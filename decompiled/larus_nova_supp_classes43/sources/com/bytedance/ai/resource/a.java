package com.bytedance.ai.resource;

import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.bytedance.ai.resource.a$a, reason: collision with other inner class name */
    public interface InterfaceC0047a {
        void a();

        void onFailed();

        void onSuccess();
    }

    static {
    }

    public a() {
    }

    public static Object a(String r10, String r11, ContinuationImpl r12) {
        if (r10.length() != 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
    L17:
        com.bytedance.ai.utils.g.a.e("AIPackageManager", "url: " + r10 + ", path: " + r11 + " ===> The download url and path are empty");
        return Boxing.boxBoolean(false);
    L9:
        if (r11.length() != 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == true) goto L17;
        SafeContinuation r13 = new SafeContinuation(IntrinsicsKt.intercepted(r12));
        com.bytedance.ai.utils.g r14 = com.bytedance.ai.utils.g.a;
        r14.d("AIPackageManager", "url: " + r10 + ", path: " + r11 + " ===> Start downloading");
        b r15 = new b(r10, r11, r13);
        DownloadTask r16 = Downloader.with(f2.k.a()).url(r10).name(StringsKt.substringAfterLast$default(r10, '/', null, 2, null)).savePath(r11).needPostProgress(true).subThreadListener(new c(r15));
        r16.download();
        r14.i("AIDownloadManager", "start download:  " + r10 + "， download id: " + r16.getDownloadId());
        Object r17 = r13.getOrThrow();
        if (r17 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        DebugProbesKt.probeCoroutineSuspended(r12);
        return r17;
    L19:
        return r17;
    L11:
        r1 = false;
        goto L12
    L5:
        r0 = false;
        goto L7
    }
}
