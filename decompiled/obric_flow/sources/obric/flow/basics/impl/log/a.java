package obric.flow.basics.impl.log;

import android.util.Log;
import com.obric.android.agilelogger.ALog;
import com.obric.olog.OLog;
import ju.b;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20432a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f20433b = null;

    static {
        f20432a = new a();
        f20433b = LazyKt.lazy(LogImpl$isRelease$2.INSTANCE);
    }

    public static boolean a() {
        return ((Boolean) f20433b.getValue()).booleanValue();
    }

    @Override // ju.b
    public final void d(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        if (OLog.d == true) goto L6;
        OLog.e();
    L6:
        if (OLog.f11909b == false) goto L11;
        if (OLog.b(3) == false) goto L11;
        OLog.f(3, r5, r10);
    L11:
        if (OLog.f11908a == false) goto L14;
        OLog.a(3, r5, r10);
    L14:
        if (a() == false) goto L17;
        Log.d(r5, r10);
        return;
    }

    @Override // ju.b
    public final void e(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        if (OLog.d == true) goto L6;
        OLog.e();
    L6:
        if (OLog.f11909b == false) goto L11;
        if (OLog.b(6) == false) goto L11;
        Log.e(r5, r10);
    L11:
        if (OLog.f11908a == false) goto L14;
        ALog.e(r5, r10);
    L14:
        if (a() == false) goto L17;
        Log.e(r5, r10);
        return;
    }

    @Override // ju.b
    public final void i(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        if (OLog.d == true) goto L6;
        OLog.e();
    L6:
        if (OLog.f11909b == false) goto L11;
        if (OLog.b(4) == false) goto L11;
        OLog.f(4, r5, r10);
    L11:
        if (OLog.f11908a == false) goto L14;
        OLog.a(4, r5, r10);
    L14:
        if (a() == false) goto L17;
        Log.i(r5, r10);
        return;
    }

    @Override // ju.b
    public final void v(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        if (OLog.d == true) goto L6;
        OLog.e();
    L6:
        if (OLog.f11909b == false) goto L11;
        if (OLog.b(2) == false) goto L11;
        OLog.f(2, r5, r10);
    L11:
        if (OLog.f11908a == false) goto L14;
        OLog.a(2, r5, r10);
    L14:
        if (a() == false) goto L17;
        Log.v(r5, r10);
        return;
    }

    @Override // ju.b
    public final void w(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        OLog.h(r5, r10);
        if (a() == false) goto L6;
        Log.w(r5, r10);
        return;
    }

    @Override // ju.b
    public final void w(String r5, String r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        Intrinsics.checkNotNullParameter(r11, "t");
        OLog.h(r5, r10);
        if (a() == false) goto L6;
        Log.w(r5, r10, r11);
        return;
    }

    @Override // ju.b
    public final void e(String r5, String r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        Intrinsics.checkNotNullParameter(r11, "t");
        if (OLog.d == true) goto L6;
        OLog.e();
    L6:
        if (OLog.f11909b == false) goto L11;
        if (OLog.b(6) == false) goto L11;
        Log.e(r5, r10, r11);
    L11:
        if (OLog.f11908a == false) goto L14;
        ALog.e(r5, r10, r11);
    L14:
        if (a() == false) goto L17;
        Log.e(r5, r10, r11);
        return;
    }
}
