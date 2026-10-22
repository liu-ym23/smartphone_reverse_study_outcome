package com.bytedance.android.live.liveinteract.voicechat.radio.asr;

import android.os.Handler;
import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l implements f {
    public final /* synthetic */ k a;

    public static final class a implements Runnable {
        public final /* synthetic */ l a;
        public final /* synthetic */ String b;

        public a(l r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            k.b r0 = this.a.a.g;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.b(this.b);     // Catch: Throwable -> L6
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
        public final /* synthetic */ l a;
        public final /* synthetic */ com.bytedance.android.live.liveinteract.voicechat.radio.asr.e b;

        public b(l r1, com.bytedance.android.live.liveinteract.voicechat.radio.asr.e r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            k.b r0 = this.a.a.g;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.a(this.b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ l a;
        public final /* synthetic */ String b;

        public c(l r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            k.b r0 = this.a.a.g;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.c(this.b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ l a;
        public final /* synthetic */ String b;

        public d(l r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            k.b r0 = this.a.a.g;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.onStart(this.b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ l a;
        public final /* synthetic */ String b;

        public e(l r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            k.b r0 = this.a.a.g;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.onStop(this.b);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public l(k r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.radio.asr.g
    public final void c(com.bytedance.android.live.liveinteract.voicechat.radio.asr.e r3) {
        Intrinsics.checkNotNullParameter(r3, "err");
        AndroidSchedulers.mainThread().scheduleDirect(new b(this, r3));
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.radio.asr.g
    public final void onStart(String r6) {
        Intrinsics.checkNotNullParameter(r6, "reqId");
        h r0 = this.a.b;
        if (r0 == null) goto L5;
        r0.f = true;
    L5:
        AndroidSchedulers.mainThread().scheduleDirect(new d(this, r6));
        Handler r1 = this.a.d;
        if (r1 == null) goto L9;
        r1.sendMessageDelayed(r1.obtainMessage(24, r6), ((long) this.a.i.intValue()) * 1000);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.radio.asr.g
    public final void onStop(String r3) {
        Intrinsics.checkNotNullParameter(r3, "reqId");
        h r0 = this.a.b;
        if (r0 == null) goto L5;
        r0.f = false;
    L5:
        k r1 = this.a;
        r1.h = "";
        Handler r2 = r1.d;
        if (r2 == null) goto L8;
        r2.removeMessages(24);
    L8:
        AndroidSchedulers.mainThread().scheduleDirect(new e(this, r3));
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.radio.asr.f
    public final void a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "reqId");
        Intrinsics.checkNotNullParameter(r3, "result");
        ALogger.d("MultiLinkAsrEngine", "onCompleteResult: " + r3);
        this.a.h = r3;
        AndroidSchedulers.mainThread().scheduleDirect(new a(this, r3));
    }

    @Override // com.bytedance.android.live.liveinteract.voicechat.radio.asr.f
    public final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "reqId");
        Intrinsics.checkNotNullParameter(r3, "result");
        if (this.a.h.equals(r3) == false) goto L5;
        return;
    L5:
        ALogger.d("MultiLinkAsrEngine", "onPartialResult: " + r3);
        this.a.h = r3;
        AndroidSchedulers.mainThread().scheduleDirect(new c(this, r3));
    }
}
