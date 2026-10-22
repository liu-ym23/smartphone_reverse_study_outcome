package com.larus.bmhome.clarification;

import android.net.Uri;
import androidx.fragment.app.Fragment;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalBizScene;
import com.larus.bmhome.chat.component.bottom.multimodal.upload.FileUploadDelegate;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.picture.LocalTakePictureImpl;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.upload.ResourceUploader;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.bmhome.view.resourcebar.bean.Mode;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.platform.api.FlowDriveFileType;
import com.larus.platform.api.fileselect.DriveUplinkInfo;
import com.larus.platform.model.chat.UploadFilePolicy;
import com.larus.platform.model.upload.ResourceUploadInstantInfo;
import com.larus.platform.service.FlowDriveSdkService;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import v19.i5;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ClarificationAttachmentManager {
    public static final /* synthetic */ int k = 0;
    public final Fragment a;
    public final e2 b;
    public final Function1<Integer, Unit> c;
    public final Function1<Integer, Unit> d;
    public final Function0<CoroutineScope> e;
    public final Function0<y> f;
    public final Function0<com.larus.bmhome.chat.component.bottom.multimodal.g> g;
    public final a h;
    public final t i;
    public boolean j;

    public final class a implements com.larus.bmhome.chat.component.bottom.multimodal.upload.c {
        public final /* synthetic */ ClarificationAttachmentManager a;

        public a(ClarificationAttachmentManager r1) {
            this.a = r1;
        }

        public final UplinkFileEntity a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "localMsgId");
            Intrinsics.checkNotNullParameter(r3, "fileIdentifier");
            ClarificationAttachmentManager r0 = this.a;
            int r4 = r0.n(r2);
            if (r4 >= 0) goto L6;
            return null;
        L6:
            return r0.l(r4, r3);
        }

        public final void b(String r3, final String r4) {
            Intrinsics.checkNotNullParameter(r3, "localMsgId");
            Intrinsics.checkNotNullParameter(r4, "fileIdentifier");
            if (ClarificationAttachmentManager.e(this.a, r4) == false) goto L5;
            return;
        L5:
            final ClarificationAttachmentManager r0 = this.a;
            ClarificationAttachmentManager.f(r0, r3, new o(r0, r4));
        }

        public final void c(String r3, final UplinkFileEntity r4) {
            Intrinsics.checkNotNullParameter(r3, "localMsgId");
            Intrinsics.checkNotNullParameter(r4, "entity");
            if (ClarificationAttachmentManager.e(this.a, r4.getFileIdentifier()) == false) goto L5;
            return;
        L5:
            final ClarificationAttachmentManager r0 = this.a;
            ClarificationAttachmentManager.f(r0, r3, new p(r0, r4));
        }

        public final void e(String r3, final String r4) {
            Intrinsics.checkNotNullParameter(r3, "localMsgId");
            Intrinsics.checkNotNullParameter(r4, "fileIdentifier");
            if (ClarificationAttachmentManager.e(this.a, r4) == false) goto L5;
            return;
        L5:
            final ClarificationAttachmentManager r0 = this.a;
            ClarificationAttachmentManager.f(r0, r3, new m(r0, r4));
        }

        public final void g(String r3, final UplinkFileEntity r4) {
            Intrinsics.checkNotNullParameter(r3, "localMsgId");
            Intrinsics.checkNotNullParameter(r4, "entity");
            if (ClarificationAttachmentManager.e(this.a, r4.getFileIdentifier()) == false) goto L5;
            return;
        L5:
            final ClarificationAttachmentManager r0 = this.a;
            ClarificationAttachmentManager.f(r0, r3, new l(r0, r4));
        }

        public final void f(String r3, final String r4, final int r5) {
            Intrinsics.checkNotNullParameter(r3, "localMsgId");
            Intrinsics.checkNotNullParameter(r4, "fileIdentifier");
            if (ClarificationAttachmentManager.e(this.a, r4) == false) goto L5;
            return;
        L5:
            final ClarificationAttachmentManager r0 = this.a;
            ClarificationAttachmentManager.f(r0, r3, new q(r0, r4, r5));
        }

        public final void d(final String r13, final UplinkFileEntity r14, final String r15, final mr9.l r16, final Boolean r17, final Boolean r18) {
            Intrinsics.checkNotNullParameter(r13, "localMsgId");
            Intrinsics.checkNotNullParameter(r14, "entity");
            Intrinsics.checkNotNullParameter(r15, "fileIdentifier");
            Intrinsics.checkNotNullParameter(r16, "uploadResult");
            final ClarificationAttachmentManager r10 = this.a;
            if (r10.j == false) goto L6;
            ClarificationAttachmentManager.b(r10, r14, r16, r17, r18);
            this.a.getClass();
            ClarificationAttachmentManager.j(r14);
            return;
        L6:
            ClarificationAttachmentManager.f(r10, r13, new n(r10, r15, r14, r16, r17, r18, r13));
        }
    }

    public static final class b {
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[FlowDriveFileType.values().length];
            r0[FlowDriveFileType.VIDEO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[FlowDriveFileType.AUDIO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L6:
            a = r0;
            int[] r1 = new int[MultimodalBizScene.values().length];
            r1[MultimodalBizScene.ChatInputCamera.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            r1[MultimodalBizScene.ChatInputFastAlbumGuideCamera.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L9:
            b = r1;
        }
    }

    static {
    }

    public final void k() {
        if (this.j == false) goto L5;
        return;
    L5:
        this.j = true;
        d2 r0 = this.b.a;
        if (r0 == null) goto L8;
        List<z1> r1 = r0.l;
    L9:
        if (r1 != null) goto L11;
        r1 = CollectionsKt.emptyList();
    L11:
        Iterator<T> r2 = r1.iterator();
    L13:
        if (r2.hasNext() == false) goto L21;
        Iterator<T> r3 = ((z1) r2.next()).l.d.iterator();
    L16:
        if (r3.hasNext() == false) goto L13;
        UplinkFileEntity r4 = (UplinkFileEntity) r3.next();
        String r5 = r4.getFileIdentifier();
        if (r5 == null) goto L20;
        ResourceUploader.c(r5);
    L20:
        j(r4);
        goto L16
    L21:
        return;
    L8:
        r1 = null;
        goto L9
    }

    public static void j(UplinkFileEntity r8) {
        Integer r0 = r8.getUpLinkStatus();
        int r1 = UpLinkState.SUCCESS.getValue();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.intValue() == r1) goto L8;
        return;
    L8:
        Map r2 = r8.getExtra();
        if (r2 == null) goto L13;
        boolean r3 = true;
        if (r2.containsKey("drive_uplink_info") != true) goto L13;
    L14:
        if (r3 == false) goto L16;
        return;
    L16:
        UplinkEntityContent r4 = r8.getUplinkEntityContent();
        if (r4 == null) goto L23;
        Image r5 = r4.getUplinkImageInfo();
        if (r5 == null) goto L23;
        Map r6 = r5.ext;
        if (r6 == null) goto L23;
        String r7 = (String) r6.get("ext_is_from_drive");
    L25:
        if (Intrinsics.areEqual(r7, "1") == false) goto L27;
        return;
    L27:
        String r9 = r8.getFileIdentifier();
        if (r9 != null) goto L30;
        r9 = "";
    L30:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ClarificationAttachmentManager$deleteRemoteResourceIfNeeded$1(r9, r8, null), 2, null);
        return;
    L23:
        r7 = null;
    L13:
        r3 = false;
        goto L14
    }

    public static boolean m(MultimodalBizScene r3) {
        return SetsKt.setOf(new MultimodalBizScene[]{MultimodalBizScene.ChatInputFile, MultimodalBizScene.ChatInputActionEntranceFile, MultimodalBizScene.ChatAttachmentPanelMoreFile, MultimodalBizScene.ChatInputDriveFile}).contains(r3);
    }

    public final int n(String r5) {
        d2 r0 = this.b.a;
        if (r0 != null) goto L5;
        return -1;
    L5:
        Iterator<z1> r1 = r0.l.iterator();
        int r2 = 0;
    L7:
        if (r1.hasNext() == false) goto L15;
        if (Intrinsics.areEqual(r1.next().h, r5) == true) goto L12;
        r2 = r2 + 1;
        goto L7
    L12:
        return r2;
    L15:
        return -1;
    }

    public static final boolean e(ClarificationAttachmentManager r0, String r1) {
        if (r0.j == true) goto L5;
        return false;
    L5:
        if (r1 == null) goto L7;
        ResourceUploader.c(r1);
    L7:
        return true;
    }

    public final UplinkFileEntity l(int r4, String r5) {
        d2 r0 = this.b.a;
        Object r1 = null;
        if (r0 == null) goto L23;
        List<z1> r2 = r0.l;
        if (r2 == null) goto L24;
        z1 r6 = (z1) CollectionsKt.getOrNull(r2, r4);
        if (r6 == null) goto L25;
        i r7 = r6.l;
        if (r7 == null) goto L26;
        List<UplinkFileEntity> r8 = r7.d;
        if (r8 == null) goto L27;
        Iterator<T> r9 = r8.iterator();
    L14:
        if (r9.hasNext() == false) goto L19;
        Object r3 = r9.next();
        if (Intrinsics.areEqual(((UplinkFileEntity) r3).getFileIdentifier(), r5) == false) goto L14;
        r1 = r3;
    L19:
        return (UplinkFileEntity) r1;
    L27:
        return null;
    L26:
        return null;
    L25:
        return null;
    L24:
        return null;
    L23:
        return null;
    }

    public final void o(int r8, final List<UplinkFileEntity> r9) {
        List<UplinkFileEntity> r0 = r9;
        final ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L3:
        boolean r3 = false;
        if (r2.hasNext() == false) goto L13;
        UplinkFileEntity r4 = (UplinkFileEntity) r2.next();
        if (n1.d(r4) == false) goto L8;
    L11:
        int r5 = i5.w0();
    L12:
        r1.add(com.larus.bmhome.chat.c.a(r4, Mode.EDIT, r5, 0, 60));
        goto L3
    L8:
        if (n1.e(r4) == true) goto L11;
        r5 = i5.y();
        goto L12
    L13:
        this.b.d(r8, new k(r9, r1));
        this.c.invoke(Integer.valueOf(r8));
        d2 r10 = this.b.a;
        if (r10 != null) goto L16;
    L18:
        if (r3 == false) goto L24;
        this.d.invoke(Integer.valueOf(r8));
        return;
    L24:
        return;
    L16:
        if (r10.j != r8) goto L18;
        r3 = true;
        goto L18
    }

    public final void p(int r5, String r6) {
        d2 r0 = this.b.a;
        if (r0 == null) goto L11;
        List<z1> r1 = r0.l;
        if (r1 == null) goto L11;
        z1 r2 = (z1) CollectionsKt.getOrNull(r1, r5);
        if (r2 == null) goto L11;
        i r3 = r2.l;
        if (r3 == null) goto L11;
        List<UplinkFileEntity> r4 = r3.d;
    L12:
        if (r4 != null) goto L14;
        r4 = CollectionsKt.emptyList();
    L14:
        ArrayList r7 = new ArrayList();
        Iterator<T> r8 = r4.iterator();
    L16:
        if (r8.hasNext() == false) goto L20;
        Object r9 = r8.next();
        if (Intrinsics.areEqual(((UplinkFileEntity) r9).getFileIdentifier(), r6) == true) goto L16;
        r7.add(r9);
        goto L16
    L20:
        o(r5, r7);
        return;
    L11:
        r4 = null;
        goto L12
    }

    public final void q(String r13, UplinkFileEntity r14) {
        String r5 = r14.getFileIdentifier();
        if (r5 != null) goto L5;
        return;
    L5:
        Integer r0 = r14.getUpLinkStatus();
        int r1 = UpLinkState.SUCCESS.getValue();
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.intValue() == r1) goto L11;
        return;
    L11:
        ResourceCenter.a.getClass();
        if (ResourceCenter.c() == false) goto L15;
        FLogger.a.i("ClarificationAttachMgr", "[preHandle] via resource center, skip");
        return;
    L15:
        y r2 = (y) this.f.invoke();
        CoroutineScope r7 = (CoroutineScope) this.e.invoke();
        if (r7 == null) goto L20;
        BuildersKt.launch$default(r7, Dispatchers.getIO(), null, new ClarificationAttachmentManager$requestPreHandle$1(r14, r2, this, r13, r5, null), 2, null);
        return;
    }

    public final void s(int r6, UplinkFileEntity r7) {
        d2 r0 = this.b.a;
        if (r0 == null) goto L11;
        List<z1> r1 = r0.l;
        if (r1 == null) goto L11;
        z1 r2 = (z1) CollectionsKt.getOrNull(r1, r6);
        if (r2 == null) goto L11;
        i r3 = r2.l;
        if (r3 == null) goto L11;
        List<UplinkFileEntity> r4 = r3.d;
    L12:
        if (r4 != null) goto L14;
        r4 = CollectionsKt.emptyList();
    L14:
        List<UplinkFileEntity> r5 = r4;
        ArrayList r8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r5, 10));
        Iterator<T> r9 = r5.iterator();
    L16:
        if (r9.hasNext() == false) goto L21;
        UplinkFileEntity r10 = (UplinkFileEntity) r9.next();
        if (Intrinsics.areEqual(r10.getFileIdentifier(), r7.getFileIdentifier()) == false) goto L20;
        r10 = r7;
    L20:
        r8.add(r10);
        goto L16
    L21:
        o(r6, r8);
        return;
    L11:
        r4 = null;
        goto L12
    }

    public final void t(int r6, UplinkFileEntity r7) {
        d2 r0 = this.b.a;
        if (r0 == null) goto L11;
        List<z1> r1 = r0.l;
        if (r1 == null) goto L11;
        z1 r2 = (z1) CollectionsKt.getOrNull(r1, r6);
        if (r2 == null) goto L11;
        i r3 = r2.l;
        if (r3 == null) goto L11;
        List<UplinkFileEntity> r4 = r3.d;
    L12:
        if (r4 != null) goto L14;
        r4 = CollectionsKt.emptyList();
    L14:
        List<UplinkFileEntity> r5 = CollectionsKt.toMutableList(r4);
        Iterator<UplinkFileEntity> r8 = r5.iterator();
        int r9 = 0;
    L16:
        if (r8.hasNext() == false) goto L21;
        if (Intrinsics.areEqual(r8.next().getFileIdentifier(), r7.getFileIdentifier()) == true) goto L22;
        r9 = r9 + 1;
    L22:
        if (r9 < 0) goto L24;
        ListProtector.set(r5, r9, r7);
    L25:
        o(r6, r5);
        return;
    L24:
        r5.add(r7);
        goto L25
    L21:
        r9 = -1;
    L11:
        r4 = null;
        goto L12
    }

    public static final Object c(ClarificationAttachmentManager r38, com.larus.bmhome.chat.component.bottom.multimodal.a.b r39, Continuation r40) {
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r1 = r39;
        r38.getClass();
        if ((r40 instanceof ClarificationAttachmentManager$buildDriveEntity$1) == false) goto L7;
        ClarificationAttachmentManager$buildDriveEntity$1 r3 = (ClarificationAttachmentManager$buildDriveEntity$1) r40;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        int r0 = r3.I$1;
        int r7 = r3.I$0;
        UplinkEntityContent r8 = (UplinkEntityContent) r3.L$6;
        Long r9 = (Long) r3.L$5;
        String r10 = (String) r3.L$4;
        UplinkEntityContent r11 = (UplinkEntityContent) r3.L$3;
        String r12 = (String) r3.L$2;
        String r13 = (String) r3.L$1;
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r14 = (com.larus.bmhome.chat.component.bottom.multimodal.a.b) r3.L$0;
        ResultKt.throwOnFailure(r2);
        int r15 = r7;
        r1 = r14;
        UplinkEntityContent r16 = r11;
        Long r17 = r9;
    L48:
        int r18 = r0;
        VideoExtension r19 = (VideoExtension) r2;
        UplinkEntityContent r20 = r8;
        int r21 = r15;
    L49:
        String r22 = r12;
        String r23 = r13;
        r20.setUplinkFileInfo(new UplinkFileInfo(r10, r22, " ", Boxing.boxInt(r18), r17, null, r19, null, " ", null, 672, null));
        UplinkEntityContent r110 = r16;
        r13 = r23;
    L52:
        int r24 = FileReviewState.ACCESS.getValue();
        int r25 = FileParseState.SUCCESS.getValue();
        int r26 = UpLinkState.SUCCESS.getValue();
        Map r27 = r1.n;
        if (r27 != null) goto L56;
        r27 = MapsKt.emptyMap();
    L56:
        if (Intrinsics.areEqual(r27.get("upload_from"), "local") == false) goto L58;
        Map r28 = r27;
    L99:
        return new UplinkFileEntity(Boxing.boxInt(r21), r110, r13, null, Boxing.boxInt(r24), Boxing.boxInt(r25), Boxing.boxInt(100), Boxing.boxInt(r26), null, false, null, null, null, r28, 7944, null);
    L58:
        int r29 = r1.i;
        FlowDriveSdkService r30 = FlowDriveSdkService.a;
        String r111 = (String) r27.get("drive_uplink_info");
        r30.getClass();
        DriveUplinkInfo r31 = FlowDriveSdkService.C(r111);
        if (r31 == null) goto L67;
        String r112 = r31.getUrl();
        if (r112 == null) goto L67;
        if ((!StringsKt.isBlank(r112)) == true) goto L66;
        r112 = null;
    L66:
        if (r112 == null) goto L67;
    L68:
        String r113 = r112;
        if (r31 == null) goto L79;
        String r114 = r31.getFileToken();
        if (r114 == null) goto L79;
        if ((!StringsKt.isBlank(r114)) == true) goto L76;
        r114 = null;
    L76:
        if (r114 == null) goto L79;
        String r115 = r114;
    L80:
        if (r31 == null) goto L90;
        String r32 = r31.getFileName();
        if (r32 == null) goto L90;
        if ((true ^ StringsKt.isBlank(r32)) == true) goto L87;
        r32 = null;
    L87:
        if (r32 == null) goto L90;
        String r33 = r32;
    L91:
        String r34 = (String) r27.get("upload_way");
        if (r34 != null) goto L96;
        if (r31 == null) goto L95;
        r34 = r31.getUplinkWay();
        goto L96
    L95:
        String r116 = null;
    L97:
        r28 = MapsKt.plus(r27, MapsKt.mapOf(TuplesKt.to("drive_uplink_info", new DriveUplinkInfo(r113, r115, r33, r29, r29, r116).toString())));
    L96:
        r116 = r34;
    L90:
        r33 = r1.e;
    L79:
        r115 = r22;
    L67:
        r112 = r1.g;
        goto L68
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        r13 = UUID.randomUUID().toString();
        Uri r35 = r1.c;
        if (r35 == null) goto L17;
        String r36 = r35.toString();
    L18:
        String r37 = "";
        if (r36 != null) goto L22;
        r36 = "";
    L22:
        if (StringsKt.isBlank(r36) == false) goto L28;
        String r41 = r1.g;
        if (r41 == null) goto L27;
        r37 = r41;
    L27:
        r12 = r37;
    L29:
        r20 = new UplinkEntityContent(null, null, 3, null);
        if (r1.h != FlowDriveFileType.IMAGE) goto L35;
        r21 = UplinkEntityType.EntityTypeImage.getValue();
        ImageObj r42 = new ImageObj(r1.m, 0, 0, null, null, 30, null);
        String r43 = r1.l;
        if (r43 != null) goto L34;
        r43 = r1.g;
    L34:
        Image r44 = new Image(r12, " ", r42, new ImageObj(r43, 0, 0, null, null, 30, null), null, null, null, null, null, null, null, null, null, null, 16368, null);
        r44.localResPath = " ";
        r44.identifier = r13;
        r44.ext = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("ext_is_from_drive", "1")});
        r20.setUplinkImageInfo(r44);
        r22 = r12;
        r110 = r20;
        goto L52
    L35:
        r15 = UplinkEntityType.EntityTypeFile.getValue();
        r10 = r1.e;
        r17 = r1.f;
        int r117 = c.a[r1.h.ordinal()];
        if (r117 != 1) goto L38;
        r18 = FileType.FileTypeVideo.getValue();
    L43:
        if (r1.h != FlowDriveFileType.VIDEO) goto L50;
        r3.L$0 = r1;
        r3.L$1 = r13;
        r3.L$2 = r12;
        r3.L$3 = r20;
        r3.L$4 = r10;
        r3.L$5 = r17;
        r3.L$6 = r20;
        r3.I$0 = r15;
        r3.I$1 = r18;
        r3.label = 1;
        Object r45 = r38.h(r1, r12, r3);
        if (r45 == r5) goto L100;
        r16 = r20;
        r8 = r16;
        r2 = r45;
        r0 = r18;
        goto L48
    L100:
        return r5;
    L50:
        r16 = r20;
        r21 = r15;
        r19 = null;
        goto L49
    L38:
        if (r117 == 2) goto L40;
        r18 = FileType.FileTypeFile.getValue();
        goto L43
    L40:
        r18 = FileType.FileTypeAudio.getValue();
        goto L43
    L28:
        r12 = r36;
        goto L29
    L17:
        r36 = null;
    L7:
        r3 = new ClarificationAttachmentManager$buildDriveEntity$1(r38, r40);
        goto L8
    }

    public static final void f(ClarificationAttachmentManager r7, String r8, Function1 r9) {
        int r10 = r7.n(r8);
        if (r10 < 0) goto L10;
        CoroutineScope r1 = (CoroutineScope) r7.e.invoke();
        if (r1 == null) goto L9;
        BuildersKt.launch$default(r1, Dispatchers.getMain().getImmediate(), null, new ClarificationAttachmentManager$updateByLocalMsgId$1(r7, r9, r10, null), 2, null);
        return;
    L9:
        return;
    }

    public final Object h(com.larus.bmhome.chat.component.bottom.multimodal.a.b r29, String r30, Continuation<? super VideoExtension> r31) {
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r2 = r29;
        final String r3 = r30;
        if ((r31 instanceof ClarificationAttachmentManager$buildDriveVideoExtension$1) == false) goto L7;
        ClarificationAttachmentManager$buildDriveVideoExtension$1 r4 = (ClarificationAttachmentManager$buildDriveVideoExtension$1) r31;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r0 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        if (r7 == 0) goto L18;
        if (r7 != 1) goto L17;
        float r8 = r4.F$0;
        Lazy r9 = (Lazy) r4.L$2;
        String r10 = (String) r4.L$1;
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r11 = (com.larus.bmhome.chat.component.bottom.multimodal.a.b) r4.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L14
        float r12 = r8;
        Lazy r13 = r9;
        r2 = r11;
        r3 = r10;
    L22:
        Object r1 = Result.constructor-impl((String) r0);     // Catch: Throwable -> L24
        float r14 = r12;
    L27:
        String r15 = null;
        if (Result.isFailure-impl(r1) == false) goto L30;
        r1 = null;
    L30:
        String r16 = (String) r1;
        String r17 = r2.m;
        if (r17 != null) goto L33;
    L40:
        r17 = (String) r13.getValue();
    L41:
        ImageObj r18 = new ImageObj(r17, 0, 0, null, null, 30, null);
        String r19 = r2.l;
        if (r19 != null) goto L44;
    L50:
        r15 = (String) r13.getValue();
    L51:
        String r20 = r3;
        return new VideoExtension(r20, null, new Image(r20, null, r18, new ImageObj(r15, 0, 0, null, null, 30, null), null, null, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("ext_is_from_drive", "1")}), null, null, null, null, null, null, 16242, null), null, r16, null, Boxing.boxFloat(r14), null, null, null, 938, null);
    L44:
        if (r19.length() <= 0) goto L46;
        boolean r110 = true;
    L47:
        if (r110 == false) goto L49;
        r15 = r19;
    L49:
        if (r15 != null) goto L51;
    L46:
        r110 = false;
        goto L47
    L33:
        if (r17.length() <= 0) goto L35;
        boolean r111 = true;
    L36:
        if (r111 == true) goto L39;
        r17 = null;
    L39:
        if (r17 != null) goto L41;
    L35:
        r111 = false;
    L24:
        Throwable th = th;
        r11 = r2;
        r10 = r3;
        r9 = r13;
        r8 = r12;
    L26:
        Result.Companion r21 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        r13 = r9;
        r3 = r10;
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r27 = r11;
        r14 = r8;
        r2 = r27;
    L14:
        th = th;
        goto L26
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        r13 = LazyKt.lazy(new j(this, r3));
        r12 = r2.k;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L24
        FlowDriveSdkService r23 = FlowDriveSdkService.a;     // Catch: Throwable -> L24
        r4.L$0 = r2;     // Catch: Throwable -> L24
        r4.L$1 = r3;     // Catch: Throwable -> L24
        r4.L$2 = r13;     // Catch: Throwable -> L24
        r4.F$0 = r12;     // Catch: Throwable -> L24
        r4.label = 1;     // Catch: Throwable -> L24
        r0 = r23.b(r3, r4);     // Catch: Throwable -> L24
        if (r0 != r6) goto L22;
        return r6;
    L7:
        r4 = new ClarificationAttachmentManager$buildDriveVideoExtension$1(this, r31);
        goto L8
    }

    public final com.larus.bmhome.chat.component.bottom.multimodal.upload.m i(String r18, UplinkFileEntity r19, String r20) {
        y r1 = (y) this.f.invoke();
        d2 r2 = this.b.a;
        FileUploadDelegate r3 = FileUploadDelegate.b;
        if (r1 == null) goto L8;
        String r5 = r1.Y1();
        if (r5 == null) goto L8;
    L7:
        String r6 = r5;
    L11:
        if (r1 == null) goto L15;
        BotModel r4 = r1.j0();
        if (r4 == null) goto L15;
        String r7 = r4.getBotId();
    L16:
        if (r2 == null) goto L18;
        String r12 = r2.b;
    L19:
        if (r2 == null) goto L21;
        String r13 = r2.d;
    L22:
        if (r2 == null) goto L26;
        com.larus.bmhome.interactionpanel.w r8 = r2.n;
        if (r8 == null) goto L26;
        String r14 = r8.a;
    L27:
        if (r2 == null) goto L31;
        com.larus.bmhome.interactionpanel.w r9 = r2.n;
        if (r9 == null) goto L31;
        String r15 = r9.b;
    L33:
        return r3.a(r18, r19, r6, r7, true, r20, null, null, r12, r13, r14, r15, this.h);
    L31:
        r15 = null;
    L26:
        r14 = null;
        goto L27
    L21:
        r13 = null;
        goto L22
    L18:
        r12 = null;
    L15:
        r7 = null;
    L8:
        if (r2 == null) goto L10;
        r5 = r2.a;
        goto L7
    L10:
        r6 = null;
        goto L11
    }

    public final void r(String r12, UplinkFileEntity r13, String r14) {
        if (this.j == false) goto L5;
        return;
    L5:
        y r2 = (y) this.f.invoke();
        com.larus.bmhome.chat.component.bottom.multimodal.upload.m r3 = i(r12, r13, r14);
        CoroutineScope r0 = (CoroutineScope) this.e.invoke();
        if (r0 == null) goto L9;
        BuildersKt.launch$default(r0, Dispatchers.getIO(), null, new ClarificationAttachmentManager$startUpload$1(r2, r3, r14, r13, r12, null), 2, null);
        return;
    }

    public final Object g(int r6, String r7, com.larus.bmhome.chat.component.bottom.multimodal.a.b r8, Continuation<? super Unit> r9) {
        if ((r9 instanceof ClarificationAttachmentManager$addDriveAttachment$1) == false) goto L7;
        ClarificationAttachmentManager$addDriveAttachment$1 r0 = (ClarificationAttachmentManager$addDriveAttachment$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = r0.I$0;
        r7 = (String) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L17:
        UplinkFileEntity r11 = (UplinkFileEntity) r10;
        if (this.j == true) goto L20;
        t(r6, r11);
        q(r7, r11);
        return Unit.INSTANCE;
    L20:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        CoroutineDispatcher r12 = Dispatchers.getIO();
        ClarificationAttachmentManager$addDriveAttachment$entity$1 r4 = new ClarificationAttachmentManager$addDriveAttachment$entity$1(this, r8, null);
        r0.L$0 = r7;
        r0.I$0 = r6;
        r0.label = 1;
        r10 = BuildersKt.withContext(r12, r4, r0);
        if (r10 != r2) goto L17;
        return r2;
    L7:
        r0 = new ClarificationAttachmentManager$addDriveAttachment$1(this, r9);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v23 */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:102:0x021a -> B:103:0x0227). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x023d -> B:109:0x023f). Please report as a decompilation issue!!! */
    public static final Object a(ClarificationAttachmentManager r24, int r25, com.larus.bmhome.chat.component.bottom.multimodal.n r26, boolean r27, Continuation r28) {
        ClarificationAttachmentManager r0 = r24;
        r24.getClass();
        if ((r28 instanceof ClarificationAttachmentManager$addAttachments$1) == false) goto L7;
        ClarificationAttachmentManager$addAttachments$1 r3 = (ClarificationAttachmentManager$addAttachments$1) r28;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        int r1 = r3.I$0;
        Iterator r7 = (Iterator) r3.L$3;
        List r8 = (List) r3.L$2;
        String r9 = (String) r3.L$1;
        z1 r10 = (z1) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L127:
        if (r7.hasNext() == false) goto L131;
        com.larus.bmhome.chat.component.bottom.multimodal.a.b r11 = (com.larus.bmhome.chat.component.bottom.multimodal.a.b) r7.next();
        String r12 = r10.h;
        r3.L$0 = r10;
        r3.L$1 = r9;
        r3.L$2 = r8;
        r3.L$3 = r7;
        r3.L$4 = null;
        r3.L$5 = null;
        r3.L$6 = null;
        r3.I$0 = r1;
        r3.label = 2;
        if (r0.g(r1, r12, r11, r3) != r5) goto L127;
        return r5;
    L131:
        Iterator r13 = r8.iterator();
    L133:
        if (r13.hasNext() == false) goto L153;
        UplinkFileEntity r14 = (UplinkFileEntity) r13.next();
        r0.t(r1, r14);
        r0.r(r10.h, r14, r9);
        goto L133
    L153:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        int r15 = r3.I$2;
        int r16 = r3.I$1;
        boolean r17 = r3.Z$0;
        int r18 = r3.I$0;
        Iterator r19 = (Iterator) r3.L$6;
        Ref.BooleanRef r110 = (Ref.BooleanRef) r3.L$5;
        List r111 = (List) r3.L$4;
        List r112 = (List) r3.L$3;
        String r20 = (String) r3.L$2;
        z1 r21 = (z1) r3.L$1;
        com.larus.bmhome.chat.component.bottom.multimodal.n r22 = (com.larus.bmhome.chat.component.bottom.multimodal.n) r3.L$0;
        ResultKt.throwOnFailure(r2);
        List r23 = r112;
        List r113 = r111;
        Ref.BooleanRef r114 = r110;
        Iterator r115 = r19;
        z1 r116 = r21;
        Object r29 = r5;
        ClarificationAttachmentManager$addAttachments$1 r30 = r3;
        boolean r31 = true;
    L103:
        UplinkFileEntity r32 = (UplinkFileEntity) r2;
        if (r32 != null) goto L106;
        r114.element = r31;
    L107:
        com.larus.bmhome.chat.component.bottom.multimodal.n r33 = r22;
        boolean r34 = r17;
        ?? r35 = r16;
        List r117 = r23;
        int r36 = r18;
        String r118 = r20;
        int r37 = r15;
        ClarificationAttachmentManager r38 = r0;
    L109:
        ?? r39 = r35;
    L75:
        if (r115.hasNext() == false) goto L111;
        com.larus.bmhome.chat.component.bottom.multimodal.a r40 = (com.larus.bmhome.chat.component.bottom.multimodal.a) r115.next();
        if ((r40 instanceof com.larus.bmhome.chat.component.bottom.multimodal.a.b) == false) goto L80;
        r113.add(r40);
    L108:
        r34 = r34;
        r35 = r39;
        goto L109
    L80:
        Uri r41 = r40.b();
        if (r41 != null) goto L93;
        String r42 = r40.a();
        if (r42 != null) goto L138;
        Uri r119 = null;
    L94:
        if (r119 == null) goto L108;
        CoroutineDispatcher r43 = Dispatchers.getIO();
        if (r39 == 0) goto L98;
        boolean r210 = true;
    L99:
        ClarificationAttachmentManager$addAttachments$2$entity$1 r44 = new ClarificationAttachmentManager$addAttachments$2$entity$1(r38, r119, r210, r34, null);
        r30.L$0 = r33;
        r30.L$1 = r116;
        r30.L$2 = r118;
        r30.L$3 = r117;
        r30.L$4 = r113;
        r30.L$5 = r114;
        r30.L$6 = r115;
        r30.I$0 = r36;
        r30.Z$0 = r34;
        r30.I$1 = r39 == true ? 1 : 0;
        r30.I$2 = r37;
        boolean r211 = r34;
        r31 = true;
        r30.label = 1;
        Object r45 = BuildersKt.withContext(r43, r44, r30);
        if (r45 == r29) goto L150;
        r23 = r117;
        r17 = r211;
        com.larus.bmhome.chat.component.bottom.multimodal.n r212 = r33;
        r2 = r45;
        r0 = r38;
        r15 = r37;
        r20 = r118;
        r18 = r36;
        r16 = r39 == true ? 1 : 0;
        r22 = r212;
        goto L103
    L150:
        return r29;
    L98:
        r210 = false;
        goto L99
    L138:
        Result.Companion r46 = Result.Companion;     // Catch: Throwable -> L86
        Object r47 = Result.constructor-impl(UriProtector.parse(r42));     // Catch: Throwable -> L86
    L89:
        if (Result.isFailure-impl(r47) == false) goto L91;
        r47 = null;
    L91:
        r119 = (Uri) r47;
    L86:
        th = move-exception;
        Result.Companion r48 = Result.Companion;
        r47 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L89
    L93:
        r119 = r41;
        goto L94
    L111:
        if (r114.element == false) goto L123;
        if (CollectionsKt.take(r33.a, r37).size() <= 1) goto L115;
        boolean r49 = true;
    L116:
        if (r49 == false) goto L118;
        int r50 = 2131907890;
    L119:
        CoroutineScope r120 = (CoroutineScope) r38.e.invoke();
        if (r120 == null) goto L123;
        BuildersKt.launch$default(r120, Dispatchers.getMain().getImmediate(), null, new ClarificationAttachmentManager$showUnsupportedFileTypeTips$1(r50, null), 2, null);
        goto L123
    L118:
        r50 = 2131906526;
        goto L119
    L115:
        r49 = false;
    L123:
        if (r38.j == true) goto L151;
        r3 = r30;
        r5 = r29;
        r8 = r117;
        r9 = r118;
        r10 = r116;
        int r213 = r36;
        r7 = r113.iterator();
        r0 = r38;
        r1 = r213;
        goto L127
    L151:
        return Unit.INSTANCE;
    L106:
        r23.add(r32);
        goto L107
    L16:
        ResultKt.throwOnFailure(r2);
        if (r0.j == true) goto L148;
        d2 r51 = r0.b.a;
        if (r51 == null) goto L137;
        List<z1> r52 = r51.l;
        if (r52 == null) goto L137;
        r36 = r25;
        z1 r53 = (z1) CollectionsKt.getOrNull(r52, r36);
        if (r53 == null) goto L137;
        if (m(r26.b.b) == true) goto L43;
        List r54 = r26.a;
        if ((r54 instanceof Collection) == true) goto L31;
    L33:
        Iterator r55 = r54.iterator();
    L35:
        if (r55.hasNext() == false) goto L39;
        if ((((com.larus.bmhome.chat.component.bottom.multimodal.a) r55.next()) instanceof com.larus.bmhome.chat.component.bottom.multimodal.a.b) == false) goto L35;
        boolean r56 = true;
    L40:
        if (r56 == true) goto L43;
        boolean r57 = false;
    L44:
        com.larus.bmhome.chat.component.bottom.multimodal.g r58 = (com.larus.bmhome.chat.component.bottom.multimodal.g) r0.g.invoke();
        if (r58 == null) goto L47;
        int r59 = r58.zv(r57, null);
    L50:
        r37 = r59 - r53.l.d.size();
        if (r37 > 0) goto L53;
    L54:
        CoroutineScope r121 = (CoroutineScope) r0.e.invoke();
        if (r121 == null) goto L57;
        BuildersKt.launch$default(r121, Dispatchers.getMain().getImmediate(), null, new ClarificationAttachmentManager$showCountLimitTips$1(r0, r57, null), 2, null);
    L57:
        if (r37 <= 0) goto L149;
    L59:
        String r60 = com.larus.bmhome.chat.component.bottom.multimodal.o.b(r26);
        if (r60.length() != 0) goto L62;
        boolean r122 = true;
    L63:
        if (r122 == false) goto L73;
        MultimodalBizScene r61 = r26.b.b;
        int r123 = c.b[r61.ordinal()];
        if (r123 != 1) goto L67;
    L72:
        r60 = "shoot";
        goto L73
    L67:
        if (r123 == 2) goto L72;
        if (m(r61) == false) goto L71;
        r60 = ShareType.FILE;
        goto L73
    L71:
        r60 = "album";
    L73:
        r117 = new ArrayList();
        ArrayList r124 = new ArrayList();
        Ref.BooleanRef r125 = new Ref.BooleanRef();
        r115 = CollectionsKt.take(r26.a, r37).iterator();
        r113 = r124;
        r114 = r125;
        r116 = r53;
        r118 = r60;
        r33 = r26;
        r39 = r57;
        r38 = r0;
        r29 = r5;
        r30 = r3;
        r34 = r27;
        goto L75
    L62:
        r122 = false;
        goto L63
    L149:
        return Unit.INSTANCE;
    L53:
        if (r26.a.size() <= r37) goto L59;
    L47:
        if (r57 == false) goto L49;
        ImFileUtil.a.getClass();
        r59 = ImFileUtil.l();
        goto L50
    L49:
        ImFileUtil.a.getClass();
        r59 = ImFileUtil.n();
    L39:
        r56 = false;
        goto L40
    L31:
        if (r54.isEmpty() == false) goto L33;
    L43:
        r57 = true;
    L137:
        return Unit.INSTANCE;
    L148:
        return Unit.INSTANCE;
    L7:
        r3 = new ClarificationAttachmentManager$addAttachments$1(r0, r28);
        goto L8
    }

    public static final void b(ClarificationAttachmentManager r10, UplinkFileEntity r11, mr9.l r12, Boolean r13, Boolean r14) {
        r10.getClass();
        ResourceUploadInstantInfo r15 = r12.g;
        String r0 = null;
        if (r15 == null) goto L5;
        String r16 = GsonProtectorUtils.toJson(new Gson(), r15);
    L6:
        r11.setInstantUploadInfoJson(r16);
        if (n1.d(r11) == false) goto L21;
        UplinkEntityContent r17 = r11.getUplinkEntityContent();
        if (r17 == null) goto L52;
        Image r18 = r17.getUplinkImageInfo();
        if (r18 == null) goto L52;
        r18.key = r12.a;
        r18.md5 = yc9.l1.e(r11);
        mr9.d r2 = r12.d;
        if (r2 == null) goto L15;
        int r4 = r2.b;
    L16:
        if (r2 == null) goto L18;
        int r5 = r2.a;
    L19:
        r18.imageOri = new ImageObj(null, r4, r5, null, null, 25, null);
        r18.resourceId = r12.c;
        r18.setMarked(r13);
        r18.setCropped(r14);
        goto L52
    L18:
        r5 = 0;
        goto L19
    L15:
        r4 = 0;
    L52:
        r11.setUpLinkStatus(Integer.valueOf(UpLinkState.SUCCESS.getValue()));
        r11.setUpLinkProcess(100);
        return;
    L21:
        if (n1.c(r11) == false) goto L52;
        UplinkEntityContent r19 = r11.getUplinkEntityContent();
        if (r19 == null) goto L52;
        UplinkFileInfo r110 = r19.getUplinkFileInfo();
        if (r110 == null) goto L52;
        r110.setMd5(yc9.l1.e(r11));
        r110.setTosKey(r12.a);
        r110.setResourceId(r12.c);
        VideoExtension r111 = r110.getVideo();
        if (r111 == null) goto L52;
        mr9.n r112 = r12.e;
        if (r112 == null) goto L31;
        String r113 = r112.a;
    L32:
        r111.setVid(r113);
        mr9.n r114 = r12.e;
        if (r114 == null) goto L37;
        mr9.e r115 = r114.c;
        if (r115 == null) goto L37;
        r0 = r115.f();
    L37:
        r111.setFormat(r0);
        mr9.n r116 = r12.e;
        if (r116 == null) goto L43;
        mr9.e r117 = r116.c;
        if (r117 == null) goto L43;
        int r118 = r117.j();
        if (r118 == null) goto L43;
    L44:
        r111.setWidth(r118);
        mr9.n r119 = r12.e;
        if (r119 == null) goto L50;
        mr9.e r120 = r119.c;
        if (r120 == null) goto L50;
        int r121 = r120.h();
        if (r121 == null) goto L50;
    L51:
        r111.setHeight(r121);
    L50:
        r121 = 0;
    L43:
        r118 = 0;
        goto L44
    L31:
        r113 = null;
        goto L32
    L5:
        r16 = null;
        goto L6
    }

    public static final Object d(ClarificationAttachmentManager r47, Uri r48, boolean r49, boolean r50, Continuation r51) {
        Uri r2 = r48;
        r47.getClass();
        if ((r51 instanceof ClarificationAttachmentManager$buildLocalEntity$1) == false) goto L7;
        ClarificationAttachmentManager$buildLocalEntity$1 r3 = (ClarificationAttachmentManager$buildLocalEntity$1) r51;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r0 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        boolean r1 = r3.Z$1;
        boolean r7 = r3.Z$0;
        String r8 = (String) r3.L$1;
        Uri r9 = (Uri) r3.L$0;
        ResultKt.throwOnFailure(r0);
        boolean r10 = r7;
        r2 = r9;
    L48:
        boolean r11 = r1;
        String r12 = r8;
        if (((Boolean) r0).booleanValue() != true) goto L51;
        boolean r13 = true;
    L52:
        if (r13 == false) goto L54;
        Uri r21 = r2;
        String r14 = r12;
        boolean r15 = true;
    L57:
        if (r10 == true) goto L81;
        if (r11 == true) goto L81;
        if (r15 == true) goto L81;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L62
        ImFileUtil.a.getClass();     // Catch: Throwable -> L62
        Object r17 = Result.constructor-impl(ImFileUtil.f(r21));     // Catch: Throwable -> L62
    L65:
        if (Result.isFailure-impl(r17) == false) goto L67;
        r17 = null;
    L67:
        ic8.m0 r18 = (ic8.m0) r17;
        String r19 = "";
        if (r18 == null) goto L74;
        String r20 = r18.b;
        if (r20 == null) goto L74;
        String r22 = StringsKt.substringAfterLast(r20, '.', "");
        if (r22 == null) goto L74;
        String r23 = r22.toLowerCase(Locale.ROOT);
    L75:
        if (r23 == null) goto L79;
        r19 = r23;
    L79:
        if (UploadFilePolicy.g(r19) == true) goto L81;
        return null;
    L74:
        r23 = null;
    L62:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
    L81:
        if (r10 == false) goto L83;
        int r25 = UplinkEntityType.EntityTypeImage.getValue();
        int r26 = UpLinkState.PROCESSING.getValue();
        Image r27 = new Image(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
        r27.identifier = r14;
        r27.localResPath = r21.toString();
        r27.ext = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_marked", sr9.b.b.a(r21.toString()))});
        return new UplinkFileEntity(Boxing.boxInt(r25), new UplinkEntityContent(null, r27, 1, null), r14, null, null, null, Boxing.boxInt(0), Boxing.boxInt(r26), Boxing.boxBoolean(false), false, r21, null, null, null, 14904, null);
    L83:
        int r28 = UplinkEntityType.EntityTypeFile.getValue();
        int r29 = UpLinkState.PROCESSING.getValue();
        if (r11 == false) goto L86;
        int r30 = FileType.FileTypeAudio.getValue();
    L89:
        Integer r31 = Boxing.boxInt(r30);
        if (r15 == false) goto L99;
        Pair r32 = sr9.b.b.b(r21.toString());
        if (r32 == null) goto L94;
        Integer r43 = (Integer) r32.getFirst();
    L95:
        if (r32 == null) goto L97;
        Integer r42 = (Integer) r32.getSecond();
    L98:
        VideoExtension r34 = new VideoExtension(null, null, null, null, null, null, null, r42, r43, null, 639, null);
    L101:
        return new UplinkFileEntity(Boxing.boxInt(r28), new UplinkEntityContent(new UplinkFileInfo(null, null, null, r31, null, null, r34, null, null, null, 951, null), null, 2, null), r14, null, null, null, Boxing.boxInt(0), Boxing.boxInt(r29), Boxing.boxBoolean(false), false, r21, null, null, null, 14904, null);
    L97:
        r42 = null;
        goto L98
    L94:
        r43 = null;
        goto L95
    L99:
        r34 = null;
        goto L101
    L86:
        if (r15 == false) goto L88;
        r30 = FileType.FileTypeVideo.getValue();
        goto L89
    L88:
        r30 = FileType.FileTypeFile.getValue();
    L54:
        r21 = r2;
        r14 = r12;
        r15 = false;
    L51:
        r13 = false;
        goto L52
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        r12 = UUID.randomUUID().toString();
        Result.Companion r33 = Result.Companion;     // Catch: Throwable -> L17
        ImFileUtil.a.getClass();     // Catch: Throwable -> L17
        Object r35 = Result.constructor-impl(Boxing.boxBoolean(ImFileUtil.w(r48)));     // Catch: Throwable -> L17
    L19:
        Boolean r36 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r35) == false) goto L22;
        r35 = r36;
    L22:
        r10 = ((Boolean) r35).booleanValue();
        ImFileUtil.a.getClass();     // Catch: Throwable -> L25
        Object r37 = Result.constructor-impl(Boxing.boxBoolean(ImFileUtil.s(r48)));     // Catch: Throwable -> L25
    L27:
        Boolean r38 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r37) == false) goto L30;
        r37 = r38;
    L30:
        r11 = ((Boolean) r37).booleanValue();
        ImFileUtil.a.getClass();     // Catch: Throwable -> L33
        Object r39 = Result.constructor-impl(Boxing.boxBoolean(ImFileUtil.y(r48)));     // Catch: Throwable -> L33
    L35:
        Boolean r110 = Boxing.boxBoolean(false);
        if (Result.isFailure-impl(r39) == false) goto L38;
        r39 = r110;
    L38:
        boolean r40 = ((Boolean) r39).booleanValue();
        if (r49 == false) goto L55;
        if (r50 == true) goto L55;
        if (r40 == false) goto L54;
        com.larus.bmhome.chat.component.bottom.multimodal.g r41 = (com.larus.bmhome.chat.component.bottom.multimodal.g) r47.g.invoke();
        if (r41 == null) goto L51;
        r3.L$0 = r2;
        r3.L$1 = r12;
        r3.Z$0 = r10;
        r3.Z$1 = r11;
        r3.label = 1;
        r0 = r41.kp(r2, r12, r3);
        if (r0 == r5) goto L111;
        r8 = r12;
        r1 = r11;
        goto L48
    L111:
        return r5;
    L55:
        r15 = r40;
        r21 = r2;
        r14 = r12;
    L33:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r39 = Result.constructor-impl(ResultKt.createFailure(th));
    L25:
        th = move-exception;
        Result.Companion r44 = Result.Companion;
        r37 = Result.constructor-impl(ResultKt.createFailure(th));
    L17:
        th = move-exception;
        Result.Companion r45 = Result.Companion;
        r35 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r3 = new ClarificationAttachmentManager$buildLocalEntity$1(r47, r51);
        goto L8
    }

    public ClarificationAttachmentManager(Fragment r2, e2 r3, p0 r4, q0 r5, r0 r6, s0 r7, u0 r8, LocalTakePictureImpl r9) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "stateStore");
        Intrinsics.checkNotNullParameter(r4, "onPageChanged");
        Intrinsics.checkNotNullParameter(r5, "onCurrentPageContentChanged");
        Intrinsics.checkNotNullParameter(r6, "lifecycleScopeProvider");
        Intrinsics.checkNotNullParameter(r7, "chatConversationProvider");
        Intrinsics.checkNotNullParameter(r8, "multimodalProvider");
        Intrinsics.checkNotNullParameter(r9, "takePictureHelper");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = new a(this);
        this.i = new t(r2, r9, r7, r8);
    }
}
