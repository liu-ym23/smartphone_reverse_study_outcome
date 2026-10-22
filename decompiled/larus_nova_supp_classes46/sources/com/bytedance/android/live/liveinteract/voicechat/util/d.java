package com.bytedance.android.live.liveinteract.voicechat.util;

import kotlin.jvm.JvmStatic;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public static final a a = null;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static int a() {
            ReadOnlyProperty r0 = vm2.d.R;
            KProperty[] r1 = vm2.d.a;
            if (((Boolean) r0.getValue(null, r1[41])).booleanValue() == false) goto L7;
            return 2;
        L7:
            if (((Boolean) vm2.d.z6.getValue(null, r1[387(0x183, float:5.42E-43)])).booleanValue() == false) goto L10;
            return 1;
        L10:
            return 0;
        }
    }

    static {
        a = new a();
    }
}
