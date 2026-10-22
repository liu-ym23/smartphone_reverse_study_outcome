package com.bytedance.android.live.core.utils.rxutils.rxlifecycle;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import io.reactivex.subjects.BehaviorSubject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class BindingFragment extends Fragment {
    public final BehaviorSubject<LifecycleEvent> d;

    public BindingFragment() {
        this.d = BehaviorSubject.create();
    }

    public final void onDestroy() {
        super.onDestroy();
        this.d.onNext(LifecycleEvent.DESTROY);
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d.onNext(LifecycleEvent.DESTROY_VIEW);
    }

    public final void onDetach() {
        super.onDetach();
        this.d.onNext(LifecycleEvent.DETACH);
    }

    public final void onPause() {
        super.onPause();
        this.d.onNext(LifecycleEvent.PAUSE);
    }

    public final void onResume() {
        super.onResume();
        this.d.onNext(LifecycleEvent.RESUME);
    }

    public final void onStart() {
        super.onStart();
        this.d.onNext(LifecycleEvent.START);
    }

    public final void onStop() {
        super.onStop();
        this.d.onNext(LifecycleEvent.STOP);
    }

    public final void onAttach(Activity r2) {
        super.onAttach(r2);
        this.d.onNext(LifecycleEvent.ATTACH);
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        this.d.onNext(LifecycleEvent.CREATE);
    }

    public final void onAttach(Context r2) {
        super.onAttach(r2);
        this.d.onNext(LifecycleEvent.ATTACH);
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        this.d.onNext(LifecycleEvent.CREATE_VIEW);
        return null;
    }
}
