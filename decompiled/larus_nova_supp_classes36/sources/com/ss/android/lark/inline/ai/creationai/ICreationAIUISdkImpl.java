package com.ss.android.lark.inline.ai.creationai;

import android.content.Intent;
import com.ss.android.lark.inline.ai.api.creationai.CreationAIPanel;
import com.ss.android.lark.inline.ai.api.creationai.FeedbackJSParams;
import com.ss.android.lark.inline.ai.api.creationai.SubPanelInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class ICreationAIUISdkImpl implements vlb.c {
    public static final /* synthetic */ int e = 0;
    public final vlb.b a;
    public final Lazy b;
    public final nsb.b c;
    public final Lazy d;

    public static final class a {
    }

    static {
    }

    @Override // vlb.c
    public final void a() {
        Log.i("ICreationAIUISdkImpl", "hidePanel");
        i().hide();
    }

    @Override // vlb.c
    public final void destroy() {
        Log.i("ICreationAIUISdkImpl", "destroy");
        i().destroy();
    }

    public final f0 i() {
        return (f0) this.b.getValue();
    }

    @Override // vlb.c
    public final i1<Boolean> isShowing() {
        return (i1) this.d.getValue();
    }

    @Override // vlb.c
    public final void e() {
        i().e();
    }

    @Override // vlb.c
    public final void g() {
        i().g();
    }

    @Override // vlb.c
    public final boolean onBackPressed() {
        return i().onBackPressed();
    }

    @Override // vlb.c
    public final void b(SubPanelInfo r2) {
        i().b(r2);
    }

    @Override // vlb.c
    public final void c(FeedbackJSParams r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Log.i("ICreationAIUISdkImpl", "showFeedback");
        i().c(r3);
    }

    @Override // vlb.c
    public final void d(SubPanelInfo r2) {
        i().d(r2);
    }

    @Override // vlb.c
    public final void f(Object r2) {
        i().f(r2);
    }

    @Override // vlb.c
    public final void h(CreationAIPanel r2) {
        Intrinsics.checkNotNullParameter(r2, "panel");
        i().h(r2);
    }

    public ICreationAIUISdkImpl(final vlb.a r3, vlb.b r4) {
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.a = r4;
        this.b = LazyKt.lazy(new ICreationAIUISdkImpl$mCreationAIPanelController$2(r3, this));
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L5
        Object r6 = Result.constructor-impl((nsb.b) LarkContext.spiByDwarf(nsb.b.class));     // Catch: Throwable -> L5
    L7:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L11;
        Log.w("ICreationAIUISdkImpl", "MyAIApi unavailable, degrade creation ai optional abilities", r7);
    L11:
        if (Result.isFailure-impl(r6) == false) goto L13;
        r6 = null;
    L13:
        this.c = (nsb.b) r6;
        this.d = LazyKt.lazy(new AnonymousClass2(this));
        return;
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // vlb.c
    public final void onActivityResult(int r1, int r2, Intent r3) {
        i().onActivityResult();
    }
}
