package com.obric.aikernel.legacy;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.keva.KevaImpl;
import com.google.gson.k;
import com.obric.aikernel.sdk.data.PackageResource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4495a = null;

    static {
        f4495a = new a();
    }

    private a() {
    }

    public final String a(PackageResource r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        k r11 = new k();
        r11.n("scriptReady", Boolean.valueOf(r10.isAvailable()));
        k r12 = new k();
        List<PackageResource> r13 = r10.getSubRes();
        if (r13 == null) goto L21;
        ArrayList r14 = new ArrayList();
        Iterator<T> r15 = r13.iterator();
    L5:
        boolean r16 = true;
        if (r15.hasNext() == false) goto L13;
        Object r17 = r15.next();
        if (((PackageResource) r17).getType() == 1) goto L11;
        r16 = false;
    L11:
        if (r16 == false) goto L5;
        r14.add(r17);
        goto L5
    L13:
        Iterator r18 = r14.iterator();
    L15:
        if (r18.hasNext() == false) goto L21;
        PackageResource r19 = (PackageResource) r18.next();
        String r20 = r19.getName() + '@' + r19.getVersion();
        k r21 = new k();
        boolean r22 = r19.isAvailable();
        if (r22 == false) goto L19;
        String r23 = "DOWNLOADED";
    L20:
        r21.p("status", r23);
        k r24 = new k();
        String r25 = r19.getName();
        k r26 = new k();
        r26.o("first", Integer.valueOf(r22 ? 1 : 0));
        r26.o("second", 1);
        Unit r27 = Unit.INSTANCE;
        r24.m(r25, r26);
        r21.m(KevaImpl.PrivateConstants.FILES_DIR_NAME, r24);
        r12.m(r20, r21);
        goto L15
    L19:
        r23 = "NEED_DOWNLOAD";
    L21:
        Unit r110 = Unit.INSTANCE;
        r11.m("modelStatus", r12);
        r11.p(WsConstants.KEY_EXTRA, "");
        String r28 = r11.toString();
        Intrinsics.checkNotNullExpressionValue(r28, "JsonObject().apply {\n   … \"\")\n        }.toString()");
        return r28;
    }
}
