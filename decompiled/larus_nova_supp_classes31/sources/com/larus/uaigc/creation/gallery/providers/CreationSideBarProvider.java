package com.larus.uaigc.creation.gallery.providers;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.bigimg.m1;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.bigimg.widget.CreationSidebarView;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.gallery.impl.databinding.LarusLayoutGalleryCreationSideBarBinding;
import com.larus.im.bean.message.Message;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CreationSideBarProvider extends com.larus.gallery.api.t<sz9.b> {
    public final jy9.e f;
    public LarusLayoutGalleryCreationSideBarBinding g;
    public final Lazy h;

    public CreationSideBarProvider(jy9.e r2) {
        Intrinsics.checkNotNullParameter(r2, "aiEditParams");
        this.f = r2;
        this.h = LazyKt.lazy(new w(this));
    }

    public final View p(ViewGroup r12) {
        LarusLayoutGalleryCreationSideBarBinding r13 = LarusLayoutGalleryCreationSideBarBinding.a(LayoutInflater.from(getContext()), r12);
        this.g = r13;
        CreationSidebarView r0 = r13.b;
        if (r0 == null) goto L5;
        jy9.e r1 = this.f;
        ic8.d r2 = r1.b;
        ic8.d r3 = r1.a;
        ic8.d r4 = ic8.d.a(r1.c, new s(this), null, 61);
        jy9.e r5 = this.f;
        CreationSidebarView.S5(r0, r2, r3, r4, r5.d, ic8.d.a(r5.e, new t(this), null, 61), ic8.d.a(this.f.f, null, new u(this), 31), new v(this), null, 384);
    L5:
        LarusLayoutGalleryCreationSideBarBinding r6 = this.g;
        if (r6 != null) goto L8;
        return null;
    L8:
        return r6.a;
    }

    public final void w(Object r12, int r13) {
        sz9.b r14 = (sz9.b) r12;
        Intrinsics.checkNotNullParameter(r14, "data");
        ((com.larus.gallery.api.t) this).d = r14;
        LarusLayoutGalleryCreationSideBarBinding r15 = this.g;
        if (r15 == null) goto L63;
        CreationSidebarView r0 = r15.b;
        if (r0 == null) goto L64;
        zo8.b r16 = r14.c;
        nr9.g r2 = null;
        if (r16 == null) goto L13;
        n1 r17 = r16.a;
        if (r17 == null) goto L13;
        String r18 = r17.a;
        if (r18 == null) goto L13;
        Uri r19 = com.larus.image.loader.b0.a(r18, "common.photo_dialog_preview", false, false, 6);
    L14:
        zo8.b r3 = r14.c;
        if (r3 == null) goto L19;
        n1 r4 = r3.a;
        if (r4 == null) goto L19;
        String r5 = r4.a;
    L20:
        if (r3 == null) goto L22;
        String r6 = r3.b;
    L23:
        if (r3 == null) goto L27;
        n1 r7 = r3.a;
        if (r7 == null) goto L27;
        String r8 = r7.c;
    L28:
        if (r3 == null) goto L34;
        n1 r9 = r3.a;
        if (r9 == null) goto L34;
        Long r10 = r9.f;
        if (r10 == null) goto L34;
        Integer r11 = Integer.valueOf((int) r10.longValue());
    L35:
        zo8.b r20 = r14.c;
        if (r20 == null) goto L42;
        n1 r21 = r20.a;
        if (r21 == null) goto L42;
        Long r22 = r21.g;
        if (r22 == null) goto L42;
        Integer r23 = Integer.valueOf((int) r22.longValue());
    L43:
        zo8.b r24 = r14.c;
        if (r24 == null) goto L46;
        String r25 = r24.d;
    L47:
        m1 r110 = new m1(r5, r6, r8, r11, r23, r25);
        zo8.e r26 = r14.d;
        if (r26 == null) goto L50;
        r2 = r26.c;
    L50:
        nr9.g r27 = r2;
        Message r28 = r14.a;
        if (r28 != null) goto L53;
    L55:
        boolean r29 = false;
    L56:
        if (r29 == false) goto L58;
    L60:
        boolean r30 = false;
    L61:
        CreationSidebarView.R5(r0, r19, r110, r27, r28, r30, null, 32);
        return;
    L58:
        if (Intrinsics.areEqual(PollingConfigService.a.f("cre_pic_sc_dg"), "1") == true) goto L60;
        r30 = true;
        goto L61
    L53:
        if (com.larus.im.bean.message.a.e0(r28) != true) goto L55;
        r29 = true;
        goto L56
    L46:
        r25 = null;
    L42:
        r23 = null;
    L34:
        r11 = null;
    L27:
        r8 = null;
        goto L28
    L22:
        r6 = null;
    L19:
        r5 = null;
    L13:
        r19 = null;
        goto L14
    L64:
        return;
    }
}
