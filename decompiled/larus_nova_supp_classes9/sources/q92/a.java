package q92;

import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.q;
import g52.e;
import h52.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements e52.a {
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public int h;
    public boolean i;
    public boolean j;
    public n42.a k;
    public n42.a l;
    public e m;
    public int n;
    public long o;
    public boolean p;
    public boolean q;
    public final float r;
    public k<f<?>> s;
    public k<s> t;
    public k<c> u;
    public com.bytedance.android.livesdk.interactivity.publicscreen.strategy.updater.c v;
    public com.bytedance.android.livesdk.interactivity.publicscreen.strategy.waitbuffer.a w;

    public final String toString() {
        StringBuilder r0 = new StringBuilder("TextMessageConfig{textMessageRenderTextProcessor=");
        k<f<?>> r1 = this.s;
        String r2 = "null";
        if (r1 != null) goto L5;
        String r3 = "null";
    L6:
        r0.append(r3);
        r0.append(", pluginMessageRenderTextProcessor=");
        k<s> r4 = this.t;
        if (r4 != null) goto L9;
        String r5 = "null";
    L10:
        r0.append(r5);
        r0.append(", showLuckyBoxMsg=");
        r0.append(this.a);
        r0.append(", showInteractLegalMsg=");
        r0.append(this.b);
        r0.append(", showShareGuideMsg=");
        r0.append(this.c);
        r0.append(", showOfficialChannelTopMsg=");
        r0.append(this.d);
        r0.append(", enableInteractionMsgRoomFilter=");
        r0.append(this.e);
        r0.append(", enableIntroMsgFilter=");
        r0.append(this.f);
        r0.append(", enableInteractionMsgFoldStrategy=");
        r0.append(this.g);
        r0.append(", enterMsgFoldStrategy=");
        r0.append(this.h);
        r0.append(", enableFloatingList=");
        r0.append(this.i);
        r0.append(", enableLandScapeShowStyle=");
        r0.append(this.j);
        r0.append(", scrollSpeedMsPerInch=");
        r0.append(this.n);
        r0.append(", enableMediaBadge=");
        r0.append(this.p);
        r0.append(", portraitShowStyle=");
        n42.a r6 = this.k;
        if (r6 != null) goto L13;
        String r7 = "null";
    L14:
        r0.append(r7);
        r0.append(", landscapeShowStyle=");
        n42.a r8 = this.l;
        if (r8 == null) goto L18;
        r2 = r8.toString();
    L18:
        r0.append(r2);
        r0.append('}');
        return r0.toString();
    L13:
        r7 = r6.toString();
        goto L14
    L9:
        r5 = r4.getName();
        goto L10
    L5:
        r3 = r1.getName();
        goto L6
    }

    public a() {
        this.a = false;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.i = false;
        this.j = false;
        this.o = 500;
        this.r = q.i();
    }

    @Override // e52.a
    public final n42.a a() {
        return this.k;
    }

    @Override // e52.a
    public final float b() {
        return this.r;
    }

    @Override // e52.a
    public final boolean c() {
        return this.q;
    }

    @Override // e52.a
    public final n42.a d() {
        return this.l;
    }

    @Override // e52.a
    public final k<s> e() {
        return this.t;
    }

    @Override // e52.a
    public final boolean f() {
        return this.j;
    }

    @Override // e52.a
    public final k<f<?>> g() {
        return this.s;
    }

    @Override // e52.a
    public final e getTextConfig() {
        return this.m;
    }

    @Override // e52.a
    public final n42.a h() {
        return this.k;
    }

    @Override // e52.a
    public final k<c> i() {
        return this.u;
    }
}
