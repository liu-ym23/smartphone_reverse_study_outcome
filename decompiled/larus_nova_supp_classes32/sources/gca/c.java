package gca;

import com.larus.im.bean.message.block.BlockType;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public static final Lazy a = null;
    public static final Lazy b = null;
    public static final Set<Integer> c = null;
    public static final Set<Integer> d = null;

    static {
        a = LazyKt.lazy(new a());
        b = LazyKt.lazy(new b());
        c = SetsKt.setOf(new Integer[]{Integer.valueOf(BlockType.BLOCK_TYPE_O_COMPLEX_CALL_FOR_ME.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_O_SEARCH_QUERY_RESULT.getValue())});
        d = SetsKt.setOf(new Integer[]{Integer.valueOf(BlockType.BLOCK_TYPE_O_REFERENCE_MSG.getValue()), Integer.valueOf(BlockType.BLOCK_TYPE_O_NORMAL_CLICK_INTENT.getValue())});
    }
}
