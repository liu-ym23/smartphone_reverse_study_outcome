package com.bytedance.android.livesdk.interactivity.common.utils;

import android.text.SpannableString;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.message.model.e2;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static CharSequence a(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$getEmojiParsedText");
        SpannableString r0 = new SpannableString(r1);
        ab2.a.e(r0, (int) (s1.E() * r2));
        return r0;
    }

    public static void b(e2 r4, DataCenter r5) {
        o32.a.a("insert real time message manager");
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, r5, 0, 2);
        if (r6 != null) goto L5;
        return;
    L5:
        vlc.d r7 = (vlc.d) r6.getMessageManager().getValue();
        if (r7 == null) goto L9;
        r7.j(r4, true);
        return;
    }
}
