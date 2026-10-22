package com.larus.chat.gallery.providers.input;

import android.net.Uri;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.bigimg.ImageSave;
import com.larus.bmhome.bigimg.m1;
import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.community.ICreationPageService;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.gallery.api.GalleryType;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.action.SuggestedActionScene;
import com.larus.platform.model.action.SuggestedActionType;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import yc9.l1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class GalleryInputProvider extends com.larus.gallery.api.t<ty8.b> {
    public final ty8.a f;
    public final Lazy g;
    public final b0 h;
    public final b i;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[GalleryType.values().length];
            r0[GalleryType.Image.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[GalleryType.Video.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class b implements com.larus.chat.gallery.providers.input.b {
        public final /* synthetic */ GalleryInputProvider a;

        @Override // com.larus.chat.gallery.providers.input.b
        public final void c() {
            FLogger r0 = FLogger.a;
            r0.i(((com.larus.gallery.api.t) this.a).a, "onCameraEntranceClick");
            this.a.f.getClass();
            q0 r1 = this.a.f.e;
            if (r1 == null) goto L9;
            q0.a r2 = r1.getProvider();
            if (r2 == null) goto L9;
            zb8.e r3 = r2.P8();
            if (r3 == null) goto L9;
            zb8.e.a.b(r3, "send_photo_preview", null, null, null, null, false, 124);
        L9:
            this.a.f.getClass();
            GalleryInputProvider r4 = this.a;
            q0 r5 = r4.f.e;
            if (r5 == null) goto L16;
            q0.a r6 = r5.getProvider();
            if (r6 == null) goto L16;
            zb8.e r7 = r6.P8();
            if (r7 == null) goto L16;
            Intrinsics.checkNotNullParameter(r7, "$this$cameraAbility");
            zb8.e.a.a(r7, r4.h, null, 6);
            Unit r8 = Unit.INSTANCE;
            return;
        L16:
            r0.e(((com.larus.gallery.api.t) r4).a, "[cameraAbility] failed, cannot get IChatCameraAbility");
        }

        @Override // com.larus.chat.gallery.providers.input.b
        public final boolean d() {
            this.a.f.getClass();
            q0 r0 = this.a.f.e;
            boolean r1 = false;
            if (r0 == null) goto L9;
            q0.a r2 = r0.getProvider();
            if (r2 == null) goto L9;
            ICoreInputAbility r3 = r2.v0();
            if (r3 == null) goto L9;
            r1 = r3.Qd(false);
        L9:
            FLogger.a.i(((com.larus.gallery.api.t) this.a).a, "supportSendImage enable:" + r1);
            return r1;
        }

        public b(GalleryInputProvider r1) {
            this.a = r1;
        }

        @Override // com.larus.chat.gallery.providers.input.b
        public final void a(String r2) {
            Intrinsics.checkNotNullParameter(r2, ShareType.TEXT);
        }

        /* JADX WARN: Type inference failed for: r6v0, types: [com.larus.chat.gallery.providers.input.e0] */
        @Override // com.larus.chat.gallery.providers.input.b
        public final void b(final String r15) {
            Intrinsics.checkNotNullParameter(r15, ShareType.TEXT);
            FLogger r0 = FLogger.a;
            r0.i(((com.larus.gallery.api.t) this.a).a, "onSendText");
            GalleryInputProvider r1 = this.a;
            ty8.b r2 = (ty8.b) ((com.larus.gallery.api.t) r1).d;
            final String r3 = null;
            if (r2 == null) goto L7;
            ConcurrentHashMap<String, String> r4 = r2.j;
            if (r4 == null) goto L7;
            String r5 = r4.get("chat_gallery_data_scene");
        L8:
            boolean r6 = true;
            if (Intrinsics.areEqual(r5, "main_bot") == false) goto L17;
            ty8.b r7 = (ty8.b) ((com.larus.gallery.api.t) r1).d;
            if (r7 == null) goto L13;
            GalleryType r8 = r7.e;
        L15:
            if (r8 != GalleryType.Image) goto L17;
            boolean r9 = true;
        L18:
            String r10 = "";
            if (r9 == false) goto L34;
            r0.i(((com.larus.gallery.api.t) this.a).a, "onSendText mainbot scene");
            ty8.b r11 = (ty8.b) ((com.larus.gallery.api.t) this.a).d;
            if (r11 != null) goto L23;
            return;
        L23:
            m1 r12 = r11.b;
            if (r12 == null) goto L27;
            r3 = r12.a;
        L27:
            if (o0.d(r3) == false) goto L33;
            final GalleryInputProvider r13 = this.a;
            Function1 r14 = new d0(r15, r13, r3);
            r13.getClass();
            ImageSave r16 = ImageSave.a;
            if (r3 != null) goto L31;
            String r17 = "";
        L32:
            this.a.getClass();
            final WeakReference r18 = new WeakReference(r14);
            ImageSave.z(r16, r17, null, null, null, false, false, null, new c0(r18), 126);
        L136:
            com.larus.gallery.api.w r19 = ((com.larus.gallery.api.t) this.a).e;
            if (r19 == null) goto L145;
            r19.Rf(com.larus.gallery.api.p.c.a);
            return;
        L145:
            return;
        L31:
            r17 = r3;
            goto L32
        L33:
            r0.e(((com.larus.gallery.api.t) this.a).a, "onSendText mainbot scene, but imageUri is empty");
            goto L136
        L34:
            ty8.b r20 = (ty8.b) ((com.larus.gallery.api.t) this.a).d;
            if (r20 == null) goto L43;
            Message r21 = r20.a;
            if (r21 == null) goto L43;
            String r22 = r21.getMessageId();
            if (r22 == null) goto L43;
            if (o0.d(r22) != true) goto L43;
            boolean r23 = true;
        L44:
            if (r23 == false) goto L46;
            r0.i(((com.larus.gallery.api.t) this.a).a, "onSendText skipUpload");
            GalleryInputProvider.y(this.a, r15);
            goto L136
        L46:
            final GalleryInputProvider r24 = this.a;
            ?? r25 = new e0(r24, r15);
            r24.getClass();
            Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L130
            ty8.b r27 = (ty8.b) ((com.larus.gallery.api.t) r24).d;     // Catch: Throwable -> L130
            if (r27 == null) goto L54;
            Message r28 = r27.a;     // Catch: Throwable -> L130
            if (r28 == null) goto L54;
            if (lr8.c.a(r28) != true) goto L54;
            boolean r29 = true;
        L55:
            if (r29 == false) goto L95;
            ty8.b r30 = (ty8.b) ((com.larus.gallery.api.t) r24).d;     // Catch: Throwable -> L130
            if (r30 == null) goto L61;
            Message r31 = r30.a;     // Catch: Throwable -> L130
            if (r31 == null) goto L61;
            NestedFileContent r32 = com.larus.bmhome.chat.bean.d.f(r31);     // Catch: Throwable -> L130
        L62:
            if (r32 == null) goto L77;
            List r33 = r32.getEntities();     // Catch: Throwable -> L130
            if (r33 == null) goto L77;
            Iterator r34 = r33.iterator();     // Catch: Throwable -> L130
        L67:
            if (r34.hasNext() == false) goto L75;
            Object r35 = r34.next();     // Catch: Throwable -> L130
            String r36 = ((UplinkFileEntity) r35).getFileIdentifier();     // Catch: Throwable -> L130
            ty8.b r37 = (ty8.b) ((com.larus.gallery.api.t) r24).d;     // Catch: Throwable -> L130
            if (r37 == null) goto L71;
            String r38 = r37.h;     // Catch: Throwable -> L130
        L73:
            if (Intrinsics.areEqual(r36, r38) == false) goto L67;
        L76:
            UplinkFileEntity r39 = (UplinkFileEntity) r35;     // Catch: Throwable -> L130
        L78:
            if (r39 == null) goto L85;
            Integer r40 = r39.getUpLinkStatus();     // Catch: Throwable -> L130
            int r41 = UpLinkState.SUCCESS.getValue();     // Catch: Throwable -> L130
            if (r40 == null) goto L85;
            if (r40.intValue() != r41) goto L85;
        L86:
            if (r6 == false) goto L89;
            FLogger.a.i(((com.larus.gallery.api.t) r24).a, "checkNeedReUpload skipUpload nestedFile");     // Catch: Throwable -> L130
            GalleryInputProvider.y(r24, r15);     // Catch: Throwable -> L130
            Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L130
        L128:
            Object r111 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L130
        L132:
            Throwable r42 = Result.exceptionOrNull-impl(r111);
            if (r42 == null) goto L135;
            FLogger.a.e(((com.larus.gallery.api.t) r24).a, "checkNeedReUpload error", r42);
        L135:
            Result.box-impl(r111);
            goto L136
        L89:
            if (r39 == null) goto L91;
            r3 = l1.d(r39);     // Catch: Throwable -> L130
        L91:
            if (r3 == null) goto L94;
            r10 = r3;
        L94:
            r25.invoke(Uri.fromFile(new PolarisFileWrapper(r10)));     // Catch: Throwable -> L130
        L85:
            r6 = false;
            goto L86
        L71:
            r38 = null;
            goto L73
        L75:
            r35 = null;
        L77:
            r39 = null;
        L61:
            r32 = null;
            goto L62
        L95:
            ty8.b r43 = (ty8.b) ((com.larus.gallery.api.t) r24).d;     // Catch: Throwable -> L130
            if (r43 == null) goto L102;
            Message r44 = r43.a;     // Catch: Throwable -> L130
            if (r44 == null) goto L102;
            if (r44.getContentType() != 6) goto L102;
            boolean r45 = true;
        L103:
            if (r45 == false) goto L128;
            ty8.b r46 = (ty8.b) ((com.larus.gallery.api.t) r24).d;     // Catch: Throwable -> L130
            if (r46 == null) goto L111;
            Message r47 = r46.a;     // Catch: Throwable -> L130
            if (r47 == null) goto L111;
            List r48 = com.larus.bmhome.chat.bean.d.g(r47).imageList;     // Catch: Throwable -> L130
            if (r48 == null) goto L111;
            Image r49 = (Image) CollectionsKt.firstOrNull(r48);     // Catch: Throwable -> L130
        L112:
            if (r49 == null) goto L118;
            String r50 = r49.key;     // Catch: Throwable -> L130
            if (r50 == null) goto L118;
            if (o0.d(r50) != true) goto L118;
        L119:
            if (r6 == false) goto L122;
            r0.i(((com.larus.gallery.api.t) r24).a, "checkNeedReUpload skipUpload image file");     // Catch: Throwable -> L130
            GalleryInputProvider.y(r24, r15);     // Catch: Throwable -> L130
            Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L130
            goto L128
        L122:
            if (r49 == null) goto L124;
            r3 = r49.localResPath;     // Catch: Throwable -> L130
        L124:
            if (r3 == null) goto L127;
            r10 = r3;
        L127:
            r25.invoke(Uri.fromFile(new PolarisFileWrapper(r10)));     // Catch: Throwable -> L130
        L118:
            r6 = false;
        L111:
            r49 = null;
        L102:
            r45 = false;
        L54:
            r29 = false;
        L130:
            th = move-exception;
            Result.Companion r51 = Result.Companion;
            r111 = Result.constructor-impl(ResultKt.createFailure(th));
        L43:
            r23 = false;
            goto L44
        L13:
            r8 = null;
        L17:
            r9 = false;
        L7:
            r5 = null;
            goto L8
        }

        @Override // com.larus.chat.gallery.providers.input.b
        public final void e(SuggestedAction r2, SuggestedActionScene r3) {
            Intrinsics.checkNotNullParameter(r2, "action");
            Intrinsics.checkNotNullParameter(r3, "scene");
            if (r2.getSuggestedActionType() != SuggestedActionType.MessageWithPromptReplacement.getValue()) goto L9;
            String r4 = r2.getDisplayName();
            if (r4 != null) goto L7;
            r4 = "";
        L7:
            b(r4);
            return;
        }
    }

    public final boolean m() {
        return false;
    }

    public final boolean s() {
        return true;
    }

    public final void u() {
        this.f.getClass();
        q0 r0 = this.f.e;
        if (r0 == null) goto L9;
        q0.a r1 = r0.getProvider();
        if (r1 == null) goto L9;
        zb8.e r2 = r1.P8();
        if (r2 == null) goto L9;
        Intrinsics.checkNotNullParameter(r2, "$this$cameraAbility");
        r2.MI();
        Unit r3 = Unit.INSTANCE;
    L10:
        com.larus.chat.gallery.providers.input.a r4 = (com.larus.chat.gallery.providers.input.a) s1a.a.g((GalleryInputFragment) this.g.getValue()).getAbility(com.larus.chat.gallery.providers.input.a.class);
        if (r4 == null) goto L13;
        Intrinsics.checkNotNullParameter(r4, "$this$inputAbility");
        r4.g();
        Unit r5 = Unit.INSTANCE;
        return;
    L13:
        FLogger.a.e(((com.larus.gallery.api.t) this).a, "[inputAbility] failed, cannot get GalleryInputAbility");
        return;
    L9:
        FLogger.a.e(((com.larus.gallery.api.t) this).a, "[cameraAbility] failed, cannot get IChatCameraAbility");
        goto L10
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.larus.chat.gallery.providers.input.b0] */
    public GalleryInputProvider(ty8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "galleryContext");
        this.f = r2;
        this.g = LazyKt.lazy(new a0(this));
        this.h = new b0(this);
        this.i = new b(this);
    }

    public final Fragment o(ViewGroup r1) {
        return (GalleryInputFragment) this.g.getValue();
    }

    public final void z(Function1<? super com.larus.chat.gallery.providers.input.a, Unit> r3) {
        com.larus.chat.gallery.providers.input.a r0 = (com.larus.chat.gallery.providers.input.a) s1a.a.g((GalleryInputFragment) this.g.getValue()).getAbility(com.larus.chat.gallery.providers.input.a.class);
        if (r0 == null) goto L5;
        r3.invoke(r0);
        return;
    L5:
        FLogger.a.e(((com.larus.gallery.api.t) this).a, "[inputAbility] failed, cannot get GalleryInputAbility");
    }

    public static final void y(GalleryInputProvider r46, String r47) {
        ty8.b r0 = (ty8.b) ((com.larus.gallery.api.t) r46).d;
        boolean r8 = true;
        String r2 = null;
        if (r0 == null) goto L45;
        Message r1 = r0.a;
        if (r1 == null) goto L45;
        FLogger.a.i(((com.larus.gallery.api.t) r46).a, "generateAttachment message id:" + r1.getMessageId() + " contentType:" + r1.getContentType());
        if (lr8.c.a(r1) == false) goto L27;
        List r3 = com.larus.bmhome.chat.bean.d.f(r1).getEntities();
        if (r3 == null) goto L23;
        Iterator r4 = r3.iterator();
    L13:
        if (r4.hasNext() == false) goto L21;
        Object r5 = r4.next();
        String r6 = ((UplinkFileEntity) r5).getFileIdentifier();
        ty8.b r7 = (ty8.b) ((com.larus.gallery.api.t) r46).d;
        if (r7 == null) goto L17;
        String r9 = r7.h;
    L19:
        if (Intrinsics.areEqual(r6, r9) == false) goto L13;
    L22:
        UplinkFileEntity r10 = (UplinkFileEntity) r5;
    L24:
        if (r10 == null) goto L45;
        CustomMultiAttachmentInfo r11 = new CustomMultiAttachmentInfo("album", "", new NestedFileContent(CollectionsKt.mutableListOf(new UplinkFileEntity[]{UplinkFileEntity.copy$default(r10, null, null, null, null, Integer.valueOf(FileReviewState.ACCESS.getValue()), Integer.valueOf(FileParseState.SUCCESS.getValue()), 100, Integer.valueOf(UpLinkState.SUCCESS.getValue()), null, false, null, null, null, null, 16143, null)}), null, false, null, 14, null), true, false, false, false, null, 240, null);
    L44:
        CustomMultiAttachmentInfo r12 = r11;
    L46:
        ty8.b r13 = (ty8.b) ((com.larus.gallery.api.t) r46).d;
        if (r13 == null) goto L49;
        GalleryType r14 = r13.e;
    L51:
        if (r14 != GalleryType.Image) goto L53;
        String r15 = "picture_detail";
    L54:
        ICoreInputAbility.OnSendParams r16 = new ICoreInputAbility.OnSendParams(r47, "", null, null, null, null, null, null, 0, false, null, false, false, false, null, null, null, null, false, r15, null, null, null, null, null, null, r12, null, null, null, null, null, null, -67633440, 1, null);
        ICreationPageService.a.getClass();
        if (ICreationPageService.a.a() == false) goto L101;
        r46.f.getClass();
        q0 r17 = r46.f.e;
        if (r17 == null) goto L64;
        q0.a r18 = r17.getProvider();
        if (r18 == null) goto L64;
        com.larus.bmhome.chat.component.cvs.y r19 = r18.u0();
        if (r19 == null) goto L64;
        wc9.e r20 = r19.h();
    L65:
        r46.f.getClass();
        q0 r21 = r46.f.e;
        if (r21 == null) goto L74;
        q0.a r22 = r21.getProvider();
        if (r22 == null) goto L74;
        com.larus.bmhome.chat.component.cvs.y r23 = r22.u0();
        if (r23 == null) goto L74;
        wc9.e r24 = r23.h();
        if (r24 == null) goto L74;
        r2 = r24.a;
    L74:
        if (r20 == null) goto L85;
        if (r2 != null) goto L77;
    L80:
        boolean r25 = true;
    L81:
        if (r25 == true) goto L85;
        if (r12 == null) goto L85;
        r16 = r16;
        BuildersKt.launch$default(r46.f.d, null, null, new GalleryInputProvider$sendTextAndMessageByCreation$1(r20, r2, r46, r16, r12, null), 3, null);
    L102:
        if (r8 == true) goto L118;
        r46.f.getClass();
        q0 r26 = r46.f.e;
        if (r26 == null) goto L115;
        q0.a r27 = r26.getProvider();
        if (r27 == null) goto L116;
        ICoreInputAbility r28 = r27.v0();
        if (r28 == null) goto L117;
        r28.E0(r16);
        return;
    L117:
        return;
    L116:
        return;
    L115:
        return;
    L118:
        return;
    L77:
        if (r2.length() == 0) goto L80;
        r25 = false;
    L85:
        FLogger r29 = FLogger.a;
        String r30 = ((com.larus.gallery.api.t) r46).a;
        StringBuilder r31 = new StringBuilder("sendTextAndMessageByCreation invalid params, conversationNull:");
        if (r20 != null) goto L88;
        boolean r32 = true;
    L89:
        r31.append(r32);
        r31.append(", cvsIdEmpty:");
        if (r2 != null) goto L92;
    L95:
        boolean r33 = true;
    L96:
        r31.append(r33);
        r31.append(", attachmentNull:");
        if (r12 == null) goto L100;
        r8 = false;
    L100:
        r31.append(r8);
        r29.e(r30, r31.toString());
        goto L101
    L92:
        if (r2.length() == 0) goto L95;
        r33 = false;
        goto L96
    L88:
        r32 = false;
    L64:
        r20 = null;
    L101:
        r8 = false;
        goto L102
    L53:
        r15 = "video_detail";
        goto L54
    L49:
        r14 = null;
        goto L51
    L17:
        r9 = null;
        goto L19
    L21:
        r5 = null;
        goto L22
    L23:
        r10 = null;
        goto L24
    L27:
        if (r1.getContentType() != 6) goto L45;
        List r34 = com.larus.bmhome.chat.bean.d.g(r1).imageList;
        if (r34 == null) goto L31;
        Image r35 = (Image) CollectionsKt.firstOrNull(r34);
    L32:
        UplinkFileEntity[] r36 = new UplinkFileEntity[1];
        int r37 = UplinkEntityType.EntityTypeImage.getValue();
        int r38 = UpLinkState.SUCCESS.getValue();
        int r210 = FileParseState.SUCCESS.getValue();
        int r211 = FileReviewState.ACCESS.getValue();
        ty8.b r110 = (ty8.b) ((com.larus.gallery.api.t) r46).d;
        if (r110 == null) goto L35;
        GalleryType r111 = r110.e;
    L36:
        if (r111 != null) goto L38;
        int r112 = -1;
    L39:
        if (r112 != 1) goto L42;
        if (r35 == null) goto L42;
        Image r39 = Image.copy$default(r35, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    L43:
        r36[0] = new UplinkFileEntity(Integer.valueOf(r37), new UplinkEntityContent(null, r39, 1, null), "", null, Integer.valueOf(r211), Integer.valueOf(r210), 100, Integer.valueOf(r38), null, false, null, null, null, null, 16136, null);
        r11 = new CustomMultiAttachmentInfo("album", "", new NestedFileContent(CollectionsKt.mutableListOf(r36), null, false, null, 14, null), true, false, false, false, null, 240, null);
    L42:
        r39 = null;
        goto L43
    L38:
        r112 = a.a[r111.ordinal()];
        goto L39
    L35:
        r111 = null;
        goto L36
    L31:
        r35 = null;
    L45:
        r12 = null;
        goto L46
    }

    public final void w(Object r2, int r3) {
        ty8.b r4 = (ty8.b) r2;
        Intrinsics.checkNotNullParameter(r4, "data");
        ((com.larus.gallery.api.t) this).d = r4;
        GalleryInputFragment r5 = (GalleryInputFragment) this.g.getValue();
        m1 r6 = r4.b;
        if (r6 == null) goto L5;
        String r7 = r6.a;
    L6:
        zy8.r r8 = r5.e;
        List<String> r9 = CollectionsKt.listOfNotNull(r7);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "urlList");
        r8.a = r9;
        z(new z(this));
        return;
    L5:
        r7 = null;
        goto L6
    }
}
