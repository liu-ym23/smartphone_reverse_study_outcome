package h30;

import android.app.Activity;
import android.os.Build;
import com.bytedance.android.live.browser.jsbridge.newmethods.CheckPermissionResultModel;
import com.bytedance.android.live.browser.jsbridge.newmethods.RequestPermissionResultModel;
import com.bytedance.android.live.browser.jsbridge.newmethods.db;
import com.bytedance.android.live.browser.jsbridge.newmethods.s;
import com.bytedance.android.live.browser.jsbridge.newmethods.x1;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f {
    public static final Map<String, List<String>> a = null;
    public static final String b = null;
    public static final String c = null;
    public static final String d = null;

    @XBridgeMethod(biz = "webcast", name = "checkPermission")
    public static final class a extends com.bytedance.android.live.browser.jsbridge.newmethods.a<x1, CheckPermissionResultModel> {
        public a() {
        }

        public static CheckPermissionResultModel j(String r2) {
            CheckPermissionResultModel r0 = new CheckPermissionResultModel();
            r0.a(CheckPermissionResultModel.Code.Success);
            r0.c(r2);
            r0.b("SUCCESS");
            return r0;
        }

        public final void invoke(Object r5, CallContext r6) {
            x1 r7 = (x1) r5;
            Intrinsics.checkNotNullParameter(r7, "params");
            Intrinsics.checkNotNullParameter(r6, "context");
            Activity r8 = ContextUtil.contextToActivity(r6.getContext());
            if (r8 != null) goto L5;
            finishWithFailure();
            return;
        L5:
            String r0 = r7.a();
            if (Intrinsics.areEqual(r0, "notification") == false) goto L11;
            int r9 = c30.c.a;
            if (c30.c.b(r8) == false) goto L10;
            finishWithResult(j(f.b));
            return;
        L10:
            finishWithResult(j(f.c));
            return;
        L11:
            Map<String, List<String>> r1 = f.a;
            if (CollectionsKt.contains(r1.keySet(), r0) == false) goto L39;
            e r2 = new e(this);
            List<String> r11 = r1.get(r7.a());
            Intrinsics.checkNotNull(r11);
            Object[] r12 = r11.toArray(new String[0]);
            if (r12 == null) goto L37;
            String[] r13 = (String[]) r12;
            int r3 = Build.VERSION.SDK_INT;
            if (r3 < 23) goto L27;
            Map<String, p60.c> r4 = p60.e.b;
            if (p60.e.a.a.b() == true) goto L27;
            if (m60.b.a(r8, r13) == false) goto L23;
            r2.onPermissionGrant(r13);
            return;
        L23:
            if (m60.c.e(r8, r13) == false) goto L25;
            r2.a(r13);
            return;
        L25:
            r2.onPermissionDenied(r13);
            return;
        L27:
            if (n60.e.a.a.b(r8, r13) == false) goto L29;
            r2.onPermissionGrant(r13);
            return;
        L29:
            if (r3 >= 23) goto L32;
            r2.onPermissionDenied(r13);
            return;
        L32:
            if (m60.c.e(r8, r13) == false) goto L34;
            r2.a(r13);
            return;
        L34:
            r2.onPermissionDenied(r13);
            return;
        L37:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        L39:
            throw new IllegalArgumentException("Unsupported permission operation");
        }
    }

    @XBridgeMethod(biz = "webcast", name = "requestPermission")
    public static final class b extends s<db, RequestPermissionResultModel> {
        public b() {
        }

        public static RequestPermissionResultModel j(String r2) {
            RequestPermissionResultModel r0 = new RequestPermissionResultModel();
            r0.a(RequestPermissionResultModel.Code.Success);
            r0.b("SUCCESS");
            r0.c(r2);
            return r0;
        }

        public final void invoke(Object r4, CallContext r5) {
            db r6 = (db) r4;
            Intrinsics.checkNotNullParameter(r6, "params");
            Intrinsics.checkNotNullParameter(r5, "context");
            Activity r7 = ContextUtil.contextToActivity(r5.getContext());
            if (r7 != null) goto L5;
            finishWithFailure();
            return;
        L5:
            String r0 = r6.a();
            if (Intrinsics.areEqual(r0, "notification") == false) goto L11;
            int r8 = c30.c.a;
            if (c30.c.b(r7) == false) goto L10;
            finishWithResult(j(f.b));
            return;
        L10:
            d.a(r7, new g(this), new String[]{"notification"});
            return;
        L11:
            Map<String, List<String>> r1 = f.a;
            if (CollectionsKt.contains(r1.keySet(), r0) == false) goto L20;
            h r2 = new h(this);
            List<String> r9 = r1.get(r6.a());
            Intrinsics.checkNotNull(r9);
            Object[] r11 = r9.toArray(new String[0]);
            if (r11 == null) goto L18;
            d.b(r7, r2, (String[]) r11);
            return;
        L18:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        L20:
            throw new IllegalArgumentException("Unsupported permission operation");
        }
    }

    static {
        Pair[] r0 = new Pair[8];
        r0[0] = TuplesKt.to(NewBroadcastMonitor.STAGE.CAMERA, CollectionsKt.listOf("android.permission.CAMERA"));
        r0[1] = TuplesKt.to("microphone", CollectionsKt.listOf("android.permission.RECORD_AUDIO"));
        if (Build.VERSION.SDK_INT >= 33) goto L5;
    L7:
        List r1 = CollectionsKt.listOf("android.permission.READ_EXTERNAL_STORAGE");
    L8:
        r0[2] = TuplesKt.to("photoAlbum", r1);
        r0[3] = TuplesKt.to("vibrate", CollectionsKt.listOf("android.permission.VIBRATE"));
        r0[4] = TuplesKt.to("location", CollectionsKt.listOf(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}));
        r0[5] = TuplesKt.to("write_calendar", CollectionsKt.listOf("android.permission.WRITE_CALENDAR"));
        r0[6] = TuplesKt.to("read_calendar", CollectionsKt.listOf("android.permission.READ_CALENDAR"));
        r0[7] = TuplesKt.to("calendar", CollectionsKt.listOf(new String[]{"android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR"}));
        a = MapsKt.mapOf(r0);
        b = "permitted";
        c = "undetermined";
        d = "denied";
        return;
    L5:
        if (jc1.a.b().getApplicationInfo().targetSdkVersion < 33) goto L7;
        r1 = CollectionsKt.listOf(new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO"});
        goto L8
    }
}
