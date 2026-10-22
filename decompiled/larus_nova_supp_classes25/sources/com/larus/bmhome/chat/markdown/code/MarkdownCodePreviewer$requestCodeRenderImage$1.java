package com.larus.bmhome.chat.markdown.code;

import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.markdown.code.render.CodeRenderApi;
import com.larus.network.FlowHttpConnection;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.markdown.code.MarkdownCodePreviewer$requestCodeRenderImage$1", f = "MarkdownCodePreviewer.kt", i = {0}, l = {108}, m = "invokeSuspend", n = {"startTimestamp"}, s = {"J$0"})
final class MarkdownCodePreviewer$requestCodeRenderImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cardId;
    final /* synthetic */ String $code;
    final /* synthetic */ Integer $deviceHeight;
    final /* synthetic */ Integer $deviceWidth;
    final /* synthetic */ String $language;
    final /* synthetic */ String $theme;
    long J$0;
    int label;
    final /* synthetic */ t0 this$0;

    public MarkdownCodePreviewer$requestCodeRenderImage$1(Integer r1, Integer r2, t0 r3, String r4, String r5, String r6, String r7, Continuation<? super MarkdownCodePreviewer$requestCodeRenderImage$1> r8) {
        this.$deviceWidth = r1;
        this.$deviceHeight = r2;
        this.this$0 = r3;
        this.$cardId = r4;
        this.$theme = r5;
        this.$code = r6;
        this.$language = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new MarkdownCodePreviewer$requestCodeRenderImage$1(this.$deviceWidth, this.$deviceHeight, this.this$0, this.$cardId, this.$theme, this.$code, this.$language, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r23) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r12 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        long r2 = this.J$0;
        ResultKt.throwOnFailure(r23);
        long r13 = r2;
        Object r3 = r23;
    L29:
        dm9.a.b r4 = (dm9.a) r3;
        if ((r4 instanceof dm9.a.b) == false) goto L49;
        ih8.b r5 = (ih8.b) r4.a.getData();
        if (r5 != null) goto L34;
        r5 = new ih8.b("", 6);
    L34:
        this.this$0.a.postValue(r5);
        String r6 = r5.b();
        if (r6 != null) goto L37;
    L40:
        if (r12 == true) goto L50;
        Lazy<Keva> r7 = t0.d;
        String r8 = t0.a.a(this.$cardId, this.$theme);
        if (r8 != null) goto L52;
    L48:
        FLogger.a.d("MarkdownCodePreviewer", "Cached image URL for cardId: " + this.$cardId + ", theme: " + this.$theme);
        goto L50
    L52:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L46
        ((Keva) t0.d.getValue()).storeString(r8, ((Gson) t0.e.getValue()).toJson(r5));     // Catch: Throwable -> L46
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L50:
        FLogger.a.d("MarkdownCodePreviewer", "requestCodeRenderImage cost: " + (System.currentTimeMillis() - r13));
        this.this$0.c = false;
        return Unit.INSTANCE;
    L37:
        if (r6.length() == 0) goto L40;
        r12 = false;
        goto L40
    L49:
        this.this$0.a.postValue(new ih8.b("", 6));
        goto L50
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r23);
        r13 = System.currentTimeMillis();
        Integer r11 = this.$deviceWidth;
        if (r11 != null) goto L11;
    L16:
        Integer r19 = null;
    L17:
        Integer r14 = this.$deviceHeight;
        if (r14 != null) goto L20;
    L25:
        Integer r20 = null;
    L26:
        CodeRenderApi.a r15 = CodeRenderApi.a;
        MarkdownCodePreviewer$requestCodeRenderImage$1$response$1 r16 = new MarkdownCodePreviewer$requestCodeRenderImage$1$response$1(this.$code, this.$language, this.$theme, r19, r20, null);
        this.J$0 = r13;
        this.label = 1;
        r15.getClass();
        FlowHttpConnection r17 = FlowHttpConnection.a;
        r3 = FlowHttpConnection.g("Basic", CodeRenderApi.class, r16, false, null, null, null, this, 248);
        if (r3 != r0) goto L29;
        return r0;
    L20:
        if (r14.intValue() <= 0) goto L22;
        boolean r18 = true;
    L23:
        if (r18 == false) goto L25;
        r20 = r14;
        goto L26
    L22:
        r18 = false;
        goto L23
    L11:
        if (r11.intValue() <= 0) goto L13;
        boolean r21 = true;
    L14:
        if (r21 == false) goto L16;
        r19 = r11;
        goto L17
    L13:
        r21 = false;
        goto L14
    }
}
