package com.ss.android.lark.keyboard.edittext2.widget;

import android.text.Editable;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.log.Log;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class g extends Editable.Factory {
    public static final g a = null;
    public static final HashSet<Class<?>> b = null;

    static {
        a = new g();
        String[] r0 = {"android.text.DynamicLayout$ChangeWatcher", "android.widget.TextView$ChangeWatcher"};
        b = new HashSet();
        int r1 = r0.length;     // Catch: Throwable -> L9
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L16;
        Class<?> r3 = a(r0[r2], a.getClass().getClassLoader());     // Catch: Throwable -> L9
        if (r3 == null) goto L8;
        b.add(r3);     // Catch: Throwable -> L9
    L8:
        r2 = r2 + 1;
        goto L4
    L16:
        return;
    L9:
        Log.e("RichTextEditableFactory", "RichTextEditableFactory: init failed");
    }

    public g() {
    }

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence r5) {
        Intrinsics.checkNotNullParameter(r5, "source");
        HashSet<Class<?>> r0 = b;
        int r1 = p.c;
        Intrinsics.checkNotNullParameter(r0, "classes");
        Intrinsics.checkNotNullParameter(r5, "text");
        return new p(r0, r5, 0, r5.length());
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r3, ClassLoader r4) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r5 = Class.forName(r3, false, r4);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r5;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r6 = Class.forName(r3, false, r4);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r6;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }
}
