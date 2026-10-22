package com.suite.lark.platform.component.widget_biz_chatkeyboard.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.larksuite.framework.utils.KeyboardUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class KeyboardDetectorFrameLayout extends FrameLayout {
    public final List<a> a;

    public interface a {
        void a();

        void b();
    }

    public KeyboardDetectorFrameLayout(Context r2) {
        this(r2, null);
    }

    public KeyboardDetectorFrameLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r3, int r4) {
        int r0 = View.MeasureSpec.getSize(r4);
        int r1 = getHeight() - r0;
        if (r1 <= 400) goto L9;
        KeyboardUtils.setKeyboardHeight(r1);
        Iterator r2 = ((ArrayList) this.a).iterator();
    L6:
        if (r2.hasNext() == false) goto L14;
        ((a) r2.next()).a();
    L14:
        super.onMeasure(r3, r4);
        return;
    L9:
        if (r1 >= (-400)) goto L14;
        Iterator r5 = ((ArrayList) this.a).iterator();
    L12:
        if (r5.hasNext() == false) goto L14;
        ((a) r5.next()).b();
        goto L12
    }

    public KeyboardDetectorFrameLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = new ArrayList(2);
    }
}
