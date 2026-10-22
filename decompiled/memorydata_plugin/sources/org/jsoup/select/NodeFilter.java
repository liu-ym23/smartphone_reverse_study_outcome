package org.jsoup.select;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.jsoup.nodes.j;

/* JADX INFO: loaded from: classes7.dex */
public interface NodeFilter {

    public static final enum FilterResult extends Enum<FilterResult> {
        private static final /* synthetic */ FilterResult[] $VALUES = null;
        public static final FilterResult CONTINUE = null;
        public static final FilterResult REMOVE = null;
        public static final FilterResult SKIP_CHILDREN = null;
        public static final FilterResult SKIP_ENTIRELY = null;
        public static final FilterResult STOP = null;

        private static /* synthetic */ FilterResult[] $values() {
            return new FilterResult[]{CONTINUE, SKIP_CHILDREN, SKIP_ENTIRELY, REMOVE, STOP};
        }

        static {
            CONTINUE = new FilterResult("CONTINUE", 0);
            SKIP_CHILDREN = new FilterResult("SKIP_CHILDREN", 1);
            SKIP_ENTIRELY = new FilterResult("SKIP_ENTIRELY", 2);
            REMOVE = new FilterResult("REMOVE", 3);
            STOP = new FilterResult("STOP", 4);
            $VALUES = $values();
        }

        private FilterResult(String r1, int r2) {
            super(r1, r2);
        }

        public static FilterResult valueOf(String r2) {
            return (FilterResult) ZeusTransformUtils.preCheckCast(Enum.valueOf(FilterResult.class, r2), FilterResult.class, "com.obric.memorydata.plugin");
        }

        public static FilterResult[] values() {
            return (FilterResult[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FilterResult[].class, "com.obric.memorydata.plugin");
        }
    }

    default FilterResult a(j r1, int r2) {
        return FilterResult.CONTINUE;
    }

    FilterResult head(j r1, int r2);
}
