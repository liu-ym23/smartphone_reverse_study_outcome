package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation;

import com.bytedance.lark.pb.basic.v1.Command;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.error.MmCustomExceptionKt;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.mock.MmMockAwareRequestService;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.pb.minutes.v1.MinutesGetI18nTemplatesRequest;
import com.ss.android.lark.pb.minutes.v1.MinutesGetI18nTemplatesResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class RustMmAIInterpretationGateway implements f {
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a a;
    public final String b;

    public RustMmAIInterpretationGateway(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r2) {
        Intrinsics.checkNotNullParameter(r2, "mmUccApi");
        this.a = r2;
        this.b = "RustMmAIInterpretationGateway";
    }

    public final Object d(List<String> r6, Continuation<? super Result<? extends Map<String, String>>> r7) {
        if ((r7 instanceof RustMmAIInterpretationGateway$getI18nTemplates$1) == false) goto L7;
        RustMmAIInterpretationGateway$getI18nTemplates$1 r0 = (RustMmAIInterpretationGateway$getI18nTemplates$1) r7;
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
        Object r9 = ((Result) r8).unbox-impl();
    L17:
        boolean r10 = Result.isSuccess-impl(r9);
        Object r11 = r9;
        if (r10 == false) goto L24;
        Map<String, String> r12 = ((MinutesGetI18nTemplatesResponse) r9).templates;
        Map<String, String> r13 = r12;
        if (r12 != null) goto L22;
        r13 = MapsKt.emptyMap();
    L22:
        lvb.a.e(this.b, "[getI18nTemplates] success, templateSize=" + r13.size());
        r11 = r13;
    L24:
        return Result.constructor-impl(r11);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        lvb.a.e(this.b, "[getI18nTemplates] request, keySize=" + r6.size());
        MinutesGetI18nTemplatesRequest r14 = new MinutesGetI18nTemplatesRequest.Builder().keys(r6).m1841build();
        MmMockAwareRequestService r15 = this.a.M();
        Command r4 = Command.MINUTES_GET_I18N_TEMPLATES;
        Intrinsics.checkNotNull(r14);
        r0.label = 1;
        Object r16 = r15.b(r4, MinutesGetI18nTemplatesResponse.class, r14, r0);
        r9 = r16;
        if (r16 != r2) goto L17;
        return r2;
    L7:
        r0 = new RustMmAIInterpretationGateway$getI18nTemplates$1(this, r7);
        goto L8
    }

    public static final Object c(RustMmAIInterpretationGateway r17, List r18, Continuation r19) {
        List r1 = r18;
        r17.getClass();
        if ((r19 instanceof RustMmAIInterpretationGateway$localizeLanguages$1) == false) goto L7;
        RustMmAIInterpretationGateway$localizeLanguages$1 r3 = (RustMmAIInterpretationGateway$localizeLanguages$1) r19;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        r1 = (List) r3.L$0;
        ResultKt.throwOnFailure(r2);
        Object r7 = ((Result) r2).unbox-impl();
    L30:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L34;
        lvb.a.h(r17.b, "[localizeLanguages] get i18n templates failed, fallback to raw descriptions, error=" + r8.getMessage());
        r7 = MapsKt.emptyMap();
    L34:
        Map r9 = (Map) r7;
        if (r9.isEmpty() == false) goto L37;
        lvb.a.e(r17.b, "[localizeLanguages] empty templates, fallback to raw descriptions");
        return r1;
    L37:
        List r10 = r1;
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r12 = r10.iterator();
    L39:
        if (r12.hasNext() == false) goto L47;
        g r13 = (g) r12.next();
        String r14 = (String) r9.get(r13.b);
        if (r14 != null) goto L44;
        r14 = "";
    L44:
        if ((!StringsKt.isBlank(r14)) == false) goto L46;
        String r15 = r13.a;
        String r16 = r13.c;
        Intrinsics.checkNotNullParameter(r15, "languageType");
        Intrinsics.checkNotNullParameter(r14, "description");
        Intrinsics.checkNotNullParameter(r16, AppbrandHostConstants.Schema_Meta.ICON);
        r13 = new g(r15, r14, r16);
    L46:
        r11.add(r13);
        goto L39
    L47:
        lvb.a.e(r17.b, "[localizeLanguages] localized=" + CollectionsKt.joinToString$default(r11, null, "[", "]", 0, null, RustMmAIInterpretationGateway$localizeLanguages$3$1.INSTANCE, 25, null));
        return r11;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        List r20 = r1;
        ArrayList r21 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator r22 = r20.iterator();
    L16:
        if (r22.hasNext() == false) goto L18;
        r21.add(((g) r22.next()).b);
        goto L16
    L18:
        ArrayList r23 = new ArrayList();
        Iterator r24 = r21.iterator();
    L20:
        if (r24.hasNext() == false) goto L24;
        Object r25 = r24.next();
        if ((!StringsKt.isBlank((String) r25)) == false) goto L20;
        r23.add(r25);
        goto L20
    L24:
        List<String> r26 = CollectionsKt.distinct(r23);
        if (r26.isEmpty() == false) goto L27;
        lvb.a.e(r17.b, "[localizeLanguages] skip, empty keys");
        return r1;
    L27:
        r3.L$0 = r1;
        r3.label = 1;
        r7 = r17.d(r26, r3);
        if (r7 != r5) goto L30;
        return r5;
    L7:
        r3 = new RustMmAIInterpretationGateway$localizeLanguages$1(r17, r19);
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.f
    public final Object b(String r5, String r6, Continuation<? super Result<? extends List<g>>> r7) {
        if ((r7 instanceof RustMmAIInterpretationGateway$getSetting$1) == false) goto L7;
        RustMmAIInterpretationGateway$getSetting$1 r0 = (RustMmAIInterpretationGateway$getSetting$1) r7;
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
        return ((Result) r8).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        RustMmAIInterpretationGateway$getSetting$2 r9 = new RustMmAIInterpretationGateway$getSetting$2(this, r5, r6, null);
        r0.label = 1;
        Object r10 = MmCustomExceptionKt.a(3, r9, r0);
        if (r10 != r2) goto L18;
        return r2;
    L18:
        return r10;
    L7:
        r0 = new RustMmAIInterpretationGateway$getSetting$1(this, r7);
        goto L8
    }

    @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.aiinterpretation.f
    public final Object a(String r13, String r14, boolean r15, g r16, Continuation<? super Result<p>> r17) {
        if ((r17 instanceof RustMmAIInterpretationGateway$updateSetting$1) == false) goto L7;
        RustMmAIInterpretationGateway$updateSetting$1 r1 = (RustMmAIInterpretationGateway$updateSetting$1) r17;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r1.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
        return ((Result) r0).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        RustMmAIInterpretationGateway$updateSetting$2 r4 = new RustMmAIInterpretationGateway$updateSetting$2(this, r13, r14, r15, r16, null);
        r1.label = 1;
        Object r5 = MmCustomExceptionKt.a(3, r4, r1);
        if (r5 != r10) goto L18;
        return r10;
    L18:
        return r5;
    L7:
        r1 = new RustMmAIInterpretationGateway$updateSetting$1(this, r17);
        goto L8
    }
}
