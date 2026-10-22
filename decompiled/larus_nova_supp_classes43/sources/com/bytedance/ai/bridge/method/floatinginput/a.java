package com.bytedance.ai.bridge.method.floatinginput;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.bridge.core.AIBridgeMethod;
import com.bytedance.ai.utils.g;
import d3.a0;
import k2.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.floatinginput.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0024a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ContainerType.values().length];
            r0[ContainerType.PAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            a = r0;
        }
    }

    public static final j a(AIBridgeMethod r10, e3.d r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        a0 r0 = r11.getContainerContext();
        j r1 = null;
        if (r0 == null) goto L5;
        ContainerType r12 = r0.getContainerType();
    L6:
        if (r12 != null) goto L8;
        int r13 = -1;
    L10:
        if (r13 != 1) goto L12;
        r1 = (j) r11.d(j.class);
    L12:
        g.a.d("FloatingSpeaker", r10.getName() + " getAIContainerView " + r1);
        return r1;
    L8:
        r13 = C0024a.a[r12.ordinal()];
        goto L10
    L5:
        r12 = null;
        goto L6
    }
}
