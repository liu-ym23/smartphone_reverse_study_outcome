package com.ss.android.lark.officesdk.minutes.service.fileupload;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmMinutesFileUploadSessionManager$buildUploadCallback$1 implements fub.b {
    public final /* synthetic */ Function0<String> a;
    public final /* synthetic */ MmMinutesFileUploadSessionManager b;
    public final /* synthetic */ String c;

    @Override // fub.b
    public final void a(fub.d r9) {
        Intrinsics.checkNotNullParameter(r9, "progress");
        String r4 = (String) this.a.invoke();
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        lvb.a.a(this.b.d, "uploadCallback.onProgress: taskId=" + this.c + ", uploadTaskId=" + r4 + ", uploaded=" + r9.a + ", total=" + r9.b + ", percent=" + r9.c);
        MmMinutesFileUploadSessionManager r1 = this.b;
        r1.r("uploadCallback.onProgress", new MmMinutesFileUploadSessionManager$buildUploadCallback$1$onProgress$1(r1, this.c, r4, r9, null));
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // fub.b
    public final void b(fub.e r9) {
        Intrinsics.checkNotNullParameter(r9, "result");
        String r4 = (String) this.a.invoke();
        boolean r1 = false;
        if (r4.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        String r2 = this.b.d;
        StringBuilder r3 = new StringBuilder("uploadCallback.onSuccess: taskId=");
        r3.append(this.c);
        r3.append(", uploadTaskId=");
        r3.append(r4);
        r3.append(", uploadedFileTokenEmpty=");
        if (r9.a.length() != 0) goto L11;
        r1 = true;
    L11:
        r3.append(r1);
        lvb.a.e(r2, r3.toString());
        MmMinutesFileUploadSessionManager r5 = this.b;
        r5.r("uploadCallback.onSuccess", new MmMinutesFileUploadSessionManager$buildUploadCallback$1$onSuccess$1(r5, this.c, r4, r9, null));
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // fub.b
    public final void onError(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, "message");
        String r4 = (String) this.a.invoke();
        lvb.a.a(this.b.d, "uploadCallback.onError: taskId=" + this.c + ", uploadTaskId=" + r4 + ", code=" + r10 + ", message=" + r11);
        MmMinutesFileUploadSessionManager r0 = this.b;
        r0.r("uploadCallback.onError", new MmMinutesFileUploadSessionManager$buildUploadCallback$1$onError$1(r0, this.c, r4, r10, r11, null));
    }

    public MmMinutesFileUploadSessionManager$buildUploadCallback$1(Function0<String> r1, MmMinutesFileUploadSessionManager r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
