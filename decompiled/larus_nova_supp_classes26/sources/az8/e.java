package az8;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.bigimg.m1;
import com.larus.bmhome.bigimg.widget.CreationSidebarView;
import com.larus.common.pollingconfig.api.PollingConfigService;
import com.larus.gallery.api.GalleryType;
import com.larus.gallery.api.t;
import com.larus.gallery.impl.databinding.LarusLayoutGalleryCreationSideBarBinding;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.image.loader.b0;
import com.larus.platform.model.chat.AiEditFilterScene;
import com.larus.platform.model.chat.h0;
import com.larus.utils.l0;
import com.larus.utils.y0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nr9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e extends t<ty8.b> {
    public final jy9.e f;
    public LarusLayoutGalleryCreationSideBarBinding g;
    public final Lazy h;

    public e(jy9.e r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.f = r2;
        this.h = LazyKt.lazy(new b(this));
    }

    public final View p(ViewGroup r12) {
        LarusLayoutGalleryCreationSideBarBinding r13 = LarusLayoutGalleryCreationSideBarBinding.a(LayoutInflater.from(getContext()), r12);
        this.g = r13;
        CreationSidebarView r0 = r13.b;
        if (r0 == null) goto L5;
        jy9.e r1 = this.f;
        ic8.d r2 = r1.a;
        CreationSidebarView.S5(r0, r1.b, r2, r1.c, r1.d, r1.e, ic8.d.a(r1.f, null, null, 55), new d(this), null, 384);
    L5:
        LarusLayoutGalleryCreationSideBarBinding r3 = this.g;
        if (r3 != null) goto L8;
        return null;
    L8:
        return r3.a;
    }

    public final void w(Object r10, int r11) {
        ty8.b r12 = (ty8.b) r10;
        Intrinsics.checkNotNullParameter(r12, "data");
        ((t) this).d = r12;
        LarusLayoutGalleryCreationSideBarBinding r13 = this.g;
        if (r13 == null) goto L112;
        CreationSidebarView r0 = r13.b;
        if (r0 == null) goto L113;
        m1 r14 = r12.b;
        GalleryType r1 = null;
        if (r14 == null) goto L9;
        String r15 = r14.a;
    L11:
        if (y0.e(r15) == true) goto L58;
        ty8.b r2 = (ty8.b) ((t) this).d;
        if (r2 == null) goto L58;
        Message r3 = r2.a;
        if (r3 == null) goto L58;
        if (lr8.c.a(r3) == false) goto L45;
        List r4 = com.larus.bmhome.chat.bean.d.f(r3).getEntities();
        if (r4 == null) goto L33;
        Iterator r5 = r4.iterator();
    L23:
        if (r5.hasNext() == false) goto L31;
        Object r6 = r5.next();
        String r7 = ((UplinkFileEntity) r6).getFileIdentifier();
        ty8.b r8 = (ty8.b) ((t) this).d;
        if (r8 == null) goto L27;
        String r9 = r8.h;
    L29:
        if (Intrinsics.areEqual(r7, r9) == false) goto L23;
    L32:
        UplinkFileEntity r16 = (UplinkFileEntity) r6;
    L34:
        if (r16 == null) goto L58;
        UplinkEntityContent r17 = r16.getUplinkEntityContent();
        if (r17 == null) goto L58;
        Image r18 = r17.getUplinkImageInfo();
        if (r18 == null) goto L58;
        ImageObj r19 = r18.previewImage;
        if (r19 != null) goto L42;
        r19 = r18.imageOri;
    L42:
        if (r19 == null) goto L56;
        r15 = r19.url;
    L56:
        r15 = null;
        goto L58
    L27:
        r9 = null;
        goto L29
    L31:
        r6 = null;
        goto L32
    L33:
        r16 = null;
        goto L34
    L45:
        if (r3.getContentType() != 6) goto L58;
        List r20 = com.larus.bmhome.chat.bean.d.g(r3).imageList;
        if (r20 == null) goto L49;
        Image r21 = (Image) CollectionsKt.firstOrNull(r20);
    L50:
        if (r21 == null) goto L58;
        ImageObj r110 = r21.previewImage;
        if (r110 != null) goto L54;
        r110 = r21.imageOri;
    L54:
        if (r110 == null) goto L56;
        r15 = r110.url;
        goto L58
    L49:
        r21 = null;
    L58:
        if (r15 == null) goto L60;
        Uri r111 = b0.a(r15, "common.photo_dialog_preview", false, false, 6);
    L61:
        m1 r22 = r12.b;
        g r23 = r12.c;
        final Message r112 = r12.a;
        if (Intrinsics.areEqual(PollingConfigService.a.f("cre_pic_sc_dg"), "1") == true) goto L106;
        boolean r24 = true;
        if (r112 != null) goto L66;
    L68:
        boolean r25 = false;
    L69:
        if (r25 == false) goto L106;
        AiEditFilterScene r26 = AiEditFilterScene.EDU;
        Lazy r27 = com.larus.chat.gallery.impl.e.a;
        if (((h0) r27.getValue()).a.d.contains(r26.getValue()) == false) goto L85;
        if (r112 == null) goto L76;
        Map r28 = r112.getExt();
        if (r28 == null) goto L76;
        String r29 = (String) r28.get("Copilot:hippo:hippo_ext");
    L77:
        if (r29 != null) goto L84;
        if (r112 != null) goto L80;
    L82:
        boolean r30 = false;
    L83:
        if (r30 == false) goto L85;
    L80:
        if (com.larus.bmhome.chat.bean.d.l0(r112) != true) goto L82;
        r30 = true;
    L84:
        boolean r31 = true;
    L86:
        if (r31 == true) goto L106;
        if (((h0) r27.getValue()).a.d.contains(AiEditFilterScene.HEALTH.getValue()) == false) goto L98;
        if (r112 == null) goto L93;
        Map r32 = r112.getExt();
        if (r32 == null) goto L93;
        String r33 = (String) r32.get("health_ext");
    L94:
        if (r33 != null) goto L97;
        int r34 = l0.a;
        if (((Boolean) l0.a(Boolean.FALSE, new c(r112))).booleanValue() == false) goto L98;
    L97:
        boolean r35 = true;
    L99:
        if (r35 == true) goto L106;
        ty8.b r36 = (ty8.b) ((t) this).d;
        if (r36 == null) goto L104;
        r1 = r36.e;
    L104:
        if (r1 == GalleryType.Video) goto L106;
    L107:
        CreationSidebarView.R5(r0, r111, r22, r23, r112, r24, null, 32);
        return;
    L93:
        r33 = null;
    L98:
        r35 = false;
    L76:
        r29 = null;
    L85:
        r31 = false;
        goto L86
    L66:
        if (com.larus.im.bean.message.a.e0(r112) == true) goto L68;
        r25 = true;
    L106:
        r24 = false;
        goto L107
    L60:
        r111 = null;
        goto L61
    L9:
        r15 = null;
        goto L11
    L113:
        return;
    }
}
