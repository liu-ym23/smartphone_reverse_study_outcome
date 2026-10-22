package com.ss.android.lark.floating.enums;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/floating/enums/ShowPattern;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "CURRENT_ACTIVITY", "FOREGROUND", "BACKGROUND", "ALL_TIME", "float_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ShowPattern extends Enum<ShowPattern> {
    public static final ShowPattern ALL_TIME = null;
    public static final ShowPattern BACKGROUND = null;
    public static final ShowPattern CURRENT_ACTIVITY = null;
    public static final ShowPattern FOREGROUND = null;
    public static final /* synthetic */ ShowPattern[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ShowPattern> getEntries() {
        return b;
    }

    static {
        ShowPattern r0 = new ShowPattern("CURRENT_ACTIVITY", 0);
        CURRENT_ACTIVITY = r0;
        ShowPattern r1 = new ShowPattern("FOREGROUND", 1);
        FOREGROUND = r1;
        ShowPattern r3 = new ShowPattern("BACKGROUND", 2);
        BACKGROUND = r3;
        ShowPattern r5 = new ShowPattern("ALL_TIME", 3);
        ALL_TIME = r5;
        ShowPattern[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static ShowPattern[] values() {
        return (ShowPattern[]) a.clone();
    }

    public static ShowPattern valueOf(String r1) {
        return (ShowPattern) a.a(ShowPattern.class, r1);
    }

    public ShowPattern(String r1, int r2) {
        super(r1, r2);
    }
}
