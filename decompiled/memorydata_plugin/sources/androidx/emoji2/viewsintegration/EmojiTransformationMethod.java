package androidx.emoji2.viewsintegration;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.emoji2.text.EmojiCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class EmojiTransformationMethod implements TransformationMethod {
    private final TransformationMethod mTransformationMethod;

    EmojiTransformationMethod(TransformationMethod r3) {
        this.mTransformationMethod = (TransformationMethod) ZeusTransformUtils.wrapperContextForParams(r3, TransformationMethod.class, "com.obric.memorydata.plugin");
    }

    public TransformationMethod getOriginalTransformationMethod() {
        return this.mTransformationMethod;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence r3, View r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.memorydata.plugin");
        if (r4.isInEditMode() == false) goto L5;
        return r5;
    L5:
        TransformationMethod r2 = this.mTransformationMethod;
        if (r2 == null) goto L8;
        r5 = r2.getTransformation(r5, r4);
    L8:
        if (r5 != null) goto L10;
    L14:
        return r5;
    L10:
        if (EmojiCompat.get().getLoadState() != 1) goto L14;
        return EmojiCompat.get().process(r5);
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View r7, CharSequence r8, boolean r9, int r10, Rect r11) {
        CharSequence r2 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r8, CharSequence.class, "com.obric.memorydata.plugin");
        TransformationMethod r0 = this.mTransformationMethod;
        if (r0 == null) goto L6;
        r0.onFocusChanged(r7, r2, r9, r10, r11);
        return;
    }
}
