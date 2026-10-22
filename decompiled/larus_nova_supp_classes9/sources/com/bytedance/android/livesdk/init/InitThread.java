package com.bytedance.android.livesdk.init;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/init/InitThread;", BuildConfig.FLAVOR, "MAIN", "BACK_GROUND", "WITH_CALLER", "live-spi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum InitThread extends Enum<InitThread> {
    public static final InitThread BACK_GROUND = null;
    public static final InitThread MAIN = null;
    public static final InitThread WITH_CALLER = null;
    public static final /* synthetic */ InitThread[] a = null;

    static {
        InitThread r1 = new InitThread("MAIN", 0);
        MAIN = r1;
        InitThread r2 = new InitThread("BACK_GROUND", 1);
        BACK_GROUND = r2;
        InitThread r3 = new InitThread("WITH_CALLER", 2);
        WITH_CALLER = r3;
        a = new InitThread[]{r1, r2, r3};
    }

    public static InitThread valueOf(String r1) {
        return (InitThread) r27.a.a(InitThread.class, r1);
    }

    public static InitThread[] values() {
        return (InitThread[]) a.clone();
    }

    public InitThread(String r1, int r2) {
        super(r1, r2);
    }
}
