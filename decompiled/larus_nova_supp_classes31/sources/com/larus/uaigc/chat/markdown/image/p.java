package com.larus.uaigc.chat.markdown.image;

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
public final class p implements i0 {
    public final /* synthetic */ fz9.d a;
    public final /* synthetic */ MDImageScrollAdapter.MDImageScrollViewHolder b;

    public final void a() {
        Message r0 = this.a.d;
        if (r0 == null) goto L7;
        Map r1 = r0.getBusinessExt();
        if (r1 == null) goto L7;
        String r2 = (String) r1.get("message_case_mode");
    L9:
        if (Intrinsics.areEqual(r2, "1") == false) goto L15;
        t19.s r3 = t19.s.a;
        AppHost.Companion r4 = AppHost.a;
        Application r5 = r4.getApplication();
        String r6 = r4.getApplication().getString(2131909395);
        if (r6 != null) goto L13;
        r6 = "";
    L13:
        r3.getClass();
        t19.s.t(r5, r6);
        return;
    L15:
        ImageEditorComponent r7 = (ImageEditorComponent) this.b.k.getValue();
        if (r7 == null) goto L25;
        ImageInfo r8 = this.a.f;
        if (r8 == null) goto L22;
        Image r9 = r8.c;
        if (r9 == null) goto L22;
        String r10 = r9.a;
    L23:
        r7.b(r10, null);
        return;
    L22:
        r10 = null;
        goto L23
    L25:
        return;
    L7:
        r2 = null;
        goto L9
    }

    public final void b() {
        VideoEditorComponent r0 = (VideoEditorComponent) this.b.l.getValue();
        if (r0 == null) goto L12;
        ImageInfo r1 = this.a.f;
        if (r1 == null) goto L9;
        Image r2 = r1.c;
        if (r2 == null) goto L9;
        String r3 = r2.a;
    L10:
        r0.b(r3);
        return;
    L9:
        r3 = null;
        goto L10
    }

    public p(fz9.d r1, MDImageScrollAdapter.MDImageScrollViewHolder r2) {
        this.a = r1;
        this.b = r2;
    }
}
