package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IEffectDownloadProgressListener;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.android.schedulers.AndroidSchedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l0 implements IEffectDownloadProgressListener {
    public final /* synthetic */ o.c a;
    public final /* synthetic */ String b;

    public static final class a implements Runnable {
        public final /* synthetic */ l0 a;
        public final /* synthetic */ ExceptionResult b;

        public a(l0 r1, ExceptionResult r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            o.c r0 = this.a.a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            this.b.getErrorCode();     // Catch: Throwable -> L6
            r0.b();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ l0 a;

        public b(l0 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            o.c r0 = this.a.a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.onDownloadStart();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public final void onProgress(Effect r1, int r2, long r3) {
    }

    public final void onStart(Effect r2) {
        AndroidSchedulers.mainThread().scheduleDirect(new b(this));
    }

    public final void onSuccess(Object r3) {
        Effect r4 = (Effect) r3;
        Intrinsics.checkNotNullParameter(r4, "response");
        AndroidSchedulers.mainThread().scheduleDirect(new k0(this, r4));
    }

    public final void onFail(Effect r2, ExceptionResult r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        AndroidSchedulers.mainThread().scheduleDirect(new a(this, r3));
    }

    public l0(o.c r1, String r2, Sticker r3) {
        this.a = r1;
        this.b = r2;
    }
}
