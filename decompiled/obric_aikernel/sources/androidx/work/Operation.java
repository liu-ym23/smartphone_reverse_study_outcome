package androidx.work;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LiveData;

/* JADX INFO: loaded from: classes.dex */
public interface Operation {

    @SuppressLint({"SyntheticAccessor"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final State.IN_PROGRESS IN_PROGRESS = null;

    @SuppressLint({"SyntheticAccessor"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final State.SUCCESS SUCCESS = null;

    /* JADX INFO: renamed from: androidx.work.Operation$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract class State {

        public static final class FAILURE extends State {
            private final Throwable mThrowable;

            public FAILURE(@NonNull Throwable r10) {
                this.mThrowable = r10;
            }

            @NonNull
            public Throwable getThrowable() {
                return this.mThrowable;
            }

            @NonNull
            public String toString() {
                return "FAILURE (" + this.mThrowable.getMessage() + ")";
            }
        }

        public static final class IN_PROGRESS extends State {
            private IN_PROGRESS() {
            }

            /* synthetic */ IN_PROGRESS(AnonymousClass1 r10) {
                this();
            }

            @NonNull
            public String toString() {
                return "IN_PROGRESS";
            }
        }

        public static final class SUCCESS extends State {
            private SUCCESS() {
            }

            /* synthetic */ SUCCESS(AnonymousClass1 r10) {
                this();
            }

            @NonNull
            public String toString() {
                return "SUCCESS";
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        State() {
        }
    }

    static {
        AnonymousClass1 r10 = null;
        SUCCESS = new State.SUCCESS(r10);
        IN_PROGRESS = new State.IN_PROGRESS(r10);
    }

    @NonNull
    c6.a<State.SUCCESS> getResult();

    @NonNull
    LiveData<State> getState();
}
