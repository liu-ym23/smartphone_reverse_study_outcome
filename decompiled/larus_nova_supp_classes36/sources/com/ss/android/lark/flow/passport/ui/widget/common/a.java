package com.ss.android.lark.flow.passport.ui.widget.common;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.flow.passport.ui.widget.layout.BaseContainerLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class a {
    public static final /* synthetic */ int c = 0;
    public final FragmentActivity a;
    public final BaseContainerLayout b;

    /* JADX INFO: renamed from: com.ss.android.lark.flow.passport.ui.widget.common.a$a, reason: collision with other inner class name */
    public static final class ViewOnFocusChangeListenerC0056a implements View.OnFocusChangeListener {
        public final /* synthetic */ a a;

        public ViewOnFocusChangeListenerC0056a(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r1, boolean r2) {
            if (r2 == true) goto L4;
            return;
        L4:
            if (uzb.f.c(this.a.a) == false) goto L8;
            uzb.f.b(this.a.a);
            return;
        }
    }

    public static final class b {
    }

    static {
    }

    public a(FragmentActivity r2, BaseContainerLayout r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "rootLayout");
        this.a = r2;
        this.b = r3;
        r3.setFocusable(true);
        r3.setFocusableInTouchMode(true);
        r3.setClickable(true);
        r3.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0056a(this));
    }
}
