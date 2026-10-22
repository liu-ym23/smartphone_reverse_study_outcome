package org.apache.poi.sl.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.TextParagraph;

/* JADX INFO: loaded from: classes7.dex */
public interface TableCell<S extends Shape<S, P>, P extends TextParagraph<S, P, ? extends TextRun>> extends TextShape<S, P> {

    public static final enum BorderEdge extends Enum<BorderEdge> {
        private static final /* synthetic */ BorderEdge[] $VALUES = null;
        public static final BorderEdge bottom = null;
        public static final BorderEdge left = null;
        public static final BorderEdge right = null;
        public static final BorderEdge top = null;

        static {
            BorderEdge r0 = new BorderEdge("bottom", 0);
            bottom = r0;
            BorderEdge r1 = new BorderEdge("left", 1);
            left = r1;
            BorderEdge r3 = new BorderEdge("top", 2);
            top = r3;
            BorderEdge r5 = new BorderEdge("right", 3);
            right = r5;
            $VALUES = new BorderEdge[]{r0, r1, r3, r5};
        }

        private BorderEdge(String r1, int r2) {
            super(r1, r2);
        }

        public static BorderEdge valueOf(String r2) {
            return (BorderEdge) ZeusTransformUtils.preCheckCast(Enum.valueOf(BorderEdge.class, r2), BorderEdge.class, "com.obric.memorydata.plugin");
        }

        public static BorderEdge[] values() {
            return (BorderEdge[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), BorderEdge[].class, "com.obric.memorydata.plugin");
        }
    }
}
