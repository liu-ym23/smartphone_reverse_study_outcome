package y12;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ KProperty[] a = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a b = null;

    static {
        a = new KProperty[]{Reflection.property0(new PropertyReference0Impl(a.class, "VS_BLOCK_GIFT_FOR_TEST", "getVS_BLOCK_GIFT_FOR_TEST()Z", 1))};
        b = SpongePreferenceManager.a().a("vs_block_gift_for_test", Boolean.FALSE, Boolean.TYPE);
    }
}
