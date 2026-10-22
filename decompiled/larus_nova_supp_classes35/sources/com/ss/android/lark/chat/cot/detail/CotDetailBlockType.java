package com.ss.android.lark.chat.cot.detail;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/chat/cot/detail/CotDetailBlockType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "THINKING", "GROUP", "TOOLCALL", "ACTION", "STATUS", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CotDetailBlockType extends Enum<CotDetailBlockType> {
    public static final CotDetailBlockType ACTION = null;
    public static final CotDetailBlockType GROUP = null;
    public static final CotDetailBlockType STATUS = null;
    public static final CotDetailBlockType THINKING = null;
    public static final CotDetailBlockType TOOLCALL = null;
    public static final /* synthetic */ CotDetailBlockType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CotDetailBlockType> getEntries() {
        return b;
    }

    static {
        CotDetailBlockType r0 = new CotDetailBlockType("THINKING", 0);
        THINKING = r0;
        CotDetailBlockType r1 = new CotDetailBlockType("GROUP", 1);
        GROUP = r1;
        CotDetailBlockType r3 = new CotDetailBlockType("TOOLCALL", 2);
        TOOLCALL = r3;
        CotDetailBlockType r5 = new CotDetailBlockType("ACTION", 3);
        ACTION = r5;
        CotDetailBlockType r7 = new CotDetailBlockType("STATUS", 4);
        STATUS = r7;
        CotDetailBlockType[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static CotDetailBlockType[] values() {
        return (CotDetailBlockType[]) a.clone();
    }

    public static CotDetailBlockType valueOf(String r1) {
        return (CotDetailBlockType) r27.a.a(CotDetailBlockType.class, r1);
    }

    public CotDetailBlockType(String r1, int r2) {
        super(r1, r2);
    }
}
