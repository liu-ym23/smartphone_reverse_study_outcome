package com.larus.uaigc.creation.gallery.datasource;

import android.graphics.Bitmap;
import com.larus.bmhome.bigimg.n1;
import com.larus.bmhome.chat.api.q0;
import com.larus.chat.gallery.api.datasource.BaseChatDataSource;
import com.larus.gallery.api.GalleryType;
import com.larus.gallery.api.k;
import com.larus.gallery.api.m;
import com.larus.gallery.api.q;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.chat.n;
import com.larus.platform.service.z2;
import java.util.Iterator;
import java.util.List;
import jy9.x;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j extends BaseChatDataSource<sz9.b> {
    public final x i;
    public int j;

    public final int l() {
        int r0 = this.j;
        int r1 = -1;
        if (r0 == (-1)) goto L5;
        return r0;
    L5:
        List<Message> r2 = m();
        int r3 = 0;
        if (r2 == null) goto L19;
        Iterator<Message> r4 = r2.iterator();
        int r5 = 0;
    L9:
        if (r4.hasNext() == false) goto L18;
        String r6 = r4.next().getMessageId();
        Message r7 = this.i.a;
        if (r7 == null) goto L13;
        String r8 = r7.getMessageId();
    L15:
        if (Intrinsics.areEqual(r6, r8) == true) goto L16;
        r5 = r5 + 1;
        goto L9
    L16:
        r1 = r5;
        goto L18
    L13:
        r8 = null;
    L18:
        r3 = RangesKt.coerceAtLeast(r1, 0);
    L19:
        this.j = r3;
        return r3;
    }

    public final List<Message> m() {
        Function0<List<Message>> r0 = this.i.u;
        if (r0 == null) goto L6;
        List<Message> r1 = (List) r0.invoke();
        if (r1 == null) goto L6;
        return r1;
    L6:
        q0.a r2 = this.i.b;
        if (r2 == null) goto L11;
        q0 r3 = r2.e();
        if (r3 == null) goto L11;
        return r3.getCurrentList();
    L11:
        return null;
    }

    public j(x r3) {
        Intrinsics.checkNotNullParameter(r3, "galleryContext");
        super(CollectionsKt.listOf("chat_creation"), r3.a);
        this.i = r3;
        this.j = -1;
    }

    public final Object i(Object r21, Continuation r22) {
        sz9.b r0 = (sz9.b) r21;
        zo8.b r1 = r0.c;
        if (r1 == null) goto L37;
        GalleryType r3 = GalleryType.Image;
        n1 r2 = r1.a;
        String r11 = r2.a;
        String r12 = r1.b;
        Long r4 = r2.f;
        Bitmap.Config r5 = null;
        if (r4 == null) goto L7;
        Integer r13 = Boxing.boxInt((int) r4.longValue());
    L8:
        Long r6 = r0.c.a.g;
        if (r6 == null) goto L11;
        Integer r14 = Boxing.boxInt((int) r6.longValue());
    L12:
        z2 r7 = z2.a;
        if (r7.ugcPreviewUseARGB() == false) goto L15;
        r5 = Bitmap.Config.ARGB_8888;
    L15:
        Bitmap.Config r15 = r5;
        boolean r8 = true;
        if (r7.getCreationPreviewPerformanceOptConfig().b == false) goto L27;
        n r9 = r7.getCreationPreviewPerformanceOptConfig();
        if (r9.b == true) goto L20;
    L24:
        boolean r10 = false;
    L25:
        if (r10 == true) goto L27;
        boolean r16 = true;
    L28:
        n r17 = r7.getCreationPreviewPerformanceOptConfig();
        if (r17.b == true) goto L31;
    L35:
        r8 = false;
    L42:
        return new k(r3, new m(r11, r12, r13, r14, r15, Boxing.boxBoolean(r16), Boxing.boxBoolean(r8), "common.photo_dialog_preview_v2", Boxing.boxInt(r7.getCreationPreviewPerformanceOptConfig().c)), null, null, r0.a, 12);
    L31:
        if (r17.c <= 0) goto L35;
        if (r7.a2() == false) goto L35;
    L20:
        if (r9.c <= 0) goto L24;
        if (r7.a2() == false) goto L24;
        r10 = true;
    L27:
        r16 = false;
        goto L28
    L11:
        r14 = null;
        goto L12
    L7:
        r13 = null;
        goto L8
    L37:
        zo8.e r18 = r0.d;
        if (r18 == null) goto L41;
        return new k(GalleryType.Video, null, new q(r18.e, r18.c, r18.d, "ugc_video", "immersive_preview", r0.g), null, r0.a, 10);
    L41:
        return new k(GalleryType.Image, null, null, null, r0.a, 14);
    }

    public final Object o(Message r3, Continuation<? super List<sz9.b>> r4) {
        return CreationDataSourceHelper.a.a(this.i, r3, r4);
    }
}
