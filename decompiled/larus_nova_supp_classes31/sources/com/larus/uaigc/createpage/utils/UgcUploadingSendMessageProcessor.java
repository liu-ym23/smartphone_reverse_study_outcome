package com.larus.uaigc.createpage.utils;

import com.bytedance.common.utility.NetworkUtils;
import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.bottom.core.y8;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.resource.access.ResourceMediaType;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.platform.model.upload.ResourceUploadInstantInfo;
import com.larus.uaigc.api.ReviewUgcImageApi;
import com.larus.uaigc.createpage.component.helper.AlbumHelperKt;
import com.larus.uaigc.helper.CreationResourceAccessUploader;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.uaigc.service.ICreationResourceAccessService;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ExceptionsKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import yc9.n1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class UgcUploadingSendMessageProcessor {
    public static final Set<String> a = null;
    public static final ConcurrentHashMap<String, Long> b = null;

    public static final class a {
    }

    public UgcUploadingSendMessageProcessor() {
    }

    static {
        a = Collections.synchronizedSet(new LinkedHashSet());
        b = new ConcurrentHashMap();
    }

    public final Object f(String r6, Continuation<? super Boolean> r7) {
        if ((r7 instanceof UgcUploadingSendMessageProcessor$ugcReviewImage$1) == false) goto L7;
        UgcUploadingSendMessageProcessor$ugcReviewImage$1 r0 = (UgcUploadingSendMessageProcessor$ugcReviewImage$1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
    L17:
        dm9.a.b r9 = (dm9.a) r8;
        boolean r10 = r9 instanceof dm9.a.b;
        if (r10 == false) goto L32;
        dm9.a.b r11 = r9;
        if (r11.a.isSuccess() == false) goto L32;
        ReviewUgcImageApi.c r12 = (ReviewUgcImageApi.c) r11.a.getData();
        if (r12 == null) goto L29;
        Integer r13 = r12.a();
        if (r13 == null) goto L29;
        if (r13.intValue() != 3) goto L29;
        boolean r14 = true;
    L30:
        if (r14 == false) goto L32;
        return Boxing.boxBoolean(false);
    L29:
        r14 = false;
    L32:
        if (r10 == true) goto L37;
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L37;
        return null;
    L37:
        return Boxing.boxBoolean(true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        ReviewUgcImageApi.Companion r15 = ReviewUgcImageApi.a;
        UgcUploadingSendMessageProcessor$ugcReviewImage$checkResult$1 r4 = new UgcUploadingSendMessageProcessor$ugcReviewImage$checkResult$1(r6, null);
        r0.label = 1;
        r15.getClass();
        r8 = ReviewUgcImageApi.Companion.a(r4, r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new UgcUploadingSendMessageProcessor$ugcReviewImage$1(this, r7);
        goto L8
    }

    public static void e(String r27, NestedFileContent r28, Long r29, String r30) {
        if (r29 == null) goto L82;
        long r0 = r29.longValue();
        if (r28 == null) goto L6;
        List r3 = r28.getEntities();
    L7:
        if (r3 != null) goto L9;
        r3 = CollectionsKt.emptyList();
    L9:
        Iterator r4 = r3.iterator();
        long r9 = 0;
        long r11 = 0;
        int r8 = 0;
    L11:
        if (r4.hasNext() == false) goto L61;
        UplinkFileEntity r13 = (UplinkFileEntity) r4.next();
        String r15 = r13.getFileIdentifier();
        if (r15 == null) goto L11;
        if (r15.length() <= 0) goto L17;
        boolean r16 = true;
    L18:
        if (r16 == true) goto L21;
        r15 = null;
    L21:
        if (r15 == null) goto L11;
        UplinkEntityContent r14 = r13.getUplinkEntityContent();
        if (r14 == null) goto L33;
        UplinkFileInfo r17 = r14.getUplinkFileInfo();
        if (r17 == null) goto L33;
        Integer r18 = r17.getFileType();
        int r2 = FileType.FileTypeVideo.getValue();
        if (r18 == null) goto L33;
        if (r18.intValue() != r2) goto L33;
        boolean r5 = true;
    L34:
        if (r5 == false) goto L36;
        ResourceMediaType r19 = ResourceMediaType.VIDEO;
    L37:
        if (r5 == false) goto L39;
        com.larus.bmhome.resource.access.x r110 = com.larus.uaigc.service.f.c;
    L40:
        com.larus.bmhome.resource.access.x r111 = r110;
        ICreationResourceAccessService.Companion r6 = ICreationResourceAccessService.a;
        if (r5 == false) goto L43;
        String r7 = "creation_video";
    L44:
        com.larus.bmhome.resource.access.z r10 = r6.d(r15, r111, r19, r7);
        if (r10 == null) goto L57;
        Long r12 = Long.valueOf(r10.e);
        long r112 = r12.longValue();
        if (r112 > 0) goto L49;
    L51:
        boolean r113 = false;
    L52:
        if (r113 == true) goto L55;
        r12 = null;
    L55:
        if (r12 == null) goto L57;
        long r114 = r0 - r12.longValue();
    L59:
        if (r114 <= 0) goto L11;
        r8 = r8 + 1;
        r9 = r9 + r114;
        r11 = Math.max(r11, r114);
        goto L11
    L49:
        if (r112 >= r0) goto L51;
        r113 = true;
    L57:
        r114 = 0;
        goto L59
    L43:
        r7 = null;
        goto L44
    L39:
        r110 = com.larus.uaigc.service.f.a;
        goto L40
    L36:
        r19 = ResourceMediaType.IMAGE;
    L33:
        r5 = false;
        goto L34
    L17:
        r16 = false;
        goto L18
    L61:
        int r20 = r3.size();
        if (r8 <= 0) goto L64;
        boolean r23 = true;
    L65:
        CreationResourceAccessUploader r21 = CreationResourceAccessUploader.a;
        ResourceMediaType r115 = ResourceMediaType.FILE;
        long r22 = System.currentTimeMillis() - r0;
        Pair[] r1 = new Pair[2];
        com.larus.uaigc.helper.f.a.getClass();
        r1[0] = TuplesKt.to("pipeline_enabled", String.valueOf(com.larus.uaigc.helper.f.a()));
        if (r28 == null) goto L70;
        List r24 = r28.getEntities();
        if (r24 == null) goto L70;
        int r25 = r24.size();
    L71:
        r1[1] = TuplesKt.to("entity_count", String.valueOf(r25));
        CreationResourceAccessUploader.j(r27, null, r115, r30, r22, r23, "ugc_uploading_send", MapsKt.plus(MapsKt.mapOf(r1), MapsKt.mapOf(new Pair[]{TuplesKt.to("resource_entity_count", String.valueOf(r20)), TuplesKt.to("reuse_entity_count", String.valueOf(r8)), TuplesKt.to("has_reused_task", String.valueOf(r23)), TuplesKt.to("send_wait_estimated_saved_ms", String.valueOf(r9)), TuplesKt.to("send_wait_max_saved_ms", String.valueOf(r11))})), Long.valueOf(r9));
        return;
    L70:
        r25 = 0;
        goto L71
    L64:
        r23 = false;
        goto L65
    L6:
        r3 = null;
        goto L7
    }

    public final Object d(UplinkFileEntity r11, String r12, String r13, String r14, Continuation<? super Boolean> r15) {
        if ((r15 instanceof UgcUploadingSendMessageProcessor$preHandleV2Review$1) == false) goto L7;
        UgcUploadingSendMessageProcessor$preHandleV2Review$1 r0 = (UgcUploadingSendMessageProcessor$preHandleV2Review$1) r15;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r16);
    L17:
        dm9.a.b r17 = (dm9.a) r16;
        if ((r17 instanceof dm9.a.b) == true) goto L20;
    L22:
        r4 = false;
    L24:
        return Boxing.boxBoolean(r4);
    L20:
        if (r17.a.isSuccess() == false) goto L22;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        ReviewUgcImageApi.Companion r18 = ReviewUgcImageApi.a;
        UgcUploadingSendMessageProcessor$preHandleV2Review$checkResult$1 r5 = new UgcUploadingSendMessageProcessor$preHandleV2Review$checkResult$1(r11, r13, r14, r12, null);
        r0.label = 1;
        r18.getClass();
        r16 = ReviewUgcImageApi.Companion.a(r5, r0);
        if (r16 != r2) goto L17;
        return r2;
    L7:
        r0 = new UgcUploadingSendMessageProcessor$preHandleV2Review$1(this, r15);
        goto L8
    }

    public static final Object b(UgcUploadingSendMessageProcessor r9, String r10, UplinkFileEntity r11, String r12, String r13, String r14, boolean r15, Continuation r16) {
        r9.getClass();
        if (r15 == false) goto L50;
        String r1 = null;
        if (r11 == null) goto L7;
        String r0 = r11.getInstantUploadInfoJson();
    L8:
        boolean r3 = false;
        if (r0 != null) goto L11;
    L40:
        ResourceUploadInstantInfo r2 = null;
    L41:
        if (r2 == null) goto L43;
        r3 = Intrinsics.areEqual(r2.getPreQueryHit(), Boxing.boxBoolean(true));
    L43:
        if (r3 == false) goto L50;
        com.larus.uaigc.helper.f.a.getClass();
        if (Intrinsics.areEqual(com.larus.uaigc.helper.f.b().b(), Boxing.boxBoolean(true)) == false) goto L50;
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("[reviewAttachment] skip pre_handle on instant hit, identifier=");
        if (r11 == null) goto L49;
        r1 = r11.getFileIdentifier();
    L49:
        r5.append(r1);
        r4.i("NestedFileSendMessageProcessor", r5.toString());
        return Boxing.boxBoolean(true);
    L11:
        if (r0.length() <= 0) goto L13;
        boolean r6 = true;
    L14:
        if (r6 == true) goto L17;
        r0 = null;
    L17:
        if (r0 == null) goto L40;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L34
        zd9.h r8 = zd9.h.a;     // Catch: Throwable -> L34
        if (StringsKt.isBlank(r0) == false) goto L56;
    L31:
        Object r17 = null;
    L32:
        Object r18 = Result.constructor-impl((ResourceUploadInstantInfo) r17);     // Catch: Throwable -> L34
    L37:
        if (Result.isFailure-impl(r18) == false) goto L39;
        r18 = null;
    L39:
        r2 = (ResourceUploadInstantInfo) r18;
        goto L41
    L56:
        r8.getClass();     // Catch: Throwable -> L24
        r17 = Result.constructor-impl(zd9.h.b.fromJson(r0, new s().getType()));     // Catch: Throwable -> L24
    L26:
        Throwable r19 = Result.exceptionOrNull-impl(r17);     // Catch: Throwable -> L34
        if (r19 == null) goto L30;
        com.larus.im.internal.delegate.c0 r20 = com.larus.im.internal.delegate.c0.b;     // Catch: Throwable -> L34
        StringBuilder r21 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L34
        Intrinsics.checkNotNullParameter(r19, "<this>");     // Catch: Throwable -> L34
        r21.append(ExceptionsKt.stackTraceToString(r19));     // Catch: Throwable -> L34
        r20.e("GsonHolder", r21.toString());     // Catch: Throwable -> L34
    L30:
        if (Result.isFailure-impl(r17) == false) goto L32;
    L24:
        th = move-exception;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L34
        r17 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L37
    L13:
        r6 = false;
        goto L14
    L7:
        r0 = null;
    L50:
        if (r15 == false) goto L53;
        return r9.d(r11, r12, r13, r14, r16);
    L53:
        return r9.f(r10, r16);
    }

    public static final Object a(UgcUploadingSendMessageProcessor r55, AtomicInteger r56, AtomicBoolean r57, ICoreInputAbility.OnSendParams r58, Map r59, String r60, String r61, Function3 r62, Continuation r63) {
        String r0 = r60;
        r55.getClass();
        if ((r63 instanceof UgcUploadingSendMessageProcessor$checkSendMessage$1) == false) goto L7;
        UgcUploadingSendMessageProcessor$checkSendMessage$1 r2 = (UgcUploadingSendMessageProcessor$checkSendMessage$1) r63;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        CustomMultiAttachmentInfo r7 = null;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        Function3 r6 = (Function3) r2.L$4;
        String r8 = (String) r2.L$3;
        String r9 = (String) r2.L$2;
        Map r10 = (Map) r2.L$1;
        ICoreInputAbility.OnSendParams r11 = (ICoreInputAbility.OnSendParams) r2.L$0;
        ResultKt.throwOnFailure(r1);
        Map r12 = r10;
        ICoreInputAbility.OnSendParams r13 = r11;
        Object r14 = r1;
        Function3 r15 = r6;
        r0 = r9;
    L24:
        NestedFileContent r16 = (NestedFileContent) r14;
        if (r16 != null) goto L31;
        CustomMultiAttachmentInfo r17 = r13.getCustomMultiAttachment();
        if (r17 == null) goto L29;
        r16 = r17.getNestedFileContent();
    L30:
        FLogger.a.w("NestedFileSendMessageProcessor", "[checkSendMessage] cache snapshot missing, fallback to send snapshot, localMessageId=" + r0);
        goto L31
    L29:
        r16 = null;
    L31:
        FLogger r18 = FLogger.a;
        StringBuilder r19 = new StringBuilder("[checkSendMessage] finalNestedFileContent entities count: ");
        if (r16 == null) goto L36;
        List r110 = r16.getEntities();
        if (r110 == null) goto L36;
        Integer r111 = Boxing.boxInt(r110.size());
    L37:
        r19.append(r111);
        r18.i("NestedFileSendMessageProcessor", r19.toString());
        Long r20 = b.remove(r0);
        if (r16 == null) goto L40;
        List r112 = r16.getEntities();
    L41:
        if (r112 != null) goto L43;
        r112 = CollectionsKt.emptyList();
    L43:
        List r113 = r112;
        if ((r113 instanceof Collection) == true) goto L46;
    L48:
        Iterator r114 = r113.iterator();
    L50:
        if (r114.hasNext() == false) goto L62;
        UplinkFileEntity r115 = (UplinkFileEntity) r114.next();
        if (n1.d(r115) == false) goto L59;
        Integer r116 = r115.getFileReviewStatus();
        int r117 = FileReviewState.NOT_COMPLIANT.getValue();
        if (r116 == null) goto L59;
        if (r116.intValue() != r117) goto L59;
        boolean r118 = true;
    L60:
        if (r118 == false) goto L50;
        boolean r119 = true;
    L63:
        if (r119 == false) goto L78;
        FLogger.a.i("NestedFileSendMessageProcessor", "[checkSendMessage] image review rejected, mark SEND_COMPLIANT");
        String[] r21 = {r0, r8};
        ArrayList r22 = new ArrayList();
        int r23 = 0;
    L65:
        if (r23 >= 2) goto L73;
        String r24 = r21[r23];
        if (r24.length() <= 0) goto L69;
        boolean r120 = true;
    L70:
        if (r120 == false) goto L72;
        r22.add(r24);
    L72:
        r23 = r23 + 1;
        goto L65
    L69:
        r120 = false;
        goto L70
    L73:
        Iterator r25 = r22.iterator();
    L75:
        if (r25.hasNext() == false) goto L77;
        String r26 = (String) r25.next();
        RepoDispatcherDelegate r27 = RepoDispatcherDelegate.b;
        r27.e().r1(r26, new q());
        r27.e().t1(r26, 14);
        goto L75
    L77:
        e(r0, r16, r20, "review_un_pass");
        return Unit.INSTANCE;
    L78:
        NestedFileContent r28 = CreationNoWatermarkManager.a.b0(r16);
        if (r28 != null) goto L81;
        NestedFileContent r121 = r16;
    L82:
        CreationMediaAttachmentExtUpdater.a.getClass();
        CreationMediaAttachmentExtUpdater.c(r12, r121);
        Map r29 = MapsKt.toMap(r12);
        CustomMultiAttachmentInfo r122 = r13.getCustomMultiAttachment();
        if (r122 == null) goto L85;
        r7 = CustomMultiAttachmentInfo.copy$default(r122, null, null, r121, false, false, false, false, null, 251, null);
    L85:
        ICoreInputAbility.OnSendParams r30 = ICoreInputAbility.OnSendParams.copy$default(r13, null, null, null, null, null, r29, null, null, 0, false, null, false, false, false, null, null, null, null, false, null, null, null, null, null, null, null, r7, null, null, null, null, null, null, -67108897, 1, null);
        FLogger r31 = FLogger.a;
        r31.i("NestedFileSendMessageProcessor", "[checkSendMessage] Calling originalLogic to send message");
        r15.invoke(r30, r0, r8);
        e(r0, r16, r20, "actual_send");
        r31.i("NestedFileSendMessageProcessor", "[checkSendMessage] Message sent");
        return Unit.INSTANCE;
    L81:
        r121 = r28;
    L59:
        r118 = false;
    L62:
        r119 = false;
        goto L63
    L46:
        if (r113.isEmpty() == false) goto L48;
    L40:
        r112 = null;
    L36:
        r111 = null;
        goto L37
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        int r32 = r56.get();
        FLogger r33 = FLogger.a;
        r33.i("NestedFileSendMessageProcessor", "[checkSendMessage] handlingFileCount: " + r32);
        if (r32 <= 0) goto L18;
        r33.i("NestedFileSendMessageProcessor", "[checkSendMessage] Still have " + r32 + " files processing, waiting...");
        return Unit.INSTANCE;
    L18:
        if (r57.compareAndSet(false, true) == true) goto L20;
        r33.i("NestedFileSendMessageProcessor", "[checkSendMessage] Message already sent, skip duplicate call");
        return Unit.INSTANCE;
    L20:
        r33.i("NestedFileSendMessageProcessor", "[checkSendMessage] All files processed, preparing to send message");
        MainCoroutineDispatcher r34 = Dispatchers.getMain();
        UgcUploadingSendMessageProcessor$checkSendMessage$cachedNestedFileContent$1 r35 = new UgcUploadingSendMessageProcessor$checkSendMessage$cachedNestedFileContent$1(r0, null);
        r13 = r58;
        r2.L$0 = r13;
        r12 = r59;
        r2.L$1 = r12;
        r2.L$2 = r0;
        r2.L$3 = r61;
        r2.L$4 = r62;
        r2.label = 1;
        Object r36 = BuildersKt.withContext(r34, r35, r2);
        if (r36 == r4) goto L99;
        r14 = r36;
        r8 = r61;
        r15 = r62;
        goto L24
    L99:
        return r4;
    L7:
        r2 = new UgcUploadingSendMessageProcessor$checkSendMessage$1(r55, r63);
        goto L8
    }

    public static final void c(AtomicBoolean r13, String r14, AtomicInteger r15, UgcUploadingSendMessageProcessor r16, y8 r17, AtomicBoolean r18, ICoreInputAbility.OnSendParams r19, Map r20, Ref.ObjectRef r21, Ref.ObjectRef r22, Function3 r23, String r24) {
        if (r13.compareAndSet(false, true) == true) goto L5;
        FLogger.a.i("NestedFileSendMessageProcessor", "[" + r24 + "] skip duplicate finish, identifier: " + r14);
        return;
    L5:
        a.remove(r14);
        int r2 = r15.decrementAndGet();
        FLogger.a.i("NestedFileSendMessageProcessor", "[" + r24 + "] handlingFileCount decremented, remaining: " + r2 + ", identifier: " + r14);
        AlbumHelperKt.g(GlobalScope.INSTANCE, null, new UgcUploadingSendMessageProcessor$uploadBeforeSendNestedFiles$2$1$3$finishImageProcessing$1(r16, r17, r15, r18, r19, r20, r21, r22, r23, null), 3);
    }
}
