package com.ss.android.lark.keyboard.factory;

import androidx.fragment.app.FragmentManager;
import com.ss.android.lark.biz.im.api.extension.chat_window.d;
import com.ss.android.lark.biz.im.api.extension.chat_window.h;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.keyboard.keyboard2.m;
import j2b.c;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends b {
    public final v k;
    public final FragmentManager l;
    public final h m;
    public d<m> n;

    /* JADX INFO: renamed from: com.ss.android.lark.keyboard.factory.a$a, reason: collision with other inner class name */
    public static final class C0148a {
    }

    static {
    }

    public a(v r2, FragmentManager r3, c r4, List r5, h r6) {
        Intrinsics.checkNotNullParameter(r2, "chatContainer");
        Intrinsics.checkNotNullParameter(r4, "pluginContext");
        Intrinsics.checkNotNullParameter(r5, "callbacks");
        Intrinsics.checkNotNullParameter(r6, "keyboardPluginContextExtension");
        super(r4, r5);
        this.k = r2;
        this.l = r3;
        this.m = r6;
    }
}
