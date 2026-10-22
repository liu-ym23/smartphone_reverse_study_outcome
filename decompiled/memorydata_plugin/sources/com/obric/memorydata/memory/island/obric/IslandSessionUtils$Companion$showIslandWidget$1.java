package com.obric.memorydata.memory.island.obric;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.obric.livecard.api.ILiveCard;
import com.obric.livecard.api.IslandCardCallback;
import com.obric.livecard.api.LiveCardType;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.entity.IslandWidget;
import com.obric.livecard.api.island.IslandApi;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.obric.memorydata.memory.utils.o;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.au;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.island.obric.IslandSessionUtils$Companion$showIslandWidget$1", f = "IslandSessionUtils.kt", i = {0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5}, l = {1883, 896, 921, 927, 1010, 1013, 1887, 1887}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "actualOwner$iv", "$this$withLock_u24default$iv", "actualOwner$iv", "visualState", "resolvedExpandTemplate", "interval", "$this$withLock_u24default$iv", "actualOwner$iv", "resolvedExpandTemplate", "$this$withLock_u24default$iv", "actualOwner$iv", "resolvedExpandTemplate", "interval", "$this$withLock_u24default$iv", "actualOwner$iv", "resolvedExpandTemplate", "$this$withLock_u24default$iv", "actualOwner$iv", "resolvedExpandTemplate"}, s = {"L$0", "L$7", "L$0", "L$3", "L$4", "L$5", "J$0", "L$0", "L$2", "L$3", "L$0", "L$3", "L$4", "J$0", "L$0", "L$2", "L$3", "L$0", "L$2", "L$3"})
final class IslandSessionUtils$Companion$showIslandWidget$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, IslandSessionUtils.Companion.b> $batchActionContents;
    final /* synthetic */ IslandSessionUtils.Companion.MemoryCollapseTemplate $collapseWidgetData;
    final /* synthetic */ IslandSessionUtils.Companion.b $content;
    final /* synthetic */ Long $dismissInterval;
    final /* synthetic */ Object $expandWidgetData;
    final /* synthetic */ String $id;
    final /* synthetic */ boolean $isCancellation;
    final /* synthetic */ boolean $needDismiss;
    final /* synthetic */ boolean $needEffect;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    boolean Z$0;
    boolean Z$1;
    boolean Z$2;
    int label;

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001f\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\tH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0013"}, d2 = {"com/obric/memorydata/memory/island/obric/IslandSessionUtils$Companion$showIslandWidget$1$1$session$3", "Lcom/obric/livecard/api/IslandCardCallback;", "onSessionActive", "", "session", "Lcom/obric/livecard/api/entity/IslandSession;", "onSessionCreate", "onSessionDestroy", InfoRequestQPSOptTraceLogger.REASON, "", "(Lcom/obric/livecard/api/entity/IslandSession;Ljava/lang/Integer;)V", "onSessionDisplayStatusChanged", "status", "onSessionInactive", "onSessionStatusChanged", "onWidgetShow", "Landroid/os/Bundle;", "widget", "Lcom/obric/livecard/api/entity/IslandWidget;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements IslandCardCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f10227a;

        a(boolean r1) {
            this.f10227a = r1;
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public void onSessionActive(IslandSession r2) {
            Intrinsics.checkNotNullParameter(r2, "session");
            RunLog.INSTANCE.debug("IslandSessionUtils", "onSessionActive ...");
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public void onSessionCreate(IslandSession r2) {
            Intrinsics.checkNotNullParameter(r2, "session");
            if (this.f10227a == true) goto L5;
            return;
        L5:
            if (r2 != CollectionsKt.lastOrNull(IslandSessionUtils.h())) goto L9;
            IslandSessionUtils.f10217a.a();
            return;
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public void onSessionDestroy(IslandSession r7, Integer r8) {
            Intrinsics.checkNotNullParameter(r7, "session");
            i.a(IslandSessionUtils.b(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new IslandSessionUtils$Companion$showIslandWidget$1$1$session$3$onSessionDestroy$1(r7, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public void onSessionDisplayStatusChanged(IslandSession r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "session");
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public void onSessionInactive(IslandSession r1) {
            Intrinsics.checkNotNullParameter(r1, "session");
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public void onSessionStatusChanged(IslandSession r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "session");
        }

        @Override // com.obric.livecard.api.IslandCardCallback
        public Bundle onWidgetShow(IslandWidget r8) {
            Intrinsics.checkNotNullParameter(r8, "widget");
            i.a(IslandSessionUtils.b(), null, null, (Function2) ZeusTransformUtils.preCheckCast(new IslandSessionUtils$Companion$showIslandWidget$1$1$session$3$onWidgetShow$1(r8, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
            return null;
        }
    }

    IslandSessionUtils$Companion$showIslandWidget$1(IslandSessionUtils.Companion.b r3, Long r4, String r5, boolean r6, Object r7, Map<String, IslandSessionUtils.Companion.b> r8, IslandSessionUtils.Companion.MemoryCollapseTemplate r9, boolean r10, boolean r11, Continuation<? super IslandSessionUtils$Companion$showIslandWidget$1> r12) {
        Map<String, IslandSessionUtils.Companion.b> r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        this.$content = r3;
        this.$dismissInterval = r4;
        this.$id = r5;
        this.$isCancellation = r6;
        this.$expandWidgetData = r7;
        this.$batchActionContents = r13;
        this.$collapseWidgetData = r9;
        this.$needDismiss = r10;
        this.$needEffect = r11;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new IslandSessionUtils$Companion$showIslandWidget$1(this.$content, this.$dismissInterval, this.$id, this.$isCancellation, this.$expandWidgetData, this.$batchActionContents, this.$collapseWidgetData, this.$needDismiss, this.$needEffect, r11), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((IslandSessionUtils$Companion$showIslandWidget$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), IslandSessionUtils$Companion$showIslandWidget$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r46) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        Object r3 = "task id: ";
        String r8 = "com.obric.memorydata.plugin";
        switch(this.label) {
            case 0: goto L35;
            case 1: goto L32;
            case 2: goto L26;
            case 3: goto L21;
            case 4: goto L16;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L9;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        th = (Throwable) ZeusTransformUtils.preCheckCast(this.L$0, Throwable.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r46);     // Catch: Exception -> L154
    L149:
        throw th;     // Catch: Exception -> L150
    L9:
        Unit r0 = (Unit) ZeusTransformUtils.preCheckCast(this.L$0, Unit.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r46);     // Catch: Exception -> L154
    L162:
        return Unit.INSTANCE;
    L12:
        IslandSessionUtils.Companion.c r1 = (IslandSessionUtils.Companion.c) ZeusTransformUtils.preCheckCast(this.L$3, IslandSessionUtils.Companion.c.class, "com.obric.memorydata.plugin");
        r3 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(this.L$2, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
        String r4 = (String) ZeusTransformUtils.preCheckCast(this.L$1, String.class, "com.obric.memorydata.plugin");
        o r6 = (o) ZeusTransformUtils.preCheckCast(this.L$0, o.class, "com.obric.memorydata.plugin");
    L14:
        ResultKt.throwOnFailure(r46);     // Catch: Throwable -> L24
        r8 = "com.obric.memorydata.plugin";
    L133:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L138
    L134:
        IslandSessionUtils.Companion r7 = IslandSessionUtils.f10217a;     // Catch: Throwable -> L138
        IslandSessionUtils.a(r4);     // Catch: Throwable -> L138
        IslandSessionUtils.Companion r9 = IslandSessionUtils.f10217a;     // Catch: Throwable -> L138
        IslandSessionUtils.a(r1.b());     // Catch: Throwable -> L138
        IslandSessionUtils.Companion r10 = IslandSessionUtils.f10217a;     // Catch: Throwable -> L138
        IslandSessionUtils.a(r1.getType());     // Catch: Throwable -> L138
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L138
        Continuation<? super Unit> r12 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, r8);     // Catch: Exception -> L150
        this.L$0 = r11;     // Catch: Exception -> L150
        this.L$1 = null;     // Catch: Exception -> L150
        this.L$2 = null;     // Catch: Exception -> L150
        this.L$3 = null;     // Catch: Exception -> L150
        this.L$4 = null;     // Catch: Exception -> L150
        this.L$5 = null;     // Catch: Exception -> L150
        this.L$6 = null;     // Catch: Exception -> L150
        this.L$7 = null;     // Catch: Exception -> L150
        this.label = 7;     // Catch: Exception -> L150
        if (r6.b(r3, r12) != r2) goto L162;
        return r2;
    L138:
        th = th;
    L146:
        Continuation<? super Unit> r13 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, r8);     // Catch: Exception -> L150
        this.L$0 = th;     // Catch: Exception -> L150
        this.L$1 = null;     // Catch: Exception -> L150
        this.L$2 = null;     // Catch: Exception -> L150
        this.L$3 = null;     // Catch: Exception -> L150
        this.L$4 = null;     // Catch: Exception -> L150
        this.L$5 = null;     // Catch: Exception -> L150
        this.L$6 = null;     // Catch: Exception -> L150
        this.L$7 = null;     // Catch: Exception -> L150
        this.label = 8;     // Catch: Exception -> L150
        if (r6.b(r3, r13) != r2) goto L149;
        return r2;
    L13:
        r1 = (IslandSessionUtils.Companion.c) ZeusTransformUtils.preCheckCast(this.L$3, IslandSessionUtils.Companion.c.class, "com.obric.memorydata.plugin");
        r3 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(this.L$2, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
        r4 = (String) ZeusTransformUtils.preCheckCast(this.L$1, String.class, "com.obric.memorydata.plugin");
        r6 = (o) ZeusTransformUtils.preCheckCast(this.L$0, o.class, "com.obric.memorydata.plugin");
        goto L14
    L16:
        long r14 = this.J$0;
        boolean r15 = this.Z$2;
        boolean r16 = this.Z$1;
        boolean r17 = this.Z$0;
        IslandSessionUtils.Companion.c r18 = (IslandSessionUtils.Companion.c) ZeusTransformUtils.preCheckCast(this.L$4, IslandSessionUtils.Companion.c.class, "com.obric.memorydata.plugin");
        CoroutineContext.Element r19 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(this.L$3, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
        IslandSessionUtils.Companion.MemoryCollapseTemplate r20 = (IslandSessionUtils.Companion.MemoryCollapseTemplate) ZeusTransformUtils.preCheckCast(this.L$2, IslandSessionUtils.Companion.MemoryCollapseTemplate.class, "com.obric.memorydata.plugin");
        String r21 = (String) ZeusTransformUtils.preCheckCast(this.L$1, String.class, "com.obric.memorydata.plugin");
        r6 = (o) ZeusTransformUtils.preCheckCast(this.L$0, o.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r46);     // Catch: Throwable -> L19
        String r22 = "com.obric.memorydata.plugin";
        boolean r110 = r17;
        String r23 = "IslandSessionUtils";
        boolean r111 = r16;
        long r112 = r14;
        IslandSessionUtils.Companion.c r24 = r18;
        boolean r113 = r15;
        r3 = r19;
    L108:
        IslandSessionUtils.Companion r25 = IslandSessionUtils.f10217a;     // Catch: Throwable -> L100
        if (r110 == false) goto L111;
        Long r26 = Boxing.boxLong(SystemClock.elapsedRealtime() + r112);     // Catch: Throwable -> L100
    L112:
        IslandSessionUtils.a(r26);     // Catch: Throwable -> L100
        LiveCardType r31 = LiveCardType.MEMORY_DATA;     // Catch: Throwable -> L100
        IslandWidget r27 = r20.create(Boxing.boxBoolean(true));     // Catch: Throwable -> L100
        r27.setOnCardClickCallback(IslandSessionUtils.d());     // Catch: Throwable -> L100
        IslandWidget r28 = IslandSessionUtils.Companion.a(IslandSessionUtils.f10217a, r24.a(), null, 1, null);     // Catch: Throwable -> L142
        r28.setOnCardClickCallback(IslandSessionUtils.d());     // Catch: Throwable -> L142
        IslandSessionUtils.Companion.a(IslandSessionUtils.f10217a, r28, r24.c());     // Catch: Throwable -> L142
        if (r113 == false) goto L117;
        boolean r114 = true;
    L118:
        r8 = r22;
        IslandSession r115 = new IslandSession(r27, r28, null, null, null, (IslandCardCallback) ZeusTransformUtils.preCheckCast(new a(r114), IslandCardCallback.class, r8), null, 0, r31, null, Boxing.boxBoolean(true), null, 1025, null, null, null, 0, 125660, null);     // Catch: Throwable -> L140
        RunLog.INSTANCE.debug(r23, "task id: " + r115.getTaskId());     // Catch: Throwable -> L140
        IslandSessionUtils.h().add(r115);     // Catch: Throwable -> L140
        IslandApi r29 = ILiveCard.Companion.getInst().getIslandService();     // Catch: Throwable -> L140
        if (r29 == null) goto L123;
        Boxing.boxBoolean(r29.createSession(r115, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), r8), Context.class, r8)));     // Catch: Throwable -> L140
    L123:
        if (r111 == false) goto L129;
        IslandSessionUtils.Companion r30 = IslandSessionUtils.f10217a;     // Catch: Throwable -> L140
        this.L$0 = r6;     // Catch: Throwable -> L140
        this.L$1 = r21;     // Catch: Throwable -> L140
        this.L$2 = r3;     // Catch: Throwable -> L140
        this.L$3 = r24;     // Catch: Throwable -> L140
        this.L$4 = null;     // Catch: Throwable -> L140
        this.label = 5;     // Catch: Throwable -> L140
        r2 = r2;
        if (r30.a(r112, this) != r2) goto L128;
        return r2;
    L128:
        r4 = r21;
        r1 = r24;
        goto L133
    L129:
        r2 = r2;
        IslandSessionUtils.Companion r32 = IslandSessionUtils.f10217a;     // Catch: Throwable -> L138
        this.L$0 = r6;     // Catch: Throwable -> L138
        this.L$1 = r21;     // Catch: Throwable -> L138
        this.L$2 = r3;     // Catch: Throwable -> L138
        this.L$3 = r24;     // Catch: Throwable -> L138
        this.L$4 = null;     // Catch: Throwable -> L138
        this.label = 6;     // Catch: Throwable -> L138
        if (r32.a(60000, this) != r2) goto L128;
        return r2;
    L140:
        th = th;
        r2 = r2;
        goto L146
    L117:
        r114 = false;
    L142:
        th = th;
        r2 = r2;
    L101:
        r8 = r22;
        goto L146
    L111:
        r26 = null;
    L19:
        th = th;
        r3 = r19;
        goto L146
    L21:
        r1 = (IslandSessionUtils.Companion.c) ZeusTransformUtils.preCheckCast(this.L$3, IslandSessionUtils.Companion.c.class, "com.obric.memorydata.plugin");
        r3 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(this.L$2, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
        r4 = (String) ZeusTransformUtils.preCheckCast(this.L$1, String.class, "com.obric.memorydata.plugin");
        r6 = (o) ZeusTransformUtils.preCheckCast(this.L$0, o.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r46);     // Catch: Throwable -> L24
        String r210 = "com.obric.memorydata.plugin";
    L99:
        Unit r33 = Unit.INSTANCE;     // Catch: Throwable -> L100
        r8 = r210;
        goto L134
    L26:
        long r34 = this.J$0;
        boolean r35 = this.Z$0;
        IslandSessionUtils.Companion.c r36 = (IslandSessionUtils.Companion.c) ZeusTransformUtils.preCheckCast(this.L$5, IslandSessionUtils.Companion.c.class, "com.obric.memorydata.plugin");
        IslandSessionUtils.Companion.MemoryIslandVisualState r37 = (IslandSessionUtils.Companion.MemoryIslandVisualState) ZeusTransformUtils.preCheckCast(this.L$4, IslandSessionUtils.Companion.MemoryIslandVisualState.class, "com.obric.memorydata.plugin");
        Object r116 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(this.L$3, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
        IslandSessionUtils.Companion.MemoryCollapseTemplate r117 = (IslandSessionUtils.Companion.MemoryCollapseTemplate) ZeusTransformUtils.preCheckCast(this.L$2, IslandSessionUtils.Companion.MemoryCollapseTemplate.class, "com.obric.memorydata.plugin");
        String r118 = (String) ZeusTransformUtils.preCheckCast(this.L$1, String.class, "com.obric.memorydata.plugin");
        o r119 = (o) ZeusTransformUtils.preCheckCast(this.L$0, o.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r46);     // Catch: Throwable -> L29
        r3 = "task id: ";
        r22 = "com.obric.memorydata.plugin";
        r23 = "IslandSessionUtils";
    L73:
        r110 = r35;
        r1 = r36;
        IslandSessionUtils.Companion.MemoryIslandVisualState r38 = r37;
        r3 = r116;
        r4 = r118;
        long r43 = r34;
        r6 = r119;
        long r120 = r43;
    L75:
        IslandSessionUtils.Companion r39 = IslandSessionUtils.f10217a;     // Catch: Throwable -> L100
        IslandSessionUtils.a(System.currentTimeMillis());     // Catch: Throwable -> L100
        if (r110 == false) goto L81;
        if (IslandSessionUtils.g() != null) goto L81;
        IslandSessionUtils.Companion r40 = IslandSessionUtils.f10217a;     // Catch: Throwable -> L100
        IslandSessionUtils.a(Boxing.boxLong(SystemClock.elapsedRealtime() + r120));     // Catch: Throwable -> L100
    L81:
        String r121 = r22;
        IslandSession r41 = (IslandSession) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(IslandSessionUtils.h()), IslandSession.class, r121);     // Catch: Throwable -> L103
        if (r41 == null) goto L102;
        r210 = r121;
        long r122 = r120;
        RunLog.INSTANCE.debug(r23, new StringBuilder().append(r3).append(r41.getTaskId()).toString());     // Catch: Throwable -> L100
        IslandWidget r42 = r41.getCollapseWidget();     // Catch: Throwable -> L100
        if (r42 == null) goto L91;
        r42.setTemplateData(r117);     // Catch: Throwable -> L100
        IslandApi r123 = ILiveCard.Companion.getInst().getIslandService();     // Catch: Throwable -> L100
        if (r123 == null) goto L91;
        r123.updateWidget(r41, r42);     // Catch: Throwable -> L100
        Unit r44 = Unit.INSTANCE;     // Catch: Throwable -> L100
    L91:
        IslandWidget r45 = r41.getExpandWidget();     // Catch: Throwable -> L100
        if (r45 == null) goto L96;
        r45.setTemplateData(r1.a());     // Catch: Throwable -> L100
        IslandSessionUtils.Companion.a(IslandSessionUtils.f10217a, r45, r1.c());     // Catch: Throwable -> L100
        IslandApi r124 = ILiveCard.Companion.getInst().getIslandService();     // Catch: Throwable -> L100
        if (r124 == null) goto L96;
        r124.updateWidget(r41, r45);     // Catch: Throwable -> L100
        Unit r47 = Unit.INSTANCE;     // Catch: Throwable -> L100
    L96:
        IslandSessionUtils.Companion.a(IslandSessionUtils.f10217a, r41, r38);     // Catch: Throwable -> L100
        IslandSessionUtils.Companion r48 = IslandSessionUtils.f10217a;     // Catch: Throwable -> L100
        this.L$0 = r6;     // Catch: Throwable -> L100
        this.L$1 = r4;     // Catch: Throwable -> L100
        this.L$2 = r3;     // Catch: Throwable -> L100
        this.L$3 = r1;     // Catch: Throwable -> L100
        this.L$4 = null;     // Catch: Throwable -> L100
        this.L$5 = null;     // Catch: Throwable -> L100
        this.L$6 = null;     // Catch: Throwable -> L100
        this.L$7 = null;     // Catch: Throwable -> L100
        this.label = 3;     // Catch: Throwable -> L100
        if (r48.a(r122, this) != r2) goto L99;
        return r2;
    L102:
        r8 = r121;
    L103:
        th = th;
        r8 = r121;
    L29:
        th = th;
        r3 = r116;
        r6 = r119;
        goto L146
    L32:
        boolean r49 = this.Z$2;
        boolean r50 = this.Z$1;
        boolean r51 = this.Z$0;
        CoroutineContext.Element r52 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(this.L$7, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
        IslandSessionUtils.Companion.MemoryCollapseTemplate r53 = (IslandSessionUtils.Companion.MemoryCollapseTemplate) ZeusTransformUtils.preCheckCast(this.L$6, IslandSessionUtils.Companion.MemoryCollapseTemplate.class, "com.obric.memorydata.plugin");
        Map<String, IslandSessionUtils.Companion.b> r125 = (Map) ZeusTransformUtils.preCheckCast(this.L$5, Map.class, "com.obric.memorydata.plugin");
        Object r126 = this.L$4;
        String r127 = (String) ZeusTransformUtils.preCheckCast(this.L$3, String.class, "com.obric.memorydata.plugin");
        Long r128 = (Long) ZeusTransformUtils.preCheckCast(this.L$2, Long.class, "com.obric.memorydata.plugin");
        IslandSessionUtils.Companion.b r129 = (IslandSessionUtils.Companion.b) ZeusTransformUtils.preCheckCast(this.L$1, IslandSessionUtils.Companion.b.class, "com.obric.memorydata.plugin");
        o r54 = (o) ZeusTransformUtils.preCheckCast(this.L$0, o.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r46);     // Catch: Exception -> L154
        String r130 = "IslandSessionUtils";
        r110 = r51;
        r6 = r54;
        boolean r55 = r50;
        r20 = r53;
        boolean r56 = r49;
        r3 = r52;
        r21 = r127;
        Map<String, IslandSessionUtils.Companion.b> r131 = r125;
        Object r132 = r126;
        IslandSessionUtils.Companion.b r133 = r129;
    L42:
        if (r133 != null) goto L178;
    L48:
        int r57 = 0;
    L49:
        if (r128 == null) goto L51;
        long r134 = r128.longValue();     // Catch: Throwable -> L46
    L54:
        boolean r410 = r56;
        boolean r135 = r55;
        r22 = "com.obric.memorydata.plugin";
        r23 = r130;
        RunLog.INSTANCE.debug(r23, "calendarsSize: " + r57 + ", interval: " + r134 + " ms");     // Catch: Throwable -> L100
        boolean r58 = Intrinsics.areEqual(r21, IslandSessionUtils.e());     // Catch: Throwable -> L100
        if (r110 == true) goto L61;
        IslandSessionUtils.Companion r59 = IslandSessionUtils.f10217a;     // Catch: Throwable -> L100
        IslandSessionUtils.a(null);     // Catch: Throwable -> L100
    L61:
        r38 = IslandSessionUtils.Companion.a(IslandSessionUtils.f10217a, r132);     // Catch: Throwable -> L100
        IslandSessionUtils.Companion r60 = IslandSessionUtils.f10217a;     // Catch: Throwable -> L100
        if (r58 == false) goto L64;
        boolean r136 = true;
    L65:
        long r211 = r134;
        r24 = IslandSessionUtils.Companion.a(r60, r132, r133, r131, r38, r136);     // Catch: Throwable -> L100
        IslandSessionUtils.Companion.a(IslandSessionUtils.f10217a, r20, r24.a(), r38);     // Catch: Throwable -> L100
        if (r58 == false) goto L105;
        long r137 = System.currentTimeMillis();     // Catch: Throwable -> L100
        if (r137 >= (IslandSessionUtils.f() + 1000)) goto L74;
        long r138 = (IslandSessionUtils.f() + 1000) - r137;     // Catch: Throwable -> L100
        this.L$0 = r6;     // Catch: Throwable -> L100
        this.L$1 = r21;     // Catch: Throwable -> L100
        this.L$2 = r20;     // Catch: Throwable -> L100
        this.L$3 = r3;     // Catch: Throwable -> L100
        this.L$4 = r38;     // Catch: Throwable -> L100
        this.L$5 = r24;     // Catch: Throwable -> L100
        this.L$6 = null;     // Catch: Throwable -> L100
        this.L$7 = null;     // Catch: Throwable -> L100
        this.Z$0 = r110;     // Catch: Throwable -> L100
        this.J$0 = r211;     // Catch: Throwable -> L100
        this.label = 2;     // Catch: Throwable -> L100
        if (au.a(r138, this) != r2) goto L72;
        return r2;
    L72:
        r119 = r6;
        r118 = r21;
        r34 = r211;
        r35 = r110;
        r116 = r3;
        r117 = r20;
        r36 = r24;
        r37 = r38;
        goto L73
    L74:
        r1 = r24;
        r120 = r211;
        r117 = r20;
        r4 = r21;
        goto L75
    L105:
        r112 = r211;
        IslandSessionUtils.Companion r61 = IslandSessionUtils.f10217a;     // Catch: Throwable -> L100
        IslandSessionUtils.a(System.currentTimeMillis());     // Catch: Throwable -> L100
        IslandSessionUtils.Companion r62 = IslandSessionUtils.f10217a;     // Catch: Throwable -> L100
        this.L$0 = r6;     // Catch: Throwable -> L100
        this.L$1 = r21;     // Catch: Throwable -> L100
        this.L$2 = r20;     // Catch: Throwable -> L100
        this.L$3 = r3;     // Catch: Throwable -> L100
        this.L$4 = r24;     // Catch: Throwable -> L100
        this.L$5 = null;     // Catch: Throwable -> L100
        this.L$6 = null;     // Catch: Throwable -> L100
        this.L$7 = null;     // Catch: Throwable -> L100
        this.Z$0 = r110;     // Catch: Throwable -> L100
        r111 = r135;
        this.Z$1 = r111;     // Catch: Throwable -> L100
        r113 = r410;
        this.Z$2 = r113;     // Catch: Throwable -> L100
        this.J$0 = r112;     // Catch: Throwable -> L100
        this.label = 4;     // Catch: Throwable -> L100
        if (r62.a(this) != r2) goto L108;
        return r2;
    L64:
        r136 = false;
    L100:
        th = th;
    L144:
        th = th;
    L46:
        th = th;
        r8 = "com.obric.memorydata.plugin";
        goto L146
    L51:
        if (r57 <= 0) goto L53;
        r134 = 2000;
        goto L54
    L53:
        r134 = 5000;
        goto L54
    L178:
        List<PendingMemoryCalendar> r63 = r133.d();     // Catch: Throwable -> L46
        if (r63 == null) goto L48;
        r57 = r63.size();     // Catch: Throwable -> L46
        goto L49
    L35:
        ResultKt.throwOnFailure(r46);
        o r64 = IslandSessionUtils.c();     // Catch: Exception -> L154
        IslandSessionUtils.Companion.b r139 = this.$content;     // Catch: Exception -> L154
        r128 = this.$dismissInterval;     // Catch: Exception -> L154
        String r65 = this.$id;     // Catch: Exception -> L154
        boolean r66 = this.$isCancellation;     // Catch: Exception -> L154
        Object r140 = this.$expandWidgetData;     // Catch: Exception -> L154
        Map<String, IslandSessionUtils.Companion.b> r141 = this.$batchActionContents;     // Catch: Exception -> L154
        IslandSessionUtils.Companion.MemoryCollapseTemplate r67 = this.$collapseWidgetData;     // Catch: Exception -> L154
        boolean r68 = this.$needDismiss;     // Catch: Exception -> L154
        boolean r142 = this.$needEffect;     // Catch: Exception -> L154
        r130 = "IslandSessionUtils";
        r3 = getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L152
        Continuation<? super Unit> r69 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L152
        this.L$0 = r64;     // Catch: Exception -> L152
        this.L$1 = r139;     // Catch: Exception -> L152
        this.L$2 = r128;     // Catch: Exception -> L152
        this.L$3 = r65;     // Catch: Exception -> L152
        this.L$4 = r140;     // Catch: Exception -> L152
        this.L$5 = r141;     // Catch: Exception -> L152
        this.L$6 = r67;     // Catch: Exception -> L152
        this.L$7 = r3;     // Catch: Exception -> L152
        this.Z$0 = r66;     // Catch: Exception -> L152
        this.Z$1 = r68;     // Catch: Exception -> L152
        this.Z$2 = r142;     // Catch: Exception -> L152
        this.label = 1;     // Catch: Exception -> L152
        if (r64.a(r3, r69) != r2) goto L41;
        return r2;
    L41:
        r110 = r66;
        r55 = r68;
        r6 = r64;
        r56 = r142;
        r131 = r141;
        r132 = r140;
        r133 = r139;
        r21 = r65;
        r20 = r67;
    L152:
        e = e;
        r8 = r130;
    L156:
        RunLog.INSTANCE.error(r8, "Error in showIslandWidget: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, r8));
        IslandSessionUtils.Companion r70 = IslandSessionUtils.f10217a;     // Catch: Exception -> L159
        IslandSessionUtils.a("");     // Catch: Exception -> L159
        IslandSessionUtils.Companion r71 = IslandSessionUtils.f10217a;     // Catch: Exception -> L159
        IslandSessionUtils.a(null);     // Catch: Exception -> L159
        IslandSessionUtils.Companion r72 = IslandSessionUtils.f10217a;     // Catch: Exception -> L159
        IslandSessionUtils.a(null);     // Catch: Exception -> L159
    L159:
        e = move-exception;
        RunLog.INSTANCE.error(r8, "Error during cleanup: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L162
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L150:
        e = e;
    L24:
        th = th;
    L154:
        e = e;
        r8 = "IslandSessionUtils";
        goto L156
    }
}
