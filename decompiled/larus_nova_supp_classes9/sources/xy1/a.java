package xy1;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a {
    public static final /* synthetic */ KProperty[] a = null;
    public static final ReadOnlyProperty b = null;

    static {
        KProperty[] r1 = {Reflection.property0(new PropertyReference0Impl(a.class, "COMMENT_GIFT_GUIDE_CONFIG", "getCOMMENT_GIFT_GUIDE_CONFIG()Lcom/bytedance/android/livesdk/gift/guide/model/RevCommentGiftGuideConfig;", 1))};
        a = r1;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r0 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("comment_gift_guide_config", new zy1.b(), zy1.b.class, false);
        b = UltraSettingsManager.a().a(r0.a, r0.b, r0.getType(), r0.d, r1[0]);
    }

    public static final zy1.b a() {
        return (zy1.b) b.getValue(null, a[0]);
    }
}
