package ag;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Movie;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Movie f162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f163b;

    public b(Movie r5) {
        this.f163b = new ArrayList();
        this.f162a = r5;
    }

    public static void b() {
        AnimatedDrawableFrameInfo.DisposalMethod r5 = AnimatedDrawableFrameInfo.DisposalMethod.DISPOSE_DO_NOT;
    }

    public final void a() {
        Canvas r5 = new Canvas(Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888));
        ArrayList r10 = new ArrayList();
        int r11 = 0;
        int r12 = 0;
    L3:
        Movie r13 = this.f162a;
        if (r12 >= r13.duration()) goto L10;
        if (r13.setTime(r12) == true) goto L8;
        if (r12 == 0) goto L8;
    L9:
        r12 = r12 + 17;
    L8:
        r13.draw(r5, 0.0f, 0.0f);
        r10.add(Integer.valueOf(r12));
        goto L9
    L10:
        int r14 = r10.size() - 1;
    L11:
        ArrayList r15 = this.f163b;
        if (r11 >= r14) goto L14;
        int r16 = r11 + 1;
        r15.add(Integer.valueOf(((Integer) r10.get(r16)).intValue() - ((Integer) r10.get(r11)).intValue()));
        r11 = r16;
        goto L11
    L14:
        r15.add(Integer.valueOf(r13.duration() - ((Integer) androidx.constraintlayout.motion.widget.a.h(r10, 1)).intValue()));
    }
}
