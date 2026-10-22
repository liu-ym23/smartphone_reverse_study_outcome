package com.ss.android.lark.message.card.view;

import com.ss.android.lark.chat.entity.message.content.CardContent;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/chat/entity/message/content/CardContent$CardHeader;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class CardContentVO$cardHeader$2 extends Lambda implements Function0<CardContent.CardHeader> {
    final /* synthetic */ CardContent $content;

    public CardContentVO$cardHeader$2(CardContent r1) {
        this.$content = r1;
        super(0);
    }

    public final CardContent.CardHeader invoke() {
        return this.$content.getCardHeader();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1433invoke() {
        return invoke();
    }
}
