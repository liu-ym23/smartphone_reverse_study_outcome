package com.larus.uaigc.helper;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
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
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/uaigc/helper/CreationImageLocalDetectHandler;", "Lcom/larus/bmhome/resource/access/ResourceNodeHandler;", "<init>", "()V", "key", "", "getKey", "()Ljava/lang/String;", "nodeKey", "getNodeKey", "supports", "", "context", "Lcom/larus/bmhome/resource/access/ResourceContext;", "execute", "Lcom/larus/bmhome/resource/access/NodeResult;", "(Lcom/larus/bmhome/resource/access/ResourceContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationImageLocalDetectHandler implements ResourceNodeHandler {
    public final String a;
    public final String b;

    public final void getPriority() {
    }

    public CreationImageLocalDetectHandler() {
        this.a = "creation_image_local_detect";
        this.b = "local_detect";
    }

    public final String a() {
        return this.b;
    }

    public final String getKey() {
        return this.a;
    }

    public final boolean b(com.larus.bmhome.resource.access.h0 r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        if (a0.b(r4) == true) goto L5;
        return false;
    L5:
        if (r4.a.c == ResourceMediaType.IMAGE) goto L7;
        return false;
    L7:
        if (a0.a(r4, "enable_local_detect", new h()) == true) goto L9;
        return false;
    L9:
        if ((r4.c instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L23;
        Set<String> r0 = i.a;
        String r5 = (String) r4.b().get("local_detect");
        if (Intrinsics.areEqual(r5, CreationLocalDetectState.SUBMITTED.getValue()) == false) goto L13;
    L16:
        boolean r6 = true;
    L17:
        if (r6 == true) goto L24;
        return true;
    L24:
        return false;
    L13:
        if (Intrinsics.areEqual(r5, CreationLocalDetectState.DISABLED.getValue()) == true) goto L16;
        r6 = false;
        goto L17
    L23:
        return false;
    }

    public final Object c(com.larus.bmhome.resource.access.h0 r10, Continuation<? super com.larus.bmhome.resource.access.g> r11) {
        com.larus.bmhome.resource.access.j0.b r12 = r10.c;
        if ((r12 instanceof com.larus.bmhome.resource.access.j0.b) == false) goto L5;
        com.larus.bmhome.resource.access.j0.b r13 = r12;
    L6:
        if (r13 == null) goto L8;
        IBachDetectCenterAbility.Companion r14 = IBachDetectCenterAbility.a;
        if (r14.b() == false) goto L12;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L31
        Uri r1 = Uri.fromFile(new PolarisFileWrapper(r13.b));     // Catch: Throwable -> L31
        String r2 = r13.c;     // Catch: Throwable -> L31
        if (r2 != null) goto L16;
    L19:
        boolean r3 = true;
    L20:
        if (r3 == false) goto L22;
    L28:
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L31
        r14.a(r1);     // Catch: Throwable -> L31
    L29:
        Object r15 = Result.constructor-impl(new com.larus.bmhome.resource.access.g.a(new com.larus.bmhome.resource.access.i0(null, null, null, null, null, null, i.a(CreationLocalDetectState.SUBMITTED), 63)));     // Catch: Throwable -> L31
    L33:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L40;
        FLogger.a.e("CreationImageNodeHandlers", "[localDetect] failed", r16);
        return new com.larus.bmhome.resource.access.g.a(new com.larus.bmhome.resource.access.i0(null, null, null, null, null, null, i.a(CreationLocalDetectState.FAILED), 63));
    L40:
        return r15;
    L22:
        if (Intrinsics.areEqual(r2, r13.b) == true) goto L28;
        if (Intrinsics.areEqual(r13.d, Boxing.boxBoolean(true)) == false) goto L26;
        Uri r17 = UriProtector.parse(r2);     // Catch: Throwable -> L31
    L27:
        Intrinsics.checkNotNull(r17);     // Catch: Throwable -> L31
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L31
        r14.e(r17, r1, true);     // Catch: Throwable -> L31
        goto L29
    L26:
        r17 = Uri.fromFile(new PolarisFileWrapper(r2));     // Catch: Throwable -> L31
        goto L27
    L16:
        if (StringsKt.isBlank(r2) == true) goto L19;
        r3 = false;
    L31:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    L12:
        return new com.larus.bmhome.resource.access.g.a(new com.larus.bmhome.resource.access.i0(null, null, null, null, null, null, i.a(CreationLocalDetectState.DISABLED), 63));
    L8:
        return com.larus.bmhome.resource.access.g.e.a;
    L5:
        r13 = null;
        goto L6
    }
}
