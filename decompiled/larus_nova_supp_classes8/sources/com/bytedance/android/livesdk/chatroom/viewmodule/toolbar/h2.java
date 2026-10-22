package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class h2 {

    public static final class a extends h2 {
        public final int a;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.h2
        public final int a() {
            return this.a;
        }

        public a(int r1) {
            this.a = r1;
        }
    }

    public static final class b extends h2 {
        public final Function0<Integer> a;

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.h2
        public final int a() {
            return ((Number) this.a.invoke()).intValue();
        }

        public b(Function0<Integer> r2) {
            Intrinsics.checkNotNullParameter(r2, "eval");
            this.a = r2;
        }
    }

    public h2() {
    }

    public int a() {
        return 0;
    }
}
