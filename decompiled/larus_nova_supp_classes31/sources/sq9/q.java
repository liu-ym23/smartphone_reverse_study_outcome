package sq9;

import com.larus.platform.api.creation.CreationDynamicInfo;
import com.larus.platform.api.creation.TplButtonType;
import com.larus.platform.api.creation.TplDetail;
import com.larus.platform.api.creation.TplInfo;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.model.creation.DoSameQuickMenuType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class q {
    public static final String a(String r3, UserCreation r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "userCreation");
        if (r3 == null) goto L37;
        int r1 = r3.hashCode();
        if (r1 == (-1557226724)) goto L34;
        if (r1 == (-1297919418)) goto L30;
        if (r1 != 430512511) goto L37;
        if (r3.equals(DoSameQuickMenuType.REPLACE_PIC) == false) goto L37;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r5 == false) goto L22;
        CreationDynamicInfo r7 = r4.h;
        if (r7 == null) goto L48;
        TplInfo r8 = r7.e;
        if (r8 == null) goto L49;
        TplDetail r9 = r8.c;
        if (r9 != null) goto L51;
        return null;
    L51:
        return r9.c;
    L49:
        return null;
    L48:
        return null;
    L22:
        CreationDynamicInfo r10 = r4.h;
        if (r10 == null) goto L52;
        TplInfo r11 = r10.e;
        if (r11 == null) goto L53;
        TplDetail r12 = r11.b;
        if (r12 != null) goto L55;
        return null;
    L55:
        return r12.c;
    L53:
        return null;
    L52:
        return null;
    L30:
        if (r3.equals(DoSameQuickMenuType.USE_PICTURE) == false) goto L37;
        return TplButtonType.USE_IMAGE;
    L34:
        if (r3.equals("use_prompt") == false) goto L37;
        return "use_prompt";
    L37:
        CreationDynamicInfo r13 = r4.h;
        if (r13 == null) goto L42;
        TplInfo r14 = r13.e;
        if (r14 == null) goto L42;
        String r15 = r14.a;
    L44:
        if (Intrinsics.areEqual(r15, "change_picture") == false) goto L58;
        if (r6 == false) goto L47;
        return null;
    L47:
        return "change_picture";
    L58:
        return null;
    L42:
        r15 = null;
        goto L44
    }
}
