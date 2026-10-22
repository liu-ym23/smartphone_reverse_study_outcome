package com.larus.contextwindow.impl.membership;

import com.larus.contextwindow.impl.membership.model.MembershipQuotaRowKind;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final Regex a = null;

    /* JADX INFO: renamed from: com.larus.contextwindow.impl.membership.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0022a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MembershipQuotaRowKind.values().length];
            r0[MembershipQuotaRowKind.SUBSCRIPTION_TOTAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[MembershipQuotaRowKind.H5.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[MembershipQuotaRowKind.D7.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[MembershipQuotaRowKind.M1.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
        a = new Regex("\\s*/\\s*");
    }
}
