package com.larus.bmhome.upload;

import android.os.SystemClock;
import com.larus.bmhome.rc.FlowResourceScene;
import com.larus.bmhome.rc.ResourceCenter;
import com.larus.bmhome.rc.ResourceCenterPostUploadSupport;
import com.larus.bmhome.rc.ResourceInstantUploadInfo;
import com.larus.bmhome.rc.ResourceRegisterData;
import com.larus.bmhome.rc.ResourceRegisterTraceError;
import com.larus.bmhome.upload.instant.ImageInstantUploadStrategy;
import com.larus.bmhome.upload.sdk.api.model.CancelReason;
import com.larus.bmhome.upload.sdk.api.model.RegisterPolicy;
import com.larus.bmhome.upload.sdk.api.model.RoutePolicy;
import com.larus.bmhome.upload.sdk.api.model.UploadMediaType;
import com.larus.bmhome.upload.sdk.api.model.UploadScene;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.upload.FlowResourceType;
import com.larus.platform.model.upload.ResourceAttachmentExtra;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.platform.model.upload.UploadDataType;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import hq9.u1;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ResourceUploader {
    public static final ResourceUploader a = null;
    public static final CoroutineScope b = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/bmhome/upload/ResourceUploader$StopObserveSdkTaskException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "<init>", "()V", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class StopObserveSdkTaskException extends RuntimeException {
        public StopObserveSdkTaskException() {
        }
    }

    public static abstract class a {

        /* JADX INFO: renamed from: com.larus.bmhome.upload.ResourceUploader$a$a, reason: collision with other inner class name */
        public static final class C0039a extends a {
            public static final C0039a a = null;

            static {
                a = new C0039a();
            }

            public C0039a() {
            }
        }

        public static final class b extends a {
            public static final b a = null;

            static {
                a = new b();
            }

            public b() {
            }
        }

        public a() {
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[UploadScene.values().length];
            r0[UploadScene.CHAT_FILE_UPLOAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L37:
            r0[UploadScene.CHAT_IMAGE_VLM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L55:
            r0[UploadScene.CHAT_DIRECT_IMAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L41:
            r0[UploadScene.CHAT_ATTACHMENT_IMAGE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L45:
            r0[UploadScene.CHAT_IMAGE_OCR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L22
        L31:
            r0[UploadScene.CHAT_IMAGE_EDU.ordinal()] = 6;     // Catch: NoSuchFieldError -> L23
        L47:
            r0[UploadScene.CHAT_ATTACHMENT_VIDEO.ordinal()] = 7;     // Catch: NoSuchFieldError -> L24
        L49:
            r0[UploadScene.CREATION_USER_VIDEO.ordinal()] = 8;     // Catch: NoSuchFieldError -> L25
        L39:
            r0[UploadScene.SPRING_MAIN_VENUE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L26
        L43:
            r0[UploadScene.O_SERVER.ordinal()] = 10;     // Catch: NoSuchFieldError -> L27
        L33:
            r0[UploadScene.O_MOBILE_TMP.ordinal()] = 11;     // Catch: NoSuchFieldError -> L28
        L35:
            r0[UploadScene.O_ASSISTANT_FEEDBACK.ordinal()] = 12;     // Catch: NoSuchFieldError -> L29
        L53:
            r0[UploadScene.UNKNOWN.ordinal()] = 13;     // Catch: NoSuchFieldError -> L30
        L16:
            a = r0;
        }
    }

    public ResourceUploader() {
    }

    static {
        a = new ResourceUploader();
        b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
    }

    public static void a(a.C0039a r8) {
        Intrinsics.checkNotNullParameter(r8, "reason");
        FLogger.a.i("ResourceUploader", "[cancelAllIdentifierUploadTask]");
        Iterator r0 = Collections.list(com.larus.bmhome.upload.sdk.g.b.keys()).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = (String) r0.next();
        BuildersKt.launch$default(b, null, null, new ResourceUploader$cancelAllIdentifierUploadTask$1$1(r1, r8, null), 3, null);
        goto L4
    }

    public static /* synthetic */ void c(String r1) {
        b(r1, a.b.a);
    }

    public static void f(mr9.j r8) {
        ms8.b r7 = ms8.b.a;
        ms8.b.g(r7, r8, "callback_success", "success", null, null, 56);
        ms8.b.d(r7, r8, "success", null, 12);
    }

    public static FlowResourceScene h(UploadScene r1) {
        switch(b.a[r1.ordinal()]) {
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L25;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L22;
            case 8: goto L21;
            case 9: goto L20;
            case 10: goto L19;
            case 11: goto L18;
            case 12: goto L17;
            default: goto L15;
        };
    L15:
        return null;
    L17:
        return FlowResourceScene.O_ASSISTANT_FEEDBACK;
    L18:
        return FlowResourceScene.O_Mobile_Tmp;
    L19:
        return FlowResourceScene.O_Server;
    L20:
        return FlowResourceScene.SpringMainVenue;
    L21:
        return FlowResourceScene.CreationUserVideo;
    L22:
        return FlowResourceScene.VideoUpload;
    L23:
        return FlowResourceScene.ImageEDU;
    L24:
        return FlowResourceScene.ImageOCR;
    L25:
        return FlowResourceScene.ImageVLM;
    L26:
        return FlowResourceScene.FileUpload;
    }

    public static void b(String r3, a r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        FLogger.a.i("ResourceUploader", "[cancelUploadTask] uploaderIdentifier:" + r3);
        if (r3 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        ConcurrentHashMap<String, mr9.j> r1 = com.larus.bmhome.upload.sdk.g.a;
        Intrinsics.checkNotNullParameter(r3, "identifier");
        gs8.b r5 = com.larus.bmhome.upload.sdk.g.b.get(r3);
        if (r5 != null) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(r4, a.b.a) == false) goto L17;
        CancelReason r6 = CancelReason.User;
    L19:
        r5.b(r6);
        return;
    L17:
        if (Intrinsics.areEqual(r4, a.C0039a.a) == false) goto L22;
        r6 = CancelReason.LeaveChat;
        goto L19
    L22:
        throw new NoWhenBranchMatchedException();
    L5:
        if (r3.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    public static void d(mr9.j r3, String r4) {
        if (r3.m == true) goto L5;
        return;
    L5:
        FLogger.a.i("ResourceUploader", "[upload_" + r3.l + "] " + r4 + " counting down latch.");
        CountDownLatch r5 = r3.n;
        if (r5 == null) goto L9;
        r5.countDown();
        return;
    }

    public static FlowResourceScene g(mr9.j r4, UploadScene r5) {
        String r6 = r4.l;
        if (r6 == null) goto L22;
        boolean r1 = false;
        if (r6.length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        FlowResourceScene r3 = null;
        if (r0 == true) goto L12;
        r6 = null;
    L12:
        if (r6 == null) goto L22;
        ResourceCenter.a.getClass();
        FlowResourceScene r7 = ResourceCenter.g(r6);
        if (r7 == null) goto L22;
        if (r7 == FlowResourceScene.Unknown) goto L18;
        r1 = true;
    L18:
        if (r1 == false) goto L20;
        r3 = r7;
    L20:
        if (r3 == null) goto L22;
        return r3;
    L7:
        r0 = false;
    L22:
        FlowResourceScene r8 = h(r5);
        if (r8 == null) goto L25;
        return r8;
    L25:
        return FlowResourceScene.Unknown;
    }

    public final Object j(mr9.j r32, Continuation<? super Unit> r33) {
        mr9.j r0 = r32;
        if ((r33 instanceof ResourceUploader$upload$1) == false) goto L7;
        ResourceUploader$upload$1 r2 = (ResourceUploader$upload$1) r33;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        ResourceUploader$upload$1 r14 = r2;
        Object r1 = r14.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r14.label;
        boolean r16 = false;
        String r9 = "param";
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        u1 r5 = (u1) r14.L$2;
        UploadScene r6 = (UploadScene) r14.L$1;
        mr9.j r7 = (mr9.j) r14.L$0;
        ResultKt.throwOnFailure(r1);
        mr9.j r8 = r7;
        r9 = "param";
        int r10 = 2;
    L109:
        if (((Boolean) r1).booleanValue() == true) goto L111;
    L112:
        boolean r11 = Intrinsics.areEqual(r5.e(), Boxing.boxBoolean(true));
        if (r8.o.a == false) goto L131;
        String r12 = r8.l;
        if (r12 == null) goto L131;
        if (r12.length() <= 0) goto L119;
        boolean r13 = true;
    L120:
        if (r13 == true) goto L123;
        r12 = null;
    L123:
        if (r12 == null) goto L131;
        ResourceCenter.a.getClass();
        if (ResourceCenter.g(r12) != FlowResourceScene.Unknown) goto L131;
        FlowResourceScene r17 = h(r6);
        if (r17 == null) goto L131;
        ResourceCenter.k(r12, r17);
        goto L131
    L119:
        r13 = false;
    L131:
        int r18 = com.larus.bmhome.upload.sdk.d.a;
        Intrinsics.checkNotNullParameter(r8, r9);
        int r19 = com.larus.bmhome.upload.sdk.d.a.a[r8.c.ordinal()];
        if (r19 == 1) goto L143;
        if (r19 != r10) goto L135;
        UploadMediaType r20 = UploadMediaType.VIDEO;
    L144:
        UploadMediaType r110 = r20;
        boolean r21 = r8.o.a;
        String r22 = r8.l;
        if (r22 != null) goto L148;
        r22 = UUID.randomUUID().toString();
    L148:
        if (r8.g == false) goto L150;
        is8.i r23 = new is8.i.a(r8.a);
    L151:
        is8.i r111 = r23;
        String r24 = r8.b;
        if (r6 == null) goto L154;
        UploadScene r112 = r6;
    L167:
        is8.c r113 = new is8.c(r24, r112, r22);
        if (r21 == false) goto L170;
        RoutePolicy r25 = RoutePolicy.ForceResourceCenter;
    L171:
        if (r21 == false) goto L173;
        RegisterPolicy r26 = RegisterPolicy.ForceEnable;
    L174:
        is8.f r114 = new is8.f(r25, r26, 57);
        String r27 = r8.k;
        Pair[] r28 = new Pair[r10];
        r28[0] = TuplesKt.to("source_scene", r8.b);
        r28[1] = TuplesKt.to("source_identifier", r22);
        is8.g r29 = new is8.g(r111, r110, r113, r114, new is8.e(r27, MapsKt.mapOf(r28), 14));
        String r30 = r29.c.f;
        String r31 = r8.l;
        if (r31 != null) goto L177;
        String r115 = r30;
    L178:
        mr9.j r116 = mr9.j.a(r8, null, null, null, null, r115, 2095103);
        if (r116.o.a == true) goto L184;
        ResourceCenter r34 = ResourceCenter.a;
        String r35 = r116.l;
        if (r35 != null) goto L183;
        r35 = "";
    L183:
        r34.getClass();
        ResourceCenter.a(r35);
    L184:
        ConcurrentHashMap<String, mr9.j> r36 = com.larus.bmhome.upload.sdk.g.a;
        Intrinsics.checkNotNullParameter(r30, "identifier");
        Intrinsics.checkNotNullParameter(r116, r9);
        Intrinsics.checkNotNullParameter(r6, "uploadScene");
        com.larus.bmhome.upload.sdk.g.a.put(r30, r116);
        ConcurrentHashMap<String, Boolean> r37 = com.larus.bmhome.upload.sdk.g.d;
        int r38 = com.larus.bmhome.upload.sdk.g.a.a[r6.ordinal()];
        if (r38 != 1) goto L187;
    L189:
        r37.put(r30, Boolean.valueOf(r16));
        com.larus.bmhome.upload.sdk.impl.core.a r117 = ((gs8.a) com.larus.bmhome.upload.sdk.c.a.getValue()).a(r29);
        Intrinsics.checkNotNullParameter(r30, "identifier");
        Intrinsics.checkNotNullParameter(r117, "handle");
        com.larus.bmhome.upload.sdk.g.b.put(r30, r117);
        BuildersKt.launch$default(b, null, null, new ResourceUploader$submitSdkUpload$1(r117, r30, r116, r11, null), 3, null);
        return Unit.INSTANCE;
    L187:
        if (r38 == 2) goto L189;
        r16 = true;
        goto L189
    L177:
        r115 = r31;
        goto L178
    L173:
        r26 = RegisterPolicy.Disabled;
        goto L174
    L170:
        r25 = RoutePolicy.ForceUploadAuthToken;
        goto L171
    L154:
        if (r110 != UploadMediaType.VIDEO) goto L157;
        r112 = UploadScene.CHAT_ATTACHMENT_VIDEO;
        goto L167
    L157:
        if (r110 != UploadMediaType.FILE) goto L160;
        r112 = UploadScene.CHAT_FILE_UPLOAD;
        goto L167
    L160:
        if (r8.o.a == false) goto L163;
        r112 = UploadScene.CHAT_ATTACHMENT_IMAGE;
        goto L167
    L163:
        if (r110 != UploadMediaType.IMAGE) goto L165;
        r112 = UploadScene.CHAT_DIRECT_IMAGE;
        goto L167
    L165:
        r112 = UploadScene.CHAT_FILE_UPLOAD;
        goto L167
    L150:
        r23 = new is8.i.b(r8.a);
        goto L151
    L135:
        if (r19 != 3) goto L137;
    L141:
        r20 = UploadMediaType.FILE;
        goto L144
    L137:
        if (r19 == 4) goto L141;
        throw new NoWhenBranchMatchedException();
    L143:
        r20 = UploadMediaType.IMAGE;
        goto L144
    L111:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r5 = (u1) r14.L$2;
        r6 = (UploadScene) r14.L$1;
        mr9.j r39 = (mr9.j) r14.L$0;
        ResultKt.throwOnFailure(r1);
        r8 = r39;
        r10 = 2;
    L103:
        com.larus.bmhome.upload.instant.b r40 = (com.larus.bmhome.upload.instant.b) r1;
        if (r40 == null) goto L112;
        FLogger.a.i("ResourceUploader", "[upload_" + r8.l + "] instant hit before sdk, result=" + r40.a);
        ResourceUploader r41 = a;
        r14.L$0 = r8;
        r14.L$1 = r6;
        r14.L$2 = r5;
        r14.label = r10;
        r1 = r41.i(r8, r40, r6, r14);
        if (r1 != r15) goto L109;
        return r15;
    L16:
        ResultKt.throwOnFailure(r1);
        String r42 = r0.l;
        if (r42 != null) goto L19;
    L26:
        UplinkFileEntity r43 = r0.o.c;
        if (r43 == null) goto L36;
        r42 = r43.getFileIdentifier();
        if (r42 == null) goto L36;
        if (r42.length() <= 0) goto L33;
        boolean r44 = true;
    L34:
        if (r44 == false) goto L36;
    L37:
        if (r42 != null) goto L39;
        r42 = UUID.randomUUID().toString();
    L39:
        String r45 = r42;
        if (Intrinsics.areEqual(r45, r0.l) == true) goto L43;
        r0 = mr9.j.a(r32, null, null, null, null, r45, 2095103);
    L43:
        Function1 r46 = r0.u;
        if (r46 == null) goto L46;
        r46.invoke("upload_dispatched");
    L46:
        int r47 = com.larus.bmhome.upload.sdk.a.a;
        Intrinsics.checkNotNullParameter(r0, "param");
        String r48 = r0.l;
        if (r48 != null) goto L49;
    L59:
        FlowResourceScene r49 = FlowResourceScene.Unknown;
    L61:
        switch(com.larus.bmhome.upload.sdk.a.C0041a.a[r49.ordinal()]) {
            case 1: goto L74;
            case 2: goto L73;
            case 3: goto L72;
            case 4: goto L71;
            case 5: goto L70;
            case 6: goto L69;
            case 7: goto L69;
            case 8: goto L68;
            case 9: goto L67;
            case 10: goto L66;
            case 11: goto L65;
            case 12: goto L64;
            default: goto L63;
        };
    L64:
        UploadScene r50 = null;
    L75:
        if (r50 != null) goto L93;
        UploadDataType r51 = r0.c;
        if (r51 != UploadDataType.VIDEO) goto L80;
        r50 = UploadScene.CHAT_ATTACHMENT_VIDEO;
        goto L93
    L80:
        if (r51 != UploadDataType.FILE) goto L82;
    L92:
        r50 = UploadScene.CHAT_FILE_UPLOAD;
        goto L93
    L82:
        if (r51 == UploadDataType.UNCLEAR) goto L92;
        UploadDataType r52 = UploadDataType.IMAGE;
        if (r51 == r52) goto L87;
    L89:
        if (r51 != r52) goto L91;
        r50 = UploadScene.CHAT_DIRECT_IMAGE;
        goto L93
    L91:
        r50 = UploadScene.CHAT_FILE_UPLOAD;
        goto L93
    L87:
        if (r0.o.a == false) goto L89;
        r50 = UploadScene.CHAT_ATTACHMENT_IMAGE;
    L93:
        u1 r53 = z2.a.getImageInstantUploadConfig();
        ms8.b r118 = ms8.b.a;
        String r210 = r50.name();
        Boolean r54 = Boxing.boxBoolean(Intrinsics.areEqual(r53.e(), Boxing.boxBoolean(true)));
        if (Intrinsics.areEqual(r53.e(), Boxing.boxBoolean(true)) == true) goto L96;
    L98:
        boolean r55 = false;
    L99:
        Boolean r56 = Boxing.boxBoolean(r55);
        r118.getClass();
        Intrinsics.checkNotNullParameter(r0, "param");
        Intrinsics.checkNotNullParameter("sdk", "chain");
        String r57 = ms8.b.l(r0);
        long r211 = SystemClock.elapsedRealtime();
        Boolean r119 = Boolean.TRUE;
        ms8.b.b.put(r57, new ms8.b.a(r57, r211, "sdk", r210, Intrinsics.areEqual(r54, r119), Intrinsics.areEqual(r56, r119), null, null, null));
        ms8.b.g(r118, r0, "upload_start", "success", 0L, null, 48);
        FLogger.a.i("ResourceUploader", "[upload_" + r0.l + "] route to sdk, uploadScene=" + r50 + "  [instantUploadPolicy_" + r0.r + "], resourceCenterEnabled=" + r0.o.a);
        ImageInstantUploadStrategy r58 = ImageInstantUploadStrategy.a;
        FlowResourceScene.a r59 = FlowResourceScene.Companion;
        FlowResourceScene r60 = g(r0, r50);
        r59.getClass();
        String r61 = FlowResourceScene.a.b(r60);
        r14.L$0 = r0;
        r14.L$1 = r50;
        r14.L$2 = r53;
        r14.label = 1;
        r10 = 2;
        Object r62 = r58.o(r0, r50, r61, r53, r14);
        if (r62 != r15) goto L102;
        return r15;
    L102:
        r8 = r0;
        r5 = r53;
        r6 = r50;
        r1 = r62;
        goto L103
    L96:
        if (Intrinsics.areEqual(r53.d(), Boxing.boxBoolean(true)) == false) goto L98;
        r55 = true;
        goto L99
    L65:
        r50 = UploadScene.O_ASSISTANT_FEEDBACK;
        goto L75
    L66:
        r50 = UploadScene.O_MOBILE_TMP;
        goto L75
    L67:
        r50 = UploadScene.O_SERVER;
        goto L75
    L68:
        r50 = UploadScene.SPRING_MAIN_VENUE;
        goto L75
    L69:
        r50 = UploadScene.CREATION_USER_VIDEO;
        goto L75
    L70:
        r50 = UploadScene.CHAT_ATTACHMENT_VIDEO;
        goto L75
    L71:
        r50 = UploadScene.CHAT_IMAGE_EDU;
        goto L75
    L72:
        r50 = UploadScene.CHAT_IMAGE_OCR;
        goto L75
    L73:
        r50 = UploadScene.CHAT_IMAGE_VLM;
        goto L75
    L74:
        r50 = UploadScene.CHAT_FILE_UPLOAD;
        goto L75
    L63:
        throw new NoWhenBranchMatchedException();
    L49:
        if (r48.length() <= 0) goto L51;
        boolean r63 = true;
    L52:
        if (r63 == true) goto L55;
        r48 = null;
    L55:
        if (r48 == null) goto L59;
        ResourceCenter.a.getClass();
        r49 = ResourceCenter.g(r48);
        if (r49 == null) goto L59;
    L51:
        r63 = false;
        goto L52
    L33:
        r44 = false;
    L36:
        r42 = null;
        goto L37
    L19:
        if (r42.length() <= 0) goto L21;
        boolean r64 = true;
    L22:
        if (r64 == true) goto L25;
        r42 = null;
    L25:
        if (r42 != null) goto L39;
    L21:
        r64 = false;
    L7:
        r2 = new ResourceUploader$upload$1(this, r33);
        goto L8
    }

    public static void e(mr9.j r8, ResourceUploadError r9, String r10) {
        ms8.b r7 = ms8.b.a;
        ms8.b.g(r7, r8, "callback_fail", r10, null, r9, 40);
        ms8.b.d(r7, r8, r10, r9, 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r20v10 */
    /* JADX WARN: Type inference failed for: r20v11 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r20v6 */
    public final Object i(mr9.j r32, com.larus.bmhome.upload.instant.b r33, UploadScene r34, Continuation<? super Boolean> r35) {
        com.larus.bmhome.upload.instant.b r0 = r33;
        if ((r35 instanceof ResourceUploader$tryNotifyInstantUploadSuccess$1) == false) goto L7;
        ResourceUploader$tryNotifyInstantUploadSuccess$1 r4 = (ResourceUploader$tryNotifyInstantUploadSuccess$1) r35;
        int r5 = r4.label;
        if ((r5 & Integer.MIN_VALUE) == 0) goto L7;
        r4.label = r5 - Integer.MIN_VALUE;
    L8:
        ResourceUploader$tryNotifyInstantUploadSuccess$1 r15 = r4;
        Object r2 = r15.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r15.label;
        String r10 = "api_path";
        String r9 = "api_name";
        String r12 = "resource_scene";
        String r8 = "register_finished";
        if (r7 != 0) goto L11;
        ResultKt.throwOnFailure(r2);
        com.larus.bmhome.upload.instant.f.a(r32);
        FlowResourceScene r3 = g(r32, r34);
        ms8.b.a.getClass();
        ms8.b.i(r32, "resource_register");
        Function1 r11 = r32.u;
        if (r11 == null) goto L124;
        r11.invoke("register_started");
    L124:
        ResourceCenterPostUploadSupport r13 = ResourceCenterPostUploadSupport.a;     // Catch: Throwable -> L83
        mr9.l r14 = r0.a;     // Catch: Throwable -> L83
        mr9.h r16 = r32.o;     // Catch: Throwable -> L81
        UplinkFileEntity r17 = r16.c;     // Catch: Throwable -> L79
        ResourceAttachmentExtra r18 = r16.b;     // Catch: Throwable -> L79
        FlowResourceScene.Companion.getClass();     // Catch: Throwable -> L79
        String r21 = FlowResourceScene.a.b(r3);     // Catch: Throwable -> L79
        String r19 = r32.l;     // Catch: Throwable -> L77
        FlowResourceType r23 = com.larus.bmhome.upload.a.a(r32);     // Catch: Throwable -> L77
        ResourceInstantUploadInfo r110 = r0.b;     // Catch: Throwable -> L74
        Long r20 = r32.t;     // Catch: Throwable -> L74
        r15.L$0 = r32;     // Catch: Throwable -> L74
        r15.L$1 = r0;     // Catch: Throwable -> L74
        r15.L$2 = r3;     // Catch: Throwable -> L74
        r15.label = 1;     // Catch: Throwable -> L74
        Object r1 = "register_type";
        r3 = r3;
        r8 = "register_finished";
        Object r26 = "/alice/resource/register";
        String r22 = "api_path";
        r12 = "resource_scene";
        boolean r24 = true;
        boolean r25 = true;
        String r27 = "resource_register";
        String r28 = "api_name";
        Object r29 = "instant_hit";
        int r30 = 4;
        Object r31 = r13.a(r14, r17, r18, r21, r19, r23, r110, r20, r15);     // Catch: Throwable -> L72
        if (r31 != r6) goto L35;
        return r6;
    L35:
        mr9.j r36 = r32;
        Object r37 = r31;
        FlowResourceScene r38 = r3;
    L128:
        ResourceRegisterData r111 = (ResourceRegisterData) r37;     // Catch: Throwable -> L69
        ms8.b r39 = ms8.b.a;     // Catch: Throwable -> L69
        Pair[] r40 = new Pair[r30];     // Catch: Throwable -> L69
        r40[0] = TuplesKt.to(r12, r38.name());     // Catch: Throwable -> L69
        Object r112 = r29;
        r40[r25 ? 1 : 0] = TuplesKt.to(r1, r112);     // Catch: Throwable -> L67
        r9 = r28;
        String r113 = r27;
        r40[2] = TuplesKt.to(r9, r113);     // Catch: Throwable -> L65
        r10 = r22;
        Object r210 = r26;
        r40[3] = TuplesKt.to(r10, r210);     // Catch: Throwable -> L63
        ms8.b.c(r39, r36, "resource_register", "success", null, MapsKt.mapOf(r40), 8);     // Catch: Throwable -> L61
        mr9.l r41 = r0.a;     // Catch: Throwable -> L61
        String r42 = r0.b.getRegisterUri();     // Catch: Throwable -> L61
        String r43 = r111.getResourceId();     // Catch: Throwable -> L61
        String r44 = r111.getAliasName();     // Catch: Throwable -> L61
        if (r44 != null) goto L48;
        r44 = r0.a.b;     // Catch: Throwable -> L61
    L48:
        mr9.l r45 = mr9.l.a(r41, r42, r44, r43, 120);     // Catch: Throwable -> L61
        Function1 r46 = r36.u;
        if (r46 == null) goto L52;
        r46.invoke(r8);
    L52:
        Function1 r47 = r36.u;
        if (r47 == null) goto L142;
        r47.invoke("fast_upload");
    L142:
        r36.d.invoke(r45);     // Catch: Throwable -> L58
        f(r36);
        d(r36, "instant hit");
        return Boxing.boxBoolean(r25);
    L58:
        th = move-exception;
        f(r36);
        d(r36, "instant hit");
        throw th;
    L61:
        th = th;
    L71:
        FlowResourceScene r48 = r38;
        ?? r211 = r25;
    L86:
        Function1 r49 = r36.u;
        if (r49 == null) goto L89;
        r49.invoke(r8);
    L89:
        Map<String, Object> r50 = null;
        if ((th instanceof ResourceRegisterTraceError) == false) goto L92;
        ResourceRegisterTraceError r51 = th;
    L93:
        if (r51 == null) goto L97;
        ResourceUploadError r52 = r51.getUploadError();
        if (r52 == null) goto L97;
    L105:
        ms8.b r114 = ms8.b.a;
        Pair[] r115 = new Pair[6];
        r115[0] = TuplesKt.to(r12, r48.name());
        r115[r211] = TuplesKt.to(r1, r112);
        r115[2] = TuplesKt.to(r9, r113);
        r115[3] = TuplesKt.to(r10, r210);
        String r53 = "exception";
        if (r51 != null) goto L108;
        Object r54 = "exception";
    L109:
        r115[4] = TuplesKt.to("error_type", r54);
        if (r51 == null) goto L113;
        r53 = null;
    L113:
        r115[5] = TuplesKt.to("fail_reason", r53);
        Map r55 = MapsKt.mapOf(r115);
        if (r51 == null) goto L116;
        r50 = r51.getTraceExtra();
    L116:
        if (r50 != null) goto L118;
        r50 = MapsKt.emptyMap();
    L118:
        Map r56 = MapsKt.plus(r55, r50);
        r114.getClass();
        ms8.b.b(r36, r113, "fail", r52, r56);
        FLogger.a.e("ResourceUploader", "[upload_" + r36.l + "] instant hit register failed, fallback to normal upload", th);
        return Boxing.boxBoolean(false);
    L108:
        r54 = null;
    L97:
        if ((th instanceof ResourceUploadError) == false) goto L99;
        r52 = (ResourceUploadError) th;
    L100:
        if (r52 != null) goto L105;
        String r116 = th.getMessage();
        if (r116 != null) goto L104;
        r116 = "";
    L104:
        r52 = new ResourceUploadError("upload_resource_register_error", r116);
        goto L105
    L99:
        r52 = null;
        goto L100
    L92:
        r51 = null;
    L63:
        th = th;
    L65:
        th = th;
        r38 = r38;
        r9 = r9;
        r10 = r22;
        r210 = r26;
    L67:
        th = th;
        r38 = r38;
        r10 = r22;
        r9 = r28;
        r210 = r26;
        r113 = r27;
    L69:
        th = th;
        r38 = r38;
        r10 = r22;
        r9 = r28;
        r210 = r26;
        r113 = r27;
        r112 = r29;
    L72:
        th = th;
        r8 = r8;
        r10 = r22;
        r9 = r28;
        r210 = r26;
        r113 = r27;
        r112 = r29;
    L85:
        r36 = r32;
        r48 = r3;
        r211 = r24;
    L74:
        th = th;
        r1 = "register_type";
        r112 = "instant_hit";
        r210 = "/alice/resource/register";
        r113 = "resource_register";
    L76:
        r24 = true;
    L77:
        th = th;
        r113 = "resource_register";
        r1 = "register_type";
        r112 = "instant_hit";
        r210 = "/alice/resource/register";
    L79:
        th = th;
        r210 = "/alice/resource/register";
        r113 = "resource_register";
        r1 = "register_type";
        r112 = "instant_hit";
    L81:
        th = th;
        r112 = "instant_hit";
        r210 = "/alice/resource/register";
        r113 = "resource_register";
        r1 = "register_type";
    L83:
        th = th;
        r1 = "register_type";
        r112 = "instant_hit";
        r210 = "/alice/resource/register";
        r113 = "resource_register";
        goto L76
    L11:
        if (r7 != 1) goto L18;
        FlowResourceScene r57 = (FlowResourceScene) r15.L$2;
        r0 = (com.larus.bmhome.upload.instant.b) r15.L$1;
        r36 = (mr9.j) r15.L$0;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L15
        r37 = r2;
        r8 = "register_finished";
        r29 = "instant_hit";
        r28 = "api_name";
        r22 = "api_path";
        r26 = "/alice/resource/register";
        r12 = "resource_scene";
        r27 = "resource_register";
        r30 = 4;
        r25 = true;
        r38 = r57;
        r1 = "register_type";
    L15:
        th = th;
        r8 = "register_finished";
        r112 = "instant_hit";
        r9 = "api_name";
        r10 = "api_path";
        r210 = "/alice/resource/register";
        r12 = "resource_scene";
        r113 = "resource_register";
        r211 = 1;
        r48 = r57;
        r1 = "register_type";
        goto L86
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r4 = new ResourceUploader$tryNotifyInstantUploadSuccess$1(this, r35);
        goto L8
    }
}
