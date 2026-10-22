package com.bytedance.android.livesdk.interactivity.publicscreen.panel.item;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.base.model.message.h0;
import com.bytedance.android.live.base.model.message.m4;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.AudiencePanelItemSymbol;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.v;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends b {
    public final TokenCert f;

    public c() {
        super(AudiencePanelItemSymbol.COPY);
        this.f = TokenCert.Companion.with("bpea-comment_operate_copy_clipboard");
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b
    public final int c() {
        if (this.e.getShowOutside() == false) goto L5;
        return 2131565172;
    L5:
        return 2131565171;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final boolean canShow() {
        t r0 = this.c;
        if ((r0 instanceof m4) == true) goto L5;
        r0 = null;
    L5:
        m4 r1 = (m4) r0;
        if (r1 != null) goto L8;
        return true;
    L8:
        if (r1.isSecretChat() != true) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b
    public final void f(String r3) {
        Intrinsics.checkNotNullParameter(r3, "name");
        super.f(r3);
        if (this.e.getShowOutside() == true) goto L10;
        View r4 = this.a;
        if (r4 == null) goto L11;
        TextView r5 = (TextView) r4.findViewById(2131375727);
        if (r5 == null) goto L12;
        r5.setText((CharSequence) ListProtector.get(this.e.getInsideName(), 0));
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.panel.item.b, com.bytedance.android.livesdk.interactivity.api.publicscreen.api.k
    public final void onClick(View r3) {
        super.onClick(r3);
        t r0 = this.c;     // Catch: BPEAException -> L13
        if ((r0 instanceof h0) == true) goto L6;
        r0 = null;
    L6:
        h0 r1 = (h0) r0;     // Catch: BPEAException -> L13
        if (r1 == null) goto L10;
        String r2 = r1.getChatContent();     // Catch: BPEAException -> L13
        if (r2 == null) goto L10;
    L11:
        g80.d.d(r2, this.f);     // Catch: BPEAException -> L13
    L15:
        f2.c(s1.B(2131915060), 0);
        v r4 = this.d;
        if (r4 == null) goto L21;
        r4.l20(false);
        return;
    L21:
        return;
    L10:
        r2 = BuildConfig.FLAVOR;
    L13:
        e = move-exception;
        SafetyGuard.a(null, e, "copy item error");
        goto L15
    }
}
