package com.larus.bot.impl.common.propertyconfig;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bot/impl/common/propertyconfig/Visibility;", "", "<init>", "(Ljava/lang/String;I)V", "VISIBLE", "DISABLE", "HIDDEN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Visibility extends Enum<Visibility> {
    public static final Visibility DISABLE = null;
    public static final Visibility HIDDEN = null;
    public static final Visibility VISIBLE = null;
    public static final /* synthetic */ Visibility[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<Visibility> getEntries() {
        return b;
    }

    static {
        Visibility r0 = new Visibility("VISIBLE", 0);
        VISIBLE = r0;
        Visibility r1 = new Visibility("DISABLE", 1);
        DISABLE = r1;
        Visibility r3 = new Visibility("HIDDEN", 2);
        HIDDEN = r3;
        Visibility[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static Visibility[] values() {
        return (Visibility[]) a.clone();
    }

    public static Visibility valueOf(String r1) {
        return (Visibility) a.a(Visibility.class, r1);
    }

    public Visibility(String r1, int r2) {
        super(r1, r2);
    }
}
