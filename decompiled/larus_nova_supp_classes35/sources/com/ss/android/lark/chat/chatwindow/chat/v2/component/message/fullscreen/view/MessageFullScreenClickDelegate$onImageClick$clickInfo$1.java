package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.coremd.facade.bizext.props.IMImageExtend;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/widget/light/listener/ImageClickInfo;", "Lcom/ss/android/lark/coremd/facade/bizext/props/IMImageExtend;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class MessageFullScreenClickDelegate$onImageClick$clickInfo$1 extends Lambda implements Function1<IMImageExtend, mcc.p> {
    final /* synthetic */ Rect $clickBounds;
    final /* synthetic */ v7b.l $image;
    final /* synthetic */ Drawable $thumbnail;

    public MessageFullScreenClickDelegate$onImageClick$clickInfo$1(v7b.l r1, Rect r2, Drawable r3) {
        this.$image = r1;
        this.$clickBounds = r2;
        this.$thumbnail = r3;
        super(1);
    }

    public final mcc.p invoke(IMImageExtend r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$IMImageExtend");
        mcc.p r0 = new mcc.p();
        r3.h(this.$image);
        r0.c = IMImageExtend.j(this.$image);
        Rect r4 = this.$clickBounds;
        r0.f = r4.left;
        r0.g = r4.top;
        r0.d = r4.width();
        r0.e = this.$clickBounds.height();
        r0.h = this.$thumbnail;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((IMImageExtend) r1);
    }
}
