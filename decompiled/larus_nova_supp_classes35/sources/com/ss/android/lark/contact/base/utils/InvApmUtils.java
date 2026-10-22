package com.ss.android.lark.contact.base.utils;

import android.os.SystemClock;
import com.bytedance.apm.ApmAgent;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.ErrorLevel;
import com.ss.android.lark.appreciablelib.ErrorParams;
import com.ss.android.lark.appreciablelib.ErrorType;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.contact.base.service.a0;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class InvApmUtils {
    public static final ConcurrentHashMap<String, Long> a = null;
    public static final HashMap<String, a> b = null;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B9\b\u0007\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/contact/base/utils/InvApmUtils$GetDataCallback;", "T", "Lcom/larksuite/framework/callback/IGetDataCallback;", "delegate", IPortraitService.NAME, BuildConfig.FLAVOR, "category", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "<init>", "(Lcom/larksuite/framework/callback/IGetDataCallback;Ljava/lang/String;Ljava/util/Map;)V", "onSuccess", BuildConfig.FLAVOR, "t", "(Ljava/lang/Object;)V", "onError", "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "contact-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class GetDataCallback<T> implements IGetDataCallback<T> {
        private final Map<String, Object> category;
        private final IGetDataCallback<T> delegate;
        private final String name;

        public GetDataCallback(IGetDataCallback<T> r8, String r9) {
            Intrinsics.checkNotNullParameter(r9, IPortraitService.NAME);
            this(r8, r9, null, 4, null);
        }

        public void onError(ErrorResult r3) {
            Intrinsics.checkNotNullParameter(r3, "err");
            IGetDataCallback<T> r0 = this.delegate;
            if (r0 == null) goto L5;
            r0.onError(r3);
        L5:
            InvApmUtils.c(this.name, this.category, r3);
        }

        public void onSuccess(T r2) {
            IGetDataCallback<T> r0 = this.delegate;
            if (r0 == null) goto L5;
            r0.onSuccess(r2);
        L5:
            InvApmUtils.b(this.name, this.category);
        }

        public /* bridge */ /* synthetic */ void onError(Object r1) {
            onError((ErrorResult) r1);
        }

        public GetDataCallback(IGetDataCallback<T> r2, String r3, Map<String, ? extends Object> r4) {
            Intrinsics.checkNotNullParameter(r3, IPortraitService.NAME);
            this.delegate = r2;
            this.name = r3;
            this.category = r4;
            InvApmUtils.g(r3);
        }

        public /* synthetic */ GetDataCallback(IGetDataCallback r1, String r2, Map r3, int r4, DefaultConstructorMarker r5) {
            if ((r4 & 4) == 0) goto L5;
            r3 = null;
        L5:
            this(r1, r2, r3);
        }
    }

    public static final class a {
        public final a0.a a;
        public final Event b;
        public final boolean c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "AppreciableBean(appreciable=" + this.a + ", event=" + this.b + ", isNeedNet=" + this.c + ')';
        }

        public a(a0.a r2, Event r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "appreciable");
            Intrinsics.checkNotNullParameter(r3, "event");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    @JvmStatic
    public static final void e(String r1, Map r2) {
        Intrinsics.checkNotNullParameter(r1, "serviceName");
        f(r1, r2, 8);
    }

    static {
        a = new ConcurrentHashMap();
        HashMap<String, a> r0 = new HashMap();
        b = r0;
        a0.a r2 = a0.e;
        r0.put("ug_fetch_dy_resource", new a(r2, Event.ug_fetch_dy_resource, true));
        r0.put("ug_dy_resource_generate_img", new a(r2, Event.ug_dy_resource_generate_img, false));
        a0.a r3 = a0.d;
        r0.put("contact_opt_local_fetch_timing_ms", new a(r3, Event.contact_opt_local_fetch, false));
        Event r4 = Event.contact_opt_contact_list_fetch;
        r0.put("contact_opt_contact_list_timing_ms", new a(r3, r4, true));
        r0.put("contact_opt_contact_list_fetch_fail", new a(r3, r4, true));
        Event r5 = Event.contact_opt_contact_applications_fetch;
        r0.put("contact_opt_contact_applications_fetch_timing_ms", new a(r3, r5, true));
        r0.put("contact_opt_contact_applications_fetch_fail", new a(r3, r5, true));
        a0.a r6 = a0.c;
        r0.put("ug_invite_member_orientation_invite", new a(r6, Event.member_orientation_invite, true));
        r0.put("ug_invite_member_nondirectional_get_invite_info", new a(r6, Event.member_nondirection_get_invite_info, true));
        r0.put("ug_invite_member_nondirectional_load_qrcode", new a(r6, Event.member_nondirection_load_qrcode, false));
        r0.put("ug_invite_member_nondirectional_get_save_or_share_qrcode", new a(r6, Event.member_nondirection_get_save_or_share_qr, true));
        r0.put("ug_invite_external_nondirectional_get_invite_info", new a(r6, Event.external_nondirection_get_invite_info, true));
        r0.put("ug_invite_external_nondirectional_load_qrcode", new a(r6, Event.external_nondirection_load_qrcode, false));
        r0.put("ug_invite_external_nondirectional_get_save_or_share_qrcode", new a(r6, Event.external_nondirection_get_save_or_share_qr, true));
        r0.put("ug_invite_external_orientation_search", new a(r6, Event.external_orientation_search, true));
        r0.put("ug_invite_external_orientation_invite", new a(r6, Event.external_orientation_invite, true));
        r0.put("ug_invite_parent_nondirectional_get_inactive_info", new a(r6, Event.parent_nondirection_get_inactive_info, true));
        r0.put("ug_invite_parent_nondirectional_get_invite_info", new a(r6, Event.parent_nondirection_get_invite_info, true));
        r0.put("ug_invite_parent_nondirectional_load_qrcode", new a(r6, Event.parent_nondirection_load_qrcode, false));
    }

    public static JSONObject a(Map r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        JSONObject r0 = new JSONObject();
        Iterator r4 = r3.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        Map.Entry r1 = (Map.Entry) r4.next();
        r0.put((String) r1.getKey(), r1.getValue());
        goto L7
    L9:
        return r0;
    }

    @JvmStatic
    public static final void g(String r3) {
        Intrinsics.checkNotNullParameter(r3, "serviceName");
        a.put(r3, Long.valueOf(SystemClock.elapsedRealtime()));
        a r4 = b.get(r3);
        if (r4 == null) goto L6;
        r4.a.c(r4.b, r4.c);
        return;
    }

    @JvmStatic
    public static final void b(String r2, Map r3) {
        Intrinsics.checkNotNullParameter(r2, "serviceName");
        Map r0 = MapsKt.mapOf(TuplesKt.to("succeed", Boolean.TRUE));
        if (r3 != null) goto L5;
        r3 = MapsKt.emptyMap();
    L5:
        d(r2, MapsKt.plus(r0, r3), null, null);
    }

    @JvmStatic
    public static final void c(String r4, Map<String, ? extends Object> r5, ErrorResult r6) {
        Intrinsics.checkNotNullParameter(r4, "serviceName");
        Intrinsics.checkNotNullParameter(r6, "err");
        int r1 = r6.getErrorCode();
        String r7 = r6.getDebugMsg();
        Intrinsics.checkNotNullParameter(r4, "serviceName");
        Map r0 = MapsKt.mapOf(new Pair[]{TuplesKt.to("succeed", Boolean.FALSE), TuplesKt.to("error_code", Integer.valueOf(r1))});
        if (r5 != null) goto L5;
        r5 = MapsKt.emptyMap();
    L5:
        Map r8 = MapsKt.plus(r0, r5);
        if (r7 != null) goto L8;
        Map r9 = null;
    L9:
        d(r4, r8, null, r9);
        return;
    L8:
        r9 = MapsKt.mapOf(TuplesKt.to("error_msg", r7));
        goto L9
    }

    public static /* synthetic */ void f(String r1, Map r2, int r3) {
        if ((r3 & 4) == 0) goto L5;
        r2 = null;
    L5:
        d(r1, null, r2, null);
    }

    @JvmStatic
    public static final void d(String r24, Map<String, ? extends Object> r25, Map<String, ? extends Number> r26, Map<String, ? extends Object> r27) {
        Map<String, ? extends Number> r2 = r26;
        Intrinsics.checkNotNullParameter(r24, "serviceName");
        ConcurrentHashMap<String, Long> r4 = a;
        Long r5 = r4.get(r24);
        String r6 = null;
        if (r25 == null) goto L5;
        Object r7 = r25.get("error_code");
    L7:
        if ((r7 instanceof Integer) == false) goto L9;
        Integer r8 = (Integer) r7;
    L10:
        if (r8 != null) goto L20;
        if (r5 == null) goto L30;
        long r9 = SystemClock.elapsedRealtime() - r5.longValue();
        if (r2 != null) goto L15;
        Map<String, ? extends Number> r10 = MapsKt.mapOf(TuplesKt.to(ChameleonOpenTracker.ParamKey.COST, Long.valueOf(r9)));
    L16:
        r4.remove(r24);
        a r11 = b.get(r24);
        if (r11 == null) goto L19;
        a0.a r12 = r11.a;
        Event r13 = r11.b;
        r12.getClass();
        a0.a.a(r13, r27, r2, r25);
    L19:
        r2 = r10;
        goto L30
    L15:
        MapsKt.plus(r2, new Pair(ChameleonOpenTracker.ParamKey.COST, Long.valueOf(r9)));
        r10 = r2;
    L30:
        ApmAgent.monitorEvent(r24, a(r25), a(r2), a(r27));
        return;
    L20:
        a r14 = b.get(r24);
        if (r14 == null) goto L30;
        int r15 = r8.intValue();
        if (r27 == null) goto L25;
        Object r16 = r27.get("error_msg");
    L27:
        if ((r16 instanceof String) == false) goto L29;
        r6 = (String) r16;
    L29:
        a0.a r17 = r14.a;
        Event r18 = r14.b;
        boolean r19 = r14.c;
        r17.getClass();
        Intrinsics.checkNotNullParameter(r18, "event");
        AppreciableKit.Companion.getInstance().error(new ErrorParams(Biz.UserGrowth, r17.a, r18, ErrorType.SDK, ErrorLevel.Fatal, r15, BuildConfig.FLAVOR, BuildConfig.FLAVOR, r6, Boolean.valueOf(r19), null, null, null, 7168, null));
        goto L30
    L25:
        r16 = null;
        goto L27
    L9:
        r8 = null;
        goto L10
    L5:
        r7 = null;
        goto L7
    }
}
