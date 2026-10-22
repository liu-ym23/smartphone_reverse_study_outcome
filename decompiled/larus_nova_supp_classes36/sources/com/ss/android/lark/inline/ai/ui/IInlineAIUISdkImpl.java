package com.ss.android.lark.inline.ai.ui;

import android.content.Intent;
import com.ss.android.lark.inline.ai.OnBoardingHelper;
import com.ss.android.lark.inline.ai.api.ui.InlineAIPanel;
import com.ss.android.lark.inline.ai.api.ui.PromptGroup;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class IInlineAIUISdkImpl implements wlb.c {
    public static final /* synthetic */ int h = 0;
    public final wlb.e a;
    public final Lazy b;
    public final nsb.b c;
    public final OnBoardingHelper d;
    public final StateFlowImpl e;
    public final Lazy f;
    public final Lazy g;

    public static final class a {
    }

    public static final class b {
        public b() {
        }
    }

    static {
    }

    @Override // wlb.c
    public final void a() {
        Log.i("IInlineAIUISdkImpl", "hidePanel");
        e().hide();
    }

    @Override // wlb.c
    public final void c() {
        Log.i("IInlineAIUISdkImpl", "hideSubPanel");
        e().c();
    }

    @Override // wlb.c
    public final void destroy() {
        Log.i("IInlineAIUISdkImpl", "destroy");
        e().destroy();
    }

    public final com.ss.android.lark.inline.ai.ui.b e() {
        return (com.ss.android.lark.inline.ai.ui.b) this.b.getValue();
    }

    @Override // wlb.c
    public final i1<Boolean> isShowing() {
        return (i1) this.g.getValue();
    }

    @Override // wlb.c
    public final boolean onBackPressed() {
        return e().onBackPressed();
    }

    @Override // wlb.c
    public final void d(InlineAIPanel r5) {
        Intrinsics.checkNotNullParameter(r5, "panel");
        nsb.b r0 = this.d.b;
        boolean r1 = false;
        if (r0 == null) goto L7;
        i1<Boolean> r2 = r0.d();
        if (r2 == null) goto L7;
        boolean r3 = ((Boolean) r2.getValue()).booleanValue();
    L8:
        if (r3 == true) goto L10;
    L17:
        e().d(r5);
        return;
    L10:
        if (r5.getShowOnboarding() == false) goto L17;
        OnBoardingHelper r4 = this.d;
        b r6 = new b();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r6, "callback");
        nsb.b r7 = r4.b;
        if (r7 != null) goto L14;
        Log.i("InlineAISdkImpl", "MyAIApi unavailable, skip tryOnBoarding");
    L15:
        if (r1 == true) goto L19;
        Log.i("IInlineAIUISdkImpl", "tryOnBoarding skipped, fallback to show panel directly");
        e().d(r5);
        return;
    L19:
        return;
    L14:
        r1 = r7.c();
    L7:
        r3 = false;
        goto L8
    }

    public IInlineAIUISdkImpl(final wlb.h r4, wlb.e r5) {
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r5, "callback");
        this.a = r5;
        this.b = LazyKt.lazy(new IInlineAIUISdkImpl$mInlineAIPanelController$2(r4, this));
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L5
        Object r7 = Result.constructor-impl((nsb.b) LarkContext.spiByDwarf(nsb.b.class));     // Catch: Throwable -> L5
    L7:
        Throwable r0 = Result.exceptionOrNull-impl(r7);
        if (r0 == null) goto L11;
        Log.w("IInlineAIUISdkImpl", "MyAIApi unavailable, degrade inline ai optional abilities", r0);
    L11:
        if (Result.isFailure-impl(r7) == false) goto L13;
        r7 = null;
    L13:
        nsb.b r8 = (nsb.b) r7;
        this.c = r8;
        this.e = j1.a(Boolean.FALSE);
        this.f = LazyKt.lazy(new IInlineAIUISdkImpl$isEnable$2(this));
        this.g = LazyKt.lazy(new AnonymousClass2(this));
        this.d = new OnBoardingHelper(r4, this.a, r8);
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // wlb.c
    public final void onActivityResult(int r2, int r3, Intent r4) {
        e().onActivityResult(r2, r3, r4);
    }

    @Override // wlb.c
    public final void b(List<PromptGroup> r3, String r4, boolean r5, Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r3, "promptList");
        Log.i("IInlineAIUISdkImpl", "showSubPromptsPanel: " + r3 + ", maskType = " + r4);
        e().b(r3, r4, r5, r6);
    }
}
