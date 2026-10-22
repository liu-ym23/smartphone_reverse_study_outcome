package com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v2.view;

import com.ss.android.lark.chat.entity.chat.ChatTab;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "chatTab", "Lcom/ss/android/lark/chat/entity/chat/ChatTab;", "invoke", "(Lcom/ss/android/lark/chat/entity/chat/ChatTab;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class TabTitleView$showGuideIfNeed$1$1$2 extends Lambda implements Function1<ChatTab, Boolean> {
    public static final TabTitleView$showGuideIfNeed$1$1$2 INSTANCE = null;

    static {
        INSTANCE = new TabTitleView$showGuideIfNeed$1$1$2();
    }

    public TabTitleView$showGuideIfNeed$1$1$2() {
        super(1);
    }

    public final Boolean invoke(ChatTab r2) {
        Intrinsics.checkNotNullParameter(r2, "chatTab");
        ChatTab.Companion.getClass();
        return Boolean.valueOf(ChatTab.a.a(r2));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((ChatTab) r1);
    }
}
