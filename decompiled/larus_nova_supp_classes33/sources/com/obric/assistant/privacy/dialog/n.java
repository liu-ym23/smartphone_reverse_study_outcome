package com.obric.assistant.privacy.dialog;

import com.larus.common_ui.widget.UrlSpanTextView;
import com.larus.network.HttpConst;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class n implements UrlSpanTextView.a {
    public final /* synthetic */ GRPrivacyDialog a;

    public n(GRPrivacyDialog r1) {
        this.a = r1;
    }

    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, MemorySourceLinkType.URL);
        int r0 = r3.hashCode();
        if (r0 == 3584) goto L18;
        if (r0 == 3646) goto L14;
        if (r0 == 115032) goto L10;
        return;
    L10:
        if (r3.equals("tos") == false) goto L25;
        GRPrivacyDialog r4 = this.a;
        HttpConst.a.getClass();
        GRPrivacyDialog.S90(r4, HttpConst.L);
        return;
    L25:
        return;
    L14:
        if (r3.equals("rp") == false) goto L26;
        GRPrivacyDialog r5 = this.a;
        String r1 = com.larus.setting.api.u.a;
        GRPrivacyDialog.S90(r5, com.larus.setting.api.u.d);
        return;
    L26:
        return;
    L18:
        if (r3.equals("pp") == false) goto L27;
        GRPrivacyDialog r6 = this.a;
        HttpConst.a.getClass();
        GRPrivacyDialog.S90(r6, HttpConst.M);
        return;
    }
}
