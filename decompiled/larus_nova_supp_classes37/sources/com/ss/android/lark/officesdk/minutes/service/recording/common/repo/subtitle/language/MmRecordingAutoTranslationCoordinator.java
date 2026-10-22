package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MmRecordingAutoTranslationCoordinator {
    public static final /* synthetic */ int k = 0;
    public final CoroutineScope a;
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.a b;
    public final Function0<String> c;
    public final Function0<Boolean> d;
    public final Function2<h, Continuation<? super Unit>, Object> e;
    public final AtomicBoolean f;
    public final StateFlowImpl g;
    public f h;
    public Boolean i;
    public long j;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingAutoTranslationCoordinator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    final class AnonymousClass1 extends Lambda implements Function0<Boolean> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m371invoke() {
            return invoke();
        }

        public final Boolean invoke() {
            return Boolean.TRUE;
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[MmAutoTranslationStage.values().length];
            r0[MmAutoTranslationStage.TRANSLATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[MmAutoTranslationStage.BILINGUAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            a = r0;
            int[] r1 = new int[MmAutoLanguageSettingResult.values().length];
            r1[MmAutoLanguageSettingResult.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r1[MmAutoLanguageSettingResult.FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L21:
            r1[MmAutoLanguageSettingResult.OBSOLETE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L10:
            b = r1;
        }
    }

    static {
    }

    public final boolean e() {
        if (this.f.get() == false) goto L6;
        return false;
    L6:
        Function0<Boolean> r0 = this.d;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        Object r2 = Result.constructor-impl(r0.invoke());     // Catch: Throwable -> L9
    L11:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L14;
        lvb.a.b("MmAutoTranslation", "[isOperationActive] lifecycle failed, error=" + r3);
    L14:
        Boolean r4 = Boolean.FALSE;
        if (Result.isFailure-impl(r2) == false) goto L18;
        r2 = r4;
    L18:
        return ((Boolean) r2).booleanValue();
    L9:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final void h() {
        if (this.f.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(this.a, null, CoroutineStart.UNDISPATCHED, new MmRecordingAutoTranslationCoordinator$onRecordingInactive$1(this, null), 1, null);
    }

    public final void l() {
        e r0 = (e) this.g.getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        MmAutoTranslationStatus r1 = r0.a;
        if (r1 != MmAutoTranslationStatus.WAITING) goto L8;
    L9:
        m(e.a(r0, MmAutoTranslationStatus.SKIPPED, null, null, 0, 0, "recording_inactive", 30));
        return;
    L8:
        if (r1 == MmAutoTranslationStatus.APPLYING) goto L9;
    }

    public final void g() {
        if (e() == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(this.a, null, null, new MmRecordingAutoTranslationCoordinator$onManualSettingIntent$1(this, null), 3, null);
    }

    public final e a(long r5) {
        e r0 = (e) this.g.getValue();
        if (r0 != null) goto L5;
    L14:
        return null;
    L5:
        if (e() == true) goto L7;
    L11:
        boolean r6 = false;
    L12:
        if (r6 == false) goto L14;
        return r0;
    L7:
        if (r0.d != r5) goto L11;
        if (r0.a != MmAutoTranslationStatus.APPLYING) goto L11;
        r6 = true;
        goto L12
    }

    public final void f(f r8) {
        Intrinsics.checkNotNullParameter(r8, "entity");
        if (e() == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(this.a, null, null, new MmRecordingAutoTranslationCoordinator$onLanguageEntityChanged$1(this, r8, null), 3, null);
    }

    public final void i(Boolean r8) {
        if (e() == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(this.a, null, null, new MmRecordingAutoTranslationCoordinator$onSubtitleStateChanged$1(this, r8, null), 3, null);
    }

    public final void j(String r9) {
        if (r9 == null) goto L5;
        String r10 = StringsKt.trim(r9).toString();
    L6:
        if (r10 != null) goto L9;
        r10 = "";
    L9:
        if (r10.length() != 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
    L18:
        lvb.a.e("MmAutoTranslation", "[onTranslationSuggested] ignore empty or inactive");
        return;
    L14:
        if (e() == false) goto L18;
        BuildersKt.launch$default(this.a, null, null, new MmRecordingAutoTranslationCoordinator$onTranslationSuggested$1(this, r10, null), 3, null);
        return;
    L11:
        r1 = false;
        goto L12
    L5:
        r10 = null;
        goto L6
    }

    public final void m(e r4) {
        this.g.setValue(r4);
        lvb.a.e("MmAutoTranslation", "[state] status=" + r4.a + ", stage=" + r4.c + ", target=" + r4.b + ", operation=" + r4.d + ", revision=" + r4.e + ", reason=" + r4.f);
    }

    public final Object b(c r21, Continuation<? super Unit> r22) {
        c r1 = r21;
        if ((r22 instanceof MmRecordingAutoTranslationCoordinator$applyBilingual$1) == false) goto L7;
        MmRecordingAutoTranslationCoordinator$applyBilingual$1 r3 = (MmRecordingAutoTranslationCoordinator$applyBilingual$1) r22;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        ResultKt.throwOnFailure(r2);
    L53:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r1 = (c) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L23:
        MmAutoLanguageSettingResult r7 = (MmAutoLanguageSettingResult) r2;
        e r10 = a(r1.a.d);
        if (r10 == null) goto L26;
        int r8 = b.b[r7.ordinal()];
        if (r8 == 1) goto L37;
        if (r8 != 2) goto L31;
        m(e.a(r10, MmAutoTranslationStatus.WAITING, null, MmAutoTranslationStage.BILINGUAL, 0, 0, "bilingual_failed", 26));
    L36:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.b r9 = null;
    L48:
        if (r9 == null) goto L53;
        r3.L$0 = null;
        r3.label = 2;
        if (d(r9, r3) != r5) goto L53;
        return r5;
    L31:
        if (r8 != 3) goto L34;
        m(e.a(r10, MmAutoTranslationStatus.SKIPPED, null, null, 0, 0, "obsolete", 30));
        goto L36
    L34:
        throw new NoWhenBranchMatchedException();
    L37:
        f r11 = f.a(this.h, null, null, null, null, true, false, false, 111);
        this.h = r11;
        Iterator<T> r12 = r11.b.iterator();
    L39:
        if (r12.hasNext() == false) goto L43;
        Object r13 = r12.next();
        if (Intrinsics.areEqual(((h) r13).a, r10.b) == false) goto L39;
    L44:
        h r14 = (h) r13;
        if (r14 != null) goto L47;
        r14 = new h(r10.b, "");
    L47:
        e r15 = e.a(r10, MmAutoTranslationStatus.APPLIED, null, null, 0, 0, "", 30);
        m(r15);
        r9 = new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.b(r15, r14);
        goto L48
    L43:
        r13 = null;
        goto L44
    L26:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r2);
        if (e() == false) goto L19;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.a r16 = this.b;
        long r17 = r1.a.e;
        r3.L$0 = r1;
        r3.label = 1;
        r2 = r16.k0(r17, r3);
        if (r2 != r5) goto L23;
        return r5;
    L19:
        return Unit.INSTANCE;
    L7:
        r3 = new MmRecordingAutoTranslationCoordinator$applyBilingual$1(this, r22);
        goto L8
    }

    public final Object c(d r21, Continuation<? super Unit> r22) {
        d r1 = r21;
        if ((r22 instanceof MmRecordingAutoTranslationCoordinator$applyTranslation$1) == false) goto L7;
        MmRecordingAutoTranslationCoordinator$applyTranslation$1 r3 = (MmRecordingAutoTranslationCoordinator$applyTranslation$1) r22;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        boolean r7 = true;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        ResultKt.throwOnFailure(r2);
    L43:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r1 = (d) r3.L$0;
        ResultKt.throwOnFailure(r2);
    L23:
        MmAutoLanguageSettingResult r8 = (MmAutoLanguageSettingResult) r2;
        e r10 = a(r1.a.d);
        if (r10 == null) goto L26;
        int r9 = b.b[r8.ordinal()];
        if (r9 == 1) goto L37;
        if (r9 != 2) goto L31;
        m(e.a(r10, MmAutoTranslationStatus.WAITING, null, null, 0, 0, "translation_failed", 30));
    L36:
        r7 = false;
    L38:
        if (r7 == false) goto L45;
        r3.L$0 = null;
        r3.label = 2;
        if (k("translation_success", r3) != r5) goto L43;
        return r5;
    L45:
        return Unit.INSTANCE;
    L31:
        if (r9 != 3) goto L34;
        m(e.a(r10, MmAutoTranslationStatus.SKIPPED, null, null, 0, 0, "obsolete", 30));
        goto L36
    L34:
        throw new NoWhenBranchMatchedException();
    L37:
        this.h = f.a(this.h, null, null, null, r1.b, false, false, false, 119);
        m(e.a(r10, MmAutoTranslationStatus.WAITING, null, MmAutoTranslationStage.BILINGUAL, 0, 0, "", 26));
        goto L38
    L26:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r2);
        if (e() == false) goto L19;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.a r11 = this.b;
        h r12 = r1.b;
        long r13 = r1.a.e;
        r3.L$0 = r1;
        r3.label = 1;
        r2 = r11.a0(r12, r13, r3);
        if (r2 != r5) goto L23;
        return r5;
    L19:
        return Unit.INSTANCE;
    L7:
        r3 = new MmRecordingAutoTranslationCoordinator$applyTranslation$1(this, r22);
        goto L8
    }

    public final Object d(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.b r18, Continuation<? super Unit> r19) {
        if ((r19 instanceof MmRecordingAutoTranslationCoordinator$deliverCompletion$1) == false) goto L7;
        MmRecordingAutoTranslationCoordinator$deliverCompletion$1 r3 = (MmRecordingAutoTranslationCoordinator$deliverCompletion$1) r19;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r2 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L17;
        if (r6 != 1) goto L16;
        ResultKt.throwOnFailure(r2);     // Catch: Throwable -> L13
    L56:
    L55:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r2);
        if (e() == false) goto L20;
        e r7 = (e) this.g.getValue();
        boolean r8 = false;
        if (e() == true) goto L30;
        if (r7 != null) goto L25;
    L27:
        boolean r9 = false;
    L28:
        if (r9 == false) goto L47;
        m(e.a(r7, MmAutoTranslationStatus.SKIPPED, null, null, 0, 0, "recording_inactive", 30));
    L47:
        if (r8 == false) goto L49;
        Function2<h, Continuation<? super Unit>, Object> r10 = this.e;     // Catch: Throwable -> L13
        h r0 = r18.b;     // Catch: Throwable -> L13
        r3.label = 1;     // Catch: Throwable -> L13
        if (r10.invoke(r0, r3) != r5) goto L56;
        return r5;
    L49:
        return Unit.INSTANCE;
    L25:
        if (r7.d != r18.a.d) goto L27;
        r9 = true;
        goto L28
    L30:
        if (r7 != null) goto L32;
    L34:
        boolean r11 = false;
    L35:
        if (r11 == true) goto L37;
    L40:
        if (r7 != null) goto L42;
    L44:
        boolean r12 = false;
    L45:
        if (r12 == false) goto L47;
        m(e.a(r7, MmAutoTranslationStatus.SKIPPED, null, null, 0, 0, "manual_before_feedback", 30));
        goto L47
    L42:
        if (r7.d != r18.a.d) goto L44;
        r12 = true;
        goto L45
    L37:
        if (this.b.i0() != r18.a.e) goto L40;
        r8 = true;
        goto L47
    L32:
        if (r7.d != r18.a.d) goto L34;
        r11 = true;
        goto L35
    L20:
        return Unit.INSTANCE;
    L13:
        th = move-exception;
        lvb.a.b("MmAutoTranslation", "[deliverCompletion] failed, error=" + th);
    L7:
        r3 = new MmRecordingAutoTranslationCoordinator$deliverCompletion$1(this, r19);
        goto L8
    }

    public final Object k(String r13, Continuation<? super Unit> r14) {
        if (e() == false) goto L5;
        Object r1 = null;
        if (e() == true) goto L9;
        l();
    L68:
        if (r1 != null) goto L72;
        return Unit.INSTANCE;
    L72:
        if ((r1 instanceof d) == false) goto L79;
        Object r15 = c((d) r1, r14);
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L77;
        return r15;
    L77:
        return Unit.INSTANCE;
    L79:
        if ((r1 instanceof c) == false) goto L86;
        Object r16 = b((c) r1, r14);
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L84;
        return r16;
    L84:
        return Unit.INSTANCE;
    L86:
        if ((r1 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.b) == false) goto L93;
        Object r17 = d((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.b) r1, r14);
        if (r17 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L91;
        return r17;
    L91:
        return Unit.INSTANCE;
    L93:
        throw new NoWhenBranchMatchedException();
    L9:
        e r2 = (e) this.g.getValue();
        if (r2 == null) goto L68;
        if (r2.a != MmAutoTranslationStatus.WAITING) goto L68;
        if (this.b.i0() == r2.e) goto L19;
        m(e.a(r2, MmAutoTranslationStatus.SKIPPED, null, null, 0, 0, "manual_revision", 30));
        goto L68
    L19:
        if (StringsKt.isBlank((CharSequence) this.c.invoke()) == false) goto L21;
    L67:
        StringBuilder r0 = new StringBuilder("[reevaluate] waiting, trigger=");
        r0.append(r13);
        r0.append(", meetingReady=");
        r0.append(!StringsKt.isBlank((CharSequence) this.c.invoke()));
        r0.append(", subtitleOn=");
        r0.append(this.i);
        r0.append(", settingsReady=");
        r0.append(this.h.f);
        r0.append(", listReady=");
        r0.append(this.h.g);
        lvb.a.e("MmAutoTranslation", r0.toString());
        goto L68
    L21:
        if (Intrinsics.areEqual(this.i, Boolean.TRUE) == false) goto L67;
        f r3 = this.h;
        if (r3.f == false) goto L67;
        if (r3.g == false) goto L67;
        int r18 = b.a[r2.c.ordinal()];
        if (r18 != 1) goto L30;
        String r19 = this.h.d.a;
        if (StringsKt.isBlank(r19) == true) goto L68;
        if (Intrinsics.areEqual(r19, "source") == true) goto L56;
        m(e.a(r2, MmAutoTranslationStatus.SKIPPED, null, null, 0, 0, "translation_exists", 30));
        goto L68
    L56:
        Iterator<T> r110 = this.h.b.iterator();
    L58:
        if (r110.hasNext() == false) goto L62;
        Object r4 = r110.next();
        if (Intrinsics.areEqual(((h) r4).a, r2.b) == false) goto L58;
    L63:
        h r5 = (h) r4;
        if (r5 != null) goto L66;
        m(e.a(r2, MmAutoTranslationStatus.SKIPPED, null, null, 0, 0, "unsupported", 30));
        goto L68
    L66:
        e r111 = e.a(r2, MmAutoTranslationStatus.APPLYING, null, null, 0, 0, "", 30);
        m(r111);
        r1 = new d(r111, r5);
        goto L68
    L62:
        r4 = null;
        goto L63
    L30:
        if (r18 != 2) goto L49;
        Iterator<T> r112 = this.h.b.iterator();
    L33:
        if (r112.hasNext() == false) goto L37;
        Object r6 = r112.next();
        if (Intrinsics.areEqual(((h) r6).a, r2.b) == false) goto L33;
    L38:
        h r7 = (h) r6;
        if (r7 != null) goto L42;
        r7 = new h(r2.b, "");
    L42:
        if (Intrinsics.areEqual(this.h.d.a, r2.b) == true) goto L45;
        m(e.a(r2, MmAutoTranslationStatus.SKIPPED, null, null, 0, 0, "translation_changed", 30));
        goto L68
    L45:
        if (this.h.e == false) goto L47;
        e r113 = e.a(r2, MmAutoTranslationStatus.APPLIED, null, null, 0, 0, "", 30);
        m(r113);
        r1 = new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.b(r113, r7);
        goto L68
    L47:
        e r114 = e.a(r2, MmAutoTranslationStatus.APPLYING, null, null, 0, 0, "", 30);
        m(r114);
        r1 = new c(r114);
        goto L68
    L37:
        r6 = null;
        goto L38
    L49:
        throw new NoWhenBranchMatchedException();
    L5:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MmRecordingAutoTranslationCoordinator(CoroutineScope r2, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.a r3, Function0<String> r4, Function0<Boolean> r5, Function2<? super h, ? super Continuation<? super Unit>, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "languageOperator");
        Intrinsics.checkNotNullParameter(r4, "meetingIdProvider");
        Intrinsics.checkNotNullParameter(r5, "recordingActiveProvider");
        Intrinsics.checkNotNullParameter(r6, "onFullyApplied");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = new AtomicBoolean(false);
        StateFlowImpl r7 = j1.a(null);
        this.g = r7;
        this.h = new f(0);
        kotlinx.coroutines.flow.e.b(r7);
    }
}
