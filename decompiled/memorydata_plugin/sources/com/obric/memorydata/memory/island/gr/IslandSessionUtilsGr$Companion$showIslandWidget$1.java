package com.obric.memorydata.memory.island.gr;

import android.app.PendingIntent;
import android.content.Context;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.obric.memorydata.memory.utils.o;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.island.gr.IslandSessionUtilsGr$Companion$showIslandWidget$1", f = "IslandSessionUtilsGr.kt", i = {0, 0, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4}, l = {1332, 212, 239, 248, 287, 1336, 1336}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "actualOwner$iv", "$this$withLock_u24default$iv", "actualOwner$iv", "ctx", "$this$withLock_u24default$iv", "actualOwner$iv", "$this$withLock_u24default$iv", "actualOwner$iv", "ctx", "$this$withLock_u24default$iv", "actualOwner$iv"}, s = {"L$0", "L$6", "L$0", "L$6", "L$7", "L$0", "L$3", "L$0", "L$6", "L$7", "L$0", "L$1"})
final class IslandSessionUtilsGr$Companion$showIslandWidget$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $collapseTitle;
    final /* synthetic */ MemoryCollapseTemplate $collapseWidgetData;
    final /* synthetic */ f.a.C0502a $content;
    final /* synthetic */ long $dismissInterval;
    final /* synthetic */ MemoryExpandedTemplate $expandWidgetData;
    final /* synthetic */ String $id;
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
    int label;

    IslandSessionUtilsGr$Companion$showIslandWidget$1(String r3, f.a.C0502a r4, MemoryCollapseTemplate r5, MemoryExpandedTemplate r6, String r7, boolean r8, boolean r9, long r10, Continuation<? super IslandSessionUtilsGr$Companion$showIslandWidget$1> r12) {
        Continuation r13 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        this.$id = r3;
        this.$content = r4;
        this.$collapseWidgetData = r5;
        this.$expandWidgetData = r6;
        this.$collapseTitle = r7;
        this.$needEffect = r8;
        this.$needDismiss = r9;
        this.$dismissInterval = r10;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new IslandSessionUtilsGr$Companion$showIslandWidget$1(this.$id, this.$content, this.$collapseWidgetData, this.$expandWidgetData, this.$collapseTitle, this.$needEffect, this.$needDismiss, this.$dismissInterval, r11), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((IslandSessionUtilsGr$Companion$showIslandWidget$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), IslandSessionUtilsGr$Companion$showIslandWidget$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r51) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String r7 = "com.obric.memorydata.plugin";
        switch(this.label) {
            case 0: goto L37;
            case 1: goto L34;
            case 2: goto L27;
            case 3: goto L22;
            case 4: goto L17;
            case 5: goto L12;
            case 6: goto L9;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        th = (Throwable) ZeusTransformUtils.preCheckCast(this.L$0, Throwable.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r51);     // Catch: Exception -> L178
    L173:
        throw th;     // Catch: Exception -> L174
    L9:
        Unit r0 = (Unit) ZeusTransformUtils.preCheckCast(this.L$0, Unit.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r51);     // Catch: Exception -> L178
        r7 = "com.obric.memorydata.plugin";
    L155:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, r7), "IslandSessionUtilsGr", "showIslandWidget: DONE for id=" + this.$id, false, 4, null);     // Catch: Exception -> L174
    L186:
        return Unit.INSTANCE;
    L12:
        CoroutineContext.Element r3 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(this.L$1, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
        o r4 = (o) ZeusTransformUtils.preCheckCast(this.L$0, o.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r51);     // Catch: Throwable -> L15
        r7 = "com.obric.memorydata.plugin";
        Object r8 = r2;
    L151:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L156
        Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, r7);     // Catch: Exception -> L174
        this.L$0 = r1;     // Catch: Exception -> L174
        this.L$1 = null;     // Catch: Exception -> L174
        this.L$2 = null;     // Catch: Exception -> L174
        this.L$3 = null;     // Catch: Exception -> L174
        this.L$4 = null;     // Catch: Exception -> L174
        this.L$5 = null;     // Catch: Exception -> L174
        this.L$6 = null;     // Catch: Exception -> L174
        this.L$7 = null;     // Catch: Exception -> L174
        this.label = 6;     // Catch: Exception -> L174
        if (r4.b(r3, r5) != r8) goto L155;
        return r8;
    L156:
        th = th;
    L170:
        Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, r7);     // Catch: Exception -> L174
        this.L$0 = th;     // Catch: Exception -> L174
        this.L$1 = null;     // Catch: Exception -> L174
        this.L$2 = null;     // Catch: Exception -> L174
        this.L$3 = null;     // Catch: Exception -> L174
        this.L$4 = null;     // Catch: Exception -> L174
        this.L$5 = null;     // Catch: Exception -> L174
        this.L$6 = null;     // Catch: Exception -> L174
        this.L$7 = null;     // Catch: Exception -> L174
        this.label = 7;     // Catch: Exception -> L174
        if (r4.b(r3, r6) != r8) goto L173;
        return r8;
    L15:
        th = th;
        r7 = "com.obric.memorydata.plugin";
    L33:
        r8 = r2;
        goto L170
    L17:
        long r9 = this.J$0;
        boolean r10 = this.Z$1;
        boolean r11 = this.Z$0;
        Context r12 = (Context) ZeusTransformUtils.preCheckCast(this.L$7, Context.class, "com.obric.memorydata.plugin");
        CoroutineContext.Element r13 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(this.L$6, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(this.L$5, String.class, "com.obric.memorydata.plugin");
        MemoryExpandedTemplate r15 = (MemoryExpandedTemplate) ZeusTransformUtils.preCheckCast(this.L$4, MemoryExpandedTemplate.class, "com.obric.memorydata.plugin");
        MemoryCollapseTemplate r16 = (MemoryCollapseTemplate) ZeusTransformUtils.preCheckCast(this.L$3, MemoryCollapseTemplate.class, "com.obric.memorydata.plugin");
        f.a.C0502a r17 = (f.a.C0502a) ZeusTransformUtils.preCheckCast(this.L$2, f.a.C0502a.class, "com.obric.memorydata.plugin");
        String r18 = (String) ZeusTransformUtils.preCheckCast(this.L$1, String.class, "com.obric.memorydata.plugin");
        o r19 = (o) ZeusTransformUtils.preCheckCast(this.L$0, o.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r51);     // Catch: Throwable -> L20
        String r36 = r14;
        String r20 = r18;
        r8 = r2;
        boolean r21 = r10;
        String r22 = "ms";
        r3 = r13;
        String r110 = "IslandSessionUtilsGr";
        boolean r23 = r11;
        r7 = "com.obric.memorydata.plugin";
        Context r24 = r12;
        long r111 = r9;
    L122:
        if (r17 != null) goto L205;
        PendingIntent r25 = null;
    L127:
        RunLog r112 = RunLog.INSTANCE;     // Catch: Throwable -> L124
        String r52 = r20;
        boolean r45 = r21;
        StringBuilder r26 = new StringBuilder().append("showIslandWidget: built card click PendingIntent, hasIntent=");     // Catch: Throwable -> L124
        if (r25 == null) goto L130;
        boolean r27 = true;
    L131:
        StringBuilder r28 = r26.append(r27).append(", hasContent=");     // Catch: Throwable -> L124
        if (r17 == null) goto L134;
        boolean r29 = true;
    L135:
        r112.debug(r110, r28.append(r29).toString());     // Catch: Throwable -> L124
        IslandSession r30 = new IslandSession(r16.create(Boxing.boxBoolean(true)), MemoryExpandedTemplate.create$default(r15, null, 1, null), f.a.a(f.f10213a), r25, ZeusTransformUtils.mapRes(R.drawable.ic_island_small_icon, "drawable", "ic_island_small_icon"), 0, SlardarSettingsConstants.PERF_KEY_MEMORY, true, false, false, false, null, null, r36, null, null, r36, null, null, null, null, null, null, 8314656, null);     // Catch: Throwable -> L124
        r30.logSummary("showIslandWidget → ");     // Catch: Throwable -> L124
        f.e().add(r30);     // Catch: Throwable -> L124
        RunLog.INSTANCE.debug(r110, "showIslandWidget: session added, total=" + f.e().size());     // Catch: Throwable -> L124
        e.f10211a.a(r30, r24);     // Catch: Throwable -> L124
        if (r23 == true) goto L138;
    L140:
        String r31 = r52;
        f.a.C0502a r32 = r17;
        r4 = r19;
        boolean r33 = r45;
    L189:
        f.a r34 = f.f10213a;     // Catch: Throwable -> L156
        f.a(r31);     // Catch: Throwable -> L156
        f.a r35 = f.f10213a;     // Catch: Throwable -> L156
        f.a(r32);     // Catch: Throwable -> L156
        RunLog r37 = RunLog.INSTANCE;     // Catch: Throwable -> L156
        StringBuilder r38 = new StringBuilder().append("showIslandWidget: currentId=").append(f.a()).append(", currentContent.title=");     // Catch: Throwable -> L156
        if (r32 == null) goto L145;
        String r39 = r32.b();     // Catch: Throwable -> L156
        if (r39 == null) goto L145;
    L146:
        r37.debug(r110, r38.append(r39).toString());     // Catch: Throwable -> L156
        if (r33 == false) goto L151;
        RunLog.INSTANCE.debug(r110, "showIslandWidget: scheduling autoDismiss, interval=" + r111 + r22);     // Catch: Throwable -> L156
        f.a r40 = f.f10213a;     // Catch: Throwable -> L156
        this.L$0 = r4;     // Catch: Throwable -> L156
        this.L$1 = r3;     // Catch: Throwable -> L156
        this.L$2 = null;     // Catch: Throwable -> L156
        this.L$3 = null;     // Catch: Throwable -> L156
        this.L$4 = null;     // Catch: Throwable -> L156
        this.L$5 = null;     // Catch: Throwable -> L156
        this.L$6 = null;     // Catch: Throwable -> L156
        this.L$7 = null;     // Catch: Throwable -> L156
        this.label = 5;     // Catch: Throwable -> L156
        if (r40.a(r111, this) != r8) goto L151;
        return r8;
    L145:
        r39 = "null";
        goto L146
    L138:
        if (r30 != CollectionsKt.lastOrNull(f.e())) goto L140;
        RunLog.INSTANCE.debug(r110, "showIslandWidget: triggering effect for new session");     // Catch: Throwable -> L124
        f.f10213a.a();     // Catch: Throwable -> L124
    L124:
        th = th;
    L125:
        r4 = r19;
        goto L170
    L134:
        r29 = false;
        goto L135
    L130:
        r27 = false;
        goto L131
    L205:
        r25 = f.a.a(f.f10213a, r24);     // Catch: Throwable -> L124
    L20:
        th = th;
        r3 = r13;
    L32:
        r4 = r19;
        goto L33
    L22:
        long r41 = this.J$0;
        r33 = this.Z$0;
        CoroutineContext.Element r42 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(this.L$3, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
        r32 = (f.a.C0502a) ZeusTransformUtils.preCheckCast(this.L$2, f.a.C0502a.class, "com.obric.memorydata.plugin");
        String r113 = (String) ZeusTransformUtils.preCheckCast(this.L$1, String.class, "com.obric.memorydata.plugin");
        o r114 = (o) ZeusTransformUtils.preCheckCast(this.L$0, o.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r51);     // Catch: Throwable -> L25
        r22 = "ms";
        r8 = r2;
        long r43 = r41;
        r7 = "com.obric.memorydata.plugin";
        r110 = "IslandSessionUtilsGr";
        r31 = r113;
    L95:
        r3 = r42;
        r4 = r114;
        r111 = r43;
    L25:
        th = th;
        r3 = r42;
        r7 = "com.obric.memorydata.plugin";
        r4 = r114;
        goto L33
    L27:
        long r44 = this.J$0;
        boolean r46 = this.Z$0;
        Context r47 = (Context) ZeusTransformUtils.preCheckCast(this.L$7, Context.class, "com.obric.memorydata.plugin");
        CoroutineContext.Element r48 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(this.L$6, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
        String r115 = (String) ZeusTransformUtils.preCheckCast(this.L$5, String.class, "com.obric.memorydata.plugin");
        MemoryExpandedTemplate r116 = (MemoryExpandedTemplate) ZeusTransformUtils.preCheckCast(this.L$4, MemoryExpandedTemplate.class, "com.obric.memorydata.plugin");
        MemoryCollapseTemplate r117 = (MemoryCollapseTemplate) ZeusTransformUtils.preCheckCast(this.L$3, MemoryCollapseTemplate.class, "com.obric.memorydata.plugin");
        f.a.C0502a r118 = (f.a.C0502a) ZeusTransformUtils.preCheckCast(this.L$2, f.a.C0502a.class, "com.obric.memorydata.plugin");
        String r119 = (String) ZeusTransformUtils.preCheckCast(this.L$1, String.class, "com.obric.memorydata.plugin");
        r19 = (o) ZeusTransformUtils.preCheckCast(this.L$0, o.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r51);     // Catch: Throwable -> L30
        r22 = "ms";
        String r120 = "com.obric.memorydata.plugin";
        f.a.C0502a r49 = r118;
        r33 = r46;
        String r121 = r115;
        r110 = "IslandSessionUtilsGr";
        r31 = r119;
        r15 = r116;
        Object r50 = r2;
        MemoryCollapseTemplate r53 = r117;
        long r122 = r44;
    L60:
        Context r54 = r47;
        r4 = r19;
        CoroutineContext.Element r410 = r48;
        r32 = r49;
        r3 = r410;
    L207:
        f.a r55 = f.f10213a;     // Catch: Throwable -> L110
        f.a(System.currentTimeMillis());     // Catch: Throwable -> L110
        Object r123 = r50;
        r7 = r120;
        IslandSession r56 = (IslandSession) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(f.e()), IslandSession.class, r7);     // Catch: Throwable -> L107
        if (r56 == null) goto L102;
        long r210 = r122;
        CoroutineContext.Element r124 = r3;
        o r125 = r4;
        RunLog.INSTANCE.debug(r110, new StringBuilder().append("showIslandWidget: updating session taskId=").append(r56.getTaskId()).toString());     // Catch: Throwable -> L99
        r56.setTicker(r121);     // Catch: Throwable -> L99
        r56.setAodTitle(r121);     // Catch: Throwable -> L99
        if (r32 != null) goto L224;
    L80:
        IslandWidget r57 = r56.getCollapseWidget();     // Catch: Throwable -> L99
        if (r57 == null) goto L83;
        r57.setTemplateData((b) ZeusTransformUtils.preCheckCast(r53, b.class, r7));     // Catch: Throwable -> L78
        Unit r58 = Unit.INSTANCE;     // Catch: Throwable -> L78
    L83:
        IslandWidget r59 = r56.getExpandWidget();     // Catch: Throwable -> L99
        if (r59 == null) goto L86;
        r59.setTemplateData((b) ZeusTransformUtils.preCheckCast(r15, b.class, r7));     // Catch: Throwable -> L78
        Unit r60 = Unit.INSTANCE;     // Catch: Throwable -> L78
    L78:
        th = th;
        r3 = r124;
        r4 = r125;
    L109:
        r8 = r123;
    L86:
        RunLog.INSTANCE.debug(r110, "showIslandWidget: updated collapse+expand templateData, calling updateSession");     // Catch: Throwable -> L99
        e.f10211a.b(r56, r54);     // Catch: Throwable -> L99
        if (r33 == false) goto L98;
        RunLog.INSTANCE.debug(r110, "showIslandWidget: scheduling autoDismiss (update path)");     // Catch: Throwable -> L99
        f.a r61 = f.f10213a;     // Catch: Throwable -> L99
        o r126 = r125;
        this.L$0 = r126;     // Catch: Throwable -> L96
        this.L$1 = r31;     // Catch: Throwable -> L96
        this.L$2 = r32;     // Catch: Throwable -> L96
        this.L$3 = r124;     // Catch: Throwable -> L96
        this.L$4 = null;     // Catch: Throwable -> L96
        this.L$5 = null;     // Catch: Throwable -> L96
        this.L$6 = null;     // Catch: Throwable -> L96
        this.L$7 = null;     // Catch: Throwable -> L96
        this.Z$0 = r33;     // Catch: Throwable -> L96
        this.J$0 = r210;     // Catch: Throwable -> L96
        this.label = 3;     // Catch: Throwable -> L96
        r8 = r123;
        if (r61.a(r210, this) != r8) goto L94;
        return r8;
    L94:
        r43 = r210;
        r42 = r124;
        r114 = r126;
    L96:
        th = th;
    L101:
        r3 = r124;
        r4 = r126;
        goto L109
    L98:
        r19 = r125;
        r8 = r123;
        long r62 = r210;
    L104:
        long r411 = r62;
        r3 = r124;
        r111 = r411;
        r4 = r19;
        goto L189
    L224:
        if (r56.getIntent() != null) goto L80;
        r56.setIntent(f.a.a(f.f10213a, r54));     // Catch: Throwable -> L78
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, r7), "IslandSessionUtilsGr", "showIslandWidget: patched intent on update (BEGIN→SUCCESS)", false, 4, null);     // Catch: Throwable -> L78
    L99:
        th = th;
        r126 = r125;
        goto L101
    L102:
        r19 = r4;
        r8 = r123;
        r124 = r3;
        r62 = r122;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, r7), "IslandSessionUtilsGr", "showIslandWidget: no session in list to update!", null, 4, null);     // Catch: Throwable -> L105
    L105:
        th = th;
        r3 = r124;
    L107:
        th = th;
    L110:
        th = th;
        r8 = r50;
        r7 = r120;
    L30:
        th = th;
        r3 = r48;
        goto L32
    L34:
        long r63 = this.J$0;
        boolean r64 = this.Z$1;
        boolean r65 = this.Z$0;
        CoroutineContext.Element r66 = (CoroutineContext.Element) ZeusTransformUtils.preCheckCast(this.L$6, CoroutineContext.Element.class, "com.obric.memorydata.plugin");
        String r127 = (String) ZeusTransformUtils.preCheckCast(this.L$5, String.class, "com.obric.memorydata.plugin");
        MemoryExpandedTemplate r128 = (MemoryExpandedTemplate) ZeusTransformUtils.preCheckCast(this.L$4, MemoryExpandedTemplate.class, "com.obric.memorydata.plugin");
        MemoryCollapseTemplate r129 = (MemoryCollapseTemplate) ZeusTransformUtils.preCheckCast(this.L$3, MemoryCollapseTemplate.class, "com.obric.memorydata.plugin");
        f.a.C0502a r130 = (f.a.C0502a) ZeusTransformUtils.preCheckCast(this.L$2, f.a.C0502a.class, "com.obric.memorydata.plugin");
        String r131 = (String) ZeusTransformUtils.preCheckCast(this.L$1, String.class, "com.obric.memorydata.plugin");
        o r67 = (o) ZeusTransformUtils.preCheckCast(this.L$0, o.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r51);     // Catch: Exception -> L178
        String r132 = "IslandSessionUtilsGr";
        o r68 = r67;
        String r69 = r131;
        r15 = r128;
        r3 = r66;
        r16 = r129;
        boolean r133 = r64;
        boolean r134 = r65;
        r17 = r130;
        r121 = r127;
    L216:
        Context r135 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.f10211a.b(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L167
        boolean r510 = r134;
        r123 = r2;
        r110 = r132;
        RunLog.INSTANCE.debug(r110, "showIslandWidget: acquired mutex, ctx.pkg=" + r135.getPackageName());     // Catch: Throwable -> L162
        if (Intrinsics.areEqual(r69, f.a()) == true) goto L220;
        r21 = r133;
        long r412 = r63;
        r7 = "com.obric.memorydata.plugin";
        r24 = r135;
        r8 = r123;
        r111 = r412;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, r7), "IslandSessionUtilsGr", "showIslandWidget: CREATING new island, id=" + r69 + " (old=" + f.a() + ')', false, 4, null);     // Catch: Throwable -> L158
        f.a r70 = f.f10213a;     // Catch: Throwable -> L158
        f.a(System.currentTimeMillis());     // Catch: Throwable -> L158
        RunLog.INSTANCE.debug(r110, "showIslandWidget: destroying old sessions");     // Catch: Throwable -> L158
        f.a r71 = f.f10213a;     // Catch: Throwable -> L158
        this.L$0 = r68;     // Catch: Throwable -> L158
        this.L$1 = r69;     // Catch: Throwable -> L158
        this.L$2 = r17;     // Catch: Throwable -> L158
        this.L$3 = r16;     // Catch: Throwable -> L158
        this.L$4 = r15;     // Catch: Throwable -> L158
        this.L$5 = r121;     // Catch: Throwable -> L158
        this.L$6 = r3;     // Catch: Throwable -> L158
        this.L$7 = r24;     // Catch: Throwable -> L158
        this.Z$0 = r510;     // Catch: Throwable -> L158
        this.Z$1 = r21;     // Catch: Throwable -> L158
        this.J$0 = r111;     // Catch: Throwable -> L158
        String r136 = r69;
        this.label = 4;     // Catch: Throwable -> L158
        Object r72 = r71.a(this);     // Catch: Throwable -> L158
        r8 = r123;
        if (r72 != r8) goto L121;
        return r8;
    L121:
        r36 = r121;
        r20 = r136;
        r19 = r68;
        r23 = r510;
    L158:
        th = th;
    L166:
        r8 = r123;
    L169:
        r4 = r68;
    L160:
        th = th;
        goto L169
    L220:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandSessionUtilsGr", "showIslandWidget: UPDATING existing island, id=" + r69, false, 4, null);     // Catch: Throwable -> L112
        long r211 = r63;
        long r73 = (f.d() + 1000) - System.currentTimeMillis();
        if (r73 > 0) goto L214;
        r120 = "com.obric.memorydata.plugin";
        r54 = r135;
        r50 = r123;
        r122 = r211;
        o r413 = r68;
        r31 = r69;
        r33 = r133;
        r53 = r16;
        r32 = r17;
        r4 = r413;
        goto L207
    L214:
        r120 = "com.obric.memorydata.plugin";
        RunLog.INSTANCE.debug(r110, "showIslandWidget: throttling update, waiting " + r73 + "ms");     // Catch: Throwable -> L61
        this.L$0 = r68;     // Catch: Throwable -> L61
        this.L$1 = r69;     // Catch: Throwable -> L61
        this.L$2 = r17;     // Catch: Throwable -> L61
        this.L$3 = r16;     // Catch: Throwable -> L61
        this.L$4 = r15;     // Catch: Throwable -> L61
        this.L$5 = r121;     // Catch: Throwable -> L61
        this.L$6 = r3;     // Catch: Throwable -> L61
        this.L$7 = r135;     // Catch: Throwable -> L61
        this.Z$0 = r133;     // Catch: Throwable -> L61
        boolean r74 = r133;
        r122 = r211;
        this.J$0 = r122;     // Catch: Throwable -> L61
        r22 = "ms";
        this.label = 2;     // Catch: Throwable -> L61
        r50 = r123;
        if (au.a(r73, this) != r50) goto L59;
        return r50;
    L59:
        r19 = r68;
        r31 = r69;
        r33 = r74;
        r53 = r16;
        r48 = r3;
        r49 = r17;
        r47 = r135;
    L61:
        th = th;
        r4 = r68;
        r7 = r120;
    L63:
        th = th;
        r7 = "com.obric.memorydata.plugin";
    L114:
        r4 = r68;
    L112:
        th = th;
        r7 = "com.obric.memorydata.plugin";
    L162:
        th = th;
        r7 = "com.obric.memorydata.plugin";
    L164:
        th = th;
        r7 = "com.obric.memorydata.plugin";
    L167:
        th = th;
        r7 = "com.obric.memorydata.plugin";
        r8 = r2;
        goto L169
    L37:
        ResultKt.throwOnFailure(r51);
        o r75 = f.c();     // Catch: Exception -> L178
        String r76 = this.$id;     // Catch: Exception -> L178
        f.a.C0502a r77 = this.$content;     // Catch: Exception -> L178
        MemoryCollapseTemplate r78 = this.$collapseWidgetData;     // Catch: Exception -> L178
        MemoryExpandedTemplate r79 = this.$expandWidgetData;     // Catch: Exception -> L178
        String r137 = this.$collapseTitle;     // Catch: Exception -> L178
        boolean r138 = this.$needEffect;     // Catch: Exception -> L178
        r133 = this.$needDismiss;     // Catch: Exception -> L178
        long r139 = this.$dismissInterval;     // Catch: Exception -> L178
        r132 = "IslandSessionUtilsGr";
        r3 = getContext().get((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(bx.f17252a, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L176
        Continuation<? super Unit> r80 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L176
        this.L$0 = r75;     // Catch: Exception -> L176
        this.L$1 = r76;     // Catch: Exception -> L176
        this.L$2 = r77;     // Catch: Exception -> L176
        this.L$3 = r78;     // Catch: Exception -> L176
        this.L$4 = r79;     // Catch: Exception -> L176
        this.L$5 = r137;     // Catch: Exception -> L176
        this.L$6 = r3;     // Catch: Exception -> L176
        this.Z$0 = r138;     // Catch: Exception -> L176
        this.Z$1 = r133;     // Catch: Exception -> L176
        this.J$0 = r139;     // Catch: Exception -> L176
        this.label = 1;     // Catch: Exception -> L176
        if (r75.a(r3, r80) != r2) goto L43;
        return r2;
    L43:
        r68 = r75;
        r69 = r76;
        r17 = r77;
        r16 = r78;
        r15 = r79;
        r121 = r137;
        r134 = r138;
        r63 = r139;
    L176:
        e = e;
        String r140 = r132;
    L180:
        RunLog.INSTANCE.error(r140, "showIslandWidget: EXCEPTION: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, r7));
        f.a r81 = f.f10213a;     // Catch: Exception -> L183
        f.a("");     // Catch: Exception -> L183
        f.a r82 = f.f10213a;     // Catch: Exception -> L183
        f.a(null);     // Catch: Exception -> L183
        RunLog.INSTANCE.debug(r140, "showIslandWidget: cleaned up after error");     // Catch: Exception -> L183
    L183:
        e = move-exception;
        RunLog.INSTANCE.error(r140, "showIslandWidget: cleanup error: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        goto L186
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L174:
        e = e;
    L178:
        e = e;
        r140 = "IslandSessionUtilsGr";
        goto L180
    }
}
