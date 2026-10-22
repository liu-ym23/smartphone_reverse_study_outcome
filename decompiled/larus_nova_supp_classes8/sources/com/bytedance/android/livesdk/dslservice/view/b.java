package com.bytedance.android.livesdk.dslservice.view;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.SliceRender;
import com.bytedance.android.ecom.arch.slice.render.elements.ElementTypes;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import yt1.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b {
    public static final HashMap<String, f<? extends View>> a = null;
    public static final HashMap<String, f<? extends View>> b = null;
    public static final HashMap<String, f<? extends View>> c = null;

    static {
        a = new HashMap();
        b = new HashMap();
        c = new HashMap();
    }

    public static void a(String r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, LiveEndPageData.TAG_NAME);
        Intrinsics.checkNotNullParameter(r3, "provider");
        HashMap<String, f<? extends View>> r0 = c;
        if (r0.containsKey(r2) == false) goto L5;
        return;
    L5:
        r0.put(r2, r3);
        SliceRender r1 = SliceRender.o;
        DSLCustomViewMap$register2Slice$1 r4 = new DSLCustomViewMap$register2Slice$1(r3);
        r1.getClass();
        ElementTypes.b(r2, r4);
    }

    public static void b(String r2, f r3) {
        Intrinsics.checkNotNullParameter(r2, LiveEndPageData.TAG_NAME);
        Intrinsics.checkNotNullParameter(r3, "provider");
        HashMap<String, f<? extends View>> r0 = a;
        if (r0.containsKey(r2) == false) goto L5;
        return;
    L5:
        r0.put(r2, r3);
        SliceRender r1 = SliceRender.o;
        DSLCustomViewMap$register2Slice$1 r4 = new DSLCustomViewMap$register2Slice$1(r3);
        r1.getClass();
        ElementTypes.b(r2, r4);
    }
}
