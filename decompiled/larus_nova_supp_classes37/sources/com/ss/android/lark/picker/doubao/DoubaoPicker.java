package com.ss.android.lark.picker.doubao;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.Dependency;
import com.ss.android.lark.picker.Picker;
import com.ss.android.lark.picker.base.PickerBaseModuleDependency;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.picker.base.widget.ForResultFragment;
import com.ss.android.lark.picker.config.Permissions;
import com.ss.android.lark.picker.config.PickerConfig;
import com.ss.android.lark.picker.config.condition.DocType;
import com.ss.android.lark.picker.config.condition.DocTypes;
import com.ss.android.lark.picker.doubao.entity.DobaoPickerScene;
import com.ss.android.lark.picker.doubao.entity.DoubaoPickerConfig;
import com.ss.android.lark.picker.doubao.entity.DoubaoPickerEntity;
import com.ss.android.lark.picker.doubao.selectedmore.DoubaoSelectedMoreFragment;
import com.ss.android.lark.picker.doubao.utils.DoubaoPickerUtils;
import com.ss.android.lark.picker.doubao.view.DoubaoItemViewBridgeFactory;
import com.ss.android.lark.search.baseview.SearchInputView;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 D2\u00020\u0001:\u0001DB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020\u0015H\u0002J \u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020 H\u0002J\u0010\u0010+\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(H\u0002J\u0016\u0010,\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(2\u0006\u0010*\u001a\u00020 J\u0014\u0010-\u001a\u00020\u00152\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u000200H\u0002J\u0018\u00102\u001a\u00020\"2\u0006\u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020$H\u0002J\u001a\u00105\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u00104\u001a\u00020$H\u0002J\u0018\u00106\u001a\u0002072\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0006\u00108\u001a\u00020\u0015J\u0018\u00109\u001a\u00020\u00152\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000bH\u0002J\u0012\u0010<\u001a\u00020=2\b\b\u0001\u0010>\u001a\u00020$H\u0002J\u0014\u0010?\u001a\u00020\u00152\f\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AJ\u0014\u0010C\u001a\u00020\u00152\f\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/ss/android/lark/picker/doubao/DoubaoPicker;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "selectedMoreFragment", "Lcom/ss/android/lark/picker/doubao/selectedmore/DoubaoSelectedMoreFragment;", "pendingShowSelectedMore", "", "picker", "Lcom/ss/android/lark/picker/Picker;", "bottomBarContainer", "imePlaceholder", "Landroid/view/View;", "selectedMoreContainer", "onItemClickListener", "Lkotlin/Function1;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "hasSelected", "selectedText", "Landroid/widget/TextView;", "bottomBarConfirmBtn", "bottomBarLeftCluster", "initConfig", "Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerConfig;", "safeResName", "", "id", "", "setupWindowInsetsListener", "addBottomBarView", "activity", "Landroidx/fragment/app/FragmentActivity;", "view", "config", "showSelectedMoreFragment", "init", "configSearchEmptyView", "emptyHint", "dp2px", "", "dp", "formatSelectedCountHintTemplate", "template", "selectedCount", "updateBottomBar", "getPickerConfig", "Lcom/ss/android/lark/picker/config/PickerConfig;", "finishSelectMoreList", "setBottomBarLeftClusterVisibleForSelectedMore", "isShowing", "animate", "getSelectedMoreAnimDuration", "", "animResId", "selectItem", "entities", "", "Lcom/ss/android/lark/picker/doubao/entity/DoubaoPickerEntity;", "deselectItem", "Companion", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class DoubaoPicker extends FrameLayout {
    public static final Companion Companion = null;
    private static final float SEARCH_BAR_TEXT_SIZE_SP = 16.0f;
    public static final String TAG = "DoubaoPicker";
    private TextView bottomBarConfirmBtn;
    private final FrameLayout bottomBarContainer;
    private View bottomBarLeftCluster;
    private boolean hasSelected;
    private final View imePlaceholder;
    private DoubaoPickerConfig initConfig;
    private Function1<? super SearchBaseInfo, Unit> onItemClickListener;
    private boolean pendingShowSelectedMore;
    private final Picker picker;
    private final View selectedMoreContainer;
    private DoubaoSelectedMoreFragment selectedMoreFragment;
    private TextView selectedText;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/picker/doubao/DoubaoPicker$Companion;", "", "<init>", "()V", "TAG", "", "SEARCH_BAR_TEXT_SIZE_SP", "", "picker-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final void setupWindowInsetsListener() {
        ViewCompat.setOnApplyWindowInsetsListener(this, new C03601(this));
    }

    public final void finishSelectMoreList() {
        DoubaoSelectedMoreFragment r0 = this.selectedMoreFragment;
        if (r0 == null) goto L6;
        r0.closeWithoutResult();
        return;
    }

    public final Function1<SearchBaseInfo, Unit> getOnItemClickListener() {
        return this.onItemClickListener;
    }

    public static final /* synthetic */ FrameLayout access$getBottomBarContainer$p(DoubaoPicker r0) {
        return r0.bottomBarContainer;
    }

    public static final /* synthetic */ boolean access$getHasSelected$p(DoubaoPicker r0) {
        return r0.hasSelected;
    }

    public static final /* synthetic */ View access$getImePlaceholder$p(DoubaoPicker r0) {
        return r0.imePlaceholder;
    }

    public static final /* synthetic */ Picker access$getPicker$p(DoubaoPicker r0) {
        return r0.picker;
    }

    public static final /* synthetic */ View access$getSelectedMoreContainer$p(DoubaoPicker r0) {
        return r0.selectedMoreContainer;
    }

    private final void configSearchEmptyView(String r3) {
        this.picker.attachSearchEmptyViewConfig(0, r3);
    }

    private final float dp2px(float r1) {
        return UIHelper.dp2px(r1);
    }

    private final long getSelectedMoreAnimDuration(int r5) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r6 = Result.constructor-impl(Long.valueOf(AnimationUtils.loadAnimation(getContext(), r5).getDuration()));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r6) == false) goto L9;
        r6 = null;
    L9:
        Long r7 = (Long) r6;
        if (r7 == null) goto L12;
        long r2 = r7.longValue();
    L14:
        if (r2 > 0) goto L20;
        return 300;
    L20:
        return r2;
    L12:
        r2 = 0;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    private final String safeResName(int r2) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r3 = Result.constructor-impl(getResources().getResourceName(r2));     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r3) == false) goto L9;
        r3 = null;
    L9:
        String r4 = (String) r3;
        if (r4 != null) goto L15;
        return "unknown";
    L15:
        return r4;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    private final void showSelectedMoreFragment(final FragmentActivity r12) {
        if (r12.isFinishing() == false) goto L5;
        return;
    L5:
        if (r12.isDestroyed() == true) goto L105;
        boolean r3 = true;
        if (this.selectedMoreContainer.isAttachedToWindow() == false) goto L10;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L16
        Object r4 = Result.constructor-impl(FragmentManager.findFragment(this));     // Catch: Throwable -> L16
    L18:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L22;
        Log.w("DoubaoPicker", "showSelectedMoreFragment: findHostFragment failed", r5);
    L22:
        if (Result.isFailure-impl(r4) == false) goto L24;
        r4 = null;
    L24:
        Fragment r6 = (Fragment) r4;
        if (r6 == null) goto L28;
        FragmentManager r7 = r6.getChildFragmentManager();
        if (r7 == null) goto L28;
    L102:
        View r13 = r12.findViewById(2131385847);     // Catch: Throwable -> L60
        View r9 = this.selectedMoreContainer.getRootView().findViewById(2131385847);     // Catch: Throwable -> L60
        StringBuilder r10 = new StringBuilder("showSelectedMoreFragment: hostFragment=");     // Catch: Throwable -> L60
        if (r6 == null) goto L33;
        String r1 = r6.getClass().getSimpleName();     // Catch: Throwable -> L60
    L34:
        r10.append(r1);     // Catch: Throwable -> L60
        r10.append('@');     // Catch: Throwable -> L60
        if (r6 == null) goto L37;
        Integer r8 = Integer.valueOf(System.identityHashCode(r6));     // Catch: Throwable -> L60
    L38:
        r10.append(r8);     // Catch: Throwable -> L60
        r10.append(", useFm=");     // Catch: Throwable -> L60
        if (r6 == null) goto L41;
        String r11 = "childFragmentManager";
    L42:
        r10.append(r11);     // Catch: Throwable -> L60
        r10.append(", fmStateSaved=");     // Catch: Throwable -> L60
        r10.append(r7.isStateSaved());     // Catch: Throwable -> L60
        r10.append(", fmBackStack=");     // Catch: Throwable -> L60
        r10.append(r7.getBackStackEntryCount());     // Catch: Throwable -> L60
        r10.append(", activityLookup=");     // Catch: Throwable -> L60
        if (r13 == null) goto L45;
        boolean r14 = true;
    L46:
        r10.append(r14);     // Catch: Throwable -> L60
        r10.append("(same=");     // Catch: Throwable -> L60
        if (r13 != this.selectedMoreContainer) goto L49;
        boolean r15 = true;
    L50:
        r10.append(r15);     // Catch: Throwable -> L60
        r10.append("), rootLookup=");     // Catch: Throwable -> L60
        if (r9 == null) goto L53;
        boolean r16 = true;
    L54:
        r10.append(r16);     // Catch: Throwable -> L60
        r10.append("(same=");     // Catch: Throwable -> L60
        if (r9 != this.selectedMoreContainer) goto L57;
        boolean r17 = true;
    L58:
        r10.append(r17);     // Catch: Throwable -> L60
        r10.append(')');     // Catch: Throwable -> L60
        Log.i("DoubaoPicker", r10.toString());     // Catch: Throwable -> L60
        Object r18 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L60
    L62:
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 == null) goto L66;
        Log.w("DoubaoPicker", "showSelectedMoreFragment: dumpContainerState failed", r19);
    L66:
        if (r7.isStateSaved() == false) goto L69;
        return;
    L69:
        if (r7.findFragmentByTag(DoubaoSelectedMoreFragment.TAG) == null) goto L72;
        this.selectedMoreContainer.setVisibility(0);
        setBottomBarLeftClusterVisibleForSelectedMore(true, false);
        return;
    L72:
        final ForResultFragment r0 = this.picker.prepareForResultFragment();
        DoubaoSelectedMoreFragment r20 = DoubaoSelectedMoreFragment.Companion.newInstance(this.picker.getSelectedList());
        r20.setOnConfirmRemovedData(new DoubaoPicker$showSelectedMoreFragment$fragment$1$1(r0));
        r20.setOnClosed(new DoubaoPicker$showSelectedMoreFragment$fragment$1$2(this));
        this.selectedMoreContainer.setVisibility(0);     // Catch: Throwable -> L75
        setBottomBarLeftClusterVisibleForSelectedMore(true, true);     // Catch: Throwable -> L75
        Object r21 = Result.constructor-impl(Integer.valueOf(INVOKEVIRTUAL_com_ss_android_lark_picker_doubao_DoubaoPicker_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(r7.beginTransaction().setCustomAnimations(2130772210, 2130772211, 0, 2130772211), 2131385847, r20, DoubaoSelectedMoreFragment.TAG).addToBackStack(DoubaoSelectedMoreFragment.TAG).commitAllowingStateLoss()));     // Catch: Throwable -> L75
    L78:
        if (Result.isSuccess-impl(r21) == false) goto L80;
        ((Number) r21).intValue();
        this.selectedMoreFragment = r20;
    L80:
        Throwable r22 = Result.exceptionOrNull-impl(r21);
        if (r22 == null) goto L96;
        this.selectedMoreContainer.setVisibility(8);
        setBottomBarLeftClusterVisibleForSelectedMore(false, false);
        this.selectedMoreFragment = null;
        Log.e("DoubaoPicker", "showSelectedMoreFragment: commitAllowingStateLoss failed", r22);
    L96:
        Object r23 = Result.constructor-impl(Boolean.valueOf(r7.executePendingTransactions()));     // Catch: Throwable -> L85
    L87:
        Throwable r24 = Result.exceptionOrNull-impl(r23);
        if (r24 == null) goto L90;
        Log.w("DoubaoPicker", "showSelectedMoreFragment: executePendingTransactions failed", r24);
    L90:
        StringBuilder r25 = new StringBuilder("showSelectedMoreFragment: exit, fmBackStack=");
        r25.append(r7.getBackStackEntryCount());
        r25.append(", fragmentExists=");
        if (r7.findFragmentByTag(DoubaoSelectedMoreFragment.TAG) != null) goto L94;
        r3 = false;
    L94:
        r25.append(r3);
        Log.i("DoubaoPicker", r25.toString());
        return;
    L85:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
    L75:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L78
    L57:
        r17 = false;
        goto L58
    L53:
        r16 = false;
        goto L54
    L49:
        r15 = false;
        goto L50
    L45:
        r14 = false;
        goto L46
    L41:
        r11 = "activity.supportFragmentManager";
        goto L42
    L37:
        r8 = null;
        goto L38
    L33:
        r1 = null;
    L60:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
    L28:
        r7 = r12.getSupportFragmentManager();
    L16:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L10:
        if (this.pendingShowSelectedMore == false) goto L12;
        return;
    L12:
        this.pendingShowSelectedMore = true;
        this.selectedMoreContainer.post(new RunnableC03611(this, r12));
        return;
    }

    public final void deselectItem(List<DoubaoPickerEntity> r4) {
        Intrinsics.checkNotNullParameter(r4, "entities");
        List<DoubaoPickerEntity> r5 = r4;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        DoubaoPickerEntity r1 = (DoubaoPickerEntity) r6.next();
        r0.add(DoubaoPickerUtils.INSTANCE.fromDoubaoEntity(r1));
        goto L4
    L6:
        List<? extends SearchBaseInfo> r7 = CollectionsKt.toMutableList(r0);
        this.picker.removeSelectedData(r7);
    }

    public final void selectItem(List<DoubaoPickerEntity> r4) {
        Intrinsics.checkNotNullParameter(r4, "entities");
        List<DoubaoPickerEntity> r5 = r4;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        DoubaoPickerEntity r1 = (DoubaoPickerEntity) r6.next();
        r0.add(DoubaoPickerUtils.INSTANCE.fromDoubaoEntity(r1));
        goto L4
    L6:
        List<? extends SearchBaseInfo> r7 = CollectionsKt.toMutableList(r0);
        this.picker.resetSelectedData(r7);
    }

    public final void setOnItemClickListener(Function1<? super SearchBaseInfo, Unit> r1) {
        this.onItemClickListener = r1;
    }

    public DoubaoPicker(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        LayoutInflater.from(r2).inflate(2131568165, this);
        this.picker = (Picker) findViewById(2131382265);
        this.bottomBarContainer = (FrameLayout) findViewById(2131364408);
        this.imePlaceholder = findViewById(2131375110);
        View r4 = findViewById(2131385847);
        this.selectedMoreContainer = r4;
        Log.i("DoubaoPicker", "init: selectedMoreContainer=" + r4.getClass().getSimpleName() + ", id=" + r4.getId() + '(' + safeResName(r4.getId()) + "), attached=" + r4.isAttachedToWindow());
    }

    public static final /* synthetic */ void access$setHasSelected$p(DoubaoPicker r0, boolean r1) {
        r0.hasSelected = r1;
    }

    public static final /* synthetic */ void access$setPendingShowSelectedMore$p(DoubaoPicker r0, boolean r1) {
        r0.pendingShowSelectedMore = r1;
    }

    public static final /* synthetic */ void access$setSelectedMoreFragment$p(DoubaoPicker r0, DoubaoSelectedMoreFragment r1) {
        r0.selectedMoreFragment = r1;
    }

    public static final /* synthetic */ void access$showSelectedMoreFragment(DoubaoPicker r0, FragmentActivity r1) {
        r0.showSelectedMoreFragment(r1);
    }

    private final String formatSelectedCountHintTemplate(String r7, int r8) {
        String r9 = String.valueOf(r8);
        MatchResult r0 = Regex.find$default(new Regex("\\{\\{\\s*num\\s*\\}\\}"), r7, 0, 2, null);
        Regex r4 = new Regex("%(\\d+\\$)?s");
        MatchResult r1 = Regex.find$default(r4, r7, 0, 2, null);
        if (r0 == null) goto L8;
        if (r1 != null) goto L6;
    L7:
        String r10 = UIHelper.mustacheFormat(r7, "num", r9);
        Intrinsics.checkNotNull(r10);
        return r10;
    L6:
        if (r0.getRange().getFirst() <= r1.getRange().getFirst()) goto L7;
    L8:
        if (r1 != null) goto L10;
        return r7;
    L10:
        return r4.replaceFirst(r7, r9);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.ss.android.lark.picker.doubao.DoubaoPicker$getPickerConfig$onItemClickHandler$1] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.ss.android.lark.picker.doubao.DoubaoPicker$getPickerConfig$doubaoBinder$1] */
    private final PickerConfig getPickerConfig(final FragmentActivity r6, final DoubaoPickerConfig r7) {
        final ?? r0 = new DoubaoPicker$getPickerConfig$onItemClickHandler$1(this);
        SetsKt.setOf(new DocType[]{DocType.DOCX, DocType.FILE, DocType.SLIDES, DocType.SHEET});
        final DocTypes r1 = DoubaoPickerUtils.INSTANCE.mapDocCondition(r7.getDocCondition());
        PickerBaseModuleDependency.getDependency().getLoginUserId();
        final DoubaoItemViewBridgeFactory r2 = new DoubaoItemViewBridgeFactory();
        final ?? r3 = new DoubaoPicker$getPickerConfig$doubaoBinder$1(r6, r0, r2);
        PickerConfig r4 = new PickerConfig(new Dependency(r6, r6.getSupportFragmentManager()), new Permissions(CollectionsKt.emptyList()));
        r4.extra(new DoubaoPicker$getPickerConfig$config$1$1(r7, r3, this));
        r4.searcher(new DoubaoPicker$getPickerConfig$config$1$2(r1));
        if (r7.getScene() != DobaoPickerScene.SELECT_FILE) goto L5;
        final RecentFileListPuller r8 = new RecentFileListPuller(r1);
        r4.recommendList(new DoubaoPicker$getPickerConfig$config$1$3(r8));
    L5:
        return r4;
    }

    private final void setBottomBarLeftClusterVisibleForSelectedMore(boolean r7, boolean r8) {
        final View r0 = this.bottomBarLeftCluster;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.animate().cancel();
        long r1 = 0;
        if (r7 == false) goto L14;
        if (r8 == false) goto L9;
        r1 = getSelectedMoreAnimDuration(2130772210);
    L9:
        r0.setClickable(false);
        r0.setEnabled(false);
        if (r8 == true) goto L13;
        r0.setAlpha(0.0f);
        r0.setVisibility(4);
        return;
    L13:
        r0.setVisibility(0);
        r0.setAlpha(1.0f);
        r0.animate().alpha(0.0f).setDuration(r1).withEndAction(new RunnableC03581(r0)).start();
        return;
    L14:
        if (r8 == false) goto L16;
        r1 = getSelectedMoreAnimDuration(2130772211);
    L16:
        if (r8 == true) goto L19;
        r0.setAlpha(1.0f);
        r0.setVisibility(0);
        r0.setEnabled(true);
        r0.setClickable(true);
        return;
    L19:
        r0.setVisibility(0);
        r0.setAlpha(0.0f);
        r0.animate().alpha(1.0f).setDuration(r1).withEndAction(new RunnableC03592(r0)).start();
    }

    private final void updateBottomBar(boolean r4, int r5) {
        if (r4 == false) goto L24;
        boolean r0 = false;
        if (this.bottomBarContainer.getVisibility() == 0) goto L6;
        this.bottomBarContainer.setVisibility(0);
    L6:
        TextView r6 = this.selectedText;
        if (r6 == null) goto L20;
        DoubaoPickerConfig r1 = this.initConfig;
        if (r1 == null) goto L11;
        String r2 = r1.getSelectedCountHintTemplate();
    L12:
        if (r2 != null) goto L14;
    L15:
        r0 = true;
    L16:
        if (r0 == true) goto L18;
        String r3 = formatSelectedCountHintTemplate(r2, r5);
    L19:
        r6.setText(r3);
        goto L20
    L18:
        r3 = UIHelper.mustacheFormat("", "num", String.valueOf(r5));
        goto L19
    L14:
        if (StringsKt.isBlank(r2) == false) goto L16;
    L11:
        r2 = null;
    L20:
        TextView r7 = this.bottomBarConfirmBtn;
        if (r7 == null) goto L27;
        r7.setText(UIHelper.mustacheFormat(2131892073, "count", String.valueOf(r5)));
        return;
    L27:
        return;
    L24:
        if (this.bottomBarContainer.getVisibility() == 8) goto L29;
        this.bottomBarContainer.setVisibility(8);
        return;
    }

    public final void init(FragmentActivity r4, DoubaoPickerConfig r5) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r5, "config");
        this.initConfig = r5;
        this.picker.attachRecommendEmptyViewConfig(r5.getDefaultEmptyIconResId(), r5.getDefaultEmptyHintText());
        configSearchEmptyView(r5.getSearchEmptyHintText());
        this.picker.init2(getPickerConfig(r4, r5));
        this.picker.attachOnSearchErrorRetryClickListener(new C03571(this));
        SearchInputView r6 = this.picker.getSearchInputView();
        r6.setSearchEditTextCornerRadius(dp2px(10.0f));
        r6.setSearchEditTextTextSizeSp(16.0f);
        r6.setSearchIconRes(2131233996);
        if (r5.getScene() != DobaoPickerScene.YUNPAN_SEARCH) goto L5;
        r6.a();
    L5:
        this.picker.setOnSelectedStatusChangeListener(new AnonymousClass3(this));
    }

    public static final /* synthetic */ void access$setBottomBarLeftClusterVisibleForSelectedMore(DoubaoPicker r0, boolean r1, boolean r2) {
        r0.setBottomBarLeftClusterVisibleForSelectedMore(r1, r2);
    }

    public static final /* synthetic */ void access$updateBottomBar(DoubaoPicker r0, boolean r1, int r2) {
        r0.updateBottomBar(r1, r2);
    }

    private final void addBottomBarView(final FragmentActivity r3, View r4, final DoubaoPickerConfig r5) {
        this.bottomBarContainer.removeAllViews();
        this.bottomBarContainer.addView(r4);
        TextView r6 = (TextView) this.bottomBarContainer.findViewById(2131362386);
        this.selectedText = r6;
        if (r6 == null) goto L5;
        r6.setClickable(false);
    L5:
        TextView r7 = this.selectedText;
        if (r7 == null) goto L8;
        r7.setFocusable(false);
    L8:
        View r8 = this.bottomBarContainer.findViewById(2131362383);
        this.bottomBarLeftCluster = r8;
        if (r8 == null) goto L11;
        r8.setOnClickListener(new AnonymousClass1(r5, this, r3));
    L11:
        TextView r9 = (TextView) this.bottomBarContainer.findViewById(2131362382);
        this.bottomBarConfirmBtn = r9;
        if (r9 == null) goto L14;
        r9.setOnClickListener(new AnonymousClass2(r5, this));
    L14:
        updateBottomBar$default(this, this.hasSelected, 0, 2, null);
    }

    public /* synthetic */ DoubaoPicker(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public static FragmentTransaction INVOKEVIRTUAL_com_ss_android_lark_picker_doubao_DoubaoPicker_com_obric_assistant_interaction_impl_window_helpers_FragmentTransactionLancet_add(FragmentTransaction r1, int r2, Fragment r3, String r4) {
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r1, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r4, r2) == false) goto L6;
        return r1;
    L6:
        return r1.add(r2, r3, r4);
    }

    public static /* synthetic */ void configSearchEmptyView$default(DoubaoPicker r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        r0.configSearchEmptyView(r1);
    }

    public static /* synthetic */ void updateBottomBar$default(DoubaoPicker r0, boolean r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = 0;
    L5:
        r0.updateBottomBar(r1, r2);
    }
}
