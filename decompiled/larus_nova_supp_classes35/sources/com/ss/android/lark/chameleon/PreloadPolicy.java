package com.ss.android.lark.chameleon;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chameleon/PreloadPolicy;", com.tencent.qqmusic.third.api.contract.BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "NO_PRELOAD", "PRELOAD_EMPTY_WEBVIEW", "PRELOAD_BIZ_HTML", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PreloadPolicy extends Enum<PreloadPolicy> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ PreloadPolicy[] $VALUES = null;
    public static final PreloadPolicy NO_PRELOAD = null;
    public static final PreloadPolicy PRELOAD_BIZ_HTML = null;
    public static final PreloadPolicy PRELOAD_EMPTY_WEBVIEW = null;

    private static final /* synthetic */ PreloadPolicy[] $values() {
        return new PreloadPolicy[]{NO_PRELOAD, PRELOAD_EMPTY_WEBVIEW, PRELOAD_BIZ_HTML};
    }

    public static EnumEntries<PreloadPolicy> getEntries() {
        return $ENTRIES;
    }

    static {
        NO_PRELOAD = new PreloadPolicy("NO_PRELOAD", 0);
        PRELOAD_EMPTY_WEBVIEW = new PreloadPolicy("PRELOAD_EMPTY_WEBVIEW", 1);
        PRELOAD_BIZ_HTML = new PreloadPolicy("PRELOAD_BIZ_HTML", 2);
        PreloadPolicy[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static PreloadPolicy[] values() {
        return (PreloadPolicy[]) $VALUES.clone();
    }

    public static PreloadPolicy valueOf(String r1) {
        return (PreloadPolicy) a.a(PreloadPolicy.class, r1);
    }

    private PreloadPolicy(String r1, int r2) {
        super(r1, r2);
    }
}
