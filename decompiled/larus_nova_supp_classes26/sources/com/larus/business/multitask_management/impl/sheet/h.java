package com.larus.business.multitask_management.impl.sheet;

import android.view.ViewGroup;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.multitask_management.api.data.quick_access.NodeType;
import com.larus.utils.j0;
import v19.c7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class h {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[NodeType.values().length];
            r0[NodeType.DOCUMENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[NodeType.PPT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[NodeType.SHEET.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[NodeType.FOLDER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[NodeType.FILE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[NodeType.UNKNOWN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    public static final void a(SimpleDraweeView r6, NodeType r7) {
        int r0 = 0;
        switch(a.a[r7.ordinal()]) {
            case 1: goto L5;
            case 2: goto L5;
            case 3: goto L5;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        boolean r8 = false;
    L6:
        GenericDraweeHierarchy r1 = r6.getHierarchy();
        float r2 = 0.0f;
        if (r8 == false) goto L9;
        float r3 = 0.0f;
    L10:
        RoundingParams r4 = RoundingParams.fromCornersRadius(r3);
        if (r8 == true) goto L14;
        r2 = c7.c(Double.valueOf(0.5d));
    L14:
        r4.setBorderWidth(r2);
        if (r8 == true) goto L18;
        int r9 = j0.a;
        r0 = j0.a(v19.c.b(2130972086, r6.getContext(), 2131103159));
    L18:
        r4.setBorderColor(r0);
        r1.setRoundingParams(r4);
        return;
    L9:
        r3 = c7.c(8);
        goto L10
    L5:
        r8 = true;
        goto L6
    }

    public static final void b(SimpleDraweeView r2, NodeType r3) {
        int r4 = a.a[r3.ordinal()];
        boolean r0 = true;
        if (r4 != 1) goto L5;
    L11:
        if (r0 == false) goto L13;
        float r5 = c7.c(-2);
    L14:
        r2.setTranslationX(r5);
        if (r0 == false) goto L17;
        int r6 = c7.b(36);
    L18:
        ViewGroup.LayoutParams r1 = r2.getLayoutParams();
        if (r1 != null) goto L22;
        return;
    L22:
        if (r1.width == r6) goto L24;
    L26:
        r1.width = r6;
        r1.height = r6;
        r2.setLayoutParams(r1);
        return;
    L24:
        if (r1.height != r6) goto L26;
        return;
    L17:
        r6 = c7.b(32);
        goto L18
    L13:
        r5 = 0.0f;
        goto L14
    L5:
        if (r4 == 2) goto L11;
        if (r4 == 3) goto L11;
        if (r4 == 4) goto L11;
        r0 = false;
        goto L11
    }
}
