package com.larus.bmhome.chat.standarduikit.fileblock.download;

import android.content.Context;
import android.widget.ProgressBar;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mainbot.impl.databinding.LarusDialogFileCardDownloadBinding;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b extends AbsDownloadListener {
    public final /* synthetic */ FileCardDownloadDialogFragment a;
    public final /* synthetic */ String b;

    public final void onCanceled(DownloadInfo r3) {
        this.a.g = 0;
        if (r3 == null) goto L7;
        String r4 = r3.getTargetFilePath();
        if (r4 == null) goto L7;
        this.a.getClass();
        FileCardDownloadDialogFragment.Z90(r4);
    L7:
        FLogger.a.i("FileCardDownloadDialog", "download canceled, fileName=" + this.b);
        FileCardDownloadDialogFragment r5 = this.a;
        if (r5.i == true) goto L11;
        FileCardDownloadDialogFragment.U90(r5, null);
        return;
    }

    public final void onProgress(DownloadInfo r4) {
        FileCardDownloadDialogFragment r0 = this.a;
        if (r0.i == false) goto L5;
        return;
    L5:
        LarusDialogFileCardDownloadBinding r1 = r0.d;
        if (r1 == null) goto L14;
        ProgressBar r2 = r1.d;
        if (r2 == null) goto L15;
        int r3 = 0;
        r2.setIndeterminate(false);
        if (r4 == null) goto L12;
        r3 = RangesKt.coerceIn(r4.getDownloadProcess(), 0, 100);
    L12:
        r2.setProgress(r3);
        return;
    L15:
        return;
    }

    public final void onStart(DownloadInfo r8) {
        FileCardDownloadDialogFragment r0 = this.a;
        if (r8 == null) goto L5;
        int r2 = r8.getId();
    L6:
        r0.g = r2;
        LarusDialogFileCardDownloadBinding r1 = this.a.d;
        if (r1 == null) goto L21;
        ProgressBar r3 = r1.d;
        if (r3 == null) goto L21;
        if (r8 != null) goto L13;
    L19:
        boolean r9 = false;
    L20:
        r3.setIndeterminate(!r9);
        r3.setProgress(0);
        goto L21
    L13:
        if (r8.getTotalBytes() > 0) goto L15;
        boolean r10 = true;
    L17:
        if (Boolean.valueOf(r10).booleanValue() == true) goto L19;
        r9 = true;
        goto L20
    L15:
        r10 = false;
    L21:
        FileCardDownloadDialogFragment r11 = this.a;
        if (r11.i == true) goto L24;
        return;
    L24:
        if (r11.g <= 0) goto L32;
        Context r12 = r11.getContext();
        if (r12 == null) goto L33;
        Context r13 = r12.getApplicationContext();
        if (r13 == null) goto L34;
        Downloader.getInstance(r13).cancel(this.a.g);
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public final void onSuccessed(DownloadInfo r12) {
        FileCardDownloadDialogFragment r0 = this.a;
        if (r0.i == false) goto L9;
        if (r12 == null) goto L34;
        String r13 = r12.getTargetFilePath();
        if (r13 == null) goto L35;
        this.a.getClass();
        FileCardDownloadDialogFragment.Z90(r13);
        return;
    L35:
        return;
    L34:
        return;
    L9:
        r0.g = 0;
        if (r12 == null) goto L12;
        String r14 = r12.getTargetFilePath();
    L13:
        if (r14 != null) goto L16;
        r14 = "";
    L16:
        if (StringsKt.isBlank(r14) == false) goto L19;
        FileCardDownloadDialogFragment.U90(this.a, null);
        return;
    L19:
        FileCardDownloadDialogFragment r2 = this.a;
        r2.h = r14;
        PolarisFileWrapper r3 = new PolarisFileWrapper(r14);
        String r15 = this.b;
        Job r4 = r2.f;
        if (r4 == null) goto L24;
        boolean r5 = true;
        if (r4.isActive() != true) goto L24;
    L25:
        if (r5 == true) goto L36;
        LarusDialogFileCardDownloadBinding r6 = r2.d;
        if (r6 == null) goto L32;
        ProgressBar r7 = r6.d;
        if (r7 == null) goto L32;
        r7.setIndeterminate(false);
        r7.setProgress(100);
    L32:
        r2.f = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r2), null, null, new FileCardDownloadDialogFragment$saveDownloadedFile$2(r2, r3, r15, null), 3, null);
        return;
    L36:
        return;
    L24:
        r5 = false;
        goto L25
    L12:
        r14 = null;
        goto L13
    }

    public b(FileCardDownloadDialogFragment r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void onFailed(DownloadInfo r4, BaseException r5) {
        this.a.g = 0;
        if (r4 == null) goto L7;
        String r6 = r4.getTargetFilePath();
        if (r6 == null) goto L7;
        this.a.getClass();
        FileCardDownloadDialogFragment.Z90(r6);
    L7:
        FLogger r7 = FLogger.a;
        StringBuilder r0 = new StringBuilder("download failed, fileName=");
        r0.append(this.b);
        r0.append(", errorCode=");
        Integer r1 = null;
        if (r5 == null) goto L10;
        Integer r2 = Integer.valueOf(r5.getErrorCode());
    L11:
        r0.append(r2);
        r7.e("FileCardDownloadDialog", r0.toString(), r5);
        FileCardDownloadDialogFragment r8 = this.a;
        if (r5 == null) goto L14;
        r1 = Integer.valueOf(r5.getErrorCode());
    L14:
        FileCardDownloadDialogFragment.U90(r8, r1);
        return;
    L10:
        r2 = null;
        goto L11
    }
}
