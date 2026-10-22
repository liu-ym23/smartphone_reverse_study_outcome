package rob;

import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter.ItemType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class g {
    public final ItemType a;
    public final Object b;

    public Object a() {
        return this.b;
    }

    public final ItemType getType() {
        return this.a;
    }

    public g(ItemType r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "data");
        this.a = r2;
        this.b = r3;
    }
}
