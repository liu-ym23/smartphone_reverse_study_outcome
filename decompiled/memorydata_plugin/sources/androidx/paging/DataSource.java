package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\b&\u0018\u0000 .*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002:\u0006-./012B\u000f\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rH\u0017J\u0017\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00028\u0001H ¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u0018H\u0017J'\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00010 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\"H @ø\u0001\u0000¢\u0006\u0004\b#\u0010$J2\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H&0\u0000\"\b\b\u0002\u0010&*\u00020\u00022\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002H&0(H\u0016J2\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H&0\u0000\"\b\b\u0002\u0010&*\u00020\u00022\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u0002H&0)H\u0016J>\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H&0\u0000\"\b\b\u0002\u0010&*\u00020\u00022\u001e\u0010'\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010+\u0012\n\u0012\b\u0012\u0004\u0012\u0002H&0+0(H\u0016J>\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H&0\u0000\"\b\b\u0002\u0010&*\u00020\u00022\u001e\u0010'\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010+\u0012\n\u0012\b\u0012\u0004\u0012\u0002H&0+0)H\u0016J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rH\u0017R\u0014\u0010\u0007\u001a\u00020\b8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0090D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u000fX\u0090D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u00063"}, d2 = {"Landroidx/paging/DataSource;", "Key", "", "Value", "type", "Landroidx/paging/DataSource$KeyType;", "(Landroidx/paging/DataSource$KeyType;)V", "invalidateCallbackCount", "", "getInvalidateCallbackCount$paging_common", "()I", "invalidateCallbackTracker", "Landroidx/paging/InvalidateCallbackTracker;", "Landroidx/paging/DataSource$InvalidatedCallback;", "isContiguous", "", "isContiguous$paging_common", "()Z", "isInvalid", "supportsPageDropping", "getSupportsPageDropping$paging_common", "getType$paging_common", "()Landroidx/paging/DataSource$KeyType;", "addInvalidatedCallback", "", "onInvalidatedCallback", "getKeyInternal", "item", "getKeyInternal$paging_common", "(Ljava/lang/Object;)Ljava/lang/Object;", "invalidate", "load", "Landroidx/paging/DataSource$BaseResult;", TrackerImpl.PARAMS, "Landroidx/paging/DataSource$Params;", "load$paging_common", "(Landroidx/paging/DataSource$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "map", "ToValue", "function", "Lkotlin/Function1;", "Landroidx/arch/core/util/Function;", "mapByPage", "", "removeInvalidatedCallback", "BaseResult", "Companion", "Factory", "InvalidatedCallback", "KeyType", "Params", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class DataSource<Key, Value> {
    public static final Companion Companion = null;
    private final InvalidateCallbackTracker<InvalidatedCallback> invalidateCallbackTracker;
    private final boolean isContiguous;
    private final boolean supportsPageDropping;
    private final KeyType type;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u0018*\b\b\u0002\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001\u0018B=\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bH\u0000¢\u0006\u0002\b\u0017R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0019"}, d2 = {"Landroidx/paging/DataSource$BaseResult;", "Value", "", "data", "", "prevKey", "nextKey", "itemsBefore", "", "itemsAfter", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;II)V", "getItemsAfter", "()I", "getItemsBefore", "getNextKey", "()Ljava/lang/Object;", "getPrevKey", "equals", "", "other", "validateForInitialTiling", "", "pageSize", "validateForInitialTiling$paging_common", "Companion", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class BaseResult<Value> {
        public static final Companion Companion = null;
        public final List<Value> data;
        private final int itemsAfter;
        private final int itemsBefore;
        private final Object nextKey;
        private final Object prevKey;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JU\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\b\b\u0003\u0010\u0006*\u00020\u0001\"\b\b\u0004\u0010\u0005*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\u001e\u0010\b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\n0\tH\u0000¢\u0006\u0002\b\u000bJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\r0\u0004\"\b\b\u0003\u0010\r*\u00020\u0001H\u0000¢\u0006\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Landroidx/paging/DataSource$BaseResult$Companion;", "", "()V", "convert", "Landroidx/paging/DataSource$BaseResult;", "Value", "ToValue", "result", "function", "Landroidx/arch/core/util/Function;", "", "convert$paging_common", "empty", ExifInterface.GPS_DIRECTION_TRUE, "empty$paging_common", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            public final <ToValue, Value> BaseResult<Value> convert$paging_common(BaseResult<ToValue> r7, Function<List<ToValue>, List<Value>> r8) {
                Function r6 = (Function) ZeusTransformUtils.wrapperContextForParams(r8, Function.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r7, "result");
                Intrinsics.checkNotNullParameter(r6, "function");
                return new BaseResult(DataSource.Companion.convert$paging_common(r6, r7.data), r7.getPrevKey(), r7.getNextKey(), r7.getItemsBefore(), r7.getItemsAfter());
            }

            public final <T> BaseResult<T> empty$paging_common() {
                return new BaseResult(CollectionsKt.emptyList(), null, null, 0, 0);
            }
        }

        static {
            Companion = new Companion(null);
        }

        public BaseResult(List<? extends Value> r3, Object r4, Object r5, int r6, int r7) {
            List<Value> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r8, "data");
            this.data = r8;
            this.prevKey = r4;
            this.nextKey = r5;
            this.itemsBefore = r6;
            this.itemsAfter = r7;
            if (r6 >= 0) goto L9;
            if (r6 == Integer.MIN_VALUE) goto L9;
            throw new IllegalArgumentException("Position must be non-negative");
        L9:
            if (r8.isEmpty() == false) goto L15;
            if (r6 > 0) goto L14;
            if (r7 <= 0) goto L15;
        L14:
            throw new IllegalArgumentException("Initial result cannot be empty if items are present in data set.");
        L15:
            if (r7 >= 0) goto L20;
            if (r7 != Integer.MIN_VALUE) goto L19;
            return;
        L19:
            throw new IllegalArgumentException("List size + position too large, last item in list beyond totalCount.");
        }

        public /* synthetic */ BaseResult(List r7, Object r8, Object r9, int r10, int r11, int r12, DefaultConstructorMarker r13) {
            List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
            if ((r12 & 8) == 0) goto L5;
            int r4 = Integer.MIN_VALUE;
        L7:
            if ((r12 & 16) == 0) goto L9;
            int r5 = Integer.MIN_VALUE;
        L10:
            this(r1, r8, r9, r4, r5);
            return;
        L9:
            r5 = r11;
            goto L10
        L5:
            r4 = r10;
            goto L7
        }

        public boolean equals(Object r6) {
            if (ZeusTransformUtils.instanceOf(r6, BaseResult.class) == true) goto L5;
            return false;
        L5:
            if (Intrinsics.areEqual(this.data, ((BaseResult) ZeusTransformUtils.preCheckCast(r6, BaseResult.class, "com.obric.memorydata.plugin")).data) == true) goto L7;
            return false;
        L7:
            if (Intrinsics.areEqual(this.prevKey, ((BaseResult) ZeusTransformUtils.preCheckCast(r6, BaseResult.class, "com.obric.memorydata.plugin")).prevKey) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.nextKey, ((BaseResult) ZeusTransformUtils.preCheckCast(r6, BaseResult.class, "com.obric.memorydata.plugin")).nextKey) == true) goto L11;
            return false;
        L11:
            if (this.itemsBefore == ((BaseResult) ZeusTransformUtils.preCheckCast(r6, BaseResult.class, "com.obric.memorydata.plugin")).itemsBefore) goto L13;
            return false;
        L13:
            if (this.itemsAfter != ((BaseResult) ZeusTransformUtils.preCheckCast(r6, BaseResult.class, "com.obric.memorydata.plugin")).itemsAfter) goto L21;
            return true;
        L21:
            return false;
        }

        public final int getItemsAfter() {
            return this.itemsAfter;
        }

        public final int getItemsBefore() {
            return this.itemsBefore;
        }

        public final Object getNextKey() {
            return this.nextKey;
        }

        public final Object getPrevKey() {
            return this.prevKey;
        }

        public final void validateForInitialTiling$paging_common(int r5) {
            if (this.itemsBefore == Integer.MIN_VALUE) goto L18;
            int r0 = this.itemsAfter;
            if (r0 == Integer.MIN_VALUE) goto L18;
            if (r0 <= 0) goto L13;
            if ((this.data.size() % r5) == 0) goto L13;
            throw new IllegalArgumentException("PositionalDataSource requires initial load size to be a multiple of page size to support internal tiling. loadSize " + this.data.size() + ", position " + this.itemsBefore + ", totalCount " + ((this.itemsBefore + this.data.size()) + this.itemsAfter) + ", pageSize " + r5);
        L13:
            if ((this.itemsBefore % r5) != 0) goto L16;
            return;
        L16:
            throw new IllegalArgumentException("Initial load must be pageSize aligned.Position = " + this.itemsBefore + ", pageSize = " + r5);
        L18:
            throw new IllegalStateException("Placeholders requested, but totalCount not provided. Please call the three-parameter onResult method, or disable placeholders in the PagedList.Config");
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JM\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0002\u0010\u0006\"\u0004\b\u0003\u0010\u00052\u001e\u0010\u0007\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00040\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0004H\u0000¢\u0006\u0002\b\n¨\u0006\u000b"}, d2 = {"Landroidx/paging/DataSource$Companion;", "", "()V", "convert", "", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "function", "Landroidx/arch/core/util/Function;", AILabCheckPermissionTask.KEY_SOURCE, "convert$paging_common", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final <A, B> List<B> convert$paging_common(Function<List<A>, List<B>> r3, List<? extends A> r4) {
            Function r2 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r2, "function");
            Intrinsics.checkNotNullParameter(r5, AILabCheckPermissionTask.KEY_SOURCE);
            List<B> r6 = (List) ZeusTransformUtils.preCheckCast(r2.apply(r5), List.class, "com.obric.memorydata.plugin");
            if (r6.size() != r5.size()) goto L7;
            Intrinsics.checkNotNullExpressionValue(r6, "dest");
            return r6;
        L7:
            throw new IllegalStateException("Invalid Function " + r2 + " changed return size. This is not supported.");
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b&\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u0002*\b\b\u0003\u0010\u0003*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0007J\u0014\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u000bH&J2\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u0002H\r0\u0000\"\b\b\u0004\u0010\r*\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u0002H\r0\u000fH\u0016J2\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u0002H\r0\u0000\"\b\b\u0004\u0010\r*\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u0002H\r0\u0010H\u0016J>\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u0002H\r0\u0000\"\b\b\u0004\u0010\r*\u00020\u00022\u001e\u0010\u000e\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u00120\u000fH\u0016J>\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u0002H\r0\u0000\"\b\b\u0004\u0010\r*\u00020\u00022\u001e\u0010\u000e\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\r0\u00120\u0010H\u0016¨\u0006\u0013"}, d2 = {"Landroidx/paging/DataSource$Factory;", "Key", "", "Value", "()V", "asPagingSourceFactory", "Lkotlin/Function0;", "Landroidx/paging/PagingSource;", "fetchDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "create", "Landroidx/paging/DataSource;", "map", "ToValue", "function", "Lkotlin/Function1;", "Landroidx/arch/core/util/Function;", "mapByPage", "", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class Factory<Key, Value> {
        public Factory() {
        }

        public static /* synthetic */ Function0 asPagingSourceFactory$default(Factory r0, ah r1, int r2, Object r3) {
            if (r3 != null) goto L9;
            if ((r2 & 1) == 0) goto L7;
            r1 = ba.c();
        L7:
            return r0.asPagingSourceFactory(r1);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: asPagingSourceFactory");
        }

        public static /* synthetic */ List lambda$cqAY6ZoY8godHxN9xA2tFl0T1Iw(Function1 r0, List r1) {
            return mapByPage$lambda$3(r0, r1);
        }

        public static /* synthetic */ List lambda$j_NsCDZ8fEX7Jtp9lkcGXEzNOxY(Function r0, List r1) {
            return map$lambda$1(r0, r1);
        }

        /* JADX INFO: renamed from: lambda$qS_0HiGw8pGRq8VKSPFzZMyq-q8, reason: not valid java name */
        public static /* synthetic */ List m51lambda$qS_0HiGw8pGRq8VKSPFzZMyqq8(Function1 r0, List r1) {
            return map$lambda$2(r0, r1);
        }

        private static final List map$lambda$1(Function r3, List r4) {
            Function r5 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "$function");
            Intrinsics.checkNotNullExpressionValue(r6, Constants.KEY_LIST);
            Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r8 = r7.iterator();
        L4:
            if (r8.hasNext() == false) goto L7;
            r0.add(r5.apply(r8.next()));
            goto L4
        L7:
            return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
        }

        private static final List map$lambda$2(Function1 r3, List r4) {
            Function1 r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "$function");
            Intrinsics.checkNotNullExpressionValue(r6, Constants.KEY_LIST);
            Iterable r7 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10)), Collection.class, "com.obric.memorydata.plugin");
            Iterator r8 = r7.iterator();
        L4:
            if (r8.hasNext() == false) goto L7;
            r0.add(r5.invoke(r8.next()));
            goto L4
        L7:
            return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.memorydata.plugin");
        }

        private static final List mapByPage$lambda$3(Function1 r2, List r3) {
            Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "$function");
            Intrinsics.checkNotNullExpressionValue(r5, "it");
            return (List) ZeusTransformUtils.preCheckCast(r4.invoke(r5), List.class, "com.obric.memorydata.plugin");
        }

        public final Function0<PagingSource<Key, Value>> asPagingSourceFactory() {
            return asPagingSourceFactory$default(this, null, 1, null);
        }

        public final Function0<PagingSource<Key, Value>> asPagingSourceFactory(final ah r4) {
            Intrinsics.checkNotNullParameter(r4, "fetchDispatcher");
            return (Function0) ZeusTransformUtils.preCheckCast(new SuspendingPagingSourceFactory(r4, (Function0) ZeusTransformUtils.preCheckCast(new DataSource$Factory$asPagingSourceFactory$1(r4, this), Function0.class, "com.obric.memorydata.plugin")), Function0.class, "com.obric.memorydata.plugin");
        }

        public abstract DataSource<Key, Value> create();

        public <ToValue> Factory<Key, ToValue> map(Function<Value, ToValue> r3) {
            final Function r4 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "function");
            return mapByPage(new $$Lambda$DataSource$Factory$j_NsCDZ8fEX7Jtp9lkcGXEzNOxY(r4));
        }

        public /* synthetic */ Factory map(Function1 r3) {
            final Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "function");
            return mapByPage(new $$Lambda$DataSource$Factory$qS_0HiGw8pGRq8VKSPFzZMyqq8(r4));
        }

        public <ToValue> Factory<Key, ToValue> mapByPage(Function<List<Value>, List<ToValue>> r3) {
            final Function r4 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "function");
            return (Factory) ZeusTransformUtils.preCheckCast(new DataSource$Factory$mapByPage$1(this, r4), Factory.class, "com.obric.memorydata.plugin");
        }

        public /* synthetic */ Factory mapByPage(Function1 r3) {
            final Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "function");
            return mapByPage(new $$Lambda$DataSource$Factory$cqAY6ZoY8godHxN9xA2tFl0T1Iw(r4));
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0001"}, d2 = {"Landroidx/paging/DataSource$InvalidatedCallback;", "", "onInvalidated", "", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface InvalidatedCallback {
        void onInvalidated();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/paging/DataSource$KeyType;", "", "(Ljava/lang/String;I)V", "POSITIONAL", "PAGE_KEYED", "ITEM_KEYED", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final enum KeyType extends Enum<KeyType> {
        private static final /* synthetic */ KeyType[] $VALUES = null;
        public static final KeyType ITEM_KEYED = null;
        public static final KeyType PAGE_KEYED = null;
        public static final KeyType POSITIONAL = null;

        private static final /* synthetic */ KeyType[] $values() {
            return new KeyType[]{POSITIONAL, PAGE_KEYED, ITEM_KEYED};
        }

        static {
            POSITIONAL = new KeyType("POSITIONAL", 0);
            PAGE_KEYED = new KeyType("PAGE_KEYED", 1);
            ITEM_KEYED = new KeyType("ITEM_KEYED", 2);
            $VALUES = $values();
        }

        private KeyType(String r1, int r2) {
            super(r1, r2);
        }

        public static KeyType valueOf(String r2) {
            return (KeyType) ZeusTransformUtils.preCheckCast(Enum.valueOf(KeyType.class, r2), KeyType.class, "com.obric.memorydata.plugin");
        }

        public static KeyType[] values() {
            return (KeyType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), KeyType[].class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0000\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u00022\u00020\u0002B1\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00018\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00018\u0002¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/paging/DataSource$Params;", "K", "", "type", "Landroidx/paging/LoadType;", "key", "initialLoadSize", "", "placeholdersEnabled", "", "pageSize", "(Landroidx/paging/LoadType;Ljava/lang/Object;IZI)V", "getInitialLoadSize", "()I", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getPageSize", "getPlaceholdersEnabled", "()Z", "getType$paging_common", "()Landroidx/paging/LoadType;", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Params<K> {
        private final int initialLoadSize;
        private final K key;
        private final int pageSize;
        private final boolean placeholdersEnabled;
        private final LoadType type;

        public Params(LoadType r2, K r3, int r4, boolean r5, int r6) {
            Intrinsics.checkNotNullParameter(r2, "type");
            this.type = r2;
            this.key = r3;
            this.initialLoadSize = r4;
            this.placeholdersEnabled = r5;
            this.pageSize = r6;
            if (r2 == LoadType.REFRESH) goto L8;
            if (r3 == null) goto L7;
            return;
        L7:
            throw new IllegalArgumentException("Key must be non-null for prepend/append");
        }

        public final int getInitialLoadSize() {
            return this.initialLoadSize;
        }

        public final K getKey() {
            return this.key;
        }

        public final int getPageSize() {
            return this.pageSize;
        }

        public final boolean getPlaceholdersEnabled() {
            return this.placeholdersEnabled;
        }

        public final LoadType getType$paging_common() {
            return this.type;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public DataSource(KeyType r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        this.type = r5;
        this.invalidateCallbackTracker = new InvalidateCallbackTracker((Function1) ZeusTransformUtils.preCheckCast(DataSource$invalidateCallbackTracker$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new DataSource$invalidateCallbackTracker$2(this), Function0.class, "com.obric.memorydata.plugin"));
        this.isContiguous = true;
        this.supportsPageDropping = true;
    }

    public static /* synthetic */ Object lambda$F_nyr5F9NYjoe4cnBdSc8h0T0ec(Function1 r0, Object r1) {
        return map$lambda$1(r0, r1);
    }

    public static /* synthetic */ List lambda$Rw0P0KbWqzx1TSmxwfXkJDgb5_I(Function1 r0, List r1) {
        return mapByPage$lambda$0(r0, r1);
    }

    private static final Object map$lambda$1(Function1 r2, Object r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "$function");
        Intrinsics.checkNotNullExpressionValue(r3, "it");
        return r4.invoke(r3);
    }

    private static final List mapByPage$lambda$0(Function1 r2, List r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "$function");
        Intrinsics.checkNotNullExpressionValue(r5, "it");
        return (List) ZeusTransformUtils.preCheckCast(r4.invoke(r5), List.class, "com.obric.memorydata.plugin");
    }

    public void addInvalidatedCallback(InvalidatedCallback r3) {
        InvalidatedCallback r4 = (InvalidatedCallback) ZeusTransformUtils.wrapperContextForParams(r3, InvalidatedCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "onInvalidatedCallback");
        this.invalidateCallbackTracker.registerInvalidatedCallback$paging_common(r4);
    }

    public final int getInvalidateCallbackCount$paging_common() {
        return this.invalidateCallbackTracker.callbackCount$paging_common();
    }

    public abstract Key getKeyInternal$paging_common(Value r1);

    public boolean getSupportsPageDropping$paging_common() {
        return this.supportsPageDropping;
    }

    public final KeyType getType$paging_common() {
        return this.type;
    }

    public void invalidate() {
        this.invalidateCallbackTracker.invalidate$paging_common();
    }

    public boolean isContiguous$paging_common() {
        return this.isContiguous;
    }

    public boolean isInvalid() {
        return this.invalidateCallbackTracker.getInvalid$paging_common();
    }

    public abstract Object load$paging_common(Params<Key> r1, Continuation<? super BaseResult<Value>> r2);

    public <ToValue> DataSource<Key, ToValue> map(Function<Value, ToValue> r3) {
        final Function r4 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "function");
        return mapByPage((Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4), Function1.class, "com.obric.memorydata.plugin"));
    }

    public /* synthetic */ DataSource map(Function1 r3) {
        final Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "function");
        return map(new $$Lambda$DataSource$F_nyr5F9NYjoe4cnBdSc8h0T0ec(r4));
    }

    public <ToValue> DataSource<Key, ToValue> mapByPage(Function<List<Value>, List<ToValue>> r3) {
        Function r4 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "function");
        return (DataSource) ZeusTransformUtils.preCheckCast(new WrapperDataSource(this, r4), DataSource.class, "com.obric.memorydata.plugin");
    }

    public /* synthetic */ DataSource mapByPage(Function1 r3) {
        final Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r3, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "function");
        return mapByPage(new $$Lambda$DataSource$Rw0P0KbWqzx1TSmxwfXkJDgb5_I(r4));
    }

    public void removeInvalidatedCallback(InvalidatedCallback r3) {
        InvalidatedCallback r4 = (InvalidatedCallback) ZeusTransformUtils.wrapperContextForParams(r3, InvalidatedCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "onInvalidatedCallback");
        this.invalidateCallbackTracker.unregisterInvalidatedCallback$paging_common(r4);
    }
}
