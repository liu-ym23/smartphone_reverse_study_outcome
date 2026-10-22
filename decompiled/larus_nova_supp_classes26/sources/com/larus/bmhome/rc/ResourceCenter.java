package com.larus.bmhome.rc;

import com.google.gson.Gson;
import com.larus.common.apphost.AppHost;
import com.larus.platform.model.upload.FlowResourceType;
import com.larus.platform.model.upload.ResourceAttachmentExtra;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import hq9.b4;
import hq9.c4;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import mr9.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class ResourceCenter {
    public static final ResourceCenter a = null;
    public static final String b = null;
    public static final CoroutineScope c = null;
    public static final ConcurrentHashMap<String, String> d = null;
    public static final ConcurrentHashMap<String, String> e = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[FlowResourceScene.values().length];
            r0[FlowResourceScene.Unknown.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L35:
            r0[FlowResourceScene.FileUpload.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L51:
            r0[FlowResourceScene.ImageVLM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L39:
            r0[FlowResourceScene.ImageOCR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L43:
            r0[FlowResourceScene.ImageEDU.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L29:
            r0[FlowResourceScene.VideoUpload.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L45:
            r0[FlowResourceScene.O_Server.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L47:
            r0[FlowResourceScene.O_Mobile_Tmp.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L37:
            r0[FlowResourceScene.O_ASSISTANT_FEEDBACK.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L41:
            r0[FlowResourceScene.CreationUserVideo.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L31:
            r0[FlowResourceScene.CreationUserVideoV2.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L33:
            r0[FlowResourceScene.SpringMainVenue.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L15:
            a = r0;
        }
    }

    public ResourceCenter() {
    }

    static {
        a = new ResourceCenter();
        if (AppHost.a.isOversea() == false) goto L5;
        String r0 = "3";
    L6:
        b = r0;
        c = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        d = new ConcurrentHashMap();
        e = new ConcurrentHashMap();
        FLogger.a.i("ResourceCenter", "[init] config:" + f());
        return;
    L5:
        r0 = "4";
        goto L6
    }

    public static b4 f() {
        AppHost.Companion r0 = AppHost.a;
        if (r0.isTestChannel() == true) goto L9;
        if (r0.isDebugChannel() == true) goto L9;
        return z2.a.getResourceCenterConfig();
    L9:
        return e.a;
    }

    public static boolean c() {
        if (f().a() == false) goto L13;
        c4 r0 = f().b();
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r0.d() != true) goto L9;
        r1 = true;
        goto L10
    L13:
        return false;
    }

    public static void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "identifier");
        FLogger.a.i("ResourceCenter", "[clearRecordedData] identifier:" + r3);
        d.remove(r3);
        e.remove(r3);
    }

    public static boolean d(String r4) {
        Intrinsics.checkNotNullParameter(r4, "identifier");
        String r5 = d.get(r4);
        boolean r0 = false;
        if (r5 != null) goto L5;
        return false;
    L5:
        FlowResourceScene.Companion.getClass();
        switch(a.a[FlowResourceScene.a.a(r5).ordinal()]) {
            case 1: goto L40;
            case 2: goto L39;
            case 3: goto L30;
            case 4: goto L20;
            case 5: goto L10;
            case 6: goto L38;
            case 7: goto L38;
            case 8: goto L38;
            case 9: goto L38;
            case 10: goto L38;
            case 11: goto L38;
            case 12: goto L38;
            default: goto L8;
        };
    L38:
        r0 = true;
        goto L40
    L39:
        r0 = c();
    L40:
        FLogger.a.i("ResourceCenter", "[enabledForRecordedScene] sceneId:" + r5 + ", enabled:" + r0);
        return r0;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        if (f().a() == false) goto L40;
        c4 r1 = f().b();
        if (r1 != null) goto L14;
    L16:
        boolean r2 = false;
    L17:
        if (r2 == false) goto L40;
    L14:
        if (r1.a() != true) goto L16;
        r2 = true;
        goto L17
    L20:
        if (f().a() == false) goto L40;
        c4 r3 = f().b();
        if (r3 != null) goto L24;
    L26:
        boolean r6 = false;
    L27:
        if (r6 == false) goto L40;
    L24:
        if (r3.b() != true) goto L26;
        r6 = true;
        goto L27
    L30:
        if (f().a() == false) goto L40;
        c4 r7 = f().b();
        if (r7 != null) goto L34;
    L36:
        boolean r8 = false;
    L37:
        if (r8 == false) goto L40;
    L34:
        if (r7.c() != true) goto L36;
        r8 = true;
        goto L37
    }

    public static FlowResourceScene g(String r1) {
        Intrinsics.checkNotNullParameter(r1, "identifier");
        String r2 = d.get(r1);
        if (r2 == null) goto L7;
        FlowResourceScene.Companion.getClass();
        FlowResourceScene r3 = FlowResourceScene.a.a(r2);
        if (r3 == null) goto L7;
        return r3;
    L7:
        return FlowResourceScene.Unknown;
    }

    public static void k(String r3, FlowResourceScene r4) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        if (r3 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        ConcurrentHashMap<String, String> r1 = d;
        FlowResourceScene.Companion.getClass();
        r1.put(r3, FlowResourceScene.a.b(r4));
        FLogger.a.i("ResourceCenter", "[recordScene] identifier:" + r3 + ", scene:" + r1.get(r3));
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    public final Object b(List<String> r6, Continuation<? super String> r7) {
        if ((r7 instanceof ResourceCenter$deleteResource$1) == false) goto L7;
        ResourceCenter$deleteResource$1 r0 = (ResourceCenter$deleteResource$1) r7;
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
        dm9.a r9 = (dm9.a) r8;
        if ((r9 instanceof dm9.a.a) == false) goto L21;
        FLogger.a.e("ResourceCenter", "[deleteResource] failed, " + r9);
    L21:
        return r9.toString();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        ResourceApi.a r10 = ResourceApi.a;
        ResourceCenter$deleteResource$2 r4 = new ResourceCenter$deleteResource$2(r6, null);
        r0.label = 1;
        r10.getClass();
        r8 = ResourceApi.a.a("/alice/resource/delete", r4, r0);
        if (r8 != r2) goto L17;
        return r2;
    L7:
        r0 = new ResourceCenter$deleteResource$1(this, r7);
        goto L8
    }

    public final Object e(String r6, String r7, Continuation<? super String> r8) {
        if ((r8 instanceof ResourceCenter$getAudioFileDetailUrl$1) == false) goto L7;
        ResourceCenter$getAudioFileDetailUrl$1 r0 = (ResourceCenter$getAudioFileDetailUrl$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = (String) r0.L$0;
        ResultKt.throwOnFailure(r9);
    L17:
        dm9.a.b r10 = (dm9.a) r9;
        if ((r10 instanceof dm9.a.a) == false) goto L21;
        FLogger.a.e("ResourceCenter", "[getAudioFileDetailUrl] failed, " + r10);
        return null;
    L21:
        if ((r10 instanceof dm9.a.b) == false) goto L27;
        Map r11 = (Map) r10.a.getData();
        FLogger.a.i("ResourceCenter", "[getAudioFileDetailUrl] success, urlMap=" + r11);
        if (r11 != null) goto L25;
        return null;
    L25:
        return (String) r11.get(r6);
    L27:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        ResourceApi.a r12 = ResourceApi.a;
        ResourceCenter$getAudioFileDetailUrl$2 r4 = new ResourceCenter$getAudioFileDetailUrl$2(r6, r7, null);
        r0.L$0 = r6;
        r0.label = 1;
        r12.getClass();
        r9 = ResourceApi.a.a("/alice/resource/get_audio_file_h5", r4, r0);
        if (r9 != r2) goto L17;
        return r2;
    L7:
        r0 = new ResourceCenter$getAudioFileDetailUrl$1(this, r8);
        goto L8
    }

    public final Object j(FlowResourceType r23, String r24, Continuation<? super PrepareUploadResult> r25) {
        if ((r25 instanceof ResourceCenter$prepareUpload$1) == false) goto L7;
        ResourceCenter$prepareUpload$1 r2 = (ResourceCenter$prepareUpload$1) r25;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        g.a r1 = (g.a) r2.L$0;
        ResultKt.throwOnFailure(r0);
    L59:
        dm9.a.a r6 = (dm9.a) r0;
        if ((r6 instanceof dm9.a.a) == false) goto L63;
        FLogger.a.e("ResourceCenter", "[prepareUpload] failed, " + r6);
        return new PrepareUploadResult(null, "HttpError(" + r6.a + ')', 1, null);
    L63:
        if ((r6 instanceof dm9.a.b) == false) goto L166;
        FLogger r7 = FLogger.a;
        StringBuilder r8 = new StringBuilder("[prepareUpload] prepareUploadResp=");
        dm9.a.b r9 = (dm9.a.b) r6;
        r8.append(r9.a.getData());
        r7.i("ResourceCenter", r8.toString());
        ResourceCenter r10 = a;
        ResourcePrepareUploadData r11 = (ResourcePrepareUploadData) r9.a.getData();
        r10.getClass();
        if (r11 != null) goto L68;
    L129:
        m r12 = null;
    L151:
        if (r12 != null) goto L153;
        r7.e("ResourceCenter", "[prepareUpload] failed, prepareUploadResp is null");
        return new PrepareUploadResult(null, "RespError(null data)", 1, null);
    L153:
        g.a.getClass();
        Intrinsics.checkNotNullParameter(r12, "tokenData");
        Intrinsics.checkNotNullParameter(r1, "cacheKey");
        if (g.d(r1) == false) goto L164;
        r7.i("ResourceCenterUploadTokenCache", "save cache token: " + r12 + ", currentTime: " + AppHost.a.getAppClock().currentTimeMillis());
        Result.Companion r13 = Result.Companion;     // Catch: Throwable -> L158
        g.b.storeString(g.a(r1), new Gson().toJson(r12));     // Catch: Throwable -> L158
        Object r14 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L158
    L160:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L164;
        FLogger.a.e("ResourceCenterUploadTokenCache", "failed to save cache token, " + r15);
        g.a.getClass();
        g.b(r1);
    L158:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
    L164:
        return new PrepareUploadResult(r12, null, 2, null);
    L68:
        if (r11.getUploadAuthToken() == null) goto L129;
        ResourceUploadAuthToken r17 = r11.getUploadAuthToken();
        if (r17 == null) goto L73;
        String r18 = r17.getAccessKey();
    L74:
        if (r18 != null) goto L76;
    L79:
        boolean r19 = true;
    L80:
        if (r19 == true) goto L129;
        ResourceUploadAuthToken r20 = r11.getUploadAuthToken();
        if (r20 == null) goto L85;
        String r21 = r20.getSecretKey();
    L86:
        if (r21 != null) goto L88;
    L91:
        boolean r22 = true;
    L92:
        if (r22 == true) goto L129;
        ResourceUploadAuthToken r26 = r11.getUploadAuthToken();
        if (r26 == null) goto L97;
        String r27 = r26.getSessionToken();
    L98:
        if (r27 != null) goto L100;
    L103:
        boolean r28 = true;
    L104:
        if (r28 == true) goto L129;
        ResourceUploadAuthToken r29 = r11.getUploadAuthToken();
        if (r29 == null) goto L109;
        String r30 = r29.getExpiredTime();
    L110:
        if (r30 != null) goto L112;
    L115:
        boolean r31 = true;
    L116:
        if (r31 == true) goto L129;
        ResourceUploadAuthToken r32 = r11.getUploadAuthToken();
        if (r32 == null) goto L121;
        String r33 = r32.getCurrentTime();
    L122:
        if (r33 != null) goto L124;
    L127:
        boolean r34 = true;
    L128:
        if (r34 == true) goto L129;
        String r35 = r11.getServiceId();
        String r36 = r11.getUploadHost();
        String r37 = r11.getUploadPathPrefix();
        ResourceUploadAuthToken r38 = r11.getUploadAuthToken();
        if (r38 == null) goto L133;
        String r110 = r38.getAccessKey();
    L134:
        ResourceUploadAuthToken r39 = r11.getUploadAuthToken();
        if (r39 == null) goto L137;
        String r111 = r39.getSecretKey();
    L138:
        ResourceUploadAuthToken r40 = r11.getUploadAuthToken();
        if (r40 == null) goto L141;
        String r112 = r40.getSessionToken();
    L142:
        ResourceUploadAuthToken r41 = r11.getUploadAuthToken();
        if (r41 == null) goto L145;
        String r210 = r41.getExpiredTime();
    L146:
        ResourceUploadAuthToken r42 = r11.getUploadAuthToken();
        if (r42 == null) goto L149;
        String r211 = r42.getCurrentTime();
    L150:
        r12 = new m(r35, r37, r36, new mr9.b(r110, r111, r112, r210, r211));
        goto L151
    L149:
        r211 = null;
        goto L150
    L145:
        r210 = null;
        goto L146
    L141:
        r112 = null;
        goto L142
    L137:
        r111 = null;
        goto L138
    L133:
        r110 = null;
        goto L134
    L124:
        if (StringsKt.isBlank(r33) == true) goto L127;
        r34 = false;
        goto L128
    L121:
        r33 = null;
        goto L122
    L112:
        if (StringsKt.isBlank(r30) == true) goto L115;
        r31 = false;
        goto L116
    L109:
        r30 = null;
        goto L110
    L100:
        if (StringsKt.isBlank(r27) == true) goto L103;
        r28 = false;
        goto L104
    L97:
        r27 = null;
        goto L98
    L88:
        if (StringsKt.isBlank(r21) == true) goto L91;
        r22 = false;
        goto L92
    L85:
        r21 = null;
        goto L86
    L76:
        if (StringsKt.isBlank(r18) == true) goto L79;
        r19 = false;
        goto L80
    L73:
        r18 = null;
        goto L74
    L166:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        FlowResourceScene.Companion.getClass();
        g.a r43 = new g.a(FlowResourceScene.a.a(r24), r23);
        String r44 = f().c();
        if (r44 != null) goto L17;
        String r113 = r24;
    L18:
        g.a.getClass();
        Intrinsics.checkNotNullParameter(r43, "cacheKey");
        if (g.d(r43) == true) goto L21;
    L47:
        g.c(false);
    L48:
        m r45 = null;
    L49:
        if (r45 == null) goto L51;
        FLogger.a.i("ResourceCenter", "[acquireUploadTokenFromCache] success " + r43 + ':' + r45);
    L52:
        if (r45 != null) goto L54;
        ResourceApi.a r46 = ResourceApi.a;
        ResourceCenter$prepareUpload$2 r47 = new ResourceCenter$prepareUpload$2(r113, r23, null);
        r2.L$0 = r43;
        r2.label = 1;
        r46.getClass();
        r0 = ResourceApi.a.a("/alice/resource/prepare_upload", r47, r2);
        if (r0 != r4) goto L58;
        return r4;
    L58:
        r1 = r43;
        goto L59
    L54:
        return new PrepareUploadResult(r45, null, 2, null);
    L51:
        FLogger.a.i("ResourceCenter", "[acquireUploadTokenFromCache] failed, key=" + r43);
        g.a.getClass();
        g.b(r43);
        r45 = null;
        goto L52
    L21:
        if (z2.a.uploaderUseCachedTokenEnable() == false) goto L47;
        String r48 = g.b.getString(g.a(r43), "");
        if (r48 != null) goto L25;
    L46:
        FLogger.a.i("ResourceCenterUploadTokenCache", "accessAuthToken failed, missed");
        goto L47
    L25:
        if (o0.d(r48) == false) goto L46;
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L28
        Object r49 = Result.constructor-impl((m) new Gson().fromJson(r48, m.class));     // Catch: Throwable -> L28
    L30:
        Throwable r115 = Result.exceptionOrNull-impl(r49);
        if (r115 == null) goto L34;
        FLogger.a.e("ResourceCenterUploadTokenCache", "accessAuthToken failed, " + r115);
        g.a.getClass();
        g.b(r43);
    L34:
        if (Result.isFailure-impl(r49) == false) goto L36;
        r49 = null;
    L36:
        r45 = (m) r49;
        if (r45 == null) goto L48;
        long r116 = AppHost.a.getAppClock().currentTimeMillis() + 300000;
        FLogger.a.i("ResourceCenterUploadTokenCache", "accessAuthToken success, tokenData: " + r45 + ", deviceTime: " + r116);
        mr9.b r50 = r45.a();
        if (r50 == null) goto L42;
        long r51 = r50.b();
    L44:
        if (r51 <= r116) goto L46;
        g.a.getClass();
        g.c(true);
        goto L49
    L42:
        r51 = -1;
    L28:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r49 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    L17:
        r113 = r44;
    L7:
        r2 = new ResourceCenter$prepareUpload$1(this, r25);
        goto L8
    }

    public final Object m(List<String> r6, SignUrlMode r7, Continuation<? super Map<String, ResourceSignUrlData>> r8) {
        if ((r8 instanceof ResourceCenter$signUrl$1) == false) goto L7;
        ResourceCenter$signUrl$1 r0 = (ResourceCenter$signUrl$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L17:
        dm9.a.b r10 = (dm9.a) r9;
        if ((r10 instanceof dm9.a.a) == false) goto L21;
        FLogger.a.e("ResourceCenter", "[signUrl] failed, " + r10);
        return MapsKt.emptyMap();
    L21:
        if ((r10 instanceof dm9.a.b) == false) goto L35;
        Map r11 = (Map) r10.a.getData();
        if (r11 != null) goto L25;
    L28:
        if (r4 == false) goto L30;
        FLogger.a.e("ResourceCenter", "[signUrl] failed, registerResp is null");
    L31:
        if (r11 == null) goto L33;
        return r11;
    L33:
        return MapsKt.emptyMap();
    L30:
        FLogger.a.i("ResourceCenter", "[signUrl] success, registerResp=" + r11);
        goto L31
    L25:
        if (r11.isEmpty() == true) goto L28;
        r4 = false;
        goto L28
    L35:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        ResourceApi.a r12 = ResourceApi.a;
        ResourceCenter$signUrl$2 r5 = new ResourceCenter$signUrl$2(r6, r7, null);
        r0.label = 1;
        r12.getClass();
        r9 = ResourceApi.a.a("/alice/resource/sign_url", r5, r0);
        if (r9 != r2) goto L17;
        return r2;
    L7:
        r0 = new ResourceCenter$signUrl$1(this, r8);
        goto L8
    }

    public final Object n(List<ResourceSignUrlParamV2> r6, boolean r7, Continuation<? super List<ResourceSignUrlDataV2>> r8) {
        if ((r8 instanceof ResourceCenter$signUrlV2$1) == false) goto L7;
        ResourceCenter$signUrlV2$1 r0 = (ResourceCenter$signUrlV2$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L17:
        dm9.a.b r10 = (dm9.a) r9;
        if ((r10 instanceof dm9.a.a) == false) goto L21;
        FLogger.a.e("ResourceCenter", "[signUrlV2] failed, " + r10);
        return CollectionsKt.emptyList();
    L21:
        if ((r10 instanceof dm9.a.b) == false) goto L35;
        List r11 = (List) r10.a.getData();
        List r12 = r11;
        if (r12 != null) goto L25;
    L28:
        if (r4 == false) goto L30;
        FLogger.a.e("ResourceCenter", "[signUrlV2] failed, registerResp is null");
    L31:
        if (r11 == null) goto L33;
        return r11;
    L33:
        return CollectionsKt.emptyList();
    L30:
        FLogger.a.i("ResourceCenter", "[signUrlV2] success, registerResp=" + r11);
        goto L31
    L25:
        if (r12.isEmpty() == true) goto L28;
        r4 = false;
        goto L28
    L35:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        ResourceApi.a r13 = ResourceApi.a;
        ResourceCenter$signUrlV2$2 r5 = new ResourceCenter$signUrlV2$2(r6, r7, null);
        r0.label = 1;
        r13.getClass();
        r9 = ResourceApi.a.a("/alice/resource/v2/sign_url", r5, r0);
        if (r9 != r2) goto L17;
        return r2;
    L7:
        r0 = new ResourceCenter$signUrlV2$1(this, r8);
        goto L8
    }

    public final Object h(String r6, String r7, boolean r8, Continuation<? super GetVideoModelResultItem> r9) {
        if ((r9 instanceof ResourceCenter$getVideoModelResult$1) == false) goto L7;
        ResourceCenter$getVideoModelResult$1 r0 = (ResourceCenter$getVideoModelResult$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r8 = r0.Z$0;
        r6 = (String) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L17:
        dm9.a.b r11 = (dm9.a) r10;
        if ((r11 instanceof dm9.a.a) == false) goto L21;
        FLogger.a.e("ResourceCenter", "[getVideoModel] failed, " + r11);
        return null;
    L21:
        if ((r11 instanceof dm9.a.b) == false) goto L54;
        GetVideoModelResults r12 = (GetVideoModelResults) r11.a.getData();
        if (r12 == null) goto L51;
        FLogger.a.i("ResourceCenter", "[getVideoModel] success, " + r12);
        if (r8 == false) goto L31;
        List<GetVideoModelResultItem> r13 = r12.getResults();
        if (r13 == null) goto L47;
        List r14 = CollectionsKt.filterNotNull(r13);
        if (r14 == null) goto L47;
        GetVideoModelResultItem r15 = (GetVideoModelResultItem) CollectionsKt.firstOrNull(r14);
    L48:
        if (r15 == null) goto L51;
        return r15;
    L47:
        r15 = null;
        goto L48
    L31:
        List<GetVideoModelResultItem> r16 = r12.getResults();
        if (r16 == null) goto L47;
        List r17 = CollectionsKt.filterNotNull(r16);
        if (r17 == null) goto L47;
        Iterator r18 = r17.iterator();
    L37:
        if (r18.hasNext() == false) goto L45;
        Object r19 = r18.next();
        GetVideoModelParam r20 = ((GetVideoModelResultItem) r19).getParams();
        if (r20 == null) goto L41;
        String r21 = r20.getResourceId();
    L43:
        if (Intrinsics.areEqual(r21, r6) == false) goto L37;
    L46:
        r15 = (GetVideoModelResultItem) r19;
        goto L48
    L41:
        r21 = null;
        goto L43
    L45:
        r19 = null;
    L51:
        FLogger.a.e("ResourceCenter", "[getVideoModel] failed, data is null");
        return null;
    L54:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        ResourceApi.a r22 = ResourceApi.a;
        ResourceCenter$getVideoModelResult$2 r4 = new ResourceCenter$getVideoModelResult$2(r7, r6, null);
        r0.L$0 = r6;
        r0.Z$0 = r8;
        r0.label = 1;
        r22.getClass();
        r10 = ResourceApi.a.a("/alice/resource/get_video_model", r4, r0);
        if (r10 != r2) goto L17;
        return r2;
    L7:
        r0 = new ResourceCenter$getVideoModelResult$1(this, r9);
        goto L8
    }

    public final Object l(List<FlowResource> r6, ResourceAttachmentExtra r7, String r8, Continuation<? super dm9.a<? extends Map<String, ResourceRegisterData>>> r9) {
        if ((r9 instanceof ResourceCenter$register$1) == false) goto L7;
        ResourceCenter$register$1 r0 = (ResourceCenter$register$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = (List) r0.L$0;
        ResultKt.throwOnFailure(r10);
    L21:
        dm9.a.b r11 = (dm9.a) r10;
        if ((r11 instanceof dm9.a.a) == false) goto L25;
        FLogger.a.e("ResourceCenter", "[register] failed, " + r11);
    L46:
        return r11;
    L25:
        if ((r11 instanceof dm9.a.b) == false) goto L48;
        Map r12 = (Map) r11.a.getData();
        if (r12 != null) goto L29;
        FLogger.a.e("ResourceCenter", "[register] failed, registerResp is null");
        goto L46
    L29:
        FLogger.a.i("ResourceCenter", "[register] registerResp=" + r12);
        a.getClass();
        Iterator<FlowResource> r13 = r6.iterator();
    L31:
        if (r13.hasNext() == false) goto L46;
        FlowResource r14 = r13.next();
        ConcurrentHashMap<String, String> r4 = e;
        String r5 = r14.getIdentifier();
        String r15 = "";
        if (r5 != null) goto L35;
        r5 = "";
    L35:
        String r16 = r14.getUri();
        if (r16 != null) goto L38;
        r16 = "";
    L38:
        ResourceRegisterData r17 = (ResourceRegisterData) r12.get(r16);
        if (r17 == null) goto L41;
        String r18 = r17.getResourceId();
    L42:
        if (r18 == null) goto L45;
        r15 = r18;
    L45:
        r4.put(r5, r15);
        goto L31
    L41:
        r18 = null;
        goto L42
    L48:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        String r19 = f().c();
        if (r19 == null) goto L18;
        r8 = r19;
    L18:
        ResourceApi.a r20 = ResourceApi.a;
        ResourceCenter$register$2 r21 = new ResourceCenter$register$2(r8, r6, r7, null);
        r0.L$0 = r6;
        r0.label = 1;
        r20.getClass();
        r10 = ResourceApi.a.a("/alice/resource/register", r21, r0);
        if (r10 != r2) goto L21;
        return r2;
    L7:
        r0 = new ResourceCenter$register$1(this, r9);
        goto L8
    }

    public static /* synthetic */ Object i(ResourceCenter r2, String r3, String r4, boolean r5, Continuation r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = false;
    L12:
        return r2.h(r3, r4, r5, r6);
    }
}
