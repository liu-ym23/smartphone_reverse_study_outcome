package com.larus.chat.gallery.impl.preview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.trace.z;
import com.larus.chat.gallery.api.IChatGalleryService;
import com.larus.chat.gallery.api.PreviewScene;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.chat.gallery.impl.preview.datasource.PreviewCreationRecordDataSource;
import com.larus.chat.gallery.impl.preview.datasource.PreviewMessageDataSource;
import com.larus.chat.gallery.impl.preview.input.CreationRecordSendStrategy;
import com.larus.chat.gallery.impl.preview.input.PreviewCameraParamProvider;
import com.larus.chat.gallery.impl.preview.input.e0;
import com.larus.chat.gallery.impl.preview.provider.PreviewBottomProvider;
import com.larus.chat.gallery.impl.preview.provider.h1;
import com.larus.chat.gallery.impl.preview.provider.q1;
import com.larus.chat.gallery.impl.preview.provider.r1;
import com.larus.chat.gallery.impl.preview.toolbar.ToolbarLayoutMode;
import com.larus.chat.gallery.impl.preview.toolbar.ToolbarVisualStyle;
import com.larus.gallery.api.DisplayGravity;
import com.larus.gallery.api.GalleryBuilder;
import com.larus.gallery.api.GallerySingleTapAction;
import com.larus.gallery.api.ProviderType;
import com.larus.gallery.api.c0;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class m {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SourceType.values().length];
            r0[SourceType.USER_SEND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[SourceType.BOT_RESP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[SourceType.CREATION_CARD.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[SourceType.CREATION_RECORD.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[SourceType.ALBUM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[SourceType.ATTACHMENT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[SourceType.CAMERA_RESULT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[SourceType.CLOUD_DRIVE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r6v31, types: [com.larus.chat.gallery.impl.preview.l] */
    public static void a(Context r50, FragmentManager r51, final p r52) {
        Intrinsics.checkNotNullParameter(r50, "context");
        Intrinsics.checkNotNullParameter(r51, "fragmentManager");
        Intrinsics.checkNotNullParameter(r52, "params");
        FLogger.a.i("PreviewGalleryHelper", "open, params=".concat(r52.getClass().getSimpleName()));
        GalleryBuilder r4 = new GalleryBuilder(r50);
        int r5 = h.a;
        Intrinsics.checkNotNullParameter(r52, "params");
        Intrinsics.checkNotNullParameter(r52, "params");
        boolean r3 = r52 instanceof p.c;
        if (r3 == false) goto L6;
        PreviewChromeKind r6 = PreviewChromeKind.MEDIA_SOURCE_V4;
    L13:
        int r7 = h.a.a[r6.ordinal()];
        final SourceType r10 = null;
        if (r7 == 1) goto L81;
        if (r7 != 2) goto L80;
        z2 r8 = z2.a;
        sq9.e r14 = r8.getCreationDetailLayoutConfig();
        int r15 = q.a;
        boolean r25 = q.b(r52.a());
        if (r25 == false) goto L19;
        int r9 = u.a;
        r r13 = u.c(r52.a());
    L36:
        PreviewChromeKind r37 = PreviewChromeKind.LEGACY;
        if (r25 == true) goto L39;
        boolean r17 = r14.f();
    L46:
        if (r25 == false) goto L48;
        boolean r18 = true;
    L49:
        if (r25 == false) goto L51;
        boolean r11 = r13.j;
    L52:
        boolean r21 = r11;
        if (r25 == true) goto L55;
        Boolean r22 = null;
    L74:
        c r39 = new c(r17, r18, r25, r25, r21, r22, false, null, r25, false);
        List r41 = CollectionsKt.emptyList();
        if (((Boolean) r52.a.getValue()).booleanValue() == false) goto L77;
        e r12 = new e(true);
    L78:
        f r16 = new f(r37, r13, r39, null, r41, true, true, false, r12);
    L131:
        boolean r19 = r52 instanceof p.a;
        if (r19 == false) goto L151;
        p.a r20 = (p.a) r52;
        String r110 = r20.b;
        String r111 = r20.c;
        Message r112 = r20.d;
        q0 r113 = r20.e;
        if (r113 == null) goto L138;
        List<Message> r114 = r113.getCurrentList();
        if (r114 == null) goto L138;
        List r115 = CollectionsKt.toList(r114);
    L139:
        if (r115 != null) goto L141;
        r115 = CollectionsKt.emptyList();
    L141:
        PreviewMessageDataSource r23 = new PreviewMessageDataSource(r110, r111, r112, r115, r20.g, r20.i, r20.j, r16.i.a);
        Intrinsics.checkNotNullParameter(r23, "dataSource");
        r4.b = r23;
        int r24 = r20.g;
        if (r24 < 0) goto L145;
        r4.c = r24;
    L145:
        if (r16.i.a == true) goto L149;
        View r26 = r20.h;
        if (r26 == null) goto L149;
        r4.l = r26;
    L149:
        Unit r27 = Unit.INSTANCE;
    L190:
        if (r19 == false) goto L193;
        e0 r28 = new com.larus.chat.gallery.impl.preview.input.l((p.a) r52);
    L197:
        if (r19 == false) goto L199;
        p.a r29 = (p.a) r52;
    L200:
        if (r29 == null) goto L208;
        q0 r30 = r29.e;
        if (r30 == null) goto L208;
        q0.a r31 = r30.getProvider();
        if (r31 == null) goto L208;
        z r32 = r31.E9();
        if (r32 == null) goto L208;
        Long r116 = Long.valueOf(r32.getChatUniqueKey());
    L209:
        if (r19 == false) goto L211;
        p.a r33 = (p.a) r52;
    L212:
        if (r33 == null) goto L214;
        final String r34 = r33.b;
    L215:
        PreviewCameraParamProvider r35 = new PreviewCameraParamProvider(new i(), new j(r34), r52 instanceof p.b, r52);
        Pair<Integer, Integer> r36 = IChatGalleryService.a.a(r50);
        e r38 = r16.i;
        if (r38.a == false) goto L218;
        com.larus.gallery.api.a r310 = null;
    L220:
        if (r16.a != PreviewChromeKind.MEDIA_SOURCE_V4) goto L222;
        boolean r210 = true;
    L223:
        boolean r40 = r16.g;
        Bitmap.Config r311 = Bitmap.Config.ARGB_8888;
        boolean r117 = r38.b;
        boolean r118 = r38.c;
        boolean r119 = r38.d;
        if (r38.a == false) goto L226;
        Resources r0 = r50.getResources();
        float r1 = WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density;
        c0 r44 = new c0(MathKt.roundToInt(52 * r1), MathKt.roundToInt(144 * r1));
    L227:
        if (r210 == false) goto L229;
        GallerySingleTapAction r2 = GallerySingleTapAction.TOGGLE_VIDEO_PLAYBACK;
    L230:
        com.larus.gallery.api.b r42 = new com.larus.gallery.api.b(r310, r40, r311, 0, r117, r119, r118, r44, r2, !r210, 476);
        Intrinsics.checkNotNullParameter(r42, "displayConfig");
        r4.d = r42;
        int r43 = d.a;
        Intrinsics.checkNotNullParameter(r4, "builder");
        Intrinsics.checkNotNullParameter(r16, "profile");
        Intrinsics.checkNotNullParameter(r28, "sendStrategy");
        Intrinsics.checkNotNullParameter(r35, "paramProvider");
        int r45 = d.a.a[r16.a.ordinal()];
        if (r45 != 1) goto L233;
        r4.a(ProviderType.TOP, new q1(r35, r28, r16.b));
        r4.a(ProviderType.BOTTOM, new PreviewBottomProvider(r28, r116, r35, r16.c, com.larus.chat.gallery.impl.preview.input.n.a, com.larus.chat.gallery.impl.preview.provider.a.a, true, null, false, 384));
        r4.a(ProviderType.RIGHT_SIDE, new h1(r35, r28, r16.b));
        r4.a(ProviderType.NON_UI, new r1(null));
    L253:
        final com.larus.chat.gallery.api.q r46 = r16.d;
        if (r46 == null) goto L256;
        Function1 r47 = new k(r46);
        Intrinsics.checkNotNullParameter(r47, "listener");
        r4.g = r47;
    L256:
        Intrinsics.checkNotNullParameter("PreviewGalleryDialog", "tag");
        r4.m = "PreviewGalleryDialog";
        final com.larus.platform.model.chat.l r48 = z2.a.getNewPreviewConfig().a;
        if (r48.f == false) goto L260;
        if (r19 == false) goto L260;
        r4.a(ProviderType.RIGHT_BOTTOM, new com.larus.chat.gallery.impl.providers.i(new l(r48, r52)));
    L260:
        r4.b(r51);
        return;
    L233:
        if (r45 != 2) goto L251;
        com.larus.chat.gallery.api.q r49 = r16.d;
        if (r49 == null) goto L249;
        com.larus.chat.gallery.api.z r53 = r49.p();
        if (r16.f == false) goto L239;
        e0 r120 = r28;
    L240:
        com.larus.chat.gallery.impl.preview.input.c r121 = new com.larus.chat.gallery.impl.preview.input.c(r49, r16.e, new PreviewChromeInstaller$installMediaSourceV4$sessionController$1(r35));
        r4.a(ProviderType.TOP, new com.larus.chat.gallery.impl.preview.provider.q(r35, r120, r49, r16.b));
        if (r16.b.g == false) goto L244;
        r4.a(ProviderType.BOTTOM, new PreviewBottomProvider(r28, null, r35, r16.c, r121, new com.larus.chat.gallery.impl.preview.provider.d(r16.f, r16.h, r53), r16.f, r53, true, 2));
    L244:
        r r54 = r16.b;
        if (r54.h == false) goto L247;
        r4.a(ProviderType.RIGHT_SIDE, new com.larus.chat.gallery.impl.preview.provider.j(r35, r120, r49, r54));
    L247:
        r4.a(ProviderType.NON_UI, new r1(new PreviewChromeInstaller$installMediaSourceV4$1(r49)));
        goto L253
    L239:
        r120 = null;
        goto L240
    L249:
        throw new IllegalArgumentException("Required value was null.".toString());
    L251:
        throw new NoWhenBranchMatchedException();
    L229:
        r2 = GallerySingleTapAction.TOGGLE_CHROME;
        goto L230
    L226:
        r44 = null;
        goto L227
    L222:
        r210 = false;
        goto L223
    L218:
        r310 = new com.larus.gallery.api.a(((Number) r36.getFirst()).intValue(), ((Number) r36.getSecond()).intValue(), DisplayGravity.TOP, new com.larus.gallery.adapter.ui.i(i5.Z()));
        goto L220
    L214:
        r34 = null;
        goto L215
    L211:
        r33 = null;
    L208:
        r116 = null;
        goto L209
    L199:
        r29 = null;
        goto L200
    L193:
        if ((r52 instanceof p.b) == false) goto L195;
        r28 = new CreationRecordSendStrategy((p.b) r52);
        goto L197
    L195:
        if (r3 == false) goto L263;
        p.c r55 = (p.c) r52;
        r28 = new com.larus.chat.gallery.impl.preview.input.c0(r55.b, r55.d);
        goto L197
    L263:
        throw new NoWhenBranchMatchedException();
    L138:
        r115 = null;
        goto L139
    L151:
        if ((r52 instanceof p.b) == false) goto L172;
        p.b r122 = (p.b) r52;
        PreviewCreationRecordDataSource r56 = new PreviewCreationRecordDataSource(r122.b, r122.c);
        List<UserCreation> r123 = r56.a.a();
        if (r123 == null) goto L168;
        Iterator<UserCreation> r124 = r123.iterator();
        int r125 = 0;
    L157:
        if (r124.hasNext() == false) goto L167;
        UserCreation r126 = r124.next();
        String r127 = r126.a;
        if (r127 == null) goto L157;
        if (Intrinsics.areEqual(r127, r56.b) == true) goto L163;
        if (PreviewCreationRecordDataSource.o(r126) == false) goto L157;
        r125 = r125 + 1;
        goto L157
    L163:
        FLogger.a.i("PreviewCreationRecordDS", "computeInitialPosition: found at position=" + r125);
    L169:
        FLogger.a.i("PreviewGalleryHelper", "open CreationRecord: initialPosition=" + r125);
        Intrinsics.checkNotNullParameter(r56, "dataSource");
        r4.b = r56;
        if (r125 < 0) goto L190;
        r4.c = r125;
        goto L190
    L167:
        FLogger.a.e("PreviewCreationRecordDS", "computeInitialPosition: selectCreationId not found, fallback to 0");
    L168:
        r125 = 0;
        goto L169
    L172:
        if (r3 == false) goto L265;
        p.c r57 = (p.c) r52;
        List<com.larus.chat.gallery.api.o> r128 = r57.b;
        PreviewScene r129 = r57.f;
        int r130 = n.a[r129.ordinal()];
        if (r130 != 1) goto L176;
        SourceType r131 = SourceType.ALBUM;
    L187:
        com.larus.chat.gallery.impl.preview.datasource.l r58 = new com.larus.chat.gallery.impl.preview.datasource.l(r128, r131);
        Intrinsics.checkNotNullParameter(r58, "dataSource");
        r4.b = r58;
        int r59 = r57.c;
        if (r59 < 0) goto L190;
        r4.c = r59;
        goto L190
    L176:
        if (r130 != 2) goto L178;
        r131 = SourceType.ATTACHMENT;
        goto L187
    L178:
        if (r130 != 3) goto L180;
        r131 = SourceType.CAMERA_RESULT;
        goto L187
    L180:
        if (r130 != 4) goto L183;
        r131 = SourceType.CLOUD_DRIVE;
        goto L187
    L183:
        throw new IllegalStateException(("Unsupported media-source scene: " + r129).toString());
    L265:
        throw new NoWhenBranchMatchedException();
    L77:
        r12 = new e(false);
        goto L78
    L55:
        if ((r52 instanceof p.a) == false) goto L66;
        q0 r60 = ((p.a) r52).e;
        if (r60 == null) goto L69;
        q0.a r61 = r60.getProvider();
        if (r61 == null) goto L69;
        com.larus.bmhome.chat.component.bottom.multimodal.g r62 = r61.r5();
        if (r62 == null) goto L69;
        if (r62.yb(null) != true) goto L69;
        boolean r63 = true;
    L70:
        r22 = Boolean.valueOf(r63);
    L69:
        r63 = false;
        goto L70
    L66:
        if ((r52 instanceof p.b) == true) goto L69;
        if (r3 == true) goto L69;
        throw new NoWhenBranchMatchedException();
    L51:
        r11 = r14.b();
        goto L52
    L48:
        r18 = r14.b();
        goto L49
    L39:
        if (r52.a() != PreviewScene.MESSAGE) goto L41;
    L44:
        r17 = true;
        goto L46
    L41:
        if (r13.i == true) goto L44;
        r17 = false;
        goto L46
    L19:
        int r132 = u.a;
        final PreviewScene r133 = r52.a();
        Intrinsics.checkNotNullParameter(r133, "scene");
        final sq9.e r64 = r8.getCreationDetailLayoutConfig();
        ToolbarLayoutMode.a r134 = ToolbarLayoutMode.Companion;
        int r65 = r64.d();
        r134.getClass();
        if (r65 != 1) goto L22;
        ToolbarLayoutMode r66 = ToolbarLayoutMode.HORIZONTAL;
    L23:
        ToolbarLayoutMode r211 = r66;
        ToolbarVisualStyle r212 = ToolbarVisualStyle.LEGACY;
        boolean r312 = r64.e();
        Function1 r67 = new t(r133, r10, r64);
        if (r133 != PreviewScene.SEARCH_IMAGE) goto L26;
        boolean r313 = true;
    L28:
        if (r64.d() != 1) goto L30;
        ToolbarLayoutMode r68 = ToolbarLayoutMode.HORIZONTAL;
    L32:
        if (r68 != ToolbarLayoutMode.VERTICAL) goto L34;
        boolean r314 = true;
    L35:
        r13 = new r(r133, r211, r212, r312, r67, r313, r314, r64.f(), r64.b());
        goto L36
    L34:
        r314 = false;
        goto L35
    L30:
        r68 = ToolbarLayoutMode.VERTICAL;
        goto L32
    L26:
        r313 = false;
        goto L28
    L22:
        r66 = ToolbarLayoutMode.VERTICAL;
        goto L23
    L80:
        throw new NoWhenBranchMatchedException();
    L81:
        p.c r69 = (p.c) r52;
        int r70 = u.a;
        r r71 = u.c(r69.f);
        boolean r72 = g.a.contains(r69.f);
        if (r72 == true) goto L84;
    L88:
        boolean r213 = false;
    L89:
        PreviewChromeKind r214 = PreviewChromeKind.MEDIA_SOURCE_V4;
        PreviewScene r135 = r69.f;
        boolean r136 = r69.d.getCapability().g;
        Intrinsics.checkNotNullParameter(r135, "scene");
        PreviewScene r137 = PreviewScene.ALBUM;
        if (r135 != r137) goto L92;
    L93:
        r136 = false;
    L94:
        boolean r138 = r71.j;
        Boolean r215 = Boolean.TRUE;
        if (r72 == false) goto L97;
        Boolean r216 = Boolean.valueOf(uy8.b.b("album"));
    L98:
        c r217 = new c(r136, true, true, true, r138, r215, r213, r216, true, r213);
        com.larus.chat.gallery.api.q r73 = r69.d;
        List<com.larus.chat.gallery.api.o> r139 = r69.b;
        if (r73.g() == false) goto L101;
    L104:
        boolean r218 = true;
    L105:
        PreviewScene r140 = r69.f;
        if (r140 != PreviewScene.CLOUD_DRIVE) goto L108;
        boolean r219 = true;
    L109:
        if (r140 != r137) goto L111;
    L116:
        boolean r220 = true;
    L117:
        int r141 = h.a.b[r140.ordinal()];
        if (r141 == 1) goto L127;
        if (r141 == 2) goto L127;
        if (r141 == 3) goto L127;
        if (r141 == 4) goto L127;
        e r74 = new e(false);
    L130:
        r16 = new f(r214, r71, r217, r73, r139, r218, r219, r220, r74);
    L127:
        if (((Boolean) r69.a.getValue()).booleanValue() == false) goto L129;
        r74 = new e(true);
        goto L130
    L129:
        r74 = new e(false);
        goto L130
    L111:
        if (r140 == PreviewScene.ATTACHMENT_PANEL) goto L116;
        if (r140 == PreviewScene.CAMERA_RESULT) goto L116;
        r220 = false;
        goto L117
    L108:
        r219 = false;
        goto L109
    L101:
        if (r69.d.p() != null) goto L104;
        r218 = false;
        goto L105
    L97:
        r216 = null;
        goto L98
    L92:
        if (r135 != PreviewScene.ATTACHMENT_PANEL) goto L94;
    L84:
        if (uy8.b.c() == false) goto L88;
        int r75 = q.a;
        if (q.b(r69.f) == false) goto L88;
        r213 = true;
        goto L89
    L6:
        if ((r52 instanceof p.a) == false) goto L8;
    L12:
        r6 = PreviewChromeKind.LEGACY;
        goto L13
    L8:
        if ((r52 instanceof p.b) == true) goto L12;
        throw new NoWhenBranchMatchedException();
    }
}
