package com.ss.android.lark.keyboard.edittext2.mdeditor.biz;

import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkLinkExtend;
import com.ss.android.lark.coremdbiz.facade.link.LinkType;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import v7b.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/ss/android/lark/coremdbiz/facade/bizext/props/LarkLinkExtend;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class TaskLinkRegexResolver$parseUrlImpl$1 extends Lambda implements Function1<LarkLinkExtend, Unit> {
    final /* synthetic */ n $link;

    public TaskLinkRegexResolver$parseUrlImpl$1(n r1) {
        this.$link = r1;
        super(1);
    }

    public final void invoke(LarkLinkExtend r3) {
        Intrinsics.checkNotNullParameter(r3, "$this$LarkLinkExtend");
        r3.f(this.$link, LinkType.CustomLink);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((LarkLinkExtend) r1);
        return Unit.INSTANCE;
    }
}
