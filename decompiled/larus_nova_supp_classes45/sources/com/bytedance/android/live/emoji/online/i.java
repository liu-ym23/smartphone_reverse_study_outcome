package com.bytedance.android.live.emoji.online;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.emoji.online.model.OnlineSmallEmojiRes;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements SingleObserver<Response<w90.a>> {
    public final /* synthetic */ OnlineSmallEmojiResManager a;

    public final void onError(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
    }

    public i(OnlineSmallEmojiResManager r1) {
        this.a = r1;
    }

    public final void onSuccess(Object r8) {
        Response r9 = (Response) r8;
        Intrinsics.checkNotNullParameter(r9, "response");
        w90.a r0 = (w90.a) ((BaseResponse) r9).data;
        boolean r3 = true;
        if (r0 != null) goto L5;
    L7:
        ALogger.d("OnlineEmojiResManager", "refreshEmoji success: " + r9);
        if (r0 == null) goto L33;
        OnlineSmallEmojiRes r1 = r0.getResources();
        if (r1 == null) goto L33;
        if (TextUtils.isEmpty(r1.getMd5()) == false) goto L14;
    L17:
        boolean r5 = true;
    L18:
        if (r5 == false) goto L21;
        r1 = null;
    L21:
        if (r1 == null) goto L33;
        if (Intrinsics.areEqual(r1.getMd5(), com.bytedance.android.live.emoji.utils.a.a().b.getString("key_small_emoji_md5", "")) == false) goto L32;
        String r11 = c.a;
        String r12 = r1.getMd5();
        Intrinsics.checkNotNull(r12);
        Intrinsics.checkNotNullParameter(r12, "md5");
        PolarisFileWrapper r2 = new PolarisFileWrapper(c.b(r12));
        if (r2.exists() == true) goto L27;
    L30:
        if (r3 == true) goto L32;
        r1.getMd5();
        this.a.a(r1);
        return;
    L27:
        if (r2.isDirectory() == false) goto L30;
        r3 = false;
    L32:
        OnlineSmallEmojiResManager r13 = this.a;
        r13.getClass();
        e r4 = new e(r13, r1);
        DownloadTask r14 = Downloader.with(jc1.a.b()).url(r1.getResourceUrl()).retryCount(3);
        String r6 = c.a;
        DownloadTask r15 = r14.savePath(c.a + "tmp/");
        String r7 = r1.getMd5();
        Intrinsics.checkNotNull(r7);
        Intrinsics.checkNotNullParameter(r7, "md5");
        r15.name(r7 + ".zip").subThreadListener(r4).monitorScene("emoji_online_small").download();
        return;
    L14:
        if (TextUtils.isEmpty(r1.getResourceUrl()) == true) goto L17;
        r5 = false;
    L33:
        ALogger.d("OnlineEmojiResManager", "  refreshEmoji fail: " + r9);
        return;
    L5:
        if (r0.a() != 1) goto L7;
        com.bytedance.android.live.emoji.utils.a.a().b.edit().putString("key_small_emoji_md5", "").commit();
        ALogger.d("OnlineEmojiResManager", "  refreshEmoji fallback");
    }
}
