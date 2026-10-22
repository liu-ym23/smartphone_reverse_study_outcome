package com.larus.uaigc.helper;

import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.resource.access.ResourceMediaType;
import com.larus.bmhome.resource.access.ResourceNodeHandler;
import com.larus.platform.api.creation.IBachDetectCenterAbility;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/uaigc/helper/CreationImageRemoteDetectHandler;", "Lcom/larus/bmhome/resource/access/ResourceNodeHandler;", "<init>", "()V", "key", "", "getKey", "()Ljava/lang/String;", "nodeKey", "getNodeKey", "supports", "", "context", "Lcom/larus/bmhome/resource/access/ResourceContext;", "execute", "Lcom/larus/bmhome/resource/access/NodeResult;", "(Lcom/larus/bmhome/resource/access/ResourceContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationImageRemoteDetectHandler implements ResourceNodeHandler {
    public final String a;
    public final String b;

    public final void getPriority() {
    }

    public CreationImageRemoteDetectHandler() {
        this.a = "creation_image_remote_detect";
        this.b = "remote_detect";
    }

    public final String a() {
        return this.b;
    }

    public final String getKey() {
        return this.a;
    }

    public final boolean b(com.larus.bmhome.resource.access.h0 r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if (a0.b(r5) == true) goto L5;
        return false;
    L5:
        if (r5.a.c == ResourceMediaType.IMAGE) goto L7;
        return false;
    L7:
        if (a0.a(r5, "enable_local_detect", new n()) == false) goto L28;
        com.larus.bmhome.resource.access.w r6 = r5.a;
        com.larus.bmhome.resource.access.j0 r0 = r6.b;
        Set<String> r2 = i.a;
        if ((r0 instanceof com.larus.bmhome.resource.access.j0.c) == false) goto L11;
    L14:
        boolean r1 = true;
    L15:
        if (r1 == false) goto L29;
        CharSequence r7 = (CharSequence) r6.d.n.get("remote_detect_local_path");
        if (r7 != null) goto L19;
    L22:
        boolean r8 = true;
    L23:
        if (r8 == true) goto L30;
        return true;
    L30:
        return false;
    L19:
        if (StringsKt.isBlank(r7) == true) goto L22;
        r8 = false;
        goto L23
    L29:
        return false;
    L11:
        if ((r0 instanceof com.larus.bmhome.resource.access.j0.d) == true) goto L14;
        r1 = false;
        goto L15
    L28:
        return false;
    }

    public final Object c(com.larus.bmhome.resource.access.h0 r10, Continuation<? super com.larus.bmhome.resource.access.g> r11) {
        IBachDetectCenterAbility.Companion r12 = IBachDetectCenterAbility.a;
        if (r12.b() == false) goto L5;
        String r13 = (String) r10.a.d.n.get("remote_detect_local_path");
        if (r13 == null) goto L27;
        if ((!StringsKt.isBlank(r13)) == true) goto L12;
        r13 = null;
    L12:
        if (r13 == null) goto L27;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L19
        PolarisFileWrapper r1 = new PolarisFileWrapper(r13);     // Catch: Throwable -> L19
        if (r1.exists() == true) goto L16;
        com.larus.bmhome.resource.access.g.a r14 = new com.larus.bmhome.resource.access.g.a(new com.larus.bmhome.resource.access.i0(null, null, null, null, null, null, i.a(CreationLocalDetectState.FAILED), 63));     // Catch: Throwable -> L19
    L17:
        Object r15 = Result.constructor-impl(r14);     // Catch: Throwable -> L19
    L21:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L30;
        FLogger.a.e("CreationImageNodeHandlers", "[remoteDetect] failed", r16);
        return new com.larus.bmhome.resource.access.g.a(new com.larus.bmhome.resource.access.i0(null, null, null, null, null, null, i.a(CreationLocalDetectState.FAILED), 63));
    L30:
        return r15;
    L16:
        r12.a(Uri.fromFile(r1));     // Catch: Throwable -> L19
        r14 = new com.larus.bmhome.resource.access.g.a(new com.larus.bmhome.resource.access.i0(null, null, null, null, null, null, i.a(CreationLocalDetectState.SUBMITTED), 63));     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
    L27:
        return com.larus.bmhome.resource.access.g.e.a;
    L5:
        return new com.larus.bmhome.resource.access.g.a(new com.larus.bmhome.resource.access.i0(null, null, null, null, null, null, i.a(CreationLocalDetectState.DISABLED), 63));
    }
}
