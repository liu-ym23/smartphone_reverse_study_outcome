package com.bytedance.ai.model.viewmodel;

import com.bytedance.assem.arch.viewModel.AssemViewModel;
import com.bytedance.assem.arch.viewModel.h;
import i5.b;
import i5.c;
import i5.d;
import i5.e;
import i5.f;
import i5.g;
import i5.i;
import i5.j;
import i5.k;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class RenderStateVM extends AssemViewModel<g> {
    public static final List<Class<?>> RENDER_STATE_LIST = null;

    public static /* synthetic */ g yo(Object r0, g r1) {
        return lambda$updateState$0(r0, r1);
    }

    static {
        RENDER_STATE_LIST = Collections.unmodifiableList(Arrays.asList(new Class[]{d.class, c.class, f.class, j.class, b.class, e.class, i.class, k.class}));
    }

    /* JADX INFO: renamed from: defaultState, reason: collision with other method in class */
    public g m19defaultState() {
        return new g();
    }

    public RenderStateVM() {
    }

    public /* bridge */ /* synthetic */ h defaultState() {
        return m19defaultState();
    }

    public void updateState(final Object r10) {
        Iterator<Class<?>> r0 = RENDER_STATE_LIST.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (r0.next() != r10.getClass()) goto L4;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        setState(new i5.h(r10));
        return;
    L13:
        throw new IllegalArgumentException("RenderState doesn't support state of " + r10.getClass());
    L8:
        r1 = false;
        goto L9
    }

    private static g lambda$updateState$0(Object r0, g r1) {
        r1.getClass();
        return new g(r0);
    }
}
