package com.larus.business.debug.base.register;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/business/debug/base/register/EntrancePage;", "", "index", "", "des", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getIndex", "()I", "getDes", "()Ljava/lang/String;", "ALL", "RECENTLY", "FAVORITE", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EntrancePage extends Enum<EntrancePage> {
    public static final EntrancePage ALL = null;
    public static final EntrancePage FAVORITE = null;
    public static final EntrancePage RECENTLY = null;
    public static final /* synthetic */ EntrancePage[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String des;
    private final int index;

    public static EnumEntries<EntrancePage> getEntries() {
        return b;
    }

    static {
        EntrancePage r0 = new EntrancePage("ALL", 0, 0, "全部");
        ALL = r0;
        EntrancePage r1 = new EntrancePage("RECENTLY", 1, 1, "最近使用");
        RECENTLY = r1;
        EntrancePage r2 = new EntrancePage("FAVORITE", 2, 2, "收藏夹");
        FAVORITE = r2;
        EntrancePage[] r4 = {r0, r1, r2};
        a = r4;
        b = EnumEntriesKt.enumEntries(r4);
    }

    public static EntrancePage[] values() {
        return (EntrancePage[]) a.clone();
    }

    public final String getDes() {
        return this.des;
    }

    public final int getIndex() {
        return this.index;
    }

    public static EntrancePage valueOf(String r1) {
        return (EntrancePage) a.a(EntrancePage.class, r1);
    }

    public EntrancePage(String r1, int r2, int r3, String r4) {
        super(r1, r2);
        this.index = r3;
        this.des = r4;
    }

    public /* synthetic */ EntrancePage(String r1, int r2, int r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L5;
        r4 = "";
    L5:
        this(r1, r2, r3, r4);
    }
}
