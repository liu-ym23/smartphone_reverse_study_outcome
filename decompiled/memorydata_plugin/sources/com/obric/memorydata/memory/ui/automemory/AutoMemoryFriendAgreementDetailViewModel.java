package com.obric.memorydata.memory.ui.automemory;

import androidx.lifecycle.ViewModel;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.entity.AutoMemoryProEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.TemporalAccessor;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryFriendAgreementDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/memorydata/memory/ui/automemory/AutoMemoryFriendAgreementDetailUiState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "load", "", OaidModel.KEY_ID, "", "formatDateTime", "", "timestamp", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutoMemoryFriendAgreementDetailViewModel extends ViewModel {
    private final ae<i> _state;
    private final ar<i> state;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.automemory.AutoMemoryFriendAgreementDetailViewModel$load$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.automemory.AutoMemoryFriendAgreementDetailViewModel$load$1", f = "AutoMemoryDetailActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $id;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AutoMemoryFriendAgreementDetailViewModel this$0;

        AnonymousClass1(long r3, AutoMemoryFriendAgreementDetailViewModel r5, Continuation<? super AnonymousClass1> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.$id = r3;
            this.this$0 = r5;
            super(2, r7);
        }

        private static final Unit invokeSuspend$lambda$3(AutoMemoryFriendAgreementDetailViewModel r10, AutoMemoryProEntity r11, String r12) {
            ae r0 = AutoMemoryFriendAgreementDetailViewModel.access$get_state$p(r10);
        L3:
            Object r1 = r0.c();
            i r2 = (i) ZeusTransformUtils.preCheckCast(r1, i.class, "com.obric.memorydata.plugin");
            String r5 = String.valueOf(r11.getId());
            String r6 = r11.getTitle();
            String r8 = r11.getContent();
            if (r0.a(r1, new i(r5, r6, AutoMemoryFriendAgreementDetailViewModel.access$formatDateTime(r10, r11.getModifyTime()), r8, r12)) == false) goto L3;
            return Unit.INSTANCE;
        }

        public static /* synthetic */ Unit lambda$Pr7tEopzYVCcI9mLcm33zQryzK8(AutoMemoryFriendAgreementDetailViewModel r0, AutoMemoryProEntity r1, String r2) {
            return invokeSuspend$lambda$3(r0, r1, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass1 r0 = new AnonymousClass1(this.$id, this.this$0, r7);
            r0.L$0 = r5;
            return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r35) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L27;
            ResultKt.throwOnFailure(r35);
            al r0 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
            long r4 = this.$id;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
            Object r2 = Result.m1421constructorimpl((AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProDao().queryById(r4), AutoMemoryProEntity.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L7
        L9:
            Object r5 = null;
            if (Result.m1427isFailureimpl(r2) == false) goto L12;
            r2 = null;
        L12:
            final AutoMemoryProEntity r3 = (AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(r2, AutoMemoryProEntity.class, "com.obric.memorydata.plugin");
            if (r3 != null) goto L15;
            r3 = new AutoMemoryProEntity(0, null, 0, 0, 0, null, 0, null, 0, 0, null, null, null, null, null, 0, null, null, null, null, null, 2097151, null);
        L15:
            Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r3.getPackageNames(), CharSequence.class, "com.obric.memorydata.plugin"), new char[]{',', ';'}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin")).iterator();
        L17:
            if (r6.hasNext() == false) goto L21;
            Object r7 = r6.next();
            if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin"), CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L17;
            r5 = r7;
        L21:
            String r8 = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
            if (r8 != null) goto L24;
            r8 = "";
        L24:
            final String r9 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin")).toString();
            final AutoMemoryFriendAgreementDetailViewModel r10 = this.this$0;
            com.obric.memorydata.utils.j.a(new $$Lambda$AutoMemoryFriendAgreementDetailViewModel$load$1$Pr7tEopzYVCcI9mLcm33zQryzK8(r10, r3, r9));
            return Unit.INSTANCE;
        L7:
            th = move-exception;
            Result.Companion r11 = Result.Companion;
            r2 = Result.m1421constructorimpl(ResultKt.createFailure(th));
            goto L9
        L27:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AutoMemoryFriendAgreementDetailViewModel() {
        ae<i> r0 = at.a(new i(null, null, null, null, null, 31, null));
        this._state = r0;
        this.state = kotlinx.coroutines.flow.k.a(r0);
    }

    public static final /* synthetic */ String access$formatDateTime(AutoMemoryFriendAgreementDetailViewModel r0, long r1) {
        return r0.formatDateTime(r1);
    }

    public static final /* synthetic */ ae access$get_state$p(AutoMemoryFriendAgreementDetailViewModel r0) {
        return r0._state;
    }

    private final String formatDateTime(long r3) {
        if (r3 > 0) goto L6;
        return "";
    L6:
        String r2 = g.a().format((TemporalAccessor) ZeusTransformUtils.preCheckCast(Instant.ofEpochMilli(r3).atZone(ZoneId.systemDefault()), TemporalAccessor.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r2, "format(...)");
        return r2;
    }

    public final ar<i> getState() {
        return this.state;
    }

    public final void load(long r10) {
        kotlinx.coroutines.i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r10, this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }
}
