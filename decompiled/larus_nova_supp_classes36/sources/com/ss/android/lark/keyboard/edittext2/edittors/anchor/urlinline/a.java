package com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline;

import android.webkit.URLUtil;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.richtext.RichTextElement;
import hob.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class a extends fob.a<j> {
    @Override // fob.a
    public final boolean a(RichTextElement.AnchorProperty r2) {
        Intrinsics.checkNotNullParameter(r2, "property");
        return true;
    }

    public a(eob.a r2) {
        Intrinsics.checkNotNullParameter(r2, "editor");
        super(r2);
    }

    @Override // fob.a
    public /* bridge */ /* synthetic */ hob.b b(RichTextElement.AnchorProperty r1) {
        return c(r1);
    }

    public j c(RichTextElement.AnchorProperty r18) {
        Intrinsics.checkNotNullParameter(r18, "property");
        int r2 = com.ss.android.lark.keyboard.edittext2.utils.a.a;
        Intrinsics.checkNotNullParameter(r18, "property");
        String r3 = r18.getContent();
        String r4 = r18.getHref();
        if (URLUtil.isNetworkUrl(r3) == false) goto L10;
        Intrinsics.checkNotNull(r4);
        if (com.ss.android.lark.keyboard.edittext2.utils.a.a(r4) == true) goto L9;
        r3 = r4;
    L9:
        r4 = r3;
    L10:
        String r5 = "";
        if (r4 != null) goto L13;
        r4 = "";
    L13:
        j r6 = new j(r4);
        String r7 = r18.getDisplayTitle();
        if (r7 != null) goto L16;
        r7 = "";
    L16:
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r6.e = r7;
        String r8 = r18.getIconKey();
        int r9 = r18.getLocalIconRes();
        String r10 = r18.getDisplayTitle();
        String r11 = r18.getUnicode();
        int r12 = r18.getIconColor();
        boolean r13 = r18.isColorIcon();
        String r14 = r18.getFaviconUrl();
        Intrinsics.checkNotNullParameter(r18, "property");
        String r1 = r18.getIconKey();
        int r15 = r18.getLocalIconRes();
        String r16 = r18.getDisplayTitle();
        String r17 = r18.getUnicode();
        String r0 = r18.getFaviconUrl();
        if (r16 != null) goto L19;
    L22:
        boolean r19 = true;
    L23:
        boolean r110 = true;
        boolean r111 = !r19;
        if (r1 != null) goto L26;
    L29:
        boolean r20 = true;
    L30:
        if (r20 == false) goto L48;
        if (r15 != 0) goto L48;
        if (r17 != null) goto L34;
    L37:
        boolean r21 = true;
    L38:
        if (r21 == false) goto L48;
        if (r0 != null) goto L41;
    L44:
        boolean r22 = true;
    L45:
        if (r22 == false) goto L48;
        boolean r23 = false;
    L50:
        if (r111 == false) goto L52;
        if (r23 == false) goto L52;
    L53:
        if (r110 == true) goto L55;
        Log.i("IMAnchorCoordinator", "appendAnchorDataIfNeed: data is not enough to create anchor span , parse from net is true.");
    L62:
        return r6;
    L55:
        if (r9 == 0) goto L57;
        r6.f.a = r9;
    L57:
        j.a r24 = r6.f;
        if (r8 == null) goto L61;
        r5 = r8;
    L61:
        r24.getClass();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r24.b = r5;
        j.a r25 = r6.f;
        r25.c = r11;
        r25.f = r12;
        r25.d = r14;
        r25.e = r13;
        Intrinsics.checkNotNull(r10);
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r6.e = r10;
        r6.d = false;
    L52:
        Log.i("IMAnchorCoordinator", "appendAnchorDataIfNeed: data is not enough to create anchor span , parse from net is true.");
        r110 = false;
        goto L53
    L41:
        if (r0.length() == 0) goto L44;
        r22 = false;
        goto L45
    L34:
        if (r17.length() == 0) goto L37;
        r21 = false;
    L48:
        r23 = true;
        goto L50
    L26:
        if (r1.length() == 0) goto L29;
        r20 = false;
        goto L30
    L19:
        if (r16.length() == 0) goto L22;
        r19 = false;
        goto L23
    }
}
