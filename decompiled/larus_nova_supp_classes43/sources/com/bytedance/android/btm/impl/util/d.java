package com.bytedance.android.btm.impl.util;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public static final d a = null;

    public d() {
    }

    static {
        a = new d();
    }

    public static Map.Entry a(Map r10) {
        Iterator r11 = r10.entrySet().iterator();
        Map.Entry r0 = null;
    L4:
        if (r11.hasNext() == false) goto L6;
        r0 = (Map.Entry) r11.next();
        goto L4
    L6:
        return r0;
    }

    public final Activity getActivity(View r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        if (BtmSetting.d.c().b().t() == 1) goto L8;
    L11:
        Context r11 = r10.getContext();
    L12:
        if (r11 == null) goto L20;
        if ((r11 instanceof Activity) == true) goto L16;
        if ((r11 instanceof ContextWrapper) == false) goto L20;
        r11 = ((ContextWrapper) r11).getBaseContext();
        goto L12
    L16:
        return (Activity) r11;
    L20:
        return null;
    L8:
        if (Intrinsics.areEqual(r10.getClass().getName(), "com.android.internal.policy.DecorView") == false) goto L11;
        return getActivity(r10.findViewById(R.id.content));
    }

    public final Activity getActivity(Object r10) {
        if ((r10 instanceof Activity) == false) goto L7;
        return (Activity) r10;
    L7:
        if ((r10 instanceof Fragment) == false) goto L11;
        return ((Fragment) r10).getActivity();
    L11:
        if ((r10 instanceof Dialog) == false) goto L15;
        return getActivity((Dialog) r10);
    L15:
        if ((r10 instanceof View) == true) goto L17;
        return null;
    L17:
        return getActivity((View) r10);
    }

    public final Activity getActivity(Dialog r10) {
        if (r10 == null) goto L5;
        Context r11 = r10.getContext();
    L6:
        if (r11 == null) goto L14;
        if ((r11 instanceof Activity) == true) goto L10;
        if ((r11 instanceof ContextWrapper) == false) goto L14;
        r11 = ((ContextWrapper) r11).getBaseContext();
        goto L6
    L10:
        return (Activity) r11;
    L14:
        return null;
    L5:
        r11 = null;
        goto L6
    }
}
