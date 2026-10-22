package com.ss.android.lark.keyboard.base;

import com.ss.android.lark.keyboard.event.ImeState;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class KeyboardLogicPluginController {
    public final com.ss.android.lark.keyboard.b a;
    public final com.ss.android.lark.keyboard.event.k b;
    public final Map<g.a<?>, g<?>> c;

    public KeyboardLogicPluginController(com.ss.android.lark.keyboard.b r3) {
        Intrinsics.checkNotNullParameter(r3, "keyboard");
        this.a = r3;
        com.ss.android.lark.keyboard.event.k r4 = r3.e();
        this.b = r4;
        this.c = new LinkedHashMap();
        com.ss.android.lark.keyboard.event.l r5 = r4.of(this);
        r5.d(InputSupportType.class, new KeyboardLogicPluginController$1$1(this));
        r5.d(cya.h.class, new KeyboardLogicPluginController$1$2(this));
        r5.d(ImeState.class, new KeyboardLogicPluginController$1$3(this));
        r5.d(com.ss.android.lark.keyboard.event.n.class, new KeyboardLogicPluginController$1$4(this));
        r5.d(com.ss.android.lark.keyboard.event.r.class, new KeyboardLogicPluginController$1$5(this));
        r5.c(com.ss.android.lark.keyboard.event.q.a.class, new KeyboardLogicPluginController$1$6(this));
        r5.c(com.ss.android.lark.keyboard.event.q.b.class, new KeyboardLogicPluginController$1$7(this));
    }
}
