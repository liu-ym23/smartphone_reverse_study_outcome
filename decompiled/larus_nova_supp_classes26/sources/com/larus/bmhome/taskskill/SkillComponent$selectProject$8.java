package com.larus.bmhome.taskskill;

import com.larus.bmhome.taskskill.view.PcConnectionStatusManager;
import com.larus.folder.FolderPanelRepository;
import com.larus.folder.m;
import com.larus.platform.service.AccountService;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.SkillComponent$selectProject$8", f = "SkillComponent.kt", i = {}, l = {1987}, m = "invokeSuspend", n = {}, s = {})
public final class SkillComponent$selectProject$8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ long $restoreGeneration;
    final /* synthetic */ String $restoreOwnerUserId;
    final /* synthetic */ String $restoredDeviceId;
    final /* synthetic */ be8.e $restoredFolder;
    int label;
    final /* synthetic */ SkillComponent this$0;

    public SkillComponent$selectProject$8(String r1, String r2, SkillComponent r3, long r4, String r6, be8.e r7, Continuation<? super SkillComponent$selectProject$8> r8) {
        this.$restoredDeviceId = r1;
        this.$restoreOwnerUserId = r2;
        this.this$0 = r3;
        this.$restoreGeneration = r4;
        this.$conversationId = r6;
        this.$restoredFolder = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new SkillComponent$selectProject$8(this.$restoredDeviceId, this.$restoreOwnerUserId, this.this$0, this.$restoreGeneration, this.$conversationId, this.$restoredFolder, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        m.c r12 = (m) r11;
        if ((r12 instanceof m.c) == false) goto L56;
        if (Intrinsics.areEqual(AccountService.a.getSecUserId(), this.$restoreOwnerUserId) == false) goto L56;
        SkillComponent r2 = this.this$0;
        if (r2.L0 != this.$restoreGeneration) goto L56;
        if (r2.yW() == false) goto L56;
        if (Intrinsics.areEqual(this.this$0.Z3(), this.$conversationId) == false) goto L56;
        if (Intrinsics.areEqual(this.this$0.w5(), this.$restoredDeviceId) == false) goto L56;
        bs8.a r3 = this.this$0.v1;
        bs8.a r4 = null;
        if (r3 == null) goto L26;
        be8.e r5 = x1.a(r3);
    L28:
        if (Intrinsics.areEqual(r5, this.$restoredFolder) == false) goto L56;
        List r13 = r12.a;
        be8.e r6 = this.$restoredFolder;
        boolean r7 = false;
        if ((r13 instanceof Collection) == true) goto L32;
    L34:
        Iterator r14 = r13.iterator();
    L36:
        if (r14.hasNext() == false) goto L45;
        com.larus.folder.j r8 = (com.larus.folder.j) r14.next();
        if (Intrinsics.areEqual(r8.a, r6.a) == true) goto L40;
    L42:
        boolean r9 = false;
    L43:
        if (r9 == false) goto L36;
        r7 = true;
        goto L45
    L40:
        if (Intrinsics.areEqual(r8.b, r6.b) == false) goto L42;
        r9 = true;
    L45:
        if (r7 == true) goto L56;
        SkillComponent r15 = this.this$0;
        bs8.a r10 = r15.v1;
        if (r10 == null) goto L50;
        r4 = bs8.a.a(r10, null, null, null, null, null, 117);
    L50:
        r15.v1 = r4;
        PcConnectionStatusManager r16 = this.this$0.j4();
        if (r16 == null) goto L53;
        r16.c(this.this$0.v1, "restoreModeDraftFolderDeleted");
    L53:
        this.this$0.KY();
        this.this$0.T4(true);
        return Unit.INSTANCE;
    L32:
        if (r13.isEmpty() == false) goto L34;
    L26:
        r5 = null;
    L56:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        FolderPanelRepository r17 = FolderPanelRepository.a;
        String r18 = this.$restoredDeviceId;
        this.label = 1;
        r11 = r17.e(r18, this);
        if (r11 != r0) goto L11;
        return r0;
    }
}
