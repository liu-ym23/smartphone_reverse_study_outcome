package com.larus.bot.impl.repository;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.image.loader.b0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import ic8.o0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import zp9.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/chat/bean/RecommendBotData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.repository.UgcBotRepo$getDiscoverFirstPageData$2", f = "UgcBotRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UgcBotRepo$getDiscoverFirstPageData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super o0>, Object> {
    int label;
    final /* synthetic */ UgcBotRepo this$0;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/bot/impl/repository/UgcBotRepo$getDiscoverFirstPageData$2$botList$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/larus/bmhome/chat/bean/RecommendBot;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends RecommendBot>> {
        public a() {
        }
    }

    public UgcBotRepo$getDiscoverFirstPageData$2(UgcBotRepo r1, Continuation<? super UgcBotRepo$getDiscoverFirstPageData$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new UgcBotRepo$getDiscoverFirstPageData$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super o0> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L62;
        ResultKt.throwOnFailure(r11);
        UgcBotRepo r12 = this.this$0;
        Lazy<UgcBotRepo> r1 = UgcBotRepo.d;
        String r13 = r12.e().getString("key_recommend_bot_first_page_data", "");
        Intrinsics.checkNotNull(r13);
        boolean r4 = false;
        if (r13.length() <= 0) goto L7;
        boolean r3 = true;
    L9:
        if (r3 == true) goto L63;
    L60:
        return null;
    L63:
        o0 r14 = (o0) GsonProtectorUtils.fromJson(new Gson(), r13, o0.class);     // Catch: NullPointerException -> L56 JsonSyntaxException -> L58
        if (r14 == null) goto L60;
        List r5 = r14.e();     // Catch: NullPointerException -> L56 JsonSyntaxException -> L58
        if (r5 == null) goto L17;
        w r6 = (w) CollectionsKt.getOrNull(r5, 0);     // Catch: NullPointerException -> L56 JsonSyntaxException -> L58
        if (r6 == null) goto L17;
        long r7 = r6.a;     // Catch: NullPointerException -> L56 JsonSyntaxException -> L58
    L18:
        String r0 = this.this$0.e().getString("key_recommend_bot_data_" + r7, "");     // Catch: NullPointerException -> L56 JsonSyntaxException -> L58
        Intrinsics.checkNotNull(r0);     // Catch: NullPointerException -> L56 JsonSyntaxException -> L58
        if (r0.length() <= 0) goto L21;
        boolean r2 = true;
    L22:
        if (r2 == false) goto L60;
        List r8 = (List) GsonProtectorUtils.fromJson(new Gson(), r0, new a().getType());     // Catch: NullPointerException -> L56 JsonSyntaxException -> L58
        List r9 = r8;     // Catch: NullPointerException -> L56 JsonSyntaxException -> L58
        UgcBotRepo r10 = this.this$0;     // Catch: NullPointerException -> L56 JsonSyntaxException -> L58
        if ((r9 instanceof Collection) == true) goto L26;
    L28:
        Iterator r15 = r9.iterator();     // Catch: NullPointerException -> L56 JsonSyntaxException -> L58
    L30:
        if (r15.hasNext() == false) goto L47;
        BotIconImage r16 = ((RecommendBot) r15.next()).O();     // Catch: NullPointerException -> L56 JsonSyntaxException -> L58
        if (r16 == null) goto L34;
        String r17 = r16.getTinyUrl();     // Catch: NullPointerException -> L56 JsonSyntaxException -> L58
    L35:
        r10.getClass();     // Catch: NullPointerException -> L56 JsonSyntaxException -> L58
        if (r17 != null) goto L38;
    L41:
        boolean r18 = true;
    L42:
        if (r18 == false) goto L44;
        boolean r19 = true;
    L45:
        if (r19 == false) goto L30;
        r4 = true;
        goto L47
    L44:
        boolean r20 = b0.a;     // Catch: NullPointerException -> L56 JsonSyntaxException -> L58
        r19 = b0.c(y0.j(r17));     // Catch: NullPointerException -> L56 JsonSyntaxException -> L58
        goto L45
    L38:
        if (r17.length() == 0) goto L41;
        r18 = false;
        goto L42
    L34:
        r17 = null;
    L47:
        if (r4 == false) goto L50;
        this.this$0.e().erase("key_recommend_bot_first_page_data");     // Catch: NullPointerException -> L56 JsonSyntaxException -> L58
        return null;
    L50:
        Iterator r21 = r8.iterator();     // Catch: NullPointerException -> L56 JsonSyntaxException -> L58
    L52:
        if (r21.hasNext() == false) goto L55;
        ((RecommendBot) r21.next()).c = true;     // Catch: NullPointerException -> L56 JsonSyntaxException -> L58
        goto L52
    L55:
        return o0.a(r14, r8, true, 30);
    L26:
        if (r9.isEmpty() == false) goto L28;
    L21:
        r2 = false;
    L17:
        r7 = 1;
    L56:
        e = move-exception;
        FLogger.a.e("UgcBotRepo", "getDiscoverFirstPageData error e=" + e.getMessage());
    L58:
        e = move-exception;
        com.larus.platform.service.g.a.ensureNotReachHere(e);
        goto L60
    L7:
        r3 = false;
        goto L9
    L62:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
