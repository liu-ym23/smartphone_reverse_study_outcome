package qb2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g extends com.bytedance.android.livesdk.interactivity.service.richcontent.config.b {
    public final float i;

    public /* synthetic */ g(boolean r2, float r3, int r4) {
        if ((r4 & 2) == 0) goto L6;
        r2 = true;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 1.0f;
    L8:
        this(0, r2, r3);
    }

    public g(int r2, boolean r3, float r4) {
        if (r2 <= 0) goto L4;
        boolean r0 = true;
    L5:
        super(r0, r2, r3);
        this.i = r4;
        return;
    L4:
        r0 = false;
        goto L5
    }
}
