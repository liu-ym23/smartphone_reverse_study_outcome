package com.larus.chat.gallery.impl.preview.toolbar.action;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import yy8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class i0 implements com.larus.bmhome.share.panel.d {
    public h0 a;
    public final /* synthetic */ com.larus.bmhome.share.panel.d b;
    public final /* synthetic */ com.larus.bmhome.share.panel.d c;

    @Override // com.larus.bmhome.share.panel.d
    public final void f() {
    }

    @Override // com.larus.bmhome.share.panel.d
    public final void onDismiss() {
        this.b.onDismiss();
        this.c.onDismiss();
        h0 r0 = this.a;
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }

    @Override // com.larus.bmhome.share.panel.d
    public final void e(Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        h0 r1 = new h0(new Ref.BooleanRef(), r3);
        this.a = r1;
        this.b.e(r1);
        this.c.e(r1);
    }

    public i0(a r1, com.larus.bmhome.share.panel.d r2) {
        this.b = r1;
        this.c = r2;
    }

    @Override // com.larus.bmhome.share.panel.d
    public final boolean d(String r5, String r6, Boolean r7) {
        boolean r0 = this.b.d(r5, r6, r7);
        boolean r8 = this.c.d(r5, r6, r7);
        if (r0 == false) goto L6;
        if (r8 == false) goto L6;
        boolean r9 = true;
    L7:
        FLogger.a.i("ShareAction", "mergedListener.enableInterceptClick: channel=" + r6 + ", primary=" + r0 + ", secondary=" + r8 + ", result=" + r9);
        return r9;
    L6:
        r9 = false;
        goto L7
    }

    @Override // com.larus.bmhome.share.panel.d
    public final boolean b(Context r7, DialogFragment r8, View r9, jr9.a r10) {
        Intrinsics.checkNotNullParameter(r10, "shareItemConfig");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("mergedListener.onInterceptClick: channel=");
        r1.append(r10.b());
        r1.append(", sharePanelDialog=");
        if (r8 == null) goto L5;
        boolean r3 = true;
    L6:
        r1.append(r3);
        r0.i("ShareAction", r1.toString());
        boolean r2 = this.b.b(r7, r8, r9, r10);
        r0.i("ShareAction", "mergedListener.onInterceptClick: primary返回=" + r2);
        if (r2 == false) goto L9;
        return true;
    L9:
        boolean r11 = this.c.b(r7, r8, r9, r10);
        r0.i("ShareAction", "mergedListener.onInterceptClick: secondary返回=" + r11);
        return r11;
    L5:
        r3 = false;
        goto L6
    }
}
