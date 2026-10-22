package com.ss.android.lark.contact.customized.department;

import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.contact.v1.GetAnotherNameFormatResponse;
import com.bytedance.lark.pb.contact.v2.GetUserProfileResponse;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import yob.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class DepartmentUserDisplayFormatter {
    public static final DepartmentUserDisplayFormatter a = null;

    public static final class a {
        public a() {
        }
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[GetAnotherNameFormatResponse.FormatRule.values().length];
            r0[GetAnotherNameFormatResponse.FormatRule.ANOTHER_NAME_FIRST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L4:
            a = r0;
            int[] r1 = new int[GetUserProfileResponse.Field.FieldType.values().length];
            r1[GetUserProfileResponse.Field.FieldType.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L14:
            r1[GetUserProfileResponse.Field.FieldType.C_ALIAS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L20:
            r1[GetUserProfileResponse.Field.FieldType.LINK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L8:
            b = r1;
        }
    }

    static {
        a = new DepartmentUserDisplayFormatter();
    }

    public DepartmentUserDisplayFormatter() {
    }

    public static void c() {
        e.a().getClass();
        int r0 = com.ss.android.lark.language.service.impl.a.f;
        apb.b r1 = com.ss.android.lark.language.service.impl.a.b.a;
        r1.d(r1.getCacheLanguageSetting()).toLowerCase(Locale.ROOT);
        StringsKt.isBlank(BuildConfig.FLAVOR);
    }

    public final List<String> b(List<GetUserProfileResponse.Field> r2) {
        if (r2 != null) goto L5;
        r2 = CollectionsKt.emptyList();
    L5:
        return SequencesKt.toList(SequencesKt.take(SequencesKt.filter(SequencesKt.mapNotNull(CollectionsKt.asSequence(r2), new DepartmentUserDisplayFormatter$formatProfileFields$1(this)), DepartmentUserDisplayFormatter$formatProfileFields$2.INSTANCE), 2));
    }

    public static String a(Chatter r5, GetAnotherNameFormatResponse.FormatRule r6) {
        Intrinsics.checkNotNullParameter(r5, "chatter");
        Intrinsics.checkNotNullParameter(r6, "rule");
        String r0 = r5.localized_name;
        String r1 = BuildConfig.FLAVOR;
        if (r0 != null) goto L6;
        r0 = BuildConfig.FLAVOR;
    L6:
        if (StringsKt.isBlank(r0) == false) goto L10;
        r0 = r5.name;
        if (r0 != null) goto L10;
        r0 = BuildConfig.FLAVOR;
    L10:
        e.a().getClass();
        int r2 = com.ss.android.lark.language.service.impl.a.f;
        if (Intrinsics.areEqual(com.ss.android.lark.language.service.impl.a.b.a.g().getLanguage(), Locale.ENGLISH.getLanguage()) == false) goto L19;
        String r3 = r5.en_us_name;
        if (r3 != null) goto L16;
        r3 = BuildConfig.FLAVOR;
    L16:
        if (StringsKt.isBlank(r3) == true) goto L19;
        r0 = r3;
    L19:
        String r4 = r5.alias;
        if (r4 != null) goto L22;
        r4 = BuildConfig.FLAVOR;
    L22:
        String r7 = r5.another_name;
        if (r7 == null) goto L27;
        r1 = r7;
    L27:
        if (StringsKt.isBlank(r4) == false) goto L32;
        if (StringsKt.isBlank(r1) == false) goto L32;
        return r0;
    L32:
        if (StringsKt.isBlank(r1) == false) goto L36;
        return r0 + '(' + r4 + ')';
    L36:
        if (c.a[r6.ordinal()] != 1) goto L42;
        StringBuilder r8 = new StringBuilder();
        r8.append(r1);
        r8.append('(');
        if (StringsKt.isBlank(r4) == true) goto L41;
        r0 = r4;
    L41:
        r8.append(r0);
        r8.append(')');
        return r8.toString();
    L42:
        StringBuilder r9 = new StringBuilder();
        r9.append(r0);
        r9.append('(');
        if (StringsKt.isBlank(r4) == false) goto L45;
        r4 = r1;
    L45:
        r9.append(r4);
        r9.append(')');
        return r9.toString();
    }
}
