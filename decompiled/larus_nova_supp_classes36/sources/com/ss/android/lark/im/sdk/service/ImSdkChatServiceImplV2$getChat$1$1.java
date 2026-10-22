package com.ss.android.lark.im.sdk.service;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "it", "", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class ImSdkChatServiceImplV2$getChat$1$1 extends Lambda implements Function1<Map<String, ? extends Chat>, Chat> {
    final /* synthetic */ String $chatId;

    public ImSdkChatServiceImplV2$getChat$1$1(String r1) {
        this.$chatId = r1;
        super(1);
    }

    public final Chat invoke(Map<String, ? extends Chat> r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return r2.get(this.$chatId);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Map) r1);
    }
}
