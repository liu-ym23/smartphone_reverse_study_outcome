package com.bytedance.android.annie;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.annie.container.dialog.AnnieDialog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public static c a;
    public static volatile boolean b;
    public static volatile AnnieDialog c;

    static {
    }

    public static FragmentActivity a(Context r1, com.bytedance.android.annie.param.a r10) {
        if ((r1 instanceof FragmentActivity) == false) goto L7;
        return (FragmentActivity) r1;
    L7:
        if ((r1 instanceof ContextWrapper) == true) goto L9;
        r10.d.a("AnnieInner", "get context error, context is not excepted type or null");
        return null;
    L9:
        return a(((ContextWrapper) r1).getBaseContext(), r10);
    }
}
