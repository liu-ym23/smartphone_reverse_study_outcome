package gf0;

import android.util.Log;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarContext;
import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarWidget;
import com.bytedance.android.live.liveinteract.hamlet.model.l;
import com.bytedance.android.live.liveinteract.hamlet.model.n;
import com.bytedance.android.live.liveinteract.hamlet.model.o;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import gd0.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements d {
    public long a;
    public boolean b;
    public final HamletAvatarContext c;
    public final a d;

    @Override // gf0.d
    public final void release() {
        this.a = -1;
        this.b = false;
    }

    @Override // gf0.d
    public final void a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "sei");
        n r11 = (n) GsonHelper.get().fromJson(r10, n.class);     // Catch: Exception -> L83
        if (r11 == null) goto L15;
        Long r2 = r11.c();     // Catch: Exception -> L83
        if (r2 == null) goto L15;
        long r3 = r2.longValue();     // Catch: Exception -> L83
        if (r3 == 0) goto L15;
        if (this.a == r3) goto L15;
        this.a = r3;     // Catch: Exception -> L83
        this.d.c(System.currentTimeMillis() - r3);     // Catch: Exception -> L83
        if (this.d.a() == false) goto L15;
        this.d.b();     // Catch: Exception -> L83
    L15:
        if (r11 == null) goto L56;
        Integer r4 = r11.b();     // Catch: Exception -> L83
        if (r4 == null) goto L56;
        int r5 = r4.intValue();     // Catch: Exception -> L83
        int r6 = 1;
        if (r5 <= 0) goto L21;
        boolean r7 = true;
    L22:
        HamletAvatarContext r8 = this.c;     // Catch: Exception -> L83
        if (r8 == null) goto L28;
        m<Boolean> r9 = r8.isAvatarRending();     // Catch: Exception -> L83
        if (r9 == null) goto L28;
        if (((Boolean) r9.getValue()).booleanValue() != r7) goto L28;
    L41:
        if (this.b == true) goto L50;
        HamletAvatarContext r1 = HamletAvatarContext.Companion.getContext();     // Catch: Exception -> L83
        if (r1 == null) goto L49;
        j<g> r12 = r1.getHamletAvatarService();     // Catch: Exception -> L83
        if (r12 == null) goto L49;
        g r13 = (g) r12.getValue();     // Catch: Exception -> L83
        if (r13 == null) goto L49;
        r13.Zf(r7, 0);     // Catch: Exception -> L83
    L49:
        this.b = true;     // Catch: Exception -> L83
    L50:
        if (r5 > 0) goto L53;
        r6 = 0;
    L53:
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();     // Catch: Exception -> L83
        com.bytedance.android.live.liveinteract.voicechat.d r14 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();     // Catch: Exception -> L83
        if (r14 == null) goto L56;
        r14.Mi(r6);     // Catch: Exception -> L83
    L28:
        HamletAvatarContext r15 = this.c;     // Catch: Exception -> L83
        if (r15 == null) goto L33;
        m<Boolean> r16 = r15.isAvatarRending();     // Catch: Exception -> L83
        if (r16 == null) goto L33;
        r16.setValue(Boolean.valueOf(r7));     // Catch: Exception -> L83
    L33:
        StringBuilder r17 = new StringBuilder("onXplaySeiProcess: sei rending value: ");     // Catch: Exception -> L83
        HamletAvatarContext r18 = this.c;     // Catch: Exception -> L83
        if (r18 == null) goto L38;
        m<Boolean> r19 = r18.isAvatarRending();     // Catch: Exception -> L83
        if (r19 == null) goto L38;
        Boolean r20 = (Boolean) r19.getValue();     // Catch: Exception -> L83
    L39:
        r17.append(r20);     // Catch: Exception -> L83
        ALogger.d("HamletAvatar", r17.toString());     // Catch: Exception -> L83
    L38:
        r20 = null;
        goto L39
    L21:
        r7 = false;
    L56:
        if (r11 == null) goto L87;
        String r21 = r11.a();     // Catch: Exception -> L83
        if (r21 == null) goto L88;
        l r22 = (l) GsonHelper.get().fromJson(r21, l.class);     // Catch: Exception -> L83
        HamletAvatarContext r23 = this.c;     // Catch: Exception -> L83
        if (r23 == null) goto L64;
        com.bytedance.live.datacontext.n<l> r24 = r23.getChestPosition();     // Catch: Exception -> L83
        if (r24 == null) goto L64;
        l r25 = (l) r24.getValue();     // Catch: Exception -> L83
    L65:
        Integer r110 = r11.b();     // Catch: Exception -> L83
        if (r110 != null) goto L69;
    L76:
        if (o.a(r25, r22) == true) goto L92;
        HamletAvatarContext r111 = this.c;     // Catch: Exception -> L83
        if (r111 == null) goto L93;
        com.bytedance.live.datacontext.n<l> r112 = r111.getChestPosition();     // Catch: Exception -> L83
        if (r112 == null) goto L94;
        r112.setValue(r22);     // Catch: Exception -> L83
        return;
    L94:
        return;
    L93:
        return;
    L92:
        return;
    L69:
        if (r110.intValue() != 0) goto L76;
        HamletAvatarContext r113 = this.c;     // Catch: Exception -> L83
        if (r113 == null) goto L89;
        com.bytedance.live.datacontext.n<l> r114 = r113.getChestPosition();     // Catch: Exception -> L83
        if (r114 == null) goto L90;
        r114.setValue(null);     // Catch: Exception -> L83
        return;
    L90:
        return;
    L89:
        return;
    L64:
        r25 = null;
        goto L65
    L88:
        return;
    L87:
        return;
    L83:
        e = move-exception;
        ALogger.e("HamletAvatar", "onXplaySeiProcess parse exception=" + Log.getStackTraceString(e));
    }

    public b(HamletAvatarContext r2, HamletAvatarWidget.d r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.c = r2;
        this.d = r3;
    }
}
