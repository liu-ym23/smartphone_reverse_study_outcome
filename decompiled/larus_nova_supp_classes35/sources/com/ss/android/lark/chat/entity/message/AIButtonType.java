package com.ss.android.lark.chat.entity.message;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/AIButtonType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "LIKE", "DISLIKE", "REGENERATE", "SHARE", "COPY", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AIButtonType extends Enum<AIButtonType> {
    public static final AIButtonType COPY = null;
    public static final AIButtonType DISLIKE = null;
    public static final AIButtonType LIKE = null;
    public static final AIButtonType REGENERATE = null;
    public static final AIButtonType SHARE = null;
    public static final /* synthetic */ AIButtonType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AIButtonType> getEntries() {
        return b;
    }

    static {
        AIButtonType r0 = new AIButtonType("LIKE", 0);
        LIKE = r0;
        AIButtonType r1 = new AIButtonType("DISLIKE", 1);
        DISLIKE = r1;
        AIButtonType r3 = new AIButtonType("REGENERATE", 2);
        REGENERATE = r3;
        AIButtonType r5 = new AIButtonType("SHARE", 3);
        SHARE = r5;
        AIButtonType r7 = new AIButtonType("COPY", 4);
        COPY = r7;
        AIButtonType[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static AIButtonType[] values() {
        return (AIButtonType[]) a.clone();
    }

    public static AIButtonType valueOf(String r1) {
        return (AIButtonType) r27.a.a(AIButtonType.class, r1);
    }

    public AIButtonType(String r1, int r2) {
        super(r1, r2);
    }
}
