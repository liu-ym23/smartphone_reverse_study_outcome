package nwb;

import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.LarkContext;
import javax.inject.Inject;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@UserScope
public final class d implements com.ss.android.lark.framework.assembly.rust.d {

    public static final class a {
    }

    static {
    }

    @Inject
    public d() {
    }

    public final com.ss.android.lark.sdk.h a() {
        if (((com.ss.android.lark.passport.dpop.b) LarkContext.spiByDwarf(com.ss.android.lark.passport.dpop.b.class)).isDoubaoBUser() == true) goto L6;
        return null;
    L6:
        com.ss.android.lark.sdk.h r0 = new com.ss.android.lark.sdk.h();
        r0.e = MapsKt.mapOf(TuplesKt.to("IsDoubaoEnterpriseUser", "1"));
        return r0;
    }
}
