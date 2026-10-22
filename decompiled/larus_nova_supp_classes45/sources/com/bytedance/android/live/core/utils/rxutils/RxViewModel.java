package com.bytedance.android.live.core.utils.rxutils;

import android.util.Pair;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.utils.rxutils.rxlifecycle.LifecycleEvent;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class RxViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable;
    private final List<Pair<LiveData, Observer>> liveDatas;
    private final BehaviorSubject<LifecycleEvent> mLifecycleBehavior;

    public void onCleared() {
        this.compositeDisposable.clear();
        Iterator<Pair<LiveData, Observer>> r0 = this.liveDatas.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Pair<LiveData, Observer> r1 = r0.next();
        ((LiveData) r1.first).removeObserver((androidx.lifecycle.Observer) r1.second);
        goto L4
    L6:
        this.liveDatas.clear();
        this.mLifecycleBehavior.onNext(LifecycleEvent.DESTROY);
    }

    public RxViewModel() {
        this.compositeDisposable = new CompositeDisposable();
        this.mLifecycleBehavior = BehaviorSubject.create();
        this.liveDatas = new ArrayList();
    }

    public final void register(Disposable r2) {
        this.compositeDisposable.add(r2);
    }
}
