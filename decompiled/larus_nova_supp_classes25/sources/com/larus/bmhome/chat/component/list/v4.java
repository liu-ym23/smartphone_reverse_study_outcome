package com.larus.bmhome.chat.component.list;

import by7.a;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class v4 implements Function0 {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ v4(ChatListComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ChatListComponent r0 = this.a;
        Pair r1 = r0.U3;
        if (r1 != null) goto L5;
    L31:
        JSONObject r2 = new JSONObject();
        Intrinsics.checkNotNullParameter(r2, "params");
        r2.put("action_step", "to_up");     // Catch: JSONException -> L34
    L36:
        TrackParams r3 = new TrackParams().merge(r2);
        a r4 = new a("click_back_up");
        r4.a.merge(r3);
        r4.b();
        return Unit.INSTANCE;
    L34:
        e = move-exception;
        FLogger.a.e("ClickButtonEventHelper", "error in ClickButtonEventHelper clickBackUp " + e.getLocalizedMessage());
        goto L36
    L5:
        if (r0.T3 == false) goto L31;
        List r5 = r0.getCurrentList();
        if (r5 == null) goto L20;
        Iterator r6 = r5.iterator();
        int r7 = 0;
    L10:
        if (r6.hasNext() == false) goto L18;
        if (((Message) r6.next()).getLocalIndex() != ((Number) r1.getFirst()).longValue()) goto L14;
        boolean r8 = true;
    L15:
        if (r8 == true) goto L19;
        r7 = r7 + 1;
    L19:
        Integer r9 = Integer.valueOf(r7);
    L21:
        if (r9 == null) goto L31;
        if (r9.intValue() == (-1)) goto L31;
        r0.g7();
        ChatMessageList r10 = r0.o5();
        if (r10 == null) goto L27;
        r10.setShowTopButton(true);
    L27:
        ChatMessageList r11 = r0.o5();
        if (r11 == null) goto L30;
        r11.g0(r9.intValue(), ((Number) r1.getSecond()).intValue());
    L30:
        r0.U1();
        goto L31
    L14:
        r8 = false;
        goto L15
    L18:
        r7 = -1;
        goto L19
    L20:
        r9 = null;
        goto L21
    }
}
