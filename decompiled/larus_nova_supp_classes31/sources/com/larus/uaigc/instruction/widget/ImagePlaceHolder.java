package com.larus.uaigc.instruction.widget;

import android.animation.ObjectAnimator;
import android.view.animation.LinearInterpolator;
import com.larus.common_ui.view.ViewBindingHolder;
import com.larus.uaigc.impl.databinding.LarusUaigcItemActionbarImageListPlaceHolderBinding;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/larus/uaigc/instruction/widget/ImagePlaceHolder;", "Lcom/larus/common_ui/view/ViewBindingHolder;", "binding", "Lcom/larus/uaigc/impl/databinding/LarusUaigcItemActionbarImageListPlaceHolderBinding;", "<init>", "(Lcom/larus/uaigc/impl/databinding/LarusUaigcItemActionbarImageListPlaceHolderBinding;)V", "getBinding", "()Lcom/larus/uaigc/impl/databinding/LarusUaigcItemActionbarImageListPlaceHolderBinding;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ImagePlaceHolder extends ViewBindingHolder {
    public ImagePlaceHolder(LarusUaigcItemActionbarImageListPlaceHolderBinding r4) {
        Intrinsics.checkNotNullParameter(r4, "binding");
        super(r4);
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r4.b, "translationX", new float[]{c7.c(-84), c7.c(84)});
        r5.setDuration(700);
        r5.setInterpolator(new LinearInterpolator());
        r5.setRepeatCount(-1);
        r5.setRepeatMode(1);
        r5.start();
    }
}
