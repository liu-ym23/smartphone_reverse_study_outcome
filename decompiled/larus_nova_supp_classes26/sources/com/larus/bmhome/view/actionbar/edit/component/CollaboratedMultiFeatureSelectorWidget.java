package com.larus.bmhome.view.actionbar.edit.component;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.CompatKt;
import androidx.fragment.app.Fragment;
import com.bytedance.router.SmartRouter;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.trace.ReeditType;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 Y2\u00020\u0001:\u0001YB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\b\u0010 \u001a\u00020\u0013H\u0014J\b\u0010&\u001a\u00020\u0013H\u0002J\b\u0010'\u001a\u00020\u0013H\u0002J\u0010\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000eH\u0002J\b\u0010*\u001a\u00020\u0013H\u0002J\u0010\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000eH\u0002J.\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u000e2\f\u00103\u001a\b\u0012\u0004\u0012\u00020504H\u0002J(\u00106\u001a\u00020\u00132\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u000e2\u0006\u00107\u001a\u000205H\u0002J-\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u000e2\f\u00103\u001a\b\u0012\u0004\u0012\u00020504H\u0002¢\u0006\u0002\u0010<J'\u0010=\u001a\u00020\u00132\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u000e2\u0006\u00107\u001a\u000205H\u0002¢\u0006\u0002\u0010>J\n\u0010?\u001a\u0004\u0018\u000105H\u0002J\u000f\u0010@\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010AJ\u0016\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020/\u0018\u00010CH\u0002J\b\u0010D\u001a\u00020\u0013H\u0002J\b\u0010E\u001a\u00020\u0013H\u0002J\u0010\u0010F\u001a\u00020\u000b2\u0006\u0010G\u001a\u00020\u0015H\u0002J\b\u0010H\u001a\u00020\u0013H\u0002J\u0010\u0010I\u001a\u00020\u00132\u0006\u0010G\u001a\u00020\u0015H\u0002J\b\u0010J\u001a\u00020\u000bH\u0002J\b\u0010K\u001a\u00020\u000bH\u0002J\b\u0010L\u001a\u00020\u0013H\u0002J\b\u0010M\u001a\u00020\u0013H\u0002J\b\u0010N\u001a\u00020\u000bH\u0002J\u0010\u0010O\u001a\u00020\u00132\u0006\u0010G\u001a\u00020\u0015H\u0002J\b\u0010P\u001a\u000205H\u0002J\u0010\u0010Q\u001a\u00020\u00132\u0006\u0010G\u001a\u00020\u0015H\u0002J\u0010\u0010R\u001a\u00020\u00132\u0006\u0010G\u001a\u00020\u0015H\u0002J\u001e\u0010S\u001a\u00020\u00132\u0014\u0010T\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0UH\u0002J\u0012\u0010V\u001a\b\u0012\u0004\u0012\u0002010W*\u00020/H\u0002J\f\u0010X\u001a\u00020\u000b*\u00020/H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006Z"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/component/CollaboratedMultiFeatureSelectorWidget;", "Lcom/larus/bmhome/instruction/base/AbsInstructionWidget;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "entryView", "Landroid/view/View;", "titleView", "Landroid/widget/TextView;", "hasStartedObserve", "", "latestDraftDropdownSelections", "", "", "", "latestDraftDurationSelections", "rerenderPanel", "Lkotlin/Function0;", "", "pendingSubscribeRequest", "Lcom/larus/bmhome/view/actionbar/edit/component/CollaboratedParamSubscribeRequest;", "currentDialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "controller", "Lcom/larus/bmhome/view/actionbar/edit/controller/CollaboratedMultiFeatureSelectorController;", "getController", "()Lcom/larus/bmhome/view/actionbar/edit/controller/CollaboratedMultiFeatureSelectorController;", "init", "attrs", "Landroid/util/AttributeSet;", "onBindView", "onDetachedFromWindow", "onDataChanged", "getOnDataChanged", "()Lkotlin/jvm/functions/Function0;", "setOnDataChanged", "(Lkotlin/jvm/functions/Function0;)V", "bindEntry", "observeModelChange", "isCurrentParentInstruction", "parentInstructionType", "showPanelIfNeeded", "dp", "value", "reportDropdownOptionShow", "dropdown", "Lcom/larus/bmhome/actionbar/model/ActionBarDropdownBox;", "option", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "optionPosition", "reportedOptionShowKeys", "", "", "reportDropdownOptionClick", "actionType", "reportDurationOptionShow", "duration", "Lcom/larus/bmhome/actionbar/model/ActionBarDurationSeekBarSelector;", "selectedDuration", "(Lcom/larus/bmhome/actionbar/model/ActionBarDurationSeekBarSelector;Ljava/lang/Integer;Ljava/util/Set;)V", "reportDurationOptionClick", "(Lcom/larus/bmhome/actionbar/model/ActionBarDurationSeekBarSelector;Ljava/lang/Integer;Ljava/lang/String;)V", "currentGenerateBoardTabType", "activeRatioSelectorId", "()Ljava/lang/Integer;", "activeRatioSelector", "Lkotlin/Pair;", "syncActiveRatioMetadata", "syncOpenPanelDraftsFromController", "handleSubscribeRequired", "request", "restoreSubscribeDraftAfterReturn", "savePendingSubscribeRestore", "markPendingSubscribeRestoreReadyOnRebind", "consumePendingSubscribeRestoreIfMatched", "dismissCurrentPanel", "restorePendingSubscribeDraft", "tryApplyPendingSubscribeSelection", "openSubscribePage", "resolveCreationEnterMethod", "reportSubscribeGuidanceShow", "reportSubscribeGuidanceClick", "syncConfirmedRatioSelection", "selectedDropdownOptionIds", "", "visibleOptionList", "", "isRatioDropdown", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CollaboratedMultiFeatureSelectorWidget extends AbsInstructionWidget {
    public static t1 o;
    public View f;
    public TextView g;
    public boolean h;
    public Map<Integer, Long> i;
    public Map<Integer, Integer> j;
    public Function0<Unit> k;
    public k0 l;
    public BottomSheetDialog m;
    public Function0<Unit> n;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean N6() {
        t1 r0 = o;
        boolean r1 = false;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.f == false) goto L21;
        com.larus.bmhome.view.actionbar.edit.c r2 = getViewModel();
        if (r2 == null) goto L10;
        com.larus.bmhome.actionbar.model.z0 r3 = r2.getCurrentCustomActionBarItem();
    L11:
        xs8.d r4 = getController();
        if (r4 == null) goto L14;
        Integer r5 = r4.g;
    L16:
        if (r0.a(r3, r5) == false) goto L21;
        this.l = r0.d;
        r1 = y7();
        this.l = null;
        o = null;
        if (r0.e == false) goto L21;
        post(new i(this));
        goto L21
    L14:
        r5 = null;
        goto L16
    L10:
        r3 = null;
    L21:
        return r1;
    }

    public final String V6() {
        int r0 = c.a;
        com.larus.bmhome.view.actionbar.edit.c r1 = getViewModel();
        if (r1 == null) goto L5;
        Integer r2 = r1.getInstructionType();
    L6:
        xs8.d r3 = getController();
        if (r3 == null) goto L9;
        Integer r4 = r3.g;
    L11:
        if (r2 != null) goto L14;
    L25:
        if (r2 != null) goto L28;
    L29:
        if (r2 != null) goto L32;
    L34:
        if (r2 != null) goto L37;
    L38:
        if (r2 != null) goto L41;
        return null;
    L41:
        if (r2.intValue() != 24) goto L46;
    L42:
        return "video";
    L46:
        return null;
    L37:
        if (r2.intValue() == 18) goto L42;
    L32:
        if (r2.intValue() != 4) goto L34;
    L43:
        return ReeditType.IMAGE;
    L28:
        if (r2.intValue() == 16) goto L43;
    L14:
        if (r2.intValue() != 28) goto L25;
        if (r4 != null) goto L18;
    L20:
        if (r4 != null) goto L23;
        return null;
    L23:
        if (r4.intValue() == 18) goto L42;
        return null;
    L18:
        if (r4.intValue() != 4) goto L20;
    L9:
        r4 = null;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void Y5() {
        t1 r1 = o;
        if (r1 == null) goto L21;
        if (r1.f == true) goto L21;
        com.larus.bmhome.view.actionbar.edit.c r4 = getViewModel();
        if (r4 == null) goto L11;
        com.larus.bmhome.actionbar.model.z0 r5 = r4.getCurrentCustomActionBarItem();
    L12:
        xs8.d r6 = getController();
        if (r6 == null) goto L15;
        Integer r7 = r6.g;
    L17:
        if (r1.a(r5, r7) == false) goto L21;
        r1.f = true;
        goto L21
    L15:
        r7 = null;
        goto L17
    L11:
        r5 = null;
    L21:
        if (N6() == false) goto L23;
    L26:
        boolean r2 = true;
    L27:
        H6();
        o7();
        if (this.h == true) goto L39;
        this.h = true;
        CoroutineScope r8 = getComponentScope();
        if (r8 == null) goto L33;
        BuildersKt.launch$default(r8, null, null, new CollaboratedMultiFeatureSelectorWidget$observeModelChange$1(this, null), 3, null);
    L33:
        CoroutineScope r11 = getComponentScope();
        if (r11 == null) goto L36;
        BuildersKt.launch$default(r11, null, null, new CollaboratedMultiFeatureSelectorWidget$observeModelChange$2(this, null), 3, null);
    L36:
        CoroutineScope r9 = getComponentScope();
        if (r9 == null) goto L39;
        BuildersKt.launch$default(r9, null, null, new CollaboratedMultiFeatureSelectorWidget$observeModelChange$3(this, null), 3, null);
    L39:
        com.larus.bmhome.view.actionbar.edit.c r3 = getViewModel();
        if (r3 == null) goto L42;
        r3.onComponentVisibilityChanged(this, true);
    L42:
        if (r2 == false) goto L47;
        Function0<Unit> r10 = this.k;
        if (r10 == null) goto L48;
        r10.invoke();
        return;
    L48:
        return;
    L47:
        return;
    L23:
        if (y7() == true) goto L26;
        r2 = false;
        goto L27
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [com.larus.bmhome.view.actionbar.edit.component.m] */
    /* JADX WARN: Type inference failed for: r22v0, types: [com.larus.bmhome.view.actionbar.edit.component.o] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.bmhome.view.actionbar.edit.component.l] */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.larus.bmhome.view.actionbar.edit.component.n] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.larus.bmhome.view.actionbar.edit.component.k] */
    public final void l7() {
        BottomSheetDialog r0 = this.m;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L13;
        Function0<Unit> r3 = this.k;
        if (r3 == null) goto L46;
        r3.invoke();
        return;
    L46:
        return;
    L13:
        final xs8.d r7 = getController();
        if (r7 != null) goto L16;
        return;
    L16:
        N6();
        y7();
        com.larus.bmhome.actionbar.model.a0 r4 = r7.s();
        if (r4 != null) goto L19;
        return;
    L19:
        List r5 = r4.c;
        if (r5 != null) goto L22;
    L23:
        r1 = true;
    L24:
        if (r1 == false) goto L26;
        return;
    L26:
        final Map<Integer, Long> r11 = MapsKt.toMutableMap(r7.z());
        final Map<Integer, Integer> r12 = MapsKt.toMutableMap(MapsKt.toMap(r7.p));
        final BottomSheetDialog r15 = new BottomSheetDialog(getContext(), 2131951931);
        this.m = r15;
        this.i = r11;
        this.j = r12;
        final Ref.ObjectRef r14 = new Ref.ObjectRef();
        r14.element = new i0(getContext(), f7(), r11, r12, new k(this), new l(this), new CollaboratedMultiFeatureSelectorWidget$showPanelIfNeeded$3(this), new CollaboratedMultiFeatureSelectorWidget$showPanelIfNeeded$4(this), new CollaboratedMultiFeatureSelectorWidget$showPanelIfNeeded$5(this), new CollaboratedMultiFeatureSelectorWidget$showPanelIfNeeded$6(this), new CollaboratedMultiFeatureSelectorWidget$showPanelIfNeeded$7(this), new m(this, r7, r14), new n(r15), new o(r7, r11, r12, this, r15));
        this.k = new CollaboratedMultiFeatureSelectorWidget$showPanelIfNeeded$11(r7, r14);
        com.larus.bmhome.actionbar.model.a0 r6 = r7.s();
        i0 r8 = null;
        if (r6 == null) goto L33;
        Object r9 = r14.element;
        if (r9 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("panelContent");
        i0 r10 = null;
    L32:
        r10.g(r6);
        goto L33
    L31:
        r10 = (i0) r9;
    L33:
        Object r13 = r14.element;
        if (r13 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("panelContent");
    L37:
        r15.setContentView(r8.m);
        r15.setOnDismissListener(new p(this, r15));
        r15.setOnShowListener(new q(r14, r15));
        if (DialogLancet.shouldBlockDialogShow(r15) == false) goto L44;
        DialogLancet.handleBlockedDialogShow(r15);
        return;
    L44:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L43
    L41:
        DialogLancet.beforeDialogShow(r15);
        r15.show();
        DialogLancet.afterDialogShow(r15);
        return;
    L36:
        r8 = (i0) r13;
        goto L37
    L22:
        if (r5.isEmpty() == false) goto L24;
    L5:
        if (r0.isShowing() != true) goto L7;
        r2 = true;
        goto L8
    }

    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void onDetachedFromWindow() {
        BottomSheetDialog r0 = this.m;
        if (r0 != null) goto L5;
    L10:
        super.onDetachedFromWindow();
        return;
    L5:
        if (r0.isShowing() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        k6(r0);
        goto L10
    }

    public final boolean y7() {
        k0 r1 = this.l;
        if (r1 != null) goto L5;
        return false;
    L5:
        xs8.d r3 = getController();
        if (r3 != null) goto L8;
        return false;
    L8:
        com.larus.bmhome.actionbar.model.a0 r4 = r3.s();
        if (r4 != null) goto L11;
        return false;
    L11:
        Map<Integer, Long> r5 = MapsKt.toMutableMap(r3.z());
        Map<Integer, Integer> r6 = MapsKt.toMutableMap(MapsKt.toMap(r3.p));
        Iterator<T> r2 = r1.a.iterator();
    L12:
        Object r9 = null;
        if (r2.hasNext() == false) goto L67;
        l0 r7 = (l0) r2.next();
        List r10 = r4.c;
        if (r10 != null) goto L17;
        r10 = CollectionsKt.emptyList();
    L17:
        Iterator r11 = r10.iterator();
    L19:
        if (r11.hasNext() == false) goto L29;
        Object r12 = r11.next();
        Integer r13 = ((com.larus.bmhome.actionbar.model.f0) r12).f();
        int r14 = r7.a;
        if (r13 != null) goto L24;
    L26:
        boolean r15 = false;
    L27:
        if (r15 == false) goto L19;
    L30:
        com.larus.bmhome.actionbar.model.f0 r16 = (com.larus.bmhome.actionbar.model.f0) r12;
        if (r16 == null) goto L32;
        Long r17 = r7.b;
        if (r17 == null) goto L58;
        long r18 = r17.longValue();
        com.larus.bmhome.actionbar.model.h r19 = r16.d();
        if (r19 == null) goto L57;
        List r110 = r19.e;
        if (r110 == null) goto L57;
        Iterator r111 = r110.iterator();
    L41:
        if (r111.hasNext() == false) goto L51;
        Object r112 = r111.next();
        Long r113 = ((com.larus.bmhome.actionbar.model.w) r112).a;
        if (r113 != null) goto L46;
    L48:
        boolean r114 = false;
    L49:
        if (r114 == false) goto L41;
        r9 = r112;
        goto L51
    L46:
        if (r113.longValue() != r18) goto L48;
        r114 = true;
    L51:
        com.larus.bmhome.actionbar.model.w r20 = (com.larus.bmhome.actionbar.model.w) r9;
        if (r20 == null) goto L57;
        if (j0.g(r20) == true) goto L55;
        r5.put(Integer.valueOf(r7.a), Long.valueOf(r18));
        goto L58
    L55:
        return false;
    L57:
        return false;
    L58:
        Integer r8 = r7.c;
        if (r8 == null) goto L12;
        int r21 = r8.intValue();
        com.larus.bmhome.actionbar.model.j r22 = r16.e();
        if (r22 == null) goto L62;
        if (j0.f(r22, Integer.valueOf(r21)) == true) goto L65;
        r6.put(Integer.valueOf(r7.a), Integer.valueOf(r21));
        goto L12
    L65:
        return false;
    L62:
        return false;
    L32:
        return false;
    L24:
        if (r13.intValue() != r14) goto L26;
        r15 = true;
        goto L27
    L29:
        r12 = null;
        goto L30
    L67:
        r3.v(r5, r6);
        this.l = null;
        r7(r3.z());
        w7();
        return true;
    }

    private final xs8.d getController() {
        return (xs8.d) getController();
    }

    public final Pair<Integer, com.larus.bmhome.actionbar.model.h> C6() {
        xs8.d r0 = getController();
        if (r0 == null) goto L7;
        com.larus.bmhome.actionbar.model.a0 r1 = r0.s();
        if (r1 == null) goto L7;
        List r2 = r1.c;
    L8:
        if (r2 != null) goto L10;
        r2 = CollectionsKt.emptyList();
    L10:
        Iterator r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L33;
        com.larus.bmhome.actionbar.model.f0 r4 = (com.larus.bmhome.actionbar.model.f0) r3.next();
        Integer r5 = r4.f();
        if (r5 == null) goto L24;
        int r6 = r5.intValue();
        com.larus.bmhome.actionbar.model.h r7 = r4.d();
        if (r7 == null) goto L24;
        if (W6(r7) == true) goto L21;
        r7 = null;
    L21:
        if (r7 == null) goto L24;
        Pair<Integer, com.larus.bmhome.actionbar.model.h> r8 = TuplesKt.to(Integer.valueOf(r6), r7);
    L25:
        if (r8 == null) goto L12;
        return r8;
    L24:
        r8 = null;
        goto L25
    L33:
        return null;
    L7:
        r2 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void H6() {
        xs8.d r0 = getController();
        TextView r1 = null;
        if (r0 == null) goto L5;
        com.larus.bmhome.actionbar.model.a0 r2 = r0.s();
    L6:
        if (r2 == null) goto L139;
        List r3 = r2.c;
        if (r3 != null) goto L10;
    L13:
        boolean r4 = true;
    L14:
        if (r4 == true) goto L139;
        com.larus.utils.e1.x(this);
        xs8.d r5 = getController();
        if (r5 == null) goto L117;
        com.larus.bmhome.actionbar.model.a0 r6 = r5.s();
        if (r6 == null) goto L21;
        List r7 = r6.c;
    L22:
        if (r7 != null) goto L24;
        r7 = CollectionsKt.emptyList();
    L24:
        ArrayList r8 = new ArrayList();
        Iterator r9 = r7.iterator();
    L26:
        if (r9.hasNext() == false) goto L102;
        com.larus.bmhome.actionbar.model.f0 r10 = (com.larus.bmhome.actionbar.model.f0) r9.next();
        Integer r11 = r10.f();
        if (r11 == null) goto L98;
        int r12 = r11.intValue();
        com.larus.bmhome.actionbar.model.h r13 = r10.d();
        if (r13 == null) goto L75;
        Long r14 = (Long) ((LinkedHashMap) r5.o).get(Integer.valueOf(r12));
        List r15 = r13.e;
        if (r15 == null) goto L98;
        Iterator r16 = r15.iterator();
    L35:
        if (r16.hasNext() == false) goto L39;
        Object r17 = r16.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.w) r17).a, r14) == false) goto L35;
    L40:
        com.larus.bmhome.actionbar.model.w r18 = (com.larus.bmhome.actionbar.model.w) r17;
        if (r18 == null) goto L98;
        String r19 = r18.t;
        if (r19 != null) goto L45;
    L49:
        r19 = r18.b;
        if (r19 != null) goto L52;
    L54:
        r19 = null;
    L55:
        if (r19 == null) goto L98;
        if ((!StringsKt.isBlank(r19)) == true) goto L60;
        r19 = null;
    L60:
        if (r19 == null) goto L98;
        String r20 = r13.c;
        if (r20 != null) goto L64;
    L68:
        r20 = r10.h;
        if (r20 != null) goto L71;
    L73:
        r20 = null;
    L74:
        xs8.m r21 = new xs8.m(r20, r19);
    L99:
        if (r21 == null) goto L26;
        r8.add(r21);
        goto L26
    L71:
        if ((!StringsKt.isBlank(r20)) == false) goto L73;
    L64:
        if ((!StringsKt.isBlank(r20)) == true) goto L67;
        r20 = null;
    L67:
        if (r20 != null) goto L74;
    L52:
        if ((!StringsKt.isBlank(r19)) == false) goto L54;
    L45:
        if ((!StringsKt.isBlank(r19)) == true) goto L48;
        r19 = null;
    L48:
        if (r19 != null) goto L55;
    L39:
        r17 = null;
        goto L40
    L75:
        com.larus.bmhome.actionbar.model.j r22 = r10.e();
        if (r22 == null) goto L98;
        String r23 = r22.a((Integer) ((LinkedHashMap) r5.p).get(Integer.valueOf(r12)));
        if (r23 == null) goto L98;
        if ((!StringsKt.isBlank(r23)) == true) goto L83;
        r23 = null;
    L83:
        if (r23 == null) goto L98;
        String r24 = r22.b;
        if (r24 != null) goto L87;
    L91:
        r24 = r10.h;
        if (r24 != null) goto L94;
    L96:
        r24 = null;
    L97:
        r21 = new xs8.m(r24, r23);
        goto L99
    L94:
        if ((!StringsKt.isBlank(r24)) == false) goto L96;
    L87:
        if ((!StringsKt.isBlank(r24)) == true) goto L90;
        r24 = null;
    L90:
        if (r24 != null) goto L97;
    L98:
        r21 = null;
        goto L99
    L102:
        if (r7.size() == 1) goto L104;
    L114:
        String r25 = CollectionsKt.joinToString$default(r8, " / ", null, null, 0, null, new xs8.c(), 30, null);
        if ((!StringsKt.isBlank(r25)) == false) goto L117;
    L118:
        if (r25 != null) goto L120;
        String r26 = "";
    L121:
        TextView r27 = this.g;
        if (r27 != null) goto L124;
        Intrinsics.throwUninitializedPropertyAccessException("titleView");
    L125:
        Intrinsics.checkNotNullParameter(r26, "<this>");
        List r28 = StringsKt.split$default(r26, new String[]{"/"}, false, 0, 6, null);
        ArrayList r29 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r28, 10));
        Iterator r30 = r28.iterator();
    L127:
        if (r30.hasNext() == false) goto L129;
        r29.add(StringsKt.trim((String) r30.next()).toString());
        goto L127
    L129:
        ArrayList r31 = new ArrayList();
        Iterator r32 = r29.iterator();
    L131:
        if (r32.hasNext() == false) goto L135;
        Object r33 = r32.next();
        if ((!StringsKt.isBlank((String) r33)) == false) goto L131;
        r31.add(r33);
        goto L131
    L135:
        r1.setText(CollectionsKt.joinToString$default(r31, " · ", null, null, 0, null, null, 62, null));
        Function0<Unit> r34 = this.n;
        if (r34 == null) goto L155;
        r34.invoke();
        return;
    L155:
        return;
    L124:
        r1 = r27;
        goto L125
    L120:
        r26 = r25;
        goto L121
    L104:
        if (r8.size() != 1) goto L114;
        xs8.m r35 = (xs8.m) CollectionsKt.first(r8);
        String r36 = r35.a;
        if (r36 == null) goto L108;
        String r37 = StringsKt.trim(r36).toString();
    L109:
        if (r37 != null) goto L111;
        r37 = "";
    L111:
        r25 = StringsKt.trim(r35.b).toString();
        if ((!StringsKt.isBlank(r37)) == false) goto L118;
        r25 = r37 + ' ' + r25;
        goto L118
    L108:
        r37 = null;
        goto L109
    L21:
        r7 = null;
    L117:
        r25 = null;
        goto L118
    L10:
        if (r3.isEmpty() == true) goto L13;
        r4 = false;
    L139:
        com.larus.utils.e1.o(this);
        FLogger.a.w("CollaboratedMultiFeatureSelectorWidget", "bindEntry empty active config, hide entry");
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final String f7() {
        Fragment r0 = getFragment();
        String r1 = null;
        if (r0 != null) goto L42;
    L29:
        Fragment r2 = getFragment();
        if (r2 == null) goto L35;
        Bundle r3 = r2.getArguments();
        if (r3 == null) goto L35;
        r1 = r3.getString("enter_method");
    L35:
        if (Intrinsics.areEqual(r1, "click_navigation_cell") == false) goto L37;
    L40:
        return "creation_nevigation_cell";
    L37:
        if (Intrinsics.areEqual(r1, "create_button_panel") == true) goto L40;
        return "creation_chat_action_bar";
    L42:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L20
        ny9.u r5 = s1a.a.g(r0).a(ny9.u.class);     // Catch: Throwable -> L20
        if (r5 == null) goto L12;
        String r6 = r5.getEnterMethod();     // Catch: Throwable -> L20
        if ((!StringsKt.isBlank(r6)) == true) goto L10;
        r6 = null;
    L10:
        if (r6 == null) goto L12;
    L18:
        Object r7 = Result.constructor-impl(r6);     // Catch: Throwable -> L20
    L23:
        if (Result.isFailure-impl(r7) == false) goto L25;
        r7 = null;
    L25:
        String r8 = (String) r7;
        if (r8 == null) goto L29;
        r1 = r8;
    L12:
        ny9.s r9 = s1a.a.g(r0).a(ny9.s.class);     // Catch: Throwable -> L20
        if (r9 == null) goto L17;
        r6 = r9.i();     // Catch: Throwable -> L20
        if ((!StringsKt.isBlank(r6)) == true) goto L18;
    L17:
        r6 = null;
    L20:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }

    public final void o7() {
        Pair<Integer, com.larus.bmhome.actionbar.model.h> r0 = C6();
        List<com.larus.bmhome.actionbar.model.w> r1 = null;
        if (r0 == null) goto L5;
        com.larus.bmhome.actionbar.model.h r2 = (com.larus.bmhome.actionbar.model.h) r0.getSecond();
    L6:
        com.larus.bmhome.view.actionbar.edit.c r3 = getViewModel();
        if (r3 == null) goto L13;
        if (r2 == null) goto L12;
        r1 = r2.e;
        if (r1 != null) goto L12;
        r1 = CollectionsKt.emptyList();
    L12:
        r3.setRatioOptionList(r1);
    L13:
        com.larus.bmhome.view.actionbar.edit.c r4 = getViewModel();
        if (r4 == null) goto L20;
        if (r2 == null) goto L17;
        boolean r5 = Intrinsics.areEqual(r2.h, Boolean.TRUE);
    L18:
        r4.setRatioCanBeEmpty(r5);
        return;
    L17:
        r5 = false;
        goto L18
    L20:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void w7() {
        xs8.d r0 = getController();
        if (r0 != null) goto L5;
        return;
    L5:
        Map<Integer, Long> r1 = this.i;
        if (r1 == null) goto L8;
        r1.clear();
        r1.putAll(r0.z());
    L8:
        Map<Integer, Integer> r2 = this.j;
        if (r2 == null) goto L12;
        r2.clear();
        r2.putAll(MapsKt.toMap(r0.p));
        return;
    }

    public final Function0<Unit> getOnDataChanged() {
        return this.n;
    }

    public CollaboratedMultiFeatureSelectorWidget(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
    }

    public static void k6(BottomSheetDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static final /* synthetic */ xs8.d n6(CollaboratedMultiFeatureSelectorWidget r0) {
        return r0.getController();
    }

    public final boolean W6(com.larus.bmhome.actionbar.model.h r10) {
        com.larus.bmhome.view.actionbar.edit.c r0 = getViewModel();
        Integer r1 = null;
        if (r0 == null) goto L5;
        Integer r2 = r0.getInstructionType();
    L7:
        if (r2 != null) goto L10;
    L34:
        if (r2 != null) goto L37;
    L38:
        if (r2 != null) goto L41;
    L43:
        if (r2 != null) goto L46;
    L47:
        if (r2 != null) goto L50;
    L63:
        return false;
    L50:
        if (r2.intValue() != 24) goto L63;
    L51:
        Integer r11 = r10.b;
        if (r11 == null) goto L63;
        if (r11.intValue() != 1) goto L63;
        return true;
    L46:
        if (r2.intValue() == 18) goto L51;
    L41:
        if (r2.intValue() != 4) goto L43;
    L57:
        Integer r12 = r10.b;
        if (r12 == null) goto L63;
        if (r12.intValue() != 2) goto L63;
        return true;
    L37:
        if (r2.intValue() == 16) goto L57;
    L10:
        if (r2.intValue() != 28) goto L34;
        xs8.d r3 = getController();
        if (r3 == null) goto L14;
        r1 = r3.g;
    L14:
        if (r1 != null) goto L17;
    L24:
        if (r1 == null) goto L63;
        if (r1.intValue() != 18) goto L63;
        Integer r13 = r10.b;
        if (r13 == null) goto L63;
        if (r13.intValue() != 1) goto L63;
        return true;
    L17:
        if (r1.intValue() != 4) goto L24;
        Integer r14 = r10.b;
        if (r14 == null) goto L63;
        if (r14.intValue() != 2) goto L63;
        return true;
    L5:
        r2 = null;
        goto L7
    }

    public final void r7(Map<Integer, Long> r3) {
        Pair<Integer, com.larus.bmhome.actionbar.model.h> r0 = C6();
        if (r0 == null) goto L5;
        Integer r1 = (Integer) r0.getFirst();
    L6:
        if (r1 == null) goto L32;
        int r2 = r1.intValue();
        xs8.d r4 = getController();
        if (r4 == null) goto L12;
        Integer r5 = r4.g;
        if (r5 == null) goto L12;
        int r6 = r5.intValue();
    L13:
        Long r7 = r3.get(Integer.valueOf(r2));
        if (r7 != null) goto L21;
        com.larus.bmhome.view.actionbar.edit.c r8 = getViewModel();
        if (r8 == null) goto L30;
        Map<Integer, Long> r9 = r8.getSelectedClickRatioIdRegistry();
        if (r9 == null) goto L31;
        Long r10 = r9.remove(Integer.valueOf(r6));
        return;
    L31:
        return;
    L30:
        return;
    L21:
        com.larus.bmhome.view.actionbar.edit.c r11 = getViewModel();
        if (r11 == null) goto L26;
        Map<Integer, Long> r12 = r11.getSelectedClickRatioIdRegistry();
        if (r12 == null) goto L26;
        r12.put(Integer.valueOf(r6), r7);
    L26:
        com.larus.bmhome.view.actionbar.edit.c r13 = getViewModel();
        if (r13 == null) goto L33;
        r13.setSelectedRatioId(r7);
        return;
    L33:
        return;
    L12:
        r6 = 0;
        goto L13
    L32:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void setOnDataChanged(Function0<Unit> r1) {
        this.n = r1;
    }

    public static final boolean o6(CollaboratedMultiFeatureSelectorWidget r2, int r3) {
        if (r3 == 0) goto L16;
        xs8.d r4 = r2.getController();
        if (r4 == null) goto L12;
        Integer r5 = r4.g;
        if (r5 == null) goto L12;
        if (r3 != r5.intValue()) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        r6 = false;
        goto L13
    L16:
        r2.getClass();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void V5(Context r5, AttributeSet r6) {
        Intrinsics.checkNotNullParameter(r5, "context");
        View r7 = LayoutInflater.from(r5).inflate(2131562476, this, false);
        this.f = r7;
        View r8 = null;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("entryView");
        r7 = null;
    L5:
        com.larus.utils.e1.o(r7.findViewById(2131390536));
        View r9 = this.f;
        if (r9 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("entryView");
        r9 = null;
    L8:
        TextView r10 = (TextView) r9.findViewById(2131391380);
        r10.setMaxLines(1);
        r10.setEllipsize(TextUtils.TruncateAt.END);
        Resources r2 = getResources();
        r10.setMaxWidth((int) ((180 * WindowDisplayMetricsOverride.apply(r2, r2.getDisplayMetrics()).density) + 0.5f));
        this.g = r10;
        View r11 = this.f;
        if (r11 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("entryView");
        r11 = null;
    L11:
        addView(r11);
        View r12 = this.f;
        if (r12 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("entryView");
    L15:
        com.larus.utils.e1.d(r8, new j(this));
        return;
    L14:
        r8 = r12;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Unit i6(final CollaboratedMultiFeatureSelectorWidget r10, xs8.d r11, Ref.ObjectRef r12, k0 r13) {
        Intrinsics.checkNotNullParameter(r13, "request");
        r10.l = r13;
        com.larus.bmhome.view.actionbar.edit.c r1 = r10.getViewModel();
        i0 r7 = null;
        if (r1 == null) goto L7;
        com.larus.bmhome.actionbar.model.z0 r2 = r1.getCurrentCustomActionBarItem();
        if (r2 == null) goto L7;
        String r3 = r2.b;
    L8:
        com.larus.bmhome.view.actionbar.edit.c r4 = r10.getViewModel();
        if (r4 == null) goto L13;
        com.larus.bmhome.actionbar.model.z0 r5 = r4.getCurrentCustomActionBarItem();
        if (r5 == null) goto L13;
        Long r6 = r5.a;
    L14:
        xs8.d r8 = r10.getController();
        if (r8 == null) goto L17;
        Integer r9 = r8.g;
    L18:
        BottomSheetDialog r14 = r10.m;
        boolean r15 = false;
        if (r14 != null) goto L21;
    L23:
        boolean r16 = false;
    L24:
        o = new t1(r3, r6, r9, r13, r16);
        String r0 = r13.a();
        if (r0 != null) goto L27;
    L30:
        boolean r17 = true;
    L31:
        if (r17 == false) goto L38;
        FLogger.a.w("CollaboratedMultiFeatureSelectorWidget", "subscribe jump url is empty, selectorId=" + ((l0) CollectionsKt.first(r13.a)).a);
        if (r10.l == null) goto L61;
        Function0<Unit> r18 = r10.k;
        if (r18 == null) goto L61;
        r18.invoke();
    L61:
        if (r15 == true) goto L70;
        com.larus.bmhome.actionbar.model.a0 r19 = r11.s();
        if (r19 == null) goto L70;
        Object r110 = r12.element;
        if (r110 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("panelContent");
    L68:
        r7.g(r19);
        goto L70
    L67:
        r7 = (i0) r110;
    L70:
        return Unit.INSTANCE;
    L38:
        ICommerceMembershipService.a.getClass();
        ICommerceMembershipService r20 = ICommerceMembershipService.a.a();
        if (r20 == null) goto L41;
        r20.v(r13.c, null);
    L41:
        Fragment r21 = r10.getFragment();
        if (r21 == null) goto L71;
    L53:
        r21.getLifecycle().addObserver(new CollaboratedMultiFeatureSelectorWidget$restoreSubscribeDraftAfterReturn$1(r10));
    L54:
        String r22 = r13.c.a;
        if (r22 != null) goto L57;
        r22 = r10.f7();
    L57:
        Context r111 = r10.getContext();
        String r23 = r13.a();
        if (r23 != null) goto L60;
        r23 = "";
    L60:
        int r24 = uz8.b.e;
        SmartRouter.buildRoute(r111, y0.b(r23, r22, uz8.b.a.a(r13.d))).d();
        r15 = true;
        goto L61
    L71:
        Result.Companion r25 = Result.Companion;     // Catch: Throwable -> L45
        Object r26 = Result.constructor-impl(CompatKt.findFragment(r10));     // Catch: Throwable -> L45
    L48:
        if (Result.isFailure-impl(r26) == false) goto L50;
        r26 = null;
    L50:
        r21 = (Fragment) r26;
        if (r21 != null) goto L53;
    L45:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L48
    L27:
        if (StringsKt.isBlank(r0) == true) goto L30;
        r17 = false;
        goto L31
    L21:
        if (r14.isShowing() != true) goto L23;
        r16 = true;
        goto L24
    L17:
        r9 = null;
    L13:
        r6 = null;
    L7:
        r3 = null;
        goto L8
    }

    public static final void s6(CollaboratedMultiFeatureSelectorWidget r44, com.larus.bmhome.actionbar.model.h r45, com.larus.bmhome.actionbar.model.w r46, int r47, String r48) {
        String r2 = r44.V6();
        com.larus.bmhome.view.actionbar.edit.c r3 = r44.getViewModel();
        Boolean r4 = null;
        if (r3 == null) goto L7;
        ChatParam r5 = r3.getChatParam();
        if (r5 == null) goto L7;
        String r6 = r5.b;
    L8:
        com.larus.bmhome.view.actionbar.edit.c r7 = r44.getViewModel();
        if (r7 == null) goto L13;
        ChatParam r8 = r7.getChatParam();
        if (r8 == null) goto L13;
        String r9 = r8.e;
    L14:
        com.larus.bmhome.view.actionbar.edit.c r10 = r44.getViewModel();
        if (r10 == null) goto L17;
        String r11 = r10.getTemplateType();
    L18:
        com.larus.bmhome.view.actionbar.edit.c r12 = r44.getViewModel();
        if (r12 == null) goto L21;
        String r13 = r12.getActionBarType();
    L22:
        com.larus.bmhome.view.actionbar.edit.c r14 = r44.getViewModel();
        if (r14 == null) goto L27;
        com.larus.bmhome.actionbar.model.z0 r15 = r14.getCurrentCustomActionBarItem();
        if (r15 == null) goto L27;
        String r16 = r15.b;
    L28:
        com.larus.bmhome.actionbar.model.u r17 = r44.getInstructionItem();
        if (r17 == null) goto L31;
        String r18 = r17.c;
    L32:
        int r19 = c.a;
        com.larus.bmhome.view.actionbar.edit.c r20 = r44.getViewModel();
        if (r20 == null) goto L35;
        Integer r21 = r20.getInstructionType();
    L36:
        xs8.d r110 = r44.getController();
        if (r110 == null) goto L39;
        Integer r111 = r110.g;
    L41:
        if (c.a(r21, r111, r45) != null) goto L44;
        if (r45 == null) goto L50;
        String r22 = r45.c;
    L51:
        String r112 = r22;
        com.larus.bmhome.view.actionbar.edit.c r23 = r44.getViewModel();
        if (r23 == null) goto L54;
        Integer r24 = r23.getInstructionType();
    L55:
        xs8.d r113 = r44.getController();
        if (r113 == null) goto L58;
        Integer r114 = r113.g;
    L59:
        String r115 = c.e(r24, r114, r45, r46);
        if (r46 == null) goto L64;
        Long r25 = r46.a;
        if (r25 == null) goto L64;
        String r116 = r25.toString();
    L65:
        int r1 = c.d(r45, r46, r47);
        int r0 = !Intrinsics.areEqual(r45.h, Boolean.TRUE) ? 1 : 0;
        int r26 = r47 + 1;
        JSONObject r27 = c.f(r2);
        com.larus.bmhome.view.actionbar.edit.c r28 = r44.getViewModel();
        if (r28 == null) goto L70;
        ChatParam r29 = r28.getChatParam();
        if (r29 == null) goto L70;
        String r210 = r29.c;
    L71:
        com.larus.bmhome.view.actionbar.edit.c r30 = r44.getViewModel();
        if (r30 == null) goto L74;
        r4 = r30.isCreationActionBar();
    L74:
        tx9.b.e(r6, r9, r11, r13, r16, r18, r112, r115, r116, Integer.valueOf(r1), Integer.valueOf(r0), Integer.valueOf(r26), r48, null, null, null, r27, "original", "chat", null, null, null, "chat", r210, r4, "click", null, null, null, null, null, null, null, null, null, null, null, -126689280, 127);
        return;
    L70:
        r210 = null;
    L64:
        r116 = null;
        goto L65
    L58:
        r114 = null;
        goto L59
    L54:
        r24 = null;
    L50:
        r22 = null;
        goto L51
    L44:
        if (r45 == null) goto L50;
        r22 = r45.d;
        if (r22 == null) goto L50;
        if ((!StringsKt.isBlank(r22)) == false) goto L50;
    L39:
        r111 = null;
        goto L41
    L35:
        r21 = null;
        goto L36
    L31:
        r18 = null;
    L27:
        r16 = null;
        goto L28
    L21:
        r13 = null;
        goto L22
    L17:
        r11 = null;
    L13:
        r9 = null;
    L7:
        r6 = null;
        goto L8
    }

    public static final void u6(CollaboratedMultiFeatureSelectorWidget r29, com.larus.bmhome.actionbar.model.h r30, com.larus.bmhome.actionbar.model.w r31, int r32, Set r33) {
        String r3 = r29.V6();
        int r4 = c.a;
        com.larus.bmhome.view.actionbar.edit.c r5 = r29.getViewModel();
        Boolean r6 = null;
        if (r5 == null) goto L5;
        Integer r7 = r5.getInstructionType();
    L6:
        xs8.d r8 = r29.getController();
        if (r8 == null) goto L9;
        Integer r9 = r8.g;
    L11:
        if (c.a(r7, r9, r30) != null) goto L14;
        if (r30 == null) goto L20;
        String r10 = r30.c;
    L21:
        String r12 = r10;
        if (r31 == null) goto L26;
        Long r11 = r31.a;
        if (r11 == null) goto L26;
        String r14 = r11.toString();
    L28:
        if (r33.add(r3 + '|' + r12 + '|' + r14 + '|' + r32) == false) goto L79;
        com.larus.bmhome.view.actionbar.edit.c r13 = r29.getViewModel();
        if (r13 == null) goto L35;
        ChatParam r15 = r13.getChatParam();
        if (r15 == null) goto L35;
        String r16 = r15.b;
    L36:
        com.larus.bmhome.view.actionbar.edit.c r17 = r29.getViewModel();
        if (r17 == null) goto L41;
        ChatParam r18 = r17.getChatParam();
        if (r18 == null) goto L41;
        String r19 = r18.e;
    L42:
        com.larus.bmhome.view.actionbar.edit.c r20 = r29.getViewModel();
        if (r20 == null) goto L45;
        String r21 = r20.getTemplateType();
    L46:
        com.larus.bmhome.view.actionbar.edit.c r22 = r29.getViewModel();
        if (r22 == null) goto L49;
        String r23 = r22.getActionBarType();
    L50:
        com.larus.bmhome.view.actionbar.edit.c r24 = r29.getViewModel();
        if (r24 == null) goto L55;
        com.larus.bmhome.actionbar.model.z0 r25 = r24.getCurrentCustomActionBarItem();
        if (r25 == null) goto L55;
        String r110 = r25.b;
    L56:
        com.larus.bmhome.actionbar.model.u r26 = r29.getInstructionItem();
        if (r26 == null) goto L59;
        String r111 = r26.c;
    L60:
        com.larus.bmhome.view.actionbar.edit.c r27 = r29.getViewModel();
        if (r27 == null) goto L63;
        Integer r28 = r27.getInstructionType();
    L64:
        xs8.d r112 = r29.getController();
        if (r112 == null) goto L67;
        Integer r113 = r112.g;
    L68:
        String r114 = c.e(r28, r113, r30, r31);
        int r1 = c.d(r30, r31, r32);
        int r0 = !Intrinsics.areEqual(r30.h, Boolean.TRUE) ? 1 : 0;
        int r2 = r32 + 1;
        JSONObject r210 = c.f(r3);
        com.larus.bmhome.view.actionbar.edit.c r34 = r29.getViewModel();
        if (r34 == null) goto L73;
        ChatParam r35 = r34.getChatParam();
        if (r35 == null) goto L73;
        String r211 = r35.c;
    L74:
        com.larus.bmhome.view.actionbar.edit.c r36 = r29.getViewModel();
        if (r36 == null) goto L77;
        r6 = r36.isCreationActionBar();
    L77:
        tx9.b.f(r16, r19, r21, r23, r110, r111, r12, r114, r14, Integer.valueOf(r1), Integer.valueOf(r0), Integer.valueOf(r2), null, null, r210, "chat", null, null, null, "chat", r211, r6, 962560);
        return;
    L73:
        r211 = null;
        goto L74
    L67:
        r113 = null;
        goto L68
    L63:
        r28 = null;
        goto L64
    L59:
        r111 = null;
    L55:
        r110 = null;
        goto L56
    L49:
        r23 = null;
        goto L50
    L45:
        r21 = null;
    L41:
        r19 = null;
    L35:
        r16 = null;
        goto L36
    L79:
        return;
    L26:
        r14 = null;
    L20:
        r10 = null;
        goto L21
    L14:
        if (r30 == null) goto L20;
        r10 = r30.d;
        if (r10 == null) goto L20;
        if ((!StringsKt.isBlank(r10)) == false) goto L20;
    L9:
        r9 = null;
        goto L11
    L5:
        r7 = null;
        goto L6
    }
}
