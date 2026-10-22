package q0;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class h implements TransformationMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TransformationMethod f10123a;

    public h(TransformationMethod r8) {
        this.f10123a = r8;
    }

    @Override // android.text.method.TransformationMethod
    public final CharSequence getTransformation(CharSequence r8, View r10) {
        if (r10.isInEditMode() == false) goto L5;
        return r8;
    L5:
        TransformationMethod r11 = this.f10123a;
        if (r11 == null) goto L8;
        r8 = r11.getTransformation(r8, r10);
    L8:
        if (r8 != null) goto L10;
    L14:
        return r8;
    L10:
        if (androidx.emoji2.text.f.a().b() != 1) goto L14;
        androidx.emoji2.text.f r12 = androidx.emoji2.text.f.a();
        r12.getClass();
        return r12.f(0, r8.length(), r8);
    }

    @Override // android.text.method.TransformationMethod
    public final void onFocusChanged(View r8, CharSequence r10, boolean r11, int r12, Rect r13) {
        TransformationMethod r14 = this.f10123a;
        if (r14 == null) goto L6;
        r14.onFocusChanged(r8, r10, r11, r12, r13);
        return;
    }
}
