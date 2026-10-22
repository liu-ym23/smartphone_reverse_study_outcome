package com.bytedance.ai.applet.login;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.ai.widget.o;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import w2.r;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.login.McpLoginManager$loadAddShowWidget$1", f = "McpLoginManager.kt", i = {0}, l = {520}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class McpLoginManager$loadAddShowWidget$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r f1729c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ Activity f;

    public McpLoginManager$loadAddShowWidget$1(r r5, String r10, String r11, Activity r12, Continuation r13) {
        this.f1729c = r5;
        this.d = r10;
        this.e = r11;
        this.f = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r10, Continuation r11) {
        McpLoginManager$loadAddShowWidget$1 r12 = new McpLoginManager$loadAddShowWidget$1(this.f1729c, this.d, this.e, this.f, r11);
        r12.f1728b = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((McpLoginManager$loadAddShowWidget$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f1727a;
        if (r11 == 0) goto L12;
        if (r11 != 1) goto L11;
        CoroutineScope r12 = (CoroutineScope) this.f1728b;
        ResultKt.throwOnFailure(r10);     // Catch: Exception -> L8
    L18:
        View r13 = (View) r10;     // Catch: Exception -> L8
    L24:
        if (r13 != null) goto L31;
        Intrinsics.checkNotNullParameter("McpLoginManager", "tag");
        t0.d r14 = com.bytedance.ai.utils.c.f2846a;
        if (r14 == null) goto L29;
        r14.e("McpLoginManager", "loadAddShowWidget: widgetView is null");
    L29:
        return Unit.INSTANCE;
    L31:
        if (j.f1751b.get() != null) goto L33;
        j.f1751b = new WeakReference(new c(this.f));
    L33:
        c r15 = (c) j.f1751b.get();
        if (r15 != null) goto L40;
        Intrinsics.checkNotNullParameter("McpLoginManager", "tag");
        t0.d r16 = com.bytedance.ai.utils.c.f2846a;
        if (r16 == null) goto L39;
        r16.e("McpLoginManager", "loadAddShowWidget: cannot get drawerContainer");
    L39:
        return Unit.INSTANCE;
    L40:
        FrameLayout r17 = r15.f1738c;
        if (r17 == null) goto L44;
        r17.removeAllViews();
    L44:
        if (r13.getParent() == null) goto L49;
        Intrinsics.checkNotNullParameter("DrawerWidgetContainer", "tag");
        t0.d r18 = com.bytedance.ai.utils.c.f2846a;
        if (r18 == null) goto L48;
        r18.d("DrawerWidgetContainer", "addWidgetRenderView: removing from parent first");
    L48:
        ViewParent r19 = r13.getParent();
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r19).removeView(r13);
    L49:
        FrameLayout r20 = r15.f1738c;
        if (r20 == null) goto L52;
        r20.addView(r13, -1, -2);
    L52:
        r15.b(this.f);
        r15.c();
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r10);
        CoroutineScope r21 = (CoroutineScope) this.f1728b;
        o r22 = o.f3079j.a();     // Catch: Exception -> L8
        if (r22 == null) goto L23;
        r r23 = this.f1729c;     // Catch: Exception -> L8
        String r24 = this.d;     // Catch: Exception -> L8
        String r25 = this.e;     // Catch: Exception -> L8
        this.f1728b = r21;     // Catch: Exception -> L8
        this.f1727a = 1;     // Catch: Exception -> L8
        r10 = r22.d(r23, r24, r25, this);     // Catch: Exception -> L8
        if (r10 != r5) goto L18;
        return r5;
    L23:
        r13 = null;
    L8:
        e = move-exception;
        Intrinsics.checkNotNullParameter("McpLoginManager", "tag");
        t0.d r26 = com.bytedance.ai.utils.c.f2846a;
        if (r26 == null) goto L23;
        r26.e("McpLoginManager", "loadAddShowWidget: 创建失败", e);
        goto L23
    }
}
