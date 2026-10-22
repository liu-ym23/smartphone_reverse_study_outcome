package com.obric.assistant.chat.menu.omnitask;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.o;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.utils.k;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import va8.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class a extends com.obric.assistant.chat.menu.a<Pair<? extends Message, ? extends DMTaskState>> {
    public a(int r1) {
        super(r1);
    }

    public static void b(String r5, Fragment r6, Message r7) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r6, "fragment");
        Intrinsics.checkNotNullParameter(r7, "message");
        o r0 = o.a;
        Bundle r1 = new Bundle();
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Map r2 = r7.getExt();
        String r3 = null;
        if (r2 == null) goto L5;
        String r4 = (String) r2.get("log_id");
    L6:
        r1.putString("log_id", r4);
        r1.putString("instruction_id", k.b(r7));
        String r8 = r7.getMessageId();
        String r9 = NameKeys.UnloadStrategy_No_Strategy;
        if (r8 != null) goto L9;
        r8 = NameKeys.UnloadStrategy_No_Strategy;
    L9:
        r1.putString("message_id", r8);
        a0 r10 = s1a.a.g(r6).getAbility(a0.class);
        if (r10 == null) goto L12;
        r3 = r10.getBotId();
    L12:
        if (r3 == null) goto L15;
        r9 = r3;
    L15:
        r1.putString("bot_id", r9);
        r1.putString("device_id", r0.getDeviceId());
        Unit r11 = Unit.INSTANCE;
        r0.b(r5, r1);
        return;
    L5:
        r4 = null;
        goto L6
    }
}
