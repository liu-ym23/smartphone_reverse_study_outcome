package com.larus.bmhome.chat.layout.holder.helper;

import android.view.View;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageEntity;
import com.larus.bmhome.chat.layout.holder.image.bean.ImageItem;
import com.larus.bmhome.chat.layout.holder.menu.item.DownloadFileMenuHandler;
import com.larus.bmhome.chat.layout.holder.menu.item.NewCvsMenuHandler;
import com.larus.bmhome.chat.layout.holder.menu.item.SaveImageMenuHandler;
import com.larus.bmhome.chat.layout.holder.menu.item.SaveVideoMenuHandler;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.bmhome.chat.layout.holder.video.bean.CoverImageEntity;
import com.larus.bmhome.chat.layout.holder.video.bean.CoverItem;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import java.util.Iterator;
import java.util.List;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o extends a1 {
    public static final /* synthetic */ int m = 0;
    public final List<com.larus.bmhome.chat.layout.holder.menu.item.a> j;
    public final JSONObject k;
    public final Function0<Unit> l;

    public static final class a {
        public a() {
        }

        public static o a(Message r9, AttachReceiver r10, x2 r11, int r12) {
            int r0 = o.m;
            t0 r13 = r11;
            if ((r12 & 4) == 0) goto L5;
            r13 = new n0();
        L5:
            t0 r4 = r13;
            if ((r12 & 8) == 0) goto L8;
            List r5 = CollectionsKt.emptyList();
        L9:
            Intrinsics.checkNotNullParameter(r9, "data");
            Intrinsics.checkNotNullParameter(r10, "component");
            Intrinsics.checkNotNullParameter(r4, "popMenuGroupCreator");
            Intrinsics.checkNotNullParameter(r5, "extraHandlers");
            u7 r14 = (u7) LazyKt.lazy(new n(r10)).getValue();
            if (r14 == null) goto L12;
            MessageAdapter r15 = r14.MF();
        L14:
            if ((r15 instanceof com.larus.bmhome.chat.api.q0) == false) goto L16;
            MessageAdapter r2 = r15;
        L18:
            if (r2 == null) goto L20;
            com.larus.bmhome.chat.api.q0.a r3 = r2.getProvider();
        L22:
            return new o(r9, r2, r3, r4, r5, null, null, 64);
        L20:
            r3 = null;
            goto L22
        L16:
            r2 = null;
            goto L18
        L12:
            r15 = null;
            goto L14
        L8:
            r5 = null;
            goto L9
        }
    }

    static {
        new a();
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.a1
    public final void d() {
        this.l.invoke();
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.a1
    public final void a(com.larus.bmhome.chat.layout.holder.menu.item.a.C0061a r3) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        r3.a(new com.larus.bmhome.chat.layout.holder.menu.item.w());
        r3.a(new com.larus.bmhome.chat.layout.holder.menu.item.o());
        r3.a(new com.larus.bmhome.chat.layout.holder.menu.item.v0());
        r3.a(new com.larus.bmhome.chat.layout.holder.menu.item.a1());
        r3.a(new com.larus.bmhome.chat.layout.holder.menu.item.y0());
        r3.a(new SaveImageMenuHandler());
        r3.a(new SaveVideoMenuHandler());
        r3.a(new DownloadFileMenuHandler());
        r3.a(new com.larus.bmhome.chat.layout.holder.menu.item.h());
        r3.a(new com.larus.bmhome.chat.layout.holder.menu.item.e());
        r3.a(new com.larus.bmhome.chat.layout.holder.menu.item.a0());
        r3.a(new NewCvsMenuHandler());
        r3.a(new com.larus.bmhome.chat.layout.holder.menu.item.m0());
        r3.a(new com.larus.bmhome.chat.layout.holder.menu.item.m());
        r3.a(new com.larus.bmhome.chat.layout.holder.menu.item.k());
        r3.a(new com.larus.bmhome.chat.layout.holder.menu.item.s());
        Iterator<T> r0 = this.j.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r3.a((com.larus.bmhome.chat.layout.holder.menu.item.a) r0.next());
        goto L4
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.a1
    public final ef8.b c(final View r36) {
        Intrinsics.checkNotNullParameter(r36, "view");
        JSONObject r2 = this.f;
        boolean r3 = true;
        AiGenVideoContentData r4 = null;
        if (r2 == null) goto L9;
        String r5 = r2.optString("attachment_target_file_identifier");
        if (r5 == null) goto L9;
        if ((!StringsKt.isBlank(r5)) == false) goto L9;
    L10:
        Integer r6 = a1.e(this.k);
        if (r6 == null) goto L26;
        int r7 = r6.intValue();
        ic8.u r8 = ic8.u.a;
        Message r9 = this.a;
        r8.getClass();
        UplinkFileEntity r10 = ic8.u.b(r9, r5);
        if (r10 != null) goto L16;
        UplinkFileEntity r17 = null;
    L28:
        Message r11 = this.a;
        com.larus.bmhome.chat.api.q0.a r12 = this.c;
        com.larus.bmhome.chat.api.q0 r13 = this.b;
        by7.e r14 = by7.h.g(r36);
        Function0 r15 = new m(r36);
        if (r17 == null) goto L59;
        UplinkEntityContent r1 = r17.getUplinkEntityContent();
        if (r1 == null) goto L57;
        Image r16 = r1.getUplinkImageInfo();
        if (r16 == null) goto L57;
        int r18 = 0;
        if (r5 != null) goto L38;
    L41:
        if (r3 == true) goto L53;
        ic8.u r19 = ic8.u.a;
        Message r110 = this.a;
        r19.getClass();
        Iterator r20 = ic8.u.a(r110).iterator();
        int r111 = 0;
    L45:
        if (r20.hasNext() == false) goto L50;
        if (Intrinsics.areEqual(((UplinkFileEntity) r20.next()).getFileIdentifier(), r5) == true) goto L51;
        r111 = r111 + 1;
    L51:
        if (r111 < 0) goto L53;
        r18 = r111;
        goto L53
    L50:
        r111 = -1;
    L53:
        String r112 = r16.key;
        ImageEntity r21 = p.a(r16.imageThumb);
        ImageEntity r22 = p.a(r16.imageOri);
        ImageEntity r23 = p.a(r16.previewImage);
        if (r5 != null) goto L56;
        r5 = r16.identifier;
    L56:
        df8.a r24 = new df8.a(r18, new ImageItem(r112, null, r21, r22, r23, null, null, null, null, null, null, false, r5, null, 12258, null), null, null);
    L58:
        df8.a r113 = r24;
    L61:
        if (r17 == null) goto L92;
        UplinkEntityContent r25 = r17.getUplinkEntityContent();
        if (r25 == null) goto L90;
        UplinkFileInfo r26 = r25.getUplinkFileInfo();
        if (r26 == null) goto L90;
        VideoExtension r27 = r26.getVideo();
        if (r27 == null) goto L91;
        String r114 = r27.getVid();
        Integer r28 = r27.getWidth();
        Integer r29 = r27.getHeight();
        Image r30 = r27.getCover();
        if (r30 != null) goto L73;
        CoverItem r210 = null;
    L81:
        String r31 = r27.getPath();
        if (r31 != null) goto L84;
        String r211 = r26.getLocalResPath();
    L85:
        String r212 = r27.getDownloadUrl();
        String r213 = r27.getDownloadFilehash();
        Float r32 = r27.getDuration();
        if (r32 == null) goto L88;
        Double r214 = Double.valueOf(r32.floatValue());
    L89:
        r4 = new AiGenVideoContentData(r114, r28, r29, null, r210, null, r211, r212, r213, r214, r27.getFormat(), null, null, 6184, null);
        goto L91
    L88:
        r214 = null;
        goto L89
    L84:
        r211 = r31;
        goto L85
    L73:
        String r33 = r30.key;
        CoverImageEntity r115 = p.b(r30.imageThumb);
        if (r115 != null) goto L76;
        r115 = p.b(r30.previewImage);
    L76:
        CoverImageEntity r215 = r115;
        CoverImageEntity r116 = p.b(r30.previewImage);
        if (r116 != null) goto L79;
        CoverImageEntity r216 = p.b(r30.imageOri);
    L80:
        r210 = new CoverItem(r33, r215, r216, null, 8, null);
        goto L81
    L79:
        r216 = r116;
    L91:
        AiGenVideoContentData r117 = r4;
    L94:
        return new ef8.b(r11, r12, r13, r14, r15, r113, null, null, r117, r17, this.k, 448);
    L90:
        r4 = null;
        goto L91
    L92:
        r117 = null;
        goto L94
    L38:
        if (StringsKt.isBlank(r5) == true) goto L41;
        r3 = false;
    L57:
        r24 = null;
        goto L58
    L59:
        r113 = null;
        goto L61
    L16:
        if (r7 == 5) goto L24;
        if (r7 == 6) goto L21;
    L27:
        r17 = r10;
        goto L28
    L21:
        if (yc9.n1.d(r10) == false) goto L26;
    L24:
        if (yc9.n1.e(r10) == true) goto L27;
    L26:
        r10 = null;
    L9:
        r5 = null;
        goto L10
    }

    public o(Message r8, com.larus.bmhome.chat.api.q0 r9, com.larus.bmhome.chat.api.q0.a r10, t0 r11, List r12, JSONObject r13, ag8.l r14, int r15) {
        if ((r15 & 8) == 0) goto L5;
        r11 = new n0();
    L5:
        t0 r4 = r11;
        if ((r15 & 16) == 0) goto L9;
        r12 = CollectionsKt.emptyList();
    L9:
        if ((r15 & 32) == 0) goto L11;
        r13 = null;
    L11:
        Function0<Unit> r16 = r14;
        if ((r15 & 64) == 0) goto L14;
        r16 = new l();
    L14:
        Intrinsics.checkNotNullParameter(r8, "data");
        Intrinsics.checkNotNullParameter(r4, "popMenuGroupCreator");
        Intrinsics.checkNotNullParameter(r12, "extraHandlers");
        Intrinsics.checkNotNullParameter(r16, "onLongClick");
        super(r8, r9, r10, r4, r13, 16);
        this.j = r12;
        this.k = r13;
        this.l = r16;
    }
}
