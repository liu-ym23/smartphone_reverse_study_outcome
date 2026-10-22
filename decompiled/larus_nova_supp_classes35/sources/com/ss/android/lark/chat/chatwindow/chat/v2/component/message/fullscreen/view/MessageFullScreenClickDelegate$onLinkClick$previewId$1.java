package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkLinkExtend;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lcom/ss/android/lark/coremdbiz/facade/bizext/props/LarkLinkExtend;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class MessageFullScreenClickDelegate$onLinkClick$previewId$1 extends Lambda implements Function1<LarkLinkExtend, String> {
    final /* synthetic */ v7b.n $link;

    public MessageFullScreenClickDelegate$onLinkClick$previewId$1(v7b.n r1) {
        this.$link = r1;
        super(1);
    }

    public final String invoke(LarkLinkExtend r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$LarkLinkExtend");
        return r2.d(this.$link);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((LarkLinkExtend) r1);
    }
}
