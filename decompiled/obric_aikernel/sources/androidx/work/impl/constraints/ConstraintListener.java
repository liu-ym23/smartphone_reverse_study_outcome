package androidx.work.impl.constraints;

import androidx.annotation.MainThread;

/* JADX INFO: loaded from: classes.dex */
public interface ConstraintListener<T> {
    @MainThread
    void onConstraintChanged(T r10);
}
