package com.ss.android.lark.parser.internal;

import com.bytedance.lark.pb.basic.v1.HongbaoCover;
import com.bytedance.lark.pb.basic.v1.ImageSetPassThrough;
import com.ss.android.lark.image.entity.PassThroughImage;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class y {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[HongbaoCover.CoverType.values().length];
            r0[HongbaoCover.CoverType.CUSTOMIZE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[HongbaoCover.CoverType.TEMPLATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public static PassThroughImage a(ImageSetPassThrough r3) {
        return new PassThroughImage(r3.key, r3.fs_unit, r3.crypto);
    }
}
