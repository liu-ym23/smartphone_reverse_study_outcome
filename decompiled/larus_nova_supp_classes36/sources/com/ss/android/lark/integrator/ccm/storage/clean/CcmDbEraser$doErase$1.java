package com.ss.android.lark.integrator.ccm.storage.clean;

import android.content.Context;
import ay4.d;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.suite.lark.platform.component.storage.clean.m;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/suite/lark/platform/component/storage/clean/ResourceEraser$EraserResult;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class CcmDbEraser$doErase$1 extends Lambda implements Function0<m.a> {
    final /* synthetic */ Context $context;
    final /* synthetic */ CcmDbResource $resource;

    public CcmDbEraser$doErase$1(CcmDbResource r1, Context r2) {
        this.$resource = r1;
        this.$context = r2;
        super(0);
    }

    public final m.a invoke() {
        CcmDbResource r3 = this.$resource;
        Context r0 = this.$context;
        String r4 = r3.getUseId() + "_encrypted_" + r3.getSourceName();
        String r5 = r3.getUseId() + '_' + r3.getSourceName();
        boolean r6 = true;
        String[] r7 = r0.databaseList();     // Catch: Throwable -> L24
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L24
        int r9 = r7.length;     // Catch: Throwable -> L24
        int r11 = 0;
    L4:
        if (r11 >= r9) goto L15;
        String r12 = r7[r11];     // Catch: Throwable -> L24
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L24
        if (StringsKt.contains$default(r12, r4, false, 2, null) == false) goto L8;
    L11:
        boolean r13 = true;
    L12:
        if (r13 == false) goto L14;
        r8.add(r12);     // Catch: Throwable -> L24
    L14:
        r11 = r11 + 1;     // Catch: Throwable -> L24
        goto L4
    L8:
        if (StringsKt.contains$default(r12, r5, false, 2, null) == true) goto L11;
        r13 = false;
        goto L12
    L15:
        Iterator r10 = r8.iterator();     // Catch: Throwable -> L24
    L16:
        if (r10.hasNext() == false) goto L26;
        String r14 = (String) r10.next();     // Catch: Throwable -> L24
        if (r0.deleteDatabase(r14) == true) goto L16;
        if (d.a().B(r0.getDatabasePath(r14)).exists() == false) goto L16;
        tt5.a.h("CcmDbEraser", "delete " + r3.getSourceName() + " failed!");     // Catch: Throwable -> L24
        r6 = false;
    L26:
        if (r6 == false) goto L29;
        int r1 = m.a.h;
        String r15 = "ccm db eraser success: " + r3.getSourceName();
        Intrinsics.checkNotNullParameter(r15, INotificationHitPoint.NoticeType.MESSAGE);
        return new m.a(true, null, r15, 0, null, 120);
    L29:
        return new m.a(false, null, "ccm db eraser failed", 0, null, 122);
    L24:
        th = move-exception;
        tt5.a.j("CcmDbEraser", th);
        goto L26
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m891invoke() {
        return invoke();
    }
}
