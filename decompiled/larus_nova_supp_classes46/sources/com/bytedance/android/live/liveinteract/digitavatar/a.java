package com.bytedance.android.live.liveinteract.digitavatar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final int a;
    public final int b;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.digitavatar.a$a, reason: collision with other inner class name */
    public static final class C0026a {
    }

    static {
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("AvatarAction(desc=");
        int r1 = this.a;
        if (r1 != 0) goto L5;
        String r2 = "null";
    L21:
        r0.append(r2);
        r0.append(", action=");
        r0.append(this.a);
        r0.append(", playCount=");
        r0.append(this.b);
        r0.append(')');
        return r0.toString();
    L5:
        if (r1 != 1) goto L7;
        r2 = "打招呼";
        goto L21
    L7:
        if (r1 != 2) goto L9;
        r2 = "拿起麦克风";
        goto L21
    L9:
        if (r1 != 3) goto L11;
        r2 = "正常唱歌";
        goto L21
    L11:
        if (r1 != 4) goto L13;
        r2 = "高潮唱歌";
        goto L21
    L13:
        if (r1 == 5) goto L15;
        r2 = "未知动作";
        goto L21
    L15:
        r2 = "放下麦克风";
        goto L21
    }

    public a(int r1) {
        this.a = r1;
        this.b = 1;
    }
}
