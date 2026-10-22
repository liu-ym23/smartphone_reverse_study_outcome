package com.ss.android.lark.chameleonv2.container.webcontainer.preload;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/chameleonv2/container/webcontainer/preload/PreloadStatus;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "INIT", "PRELOADING", "PRELOAD_SUCCESS", "PRELOAD_FAILED", "NOT_PRELOAD", "chameleon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PreloadStatus extends Enum<PreloadStatus> {
    public static final PreloadStatus INIT = null;
    public static final PreloadStatus NOT_PRELOAD = null;
    public static final PreloadStatus PRELOADING = null;
    public static final PreloadStatus PRELOAD_FAILED = null;
    public static final PreloadStatus PRELOAD_SUCCESS = null;
    public static final /* synthetic */ PreloadStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<PreloadStatus> getEntries() {
        return b;
    }

    static {
        PreloadStatus r0 = new PreloadStatus("INIT", 0);
        INIT = r0;
        PreloadStatus r1 = new PreloadStatus("PRELOADING", 1);
        PRELOADING = r1;
        PreloadStatus r3 = new PreloadStatus("PRELOAD_SUCCESS", 2);
        PRELOAD_SUCCESS = r3;
        PreloadStatus r5 = new PreloadStatus("PRELOAD_FAILED", 3);
        PRELOAD_FAILED = r5;
        PreloadStatus r7 = new PreloadStatus("NOT_PRELOAD", 4);
        NOT_PRELOAD = r7;
        PreloadStatus[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static PreloadStatus[] values() {
        return (PreloadStatus[]) a.clone();
    }

    public static PreloadStatus valueOf(String r1) {
        return (PreloadStatus) r27.a.a(PreloadStatus.class, r1);
    }

    public PreloadStatus(String r1, int r2) {
        super(r1, r2);
    }
}
