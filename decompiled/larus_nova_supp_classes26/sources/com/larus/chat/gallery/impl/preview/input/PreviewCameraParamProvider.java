package com.larus.chat.gallery.impl.preview.input;

import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.tips.GuidePriority;
import com.larus.bmhome.rc.GetVideoModelResultItem;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.rc.VideoUrlResult;
import com.larus.camera.api.IFlowCamera;
import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.CameraResultRoute;
import com.larus.camera.api.params.ImageParam;
import com.larus.camera.api.params.InputParam;
import com.larus.camera.api.params.InputParamExtra;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.api.params.VideoParam;
import com.larus.chat.gallery.api.PreviewScene;
import com.larus.gallery.api.GalleryType;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.CameraTabConfig;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.z3;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.action.SuggestedActionKey;
import com.larus.platform.model.camera.IMCameraEventExt;
import com.larus.platform.model.preview.AttachmentEditType;
import com.larus.platform.model.preview.InputDraftSnapshot;
import com.larus.platform.service.q3;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import yc9.l1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class PreviewCameraParamProvider {
    public static final Set<String> s = null;
    public final Function0<String> a;
    public final Function0<String> b;
    public final boolean c;
    public final com.larus.chat.gallery.impl.preview.p d;
    public final g e;
    public final Lazy f;
    public volatile SuggestedAction g;
    public final boolean h;
    public volatile boolean i;
    public Function0<xy8.d> j;
    public Function0<Boolean> k;
    public Function0<Unit> l;
    public AttachmentEditType m;
    public String n;
    public String o;
    public ex8.b p;
    public o q;
    public volatile boolean r;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[PreviewScene.values().length];
            r0[PreviewScene.MESSAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L22:
            r0[PreviewScene.SEARCH_IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L6:
            a = r0;
            int[] r1 = new int[GalleryType.values().length];
            r1[GalleryType.Image.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L32:
            r1[GalleryType.Video.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L9:
            b = r1;
            int[] r2 = new int[AttachmentEditType.values().length];
            r2[AttachmentEditType.CROP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L26:
            r2[AttachmentEditType.MARK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L28:
            r2[AttachmentEditType.OTHER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L13:
            c = r2;
        }
    }

    static {
        s = SetsKt.setOf(new String[]{SuggestedActionKey.AIBeautify.getValue(), SuggestedActionKey.AIVideoGenerate.getValue()});
    }

    public final IMCameraEventExt c() {
        String r5 = (String) this.b.invoke();
        if (r5 != null) goto L6;
        return null;
    L6:
        IMCameraEventExt r0 = new IMCameraEventExt();
        r0.setChatInfo((String) this.a.invoke(), null, null, r5, 0);
        return r0;
    }

    public final boolean g() {
        return ((Boolean) this.f.getValue()).booleanValue();
    }

    public final z0 h() {
        String r0 = (String) this.a.invoke();
        Object r1 = null;
        if (r0 != null) goto L10;
        com.larus.bmhome.chat.api.e0 r2 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r2 == null) goto L9;
        LaunchInfo r3 = r2.a;
        if (r3 == null) goto L9;
        r0 = r3.W();
    L9:
        r0 = null;
    L10:
        IActionBarService r4 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        List r5 = r4.f(r0);
        if (r5 == null) goto L28;
        Iterator r6 = r5.iterator();
    L14:
        if (r6.hasNext() == false) goto L26;
        Object r7 = r6.next();
        com.larus.bmhome.actionbar.model.r r8 = ((z0) r7).q;
        if (r8 == null) goto L23;
        Integer r9 = r8.a;
        if (r9 == null) goto L23;
        if (r9.intValue() != 16) goto L23;
        boolean r10 = true;
    L24:
        if (r10 == false) goto L14;
    L27:
        z0 r11 = (z0) r7;
    L29:
        if (r11 == null) goto L31;
        return r11;
    L31:
        com.larus.bmhome.chat.api.e0 r12 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r12 == null) goto L36;
        LaunchInfo r13 = r12.a;
        if (r13 == null) goto L36;
        String r14 = r13.W();
    L37:
        List r15 = r4.f(r14);
        if (r15 == null) goto L65;
        Iterator r16 = r15.iterator();
    L41:
        if (r16.hasNext() == false) goto L54;
        Object r17 = r16.next();
        com.larus.bmhome.actionbar.model.r r18 = ((z0) r17).q;
        if (r18 == null) goto L50;
        Integer r19 = r18.a;
        if (r19 == null) goto L50;
        if (r19.intValue() != 16) goto L50;
        boolean r20 = true;
    L51:
        if (r20 == false) goto L41;
        r1 = r17;
    L50:
        r20 = false;
    L54:
        return (z0) r1;
    L65:
        return null;
    L36:
        r14 = null;
    L23:
        r10 = false;
        goto L24
    L26:
        r7 = null;
        goto L27
    L28:
        r11 = null;
        goto L29
    }

    public final boolean i() {
        Set<PreviewScene> r0 = com.larus.chat.gallery.impl.preview.g.a;
        com.larus.chat.gallery.impl.preview.p r1 = this.d;
        PreviewScene r3 = null;
        if ((r1 instanceof com.larus.chat.gallery.impl.preview.p.c) == false) goto L5;
        com.larus.chat.gallery.impl.preview.p.c r2 = (com.larus.chat.gallery.impl.preview.p.c) r1;
    L6:
        if (r2 == null) goto L9;
        r3 = r2.f;
    L9:
        return CollectionsKt.contains(r0, r3);
    L5:
        r2 = null;
        goto L6
    }

    public final boolean j() {
        com.larus.chat.gallery.impl.preview.p r0 = this.d;
        if ((r0 instanceof com.larus.chat.gallery.impl.preview.p.a) == false) goto L12;
        q0 r1 = ((com.larus.chat.gallery.impl.preview.p.a) r0).e;
        if (r1 == null) goto L22;
        q0.a r2 = r1.getProvider();
        if (r2 == null) goto L22;
        com.larus.bmhome.chat.component.bottom.multimodal.g r3 = r2.r5();
        if (r3 == null) goto L22;
        return r3.nA(null);
    L22:
        return false;
    L12:
        if ((r0 instanceof com.larus.chat.gallery.impl.preview.p.c) == false) goto L19;
        com.larus.chat.gallery.api.l r4 = ((com.larus.chat.gallery.impl.preview.p.c) r0).e;
        if (r4.a == false) goto L22;
        if (r4.f == false) goto L22;
        return true;
    L19:
        if ((r0 instanceof com.larus.chat.gallery.impl.preview.p.b) == true) goto L22;
        if (r0 == null) goto L22;
        throw new NoWhenBranchMatchedException();
    }

    public final void k() {
        String r0 = this.o;
        if (r0 == null) goto L5;
        dr9.g r1 = dr9.g.a;
        dr9.g.f(r0);
    L5:
        this.o = null;
    }

    public final String m() {
        if (this.c == false) goto L11;
        com.larus.bmhome.chat.api.e0 r0 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r0 == null) goto L9;
        LaunchInfo r1 = r0.a;
        if (r1 == null) goto L9;
        return r1.W();
    L9:
        return null;
    L11:
        return (String) this.a.invoke();
    }

    public final String n() {
        String r1 = null;
        String r2 = "";
        if (this.c == false) goto L11;
        wc9.e r0 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r0 == null) goto L7;
        r1 = r0.a;
    L7:
        if (r1 != null) goto L10;
        return "";
    L10:
        return r1;
    L11:
        String r3 = (String) this.b.invoke();
        if (r3 != null) goto L14;
        r3 = "";
    L14:
        wc9.e r4 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r4 == null) goto L17;
        r1 = r4.a;
    L17:
        if (r1 == null) goto L21;
        r2 = r1;
    L21:
        if (r3.length() != 0) goto L23;
        boolean r5 = true;
    L24:
        if (r5 == true) goto L26;
        return r3;
    L26:
        return r2;
    L23:
        r5 = false;
        goto L24
    }

    public final boolean o() {
        Function0<xy8.d> r0 = this.j;
        if (r0 == null) goto L5;
        xy8.d r1 = (xy8.d) r0.invoke();
    L6:
        if (r1 == null) goto L12;
        xy8.b r2 = r1.c;
        if (r2 == null) goto L12;
        Boolean r3 = r2.e;
        if (r3 == null) goto L12;
        boolean r4 = r3.booleanValue();
    L13:
        this.i = r4;
        return r4;
    L12:
        r4 = this.i;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final Image p() {
        Function0<xy8.d> r1 = this.j;
        if (r1 == null) goto L186;
        xy8.d r2 = (xy8.d) r1.invoke();
        if (r2 == null) goto L186;
        xy8.b r3 = r2.c;
        if (r3 != null) goto L10;
        return null;
    L10:
        xy8.f r4 = r2.l;
        if (r4 == null) goto L17;
        List<UplinkFileEntity> r5 = r4.f;
        if (r5 == null) goto L17;
        UplinkFileEntity r6 = (UplinkFileEntity) CollectionsKt.firstOrNull(r5);
        if (r6 == null) goto L17;
        Image r7 = l1.c(r6);
    L18:
        if (r7 == null) goto L20;
        ImageObj r8 = r7.previewImage;
    L21:
        ImageObj r9 = u(r8);
        if (r9 != null) goto L37;
        if (r7 == null) goto L25;
        ImageObj r10 = r7.imageThumb;
    L26:
        r9 = u(r10);
        if (r9 != null) goto L37;
        String r11 = r3.a;
        if (r11 != null) goto L31;
    L36:
        r9 = null;
        goto L37
    L31:
        if (o0.d(r11) == false) goto L33;
        String r12 = r11;
    L34:
        if (r12 == null) goto L36;
        r9 = new ImageObj(r12, r3.i, r3.j, null, null, 24, null);
        goto L37
    L33:
        r12 = null;
        goto L34
    L25:
        r10 = null;
    L37:
        if (r7 == null) goto L39;
        ImageObj r13 = r7.imageOri;
    L40:
        ImageObj r14 = u(r13);
        if (r14 != null) goto L63;
        String r15 = r3.c;
        if (r15 != null) goto L45;
    L50:
        r14 = null;
    L51:
        if (r14 != null) goto L63;
        String r16 = r3.d;
        if (r16 != null) goto L55;
    L60:
        r14 = null;
    L61:
        if (r14 != null) goto L63;
        ImageObj r17 = r9;
    L64:
        if (r7 == null) goto L66;
        ImageObj r18 = r7.imageOriRaw;
    L67:
        ImageObj r19 = u(r18);
        if (r19 != null) goto L78;
        String r20 = r3.d;
        if (r20 != null) goto L72;
    L77:
        ImageObj r110 = null;
    L79:
        if (r17 != null) goto L82;
        if (r9 != null) goto L82;
        return null;
    L82:
        Integer r21 = Integer.valueOf(r3.i);
        boolean r22 = true;
        if (r21.intValue() <= 0) goto L85;
        boolean r23 = true;
    L86:
        if (r23 == true) goto L89;
        r21 = null;
    L89:
        if (r21 != null) goto L120;
        if (r9 == null) goto L98;
        r21 = Integer.valueOf(r9.width);
        if (r21.intValue() <= 0) goto L95;
        boolean r24 = true;
    L96:
        if (r24 == false) goto L98;
    L99:
        if (r21 != null) goto L120;
        if (r17 == null) goto L108;
        r21 = Integer.valueOf(r17.width);
        if (r21.intValue() <= 0) goto L105;
        boolean r25 = true;
    L106:
        if (r25 == false) goto L108;
    L109:
        if (r21 != null) goto L120;
        if (r110 == null) goto L118;
        r21 = Integer.valueOf(r110.width);
        if (r21.intValue() <= 0) goto L115;
        boolean r26 = true;
    L116:
        if (r26 == false) goto L118;
    L119:
        if (r21 != null) goto L120;
        int r111 = 0;
    L122:
        Integer r27 = Integer.valueOf(r3.j);
        if (r27.intValue() <= 0) goto L125;
        boolean r28 = true;
    L126:
        if (r28 == true) goto L129;
        r27 = null;
    L129:
        if (r27 != null) goto L160;
        if (r9 == null) goto L138;
        r27 = Integer.valueOf(r9.height);
        if (r27.intValue() <= 0) goto L135;
        boolean r29 = true;
    L136:
        if (r29 == false) goto L138;
    L139:
        if (r27 != null) goto L160;
        if (r17 == null) goto L148;
        r27 = Integer.valueOf(r17.height);
        if (r27.intValue() <= 0) goto L145;
        boolean r30 = true;
    L146:
        if (r30 == false) goto L148;
    L149:
        if (r27 != null) goto L160;
        if (r110 == null) goto L158;
        r27 = Integer.valueOf(r110.height);
        if (r27.intValue() > 0) goto L156;
        r22 = false;
    L156:
        if (r22 == false) goto L158;
    L159:
        if (r27 != null) goto L160;
        int r112 = 0;
    L162:
        if (r7 == null) goto L167;
        int r31 = r112;
        int r210 = r111;
        ImageObj r211 = r110;
        ImageObj r212 = r17;
        Image r32 = Image.copy$default(r7, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
        if (r32 == null) goto L168;
    L166:
        ImageObj r33 = r212;
        if (r33 == null) goto L171;
        int r34 = r210;
        ImageObj r35 = f(r33, r34, r31);
    L172:
        r32.imageOri = r35;
        if (r9 == null) goto L175;
        ImageObj r36 = f(r9, r34, r31);
    L176:
        r32.previewImage = r36;
        ImageObj r37 = r211;
        if (r37 == null) goto L179;
        ImageObj r38 = f(r37, r34, r31);
    L180:
        r32.imageOriRaw = r38;
        Boolean r39 = r3.e;
        if (r39 != null) goto L183;
        r39 = r32.aiCreationImage;
    L183:
        r32.aiCreationImage = r39;
        return r32;
    L179:
        r38 = null;
        goto L180
    L175:
        r36 = null;
        goto L176
    L171:
        r34 = r210;
        r35 = null;
    L168:
        r32 = new Image(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
        goto L166
    L167:
        r31 = r112;
        r210 = r111;
        r211 = r110;
        r212 = r17;
    L158:
        r27 = null;
        goto L159
    L145:
        r30 = false;
    L148:
        r27 = null;
        goto L149
    L135:
        r29 = false;
    L138:
        r27 = null;
    L160:
        r112 = r27.intValue();
        goto L162
    L125:
        r28 = false;
        goto L126
    L115:
        r26 = false;
    L118:
        r21 = null;
        goto L119
    L105:
        r25 = false;
    L108:
        r21 = null;
        goto L109
    L95:
        r24 = false;
    L98:
        r21 = null;
    L120:
        r111 = r21.intValue();
        goto L122
    L85:
        r23 = false;
        goto L86
    L72:
        if (o0.d(r20) == false) goto L74;
        String r40 = r20;
    L75:
        if (r40 == null) goto L77;
        r19 = new ImageObj(r40, r3.i, r3.j, null, null, 24, null);
        goto L78
    L74:
        r40 = null;
    L78:
        r110 = r19;
        goto L79
    L66:
        r18 = null;
        goto L67
    L55:
        if (o0.d(r16) == false) goto L57;
        String r41 = r16;
    L58:
        if (r41 == null) goto L60;
        r14 = new ImageObj(r41, r3.i, r3.j, null, null, 24, null);
        goto L61
    L57:
        r41 = null;
        goto L58
    L45:
        if (o0.d(r15) == false) goto L47;
        String r42 = r15;
    L48:
        if (r42 == null) goto L50;
        r14 = new ImageObj(r42, r3.i, r3.j, null, null, 24, null);
        goto L51
    L47:
        r42 = null;
    L63:
        r17 = r14;
        goto L64
    L39:
        r13 = null;
        goto L40
    L20:
        r8 = null;
    L17:
        r7 = null;
    L186:
        return null;
    }

    public static ImageObj u(ImageObj r1) {
        if (r1 != null) goto L4;
    L6:
        return null;
    L4:
        if (o0.d(r1.url) == false) goto L6;
        return r1;
    }

    public final void a(InputParamExtra r6) {
        r6.put("USE_UNIFIED_MEDIA_CANVAS", String.valueOf(this.h));
        boolean r1 = false;
        if (g() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        r6.put("MOBILE_PREVIEW_HOST_ENABLED", String.valueOf(g()));
        if (r0 == false) goto L13;
        int r3 = uy8.b.a;
        Intrinsics.checkNotNullParameter("camera_album", "entry");
        if (uy8.b.a().a("camera_album") == false) goto L13;
        boolean r4 = true;
    L14:
        r6.put("ENABLE_CAMERA_ALBUM_QUICK_INPUT", String.valueOf(r4));
        if (r0 == true) goto L17;
    L19:
        boolean r2 = false;
    L20:
        r6.put("ENABLE_CAMERA_ALBUM_UNIFIED_PREVIEW", String.valueOf(r2));
        if (g() == true) goto L23;
    L25:
        r6.put("ENABLE_CAMERA_RESULT_UNIFIED_VISUAL", String.valueOf(r1));
        return;
    L23:
        if (uy8.b.b("camera_result") == false) goto L25;
        r1 = true;
        goto L25
    L17:
        if (uy8.b.b("album") == false) goto L19;
        r2 = true;
    L13:
        r4 = false;
        goto L14
    L5:
        if (i() == false) goto L7;
        r0 = true;
        goto L8
    }

    public final String l(InputDraftSnapshot r2) {
        k();
        int r0 = y.a;
        Intrinsics.checkNotNullParameter(r2, "snapshot");
        String r3 = dr9.g.a.b(r2);
        this.o = r3;
        return r3;
    }

    public final boolean r(com.larus.chat.gallery.api.q r4) {
        if (r4 == null) goto L5;
        return false;
    L5:
        com.larus.chat.gallery.impl.preview.p r5 = this.d;
        if (r5 == null) goto L8;
        PreviewScene r6 = r5.a();
    L9:
        if (r6 != null) goto L11;
        int r7 = -1;
    L13:
        if (r7 != 1) goto L15;
        int r8 = com.larus.chat.gallery.impl.preview.q.a;
        return com.larus.chat.gallery.impl.preview.q.b(PreviewScene.MESSAGE);
    L15:
        if (r7 != 2) goto L21;
        return true;
    L21:
        return false;
    L11:
        r7 = b.a[r6.ordinal()];
        goto L13
    L8:
        r6 = null;
        goto L9
    }

    public final boolean s(com.larus.chat.gallery.api.q r4) {
        if (uy8.b.c() == true) goto L5;
        return false;
    L5:
        if (r4 != null) goto L13;
        com.larus.chat.gallery.impl.preview.p r5 = this.d;
        if (r5 == null) goto L11;
        int r2 = com.larus.chat.gallery.impl.preview.q.a;
        if (com.larus.chat.gallery.impl.preview.q.b(r5.a()) != true) goto L11;
        boolean r6 = true;
    L12:
        if (r6 == true) goto L13;
        return false;
    L11:
        r6 = false;
    L13:
        return true;
    }

    public final Object d(xy8.d r9, Continuation<? super CameraOutputContext> r10) {
        if ((r10 instanceof PreviewCameraParamProvider$buildInitialPreviewOutputContext$1) == false) goto L7;
        PreviewCameraParamProvider$buildInitialPreviewOutputContext$1 r0 = (PreviewCameraParamProvider$buildInitialPreviewOutputContext$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r9 = (xy8.d) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L22:
        String r12 = (String) r11;
        if (r12 != null) goto L24;
    L18:
        OutputParam r4 = null;
    L67:
        if (r4 != null) goto L69;
        return null;
    L69:
        CameraOutputContext r13 = new CameraOutputContext();
        r13.setOutputParamList(CollectionsKt.mutableListOf(new OutputParam[]{r4}));
        return r13;
    L24:
        r4 = new OutputParam();
        r4.setResultType(OutputParam.ResultType.VIDEO);
        VideoParam r5 = new VideoParam();
        r5.setPath(r12);
        xy8.g r14 = r9.d;
        if (r14 == null) goto L27;
        int r15 = r14.j;
    L28:
        r5.setWidth(r15);
        xy8.g r16 = r9.d;
        if (r16 == null) goto L31;
        int r17 = r16.k;
    L32:
        r5.setHeight(r17);
        xy8.g r18 = r9.d;
        if (r18 == null) goto L35;
        double r19 = r18.l;
    L36:
        r5.setDuration((long) (r19 * ((double) GuidePriority.COMMERCE_CREDIT_PRIORITY)));
        r4.setVideoParam(r5);
        r4.setSelected(true);
        goto L67
    L35:
        r19 = 0.0d;
        goto L36
    L31:
        r17 = 0;
        goto L32
    L27:
        r15 = 0;
        goto L28
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        int r110 = b.b[r9.e.ordinal()];
        if (r110 != 1) goto L17;
        xy8.b r111 = r9.c;
        if (r111 == null) goto L41;
        String r6 = r111.a;
        if (r6 == null) goto L41;
    L48:
        if (r6 == null) goto L18;
        if ((!StringsKt.isBlank(r6)) == true) goto L53;
        r6 = null;
    L53:
        if (r6 == null) goto L18;
        OutputParam r112 = new OutputParam();
        r112.setResultType(OutputParam.ResultType.PHOTO);
        ImageParam r7 = new ImageParam();
        r7.setPath(r6);
        xy8.b r8 = r9.c;
        if (r8 == null) goto L57;
        int r20 = r8.i;
    L58:
        r7.setWidth(r20);
        xy8.b r21 = r9.c;
        if (r21 == null) goto L61;
        int r22 = r21.j;
    L62:
        r7.setHeight(r22);
        xy8.b r23 = r9.c;
        if (r23 == null) goto L65;
        boolean r24 = Intrinsics.areEqual(r23.e, Boxing.boxBoolean(true));
    L66:
        r7.setAiCreation(r24);
        r112.setImageParam(r7);
        r112.setSelected(true);
        r4 = r112;
        goto L67
    L65:
        r24 = false;
        goto L66
    L61:
        r22 = 0;
        goto L62
    L57:
        r20 = 0;
    L41:
        if (r111 == null) goto L43;
        r6 = r111.c;
    L44:
        if (r6 != null) goto L48;
        if (r111 == null) goto L47;
        r6 = r111.d;
        goto L48
    L47:
        r6 = null;
        goto L48
    L43:
        r6 = null;
        goto L44
    L17:
        if (r110 != 2) goto L18;
        r0.L$0 = r9;
        r0.label = 1;
        r11 = q(r9, r0);
        if (r11 != r2) goto L22;
        return r2;
    L7:
        r0 = new PreviewCameraParamProvider$buildInitialPreviewOutputContext$1(this, r10);
        goto L8
    }

    public final Object q(xy8.d r11, Continuation<? super String> r12) {
        if ((r12 instanceof PreviewCameraParamProvider$resolveMessageVideoPath$1) == false) goto L7;
        PreviewCameraParamProvider$resolveMessageVideoPath$1 r0 = (PreviewCameraParamProvider$resolveMessageVideoPath$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        ResultKt.throwOnFailure(r13);
    L86:
        String r14 = (String) r13;
        if (r14 != null) goto L89;
        return null;
    L89:
        if (new PolarisFileWrapper(r14).isFile() == true) goto L91;
        return null;
    L91:
        return r14;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        xy8.g r15 = (xy8.g) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L58:
        GetVideoModelResultItem r16 = (GetVideoModelResultItem) r13;
        if (r16 == null) goto L61;
        VideoUrlResult r17 = r16.getVideoUrlResult();
    L62:
        String r4 = r15.b;
        if (r4 != null) goto L69;
        if (r17 == null) goto L66;
        r4 = r17.getVideoUrl();
    L67:
        if (r4 != null) goto L69;
        return null;
    L66:
        r4 = null;
    L69:
        String r5 = r15.c;
        if (r5 != null) goto L81;
        if (r17 == null) goto L73;
        r5 = r17.getDownloadFilehash();
    L74:
        if (r5 != null) goto L81;
        String r18 = r15.a;
        if ((!StringsKt.isBlank(r18)) == false) goto L78;
        r5 = r18;
    L79:
        if (r5 != null) goto L81;
        return null;
    L78:
        r5 = null;
        goto L79
    L73:
        r5 = null;
    L81:
        Lazy r19 = q3.a;
        z3 r110 = q3.a();
        if (r110 == null) goto L92;
        r0.L$0 = null;
        r0.label = 3;
        r13 = r110.h(r4, r5, r0);
        if (r13 != r2) goto L86;
        return r2;
    L92:
        return null;
    L61:
        r17 = null;
        goto L62
    L17:
        r15 = (xy8.g) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L39:
        String r111 = (String) r13;
        if (r111 == null) goto L42;
        return r111;
    L42:
        String r112 = r15.b;
        boolean r6 = false;
        if (r112 != null) goto L45;
    L48:
        boolean r113 = true;
    L49:
        if (r113 == false) goto L61;
        ResourceCenter r114 = ResourceCenter.a;
        String r7 = r15.i;
        String r8 = r15.a;
        if (r7 != null) goto L53;
    L54:
        r6 = true;
    L55:
        r0.L$0 = r15;
        r0.label = 2;
        r13 = r114.h(r7, r8, r6, r0);
        if (r13 != r2) goto L58;
        return r2;
    L53:
        if (StringsKt.isBlank(r7) == false) goto L55;
    L45:
        if (StringsKt.isBlank(r112) == true) goto L48;
        r113 = false;
        goto L49
    L18:
        ResultKt.throwOnFailure(r13);
        r15 = r11.d;
        if (r15 != null) goto L21;
        return null;
    L21:
        String r115 = r15.f;
        if (r115 != null) goto L24;
    L29:
        String r116 = r15.p;
        if (r116 == null) goto L42;
        if ((!StringsKt.isBlank(r116)) == true) goto L35;
        r116 = null;
    L35:
        if (r116 == null) goto L42;
        Uri r117 = UriProtector.parse(r116);
        r0.L$0 = r15;
        r0.label = 1;
        r13 = BuildersKt.withContext(Dispatchers.getIO(), new PreviewCameraParamProvider$materializeLocalVideo$2(r117, null), r0);
        if (r13 != r2) goto L39;
        return r2;
    L24:
        if (new PolarisFileWrapper(r115).isFile() == true) goto L27;
        r115 = null;
    L27:
        if (r115 == null) goto L29;
        return r115;
    L7:
        r0 = new PreviewCameraParamProvider$resolveMessageVideoPath$1(this, r12);
        goto L8
    }

    public static ImageObj f(ImageObj r9, int r10, int r11) {
        if (r9.width > 0) goto L5;
    L6:
        if (r10 <= 0) goto L12;
        if (r11 > 0) goto L10;
        return r9;
    L10:
        return ImageObj.copy$default(r9, null, r10, r11, null, null, 25, null);
    L12:
        return r9;
    L5:
        if (r9.height <= 0) goto L6;
        return r9;
    }

    public final InputParam e(AttachmentEditType r10, boolean r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "editType");
        z2 r0 = z2.a;
        int r1 = r0.cameraFreeInputConfig().b;
        BotModel r2 = this.e.e;
        CameraResultRoute r3 = null;
        if (r2 == null) goto L7;
        Map r4 = r2.getCameraTabConfigMap();
        if (r4 == null) goto L7;
        CameraTabConfig r5 = (CameraTabConfig) r4.get("all_camera");
    L8:
        BotModel r6 = this.e.e;
        if (r6 == null) goto L13;
        Map r7 = r6.getCameraTabConfigMap();
        if (r7 == null) goto L13;
        CameraTabConfig r8 = (CameraTabConfig) r7.get("input_left");
    L14:
        boolean r9 = o();
        Intrinsics.checkNotNullParameter("send_photo_preview", "scene");
        InputParam r13 = new InputParam(r3);
        r13.setScene("send_photo_preview");
        Intrinsics.checkNotNullParameter("CAPTURE_MODE_PHOTO", "captureMode");
        r13.setCaptureMode("CAPTURE_MODE_PHOTO");
        Intrinsics.checkNotNullParameter("TARGET_SHOW_GET", "target");
        r13.setTarget("TARGET_SHOW_GET");
        r13.setInputStyle(r1);
        boolean r14 = true;
        r13.setSupportMark(true);
        r13.setSupportCrop(r11);
        r13.setSupportMultiImages(true);
        r13.setBotId((String) this.a.invoke());
        r13.setEnableCaptureDetectModeList(CollectionsKt.emptyList());
        if (r5 == null) goto L17;
        String r15 = r5.getCameraNameUrl();
    L18:
        r13.setCameraNameUrl(r15);
        if (r5 == null) goto L21;
        String r16 = r5.getCameraName();
    L22:
        r13.setCameraName(r16);
        if (r8 == null) goto L25;
        Integer r17 = r8.getTipsShowOrder();
    L26:
        r13.setTipsShowOrder(r17);
        if (r8 == null) goto L29;
        List<String> r18 = r8.getTips();
    L30:
        r13.setTips(r18);
        r13.setSupportAlbumMultiTake(r0.isCameraAlbumMultiSelectEnable());
        r13.setAlbumMultiTakeMaxCount(20);
        r13.setEventExt(c());
        r13.setFromMarkPage(true);
        int r19 = b.c[r10.ordinal()];
        if (r19 != 1) goto L33;
        InputParam.InitialImageEditMode r110 = InputParam.InitialImageEditMode.CROP;
    L41:
        Intrinsics.checkNotNullParameter(r110, "mode");
        r13.setInitialImageEditMode(r110);
        if (r12 != null) goto L44;
    L49:
        r13.setResultRoute(r3);
        InputParamExtra r111 = r13.getExtra();
        if (r111 != null) goto L52;
        r111 = new InputParamExtra();
        r13.setExtra(r111);
    L52:
        a(r111);
        if (r12 != null) goto L55;
    L58:
        if (r14 == true) goto L63;
        InputParamExtra r112 = r13.getExtra();
        if (r112 != null) goto L62;
        r112 = new InputParamExtra();
        r13.setExtra(r112);
    L62:
        r112.put("ENABLE_RESULT_SUGGESTED_ACTION", "false");
    L63:
        if (r9 == false) goto L68;
        InputParamExtra r113 = r13.getExtra();
        if (r113 != null) goto L67;
        r113 = new InputParamExtra();
        r13.setExtra(r113);
    L67:
        r113.put(InputParamExtra.KEY_IS_AI_CREATION, "1");
    L68:
        return r13;
    L55:
        if (StringsKt.isBlank(r12) == true) goto L58;
        r14 = false;
        goto L58
    L44:
        if ((!StringsKt.isBlank(r12)) == false) goto L46;
        String r114 = r12;
    L47:
        if (r114 == null) goto L49;
        r3 = new CameraResultRoute(r114, CameraResultRoute.Delivery.CONFIRM_TO_OWNER);
        goto L49
    L46:
        r114 = null;
        goto L47
    L33:
        if (r19 != 2) goto L35;
        r110 = InputParam.InitialImageEditMode.MARK;
        goto L41
    L35:
        if (r19 != 3) goto L38;
        r110 = InputParam.InitialImageEditMode.NONE;
        goto L41
    L38:
        throw new NoWhenBranchMatchedException();
    L29:
        r18 = null;
        goto L30
    L25:
        r17 = null;
        goto L26
    L21:
        r16 = null;
        goto L22
    L17:
        r15 = null;
    L13:
        r8 = null;
    L7:
        r5 = null;
        goto L8
    }

    public PreviewCameraParamProvider(Function0<String> r7, Function0<String> r8, boolean r9, com.larus.chat.gallery.impl.preview.p r10) {
        Intrinsics.checkNotNullParameter(r7, "botIdProvider");
        Intrinsics.checkNotNullParameter(r8, "conversationIdProvider");
        this.a = r7;
        this.b = r8;
        this.c = r9;
        this.d = r10;
        final g r11 = new g(r7);
        this.e = r11;
        this.f = LazyKt.lazy(new p(this));
        if (r10 == null) goto L5;
        boolean r12 = ((Boolean) r10.a.getValue()).booleanValue();
    L6:
        this.h = r12;
        this.m = AttachmentEditType.MARK;
        this.n = "";
        final String r13 = (String) r11.a.invoke();
        if (r13 == null) goto L10;
        r11.b.execute(new f(r13, r11));
    L10:
        String r1 = (String) r11.a.invoke();
        if (r1 == null) goto L15;
        FLogger.a.i("BotModelCacheHelper", "preloadBotModel: botId=".concat(r1));
        com.larus.im.d.a().getBot(r1, false, "default", true, new i(r11, r1));
        return;
    L15:
        return;
    L5:
        r12 = z2.a.getNewPreviewConfig().c.a;
        goto L6
    }

    public final void b(InputParam r3, com.larus.chat.gallery.api.q r4, xy8.d r5, Set r6) {
        Intrinsics.checkNotNullParameter(r3, "inputParam");
        Intrinsics.checkNotNullParameter(r5, "data");
        Intrinsics.checkNotNullParameter(r6, "excludedStableIds");
        if (s(r4) == true) goto L5;
        return;
    L5:
        int r0 = y.a;
        InputDraftSnapshot r7 = y.b(r4, this.n, r5, false, r6);
        y.a(r7, r3, l(r7));
    }

    public final Object t(FragmentActivity r24, com.larus.chat.gallery.api.q r25, xy8.d r26, Continuation<? super Boolean> r27) {
        if ((r27 instanceof PreviewCameraParamProvider$startCamera$1) == false) goto L7;
        PreviewCameraParamProvider$startCamera$1 r3 = (PreviewCameraParamProvider$startCamera$1) r27;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        int r0 = r3.I$0;
        CameraResultRoute r7 = (CameraResultRoute) r3.L$5;
        String r8 = (String) r3.L$4;
        String r10 = (String) r3.L$3;
        InputDraftSnapshot r11 = (InputDraftSnapshot) r3.L$2;
        IFlowCamera r12 = (IFlowCamera) r3.L$1;
        FragmentActivity r9 = (FragmentActivity) r3.L$0;
        ResultKt.throwOnFailure(r2);
        FragmentActivity r13 = r9;
    L80:
        CameraOutputContext r14 = (CameraOutputContext) r2;
        int r15 = r0;
        CameraOutputContext r1 = r14;
    L82:
        com.larus.chat.gallery.impl.preview.p r16 = this.d;
        if ((r16 instanceof com.larus.chat.gallery.impl.preview.p.a) == false) goto L85;
        com.larus.chat.gallery.impl.preview.p.a r17 = (com.larus.chat.gallery.impl.preview.p.a) r16;
    L86:
        if (r17 == null) goto L92;
        q0 r18 = r17.e;
        if (r18 == null) goto L92;
        q0.a r19 = r18.getProvider();
        if (r19 == null) goto L92;
        zb8.e r110 = r19.P8();
    L94:
        if (r110 != null) goto L197;
        z2 r20 = z2.a;
        int r111 = r20.cameraFreeInputConfig().b;
        BotModel r21 = this.e.e;
        if (r21 == null) goto L133;
        Map r22 = r21.getCameraTabConfigMap();
        if (r22 == null) goto L133;
        CameraTabConfig r23 = (CameraTabConfig) r22.get("all_camera");
    L134:
        BotModel r28 = this.e.e;
        if (r28 == null) goto L139;
        Map r29 = r28.getCameraTabConfigMap();
        if (r29 == null) goto L139;
        CameraTabConfig r30 = (CameraTabConfig) r29.get("input_left");
    L140:
        String r112 = (String) this.a.invoke();
        FragmentActivity r113 = r13;
        Intrinsics.checkNotNullParameter("send_photo_preview", "scene");
        int r210 = r15;
        InputParam r114 = new InputParam(null);
        r114.setScene("send_photo_preview");
        Intrinsics.checkNotNullParameter("CAPTURE_MODE_PHOTO", "captureMode");
        r114.setCaptureMode("CAPTURE_MODE_PHOTO");
        CameraOutputContext r211 = r1;
        Intrinsics.checkNotNullParameter("TARGET_SHOW_GET", "target");
        r114.setTarget("TARGET_SHOW_GET");
        r114.setInputStyle(r111);
        r114.setSupportMultiImages(true);
        r114.setSupportMark(true);
        r114.setSupportCrop(true);
        r114.setBotId(r112);
        r114.setEnableCaptureDetectModeList(CollectionsKt.listOf("CAPTURE_MODE_PHOTO"));
        if (r23 == null) goto L143;
        String r31 = r23.getCameraNameUrl();
    L144:
        r114.setCameraNameUrl(r31);
        if (r23 == null) goto L147;
        String r32 = r23.getCameraName();
    L148:
        r114.setCameraName(r32);
        if (r30 == null) goto L151;
        Integer r33 = r30.getTipsShowOrder();
    L152:
        r114.setTipsShowOrder(r33);
        if (r30 == null) goto L155;
        List<String> r34 = r30.getTips();
    L156:
        r114.setTips(r34);
        r114.setSupportAlbumMultiTake(r20.isCameraAlbumMultiSelectEnable());
        r114.setAlbumMultiTakeMaxCount(20);
        com.larus.chat.gallery.impl.preview.p r35 = this.d;
        if ((r35 instanceof com.larus.chat.gallery.impl.preview.p.a) == false) goto L165;
        q0 r36 = ((com.larus.chat.gallery.impl.preview.p.a) r35).e;
        if (r36 == null) goto L165;
        q0.a r37 = r36.getProvider();
        if (r37 == null) goto L165;
        zb8.e r38 = r37.P8();
        if (r38 == null) goto L165;
        boolean r39 = r38.gs("common_input");
    L166:
        r114.setSupportRecord(r39);
        r114.setEventExt(c());
        InputParamExtra r40 = new InputParamExtra();
        r40.put("SHOW_BOTTOM_ALBUM", "true");
        a(r40);
        if (r8 != null) goto L169;
    L174:
        r114.setResultRoute(r7);
        r114.setExtra(r40);
        if (r11 == null) goto L178;
        if (r10 == null) goto L178;
        int r41 = y.a;
        y.a(r11, r114, r10);
    L178:
        r114.setInitialOutputContext(r211);
        if (r210 == 0) goto L195;
        InputParamExtra r42 = r114.getExtra();
        if (r42 != null) goto L183;
        r42 = new InputParamExtra();
        r114.setExtra(r42);
    L183:
        r42.put("EXTRA_FORCE_NEW_CAPTURE_ACTIVITY", "true");
    L195:
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L186
        r12.g(r113, r114, null);     // Catch: Throwable -> L186
        Object r44 = Result.constructor-impl(Boxing.boxBoolean(true));     // Catch: Throwable -> L186
    L188:
        Throwable r45 = Result.exceptionOrNull-impl(r44);
        if (r45 == null) goto L191;
        FLogger.a.e("PreviewCameraParamProvider", "startCamera: IFlowCamera launch failed", r45);
    L191:
        Boolean r46 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r44) == true) goto L194;
        return r44;
    L194:
        return r46;
    L186:
        th = move-exception;
        Result.Companion r47 = Result.Companion;
        r44 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L188
    L169:
        if ((!StringsKt.isBlank(r8)) == true) goto L172;
        r8 = null;
    L172:
        if (r8 == null) goto L174;
        r40.put("CAMERA_RETURN_ALBUM_NODE_ID", r8);
    L165:
        r39 = false;
        goto L166
    L155:
        r34 = null;
        goto L156
    L151:
        r33 = null;
        goto L152
    L147:
        r32 = null;
        goto L148
    L143:
        r31 = null;
    L139:
        r30 = null;
    L133:
        r23 = null;
        goto L134
    L197:
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L119
        r110.D40(true);     // Catch: Throwable -> L119
        HashMap r116 = new HashMap();     // Catch: Throwable -> L119
        r116.put("USE_UNIFIED_MEDIA_CANVAS", Boxing.boxBoolean(this.h));     // Catch: Throwable -> L119
        r116.put("ENABLE_CAMERA_ALBUM_QUICK_INPUT", Boxing.boxBoolean(i()));     // Catch: Throwable -> L119
        r116.put("ENABLE_CAMERA_ALBUM_UNIFIED_PREVIEW", Boxing.boxBoolean(i()));     // Catch: Throwable -> L119
        com.larus.chat.gallery.impl.preview.p r48 = this.d;     // Catch: Throwable -> L119
        if ((r48 instanceof com.larus.chat.gallery.impl.preview.p.a) == false) goto L98;
        com.larus.chat.gallery.impl.preview.p.a r49 = (com.larus.chat.gallery.impl.preview.p.a) r48;     // Catch: Throwable -> L119
    L99:
        if (r49 == null) goto L107;
        q0 r50 = r49.e;     // Catch: Throwable -> L119
        if (r50 == null) goto L107;
        q0.a r51 = r50.getProvider();     // Catch: Throwable -> L119
        if (r51 == null) goto L107;
        com.larus.bmhome.chat.component.trace.z r52 = r51.E9();     // Catch: Throwable -> L119
        if (r52 == null) goto L107;
        r116.put("chat_key", Boxing.boxLong(r52.getChatUniqueKey()));     // Catch: Throwable -> L119
    L107:
        if (r10 == null) goto L113;
        r116.put("ALBUM_INPUT_SNAPSHOT_ID", r10);     // Catch: Throwable -> L119
        if (r11 == null) goto L113;
        String r53 = r11.getSourceNodeId();     // Catch: Throwable -> L119
        if (r53 == null) goto L113;
        r116.put("ALBUM_INPUT_SOURCE_NODE_ID", r53);     // Catch: Throwable -> L119
    L113:
        if (r8 == null) goto L115;
        r116.put("CAMERA_RETURN_ALBUM_NODE_ID", r8);     // Catch: Throwable -> L119
    L115:
        if (r15 == 0) goto L117;
        r116.put("EXTRA_FORCE_NEW_CAPTURE_ACTIVITY", "true");     // Catch: Throwable -> L119
    L117:
        zb8.e.a.b(r110, "send_photo_preview", r116, null, r7, r1, g(), 12);     // Catch: Throwable -> L119
        Object r54 = Result.constructor-impl(Boxing.boxBoolean(true));     // Catch: Throwable -> L119
    L121:
        Throwable r55 = Result.exceptionOrNull-impl(r54);
        if (r55 == null) goto L124;
        FLogger.a.e("PreviewCameraParamProvider", "startCamera: IChatCameraAbility launch failed", r55);
    L124:
        Boolean r56 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r54) == true) goto L127;
        return r54;
    L127:
        return r56;
    L98:
        r49 = null;
    L119:
        th = move-exception;
        Result.Companion r57 = Result.Companion;
        r54 = Result.constructor-impl(ResultKt.createFailure(th));
    L92:
        r110 = null;
        goto L94
    L85:
        r17 = null;
        goto L86
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        IFlowSdkDepend r58 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r58 == null) goto L17;
        r58.x();
    L17:
        r12 = (IFlowCamera) ServiceManager.get().getService(IFlowCamera.class);
        if (r12 != null) goto L22;
        FLogger.a.e("PreviewCameraParamProvider", "startCamera: IFlowCamera service not found");
        return Boxing.boxBoolean(false);
    L22:
        if (r12.i().contains(r24.getClass().getName()) == true) goto L31;
        com.larus.chat.gallery.impl.preview.p r59 = this.d;
        if (r59 == null) goto L26;
        PreviewScene r60 = r59.a();
    L28:
        if (r60 == PreviewScene.CAMERA_RESULT) goto L31;
        r15 = 0;
    L32:
        if (r26 != null) goto L34;
    L49:
        r11 = null;
    L50:
        if (r11 == null) goto L52;
        r10 = l(r11);
    L53:
        if (r25 == null) goto L64;
        r8 = r25.o();
        if (r8 == null) goto L64;
        if (uy8.b.c() == true) goto L59;
    L61:
        boolean r117 = false;
    L62:
        if (r117 == false) goto L64;
    L65:
        if (r25 == null) goto L69;
        String r118 = r25.j();
        if (r118 == null) goto L69;
        CameraResultRoute r119 = new CameraResultRoute(r118, CameraResultRoute.Delivery.PREVIEW_CAPTURE_APPEND);
    L70:
        if (r26 != null) goto L72;
    L81:
        r13 = r24;
        r7 = r119;
        r1 = null;
        goto L82
    L72:
        if (r(r25) == false) goto L74;
        xy8.d r61 = r26;
    L75:
        if (r61 == null) goto L81;
        r13 = r24;
        r3.L$0 = r13;
        r3.L$1 = r12;
        r3.L$2 = r11;
        r3.L$3 = r10;
        r3.L$4 = r8;
        r3.L$5 = r119;
        r3.I$0 = r15;
        r3.label = 1;
        Object r62 = d(r61, r3);
        if (r62 != r5) goto L79;
        return r5;
    L79:
        r7 = r119;
        int r212 = r15;
        r2 = r62;
        r0 = r212;
        goto L80
    L74:
        r61 = null;
    L69:
        r119 = null;
        goto L70
    L59:
        if (kq9.b.c(r8) == false) goto L61;
        r117 = true;
    L64:
        r8 = null;
        goto L65
    L52:
        r10 = null;
        goto L53
    L34:
        if (s(r25) == false) goto L36;
    L39:
        boolean r63 = true;
    L40:
        if (r63 == false) goto L42;
        xy8.d r64 = r26;
    L43:
        if (r64 == null) goto L49;
        int r120 = y.a;
        String r121 = this.n;
        if (r25 == null) goto L47;
        boolean r122 = true;
    L48:
        r11 = y.b(r25, r121, r64, r122, SetsKt.emptySet());
        goto L50
    L47:
        r122 = false;
        goto L48
    L42:
        r64 = null;
        goto L43
    L36:
        if (r(r25) == true) goto L39;
        r63 = false;
        goto L40
    L26:
        r60 = null;
    L31:
        r15 = 1;
    L7:
        r3 = new PreviewCameraParamProvider$startCamera$1(this, r27);
        goto L8
    }
}
