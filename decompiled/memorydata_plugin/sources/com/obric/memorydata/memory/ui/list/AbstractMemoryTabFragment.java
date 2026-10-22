package com.obric.memorydata.memory.ui.list;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.obric.memorydata.database.dao.AuditoryRecordingRawDbDao;
import com.obric.memorydata.database.dao.EpisodicMemoryDao;
import com.obric.memorydata.database.dao.SemanticMemoryDao;
import com.obric.memorydata.database.entity.cu;
import com.obric.memorydata.database.entity.iq;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.ui.settings.MemorySettingsActivity;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.ui.BaseFragment;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0094@¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\rH\u0014J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J*\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00142\u0006\u0010\u001d\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006 "}, d2 = {"Lcom/obric/memorydata/memory/ui/list/AbstractMemoryTabFragment;", "Lcom/obric/memorydata/ui/BaseFragment;", "<init>", "()V", "isBulkDeleting", "", "shareViewModel", "Lcom/obric/memorydata/memory/ui/list/MemoryListShareViewModel;", "getShareViewModel", "()Lcom/obric/memorydata/memory/ui/list/MemoryListShareViewModel;", "shareViewModel$delegate", "Lkotlin/Lazy;", "showPopupMenu", "", "anchor", "Landroid/view/View;", "openSettingsPage", "context", "Landroid/content/Context;", "getEntityMetaInfo", "", "Lcom/obric/memorydata/database/entity/MemoryMetaInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showDeleteDialog", "getSelectDate", "Ljava/time/LocalDate;", "getEntityMetaInfoWithSpecifiedRange", "ids", "", "withSpecifiedRange", "(Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbstractMemoryTabFragment extends BaseFragment {
    public static final a Companion = null;
    protected static final String TAG = "AbstractMemoryTabFragment";
    private boolean isBulkDeleting;
    private final Lazy shareViewModel$delegate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0084T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/list/AbstractMemoryTabFragment$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10977a = null;

        static {
            int[] r0 = new int[SelectionStateManager.SelectAllState.values().length];
            r0[SelectionStateManager.SelectAllState.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[SelectionStateManager.SelectAllState.PARTIAL_SELECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[SelectionStateManager.SelectAllState.PARTIAL_UNSELECTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[SelectionStateManager.SelectAllState.ALL_SELECTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f10977a = r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public AbstractMemoryTabFragment() {
        this.shareViewModel$delegate = LazyKt.lazy(new $$Lambda$AbstractMemoryTabFragment$8fIyzPnhes_2JAdpeYKTd0snxRw(this));
    }

    public static final /* synthetic */ Object access$getEntityMetaInfoWithSpecifiedRange(AbstractMemoryTabFragment r2, List r3, boolean r4, Continuation r5) {
        return r2.getEntityMetaInfoWithSpecifiedRange((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$setBulkDeleting$p(AbstractMemoryTabFragment r0, boolean r1) {
        r0.isBulkDeleting = r1;
    }

    static /* synthetic */ Object getEntityMetaInfo$suspendImpl(AbstractMemoryTabFragment r5, Continuation<? super List<cu>> r6) {
        Continuation<? super List<cu>> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        SelectionStateManager.SelectAllState r0 = (SelectionStateManager.SelectAllState) ZeusTransformUtils.preCheckCast(r5.getShareViewModel().getSelectionManager().c().c(), SelectionStateManager.SelectAllState.class, "com.obric.memorydata.plugin");
        int r1 = b.f10977a[r0.ordinal()];
        if (r1 == 1) goto L19;
        if (r1 != 2) goto L7;
        Set<String> r2 = r5.getShareViewModel().getSelectionManager().d().keySet();
        Intrinsics.checkNotNullExpressionValue(r2, "<get-keys>(...)");
        return r5.getEntityMetaInfoWithSpecifiedRange(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin")), true, r7);
    L7:
        if (r1 != 3) goto L9;
        Set<String> r3 = r5.getShareViewModel().getSelectionManager().e().keySet();
        Intrinsics.checkNotNullExpressionValue(r3, "<get-keys>(...)");
        return r5.getEntityMetaInfoWithSpecifiedRange(CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")), false, r7);
    L9:
        if (r1 != 4) goto L13;
        return r5.getEntityMetaInfoWithSpecifiedRange(CollectionsKt.emptyList(), false, r7);
    L13:
        throw new NoWhenBranchMatchedException();
    L19:
        return CollectionsKt.emptyList();
    }

    private final Object getEntityMetaInfoWithSpecifiedRange(List<String> r14, boolean r15, Continuation<? super List<cu>> r16) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.memorydata.plugin");
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r16, Continuation.class, "com.obric.memorydata.plugin");
        LocalDate r1 = getSelectDate();
        if (r1 == null) goto L9;
        ZonedDateTime r3 = r1.atStartOfDay(ZoneId.systemDefault());
        if (r3 == null) goto L9;
        Instant r5 = r3.toInstant();
        if (r5 == null) goto L9;
        Long r6 = Boxing.boxLong(r5.toEpochMilli());
    L10:
        if (r1 == null) goto L18;
        LocalDate r2 = r1.plusDays(1);
        if (r2 == null) goto L18;
        ZonedDateTime r7 = r2.atStartOfDay(ZoneId.systemDefault());
        if (r7 == null) goto L18;
        Instant r8 = r7.toInstant();
        if (r8 == null) goto L18;
        Long r9 = Boxing.boxLong(r8.toEpochMilli());
    L19:
        String r10 = MemoryListShareViewModel.getMixTab$default(getShareViewModel(), null, 1, null);
        if (Intrinsics.areEqual(r10, MemoryTab.OBSERVATION.getText()) == false) goto L29;
        if (r6 == null) goto L27;
        if (r9 == null) goto L27;
        return EpisodicMemoryDao.DefaultImpls.getAllObservationMemoryMetaInfoWithTimestamp$default(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao(), r4, r15, r6.longValue(), r9.longValue(), false, r0, 16, null);
    L27:
        return EpisodicMemoryDao.DefaultImpls.getAllObservationMemoryMetaInfo$default(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao(), r4, r15, false, r0, 4, null);
    L29:
        if (Intrinsics.areEqual(r10, MemoryTab.AUDIO.getText()) == false) goto L38;
        if (r6 == null) goto L36;
        if (r9 == null) goto L36;
        return AuditoryRecordingRawDbDao.DefaultImpls.getAllRecordingsMetaInfoWithTimestamp$default(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryRecordingRawDbDao(), r4, r15, r6.longValue(), r9.longValue(), false, r0, 16, null);
    L36:
        return AuditoryRecordingRawDbDao.DefaultImpls.getAllRecordingsMetaInfo$default(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getAuditoryRecordingRawDbDao(), r4, r15, false, r0, 4, null);
    L38:
        if (Intrinsics.areEqual(r10, MemoryTab.COLLECT.getText()) == false) goto L42;
        return EpisodicMemoryDao.DefaultImpls.getCollectMemoryMetaInfo$default(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getEpisodicMemoryDao(), r4, r15, getShareViewModel().getSelectedCollectSourcePackage(), getShareViewModel().getSelectedCollectSourceProductType(), false, r0, 16, null);
    L42:
        if (Intrinsics.areEqual(r10, MemoryTab.PROFILE.getText()) == false) goto L50;
        if (Intrinsics.areEqual(getShareViewModel().getSelectedTag(), PersonalTag.f11118a.a()) == false) goto L48;
        return SemanticMemoryDao.DefaultImpls.getInfoAllTypeMemoryMetaInfo$default(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao(), r4, r15, false, r0, 4, null);
    L48:
        return SemanticMemoryDao.DefaultImpls.getInfoSingleTagMemoryMetaInfo$default(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getSemanticMemoryDao(), iq.a(getShareViewModel().getSelectedTag()), r4, r15, false, r0, 8, null);
    L50:
        throw new IllegalArgumentException("shareViewModel.getMixTab(): " + MemoryListShareViewModel.getMixTab$default(getShareViewModel(), null, 1, null) + " didn't match any tab text");
    L18:
        r9 = null;
    L9:
        r6 = null;
        goto L10
    }

    public static /* synthetic */ MemoryListShareViewModel lambda$8fIyzPnhes_2JAdpeYKTd0snxRw(AbstractMemoryTabFragment r0) {
        return shareViewModel_delegate$lambda$0(r0);
    }

    /* JADX INFO: renamed from: lambda$dxEaQyTeAILy8p7xnWJZU-08v84, reason: not valid java name */
    public static /* synthetic */ Unit m870lambda$dxEaQyTeAILy8p7xnWJZU08v84(AbstractMemoryTabFragment r0, DialogInterface r1, int r2) {
        return showDeleteDialog$lambda$5(r0, r1, r2);
    }

    public static /* synthetic */ Unit lambda$oOOKXM7JwdAoq3bdheRIziuedIc(Ref.ObjectRef r0, AbstractMemoryTabFragment r1, FragmentActivity r2, View r3, int r4) {
        return showPopupMenu$lambda$1(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit lambda$xFs8r3aKfNstcwgfZ2KttygQTsU(DialogInterface r0, int r1) {
        return showDeleteDialog$lambda$3(r0, r1);
    }

    private static final MemoryListShareViewModel shareViewModel_delegate$lambda$0(AbstractMemoryTabFragment r3) {
        FragmentActivity r4 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r4, "requireActivity(...)");
        return (MemoryListShareViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider((ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(r4, ViewModelStoreOwner.class, "com.obric.memorydata.plugin")).get(MemoryListShareViewModel.class), MemoryListShareViewModel.class, "com.obric.memorydata.plugin");
    }

    private static final Unit showDeleteDialog$lambda$3(DialogInterface r6, int r7) {
        DialogInterface r8 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r6, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "dialog");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "取消", false, 4, null);
        r8.dismiss();
        return Unit.INSTANCE;
    }

    private static final Unit showDeleteDialog$lambda$5(AbstractMemoryTabFragment r12, DialogInterface r13, int r14) {
        DialogInterface r15 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r13, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r15, "dialog");
        if (r12.isBulkDeleting == false) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "bulk delete is running, ignore repeated confirm", false, 4, null);
    L6:
        return Unit.INSTANCE;
    L7:
        r12.isBulkDeleting = true;
        long r1 = System.currentTimeMillis();
        MemoryListShareViewModel r3 = r12.getShareViewModel();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "bulk delete confirm, selectAllState=" + r3.getSelectionManager().c().c() + ", selectedTab=" + MemoryListShareViewModel.getMixTab$default(r3, null, 1, null) + ", selectedTag=" + r3.getSelectedTag() + ", selectedCount=" + ((Number) ZeusTransformUtils.preCheckCast(r3.getSelectionManager().f().c(), Number.class, "com.obric.memorydata.plugin")).intValue() + ", selectedItemsSize=" + r3.getSelectionManager().d().size() + ", deselectedItemsSize=" + r3.getSelectionManager().e().size(), false, 4, null);
        r15.dismiss();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "bulk delete dialog dismissed", false, 4, null);
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) ZeusTransformUtils.preCheckCast(r12, LifecycleOwner.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AbstractMemoryTabFragment$showDeleteDialog$2$2(r12, r1, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        goto L6
    }

    private static final Unit showPopupMenu$lambda$1(Ref.ObjectRef r1, AbstractMemoryTabFragment r2, FragmentActivity r3, View r4, int r5) {
        FragmentActivity r6 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r3, FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<unused var>");
        com.obric.oui.popover.v2.a r7 = (com.obric.oui.popover.v2.a) ZeusTransformUtils.preCheckCast(r1.element, com.obric.oui.popover.v2.a.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L5;
        r7.dismiss();
    L5:
        r2.openSettingsPage((Context) ZeusTransformUtils.preCheckCast(r6, Context.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    public Object getEntityMetaInfo(Continuation<? super List<cu>> r3) {
        return getEntityMetaInfo$suspendImpl(this, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public LocalDate getSelectDate() {
        return null;
    }

    public final MemoryListShareViewModel getShareViewModel() {
        return (MemoryListShareViewModel) ZeusTransformUtils.preCheckCast(this.shareViewModel$delegate.getValue(), MemoryListShareViewModel.class, "com.obric.memorydata.plugin");
    }

    public void openSettingsPage(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        MemorySettingsActivity.Companion.a(r1);
    }

    public void showDeleteDialog() {
        if (this.isBulkDeleting == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "bulk delete is running, ignore show delete dialog", false, 4, null);
        Context r11 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r11, "requireContext(...)");
        com.obric.memorydata.utils.ba.a(r11, ZeusTransformUtils.mapRes(R.string.memory_bulk_delete_running_toast, TypedValues.Custom.S_STRING, "memory_bulk_delete_running_toast"), 0, 4, null);
        return;
    L6:
        FragmentActivity r5 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r5, "requireActivity(...)");
        com.obric.oui.dialog.v2.alert.b r0 = new com.obric.oui.dialog.v2.alert.b((Context) ZeusTransformUtils.preCheckCast(r5, Context.class, "com.obric.memorydata.plugin")).b(false);
        if (((Number) ZeusTransformUtils.preCheckCast(getShareViewModel().getSelectionManager().f().c(), Number.class, "com.obric.memorydata.plugin")).intValue() <= 1) goto L9;
        String r6 = getString(ZeusTransformUtils.mapRes(R.string.memory_card_delete_notice_title_multiple, TypedValues.Custom.S_STRING, "memory_card_delete_notice_title_multiple"), new Object[]{getShareViewModel().getSelectionManager().f().c()});
    L10:
        com.obric.oui.dialog.v2.alert.a r12 = (com.obric.oui.dialog.v2.alert.a) ZeusTransformUtils.preCheckCast(com.obric.oui.dialog.v2.alert.b.a(r0, (CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null).a(null).a(true).b((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_card_delete_notice_cancel, TypedValues.Custom.S_STRING, "memory_card_delete_notice_cancel")), CharSequence.class, "com.obric.memorydata.plugin"), $$Lambda$AbstractMemoryTabFragment$xFs8r3aKfNstcwgfZ2KttygQTsU.INSTANCE).a((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_card_delete_notice_confirm, TypedValues.Custom.S_STRING, "memory_card_delete_notice_confirm")), CharSequence.class, "com.obric.memorydata.plugin"), new $$Lambda$AbstractMemoryTabFragment$dxEaQyTeAILy8p7xnWJZU08v84(this)).g(), com.obric.oui.dialog.v2.alert.a.class, "com.obric.memorydata.plugin");
        r12.setCanceledOnTouchOutside(true);
        r12.setCancelable(true);
        r12.show();
        return;
    L9:
        r6 = getString(ZeusTransformUtils.mapRes(R.string.memory_card_delete_notice_title_single, TypedValues.Custom.S_STRING, "memory_card_delete_notice_title_single"));
        goto L10
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [T, com.obric.oui.popover.v2.a] */
    public final void showPopupMenu(View r19) {
        Intrinsics.checkNotNullParameter(r19, "anchor");
        final FragmentActivity r0 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r0, "requireActivity(...)");
        OPopoverEntranceMenuView.Builder r2 = new OPopoverEntranceMenuView.Builder((Context) ZeusTransformUtils.preCheckCast(r0, Context.class, "com.obric.memorydata.plugin"));
        final Ref.ObjectRef r15 = new Ref.ObjectRef();
        OPopoverEntranceMenuView.Builder.a(r2, Integer.valueOf(ZeusTransformUtils.mapRes(R.drawable.memory_menu_setting_icon, "drawable", "memory_menu_setting_icon")), null, null, (CharSequence) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_list_setting_menu_text, TypedValues.Custom.S_STRING, "memory_list_setting_menu_text")), CharSequence.class, "com.obric.memorydata.plugin"), null, null, false, null, new $$Lambda$AbstractMemoryTabFragment$oOOKXM7JwdAoq3bdheRIziuedIc(r15, this, r0), 182, null);
        r2.b();
        OPopoverEntranceMenuView r3 = r2.c();
        ?? r1 = ((com.obric.oui.popover.v2.a.C0765a) ZeusTransformUtils.preCheckCast(new com.obric.oui.popover.v2.a.C0765a((Context) ZeusTransformUtils.preCheckCast(r0, Context.class, "com.obric.memorydata.plugin")).a((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.memorydata.plugin")), com.obric.oui.popover.v2.a.C0765a.class, "com.obric.memorydata.plugin")).F();
        com.obric.oui.popover.v2.e.a(com.obric.oui.popover.v2.e.f14366a, r1, r19, 48, false, 0, false, 0, 0, 248, null);
        r15.element = r1;
    }
}
