package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActivityResultContract<I, O> {

    public static final class SynchronousResult<T> {
        private final T value;

        public SynchronousResult(T r10) {
            this.value = r10;
        }

        public final T getValue() {
            return this.value;
        }
    }

    public ActivityResultContract() {
    }

    public abstract Intent createIntent(Context r10, I r11);

    public SynchronousResult<O> getSynchronousResult(Context r10, I r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        return null;
    }

    public abstract O parseResult(int r10, Intent r11);
}
