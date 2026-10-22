package com.ss.android.lark.inline.ai;

import com.ss.android.lark.inline.ai.logic.InlineAIController;
import com.ss.android.lark.inline.ai.logic.InlineAIRustPbWrapper;
import com.ss.android.lark.inline.ai.logic.InlineAIStatus;
import com.ss.android.lark.inline.ai.logic.InlineAIViewModel;
import com.ss.android.lark.inline.ai.logic.f;
import com.ss.android.lark.log.Log;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;
import slb.e;
import slb.g;
import slb.j;
import slb.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class IInlineAISdkImpl implements e {
    public final g a;
    public final Lazy b;
    public final i1<Boolean> c;
    public final i1<Boolean> d;

    public static final class a {
    }

    static {
    }

    @Override // slb.e
    public final void b() {
        Log.i("IInlineAISdkImpl", "retryCurrentPrompt");
        f().c.retryCurrentTask();
    }

    public final InlineAIController f() {
        return (InlineAIController) this.b.getValue();
    }

    @Override // slb.e
    public final i1<Boolean> isShowing() {
        return this.d;
    }

    public IInlineAISdkImpl(g r2) {
        Intrinsics.checkNotNullParameter(r2, "inlineAIParams");
        this.a = r2;
        this.b = LazyKt.lazy(new IInlineAISdkImpl$inlineAIController$2(this));
        this.c = (i1) f().j.getValue();
        this.d = (i1) f().h.getValue();
    }

    @Override // slb.e
    public final void d(String r5) {
        Intrinsics.checkNotNullParameter(r5, "quitType");
        Log.i("IInlineAISdkImpl", "hidePanel");
        InlineAIController r1 = f();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "quitType");
        List r0 = CollectionsKt.listOf(new InlineAIStatus[]{InlineAIStatus.Init, InlineAIStatus.Closed});
        f r2 = r1.e;
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("inlineAIState");
        r2 = null;
    L6:
        if (r0.contains(r2.a) == true) goto L9;
        r1.c.hidePanel();
        r1.i.e(r5, r1.c(), r1.b());
        return;
    }

    @Override // slb.e
    public final void e(List<m> r9) {
        Intrinsics.checkNotNullParameter(r9, "promptGroups");
        Log.i("IInlineAISdkImpl", "showPanel: " + r9);
        InlineAIController r1 = f();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r9, "promptGroups");
        int r0 = zlb.a.d;
        long r2 = System.currentTimeMillis();
        if (zlb.a.c != 0) goto L5;
        zlb.a.c = r2;
    L5:
        r1.c.showPanel(r9);
    }

    @Override // slb.e
    public final void a(j r9, List<m> r10) {
        Intrinsics.checkNotNullParameter(r9, "prompt");
        Log.i("IInlineAISdkImpl", "sendPrompt: " + r9);
        InlineAIController r1 = f();
        r1.getClass();
        Intrinsics.checkNotNullParameter(r9, "prompt");
        int r0 = zlb.a.d;
        long r2 = System.currentTimeMillis();
        if (zlb.a.c != 0) goto L5;
        zlb.a.c = r2;
    L5:
        InlineAIViewModel r3 = r1.c;
        if (r10 != null) goto L8;
        r10 = CollectionsKt.emptyList();
    L8:
        r3.updatePromptGroups(r10);
        r1.a(r9);
    }

    @Override // slb.e
    public final void c(Map<String, String> r3, e.a r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        Log.i("IInlineAISdkImpl", "triggerParamsMap: " + r3);
        List<slb.d.a> r0 = InlineAIRustPbWrapper.a;
        InlineAIRustPbWrapper.c(this.a.e, r3, r4);
    }
}
