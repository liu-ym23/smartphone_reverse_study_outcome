package com.ss.android.lark.chameleon.pluginapi;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/chameleon/pluginapi/RootBackPressSource;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "SYSTEM_BACK", "TITLE_BACK", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RootBackPressSource extends Enum<RootBackPressSource> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ RootBackPressSource[] $VALUES = null;
    public static final RootBackPressSource SYSTEM_BACK = null;
    public static final RootBackPressSource TITLE_BACK = null;

    private static final /* synthetic */ RootBackPressSource[] $values() {
        return new RootBackPressSource[]{SYSTEM_BACK, TITLE_BACK};
    }

    public static EnumEntries<RootBackPressSource> getEntries() {
        return $ENTRIES;
    }

    static {
        SYSTEM_BACK = new RootBackPressSource("SYSTEM_BACK", 0);
        TITLE_BACK = new RootBackPressSource("TITLE_BACK", 1);
        RootBackPressSource[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static RootBackPressSource[] values() {
        return (RootBackPressSource[]) $VALUES.clone();
    }

    public static RootBackPressSource valueOf(String r1) {
        return (RootBackPressSource) a.a(RootBackPressSource.class, r1);
    }

    private RootBackPressSource(String r1, int r2) {
        super(r1, r2);
    }
}
