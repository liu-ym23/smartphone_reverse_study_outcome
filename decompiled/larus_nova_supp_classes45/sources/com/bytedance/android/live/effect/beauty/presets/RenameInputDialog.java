package com.bytedance.android.live.effect.beauty.presets;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.core.utils.f2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/effect/beauty/presets/RenameInputDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RenameInputDialog extends DialogFragment {
    public EditText d;
    public Button e;
    public ImageView f;
    public com.bytedance.android.live.effect.beauty.presets.b g;

    public static final class a implements TextWatcher {
        public final /* synthetic */ RenameInputDialog a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r1) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public a(RenameInputDialog r1) {
            this.a = r1;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            if (r1 == null) goto L11;
            Button r5 = this.a.e;
            if (r5 != null) goto L6;
            return;
        L6:
            if (r1.length() <= 0) goto L8;
            boolean r6 = true;
        L9:
            r5.setEnabled(r6);
            return;
        L8:
            r6 = false;
            goto L9
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ RenameInputDialog a;

        public b(RenameInputDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            EditText r5 = this.a.d;
            Editable r0 = null;
            if (r5 == null) goto L5;
            Editable r6 = r5.getText();
        L6:
            boolean r1 = true;
            if (r6 != null) goto L9;
        L12:
            boolean r7 = true;
        L13:
            if (r7 == true) goto L47;
            EditText r8 = this.a.d;
            if (r8 == null) goto L17;
            Editable r9 = r8.getText();
        L18:
            if (r9 != null) goto L20;
        L23:
            if (r1 == true) goto L47;
            EditText r11 = this.a.d;
            if (r11 == null) goto L30;
            Editable r12 = r11.getText();
            if (r12 == null) goto L30;
            int r13 = r12.length();
        L32:
            if (r13 <= 4) goto L34;
            f2.c("最多输入4个字符", 0);
            return;
        L34:
            RenameInputDialog r14 = this.a;
            com.bytedance.android.live.effect.beauty.presets.b r2 = r14.g;
            if (r2 == null) goto L49;
            EditText r15 = r14.d;
            if (r15 == null) goto L39;
            r0 = r15.getText();
        L39:
            r2.a(String.valueOf(r0));
        L49:
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L43
            return;
        L43:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r16 = DialogFragmentLancet.sLastShowStack;
            if (r16 == null) goto L52;
            com.bytedance.crash.d.d(r16, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L52:
            return;
        L30:
            r13 = 0;
            goto L32
        L20:
            if (StringsKt.isBlank(r9) == true) goto L23;
            r1 = false;
            goto L23
        L17:
            r9 = null;
        L47:
            f2.c("命名不能为空", 0);
            return;
        L9:
            if (r6.length() == 0) goto L12;
            r7 = false;
            goto L13
        L5:
            r6 = null;
            goto L6
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ RenameInputDialog a;

        public c(RenameInputDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            EditText r3 = this.a.d;
            if (r3 == null) goto L6;
            r3.setText("");
            return;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ RenameInputDialog a;

        public d(RenameInputDialog r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r3 = DialogFragmentLancet.sLastShowStack;
            if (r3 == null) goto L12;
            com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public RenameInputDialog() {
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        this.f = (ImageView) r2.findViewById(2131376105);
        EditText r4 = (EditText) r2.findViewById(2131371800);
        r4.addTextChangedListener(new a(this));
        Unit r0 = Unit.INSTANCE;
        this.d = r4;
        ImageView r5 = this.f;
        if (r5 == null) goto L5;
        r5.setOnClickListener(new c(this));
    L5:
        Dialog r6 = getDialog();
        if (r6 == null) goto L8;
        r6.setCancelable(false);
    L8:
        Dialog r7 = getDialog();
        if (r7 == null) goto L11;
        r7.setCanceledOnTouchOutside(false);
    L11:
        Button r8 = (Button) r2.findViewById(2131367655);
        r8.setEnabled(false);
        r8.setOnClickListener(new b(this));
        this.e = r8;
        ((Button) r2.findViewById(2131365125)).setOnClickListener(new d(this));
    }

    public final View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r5, "inflater");
        Dialog r8 = getDialog();
        if (r8 == null) goto L5;
        r8.requestWindowFeature(1);
    L5:
        Dialog r9 = getDialog();
        if (r9 == null) goto L10;
        Window r11 = r9.getWindow();
        if (r11 == null) goto L10;
        r11.setBackgroundDrawable(new ColorDrawable(0));
    L10:
        Dialog r12 = getDialog();
        if (r12 == null) goto L22;
        Window r13 = r12.getWindow();
        if (r13 == null) goto L22;
        View r14 = r13.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L19;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r1 = ThreadMethodProxy.currentThread();
        if (r1 == com.larus.home.impl.utils.c.a) goto L19;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");
    L19:
        if (r14 == null) goto L22;
        r14.setPadding(0, 0, 0, 0);
    L22:
        return r5.inflate(2131565856, r6, false);
    }
}
