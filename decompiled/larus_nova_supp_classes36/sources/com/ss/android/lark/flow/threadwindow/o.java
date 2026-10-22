package com.ss.android.lark.flow.threadwindow;

import com.ss.android.lark.chat.chatwindow.chat.v2.push.c0;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class o implements c0.a {
    public final Function3<String, Integer, Long, Unit> a;
    public final Function1<String, Unit> b;
    public final w4b.c0 c;

    public static final class a {
        public a() {
        }
    }

    public final void register() {
        this.c.e();
    }

    public final void unRegister() {
        this.c.c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(String r2, Function3<? super String, ? super Integer, ? super Long, Unit> r3, Function1<? super String, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r3, "onMediaUploadProgress");
        Intrinsics.checkNotNullParameter(r4, "onMediaUploadFailed");
        this.a = r3;
        this.b = r4;
        this.c = ChatCoreModule.a().getPushDependency();
        new a();
    }
}
