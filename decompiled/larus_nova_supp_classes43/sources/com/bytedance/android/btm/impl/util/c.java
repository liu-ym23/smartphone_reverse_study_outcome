package com.bytedance.android.btm.impl.util;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.model.PageFinder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(PageFinder r10) {
        if (r10 != null) goto L5;
        return "null";
    L5:
        Object r1 = r10.page;
        String r11 = null;
        if (r1 == null) goto L8;
        String r12 = r1.getClass().getCanonicalName();
    L9:
        View r13 = r10.view;
        if (r13 == null) goto L12;
        String r14 = r13.getClass().getCanonicalName();
    L13:
        Fragment r15 = r10.fragment;
        if (r15 == null) goto L16;
        r11 = r15.getClass().getCanonicalName();
    L16:
        if (r12 != null) goto L26;
        if (r14 != null) goto L27;
        if (r11 != null) goto L28;
        String r16 = r10.btmPageId;
        if (r16 != null) goto L25;
        return "null";
    L25:
        return r16;
    L28:
        return r11;
    L27:
        return r14;
    L26:
        return r12;
    L12:
        r14 = null;
        goto L13
    L8:
        r12 = null;
        goto L9
    }

    public static String b(PageFinder r10) {
        String r0 = "null";
        if (r10 != null) goto L5;
        return "null";
    L5:
        StringBuilder r1 = new StringBuilder("page: ");
        Object r11 = r10.page;
        if (r11 == null) goto L10;
        String r12 = r11.getClass().getCanonicalName();
        if (r12 == null) goto L10;
    L11:
        View r13 = r10.view;
        if (r13 == null) goto L16;
        String r14 = r13.getClass().getCanonicalName();
        if (r14 == null) goto L16;
    L17:
        Fragment r15 = r10.fragment;
        if (r15 == null) goto L22;
        String r16 = r15.getClass().getCanonicalName();
        if (r16 == null) goto L22;
        r0 = r16;
    L22:
        r1.append(r12);
        r1.append(", view: ");
        r1.append(r14);
        r1.append(", fragment: ");
        r1.append(r0);
        String r17 = r10.btmPageId;
        if (r17 != null) goto L25;
        String r18 = "false";
    L32:
        r1.append(", has_page_id: ");
        r1.append(r18);
        return r1.toString();
    L25:
        if (r17.length() != 0) goto L27;
        boolean r19 = true;
    L28:
        if (r19 == false) goto L30;
        r18 = "empty";
        goto L32
    L30:
        r18 = "true";
        goto L32
    L27:
        r19 = false;
    L16:
        r14 = "null";
    L10:
        r12 = "null";
        goto L11
    }
}
