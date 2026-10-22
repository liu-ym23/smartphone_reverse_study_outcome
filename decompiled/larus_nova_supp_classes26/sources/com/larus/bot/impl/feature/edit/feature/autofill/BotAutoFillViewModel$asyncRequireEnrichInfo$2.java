package com.larus.bot.impl.feature.edit.feature.autofill;

import com.larus.bot.impl.bean.BotEnrichRespData;
import com.larus.bot.impl.bean.ContentSource;
import com.larus.bot.impl.bean.ContentType;
import com.larus.bot.impl.bean.EnrichBotData;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import com.larus.bot.impl.feature.edit.feature.autofill.model.BotEnrichParam;
import com.larus.bot.impl.feature.edit.feature.firstmet.k;
import com.larus.bot.impl.repository.UgcBotRepo;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.y;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.autofill.BotAutoFillViewModel$asyncRequireEnrichInfo$2", f = "BotAutoFillViewModel.kt", i = {}, l = {512, 516}, m = "invokeSuspend", n = {}, s = {})
final class BotAutoFillViewModel$asyncRequireEnrichInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $curRetryCount;
    final /* synthetic */ int $maxRetryCount;
    final /* synthetic */ BotEnrichParam $requestParam;
    int label;
    final /* synthetic */ BotAutoFillViewModel this$0;

    public BotAutoFillViewModel$asyncRequireEnrichInfo$2(BotAutoFillViewModel r1, BotEnrichParam r2, int r3, int r4, Continuation<? super BotAutoFillViewModel$asyncRequireEnrichInfo$2> r5) {
        this.this$0 = r1;
        this.$requestParam = r2;
        this.$curRetryCount = r3;
        this.$maxRetryCount = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new BotAutoFillViewModel$asyncRequireEnrichInfo$2(this.this$0, this.$requestParam, this.$curRetryCount, this.$maxRetryCount, r8);
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
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        ResultKt.throwOnFailure(r18);
    L293:
        BotAutoFillViewModel r3 = this.this$0;
        int r4 = BotAutoFillViewModel.x;
        r3.getClass();
        ArrayList r5 = new ArrayList();
        if (r3.g.b == false) goto L297;
        r5.add(ContentType.NAME);
    L297:
        if (r3.g.c == false) goto L300;
        r5.add(ContentType.DESC);
    L300:
        if (r3.g.e == false) goto L303;
        r5.add(ContentType.PROLOGUE);
    L303:
        if (r3.g.f == false) goto L306;
        r5.add(ContentType.SUGGEST);
    L306:
        if (r3.g.g == false) goto L309;
        r5.add(ContentType.VOICE_ID);
    L309:
        if (r3.g.h == false) goto L311;
        r5.add(ContentType.BIO);
    L311:
        Iterator r6 = r5.iterator();
    L313:
        if (r6.hasNext() == false) goto L336;
        int r7 = BotAutoFillViewModel.b.a[((ContentType) r6.next()).ordinal()];
        if (r7 != 3) goto L317;
        String r8 = r3.j.getPrologue();
        if (r8 != null) goto L335;
        r8 = "";
    L335:
        r3.m(CollectionsKt.listOf(new wu8.c.e(r8)));
        goto L313
    L317:
        if (r7 != 4) goto L319;
        String r9 = r3.j.getBio();
        if (r9 != null) goto L331;
        r9 = "";
    L331:
        r3.m(CollectionsKt.listOf(new wu8.c.b(r9)));
        goto L313
    L319:
        if (r7 != 5) goto L313;
        Triple<String, String, String> r10 = r3.j.getSuggests();
        if (r10 == null) goto L324;
        List<String> r11 = k.c(r10);
    L325:
        if (r11 != null) goto L327;
        r11 = CollectionsKt.emptyList();
    L327:
        r3.m(CollectionsKt.listOf(new wu8.c.f(r11)));
        goto L313
    L324:
        r11 = null;
        goto L325
    L336:
        wu8.b r12 = this.this$0.g;
        r12.b = false;
        r12.c = false;
        r12.d = false;
        r12.e = false;
        r12.f = false;
        r12.g = false;
        r12.h = false;
        this.this$0.b();
        this.this$0.I();
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r18);
        Object r13 = r18;
    L13:
        com.larus.network.http.f r14 = (com.larus.network.http.a) r13;
        long r15 = 0;
        if ((r14 instanceof y) == false) goto L251;
        BotAutoFillViewModel r16 = this.this$0;
        int r17 = BotAutoFillViewModel.x;
        r16.getClass();
        BotEnrichRespData r19 = (BotEnrichRespData) ((com.larus.network.http.a) r14).b;
        if (r19 == null) goto L18;
        List<EnrichBotData> r20 = r19.getData();
    L19:
        List<EnrichBotData> r21 = r20;
        if (r21 != null) goto L22;
    L25:
        boolean r22 = true;
    L27:
        if (r22 == true) goto L184;
        BotEnrichRespData r23 = (BotEnrichRespData) ((com.larus.network.http.a) r14).b;
        if (r23 == null) goto L41;
        List<EnrichBotData> r24 = r23.getData();
        if (r24 == null) goto L41;
        ArrayList r110 = new ArrayList();
        Iterator<T> r25 = r24.iterator();
    L34:
        if (r25.hasNext() == false) goto L42;
        Object r111 = r25.next();
        EnrichBotData r112 = (EnrichBotData) r111;
        if (r112 == null) goto L38;
        boolean r26 = Intrinsics.areEqual(r112.useInternet, Boolean.TRUE);
    L39:
        if (r26 == false) goto L34;
        r110.add(r111);
        goto L34
    L38:
        r26 = false;
    L42:
        if (r110 != null) goto L44;
    L47:
        boolean r27 = true;
    L48:
        r16.w = !r27;
        BotEnrichRespData r28 = (BotEnrichRespData) ((com.larus.network.http.a) r14).b;
        if (r28 == null) goto L51;
        List<EnrichBotData> r29 = r28.getData();
    L52:
        if (r29 != null) goto L54;
        r29 = CollectionsKt.emptyList();
    L54:
        ArrayList r30 = new ArrayList();
        Iterator<T> r31 = r29.iterator();
    L56:
        if (r31.hasNext() == false) goto L72;
        Object r32 = r31.next();
        EnrichBotData r113 = (EnrichBotData) r32;
        if (r113 == null) goto L60;
        String r114 = r113.contentType;
    L62:
        if (o0.d(r114) == false) goto L69;
        if (r113 == null) goto L65;
        String r115 = r113.contentSource;
    L67:
        if (o0.d(r115) == false) goto L69;
        boolean r116 = true;
    L70:
        if (r116 == false) goto L56;
        r30.add(r32);
        goto L56
    L65:
        r115 = null;
    L69:
        r116 = false;
        goto L70
    L60:
        r114 = null;
        goto L62
    L72:
        ArrayList r33 = new ArrayList();
        Iterator r34 = r30.iterator();
    L74:
        if (r34.hasNext() == false) goto L101;
        Object r35 = r34.next();
        EnrichBotData r117 = (EnrichBotData) r35;
        if (r117 == null) goto L78;
        String r118 = r117.contentSource;
    L80:
        if (Intrinsics.areEqual(r118, ContentSource.MODEL_GENERATED.getValue()) == false) goto L98;
        List<String> r119 = r117.content;
        if (r119 == null) goto L89;
        ArrayList r120 = new ArrayList();
        Iterator<T> r121 = r119.iterator();
    L85:
        if (r121.hasNext() == false) goto L90;
        Object r122 = r121.next();
        if (o0.d((String) r122) == false) goto L85;
        r120.add(r122);
    L90:
        if (r120 != null) goto L92;
    L95:
        boolean r123 = true;
    L96:
        if (r123 == true) goto L98;
        boolean r124 = true;
    L99:
        if (r124 == false) goto L74;
        r33.add(r35);
        goto L74
    L92:
        if (r120.isEmpty() == true) goto L95;
        r123 = false;
        goto L96
    L89:
        r120 = null;
    L98:
        r124 = false;
        goto L99
    L78:
        r118 = null;
        goto L80
    L101:
        ArrayList r36 = new ArrayList();
        Iterator r37 = r33.iterator();
    L103:
        if (r37.hasNext() == false) goto L181;
        EnrichBotData r38 = (EnrichBotData) r37.next();
        ContentType.a r125 = ContentType.Companion;
        if (r38 == null) goto L107;
        String r126 = r38.contentType;
    L108:
        r125.getClass();
        switch(BotAutoFillViewModel.b.a[ContentType.a.a(r126).ordinal()]) {
            case 1: goto L171;
            case 2: goto L160;
            case 3: goto L149;
            case 4: goto L138;
            case 5: goto L123;
            case 6: goto L112;
            default: goto L103;
        };
    L112:
        if (r16.g.g == false) goto L103;
        r16.g.g = false;
        if (r38 == null) goto L118;
        List<String> r39 = r38.content;
        if (r39 == null) goto L118;
        String r40 = (String) CollectionsKt.firstOrNull(r39);
    L119:
        if (r40 != null) goto L121;
        r40 = "";
    L121:
        wu8.c.g r127 = new wu8.c.g(r40);
        ((HashMap) r16.h).put(ContentType.VOICE_ID.getValue(), CollectionsKt.listOf(r127.a));
        r36.add(r127);
    L118:
        r40 = null;
        goto L119
    L123:
        if (r16.g.f == false) goto L103;
        r16.g.f = false;
        if (r38 == null) goto L127;
        List<String> r41 = r38.content;
    L128:
        if (r41 != null) goto L130;
        r41 = CollectionsKt.emptyList();
    L130:
        List r42 = CollectionsKt.filterNotNull(r41);
        ArrayList r128 = new ArrayList();
        Iterator r43 = r42.iterator();
    L132:
        if (r43.hasNext() == false) goto L136;
        Object r129 = r43.next();
        if (StringsKt.isBlank((String) r129) == true) goto L132;
        r128.add(r129);
        goto L132
    L136:
        wu8.c.f r44 = new wu8.c.f(r128);
        ((HashMap) r16.h).put(ContentType.SUGGEST.getValue(), r44.a);
        r36.add(r44);
        goto L103
    L127:
        r41 = null;
        goto L128
    L138:
        if (r16.g.h == false) goto L103;
        r16.g.h = false;
        if (r38 == null) goto L144;
        List<String> r45 = r38.content;
        if (r45 == null) goto L144;
        String r46 = (String) CollectionsKt.firstOrNull(r45);
    L145:
        if (r46 != null) goto L147;
        r46 = "";
    L147:
        wu8.c.b r130 = new wu8.c.b(r46);
        ((HashMap) r16.h).put(ContentType.BIO.getValue(), CollectionsKt.listOf(r130.a));
        r36.add(r130);
    L144:
        r46 = null;
        goto L145
    L149:
        if (r16.g.e == false) goto L103;
        r16.g.e = false;
        if (r38 == null) goto L155;
        List<String> r47 = r38.content;
        if (r47 == null) goto L155;
        String r48 = (String) CollectionsKt.firstOrNull(r47);
    L156:
        if (r48 != null) goto L158;
        r48 = "";
    L158:
        wu8.c.e r131 = new wu8.c.e(r48);
        ((HashMap) r16.h).put(ContentType.PROLOGUE.getValue(), CollectionsKt.listOf(r131.a));
        r36.add(r131);
    L155:
        r48 = null;
        goto L156
    L160:
        if (r16.g.c == false) goto L103;
        r16.g.c = false;
        if (r38 == null) goto L166;
        List<String> r49 = r38.content;
        if (r49 == null) goto L166;
        String r50 = (String) CollectionsKt.firstOrNull(r49);
    L167:
        if (r50 != null) goto L169;
        r50 = "";
    L169:
        wu8.c.C0140c r132 = new wu8.c.C0140c(r50);
        ((HashMap) r16.h).put(ContentType.DESC.getValue(), CollectionsKt.listOf(r132.a));
        r36.add(r132);
    L166:
        r50 = null;
        goto L167
    L171:
        if (r16.g.b == false) goto L103;
        r16.g.b = false;
        if (r38 == null) goto L177;
        List<String> r51 = r38.content;
        if (r51 == null) goto L177;
        String r52 = (String) CollectionsKt.firstOrNull(r51);
    L178:
        if (r52 != null) goto L180;
        r52 = "";
    L180:
        wu8.c.d r133 = new wu8.c.d(r52);
        ((HashMap) r16.h).put(ContentType.NAME.getValue(), CollectionsKt.listOf(r133.a));
        r36.add(r133);
    L177:
        r52 = null;
        goto L178
    L107:
        r126 = null;
        goto L108
    L181:
        r16.m(r36);
        qu8.b.d("enrich", 0);
        if (r16.g.a == true) goto L185;
        qu8.b.d("bot_create_auto_fill", 0);
    L185:
        ArrayList r53 = new ArrayList();
        boolean r54 = r16.g.b;
        if (r54 == false) goto L188;
        r53.add(ContentType.NAME);
        qu8.b.d("enrich", 30014);
        FLogger.a.e("BotAutoFillViewModel", "gen bot name is empty");
    L188:
        boolean r55 = r16.g.c;
        if (r55 == false) goto L191;
        r53.add(ContentType.DESC);
        qu8.b.d("enrich", 30011);
        FLogger.a.e("BotAutoFillViewModel", "gen bot description is empty");
    L191:
        boolean r134 = r16.g.e;
        if (r134 == false) goto L194;
        r53.add(ContentType.PROLOGUE);
        qu8.b.d("enrich", 30013);
        FLogger.a.e("BotAutoFillViewModel", "gen bot prologue is empty");
    L194:
        boolean r135 = r16.g.f;
        if (r135 == false) goto L197;
        r53.add(ContentType.SUGGEST);
        qu8.b.d("enrich", 30012);
        FLogger.a.e("BotAutoFillViewModel", "gen bot suggests is empty");
    L197:
        boolean r136 = r16.g.g;
        if (r136 == false) goto L200;
        r53.add(ContentType.VOICE_ID);
        qu8.b.d("enrich", 30015);
        FLogger.a.e("BotAutoFillViewModel", "gen bot voice is empty");
    L200:
        boolean r137 = r16.g.h;
        if (r137 == false) goto L204;
        r53.add(ContentType.BIO);
        qu8.b.d("enrich", 30016);
        FLogger.a.e("BotAutoFillViewModel", "gen bot bio is empty");
    L204:
        if (r54 == true) goto L211;
        if (r55 == true) goto L211;
        if (r134 == true) goto L211;
        if (r135 == true) goto L211;
        if (r136 == true) goto L211;
        if (r137 == false) goto L293;
    L211:
        if (r16.g.a == true) goto L213;
        qu8.b.d("bot_create_auto_fill", 3001);
    L213:
        String r56 = BotAutoFillViewModel.y(r53);
        Intrinsics.checkNotNullParameter(r56, "<this>");
        r16.L(new b.C0054b(new TextRes.PlainText(r56)));
        if (r54 == false) goto L216;
        String r57 = "name";
    L218:
        if (r55 == true) goto L220;
    L226:
        if (r134 == true) goto L228;
    L234:
        if (r135 == true) goto L236;
    L242:
        if (r136 == true) goto L244;
    L250:
        o.a.b("enrich_incomplete", com.larus.utils.f.c(new Pair[]{TuplesKt.to("empty_params", r57)}));
        goto L293
    L244:
        if (r57.length() <= 0) goto L246;
        boolean r58 = true;
    L247:
        if (r58 == false) goto L249;
        r57 = r57.concat(",");
    L249:
        r57 = r57 + "voice";
        goto L250
    L246:
        r58 = false;
        goto L247
    L236:
        if (r57.length() <= 0) goto L238;
        boolean r59 = true;
    L239:
        if (r59 == false) goto L241;
        r57 = r57.concat(",");
    L241:
        r57 = r57 + "suggest";
        goto L242
    L238:
        r59 = false;
        goto L239
    L228:
        if (r57.length() <= 0) goto L230;
        boolean r60 = true;
    L231:
        if (r60 == false) goto L233;
        r57 = r57.concat(",");
    L233:
        r57 = r57 + "prologue";
        goto L234
    L230:
        r60 = false;
        goto L231
    L220:
        if (r57.length() <= 0) goto L222;
        boolean r61 = true;
    L223:
        if (r61 == false) goto L225;
        r57 = r57.concat(",");
    L225:
        r57 = r57 + "description";
        goto L226
    L222:
        r61 = false;
        goto L223
    L216:
        r57 = "";
        goto L218
    L51:
        r29 = null;
        goto L52
    L44:
        if (r110.isEmpty() == true) goto L47;
        r27 = false;
    L41:
        r110 = null;
        goto L42
    L184:
        FLogger.a.e("BotAutoFillViewModel", "requireEnrichBot failed");
        goto L185
    L22:
        if (r21.isEmpty() == true) goto L25;
        r22 = false;
        goto L27
    L18:
        r20 = null;
        goto L19
    L251:
        int r62 = this.$curRetryCount;
        int r63 = this.$maxRetryCount;
        if (r62 >= r63) goto L256;
        this.label = 2;
        int r64 = BotAutoFillViewModel.x;
        if (this.this$0.x(this.$requestParam, r62 + 1, r63) != r1) goto L293;
        return r1;
    L256:
        FLogger r65 = FLogger.a;
        StringBuilder r66 = new StringBuilder("requireEnrichBot failed, error code = ");
        boolean r67 = r14 instanceof com.larus.network.http.f;
        if (r67 == false) goto L259;
        com.larus.network.http.f r68 = r14;
    L260:
        if (r68 == null) goto L264;
        AsyncThrowable r69 = r68.d;
        if (r69 == null) goto L264;
        Long r70 = Boxing.boxLong(r69.getCode());
    L265:
        r66.append(r70);
        r65.e("BotAutoFillViewModel", r66.toString());
        BizResponse.Companion.getClass();
        long[] r71 = BizResponse.access$getCODE_RISK_CONTROL$cp();
        if (r67 == false) goto L268;
        com.larus.network.http.f r72 = r14;
    L269:
        if (r72 == null) goto L273;
        AsyncThrowable r73 = r72.d;
        if (r73 == null) goto L273;
        long r74 = r73.getCode();
    L275:
        if (ArraysKt.contains(r71, r74) == false) goto L284;
        BotAutoFillViewModel r75 = this.this$0;
        if (r67 == false) goto L279;
        com.larus.network.http.f r76 = r14;
    L280:
        if (r76 == null) goto L282;
        AsyncThrowable r77 = r76.d;
    L283:
        BotAutoFillViewModel.D(r75, r77);
    L285:
        if (r67 == false) goto L287;
        com.larus.network.http.f r78 = r14;
    L288:
        if (r78 == null) goto L292;
        AsyncThrowable r79 = r78.d;
        if (r79 == null) goto L292;
        r15 = r79.getCode();
    L292:
        qu8.b.d("enrich", r15);
        goto L293
    L287:
        r78 = null;
        goto L288
    L282:
        r77 = null;
        goto L283
    L279:
        r76 = null;
        goto L280
    L284:
        BotAutoFillViewModel r80 = this.this$0;
        b.C0054b r81 = new b.C0054b(new TextRes.StringResId(2131897469));
        int r82 = BotAutoFillViewModel.x;
        r80.L(r81);
    L273:
        r74 = 0;
        goto L275
    L268:
        r72 = null;
    L264:
        r70 = null;
        goto L265
    L259:
        r68 = null;
        goto L260
    L10:
        ResultKt.throwOnFailure(r18);
        UgcBotRepo r83 = this.this$0.n;
        BotEnrichParam r84 = this.$requestParam;
        this.label = 1;
        r83.getClass();
        r13 = UgcBotRepo.h(r84, this);
        if (r13 != r1) goto L13;
        return r1;
    }
}
