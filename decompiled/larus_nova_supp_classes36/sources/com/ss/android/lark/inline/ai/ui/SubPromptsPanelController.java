package com.ss.android.lark.inline.ai.ui;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.inline.ai.ui.prompts.PromptsRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class SubPromptsPanelController {
    public static final /* synthetic */ int g = 0;
    public final wlb.h a;
    public final wlb.e b;
    public final FragmentActivity c;
    public final List<Triple<View, InlineAIDragView, Function0<Unit>>> d;
    public PromptsRecyclerView e;
    public InlineAIDragView f;

    public static final class a {
    }

    static {
    }

    public final boolean b() {
        if (((ArrayList) this.d).size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final FragmentActivity getActivity() {
        return this.c;
    }

    public SubPromptsPanelController(wlb.h r2, wlb.e r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.a = r2;
        this.b = r3;
        this.c = r2.getActivity();
        this.d = new ArrayList();
    }

    public final void a(boolean r4, boolean r5) {
        if (r4 == false) goto L7;
        ArrayList r6 = new ArrayList();
        r6.addAll(this.d);
        ((ArrayList) this.d).clear();
        Iterator r7 = r6.iterator();
    L5:
        if (r7.hasNext() == false) goto L13;
        final Triple r0 = (Triple) r7.next();
        ((InlineAIDragView) r0.getSecond()).g(r5, new SubPromptsPanelController$hideInternal$1$1(this, r0));
        goto L5
    L13:
        return;
    L7:
        final Triple r8 = (Triple) CollectionsKt.removeLastOrNull(this.d);
        if (r8 == null) goto L12;
        ((InlineAIDragView) r8.getSecond()).g(r5, new SubPromptsPanelController$hideInternal$2$1(this, r8));
        return;
    }
}
