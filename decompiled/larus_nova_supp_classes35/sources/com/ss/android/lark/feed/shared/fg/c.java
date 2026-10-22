package com.ss.android.lark.feed.shared.fg;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.api.bean.ForsetiMode;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static final peb.b.f a = null;

    static {
        a = heb.a.a.getFeatureGatingDependency();
    }

    @JvmStatic
    public static final boolean a() {
        if (a.isCurrentEnable("im.feed.priority_message") == false) goto L7;
        int r0 = neb.c.a;
        if (((neb.a) k.a(LarkContext.getApplication(), neb.a.class)).e1() == false) goto L7;
        return true;
    L7:
        return false;
    }

    @JvmStatic
    public static final boolean c() {
        return a.isEnable("lark.feed.feed_click_hint");
    }

    @JvmStatic
    public static final boolean b(FragmentActivity r2) {
        if (r2 != null) goto L6;
        return false;
    L6:
        if (ForsetiConfig.a(r2) == true) goto L8;
        return false;
    L8:
        if (c() == false) goto L18;
        tua.b r3 = ((sua.a) ApiUtils.getApi(sua.a.class)).tryGetChainManager(r2);
        if (r3 == null) goto L12;
        ForsetiMode r4 = r3.T();
    L14:
        if (r4 != ForsetiMode.Regular) goto L19;
        return true;
    L19:
        return false;
    L12:
        r4 = null;
        goto L14
    L18:
        return false;
    }
}
