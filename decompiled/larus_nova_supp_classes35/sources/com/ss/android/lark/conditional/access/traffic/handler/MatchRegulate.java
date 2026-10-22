package com.ss.android.lark.conditional.access.traffic.handler;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/conditional/access/traffic/handler/MatchRegulate;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "ACCURATE", "ANY", "NONE", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MatchRegulate extends Enum<MatchRegulate> {
    public static final MatchRegulate ACCURATE = null;
    public static final MatchRegulate ANY = null;
    public static final MatchRegulate NONE = null;
    public static final /* synthetic */ MatchRegulate[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<MatchRegulate> getEntries() {
        return b;
    }

    static {
        MatchRegulate r0 = new MatchRegulate("ACCURATE", 0);
        ACCURATE = r0;
        MatchRegulate r1 = new MatchRegulate("ANY", 1);
        ANY = r1;
        MatchRegulate r3 = new MatchRegulate("NONE", 2);
        NONE = r3;
        MatchRegulate[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static MatchRegulate[] values() {
        return (MatchRegulate[]) a.clone();
    }

    public static MatchRegulate valueOf(String r1) {
        return (MatchRegulate) a.a(MatchRegulate.class, r1);
    }

    public MatchRegulate(String r1, int r2) {
        super(r1, r2);
    }
}
