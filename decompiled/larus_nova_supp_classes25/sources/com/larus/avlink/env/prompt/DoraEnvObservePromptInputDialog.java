package com.larus.avlink.env.prompt;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBindings;
import com.larus.avlink.impl.databinding.FragmentTextInputDialogBinding;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.lang.ref.SoftReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p98.b;
import p98.c;
import p98.d;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u0000 $2\u00020\u0001:\u0002$%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u0019H\u0002J\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\rR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/avlink/env/prompt/DoraEnvObservePromptInputDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/avlink/impl/databinding/FragmentTextInputDialogBinding;", "textInputClickListener", "Lcom/larus/avlink/env/prompt/DoraEnvObservePromptInputDialog$TextInputClickListener;", "getTextInputClickListener", "()Lcom/larus/avlink/env/prompt/DoraEnvObservePromptInputDialog$TextInputClickListener;", "setTextInputClickListener", "(Lcom/larus/avlink/env/prompt/DoraEnvObservePromptInputDialog$TextInputClickListener;)V", "inputLimit", "", "isTextChanging", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "onDestroyView", "setupView", "setupInputListener", "getInputText", "", "wakeUpSoftInput", "setInputLimit", "limit", "Companion", "TextInputClickListener", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DoraEnvObservePromptInputDialog extends DialogFragment {
    public static final /* synthetic */ int g = 0;
    public FragmentTextInputDialogBinding d;
    public final int e;
    public boolean f;

    public static final class a {
    }

    static {
    }

    public DoraEnvObservePromptInputDialog() {
        this.e = 1000;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d = null;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        r1.setBackgroundDrawable(null);
        r1.setLayout(-1, c7.b(310));
        r1.setGravity(80);
    L7:
        FragmentTextInputDialogBinding r2 = this.d;
        if (r2 == null) goto L19;
        EditText r3 = r2.d;
        if (r3 == null) goto L19;
        if (r2 == null) goto L17;
        if (r3 == null) goto L17;
        Editable r4 = r3.getText();
        if (r4 == null) goto L17;
        String r5 = r4.toString();
        if (r5 == null) goto L17;
    L18:
        r3.setSelection(r5.length());
    L17:
        r5 = "";
    L19:
        SoftReference r6 = y.a;
        Runnable r7 = new c(this);
        Intrinsics.checkNotNullParameter(r7, "action");
        y.d(r7, 200);
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r4, r5);
        FLogger.a.i("DoraEnvObservePromptInputDialog", "onViewCreated");
        FragmentTextInputDialogBinding r6 = this.d;
        if (r6 == null) goto L7;
        EditText r7 = r6.d;
        if (r7 == null) goto L7;
        r7.addTextChangedListener(new d(this));
    L7:
        Bundle r8 = getArguments();
        String r9 = null;
        if (r8 == null) goto L10;
        Integer r10 = Integer.valueOf(r8.getInt("promptState", 1));
    L11:
        FragmentTextInputDialogBinding r1 = this.d;
        if (r1 == null) goto L22;
        TextView r2 = r1.f;
        if (r2 == null) goto L22;
        if (r10 != null) goto L18;
    L20:
        String r3 = getString(2131903900);
    L21:
        r2.setText(r3);
        goto L22
    L18:
        if (r10.intValue() != 1) goto L20;
        r3 = getString(2131903856);
    L22:
        FragmentTextInputDialogBinding r11 = this.d;
        if (r11 == null) goto L33;
        EditText r12 = r11.d;
        if (r12 == null) goto L33;
        if (r10 != null) goto L29;
    L31:
        String r13 = getString(2131903899);
    L32:
        r12.setHint(r13);
        goto L33
    L29:
        if (r10.intValue() != 1) goto L31;
        r13 = getString(2131903855);
    L33:
        FragmentTextInputDialogBinding r14 = this.d;
        if (r14 == null) goto L41;
        EditText r15 = r14.d;
        if (r15 == null) goto L41;
        Bundle r0 = getArguments();
        if (r0 == null) goto L40;
        r9 = r0.getString("editContent", "");
    L40:
        r15.setText(r9);
    L41:
        FragmentTextInputDialogBinding r16 = this.d;
        if (r16 == null) goto L46;
        EditText r17 = r16.d;
        if (r17 == null) goto L46;
        r17.setLineSpacing(0.0f, 1.25f);
    L46:
        FragmentTextInputDialogBinding r18 = this.d;
        if (r18 == null) goto L51;
        TextView r19 = r18.b;
        if (r19 == null) goto L51;
        r19.setOnClickListener(new p98.a(this));
    L51:
        FragmentTextInputDialogBinding r20 = this.d;
        if (r20 == null) goto L57;
        TextView r21 = r20.e;
        if (r21 == null) goto L58;
        r21.setOnClickListener(new b(this));
        return;
    L58:
        return;
    L57:
        return;
    L10:
        r10 = null;
        goto L11
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        View r11 = r8.inflate(2131561254, r9, false);
        int r12 = 2131365123;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r11, 2131365123);
        if (r2 == null) goto L18;
        r12 = 2131368024;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r11, 2131368024);
        if (r3 == null) goto L18;
        r12 = 2131371413;
        EditText r4 = (EditText) ViewBindings.findChildViewById(r11, 2131371413);
        if (r4 == null) goto L18;
        r12 = 2131385089;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r11, 2131385089);
        if (r5 == null) goto L18;
        r12 = 2131388772;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r11, 2131388772);
        if (r6 == null) goto L18;
        LinearLayout r13 = (LinearLayout) r11;
        this.d = new FragmentTextInputDialogBinding(r13, r2, r3, r4, r5, r6);
        if (r13 == null) goto L16;
        return r13;
    L16:
        return new View(getContext());
    L18:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
