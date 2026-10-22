package com.bytedance.ies.bullet.kit.web.impl;

import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.bytedance.ies.bullet.kit.web.j;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthSuccessCode;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements aj.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f5508a;

    public c(i r5) {
        this.f5508a = r5;
    }

    @Override // aj.a
    public final li.c a(bj.a r13, IDLXBridgeMethod r14) {
        Intrinsics.checkNotNullParameter(r13, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r14, "method");
        i r12 = this.f5508a;
        if (r12.f5524c == null) goto L5;
        j r15 = (j) r12.d().f5307v.f1119c;
        if (r15 != null) goto L10;
        r15 = null;
    L10:
        if (r15 == null) goto L36;
        ArrayList r5 = r15.f5539n;
        ArrayList r10 = r15.f5538m;
        if (r10.isEmpty() == false) goto L15;
        r10 = r15.f5537l;
    L15:
        if (r5.isEmpty() == false) goto L17;
    L20:
        String r16 = Uri.parse(r13.d()).getHost();
        if (r16 == null) goto L36;
        if (r14.getAccess() == IDLXBridgeMethod.Access.e) goto L36;
        if (r10.isEmpty() == true) goto L36;
        Iterator r17 = r10.iterator();
    L28:
        if (r17.hasNext() == false) goto L36;
        String r18 = (String) r17.next();
        if (Intrinsics.areEqual(r16, r18) == true) goto L34;
        if (StringsKt.k(r16, td.d.b(".", r18)) == false) goto L28;
    L34:
        return new li.c(true, null, null, AuthSuccessCode.d, 44);
    L17:
        if (r5.contains(r14.getName()) == false) goto L20;
        return new li.c(true, null, null, AuthSuccessCode.f7320c, 44);
    L36:
        return new li.c(true, null, null, null, 62);
    L5:
        return new li.c(true, null, null, null, 62);
    }
}
