package com.bytedance.android.livesdk.gamesticker.hok.machine;

import com.bytedance.android.livesdk.chatroom.model.b2;
import com.bytedance.android.livesdk.chatroom.model.c3;
import com.bytedance.android.livesdk.chatroom.model.j0;
import com.bytedance.android.livesdk.chatroom.model.k2;
import com.bytedance.android.livesdk.chatroom.model.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public abstract class b {

    public static final class a extends b {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gamesticker.hok.machine.b$b, reason: collision with other inner class name */
    public static final class C0363b extends b {
        public final c3 a;
        public final j0 b;

        public C0363b(c3 r2, j0 r3) {
            Intrinsics.checkNotNullParameter(r2, "roleInfo");
            Intrinsics.checkNotNullParameter(r3, "equipState");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c extends b {
        public final c3 a;
        public final k2 b;

        public c(c3 r2, k2 r3) {
            Intrinsics.checkNotNullParameter(r2, "roleInfo");
            Intrinsics.checkNotNullParameter(r3, "moneyCount");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class d extends b {
        public final c3 a;
        public final b2 b;

        public d(c3 r2, b2 r3) {
            Intrinsics.checkNotNullParameter(r2, "roleInfo");
            Intrinsics.checkNotNullParameter(r3, "liveInfo");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class e extends b {
        public final c3 a;

        public e(c3 r2) {
            Intrinsics.checkNotNullParameter(r2, "roleInfo");
            this.a = r2;
        }
    }

    public static final class f extends b {
        public final c3 a;
        public final o b;

        public f(c3 r2, o r3) {
            Intrinsics.checkNotNullParameter(r2, "roleInfo");
            Intrinsics.checkNotNullParameter(r3, "battleInfo");
            this.a = r2;
            this.b = r3;
        }
    }

    public b() {
    }
}
