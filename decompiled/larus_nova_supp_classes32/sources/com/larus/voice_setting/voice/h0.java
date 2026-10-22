package com.larus.voice_setting.voice;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.impl.databinding.LarusTtsSpeakerContentNewStyleBinding;
import com.larus.voice_setting.voice.base.AppBarLayoutStateListener;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class h0 extends AppBarLayoutStateListener {
    public final /* synthetic */ DoubleTabTtsSpeakerSettingFragment b;
    public final /* synthetic */ LarusTtsSpeakerContentNewStyleBinding c;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AppBarLayoutStateListener.State.values().length];
            r0[AppBarLayoutStateListener.State.COLLAPSED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public h0(DoubleTabTtsSpeakerSettingFragment r1, LarusTtsSpeakerContentNewStyleBinding r2) {
        this.b = r1;
        this.c = r2;
    }

    @Override // com.larus.voice_setting.voice.base.AppBarLayoutStateListener
    public final void a(AppBarLayout r3, AppBarLayoutStateListener.State r4, AppBarLayoutStateListener.State r5) {
        Intrinsics.checkNotNullParameter(r3, "appBarLayout");
        Intrinsics.checkNotNullParameter(r4, "lastState");
        Intrinsics.checkNotNullParameter(r5, "state");
        FLogger.a.i("DoubleTabTtsSpeakerSettingFragment", "[onStateChange] last:" + r4 + ", state=" + r5);
        if (a.a[r5.ordinal()] != 1) goto L8;
        DoubleTabTtsSpeakerSettingFragment r6 = this.b;
        List<String> r7 = DoubleTabTtsSpeakerSettingFragment.Z;
        r6.X90().getSpeakerVoiceEditModel().p(true);
        ConstraintLayout r8 = this.c.k;
        if (r8 == null) goto L9;
        com.larus.utils.e1.o(r8);
        return;
    L9:
        return;
    }
}
