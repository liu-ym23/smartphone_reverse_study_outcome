package rob;

import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.ItemType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a extends g {
    public final b c;

    @Override // rob.g
    public final Object a() {
        return this.c;
    }

    public a(b r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        super(ItemType.AsrLanguage, r2);
        this.c = r2;
    }
}
