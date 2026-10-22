package com.bytedance.android.live.liveinteract.widget.widget;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public final String a;
    public final String b;
    public final int c;
    public final int d;
    public final View.OnClickListener e;

    public static class a {
        public String a;
        public String b;
        public int c;
        public int d;
        public View.OnClickListener e;

        public a() {
            this.a = "";
            this.b = "";
            this.d = -1;
        }
    }

    public e(a r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        this.a = "";
        this.b = "";
        this.d = -1;
        this.a = r2.a;
        this.b = r2.b;
        this.c = r2.c;
        this.d = r2.d;
        this.e = r2.e;
    }
}
