package com.larus.business.debug.base.register;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001e"}, d2 = {"Lcom/larus/business/debug/base/register/EntranceGroup;", "", "des", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDes", "()Ljava/lang/String;", "PMO", "BASE", "LARK_SOCIAL", "OFFICE_SDK", "APPS_FRAMEWORK", "NETWORK", "AUDIO", "DORA", "IM", "ACCOUNT", "SECURITY", "HYBRID", "ONE_PARTY", "AI_CREATION", "MOA_OFFICE", "DOC", "COMMERCE", "ARCH", "ECOMMERCE", "LIVE", "COT", "OBRIC_COMMON", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EntranceGroup extends Enum<EntranceGroup> {
    public static final EntranceGroup ACCOUNT = null;
    public static final EntranceGroup AI_CREATION = null;
    public static final EntranceGroup APPS_FRAMEWORK = null;
    public static final EntranceGroup ARCH = null;
    public static final EntranceGroup AUDIO = null;
    public static final EntranceGroup BASE = null;
    public static final EntranceGroup COMMERCE = null;
    public static final EntranceGroup COT = null;
    public static final EntranceGroup DOC = null;
    public static final EntranceGroup DORA = null;
    public static final EntranceGroup ECOMMERCE = null;
    public static final EntranceGroup HYBRID = null;
    public static final EntranceGroup IM = null;
    public static final EntranceGroup LARK_SOCIAL = null;
    public static final EntranceGroup LIVE = null;
    public static final EntranceGroup MOA_OFFICE = null;
    public static final EntranceGroup NETWORK = null;
    public static final EntranceGroup OBRIC_COMMON = null;
    public static final EntranceGroup OFFICE_SDK = null;
    public static final EntranceGroup ONE_PARTY = null;
    public static final EntranceGroup PMO = null;
    public static final EntranceGroup SECURITY = null;
    public static final /* synthetic */ EntranceGroup[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String des;

    public static EnumEntries<EntranceGroup> getEntries() {
        return b;
    }

    static {
        EntranceGroup r0 = new EntranceGroup("PMO", 0, "验收反馈");
        PMO = r0;
        EntranceGroup r1 = new EntranceGroup("BASE", 1, "基础工具");
        BASE = r1;
        EntranceGroup r2 = new EntranceGroup("LARK_SOCIAL", 2, "真人聊天");
        LARK_SOCIAL = r2;
        EntranceGroup r4 = new EntranceGroup("OFFICE_SDK", 3, "OfficeSDK");
        OFFICE_SDK = r4;
        EntranceGroup r6 = new EntranceGroup("APPS_FRAMEWORK", 4, "小程序");
        APPS_FRAMEWORK = r6;
        EntranceGroup r8 = new EntranceGroup("NETWORK", 5, "网络");
        NETWORK = r8;
        EntranceGroup r10 = new EntranceGroup("AUDIO", 6, "Audio");
        AUDIO = r10;
        EntranceGroup r12 = new EntranceGroup("DORA", 7, "Dora");
        DORA = r12;
        EntranceGroup r14 = new EntranceGroup("IM", 8, "IM");
        IM = r14;
        EntranceGroup r15 = new EntranceGroup("ACCOUNT", 9, "登录与账号");
        ACCOUNT = r15;
        EntranceGroup r11 = new EntranceGroup("SECURITY", 10, "安全");
        SECURITY = r11;
        EntranceGroup r9 = new EntranceGroup("HYBRID", 11, "跨端");
        HYBRID = r9;
        EntranceGroup r7 = new EntranceGroup("ONE_PARTY", 12, "一方功能");
        ONE_PARTY = r7;
        EntranceGroup r5 = new EntranceGroup("AI_CREATION", 13, "AI创作");
        AI_CREATION = r5;
        EntranceGroup r3 = new EntranceGroup("MOA_OFFICE", 14, "moa办公模式");
        MOA_OFFICE = r3;
        EntranceGroup r13 = new EntranceGroup("DOC", 15, "豆包文档");
        DOC = r13;
        EntranceGroup r16 = new EntranceGroup("COMMERCE", 16, "商业化积分/会员");
        COMMERCE = r16;
        EntranceGroup r17 = new EntranceGroup("ARCH", 17, "架构调试");
        ARCH = r17;
        EntranceGroup r18 = new EntranceGroup("ECOMMERCE", 18, "电商功能");
        ECOMMERCE = r18;
        EntranceGroup r19 = new EntranceGroup("LIVE", 19, "直播功能");
        LIVE = r19;
        EntranceGroup r20 = new EntranceGroup("COT", 20, "Cot详情页");
        COT = r20;
        EntranceGroup r21 = new EntranceGroup("OBRIC_COMMON", 21, "O Common");
        OBRIC_COMMON = r21;
        EntranceGroup[] r22 = {r0, r1, r2, r4, r6, r8, r10, r12, r14, r15, r11, r9, r7, r5, r3, r13, r16, r17, r18, r19, r20, r21};
        a = r22;
        b = EnumEntriesKt.enumEntries(r22);
    }

    public static EntranceGroup[] values() {
        return (EntranceGroup[]) a.clone();
    }

    public final String getDes() {
        return this.des;
    }

    public static EntranceGroup valueOf(String r1) {
        return (EntranceGroup) a.a(EntranceGroup.class, r1);
    }

    public EntranceGroup(String r1, int r2, String r3) {
        super(r1, r2);
        this.des = r3;
    }

    public /* synthetic */ EntranceGroup(String r1, int r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L5;
        r3 = "";
    L5:
        this(r1, r2, r3);
    }
}
