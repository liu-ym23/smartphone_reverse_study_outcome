package com.larus.avlink.env.diary.style;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.avlink.impl.databinding.LarusDialogDiaryStyleInputBinding;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 A2\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u0019H\u0002J\u0010\u0010\"\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J$\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u001a\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010-\u001a\u00020\u0012H\u0002J\u0012\u0010.\u001a\u00020\u00122\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u0012\u00101\u001a\u00020\u00122\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\b\u00102\u001a\u00020\u0012H\u0002J\"\u00103\u001a\u00020\u00122\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00104\u001a\u00020 2\u0006\u00105\u001a\u00020\u0019H\u0002J\u0010\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u0019H\u0002J\u0012\u00108\u001a\u0002092\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020<H\u0016J\u0010\u0010=\u001a\u00020\u00122\u0006\u0010;\u001a\u00020<H\u0016J\b\u0010>\u001a\u00020\u0012H\u0016J\b\u0010?\u001a\u00020\u0012H\u0002J\b\u0010@\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0093\u0001\u0010\b\u001a{\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012E\u0012C\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\r¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0012\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017Ra\u0010\u0018\u001aI\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0012\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0017R\u000e\u0010\u001d\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/larus/avlink/env/diary/style/DiaryStyleInputDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "TAG", "", "binding", "Lcom/larus/avlink/impl/databinding/LarusDialogDiaryStyleInputBinding;", "onSaveListener", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "prompt", "Lkotlin/Function2;", "Lcom/larus/avlink/env/diary/style/DiaryStyleItem;", "result", "", "errorCode", "", "onResult", "getOnSaveListener", "()Lkotlin/jvm/functions/Function3;", "setOnSaveListener", "(Lkotlin/jvm/functions/Function3;)V", "onDraftListener", "", "saved", "getOnDraftListener", "setOnDraftListener", "isTextChanging", "hasNotifiedDraft", "getMode", "", "shouldHandleDraft", "notifyDraftOnce", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setupInputListener", "handleNameChanged", "editable", "Landroid/text/Editable;", "handlePromptChanged", "updateCountByFocusedInput", "updateInputCount", "limit", "shouldTrimOverflow", "updateSaveButtonStyle", "hasContent", "onCreateDialog", "Landroid/app/Dialog;", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "onStart", "wakeUpSoftInput", "onDestroyView", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DiaryStyleInputDialog extends DialogFragment {
    public static final /* synthetic */ int j = 0;
    public final String d;
    public LarusDialogDiaryStyleInputBinding e;
    public Function3<? super String, ? super String, ? super Function2<? super e0, ? super Long, Unit>, Unit> f;
    public Function3<? super String, ? super String, ? super Boolean, Unit> g;
    public boolean h;
    public boolean i;

    public static final class a {
    }

    static {
    }

    public DiaryStyleInputDialog() {
        this.d = "DiaryStyleInputDialog";
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.e = null;
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
        r1.setLayout(-1, -2);
        r1.setGravity(80);
        r1.setSoftInputMode(21);
    L7:
        LarusDialogDiaryStyleInputBinding r2 = this.e;
        if (r2 == null) goto L14;
        final EditText r3 = r2.d;
        if (r3 == null) goto L15;
        r3.post(new v(this, r3));
        r3.post(new w(r3));
        return;
    L15:
        return;
    }

    public final void S90(Editable r3) {
        LarusDialogDiaryStyleInputBinding r0 = this.e;
        if (r0 == null) goto L9;
        EditText r1 = r0.c;
        if (r1 == null) goto L9;
        boolean r2 = true;
        if (r1.hasFocus() != true) goto L9;
    L10:
        if (r2 == false) goto L13;
        V90(r3, 20);
        return;
    L13:
        return;
    L9:
        r2 = false;
        goto L10
    }

    public final void T90(Editable r4) {
        boolean r0 = false;
        if (r4 == null) goto L5;
        int r1 = r4.length();
    L7:
        if (r1 <= 0) goto L9;
        boolean r2 = true;
    L10:
        W90(r2);
        LarusDialogDiaryStyleInputBinding r3 = this.e;
        if (r3 == null) goto L17;
        EditText r5 = r3.d;
        if (r5 == null) goto L17;
        if (r5.hasFocus() != true) goto L17;
        boolean r6 = true;
    L18:
        if (r6 == true) goto L27;
        LarusDialogDiaryStyleInputBinding r7 = this.e;
        if (r7 == null) goto L26;
        EditText r8 = r7.c;
        if (r8 == null) goto L26;
        if (r8.hasFocus() != true) goto L26;
        r0 = true;
    L26:
        if (r0 == false) goto L27;
        return;
    L27:
        V90(r4, DoraCallStateCode.DORA_OB_USER_END);
        return;
    L17:
        r6 = false;
        goto L18
    L9:
        r2 = false;
        goto L10
    L5:
        r1 = 0;
        goto L7
    }

    public final void U90(boolean r5) {
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        int r1 = r0.getInt("mode", 1);
    L6:
        if (r1 != 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == true) goto L12;
        return;
    L12:
        if (this.i == false) goto L14;
        return;
    L14:
        this.i = true;
        LarusDialogDiaryStyleInputBinding r3 = this.e;
        String r4 = null;
        if (r3 == null) goto L21;
        EditText r6 = r3.c;
        if (r6 == null) goto L21;
        Editable r7 = r6.getText();
        if (r7 == null) goto L21;
        String r8 = r7.toString();
    L22:
        String r9 = "";
        if (r8 != null) goto L25;
        r8 = "";
    L25:
        if (r3 == null) goto L31;
        EditText r10 = r3.d;
        if (r10 == null) goto L31;
        Editable r11 = r10.getText();
        if (r11 == null) goto L31;
        r4 = r11.toString();
    L31:
        if (r4 == null) goto L34;
        r9 = r4;
    L34:
        Function3<? super String, ? super String, ? super Boolean, Unit> r12 = this.g;
        if (r12 == null) goto L38;
        r12.invoke(r8, r9, Boolean.valueOf(r5));
        return;
    L38:
        return;
    L21:
        r8 = null;
        goto L22
    L8:
        r2 = false;
        goto L9
    L5:
        r1 = 1;
        goto L6
    }

    public final void W90(boolean r3) {
        Context r0 = getContext();
        if (r0 == null) goto L18;
        LarusDialogDiaryStyleInputBinding r1 = this.e;
        if (r1 == null) goto L9;
        TextView r2 = r1.e;
        if (r2 == null) goto L9;
        r2.setClickable(r3);
    L9:
        if (r3 == false) goto L11;
        int r4 = v19.c.b(2130972123, r0, 2131103203);
    L12:
        LarusDialogDiaryStyleInputBinding r5 = this.e;
        if (r5 == null) goto L19;
        TextView r6 = r5.e;
        if (r6 == null) goto L20;
        r6.setTextColor(ContextCompat.getColor(r0, r4));
        return;
    L20:
        return;
    L19:
        return;
    L11:
        r4 = v19.c.b(2130972081, r0, 2131103143);
        goto L12
    }

    public final void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        U90(false);
        super.onCancel(r2);
    }

    public final Dialog onCreateDialog(Bundle r3) {
        Dialog r4 = super.onCreateDialog(r3);
        Window r0 = r4.getWindow();
        if (r0 == null) goto L5;
        r0.setSoftInputMode(16);
    L5:
        return r4;
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        U90(false);     // Catch: Throwable -> L5
        super.onDismiss(r2);     // Catch: Throwable -> L5
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

    public final void V90(Editable r5, int r6) {
        if (this.h == false) goto L5;
        return;
    L5:
        boolean r0 = true;
        this.h = true;
        if (r5 == null) goto L8;
        int r2 = r5.length();
    L9:
        if (r2 <= r6) goto L11;
        boolean r3 = true;
    L12:
        if (r5 == null) goto L15;
        if (r3 == false) goto L15;
        r5.delete(r6, r2);
        r2 = r6;
    L15:
        LarusDialogDiaryStyleInputBinding r7 = this.e;
        if (r7 == null) goto L20;
        TextView r8 = r7.f;
        if (r8 == null) goto L20;
        r8.setVisibility(0);
    L20:
        if (r6 <= 0) goto L23;
        if (r2 < r6) goto L23;
    L25:
        if (r0 == false) goto L31;
        StringBuilder r1 = new StringBuilder();
        r1.append(r2);
        r1.append('/');
        r1.append(r6);
        String r9 = r1.toString();
        int r10 = String.valueOf(r2).length();
        SpannableString r4 = new SpannableString(r9);
        r4.setSpan(new ForegroundColorSpan(ColorProtector.parseColor("#FF3B30")), 0, r10, 33);
        LarusDialogDiaryStyleInputBinding r11 = this.e;
        if (r11 == null) goto L43;
        TextView r12 = r11.f;
        if (r12 == null) goto L43;
        r12.setText(r4);
    L43:
        this.h = false;
        return;
    L31:
        LarusDialogDiaryStyleInputBinding r13 = this.e;
        if (r13 == null) goto L36;
        TextView r14 = r13.f;
        if (r14 == null) goto L36;
        StringBuilder r15 = new StringBuilder();
        r15.append(r2);
        r15.append('/');
        r15.append(r6);
        r14.setText(r15.toString());
    L36:
        Context r16 = getContext();
        if (r16 == null) goto L43;
        LarusDialogDiaryStyleInputBinding r17 = this.e;
        if (r17 == null) goto L43;
        TextView r18 = r17.f;
        if (r18 == null) goto L43;
        r18.setTextColor(ContextCompat.getColor(r16, v19.c.b(2130972081, r16, 2131103143)));
    L23:
        r0 = false;
        goto L25
    L11:
        r3 = false;
        goto L12
    L8:
        r2 = 0;
        goto L9
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r3, r4);
        LarusDialogDiaryStyleInputBinding r5 = this.e;
        if (r5 == null) goto L7;
        EditText r6 = r5.c;
        if (r6 == null) goto L7;
        r6.setOnFocusChangeListener(new a0(this));
    L7:
        LarusDialogDiaryStyleInputBinding r7 = this.e;
        if (r7 == null) goto L12;
        EditText r8 = r7.d;
        if (r8 == null) goto L12;
        r8.setOnFocusChangeListener(new b0(this));
    L12:
        LarusDialogDiaryStyleInputBinding r9 = this.e;
        if (r9 == null) goto L17;
        EditText r10 = r9.c;
        if (r10 == null) goto L17;
        r10.addTextChangedListener(new c0(this));
    L17:
        LarusDialogDiaryStyleInputBinding r11 = this.e;
        if (r11 == null) goto L22;
        EditText r12 = r11.d;
        if (r12 == null) goto L22;
        r12.addTextChangedListener(new d0(this));
    L22:
        Bundle r13 = getArguments();
        boolean r14 = true;
        if (r13 == null) goto L25;
        int r15 = r13.getInt("mode", 1);
    L26:
        if (r15 != 1) goto L45;
        Bundle r16 = getArguments();
        if (r16 == null) goto L36;
        String r17 = r16.getString("name");
        if (r17 == null) goto L36;
        LarusDialogDiaryStyleInputBinding r0 = this.e;
        if (r0 == null) goto L36;
        EditText r1 = r0.c;
        if (r1 == null) goto L36;
        r1.setText(r17);
    L36:
        Bundle r18 = getArguments();
        if (r18 == null) goto L63;
        String r19 = r18.getString("prompt");
        if (r19 == null) goto L63;
        LarusDialogDiaryStyleInputBinding r2 = this.e;
        if (r2 == null) goto L63;
        EditText r20 = r2.d;
        if (r20 == null) goto L63;
        r20.setText(r19);
    L63:
        LarusDialogDiaryStyleInputBinding r21 = this.e;
        if (r21 == null) goto L70;
        EditText r22 = r21.c;
        if (r22 == null) goto L70;
        if (r22.hasFocus() != true) goto L70;
        boolean r23 = true;
    L71:
        Editable r24 = null;
        if (r23 == false) goto L79;
        LarusDialogDiaryStyleInputBinding r25 = this.e;
        if (r25 == null) goto L78;
        EditText r26 = r25.c;
        if (r26 == null) goto L78;
        r24 = r26.getText();
    L78:
        S90(r24);
    L85:
        LarusDialogDiaryStyleInputBinding r27 = this.e;
        if (r27 == null) goto L94;
        EditText r28 = r27.d;
        if (r28 == null) goto L94;
        Editable r29 = r28.getText();
        if (r29 == null) goto L94;
        if ((!StringsKt.isBlank(r29)) != true) goto L94;
    L95:
        W90(r14);
        LarusDialogDiaryStyleInputBinding r30 = this.e;
        if (r30 == null) goto L100;
        TextView r31 = r30.b;
        if (r31 == null) goto L100;
        r31.setOnClickListener(new x(this));
    L100:
        LarusDialogDiaryStyleInputBinding r32 = this.e;
        if (r32 == null) goto L106;
        TextView r33 = r32.e;
        if (r33 == null) goto L107;
        r33.setOnClickListener(new y(this));
        return;
    L107:
        return;
    L106:
        return;
    L94:
        r14 = false;
        goto L95
    L79:
        LarusDialogDiaryStyleInputBinding r34 = this.e;
        if (r34 == null) goto L84;
        EditText r35 = r34.d;
        if (r35 == null) goto L84;
        r24 = r35.getText();
    L84:
        T90(r24);
    L70:
        r23 = false;
        goto L71
    L45:
        Bundle r36 = getArguments();
        if (r36 == null) goto L54;
        String r37 = r36.getString("draft_name");
        if (r37 == null) goto L54;
        LarusDialogDiaryStyleInputBinding r38 = this.e;
        if (r38 == null) goto L54;
        EditText r39 = r38.c;
        if (r39 == null) goto L54;
        r39.setText(r37);
    L54:
        Bundle r40 = getArguments();
        if (r40 == null) goto L63;
        String r41 = r40.getString("draft_prompt");
        if (r41 == null) goto L63;
        LarusDialogDiaryStyleInputBinding r42 = this.e;
        if (r42 == null) goto L63;
        EditText r43 = r42.d;
        if (r43 == null) goto L63;
        r43.setText(r41);
        goto L63
    L25:
        r15 = 1;
        goto L26
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        ConstraintLayout r11 = r8.inflate(2131562057, r9, false);
        int r12 = 2131369061;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r11, 2131369061);
        if (r2 == null) goto L20;
        r12 = 2131369062;
        EditText r3 = (EditText) ViewBindings.findChildViewById(r11, 2131369062);
        if (r3 == null) goto L20;
        r12 = 2131369063;
        EditText r4 = (EditText) ViewBindings.findChildViewById(r11, 2131369063);
        if (r4 == null) goto L20;
        r12 = 2131369064;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r11, 2131369064);
        if (r5 == null) goto L20;
        r12 = 2131369065;
        if (((TextView) ViewBindings.findChildViewById(r11, 2131369065)) == null) goto L20;
        r12 = 2131369070;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r11, 2131369070);
        if (r6 == null) goto L20;
        ConstraintLayout r13 = r11;
        this.e = new LarusDialogDiaryStyleInputBinding(r13, r2, r3, r4, r5, r6);
        if (r13 == null) goto L18;
        return r13;
    L18:
        return new View(getContext());
    L20:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
