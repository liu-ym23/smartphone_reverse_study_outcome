package com.google.common.graph;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class Graphs {

    private static final enum NodeVisitState extends Enum<NodeVisitState> {
        private static final /* synthetic */ NodeVisitState[] $VALUES = null;
        public static final NodeVisitState COMPLETE = null;
        public static final NodeVisitState PENDING = null;

        private static /* synthetic */ NodeVisitState[] $values() {
            return new NodeVisitState[]{PENDING, COMPLETE};
        }

        static {
            PENDING = new NodeVisitState("PENDING", 0);
            COMPLETE = new NodeVisitState("COMPLETE", 1);
            $VALUES = $values();
        }

        private NodeVisitState(String r1, int r2) {
            super(r1, r2);
        }

        public static NodeVisitState valueOf(String r2) {
            return (NodeVisitState) ZeusTransformUtils.preCheckCast(Enum.valueOf(NodeVisitState.class, r2), NodeVisitState.class, "com.obric.memorydata.plugin");
        }

        public static NodeVisitState[] values() {
            return (NodeVisitState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), NodeVisitState[].class, "com.obric.memorydata.plugin");
        }
    }
}
