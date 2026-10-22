package com.larus.uaigc.music.template;

import android.content.Context;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.music.template.MusicTemplateAdapter$observeSyncCurrentPlaying$1", f = "MusicTemplateAdapter.kt", i = {}, l = {338}, m = "invokeSuspend", n = {}, s = {})
final class MusicTemplateAdapter$observeSyncCurrentPlaying$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ bq8.a $template;
    int label;
    final /* synthetic */ MusicTemplateAdapter this$0;

    /* JADX INFO: renamed from: com.larus.uaigc.music.template.MusicTemplateAdapter$observeSyncCurrentPlaying$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "action", "Lcom/larus/im/bean/message/block/player/ICreationPlayList$MusicShuffleAction;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.uaigc.music.template.MusicTemplateAdapter$observeSyncCurrentPlaying$1$1", f = "MusicTemplateAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<ad9.b.b, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MusicTemplateAdapter this$0;

        public AnonymousClass1(MusicTemplateAdapter r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(ad9.b.b r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((ad9.b.b) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L27;
            ResultKt.throwOnFailure(r10);
            ad9.b.b r11 = (ad9.b.b) this.L$0;
            int r0 = r11.a;
            if (r0 != (-1)) goto L7;
            String r1 = "click_previous";
        L11:
            String r2 = r1;
            bq8.a r12 = r11.b;
            if ((r12 instanceof bq8.a) == false) goto L14;
            bq8.a r3 = r12;
            String r4 = String.valueOf(r3.a);
            Integer r5 = Boxing.boxInt(r3.e);
            MusicTemplateAdapter r6 = this.this$0;
            kr8.l.a.b(new kr8.j(r2, r4, r5, "music", r6.b, r6.c, 1), null, 3);
        L14:
            Integer r13 = StringsKt.toIntOrNull(r12.getPlayList().getItemId());
            if (r13 == null) goto L25;
            MusicTemplateAdapter r7 = this.this$0;
            int r14 = r13.intValue();
            final Context r8 = r7.getContext();
            LinearSmoothScroller r9 = new MusicTemplateAdapter$observeSyncCurrentPlaying$1$1$1$linearSmoothScroller$1(r8);
            r9.setTargetPosition(r14);
            if (r14 >= r7.f.size()) goto L25;
            if (r14 <= 0) goto L25;
            RecyclerView r15 = r7.g;
            if (r15 == null) goto L25;
            RecyclerView.LayoutManager r16 = r15.getLayoutManager();
            if (r16 == null) goto L25;
            r16.startSmoothScroll(r9);
        L25:
            return Unit.INSTANCE;
        L7:
            if (r0 == 1) goto L9;
            r1 = "";
            goto L11
        L9:
            r1 = "click_next";
            goto L11
        L27:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MusicTemplateAdapter$observeSyncCurrentPlaying$1(bq8.a r1, MusicTemplateAdapter r2, Continuation<? super MusicTemplateAdapter$observeSyncCurrentPlaying$1> r3) {
        this.$template = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MusicTemplateAdapter$observeSyncCurrentPlaying$1(this.$template, this.this$0, r4);
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
        MutableSharedFlow r7 = this.$template.getPlayList().b();
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r7, r2, this) != r0) goto L12;
        return r0;
    }
}
