package com.obric.aiproactive.ui.feedback;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiproactive.ui.databinding.SheetProactiveValueRatingBinding;
import com.obric.aiproactive.ui.util.ProactiveTopBarIconButton;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.sheet.v2.OSheet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J8\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/aiproactive/ui/feedback/ProactiveValueRatingSheet;", "", "activity", "Landroid/app/Activity;", "store", "Lcom/obric/aiproactive/ui/feedback/ProactiveValueRatingStore;", "<init>", "(Landroid/app/Activity;Lcom/obric/aiproactive/ui/feedback/ProactiveValueRatingStore;)V", "show", "", "recommendationId", "", "targetType", "Lcom/obric/aiproactive/ui/feedback/ProactiveValueTargetType;", "onDismiss", "Lkotlin/Function0;", "onChanged", "Lkotlin/Function1;", "Lcom/obric/aiproactive/ui/feedback/ProactiveValueRating;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f6667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f6668b;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J*\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"com/obric/aiproactive/ui/feedback/ProactiveValueRatingSheet$show$2", "Landroid/text/TextWatcher;", "beforeTextChanged", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", CommonConsts.APM_INNER_EVENT_COST_START, "", CommonConsts.COUNT_TYPE, "after", "onTextChanged", "before", "afterTextChanged", "Landroid/text/Editable;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OEditText f6669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SheetProactiveValueRatingBinding f6670b;
        final /* synthetic */ l c;

        a(OEditText r1, SheetProactiveValueRatingBinding r2, l r3) {
            this.f6669a = r1;
            this.f6670b = r2;
            this.c = r3;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r2) {
            Editable r1 = (Editable) ZeusTransformUtils.wrapperContextForParams(r2, Editable.class, "com.obric.memorydata.plugin");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r1, CharSequence.class, "com.obric.memorydata.plugin");
            l.a(this.f6669a, this.f6670b, this.c);
            l.a(this.f6670b, this.f6669a);
        }
    }

    public l(Activity r3, n r4) {
        Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r4, "store");
        this.f6667a = ZeusTransformUtils.wrapperContext2Activity(r5, "com.obric.memorydata.plugin");
        this.f6668b = r4;
    }

    private static final ProactiveValueSubmitType a(l r1, String r2, j r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        return r1.f6668b.a(r2, r3);
    }

    private static final Unit a(OSheet r0) {
        r0.dismiss();
        return Unit.INSTANCE;
    }

    private static final Unit a(String r7, j r8, ProactiveValueSubmitType r9) {
        Intrinsics.checkNotNullParameter(r8, "savedRating");
        Intrinsics.checkNotNullParameter(r9, "savedSubmitType");
        com.obric.aiproactive.ui.util.h.f6884a.b(r7, r8.a(), r8.b().getWireValue(), r8.c().getWireValue(), r9.getWireValue());
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void a(SheetProactiveValueRatingBinding r0, OEditText r1) {
        b(r0, r1);
    }

    private static final void a(l r2, OEditText r3, SheetProactiveValueRatingBinding r4) {
        InputMethodManager r5 = (InputMethodManager) ZeusTransformUtils.preCheckCast(ContextCompat.getSystemService((Context) ZeusTransformUtils.preCheckCast(r2.f6667a, Context.class, "com.obric.memorydata.plugin"), InputMethodManager.class), InputMethodManager.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L5;
        r5.hideSoftInputFromWindow(r3.getWindowToken(), 0);
    L5:
        r3.clearFocus();
        r4.getRoot().setFocusableInTouchMode(true);
        r4.getRoot().requestFocus();
    }

    public static final /* synthetic */ void a(OEditText r0, SheetProactiveValueRatingBinding r1, l r2) {
        b(r0, r1, r2);
    }

    private static final void a(OEditText r6, ProactiveValueTargetType r7, SheetProactiveValueRatingBinding r8, Function1 r9, OSheet r10, final l r11, final String r12, View r13) {
        Function1 r14 = (Function1) ZeusTransformUtils.wrapperContextForParams(r9, Function1.class, "com.obric.memorydata.plugin");
        Editable r15 = r6.getText();
        if (r15 == null) goto L5;
        String r16 = r15.toString();
    L6:
        if (r16 != null) goto L8;
        r16 = "";
    L8:
        Integer r17 = o.a(r16);
        if (r17 == null) goto L16;
        j r18 = new j(r17.intValue(), ProactiveValueAmountSource.CUSTOM, r7, System.currentTimeMillis());
        r8.btnSubmit.setEnabled(false);
        if (o.a(ProactiveValueSubmissionTrigger.USER_SUBMIT, r18, new $$Lambda$l$28mBKfNGGZKzQNFRp6bMgusKmXA(r11, r12), new $$Lambda$l$B3_7kB0YGfwQznxMrrYxlrybs(r12), r14) != null) goto L14;
        b(r8, r6);
        return;
    L14:
        r10.dismiss();
        return;
    L16:
        return;
    L5:
        r16 = null;
        goto L6
    }

    private static final void a(OEditText r2, l r3) {
        r2.requestFocus();
        Editable r0 = r2.getText();
        if (r0 == null) goto L5;
        int r1 = r0.length();
    L6:
        r2.setSelection(r1);
        InputMethodManager r4 = (InputMethodManager) ZeusTransformUtils.preCheckCast(ContextCompat.getSystemService((Context) ZeusTransformUtils.preCheckCast(r3.f6667a, Context.class, "com.obric.memorydata.plugin"), InputMethodManager.class), InputMethodManager.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L10;
        r4.showSoftInput((View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.memorydata.plugin"), 1);
        return;
    L10:
        return;
    L5:
        r1 = 0;
        goto L6
    }

    private static final void a(Function0 r2, DialogInterface r3) {
        Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        DialogInterface r5 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin");
        r4.invoke();
    }

    private static final boolean a(l r0, OEditText r1, SheetProactiveValueRatingBinding r2, TextView r3, int r4, KeyEvent r5) {
        if (r4 != 6) goto L5;
        a(r0, r1, r2);
        return true;
    L5:
        return false;
    }

    private static final void b(SheetProactiveValueRatingBinding r0, OEditText r1) {
        OButton r2 = r0.btnSubmit;
        Editable r3 = r1.getText();
        if (r3 == null) goto L5;
        String r4 = r3.toString();
    L6:
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        if (o.a(r4) == null) goto L11;
        boolean r5 = true;
    L12:
        r2.setEnabled(r5);
        return;
    L11:
        r5 = false;
        goto L12
    L5:
        r4 = null;
        goto L6
    }

    private static final void b(OEditText r6, SheetProactiveValueRatingBinding r7, l r8) {
        Editable r9 = r6.getText();
        if (r9 == null) goto L5;
        String r10 = r9.toString();
    L6:
        if (r10 != null) goto L8;
        r10 = "";
    L8:
        boolean r2 = true;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L11;
        boolean r0 = true;
    L13:
        if (o.a(r10) == null) goto L15;
        boolean r11 = true;
    L16:
        OInputLayout r4 = r7.inputCustomAmount;
        if (r0 == true) goto L20;
        if (r11 == true) goto L20;
    L21:
        r4.setTextState(r2);
        TextView r3 = r7.tvInputHint;
        if (r11 == true) goto L26;
        if (r0 == true) goto L26;
        int r5 = R.string.proactive_value_custom_error;
        String r12 = "proactive_value_custom_error";
    L27:
        r3.setText(ZeusTransformUtils.mapRes(r5, TypedValues.Custom.S_STRING, r12));
        TextView r13 = r7.tvInputHint;
        Context r14 = (Context) ZeusTransformUtils.preCheckCast(r8.f6667a, Context.class, "com.obric.memorydata.plugin");
        if (r11 == true) goto L32;
        if (r0 == true) goto L32;
        int r15 = R.color.proactive_value_error_text;
        String r1 = "proactive_value_error_text";
    L33:
        r13.setTextColor(ContextCompat.getColor(r14, ZeusTransformUtils.mapRes(r15, TypedValues.Custom.S_COLOR, r1)));
        return;
    L32:
        r15 = R.color.ai_proactive_demo_text_disabled;
        r1 = "ai_proactive_demo_text_disabled";
    L26:
        r5 = R.string.proactive_value_custom_range_hint;
        r12 = "proactive_value_custom_range_hint";
    L20:
        r2 = false;
        goto L21
    L15:
        r11 = false;
        goto L16
    L11:
        r0 = false;
        goto L13
    L5:
        r10 = null;
        goto L6
    }

    /* JADX INFO: renamed from: lambda$-TgV7R8cP-tpcfj2P40kxCMvZXk, reason: not valid java name */
    public static /* synthetic */ void m299lambda$TgV7R8cPtpcfj2P40kxCMvZXk(Function0 r0, DialogInterface r1) {
        a(r0, r1);
    }

    public static /* synthetic */ ProactiveValueSubmitType lambda$28mBKfNGGZKzQNFRp6bMgusKmXA(l r0, String r1, j r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$B3_7kB0Y-GfwQz-nxMrrYxlrybs, reason: not valid java name */
    public static /* synthetic */ Unit m300lambda$B3_7kB0YGfwQznxMrrYxlrybs(String r0, j r1, ProactiveValueSubmitType r2) {
        return a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$BsvVYlCifs-SkuAU9VzVHu-m9fc, reason: not valid java name */
    public static /* synthetic */ void m301lambda$BsvVYlCifsSkuAU9VzVHum9fc(OEditText r0, ProactiveValueTargetType r1, SheetProactiveValueRatingBinding r2, Function1 r3, OSheet r4, l r5, String r6, View r7) {
        a(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    /* JADX INFO: renamed from: lambda$GWIDdlUt8TV8NkIvp0xN-cc6C7E, reason: not valid java name */
    public static /* synthetic */ void m302lambda$GWIDdlUt8TV8NkIvp0xNcc6C7E(OEditText r0, l r1) {
        a(r0, r1);
    }

    public static /* synthetic */ Unit lambda$TAmL2MyrCN1W9jGL915qgx1cndo(OSheet r0) {
        return a(r0);
    }

    public static /* synthetic */ boolean lambda$rR8uV1uJ_A_P6eDcnQjViBBHVks(l r0, OEditText r1, SheetProactiveValueRatingBinding r2, TextView r3, int r4, KeyEvent r5) {
        return a(r0, r1, r2, r3, r4, r5);
    }

    public final void a(final String r19, final ProactiveValueTargetType r20, Function0<Unit> r21, Function1<? super j, Unit> r22) {
        final Function0 r0 = (Function0) ZeusTransformUtils.wrapperContextForParams(r21, Function0.class, "com.obric.memorydata.plugin");
        final Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r22, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r19, "recommendationId");
        Intrinsics.checkNotNullParameter(r20, "targetType");
        Intrinsics.checkNotNullParameter(r0, "onDismiss");
        Intrinsics.checkNotNullParameter(r4, "onChanged");
        k r1 = m.a(this.f6668b.a(r19));
        final OSheet r6 = new OSheet((Context) ZeusTransformUtils.preCheckCast(this.f6667a, Context.class, "com.obric.memorydata.plugin"), 0, 0, false, false, 30, null);
        r6.a(OSheet.HeightMode.WRAP_HEIGHT);
        int r3 = 0;
        r6.e(false);
        r6.setOnDismissListener(new $$Lambda$l$TgV7R8cPtpcfj2P40kxCMvZXk(r0));
        final SheetProactiveValueRatingBinding r10 = SheetProactiveValueRatingBinding.inflate(this.f6667a.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(r10, "inflate(...)");
        r10.getRoot().setBackgroundColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(this.f6667a, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.ai_proactive_demo_sheet_bg, TypedValues.Custom.S_COLOR, "ai_proactive_demo_sheet_bg")));
        r10.tvTitle.setText(ZeusTransformUtils.mapRes(R.string.proactive_value_question, TypedValues.Custom.S_STRING, "proactive_value_question"));
        r10.btnSubmit.setText(ZeusTransformUtils.mapRes(R.string.proactive_value_submit, TypedValues.Custom.S_STRING, "proactive_value_submit"));
        ProactiveTopBarIconButton r2 = r10.btnClose;
        Intrinsics.checkNotNullExpressionValue(r2, "btnClose");
        com.obric.aiproactive.ui.util.m.a((OIconButtonFloating) ZeusTransformUtils.preCheckCast(r2, OIconButtonFloating.class, "com.obric.memorydata.plugin"), new $$Lambda$l$TAmL2MyrCN1W9jGL915qgx1cndo(r6));
        final OEditText r11 = r10.inputCustomAmount.getVInput();
        r11.setInputType(2);
        r11.setImeOptions(6);
        r11.setSingleLine(true);
        r11.setMaxLines(1);
        r11.setFilters((InputFilter[]) ZeusTransformUtils.preCheckCast(new com.obric.aiproactive.ui.feedback.a[]{new com.obric.aiproactive.ui.feedback.a()}, InputFilter[].class, "com.obric.memorydata.plugin"));
        r11.setText((CharSequence) ZeusTransformUtils.preCheckCast(r1.a(), CharSequence.class, "com.obric.memorydata.plugin"));
        Editable r5 = r11.getText();
        if (r5 == null) goto L5;
        r3 = r5.length();
    L5:
        r11.setSelection(r3);
        r11.addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(new a(r11, r10, this), TextWatcher.class, "com.obric.memorydata.plugin"));
        r11.setOnEditorActionListener(new $$Lambda$l$rR8uV1uJ_A_P6eDcnQjViBBHVks(this, r11, r10));
        r10.btnSubmit.setOnClickListener(new $$Lambda$l$BsvVYlCifsSkuAU9VzVHum9fc(r11, r20, r10, r4, r6, this, r19));
        b(r11, r10, this);
        b(r10, r11);
        r6.c((View) ZeusTransformUtils.preCheckCast(r10.getRoot(), View.class, "com.obric.memorydata.plugin"));
        r6.show();
        r11.postDelayed(new $$Lambda$l$GWIDdlUt8TV8NkIvp0xNcc6C7E(r11, this), 220);
    }
}
