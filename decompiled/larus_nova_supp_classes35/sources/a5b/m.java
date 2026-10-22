package a5b;

import com.ss.android.lark.chat.cot.CotViewBlock;
import com.ss.android.lark.chat.cot.CotViewBlockType;
import com.ss.android.lark.chat.cot.TextExtra;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m extends h {
    @Override // a5b.h
    public final CotViewBlock a() {
        return CotViewBlock.copy$default(super.a(), null, null, null, null, null, false, TextExtra.INSTANCE, 63, null);
    }

    public m(String r2) {
        Intrinsics.checkNotNullParameter(r2, "stableId");
        super(r2, CotViewBlockType.TEXT);
    }
}
