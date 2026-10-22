package com.ss.android.lark.im.sdk.service;

import com.ss.android.lark.chat.core.model.ChannelDataFetcherStrategy;
import com.ss.android.lark.chat.core.model.MessageFetchScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final String a;
    public final MessageFetchScene b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final boolean g;
    public final ChannelDataFetcherStrategy h;
    public final String i;

    /* JADX INFO: renamed from: com.ss.android.lark.im.sdk.service.a$a, reason: collision with other inner class name */
    public static final class C0085a {
        public String a;
        public MessageFetchScene b;
        public int c;
        public int d;
        public int e;
        public int f;
        public boolean g;
        public ChannelDataFetcherStrategy h;
        public String i;

        public C0085a() {
        }

        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "chatId");
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.a = r2;
        }

        public final void b(MessageFetchScene r2) {
            Intrinsics.checkNotNullParameter(r2, "messageFetchScene");
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.b = r2;
        }

        public final void c(ChannelDataFetcherStrategy r2) {
            Intrinsics.checkNotNullParameter(r2, "strategy");
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.h = r2;
        }
    }

    public a(C0085a r3) {
        String r0 = r3.a;
        ChannelDataFetcherStrategy r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("chatId");
        r0 = null;
    L6:
        this.a = r0;
        MessageFetchScene r2 = r3.b;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("messageFetchScene");
        r2 = null;
    L10:
        this.b = r2;
        this.c = r3.c;
        this.d = r3.d;
        this.e = r3.e;
        this.f = r3.f;
        this.g = r3.g;
        ChannelDataFetcherStrategy r4 = r3.h;
        if (r4 == null) goto L13;
        r1 = r4;
    L14:
        this.h = r1;
        this.i = r3.i;
        return;
    L13:
        Intrinsics.throwUninitializedPropertyAccessException("strategy");
        goto L14
    }
}
