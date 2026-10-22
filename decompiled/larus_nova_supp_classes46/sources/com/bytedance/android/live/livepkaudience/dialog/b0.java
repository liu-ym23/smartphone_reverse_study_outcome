package com.bytedance.android.live.livepkaudience.dialog;

import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AndroidLifecycleScopeProvider;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDisposeConverter;
import com.bytedance.android.live.livepkaudience.dialog.RevInteractDialogFragmentBaseContract$View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class b0<V extends RevInteractDialogFragmentBaseContract$View> extends com.bytedance.android.livesdk.common.c {
    public final V b;

    public final <R> AutoDisposeConverter<R> c() {
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(((RevLinkDialog) this.b.d).k, Lifecycle.Event.ON_DESTROY), RxUtil.rxSchedulerHelper());
    }

    public b0(V r1) {
        this.b = r1;
        ((com.bytedance.android.livesdk.common.c) this).a = r1;
    }
}
