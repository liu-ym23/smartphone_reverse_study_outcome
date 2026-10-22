package com.larus.dora.impl.dynamic;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.DoraDeviceFoundListFragment$setupAdapterWithDynamicDsl$1", f = "DoraDeviceFoundListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraDeviceFoundListFragment$setupAdapterWithDynamicDsl$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraDeviceFoundListFragment this$0;

    public static final class a implements com.larus.dora.impl.dynamic.loader.d.b {
        public final /* synthetic */ DoraDeviceFoundListFragment a;

        @Override // com.larus.dora.impl.dynamic.loader.d.b
        public final void a() {
            g49.d.d("DoraDeviceFoundListFragment", "dataLoader fetchData onInvalid: empty data");
        }

        public a(DoraDeviceFoundListFragment r1) {
            this.a = r1;
        }

        @Override // com.larus.dora.impl.dynamic.loader.d.b
        public final void b(c59.z r4) {
            Intrinsics.checkNotNullParameter(r4, "pageNode");
            c59.l r5 = c59.a0.a(r4);
            DoraDeviceFoundListFragment.W90(this.a, r5);
            DoraDeviceFoundListFragment.X90(this.a, r5, MapsKt.emptyMap(), false);
        }

        @Override // com.larus.dora.impl.dynamic.loader.d.b
        public final void onFail(String r3) {
            g49.d.d("DoraDeviceFoundListFragment", "dataLoader fetchData onFail: " + r3);
        }
    }

    public DoraDeviceFoundListFragment$setupAdapterWithDynamicDsl$1(DoraDeviceFoundListFragment r1, Continuation<? super DoraDeviceFoundListFragment$setupAdapterWithDynamicDsl$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraDeviceFoundListFragment$setupAdapterWithDynamicDsl$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r9);
        DoraDevice r10 = DoraAdapterExtKt.h(kj4.a.g());
        DoraDeviceFoundListFragment r0 = this.this$0;
        com.larus.dora.impl.dynamic.loader.d r1 = r0.h;
        if (r1 == null) goto L16;
        LifecycleCoroutineScope r2 = LifecycleOwnerKt.getLifecycleScope(r0);
        if (r10 == null) goto L9;
        int r3 = r10.vendorId;
    L10:
        Integer r4 = Boxing.boxInt(r3);
        Integer r5 = Boxing.boxInt(ProductNameType.DORA_LITE.id);
        if (r10 == null) goto L13;
        String r11 = r10.model;
    L14:
        String r6 = r11;
        DoraDeviceFoundListFragment r12 = this.this$0;
        com.larus.dora.impl.dynamic.loader.d.b(r1, r2, r4, r5, r6, r12.j, new a(r12));
        goto L16
    L13:
        r11 = null;
        goto L14
    L9:
        r3 = 1;
    L16:
        return Unit.INSTANCE;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
