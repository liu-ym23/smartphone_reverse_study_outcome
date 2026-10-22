package com.bytedance.ai.applet.render.core.relax;

import android.content.Context;
import com.relax.RelaxEnv;
import mn.i;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends dk.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i f1791c;
    public RelaxRenderView$RenderMode d;

    public final f a() {
        i r5 = this.f1791c;
        if (r5 == null) goto L7;
        RelaxEnv.inst().setRenderType(this.d.a());
        return new f((Context) this.f16659a, this.d, r5);
    L7:
        throw new IllegalArgumentException("ResourceLoader is required");
    }
}
