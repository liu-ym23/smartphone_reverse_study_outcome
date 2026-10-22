package h08;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.toast.UDToast;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public static final Handler d = null;
    public com.ss.android.lark.compose.foundation.toast.g a;
    public UDToast.a b;
    public final Context c;

    static {
        d = new Handler(Looper.getMainLooper());
    }

    public final void a() {
        com.ss.android.lark.compose.foundation.toast.g r0 = this.a;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.a = null;
        this.b = null;
    }

    public final void c() {
        if (this.a != null) goto L8;
        UDToast.a r0 = this.b;
        if (r0 != null) goto L7;
        return;
    L7:
        this.a = r0.a();
    L8:
        this.a.show();
    }

    public b(Context r2, UDToast.a r3) {
        this.a = null;
        this.c = r2;
        this.b = r3;
    }

    public final void b(int r3, Animation r4) {
        if (r3 != (-1)) goto L6;
        return;
    L6:
        if ((r4 instanceof RotateAnimation) == true) goto L15;
        if (r3 == (-1)) goto L27;
        com.ss.android.lark.compose.foundation.toast.g r5 = this.a;
        if (r5 != null) goto L14;
        UDToast.a r6 = this.b;
        if (r6 == null) goto L22;
        r6.d(r3);
        return;
    L22:
        return;
    L14:
        r5.setIcon(r3);
        return;
    L27:
        return;
    L15:
        Drawable r7 = new CircularProgressDrawable(this.c);
        r7.setStyle(1);
        r7.setColorSchemeColors(new int[]{UDColorUtils.getColor(this.c, 2131106521)});
        r7.setStrokeCap(Paint.Cap.ROUND);
        com.ss.android.lark.compose.foundation.toast.g r8 = this.a;
        if (r8 != null) goto L20;
        UDToast.a r9 = this.b;
        if (r9 == null) goto L25;
        r9.e(r7);
        return;
    L25:
        return;
    L20:
        r8.setIcon(r7);
    }
}
