package com.ss.android.lark.coremd.facade.mdeditor.at;

import com.ss.android.lark.coremd.facade.bizext.props.IMAtNodeExtend;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lcom/ss/android/lark/coremd/facade/bizext/props/IMAtNodeExtend;", "invoke", "(Lcom/ss/android/lark/coremd/facade/bizext/props/IMAtNodeExtend;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class IMEditorAtChatterLoader$fetchChattersImpl$fetchLocalChatters$1$1 extends Lambda implements Function1<IMAtNodeExtend, Boolean> {
    final /* synthetic */ String $chatId;
    final /* synthetic */ a.c $it;

    public IMEditorAtChatterLoader$fetchChattersImpl$fetchLocalChatters$1$1(a.c r1, String r2) {
        this.$it = r1;
        this.$chatId = r2;
        super(1);
    }

    public final Boolean invoke(IMAtNodeExtend r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$IMAtNodeExtend");
        this.$it.getClass();
        r4.getClass();
        Intrinsics.checkNotNullParameter(null, "<this>");
        boolean r2 = false;
        String r5 = (String) r4.c.getValue(null, IMAtNodeExtend.j[0]);
        this.$it.getClass();
        if (Intrinsics.areEqual(null, r5) == false) goto L11;
        if (this.$chatId.length() <= 0) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == false) goto L11;
        r2 = true;
        goto L11
    L7:
        r6 = false;
    L11:
        return Boolean.valueOf(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((IMAtNodeExtend) r1);
    }
}
