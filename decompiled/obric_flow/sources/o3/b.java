package o3;

import android.content.Context;
import b4.c;
import com.bytedance.android.anniex.ui.AnnieXLynxView;
import com.bytedance.ies.bullet.core.container.d;
import com.bytedance.ies.bullet.core.e;
import com.bytedance.ies.bullet.core.f;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f20406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AnnieXLynxView f20407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.sdk.xbridge.cn.platform.lynx.a f20408c;

    public b(c r5, AnnieXLynxView r10, com.bytedance.sdk.xbridge.cn.platform.lynx.a r11) {
        this.f20406a = r5;
        this.f20407b = r10;
        this.f20408c = r11;
    }

    @Override // com.bytedance.ies.bullet.core.container.e
    public final void c(com.bytedance.ies.bullet.lynx.impl.b r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        String r10 = r5.f5650b;
        JSONObject r11 = (JSONObject) r5.f5651c;
        AnnieXLynxView.i(this.f20407b, r10, r11);
    }

    @Override // com.bytedance.ies.bullet.core.container.e
    public final e getBulletContext() {
        Lazy r5 = f.f5312b;
        td.b.b().getClass();
        e r10 = new e();
        c r11 = this.f20406a;
        String r12 = r11.f;
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r10.f5291a = r12;
        r10.f = r11.f861c;
        ConcurrentHashMap r13 = yc.a.f23246a;
        Intrinsics.checkNotNullParameter(xc.e.class, "cls");
        xc.e r14 = (xc.e) yc.a.a(xc.e.class, "default_bid");
        if (r14 == null) goto L9;
        xc.d r15 = (xc.d) r14.a(xc.d.class);
        if (r15 == null) goto L9;
        Boolean r16 = r15.V();
        if (r16 == null) goto L9;
        boolean r17 = r16.booleanValue();
    L10:
        if (r17 == false) goto L12;
        Context r18 = this.f20407b.getContext();
    L13:
        r10.f5294h = r18;
        r10.C = true;
        return r10;
    L12:
        r18 = this.f20408c.f7453a;
    L9:
        r17 = true;
        goto L10
    }

    @Override // com.bytedance.ies.bullet.core.container.e
    public final String getSessionId() {
        return this.f20406a.f;
    }
}
