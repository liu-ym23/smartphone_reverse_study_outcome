package com.ss.android.lark.parser.internal;

import com.ss.android.lark.chat.entity.chat.ChatTeamInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ModelParserChatTeamInfo {
    public static final ModelParserChatTeamInfo a = null;

    static {
        a = new ModelParserChatTeamInfo();
    }

    public ModelParserChatTeamInfo() {
    }

    @JvmStatic
    public static final List<ChatTeamInfo> a(List<com.bytedance.lark.pb.basic.v1.ChatTeamInfo> r3) {
        if (r3 == null) goto L9;
        ModelParserChatTeamInfo$parseChatTeamInfoList$1 r0 = new ModelParserChatTeamInfo$parseChatTeamInfoList$1(a);
        ArrayList r1 = new ArrayList();
        Iterator<T> r4 = r3.iterator();
    L5:
        if (r4.hasNext() == false) goto L16;
        Object r2 = r0.invoke(r4.next());
        if (r2 == null) goto L5;
        r1.add(r2);
        goto L5
    L16:
        return r1;
    L9:
        return null;
    }
}
