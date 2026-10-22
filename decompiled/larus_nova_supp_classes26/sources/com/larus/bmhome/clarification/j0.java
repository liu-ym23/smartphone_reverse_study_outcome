package com.larus.bmhome.clarification;

import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.utils.logger.FLogger;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class j0 implements Function4 {
    public final /* synthetic */ ClarificationComponent a;

    public /* synthetic */ j0(ClarificationComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r37, Object r38, Object r39, Object r40) {
        String r5 = (String) r37;
        String r2 = (String) r38;
        Boolean r3 = (Boolean) r39;
        Boolean r6 = (Boolean) r40;
        ClarificationAttachmentManager r1 = this.a.H;
        if (r1 == null) goto L62;
        if (r1.j == true) goto L62;
        if (r1.a.isAdded() == false) goto L62;
        Boolean r4 = Boolean.FALSE;
        if (Intrinsics.areEqual(r3, r4) == true) goto L12;
    L14:
        if (r5 != null) goto L16;
    L19:
        boolean r7 = true;
    L20:
        if (r7 == true) goto L62;
        if (r2 != null) goto L23;
    L26:
        boolean r8 = true;
    L27:
        if (r8 == true) goto L62;
        d2 r9 = r1.b.a;
        int r10 = -1;
        if (r9 != null) goto L32;
        int r15 = -1;
    L51:
        if (r15 < 0) goto L62;
        d2 r11 = r1.b.a;
        if (r11 == null) goto L62;
        List<z1> r12 = r11.l;
        if (r12 == null) goto L62;
        z1 r14 = (z1) CollectionsKt.getOrNull(r12, r15);
        if (r14 == null) goto L62;
        Uri r13 = Uri.fromFile(new PolarisFileWrapper(r2));
        int r16 = UplinkEntityType.EntityTypeImage.getValue();
        int r17 = UpLinkState.PROCESSING.getValue();
        UplinkEntityContent r18 = new UplinkEntityContent(null, null, 3, null);
        Image r19 = new Image(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
        r19.localResPath = r2;
        r19.identifier = r5;
        r19.setMarked(r3);
        r19.setCropped(r6);
        r19.ext = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_marked", sr9.b.b.a(r13.toString()))});
        r18.setUplinkImageInfo(r19);
        UplinkFileEntity r110 = new UplinkFileEntity(Integer.valueOf(r16), r18, r5, null, null, null, 0, Integer.valueOf(r17), Boolean.FALSE, false, r13, null, null, null, 14904, null);
        r1.t(r15, r110);
        r1.r(r14.h, r110, "clarification_retry");
        goto L62
    L32:
        Iterator<z1> r20 = r9.l.iterator();
        int r111 = 0;
    L34:
        if (r20.hasNext() == false) goto L50;
        List<UplinkFileEntity> r112 = r20.next().l.d;
        if ((r112 instanceof Collection) == true) goto L38;
    L40:
        Iterator<T> r113 = r112.iterator();
    L42:
        if (r113.hasNext() == false) goto L46;
        if (Intrinsics.areEqual(((UplinkFileEntity) r113.next()).getFileIdentifier(), r5) == false) goto L42;
        boolean r114 = true;
    L47:
        if (r114 == true) goto L48;
        r111 = r111 + 1;
        goto L34
    L48:
        r10 = r111;
    L46:
        r114 = false;
        goto L47
    L38:
        if (r112.isEmpty() == false) goto L40;
    L50:
        r15 = r10;
        goto L51
    L23:
        if (r2.length() == 0) goto L26;
        r8 = false;
        goto L27
    L16:
        if (r5.length() == 0) goto L19;
        r7 = false;
        goto L20
    L12:
        if (Intrinsics.areEqual(r6, r4) == false) goto L14;
        FLogger.a.i("ClarificationAttachMgr", "[handlePhotoEdited] photo not changed, skip");
    L62:
        return Unit.INSTANCE;
    }
}
