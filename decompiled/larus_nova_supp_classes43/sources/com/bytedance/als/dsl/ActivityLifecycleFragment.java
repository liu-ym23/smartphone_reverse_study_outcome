package com.bytedance.als.dsl;

import android.app.Fragment;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/als/dsl/ActivityLifecycleFragment;", "Landroid/app/Fragment;", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "()V", "als_release"}, k = 1, mv = {1, 4, 1})
public final class ActivityLifecycleFragment extends Fragment implements LifecycleOwner {
    public final LifecycleRegistry a;

    @Override // android.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
    }

    public ActivityLifecycleFragment() {
        this.a = new LifecycleRegistry(this);
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.a.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    @Override // android.app.Fragment
    public final void onPause() {
        super.onPause();
        this.a.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.a.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.a.handleLifecycleEvent(Lifecycle.Event.ON_START);
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.a.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    public final Lifecycle getLifecycle() {
        return this.a;
    }

    @Override // android.app.Fragment
    public final void onActivityCreated(Bundle r10) {
        super.onActivityCreated(r10);
        this.a.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }
}
