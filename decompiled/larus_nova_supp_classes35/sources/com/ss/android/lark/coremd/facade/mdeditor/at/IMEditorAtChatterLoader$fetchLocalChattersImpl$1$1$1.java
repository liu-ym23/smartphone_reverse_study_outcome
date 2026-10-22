package com.ss.android.lark.coremd.facade.mdeditor.at;

import com.ss.android.lark.coremd.facade.bizext.props.IMAtNodeExtend;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lcom/ss/android/lark/coremd/facade/bizext/props/IMAtNodeExtend;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
public final class IMEditorAtChatterLoader$fetchLocalChattersImpl$1$1$1 extends Lambda implements Function1<IMAtNodeExtend, Unit> {
    final /* synthetic */ eab.a $node;
    final /* synthetic */ String $originName;
    final /* synthetic */ a.c $request;

    public IMEditorAtChatterLoader$fetchLocalChattersImpl$1$1$1(eab.a r1, a.c r2, String r3) {
        this.$node = r1;
        this.$request = r2;
        this.$originName = r3;
        super(1);
    }

    public final void invoke(IMAtNodeExtend r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$IMAtNodeExtend");
        this.$request.getClass();
        r2.a(null);
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((IMAtNodeExtend) r1);
        return Unit.INSTANCE;
    }
}
