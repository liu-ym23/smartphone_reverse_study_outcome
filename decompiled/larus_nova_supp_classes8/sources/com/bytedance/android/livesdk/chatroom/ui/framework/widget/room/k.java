package com.bytedance.android.livesdk.chatroom.ui.framework.widget.room;

import android.content.DialogInterface;
import com.bytedance.android.livesdk.closeroom.CloseRoomInterceptList;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.widget.x0;
import kotlin.jvm.internal.Intrinsics;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k implements kf1.a {
    public final /* synthetic */ RoomCloseInterceptorWidget a;

    public static final class a implements DialogInterface.OnClickListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "dialog");
            xs2.b.a().post(new h1(58));
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "dialog");
            r1.dismiss();
        }
    }

    public final String tag() {
        return "VsConcertInterceptor";
    }

    public final CloseRoomInterceptList config() {
        return CloseRoomInterceptList.DEFAULT;
    }

    public k(RoomCloseInterceptorWidget r1) {
        this.a = r1;
    }

    public final boolean qa(Runnable r3, boolean r4) {
        IKtvService r5 = jc1.k.f(IKtvService.class);
        if (r5 == null) goto L7;
        gd2.c r6 = r5.getChorusConcertService();
        if (r6 == null) goto L7;
        boolean r7 = r6.b();
    L8:
        if (r7 == true) goto L10;
        return false;
    L10:
        x0.b r8 = new x0.b(this.a.getContext(), 4);
        r8.m(2131923301);
        r8.l(2131923300);
        r8.i(0, 2131920806, a.a);
        r8.i(1, 2131915442, b.a);
        r8.n();
        return true;
    L7:
        r7 = false;
        goto L8
    }
}
