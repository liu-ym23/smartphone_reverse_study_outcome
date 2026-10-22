package com.bytedance.android.live.liveinteract.videotalk.emoji;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ d a;
    public final /* synthetic */ com.bytedance.android.live.liveinteract.videotalk.emoji.model.j b;
    public final /* synthetic */ long c;
    public final /* synthetic */ Ref.LongRef d;

    public k(d r1, com.bytedance.android.live.liveinteract.videotalk.emoji.model.j r2, long r3, Ref.LongRef r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void accept(Object r10) {
        com.bytedance.android.live.network.response.e r11 = (com.bytedance.android.live.network.response.e) r10;
        this.a.d = false;
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        long r3 = this.b.getEmojiId();
        int r5 = this.b.getEmojiType();
        long r6 = this.c;
        String r8 = r11.logId;
        r0.getClass();
        TalkRoomBusinessFullLinkMonitor.u0(r3, r5, r6, r8);
        d.a r1 = (d.a) ((q46.b) this.a).a;
        if (r1 == null) goto L5;
        r1.w2((com.bytedance.android.live.liveinteract.voicechat.model.a) r11.data);
    L5:
        com.bytedance.android.live.liveinteract.videotalk.emoji.model.a r12 = this.b.getCustomizedRandomResource();
        if (r12 != null) goto L8;
        return;
    L8:
        if (r12.isRandomEmoji() == true) goto L10;
        return;
    L10:
        if (r12.getStatus() == 1) goto L33;
        int r13 = r12.getType();
        if (r13 != 1) goto L14;
        String r14 = s1.B(2131915065);
    L18:
        if (r14 != null) goto L20;
        return;
    L20:
        if ((!TextUtils.isEmpty(r14)) == true) goto L23;
        r14 = null;
    L23:
        if (r14 == null) goto L39;
        com.bytedance.android.livesdk.sharedpref.e r2 = com.bytedance.android.livesdk.sharedpref.c.y1;
        Map r4 = (Map) r2.getValue();
        Integer r7 = (Integer) r4.get(Long.valueOf(this.b.getEmojiId()));
        if (r7 == null) goto L27;
        int r9 = r7.intValue();
    L29:
        if (r9 >= 3) goto L31;
        f2.c(r14, 0);
        r4.put(Long.valueOf(this.b.getEmojiId()), Integer.valueOf(r9 + 1));
        com.bytedance.android.livesdk.sharedpref.f.d(r2, r4);
    L31:
        com.bytedance.android.livesdk.sharedpref.f.d(r2, r4);
        return;
    L27:
        r9 = 0;
        goto L29
    L39:
        return;
    L14:
        if (r13 == 2) goto L16;
        r14 = "";
        goto L18
    L16:
        r14 = s1.B(2131915064);
        goto L18
    L33:
        if (this.d.element != 1) goto L41;
        f2.c("已公开，所有人可见", 0);
        return;
    }
}
