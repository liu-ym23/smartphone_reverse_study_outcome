package h9b;

import com.ss.android.lark.contact.base.dependency.ContactBaseModuleDependency;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    static {
    }

    public static String a() {
        if (ContactBaseModuleDependency.b.isSmallB() == false) goto L5;
        String r0 = UIHelper.getString(2131892413);
        Intrinsics.checkNotNull(r0);
        return r0;
    L5:
        String r1 = UIHelper.getString(2131892414);
        Intrinsics.checkNotNull(r1);
        return r1;
    }
}
