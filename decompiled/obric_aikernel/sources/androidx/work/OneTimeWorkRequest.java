package androidx.work;

import android.os.Build;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class OneTimeWorkRequest extends WorkRequest {
    public static final Companion Companion = null;

    public static final class Builder extends WorkRequest.Builder<Builder, OneTimeWorkRequest> {
        public Builder(Class<? extends ListenableWorker> r10) {
            Intrinsics.checkNotNullParameter(r10, "workerClass");
            super(r10);
            WorkSpec r11 = getWorkSpec$work_runtime_release();
            r11.inputMergerClassName = OverwritingInputMerger.class.getName();
        }

        @Override // androidx.work.WorkRequest.Builder
        public OneTimeWorkRequest buildInternal$work_runtime_release() {
            if (getBackoffCriteriaSet$work_runtime_release() == true) goto L5;
        L10:
            boolean r10 = true;
        L11:
            if (r10 == false) goto L15;
            return new OneTimeWorkRequest(this);
        L15:
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job".toString());
        L5:
            if (Build.VERSION.SDK_INT < 23) goto L10;
            if (getWorkSpec$work_runtime_release().constraints.requiresDeviceIdle() == false) goto L10;
            r10 = false;
            goto L11
        }

        @Override // androidx.work.WorkRequest.Builder
        public /* bridge */ /* synthetic */ WorkRequest buildInternal$work_runtime_release() {
            return buildInternal$work_runtime_release();
        }

        @Override // androidx.work.WorkRequest.Builder
        public Builder getThisObject$work_runtime_release() {
            return this;
        }

        @Override // androidx.work.WorkRequest.Builder
        public /* bridge */ /* synthetic */ WorkRequest.Builder getThisObject$work_runtime_release() {
            return getThisObject$work_runtime_release();
        }

        public final Builder setInputMerger(Class<? extends InputMerger> r10) {
            Intrinsics.checkNotNullParameter(r10, "inputMerger");
            WorkSpec r11 = getWorkSpec$work_runtime_release();
            r11.inputMergerClassName = r10.getName();
            return this;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        @JvmStatic
        public final OneTimeWorkRequest from(Class<? extends ListenableWorker> r10) {
            Intrinsics.checkNotNullParameter(r10, "workerClass");
            return new Builder(r10).build();
        }

        @JvmStatic
        public final List<OneTimeWorkRequest> from(List<? extends Class<? extends ListenableWorker>> r10) {
            Intrinsics.checkNotNullParameter(r10, "workerClasses");
            ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
            Iterator<T> r12 = r10.iterator();
        L4:
            if (r12.hasNext() == false) goto L6;
            r11.add(new Builder((Class) r12.next()).build());
            goto L4
        L6:
            return r11;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public OneTimeWorkRequest(Builder r10) {
        Intrinsics.checkNotNullParameter(r10, "builder");
        super(r10.getId$work_runtime_release(), r10.getWorkSpec$work_runtime_release(), r10.getTags$work_runtime_release());
    }

    @JvmStatic
    public static final OneTimeWorkRequest from(Class<? extends ListenableWorker> r10) {
        return Companion.from(r10);
    }

    @JvmStatic
    public static final List<OneTimeWorkRequest> from(List<? extends Class<? extends ListenableWorker>> r10) {
        return Companion.from(r10);
    }
}
