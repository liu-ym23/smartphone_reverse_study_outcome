package com.ss.android.lark.chat.chatwindow.chat.v2.model.operation;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Lcom/ss/android/lark/chat/entity/message/Message;", "invoke", "(Lcom/ss/android/lark/chat/entity/message/Message;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class PreviewUpdater$Companion$mergeMergeForwardPreview$1 extends Lambda implements Function1<Message, Boolean> {
    final /* synthetic */ Map<String, Map<String, UrlCardPreviewEntity>> $previews;

    /* JADX WARN: Multi-variable type inference failed */
    public PreviewUpdater$Companion$mergeMergeForwardPreview$1(Map<String, ? extends Map<String, UrlCardPreviewEntity>> r1) {
        this.$previews = r1;
        super(1);
    }

    public final Boolean invoke(Message r3) {
        if (r3 == null) goto L8;
        if (this.$previews.containsKey(r3.getId()) == false) goto L8;
        int r0 = l.c;
        l.a.a(r3, this.$previews.get(r3.getId()));
        return Boolean.TRUE;
    L8:
        return Boolean.FALSE;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Message) r1);
    }
}
