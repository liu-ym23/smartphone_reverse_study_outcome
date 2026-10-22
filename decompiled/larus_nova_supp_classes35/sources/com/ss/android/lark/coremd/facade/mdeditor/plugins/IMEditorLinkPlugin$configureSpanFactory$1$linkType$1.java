package com.ss.android.lark.coremd.facade.mdeditor.plugins;

import com.ss.android.lark.coremd.base.parse.o;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkLinkExtend;
import com.ss.android.lark.coremdbiz.facade.link.LinkType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import v7b.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/coremdbiz/facade/link/LinkType;", "Lcom/ss/android/lark/coremdbiz/facade/bizext/props/LarkLinkExtend;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class IMEditorLinkPlugin$configureSpanFactory$1$linkType$1 extends Lambda implements Function1<LarkLinkExtend, LinkType> {
    final /* synthetic */ o<n> $this_on;

    public IMEditorLinkPlugin$configureSpanFactory$1$linkType$1(o<n> r1) {
        this.$this_on = r1;
        super(1);
    }

    public final LinkType invoke(LarkLinkExtend r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$LarkLinkExtend");
        return r2.b((n) this.$this_on.getNode());
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((LarkLinkExtend) r1);
    }
}
