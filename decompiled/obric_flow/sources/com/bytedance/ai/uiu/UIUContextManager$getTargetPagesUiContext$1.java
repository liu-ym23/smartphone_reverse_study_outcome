package com.bytedance.ai.uiu;

import com.bytedance.ai.uiu.objects.ConversionScene;
import com.bytedance.ai.uiu.objects.PageSetting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@DebugMetadata(c = "com.bytedance.ai.uiu.UIUContextManager$getTargetPagesUiContext$1", f = "UIUContextManager.kt", i = {0, 0}, l = {60}, m = "invokeSuspend", n = {"jsonAry", "targetRunningPages"}, s = {"L$0", "L$1"})
@SourceDebugExtension({"SMAP\nUIUContextManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UIUContextManager.kt\ncom/bytedance/ai/uiu/UIUContextManager$getTargetPagesUiContext$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,342:1\n1557#2:343\n1628#2,3:344\n1872#2,2:349\n1874#2:352\n37#3,2:347\n1#4:351\n*S KotlinDebug\n*F\n+ 1 UIUContextManager.kt\ncom/bytedance/ai/uiu/UIUContextManager$getTargetPagesUiContext$1\n*L\n55#1:343\n55#1:344,3\n63#1:349,2\n63#1:352\n60#1:347,2\n*E\n"})
final class UIUContextManager$getTargetPagesUiContext$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Set f2798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f2800c;
    public final /* synthetic */ ConversionScene d;
    public final /* synthetic */ PageSetting e;
    public final /* synthetic */ Function1 f;

    public UIUContextManager$getTargetPagesUiContext$1(ConversionScene r5, PageSetting r10, Function1 r11, Continuation r12) {
        this.d = r5;
        this.e = r10;
        this.f = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        UIUContextManager$getTargetPagesUiContext$1 r11 = new UIUContextManager$getTargetPagesUiContext$1(this.d, this.e, this.f, r10);
        r11.f2800c = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((UIUContextManager$getTargetPagesUiContext$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r18) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.f2799b;
        int r11 = 0;
        if (r10 == 0) goto L12;
        if (r10 != 1) goto L11;
        Set r12 = this.f2798a;
        JSONArray r13 = (JSONArray) this.f2800c;
        ResultKt.throwOnFailure(r18);     // Catch: Exception -> L8
        Set r14 = r12;
        JSONArray r15 = r13;
        Object r16 = r18;
    L25:
        List r17 = (List) r16;     // Catch: Exception -> L17
        String r19 = "UIU pageContexts: " + r17;     // Catch: Exception -> L17
        Intrinsics.checkNotNullParameter("com.bytedance.ai.uiu.c", "tag");     // Catch: Exception -> L17
        t0.d r20 = com.bytedance.ai.utils.c.f2846a;     // Catch: Exception -> L17
        if (r20 == null) goto L28;
        r20.d("com.bytedance.ai.uiu.c", r19);     // Catch: Exception -> L17
    L28:
        Iterator r21 = r17.iterator();     // Catch: Exception -> L17
    L29:
        if (r21.hasNext() == false) goto L54;
        Object r22 = r21.next();     // Catch: Exception -> L17
        int r23 = r11 + 1;     // Catch: Exception -> L17
        if (r11 >= 0) goto L34;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L17
    L34:
        String r24 = (String) r22;     // Catch: Exception -> L17
        w0.e r25 = (w0.e) CollectionsKt.toList(r14).get(r11);     // Catch: Exception -> L17
        JSONObject r26 = new JSONObject();     // Catch: Exception -> L17
        r26.put("cardId", r25.g());     // Catch: Exception -> L17
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L37
        Object r27 = Result.m124constructorimpl(new JSONObject(r24));     // Catch: Throwable -> L37
    L39:
        Throwable r111 = Result.m127exceptionOrNullimpl(r27);     // Catch: Exception -> L17
        if (r111 == null) goto L45;
        String r28 = "Convert pages " + r25.g() + " ui context e:" + r111;     // Catch: Exception -> L17
        Intrinsics.checkNotNullParameter("com.bytedance.ai.uiu.c", "tag");     // Catch: Exception -> L17
        t0.d r112 = com.bytedance.ai.utils.c.f2846a;     // Catch: Exception -> L17
        if (r112 == null) goto L44;
        r112.e("com.bytedance.ai.uiu.c", r28);     // Catch: Exception -> L17
    L44:
        Unit r29 = Unit.INSTANCE;     // Catch: Exception -> L17
    L45:
        JSONObject r30 = new JSONObject();     // Catch: Exception -> L17
        if (Result.m130isFailureimpl(r27) == false) goto L48;
        r27 = r30;
    L48:
        r26.put("cardContext", r27);     // Catch: Exception -> L17
        r15.put(r26);     // Catch: Exception -> L17
        r11 = r23;
        goto L29
    L37:
        th = move-exception;
        Result.Companion r113 = Result.Companion;     // Catch: Exception -> L17
        r27 = Result.m124constructorimpl(ResultKt.createFailure(th));     // Catch: Exception -> L17
    L54:
        Function1 r31 = this.f;
        JSONObject r32 = new JSONObject();
        r32.put("pageInfo", r15);
        r31.invoke(c.d(r32.toString()));
        return Unit.INSTANCE;
    L17:
        Exception e = e;
        r13 = r15;
    L50:
        String r33 = "Get pages ui context e:" + e;
        Intrinsics.checkNotNullParameter("com.bytedance.ai.uiu.c", "tag");
        t0.d r34 = com.bytedance.ai.utils.c.f2846a;
        if (r34 == null) goto L53;
        r34.e("com.bytedance.ai.uiu.c", r33);
    L53:
        r15 = r13;
    L8:
        e = e;
        goto L50
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r18);
        CoroutineScope r35 = (CoroutineScope) this.f2800c;
        r15 = new JSONArray();
        r14 = c.e(this.d, this.e);     // Catch: Exception -> L17
        ArrayList r114 = new ArrayList(CollectionsKt.h(r14));     // Catch: Exception -> L17
        Iterator r115 = r14.iterator();     // Catch: Exception -> L17
    L15:
        if (r115.hasNext() == false) goto L19;
        r114.add(BuildersKt.async$default(r35, null, null, new UIUContextManager$getTargetPagesUiContext$1$pageContextTasks$1$1((w0.e) r115.next(), null), 3, null));     // Catch: Exception -> L17
        goto L15
    L19:
        m0[] r36 = (m0[]) r114.toArray(new m0[0]);     // Catch: Exception -> L17
        m0[] r37 = (m0[]) Arrays.copyOf(r36, r36.length);     // Catch: Exception -> L17
        this.f2800c = r15;     // Catch: Exception -> L17
        this.f2798a = r14;     // Catch: Exception -> L17
        this.f2799b = 1;     // Catch: Exception -> L17
        if (r37.length != 0) goto L22;
        r16 = CollectionsKt.emptyList();     // Catch: Exception -> L17
    L23:
        if (r16 != r5) goto L25;
        return r5;
    L22:
        r16 = new kotlinx.coroutines.e(r37).a(this);     // Catch: Exception -> L17
        goto L23
    }
}
