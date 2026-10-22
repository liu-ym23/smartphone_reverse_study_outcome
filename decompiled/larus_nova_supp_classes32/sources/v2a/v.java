package v2a;

import com.google.android.material.appbar.AppBarLayout;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.base.AppBarLayoutStateListener;
import com.larus.voice_setting.voice.mix.VoiceMixBar;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class v extends AppBarLayoutStateListener {
    public final /* synthetic */ VoiceMixBar b;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AppBarLayoutStateListener.State.values().length];
            r0[AppBarLayoutStateListener.State.COLLAPSED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public v(VoiceMixBar r1) {
        this.b = r1;
    }

    @Override // com.larus.voice_setting.voice.base.AppBarLayoutStateListener
    public final void a(AppBarLayout r3, AppBarLayoutStateListener.State r4, AppBarLayoutStateListener.State r5) {
        Intrinsics.checkNotNullParameter(r3, "appBarLayout");
        Intrinsics.checkNotNullParameter(r4, "lastState");
        Intrinsics.checkNotNullParameter(r5, "state");
        FLogger.a.i("VoiceMixBar", "[onStateChange] last:" + r4 + ", state=" + r5);
        if (a.a[r5.ordinal()] != 1) goto L5;
        VoiceMixBar r6 = this.b;
        r6.c = r5;
        r6.applyState();
        return;
    L5:
        VoiceMixBar r7 = this.b;
        r7.c = r5;
        r7.applyState();
    }
}
