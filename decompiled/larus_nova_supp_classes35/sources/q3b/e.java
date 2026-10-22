package q3b;

import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e extends x4b.a<MessageInfo> {
    public final int d;
    public final Map<String, Boolean> e;

    public e(List<? extends MessageInfo> r2, List<Integer> r3, List<Integer> r4, int r5, Map<String, Boolean> r6) {
        Intrinsics.checkNotNullParameter(r2, "dataList");
        Intrinsics.checkNotNullParameter(r3, "invisiblePositions");
        Intrinsics.checkNotNullParameter(r4, "missingPositions");
        Intrinsics.checkNotNullParameter(r6, "syncPipeFinishMap");
        super(r2, r3, r4);
        this.d = r5;
        this.e = r6;
    }
}
