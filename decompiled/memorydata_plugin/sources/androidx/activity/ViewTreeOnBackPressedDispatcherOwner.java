package androidx.activity;

import android.view.View;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007¢\u0006\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"findViewTreeOnBackPressedDispatcherOwner", "Landroidx/activity/OnBackPressedDispatcherOwner;", "Landroid/view/View;", "get", "setViewTreeOnBackPressedDispatcherOwner", "", "onBackPressedDispatcherOwner", "set", "activity_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ViewTreeOnBackPressedDispatcherOwner {
    public static final OnBackPressedDispatcherOwner get(View r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return (OnBackPressedDispatcherOwner) ZeusTransformUtils.preCheckCast(SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.generateSequence(r3, (Function1) ZeusTransformUtils.preCheckCast(ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin")), (Function1) ZeusTransformUtils.preCheckCast(ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$2.INSTANCE, Function1.class, "com.obric.memorydata.plugin"))), OnBackPressedDispatcherOwner.class, "com.obric.memorydata.plugin");
    }

    public static final void set(View r3, OnBackPressedDispatcherOwner r4) {
        OnBackPressedDispatcherOwner r5 = (OnBackPressedDispatcherOwner) ZeusTransformUtils.wrapperContextForParams(r4, OnBackPressedDispatcherOwner.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r5, "onBackPressedDispatcherOwner");
        r3.setTag(ZeusTransformUtils.mapRes(R.id.view_tree_on_back_pressed_dispatcher_owner, OaidModel.KEY_ID, "view_tree_on_back_pressed_dispatcher_owner"), r5);
    }
}
