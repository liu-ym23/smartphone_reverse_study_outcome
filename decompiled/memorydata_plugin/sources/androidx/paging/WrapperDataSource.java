package androidx.paging;

import androidx.arch.core.util.Function;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0002*\b\b\u0002\u0010\u0004*\u00020\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00040\u0005B9\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u001e\u0010\u0007\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\b¢\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0017\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u0002H\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0011H\u0016J'\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0090@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\"\u0010 \u001a\u00020\u00112\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\t2\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00020\tR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Landroidx/paging/WrapperDataSource;", "Key", "", "ValueFrom", "ValueTo", "Landroidx/paging/DataSource;", AILabCheckPermissionTask.KEY_SOURCE, "listFunction", "Landroidx/arch/core/util/Function;", "", "(Landroidx/paging/DataSource;Landroidx/arch/core/util/Function;)V", "isInvalid", "", "()Z", "keyMap", "Ljava/util/IdentityHashMap;", "addInvalidatedCallback", "", "onInvalidatedCallback", "Landroidx/paging/DataSource$InvalidatedCallback;", "getKeyInternal", "item", "getKeyInternal$paging_common", "(Ljava/lang/Object;)Ljava/lang/Object;", "invalidate", "load", "Landroidx/paging/DataSource$BaseResult;", TrackerImpl.PARAMS, "Landroidx/paging/DataSource$Params;", "load$paging_common", "(Landroidx/paging/DataSource$Params;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeInvalidatedCallback", "stashKeysIfNeeded", "dest", "paging-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class WrapperDataSource<Key, ValueFrom, ValueTo> extends DataSource<Key, ValueTo> {
    private final IdentityHashMap<ValueTo, Key> keyMap;
    private final Function<List<ValueFrom>, List<ValueTo>> listFunction;
    private final DataSource<Key, ValueFrom> source;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[DataSource.KeyType.values().length];
            r0[DataSource.KeyType.ITEM_KEYED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public WrapperDataSource(DataSource<Key, ValueFrom> r3, Function<List<ValueFrom>, List<ValueTo>> r4) {
        Function<List<ValueFrom>, List<ValueTo>> r5 = (Function) ZeusTransformUtils.wrapperContextForParams(r4, Function.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r5, "listFunction");
        super(r3.getType$paging_common());
        this.source = r3;
        this.listFunction = r5;
        DataSource.KeyType r6 = r3.getType$paging_common();
        if (WhenMappings.$EnumSwitchMapping$0[r6.ordinal()] != 1) goto L5;
        IdentityHashMap<ValueTo, Key> r7 = new IdentityHashMap();
    L6:
        this.keyMap = r7;
        return;
    L5:
        r7 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ <Key, ValueFrom, ValueTo> Object load$suspendImpl(WrapperDataSource<Key, ValueFrom, ValueTo> r5, DataSource.Params<Key> r6, Continuation<? super DataSource.BaseResult<ValueTo>> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, WrapperDataSource$load$1.class) == false) goto L7;
        WrapperDataSource$load$1 r0 = (WrapperDataSource$load$1) ZeusTransformUtils.preCheckCast(r8, WrapperDataSource$load$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        boolean r10 = (WrapperDataSource<Key, ValueFrom, ValueTo>) ((WrapperDataSource) ZeusTransformUtils.preCheckCast(r0.L$0, WrapperDataSource.class, "com.obric.memorydata.plugin"));
        ResultKt.throwOnFailure(r9);
        WrapperDataSource r11 = r10;
    L17:
        DataSource.BaseResult r12 = (DataSource.BaseResult) ZeusTransformUtils.preCheckCast(r9, DataSource.BaseResult.class, "com.obric.memorydata.plugin");
        DataSource.BaseResult r13 = DataSource.BaseResult.Companion.convert$paging_common(r12, r11.listFunction);
        r11.stashKeysIfNeeded(r12.data, r13.data);
        return r13;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        DataSource<Key, ValueFrom> r14 = ((WrapperDataSource) r5).source;
        r0.L$0 = r5;
        r0.label = 1;
        r9 = r14.load$paging_common(r6, r0);
        r11 = r5;
        if (r9 != r2) goto L17;
        return r2;
    L7:
        r0 = new WrapperDataSource$load$1(r5, r8);
        goto L8
    }

    @Override // androidx.paging.DataSource
    public void addInvalidatedCallback(DataSource.InvalidatedCallback r3) {
        DataSource.InvalidatedCallback r4 = (DataSource.InvalidatedCallback) ZeusTransformUtils.wrapperContextForParams(r3, DataSource.InvalidatedCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "onInvalidatedCallback");
        this.source.addInvalidatedCallback(r4);
    }

    @Override // androidx.paging.DataSource
    public Key getKeyInternal$paging_common(ValueTo r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        IdentityHashMap<ValueTo, Key> r0 = this.keyMap;
        if (r0 == null) goto L12;
        monitor-enter(r0);
        Key r1 = this.keyMap.get(r2);     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L8
        monitor-exit(r0);
        return r1;
    L8:
        th = move-exception;
        throw th;
    L12:
        throw new IllegalStateException("Cannot get key by item in non-item keyed DataSource");
    }

    @Override // androidx.paging.DataSource
    public void invalidate() {
        this.source.invalidate();
    }

    @Override // androidx.paging.DataSource
    public boolean isInvalid() {
        return this.source.isInvalid();
    }

    @Override // androidx.paging.DataSource
    public Object load$paging_common(DataSource.Params<Key> r3, Continuation<? super DataSource.BaseResult<ValueTo>> r4) {
        return load$suspendImpl(this, r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // androidx.paging.DataSource
    public void removeInvalidatedCallback(DataSource.InvalidatedCallback r3) {
        DataSource.InvalidatedCallback r4 = (DataSource.InvalidatedCallback) ZeusTransformUtils.wrapperContextForParams(r3, DataSource.InvalidatedCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "onInvalidatedCallback");
        this.source.removeInvalidatedCallback(r4);
    }

    public final void stashKeysIfNeeded(List<? extends ValueFrom> r9, List<? extends ValueTo> r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r12, "dest");
        IdentityHashMap<ValueTo, Key> r0 = this.keyMap;
        if (r0 == null) goto L15;
        monitor-enter(r0);
        int r1 = 0;
        int r2 = r12.size();     // Catch: Throwable -> L12
    L7:
        if (r1 >= r2) goto L9;
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(this.keyMap, Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        Object r4 = r12.get(r1);     // Catch: Throwable -> L12
        DataSource<Key, ValueFrom> r5 = this.source;     // Catch: Throwable -> L12
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type androidx.paging.ItemKeyedDataSource<Key of androidx.paging.WrapperDataSource.stashKeysIfNeeded$lambda$1, ValueFrom of androidx.paging.WrapperDataSource.stashKeysIfNeeded$lambda$1>");     // Catch: Throwable -> L12
        r3.put(r4, ((ItemKeyedDataSource) ZeusTransformUtils.preCheckCast(r5, ItemKeyedDataSource.class, "com.obric.memorydata.plugin")).getKey(r11.get(r1)));     // Catch: Throwable -> L12
        r1 = r1 + 1;     // Catch: Throwable -> L12
        goto L7
    L9:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(r0);
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
