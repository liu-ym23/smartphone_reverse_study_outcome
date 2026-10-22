package jgb;

import com.ss.android.lark.keyboard.plugin.tool.voice.audio2.AudioViewModel;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends u2b.a {

    /* JADX INFO: renamed from: jgb.a$a, reason: collision with other inner class name */
    public static final class C0280a {
    }

    static {
    }

    public a() {
    }

    public final CharSequence d(f5b.b r9) {
        Intrinsics.checkNotNullParameter(r9, "messageInfo");
        String r0 = UIHelper.getString(2131891532);
        int r10 = r9.getMessage().getContent().getDuration();
        if (r10 > 0) goto L5;
        int r11 = 0;
    L6:
        if (r11 <= 0) goto L12;
        Intrinsics.checkNotNull(r0);
        String r12 = " " + r11 + 8243;
        int r1 = StringsKt.lastIndexOf$default(r0, ']', 0, false, 6, null);
        if (r1 < 0) goto L10;
        String r13 = r0.substring(0, r1) + r12 + r0.substring(r1);
    L14:
        return r13;
    L10:
        r13 = r0 + r12;
        goto L14
    L12:
        Intrinsics.checkNotNull(r0);
        return r0;
    L5:
        r11 = Math.max(1, r10 / AudioViewModel.ASR_SESSION_IDLE);
        goto L6
    }
}
