package com.larus.drive.sdk.impl.component.chat;

import android.content.Context;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.router.SmartRouter;
import com.google.gson.Gson;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.common.apphost.AppHost;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.platform.api.FlowDriveFileSendInfo;
import com.larus.platform.api.fileselect.DriveUplinkInfo;
import com.larus.platform.model.preview.AttachmentSnapshot;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import hq9.j4;
import hq9.w4;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import yc9.l1;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001CB\u0007¢\u0006\u0004\b\u0003\u0010\u0004Jp\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u00132\b\u0010!\u001a\u0004\u0018\u00010\u0013H\u0016Jt\u0010\"\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010#\u001a\u00020$2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010&2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u00132\b\u0010!\u001a\u0004\u0018\u00010\u0013H\u0002J\u001c\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130&2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J \u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0013\u0018\u00010&2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\"\u0010)\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016JR\u0010,\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u00152\b\u0010/\u001a\u0004\u0018\u00010+2\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u0011012\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u001b03H\u0016J(\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u00020\u00132\u0006\u00108\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u00109J2\u0010:\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010;\u001a\b\u0012\u0004\u0012\u0002050\u00152\b\u0010/\u001a\u0004\u0018\u00010+2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J \u0010<\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J(\u0010=\u001a\u00020\u00112\u0006\u0010>\u001a\u00020?2\u0006\u00107\u001a\u00020\u00132\u0006\u00108\u001a\u00020\u00132\u0006\u0010@\u001a\u00020\u0013H\u0002J\b\u0010A\u001a\u00020?H\u0002J\n\u0010B\u001a\u0004\u0018\u00010\u0013H\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006D"}, d2 = {"Lcom/larus/drive/sdk/impl/component/chat/DriveChatReceiveComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/drive/sdk/api/ability/IDriveChatReceiveAbility;", "<init>", "()V", "coreInputAbility", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "getCoreInputAbility", "()Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility;", "coreInputAbility$delegate", "Lkotlin/Lazy;", "referenceMsgAbility", "Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "getReferenceMsgAbility", "()Lcom/larus/bmhome/chat/component/bottom/reference/IReferenceMsgAbility;", "referenceMsgAbility$delegate", "sendDriveFileAndText", "", "sendText", "", "driveFileList", "", "Lcom/larus/drive/sdk/api/file/upload/UploadDriveFileInfo;", "txtScene", "fromScene", "enterMethod", "isSpeak", "", "sendInfo", "Lcom/larus/platform/api/FlowDriveFileSendInfo;", "sendConversation", "Lcom/larus/im/bean/conversation/Conversation;", "sendCvsId", "sendBotId", "sendDriveFileAndTextByCreation", "customMultiAttachment", "Lcom/larus/bmhome/chat/CustomMultiAttachmentInfo;", "driveBizExt", "", "buildCreationDriveMessageExt", "buildDriveBizExt", "sendDriveFileAndTextNavigateToChatPage", "driveFile", "Lcom/larus/drive/sdk/api/file/DriveFileItem;", "sendPreviewAttachmentsAndTextNavigateToChatPage", "attachments", "Lcom/larus/platform/model/preview/AttachmentSnapshot;", "sourceDriveFile", "onResult", "Lkotlin/Function1;", "shouldContinue", "Lkotlin/Function0;", "materializePreviewAttachment", "Lcom/larus/im/bean/message/UplinkFileEntity;", "entity", "conversationId", "botId", "(Lcom/larus/im/bean/message/UplinkFileEntity;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildPreviewSendDriveFileInfoJson", "entities", "buildSendDriveFileInfoJson", "openLocalConversationChatPage", "targetContext", "Landroid/content/Context;", "sendDriveFileInfo", "resolveChatOpenContext", "getMainBotId", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveChatReceiveComponent extends ComponentFeature implements r79.a {
    public static final /* synthetic */ int j = 0;
    public final Lazy h;
    public final Lazy i;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DriveFileType.values().length];
            r0[DriveFileType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[DriveFileType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[DriveFileType.AUDIO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class c implements Function0<ICoreInputAbility> {
        public final /* synthetic */ AttachReceiver a;

        public c(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(ICoreInputAbility.class));
        }
    }

    public static final class d implements Function0<com.larus.bmhome.chat.component.bottom.reference.a> {
        public final /* synthetic */ AttachReceiver a;

        public d(AttachReceiver r1) {
            this.a = r1;
        }

        public final Object invoke() {
            AttachReceiver r0 = this.a;
            if ((r0 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r0).o(Reflection.getOrCreateKotlinClass(com.larus.bmhome.chat.component.bottom.reference.a.class));
        }
    }

    static {
    }

    public DriveChatReceiveComponent() {
        this.h = LazyKt.lazy(new c(this));
        this.i = LazyKt.lazy(new d(this));
    }

    @Override // r79.a
    public final void wk(String r12, DriveFileItem r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r12, "sendText");
        if (r13 != null) goto L6;
        FLogger.a.i("DriveChatReceiveComponent", "[sendDriveFileAndTextNavigateToChatPage] Send param is null; driveFile=" + r13);
        return;
    L6:
        AppHost.Companion r0 = AppHost.a;
        Context r1 = r0.a().getCurrentActivity();
        if (r1 != null) goto L10;
        r1 = r0.getApplication().getApplicationContext();
    L10:
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new DriveChatReceiveComponent$sendDriveFileAndTextNavigateToChatPage$1(r1, this, r12, r13, r14, null), 2, null);
    }

    public static final String F2(DriveChatReceiveComponent r21, String r22, List r23, DriveFileItem r24, boolean r25) {
        r21.getClass();
        ArrayList r5 = new ArrayList();
        Iterator r2 = r23.iterator();
    L3:
        ImageObj r3 = null;
        if (r2.hasNext() == false) goto L78;
        UplinkFileEntity r4 = (UplinkFileEntity) r2.next();
        String r0 = l1.h(r4);
        if (r0 != null) goto L8;
    L75:
        if (r3 == null) goto L3;
        r5.add(r3);
        goto L3
    L8:
        if ((!StringsKt.isBlank(r0)) == false) goto L10;
        String r10 = r0;
    L11:
        if (r10 == null) goto L75;
        Map r1 = r4.getExtra();
        if (r1 == null) goto L25;
        String r6 = (String) r1.get("drive_uplink_info");
        if (r6 == null) goto L25;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L19
        Object r8 = Result.constructor-impl((DriveUplinkInfo) new Gson().fromJson(r6, DriveUplinkInfo.class));     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r8) == false) goto L24;
        r8 = null;
    L24:
        DriveUplinkInfo r9 = (DriveUplinkInfo) r8;
    L26:
        Image r11 = l1.c(r4);
        UplinkEntityContent r12 = r4.getUplinkEntityContent();
        if (r12 == null) goto L31;
        UplinkFileInfo r13 = r12.getUplinkFileInfo();
        if (r13 == null) goto L31;
        VideoExtension r14 = r13.getVideo();
    L32:
        String r15 = l1.a(r4);
        if (r9 == null) goto L36;
        String r16 = r9.getUrl();
        if (r16 == null) goto L36;
    L45:
        long r17 = l1.b(r4);
        if (n1.d(r4) == false) goto L49;
        int r18 = 1;
    L55:
        if (r9 == null) goto L57;
        int r110 = r9.getCcmType();
    L58:
        if (r11 == null) goto L60;
        ImageObj r111 = r11.imageThumb;
    L61:
        if (r11 == null) goto L63;
        ImageObj r112 = r11.imageOri;
    L64:
        if (r14 == null) goto L68;
        Image r20 = r14.getCover();
        if (r20 == null) goto L68;
        r3 = r20.imageOri;
    L68:
        ImageObj r113 = r3;
        if (r14 == null) goto L73;
        Float r26 = r14.getDuration();
        if (r26 == null) goto L73;
        float r114 = r26.floatValue();
    L74:
        r3 = new w4(r15, r10, r16, r17, r18, r110, r111, r112, r113, r114);
    L73:
        r114 = 0.0f;
        goto L74
    L63:
        r112 = null;
        goto L64
    L60:
        r111 = null;
        goto L61
    L57:
        r110 = 12;
        goto L58
    L49:
        if (n1.e(r4) == false) goto L52;
        r18 = 2;
        goto L55
    L52:
        if (n1.a(r4) == false) goto L54;
        r18 = 3;
        goto L55
    L54:
        r18 = 0;
    L36:
        if (r11 == null) goto L40;
        ImageObj r115 = r11.imageOri;
        if (r115 == null) goto L40;
        r16 = r115.url;
    L41:
        if (r16 != null) goto L45;
        if (r14 == null) goto L44;
        r16 = r14.getDownloadUrl();
        goto L45
    L44:
        r16 = null;
    L40:
        r16 = null;
    L31:
        r14 = null;
    L19:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
    L25:
        r9 = null;
        goto L26
    L10:
        r10 = null;
        goto L11
    L78:
        if (r5.size() != r23.size()) goto L96;
        if (r25 == false) goto L82;
        String r28 = "speak";
    L83:
        String r30 = r28;
        Gson r31 = new Gson();
        if (r24 == null) goto L86;
        String r32 = r24.b;
        String r33 = r24.a;
        int r34 = com.larus.drive.sdk.impl.utils.n.a;
        FlowDriveFileSendInfo r35 = new FlowDriveFileSendInfo(r32, r33, com.larus.drive.sdk.impl.utils.n.e(r24.j), com.larus.drive.sdk.impl.utils.n.d(r24));
    L88:
        return GsonProtectorUtils.toJson(r31, new j4(r22, r30, r30, r5, r35));
    L86:
        r35 = null;
        goto L88
    L82:
        r28 = "keyboard";
        goto L83
    L96:
        return null;
    }

    public static final void L2(DriveChatReceiveComponent r1, Context r2, String r3, String r4, String r5) {
        r1.getClass();
        com.bytedance.router.i r6 = SmartRouter.buildRoute(r2, "//flow/chat_page");
        r6.c.putExtras(com.larus.utils.f.c(new Pair[]{TuplesKt.to("argConversationId", r3), TuplesKt.to("argBotId", r4), TuplesKt.to("send_drive_file_info", r5)}));
        r6.d();
    }

    @Override // r79.a
    public final boolean OG(String r35, List r36, DriveFileItem r37, boolean r38, com.larus.drive.sdk.impl.gallery.j r310, com.larus.drive.sdk.impl.gallery.o r40) {
        Intrinsics.checkNotNullParameter(r35, "sendText");
        Intrinsics.checkNotNullParameter(r36, "attachments");
        Intrinsics.checkNotNullParameter(r310, "onResult");
        Intrinsics.checkNotNullParameter(r40, "shouldContinue");
        if (r36.isEmpty() == true) goto L24;
        List r0 = r36;
        if ((r0 instanceof Collection) == true) goto L7;
    L9:
        Iterator r1 = r0.iterator();
    L11:
        if (r1.hasNext() == false) goto L15;
        if ((!((AttachmentSnapshot) r1.next()).canEnterSendPipeline()) == false) goto L11;
        boolean r2 = true;
    L16:
        if (r2 == true) goto L24;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r3 = r0.iterator();
    L20:
        if (r3.hasNext() == false) goto L22;
        AttachmentSnapshot r4 = (AttachmentSnapshot) r3.next();
        r6.add(AttachmentSnapshot.copy$default(r4, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, 0, null, MapsKt.toMap(r4.getExtra()), 65535, null));
        goto L20
    L22:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new DriveChatReceiveComponent$sendPreviewAttachmentsAndTextNavigateToChatPage$2(r40, AppHost.a.getApplication().getApplicationContext(), this, r6, r35, r37, r38, r310, null), 2, null);
        return true;
    L15:
        r2 = false;
        goto L16
    L7:
        if (r0.isEmpty() == false) goto L9;
    L24:
        FLogger.a.e("DriveChatReceiveComponent", "[sendPreviewAttachments] rejected invalid frozen attachment set");
        return false;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r7v11 ??, still in use, count: 2, list:
          (r7v11 ?? I:com.larus.im.bean.message.VideoExtension) from 0x013c: INVOKE (r7v11 ?? I:com.larus.im.bean.message.VideoExtension), (r8v6 ?? I:java.lang.Float) VIRTUAL call: com.larus.im.bean.message.VideoExtension.setDuration(java.lang.Float):void (LINE:150995260)
          (r7v11 ?? I:com.larus.im.bean.message.VideoExtension) from 0x0154: INVOKE (r7v11 ?? I:com.larus.im.bean.message.VideoExtension), (r8v7 ?? I:com.larus.im.bean.message.Image) VIRTUAL call: com.larus.im.bean.message.VideoExtension.setCover(com.larus.im.bean.message.Image):void (LINE:150995284)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    @Override // r79.a
    public final void T10(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r7v11 ??, still in use, count: 2, list:
          (r7v11 ?? I:com.larus.im.bean.message.VideoExtension) from 0x013c: INVOKE (r7v11 ?? I:com.larus.im.bean.message.VideoExtension), (r8v6 ?? I:java.lang.Float) VIRTUAL call: com.larus.im.bean.message.VideoExtension.setDuration(java.lang.Float):void (LINE:150995260)
          (r7v11 ?? I:com.larus.im.bean.message.VideoExtension) from 0x0154: INVOKE (r7v11 ?? I:com.larus.im.bean.message.VideoExtension), (r8v7 ?? I:com.larus.im.bean.message.Image) VIRTUAL call: com.larus.im.bean.message.VideoExtension.setCover(com.larus.im.bean.message.Image):void (LINE:150995284)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r52v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
        */
}
