package com.bytedance.ai.uiu;

import com.bytedance.ai.model.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.m0;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.uiu.UIUContextManager$getTargetPagesUiContext$2", f = "UIUContextManager.kt", i = {0, 0}, l = {110}, m = "invokeSuspend", n = {"jsonAry", "targetRunningPage"}, s = {"L$0", "L$1"})
@SourceDebugExtension({"SMAP\nUIUContextManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UIUContextManager.kt\ncom/bytedance/ai/uiu/UIUContextManager$getTargetPagesUiContext$2\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n+ 3 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n+ 4 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,342:1\n535#2:343\n520#2,6:344\n126#3:350\n153#3,3:351\n37#4,2:354\n1872#5,2:356\n1874#5:359\n1#6:358\n*S KotlinDebug\n*F\n+ 1 UIUContextManager.kt\ncom/bytedance/ai/uiu/UIUContextManager$getTargetPagesUiContext$2\n*L\n99#1:343\n99#1:344,6\n104#1:350\n104#1:351,3\n110#1:354,2\n113#1:356,2\n113#1:359\n*E\n"})
final class UIUContextManager$getTargetPagesUiContext$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinkedHashMap f2803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f2805c;
    public final /* synthetic */ Function1 d;
    public final /* synthetic */ String e;

    public UIUContextManager$getTargetPagesUiContext$2(Function1 r5, String r10, Continuation r11) {
        this.d = r5;
        this.e = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        UIUContextManager$getTargetPagesUiContext$2 r11 = new UIUContextManager$getTargetPagesUiContext$2(this.d, this.e, r10);
        r11.f2805c = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((UIUContextManager$getTargetPagesUiContext$2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r18) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.f2804b;
        int r11 = 0;
        if (r10 == 0) goto L12;
        if (r10 != 1) goto L11;
        LinkedHashMap r12 = this.f2803a;
        JSONArray r13 = (JSONArray) this.f2805c;
        ResultKt.throwOnFailure(r18);     // Catch: Exception -> L8
        LinkedHashMap r14 = r12;
        JSONArray r15 = r13;
        Object r16 = r18;
    L34:
        List r17 = (List) r16;     // Catch: Exception -> L21
        String r19 = "UIU pageContexts: " + r17;     // Catch: Exception -> L21
        Intrinsics.checkNotNullParameter("com.bytedance.ai.uiu.c", "tag");     // Catch: Exception -> L21
        t0.d r20 = com.bytedance.ai.utils.c.f2846a;     // Catch: Exception -> L21
        if (r20 == null) goto L37;
        r20.d("com.bytedance.ai.uiu.c", r19);     // Catch: Exception -> L21
    L37:
        Iterator r21 = r17.iterator();     // Catch: Exception -> L21
    L38:
        if (r21.hasNext() == false) goto L67;
        Object r22 = r21.next();     // Catch: Exception -> L21
        int r23 = r11 + 1;     // Catch: Exception -> L21
        if (r11 >= 0) goto L43;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L21
    L43:
        String r24 = (String) r22;     // Catch: Exception -> L21
        com.bytedance.ai.model.widgets.a r25 = (com.bytedance.ai.model.widgets.a) ((Pair) MapsKt.c(r14).get(r11)).getSecond();     // Catch: Exception -> L21
        JSONObject r26 = new JSONObject();     // Catch: Exception -> L21
        if (com.bytedance.ai.utils.c.l(r25.f2330b.getMessageId()) == false) goto L46;
        String r110 = r25.f2330b.getMessageId();     // Catch: Exception -> L21
    L47:
        r26.put("cardId", r110);     // Catch: Exception -> L21
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L50
        Object r27 = Result.m124constructorimpl(new JSONObject(r24));     // Catch: Throwable -> L50
    L52:
        Throwable r112 = Result.m127exceptionOrNullimpl(r27);     // Catch: Exception -> L21
        if (r112 == null) goto L58;
        String r28 = "Convert pages " + r25.f2330b.getMessageId() + " uicontext e:" + r112;     // Catch: Exception -> L21
        Intrinsics.checkNotNullParameter("com.bytedance.ai.uiu.c", "tag");     // Catch: Exception -> L21
        t0.d r113 = com.bytedance.ai.utils.c.f2846a;     // Catch: Exception -> L21
        if (r113 == null) goto L57;
        r113.d("com.bytedance.ai.uiu.c", r28);     // Catch: Exception -> L21
    L57:
        Unit r29 = Unit.INSTANCE;     // Catch: Exception -> L21
    L58:
        JSONObject r30 = new JSONObject();     // Catch: Exception -> L21
        if (Result.m130isFailureimpl(r27) == false) goto L61;
        r27 = r30;
    L61:
        r26.put("cardContext", r27);     // Catch: Exception -> L21
        r15.put(r26);     // Catch: Exception -> L21
        r11 = r23;
        goto L38
    L50:
        th = move-exception;
        Result.Companion r114 = Result.Companion;     // Catch: Exception -> L21
        r27 = Result.m124constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L21
        goto L52
    L46:
        r110 = r25.f2330b.getPageId();     // Catch: Exception -> L21
    L67:
        Function1 r31 = this.d;
        JSONObject r32 = new JSONObject();
        r32.put("pageInfo", r15);
        r31.invoke(c.d(r32.toString()));
        return Unit.INSTANCE;
    L21:
        Exception e = e;
        r13 = r15;
    L63:
        String r33 = "Get pages ui context e:" + e;
        Intrinsics.checkNotNullParameter("com.bytedance.ai.uiu.c", "tag");
        t0.d r34 = com.bytedance.ai.utils.c.f2846a;
        if (r34 == null) goto L66;
        r34.d("com.bytedance.ai.uiu.c", r33);
    L66:
        r15 = r13;
    L8:
        e = e;
        goto L63
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r18);
        CoroutineScope r35 = (CoroutineScope) this.f2805c;
        r15 = new JSONArray();
        LinkedHashMap r36 = p.f2293b;     // Catch: Exception -> L21
        String r37 = this.e;     // Catch: Exception -> L21
        r14 = new LinkedHashMap();     // Catch: Exception -> L21
        Iterator r38 = r36.entrySet().iterator();     // Catch: Exception -> L21
    L15:
        if (r38.hasNext() == false) goto L24;
        Map.Entry r39 = (Map.Entry) r38.next();     // Catch: Exception -> L21
        if (Intrinsics.areEqual(((com.bytedance.ai.model.widgets.a) r39.getValue()).f2330b.getMessageId(), r37) == true) goto L23;
        if (Intrinsics.areEqual(((com.bytedance.ai.model.widgets.a) r39.getValue()).f2330b.getPageId(), r37) == false) goto L15;
    L23:
        r14.put(r39.getKey(), r39.getValue());     // Catch: Exception -> L21
        goto L15
    L24:
        ArrayList r115 = new ArrayList(r14.size());     // Catch: Exception -> L21
        Iterator r116 = r14.entrySet().iterator();     // Catch: Exception -> L21
    L26:
        if (r116.hasNext() == false) goto L28;
        r115.add(BuildersKt.async$default(r35, null, null, new UIUContextManager$getTargetPagesUiContext$2$pageContextTasks$1$1((com.bytedance.ai.model.widgets.a) ((Map.Entry) r116.next()).getValue(), null), 3, null));     // Catch: Exception -> L21
        goto L26
    L28:
        m0[] r40 = (m0[]) r115.toArray(new m0[0]);     // Catch: Exception -> L21
        m0[] r41 = (m0[]) Arrays.copyOf(r40, r40.length);     // Catch: Exception -> L21
        this.f2805c = r15;     // Catch: Exception -> L21
        this.f2803a = r14;     // Catch: Exception -> L21
        this.f2804b = 1;     // Catch: Exception -> L21
        if (r41.length != 0) goto L31;
        r16 = CollectionsKt.emptyList();     // Catch: Exception -> L21
    L32:
        if (r16 != r5) goto L34;
        return r5;
    L31:
        r16 = new kotlinx.coroutines.e(r41).a(this);     // Catch: Exception -> L21
        goto L32
    }
}
