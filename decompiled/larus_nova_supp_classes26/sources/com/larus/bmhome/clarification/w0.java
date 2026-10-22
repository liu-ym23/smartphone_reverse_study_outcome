package com.larus.bmhome.clarification;

import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.utils.logger.FLogger;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final /* synthetic */ class w0 implements Function1 {
    public final /* synthetic */ ClarificationComponent a;

    public /* synthetic */ w0(ClarificationComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r47) {
        ClarificationComponent r7 = this.a;
        ICoreInputAbility.OnSendParams r8 = (ICoreInputAbility.OnSendParams) r47;
        int r1 = ClarificationComponent.k0;
        Intrinsics.checkNotNullParameter(r8, "params");
        d2 r9 = r7.n.a;
        boolean r2 = false;
        if (r9 == null) goto L32;
        ze8.b r3 = r9.k;
        if (r3 == null) goto L32;
        int r4 = r9.j;
        if (r4 < CollectionsKt.getLastIndex(r9.h)) goto L26;
        String r45 = StringsKt.trim(r8.getContent()).toString();
        if (w.a(r9.g) == true) goto L13;
    L24:
        r7.h4(r9);
    L25:
        r2 = true;
        goto L32
    L13:
        if (r45.length() <= 0) goto L15;
        r2 = true;
    L15:
        if (r2 == false) goto L24;
        FLogger.a.d("ClarificationComponent", "forward auto-route custom input, clarifyId=" + r9.d + ", textLength=" + r45.length());
        if (r7.j4(r9, "auto_route_custom_input") == false) goto L25;
        r7.Q3(r9);
        r7.C3(r9, "auto_route_custom_input", ClarificationAttachmentReleasePolicy.DISMISS_AND_DELETE_TEMP_RESOURCES, true, true);
        ICoreInputAbility r5 = r7.H3();
        if (r5 == null) goto L22;
        boolean r6 = true;
        r5.E0(ICoreInputAbility.OnSendParams.copy$default(r8, r45, null, null, null, null, null, null, null, 0, false, null, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2, 1, null));
    L23:
        r7.Z3(r9, r6, "auto_route_custom_input");
        goto L25
    L22:
        r6 = true;
        goto L23
    L26:
        int r10 = RangesKt.coerceAtMost(r4 + 1, CollectionsKt.getLastIndex(r9.h));
        r7.N = Integer.valueOf(r10);
        boolean r11 = r3.b();
        if (r11 == false) goto L29;
        r7.X3(r9, r4);
        r7.n.c(r10);
        r7.W3(r9, r10, "next", "click");
        r3.h(r4);
        r3.e(r10);
        r7.l4();
    L30:
        r2 = r11;
        goto L32
    L29:
        r7.N = null;
    L32:
        return Boolean.valueOf(r2);
    }
}
