package com.ss.android.lark.chat.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ThreadMergeForwardAuthorityUtil {
    public static final Lazy a = null;

    static {
        a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ThreadMergeForwardAuthorityUtil$passportDependency$2.INSTANCE);
    }

    @JvmStatic
    public static final boolean a(f5b.b r5, Map<String, ValidateIMFileResult> r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "resultMap");
        Message r0 = r5.getMessage();
        boolean r3 = false;
        if (r0.getMessageType() != MessageType.MERGE_FORWARD) goto L28;
        MergeForwardContent r1 = (MergeForwardContent) r0.getMessageContent();
        if (r1.isFromPrivateTopic() == false) goto L28;
        List<Message> r2 = r1.getMessages();
        List<Message> r4 = r2;
        if (r4 != null) goto L11;
    L14:
        boolean r7 = true;
    L15:
        if (r7 == true) goto L28;
        Message r8 = (Message) ListProtector.get(r2, 0);
        ValidateIMFileResult r9 = r6.get(r8.getId());
        if (r9 == null) goto L28;
        ValidateIMFileResult r10 = r8.getValidateIMFileResult();
        if (r10 == null) goto L25;
        IMFileResult r11 = r10.getResultType();
        if (r11 == null) goto L25;
        if (r11.getValue() != r9.getResultType().getValue()) goto L25;
        boolean r12 = true;
    L26:
        if (r12 == true) goto L28;
        r8.setValidateIMFileResult(r9);
        r3 = true;
    L25:
        r12 = false;
        goto L26
    L11:
        if (r4.isEmpty() == true) goto L14;
        r7 = false;
    L28:
        r5.setForceUpdate(r3);
        return r3;
    }
}
