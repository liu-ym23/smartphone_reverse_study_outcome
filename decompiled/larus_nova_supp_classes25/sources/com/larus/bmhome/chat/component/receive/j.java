package com.larus.bmhome.chat.component.receive;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.model.ImportedImageRouteParam;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.platform.service.i2;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class j implements Function0 {
    public final /* synthetic */ ChatReceiveServiceComponent a;
    public final /* synthetic */ ImportedImageRouteParam b;

    public /* synthetic */ j(ChatReceiveServiceComponent r1, ImportedImageRouteParam r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        final ChatReceiveServiceComponent r0 = this.a;
        final ImportedImageRouteParam r1 = this.b;
        int r2 = ChatReceiveServiceComponent.x;
        if (s1a.a.c(r0).isAdded() == false) goto L49;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(r0, r0).isDetached() == true) goto L49;
        String r3 = r1.getImageUriString();
        if (r3 != null) goto L10;
    L13:
        boolean r6 = true;
    L14:
        if (r6 == false) goto L16;
        FLogger.a.w("ChatReceiveServiceComponent", "routeImportedImage imageUriString is empty");
    L50:
        return Unit.INSTANCE;
    L16:
        final Uri r4 = UriProtector.parse(r3);
        Intrinsics.checkNotNull(r4);
        String r7 = r4.toString();
        String r8 = r1.getPreviousPage();
        String r9 = null;
        if (r8 != null) goto L19;
    L27:
        String r10 = r1.getContentSource();
        if (r10 != null) goto L30;
    L37:
        ChatControlTrace.b.getClass();
        ChatControlTrace.A = true;
        com.larus.bmhome.instruction.g r5 = (com.larus.bmhome.instruction.g) r0.o.getValue();
        if (r5 == null) goto L40;
        r5.A1();
    L40:
        u7 r11 = (u7) r0.k.getValue();
        if (r11 == null) goto L43;
        r11.TP(false);
    L43:
        final List r12 = CollectionsKt.listOf(r4);
        if (l0.a(r12) == false) goto L46;
        r0.p3(r4, r1);
        goto L50
    L46:
        List r13 = CollectionsKt.mutableListOf(new String[]{"android.permission.READ_EXTERNAL_STORAGE"});
        i2 r14 = i2.b;
        Intrinsics.checkNotNullParameter(r0, "<this>");
        i2.q(com.larus.ui.arch.component.internal.attach.a.b(r0, r0), r13, new y(r12, r0, r4, r1));
        goto L50
    L30:
        if (r10.length() <= 0) goto L32;
        boolean r15 = true;
    L33:
        if (r15 == false) goto L35;
        r9 = r10;
    L35:
        if (r9 == null) goto L37;
        od8.d.a.d(r7, r9);
        goto L37
    L32:
        r15 = false;
        goto L33
    L19:
        if (r8.length() <= 0) goto L21;
        boolean r16 = true;
    L22:
        if (r16 == true) goto L25;
        r8 = null;
    L25:
        if (r8 == null) goto L27;
        od8.d.a.e(r7, r8);
        goto L27
    L21:
        r16 = false;
        goto L22
    L10:
        if (r3.length() == 0) goto L13;
        r6 = false;
    L49:
        return Unit.INSTANCE;
    }
}
