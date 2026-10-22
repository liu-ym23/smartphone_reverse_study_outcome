package com.larus.uaigc.helper;

import com.larus.bmhome.resource.access.ResourceMediaType;
import com.larus.bmhome.resource.access.ResourceNodeHandler;
import com.larus.platform.model.upload.ResourceUploadInstantInfo;
import com.larus.uaigc.api.ReviewUgcImageApi;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/larus/uaigc/helper/CreationImageReviewHandler;", "Lcom/larus/bmhome/resource/access/ResourceNodeHandler;", "<init>", "()V", "key", "", "getKey", "()Ljava/lang/String;", "nodeKey", "getNodeKey", "supports", "", "context", "Lcom/larus/bmhome/resource/access/ResourceContext;", "execute", "Lcom/larus/bmhome/resource/access/NodeResult;", "(Lcom/larus/bmhome/resource/access/ResourceContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reviewUri", "shouldSkipReviewOnInstantUpload", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CreationImageReviewHandler implements ResourceNodeHandler {
    public final String a;
    public final String b;

    public final void getPriority() {
    }

    public CreationImageReviewHandler() {
        this.a = "creation_image_review";
        this.b = "review";
    }

    public final String a() {
        return this.b;
    }

    public final String getKey() {
        return this.a;
    }

    public static String d(com.larus.bmhome.resource.access.h0 r3) {
        com.larus.bmhome.resource.access.f0 r0 = r3.h;
        if (r0 == null) goto L13;
        String r1 = r0.c;
        if (r1 == null) goto L13;
        if ((!StringsKt.isBlank(r1)) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L13;
        return r1;
    L13:
        com.larus.bmhome.resource.access.f0 r4 = r3.h;
        if (r4 == null) goto L22;
        String r5 = r4.d;
        if (r5 != null) goto L18;
        return null;
    L18:
        if ((!StringsKt.isBlank(r5)) == true) goto L20;
        return null;
    L20:
        return r5;
    L22:
        return null;
    }

    public final boolean b(com.larus.bmhome.resource.access.h0 r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if (a0.b(r5) == false) goto L26;
        com.larus.bmhome.resource.access.w r0 = r5.a;
        if (r0.c != ResourceMediaType.IMAGE) goto L27;
        com.larus.bmhome.resource.access.j0 r1 = r0.b;
        Set<String> r2 = i.a;
        if ((r1 instanceof com.larus.bmhome.resource.access.j0.c) == false) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        return false;
    L15:
        if (a0.a(r5, "enable_review", new q()) == false) goto L29;
        String r6 = d(r5);
        if (r6 != null) goto L19;
    L22:
        boolean r7 = true;
    L23:
        if (r7 == true) goto L30;
        return true;
    L30:
        return false;
    L19:
        if (StringsKt.isBlank(r6) == true) goto L22;
        r7 = false;
        goto L23
    L29:
        return false;
    L9:
        if ((r1 instanceof com.larus.bmhome.resource.access.j0.d) == true) goto L12;
        r3 = false;
        goto L13
    L27:
        return false;
    L26:
        return false;
    }

    public final Object c(com.larus.bmhome.resource.access.h0 r21, Continuation<? super com.larus.bmhome.resource.access.g> r22) {
        if ((r22 instanceof CreationImageReviewHandler$execute$1) == false) goto L7;
        CreationImageReviewHandler$execute$1 r2 = (CreationImageReviewHandler$execute$1) r22;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        String r6 = null;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        String r7 = (String) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L42:
        dm9.a.b r8 = (dm9.a) r1;
        boolean r9 = r8 instanceof dm9.a.b;
        if (r9 == false) goto L57;
        dm9.a.b r10 = r8;
        if (r10.a.isSuccess() == false) goto L57;
        ReviewUgcImageApi.c r11 = (ReviewUgcImageApi.c) r10.a.getData();
        if (r11 == null) goto L54;
        Integer r12 = r11.a();
        if (r12 == null) goto L54;
        if (r12.intValue() != 3) goto L54;
        boolean r13 = true;
    L55:
        if (r13 == false) goto L57;
        return new com.larus.bmhome.resource.access.g.b(new com.larus.bmhome.resource.access.r(this.b, "review_un_pass", "creation image review unpass", null));
    L54:
        r13 = false;
    L57:
        if (r9 == false) goto L68;
        dm9.a.b r14 = r8;
        if (r14.a.isSuccess() == false) goto L68;
        Pair[] r15 = new Pair[2];
        r15[0] = TuplesKt.to("review_result", CreationReviewState.PASS.getValue());
        ReviewUgcImageApi.c r16 = (ReviewUgcImageApi.c) r14.a.getData();
        if (r16 == null) goto L65;
        Boolean r17 = r16.b();
        if (r17 == null) goto L65;
        r6 = r17.toString();
    L65:
        if (r6 != null) goto L67;
        r6 = "";
    L67:
        r15[1] = TuplesKt.to("face_detected", r6);
        return new com.larus.bmhome.resource.access.g.a(new com.larus.bmhome.resource.access.i0(null, null, null, null, null, null, MapsKt.mapOf(r15), 63));
    L68:
        FLogger.a.w("CreationImageNodeHandlers", "[review] degraded, uri=" + r7);
        return new com.larus.bmhome.resource.access.g.a(new com.larus.bmhome.resource.access.i0(null, null, null, null, null, null, MapsKt.mapOf(TuplesKt.to("review_result", CreationReviewState.DEGRADE.getValue())), 63));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        String r18 = d(r21);
        if (r18 == null) goto L17;
        f.a.getClass();
        Boolean r19 = f.b().b();
        Boolean r110 = Boolean.TRUE;
        if (Intrinsics.areEqual(r19, r110) == false) goto L34;
        com.larus.bmhome.resource.access.f0 r20 = r21.h;
        if (r20 == null) goto L34;
        mr9.l r23 = r20.e;
        if (r23 == null) goto L34;
        if (r23.f == true) goto L33;
        ResourceUploadInstantInfo r24 = r23.g;
        if (r24 == null) goto L31;
        boolean r25 = Intrinsics.areEqual(r24.getPreQueryHit(), r110);
    L32:
        if (r25 == false) goto L34;
    L31:
        r25 = false;
    L33:
        boolean r26 = true;
    L35:
        if (r26 == false) goto L38;
        FLogger.a.i("CreationImageNodeHandlers", "[review] skip on instant hit");
        return new com.larus.bmhome.resource.access.g.a(new com.larus.bmhome.resource.access.i0(null, null, null, null, null, null, MapsKt.mapOf(TuplesKt.to("review_result", CreationReviewState.INSTANT_SKIP.getValue())), 63));
    L38:
        ReviewUgcImageApi.Companion r27 = ReviewUgcImageApi.a;
        CreationImageReviewHandler$execute$checkResult$1 r111 = new CreationImageReviewHandler$execute$checkResult$1(r18, null);
        r2.L$0 = r18;
        r2.label = 1;
        r27.getClass();
        Object r28 = ReviewUgcImageApi.Companion.a(r111, r2);
        if (r28 != r4) goto L41;
        return r4;
    L41:
        r7 = r18;
        r1 = r28;
    L34:
        r26 = false;
        goto L35
    L17:
        return com.larus.bmhome.resource.access.g.e.a;
    L7:
        r2 = new CreationImageReviewHandler$execute$1(this, r22);
        goto L8
    }
}
