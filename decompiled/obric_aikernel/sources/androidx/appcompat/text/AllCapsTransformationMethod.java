package androidx.appcompat.text;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.annotation.RestrictTo;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AllCapsTransformationMethod implements TransformationMethod {
    private Locale mLocale;

    public AllCapsTransformationMethod(Context r10) {
        this.mLocale = r10.getResources().getConfiguration().locale;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence r10, View r11) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return r10.toString().toUpperCase(this.mLocale);
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View r10, CharSequence r11, boolean r12, int r13, Rect r14) {
    }
}
