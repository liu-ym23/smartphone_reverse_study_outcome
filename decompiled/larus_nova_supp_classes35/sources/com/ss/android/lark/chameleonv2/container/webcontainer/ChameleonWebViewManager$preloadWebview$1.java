package com.ss.android.lark.chameleonv2.container.webcontainer;

import android.webkit.WebView;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.WebViewPoolConfig;
import com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chameleonv2.container.webcontainer.ChameleonWebViewManager$preloadWebview$1", f = "ChameleonWebViewManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChameleonWebViewManager$preloadWebview$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChameleonConfig $chameleonConfig;
    final /* synthetic */ WebView $destroyWebview;
    int label;
    final /* synthetic */ ChameleonWebViewManager this$0;

    public ChameleonWebViewManager$preloadWebview$1(ChameleonWebViewManager r1, ChameleonConfig r2, WebView r3, Continuation<? super ChameleonWebViewManager$preloadWebview$1> r4) {
        this.this$0 = r1;
        this.$chameleonConfig = r2;
        this.$destroyWebview = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChameleonWebViewManager$preloadWebview$1(this.this$0, this.$chameleonConfig, this.$destroyWebview, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [android.webkit.WebView, com.ss.android.lark.chameleonv2.container.webcontainer.view.ChameleonWebView] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r8);
        com.ss.android.lark.officesdk.utils.di.j.e(this.this$0.a, "preload()... bizName = " + this.$chameleonConfig.getBizName() + ", already preload: " + this.this$0.b.containsKey(ChameleonWebViewManager.e(this.$chameleonConfig)));
        Object r9 = this.$destroyWebview;
        if ((r9 instanceof ChameleonWebView) == false) goto L7;
        ?? r10 = (ChameleonWebView) r9;
    L8:
        if (r10 == 0) goto L10;
        ChameleonWebViewManager r0 = this.this$0;
        com.ss.android.lark.officesdk.utils.di.j.e(r0.a, "preload()... destroyWebview = " + r10.hashCode());
        r0.c(r10);
    L10:
        q0b.a r11 = this.this$0.b.get(ChameleonWebViewManager.e(this.$chameleonConfig));
        if (r11 != null) goto L13;
        this.this$0.d(this.$chameleonConfig, null);
    L22:
        return Unit.INSTANCE;
    L13:
        WebViewPoolConfig r1 = r11.a();
        int r2 = r11.poolSize();
        int r3 = r11.occupiedSize();
        com.ss.android.lark.officesdk.utils.di.j.e(this.this$0.a, "preload cache pool status, poolSize = " + r2 + ", occupiedSize = " + r3 + ", coreSize = " + r1.getCoreSize() + ", poolMaxSize = " + r1.getMaxSize());
        if (r3 == r2) goto L16;
    L17:
        if (r3 < r2) goto L19;
    L23:
        com.ss.android.lark.officesdk.utils.di.j.f(this.this$0.a, "preload cache pool status, not need preload");
        return Unit.INSTANCE;
    L19:
        if (r2 >= r1.getCoreSize()) goto L23;
    L20:
        r11.b(this.$chameleonConfig, null).z();
        goto L22
    L16:
        if (r2 < r1.getMaxSize()) goto L20;
    L7:
        r10 = 0;
        goto L8
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
