package xb8;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.model.EditPos;
import com.larus.platform.service.z2;
import kotlin.jvm.internal.Intrinsics;
import lq9.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r5, ItemTextArrow r6, SpeakerVoice r7, boolean r8, boolean r9) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r6 != null) goto L6;
        return;
    L6:
        boolean r1 = true;
        if (g0.b(r7) == false) goto L16;
        if (r7 != null) goto L10;
    L12:
        boolean r0 = false;
    L13:
        if (r0 == false) goto L16;
        r6.b6(r5.getString(2131910777), Integer.valueOf(ContextCompat.getColor(r5, 2131102650)));
        r6.setStyle(0);
        return;
    L10:
        if (r7.getStatus() != 4) goto L12;
        r0 = true;
    L16:
        if (g0.b(r7) == false) goto L25;
        if (r7 != null) goto L19;
    L21:
        boolean r2 = false;
    L22:
        if (r2 == false) goto L25;
        r6.b6(r5.getString(2131908207), Integer.valueOf(ContextCompat.getColor(r5, 2131102650)));
        return;
    L19:
        if (r7.getStatus() != 3) goto L21;
        r2 = true;
    L25:
        if (r9 == true) goto L38;
        if (r8 == true) goto L37;
        if (r7 == null) goto L29;
        String r10 = r7.getName();
    L30:
        if (r10 != null) goto L32;
    L35:
        boolean r11 = true;
    L36:
        if (r11 == false) goto L38;
    L32:
        if (r10.length() == 0) goto L35;
        r11 = false;
        goto L36
    L29:
        r10 = null;
    L37:
        String r12 = r5.getString(2131908048);
        int r13 = ItemTextArrow.k;
        r6.Z5(r12, null);
        return;
    L38:
        String r14 = "";
        if (z2.a.hideAudioVoiceSettingsName() == false) goto L41;
        int r15 = ItemTextArrow.k;
        r6.Z5("", null);
        return;
    L41:
        if (r7 == null) goto L43;
        String r16 = r7.getName();
    L44:
        if (r7 == null) goto L46;
        Float r17 = Float.valueOf(r7.getSpeechRateF64());
    L47:
        if (r16 != null) goto L49;
    L52:
        if (r1 == true) goto L64;
        if (r17 != null) goto L56;
    L63:
        r14 = r16;
        goto L64
    L56:
        if (Intrinsics.areEqual(r17, 0.0f) == true) goto L63;
        AppHost.Companion r18 = AppHost.a;
        if (r18.isOversea() == true) goto L63;
        if (r18.isPlugin() == true) goto L63;
        r14 = r16 + ' ' + (r17.floatValue() / 10) + r5.getString(2131900179);
    L64:
        int r19 = ItemTextArrow.k;
        r6.Z5(r14, null);
        return;
    L49:
        if (r16.length() == 0) goto L52;
        r1 = false;
        goto L52
    L46:
        r17 = null;
        goto L47
    L43:
        r16 = null;
        goto L44
    }

    public static void b(Context r2, ItemTextArrow r3, SpeakerVoice r4, boolean r5, EditPos r6, boolean r7) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r3 != null) goto L6;
        return;
    L6:
        if (r4 != null) goto L8;
    L10:
        boolean r0 = false;
    L11:
        if (r0 == true) goto L13;
        a(r2, r3, r4, r5, r7);
        return;
    L13:
        if (r7 == false) goto L15;
    L19:
        r3.b6(r2.getString(2131907855), Integer.valueOf(ContextCompat.getColor(r2, 2131102650)));
        return;
    L15:
        if (g0.b(r4) == true) goto L19;
        if (g0.a(r4, r6) == true) goto L19;
        String r8 = r2.getString(2131908048);
        int r9 = ItemTextArrow.k;
        r3.Z5(r8, null);
        return;
    L8:
        if (r4.getConfStatus() != 2) goto L10;
        r0 = true;
        goto L11
    }
}
