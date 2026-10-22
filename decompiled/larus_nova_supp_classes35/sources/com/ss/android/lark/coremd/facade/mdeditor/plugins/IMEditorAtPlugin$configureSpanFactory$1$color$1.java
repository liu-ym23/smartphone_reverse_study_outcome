package com.ss.android.lark.coremd.facade.mdeditor.plugins;

import android.content.Context;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.coremd.facade.bizext.props.IMAtNodeExtend;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lcom/ss/android/lark/coremd/facade/bizext/props/IMAtNodeExtend;", "invoke", "(Lcom/ss/android/lark/coremd/facade/bizext/props/IMAtNodeExtend;)Ljava/lang/Integer;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class IMEditorAtPlugin$configureSpanFactory$1$color$1 extends Lambda implements Function1<IMAtNodeExtend, Integer> {
    final /* synthetic */ Context $context;
    final /* synthetic */ eab.a $node;

    public IMEditorAtPlugin$configureSpanFactory$1$color$1(eab.a r1, Context r2) {
        this.$node = r1;
        this.$context = r2;
        super(1);
    }

    public final Integer invoke(IMAtNodeExtend r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$IMAtNodeExtend");
        if (r2.a(this.$node) == false) goto L5;
    L8:
        int r3 = UDColorUtils.getColor(this.$context, 2131106607);
    L10:
        return Integer.valueOf(r3);
    L5:
        if (r2.b(this.$node) == true) goto L8;
        r3 = UDColorUtils.getColor(this.$context, 2131106616);
        goto L10
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((IMAtNodeExtend) r1);
    }
}
