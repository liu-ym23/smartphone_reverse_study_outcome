package com.ss.android.lark.officesdk.minutes.service.foundation.network.core.error;

import android.app.Activity;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.ToastType;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpErrorMsg;
import kotlin.jvm.internal.Intrinsics;
import rub.e;
import yub.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a a;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.foundation.network.core.error.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0017a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmHttpErrorMsg.ErrorDisplayType.values().length];
            r0[MmHttpErrorMsg.ErrorDisplayType.TOAST_NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[MmHttpErrorMsg.ErrorDisplayType.TOAST_SUCCEED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[MmHttpErrorMsg.ErrorDisplayType.TOAST_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[MmHttpErrorMsg.ErrorDisplayType.TOAST_INFO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ a b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public b(Activity r1, a r2, String r3, String r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void a() {
            if (this.a.isFinishing() == false) goto L6;
            lvb.a.b("MmHttpErrorProcessor", "[showAlert] activity is not ready, activity=" + this.a);
            return;
        L6:
            com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r0 = this.b.a;
            if (r0 == null) goto L9;
            qub.c r1 = (qub.c) r0.u(qub.c.class);
        L10:
            if (r1 == null) goto L13;
            r1.u0(this.a, new rub.b(null, this.c, this.d, this.e, null, false, null, null, 65521));
            return;
        L13:
            UDDialog r2 = new UDDialogBuilder(this.a).title(this.c).message(this.d).actionButtonOrientation(UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL).addActionButton(2131391777, this.e, null).build();
            if (DialogLancet.shouldBlockDialogShow(r2) == false) goto L20;
            DialogLancet.handleBlockedDialogShow(r2);
            return;
        L20:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L19
        L17:
            DialogLancet.beforeDialogShow(r2);
            r2.show();
            DialogLancet.afterDialogShow(r2);
            return;
        L9:
            r1 = null;
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

    public a(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r1) {
        this.a = r1;
    }

    public final boolean b(MmHttpErrorMsg.ErrorDisplayType r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "type");
        Intrinsics.checkNotNullParameter(r7, "body");
        int r8 = C0017a.a[r6.ordinal()];
        if (r8 != 1) goto L5;
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.e(r7);
    L16:
        return true;
    L5:
        if (r8 != 2) goto L7;
        MmRecordingUILaunchMode r9 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.a;
        Intrinsics.checkNotNullParameter(r7, "toastMsg");
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.c(new e(r7, ToastType.SUCCESS, null, 26));
        goto L16
    L7:
        if (r8 != 3) goto L9;
        MmRecordingUILaunchMode r10 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.a;
        Intrinsics.checkNotNullParameter(r7, "toastMsg");
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.c(new e(r7, ToastType.ERROR, null, 26));
        goto L16
    L9:
        if (r8 == 4) goto L12;
        return false;
    L12:
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.g(r7);
        goto L16
    }

    public final boolean a(String r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "title");
        Intrinsics.checkNotNullParameter(r9, "body");
        Intrinsics.checkNotNullParameter(r10, "positiveButtonText");
        d r0 = d.a;
        Activity r2 = com.ss.android.lark.appcontext.applifecycle2.api.a.a();
        if (r2 != null) goto L5;
    L9:
        lvb.a.b("MmHttpErrorProcessor", "[showAlert] activity is not ready, activity=" + r2);
        return false;
    L5:
        if (r2.isFinishing() == true) goto L9;
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.d.a(new b(r2, this, r8, r9, r10));
        return true;
    }
}
