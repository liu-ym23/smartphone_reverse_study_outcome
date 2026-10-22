package wd0;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.multiroom.e;
import com.bytedance.android.live.liveinteract.utils.c1;
import com.bytedance.android.livesdk.config.gb0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBasisData;
import com.bytedance.ies.sdk.widgets.DataCenter;
import gd0.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements c {

    public static final class a {
    }

    static {
    }

    public d() {
    }

    public static void b(xd0.a r0, DataCenter r1, boolean r2) {
        if (r2 == true) goto L7;
        if (r1 == null) goto L7;
        com.bytedance.android.live.liveinteract.bgComponent.platform.a r3 = e.c(r1);
        if (r3 == null) goto L7;
        r3.lb();
    L7:
        r0.c.setVisible(r2);
    }

    @Override // wd0.c
    public final void a(b r9, List<xd0.a> r10, xd0.b r11) {
        Intrinsics.checkNotNullParameter(r9, "renderContext");
        Intrinsics.checkNotNullParameter(r10, "layers");
        Intrinsics.checkNotNullParameter(r11, "shadowLayer");
        Iterator<T> r12 = r10.iterator();
    L3:
        boolean r2 = true;
        if (r12.hasNext() == false) goto L11;
        Object r0 = r12.next();
        if (((xd0.a) r0).b != 2000) goto L8;
        boolean r4 = true;
    L9:
        if (r4 == false) goto L3;
    L12:
        xd0.a r1 = (xd0.a) r0;
        if (r1 != null) goto L15;
        return;
    L15:
        ALogger.i("ThemeBgLayerVisibleStrategy", "process, renderContext=" + r9);
        DataCenter r13 = r9.a;
        if (r13 == null) goto L20;
        Integer r5 = (Integer) r13.get("data_link_state", 0);
        if (r5 == null) goto L20;
        int r6 = r5.intValue();
    L21:
        boolean r7 = v.a(r6, 4);
        boolean r8 = v.a(r6, 64);
        if (r7 == true) goto L111;
        if (r8 == true) goto L111;
        Boolean r14 = r9.g;
        Boolean r15 = Boolean.TRUE;
        if (Intrinsics.areEqual(r14, r15) == false) goto L29;
        b(r1, r13, false);
        return;
    L29:
        IRoom r16 = r9.b;
        if (r16 != null) goto L32;
    L47:
        Integer r17 = r9.d;
        if (r17 != null) goto L51;
    L52:
        Integer r18 = r9.d;
        if (r18 != null) goto L56;
    L58:
        int r19 = c1.a;
        if (c1.a(0, r9.d) == true) goto L61;
    L64:
        List<? extends tf0.e> r20 = r9.i;
        if (r20 == null) goto L72;
        Iterator<T> r21 = r20.iterator();
        boolean r22 = true;
    L68:
        if (r21.hasNext() == false) goto L73;
        if ((((tf0.e) r21.next()) instanceof MultiLinkGuestViewBinder.a) == false) goto L68;
        r22 = false;
    L73:
        List<? extends tf0.e> r23 = r20;
        if (r23 != null) goto L76;
    L79:
        boolean r24 = true;
    L80:
        if (r24 == true) goto L84;
        if (r22 == true) goto L84;
        boolean r25 = false;
    L85:
        if (r25 == false) goto L89;
        b(r1, r13, false);
        return;
    L89:
        if (((Boolean) vm2.d.k2.getValue(null, vm2.d.a[164(0xa4, float:2.3E-43)])).booleanValue() == false) goto L101;
        Integer r3 = r9.d;
        if (r3 == null) goto L93;
        int r26 = r3.intValue();
    L95:
        if (r26 != 7) goto L97;
        boolean r27 = true;
    L98:
        if (r27 == false) goto L101;
        b(r1, r13, false);
        return;
    L97:
        r27 = false;
        goto L98
    L93:
        r26 = 0;
    L101:
        Iterator r110 = ((ArrayList) r11.a).iterator();
    L103:
        if (r110.hasNext() == false) goto L107;
        if (((yd0.a) r110.next()).a(r9) == true) goto L103;
        r2 = false;
        goto L103
    L107:
        b(r1, r13, r2);
        return;
    L84:
        r25 = true;
        goto L85
    L76:
        if (r23.isEmpty() == true) goto L79;
        r24 = false;
        goto L80
    L72:
        r22 = true;
        goto L73
    L61:
        if (r9.h != 1) goto L64;
        b(r1, r13, false);
        return;
    L56:
        if (r18.intValue() != 0) goto L58;
    L109:
        b(r1, r13, false);
        return;
    L51:
        if (r17.intValue() == 15) goto L109;
    L32:
        if (r16.isLiveTypeAudio() != true) goto L47;
        IRoom r28 = r9.b;
        if (r28 == null) goto L38;
        IRoomBasisData r29 = r28.getBasisRoomData();
        if (r29 == null) goto L38;
        Boolean r30 = r29.isCustomizeAudioRoom();
    L40:
        if (Intrinsics.areEqual(r30, r15) == false) goto L44;
        b(r1, r13, false);
        return;
    L44:
        if (CollectionsKt.contains((List) gb0.a.getValue(), r9.d) == false) goto L89;
        b(r1, r13, false);
        return;
    L38:
        r30 = null;
    L111:
        b(r1, r13, false);
        return;
    L20:
        r6 = 0;
        goto L21
    L8:
        r4 = false;
        goto L9
    L11:
        r0 = null;
        goto L12
    }
}
