package com.bytedance.android.livesdk.ktvapi.model;

import com.bytedance.bdlocation.BuildConfig;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/ktvapi/model/KtvCommand;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "value", "I", "getValue", "()I", "NOTHING", "START_KTV", "EXIT_KTV", "SONG_START", "SONG_PAUSE", "SONG_RESTART", "SONG_FINISH", "livektv-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum KtvCommand extends Enum<KtvCommand> {
    public static final KtvCommand EXIT_KTV = null;
    public static final KtvCommand NOTHING = null;
    public static final KtvCommand SONG_FINISH = null;
    public static final KtvCommand SONG_PAUSE = null;
    public static final KtvCommand SONG_RESTART = null;
    public static final KtvCommand SONG_START = null;
    public static final KtvCommand START_KTV = null;
    public static final /* synthetic */ KtvCommand[] a = null;
    private final int value;

    static {
        KtvCommand r1 = new KtvCommand("NOTHING", 0, 0);
        NOTHING = r1;
        KtvCommand r2 = new KtvCommand("START_KTV", 1, 1);
        START_KTV = r2;
        KtvCommand r3 = new KtvCommand("EXIT_KTV", 2, 2);
        EXIT_KTV = r3;
        KtvCommand r4 = new KtvCommand("SONG_START", 3, 3);
        SONG_START = r4;
        KtvCommand r5 = new KtvCommand("SONG_PAUSE", 4, 4);
        SONG_PAUSE = r5;
        KtvCommand r6 = new KtvCommand("SONG_RESTART", 5, 5);
        SONG_RESTART = r6;
        KtvCommand r7 = new KtvCommand("SONG_FINISH", 6, 6);
        SONG_FINISH = r7;
        a = new KtvCommand[]{r1, r2, r3, r4, r5, r6, r7};
    }

    public static KtvCommand valueOf(String r1) {
        return (KtvCommand) a.a(KtvCommand.class, r1);
    }

    public static KtvCommand[] values() {
        return (KtvCommand[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public KtvCommand(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
