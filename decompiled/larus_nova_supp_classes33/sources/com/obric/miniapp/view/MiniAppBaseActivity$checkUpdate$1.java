package com.obric.miniapp.view;

import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.resource.AIManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.view.MiniAppBaseActivity$checkUpdate$1", f = "MiniAppBaseActivity.kt", i = {}, l = {611}, m = "invokeSuspend", n = {}, s = {})
final class MiniAppBaseActivity$checkUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MiniAppBaseActivity this$0;

    /* JADX INFO: renamed from: com.obric.miniapp.view.MiniAppBaseActivity$checkUpdate$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.miniapp.view.MiniAppBaseActivity$checkUpdate$1$1", f = "MiniAppBaseActivity.kt", i = {}, l = {612, 613, 616}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MiniAppBaseActivity this$0;

        public AnonymousClass1(MiniAppBaseActivity r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            boolean r4 = true;
            if (r1 == 0) goto L12;
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L10;
            if (r1 != 3) goto L9;
            ResultKt.throwOnFailure(r7);
        L37:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r7);
        L20:
            Integer r8 = (Integer) r7;
            if (r8 != null) goto L24;
        L28:
            r4 = false;
        L29:
            if (r4 == false) goto L37;
            MiniAppBaseActivity r9 = this.this$0;
            this.label = 3;
            int r2 = MiniAppBaseActivity.r;
            r9.getClass();
            Object r10 = BuildersKt.withContext(Dispatchers.getMain(), new MiniAppBaseActivity$showUpdateDialog$2(r9, null), this);
            if (r10 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L34;
            r10 = Unit.INSTANCE;
        L34:
            if (r10 != r0) goto L37;
            return r0;
        L24:
            if (r8.intValue() != 2) goto L28;
            AppletRuntimeManager r11 = AppletRuntimeManager.INSTANCE;
            String r3 = this.this$0.j;
            r11.getClass();
            if (AppletRuntimeManager.i("SYSTEM_CVS_ID", "SYSTEM_CVS_ID", r3) == null) goto L28;
        L11:
            ResultKt.throwOnFailure(r7);
        L16:
            if (((Boolean) r7).booleanValue() == false) goto L28;
            AIManager r12 = AIManager.a;
            String r5 = this.this$0.j;
            this.label = 2;
            r7 = r12.p(r5, this);
            if (r7 != r0) goto L20;
            return r0;
        L12:
            ResultKt.throwOnFailure(r7);
            AIManager r13 = AIManager.a;
            String r6 = this.this$0.j;
            AIPackage.AIPackageType r14 = AIPackage.AIPackageType.APPLET;
            this.label = 1;
            r7 = r13.r(r6, r14, this);
            if (r7 != r0) goto L16;
            return r0;
        }
    }

    public MiniAppBaseActivity$checkUpdate$1(MiniAppBaseActivity r1, Continuation<? super MiniAppBaseActivity$checkUpdate$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MiniAppBaseActivity$checkUpdate$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CoroutineDispatcher r7 = Dispatchers.getIO();
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (BuildersKt.withContext(r7, r2, this) != r0) goto L12;
        return r0;
    }
}
