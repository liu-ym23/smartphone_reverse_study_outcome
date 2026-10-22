package androidx.lifecycle;

import androidx.annotation.CheckResult;
import androidx.annotation.MainThread;
import androidx.arch.core.util.Function;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes.dex */
@JvmName(name = "Transformations")
public final class Transformations {
    @CheckResult
    @MainThread
    @JvmName(name = "distinctUntilChanged")
    public static final <X> LiveData<X> distinctUntilChanged(LiveData<X> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        final MediatorLiveData r11 = new MediatorLiveData();
        final Ref.BooleanRef r12 = new Ref.BooleanRef();
        r12.element = true;
        if (r10.isInitialized() == false) goto L5;
        r11.setValue(r10.getValue());
        r12.element = false;
    L5:
        r11.addSource(r10, new Transformations$sam$androidx_lifecycle_Observer$0(new AnonymousClass1(r11, r12)));
        return r11;
    }

    @JvmName(name = "map")
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use kotlin functions, instead of outdated arch core Functions")
    @CheckResult
    @MainThread
    public static final /* synthetic */ LiveData map(LiveData r10, final Function r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "mapFunction");
        final MediatorLiveData r12 = new MediatorLiveData();
        r12.addSource(r10, new Transformations$sam$androidx_lifecycle_Observer$0(new AnonymousClass2(r12, r11)));
        return r12;
    }

    @CheckResult
    @MainThread
    @JvmName(name = "map")
    public static final <X, Y> LiveData<Y> map(LiveData<X> r10, final Function1<X, Y> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        final MediatorLiveData r12 = new MediatorLiveData();
        r12.addSource(r10, new Transformations$sam$androidx_lifecycle_Observer$0(new C03381(r12, r11)));
        return r12;
    }

    @JvmName(name = "switchMap")
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use kotlin functions, instead of outdated arch core Functions")
    @CheckResult
    @MainThread
    public static final /* synthetic */ LiveData switchMap(LiveData r10, final Function r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "switchMapFunction");
        final MediatorLiveData r12 = new MediatorLiveData();
        r12.addSource(r10, new C03402(r11, r12));
        return r12;
    }

    @CheckResult
    @MainThread
    @JvmName(name = "switchMap")
    public static final <X, Y> LiveData<Y> switchMap(LiveData<X> r10, final Function1<X, LiveData<Y>> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        final MediatorLiveData r12 = new MediatorLiveData();
        r12.addSource(r10, new C03391(r11, r12));
        return r12;
    }
}
