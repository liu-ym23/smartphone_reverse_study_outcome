package com.ss.android.lark.officesdk.minutes.service.foundation.feature;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.feature.MmOfficeSdkFeature;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jdb.g;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final /* synthetic */ int f = 0;
    public final g a;
    public final Function0<lub.a> b;
    public final Function0<Boolean> c;
    public final Function0<MmRecordingSource> d;
    public final Function0<Boolean> e;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.foundation.feature.a$a, reason: collision with other inner class name */
    public static final class C0015a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[MmRecordingSource.values().length];
            r0[MmRecordingSource.DOUBAO_PERSONAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L53:
            r0[MmRecordingSource.DOUBAO_ENTERPRISE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L61:
            r0[MmRecordingSource.DOUBAO_EARBUDS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L39:
            r0[MmRecordingSource.DOUBAO_GLASSES.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L41:
            r0[MmRecordingSource.OBRIC_RECORDER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L49:
            r0[MmRecordingSource.FEISHU.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L59:
            r0[MmRecordingSource.FEISHU_DOUBAO.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L43:
            r0[MmRecordingSource.FEISHU_HARDWARE_RECORDER.ordinal()] = 8;     // Catch: NoSuchFieldError -> L28
        L55:
            r0[MmRecordingSource.FEISHU_HARDWARE_D1204.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L57:
            r0[MmRecordingSource.FEISHU_HARDWARE_D1204_CASE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L30
        L35:
            r0[MmRecordingSource.FEISHU_STANDALONE_AI_INTERPRETATION.ordinal()] = 11;     // Catch: NoSuchFieldError -> L31
        L51:
            r0[MmRecordingSource.DOUBAO_STANDALONE_AI_INTERPRETATION.ordinal()] = 12;     // Catch: NoSuchFieldError -> L32
        L16:
            a = r0;
            int[] r1 = new int[MmOfficeSdkFeature.values().length];
            r1[MmOfficeSdkFeature.RecordingNoAiNotes.ordinal()] = 1;     // Catch: NoSuchFieldError -> L33
        L47:
            r1[MmOfficeSdkFeature.RecordAiLayout.ordinal()] = 2;     // Catch: NoSuchFieldError -> L34
        L19:
            b = r1;
        }
    }

    static {
    }

    public a() {
        throw null;
    }

    public static boolean b(MmOfficeSdkFeature r2) {
        int r3 = b.b[r2.ordinal()];
        if (r3 != 1) goto L5;
    L6:
        return false;
    L5:
        if (r3 != 2) goto L6;
        return true;
    }

    public final boolean c(MmOfficeSdkFeature r4) {
        if (((Boolean) this.c.invoke()).booleanValue() == false) goto L5;
        Boolean r0 = r4.getLarkFgFixedValue();
    L6:
        if (r0 == null) goto L10;
        boolean r1 = r0.booleanValue();
        lvb.a.a("MmOfficeSdkFeatureService", "[getFeatureGatingValue] fixed value, feature=" + r4.name() + ", value=" + r1);
        return r1;
    L10:
        return f(r4);
    L5:
        r0 = r4.getDoubaoFgFixedValue();
        goto L6
    }

    public final boolean d(MmOfficeSdkFeature r6) {
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L9
        lub.a r4 = (lub.a) this.b.invoke();     // Catch: Throwable -> L9
        if (r4 != null) goto L6;
        lvb.a.h("MmOfficeSdkFeatureService", "[getHostSettingValue] host setting service missing, feature=" + r6.name());     // Catch: Throwable -> L9
        boolean r1 = false;
    L7:
        Object r2 = Result.constructor-impl(Boolean.valueOf(r1));     // Catch: Throwable -> L9
    L11:
        Throwable r5 = Result.exceptionOrNull-impl(r2);
        if (r5 == null) goto L14;
        lvb.a.b("MmOfficeSdkFeatureService", "[getHostSettingValue] failed, feature=" + r6.name() + ", error=" + r5);
    L14:
        Boolean r7 = Boolean.FALSE;
        if (Result.isFailure-impl(r2) == false) goto L18;
        r2 = r7;
    L18:
        return ((Boolean) r2).booleanValue();
    L6:
        boolean r8 = r4.G(r6);     // Catch: Throwable -> L9
        lvb.a.a("MmOfficeSdkFeatureService", "[getHostSettingValue] success, feature=" + r6.name() + ", value=" + r8);     // Catch: Throwable -> L9
        r1 = r8;
    L9:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final boolean e(MmOfficeSdkFeature r4) {
        if ((!StringsKt.isBlank(r4.getAbSettingKey())) == false) goto L6;
        lvb.a.a("MmOfficeSdkFeatureService", "[getNonFeiShuValue] use host setting first, feature=" + r4.name() + ", hostSettingKey=" + r4.getAbSettingKey());
        return d(r4);
    L6:
        lvb.a.a("MmOfficeSdkFeatureService", "[getNonFeiShuValue] empty setting config, fallback to fg, feature=" + r4.name());
        return c(r4);
    }

    public final boolean f(MmOfficeSdkFeature r6) {
        if (StringsKt.isBlank(r6.getFgKey()) == false) goto L21;
        lvb.a.h("MmOfficeSdkFeatureService", "[getRawFeatureGatingValue] empty fgKey, feature=" + r6.name());
        return false;
    L21:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        Object r1 = Result.constructor-impl(Boolean.valueOf(this.a.isCurrentEnable(r6.getFgKey())));     // Catch: Throwable -> L8
    L11:
        if (Result.isSuccess-impl(r1) == false) goto L13;
        lvb.a.a("MmOfficeSdkFeatureService", "[getRawFeatureGatingValue] fg result, feature=" + r6.name() + ", value=" + ((Boolean) r1).booleanValue());
    L13:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L16;
        lvb.a.b("MmOfficeSdkFeatureService", "[getRawFeatureGatingValue] fg failed, feature=" + r6.name() + ", error=" + r2);
    L16:
        Boolean r7 = Boolean.FALSE;
        if (Result.isFailure-impl(r1) == false) goto L20;
        r1 = r7;
    L20:
        return ((Boolean) r1).booleanValue();
    L8:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final boolean h(MmOfficeSdkFeature r7) {
        Intrinsics.checkNotNullParameter(r7, "feature");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L20
        boolean r4 = ((Boolean) this.c.invoke()).booleanValue();     // Catch: Throwable -> L20
        MmRecordingSource r5 = (MmRecordingSource) this.d.invoke();     // Catch: Throwable -> L20
        lvb.a.a("MmOfficeSdkFeatureService", "[isFeatureEnable] route, feature=" + r7.name() + ", isFeiShu=" + r4 + ", hostSettingKey=" + r7.getAbSettingKey() + ", recordingSource=" + r5);     // Catch: Throwable -> L20
        if (r7 != MmOfficeSdkFeature.RecordingNoAiNotes) goto L6;
    L9:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        boolean r1 = g(r7, r5, r4);     // Catch: Throwable -> L20
    L18:
        Object r6 = Result.constructor-impl(Boolean.valueOf(r1));     // Catch: Throwable -> L20
    L22:
        Throwable r8 = Result.exceptionOrNull-impl(r6);
        if (r8 == null) goto L25;
        lvb.a.b("MmOfficeSdkFeatureService", "[isFeatureEnable] route failed, feature=" + r7.name() + ", error=" + r8);
    L25:
        Boolean r9 = Boolean.FALSE;
        if (Result.isFailure-impl(r6) == false) goto L28;
        r6 = r9;
    L28:
        boolean r10 = ((Boolean) r6).booleanValue();
        lvb.a.a("MmOfficeSdkFeatureService", "[isFeatureEnable] result, feature=" + r7.name() + ", enabled=" + r10);
        return r10;
    L12:
        if (r4 == false) goto L15;
        r1 = c(r7);     // Catch: Throwable -> L20
        goto L18
    L15:
        if (r5 != MmRecordingSource.OBRIC_RECORDER) goto L17;
        lvb.a.a("MmOfficeSdkFeatureService", "[isFeatureEnable] recorder source uses host setting, feature=" + r7.name());     // Catch: Throwable -> L20
        r1 = d(r7);     // Catch: Throwable -> L20
        goto L18
    L17:
        r1 = e(r7);     // Catch: Throwable -> L20
        goto L18
    L6:
        if (r7 == MmOfficeSdkFeature.RecordAiLayout) goto L9;
        r2 = false;
    L20:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }

    public final Map<String, Boolean> a(List<String> r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "featureKeys");
        lvb.a.a("MmOfficeSdkFeatureService", "[getBooleanValues] start, size=" + r9.size());
        List<String> r11 = r9;
        LinkedHashMap r0 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r11, 10)), 16));
        Iterator<T> r12 = r11.iterator();
    L4:
        if (r12.hasNext() == false) goto L17;
        Object r2 = r12.next();
        String r3 = (String) r2;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L8
        Object r5 = Result.constructor-impl(Boolean.valueOf(this.a.isCurrentEnable(r3)));     // Catch: Throwable -> L8
    L10:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L13;
        lvb.a.b("MmOfficeSdkFeatureService", "[getBooleanValues] fg failed, key=" + r3 + ", error=" + r6);
    L13:
        Boolean r7 = Boolean.valueOf(r10);
        if (Result.isFailure-impl(r5) == false) goto L16;
        r5 = r7;
    L16:
        r0.put(r2, Boolean.valueOf(((Boolean) r5).booleanValue()));
    L8:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L17:
        return r0;
    }

    public a(g r4, Function0 r5, Function0 r6) {
        MmOfficeSdkFeatureService$2 r0 = MmOfficeSdkFeatureService$2.INSTANCE;
        MmOfficeSdkFeatureService$4 r1 = MmOfficeSdkFeatureService$4.INSTANCE;
        Intrinsics.checkNotNullParameter(r4, "featureGatingService");
        Intrinsics.checkNotNullParameter(r5, "featureSettingServiceProvider");
        Intrinsics.checkNotNullParameter(r0, "isLarkAppProvider");
        Intrinsics.checkNotNullParameter(r6, "recordingSourceProvider");
        Intrinsics.checkNotNullParameter(r1, "isDoubaoBUserProvider");
        this.a = r4;
        this.b = r5;
        this.c = r0;
        this.d = r6;
        this.e = r1;
    }

    public final boolean g(MmOfficeSdkFeature r2, MmRecordingSource r3, boolean r4) {
        if (r3 != null) goto L4;
        int r5 = -1;
    L5:
        switch(r5) {
            case -1: goto L24;
            case 0: goto L7;
            case 1: goto L36;
            case 2: goto L35;
            case 3: goto L28;
            case 4: goto L28;
            case 5: goto L32;
            case 6: goto L31;
            case 7: goto L31;
            case 8: goto L31;
            case 9: goto L31;
            case 10: goto L31;
            case 11: goto L8;
            case 12: goto L8;
            default: goto L7;
        };
    L8:
        return false;
    L24:
        if (r4 == false) goto L27;
        return f(r2);
    L27:
        return b(r2);
    L28:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L13
        Object r7 = Result.constructor-impl(Boolean.valueOf(((Boolean) this.e.invoke()).booleanValue()));     // Catch: Throwable -> L13
    L15:
        Boolean r8 = Boolean.FALSE;
        if (Result.isFailure-impl(r7) == false) goto L19;
        r7 = r8;
    L19:
        if (((Boolean) r7).booleanValue() == false) goto L34;
        return f(r2);
    L34:
        return b(r2);
    L13:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L7:
        throw new NoWhenBranchMatchedException();
    L31:
        return f(r2);
    L32:
        return d(r2);
    L35:
        return f(r2);
    L36:
        return b(r2);
    L4:
        r5 = b.a[r3.ordinal()];
        goto L5
    }
}
