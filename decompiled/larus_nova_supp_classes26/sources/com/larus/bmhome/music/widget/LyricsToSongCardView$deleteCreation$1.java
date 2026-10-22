package com.larus.bmhome.music.widget;

import android.content.Context;
import android.content.res.Resources;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.widget.LyricsToSongCardView$deleteCreation$1", f = "LyricsToSongCardView.kt", i = {}, l = {569, 578}, m = "invokeSuspend", n = {}, s = {})
final class LyricsToSongCardView$deleteCreation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LyricsToSongCardView this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.music.widget.LyricsToSongCardView$deleteCreation$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.music.widget.LyricsToSongCardView$deleteCreation$1$1", f = "LyricsToSongCardView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LyricsToSongCardView this$0;

        public AnonymousClass1(LyricsToSongCardView r1, Continuation<? super AnonymousClass1> r2) {
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

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            LyricsToSongCardView r3 = this.this$0;
            r3.p(r3.J);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public LyricsToSongCardView$deleteCreation$1(LyricsToSongCardView r1, Continuation<? super LyricsToSongCardView$deleteCreation$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new LyricsToSongCardView$deleteCreation$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r4 = "";
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r15);
    L59:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r15);
    L20:
        Pair r16 = (Pair) r15;
        if (r16 == null) goto L23;
        Boolean r17 = (Boolean) r16.getFirst();
    L25:
        if (Intrinsics.areEqual(r17, Boxing.boxBoolean(true)) == true) goto L38;
        LyricsToSongCardView r5 = this.this$0;
        Map<String, Pair<String, Integer>> r9 = r5.E;
        if (r9 == null) goto L34;
        Pair r6 = (Pair) ((LinkedHashMap) r9).get(LyricsToSongCardView.n(r5.j));
        if (r6 == null) goto L34;
        String r7 = (String) r6.getFirst();
        if (r7 == null) goto L34;
        String r10 = r7;
    L35:
        tx9.e2.a.b(new tx9.u("chat_list", "chat", TriggerSendLoading.NO_LOADING, r10, "music", null, null, 193), null, 3);
        MainCoroutineDispatcher r18 = Dispatchers.getMain();
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, null);
        this.label = 2;
        if (BuildersKt.withContext(r18, r3, this) != r0) goto L59;
        return r0;
    L34:
        r10 = "";
        goto L35
    L38:
        LyricsToSongCardView r2 = this.this$0;
        Map<String, Pair<String, Integer>> r8 = r2.E;
        if (r8 == null) goto L46;
        Pair r11 = (Pair) ((LinkedHashMap) r8).get(LyricsToSongCardView.n(r2.j));
        if (r11 == null) goto L46;
        String r12 = (String) r11.getFirst();
        if (r12 == null) goto L46;
        String r13 = r12;
    L47:
        tx9.e2.a.b(new tx9.u("chat_list", "chat", "1", r13, "music", null, null, 193), null, 3);
        t19.s r19 = t19.s.a;
        Context r14 = this.this$0.getContext();
        Context r20 = this.this$0.getContext();
        if (r20 == null) goto L55;
        Resources r21 = r20.getResources();
        if (r21 == null) goto L55;
        String r22 = r21.getString(2131900648);
        if (r22 == null) goto L55;
        r4 = r22;
    L55:
        r19.getClass();
        t19.s.p(r14, r4);
        LyricsToSongCardView r110 = this.this$0;
        Map<String, Pair<String, Integer>> r23 = r110.E;
        if (r23 == null) goto L59;
        Pair<String, Integer> r111 = r23.remove(LyricsToSongCardView.n(r110.j));
    L46:
        r13 = "";
        goto L47
    L23:
        r17 = null;
        goto L25
    L10:
        ResultKt.throwOnFailure(r15);
        com.larus.platform.service.e0 r112 = com.larus.platform.service.e0.a;
        LyricsToSongCardView r24 = this.this$0;
        Map<String, Pair<String, Integer>> r25 = r24.E;
        if (r25 == null) goto L16;
        Pair r26 = (Pair) ((LinkedHashMap) r25).get(LyricsToSongCardView.n(r24.j));
        if (r26 == null) goto L16;
        String r27 = (String) r26.getFirst();
        if (r27 == null) goto L16;
    L17:
        this.label = 1;
        r15 = r112.g(r27, this);
        if (r15 != r0) goto L20;
        return r0;
    L16:
        r27 = "";
        goto L17
    }
}
