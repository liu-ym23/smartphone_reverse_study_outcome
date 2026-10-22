package com.larus.bmhome.chat;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.databinding.LarusWholeContentLayoutBinding;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/WholeContentDialogFragment;", "Lcom/larus/bmhome/chat/BaseDialogFragment;", "Lcom/larus/bmhome/databinding/LarusWholeContentLayoutBinding;", "<init>", "()V", "initViewBinding", "initView", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class WholeContentDialogFragment extends BaseDialogFragment<LarusWholeContentLayoutBinding> {
    public static final /* synthetic */ int f = 0;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.chat.BaseDialogFragment
    public final ViewBinding T90() {
        CardView r0 = getLayoutInflater().inflate(2131563237, null, false);
        TextView r2 = (TextView) ViewBindings.findChildViewById(r0, 2131367858);
        if (r2 == null) goto L7;
        CardView r1 = r0;
        return new LarusWholeContentLayoutBinding(r1, r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(2131367858)));
    }

    public WholeContentDialogFragment() {
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [com.larus.bmhome.chat.i5, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v12, types: [com.larus.bmhome.chat.h5, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.larus.bmhome.chat.g5, java.lang.Object] */
    @Override // com.larus.bmhome.chat.BaseDialogFragment
    public final void S90(Bundle r7) {
        Bundle r8 = getArguments();
        String r0 = "";
        Object r1 = null;
        if (r8 == null) goto L5;
        String r9 = r8.getString("param_content", "");
    L6:
        StringBuilder r2 = new StringBuilder();
        Context r3 = getContext();
        if (r3 == null) goto L14;
        Resources r4 = r3.getResources();
        if (r4 == null) goto L14;
        String r5 = r4.getString(2131900193);
        if (r5 == null) goto L14;
        r0 = r5;
    L14:
        r2.append(r0);
        r2.append(r9);
        final Ref.ObjectRef r10 = new Ref.ObjectRef();
        r10.element = r2.toString();
        Bundle r6 = getArguments();
        if (r6 == null) goto L17;
        Integer r11 = Integer.valueOf(r6.getInt("param_background", -1));
    L18:
        CharSequence r12 = (CharSequence) r10.element;
        int r13 = 0;
        if (r12 != null) goto L21;
    L24:
        boolean r14 = true;
    L25:
        if (r14 == false) goto L34;
        dismissAllowingStateLoss();     // Catch: Exception -> L28
        return;
    L28:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r15 = DialogFragmentLancet.sLastShowStack;
        if (r15 == null) goto L55;
        com.bytedance.crash.d.d(r15, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L55:
        return;
    L34:
        if (r11 != null) goto L37;
    L38:
        int r16 = com.larus.bmhome.chat.immerse.k0.a;
        if (r11 == null) goto L41;
        r13 = r11.intValue();
    L41:
        final int r17 = com.larus.bmhome.chat.immerse.k0.a(r13, 0.4f, 0.15f);
        ?? r18 = new g5(r17, this);
        Intrinsics.checkNotNullParameter(r18, "block");
        VB r19 = this.d;
        if (r19 == 0) goto L44;
        r1 = r18.invoke(r19);
    L44:
        Unit r20 = (Unit) r1;
    L49:
        ?? r21 = new i5(r10);
        Intrinsics.checkNotNullParameter(r21, "block");
        VB r22 = this.d;
        if (r22 == 0) goto L57;
        r21.invoke(r22);
        return;
    L57:
        return;
    L37:
        if (r11.intValue() != (-1)) goto L38;
        ?? r23 = new h5(this);
        Intrinsics.checkNotNullParameter(r23, "block");
        VB r24 = this.d;
        if (r24 == 0) goto L48;
        r1 = r23.invoke(r24);
    L48:
        Unit r25 = (Unit) r1;
        goto L49
    L21:
        if (r12.length() == 0) goto L24;
        r14 = false;
        goto L25
    L17:
        r11 = null;
        goto L18
    L5:
        r9 = null;
        goto L6
    }
}
