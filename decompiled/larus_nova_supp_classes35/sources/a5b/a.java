package a5b;

import com.ss.android.lark.chat.cot.ActivityExtra;
import com.ss.android.lark.chat.cot.CotViewBlock;
import com.ss.android.lark.chat.cot.CotViewBlockType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a extends h {
    public String g;

    @Override // a5b.h
    public final CotViewBlock a() {
        CotViewBlock r0 = super.a();
        String r4 = this.g;
        return CotViewBlock.copy$default(r0, null, null, null, r4, null, false, new ActivityExtra(r4), 55, null);
    }

    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "stableId");
        super(r2, CotViewBlockType.ACTIVITY);
    }
}
