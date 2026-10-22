package com.ss.android.lark.conditional.access.utils;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.ss.android.lark.passport.signinsdk_api.base.policy.PolicyAgreement;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.CommonCmd;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class PrivacyPolicyUtils {
    public static final String[] a = null;
    public static final String[] b = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/conditional/access/utils/PrivacyPolicyUtils$PolicyType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "SERVICE_TERM", "PRIVACY", "AGREEMENT", "conditional-access_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PolicyType extends Enum<PolicyType> {
        public static final PolicyType AGREEMENT = null;
        public static final PolicyType PRIVACY = null;
        public static final PolicyType SERVICE_TERM = null;
        public static final /* synthetic */ PolicyType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<PolicyType> getEntries() {
            return b;
        }

        static {
            PolicyType r0 = new PolicyType("SERVICE_TERM", 0);
            SERVICE_TERM = r0;
            PolicyType r1 = new PolicyType("PRIVACY", 1);
            PRIVACY = r1;
            PolicyType r3 = new PolicyType("AGREEMENT", 2);
            AGREEMENT = r3;
            PolicyType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static PolicyType[] values() {
            return (PolicyType[]) a.clone();
        }

        public static PolicyType valueOf(String r1) {
            return (PolicyType) r27.a.a(PolicyType.class, r1);
        }

        public PolicyType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static class a {
        public final Context a;
        public final int b;
        public final Map<PolicyType, b> c;

        public a(Context r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "context");
            this.a = r4;
            this.b = r5;
            LinkedHashMap r6 = new LinkedHashMap();
            this.c = r6;
            String[] r0 = PrivacyPolicyUtils.a;
            int r1 = g8b.b.a;
            g8b.b.a.a().getDependency().getPassportDependency().c(PolicyAgreement.SERVICE_TERM);
            b r2 = new b(r4.getString(2131890550), BuildConfig.FLAVOR);
            r6.put(PolicyType.SERVICE_TERM, r2);
            g8b.b.a.a().getDependency().getPassportDependency().c(PolicyAgreement.PRIVACY);
            b r3 = new b(r4.getString(2131890530), BuildConfig.FLAVOR);
            r6.put(PolicyType.PRIVACY, r3);
        }
    }

    public static final class b {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Policy(replacement=" + this.a + ", url=" + this.b + ')';
        }

        public b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "replacement");
            Intrinsics.checkNotNullParameter(r3, "url");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c extends a {
        public final TextView d;

        public final void a() {
            TextView r0 = this.d;
            String[] r1 = PrivacyPolicyUtils.a;
            Intrinsics.checkNotNullParameter(r0, CommonCmd.AIDL_PLATFORM_TYPE_TV);
            r0.setMovementMethod(LinkMovementMethod.getInstance());
            r0.setHighlightColor(0);
            TextView r2 = this.d;
            Context r3 = this.a;
            int r4 = this.b;
            Map<PolicyType, b> r5 = this.c;
            Intrinsics.checkNotNullParameter(r3, "context");
            SpannableStringBuilder r6 = new SpannableStringBuilder();
            r6.append(r3.getString(r4));
            if (r5 == null) goto L6;
            LinkedHashMap r7 = (LinkedHashMap) r5;
            b r8 = (b) r7.get(PolicyType.SERVICE_TERM);
            if (r8 == null) goto L6;
        L7:
            PrivacyPolicyUtils.a(r3, r6, PrivacyPolicyUtils.a, PolicyType.SERVICE_TERM, r8);
            if (r5 == null) goto L11;
            LinkedHashMap r9 = (LinkedHashMap) r5;
            b r10 = (b) r9.get(PolicyType.PRIVACY);
            if (r10 == null) goto L11;
        L12:
            PrivacyPolicyUtils.a(r3, r6, PrivacyPolicyUtils.b, PolicyType.PRIVACY, r10);
            r2.setText(r6);
            return;
        L11:
            int r11 = g8b.b.a;
            g8b.b.a.a().getDependency().getPassportDependency().c(PolicyAgreement.PRIVACY);
            r10 = new b(r3.getString(2131890530), BuildConfig.FLAVOR);
        L6:
            int r12 = g8b.b.a;
            g8b.b.a.a().getDependency().getPassportDependency().c(PolicyAgreement.SERVICE_TERM);
            r8 = new b(r3.getString(2131890550), BuildConfig.FLAVOR);
            goto L7
        }

        public c(TextView r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "textView");
            super(r2.getContext(), r3);
            this.d = r2;
        }
    }

    static {
        a = new String[]{"{{serviceTerm}}", "{{termService}}", "{{UserAgreement}}"};
        b = new String[]{"{{privacy}}", "{{privacyPolicy}}", "{{PrivacyPolicy}}"};
    }

    public static void a(final Context r7, SpannableStringBuilder r8, String[] r9, final PolicyType r10, final b r11) {
        final Function1 r1 = null;
        Function0<CharSequence> r0 = new PrivacyPolicyUtils$mustache$provider$1(r7, r11, r1, r10);
        int r12 = r9.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        String r14 = r9[r13];
        int r2 = StringsKt.indexOf$default(r8, r14, 0, false, 6, null);
        if (r2 < 0) goto L8;
        r8.replace(r2, r14.length() + r2, (CharSequence) r0.invoke());
    L8:
        r13 = r13 + 1;
        goto L3
    }
}
