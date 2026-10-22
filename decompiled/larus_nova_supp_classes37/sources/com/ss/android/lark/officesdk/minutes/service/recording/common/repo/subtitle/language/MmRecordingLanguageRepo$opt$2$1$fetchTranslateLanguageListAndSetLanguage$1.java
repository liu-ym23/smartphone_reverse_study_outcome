package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import com.ss.android.lark.pb.videochat.GetLiveRecordingSettingResponse;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingLanguageRepo$opt$2$1$fetchTranslateLanguageListAndSetLanguage$1", f = "MmRecordingLanguageRepo.kt", i = {0, 1}, l = {252, 253}, m = "invokeSuspend", n = {"languageSettingsDeferred", "translateListResult"}, s = {"L$0", "L$0"})
final class MmRecordingLanguageRepo$opt$2$1$fetchTranslateLanguageListAndSetLanguage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $meetingId;
    final /* synthetic */ String $translationLanguage;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingLanguageRepo$opt$2.AnonymousClass1 this$0;
    final /* synthetic */ MmRecordingLanguageRepo this$1;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingLanguageRepo$opt$2$1$fetchTranslateLanguageListAndSetLanguage$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingLanguageRepo$opt$2$1$fetchTranslateLanguageListAndSetLanguage$1$1", f = "MmRecordingLanguageRepo.kt", i = {}, l = {262}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ GetLiveRecordingSettingResponse $languageSettingsResult;
        final /* synthetic */ GetLiveRecordingSettingResponse $translateListResult;
        final /* synthetic */ String $translationLanguage;
        int label;
        final /* synthetic */ MmRecordingLanguageRepo$opt$2.AnonymousClass1 this$0;
        final /* synthetic */ MmRecordingLanguageRepo this$1;

        public AnonymousClass1(MmRecordingLanguageRepo$opt$2.AnonymousClass1 r1, GetLiveRecordingSettingResponse r2, GetLiveRecordingSettingResponse r3, String r4, MmRecordingLanguageRepo r5, Continuation<? super AnonymousClass1> r6) {
            this.this$0 = r1;
            this.$translateListResult = r2;
            this.$languageSettingsResult = r3;
            this.$translationLanguage = r4;
            this.this$1 = r5;
            super(1, r6);
        }

        public final Continuation<Unit> create(Continuation<?> r9) {
            return new AnonymousClass1(this.this$0, this.$translateListResult, this.$languageSettingsResult, this.$translationLanguage, this.this$1, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r15) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r15);
        L73:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r15);
            MmRecordingLanguageRepo$opt$2.AnonymousClass1 r16 = this.this$0;
            GetLiveRecordingSettingResponse r2 = this.$translateListResult;
            GetLiveRecordingSettingResponse r3 = this.$languageSettingsResult;
            f r5 = (f) r16.m();
            if (r2 == null) goto L17;
            List<GetLiveRecordingSettingResponse.SubtitleLanguage> r4 = r2.mtranslation_language_list;
            if (r4 == null) goto L17;
            List<GetLiveRecordingSettingResponse.SubtitleLanguage> r6 = r4;
            ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
            Iterator<T> r8 = r6.iterator();
        L14:
            if (r8.hasNext() == false) goto L16;
            GetLiveRecordingSettingResponse.SubtitleLanguage r9 = (GetLiveRecordingSettingResponse.SubtitleLanguage) r8.next();
            r7.add(new h(r9.mlanguage, r9.mdescription_i18n));
            goto L14
        L16:
            List r10 = r7;
        L18:
            Boolean r11 = null;
            if (r3 == null) goto L21;
            GetLiveRecordingSettingResponse.SubtitleLanguage r12 = r3.mtranslation_language;
        L22:
            String r13 = "";
            if (r3 == null) goto L34;
            GetLiveRecordingSettingResponse.SubtitleLanguage r14 = r3.mspoken_language;
            if (r14 == null) goto L28;
            String r17 = r14.mlanguage;
            if (r17 == null) goto L28;
        L29:
            if (r14 == null) goto L32;
            String r18 = r14.mdescription_i18n;
            if (r18 == null) goto L32;
        L33:
            h r19 = new h(r17, r18);
        L35:
            if (r3 != null) goto L37;
            h r110 = r5.d;
        L48:
            String r111 = r16.l.m;
            StringBuilder r20 = new StringBuilder("[buildEntityFromResults] finalTranslateLanguage=");
            r20.append(r110.a);
            r20.append(", spokenLanguage=");
            r20.append(r19.a);
            r20.append(", isBilingual=");
            if (r2 == null) goto L51;
            r11 = r2.mis_bilingual;
        L51:
            r20.append(r11);
            lvb.a.e(r111, r20.toString());
            if (r2 == null) goto L56;
            Boolean r112 = r2.mis_bilingual;
            if (r112 == null) goto L56;
            boolean r113 = r112.booleanValue();
        L58:
            if (r5.f == true) goto L62;
            if (r3 != null) goto L62;
            boolean r114 = false;
        L64:
            if (r5.g == true) goto L68;
            if (r2 != null) goto L68;
            boolean r115 = false;
        L69:
            f r116 = f.a(r5, null, r10, r19, r110, r113, r114, r115, 1);
            MmRecordingLanguageRepo r21 = this.this$1;
            this.label = 1;
            if (r21.b(r116, this) != r0) goto L73;
            return r0;
        L68:
            r115 = true;
        L62:
            r114 = true;
        L56:
            r113 = r5.e;
            goto L58
        L37:
            if (r12 == null) goto L40;
            String r117 = r12.mlanguage;
            if (r117 == null) goto L40;
        L41:
            if (r12 == null) goto L46;
            String r22 = r12.mdescription_i18n;
            if (r22 == null) goto L46;
            r13 = r22;
        L46:
            r110 = new h(r117, r13);
        L40:
            r117 = "source";
        L32:
            r18 = "";
        L28:
            r17 = "";
            goto L29
        L34:
            r19 = r5.c;
            goto L35
        L21:
            r12 = null;
        L17:
            r10 = r5.b;
            goto L18
        }
    }

    public MmRecordingLanguageRepo$opt$2$1$fetchTranslateLanguageListAndSetLanguage$1(MmRecordingLanguageRepo$opt$2.AnonymousClass1 r1, MmRecordingLanguageRepo r2, String r3, String r4, Continuation<? super MmRecordingLanguageRepo$opt$2$1$fetchTranslateLanguageListAndSetLanguage$1> r5) {
        this.this$0 = r1;
        this.this$1 = r2;
        this.$meetingId = r3;
        this.$translationLanguage = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        MmRecordingLanguageRepo$opt$2$1$fetchTranslateLanguageListAndSetLanguage$1 r6 = new MmRecordingLanguageRepo$opt$2$1$fetchTranslateLanguageListAndSetLanguage$1(this.this$0, this.this$1, this.$meetingId, this.$translationLanguage, r9);
        r6.L$0 = r8;
        return r6;
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
        Object r3 = null;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        GetLiveRecordingSettingResponse r2 = (GetLiveRecordingSettingResponse) this.L$0;
        ResultKt.throwOnFailure(r14);
        GetLiveRecordingSettingResponse r7 = r2;
    L21:
        Object r15 = ((Result) r14).unbox-impl();
        if (Result.isFailure-impl(r15) == true) goto L25;
        r3 = r15;
    L25:
        GetLiveRecordingSettingResponse r8 = (GetLiveRecordingSettingResponse) r3;
        if (r7 != null) goto L28;
        this.this$0.k = true;
    L28:
        if (r8 != null) goto L30;
        this.this$0.i = true;
    L30:
        MmRecordingLanguageRepo r16 = this.this$1;
        r16.j(new AnonymousClass1(this.this$0, r7, r8, this.$translationLanguage, r16, null));
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Deferred r4 = (Deferred) this.L$0;
        ResultKt.throwOnFailure(r14);
    L14:
        Object r17 = ((Result) r14).unbox-impl();
        if (Result.isFailure-impl(r17) == false) goto L17;
        r17 = null;
    L17:
        GetLiveRecordingSettingResponse r18 = (GetLiveRecordingSettingResponse) r17;
        this.L$0 = r18;
        this.label = 2;
        Object r5 = r4.await(this);
        if (r5 != r0) goto L20;
        return r0;
    L20:
        r7 = r18;
        r14 = r5;
        goto L21
    L10:
        ResultKt.throwOnFailure(r14);
        CoroutineScope r19 = (CoroutineScope) this.L$0;
        Deferred r6 = BuildersKt.async$default(r19, null, null, new MmRecordingLanguageRepo$opt$2$1$fetchTranslateLanguageListAndSetLanguage$1$translateListDeferred$1(this.this$0, this.$meetingId, null), 3, null);
        Deferred r110 = BuildersKt.async$default(r19, null, null, new MmRecordingLanguageRepo$opt$2$1$fetchTranslateLanguageListAndSetLanguage$1$languageSettingsDeferred$1(this.this$0, this.$meetingId, null), 3, null);
        this.L$0 = r110;
        this.label = 1;
        Object r9 = r6.await(this);
        if (r9 != r0) goto L13;
        return r0;
    L13:
        r4 = r110;
        r14 = r9;
        goto L14
    }
}
