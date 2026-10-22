package com.larus.bmhome.music.instructions;

import android.content.Context;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.music.protocol.BigMusicLyrics;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import t19.s;
import va8.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.instructions.MusicCreateManager$onClickLyricsAiGen$1", f = "MusicCreateManager.kt", i = {}, l = {260}, m = "invokeSuspend", n = {}, s = {})
final class MusicCreateManager$onClickLyricsAiGen$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<u> $selectedItems;
    int label;
    final /* synthetic */ g this$0;

    public MusicCreateManager$onClickLyricsAiGen$1(g r1, List<u> r2, Continuation<? super MusicCreateManager$onClickLyricsAiGen$1> r3) {
        this.this$0 = r1;
        this.$selectedItems = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MusicCreateManager$onClickLyricsAiGen$1(this.this$0, this.$selectedItems, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r3 = null;
        boolean r4 = true;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r20);
        Object r5 = r20;
    L19:
        y r6 = (com.larus.network.http.a) r5;
        if ((r6 instanceof y) == false) goto L27;
        BigMusicLyrics r7 = (BigMusicLyrics) ((com.larus.network.http.a) r6).b;
        if (r7 == null) goto L34;
        List<String> r8 = r7.a();
        if (r8 == null) goto L34;
        r3 = (String) CollectionsKt.firstOrNull(r8);
    L34:
        String r12 = r3;
        if (r12 != null) goto L37;
    L40:
        if (r4 == true) goto L44;
        g r9 = this.this$0;
        int r10 = g.m;
        r9.getClass();
        ICoreInputAbility r11 = this.this$0.d();
        if (r11 == null) goto L44;
        ICoreInputAbility.b.d(r11, r12, false, false, null, null, false, 62);
    L44:
        g.b(this.this$0, false);
        return Unit.INSTANCE;
    L37:
        if (r12.length() == 0) goto L40;
        r4 = false;
        goto L40
    L27:
        if ((r6 instanceof com.larus.network.http.f) == false) goto L29;
        String r13 = ((com.larus.network.http.f) r6).d.getMessage();
    L30:
        s r14 = s.a;
        Context r15 = this.this$0.getContext();
        if (r13 != null) goto L33;
        r13 = this.this$0.getContext().getResources().getString(2131907194);
    L33:
        s.j(r14, r15, r13, null, false, 28);
        goto L34
    L29:
        r13 = null;
        goto L30
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r20);
        g r16 = this.this$0;
        if (r16.i == true) goto L11;
        g.b(r16, true);
        o r17 = this.this$0.c();
        if (r17 == null) goto L15;
        String r18 = r17.u7();
    L16:
        String r19 = GsonProtectorUtils.toJson(HttpExtKt.f, this.$selectedItems);
        this.label = 1;
        r5 = com.larus.bmhome.music.protocol.g.a(r18, r19, this);
        if (r5 != r1) goto L19;
        return r1;
    L15:
        r18 = null;
        goto L16
    L11:
        return Unit.INSTANCE;
    }
}
