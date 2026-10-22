package com.larus.bmhome.chat.component.list;

import android.content.Context;
import android.os.SystemClock;
import com.larus.bmhome.chat.api.b0$a;
import com.larus.bmhome.chat.stop.PendingAppletActionCancellation;
import com.larus.bmhome.databinding.LarusPageChatBinding;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.im.bean.message.Message;
import com.larus.im.d;
import com.larus.im.internal.legacy.NativeCmdServiceImpl;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocationResult;
import com.larus.utils.logger.FLogger;
import hq9.a3;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import vc9.a;
import vc9.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class ChatListComponent$e implements a3 {
    public final /* synthetic */ Message a;
    public final /* synthetic */ ChatListComponent b;
    public final /* synthetic */ boolean c;

    public ChatListComponent$e(Message r1, ChatListComponent r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a(LocationResult r8, Integer r9, GeoLocationInfo r10) {
        Intrinsics.checkNotNullParameter(r8, "code");
        PendingAppletActionCancellation r11 = PendingAppletActionCancellation.a;
        Message r12 = this.a;
        r11.getClass();
        if (PendingAppletActionCancellation.b(r12) == false) goto L7;
        FLogger.a.i("need_location", "drop cancelled location result, messageId[" + this.a.getMessageId() + ']');
        return;
    L7:
        if (r8 != LocationResult.SUCCESS) goto L15;
        FLogger.a.i(this.b.n, "locationAndModify triggered success");
        LarusPageChatBinding r13 = this.b.h4();
        if (r13 == null) goto L13;
        ChatMessageList r0 = r13.n;
        if (r0 == null) goto L13;
        b0$a.a(r0, false, 0, null, null, 0, 31);
    L13:
        this.b.U5().replaceMessageForLocation(this.a);
        return;
    L15:
        if (this.c == false) goto L17;
        FLogger.a.i(this.b.n, "locationAndModify fail code " + r8 + " retryStrategy true");
        this.b.Y6(this.a, false);
        return;
    L17:
        FLogger.a.i(this.b.n, "locationAndModify fail code " + r8 + " retryStrategy false");
        long r14 = SystemClock.elapsedRealtime();
        ChatListComponent r1 = this.b;
        if ((r14 - r1.J3) <= 5000) goto L20;
        t19.s r15 = t19.s.a;
        Context r16 = r1.getContext();
        r15.getClass();
        t19.s.b(r16, 2131898481, false);
        this.b.J3 = SystemClock.elapsedRealtime();
    L20:
        ChatListComponent r17 = this.b;
        Message r18 = this.a;
        r17.getClass();
        NativeCmdServiceImpl r19 = d.b();
        ArrayList r2 = new ArrayList();
        r2.add(new b("message_id", r18.getMessageId()));
        wc9.e r20 = r17.R4();
        if (r20 == null) goto L25;
        Integer r21 = r20.j;
        if (r21 == null) goto L25;
        r2.add(new b("conversation_type", String.valueOf(r21.intValue())));
    L25:
        r19.sendBizCmd(new a(r2, "report_loc_update_error"), new k6());
    }
}
