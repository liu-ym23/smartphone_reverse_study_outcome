package com.larus.bmhome.chat.component.bottom.multimodal.preprocess;

import com.larus.platform.audit.BehaviorAuditApi;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class SendResourcePreprocessManager$a extends AbsDownloadListener {
    public final /* synthetic */ AbsDownloadListener a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public final void onCanceled(DownloadInfo r2) {
        AbsDownloadListener r0 = this.a;
        if (r0 == null) goto L6;
        r0.onCanceled(r2);
        return;
    }

    public final void onPause(DownloadInfo r2) {
        AbsDownloadListener r0 = this.a;
        if (r0 == null) goto L6;
        r0.onPause(r2);
        return;
    }

    public final void onProgress(DownloadInfo r2) {
        AbsDownloadListener r0 = this.a;
        if (r0 == null) goto L6;
        r0.onProgress(r2);
        return;
    }

    public final void onStart(DownloadInfo r2) {
        AbsDownloadListener r0 = this.a;
        if (r0 == null) goto L6;
        r0.onStart(r2);
        return;
    }

    public final void onSuccessed(DownloadInfo r11) {
        AbsDownloadListener r0 = this.a;
        if (r0 == null) goto L5;
        r0.onSuccessed(r11);
    L5:
        String r3 = this.b;
        if (r11 == null) goto L8;
        Long r4 = Long.valueOf(r11.getTotalBytes());
    L9:
        if (r11 == null) goto L11;
        String r5 = r11.getMd5();
    L12:
        String r12 = StringsKt.substringAfterLast(this.b, '.', "");
        if (r12.length() <= 0) goto L15;
        boolean r1 = true;
    L16:
        if (r1 == false) goto L18;
        String r6 = r12;
    L19:
        BehaviorAuditApi.c(new com.larus.platform.audit.b(null, r3, r4, r5, r6, 1), MapsKt.mapOf(new Pair[]{TuplesKt.to("scene", "chat_file"), TuplesKt.to("url", this.c)}));
        return;
    L18:
        r6 = null;
        goto L19
    L15:
        r1 = false;
        goto L16
    L11:
        r5 = null;
        goto L12
    L8:
        r4 = null;
        goto L9
    }

    public final void onFailed(DownloadInfo r12, BaseException r13) {
        AbsDownloadListener r0 = this.a;
        if (r0 == null) goto L5;
        r0.onFailed(r12, r13);
    L5:
        String r3 = this.b;
        if (r12 == null) goto L8;
        Long r4 = Long.valueOf(r12.getTotalBytes());
    L9:
        if (r12 == null) goto L11;
        String r5 = r12.getMd5();
    L12:
        String r8 = "";
        String r14 = StringsKt.substringAfterLast(this.b, '.', "");
        if (r14.length() <= 0) goto L15;
        boolean r1 = true;
    L16:
        if (r1 == false) goto L18;
        String r6 = r14;
    L19:
        com.larus.platform.audit.b r15 = new com.larus.platform.audit.b(null, r3, r4, r5, r6, 1);
        Pair[] r2 = new Pair[3];
        r2[0] = TuplesKt.to("scene", "chat_file");
        r2[1] = TuplesKt.to("url", this.c);
        if (r13 == null) goto L25;
        String r16 = r13.getMessage();
        if (r16 == null) goto L25;
        r8 = r16;
    L25:
        r2[2] = TuplesKt.to("error_msg", r8);
        BehaviorAuditApi.c(r15, MapsKt.mapOf(r2));
        return;
    L18:
        r6 = null;
        goto L19
    L15:
        r1 = false;
        goto L16
    L11:
        r5 = null;
        goto L12
    L8:
        r4 = null;
        goto L9
    }

    public final void onRetry(DownloadInfo r2, BaseException r3) {
        AbsDownloadListener r0 = this.a;
        if (r0 == null) goto L6;
        r0.onRetry(r2, r3);
        return;
    }

    public SendResourcePreprocessManager$a(AbsDownloadListener r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
