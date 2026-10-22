package com.bytedance.android.live.anchormodelink.linkroom;

import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import jc1.k;
import kotlin.jvm.functions.Function0;
import m00.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements rj0.a {
    public final /* synthetic */ e a;
    public final /* synthetic */ Function0 b;
    public final /* synthetic */ Function0 c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ Object f;

    public static final class a implements g.a {
        public a() {
        }
    }

    public final void c() {
    }

    public final boolean a() {
        if (this.f == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean b() {
        if (this.f != null) goto L5;
        return true;
    L5:
        return false;
    }

    public final vc0.a getSurfaceView() {
        Object r0 = this.f;
        if (r0 != null) goto L5;
        a r8 = new a();
        g r1 = ((IMiddlewareBroadcastService) k.n(IMiddlewareBroadcastService.class)).createVideoTalkView(this.a.d, "", true, false, false, r8);
        if (r1 == null) goto L9;
        r1.h();
        return new vc0.a(r1);
    L9:
        return null;
    L5:
        return new vc0.a(r0);
    }

    public final void onCancel() {
        this.c.invoke();
    }

    public final void onConfirm() {
        this.b.invoke();
    }

    public final String getCancelText() {
        return this.e;
    }

    public final String getConfirmText() {
        return this.d;
    }

    public d(e r1, Function0 r2, Function0 r3, String r4, String r5, Object r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
