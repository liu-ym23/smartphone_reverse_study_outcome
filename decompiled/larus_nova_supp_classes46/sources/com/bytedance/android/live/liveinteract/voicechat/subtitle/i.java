package com.bytedance.android.live.liveinteract.voicechat.subtitle;

import com.bytedance.android.livesdk.chatroom.model.interact.SubtitleEventType;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import zg1.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i<T> implements Consumer {
    public final /* synthetic */ LinkmicSubtitleBusinessWidget a;

    public i(LinkmicSubtitleBusinessWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r11) {
        i1 r12 = (i1) r11;
        if (r12 == null) goto L54;
        LinkmicSubtitleBusinessWidget r0 = this.a;
        boolean r13 = r12.b;
        int r1 = LinkmicSubtitleBusinessWidget.x;
        if (r0.isAnchor() == false) goto L13;
        LinkmicSubtitleBusinessContext r2 = r0.e;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L11:
        if (((LinkmicSubtitleStatus) r2.getStatus().getValue()) != LinkmicSubtitleStatus.OPEN) goto L13;
    L22:
        boolean r3 = true;
        if (r13 == false) goto L31;
        s r4 = t.a;
        if (Intrinsics.areEqual(r4.d.get("key_board"), Boolean.FALSE) == false) goto L49;
        nj0.f r5 = LinkmicSubtitleUIContext.Companion.a();
        if (r5 == null) goto L49;
        if (r5.J9() != true) goto L49;
        r4.d.put("key_board", Boolean.TRUE);
        r4.c.put("key_board", Long.valueOf(System.currentTimeMillis()));
    L49:
        r0.h.put("keybroad", Boolean.valueOf(r13));
        if (r0.Kq() == false) goto L52;
        JsonObject r6 = new JsonObject();
        r6.addProperty("hide", Boolean.valueOf(r13));
        r6.addProperty("type", Integer.valueOf(SubtitleEventType.HIDE.ordinal()));
        r0.Yq(r6);
    L52:
        r0.Eq();
        return;
    L31:
        s r7 = t.a;
        if (Intrinsics.areEqual(r7.d.get("key_board"), Boolean.TRUE) == false) goto L49;
        if (t.a("key_board") == 0) goto L49;
        r7.d.put("key_board", Boolean.FALSE);
        t.f("key_board");
        int r8 = nd0.g.a;
        LinkmicSubtitleBusinessContext r9 = r0.e;
        if (r9 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L39:
        if (((LinkmicSubtitleStatus) r9.getStatus().getValue()) != LinkmicSubtitleStatus.OPEN) goto L41;
        boolean r10 = true;
    L42:
        nj0.f r14 = LinkmicSubtitleUIContext.Companion.a();
        if (r14 != null) goto L45;
    L47:
        r3 = false;
    L48:
        nd0.g.b(r10, r3, String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - 0)), "key_board");
        goto L49
    L45:
        if (r14.J9() != true) goto L47;
    L41:
        r10 = false;
    L13:
        if (r0.isAnchor() == true) goto L49;
        LinkmicSubtitleBusinessContext.Companion.getClass();
        if (LinkmicSubtitleBusinessContext.a.c() == false) goto L49;
        LinkmicSubtitleBusinessContext r15 = r0.e;
        if (r15 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mDataContext");
    L20:
        if (((LinkmicSubtitleStatus) r15.getStatus().getValue()) != LinkmicSubtitleStatus.OPEN) goto L49;
        int r16 = g0.a;
        goto L22
    }
}
