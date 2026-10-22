package com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor;

import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.i5;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.h0;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g {
    static {
    }

    @JvmStatic
    public static final void a(tb2.d r9, i r10) {
        Intrinsics.checkNotNullParameter(r9, "renderText");
        IRoomContextService r0 = jc1.k.f(IRoomContextService.class);
        if (r0 == null) goto L13;
        o r1 = IRoomContextService.a.a(r0, null, 0, 3);
        if (r1 == null) goto L13;
        m r2 = r1.getRoom();
        if (r2 == null) goto L13;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L13;
        if (r3.isMediaRoom() != true) goto L13;
        boolean r4 = true;
    L14:
        IRoomContextService r6 = jc1.k.f(IRoomContextService.class);
        if (r6 == null) goto L19;
        o r5 = IRoomContextService.a.a(r6, null, 0, 3);
        if (r5 == null) goto L19;
        Boolean r7 = r5.isAnchor();
    L20:
        boolean r8 = Intrinsics.areEqual(r7, Boolean.TRUE);
        ArrayList r11 = new ArrayList();
        Iterator<T> r13 = r9.a.iterator();
    L22:
        if (r13.hasNext() == false) goto L33;
        tb2.c r14 = (tb2.c) r13.next();
        if (r14.getType() != PieceType.USER.getPieceType()) goto L32;
        i5 r15 = r14.getUserValue();
        if (r15 == null) goto L28;
        IBaseUser r16 = r15.getUser();
    L29:
        List<tb2.c> r17 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.d.e(r16, r4, r8);
        if ((!r17.isEmpty()) == false) goto L32;
        b(r17, r10);
        r14.setBindUserBadgePieceList(r17);
        r11.addAll(r17);
        goto L32
    L28:
        r16 = null;
    L32:
        r11.add(r14);
        goto L22
    L33:
        r9.a.clear();
        r9.b(r11);
        return;
    L19:
        r7 = null;
    L13:
        r4 = false;
        goto L14
    }

    @JvmStatic
    public static final void b(List<tb2.c> r8, i r9) {
        Intrinsics.checkNotNullParameter(r8, "badgeList");
        Iterator<T> r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L44;
        tb2.c r0 = (tb2.c) r10.next();
        ITextPieceImage r1 = r0.getImageValue();
        if (r1 == null) goto L13;
        py.k r2 = r1.getImageModel();
        if (r2 == null) goto L13;
        if (r2.isAnimated() != true) goto L13;
        if (r9 == null) goto L13;
        r9.a = true;
    L13:
        ITextPieceImage r3 = r0.getImageValue();
        Integer r4 = null;
        if (r3 == null) goto L18;
        py.k r5 = r3.getImageModel();
        if (r5 == null) goto L18;
        Integer r6 = r5.getImageType();
    L19:
        if (r6 != null) goto L22;
    L23:
        h0 r7 = r0.getBadge();
        if (r7 != null) goto L26;
    L29:
        ITextPieceImage r11 = r0.getImageValue();
        if (r11 == null) goto L34;
        py.k r13 = r11.getImageModel();
        if (r13 == null) goto L34;
        r4 = r13.getImageType();
    L34:
        if (r4 != null) goto L37;
    L38:
        h0 r14 = r0.getBadge();
        if (r14 == null) goto L4;
        if (r14.a != 8) goto L4;
    L42:
        if (r9 == null) goto L4;
        r9.b = true;
        goto L4
    L37:
        if (r4.intValue() == 34) goto L42;
    L26:
        if (r7.a != 9) goto L29;
    L27:
        if (r9 == null) goto L29;
        r9.c = true;
        goto L29
    L22:
        if (r6.intValue() == 35) goto L27;
    L18:
        r6 = null;
        goto L19
    }
}
