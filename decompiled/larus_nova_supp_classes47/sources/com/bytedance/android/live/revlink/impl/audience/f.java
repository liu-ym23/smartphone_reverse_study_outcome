package com.bytedance.android.live.revlink.impl.audience;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f {
    public static final ReadOnlyProperty e = null;
    public int a;
    public long b;
    public boolean c;
    public final com.bytedance.android.live.revlink.impl.global.c d;

    public static final class a {
        public static final /* synthetic */ KProperty[] a = null;

        static {
            a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, "reportIllegalPkLayout", "getReportIllegalPkLayout()Z", 0))};
        }

        public a() {
        }
    }

    static {
        new a();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r0 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("revlink_audience_report_illegal_pk_layout", Boolean.TRUE, Boolean.TYPE, false);
        KProperty r10 = a.a[0];
        e = UltraSettingsManager.a().a(r0.a, r0.b, r0.getType(), r0.d, r10);
    }

    public f(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.b r1) {
        this.d = r1;
        b03.a r2 = b03.a.a;
        s1.w();
        PadConfigUtils.a();
    }
}
