package b02;

import android.graphics.drawable.Animatable;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.ComboProgressAnimationView;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g implements p0 {
    public final /* synthetic */ ComboProgressAnimationView a;
    public final /* synthetic */ boolean b;

    public final /* synthetic */ void a(ImageInfo r1, Animatable r2) {
    }

    public final /* synthetic */ void d(ImageInfo r1) {
    }

    public final /* synthetic */ void e(py.k r1) {
    }

    public g(ComboProgressAnimationView r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void b(py.k r1, Exception r2) {
        ConstraintLayout r3 = this.a.a(2131367239);
        if (r3 == null) goto L6;
        r3.setVisibility(0);
        return;
    }

    public final void c(py.k r1, int r2, int r3, boolean r4) {
        HSImageView r5 = this.a.w;
        ViewGroup.LayoutParams r6 = null;
        if (r5 == null) goto L5;
        ViewGroup.LayoutParams r7 = r5.getLayoutParams();
    L7:
        if ((r7 instanceof ViewGroup.LayoutParams) == false) goto L19;
        float r8 = r2 / r3;
        HSImageView r9 = this.a.w;
        if (r9 == null) goto L11;
        r6 = r9.getLayoutParams();
    L11:
        if (r6 == null) goto L13;
        r6.height = (int) this.a.getContext().getResources().getDimension(2131168767);
    L13:
        if (r6 == null) goto L15;
        r6.width = (int) (r6.height * r8);
    L15:
        HSImageView r10 = this.a.w;
        if (r10 == null) goto L19;
        r10.setLayoutParams(r6);
    L19:
        if ((new Random().nextInt(10) % 2) != 0) goto L21;
        float r11 = -5.0f;
    L22:
        HSImageView r13 = this.a.w;
        if (r13 == null) goto L26;
        r13.setRotation(r11);
    L26:
        if (this.b == false) goto L29;
        ComboProgressAnimationView.c(this.a, false, false);
        return;
    L29:
        return;
    L21:
        r11 = 5.0f;
        goto L22
    L5:
        r7 = null;
        goto L7
    }
}
