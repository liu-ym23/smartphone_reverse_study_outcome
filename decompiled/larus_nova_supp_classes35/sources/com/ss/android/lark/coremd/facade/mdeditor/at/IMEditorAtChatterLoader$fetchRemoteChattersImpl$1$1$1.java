package com.ss.android.lark.coremd.facade.mdeditor.at;

import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.coremd.facade.bizext.props.IMAtNodeExtend;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lcom/ss/android/lark/coremd/facade/bizext/props/IMAtNodeExtend;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
public final class IMEditorAtChatterLoader$fetchRemoteChattersImpl$1$1$1 extends Lambda implements Function1<IMAtNodeExtend, Unit> {
    final /* synthetic */ ChatChatter $chatter;
    final /* synthetic */ Map<String, Boolean> $inChatMap;
    final /* synthetic */ String $it;
    final /* synthetic */ eab.a $node;
    final /* synthetic */ String $originName;

    public IMEditorAtChatterLoader$fetchRemoteChattersImpl$1$1$1(eab.a r1, ChatChatter r2, String r3, Map<String, Boolean> r4, String r5) {
        this.$node = r1;
        this.$chatter = r2;
        this.$originName = r3;
        this.$inChatMap = r4;
        this.$it = r5;
        super(1);
    }

    public final void invoke(IMAtNodeExtend r6) {
        Intrinsics.checkNotNullParameter(r6, "$this$IMAtNodeExtend");
        r6.d(this.$node, this.$chatter.isAnonymous());
        eab.a r0 = this.$node;
        String r1 = this.$originName;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r6.h.setValue(r0, IMAtNodeExtend.j[5], r1);
        r6.f(this.$node, !Intrinsics.areEqual(this.$inChatMap.get(this.$it), Boolean.TRUE));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((IMAtNodeExtend) r1);
        return Unit.INSTANCE;
    }
}
