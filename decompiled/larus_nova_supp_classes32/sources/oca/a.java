package oca;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UpdateMessageLocalOption;
import com.obric.aivoice.core.data.NameKeys;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class a implements Function1 {
    public final /* synthetic */ Map a;

    public /* synthetic */ a(Map r1) {
        this.a = r1;
    }

    public final Object invoke(Object r6) {
        Map r0 = this.a;
        Intrinsics.checkNotNullParameter((Message) r6, "it");
        LinkedHashMap r7 = new LinkedHashMap();
        UpdateMessageLocalOption r1 = UpdateMessageLocalOption.REPLACE_EXT;
        StringCompanionObject r2 = StringCompanionObject.INSTANCE;
        kuc.a.f(r2);
        v2 r3 = v2.a;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r4 = zd9.i.c(r0, kuc.a.c(r3, r3));
        if (r4 != null) goto L5;
        r4 = NameKeys.UnloadStrategy_No_Strategy;
    L5:
        r7.put(r1, r4);
        return r7;
    }
}
