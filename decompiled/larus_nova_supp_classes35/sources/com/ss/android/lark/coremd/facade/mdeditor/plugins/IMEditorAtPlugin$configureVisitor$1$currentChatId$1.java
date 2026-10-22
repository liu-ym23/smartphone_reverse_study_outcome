package com.ss.android.lark.coremd.facade.mdeditor.plugins;

import com.ss.android.lark.coremd.base.parse.r;
import com.ss.android.lark.coremd.facade.mdeditor.IMEditorContextExtend;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lcom/ss/android/lark/coremd/facade/mdeditor/IMEditorContextExtend;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class IMEditorAtPlugin$configureVisitor$1$currentChatId$1 extends Lambda implements Function1<IMEditorContextExtend, String> {
    final /* synthetic */ r<eab.a> $this_on;

    public IMEditorAtPlugin$configureVisitor$1$currentChatId$1(r<eab.a> r1) {
        this.$this_on = r1;
        super(1);
    }

    public final String invoke(IMEditorContextExtend r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$IMEditorContextExtend");
        r<eab.a> r0 = this.$this_on;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r0, "<this>");
        return (String) ((Function0) r4.u.getValue(r0, IMEditorContextExtend.v[0])).invoke();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((IMEditorContextExtend) r1);
    }
}
