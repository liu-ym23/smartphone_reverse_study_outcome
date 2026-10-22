package com.bytedance.android.live.messagewindow.framework.process;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int d = 0;
    public im0.a a;
    public final y61.b b;
    public final v61.a c;

    /* JADX INFO: renamed from: com.bytedance.android.live.messagewindow.framework.process.a$a, reason: collision with other inner class name */
    public static final class C0130a {
        public static a a(y61.b r1, v61.a r2) {
            Intrinsics.checkNotNullParameter(r1, "msgWindowCtx");
            Intrinsics.checkNotNullParameter(r2, "card");
            return new a(r1, r2);
        }
    }

    static {
    }

    public a(y61.b r1, v61.a r2) {
        this.b = r1;
        this.c = r2;
    }
}
