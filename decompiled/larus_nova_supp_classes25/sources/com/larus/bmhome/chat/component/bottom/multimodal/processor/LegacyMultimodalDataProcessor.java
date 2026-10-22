package com.larus.bmhome.chat.component.bottom.multimodal.processor;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import androidx.collection.LruCache;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.chat.component.bottom.attachment.entity.AttachmentPanelType;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalBizScene;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalDowngradeData;
import com.larus.bmhome.chat.component.bottom.multimodal.MultimodalInputComponentViewModel;
import com.larus.bmhome.chat.component.bottom.multimodal.VLMUploadDowngradeData;
import com.larus.bmhome.chat.component.bottom.multimodal.h1;
import com.larus.bmhome.chat.component.bottom.multimodal.i1;
import com.larus.bmhome.chat.component.bottom.multimodal.preprocess.SendResourcePreprocessManager;
import com.larus.bmhome.chat.component.bottom.p1;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.input.ChatInputService;
import com.larus.bmhome.chat.picture.LocalTakePictureImpl;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.o2;
import com.larus.im.bean.bot.BotConfItem;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.FlowDriveFileType;
import com.larus.platform.model.action.DirectSendData;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.downgrade.FlowDowngradeToastConfig;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ic8.m0;
import ic8.n0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import od8.h0;
import tx9.x0;
import tx9.y3;
import yc9.n1;
import ye8.b$a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Deprecated(message = "Legacy Implementation")
public final class LegacyMultimodalDataProcessor implements com.larus.bmhome.chat.component.bottom.multimodal.f {
    public static final /* synthetic */ int q = 0;
    public final b a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final com.larus.bmhome.chat.component.bottom.multimodal.processor.b o;
    public String p;

    public static final class a {
    }

    public static final class b {
        public final Fragment a;
        public final Context b;
        public final t1a.b c;
        public final LifecycleCoroutineScope d;
        public final MultimodalInputComponentViewModel e;
        public final LocalTakePictureImpl f;
        public final Function1<Boolean, ns8.b> g;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            return (((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
        }

        public final String toString() {
            return "Dependency(fragment=" + this.a + ", context=" + this.b + ", vContext=" + this.c + ", scope=" + this.d + ", viewModel=" + this.e + ", takePictureHelper=" + this.f + ", imageProcessConfigProvider=" + this.g + ')';
        }

        public final Context getContext() {
            return this.b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Fragment r2, Context r3, t1a.b r4, LifecycleCoroutineScope r5, MultimodalInputComponentViewModel r6, LocalTakePictureImpl r7, Function1<? super Boolean, ns8.b> r8) {
            Intrinsics.checkNotNullParameter(r2, "fragment");
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "vContext");
            Intrinsics.checkNotNullParameter(r5, "scope");
            Intrinsics.checkNotNullParameter(r6, "viewModel");
            Intrinsics.checkNotNullParameter(r7, "takePictureHelper");
            Intrinsics.checkNotNullParameter(r8, "imageProcessConfigProvider");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[MultimodalBizScene.values().length];
            r0[MultimodalBizScene.ChatInputCamera.ordinal()] = 1;     // Catch: NoSuchFieldError -> L34
        L79:
            r0[MultimodalBizScene.ChatInputFastAlbumGuideCamera.ordinal()] = 2;     // Catch: NoSuchFieldError -> L35
        L89:
            r0[MultimodalBizScene.ChatInputAlbum.ordinal()] = 3;     // Catch: NoSuchFieldError -> L36
        L95:
            r0[MultimodalBizScene.ChatInputFastAlbum.ordinal()] = 4;     // Catch: NoSuchFieldError -> L37
        L99:
            r0[MultimodalBizScene.ChatInputActionEntranceAlbum.ordinal()] = 5;     // Catch: NoSuchFieldError -> L38
        L103:
            r0[MultimodalBizScene.ChatInputCameraActionEntranceAlbum.ordinal()] = 6;     // Catch: NoSuchFieldError -> L39
        L111:
            r0[MultimodalBizScene.OuterChatInputAlbum.ordinal()] = 7;     // Catch: NoSuchFieldError -> L40
        L69:
            r0[MultimodalBizScene.OuterChatInputActionEntranceAlbum.ordinal()] = 8;     // Catch: NoSuchFieldError -> L41
        L81:
            r0[MultimodalBizScene.SuggestedActionAlbum.ordinal()] = 9;     // Catch: NoSuchFieldError -> L42
        L83:
            r0[MultimodalBizScene.PromptCellAlbum.ordinal()] = 10;     // Catch: NoSuchFieldError -> L43
        L91:
            r0[MultimodalBizScene.ChatAttachmentPanelMoreAlbum.ordinal()] = 11;     // Catch: NoSuchFieldError -> L44
        L107:
            r0[MultimodalBizScene.ChatLatestPhoto.ordinal()] = 12;     // Catch: NoSuchFieldError -> L45
        L113:
            r0[MultimodalBizScene.ChatInputFile.ordinal()] = 13;     // Catch: NoSuchFieldError -> L46
        L61:
            r0[MultimodalBizScene.PodcastFile.ordinal()] = 14;     // Catch: NoSuchFieldError -> L47
        L67:
            r0[MultimodalBizScene.OuterChatInputFile.ordinal()] = 15;     // Catch: NoSuchFieldError -> L48
        L87:
            r0[MultimodalBizScene.ChatAttachmentPanelMoreFile.ordinal()] = 16;     // Catch: NoSuchFieldError -> L49
        L93:
            r0[MultimodalBizScene.ChatInputActionEntranceFile.ordinal()] = 17;     // Catch: NoSuchFieldError -> L50
        L97:
            r0[MultimodalBizScene.OuterChatInputActionEntranceFile.ordinal()] = 18;     // Catch: NoSuchFieldError -> L51
        L105:
            r0[MultimodalBizScene.ChatAttachmentPanelMoreAudioFile.ordinal()] = 19;     // Catch: NoSuchFieldError -> L52
        L63:
            r0[MultimodalBizScene.InstructionDocumentRead.ordinal()] = 20;     // Catch: NoSuchFieldError -> L53
        L73:
            r0[MultimodalBizScene.SuggestedActionFile.ordinal()] = 21;     // Catch: NoSuchFieldError -> L54
        L77:
            r0[MultimodalBizScene.ChatPasteUri.ordinal()] = 22;     // Catch: NoSuchFieldError -> L55
        L85:
            r0[MultimodalBizScene.ChatReceiveUri.ordinal()] = 23;     // Catch: NoSuchFieldError -> L56
        L101:
            r0[MultimodalBizScene.ChatInputDriveFile.ordinal()] = 24;     // Catch: NoSuchFieldError -> L57
        L109:
            r0[MultimodalBizScene.PhotoPickerAttachmentPanel.ordinal()] = 25;     // Catch: NoSuchFieldError -> L58
        L29:
            a = r0;
            int[] r1 = new int[FlowDriveFileType.values().length];
            r1[FlowDriveFileType.AUDIO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L59
        L75:
            r1[FlowDriveFileType.IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L60
        L32:
            b = r1;
        }
    }

    static {
    }

    private final Context getContext() {
        return this.a.getContext();
    }

    public final BotModel B() {
        y r0 = (y) this.d.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.j0();
    }

    public final g1 C() {
        return (g1) this.e.getValue();
    }

    public final wc9.e D() {
        y r0 = (y) this.d.getValue();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.h();
    }

    public final ICoreInputAbility E() {
        return (ICoreInputAbility) this.i.getValue();
    }

    public final com.larus.bmhome.instruction.g G() {
        return (com.larus.bmhome.instruction.g) this.g.getValue();
    }

    public final void z() {
        gd8.g r0 = (gd8.g) this.c.getValue();
        if (r0 == null) goto L11;
        y r2 = (y) this.d.getValue();
        if (r2 == null) goto L7;
        String r3 = r2.Y1();
    L8:
        if (r3 != null) goto L10;
        r3 = "";
    L10:
        r0.mh(r3, "beforeProcessSendFileOrImg", OmniBreakReason.OmniBreakReason_SEND_NEW_MSG);
        goto L11
    L7:
        r3 = null;
    L11:
        ICoreInputAbility r1 = E();
        if (r1 == null) goto L14;
        r1.C1(false, true, "");
    L14:
        com.larus.utils.y.d(new q(this), 50);
    }

    public final int F() {
        com.larus.bmhome.instruction.g r0 = G();
        if (r0 == null) goto L7;
        boolean r1 = true;
        if (r0.Aq() != true) goto L7;
    L8:
        if (r1 == false) goto L15;
        IFlowSdkDepend r2 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r2 == null) goto L14;
        o2 r3 = r2.x0();
        if (r3 == null) goto L14;
        return r3.e4();
    L14:
        return 5;
    L15:
        ImFileUtil.a.getClass();
        return ImFileUtil.n();
    L7:
        r1 = false;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v27, types: [com.larus.bmhome.chat.component.bottom.multimodal.processor.b] */
    public LegacyMultimodalDataProcessor(b r2) {
        Intrinsics.checkNotNullParameter(r2, "dependency");
        this.a = r2;
        this.b = LazyKt.lazy(new r(this));
        this.c = LazyKt.lazy(new com.larus.bmhome.chat.component.bottom.multimodal.processor.c(this));
        this.d = LazyKt.lazy(new d(this));
        this.e = LazyKt.lazy(new e(this));
        this.f = LazyKt.lazy(new f(this));
        this.g = LazyKt.lazy(new g(this));
        this.h = LazyKt.lazy(new h(this));
        this.i = LazyKt.lazy(new i(this));
        this.j = LazyKt.lazy(new j(this));
        this.k = LazyKt.lazy(new k(this));
        this.l = LazyKt.lazy(new s(this));
        this.m = LazyKt.lazy(new t(this));
        this.n = LazyKt.lazy(new u(this));
        this.o = new com.larus.bmhome.chat.component.bottom.multimodal.processor.b(this);
        this.p = "";
    }

    public static boolean A(List r13) {
        MultimodalDowngradeData r0 = ChatInputService.b.A6();
        boolean r2 = false;
        if (r0 == null) goto L10;
        Integer r3 = r0.getFileDowngrade();
        if (r3 == null) goto L10;
        if (r3.intValue() != 1) goto L10;
        boolean r4 = true;
    L11:
        String r6 = null;
        if (r4 == false) goto L48;
        List r5 = r13;
        if ((r5 instanceof Collection) == true) goto L16;
    L18:
        Iterator r7 = r5.iterator();
    L20:
        if (r7.hasNext() == false) goto L29;
        Uri r8 = (Uri) r7.next();
        ImFileUtil.a.getClass();
        if (ImFileUtil.w(r8) == false) goto L24;
    L26:
        boolean r9 = false;
    L27:
        if (r9 == false) goto L20;
        boolean r10 = true;
    L30:
        if (r10 == false) goto L48;
        FLogger.a.i("LegacyMultimodalDataProcessor", "fileDowngrade = 1, return");
        t19.s r11 = t19.s.a;
        AppHost.Companion r14 = AppHost.a;
        Application r12 = r14.getApplication();
        z2 r1 = z2.a;
        FlowDowngradeToastConfig r15 = r1.getFlowDowngradeToastConfig();
        if (r15 == null) goto L34;
        String r16 = r15.getTrafficDegradationFeatureDisableCn();
    L35:
        if (r16 != null) goto L37;
    L38:
        r2 = true;
    L39:
        if (r2 == false) goto L42;
        String r17 = r14.getApplication().getString(2131910602);
    L41:
        String r18 = r17;
        Intrinsics.checkNotNull(r18);
        t19.s.j(r11, r12, r18, null, false, 28);
        x0.a("atm_dg_file_dg");
        return true;
    L42:
        FlowDowngradeToastConfig r19 = r1.getFlowDowngradeToastConfig();
        if (r19 == null) goto L45;
        r6 = r19.getTrafficDegradationFeatureDisableCn();
    L45:
        r17 = String.valueOf(r6);
        goto L41
    L37:
        if (r16.length() != 0) goto L39;
    L34:
        r16 = null;
        goto L35
    L24:
        if (ImFileUtil.y(r8) == true) goto L26;
        r9 = true;
    L29:
        r10 = false;
        goto L30
    L16:
        if (r5.isEmpty() == false) goto L18;
    L48:
        if (r0 == null) goto L55;
        Integer r20 = r0.getVideoDowngrade();
        if (r20 == null) goto L55;
        if (r20.intValue() != 1) goto L55;
        boolean r21 = true;
    L56:
        if (r21 == false) goto L87;
        List r110 = r13;
        if ((r110 instanceof Collection) == true) goto L60;
    L62:
        Iterator r111 = r110.iterator();
    L64:
        if (r111.hasNext() == false) goto L68;
        Uri r22 = (Uri) r111.next();
        ImFileUtil.a.getClass();
        if (ImFileUtil.y(r22) == false) goto L64;
        boolean r112 = true;
    L69:
        if (r112 == false) goto L87;
        FLogger.a.i("LegacyMultimodalDataProcessor", "videoDowngrade = 1, return");
        t19.s r23 = t19.s.a;
        AppHost.Companion r113 = AppHost.a;
        Application r24 = r113.getApplication();
        z2 r25 = z2.a;
        FlowDowngradeToastConfig r26 = r25.getFlowDowngradeToastConfig();
        if (r26 == null) goto L73;
        String r27 = r26.getTrafficDegradationFeatureDisableCn();
    L74:
        if (r27 != null) goto L76;
    L77:
        r2 = true;
    L78:
        if (r2 == false) goto L81;
        String r114 = r113.getApplication().getString(2131910602);
    L80:
        String r28 = r114;
        Intrinsics.checkNotNull(r28);
        t19.s.j(r23, r24, r28, null, false, 28);
        x0.a("atm_dg_video_dg");
        return true;
    L81:
        FlowDowngradeToastConfig r115 = r25.getFlowDowngradeToastConfig();
        if (r115 == null) goto L84;
        r6 = r115.getTrafficDegradationFeatureDisableCn();
    L84:
        r114 = String.valueOf(r6);
        goto L80
    L76:
        if (r27.length() != 0) goto L78;
    L73:
        r27 = null;
    L68:
        r112 = false;
        goto L69
    L60:
        if (r110.isEmpty() == false) goto L62;
    L87:
        return false;
    L55:
        r21 = false;
    L10:
        r4 = false;
        goto L11
    }

    public static boolean H(List r2) {
        Iterator r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L13;
        Uri r0 = (Uri) r3.next();
        ImFileUtil.a.getClass();     // Catch: Throwable -> L11
        m0 r1 = ImFileUtil.f(r0);     // Catch: Throwable -> L11
        if (ImFileUtil.u(r1.b, r1.d) == false) goto L4;
        return false;
    L11:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th, "onMultiFileResultSuccess getFileInfoFromUri exception");
        goto L4
    L13:
        return true;
    }

    public static final /* synthetic */ void b(LegacyMultimodalDataProcessor r0) {
        r0.z();
    }

    public static final /* synthetic */ BotModel c(LegacyMultimodalDataProcessor r0) {
        return r0.B();
    }

    public static final String d(LegacyMultimodalDataProcessor r5) {
        com.larus.bmhome.instruction.g r0 = r5.G();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (Intrinsics.areEqual(r5.p, "chat_action_bar") == false) goto L20;
        com.larus.bmhome.instruction.g r3 = r5.G();
        if (r3 != null) goto L13;
    L15:
        if (r1 == true) goto L17;
        if (r2 == false) goto L20;
    L17:
        com.larus.bmhome.instruction.g r6 = r5.G();
        if (r6 == null) goto L20;
        return r6.M10();
    L13:
        if (r3.vX() != true) goto L15;
        r1 = true;
    L20:
        return null;
    L5:
        if (r0.HM() != true) goto L7;
        r2 = true;
        goto L9
    }

    public static final /* synthetic */ g1 e(LegacyMultimodalDataProcessor r0) {
        return r0.C();
    }

    public static final p1 f(LegacyMultimodalDataProcessor r0) {
        return (p1) r0.f.getValue();
    }

    public static final /* synthetic */ Context g(LegacyMultimodalDataProcessor r0) {
        return r0.getContext();
    }

    public static final /* synthetic */ wc9.e h(LegacyMultimodalDataProcessor r0) {
        return r0.D();
    }

    public static final /* synthetic */ ICoreInputAbility i(LegacyMultimodalDataProcessor r0) {
        return r0.E();
    }

    public static final Fragment l(LegacyMultimodalDataProcessor r0) {
        return r0.a.a;
    }

    public static final /* synthetic */ int m(LegacyMultimodalDataProcessor r0) {
        return r0.F();
    }

    public static final /* synthetic */ com.larus.bmhome.instruction.g n(LegacyMultimodalDataProcessor r0) {
        return r0.G();
    }

    public static final LifecycleCoroutineScope o(LegacyMultimodalDataProcessor r0) {
        return r0.a.d;
    }

    public static final com.larus.bmhome.chat.component.bottom.multimodal.g p(LegacyMultimodalDataProcessor r0) {
        return (com.larus.bmhome.chat.component.bottom.multimodal.g) r0.n.getValue();
    }

    public static final com.larus.bmhome.chat.component.bottom.reference.a q(LegacyMultimodalDataProcessor r0) {
        return (com.larus.bmhome.chat.component.bottom.reference.a) r0.m.getValue();
    }

    public static final /* synthetic */ String s(LegacyMultimodalDataProcessor r0) {
        return r0.p;
    }

    /* JADX WARN: Type inference failed for: r10v17, types: [com.larus.bmhome.chat.component.bottom.multimodal.processor.o] */
    /* JADX WARN: Type inference failed for: r11v13, types: [com.larus.bmhome.chat.component.bottom.multimodal.processor.p] */
    public final boolean a(com.larus.bmhome.chat.component.bottom.multimodal.n r27) {
        Intrinsics.checkNotNullParameter(r27, "data");
        FLogger r1 = FLogger.a;
        r1.i("LegacyMultimodalDataProcessor", "[process] " + r27);
        Function1<Boolean, ns8.b> r2 = this.a.g;
        MultimodalBizScene r4 = r27.b.b;
        int[] r5 = c.a;
        int r6 = r5[r4.ordinal()];
        if (r6 != 16) goto L5;
    L11:
        boolean r7 = true;
    L12:
        ns8.b r24 = (ns8.b) r2.invoke(Boolean.valueOf(r7));
        int r3 = r5[r27.b.b.ordinal()];
        String r8 = "";
        switch(r3) {
            case 1: goto L393;
            case 2: goto L393;
            case 3: goto L333;
            case 4: goto L333;
            case 5: goto L333;
            case 6: goto L333;
            case 7: goto L333;
            case 8: goto L333;
            case 9: goto L333;
            case 10: goto L333;
            case 11: goto L333;
            case 12: goto L333;
            case 13: goto L306;
            case 14: goto L306;
            case 15: goto L306;
            case 16: goto L306;
            case 17: goto L306;
            case 18: goto L306;
            case 19: goto L306;
            case 20: goto L306;
            case 21: goto L306;
            case 22: goto L293;
            case 23: goto L65;
            case 24: goto L42;
            case 25: goto L15;
            default: goto L482;
        };
    L15:
        List<com.larus.bmhome.chat.component.bottom.multimodal.a> r9 = r27.a;
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r9.iterator();
    L17:
        if (r11.hasNext() == false) goto L21;
        Uri r12 = ((com.larus.bmhome.chat.component.bottom.multimodal.a) r11.next()).b();
        if (r12 == null) goto L17;
        r10.add(r12);
        goto L17
    L21:
        String r13 = com.larus.bmhome.chat.component.bottom.multimodal.o.b(r27);
        Integer r14 = com.larus.bmhome.chat.component.bottom.multimodal.o.a(r27);
        com.larus.bmhome.chat.component.bottom.multimodal.m r15 = r27.e;
        if (r15 == null) goto L25;
        DirectSendData r16 = r15.c;
        if (r16 == null) goto L25;
    L26:
        DirectSendData r17 = r16;
        Map<String, String> r18 = r27.d;
        com.larus.bmhome.chat.component.bottom.multimodal.m r0 = r27.e;
        if (r0 == null) goto L31;
        com.larus.bmhome.chat.component.bottom.multimodal.i r19 = r0.d;
        if (r19 == null) goto L31;
        List<Boolean> r20 = r19.a;
    L32:
        if (r0 == null) goto L36;
        com.larus.bmhome.chat.component.bottom.multimodal.i r21 = r0.d;
        if (r21 == null) goto L36;
        List<Boolean> r110 = r21.b;
    L38:
        if (r0 == null) goto L40;
        String r22 = r0.g;
    L41:
        I(this, r10, false, r13, r14, r17, r18, r20, r110, null, null, false, null, false, r22, false, null, r24, 57088);
        Unit r23 = Unit.INSTANCE;
    L392:
        return true;
    L40:
        r22 = null;
    L36:
        r110 = null;
    L31:
        r20 = null;
    L25:
        r16 = com.larus.bmhome.chat.component.bottom.multimodal.o.c(r27);
        goto L26
    L42:
        List<com.larus.bmhome.chat.component.bottom.multimodal.a> r25 = r27.a;
        ArrayList r26 = new ArrayList();
        Iterator<T> r28 = r25.iterator();
    L44:
        if (r28.hasNext() == false) goto L48;
        Uri r29 = ((com.larus.bmhome.chat.component.bottom.multimodal.a) r28.next()).b();
        if (r29 == null) goto L44;
        r26.add(r29);
        goto L44
    L48:
        String r30 = com.larus.bmhome.chat.component.bottom.multimodal.o.b(r27);
        Integer r31 = com.larus.bmhome.chat.component.bottom.multimodal.o.a(r27);
        com.larus.bmhome.chat.component.bottom.multimodal.m r32 = r27.e;
        if (r32 == null) goto L52;
        DirectSendData r33 = r32.c;
        if (r33 == null) goto L52;
    L53:
        DirectSendData r34 = r33;
        Map<String, String> r35 = r27.d;
        com.larus.bmhome.chat.component.bottom.multimodal.m r36 = r27.e;
        if (r36 == null) goto L58;
        com.larus.bmhome.chat.component.bottom.multimodal.i r37 = r36.d;
        if (r37 == null) goto L58;
        List<Boolean> r111 = r37.a;
    L59:
        if (r36 == null) goto L63;
        com.larus.bmhome.chat.component.bottom.multimodal.i r38 = r36.d;
        if (r38 == null) goto L63;
        List<Boolean> r210 = r38.b;
    L64:
        I(this, r26, false, r30, r31, r34, r35, r111, r210, null, null, true, r27.a, false, null, false, null, null, 127744);
        Unit r39 = Unit.INSTANCE;
    L63:
        r210 = null;
    L58:
        r111 = null;
    L52:
        r33 = com.larus.bmhome.chat.component.bottom.multimodal.o.c(r27);
        goto L53
    L65:
        List<com.larus.bmhome.chat.component.bottom.multimodal.a> r40 = r27.a;
        final ArrayList r41 = new ArrayList();
        Iterator<T> r42 = r40.iterator();
    L67:
        if (r42.hasNext() == false) goto L71;
        Uri r43 = ((com.larus.bmhome.chat.component.bottom.multimodal.a) r42.next()).b();
        if (r43 == null) goto L67;
        r41.add(r43);
        goto L67
    L71:
        final String r44 = r27.d.get("mobile_new_session_mode_draft_replacement");
        if (r44 == null) goto L76;
        boolean r112 = true;
        if ((!StringsKt.isBlank(r44)) == true) goto L78;
    L77:
        r44 = null;
    L78:
        if (r44 == null) goto L80;
        final boolean r113 = true;
    L82:
        if (r41.isEmpty() == false) goto L90;
        if (r113 == false) goto L292;
        z2 r45 = z2.a;
        if (z2.c4() == false) goto L292;
        p1 r46 = (p1) this.f.getValue();
        if (r46 == null) goto L292;
        r46.cb(r112);
    L292:
        Unit r47 = Unit.INSTANCE;
        goto L392
    L90:
        FLogger.a.i("LegacyMultimodalDataProcessor", "[onReceiveUris] " + r41);
        ICoreInputAbility r48 = E();
        if (r48 == null) goto L93;
        final boolean r49 = r48.Qd(r113);
    L94:
        ICoreInputAbility r50 = E();
        if (r50 == null) goto L97;
        final boolean r51 = r50.CD(r113);
    L98:
        ICoreInputAbility r52 = E();
        if (r52 == null) goto L101;
        final boolean r53 = r52.wy();
    L102:
        List r114 = SequencesKt.toMutableList(SequencesKt.filterNot(SequencesKt.filterNot(SequencesKt.filterNot(CollectionsKt.asSequence(r41), new com.larus.bmhome.chat.component.bottom.multimodal.processor.a(r49)), new l(r53)), new n(r51)));
        if (r114.isEmpty() == false) goto L111;
        t19.s r54 = t19.s.a;
        Application r55 = AppHost.a.getApplication();
        r54.getClass();
        t19.s.s(r55, 2131907890);
        if (r113 == false) goto L292;
        z2 r56 = z2.a;
        if (z2.c4() == false) goto L292;
        p1 r57 = (p1) this.f.getValue();
        if (r57 == null) goto L292;
        r57.cb(r112);
        goto L292
    L111:
        g1 r58 = C();
        if (r58 == null) goto L117;
        String r59 = r58.uM();
        if (r59 == null) goto L117;
        r8 = r59;
    L117:
        if (r113 == true) goto L131;
        com.larus.bmhome.instruction.g r60 = G();
        if (r60 != null) goto L121;
    L123:
        boolean r61 = false;
    L124:
        if (r61 == false) goto L131;
        com.larus.bmhome.instruction.g r62 = G();
        if (r62 == null) goto L128;
        r62.A1();
    L128:
        g1 r63 = C();
        if (r63 == null) goto L131;
        r63.b2(r8);
        goto L131
    L121:
        if (r60.z0() != r112) goto L123;
        r61 = true;
    L131:
        ArrayList r64 = new ArrayList();
        ArrayList r65 = new ArrayList();
        ArrayList r66 = new ArrayList();
        ArrayList r67 = new ArrayList();
        Iterator r68 = r114.iterator();
    L133:
        if (r68.hasNext() == false) goto L141;
        Uri r115 = (Uri) r68.next();
        ImFileUtil.a.getClass();
        if (ImFileUtil.w(r115) == true) goto L136;
        if (ImFileUtil.s(r115) == true) goto L139;
        r64.add(r115);
        r67.add(r115);
        goto L133
    L139:
        r67.add(r115);
        r66.add(r115);
        goto L133
    L136:
        r65.add(r115);
        goto L133
    L141:
        boolean r69 = r64.isEmpty() ^ r112;
        boolean r116 = r65.isEmpty() ^ r112;
        boolean r117 = r66.isEmpty() ^ r112;
        if (r69 == false) goto L146;
        if (r116 == true) goto L146;
        if (r117 == true) goto L146;
        boolean r118 = true;
    L147:
        if (r69 == true) goto L151;
        if (r116 == false) goto L151;
        if (r117 == true) goto L151;
        boolean r119 = true;
    L152:
        if (r69 == true) goto L156;
        if (r116 == true) goto L156;
        if (r117 == false) goto L156;
        boolean r120 = true;
    L157:
        if (r69 == false) goto L159;
        if (r116 == false) goto L159;
    L163:
        boolean r70 = true;
    L165:
        ?? r121 = new o(this, r41, r113, r44);
        ?? r122 = new p(this, r41, r113, r44);
        if (r113 == false) goto L168;
        AttachmentPanelType r71 = AttachmentPanelType.Unknown;
    L173:
        i1 r72 = new i1(r64.size(), r65.size(), r66.size());
        if (r118 == false) goto L196;
        if (r71.isSingleImage() == false) goto L178;
    L188:
        int r73 = 2131907894;
        if (r113 == true) goto L193;
        g1 r74 = C();
        if (r74 == null) goto L193;
        r74.b2(r8);
    L193:
        Integer r211 = r73;
    L194:
        r122.invoke(r67, r72, Boolean.TRUE, "file", r211);
        goto L292
    L178:
        if (r71.isMultiImage() == true) goto L188;
        if (r71.isMultiAudio() == false) goto L187;
        r73 = 2131900063;
        if (r113 == true) goto L193;
        g1 r75 = C();
        if (r75 == null) goto L193;
        r75.b2(r8);
        goto L193
    L187:
        r211 = null;
        goto L194
    L196:
        if (r119 == false) goto L239;
        ICoreInputAbility r76 = E();
        if (r76 != null) goto L200;
    L202:
        boolean r77 = false;
    L203:
        if (r77 == false) goto L223;
        if (r71.isMultiFile() == false) goto L213;
        int r78 = 2131907894;
        if (r113 == true) goto L219;
        g1 r79 = C();
        if (r79 == null) goto L219;
        r79.b2(r8);
    L219:
        Integer r212 = r78;
    L221:
        r122.invoke(r65, r72, Boolean.FALSE, "album", r212);
        goto L292
    L213:
        if (r71.isMultiAudio() == false) goto L220;
        r78 = 2131900063;
        if (r113 == true) goto L219;
        g1 r80 = C();
        if (r80 == null) goto L219;
        r80.b2(r8);
        goto L219
    L220:
        r212 = null;
        goto L221
    L223:
        if (r71.isMultiFile() == false) goto L226;
        Integer r81 = 2131907894;
    L233:
        if (r113 == true) goto L237;
        g1 r82 = C();
        if (r82 == null) goto L237;
        r82.b2(r8);
    L237:
        r121.invoke(ListProtector.get(r65, 0), r81);
        goto L292
    L226:
        if (r71.isMultiAudio() == false) goto L232;
        r81 = 2131900063;
        if (r113 == true) goto L233;
        g1 r83 = C();
        if (r83 == null) goto L233;
        r83.b2(r8);
        goto L233
    L232:
        r81 = null;
        goto L233
    L200:
        if (r76.gj() != r112) goto L202;
        r77 = true;
        goto L203
    L239:
        if (r120 == true) goto L241;
        Integer r123 = null;
    L252:
        if (r70 == false) goto L292;
        ICoreInputAbility r84 = E();
        if (r84 != null) goto L256;
    L258:
        boolean r85 = false;
    L259:
        if (r85 == true) goto L261;
        ICoreInputAbility r86 = E();
        if (r86 != null) goto L268;
    L270:
        boolean r213 = false;
    L271:
        if (r213 == false) goto L281;
        if (r71.isMultiImage() == true) goto L275;
        r122.invoke(r67, r72, Boolean.TRUE, "file", null);
        goto L292
    L275:
        if ((r66.isEmpty() ^ r112) == false) goto L277;
        Integer r214 = 2131900063;
    L278:
        r122.invoke(r65, r72, Boolean.FALSE, "album", r214);
        goto L292
    L277:
        r214 = null;
        goto L278
    L281:
        if (r71.isSingleImage() == false) goto L290;
        int r87 = 2131907894;
        if ((r66.isEmpty() ^ r112) == false) goto L285;
        r87 = 2131900063;
    L285:
        if (r113 == true) goto L289;
        g1 r88 = C();
        if (r88 == null) goto L289;
        r88.b2(r8);
    L289:
        Integer r215 = r87;
    L291:
        r122.invoke(r67, r72, Boolean.TRUE, "file", r215);
        goto L292
    L290:
        r215 = r123;
        goto L291
    L268:
        if (r86.gj() != r112) goto L270;
        r213 = true;
        goto L271
    L261:
        if ((r66.isEmpty() ^ r112) == false) goto L263;
        Integer r216 = 2131900063;
    L264:
        r122.invoke(r114, r72, Boolean.TRUE, "file", r216);
        goto L292
    L263:
        r216 = null;
        goto L264
    L256:
        if (r84.Pi() != r112) goto L258;
        r85 = true;
        goto L259
    L241:
        if (r71.isMultiAudio() == false) goto L243;
    L249:
        r123 = null;
    L250:
        r122.invoke(r66, r72, Boolean.TRUE, "file", r123);
        goto L252
    L243:
        if (r71.isUnknown() == true) goto L249;
        r123 = 2131900063;
        if (r113 == true) goto L250;
        g1 r124 = C();
        if (r124 == null) goto L250;
        r124.b2(r8);
        goto L250
    L168:
        g1 r89 = C();
        if (r89 == null) goto L172;
        r71 = r89.eC();
        if (r71 != null) goto L173;
    L172:
        r71 = AttachmentPanelType.Unknown;
    L159:
        if (r69 == false) goto L161;
        if (r117 == true) goto L163;
    L161:
        if (r116 == false) goto L164;
        if (r117 == true) goto L163;
    L164:
        r70 = false;
    L156:
        r120 = false;
    L151:
        r119 = false;
    L146:
        r118 = false;
        goto L147
    L101:
        r53 = false;
        goto L102
    L97:
        r51 = false;
        goto L98
    L93:
        r49 = false;
        goto L94
    L80:
        r113 = false;
        goto L82
    L76:
        r112 = true;
        goto L77
    L293:
        List<com.larus.bmhome.chat.component.bottom.multimodal.a> r90 = r27.a;
        ArrayList r91 = new ArrayList();
        Iterator<T> r92 = r90.iterator();
    L295:
        if (r92.hasNext() == false) goto L300;
        Uri r93 = ((com.larus.bmhome.chat.component.bottom.multimodal.a) r92.next()).b();
        if (r93 == null) goto L295;
        r91.add(r93);
        goto L295
    L300:
        if (z2.a.optPasteFile() == false) goto L303;
        BuildersKt.launch$default(this.a.d, null, null, new LegacyMultimodalDataProcessor$process$3(this, r91, r27, null), 3, null);
        goto L392
    L303:
        if (A(r91) == false) goto L305;
        return true;
    L305:
        J(r91, !r27.b.a);
        Unit r94 = Unit.INSTANCE;
        goto L392
    L306:
        List<com.larus.bmhome.chat.component.bottom.multimodal.a> r95 = r27.a;
        ArrayList r96 = new ArrayList();
        Iterator<T> r97 = r95.iterator();
    L308:
        if (r97.hasNext() == false) goto L312;
        Uri r99 = ((com.larus.bmhome.chat.component.bottom.multimodal.a) r97.next()).b();
        if (r99 == null) goto L308;
        r96.add(r99);
        goto L308
    L312:
        String r100 = com.larus.bmhome.chat.component.bottom.multimodal.o.b(r27);
        Integer r101 = com.larus.bmhome.chat.component.bottom.multimodal.o.a(r27);
        com.larus.bmhome.chat.component.bottom.multimodal.m r102 = r27.e;
        if (r102 == null) goto L316;
        DirectSendData r103 = r102.c;
        if (r103 == null) goto L316;
    L317:
        DirectSendData r104 = r103;
        Map<String, String> r105 = r27.d;
        com.larus.bmhome.chat.component.bottom.multimodal.m r106 = r27.e;
        if (r106 == null) goto L322;
        com.larus.bmhome.chat.component.bottom.multimodal.i r107 = r106.d;
        if (r107 == null) goto L322;
        List<Boolean> r108 = r107.a;
    L323:
        if (r106 == null) goto L327;
        com.larus.bmhome.chat.component.bottom.multimodal.i r109 = r106.d;
        if (r109 == null) goto L327;
        List<Boolean> r125 = r109.b;
    L329:
        if (r106 == null) goto L331;
        String r217 = r106.g;
    L332:
        I(this, r96, true, r100, r101, r104, r105, r108, r125, null, null, false, null, false, r217, false, null, r24, 57088);
        Unit r126 = Unit.INSTANCE;
        goto L392
    L331:
        r217 = null;
    L327:
        r125 = null;
    L322:
        r108 = null;
    L316:
        r103 = com.larus.bmhome.chat.component.bottom.multimodal.o.c(r27);
        goto L317
    L333:
        com.larus.bmhome.chat.component.bottom.multimodal.g1 r127 = r27.b;
        if (r127.a == false) goto L336;
    L350:
        List<com.larus.bmhome.chat.component.bottom.multimodal.a> r128 = r27.a;
        ArrayList r129 = new ArrayList();
        Iterator<T> r130 = r128.iterator();
    L352:
        if (r130.hasNext() == false) goto L356;
        Uri r131 = ((com.larus.bmhome.chat.component.bottom.multimodal.a) r130.next()).b();
        if (r131 == null) goto L352;
        r129.add(r131);
        goto L352
    L356:
        String r132 = com.larus.bmhome.chat.component.bottom.multimodal.o.b(r27);
        Integer r133 = com.larus.bmhome.chat.component.bottom.multimodal.o.a(r27);
        com.larus.bmhome.chat.component.bottom.multimodal.m r134 = r27.e;
        if (r134 == null) goto L360;
        DirectSendData r135 = r134.c;
        if (r135 == null) goto L360;
    L361:
        DirectSendData r136 = r135;
        Map<String, String> r137 = r27.d;
        com.larus.bmhome.chat.component.bottom.multimodal.m r138 = r27.e;
        if (r138 == null) goto L366;
        com.larus.bmhome.chat.component.bottom.multimodal.i r139 = r138.d;
        if (r139 == null) goto L366;
        List<Boolean> r140 = r139.a;
    L367:
        if (r138 == null) goto L371;
        com.larus.bmhome.chat.component.bottom.multimodal.i r141 = r138.d;
        if (r141 == null) goto L371;
        List<Boolean> r142 = r141.b;
    L372:
        if (r138 == null) goto L376;
        com.larus.bmhome.chat.component.bottom.multimodal.i r143 = r138.d;
        if (r143 == null) goto L376;
        List<Boolean> r144 = r143.c;
    L377:
        ArrayList r145 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r129, 10));
        Iterator r146 = r129.iterator();
    L379:
        if (r146.hasNext() == false) goto L381;
        Uri r147 = (Uri) r146.next();
        r145.add("upload");
        goto L379
    L381:
        com.larus.bmhome.chat.component.bottom.multimodal.m r148 = r27.e;
        if (r148 == null) goto L387;
        if (r148.f != true) goto L387;
        boolean r218 = true;
    L388:
        if (r148 == null) goto L390;
        String r149 = r148.g;
    L391:
        I(this, r129, false, r132, r133, r136, r137, r140, r142, r144, r145, false, null, r218, r149, false, null, r24, 52224);
        Unit r150 = Unit.INSTANCE;
        goto L392
    L390:
        r149 = null;
    L387:
        r218 = false;
    L376:
        r144 = null;
    L371:
        r142 = null;
    L366:
        r140 = null;
    L360:
        r135 = com.larus.bmhome.chat.component.bottom.multimodal.o.c(r27);
        goto L361
    L336:
        if (r127.c == false) goto L350;
        com.larus.bmhome.chat.component.bottom.multimodal.a r151 = (com.larus.bmhome.chat.component.bottom.multimodal.a) CollectionsKt.firstOrNull(r27.a);
        if (r151 == null) goto L392;
        Uri r152 = r151.b();
        if (r152 == null) goto L392;
        String r153 = com.larus.bmhome.chat.component.bottom.multimodal.o.b(r27);
        Map<String, String> r154 = r27.d;
        r1.i("LegacyMultimodalDataProcessor", "[directSendImageAfterSinglePick] fromScene:" + r153 + ", ext:" + r154);
        z();
        wc9.e r155 = D();
        if (r155 == null) goto L348;
        MultimodalInputComponentViewModel r156 = this.a.e;
        BotModel r157 = B();
        if (r157 == null) goto L346;
        String r158 = r157.getBotId();
    L347:
        r156.onPickImageSuccess(r155, r152, r158, r153, this.o, r154, (ChatPageContext) this.a.c.a(ChatPageContext.class), r24);
        goto L348
    L346:
        r158 = null;
    L348:
        Unit r159 = Unit.INSTANCE;
        goto L392
    L393:
        com.larus.bmhome.chat.component.bottom.multimodal.g1 r160 = r27.b;
        if (r160.a == false) goto L396;
    L443:
        List<com.larus.bmhome.chat.component.bottom.multimodal.a> r161 = r27.a;
        ArrayList r162 = new ArrayList();
        Iterator<T> r163 = r161.iterator();
    L445:
        if (r163.hasNext() == false) goto L449;
        Uri r164 = ((com.larus.bmhome.chat.component.bottom.multimodal.a) r163.next()).b();
        if (r164 == null) goto L445;
        r162.add(r164);
        goto L445
    L449:
        String r165 = com.larus.bmhome.chat.component.bottom.multimodal.o.b(r27);
        Integer r166 = com.larus.bmhome.chat.component.bottom.multimodal.o.a(r27);
        com.larus.bmhome.chat.component.bottom.multimodal.m r167 = r27.e;
        if (r167 == null) goto L453;
        DirectSendData r168 = r167.c;
        if (r168 == null) goto L453;
    L454:
        DirectSendData r169 = r168;
        Map<String, String> r170 = r27.d;
        com.larus.bmhome.chat.component.bottom.multimodal.m r171 = r27.e;
        if (r171 == null) goto L459;
        com.larus.bmhome.chat.component.bottom.multimodal.i r172 = r171.d;
        if (r172 == null) goto L459;
        List<Boolean> r173 = r172.a;
    L460:
        if (r171 == null) goto L464;
        com.larus.bmhome.chat.component.bottom.multimodal.i r174 = r171.d;
        if (r174 == null) goto L464;
        List<Boolean> r175 = r174.b;
    L465:
        if (r171 == null) goto L469;
        com.larus.bmhome.chat.component.bottom.multimodal.i r176 = r171.d;
        if (r176 == null) goto L469;
        List<Boolean> r177 = r176.c;
    L470:
        if (r171 == null) goto L472;
        List<String> r178 = r171.e;
    L474:
        if (r171 == null) goto L479;
        if (r171.f != true) goto L479;
        boolean r219 = true;
    L480:
        boolean r220 = true;
        I(this, r162, false, r165, r166, r169, r170, r173, r175, r177, r178, false, null, r219, null, false, null, r24, 60416);
    L481:
        Unit r179 = Unit.INSTANCE;
        return r220;
    L479:
        r219 = false;
        goto L480
    L472:
        r178 = null;
    L469:
        r177 = null;
    L464:
        r175 = null;
    L459:
        r173 = null;
    L453:
        r168 = com.larus.bmhome.chat.component.bottom.multimodal.o.c(r27);
        goto L454
    L396:
        if (r160.c == false) goto L443;
        com.larus.bmhome.chat.component.bottom.multimodal.m r180 = r27.e;
        if (r180 == null) goto L400;
        SuggestedAction r221 = r180.a;
    L401:
        h1 r181 = r27.c;
        if (r181 == null) goto L406;
        Map<String, String> r182 = r181.c;
        if (r182 == null) goto L406;
        String r183 = r182.get("scene");
    L408:
        if (Intrinsics.areEqual(r183, "keyboard") == false) goto L411;
        int r184 = 1;
    L414:
        h1 r185 = r27.c;
        if (r185 == null) goto L417;
        String r186 = r185.a;
    L418:
        if (r186 != null) goto L420;
        r186 = "";
    L420:
        Pair<String, Integer> r187 = new Pair(r186, Integer.valueOf(r184));
        r1.i("LegacyMultimodalDataProcessor", "[directSendImageAfterCamera] data");
        z();
        wc9.e r188 = D();
        if (r188 == null) goto L442;
        MultimodalInputComponentViewModel r189 = this.a.e;
        com.larus.bmhome.chat.component.bottom.multimodal.a r190 = (com.larus.bmhome.chat.component.bottom.multimodal.a) CollectionsKt.firstOrNull(r27.a);
        if (r190 == null) goto L425;
        String r191 = r190.a();
    L426:
        if (r191 != null) goto L428;
        String r192 = "";
    L429:
        BotModel r193 = B();
        if (r193 == null) goto L432;
        String r194 = r193.getBotId();
    L433:
        com.larus.bmhome.chat.component.bottom.multimodal.processor.b r195 = this.o;
        h1 r196 = r27.c;
        if (r196 == null) goto L436;
        Map<String, String> r197 = r196.b;
    L437:
        com.larus.bmhome.chat.component.bottom.reference.a r198 = (com.larus.bmhome.chat.component.bottom.reference.a) this.m.getValue();
        if (r198 == null) goto L440;
        ReferenceInfo r222 = r198.T6();
    L441:
        r189.onTakePictureSuccess(r188, r192, r194, r195, r197, r221, r187, r222, (ChatPageContext) this.a.c.a(ChatPageContext.class), r24);
        goto L442
    L440:
        r222 = null;
        goto L441
    L436:
        r197 = null;
        goto L437
    L432:
        r194 = null;
        goto L433
    L428:
        r192 = r191;
        goto L429
    L425:
        r191 = null;
    L442:
        r220 = true;
        goto L481
    L417:
        r186 = null;
        goto L418
    L411:
        if (Intrinsics.areEqual(r183, "speak") == false) goto L413;
        r184 = 2;
        goto L414
    L413:
        r184 = 0;
    L406:
        r183 = null;
        goto L408
    L400:
        r221 = null;
        goto L401
    L482:
        List<com.larus.bmhome.chat.component.bottom.multimodal.a> r199 = r27.a;
        ArrayList r200 = new ArrayList();
        Iterator<T> r201 = r199.iterator();
    L484:
        if (r201.hasNext() == false) goto L488;
        Uri r202 = ((com.larus.bmhome.chat.component.bottom.multimodal.a) r201.next()).b();
        if (r202 == null) goto L484;
        r200.add(r202);
        goto L484
    L488:
        String r203 = com.larus.bmhome.chat.component.bottom.multimodal.o.b(r27);
        Integer r204 = com.larus.bmhome.chat.component.bottom.multimodal.o.a(r27);
        com.larus.bmhome.chat.component.bottom.multimodal.m r205 = r27.e;
        if (r205 == null) goto L492;
        DirectSendData r206 = r205.c;
        if (r206 == null) goto L492;
    L493:
        DirectSendData r207 = r206;
        Map<String, String> r208 = r27.d;
        com.larus.bmhome.chat.component.bottom.multimodal.m r209 = r27.e;
        if (r209 == null) goto L498;
        com.larus.bmhome.chat.component.bottom.multimodal.i r223 = r209.d;
        if (r223 == null) goto L498;
        List<Boolean> r1100 = r223.a;
    L499:
        if (r209 == null) goto L503;
        com.larus.bmhome.chat.component.bottom.multimodal.i r224 = r209.d;
        if (r224 == null) goto L503;
        List<Boolean> r225 = r224.b;
    L504:
        I(this, r200, false, r203, r204, r207, r208, r1100, r225, null, null, false, null, false, null, false, null, null, 130816);
        Unit r226 = Unit.INSTANCE;
        return true;
    L503:
        r225 = null;
    L498:
        r1100 = null;
    L492:
        r206 = com.larus.bmhome.chat.component.bottom.multimodal.o.c(r27);
        goto L493
    L5:
        if (r6 == 17) goto L11;
        if (r6 == 25) goto L11;
        switch(r6) {
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L11;
            case 4: goto L11;
            case 5: goto L11;
            case 6: goto L11;
            default: goto L9;
        };
    L9:
        switch(r6) {
            case 11: goto L11;
            case 12: goto L11;
            case 13: goto L11;
            default: goto L10;
        };
    L10:
        r7 = false;
        goto L12
    }

    public static final FlowDriveFileType u(LegacyMultimodalDataProcessor r6, m0 r7) {
        ICoreInputAbility r0 = r6.E();
        boolean r1 = true;
        boolean r2 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r3 = false;
    L9:
        if (r3 == true) goto L82;
        FlowDriveFileType r8 = r7.k;
        if (r8 == null) goto L83;
        g1 r4 = r6.C();
        if (r4 == null) goto L21;
        List<UplinkFileEntity> r5 = r4.q1();
        if (r5 == null) goto L21;
        if (r5.isEmpty() == true) goto L21;
        boolean r9 = true;
    L22:
        if (r9 == false) goto L84;
        g1 r10 = r6.C();
        if (r10 == null) goto L27;
        AttachmentPanelType r11 = r10.eC();
    L28:
        boolean r12 = r8.isMediaType();
        if (r11 != null) goto L52;
        g1 r13 = r6.C();
        if (r13 == null) goto L45;
        List<UplinkFileEntity> r14 = r13.q1();
        if (r14 == null) goto L45;
        Iterator<T> r15 = r14.iterator();
        boolean r16 = false;
    L36:
        if (r15.hasNext() == false) goto L44;
        UplinkFileEntity r17 = (UplinkFileEntity) r15.next();
        if (n1.d(r17) == true) goto L43;
        if (n1.e(r17) == true) goto L43;
        r16 = true;
    L43:
        r2 = true;
        goto L36
    L44:
        boolean r18 = r2;
        r2 = r16;
    L46:
        if (r12 == false) goto L48;
        if (r2 == false) goto L48;
    L79:
        return FlowDriveFileType.IMAGE;
    L48:
        if (r12 == true) goto L77;
        if (r18 == true) goto L79;
        return null;
    L77:
        return null;
    L45:
        r18 = false;
        goto L46
    L52:
        if (r11 != AttachmentPanelType.MultiImage) goto L54;
    L57:
        boolean r19 = true;
    L59:
        if (r11 != AttachmentPanelType.MultiFile) goto L61;
    L64:
        if (r12 == false) goto L66;
        if (r1 == false) goto L66;
    L69:
        return FlowDriveFileType.IMAGE;
    L66:
        if (r12 == true) goto L80;
        if (r19 == true) goto L69;
        return null;
    L80:
        return null;
    L61:
        if (r11 == AttachmentPanelType.MultiAudio) goto L64;
        r1 = false;
        goto L64
    L54:
        if (r11 == AttachmentPanelType.SingleImage) goto L57;
        r19 = false;
        goto L59
    L27:
        r11 = null;
        goto L28
    L84:
        return null;
    L21:
        r9 = false;
        goto L22
    L83:
        return null;
    L82:
        return null;
    L5:
        if (r0.Pi() != true) goto L7;
        r3 = true;
        goto L9
    }

    public static final /* synthetic */ void w(LegacyMultimodalDataProcessor r0, String r1) {
        r0.p = r1;
    }

    public final void J(List<? extends Uri> r38, boolean r39) {
        if (r38.isEmpty() == false) goto L6;
        FLogger.a.e("LegacyMultimodalDataProcessor", "[onPasteUris] uriList is empty");
        return;
    L6:
        FLogger.a.i("LegacyMultimodalDataProcessor", "[onPasteUris] " + r38);
        com.larus.bmhome.instruction.g r2 = G();
        if (r2 != null) goto L9;
    L11:
        boolean r3 = false;
    L12:
        g1 r4 = C();
        if (r4 != null) goto L15;
    L17:
        boolean r5 = false;
    L18:
        if (r5 == true) goto L26;
        ICoreInputAbility r6 = E();
        if (r6 != null) goto L22;
    L24:
        boolean r7 = false;
    L25:
        if (r7 == true) goto L26;
    L27:
        boolean r19 = true;
    L30:
        if (r3 == false) goto L104;
        com.larus.bmhome.instruction.g r8 = G();
        if (r8 != null) goto L34;
    L36:
        boolean r9 = false;
    L37:
        if (r9 == false) goto L45;
        va8.o r10 = (va8.o) this.j.getValue();
        if (r10 == null) goto L41;
        r10.ra();
    L41:
        va8.o r11 = (va8.o) this.j.getValue();
        if (r11 == null) goto L44;
        r11.E40();
    L44:
        String r20 = "";
        I(this, r38, false, "paste", null, null, null, null, null, null, null, false, null, false, null, false, null, null, 131064);
        String r21 = null;
    L165:
        boolean r14 = r19;
    L166:
        va8.o r1 = (va8.o) this.j.getValue();
        if (r1 == null) goto L171;
        boolean r12 = true;
        if (r1.w() != true) goto L172;
        boolean r15 = true;
    L173:
        if (r15 == false) goto L178;
        if (r14 == false) goto L178;
        ICoreInputAbility r13 = E();
        if (r13 == null) goto L178;
        int r16 = 0;
        r13.qp(false);
    L179:
        LruCache r17 = ko8.a.a;
        BotModel r18 = B();
        if (r18 == null) goto L182;
        String r22 = r18.getBotId();
    L183:
        Integer r23 = Integer.valueOf(r16);
        Integer r24 = Integer.valueOf(r38.size());
        ICoreInputAbility r25 = E();
        if (r25 != null) goto L186;
    L188:
        boolean r110 = false;
    L189:
        if (r110 == true) goto L199;
        ICoreInputAbility r26 = E();
        if (r26 != null) goto L193;
    L195:
        boolean r111 = false;
    L196:
        if (r111 == true) goto L199;
        int r112 = 0;
    L200:
        Integer r27 = Integer.valueOf(r112);
        wc9.e r28 = D();
        if (r28 == null) goto L203;
        String r29 = ic8.n.f(r28);
    L204:
        y r30 = (y) this.d.getValue();
        if (r30 == null) goto L207;
        String r113 = r30.Y1();
    L208:
        String r31 = this.a.a;
        if ((r31 instanceof by7.e) == false) goto L211;
        String r114 = (by7.e) r31;
    L212:
        IAIChatControlTraceService.Companion r32 = IAIChatControlTraceService.a;
        r32.Ub(r22, r23, r24, r27, r29, r113, r114);
        Intrinsics.checkNotNullParameter("paste", "originalSource");
        String r33 = r20;
        Intrinsics.checkNotNullParameter(r33, "messageId");
        r32.Ab("paste", r33);
        return;
    L211:
        r114 = r21;
        goto L212
    L207:
        r113 = r21;
        goto L208
    L203:
        r29 = r21;
        goto L204
    L193:
        if (r26.Pi() != r12) goto L195;
        r111 = true;
    L199:
        r112 = 1;
        goto L200
    L186:
        if (r25.gj() != r12) goto L188;
        r110 = true;
        goto L189
    L182:
        r22 = r21;
    L178:
        r16 = 0;
    L172:
        r15 = false;
        goto L173
    L171:
        r12 = true;
        goto L172
    L45:
        r20 = "";
        com.larus.bmhome.instruction.g r0 = G();
        if (r0 == null) goto L48;
        Map r210 = r0.nK(null);
    L49:
        com.larus.bmhome.instruction.g r34 = G();
        if (r34 == null) goto L52;
        r34.cO();
    L52:
        Uri r35 = (Uri) CollectionsKt.first(r38);
        VLMUploadDowngradeData r36 = com.larus.bmhome.chat.component.bottom.multimodal.p.b();
        z2 r37 = z2.a;
        oq9.b r40 = r37.getAppImageUploadConfig();
        if (r36 == null) goto L64;
        Integer r115 = r36.getVlmResolution();
        if (r115 == null) goto L64;
        if (r115.intValue() <= 0) goto L59;
        boolean r116 = true;
    L60:
        if (r116 == true) goto L63;
        r115 = null;
    L63:
        if (r115 == null) goto L64;
    L65:
        Integer r310 = r115;
        if (r36 == null) goto L79;
        Integer r117 = r36.getVlmQuality();
        if (r117 == null) goto L79;
        if (r117.intValue() <= 0) goto L72;
        boolean r118 = true;
    L73:
        if (r118 == true) goto L76;
        r117 = null;
    L76:
        if (r117 == null) goto L79;
        Integer r311 = r117;
    L80:
        n0 r41 = b$a.b(SendResourcePreprocessManager.a, r35, false, new ns8.a(r310, null, r311, null, r37.d2(), 232), null, null, 56);
        ProcessFileResultCode r42 = r41.b;
        if (r42 == null) goto L86;
        if (r42.isSuccess() != true) goto L86;
        boolean r119 = true;
    L87:
        if (r119 == false) goto L103;
        z();
        wc9.e r211 = D();
        if (r211 == null) goto L102;
        MultimodalInputComponentViewModel r43 = this.a.e;
        m0 r44 = r41.a;
        if (r44 == null) goto L93;
        String r120 = r44.e;
    L94:
        if (r120 != null) goto L96;
        String r212 = r20;
    L97:
        BotModel r45 = B();
        if (r45 == null) goto L100;
        String r213 = r45.getBotId();
    L101:
        MultimodalInputComponentViewModel.onTakePictureSuccess$default(r43, r211, r212, r213, this.o, r210, null, null, null, (ChatPageContext) this.a.c.a(ChatPageContext.class), null, 736, null);
        goto L102
    L100:
        r213 = null;
        goto L101
    L96:
        r212 = r120;
        goto L97
    L93:
        r120 = null;
    L102:
        r21 = null;
        r14 = true;
        goto L166
    L103:
        r21 = null;
    L86:
        r119 = false;
        goto L87
    L72:
        r118 = false;
    L79:
        r311 = r40.c();
        goto L80
    L59:
        r116 = false;
    L64:
        r115 = r40.b();
        goto L65
    L48:
        r210 = null;
        goto L49
    L34:
        if (r8.Wa() != true) goto L36;
        r9 = true;
        goto L37
    L104:
        r20 = "";
        List<? extends Uri> r46 = r38;
        if ((r46 instanceof Collection) == true) goto L107;
    L109:
        Iterator<T> r47 = r46.iterator();
    L111:
        if (r47.hasNext() == false) goto L120;
        Uri r48 = (Uri) r47.next();
        ImFileUtil.a.getClass();
        if (ImFileUtil.w(r48) == false) goto L115;
    L117:
        boolean r121 = false;
    L118:
        if (r121 == true) goto L111;
        boolean r214 = false;
    L121:
        g1 r49 = C();
        if (r49 == null) goto L124;
        AttachmentPanelType r122 = r49.eC();
    L126:
        if (r122 == AttachmentPanelType.MultiFile) goto L133;
        g1 r50 = C();
        if (r50 == null) goto L130;
        AttachmentPanelType r123 = r50.eC();
    L132:
        if (r123 == AttachmentPanelType.MultiAudio) goto L133;
    L141:
        if (r19 == false) goto L143;
        DirectSendData r215 = new DirectSendData(null, null, null, null, null, null, false, 127, null);
    L144:
        ICoreInputAbility r51 = E();
        if (r51 != null) goto L147;
    L149:
        boolean r124 = false;
    L150:
        if (r124 == false) goto L161;
        ArrayList r52 = new ArrayList();
        Iterator<T> r53 = r46.iterator();
    L153:
        if (r53.hasNext() == false) goto L158;
        Object r54 = r53.next();
        ImFileUtil.a.getClass();
        if (ImFileUtil.w((Uri) r54) == false) goto L153;
        r52.add(r54);
        goto L153
    L158:
        if ((!r52.isEmpty()) == false) goto L163;
        List r216 = r52;
    L164:
        boolean r55 = r214;
        r21 = null;
        I(this, r216, r55, "paste", null, r215, null, null, null, null, null, false, null, false, null, false, null, null, 131048);
    L163:
        r216 = r38;
        goto L164
    L161:
        if (r38.size() <= 1) goto L163;
        t19.s r56 = t19.s.a;
        Context r57 = getContext();
        r56.getClass();
        t19.s.s(r57, 2131907898);
        r216 = r38.subList(0, 1);
        goto L164
    L147:
        if (r51.gj() != true) goto L149;
        r124 = true;
        goto L150
    L143:
        r215 = null;
        goto L144
    L130:
        r123 = null;
    L133:
        g1 r58 = C();
        if (r58 == null) goto L141;
        g1 r59 = C();
        if (r59 == null) goto L139;
        String r125 = r59.uM();
        if (r125 == null) goto L139;
    L140:
        r58.b2(r125);
    L139:
        r125 = r20;
        goto L140
    L124:
        r122 = null;
        goto L126
    L115:
        if (ImFileUtil.y(r48) == true) goto L117;
        r121 = true;
    L120:
        r214 = true;
        goto L121
    L107:
        if (r46.isEmpty() == false) goto L109;
    L22:
        if (r6.gj() != true) goto L24;
        r7 = true;
    L26:
        if (r39 == true) goto L27;
        r19 = false;
        goto L30
    L15:
        if (r4.mT() != true) goto L17;
        r5 = true;
        goto L18
    L9:
        if (r2.HM() != true) goto L11;
        r3 = true;
        goto L12
    }

    public static final int j(LegacyMultimodalDataProcessor r3, boolean r4, boolean r5) {
        ICoreInputAbility r0 = r3.E();
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L10;
        ImFileUtil.a.getClass();
        return ImFileUtil.o();
    L10:
        if (r4 == true) goto L21;
        if (r5 == true) goto L21;
        com.larus.bmhome.chat.component.bottom.multimodal.g r6 = (com.larus.bmhome.chat.component.bottom.multimodal.g) r3.n.getValue();
        if (r6 != null) goto L16;
    L18:
        if (r1 == false) goto L20;
        ImFileUtil.a.getClass();
        return ImFileUtil.m();
    L20:
        ImFileUtil.a.getClass();
        return ImFileUtil.n();
    L16:
        if (r6.nA(null) != true) goto L18;
        r1 = true;
    L21:
        ImFileUtil.a.getClass();
        return ImFileUtil.l();
    L5:
        if (r0.Pi() != true) goto L7;
        r2 = true;
        goto L8
    }

    public static final int k(LegacyMultimodalDataProcessor r0, boolean r1, boolean r2) {
        r0.getClass();
        if (r1 == true) goto L9;
        if (r2 == false) goto L8;
        return FileType.FileTypeVideo.getValue();
    L8:
        return FileType.FileTypeFile.getValue();
    L9:
        return FileType.FileTypeAudio.getValue();
    }

    public static final String r(LegacyMultimodalDataProcessor r1, String r2, DirectSendData r3) {
        if (r3 == null) goto L7;
        r1.getClass();
        String r4 = r3.getEnterMethod();
        if (r4 == null) goto L7;
        return r4;
    L7:
        if (Intrinsics.areEqual(r1.p, "chat_action_bar") == false) goto L10;
        return "chat_action_bar";
    L10:
        if (Intrinsics.areEqual(r2, "shoot") == false) goto L12;
    L13:
        String r5 = r1.p;
        if (Intrinsics.areEqual(r5, "input_left_icon") == false) goto L17;
        String r6 = "camera_input_left_icon";
    L21:
        return r6;
    L17:
        if (Intrinsics.areEqual(r5, "plus_panel") == false) goto L19;
        r6 = "camera_plus_panel";
    L19:
        r6 = "";
        goto L21
    L12:
        if (Intrinsics.areEqual(r2, "shoot_ocr") == false) goto L19;
        goto L13
    }

    public static final void t(LegacyMultimodalDataProcessor r3, List r4, boolean r5) {
        r3.getClass();
        t19.s r0 = t19.s.a;
        Context r1 = r3.getContext();
        r0.getClass();
        t19.s.b(r1, 2131907891, false);
        BotModel r2 = r3.B();
        Integer r6 = null;
        if (r2 == null) goto L5;
        String r7 = r2.getBotId();
    L6:
        g1 r8 = r3.C();
        if (r8 == null) goto L9;
        r6 = Integer.valueOf(g1.a.b(r8));
    L9:
        y3.b(r7, "insufficient storage", r6);
        if (r5 == false) goto L15;
        g1 r9 = r3.C();
        if (r9 == null) goto L16;
        g1.a.a(r9, r4, 6);
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r7 = null;
        goto L6
    }

    public static final boolean v(LegacyMultimodalDataProcessor r5, List r6, String r7, List r8, boolean r9, boolean r10) {
        if (r10 == false) goto L5;
        r5.getClass();
        AttachmentPanelType r1 = AttachmentPanelType.Unknown;
    L9:
        FLogger.a.i("LegacyMultimodalDataProcessor", "isHitMultipleAudioType: " + r1 + ", " + r7);
        boolean r2 = true;
        if (r1 != AttachmentPanelType.MultiAudio) goto L48;
        if (r9 == false) goto L125;
        ICoreInputAbility r11 = r5.E();
        if (r11 != null) goto L15;
    L17:
        boolean r12 = false;
    L18:
        if (r12 == false) goto L125;
        if (r8 != null) goto L21;
    L45:
        boolean r13 = H(r6);
    L46:
        if (r13 == true) goto L125;
    L104:
        r2 = false;
        goto L125
    L21:
        if (r8.size() != r6.size()) goto L23;
        boolean r14 = true;
    L24:
        if (r14 == true) goto L27;
        r8 = null;
    L27:
        if (r8 == null) goto L45;
        List r15 = r8;
        if ((r15 instanceof Collection) == true) goto L31;
    L33:
        Iterator r16 = r15.iterator();
    L35:
        if (r16.hasNext() == false) goto L44;
        com.larus.bmhome.chat.component.bottom.multimodal.a r17 = (com.larus.bmhome.chat.component.bottom.multimodal.a) r16.next();
        if ((r17 instanceof com.larus.bmhome.chat.component.bottom.multimodal.a.b) == true) goto L39;
    L41:
        boolean r18 = false;
    L42:
        if (r18 == true) goto L35;
        r13 = false;
        goto L46
    L39:
        if (((com.larus.bmhome.chat.component.bottom.multimodal.a.b) r17).h != FlowDriveFileType.AUDIO) goto L41;
        r18 = true;
    L44:
        r13 = true;
        goto L46
    L31:
        if (r15.isEmpty() == false) goto L33;
    L23:
        r14 = false;
        goto L24
    L15:
        if (r11.CD(false) != true) goto L17;
        r12 = true;
    L125:
        return r2;
    L48:
        ICoreInputAbility r19 = r5.E();
        if (r19 != null) goto L51;
    L53:
        boolean r20 = false;
    L54:
        if (r20 == true) goto L126;
        if (r1 != null) goto L58;
    L59:
        if (r10 == true) goto L64;
        g1 r21 = r5.C();
        if (r21 == null) goto L64;
        int r22 = g1.a.b(r21);
    L65:
        if (r22 != 0) goto L124;
        if (r9 == false) goto L107;
        if (r8 == null) goto L87;
        List r23 = r8;
        if ((r23 instanceof Collection) == true) goto L71;
    L73:
        Iterator r24 = r23.iterator();
    L75:
        if (r24.hasNext() == false) goto L84;
        com.larus.bmhome.chat.component.bottom.multimodal.a r25 = (com.larus.bmhome.chat.component.bottom.multimodal.a) r24.next();
        if ((r25 instanceof com.larus.bmhome.chat.component.bottom.multimodal.a.b) == true) goto L79;
    L81:
        boolean r26 = false;
    L82:
        if (r26 == false) goto L75;
        boolean r27 = true;
    L85:
        if (r27 != true) goto L87;
        boolean r28 = true;
    L88:
        if (r28 == false) goto L107;
        List r29 = r8;
        if ((r29 instanceof Collection) == true) goto L92;
    L94:
        Iterator r30 = r29.iterator();
    L96:
        if (r30.hasNext() == false) goto L125;
        com.larus.bmhome.chat.component.bottom.multimodal.a r31 = (com.larus.bmhome.chat.component.bottom.multimodal.a) r30.next();
        if ((r31 instanceof com.larus.bmhome.chat.component.bottom.multimodal.a.b) == true) goto L100;
    L102:
        boolean r32 = false;
    L103:
        if (r32 == true) goto L96;
    L100:
        if (((com.larus.bmhome.chat.component.bottom.multimodal.a.b) r31).h != FlowDriveFileType.AUDIO) goto L102;
        r32 = true;
        goto L103
    L92:
        if (r29.isEmpty() == false) goto L94;
    L79:
        if (((com.larus.bmhome.chat.component.bottom.multimodal.a.b) r25).h != FlowDriveFileType.AUDIO) goto L81;
        r26 = true;
    L84:
        r27 = false;
        goto L85
    L71:
        if (r23.isEmpty() == false) goto L73;
    L87:
        r28 = false;
    L107:
        return H(r6);
    L124:
        return false;
    L64:
        r22 = 0;
        goto L65
    L58:
        if (r1 == AttachmentPanelType.Unknown) goto L59;
        return false;
    L126:
        return false;
    L51:
        if (r19.wy() == true) goto L53;
        r20 = true;
        goto L54
    L5:
        g1 r3 = r5.C();
        if (r3 == null) goto L8;
        r1 = r3.eC();
        goto L9
    L8:
        r1 = null;
        goto L9
    }

    public static final boolean y(LegacyMultimodalDataProcessor r8, String r9, boolean r10, Integer r11, DirectSendData r12, boolean r13) {
        r8.getClass();
        FLogger.a.i("LegacyMultimodalDataProcessor", "[skipAttachment] scene:" + r9 + ", allImage:" + r10 + ", cameraType:" + r11 + ", directSendData:" + r12);
        boolean r0 = true;
        if (r12 == null) goto L6;
        return true;
    L6:
        if (r13 == false) goto L8;
    L10:
        if (r13 == true) goto L19;
        g1 r14 = r8.C();
        if (r14 != null) goto L14;
    L16:
        boolean r15 = false;
    L17:
        if (r15 == false) goto L19;
    L121:
        return false;
    L14:
        if (r14.isVisible() != true) goto L16;
        r15 = true;
    L19:
        String r3 = null;
        if (FeatureKitDelegate.b.k0().b() == true) goto L44;
        BotModel r16 = r8.B();
        if (r16 == null) goto L40;
        List r17 = r16.getBotConf();
        if (r17 == null) goto L40;
        Iterator r18 = r17.iterator();
    L27:
        if (r18.hasNext() == false) goto L36;
        Object r4 = r18.next();
        BotConfItem r5 = (BotConfItem) r4;
        if (Intrinsics.areEqual(r5.getConfGroupKey(), "disable_function") == true) goto L31;
    L33:
        boolean r6 = false;
    L34:
        if (r6 == false) goto L27;
    L37:
        BotConfItem r7 = (BotConfItem) r4;
        if (r7 == null) goto L40;
        String r19 = r7.getConfValue();
    L42:
        if (Intrinsics.areEqual(r19, "1") == false) goto L44;
        boolean r110 = true;
    L46:
        if (FeatureKitDelegate.b.u0().b() == true) goto L70;
        BotModel r20 = r8.B();
        if (r20 == null) goto L66;
        List r21 = r20.getBotConf();
        if (r21 == null) goto L66;
        Iterator r22 = r21.iterator();
    L53:
        if (r22.hasNext() == false) goto L62;
        Object r23 = r22.next();
        BotConfItem r24 = (BotConfItem) r23;
        if (Intrinsics.areEqual(r24.getConfGroupKey(), "disable_function") == true) goto L57;
    L59:
        boolean r25 = false;
    L60:
        if (r25 == false) goto L53;
    L63:
        BotConfItem r26 = (BotConfItem) r23;
        if (r26 == null) goto L66;
        String r27 = r26.getConfValue();
    L68:
        if (Intrinsics.areEqual(r27, "1") == false) goto L70;
        boolean r28 = true;
    L72:
        if (FeatureKitDelegate.b.p0().b() == true) goto L95;
        BotModel r29 = r8.B();
        if (r29 == null) goto L93;
        List r30 = r29.getBotConf();
        if (r30 == null) goto L93;
        Iterator r31 = r30.iterator();
    L79:
        if (r31.hasNext() == false) goto L88;
        Object r32 = r31.next();
        BotConfItem r33 = (BotConfItem) r32;
        if (Intrinsics.areEqual(r33.getConfGroupKey(), "disable_function") == true) goto L83;
    L85:
        boolean r34 = false;
    L86:
        if (r34 == false) goto L79;
    L89:
        BotConfItem r35 = (BotConfItem) r32;
        if (r35 == null) goto L93;
        r3 = r35.getConfValue();
        goto L93
    L83:
        if (Intrinsics.areEqual(r33.getConfKey(), "apply_attachment_skip_optional") == false) goto L85;
        r34 = true;
        goto L86
    L88:
        r32 = null;
    L93:
        if (Intrinsics.areEqual(r3, "1") == false) goto L95;
    L97:
        switch(r9.hashCode()) {
            case -2113586946: goto L118;
            case 3143036: goto L115;
            case 92896879: goto L111;
            case 106438291: goto L106;
            case 109413407: goto L103;
            case 249793358: goto L100;
            default: goto L121;
        };
    L100:
        if (r9.equals("album_ocr") == false) goto L121;
    L139:
        return r28;
    L103:
        if (r9.equals("shoot") == false) goto L121;
    L141:
        return r110;
    L106:
        if (r9.equals("paste") == false) goto L121;
        if (r10 == true) goto L139;
        return r0;
    L111:
        if (r9.equals("album") == true) goto L139;
    L115:
        if (r9.equals("file") == false) goto L121;
        return r0;
    L118:
        if (r9.equals("shoot_ocr") == true) goto L141;
    L95:
        r0 = false;
        goto L97
    L57:
        if (Intrinsics.areEqual(r24.getConfKey(), "apply_attachment_skip_optional") == false) goto L59;
        r25 = true;
        goto L60
    L62:
        r23 = null;
    L66:
        r27 = null;
    L70:
        r28 = false;
        goto L72
    L31:
        if (Intrinsics.areEqual(r5.getConfKey(), "apply_attachment_skip_optional") == false) goto L33;
        r6 = true;
        goto L34
    L36:
        r4 = null;
    L40:
        r19 = null;
    L44:
        r110 = false;
        goto L46
    L8:
        if (h0.e(r11) == false) goto L10;
        goto L10
    }

    public static final void x(LegacyMultimodalDataProcessor r13, boolean r14, boolean r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r20, boolean r21, boolean r22, boolean r23, FlowDriveFileType r24, boolean r25, String r26, boolean r27) {
        r13.getClass();
        if (r15 == false) goto L12;
        if (r18 == false) goto L6;
        t19.s r1 = t19.s.a;
        Context r0 = r13.getContext();
        r1.getClass();
        t19.s.s(r0, 2131900063);
        return;
    L6:
        if (r20 == false) goto L8;
        t19.s r2 = t19.s.a;
        Context r3 = r13.getContext();
        Context r4 = r13.getContext();
        ImFileUtil.a.getClass();
        long r8 = ((Number) ImFileUtil.o.getValue()).longValue();
        StringBuilder r10 = new StringBuilder();
        long r11 = 1024;
        r10.append((r8 / r11) / r11);
        r10.append("MB");
        String r5 = r4.getString(2131907893, new Object[]{r10.toString()});
        r2.getClass();
        t19.s.t(r3, r5);
        return;
    L8:
        if (r22 == false) goto L10;
        t19.s r6 = t19.s.a;
        Context r7 = r13.getContext();
        Context r9 = r13.getContext();
        ImFileUtil.a.getClass();
        String r12 = r9.getString(2131900065, new Object[]{String.valueOf(ImFileUtil.k())});
        r6.getClass();
        t19.s.t(r7, r12);
        return;
    L10:
        if (r21 == false) goto L67;
        t19.s r28 = t19.s.a;
        Context r29 = r13.getContext();
        Context r30 = r13.getContext();
        ImFileUtil.a.getClass();
        long r31 = 60;
        String r32 = r30.getString(2131907359, new Object[]{String.valueOf((int) (((((Number) ImFileUtil.p.getValue()).longValue() / ((long) 1000)) / r31) / r31))});
        r28.getClass();
        t19.s.t(r29, r32);
        return;
    L67:
        return;
    L12:
        if (r24 == null) goto L20;
        int r33 = c.b[r24.ordinal()];
        if (r33 != 1) goto L16;
        t19.s r34 = t19.s.a;
        Context r35 = r13.getContext();
        r34.getClass();
        t19.s.s(r35, 2131909177);
        return;
    L16:
        if (r33 != 2) goto L78;
        t19.s r36 = t19.s.a;
        Context r37 = r13.getContext();
        r36.getClass();
        t19.s.s(r37, 2131909178);
        return;
    L78:
        return;
    L20:
        if (r26 == null) goto L22;
        t19.s r38 = t19.s.a;
        Context r39 = r13.getContext();
        r38.getClass();
        t19.s.t(r39, r26);
        return;
    L22:
        if (r16 == false) goto L25;
        if (r14 == false) goto L25;
        t19.s r40 = t19.s.a;
        Context r41 = r13.getContext();
        r40.getClass();
        t19.s.s(r41, 2131900063);
        return;
    L25:
        if (r17 == false) goto L27;
        t19.s r42 = t19.s.a;
        Context r43 = r13.getContext();
        r42.getClass();
        t19.s.s(r43, 2131907894);
        return;
    L27:
        if (r18 == false) goto L29;
        t19.s r44 = t19.s.a;
        Context r45 = r13.getContext();
        r44.getClass();
        t19.s.s(r45, 2131907890);
        return;
    L29:
        if (r20 == false) goto L31;
        t19.s r46 = t19.s.a;
        Context r47 = r13.getContext();
        Context r48 = r13.getContext();
        ImFileUtil.a.getClass();
        long r49 = ((Number) ImFileUtil.k.getValue()).longValue();
        StringBuilder r110 = new StringBuilder();
        long r111 = 1024;
        r110.append((r49 / r111) / r111);
        r110.append("MB");
        String r50 = r48.getString(2131907893, new Object[]{r110.toString()});
        r46.getClass();
        t19.s.t(r47, r50);
        return;
    L31:
        if (r19 == false) goto L33;
        t19.s r51 = t19.s.a;
        Context r52 = r13.getContext();
        Context r53 = r13.getContext();
        ImFileUtil.a.getClass();
        long r54 = ((Number) ImFileUtil.l.getValue()).longValue();
        StringBuilder r55 = new StringBuilder();
        long r112 = 1024;
        r55.append((r54 / r112) / r112);
        r55.append("MB");
        String r56 = r53.getString(2131907896, new Object[]{r55.toString()});
        r51.getClass();
        t19.s.t(r52, r56);
        return;
    L33:
        if (r22 == true) goto L35;
        return;
    L35:
        if (r27 == false) goto L57;
        ICoreInputAbility r57 = r13.E();
        if (r57 != null) goto L39;
    L41:
        boolean r58 = false;
    L42:
        if (r58 == false) goto L44;
        Context r59 = r13.getContext();
        ImFileUtil.a.getClass();
        String r60 = r59.getString(2131907886, new Object[]{String.valueOf(ImFileUtil.o())});
    L62:
        t19.s r61 = t19.s.a;
        Context r62 = r13.getContext();
        r61.getClass();
        t19.s.t(r62, r60);
        return;
    L44:
        if (r23 == true) goto L56;
        if (r25 == true) goto L56;
        com.larus.bmhome.chat.component.bottom.multimodal.g r63 = (com.larus.bmhome.chat.component.bottom.multimodal.g) r13.n.getValue();
        if (r63 != null) goto L50;
    L52:
        boolean r64 = false;
    L53:
        if (r64 == false) goto L55;
        Context r65 = r13.getContext();
        ImFileUtil.a.getClass();
        r60 = r65.getString(2131910955, new Object[]{String.valueOf(ImFileUtil.m())});
        goto L62
    L55:
        Context r66 = r13.getContext();
        ImFileUtil.a.getClass();
        r60 = r66.getString(2131907895, new Object[]{String.valueOf(ImFileUtil.n())});
        goto L62
    L50:
        if (r63.nA(null) != true) goto L52;
        r64 = true;
    L56:
        Context r67 = r13.getContext();
        ImFileUtil.a.getClass();
        r60 = r67.getString(2131907892, new Object[]{String.valueOf(ImFileUtil.l())});
        goto L62
    L39:
        if (r57.Pi() != true) goto L41;
        r58 = true;
        goto L42
    L57:
        com.larus.bmhome.chat.component.bottom.multimodal.g r68 = (com.larus.bmhome.chat.component.bottom.multimodal.g) r13.n.getValue();
        if (r68 == null) goto L61;
        r60 = r68.mS(r23, Boolean.valueOf(r25));
        if (r60 != null) goto L62;
    L61:
        r60 = r13.getContext().getString(2131907895, new Object[]{String.valueOf(r13.F())});
        goto L62
    }

    public static void I(LegacyMultimodalDataProcessor r27, List r28, boolean r29, String r30, Integer r31, DirectSendData r32, Map r33, List r34, List r35, List r36, List r37, boolean r38, List r39, boolean r40, String r41, boolean r42, String r43, ns8.b r44, int r45) {
        if ((r45 & 8) == 0) goto L5;
        Integer r12 = null;
    L7:
        if ((r45 & 16) == 0) goto L9;
        DirectSendData r13 = null;
    L11:
        if ((r45 & 32) == 0) goto L13;
        Map r11 = null;
    L15:
        if ((r45 & 64) == 0) goto L17;
        List r20 = null;
    L19:
        if ((r45 & 128) == 0) goto L21;
        List r21 = null;
    L23:
        if ((r45 & 256) == 0) goto L25;
        List r22 = null;
    L27:
        if ((r45 & 512) == 0) goto L29;
        List r23 = null;
    L31:
        if ((r45 & 1024) == 0) goto L33;
        boolean r9 = false;
    L35:
        if ((r45 & 2048) == 0) goto L37;
        List r10 = null;
    L39:
        if ((r45 & 4096) == 0) goto L41;
        boolean r19 = false;
    L43:
        if ((r45 & 8192) == 0) goto L45;
        String r16 = null;
    L47:
        if ((r45 & 16384) == 0) goto L49;
        boolean r7 = false;
    L51:
        if ((32768 & r45) == 0) goto L53;
        String r14 = null;
    L55:
        if ((r45 & 65536) == 0) goto L57;
        ns8.b r15 = null;
    L58:
        r27.getClass();
        BuildersKt.launch$default(r27.a.d, Dispatchers.getMain(), null, new LegacyMultimodalDataProcessor$onMultiFileResultSuccess$1(r30, r29, r28, r7, r27, r9, r10, r11, r12, r13, r14, r15, r16, System.currentTimeMillis(), r19, r20, r21, r22, r23, null), 2, null);
        return;
    L57:
        r15 = r44;
        goto L58
    L53:
        r14 = r43;
        goto L55
    L49:
        r7 = r42;
        goto L51
    L45:
        r16 = r41;
        goto L47
    L41:
        r19 = r40;
        goto L43
    L37:
        r10 = r39;
        goto L39
    L33:
        r9 = r38;
        goto L35
    L29:
        r23 = r37;
        goto L31
    L25:
        r22 = r36;
        goto L27
    L21:
        r21 = r35;
        goto L23
    L17:
        r20 = r34;
        goto L19
    L13:
        r11 = r33;
        goto L15
    L9:
        r13 = r32;
        goto L11
    L5:
        r12 = r31;
        goto L7
    }
}
