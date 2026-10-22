package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import android.content.Context;
import android.view.View;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface a0<CMD> {

    public static final class a {
        public static /* synthetic */ void a(a0 r2, pp1.c r3, q2 r4) {
            r2.addBubble(r3, 1, r4, IToolbarBubbleManager$addBubble$2.INSTANCE);
        }
    }

    public interface b {
    }

    b addBubble(CMD r1, int r2, z<CMD> r3, Function0<Unit> r4);

    b addBubbleLocal(CMD r1, int r2, z<CMD> r3, Function0<Unit> r4);

    <T> z<T> createToolbarBubble(DataCenter r1, Context r2, View r3);

    boolean dismissBubble(b r1);

    void lock(Object r1);

    void tryStartNextBubble();

    void unlock(Object r1);
}
