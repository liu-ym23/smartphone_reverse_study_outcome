package com.ss.android.lark.coremd.facade.mdeditor.plugins;

import com.ss.android.lark.coremd.base.parse.o;
import com.ss.android.lark.coremd.facade.mdeditor.IMEditorContextExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkContextExtend;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import eab.f;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lcom/ss/android/lark/coremd/facade/mdeditor/IMEditorContextExtend;", "invoke", "(Lcom/ss/android/lark/coremd/facade/mdeditor/IMEditorContextExtend;)Ljava/lang/Integer;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class IMEditorMediaPlugin$configureSpanFactory$1$draftResourceSource$1 extends Lambda implements Function1<IMEditorContextExtend, Integer> {
    final /* synthetic */ o<f> $this_on;

    public IMEditorMediaPlugin$configureSpanFactory$1$draftResourceSource$1(o<f> r1) {
        this.$this_on = r1;
        super(1);
    }

    public final Integer invoke(IMEditorContextExtend r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$IMEditorContextExtend");
        o<f> r0 = this.$this_on;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r0, "<this>");
        return (Integer) ((Function0) r4.r.getValue(r0, LarkContextExtend.t[15])).invoke();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((IMEditorContextExtend) r1);
    }
}
