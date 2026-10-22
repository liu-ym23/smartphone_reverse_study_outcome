package com.bytedance.android.live.effect.sticker;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.effectmanager.common.task.ExceptionResult;
import com.ss.android.ugc.effectmanager.effect.listener.IEffectDownloadProgressListener;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements IEffectDownloadProgressListener {
    public final /* synthetic */ Effect a;
    public final /* synthetic */ LiveStickerDownloadHelper b;
    public final /* synthetic */ String c;
    public final /* synthetic */ com.bytedance.android.live.effect.api.l.b d;
    public final /* synthetic */ Sticker e;

    public static final class a implements Runnable {
        public final /* synthetic */ h a;
        public final /* synthetic */ ExceptionResult b;

        public a(h r1, ExceptionResult r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            com.bytedance.android.live.effect.api.l.b r0 = this.a.d;
            if (r0 == null) goto L5;
            this.b.getErrorCode();
            r0.b();
        L5:
            Iterator r1 = ((ArrayList) this.a.b.b).iterator();
        L7:
            if (r1.hasNext() == false) goto L9;
            com.bytedance.android.live.effect.api.l.b r2 = (com.bytedance.android.live.effect.api.l.b) r1.next();
            Sticker r3 = this.a.e;
            this.b.getErrorCode();
            r2.b();
            goto L7
        L9:
            h r4 = this.a;
            List<String> r5 = r4.b.c;
            ArrayList r6 = (ArrayList) r5;
            r6.remove(r4.a.getEffectId());
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ h a;

        public b(h r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.live.effect.api.l.b r0 = this.a.d;     // Catch: Throwable -> L6
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
        AndroidSchedulers.mainThread().scheduleDirect(new g(this, r4));
    }

    public final void onFail(Effect r2, ExceptionResult r3) {
        Intrinsics.checkNotNullParameter(r3, "e");
        AndroidSchedulers.mainThread().scheduleDirect(new a(this, r3));
    }

    public h(Effect r1, LiveStickerDownloadHelper r2, String r3, com.bytedance.android.live.effect.api.l.b r4, Sticker r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
