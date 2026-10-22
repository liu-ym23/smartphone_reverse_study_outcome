package com.google.common.graph;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
final class GraphConstants {

    static final enum Presence extends Enum<Presence> {
        private static final /* synthetic */ Presence[] $VALUES = null;
        public static final Presence EDGE_EXISTS = null;

        private static /* synthetic */ Presence[] $values() {
            return new Presence[]{EDGE_EXISTS};
        }

        static {
            EDGE_EXISTS = new Presence("EDGE_EXISTS", 0);
            $VALUES = $values();
        }

        private Presence(String r1, int r2) {
            super(r1, r2);
        }

        public static Presence valueOf(String r2) {
            return (Presence) ZeusTransformUtils.preCheckCast(Enum.valueOf(Presence.class, r2), Presence.class, "com.obric.memorydata.plugin");
        }

        public static Presence[] values() {
            return (Presence[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Presence[].class, "com.obric.memorydata.plugin");
        }
    }
}
