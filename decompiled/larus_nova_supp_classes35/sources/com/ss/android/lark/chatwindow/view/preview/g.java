package com.ss.android.lark.chatwindow.view.preview;

import b3b.t;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.UrlPreviewBody;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g implements vcb.a {
    public final /* synthetic */ h2b.c a;
    public final /* synthetic */ UrlPreviewBinder b;

    public g(h2b.c r1, UrlPreviewBinder r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // vcb.a
    public final void a(String r5, String r6) {
        if (this.a == null) goto L31;
        if (r6 != null) goto L6;
    L9:
        boolean r0 = true;
    L10:
        if (r0 == true) goto L31;
        Map<String, PreviewHangPoint> r1 = this.a.a;
        if (r1 == null) goto L21;
        Collection<PreviewHangPoint> r2 = r1.values();
        if (r2 == null) goto L21;
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L17:
        if (r4.hasNext() == false) goto L22;
        Object r7 = r4.next();
        if (Intrinsics.areEqual(((PreviewHangPoint) r7).getPreviewId(), r5) == false) goto L17;
        r3.add(r7);
    L22:
        if (r3 == null) goto L31;
        Iterator r8 = r3.iterator();
    L25:
        if (r8.hasNext() == false) goto L31;
        UrlCardPreviewEntity r9 = ((PreviewHangPoint) r8.next()).getUrlCardPreviewEntity();
        if (r9 == null) goto L25;
        UrlPreviewBody r10 = r9.getPreviewBody();
        if (r10 == null) goto L25;
        r10.setCurrentStateId(r6);
    L21:
        r3 = null;
        goto L22
    L6:
        if (r6.length() == 0) goto L9;
        r0 = false;
    L31:
        UrlPreviewBinder r11 = this.b;
        t r12 = r11.e;
        if (r12 == null) goto L47;
        r12.E(r11.c.getMessageId());
        return;
    }
}
