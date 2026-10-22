package ge0;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AndroidLifecycleScopeProvider;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDisposeConverter;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.interact.contract.InteractDialogFragmentBaseContract$View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class a<V extends InteractDialogFragmentBaseContract$View> extends com.bytedance.android.livesdk.common.c {
    public final V b;

    public final <R> AutoDisposeConverter<R> c() {
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(this.b.d.getLifecycleOwner(), Lifecycle.Event.ON_DESTROY), RxUtil.rxSchedulerHelper());
    }

    public a(V r1) {
        this.b = r1;
        ((com.bytedance.android.livesdk.common.c) this).a = r1;
    }
}
