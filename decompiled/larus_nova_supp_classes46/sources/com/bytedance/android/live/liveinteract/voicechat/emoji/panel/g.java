package com.bytedance.android.live.liveinteract.voicechat.emoji.panel;

import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class g {
    public final String a;
    public final int b;
    public final int c;
    public int d;
    public final q0 e;

    public static final class a {
    }

    static {
    }

    public void a(HSImageView r2) {
        Intrinsics.checkNotNullParameter(r2, "icon");
    }

    public int b() {
        return 0;
    }

    public Object c() {
        return null;
    }

    public abstract int d();

    public String e() {
        return "";
    }

    public boolean i() {
        return false;
    }

    public abstract String j();

    public abstract void k(View r1);

    public boolean l() {
        return false;
    }

    public String f() {
        return this.a;
    }

    public int g() {
        return this.b;
    }

    public int h() {
        return this.c;
    }

    public g(q0 r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.e = r2;
        this.a = "";
        this.b = -1;
        this.c = 2131250010;
        this.d = s1.h(2131106994);
    }
}
