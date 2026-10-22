package com.bytedance.android.livesdk.interactivity.square.plugin;

import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessageBinderType;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.config.MessagePluginType;
import com.bytedance.android.livesdk.interactivity.api.publicscreenV2.square.f;
import com.bytedance.android.livesdk.interactivity.square.common.j;
import com.bytedance.android.livesdk.interactivity.square.common.k;
import com.bytedance.android.livesdk.interactivity.square.common.l;
import h52.c;
import h52.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements h52.a<d, j> {
    public final MessagePluginType a;
    public final hc2.a b;
    public final k c;
    public final SquareModelSpanClickListener d;
    public final l e;

    @Override // h52.a
    public final void onLoad() {
    }

    @Override // h52.a
    public final void onUnload() {
    }

    @Override // h52.a
    public final SquareModelSpanClickListener b() {
        return this.d;
    }

    @Override // h52.a
    public final k c() {
        return this.c;
    }

    @Override // h52.a
    public final MessagePluginType getPluginType() {
        return this.a;
    }

    public a(k52.a r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        this.a = MessagePluginType.SquareChatMessagePlugin;
        this.b = new hc2.a();
        this.c = new k(MessageBinderType.CommonMessageModelBinder, r3);
        this.d = new SquareModelSpanClickListener();
        this.e = new l();
    }

    @Override // h52.a
    public final boolean a(d r2) {
        Intrinsics.checkNotNullParameter(r2, "origin");
        return r2 instanceof f;
    }

    @Override // h52.a
    public final gc2.a d(d r11) {
        Intrinsics.checkNotNullParameter(r11, "origin");
        hc2.a r1 = this.b;
        MessageBinderType r5 = this.c.a;
        l r2 = this.e;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r11, "origin");
        Intrinsics.checkNotNullParameter(r5, "binderType");
        Intrinsics.checkNotNullParameter(r2, "generator");
        gc2.a r9 = new gc2.a(r11.d(), r5, r11.b(), r11.e());
        Intrinsics.checkNotNullParameter(r9, "model");
        Intrinsics.checkNotNullParameter(r11, "origin");
        Intrinsics.checkNotNullParameter(r2, "generator");
        r9.g = r11.c();
        r9.d = r11.h();
        r9.b = r11.a();
        r9.c = r11.g();
        tb2.d r0 = r2.a(r9);
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        c.a r3 = new c.a(r0);
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r9.i = r3;
        r9.e = r11.f();
        if ((r11 instanceof f) == true) goto L5;
        r11 = null;
    L5:
        f r13 = (f) r11;
        if (r13 == null) goto L9;
        r9.n = r13.j();
        r9.h = r13.i();
        r9.a = r13.a;
    L9:
        return r9;
    }
}
