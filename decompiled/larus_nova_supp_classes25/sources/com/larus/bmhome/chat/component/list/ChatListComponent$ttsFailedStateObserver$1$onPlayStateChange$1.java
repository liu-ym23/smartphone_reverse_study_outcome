package com.larus.bmhome.chat.component.list;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.audiov3.task.tts.TtsErrorType;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.media.MediaResourceManager;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.VoiceCallServiceDelegate;
import com.obric.assistant.spi.audio.ObricTtsControlDelegate;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
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
import kotlinx.coroutines.DelayKt;
import t19.o;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponent$ttsFailedStateObserver$1$onPlayStateChange$1", f = "ChatListComponent.kt", i = {}, l = {1484}, m = "invokeSuspend", n = {}, s = {})
public final class ChatListComponent$ttsFailedStateObserver$1$onPlayStateChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PlayStateEnum $state;
    final /* synthetic */ TtsErrorType $ttsErrorType;
    int label;
    final /* synthetic */ ChatListComponent this$0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PlayStateEnum.values().length];
            r0[PlayStateEnum.PLAY_STATE_PREPARE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[PlayStateEnum.PLAY_STATE_FAIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[PlayStateEnum.PLAY_STATE_STOPPED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[PlayStateEnum.PLAY_STATE_PAUSED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public ChatListComponent$ttsFailedStateObserver$1$onPlayStateChange$1(PlayStateEnum r1, ChatListComponent r2, TtsErrorType r3, Continuation<? super ChatListComponent$ttsFailedStateObserver$1$onPlayStateChange$1> r4) {
        this.$state = r1;
        this.this$0 = r2;
        this.$ttsErrorType = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatListComponent$ttsFailedStateObserver$1$onPlayStateChange$1(this.$state, this.this$0, this.$ttsErrorType, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L26:
        t19.s.a.a();
    L94:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        PlayStateEnum r10 = this.$state;
        if (r10 != null) goto L11;
        int r11 = -1;
    L12:
        if (r11 == (-1)) goto L94;
        Object r2 = null;
        if (r11 != 1) goto L16;
        FLogger r12 = FLogger.a;
        String r3 = this.this$0.n;
        StringBuilder r4 = new StringBuilder("loading toast, should show: ");
        RepoDispatcher.a.getClass();
        ChatRepo r5 = RepoDispatcher.d;
        r4.append(r5.d.d.n6());
        r4.append('.');
        r12.e(r3, r4.toString());
        String r13 = r5.d.d.o6();
        MessageAdapter r6 = this.this$0.O;
        if (r6 == null) goto L90;
        List<b> r7 = r6.z2();
        if (r7 == null) goto L90;
        Iterator<T> r8 = r7.iterator();
    L83:
        if (r8.hasNext() == false) goto L87;
        Object r14 = r8.next();
        if (Intrinsics.areEqual(((b) r14).getMessage().getMessageId(), r13) == false) goto L83;
        r2 = r14;
    L87:
        b r15 = (b) r2;
        if (r15 == null) goto L90;
        r15.getMessage();
    L90:
        RepoDispatcher.a.getClass();
        ChatRepo r16 = RepoDispatcher.d;
        if (r16.d.d.n6() == false) goto L94;
        t19.s r17 = t19.s.a;
        Fragment r18 = s1a.a.c(this.this$0);
        r17.getClass();
        Intrinsics.checkNotNullParameter(r18, "fragment");
        t19.s.n(r17, r18, r18.getText(2131910633), new o());
        r16.d.d.l6();
        this.this$0.E3 = true;
        goto L94
    L16:
        if (r11 != 2) goto L18;
        FLogger.a.e(this.this$0.n, "failed toast.");
        if (AudioServiceDelegate.a.F().b() == true) goto L73;
        RepoDispatcher.a.getClass();
        String r19 = RepoDispatcher.d.d.d.o6();
        MessageAdapter r20 = this.this$0.O;
        if (r20 == null) goto L45;
        List<b> r21 = r20.z2();
        if (r21 == null) goto L45;
        Iterator<T> r22 = r21.iterator();
    L37:
        if (r22.hasNext() == false) goto L41;
        Object r23 = r22.next();
        if (Intrinsics.areEqual(((b) r23).getMessage().getMessageId(), r19) == false) goto L37;
    L42:
        b r24 = (b) r23;
        if (r24 == null) goto L45;
        Message r25 = r24.getMessage();
    L46:
        FLogger r26 = FLogger.a;
        String r27 = this.this$0.n;
        StringBuilder r28 = new StringBuilder("[TTS_FAIL][FAIL_STATE][2][msgId:");
        if (r25 == null) goto L49;
        String r29 = r25.getMessageId();
    L50:
        r28.append(r29);
        r28.append("][localIndex:");
        if (r25 == null) goto L53;
        Long r30 = Boxing.boxLong(r25.getLocalIndex());
    L54:
        r28.append(r30);
        r28.append("][status:");
        if (r25 == null) goto L57;
        MessageStatus r31 = r25.getMessageStatus();
    L58:
        r28.append(r31);
        r28.append("][statusLocal:");
        if (r25 == null) goto L61;
        r2 = Boxing.boxInt(r25.getMessageStatusLocal());
    L61:
        r28.append(r2);
        r28.append(']');
        r26.e(r27, r28.toString());
        if (r25 == null) goto L69;
        if (ObricTtsControlDelegate.b.r(r25) == false) goto L69;
        ChatListComponent r32 = this.this$0;
        if (r32.E3 == false) goto L73;
        r32.E3 = false;
        t19.s.a.a();
    L69:
        if (this.$ttsErrorType != TtsErrorType.LANGUAGE_NOT_SUPPORTED) goto L71;
        int r33 = 2131911116;
    L72:
        t19.s r34 = t19.s.a;
        Context r35 = s1a.a.c(this.this$0).getContext();
        r34.getClass();
        t19.s.s(r35, r33);
        this.this$0.E3 = false;
        goto L73
    L71:
        r33 = 2131910632;
        goto L72
    L57:
        r31 = null;
        goto L58
    L53:
        r30 = null;
        goto L54
    L49:
        r29 = null;
        goto L50
    L41:
        r23 = null;
    L45:
        r25 = null;
    L73:
        Lazy r36 = MediaResourceManager.a;
        String r37 = this.this$0.U5().getReader().o6();
        if (com.larus.media.o.a() == false) goto L76;
        MediaResourceManager.a r38 = new MediaResourceManager.a();
        r38.a = 2;
        r38.b = r37;
        r38.c = MediaResourceManager.FlowAudioBroadcastEvent.asrWaitReplyEnd;
        MediaResourceManager.d(r38);
    L76:
        VoiceCallServiceDelegate.a.w("tts_error");
        goto L94
    L18:
        if (r11 != 3) goto L20;
        FLogger.a.e(this.this$0.n, "PLAY_STATE_STOPPED.");
        ChatListComponent.D3(this.this$0);
        goto L94
    L20:
        if (r11 == 4) goto L27;
        FLogger r39 = FLogger.a;
        r39.e(this.this$0.n, "normal state -> " + this.$state + ", state name -> " + this.$state.name());
        ChatListComponent r40 = this.this$0;
        if (r40.E3 == false) goto L94;
        r39.e(r40.n, "dismiss toast.");
        this.this$0.E3 = false;
        this.label = 1;
        if (DelayKt.delay(200, this) != r0) goto L26;
        return r0;
    L27:
        FLogger.a.e(this.this$0.n, "PLAY_STATE_PAUSED.");
        ChatListComponent.D3(this.this$0);
        goto L94
    L11:
        r11 = a.a[r10.ordinal()];
        goto L12
    }
}
