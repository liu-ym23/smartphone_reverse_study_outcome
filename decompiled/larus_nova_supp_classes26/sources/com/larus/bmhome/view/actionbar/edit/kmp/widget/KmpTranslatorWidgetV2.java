package com.larus.bmhome.view.actionbar.edit.kmp.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import bt8.a1;
import bt8.c1;
import bt8.d1;
import bt8.f1;
import bt8.g1;
import bt8.h1;
import bt8.i1;
import bt8.n0;
import bt8.o0;
import bt8.p0;
import bt8.q0;
import bt8.r0;
import bt8.s0;
import bt8.t0;
import bt8.u0;
import bt8.x0;
import bt8.y0;
import com.larus.bmhome.actionbar.model.h;
import com.larus.bmhome.actionbar.model.l0;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.core.model.widget.TranslatorSelectorType;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.bmhome.view.actionbar.edit.component.DropdownItemAdapter;
import com.larus.bmhome.view.actionbar.edit.component.b1;
import com.larus.instruction.impl.databinding.LarusItemActionbarDropdownListBinding;
import com.larus.instruction.impl.databinding.LarusLayoutActionBarEditorWidgetTranslatorV2Binding;
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
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0002,/\u0018\u00002\u00060\u0001j\u0002`\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001a\u00101\u001a\u0002022\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u00103\u001a\u0002022\u0006\u0010\r\u001a\u000204H\u0014J\u000e\u00105\u001a\u0002022\u0006\u0010\r\u001a\u00020\u000eJ\u0012\u00106\u001a\u0002022\b\u00107\u001a\u0004\u0018\u000108H\u0002J\u0012\u00109\u001a\u0002022\b\u00107\u001a\u0004\u0018\u000108H\u0002J¸\u0001\u0010:\u001a\u0002022\u0006\u0010;\u001a\u00020<2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u0010=\u001a\u00020\u001a2\u000e\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001080?2\u000e\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0?2\u0014\u0010A\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001f\u0012\u0004\u0012\u0002020B2\u0006\u0010C\u001a\u00020\u00142\u000e\u0010D\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120?2\u0014\u0010E\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u0002020B2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020!0?2\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u0002020B2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020KH\u0002J\u0010\u0010L\u001a\u0002022\u0006\u0010\r\u001a\u00020\u000eH\u0002J\"\u0010M\u001a\u0002022\b\u0010N\u001a\u0004\u0018\u0001082\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\bH\u0002J\"\u0010R\u001a\u0002022\b\u0010N\u001a\u0004\u0018\u0001082\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\bH\u0002J\u001a\u0010S\u001a\u00020\b2\b\u0010N\u001a\u0004\u0018\u0001082\u0006\u0010Q\u001a\u00020\bH\u0002J\u0012\u0010T\u001a\u00020\b2\b\u0010N\u001a\u0004\u0018\u000108H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0018\u001a\u0004\b$\u0010\u0016R\u001b\u0010&\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0018\u001a\u0004\b'\u0010\u001cR\u0010\u0010)\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0004\n\u0002\u0010-R\u0010\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100¨\u0006U"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpTranslatorWidgetV2;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/AbsKmpInstructionWidget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetTranslatorV2Binding;", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/TranslatorDescriptor;", "currentTemplate", "Lcom/larus/bmhome/actionbar/model/ActionBarTranslatorBoxTemplate;", "sourceLanguageBalloon", "Lcom/skydoves/balloon/Balloon;", "sourceLanguagePopupView", "Landroid/view/View;", "getSourceLanguagePopupView", "()Landroid/view/View;", "sourceLanguagePopupView$delegate", "Lkotlin/Lazy;", "sourceLanguageRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getSourceLanguageRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "sourceLanguageRecyclerView$delegate", "sourceLanguageItemAdapter", "Lcom/larus/bmhome/view/actionbar/edit/component/DropdownItemAdapter;", "sourceDismissTime", "", "targetLanguageBalloon", "targetLanguagePopupView", "getTargetLanguagePopupView", "targetLanguagePopupView$delegate", "targetLanguageRecyclerView", "getTargetLanguageRecyclerView", "targetLanguageRecyclerView$delegate", "targetLanguageItemAdapter", "targetDismissTime", "sourceLanguageSelectedCallback", "com/larus/bmhome/view/actionbar/edit/kmp/widget/KmpTranslatorWidgetV2$sourceLanguageSelectedCallback$1", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpTranslatorWidgetV2$sourceLanguageSelectedCallback$1;", "targetLanguageSelectedCallback", "com/larus/bmhome/view/actionbar/edit/kmp/widget/KmpTranslatorWidgetV2$targetLanguageSelectedCallback$1", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpTranslatorWidgetV2$targetLanguageSelectedCallback$1;", "init", "", "onDescriptorChanged", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "bind", "renderSourceLanguageSelector", "data", "Lcom/larus/bmhome/actionbar/model/ActionBarDropdownBox;", "renderTargetLanguageSelector", "bindDropdown", "itemBinding", "Lcom/larus/instruction/impl/databinding/LarusItemActionbarDropdownListBinding;", "recyclerView", "getDropdown", "Lkotlin/Function0;", "getItemAdapter", "setItemAdapter", "Lkotlin/Function1;", "popupView", "getBalloon", "setBalloon", "getDismissTime", "setDismissTime", "selectedCallback", "Lcom/larus/bmhome/view/actionbar/edit/component/DropdownSelectorHolderCallback;", "singleOptionHideArrow", "", "renderWidgetChrome", "reportOptionShow", "dropdown", "option", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "optionPosition", "reportOptionClick", "calculateIsDefault", "calculateIsChooseRequired", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpTranslatorWidgetV2 extends AbsKmpInstructionWidget {
    public static final /* synthetic */ int u = 0;
    public LarusLayoutActionBarEditorWidgetTranslatorV2Binding f;
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
    public final a s;
    public final b t;

    public static final class a implements b1 {
        public final /* synthetic */ KmpTranslatorWidgetV2 a;

        public a(KmpTranslatorWidgetV2 r1) {
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
            KmpTranslatorWidgetV2 r12 = this.a;
            l0 r1 = r12.h;
            if (r1 == null) goto L20;
            h r5 = r1.a;
        L21:
            KmpTranslatorWidgetV2.Z5(r12, r5, r7, r8);
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
        public final /* synthetic */ KmpTranslatorWidgetV2 a;

        public b(KmpTranslatorWidgetV2 r1) {
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
            KmpTranslatorWidgetV2 r12 = this.a;
            l0 r1 = r12.h;
            if (r1 == null) goto L20;
            h r5 = r1.b;
        L21:
            KmpTranslatorWidgetV2.Z5(r12, r5, r7, r8);
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

    public KmpTranslatorWidgetV2(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KmpTranslatorWidgetV2(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
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

    public static RecyclerView V5(KmpTranslatorWidgetV2 r1) {
        return r1.getSourceLanguagePopupView().findViewById(2131382753);
    }

    public static RecyclerView Y5(KmpTranslatorWidgetV2 r1) {
        return r1.getTargetLanguagePopupView().findViewById(2131382753);
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void T5(a0 r18) {
        a0 r0 = r18;
        Intrinsics.checkNotNullParameter(r0, "descriptor");
        LarusLayoutActionBarEditorWidgetTranslatorV2Binding r15 = null;
        if ((r0 instanceof v0) == true) goto L5;
        r0 = null;
    L5:
        v0 r1 = (v0) r0;
        if (r1 == null) goto L64;
        Intrinsics.checkNotNullParameter(r1, "descriptor");
        this.g = r1;
        l0 r2 = r1.f;
        if (r2 == null) goto L11;
        l0 r3 = l0.d(r2, i1.a(r2.a), i1.a(r2.b), null, 28);
    L12:
        this.h = r3;
        String r4 = r1.g;
        if (r4 != null) goto L15;
    L17:
        r4 = null;
    L19:
        if (r4 != null) goto L24;
        LarusLayoutActionBarEditorWidgetTranslatorV2Binding r5 = this.f;
        if (r5 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L23:
        e1.o(r5.e);
    L32:
        if (r1.i == false) goto L37;
        LarusLayoutActionBarEditorWidgetTranslatorV2Binding r6 = this.f;
        if (r6 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L36:
        e1.x(r6.b);
    L41:
        l0 r7 = this.h;
        if (r7 == null) goto L44;
        h r8 = r7.a;
    L45:
        LarusLayoutActionBarEditorWidgetTranslatorV2Binding r9 = this.f;
        if (r9 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L48:
        e1.o(r9.c.c);
        LarusLayoutActionBarEditorWidgetTranslatorV2Binding r10 = this.f;
        if (r10 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L51:
        b6(r10.c, r8, getSourceLanguageRecyclerView(), new n0(this), new y0(this), new a1(this), getSourceLanguagePopupView(), new bt8.b1(this), new c1(this), new d1(this), new bt8.e1(this), this.s, true);
        l0 r11 = this.h;
        if (r11 == null) goto L54;
        h r12 = r11.b;
    L55:
        LarusLayoutActionBarEditorWidgetTranslatorV2Binding r13 = this.f;
        if (r13 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L58:
        e1.o(r13.d.c);
        LarusLayoutActionBarEditorWidgetTranslatorV2Binding r14 = this.f;
        if (r14 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L62:
        b6(r15.d, r12, getTargetLanguageRecyclerView(), new f1(this), new g1(this), new h1(this), getTargetLanguagePopupView(), new o0(this), new p0(this), new q0(this), new r0(this), this.t, true);
        return;
    L61:
        r15 = r14;
        goto L62
    L54:
        r12 = null;
        goto L55
    L44:
        r8 = null;
        goto L45
    L37:
        LarusLayoutActionBarEditorWidgetTranslatorV2Binding r16 = this.f;
        if (r16 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L40:
        e1.o(r16.b);
        goto L41
    L24:
        LarusLayoutActionBarEditorWidgetTranslatorV2Binding r17 = this.f;
        if (r17 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L27:
        r17.e.setText(r4);
        LarusLayoutActionBarEditorWidgetTranslatorV2Binding r19 = this.f;
        if (r19 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L30:
        e1.x(r19.e);
        goto L32
    L15:
        if ((!TextUtils.isEmpty(r4)) == false) goto L17;
    L11:
        r3 = null;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void S5(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        this.f = LarusLayoutActionBarEditorWidgetTranslatorV2Binding.a(LayoutInflater.from(r1), this);
    }

    public final int c6(h r2, int r3) {
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

    public KmpTranslatorWidgetV2(final Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LazyThreadSafetyMode r5 = LazyThreadSafetyMode.NONE;
        this.j = LazyKt.lazy(r5, new s0(r2));
        this.k = LazyKt.lazy(r5, new t0(this));
        this.o = LazyKt.lazy(r5, new u0(r2));
        this.p = LazyKt.lazy(r5, new bt8.v0(this));
        this.s = new a(this);
        this.t = new b(this);
    }

    public /* synthetic */ KmpTranslatorWidgetV2(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void Z5(KmpTranslatorWidgetV2 r44, h r45, w r46, int r47) {
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
        Integer r15 = Integer.valueOf(r44.c6(r45, r47));
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

    public final void b6(final LarusItemActionbarDropdownListBinding r13, h r14, final RecyclerView r15, final Function0<h> r16, Function0<DropdownItemAdapter> r17, Function1<? super DropdownItemAdapter, Unit> r18, final View r19, final Function0<Balloon> r20, final Function1<? super Balloon, Unit> r21, final Function0<Long> r22, final Function1<? super Long, Unit> r23, b1 r24, boolean r25) {
        if (r14 == null) goto L5;
        List r3 = r14.e;
    L6:
        if (r3 != null) goto L8;
        r3 = CollectionsKt.emptyList();
    L8:
        Iterator r4 = r3.iterator();
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
        r13.d.setText(r9);
        if (r3.size() > 1) goto L30;
        e1.o(r13.b);
    L31:
        final DropdownItemAdapter r10 = (DropdownItemAdapter) r17.invoke();
        if (r10 != null) goto L39;
        if (r14 == null) goto L36;
        Integer r0 = r14.b;
    L37:
        r10 = new DropdownItemAdapter(r0, r24, null);
        y6.d(r15, null, null, null, new bt8.w0(r10, this, r16), 15);
        goto L39
    L36:
        r0 = null;
    L39:
        r10.submitList(r3);
        r15.setAdapter(r10);
        r18.invoke(r10);
        r13.a.setOnClickListener(null);
        final List r1 = r3;
        e1.d(r13.a, new x0(r1, r13, r19, r21, r20, r22, r23, r15));
        return;
    L30:
        e1.x(r13.b);
        goto L31
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
        r3 = null;
        goto L6
    }
}
