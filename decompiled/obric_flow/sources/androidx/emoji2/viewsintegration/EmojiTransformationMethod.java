package androidx.emoji2.viewsintegration;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
@RestrictTo({RestrictTo.Scope.LIBRARY})
class EmojiTransformationMethod implements TransformationMethod {

    @Nullable
    private final TransformationMethod mTransformationMethod;

    public EmojiTransformationMethod(@Nullable TransformationMethod r5) {
        this.mTransformationMethod = r5;
    }

    public TransformationMethod getOriginalTransformationMethod() {
        return this.mTransformationMethod;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(@Nullable CharSequence r5, @NonNull View r10) {
        if (r10.isInEditMode() == false) goto L5;
        return r5;
    L5:
        TransformationMethod r11 = this.mTransformationMethod;
        if (r11 == null) goto L8;
        r5 = r11.getTransformation(r5, r10);
    L8:
        if (r5 != null) goto L10;
    L14:
        return r5;
    L10:
        if (EmojiCompat.get().getLoadState() != 1) goto L14;
        return EmojiCompat.get().process(r5);
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View r10, CharSequence r11, boolean r12, int r13, Rect r14) {
        TransformationMethod r5 = this.mTransformationMethod;
        if (r5 == null) goto L6;
        r5.onFocusChanged(r10, r11, r12, r13, r14);
        return;
    }
}
