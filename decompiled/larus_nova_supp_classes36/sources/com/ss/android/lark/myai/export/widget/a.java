package com.ss.android.lark.myai.export.widget;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements ViewTreeObserver.OnPreDrawListener {
    public static final /* synthetic */ int f = 0;
    public final TextView a;
    public final int b;
    public final int c;
    public LinearGradient d;
    public boolean e;

    /* JADX INFO: renamed from: com.ss.android.lark.myai.export.widget.a$a, reason: collision with other inner class name */
    public static final class C0196a {
    }

    static {
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        if (this.e == true) goto L5;
    L18:
        this.a.getPaint().setShader(null);
    L19:
        return true;
    L5:
        if (this.a.getText().length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L18;
        if (this.a.getLayout() == null) goto L18;
        if (this.a.isDirty() == true) goto L16;
        LinearGradient r1 = this.d;
        if (r1 == null) goto L16;
    L17:
        this.a.getPaint().setShader(r1);
    L16:
        LinearGradient r10 = new LinearGradient(0.0f, 0.0f, Math.min(this.a.getLayout().getWidth(), this.a.getWidth()), this.a.getHeight(), this.b, this.c, Shader.TileMode.CLAMP);
        this.d = r10;
        r1 = r10;
        goto L17
    L7:
        r0 = false;
        goto L8
    }

    public a(TextView r3) {
        Intrinsics.checkNotNullParameter(r3, "target");
        this.a = r3;
        Context r0 = r3.getContext();
        this.b = UDColorUtils.getColor(r0, 2131103667);
        this.c = UDColorUtils.getColor(r0, 2131103670);
        r3.getViewTreeObserver().addOnPreDrawListener(this);
        this.e = true;
    }
}
