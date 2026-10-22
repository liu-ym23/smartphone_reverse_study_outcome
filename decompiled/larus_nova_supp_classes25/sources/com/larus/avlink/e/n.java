package com.larus.avlink.e;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.ExpiredInfo;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UplinkFileEntity;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class n implements td8.c {

    public static final class a {
    }

    static {
    }

    public n(td8.d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContext");
    }

    @Override // td8.c
    public final boolean a(int r4, xc8.b r5, xc8.b r6, List<? extends xc8.b> r7) {
        Intrinsics.checkNotNullParameter(r6, "current");
        Intrinsics.checkNotNullParameter(r7, "input");
        Iterator<? extends xc8.b> r8 = r7.iterator();
        int r9 = 0;
    L4:
        if (r8.hasNext() == false) goto L14;
        xc8.b r10 = r8.next();
        if (hp8.a.c(r10.getMessage()) == true) goto L8;
    L10:
        boolean r11 = false;
    L11:
        if (r11 == true) goto L15;
        r9 = r9 + 1;
    L15:
        if (r9 == (-1)) goto L20;
        return true;
    L20:
        return false;
    L8:
        if (hp8.a.b(r10.getMessage()) == true) goto L10;
        r11 = true;
        goto L11
    L14:
        r9 = -1;
        goto L15
    }

    @Override // td8.c
    public final List<xc8.b> b(int r53, xc8.b r54, xc8.b r55, List<xc8.b> r56) {
        Intrinsics.checkNotNullParameter(r55, "current");
        Intrinsics.checkNotNullParameter(r56, "input");
        Iterator<xc8.b> r1 = r56.iterator();
        int r3 = 0;
    L4:
        if (r1.hasNext() == false) goto L14;
        xc8.b r4 = r1.next();
        if (hp8.a.c(r4.getMessage()) == true) goto L8;
    L10:
        boolean r5 = false;
    L11:
        if (r5 == true) goto L15;
        r3 = r3 + 1;
    L15:
        if (r3 == (-1)) goto L59;
        if (r3 >= 0) goto L18;
    L20:
        boolean r2 = false;
    L21:
        if (r2 == true) goto L23;
        return r56;
    L23:
        xc8.b r6 = (xc8.b) ListProtector.get(r56, r3);
        List r7 = com.larus.bmhome.chat.sendimage.e.e(r6.getMessage().getContent()).getEntities();
        if (r7 != null) goto L26;
    L29:
        boolean r8 = true;
    L30:
        if (r8 == false) goto L32;
        return r56;
    L32:
        String r9 = r6.getMessage().getContent();
        if (r9 != null) goto L36;
        return r56;
    L36:
        if (Intrinsics.areEqual(r9, "null") == false) goto L38;
        return r56;
    L38:
        Message r10 = r6.getMessage();
        long r44 = r6.getMessage().getCreateTime();
        List r11 = com.larus.bmhome.chat.sendimage.e.e(r10.getContent()).getEntities();
        if (r11 == null) goto L47;
        UplinkFileEntity r12 = (UplinkFileEntity) ListProtector.get(r11, 0);
        if (r12 == null) goto L47;
        ExpiredInfo r13 = r12.getExpiredInfo();
        if (r13 == null) goto L47;
        Long r14 = r13.getExpireTime();
        if (r14 == null) goto L47;
        long r15 = r14.longValue();
    L48:
        long r16 = r15 - (System.currentTimeMillis() / ((long) 1000));
        if (r16 < 86400) goto L52;
        String r17 = MathKt.roundToInt(r16 / 86400.0f) + " 天";
    L58:
        String r18 = AppHost.a.getApplication().getString(2131908347, new Object[]{r17});
        ListProtector.add(r56, r3, new xc8.l(b0.j(new Message(r10.getConversationId(), null, null, 0, 21, null, 1002, false, null, r18, null, null, null, null, null, r10.getMessageId() + "-time-stamp", r10.getLocalIndex() + 1, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, r44, null, null, null, -98898, 29, null), 12)));
        goto L59
    L52:
        if (r16 < 3600) goto L55;
        r17 = MathKt.roundToInt(r16 / 3600.0f) + " 小时";
        goto L58
    L55:
        if (r16 < 60) goto L57;
        r17 = MathKt.roundToInt(r16 / 60.0f) + " 分钟";
        goto L58
    L57:
        r17 = "1 分钟";
    L47:
        r15 = Long.MAX_VALUE;
        goto L48
    L26:
        if (r7.isEmpty() == true) goto L29;
        r8 = false;
        goto L30
    L18:
        if (r3 >= r56.size()) goto L20;
        r2 = true;
    L59:
        return r56;
    L8:
        if (hp8.a.b(r4.getMessage()) == true) goto L10;
        r5 = true;
        goto L11
    L14:
        r3 = -1;
        goto L15
    }
}
