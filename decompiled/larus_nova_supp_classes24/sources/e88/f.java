package e88;

import com.larus.platform.api.IVideoController;
import com.larus.platform.api.l4;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f implements l4 {
    public final /* synthetic */ com.larus.audioplayer.impl.music.a a;
    public final /* synthetic */ IVideoController b;

    public f(com.larus.audioplayer.impl.music.a r1, IVideoController r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(String r3, com.larus.video.impl.sdk.a r4) {
        if (r4 != null) goto L7;
        this.a.d = true;
        this.b.release();
        return;
    L7:
        if (this.a.e == false) goto L10;
        FLogger.a.i("MusicPlayEngine", "ignore videoModel ready after background audio takeover, musicId:" + this.a.a.a);
        this.b.release();
        return;
    L10:
        this.b.j(r4, false);
        com.larus.audioplayer.impl.music.a r5 = this.a;
        r5.c = true;
        b r6 = r5.m;
        if (r6 == null) goto L14;
        r6.run();
        return;
    }
}
