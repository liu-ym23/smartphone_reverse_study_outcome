package com.bytedance.lego.init.util;

import com.bytedance.lego.init.config.ProcessMatchMode;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 13})
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f2801a = null;

    static {
        int[] r0 = new int[ProcessMatchMode.values().length];
        f2801a = r0;
        r0[ProcessMatchMode.ENDWITH.ordinal()] = 1;
        r0[ProcessMatchMode.CONTAIN.ordinal()] = 2;
    }
}
