package com.ss.android.lark.coremdbiz.facade.plugins;

import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkImageExtend;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/widget/light/image/ImageGalleryLayout$ImageData;", "Lcom/ss/android/lark/coremdbiz/facade/bizext/props/LarkImageExtend;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ImageGalleryPlugin$prepareImageGallerySpan$1$onBindView$1$1 extends Lambda implements Function1<LarkImageExtend, com.ss.android.lark.widget.light.image.a.b> {
    final /* synthetic */ v7b.l $it;

    public ImageGalleryPlugin$prepareImageGallerySpan$1$onBindView$1$1(v7b.l r1) {
        this.$it = r1;
        super(1);
    }

    public final com.ss.android.lark.widget.light.image.a.b invoke(LarkImageExtend r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$LarkImageExtend");
        v7b.l r1 = this.$it;
        return new com.ss.android.lark.widget.light.image.a.b(r1.j, r5.f(r1), r5.d(this.$it), this.$it.k);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((LarkImageExtend) r1);
    }
}
