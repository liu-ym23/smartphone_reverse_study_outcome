package v2b;

import android.content.Context;
import android.text.Layout;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import kotlin.jvm.functions.Function1;
import u2b.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final int a;
    public Function1<? super Context, ? extends com.ss.android.lark.widget.light.viewstub.f> b;

    /* JADX INFO: renamed from: v2b.a$a, reason: collision with other inner class name */
    public static final class C0310a {
    }

    static {
    }

    public a() {
        this.a = UIHelper.dp2px(2.5f);
    }

    public final Layout a(CharSequence r7, com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b r8, Context r9) {
        com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.b.InterfaceC0038b r0 = r8.G;
        if (r0 == null) goto L5;
        Integer r1 = r0.a();
    L7:
        switch(r8.x) {
            case 17: goto L16;
            case 18: goto L15;
            case 19: goto L14;
            case 20: goto L13;
            case 21: goto L12;
            case 22: goto L11;
            case 23: goto L10;
            case 24: goto L9;
            default: goto L8;
        };
    L8:
        int r2 = Integer.MAX_VALUE;
    L18:
        if (r8.j == false) goto L20;
    L22:
        boolean r3 = false;
    L23:
        int r4 = Math.max(r8.L, r8.M);
        if (r4 <= 0) goto L26;
        r2 = r4;
    L26:
        r8.L = 0;
        r8.M = 0;
        Function1<? super Context, ? extends com.ss.android.lark.widget.light.viewstub.f> r5 = this.b;
        if (r5 == null) goto L30;
        com.ss.android.lark.widget.light.viewstub.f r6 = (com.ss.android.lark.widget.light.viewstub.f) r5.invoke(r9);
        if (r6 == null) goto L30;
    L31:
        TextLayoutBuilder r10 = new TextLayoutBuilder();
        r10.h(r7);
        r10.c.s = r6;
        r10.j((int) zz7.b.h(r9, 17));
        if (r8.e == false) goto L34;
        int r11 = v2c.a.b(r9, 2131106620);
    L35:
        r10.i(r11);
        r10.f(r2);
        r10.l(1.0f);
        TextLayoutBuilder.a r12 = r10.c;
        if (r12.m == false) goto L38;
        r12.m = false;
        r10.d = null;
    L38:
        r10.m(h18.e.b(r9, 0));
        r10.d(null);
        r10.g = r8.A;
        r10.c(r8.v);
        r10.e = new com.ss.android.lark.widget.light.layout.a();
        r10.k(UIHelper.dp2px(2.5f));
        r10.f = r3;
        r10.c.c = this.a;
        return r10.a();
    L34:
        r11 = v2c.a.b(r9, 2131106622);
    L30:
        r6 = new b(r9);
        goto L31
    L20:
        if (r8.w == true) goto L22;
        r3 = true;
        goto L23
    L9:
        r2 = j.f(r9, r1);
        goto L18
    L10:
        r2 = j.j(r9, r8.g, r1, r8.a0);
        goto L18
    L11:
        r2 = j.i(r9, r8.g, r1, r8.a0);
        goto L18
    L12:
        r2 = j.l(r9, r1);
        goto L18
    L13:
        r2 = j.k(r9, r1);
        goto L18
    L14:
        r2 = j.e(r9, r1, r8.a0, r8.g);
        goto L18
    L15:
        r2 = j.b(r9, r1);
        goto L18
    L16:
        r2 = j.d(r9, r1);
        goto L18
    L5:
        r1 = null;
        goto L7
    }
}
