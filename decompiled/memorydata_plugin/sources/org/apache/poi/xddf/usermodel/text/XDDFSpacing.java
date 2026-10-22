package org.apache.poi.xddf.usermodel.text;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public abstract class XDDFSpacing {

    public static final enum Kind extends Enum<Kind> {
        private static final /* synthetic */ Kind[] $VALUES = null;
        public static final Kind PERCENT = null;
        public static final Kind POINTS = null;

        static {
            Kind r0 = new Kind("PERCENT", 0);
            PERCENT = r0;
            Kind r1 = new Kind("POINTS", 1);
            POINTS = r1;
            $VALUES = new Kind[]{r0, r1};
        }

        private Kind(String r1, int r2) {
            super(r1, r2);
        }

        public static Kind valueOf(String r2) {
            return (Kind) ZeusTransformUtils.preCheckCast(Enum.valueOf(Kind.class, r2), Kind.class, "com.obric.memorydata.plugin");
        }

        public static Kind[] values() {
            return (Kind[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Kind[].class, "com.obric.memorydata.plugin");
        }
    }

    public abstract Kind getType();
}
