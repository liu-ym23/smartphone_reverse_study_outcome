package com.larus.bmhome.chat.component.list;

import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import p99.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f6 implements com.larus.bmhome.chat.component.cvs.y.a<wc9.e> {
    public final /* synthetic */ ChatListComponent a;

    public f6(ChatListComponent r1) {
        this.a = r1;
    }

    public final void c(Object r9) {
        wc9.e r10 = (wc9.e) r9;
        Intrinsics.checkNotNullParameter(r10, "new");
        FLogger r0 = FLogger.a;
        r0.i(this.a.n, "[observeSectionIdChange] sectionId = " + r10.B);
        d r1 = this.a.m3;
        if (r1 == null) goto L9;
        String r2 = r10.B;
        if (r2 != null) goto L7;
        r2 = "";
    L7:
        r1.j(r2);
    L9:
        if (ic8.n.v(r10) == false) goto L25;
        v7 r3 = x7.a;
        String r4 = AccountService.a.getUserId();
        Intrinsics.checkNotNullParameter(r4, "userId");
        if (z2.a.u() == true) goto L13;
        return;
    L13:
        if (r4.length() != 0) goto L15;
        boolean r5 = true;
    L16:
        if (r5 == true) goto L28;
        r0.i("SectionIdInfoCache", "updateSectionIdInfo userId = " + r4 + ", conversation = " + r10);
        x7.a = new v7(r4, r10.B);
        CopyOnWriteArraySet<String> r6 = x7.c;
        if (r6.contains(r4) == true) goto L21;
        r6.add(r4);
    L21:
        String r11 = r10.B;
        if (r11 == null) goto L27;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new SectionIdInfoCache$updateSectionIdInfo$1$1$1(r4, r11, null), 3, null);
        return;
    L27:
        return;
    L28:
        return;
    L15:
        r5 = false;
        goto L16
    }
}
