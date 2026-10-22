package com.obric.memorydata.memory.ui.edit;

import android.os.Parcel;
import androidx.lifecycle.ViewModel;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;
import kotlinx.coroutines.flow.k;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J&\u0010\u0011\u001a\u00020\u000e2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u001e\u0010\u0016\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00132\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001aH\u0086@¢\u0006\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082.¢\u0006\u0002\n\u0000R!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/memory/ui/edit/MemoryEditViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/memory/ui/edit/MemoryEditState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "state$delegate", "Lkotlin/Lazy;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "memoryEntity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "updateEditValue", "item", "Lcom/obric/memorydata/memory/ui/edit/MemoryEditItem;", "", EventBody.KEY_VALUE, "updateEditState", "isValid", "", "saveMemoryEntity", "Lkotlin/Result;", "saveMemoryEntity-CmtIpJM", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryEditViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "MemoryEditViewModel";
    private ae<e> _state;
    private final Lazy state$delegate;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/edit/MemoryEditViewModel$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    public MemoryEditViewModel() {
        this.state$delegate = LazyKt.lazy(new $$Lambda$MemoryEditViewModel$f2oDjBrklR4zXpexexdOIzosrdU(this));
    }

    public static /* synthetic */ ar lambda$f2oDjBrklR4zXpexexdOIzosrdU(MemoryEditViewModel r0) {
        return state_delegate$lambda$0(r0);
    }

    private static final ar state_delegate$lambda$0(MemoryEditViewModel r0) {
        ae<e> r1 = r0._state;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_state");
        r1 = null;
    L6:
        return k.a(r1);
    }

    public final ar<e> getState() {
        return (ar) ZeusTransformUtils.preCheckCast(this.state$delegate.getValue(), ar.class, "com.obric.memorydata.plugin");
    }

    public final void init(MemoryEntity r11) {
        Intrinsics.checkNotNullParameter(r11, "memoryEntity");
        List<b<? extends MemoryEntity, ?>> r3 = i.f10906a.a(r11);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.collections.List<com.obric.memorydata.memory.ui.edit.MemoryEditItem<com.obric.capabilitykit.entity.memory.MemoryEntity, kotlin.Any?>>");
        this._state = at.a(new e(r11, r3, null, null, 0, 28, null));
    }

    /* JADX INFO: renamed from: saveMemoryEntity-CmtIpJM, reason: not valid java name */
    public final Object m855saveMemoryEntityCmtIpJM(Continuation<? super Result<? extends MemoryEntity>> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        ae<e> r4 = this._state;
        if (r4 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("_state");
        r4 = null;
    L6:
        return kotlinx.coroutines.i.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new MemoryEditViewModel$saveMemoryEntity$2$1((e) ZeusTransformUtils.preCheckCast(r4.c(), e.class, "com.obric.memorydata.plugin"), null), Function2.class, "com.obric.memorydata.plugin"), r6);
    }

    public final void updateEditState(b<?, ?> r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r12, "item");
        ae<e> r11 = this._state;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_state");
        r11 = null;
    L5:
        e r0 = r11.c();
        e r2 = (e) ZeusTransformUtils.preCheckCast(r0, e.class, "com.obric.memorydata.plugin");
        Map r6 = MapsKt.toMutableMap(r2.c());
        r6.put(r12.a().getName(), Boolean.valueOf(r13));
        if (r11.a(r0, e.a(r2, null, null, null, r6, 0, 23, null)) == false) goto L5;
    }

    public final void updateEditValue(b<MemoryEntity, Object> r12, Object r13) {
        Intrinsics.checkNotNullParameter(r12, "item");
        ae<e> r11 = this._state;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("_state");
        r11 = null;
    L5:
        e r0 = r11.c();
        e r2 = (e) ZeusTransformUtils.preCheckCast(r0, e.class, "com.obric.memorydata.plugin");
        MemoryEntity r1 = r2.b();
        if (r1 != null) goto L13;
        Parcel r3 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(r3, "obtain(...)");
        r2.a().writeToParcel(r3, 0);     // Catch: Throwable -> L10
        r3.setDataPosition(0);     // Catch: Throwable -> L10
        MemoryEntity r4 = MemoryEntity.CREATOR.createFromParcel(r3);     // Catch: Throwable -> L10
        r3.recycle();
        MemoryEntity r5 = r4;
    L14:
        if (r5 == null) goto L17;
        r12.a(r5, r13);
    L17:
        if (r11.a(r0, e.a(r2, null, null, r5, null, r2.d() + 1, 11, null)) == false) goto L5;
        return;
    L10:
        th = move-exception;
        r3.recycle();
        throw th;
    L13:
        r5 = r1;
        goto L14
    }
}
