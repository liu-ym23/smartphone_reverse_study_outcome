package com.larus.uaigc.instruction.kmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.uaigc.impl.databinding.LarusLayoutActionBarEditorWidgetImageSelectorV2Binding;
import com.larus.uaigc.instruction.widget.ImageSelectorWidgetAdapter;
import com.larus.utils.e1;
import com.tencent.open.log.TraceLevel;
import cq8.a0;
import cq8.q;
import cq8.r;
import cq8.z;
import cq8.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u001b\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0012\u0010\u001f\u001a\u00020\u001e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010 \u001a\u00020\u001eH\u0014J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\"H\u0014J\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010%\u001a\u00020\u001eH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001c¨\u0006'"}, d2 = {"Lcom/larus/uaigc/instruction/kmp/KmpImageListSelectorWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/instruction/kmp/IKmpInstructionViewModelAware;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusLayoutActionBarEditorWidgetImageSelectorV2Binding;", "adapter", "Lcom/larus/uaigc/instruction/widget/ImageSelectorWidgetAdapter;", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/ImageListSelectorDescriptor;", "isBound", "", "viewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "widgetScope", "Lkotlinx/coroutines/CoroutineScope;", "localImageList", "", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "itemClickCallback", "com/larus/uaigc/instruction/kmp/KmpImageListSelectorWidget$itemClickCallback$1", "Lcom/larus/uaigc/instruction/kmp/KmpImageListSelectorWidget$itemClickCallback$1;", "init", "", "bindInstructionViewModel", "onDetachedFromWindow", "onDescriptorChanged", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "onBindView", "render", "startObserveTemplateChoose", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class KmpImageListSelectorWidget extends AbsKmpInstructionWidget implements com.larus.bmhome.instruction.kmp.b {
    public static final /* synthetic */ int n = 0;
    public LarusLayoutActionBarEditorWidgetImageSelectorV2Binding f;
    public ImageSelectorWidgetAdapter g;
    public r h;
    public boolean i;
    public com.larus.bmhome.view.actionbar.edit.c j;
    public final CoroutineScope k;
    public List<w> l;
    public final b m;

    public static final class a {
    }

    public static final class b implements vz9.d {
        public final /* synthetic */ KmpImageListSelectorWidget a;

        @Override // vz9.d
        public final void b(w r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "item");
        }

        public b(KmpImageListSelectorWidget r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v2, types: [int] */
        /* JADX WARN: Type inference failed for: r4v5 */
        @Override // vz9.d
        public final void a(w r49, int r50) {
            Intrinsics.checkNotNullParameter(r49, "item");
            r r3 = this.a.h;
            if (r3 != null) goto L5;
            return;
        L5:
            com.larus.bmhome.actionbar.model.l r4 = r3.f;
            if (r4 == null) goto L8;
            ?? r5 = Intrinsics.areEqual(r4.c, Boolean.TRUE);
        L9:
            Iterator r6 = this.a.l.iterator();
        L10:
            Integer r8 = null;
            if (r6.hasNext() == false) goto L15;
            Object r7 = r6.next();
            if (Intrinsics.areEqual(((w) r7).a, r49.a) == false) goto L10;
        L16:
            w r9 = (w) r7;
            if (r9 == null) goto L20;
            r8 = r9.s;
        L20:
            if (r5 != 0) goto L26;
            if (r8 == null) goto L26;
            if (r8.intValue() != 1) goto L26;
            boolean r10 = true;
        L27:
            z r11 = r3.d;
            String r12 = r3.c;
            Long r13 = r49.a;
            if (r13 == null) goto L47;
            r11.a(new q(r12, r13.longValue(), r10));
            z0 r14 = r3.j;
            String r15 = r14.a;
            String r16 = r14.c;
            String r17 = r14.d;
            String r18 = r14.f;
            String r19 = r14.g;
            String r110 = r14.j;
            String r20 = r49.b;
            String r111 = String.valueOf(r49.a);
            com.larus.bmhome.actionbar.model.l r1 = r3.f;
            if (r1 == null) goto L37;
            Integer r2 = r1.b;
            if (r2 == null) goto L37;
            if (r50 != r2.intValue()) goto L37;
            int r112 = 1;
        L38:
            Integer r113 = Integer.valueOf(r112);
            Integer r114 = Integer.valueOf(r5);
            Integer r21 = Integer.valueOf(r50 + 1);
            if (r10 == true) goto L41;
            String r22 = "select";
        L42:
            tx9.b.e(r15, r16, r17, r18, r19, r110, null, r20, r111, r113, r114, r21, r22, null, null, null, null, "original", null, null, null, null, null, null, r14.i, null, null, null, null, null, null, null, null, null, null, null, null, -33824704, 127);
            return;
        L41:
            r22 = "cancel";
        L37:
            r112 = 0;
            goto L38
        L47:
            return;
        L26:
            r10 = false;
            goto L27
        L15:
            r7 = null;
            goto L16
        L8:
            r5 = 0;
            goto L9
        }
    }

    static {
    }

    public KmpImageListSelectorWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KmpImageListSelectorWidget(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CoroutineScopeKt.cancel$default(this.k, null, 1, null);
    }

    public final void L4(com.larus.bmhome.view.actionbar.edit.c r1) {
        this.j = r1;
    }

    public final void T5(a0 r14) {
        Intrinsics.checkNotNullParameter(r14, "descriptor");
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r1 = null;
        if ((r14 instanceof r) == false) goto L5;
        r r15 = (r) r14;
    L6:
        if (r15 != null) goto L8;
        return;
    L8:
        this.h = r15;
        if (this.i == true) goto L44;
        boolean r0 = true;
        this.i = true;
        if (r15.h == false) goto L16;
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r3 = this.f;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L15:
        e1.x(r3.b);
    L16:
        String r4 = r15.g;
        if (r4 != null) goto L19;
    L22:
        if (r0 == false) goto L27;
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r2 = this.f;
        if (r2 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L26:
        e1.o(r2.e);
    L34:
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r5 = this.f;
        if (r5 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L37:
        y6.d(r5.c, null, null, null, new c(this), 15);
        this.g = new ImageSelectorWidgetAdapter(this.m, null);
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r6 = this.f;
        if (r6 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L40:
        r6.c.setAdapter(this.g);
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r7 = this.f;
        if (r7 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L43:
        r7.c.addItemDecoration(new KmpImageListSelectorWidget$onBindView$2());
        BuildersKt.launch$default(this.k, null, null, new KmpImageListSelectorWidget$startObserveTemplateChoose$1(this, null), 3, null);
        goto L44
    L27:
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r8 = this.f;
        if (r8 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L30:
        r8.e.setText(r4);
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r9 = this.f;
        if (r9 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L33:
        e1.x(r9.e);
        goto L34
    L19:
        if (r4.length() == 0) goto L22;
        r0 = false;
    L44:
        com.larus.bmhome.actionbar.model.l r10 = r15.f;
        if (r10 == null) goto L47;
        List r11 = r10.a;
    L48:
        if (r11 != null) goto L50;
        r11 = CollectionsKt.emptyList();
    L50:
        List r12 = r11;
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r16 = r12.iterator();
    L52:
        if (r16.hasNext() == false) goto L54;
        r13.add(w.a((w) r16.next(), null, null, null, null, null, null, 8388607));
        goto L52
    L54:
        ImageSelectorWidgetAdapter r17 = this.g;
        if (r17 == null) goto L57;
        r17.submitList(r13);
    L57:
        this.l = r13;
        if (r15.k < 0) goto L68;
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r18 = this.f;
        if (r18 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L63:
        RecyclerView.LayoutManager r19 = r1.c.getLayoutManager();
        if (r19 == null) goto L69;
        r19.scrollToPosition(r15.k);
        return;
    L69:
        return;
    L62:
        r1 = r18;
        goto L63
    L68:
        return;
    L47:
        r11 = null;
        goto L48
    L5:
        r15 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        this.f = LarusLayoutActionBarEditorWidgetImageSelectorV2Binding.a(LayoutInflater.from(r1), this);
    }

    public KmpImageListSelectorWidget(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.k = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
        this.l = CollectionsKt.emptyList();
        this.m = new b(this);
    }

    public /* synthetic */ KmpImageListSelectorWidget(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
