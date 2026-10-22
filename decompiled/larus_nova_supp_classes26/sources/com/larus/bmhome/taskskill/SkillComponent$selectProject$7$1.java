package com.larus.bmhome.taskskill;

import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.bmhome.taskskill.view.PcConnectionStatusManager;
import com.larus.dispatcher.api.AllDeviceResponse;
import com.larus.dispatcher.api.GetAllDevicesRepo;
import com.larus.im.bean.message.AgentTaskParamChange;
import com.larus.platform.service.AccountService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.SkillComponent$selectProject$7$1", f = "SkillComponent.kt", i = {}, l = {1875}, m = "invokeSuspend", n = {}, s = {})
public final class SkillComponent$selectProject$7$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ long $restoreGeneration;
    final /* synthetic */ String $restoreOwnerUserId;
    final /* synthetic */ String $restoredDeviceId;
    int label;
    final /* synthetic */ SkillComponent this$0;

    public SkillComponent$selectProject$7$1(String r1, SkillComponent r2, long r3, String r5, String r6, Continuation<? super SkillComponent$selectProject$7$1> r7) {
        this.$restoreOwnerUserId = r1;
        this.this$0 = r2;
        this.$restoreGeneration = r3;
        this.$conversationId = r5;
        this.$restoredDeviceId = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new SkillComponent$selectProject$7$1(this.$restoreOwnerUserId, this.this$0, this.$restoreGeneration, this.$conversationId, this.$restoredDeviceId, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r23) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r23);
        Object r3 = r23;
    L11:
        AllDeviceResponse r4 = (AllDeviceResponse) r3;
        if (r4 != null) goto L16;
        return Unit.INSTANCE;
    L16:
        if (Intrinsics.areEqual(AccountService.a.getSecUserId(), this.$restoreOwnerUserId) == false) goto L139;
        SkillComponent r5 = this.this$0;
        if (r5.L0 != this.$restoreGeneration) goto L139;
        if (r5.yW() == false) goto L139;
        if (Intrinsics.areEqual(this.this$0.Z3(), this.$conversationId) == false) goto L139;
        if (Intrinsics.areEqual(this.this$0.w5(), this.$restoredDeviceId) == false) goto L139;
        List r6 = r4.getDevices();
        if (r6 != null) goto L28;
        r6 = CollectionsKt.emptyList();
    L28:
        List r7 = r6;
        String r8 = this.$restoredDeviceId;
        boolean r9 = false;
        if ((r7 instanceof Collection) == true) goto L31;
    L33:
        Iterator r10 = r7.iterator();
    L35:
        if (r10.hasNext() == false) goto L43;
        PcDevice r11 = (PcDevice) r10.next();
        if (r11 == null) goto L39;
        String r12 = r11.getDeviceId();
    L41:
        if (Intrinsics.areEqual(r12, r8) == false) goto L35;
        boolean r13 = true;
    L44:
        if (r13 == true) goto L139;
        be8.c r14 = this.this$0.YF();
        SkillComponent r15 = this.this$0;
        be8.c r16 = r15.k0;
        if (r16 == null) goto L58;
        String r17 = this.$conversationId;
        String r18 = this.$restoreOwnerUserId;
        long r19 = this.$restoreGeneration;
        if (Intrinsics.areEqual(r15.p0, r17) == true) goto L51;
    L55:
        boolean r20 = false;
    L56:
        if (r20 == false) goto L58;
    L59:
        List r21 = CollectionsKt.plus(r14.i, r14.j);
        if (r16 == null) goto L62;
        List r22 = r16.i;
    L63:
        if (r22 != null) goto L65;
        r22 = CollectionsKt.emptyList();
    L65:
        List r24 = CollectionsKt.plus(r21, r22);
        if (r16 == null) goto L68;
        List r25 = r16.j;
    L69:
        if (r25 != null) goto L71;
        r25 = CollectionsKt.emptyList();
    L71:
        Set r26 = CollectionsKt.toSet(CollectionsKt.plus(r24, r25));
        List r27 = r14.b;
        if (r16 == null) goto L74;
        List r28 = r16.b;
    L75:
        if (r28 != null) goto L77;
        r28 = CollectionsKt.emptyList();
    L77:
        List r29 = CollectionsKt.plus(r27, r28);
        HashSet r30 = new HashSet();
        ArrayList r31 = new ArrayList();
        Iterator r32 = r29.iterator();
    L79:
        if (r32.hasNext() == false) goto L83;
        Object r110 = r32.next();
        if (r30.add(((be8.b) r110).a) == false) goto L79;
        r31.add(r110);
        goto L79
    L83:
        ArrayList r33 = new ArrayList();
        Iterator r34 = r31.iterator();
    L85:
        if (r34.hasNext() == false) goto L89;
        Object r35 = r34.next();
        if (r26.contains(((be8.b) r35).a) == false) goto L85;
        r33.add(r35);
        goto L85
    L89:
        List r36 = r14.d;
        if (r16 == null) goto L92;
        List r37 = r16.d;
    L93:
        if (r37 != null) goto L95;
        r37 = CollectionsKt.emptyList();
    L95:
        List r38 = CollectionsKt.plus(r36, r37);
        ArrayList r39 = new ArrayList();
        Iterator r40 = r38.iterator();
    L97:
        if (r40.hasNext() == false) goto L101;
        Object r111 = r40.next();
        if (r26.contains((String) r111) == false) goto L97;
        r39.add(r111);
        goto L97
    L101:
        List r112 = CollectionsKt.distinct(r39);
        this.this$0.m.b(null);
        SkillComponent r41 = this.this$0;
        r41.v1 = null;
        r41.x1 = false;
        r41.y1 = new AgentTaskParamChange(false, false, false, 7, null);
        SkillComponent r113 = this.this$0;
        long r114 = r113.L0 + 1;
        r113.L0 = r114;
        if ((!r33.isEmpty()) == false) goto L104;
        ArrayList r42 = r33;
    L105:
        if (r42 == null) goto L119;
        Set r43 = r26;
        List r44 = r14.i;
        if (r16 == null) goto L109;
        List r45 = r16.i;
    L110:
        if (r45 != null) goto L112;
        r45 = CollectionsKt.emptyList();
    L112:
        List r115 = CollectionsKt.toList(CollectionsKt.intersect(r43, CollectionsKt.toSet(CollectionsKt.plus(r44, r45))));
        List r46 = r14.j;
        if (r16 == null) goto L115;
        List r47 = r16.j;
    L116:
        if (r47 != null) goto L118;
        r47 = CollectionsKt.emptyList();
    L118:
        be8.c r48 = be8.c.a(r14, false, r33, false, r112, r115, CollectionsKt.toList(CollectionsKt.intersect(r43, CollectionsKt.toSet(CollectionsKt.plus(r46, r47)))), 5);
    L120:
        r113.k0 = r48;
        SkillComponent r49 = this.this$0;
        String r50 = this.$conversationId;
        be8.c r51 = r49.k0;
        if (r51 == null) goto L123;
        boolean r52 = true;
    L124:
        if (r52 == false) goto L126;
        String r53 = r50;
    L127:
        r49.p0 = r53;
        String r54 = this.$restoreOwnerUserId;
        if (r51 == null) goto L130;
        r9 = true;
    L130:
        if (r9 == true) goto L133;
        r54 = null;
    L133:
        r49.H0 = r54;
        r49.P0 = null;
        r49.V0 = null;
        r49.b1 = null;
        ConcurrentHashMap r55 = j2.a;
        j2.d(r50);
        this.this$0.s5(this.$conversationId, r114, CollectionsKt.emptyList(), false);
        this.this$0.q5();
        PcConnectionStatusManager r56 = this.this$0.j4();
        if (r56 == null) goto L136;
        r56.c(null, "restoreModeDraftDeviceDeleted");
    L136:
        this.this$0.KY();
        this.this$0.T4(true);
        this.this$0.V4();
        return Unit.INSTANCE;
    L126:
        r53 = null;
        goto L127
    L123:
        r52 = false;
        goto L124
    L115:
        r47 = null;
        goto L116
    L109:
        r45 = null;
        goto L110
    L119:
        r48 = null;
        goto L120
    L104:
        r42 = null;
        goto L105
    L92:
        r37 = null;
        goto L93
    L74:
        r28 = null;
        goto L75
    L68:
        r25 = null;
        goto L69
    L62:
        r22 = null;
        goto L63
    L51:
        if (Intrinsics.areEqual(r15.H0, r18) == false) goto L55;
        if (r15.L0 != r19) goto L55;
        r20 = true;
    L58:
        r16 = null;
        goto L59
    L39:
        r12 = null;
    L43:
        r13 = false;
        goto L44
    L31:
        if (r7.isEmpty() == false) goto L33;
    L139:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r23);
        GetAllDevicesRepo r57 = GetAllDevicesRepo.a;
        this.label = 1;
        r3 = GetAllDevicesRepo.e("SkillComponent.restoreModeDraft", this);
        if (r3 != r1) goto L11;
        return r1;
    }
}
