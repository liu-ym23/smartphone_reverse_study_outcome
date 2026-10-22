package lvb;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kub.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final String d(String r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        return "";
    L13:
        if (r3.length() > 8) goto L17;
        return "***";
    L17:
        return r3.substring(0, 4) + '_' + r3.substring(r3.length() - 6);
    L5:
        if (r3.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    @JvmStatic
    public static final String f(String r7) {
        if (r7 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return "";
    L12:
        int r2 = StringsKt.indexOf$default(r7, '?', 0, false, 6, null);
        if (r2 < 0) goto L16;
        r7 = r7.substring(0, r2);
    L16:
        if (r7.length() > 32) goto L19;
        return r7;
    L19:
        return StringsKt.take(r7, 16) + "..." + StringsKt.takeLast(r7, 8);
    L5:
        if (StringsKt.isBlank(r7) == true) goto L8;
        r1 = false;
        goto L9
    }

    @JvmStatic
    public static final void g(String r3) {
        Intrinsics.checkNotNullParameter("AudioRecordExtSource", "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        if (Intrinsics.areEqual(OfficeSDKManager.isDebug(), Boolean.TRUE) == false) goto L7;
        e r0 = (e) OfficeSDKManager.getHostGlobalService(e.class);
        if (r0 == null) goto L7;
        r0.v("minutes_AudioRecordExtSource", r3);
    L7:
        Log.v("minutes_AudioRecordExtSource", r3);
    }

    @JvmStatic
    public static final void a(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        if (Intrinsics.areEqual(OfficeSDKManager.isDebug(), Boolean.TRUE) == false) goto L8;
        Log.d("minutes_" + r3, r4);
        e r0 = (e) OfficeSDKManager.getHostGlobalService(e.class);
        if (r0 == null) goto L9;
        r0.d("minutes_" + r3, r4);
        return;
    L9:
        return;
    }

    @JvmStatic
    public static final void b(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "tag");
        Intrinsics.checkNotNullParameter(r5, "msg");
        Log.e("minutes_" + r4, r5, null, false);
        if (Intrinsics.areEqual(OfficeSDKManager.isDebug(), Boolean.TRUE) == false) goto L8;
        e r0 = (e) OfficeSDKManager.getHostGlobalService(e.class);
        if (r0 == null) goto L9;
        r0.e("minutes_" + r4, r5);
        return;
    L9:
        return;
    }

    @JvmStatic
    public static final void c(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        Log.e("minutes_" + r2, r3, null, true);
    }

    @JvmStatic
    public static final void e(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        Log.i("minutes_" + r3, r4);
        if (Intrinsics.areEqual(OfficeSDKManager.isDebug(), Boolean.TRUE) == false) goto L8;
        e r0 = (e) OfficeSDKManager.getHostGlobalService(e.class);
        if (r0 == null) goto L9;
        r0.i("minutes_" + r3, r4);
        return;
    L9:
        return;
    }

    @JvmStatic
    public static final void h(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        Log.w("minutes_" + r3, r4);
        if (Intrinsics.areEqual(OfficeSDKManager.isDebug(), Boolean.TRUE) == false) goto L8;
        e r0 = (e) OfficeSDKManager.getHostGlobalService(e.class);
        if (r0 == null) goto L9;
        r0.w("minutes_" + r3, r4);
        return;
    L9:
        return;
    }
}
