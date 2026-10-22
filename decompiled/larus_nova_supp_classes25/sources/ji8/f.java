package ji8;

import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.audiov3.task.tts.TtsErrorType;
import com.larus.audio.audiov3.tts.PlayStateEnum;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.z2;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f implements n68.a {
    public final Message a;
    public final PlayStateEnum b;
    public final WeakReference<CommonMenu> c;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[PlayStateEnum.values().length];
            r0[PlayStateEnum.PLAY_STATE_PLAYING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[PlayStateEnum.PLAY_STATE_PREPARE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public final void d(PlayStateEnum r1) {
    }

    public final void e(TtsErrorType r1) {
    }

    public final void c(final PlayStateEnum r3) {
        if (z2.a.m3() == true) goto L5;
        return;
    L5:
        final CommonMenu r0 = this.c.get();
        if (r0 != null) goto L9;
        return;
    L9:
        if (r3 != this.b) goto L11;
        return;
    L11:
        r0.post(new e(this, r0, r3));
    }

    public f(CommonMenu r3, Message r4) {
        PlayStateEnum r0 = AudioServiceDelegate.a.r0().l();
        Intrinsics.checkNotNullParameter(r3, "menu");
        Intrinsics.checkNotNullParameter(r4, "msg");
        this.a = r4;
        this.b = r0;
        this.c = new WeakReference(r3);
    }

    public final void a(boolean r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
    }

    public final void b(boolean r1, String r2, String r3, long r4) {
        Intrinsics.checkNotNullParameter(r3, "taskId");
    }
}
