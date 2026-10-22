package com.bytedance.android.livesdk.gamecp.utils;

import com.bytedance.android.live.room.api.panel.PanelName;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gamecp.utils.a$a, reason: collision with other inner class name */
    public static final class C0357a implements com.bytedance.android.live.room.api.panel.b {
        public final int a;
        public final int b;

        public final PanelName getPanelName() {
            return PanelName.GameCp;
        }

        public final int getUnionId() {
            return this.b;
        }

        public C0357a(int r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(Function1<? super Integer, Unit> r2, Function1<? super String, Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, "continueAction");
            Intrinsics.checkNotNullParameter(r3, "stopAction");
            r2.invoke(Integer.valueOf(this.a));
        }
    }

    static {
    }
}
