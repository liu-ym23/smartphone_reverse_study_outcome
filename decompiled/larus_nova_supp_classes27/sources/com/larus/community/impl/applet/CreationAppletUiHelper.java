package com.larus.community.impl.applet;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class CreationAppletUiHelper {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/community/impl/applet/CreationAppletUiHelper$PageExitBehavior;", "", "<init>", "(Ljava/lang/String;I)V", "NATIVE_FINISH", "HOST_BACK", "HOST_CLOSE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PageExitBehavior extends Enum<PageExitBehavior> {
        public static final PageExitBehavior HOST_BACK = null;
        public static final PageExitBehavior HOST_CLOSE = null;
        public static final PageExitBehavior NATIVE_FINISH = null;
        public static final /* synthetic */ PageExitBehavior[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<PageExitBehavior> getEntries() {
            return b;
        }

        static {
            PageExitBehavior r0 = new PageExitBehavior("NATIVE_FINISH", 0);
            NATIVE_FINISH = r0;
            PageExitBehavior r1 = new PageExitBehavior("HOST_BACK", 1);
            HOST_BACK = r1;
            PageExitBehavior r3 = new PageExitBehavior("HOST_CLOSE", 2);
            HOST_CLOSE = r3;
            PageExitBehavior[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static PageExitBehavior[] values() {
            return (PageExitBehavior[]) a.clone();
        }

        public static PageExitBehavior valueOf(String r1) {
            return (PageExitBehavior) r27.a.a(PageExitBehavior.class, r1);
        }

        public PageExitBehavior(String r1, int r2) {
            super(r1, r2);
        }
    }

    static {
    }

    public static View a(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static View c(FragmentActivity r4) {
        View r0 = d(r4, "btn_mini_close");
        View r1 = null;
        if (r0 != null) goto L7;
        r0 = d(r4, "btn_mini_menu");
        if (r0 != null) goto L7;
        return null;
    L7:
        Object r5 = r0.getParent();
        if ((r5 instanceof View) == false) goto L10;
        View r6 = (View) r5;
    L11:
        if (r6 == null) goto L13;
        ViewParent r2 = r6.getParent();
    L15:
        if ((r2 instanceof View) == false) goto L17;
        r1 = (View) r2;
    L17:
        if (r1 != null) goto L22;
        if (r6 != null) goto L23;
        return r0;
    L23:
        return r6;
    L22:
        return r1;
    L13:
        r2 = null;
        goto L15
    L10:
        r6 = null;
        goto L11
    }

    public static boolean h(Bundle r1) {
        cy9.a.a.getClass();
        return cy9.a.e(r1);
    }

    public static t b(Bundle r7, FragmentActivity r8) {
        boolean r0 = f(r7, r8);
        int r3 = 0;
        if (h(r7) == false) goto L7;
        cy9.a.a.getClass();
        if (cy9.a.g(r7) == false) goto L7;
        boolean r9 = true;
    L8:
        if (r0 == false) goto L43;
        if (r8 == null) goto L43;
        Window r2 = r8.getWindow();
        if (r2 == null) goto L43;
        View r4 = a(r2);
        if (r4 == null) goto L43;
        View r5 = d(r8, "applet_action_bar");
        View r6 = null;
        if (r5 != null) goto L18;
    L23:
        View r10 = c(r8);
        if (r10 != null) goto L26;
    L28:
        r5 = r6;
    L29:
        if (r5 == null) goto L43;
        if (r4.getWidth() <= 0) goto L43;
        if (r5.getWidth() <= 0) goto L43;
        int[] r11 = new int[2];
        int[] r12 = new int[2];
        r4.getLocationInWindow(r11);
        r5.getLocationInWindow(r12);
        int r13 = r12[0] - r11[0];
        if (r13 <= 0) goto L43;
        if (r13 >= r4.getWidth()) goto L43;
        r3 = RangesKt.coerceAtLeast(r4.getWidth() - r13, 0);
        goto L43
    L26:
        if (e(r10, r4) == false) goto L28;
        r6 = r10;
        goto L28
    L18:
        if (e(r5, r4) == true) goto L21;
        r5 = null;
    L21:
        if (r5 == null) goto L23;
    L43:
        return new t(r0, r9, r3);
    L7:
        r9 = false;
        goto L8
    }

    public static View d(FragmentActivity r3, String r4) {
        int r5 = r3.getResources().getIdentifier(r4, "id", r3.getPackageName());
        if (r5 != 0) goto L5;
        return null;
    L5:
        Window r6 = r3.getWindow();
        if (r6 == null) goto L11;
        View r7 = a(r6);
        if (r7 != null) goto L10;
        return null;
    L10:
        return r7.findViewById(r5);
    L11:
        return null;
    }

    public static boolean e(View r4, View r5) {
        if (r5.getWidth() > 0) goto L5;
        return false;
    L5:
        if (r4.getWidth() <= 0) goto L19;
        int[] r2 = new int[2];
        int[] r3 = new int[2];
        r5.getLocationInWindow(r2);
        r4.getLocationInWindow(r3);
        int r6 = r3[0] - r2[0];
        if (r6 > 0) goto L10;
        return false;
    L10:
        if (r6 < r5.getWidth()) goto L12;
        return false;
    L12:
        if (r4.getWidth() >= (r5.getWidth() / 2)) goto L18;
        return true;
    L18:
        return false;
    L19:
        return false;
    }

    public static boolean f(Bundle r0, FragmentActivity r1) {
        if (h(r0) == true) goto L8;
        cy9.a.a.getClass();
        if (cy9.a.d(r1) == true) goto L8;
        return false;
    L8:
        return true;
    }

    public static boolean g(Bundle r3, String r4) {
        if (h(r3) == false) goto L21;
        cy9.a.a.getClass();
        if (cy9.a.h(r3) == true) goto L7;
        return false;
    L7:
        if (r4 != null) goto L9;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == true) goto L23;
        if (r3 == null) goto L16;
        String r5 = r3.getString("ai_creation_host_source_profile_user_id");
    L18:
        if (Intrinsics.areEqual(r4, r5) == false) goto L24;
        return true;
    L24:
        return false;
    L16:
        r5 = null;
        goto L18
    L23:
        return false;
    L9:
        if (r4.length() == 0) goto L12;
        r2 = false;
        goto L13
    L21:
        return false;
    }
}
