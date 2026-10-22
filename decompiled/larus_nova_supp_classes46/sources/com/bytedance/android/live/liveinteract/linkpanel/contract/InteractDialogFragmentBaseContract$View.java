package com.bytedance.android.live.liveinteract.linkpanel.contract;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AndroidLifecycleScopeProvider;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDisposeConverter;
import com.bytedance.android.livesdk.common.d;
import yf0.e;
import yf0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class InteractDialogFragmentBaseContract$View<T extends e> extends BaseFragment implements d {
    public g d;
    public final String e;
    public T f;

    public abstract float T90();

    public View U90() {
        return null;
    }

    public View V90() {
        return null;
    }

    public abstract String W90();

    public ViewGroup X90() {
        return null;
    }

    public void Y90() {
    }

    public void Z90() {
    }

    public final <R> AutoDisposeConverter<R> S90() {
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(this.d.getLifecycleOwner(), Lifecycle.Event.ON_DESTROY), RxUtil.rxSchedulerHelper());
    }

    public InteractDialogFragmentBaseContract$View() {
        this.e = getClass().getName();
    }
}
