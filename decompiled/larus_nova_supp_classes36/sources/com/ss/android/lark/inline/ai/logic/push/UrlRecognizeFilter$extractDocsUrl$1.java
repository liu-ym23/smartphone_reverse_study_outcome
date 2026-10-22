package com.ss.android.lark.inline.ai.logic.push;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.google.gson.Gson;
import com.ss.android.lark.appsetting.api.e;
import com.ss.android.lark.ccm_api.ICCMApi;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.inline.ai.logic.push.UrlRecognizeFilter$extractDocsUrl$1", f = "UrlRecognizeFilter.kt", i = {0, 0, 0, 0, 0}, l = {124}, m = "invokeSuspend", n = {"m", "urlMetaMap", "url", "docsMetaFromLocal", "localToken"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
final class UrlRecognizeFilter$extractDocsUrl$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ int $seqId;
    final /* synthetic */ String $taskId;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ b this$0;

    public UrlRecognizeFilter$extractDocsUrl$1(String r1, String r2, int r3, b r4, Continuation<? super UrlRecognizeFilter$extractDocsUrl$1> r5) {
        this.$content = r1;
        this.$taskId = r2;
        this.$seqId = r3;
        this.this$0 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        UrlRecognizeFilter$extractDocsUrl$1 r6 = new UrlRecognizeFilter$extractDocsUrl$1(this.$content, this.$taskId, this.$seqId, this.this$0, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x0139 -> B:94:0x0294). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x0173 -> B:124:0x017c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x0255 -> B:94:0x0294). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:93:0x0279 -> B:94:0x0294). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r20) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        int r8 = 1;
        if (r0 == 0) goto L13;
        if (r0 != 1) goto L12;
        String r1 = (String) this.L$4;
        obb.b r9 = (obb.b) this.L$3;
        String r10 = (String) this.L$2;
        ConcurrentHashMap r11 = (ConcurrentHashMap) this.L$1;
        Matcher r12 = (Matcher) this.L$0;
        ResultKt.throwOnFailure(r20);     // Catch: Throwable -> L8
        Object r14 = r20;
        Matcher r13 = r12;
        ConcurrentHashMap r15 = r11;
        String r16 = r10;
        UrlRecognizeFilter$extractDocsUrl$1 r17 = this;
    L124:
        obb.b r18 = (obb.b) r14;     // Catch: Throwable -> L83
        String r19 = r18.h;     // Catch: Throwable -> L83
        if (r19 != null) goto L68;
        r19 = "";
    L68:
        if (r19.length() != 0) goto L70;
        boolean r110 = true;
    L71:
        if (r110 == false) goto L77;
        r19 = ((ICCMApi) ApiUtils.getApi(ICCMApi.class)).getDocumentDefaultName(LarkContext.getApplication(), r18.getType());     // Catch: Throwable -> L74
    L74:
        Throwable th = th;
        UrlRecognizeFilter$extractDocsUrl$1 r21 = r17;
        r11 = r15;
        r12 = r13;
    L93:
        Log.e("UrlRecognizeFilter", "parse url error! taskId = " + r21.$taskId + ", seqId = " + r21.$seqId, th);
    L94:
        r8 = 1;
    L39:
        if (r12.find() == false) goto L95;
        String r111 = r21.$content.substring(r12.start(), r12.end());
        Log.i("UrlRecognizeFilter", "start process url: " + r111.hashCode() + ". taskId = " + r21.$taskId + ", seqId = " + r21.$seqId);
        obb.b r3 = b.c(r21.this$0, r111);     // Catch: Throwable -> L91
        if (r3 == null) goto L114;
        String r112 = r3.b;     // Catch: Throwable -> L91
        if (r112 != null) goto L46;
    L49:
        boolean r113 = true;
    L50:
        if (r113 == true) goto L114;
        if (r3.getType() == (-1)) goto L114;
        String r114 = r3.b;     // Catch: Throwable -> L91
        if (r114 != null) goto L57;
        r114 = "";
    L57:
        Map r115 = (Map) r21.this$0.c.get(r114);     // Catch: Throwable -> L91
        if (r115 == null) goto L60;
        Log.i("UrlRecognizeFilter", "hit cache. taskId = " + r21.$taskId + ", seqId = " + r21.$seqId);     // Catch: Throwable -> L91
        r11.put(r114, r115);     // Catch: Throwable -> L91
        goto L94
    L60:
        b r116 = r21.this$0;     // Catch: Throwable -> L91
        r21.L$0 = r12;     // Catch: Throwable -> L91
        r21.L$1 = r11;     // Catch: Throwable -> L91
        r21.L$2 = r111;     // Catch: Throwable -> L91
        r21.L$3 = r3;     // Catch: Throwable -> L91
        r21.L$4 = r114;     // Catch: Throwable -> L91
        r21.label = r8;     // Catch: Throwable -> L91
        r14 = b.d(r116, r3, r21);     // Catch: Throwable -> L91
        if (r14 != r2) goto L63;
        return r2;
    L63:
        UrlRecognizeFilter$extractDocsUrl$1 r117 = r21;
        r9 = r3;
        r1 = r114;
        r13 = r12;
        r15 = r11;
        r16 = r111;
        r17 = r117;
        goto L124
    L46:
        if (r112.length() == 0) goto L49;
        r113 = false;
    L114:
        Log.i("UrlRecognizeFilter", "not a docs url. taskId = " + r21.$taskId + ", seqId = " + r21.$seqId);     // Catch: Throwable -> L89
    L89:
        th = th;
    L91:
        th = th;
        goto L93
    L95:
        Integer r4 = (Integer) r21.this$0.f.get(r21.$taskId);
        if (r4 != null) goto L98;
    L101:
        boolean r5 = true;
    L102:
        Set r6 = r11.keySet();
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r22 = r6.iterator();
    L104:
        if (r22.hasNext() == false) goto L106;
        r7.add(Boxing.boxInt(((String) r22.next()).hashCode()));
        goto L104
    L106:
        Log.i("UrlRecognizeFilter", "parse done, urlMetaMap.keys = " + String.valueOf(r7) + ", seqId = " + r21.$seqId + ", lastSeqId = " + r4 + ". taskId = " + r21.$taskId + ", seqId = " + r21.$seqId);
        if ((!r11.isEmpty()) == false) goto L111;
        if (r5 == false) goto L111;
        r21.this$0.f.put(r21.$taskId, Boxing.boxInt(r21.$seqId));
        r21.this$0.b.updateDocsMeta(r21.$taskId, r11);
    L111:
        return Unit.INSTANCE;
    L98:
        if (r21.$seqId > r4.intValue()) goto L101;
        r5 = false;
    L77:
        Pair[] r23 = new Pair[5];     // Catch: Throwable -> L83
        r23[0] = TuplesKt.to("title", r19);     // Catch: Throwable -> L81
        r23[1] = TuplesKt.to("raw_url", r16);     // Catch: Throwable -> L81
        r23[2] = TuplesKt.to("token", r1);     // Catch: Throwable -> L81
        r23[3] = TuplesKt.to("file_type", Boxing.boxInt(r9.getType()));     // Catch: Throwable -> L81
        r23[4] = TuplesKt.to("icon_type", Boxing.boxInt(r18.getType()));     // Catch: Throwable -> L81
        Map r24 = MapsKt.mapOf(r23);     // Catch: Throwable -> L81
        Log.i("UrlRecognizeFilter", "parse success, title length = " + r19.length() + ", token = " + r1.hashCode() + ", file_type = " + r9.getType() + ", icon_type = " + r18.getType() + ". taskId = " + r17.$taskId + ", seqId = " + r17.$seqId);     // Catch: Throwable -> L81
        r17.this$0.c.put(r1, r24);     // Catch: Throwable -> L81
        r15.put(r1, r24);     // Catch: Throwable -> L81
        r21 = r17;
        r11 = r15;
        r12 = r13;
    L81:
        th = th;
    L85:
        r21 = r17;
        r11 = r15;
        r12 = r13;
        goto L93
    L70:
        r110 = false;
    L83:
        th = th;
    L8:
        th = th;
        r21 = this;
        goto L93
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r20);
        CoroutineScope r25 = (CoroutineScope) this.L$0;
        String r26 = e.a.a.c("", "ccm_at_regex_config", true);
        if (r26 != null) goto L112;
        Log.e("UrlRecognizeFilter", "config is null! taskId = " + this.$taskId + ", seqId = " + this.$seqId);
        return Unit.INSTANCE;
    L112:
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L23
        Object r28 = ((Map) new Gson().fromJson(r26, Map.class)).get("linkRegex");     // Catch: Throwable -> L23
        if ((r28 instanceof String) == false) goto L20;
        String r29 = (String) r28;     // Catch: Throwable -> L23
    L21:
        Object r30 = Result.constructor-impl(r29);     // Catch: Throwable -> L23
    L26:
        if (Result.isFailure-impl(r30) == false) goto L28;
        r30 = "";
    L28:
        String r31 = (String) r30;
        if (r31 != null) goto L32;
        r31 = "";
    L32:
        if (r31.length() != 0) goto L34;
        boolean r32 = true;
    L35:
        if (r32 == false) goto L37;
        r31 = "((https?|http|ftp):\\/\\/((localhost:[0-9]{2,5})|( (([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}(2[0-4][0-9]|25[0-5]|1[0-9]{2}|[1-9][0-9]|[0-9])(:[0-9]{2,5})?))(\\/[-a-zA-Z0-9@:%_+.~#?&//=]*)?)|(((https?|http|ftp):\\/\\/)?[-a-zA-Z0-9:%._+~#=]{2,256}\\.(com|org|net|edu|gov|aero|app|biz|cat|coop|info|int|jobs|mobi|museum|name|pro|travel|arpa|asia|xxx|google|[a-z][a-z])\\b([-a-zA-Z0-9@:%_+.~#?&//=;()$,!]*))|(^(?!data:)(?:mailto:)?[\\w.!#$%&'*+-/=?^_`{|}~]{1,2000}@[A-Za-z0-9.-]+\\.(com|org|net|edu|gov|aero|app|biz|cat|coop|info|int|jobs|mobi|museum|name|pro|travel|arpa|asia|xxx|[a-z][a-z]))";
    L37:
        Matcher r33 = PatternProtector.compile(r31).matcher(this.$content);
        ConcurrentHashMap r34 = new ConcurrentHashMap();
        new ArrayList();
        r12 = r33;
        r11 = r34;
        r21 = this;
        goto L39
    L34:
        r32 = false;
        goto L35
    L20:
        r29 = null;
    L23:
        th = move-exception;
        Result.Companion r35 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    }
}
