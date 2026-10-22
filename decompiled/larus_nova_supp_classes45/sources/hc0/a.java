package hc0;

import android.content.Context;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.livesdk.config.cd1;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.mt.protector.impl.UriProtector;
import jc1.k;
import kotlin.jvm.JvmStatic;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import pb0.b;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final void a(Context r5) {
        ReadOnlyProperty r0 = h.P1;
        KProperty[] r1 = h.a;
        String r3 = ((cd1) r0.getValue(null, r1[144(0x90, float:2.02E-43)])).b();
        String r2 = UriProtector.parse(((cd1) r0.getValue(null, r1[144(0x90, float:2.02E-43)])).a()).buildUpon().appendQueryParameter(LiveSlardarConstants.EXTRA_KEY_URL, r3).build().toString();
        k.n(IBaseLiveActionHandler.class).handle(r5, r2);
        pb0.a r6 = b.a;
        if (r6 == null) goto L6;
        r6.a();
        return;
    }
}
