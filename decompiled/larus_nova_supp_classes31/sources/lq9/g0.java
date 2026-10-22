package lq9;

import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.model.EditPos;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.o0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g0 {
    public static final boolean b(SpeakerVoice r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (o0.d(r2.getCreatorId()) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(r2.getCreatorId(), AccountService.a.getUserId()) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static final boolean a(SpeakerVoice r3, EditPos r4) {
        if (r3 == null) goto L26;
        if (r4 == null) goto L26;
        if (r4.j() == true) goto L9;
        return false;
    L9:
        List r5 = r3.getMixVoiceList();
        if (r5 == null) goto L12;
        int r6 = r5.size();
    L14:
        if (r6 <= 1) goto L25;
        f0 r7 = z2.a.o3();
        int r2 = r7.b(r3.getLanguageCode());
        if (r7.a == true) goto L18;
    L20:
        boolean r8 = false;
    L21:
        if (r8 == true) goto L25;
        if (b(r3) == true) goto L25;
        return false;
    L18:
        if (r2 != 3) goto L20;
        r8 = true;
    L25:
        return true;
    L12:
        r6 = 0;
    L26:
        return false;
    }
}
