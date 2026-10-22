package com.ss.android.lark.chameleon.pluginapi;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chameleon/pluginapi/RootBackPressResult;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "CONSUMED", "PROPAGATE", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RootBackPressResult extends Enum<RootBackPressResult> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ RootBackPressResult[] $VALUES = null;
    public static final RootBackPressResult CONSUMED = null;
    public static final RootBackPressResult DEFAULT = null;
    public static final RootBackPressResult PROPAGATE = null;

    private static final /* synthetic */ RootBackPressResult[] $values() {
        return new RootBackPressResult[]{DEFAULT, CONSUMED, PROPAGATE};
    }

    public static EnumEntries<RootBackPressResult> getEntries() {
        return $ENTRIES;
    }

    static {
        DEFAULT = new RootBackPressResult("DEFAULT", 0);
        CONSUMED = new RootBackPressResult("CONSUMED", 1);
        PROPAGATE = new RootBackPressResult("PROPAGATE", 2);
        RootBackPressResult[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static RootBackPressResult[] values() {
        return (RootBackPressResult[]) $VALUES.clone();
    }

    public static RootBackPressResult valueOf(String r1) {
        return (RootBackPressResult) a.a(RootBackPressResult.class, r1);
    }

    private RootBackPressResult(String r1, int r2) {
        super(r1, r2);
    }
}
