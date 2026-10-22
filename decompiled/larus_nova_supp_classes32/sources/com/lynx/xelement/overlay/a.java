package com.lynx.xelement.overlay;

import android.app.Dialog;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.devtoolwrapper.DevToolOverlayDelegate;
import com.lynx.devtoolwrapper.OverlayService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public static final List<b> a = null;
    public static int b;

    /* JADX INFO: renamed from: com.lynx.xelement.overlay.a$a, reason: collision with other inner class name */
    public static final class C0070a implements OverlayService {
        public C0070a() {
        }

        @Override // com.lynx.devtoolwrapper.OverlayService
        public final ArrayList<Integer> getAllVisibleOverlaySign() {
            List<b> r0 = a.a;
            ArrayList<Integer> r1 = new ArrayList();
            Iterator r2 = ((ArrayList) a.a).iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            r1.add(Integer.valueOf(((b) r2.next()).b.a.a.getSign()));
            goto L4
        L6:
            return r1;
        }

        @Override // com.lynx.devtoolwrapper.OverlayService
        public final ArrayList<Dialog> getGlobalOverlayView() {
            List<b> r0 = a.a;
            ArrayList<Dialog> r1 = new ArrayList();
            Iterator r2 = ((ArrayList) a.a).iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            r1.add(((b) r2.next()).b);
            goto L4
        L6:
            return r1;
        }
    }

    public static final class b {
        public final String a;
        public final LynxOverlayDialog b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "OverlayData(id=" + this.a + ", dialog=" + this.b + ')';
        }

        public b(String r2, LynxOverlayDialog r3) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r3, "dialog");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
        a = new ArrayList();
        DevToolOverlayDelegate.getInstance().init(new C0070a());
    }

    public static String a(LynxOverlayDialog r4) {
        Intrinsics.checkNotNullParameter(r4, "dialog");
        StringBuilder r0 = new StringBuilder("default_overlay_id_");
        int r1 = b;
        b = r1 + 1;
        r0.append(r1);
        String r2 = r0.toString();
        int r3 = r4.e.intValue();
        ListIterator r5 = ((ArrayList) a).listIterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        if (r3 > ((b) r5.next()).b.e.intValue()) goto L4;
        r5.previous();
        r5.add(new b(r2, r4));
        return r2;
    L9:
        List<b> r6 = a;
        ArrayList r7 = (ArrayList) r6;
        r7.add(new b(r2, r4));
        return r2;
    }

    public static boolean b(MotionEvent r9, LynxOverlayDialog r10) {
        Intrinsics.checkNotNullParameter(r9, "ev");
        Intrinsics.checkNotNullParameter(r10, "overlay");
        Iterator r0 = ((ArrayList) a).iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        b r1 = (b) r0.next();
        if (r1.b.d(r9) == false) goto L4;
        if (Intrinsics.areEqual(r10, r1.b) == true) goto L4;
        return r1.b.f(r9);
    L11:
        ArrayList r11 = (ArrayList) a;
        Fragment r2 = null;
        if ((!r11.isEmpty()) == true) goto L15;
        r11 = null;
    L15:
        boolean r3 = false;
        if (r11 == null) goto L54;
        LynxOverlayDialog r12 = ((b) ListProtector.get(r11, 0)).b;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r9, "event");
        FragmentActivity r4 = com.lynx.tasm.utils.a.getActivity(r12.a.getLynxContext());
        String r5 = r12.d;
        if (r5 != null) goto L20;
    L23:
        boolean r6 = true;
    L25:
        if (r6 == true) goto L45;
        PointF r7 = new PointF(r9.getRawX(), r9.getRawY());
        if ((r4 instanceof FragmentActivity) == false) goto L29;
        FragmentActivity r8 = r4;
    L30:
        if (r8 == null) goto L32;
        Fragment r13 = LynxOverlayDialog.b(r8.getSupportFragmentManager(), r12.d, r7);
    L34:
        if ((r13 instanceof Fragment) == false) goto L36;
        r2 = r13;
    L36:
        if (r2 == null) goto L57;
        float r14 = r12.c();
        r9.offsetLocation(-0.0f, -r14);
        if ((r2 instanceof DialogFragment) == false) goto L41;
        r3 = ((DialogFragment) r2).getDialog().dispatchTouchEvent(r9);
    L44:
        r9.offsetLocation(0.0f, r14);
        return r3;
    L41:
        View r15 = r2.getView();
        if (r15 == null) goto L44;
        int[] r16 = new int[2];
        r15.getLocationOnScreen(r16);
        float r17 = r16[0];
        float r18 = r16[1];
        r9.offsetLocation(-r17, -r18);
        boolean r19 = r15.dispatchTouchEvent(r9);
        r9.offsetLocation(r17, r18);
        r3 = r19;
        goto L44
    L57:
        return false;
    L32:
        r13 = null;
        goto L34
    L29:
        r8 = null;
        goto L30
    L45:
        if (r4 == null) goto L56;
        float r110 = r12.c();
        r9.offsetLocation(-0.0f, -r110);
        boolean r20 = r4.dispatchTouchEvent(r9);
        r9.offsetLocation(0.0f, r110);
        return r20;
    L56:
        return false;
    L20:
        if (r5.length() == 0) goto L23;
        r6 = false;
        goto L25
    L54:
        return false;
    }
}
