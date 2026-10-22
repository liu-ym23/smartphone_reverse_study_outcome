package com.suite.lark.platform.component.widget.floatingpanel.impl;

import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements com.suite.lark.platform.component.widget.floatingpanel.impl.container.b.a {
    public final /* synthetic */ c a;

    @Override // com.suite.lark.platform.component.widget.floatingpanel.impl.container.b.a
    public final void a() {
        c r0 = this.a;
        r0.getClass();
        Log.i("FloatingPanelPresenter", "stopListenBackEvent");
        r0.b.a();
        this.a.c().c();
    }

    public b(c r1) {
        this.a = r1;
    }
}
