package com.ss.android.lark.keyboard.keyboard2;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.ss.android.lark.keyboard.KeyboardScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k implements c {
    public static final a f = null;
    public final KeyboardScene a;
    public final Lifecycle b;
    public final Activity c;
    public final Fragment d;
    public com.ss.android.lark.keyboard.b e;

    public static final class a implements c.a<k> {
        public a() {
        }
    }

    static {
        f = new a();
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void d() {
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void j() {
    }

    public final Activity getContext() {
        return this.c;
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.c
    public final void setKeyboard(com.ss.android.lark.keyboard.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    public k(KeyboardScene r2, Lifecycle r3, Activity r4, Fragment r5) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r4, "context");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
