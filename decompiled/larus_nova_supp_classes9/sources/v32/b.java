package v32;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface b {
    Bitmap a();

    boolean b(PointF r1, boolean r2);

    void c(a r1);

    void clear();

    View getTapView();

    void init();

    void load();

    void unload();
}
