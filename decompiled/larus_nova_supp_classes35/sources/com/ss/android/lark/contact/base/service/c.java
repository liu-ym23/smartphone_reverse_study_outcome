package com.ss.android.lark.contact.base.service;

import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.im.v1.GetChatApplicationsResponse;
import com.ss.android.lark.chat.api.IChatParser;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.contact.base.dependency.ContactBaseModuleDependency;
import com.ss.android.lark.contact.base.dto.ChatApplication;
import com.ss.android.lark.sdk.SdkSender;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c<T> implements SdkSender.IParser {
    public static final c<T> a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final Object parse(byte[] r4) {
        GetChatApplicationsResponse r5 = (GetChatApplicationsResponse) GetChatApplicationsResponse.ADAPTER.decode(r4);
        Entity r0 = r5.entity;
        IChatParser r1 = ContactBaseModuleDependency.b.getChatParser();
        if (r1 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        Map<String, Chat> r2 = r1.getChatMap(r0.chats);
    L6:
        List<ChatApplication> r3 = com.larksuite.framework.utils.y.a(r5.applications, new g9b.a());
        Boolean r6 = r5.has_more;
        e9b.a r7 = new e9b.a();
        r7.a = r2;
        r7.b = r3;
        Intrinsics.checkNotNull(r6);
        r7.c = r6.booleanValue();
        return r7;
    L5:
        r2 = null;
        goto L6
    }
}
