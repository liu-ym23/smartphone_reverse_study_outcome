package com.bytedance.android.livesdk.interactivity.medialink.dialog;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.bdlocation.BuildConfig;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/dialog/MediaMultiLinkSelfAnchorMicDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "a", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaMultiLinkSelfAnchorMicDialog extends CommonBottomDialog {
    public static final /* synthetic */ int b = 0;
    public final String a;

    public static final class a {
        public static MediaMultiLinkSelfAnchorMicDialog a(Context r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "context");
            Intrinsics.checkNotNullParameter(r2, "uid");
            MediaMultiLinkSelfAnchorMicDialog r0 = new MediaMultiLinkSelfAnchorMicDialog(r1, r2);
            if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L9;
            DialogLancet.handleBlockedDialogShow(r0);
        L7:
            return r0;
        L9:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
        L6:
            DialogLancet.beforeDialogShow(r0);
            r0.show();
            DialogLancet.afterDialogShow(r0);
            goto L7
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ MediaMultiLinkSelfAnchorMicDialog a;
        public final /* synthetic */ boolean b;

        public b(MediaMultiLinkSelfAnchorMicDialog r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static void a(MediaMultiLinkSelfAnchorMicDialog r3) {
            Handler r0 = DialogLancet.resolveDialogHandler(r3);
            if (r0 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r3);
            r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L10:
            DialogLancet.afterDialogDismiss(r3);
            return;
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r3);
            throw th;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r1 == null) goto L10;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
            goto L10
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L8;
            r0.post(DialogLancet.createDismissRunnable(r3));
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            x82.d.z2.getClass();
            x82.d r5 = x82.d.a.a();
            boolean r0 = false;
            if (r5 != null) goto L5;
        L8:
            int r6 = e92.d.a;
            if (e92.m.h() != 4) goto L11;
            r0 = true;
        L11:
            if (r0 == true) goto L14;
            a(this.a);
            return;
        L14:
            x82.d r7 = x82.d.a.a();
            if (r7 == null) goto L17;
            r7.A5(this.a.a, true ^ this.b);
        L17:
            a(this.a);
            return;
        L5:
            if (r5.x5(BuildConfig.FLAVOR) != true) goto L8;
            f2.b(2131920310, 0);
            a(this.a);
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ MediaMultiLinkSelfAnchorMicDialog a;
        public final /* synthetic */ boolean b;

        public c(MediaMultiLinkSelfAnchorMicDialog r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static void a(MediaMultiLinkSelfAnchorMicDialog r3) {
            Handler r0 = DialogLancet.resolveDialogHandler(r3);
            if (r0 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r3);
            r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L10:
            DialogLancet.afterDialogDismiss(r3);
            return;
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r3);
            throw th;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r1 == null) goto L10;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
            goto L10
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L8;
            r0.post(DialogLancet.createDismissRunnable(r3));
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            if (e92.m.e() == false) goto L15;
            int r5 = e92.d.a;
            if (e92.m.h() != 4) goto L7;
            boolean r6 = true;
        L8:
            if (r6 == false) goto L15;
            x82.d.z2.getClass();
            x82.d r7 = x82.d.a.a();
            if (r7 == null) goto L13;
            r7.P4(this.a.a.toString(), true ^ this.b);
        L13:
            a(this.a);
            return;
        L7:
            r6 = false;
        L15:
            a(this.a);
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ MediaMultiLinkSelfAnchorMicDialog a;

        public d(MediaMultiLinkSelfAnchorMicDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            CommonBottomDialog r5 = this.a;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r1 == null) goto L16;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r0.getLooper()) goto L7;
            r0.post(DialogLancet.createDismissRunnable(r5));
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131566920;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        x82.d.z2.getClass();
        x82.d r0 = x82.d.a.a();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        x82.d r3 = x82.d.a.a();
        if (r3 != null) goto L11;
    L13:
        boolean r4 = false;
    L14:
        TextView r5 = (TextView) findViewById(2131389544);
        if (r5 == null) goto L20;
        if (r2 == false) goto L18;
        int r6 = 2131920307;
    L19:
        r5.setText(s1.B(r6));
        goto L20
    L18:
        r6 = 2131920309;
    L20:
        TextView r7 = (TextView) findViewById(2131389543);
        if (r7 == null) goto L27;
        if (r4 == false) goto L24;
        int r8 = 2131920306;
    L25:
        r7.setText(s1.B(r8));
        goto L27
    L24:
        r8 = 2131920308;
    L27:
        if (e92.m.e() == false) goto L34;
        int r9 = e92.d.a;
        if (e92.m.h() != 4) goto L31;
        boolean r10 = true;
    L32:
        if (r10 == false) goto L34;
        boolean r11 = true;
    L35:
        if (r11 == false) goto L39;
        TextView r13 = (TextView) findViewById(2131389543);
        if (r13 == null) goto L39;
        UtilityKotlinExtentionsKt.z(r13, true);
    L39:
        int r14 = e92.d.a;
        if (e92.m.h() != 4) goto L42;
        boolean r15 = true;
    L43:
        if (r15 == true) goto L46;
    L51:
        if (r1 == false) goto L55;
        TextView r16 = (TextView) findViewById(2131389544);
        if (r16 == null) goto L55;
        UtilityKotlinExtentionsKt.z(r16, true);
    L55:
        TextView r17 = (TextView) findViewById(2131389544);
        if (r17 == null) goto L58;
        r17.setOnClickListener(new b(this, r2));
    L58:
        TextView r18 = (TextView) findViewById(2131389543);
        if (r18 == null) goto L61;
        r18.setOnClickListener(new c(this, r4));
    L61:
        TextView r19 = (TextView) findViewById(2131389670);
        if (r19 == null) goto L65;
        r19.setOnClickListener(new d(this));
        return;
    L65:
        return;
    L46:
        if (e92.m.e() == false) goto L50;
        if (r4 == true) goto L51;
    L50:
        r1 = true;
        goto L51
    L42:
        r15 = false;
        goto L43
    L31:
        r10 = false;
    L34:
        r11 = false;
        goto L35
    L11:
        if (r3.x5(this.a) != true) goto L13;
        r4 = true;
        goto L14
    L5:
        if (r0.t4(this.a) != true) goto L7;
        r2 = true;
        goto L8
    }

    public MediaMultiLinkSelfAnchorMicDialog(Context r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "uid");
        super(r2);
        this.a = r3;
    }
}
