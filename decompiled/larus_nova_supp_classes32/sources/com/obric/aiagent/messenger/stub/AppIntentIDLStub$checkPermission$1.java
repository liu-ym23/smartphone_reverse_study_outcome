package com.obric.aiagent.messenger.stub;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.MessageContentType;
import com.obric.aivoice.core.data.NameKeys;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.AppIntentIDLStub$checkPermission$1", f = "AppIntentIDLStub.kt", i = {}, l = {65, 69}, m = "invokeSuspend", n = {}, s = {})
public final class AppIntentIDLStub$checkPermission$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $permission;
    final /* synthetic */ long $timeOut;
    final /* synthetic */ boolean $tryRequest;
    int label;
    final /* synthetic */ AppIntentIDLStub this$0;

    /* JADX INFO: renamed from: com.obric.aiagent.messenger.stub.AppIntentIDLStub$checkPermission$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.aiagent.messenger.stub.AppIntentIDLStub$checkPermission$1$1", f = "AppIntentIDLStub.kt", i = {}, l = {MessageContentType.CONTENT_TYPE_MULTI_CONTENT}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ String $permission;
        final /* synthetic */ boolean $tryRequest;
        int label;
        final /* synthetic */ AppIntentIDLStub this$0;

        public AnonymousClass1(AppIntentIDLStub r1, String r2, boolean r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$permission = r2;
            this.$tryRequest = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$permission, this.$tryRequest, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            AppIntentIDLStub r6 = this.this$0;
            String r2 = this.$permission;
            boolean r3 = this.$tryRequest;
            this.label = 1;
            r5 = AppIntentIDLStub.access$handleCheckPermission(r6, r2, r3, this);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    public AppIntentIDLStub$checkPermission$1(String r1, AppIntentIDLStub r2, boolean r3, long r4, Continuation<? super AppIntentIDLStub$checkPermission$1> r6) {
        this.$permission = r1;
        this.this$0 = r2;
        this.$tryRequest = r3;
        this.$timeOut = r4;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new AppIntentIDLStub$checkPermission$1(this.$permission, this.this$0, this.$tryRequest, this.$timeOut, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r9);
    L23:
        if (((Boolean) r9).booleanValue() == true) goto L27;
        r3 = false;
    L27:
        return Boxing.boxBoolean(r3);
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r9);
    L18:
        r3 = Intrinsics.areEqual(r9, Boxing.boxBoolean(true));
        goto L27
    L10:
        ResultKt.throwOnFailure(r9);
        String r10 = this.$permission;
        if (r10 == null) goto L13;
        r10.length();
    L13:
        FLogger.a.i(AppIntentIDLStub.access$getTAG$p(this.this$0), "checkPermission, " + this.$permission + ", tryRequest:" + this.$tryRequest + ", timeout:" + this.$timeOut);
        long r4 = this.$timeOut;
        if (r4 == 0) goto L19;
        AnonymousClass1 r11 = new AnonymousClass1(this.this$0, this.$permission, this.$tryRequest, null);
        this.label = 1;
        r9 = TimeoutKt.c(r4, r11, this);
        if (r9 != r0) goto L18;
        return r0;
    L19:
        AppIntentIDLStub r12 = this.this$0;
        String r2 = this.$permission;
        boolean r5 = this.$tryRequest;
        this.label = 2;
        r9 = AppIntentIDLStub.access$handleCheckPermission(r12, r2, r5, this);
        if (r9 != r0) goto L23;
        return r0;
    }
}
