package com.ss.android.lark.keyboard.plugin.tool.voice.advance;

import ccb.d;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/dto/chat/MentionChatChatterResponse;", "chatId", "", "searchKey", "requestId", "isFromServer", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class AdvanceVoiceInputComponent$startRecord$3 extends Lambda implements Function4<String, String, String, Boolean, d> {
    final /* synthetic */ b this$0;

    public AdvanceVoiceInputComponent$startRecord$3(b r1) {
        this.this$0 = r1;
        super(4);
    }

    public final d invoke(String r1, String r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "chatId");
        Intrinsics.checkNotNullParameter(r2, "searchKey");
        Intrinsics.checkNotNullParameter(r3, "requestId");
        this.this$0.getClass();
        throw null;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
        return invoke((String) r1, (String) r2, (String) r3, ((Boolean) r4).booleanValue());
    }
}
