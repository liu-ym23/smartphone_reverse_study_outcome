package com.larus.uaigc.chat.block.widget.image;

import android.app.Application;
import com.larus.bmhome.chat.layout.widget.i0;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.Image;
import com.larus.platform.api.ImageInfo;
import com.larus.uaigc.chat.markdown.image.component.ImageEditorComponent;
import com.larus.uaigc.chat.markdown.image.component.VideoEditorComponent;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class l implements i0 {
    public final /* synthetic */ cz9.h a;
    public final /* synthetic */ ImageItemViewHolder b;

    public final void a() {
        Message r0 = this.a.e;
        String r1 = null;
        if (r0 == null) goto L7;
        Map r2 = r0.getBusinessExt();
        if (r2 == null) goto L7;
        String r3 = (String) r2.get("message_case_mode");
    L9:
        if (Intrinsics.areEqual(r3, "1") == false) goto L15;
        t19.s r4 = t19.s.a;
        AppHost.Companion r5 = AppHost.a;
        Application r6 = r5.getApplication();
        String r7 = r5.getApplication().getString(2131909395);
        if (r7 != null) goto L13;
        r7 = "";
    L13:
        r4.getClass();
        t19.s.t(r6, r7);
        return;
    L15:
        ImageItemViewHolder r8 = this.b;
        cz9.h r9 = this.a;
        int r10 = ImageItemViewHolder.v;
        r8.getClass();
        ImageInfo r11 = ImageItemViewHolder.X3(r9);
        ImageEditorComponent r12 = (ImageEditorComponent) this.b.m.getValue();
        if (r12 == null) goto L31;
        ImageItemViewHolder r13 = this.b;
        cz9.h r14 = this.a;
        r13.getClass();
        String r15 = ImageItemViewHolder.Y3(r14, r11);
        if (r11 == null) goto L25;
        Image r16 = r11.i;
        if (r16 == null) goto L25;
        String r17 = bz9.a.b(r16);
        if (r17 == null) goto L25;
        r1 = r17;
    L29:
        r12.b(r15, r1);
        return;
    L25:
        if (r11 == null) goto L29;
        Image r18 = r11.a;
        if (r18 == null) goto L29;
        r1 = bz9.a.b(r18);
        goto L29
    L31:
        return;
    L7:
        r3 = null;
        goto L9
    }

    public final void b() {
        VideoEditorComponent r0 = (VideoEditorComponent) this.b.n.getValue();
        if (r0 == null) goto L6;
        ImageItemViewHolder r1 = this.b;
        cz9.h r2 = this.a;
        r1.getClass();
        r0.b(ImageItemViewHolder.Y3(r2, ImageItemViewHolder.X3(r2)));
        return;
    }

    public l(cz9.h r1, ImageItemViewHolder r2) {
        this.a = r1;
        this.b = r2;
    }
}
