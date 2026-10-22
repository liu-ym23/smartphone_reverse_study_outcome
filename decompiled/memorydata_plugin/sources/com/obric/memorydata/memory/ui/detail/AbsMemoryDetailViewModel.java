package com.obric.memorydata.memory.ui.detail;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.paging.PagingData;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0007\b&\u0018\u0000 **\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001*B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0011\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0002\u0010\u0016J\u0015\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00028\u0000H&¢\u0006\u0002\u0010(J\b\u0010)\u001a\u00020\u0014H&R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u001e\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000bR\u001e\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u000bR*\u0010#\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00180$0\tX¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u000b¨\u0006+"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/AbsMemoryDetailViewModel;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_episodicMemoryEntityId", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "episodicMemoryEntityId", "Lkotlinx/coroutines/flow/StateFlow;", "getEpisodicMemoryEntityId", "()Lkotlinx/coroutines/flow/StateFlow;", "_enterFrom", "get_enterFrom", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "enterFrom", "getEnterFrom", "refresh", "()Ljava/lang/Object;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "sourceData", "(Ljava/lang/Object;Ljava/lang/String;)V", "memoryCalendarItemsFlow", "", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$Calendar;", "getMemoryCalendarItemsFlow", "pagingDataFlow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "getPagingDataFlow", "()Lkotlinx/coroutines/flow/Flow;", "memoryEntityStateFlow", "getMemoryEntityStateFlow", "memoryKeyInfo", "", "getMemoryKeyInfo", "deleteMemoryEntity", "memoryEntity", "(Ljava/lang/Object;)V", "deleteExpiredMemoryCalendarItems", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AbsMemoryDetailViewModel<T> extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "AbsMemoryDetailViewModel";
    private final kotlinx.coroutines.flow.ae<String> _enterFrom;
    private final kotlinx.coroutines.flow.ae<String> _episodicMemoryEntityId;
    private final ar<String> enterFrom;
    private final ar<String> episodicMemoryEntityId;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/AbsMemoryDetailViewModel$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public AbsMemoryDetailViewModel() {
        kotlinx.coroutines.flow.ae<String> r0 = at.a(null);
        this._episodicMemoryEntityId = r0;
        this.episodicMemoryEntityId = kotlinx.coroutines.flow.k.a(r0);
        kotlinx.coroutines.flow.ae<String> r1 = at.a("");
        this._enterFrom = r1;
        this.enterFrom = kotlinx.coroutines.flow.k.a(r1);
    }

    public static /* synthetic */ void init$default(AbsMemoryDetailViewModel r0, Object r1, String r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L6;
        r2 = (String) ZeusTransformUtils.preCheckCast(r0._enterFrom.c(), String.class, "com.obric.memorydata.plugin");
    L6:
        r0.init(r1, r2);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
    }

    public abstract void deleteExpiredMemoryCalendarItems();

    public abstract void deleteMemoryEntity(T r1);

    public final ar<String> getEnterFrom() {
        return this.enterFrom;
    }

    public final ar<String> getEpisodicMemoryEntityId() {
        return this.episodicMemoryEntityId;
    }

    public abstract ar<List<com.obric.memorydata.memory.ui.data.a.c>> getMemoryCalendarItemsFlow();

    public abstract ar<com.obric.memorydata.memory.ui.data.a> getMemoryEntityStateFlow();

    public abstract ar<Map<String, List<String>>> getMemoryKeyInfo();

    public abstract kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> getPagingDataFlow();

    public final kotlinx.coroutines.flow.ae<String> get_enterFrom() {
        return this._enterFrom;
    }

    public void init(T r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "enterFrom");
        this._enterFrom.b(r2);
    }

    public abstract T refresh();
}
