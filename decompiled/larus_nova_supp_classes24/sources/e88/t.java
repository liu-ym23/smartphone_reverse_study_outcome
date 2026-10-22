package e88;

import android.animation.ValueAnimator;
import com.larus.audio.constant.GlobalAudioSceneEnum;
import com.larus.media.MediaOccupyStrategy;
import com.larus.media.MediaResourceManager;
import com.larus.media.o0;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class t implements com.larus.media.v {
    public String a;
    public boolean b;
    public boolean c;
    public ValueAnimator d;
    public final /* synthetic */ com.larus.audioplayer.impl.music.a e;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MediaResourceManager.FlowAudioBroadcastEvent.values().length];
            r0[MediaResourceManager.FlowAudioBroadcastEvent.asrWaitReplyBegin.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MediaResourceManager.FlowAudioBroadcastEvent.asrWaitReplyEnd.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public t(com.larus.audioplayer.impl.music.a r1) {
        this.e = r1;
    }

    public final boolean b(lk9.g r2) {
        Intrinsics.checkNotNullParameter(r2, "applicant");
        Map r0 = o0.a;
        return o0.a(GlobalAudioSceneEnum.MUSIC, r2.getScene());
    }

    public final void e(lk9.g r2) {
        Intrinsics.checkNotNullParameter(r2, "applicant");
        com.larus.media.v.a.d(r2);
        this.b = false;
    }

    public final void f(MediaResourceManager.a r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        Intrinsics.checkNotNullParameter(r7, "event");
        if (com.larus.media.o.a() == false) goto L18;
        MediaResourceManager.FlowAudioBroadcastEvent r0 = r7.c;
        if (r0 != null) goto L7;
        int r1 = -1;
    L9:
        if (r1 != 1) goto L11;
        FLogger.a.i("MusicPlayEngine", "event asrWaitReplyBegin , msgId: " + r7.b + ", musicId: " + this.e.a.a);
        this.c = true;
        return;
    L11:
        if (r1 == 2) goto L13;
        FLogger.a.i("MusicPlayEngine", "else  msgId: " + r7.b + ", musicId: " + this.e.a.a);
        this.c = false;
        return;
    L13:
        FLogger.a.i("MusicPlayEngine", "event asrWaitReplyEnd , msgId: " + r7.b + ", musicId: " + this.e.a.a);
        if (this.c == false) goto L20;
        this.c = false;
        final com.larus.audioplayer.impl.music.a r8 = this.e;
        t0.a(new k(this, r8));
        return;
    L20:
        return;
    L7:
        r1 = a.a[r0.ordinal()];
        goto L9
    }

    public final void a(lk9.g r5, final float r6) {
        Intrinsics.checkNotNullParameter(r5, "applicant");
        com.larus.media.v.a.f(r5, r6);
        final String r0 = this.a;
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        this.a = null;
        com.larus.audioplayer.impl.music.a r1 = this.e;
        r1.i = r6;
        r1.f.c(r6);
        if (this.b == false) goto L11;
        FLogger.a.i("MusicPlayEngine", "audio focus onMediaResume and resume. applicant:" + r5 + ", volumeFactor: " + r6 + ", musicId: " + this.e.a.a);
        this.b = false;
        if (this.c == true) goto L12;
        final com.larus.audioplayer.impl.music.a r7 = this.e;
        t0.a(new l(this, r6, r7, r0));
        return;
    L12:
        return;
    }

    public final void d(final lk9.g r3, final lk9.g r4) {
        Intrinsics.checkNotNullParameter(r3, "current");
        Intrinsics.checkNotNullParameter(r4, "applicant");
        com.larus.media.v.a.c(r3, r4);
        final com.larus.audioplayer.impl.music.a r0 = this.e;
        t0.a(new m(this, r0, r4, r3));
    }

    public final void g(lk9.g r4, final float r5) {
        Intrinsics.checkNotNullParameter(r4, "applicant");
        com.larus.media.v.a.g(r4, r5);
        this.e.i = r5;
        FLogger.a.i("MusicPlayEngine", "audio focus onMediaVolumeChange. applicant:" + r4 + ", volumeFactor: " + r5 + ", musicId: " + this.e.a.a + '.');
        final com.larus.audioplayer.impl.music.a r6 = this.e;
        t0.a(new h(this, r6, r5));
    }

    public final void i(lk9.g r2, lk9.g r3) {
        Intrinsics.checkNotNullParameter(r2, "current");
        Intrinsics.checkNotNullParameter(r3, "applicant");
        com.larus.media.v.a.e(r2, r3);
        this.b = true;
        this.a = r3.getScene();
    }

    public final MediaOccupyStrategy c(lk9.g r1, lk9.g r2, int r3) {
        return com.larus.media.v.a.a(this, r1, r2, r3);
    }

    public final MediaOccupyStrategy h(lk9.g r3, lk9.g r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "current");
        Intrinsics.checkNotNullParameter(r4, "applicant");
        boolean r6 = false;
        if (Intrinsics.areEqual(r4.getScene(), "dora") == false) goto L14;
        IFlowSdkDepend r7 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r7 == null) goto L11;
        com.larus.home.impl.sdk.s r8 = r7.s0();
        if (r8 == null) goto L11;
        if (r8.c() != true) goto L11;
        boolean r9 = true;
    L12:
        if (r9 == false) goto L14;
        boolean r10 = true;
    L15:
        Map r1 = o0.a;
        if (o0.c(GlobalAudioSceneEnum.MUSIC, r4.getScene()) == true) goto L18;
        if (r10 == true) goto L18;
    L19:
        if (r6 == false) goto L22;
        return MediaOccupyStrategy.PAUSE;
    L22:
        return MediaOccupyStrategy.INTERRUPT;
    L18:
        r6 = true;
    L11:
        r9 = false;
    L14:
        r10 = false;
        goto L15
    }
}
