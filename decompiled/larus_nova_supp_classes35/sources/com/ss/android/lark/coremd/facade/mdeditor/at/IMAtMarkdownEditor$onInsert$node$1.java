package com.ss.android.lark.coremd.facade.mdeditor.at;

import com.ss.android.lark.coremd.facade.bizext.props.IMAtNodeExtend;
import hob.c;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/coremdbiz/facade/node/AtNode;", "Lcom/ss/android/lark/coremd/facade/bizext/props/IMAtNodeExtend;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class IMAtMarkdownEditor$onInsert$node$1 extends Lambda implements Function1<IMAtNodeExtend, eab.a> {
    final /* synthetic */ c $data;

    public IMAtMarkdownEditor$onInsert$node$1(c r1) {
        this.$data = r1;
        super(1);
    }

    public final eab.a invoke(IMAtNodeExtend r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$IMAtNodeExtend");
        c r1 = this.$data;
        eab.a r0 = new eab.a(r1.b, r1.a);
        r4.d(r0, this.$data.e);
        r4.f(r0, this.$data.d);
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((IMAtNodeExtend) r1);
    }
}
