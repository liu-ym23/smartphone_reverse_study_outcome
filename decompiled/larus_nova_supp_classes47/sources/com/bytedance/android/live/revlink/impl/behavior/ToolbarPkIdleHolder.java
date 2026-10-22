package com.bytedance.android.live.revlink.impl.behavior;

import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class ToolbarPkIdleHolder {
    public static final ReadOnlyProperty g = null;
    public static final a h = null;
    public final k a;
    public final d0 b;
    public final j c;
    public boolean d;
    public final CompositeDisposable e;
    public PkIconStatus f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/behavior/ToolbarPkIdleHolder$PkIconStatus;", "", "WAITING_PK_TO_LINK", "WAITING_LINK_TO_PK", "WAITING_PK_TO_LINK_AND_PASS_LEAD", "WAITING_LINK_TO_PK_AND_PASS_LEAD", "WAITING_LEAD_PK", "ANIMATING", "ANIMATING_PASS_LEAD", "OTHERS", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum PkIconStatus extends Enum<PkIconStatus> {
        public static final PkIconStatus ANIMATING = null;
        public static final PkIconStatus ANIMATING_PASS_LEAD = null;
        public static final PkIconStatus OTHERS = null;
        public static final PkIconStatus WAITING_LEAD_PK = null;
        public static final PkIconStatus WAITING_LINK_TO_PK = null;
        public static final PkIconStatus WAITING_LINK_TO_PK_AND_PASS_LEAD = null;
        public static final PkIconStatus WAITING_PK_TO_LINK = null;
        public static final PkIconStatus WAITING_PK_TO_LINK_AND_PASS_LEAD = null;
        public static final /* synthetic */ PkIconStatus[] a = null;

        static {
            PkIconStatus r1 = new PkIconStatus("WAITING_PK_TO_LINK", 0);
            WAITING_PK_TO_LINK = r1;
            PkIconStatus r2 = new PkIconStatus("WAITING_LINK_TO_PK", 1);
            WAITING_LINK_TO_PK = r2;
            PkIconStatus r3 = new PkIconStatus("WAITING_PK_TO_LINK_AND_PASS_LEAD", 2);
            WAITING_PK_TO_LINK_AND_PASS_LEAD = r3;
            PkIconStatus r4 = new PkIconStatus("WAITING_LINK_TO_PK_AND_PASS_LEAD", 3);
            WAITING_LINK_TO_PK_AND_PASS_LEAD = r4;
            PkIconStatus r5 = new PkIconStatus("WAITING_LEAD_PK", 4);
            WAITING_LEAD_PK = r5;
            PkIconStatus r6 = new PkIconStatus("ANIMATING", 5);
            ANIMATING = r6;
            PkIconStatus r7 = new PkIconStatus("ANIMATING_PASS_LEAD", 6);
            ANIMATING_PASS_LEAD = r7;
            PkIconStatus r8 = new PkIconStatus("OTHERS", 7);
            OTHERS = r8;
            a = new PkIconStatus[]{r1, r2, r3, r4, r5, r6, r7, r8};
        }

        public static PkIconStatus valueOf(String r1) {
            return (PkIconStatus) r27.a.a(PkIconStatus.class, r1);
        }

        public static PkIconStatus[] values() {
            return (PkIconStatus[]) a.clone();
        }

        public PkIconStatus(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public static final /* synthetic */ KProperty[] a = null;

        static {
            a = new KProperty[]{Reflection.property1(new PropertyReference1Impl(a.class, "ANIM_DELAY_MILLS", "getANIM_DELAY_MILLS()J", 0))};
        }

        public a() {
        }
    }

    static {
        h = new a();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r0 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("toolbar_pk_entrance_anim_delay_mills", 1500L, Long.TYPE, false);
        KProperty r10 = a.a[0];
        g = UltraSettingsManager.a().a(r0.a, r0.b, r0.getType(), r0.d, r10);
    }

    public final void a() {
        if (this.d == false) goto L16;
        this.e.clear();
        this.a.getClass();
        if (k.j() == false) goto L17;
        c(IvPkId.MAIN);
        h r0 = this.a.d();
        PkPanelType r1 = r0.getType();
        String r2 = r0.c;
        String r3 = r0.d;
        this.a.getClass();
        k.i(r1, r2, r3);
        PkIconStatus r4 = this.f;
        if (r4 != PkIconStatus.ANIMATING_PASS_LEAD) goto L9;
    L14:
        this.a.getClass();
        k.h();
        return;
    L9:
        if (r4 == PkIconStatus.WAITING_PK_TO_LINK_AND_PASS_LEAD) goto L14;
        if (r4 == PkIconStatus.WAITING_LINK_TO_PK_AND_PASS_LEAD) goto L14;
        if (r4 == PkIconStatus.WAITING_LEAD_PK) goto L14;
        return;
    L17:
        return;
    }

    public ToolbarPkIdleHolder(d r3) {
        Intrinsics.checkNotNullParameter(r3, "button");
        k r0 = new k();
        this.a = r0;
        this.e = new CompositeDisposable();
        this.f = PkIconStatus.OTHERS;
        this.b = new d0(r3, r0);
        this.c = new j(r3, r0);
    }

    public final void c(IvPkId r5) {
        h r0 = this.a.d();
        ld.a r1 = ld.d.a();
        if (r1 == null) goto L11;
        NextLiveData r2 = r1.uf();
        if (r2 == null) goto L11;
        if (r0.getType() != PkPanelType.PK) goto L9;
        int r3 = 2;
    L10:
        r2.setValue(Integer.valueOf(r3));
        goto L11
    L9:
        r3 = 1;
    L11:
        com.bytedance.android.livesdk.revenue.datacenter.e r4 = wq2.e.a();
        k r6 = this.a;
        PkPanelType r7 = r0.getType();
        r6.getClass();
        r4.f(k.e(r7));
        ld.a r8 = ld.d.a();
        if (r8 == null) goto L16;
        NextLiveData r9 = r8.A4();
        if (r9 == null) goto L16;
        k r10 = this.a;
        PkPanelType r12 = r0.getType();
        r10.getClass();
        r9.setValue(k.f(r12));
    L16:
        Disposable r13 = this.b.e(r0.b, r5, false);
        if (r13 == null) goto L20;
        this.e.add(r13);
        return;
    }

    public static void b(ToolbarPkIdleHolder r5, PkPanelType r6) {
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "currentType");
        mz0.n r7 = new mz0.n();
        Map<String, String> r0 = r7.a;
        Intrinsics.checkNotNullParameter(r0, "map");
        if (r6 != PkPanelType.PK) goto L6;
        Intrinsics.checkNotNullParameter("flash_type", "key");
        Intrinsics.checkNotNullParameter("anchorlink_to_pk", "value");
        r0.put("flash_type", "anchorlink_to_pk");
    L11:
        d31.d r8 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r8 == null) goto L15;
        String r9 = r8.a();
        if (r9 == null) goto L15;
    L16:
        Intrinsics.checkNotNullParameter("anchor_connect_status", "key");
        Intrinsics.checkNotNullParameter(r9, "value");
        r0.put("anchor_connect_status", r9);
        mz0.m r10 = new mz0.m();
        r10.b(LogCommon.ROOM);
        List<Object> r1 = r7.b;
        ArrayList r2 = (ArrayList) r1;
        r2.addAll(r10.a);
        cy0.e.a.getClass();
        cy0.j r12 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r13 = com.bytedance.android.scope.m.b(r12).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r13);
        ((mz0.i) ((f80.a) r13)).w3("livesdk_interact_icon_change_flash_show", r7.a, r7.b);
        return;
    L15:
        r9 = "";
        goto L16
    L6:
        if (r6 != PkPanelType.Anchor) goto L9;
        Intrinsics.checkNotNullParameter("flash_type", "key");
        Intrinsics.checkNotNullParameter("pk_to_anchorlink", "value");
        r0.put("flash_type", "pk_to_anchorlink");
        goto L11
    L9:
        if (r6 != PkPanelType.GAME) goto L11;
        Intrinsics.checkNotNullParameter("flash_type", "key");
        Intrinsics.checkNotNullParameter("game_guide", "value");
        r0.put("flash_type", "game_guide");
        goto L11
    }

    public final void d(PkPanelType r6, IvPkId r7, boolean r8) {
        this.a.getClass();
        Intrinsics.checkNotNullParameter(r6, "type");
        e r1 = null;
        if (k.j() == false) goto L19;
        com.bytedance.android.livesdk.link.model.t r0 = k.c();
        if (r0 == null) goto L19;
        py.k r2 = r0.getPkIcon();
        if (r2 == null) goto L19;
        py.k r3 = r0.getAnchorIcon();
        if (r3 == null) goto L19;
        if (r6 != PkPanelType.Anchor) goto L17;
        int r9 = e.d;
        Intrinsics.checkNotNullParameter(r3, "image");
        e r10 = new e(IconResMode.IMAGE_MODEL, r3, null);
    L18:
        r1 = r10;
        goto L19
    L17:
        int r12 = e.d;
        Intrinsics.checkNotNullParameter(r2, "image");
        r10 = new e(IconResMode.IMAGE_MODEL, r2, null);
    L19:
        if (r1 == null) goto L24;
        Disposable r13 = this.b.e(r1, r7, r8);
        if (r13 == null) goto L25;
        this.e.add(r13);
        return;
    L25:
        return;
    }
}
