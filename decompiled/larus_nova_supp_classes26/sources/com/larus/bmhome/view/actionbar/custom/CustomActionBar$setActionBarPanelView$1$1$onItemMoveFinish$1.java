package com.larus.bmhome.view.actionbar.custom;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.bmhome.chat.api.BotApi;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.custom.CustomActionBar$setActionBarPanelView$1$1$onItemMoveFinish$1", f = "CustomActionBar.kt", i = {}, l = {3446}, m = "invokeSuspend", n = {}, s = {})
public final class CustomActionBar$setActionBarPanelView$1$1$onItemMoveFinish$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<com.larus.bmhome.actionbar.model.z0> $newItems;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ CustomActionBar this$0;

    public CustomActionBar$setActionBarPanelView$1$1$onItemMoveFinish$1(CustomActionBar r1, List<com.larus.bmhome.actionbar.model.z0> r2, Continuation<? super CustomActionBar$setActionBarPanelView$1$1$onItemMoveFinish$1> r3) {
        this.this$0 = r1;
        this.$newItems = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CustomActionBar$setActionBarPanelView$1$1$onItemMoveFinish$1(this.this$0, this.$newItems, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        List<com.larus.bmhome.actionbar.model.z0> r3 = (List) this.L$1;
        CustomActionBar r4 = (CustomActionBar) this.L$0;
        ResultKt.throwOnFailure(r17);
        Object r5 = r17;
    L56:
        com.larus.network.http.a r6 = (com.larus.network.http.a) r5;
        if ((r6 instanceof com.larus.network.http.y) == false) goto L61;
        CustomActionBarViewModel r7 = r4.o;
        if (r7 == null) goto L63;
        int r8 = CustomActionBar.c0;
        r7.updateLocalCache(CustomActionBar.b.a(), r3);
    L63:
        return Unit.INSTANCE;
    L61:
        FLogger.a.e("CustomActionBar", "requireCustomActionBarCustomize error:" + r6);
        goto L63
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        r4 = this.this$0;
        String r9 = r4.l;
        if (r9 == null) goto L63;
        List<com.larus.bmhome.actionbar.model.z0> r10 = this.$newItems;
        BotApi r11 = (BotApi) BotApi.a.getValue();
        long r12 = CastLongProtector.parseLong(r9);
        ArrayList r13 = new ArrayList();
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r10.iterator();
    L11:
        int r16 = 0;
        if (r15.hasNext() == false) goto L18;
        Object r18 = r15.next();
        if (((com.larus.bmhome.actionbar.model.z0) r18).a == null) goto L16;
        r16 = 1;
    L16:
        if (r16 == 0) goto L11;
        r14.add(r18);
        goto L11
    L18:
        ArrayList r19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator r110 = r14.iterator();
    L20:
        if (r110.hasNext() == false) goto L26;
        Long r111 = ((com.larus.bmhome.actionbar.model.z0) r110.next()).a;
        if (r111 == null) goto L24;
        long r112 = r111.longValue();
    L25:
        r19.add(Boxing.boxLong(r112));
        goto L20
    L24:
        r112 = 0;
        goto L25
    L26:
        r13.addAll(r19);
        int r113 = r19.size();
        CustomActionBarViewModel r114 = r4.o;
        if (r114 == null) goto L31;
        List<com.larus.bmhome.actionbar.model.z0> r115 = r114.getRemoteActionbarList();
        if (r115 == null) goto L31;
        r16 = r115.size();
    L31:
        if (r113 >= r16) goto L52;
        CustomActionBarViewModel r116 = r4.o;
        if (r116 == null) goto L50;
        List<com.larus.bmhome.actionbar.model.z0> r117 = r116.getRemoteActionbarList();
        if (r117 == null) goto L50;
        ArrayList r118 = new ArrayList();
        Iterator<T> r119 = r117.iterator();
    L38:
        if (r119.hasNext() == false) goto L42;
        Object r120 = r119.next();
        if ((!CollectionsKt.contains(r19, ((com.larus.bmhome.actionbar.model.z0) r120).a)) == false) goto L38;
        r118.add(r120);
        goto L38
    L42:
        ArrayList r20 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r118, 10));
        Iterator r121 = r118.iterator();
    L44:
        if (r121.hasNext() == false) goto L51;
        Long r122 = ((com.larus.bmhome.actionbar.model.z0) r121.next()).a;
        if (r122 == null) goto L48;
        long r123 = r122.longValue();
    L49:
        r20.add(Boxing.boxLong(r123));
        goto L44
    L48:
        r123 = 0;
    L51:
        r13.addAll(r20);
    L50:
        r20 = new ArrayList();
    L52:
        Unit r21 = Unit.INSTANCE;
        this.L$0 = r4;
        this.L$1 = r10;
        this.label = 1;
        r11.getClass();
        r5 = BotApi.g(r12, r13, this);
        if (r5 != r1) goto L55;
        return r1;
    L55:
        r3 = r10;
        goto L56
    }
}
