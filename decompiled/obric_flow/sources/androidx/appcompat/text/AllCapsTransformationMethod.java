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

    public AllCapsTransformationMethod(Context r5) {
        this.mLocale = r5.getResources().getConfiguration().locale;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence r5, View r10) {
        if (r5 != null) goto L6;
        return null;
    L6:
        return r5.toString().toUpperCase(this.mLocale);
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View r5, CharSequence r10, boolean r11, int r12, Rect r13) {
    }
}
