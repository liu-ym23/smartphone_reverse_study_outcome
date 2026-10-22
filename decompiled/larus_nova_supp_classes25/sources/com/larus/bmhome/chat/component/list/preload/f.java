package com.larus.bmhome.chat.component.list.preload;

import android.content.Context;
import android.os.Bundle;
import com.larus.bmhome.ability.FloatChatWindowState;
import com.larus.bmhome.social.userchat.model.c0;
import com.larus.im.bean.bot.BotModel;
import de8.c;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import td8.d;
import va8.k;
import va8.m0;
import va8.p0;
import wc9.e;
import xc8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f implements d {
    public final /* synthetic */ e a;
    public final /* synthetic */ c b;
    public final /* synthetic */ ChatListPreloadComponent c;

    @Override // td8.d
    public final boolean E8() {
        return false;
    }

    @Override // td8.d
    public final BotModel a() {
        return null;
    }

    @Override // td8.d
    public final boolean e() {
        return false;
    }

    @Override // td8.d
    public final Map<Object, Object> extraInfo() {
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("load_scene", "preload")});
    }

    @Override // td8.d
    public final long i() {
        return Long.MAX_VALUE;
    }

    @Override // td8.d
    public final boolean k() {
        return false;
    }

    @Override // td8.d
    public final c0 l() {
        return null;
    }

    @Override // td8.d
    public final b n() {
        return null;
    }

    @Override // td8.d
    public final boolean q() {
        return false;
    }

    @Override // td8.d
    public final boolean Pa() {
        ew8.b r0 = (ew8.b) this.c.j.getValue();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.Pa() != true) goto L7;
        return true;
    }

    @Override // td8.d
    public final long b() {
        return de8.d.a(this.b);
    }

    @Override // td8.d
    public final boolean c() {
        return this.b.C();
    }

    @Override // td8.d
    public final int d() {
        m0 r0 = (m0) this.c.k.getValue();
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.pD();
    }

    @Override // td8.d
    public final p0 f() {
        ew8.b r0 = (ew8.b) this.c.j.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.Je();
    }

    @Override // td8.d
    public final FloatChatWindowState h() {
        k r0 = (k) this.c.i.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getWindowState();
    }

    @Override // td8.d
    public final Context j() {
        return this.c.getContext();
    }

    @Override // td8.d
    public final String m() {
        Bundle r0 = this.b.b;
        if (r0 == null) goto L9;
        String r1 = r0.getString("argPushContentId", "");
        if (r1 != null) goto L8;
        return "";
    L8:
        return r1;
    L9:
        return "";
    }

    @Override // td8.d
    public final long o() {
        return this.b.l();
    }

    @Override // td8.d
    public final String p() {
        e r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.B;
    }

    @Override // td8.d
    public final e g() {
        return this.a;
    }

    public f(e r1, c r2, ChatListPreloadComponent r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
