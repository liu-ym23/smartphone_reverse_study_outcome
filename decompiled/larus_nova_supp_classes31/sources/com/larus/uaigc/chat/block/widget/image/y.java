package com.larus.uaigc.chat.block.widget.image;

import android.app.Application;
import com.larus.bmhome.chat.layout.widget.i0;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.LocalImageData;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.uaigc.chat.markdown.image.component.ImageEditorComponent;
import com.larus.uaigc.chat.markdown.image.component.VideoEditorComponent;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class y implements i0 {
    public final /* synthetic */ cz9.m a;
    public final /* synthetic */ LocalImageItemViewHolder b;

    public final void a() {
        Message r0 = this.a.e;
        String r1 = null;
        if (r0 == null) goto L7;
        Map r2 = r0.getBusinessExt();
        if (r2 == null) goto L7;
        String r3 = (String) r2.get("message_case_mode");
    L8:
        String r4 = "";
        if (Intrinsics.areEqual(r3, "1") == false) goto L16;
        t19.s r5 = t19.s.a;
        AppHost.Companion r6 = AppHost.a;
        Application r7 = r6.getApplication();
        String r8 = r6.getApplication().getString(2131909395);
        if (r8 == null) goto L14;
        r4 = r8;
    L14:
        r5.getClass();
        t19.s.t(r7, r4);
        return;
    L16:
        CreationItem r9 = this.a.d;
        if (r9 == null) goto L19;
        ImageInfo r10 = bz9.c.o(r9);
    L20:
        ImageEditorComponent r11 = (ImageEditorComponent) this.b.m.getValue();
        if (r11 == null) goto L46;
        CreationItem r12 = this.a.d;
        if (r12 == null) goto L29;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        LocalImageData r13 = r12.localImage;
        if (r13 == null) goto L29;
        String r14 = bz9.c.l(r13);
        if (r14 != null) goto L30;
        r14 = bz9.c.k(r13);
    L30:
        if (r14 == null) goto L33;
        r4 = r14;
    L33:
        if (r10 == null) goto L40;
        Image r15 = r10.i;
        if (r15 == null) goto L40;
        String r16 = bz9.a.b(r15);
        if (r16 == null) goto L40;
        r1 = r16;
    L44:
        r11.b(r4, r1);
        return;
    L40:
        if (r10 == null) goto L44;
        Image r17 = r10.a;
        if (r17 == null) goto L44;
        r1 = bz9.a.b(r17);
    L29:
        r14 = null;
        goto L30
    L46:
        return;
    L19:
        r10 = null;
    L7:
        r3 = null;
        goto L8
    }

    public final void b() {
        VideoEditorComponent r0 = (VideoEditorComponent) this.b.n.getValue();
        if (r0 == null) goto L15;
        CreationItem r1 = this.a.d;
        String r2 = null;
        if (r1 == null) goto L11;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        LocalImageData r3 = r1.localImage;
        if (r3 == null) goto L11;
        r2 = bz9.c.l(r3);
        if (r2 != null) goto L11;
        r2 = bz9.c.k(r3);
    L11:
        if (r2 != null) goto L13;
        r2 = "";
    L13:
        r0.b(r2);
        return;
    }

    public y(cz9.m r1, LocalImageItemViewHolder r2) {
        this.a = r1;
        this.b = r2;
    }
}
