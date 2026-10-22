package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.utils.Contexts;
import com.ss.android.lark.widget.span.AbbreviationInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements mcc.a {
    public final c a;

    public final c getContext() {
        return this.a;
    }

    public a(c r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }

    public final void s(View r1, AbbreviationInfo r2, float r3, float r4) {
        Intrinsics.checkNotNullParameter(r1, "view");
        Intrinsics.checkNotNullParameter(r2, "abbrInfo");
        if (r2.bizType != AbbreviationInfo.AbbreviationType.CALENDAR) goto L12;
        FragmentActivity r5 = Contexts.findActivity(this.a.getContext());
        if ((r5 instanceof FragmentActivity) == false) goto L7;
        FragmentActivity r6 = r5;
    L8:
        if (r6 != null) goto L10;
        return;
    L10:
        ChatCoreModule.a().getIRecommendEventAiDependency();
        throw null;
    L7:
        r6 = null;
        goto L8
    L12:
        ChatCoreModule.a().getEnterpriseTopicDependency();
        this.a.c.getId();
        this.a.d.isFromMe();
        throw null;
    }
}
