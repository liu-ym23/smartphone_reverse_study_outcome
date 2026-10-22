package com.bytedance.android.live.effect.sticker.chain;

import android.content.Context;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.LiveEffectScene;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import java.util.LinkedList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l {
    public final com.bytedance.android.live.effect.base.e a;
    public boolean b;
    public final Context c;
    public final LiveEffectContextFactoryDelegate$Type d;
    public final LiveEffectScene e;
    public final String f;
    public Sticker g;
    public final Map<String, String> h;
    public final LinkedList<m> i;

    public final void a() {
        if (this.i.isEmpty() == false) goto L6;
        this.b = false;
    L6:
        if (this.b == true) goto L8;
        return;
    L8:
        this.i.remove().a(this);
    }

    public final Context getContext() {
        return this.c;
    }

    public final LiveEffectContextFactoryDelegate$Type getType() {
        return this.d;
    }

    public l(Context r2, LiveEffectContextFactoryDelegate$Type r3, LiveEffectScene r4, String r5, Sticker r6, Map<String, String> r7, LinkedList<m> r8) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "type");
        Intrinsics.checkNotNullParameter(r4, "scene");
        Intrinsics.checkNotNullParameter(r5, "panel");
        Intrinsics.checkNotNullParameter(r6, "sticker");
        Intrinsics.checkNotNullParameter(r7, "extra");
        Intrinsics.checkNotNullParameter(r8, "interceptors");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r8;
        this.a = new com.bytedance.android.live.effect.base.e();
        this.b = true;
    }
}
