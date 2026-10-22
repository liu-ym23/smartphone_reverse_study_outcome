package androidx.lifecycle;

import android.view.View;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007¢\u0006\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"findViewTreeViewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroid/view/View;", "get", "setViewTreeViewModelStoreOwner", "", "viewModelStoreOwner", "set", "lifecycle-viewmodel_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ViewTreeViewModelStoreOwner {
    public static final ViewModelStoreOwner get(View r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return (ViewModelStoreOwner) ZeusTransformUtils.preCheckCast(SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.generateSequence(r3, (Function1) ZeusTransformUtils.preCheckCast(ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin")), (Function1) ZeusTransformUtils.preCheckCast(ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2.INSTANCE, Function1.class, "com.obric.memorydata.plugin"))), ViewModelStoreOwner.class, "com.obric.memorydata.plugin");
    }

    public static final void set(View r3, ViewModelStoreOwner r4) {
        ViewModelStoreOwner r5 = (ViewModelStoreOwner) ZeusTransformUtils.wrapperContextForParams(r4, ViewModelStoreOwner.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        r3.setTag(ZeusTransformUtils.mapRes(R.id.view_tree_view_model_store_owner, OaidModel.KEY_ID, "view_tree_view_model_store_owner"), r5);
    }
}
