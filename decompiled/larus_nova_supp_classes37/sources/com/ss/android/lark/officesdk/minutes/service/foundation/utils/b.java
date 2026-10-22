package com.ss.android.lark.officesdk.minutes.service.foundation.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.ToastType;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import qub.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public static volatile MmRecordingUILaunchMode a;
    public static volatile h b;

    public static final class a implements Runnable {
        public final /* synthetic */ MmRecordingUILaunchMode a;
        public final /* synthetic */ rub.e b;

        public a(MmRecordingUILaunchMode r1, rub.e r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            if (this.a.shouldHandleUI() == false) goto L7;
            h r0 = b.b;
            if (r0 == null) goto L9;
            r0.u(UIHelper.getContext(), this.b);
            return;
        L9:
            return;
        L7:
            lvb.a.b("MmRecordToast", "[showInternal] skip toast, uiLaunchMode=" + this.a + ", type=" + this.b.getType());
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

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.foundation.utils.b$b, reason: collision with other inner class name */
    public static final class RunnableC0019b implements Runnable {
        public final /* synthetic */ h a;
        public final /* synthetic */ rub.e b;
        public final /* synthetic */ rub.e c;

        public RunnableC0019b(h r1, rub.e r2, rub.e r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            h r0 = this.a;     // Catch: Throwable -> L7
            if (r0 == null) goto L5;
            r0.u(UIHelper.getContext(), this.b);     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            MmRecordingUILaunchMode r1 = b.a;     // Catch: Throwable -> L7
            b.c(this.c);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        }
    }

    static {
        a = MmRecordingUILaunchMode.UNKNOWN;
    }

    public static void a(int r4) {
        String r5 = UIHelper.getString(r4);
        Intrinsics.checkNotNullParameter(r5, "toastMsg");
        c(new rub.e(r5, ToastType.ERROR, null, 26));
    }

    public static void c(rub.e r2) {
        if (StringsKt.isBlank(r2.a) == false) goto L5;
        return;
    L5:
        MmRecordingUILaunchMode r0 = a;
        d.a(new a(r0, rub.e.a(r2, r0)));
    }

    public static void d(int r0) {
        e(UIHelper.getString(r0));
    }

    public static void e(String r4) {
        Intrinsics.checkNotNullParameter(r4, "toastMsg");
        c(new rub.e(r4, ToastType.NORMAL, null, 26));
    }

    public static void f(int r0) {
        g(UIHelper.getString(r0));
    }

    public static void g(String r4) {
        Intrinsics.checkNotNullParameter(r4, "toastMsg");
        c(new rub.e(r4, ToastType.WARNING, null, 26));
    }

    public static void b(h r2, rub.e r3) {
        if (StringsKt.isBlank(r3.a) == false) goto L6;
        lvb.a.b("MmRecordToast", "[showInternal] skip toast, content is blank");
        return;
    L6:
        d.a(new RunnableC0019b(r2, rub.e.a(r3, a), r3));
    }
}
