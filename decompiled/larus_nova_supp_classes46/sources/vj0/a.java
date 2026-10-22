package vj0;

import com.bytedance.android.live.liveinteract.videotalk.contract.VideoRoomPreApplyContract$View;
import yf0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class a extends e<VideoRoomPreApplyContract$View> {
    public abstract void d(String r1);

    public abstract void e(boolean r1, int r2, String r3);

    public a(VideoRoomPreApplyContract$View r1) {
        super(r1);
    }

    public static /* synthetic */ void f(a r1, boolean r2, String r3, int r4) {
        if ((r4 & 2) == 0) goto L5;
        int r0 = 20;
    L7:
        if ((r4 & 4) == 0) goto L9;
        r3 = "";
    L9:
        r1.e(r2, r0, r3);
        return;
    L5:
        r0 = 0;
        goto L7
    }
}
