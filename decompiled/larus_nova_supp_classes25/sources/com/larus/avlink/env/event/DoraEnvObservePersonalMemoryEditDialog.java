package com.larus.avlink.env.event;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.avlink.impl.databinding.LarusDialogPersonalMemoryEditBinding;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.util.UUID;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0002J\b\u0010#\u001a\u00020\u0017H\u0002J\u0012\u0010$\u001a\u00020\u00172\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u0010\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u0007H\u0002J\u0010\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\u0017H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryEditDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/avlink/impl/databinding/LarusDialogPersonalMemoryEditBinding;", "maxCharCount", "", "viewModel", "Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryViewModel;", "getViewModel", "()Lcom/larus/avlink/env/event/DoraEnvObservePersonalMemoryViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "clientReqId", "", "isSaveSuccess", "", "editEntryId", "", "Ljava/lang/Long;", "initialContent", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setupDialogBehavior", "setupViews", "updateSaveButtonState", "s", "Landroid/text/Editable;", "updateCounter", "length", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onDestroyView", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DoraEnvObservePersonalMemoryEditDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int k = 0;
    public LarusDialogPersonalMemoryEditBinding d;
    public final int e;
    public final Lazy f;
    public final String g;
    public boolean h;
    public Long i;
    public String j;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public b(r r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final DoraEnvObservePersonalMemoryViewModel T90() {
        return (DoraEnvObservePersonalMemoryViewModel) this.f.getValue();
    }

    public DoraEnvObservePersonalMemoryEditDialog() {
        this.e = 100;
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraEnvObservePersonalMemoryViewModel.class), new DoraEnvObservePersonalMemoryEditDialog$special$$inlined$activityViewModels$default$1(this), new DoraEnvObservePersonalMemoryEditDialog$special$$inlined$activityViewModels$default$2(this));
        this.g = UUID.randomUUID().toString();
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
        this.d = null;
    }

    public final void S90(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        super/*androidx.fragment.app.DialogFragment*/.onDismiss(r2);
        if (this.h == false) goto L5;
        return;
    L5:
        if (this.i != null) goto L20;
        LarusDialogPersonalMemoryEditBinding r3 = this.d;
        if (r3 == null) goto L16;
        EditText r4 = r3.b;
        if (r4 == null) goto L16;
        Editable r5 = r4.getText();
        if (r5 == null) goto L16;
        String r6 = r5.toString();
        if (r6 == null) goto L16;
        String r7 = StringsKt.trim(r6).toString();
        if (r7 == null) goto L16;
    L17:
        String r0 = o98.d.a;
        Intrinsics.checkNotNullParameter(r7, ChatDraftItem.TYPE_TEXT);
        o98.d.a = r7;
        return;
    L16:
        r7 = "";
        goto L17
    }

    public final void U90(int r5) {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        LarusDialogPersonalMemoryEditBinding r1 = this.d;
        if (r1 == null) goto L11;
        TextView r2 = r1.d;
        if (r2 == null) goto L11;
        StringBuilder r3 = new StringBuilder();
        r3.append(r5);
        r3.append('/');
        r3.append(this.e);
        r2.setText(r3.toString());
    L11:
        if (r5 < this.e) goto L17;
        LarusDialogPersonalMemoryEditBinding r6 = this.d;
        if (r6 == null) goto L23;
        TextView r7 = r6.d;
        if (r7 == null) goto L24;
        r7.setTextColor(ContextCompat.getColor(r0, v19.c.b(2131102625, r0, 2131102625)));
        return;
    L24:
        return;
    L23:
        return;
    L17:
        LarusDialogPersonalMemoryEditBinding r8 = this.d;
        if (r8 == null) goto L26;
        TextView r9 = r8.d;
        if (r9 == null) goto L27;
        r9.setTextColor(ContextCompat.getColor(r0, v19.c.b(2131103143, r0, 2131103143)));
        return;
    L27:
        return;
    }

    public final void V90(Editable r4) {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r1 = false;
        if (r4 == null) goto L12;
        String r5 = r4.toString();
        if (r5 == null) goto L12;
        if ((!StringsKt.isBlank(r5)) != true) goto L12;
        r1 = true;
    L12:
        if (r1 == false) goto L18;
        LarusDialogPersonalMemoryEditBinding r6 = this.d;
        if (r6 == null) goto L24;
        TextView r7 = r6.e;
        if (r7 == null) goto L25;
        r7.setTextColor(ContextCompat.getColor(r0, v19.c.b(2131103203, r0, 2131103203)));
        return;
    L25:
        return;
    L24:
        return;
    L18:
        LarusDialogPersonalMemoryEditBinding r8 = this.d;
        if (r8 == null) goto L27;
        TextView r9 = r8.e;
        if (r9 == null) goto L28;
        r9.setTextColor(ContextCompat.getColor(r0, v19.c.b(2131103204, r0, 2131103204)));
        return;
    L28:
        return;
    }

    public final void onCreate(Bundle r4) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r4);
        Bundle r5 = getArguments();
        String r0 = null;
        if (r5 != null) goto L5;
    L7:
        Long r6 = null;
    L8:
        this.i = r6;
        Bundle r7 = getArguments();
        if (r7 == null) goto L11;
        r0 = r7.getString("arg_content");
    L11:
        this.j = r0;
        return;
    L5:
        if (r5.containsKey("arg_entry_id") == false) goto L7;
        r6 = Long.valueOf(r5.getLong("arg_entry_id"));
        goto L8
    }

    public final void onDismiss(DialogInterface r2) {
        S90(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.avlink.env.event.r] */
    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r5, r6);
        Object r7 = r5.getParent();
        Editable r0 = null;
        if ((r7 instanceof View) == false) goto L5;
        View r8 = (View) r7;
    L6:
        int r9 = 0;
        if (r8 == null) goto L9;
        r8.setBackgroundColor(0);
    L9:
        Dialog r10 = getDialog();
        if (r10 == null) goto L12;
        r10.setOnShowListener(new s(this));
    L12:
        LarusDialogPersonalMemoryEditBinding r11 = this.d;
        if (r11 == null) goto L17;
        TextView r12 = r11.c;
        if (r12 == null) goto L17;
        int r1 = com.larus.utils.j0.a;
        r12.setText(com.larus.utils.j0.d(2131902520));
    L17:
        LarusDialogPersonalMemoryEditBinding r13 = this.d;
        if (r13 == null) goto L22;
        TextView r14 = r13.e;
        if (r14 == null) goto L22;
        int r2 = com.larus.utils.j0.a;
        r14.setText(com.larus.utils.j0.d(2131902529));
    L22:
        LarusDialogPersonalMemoryEditBinding r15 = this.d;
        if (r15 == null) goto L27;
        EditText r16 = r15.b;
        if (r16 == null) goto L27;
        int r3 = com.larus.utils.j0.a;
        r16.setHint(com.larus.utils.j0.d(2131902519));
    L27:
        LarusDialogPersonalMemoryEditBinding r17 = this.d;
        if (r17 == null) goto L32;
        TextView r18 = r17.c;
        if (r18 == null) goto L32;
        r18.setOnClickListener(new p(this));
    L32:
        LarusDialogPersonalMemoryEditBinding r19 = this.d;
        if (r19 == null) goto L37;
        TextView r20 = r19.e;
        if (r20 == null) goto L37;
        r20.setOnClickListener(new q(this));
    L37:
        T90().getSaveSuccess().observe(getViewLifecycleOwner(), new b(new r(this)));
        String r21 = o98.d.a;
        if (r21.length() <= 0) goto L40;
        boolean r4 = true;
    L41:
        if (r4 == true) goto L43;
    L54:
        String r22 = this.j;
        if (r22 == null) goto L70;
        LarusDialogPersonalMemoryEditBinding r23 = this.d;
        if (r23 == null) goto L61;
        EditText r24 = r23.b;
        if (r24 == null) goto L61;
        r24.setText(r22);
    L61:
        LarusDialogPersonalMemoryEditBinding r25 = this.d;
        if (r25 == null) goto L70;
        EditText r26 = r25.b;
        if (r26 == null) goto L70;
        String r27 = this.j;
        if (r27 == null) goto L68;
        int r28 = r27.length();
    L69:
        r26.setSelection(r28);
        goto L70
    L68:
        r28 = 0;
    L70:
        LarusDialogPersonalMemoryEditBinding r29 = this.d;
        if (r29 == null) goto L77;
        EditText r30 = r29.b;
        if (r30 == null) goto L77;
        Editable r31 = r30.getText();
        if (r31 == null) goto L77;
        r9 = r31.length();
    L77:
        U90(r9);
        LarusDialogPersonalMemoryEditBinding r32 = this.d;
        if (r32 == null) goto L82;
        EditText r33 = r32.b;
        if (r33 == null) goto L82;
        r0 = r33.getText();
    L82:
        V90(r0);
        LarusDialogPersonalMemoryEditBinding r34 = this.d;
        if (r34 == null) goto L88;
        EditText r35 = r34.b;
        if (r35 == null) goto L89;
        r35.addTextChangedListener(new u(this));
        return;
    L89:
        return;
    L88:
        return;
    L43:
        if (this.i != null) goto L54;
        LarusDialogPersonalMemoryEditBinding r36 = this.d;
        if (r36 == null) goto L49;
        EditText r37 = r36.b;
        if (r37 == null) goto L49;
        r37.setText(r21);
    L49:
        LarusDialogPersonalMemoryEditBinding r38 = this.d;
        if (r38 == null) goto L70;
        EditText r39 = r38.b;
        if (r39 == null) goto L70;
        r39.setSelection(r21.length());
        goto L70
    L40:
        r4 = false;
        goto L41
    L5:
        r8 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        ConstraintLayout r10 = r7.inflate(2131562093, r8, false);
        int r11 = 2131371800;
        EditText r2 = (EditText) ViewBindings.findChildViewById(r10, 2131371800);
        if (r2 == null) goto L15;
        r11 = 2131390273;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r10, 2131390273);
        if (r3 == null) goto L15;
        r11 = 2131390417;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r10, 2131390417);
        if (r4 == null) goto L15;
        r11 = 2131391337;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r10, 2131391337);
        if (r5 == null) goto L15;
        r11 = 2131391606;
        if (((TextView) ViewBindings.findChildViewById(r10, 2131391606)) == null) goto L15;
        ConstraintLayout r12 = r10;
        this.d = new LarusDialogPersonalMemoryEditBinding(r12, r2, r3, r4, r5);
        return r12;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r11)));
    }
}
