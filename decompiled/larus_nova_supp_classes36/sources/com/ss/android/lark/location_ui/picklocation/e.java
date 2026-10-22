package com.ss.android.lark.location_ui.picklocation;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.supervisor.token.Token;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.location.dto.POIInfo;
import com.ss.android.lark.location.dto.Scene;
import com.ss.android.lark.location.listener.LocationRequestOption;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e implements b {
    public com.ss.android.lark.location.service.h a;

    public class a implements com.ss.android.lark.location.service.h.b {
        public final /* synthetic */ LocationView.i a;

        public a(LocationView.i r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.location.service.h.b
        public final void a(com.ss.android.lark.location.service.k r2) {
            this.a.a(r2);
        }

        @Override // com.ss.android.lark.location.service.h.b
        public final void b(List<POIInfo> r2) {
            this.a.b(r2);
        }
    }

    public e() {
    }

    public final void destroy() {
        this.a.release();
    }

    public final void create() {
        this.a = com.ss.android.lark.location.service.f.a().getPOIService();
    }

    @Override // com.ss.android.lark.location_ui.picklocation.b
    public final boolean isAdminGpsEnabled() {
        return com.ss.android.lark.location.service.f.a().isAdminGpsEnabled();
    }

    @Override // com.ss.android.lark.location_ui.picklocation.b
    public final void W6(Bitmap r3, q r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new g(r3, r4));
    }

    @Override // com.ss.android.lark.location_ui.picklocation.b
    public final void q0(double r2, double r4) {
        this.a.q0(r2, r4);
    }

    @Override // com.ss.android.lark.location_ui.picklocation.b
    public final void q(Context r2, POIInfo r3, k.a r4) {
        this.a.q(r2, r3, r4);
    }

    @Override // com.ss.android.lark.location_ui.picklocation.b
    public final void E5(Context r2, String r3, Scene r4, LocationView.c.a r5) {
        f r0 = new f(r5);
        this.a.u0(r2, r3, r4, r0);
    }

    @Override // com.ss.android.lark.location_ui.picklocation.b
    public final void W5(Context r2, Scene r3, LocationView.i r4, int r5) {
        a r0 = new a(r4);
        this.a.s0(r2, r3, r0, r5);
    }

    @Override // com.ss.android.lark.location_ui.picklocation.b
    public final void q7(Context r7, Token r8, Scene r9, LocationView.d r10) {
        d r5 = new d(this, r10);
        LocationRequestOption r2 = new LocationRequestOption();
        com.ss.android.lark.location.service.f.a().getLocationWithOption(r7, r2, r8, r9, r5);
    }

    @Override // com.ss.android.lark.location_ui.picklocation.b
    public final void l5(Context r9, double r10, double r12, Scene r14, LocationView.a r15) {
        h r7 = new h(r15);
        this.a.v0(r9, r10, r12, r14, r7);
    }
}
