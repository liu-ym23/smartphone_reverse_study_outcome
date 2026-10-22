package qh0;

import android.content.Context;
import com.bytedance.android.live.liveinteract.plantform.permission.checker.s;
import com.bytedance.android.live.liveinteract.plantform.permission.checker.t;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f {

    public static final class a implements qh0.c {
        public final Context a;

        public final Context getContext() {
            return this.a;
        }

        public a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            this.a = r2;
        }

        @Override // qh0.c
        public final qh0.a<rh0.a> a(qh0.a<rh0.a> r2) {
            return new com.bytedance.android.live.liveinteract.plantform.permission.checker.a(this, r2);
        }
    }

    public static final class b implements qh0.c {
        public final Context a;
        public final OperateType b;
        public final int c;
        public final boolean d;

        public final Context getContext() {
            return this.a;
        }

        @Override // qh0.c
        public final qh0.a<rh0.a> a(qh0.a<rh0.a> r1) {
            return new com.bytedance.android.live.liveinteract.plantform.permission.checker.e(this);
        }

        public b(Context r2, OperateType r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "operateType");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = false;
        }
    }

    public static final class c implements qh0.c {
        public final Context a;
        public final OperateType b;
        public final int c;

        public final Context getContext() {
            return this.a;
        }

        @Override // qh0.c
        public final qh0.a<rh0.a> a(qh0.a<rh0.a> r2) {
            return new com.bytedance.android.live.liveinteract.plantform.permission.checker.i(this, r2);
        }

        public c(Context r2, OperateType r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "operateType");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class d implements qh0.c {
        public final Context a;
        public final OperateType b;
        public final int c;
        public final boolean d;

        public final Context getContext() {
            return this.a;
        }

        @Override // qh0.c
        public final qh0.a<rh0.a> a(qh0.a<rh0.a> r2) {
            return new com.bytedance.android.live.liveinteract.plantform.permission.checker.m(this, r2);
        }

        public d(Context r2, OperateType r3, int r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "operateType");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class e implements qh0.c {
        public final Context a;

        public final Context getContext() {
            return this.a;
        }

        @Override // qh0.c
        public final qh0.a<rh0.a> a(qh0.a<rh0.a> r2) {
            return new com.bytedance.android.live.liveinteract.plantform.permission.checker.q(this, r2);
        }

        public e(Context r2, OperateType r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "operateType");
            this.a = r2;
        }
    }

    /* JADX INFO: renamed from: qh0.f$f, reason: collision with other inner class name */
    public static final class C0257f implements qh0.c {
        public final Context a;
        public final OperateType b;
        public final int c;
        public final boolean d;

        public final Context getContext() {
            return this.a;
        }

        @Override // qh0.c
        public final qh0.a<rh0.a> a(qh0.a<rh0.a> r2) {
            return new com.bytedance.android.live.liveinteract.plantform.permission.checker.r(this, r2);
        }

        public C0257f(Context r2, OperateType r3, int r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "operateType");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    public static final class g implements qh0.c {
        public final Context a;
        public final OperateType b;
        public final int c;

        public final Context getContext() {
            return this.a;
        }

        @Override // qh0.c
        public final qh0.a<rh0.a> a(qh0.a<rh0.a> r2) {
            return new com.bytedance.android.live.liveinteract.plantform.permission.checker.o(this, r2);
        }

        public g(Context r2, OperateType r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "operateType");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class h implements qh0.c {
        public final Context a;
        public final OperateType b;
        public final int c;
        public final int d;
        public final IRoom e;
        public final String f;
        public final String g;
        public final j1 h;
        public final Function2<? super String, ? super String, Unit> i;

        public final Context getContext() {
            return this.a;
        }

        @Override // qh0.c
        public final qh0.a<rh0.a> a(qh0.a<rh0.a> r4) {
            return new t(this, r4, this.h, this.i);
        }

        public h(Context r3, OperateType r4, int r5, int r6, IRoom r7, String r8, String r9, j1 r10, Function2 r11, int r12) {
            if ((r12 & 32) == 0) goto L6;
            r8 = "0";
        L6:
            if ((r12 & 256) == 0) goto L9;
            r9 = null;
        L9:
            if ((r12 & 512) == 0) goto L12;
            r10 = null;
        L12:
            if ((r12 & 1024) == 0) goto L14;
            r11 = null;
        L14:
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "operateType");
            Intrinsics.checkNotNullParameter(r8, "toUserId");
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r10;
            this.i = r11;
        }
    }

    static {
    }

    @JvmStatic
    public static final s a(List r2) {
        Intrinsics.checkNotNullParameter(r2, "createConfigs");
        Iterator r3 = r2.iterator();
        qh0.a<rh0.a> r0 = null;
    L4:
        if (r3.hasNext() == false) goto L7;
        r0 = ((qh0.c) r3.next()).a(r0);
        goto L4
    L7:
        return new s(r0);
    }
}
