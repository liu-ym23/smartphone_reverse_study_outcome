package com.obric.matrixpro.sdk.deviceinfoclient;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.obric.aiagent.product.platform.impl.rom.PublicRomInfoImpl;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static HandlerThread a;
    public static f b;
    public static Handler c;
    public static Context d;
    public static final a e = null;

    /* JADX INFO: renamed from: com.obric.matrixpro.sdk.deviceinfoclient.a$a, reason: collision with other inner class name */
    public interface InterfaceC0042a {
        void onError(String r1);

        void onSuccess(String r1);
    }

    public static final class b {
        public final Context a;
        public final InterfaceC0042a b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L10;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            Context r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            InterfaceC0042a r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "OsDidRequest(context=" + this.a + ", callback=" + this.b + ")";
        }

        public final Context getContext() {
            return this.a;
        }

        public b(Context r2, PublicRomInfoImpl.getOSDeviceIdAsync.1.a r3) {
            Intrinsics.checkNotNullParameter(r2, "context");
            Intrinsics.checkNotNullParameter(r3, "callback");
            this.a = r2;
            this.b = r3;
        }
    }

    public a() {
    }

    static {
        e = new a();
        new CopyOnWriteArrayList();
    }

    public static Cursor a(ContentResolver r12, Uri r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13, null, null, null, null};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r12, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r14 = r12.query(r13, null, null, null, null);
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, r14, r10, true);
        return r14;
    }

    public static void b(Context r3, PublicRomInfoImpl.getOSDeviceIdAsync.1.a r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "callback");
        if (d != null) goto L6;
        d = r3.getApplicationContext();
    L6:
        if (a != null) goto L11;
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("DeviceInfoGetter-Worker");
        a = r0;
        ThreadMethodProxy.start(r0);
        HandlerThread r1 = a;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("handlerThread");
    L10:
        b = new f(r1.getLooper());
        c = new Handler(Looper.getMainLooper());
    L11:
        b r2 = new b(r3.getApplicationContext(), r4);
        f r5 = b;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("workerHandler");
    L14:
        Message r6 = Message.obtain(r5, 1, r2);
        f r7 = b;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("workerHandler");
    L17:
        r7.sendMessage(r6);
    }
}
