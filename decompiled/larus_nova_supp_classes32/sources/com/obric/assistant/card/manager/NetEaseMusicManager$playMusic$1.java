package com.obric.assistant.card.manager;

import android.os.Handler;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.capabilitykit.entity.app.MusicEntity;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.card.manager.NetEaseMusicManager$playMusic$1", f = "NetEaseMusicManager.kt", i = {}, l = {142}, m = "invokeSuspend", n = {}, s = {})
public final class NetEaseMusicManager$playMusic$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $localMessageId;
    final /* synthetic */ Function1<Boolean, Unit> $onResult;
    final /* synthetic */ MusicEntity $playSong;
    final /* synthetic */ MusicEntity[] $songs;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.obric.assistant.card.manager.NetEaseMusicManager$playMusic$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.card.manager.NetEaseMusicManager$playMusic$1$1", f = "NetEaseMusicManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Boolean, Unit> $onResult;
        final /* synthetic */ boolean $success;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(boolean r1, Function1<? super Boolean, Unit> r2, Continuation<? super AnonymousClass1> r3) {
            this.$success = r1;
            this.$onResult = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$success, this.$onResult, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r4);
            if (this.$success == false) goto L7;
            NetEaseMusicManager.a.getClass();
            NetEaseMusicManager.g = false;
            Handler r5 = NetEaseMusicManager.c;
            NetEaseMusicManager.b r0 = NetEaseMusicManager.h;
            r5.removeCallbacks(r0);
            r5.postDelayed(r0, 1000);
        L7:
            this.$onResult.invoke(Boxing.boxBoolean(this.$success));
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NetEaseMusicManager$playMusic$1(String r1, MusicEntity[] r2, MusicEntity r3, Function1<? super Boolean, Unit> r4, Continuation<? super NetEaseMusicManager$playMusic$1> r5) {
        this.$localMessageId = r1;
        this.$songs = r2;
        this.$playSong = r3;
        this.$onResult = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        NetEaseMusicManager$playMusic$1 r6 = new NetEaseMusicManager$playMusic$1(this.$localMessageId, this.$songs, this.$playSong, this.$onResult, r9);
        r6.L$0 = r8;
        return r6;
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L26:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        String r9 = this.$localMessageId;
        MusicEntity[] r2 = this.$songs;
        MusicEntity r3 = this.$playSong;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L17
        NetEaseMusicManager.a.getClass();     // Catch: Throwable -> L17
        NetEaseMusicManager.a();     // Catch: Throwable -> L17
        IAgentAppIntentIDL r6 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));     // Catch: Throwable -> L17
        if (r6 != null) goto L12;
    L14:
        boolean r10 = false;
    L15:
        Object r11 = Result.constructor-impl(Boxing.boxBoolean(r10));     // Catch: Throwable -> L17
    L19:
        Boolean r4 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r11) == false) goto L22;
        r11 = r4;
    L22:
        boolean r12 = ((Boolean) r11).booleanValue();
        MainCoroutineDispatcher r13 = Dispatchers.getMain().getImmediate();
        AnonymousClass1 r14 = new AnonymousClass1(r12, this.$onResult, null);
        this.label = 1;
        if (BuildersKt.withContext(r13, r14, this) != r0) goto L26;
        return r0;
    L12:
        if (r6.playMusic(r9, r2, r3) != 0) goto L14;
        r10 = true;
    L17:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }
}
