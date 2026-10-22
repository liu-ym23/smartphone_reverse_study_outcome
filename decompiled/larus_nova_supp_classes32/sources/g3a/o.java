package g3a;

import com.larus.av_call.constant.ThemeType;
import com.larus.av_call.model.RealtimePageMode;
import com.larus.im.bean.bot.BotModel;
import com.larus.voicecall.impl.component.content.RealtimeContentComponent;
import com.larus.voicecall.impl.ui.VoiceCallBgLayout;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class o implements w3a.i {
    public final /* synthetic */ RealtimeContentComponent a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RealtimePageMode.values().length];
            r0[RealtimePageMode.HALF_SCREEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[RealtimePageMode.FULL_SCREEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public o(RealtimeContentComponent r1) {
        this.a = r1;
    }

    @Override // w3a.i
    public final void a(w3a.h r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        if ((r6 instanceof w3a.a) == false) goto L17;
        RealtimePageMode r7 = ((w3a.a) r6).a;
        int r8 = a.a[r7.ordinal()];
        if (r8 != 1) goto L7;
        VoiceCallBgLayout r9 = this.a.Nl();
        if (r9 == null) goto L20;
        BotModel r2 = this.a.m3().H0;
        e3a.a r3 = this.a.m3();
        r3.getClass();
        Lazy r4 = c4a.l.a;
        ThemeType r5 = c4a.l.b(r3.H0);
        Intrinsics.checkNotNullParameter(r5, "themeType");
        r9.R5(r5, r2, true);
        return;
    L20:
        return;
    L7:
        if (r8 != 2) goto L12;
        this.a.F2().setVisibility(0);
        VoiceCallBgLayout r10 = this.a.Nl();
        if (r10 == null) goto L18;
        BotModel r11 = this.a.m3().H0;
        e3a.a r12 = this.a.m3();
        r12.getClass();
        Lazy r13 = c4a.l.a;
        ThemeType r14 = c4a.l.b(r12.H0);
        Intrinsics.checkNotNullParameter(r14, "themeType");
        r10.R5(r14, r11, false);
        return;
    L18:
        return;
    L12:
        throw new NoWhenBranchMatchedException();
    }
}
