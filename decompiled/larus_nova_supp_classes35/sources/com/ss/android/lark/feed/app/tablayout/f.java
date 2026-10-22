package com.ss.android.lark.feed.app.tablayout;

import android.graphics.drawable.ShapeDrawable;
import android.os.Build;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f extends ShapeDrawable {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    public static class b {
        public b() {
        }
    }

    public static class c extends b {
        public c() {
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        new b();
        return;
    L5:
        new c();
    }
}
