package nu0;

import com.bytedance.tools.kcp.spongepreference.runtime.SpongePreferenceManager;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k {
    public static final /* synthetic */ KProperty[] a = null;
    public static final com.bytedance.tools.kcp.spongepreference.runtime.a b = null;

    static {
        a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(k.class, "LIVE_FORMAT_VOICE_CHAT_HAS_SEND_GIFT", "getLIVE_FORMAT_VOICE_CHAT_HAS_SEND_GIFT()Z", 1))};
        b = SpongePreferenceManager.a().a("live_format_voice_chat_has_send_gift", Boolean.FALSE, Boolean.TYPE);
    }
}
