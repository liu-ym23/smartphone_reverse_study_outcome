package vsb;

import android.graphics.Bitmap;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.maintab.export.TabAppInfo;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c extends c0c.b implements rsb.a {
    public final /* synthetic */ rsb.a b;
    public final v c;
    public final com.ss.android.lark.passportc.convention.b<rsb.a> d;

    @Override // rsb.a
    @Deprecated(message = "replace with [getReactionOrEmojiBitmap]")
    public final Bitmap Hb(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        return this.b.Hb(r2, r3);
    }

    @Override // rsb.a
    @Deprecated(message = "replace with [getReactionOrEmojiText]")
    public final String K9(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        return this.b.K9(r2, r3);
    }

    @Override // rsb.a
    public final ConcurrentHashMap<String, qsb.a> Q1() {
        return this.b.Q1();
    }

    @Override // rsb.a
    public final int U9() {
        return this.b.U9();
    }

    @Override // rsb.a
    public final void V8(Set<? extends qsb.a> r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "set");
        this.b.V8(r2, r3);
    }

    @Override // rsb.a
    public final qsb.a Yd(String r2) {
        Intrinsics.checkNotNullParameter(r2, "reactionKey");
        return this.b.Yd(r2);
    }

    @Override // rsb.a
    public final qsb.a b0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "emojiKey");
        return this.b.b0(r2);
    }

    @Override // rsb.a
    public final void c9(rsb.a.InterfaceC0324a r2) {
        this.b.c9(r2);
    }

    @Override // rsb.a
    public final String df(String r2) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        return this.b.df(r2);
    }

    @Override // rsb.a
    public final void f3() {
        this.b.f3();
    }

    @Override // rsb.a
    public final void ge(String r2, boolean r3, IGetDataCallback<Boolean> r4, IGetDataCallback<Boolean> r5) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        this.b.ge(r2, r3, r4, r5);
    }

    @Override // rsb.a
    public final ConcurrentHashMap<String, String> h2() {
        return this.b.h2();
    }

    @Override // rsb.a
    public final boolean i7(String r2) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        return this.b.i7(r2);
    }

    @Override // rsb.a
    /* JADX INFO: renamed from: if */
    public final boolean mo1505if(String r2) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        return this.b.mo1505if(r2);
    }

    @Override // rsb.a
    public final boolean l4(String r2) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        return this.b.l4(r2);
    }

    @Override // rsb.a
    @Deprecated(message = "replace with [requestBitmap(String)]")
    public final void sb(String r2) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        this.b.sb(r2);
    }

    @Override // rsb.a
    public final String ub(String r2) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        return this.b.ub(r2);
    }

    @Override // rsb.a
    public final Bitmap v1(String r2) {
        Intrinsics.checkNotNullParameter(r2, TabAppInfo.IMAGE_JSON_KEY);
        return this.b.v1(r2);
    }

    public c(j r4, v r5) {
        UserSession r1 = r4.b();
        if (r1 != null) goto L5;
        r1 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<rsb.a> r0 = new com.ss.android.lark.passportc.convention.b(k.b(r5.c(r1), rsb.a.class), rsb.a.class);
        Intrinsics.checkNotNullParameter(r4, "passport");
        Intrinsics.checkNotNullParameter(r5, "accessor");
        Intrinsics.checkNotNullParameter(r0, "proxy");
        super(r4);
        this.b = (rsb.a) r0.b();
        this.c = r5;
        this.d = r0;
    }

    public final void pf(g r1, f0c.b r2) {
        Intrinsics.checkNotNullParameter(r2, "toState");
        v r3 = this.c;
        g r4 = r2.a();
        if (r4 == null) goto L6;
        UserSession r5 = r4.b;
        if (r5 == null) goto L6;
    L7:
        rsb.a r6 = (rsb.a) k.b(r3.c(r5), rsb.a.class);
        this.d.e(r6);
        return;
    L6:
        r5 = ContainerConstsKt.a();
        goto L7
    }
}
