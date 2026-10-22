package com.bytedance.android.livesdk.chatroom.vs_base.base.setting.config;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs_base/base/setting/config/ReplayBarrageSettingSpeed;", "", "", "level", "I", "getLevel", "()I", "", "factor", "F", "getFactor", "()F", "", "des", "Ljava/lang/String;", "getDes", "()Ljava/lang/String;", "Companion", "a", "SLOW", "NORMAL", "FAST", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ReplayBarrageSettingSpeed extends Enum<ReplayBarrageSettingSpeed> {
    public static final a Companion = null;
    public static final ReplayBarrageSettingSpeed FAST = null;
    public static final ReplayBarrageSettingSpeed NORMAL = null;
    public static final ReplayBarrageSettingSpeed SLOW = null;
    public static final /* synthetic */ ReplayBarrageSettingSpeed[] a = null;
    private final String des;
    private final float factor;
    private final int level;

    public static final class a {
        public a() {
        }

        public static ReplayBarrageSettingSpeed a(int r6) {
            ReplayBarrageSettingSpeed[] r0 = ReplayBarrageSettingSpeed.values();
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L11;
            ReplayBarrageSettingSpeed r4 = r0[r3];
            if (r4.getLevel() != r6) goto L7;
            boolean r5 = true;
        L8:
            if (r5 == true) goto L12;
            r3 = r3 + 1;
        L12:
            if (r4 == null) goto L14;
            return r4;
        L14:
            return ReplayBarrageSettingSpeed.NORMAL;
        L7:
            r5 = false;
            goto L8
        L11:
            r4 = null;
            goto L12
        }
    }

    static {
        ReplayBarrageSettingSpeed r7 = new ReplayBarrageSettingSpeed("SLOW", 0, 0, 0.5f, "慢速");
        SLOW = r7;
        ReplayBarrageSettingSpeed r1 = new ReplayBarrageSettingSpeed("NORMAL", 1, 1, 1.0f, "正常");
        NORMAL = r1;
        ReplayBarrageSettingSpeed r2 = new ReplayBarrageSettingSpeed("FAST", 2, 2, 1.5f, "快速");
        FAST = r2;
        a = new ReplayBarrageSettingSpeed[]{r7, r1, r2};
        Companion = new a();
    }

    public static ReplayBarrageSettingSpeed valueOf(String r1) {
        return (ReplayBarrageSettingSpeed) r27.a.a(ReplayBarrageSettingSpeed.class, r1);
    }

    public static ReplayBarrageSettingSpeed[] values() {
        return (ReplayBarrageSettingSpeed[]) a.clone();
    }

    public final String getDes() {
        return this.des;
    }

    public final float getFactor() {
        return this.factor;
    }

    public final int getLevel() {
        return this.level;
    }

    public ReplayBarrageSettingSpeed(String r1, int r2, int r3, float r4, String r5) {
        super(r1, r2);
        this.level = r3;
        this.factor = r4;
        this.des = r5;
    }
}
