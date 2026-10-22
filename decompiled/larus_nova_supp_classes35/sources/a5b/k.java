package a5b;

import com.ss.android.lark.chat.cot.CotViewBlock;
import com.ss.android.lark.chat.cot.CotViewBlockType;
import com.ss.android.lark.chat.cot.RunExtra;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k extends h {
    public String g;

    @Override // a5b.h
    public final CotViewBlock a() {
        return CotViewBlock.copy$default(super.a(), null, null, null, null, null, false, new RunExtra(this.g), 63, null);
    }

    public k(String r2) {
        Intrinsics.checkNotNullParameter(r2, "stableId");
        super(r2, CotViewBlockType.RUN);
    }
}
