package com.bytedance.android.live.room.discovery.drawer.processor;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.room.discovery.drawer.DrawerEntranceApi;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.live.datacontext.m;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedance/android/live/base/model/moreliveentrance/b;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.live.room.discovery.drawer.processor.MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$3$deferredTask$1", f = "MoreLiveEntranceMarqueeProcessorController.kt", i = {}, l = {139}, m = "invokeSuspend", n = {}, s = {})
public final class MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$3$deferredTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.bytedance.android.live.base.model.moreliveentrance.b>, Object> {
    int label;
    final /* synthetic */ MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$3 this$0;

    public MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$3$deferredTask$1(MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$3 r1, Continuation r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "completion");
        return new MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$3$deferredTask$1(this.this$0, r3);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r23) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r23);
        return r23;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r23);
        MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$3 r1 = this.this$0;
        MoreLiveEntranceMarqueeProcessorController r4 = r1.this$0;
        Map<String, Object> r12 = r1.$extraQueryMap;
        this.label = 1;
        r4.getClass();
        j r13 = new j(IntrinsicsKt.intercepted(this), 1);
        r13.C();
        final Ref.ObjectRef r3 = new Ref.ObjectRef();
        String r14 = null;
        r3.element = null;
        r13.i(new MoreLiveEntranceMarqueeProcessorController$fetchDrawerEntranceDataAsync$2$1(r3));
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L76
        long r8 = -1;
        if (r4.f.a() == false) goto L37;
        DrawerEntranceApi r6 = (DrawerEntranceApi) com.bytedance.android.live.network.c.b().e(DrawerEntranceApi.class);     // Catch: Throwable -> L76
        if (r6 == null) goto L35;
        RoomContext r15 = r4.f.q;     // Catch: Throwable -> L76
        if (r15 == null) goto L21;
        m r16 = r15.getRoom();     // Catch: Throwable -> L76
        if (r16 == null) goto L21;
        Room r17 = (Room) r16.getValue();     // Catch: Throwable -> L76
        if (r17 == null) goto L21;
        r8 = r17.getRoomId();     // Catch: Throwable -> L76
    L21:
        RoomContext r18 = r4.f.q;     // Catch: Throwable -> L76
        if (r18 == null) goto L29;
        m r19 = r18.getRoom();     // Catch: Throwable -> L76
        if (r19 == null) goto L29;
        Room r110 = (Room) r19.getValue();     // Catch: Throwable -> L76
        if (r110 == null) goto L29;
        String r111 = r110.getOwnerUserIdString();     // Catch: Throwable -> L76
        if (r111 == null) goto L29;
    L30:
        String r7 = r4.f.a;     // Catch: Throwable -> L76
        if (r7 != null) goto L33;
        String r112 = "";
    L34:
        Call<com.bytedance.android.live.network.response.e<com.bytedance.android.live.base.model.moreliveentrance.a>> r9 = r6.getMoreEntranceDataNew(2, r8, r111, "", r112, r12);     // Catch: Throwable -> L76
    L36:
        r3.element = r9;     // Catch: Throwable -> L76
    L64:
        Call r10 = (Call) r3.element;     // Catch: Throwable -> L76
        if (r10 == null) goto L73;
        SsResponse r20 = r10.execute();     // Catch: Throwable -> L76
        if (r20 == null) goto L73;
        com.bytedance.android.live.network.response.e r22 = (com.bytedance.android.live.network.response.e) r20.body();     // Catch: Throwable -> L76
        if (r22 == null) goto L73;
        com.bytedance.android.live.base.model.moreliveentrance.a r24 = (com.bytedance.android.live.base.model.moreliveentrance.a) ((ExtraResponse) r22).data;     // Catch: Throwable -> L76
        if (r24 == null) goto L73;
        com.bytedance.android.live.base.model.moreliveentrance.b r25 = r24.a();     // Catch: Throwable -> L76
    L74:
        Object r26 = Result.constructor-impl(r25);     // Catch: Throwable -> L76
    L78:
        Throwable r27 = Result.exceptionOrNull-impl(r26);
        if (r27 == null) goto L82;
        r4.f.l++;
        Intrinsics.checkNotNullParameter("fetchDrawerEntranceDataAsync error call back.", Constants.OperatorKey.MSG);
        Intrinsics.checkNotNullParameter(r27, "e");
        ALogger.e("LiveDrawerLog", "fetchDrawerEntranceDataAsync error call back.", r27);
        r13.resumeWith(Result.constructor-impl(null));
    L82:
        if (Result.isSuccess-impl(r26) == false) goto L87;
        com.bytedance.android.live.base.model.moreliveentrance.b r28 = (com.bytedance.android.live.base.model.moreliveentrance.b) r26;
        r4.f.l++;
        d.a("fetchDrawerEntranceDataAsync success call back.");
        StringBuilder r29 = new StringBuilder("get entrance info ");
        if (r28 == null) goto L86;
        Intrinsics.checkNotNullParameter(r28, "$this$toLogString");
        r14 = "{name: " + r28.e() + ", validTime: " + r28.o() + ", tabItemId:" + r28.j() + ", tabItemName:" + r28.k() + ", tabItemEvent:" + r28.i() + ", guideType:" + r28.d() + ", entranceType: " + r28.a();
    L86:
        r29.append(r14);
        String r30 = r29.toString();
        Intrinsics.checkNotNullParameter(r30, Constants.OperatorKey.MSG);
        ALogger.d("LiveDrawerLog", r30);
        r13.resumeWith(Result.constructor-impl(r28));
    L87:
        Object r32 = r13.B();
        if (r32 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L90;
        DebugProbesKt.probeCoroutineSuspended(this);
    L90:
        if (r32 != r2) goto L95;
        return r2;
    L95:
        return r32;
    L73:
        r25 = null;
        goto L74
    L33:
        r112 = r7;
    L29:
        r111 = "-1";
        goto L30
    L35:
        r9 = null;
        goto L36
    L37:
        DrawerEntranceApi r113 = (DrawerEntranceApi) com.bytedance.android.live.network.c.b().e(DrawerEntranceApi.class);     // Catch: Throwable -> L76
        if (r113 == null) goto L62;
        RoomContext r33 = r4.f.q;     // Catch: Throwable -> L76
        if (r33 == null) goto L46;
        m r34 = r33.getRoom();     // Catch: Throwable -> L76
        if (r34 == null) goto L46;
        Room r35 = (Room) r34.getValue();     // Catch: Throwable -> L76
        if (r35 == null) goto L46;
        r8 = r35.getRoomId();     // Catch: Throwable -> L76
    L46:
        long r114 = r8;
        RoomContext r36 = r4.f.q;     // Catch: Throwable -> L76
        if (r36 == null) goto L56;
        m r37 = r36.getRoom();     // Catch: Throwable -> L76
        if (r37 == null) goto L56;
        Room r38 = (Room) r37.getValue();     // Catch: Throwable -> L76
        if (r38 == null) goto L56;
        String r39 = r38.getOwnerUserIdString();     // Catch: Throwable -> L76
        if (r39 == null) goto L56;
        String r115 = r39;
    L57:
        String r40 = r4.f.a;     // Catch: Throwable -> L76
        if (r40 != null) goto L60;
        String r210 = "";
    L61:
        Call<com.bytedance.android.live.network.response.e<com.bytedance.android.live.base.model.moreliveentrance.a>> r42 = r113.getMoreEntranceData(2, r114, r115, "", r210);     // Catch: Throwable -> L76
    L63:
        r3.element = r42;     // Catch: Throwable -> L76
        goto L64
    L60:
        r210 = r40;
    L56:
        r115 = "-1";
        goto L57
    L62:
        r42 = null;
    L76:
        th = move-exception;
        Result.Companion r43 = Result.Companion;
        r26 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L78
    }
}
