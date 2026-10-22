package com.bytedance.android.live.broadcastgame.opengame.openapi;

import android.net.Uri;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.utils.UIThreadUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b0 extends BaseOpenMethod<b> {

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/openapi/b0$b;", "", "", LiveSlardarConstants.EXTRA_KEY_URL, "Ljava/lang/String;", "a", "()Ljava/lang/String;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName(LiveSlardarConstants.EXTRA_KEY_URL)
        private final String url;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof b) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.url, ((b) r2).url) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            String r0 = this.url;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "Params(url=" + this.url + ")";
        }

        public final String a() {
            return this.url;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ b0 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ HashMap c;

        public c(b0 r1, String r2, HashMap r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            x7a.g r0 = x7a.g.d;
            String r1 = this.b;
            if (r1 != null) goto L5;
            return;
        L5:
            r0.c(r1, this.c);
            if (this.c.containsKey("ERROR_CODE") == true) goto L8;
        L14:
            this.a.r(null);
            return;
        L8:
            if ((this.c.get("ERROR_CODE") instanceof Integer) == false) goto L14;
            b0 r2 = this.a;
            Object r3 = this.c.get("ERROR_CODE");
            if (r3 == null) goto L13;
            BaseOpenMethod.p(r2, ((Integer) r3).intValue(), OpenApiErrorInfo.INCORRECT_PARAMS.getErrorMsg(), null, 12);
            return;
        L13:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
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
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "navigateTo";
    }

    public b0(PluginContext r2, Queue<Long> r3) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        super(r2, r3);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(b r19, CallContext r21) {
        Intrinsics.checkNotNullParameter(r19, "params");
        Intrinsics.checkNotNullParameter(r21, "context");
        HashMap r1 = new HashMap();
        Uri r2 = UriProtector.parse(r19.a());
        String r3 = r2.getQuery();
        String r4 = r2.getPath();
        if (r4 != null) goto L5;
    L14:
        String r5 = r2.getPath();
    L15:
        if (r5 != null) goto L17;
    L18:
        n(OpenApiErrorInfo.INCORRECT_PARAMS, null);
    L19:
        if (r3 != null) goto L21;
    L31:
        UIThreadUtils.runOnUiThread(new c(this, r5, r1));
        return;
    L21:
        if (r3.length() <= 0) goto L23;
        boolean r6 = true;
    L24:
        if (r6 == false) goto L31;
        Iterator r7 = StringsKt.split$default(r3, new String[]{"&"}, false, 0, 6, null).iterator();
    L27:
        if (r7.hasNext() == false) goto L31;
        List r8 = StringsKt.split$default((String) r7.next(), new String[]{"="}, false, 0, 6, null);
        if (r8.size() != 2) goto L27;
        r1.put(ListProtector.get(r8, 0), ListProtector.get(r8, 1));
        goto L27
    L23:
        r6 = false;
        goto L24
    L17:
        if (Intrinsics.areEqual(r5, "") == false) goto L19;
    L5:
        if (StringsKt.endsWith$default(r4, "index", false, 2, null) != true) goto L14;
        String r9 = r2.getPath();
        if (r9 == null) goto L13;
        String r12 = r2.getPath();
        if (r12 == null) goto L11;
        int r11 = StringsKt.lastIndexOf$default(r12, "/", 0, false, 6, null);
    L12:
        r5 = r9.substring(0, r11);
        goto L15
    L11:
        r11 = 0;
        goto L12
    L13:
        r5 = null;
        goto L15
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(b r1, CallContext r2) {
        call2(r1, r2);
    }
}
