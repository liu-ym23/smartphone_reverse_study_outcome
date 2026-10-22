package com.larus.bmhome.music.instructions;

import android.content.Context;
import com.larus.bmhome.actionbar.model.u;
import com.larus.bmhome.music.protocol.BigMusicLyrics;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.instructions.MusicCreateManager$onClickLyricsAiGen$2", f = "MusicCreateManager.kt", i = {}, l = {294}, m = "invokeSuspend", n = {}, s = {})
final class MusicCreateManager$onClickLyricsAiGen$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $onLoadingChanged;
    final /* synthetic */ Function1<String, Unit> $onResult;
    final /* synthetic */ Function0<String> $promptProvider;
    final /* synthetic */ List<u> $selectedItems;
    int label;
    final /* synthetic */ g this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public MusicCreateManager$onClickLyricsAiGen$2(g r1, Function1<? super Boolean, Unit> r2, Function0<String> r3, List<u> r4, Function1<? super String, Unit> r5, Continuation<? super MusicCreateManager$onClickLyricsAiGen$2> r6) {
        this.this$0 = r1;
        this.$onLoadingChanged = r2;
        this.$promptProvider = r3;
        this.$selectedItems = r4;
        this.$onResult = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new MusicCreateManager$onClickLyricsAiGen$2(this.this$0, this.$onLoadingChanged, this.$promptProvider, this.$selectedItems, this.$onResult, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L15;
        if (r1 != 1) goto L14;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
    L23:
        y r13 = (com.larus.network.http.a) r12;     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        String r2 = null;
        if ((r13 instanceof y) == false) goto L31;
        BigMusicLyrics r14 = (BigMusicLyrics) ((com.larus.network.http.a) r13).b;     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        if (r14 == null) goto L38;
        List<String> r15 = r14.a();     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        if (r15 == null) goto L38;
        r2 = (String) CollectionsKt.firstOrNull(r15);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
    L38:
        if (r2 != null) goto L40;
    L43:
        if (r3 == true) goto L47;
        g r16 = this.this$0;     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        int r4 = g.m;     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        r16.getClass();     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        this.$onResult.invoke(r2);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
    L47:
        this.$onLoadingChanged.invoke(Boxing.boxBoolean(false));
        this.this$0.i = false;
        return Unit.INSTANCE;
    L40:
        if (r2.length() == 0) goto L43;
        r3 = false;
        goto L43
    L31:
        if ((r13 instanceof com.larus.network.http.f) == false) goto L33;
        String r17 = ((com.larus.network.http.f) r13).d.getMessage();     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
    L34:
        s r5 = s.a;     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        Context r6 = this.this$0.getContext();     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        if (r17 != null) goto L37;
        r17 = this.this$0.getContext().getResources().getString(2131907194);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
    L37:
        s.j(r5, r6, r17, null, false, 28);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        goto L38
    L33:
        r17 = null;
        goto L34
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r12);
        g r18 = this.this$0;
        if (r18.i == true) goto L18;
        r18.i = true;
        this.$onLoadingChanged.invoke(Boxing.boxBoolean(true));
        String r19 = (String) this.$promptProvider.invoke();     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        String r7 = HttpExtKt.f.toJson(this.$selectedItems);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        this.label = 1;     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        r12 = com.larus.bmhome.music.protocol.g.a(r19, r7, this);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        if (r12 != r0) goto L23;
        return r0;
    L18:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        this.$onLoadingChanged.invoke(Boxing.boxBoolean(false));
        this.this$0.i = false;
        throw th;
    L11:
        e = move-exception;
        throw e;     // Catch: Throwable -> L7
    L9:
        e = move-exception;
        FLogger.a.e("MusicCreateManager", "generate lyrics failed", e);     // Catch: Throwable -> L7
        s.j(s.a, this.this$0.getContext(), this.this$0.getContext().getResources().getString(2131907194), null, false, 28);     // Catch: Throwable -> L7
        goto L47
    }
}
