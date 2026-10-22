package com.ss.android.lark.chat.entity.message;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/AIButtonStrategy;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "CUSTOMIZE", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AIButtonStrategy extends Enum<AIButtonStrategy> {
    public static final AIButtonStrategy CUSTOMIZE = null;
    public static final AIButtonStrategy DEFAULT = null;
    public static final /* synthetic */ AIButtonStrategy[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<AIButtonStrategy> getEntries() {
        return b;
    }

    static {
        AIButtonStrategy r0 = new AIButtonStrategy("DEFAULT", 0);
        DEFAULT = r0;
        AIButtonStrategy r1 = new AIButtonStrategy("CUSTOMIZE", 1);
        CUSTOMIZE = r1;
        AIButtonStrategy[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static AIButtonStrategy[] values() {
        return (AIButtonStrategy[]) a.clone();
    }

    public static AIButtonStrategy valueOf(String r1) {
        return (AIButtonStrategy) r27.a.a(AIButtonStrategy.class, r1);
    }

    public AIButtonStrategy(String r1, int r2) {
        super(r1, r2);
    }
}
