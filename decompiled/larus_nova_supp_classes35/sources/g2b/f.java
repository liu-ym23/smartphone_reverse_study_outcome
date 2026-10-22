package g2b;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.ss.android.lark.chat.base.view.recycleview.ItemShineManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ View b;
    public final /* synthetic */ Drawable c;

    public /* synthetic */ f(int r1, View r2, Drawable r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r0 = this.a;
        View r1 = this.b;
        Drawable r2 = this.c;
        if (r0 < 0) goto L5;
        r1.setBackgroundColor(r0);
    L6:
        ItemShineManager.b(r1);
        return;
    L5:
        r1.setBackground(r2);
        goto L6
    }
}
