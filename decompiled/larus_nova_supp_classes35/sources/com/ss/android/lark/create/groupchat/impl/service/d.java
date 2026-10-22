package com.ss.android.lark.create.groupchat.impl.service;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.PickChatEntity;
import com.ss.android.lark.create.groupchat.dto.CreateGroupMode;
import com.ss.android.lark.doc.entity.DocPermPair;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d {
    public final List<String> a;
    public final Set<PickChatEntity> b;
    public final List<String> c;
    public final Map<String, Map<String, DocPermPair.PermType>> d;
    public String e;
    public String f;
    public String g;
    public boolean h;
    public boolean i;
    public boolean j;
    public String k;
    public Chat.ChatMode l;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CreateGroupMode.values().length];
            r0[CreateGroupMode.CONVERSATION_MODE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[CreateGroupMode.TOPIC_MODE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[CreateGroupMode.SECRET_MODE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public d() {
        this.a = new ArrayList();
        this.b = new LinkedHashSet();
        this.c = new ArrayList();
        this.d = new LinkedHashMap();
        this.e = BuildConfig.FLAVOR;
        this.f = BuildConfig.FLAVOR;
        this.g = BuildConfig.FLAVOR;
        this.l = Chat.ChatMode.DEFAULT;
    }
}
