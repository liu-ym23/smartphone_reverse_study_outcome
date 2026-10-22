package com.bytedance.android.live.revlink.impl.behavior;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.di1;
import com.bytedance.android.livesdkapi.depend.model.live.IAnchorBottomToolbar;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomOthersData;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k {
    public final h a;

    public static boolean b() {
        com.bytedance.android.livesdk.revenue.service.toolbar.f r0 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.toolbar.f.class);
        if (r0 == null) goto L5;
        di1 r1 = r0.l3();
    L6:
        if (r1 != null) goto L10;
        return false;
    L10:
        return r1.a;
    L5:
        r1 = null;
        goto L6
    }

    public static com.bytedance.android.livesdk.link.model.t c() {
        yz0.k r0 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r0 == null) goto L16;
        IRoom r1 = r0.getRoom();
        if (r1 == null) goto L19;
        IRoomOthersData r2 = r1.getRoomOthers();
        if (r2 == null) goto L17;
        Intrinsics.checkNotNullParameter(r2, "$this$anchorBottomToolbarExt");
        IAnchorBottomToolbar r3 = r2.getAnchorBottomToolbar();
        if (r3 == null) goto L12;
        com.bytedance.android.livesdk.link.model.i r4 = (com.bytedance.android.livesdk.link.model.i) r3.castToOrNull(com.bytedance.android.livesdk.link.model.i.class);
    L13:
        if (r4 != null) goto L15;
        return null;
    L15:
        return r4.getAnchorLinkmicentrance();
    L12:
        r4 = null;
        goto L13
    L17:
        return null;
    L19:
        return null;
    L16:
        return null;
    }

    public k() {
        PkPanelType r1 = PkPanelType.PK;
        int r2 = e.d;
        this.a = new h(r1, new e(IconResMode.DRAWABLE, null, 2131252958), s1.B(2131914888), "");
    }

    public static boolean g() {
        com.bytedance.android.livesdk.link.model.t r0 = c();
        if (r0 == null) goto L5;
        String r1 = r0.getLeadPkFreqKey();
    L7:
        if (r1 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == false) goto L16;
        return false;
    L16:
        return !Intrinsics.areEqual((String) l51.a.I0.getValue(null, l51.a.a[98]), r1);
    L9:
        if (r1.length() == 0) goto L12;
        r4 = false;
        goto L13
    L5:
        r1 = null;
        goto L7
    }

    public static void h() {
        com.bytedance.android.livesdk.link.model.t r0 = c();
        if (r0 == null) goto L5;
        String r1 = r0.getLeadPkFreqKey();
    L7:
        if (by0.b.a(r1) == false) goto L12;
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        KProperty[] r2 = l51.a.a;
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        l51.a.I0.setValue(null, l51.a.a[98], r1);
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public static boolean j() {
        if (b() == true) goto L5;
        return false;
    L5:
        com.bytedance.android.livesdk.link.model.t r0 = c();
        if (r0 != null) goto L8;
        return false;
    L8:
        yz0.k r2 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r2 == null) goto L11;
        IRoom r3 = r2.getRoom();
    L13:
        if (r3 != null) goto L15;
    L17:
        boolean r4 = false;
    L18:
        if (r4 == false) goto L21;
        return false;
    L21:
        if (by0.b.a(r0.getText()) == true) goto L23;
        return false;
    L23:
        if (a(r0.getIcon()) == true) goto L25;
        return false;
    L25:
        if (a(r0.getPkIcon()) == true) goto L27;
        return false;
    L27:
        if (a(r0.getAnchorIcon()) == true) goto L29;
        return false;
    L29:
        if (a(r0.getLink2PkImage()) == true) goto L31;
        return false;
    L31:
        if (a(r0.getPk2LinkImage()) == true) goto L33;
        return false;
    L33:
        if (a(r0.getLeadPkImage()) == false) goto L42;
        return true;
    L42:
        return false;
    L15:
        if (r3.isLiveTypeAudio() != true) goto L17;
        r4 = true;
        goto L18
    L11:
        r3 = null;
        goto L13
    }

    public final h d() {
        if (j() == false) goto L20;
        com.bytedance.android.livesdk.link.model.t r0 = c();
        h r1 = null;
        if (r0 == null) goto L18;
        int r2 = r0.getPanelType();
        py.k r3 = r0.getIcon();
        if (r3 == null) goto L18;
        String r4 = r0.getText();
        if (r4 == null) goto L18;
        String r5 = r0.getWordType();
        if (r2 != 1) goto L16;
        PkPanelType r6 = PkPanelType.Anchor;
    L17:
        int r7 = e.d;
        Intrinsics.checkNotNullParameter(r3, "image");
        r1 = new h(r6, new e(IconResMode.IMAGE_MODEL, r3, null), r4, r5);
        goto L18
    L16:
        r6 = PkPanelType.PK;
    L18:
        if (r1 == null) goto L20;
        return r1;
    L20:
        return this.a;
    }

    public static boolean a(py.k r0) {
        if (r0 == null) goto L6;
        List r1 = r0.getUrls();
        if (r1 == null) goto L6;
        String r2 = (String) CollectionsKt.firstOrNull(r1);
    L8:
        return by0.b.a(r2);
    L6:
        r2 = null;
        goto L8
    }

    public static String e(PkPanelType r6) {
        Intrinsics.checkNotNullParameter(r6, "type");
        boolean r1 = false;
        if (r6 != PkPanelType.PK) goto L9;
        String r0 = (String) l51.a.J0.getValue(null, l51.a.a[99]);
        if (r0.length() != 0) goto L7;
        r1 = true;
    L7:
        if (r1 == false) goto L14;
        r0 = "PK";
    L14:
        com.bytedance.android.livesdk.link.model.t r2 = c();
        if (r2 != null) goto L17;
        return r0;
    L17:
        PkPanelType.a r3 = PkPanelType.Companion;
        Integer r4 = Integer.valueOf(r2.getPanelType());
        r3.getClass();
        if (PkPanelType.a.a(r4) != r6) goto L24;
        String r7 = r2.getText();
        if (r7 != null) goto L23;
        return r0;
    L23:
        return r7;
    L24:
        return r0;
    L9:
        r0 = (String) l51.a.K0.getValue(null, l51.a.a[100]);
        if (r0.length() != 0) goto L12;
        r1 = true;
    L12:
        if (r1 == false) goto L14;
        r0 = "连主播";
        goto L14
    }

    public static String f(PkPanelType r4) {
        Intrinsics.checkNotNullParameter(r4, "type");
        if (r4 != PkPanelType.PK) goto L5;
        String r0 = (String) l51.a.L0.getValue(null, l51.a.a[101(0x65, float:1.42E-43)]);
    L6:
        com.bytedance.android.livesdk.link.model.t r1 = c();
        if (r1 != null) goto L9;
        return r0;
    L9:
        PkPanelType.a r2 = PkPanelType.Companion;
        Integer r3 = Integer.valueOf(r1.getPanelType());
        r2.getClass();
        if (PkPanelType.a.a(r3) == r4) goto L12;
        return r0;
    L12:
        return r1.getWordType();
    L5:
        r0 = (String) l51.a.M0.getValue(null, l51.a.a[102(0x66, float:1.43E-43)]);
        goto L6
    }

    public static void i(PkPanelType r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r6, "text");
        Intrinsics.checkNotNullParameter(r7, "wordType");
        if (r6.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        Integer r1 = Integer.valueOf(r5.toConstInt());
        com.bytedance.tools.kcp.spongepreference.runtime.a r2 = l51.a.H0;
        KProperty[] r3 = l51.a.a;
        r2.setValue(null, r3[97], r1);
        if (r5 != PkPanelType.PK) goto L12;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        l51.a.J0.setValue(null, r3[99], r6);
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        l51.a.L0.setValue(null, r3[101(0x65, float:1.42E-43)], r7);
    L12:
        if (r5 != PkPanelType.Anchor) goto L15;
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        l51.a.K0.setValue(null, r3[100], r6);
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        l51.a.M0.setValue(null, r3[102(0x66, float:1.43E-43)], r7);
        return;
    L15:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
