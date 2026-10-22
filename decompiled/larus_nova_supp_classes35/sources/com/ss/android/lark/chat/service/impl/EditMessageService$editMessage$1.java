package com.ss.android.lark.chat.service.impl;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.EditMessageAttachmentUpdate;
import com.bytedance.lark.pb.basic.v1.EditMessageContent;
import com.bytedance.lark.pb.basic.v1.File;
import com.bytedance.lark.pb.basic.v1.URL;
import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.bytedance.lark.pb.basic.v1.UrlPreviewHangPoint;
import com.bytedance.lark.pb.im.v1.EditMessageRequest;
import com.bytedance.lark.pb.im.v1.QuasiMessageExtraData;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.auditsdk.IAuditModuleDependency;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.message.content.TextContent;
import com.ss.android.lark.chat.utils.ChatParamUtils;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.ColorIcon;
import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.export.entity.preview.UnifiedHeaderInfo;
import com.ss.android.lark.export.entity.preview.Url;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.chat.ChatHitPointNew;
import com.ss.android.lark.utils.ContextsKt;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.genv2.RichTextGenerateUtils2;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.ErrorCodes;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.service.impl.EditMessageService$editMessage$1", f = "EditMessageService.kt", i = {}, l = {91, ErrorCodes.ERROR_INVOKE_API}, m = "invokeSuspend", n = {}, s = {})
public final class EditMessageService$editMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Chat $chat;
    final /* synthetic */ String $chatId;
    final /* synthetic */ Context $context;
    final /* synthetic */ WeakReference<Context> $contextRef;
    final /* synthetic */ s5c.d $extras;
    final /* synthetic */ List<File> $fileAttachments;
    final /* synthetic */ String $msgId;
    final /* synthetic */ RichText $richText;
    final /* synthetic */ String $title;
    int label;
    final /* synthetic */ EditMessageService this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.service.impl.EditMessageService$editMessage$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Lcom/larksuite/framework/callback/Entity/ErrorResult;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.chat.service.impl.EditMessageService$editMessage$1$2", f = "EditMessageService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<ErrorResult, Continuation<? super Unit>, Object> {
        final /* synthetic */ Chat $chat;
        final /* synthetic */ Context $ctx;
        final /* synthetic */ String $msgId;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ EditMessageService this$0;

        public AnonymousClass2(String r1, Context r2, EditMessageService r3, Chat r4, Continuation<? super AnonymousClass2> r5) {
            this.$msgId = r1;
            this.$ctx = r2;
            this.this$0 = r3;
            this.$chat = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            AnonymousClass2 r6 = new AnonymousClass2(this.$msgId, this.$ctx, this.this$0, this.$chat, r9);
            r6.L$0 = r8;
            return r6;
        }

        public final Object invoke(ErrorResult r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((ErrorResult) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L27;
            ResultKt.throwOnFailure(r4);
            ErrorResult r5 = (ErrorResult) this.L$0;
            Log.w("EditMessageService", "handleReEditMessage: msg " + this.$msgId + "on Error " + r5.getDisplayMsg(BuildConfig.FLAVOR));
            String r0 = r5.getDisplayMsg(BuildConfig.FLAVOR);
            if (owa.a.d().isHitStorageQuotaLimit(r5.getCode()) == false) goto L13;
            IAuditModuleDependency r1 = owa.a.d();
            Context r2 = this.$ctx;
            if (r2 == null) goto L9;
            Activity r3 = ContextsKt.findActivity(r2);
        L10:
            r1.showQuotaLimitDialog(r3, r5.getCode());
            return Unit.INSTANCE;
        L9:
            r3 = null;
            goto L10
        L13:
            if (r5.getCode() != 5104) goto L16;
            this.this$0.b.jd(true);
        L16:
            if (r5.getCode() != 5106) goto L19;
            r0 = UIHelper.getString(2131891083);
        L19:
            if (r5.getCode() != 5127) goto L22;
            r0 = UIHelper.mustacheFormat(2131891079, "ChatName", this.$chat.getName());
        L22:
            if (TextUtils.isEmpty(r0) == true) goto L25;
            UDToast.show(LarkContext.getApplication(), r0, 2131255144);
        L25:
            return Unit.INSTANCE;
        L27:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public EditMessageService$editMessage$1(s5c.d r1, WeakReference<Context> r2, Context r3, String r4, RichText r5, List<File> r6, EditMessageService r7, String r8, String r9, Chat r10, Continuation<? super EditMessageService$editMessage$1> r11) {
        this.$extras = r1;
        this.$contextRef = r2;
        this.$context = r3;
        this.$title = r4;
        this.$richText = r5;
        this.$fileAttachments = r6;
        this.this$0 = r7;
        this.$msgId = r8;
        this.$chatId = r9;
        this.$chat = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        return new EditMessageService$editMessage$1(this.$extras, this.$contextRef, this.$context, this.$title, this.$richText, this.$fileAttachments, this.this$0, this.$msgId, this.$chatId, this.$chat, r14);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        URL r4 = null;
        boolean r5 = true;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        ResultKt.throwOnFailure(r20);
    L199:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r20);
        Object r3 = r20;
    L13:
        Message r6 = (Message) r3;
        if (r6 != null) goto L16;
    L18:
        int r7 = 0;
        if (r6 != null) goto L21;
    L23:
        boolean r8 = false;
    L25:
        if (r8 == false) goto L27;
        String r9 = UIHelper.getString(2131891082);
        boolean r10 = true;
    L28:
        if (r6 != null) goto L30;
    L32:
        boolean r11 = false;
    L33:
        if (r11 == false) goto L35;
        r9 = UIHelper.getString(2131891083);
        r10 = true;
    L35:
        Context r13 = this.$contextRef.get();
        if (r10 == false) goto L46;
        Log.w("EditMessageService", "editMessage: message is deleted or recalled, save edit failed.");
        if (r13 == null) goto L45;
        if ((r13 instanceof Activity) == false) goto L45;
        if (((Activity) r13).isFinishing() == true) goto L45;
        new UDDialogBuilder(this.$context).message(r9).title(2131891086).addActionButton(2131391777, 2131891087, null).show();
    L45:
        return Unit.INSTANCE;
    L46:
        if (r6 == null) goto L78;
        Set<RichTextElement.RichTextTag> r12 = com.ss.android.lark.chat.utils.x.a;
        String r14 = this.$title;
        RichText r15 = this.$richText;
        Intrinsics.checkNotNullParameter(r14, "title");
        Intrinsics.checkNotNullParameter(r15, "content");
        Intrinsics.checkNotNullParameter(r6, "message");
        Message.Type r16 = r6.getType();
        if (r16 != Message.Type.POST) goto L50;
    L52:
        Message.Type r17 = r6.getType();
        if (r17 != null) goto L55;
        int r18 = -1;
    L56:
        if (r18 == 1) goto L66;
        if (r18 == 2) goto L59;
        Pair r19 = null;
    L70:
        if (r19 != null) goto L72;
    L71:
        boolean r21 = false;
    L76:
        if (r21 == false) goto L78;
        boolean r22 = true;
    L80:
        if (this.$fileAttachments == null) goto L82;
        boolean r23 = true;
    L83:
        if (r22 == true) goto L87;
        if (r23 == true) goto L87;
        Log.i("EditMessageService", "reEditMsg: message content not change, method return");
        return Unit.INSTANCE;
    L87:
        EditMessageService r24 = this.this$0;
        RichText r25 = this.$richText;
        CoroutineScope r110 = EditMessageService.d;
        r24.getClass();
        List r26 = r25.getMediaIds();
        Intrinsics.checkNotNull(r26);
        ArrayList r111 = new ArrayList();
        Iterator r27 = r26.iterator();
    L89:
        if (r27.hasNext() == false) goto L96;
        RichTextElement r112 = (RichTextElement) r25.getElements().getDictionary().get((String) r27.next());
        if (r112 == null) goto L93;
        RichTextElement.RichTextProperty r113 = r112.getProperty();
    L94:
        if (r113 == null) goto L89;
        r111.add(r113);
        goto L89
    L93:
        r113 = null;
        goto L94
    L96:
        ArrayList r28 = new ArrayList();
        Iterator r29 = r111.iterator();
    L98:
        if (r29.hasNext() == false) goto L102;
        Object r114 = r29.next();
        if ((r114 instanceof RichTextElement.MediaProperty) == false) goto L98;
        r28.add(r114);
        goto L98
    L102:
        ArrayList r30 = new ArrayList();
        Iterator r31 = r28.iterator();
    L104:
        if (r31.hasNext() == false) goto L121;
        Object r115 = r31.next();
        RichTextElement.MediaProperty r116 = (RichTextElement.MediaProperty) r115;
        String r117 = r116.getKey();
        if (r117 != null) goto L108;
    L111:
        boolean r118 = true;
    L112:
        if (r118 == false) goto L114;
    L116:
        boolean r119 = false;
    L118:
        if ((!r119) == false) goto L104;
        r30.add(r115);
        goto L104
    L114:
        if (r116.getOriginImage() == null) goto L116;
        r119 = true;
        goto L118
    L108:
        if (r117.length() == 0) goto L111;
        r118 = false;
        goto L112
    L121:
        if (r30.isEmpty() == false) goto L123;
        Map r32 = MapsKt.emptyMap();
    L128:
        Iterator r33 = r32.entrySet().iterator();
    L130:
        if (r33.hasNext() == false) goto L132;
        Map.Entry r120 = (Map.Entry) r33.next();
        ((RichTextElement.MediaProperty) r120.getValue()).setMediaUploadId((String) r120.getKey());
        goto L130
    L132:
        this.$richText.setRichTextVersion(1);
        if (this.$fileAttachments != null) goto L136;
        r5 = false;
    L136:
        boolean r34 = com.ss.android.lark.chat.utils.x.b(this.$richText, this.$title);
        if (r5 == true) goto L141;
        if (r34 == false) goto L141;
        com.bytedance.lark.pb.basic.v1.Message.Type r35 = com.bytedance.lark.pb.basic.v1.Message.Type.TEXT;
    L142:
        StringBuilder r121 = new StringBuilder("editMessage: build request, msgId=");
        r121.append(this.$msgId);
        r121.append(", type=");
        r121.append(r35);
        r121.append(", hasAttachmentUpdate=");
        r121.append(r5);
        r121.append(", attachmentCount=");
        List<File> r36 = this.$fileAttachments;
        if (r36 == null) goto L145;
        r7 = r36.size();
    L145:
        r121.append(r7);
        Log.i("EditMessageService", r121.toString());
        if (r6 == null) goto L148;
        Message.Type r37 = r6.getType();
    L150:
        if (r37 != Message.Type.TEXT) goto L152;
        Map<String, PreviewHangPoint> r38 = ((TextContent) r6.getMessageContent()).getPreviewHangPoints();
    L153:
        int r39 = cdb.c.a;
        Intrinsics.checkNotNullParameter(r38, "previewHangPoints");
        LinkedHashMap r40 = new LinkedHashMap();
        LinkedHashMap r41 = new LinkedHashMap();
        Iterator<Map.Entry<String, PreviewHangPoint>> r42 = r38.entrySet().iterator();
    L155:
        if (r42.hasNext() == false) goto L185;
        Map.Entry<String, PreviewHangPoint> r122 = r42.next();
        String r123 = r122.getKey();
        PreviewHangPoint r124 = r122.getValue();
        UrlPreviewHangPoint.Builder r125 = new UrlPreviewHangPoint.Builder();
        String r126 = r124.getUrl();
        if (r126 != null) goto L159;
        r126 = BuildConfig.FLAVOR;
    L159:
        r40.put(r123, r125.url(r126).preview_id(r124.getPreviewId()).need_local_preview(Boolean.valueOf(r124.getNeedLocalPreview())).is_lazy_load(Boolean.valueOf(r124.isLazyLoad())).send_scene(UrlPreviewHangPoint.SendScene.fromValue(r124.getSendScene().getValue())).build());
        String r127 = r124.getPreviewId();
        if (r127 == null) goto L183;
        UrlCardPreviewEntity r128 = r124.getUrlCardPreviewEntity();
        if (r128 == null) goto L183;
        UrlInlinePreviewEntity r129 = r128.getInlineEntity();
        if (r129 == null) goto L183;
        UrlPreviewEntity.Builder r130 = new UrlPreviewEntity.Builder().source_id(r129.getSourceId()).preview_id(r129.getPreviewId());
        Url r131 = r129.getUrl();
        if (r131 == null) goto L171;
        r4 = new URL.Builder().url(r131.getUrl()).ios(r131.getIosUrl()).android(r131.getAndroidUrl()).pc(r131.getPcUrl()).web(r131.getWebUrl()).build();
    L171:
        UrlPreviewEntity.Builder r43 = r130.url(r4).need_reload(Boolean.valueOf(r129.getNeedReload())).server_icon_key(r129.getNetIconKey()).server_title(r129.getTitle()).server_tag(r129.getNetUrlTag()).version(Integer.valueOf(r129.getVersion())).ud_icon(j6b.f.e(r129.getUdIcon())).is_sdk_preview(Boolean.valueOf(r129.isSdkPreview()));
        UnifiedHeaderInfo r132 = r129.getHeaderInfo();
        if (r132 == null) goto L181;
        ColorIcon r133 = r132.getIcon();
        if (r133 == null) goto L181;
        UrlPreviewEntity.UnifiedHeader.Builder r134 = new UrlPreviewEntity.UnifiedHeader.Builder();
        UrlPreviewEntity.ColorIcon.Builder r135 = new UrlPreviewEntity.ColorIcon.Builder();
        ImageSet r136 = r133.getImageSet();
        int r137 = j6b.b.a;
        if (r136 != null) goto L179;
        com.bytedance.lark.pb.basic.v1.ImageSet r44 = null;
    L180:
        UrlPreviewEntity.UnifiedHeader r45 = r134.icon(r135.icon(r44).favicon_url(r133.getFaviconUrl()).icon_color(j6b.h.e(r133.getThemeColor())).ud_icon(j6b.f.e(r133.getUdIcon())).build()).build();
    L182:
        r41.put(r127, r43.unified_header(r45).use_color_icon(Boolean.valueOf(r129.getUseColorIcon())).build());
    L184:
        r42 = r42;
        r4 = null;
        goto L155
    L179:
        r44 = new com.bytedance.lark.pb.basic.v1.ImageSet.Builder().key(r136.getKey()).origin(j6b.b.c(r136.getOrigin())).thumbnail(j6b.b.c(r136.getThumbnail())).middle(j6b.b.c(r136.getMiddle())).thumbnail_webp(j6b.b.c(r136.getThumbnailWebp())).middle_webp(j6b.b.c(r136.getMiddleWebp())).middle_mp4(j6b.b.c(r136.getMiddleMp4())).cover(j6b.b.c(r136.getCover())).build();
    L181:
        r42 = r42;
        r45 = null;
    L183:
        r42 = r42;
        goto L184
    L185:
        Intrinsics.checkNotNullParameter(r40, "hangPointMap");
        Intrinsics.checkNotNullParameter(r41, "previewEntityMap");
        EditMessageContent.Builder r46 = new EditMessageContent.Builder().title(this.$title).rich_text(com.ss.android.lark.parser.internal.g0.d(this.$richText)).lingo_option(com.ss.android.lark.parser.internal.g0.c(this.$richText)).url_preview_hang_point_map(r40);
        if (this.$fileAttachments == null) goto L188;
        r46.attachment_update(new EditMessageAttachmentUpdate.Builder().file_attachments(this.$fileAttachments).build());
    L188:
        EditMessageContent r47 = r46.build();
        QuasiMessageExtraData r48 = new QuasiMessageExtraData.Builder().url_preview_entities(r41).build();
        EditMessageRequest.Builder r49 = new EditMessageRequest.Builder();
        Long r50 = StringsKt.toLongOrNull(this.$chatId);
        long r138 = 0;
        if (r50 == null) goto L191;
        long r51 = r50.longValue();
    L192:
        EditMessageRequest.Builder r52 = r49.chat_id(Boxing.boxLong(r51)).cid(UUID.randomUUID().toString());
        Long r53 = StringsKt.toLongOrNull(this.$msgId);
        if (r53 == null) goto L195;
        r138 = r53.longValue();
    L195:
        EditMessageRequest r54 = r52.msg_id(Boxing.boxLong(r138)).extra_data(r48).content(r47).type(r35).build();
        m6b.h r55 = (m6b.h) ((c38.a) this.this$0).a.create(m6b.h.class);
        Intrinsics.checkNotNull(r54);
        r55.editMessage(r54).error(Dispatchers.getMain(), new AnonymousClass2(this.$msgId, r13, this.this$0, this.$chat, null));
        EditMessageService r56 = this.this$0;
        String r57 = this.$chatId;
        this.label = 2;
        if (EditMessageService.a(r56, r57, r32, this) != r1) goto L199;
        return r1;
    L191:
        r51 = 0;
        goto L192
    L152:
        r38 = MapsKt.emptyMap();
        goto L153
    L148:
        r37 = null;
    L141:
        r35 = com.bytedance.lark.pb.basic.v1.Message.Type.POST;
        goto L142
    L123:
        LinkedHashMap r139 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r30, 10)), 16));
        Iterator r58 = r30.iterator();
    L125:
        if (r58.hasNext() == false) goto L127;
        Object r59 = r58.next();
        RichTextElement.MediaProperty r140 = (RichTextElement.MediaProperty) r59;
        r139.put(UUID.randomUUID().toString(), r59);
        goto L125
    L127:
        r32 = r139;
        goto L128
    L82:
        r23 = false;
        goto L83
    L72:
        String r141 = (String) r19.component1();
        RichText r142 = (RichText) r19.component2();
        if (Intrinsics.areEqual(r14, r141) == true) goto L75;
        r21 = true;
        goto L76
    L75:
        Intrinsics.checkNotNullParameter(r15, "<this>");
        int r143 = com.ss.android.lark.widget.richtext.utils.b.a;
        Intrinsics.checkNotNullParameter(r15, "richText");
        RichTextGenerateUtils2 r144 = RichTextGenerateUtils2.a;
        RichText r60 = RichTextGenerateUtils2.c(com.ss.android.lark.widget.richtext.utils.b.a(r15, true));
        Intrinsics.checkNotNull(r142);
        Intrinsics.checkNotNullParameter(r142, "<this>");
        Intrinsics.checkNotNullParameter(r142, "richText");
        r21 = !Intrinsics.areEqual(r60, RichTextGenerateUtils2.c(com.ss.android.lark.widget.richtext.utils.b.a(r142, true)));
        goto L76
    L59:
        PostContent r145 = (PostContent) r6.getMessageContent();
        RichText r146 = r145.getRichText();
        if (r146 != null) goto L62;
        r146 = com.ss.android.lark.widget.richtext.c.a();
    L62:
        String r147 = r145.getTitle();
        if (r147 != null) goto L65;
        r147 = BuildConfig.FLAVOR;
    L65:
        r19 = TuplesKt.to(r147, r146);
        goto L70
    L66:
        RichText r148 = ((TextContent) r6.getMessageContent()).getRichText();
        if (r148 != null) goto L69;
        r148 = com.ss.android.lark.widget.richtext.c.a();
    L69:
        r19 = TuplesKt.to(BuildConfig.FLAVOR, r148);
        goto L70
    L55:
        r18 = com.ss.android.lark.chat.utils.x.a.a[r17.ordinal()];
        goto L56
    L50:
        if (r16 == Message.Type.TEXT) goto L52;
        Log.w("KeyboardEditUtils", "UnSupport message type, method return");
    L78:
        r22 = false;
        goto L80
    L30:
        if (r6.isRecalled() != true) goto L32;
        r11 = true;
        goto L33
    L27:
        r9 = BuildConfig.FLAVOR;
        r10 = false;
        goto L28
    L21:
        if (r6.isRemoved() != true) goto L23;
        r8 = true;
        goto L25
    L16:
        if (this.$extras == null) goto L18;
        s5c.d r61 = this.$extras.plus(ChatParamUtils.g(r6));
        Lazy r62 = ChatHitPointNew.a;
        Intrinsics.checkNotNullParameter(r61, "param");
        JSONObject r63 = r61.plus(ChatParamUtils.e()).toJson();
        Log.d("ChatHitPointNew", "IM_CHAT_MAIN_CLICK, params:" + r63);
        ChatHitPointNew.d().sendEvent("im_chat_main_click", r63);
        goto L18
    L10:
        ResultKt.throwOnFailure(r20);
        ExecutorCoroutineDispatcher r64 = EditMessageService.e;
        EditMessageService$editMessage$1$msg$1 r65 = new EditMessageService$editMessage$1$msg$1(this.this$0, this.$msgId, null);
        this.label = 1;
        r3 = BuildersKt.withContext(r64, r65, this);
        if (r3 != r1) goto L13;
        return r1;
    }
}
