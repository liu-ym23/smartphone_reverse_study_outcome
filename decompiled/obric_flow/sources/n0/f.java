package n0;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import io.reactivex.internal.observers.h;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class f {
    public static Integer d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f20192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f20193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f20194c;

    public f(ImageView r5) {
        this.f20193b = new ArrayList();
        this.f20192a = r5;
    }

    public final int a(int r5, int r10, int r11) {
        int r12 = r10 - r11;
        if (r12 <= 0) goto L5;
        return r12;
    L5:
        int r13 = r5 - r11;
        if (r13 <= 0) goto L8;
        return r13;
    L8:
        ImageView r14 = this.f20192a;
        if (r14.isLayoutRequested() == false) goto L11;
        return 0;
    L11:
        if (r10 == (-2)) goto L13;
        return 0;
    L13:
        if (Log.isLoggable("ViewTarget", 4) == false) goto L15;
        Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
    L15:
        Context r15 = r14.getContext();
        if (d != null) goto L19;
        WindowManager r16 = (WindowManager) r15.getSystemService("window");
        h.h(r16, "Argument must not be null");
        Display r17 = r16.getDefaultDisplay();
        Point r18 = new Point();
        r17.getSize(r18);
        d = Integer.valueOf(Math.max(r18.x, r18.y));
    L19:
        return d.intValue();
    }
}
