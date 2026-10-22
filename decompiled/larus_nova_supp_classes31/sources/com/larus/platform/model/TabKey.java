package com.larus.platform.model;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/larus/platform/model/TabKey;", "", "tabKey", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTabKey", "()Ljava/lang/String;", "MY", "RECOMMEND", "FEMALE", "MALE", "CHARACTERS", "ACCENT", "ENGLISH", "MULTILANGUAGE", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum TabKey extends Enum<TabKey> {
    public static final TabKey ACCENT = null;
    public static final TabKey CHARACTERS = null;
    public static final a Companion = null;
    public static final TabKey ENGLISH = null;
    public static final TabKey FEMALE = null;
    public static final TabKey MALE = null;
    public static final TabKey MULTILANGUAGE = null;
    public static final TabKey MY = null;
    public static final TabKey RECOMMEND = null;
    public static final /* synthetic */ TabKey[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String tabKey;

    public static EnumEntries<TabKey> getEntries() {
        return b;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.larus.platform.model.TabKey$a] */
    static {
        TabKey r0 = new TabKey("MY", 0, "my");
        MY = r0;
        TabKey r1 = new TabKey("RECOMMEND", 1, "recommend");
        RECOMMEND = r1;
        TabKey r3 = new TabKey("FEMALE", 2, "female");
        FEMALE = r3;
        TabKey r5 = new TabKey("MALE", 3, "male");
        MALE = r5;
        TabKey r7 = new TabKey("CHARACTERS", 4, "characters");
        CHARACTERS = r7;
        TabKey r9 = new TabKey("ACCENT", 5, "accent");
        ACCENT = r9;
        TabKey r11 = new TabKey("ENGLISH", 6, "english");
        ENGLISH = r11;
        TabKey r13 = new TabKey("MULTILANGUAGE", 7, "multilanguage");
        MULTILANGUAGE = r13;
        TabKey[] r12 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
        Companion = new a();
    }

    public static TabKey[] values() {
        return (TabKey[]) a.clone();
    }

    public final String getTabKey() {
        return this.tabKey;
    }

    public static TabKey valueOf(String r1) {
        return (TabKey) r27.a.a(TabKey.class, r1);
    }

    public TabKey(String r1, int r2, String r3) {
        super(r1, r2);
        this.tabKey = r3;
    }
}
