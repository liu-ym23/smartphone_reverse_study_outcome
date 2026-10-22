package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.view.View;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.widget.span.AbbreviationInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m0 implements mcc.a {
    public final /* synthetic */ TextContentBlock a;
    public final /* synthetic */ y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> b;

    public m0(TextContentBlock r1, y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void s(View r1, AbbreviationInfo r2, float r3, float r4) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r2, "abbreviationInfo");
        if (r2.bizType != AbbreviationInfo.AbbreviationType.CALENDAR) goto L6;
        ChatCoreModule.a().getIRecommendEventAiDependency();
        this.a.g().getContext();
        throw null;
    L6:
        ChatCoreModule.a().getEnterpriseTopicDependency();
        this.a.g().getChatId();
        this.b.h();
        throw null;
    }
}
