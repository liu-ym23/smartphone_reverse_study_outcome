package com.bytedance.android.live.ktv.common.music.download;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static String a(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "key");
            Intrinsics.checkNotNullParameter(r2, "exportDiar");
            return r2 + r1 + ".mp4";
        }
    }

    public static final class b<T> implements SingleOnSubscribe {
        public final /* synthetic */ DownloadTask a;

        public b(DownloadTask r1) {
            this.a = r1;
        }

        public final void subscribe(SingleEmitter<Object> r1) {
            this.a.download();
        }
    }

    public static final class c extends AbsDownloadListener {
        public final /* synthetic */ s a;
        public final /* synthetic */ Function1 b;
        public final /* synthetic */ Function1 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;

        public final void onProgress(DownloadInfo r2) {
            if (r2 == null) goto L5;
            this.b.invoke(Integer.valueOf(r2.getDownloadProcess()));
            return;
        }

        public final void onSuccessed(DownloadInfo r2) {
            this.c.invoke(this.d);
        }

        public final void onFailed(DownloadInfo r8, BaseException r9) {
            int r11 = this.e;
            if (r11 <= 0) goto L5;
            this.a.a(this.f, this.g, this.h, r11 - 1, this.b, this.c);
            return;
        L5:
            this.c.invoke(null);
        }

        public c(s r1, Function1 r2, Function1 r3, String r4, int r5, String r6, String r7, String r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }
    }

    static {
    }

    public s() {
    }

    public final void a(String r12, String r13, String r14, int r15, Function1<? super Integer, Unit> r16, Function1<? super String, Unit> r17) {
        Intrinsics.checkNotNullParameter(r13, "key");
        Intrinsics.checkNotNullParameter(r14, "exportDiar");
        Intrinsics.checkNotNullParameter(r16, "progressCb");
        Intrinsics.checkNotNullParameter(r17, "callback");
        if (TextUtils.isEmpty(r12) == false) goto L6;
        com.bytedance.android.live.ktv.common.util.g.e("prefech url is empty");
        return;
    L6:
        PolarisFileWrapper r0 = new PolarisFileWrapper(r14);
        if (r0.exists() == true) goto L9;
        r0.mkdirs();
    L9:
        String r4 = r14 + r13 + ".mp4";
        PolarisFileWrapper r1 = new PolarisFileWrapper(r4);
        if (r1.exists() == true) goto L16;
    L14:
        Single.create(new b(Downloader.with(s1.getContext()).url(r12).name(r13 + ".mp4").savePath(r14).subThreadListener(new c(this, r16, r17, r4, r15, r12, r13, r14)))).subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.livesdk.user.h());
        return;
    L16:
        r1.deleteOnExit();     // Catch: Exception -> L13
    L13:
        com.bytedance.android.live.ktv.common.util.g.e("delete fail");
        goto L14
    }
}
