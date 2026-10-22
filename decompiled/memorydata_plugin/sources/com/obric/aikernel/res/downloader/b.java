package com.obric.aikernel.res.downloader;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"DOWNLOAD_STATE_CALLER_QUIT", "", "DOWNLOAD_STATE_DISALLOW_ASSISTANT_AUTO_UPDATE", "DOWNLOAD_STATE_DISALLOW_BACKGROUND", "DOWNLOAD_STATE_DISALLOW_NETWORK", "DOWNLOAD_STATE_IDLE", "DOWNLOAD_STATE_NEED_INTERNET", "DOWNLOAD_STATE_NEED_WIFI", "DOWNLOAD_STATE_NORMAL", "evaluateDownloadConstraint", "Lcom/obric/aikernel/res/downloader/DownloadConstraintGate;", "snapshot", "Lcom/obric/aikernel/res/downloader/DownloadConstraintSnapshot;", "isPendingRetryTimerRecoverableDownloadConstraintState", "", "state", "isResumableDownloadConstraintState", "resource_manager_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class b {
    public static final a a(c r5) {
        Intrinsics.checkNotNullParameter(r5, "snapshot");
        if (r5.a() == false) goto L36;
        boolean r1 = true;
        if (r5.b() == true) goto L9;
        return new a(1, "caller group canceled");
    L9:
        if (r5.g().contains("model") == false) goto L14;
        if (r5.h() == false) goto L14;
        return new a(7, "assistant auto-update gate disallowed");
    L14:
        if (r5.c() == false) goto L27;
        if (r5.d() == false) goto L27;
        if (r5.e() == true) goto L27;
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r5.f(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r6.length() == 0) goto L23;
        r1 = false;
    L23:
        if (r1 == false) goto L39;
        r6 = "background update disallowed";
    L39:
        return new a(2, (String) ZeusTransformUtils.preCheckCast(r6, String.class, "com.obric.memorydata.plugin"));
    L27:
        if (r5.i() == true) goto L30;
        return new a(5, "no valid internet");
    L30:
        if (r5.j() == false) goto L35;
        if (r5.k() == true) goto L35;
        return new a(3, "no unmetered network");
    L35:
        return new a(0, "ready");
    L36:
        return new a(4, "allowNetworkRequest=false");
    }

    public static final boolean a(int r1) {
        if (r1 != 2) goto L5;
    L13:
        return true;
    L5:
        if (r1 == 3) goto L13;
        if (r1 == 4) goto L13;
        if (r1 == 5) goto L13;
        if (r1 == 7) goto L13;
        return false;
    }

    public static final boolean b(int r1) {
        if (r1 != 3) goto L5;
    L7:
        return true;
    L5:
        if (r1 == 5) goto L7;
        return false;
    }
}
