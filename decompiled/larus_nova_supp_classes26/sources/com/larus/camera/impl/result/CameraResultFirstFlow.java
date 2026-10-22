package com.larus.camera.impl.result;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.chat.camera.command.CameraCommandSideEffectFactory;
import com.larus.bmhome.chat.camera.command.d;
import com.larus.bmhome.chat.camera.command.e;
import com.larus.bmhome.chat.camera.command.f;
import com.larus.bmhome.chat.camera.command.i;
import com.larus.bmhome.chat.camera.command.k;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.CameraResultOutOpenParams;
import com.larus.camera.api.params.ImageParam;
import com.larus.camera.api.params.InputParam;
import com.larus.camera.api.params.InputParamExtra;
import com.larus.camera.api.params.OutputParam;
import com.larus.camera.impl.FlowCameraImpl;
import com.larus.camera.impl.ui.activity.CameraResultFirstActivity;
import com.larus.camera.impl.ui.viewmodel.t;
import com.larus.camera.impl.ui.viewmodel.z;
import com.larus.camera.impl.utils.l;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.api.g3;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.service.k2;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.chat.ObricChatSPIServiceDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import od8.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class CameraResultFirstFlow {
    public static final CameraResultFirstFlow a = null;
    public static final CoroutineScope b = null;
    public static final ConcurrentHashMap<String, a> c = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/camera/impl/result/CameraResultFirstFlow$CreationPageReturnResult;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_RESULT_FIRST", "RESULT_FIRST_COMPLETED", "RESULT_FIRST_FAILED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CreationPageReturnResult extends Enum<CreationPageReturnResult> {
        public static final CreationPageReturnResult NOT_RESULT_FIRST = null;
        public static final CreationPageReturnResult RESULT_FIRST_COMPLETED = null;
        public static final CreationPageReturnResult RESULT_FIRST_FAILED = null;
        public static final /* synthetic */ CreationPageReturnResult[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<CreationPageReturnResult> getEntries() {
            return b;
        }

        static {
            CreationPageReturnResult r0 = new CreationPageReturnResult("NOT_RESULT_FIRST", 0);
            NOT_RESULT_FIRST = r0;
            CreationPageReturnResult r1 = new CreationPageReturnResult("RESULT_FIRST_COMPLETED", 1);
            RESULT_FIRST_COMPLETED = r1;
            CreationPageReturnResult r3 = new CreationPageReturnResult("RESULT_FIRST_FAILED", 2);
            RESULT_FIRST_FAILED = r3;
            CreationPageReturnResult[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static CreationPageReturnResult[] values() {
            return (CreationPageReturnResult[]) a.clone();
        }

        public static CreationPageReturnResult valueOf(String r1) {
            return (CreationPageReturnResult) r27.a.a(CreationPageReturnResult.class, r1);
        }

        public CreationPageReturnResult(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final ex8.b a;
        public final iga.c b;
        public final CoroutineScope c;
        public final CompletableDeferred<BotModel> d;
        public final long e;
        public final ConcurrentHashMap<Integer, Pair<z0, Boolean>> f;
        public BotModel g;
        public SuggestedAction h;
        public final d i;
        public final com.larus.bmhome.chat.camera.command.c j;

        /* JADX INFO: renamed from: com.larus.camera.impl.result.CameraResultFirstFlow$a$a, reason: collision with other inner class name */
        public static final class C0078a implements d {
            public final /* synthetic */ a b;

            public C0078a(a r1) {
                this.b = r1;
            }

            public final void b(SuggestedAction r2) {
                a r0 = this.b;
                r0.h = r2;
                d r1 = r0.i;
                if (r1 == null) goto L6;
                r1.b(r2);
                return;
            }

            public final Intent e(Uri r2) {
                Intrinsics.checkNotNullParameter(r2, "uri");
                d r0 = this.b.i;
                if (r0 != null) goto L7;
                return null;
            L7:
                return r0.e(r2);
            }

            public final Intent c(String r2, Uri r3) {
                Intrinsics.checkNotNullParameter(r2, "scene");
                Intrinsics.checkNotNullParameter(r3, "uri");
                d r0 = this.b.i;
                if (r0 != null) goto L7;
                return null;
            L7:
                return r0.c(r2, r3);
            }

            public final void d(boolean r2, List<?> r3) {
                Intrinsics.checkNotNullParameter(r3, "data");
                d r0 = this.b.i;
                if (r0 == null) goto L6;
                r0.d(r2, r3);
                return;
            }
        }

        public static final class b implements f {
            public final /* synthetic */ a a;

            public final boolean c1() {
                return false;
            }

            public final boolean i9() {
                return false;
            }

            public final boolean k5() {
                return false;
            }

            public final BotModel a() {
                return this.a.g;
            }

            public b(a r1) {
                this.a = r1;
            }
        }

        public static final class c implements e {
            public final /* synthetic */ a a;

            public final void P8() {
            }

            public final Pair<z0, Boolean> A7() {
                return a.a(this.a, 24);
            }

            public final Pair<z0, Boolean> N8() {
                return a.a(this.a, 16);
            }

            public final wc9.e O8() {
                iga.c r0 = this.a.b;
                if (r0 == null) goto L7;
                wc9.e r1 = r0.b;
                if (r1 == null) goto L7;
                return r1;
            L7:
                return (wc9.e) AuthModelDelegate.b.y().getValue();
            }

            public final BotModel a() {
                return this.a.g;
            }

            public final long chatKey() {
                return this.a.e;
            }

            public c(a r1) {
                this.a = r1;
            }

            public final void b(SuggestedAction r2) {
                this.a.h = r2;
            }
        }

        public final void b(BotModel r2) {
            this.g = r2;
            if (this.d.isCompleted() == true) goto L6;
            this.d.complete(r2);
            return;
        }

        public a(ex8.b r6, iga.c r7) {
            this.a = r6;
            this.b = r7;
            CoroutineScope r8 = CoroutineScopeKt.MainScope();
            this.c = r8;
            m0 r0 = null;
            CompletableDeferred<BotModel> r1 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
            if (r7 == null) goto L7;
            BotModel r2 = r7.a;
            if (r2 == null) goto L7;
            r1.complete(r2);
        L7:
            this.d = r1;
            this.e = SystemClock.elapsedRealtime();
            this.f = new ConcurrentHashMap();
            if (r7 == null) goto L10;
            BotModel r9 = r7.a;
        L11:
            this.g = r9;
            c r10 = new c(this);
            CameraCommandSideEffectFactory r3 = (CameraCommandSideEffectFactory) ServiceManager.get().getService(CameraCommandSideEffectFactory.class);
            if (r3 == null) goto L14;
            r0 = r3.a(r10);
        L14:
            this.i = r0;
            this.j = new com.larus.bmhome.chat.camera.command.c(new b(this), new i(r8, r1, r10), new C0078a(this));
            return;
        L10:
            r9 = null;
            goto L11
        }

        public static final Pair a(a r3, int r4) {
            Pair<z0, Boolean> r0 = r3.f.get(Integer.valueOf(r4));
            if (r0 != null) goto L21;
            com.larus.bmhome.chat.camera.command.a r1 = com.larus.bmhome.chat.camera.command.a.a;
            BotModel r2 = r3.g;
            if (r2 == null) goto L9;
            String r5 = r2.getBotId();
            if (r5 == null) goto L9;
        L15:
            r1.getClass();
            Pair<z0, Boolean> r6 = com.larus.bmhome.chat.camera.command.a.a(r5, r4);
            if (r6 == null) goto L19;
            r3.f.put(Integer.valueOf(r4), r6);
            return r6;
        L19:
            return null;
        L9:
            e0 r7 = (e0) AuthModelDelegate.b.e().getValue();
            if (r7 == null) goto L14;
            LaunchInfo r8 = r7.a;
            if (r8 == null) goto L14;
            r5 = r8.W();
        L14:
            r5 = null;
            goto L15
        L21:
            return r0;
        }
    }

    public CameraResultFirstFlow() {
    }

    static {
        a = new CameraResultFirstFlow();
        b = CoroutineScopeKt.MainScope();
        c = new ConcurrentHashMap();
    }

    public static void h(String r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        a r4 = c.remove(r3);
        if (r4 != null) goto L14;
        return;
    L14:
        if (FlowCameraImpl.c != r4.j) goto L16;
        FlowCameraImpl.c = r4.a;
    L16:
        r4.b(null);
        CoroutineScopeKt.cancel$default(r4.c, null, 1, null);
        return;
    L5:
        if (r3.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public static ParcelFileDescriptor b(ContentResolver r20, Uri r21) {
        ArrayList r1 = new ArrayList();
        Object[] r2 = {r21, "r"};
        f06.b r13 = new f06.b();
        g06.a r3 = (g06.a) ApiHookConfig.b.get(240020);
        if (r3 == null) goto L5;
        f06.a[] r4 = r3.i;
    L6:
        f06.a[] r10 = r4;
        int r9 = r10.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r10[r8];
        int r17 = r8;
        int r18 = r9;
        f06.a[] r19 = r10;
        f06.d r5 = r7.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r20, r2, "android.os.ParcelFileDescriptor", r13);     // Catch: Exception -> L22
        if (r5.a == true) goto L17;
        r1.add(r7);     // Catch: Exception -> L22
    L17:
        if (r5.a == false) goto L21;
        return (ParcelFileDescriptor) r5.b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r20, r21, "r");
    L14:
        r8 = r17 + 1;
        r9 = r18;
        r10 = r19;
        goto L8
    L15:
        r5 = new f06.d(false, null);
        goto L17
    L5:
        r4 = ApiHookConfig.d;
        goto L6
    }

    public static CreationPageReturnResult d(Activity r3, String r4) {
        Intent r5 = r3.getIntent();
        if (r5 == null) goto L5;
        String r6 = r5.getStringExtra("extra_camera_result_first_command_session_id");
        if (r6 == null) goto L9;
        h(r6);
        ObricChatSPIServiceDelegate r7 = ObricChatSPIServiceDelegate.b;
        Bundle r0 = new Bundle();
        if (r4 == null) goto L22;
        if (r4.length() <= 0) goto L15;
        boolean r1 = true;
    L16:
        if (r1 == false) goto L18;
        String r2 = r4;
    L19:
        if (r2 == null) goto L22;
        r0.putString("argConversationId", r2);
        goto L22
    L18:
        r2 = null;
        goto L19
    L15:
        r1 = false;
    L22:
        if (r7.m(r0) == false) goto L24;
        FLogger.a.i("CameraResultFirstFlow", "open chat for sent creation message, conversationId=" + r4);
        return CreationPageReturnResult.RESULT_FIRST_COMPLETED;
    L24:
        FLogger.a.e("CameraResultFirstFlow", "open chat failed for sent creation message, conversationId=" + r4);
        return CreationPageReturnResult.RESULT_FIRST_FAILED;
    L9:
        return CreationPageReturnResult.NOT_RESULT_FIRST;
    L5:
        return CreationPageReturnResult.NOT_RESULT_FIRST;
    }

    public static boolean i(Context r9, CameraResultOutOpenParams r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "params");
        String r0 = r10.getImgPath();
        if (r0 == null) goto L22;
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L22;
        Uri r1 = UriProtector.parse(r0);
        if (r1 == null) goto L22;
        if (k2.a.x() == true) goto L14;
    L19:
        BuildersKt.launch$default(b, null, null, new CameraResultFirstFlow$start$1(r9, r1, r10, null), 3, null);
        return true;
    L14:
        if (g3.a.d() == false) goto L19;
        if (g3.a.e() == true) goto L19;
        return j(r9, r10);
    L22:
        return j(r9, r10);
    }

    public static boolean j(Context r8, CameraResultOutOpenParams r9) {
        t r2 = t.a;
        t.h();
        String r3 = UUID.randomUUID().toString();
        Activity r5 = null;
        a r4 = new a(FlowCameraImpl.c, null);
        c.put(r3, r4);
        FlowCameraImpl.c = r4.j;
        wc9.e r6 = (wc9.e) AuthModelDelegate.b.y().getValue();
        if (r6 == null) goto L5;
        String r7 = r6.a;
    L6:
        if (r7 != null) goto L8;
    L11:
        boolean r10 = true;
    L12:
        if (r10 == false) goto L14;
        r4.b(null);
    L31:
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L23
        r8.startActivity(e(r8, r9, r3));     // Catch: Throwable -> L23
        if ((r8 instanceof Activity) == false) goto L18;
        r5 = (Activity) r8;     // Catch: Throwable -> L23
    L18:
        if (r5 == null) goto L21;
        r5.overridePendingTransition(2130772349, 2130772350);     // Catch: Throwable -> L23
    L21:
        FLogger.a.i("CameraResultFirstFlow", "start result page, commandSessionId=" + r3);     // Catch: Throwable -> L23
        Object r12 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L23
    L25:
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L30;
        FLogger.a.e("CameraResultFirstFlow", "start result page failed", r13);
        a.getClass();
        h(r3);
        r12 = Boolean.FALSE;
    L30:
        return ((Boolean) r12).booleanValue();
    L23:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L14:
        com.larus.im.d.a().getBotByConversationId(r7, new c(r4));
        goto L31
    L8:
        if (r7.length() == 0) goto L11;
        r10 = false;
        goto L12
    L5:
        r7 = null;
        goto L6
    }

    public static final long a(CameraResultFirstFlow r9, Context r10, Uri r11) {
        r9.getClass();
        long r1 = -1;
        Object r3 = -1L;
        PolarisFileWrapper r4 = null;
        if (Intrinsics.areEqual(ShareType.FILE, r11.getScheme()) == false) goto L70;
        String r12 = r11.getPath();
        if (r12 == null) goto L7;
        r4 = new PolarisFileWrapper(r12);
    L7:
        if (r4 == null) goto L11;
        boolean r13 = true;
        if (r4.exists() != true) goto L11;
    L12:
        if (r13 == true) goto L74;
        return -1;
    L74:
        return r4.length();
    L11:
        r13 = false;
        goto L12
    L70:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L27
        ParcelFileDescriptor r2 = b(r10.getContentResolver(), r11);     // Catch: Throwable -> L27
        if (r2 != null) goto L66;
        long r5 = -1;
    L25:
        Object r6 = Result.constructor-impl(Long.valueOf(r5));     // Catch: Throwable -> L27
    L30:
        if (Result.isFailure-impl(r6) == false) goto L32;
        r6 = r3;
    L32:
        long r7 = ((Number) r6).longValue();
        if (r7 >= 0) goto L75;
        Cursor r14 = c(r10.getContentResolver(), r11, new String[]{"_size"});     // Catch: Throwable -> L55
        if (r14 == null) goto L53;
        Cursor r15 = r14;     // Catch: Throwable -> L55
        Cursor r16 = r15;     // Catch: Throwable -> L48
        if (r16.moveToFirst() == false) goto L46;
        int r17 = r16.getColumnIndex("_size");     // Catch: Throwable -> L48
        if (r17 < 0) goto L46;
        if (r16.isNull(r17) == true) goto L46;
        r1 = r16.getLong(r17);     // Catch: Throwable -> L48
        goto L46
    L46:
        CloseableKt.closeFinally(r15, null);     // Catch: Throwable -> L55
    L48:
        th = move-exception;
        throw th;     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);     // Catch: Throwable -> L55
        throw th;     // Catch: Throwable -> L55
    L53:
        Object r18 = Result.constructor-impl(Long.valueOf(r1));     // Catch: Throwable -> L55
    L58:
        if (Result.isFailure-impl(r18) == true) goto L62;
        r3 = r18;
    L62:
        return ((Number) r3).longValue();
    L55:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L58
    L75:
        return r7;
    L66:
        r5 = r2.getStatSize();     // Catch: Throwable -> L19
        CloseableKt.closeFinally(r2, null);     // Catch: Throwable -> L27
        goto L25
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    }

    public static Cursor c(ContentResolver r12, Uri r13, String[] r14) {
        f06.c r8 = new f06.c();
        Object[] r9 = {r13, r14, null, null, null};
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(240004, "android/content/ContentResolver", "query", r12, r9, "android.database.Cursor", r10);
        if (r11.a == false) goto L6;
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, null, r10, false);
        return (Cursor) r11.b;
    L6:
        Cursor r15 = r12.query(r13, r14, null, null, null);
        r8.a(240004, "android/content/ContentResolver", "query", r12, r9, r15, r10, true);
        return r15;
    }

    public static Intent e(Context r9, CameraResultOutOpenParams r10, String r11) {
        Intent r0 = new Intent(r9, CameraResultFirstActivity.class);
        a.getClass();
        InputParamExtra r1 = new InputParamExtra();
        r1.put("PHOTO_RESULT_SURE_PAGE_ENTER_ANI", String.valueOf(2130772349));
        r1.put("PHOTO_RESULT_SURE_PAGE_EXIT_FINISH_ANI", String.valueOf(2130772350));
        r1.put("ENABLE_RESULT_SUGGESTED_ACTION", "true");
        r1.put("ENABLE_RESULT_MARKED_TIPS", "true");
        r1.put("OPEN_CAMERA_PAGE_TRIGGER_TIME_MS", String.valueOf(r10.getOpenPageTriggerTimeMs()));
        r1.put("OPEN_CAMERA_PAGE_PATH", "result_first");
        if (r10.getMarkTipsRest() == false) goto L5;
        l.a = false;
    L5:
        Intrinsics.checkNotNullParameter("common_bottom_menu", "scene");
        InputParam r2 = new InputParam(null);
        r2.setScene("common_bottom_menu");
        Intrinsics.checkNotNullParameter("CAPTURE_MODE_PHOTO", "captureMode");
        r2.setCaptureMode("CAPTURE_MODE_PHOTO");
        r2.setSupportMark(true);
        r2.setSupportCrop(true);
        r2.setSupportMultiImages(r10.getSupportMultiImages());
        r2.setInputStyle(z2.a.cameraFreeInputConfig().a);
        r2.setDisableCaptureDetect(r10.getDisableCaptureDetect());
        r2.setExtra(r1);
        r0.putExtra("CAMERA_INPUT_PARAM", r2);
        CameraOutputContext r3 = new CameraOutputContext();
        OutputParam[] r4 = new OutputParam[1];
        OutputParam r5 = new OutputParam();
        r5.setResultType(OutputParam.ResultType.PHOTO);
        ImageParam r6 = new ImageParam();
        String r7 = r10.getImgPath();
        if (r7 != null) goto L8;
        r7 = "";
    L8:
        r6.setPath(r7);
        r5.setImageParam(r6);
        Unit r8 = Unit.INSTANCE;
        r4[0] = r5;
        r3.setOutputParamList(CollectionsKt.mutableListOf(r4));
        r0.putExtra("CAMERA_OUTPUT_CONTEXT", r3);
        r0.putExtra("PREVIEW_PARAM_ORIENTATION", 0);
        r0.putExtra("SUPPORT_MARK_PARAM", true);
        r0.putExtra("PREVIEW_PARAM_ALBUM_URI", "");
        r0.putExtra("KEY_OPEN_CAMERA_RESULT_PAGE_OUT_OPEN_PARAMS", r10);
        r0.putExtra("extra_camera_result_first_command_session_id", r11);
        Iterator<Map.Entry<String, Boolean>> r12 = r10.getIntentBooleanExtras().entrySet().iterator();
    L10:
        if (r12.hasNext() == false) goto L13;
        Map.Entry<String, Boolean> r13 = r12.next();
        r0.putExtra(r13.getKey(), r13.getValue().booleanValue());
        goto L10
    L13:
        if ((r9 instanceof Activity) == true) goto L15;
        r0.addFlags(335577088);
    L15:
        return r0;
    }

    public static boolean g(String r4, CameraResultOutOpenParams r5, String r6) {
        ObricChatSPIServiceDelegate r0 = ObricChatSPIServiceDelegate.b;
        Bundle r1 = new Bundle();
        r1.putString("KEY_CAMERA_RESULT_PENDING_SESSION_ID", r4);
        if (r0.m(r1) == false) goto L5;
        FLogger.a.i("CameraResultFirstFlow", "open chat with " + r6 + " pending result key=" + r4);
        return true;
    L5:
        FLogger r2 = FLogger.a;
        StringBuilder r3 = new StringBuilder("open chat failed, source=");
        r3.append(r6);
        r3.append(", imgPath=");
        if (r5 == null) goto L8;
        String r7 = r5.getImgPath();
    L9:
        r3.append(r7);
        r2.e("CameraResultFirstFlow", r3.toString());
        k.b(r4);
        return false;
    L8:
        r7 = null;
        goto L9
    }

    public static Object f(Context r3, Uri r4, z r5, Continuation r6) {
        return BuildersKt.withContext(Dispatchers.getIO(), new CameraResultFirstFlow$getPreviewBitmapByUri$2(r3, r4, r5, null), r6);
    }
}
