package v19;

import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.larus.platform.api.f2;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class r5 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(Context r7, long r8) {
        if (r7 != null) goto L6;
        return "";
    L6:
        if (f2.a.h() == true) goto L27;
        if (Intrinsics.areEqual(Locale.getDefault().getLanguage(), Locale.CHINA.getLanguage()) == true) goto L27;
        if (Intrinsics.areEqual(Locale.getDefault().getLanguage(), Locale.JAPAN.getLanguage()) == true) goto L27;
        if (Intrinsics.areEqual(Locale.getDefault().getLanguage(), Locale.KOREA.getLanguage()) == true) goto L27;
        if (AppHost.a.isOversea() == false) goto L27;
        if (r8 < 1000) goto L37;
        if (r8 >= 1000000) goto L21;
        String r9 = r7.getResources().getString(2131900314, new Object[]{b(r8, 1000)});
        Intrinsics.checkNotNull(r9);
        return r9;
    L21:
        if (r8 < 1000000000) goto L23;
        String r10 = r7.getResources().getString(2131900315, new Object[]{b(r8, 1000000000)});
        Intrinsics.checkNotNull(r10);
        return r10;
    L23:
        String r11 = r7.getResources().getString(2131900316, new Object[]{b(r8, 1000000)});
        Intrinsics.checkNotNull(r11);
        return r11;
    L37:
        return String.valueOf(r8);
    L27:
        if (r8 < 10000) goto L33;
        if (r8 < 100000000) goto L31;
        String r12 = r7.getResources().getString(2131900313, new Object[]{b(r8, 100000000)});
        Intrinsics.checkNotNull(r12);
        return r12;
    L31:
        String r13 = r7.getResources().getString(2131900312, new Object[]{b(r8, 10000)});
        Intrinsics.checkNotNull(r13);
        return r13;
    L33:
        return String.valueOf(r8);
    }

    public static String b(long r7, long r9) {
        DecimalFormat r0 = new DecimalFormat("0.0", new DecimalFormatSymbols(Locale.US));
        r0.setRoundingMode(RoundingMode.DOWN);
        return StringsKt.replace$default(r0.format(r7 / r9), ".0", "", false, 4, null);
    }
}
