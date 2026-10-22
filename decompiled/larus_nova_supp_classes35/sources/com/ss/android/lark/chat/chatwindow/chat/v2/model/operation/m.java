package com.ss.android.lark.chat.chatwindow.chat.v2.model.operation;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m {
    public static final boolean a(f5b.b r8, Function1<? super Message, Boolean> r9) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, Keys.API_PARAM_KEY_ACTION);
        Message r10 = r8.getMessage();
        if (r10.getType() == Message.Type.MERGE_FORWARD) goto L5;
        return false;
    L5:
        List<Message> r0 = ((MergeForwardContent) r10.getContent()).getMessages();
        List<Message> r1 = r0;
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        return false;
    L14:
        int r3 = Math.min(r0.size(), 5);
        int r5 = 0;
        boolean r6 = false;
    L15:
        if (r5 >= r3) goto L20;
        if (((Boolean) r9.invoke((Message) ListProtector.get(r0, r5))).booleanValue() == false) goto L19;
        r6 = true;
    L19:
        r5 = r5 + 1;
        goto L15
    L20:
        Message r4 = (Message) ListProtector.get(r0, 0);
        int r7 = 0;
    L21:
        if (r7 >= 5) goto L40;
        if (r4 == null) goto L40;
        if (r4.getType() != Message.Type.MERGE_FORWARD) goto L40;
        MergeForwardContent r11 = (MergeForwardContent) r4.getContent();
        List<Message> r12 = r11.getMessages();
        if (r12 != null) goto L28;
    L31:
        boolean r13 = true;
    L32:
        if (r13 == false) goto L34;
        Log.w("[URLPreview]PreviewUpdater", "mergeForwardForEach failed, root=" + r10.getId() + ", id=" + r4.getId() + ": empty content");
    L37:
        r4 = null;
    L38:
        r7 = r7 + 1;
        goto L21
    L34:
        List<Message> r14 = r11.getMessages();
        if (r14 == null) goto L37;
        r4 = (Message) ListProtector.get(r14, 0);
        goto L38
    L28:
        if (r12.isEmpty() == true) goto L31;
        r13 = false;
    L40:
        if (((Boolean) r9.invoke(r4)).booleanValue() == false) goto L43;
        return true;
    L43:
        return r6;
    L8:
        if (r1.isEmpty() == true) goto L11;
        r2 = false;
        goto L12
    }
}
