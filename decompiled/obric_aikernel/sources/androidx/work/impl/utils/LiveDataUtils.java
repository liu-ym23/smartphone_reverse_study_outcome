package androidx.work.impl.utils;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class LiveDataUtils {

    /* JADX INFO: Add missing generic type declarations: [In] */
    /* JADX INFO: renamed from: androidx.work.impl.utils.LiveDataUtils$1, reason: invalid class name */
    class AnonymousClass1<In> implements Observer<In> {
        Out mCurrentOutput;
        final /* synthetic */ Object val$lock;
        final /* synthetic */ Function val$mappingMethod;
        final /* synthetic */ MediatorLiveData val$outputLiveData;
        final /* synthetic */ TaskExecutor val$workTaskExecutor;

        AnonymousClass1(TaskExecutor r10, Object r11, Function r12, MediatorLiveData r13) {
            this.val$workTaskExecutor = r10;
            this.val$lock = r11;
            this.val$mappingMethod = r12;
            this.val$outputLiveData = r13;
            this.mCurrentOutput = null;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable final In r10) {
            this.val$workTaskExecutor.executeOnTaskThread(new RunnableC00221(this, r10));
        }
    }

    private LiveDataUtils() {
    }

    @NonNull
    @SuppressLint({"LambdaLast"})
    public static <In, Out> LiveData<Out> dedupedMappedLiveDataFor(@NonNull LiveData<In> r10, @NonNull Function<In, Out> r11, @NonNull TaskExecutor r12) {
        Object r13 = new Object();
        MediatorLiveData r14 = new MediatorLiveData();
        r14.addSource(r10, new AnonymousClass1(r12, r13, r11, r14));
        return r14;
    }
}
