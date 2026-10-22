package com.ss.android.lark.framework.assembly.navigation;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.ss.android.lark.utils.navigation.Navigation;
import hjb.a;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class InitNavigationTask extends AbstractLaunchTask {
    public InitNavigationTask() {
    }

    public final void a(Context r6) {
        HashSet<String> r0 = a.a;
        Intrinsics.checkNotNullParameter(r6, "context");
        boolean r1 = false;
        if ((r6.getResources().getConfiguration().screenLayout & 15) < 3) goto L5;
        boolean r7 = true;
    L6:
        if (r7 == false) goto L13;
        String r8 = Build.BRAND;
        Iterator<String> r2 = a.a.iterator();
    L9:
        if (r2.hasNext() == false) goto L13;
        String r3 = r2.next().toLowerCase();
        Intrinsics.checkNotNull(r8);
        if (TextUtils.equals(r3, r8.toLowerCase()) == false) goto L9;
        r1 = true;
    L13:
        Navigation.setIsNavigationEnable(!r1);
        return;
    L5:
        r7 = false;
        goto L6
    }
}
