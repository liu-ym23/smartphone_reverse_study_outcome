package com.bytedance.android.live.room.api.experience.perf;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/room/api/experience/perf/LivePerfBizLevel;", "", "", "level", "I", "getLevel", "()I", "Companion", "a", "Unknown", "Default", "P0", "P1", "P2", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LivePerfBizLevel extends Enum<LivePerfBizLevel> {
    public static final a Companion = null;
    public static final LivePerfBizLevel Default = null;
    public static final LivePerfBizLevel P0 = null;
    public static final LivePerfBizLevel P1 = null;
    public static final LivePerfBizLevel P2 = null;
    public static final LivePerfBizLevel Unknown = null;
    public static final /* synthetic */ LivePerfBizLevel[] a = null;
    private final int level;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static LivePerfBizLevel a(int r6) {
            LivePerfBizLevel[] r0 = LivePerfBizLevel.values();
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L11;
            LivePerfBizLevel r4 = r0[r3];
            if (r4.getLevel() != r6) goto L7;
            boolean r5 = true;
        L8:
            if (r5 == true) goto L12;
            r3 = r3 + 1;
        L12:
            if (r4 == null) goto L14;
            return r4;
        L14:
            return LivePerfBizLevel.Unknown;
        L7:
            r5 = false;
            goto L8
        L11:
            r4 = null;
            goto L12
        }
    }

    static {
        LivePerfBizLevel r1 = new LivePerfBizLevel("Unknown", 0, -1996);
        Unknown = r1;
        LivePerfBizLevel r2 = new LivePerfBizLevel("Default", 1, -1);
        Default = r2;
        LivePerfBizLevel r3 = new LivePerfBizLevel("P0", 2, 0);
        P0 = r3;
        LivePerfBizLevel r4 = new LivePerfBizLevel("P1", 3, 1);
        P1 = r4;
        LivePerfBizLevel r5 = new LivePerfBizLevel("P2", 4, 2);
        P2 = r5;
        a = new LivePerfBizLevel[]{r1, r2, r3, r4, r5};
        Companion = new a();
    }

    @JvmStatic
    public static final LivePerfBizLevel mapPerfBizLevel(int r1) {
        Companion.getClass();
        return a.a(r1);
    }

    public static LivePerfBizLevel valueOf(String r1) {
        return (LivePerfBizLevel) r27.a.a(LivePerfBizLevel.class, r1);
    }

    public static LivePerfBizLevel[] values() {
        return (LivePerfBizLevel[]) a.clone();
    }

    public final int getLevel() {
        return this.level;
    }

    public LivePerfBizLevel(String r1, int r2, int r3) {
        super(r1, r2);
        this.level = r3;
    }
}
