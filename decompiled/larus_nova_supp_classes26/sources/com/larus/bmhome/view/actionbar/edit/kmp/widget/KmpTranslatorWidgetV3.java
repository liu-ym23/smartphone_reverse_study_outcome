package com.larus.bmhome.view.actionbar.edit.kmp.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import bt8.a2;
import bt8.b2;
import bt8.c2;
import bt8.d2;
import bt8.f2;
import bt8.g2;
import bt8.h2;
import bt8.i2;
import bt8.j1;
import bt8.j2;
import bt8.k1;
import bt8.k2;
import bt8.l1;
import bt8.l2;
import bt8.m0;
import bt8.m1;
import bt8.m2;
import bt8.n1;
import bt8.o1;
import bt8.p1;
import bt8.q1;
import bt8.r1;
import bt8.s1;
import bt8.t1;
import bt8.u1;
import bt8.v1;
import bt8.w1;
import bt8.x1;
import bt8.y1;
import bt8.z1;
import com.larus.bmhome.actionbar.model.h;
import com.larus.bmhome.actionbar.model.l0;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.core.model.widget.TranslatorSelectorType;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.component.DropdownItemAdapter;
import com.larus.bmhome.view.actionbar.edit.component.b1;
import com.larus.instruction.impl.databinding.LarusItemActionbarDropdownListBinding;
import com.larus.instruction.impl.databinding.LarusLayoutActionBarEditorWidgetTranslatorV3Binding;
import com.larus.utils.e1;
import com.skydoves.balloon.Balloon;
import cq8.a0;
import cq8.v0;
import cq8.w0;
import cq8.z;
import cq8.z0;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u00ad\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u000358;\u0018\u00002\u00060\u0001j\u0002`\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010=\u001a\u00020>2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010?\u001a\u00020>2\u0006\u0010\r\u001a\u00020@H\u0014J\u000e\u0010A\u001a\u00020>2\u0006\u0010\r\u001a\u00020\u000eJ\u0012\u0010B\u001a\u00020>2\b\u0010C\u001a\u0004\u0018\u00010DH\u0002J\u0012\u0010E\u001a\u00020>2\b\u0010C\u001a\u0004\u0018\u00010DH\u0002J\u0012\u0010F\u001a\u00020>2\b\u0010C\u001a\u0004\u0018\u00010DH\u0002J¸\u0001\u0010G\u001a\u00020>2\u0006\u0010H\u001a\u00020I2\b\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010J\u001a\u00020\u001a2\u000e\u0010K\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010D0L2\u000e\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0L2\u0014\u0010N\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0004\u0012\u00020>0O2\u0006\u0010P\u001a\u00020\u00142\u000e\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120L2\u0014\u0010R\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020>0O2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020!0L2\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020>0O2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020XH\u0002J\u0010\u0010Y\u001a\u00020>2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\"\u0010Z\u001a\u00020>2\b\u0010[\u001a\u0004\u0018\u00010D2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020\bH\u0002J\"\u0010_\u001a\u00020>2\b\u0010[\u001a\u0004\u0018\u00010D2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020\bH\u0002J\u001a\u0010`\u001a\u00020\b2\b\u0010[\u001a\u0004\u0018\u00010D2\u0006\u0010^\u001a\u00020\bH\u0002J\u0012\u0010a\u001a\u00020\b2\b\u0010[\u001a\u0004\u0018\u00010DH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0018\u001a\u0004\b$\u0010\u0016R\u001b\u0010&\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0018\u001a\u0004\b'\u0010\u001cR\u0010\u0010)\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010,\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0018\u001a\u0004\b-\u0010\u0016R\u001b\u0010/\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0018\u001a\u0004\b0\u0010\u001cR\u0010\u00102\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0004\n\u0002\u00106R\u0010\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0004\n\u0002\u00109R\u0010\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0004\n\u0002\u0010<¨\u0006b"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpTranslatorWidgetV3;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/AbsKmpInstructionWidget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetTranslatorV3Binding;", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/TranslatorDescriptor;", "currentTemplate", "Lcom/larus/bmhome/actionbar/model/ActionBarTranslatorBoxTemplate;", "sourceLanguageBalloon", "Lcom/skydoves/balloon/Balloon;", "sourceLanguagePopupView", "Landroid/view/View;", "getSourceLanguagePopupView", "()Landroid/view/View;", "sourceLanguagePopupView$delegate", "Lkotlin/Lazy;", "sourceLanguageRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getSourceLanguageRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "sourceLanguageRecyclerView$delegate", "sourceLanguageItemAdapter", "Lcom/larus/bmhome/view/actionbar/edit/component/DropdownItemAdapter;", "sourceDismissTime", "", "targetLanguageBalloon", "targetLanguagePopupView", "getTargetLanguagePopupView", "targetLanguagePopupView$delegate", "targetLanguageRecyclerView", "getTargetLanguageRecyclerView", "targetLanguageRecyclerView$delegate", "targetLanguageItemAdapter", "targetDismissTime", "modeBalloon", "modePopupView", "getModePopupView", "modePopupView$delegate", "modeRecyclerView", "getModeRecyclerView", "modeRecyclerView$delegate", "modeItemAdapter", "modeDismissTime", "sourceLanguageSelectedCallback", "com/larus/bmhome/view/actionbar/edit/kmp/widget/KmpTranslatorWidgetV3$sourceLanguageSelectedCallback$1", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpTranslatorWidgetV3$sourceLanguageSelectedCallback$1;", "targetLanguageSelectedCallback", "com/larus/bmhome/view/actionbar/edit/kmp/widget/KmpTranslatorWidgetV3$targetLanguageSelectedCallback$1", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpTranslatorWidgetV3$targetLanguageSelectedCallback$1;", "modeSelectedCallback", "com/larus/bmhome/view/actionbar/edit/kmp/widget/KmpTranslatorWidgetV3$modeSelectedCallback$1", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpTranslatorWidgetV3$modeSelectedCallback$1;", "init", "", "onDescriptorChanged", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "bind", "renderSourceLanguageSelector", "data", "Lcom/larus/bmhome/actionbar/model/ActionBarDropdownBox;", "renderTargetLanguageSelector", "renderModeSelector", "bindDropdown", "itemBinding", "Lcom/larus/instruction/impl/databinding/LarusItemActionbarDropdownListBinding;", "recyclerView", "getDropdown", "Lkotlin/Function0;", "getItemAdapter", "setItemAdapter", "Lkotlin/Function1;", "popupView", "getBalloon", "setBalloon", "getDismissTime", "setDismissTime", "selectedCallback", "Lcom/larus/bmhome/view/actionbar/edit/component/DropdownSelectorHolderCallback;", "singleOptionHideArrow", "", "renderWidgetChrome", "reportOptionShow", "dropdown", "option", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "optionPosition", "reportOptionClick", "calculateIsDefault", "calculateIsChooseRequired", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpTranslatorWidgetV3 extends AbsKmpInstructionWidget {
    public static final /* synthetic */ int A = 0;
    public LarusLayoutActionBarEditorWidgetTranslatorV3Binding f;
    public v0 g;
    public l0 h;
    public Balloon i;
    public final Lazy j;
    public final Lazy k;
    public DropdownItemAdapter l;
    public long m;
    public Balloon n;
    public final Lazy o;
    public final Lazy p;
    public DropdownItemAdapter q;
    public long r;
    public Balloon s;
    public final Lazy t;
    public final Lazy u;
    public DropdownItemAdapter v;
    public long w;
    public final b x;
    public final c y;
    public final a z;

    public static final class a implements b1 {
        public final /* synthetic */ KmpTranslatorWidgetV3 a;

        public a(KmpTranslatorWidgetV3 r1) {
            this.a = r1;
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final void b(int r1, w r2) {
            Intrinsics.checkNotNullParameter(r2, "selectedSpinnerItem");
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final void a(int r6, w r7, int r8) {
            Intrinsics.checkNotNullParameter(r7, "selectedSpinnerItem");
            Balloon r9 = this.a.s;
            if (r9 == null) goto L5;
            r9.h();
        L5:
            v0 r10 = this.a.g;
            if (r10 == null) goto L17;
            z r0 = r10.d;
            if (r0 == null) goto L17;
            String r11 = r10.c;
            if (r11 != null) goto L12;
            r11 = "";
        L12:
            TranslatorSelectorType r2 = TranslatorSelectorType.VOICE;
            Long r3 = r7.a;
            if (r3 == null) goto L15;
            long r4 = r3.longValue();
        L16:
            r0.a(new w0(r11, r2, r4));
            goto L17
        L15:
            r4 = 0;
        L17:
            KmpTranslatorWidgetV3 r12 = this.a;
            l0 r1 = r12.h;
            if (r1 == null) goto L20;
            h r5 = r1.c;
        L21:
            KmpTranslatorWidgetV3.b6(r12, r5, r7, r8);
            return;
        L20:
            r5 = null;
            goto L21
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final boolean c(int r1, w r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "selectedSpinnerItem");
            return false;
        }
    }

    public static final class b implements b1 {
        public final /* synthetic */ KmpTranslatorWidgetV3 a;

        public b(KmpTranslatorWidgetV3 r1) {
            this.a = r1;
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final void b(int r1, w r2) {
            Intrinsics.checkNotNullParameter(r2, "selectedSpinnerItem");
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final void a(int r6, w r7, int r8) {
            Intrinsics.checkNotNullParameter(r7, "selectedSpinnerItem");
            Balloon r9 = this.a.i;
            if (r9 == null) goto L5;
            r9.h();
        L5:
            v0 r10 = this.a.g;
            if (r10 == null) goto L17;
            z r0 = r10.d;
            if (r0 == null) goto L17;
            String r11 = r10.c;
            if (r11 != null) goto L12;
            r11 = "";
        L12:
            TranslatorSelectorType r2 = TranslatorSelectorType.SOURCE;
            Long r3 = r7.a;
            if (r3 == null) goto L15;
            long r4 = r3.longValue();
        L16:
            r0.a(new w0(r11, r2, r4));
            goto L17
        L15:
            r4 = 0;
        L17:
            KmpTranslatorWidgetV3 r12 = this.a;
            l0 r1 = r12.h;
            if (r1 == null) goto L20;
            h r5 = r1.a;
        L21:
            KmpTranslatorWidgetV3.b6(r12, r5, r7, r8);
            return;
        L20:
            r5 = null;
            goto L21
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final boolean c(int r1, w r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "selectedSpinnerItem");
            return false;
        }
    }

    public static final class c implements b1 {
        public final /* synthetic */ KmpTranslatorWidgetV3 a;

        public c(KmpTranslatorWidgetV3 r1) {
            this.a = r1;
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final void b(int r1, w r2) {
            Intrinsics.checkNotNullParameter(r2, "selectedSpinnerItem");
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final void a(int r6, w r7, int r8) {
            Intrinsics.checkNotNullParameter(r7, "selectedSpinnerItem");
            Balloon r9 = this.a.n;
            if (r9 == null) goto L5;
            r9.h();
        L5:
            v0 r10 = this.a.g;
            if (r10 == null) goto L17;
            z r0 = r10.d;
            if (r0 == null) goto L17;
            String r11 = r10.c;
            if (r11 != null) goto L12;
            r11 = "";
        L12:
            TranslatorSelectorType r2 = TranslatorSelectorType.TARGET;
            Long r3 = r7.a;
            if (r3 == null) goto L15;
            long r4 = r3.longValue();
        L16:
            r0.a(new w0(r11, r2, r4));
            goto L17
        L15:
            r4 = 0;
        L17:
            KmpTranslatorWidgetV3 r12 = this.a;
            l0 r1 = r12.h;
            if (r1 == null) goto L20;
            h r5 = r1.b;
        L21:
            KmpTranslatorWidgetV3.b6(r12, r5, r7, r8);
            return;
        L20:
            r5 = null;
            goto L21
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final boolean c(int r1, w r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "selectedSpinnerItem");
            return false;
        }
    }

    public KmpTranslatorWidgetV3(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KmpTranslatorWidgetV3(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final View getModePopupView() {
        return (View) this.t.getValue();
    }

    private final RecyclerView getModeRecyclerView() {
        return (RecyclerView) this.u.getValue();
    }

    private final View getSourceLanguagePopupView() {
        return (View) this.j.getValue();
    }

    private final RecyclerView getSourceLanguageRecyclerView() {
        return (RecyclerView) this.k.getValue();
    }

    private final View getTargetLanguagePopupView() {
        return (View) this.o.getValue();
    }

    private final RecyclerView getTargetLanguageRecyclerView() {
        return (RecyclerView) this.p.getValue();
    }

    public static RecyclerView V5(KmpTranslatorWidgetV3 r1) {
        return r1.getTargetLanguagePopupView().findViewById(2131382753);
    }

    public static RecyclerView Y5(KmpTranslatorWidgetV3 r1) {
        return r1.getSourceLanguagePopupView().findViewById(2131382753);
    }

    public static RecyclerView Z5(KmpTranslatorWidgetV3 r1) {
        return r1.getModePopupView().findViewById(2131382753);
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void T5(a0 r19) {
        a0 r0 = r19;
        Intrinsics.checkNotNullParameter(r0, "descriptor");
        LarusLayoutActionBarEditorWidgetTranslatorV3Binding r15 = null;
        if ((r0 instanceof v0) == true) goto L5;
        r0 = null;
    L5:
        v0 r1 = (v0) r0;
        if (r1 == null) goto L100;
        Intrinsics.checkNotNullParameter(r1, "descriptor");
        this.g = r1;
        l0 r2 = r1.f;
        if (r2 == null) goto L11;
        l0 r3 = l0.d(r2, m0.a(r2.a), m0.a(r2.b), m0.a(r2.c), 24);
    L12:
        this.h = r3;
        String r4 = r1.h;
        boolean r16 = true;
        if (r4 != null) goto L15;
    L19:
        r4 = r1.g;
        if (r4 != null) goto L22;
    L24:
        r4 = null;
    L26:
        if (r4 != null) goto L31;
        LarusLayoutActionBarEditorWidgetTranslatorV3Binding r5 = this.f;
        if (r5 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L30:
        e1.o(r5.f);
    L39:
        if (r1.i == false) goto L44;
        LarusLayoutActionBarEditorWidgetTranslatorV3Binding r6 = this.f;
        if (r6 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L43:
        e1.x(r6.b);
    L48:
        l0 r7 = this.h;
        if (r7 == null) goto L51;
        h r8 = r7.a;
    L52:
        LarusLayoutActionBarEditorWidgetTranslatorV3Binding r9 = this.f;
        if (r9 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L55:
        e1.o(r9.c.c);
        LarusLayoutActionBarEditorWidgetTranslatorV3Binding r10 = this.f;
        if (r10 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L58:
        c6(r10.c, r8, getSourceLanguageRecyclerView(), new n1(this), new o1(this), new p1(this), getSourceLanguagePopupView(), new q1(this), new r1(this), new s1(this), new t1(this), this.x, true);
        l0 r11 = this.h;
        if (r11 == null) goto L61;
        h r12 = r11.b;
    L62:
        LarusLayoutActionBarEditorWidgetTranslatorV3Binding r13 = this.f;
        if (r13 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L65:
        e1.o(r13.d.c);
        LarusLayoutActionBarEditorWidgetTranslatorV3Binding r14 = this.f;
        if (r14 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L68:
        c6(r14.d, r12, getTargetLanguageRecyclerView(), new j2(this), new k2(this), new l2(this), getTargetLanguagePopupView(), new m2(this), new k1(this), new l1(this), new m1(this), this.y, true);
        l0 r17 = this.h;
        if (r17 == null) goto L71;
        h r18 = r17.c;
    L72:
        if (r18 == null) goto L74;
        List r20 = r18.e;
    L75:
        List r21 = r20;
        if (r21 != null) goto L78;
    L81:
        if (r16 == false) goto L87;
        LarusLayoutActionBarEditorWidgetTranslatorV3Binding r22 = this.f;
        if (r22 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L86:
        e1.o(r15.e.a);
        return;
    L85:
        r15 = r22;
        goto L86
    L87:
        LarusLayoutActionBarEditorWidgetTranslatorV3Binding r23 = this.f;
        if (r23 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r23 = null;
    L90:
        e1.x(r23.e.a);
        LarusLayoutActionBarEditorWidgetTranslatorV3Binding r24 = this.f;
        if (r24 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r24 = null;
    L93:
        e1.o(r24.e.c);
        LarusLayoutActionBarEditorWidgetTranslatorV3Binding r25 = this.f;
        if (r25 != null) goto L96;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L97:
        c6(r15.e, r18, getModeRecyclerView(), new v1(this), new w1(this), new x1(this), getModePopupView(), new y1(this), new z1(this), new a2(this), new b2(this), this.z, false);
        return;
    L96:
        r15 = r25;
        goto L97
    L78:
        if (r21.isEmpty() == true) goto L81;
        r16 = false;
        goto L81
    L74:
        r20 = null;
        goto L75
    L71:
        r18 = null;
        goto L72
    L61:
        r12 = null;
        goto L62
    L51:
        r8 = null;
        goto L52
    L44:
        LarusLayoutActionBarEditorWidgetTranslatorV3Binding r26 = this.f;
        if (r26 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r26 = null;
    L47:
        e1.o(r26.b);
        goto L48
    L31:
        LarusLayoutActionBarEditorWidgetTranslatorV3Binding r27 = this.f;
        if (r27 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r27 = null;
    L34:
        r27.f.setText(r4);
        LarusLayoutActionBarEditorWidgetTranslatorV3Binding r28 = this.f;
        if (r28 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r28 = null;
    L37:
        e1.x(r28.f);
        goto L39
    L22:
        if ((!TextUtils.isEmpty(r4)) == false) goto L24;
    L15:
        if ((!TextUtils.isEmpty(r4)) == true) goto L18;
        r4 = null;
    L18:
        if (r4 != null) goto L26;
    L11:
        r3 = null;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void S5(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        this.f = LarusLayoutActionBarEditorWidgetTranslatorV3Binding.a(LayoutInflater.from(r1), this);
    }

    public final int i6(h r2, int r3) {
        if (r2 == null) goto L11;
        Integer r4 = r2.f;
        if (r4 != null) goto L8;
        return 0;
    L8:
        if (r4.intValue() != r3) goto L12;
        return 1;
    L12:
        return 0;
    L11:
        return 0;
    }

    public KmpTranslatorWidgetV3(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LazyThreadSafetyMode r5 = LazyThreadSafetyMode.NONE;
        this.j = LazyKt.lazy(r5, new j1(r2));
        this.k = LazyKt.lazy(r5, new u1(this));
        this.o = LazyKt.lazy(r5, new f2(r2));
        this.p = LazyKt.lazy(r5, new g2(this));
        this.t = LazyKt.lazy(r5, new h2(r2));
        this.u = LazyKt.lazy(r5, new i2(this));
        this.x = new b(this);
        this.y = new c(this);
        this.z = new a(this);
    }

    public /* synthetic */ KmpTranslatorWidgetV3(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void b6(KmpTranslatorWidgetV3 r44, h r45, w r46, int r47) {
        v0 r4 = r44.g;
        if (r4 == null) goto L17;
        z0 r5 = r4.j;
        if (r5 == null) goto L18;
        String r6 = r5.a;
        String r7 = r5.c;
        String r8 = r5.d;
        String r9 = r5.f;
        String r10 = r5.g;
        String r11 = r5.j;
        if (r45 == null) goto L10;
        String r12 = r45.c;
    L11:
        String r13 = r46.b;
        String r14 = String.valueOf(r46.a);
        Integer r15 = Integer.valueOf(r44.i6(r45, r47));
        if (r45 == null) goto L14;
        boolean r0 = Intrinsics.areEqual(r45.h, Boolean.TRUE);
    L15:
        tx9.b.e(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, Integer.valueOf(!r0), Integer.valueOf(r47 + 1), "select", null, null, null, null, "original", null, null, null, null, null, r5.h, r5.i, null, null, null, null, null, null, null, null, null, null, null, null, -50601984, 127);
        return;
    L14:
        r0 = 0;
        goto L15
    L10:
        r12 = null;
        goto L11
    L18:
        return;
    }

    public final void c6(final LarusItemActionbarDropdownListBinding r14, h r15, final RecyclerView r16, final Function0<h> r17, Function0<DropdownItemAdapter> r18, Function1<? super DropdownItemAdapter, Unit> r19, final View r20, final Function0<Balloon> r21, final Function1<? super Balloon, Unit> r22, final Function0<Long> r23, final Function1<? super Long, Unit> r24, b1 r25, final boolean r26) {
        if (r15 == null) goto L5;
        final List r2 = r15.e;
    L6:
        if (r2 != null) goto L8;
        r2 = CollectionsKt.emptyList();
    L8:
        Iterator r4 = r2.iterator();
    L10:
        if (r4.hasNext() == false) goto L20;
        Object r5 = r4.next();
        Integer r7 = ((w) r5).s;
        if (r7 != null) goto L15;
    L17:
        boolean r8 = false;
    L18:
        if (r8 == false) goto L10;
    L21:
        w r6 = (w) r5;
        if (r6 == null) goto L24;
        String r9 = r6.b();
    L25:
        if (r9 != null) goto L27;
        r9 = "";
    L27:
        r14.d.setText(r9);
        if (r26 == true) goto L30;
    L32:
        e1.x(r14.b);
    L33:
        final DropdownItemAdapter r10 = (DropdownItemAdapter) r18.invoke();
        if (r10 != null) goto L41;
        if (r15 == null) goto L38;
        Integer r0 = r15.b;
    L39:
        r10 = new DropdownItemAdapter(r0, r25, null);
        y6.d(r16, null, null, null, new c2(r10, this, r17), 15);
        goto L41
    L38:
        r0 = null;
    L41:
        r10.submitList(r2);
        r16.setAdapter(r10);
        r19.invoke(r10);
        r14.a.setOnClickListener(null);
        e1.d(r14.a, new d2(r26, r2, r14, r20, r22, r21, r23, r24, r16));
        return;
    L30:
        if (r2.size() > 1) goto L32;
        e1.o(r14.b);
        goto L33
    L24:
        r9 = null;
        goto L25
    L15:
        if (r7.intValue() != 1) goto L17;
        r8 = true;
        goto L18
    L20:
        r5 = null;
        goto L21
    L5:
        r2 = null;
        goto L6
    }
}
