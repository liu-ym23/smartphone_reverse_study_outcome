package qha;

import android.content.Context;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import com.larus.utils.y0;
import com.obric.assistant.spi.actionbar.ObricSpecialInputType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class o {
    public static final z0 a(Context r21, z0 r22) {
        Intrinsics.checkNotNullParameter(r21, "context");
        Intrinsics.checkNotNullParameter(r22, "source");
        String r1 = y0.k(UriProtector.parse("res://" + r21.getPackageName() + "/2131244357"));
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        g1 r2 = new g1(null, r1, null, null, 29);
        String r7 = r21.getString(2131911924);
        int r0 = ActionBarExecutionType.INSTRUCTION.getValue();
        return z0.a(r22, Long.valueOf(-761162256), "obric_quick_instruction", r2, r2, r7, Integer.valueOf(r0), null, null, new com.larus.bmhome.actionbar.model.r(Integer.valueOf(ObricSpecialInputType.SPECIAL_INPUT.getType()), null, null, null, null, null, null, null, 4094), null, null, null, false, -65632);
    }
}
