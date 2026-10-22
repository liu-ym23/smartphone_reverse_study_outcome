package com.suite.lark.platform.component.widget.floatingpanel.impl.container;

import android.app.Activity;
import com.suite.lark.platform.component.widget.floatingpanel.impl.view.FloatingPanelView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface b {

    public interface a {
        void a();
    }

    void a();

    void b(Function0<Unit> r1);

    void c(FloatingPanelView r1);

    void d(Function0<Unit> r1);

    void dismiss();

    Activity getCurrentActivity();
}
