package com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation;

import com.ss.android.lark.pb.entities.I18nInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b {
    public static final Set<String> a = null;
    public static final Set<String> b = null;
    public static final Set<String> c = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MmStandaloneAIInterpretationLanguageSide.values().length];
            r0[MmStandaloneAIInterpretationLanguageSide.SPOKEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MmStandaloneAIInterpretationLanguageSide.TARGET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        a = SetsKt.setOf(new String[]{"zhen", "zh_cn_en_us"});
        b = SetsKt.setOf(new String[]{"zh", I18nInfo.DEFAULT_LOCALE});
        c = SetsKt.setOf(new String[]{"en", "en_us"});
    }

    public static final boolean a(String r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (a.contains(r1) == false) goto L6;
        return true;
    }

    public static final boolean b(String r15, String r16) {
        if (Intrinsics.areEqual(r15, r16) == false) goto L5;
        return true;
    L5:
        if (StringsKt.split$default(r15, new char[]{'_'}, false, 0, 6, null).contains(r16) == false) goto L7;
        return true;
    L7:
        if (StringsKt.split$default(r16, new char[]{'_'}, false, 0, 6, null).contains(r15) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static final boolean c(String r3, List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r4) {
        Intrinsics.checkNotNullParameter(r4, "spokenLanguages");
        if (r3 != null) goto L5;
        return false;
    L5:
        if ((!r4.isEmpty()) == false) goto L24;
        List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r5 = r4;
        if ((r5 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L10;
        if (Intrinsics.areEqual(((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c) r6.next()).a, r3) == false) goto L13;
        boolean r7 = false;
    L17:
        if (r7 == false) goto L25;
        return true;
    L25:
        return false;
    L10:
        r7 = true;
        goto L17
    L9:
        if (r5.isEmpty() == false) goto L11;
    L24:
        return false;
    }

    public static final MmStandaloneAIInterpretationLanguageDisabledReason d(MmStandaloneAIInterpretationLanguageSide r4, String r5, String r6, String r7, Map<String, ? extends List<String>> r8, Map<String, ? extends List<String>> r9, List<com.ss.android.lark.officesdk.minutes.service.recording.common.repo.standaloneinterpretation.c> r10) {
        Intrinsics.checkNotNullParameter(r4, "side");
        Intrinsics.checkNotNullParameter(r5, "candidateLanguageType");
        Intrinsics.checkNotNullParameter(r8, "spokenToTargetLanguageTypes");
        Intrinsics.checkNotNullParameter(r9, "targetToSpokenLanguageTypes");
        Intrinsics.checkNotNullParameter(r10, "spokenLanguages");
        if (a(r5) == false) goto L6;
        return null;
    L6:
        if (a(r6) == false) goto L8;
        return null;
    L8:
        if (a(r7) == false) goto L11;
        return null;
    L11:
        if (r4 == MmStandaloneAIInterpretationLanguageSide.TARGET) goto L13;
    L15:
        int[] r11 = a.a;
        int r0 = r11[r4.ordinal()];
        if (r0 == 1) goto L21;
        if (r0 != 2) goto L20;
    L22:
        if (r6 != null) goto L25;
        return null;
    L25:
        if (b(r5, r6) == true) goto L27;
        int r12 = r11[r4.ordinal()];
        if (r12 == 1) goto L42;
        if (r12 != 2) goto L40;
        if ((!r8.isEmpty()) == false) goto L51;
        List<String> r13 = r8.get(r6);
        if (r13 != null) goto L37;
        r13 = CollectionsKt.emptyList();
    L37:
        if (r13.contains(r5) == false) goto L53;
        return null;
    L53:
        return MmStandaloneAIInterpretationLanguageDisabledReason.SOURCE_TO_TARGET_UNSUPPORTED;
    L51:
        return null;
    L40:
        throw new NoWhenBranchMatchedException();
    L42:
        if ((!r9.isEmpty()) == false) goto L54;
        List<String> r14 = r9.get(r6);
        if (r14 != null) goto L47;
        r14 = CollectionsKt.emptyList();
    L47:
        if (r14.contains(r5) == false) goto L49;
        return null;
    L49:
        return MmStandaloneAIInterpretationLanguageDisabledReason.TARGET_TO_SOURCE_UNSUPPORTED;
    L54:
        return null;
    L27:
        return MmStandaloneAIInterpretationLanguageDisabledReason.SAME_LANGUAGE;
    L20:
        throw new NoWhenBranchMatchedException();
    L21:
        r6 = r7;
        goto L22
    L13:
        if (c(r6, r10) == false) goto L15;
        return null;
    }
}
