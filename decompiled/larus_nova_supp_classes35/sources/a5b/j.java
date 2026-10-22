package a5b;

import com.ss.android.lark.chat.cot.CotViewBlock;
import com.ss.android.lark.chat.cot.CotViewBlockType;
import com.ss.android.lark.chat.cot.ReasoningExtra;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j extends h {
    public final List<String> g;

    @Override // a5b.h
    public final CotViewBlock a() {
        CotViewBlock r0 = super.a();
        ArrayList r7 = (ArrayList) this.g;
        ArrayList r9 = null;
        if ((!r7.isEmpty()) == true) goto L6;
        r7 = null;
    L6:
        if (r7 == null) goto L9;
        r9 = new ArrayList(r7);
    L9:
        return CotViewBlock.copy$default(r0, null, null, null, null, null, false, new ReasoningExtra(r9), 63, null);
    }

    public j(String r2) {
        Intrinsics.checkNotNullParameter(r2, "stableId");
        super(r2, CotViewBlockType.REASONING);
        this.g = new ArrayList();
    }
}
