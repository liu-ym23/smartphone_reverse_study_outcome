package u1c;

import com.ss.android.lark.biz.im.api.e1;
import com.ss.android.lark.forwardv3.configuration.ConvertMessageParamsHandler;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import com.ss.android.lark.forwardv3.configuration.g;
import com.ss.android.lark.profile_office.shareprofile.ProfileForwardContent;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@ConvertMessageParamsHandler
public final class a implements g<ProfileForwardContent> {
    public a() {
    }

    public int getType() {
        return 4;
    }

    public final Object a(IForwardContent r4) {
        ProfileForwardContent r5 = (ProfileForwardContent) r4;
        if (r5 != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        e1.a r1 = new e1.a();
        r1.A = r5.a;
        r1.C = r5.b;
        r1.B = r5.c;
        r0.add(r1);
        return r0;
    }
}
