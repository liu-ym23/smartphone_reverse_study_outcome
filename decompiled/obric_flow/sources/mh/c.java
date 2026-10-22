package mh;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.pia.core.metrics.PvEventType;
import com.bytedance.pia.core.plugins.BootPlugin;
import com.bytedance.pia.core.plugins.BridgeDowngradePlugin;
import com.bytedance.pia.core.plugins.BridgePlugin;
import com.bytedance.pia.core.plugins.HtmlPlugin;
import com.bytedance.pia.core.plugins.ManifestPlugin;
import com.bytedance.pia.core.plugins.NsrPlugin;
import com.bytedance.pia.core.plugins.PiaPropsPlugin;
import com.bytedance.pia.core.plugins.PrefetchPlugin;
import com.bytedance.pia.core.plugins.PreloadPlugin;
import com.bytedance.pia.core.plugins.SnapshotPlugin;
import com.bytedance.pia.core.plugins.StreamingPlugin;
import com.bytedance.pia.core.setting.Settings;
import com.bytedance.pia.core.utils.l;
import com.google.gson.Gson;
import com.lynx.tasm.p;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends nh.i {
    public final /* synthetic */ int d;

    public /* synthetic */ c(int r5) {
        this.d = r5;
    }

    @Override // nh.i
    public final void a(nh.d r10) {
        boolean r5 = true;
        boolean r11 = false;
        switch(this.d) {
            case 0: goto L41;
            default: goto L4;
        };
    L4:
        super.a(r10);
        if (r10.k() == false) goto L69;
        r10.f(BridgePlugin.class, null);
        r10.f(PiaPropsPlugin.class, null);
        Uri r12 = Uri.EMPTY;
        if (TextUtils.isEmpty(r10.d.b()) == true) goto L9;
        Uri.parse(r10.d.b());
    L9:
        Lazy r13 = Settings.B;
        if (p.a().o() == true) goto L12;
    L15:
        String r14 = r10.f;
        Intrinsics.checkNotNullParameter(r14, "url");
        Application r15 = zg.b.f23438a;
        LinkedHashMap r16 = l.f7154a;
        Pair r17 = (Pair) r16.get("openManifestCacheInt");
        if (r17 != null) goto L18;
    L20:
        boolean r18 = com.bytedance.pia.core.setting.d.f7088a;
        boolean r19 = false;
    L21:
        if (r19 == false) goto L23;
        Intrinsics.checkNotNullParameter(r14, "url");
    L23:
        if (r5 == false) goto L28;
        if (r10.d.f() == false) goto L28;
        r10.f(StreamingPlugin.class, null);
    L31:
        String r20 = r10.f;
        Intrinsics.checkNotNullParameter(r20, "url");
        Pair r21 = (Pair) r16.get("openManifestCacheInt");
        if (r21 != null) goto L34;
    L36:
        boolean r22 = com.bytedance.pia.core.setting.d.f7088a;
    L37:
        if (r11 == false) goto L39;
        Intrinsics.checkNotNullParameter(r20, "url");
    L39:
        r10.f(ManifestPlugin.class, null);
        return;
    L34:
        if (((Number) r21.getFirst()).intValue() != 5000) goto L36;
        r11 = ((Boolean) r21.getSecond()).booleanValue();
    L28:
        monitor-enter(rh.b.class);
        monitor-exit(rh.b.class);
        r10.f(HtmlPlugin.class, null);
        r10.f(BootPlugin.class, null);
        r10.f(PreloadPlugin.class, null);
        goto L31
    L18:
        if (((Number) r17.getFirst()).intValue() != 5000) goto L20;
        r19 = ((Boolean) r17.getSecond()).booleanValue();
        goto L21
    L12:
        monitor-enter(rh.b.class);
        monitor-exit(rh.b.class);
        r5 = false;
        goto L15
    L69:
        return;
    L41:
        super.a(r10);
        if (r10.k() == true) goto L72;
        PvEventType r23 = PvEventType.f7039c;
        kh.c r24 = r10.f20239j;
        r24.a(r23, 0);
        PvEventType r25 = PvEventType.e;
        r24.a(r25, 0);
        PvEventType r26 = PvEventType.f7038b;
        r24.a(r26, 0);
        Uri r27 = r10.g;
        if (r27.getBooleanQueryParameter("__pia_manifest__", false) == false) goto L70;
        Gson r28 = yg.b.g;
        yg.b r29 = com.lynx.tasm.utils.j.e(r27.toString(), r10);
        if (r29 == null) goto L73;
        Lazy r30 = Settings.B;
        Settings r31 = p.a();
        Uri r32 = r29.f23262c;
        if (r31.c(r32) == true) goto L52;
        String r33 = "[CompatPluginRegistry]: register failed, public path not support. Public path = " + r32;
        Intrinsics.checkNotNullParameter(r33, "message");
        com.bytedance.pia.core.utils.j.C(r33, null);
        return;
    L52:
        r10.f(BridgePlugin.class, null);
        r10.f(BridgeDowngradePlugin.class, r29);
        if (r29.f == false) goto L58;
        if (p.a().p() == false) goto L58;
        r10.f(NsrPlugin.class, r29);
        r24.a(r23, 1);
    L58:
        if (r29.e == false) goto L63;
        if (p.a().t() == false) goto L63;
        r10.f(SnapshotPlugin.class, r29);
        r24.a(r25, 1);
    L63:
        if (r29.d == true) goto L65;
    L67:
        Intrinsics.checkNotNullParameter("[CompatPluginRegistry]: register success.", "message");
        com.bytedance.pia.core.utils.j.C("[CompatPluginRegistry]: register success.", null);
        return;
    L65:
        if (p.a().s() == false) goto L67;
        r10.f(PrefetchPlugin.class, r29);
        r24.a(r26, 1);
        goto L67
    L73:
        return;
    L70:
        return;
    }
}
