package com.bytedance.android.annie.card.web.secLink;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.ng.g;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import k9.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o8.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class LiveSecLinkManager {
    public static final b a = null;
    public static final List<String> b = null;
    public static final Lazy c = null;

    public static final class a implements Runnable {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public a(String r1, String r10, String r11) {
            this.a = r1;
            this.b = r10;
            this.c = r11;
        }

        public final void a() {
            String r1 = this.a;
            String r10 = this.b;
            String r11 = this.c;
            Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L15
            int r13 = x8.a.a;     // Catch: Throwable -> L15
            x8.a.b("LiveSecLinkManager", "invalid scheme " + r1, false);     // Catch: Throwable -> L15
            j9.b r14 = ((e) Annie.getService$default(e.class, null, 2, null)).H0();     // Catch: Throwable -> L15
            JSONObject r15 = new JSONObject();     // Catch: Throwable -> L15
            if (r10 == null) goto L6;
            r15.put(com.bytedance.android.ec.core.event.a.KEY_URL, r10);     // Catch: Throwable -> L15
        L6:
            Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L15
            JSONObject r16 = new JSONObject();     // Catch: Throwable -> L15
            com.bytedance.android.annie.ng.a r17 = g.c.get(r11);     // Catch: Throwable -> L15
            if (r17 == null) goto L12;
            f r18 = r17.b;     // Catch: Throwable -> L15
            if (r18 == null) goto L12;
            String r19 = r18.a;     // Catch: Throwable -> L15
            if (r19 == null) goto L12;
        L13:
            r16.put("virtual_aid", r19);     // Catch: Throwable -> L15
            j9.b.a.a(r14, null, "ttlive_hybrid_invalid_scheme", null, r15, null, null, r16, 0, 256);     // Catch: Throwable -> L15
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
            return;
        L12:
            r19 = "host";
        L15:
            th = move-exception;
            Result.Companion r20 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
        a = new b();
        b = CollectionsKt.listOf(new String[]{"https", "http"});
        c = LazyKt.lazy(LiveSecLinkManager$secLinkMode$2.INSTANCE);
    }

    public static Integer a() {
        return (Integer) c.getValue();
    }

    @JvmStatic
    public static final boolean c() {
        return AnnieConfigSettingKeys.OPEN_HYBRID_SECLINK_CONFIG.a().booleanValue();
    }

    @JvmStatic
    public static final boolean b(String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        Intrinsics.checkNotNullParameter(r12, "bizKey");
        if (StringsKt.isBlank(r10) == true) goto L21;
        Integer r0 = a();
        if (r0 == null) goto L11;
        if (r0.intValue() == 0) goto L21;
    L11:
        if (CollectionsKt.contains(b, UriProtector.parse(r10).getScheme()) == false) goto L13;
        return false;
    L13:
        Integer r1 = a();
        if (r1 != null) goto L17;
    L20:
        return true;
    L17:
        if (r1.intValue() != 1) goto L20;
        Schedulers.computation().scheduleDirect(new a(r11, r10, r12));
        return false;
    L21:
        return false;
    }
}
