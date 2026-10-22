package com.bytedance.android.livesdk.interactivity.medialink.dialog.contract;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AndroidLifecycleScopeProvider;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDisposeConverter;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.common.d;
import t82.e;
import t82.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class MediaInteractDialogFragmentBaseContract$View<T extends e> extends BaseFragment implements d {
    public f d;
    public final String e;
    public T f;

    public abstract float T90();

    public View U90() {
        return null;
    }

    public abstract String V90();

    public ViewGroup X90() {
        return null;
    }

    public final <R> AutoDisposeConverter<R> S90() {
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(this.d.getLifecycleOwner(), Lifecycle.Event.ON_DESTROY), RxUtil.rxSchedulerHelper());
    }

    public MediaInteractDialogFragmentBaseContract$View() {
        this.e = getClass().getName();
    }

    public int W90(View r1) {
        return s1.f(56.0f);
    }
}
