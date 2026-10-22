package f;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class a implements TransformationMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Locale f7232a;

    public a(Context r8) {
        this.f7232a = r8.getResources().getConfiguration().locale;
    }

    @Override // android.text.method.TransformationMethod
    public final CharSequence getTransformation(CharSequence r8, View r10) {
        if (r8 != null) goto L6;
        return null;
    L6:
        return r8.toString().toUpperCase(this.f7232a);
    }

    @Override // android.text.method.TransformationMethod
    public final void onFocusChanged(View r8, CharSequence r10, boolean r11, int r12, Rect r13) {
    }
}
