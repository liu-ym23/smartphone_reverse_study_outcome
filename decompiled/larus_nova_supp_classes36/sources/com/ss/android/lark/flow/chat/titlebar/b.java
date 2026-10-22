package com.ss.android.lark.flow.chat.titlebar;

import com.ss.android.lark.biz.im.api.n1;
import com.ss.android.lark.widget.span.RecogniseSpansResult;
import com.suite.lark.platform.component.widget_biz_userstatus.UserStatusTextView;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements hpc.a {
    public final /* synthetic */ WeakReference<UserStatusTextView> a;
    public final /* synthetic */ FlowTitleBarComponent b;
    public final /* synthetic */ n1 c;
    public final /* synthetic */ String d;

    public b(WeakReference<UserStatusTextView> r1, FlowTitleBarComponent r2, n1 r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // hpc.a
    public final void a(Map<String, RecogniseSpansResult> r3, Map<String, String> r4) {
        UserStatusTextView r5 = this.a.get();
        if (r5 != null) goto L5;
        return;
    L5:
        FlowTitleBarComponent r0 = this.b;
        if (r0.v == r5) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r0.u, this.c) == false) goto L18;
        if (r3 == null) goto L17;
        RecogniseSpansResult r6 = r3.get(this.c.b);
        if (r6 == null) goto L19;
        r5.Q(r6, this.c.a, this.d);
        return;
    L19:
        return;
    L17:
        return;
    }
}
