package com.bytedance.ai.uiu;

import android.view.View;
import android.webkit.WebView;
import com.bytedance.ai.model.p;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.bytedance.ai.widget.o;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import w0.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.uiu.UIUContextManager$performUIOperations$2", f = "UIUContextManager.kt", i = {0, 0, 0}, l = {196}, m = "invokeSuspend", n = {"webView", "atomResult", "uiOperation"}, s = {"L$0", "L$3", "L$5"})
@SourceDebugExtension({"SMAP\nUIUContextManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UIUContextManager.kt\ncom/bytedance/ai/uiu/UIUContextManager$performUIOperations$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,342:1\n295#2,2:343\n1863#2,2:345\n*S KotlinDebug\n*F\n+ 1 UIUContextManager.kt\ncom/bytedance/ai/uiu/UIUContextManager$performUIOperations$2\n*L\n190#1:343,2\n195#1:345,2\n*E\n"})
final class UIUContextManager$performUIOperations$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebView f2808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1 f2810c;
    public Ref.BooleanRef d;
    public Iterator e;
    public g3.a f;
    public Ref.BooleanRef g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2811h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2812i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Function1 f2813j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f2814k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ List f2815l;

    public UIUContextManager$performUIOperations$2(Function1 r5, String r10, List r11, Continuation r12) {
        this.f2813j = r5;
        this.f2814k = r10;
        this.f2815l = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new UIUContextManager$performUIOperations$2(this.f2813j, this.f2814k, this.f2815l, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((UIUContextManager$performUIOperations$2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00fd -> B:45:0x0100). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.f2812i;
        if (r10 == 0) goto L8;
        if (r10 != 1) goto L7;
        boolean r11 = this.f2811h;
        Ref.BooleanRef r13 = this.g;
        g3.a r14 = this.f;
        Iterator r15 = this.e;
        Ref.BooleanRef r16 = this.d;
        Function1 r17 = this.f2810c;
        String r18 = this.f2809b;
        WebView r19 = this.f2808a;
        ResultKt.throwOnFailure(r12);
        Ref.BooleanRef r20 = r13;
        Ref.BooleanRef r21 = r16;
        Iterator r22 = r15;
        g3.a r23 = r14;
    L45:
        r20.element = ((Boolean) r12).booleanValue() & r11;
        if (r21.element == true) goto L50;
        String r110 = "Page " + r18 + " performUiOperations error: " + r23;
        Intrinsics.checkNotNullParameter("com.bytedance.ai.uiu.c", "tag");
        t0.d r24 = com.bytedance.ai.utils.c.f2846a;
        if (r24 == null) goto L50;
        r24.d("com.bytedance.ai.uiu.c", r110);
    L50:
        Iterator r25 = r22;
    L40:
        if (r25.hasNext() == false) goto L51;
        g3.a r26 = (g3.a) r25.next();
        r11 = r21.element;
        List r111 = CollectionsKt.listOf(r26);
        this.f2808a = r19;
        this.f2809b = r18;
        this.f2810c = r17;
        this.d = r21;
        this.e = r25;
        this.f = r26;
        this.g = r21;
        this.f2811h = r11;
        this.f2812i = 1;
        r12 = c.b(r19, r111, this);
        if (r12 != r5) goto L44;
        return r5;
    L44:
        r22 = r25;
        r23 = r26;
        r20 = r21;
        goto L45
    L51:
        Unit r112 = Unit.INSTANCE;
        r17.invoke(Boxing.boxBoolean(r21.element));
    L54:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        LinkedHashMap r113 = p.f2293b;
        o r27 = o.f3079j.a();
        Intrinsics.checkNotNull(r27, "null cannot be cast to non-null type com.bytedance.ai.widget.WidgetManager");
        Set r114 = CollectionsKt.union(r113.values(), r27.e.keySet());
        String r28 = this.f2814k;
        Iterator r115 = r114.iterator();
    L9:
        WebView r29 = null;
        if (r115.hasNext() == false) goto L24;
        Object r30 = r115.next();
        w0.e r31 = (w0.e) r30;
        if ((r31 instanceof f) == false) goto L19;
        com.bytedance.ai.model.widgets.a r32 = (com.bytedance.ai.model.widgets.a) ((f) r31);
        if (Intrinsics.areEqual(r32.f2330b.getMessageId(), r28) == false) goto L16;
    L17:
        boolean r33 = true;
    L22:
        if (r33 == false) goto L9;
    L25:
        w0.e r34 = (w0.e) r30;
        if (r34 != null) goto L28;
    L37:
        if (r29 == null) goto L52;
        List r116 = this.f2815l;
        String r35 = this.f2814k;
        Function1 r36 = this.f2813j;
        Ref.BooleanRef r37 = new Ref.BooleanRef();
        r37.element = true;
        r18 = r35;
        r17 = r36;
        r19 = r29;
        r21 = r37;
        r25 = r116.iterator();
        goto L40
    L52:
        this.f2813j.invoke(Boxing.boxBoolean(false));
        goto L54
    L28:
        if ((r34 instanceof WidgetContainer) == false) goto L33;
        View r117 = ((WidgetContainer) r34).d();
        if ((r117 instanceof WebView) == false) goto L37;
        r29 = (WebView) r117;
        goto L37
    L33:
        if ((r34 instanceof f) == false) goto L37;
        View r118 = r34.d();
        if ((r118 instanceof WebView) == false) goto L37;
        r29 = (WebView) r118;
        goto L37
    L16:
        if (Intrinsics.areEqual(r32.f2330b.getPageId(), r28) == true) goto L17;
    L21:
        r33 = false;
        goto L22
    L19:
        if ((r31 instanceof WidgetContainer) == false) goto L21;
        r33 = Intrinsics.areEqual(((WidgetContainer) r31).e, r28);
        goto L22
    L24:
        r30 = null;
        goto L25
    }
}
