package com.obric.memorydata.memory.ui.list;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.memory.databinding.ItemMemoryListBinding;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.memory.ui.detail.MemoryDetailActivity;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a \u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a \u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\f\u0010\u000f\u001a\u00020\u0010*\u00020\u000bH\u0002\u001a\u000e\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u0013H\u0002\u001a\u0018\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002\u001a.\u0010\u0018\u001a\u0004\u0018\u0001H\u0019\"\n\b\u0000\u0010\u0019\u0018\u0001*\u00020\u001a*\u00020\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00190\u001cH\u0082\b¢\u0006\u0002\u0010\u001d¨\u0006\u001e"}, d2 = {"showDeleteDialog", "", "binding", "Lcom/obric/memorydata/memory/databinding/ItemMemoryListBinding;", "memoryItem", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "delete", "gotoDetailPage", "memoryEntity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "itemRelatedPage", "Lcom/obric/memorydata/memory/ui/list/MemoryListItemViewHolder$Companion$ItemRelatedPage;", "gotoEpisodicMemoryDetailActivity", "episodicMemoryEntity", "Lcom/obric/memorydata/database/entity/EpisodicMemoryEntity;", "toDetailEnterFrom", "", "getLifecycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "Landroid/view/View;", "setMemoryListOverlayVisible", "view", "visible", "", "getViewModel", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "clazz", "Ljava/lang/Class;", "(Landroid/view/View;Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "memory_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class x {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11338a = null;

        static {
            int[] r0 = new int[MemoryListItemViewHolder.Companion.ItemRelatedPage.values().length];
            r0[MemoryListItemViewHolder.Companion.ItemRelatedPage.LIST_PAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[MemoryListItemViewHolder.Companion.ItemRelatedPage.DETAIL_PAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[MemoryListItemViewHolder.Companion.ItemRelatedPage.SEARCH_PAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[MemoryListItemViewHolder.Companion.ItemRelatedPage.CONTEXT_AWARENESS_PAGE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f11338a = r0;
        }
    }

    public static final /* synthetic */ LifecycleCoroutineScope a(View r0) {
        return b(r0);
    }

    private static final String a(MemoryListItemViewHolder.Companion.ItemRelatedPage r1) {
        int r2 = a.f11338a[r1.ordinal()];
        if (r2 != 1) goto L5;
    L15:
        MemoryEventTracker.SourceType r3 = MemoryEventTracker.SourceType.MEMORY_LIST;
    L17:
        return r3.getValue();
    L5:
        if (r2 != 2) goto L7;
        r3 = MemoryEventTracker.SourceType.MEMORY_RELATION;
        goto L17
    L7:
        if (r2 != 3) goto L9;
        r3 = MemoryEventTracker.SourceType.MEMORY_SEARCH;
        goto L17
    L9:
        if (r2 == 4) goto L15;
        throw new NoWhenBranchMatchedException();
    }

    private static final Unit a(DialogInterface r1, int r2) {
        DialogInterface r3 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r1, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "dialog");
        r3.dismiss();
        return Unit.INSTANCE;
    }

    private static final Unit a(ItemMemoryListBinding r1, com.obric.memorydata.memory.ui.data.a r2, DialogInterface r3, int r4) {
        DialogInterface r5 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "dialog");
        delete(r1, r2);
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r1.getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r6, "getContext(...)");
        Activity r7 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.obric.memorydata.utils.ba.b(r6), "com.obric.memorydata.plugin"), Activity.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, MemorySearchActivity.class) == false) goto L5;
        MemorySearchActivity r8 = (MemorySearchActivity) ZeusTransformUtils.preCheckCast(r7, MemorySearchActivity.class, "com.obric.memorydata.plugin");
    L6:
        if (r8 == null) goto L8;
        r8.removeSingleMemoryItem(r2);
    L8:
        r5.dismiss();
        return Unit.INSTANCE;
    L5:
        r8 = null;
        goto L6
    }

    public static final /* synthetic */ void a(View r0, boolean r1) {
        b(r0, r1);
    }

    public static final /* synthetic */ void a(ItemMemoryListBinding r0, MemoryEntity r1, MemoryListItemViewHolder.Companion.ItemRelatedPage r2) {
        b(r0, r1, r2);
    }

    public static final /* synthetic */ void a(ItemMemoryListBinding r0, EpisodicMemoryEntity r1, MemoryListItemViewHolder.Companion.ItemRelatedPage r2) {
        b(r0, r1, r2);
    }

    public static final /* synthetic */ void a(ItemMemoryListBinding r0, com.obric.memorydata.memory.ui.data.a r1) {
        c(r0, r1);
    }

    private static final LifecycleCoroutineScope b(View r0) {
        LifecycleOwner r1 = ViewTreeLifecycleOwner.get(r0);
        if (r1 != null) goto L7;
        return null;
    L7:
        return LifecycleOwnerKt.getLifecycleScope(r1);
    }

    private static final void b(View r3, boolean r4) {
        View r5 = r3.findViewById(ZeusTransformUtils.mapRes(R.id.overlay, OaidModel.KEY_ID, "overlay"));
        if (r5 == null) goto L9;
        if (r4 == false) goto L6;
        int r6 = 0;
    L7:
        r5.setVisibility(r6);
        return;
    L6:
        r6 = 8;
        goto L7
    }

    private static final void b(ItemMemoryListBinding r3, MemoryEntity r4, MemoryListItemViewHolder.Companion.ItemRelatedPage r5) {
        MemoryDetailActivity.a r0 = MemoryDetailActivity.Companion;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r6, "getContext(...)");
        r0.b(r6, r4, a(r5), false);
    }

    private static final void b(ItemMemoryListBinding r3, EpisodicMemoryEntity r4, MemoryListItemViewHolder.Companion.ItemRelatedPage r5) {
        MemoryDetailActivity.a r0 = MemoryDetailActivity.Companion;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r6, "getContext(...)");
        r0.a(r6, r4.getEntityId(), a(r5), false);
    }

    public static final /* synthetic */ void b(ItemMemoryListBinding r0, com.obric.memorydata.memory.ui.data.a r1) {
        delete(r0, r1);
    }

    private static final void c(final ItemMemoryListBinding r7, final com.obric.memorydata.memory.ui.data.a r8) {
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "getContext(...)");
        com.obric.oui.dialog.v2.alert.a r9 = (com.obric.oui.dialog.v2.alert.a) ZeusTransformUtils.preCheckCast(com.obric.oui.dialog.v2.alert.b.a(new com.obric.oui.dialog.v2.alert.b(r1).b(false), (CharSequence) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_card_delete_notice_title_single, TypedValues.Custom.S_STRING, "memory_card_delete_notice_title_single")), CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null).a(null).a(true).b((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_card_delete_notice_cancel, TypedValues.Custom.S_STRING, "memory_card_delete_notice_cancel")), CharSequence.class, "com.obric.memorydata.plugin"), $$Lambda$x$xH6I_HRe9YRKprcjyXuUMF72UIw.INSTANCE).a((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_card_delete_notice_confirm, TypedValues.Custom.S_STRING, "memory_card_delete_notice_confirm")), CharSequence.class, "com.obric.memorydata.plugin"), new $$Lambda$x$drnHo_G0cIlSGkZS7PffocBRsI(r7, r8)).g(), com.obric.oui.dialog.v2.alert.a.class, "com.obric.memorydata.plugin");
        r9.setCanceledOnTouchOutside(true);
        r9.setCancelable(true);
        r9.show();
    }

    private static final void delete(ItemMemoryListBinding r9, com.obric.memorydata.memory.ui.data.a r10) {
        ConstraintLayout r0 = r9.getRoot();
        Intrinsics.checkNotNullExpressionValue(r0, "getRoot(...)");
        LifecycleCoroutineScope r1 = b((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin"));
        if (r1 == null) goto L6;
        kotlinx.coroutines.i.a((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new MemoryListItemViewHolderKt$delete$1(r10, r9, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return;
    }

    /* JADX INFO: renamed from: lambda$drnHo_G0cIlSGkZS7PffocB-RsI, reason: not valid java name */
    public static /* synthetic */ Unit m950lambda$drnHo_G0cIlSGkZS7PffocBRsI(ItemMemoryListBinding r0, com.obric.memorydata.memory.ui.data.a r1, DialogInterface r2, int r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$xH6I_HRe9YRKprcjyXuUMF72UIw(DialogInterface r0, int r1) {
        return a(r0, r1);
    }
}
