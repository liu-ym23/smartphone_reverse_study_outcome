package com.larus.uaigc.creation.gallery.providers;

import com.larus.bmhome.utils.c4;
import com.larus.im.bean.message.Message;
import com.larus.utils.o0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.a4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a0 extends ab9.b<sz9.b> {
    public final Lazy n;

    public final JSONObject y() {
        sz9.b r0 = (sz9.b) ((com.larus.gallery.api.t) this).d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.i;
    }

    public final c4 z() {
        sz9.b r0 = (sz9.b) ((com.larus.gallery.api.t) this).d;
        if (r0 == null) goto L7;
        zo8.e r1 = r0.d;
        if (r1 == null) goto L7;
        return r1.b;
    L7:
        return null;
    }

    public a0() {
        this.n = LazyKt.lazy(new z(this));
    }

    public final void A(int r15, String r16, String r17) {
        Intrinsics.checkNotNullParameter(r16, "enterMethod");
        Intrinsics.checkNotNullParameter(r17, "slideStatus");
        sz9.b r2 = (sz9.b) ((com.larus.gallery.api.t) this).d;
        JSONObject r3 = null;
        String r4 = null;
        r4 = null;
        if (r2 == null) goto L5;
        zo8.e r5 = r2.d;
    L6:
        if (r5 == null) goto L64;
        if (r2 == null) goto L13;
        zo8.e r1 = r2.d;
        if (r1 == null) goto L13;
        nr9.g r6 = r1.c;
        if (r6 == null) goto L13;
        String r7 = r6.a;
    L14:
        if (r2 == null) goto L20;
        zo8.e r8 = r2.d;
        if (r8 == null) goto L20;
        c4 r9 = r8.b;
        if (r9 == null) goto L20;
        String r10 = r9.b;
    L21:
        if (r2 == null) goto L27;
        zo8.e r11 = r2.d;
        if (r11 == null) goto L27;
        c4 r12 = r11.b;
        if (r12 == null) goto L27;
        String r13 = r12.a;
    L28:
        if (r2 == null) goto L34;
        zo8.e r14 = r2.d;
        if (r14 == null) goto L34;
        c4 r18 = r14.b;
        if (r18 == null) goto L34;
        String r19 = r18.c;
    L35:
        if (r2 == null) goto L41;
        zo8.e r20 = r2.d;
        if (r20 == null) goto L41;
        c4 r21 = r20.b;
        if (r21 == null) goto L41;
        String r22 = r21.g;
    L42:
        if (r2 == null) goto L48;
        zo8.e r23 = r2.d;
        if (r23 == null) goto L48;
        c4 r24 = r23.b;
        if (r24 == null) goto L48;
        String r25 = r24.j;
    L49:
        if (r2 == null) goto L55;
        zo8.e r110 = r2.d;
        if (r110 == null) goto L55;
        c4 r111 = r110.b;
        if (r111 == null) goto L55;
        Integer r112 = r111.i;
    L56:
        if (r2 == null) goto L62;
        zo8.e r26 = r2.d;
        if (r26 == null) goto L62;
        c4 r27 = r26.b;
        if (r27 == null) goto L62;
        String r113 = r27.h;
    L63:
        a4.h(r7, r10, r13, r16, r19, r22, r25, r112, r113, "bot", 3072);
        return;
    L62:
        r113 = null;
    L55:
        r112 = null;
    L48:
        r25 = null;
    L41:
        r22 = null;
    L34:
        r19 = null;
    L27:
        r13 = null;
    L20:
        r10 = null;
    L13:
        r7 = null;
        goto L14
    L64:
        com.larus.platform.service.o r28 = com.larus.platform.service.o.a;
        JSONObject r29 = y();
        if (r29 == null) goto L120;
        r29.put("enter_method", r16);
        if (o0.d(r17) == false) goto L69;
        r29.put("slide_status", r17);
    L69:
        sz9.b r30 = (sz9.b) ((com.larus.gallery.api.t) this).d;
        if (r30 == null) goto L73;
        String r31 = sz9.d.a(r30);
        if (r31 == null) goto L73;
    L74:
        b0 r32 = (b0) this.n.getValue();
        int r33 = 0;
        if (r32 != null) goto L77;
    L79:
        boolean r34 = false;
    L80:
        String r35 = "1";
        if (r34 == false) goto L83;
        Object r36 = "1";
    L84:
        r29.put("is_template", r36);
        b0 r37 = (b0) this.n.getValue();
        if (r37 != null) goto L87;
    L89:
        boolean r38 = false;
    L90:
        if (r38 == true) goto L93;
        r35 = "0";
    L93:
        r29.put("is_creation", r35);
        sz9.b r39 = (sz9.b) ((com.larus.gallery.api.t) this).d;
        if (r39 == null) goto L101;
        Integer r40 = r39.m;
        if (r40 == null) goto L101;
        if (r40.intValue() != 3) goto L101;
        int r41 = 1;
    L102:
        r29.put("is_replica_gen", r41);
        sz9.b r42 = (sz9.b) ((com.larus.gallery.api.t) this).d;
        if (r42 == null) goto L110;
        Integer r43 = r42.m;
        if (r43 == null) goto L110;
        if (r43.intValue() != 4) goto L110;
        r33 = 1;
    L110:
        r29.put("is_image_edit", r33);
        b0 r44 = (b0) this.n.getValue();
        if (r44 == null) goto L113;
        String r45 = r44.h(r31);
    L114:
        r29.put("creation_public_status", r45);
        sz9.b r46 = (sz9.b) ((com.larus.gallery.api.t) this).d;
        if (r46 == null) goto L119;
        Message r47 = r46.a;
        if (r47 == null) goto L119;
        r4 = r47.getReplyId();
    L119:
        r29.putOpt("reply_id", r4);
        Unit r48 = Unit.INSTANCE;
        r3 = r29;
        goto L120
    L113:
        r45 = null;
    L101:
        r41 = 0;
        goto L102
    L87:
        if (r37.f(r31) != true) goto L89;
        r38 = true;
        goto L90
    L83:
        r36 = "0";
        goto L84
    L77:
        if (r32.f(r31) != true) goto L79;
        r34 = true;
    L73:
        r31 = String.valueOf(r15);
    L120:
        r28.reportEvent("enter_picture_detail", r3);
        return;
    L5:
        r5 = null;
        goto L6
    }
}
