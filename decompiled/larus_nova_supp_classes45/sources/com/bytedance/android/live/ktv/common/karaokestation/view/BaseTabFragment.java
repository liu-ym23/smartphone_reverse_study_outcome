package com.bytedance.android.live.ktv.common.karaokestation.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.DialogFragment;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/ktv/common/karaokestation/view/BaseTabFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class BaseTabFragment extends DialogFragment {
    public final Lazy d;

    public abstract int getLayoutId();

    public abstract void initData();

    public abstract void initView(View r1);

    public BaseTabFragment() {
        this.d = LazyKt.lazy(BaseTabFragment$compositeDisposable$2.INSTANCE);
    }

    public void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        ((CompositeDisposable) this.d.getValue()).clear();
    }

    public final void S90(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$bind");
        ((CompositeDisposable) this.d.getValue()).add(r2);
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        initData();
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        View r4 = null;
        if (r2 == null) goto L7;
        Context r5 = r2.getContext();
        if (r5 == null) goto L7;
        r4 = LayoutInflater.from(r5).inflate(getLayoutId(), null);
    L7:
        initView(r4);
        return r4;
    }
}
