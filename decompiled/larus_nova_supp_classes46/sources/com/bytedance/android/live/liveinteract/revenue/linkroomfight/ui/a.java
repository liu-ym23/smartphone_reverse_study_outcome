package com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest.MultiLinkCommonGuestMicSeatBasicLayer;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest.MultiLinkAudioCommonGuestMicSeatBasicLayer;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.config.om;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import pg0.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a$a, reason: collision with other inner class name */
    public static final class C0094a {
        public C0094a() {
        }

        @JvmStatic
        public static boolean b(ILinkPlayerInfoBridge r1) {
            Intrinsics.checkNotNullParameter(r1, "info");
            return !r1.isLinkRoomUser();
        }

        public static /* synthetic */ boolean d(Integer r1) {
            Integer r0 = je0.d.h();
            if (r0 == null) goto L5;
            int r2 = r0.intValue();
        L7:
            return c(r1, r2);
        L5:
            r2 = 0;
            goto L7
        }

        @JvmStatic
        public static int a(int r1, int r2) {
            if (r2 != 51) goto L7;
            return (r1 % 2) + ((r1 / 4) * 2);
        L7:
            if (r2 != 67) goto L11;
            return r1 % 9;
        L11:
            return r1 % 6;
        }

        @JvmStatic
        public static boolean c(Integer r0, int r1) {
            if (r0 == null) goto L4;
            int r2 = r0.intValue();
        L6:
            return !aj0.b.a(r2, r1);
        L4:
            r2 = 0;
            goto L6
        }

        @JvmStatic
        public static int e(int r1, int r2) {
            if (r2 == 67) goto L5;
            int r3 = (r1 / 2) * 2;
        L9:
            return r1 + r3;
        L5:
            if (((Boolean) om.a.getValue()).booleanValue() == false) goto L10;
            r3 = (r1 / 3) * 3;
            goto L9
        L10:
            return r1;
        }

        public static /* synthetic */ void g(Object r1, int r2) {
            Integer r0 = je0.d.h();
            if (r0 == null) goto L5;
            int r3 = r0.intValue();
        L6:
            f(r1, r2, r3);
            return;
        L5:
            r3 = 0;
            goto L6
        }

        public static void f(Object r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r4, "layer");
            ConstraintLayout.LayoutParams r1 = null;
            if ((r4 instanceof MultiLinkAudioCommonGuestMicSeatBasicLayer) == true) goto L25;
            if ((r4 instanceof MultiLinkCommonGuestMicSeatBasicLayer) == true) goto L25;
            if ((r4 instanceof e) == false) goto L13;
            View r7 = ((e) r4).m(2131389701);
            if (r7 == null) goto L62;
            r7.setAlpha(0.0f);
            return;
        L62:
            return;
        L13:
            if ((r4 instanceof com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b) == false) goto L64;
            com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b r8 = (com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.empty.b) r4;
            View r0 = r8.m(2131389701);
            if (r0 == null) goto L17;
            r0.setAlpha(0.0f);
        L17:
            ConstraintLayout.LayoutParams r9 = r8.m(2131389540);
            if ((r9 instanceof TextView) == false) goto L21;
            r1 = r9;
        L21:
            TextView r2 = (TextView) r1;
            if (r2 == null) goto L65;
            int r10 = a.a;
            r2.setText(String.valueOf(a(r5, r6) + 1));
            return;
        L65:
            return;
        L64:
            return;
        L25:
            if ((r4 instanceof jg0.c) == true) goto L27;
            r4 = null;
        L27:
            jg0.c r11 = (jg0.c) r4;
            int r3 = a.a;
            if (c(Integer.valueOf(r5), r6) == true) goto L45;
            if (r11 == null) goto L31;
            View r12 = r11.m(2131389577);
        L32:
            ViewGroup r13 = (ViewGroup) r12;
            if (r13 == null) goto L35;
            ConstraintLayout.LayoutParams r14 = r13.getLayoutParams();
        L37:
            if ((r14 instanceof ConstraintLayout.LayoutParams) == false) goto L40;
            r1 = r14;
        L40:
            ConstraintLayout.LayoutParams r15 = r1;
            if (r15 == null) goto L67;
            r15.leftToLeft = -1;
            r15.rightToRight = 0;
            if (r13 == null) goto L68;
            r13.setLayoutParams(r15);
            return;
        L68:
            return;
        L67:
            return;
        L35:
            r14 = null;
            goto L37
        L31:
            r12 = null;
            goto L32
        L45:
            if (r11 == null) goto L47;
            View r16 = r11.m(2131389577);
        L48:
            ViewGroup r17 = (ViewGroup) r16;
            if (r17 == null) goto L51;
            ConstraintLayout.LayoutParams r18 = r17.getLayoutParams();
        L53:
            if ((r18 instanceof ConstraintLayout.LayoutParams) == false) goto L56;
            r1 = r18;
        L56:
            ConstraintLayout.LayoutParams r19 = r1;
            if (r19 == null) goto L70;
            r19.leftToLeft = 0;
            r19.rightToRight = -1;
            if (r17 == null) goto L71;
            r17.setLayoutParams(r19);
            return;
        L71:
            return;
        L70:
            return;
        L51:
            r18 = null;
            goto L53
        L47:
            r16 = null;
            goto L48
        }
    }

    static {
        new C0094a();
    }
}
