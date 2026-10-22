package com.ss.android.lark.movable.selection;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j {
    public final Context a;
    public ViewGroup b;
    public UDShadowLayout c;
    public k d;
    public final Rect e;

    public static final class a {
    }

    static {
    }

    public final void a() {
        Log.d("Movable_SelectionDialog", "dismiss");
        View r0 = this.c;
        if (r0 == null) goto L8;
        ViewGroup r2 = this.b;
        if (r2 == null) goto L7;
        r2.removeView(r0);
    L7:
        this.c = null;
    L8:
        k r1 = this.d;
        if (r1 == null) goto L15;
        ViewGroup r3 = this.b;
        if (r3 == null) goto L13;
        r3.removeView(r1);
    L13:
        this.d = null;
        return;
    }

    public j(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r3;
        this.e = new Rect(0, b(20), 0, 0);
    }

    public final int b(int r2) {
        return UIUtils.dp2px(this.a, r2);
    }
}
