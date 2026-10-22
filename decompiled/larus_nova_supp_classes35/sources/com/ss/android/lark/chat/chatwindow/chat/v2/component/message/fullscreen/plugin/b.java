package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.plugin;

import androidx.fragment.app.Fragment;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.MessageFullScreenFragment;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.MessageFullScreenViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public final Fragment a;
    public final MessageFullScreenViewModel b;
    public final List<a> c;
    public final Lazy d;

    public final void a(d r2) {
        Intrinsics.checkNotNullParameter(r2, "plugin");
        ((ArrayList) this.c).add(r2);
    }

    public b(MessageFullScreenFragment r2, MessageFullScreenViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        this.a = r2;
        this.b = r3;
        this.c = new ArrayList();
        this.d = LazyKt.lazy(new MessageFullScreenPluginAdapter$observer$2(this));
    }
}
