package wvb;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.larksuite.component.universe_design.color.UDColorUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(ImageView r0, int r1, int r2) {
        if (r0 == null) goto L7;
        r0.setImageResource(r1);
        Drawable r3 = r0.getDrawable();
        if (r3 == null) goto L8;
        r3.setTint(UDColorUtils.getColor(r0.getContext(), r2));
        return;
    L8:
        return;
    }
}
