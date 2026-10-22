package com.bytedance.android.ec.adapter.impl.adapters.views;

import android.animation.Animator;
import android.view.View;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.sti.IExternalIconTemplate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements IExternalIconTemplate {
    public final View a;
    public final yd.c b;

    public final View getView() {
        return this.a;
    }

    public b(yd.c r10) {
        Intrinsics.checkNotNullParameter(r10, "realTemplate");
        this.b = r10;
        this.a = r10.getView();
    }

    public final Animator getEntryAnimation(long r10) {
        return this.b.getEntryAnimation(r10);
    }
}
