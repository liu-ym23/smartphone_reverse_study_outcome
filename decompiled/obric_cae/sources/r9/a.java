package r9;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.ColorStateListDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static ColorStateList a(Drawable r8) {
        if ((r8 instanceof ColorDrawable) == false) goto L7;
        return ColorStateList.valueOf(((ColorDrawable) r8).getColor());
    L7:
        if ((r8 instanceof ColorStateListDrawable) == true) goto L9;
        return null;
    L9:
        return ((ColorStateListDrawable) r8).getColorStateList();
    }
}
