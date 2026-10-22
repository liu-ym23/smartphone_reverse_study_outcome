package androidx.lifecycle;

import androidx.arch.core.util.Function;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001aB\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u001c\u0010\u0005\u001a\u0018\u0012\t\u0012\u0007H\u0002¢\u0006\u0002\b\u0007\u0012\t\u0012\u0007H\u0004¢\u0006\u0002\b\u00070\u0006H\u0007\u001a8\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\tH\u0007\u001aJ\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012$\u0010\u0005\u001a \u0012\t\u0012\u0007H\u0002¢\u0006\u0002\b\u0007\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\u0001¢\u0006\u0002\b\u00070\u0006H\u0007\u001a>\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00010\tH\u0007¨\u0006\f"}, d2 = {"distinctUntilChanged", "Landroidx/lifecycle/LiveData;", "X", "map", "Y", "transform", "Lkotlin/Function1;", "Lkotlin/jvm/JvmSuppressWildcards;", "mapFunction", "Landroidx/arch/core/util/Function;", "switchMap", "switchMapFunction", "lifecycle-livedata_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Transformations {
    public static final <X> LiveData<X> distinctUntilChanged(LiveData<X> r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        final MediatorLiveData r0 = new MediatorLiveData();
        final Ref.BooleanRef r1 = new Ref.BooleanRef();
        r1.element = true;
        if (r4.isInitialized() == false) goto L5;
        r0.setValue(r4.getValue());
        r1.element = false;
    L5:
        r0.addSource(r4, (Observer) ZeusTransformUtils.preCheckCast(new Transformations$sam$androidx_lifecycle_Observer$0((Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r0, r1), Function1.class, "com.obric.memorydata.plugin")), Observer.class, "com.obric.memorydata.plugin"));
        return (LiveData) ZeusTransformUtils.preCheckCast(r0, LiveData.class, "com.obric.memorydata.plugin");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use kotlin functions, instead of outdated arch core Functions")
    public static final /* synthetic */ LiveData map(LiveData r3, Function r4) {
        final Function r5 = (Function) ZeusTransformUtils.wrapperContextForParams(r4, Function.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r5, "mapFunction");
        final MediatorLiveData r0 = new MediatorLiveData();
        r0.addSource(r3, (Observer) ZeusTransformUtils.preCheckCast(new Transformations$sam$androidx_lifecycle_Observer$0((Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r0, r5), Function1.class, "com.obric.memorydata.plugin")), Observer.class, "com.obric.memorydata.plugin"));
        return (LiveData) ZeusTransformUtils.preCheckCast(r0, LiveData.class, "com.obric.memorydata.plugin");
    }

    public static final <X, Y> LiveData<Y> map(LiveData<X> r3, Function1<X, Y> r4) {
        final Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r5, "transform");
        final MediatorLiveData r0 = new MediatorLiveData();
        r0.addSource(r3, (Observer) ZeusTransformUtils.preCheckCast(new Transformations$sam$androidx_lifecycle_Observer$0((Function1) ZeusTransformUtils.preCheckCast(new C09341(r0, r5), Function1.class, "com.obric.memorydata.plugin")), Observer.class, "com.obric.memorydata.plugin"));
        return (LiveData) ZeusTransformUtils.preCheckCast(r0, LiveData.class, "com.obric.memorydata.plugin");
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use kotlin functions, instead of outdated arch core Functions")
    public static final /* synthetic */ LiveData switchMap(LiveData r3, Function r4) {
        final Function r5 = (Function) ZeusTransformUtils.wrapperContextForParams(r4, Function.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r5, "switchMapFunction");
        final MediatorLiveData r0 = new MediatorLiveData();
        r0.addSource(r3, (Observer) ZeusTransformUtils.preCheckCast(new C09362(r5, r0), Observer.class, "com.obric.memorydata.plugin"));
        return (LiveData) ZeusTransformUtils.preCheckCast(r0, LiveData.class, "com.obric.memorydata.plugin");
    }

    public static final <X, Y> LiveData<Y> switchMap(LiveData<X> r3, Function1<X, LiveData<Y>> r4) {
        final Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r5, "transform");
        final MediatorLiveData r0 = new MediatorLiveData();
        r0.addSource(r3, (Observer) ZeusTransformUtils.preCheckCast(new C09351(r5, r0), Observer.class, "com.obric.memorydata.plugin"));
        return (LiveData) ZeusTransformUtils.preCheckCast(r0, LiveData.class, "com.obric.memorydata.plugin");
    }
}
