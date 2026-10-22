package com.larus.uaigc.music.template.kmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.actionbar.model.d0;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.uaigc.impl.databinding.LarusItemActionbarImageTemplateCoverHolderBinding;
import com.larus.uaigc.impl.databinding.LarusLayoutActionBarEditorWidgetImageSelectorBinding;
import com.larus.uaigc.instruction.widget.ImageSelectorWidgetAdapter;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import cq8.a0;
import cq8.m0;
import cq8.o0;
import cq8.z;
import cq8.z0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0014J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u001bH\u0014J\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0002J\u0018\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J\n\u0010(\u001a\u0004\u0018\u00010)H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006*"}, d2 = {"Lcom/larus/uaigc/music/template/kmp/KmpMusicTemplateSelectorWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusLayoutActionBarEditorWidgetImageSelectorBinding;", "adapter", "Lcom/larus/uaigc/instruction/widget/ImageSelectorWidgetAdapter;", "coverBinding", "Lcom/larus/uaigc/impl/databinding/LarusItemActionbarImageTemplateCoverHolderBinding;", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/MusicTemplateSelectorDescriptor;", "localImageList", "", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "itemClickCallback", "com/larus/uaigc/music/template/kmp/KmpMusicTemplateSelectorWidget$itemClickCallback$1", "Lcom/larus/uaigc/music/template/kmp/KmpMusicTemplateSelectorWidget$itemClickCallback$1;", "init", "", "onDescriptorChanged", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "bind", "setupAdapter", "renderWidgetChrome", "requestTemplateList", "goToMusicTemplateList", "data", "Lcom/larus/uaigc/music/template/MusicTemplateModel;", "selectMusicTemplateInternal", "item", "Lcom/larus/bmhome/instruction/core/model/music/MusicGenTemplate;", "enterFrom", "", "getScope", "Lkotlinx/coroutines/CoroutineScope;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class KmpMusicTemplateSelectorWidget extends AbsKmpInstructionWidget {
    public static final /* synthetic */ int l = 0;
    public LarusLayoutActionBarEditorWidgetImageSelectorBinding f;
    public ImageSelectorWidgetAdapter g;
    public LarusItemActionbarImageTemplateCoverHolderBinding h;
    public o0 i;
    public List<w> j;
    public final a k;

    public static final class a implements vz9.d {
        public final /* synthetic */ KmpMusicTemplateSelectorWidget a;

        @Override // vz9.d
        public final void b(w r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "item");
        }

        public a(KmpMusicTemplateSelectorWidget r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v2, types: [int] */
        /* JADX WARN: Type inference failed for: r3v5 */
        @Override // vz9.d
        public final void a(w r49, int r50) {
            Intrinsics.checkNotNullParameter(r49, "item");
            o0 r2 = this.a.i;
            if (r2 != null) goto L5;
            return;
        L5:
            d0 r3 = r2.f;
            if (r3 == null) goto L8;
            ?? r4 = Intrinsics.areEqual(r3.c, Boolean.TRUE);
        L9:
            Iterator r5 = this.a.j.iterator();
        L10:
            Integer r7 = null;
            if (r5.hasNext() == false) goto L15;
            Object r6 = r5.next();
            if (Intrinsics.areEqual(((w) r6).a, r49.a) == false) goto L10;
        L16:
            w r8 = (w) r6;
            if (r8 == null) goto L20;
            r7 = r8.s;
        L20:
            if (r4 != 0) goto L26;
            if (r7 == null) goto L26;
            if (r7.intValue() != 1) goto L26;
            boolean r9 = true;
        L27:
            FLogger.a.i("ImageSelectorWidgetAdapter", "item name:" + r49.b + " isDeselect:" + r9);
            z r10 = r2.d;
            String r11 = r2.c;
            Long r12 = r49.a;
            if (r12 == null) goto L51;
            r10.a(new m0(r11, r12.longValue(), r9));
            if (r2.i == false) goto L32;
            int r13 = r50 - 1;
        L33:
            z0 r14 = r2.k;
            String r15 = r14.a;
            String r16 = r14.c;
            String r17 = r14.d;
            String r18 = r14.f;
            String r19 = r14.g;
            String r110 = r14.j;
            String r20 = r49.b;
            String r111 = String.valueOf(r49.a);
            d0 r1 = r2.f;
            if (r1 == null) goto L41;
            Integer r21 = r1.b;
            if (r21 == null) goto L41;
            if (r13 != r21.intValue()) goto L41;
            int r112 = 1;
        L42:
            Integer r113 = Integer.valueOf(r112);
            Integer r114 = Integer.valueOf(r4);
            Integer r22 = Integer.valueOf(r50 + 1);
            if (r9 == true) goto L45;
            String r23 = "select";
        L46:
            tx9.b.e(r15, r16, r17, r18, r19, r110, null, r20, r111, r113, r114, r22, r23, null, null, null, null, "original", null, null, null, null, null, null, r14.i, null, null, null, null, null, null, null, null, null, null, null, null, -33824704, 127);
            return;
        L45:
            r23 = "cancel";
        L41:
            r112 = 0;
            goto L42
        L32:
            r13 = r50;
            goto L33
        L51:
            return;
        L26:
            r9 = false;
            goto L27
        L15:
            r6 = null;
            goto L16
        L8:
            r4 = 0;
            goto L9
        }
    }

    public KmpMusicTemplateSelectorWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KmpMusicTemplateSelectorWidget(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final CoroutineScope getScope() {
        return CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
    }

    public final void V5() {
        CoroutineScope r0 = getScope();
        if (r0 != null) goto L5;
        return;
    L5:
        BuildersKt.launch$default(r0, null, null, new KmpMusicTemplateSelectorWidget$requestTemplateList$1(this, r0, null), 3, null);
    }

    private final void setupAdapter(final o0 r10) {
        LarusLayoutActionBarEditorWidgetImageSelectorBinding r1 = null;
        if (r10.i == false) goto L5;
        this.g = new ImageSelectorWidgetAdapter(this.k, new com.larus.uaigc.music.template.kmp.a(this));
    L6:
        LarusLayoutActionBarEditorWidgetImageSelectorBinding r0 = this.f;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L9:
        y6.d(r0.c, null, null, null, new b(r10, this), 15);
        LarusLayoutActionBarEditorWidgetImageSelectorBinding r11 = this.f;
        if (r11 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L12:
        r11.c.setAdapter(this.g);
        LarusLayoutActionBarEditorWidgetImageSelectorBinding r12 = this.f;
        if (r12 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L16:
        r1.c.addItemDecoration(new AnonymousClass3());
        return;
    L15:
        r1 = r12;
        goto L16
    L5:
        this.g = new ImageSelectorWidgetAdapter(this.k, null);
        goto L6
    }

    public final void T5(a0 r23) {
        Intrinsics.checkNotNullParameter(r23, "descriptor");
        LarusLayoutActionBarEditorWidgetImageSelectorBinding r4 = null;
        if ((r23 instanceof o0) == false) goto L5;
        o0 r1 = (o0) r23;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        Intrinsics.checkNotNullParameter(r1, "descriptor");
        this.i = r1;
        String r2 = r1.k.j;
        if (r2 != null) goto L11;
    L13:
        r2 = null;
    L15:
        if (r2 != null) goto L20;
        LarusLayoutActionBarEditorWidgetImageSelectorBinding r3 = this.f;
        if (r3 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L19:
        e1.o(r3.e);
    L27:
        LarusLayoutActionBarEditorWidgetImageSelectorBinding r5 = this.f;
        if (r5 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L30:
        e1.o(r5.b);
        d0 r6 = r1.f;
        if (r6 == null) goto L33;
        List r7 = r6.a;
    L34:
        if (r7 != null) goto L36;
        r7 = CollectionsKt.emptyList();
    L36:
        d0 r8 = r1.f;
        int r9 = -1;
        if (r8 == null) goto L41;
        Integer r10 = r8.b;
        if (r10 == null) goto L41;
        int r11 = r10.intValue();
    L42:
        List r12 = r7;
        if ((r12 instanceof Collection) == true) goto L45;
    L47:
        Iterator r13 = r12.iterator();
    L49:
        if (r13.hasNext() == false) goto L59;
        Integer r14 = ((w) r13.next()).s;
        if (r14 != null) goto L54;
    L56:
        boolean r15 = false;
    L57:
        if (r15 == false) goto L49;
        boolean r16 = true;
    L60:
        ArrayList r17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r18 = r12.iterator();
        int r19 = 0;
    L62:
        if (r18.hasNext() == false) goto L72;
        Object r110 = r18.next();
        int r111 = r19 + 1;
        if (r19 >= 0) goto L66;
        CollectionsKt.throwIndexOverflow();
    L66:
        w r112 = (w) r110;
        if (r16 == true) goto L70;
        if (r19 != r11) goto L70;
        w r113 = w.a(r112, null, null, 1, null, null, null, 8126463);
    L71:
        r17.add(r113);
        r19 = r111;
    L70:
        r113 = w.a(r112, null, null, null, null, null, null, 8388607);
        goto L71
    L72:
        List<w> r20 = CollectionsKt.toMutableList(r17);
        if (this.g != null) goto L75;
        setupAdapter(r1);
    L75:
        ImageSelectorWidgetAdapter r21 = this.g;
        if (r21 == null) goto L79;
        r21.submitList(r20);
    L79:
        if (r1.l == false) goto L104;
        Iterator<w> r22 = r20.iterator();
        int r24 = 0;
    L82:
        if (r22.hasNext() == false) goto L93;
        Integer r114 = r22.next().s;
        if (r114 != null) goto L87;
    L89:
        boolean r115 = false;
    L90:
        if (r115 == true) goto L91;
        r24 = r24 + 1;
        goto L82
    L91:
        r9 = r24;
        goto L93
    L87:
        if (r114.intValue() != 1) goto L89;
        r115 = true;
    L93:
        if (r9 < 0) goto L104;
        if (r1.i == false) goto L97;
        r9 = r9 + 1;
    L97:
        LarusLayoutActionBarEditorWidgetImageSelectorBinding r25 = this.f;
        if (r25 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L101:
        RecyclerView.LayoutManager r26 = r4.c.getLayoutManager();
        if (r26 == null) goto L104;
        r26.scrollToPosition(r9);
        goto L104
    L100:
        r4 = r25;
    L104:
        this.j = r20;
        return;
    L54:
        if (r14.intValue() != 1) goto L56;
        r15 = true;
    L59:
        r16 = false;
        goto L60
    L45:
        if (r12.isEmpty() == false) goto L47;
    L41:
        r11 = -1;
        goto L42
    L33:
        r7 = null;
        goto L34
    L20:
        LarusLayoutActionBarEditorWidgetImageSelectorBinding r27 = this.f;
        if (r27 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r27 = null;
    L23:
        r27.e.setText(r2);
        LarusLayoutActionBarEditorWidgetImageSelectorBinding r28 = this.f;
        if (r28 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r28 = null;
    L26:
        e1.x(r28.e);
        goto L27
    L11:
        if ((!StringsKt.isBlank(r2)) == false) goto L13;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        this.f = LarusLayoutActionBarEditorWidgetImageSelectorBinding.a(LayoutInflater.from(r1), this);
    }

    public KmpMusicTemplateSelectorWidget(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.j = CollectionsKt.emptyList();
        this.k = new a(this);
    }

    public /* synthetic */ KmpMusicTemplateSelectorWidget(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
