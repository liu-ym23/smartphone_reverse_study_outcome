package com.bytedance.android.livesdk.interactivity.imagerecognition;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.d8;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionBusiness;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionEntry;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import s32.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class ImageRecognitionTask {
    public static final /* synthetic */ int q = 0;
    public int a;
    public long b;
    public ImageRecognitionDialogFragment c;
    public long d;
    public final Handler e;
    public final CompositeDisposable f;
    public c g;
    public final d h;
    public final d8 i;
    public final int j;
    public final ImageRecognitionEntry k;
    public final String l;
    public final ImageRecognitionBusiness m;
    public final Context n;
    public final FragmentManager o;
    public final b p;

    public static final class a {
    }

    public interface b {
        void onCancel();

        void onFailed();

        void onSuccess();
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ImageRecognitionTask a;
        public final /* synthetic */ Function0 b;

        public c(ImageRecognitionTask r1, Function0 r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            ImageRecognitionTask r0 = this.a;
            String r1 = "close action run. state=" + this.a.a;
            r0.getClass();
            ImageRecognitionTask.e(r1);
            ImageRecognitionDialogFragment r2 = this.a.c;
            if (r2 != null) goto L13;
        L11:
            this.a.d = 0;
            this.b.invoke();
            return;
        L13:
            r2.dismissAllowingStateLoss();     // Catch: Exception -> L6
        L10:
            this.a.c = null;
        L6:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L10;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L10
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

    static {
    }

    public final boolean d() {
        if (this.a == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void b() {
        if (d() == true) goto L15;
        int r0 = this.a;
        if (r0 != 2) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L15;
        if (r0 != 0) goto L26;
        this.a = 5;
        b r1 = this.p;
        if (r1 == null) goto L27;
        r1.onCancel();
        return;
    L27:
        return;
    L26:
        return;
    L7:
        r3 = false;
    L15:
        if (d() == true) goto L19;
        if (this.h.c == 0) goto L19;
    L22:
        this.a = 5;
        c(true, ImageRecognitionTask$cancel$1.INSTANCE);
        this.f.dispose();
        this.e.removeCallbacksAndMessages(null);
        b r2 = this.p;
        if (r2 == null) goto L29;
        r2.onCancel();
        return;
    L29:
        return;
    L19:
        if (d() == false) goto L21;
        d r4 = this.h;
        r4.m = System.currentTimeMillis() - this.b;
    L21:
        d r5 = this.h;
        r5.c = -1;
        Intrinsics.checkNotNullParameter("user cancel", "<set-?>");
        r5.d = "user cancel";
        int r6 = com.bytedance.android.livesdk.interactivity.imagerecognition.util.a.a;
        int r7 = this.j;
        ImageRecognitionEntry r8 = this.k;
        d r9 = this.h;
        Intrinsics.checkNotNullParameter(r8, "entry");
        Intrinsics.checkNotNullParameter(r9, "ctx");
        com.bytedance.android.livesdk.interactivity.imagerecognition.util.a.a(r7, r8, r9);
        goto L22
    }

    public static void e(String r2) {
        int r0 = f.a;
        f.b("[RecognitionTask] " + r2);
    }

    public static final void a(final ImageRecognitionTask r5, Throwable r6) {
        if (r5.d() == false) goto L6;
        r5.a = 2;
        r5.h.m = System.currentTimeMillis() - r5.b;
        int r0 = com.bytedance.android.livesdk.interactivity.imagerecognition.util.a.a;
        int r1 = r5.j;
        ImageRecognitionEntry r2 = r5.k;
        d r3 = r5.h;
        Intrinsics.checkNotNullParameter(r2, "entry");
        Intrinsics.checkNotNullParameter(r3, "ctx");
        com.bytedance.android.livesdk.interactivity.imagerecognition.util.a.a(r1, r2, r3);
        f("onRecognitionFailed. cost " + r5.h.m + "ms. logId=" + r5.h.o + " msg=" + r5.h.d + " requestId=" + r5.h.n, r6);
        r5.c(false, new ImageRecognitionTask$onRecognitionFailed$1(r5));
        return;
    }

    public static void f(String r2, Throwable r3) {
        if (r3 != null) goto L5;
        int r4 = f.a;
        f.a("[RecognitionTask] " + r2);
        return;
    L5:
        int r1 = f.a;
        String r5 = "[RecognitionTask] " + r2;
        Intrinsics.checkNotNullParameter(r5, "info");
        Intrinsics.checkNotNullParameter(r3, "t");
        ALogger.e("ImageRecognition", r5, r3);
    }

    public final void c(boolean r6, Function0<Unit> r7) {
        c r0 = this.g;
        if (r0 == null) goto L5;
        this.e.removeCallbacks(r0);
        this.g = null;
    L5:
        c r1 = new c(this, r7);
        if (r6 == true) goto L14;
        long r8 = this.d;
        if (r8 == 0) goto L14;
        long r9 = r8 - SystemClock.elapsedRealtime();
        if (r9 <= 0) goto L13;
        this.g = r1;
        this.e.postDelayed(r1, r9);
        return;
    L13:
        r1.run();
        return;
    L14:
        r1.run();
    }

    public ImageRecognitionTask(d8 r2, int r3, ImageRecognitionEntry r4, String r5, ImageRecognitionBusiness r6, Context r7, FragmentManager r8, com.bytedance.android.livesdk.interactivity.imagerecognition.b r9) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r4, "entry");
        Intrinsics.checkNotNullParameter(r6, "business");
        this.i = r2;
        this.j = r3;
        this.k = r4;
        this.l = r5;
        this.m = r6;
        this.n = r7;
        this.o = r8;
        this.p = r9;
        this.e = new Handler(Looper.getMainLooper());
        this.f = new CompositeDisposable();
        this.h = new d();
    }
}
