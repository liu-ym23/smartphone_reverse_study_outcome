package com.bytedance.android.livesdk.interactivity.api.entity;

import android.text.style.ImageSpan;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.android.live.base.model.message.j4;
import com.bytedance.android.live.base.model.message.x3;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.x;
import com.bytedance.android.livesdk.interactivity.textmessage.render.TextMessageSpanAction;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class PublicScreenRichTextUtilsKt {
    public static final Function1<tb2.d, tb2.d> c(final IPublicAreaCommon r1, final yb2.a r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        return new PublicScreenRichTextUtilsKt$suffixAppender$1(r1, r2);
    }

    public static final tb2.d a(x3 r6, yb2.a r7, boolean r8, TextMessageSpanAction r9) {
        Intrinsics.checkNotNullParameter(r6, "message");
        Intrinsics.checkNotNullParameter(r7, "config");
        Intrinsics.checkNotNullParameter(r9, "action");
        tb2.d r0 = new tb2.d();
        a5 r10 = r6.getRichText();
        if (r10 == null) goto L5;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        x r1 = r.b;
        Intrinsics.checkNotNullParameter(r10, "text");
        r0 = r.a(r10, r7);
    L5:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r11 = null;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> r13 = com.bytedance.android.livesdk.interactivity.api.publicscreen.m.a(null);
        if (r13 == null) goto L8;
        r11 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.l) r13.getValue();
    L8:
        if (r11 == null) goto L14;
        e52.a r14 = r11.getTextConfig();
        if (r14 == null) goto L14;
        n42.a r15 = r14.a();
        if (r15 == null) goto L14;
        int r16 = r15.a;
    L15:
        Iterator<tb2.c> r17 = r0.a.iterator();
    L17:
        if (r17.hasNext() == false) goto L36;
        tb2.c r2 = r17.next();
        ITextPieceImage r3 = r2.getImageValue();
        if (r3 == null) goto L30;
        int r4 = (int) (r16 * r3.getScalingRate());
        if (r3.getScalingRate() <= 0.0f) goto L23;
        r3.setScaleType(ITextPieceImage.ScaleType.FIT_Y);
        r3.setHeight(r4);
    L23:
        r3.setExtraOpt(ITextPieceImage.ExtraOpt.OTHER);
        py.k r5 = r3.getImageModel();
        if (r5 == null) goto L30;
        py.k.b r18 = r5.getImageContent();
        if (r18 == null) goto L30;
        String r19 = r18.getName();
        if (r19 == null) goto L30;
        r2.setText(r19);
    L30:
        if (r8 == false) goto L17;
        if (r2.getType() == PieceType.STRING.getPieceType()) goto L35;
        if (r2.getType() != PieceType.IMAGE.getPieceType()) goto L17;
    L35:
        r2.setClickAction(r9);
        goto L17
    L36:
        return r0;
    L14:
        r16 = 0;
        goto L15
    }

    public static final tb2.d b(tb2.d r10, x3 r11, yb2.a r13, boolean r14, TextMessageSpanAction r15) {
        Intrinsics.checkNotNullParameter(r10, "renderText");
        Intrinsics.checkNotNullParameter(r11, "message");
        Intrinsics.checkNotNullParameter(r13, "config");
        Intrinsics.checkNotNullParameter(r15, "action");
        Intrinsics.checkNotNullParameter(r11, "message");
        if (r11.getRichText() == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        r10.b(a(r11, r13, r14, r15).a);
        return r10;
    L9:
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.publicscreen.l> r1 = com.bytedance.android.livesdk.interactivity.api.publicscreen.m.a(null);
        if (r1 == null) goto L12;
        com.bytedance.android.livesdk.interactivity.api.publicscreen.l r2 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.l) r1.getValue();
    L13:
        if (r2 == null) goto L19;
        e52.a r3 = r2.getTextConfig();
        if (r3 == null) goto L19;
        n42.a r4 = r3.a();
        if (r4 == null) goto L19;
        int r5 = r4.a;
    L20:
        j4 r16 = r11.getSelfFakeRichContent();
        if ((r16 instanceof p) == true) goto L23;
        r16 = null;
    L23:
        p r17 = (p) r16;
        if (r17 == null) goto L107;
        String r6 = r17.a;
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r17.b.iterator();
    L27:
        if (r8.hasNext() == false) goto L31;
        com.bytedance.android.livesdk.event.n r9 = (com.bytedance.android.livesdk.event.n) r8.next();
        if (r9 == null) goto L27;
        r7.add(r9);
        goto L27
    L31:
        Iterator<T> r18 = r17.c.iterator();
    L33:
        if (r18.hasNext() == false) goto L37;
        com.bytedance.android.livesdk.event.r r19 = (com.bytedance.android.livesdk.event.r) r18.next();
        if (r19 == null) goto L33;
        r7.add(r19);
        goto L33
    L37:
        Iterator r110 = r7.iterator();
        int r20 = 0;
    L39:
        if (r110.hasNext() == false) goto L101;
        com.bytedance.android.livesdk.event.n r21 = (com.bytedance.android.livesdk.event.l) r110.next();
        if (r21.getStart() <= r20) goto L52;
        int r23 = r21.getStart();
        if (r6 == null) goto L50;
        tb2.c r24 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(r6.substring(r20, r23));
        if (r14 == false) goto L47;
        TextMessageSpanAction r25 = r15;
    L48:
        r10.c(r24.setClickAction(r25));
        goto L52
    L47:
        r25 = null;
        goto L48
    L50:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L52:
        if ((r21 instanceof com.bytedance.android.livesdk.event.n) == false) goto L66;
        com.bytedance.android.livesdk.event.n r26 = r21;
        ImageSpan r27 = r26.f;
        if ((r27 instanceof com.bytedance.android.livesdk.interactivity.api.e) == false) goto L60;
        float r28 = r5 * r26.h;
        String r29 = r26.c;
        py.k r30 = r26.g;
        tb2.c r31 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.b(r29, r30, (int) ((r30.getWidth() / r26.g.getHeight()) * r28), (int) r28);
        if (r14 == false) goto L58;
        TextMessageSpanAction r33 = r15;
    L59:
        r10.c(r31.setClickAction(r33));
    L99:
        r20 = r21.getStart() + r21.getLength();
        goto L39
    L58:
        r33 = null;
        goto L59
    L60:
        float r34 = r5 * r26.h;
        tb2.c r35 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.b(r26.c, r26.g, (int) ((r27.getDrawable().getIntrinsicWidth() / r26.f.getDrawable().getIntrinsicHeight()) * r34), (int) r34);
        if (r14 == false) goto L63;
        TextMessageSpanAction r36 = r15;
    L64:
        r10.c(r35.setClickAction(r36));
        goto L99
    L63:
        r36 = null;
        goto L64
    L66:
        if ((r21 instanceof com.bytedance.android.livesdk.event.r) == false) goto L99;
        IRoomContextService r37 = jc1.k.f(IRoomContextService.class);
        if (r37 == null) goto L72;
        com.bytedance.android.livesdk.chatroom.o r38 = r37.getRoomDataContext(null, 0);
        if (r38 == null) goto L72;
        com.bytedance.live.datacontext.m r39 = r38.getRoom();
    L73:
        if (r39 == null) goto L94;
        IRoom r40 = (IRoom) r39.getValue();
        if (r40 == null) goto L94;
        String r41 = r40.getAnchorId();
        if (r41 == null) goto L94;
        if (r41.length() <= 0) goto L81;
        boolean r43 = true;
    L82:
        if (r43 != true) goto L94;
        IBaseUser r44 = ((com.bytedance.android.livesdk.event.r) r21).e;
        if (r44 == null) goto L86;
        String r45 = r44.getIdString();
    L87:
        IRoom r46 = (IRoom) r39.getValue();
        if (r46 == null) goto L90;
        String r47 = r46.getAnchorId();
    L92:
        if (Intrinsics.areEqual(r45, r47) == false) goto L94;
        boolean r48 = true;
    L95:
        com.bytedance.android.livesdk.event.r r49 = (com.bytedance.android.livesdk.event.r) r21;
        IBaseUser r50 = r49.e;
        tb2.c r51 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.h(r50, "@".concat(gm2.q.a(r50, r48)), false, r48);
        IBaseUser r53 = r49.e;
        if (r53 == null) goto L98;
        r51.setClickAction(new m(r53));
    L98:
        Unit r54 = Unit.INSTANCE;
        r10.c(r51);
        goto L99
    L90:
        r47 = null;
        goto L92
    L86:
        r45 = null;
        goto L87
    L81:
        r43 = false;
    L94:
        r48 = false;
    L72:
        r39 = null;
        goto L73
    L101:
        if (r20 >= (r6.length() - ((Integer) r52.o.a.getValue()).intValue())) goto L107;
        tb2.c r111 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(r6.substring(r20));
        if (r14 == true) goto L106;
        r15 = null;
    L106:
        r10.c(r111.setClickAction(r15));
    L107:
        return r10;
    L19:
        r5 = 0;
        goto L20
    L12:
        r2 = null;
        goto L13
    L5:
        r0 = false;
        goto L6
    }
}
