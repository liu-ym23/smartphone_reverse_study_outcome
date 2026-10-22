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

    EmojiTransformationMethod(@Nullable TransformationMethod r10) {
        this.mTransformationMethod = r10;
    }

    public TransformationMethod getOriginalTransformationMethod() {
        return this.mTransformationMethod;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(@Nullable CharSequence r10, @NonNull View r11) {
        if (r11.isInEditMode() == false) goto L5;
        return r10;
    L5:
        TransformationMethod r12 = this.mTransformationMethod;
        if (r12 == null) goto L8;
        r10 = r12.getTransformation(r10, r11);
    L8:
        if (r10 != null) goto L10;
    L14:
        return r10;
    L10:
        if (EmojiCompat.get().getLoadState() != 1) goto L14;
        return EmojiCompat.get().process(r10);
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View r10, CharSequence r11, boolean r12, int r13, Rect r14) {
        TransformationMethod r15 = this.mTransformationMethod;
        if (r15 == null) goto L6;
        r15.onFocusChanged(r10, r11, r12, r13, r14);
        return;
    }
}
