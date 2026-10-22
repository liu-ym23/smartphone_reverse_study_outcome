package com.larus.contextwindow.impl.membership;

import com.google.gson.JsonElement;
import com.larus.contextwindow.impl.membership.model.MembershipInfoDto;
import com.larus.contextwindow.impl.membership.model.MembershipQuotaBarTier;
import com.larus.contextwindow.impl.membership.model.MembershipQuotaEntitlementDisplayDto;
import com.larus.contextwindow.impl.membership.model.MembershipQuotaEntitlementDto;
import com.larus.contextwindow.impl.membership.model.MembershipQuotaEntitlementGroupDto;
import com.larus.contextwindow.impl.membership.model.MembershipQuotaRowKind;
import com.larus.contextwindow.impl.membership.model.MembershipQuotaSource;
import com.larus.contextwindow.impl.membership.model.MembershipQuotaSummaryDto;
import com.larus.contextwindow.impl.membership.model.WindowLimitExemptionDto;
import com.larus.contextwindow.impl.membership.model.WindowLimitGroupDto;
import com.larus.contextwindow.impl.membership.model.WindowLimitItemDto;
import com.larus.contextwindow.impl.membership.model.WindowLimitSectionDto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c {
    public static final Set<Integer> a = null;

    public static final class a {
        public final WindowLimitItemDto a;
        public final boolean b;
        public final String c;
        public final String d;
        public final List<MembershipQuotaEntitlementDto> e;
        public final boolean f;
        public final Integer g;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            int r2 = 1231;
            if (this.b == false) goto L5;
            int r1 = 1231;
        L6:
            int r3 = (((r0 + r1) * 31) + this.c.hashCode()) * 31;
            String r4 = this.d;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (((r3 + r5) * 31) + this.e.hashCode()) * 31;
            if (this.f == true) goto L15;
            r2 = 1237;
        L15:
            return r6 + r2;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "Candidate(item=" + this.a + ", usageExhausted=" + this.b + ", featureGroup=" + this.c + ", serverLabel=" + this.d + ", entitlements=" + this.e + ", canDrillDown=" + this.f + ')';
        }

        public a(WindowLimitItemDto r2, boolean r3, String r4, String r5, List<MembershipQuotaEntitlementDto> r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r2, "item");
            Intrinsics.checkNotNullParameter(r4, "featureGroup");
            Intrinsics.checkNotNullParameter(r6, "entitlements");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            f r8 = f.a;
            JsonElement r9 = r2.getWindowType();
            r8.getClass();
            this.g = f.c(r9);
        }
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MembershipQuotaSource.values().length];
            r0[MembershipQuotaSource.ENTERPRISE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MembershipQuotaSource.PERSONAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        a = SetsKt.setOf(new Integer[]{1, 2, 4});
    }

    public static z29.c a(MembershipQuotaSummaryDto r36) {
        if (r36 == null) goto L5;
        List r1 = c(r36.getQuotaPackageSection());
        ArrayList r2 = new ArrayList();
        Iterator r3 = ((ArrayList) r1).iterator();
    L7:
        boolean r4 = true;
        if (r3.hasNext() == false) goto L18;
        Object r5 = r3.next();
        Integer r6 = ((a) r5).g;
        if (r6 != null) goto L13;
    L15:
        r4 = false;
    L16:
        if (r4 == false) goto L7;
        r2.add(r5);
        goto L7
    L13:
        if (r6.intValue() != 3) goto L15;
    L18:
        MembershipInfoDto r7 = r36.getMemberInfo();
        if (r7 == null) goto L21;
        boolean r8 = Intrinsics.areEqual(r7.getHasActiveSubscription(), Boolean.TRUE);
    L22:
        MembershipInfoDto r9 = r36.getMemberInfo();
        if (r9 == null) goto L25;
        boolean r10 = Intrinsics.areEqual(r9.getHasEnterpriseSubscription(), Boolean.TRUE);
    L26:
        if (r10 == false) goto L35;
        WindowLimitSectionDto r11 = r36.getEnterpriseWindowLimitSection();
        if (r11 == null) goto L30;
        boolean r12 = Intrinsics.areEqual(r11.getUsageExhausted(), Boolean.TRUE);
    L31:
        if (r12 == true) goto L35;
        if (d(r36.getEnterpriseWindowLimitSection()) == false) goto L35;
        boolean r13 = true;
    L36:
        if (r8 == false) goto L45;
        WindowLimitSectionDto r14 = r36.getWindowLimitSection();
        if (r14 == null) goto L40;
        boolean r15 = Intrinsics.areEqual(r14.getUsageExhausted(), Boolean.TRUE);
    L41:
        if (r15 == true) goto L45;
        if (d(r36.getWindowLimitSection()) == false) goto L45;
        boolean r16 = true;
    L46:
        if (r13 == false) goto L48;
        MembershipQuotaSource r17 = MembershipQuotaSource.ENTERPRISE;
    L55:
        if (r17 == null) goto L57;
    L60:
        ArrayList r18 = new ArrayList();
        MembershipQuotaSource r20 = MembershipQuotaSource.ENTERPRISE;
        if (r17 == r20) goto L66;
        MembershipQuotaRowKind r21 = MembershipQuotaRowKind.SUBSCRIPTION_TOTAL;
        a r22 = (a) CollectionsKt.singleOrNull(r2);
        if (r22 == null) goto L66;
        r18.add(b(r21, r22, true, false));
    L66:
        if (r17 != null) goto L68;
        int r23 = -1;
    L70:
        if (r23 == (-1)) goto L77;
        if (r23 == 1) goto L76;
        if (r23 != 2) goto L75;
        WindowLimitSectionDto r24 = r36.getWindowLimitSection();
    L78:
        int r25 = 10;
        if (r17 != r20) goto L142;
        List<MembershipQuotaEntitlementGroupDto> r26 = r36.getEnterprisePackageEntitlementGroups();
        if (r26 != null) goto L83;
        r26 = CollectionsKt.emptyList();
    L83:
        List r27 = CollectionsKt.filterNotNull(r26);
        ArrayList r28 = new ArrayList();
        Iterator r30 = r27.iterator();
    L85:
        if (r30.hasNext() == false) goto L100;
        MembershipQuotaEntitlementGroupDto r110 = (MembershipQuotaEntitlementGroupDto) r30.next();
        String r111 = r110.getFeatureGroup();
        if (r111 != null) goto L89;
    L97:
        Pair r112 = null;
    L98:
        if (r112 == null) goto L85;
        r28.add(r112);
        goto L85
    L89:
        if ((!StringsKt.isBlank(r111)) == true) goto L92;
        r111 = null;
    L92:
        if (r111 == null) goto L97;
        List<MembershipQuotaEntitlementDto> r113 = r110.getEntitlements();
        if (r113 != null) goto L96;
        r113 = CollectionsKt.emptyList();
    L96:
        r112 = TuplesKt.to(r111, CollectionsKt.filterNotNull(r113));
        goto L98
    L100:
        Map r31 = MapsKt.toMap(r28);
        if (r24 == null) goto L103;
        boolean r32 = Intrinsics.areEqual(r24.getUsageExhausted(), Boolean.TRUE);
    L104:
        if (r24 == null) goto L106;
        List<WindowLimitGroupDto> r33 = r24.getWindowLimitGroups();
    L107:
        if (r33 != null) goto L109;
        r33 = CollectionsKt.emptyList();
    L109:
        List r34 = CollectionsKt.filterNotNull(r33);
        List r114 = new ArrayList();
        Iterator r35 = r34.iterator();
    L111:
        if (r35.hasNext() == false) goto L143;
        WindowLimitGroupDto r115 = (WindowLimitGroupDto) r35.next();
        String r116 = r115.getFeatureGroup();
        if (r116 != null) goto L115;
        r116 = "";
    L115:
        String r117 = r116;
        List r118 = (List) r31.get(r117);
        if (r118 != null) goto L118;
        r118 = CollectionsKt.emptyList();
    L118:
        List r119 = r118;
        List<WindowLimitItemDto> r120 = r115.getWindowLimits();
        if (r120 != null) goto L121;
        r120 = CollectionsKt.emptyList();
    L121:
        List r121 = CollectionsKt.filterNotNull(r120);
        ArrayList r122 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r121, r25));
        Iterator r123 = r121.iterator();
    L123:
        if (r123.hasNext() == false) goto L140;
        WindowLimitItemDto r124 = (WindowLimitItemDto) r123.next();
        String r125 = r115.getFeatureGroupName();
        if (r125 != null) goto L127;
    L129:
        String r126 = null;
    L130:
        f r127 = f.a;
        JsonElement r128 = r124.getItemType();
        r127.getClass();
        Integer r129 = f.c(r128);
        if (r129 != null) goto L134;
    L138:
        boolean r210 = false;
    L139:
        ArrayList r37 = r122;
        r37.add(new a(r124, r32, r117, r126, r119, r210));
        r122 = r37;
        r114 = r114;
        r117 = r117;
        goto L123
    L134:
        if (r129.intValue() != 1) goto L138;
        if ((!r119.isEmpty()) == false) goto L138;
        r210 = true;
        goto L139
    L127:
        if ((!StringsKt.isBlank(r125)) == false) goto L129;
        r126 = r125;
        goto L130
    L140:
        CollectionsKt.addAll(r114, r122);
        r25 = 10;
    L143:
        MembershipQuotaRowKind r38 = MembershipQuotaRowKind.H5;
        ArrayList r40 = new ArrayList();
        Iterator r41 = r114.iterator();
    L145:
        if (r41.hasNext() == false) goto L155;
        Object r42 = r41.next();
        Integer r43 = ((a) r42).g;
        if (r43 != null) goto L150;
    L152:
        boolean r44 = false;
    L153:
        if (r44 == false) goto L145;
        r40.add(r42);
        goto L145
    L150:
        if (r43.intValue() != 1) goto L152;
        r44 = true;
        goto L153
    L155:
        a r45 = (a) CollectionsKt.singleOrNull(r40);
        if (r45 == null) goto L158;
        r18.add(b(r38, r45, true, false));
    L158:
        ArrayList r46 = new ArrayList();
        Iterator r47 = r114.iterator();
    L160:
        if (r47.hasNext() == false) goto L170;
        Object r48 = r47.next();
        Integer r50 = ((a) r48).g;
        if (r50 != null) goto L165;
    L167:
        boolean r51 = false;
    L168:
        if (r51 == false) goto L160;
        r46.add(r48);
        goto L160
    L165:
        if (r50.intValue() != 2) goto L167;
        r51 = true;
        goto L168
    L170:
        ArrayList r52 = new ArrayList();
        Iterator r53 = r114.iterator();
    L172:
        if (r53.hasNext() == false) goto L183;
        Object r54 = r53.next();
        Integer r55 = ((a) r54).g;
        if (r55 != null) goto L177;
    L179:
        boolean r56 = false;
    L180:
        if (r56 == false) goto L172;
        r52.add(r54);
        goto L172
    L177:
        if (r55.intValue() != 4) goto L179;
        r56 = true;
        goto L180
    L183:
        if (r17 != MembershipQuotaSource.ENTERPRISE) goto L230;
        a r57 = (a) CollectionsKt.firstOrNull(r46);
        if (r57 == null) goto L187;
        r18.add(b(MembershipQuotaRowKind.D7, r57, false, false));
    L187:
        ArrayList r58 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r52, 10));
        Iterator r60 = r52.iterator();
    L189:
        if (r60.hasNext() == false) goto L191;
        r58.add(((a) r60.next()).c);
        goto L189
    L191:
        int r61 = CollectionsKt.toSet(r58).size();
        if (r61 != r52.size()) goto L241;
        if (r61 <= 1) goto L196;
        boolean r62 = true;
    L197:
        Iterator r63 = r52.iterator();
    L199:
        if (r63.hasNext() == false) goto L241;
        a r64 = (a) r63.next();
        if (r64.f == false) goto L225;
        if (r64.e.size() <= 1) goto L225;
        Iterator<MembershipQuotaEntitlementDto> r65 = r64.e.iterator();
    L206:
        if (r65.hasNext() == false) goto L199;
        MembershipQuotaEntitlementDto r66 = r65.next();
        f r67 = f.a;
        JsonElement r130 = r66.getTotalUsedPercent();
        r67.getClass();
        z29.d r68 = f.d(f.b(r130), Intrinsics.areEqual(r66.getTotalLessThanOnePercent(), Boolean.TRUE), false, false, r66.getUsedAmount(), r66.getTotalAmount());
        MembershipQuotaRowKind r211 = MembershipQuotaRowKind.M1;
        MembershipQuotaEntitlementDisplayDto r70 = r66.getDisplay();
        if (r70 == null) goto L216;
        String r71 = r70.getTitle();
        if (r71 == null) goto L216;
        if ((!StringsKt.isBlank(r71)) == true) goto L215;
        r71 = null;
    L215:
        if (r71 == null) goto L216;
    L217:
        String r212 = r71;
        double r131 = r68.a;
        double r132 = r68.b;
        MembershipQuotaBarTier r213 = f.a(r132);
        boolean r72 = r68.c;
        boolean r133 = r68.d;
        boolean r134 = r68.e;
        z29.a r73 = r68.f;
        if (r73 == null) goto L220;
        String r310 = r73.a;
    L221:
        if (r73 == null) goto L223;
        String r311 = r73.b;
    L224:
        r18.add(new z29.b(r211, r212, false, r131, r132, r213, r72, r133, r134, r310, r311, null));
        goto L206
    L223:
        r311 = null;
        goto L224
    L220:
        r310 = null;
    L216:
        r71 = r64.d;
    L225:
        MembershipQuotaRowKind r0 = MembershipQuotaRowKind.M1;
        if (r61 != 1) goto L228;
        boolean r74 = true;
    L229:
        r18.add(b(r0, r64, r62, r74));
        goto L199
    L228:
        r74 = false;
        goto L229
    L196:
        r62 = false;
    L241:
        return new z29.c(r18);
    L230:
        List r75 = CollectionsKt.plus(r46, r52);
        if (r75.size() != 1) goto L241;
        a r76 = (a) CollectionsKt.single(r75);
        Integer r77 = r76.g;
        if (r77 != null) goto L236;
    L238:
        MembershipQuotaRowKind r78 = MembershipQuotaRowKind.D7;
    L239:
        r18.add(b(r78, r76, false, false));
        goto L241
    L236:
        if (r77.intValue() != 4) goto L238;
        r78 = MembershipQuotaRowKind.M1;
        goto L239
    L106:
        r33 = null;
        goto L107
    L103:
        r32 = false;
        goto L104
    L142:
        r114 = c(r24);
        goto L143
    L75:
        throw new NoWhenBranchMatchedException();
    L76:
        r24 = r36.getEnterpriseWindowLimitSection();
        goto L78
    L77:
        r24 = null;
        goto L78
    L68:
        r23 = b.a[r17.ordinal()];
        goto L70
    L57:
        if (r2.isEmpty() == false) goto L60;
        return new z29.c(0);
    L48:
        if (r16 == false) goto L50;
        r17 = MembershipQuotaSource.PERSONAL;
        goto L55
    L50:
        if (r10 == false) goto L52;
        r17 = MembershipQuotaSource.ENTERPRISE;
        goto L55
    L52:
        if (r8 == false) goto L54;
        r17 = MembershipQuotaSource.PERSONAL;
        goto L55
    L54:
        r17 = null;
        goto L55
    L40:
        r15 = false;
    L45:
        r16 = false;
        goto L46
    L30:
        r12 = false;
    L35:
        r13 = false;
        goto L36
    L25:
        r10 = false;
        goto L26
    L21:
        r8 = false;
        goto L22
    L5:
        return new z29.c(0);
    }

    public static List c(WindowLimitSectionDto r14) {
        if (r14 == null) goto L4;
        boolean r0 = Intrinsics.areEqual(r14.getUsageExhausted(), Boolean.TRUE);
    L6:
        if (r14 == null) goto L8;
        List<WindowLimitGroupDto> r15 = r14.getWindowLimitGroups();
    L9:
        if (r15 != null) goto L11;
        r15 = CollectionsKt.emptyList();
    L11:
        List r16 = CollectionsKt.filterNotNull(r15);
        ArrayList r9 = new ArrayList();
        Iterator r17 = r16.iterator();
    L13:
        if (r17.hasNext() == false) goto L31;
        WindowLimitGroupDto r10 = (WindowLimitGroupDto) r17.next();
        List<WindowLimitItemDto> r1 = r10.getWindowLimits();
        if (r1 != null) goto L17;
        r1 = CollectionsKt.emptyList();
    L17:
        List r2 = CollectionsKt.filterNotNull(r1);
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r12 = r2.iterator();
    L19:
        if (r12.hasNext() == false) goto L30;
        WindowLimitItemDto r3 = (WindowLimitItemDto) r12.next();
        String r4 = r10.getFeatureGroup();
        if (r4 != null) goto L23;
        r4 = "";
    L23:
        String r5 = r4;
        String r6 = r10.getFeatureGroupName();
        if (r6 != null) goto L26;
    L28:
        String r7 = null;
    L29:
        r11.add(new a(r3, r0, r5, r7, CollectionsKt.emptyList(), false));
        goto L19
    L26:
        if ((!StringsKt.isBlank(r6)) == false) goto L28;
        r7 = r6;
        goto L29
    L30:
        CollectionsKt.addAll(r9, r11);
        goto L13
    L31:
        return r9;
    L8:
        r15 = null;
        goto L9
    L4:
        r0 = false;
        goto L6
    }

    public static boolean d(WindowLimitSectionDto r2) {
        ArrayList r3 = (ArrayList) c(r2);
        if (r3.isEmpty() == true) goto L11;
        Iterator r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        a r0 = (a) r4.next();
        if (CollectionsKt.contains(a, r0.g) == false) goto L7;
        return true;
    L11:
        return false;
    }

    public static z29.b b(MembershipQuotaRowKind r18, a r110, boolean r20, boolean r21) {
        MembershipQuotaRowKind r2 = MembershipQuotaRowKind.H5;
        boolean r3 = false;
        if (r18 != r2) goto L10;
        WindowLimitExemptionDto r5 = r110.a.getExemption();
        if (r5 == null) goto L7;
        boolean r6 = Intrinsics.areEqual(r5.getActive(), Boolean.TRUE);
    L8:
        if (r6 == false) goto L10;
        boolean r7 = true;
    L11:
        f r8 = f.a;
        JsonElement r9 = r110.a.getUsedPercent();
        r8.getClass();
        z29.d r10 = f.d(f.b(r9), Intrinsics.areEqual(r110.a.getLessThanOnePercent(), Boolean.TRUE), r110.b, r7, r110.a.getUsedAmount(), r110.a.getTotalAmount());
        if (r18 != r2) goto L33;
        if (r7 == false) goto L18;
        WindowLimitExemptionDto r4 = r110.a.getExemption();
        if (r4 == null) goto L17;
        JsonElement r11 = r4.getEndTime();
    L19:
        Double r12 = f.b(r11);
        if (r12 == null) goto L31;
        double r13 = r12.doubleValue();
        if (r13 <= 0.0d) goto L31;
        if ((r13 % 1.0d) != 0.0d) goto L26;
        r3 = true;
    L26:
        if (r3 == false) goto L31;
        if (r13 > 9.223372036854776E18d) goto L31;
        Long r14 = Long.valueOf((long) r13);
    L32:
        Long r15 = r14;
    L34:
        String r0 = r110.d;
        if (r20 == false) goto L37;
        String r16 = r0;
    L38:
        double r17 = r10.a;
        double r22 = r10.b;
        MembershipQuotaBarTier r111 = f.a(r22);
        boolean r112 = r10.c;
        boolean r113 = r10.d;
        boolean r114 = r10.e;
        z29.a r1 = r10.f;
        if (r1 == null) goto L41;
        String r115 = r1.a;
    L42:
        if (r1 == null) goto L44;
        String r116 = r1.b;
    L46:
        return new z29.b(r18, r16, r21, r17, r22, r111, r112, r113, r114, r115, r116, r15);
    L44:
        r116 = null;
        goto L46
    L41:
        r115 = null;
        goto L42
    L37:
        r16 = null;
    L31:
        r14 = null;
        goto L32
    L17:
        r11 = null;
        goto L19
    L18:
        r11 = r110.a.getEndTime();
        goto L19
    L33:
        r15 = null;
        goto L34
    L7:
        r6 = false;
    L10:
        r7 = false;
        goto L11
    }
}
