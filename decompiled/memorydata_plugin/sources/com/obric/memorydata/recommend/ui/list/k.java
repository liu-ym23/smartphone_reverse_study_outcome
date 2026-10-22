package com.obric.memorydata.recommend.ui.list;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import com.mcxtzhang.swipemenulib.SwipeMenuLayout;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.recommend.databinding.ItemRecommendMemoryCardBinding;
import com.obric.memorydata.utils.at;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\bH\u0002\u001a\u000e\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\bH\u0002\u001a\u000e\u0010\u000b\u001a\u0004\u0018\u00010\f*\u00020\bH\u0002\u001a\u000e\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\bH\u0002¨\u0006\u000f"}, d2 = {"showDeleteDialog", "", "binding", "Lcom/obric/memorydata/recommend/databinding/ItemRecommendMemoryCardBinding;", "memoryItem", "Lcom/obric/memorydata/recommend/ui/list/MemoryItem;", "getLifecycleScope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "Landroid/view/View;", "getMemoryListViewModel", "Lcom/obric/memorydata/recommend/ui/list/MemoryListViewModel;", "getUserPortraitViewModel", "Lcom/obric/memorydata/recommend/ui/list/PortraitViewModel;", "getUserTodoViewModel", "Lcom/obric/memorydata/recommend/ui/list/UserTodoViewModel;", "recommend_obricRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class k {
    public static final /* synthetic */ MemoryListViewModel a(View r0) {
        return e(r0);
    }

    private static final Unit a(DialogInterface r1, int r2) {
        DialogInterface r3 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r1, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "dialog");
        r3.dismiss();
        return Unit.INSTANCE;
    }

    private static final Unit a(ItemRecommendMemoryCardBinding r7, f r8, DialogInterface r9, int r10) {
        DialogInterface r11 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r9, DialogInterface.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "dialog");
        SwipeMenuLayout r12 = r7.getRoot();
        Intrinsics.checkNotNullExpressionValue(r12, "getRoot(...)");
        LifecycleCoroutineScope r13 = d((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.memorydata.plugin"));
        if (r13 == null) goto L5;
        kotlinx.coroutines.i.a((al) ZeusTransformUtils.preCheckCast(r13, al.class, "com.obric.memorydata.plugin"), null, null, (Function2) ZeusTransformUtils.preCheckCast(new RecommendMemoryItemViewHolderKt$showDeleteDialog$2$1(r8, r7, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    L5:
        r11.dismiss();
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void a(ItemRecommendMemoryCardBinding r0, f r1) {
        b(r0, r1);
    }

    public static final /* synthetic */ PortraitViewModel b(View r0) {
        return f(r0);
    }

    private static final void b(final ItemRecommendMemoryCardBinding r7, final f r8) {
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getRoot().getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r1, "getContext(...)");
        com.obric.oui.dialog.v2.alert.b.a(new com.obric.oui.dialog.v2.alert.b(r1).b(false), (CharSequence) ZeusTransformUtils.preCheckCast(at.a(ZeusTransformUtils.mapRes(R.string.recommend_memory_general_delete_notice_title, TypedValues.Custom.S_STRING, "recommend_memory_general_delete_notice_title")), CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null).a(null).a(true).b((CharSequence) ZeusTransformUtils.preCheckCast(at.a(ZeusTransformUtils.mapRes(R.string.recommend_memory_general_delete_notice_cancel, TypedValues.Custom.S_STRING, "recommend_memory_general_delete_notice_cancel")), CharSequence.class, "com.obric.memorydata.plugin"), $$Lambda$k$zpQBSv1TquXK1yeUQBfRnOGMkLA.INSTANCE).a((CharSequence) ZeusTransformUtils.preCheckCast(at.a(ZeusTransformUtils.mapRes(R.string.recommend_memory_general_delete_notice_confirm, TypedValues.Custom.S_STRING, "recommend_memory_general_delete_notice_confirm")), CharSequence.class, "com.obric.memorydata.plugin"), new $$Lambda$k$TZill7z97UGqj1I4wOqyt3Xdpik(r7, r8)).h();
    }

    public static final /* synthetic */ UserTodoViewModel c(View r0) {
        return g(r0);
    }

    private static final LifecycleCoroutineScope d(View r0) {
        LifecycleOwner r1 = ViewTreeLifecycleOwner.get(r0);
        if (r1 != null) goto L7;
        return null;
    L7:
        return LifecycleOwnerKt.getLifecycleScope(r1);
    }

    private static final MemoryListViewModel e(View r2) {
        ViewModelStoreOwner r3 = ViewTreeViewModelStoreOwner.get(r2);
        if (r3 != null) goto L5;
        return null;
    L5:
        return (MemoryListViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider(r3).get(MemoryListViewModel.class), MemoryListViewModel.class, "com.obric.memorydata.plugin");
    }

    private static final PortraitViewModel f(View r2) {
        ViewModelStoreOwner r3 = ViewTreeViewModelStoreOwner.get(r2);
        if (r3 != null) goto L5;
        return null;
    L5:
        return (PortraitViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider(r3).get(PortraitViewModel.class), PortraitViewModel.class, "com.obric.memorydata.plugin");
    }

    private static final UserTodoViewModel g(View r2) {
        ViewModelStoreOwner r3 = ViewTreeViewModelStoreOwner.get(r2);
        if (r3 != null) goto L5;
        return null;
    L5:
        return (UserTodoViewModel) ZeusTransformUtils.preCheckCast(new ViewModelProvider(r3).get(UserTodoViewModel.class), UserTodoViewModel.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ Unit lambda$TZill7z97UGqj1I4wOqyt3Xdpik(ItemRecommendMemoryCardBinding r0, f r1, DialogInterface r2, int r3) {
        return a(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$zpQBSv1TquXK1yeUQBfRnOGMkLA(DialogInterface r0, int r1) {
        return a(r0, r1);
    }
}
