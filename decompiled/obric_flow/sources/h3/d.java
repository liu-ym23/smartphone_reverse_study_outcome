package h3;

import android.app.Activity;
import android.content.res.Resources;
import android.view.Window;
import com.bytedance.ai.model.p;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f17275a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f17276b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f17277c = 0;

    static {
        t0.b r5 = p.f2294c;
        if (r5 == null) goto L7;
        Activity r10 = r5.currentActivity();
        if (r10 == null) goto L7;
        Window r11 = r10.getWindow();
    L8:
        if (r11 == null) goto L10;
        int r12 = com.bytedance.ai.utils.c.f(r11).widthPixels;
    L11:
        f17275a = r12;
        f17276b = com.bytedance.ai.utils.c.k(null);
        f17277c = (int) (com.bytedance.ai.utils.c.k(null) * 0.1f);
        com.bytedance.ai.utils.c.k(null);
        return;
    L10:
        r12 = Resources.getSystem().getDisplayMetrics().widthPixels;
    L7:
        r11 = null;
        goto L8
    }
}
