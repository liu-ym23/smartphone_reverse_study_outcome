package com.larus.bmhome.view.actionbar.edit.kmp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bt8.l0;
import bt8.o2;
import com.larus.bmhome.actionbar.model.k0;
import com.larus.bmhome.actionbar.model.y1;
import com.larus.bmhome.chat.WrapStaggeredGridLayoutManager;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.instruction.impl.databinding.LarusLayoutActionBarEditorWidgetTextSelectorBinding;
import com.larus.utils.e1;
import com.larus.utils.o0;
import com.obric.assistant.spi.actionbar.ObricActionBarSendServiceDelegate;
import cq8.a0;
import cq8.t0;
import cq8.u0;
import cq8.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v19.i5;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u000e\u0018\u0000 02\u00060\u0001j\u0002`\u0002:\u00010B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0002J\u001a\u0010 \u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\"H\u0014J\u000e\u0010#\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010$\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020\bH\u0002J\u0017\u0010'\u001a\u00020\u00112\b\u0010(\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010)J \u0010*\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\bH\u0002J(\u0010-\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010.\u001a\u00020/H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpTextListSelectorWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/AbsKmpInstructionWidget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetTextSelectorBinding;", "itemClickCallback", "com/larus/bmhome/view/actionbar/edit/kmp/widget/KmpTextListSelectorWidget$itemClickCallback$1", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpTextListSelectorWidget$itemClickCallback$1;", "refreshAdapter", "", "bindingAdapterPosition", "adapter", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/TextSelectorWidgetAdapter;", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/TextListSelectorDescriptor;", "localOptions", "", "Lcom/larus/bmhome/actionbar/model/SingleSelectorInstructionOption;", "lastSelectedIndex", "currentColNums", "currentDecoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "staggeredScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "init", "onDescriptorChanged", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "bind", "renderWidgetChrome", "ensureLayout", "colNums", "applyLocalSingleSelection", "selectedId", "(Ljava/lang/Integer;)V", "reportOptionShow", "item", "index", "reportOptionClick", "actionType", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpTextListSelectorWidget extends AbsKmpInstructionWidget {
    public static final int n = 0;
    public static final int o = 0;
    public LarusLayoutActionBarEditorWidgetTextSelectorBinding f;
    public final TextSelectorWidgetAdapter g;
    public u0 h;
    public List<y1> i;
    public int j;
    public int k;
    public RecyclerView.ItemDecoration l;
    public KmpTextListSelectorWidget$ensureLayout$scrollListener$1 m;

    public static final class a {
    }

    public static final class b implements o2 {
        public final /* synthetic */ KmpTextListSelectorWidget a;

        public b(KmpTextListSelectorWidget r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v2 */
        /* JADX WARN: Type inference failed for: r6v3, types: [int] */
        /* JADX WARN: Type inference failed for: r6v5 */
        @Override // bt8.o2
        public final void a(y1 r50, int r51) {
            int r2 = r51;
            Intrinsics.checkNotNullParameter(r50, "item");
            u0 r3 = this.a.h;
            if (r3 != null) goto L5;
            return;
        L5:
            Integer r4 = r50.a;
            if (r4 == null) goto L79;
            int r5 = r4.intValue();
            ObricActionBarSendServiceDelegate.b.s(r50.g, r50.b);
            r3.d.a(new t0(r3.c, r5));
            k0 r6 = r3.f;
            ?? r7 = 0;
            if (r6 == null) goto L10;
            boolean r8 = Intrinsics.areEqual(r6.e, Boolean.TRUE);
        L11:
            Integer r9 = r50.g;
            if (r9 != null) goto L15;
        L17:
            boolean r10 = false;
        L18:
            Integer r11 = null;
            if (r8 == false) goto L21;
            Integer r12 = Integer.valueOf(r5);
        L24:
            KmpTextListSelectorWidget r13 = this.a;
            List<y1> r14 = r13.i;
            ArrayList r15 = new ArrayList();
            Iterator r16 = r14.iterator();
        L26:
            if (r16.hasNext() == false) goto L35;
            Object r17 = r16.next();
            String r18 = ((y1) r17).b;
            if (r18 != null) goto L30;
        L32:
            boolean r19 = false;
        L33:
            if (r19 == false) goto L26;
            r15.add(r17);
            goto L26
        L30:
            if ((!StringsKt.isBlank(r18)) != true) goto L32;
            r19 = true;
            goto L33
        L35:
            ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
            Iterator r110 = r15.iterator();
        L37:
            if (r110.hasNext() == false) goto L45;
            y1 r111 = (y1) r110.next();
            if (r12 != null) goto L41;
        L43:
            int r112 = 0;
        L44:
            r20.add(y1.a(r111, Integer.valueOf(r112), 63));
            goto L37
        L41:
            if (Intrinsics.areEqual(r111.a, r12) == false) goto L43;
            r112 = 1;
            goto L44
        L45:
            List<y1> r21 = CollectionsKt.toMutableList(r20);
            r13.i = r21;
            r13.g.submitList(r21);
            if (r12 == null) goto L48;
            String r22 = "select";
        L49:
            String r23 = r22;
            this.a.getClass();
            z0 r24 = r3.j;
            String r113 = r24.a;
            String r114 = r24.c;
            String r115 = r24.d;
            String r116 = r24.f;
            String r117 = r24.g;
            String r118 = r3.h;
            String r25 = r50.b;
            Integer r26 = r50.a;
            if (r26 == null) goto L52;
            String r119 = r26.toString();
        L53:
            Integer r1 = r50.a;
            k0 r27 = r3.f;
            if (r27 == null) goto L58;
            y1 r28 = r27.b;
            if (r28 == null) goto L58;
            r11 = r28.a;
        L58:
            Integer r120 = Integer.valueOf(Intrinsics.areEqual(r1, r11) ? 1 : 0);
            k0 r29 = r3.f;
            if (r29 == null) goto L61;
            r7 = Intrinsics.areEqual(r29.e, Boolean.TRUE);
        L61:
            tx9.b.e(r113, r114, r115, r116, r117, r118, null, r25, r119, r120, Integer.valueOf(r7), Integer.valueOf(r2 + 1), r23, null, null, null, null, "original", null, null, null, null, null, r24.h, r24.i, null, null, null, null, null, null, null, null, null, null, null, null, -50601920, 127);
            KmpTextListSelectorWidget r30 = this.a;
            int r31 = r30.j;
            if (r31 < 0) goto L66;
            TextSelectorWidgetAdapter r32 = r30.g;
            if (r32 == null) goto L66;
            r32.notifyItemChanged(r31);
        L66:
            r30.g.notifyItemChanged(r2);
            KmpTextListSelectorWidget r33 = this.a;
            if (r12 != null) goto L69;
            r2 = -1;
        L69:
            r33.j = r2;
            return;
        L52:
            r119 = null;
            goto L53
        L48:
            r22 = "cancel";
            goto L49
        L21:
            if (r10 == false) goto L23;
            r12 = null;
            goto L24
        L23:
            r12 = Integer.valueOf(r5);
            goto L24
        L15:
            if (r9.intValue() != 1) goto L17;
            r10 = true;
            goto L18
        L10:
            r8 = false;
            goto L11
        }
    }

    public KmpTextListSelectorWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KmpTextListSelectorWidget(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    static {
        n = i5.j0();
        o = i5.r0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v43, types: [androidx.recyclerview.widget.RecyclerView$OnScrollListener, com.larus.bmhome.view.actionbar.edit.kmp.widget.KmpTextListSelectorWidget$ensureLayout$scrollListener$1] */
    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void T5(a0 r14) {
        Intrinsics.checkNotNullParameter(r14, "descriptor");
        if ((r14 instanceof u0) == true) goto L5;
        r14 = null;
    L5:
        u0 r15 = (u0) r14;
        if (r15 == null) goto L158;
        Intrinsics.checkNotNullParameter(r15, "descriptor");
        this.h = r15;
        k0 r0 = r15.f;
        if (r0 == null) goto L19;
        List r1 = r0.c;
        if (r1 == null) goto L19;
        List r2 = r1;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r3 = r2.iterator();
    L14:
        if (r3.hasNext() == false) goto L16;
        r4.add(y1.a((y1) r3.next(), null, 127));
        goto L14
    L16:
        List<y1> r5 = CollectionsKt.toMutableList(r4);
        if (r5 == null) goto L19;
    L20:
        this.i = r5;
        if (r15.i == false) goto L26;
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r6 = this.f;
        if (r6 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L25:
        e1.x(r6.b);
    L31:
        if (o0.d(r15.h) == false) goto L39;
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r7 = this.f;
        if (r7 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L35:
        r7.d.setText(r15.h);
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r8 = this.f;
        if (r8 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L38:
        e1.x(r8.d);
    L43:
        k0 r16 = r15.f;
        if (r16 == null) goto L48;
        Integer r17 = r16.a;
        if (r17 == null) goto L48;
        int r18 = r17.intValue();
    L50:
        if (this.k == r18) goto L114;
        this.k = r18;
        RecyclerView.ItemDecoration r9 = this.l;
        if (r9 == null) goto L58;
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r10 = this.f;
        if (r10 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L57:
        r10.c.removeItemDecoration(r9);
    L58:
        KmpTextListSelectorWidget$ensureLayout$scrollListener$1 r11 = this.m;
        if (r11 == null) goto L64;
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r12 = this.f;
        if (r12 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L63:
        r12.c.removeOnScrollListener(r11);
    L64:
        this.l = null;
        this.m = null;
        if (r18 <= 1) goto L90;
        final WrapStaggeredGridLayoutManager r13 = new WrapStaggeredGridLayoutManager(r18, 0);
        r13.setGapStrategy(0);
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r19 = this.f;
        if (r19 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L69:
        RecyclerView r110 = r19.c;
        ViewGroup.LayoutParams r111 = r110.getLayoutParams();
        if (r111 == null) goto L89;
        r111.height = r18 * (i5.W() + o);
        r110.setLayoutParams(r111);
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r112 = this.f;
        if (r112 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r112 = null;
    L74:
        RecyclerView r113 = r112.c;
        ViewGroup.LayoutParams r20 = r113.getLayoutParams();
        if (r20 == null) goto L87;
        ViewGroup.MarginLayoutParams r21 = (ViewGroup.MarginLayoutParams) r20;
        r21.bottomMargin = i5.r0();
        r113.setLayoutParams(r21);
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r114 = this.f;
        if (r114 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r114 = null;
    L79:
        r114.c.setLayoutManager(r13);
        RecyclerView.ItemDecoration r115 = new KmpTextListSelectorWidget$ensureLayout$decoration$1();
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r22 = this.f;
        if (r22 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r22 = null;
    L82:
        r22.c.addItemDecoration(r115);
        this.l = r115;
        ?? r116 = new KmpTextListSelectorWidget$ensureLayout$scrollListener$1(r13);
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r23 = this.f;
        if (r23 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r23 = null;
    L85:
        r23.c.addOnScrollListener(r116);
        this.m = r116;
    L107:
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r117 = this.f;
        if (r117 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r117 = null;
    L110:
        r117.c.setAdapter(this.g);
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r118 = this.f;
        if (r118 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r118 = null;
    L113:
        r118.c.setItemAnimator(null);
        goto L114
    L87:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L89:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L90:
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r119 = this.f;
        if (r119 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r119 = null;
    L93:
        RecyclerView r120 = r119.c;
        ViewGroup.LayoutParams r24 = r120.getLayoutParams();
        if (r24 == null) goto L148;
        r24.height = -2;
        r120.setLayoutParams(r24);
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r121 = this.f;
        if (r121 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r121 = null;
    L98:
        RecyclerView r122 = r121.c;
        ViewGroup.LayoutParams r25 = r122.getLayoutParams();
        if (r25 == null) goto L146;
        ViewGroup.MarginLayoutParams r26 = (ViewGroup.MarginLayoutParams) r25;
        r26.bottomMargin = i5.h();
        r122.setLayoutParams(r26);
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r123 = this.f;
        if (r123 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r123 = null;
    L103:
        r123.c.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        RecyclerView.ItemDecoration r124 = new KmpTextListSelectorWidget$ensureLayout$decoration$2();
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r27 = this.f;
        if (r27 != null) goto L106;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r27 = null;
    L106:
        r27.c.addItemDecoration(r124);
        this.l = r124;
        goto L107
    L146:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L148:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L114:
        ArrayList r125 = new ArrayList();
        Iterator<T> r28 = r5.iterator();
    L116:
        if (r28.hasNext() == false) goto L125;
        Object r29 = r28.next();
        String r30 = ((y1) r29).b;
        if (r30 != null) goto L120;
    L122:
        boolean r31 = false;
    L123:
        if (r31 == false) goto L116;
        r125.add(r29);
        goto L116
    L120:
        if ((!StringsKt.isBlank(r30)) != true) goto L122;
        r31 = true;
        goto L123
    L125:
        ArrayList r32 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r125, 10));
        Iterator r126 = r125.iterator();
    L127:
        if (r126.hasNext() == false) goto L129;
        r32.add(y1.a((y1) r126.next(), null, 127));
        goto L127
    L129:
        this.g.submitList(r32);
        Iterator r127 = r32.iterator();
        int r33 = 0;
    L131:
        if (r127.hasNext() == false) goto L142;
        Integer r34 = ((y1) r127.next()).g;
        if (r34 != null) goto L136;
    L138:
        boolean r35 = false;
    L139:
        if (r35 == true) goto L143;
        r33 = r33 + 1;
    L143:
        this.j = r33;
        return;
    L136:
        if (r34.intValue() != 1) goto L138;
        r35 = true;
        goto L139
    L142:
        r33 = -1;
    L48:
        r18 = 1;
        goto L50
    L39:
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r36 = this.f;
        if (r36 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r36 = null;
    L42:
        e1.o(r36.d);
        goto L43
    L26:
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r37 = this.f;
        if (r37 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r37 = null;
    L29:
        e1.o(r37.b);
    L19:
        r5 = new ArrayList();
        goto L20
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void S5(Context r7, AttributeSet r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        LarusLayoutActionBarEditorWidgetTextSelectorBinding r9 = LarusLayoutActionBarEditorWidgetTextSelectorBinding.a(LayoutInflater.from(r7), this);
        this.f = r9;
        y6.d(r9.c, new bt8.k0(this), null, null, new l0(this), 13);
    }

    public KmpTextListSelectorWidget(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.g = new TextSelectorWidgetAdapter(new b(this));
        this.i = new ArrayList();
        this.j = -1;
        this.k = -1;
    }

    public /* synthetic */ KmpTextListSelectorWidget(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
