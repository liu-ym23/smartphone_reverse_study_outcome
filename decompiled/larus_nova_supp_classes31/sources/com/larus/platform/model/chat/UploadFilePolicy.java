package com.larus.platform.model.chat;

import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class UploadFilePolicy {
    public static volatile boolean a;
    public static volatile boolean b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/platform/model/chat/UploadFilePolicy$TypePolicyMode;", "", "<init>", "(Ljava/lang/String;I)V", "ALLOWLIST", "DENYLIST", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    public static final enum TypePolicyMode extends Enum<TypePolicyMode> {
        public static final TypePolicyMode ALLOWLIST = null;
        public static final TypePolicyMode DENYLIST = null;
        public static final /* synthetic */ TypePolicyMode[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<TypePolicyMode> getEntries() {
            return b;
        }

        static {
            TypePolicyMode r0 = new TypePolicyMode("ALLOWLIST", 0);
            ALLOWLIST = r0;
            TypePolicyMode r1 = new TypePolicyMode("DENYLIST", 1);
            DENYLIST = r1;
            TypePolicyMode[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static TypePolicyMode[] values() {
            return (TypePolicyMode[]) a.clone();
        }

        public static TypePolicyMode valueOf(String r1) {
            return (TypePolicyMode) r27.a.a(TypePolicyMode.class, r1);
        }

        public TypePolicyMode(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
        public final TypePolicyMode a;
        public final List<String> b;

        /* JADX INFO: renamed from: com.larus.platform.model.chat.UploadFilePolicy$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0011a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[TypePolicyMode.values().length];
                r0[TypePolicyMode.DENYLIST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[TypePolicyMode.ALLOWLIST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (this.a == r6.a) goto L12;
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
            return "TypePolicy(mode=" + this.a + ", identifiers=" + this.b + ')';
        }

        public final boolean a(String r5) {
            Intrinsics.checkNotNullParameter(r5, "extension");
            String r6 = StringsKt.trimStart(StringsKt.trim(r5).toString(), new char[]{'.'}).toLowerCase(Locale.ROOT);
            int r1 = C0011a.a[this.a.ordinal()];
            if (r1 == 1) goto L17;
            if (r1 != 2) goto L15;
            if (r6.length() <= 0) goto L9;
            boolean r2 = true;
        L10:
            if (r2 == true) goto L12;
        L19:
            return false;
        L12:
            if (this.b.contains(r6) == false) goto L19;
            return true;
        L9:
            r2 = false;
            goto L10
        L15:
            throw new NoWhenBranchMatchedException();
        L17:
            if (this.b.contains(r6) == true) goto L19;
            return true;
        }

        public a(TypePolicyMode r2, List<String> r3) {
            Intrinsics.checkNotNullParameter(r2, "mode");
            Intrinsics.checkNotNullParameter(r3, "identifiers");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public static List b() {
        boolean r0 = false;
        a r1 = i(false);
        if (r1.a != TypePolicyMode.ALLOWLIST) goto L5;
        r0 = true;
    L5:
        List<String> r2 = null;
        if (r0 == true) goto L9;
        r1 = null;
    L9:
        if (r1 == null) goto L11;
        r2 = r1.b;
    L11:
        if (r2 == null) goto L13;
        return r2;
    L13:
        return CollectionsKt.emptyList();
    }

    public static boolean c() {
        if (i(false).a != TypePolicyMode.DENYLIST) goto L6;
        return true;
    L6:
        return false;
    }

    public static long d() {
        if (a == false) goto L8;
        Long r0 = z2.a.getFlowMultiUploadConfig().i();
        if (r0 != null) goto L15;
        return 524288000;
    L15:
        return r0.longValue();
    L8:
        s0 r1 = z2.a.getFlowMultiUploadConfig().m();
        if (r1 == null) goto L13;
        Long r2 = r1.b();
        if (r2 == null) goto L13;
        return r2.longValue();
    L13:
        return 104857600;
    }

    public static boolean e(String r1) {
        Intrinsics.checkNotNullParameter(r1, "extension");
        return i(true).a(r1);
    }

    public static boolean f(long r3) {
        if (r3 > 0) goto L5;
    L7:
        return false;
    L5:
        if (r3 > d()) goto L7;
        return true;
    }

    public static boolean g(String r1) {
        Intrinsics.checkNotNullParameter(r1, "extension");
        return i(false).a(r1);
    }

    public static List h(List r7) {
        ArrayList r0 = null;
        if (r7 == null) goto L25;
        ArrayList r1 = new ArrayList();
        Iterator r8 = r7.iterator();
    L6:
        if (r8.hasNext() == false) goto L24;
        String r2 = (String) r8.next();
        if (r2 == null) goto L21;
        String r3 = StringsKt.trim(r2).toString();
        if (r3 == null) goto L21;
        boolean r4 = true;
        String r5 = StringsKt.trimStart(r3, new char[]{'.'});
        if (r5 == null) goto L21;
        String r6 = r5.toLowerCase(Locale.ROOT);
        if (r6 == null) goto L21;
        if (r6.length() > 0) goto L19;
        r4 = false;
    L19:
        if (r4 == false) goto L21;
    L22:
        if (r6 == null) goto L6;
        r1.add(r6);
    L21:
        r6 = null;
        goto L22
    L24:
        r0 = r1;
    L25:
        if (r0 == null) goto L27;
        return r0;
    L27:
        return CollectionsKt.emptyList();
    }

    public static a i(boolean r2) {
        t r0 = z2.a.getFlowMultiUploadConfig();
        if (a == false) goto L9;
        List<String> r3 = r0.g();
        List<String> r1 = r0.h();
        if (r1 != null) goto L21;
        r1 = r0.k();
    L21:
        return a(r3, r1);
    L9:
        if (AccountService.a.isEnterpriseAccount() == false) goto L14;
        List<String> r4 = r0.d();
        List<String> r5 = r0.e();
        if (r5 != null) goto L22;
        r5 = r0.k();
    L22:
        return a(r4, r5);
    L14:
        if (r2 == false) goto L20;
        List<String> r6 = r0.f();
        List<String> r7 = r0.b();
        if (r7 != null) goto L23;
        r7 = r0.k();
    L23:
        return a(r6, r7);
    L20:
        return a(r0.f(), r0.k());
    }

    public static a a(List r1, List r2) {
        if (r1 == null) goto L5;
        return new a(TypePolicyMode.DENYLIST, h(r1));
    L5:
        return new a(TypePolicyMode.ALLOWLIST, h(r2));
    }
}
