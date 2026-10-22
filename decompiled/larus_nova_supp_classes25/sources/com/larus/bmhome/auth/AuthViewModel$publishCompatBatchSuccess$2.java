package com.larus.bmhome.auth;

import com.google.gson.Gson;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.auth.AuthViewModel$publishCompatBatchSuccess$2", f = "AuthViewModel.kt", i = {}, l = {1424}, m = "invokeSuspend", n = {}, s = {})
final class AuthViewModel$publishCompatBatchSuccess$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ b $audio;
    final /* synthetic */ e0 $basic;
    final /* synthetic */ f1$b$c $completion;
    final /* synthetic */ h0 $core;
    final /* synthetic */ LaunchInfo $fallback;
    final /* synthetic */ j0 $im;
    final /* synthetic */ long $revision;
    int label;
    final /* synthetic */ AuthViewModel this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.auth.AuthViewModel$publishCompatBatchSuccess$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.auth.AuthViewModel$publishCompatBatchSuccess$2$1", f = "AuthViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ f1$b$c $completion;
        final /* synthetic */ LaunchInfo $launchData;
        final /* synthetic */ long $revision;
        int label;
        final /* synthetic */ AuthViewModel this$0;

        public AnonymousClass1(LaunchInfo r1, f1$b$c r2, AuthViewModel r3, long r4, Continuation<? super AnonymousClass1> r6) {
            this.$launchData = r1;
            this.$completion = r2;
            this.this$0 = r3;
            this.$revision = r4;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass1(this.$launchData, this.$completion, this.this$0, this.$revision, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L38;
            ResultKt.throwOnFailure(r14);
            f1$b$c r15 = this.$completion;
            AuthViewModel r0 = this.this$0;
            long r1 = this.$revision;
            final LaunchInfo r3 = this.$launchData;
            AtomicBoolean r4 = AuthViewModel.A;
            if (r15.b == r0.e.a) goto L7;
        L34:
            FLogger.a.i("AuthViewModel", "drop stale compat launch batch=" + r15.a + ", revision=" + r1);
        L36:
            return Unit.INSTANCE;
        L7:
            if (r1 != r0.o) goto L34;
            Set<LaunchBiz> r2 = r15.d;
            String r16 = r15.c;
            e0 r5 = (e0) r0.q.getValue();
            AccountService r6 = AccountService.a;
            if (r6.isLogin().booleanValue() == true) goto L12;
            r3.J1();
        L12:
            boolean r7 = false;
            if (r3.z1() != UserBanStatus.Mute.getValue()) goto L15;
            boolean r8 = true;
        L16:
            r6.y(r8);
            String r10 = null;
            r0.q.setValue(new e0(r3, 2, r16, null));
            Map r17 = r0.l;
            long r11 = r0.e.a;
            String r9 = r3.A1();
            String r12 = "";
            if (r9 != null) goto L19;
            r9 = "";
        L19:
            String r13 = r3.W();
            if (r13 == null) goto L23;
            r12 = r13;
        L23:
            final e r18 = (e) r17.remove(new AuthViewModel.b(r11, r9, r12));
            String r19 = r3.A1();
            if (r19 != null) goto L26;
        L27:
            r7 = true;
        L28:
            if (r7 == true) goto L30;
            Gson r20 = z0.a;
            Intrinsics.checkNotNullParameter(r3, "newLaunchInfo");
            final i0 r21 = z0.m(r3, r18);
            final String r22 = r6.getSecUserId();
            t0.a(new w0(r3, r22, r21, r18));
        L30:
            FLogger r110 = FLogger.a;
            StringBuilder r23 = new StringBuilder("publishCompatLaunchInfo changedBiz=");
            r23.append(r2);
            r23.append(" landingScheme=");
            LandingConfig r24 = r3.M0();
            if (r24 == null) goto L33;
            r10 = r24.a();
        L33:
            r23.append(r10);
            r110.i("AuthViewModel", r23.toString());
            goto L36
        L26:
            if (StringsKt.isBlank(r19) == false) goto L28;
        L15:
            r8 = false;
            goto L16
        L38:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AuthViewModel$publishCompatBatchSuccess$2(AuthViewModel r1, h0 r2, e0 r3, j0 r4, b r5, LaunchInfo r6, f1$b$c r7, long r8, Continuation<? super AuthViewModel$publishCompatBatchSuccess$2> r10) {
        this.this$0 = r1;
        this.$core = r2;
        this.$basic = r3;
        this.$im = r4;
        this.$audio = r5;
        this.$fallback = r6;
        this.$completion = r7;
        this.$revision = r8;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        return new AuthViewModel$publishCompatBatchSuccess$2(this.this$0, this.$core, this.$basic, this.$im, this.$audio, this.$fallback, this.$completion, this.$revision, r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r18);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r18);
        AuthViewModel r3 = this.this$0;
        h0 r4 = this.$core;
        e0 r5 = this.$basic;
        j0 r6 = this.$im;
        b r7 = this.$audio;
        LaunchInfo r8 = this.$fallback;
        AtomicBoolean r9 = AuthViewModel.A;
        r3.getClass();
        LaunchInfo r11 = AuthViewModel.L(r4, r5, r6, r7, r8);
        MainCoroutineDispatcher r10 = Dispatchers.getMain();
        AnonymousClass1 r12 = new AnonymousClass1(r11, this.$completion, this.this$0, this.$revision, null);
        this.label = 1;
        if (BuildersKt.withContext(r10, r12, this) != r1) goto L12;
        return r1;
    }
}
