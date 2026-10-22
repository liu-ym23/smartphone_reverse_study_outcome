package io.noties.markwon.ext.tables;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class Table {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Object> f16492a;

    public static final enum Alignment extends Enum<Alignment> {
        private static final /* synthetic */ Alignment[] $VALUES = null;
        public static final Alignment CENTER = null;
        public static final Alignment LEFT = null;
        public static final Alignment RIGHT = null;

        static {
            Alignment r0 = new Alignment("LEFT", 0);
            LEFT = r0;
            Alignment r1 = new Alignment("CENTER", 1);
            CENTER = r1;
            Alignment r3 = new Alignment("RIGHT", 2);
            RIGHT = r3;
            $VALUES = new Alignment[]{r0, r1, r3};
        }

        private Alignment(String r1, int r2) {
            super(r1, r2);
        }

        public static Alignment valueOf(String r2) {
            return (Alignment) ZeusTransformUtils.preCheckCast(Enum.valueOf(Alignment.class, r2), Alignment.class, "com.obric.memorydata.plugin");
        }

        public static Alignment[] values() {
            return (Alignment[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Alignment[].class, "com.obric.memorydata.plugin");
        }
    }

    public String toString() {
        return "Table{rows=" + this.f16492a + '}';
    }
}
