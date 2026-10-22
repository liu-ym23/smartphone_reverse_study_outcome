package com.larus.bmhome.chat.layout.holder.helper;

import android.content.Context;
import androidx.collection.LruCache;
import androidx.fragment.app.Fragment;
import com.larus.bmhome.chat.layout.item.RecordStatus;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d implements t0 {
    public d() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.t0
    public final void b(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "keys");
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.t0
    public final List<ot8.a> a(Context r11, Message r12, Function0<Message> r13, com.larus.bmhome.chat.api.q0 r14, BotModel r15, wc9.e r16, com.larus.bmhome.chat.api.q0.a r17, JSONObject r18) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "data");
        Intrinsics.checkNotNullParameter(r15, "chatBot");
        ArrayList r5 = new ArrayList();
        com.larus.bmhome.view.screenmenu.l0 r6 = com.larus.bmhome.chat.layout.holder.menu.item.w0.a(r12, r17);
        if (r6 == null) goto L6;
        r5.add(r6);
    L6:
        if (com.larus.platform.service.z2.a.getDocFeatureEntranceConfig().a() == false) goto L18;
        ic8.p0 r7 = ic8.q0.a(r12);
        if (r7 == null) goto L15;
        Integer r8 = r7.d();
        int r9 = RecordStatus.SUMMARY_READY.getType();
        if (r8 == null) goto L15;
        if (r8.intValue() != r9) goto L15;
        boolean r10 = true;
    L16:
        if (r10 == false) goto L18;
        r5.add(com.larus.bmhome.chat.layout.holder.menu.item.q.a());
    L15:
        r10 = false;
    L18:
        r5.addAll(com.larus.bmhome.chat.layout.holder.menu.item.n.b(new com.larus.bmhome.chat.layout.holder.menu.item.n(), r11, r15, false, 8));
        v1.a(r5);
        v1.d(r5, r12, r16, r17);
        List<ot8.a> r19 = e.b(r5);
        LruCache r0 = ko8.a.a;
        String r1 = null;
        if (r14 == null) goto L21;
        Function0<Fragment> r4 = r14.getHostFragment();
    L23:
        if ((r4 instanceof by7.e) == false) goto L25;
        by7.e r20 = (by7.e) r4;
    L26:
        if (r16 == null) goto L28;
        r1 = ic8.n.f(r16);
    L28:
        String r21 = r1;
        JSONObject r22 = new JSONObject();
        r22.put("is_meeting_record_message", 1);
        r22.put("meeting_record_message_create_platform", "mobile");
        Unit r2 = Unit.INSTANCE;
        ko8.a.l(r19, r12, r15, r20, r21, "long_press_message", r22);
        return r19;
    L25:
        r20 = null;
        goto L26
    L21:
        r4 = null;
        goto L23
    }
}
