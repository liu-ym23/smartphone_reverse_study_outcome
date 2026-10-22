package com.bytedance.android.livesdk.interactivity.textmessage.render;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.message.m4;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.config.cl0;
import com.bytedance.android.livesdk.interactivity.api.entity.PublicScreenRichTextUtilsKt;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.PublicScreenAutoTestUtil;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.g;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.h;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.i;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.x;
import com.bytedance.android.livesdk.interactivity.service.textrender.utils.UserDslBadgeUtils;
import com.bytedance.android.livesdk.message.model.ac;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import gd0.n;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class TextMessageRichContentHelper {
    public final List<com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.a> a;
    public final Lazy b;
    public final Lazy c;
    public final boolean d;
    public final boolean e;
    public final e52.a f;

    public final Pair<tb2.d, i> a(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r18) {
        yb2.a r2 = b(r18);
        boolean r4 = false;
        i r3 = new i(0);
        va r5 = r18.b;
        if (r5 != null) goto L6;
    L14:
        Text r6 = null;
    L16:
        if (r6 == null) goto L18;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.a.getClass();
        x r9 = r.b;
        Intrinsics.checkNotNullParameter(r6, "text");
        tb2.d r7 = r.a(r6, r2);
        g.a(r7, r3);
    L30:
        if (r7 != null) goto L32;
        r7 = new tb2.d();
    L32:
        r7.b = r2;
        r7.e(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(String.valueOf(8206)));
        int r10 = h.c;
        Intrinsics.checkNotNullParameter(r18, "message");
        Intrinsics.checkNotNullParameter(r7, "text");
        if ((r18 instanceof com.bytedance.android.livesdk.interactivity.textmessage.model.d) == true) goto L36;
    L42:
        r7.a(PublicScreenRichTextUtilsKt.c(r18.v(), r2));
        b r8 = (b) this.b.getValue();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r18, "message");
        Intrinsics.checkNotNullParameter(r7, "renderText");
        o r11 = r8.f;
        T r13 = r18.b;
        boolean r14 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.h.a;
        if (r11 == null) goto L45;
        Boolean r15 = r11.isPortraitInteraction();
    L46:
        Boolean r16 = Boolean.TRUE;
        boolean r17 = Intrinsics.areEqual(r15, r16);
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.h.a(r11) == false) goto L52;
        if (r17 == false) goto L52;
        if ((r13 instanceof m4) == false) goto L52;
        boolean r19 = true;
    L53:
        if (r19 == false) goto L84;
        com.bytedance.android.live.base.model.data.b r20 = r18.l();
        long r110 = 0;
        if (r20 == null) goto L57;
        long r111 = r20.a();
    L59:
        if (r111 <= 0) goto L84;
        com.bytedance.android.live.base.model.data.b r21 = r18.l();
        if (r21 != null) goto L63;
    L65:
        boolean r23 = false;
    L66:
        boolean r112 = r18.A();
        r7.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f("   "));
        if (r23 == false) goto L69;
        int r113 = r8.d;
    L70:
        r7.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.a(r113));
        r7.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(" "));
        com.bytedance.android.live.base.model.data.b r114 = r18.l();
        if (r114 == null) goto L73;
        r110 = r114.a();
    L73:
        String r115 = "message";
        if (r110 >= r8.a) goto L76;
        if (r112 == true) goto L76;
    L85:
        final e r24 = (e) this.c.getValue();
        r24.getClass();
        Intrinsics.checkNotNullParameter(r18, r115);
        Intrinsics.checkNotNullParameter(r7, "text");
        Function0<Boolean> r25 = new TopAggregateChatMsgProcessor$process$1(r24);
        int r26 = com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.o.a;
        Intrinsics.checkNotNullParameter(r25, "predicate");
        if (((Boolean) r25.invoke()).booleanValue() == false) goto L122;
        ac r27 = r18.b;
        if ((r27 instanceof ac) == false) goto L122;
        if (r27 == null) goto L121;
        ac r28 = r27;
        IBaseUser r29 = r28.getUser();
        if (r29 == null) goto L122;
        String r30 = r28.getContent();
        if (r30 == null) goto L122;
        o r31 = r24.a;
        if (r31 == null) goto L100;
        Boolean r33 = r31.isAnchor();
    L101:
        r7.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.h(r29, null, false, Intrinsics.areEqual(r33, r16)).setClickAction(new d(r29)));
        int r34 = ColorProtector.parseColor("#B2FFFFFF");
        StringBuilder r35 = new StringBuilder("等");
        if (r28.getCount() <= r28.getMaxCount()) goto L104;
        r4 = true;
    L104:
        if (r4 == false) goto L106;
        ac r36 = r28;
    L107:
        if (r36 == null) goto L110;
        StringBuilder r116 = new StringBuilder();
        r116.append(r36.getMaxCount());
        r116.append('+');
        String r37 = r116.toString();
        if (r37 == null) goto L110;
    L111:
        r35.append(r37);
        r35.append("人说 ");
        r7.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.e(r34, r35.toString()));
        r7.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.e(ColorProtector.parseColor("#FFFFFFFF"), r30));
        if ((!r28.M1()) == false) goto L114;
        tb2.d r38 = r7;
    L115:
        if (r38 == null) goto L122;
        r38.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.f(" "));
        tb2.c r39 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.a(2131251377);
        if (((Boolean) cl0.a.getValue()).booleanValue() == false) goto L119;
        r39.setVerticalOffset(-2);
    L119:
        Unit r40 = Unit.INSTANCE;
        r38.c(r39.setClickAction(f.a));
        goto L122
    L114:
        r38 = null;
    L110:
        r37 = String.valueOf(r28.getCount());
        goto L111
    L106:
        r36 = null;
        goto L107
    L100:
        r33 = null;
        goto L101
    L121:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.message.model.ITopAggregateChatMessage");
    L122:
        Iterator<T> r41 = this.a.iterator();
    L124:
        if (r41.hasNext() == false) goto L127;
        ((com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.a) r41.next()).a(r7, r18);
        goto L124
    L127:
        return new Pair(r7, r3);
    L76:
        if (r23 == false) goto L78;
        int r43 = r8.b;
    L79:
        com.bytedance.android.live.base.model.data.b r44 = r18.l();
        if (r44 == null) goto L82;
        Long r45 = Long.valueOf(r44.a());
    L83:
        r7.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.e(r43, String.valueOf(r45)));
        goto L85
    L82:
        r45 = null;
        goto L83
    L78:
        r43 = r8.c;
        goto L79
    L69:
        r113 = r8.e;
        goto L70
    L63:
        if (r21.e() != true) goto L65;
        r23 = true;
        goto L66
    L57:
        r111 = 0;
    L84:
        r115 = "message";
    L52:
        r19 = false;
        goto L53
    L45:
        r15 = null;
        goto L46
    L36:
        if (((com.bytedance.android.livesdk.interactivity.api.settings.config.c) ec2.b.a.getValue()).a() == false) goto L42;
        com.bytedance.android.livesdk.interactivity.textmessage.model.d r117 = (com.bytedance.android.livesdk.interactivity.textmessage.model.d) r18;
        if (r117.b.getGiftImage() == null) goto L42;
        r7.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.b(" . ", r117.b.getGiftImage(), r10, r10));
        goto L42
    L18:
        r7 = r18.w();
        if (r7 == null) goto L29;
        boolean r46 = this.d;
        boolean r118 = this.e;
        Intrinsics.checkNotNullParameter(r18, "message");
        Intrinsics.checkNotNullParameter(r7, "text");
        if (r18.l != null) goto L23;
    L25:
        List<tb2.c> r47 = com.bytedance.android.livesdk.interactivity.service.textrender.utils.d.e(r18.x(), r46, r118);
    L27:
        if (CollectionUtils.isEmpty(r47) == true) goto L30;
        r7.d(r47);
        g.b(r47, r3);
        goto L30
    L23:
        if (r18.d() == false) goto L25;
        r47 = UserDslBadgeUtils.b(UserDslBadgeUtils.f(r18.l));
        goto L27
    L29:
        r7 = null;
        goto L30
    L6:
        if (r5.supportDisplayText() == false) goto L14;
        if ((r5 instanceof va) == false) goto L11;
        r6 = r5.F1();
        goto L16
    L11:
        m0 r48 = r5.getBaseMessage();
        if (r48 == null) goto L14;
        r6 = r48.getDisplayText();
        goto L16
    }

    public final yb2.a b(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r4) {
        e52.a r0 = this.f;
        if (r0 != null) goto L5;
        yb2.a r1 = r4.j();
    L10:
        boolean r5 = r4.e;
        n r2 = k.f(n.class);
        if (r2 != null) goto L13;
    L15:
        boolean r3 = false;
    L16:
        if (r5 == true) goto L18;
        if (r3 == true) goto L18;
    L19:
        return r1;
    L18:
        r1.k = true;
        goto L19
    L13:
        if (r2.isAudienceLinkEngineOn() != true) goto L15;
        r3 = true;
        goto L16
    L5:
        int r6 = l.a;
        Intrinsics.checkNotNullParameter(r0, "textMessageConfig");
        Intrinsics.checkNotNullParameter(r4, "message");
        if (l.d() == false) goto L8;
        n42.a r7 = r0.h();
    L9:
        r7.getClass();
        r1 = r4.j();
        goto L10
    L8:
        r7 = r0.d();
        goto L9
    }

    public TextMessageRichContentHelper(boolean r4, boolean r5, e52.a r6) {
        this.d = r4;
        this.e = r5;
        this.f = r6;
        if (v.a() == false) goto L7;
        boolean r7 = PublicScreenAutoTestUtil.a;
        if (PublicScreenAutoTestUtil.a == false) goto L7;
        List<com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.a> r8 = CollectionsKt.listOf(new com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.a[]{new w42.c(), new w42.d(), new w42.b(r5)});
    L8:
        this.a = r8;
        this.b = LazyKt.lazy(TextMessageRichContentHelper$chatLikeProcessor$2.INSTANCE);
        this.c = LazyKt.lazy(TextMessageRichContentHelper$topAggregateChatMsgProcessor$2.INSTANCE);
        return;
    L7:
        r8 = CollectionsKt.listOf(new com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.a[]{new w42.c(), new w42.b(r5)});
        goto L8
    }
}
