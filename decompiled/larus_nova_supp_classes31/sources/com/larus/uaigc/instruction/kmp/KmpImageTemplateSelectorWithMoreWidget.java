package com.larus.uaigc.instruction.kmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.actionbar.model.n;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.uaigc.impl.databinding.LarusItemActionbarImageTemplateCoverHolderV2Binding;
import com.larus.uaigc.impl.databinding.LarusLayoutActionBarEditorWidgetImageSelectorV2Binding;
import com.larus.uaigc.instruction.widget.ImageSelectorWithMoreWidgetAdapter;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import cq8.a0;
import cq8.q;
import cq8.w;
import cq8.z;
import cq8.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001/\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J\u001a\u00101\u001a\u00020)2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0012\u00102\u001a\u00020)2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u00103\u001a\u00020)H\u0014J\u0010\u00104\u001a\u00020)2\u0006\u0010\u000f\u001a\u000205H\u0014J\u0010\u00106\u001a\u00020)2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u00107\u001a\u00020)2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u00108\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\b\u00109\u001a\u00020)H\u0002J\b\u0010:\u001a\u00020)H\u0002J\u0010\u0010;\u001a\u00020)2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010>\u001a\u00020)2\u0006\u0010\u000f\u001a\u00020\u0010H\u0003J\b\u0010?\u001a\u00020)H\u0003J\b\u0010@\u001a\u00020)H\u0002J\b\u0010A\u001a\u00020)H\u0002J\u001c\u0010B\u001a\u00020)2\u0006\u0010C\u001a\u00020!2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eRW\u0010\u001f\u001aK\u0012\u0013\u0012\u00110!¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0015\u0012\u0013\u0018\u00010%¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(&\u0012\u0015\u0012\u0013\u0018\u00010'¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b((\u0012\u0004\u0012\u00020)0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0004\n\u0002\u00100R\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/larus/uaigc/instruction/kmp/KmpImageTemplateSelectorWithMoreWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/instruction/kmp/IKmpInstructionViewModelAware;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusLayoutActionBarEditorWidgetImageSelectorV2Binding;", "adapter", "Lcom/larus/uaigc/instruction/widget/ImageSelectorWithMoreWidgetAdapter;", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/ImageTemplateSelectorWithMoreDescriptor;", "isBound", "", "viewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "widgetScope", "Lkotlinx/coroutines/CoroutineScope;", "coverBinding", "Lcom/larus/uaigc/impl/databinding/LarusItemActionbarImageTemplateCoverHolderV2Binding;", "showCover", "localImageList", "", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "pendingInitialScrollPosition", "Ljava/lang/Integer;", "imageTemplateChoose", "Lkotlin/Function3;", "Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateInfo;", "Lkotlin/ParameterName;", "name", "templateInfo", "", "conversationId", "Landroid/net/Uri;", "localImagePath", "", "getSendMessageTrackExtMap", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$SendMessageTrackExtMap;", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "itemClickCallback", "com/larus/uaigc/instruction/kmp/KmpImageTemplateSelectorWithMoreWidget$itemClickCallback$1", "Lcom/larus/uaigc/instruction/kmp/KmpImageTemplateSelectorWithMoreWidget$itemClickCallback$1;", "init", "bindInstructionViewModel", "onDetachedFromWindow", "onDescriptorChanged", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "onBindView", "bindHeader", "createImageTemplateAdapter", "bindExposureTracking", "bindRecyclerViewSpacing", "scheduleInitialScroll", "initialScrollListener", "Landroid/view/View$OnLayoutChangeListener;", "render", "bindObservers", "requestTemplateList", "goToImageTemplateList", "selectImageTemplateInternal", "item", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class KmpImageTemplateSelectorWithMoreWidget extends AbsKmpInstructionWidget implements com.larus.bmhome.instruction.kmp.b {
    public static final /* synthetic */ int s = 0;
    public LarusLayoutActionBarEditorWidgetImageSelectorV2Binding f;
    public ImageSelectorWithMoreWidgetAdapter g;
    public w h;
    public boolean i;
    public com.larus.bmhome.view.actionbar.edit.c j;
    public final CoroutineScope k;
    public LarusItemActionbarImageTemplateCoverHolderV2Binding l;
    public boolean m;
    public List<com.larus.bmhome.actionbar.model.w> n;
    public Integer o;
    public final g p;
    public final a q;
    public final h r;

    public static final class a implements vz9.d {
        public final /* synthetic */ KmpImageTemplateSelectorWithMoreWidget a;

        @Override // vz9.d
        public final void b(com.larus.bmhome.actionbar.model.w r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "item");
        }

        public a(KmpImageTemplateSelectorWithMoreWidget r1) {
            this.a = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v2, types: [int] */
        /* JADX WARN: Type inference failed for: r3v5 */
        @Override // vz9.d
        public final void a(com.larus.bmhome.actionbar.model.w r50, int r51) {
            Intrinsics.checkNotNullParameter(r50, "item");
            w r2 = this.a.h;
            if (r2 != null) goto L5;
            return;
        L5:
            n r3 = r2.f;
            if (r3 == null) goto L8;
            ?? r4 = Intrinsics.areEqual(r3.c, Boolean.TRUE);
        L9:
            Iterator r5 = this.a.n.iterator();
        L10:
            Integer r7 = null;
            if (r5.hasNext() == false) goto L15;
            Object r6 = r5.next();
            if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.w) r6).a, r50.a) == false) goto L10;
        L16:
            com.larus.bmhome.actionbar.model.w r8 = (com.larus.bmhome.actionbar.model.w) r6;
            if (r8 == null) goto L20;
            r7 = r8.s;
        L20:
            if (r4 != 0) goto L26;
            if (r7 == null) goto L26;
            if (r7.intValue() != 1) goto L26;
            boolean r9 = true;
        L27:
            z r10 = r2.d;
            String r11 = r2.c;
            Long r12 = r50.a;
            if (r12 == null) goto L61;
            r10.a(new q(r11, r12.longValue(), r9));
            Iterator<com.larus.bmhome.actionbar.model.w> r13 = this.a.n.iterator();
            int r14 = 0;
        L31:
            if (r13.hasNext() == false) goto L36;
            if (Intrinsics.areEqual(r13.next().a, r50.a) == true) goto L38;
            r14 = r14 + 1;
        L38:
            if (this.a.m == false) goto L40;
            r14 = r14 - 1;
            int r15 = r51 - 1;
        L41:
            z0 r16 = r2.l;
            String r17 = r16.a;
            String r18 = r16.c;
            String r19 = r16.d;
            String r110 = r16.f;
            String r111 = r16.g;
            String r112 = r16.j;
            String r20 = r50.b;
            String r113 = String.valueOf(r50.a);
            n r1 = r2.f;
            if (r1 == null) goto L49;
            Integer r21 = r1.b;
            if (r21 == null) goto L49;
            if (r14 != r21.intValue()) goto L49;
            int r114 = 1;
        L50:
            Integer r115 = Integer.valueOf(r114);
            Integer r22 = Integer.valueOf(r4);
            Integer r23 = Integer.valueOf(r15 + 1);
            if (r9 == true) goto L53;
            String r24 = "select";
        L54:
            tx9.b.e(r17, r18, r19, r110, r111, r112, null, r20, r113, r115, r22, r23, r24, null, null, null, null, "original", null, null, null, null, null, null, r16.i, null, null, null, null, null, null, null, null, null, null, null, null, -33824704, 127);
            return;
        L53:
            r24 = "cancel";
        L49:
            r114 = 0;
            goto L50
        L40:
            r15 = r51;
            goto L41
        L36:
            r14 = -1;
            goto L38
        L61:
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

    public KmpImageTemplateSelectorWithMoreWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public KmpImageTemplateSelectorWithMoreWidget(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Lifecycle.State r2 = null;
        CoroutineScopeKt.cancel$default(this.k, null, 1, null);
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onDetachedFromWindow, current state is ");
        Fragment r3 = getFragment();
        if (r3 == null) goto L7;
        Lifecycle r4 = r3.getLifecycle();
        if (r4 == null) goto L7;
        r2 = r4.getCurrentState();
    L7:
        r1.append(r2);
        r0.i("KmpImageTemplateSelectorWithMoreWidget", r1.toString());
    }

    public final void L4(com.larus.bmhome.view.actionbar.edit.c r1) {
        this.j = r1;
    }

    public final void T5(a0 r26) {
        Intrinsics.checkNotNullParameter(r26, "descriptor");
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r3 = null;
        if ((r26 instanceof w) == false) goto L5;
        w r1 = (w) r26;
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        this.h = r1;
        if (this.i == true) goto L44;
        this.i = true;
        BuildersKt.launch$default(this.k, null, null, new KmpImageTemplateSelectorWithMoreWidget$bindObservers$1(this, null), 3, null);
        BuildersKt.launch$default(this.k, null, null, new KmpImageTemplateSelectorWithMoreWidget$bindObservers$2(this, null), 3, null);
        BuildersKt.launch$default(this.k, null, null, new KmpImageTemplateSelectorWithMoreWidget$bindObservers$3(this, null), 3, null);
        BuildersKt.launch$default(this.k, null, null, new KmpImageTemplateSelectorWithMoreWidget$bindObservers$4(this, null), 3, null);
        if (r1.h == false) goto L17;
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r2 = this.f;
        if (r2 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L15:
        e1.x(r2.b);
    L17:
        if (o0.d(r1.g) == false) goto L25;
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r4 = this.f;
        if (r4 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L21:
        r4.e.setText(r1.g);
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r5 = this.f;
        if (r5 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L24:
        e1.x(r5.e);
    L25:
        boolean r6 = r1.j;
        this.m = r6;
        if (r6 == false) goto L28;
        ImageSelectorWithMoreWidgetAdapter r7 = new ImageSelectorWithMoreWidgetAdapter(this.q, new d(this));
    L29:
        this.g = r7;
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r8 = this.f;
        if (r8 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L32:
        y6.d(r8.c, new e(this), null, null, new f(this), 13);
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r9 = this.f;
        if (r9 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L35:
        r9.c.addItemDecoration(new KmpImageTemplateSelectorWithMoreWidget$bindRecyclerViewSpacing$1());
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r10 = this.f;
        if (r10 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L38:
        r10.c.setAdapter(this.g);
        int r11 = r1.m;
        if (r11 <= 0) goto L44;
        this.o = Integer.valueOf(r11 + (this.m ? 1 : 0));
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r12 = this.f;
        if (r12 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L43:
        r12.c.addOnLayoutChangeListener(this.r);
        goto L44
    L28:
        r7 = new ImageSelectorWithMoreWidgetAdapter(this.q, null);
    L44:
        n r13 = r1.f;
        if (r13 == null) goto L47;
        List r14 = r13.a;
    L48:
        if (r14 != null) goto L50;
        r14 = CollectionsKt.emptyList();
    L50:
        List r15 = r14;
        ArrayList r16 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r17 = r15.iterator();
    L52:
        if (r17.hasNext() == false) goto L54;
        r16.add(com.larus.bmhome.actionbar.model.w.a((com.larus.bmhome.actionbar.model.w) r17.next(), null, null, null, null, null, null, 8388607));
        goto L52
    L54:
        ImageSelectorWithMoreWidgetAdapter r18 = this.g;
        if (r18 == null) goto L57;
        Lazy<JSONObject> r19 = ImageSelectorWithMoreWidgetAdapter.e;
        r18.y2(r16, true);
    L57:
        this.n = r16;
        com.larus.bmhome.view.actionbar.edit.c r20 = this.j;
        if (r20 == null) goto L61;
        r20.setCurImageList(r16);
    L61:
        if (r1.m >= 0) goto L63;
        return;
    L63:
        if (this.o != null) goto L74;
        LarusLayoutActionBarEditorWidgetImageSelectorV2Binding r21 = this.f;
        if (r21 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L68:
        RecyclerView.LayoutManager r22 = r3.c.getLayoutManager();
        if (r22 == null) goto L75;
        r22.scrollToPosition(r1.m + (this.m ? 1 : 0));
        return;
    L75:
        return;
    L67:
        r3 = r21;
        goto L68
    L74:
        return;
    L47:
        r14 = null;
        goto L48
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        this.f = LarusLayoutActionBarEditorWidgetImageSelectorV2Binding.a(LayoutInflater.from(r1), this);
    }

    /* JADX WARN: Type inference failed for: r2v8, types: [com.larus.uaigc.instruction.kmp.h] */
    public KmpImageTemplateSelectorWithMoreWidget(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.k = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
        this.n = CollectionsKt.emptyList();
        this.p = new g(this);
        this.q = new a(this);
        this.r = new h(this);
    }

    public /* synthetic */ KmpImageTemplateSelectorWithMoreWidget(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
