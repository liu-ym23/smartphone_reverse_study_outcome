package com.obric.miniapp.view;

import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.AIPackage;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.resource.AIManager;
import com.larus.utils.logger.FLogger;
import com.obric.miniapp.utils.MiniAppUtils;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.view.MiniAppBaseActivity$launchApplet$1", f = "MiniAppBaseActivity.kt", i = {}, l = {537}, m = "invokeSuspend", n = {}, s = {})
final class MiniAppBaseActivity$launchApplet$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appletId;
    final /* synthetic */ boolean $checkUpdate;
    int label;
    final /* synthetic */ MiniAppBaseActivity this$0;

    /* JADX INFO: renamed from: com.obric.miniapp.view.MiniAppBaseActivity$launchApplet$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.miniapp.view.MiniAppBaseActivity$launchApplet$1$1", f = "MiniAppBaseActivity.kt", i = {2}, l = {538, 539, 541, 594}, m = "invokeSuspend", n = {"hasNewVersion"}, s = {"I$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $appletId;
        final /* synthetic */ boolean $checkUpdate;
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ MiniAppBaseActivity this$0;

        public AnonymousClass1(String r1, MiniAppBaseActivity r2, boolean r3, Continuation<? super AnonymousClass1> r4) {
            this.$appletId = r1;
            this.this$0 = r2;
            this.$checkUpdate = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$appletId, this.this$0, this.$checkUpdate, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r15v0, types: [android.app.Activity, com.obric.miniapp.view.MiniAppBaseActivity, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v6, types: [androidx.activity.ComponentActivity, com.obric.miniapp.view.MiniAppBaseActivity] */
        public final Object invokeSuspend(Object r17) {
            Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r0 = this.label;
            if (r0 == 0) goto L14;
            if (r0 == 1) goto L13;
            if (r0 == 2) goto L12;
            if (r0 == 3) goto L11;
            if (r0 != 4) goto L10;
            String r1 = (String) this.L$1;
            MiniAppBaseActivity r2 = (MiniAppBaseActivity) this.L$0;
            ResultKt.throwOnFailure(r17);
            ?? r4 = r2;
        L75:
            if (r4.m == true) goto L78;
            MiniAppUtils r5 = MiniAppUtils.a;
            MiniAppUtils.i(r4, r1);
        L78:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            int r6 = this.I$0;
            ResultKt.throwOnFailure(r17);
            Object r7 = r17;
        L34:
            int r8 = r6;
            Applet r9 = (Applet) r7;
            if (r9 == null) goto L78;
            ?? r15 = this.this$0;
            String r14 = this.$appletId;
            boolean r10 = this.$checkUpdate;
            LinkedHashMap r11 = new LinkedHashMap();
            r15.getClass();
            r11.put("hideTitleBar", String.valueOf(1));
            String r12 = "0";
            r11.put("closeActivity", "0");
            if (r15.S1() == false) goto L39;
            Object r13 = "1";
        L40:
            r11.put("transStatusBar", r13);
            if (r15.R1() == false) goto L43;
            r12 = "1";
        L43:
            r11.put("transNavigationBar", r12);
            String r16 = r15.getIntent().getStringExtra("launchFrom");
            if (r16 == null) goto L46;
            r11.put("launchFrom", r16);
        L46:
            String r18 = r15.getIntent().getStringExtra("pageId");
            if (r18 != null) goto L49;
            r18 = r9.O;
        L49:
            String r19 = r18;
            String r20 = r15.getIntent().getStringExtra("pageData");
            if (r20 != null) goto L54;
            r20 = r15.getIntent().getStringExtra("pageDate");
            if (r20 != null) goto L54;
            r20 = "";
        L54:
            String r110 = r20;
        L64:
            e = move-exception;
            FLogger.a.e("MiniAppBaseActivity", "exception in preprocessing pageData: " + e + ' ');
        L66:
            FLogger.a.i("MiniAppBaseActivity", "currentPageData: " + r110);
            LinkedHashMap r21 = new LinkedHashMap();
            r21.put("appletId", r15.P1());
            r21.put("pageId", r19);
            r21.put("pageType", "full");
            r21.put("pageSettings", r11);
            r21.put("pageData", r110);
            MainCoroutineDispatcher r22 = Dispatchers.getMain();
            if (r8 == 0) goto L69;
            boolean r111 = true;
        L70:
            MiniAppBaseActivity$launchApplet$1$1$1$3 r23 = new MiniAppBaseActivity$launchApplet$1$1$1$3(r10, r111, r15, r21, null);
            this.L$0 = r15;
            this.L$1 = r14;
            this.label = 4;
            if (BuildersKt.withContext(r22, r23, this) != r3) goto L73;
            return r3;
        L73:
            r1 = r14;
            r4 = r15;
            goto L75
        L69:
            r111 = false;
            goto L70
        L56:
            if (r110.length() != 0) goto L58;
            boolean r24 = true;
        L60:
            if (r24 == false) goto L62;
            JSONObject r25 = new JSONObject();     // Catch: JSONException -> L64
            r25.put("fromMiniApp", true);     // Catch: JSONException -> L64
            r110 = r25.toString();     // Catch: JSONException -> L64
        L79:
            goto L66
        L62:
            JSONObject r26 = new JSONObject(r110);     // Catch: JSONException -> L64
            r26.put("fromMiniApp", true);     // Catch: JSONException -> L64
            r110 = r26.toString();     // Catch: JSONException -> L64
            goto L79
        L58:
            r24 = false;
            goto L60
        L39:
            r13 = "0";
            goto L40
        L12:
            ResultKt.throwOnFailure(r17);
            Object r27 = r17;
        L22:
            Integer r28 = (Integer) r27;
            if (r28 != null) goto L26;
        L30:
            r6 = 0;
        L31:
            AIManager r29 = AIManager.a;
            String r30 = this.$appletId;
            this.I$0 = r6;
            this.label = 3;
            r7 = r29.C(r30, null, this);
            if (r7 != r3) goto L34;
            return r3;
        L26:
            if (r28.intValue() != 1) goto L30;
            AppletRuntimeManager r31 = AppletRuntimeManager.INSTANCE;
            String r32 = this.$appletId;
            r31.getClass();
            if (AppletRuntimeManager.i("SYSTEM_CVS_ID", "SYSTEM_CVS_ID", r32) == null) goto L30;
            r6 = 1;
            goto L31
        L13:
            ResultKt.throwOnFailure(r17);
            Object r33 = r17;
        L18:
            if (((Boolean) r33).booleanValue() == false) goto L30;
            AIManager r34 = AIManager.a;
            String r35 = this.$appletId;
            this.label = 2;
            r27 = r34.p(r35, this);
            if (r27 != r3) goto L22;
            return r3;
        L14:
            ResultKt.throwOnFailure(r17);
            AIManager r36 = AIManager.a;
            String r37 = this.$appletId;
            AIPackage.AIPackageType r112 = AIPackage.AIPackageType.APPLET;
            this.label = 1;
            r33 = r36.r(r37, r112, this);
            if (r33 != r3) goto L18;
            return r3;
        }
    }

    public MiniAppBaseActivity$launchApplet$1(String r1, MiniAppBaseActivity r2, boolean r3, Continuation<? super MiniAppBaseActivity$launchApplet$1> r4) {
        this.$appletId = r1;
        this.this$0 = r2;
        this.$checkUpdate = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MiniAppBaseActivity$launchApplet$1(this.$appletId, this.this$0, this.$checkUpdate, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        CoroutineDispatcher r9 = Dispatchers.getIO();
        AnonymousClass1 r2 = new AnonymousClass1(this.$appletId, this.this$0, this.$checkUpdate, null);
        this.label = 1;
        if (BuildersKt.withContext(r9, r2, this) != r0) goto L12;
        return r0;
    }
}
