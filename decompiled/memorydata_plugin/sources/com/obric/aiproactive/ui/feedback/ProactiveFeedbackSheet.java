package com.obric.aiproactive.ui.feedback;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.google.android.material.card.MaterialCardView;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.chip.OChipGroup;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.sheet.v2.OSheet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J<\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00070\u000fJ:\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000b2\u0018\u0010\u0016\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0004\u0012\u00020\u00070\u000fH\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002JF\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0018\u0010\u0016\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0004\u0012\u00020\u00070\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/aiproactive/ui/feedback/ProactiveFeedbackSheet;", "", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "show", "", "mode", "Lcom/obric/aiproactive/ui/feedback/ProactiveFeedbackSheet$Mode;", "initialInput", "Lcom/obric/aiproactive/ui/feedback/ProactiveFeedbackInitialInput;", "onDismiss", "Lkotlin/Function0;", "onConfirm", "Lkotlin/Function1;", "Lcom/obric/aiproactive/ui/feedback/ProactiveFeedbackResult;", "bindOptions", "view", "Landroid/view/View;", "contentSpec", "Lcom/obric/aiproactive/ui/feedback/ProactiveFeedbackContentSpec;", "onReasonChanged", "", "", "collectDetail", "collectUploadChecked", "", "renderChips", "chipGroup", "Lcom/obric/oui/chip/OChipGroup;", "reasons", "selectedReasons", "Mode", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveFeedbackSheet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f6644a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/aiproactive/ui/feedback/ProactiveFeedbackSheet$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "LIKE", "DISLIKE", "GENERIC", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode DISLIKE = null;
        public static final Mode GENERIC = null;
        public static final Mode LIKE = null;

        private static final /* synthetic */ Mode[] $values() {
            return new Mode[]{LIKE, DISLIKE, GENERIC};
        }

        static {
            LIKE = new Mode("LIKE", 0);
            DISLIKE = new Mode("DISLIKE", 1);
            GENERIC = new Mode("GENERIC", 2);
            Mode[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private Mode(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<Mode> getEntries() {
            return $ENTRIES;
        }

        public static Mode valueOf(String r2) {
            return (Mode) ZeusTransformUtils.preCheckCast(Enum.valueOf(Mode.class, r2), Mode.class, "com.obric.memorydata.plugin");
        }

        public static Mode[] values() {
            return (Mode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Mode[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J*\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"com/obric/aiproactive/ui/feedback/ProactiveFeedbackSheet$show$6", "Landroid/text/TextWatcher;", "beforeTextChanged", "", "s", "", CommonConsts.APM_INNER_EVENT_COST_START, "", CommonConsts.COUNT_TYPE, "after", "onTextChanged", "before", "afterTextChanged", "Landroid/text/Editable;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f6645a;

        a(Function0<Unit> r3) {
            this.f6645a = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
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
            this.f6645a.invoke();
        }
    }

    public ProactiveFeedbackSheet(Activity r3) {
        Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "activity");
        this.f6644a = ZeusTransformUtils.wrapperContext2Activity(r4, "com.obric.memorydata.plugin");
    }

    private final String a(View r3) {
        OInputLayout r2 = (OInputLayout) ZeusTransformUtils.preCheckCast(r3.findViewById(ZeusTransformUtils.mapRes(R.id.et_feedback_detail, OaidModel.KEY_ID, "et_feedback_detail")), OInputLayout.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L11;
        OEditText r4 = r2.getVInput();
        if (r4 == null) goto L11;
        Editable r5 = r4.getText();
        if (r5 == null) goto L11;
        String r6 = r5.toString();
        if (r6 == null) goto L11;
        String r7 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L12:
        if (r7 != null) goto L15;
        return "";
    L15:
        return r7;
    L11:
        r7 = null;
        goto L12
    }

    private static final Unit a() {
        return Unit.INSTANCE;
    }

    private static final Unit a(OSheet r0) {
        r0.dismiss();
        return Unit.INSTANCE;
    }

    private static final Unit a(Ref.ObjectRef r2, OInputLayout r3, View r4) {
        List r5 = (List) ZeusTransformUtils.preCheckCast(r2.element, List.class, "com.obric.memorydata.plugin");
        Editable r6 = r3.getVInput().getText();
        if (r6 == null) goto L5;
        String r7 = r6.toString();
    L6:
        if (r7 != null) goto L8;
        r7 = "";
    L8:
        boolean r8 = f.a(r5, StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).toString());
        r4.setEnabled(r8);
        if (r8 == false) goto L11;
        float r9 = 1.0f;
    L12:
        r4.setAlpha(r9);
        return Unit.INSTANCE;
    L11:
        r9 = 0.4f;
        goto L12
    L5:
        r7 = null;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [T, java.lang.Object, java.util.List] */
    private static final Unit a(Ref.ObjectRef r2, Function0 r3, List r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        ?? r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "reasons");
        r2.element = r6;
        r5.invoke();
        return Unit.INSTANCE;
    }

    private final void a(View r8, b r9, c r10, Function1<? super List<String>, Unit> r11) {
        Function1<? super List<String>, Unit> r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        OInputLayout r0 = (OInputLayout) ZeusTransformUtils.preCheckCast(r8.findViewById(ZeusTransformUtils.mapRes(R.id.et_feedback_detail, OaidModel.KEY_ID, "et_feedback_detail")), OInputLayout.class, "com.obric.memorydata.plugin");
        r0.setType(1);
        OEditText r1 = r0.getVInput();
        String r3 = r9.e();
        if (r3 != null) goto L6;
        r3 = this.f6644a.getString(r9.b());
        Intrinsics.checkNotNullExpressionValue(r3, "getString(...)");
    L6:
        r1.setHint((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"));
        r1.setTextSize(16.0f);
        r1.setTextColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(this.f6644a, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.ai_proactive_demo_text_primary, TypedValues.Custom.S_COLOR, "ai_proactive_demo_text_primary")));
        r1.setHintTextColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(this.f6644a, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.ai_proactive_demo_text_tertiary, TypedValues.Custom.S_COLOR, "ai_proactive_demo_text_tertiary")));
        r1.setSingleLine(false);
        r1.setGravity(MaterialCardView.CHECKED_ICON_GRAVITY_TOP_START);
        r1.setTextAlignment(5);
        r1.setHorizontallyScrolling(false);
        OCheckBox r2 = (OCheckBox) ZeusTransformUtils.preCheckCast(r8.findViewById(ZeusTransformUtils.mapRes(R.id.cb_feedback_upload, OaidModel.KEY_ID, "cb_feedback_upload")), OCheckBox.class, "com.obric.memorydata.plugin");
        r2.setVisibility(8);
        r2.setChecked(false);
        OChipGroup r13 = (OChipGroup) ZeusTransformUtils.preCheckCast(r8.findViewById(ZeusTransformUtils.mapRes(R.id.chip_group, OaidModel.KEY_ID, "chip_group")), OChipGroup.class, "com.obric.memorydata.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(r9.d(), Collection.class, "com.obric.memorydata.plugin");
        if (r4.isEmpty() == false) goto L13;
        Iterable r14 = (Iterable) ZeusTransformUtils.preCheckCast(r9.c(), Iterable.class, "com.obric.memorydata.plugin");
        Activity r5 = this.f6644a;
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r15 = r14.iterator();
    L10:
        if (r15.hasNext() == false) goto L12;
        r6.add(r5.getString(((Number) ZeusTransformUtils.preCheckCast(r15.next(), Number.class, "com.obric.memorydata.plugin")).intValue()));
        goto L10
    L12:
        r4 = (List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
    L13:
        List<String> r16 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r13);
        a(r13, r16, r10.a(), r12);
    }

    public static /* synthetic */ void a(ProactiveFeedbackSheet r1, Mode r2, c r3, Function0 r4, Function1 r5, int r6, Object r7) {
        Function0<Unit> r8 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        Function1<? super d, Unit> r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = new c(null, null, 3, null);
    L6:
        if ((r6 & 4) == 0) goto L8;
        r8 = $$Lambda$ProactiveFeedbackSheet$SjRy1JyK38vWgY4HyOxrHAHBmBU.INSTANCE;
    L8:
        r1.a(r2, r3, r8, r9);
    }

    private final void a(final OChipGroup r17, List<String> r18, List<String> r19, Function1<? super List<String>, Unit> r20) {
        final List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        final List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
        final Function1 r11 = (Function1) ZeusTransformUtils.wrapperContextForParams(r20, Function1.class, "com.obric.memorydata.plugin");
        LayoutInflater r12 = LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r17.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        r17.removeAllViews();
        Iterator r13 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        final String r2 = (String) ZeusTransformUtils.preCheckCast(r13.next(), String.class, "com.obric.memorydata.plugin");
        View r0 = ZeusTransformUtils.inflate(r12, ZeusTransformUtils.mapRes(R.layout.item_proactive_feedback_ochip, "layout", "item_proactive_feedback_ochip"), (ViewGroup) ZeusTransformUtils.preCheckCast(r17, ViewGroup.class, "com.obric.memorydata.plugin"), false, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatTextView");
        AppCompatTextView r14 = (AppCompatTextView) ZeusTransformUtils.preCheckCast(r0, AppCompatTextView.class, "com.obric.memorydata.plugin");
        r14.setText((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"));
        boolean r1 = r10.contains(r2);
        r14.setSelected(r1);
        r14.setActivated(r1);
        r14.setOnClickListener(new $$Lambda$ProactiveFeedbackSheet$rDWmey9KOLPfIA2ZLxFajmT_k(r10, r2, r11, this, r17, r9));
        r17.addView((View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.memorydata.plugin"));
        goto L4
    }

    private static final void a(List r1, String r2, Function1 r3, ProactiveFeedbackSheet r4, OChipGroup r5, List r6, View r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r1, List.class, "com.obric.memorydata.plugin");
        Function1<? super List<String>, Unit> r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        List<String> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List<String> r11 = f.b(r8, r2);
        r9.invoke(r11);
        r4.a(r5, r10, r11, r9);
    }

    private static final void a(Ref.BooleanRef r2, Function0 r3, DialogInterface r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        DialogInterface r6 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r4, DialogInterface.class, "com.obric.memorydata.plugin");
        if (r2.element == true) goto L6;
        r5.invoke();
        return;
    }

    private static final void a(Ref.BooleanRef r1, Function1 r2, Ref.ObjectRef r3, ProactiveFeedbackSheet r4, View r5, OSheet r6, View r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        r1.element = true;
        List r9 = (List) ZeusTransformUtils.preCheckCast(r3.element, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r5);
        r8.invoke(new d(r9, r4.a(r5), r4.b(r5)));
        r6.dismiss();
    }

    private final boolean b(View r1) {
        return false;
    }

    /* JADX INFO: renamed from: lambda$GNxiA9PAsAMnsKnHH0-uVgMli5k, reason: not valid java name */
    public static /* synthetic */ void m294lambda$GNxiA9PAsAMnsKnHH0uVgMli5k(Ref.BooleanRef r0, Function1 r1, Ref.ObjectRef r2, ProactiveFeedbackSheet r3, View r4, OSheet r5, View r6) {
        a(r0, r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: lambda$PkbY-H-Oi4Vl-EmFce0Op3JPocw, reason: not valid java name */
    public static /* synthetic */ Unit m295lambda$PkbYHOi4VlEmFce0Op3JPocw(Ref.ObjectRef r0, Function0 r1, List r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$SjRy1JyK38vWgY4HyOxrHAHBmBU() {
        return a();
    }

    /* JADX INFO: renamed from: lambda$UoF__6Ckwa-v9a_p1cseyCJIut0, reason: not valid java name */
    public static /* synthetic */ Unit m296lambda$UoF__6Ckwav9a_p1cseyCJIut0(OSheet r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$csI-ZoZkRCN7J9Y_eR61xsMCXBY, reason: not valid java name */
    public static /* synthetic */ void m297lambda$csIZoZkRCN7J9Y_eR61xsMCXBY(Ref.BooleanRef r0, Function0 r1, DialogInterface r2) {
        a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$rDW-mey9KOLPfIA2-ZLxFajmT_k, reason: not valid java name */
    public static /* synthetic */ void m298lambda$rDWmey9KOLPfIA2ZLxFajmT_k(List r0, String r1, Function1 r2, ProactiveFeedbackSheet r3, OChipGroup r4, List r5, View r6) {
        a(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit lambda$vq2W1k2O8LMa6vx9DqYC6LR0vJI(Ref.ObjectRef r0, OInputLayout r1, View r2) {
        return a(r0, r1, r2);
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [T, java.util.List] */
    public final void a(Mode r21, c r22, Function0<Unit> r23, Function1<? super d, Unit> r24) {
        final Function0 r1 = (Function0) ZeusTransformUtils.wrapperContextForParams(r23, Function0.class, "com.obric.memorydata.plugin");
        final Function1 r2 = (Function1) ZeusTransformUtils.wrapperContextForParams(r24, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r21, "mode");
        Intrinsics.checkNotNullParameter(r22, "initialInput");
        Intrinsics.checkNotNullParameter(r1, "onDismiss");
        Intrinsics.checkNotNullParameter(r2, "onConfirm");
        e r3 = f.a();
        b r10 = f.a(r21, r3);
        IRunLog r11 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder().append("[FeedbackSheet] show mode=").append(r21).append(" source=");
        if (r3 != null) goto L5;
        String r4 = "fallback";
    L6:
        IRunLog.a.a(r11, "ProactiveUI", r0.append(r4).append(" reasons=").append(r10.d().size()).toString(), false, 4, null);
        final Ref.ObjectRef r12 = new Ref.ObjectRef();
        r12.element = r22.a();
        final Ref.BooleanRef r5 = new Ref.BooleanRef();
        final OSheet r6 = new OSheet((Context) ZeusTransformUtils.preCheckCast(this.f6644a, Context.class, "com.obric.memorydata.plugin"), 0, 0, false, false, 30, null);
        final View r13 = ZeusTransformUtils.inflate(this.f6644a.getLayoutInflater(), ZeusTransformUtils.mapRes(R.layout.sheet_proactive_feedback_form, "layout", "sheet_proactive_feedback_form"), null, "com.obric.memorydata.plugin");
        r13.setBackgroundColor(ContextCompat.getColor((Context) ZeusTransformUtils.preCheckCast(this.f6644a, Context.class, "com.obric.memorydata.plugin"), ZeusTransformUtils.mapRes(R.color.ai_proactive_demo_sheet_bg, TypedValues.Custom.S_COLOR, "ai_proactive_demo_sheet_bg")));
        r6.a(OSheet.HeightMode.WRAP_HEIGHT);
        r6.e(false);
        r6.setOnDismissListener(new $$Lambda$ProactiveFeedbackSheet$csIZoZkRCN7J9Y_eR61xsMCXBY(r5, r1));
        TextView r7 = (TextView) ZeusTransformUtils.preCheckCast(r13.findViewById(ZeusTransformUtils.mapRes(R.id.tv_title, OaidModel.KEY_ID, "tv_title")), TextView.class, "com.obric.memorydata.plugin");
        OIconButtonFloating r8 = (OIconButtonFloating) ZeusTransformUtils.preCheckCast(r13.findViewById(ZeusTransformUtils.mapRes(R.id.btn_close, OaidModel.KEY_ID, "btn_close")), OIconButtonFloating.class, "com.obric.memorydata.plugin");
        final View r14 = r13.findViewById(ZeusTransformUtils.mapRes(R.id.btn_submit, OaidModel.KEY_ID, "btn_submit"));
        r7.setText(r10.a());
        Intrinsics.checkNotNull(r8);
        com.obric.aiproactive.ui.util.m.a(r8, new $$Lambda$ProactiveFeedbackSheet$UoF__6Ckwav9a_p1cseyCJIut0(r6));
        r14.setOnClickListener(new $$Lambda$ProactiveFeedbackSheet$GNxiA9PAsAMnsKnHH0uVgMli5k(r5, r2, r12, this, r13, r6));
        final OInputLayout r9 = (OInputLayout) ZeusTransformUtils.preCheckCast(r13.findViewById(ZeusTransformUtils.mapRes(R.id.et_feedback_detail, OaidModel.KEY_ID, "et_feedback_detail")), OInputLayout.class, "com.obric.memorydata.plugin");
        final Function0 r15 = new $$Lambda$ProactiveFeedbackSheet$vq2W1k2O8LMa6vx9DqYC6LR0vJI(r12, r9, r14);
        Intrinsics.checkNotNull(r13);
        a(r13, r10, r22, new $$Lambda$ProactiveFeedbackSheet$PkbYHOi4VlEmFce0Op3JPocw(r12, r15));
        r9.getVInput().setText((CharSequence) ZeusTransformUtils.preCheckCast(r22.b(), CharSequence.class, "com.obric.memorydata.plugin"));
        r15.invoke();
        r9.getVInput().addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(new a(r15), TextWatcher.class, "com.obric.memorydata.plugin"));
        r6.c(r13);
        r6.show();
        return;
    L5:
        r4 = "settings";
        goto L6
    }
}
