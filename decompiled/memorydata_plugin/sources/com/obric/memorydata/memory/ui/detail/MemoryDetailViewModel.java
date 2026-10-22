package com.obric.memorydata.memory.ui.detail;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.PagingData;
import androidx.paging.PagingDataTransforms;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.obric.capabilitykit.entity.memory.CommonTextMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.obric.memorydata.memory.llm.SessionStatus;
import com.obric.memorydata.memory.memoryentity.MemoryEntityManager;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.utils.at;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.flow.ar;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00020\u0001:\u000289B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020$H\u0002J\b\u0010&\u001a\u00020$H\u0002J\u0010\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020\u0002H\u0016J\u0018\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u0010H\u0016J\n\u0010,\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001d2\u0006\u0010.\u001a\u00020\u0002H\u0002J\u001e\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00110\u001d2\b\u00100\u001a\u0004\u0018\u00010\u0010H\u0002J$\u00101\u001a\u0004\u0018\u0001022\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u000104H\u0082@¢\u0006\u0002\u00106J\b\u00107\u001a\u00020$H\u0016R\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR&\u0010\u000e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00110\u000f0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R,\u0010\u0012\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00110\u000f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00110\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00110\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\rR\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\rR&\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001dX\u0096\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\"¨\u0006:"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/MemoryDetailViewModel;", "Lcom/obric/memorydata/memory/ui/detail/AbsMemoryDetailViewModel;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "<init>", "()V", "_memoryEntityStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$DetailEntity;", "get_memoryEntityStateFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "memoryEntityStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getMemoryEntityStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_memoryKeyInfo", "", "", "", "memoryKeyInfo", "getMemoryKeyInfo", "_memoryCalendarItemsFlow", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$Calendar;", "memoryCalendarItemsFlow", "getMemoryCalendarItemsFlow", "_detailStreamUiState", "Lcom/obric/memorydata/memory/ui/detail/MemoryDetailViewModel$DetailStreamUiState;", "detailStreamUiState", "getDetailStreamUiState", "pagingDataFlow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "Lcom/obric/memorydata/memory/ui/data/MemoryItem;", "getPagingDataFlow$annotations", "getPagingDataFlow", "()Lkotlinx/coroutines/flow/Flow;", "observeMemoryKeyInfo", "", "observeMemoryCalendarItems", "observeDetailStream", "deleteMemoryEntity", "memoryEntity", CommonConsts.APM_INNER_EVENT_COST_INIT, "sourceData", "enterFrom", "refresh", "getRelationMemoryEntity", "sourceMemoryEntity", "getPendingMemoryCalendars", "memoryUUID", "generateMemoryItemRelationText", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$RelationTitle;", "before", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$ListEntity;", "after", "(Lcom/obric/memorydata/memory/ui/data/MemoryItem$ListEntity;Lcom/obric/memorydata/memory/ui/data/MemoryItem$ListEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteExpiredMemoryCalendarItems", "Companion", "DetailStreamUiState", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryDetailViewModel extends AbsMemoryDetailViewModel<MemoryEntity> {
    public static final a Companion = null;
    private static final String TAG = "MemoryDetailViewModel";
    private final kotlinx.coroutines.flow.ae<b> _detailStreamUiState;
    private final kotlinx.coroutines.flow.ae<List<com.obric.memorydata.memory.ui.data.a.c>> _memoryCalendarItemsFlow;
    private final kotlinx.coroutines.flow.ae<com.obric.memorydata.memory.ui.data.a.e> _memoryEntityStateFlow;
    private final kotlinx.coroutines.flow.ae<Map<String, List<String>>> _memoryKeyInfo;
    private final ar<b> detailStreamUiState;
    private final ar<List<com.obric.memorydata.memory.ui.data.a.c>> memoryCalendarItemsFlow;
    private final ar<com.obric.memorydata.memory.ui.data.a.e> memoryEntityStateFlow;
    private final ar<Map<String, List<String>>> memoryKeyInfo;
    private final kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> pagingDataFlow;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/MemoryDetailViewModel$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n0\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J\u001b\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n0\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JW\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R#\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006#"}, d2 = {"Lcom/obric/memorydata/memory/ui/detail/MemoryDetailViewModel$DetailStreamUiState;", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "", "status", "Lcom/obric/memorydata/memory/llm/SessionStatus;", "contentFlow", "Lkotlinx/coroutines/flow/StateFlow;", "keyInfoMap", "", "", "resultStrMemory", "<init>", "(Ljava/lang/String;Lcom/obric/memorydata/memory/llm/SessionStatus;Lkotlinx/coroutines/flow/StateFlow;Ljava/util/Map;Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "getStatus", "()Lcom/obric/memorydata/memory/llm/SessionStatus;", "getContentFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "getKeyInfoMap", "()Ljava/util/Map;", "getResultStrMemory", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10823a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final SessionStatus f10824b;
        private final ar<String> c;
        private final Map<String, List<String>> d;
        private final String e;

        public b() {
            this(null, null, null, null, null, 31, null);
        }

        public b(String r3, SessionStatus r4, ar<String> r5, Map<String, ? extends List<String>> r6, String r7) {
            ar<String> r8 = (ar) ZeusTransformUtils.wrapperContextForParams(r5, ar.class, "com.obric.memorydata.plugin");
            Map<String, List<String>> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);
            Intrinsics.checkNotNullParameter(r9, "keyInfoMap");
            Intrinsics.checkNotNullParameter(r7, "resultStrMemory");
            this.f10823a = r3;
            this.f10824b = r4;
            this.c = r8;
            this.d = r9;
            this.e = r7;
        }

        public /* synthetic */ b(String r8, SessionStatus r9, ar r10, Map r11, String r12, int r13, DefaultConstructorMarker r14) {
            ar r15 = (ar) ZeusTransformUtils.wrapperContextForParams(r10, ar.class, "com.obric.memorydata.plugin");
            Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
            if ((r13 & 1) == 0) goto L5;
            String r2 = "";
        L7:
            if ((r13 & 2) == 0) goto L9;
            SessionStatus r3 = null;
        L11:
            if ((r13 & 4) == 0) goto L13;
            ar r4 = null;
        L15:
            if ((r13 & 8) == 0) goto L17;
            r16 = MapsKt.emptyMap();
        L17:
            Map r5 = r16;
            if ((r13 & 16) == 0) goto L20;
            String r6 = "";
        L21:
            this(r2, r3, r4, r5, r6);
            return;
        L20:
            r6 = r12;
            goto L21
        L13:
            r4 = r15;
            goto L15
        L9:
            r3 = r9;
            goto L11
        L5:
            r2 = r8;
            goto L7
        }

        public final String a() {
            return this.f10823a;
        }

        public final SessionStatus b() {
            return this.f10824b;
        }

        public final ar<String> c() {
            return this.c;
        }

        public final Map<String, List<String>> d() {
            return this.d;
        }

        public final String e() {
            return this.e;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f10823a, r6.f10823a) == true) goto L12;
            return false;
        L12:
            if (this.f10824b == r6.f10824b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = this.f10823a.hashCode() * 31;
            SessionStatus r1 = this.f10824b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            ar<String> r5 = this.c;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return ((((r4 + r2) * 31) + this.d.hashCode()) * 31) + this.e.hashCode();
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "DetailStreamUiState(text=" + this.f10823a + ", status=" + this.f10824b + ", contentFlow=" + this.c + ", keyInfoMap=" + this.d + ", resultStrMemory=" + this.e + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements kotlinx.coroutines.flow.i<List<? extends com.obric.memorydata.memory.ui.data.a.c>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f10825a;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.MemoryDetailViewModel$c$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f10826a;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3) {
                this.f10826a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r8, Continuation r9) {
                Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r10, MemoryDetailViewModel$getPendingMemoryCalendars$$inlined$map$1$2$1.class) == false) goto L7;
                MemoryDetailViewModel$getPendingMemoryCalendars$$inlined$map$1$2$1 r0 = (MemoryDetailViewModel$getPendingMemoryCalendars$$inlined$map$1$2$1) ZeusTransformUtils.preCheckCast(r10, MemoryDetailViewModel$getPendingMemoryCalendars$$inlined$map$1$2$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r11 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                ResultKt.throwOnFailure(r11);
            L28:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r11);
                kotlinx.coroutines.flow.j r7 = this.f10826a;
                Continuation r12 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
                Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
                Iterator<T> r15 = r13.iterator();
            L16:
                if (r15.hasNext() == false) goto L20;
                T r4 = r15.next();
                if (com.obric.memorydata.memory.island.d.f10194a.a((PendingMemoryCalendar) ZeusTransformUtils.preCheckCast(r4, PendingMemoryCalendar.class, "com.obric.memorydata.plugin")) == false) goto L16;
                r14.add(r4);
                goto L16
            L20:
                Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");
                Collection r17 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10)), Collection.class, "com.obric.memorydata.plugin");
                Iterator<T> r18 = r16.iterator();
            L22:
                if (r18.hasNext() == false) goto L24;
                r17.add(new com.obric.memorydata.memory.ui.data.a.c((PendingMemoryCalendar) ZeusTransformUtils.preCheckCast(r18.next(), PendingMemoryCalendar.class, "com.obric.memorydata.plugin")));
                goto L22
            L24:
                List r19 = (List) ZeusTransformUtils.preCheckCast(r17, List.class, "com.obric.memorydata.plugin");
                r0.label = 1;
                if (r7.emit(r19, r0) != r2) goto L28;
                return r2;
            L7:
                r0 = new MemoryDetailViewModel$getPendingMemoryCalendars$$inlined$map$1$2$1(this, r10);
                goto L8
            }
        }

        public c(kotlinx.coroutines.flow.i r3) {
            this.f10825a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super List<? extends com.obric.memorydata.memory.ui.data.a.c>> r3, Continuation r4) {
            kotlinx.coroutines.flow.j r5 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            Object r2 = this.f10825a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r6);
            if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r2;
        L6:
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a.h>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f10827a;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.MemoryDetailViewModel$d$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f10828a;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3) {
                this.f10828a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r6, Continuation r7) {
                Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r8, MemoryDetailViewModel$getRelationMemoryEntity$$inlined$map$1$2$1.class) == false) goto L7;
                MemoryDetailViewModel$getRelationMemoryEntity$$inlined$map$1$2$1 r0 = (MemoryDetailViewModel$getRelationMemoryEntity$$inlined$map$1$2$1) ZeusTransformUtils.preCheckCast(r8, MemoryDetailViewModel$getRelationMemoryEntity$$inlined$map$1$2$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r9 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                ResultKt.throwOnFailure(r9);
            L18:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r9);
                kotlinx.coroutines.flow.j r5 = this.f10828a;
                Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                PagingData r11 = PagingDataTransforms.flatMap((PagingData) ZeusTransformUtils.preCheckCast(r6, PagingData.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new MemoryDetailViewModel$getRelationMemoryEntity$1$1(null), Function2.class, "com.obric.memorydata.plugin"));
                r0.label = 1;
                if (r5.emit(r11, r0) != r2) goto L18;
                return r2;
            L7:
                r0 = new MemoryDetailViewModel$getRelationMemoryEntity$$inlined$map$1$2$1(this, r8);
                goto L8
            }
        }

        public d(kotlinx.coroutines.flow.i r3) {
            this.f10827a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super PagingData<com.obric.memorydata.memory.ui.data.a.h>> r3, Continuation r4) {
            kotlinx.coroutines.flow.j r5 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            Object r2 = this.f10827a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r6);
            if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r2;
        L6:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.MemoryDetailViewModel$deleteMemoryEntity$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.detail.MemoryDetailViewModel$deleteMemoryEntity$1", f = "MemoryDetailViewModel.kt", i = {}, l = {167}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ MemoryEntity $memoryEntity;
        int label;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.MemoryDetailViewModel$deleteMemoryEntity$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.detail.MemoryDetailViewModel$deleteMemoryEntity$1$1", f = "MemoryDetailViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C05491 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            final /* synthetic */ MemoryEntity $memoryEntity;
            int label;

            C05491(MemoryEntity r3, Continuation<? super C05491> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                this.$memoryEntity = r3;
                super(2, r5);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new C05491(this.$memoryEntity, r4), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Unit> r4) {
                return ((C05491) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C05491.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r8) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r8);
                com.obric.memorydata.memory.memoryentity.d.a(com.obric.memorydata.memory.memoryentity.d.f10317a, this.$memoryEntity, MemoryEventTracker.DeleteMethod.GUI_DELETE.getValue(), null, 4, null);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass1(MemoryEntity r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$memoryEntity = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$memoryEntity, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            CoroutineContext r8 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C05491(this.$memoryEntity, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.i.a(r8, r2, r3) != r0) goto L12;
            return r0;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e implements kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f10829a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MemoryDetailViewModel f10830b;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.MemoryDetailViewModel$e$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f10831a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ MemoryDetailViewModel f10832b;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3, MemoryDetailViewModel r4) {
                this.f10831a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                this.f10832b = r4;
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r7, Continuation r8) {
                Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r9, MemoryDetailViewModel$getRelationMemoryEntity$$inlined$map$2$2$1.class) == false) goto L7;
                MemoryDetailViewModel$getRelationMemoryEntity$$inlined$map$2$2$1 r0 = (MemoryDetailViewModel$getRelationMemoryEntity$$inlined$map$2$2$1) ZeusTransformUtils.preCheckCast(r9, MemoryDetailViewModel$getRelationMemoryEntity$$inlined$map$2$2$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r10 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                ResultKt.throwOnFailure(r10);
            L18:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r10);
                kotlinx.coroutines.flow.j r11 = this.f10831a;
                Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                PagingData r6 = PagingDataTransforms.insertSeparators$default((PagingData) ZeusTransformUtils.preCheckCast(r7, PagingData.class, "com.obric.memorydata.plugin"), null, (Function3) ZeusTransformUtils.preCheckCast(new MemoryDetailViewModel$getRelationMemoryEntity$2$1(this.f10832b, null), Function3.class, "com.obric.memorydata.plugin"), 1, null);
                r0.label = 1;
                if (r11.emit(r6, r0) != r2) goto L18;
                return r2;
            L7:
                r0 = new MemoryDetailViewModel$getRelationMemoryEntity$$inlined$map$2$2$1(this, r9);
                goto L8
            }
        }

        public e(kotlinx.coroutines.flow.i r3, MemoryDetailViewModel r4) {
            this.f10829a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
            this.f10830b = r4;
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super PagingData<com.obric.memorydata.memory.ui.data.a>> r4, Continuation r5) {
            kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            Object r3 = this.f10829a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r6, this.f10830b), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r7);
            if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r3;
        L6:
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f implements kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f10833a;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.MemoryDetailViewModel$f$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.j f10834a;

            public AnonymousClass1(kotlinx.coroutines.flow.j r3) {
                this.f10834a = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlinx.coroutines.flow.j
            public final Object emit(Object r7, Continuation r8) {
                Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
                if (ZeusTransformUtils.instanceOf(r9, MemoryDetailViewModel$getRelationMemoryEntity$$inlined$map$3$2$1.class) == false) goto L7;
                MemoryDetailViewModel$getRelationMemoryEntity$$inlined$map$3$2$1 r0 = (MemoryDetailViewModel$getRelationMemoryEntity$$inlined$map$3$2$1) ZeusTransformUtils.preCheckCast(r9, MemoryDetailViewModel$getRelationMemoryEntity$$inlined$map$3$2$1.class, "com.obric.memorydata.plugin");
                if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                r0.label -= Integer.MIN_VALUE;
            L8:
                Object r10 = r0.result;
                Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r3 = r0.label;
                if (r3 == 0) goto L14;
                if (r3 != 1) goto L13;
                ResultKt.throwOnFailure(r10);
            L18:
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r10);
                kotlinx.coroutines.flow.j r6 = this.f10834a;
                Continuation r11 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                PagingData r12 = PagingDataTransforms.insertFooterItem$default((PagingData) ZeusTransformUtils.preCheckCast(r7, PagingData.class, "com.obric.memorydata.plugin"), null, new com.obric.memorydata.memory.ui.data.a.g(at.a(ZeusTransformUtils.mapRes(R.string.memory_detail_footer_text, TypedValues.Custom.S_STRING, "memory_detail_footer_text"))), 1, null);
                r0.label = 1;
                if (r6.emit(r12, r0) != r2) goto L18;
                return r2;
            L7:
                r0 = new MemoryDetailViewModel$getRelationMemoryEntity$$inlined$map$3$2$1(this, r9);
                goto L8
            }
        }

        public f(kotlinx.coroutines.flow.i r3) {
            this.f10833a = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlinx.coroutines.flow.i
        public Object collect(kotlinx.coroutines.flow.j<? super PagingData<com.obric.memorydata.memory.ui.data.a>> r3, Continuation r4) {
            kotlinx.coroutines.flow.j r5 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            Object r2 = this.f10833a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r6);
            if (r2 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r2;
        L6:
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.MemoryDetailViewModel$generateMemoryItemRelationText$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/memory/ui/data/MemoryItem$RelationTitle;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.detail.MemoryDetailViewModel$generateMemoryItemRelationText$2", f = "MemoryDetailViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<al, Continuation<? super com.obric.memorydata.memory.ui.data.a.j>, Object> {
        final /* synthetic */ com.obric.memorydata.memory.ui.data.a.h $after;
        final /* synthetic */ com.obric.memorydata.memory.ui.data.a.h $before;
        int label;

        AnonymousClass2(com.obric.memorydata.memory.ui.data.a.h r3, com.obric.memorydata.memory.ui.data.a.h r4, Continuation<? super AnonymousClass2> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$before = r3;
            this.$after = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.$before, this.$after, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super com.obric.memorydata.memory.ui.data.a.j> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super com.obric.memorydata.memory.ui.data.a.j> r4) {
            return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L12;
            ResultKt.throwOnFailure(r3);
            if (this.$before == null) goto L7;
        L9:
            return null;
        L7:
            if (this.$after == null) goto L9;
            return new com.obric.memorydata.memory.ui.data.a.j(at.a(ZeusTransformUtils.mapRes(R.string.memory_relation_content, TypedValues.Custom.S_STRING, "memory_relation_content")));
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.MemoryDetailViewModel$observeDetailStream$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.detail.MemoryDetailViewModel$observeDetailStream$1", f = "MemoryDetailViewModel.kt", i = {}, l = {161}, m = "invokeSuspend", n = {}, s = {})
    static final class C11471 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemoryDetailViewModel this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.MemoryDetailViewModel$observeDetailStream$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/obric/memorydata/memory/ui/detail/MemoryDetailViewModel$DetailStreamUiState;", "e", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.memory.ui.detail.MemoryDetailViewModel$observeDetailStream$1$2", f = "MemoryDetailViewModel.kt", i = {}, l = {159}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.j<? super b>, Throwable, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            /* synthetic */ Object L$1;
            int label;

            AnonymousClass2(Continuation<? super AnonymousClass2> r3) {
                super(3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
            }

            @Override // kotlin.jvm.functions.Function3
            public /* synthetic */ Object invoke(kotlinx.coroutines.flow.j<? super b> r3, Throwable r4, Continuation<? super Unit> r5) {
                return invoke2((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(kotlinx.coroutines.flow.j<? super b> r2, Throwable r3, Continuation<? super Unit> r4) {
                kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                AnonymousClass2 r5 = new AnonymousClass2((Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
                r5.L$0 = r1;
                r5.L$1 = r3;
                return r5.invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r18) {
                Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r2 = this.label;
                if (r2 == 0) goto L8;
                if (r2 != 1) goto L7;
                ResultKt.throwOnFailure(r18);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r18);
                kotlinx.coroutines.flow.j r3 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                Throwable r4 = (Throwable) ZeusTransformUtils.preCheckCast(this.L$1, Throwable.class, "com.obric.memorydata.plugin");
                RunLog.INSTANCE.error(MemoryDetailViewModel.TAG, "observeDetailStream failed", r4);
                b r5 = new b(null, null, null, null, null, 31, null);
                Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
                this.L$0 = null;
                this.label = 1;
                if (r3.emit(r5, r6) != r1) goto L12;
                return r1;
            }
        }

        /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.MemoryDetailViewModel$observeDetailStream$1$a */
        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class a implements kotlinx.coroutines.flow.i<b> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.flow.i f10836a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ar f10837b;
            final /* synthetic */ MemoryEntity c;
            final /* synthetic */ com.obric.memorydata.memory.llm.j d;

            /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.MemoryDetailViewModel$observeDetailStream$1$a$1, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
            public static final class C05511<T> implements kotlinx.coroutines.flow.j {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.flow.j f10838a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ ar f10839b;
                final /* synthetic */ MemoryEntity c;
                final /* synthetic */ com.obric.memorydata.memory.llm.j d;

                public C05511(kotlinx.coroutines.flow.j r3, ar r4, MemoryEntity r5, com.obric.memorydata.memory.llm.j r6) {
                    kotlinx.coroutines.flow.j r7 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                    ar r8 = (ar) ZeusTransformUtils.wrapperContextForParams(r4, ar.class, "com.obric.memorydata.plugin");
                    this.f10838a = r7;
                    this.f10839b = r8;
                    this.c = r5;
                    this.d = r6;
                }

                @Override // kotlinx.coroutines.flow.j
                public final Object emit(Object r12, Continuation r13) {
                    Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
                    if (ZeusTransformUtils.instanceOf(r14, MemoryDetailViewModel$observeDetailStream$1$invokeSuspend$lambda$1$$inlined$map$1$2$1.class) == false) goto L7;
                    MemoryDetailViewModel$observeDetailStream$1$invokeSuspend$lambda$1$$inlined$map$1$2$1 r0 = (MemoryDetailViewModel$observeDetailStream$1$invokeSuspend$lambda$1$$inlined$map$1$2$1) ZeusTransformUtils.preCheckCast(r14, MemoryDetailViewModel$observeDetailStream$1$invokeSuspend$lambda$1$$inlined$map$1$2$1.class, "com.obric.memorydata.plugin");
                    if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
                    r0.label -= Integer.MIN_VALUE;
                L8:
                    Object r15 = r0.result;
                    Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r3 = r0.label;
                    if (r3 == 0) goto L14;
                    if (r3 != 1) goto L13;
                    ResultKt.throwOnFailure(r15);
                L22:
                    return Unit.INSTANCE;
                L13:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L14:
                    ResultKt.throwOnFailure(r15);
                    kotlinx.coroutines.flow.j r16 = this.f10838a;
                    Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
                    SessionStatus r7 = (SessionStatus) ZeusTransformUtils.preCheckCast(r12, SessionStatus.class, "com.obric.memorydata.plugin");
                    String r6 = (String) ZeusTransformUtils.preCheckCast(this.f10839b.c(), String.class, "com.obric.memorydata.plugin");
                    ar r8 = this.f10839b;
                    if (r7 != SessionStatus.COMPLETED) goto L17;
                    Map<String, List<String>> r1 = com.obric.memorydata.memory.llm.k.f10296a.b(this.c);
                L18:
                    b r17 = new b(r6, r7, r8, r1, this.d.b());
                    r0.label = 1;
                    if (r16.emit(r17, r0) != r2) goto L22;
                    return r2;
                L17:
                    r1 = MapsKt.emptyMap();
                L7:
                    r0 = new MemoryDetailViewModel$observeDetailStream$1$invokeSuspend$lambda$1$$inlined$map$1$2$1(this, r14);
                    goto L8
                }
            }

            public a(kotlinx.coroutines.flow.i r3, ar r4, MemoryEntity r5, com.obric.memorydata.memory.llm.j r6) {
                kotlinx.coroutines.flow.i r7 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
                ar r8 = (ar) ZeusTransformUtils.wrapperContextForParams(r4, ar.class, "com.obric.memorydata.plugin");
                this.f10836a = r7;
                this.f10837b = r8;
                this.c = r5;
                this.d = r6;
            }

            @Override // kotlinx.coroutines.flow.i
            public Object collect(kotlinx.coroutines.flow.j<? super b> r6, Continuation r7) {
                kotlinx.coroutines.flow.j r8 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r6, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
                Continuation<? super Unit> r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
                Object r5 = this.f10836a.collect((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C05511(r8, this.f10837b, this.c, this.d), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r9);
                if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
                return r5;
            L6:
                return Unit.INSTANCE;
            }
        }

        C11471(MemoryDetailViewModel r3, Continuation<? super C11471> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11471(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11471) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11471.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            kotlinx.coroutines.flow.i r8 = kotlinx.coroutines.flow.k.b(kotlinx.coroutines.flow.k.c(kotlinx.coroutines.flow.k.b(kotlinx.coroutines.flow.k.c((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(this.this$0.get_memoryEntityStateFlow(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"))), (Function3) ZeusTransformUtils.preCheckCast(new MemoryDetailViewModel$observeDetailStream$1$invokeSuspend$$inlined$flatMapLatest$1(null), Function3.class, "com.obric.memorydata.plugin")), (Function3) ZeusTransformUtils.preCheckCast(new AnonymousClass2(null), Function3.class, "com.obric.memorydata.plugin"));
            final MemoryDetailViewModel r4 = this.this$0;
            kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C05501(r4), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r8.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.MemoryDetailViewModel$observeMemoryCalendarItems$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.detail.MemoryDetailViewModel$observeMemoryCalendarItems$1", f = "MemoryDetailViewModel.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
    static final class C11481 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemoryDetailViewModel this$0;

        C11481(MemoryDetailViewModel r3, Continuation<? super C11481> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11481(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11481) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11481.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r7);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            kotlinx.coroutines.flow.i r8 = kotlinx.coroutines.flow.k.c(kotlinx.coroutines.flow.k.b(kotlinx.coroutines.flow.k.c((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(this.this$0.get_memoryEntityStateFlow(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"))), (Function3) ZeusTransformUtils.preCheckCast(new MemoryDetailViewModel$observeMemoryCalendarItems$1$invokeSuspend$$inlined$flatMapLatest$1(null, this.this$0), Function3.class, "com.obric.memorydata.plugin"));
            final MemoryDetailViewModel r4 = this.this$0;
            kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C05521(r4), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r8.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.detail.MemoryDetailViewModel$observeMemoryKeyInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.detail.MemoryDetailViewModel$observeMemoryKeyInfo$1", f = "MemoryDetailViewModel.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
    static final class C11491 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MemoryDetailViewModel this$0;

        C11491(MemoryDetailViewModel r3, Continuation<? super C11491> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C11491(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((C11491) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C11491.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            kotlinx.coroutines.flow.i r7 = kotlinx.coroutines.flow.k.c(kotlinx.coroutines.flow.k.b(kotlinx.coroutines.flow.k.c((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(this.this$0.get_memoryEntityStateFlow(), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"))), (Function3) ZeusTransformUtils.preCheckCast(new MemoryDetailViewModel$observeMemoryKeyInfo$1$invokeSuspend$$inlined$flatMapLatest$1(null), Function3.class, "com.obric.memorydata.plugin"));
            final MemoryDetailViewModel r4 = this.this$0;
            kotlinx.coroutines.flow.j r2 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new C05531(r4), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (r7.collect(r2, r3) != r0) goto L12;
            return r0;
        }
    }

    static {
        Companion = new a(null);
    }

    public MemoryDetailViewModel() {
        kotlinx.coroutines.flow.ae<com.obric.memorydata.memory.ui.data.a.e> r1 = kotlinx.coroutines.flow.at.a(null);
        this._memoryEntityStateFlow = r1;
        this.memoryEntityStateFlow = kotlinx.coroutines.flow.k.a(r1);
        kotlinx.coroutines.flow.ae<Map<String, List<String>>> r2 = kotlinx.coroutines.flow.at.a(MapsKt.emptyMap());
        this._memoryKeyInfo = r2;
        this.memoryKeyInfo = kotlinx.coroutines.flow.k.a(r2);
        kotlinx.coroutines.flow.ae<List<com.obric.memorydata.memory.ui.data.a.c>> r3 = kotlinx.coroutines.flow.at.a(CollectionsKt.emptyList());
        this._memoryCalendarItemsFlow = r3;
        this.memoryCalendarItemsFlow = kotlinx.coroutines.flow.k.a(r3);
        kotlinx.coroutines.flow.ae<b> r4 = kotlinx.coroutines.flow.at.a(new b(null, null, null, null, null, 31, null));
        this._detailStreamUiState = r4;
        this.detailStreamUiState = kotlinx.coroutines.flow.k.a(r4);
        this.pagingDataFlow = kotlinx.coroutines.flow.k.c(kotlinx.coroutines.flow.k.b(kotlinx.coroutines.flow.k.c((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"))), (Function3) ZeusTransformUtils.preCheckCast(new MemoryDetailViewModel$special$$inlined$flatMapLatest$1(null, this), Function3.class, "com.obric.memorydata.plugin"));
        observeMemoryKeyInfo();
        observeMemoryCalendarItems();
        observeDetailStream();
    }

    public static final /* synthetic */ Object access$generateMemoryItemRelationText(MemoryDetailViewModel r2, com.obric.memorydata.memory.ui.data.a.h r3, com.obric.memorydata.memory.ui.data.a.h r4, Continuation r5) {
        return r2.generateMemoryItemRelationText(r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.i access$getPendingMemoryCalendars(MemoryDetailViewModel r0, String r1) {
        return r0.getPendingMemoryCalendars(r1);
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.i access$getRelationMemoryEntity(MemoryDetailViewModel r0, MemoryEntity r1) {
        return r0.getRelationMemoryEntity(r1);
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.ae access$get_detailStreamUiState$p(MemoryDetailViewModel r0) {
        return r0._detailStreamUiState;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.ae access$get_memoryCalendarItemsFlow$p(MemoryDetailViewModel r0) {
        return r0._memoryCalendarItemsFlow;
    }

    public static final /* synthetic */ kotlinx.coroutines.flow.ae access$get_memoryKeyInfo$p(MemoryDetailViewModel r0) {
        return r0._memoryKeyInfo;
    }

    private final Object generateMemoryItemRelationText(com.obric.memorydata.memory.ui.data.a.h r4, com.obric.memorydata.memory.ui.data.a.h r5, Continuation<? super com.obric.memorydata.memory.ui.data.a.j> r6) {
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        return kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.a(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r4, r5, null), Function2.class, "com.obric.memorydata.plugin"), r3);
    }

    public static /* synthetic */ void getPagingDataFlow$annotations() {
    }

    private final kotlinx.coroutines.flow.i<List<com.obric.memorydata.memory.ui.data.a.c>> getPendingMemoryCalendars(String r2) {
        return (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new c(com.obric.memorydata.memory.memoryentity.d.f10317a.b(r2)), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
    }

    private final kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> getRelationMemoryEntity(MemoryEntity r3) {
        return (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new f((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new e((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new d(com.obric.memorydata.memory.memoryentity.d.f10317a.a(r3.getId())), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), this), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin")), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
    }

    private final void observeDetailStream() {
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11471(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void observeMemoryCalendarItems() {
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11481(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final void observeMemoryKeyInfo() {
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new C11491(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    @Override // com.obric.memorydata.memory.ui.detail.AbsMemoryDetailViewModel
    public void deleteExpiredMemoryCalendarItems() {
    }

    /* JADX INFO: renamed from: deleteMemoryEntity, reason: avoid collision after fix types in other method */
    public void deleteMemoryEntity2(MemoryEntity r9) {
        Intrinsics.checkNotNullParameter(r9, "memoryEntity");
        kotlinx.coroutines.i.a(ViewModelKt.getViewModelScope((ViewModel) ZeusTransformUtils.preCheckCast(this, ViewModel.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r9, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    @Override // com.obric.memorydata.memory.ui.detail.AbsMemoryDetailViewModel
    public /* synthetic */ void deleteMemoryEntity(MemoryEntity r3) {
        deleteMemoryEntity2((MemoryEntity) ZeusTransformUtils.preCheckCast(r3, MemoryEntity.class, "com.obric.memorydata.plugin"));
    }

    public final ar<b> getDetailStreamUiState() {
        return this.detailStreamUiState;
    }

    @Override // com.obric.memorydata.memory.ui.detail.AbsMemoryDetailViewModel
    public ar<List<com.obric.memorydata.memory.ui.data.a.c>> getMemoryCalendarItemsFlow() {
        return this.memoryCalendarItemsFlow;
    }

    @Override // com.obric.memorydata.memory.ui.detail.AbsMemoryDetailViewModel
    public ar<com.obric.memorydata.memory.ui.data.a.e> getMemoryEntityStateFlow() {
        return this.memoryEntityStateFlow;
    }

    @Override // com.obric.memorydata.memory.ui.detail.AbsMemoryDetailViewModel
    public ar<Map<String, List<String>>> getMemoryKeyInfo() {
        return this.memoryKeyInfo;
    }

    @Override // com.obric.memorydata.memory.ui.detail.AbsMemoryDetailViewModel
    public kotlinx.coroutines.flow.i<PagingData<com.obric.memorydata.memory.ui.data.a>> getPagingDataFlow() {
        return this.pagingDataFlow;
    }

    public final kotlinx.coroutines.flow.ae<com.obric.memorydata.memory.ui.data.a.e> get_memoryEntityStateFlow() {
        return this._memoryEntityStateFlow;
    }

    /* JADX INFO: renamed from: init, reason: avoid collision after fix types in other method */
    public void init2(MemoryEntity r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "sourceData");
        Intrinsics.checkNotNullParameter(r13, "enterFrom");
        super.init(r12, r13);
        this._memoryEntityStateFlow.b(new com.obric.memorydata.memory.ui.data.a.e(r12, false, null, null, null, null, null, null, 254, null));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "init memoryEntity.id = " + r12.getId(), false, 4, null);
        if (ZeusTransformUtils.instanceOf(r12, CommonTextMemoryEntity.class) == true) goto L5;
        return;
    L5:
        if (r12.getDetailStatus() != 2) goto L9;
        MemoryEntityManager.executeCorrelationMemoryBuild$default(MemoryEntityManager.INSTANCE, r12.getId(), 1, null, 4, null);
        return;
    }

    @Override // com.obric.memorydata.memory.ui.detail.AbsMemoryDetailViewModel
    public /* synthetic */ void init(MemoryEntity r3, String r4) {
        init2((MemoryEntity) ZeusTransformUtils.preCheckCast(r3, MemoryEntity.class, "com.obric.memorydata.plugin"), r4);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.obric.memorydata.memory.ui.detail.AbsMemoryDetailViewModel
    public MemoryEntity refresh() {
        com.obric.memorydata.memory.ui.data.a.e r0 = (com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(this._memoryEntityStateFlow.c(), com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L15;
        MemoryEntity r1 = r0.b();
        if (r1 == null) goto L15;
        MemoryEntity r3 = com.obric.memorydata.memory.utils.f.f11537a.a(r1.getId(), Integer.valueOf(r1.getType()));
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "refresh memoryEntity.id = " + r1.getId(), false, 4, null);
        if (r3 != null) goto L11;
        return null;
    L11:
        if (r3.getLastModifiedTime() == r1.getLastModifiedTime()) goto L14;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "memoryEntity has change", false, 4, null);
        AbsMemoryDetailViewModel.init$default((AbsMemoryDetailViewModel) ZeusTransformUtils.preCheckCast(this, AbsMemoryDetailViewModel.class, "com.obric.memorydata.plugin"), r3, null, 2, null);
        return r3;
    L14:
        return r1;
    L15:
        return null;
    }

    @Override // com.obric.memorydata.memory.ui.detail.AbsMemoryDetailViewModel
    public /* bridge */ /* synthetic */ MemoryEntity refresh() {
        return refresh();
    }
}
