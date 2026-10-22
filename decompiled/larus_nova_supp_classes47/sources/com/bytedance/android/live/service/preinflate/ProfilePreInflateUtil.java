package com.bytedance.android.live.service.preinflate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import rs0.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ProfilePreInflateUtil {
    public static final Lazy a = null;
    public static int b;
    public static int c;
    public static int d;
    public static int e;
    public static final List<String> f = null;

    static {
        a = LazyKt.lazy(ProfilePreInflateUtil$DELAY_TIME$2.INSTANCE);
        f = new ArrayList();
    }

    public static boolean a() {
        if (((Number) m0.a.getValue()).intValue() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static void b(a r4, ProfilePreInflateViewInfo r5) {
        int r0 = r5.getCount() - r4.c(r5.getResId());
        ALogger.i("NewUserProfile_PreLayout", "fullWannaCache, tag = " + r5.getTag() + ", repeatCount = " + r0);
        if (r0 <= 0) goto L7;
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L9;
        r4.d(r5.getResId(), r5.getContainerViewClass());
        r1 = r1 + 1;
        goto L5
    L9:
        return;
    }

    public static void d(FragmentActivity r1, List r2) {
        Intrinsics.checkNotNullParameter(r1, "activity");
        Intrinsics.checkNotNullParameter(r2, "preViewInfos");
        a r3 = ViewPools.a(r1);
        Iterator r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        b(r3, (ProfilePreInflateViewInfo) r4.next());
        goto L4
    }

    public static View c(ProfilePreInflateViewInfo r4, Context r5, LayoutInflater r6, ViewGroup r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r4, "viewInfo");
        Intrinsics.checkNotNullParameter(r6, "fallbackInflater");
        r4.setUsed(true);
        FragmentActivity r1 = ContextUtil.contextToFragmentActivity(r5);
        if (r1 != null) goto L5;
        boolean r2 = false;
    L6:
        ALogger.i("NewUserProfile_PreLayout", "check hasCachedView, tag = " + r4.getTag() + ", layoutId = " + r4.getResId() + " has cache view: " + r2);
        e = e + 1;
        if (r2 == false) goto L9;
        d++;
    L9:
        FragmentActivity r9 = ContextUtil.contextToFragmentActivity(r5);
        if (r9 != null) goto L13;
        ALogger.e("NewUserProfile_PreLayout", "inflate error, activity is null, tag = " + r4.getTag());
        return r6.inflate(r4.getResId(), r7, r8);
    L13:
        ALogger.i("NewUserProfile_PreLayout", "get cache view from view pool");
        View r10 = ViewPools.a(r9).b(r4.getResId(), r7, r8);
        a r12 = ViewPools.a(r9);
        ArrayList r13 = (ArrayList) f;
        if (r13.contains(r4.getTag()) == false) goto L16;
        ALogger.i("NewUserProfile_PreLayout", "commit delay task fail, tag = " + r4.getTag() + " is in delay list");
    L17:
        return r10;
    L16:
        ALogger.i("NewUserProfile_PreLayout", "commit delay task success, tag = " + r4.getTag());
        r13.add(r4.getTag());
        r12.e(((Number) a.getValue()).longValue(), new b(r12, r4));
        goto L17
    L5:
        r2 = ViewPools.a(r1).a(r4.getResId());
        goto L6
    }
}
