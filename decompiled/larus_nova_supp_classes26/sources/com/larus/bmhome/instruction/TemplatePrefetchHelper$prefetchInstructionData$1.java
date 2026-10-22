package com.larus.bmhome.instruction;

import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import com.larus.uaigc.creation.ICreationService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.TemplatePrefetchHelper$prefetchInstructionData$1", f = "TemplatePrefetchHelper.kt", i = {0}, l = {40}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class TemplatePrefetchHelper$prefetchInstructionData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<com.larus.bmhome.actionbar.model.z0> $cacheConfig;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.instruction.TemplatePrefetchHelper$prefetchInstructionData$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.instruction.TemplatePrefetchHelper$prefetchInstructionData$1$2", f = "TemplatePrefetchHelper.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ com.larus.bmhome.actionbar.model.z0 $digitalAvatarItem;
        int label;

        public AnonymousClass2(com.larus.bmhome.actionbar.model.z0 r1, Continuation<? super AnonymousClass2> r2) {
            this.$digitalAvatarItem = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.$digitalAvatarItem, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L23:
            String r5 = (String) r4;
        L25:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            com.larus.bmhome.actionbar.model.r r6 = this.$digitalAvatarItem.q;
            if (r6 == null) goto L11;
            boolean r7 = Intrinsics.areEqual(r6.j, Boxing.boxBoolean(true));
        L12:
            if (r7 == false) goto L25;
            Integer r8 = this.$digitalAvatarItem.g;
            int r2 = ActionBarExecutionType.OPEN_BY_SCHEMA.getValue();
            if (r8 != null) goto L17;
        L18:
            ICreationService r9 = (ICreationService) ServiceManager.get().getService(ICreationService.class);
            if (r9 == null) goto L25;
            this.label = 1;
            r4 = r9.a(this);
            if (r4 != r0) goto L23;
            return r0;
        L17:
            if (r8.intValue() == r2) goto L25;
        L11:
            r7 = false;
            goto L12
        }
    }

    public TemplatePrefetchHelper$prefetchInstructionData$1(List<com.larus.bmhome.actionbar.model.z0> r1, Continuation<? super TemplatePrefetchHelper$prefetchInstructionData$1> r2) {
        this.$cacheConfig = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        TemplatePrefetchHelper$prefetchInstructionData$1 r0 = new TemplatePrefetchHelper$prefetchInstructionData$1(this.$cacheConfig, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r10);
        CoroutineScope r3 = r2;
    L12:
        List<com.larus.bmhome.actionbar.model.z0> r11 = this.$cacheConfig;
        if (r11 == null) goto L36;
        List<com.larus.bmhome.actionbar.model.z0> r12 = r11;
        if ((r12 instanceof Collection) == true) goto L17;
    L19:
        Iterator<T> r13 = r12.iterator();
    L21:
        if (r13.hasNext() == false) goto L33;
        com.larus.bmhome.actionbar.model.r r4 = ((com.larus.bmhome.actionbar.model.z0) r13.next()).q;
        if (r4 == null) goto L30;
        Integer r5 = r4.a;
        if (r5 == null) goto L30;
        if (r5.intValue() != 4) goto L30;
        boolean r6 = true;
    L31:
        if (r6 == false) goto L21;
        boolean r14 = true;
    L34:
        if (r14 != true) goto L36;
        boolean r15 = true;
    L38:
        if (r15 == false) goto L40;
        com.larus.platform.service.e0.a.e(2, false, null);
    L40:
        List<com.larus.bmhome.actionbar.model.z0> r16 = this.$cacheConfig;
        if (r16 == null) goto L58;
        Iterator<T> r17 = r16.iterator();
    L44:
        if (r17.hasNext() == false) goto L56;
        Object r7 = r17.next();
        com.larus.bmhome.actionbar.model.r r8 = ((com.larus.bmhome.actionbar.model.z0) r7).q;
        if (r8 == null) goto L53;
        Integer r9 = r8.a;
        if (r9 == null) goto L53;
        if (r9.intValue() != 11) goto L53;
        boolean r18 = true;
    L54:
        if (r18 == false) goto L44;
    L57:
        com.larus.bmhome.actionbar.model.z0 r19 = (com.larus.bmhome.actionbar.model.z0) r7;
    L59:
        if (r19 == null) goto L62;
        com.larus.platform.service.e0.a.e(3, false, null);
        BuildersKt.launch$default(r3, null, null, new AnonymousClass2(r19, null), 3, null);
    L62:
        return Unit.INSTANCE;
    L53:
        r18 = false;
        goto L54
    L56:
        r7 = null;
        goto L57
    L58:
        r19 = null;
    L30:
        r6 = false;
    L33:
        r14 = false;
        goto L34
    L17:
        if (r12.isEmpty() == false) goto L19;
    L36:
        r15 = false;
        goto L38
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        CoroutineScope r110 = (CoroutineScope) this.L$0;
        this.L$0 = r110;
        this.label = 1;
        if (DelayKt.delay(200, this) != r0) goto L11;
        return r0;
    L11:
        r3 = r110;
        goto L12
    }
}
