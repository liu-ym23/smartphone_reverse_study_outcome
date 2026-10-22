package com.larus.chat.gallery.impl.preview.toolbar.action;

import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.chat.gallery.impl.preview.toolbar.PreviewToolbarView;
import com.larus.chat.gallery.impl.preview.toolbar.ToolbarButtonType;
import com.larus.gallery.api.GalleryType;
import com.larus.platform.api.creation.PublisherCreation;
import com.larus.platform.api.creation.PublisherTrackParams;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.platform.service.z2;
import com.larus.uaigc.utils.DataConverterKt;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class PublishAction implements o {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[SourceType.values().length];
            r0[SourceType.CREATION_RECORD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L12:
            r0[SourceType.CREATION_CARD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L5:
            a = r0;
            int[] r1 = new int[GalleryType.values().length];
            r1[GalleryType.Video.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L7:
            b = r1;
        }
    }

    static {
    }

    public PublishAction() {
    }

    public static PublisherCreation d(xy8.d r21, xy8.e r22) {
        String r2 = r22.a;
        Integer r3 = r22.b;
        Integer r4 = r22.h;
        String r5 = r22.c;
        if (r5 != null) goto L5;
    L10:
        r5 = null;
    L11:
        String r9 = r22.i;
        if (r9 != null) goto L20;
        r9 = r21.g;
        if (r9.length() <= 0) goto L16;
        boolean r10 = true;
    L17:
        if (r10 == true) goto L20;
        r9 = null;
        goto L20
    L16:
        r10 = false;
    L20:
        xy8.b r11 = r21.c;
        if (r11 == null) goto L24;
        String r12 = r11.a;
        if (r12 == null) goto L24;
    L28:
        String r13 = r22.d;
        String r0 = r22.f;
        if (r0 == null) goto L31;
        Integer r17 = StringsKt.toIntOrNull(r0);
    L32:
        String r1 = r22.e;
        if (r1 != null) goto L35;
    L40:
        String r18 = null;
    L41:
        String r8 = r22.g;
        if (r22.a == null) goto L44;
        boolean r19 = true;
    L46:
        return new PublisherCreation(r2, r3, r4, r5, r9, r12, r13, r17, r18, r19, r8, null, null, null, 14336, null);
    L44:
        r19 = false;
        goto L46
    L35:
        if (r1.length() <= 0) goto L37;
        boolean r14 = true;
    L38:
        if (r14 == false) goto L40;
        r18 = r1;
        goto L41
    L37:
        r14 = false;
        goto L38
    L31:
        r17 = null;
    L24:
        xy8.g r6 = r21.d;
        if (r6 == null) goto L27;
        r12 = r6.d;
        goto L28
    L27:
        r12 = null;
        goto L28
    L5:
        if (r5.length() <= 0) goto L7;
        boolean r15 = true;
    L8:
        if (r15 == false) goto L10;
    L7:
        r15 = false;
        goto L8
    }

    @Override // com.larus.chat.gallery.impl.preview.toolbar.action.o
    public final Object a(l0 r19, Continuation<? super Unit> r20) {
        FLogger.a.i("PublishAction", "execute: sourceType=" + r19.a.a);
        xy8.d r1 = r19.a;
        xy8.e r2 = r1.m;
        if (r2 == null) goto L5;
        Integer r5 = r2.b;
    L7:
        if (b.b[r1.e.ordinal()] != 1) goto L9;
        String r6 = "video_detail";
    L10:
        String r8 = "";
        if (r5 == null) goto L13;
        String r15 = zp9.y.b(r5.intValue());
    L14:
        if (r5 == null) goto L16;
        r8 = zp9.y.a(r5.intValue());
    L16:
        String r7 = r8;
        if (r19.j == false) goto L19;
        String r9 = "share_panel";
    L20:
        JSONObject r14 = new JSONObject();
        r14.put("click_from", r9);
        Iterator<Map.Entry<String, Object>> r10 = r1.f.entrySet().iterator();
    L22:
        if (r10.hasNext() == false) goto L26;
        Map.Entry<String, Object> r11 = r10.next();
        String r12 = r11.getKey();
        Object r13 = r11.getValue();
        if (r14.has(r12) == true) goto L22;
        r14.put(r12, r13);
        goto L22
    L26:
        if (r2 == null) goto L29;
        String r16 = r2.c;
        if (r16 == null) goto L29;
    L33:
        if (r2 == null) goto L35;
        String r3 = r2.a;
    L36:
        String r4 = r15;
        tx9.m0.b(r16, null, null, "chat", r6, r15, r7, r3, r14, 518);
        FLogger r17 = FLogger.a;
        StringBuilder r18 = new StringBuilder("reportClickPublish: click_add_creation, creationId=");
        if (r2 == null) goto L39;
        String r21 = r2.a;
    L40:
        r18.append(r21);
        r18.append(", type=");
        r18.append(r4);
        r18.append(", subType=");
        r18.append(r7);
        r18.append(", currentPage=");
        r18.append(r6);
        r17.i("PublishAction", r18.toString());
        int r22 = b.a[r19.a.a.ordinal()];
        if (r22 != 1) goto L43;
        xy8.d r23 = r19.a;
        xy8.e r24 = r23.m;
        if (r24 != null) goto L56;
        r17.w("PublishAction", "handleCreationRecord: publishMetadata is null");
        Object r0 = Unit.INSTANCE;
    L67:
        if (r0 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L70;
        return r0;
    L70:
        return Unit.INSTANCE;
    L56:
        if (z2.a.getCreationPublishConfig().b() == false) goto L62;
        UserCreation r25 = r23.n;
        if (r25 == null) goto L60;
        PublisherCreation r26 = zp9.d.g(r25, null);
    L61:
        r17.i("PublishAction", "handleCreationRecord: gotoPublisher, creationId=" + r24.a);
        com.larus.platform.service.e0.a.a1(r26, new PublisherTrackParams("creation_detail", 6));
        r0 = Unit.INSTANCE;
        goto L67
    L60:
        r26 = d(r23, r24);
        goto L61
    L62:
        r0 = g(r19, r24, r20);
        if (r0 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L67;
        r0 = Unit.INSTANCE;
        goto L67
    L43:
        if (r22 == 2) goto L46;
        r17.w("PublishAction", "不支持的 sourceType: " + r19.a.a);
        return Unit.INSTANCE;
    L46:
        Object r27 = e(r19, r20);
        if (r27 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L50;
        return r27;
    L50:
        return Unit.INSTANCE;
    L39:
        r21 = null;
        goto L40
    L35:
        r3 = null;
    L29:
        xy8.f r28 = r1.l;
        if (r28 == null) goto L32;
        r16 = r28.a;
        goto L33
    L32:
        r16 = null;
        goto L33
    L19:
        r9 = "detail_page";
        goto L20
    L13:
        r15 = "";
        goto L14
    L9:
        r6 = "picture_detail";
        goto L10
    L5:
        r5 = null;
        goto L7
    }

    public final Object e(l0 r9, Continuation<? super Unit> r10) {
        if ((r10 instanceof PublishAction$handleCreationCard$1) == false) goto L7;
        PublishAction$handleCreationCard$1 r0 = (PublishAction$handleCreationCard$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L18;
        if (r3 == 3) goto L17;
        if (r3 != 4) goto L16;
        ResultKt.throwOnFailure(r11);
    L45:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r11);
    L40:
        return Unit.INSTANCE;
    L18:
        r9 = (l0) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L34:
        xy8.e r12 = (xy8.e) r11;
        if (r12.a == null) goto L41;
        FLogger.a.i("PublishAction", "handleCreationCard: 从消息 ext 补全 creationId=" + r12.a);
        r0.L$0 = null;
        r0.label = 3;
        if (g(r9, r12, r0) != r2) goto L40;
        return r2;
    L41:
        FLogger.a.i("PublishAction", "handleCreationCard: 无 creationId，走 addCreation");
        r0.L$0 = null;
        r0.label = 4;
        if (c(r9, r12, r0) != r2) goto L45;
        return r2;
    L19:
        ResultKt.throwOnFailure(r11);
    L30:
        return Unit.INSTANCE;
    L20:
        ResultKt.throwOnFailure(r11);
        xy8.e r13 = r9.a.m;
        if (r13 != null) goto L25;
        FLogger.a.w("PublishAction", "handleCreationCard: publishMetadata is null");
        return Unit.INSTANCE;
    L25:
        if (r13.a == null) goto L31;
        FLogger.a.i("PublishAction", "handleCreationCard: 已有 creationId=" + r13.a);
        r0.label = 1;
        if (g(r9, r13, r0) != r2) goto L30;
        return r2;
    L31:
        r0.L$0 = r9;
        r0.label = 2;
        r11 = f(r13, r0);
        if (r11 != r2) goto L34;
        return r2;
    L7:
        r0 = new PublishAction$handleCreationCard$1(this, r10);
        goto L8
    }

    public final Object f(xy8.e r19, Continuation<? super xy8.e> r20) {
        xy8.e r1 = r19;
        if ((r20 instanceof PublishAction$resolvePublishMetadataFromMessage$1) == false) goto L7;
        PublishAction$resolvePublishMetadataFromMessage$1 r4 = (PublishAction$resolvePublishMetadataFromMessage$1) r20;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        Object r0 = r4.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r4.label;
        boolean r9 = true;
        if (r7 == 0) goto L18;
        if (r7 != 1) goto L17;
        String r2 = (String) r4.L$2;
        String r8 = (String) r4.L$1;
        xy8.e r10 = (xy8.e) r4.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L14
        String r11 = r2;
        r1 = r10;
    L28:
        String r3 = (String) r0;     // Catch: Throwable -> L54
        if (r3 != null) goto L31;
    L34:
        if (r9 == false) goto L36;
        return r1;
    L36:
        String r12 = r8 + '_' + r11;     // Catch: Throwable -> L54
        UserCreationFromIM r13 = (UserCreationFromIM) ((LinkedHashMap) DataConverterKt.c(r3, r8)).get(r12);     // Catch: Throwable -> L54
        if (r13 == null) goto L51;
        FLogger.a.i("PublishAction", "resolvePublishMetadataFromMessage: 找到 creationId=" + r13.getCreationId());     // Catch: Throwable -> L54
        String r14 = r13.getCreationId();     // Catch: Throwable -> L54
        Integer r15 = r13.getCreationType();     // Catch: Throwable -> L54
        if (r15 != null) goto L41;
        r15 = r1.b;     // Catch: Throwable -> L54
    L41:
        Integer r16 = r15;
        String r17 = r13.getRefContent();     // Catch: Throwable -> L54
        if (r17 != null) goto L44;
        r17 = r1.d;     // Catch: Throwable -> L54
    L44:
        String r18 = r17;
        String r21 = r13.getMaterialId();     // Catch: Throwable -> L54
        if (r21 != null) goto L47;
        r21 = r1.g;     // Catch: Throwable -> L54
    L47:
        String r110 = r21;
        String r22 = r13.getPrompt();     // Catch: Throwable -> L54
        if (r22 != null) goto L50;
        r22 = r1.i;     // Catch: Throwable -> L54
    L50:
        xy8.e r23 = xy8.e.a(r1, r14, r16, r18, r110, r22, false, 1716);     // Catch: Throwable -> L54
    L52:
        Object r24 = Result.constructor-impl(r23);     // Catch: Throwable -> L54
    L57:
        Throwable r25 = Result.exceptionOrNull-impl(r24);
        if (r25 == null) goto L61;
        FLogger.a.e("PublishAction", "resolvePublishMetadataFromMessage error", r25);
    L61:
        if (Result.isFailure-impl(r24) == true) goto L63;
        return r24;
    L63:
        return r1;
    L54:
        Throwable th = th;
        r10 = r1;
    L56:
        Result.Companion r26 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
        r1 = r10;
        goto L57
    L51:
        FLogger.a.w("PublishAction", "resolvePublishMetadataFromMessage: 未找到匹配项, key=" + r12);     // Catch: Throwable -> L54
        r23 = r1;
        goto L52
    L31:
        if (r3.length() == 0) goto L34;
        r9 = false;
    L14:
        th = th;
        goto L56
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r0);
        String r27 = r1.c;
        if (r27 != null) goto L21;
        return r1;
    L21:
        r11 = r1.e;
        if (r11 != null) goto L64;
        return r1;
    L64:
        Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L54
        IChatRepoService r112 = RepoDispatcherDelegate.b.e();     // Catch: Throwable -> L54
        r4.L$0 = r1;     // Catch: Throwable -> L54
        r4.L$1 = r27;     // Catch: Throwable -> L54
        r4.L$2 = r11;     // Catch: Throwable -> L54
        r4.label = 1;     // Catch: Throwable -> L54
        Object r28 = r112.w1(r27, r4);     // Catch: Throwable -> L54
        if (r28 != r6) goto L27;
        return r6;
    L27:
        r8 = r27;
        r0 = r28;
    L7:
        r4 = new PublishAction$resolvePublishMetadataFromMessage$1(this, r20);
        goto L8
    }

    public static final void b(PublishAction r26, l0 r27, String r28) {
        r26.getClass();
        PreviewToolbarView r2 = r27.f;
        if (r2 == null) goto L5;
        r2.b(ToolbarButtonType.PUBLISH, new s());
    L5:
        PreviewToolbarView r3 = r27.f;
        if (r3 == null) goto L8;
        r3.b(ToolbarButtonType.SET_PRIVATE, new t());
    L8:
        xy8.d r4 = r27.a;
        xy8.e r5 = r4.m;
        UserCreation r17 = null;
        if (r5 == null) goto L14;
        if (r28 != null) goto L12;
        String r6 = r5.a;
    L13:
        xy8.e r7 = xy8.e.a(r5, r6, null, null, null, null, true, 1022);
    L15:
        UserCreation r8 = r4.n;
        if (r8 == null) goto L18;
        r17 = UserCreation.c(r8, 1, null, null, null, null, null, 131063);
    L18:
        r27.e.Rf(new com.larus.gallery.api.p.j(xy8.d.a(r4, null, null, null, null, null, null, r7, r17, null, 0, 118783), false));
        FLogger.a.i("PublishAction", "swapToSetPrivateButton: 更新发布状态, itemKey=" + r4.b + ", creationId=" + r28);
        return;
    L12:
        r6 = r28;
        goto L13
    L14:
        r7 = null;
        goto L15
    }

    public final Object c(l0 r13, xy8.e r14, Continuation<? super Unit> r15) {
        if ((r15 instanceof PublishAction$addCreation$1) == false) goto L7;
        PublishAction$addCreation$1 r0 = (PublishAction$addCreation$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        ResultKt.throwOnFailure(r16);
    L46:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r13 = (l0) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L42:
        MainCoroutineDispatcher r17 = Dispatchers.getMain();
        PublishAction$addCreation$2 r3 = new PublishAction$addCreation$2((zp9.a) r16, r13, this, null);
        r0.L$0 = null;
        r0.label = 2;
        if (BuildersKt.withContext(r17, r3, r0) != r10) goto L46;
        return r10;
    L16:
        ResultKt.throwOnFailure(r16);
        PublisherCreation r18 = d(r13.a, r14);
        if (z2.a.getCreationPublishConfig().b() == false) goto L20;
        FLogger.a.i("PublishAction", "addCreation: isByPublisher=true, gotoPublisher");
        com.larus.platform.service.e0.a.a1(r18, new PublisherTrackParams("picture_detail", 6));
        return Unit.INSTANCE;
    L20:
        FLogger.a.i("PublishAction", "addCreation: isByPublisher=false, 直接调 API");
        Integer r19 = r14.b;
        if (r19 != null) goto L24;
    L26:
        if (r19 != null) goto L29;
    L31:
        int r4 = 2;
    L33:
        if (r14.j == false) goto L35;
        int r7 = 4;
    L36:
        com.larus.platform.service.e0 r5 = com.larus.platform.service.e0.a;
        String r110 = r14.c;
        if (r110 != null) goto L39;
        r110 = "";
    L39:
        String r6 = r14.f;
        String r8 = r14.e;
        String r9 = r14.g;
        r0.L$0 = r13;
        r0.label = 1;
        r16 = r5.l(r110, r4, r6, 1, r8, r7, r9, r0);
        if (r16 != r10) goto L42;
        return r10;
    L35:
        r7 = 1;
        goto L36
    L29:
        if (r19.intValue() != 4) goto L31;
        r4 = 4;
        goto L33
    L24:
        if (r19.intValue() != 3) goto L26;
        r4 = 3;
    L7:
        r0 = new PublishAction$addCreation$1(this, r15);
        goto L8
    }

    public final Object g(l0 r12, xy8.e r13, Continuation<? super Unit> r14) {
        if ((r14 instanceof PublishAction$setCreationPublic$1) == false) goto L7;
        PublishAction$setCreationPublic$1 r0 = (PublishAction$setCreationPublic$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r15);
    L43:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r16 = (String) r0.L$1;
        l0 r17 = (l0) r0.L$0;
        ResultKt.throwOnFailure(r15);
        String r9 = r16;
        l0 r7 = r17;
    L39:
        MainCoroutineDispatcher r18 = Dispatchers.getMain();
        PublishAction$setCreationPublic$2 r19 = new PublishAction$setCreationPublic$2((Pair) r15, r7, this, r9, null);
        r0.L$0 = null;
        r0.L$1 = null;
        r0.label = 2;
        if (BuildersKt.withContext(r18, r19, r0) != r2) goto L43;
        return r2;
    L16:
        ResultKt.throwOnFailure(r15);
        xy8.d r110 = r12.a;
        if (z2.a.getCreationPublishConfig().b() == false) goto L31;
        SourceType r111 = r110.a;
        SourceType r4 = SourceType.CREATION_RECORD;
        if (r111 != r4) goto L24;
        UserCreation r112 = r110.n;
        if (r112 == null) goto L23;
        PublisherCreation r113 = zp9.d.g(r112, null);
    L26:
        if (r110.a != r4) goto L28;
        String r114 = "creation_detail";
    L29:
        FLogger.a.i("PublishAction", "setCreationPublic: isByPublisher=true, gotoPublisher");
        com.larus.platform.service.e0.a.a1(r113, new PublisherTrackParams(r114, 6));
        return Unit.INSTANCE;
    L28:
        r114 = "picture_detail";
        goto L29
    L23:
        r113 = d(r110, r13);
        goto L26
    L24:
        r113 = d(r110, r13);
        goto L26
    L31:
        String r115 = r13.a;
        if (r115 != null) goto L35;
        FLogger.a.w("PublishAction", "setCreationPublic: creationId is null");
        return Unit.INSTANCE;
    L35:
        FLogger.a.i("PublishAction", "setCreationPublic: 调 updateCreationPrivateStatus, creationId=".concat(r115));
        com.larus.platform.service.e0 r116 = com.larus.platform.service.e0.a;
        r0.L$0 = r12;
        r0.L$1 = r115;
        r0.label = 1;
        r15 = r116.h(r115, 1, r0);
        if (r15 != r2) goto L38;
        return r2;
    L38:
        r7 = r12;
        r9 = r115;
    L7:
        r0 = new PublishAction$setCreationPublic$1(this, r14);
        goto L8
    }
}
