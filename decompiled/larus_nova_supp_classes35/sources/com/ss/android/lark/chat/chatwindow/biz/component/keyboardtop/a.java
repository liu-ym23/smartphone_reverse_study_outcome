package com.ss.android.lark.chat.chatwindow.biz.component.keyboardtop;

import android.content.Context;
import android.widget.FrameLayout;
import com.ss.android.lark.biz.im.extension.chat_window.keyboard_top.ExtendType;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final Map<ExtendType, Integer> a;
    public final Context b;
    public final FrameLayout c;
    public final Map<ExtendType, Integer> d;
    public final Map<ExtendType, Object> e;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.biz.component.keyboardtop.a$a, reason: collision with other inner class name */
    public static final class C0032a {
    }

    public interface b {
    }

    static {
    }

    public final Context getContext() {
        return this.b;
    }

    public a(Map<ExtendType, Integer> r2, Context r3, FrameLayout r4, b r5) {
        Intrinsics.checkNotNullParameter(r2, "propertiesMap");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r5, "dependency");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        ConcurrentHashMap r6 = new ConcurrentHashMap();
        this.d = r6;
        this.e = new ConcurrentHashMap();
        new LinkedHashMap();
        new ConcurrentHashMap();
        r6.putAll(r2);
    }
}
