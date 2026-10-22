package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u00020\u0001\"\b\b\u0000\u0010\n*\u00020\u0005*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f\u001a4\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u00020\u0001\"\b\b\u0000\u0010\n*\u00020\u0005*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e\u001a4\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u00020\u0001\"\b\b\u0000\u0010\n*\u00020\u0005*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010\"A\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00020\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005\"\b\b\u0001\u0010\u0003*\u00020\u0005*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00030\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"liveData", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagingData;", "Value", "Key", "", "Landroidx/paging/Pager;", "getLiveData", "(Landroidx/paging/Pager;)Landroidx/lifecycle/LiveData;", "cachedIn", ExifInterface.GPS_DIRECTION_TRUE, "lifecycle", "Landroidx/lifecycle/Lifecycle;", "viewModel", "Landroidx/lifecycle/ViewModel;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "paging-runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PagingLiveData {
    public static final <T> LiveData<PagingData<T>> cachedIn(LiveData<PagingData<T>> r6, Lifecycle r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "lifecycle");
        return FlowLiveDataConversions.asLiveData$default(CachedPagingDataKt.cachedIn(FlowLiveDataConversions.asFlow(r6), (al) ZeusTransformUtils.preCheckCast(LifecycleKt.getCoroutineScope(r7), al.class, "com.obric.memorydata.plugin")), null, 0, 3, null);
    }

    public static final <T> LiveData<PagingData<T>> cachedIn(LiveData<PagingData<T>> r6, ViewModel r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "viewModel");
        return FlowLiveDataConversions.asLiveData$default(CachedPagingDataKt.cachedIn(FlowLiveDataConversions.asFlow(r6), ViewModelKt.getViewModelScope(r7)), null, 0, 3, null);
    }

    public static final <T> LiveData<PagingData<T>> cachedIn(LiveData<PagingData<T>> r6, al r7) {
        al r8 = (al) ZeusTransformUtils.wrapperContextForParams(r7, al.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r8, "scope");
        return FlowLiveDataConversions.asLiveData$default(CachedPagingDataKt.cachedIn(FlowLiveDataConversions.asFlow(r6), r8), null, 0, 3, null);
    }

    public static final <Key, Value> LiveData<PagingData<Value>> getLiveData(Pager<Key, Value> r7) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        return FlowLiveDataConversions.asLiveData$default(r7.getFlow(), null, 0, 3, null);
    }
}
