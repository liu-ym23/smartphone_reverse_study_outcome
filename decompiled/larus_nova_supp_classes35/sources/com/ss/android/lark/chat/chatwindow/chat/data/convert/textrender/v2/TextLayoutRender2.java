package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import android.content.Context;
import android.text.Layout;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import com.ss.android.lark.widget.richtext.RichText;
import kotlin.jvm.internal.Intrinsics;
import v7b.r;
import v7b.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class TextLayoutRender2 extends com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.c {
    public z2b.a g;

    public static final class a {
    }

    static {
    }

    public TextLayoutRender2() {
    }

    @Override // z2b.b
    public final CharSequence a(z2b.b.a r8) {
        Intrinsics.checkNotNullParameter(r8, "request");
        m r0 = (m) r8;
        n r1 = r0.b;
        z2b.a r2 = this.g;
        if (r2 == null) goto L5;
        e(r1.b);
        d(this.c);
        CharSequence r3 = r2.b(r8);
        if (r3 == null) goto L10;
        d(this.d);
        Log.d("TextLayoutRender2", "parse, hit cache for message , message id is " + r1.b);
        return r3;
    L10:
        long r5 = System.currentTimeMillis();
        CharSequence r4 = f(r0.a, r1);
        r2.a(r8, r4);
        long r6 = System.currentTimeMillis() - r5;
        if (this.a == false) goto L13;
        Log.i("TextLayoutRender2", "parse, message " + r0.b.b + " , build charSequence, build charSequence cost " + r6 + " millis");
    L13:
        return r4;
    L5:
        return f(r0.a, r1);
    }

    @Override // z2b.b
    public final Layout b(z2b.b.InterfaceC0324b r8) {
        Intrinsics.checkNotNullParameter(r8, "request");
        p r0 = (p) r8;
        n r1 = r0.b;
        z2b.a r2 = this.g;
        if (r2 == null) goto L5;
        e(r1.b);
        d(this.e);
        Layout r3 = r2.c(r8);
        if (r3 == null) goto L10;
        d(this.f);
        Log.d("TextLayoutRender2", "render, hit cache for message, message id is " + r1.b);
        return r3;
    L10:
        long r5 = System.currentTimeMillis();
        Layout r4 = g(r0.a, r1);
        if (r4 == null) goto L13;
        r2.d(r8, r4);
    L13:
        long r6 = System.currentTimeMillis() - r5;
        if (this.a == false) goto L16;
        Log.i("TextLayoutRender2", "render, message " + r1.b + " not hit cache, render cs, render cost " + r6 + " millis");
    L16:
        return r4;
    L5:
        return g(r0.a, r1);
    }

    public static CharSequence f(RichText r2, final n r3) {
        t9b.a r0 = t9b.a.a;
        com.ss.android.lark.richtextmd.parse.impl.b r1 = com.ss.android.lark.richtextmd.parse.ext.a.b(r3.getContext());
        com.ss.android.lark.richtextmd.parse.ext.a.a(r1, new TextLayoutRender2$parseImpl$node$1(r3));
        s r4 = r1.b(r2);
        if (DevEnvUtil.isDevelopPackage(r3.getContext()) == false) goto L5;
        Log.d("TextLayoutRender2", "parse, node tree is " + r.a(r4, false));
    L5:
        t9b.b r5 = t9b.b.a;
        com.ss.android.lark.coremd.impl.parse.b.a r6 = t9b.b.a(r3.getContext());
        com.ss.android.lark.coremd.ext.l.b(r6, r3.d);
        com.ss.android.lark.coremd.ext.l.a(r6, r3.g);
        r6.c(r3.e.clone());
        return r6.a(r4, r3.f.clone());
    }

    public final Layout g(CharSequence r5, n r6) {
        com.ss.android.lark.widget.light.layout.h r0 = r6.h;
        TextLayoutBuilder r1 = new TextLayoutBuilder();
        z2b.a r2 = this.g;
        if ((r2 instanceof TextLayoutCacheStoreImpl2) == false) goto L5;
        TextLayoutCacheStoreImpl2 r3 = (TextLayoutCacheStoreImpl2) r2;
        Context r7 = r6.getContext();
        r3.getClass();
        Intrinsics.checkNotNullParameter(r7, "context");
        r1.c.s = new k(r3, r7);
    L5:
        r1.h(r5);
        r0.a(r1);
        return r1.a();
    }
}
