package com.lynx.tasm.behavior.ui.accessibility;

import android.os.Build;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LynxAccessibilityHelper {
    public final WeakReference<UIGroup> a;
    public boolean b;
    public final ArrayList<WeakReference<LynxBaseUI>> c;
    public final ArrayList<WeakReference<LynxBaseUI>> d;
    public final HashMap<Integer, WeakReference<LynxBaseUI>> e;

    public static final enum LynxAccessibilityTraits extends Enum<LynxAccessibilityTraits> {
        public static final LynxAccessibilityTraits BUTTON = null;
        public static final LynxAccessibilityTraits IMAGE = null;
        public static final LynxAccessibilityTraits NONE = null;
        public static final /* synthetic */ LynxAccessibilityTraits[] a = null;

        static {
            LynxAccessibilityTraits r0 = new LynxAccessibilityTraits("NONE", 0);
            NONE = r0;
            LynxAccessibilityTraits r1 = new LynxAccessibilityTraits("IMAGE", 1);
            IMAGE = r1;
            LynxAccessibilityTraits r3 = new LynxAccessibilityTraits("BUTTON", 2);
            BUTTON = r3;
            a = new LynxAccessibilityTraits[]{r0, r1, r3};
        }

        public static LynxAccessibilityTraits[] values() {
            return (LynxAccessibilityTraits[]) a.clone();
        }

        public static LynxAccessibilityTraits fromValue(String r5) {
            if (r5 == null) goto L10;
            LynxAccessibilityTraits[] r0 = values();
            int r1 = r0.length;
            int r2 = 0;
        L4:
            if (r2 >= r1) goto L10;
            LynxAccessibilityTraits r3 = r0[r2];
            if (r3.name().equalsIgnoreCase(r5) == true) goto L7;
            r2 = r2 + 1;
            goto L4
        L7:
            return r3;
        L10:
            return NONE;
        }

        public static String getValue(LynxAccessibilityTraits r1) {
            int r2 = a.a[r1.ordinal()];
            if (r2 != 1) goto L5;
            return "android.widget.ImageView";
        L5:
            if (r2 == 2) goto L8;
            return "android.view.View";
        L8:
            return "android.widget.Button";
        }

        public static LynxAccessibilityTraits valueOf(String r1) {
            return (LynxAccessibilityTraits) r27.a.a(LynxAccessibilityTraits.class, r1);
        }

        public LynxAccessibilityTraits(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[LynxAccessibilityTraits.values().length];
            a = r0;
            r0[LynxAccessibilityTraits.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            a[LynxAccessibilityTraits.BUTTON.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public LynxAccessibilityHelper(UIGroup r2) {
        this.b = false;
        this.c = null;
        this.d = null;
        this.e = null;
        if (r2.getView() != 0) goto L6;
        LLog.e("LynxAccessibilityHelper", "Construct LynxAccessibilityHelper with null host ui or view");
        return;
    L6:
        this.a = new WeakReference(r2);
        this.d = new ArrayList();
        this.c = new ArrayList();
        this.e = new HashMap();
    }

    public static void c(LynxBaseUI r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.getChildren() == null) goto L16;
        int r0 = r5.getChildren().size();
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L17;
        LynxBaseUI r2 = r5.getChildAt(r1);
        if ((r2 instanceof LynxUI) == false) goto L11;
        ViewCompat.setImportantForAccessibility(((LynxUI) r2).getView(), 2);
    L11:
        c(r2);
        r1 = r1 + 1;
        goto L7
    L17:
        return;
    }

    public final boolean a(LynxBaseUI r6) {
        if (r6 != null) goto L5;
        return false;
    L5:
        int r1 = r6.getAccessibilityElementStatus();
        if (r1 != (-1)) goto L8;
        boolean r2 = this.b;
    L11:
        WeakReference<UIGroup> r3 = this.a;
        if (r3 == null) goto L14;
        UIGroup r4 = r3.get();
    L15:
        if (r2 == false) goto L26;
        if (r4 == null) goto L26;
        if (this.e.isEmpty() == true) goto L26;
    L19:
        if (r6 == null) goto L25;
        if (r6 == r4) goto L25;
        if (this.e.containsKey(Integer.valueOf(r6.getSign())) == true) goto L23;
        r6 = r6.getParentBaseUI();
        goto L19
    L23:
        return true;
    L25:
        return false;
    L26:
        return r2;
    L14:
        r4 = null;
        goto L15
    L8:
        if (r1 != 1) goto L10;
        r2 = true;
        goto L11
    L10:
        r2 = false;
        goto L11
    }

    public final void b(LynxBaseUI r8) {
        if (Build.VERSION.SDK_INT < 22) goto L47;
        WeakReference<UIGroup> r0 = this.a;
        if (r0 != null) goto L7;
    L13:
        LynxUIOwner r1 = null;
    L14:
        if (r8 == null) goto L58;
        if (r1 != null) goto L17;
        return;
    L17:
        if (r8.getAccessibilityElementsA11y() == null) goto L19;
    L21:
        c(r8);
        ArrayList<String> r2 = r8.getAccessibilityElementsA11y();
        int r3 = 0;
        if (r2 != null) goto L24;
        r2 = r8.getAccessibilityElements();
        boolean r9 = false;
    L25:
        ArrayList r4 = new ArrayList();
        Iterator<String> r5 = r2.iterator();
    L27:
        if (r5.hasNext() == false) goto L39;
        String r6 = r5.next();
        if (r6 == null) goto L27;
        if (r9 == false) goto L32;
        LynxBaseUI r7 = r1.findLynxUIByA11yId(r6);
    L34:
        if ((r7 instanceof LynxUI) == false) goto L27;
        LynxUI r10 = (LynxUI) r7;
        if (r10.getView() == null) goto L27;
        ViewCompat.setImportantForAccessibility(r10.getView(), 1);
        r4.add(r10);
        goto L27
    L32:
        r7 = r1.findLynxUIByIdSelector(r6);
        goto L34
    L39:
        if (r4.isEmpty() == false) goto L41;
        return;
    L41:
        if (r4.size() == 1) goto L62;
        int r11 = r4.size();
    L45:
        if (r3 >= (r11 - 1)) goto L63;
        LynxUI r12 = (LynxUI) ListProtector.get(r4, r3);
        r3 = r3 + 1;
        LynxUI r13 = (LynxUI) ListProtector.get(r4, r3);
        View r14 = r12.getView();
        View r15 = r13.getView();
        r14.setId(r12.getSign());
        r15.setId(r13.getSign());
        r14.setAccessibilityTraversalBefore(r13.getSign());
        goto L45
    L63:
        return;
    L62:
        return;
    L24:
        r9 = true;
        goto L25
    L19:
        if (r8.getAccessibilityElements() != null) goto L21;
        return;
    L58:
        return;
    L7:
        if (r0.get() == null) goto L13;
        UIGroup r16 = this.a.get();
        if (r16 == null) goto L13;
        if (r16.getLynxContext() == null) goto L13;
        r1 = r16.getLynxContext().getLynxUIOwner();
        goto L14
    }
}
