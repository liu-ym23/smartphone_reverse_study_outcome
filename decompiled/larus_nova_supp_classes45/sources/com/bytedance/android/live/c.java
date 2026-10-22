package com.bytedance.android.live;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.chatroom.ui.DouyinLoadingLayout;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.view.PreviewType;
import com.bytedance.android.livesdk.chatroom.view.SharePanelPreviewProgressBar;
import com.bytedance.android.livesdkapi.depend.model.match.CollectionItem;
import com.bytedance.android.livesdkapi.util.VSVideoUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.videoshop.context.VideoContext;
import com.ss.android.videoshop.mediaview.LayerHostMediaLayout;
import com.ss.android.videoshop.mediaview.SimpleMediaView;
import com.ss.android.videoshop.mediaview.VideoPatchLayout;
import com.ss.ttvideoengine.Resolution;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(boolean r1, boolean r2, ViewGroup r3, int r4) {
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if (r1 == false) goto L5;
        r0.height = (int) (r4 * 0.5625f);
        r0.width = r4;
    L7:
        r3.setLayoutParams(r0);
        r3.requestLayout();
        return;
    L5:
        if (r2 == true) goto L7;
        r0.height = (int) ((s1.t() * s1.t()) / s1.r());
        goto L7
    }

    @JvmStatic
    public static final void b(boolean r7, ViewGroup r8, com.bytedance.android.livesdk.chatroom.view.f r9, int r11, CollectionItem r12) {
        Intrinsics.checkNotNullParameter(r8, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r9, "player");
        if (r12 == null) goto L149;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r8, KtvSubElement.CONTAINER);
        k r1 = null;
        if (r9.a != null) goto L53;
        View r0 = LayoutInflater.from(r8.getContext()).inflate(2131567453, r8, false);
        if (r0 == null) goto L52;
        r9.a = r0;
        r9.b = r0.findViewById(2131382944);
        View r2 = r9.a;
        if (r2 == null) goto L11;
        HSImageView r3 = (HSImageView) r2.findViewById(2131382921);
    L12:
        r9.c = r3;
        View r4 = r9.a;
        if (r4 == null) goto L15;
        View r5 = r4.findViewById(2131382943);
    L16:
        r9.d = r5;
        View r6 = r9.a;
        if (r6 == null) goto L19;
        SharePanelPreviewProgressBar r13 = (SharePanelPreviewProgressBar) r6.findViewById(2131382946);
    L20:
        r9.e = r13;
        View r14 = r9.a;
        if (r14 == null) goto L23;
        TextView r15 = (TextView) r14.findViewById(2131382915);
    L24:
        r9.f = r15;
        View r16 = r9.a;
        if (r16 == null) goto L27;
        DouyinLoadingLayout r17 = (DouyinLoadingLayout) r16.findViewById(2131382929);
    L28:
        r9.g = r17;
        View r18 = r9.a;
        if (r18 == null) goto L31;
        ImageView r19 = (ImageView) r18.findViewById(2131375078);
    L32:
        r9.h = r19;
        SimpleMediaView r21 = r9.b;
        if (r21 == null) goto L48;
        Resolution r22 = Resolution.Standard;
        LayerHostMediaLayout r23 = r21.c;
        if (r23 == null) goto L39;
        qic.a r24 = ((VideoPatchLayout) r23).j;
        if (r24 == null) goto L48;
        r24.setResolution(r22, false);
        goto L48
    L39:
        VideoContext r25 = r21.e;
        if (r25 == null) goto L48;
        if (r25.r0(r21) == false) goto L48;
        LayerHostMediaLayout r26 = r21.e.c;
        if (r26 == null) goto L48;
        qic.a r27 = ((VideoPatchLayout) r26).j;
        if (r27 == null) goto L48;
        r27.setResolution(r22, false);
    L48:
        SimpleMediaView r28 = r9.b;
        if (r28 == null) goto L53;
        r28.setOnClickListener(new com.bytedance.android.livesdk.chatroom.view.h(r9));
        goto L53
    L31:
        r19 = null;
        goto L32
    L27:
        r17 = null;
        goto L28
    L23:
        r15 = null;
        goto L24
    L19:
        r13 = null;
        goto L20
    L15:
        r5 = null;
        goto L16
    L11:
        r3 = null;
        goto L12
    L52:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L53:
        View r29 = r9.a;
        if (r29 != null) goto L56;
    L64:
        SimpleMediaView r31 = r9.b;
        if (r31 == null) goto L67;
        tic.a r32 = r31.getPlayEntity();
    L69:
        if (r32 != null) goto L79;
        SimpleMediaView r33 = r9.b;
        if (r33 == null) goto L73;
        tic.a r34 = new tic.a();
        ejc.b r35 = ejc.b.a();
        r35.g = 0;
        r35.b = false;
        Unit r36 = Unit.INSTANCE;
        r34.o = r35;
        r34.k = "share_panel_preview";
        r34.l = "share_panel_preview";
        r33.setPlayEntity(r34);
    L73:
        SimpleMediaView r37 = r9.b;
        if (r37 == null) goto L76;
        r37.setVideoEngineFactory(com.bytedance.android.livesdk.chatroom.view.i.a);
    L76:
        SimpleMediaView r38 = r9.b;
        if (r38 == null) goto L79;
        r38.setReleaseEngineEnabled(true);
    L79:
        String r39 = "";
        if (TextUtils.isEmpty(r12.getLocalVideoPath()) == true) goto L94;
        String r110 = r12.getLocalVideoPath();
        if (r110 != null) goto L84;
        r110 = "";
    L84:
        Intrinsics.checkNotNullParameter("", "vid");
        Intrinsics.checkNotNullParameter(r110, "localUrl");
        Intrinsics.checkNotNullParameter("", "enCodeKey");
        r9.d(PreviewType.VIDEO);
        SimpleMediaView r41 = r9.b;
        if (r41 == null) goto L89;
        tic.a r42 = r41.getPlayEntity();
        if (r42 == null) goto L89;
        r42.d = VSVideoUtils.INSTANCE.getVideoModel(null);
        r42.a = "";
        r42.f = r110;
    L89:
        SimpleMediaView r43 = r9.b;
        if (r43 == null) goto L92;
        r43.setLoop(true);
    L92:
        a(r7, false, r8, r11);
        return;
    L94:
        if (TextUtils.isEmpty(r12.getLocalImagePath()) == true) goto L107;
        String r111 = r12.getLocalImagePath();
        if (r111 == null) goto L99;
        r39 = r111;
    L99:
        Intrinsics.checkNotNullParameter(r39, "localPath");
        Uri r112 = Uri.fromFile(new PolarisFileWrapper(r39));
        HSImageView r44 = r9.c;
        if (r44 == null) goto L102;
        r44.setImageURI(r112);
    L102:
        PreviewType r113 = PreviewType.LOCAL_IMAGE;
        Intrinsics.checkNotNullParameter(r113, "previewType");
        r9.d(r113);
        SimpleMediaView r45 = r9.b;
        if (r45 == null) goto L105;
        r45.j();
    L105:
        a(r7, true, r8, r11);
        return;
    L107:
        if (r12.getLocalImagePreviewBitmap() == null) goto L116;
        Bitmap r114 = r12.getLocalImagePreviewBitmap();
        Intrinsics.checkNotNull(r114);
        Intrinsics.checkNotNullParameter(r114, "bitmap");
        HSImageView r46 = r9.c;
        if (r46 == null) goto L111;
        r46.setImageBitmap(r114);
    L111:
        PreviewType r115 = PreviewType.LOCAL_IMAGE;
        Intrinsics.checkNotNullParameter(r115, "previewType");
        r9.d(r115);
        SimpleMediaView r47 = r9.b;
        if (r47 == null) goto L114;
        r47.j();
    L114:
        a(r7, true, r8, r11);
        return;
    L116:
        if (TextUtils.isEmpty(r12.getOriginalVidUrl()) == true) goto L118;
    L133:
        String r48 = r12.getOriginalVid();
        if (r48 != null) goto L136;
        r48 = "";
    L136:
        String r116 = r12.getOriginalVidUrl();
        if (r116 != null) goto L139;
        r116 = "";
    L139:
        Intrinsics.checkNotNullParameter(r48, "vid");
        Intrinsics.checkNotNullParameter(r116, "videoUrl");
        r9.d(PreviewType.VIDEO);
        SimpleMediaView r49 = r9.b;
        if (r49 == null) goto L144;
        tic.a r51 = r49.getPlayEntity();
        if (r51 == null) goto L144;
        r51.e = r116;
        r51.d = VSVideoUtils.INSTANCE.getVideoModel(null);
        r51.a = r48;
        r51.f = "";
        r51.j = "";
    L144:
        SimpleMediaView r52 = r9.b;
        if (r52 == null) goto L147;
        r52.setLoop(true);
    L147:
        a(r7, false, r8, r11);
        return;
    L118:
        if (TextUtils.isEmpty(r12.getOriginalVid()) == false) goto L133;
        if (r12.getCoverImage() == null) goto L153;
        k r117 = r12.getCoverImage();
        if (r117 != null) goto L125;
        return;
    L125:
        if ((r117 instanceof ImageModel) == false) goto L127;
        r1 = r117;
    L127:
        ImageModel r53 = (ImageModel) r1;
        if (r53 == null) goto L155;
        Intrinsics.checkNotNullParameter(r53, "image");
        a1.o(r9.c, r53, ImageView.ScaleType.FIT_CENTER);
        PreviewType r118 = PreviewType.SERVER_IMAGE;
        Intrinsics.checkNotNullParameter(r118, "previewType");
        r9.d(r118);
        SimpleMediaView r54 = r9.b;
        if (r54 == null) goto L132;
        r54.j();
    L132:
        a(r7, true, r8, r11);
        return;
    L155:
        return;
    L153:
        return;
    L67:
        r32 = null;
        goto L69
    L56:
        if (r8.indexOfChild(r29) >= 0) goto L64;
        ViewParent r55 = r29.getParent();
        if ((r55 instanceof ViewGroup) == true) goto L60;
        r55 = null;
    L60:
        ViewGroup r56 = (ViewGroup) r55;
        if (r56 == null) goto L63;
        r56.removeView(r29);
    L63:
        r8.removeAllViews();
        r8.addView(r29);
        goto L64
    }
}
