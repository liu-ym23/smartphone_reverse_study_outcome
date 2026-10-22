package zp9;

import com.larus.network.http.HttpExtKt;
import com.larus.platform.api.creation.AuthorInfo;
import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.PublisherCreation;
import com.larus.platform.api.creation.TplButtonType;
import com.larus.platform.api.creation.TplDetail;
import com.larus.platform.api.creation.TplInfo;
import com.larus.platform.api.creation.TplType;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationRefContent;
import com.larus.platform.service.AccountService;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d {
    public static final String b(UserCreation r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        AuthorInfo r0 = r3.g;
        if (r0 == null) goto L5;
        String r1 = r0.b;
    L7:
        if (Intrinsics.areEqual(r1, AccountService.a.getUserId()) == false) goto L9;
        return "self_created";
    L9:
        Integer r2 = r3.j;
        if (r2 != null) goto L13;
    L14:
        Integer r4 = r3.j;
        if (r4 == null) goto L22;
        if (r4 != null) goto L19;
    L27:
        return "others_created";
    L19:
        if (r4.intValue() != 3) goto L27;
    L25:
        return "default";
    L22:
        if (r3.b == 1) goto L25;
    L13:
        if (r2.intValue() == 0) goto L22;
    L5:
        r1 = null;
        goto L7
    }

    public static final String c(UserCreation r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return y.a(r1.b);
    }

    public static final String d(UserCreation r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return y.b(r1.b);
    }

    public static final String e(UserCreation r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        CreationDynamicInfo r2 = r1.h;
        if (r2 == null) goto L9;
        TplInfo r3 = r2.e;
        if (r3 == null) goto L9;
        TplDetail r4 = r3.b;
        if (r4 == null) goto L9;
        return r4.b;
    L9:
        return null;
    }

    public static final boolean f(UserCreation r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        return CollectionsKt.listOf(new Integer[]{7, 6, 9, 8, 10, 11, 12}).contains(Integer.valueOf(r4.b));
    }

    public static final String a(UserCreation r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (r3 == false) goto L5;
        return "use_prompt";
    L5:
        CreationDynamicInfo r4 = r2.h;
        if (r4 == null) goto L10;
        TplInfo r5 = r4.e;
        if (r5 == null) goto L10;
        String r6 = r5.a;
    L11:
        if (r6 == null) goto L31;
        int r7 = r6.hashCode();
        if (r7 != 3347807) goto L15;
        String r8 = TplType.MENU;
        if (r6.equals(TplType.MENU) == true) goto L30;
        return "use_prompt";
    L30:
        return r8;
    L15:
        if (r7 == 766630817) goto L23;
        if (r7 != 1430284143) goto L33;
        r8 = "change_picture";
        if (r6.equals("change_picture") == true) goto L30;
        return "use_prompt";
    L33:
        return "use_prompt";
    L23:
        if (r6.equals(TplType.AI_REPLICA) == false) goto L35;
        return TplButtonType.GEN_CREATE_AVATAR;
    L35:
        return "use_prompt";
    L31:
        return "use_prompt";
    L10:
        r6 = null;
        goto L11
    }

    public static final PublisherCreation g(UserCreation r19, String r20) {
        Intrinsics.checkNotNullParameter(r19, "<this>");
        int r1 = r19.b;
        String r3 = r19.a;
        CreationDynamicInfo r2 = r19.h;
        if (r2 == null) goto L5;
        String r6 = r2.d;
    L6:
        String r7 = r19.k();
        String r8 = r19.e();
        UserCreationRefContent r0 = r19.o;
        if (r0 == null) goto L9;
        String r9 = HttpExtKt.p(r0);
    L11:
        return new PublisherCreation(r3, Integer.valueOf(r1), null, r6, r7, r8, r9, null, r20, true, null, null, null, null, 15492, null);
    L9:
        r9 = null;
        goto L11
    L5:
        r6 = null;
        goto L6
    }
}
