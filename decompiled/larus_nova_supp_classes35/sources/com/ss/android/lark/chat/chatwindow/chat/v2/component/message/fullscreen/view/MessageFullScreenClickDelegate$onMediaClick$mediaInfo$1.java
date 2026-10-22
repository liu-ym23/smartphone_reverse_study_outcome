package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.ss.android.lark.coremd.facade.bizext.props.IMMediaExtend;
import com.ss.android.lark.widget.span.MediaInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/widget/span/MediaInfo;", "Lcom/ss/android/lark/coremd/facade/bizext/props/IMMediaExtend;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class MessageFullScreenClickDelegate$onMediaClick$mediaInfo$1 extends Lambda implements Function1<IMMediaExtend, MediaInfo> {
    final /* synthetic */ Rect $clickBounds;
    final /* synthetic */ eab.f $media;
    final /* synthetic */ Drawable $thumbnail;

    public MessageFullScreenClickDelegate$onMediaClick$mediaInfo$1(Drawable r1, eab.f r2, Rect r3) {
        this.$thumbnail = r1;
        this.$media = r2;
        this.$clickBounds = r3;
        super(1);
    }

    public final MediaInfo invoke(IMMediaExtend r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$IMMediaExtend");
        MediaInfo r0 = new MediaInfo();
        r0.mediaThumbnail = this.$thumbnail;
        eab.f r1 = this.$media;
        r3.getClass();
        r0.key = IMMediaExtend.g(r1);
        r0.url = r3.j(this.$media);
        Rect r4 = this.$clickBounds;
        r0.left = r4.left;
        r0.top = r4.top;
        r0.height = r4.height();
        r0.width = this.$clickBounds.width();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((IMMediaExtend) r1);
    }
}
