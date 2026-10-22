package com.ss.android.lark.chameleonv2.container.webcontainer.view;

import android.webkit.PermissionRequest;
import androidx.core.content.ContextCompat;
import com.ss.android.lark.chameleon.WebMediaPermissionResources;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements com.ss.android.lark.officewebview.quality.safe.permission.b.b {
    public final /* synthetic */ e a;

    public f(e r1) {
        this.a = r1;
    }

    public final void a(String[] r10, int[] r11) {
        Intrinsics.checkNotNullParameter(r10, "permissions");
        Intrinsics.checkNotNullParameter(r11, "grantResults");
        e r0 = this.a;
        PermissionRequest r1 = r0.b;
        if (r1 == null) goto L40;
        r0.b = null;
        List<String> r2 = WebMediaPermissionResources.grantableWebResources(r1.getResources());
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L7:
        if (r4.hasNext() == false) goto L25;
        Object r5 = r4.next();
        List<String> r6 = WebMediaPermissionResources.androidPermissions(CollectionsKt.listOf((String) r5));
        boolean r7 = true;
        if ((r6 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r8 = r6.iterator();
    L15:
        if (r8.hasNext() == false) goto L22;
        if (ContextCompat.checkSelfPermission(r0.a.getContext(), (String) r8.next()) != 0) goto L19;
        boolean r9 = true;
    L20:
        if (r9 == true) goto L15;
        r7 = false;
        goto L22
    L19:
        r9 = false;
    L22:
        if (r7 == false) goto L7;
        r3.add(r5);
        goto L7
    L11:
        if (r6.isEmpty() == false) goto L13;
    L25:
        if (r3.isEmpty() == false) goto L27;
        com.ss.android.lark.officesdk.utils.di.j.e("CML_TAG_PermissionClient", "deny WebView permission after Android permission result permissions=" + Arrays.toString(r10) + " results=" + Arrays.toString(r11));
        e.b(r1);
        return;
    L27:
        r0.g(r1, r3);
        e.e(r1, r3);
        return;
    }
}
