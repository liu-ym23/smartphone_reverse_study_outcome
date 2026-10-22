package im.quar.autolayout.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import im.quar.autolayout.ViewCreator;
import im.quar.autolayout.view.AutoFrameLayout;
import im.quar.autolayout.view.AutoLinearLayout;
import im.quar.autolayout.view.AutoListView;
import im.quar.autolayout.view.AutoRecyclerView;
import im.quar.autolayout.view.AutoRelativeLayout;

/* JADX INFO: loaded from: classes2.dex */
class DefaultViewCreator implements ViewCreator {
    public DefaultViewCreator() {
    }

    @Override // im.quar.autolayout.ViewCreator
    public View create(String r8, Context r10, AttributeSet r11) {
        switch(r8.hashCode()) {
            case -703660929: goto L18;
            case -443652810: goto L15;
            case 1127291599: goto L12;
            case 1310765783: goto L9;
            case 1410352259: goto L6;
            default: goto L20;
        };
    L20:
        byte r12 = -1;
    L21:
        if (r12 == 0) goto L37;
        if (r12 == 1) goto L35;
        if (r12 == 2) goto L33;
        if (r12 == 3) goto L31;
        if (r12 == 4) goto L29;
        return null;
    L29:
        return new AutoRecyclerView(r10, r11);
    L31:
        return new AutoListView(r10, r11);
    L33:
        return new AutoFrameLayout(r10, r11);
    L35:
        return new AutoRelativeLayout(r10, r11);
    L37:
        return new AutoLinearLayout(r10, r11);
    L6:
        if (r8.equals("ListView") == false) goto L20;
        r12 = 3;
        goto L21
    L9:
        if (r8.equals("FrameLayout") == false) goto L20;
        r12 = 2;
        goto L21
    L12:
        if (r8.equals("LinearLayout") == false) goto L20;
        r12 = 0;
        goto L21
    L15:
        if (r8.equals("RelativeLayout") == false) goto L20;
        r12 = 1;
        goto L21
    L18:
        if (r8.equals("androidx.recyclerview.widget.RecyclerView") == false) goto L20;
        r12 = 4;
        goto L21
    }
}
