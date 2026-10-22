package com.larus.bmhome.view.actionbar.edit.component;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.common_ui.widget.ShadowLayout;
import com.larus.instruction.impl.databinding.LarusItemActionbarDropdownListBinding;
import com.larus.utils.logger.FLogger;
import com.skydoves.balloon.Balloon;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import v19.c7;
import v19.i5;
import v19.y6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012*\u0002(A\u0018\u0000 e2\u00020\u00012\u00020\u0002:\u0001eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010-\u001a\u00020.2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\b\u00101\u001a\u00020.H\u0016J\b\u00103\u001a\u00020.H\u0002J\b\u00104\u001a\u00020!H\u0002J\u0010\u00105\u001a\n\u0012\u0004\u0012\u000207\u0018\u000106H\u0002J\b\u00108\u001a\u00020!H\u0002J\b\u00109\u001a\u00020.H\u0002J\u0017\u0010:\u001a\u00020.2\b\u0010;\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0002\u0010<J\b\u0010=\u001a\u00020.H\u0002J\u001a\u0010>\u001a\u0004\u0018\u0001072\u000e\u0010?\u001a\n\u0012\u0004\u0012\u000207\u0018\u000106H\u0002J\u0018\u0010C\u001a\u00020.2\u0006\u0010D\u001a\u00020\u00192\u0006\u0010E\u001a\u000207H\u0002J\b\u0010F\u001a\u00020GH\u0002J\b\u0010H\u001a\u00020!H\u0002J\f\u0010I\u001a\u00020!*\u00020JH\u0002J\u001f\u0010K\u001a\u00020.2\b\u0010L\u001a\u0004\u0018\u00010\u000f2\u0006\u0010M\u001a\u00020GH\u0002¢\u0006\u0002\u0010NJ \u0010O\u001a\u00020.2\u0006\u0010P\u001a\u0002072\u0006\u0010Q\u001a\u00020\u00192\u0006\u0010M\u001a\u00020GH\u0002J\u0018\u0010R\u001a\u00020\u00192\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020TH\u0002J\u0012\u0010V\u001a\u0004\u0018\u00010T2\u0006\u0010S\u001a\u00020TH\u0002J\u0018\u0010W\u001a\u00020\u00192\u0006\u0010X\u001a\u00020T2\u0006\u0010Y\u001a\u00020\u0019H\u0002J\u0010\u0010Z\u001a\u00020\u00192\u0006\u0010U\u001a\u00020TH\u0002J\u0010\u0010[\u001a\u00020\u00192\u0006\u0010U\u001a\u00020TH\u0002J\u0010\u0010\\\u001a\u00020\u00192\u0006\u0010U\u001a\u00020TH\u0002J\u000f\u0010]\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\u0010\u001bJ\n\u0010^\u001a\u0004\u0018\u00010GH\u0016J\b\u0010_\u001a\u00020.H\u0002J\b\u0010`\u001a\u00020!H\u0002J\b\u0010a\u001a\u00020!H\u0002J\u0010\u0010b\u001a\u00020.2\u0006\u0010c\u001a\u00020\u0015H\u0002J\u0010\u0010d\u001a\u00020.2\u0006\u0010c\u001a\u00020\u0015H\u0002R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0004\n\u0002\u0010)R\u001e\u0010*\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000f@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b+\u0010,R\u000e\u00102\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u00020AX\u0082\u000e¢\u0006\u0004\n\u0002\u0010B¨\u0006f"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/component/DropdownSelectorWidget;", "Lcom/larus/bmhome/instruction/base/AbsInstructionWidget;", "Lcom/larus/uaigc/creation/IReportInstructionWidget;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "value", "Lcom/larus/instruction/impl/databinding/LarusItemActionbarDropdownListBinding;", "binding", "getBinding", "()Lcom/larus/instruction/impl/databinding/LarusItemActionbarDropdownListBinding;", "balloon", "Lcom/skydoves/balloon/Balloon;", "disMissTime", "", "controller", "Lcom/larus/bmhome/view/actionbar/edit/controller/DropdownSelectorController;", "getController", "()Lcom/larus/bmhome/view/actionbar/edit/controller/DropdownSelectorController;", "currentBindData", "Lcom/larus/bmhome/actionbar/model/ActionBarDropdownBox;", "getCurrentBindData", "()Lcom/larus/bmhome/actionbar/model/ActionBarDropdownBox;", "dropdownBoxStyle", "", "getDropdownBoxStyle", "()Ljava/lang/Integer;", "keva", "Lcom/bytedance/keva/Keva;", "getKeva", "()Lcom/bytedance/keva/Keva;", "haveTryReadDraft", "", "buttonShowReported", "lastPhotoInMotionModelConfigId", "Ljava/lang/Long;", "optionAdapter", "Lcom/larus/bmhome/view/actionbar/edit/component/DropdownItemAdapter;", "widthFixItemDecoration", "com/larus/bmhome/view/actionbar/edit/component/DropdownSelectorWidget$widthFixItemDecoration$1", "Lcom/larus/bmhome/view/actionbar/edit/component/DropdownSelectorWidget$widthFixItemDecoration$1;", "selectedIdWhenNoMedia", "setSelectedIdWhenNoMedia", "(J)V", "init", "", "attrs", "Landroid/util/AttributeSet;", "onBindView", "collectStarted", "observeDataChange", "isRatio", "getVisibleOptionList", "", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "isVideoModelSelection", "observeSelectVideoModel", "notifyPhotoInMotionModelConfig", "selectedModelId", "(Ljava/lang/Long;)V", "updateDropdownBoxUi", "selectedOption", "optionList", "itemSelectedCallback", "com/larus/bmhome/view/actionbar/edit/component/DropdownSelectorWidget$itemSelectedCallback$1", "Lcom/larus/bmhome/view/actionbar/edit/component/DropdownSelectorWidget$itemSelectedCallback$1;", "savePendingSubscribeRestore", "dropdownBoxId", "option", "resolveCreationSubscriptionEnterMethod", "", "tryApplyPendingSubscribeSelection", "matchesCurrentWidget", "Lcom/larus/bmhome/view/actionbar/edit/component/PendingDropdownSubscribeRestore;", "onItemSelectedInternal", "selectedSpinnerItemId", "optionSource", "(Ljava/lang/Long;Ljava/lang/String;)V", "onItemUnselectedInternal", "selectedSpinnerItem", "bindingAdapterPosition", "getDropdownMenuXOff", "anchorView", "Landroid/view/View;", "menuView", "getDropdownMenuStartBoundaryView", "getDropdownMenuStartBoundaryX", "targetView", "anchorStartX", "getDropdownMenuVisualStartInset", "getShadowContentStartInset", "measureDropdownMenuWidth", "getImageEditFunctionId", "getButtonName", "observeSelectModel", "isModelSelector", "isDurationSelector", "trackButtonShow", "data", "trackButtonClick", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DropdownSelectorWidget extends AbsInstructionWidget implements com.larus.uaigc.creation.e {
    public static u1 q;
    public LarusItemActionbarDropdownListBinding f;
    public Balloon g;
    public long h;
    public boolean i;
    public boolean j;
    public Long k;
    public DropdownItemAdapter l;
    public final DropdownSelectorWidget$widthFixItemDecoration$1 m;
    public long n;
    public boolean o;
    public final b p;

    public static final class a {
    }

    public static final class b implements b1 {
        public final /* synthetic */ DropdownSelectorWidget a;
        public final /* synthetic */ Context b;

        public b(DropdownSelectorWidget r1, Context r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final void b(int r2, com.larus.bmhome.actionbar.model.w r3) {
            Intrinsics.checkNotNullParameter(r3, "selectedSpinnerItem");
            k0 r4 = j0.a(r3, r2, DropdownSelectorWidget.H6(this.a));
            if (r4 == null) goto L8;
            Intrinsics.checkNotNullParameter(r4, "<this>");
            ICommerceMembershipService.a.getClass();
            ICommerceMembershipService r5 = ICommerceMembershipService.a.a();
            if (r5 == null) goto L9;
            r5.s(r4.c, null);
            return;
        L9:
            return;
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final void a(int r7, com.larus.bmhome.actionbar.model.w r8, int r9) {
            Intrinsics.checkNotNullParameter(r8, "selectedSpinnerItem");
            DropdownSelectorWidget r10 = this.a;
            u1 r0 = DropdownSelectorWidget.q;
            boolean r1 = false;
            if (r10.V6() == false) goto L20;
            Long r11 = r8.a;
            if (r11 == null) goto L20;
            if (r11.longValue() != 3) goto L20;
            com.larus.bmhome.view.actionbar.edit.c r12 = this.a.getViewModel();
            if (r12 == null) goto L16;
            Long r13 = r12.getSelectedVideoModelId();
            if (r13 == null) goto L16;
            if (r13.longValue() != 4) goto L16;
            boolean r14 = true;
        L17:
            if (r14 == true) goto L20;
            t19.s.a.g(AppHost.a.getApplication(), 2131899511, false);
            return;
        L16:
            r14 = false;
        L20:
            Balloon r15 = this.a.g;
            if (r15 == null) goto L23;
            r15.h();
        L23:
            com.larus.bmhome.actionbar.model.h r16 = DropdownSelectorWidget.o6(this.a);
            if (r16 == null) goto L26;
            r1 = Intrinsics.areEqual(r16.h, Boolean.TRUE);
        L26:
            if (r1 == false) goto L33;
            Integer r17 = r8.s;
            if (r17 == null) goto L33;
            if (r17.intValue() != 1) goto L33;
            DropdownSelectorWidget.C6(this.a, r8, r9);
            return;
        L33:
            this.a.r7(r8.a, "original");
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final boolean c(int r11, com.larus.bmhome.actionbar.model.w r12, int r13) {
            Intrinsics.checkNotNullParameter(r12, "selectedSpinnerItem");
            Balloon r14 = this.a.g;
            if (r14 == null) goto L5;
            r14.h();
        L5:
            DropdownSelectorWidget r15 = this.a;
            com.larus.bmhome.view.actionbar.edit.c r0 = r15.getViewModel();
            u1 r1 = null;
            Integer r2 = null;
            if (r0 == null) goto L8;
            com.larus.bmhome.actionbar.model.z0 r3 = r0.getCurrentCustomActionBarItem();
        L9:
            Long r4 = r12.a;
            if (r4 == null) goto L22;
            long r8 = r4.longValue();
            if (r3 == null) goto L14;
            String r5 = r3.b;
        L15:
            if (r3 == null) goto L17;
            Long r6 = r3.a;
        L18:
            com.larus.bmhome.actionbar.model.u r16 = r15.getInstructionItem();
            if (r16 == null) goto L21;
            r2 = r16.a;
        L21:
            r1 = new u1(r5, r6, r2, r11, r8);
            goto L22
        L17:
            r6 = null;
            goto L18
        L14:
            r5 = null;
        L22:
            DropdownSelectorWidget.q = r1;
            String r17 = DropdownSelectorWidget.H6(this.a);
            k0 r18 = j0.a(r12, r11, r17);
            if (r18 != null) goto L26;
            return false;
        L26:
            y0.a(this.b, r18, r17);
            return true;
        L8:
            r3 = null;
            goto L9
        }
    }

    static {
    }

    public int getMultiItemType() {
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void Y5() {
        u1 r1 = q;
        String r2 = null;
        if (r1 == null) goto L92;
        com.larus.bmhome.view.actionbar.edit.c r5 = getViewModel();
        if (r5 == null) goto L8;
        com.larus.bmhome.actionbar.model.z0 r6 = r5.getCurrentCustomActionBarItem();
    L9:
        Integer r7 = r1.c;
        com.larus.bmhome.actionbar.model.u r8 = getInstructionItem();
        if (r8 == null) goto L12;
        Integer r9 = r8.a;
    L14:
        if (Intrinsics.areEqual(r7, r9) == false) goto L55;
        com.larus.bmhome.actionbar.model.h r10 = getCurrentBindData();
        if (r10 == null) goto L23;
        int r11 = r1.d;
        Integer r12 = r10.b;
        if (r12 == null) goto L23;
        if (r11 != r12.intValue()) goto L23;
        boolean r13 = true;
    L24:
        if (r13 == false) goto L55;
        String r14 = r1.a;
        if (r14 != null) goto L29;
    L37:
        Long r15 = r1.b;
        if (r15 != null) goto L40;
    L54:
        boolean r16 = true;
    L56:
        if (r16 == false) goto L92;
        com.larus.bmhome.actionbar.model.h r17 = getCurrentBindData();
        if (r17 == null) goto L92;
        Integer r18 = r17.b;
        int r19 = r1.d;
        if (r18 != null) goto L64;
    L66:
        boolean r20 = false;
    L67:
        if (r20 == true) goto L70;
        r17 = null;
    L70:
        if (r17 == null) goto L92;
        List r21 = r17.e;
        if (r21 == null) goto L92;
        Iterator r22 = r21.iterator();
    L75:
        if (r22.hasNext() == false) goto L85;
        Object r23 = r22.next();
        Long r24 = ((com.larus.bmhome.actionbar.model.w) r23).a;
        long r25 = r1.e;
        if (r24 != null) goto L80;
    L82:
        boolean r26 = false;
    L83:
        if (r26 == false) goto L75;
    L86:
        com.larus.bmhome.actionbar.model.w r27 = (com.larus.bmhome.actionbar.model.w) r23;
        if (r27 == null) goto L92;
        if (com.larus.bmhome.view.actionbar.edit.component.b.f(r27) != null) goto L92;
        q = null;
        r7(r27.a, "subscribe_return");
        goto L92
    L80:
        if (r24.longValue() != r25) goto L82;
        r26 = true;
        goto L83
    L85:
        r23 = null;
        goto L86
    L64:
        if (r18.intValue() != r19) goto L66;
        r20 = true;
        goto L67
    L40:
        if (r15.longValue() <= 0) goto L42;
        boolean r28 = true;
    L43:
        if (r28 == true) goto L46;
        r15 = null;
    L46:
        if (r15 == null) goto L54;
        long r29 = r15.longValue();
        if (r6 == null) goto L55;
        Long r30 = r6.a;
        if (r30 == null) goto L55;
        if (r30.longValue() != r29) goto L55;
    L42:
        r28 = false;
        goto L43
    L29:
        if ((!StringsKt.isBlank(r14)) == true) goto L32;
        r14 = null;
    L32:
        if (r14 == null) goto L37;
        if (r6 == null) goto L35;
        String r31 = r6.b;
    L36:
        r16 = Intrinsics.areEqual(r31, r14);
        goto L56
    L35:
        r31 = null;
    L23:
        r13 = false;
    L55:
        r16 = false;
        goto L56
    L12:
        r9 = null;
        goto L14
    L8:
        r6 = null;
    L92:
        w7();
        CoroutineScope r32 = getComponentScope();
        if (r32 == null) goto L96;
        BuildersKt.launch$default(r32, null, null, new DropdownSelectorWidget$onBindView$1(this, null), 3, null);
    L96:
        if (this.o == true) goto L119;
        this.o = true;
        if (f7() == false) goto L107;
        CoroutineScope r33 = getComponentScope();
        if (r33 == null) goto L103;
        BuildersKt.launch$default(r33, null, null, new DropdownSelectorWidget$observeDataChange$1(this, null), 3, null);
    L103:
        CoroutineScope r110 = getComponentScope();
        if (r110 == null) goto L107;
        BuildersKt.launch$default(r110, null, null, new DropdownSelectorWidget$observeDataChange$2(this, null), 3, null);
    L107:
        if (W6() == false) goto L112;
        CoroutineScope r34 = getComponentScope();
        if (r34 == null) goto L112;
        BuildersKt.launch$default(r34, null, null, new DropdownSelectorWidget$observeSelectModel$1(this, null), 3, null);
    L112:
        if (l7() == false) goto L119;
        CoroutineScope r3 = getComponentScope();
        if (r3 == null) goto L116;
        com.larus.bmhome.view.actionbar.edit.utils.a.a(r3, new DropdownSelectorWidget$observeSelectVideoModel$1(this, null));
    L116:
        CoroutineScope r4 = getComponentScope();
        if (r4 == null) goto L119;
        com.larus.bmhome.view.actionbar.edit.utils.a.a(r4, new DropdownSelectorWidget$observeDataChange$3(this, null));
    L119:
        com.larus.bmhome.view.actionbar.edit.c r35 = getViewModel();
        if (r35 == null) goto L122;
        r35.onComponentVisibilityChanged(this, true);
    L122:
        com.larus.bmhome.actionbar.model.h r36 = getCurrentBindData();
        if (r36 != null) goto L125;
        return;
    L125:
        if (this.j == true) goto L174;
        this.j = true;
        com.larus.bmhome.view.actionbar.edit.c r37 = getViewModel();
        if (r37 == null) goto L132;
        ChatParam r38 = r37.getChatParam();
        if (r38 == null) goto L132;
        String r39 = r38.b;
    L133:
        com.larus.bmhome.view.actionbar.edit.c r40 = getViewModel();
        if (r40 == null) goto L138;
        ChatParam r41 = r40.getChatParam();
        if (r41 == null) goto L138;
        String r42 = r41.e;
    L139:
        com.larus.bmhome.view.actionbar.edit.c r43 = getViewModel();
        if (r43 == null) goto L142;
        String r44 = r43.getTemplateType();
    L143:
        com.larus.bmhome.view.actionbar.edit.c r45 = getViewModel();
        if (r45 == null) goto L146;
        String r46 = r45.getActionBarType();
    L147:
        com.larus.bmhome.view.actionbar.edit.c r47 = getViewModel();
        if (r47 == null) goto L152;
        com.larus.bmhome.actionbar.model.z0 r48 = r47.getCurrentCustomActionBarItem();
        if (r48 == null) goto L152;
        String r111 = r48.b;
    L153:
        String r112 = r36.c;
        String r113 = String.valueOf(r36.b);
        com.larus.bmhome.view.actionbar.edit.c r49 = getViewModel();
        if (r49 == null) goto L156;
        Boolean r210 = r49.isCreationActionBar();
    L157:
        com.larus.bmhome.view.actionbar.edit.c r50 = getViewModel();
        if (r50 == null) goto L162;
        ChatParam r51 = r50.getChatParam();
        if (r51 == null) goto L162;
        r2 = r51.c;
    L162:
        String r211 = r2;
        com.larus.bmhome.actionbar.model.h r52 = getCurrentBindData();
        if (r52 == null) goto L165;
        boolean r53 = Intrinsics.areEqual(r52.h, Boolean.TRUE);
    L166:
        tx9.b.f(r39, r42, r44, r46, r111, null, null, r112, r113, 0, Integer.valueOf(!r53), null, null, null, null, "chat", null, null, null, "chat", r211, r210, 981088);
        return;
    L165:
        r53 = 0;
        goto L166
    L156:
        r210 = null;
    L152:
        r111 = null;
        goto L153
    L146:
        r46 = null;
        goto L147
    L142:
        r44 = null;
    L138:
        r42 = null;
    L132:
        r39 = null;
        goto L133
    }

    public final LarusItemActionbarDropdownListBinding getBinding() {
        LarusItemActionbarDropdownListBinding r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void w7() {
        final com.larus.bmhome.actionbar.model.h r8 = getCurrentBindData();
        if (r8 == null) goto L129;
        getBinding().c.setText(r8.c);
        com.larus.utils.e1.x(getBinding().c);
        List<com.larus.bmhome.actionbar.model.w> r0 = getVisibleOptionList();
        if (f7() == false) goto L10;
        com.larus.bmhome.view.actionbar.edit.c r1 = getViewModel();
        if (r1 == null) goto L10;
        r1.setRatioOptionList(r0);
    L10:
        if (l7() == false) goto L34;
        com.larus.bmhome.view.actionbar.edit.c r2 = getViewModel();
        if (r2 == null) goto L14;
        Long r3 = r2.getSelectedVideoModelId();
    L15:
        if (r0 == null) goto L34;
        List<com.larus.bmhome.actionbar.model.w> r5 = r0;
        Iterator<T> r6 = r5.iterator();
    L18:
        if (r6.hasNext() == false) goto L22;
        Object r7 = r6.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.w) r7).a, r3) == false) goto L18;
    L23:
        com.larus.bmhome.actionbar.model.w r9 = (com.larus.bmhome.actionbar.model.w) r7;
        if (r9 == null) goto L34;
        Iterator<T> r4 = r5.iterator();
    L27:
        if (r4.hasNext() == false) goto L33;
        com.larus.bmhome.actionbar.model.w r10 = (com.larus.bmhome.actionbar.model.w) r4.next();
        if (r10 != r9) goto L31;
        int r11 = 1;
    L32:
        r10.s = r11;
        goto L27
    L31:
        r11 = 0;
        goto L32
    L33:
        final com.larus.bmhome.actionbar.model.w r12 = r9;
    L51:
        long r13 = 0;
        if (r12 != null) goto L54;
        com.larus.utils.e1.o(getBinding().d);
    L74:
        com.larus.bmhome.view.actionbar.edit.c r14 = getViewModel();
        if (r14 == null) goto L81;
        if (r12 == null) goto L78;
        Long r15 = r12.a;
    L79:
        r14.setSelectedRatioId(r15);
        goto L81
    L78:
        r15 = null;
    L81:
        if (f7() == false) goto L87;
        FLogger r16 = FLogger.a;
        StringBuilder r17 = new StringBuilder("updateDropdownBoxUi ratio canBeEmpty=");
        r17.append(r8.h);
        r17.append(", defaultSelectionId=");
        r17.append(r8.g);
        r17.append(", defaultSelectionIndex=");
        r17.append(r8.f);
        r17.append(", selectedId=");
        if (r12 == null) goto L85;
        Long r18 = r12.a;
    L86:
        r17.append(r18);
        r16.i("DropdownSelectorWidget", r17.toString());
        goto L87
    L85:
        r18 = null;
    L87:
        if (r12 == null) goto L89;
        Long r19 = r12.a;
    L91:
        if (l7() == false) goto L104;
        if (r19 == null) goto L104;
        com.larus.bmhome.view.actionbar.edit.c r20 = getViewModel();
        if (r20 == null) goto L96;
        Long r21 = r20.getSelectedVideoModelId();
    L98:
        if (Intrinsics.areEqual(r21, r19) == true) goto L104;
        com.larus.bmhome.view.actionbar.edit.c r22 = getViewModel();
        if (r22 == null) goto L102;
        r22.syncVideoModel(r19.longValue());
    L102:
        o7(r19);
        goto L104
    L96:
        r21 = null;
    L104:
        if (V6() == false) goto L112;
        com.larus.bmhome.view.actionbar.edit.c r23 = getViewModel();
        if (r23 == null) goto L112;
        if (r12 == null) goto L111;
        Long r24 = r12.a;
        if (r24 == null) goto L111;
        r13 = r24.longValue();
    L111:
        r23.selectDuration(r13);
    L112:
        final View r25 = LayoutInflater.from(getBinding().a.getContext()).inflate(2131562465, null);
        final RecyclerView r26 = r25.findViewById(2131382753);
        r26.setItemAnimator(null);
        final DropdownItemAdapter r27 = new DropdownItemAdapter(r8.b, this.p, new g1(this));
        this.l = r27;
        r26.setAdapter(r27);
        y6.d(r26, null, null, null, new h1(r27, this, r8), 15);
        r27.submitList(r0);
        if (r0 == null) goto L115;
        final int r28 = r0.size();
    L116:
        final int[] r29 = new int[2];
        final Rect r30 = new Rect();
        com.larus.utils.e1.d(getBinding().a, new i1(this, r27, r29, r30, r28, r25, r26, r8, r12));
        return;
    L115:
        r28 = 0;
        goto L116
    L89:
        r19 = null;
        goto L91
    L54:
        Long r31 = r12.a;
        if (r31 == null) goto L57;
        long r110 = r31.longValue();
    L58:
        setSelectedIdWhenNoMedia(r110);
        if (f7() == false) goto L66;
        Long r32 = r12.a;
        if (r32 == null) goto L66;
        if (r32.longValue() != 0) goto L66;
        com.larus.utils.e1.o(getBinding().c);
    L66:
        getBinding().d.setText(r12.b());
        com.larus.utils.e1.x(getBinding().d);
        Integer r33 = getDropdownBoxStyle();
        if (r33 == null) goto L74;
        if (r33.intValue() != 4) goto L74;
        com.larus.bmhome.view.actionbar.edit.c r34 = getViewModel();
        if (r34 == null) goto L74;
        r34.setImageStyleRadioSelected(true);
        goto L74
    L57:
        r110 = this.n;
        goto L58
    L22:
        r7 = null;
        goto L23
    L14:
        r3 = null;
    L34:
        if (r0 == null) goto L49;
        Iterator<T> r35 = r0.iterator();
    L37:
        if (r35.hasNext() == false) goto L47;
        Object r36 = r35.next();
        Integer r37 = ((com.larus.bmhome.actionbar.model.w) r36).s;
        if (r37 != null) goto L42;
    L44:
        boolean r38 = false;
    L45:
        if (r38 == false) goto L37;
    L48:
        com.larus.bmhome.actionbar.model.w r39 = (com.larus.bmhome.actionbar.model.w) r36;
    L50:
        r12 = r39;
        goto L51
    L42:
        if (r37.intValue() != 1) goto L44;
        r38 = true;
        goto L45
    L47:
        r36 = null;
        goto L48
    L49:
        r39 = null;
        goto L50
    }

    private final xs8.g getController() {
        return (xs8.g) getController();
    }

    private final com.larus.bmhome.actionbar.model.h getCurrentBindData() {
        xs8.g r0 = getController();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.l;
    }

    private final Integer getDropdownBoxStyle() {
        xs8.g r0 = getController();
        if (r0 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r0.n);
    }

    private final Keva getKeva() {
        xs8.g r0 = getController();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.m;
    }

    private final List<com.larus.bmhome.actionbar.model.w> getVisibleOptionList() {
        if (f7() == false) goto L29;
        com.larus.bmhome.view.actionbar.edit.c r0 = getViewModel();
        if (r0 == null) goto L11;
        kotlinx.coroutines.flow.i1<Boolean> r1 = r0.getEnableOriginalRatioFlow();
        if (r1 == null) goto L11;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == true) goto L29;
        com.larus.bmhome.actionbar.model.h r3 = getCurrentBindData();
        if (r3 == null) goto L38;
        List r4 = r3.e;
        if (r4 == null) goto L39;
        ArrayList r5 = new ArrayList();
        Iterator r6 = r4.iterator();
    L19:
        if (r6.hasNext() == false) goto L41;
        Object r7 = r6.next();
        Long r8 = ((com.larus.bmhome.actionbar.model.w) r7).a;
        if (r8 != null) goto L24;
    L26:
        boolean r9 = false;
    L27:
        if (r9 == true) goto L19;
        r5.add(r7);
        goto L19
    L24:
        if (r8.longValue() != 0) goto L26;
        r9 = true;
        goto L27
    L41:
        return r5;
    L39:
        return null;
    L38:
        return null;
    L11:
        r2 = false;
    L29:
        com.larus.bmhome.actionbar.model.h r10 = getCurrentBindData();
        if (r10 != null) goto L32;
        return null;
    L32:
        return r10.e;
    }

    public final boolean V6() {
        com.larus.bmhome.view.actionbar.edit.c r0 = getViewModel();
        if (r0 == null) goto L5;
        Integer r1 = r0.getInstructionType();
    L7:
        if (r1 != null) goto L10;
    L11:
        if (r1 != null) goto L14;
    L16:
        if (r1 != null) goto L19;
    L49:
        return false;
    L19:
        if (r1.intValue() != 28) goto L49;
        xs8.g r2 = getController();
        if (r2 == null) goto L28;
        Integer r3 = r2.g;
        if (r3 == null) goto L28;
        if (r3.intValue() != 18) goto L28;
        boolean r4 = true;
    L29:
        if (r4 == false) goto L49;
        com.larus.bmhome.actionbar.model.h r5 = getCurrentBindData();
        if (r5 == null) goto L38;
        Integer r6 = r5.b;
        if (r6 == null) goto L38;
        if (r6.intValue() != 5) goto L38;
        boolean r7 = true;
    L39:
        if (r7 == false) goto L49;
        return true;
    L38:
        r7 = false;
    L28:
        r4 = false;
        goto L29
    L14:
        if (r1.intValue() != 24) goto L16;
    L41:
        com.larus.bmhome.actionbar.model.h r8 = getCurrentBindData();
        if (r8 == null) goto L49;
        Integer r9 = r8.b;
        if (r9 == null) goto L49;
        if (r9.intValue() != 5) goto L49;
        return true;
    L10:
        if (r1.intValue() == 18) goto L41;
    L5:
        r1 = null;
        goto L7
    }

    public final boolean W6() {
        com.larus.bmhome.view.actionbar.edit.c r0 = getViewModel();
        Integer r1 = null;
        if (r0 == null) goto L5;
        Integer r2 = r0.getInstructionType();
    L7:
        if (r2 != null) goto L10;
    L38:
        if (r2 != null) goto L41;
    L42:
        if (r2 != null) goto L45;
    L47:
        if (r2 != null) goto L50;
    L51:
        if (r2 != null) goto L54;
    L71:
        return false;
    L54:
        if (r2.intValue() != 24) goto L71;
    L55:
        com.larus.bmhome.actionbar.model.h r3 = getCurrentBindData();
        if (r3 == null) goto L71;
        Integer r4 = r3.b;
        if (r4 == null) goto L71;
        if (r4.intValue() != 6) goto L71;
        return true;
    L50:
        if (r2.intValue() == 18) goto L55;
    L45:
        if (r2.intValue() != 4) goto L47;
    L63:
        com.larus.bmhome.actionbar.model.h r5 = getCurrentBindData();
        if (r5 == null) goto L71;
        Integer r6 = r5.b;
        if (r6 == null) goto L71;
        if (r6.intValue() != 30) goto L71;
        return true;
    L41:
        if (r2.intValue() == 16) goto L63;
    L10:
        if (r2.intValue() != 28) goto L38;
        xs8.g r7 = getController();
        if (r7 == null) goto L14;
        r1 = r7.g;
    L14:
        if (r1 != null) goto L17;
    L26:
        if (r1 == null) goto L71;
        if (r1.intValue() != 18) goto L71;
        com.larus.bmhome.actionbar.model.h r8 = getCurrentBindData();
        if (r8 == null) goto L71;
        Integer r9 = r8.b;
        if (r9 == null) goto L71;
        if (r9.intValue() != 6) goto L71;
        return true;
    L17:
        if (r1.intValue() != 4) goto L26;
        com.larus.bmhome.actionbar.model.h r10 = getCurrentBindData();
        if (r10 == null) goto L71;
        Integer r11 = r10.b;
        if (r11 == null) goto L71;
        if (r11.intValue() != 30) goto L71;
        return true;
    L5:
        r2 = null;
        goto L7
    }

    public final boolean f7() {
        com.larus.bmhome.view.actionbar.edit.c r0 = getViewModel();
        Integer r1 = null;
        if (r0 == null) goto L5;
        Integer r2 = r0.getInstructionType();
    L7:
        if (r2 != null) goto L10;
    L38:
        if (r2 != null) goto L41;
    L42:
        if (r2 != null) goto L45;
    L47:
        if (r2 != null) goto L50;
    L51:
        if (r2 != null) goto L54;
    L71:
        return false;
    L54:
        if (r2.intValue() != 24) goto L71;
    L55:
        com.larus.bmhome.actionbar.model.h r3 = getCurrentBindData();
        if (r3 == null) goto L71;
        Integer r4 = r3.b;
        if (r4 == null) goto L71;
        if (r4.intValue() != 1) goto L71;
        return true;
    L50:
        if (r2.intValue() == 18) goto L55;
    L45:
        if (r2.intValue() != 4) goto L47;
    L63:
        com.larus.bmhome.actionbar.model.h r5 = getCurrentBindData();
        if (r5 == null) goto L71;
        Integer r6 = r5.b;
        if (r6 == null) goto L71;
        if (r6.intValue() != 2) goto L71;
        return true;
    L41:
        if (r2.intValue() == 16) goto L63;
    L10:
        if (r2.intValue() != 28) goto L38;
        xs8.g r7 = getController();
        if (r7 == null) goto L14;
        r1 = r7.g;
    L14:
        if (r1 != null) goto L17;
    L26:
        if (r1 == null) goto L71;
        if (r1.intValue() != 18) goto L71;
        com.larus.bmhome.actionbar.model.h r8 = getCurrentBindData();
        if (r8 == null) goto L71;
        Integer r9 = r8.b;
        if (r9 == null) goto L71;
        if (r9.intValue() != 1) goto L71;
        return true;
    L17:
        if (r1.intValue() != 4) goto L26;
        com.larus.bmhome.actionbar.model.h r10 = getCurrentBindData();
        if (r10 == null) goto L71;
        Integer r11 = r10.b;
        if (r11 == null) goto L71;
        if (r11.intValue() != 2) goto L71;
        return true;
    L5:
        r2 = null;
        goto L7
    }

    public String getButtonName() {
        com.larus.bmhome.actionbar.model.h r0 = getCurrentBindData();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c;
    }

    public Integer getImageEditFunctionId() {
        com.larus.bmhome.actionbar.model.h r0 = getCurrentBindData();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    public final boolean l7() {
        com.larus.bmhome.view.actionbar.edit.c r0 = getViewModel();
        if (r0 == null) goto L10;
        Integer r1 = r0.getInstructionType();
        if (r1 == null) goto L10;
        if (r1.intValue() != 28) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L52;
        com.larus.bmhome.view.actionbar.edit.c r3 = getViewModel();
        if (r3 == null) goto L20;
        Integer r4 = r3.getInstructionType();
        if (r4 == null) goto L20;
        if (r4.intValue() != 18) goto L20;
        boolean r5 = true;
    L21:
        if (r5 == true) goto L52;
        com.larus.bmhome.view.actionbar.edit.c r6 = getViewModel();
        if (r6 == null) goto L30;
        Integer r7 = r6.getInstructionType();
        if (r7 == null) goto L30;
        if (r7.intValue() != 32) goto L30;
        boolean r8 = true;
    L31:
        if (r8 == true) goto L52;
        com.larus.bmhome.view.actionbar.edit.c r9 = getViewModel();
        if (r9 == null) goto L40;
        Integer r10 = r9.getInstructionType();
        if (r10 == null) goto L40;
        if (r10.intValue() != 33) goto L40;
        boolean r11 = true;
    L41:
        if (r11 == true) goto L52;
        com.larus.bmhome.view.actionbar.edit.c r12 = getViewModel();
        if (r12 == null) goto L50;
        Integer r13 = r12.getInstructionType();
        if (r13 == null) goto L50;
        if (r13.intValue() != 24) goto L50;
        boolean r14 = true;
    L51:
        if (r14 == true) goto L52;
    L63:
        return false;
    L50:
        r14 = false;
    L40:
        r11 = false;
    L30:
        r8 = false;
    L20:
        r5 = false;
    L52:
        com.larus.bmhome.actionbar.model.h r15 = getCurrentBindData();
        if (r15 == null) goto L60;
        Integer r16 = r15.b;
        if (r16 == null) goto L60;
        if (r16.intValue() != 6) goto L60;
        boolean r17 = true;
    L61:
        if (r17 == false) goto L63;
        return true;
    L60:
        r17 = false;
    L10:
        r2 = false;
        goto L11
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.view.actionbar.edit.component.DropdownSelectorWidget$widthFixItemDecoration$1] */
    public DropdownSelectorWidget(final Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
        this.m = new DropdownSelectorWidget$widthFixItemDecoration$1(r4);
        this.n = -1;
        this.p = new b(this, r4);
    }

    public static final String H6(DropdownSelectorWidget r4) {
        Fragment r0 = r4.getFragment();
        String r1 = null;
        if (r0 != null) goto L42;
    L29:
        Fragment r5 = r4.getFragment();
        if (r5 == null) goto L35;
        Bundle r6 = r5.getArguments();
        if (r6 == null) goto L35;
        r1 = r6.getString("enter_method");
    L35:
        if (Intrinsics.areEqual(r1, "click_navigation_cell") == false) goto L37;
    L40:
        return "creation_nevigation_cell";
    L37:
        if (Intrinsics.areEqual(r1, "create_button_panel") == true) goto L40;
        return "creation_chat_action_bar";
    L42:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L20
        ny9.u r3 = s1a.a.g(r0).a(ny9.u.class);     // Catch: Throwable -> L20
        if (r3 == null) goto L12;
        String r7 = r3.getEnterMethod();     // Catch: Throwable -> L20
        if ((!StringsKt.isBlank(r7)) == true) goto L10;
        r7 = null;
    L10:
        if (r7 == null) goto L12;
    L18:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L20
    L23:
        if (Result.isFailure-impl(r8) == false) goto L25;
        r8 = null;
    L25:
        String r9 = (String) r8;
        if (r9 == null) goto L29;
        r1 = r9;
    L12:
        ny9.s r10 = s1a.a.g(r0).a(ny9.s.class);     // Catch: Throwable -> L20
        if (r10 == null) goto L17;
        r7 = r10.i();     // Catch: Throwable -> L20
        if ((!StringsKt.isBlank(r7)) == true) goto L18;
    L17:
        r7 = null;
    L20:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }

    public static View k6(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static final /* synthetic */ xs8.g n6(DropdownSelectorWidget r0) {
        return r0.getController();
    }

    public static final /* synthetic */ com.larus.bmhome.actionbar.model.h o6(DropdownSelectorWidget r0) {
        return r0.getCurrentBindData();
    }

    public static final /* synthetic */ Integer s6(DropdownSelectorWidget r0) {
        return r0.getDropdownBoxStyle();
    }

    private final void setSelectedIdWhenNoMedia(long r4) {
        if (r4 == 0) goto L6;
        this.n = r4;
        return;
    }

    public static final /* synthetic */ Keva u6(DropdownSelectorWidget r0) {
        return r0.getKeva();
    }

    public final void o7(Long r6) {
        if (r6 == null) goto L23;
        long r0 = r6.longValue();
        xs8.g r7 = getController();
        boolean r3 = false;
        if (r7 == null) goto L11;
        Integer r8 = r7.g;
        if (r8 == null) goto L11;
        if (r8.intValue() != 24) goto L11;
        r3 = true;
    L11:
        if (r3 == true) goto L13;
        return;
    L13:
        Long r9 = this.k;
        if (r9 != null) goto L17;
    L19:
        this.k = Long.valueOf(r0);
        com.larus.bmhome.view.actionbar.edit.c r10 = getViewModel();
        if (r10 == null) goto L24;
        r10.selectModel(24, r0);
        return;
    L24:
        return;
    L17:
        if (r9.longValue() != r0) goto L19;
        return;
    }

    public static final /* synthetic */ void N6(DropdownSelectorWidget r0, long r1) {
        r0.setSelectedIdWhenNoMedia(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void V5(Context r1, AttributeSet r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        this.f = LarusItemActionbarDropdownListBinding.b(LayoutInflater.from(r1), this, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r7(Long r56, String r57) {
        boolean r3 = 0;
        if (l7() == false) goto L6;
        if (r56 == null) goto L6;
        boolean r1 = true;
    L7:
        long r4 = 0;
        if (r1 == false) goto L21;
        com.larus.bmhome.view.actionbar.edit.c r6 = getViewModel();
        if (r6 == null) goto L17;
        if (r56 == null) goto L13;
        long r7 = r56.longValue();
    L15:
        if (r6.selectVideoModel(r7) == true) goto L17;
        boolean r8 = true;
    L18:
        if (r8 == false) goto L21;
        FLogger.a.d("DropdownSelectorWidget", "video model selection rejected before commit");
        return;
    L13:
        r7 = 0;
    L17:
        r8 = false;
    L21:
        com.larus.bmhome.actionbar.model.h r9 = getCurrentBindData();
        if (r9 == null) goto L73;
        List r10 = r9.e;
        if (r10 == null) goto L73;
        Iterator r11 = r10.iterator();
        int r12 = 0;
        com.larus.bmhome.actionbar.model.w r13 = null;
        int r14 = 0;
    L27:
        if (r11.hasNext() == false) goto L74;
        Object r15 = r11.next();
        int r16 = r12 + 1;
        if (r12 >= 0) goto L31;
        CollectionsKt.throwIndexOverflow();
    L31:
        com.larus.bmhome.actionbar.model.w r17 = (com.larus.bmhome.actionbar.model.w) r15;
        if (Intrinsics.areEqual(r17.a, r56) == false) goto L71;
        r17.s = 1;
        com.larus.bmhome.actionbar.model.h r18 = getCurrentBindData();
        if (r18 == null) goto L36;
        boolean r19 = Intrinsics.areEqual(r18.i, Boolean.TRUE);
    L37:
        if (r19 == false) goto L70;
        Integer r110 = getDropdownBoxStyle();
        long r111 = -1;
        if (r110 == null) goto L54;
        if (r110.intValue() != 4) goto L54;
        Keva r112 = getKeva();
        if (r112 == null) goto L70;
        StringBuilder r20 = new StringBuilder("dropbox_");
        com.larus.bmhome.actionbar.model.h r113 = getCurrentBindData();
        if (r113 == null) goto L48;
        Integer r114 = r113.b;
    L49:
        r20.append(r114);
        String r21 = r20.toString();
        Long r115 = r17.a;
        if (r115 == null) goto L52;
        r111 = r115.longValue();
    L52:
        r112.storeLong(r21, r111);
        goto L70
    L48:
        r114 = null;
    L54:
        if (f7() == false) goto L60;
        Long r22 = r17.a;
        if (r22 == null) goto L60;
        if (r22.longValue() == 0) goto L70;
    L60:
        Keva r23 = getKeva();
        if (r23 == null) goto L70;
        StringBuilder r116 = new StringBuilder("dropbox_");
        r116.append(getDropdownBoxStyle());
        r116.append('_');
        com.larus.bmhome.actionbar.model.h r117 = getCurrentBindData();
        if (r117 == null) goto L65;
        Integer r118 = r117.b;
    L66:
        r116.append(r118);
        String r119 = r116.toString();
        Long r120 = r17.a;
        if (r120 == null) goto L69;
        r111 = r120.longValue();
    L69:
        r23.storeLong(r119, r111);
        goto L70
    L65:
        r118 = null;
    L70:
        r14 = r12;
        r13 = r17;
    L72:
        r12 = r16;
        goto L27
    L36:
        r19 = false;
        goto L37
    L71:
        r17.s = 0;
    L74:
        List<com.larus.bmhome.actionbar.model.w> r0 = getVisibleOptionList();
        if (r0 == null) goto L90;
        Iterator<T> r2 = r0.iterator();
    L78:
        if (r2.hasNext() == false) goto L88;
        Object r24 = r2.next();
        Integer r25 = ((com.larus.bmhome.actionbar.model.w) r24).s;
        if (r25 != null) goto L83;
    L85:
        boolean r26 = false;
    L86:
        if (r26 == false) goto L78;
    L89:
        com.larus.bmhome.actionbar.model.w r27 = (com.larus.bmhome.actionbar.model.w) r24;
    L91:
        xs8.g r5 = getController();
        if (r5 == null) goto L94;
        Integer r28 = r5.g;
    L95:
        if (r28 != null) goto L98;
    L113:
        if (r28 != null) goto L116;
    L158:
        if (r28 != null) goto L161;
    L168:
        w7();
        com.larus.bmhome.view.actionbar.edit.c r29 = getViewModel();
        if (r29 == null) goto L173;
        ChatParam r30 = r29.getChatParam();
        if (r30 == null) goto L173;
        String r121 = r30.b;
    L174:
        com.larus.bmhome.view.actionbar.edit.c r31 = getViewModel();
        if (r31 == null) goto L179;
        ChatParam r32 = r31.getChatParam();
        if (r32 == null) goto L179;
        String r122 = r32.e;
    L180:
        com.larus.bmhome.view.actionbar.edit.c r33 = getViewModel();
        if (r33 == null) goto L183;
        String r123 = r33.getTemplateType();
    L184:
        com.larus.bmhome.view.actionbar.edit.c r34 = getViewModel();
        if (r34 == null) goto L187;
        String r124 = r34.getActionBarType();
    L188:
        com.larus.bmhome.view.actionbar.edit.c r35 = getViewModel();
        if (r35 == null) goto L193;
        com.larus.bmhome.actionbar.model.z0 r36 = r35.getCurrentCustomActionBarItem();
        if (r36 == null) goto L193;
        String r210 = r36.b;
    L194:
        com.larus.bmhome.actionbar.model.u r37 = getInstructionItem();
        if (r37 == null) goto L197;
        String r211 = r37.c;
    L198:
        com.larus.bmhome.actionbar.model.h r38 = getCurrentBindData();
        if (r38 == null) goto L201;
        String r212 = r38.c;
    L202:
        if (r13 == null) goto L204;
        String r213 = r13.b;
    L205:
        if (r13 == null) goto L207;
        Long r39 = r13.a;
    L208:
        String r214 = String.valueOf(r39);
        com.larus.bmhome.actionbar.model.h r40 = getCurrentBindData();
        if (r40 == null) goto L211;
        boolean r41 = Intrinsics.areEqual(r40.h, Boolean.TRUE);
    L212:
        if (r41 == true) goto L224;
        com.larus.bmhome.actionbar.model.h r42 = getCurrentBindData();
        if (r42 == null) goto L221;
        Integer r43 = r42.f;
        if (r43 == null) goto L221;
        if (r43.intValue() != r14) goto L221;
        boolean r44 = true;
    L222:
        if (r44 == false) goto L224;
        int r45 = 1;
    L225:
        com.larus.bmhome.actionbar.model.h r46 = getCurrentBindData();
        if (r46 == null) goto L228;
        r3 = Intrinsics.areEqual(r46.h, Boolean.TRUE);
    L228:
        int r47 = !r3;
        int r125 = r14 + 1;
        com.larus.bmhome.view.actionbar.edit.c r48 = getViewModel();
        if (r48 == null) goto L233;
        ChatParam r49 = r48.getChatParam();
        if (r49 == null) goto L233;
        String r310 = r49.c;
    L234:
        com.larus.bmhome.view.actionbar.edit.c r50 = getViewModel();
        if (r50 == null) goto L237;
        Boolean r410 = r50.isCreationActionBar();
    L238:
        tx9.b.e(r121, r122, r123, r124, r210, r211, r212, r213, r214, Integer.valueOf(r45), Integer.valueOf(r47), Integer.valueOf(r125), "select", null, null, null, null, r57, "chat", null, null, null, "chat", r310, r410, null, null, null, null, null, null, null, null, null, null, null, null, -59514880, 127);
        return;
    L237:
        r410 = null;
    L233:
        r310 = null;
    L221:
        r44 = false;
    L224:
        r45 = 0;
        goto L225
    L211:
        r41 = false;
        goto L212
    L207:
        r39 = null;
        goto L208
    L204:
        r213 = null;
        goto L205
    L201:
        r212 = null;
        goto L202
    L197:
        r211 = null;
    L193:
        r210 = null;
        goto L194
    L187:
        r124 = null;
        goto L188
    L183:
        r123 = null;
    L179:
        r122 = null;
    L173:
        r121 = null;
        goto L174
    L161:
        if (r28.intValue() != 24) goto L168;
        if (W6() == false) goto L168;
        if (r27 == null) goto L166;
        Long r51 = r27.a;
    L167:
        o7(r51);
        goto L168
    L166:
        r51 = null;
        goto L167
    L116:
        if (r28.intValue() != 18) goto L158;
        com.larus.bmhome.actionbar.model.h r52 = getCurrentBindData();
        if (r52 == null) goto L125;
        Integer r53 = r52.b;
        if (r53 == null) goto L125;
        if (r53.intValue() != 6) goto L125;
        boolean r54 = true;
    L126:
        if (r54 == false) goto L137;
        if (r1 == true) goto L137;
        com.larus.bmhome.view.actionbar.edit.c r55 = getViewModel();
        if (r55 == null) goto L137;
        if (r27 == null) goto L134;
        Long r58 = r27.a;
        if (r58 == null) goto L134;
        long r126 = r58.longValue();
    L135:
        r55.selectVideoModel(r126);
    L134:
        r126 = 0;
    L137:
        if (V6() == false) goto L145;
        com.larus.bmhome.view.actionbar.edit.c r59 = getViewModel();
        if (r59 == null) goto L145;
        if (r27 == null) goto L144;
        Long r60 = r27.a;
        if (r60 == null) goto L144;
        r4 = r60.longValue();
    L144:
        r59.selectDuration(r4);
    L145:
        if (r27 == null) goto L168;
        Long r61 = r27.a;
        if (r61 == null) goto L168;
        long r62 = r61.longValue();
        com.larus.bmhome.view.actionbar.edit.c r63 = getViewModel();
        if (r63 == null) goto L154;
        Map<Integer, Long> r64 = r63.getSelectedClickRatioIdRegistry();
        if (r64 == null) goto L154;
        r64.put(18, Long.valueOf(r62));
    L154:
        if (W6() == false) goto L168;
        com.larus.bmhome.view.actionbar.edit.c r65 = getViewModel();
        if (r65 == null) goto L168;
        r65.selectModel(18, r62);
    L125:
        r54 = false;
        goto L126
    L98:
        if (r28.intValue() != 4) goto L113;
        if (r27 == null) goto L168;
        Long r66 = r27.a;
        if (r66 == null) goto L168;
        long r67 = r66.longValue();
        com.larus.bmhome.view.actionbar.edit.c r68 = getViewModel();
        if (r68 == null) goto L108;
        Map<Integer, Long> r69 = r68.getSelectedClickRatioIdRegistry();
        if (r69 == null) goto L108;
        r69.put(4, Long.valueOf(r67));
    L108:
        if (W6() == false) goto L168;
        com.larus.bmhome.view.actionbar.edit.c r70 = getViewModel();
        if (r70 == null) goto L168;
        r70.selectModel(4, r67);
        goto L168
    L94:
        r28 = null;
        goto L95
    L83:
        if (r25.intValue() != 1) goto L85;
        r26 = true;
        goto L86
    L88:
        r24 = null;
        goto L89
    L90:
        r27 = null;
    L73:
        r13 = null;
        r14 = 0;
    L6:
        r1 = false;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void C6(DropdownSelectorWidget r43, com.larus.bmhome.actionbar.model.w r44, int r45) {
        com.larus.bmhome.actionbar.model.h r2 = r43.getCurrentBindData();
        boolean r3 = 0;
        if (r2 == null) goto L10;
        List r4 = r2.e;
        if (r4 == null) goto L10;
        Iterator r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        ((com.larus.bmhome.actionbar.model.w) r5.next()).s = 0;
    L10:
        r43.setSelectedIdWhenNoMedia(-1);
        com.larus.bmhome.actionbar.model.h r6 = r43.getCurrentBindData();
        if (r6 == null) goto L13;
        boolean r7 = Intrinsics.areEqual(r6.i, Boolean.TRUE);
    L15:
        if (r7 == false) goto L35;
        Integer r8 = r43.getDropdownBoxStyle();
        if (r8 != null) goto L20;
    L28:
        Keva r9 = r43.getKeva();
        if (r9 == null) goto L35;
        StringBuilder r10 = new StringBuilder("dropbox_");
        r10.append(r43.getDropdownBoxStyle());
        r10.append('_');
        com.larus.bmhome.actionbar.model.h r11 = r43.getCurrentBindData();
        if (r11 == null) goto L33;
        Integer r12 = r11.b;
    L34:
        r10.append(r12);
        r9.storeLong(r10.toString(), -1);
        goto L35
    L33:
        r12 = null;
        goto L34
    L20:
        if (r8.intValue() != 4) goto L28;
        Keva r13 = r43.getKeva();
        if (r13 == null) goto L35;
        StringBuilder r14 = new StringBuilder("dropbox_");
        com.larus.bmhome.actionbar.model.h r15 = r43.getCurrentBindData();
        if (r15 == null) goto L26;
        Integer r16 = r15.b;
    L27:
        r14.append(r16);
        r13.storeLong(r14.toString(), -1);
        goto L35
    L26:
        r16 = null;
    L35:
        xs8.g r17 = r43.getController();
        if (r17 == null) goto L38;
        Integer r18 = r17.g;
    L39:
        if (r18 != null) goto L42;
    L50:
        if (r18 != null) goto L53;
    L61:
        r43.w7();
        FLogger r19 = FLogger.a;
        StringBuilder r20 = new StringBuilder("onItemUnselectedInternal dropdownId=");
        com.larus.bmhome.actionbar.model.h r21 = r43.getCurrentBindData();
        if (r21 == null) goto L64;
        Integer r22 = r21.b;
    L65:
        r20.append(r22);
        r20.append(", optionId=");
        r20.append(r44.a);
        r20.append(", canBeEmpty=");
        com.larus.bmhome.actionbar.model.h r23 = r43.getCurrentBindData();
        if (r23 == null) goto L68;
        Boolean r24 = r23.h;
    L69:
        r20.append(r24);
        r20.append(", isRatio=");
        r20.append(r43.f7());
        r19.i("DropdownSelectorWidget", r20.toString());
        com.larus.bmhome.view.actionbar.edit.c r25 = r43.getViewModel();
        if (r25 == null) goto L74;
        ChatParam r26 = r25.getChatParam();
        if (r26 == null) goto L74;
        String r27 = r26.b;
    L75:
        com.larus.bmhome.view.actionbar.edit.c r28 = r43.getViewModel();
        if (r28 == null) goto L80;
        ChatParam r29 = r28.getChatParam();
        if (r29 == null) goto L80;
        String r30 = r29.e;
    L81:
        com.larus.bmhome.view.actionbar.edit.c r31 = r43.getViewModel();
        if (r31 == null) goto L84;
        String r32 = r31.getTemplateType();
    L85:
        com.larus.bmhome.view.actionbar.edit.c r33 = r43.getViewModel();
        if (r33 == null) goto L88;
        String r34 = r33.getActionBarType();
    L89:
        com.larus.bmhome.view.actionbar.edit.c r35 = r43.getViewModel();
        if (r35 == null) goto L94;
        com.larus.bmhome.actionbar.model.z0 r36 = r35.getCurrentCustomActionBarItem();
        if (r36 == null) goto L94;
        String r210 = r36.b;
    L95:
        com.larus.bmhome.actionbar.model.u r37 = r43.getInstructionItem();
        if (r37 == null) goto L98;
        String r211 = r37.c;
    L99:
        com.larus.bmhome.actionbar.model.h r38 = r43.getCurrentBindData();
        if (r38 == null) goto L102;
        String r39 = r38.c;
    L103:
        String r110 = r44.b;
        String r40 = String.valueOf(r44.a);
        com.larus.bmhome.actionbar.model.h r0 = r43.getCurrentBindData();
        if (r0 == null) goto L106;
        boolean r1 = Intrinsics.areEqual(r0.h, Boolean.TRUE);
    L108:
        if (r1 == true) goto L120;
        com.larus.bmhome.actionbar.model.h r41 = r43.getCurrentBindData();
        if (r41 == null) goto L117;
        Integer r42 = r41.f;
        if (r42 == null) goto L117;
        if (r42.intValue() != r45) goto L117;
        boolean r46 = true;
    L118:
        if (r46 == false) goto L120;
        int r47 = 1;
    L121:
        com.larus.bmhome.actionbar.model.h r111 = r43.getCurrentBindData();
        if (r111 == null) goto L124;
        r3 = Intrinsics.areEqual(r111.h, Boolean.TRUE);
    L124:
        int r48 = !r3;
        int r49 = r45 + 1;
        com.larus.bmhome.view.actionbar.edit.c r50 = r43.getViewModel();
        if (r50 == null) goto L129;
        ChatParam r51 = r50.getChatParam();
        if (r51 == null) goto L129;
        String r410 = r51.c;
    L130:
        com.larus.bmhome.view.actionbar.edit.c r52 = r43.getViewModel();
        if (r52 == null) goto L133;
        Boolean r411 = r52.isCreationActionBar();
    L134:
        tx9.b.e(r27, r30, r32, r34, r210, r211, r39, r110, r40, Integer.valueOf(r47), Integer.valueOf(r48), Integer.valueOf(r49), "cancel", null, null, null, null, "original", "chat", null, null, null, "chat", r410, r411, null, null, null, null, null, null, null, null, null, null, null, null, -59514880, 127);
        return;
    L133:
        r411 = null;
    L129:
        r410 = null;
    L117:
        r46 = false;
    L120:
        r47 = 0;
        goto L121
    L106:
        r1 = false;
        goto L108
    L102:
        r39 = null;
        goto L103
    L98:
        r211 = null;
    L94:
        r210 = null;
        goto L95
    L88:
        r34 = null;
        goto L89
    L84:
        r32 = null;
    L80:
        r30 = null;
    L74:
        r27 = null;
        goto L75
    L68:
        r24 = null;
        goto L69
    L64:
        r22 = null;
        goto L65
    L53:
        if (r18.intValue() != 18) goto L61;
        if (r43.f7() == false) goto L61;
        com.larus.bmhome.view.actionbar.edit.c r53 = r43.getViewModel();
        if (r53 == null) goto L61;
        Map<Integer, Long> r54 = r53.getSelectedClickRatioIdRegistry();
        if (r54 == null) goto L61;
        Long r55 = r54.remove(18);
        goto L61
    L42:
        if (r18.intValue() != 4) goto L50;
        if (r43.f7() == false) goto L61;
        com.larus.bmhome.view.actionbar.edit.c r56 = r43.getViewModel();
        if (r56 == null) goto L61;
        Map<Integer, Long> r57 = r56.getSelectedClickRatioIdRegistry();
        if (r57 == null) goto L61;
        Long r58 = r57.remove(4);
        goto L61
    L38:
        r18 = null;
        goto L39
    L13:
        r7 = false;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Unit i6(final DropdownSelectorWidget r57, DropdownItemAdapter r58, int[] r59, Rect r60, int r61, View r62, final RecyclerView r63, com.larus.bmhome.actionbar.model.h r64, com.larus.bmhome.actionbar.model.w r65, ConstraintLayout r66) {
        Intrinsics.checkNotNullParameter(r66, "it");
        Balloon r3 = r57.g;
        if (r3 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L12;
        if (r3 == null) goto L193;
        r3.h();
    L193:
        return Unit.INSTANCE;
    L12:
        if (r57.f7() == false) goto L24;
        com.larus.bmhome.view.actionbar.edit.c r5 = r57.getViewModel();
        if (r5 == null) goto L20;
        Function0<Boolean> r6 = r5.getDropDownSelectorClickInterceptor();
        if (r6 == null) goto L20;
        if (((Boolean) r6.invoke()).booleanValue() != true) goto L20;
        boolean r7 = true;
    L21:
        if (r7 == false) goto L24;
        FLogger.a.d("DropdownSelectorWidget", "dropDownSelectorClickInterceptor is true");
        return Unit.INSTANCE;
    L20:
        r7 = false;
    L24:
        if (r57.l7() == false) goto L36;
        com.larus.bmhome.view.actionbar.edit.c r8 = r57.getViewModel();
        if (r8 == null) goto L32;
        Function0<Boolean> r9 = r8.getVideoModelDropDownSelectorClickInterceptor();
        if (r9 == null) goto L32;
        if (((Boolean) r9.invoke()).booleanValue() != true) goto L32;
        boolean r10 = true;
    L33:
        if (r10 == false) goto L36;
        FLogger.a.d("DropdownSelectorWidget", "videoModelDropDownSelectorClickInterceptor is set");
        return Unit.INSTANCE;
    L32:
        r10 = false;
    L36:
        if ((SystemClock.elapsedRealtime() - r57.h) <= 500) goto L193;
        r58.notifyItemRangeChanged(0, r58.getItemCount());
        r57.getLocationOnScreen(r59);
        r57.getRootView().getWindowVisibleDisplayFrame(r60);
        int r11 = (r60.bottom - r60.top) - i5.d0();
        int r12 = j19.c.c(560);
        int r13 = r60.bottom - r59[1];
        Integer r1 = r57.getDropdownBoxStyle();
        if (r1 != null) goto L41;
    L43:
        int r2 = i5.d0();
    L45:
        if ((r2 * r61) >= Math.min(r11, r12)) goto L47;
        Integer r14 = null;
    L48:
        if (r14 != null) goto L51;
    L52:
        boolean r16 = false;
    L54:
        Activity r15 = com.larus.utils.i.getActivity(r57.getContext());
        if (r15 == null) goto L63;
        Window r17 = r15.getWindow();
        if (r17 == null) goto L63;
        View r18 = k6(r17);
        if (r18 == null) goto L63;
        View r19 = r18.findViewById(R.id.content);
        if (r19 == null) goto L63;
        boolean r20 = ViewExtKt.h(r19);
    L64:
        com.larus.bmhome.view.screenmenu.d r21 = com.larus.bmhome.view.screenmenu.d.a;
        ConstraintLayout r22 = r57.getBinding().a;
        Intrinsics.checkNotNull(r62);
        boolean r23 = !r20;
        if (r14 != null) goto L67;
    L72:
        Integer r24 = null;
    L73:
        Integer r110 = r14;
        r57.g = com.larus.bmhome.view.screenmenu.d.a(r21, r22, r62, r23, r24, null, null, new j1(r57, r63), 48);
        List r25 = r64.e;
        if (r25 == null) goto L84;
        Integer r26 = Integer.valueOf(CollectionsKt.indexOf(r25, r65));
        if (r26.intValue() < 0) goto L78;
        boolean r27 = true;
    L79:
        if (r27 == true) goto L82;
        r26 = null;
    L82:
        if (r26 == null) goto L84;
        int r28 = r26.intValue();
    L85:
        r63.scrollToPosition(r28);
        int r29 = r63.getItemDecorationCount();
        int r30 = 0;
        boolean r31 = false;
    L86:
        if (r30 >= r29) goto L91;
        if (Intrinsics.areEqual(r63.getItemDecorationAt(r30), r57.m) == false) goto L90;
        r31 = true;
    L90:
        r30 = r30 + 1;
        goto L86
    L91:
        if (r31 == true) goto L93;
        r63.addItemDecoration(r57.m);
    L93:
        FLogger.a.i("DropdownSelectorWidget", "balloonHeight is " + r110 + " offset is " + r13);
        Activity r32 = com.larus.utils.i.getActivity(r57.getContext());
        if (r32 == null) goto L102;
        Window r33 = r32.getWindow();
        if (r33 == null) goto L102;
        View r34 = k6(r33);
        if (r34 == null) goto L102;
        View r35 = r34.findViewById(R.id.content);
        if (r35 == null) goto L102;
        ShadowLayout r36 = null;
        ViewExtKt.j(r35, null, new k1(r57), 3);
    L103:
        Balloon r37 = r57.g;
        if (r37 == null) goto L151;
        ConstraintLayout r38 = r57.getBinding().a;
        ConstraintLayout r39 = r57.getBinding().a;
        com.larus.bmhome.view.actionbar.edit.n r40 = r57.getInputDepend();
        if ((r40 instanceof com.larus.bmhome.view.actionbar.edit.a) == false) goto L108;
        ShadowLayout r41 = (com.larus.bmhome.view.actionbar.edit.a) r40;
    L109:
        if (r41 == null) goto L120;
        ShadowLayout r42 = r41.c(r39);
        if (r42 == null) goto L120;
        if (r42.isAttachedToWindow() == true) goto L115;
    L117:
        boolean r43 = false;
    L118:
        if (r43 == false) goto L120;
    L121:
        if (r42 != null) goto L124;
    L146:
        int r44 = 0;
    L147:
        if (r16 == false) goto L149;
        int r45 = r13;
    L150:
        r37.v(r38, r44, r45);
        goto L151
    L149:
        r45 = 0;
        goto L150
    L124:
        if (r62.getMeasuredWidth() > 0) goto L126;
        r62.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    L126:
        int r46 = r62.getMeasuredWidth();
        if (r46 <= 0) goto L146;
        if (r39.getWidth() <= 0) goto L146;
        int[] r47 = new int[2];
        r39.getLocationOnScreen(r47);
        int r111 = r47[0] + (r39.getWidth() / 2);
        int r48 = r47[0];
        int[] r49 = new int[2];
        r42.getLocationOnScreen(r49);
        int r50 = Math.max(r48, r49[0]);
        ShadowLayout r51 = r62.getLayoutParams();
        if ((r51 instanceof ViewGroup.MarginLayoutParams) == false) goto L134;
        ShadowLayout r52 = (ViewGroup.MarginLayoutParams) r51;
    L135:
        if (r52 == null) goto L137;
        int r53 = r52.getMarginStart();
    L138:
        int r54 = r53 + r62.getPaddingStart();
        if ((r62 instanceof ShadowLayout) == false) goto L141;
        ShadowLayout r55 = (ShadowLayout) r62;
    L142:
        if (r55 == null) goto L144;
        int r56 = Math.max(0, r55.getShadowSize() - r55.getShadowOffset().x);
    L145:
        r44 = ((r50 - (r54 + r56)) + (r46 / 2)) - r111;
        goto L147
    L144:
        r56 = 0;
        goto L145
    L141:
        r55 = r36;
        goto L142
    L137:
        r53 = 0;
        goto L138
    L134:
        r52 = r36;
        goto L135
    L115:
        if (r42.getWidth() <= 0) goto L117;
        r43 = true;
    L120:
        r42 = r36;
        goto L121
    L108:
        r41 = r36;
    L151:
        com.larus.bmhome.view.actionbar.edit.c r67 = r57.getViewModel();
        if (r67 == null) goto L156;
        ChatParam r68 = r67.getChatParam();
        if (r68 == null) goto L156;
        ShadowLayout r112 = r68.b;
    L157:
        com.larus.bmhome.view.actionbar.edit.c r69 = r57.getViewModel();
        if (r69 == null) goto L162;
        ChatParam r70 = r69.getChatParam();
        if (r70 == null) goto L162;
        ShadowLayout r113 = r70.e;
    L163:
        com.larus.bmhome.view.actionbar.edit.c r71 = r57.getViewModel();
        if (r71 == null) goto L166;
        ShadowLayout r210 = r71.getTemplateType();
    L167:
        com.larus.bmhome.view.actionbar.edit.c r72 = r57.getViewModel();
        if (r72 == null) goto L170;
        ShadowLayout r211 = r72.getActionBarType();
    L171:
        com.larus.bmhome.view.actionbar.edit.c r73 = r57.getViewModel();
        if (r73 == null) goto L176;
        com.larus.bmhome.actionbar.model.z0 r74 = r73.getCurrentCustomActionBarItem();
        if (r74 == null) goto L176;
        ShadowLayout r212 = r74.b;
    L177:
        String r75 = r64.c;
        String r213 = String.valueOf(r64.b);
        com.larus.bmhome.view.actionbar.edit.c r76 = r57.getViewModel();
        if (r76 == null) goto L180;
        ShadowLayout r410 = r76.isCreationActionBar();
    L181:
        com.larus.bmhome.view.actionbar.edit.c r77 = r57.getViewModel();
        if (r77 == null) goto L186;
        ChatParam r78 = r77.getChatParam();
        if (r78 == null) goto L186;
        ShadowLayout r411 = r78.c;
    L187:
        com.larus.bmhome.actionbar.model.h r0 = r57.getCurrentBindData();
        if (r0 == null) goto L190;
        boolean r79 = Intrinsics.areEqual(r0.h, Boolean.TRUE);
        int r80 = 1;
        boolean r81 = r79;
    L191:
        tx9.b.e(r112, r113, r210, r211, r212, null, null, r75, r213, 0, Integer.valueOf(r80 ^ r81), null, "select", null, null, null, null, null, "chat", null, null, null, "chat", r411, r410, null, null, null, null, null, null, null, null, null, null, null, null, -59250592, 127);
        goto L193
    L190:
        r80 = 1;
        r81 = 0;
    L186:
        r411 = r36;
        goto L187
    L180:
        r410 = r36;
    L176:
        r212 = r36;
        goto L177
    L170:
        r211 = r36;
        goto L171
    L166:
        r210 = r36;
    L162:
        r113 = r36;
    L156:
        r112 = r36;
    L102:
        r36 = null;
        goto L103
    L78:
        r27 = false;
    L84:
        r28 = 0;
        goto L85
    L67:
        if (r14.intValue() <= 0) goto L69;
        boolean r82 = true;
    L70:
        if (r82 == false) goto L72;
        r24 = r14;
        goto L73
    L69:
        r82 = false;
    L63:
        r20 = false;
        goto L64
    L51:
        if (r14.intValue() < ((int) c7.d(Integer.valueOf(r11)))) goto L52;
        r16 = true;
        goto L54
    L47:
        r14 = Integer.valueOf(RangesKt.coerceAtMost((int) c7.d(Integer.valueOf(r11)), (int) c7.d(Integer.valueOf(r12))));
        goto L48
    L41:
        if (r1.intValue() != 4) goto L43;
        r2 = i5.l0();
        goto L45
    L5:
        if (r3.g != true) goto L7;
        r4 = true;
        goto L8
    }
}
