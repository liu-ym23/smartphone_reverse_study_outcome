package com.bytedance.android.livesdk.dslservice.lynxair.view;

import android.content.Context;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b extends com.lynx.tasm.behavior.ui.view.a implements com.bytedance.android.livesdk.dslservice.view.a {
    public final HashSet<WeakReference<LynxBaseUI>> a;

    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return x6a.d.e(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return x6a.d.f(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return x6a.d.g(this);
    }

    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return x6a.d.h(this);
    }

    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r1) {
        x6a.d.k(this, r1);
    }

    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r1) {
        x6a.d.l(this, r1);
    }

    @Override // com.bytedance.android.livesdk.dslservice.view.a
    public final void reset() {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        LynxUI r1 = (LynxBaseUI) ((WeakReference) r0.next()).get();
        if ((r1 instanceof LynxUI) == false) goto L4;
        r1.setVisibility(1);
        goto L4
    }

    public final HashSet<WeakReference<LynxBaseUI>> getAutoGoneViewSet() {
        return this.a;
    }

    public b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = new HashSet();
    }
}
