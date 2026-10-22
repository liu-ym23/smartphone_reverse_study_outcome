package com.ss.android.lark.profile_office.userprofile;

import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.contact.v2.GetDoubaoProfileRequest;
import com.bytedance.lark.pb.contact.v2.GetDoubaoProfileResponse;
import com.bytedance.lark.pb.contact.v2.I18nVal;
import com.ss.android.lark.widget.span.RecogniseSpansResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class OfficeProfileState {
    public static final Set<GetDoubaoProfileResponse.CTAType> p = null;
    public static final Lazy<GetDoubaoProfileResponse.CTAInfo> q = null;
    public final q1c.b<GetDoubaoProfileResponse> a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final Set<l> e;
    public final v1c.a f;
    public final List<String> g;
    public final List<String> h;
    public final boolean i;
    public final boolean j;
    public final com.ss.android.lark.compose.foundation.widget.a k;
    public final RecogniseSpansResult l;
    public final boolean m;
    public final Lazy n;
    public final Lazy o;

    public static final class a {
    }

    public OfficeProfileState() {
        boolean r0 = false;
        this(r0, r0, 8191);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OfficeProfileState) == true) goto L8;
        return false;
    L8:
        OfficeProfileState r6 = (OfficeProfileState) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
        return false;
    L45:
        if (this.m == r6.m) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        q1c.b<GetDoubaoProfileResponse> r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        int r4 = 1231;
        if (this.b == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.c == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (r6 + r7) * 31;
        if (this.d == false) goto L17;
        int r9 = 1231;
    L18:
        int r10 = (((((((((r8 + r9) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31;
        if (this.i == false) goto L21;
        int r11 = 1231;
    L22:
        int r12 = (r10 + r11) * 31;
        if (this.j == false) goto L25;
        int r13 = 1231;
    L26:
        int r14 = (((r12 + r13) * 31) + this.k.hashCode()) * 31;
        RecogniseSpansResult r15 = this.l;
        if (r15 == null) goto L30;
        r1 = r15.hashCode();
    L30:
        int r16 = (r14 + r1) * 31;
        if (this.m == true) goto L35;
        r4 = 1237;
    L35:
        return r16 + r4;
    L25:
        r13 = 1237;
        goto L26
    L21:
        r11 = 1237;
        goto L22
    L17:
        r9 = 1237;
        goto L18
    L13:
        r7 = 1237;
        goto L14
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "OfficeProfileState(response=" + this.a + ", isServerResponse=" + this.b + ", isIMEnabled=" + this.c + ", isLoginBUser=" + this.d + ", visibleItems=" + this.e + ", doubaoData=" + this.f + ", doubaoHomepageImages=" + this.g + ", departmentList=" + this.h + ", isAcceptingFriend=" + this.i + ", isDepartmentExpanded=" + this.j + ", blockSwitchState=" + this.k + ", descriptionSpanResult=" + this.l + ", isOnLeave=" + this.m + ')';
    }

    static {
        p = SetsKt.setOf(GetDoubaoProfileResponse.CTAType.CHAT);
        q = LazyKt.lazy(OfficeProfileState$Companion$MOCK_CTA$2.INSTANCE);
    }

    public final String b() {
        q1c.b<GetDoubaoProfileResponse> r0 = this.a;
        if (r0 == null) goto L9;
        GetDoubaoProfileResponse r1 = r0.a();
        if (r1 == null) goto L9;
        GetDoubaoProfileResponse.UserInfo r2 = r1.user_info;
        if (r2 == null) goto L9;
        String r3 = r2.alias;
    L10:
        if (r3 != null) goto L13;
        return "";
    L13:
        return r3;
    L9:
        r3 = null;
        goto L10
    }

    public final String c() {
        q1c.b<GetDoubaoProfileResponse> r0 = this.a;
        if (r0 == null) goto L11;
        GetDoubaoProfileResponse r1 = r0.a();
        if (r1 == null) goto L11;
        GetDoubaoProfileResponse.UserInfo r2 = r1.user_info;
        if (r2 == null) goto L11;
        GetDoubaoProfileResponse.CityInfo r3 = r2.city_info;
        if (r3 == null) goto L11;
        I18nVal r4 = r3.city;
    L13:
        return w1c.a.a(r4);
    L11:
        r4 = null;
        goto L13
    }

    public final GetDoubaoProfileResponse.ContactStatus d() {
        q1c.b<GetDoubaoProfileResponse> r0 = this.a;
        if (r0 == null) goto L9;
        GetDoubaoProfileResponse r1 = r0.a();
        if (r1 == null) goto L9;
        GetDoubaoProfileResponse.UserInfo r2 = r1.user_info;
        if (r2 == null) goto L9;
        return r2.contact_status;
    L9:
        return null;
    }

    public final List<GetDoubaoProfileResponse.CTAInfo> e() {
        q1c.b<GetDoubaoProfileResponse> r0 = this.a;
        List r1 = null;
        if (r0 == null) goto L5;
        GetDoubaoProfileResponse r2 = r0.a();
    L6:
        if (r2 == null) goto L8;
        r1 = r2.cta_info_list;
    L8:
        if (r1 != null) goto L10;
        r1 = CollectionsKt.emptyList();
    L10:
        ArrayList r3 = new ArrayList();
        Iterator r4 = r1.iterator();
    L12:
        if (r4.hasNext() == false) goto L17;
        Object r5 = r4.next();
        if (p.contains(((GetDoubaoProfileResponse.CTAInfo) r5).cta_type) == false) goto L12;
        r3.add(r5);
        goto L12
    L17:
        if (r3.isEmpty() == false) goto L23;
        if (r2 == null) goto L23;
        if (this.b == true) goto L23;
        return CollectionsKt.listOf((GetDoubaoProfileResponse.CTAInfo) q.getValue());
    L23:
        return r3;
    L5:
        r2 = null;
        goto L6
    }

    public final Long f() {
        q1c.b<GetDoubaoProfileResponse> r0 = this.a;
        if (r0 == null) goto L11;
        GetDoubaoProfileResponse r1 = r0.a();
        if (r1 == null) goto L11;
        GetDoubaoProfileResponse.UserInfo r2 = r1.user_info;
        if (r2 == null) goto L11;
        Chatter.Description r3 = r2.description;
        if (r3 == null) goto L11;
        return r3.description_id;
    L11:
        return null;
    }

    public final String g() {
        q1c.b<GetDoubaoProfileResponse> r0 = this.a;
        if (r0 == null) goto L11;
        GetDoubaoProfileResponse r1 = r0.a();
        if (r1 == null) goto L11;
        GetDoubaoProfileResponse.UserInfo r2 = r1.user_info;
        if (r2 == null) goto L11;
        Chatter.Description r3 = r2.description;
        if (r3 == null) goto L11;
        String r4 = r3.text;
    L12:
        if (r4 != null) goto L15;
        return "";
    L15:
        return r4;
    L11:
        r4 = null;
        goto L12
    }

    public final String h() {
        q1c.b<GetDoubaoProfileResponse> r0 = this.a;
        if (r0 == null) goto L11;
        GetDoubaoProfileResponse r1 = r0.a();
        if (r1 == null) goto L11;
        GetDoubaoProfileResponse.UserInfo r2 = r1.user_info;
        if (r2 == null) goto L11;
        GetDoubaoProfileResponse.LeaderInfo r3 = r2.leader_info;
        if (r3 == null) goto L11;
        I18nVal r4 = r3.user_name;
    L13:
        return w1c.a.a(r4);
    L11:
        r4 = null;
        goto L13
    }

    public final String i() {
        q1c.b<GetDoubaoProfileResponse> r0 = this.a;
        if (r0 == null) goto L11;
        GetDoubaoProfileResponse r1 = r0.a();
        if (r1 == null) goto L11;
        GetDoubaoProfileResponse.UserInfo r2 = r1.user_info;
        if (r2 == null) goto L11;
        GetDoubaoProfileResponse.LeaderInfo r3 = r2.leader_info;
        if (r3 == null) goto L11;
        String r4 = r3.user_id;
    L12:
        if (r4 != null) goto L15;
        return "";
    L15:
        return r4;
    L11:
        r4 = null;
        goto L12
    }

    public final String j() {
        q1c.b<GetDoubaoProfileResponse> r0 = this.a;
        if (r0 == null) goto L11;
        GetDoubaoProfileResponse r1 = r0.a();
        if (r1 == null) goto L11;
        GetDoubaoProfileResponse.UserInfo r2 = r1.user_info;
        if (r2 == null) goto L11;
        GetDoubaoProfileResponse.TenantInfo r3 = r2.tenant_info;
        if (r3 == null) goto L11;
        I18nVal r4 = r3.tenant_name;
    L13:
        return w1c.a.a(r4);
    L11:
        r4 = null;
        goto L13
    }

    public final String k() {
        q1c.b<GetDoubaoProfileResponse> r0 = this.a;
        if (r0 == null) goto L9;
        GetDoubaoProfileResponse r1 = r0.a();
        if (r1 == null) goto L9;
        GetDoubaoProfileResponse.UserInfo r2 = r1.user_info;
        if (r2 == null) goto L9;
        String r3 = r2.avatar_key;
    L10:
        if (r3 != null) goto L13;
        return "";
    L13:
        return r3;
    L9:
        r3 = null;
        goto L10
    }

    public final String l() {
        q1c.b<GetDoubaoProfileResponse> r0 = this.a;
        if (r0 == null) goto L9;
        GetDoubaoProfileResponse r1 = r0.a();
        if (r1 == null) goto L9;
        GetDoubaoProfileResponse.UserInfo r2 = r1.user_info;
        if (r2 == null) goto L9;
        String r3 = r2.user_id;
    L10:
        if (r3 != null) goto L13;
        return "";
    L13:
        return r3;
    L9:
        r3 = null;
        goto L10
    }

    public final String m() {
        q1c.b<GetDoubaoProfileResponse> r0 = this.a;
        if (r0 == null) goto L9;
        GetDoubaoProfileResponse r1 = r0.a();
        if (r1 == null) goto L9;
        GetDoubaoProfileResponse.UserInfo r2 = r1.user_info;
        if (r2 == null) goto L9;
        String r3 = r2.user_name;
    L10:
        if (r3 != null) goto L13;
        return "";
    L13:
        return r3;
    L9:
        r3 = null;
        goto L10
    }

    public final boolean n() {
        q1c.b<GetDoubaoProfileResponse> r0 = this.a;
        GetDoubaoProfileResponse.BlockStatus r1 = null;
        if (r0 == null) goto L5;
        GetDoubaoProfileResponse r2 = r0.a();
    L6:
        if (r2 == null) goto L11;
        GetDoubaoProfileResponse.UserInfo r3 = r2.user_info;
        if (r3 == null) goto L11;
        r1 = r3.block_status;
    L11:
        if (r1 != GetDoubaoProfileResponse.BlockStatus.BLOCK_FORWARD) goto L13;
    L16:
        return true;
    L13:
        if (r1 == GetDoubaoProfileResponse.BlockStatus.BLOCK_DUAL) goto L16;
        return false;
    L5:
        r2 = null;
        goto L6
    }

    public final boolean o() {
        q1c.b<GetDoubaoProfileResponse> r0 = this.a;
        if (r0 == null) goto L7;
        GetDoubaoProfileResponse r1 = r0.a();
        if (r1 == null) goto L7;
        GetDoubaoProfileRequest.DoubaoProfileEdition r2 = r1.edition;
    L9:
        if (r2 != GetDoubaoProfileRequest.DoubaoProfileEdition.EDITION_ENTERPRISE) goto L11;
        return true;
    L11:
        return false;
    L7:
        r2 = null;
        goto L9
    }

    public final boolean p() {
        q1c.b<GetDoubaoProfileResponse> r0 = this.a;
        if (r0 == null) goto L9;
        GetDoubaoProfileResponse r1 = r0.a();
        if (r1 == null) goto L9;
        GetDoubaoProfileResponse.UserInfo r2 = r1.user_info;
        if (r2 == null) goto L9;
        return Intrinsics.areEqual(r2.is_frozen, Boolean.TRUE);
    L9:
        return false;
    }

    public final boolean r() {
        q1c.b<GetDoubaoProfileResponse> r0 = this.a;
        if (r0 == null) goto L7;
        GetDoubaoProfileResponse r1 = r0.a();
        if (r1 == null) goto L7;
        GetDoubaoProfileRequest.DoubaoProfileEdition r2 = r1.edition;
    L9:
        if (r2 != GetDoubaoProfileRequest.DoubaoProfileEdition.EDITION_PERSONAL) goto L11;
        return true;
    L11:
        return false;
    L7:
        r2 = null;
        goto L9
    }

    public final boolean s() {
        q1c.b<GetDoubaoProfileResponse> r0 = this.a;
        if (r0 == null) goto L9;
        GetDoubaoProfileResponse r1 = r0.a();
        if (r1 == null) goto L9;
        GetDoubaoProfileResponse.UserInfo r2 = r1.user_info;
        if (r2 == null) goto L9;
        return Intrinsics.areEqual(r2.is_resigned, Boolean.TRUE);
    L9:
        return false;
    }

    public final boolean t() {
        q1c.b<GetDoubaoProfileResponse> r0 = this.a;
        if (r0 == null) goto L9;
        GetDoubaoProfileResponse r1 = r0.a();
        if (r1 == null) goto L9;
        GetDoubaoProfileResponse.UserInfo r2 = r1.user_info;
        if (r2 == null) goto L9;
        String r3 = r2.tenant_id;
    L10:
        if (r3 != null) goto L13;
        r3 = "";
    L13:
        if (r3.length() <= 0) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == true) goto L18;
    L20:
        return false;
    L18:
        if (Intrinsics.areEqual(r3, (String) this.o.getValue()) == false) goto L20;
        return true;
    L15:
        r4 = false;
    L9:
        r3 = null;
        goto L10
    }

    public final boolean u() {
        q1c.b<GetDoubaoProfileResponse> r0 = this.a;
        if (r0 == null) goto L9;
        GetDoubaoProfileResponse r1 = r0.a();
        if (r1 == null) goto L9;
        GetDoubaoProfileResponse.UserInfo r2 = r1.user_info;
        if (r2 == null) goto L9;
        String r3 = r2.user_id;
    L11:
        return Intrinsics.areEqual(r3, (String) this.n.getValue());
    L9:
        r3 = null;
        goto L11
    }

    public final boolean q(l r2) {
        Intrinsics.checkNotNullParameter(r2, "item");
        return this.e.contains(r2);
    }

    public /* synthetic */ OfficeProfileState(boolean r17, boolean r18, int r19) {
        if ((r19 & 4) == 0) goto L5;
        boolean r3 = false;
    L7:
        if ((r19 & 8) == 0) goto L9;
        boolean r5 = false;
    L11:
        if ((r19 & 16) == 0) goto L13;
        Set r6 = SetsKt.emptySet();
    L15:
        if ((r19 & 32) == 0) goto L17;
        v1c.a r8 = new v1c.a(0);
    L19:
        if ((r19 & 64) == 0) goto L21;
        List r9 = CollectionsKt.emptyList();
    L23:
        if ((r19 & 128) == 0) goto L25;
        List r10 = CollectionsKt.emptyList();
    L27:
        if ((r19 & 1024) == 0) goto L29;
        com.ss.android.lark.compose.foundation.widget.a r13 = new com.ss.android.lark.compose.foundation.widget.a(false, false);
    L30:
        this(null, false, r3, r5, r6, r8, r9, r10, false, false, r13, null, false);
        return;
    L29:
        r13 = null;
        goto L30
    L25:
        r10 = null;
        goto L27
    L21:
        r9 = null;
        goto L23
    L17:
        r8 = null;
        goto L19
    L13:
        r6 = null;
        goto L15
    L9:
        r5 = r18;
        goto L11
    L5:
        r3 = r17;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfficeProfileState(q1c.b<GetDoubaoProfileResponse> r2, boolean r3, boolean r4, boolean r5, Set<? extends l> r6, v1c.a r7, List<String> r8, List<String> r9, boolean r10, boolean r11, com.ss.android.lark.compose.foundation.widget.a r12, RecogniseSpansResult r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r6, "visibleItems");
        Intrinsics.checkNotNullParameter(r7, "doubaoData");
        Intrinsics.checkNotNullParameter(r8, "doubaoHomepageImages");
        Intrinsics.checkNotNullParameter(r9, "departmentList");
        Intrinsics.checkNotNullParameter(r12, "blockSwitchState");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
        this.l = r13;
        this.m = r14;
        this.n = LazyKt.lazy(OfficeProfileState$loginUserId$2.INSTANCE);
        this.o = LazyKt.lazy(OfficeProfileState$loginTenantId$2.INSTANCE);
    }

    public static OfficeProfileState a(OfficeProfileState r17, q1c.b r18, boolean r19, Set r20, v1c.a r21, List r22, List r23, boolean r24, boolean r25, com.ss.android.lark.compose.foundation.widget.a r26, RecogniseSpansResult r27, boolean r28, int r29) {
        if ((r29 & 1) == 0) goto L5;
        q1c.b r4 = r17.a;
    L7:
        if ((r29 & 2) == 0) goto L9;
        boolean r5 = r17.b;
    L11:
        if ((r29 & 4) == 0) goto L13;
        boolean r6 = r17.c;
    L15:
        if ((r29 & 8) == 0) goto L17;
        boolean r7 = r17.d;
    L19:
        if ((r29 & 16) == 0) goto L21;
        Set r8 = r17.e;
    L23:
        if ((r29 & 32) == 0) goto L25;
        v1c.a r9 = r17.f;
    L27:
        if ((r29 & 64) == 0) goto L29;
        List r10 = r17.g;
    L31:
        if ((r29 & 128) == 0) goto L33;
        List r11 = r17.h;
    L35:
        if ((r29 & 256) == 0) goto L37;
        boolean r12 = r17.i;
    L39:
        if ((r29 & 512) == 0) goto L41;
        boolean r13 = r17.j;
    L43:
        if ((r29 & 1024) == 0) goto L45;
        com.ss.android.lark.compose.foundation.widget.a r14 = r17.k;
    L47:
        if ((r29 & 2048) == 0) goto L49;
        RecogniseSpansResult r15 = r17.l;
    L51:
        if ((r29 & 4096) == 0) goto L53;
        boolean r16 = r17.m;
    L54:
        r17.getClass();
        Intrinsics.checkNotNullParameter(r8, "visibleItems");
        Intrinsics.checkNotNullParameter(r9, "doubaoData");
        Intrinsics.checkNotNullParameter(r10, "doubaoHomepageImages");
        Intrinsics.checkNotNullParameter(r11, "departmentList");
        Intrinsics.checkNotNullParameter(r14, "blockSwitchState");
        return new OfficeProfileState(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L53:
        r16 = r28;
        goto L54
    L49:
        r15 = r27;
        goto L51
    L45:
        r14 = r26;
        goto L47
    L41:
        r13 = r25;
        goto L43
    L37:
        r12 = r24;
        goto L39
    L33:
        r11 = r23;
        goto L35
    L29:
        r10 = r22;
        goto L31
    L25:
        r9 = r21;
        goto L27
    L21:
        r8 = r20;
        goto L23
    L17:
        r7 = false;
        goto L19
    L13:
        r6 = false;
        goto L15
    L9:
        r5 = r19;
        goto L11
    L5:
        r4 = r18;
        goto L7
    }
}
