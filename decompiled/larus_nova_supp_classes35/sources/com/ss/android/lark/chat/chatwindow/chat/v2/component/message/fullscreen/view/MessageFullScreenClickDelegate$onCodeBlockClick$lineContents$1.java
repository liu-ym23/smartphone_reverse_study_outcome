package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkCodeBlockExtend;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lcom/ss/android/lark/widget/codeblock/entity/LineContent;", "Lcom/ss/android/lark/coremdbiz/facade/bizext/props/LarkCodeBlockExtend;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class MessageFullScreenClickDelegate$onCodeBlockClick$lineContents$1 extends Lambda implements Function1<LarkCodeBlockExtend, List<? extends LineContent>> {
    final /* synthetic */ v7b.g $code;

    public MessageFullScreenClickDelegate$onCodeBlockClick$lineContents$1(v7b.g r1) {
        this.$code = r1;
        super(1);
    }

    public final List<LineContent> invoke(LarkCodeBlockExtend r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$LarkCodeBlockExtend");
        return r2.a(this.$code);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((LarkCodeBlockExtend) r1);
    }
}
