package com.ss.android.lark.keyboard.keyboard2;

import android.view.View;
import android.view.ViewGroup;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.keyboard.widget.KBMenuContainerView;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface f {
    public static final a a = null;

    public static final class a implements f {
        public static final /* synthetic */ a b = null;

        static {
            b = new a();
        }

        public a() {
        }

        @Override // com.ss.android.lark.keyboard.keyboard2.f
        public final void a(KBMenuContainerView r3, List<? extends View> r4) {
            Intrinsics.checkNotNullParameter(r3, "container");
            Intrinsics.checkNotNullParameter(r4, "visibleChildViews");
            int r5 = UIUtils.dp2px(r3.getContext(), 6.0f);
            Iterator<T> r6 = r4.iterator();
        L4:
            if (r6.hasNext() == false) goto L10;
            View r0 = (View) r6.next();
            ViewGroup.LayoutParams r1 = r0.getLayoutParams();
            if (r1 == null) goto L9;
            ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
            r2.rightMargin = r5;
            r0.setLayoutParams(r2);
            goto L4
        L9:
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
    }

    static {
        a = a.b;
    }

    void a(KBMenuContainerView r1, List<? extends View> r2);
}
