package com.larus.bmhome.clarification;

import com.larus.im.bean.message.block.Block;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class i0 implements Function0 {
    public final /* synthetic */ ClarificationComponent a;

    public /* synthetic */ i0(ClarificationComponent r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ClarificationComponent r6 = this.a;
        d2 r7 = r6.n.a;
        if (r7 == null) goto L9;
        Block r0 = r7.g;
        if (r0 == null) goto L9;
        if (w.a(r0) != true) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L13;
        r6.MY("user_dismiss", true);
    L17:
        return Unit.INSTANCE;
    L13:
        if (r6.j4(r7, "auto_route_close_button") == false) goto L17;
        r6.Q3(r7);
        r6.C3(r7, "close_button", ClarificationAttachmentReleasePolicy.DISMISS_AND_DELETE_TEMP_RESOURCES, true, true);
        r6.Z3(r7, true, "auto_route_close_button");
    L9:
        r1 = false;
        goto L10
    }
}
