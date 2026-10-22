package com.larus.uaigc.createpage.component.sendmessage;

import android.net.Uri;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.chat.CustomMultiAttachmentInfo;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.resource.access.ResourceMediaType;
import com.larus.bmhome.utils.RegisterHelper;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.FileType;
import com.larus.im.bean.message.Image;
import com.larus.im.bean.message.ImageObj;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkEntityContent;
import com.larus.im.bean.message.UplinkEntityType;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.im.bean.message.VideoExtension;
import com.larus.platform.api.creation.IBachDetectCenterAbility;
import com.larus.platform.model.upload.ResourceUploadInstantInfo;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.api.ReviewUgcImageApi;
import com.larus.uaigc.bean.createpage.CreationSendMessageConfig;
import com.larus.uaigc.createpage.component.helper.AlbumHelperKt;
import com.larus.uaigc.createpage.utils.CreationMediaAttachmentExtUpdater;
import com.larus.uaigc.helper.CreationResourceAccessUploader;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.uaigc.service.ICreationResourceAccessService;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
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
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.MainCoroutineDispatcher;
import yc9.l1;
import yc9.n1;
import yc9.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CreationMultiAttachmentProcessor {
    public static final Set<String> b = null;
    public static final ConcurrentHashMap<String, Long> c = null;
    public final Lazy a;

    public static final class a {
        public a() {
        }

        public static void a(String r1) {
            if (r1 != null) goto L4;
            return;
        L4:
            if (r1.length() <= 0) goto L6;
            boolean r0 = true;
        L7:
            if (r0 == true) goto L10;
            r1 = null;
        L10:
            if (r1 == null) goto L14;
            CreationMultiAttachmentProcessor.b.add(r1);
            return;
        L14:
            return;
        L6:
            r0 = false;
            goto L7
        }

        public static void b(String r1) {
            if (r1 != null) goto L4;
            return;
        L4:
            if (r1.length() <= 0) goto L6;
            boolean r0 = true;
        L7:
            if (r0 == true) goto L10;
            r1 = null;
        L10:
            if (r1 == null) goto L14;
            CreationMultiAttachmentProcessor.b.remove(r1);
            return;
        L14:
            return;
        L6:
            r0 = false;
            goto L7
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CreationPendingResourceInputType.values().length];
            r0[CreationPendingResourceInputType.LOCAL_PATH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[CreationPendingResourceInputType.CONTENT_URI.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[CreationPendingResourceInputType.FILE_URI.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[CreationPendingResourceInputType.TOS_KEY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[CreationPendingResourceInputType.REMOTE_URL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[CreationPendingResourceInputType.INVALID.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002¸\u0006\u0000"}, d2 = {"com/larus/im/internal/core/util/GsonHolder$fromJson$1$1", "Lcom/google/gson/reflect/TypeToken;", "runtime_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final class c extends TypeToken<ResourceUploadInstantInfo> {
        public c() {
        }
    }

    static {
        new a();
        b = Collections.synchronizedSet(new LinkedHashSet());
        c = new ConcurrentHashMap();
    }

    public CreationMultiAttachmentProcessor() {
        this.a = LazyKt.lazy(new q());
    }

    public static Map h(CreationSendMessageConfig r3) {
        Map<String, String> r0 = r3.getActionBarInstructionMap();
        if (r0 != null) goto L5;
        r0 = MapsKt.emptyMap();
    L5:
        Map r1 = MapsKt.toMutableMap(r0);
        Map<String, String> r2 = r3.getMessageExtMap();
        if (r2 != null) goto L8;
        r2 = MapsKt.emptyMap();
    L8:
        r1.putAll(r2);
        CharSequence r4 = (CharSequence) r1.get("enter_method_trace");
        if (r4 != null) goto L11;
    L14:
        boolean r5 = true;
    L15:
        if (r5 == false) goto L24;
        CustomMultiAttachmentInfo r6 = r3.getCustomMultiAttachmentInfo();
        if (r6 == null) goto L20;
        String r7 = r6.getEnterMethod();
        if (r7 == null) goto L20;
    L23:
        r1.put("enter_method_trace", r7);
    L20:
        r7 = r3.getEnterMethod();
        if (r7 != null) goto L23;
        r7 = "";
    L24:
        return r1;
    L11:
        if (r4.length() == 0) goto L14;
        r5 = false;
        goto L15
    }

    public static boolean i(NestedFileContent r6) {
        List r7 = r6.getEntities();
        Boolean r1 = null;
        if (r7 == null) goto L23;
        List r3 = r7;
        if ((r3 instanceof Collection) == true) goto L7;
    L9:
        Iterator r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L21;
        Integer r5 = ((UplinkFileEntity) r4.next()).getUpLinkStatus();
        int r8 = UpLinkState.SUCCESS.getValue();
        if (r5 != null) goto L16;
    L17:
        boolean r9 = true;
    L19:
        if (r9 == false) goto L11;
        boolean r10 = true;
    L22:
        Boolean r11 = Boolean.valueOf(r10);
    L24:
        if (r7 == null) goto L44;
        List r12 = r7;
        if ((r12 instanceof Collection) == true) goto L28;
    L30:
        Iterator r13 = r12.iterator();
    L32:
        if (r13.hasNext() == false) goto L42;
        Integer r2 = ((UplinkFileEntity) r13.next()).getFileReviewStatus();
        int r14 = FileReviewState.ACCESS.getValue();
        if (r2 != null) goto L37;
    L38:
        boolean r15 = true;
    L40:
        if (r15 == false) goto L32;
        boolean r16 = true;
    L43:
        r1 = Boolean.valueOf(r16);
        goto L44
    L37:
        if (r2.intValue() != r14) goto L38;
        r15 = false;
    L42:
        r16 = false;
        goto L43
    L28:
        if (r12.isEmpty() == false) goto L30;
    L44:
        Boolean r17 = Boolean.TRUE;
        if (Intrinsics.areEqual(r11, r17) == false) goto L47;
        return false;
    L47:
        if (Intrinsics.areEqual(r1, r17) == true) goto L61;
        return true;
    L61:
        return false;
    L16:
        if (r5.intValue() != r8) goto L17;
        r9 = false;
    L21:
        r10 = false;
        goto L22
    L7:
        if (r3.isEmpty() == false) goto L9;
    L23:
        r11 = null;
        goto L24
    }

    public static ResourceUploadInstantInfo m(String r6) {
        Object r1 = null;
        if (r6 != null) goto L5;
        return null;
    L5:
        if (r6.length() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L11;
        r6 = null;
    L11:
        if (r6 == null) goto L41;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L28
        zd9.h r4 = zd9.h.a;     // Catch: Throwable -> L28
        if (StringsKt.isBlank(r6) == false) goto L38;
    L25:
        Object r7 = null;
    L26:
        Object r8 = Result.constructor-impl((ResourceUploadInstantInfo) r7);     // Catch: Throwable -> L28
    L31:
        if (Result.isFailure-impl(r8) == true) goto L35;
        r1 = r8;
    L35:
        return (ResourceUploadInstantInfo) r1;
    L38:
        r4.getClass();     // Catch: Throwable -> L18
        r7 = Result.constructor-impl(zd9.h.b.fromJson(r6, new c().getType()));     // Catch: Throwable -> L18
    L20:
        Throwable r5 = Result.exceptionOrNull-impl(r7);     // Catch: Throwable -> L28
        if (r5 == null) goto L24;
        com.larus.im.internal.delegate.c0 r9 = com.larus.im.internal.delegate.c0.b;     // Catch: Throwable -> L28
        StringBuilder r10 = new StringBuilder("fromJson failed, stack: ");     // Catch: Throwable -> L28
        Intrinsics.checkNotNullParameter(r5, "<this>");     // Catch: Throwable -> L28
        r10.append(ExceptionsKt.stackTraceToString(r5));     // Catch: Throwable -> L28
        r9.e("GsonHolder", r10.toString());     // Catch: Throwable -> L28
    L24:
        if (Result.isFailure-impl(r7) == false) goto L26;
    L18:
        th = move-exception;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L28
        r7 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    L41:
        return null;
    L7:
        r2 = false;
        goto L8
    }

    public static final com.larus.bmhome.resource.access.j0 g(CreationMultiAttachmentProcessor r7, s0 r8) {
        r7.getClass();
        switch(b.a[r8.getType().ordinal()]) {
            case 1: goto L18;
            case 2: goto L25;
            case 3: goto L8;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L19;
            default: goto L5;
        };
    L8:
        String r9 = UriProtector.parse(r8.b).getPath();
        if (r9 != null) goto L11;
        return null;
    L11:
        if ((!StringsKt.isBlank(r9)) == false) goto L13;
        String r2 = r9;
    L14:
        if (r2 != null) goto L24;
        return null;
    L24:
        return new com.larus.bmhome.resource.access.j0.b(r2, null, null, null, 30);
    L13:
        r2 = null;
        goto L14
    L19:
        return null;
    L5:
        throw new NoWhenBranchMatchedException();
    L20:
        return new com.larus.bmhome.resource.access.j0.c(r8.b);
    L21:
        return new com.larus.bmhome.resource.access.j0.d(r8.b);
    L25:
        return new com.larus.bmhome.resource.access.j0.a(r8.b);
    L18:
        return new com.larus.bmhome.resource.access.j0.b(r8.b, null, null, null, 30);
    }

    public final Object n(String r6, Continuation<? super Boolean> r7) {
        if ((r7 instanceof CreationMultiAttachmentProcessor$ugcReviewImage$1) == false) goto L7;
        CreationMultiAttachmentProcessor$ugcReviewImage$1 r0 = (CreationMultiAttachmentProcessor$ugcReviewImage$1) r7;
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
        CreationMultiAttachmentProcessor$ugcReviewImage$checkResult$1 r4 = new CreationMultiAttachmentProcessor$ugcReviewImage$checkResult$1(r6, null);
        r0.label = 1;
        r15.getClass();
        r8 = ReviewUgcImageApi.Companion.a(r4, r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new CreationMultiAttachmentProcessor$ugcReviewImage$1(this, r7);
        goto L8
    }

    public static final String e(CreationMultiAttachmentProcessor r3, String r4, String r5) {
        r3.getClass();
        String r6 = StringsKt.substringAfterLast(r4, '.', "");
        if ((!StringsKt.isBlank(r6)) == true) goto L6;
        r6 = null;
    L6:
        if (r6 != null) goto L16;
        if (r5 == null) goto L17;
        String r7 = StringsKt.substringBefore$default(r5, '?', null, 2, null);
        if (r7 == null) goto L18;
        String r8 = StringsKt.substringAfterLast(r7, '.', "");
        if (r8 != null) goto L13;
        return null;
    L13:
        if ((!StringsKt.isBlank(r8)) == true) goto L21;
        return null;
    L21:
        return r8;
    L18:
        return null;
    L17:
        return null;
    L16:
        return r6;
    }

    public final void l(CreationSendMessageConfig r33, String r34, String r35) {
        CustomMultiAttachmentInfo r1 = r33.getCustomMultiAttachmentInfo();
        if (r1 == null) goto L5;
        NestedFileContent r0 = r1.getNestedFileContent();
    L7:
        if (r1 == null) goto L186;
        if (r0 == null) goto L186;
        NestedFileContent r4 = CreationNoWatermarkManager.a.b0(r0);
        if (r4 != null) goto L13;
        r4 = r0;
    L13:
        ArrayList r15 = new ArrayList();
        Map r14 = h(r33);
        r14.put("content_source", "upload");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L80
        if (IBachDetectCenterAbility.a.b() == false) goto L82;
        CustomMultiAttachmentInfo r3 = r33.getCustomMultiAttachmentInfo();     // Catch: Throwable -> L80
        if (r3 == null) goto L75;
        NestedFileContent r5 = r3.getNestedFileContent();     // Catch: Throwable -> L80
        if (r5 == null) goto L75;
        List r6 = r5.getEntities();     // Catch: Throwable -> L80
        if (r6 == null) goto L75;
        Iterator r7 = r6.iterator();     // Catch: Throwable -> L80
        boolean r8 = false;
    L25:
        if (r7.hasNext() == false) goto L76;
        UplinkFileEntity r9 = (UplinkFileEntity) r7.next();     // Catch: Throwable -> L80
        Integer r10 = r9.getEntityType();     // Catch: Throwable -> L80
        int r11 = UplinkEntityType.EntityTypeImage.getValue();     // Catch: Throwable -> L80
        if (r10 == null) goto L25;
        if (r10.intValue() != r11) goto L25;
        UplinkEntityContent r12 = r9.getUplinkEntityContent();     // Catch: Throwable -> L80
        if (r12 == null) goto L39;
        Image r13 = r12.getUplinkImageInfo();     // Catch: Throwable -> L80
        if (r13 == null) goto L39;
        ImageObj r16 = r13.imageOri;     // Catch: Throwable -> L80
        if (r16 == null) goto L39;
        String r17 = r16.url;     // Catch: Throwable -> L80
    L40:
        UplinkEntityContent r18 = r9.getUplinkEntityContent();     // Catch: Throwable -> L80
        if (r18 == null) goto L45;
        Image r19 = r18.getUplinkImageInfo();     // Catch: Throwable -> L80
        if (r19 == null) goto L45;
        String r20 = r19.localResPath;     // Catch: Throwable -> L80
    L46:
        if (r17 != null) goto L48;
    L51:
        boolean r21 = true;
    L52:
        if (r21 == false) goto L54;
    L56:
        if (r20 != null) goto L58;
    L61:
        boolean r22 = true;
    L62:
        if (r22 == true) goto L25;
        PolarisFileWrapper r23 = new PolarisFileWrapper(r20);     // Catch: Throwable -> L80
        if (r23.exists() == false) goto L25;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L67
        Object r25 = Result.constructor-impl(IBachDetectCenterAbility.a.c(Uri.fromFile(r23), true));     // Catch: Throwable -> L67
    L70:
        if (Result.isFailure-impl(r25) == false) goto L73;
        r25 = null;
    L73:
        if (Intrinsics.areEqual((Boolean) r25, Boolean.TRUE) == false) goto L25;
    L74:
        r8 = true;
    L67:
        th = move-exception;
        Result.Companion r26 = Result.Companion;     // Catch: Throwable -> L80
        r25 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L80
        goto L70
    L58:
        if (r20.length() == 0) goto L61;
        r22 = false;
        goto L62
    L54:
        if (Intrinsics.areEqual(IBachDetectCenterAbility.a.c(UriProtector.parse(r17), true), Boolean.TRUE) == false) goto L56;
    L48:
        if (r17.length() == 0) goto L51;
        r21 = false;
    L45:
        r20 = null;
    L39:
        r17 = null;
    L76:
        if (r8 == false) goto L78;
        r14.put(IAIChatUgcAIGCService.a.F0(), "1");     // Catch: Throwable -> L80
    L78:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L80
    L75:
        r8 = false;
    L82:
        v0.g(r4);
        if (v0.h(r4) <= 0) goto L141;
        if (r34 != null) goto L96;
        String r27 = r1.getLocalMsgId();
        if (r27 != null) goto L88;
    L93:
        r27 = null;
    L94:
        if (r27 != null) goto L97;
        int r28 = wf9.b.a;
        r27 = com.flow.kmp.common.util.i.a();
    L97:
        NestedFileContent r29 = r4;
        String r30 = r27;
        Map r31 = r14;
        ArrayList r110 = r15;
        r110.add(new ai8.f(r29, r30, null, null, r14, r33.getBizExtMap(), false, null, r33.getChatPageContext(), null, 716));
        String r32 = r33.getBotId();
        String r36 = r33.getCvsId();
        wc9.e r37 = r33.getConversation();
        if (r37 == null) goto L100;
        String r38 = r37.B;
    L101:
        List r39 = r4.getEntities();
        if (r39 == null) goto L142;
        Iterator r40 = r39.iterator();
    L105:
        if (r40.hasNext() == false) goto L142;
        UplinkFileEntity r41 = (UplinkFileEntity) r40.next();
        UplinkEntityContent r42 = r41.getUplinkEntityContent();
        if (r42 == null) goto L111;
        Image r43 = r42.getUplinkImageInfo();
        if (r43 == null) goto L111;
        String r210 = r43.key;
    L112:
        if (r210 == null) goto L105;
        if (n1.d(r41) == false) goto L105;
        Integer r44 = r41.getFileReviewStatus();
        int r45 = FileReviewState.ACCESS.getValue();
        if (r44 == null) goto L121;
        if (r44.intValue() == r45) goto L105;
    L121:
        if (r1.getOverrideSinceId() == false) goto L123;
        String r211 = FlowResourceScene.SpringMainVenue.getSceneIDForDoubao();
    L124:
        ResourceUploadInstantInfo r212 = m(r41.getInstantUploadInfoJson());
        String r46 = l1.g(r41);
        if (r46 != null) goto L127;
    L130:
        boolean r111 = true;
    L131:
        if (r111 == true) goto L136;
        if (r212 == null) goto L134;
        boolean r47 = Intrinsics.areEqual(r212.getPreQueryHit(), Boolean.TRUE);
    L135:
        if (r47 == false) goto L105;
    L134:
        r47 = false;
    L136:
        int r48 = RegisterHelper.a;
        String r213 = r41.getFileIdentifier();
        UplinkEntityContent r49 = r41.getUplinkEntityContent();
        if (r49 == null) goto L139;
        Image r214 = r49.getUplinkImageInfo();
    L140:
        RegisterHelper.b(r27, r32, r36, r210, r211, r213, r212, r214, r38);
        goto L105
    L139:
        r214 = null;
        goto L140
    L127:
        if (r46.length() == 0) goto L130;
        r111 = false;
        goto L131
    L123:
        r211 = "";
    L111:
        r210 = null;
    L142:
        String r50 = r33.getContent();
        if (r50 != null) goto L146;
        r50 = "";
    L146:
        if (r50.length() <= 0) goto L148;
        boolean r112 = true;
    L149:
        if (r112 == false) goto L156;
        if (r35 != null) goto L153;
        int r51 = wf9.b.a;
        String r113 = com.flow.kmp.common.util.i.a();
    L154:
        String r114 = r50;
        Map r215 = r31;
        r110.add(new ai8.h(r114, r113, null, null, r215, r33.getBizExtMap(), false, false, r33.getChatPageContext(), null, 716));
        goto L156
    L153:
        r113 = r35;
    L156:
        if (r110.isEmpty() == false) goto L159;
        FLogger.a.e("CreationMultiAttachmentProcessor", "sendMultiAttachmentsWithoutCache strategyList is empty");
        return;
    L159:
        ConcurrentHashMap r52 = ko8.b.a;
        String r53 = r33.getCreationSendTraceId();
        ArrayList r54 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator r55 = r110.iterator();
    L161:
        if (r55.hasNext() == false) goto L163;
        r54.add(((ic8.w) r55.next()).b());
        goto L161
    L163:
        ko8.b.b(r53, r54);
        wc9.e r56 = r33.getConversation();
        if (r56 != null) goto L167;
        FLogger.a.e("CreationMultiAttachmentProcessor", "sendMultiAttachmentsWithoutCache conversation is null");
        return;
    L167:
        com.larus.uaigc.createpage.component.sendmessage.a r57 = (com.larus.uaigc.createpage.component.sendmessage.a) this.a.getValue();
        String r58 = r33.getTxtScene();
        if (r58 != null) goto L172;
        r58 = r33.getScene();
        if (r58 != null) goto L172;
        String r59 = "";
    L173:
        ArrayList r60 = r110;
        if (com.larus.uaigc.createpage.component.sendmessage.a.c(r57, r56, r59, r60, r1.getFromScene(), "creation_send_multi_attachment", 48) == true) goto L185;
        FLogger.a.e("CreationMultiAttachmentProcessor", "sendMultiAttachmentsWithoutCache send failed");
        ArrayList r61 = new ArrayList();
        Iterator r62 = r110.iterator();
    L177:
        if (r62.hasNext() == false) goto L181;
        String r63 = ((ic8.w) r62.next()).b();
        if (r63 == null) goto L177;
        r61.add(r63);
        goto L177
    L181:
        Iterator r64 = r61.iterator();
    L183:
        if (r64.hasNext() == false) goto L227;
        String r65 = (String) r64.next();
        RepoDispatcherDelegate.b.e().t1(r65, 12);
        goto L183
    L227:
        return;
    L185:
        return;
    L172:
        r59 = r58;
        goto L173
    L148:
        r112 = false;
        goto L149
    L100:
        r38 = null;
        goto L101
    L88:
        if (r27.length() <= 0) goto L90;
        boolean r66 = true;
    L91:
        if (r66 == false) goto L93;
    L90:
        r66 = false;
        goto L91
    L96:
        r27 = r34;
        goto L97
    L141:
        r31 = r14;
        r110 = r15;
    L80:
        th = move-exception;
        Result.Companion r67 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L186:
        FLogger.a.e("CreationMultiAttachmentProcessor", "sendMultiAttachmentsWithoutCache missing multi attachment");
        return;
    L5:
        r0 = null;
        goto L7
    }

    public static void k(String r27, NestedFileContent r28, Long r29, String r30) {
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
        CreationResourceAccessUploader.j(r27, null, r115, r30, r22, r23, "creation_multi_attachment_send", MapsKt.plus(MapsKt.mapOf(r1), MapsKt.mapOf(new Pair[]{TuplesKt.to("resource_entity_count", String.valueOf(r20)), TuplesKt.to("reuse_entity_count", String.valueOf(r8)), TuplesKt.to("has_reused_task", String.valueOf(r23)), TuplesKt.to("send_wait_estimated_saved_ms", String.valueOf(r9)), TuplesKt.to("send_wait_max_saved_ms", String.valueOf(r11))})), Long.valueOf(r9));
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

    public static final mr9.h b(CreationMultiAttachmentProcessor r33, String r34, Uri r35, String r36, VideoExtension r37) {
        r33.getClass();
        ResourceCenter.a.getClass();
        boolean r0 = ResourceCenter.d(r34);
        int r1 = UplinkEntityType.EntityTypeFile.getValue();
        Integer r6 = Integer.valueOf(FileType.FileTypeVideo.getValue());
        VideoExtension r2 = new VideoExtension(null, null, null, null, null, null, null, null, null, null, 1023, null);
        r2.setPath(r36);
        if (r37 == null) goto L5;
        Image r9 = r37.getCover();
    L6:
        r2.setCover(r9);
        if (r37 == null) goto L10;
        int r10 = r37.getWidth();
        if (r10 == null) goto L10;
    L11:
        r2.setWidth(r10);
        if (r37 == null) goto L15;
        int r11 = r37.getHeight();
        if (r11 == null) goto L15;
    L16:
        r2.setHeight(r11);
        r2.setSource("upload");
        Unit r12 = Unit.INSTANCE;
        return new mr9.h(r0, null, new UplinkFileEntity(Integer.valueOf(r1), new UplinkEntityContent(new UplinkFileInfo(null, null, null, r6, null, null, r2, null, null, null, 951, null), null, 2, null), r34, null, null, null, null, null, null, false, r35, null, null, null, 15352, null), 26);
    L15:
        r11 = 0;
    L10:
        r10 = 0;
        goto L11
    L5:
        r9 = null;
        goto L6
    }

    public final Object j(UplinkFileEntity r11, String r12, String r13, String r14, Continuation<? super Boolean> r15) {
        if ((r15 instanceof CreationMultiAttachmentProcessor$preHandleV2Review$1) == false) goto L7;
        CreationMultiAttachmentProcessor$preHandleV2Review$1 r0 = (CreationMultiAttachmentProcessor$preHandleV2Review$1) r15;
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
        CreationMultiAttachmentProcessor$preHandleV2Review$checkResult$1 r5 = new CreationMultiAttachmentProcessor$preHandleV2Review$checkResult$1(r11, r13, r14, r12, null);
        r0.label = 1;
        r18.getClass();
        r16 = ReviewUgcImageApi.Companion.a(r5, r0);
        if (r16 != r2) goto L17;
        return r2;
    L7:
        r0 = new CreationMultiAttachmentProcessor$preHandleV2Review$1(this, r15);
        goto L8
    }

    public static final Object f(CreationMultiAttachmentProcessor r14, CreationSendMessageConfig r15, UplinkFileEntity r16, CustomMultiAttachmentInfo r17, String r18, String r19, Continuation r20) {
        r14.getClass();
        if ((r20 instanceof CreationMultiAttachmentProcessor$reviewUploadedImage$1) == false) goto L7;
        CreationMultiAttachmentProcessor$reviewUploadedImage$1 r2 = (CreationMultiAttachmentProcessor$reviewUploadedImage$1) r20;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        CreationMultiAttachmentProcessor$reviewUploadedImage$1 r8 = r2;
        Object r1 = r8.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r8.label;
        if (r4 == 0) goto L18;
        if (r4 == 1) goto L17;
        if (r4 == 2) goto L16;
        if (r4 != 3) goto L15;
        ResultKt.throwOnFailure(r1);
    L65:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        String r0 = (String) r8.L$1;
        UplinkFileEntity r5 = (UplinkFileEntity) r8.L$0;
        ResultKt.throwOnFailure(r1);
    L55:
        Boolean r6 = (Boolean) r1;
        if (Intrinsics.areEqual(r6, Boxing.boxBoolean(false)) == false) goto L59;
        r5.setFileReviewStatus(Boxing.boxInt(FileReviewState.NOT_COMPLIANT.getValue()));
    L61:
        MainCoroutineDispatcher r7 = Dispatchers.getMain();
        CreationMultiAttachmentProcessor$reviewUploadedImage$3 r10 = new CreationMultiAttachmentProcessor$reviewUploadedImage$3(r0, r5, null);
        r8.L$0 = null;
        r8.L$1 = null;
        r8.label = 3;
        if (BuildersKt.withContext(r7, r10, r8) != r9) goto L65;
        return r9;
    L59:
        if (Intrinsics.areEqual(r6, Boxing.boxBoolean(true)) == false) goto L61;
        r5.setFileReviewStatus(Boxing.boxInt(FileReviewState.ACCESS.getValue()));
        goto L61
    L17:
        ResultKt.throwOnFailure(r1);
    L66:
        return Unit.INSTANCE;
    L18:
        ResultKt.throwOnFailure(r1);
        if (r17.getOnlyRegisterCheck() == false) goto L24;
        r16.setFileReviewStatus(Boxing.boxInt(FileReviewState.PROCESSING.getValue()));
        MainCoroutineDispatcher r11 = Dispatchers.getMain();
        CreationMultiAttachmentProcessor$reviewUploadedImage$2 r12 = new CreationMultiAttachmentProcessor$reviewUploadedImage$2(r18, r16, null);
        r8.label = 1;
        if (BuildersKt.withContext(r11, r12, r8) != r9) goto L66;
        return r9;
    L24:
        wc9.e r13 = r15.getConversation();
        if (r13 == null) goto L27;
        String r21 = r13.a;
    L28:
        if (r13 == null) goto L30;
        String r22 = r13.B;
    L31:
        boolean r23 = r17.getPreHandleV2Check();
        r8.L$0 = r16;
        r8.L$1 = r18;
        r8.label = 2;
        if (r23 == false) goto L48;
        if (r16 == null) goto L35;
        String r24 = r16.getInstantUploadInfoJson();
    L36:
        ResourceUploadInstantInfo r25 = m(r24);
        if (r25 == null) goto L39;
        boolean r26 = Intrinsics.areEqual(r25.getPreQueryHit(), Boxing.boxBoolean(true));
    L40:
        if (r26 == false) goto L48;
        com.larus.uaigc.helper.f.a.getClass();
        if (Intrinsics.areEqual(com.larus.uaigc.helper.f.b().b(), Boxing.boxBoolean(true)) == false) goto L48;
        FLogger r27 = FLogger.a;
        StringBuilder r28 = new StringBuilder("[reviewAttachment] skip pre_handle on instant hit, identifier=");
        if (r16 == null) goto L46;
        String r29 = r16.getFileIdentifier();
    L47:
        r28.append(r29);
        r27.i("CreationMultiAttachmentProcessor", r28.toString());
        Object r30 = Boxing.boxBoolean(true);
    L51:
        r1 = r30;
        if (r1 == r9) goto L68;
        r5 = r16;
        r0 = r18;
        goto L55
    L68:
        return r9;
    L46:
        r29 = null;
        goto L47
    L39:
        r26 = false;
        goto L40
    L35:
        r24 = null;
    L48:
        if (r23 == false) goto L50;
        r30 = r14.j(r16, r18, r21, r22, r8);
        goto L51
    L50:
        r30 = r14.n(r19, r8);
        goto L51
    L30:
        r22 = null;
        goto L31
    L27:
        r21 = null;
    L7:
        r2 = new CreationMultiAttachmentProcessor$reviewUploadedImage$1(r14, r20);
        goto L8
    }

    public static final Object a(CreationMultiAttachmentProcessor r47, AtomicInteger r48, AtomicBoolean r49, CreationSendMessageConfig r50, Map r51, String r52, String r53, Continuation r54) {
        String r1 = r52;
        r47.getClass();
        if ((r54 instanceof CreationMultiAttachmentProcessor$checkAndSendWhenAllDone$1) == false) goto L7;
        CreationMultiAttachmentProcessor$checkAndSendWhenAllDone$1 r3 = (CreationMultiAttachmentProcessor$checkAndSendWhenAllDone$1) r54;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        CustomMultiAttachmentInfo r8 = null;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        String r7 = (String) r3.L$3;
        String r9 = (String) r3.L$2;
        Map r10 = (Map) r3.L$1;
        CreationSendMessageConfig r11 = (CreationSendMessageConfig) r3.L$0;
        ResultKt.throwOnFailure(r2);
        CreationSendMessageConfig r12 = r11;
        Object r13 = r2;
        String r14 = r7;
        r1 = r9;
    L24:
        NestedFileContent r15 = (NestedFileContent) r13;
        if (r15 != null) goto L31;
        CustomMultiAttachmentInfo r16 = r12.getCustomMultiAttachmentInfo();
        if (r16 == null) goto L29;
        r15 = r16.getNestedFileContent();
    L30:
        FLogger.a.w("CreationMultiAttachmentProcessor", "[checkAndSendWhenAllDone] cache snapshot missing, fallback to send snapshot, localMessageId=" + r1);
        goto L31
    L29:
        r15 = null;
    L31:
        Long r17 = c.remove(r1);
        if (r15 == null) goto L34;
        List r18 = r15.getEntities();
    L35:
        if (r18 != null) goto L37;
        r18 = CollectionsKt.emptyList();
    L37:
        List r19 = r18;
        if ((r19 instanceof Collection) == true) goto L40;
    L42:
        Iterator r110 = r19.iterator();
    L44:
        if (r110.hasNext() == false) goto L56;
        UplinkFileEntity r111 = (UplinkFileEntity) r110.next();
        if (n1.d(r111) == false) goto L53;
        Integer r112 = r111.getFileReviewStatus();
        int r113 = FileReviewState.NOT_COMPLIANT.getValue();
        if (r112 == null) goto L53;
        if (r112.intValue() != r113) goto L53;
        boolean r114 = true;
    L54:
        if (r114 == false) goto L44;
        boolean r115 = true;
    L57:
        if (r115 == false) goto L72;
        FLogger.a.i("CreationMultiAttachmentProcessor", "[checkAndSendWhenAllDone] image review rejected, mark SEND_COMPLIANT");
        String[] r20 = {r1, r14};
        ArrayList r21 = new ArrayList();
        int r22 = 0;
    L59:
        if (r22 >= 2) goto L67;
        String r23 = r20[r22];
        if (r23.length() <= 0) goto L63;
        boolean r116 = true;
    L64:
        if (r116 == false) goto L66;
        r21.add(r23);
    L66:
        r22 = r22 + 1;
        goto L59
    L63:
        r116 = false;
        goto L64
    L67:
        Iterator r0 = r21.iterator();
    L69:
        if (r0.hasNext() == false) goto L71;
        String r24 = (String) r0.next();
        RepoDispatcherDelegate r25 = RepoDispatcherDelegate.b;
        r25.e().r1(r24, new s());
        r25.e().t1(r24, 14);
        goto L69
    L71:
        k(r1, r15, r17, "review_un_pass");
        return Unit.INSTANCE;
    L72:
        NestedFileContent r26 = CreationNoWatermarkManager.a.b0(r15);
        if (r26 != null) goto L75;
        NestedFileContent r117 = r15;
    L76:
        CreationMediaAttachmentExtUpdater.a.getClass();
        CreationMediaAttachmentExtUpdater.c(r10, r117);
        CustomMultiAttachmentInfo r118 = r12.getCustomMultiAttachmentInfo();
        if (r118 == null) goto L79;
        r8 = CustomMultiAttachmentInfo.copy$default(r118, null, null, r117, false, false, false, false, null, 251, null);
    L79:
        CreationSendMessageConfig r27 = CreationSendMessageConfig.copy$default(r12, null, null, null, null, null, null, null, null, null, r10, null, r8, null, null, null, null, null, null, null, null, null, false, null, null, false, false, null, 134215167, null);
        FLogger r28 = FLogger.a;
        r28.i("CreationMultiAttachmentProcessor", "[checkAndSendWhenAllDone] Calling originalLogic to send message");
        r47.l(r27, r1, r14);
        k(r1, r15, r17, "actual_send");
        r28.i("CreationMultiAttachmentProcessor", "[checkAndSendWhenAllDone] Message sent");
        return Unit.INSTANCE;
    L75:
        r117 = r26;
    L53:
        r114 = false;
    L56:
        r115 = false;
        goto L57
    L40:
        if (r19.isEmpty() == false) goto L42;
    L34:
        r18 = null;
        goto L35
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        int r29 = r48.get();
        FLogger r30 = FLogger.a;
        r30.i("CreationMultiAttachmentProcessor", "[checkAndSendWhenAllDone] handlingFileCount: " + r29);
        if (r29 <= 0) goto L18;
        r30.i("CreationMultiAttachmentProcessor", "[checkAndSendWhenAllDone] Still have " + r29 + " files processing, waiting...");
        return Unit.INSTANCE;
    L18:
        if (r49.compareAndSet(false, true) == true) goto L20;
        r30.i("CreationMultiAttachmentProcessor", "[checkAndSendWhenAllDone] Message already sent, skip duplicate call");
        return Unit.INSTANCE;
    L20:
        r30.i("CreationMultiAttachmentProcessor", "[checkAndSendWhenAllDone] All files processed, preparing to send message");
        MainCoroutineDispatcher r31 = Dispatchers.getMain();
        CreationMultiAttachmentProcessor$checkAndSendWhenAllDone$cachedNestedFileContent$1 r32 = new CreationMultiAttachmentProcessor$checkAndSendWhenAllDone$cachedNestedFileContent$1(r1, null);
        r12 = r50;
        r3.L$0 = r12;
        r3.L$1 = r51;
        r3.L$2 = r1;
        r3.L$3 = r53;
        r3.label = 1;
        Object r33 = BuildersKt.withContext(r31, r32, r3);
        if (r33 == r5) goto L93;
        r13 = r33;
        r10 = r51;
        r14 = r53;
        goto L24
    L93:
        return r5;
    L7:
        r3 = new CreationMultiAttachmentProcessor$checkAndSendWhenAllDone$1(r47, r54);
        goto L8
    }

    public static final void c(AtomicBoolean r11, AtomicInteger r12, CreationMultiAttachmentProcessor r13, AtomicBoolean r14, CreationSendMessageConfig r15, Map r16, String r17, String r18, String r19, String r20) {
        if (r11.compareAndSet(false, true) == true) goto L5;
        FLogger.a.i("CreationMultiAttachmentProcessor", "[" + r20 + "] skip duplicate finish, identifier: " + r19);
        return;
    L5:
        a.b(r19);
        int r2 = r12.decrementAndGet();
        FLogger.a.i("CreationMultiAttachmentProcessor", "[" + r20 + "] handlingFileCount decremented, remaining: " + r2 + ", identifier: " + r19);
        AlbumHelperKt.g(GlobalScope.INSTANCE, null, new CreationMultiAttachmentProcessor$handleImageUpload$finishProcessing$1(r13, r12, r14, r15, r16, r17, r18, null), 3);
    }

    public static final void d(AtomicBoolean r11, String r12, AtomicInteger r13, CreationMultiAttachmentProcessor r14, AtomicBoolean r15, CreationSendMessageConfig r16, Map r17, String r18, String r19, String r20) {
        if (r11.compareAndSet(false, true) == true) goto L5;
        FLogger.a.i("CreationMultiAttachmentProcessor", "[" + r20 + "] skip duplicate finish, resourceKey: " + r12);
        return;
    L5:
        a.b(r12);
        int r2 = r13.decrementAndGet();
        FLogger.a.i("CreationMultiAttachmentProcessor", "[" + r20 + "] handlingFileCount decremented, remaining: " + r2 + ", resourceKey: " + r12);
        AlbumHelperKt.g(GlobalScope.INSTANCE, null, new CreationMultiAttachmentProcessor$handleVideoUpload$finishProcessing$1(r14, r13, r15, r16, r17, r18, r19, null), 3);
    }
}
