package com.bytedance.android.livesdk.chatroom.ui.framework.base;

import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g {
    public static final LayerDescriptorList b(com.bytedance.android.livesdk.widgetdescriptor.m r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$getFirstScreenList");
        LayerDescriptorList r0 = new LayerDescriptorList();
        r0.addAll(r2.c());
        r0.addAll(r2.b());
        return r0;
    }

    public static final LayerDescriptorList c(com.bytedance.android.livesdk.widgetdescriptor.m r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$getPreloadList");
        LayerDescriptorList r0 = new LayerDescriptorList();
        r0.addAll(r2.e());
        r0.addAll(r2.k());
        return r0;
    }

    public static final LinkedHashMap<f70.b, LayerDescriptorList> a(com.bytedance.android.livesdk.widgetdescriptor.m r2, boolean r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$getDescriptorMap");
        LayerDescriptorList r0 = new LayerDescriptorList();
        if (r3 == true) goto L6;
        if (r4 == true) goto L6;
        r0.addAll(r2.e());
        r0.addAll(r2.c());
    L9:
        r0.addAll(r2.g());
        r0.addAll(r2.i());
        r0.addAll(r2.j());
        r0.addAll(r2.d());
        LayerDescriptorList r1 = new LayerDescriptorList();
        if (r3 == true) goto L13;
        if (r4 == true) goto L13;
        r1.addAll(r2.k());
        r1.addAll(r2.b());
    L16:
        r1.addAll(r2.h());
        r1.addAll(r2.f());
        LinkedHashMap<f70.b, LayerDescriptorList> r5 = new LinkedHashMap();
        r5.put(mg2.e.c, r0);
        r5.put(mg2.e.e, r1);
        return r5;
    L13:
        if (r3 == false) goto L16;
        if (r4 == true) goto L16;
        r1.addAll(r2.b());
    L6:
        if (r3 == false) goto L9;
        if (r4 == true) goto L9;
        r0.addAll(r2.c());
        goto L9
    }
}
