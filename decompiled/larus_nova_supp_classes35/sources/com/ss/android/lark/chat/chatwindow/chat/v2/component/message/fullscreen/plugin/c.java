package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.MessageFullScreenViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public final Context a;
    public final Fragment b;
    public final MessageFullScreenViewModel c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        Context r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((r1 * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public final String toString() {
        return "PluginContext(context=" + this.a + ", fragment=" + this.b + ", viewModel=" + this.c + ')';
    }

    public final Context getContext() {
        return this.a;
    }

    public c(Context r2, Fragment r3, MessageFullScreenViewModel r4) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "viewModel");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
