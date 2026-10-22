package com.ss.android.lark.chat.utils;

import android.os.Bundle;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageLink;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i0 {
    static {
    }

    @JvmStatic
    public static final Bundle a(String r5, Message r6) {
        MessageLink r0 = null;
        if (r5 != null) goto L5;
        return null;
    L5:
        if (r6 == null) goto L9;
        LinkedHashMap<String, com.bytedance.lark.pb.basic.v1.MessageLink> r1 = r6.getMessageLinkMap();
        if (r1 == null) goto L9;
        com.bytedance.lark.pb.basic.v1.MessageLink r2 = r1.get(r5);
    L10:
        if (r2 == null) goto L12;
        r0 = com.ss.android.lark.parser.internal.t.a(r2);
    L12:
        Bundle r7 = b(r5, r0);
        if (r6 == null) goto L15;
        r7.putSerializable("lk_seclink_params", d(r6.getId(), r6.getChatId(), r6.getFromId(), r6.getCreateTime()));
    L15:
        return r7;
    L9:
        r2 = null;
        goto L10
    }

    @JvmStatic
    public static final Bundle b(String r5, MessageLink r6) {
        Intrinsics.checkNotNullParameter(r5, "previewId");
        ArrayList r1 = null;
        if (r6 == null) goto L5;
        MessageLink.ChatInfo r2 = r6.getChatInfo();
    L6:
        if (r6 == null) goto L13;
        ArrayList<Long> r7 = r6.getEntityIds();
        if (r7 == null) goto L13;
        r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
        Iterator<T> r8 = r7.iterator();
    L11:
        if (r8.hasNext() == false) goto L13;
        r1.add(String.valueOf(((Number) r8.next()).longValue()));
    L13:
        Bundle r9 = new Bundle();
        r9.putString("previewId", r5);
        if (r2 == null) goto L17;
        if (r1 == null) goto L17;
        r9.putSerializable("messageLinkChatInfo", r2);
        r9.putStringArrayList("messageLinkMsgIdList", new ArrayList(r1));
    L17:
        return r9;
    L5:
        r2 = null;
        goto L6
    }

    @JvmStatic
    public static final Bundle c(String r5, y6b.a<?> r6) {
        Intrinsics.checkNotNullParameter(r6, Keys.API_RETURN_KEY_DATA);
        MessageLink r0 = null;
        if (r5 != null) goto L5;
        return null;
    L5:
        Map<String, com.bytedance.lark.pb.basic.v1.MessageLink> r1 = r6.z();
        if (r1 == null) goto L8;
        com.bytedance.lark.pb.basic.v1.MessageLink r2 = r1.get(r5);
    L9:
        if (r2 == null) goto L11;
        r0 = com.ss.android.lark.parser.internal.t.a(r2);
    L11:
        Bundle r7 = b(r5, r0);
        r7.putSerializable("lk_seclink_params", d(r6.getId(), r6.getChatId(), r6.g(), r6.getCreateTime()));
        return r7;
    L8:
        r2 = null;
        goto L9
    }

    @JvmStatic
    public static final void e(String r1, y6b.a<?> r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r2 == null) goto L18;
        String r0 = r2.getChatId();
        if (r0 == null) goto L20;
        Map<String, com.bytedance.lark.pb.basic.v1.MessageLink> r3 = r2.z();
        if (r3 == null) goto L19;
        com.bytedance.lark.pb.basic.v1.MessageLink r4 = r3.get(r1);
        if (r4 == null) goto L21;
        MessageLink r5 = com.ss.android.lark.parser.internal.t.a(r4);
        if (r5 != null) goto L16;
        return;
    L16:
        com.ss.android.lark.chatwindow.view.preview.i.d(r0, r5);
        return;
    L21:
        return;
    L19:
        return;
    L20:
        return;
    }

    public static HashMap d(String r3, String r4, String r5, long r6) {
        HashMap r0 = new HashMap();
        r0.put("scene", "im");
        r0.put("location", "message");
        r0.put("object_id", r3);
        r0.put("object_type", "msg");
        r0.put("group_id", r4);
        r0.put("send_user_id", r5);
        r0.put("send_time", String.valueOf(r6));
        return r0;
    }
}
