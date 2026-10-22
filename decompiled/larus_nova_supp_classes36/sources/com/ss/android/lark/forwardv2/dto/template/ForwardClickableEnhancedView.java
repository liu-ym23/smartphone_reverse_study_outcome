package com.ss.android.lark.forwardv2.dto.template;

import android.app.Activity;
import android.text.Editable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface ForwardClickableEnhancedView extends ForwardEnhancedView {

    public interface a {
        void a(boolean r1);
    }

    public interface b {
        void a(String r1);
    }

    boolean e0();

    void f(Activity r1, ConstraintLayout r2, BasicDialogContent r3);

    void k1(Editable r1);

    void l(a r1, b r2);

    boolean n0();

    void onDestroy();

    void s0(Fragment r1);

    void t1(Activity r1, ConstraintLayout r2);
}
