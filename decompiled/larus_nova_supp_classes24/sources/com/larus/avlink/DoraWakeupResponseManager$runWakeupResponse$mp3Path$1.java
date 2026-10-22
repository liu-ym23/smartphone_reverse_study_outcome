package com.larus.avlink;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.dora.api.IDoraService;
import com.larus.settings.value.e10;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.random.Random;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.avlink.DoraWakeupResponseManager$runWakeupResponse$mp3Path$1", f = "DoraWakeupResponseManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraWakeupResponseManager$runWakeupResponse$mp3Path$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    int label;

    public DoraWakeupResponseManager$runWakeupResponse$mp3Path$1(Continuation<? super DoraWakeupResponseManager$runWakeupResponse$mp3Path$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraWakeupResponseManager$runWakeupResponse$mp3Path$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L62;
        ResultKt.throwOnFailure(r14);
        DoraWakeupResponseManager r15 = DoraWakeupResponseManager.a;
        IDoraService r6 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Exception -> L58
        if (r6 == null) goto L8;
        String r7 = r6.P();     // Catch: Exception -> L58
    L9:
        boolean r8 = false;
        if (r7 != null) goto L12;
    L15:
        boolean r9 = true;
    L16:
        String r10 = "";
        if (r9 == false) goto L21;
        e10 r11 = e10.a;     // Catch: Exception -> L58
        r7 = e10.f().a();     // Catch: Exception -> L58
        if (r7 != null) goto L21;
        r7 = "";
    L21:
        if (r7 == null) goto L25;
        r10 = r7;
    L25:
        if (r10.length() != 0) goto L27;
        boolean r12 = true;
    L28:
        if (r12 == false) goto L30;
        FLogger.a.i("DoraWakeupResponse", "resolveWakeupResponseMp3Path: styleId is empty");     // Catch: Exception -> L58
        return null;
    L30:
        FLogger r13 = FLogger.a;     // Catch: Exception -> L58
        r13.i("DoraWakeupResponse", "resolveWakeupResponseMp3Path: bundle=index, channel=com_flow_dora_netural_wakeup");     // Catch: Exception -> L58
        String r16 = com.larus.platform.service.c1.a.b("index", "com_flow_dora_netural_wakeup", true);     // Catch: Exception -> L58
        if (r16.length() != 0) goto L33;
        boolean r17 = true;
    L34:
        if (r17 == false) goto L36;
        r13.i("DoraWakeupResponse", "resolveWakeupResponseMp3Path: loadSync return empty, styleId=".concat(r10));     // Catch: Exception -> L58
        return null;
    L36:
        File r4 = new PolarisFileWrapper(r16).getParentFile();     // Catch: Exception -> L58
        if (r4 != null) goto L39;
    L56:
        r13.i("DoraWakeupResponse", "resolveWakeupResponseMp3Path: rootDir invalid, indexPath=".concat(r16));     // Catch: Exception -> L58
        return null;
    L39:
        if (r4.isDirectory() == false) goto L56;
        PolarisFileWrapper r3 = new PolarisFileWrapper(r4, r10);     // Catch: Exception -> L58
        if (r3.isDirectory() == true) goto L44;
        r13.i("DoraWakeupResponse", "resolveWakeupResponseMp3Path: styleDir not found, styleDir=" + r3.getAbsolutePath());     // Catch: Exception -> L58
        return null;
    L44:
        File[] r2 = r3.listFiles(new v0());     // Catch: Exception -> L58
        if (r2 == null) goto L47;
        List r5 = ArraysKt.toList(r2);     // Catch: Exception -> L58
    L48:
        List r19 = r5;     // Catch: Exception -> L58
        if (r19 != null) goto L51;
    L52:
        r8 = true;
    L53:
        if (r8 == false) goto L55;
        r13.i("DoraWakeupResponse", "resolveWakeupResponseMp3Path: no mp3 in styleDir=" + r3.getAbsolutePath());     // Catch: Exception -> L58
        return null;
    L55:
        String r1 = ((File) CollectionsKt.random(r5, Random.Default)).getAbsolutePath();     // Catch: Exception -> L58
        r13.i("DoraWakeupResponse", "resolveWakeupResponseMp3Path: mp3Files.size = " + r5.size() + ", localPath=" + r1 + ", styleId=" + r10);     // Catch: Exception -> L58
        return r1;
    L51:
        if (r19.isEmpty() == false) goto L53;
    L47:
        r5 = null;
        goto L48
    L33:
        r17 = false;
        goto L34
    L27:
        r12 = false;
        goto L28
    L12:
        if (r7.length() == 0) goto L15;
        r9 = false;
        goto L16
    L8:
        r7 = null;
    L58:
        e = move-exception;
        FLogger.a.e("DoraWakeupResponse", "resolveWakeupResponseMp3Path error: " + e.getMessage());
        return null;
    L62:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
