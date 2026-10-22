package c4a;

import android.app.Application;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.av_call.constant.ThemeType;
import com.larus.common.apphost.AppHost;
import com.larus.voicecall.impl.ui.VoiceCallVideoView;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f {
    public static final Application a = null;
    public static final VoiceCallVideoView.b b = null;
    public static final VoiceCallVideoView.b c = null;
    public static final VoiceCallVideoView.b d = null;
    public static final VoiceCallVideoView.b e = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ThemeType.values().length];
            r0[ThemeType.DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[ThemeType.MAIN_BOT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[ThemeType.UGC_BOT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[ThemeType.IMMERS_BOT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
        a = AppHost.a.getApplication();
        b = new VoiceCallVideoView.b(a(2131103298), 0.6f);
        c = new VoiceCallVideoView.b(ColorProtector.parseColor("#0C0D18"), 0.86f);
        d = new VoiceCallVideoView.b(a(2131103298), 0.05f);
        e = new VoiceCallVideoView.b(ColorProtector.parseColor("#0C0D18"), 0.0f);
        i5.v0();
    }

    public static int a(int r1) {
        return ContextCompat.getColor(a, r1);
    }

    public static void b(TextView r2, ThemeType r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "themeType");
        int r0 = a.a[r3.ordinal()];
        if (r0 != 1) goto L5;
        if (r4 == false) goto L26;
    L25:
        String r5 = "#80FFFFFF";
    L27:
        r2.setTextColor(ColorProtector.parseColor(r5));
        if (r3 != ThemeType.IMMERS_BOT) goto L31;
        r2.setShadowLayer(2.0f, 0.0f, 2.0f, ColorProtector.parseColor("#66000000"));
        return;
    L31:
        return;
    L26:
        r5 = "#CCFFFFFF";
        goto L27
    L5:
        if (r0 != 2) goto L7;
    L15:
        if (r4 == false) goto L21;
        if (i88.e.o(r3) == true) goto L25;
        r5 = "#80000000";
        goto L27
    L21:
        if (i88.e.o(r3) == true) goto L26;
        r5 = "#CC000000";
        goto L27
    L7:
        if (r0 == 3) goto L15;
        if (r0 != 4) goto L14;
        if (r4 == true) goto L26;
        r5 = "#FFFFFFFF";
        goto L27
    L14:
        throw new NoWhenBranchMatchedException();
    }
}
