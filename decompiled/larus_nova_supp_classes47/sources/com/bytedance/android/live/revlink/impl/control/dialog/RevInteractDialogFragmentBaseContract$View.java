package com.bytedance.android.live.revlink.impl.control.dialog;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AndroidLifecycleScopeProvider;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDisposeConverter;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.control.dialog.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class RevInteractDialogFragmentBaseContract$View<T extends g> extends BaseFragment implements com.bytedance.android.livesdk.common.d {
    public r d;
    public final String e;
    public T f;

    public abstract float U90();

    public View V90() {
        return null;
    }

    public View W90() {
        return null;
    }

    public abstract String X90();

    public ViewGroup Z90() {
        return null;
    }

    public <S> AutoDisposeConverter<S> S90() {
        return AutoDispose.bind(this.d.getLifecycleOwner());
    }

    public final <R> AutoDisposeConverter<R> T90() {
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(this.d.getLifecycleOwner(), Lifecycle.Event.ON_DESTROY), RxUtil.rxSchedulerHelper());
    }

    public RevInteractDialogFragmentBaseContract$View() {
        this.e = getClass().getName();
    }

    public Boolean aa0() {
        return Boolean.TRUE;
    }

    public int Y90(View r1) {
        return s1.f(56.0f);
    }
}
