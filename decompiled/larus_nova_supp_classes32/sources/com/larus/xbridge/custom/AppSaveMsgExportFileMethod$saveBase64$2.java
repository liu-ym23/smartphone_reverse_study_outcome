package com.larus.xbridge.custom;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.util.Base64;
import com.bytedance.router.SmartRouter;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import com.larus.common.apphost.AppHost;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.mammon.speechaudiosdk.session.type.SpeechEvent;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.xbridge.custom.AppSaveMsgExportFileMethod$saveBase64$2", f = "AppSaveMsgExportFileMethod.kt", i = {0}, l = {SpeechEvent.SERVER_UPLINK_EVENT_TRIGGER_BOT, 115}, m = "invokeSuspend", n = {"cacheFilePath"}, s = {"L$0"})
final class AppSaveMsgExportFileMethod$saveBase64$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $base64Content;
    final /* synthetic */ IvyBridgeMethod.a $callback;
    final /* synthetic */ String $fileName;
    final /* synthetic */ cx7.d $params;
    Object L$0;
    int label;
    final /* synthetic */ y this$0;

    /* JADX INFO: renamed from: com.larus.xbridge.custom.AppSaveMsgExportFileMethod$saveBase64$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.xbridge.custom.AppSaveMsgExportFileMethod$saveBase64$2$1", f = "AppSaveMsgExportFileMethod.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $finalPath;
        final /* synthetic */ cx7.d $params;
        int label;
        final /* synthetic */ y this$0;

        public AnonymousClass1(y r1, String r2, cx7.d r3, Continuation<? super AnonymousClass1> r4) {
            this.this$0 = r1;
            this.$finalPath = r2;
            this.$params = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.this$0, this.$finalPath, this.$params, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L19;
            ResultKt.throwOnFailure(r8);
            y r9 = this.this$0;
            String r0 = this.$finalPath;
            cx7.d r1 = this.$params;
            int r2 = y.b;
            ex7.d r10 = ((bx7.c) r9).a;
            if (r10 == null) goto L17;
            Context r11 = (Context) r10.a(Context.class);
            if (r11 == null) goto L17;
            Activity r3 = com.bytedance.ies.xbridge.utils.f.a.getActivity(r11);
            if (r3 == null) goto L17;
            if (AppHost.a.isTestChannel() == false) goto L15;
            Uri r4 = Uri.fromFile(new PolarisFileWrapper(r0));
            Intrinsics.checkNotNull(r4);
            String r5 = y.g(r11, r4);
            FLogger.a.d("AppSaveFileMethod", "mimeType for file: " + r5);
        L15:
            String r6 = r1.getString("botId");
            String r7 = r1.getString("exportId");
            com.bytedance.router.i r12 = SmartRouter.buildRoute(r11, "//flow/file_preview");
            r12.c.putExtra("arg_file_path", r0);
            r12.c.putExtra("arg_bot_id", r6);
            r12.c.putExtra("arg_export_id", r7);
            r12.c.putExtra("arg_previous_page", "h5_exporting_file_loading");
            r12.d = 0;
            r12.e = 0;
            r12.d();
            r3.finish();
        L17:
            return Unit.INSTANCE;
        L19:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AppSaveMsgExportFileMethod$saveBase64$2(String r1, String r2, y r3, IvyBridgeMethod.a r4, cx7.d r5, Continuation<? super AppSaveMsgExportFileMethod$saveBase64$2> r6) {
        this.$base64Content = r1;
        this.$fileName = r2;
        this.this$0 = r3;
        this.$callback = r4;
        this.$params = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new AppSaveMsgExportFileMethod$saveBase64$2(this.$base64Content, this.$fileName, this.this$0, this.$callback, this.$params, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r14);
    L64:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        String r2 = (String) this.L$0;
        ResultKt.throwOnFailure(r14);
    L53:
        String r15 = (String) r14;
        if (r15 == null) goto L57;
        r2 = r15;
    L57:
        IFlowSdkDepend r16 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r16 == null) goto L60;
        r16.D0();
        Boxing.boxBoolean(com.larus.home.impl.sdk.b1.a.b(r2));
    L60:
        bx7.c.d(this.this$0, this.$callback, new LinkedHashMap());
        MainCoroutineDispatcher r17 = Dispatchers.getMain();
        AnonymousClass1 r4 = new AnonymousClass1(this.this$0, r2, this.$params, null);
        this.L$0 = null;
        this.label = 2;
        if (BuildersKt.withContext(r17, r4, this) != r0) goto L64;
        return r0;
    L10:
        ResultKt.throwOnFailure(r14);
        if (this.$base64Content.length() != 0) goto L13;
        boolean r18 = true;
    L15:
        if (r18 == false) goto L17;
    L67:
        bx7.c.c(this.this$0, this.$callback, 0, "params invalid, content and name can't empty", 8);
        return Unit.INSTANCE;
    L17:
        if (this.$fileName.length() != 0) goto L19;
        boolean r19 = true;
    L20:
        if (r19 == true) goto L67;
        String r110 = this.$base64Content;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L25
        Object r111 = Result.constructor-impl(Base64.decode(r110, 0));     // Catch: Throwable -> L25
    L28:
        if (Result.isFailure-impl(r111) == false) goto L30;
        r111 = null;
    L30:
        byte[] r112 = (byte[]) r111;
        if (r112 != null) goto L33;
    L65:
        FLogger.a.e("AppSaveFileMethod", "content decode failed");
        bx7.c.c(this.this$0, this.$callback, 0, "content decode failed", 8);
        return Unit.INSTANCE;
    L33:
        if (r112.length != 0) goto L35;
        boolean r7 = true;
    L36:
        if (r7 == true) goto L65;
        y r8 = this.this$0;
        int r9 = y.b;
        r8.getClass();
        File r10 = AppHost.a.getApplication().getExternalFilesDir(null);
        StringBuilder r11 = new StringBuilder();
        r11.append(r10);
        String r12 = File.separator;
        r11.append(r12);
        r11.append("export");
        r11.append(r12);
        String r13 = r11.toString() + this.$fileName;
        FLogger r20 = FLogger.a;
        r20.d("AppSaveFileMethod", "cache file path: " + r13);
        PolarisFileWrapper r21 = new PolarisFileWrapper(r13);
        if (r21.exists() == true) goto L49;
        File r113 = r21.getParentFile();
        if (r113 == null) goto L46;
        if (r113.exists() == true) goto L46;
        r113.mkdirs();
        r20.w("AppSaveFileMethod", "mkdirs " + r113.getAbsolutePath());
    L46:
        if (r21.createNewFile() == true) goto L49;
        r20.e("AppSaveFileMethod", "create new file failed");
        bx7.c.c(this.this$0, this.$callback, 0, "create file failed", 8);
        return Unit.INSTANCE;
    L49:
        FilesKt.writeBytes(r21, r112);
        y r114 = this.this$0;
        this.L$0 = r13;
        this.label = 1;
        r14 = y.f(r114, r13, this);
        if (r14 != r0) goto L52;
        return r0;
    L52:
        r2 = r13;
        goto L53
    L35:
        r7 = false;
    L25:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r111 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    L19:
        r19 = false;
        goto L20
    L13:
        r18 = false;
        goto L15
    }
}
