package com.larus.uaigc.music.lyrics_to_song;

import android.content.Context;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.view.utils.SwipingControlVm;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.music.lyrics_to_song.LyricsToSongListBox$collectScrollToPlayingCardEvent$1", f = "LyricsToSongListBox.kt", i = {}, l = {359}, m = "invokeSuspend", n = {}, s = {})
final class LyricsToSongListBox$collectScrollToPlayingCardEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ l this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ l a;

        public a(l r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [android.widget.LinearLayout, com.larus.uaigc.music.lyrics_to_song.l, java.lang.Object] */
        public final Object emit(Object r6, Continuation r7) {
            SwipingControlVm.a r8 = (SwipingControlVm.a) r6;
            SimpleLyricsToSongListAdapter r9 = this.a.q;
            if (r9 == null) goto L27;
            ArrayList<Pair<Integer, MusicCreationContent>> r10 = r9.d;
            if (r10 == null) goto L27;
            IntRange r11 = CollectionsKt.getIndices(r10);
            if (r11 == null) goto L27;
            String r0 = r8.b;
            Message r1 = this.a.s;
            if (r1 == null) goto L12;
            String r2 = r1.getMessageId();
        L13:
            boolean r3 = Intrinsics.areEqual(r0, r2);
            int r4 = r11.getFirst();
            int r12 = r11.getLast();
            int r5 = r8.a;
            boolean r13 = false;
            if (r4 > r5) goto L17;
            if (r5 > r12) goto L17;
            boolean r14 = true;
        L18:
            if (r3 == false) goto L21;
            if (r14 == false) goto L21;
            r13 = true;
        L21:
            if (r13 == false) goto L28;
            FLogger r15 = FLogger.a;
            r15.i("LyricsToSongBox", "[scrollToPlayingMusicCardFlow] collect, target:" + r8);
            ?? r16 = this.a;
            int r17 = r8.a;
            r16.getClass();
            r15.i("LyricsToSongBox", "[smoothScrollTo] target:" + r17);
            final Context r18 = r16.getContext();
            LinearSmoothScroller r19 = new LyricsToSongListBox$smoothScrollTo$linearSmoothScroller$1(r18);
            r19.setTargetPosition(r17);
            RecyclerView.LayoutManager r20 = r16.x.c.getLayoutManager();
            if (r20 == null) goto L28;
            r20.startSmoothScroll(r19);
        L28:
            return Unit.INSTANCE;
        L17:
            r14 = false;
            goto L18
        L12:
            r2 = null;
        L27:
            return Unit.INSTANCE;
        }
    }

    public LyricsToSongListBox$collectScrollToPlayingCardEvent$1(l r1, Continuation<? super LyricsToSongListBox$collectScrollToPlayingCardEvent$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new LyricsToSongListBox$collectScrollToPlayingCardEvent$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L18:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        q0.a r6 = this.this$0.t;
        if (r6 == null) goto L20;
        SwipingControlVm r7 = r6.O9();
        if (r7 == null) goto L20;
        MutableSharedFlow r8 = r7.getScrollToPlayingMusicCardFlow();
        if (r8 == null) goto L20;
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r8.collect(r2, this) != r0) goto L18;
        return r0;
    L20:
        return Unit.INSTANCE;
    }
}
