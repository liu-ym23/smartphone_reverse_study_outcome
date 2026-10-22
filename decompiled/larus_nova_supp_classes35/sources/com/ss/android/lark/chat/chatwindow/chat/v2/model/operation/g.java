package com.ss.android.lark.chat.chatwindow.chat.v2.model.operation;

import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.chat.utils.ThreadMergeForwardAuthorityUtil;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g implements Function1<f5b.b, f5b.b> {
    public final Map<String, ValidateIMFileResult> a;

    public static final class a implements Function1<f5b.b, Boolean> {
        public a() {
        }

        public final Object invoke(Object r3) {
            f5b.b r4 = (f5b.b) r3;
            if (r4 != null) goto L6;
            return Boolean.FALSE;
        L6:
            if (r4.getMessage().getMessageType() == MessageType.MERGE_FORWARD) goto L9;
            return Boolean.FALSE;
        L9:
            if (((MergeForwardContent) r4.getMessage().getMessageContent()).isFromPrivateTopic() == true) goto L12;
            return Boolean.FALSE;
        L12:
            return Boolean.TRUE;
        }
    }

    public g(Map<String, ValidateIMFileResult> r2) {
        Intrinsics.checkNotNullParameter(r2, "validateResult");
        this.a = r2;
    }

    public final Object invoke(Object r2) {
        f5b.b r3 = (f5b.b) r2;
        if (r3 != null) goto L5;
        return null;
    L5:
        ThreadMergeForwardAuthorityUtil.a(r3, this.a);
        return r3;
    }
}
