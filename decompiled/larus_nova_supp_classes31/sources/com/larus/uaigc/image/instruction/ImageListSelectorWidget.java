package com.larus.uaigc.image.instruction;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.actionbar.model.l;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.chat.ChatParam;
import com.larus.uaigc.impl.databinding.LarusLayoutActionBarEditorWidgetImageSelectorV2Binding;
import com.larus.uaigc.instruction.widget.ImageSelectorWidgetAdapter;
import com.larus.utils.e1;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u001dH\u0016J\b\u0010#\u001a\u00020\u001dH\u0002R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/uaigc/image/instruction/ImageListSelectorWidget;", "Lcom/larus/uaigc/image/instruction/AbsTemplateListEditorWidget;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "value", "Lcom/larus/uaigc/impl/databinding/LarusLayoutActionBarEditorWidgetImageSelectorV2Binding;", "binding", "getBinding", "()Lcom/larus/uaigc/impl/databinding/LarusLayoutActionBarEditorWidgetImageSelectorV2Binding;", "adapter", "Lcom/larus/uaigc/instruction/widget/ImageSelectorWidgetAdapter;", "controller", "Lcom/larus/uaigc/image/instruction/ImageListSelectorController;", "getController", "()Lcom/larus/uaigc/image/instruction/ImageListSelectorController;", "currentBindData", "Lcom/larus/bmhome/actionbar/model/ActionBarImageSelectorTemplate;", "getCurrentBindData", "()Lcom/larus/bmhome/actionbar/model/ActionBarImageSelectorTemplate;", "itemClickCallback", "com/larus/uaigc/image/instruction/ImageListSelectorWidget$itemClickCallback$1", "Lcom/larus/uaigc/image/instruction/ImageListSelectorWidget$itemClickCallback$1;", "templateListView", "Landroidx/recyclerview/widget/RecyclerView;", "getTemplateListView", "()Landroidx/recyclerview/widget/RecyclerView;", "init", "", "attrs", "Landroid/util/AttributeSet;", "onBindView", "collectStarted", "", "startObserveTemplateChoose", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ImageListSelectorWidget extends AbsTemplateListEditorWidget {
    public static final /* synthetic */ int l = 0;
    public LarusLayoutActionBarEditorWidgetImageSelectorV2Binding h;
    public ImageSelectorWidgetAdapter i;
    public final a j;
    public boolean k;

    public static final class a implements vz9.d {
        public final /* synthetic */ ImageListSelectorWidget a;

        @Override // vz9.d
        public final void b(w r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "item");
        }

        public a(ImageListSelectorWidget r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v10 */
        /* JADX WARN: Type inference failed for: r4v11, types: [int] */
        /* JADX WARN: Type inference failed for: r4v25 */
        @Override // vz9.d
        public final void a(w r53, int r54) {
            Intrinsics.checkNotNullParameter(r53, "item");
            ArrayList r2 = new ArrayList();
            l r3 = ImageListSelectorWidget.k6(this.a);
            Object r6 = null;
            if (r3 == null) goto L83;
            List r4 = r3.a;
            if (r4 == null) goto L83;
            ImageListSelectorWidget r8 = this.a;
            Iterator r5 = r4.iterator();
            int r9 = 0;
        L8:
            if (r5.hasNext() == false) goto L83;
            Object r10 = r5.next();
            int r11 = r9 + 1;
            if (r9 >= 0) goto L12;
            CollectionsKt.throwIndexOverflow();
        L12:
            w r12 = (w) r10;
            if (Intrinsics.areEqual(r12.a, r53.a) == false) goto L81;
            l r13 = ImageListSelectorWidget.k6(r8);
            if (r13 == null) goto L17;
            boolean r14 = Intrinsics.areEqual(r13.c, Boolean.FALSE);
        L18:
            if (r14 == false) goto L25;
            Integer r15 = r12.s;
            if (r15 == null) goto L25;
            if (r15.intValue() != 1) goto L25;
            r12.s = 0;
        L26:
            com.larus.bmhome.view.actionbar.edit.c r16 = r8.getViewModel();
            if (r16 == null) goto L31;
            ChatParam r17 = r16.getChatParam();
            if (r17 == null) goto L31;
            String r18 = r17.b;
        L32:
            com.larus.bmhome.view.actionbar.edit.c r19 = r8.getViewModel();
            if (r19 == null) goto L37;
            ChatParam r110 = r19.getChatParam();
            if (r110 == null) goto L37;
            String r111 = r110.e;
        L38:
            com.larus.bmhome.view.actionbar.edit.c r112 = r8.getViewModel();
            if (r112 == null) goto L41;
            String r113 = r112.getTemplateType();
        L42:
            com.larus.bmhome.view.actionbar.edit.c r114 = r8.getViewModel();
            if (r114 == null) goto L45;
            String r115 = r114.getActionBarType();
        L46:
            com.larus.bmhome.view.actionbar.edit.c r116 = r8.getViewModel();
            if (r116 == null) goto L51;
            z0 r117 = r116.getCurrentCustomActionBarItem();
            if (r117 == null) goto L51;
            String r118 = r117.b;
        L52:
            u r119 = r8.getInstructionItem();
            if (r119 == null) goto L55;
            String r120 = r119.c;
        L56:
            String r121 = r53.b;
            String r21 = String.valueOf(r53.a);
            l r7 = ImageListSelectorWidget.k6(r8);
            if (r7 == null) goto L64;
            Integer r20 = r7.b;
            if (r20 == null) goto L64;
            if (r9 != r20.intValue()) goto L64;
            int r22 = 1;
        L65:
            Integer r23 = Integer.valueOf(r22);
            l r24 = ImageListSelectorWidget.k6(r8);
            if (r24 == null) goto L68;
            ?? r25 = Intrinsics.areEqual(r24.c, Boolean.TRUE);
        L69:
            Integer r26 = Integer.valueOf(r25);
            Integer r27 = Integer.valueOf(r54 + 1);
            Integer r28 = r12.s;
            if (r28 != null) goto L73;
        L75:
            String r29 = "cancel";
        L76:
            String r210 = r29;
            com.larus.bmhome.view.actionbar.edit.c r30 = r8.getViewModel();
            if (r30 == null) goto L79;
            Boolean r37 = r30.isCreationActionBar();
        L80:
            tx9.b.e(r18, r111, r113, r115, r118, r120, null, r121, r21, r23, r26, r27, r210, null, null, null, null, "original", null, null, null, null, null, null, r37, null, null, null, null, null, null, null, null, null, null, null, null, -33824704, 127);
        L82:
            r2.add(r12);
            r9 = r11;
            goto L8
        L79:
            r37 = null;
            goto L80
        L73:
            if (r28.intValue() != 1) goto L75;
            r29 = "select";
            goto L76
        L68:
            r25 = 0;
        L64:
            r22 = 0;
            goto L65
        L55:
            r120 = null;
        L51:
            r118 = null;
            goto L52
        L45:
            r115 = null;
            goto L46
        L41:
            r113 = null;
        L37:
            r111 = null;
        L31:
            r18 = null;
        L25:
            r12.s = 1;
            goto L26
        L17:
            r14 = false;
            goto L18
        L81:
            r12.s = 0;
        L83:
            ImageSelectorWidgetAdapter r1 = this.a.i;
            if (r1 == null) goto L86;
            r1.submitList(r2);
        L86:
            l r31 = ImageListSelectorWidget.k6(this.a);
            if (r31 == null) goto L103;
            List r32 = r31.a;
            if (r32 == null) goto L103;
            Iterator r33 = r32.iterator();
        L92:
            if (r33.hasNext() == false) goto L102;
            Object r34 = r33.next();
            Integer r35 = ((w) r34).s;
            if (r35 != null) goto L97;
        L99:
            boolean r36 = false;
        L100:
            if (r36 == false) goto L92;
            r6 = r34;
            goto L102
        L97:
            if (r35.intValue() != 1) goto L99;
            r36 = true;
        L102:
            r6 = (w) r6;
        L103:
            u r38 = this.a.getInstructionItem();
            if (r38 == null) goto L111;
            Integer r39 = r38.a;
            if (r39 == null) goto L111;
            if (r39.intValue() != 1) goto L111;
            boolean r40 = true;
        L112:
            if (r40 == false) goto L128;
            com.larus.bmhome.view.actionbar.edit.c r41 = this.a.getViewModel();
            if (r41 == null) goto L129;
            if (r6 == null) goto L117;
            boolean r42 = true;
        L118:
            r41.setImageStyleRadioSelected(r42);
            return;
        L117:
            r42 = false;
            goto L118
        L129:
            return;
        L128:
            return;
        L111:
            r40 = false;
            goto L112
        }
    }

    public final LarusLayoutActionBarEditorWidgetImageSelectorV2Binding getBinding() {
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r0 = this.h;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    private final com.larus.uaigc.image.instruction.a getController() {
        return (com.larus.uaigc.image.instruction.a) getController();
    }

    private final l getCurrentBindData() {
        com.larus.uaigc.image.instruction.a r0 = getController();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.l;
    }

    public final void Y5() {
        u r0 = getInstructionItem();
        boolean r1 = false;
        if (r0 == null) goto L5;
        boolean r2 = Intrinsics.areEqual(r0.f, Boolean.TRUE);
    L6:
        if (r2 == false) goto L8;
        e1.x(getBinding().b);
    L8:
        u r3 = getInstructionItem();
        if (r3 == null) goto L11;
        String r4 = r3.c;
    L13:
        if (o0.d(r4) == false) goto L19;
        TextView r5 = getBinding().e;
        u r6 = getInstructionItem();
        if (r6 == null) goto L17;
        String r7 = r6.c;
    L18:
        r5.setText(r7);
        e1.x(getBinding().e);
        goto L19
    L17:
        r7 = null;
    L19:
        y6.d(getBinding().c, null, null, null, new b(this), 15);
        this.i = new ImageSelectorWidgetAdapter(this.j, null);
        getBinding().c.setAdapter(this.i);
        getBinding().c.addItemDecoration(new ImageListSelectorWidget$onBindView$2());
        l r8 = getCurrentBindData();
        if (r8 == null) goto L24;
        Integer r9 = r8.b;
        if (r9 == null) goto L24;
        int r10 = r9.intValue();
    L25:
        this.f = Integer.valueOf(r10);
        if (r10 < 0) goto L35;
        l r11 = getCurrentBindData();
        if (r11 == null) goto L32;
        List r12 = r11.a;
        if (r12 == null) goto L32;
        w r13 = (w) CollectionsKt.getOrNull(r12, r10);
    L33:
        if (r13 == null) goto L35;
        r13.s = 1;
    L32:
        r13 = null;
    L35:
        l r14 = getCurrentBindData();
        if (r14 == null) goto L51;
        List r15 = r14.a;
        if (r15 == null) goto L51;
        ArrayList r16 = new ArrayList();
        Iterator r17 = r15.iterator();
    L41:
        if (r17.hasNext() == false) goto L52;
        Object r18 = r17.next();
        Integer r19 = ((w) r18).s;
        if (r19 != null) goto L46;
    L48:
        boolean r20 = false;
    L49:
        if (r20 == false) goto L41;
        r16.add(r18);
        goto L41
    L46:
        if (r19.intValue() != 1) goto L48;
        r20 = true;
    L52:
        if (r16 != null) goto L54;
    L57:
        boolean r21 = true;
    L58:
        if (r21 == true) goto L71;
        u r22 = getInstructionItem();
        if (r22 == null) goto L67;
        Integer r23 = r22.a;
        if (r23 == null) goto L67;
        if (r23.intValue() != 1) goto L67;
        r1 = true;
    L67:
        if (r1 == false) goto L71;
        com.larus.bmhome.view.actionbar.edit.c r24 = getViewModel();
        if (r24 == null) goto L71;
        r24.setImageStyleRadioSelected(true);
    L71:
        ImageSelectorWidgetAdapter r25 = this.i;
        if (r25 == null) goto L79;
        l r26 = getCurrentBindData();
        if (r26 == null) goto L76;
        List<w> r27 = r26.a;
    L77:
        r25.submitList(r27);
        goto L79
    L76:
        r27 = null;
    L79:
        if (this.k == true) goto L94;
        this.k = true;
        com.larus.bmhome.view.actionbar.edit.c r28 = getViewModel();
        if (r28 == null) goto L92;
        CoroutineScope r29 = r28.getCurrentViewModelScope();
        if (r29 == null) goto L93;
        BuildersKt.launch$default(r29, null, null, new ImageListSelectorWidget$startObserveTemplateChoose$1(this, null), 3, null);
        return;
    L93:
        return;
    L92:
        return;
    L94:
        return;
    L54:
        if (r16.isEmpty() == true) goto L57;
        r21 = false;
    L51:
        r16 = null;
    L24:
        r10 = -1;
        goto L25
    L11:
        r4 = null;
        goto L13
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.larus.uaigc.image.instruction.AbsTemplateListEditorWidget
    public RecyclerView getTemplateListView() {
        return getBinding().c;
    }

    public ImageListSelectorWidget(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.j = new a(this);
    }

    public static final /* synthetic */ l k6(ImageListSelectorWidget r0) {
        return r0.getCurrentBindData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V5(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        this.h = LarusLayoutActionBarEditorWidgetImageSelectorV2Binding.a(LayoutInflater.from(r1), this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [int] */
    public static void i6(ImageListSelectorWidget r28, int r29, RecyclerView.ViewHolder r30) {
        Intrinsics.checkNotNullParameter(r30, "<unused var>");
        ImageSelectorWidgetAdapter r2 = r28.i;
        Boolean r3 = null;
        if (r2 == null) goto L7;
        List<w> r4 = r2.c;
        if (r4 == null) goto L7;
        w r5 = (w) CollectionsKt.getOrNull(r4, r29);
    L8:
        if (r5 == null) goto L56;
        com.larus.bmhome.view.actionbar.edit.c r6 = r28.getViewModel();
        if (r6 == null) goto L14;
        ChatParam r7 = r6.getChatParam();
        if (r7 == null) goto L14;
        String r8 = r7.b;
    L15:
        com.larus.bmhome.view.actionbar.edit.c r9 = r28.getViewModel();
        if (r9 == null) goto L20;
        ChatParam r10 = r9.getChatParam();
        if (r10 == null) goto L20;
        String r11 = r10.e;
    L21:
        com.larus.bmhome.view.actionbar.edit.c r12 = r28.getViewModel();
        if (r12 == null) goto L24;
        String r13 = r12.getTemplateType();
    L25:
        com.larus.bmhome.view.actionbar.edit.c r14 = r28.getViewModel();
        if (r14 == null) goto L28;
        String r15 = r14.getActionBarType();
    L29:
        com.larus.bmhome.view.actionbar.edit.c r16 = r28.getViewModel();
        if (r16 == null) goto L34;
        z0 r17 = r16.getCurrentCustomActionBarItem();
        if (r17 == null) goto L34;
        String r18 = r17.b;
    L35:
        u r19 = r28.getInstructionItem();
        if (r19 == null) goto L38;
        String r110 = r19.c;
    L39:
        String r111 = r5.b;
        String r112 = String.valueOf(r5.a);
        l r20 = r28.getCurrentBindData();
        ?? r21 = 0;
        if (r20 == null) goto L47;
        Integer r22 = r20.b;
        if (r22 == null) goto L47;
        if (r29 != r22.intValue()) goto L47;
        int r23 = 1;
    L48:
        Integer r24 = Integer.valueOf(r23);
        l r113 = r28.getCurrentBindData();
        if (r113 == null) goto L51;
        r21 = Intrinsics.areEqual(r113.c, Boolean.TRUE);
    L51:
        Integer r114 = Integer.valueOf(r21);
        Integer r115 = Integer.valueOf(r29 + 1);
        com.larus.bmhome.view.actionbar.edit.c r0 = r28.getViewModel();
        if (r0 == null) goto L54;
        r3 = r0.isCreationActionBar();
    L54:
        tx9.b.f(r8, r11, r13, r15, r18, r110, null, r111, r112, r24, r114, r115, null, null, null, null, null, null, null, null, null, r3, 4190272);
        return;
    L47:
        r23 = 0;
        goto L48
    L38:
        r110 = null;
    L34:
        r18 = null;
        goto L35
    L28:
        r15 = null;
        goto L29
    L24:
        r13 = null;
    L20:
        r11 = null;
    L14:
        r8 = null;
        goto L15
    L56:
        return;
    L7:
        r5 = null;
        goto L8
    }
}
