package com.larus.search.impl.global;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.larus.paging.PagingSource;
import com.larus.paging.i0;
import com.larus.paging.j0;
import com.larus.paging.k0;
import com.tencent.open.log.TraceLevel;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J2\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e¨\u0006\u0010"}, d2 = {"Lcom/larus/search/impl/global/GlobalSearchViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "getSearchResultPager", "Landroidx/lifecycle/LiveData;", "Lcom/larus/paging/PagingData;", "Lcom/larus/search/impl/global/model/GlobalSearchResultItemWrapper;", "keyword", "", "enterMethod", "trackNode", "Ljava/lang/ref/WeakReference;", "Lcom/ixigua/lib/track/ITrackNode;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class GlobalSearchViewModel extends AndroidViewModel {
    public static /* synthetic */ PagingSource yo(String r0, String r1, WeakReference r2) {
        return getSearchResultPager$lambda$0(r0, r1, r2);
    }

    public GlobalSearchViewModel(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "application");
        super(r2);
    }

    private static final PagingSource getSearchResultPager$lambda$0(String r1, String r2, WeakReference r3) {
        return new GlobalSearchPagingSource(r1, r2, r3);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.search.impl.global.u] */
    public final LiveData<k0<ws9.c>> getSearchResultPager(final String r7, final String r8, final WeakReference<by7.e> r9) {
        Intrinsics.checkNotNullParameter(r7, "keyword");
        Intrinsics.checkNotNullParameter(r8, "enterMethod");
        Intrinsics.checkNotNullParameter(r9, "trackNode");
        return FlowLiveDataConversions.asLiveData$default(com.larus.paging.g.a(new i0(new j0(), new u(r7, r8, r9)).a, ViewModelKt.getViewModelScope(this)), null, 0, 3, null);
    }
}
