package com.bytedance.android.live.core.utils;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d1 {
    static {
    }

    @JvmStatic
    public static final boolean a(IRoom r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (r1.isGameRoom() != 1) goto L6;
        return true;
    }
}
