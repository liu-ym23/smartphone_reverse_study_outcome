package com.bytedance.android.live.liveinteract.revenue.guestlink.ui;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.chatroom.t;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.message.model.n5;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.live.datacontext.j;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public vlc.d a;
    public final List<n5> b;
    public final Lazy c;
    public final d d;
    public final j1 e;

    public static final class a {
    }

    static {
    }

    public final void c() {
        vlc.d r0 = this.a;
        if (r0 == null) goto L5;
        r0.removeMessageListener((l) this.c.getValue());
    L5:
        ((ArrayList) this.b).clear();
        this.d.b();
        this.d.clear();
    }

    public final void d() {
        ALogger.i("GiftMarqueeViewController", "reset");
        ((ArrayList) this.b).clear();
        this.d.clear();
    }

    public final void b() {
        t r0 = m.b();
        if (r0 == null) goto L7;
        j r1 = r0.getMessageManager();
        if (r1 == null) goto L7;
        vlc.d r2 = (vlc.d) r1.getValue();
    L8:
        this.a = r2;
        if (r2 == null) goto L12;
        r2.addMessageListener(MessageType.GIFT.getIntType(), (l) this.c.getValue());
        return;
    L12:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public static String a(n5 r4) {
        String r0 = String.valueOf(r4.getGiftId()) + "-" + String.valueOf(r4.getGroupId()) + "-" + String.valueOf(r4.getGroupCount());
        IBaseUser r1 = r4.getFromUser();
        if (r1 == null) goto L5;
        r0 = r0 + "_" + r1.getWebcastUid();
    L5:
        IBaseUser r5 = r4.getToUser();
        if (r5 != null) goto L8;
        return r0;
    L8:
        return r0 + "_" + r5.getWebcastUid();
    }

    public c(GiftMarqueeContainer r2, j1 r3) {
        Intrinsics.checkNotNullParameter(r2, "giftMarqueeContainer");
        Intrinsics.checkNotNullParameter(r3, "outerScopeProvider");
        this.d = r2;
        this.e = r3;
        r2.f(new b(this));
        this.b = new ArrayList();
        this.c = LazyKt.lazy(new GiftMarqueeViewController$mOnMessageListener$2(this));
    }
}
