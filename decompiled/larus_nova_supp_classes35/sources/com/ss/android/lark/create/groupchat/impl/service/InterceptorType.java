package com.ss.android.lark.create.groupchat.impl.service;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/create/groupchat/impl/service/InterceptorType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "HIT_POINT", "GROUP_MEMBER_LIMIT", "EXCEED_GROUP_LIMIT", "EXCEED_GROUP_LIMIT_NEED_APPLY", "BILLING", "DLP", "DEFAULT", "SECRET_CHAT_BANNED", "STRANGER", "create-group-chat-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InterceptorType extends Enum<InterceptorType> {
    public static final InterceptorType BILLING = null;
    public static final InterceptorType DEFAULT = null;
    public static final InterceptorType DLP = null;
    public static final InterceptorType EXCEED_GROUP_LIMIT = null;
    public static final InterceptorType EXCEED_GROUP_LIMIT_NEED_APPLY = null;
    public static final InterceptorType GROUP_MEMBER_LIMIT = null;
    public static final InterceptorType HIT_POINT = null;
    public static final InterceptorType SECRET_CHAT_BANNED = null;
    public static final InterceptorType STRANGER = null;
    public static final /* synthetic */ InterceptorType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<InterceptorType> getEntries() {
        return b;
    }

    static {
        InterceptorType r0 = new InterceptorType("HIT_POINT", 0);
        HIT_POINT = r0;
        InterceptorType r1 = new InterceptorType("GROUP_MEMBER_LIMIT", 1);
        GROUP_MEMBER_LIMIT = r1;
        InterceptorType r3 = new InterceptorType("EXCEED_GROUP_LIMIT", 2);
        EXCEED_GROUP_LIMIT = r3;
        InterceptorType r5 = new InterceptorType("EXCEED_GROUP_LIMIT_NEED_APPLY", 3);
        EXCEED_GROUP_LIMIT_NEED_APPLY = r5;
        InterceptorType r7 = new InterceptorType("BILLING", 4);
        BILLING = r7;
        InterceptorType r9 = new InterceptorType("DLP", 5);
        DLP = r9;
        InterceptorType r11 = new InterceptorType("DEFAULT", 6);
        DEFAULT = r11;
        InterceptorType r13 = new InterceptorType("SECRET_CHAT_BANNED", 7);
        SECRET_CHAT_BANNED = r13;
        InterceptorType r15 = new InterceptorType("STRANGER", 8);
        STRANGER = r15;
        InterceptorType[] r14 = {r0, r1, r3, r5, r7, r9, r11, r13, r15};
        a = r14;
        b = EnumEntriesKt.enumEntries(r14);
    }

    public static InterceptorType[] values() {
        return (InterceptorType[]) a.clone();
    }

    public static InterceptorType valueOf(String r1) {
        return (InterceptorType) r27.a.a(InterceptorType.class, r1);
    }

    public InterceptorType(String r1, int r2) {
        super(r1, r2);
    }
}
