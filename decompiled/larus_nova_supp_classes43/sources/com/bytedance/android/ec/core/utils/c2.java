package com.bytedance.android.ec.core.utils;

import android.content.Context;
import com.byted.cast.sink.api.IServerListener;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c2 {
    public static final /* synthetic */ int h = 0;
    public int a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;

    public static final class a {
        @JvmStatic
        public static c2 a(Context r10, long r11, boolean r12) {
            Intrinsics.checkNotNullParameter(r10, "context");
            c2 r0 = new c2();
            String r13 = null;
            if (r11 <= 0) goto L27;
            int r1 = (((int) r11) % IServerListener.WHAT_BYTELINK_SINK_ERROR) / 100;
            long r14 = r11 / ((long) IServerListener.WHAT_BYTELINK_SINK_ERROR);
            int r15 = ((int) r14) % 60;
            long r16 = 60;
            long r17 = r14 / r16;
            int r18 = ((int) r17) % 60;
            int r19 = (int) (r17 / r16);
            int r110 = r19 % 24;
            int r111 = r19 / 24;
            r0.a = r111;
            if (r111 <= 0) goto L8;
            r13 = String.valueOf(r111);
        L8:
            r0.b = r13;
            if (r110 >= 10) goto L11;
            String r112 = th.a.h(r10, 2131913992, new Object[]{Integer.valueOf(r110)});
        L12:
            r0.c = r112;
            if (r18 >= 10) goto L15;
            String r113 = th.a.h(r10, 2131913992, new Object[]{Integer.valueOf(r18)});
        L16:
            r0.d = r113;
            if (r15 >= 10) goto L19;
            String r114 = th.a.h(r10, 2131913992, new Object[]{Integer.valueOf(r15)});
        L20:
            r0.e = r114;
            String r115 = String.valueOf(r1);
            r0.f = r115;
            if (r111 <= 0) goto L23;
            String r20 = th.a.h(r10, 2131913988, new Object[]{Integer.valueOf(r111), r0.c, r0.d, r0.e});
        L26:
            r0.g = r20;
        L28:
            return r0;
        L23:
            if (r12 == false) goto L25;
            r20 = th.a.h(r10, 2131913991, new Object[]{r0.c, r0.d, r0.e, r115});
            goto L26
        L25:
            r20 = th.a.h(r10, 2131913990, new Object[]{r0.c, r0.d, r0.e});
            goto L26
        L19:
            r114 = String.valueOf(r15);
            goto L20
        L15:
            r113 = String.valueOf(r18);
            goto L16
        L11:
            r112 = String.valueOf(r110);
            goto L12
        L27:
            r0.a = 0;
            r0.b = null;
            r0.c = th.a.g(r10, 2131913989);
            r0.d = th.a.g(r10, 2131913989);
            r0.e = th.a.g(r10, 2131913989);
            goto L28
        }
    }

    static {
    }

    public c2() {
    }
}
