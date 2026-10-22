package com.bytedance.ai.debugscene;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ai.debug.NativeDebugPanelType;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f0 {
    public static final f0 a = null;
    public static final Handler b = null;
    public static volatile a c;
    public static c d;

    public static final class a {
        public final NativeDebugPanelType a;
        public final com.bytedance.ai.debug.h b;
        public final b c;
        public final j0 d;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof a) == true) goto L8;
            return false;
        L8:
            a r11 = (a) r10;
            if (this.a == r11.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r11.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "CurrentPanel(type=" + this.a + ", listener=" + this.b + ", dispatcher=" + this.c + ", handle=" + this.d + ')';
        }

        public final NativeDebugPanelType getType() {
            return this.a;
        }

        public a(NativeDebugPanelType r10, com.bytedance.ai.debug.h r11, b r12, j0 r13) {
            Intrinsics.checkNotNullParameter(r10, "type");
            Intrinsics.checkNotNullParameter(r11, "listener");
            Intrinsics.checkNotNullParameter(r12, "dispatcher");
            Intrinsics.checkNotNullParameter(r13, "handle");
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
        }
    }

    public static final class b implements k0 {
        public final com.bytedance.ai.debug.h a;
        public final AtomicBoolean b;
        public final AtomicBoolean c;

        public b(com.bytedance.ai.debug.h r10) {
            Intrinsics.checkNotNullParameter(r10, "listener");
            this.a = r10;
            this.b = new AtomicBoolean(true);
            this.c = new AtomicBoolean(false);
        }

        @Override // com.bytedance.ai.debugscene.k0
        public final void a(final String r10, final String r11, final o2 r12) {
            Intrinsics.checkNotNullParameter(r10, "type");
            Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_MSG);
            Intrinsics.checkNotNullParameter(r12, "reply");
            if (this.b.get() == true) goto L6;
            com.bytedance.ai.utils.g.a.w("AIDebugPanelCoordinator", "reject panel message because session is unavailable, type:" + r10);
            b(r12, -2, "MESSAGE_TYPE_NOT_REGISTERED", null);
            return;
        L6:
            f0.b.post(new g0(this, r12, r10, r11));
        }

        public static void c(com.bytedance.ai.debug.i r1, int r10, String r11, String r12) {
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
            r1.a(r10, r11, r12);     // Catch: Throwable -> L4
            Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
        L6:
            Throwable r14 = Result.exceptionOrNull-impl(r13);
            if (r14 == null) goto L12;
            com.bytedance.ai.utils.g.a.e("AIDebugPanelCoordinator", "panel reply failed, code:" + r10 + ", error:" + r14.getMessage());
            return;
        L12:
            return;
        L4:
            th = move-exception;
            Result.Companion r15 = Result.Companion;
            r13 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L6
        }

        public final void b(final com.bytedance.ai.debug.i r10, final int r11, final String r12, final String r13) {
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
            c(r10, r11, r12, r13);
            return;
        L5:
            f0.b.post(new i0(this, r10, r11, r12, r13));
        }
    }

    public static final class c {
        public final NativeDebugPanelType a;
        public final String b;
        public final com.bytedance.ai.debug.h c;
        public final Activity d;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof c) == true) goto L8;
            return false;
        L8:
            c r11 = (c) r10;
            if (this.a == r11.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r11.d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public final String toString() {
            return "PanelRequest(type=" + this.a + ", launchParamsJson=" + this.b + ", listener=" + this.c + ", activity=" + this.d + ')';
        }

        public final Activity getActivity() {
            return this.d;
        }

        public final NativeDebugPanelType getType() {
            return this.a;
        }

        public c(NativeDebugPanelType r10, String r11, com.bytedance.ai.debug.h r12, Activity r13) {
            Intrinsics.checkNotNullParameter(r10, "type");
            Intrinsics.checkNotNullParameter(r11, "launchParamsJson");
            Intrinsics.checkNotNullParameter(r12, "listener");
            Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
            this.a = r10;
            this.b = r11;
            this.c = r12;
            this.d = r13;
        }
    }

    public f0() {
    }

    static {
        a = new f0();
        b = new Handler(Looper.getMainLooper());
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [com.bytedance.ai.debugscene.d0] */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.bytedance.ai.debugscene.e0] */
    public final boolean a(c r10) {
        final b r11 = new b(r10.c);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        w0 r1 = w0.a;     // Catch: Throwable -> L5
        Activity r12 = r10.getActivity();     // Catch: Throwable -> L5
        NativeDebugPanelType r13 = r10.getType();     // Catch: Throwable -> L5
        String r14 = r10.b;     // Catch: Throwable -> L5
        ?? r15 = new d0(this, r11);     // Catch: Throwable -> L5
        ?? r16 = new e0(this, r11);     // Catch: Throwable -> L5
        r1.getClass();     // Catch: Throwable -> L5
        Object r17 = Result.constructor-impl(w0.a(r12, r13, r14, r11, r15, r16));     // Catch: Throwable -> L5
    L7:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L11;
        com.bytedance.ai.utils.g.a.e("AIDebugPanelCoordinator", "show panel failed, type:" + r10.getType() + ", error:" + r18.getMessage());
    L11:
        if (Result.isFailure-impl(r17) == false) goto L13;
        r17 = null;
    L13:
        j0 r19 = (j0) r17;
        if (r19 != null) goto L17;
        r11.b.set(false);
        return false;
    L17:
        c = new a(r10.getType(), r10.c, r11, r19);
        com.bytedance.ai.utils.g.a.i("AIDebugPanelCoordinator", "show panel accepted, type:" + r10.getType());
        return true;
    L5:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public final boolean b(c r10) {
        a r0 = c;
        if (r0 != null) goto L7;
        return a(r10);
    L7:
        if (r0.d.a(r10.getActivity()) == true) goto L11;
        d = r10;
        com.bytedance.ai.utils.g.a.i("AIDebugPanelCoordinator", "replace panel because host Activity changed, type:" + r10.getType());
        r0.d.close();
        return true;
    L11:
        if (r0.getType() == r10.getType()) goto L13;
        d = r10;
        com.bytedance.ai.utils.g.a.i("AIDebugPanelCoordinator", "replace panel, from:" + r0.getType() + ", to:" + r10.getType());
        r0.d.close();
        return true;
    L13:
        if (r0.b == r10.c) goto L16;
        d = r10;
        com.bytedance.ai.utils.g.a.i("AIDebugPanelCoordinator", "replace panel because listener differs, type:" + r10.getType());
        r0.d.close();
        return true;
    L16:
        r0.d.b(r10.b);
        com.bytedance.ai.utils.g.a.i("AIDebugPanelCoordinator", "update panel params, type:" + r10.getType());
        return true;
    }
}
