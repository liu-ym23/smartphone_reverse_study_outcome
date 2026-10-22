package com.larus.chat.gallery.impl.preview.input;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.router.SmartRouter;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.bean.PageType;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.bmhome.view.AttachmentInfo;
import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.ImageParam;
import com.larus.camera.api.params.OutputParam;
import com.larus.common.apphost.AppHost;
import com.larus.gallery.api.GalleryType;
import com.larus.im.bean.bot.ConversationPage;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.utils.logger.FLogger;
import ic8.l0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class CreationRecordSendStrategy implements e0 {
    public static final /* synthetic */ int d = 0;
    public final CoroutineScope a;
    public Function1<? super Boolean, Unit> b;
    public Job c;

    public static final class a {
    }

    public /* synthetic */ class b {
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

    static {
    }

    @Override // com.larus.chat.gallery.impl.preview.input.e0
    public final void c(boolean r1) {
    }

    @Override // com.larus.chat.gallery.impl.preview.input.e0
    public final SuggestedAction i() {
        return null;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.e0
    public final boolean d() {
        Job r0 = this.c;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isActive() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public CreationRecordSendStrategy(com.larus.chat.gallery.impl.preview.p.b r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
    }

    @Override // com.larus.chat.gallery.impl.preview.input.e0
    public final void a(com.larus.chat.gallery.impl.preview.provider.a0 r3) {
        this.b = r3;
        if (r3 != null) goto L9;
        Job r4 = this.c;
        if (r4 == null) goto L7;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
    L7:
        this.c = null;
        return;
    }

    @Override // com.larus.chat.gallery.impl.preview.input.e0
    public final boolean h(String r34, xy8.d r35) {
        Intrinsics.checkNotNullParameter(r34, ShareType.TEXT);
        Intrinsics.checkNotNullParameter(r35, "data");
        int r3 = b.a[r35.e.ordinal()];
        boolean r6 = true;
        int r7 = 0;
        if (r3 != 1) goto L5;
        xy8.b r2 = r35.c;
        if (r2 == null) goto L76;
        String r4 = r2.a;
    L77:
        if (r4 != null) goto L80;
        r4 = "";
    L80:
        if (r4.length() != 0) goto L82;
        boolean r5 = true;
    L83:
        if (r5 == false) goto L86;
        FLogger.a.e("CreationRecordSendStrategy", "navigateToChat: imageUri is empty, abort");
        return false;
    L86:
        Job r8 = this.c;
        if (r8 != null) goto L89;
    L91:
        r6 = false;
    L92:
        if (r6 == false) goto L94;
        return false;
    L94:
        this.c = BuildersKt.launch$default(this.a, null, null, new CreationRecordSendStrategy$navigateToChat$1(this, r4, r34, null), 3, null);
        return false;
    L89:
        if (r8.isActive() != true) goto L91;
    L82:
        r5 = false;
        goto L83
    L76:
        r4 = null;
        goto L77
    L5:
        if (r3 == 2) goto L8;
        FLogger.a.e("CreationRecordSendStrategy", "navigateToChat: unknown resourceType=" + r35.e + ", abort");
        return false;
    L8:
        xy8.g r9 = r35.d;
        if (r9 != null) goto L11;
    L71:
        FLogger.a.e("CreationRecordSendStrategy", "navigateToChat: videoContent is null or vid is empty, abort");
        return false;
    L11:
        if (r9.a.length() != 0) goto L13;
        boolean r10 = true;
    L14:
        if (r10 == true) goto L71;
        Activity r11 = AppHost.a.a().getCurrentActivity();
        if (r11 != null) goto L19;
        FLogger.a.e("CreationRecordSendStrategy", "openChatPageForVideo: currentActivity is null, abort");
        return false;
    L19:
        AuthModelDelegate r12 = AuthModelDelegate.b;
        com.larus.bmhome.chat.api.e0 r13 = (com.larus.bmhome.chat.api.e0) r12.e().getValue();
        if (r13 == null) goto L25;
        LaunchInfo r14 = r13.a;
        if (r14 == null) goto L25;
        String r15 = r14.W();
        if (r15 == null) goto L25;
    L26:
        nr9.g r23 = new nr9.g(r9.a, null, r9.b, r9.c, null, null, new nr9.f(null, r9.d, null, Integer.valueOf(r9.k), Integer.valueOf(r9.j), null, 37), null, null, null, 946);
        FLogger r16 = FLogger.a;
        StringBuilder r17 = new StringBuilder("openChatPageForVideo: hasPlayUrl=");
        String r18 = r9.b;
        if (r18 != null) goto L29;
    L32:
        boolean r19 = true;
    L33:
        r17.append(!r19);
        r17.append(", hasCoverUrl=");
        String r20 = r9.d;
        if (r20 != null) goto L36;
    L39:
        boolean r21 = true;
    L40:
        r17.append(!r21);
        r16.i("CreationRecordSendStrategy", r17.toString());
        wc9.e r22 = (wc9.e) r12.y().getValue();
        if (r22 == null) goto L45;
        ConversationPage r24 = r22.g;
        if (r24 == null) goto L45;
        List r32 = r24.getPageList();
    L46:
        boolean r25 = l0.a(r32);
        Bundle r1 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("argBotId", r15), TuplesKt.to("actionbar_instruction_prompt", r34), TuplesKt.to("creation_remote_video_play_data", HttpExtKt.p(r23)), TuplesKt.to("creation_remote_video_prompt", r34), TuplesKt.to("creation_remote_video_direct_send", Boolean.TRUE), TuplesKt.to("enter_method", "creation_record_gallery")});
        if (r25 == false) goto L49;
        String r26 = "//flow/chat_multi_tab";
    L50:
        com.bytedance.router.i r27 = SmartRouter.buildRoute(r11, r26);
        r27.c.putExtras(r1);
        r27.c.addFlags(67108864);
        if (r32 == null) goto L69;
        if (r25 == false) goto L69;
        wc9.e r28 = (wc9.e) r12.y().getValue();
        if (r28 == null) goto L60;
        ConversationPage r29 = r28.g;
        if (r29 == null) goto L60;
        Integer r30 = r29.getDefaultStatus();
        if (r30 == null) goto L60;
        int r31 = r30.intValue();
    L61:
        wc9.e r33 = (wc9.e) r12.y().getValue();
        if (r33 == null) goto L68;
        ConversationPage r36 = r33.g;
        if (r36 == null) goto L68;
        Integer r37 = r36.getPagePosition();
        if (r37 == null) goto L68;
        r7 = r37.intValue();
    L68:
        ArrayList r38 = new ArrayList();
        r38.addAll(r32);
        Unit r110 = Unit.INSTANCE;
        r27.c.putExtra("argument_multi_tab_list", r38);
        r27.c.putExtra("argument_multi_tab_default_tab", r31);
        r27.h("argument_multi_tab_title_style", r7);
    L60:
        r31 = PageType.Chat.getType();
    L69:
        r16.i("CreationRecordSendStrategy", "openChatPageForVideo: opening route=" + r26 + ", isChatMultiTab=" + r25);
        r27.d();
        return true;
    L49:
        r26 = "//flow/chat_page";
    L45:
        r32 = null;
        goto L46
    L36:
        if (StringsKt.isBlank(r20) == true) goto L39;
        r21 = false;
        goto L40
    L29:
        if (StringsKt.isBlank(r18) == true) goto L32;
        r19 = false;
    L25:
        r15 = "7234781073513644036";
        goto L26
    L13:
        r10 = false;
        goto L14
    }

    public static final boolean j(CreationRecordSendStrategy r9, String r10, AttachmentInfo r11) {
        r9.getClass();
        Activity r12 = AppHost.a.a().getCurrentActivity();
        int r0 = 0;
        if (r12 != null) goto L5;
        FLogger.a.e("CreationRecordSendStrategy", "openChatPage: currentActivity is null, abort");
        return false;
    L5:
        AuthModelDelegate r2 = AuthModelDelegate.b;
        com.larus.bmhome.chat.api.e0 r3 = (com.larus.bmhome.chat.api.e0) r2.e().getValue();
        if (r3 == null) goto L11;
        LaunchInfo r4 = r3.a;
        if (r4 == null) goto L11;
        String r5 = r4.W();
        if (r5 == null) goto L11;
    L12:
        FLogger r6 = FLogger.a;
        r6.i("CreationRecordSendStrategy", "openChatPage: routing to chat, botId=".concat(r5));
        wc9.e r7 = (wc9.e) r2.y().getValue();
        if (r7 == null) goto L17;
        ConversationPage r8 = r7.g;
        if (r8 == null) goto L17;
        List r13 = r8.getPageList();
    L18:
        boolean r14 = l0.a(r13);
        Bundle r15 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("argBotId", r5), TuplesKt.to("actionbar_remote_image", r11), TuplesKt.to("actionbar_instruction_prompt", r10)});
        if (r14 == false) goto L21;
        String r16 = "//flow/chat_multi_tab";
    L22:
        com.bytedance.router.i r17 = SmartRouter.buildRoute(r12, r16);
        r17.c.putExtras(r15);
        r17.c.addFlags(67108864);
        if (r13 == null) goto L41;
        if (r14 == false) goto L41;
        wc9.e r18 = (wc9.e) r2.y().getValue();
        if (r18 == null) goto L32;
        ConversationPage r19 = r18.g;
        if (r19 == null) goto L32;
        Integer r110 = r19.getDefaultStatus();
        if (r110 == null) goto L32;
        int r111 = r110.intValue();
    L33:
        wc9.e r20 = (wc9.e) r2.y().getValue();
        if (r20 == null) goto L40;
        ConversationPage r21 = r20.g;
        if (r21 == null) goto L40;
        Integer r22 = r21.getPagePosition();
        if (r22 == null) goto L40;
        r0 = r22.intValue();
    L40:
        ArrayList r23 = new ArrayList();
        r23.addAll(r13);
        Unit r24 = Unit.INSTANCE;
        r17.c.putExtra("argument_multi_tab_list", r23);
        r17.c.putExtra("argument_multi_tab_default_tab", r111);
        r17.h("argument_multi_tab_title_style", r0);
    L32:
        r111 = PageType.Chat.getType();
    L41:
        r6.i("CreationRecordSendStrategy", "openChatPage: opening route=" + r16 + ", isChatMultiTab=" + r14);
        r17.d();
        return true;
    L21:
        r16 = "//flow/chat_page";
    L17:
        r13 = null;
    L11:
        r5 = "7234781073513644036";
        goto L12
    }

    @Override // com.larus.chat.gallery.impl.preview.input.e0
    public final boolean b(SuggestedAction r1, xy8.d r2, String r3) {
        return e0.a.a(this, r1, r2);
    }

    @Override // com.larus.chat.gallery.impl.preview.input.e0
    public final boolean e(String r3, xy8.d r4, zy8.s r5) {
        Intrinsics.checkNotNullParameter(r3, ShareType.TEXT);
        Intrinsics.checkNotNullParameter(r4, "data");
        FLogger.a.w("CreationRecordSendStrategy", "sendInChat called on CreationRecord source, delegating to navigateToChat");
        return h(r3, r4);
    }

    @Override // com.larus.chat.gallery.impl.preview.input.e0
    public final boolean f(String r9, CameraOutputContext r10, Map<String, String> r11) {
        Intrinsics.checkNotNullParameter(r9, ShareType.TEXT);
        Intrinsics.checkNotNullParameter(r10, "outputContext");
        List<OutputParam> r12 = r10.getOutputParamList();
        List<OutputParam> r0 = r12;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        FLogger.a.e("CreationRecordSendStrategy", "sendWithInputContent: outputParamList is empty");
        return false;
    L13:
        ArrayList r4 = new ArrayList();
        Iterator<T> r2 = r12.iterator();
    L14:
        String r6 = null;
        if (r2.hasNext() == false) goto L29;
        Object r5 = r2.next();
        OutputParam r7 = (OutputParam) r5;
        if (r7 == null) goto L19;
        r6 = r7.getPath();
    L19:
        if (r6 != null) goto L21;
    L24:
        boolean r8 = true;
    L26:
        if ((!r8) == false) goto L14;
        r4.add(r5);
        goto L14
    L21:
        if (r6.length() == 0) goto L24;
        r8 = false;
        goto L26
    L29:
        if (r4.isEmpty() == false) goto L32;
        FLogger.a.e("CreationRecordSendStrategy", "sendWithInputContent: no valid paths in outputParamList");
        return false;
    L32:
        OutputParam r13 = (OutputParam) CollectionsKt.firstOrNull(r12);
        if (r13 == null) goto L37;
        Pair<String, Integer> r14 = r13.getInputContent();
        if (r14 == null) goto L37;
        Integer r15 = (Integer) r14.getSecond();
    L38:
        if (r15 != null) goto L41;
    L43:
        if (r15 != null) goto L46;
    L48:
        FLogger.a.i("CreationRecordSendStrategy", "sendWithInputContent: text.length=" + r9.length() + ", imageCount=" + r4.size());
        return k(r9, r4, r11, r6);
    L46:
        if (r15.intValue() != 2) goto L48;
        r6 = "speak";
        goto L48
    L41:
        if (r15.intValue() != 1) goto L43;
        r6 = "keyboard";
    L37:
        r15 = null;
        goto L38
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L10
    }

    @Override // com.larus.chat.gallery.impl.preview.input.e0
    public final boolean g(SuggestedAction r7, CameraOutputContext r8, Map<String, String> r9) {
        Intrinsics.checkNotNullParameter(r7, "suggestedAction");
        Intrinsics.checkNotNullParameter(r8, "outputContext");
        List<OutputParam> r10 = r8.getOutputParamList();
        List<OutputParam> r0 = r10;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        FLogger.a.e("CreationRecordSendStrategy", "sendWithCameraOutput: outputParamList is empty");
        return false;
    L13:
        ArrayList r2 = new ArrayList();
        Iterator<T> r11 = r10.iterator();
    L15:
        if (r11.hasNext() == false) goto L30;
        Object r4 = r11.next();
        OutputParam r5 = (OutputParam) r4;
        if (r5 == null) goto L19;
        String r6 = r5.getPath();
    L20:
        if (r6 != null) goto L22;
    L25:
        boolean r12 = true;
    L27:
        if ((!r12) == false) goto L15;
        r2.add(r4);
        goto L15
    L22:
        if (r6.length() == 0) goto L25;
        r12 = false;
        goto L27
    L19:
        r6 = null;
        goto L20
    L30:
        if (r2.isEmpty() == false) goto L33;
        FLogger.a.e("CreationRecordSendStrategy", "sendWithCameraOutput: no valid paths in outputParamList");
        return false;
    L33:
        String r13 = r7.getDisplayName();
        if (r13 != null) goto L36;
        r13 = "";
    L36:
        Map r14 = r7.getEventExtra();
        if (r14 == null) goto L40;
        String r15 = (String) r14.get("sug_scene");
        if (r15 == null) goto L40;
    L42:
        return k(r13, r2, r9, r15);
    L40:
        r15 = "attachment_suggest";
        goto L42
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L10
    }

    public static boolean k(String r51, List r52, Map r53, String r54) {
        Activity r0 = AppHost.a.a().getCurrentActivity();
        if (r0 != null) goto L6;
        FLogger.a.e("CreationRecordSendStrategy", "openChatPageWithAutoSend: currentActivity is null, abort");
        return false;
    L6:
        com.larus.bmhome.chat.api.e0 r3 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r3 == null) goto L12;
        LaunchInfo r4 = r3.a;
        if (r4 == null) goto L12;
        String r5 = r4.W();
        if (r5 == null) goto L12;
    L13:
        ArrayList r6 = new ArrayList();
        Iterator r7 = r52.iterator();
    L14:
        UplinkFileEntity r13 = null;
        if (r7.hasNext() == false) goto L38;
        OutputParam r8 = (OutputParam) r7.next();
        if (r8 == null) goto L36;
        String r9 = r8.getPath();
        if (r9 == null) goto L36;
        if (r9.length() <= 0) goto L23;
        boolean r10 = true;
    L24:
        if (r10 == true) goto L27;
        r9 = null;
    L27:
        if (r9 == null) goto L36;
        Integer r34 = Integer.valueOf(UplinkEntityType.EntityTypeImage.getValue());
        ImageObj r11 = new ImageObj(null, 0, 0, null, null, 31, null);
        ImageParam r12 = r8.getImageParam();
        if (r12 != null) goto L32;
    L34:
        boolean r14 = false;
    L35:
        r13 = new UplinkFileEntity(r34, new UplinkEntityContent(null, new Image(null, null, null, r11, null, r9, null, null, null, null, Boolean.valueOf(r14), null, null, null, 15319, null), 1, null), null, null, Integer.valueOf(FileReviewState.DEFAULT.getValue()), Integer.valueOf(FileParseState.DEFAULT.getValue()), 0, Integer.valueOf(UpLinkState.PROCESSING.getValue()), null, false, Uri.fromFile(new PolarisFileWrapper(r9)), null, null, null, 15116, null);
        goto L36
    L32:
        if (r12.isAiCreation() != true) goto L34;
        r14 = true;
        goto L35
    L23:
        r10 = false;
    L36:
        if (r13 == null) goto L14;
        r6.add(r13);
        goto L14
    L38:
        List r41 = CollectionsKt.toMutableList(r6);
        CustomMultiAttachmentInfo r31 = new CustomMultiAttachmentInfo("album", "picture_mark_page", new NestedFileContent(r41, null, false, null, 14, null), false, false, false, false, null, 248, null);
        if (r52.isEmpty() == true) goto L52;
        Iterator r15 = r52.iterator();
    L43:
        if (r15.hasNext() == false) goto L52;
        OutputParam r16 = (OutputParam) r15.next();
        if (r16 != null) goto L47;
    L49:
        boolean r17 = false;
    L50:
        if (r17 == false) goto L43;
        boolean r18 = true;
    L53:
        FLogger r19 = FLogger.a;
        r19.i("CreationRecordSendStrategy", "buildMarkMessageExt: hasPaintMark=" + r18);
        if (r18 == false) goto L56;
        String r20 = "1";
    L57:
        ICoreInputAbility.OnSendParams r110 = new ICoreInputAbility.OnSendParams(r51, "", null, null, null, null, null, null, 0, false, null, false, false, false, null, null, null, null, false, "picture_mark_page", MapsKt.mapOf(TuplesKt.to("ref_img_paint_mark", r20)), null, r54, null, null, null, r31, null, null, null, null, null, null, -72876320, 1, null);
        r19.i("CreationRecordSendStrategy", "openChatPageWithAutoSend: botId=" + r5 + ", text.length=" + r51.length() + ", entities=" + r41.size());
        wc9.e r21 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r21 == null) goto L62;
        ConversationPage r22 = r21.g;
        if (r22 == null) goto L62;
        List r111 = r22.getPageList();
    L63:
        boolean r23 = l0.a(r111);
        Bundle r2 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("argBotId", r5), TuplesKt.to("auto_send_message_params", r110)});
        Map r24 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("enter_method", "picture_mark_page")});
        if (r53 == null) goto L69;
        Iterator r25 = r53.entrySet().iterator();
    L67:
        if (r25.hasNext() == false) goto L69;
        Map.Entry r26 = (Map.Entry) r25.next();
        r24.put((String) r26.getKey(), (String) r26.getValue());
    L69:
        r2.putParcelable("actionbar_instruction_send_message_track_ext_map", new ICoreInputAbility.SendMessageTrackExtMap(r24));
        if (r23 == false) goto L72;
        String r27 = "//flow/chat_multi_tab";
    L73:
        com.bytedance.router.i r1 = SmartRouter.buildRoute(r0, r27);
        r1.c.putExtras(r2);
        r1.c.addFlags(67108864);
        if (r111 == null) goto L93;
        if (r23 == false) goto L93;
        AuthModelDelegate r28 = AuthModelDelegate.b;
        wc9.e r29 = (wc9.e) r28.y().getValue();
        if (r29 == null) goto L83;
        ConversationPage r30 = r29.g;
        if (r30 == null) goto L83;
        Integer r32 = r30.getDefaultStatus();
        if (r32 == null) goto L83;
        int r33 = r32.intValue();
    L84:
        wc9.e r35 = (wc9.e) r28.y().getValue();
        if (r35 == null) goto L91;
        ConversationPage r36 = r35.g;
        if (r36 == null) goto L91;
        Integer r37 = r36.getPagePosition();
        if (r37 == null) goto L91;
        int r38 = r37.intValue();
    L92:
        ArrayList r39 = new ArrayList();
        r39.addAll(r111);
        Unit r40 = Unit.INSTANCE;
        r1.c.putExtra("argument_multi_tab_list", r39);
        r1.c.putExtra("argument_multi_tab_default_tab", r33);
        r1.h("argument_multi_tab_title_style", r38);
    L91:
        r38 = 0;
    L83:
        r33 = PageType.Chat.getType();
    L93:
        FLogger.a.i("CreationRecordSendStrategy", "openChatPageWithAutoSend: opening route=" + r27 + ", isChatMultiTab=" + r23);
        Result.Companion r42 = Result.Companion;     // Catch: Throwable -> L96
        r1.d();     // Catch: Throwable -> L96
        Object r43 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L96
    L98:
        Throwable r44 = Result.exceptionOrNull-impl(r43);
        if (r44 == null) goto L101;
        FLogger.a.e("CreationRecordSendStrategy", "openChatPageWithAutoSend: route failed", r44);
    L101:
        Boolean r45 = Boolean.FALSE;
        if (Result.isFailure-impl(r43) == false) goto L105;
        r43 = r45;
    L105:
        return ((Boolean) r43).booleanValue();
    L96:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        r43 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L98
    L72:
        r27 = "//flow/chat_page";
    L62:
        r111 = null;
        goto L63
    L56:
        r20 = TriggerSendLoading.NO_LOADING;
        goto L57
    L47:
        if (r16.isImageMarked() != true) goto L49;
        r17 = true;
    L52:
        r18 = false;
    L12:
        r5 = "7234781073513644036";
        goto L13
    }
}
