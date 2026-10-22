package com.larus.dora.impl.dynamic;

import android.content.Context;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.larus.avlink.api.AlbumServiceDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.DoraEnableScope;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.DoraSimpleDevice;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.dynamic.loader.DslLocalCache;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.dora.impl.resource.DoraResourceDeviceType;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.DoraDeviceFoundListFragment$setupAdapterWithLocalDsl$1", f = "DoraDeviceFoundListFragment.kt", i = {0, 0, 1, 1, 1, 1}, l = {152, 167}, m = "invokeSuspend", n = {"currentDevice", "hasContent", "currentDevice", "hasContent", "hasDiaryData", "hasQuickNoteData"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0", "I$1"})
final class DoraDeviceFoundListFragment$setupAdapterWithLocalDsl$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DoraDeviceFoundListFragment this$0;

    public DoraDeviceFoundListFragment$setupAdapterWithLocalDsl$1(DoraDeviceFoundListFragment r1, Continuation<? super DoraDeviceFoundListFragment$setupAdapterWithLocalDsl$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraDeviceFoundListFragment$setupAdapterWithLocalDsl$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        DoraResourceDeviceType r4 = null;
        boolean r5 = false;
        int r6 = 1;
        if (r1 == 0) goto L18;
        if (r1 == 1) goto L13;
        if (r1 != 2) goto L12;
        int r2 = this.I$1;
        int r3 = this.I$0;
        Ref.BooleanRef r7 = (Ref.BooleanRef) this.L$1;
        DoraDevice r8 = (DoraDevice) this.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L9
    L123:
        boolean r14 = ((Boolean) r13).booleanValue();     // Catch: Exception -> L9
        Ref.BooleanRef r9 = r7;
    L129:
        if (r3 != 0) goto L132;
        if (r2 != 0) goto L132;
        if (r14 == true) goto L132;
    L133:
        r9.element = r5;
        DoraDevice r10 = r8;
    L134:
        if (r10 == null) goto L136;
        r6 = r10.vendorId;
    L136:
        if (r10 == null) goto L138;
        int r15 = r10.productId;
    L139:
        DoraDeviceFoundListFragment r11 = this.this$0;
        if (r11.i == null) goto L181;
        Context r12 = r11.getContext();
        if (r12 != null) goto L144;
        r12 = AppHost.a.getApplication();
    L144:
        Integer r16 = Boxing.boxInt(r6);
        Integer r17 = Boxing.boxInt(r15);
        String r18 = this.this$0.j;
        if (r10 == null) goto L147;
        Integer r20 = Boxing.boxInt(r10.productId);
    L148:
        int r21 = ProductNameType.DORA_G.id;
        if (r20 != null) goto L152;
    L154:
        int r22 = ProductNameType.DORA_G2.id;
        if (r20 != null) goto L158;
    L159:
        int r23 = ProductNameType.DORA_G_AIR.id;
        if (r20 != null) goto L163;
    L164:
        int r24 = ProductNameType.DORA_G_PIN.id;
        if (r20 != null) goto L168;
    L170:
        IDoraService r25 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r25 != null) goto L174;
    L180:
        r4 = DslLocalCache.a(r12, r16, r17, r18, r4);
        goto L181
    L174:
        if (r25.T0(DoraEnableScope.G1) == false) goto L177;
        r4 = DoraResourceDeviceType.G1;
        goto L180
    L177:
        if (r25.T0(DoraEnableScope.G2) == false) goto L180;
        r4 = DoraResourceDeviceType.G2;
        goto L180
    L168:
        if (r20.intValue() != r24) goto L170;
    L179:
        r4 = DoraResourceDeviceType.G2;
        goto L180
    L163:
        if (r20.intValue() == r23) goto L179;
    L158:
        if (r20.intValue() == r22) goto L179;
    L152:
        if (r20.intValue() != r21) goto L154;
        r4 = DoraResourceDeviceType.G1;
        goto L180
    L147:
        r20 = null;
    L181:
        if (r4 == null) goto L184;
        c59.l r110 = c59.a0.a(r4);
        DoraDeviceFoundListFragment r26 = this.this$0;
        DoraDeviceFoundListFragment.W90(r26, r110);
        DoraDeviceFoundListFragment.X90(r26, r110, MapsKt.emptyMap(), r9.element);
    L184:
        return Unit.INSTANCE;
    L138:
        r15 = ProductNameType.DORA_LITE.id;
    L132:
        r5 = true;
    L9:
        Exception e = e;
        r9 = r7;
        DoraDevice r111 = r8;
        int r27 = r3;
        r10 = r111;
    L128:
        g49.d.c("DoraDeviceFoundListFragment", "get gallery media count exception", e);
        r14 = false;
        int r112 = r27;
        r8 = r10;
        r3 = r112;
        goto L129
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        Ref.BooleanRef r28 = (Ref.BooleanRef) this.L$1;
        DoraDevice r30 = (DoraDevice) this.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L16
        Object r113 = ((Result) r13).unbox-impl();     // Catch: Exception -> L16
    L61:
        Result r114 = Result.box-impl(r113);     // Catch: Exception -> L16
        r9 = r28;
        r10 = r30;
    L66:
        if (r114 == null) goto L134;
        if (Result.isSuccess-impl(r114.unbox-impl()) == false) goto L134;
        Object r115 = r114.unbox-impl();
        if (Result.isFailure-impl(r115) == false) goto L72;
        r115 = null;
    L72:
        a49.h r116 = (a49.h) r115;
        if (r116 == null) goto L95;
        a49.a r31 = r116.a();
        if (r31 == null) goto L95;
        a49.e r32 = r31.a();
        if (r32 == null) goto L95;
        String r33 = r32.g();
        if (r33 != null) goto L81;
    L84:
        boolean r34 = true;
    L85:
        if (r34 == false) goto L94;
        String r35 = r32.b();
        if (r35 != null) goto L89;
    L92:
        boolean r36 = true;
    L93:
        if (r36 == true) goto L95;
    L89:
        if (r35.length() == 0) goto L92;
        r36 = false;
    L94:
        r27 = 1;
    L96:
        if (r116 == null) goto L118;
        a49.a r117 = r116.a();
        if (r117 == null) goto L118;
        a49.i r118 = r117.b();
        if (r118 == null) goto L118;
        String r37 = r118.b();
        if (r37 != null) goto L104;
    L107:
        boolean r38 = true;
    L108:
        if (r38 == false) goto L117;
        String r119 = r118.a();
        if (r119 != null) goto L112;
    L115:
        boolean r120 = true;
    L116:
        if (r120 == true) goto L118;
    L112:
        if (r119.length() == 0) goto L115;
        r120 = false;
    L117:
        int r121 = 1;
    L187:
        AlbumServiceDelegate r40 = AlbumServiceDelegate.b;     // Catch: Exception -> L126
        this.L$0 = r10;     // Catch: Exception -> L126
        this.L$1 = r9;     // Catch: Exception -> L126
        this.I$0 = r27;     // Catch: Exception -> L126
        this.I$1 = r121;     // Catch: Exception -> L126
        this.label = 2;     // Catch: Exception -> L126
        Object r41 = r40.d(this);     // Catch: Exception -> L126
        if (r41 != r0) goto L122;
        return r0;
    L122:
        r2 = r121;
        r13 = r41;
        r7 = r9;
        int r122 = r27;
        r8 = r10;
        r3 = r122;
    L126:
        e = move-exception;
        r2 = r121;
        e = e;
        goto L128
    L104:
        if (r37.length() == 0) goto L107;
        r38 = false;
    L118:
        r121 = 0;
        goto L187
    L81:
        if (r33.length() == 0) goto L84;
        r34 = false;
    L95:
        r27 = 0;
    L16:
        e = e;
        r9 = r28;
        r10 = r30;
    L65:
        g49.d.c("DoraDeviceFoundListFragment", "fetchLatestCardContent exception", e);
        r114 = null;
        goto L66
    L18:
        ResultKt.throwOnFailure(r13);
        boolean r123 = DoraAdapterExtKt.k(kj4.a.g()).isEmpty();
        r10 = DoraAdapterExtKt.h(kj4.a.g());
        com.larus.dora.impl.util.b0.a.getClass();
        DoraSimpleDevice r42 = com.larus.dora.impl.util.b0.k();
        r9 = new Ref.BooleanRef();
        if (r123 == false) goto L134;
        if (r10 == null) goto L24;
        String r124 = o59.a.A(r10.getSerialNumber(), r10.mac, Boxing.boxInt(r10.productId));
        if (r124 == null) goto L27;
    L29:
        if (r10 == null) goto L31;
        String r43 = String.valueOf(r10.productId);
    L55:
        if (r124 == null) goto L134;
        List<String> r44 = CollectionsKt.listOf(new String[]{"diary", "quick_note"});
        DoraNetworkApi r125 = DoraNetworkApi.a;     // Catch: Exception -> L64
        this.L$0 = r10;     // Catch: Exception -> L64
        this.L$1 = r9;     // Catch: Exception -> L64
        this.label = 1;     // Catch: Exception -> L64
        r113 = r125.k(r124, r43, r44, this);     // Catch: Exception -> L64
        if (r113 != r0) goto L60;
        return r0;
    L60:
        r30 = r10;
        r28 = r9;
    L64:
        e = e;
        goto L65
    L31:
        if (r42 == null) goto L33;
        Integer r45 = Boxing.boxInt(r42.getType());
    L34:
        if (r45 != null) goto L37;
    L39:
        if (r45 != null) goto L42;
    L44:
        if (r45 != null) goto L47;
    L49:
        if (r45 != null) goto L52;
    L54:
        r43 = String.valueOf(ProductNameType.DORA_LITE.id);
        goto L55
    L52:
        if (r45.intValue() != 19) goto L54;
        r43 = String.valueOf(ProductNameType.DORA_G_PIN.id);
        goto L55
    L47:
        if (r45.intValue() != 18) goto L49;
        r43 = String.valueOf(ProductNameType.DORA_G_AIR.id);
        goto L55
    L42:
        if (r45.intValue() != 17) goto L44;
        r43 = String.valueOf(ProductNameType.DORA_G2.id);
        goto L55
    L37:
        if (r45.intValue() != 16) goto L39;
        r43 = String.valueOf(ProductNameType.DORA_G.id);
        goto L55
    L33:
        r45 = null;
    L27:
        r124 = "";
        goto L29
    L24:
        if (r42 == null) goto L28;
        r124 = o59.a.A(r42.getSerialNumber(), r42.getMac(), Boxing.boxInt(r42.getType()));
        if (r124 != null) goto L29;
    L28:
        r124 = null;
        goto L29
    }
}
