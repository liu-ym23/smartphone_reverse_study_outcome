package kc;

import com.bytedance.crash.event.EnsureReportData;
import com.bytedance.crypto.cloudsync.network.CloudConfig;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f10166a = null;

    static {
        f10166a = new f();
    }

    private f() {
    }

    @JvmStatic
    public static final boolean a(String r10) {
        Intrinsics.checkNotNullParameter(r10, EnsureReportData.METHOD);
        if (Intrinsics.areEqual(r10, "GET") == false) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r10, "HEAD") == true) goto L7;
        return true;
    }

    @JvmStatic
    public static final boolean d(String r10) {
        Intrinsics.checkNotNullParameter(r10, EnsureReportData.METHOD);
        if (Intrinsics.areEqual(r10, CloudConfig.REQUEST_TYPE_POST) == false) goto L5;
    L14:
        return true;
    L5:
        if (Intrinsics.areEqual(r10, "PUT") == true) goto L14;
        if (Intrinsics.areEqual(r10, "PATCH") == true) goto L14;
        if (Intrinsics.areEqual(r10, "PROPPATCH") == true) goto L14;
        if (Intrinsics.areEqual(r10, "REPORT") == true) goto L14;
        return false;
    }

    public final boolean b(String r10) {
        Intrinsics.checkNotNullParameter(r10, EnsureReportData.METHOD);
        return !Intrinsics.areEqual(r10, "PROPFIND");
    }

    public final boolean c(String r10) {
        Intrinsics.checkNotNullParameter(r10, EnsureReportData.METHOD);
        return Intrinsics.areEqual(r10, "PROPFIND");
    }
}
