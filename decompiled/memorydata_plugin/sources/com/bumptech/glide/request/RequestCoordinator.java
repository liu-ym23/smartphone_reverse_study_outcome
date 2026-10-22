package com.bumptech.glide.request;

import com.obric.memorydata.database.entity.RawObservationEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public interface RequestCoordinator {

    public static final enum RequestState extends Enum<RequestState> {
        private static final /* synthetic */ RequestState[] $VALUES = null;
        public static final RequestState CLEARED = null;
        public static final RequestState FAILED = null;
        public static final RequestState PAUSED = null;
        public static final RequestState RUNNING = null;
        public static final RequestState SUCCESS = null;
        private final boolean isComplete;

        private static /* synthetic */ RequestState[] $values() {
            return new RequestState[]{RUNNING, PAUSED, CLEARED, SUCCESS, FAILED};
        }

        static {
            RUNNING = new RequestState("RUNNING", 0, false);
            PAUSED = new RequestState("PAUSED", 1, false);
            CLEARED = new RequestState("CLEARED", 2, false);
            SUCCESS = new RequestState("SUCCESS", 3, true);
            FAILED = new RequestState(RawObservationEntity.STATE_FAILED, 4, true);
            $VALUES = $values();
        }

        private RequestState(String r1, int r2, boolean r3) {
            super(r1, r2);
            this.isComplete = r3;
        }

        public static RequestState valueOf(String r2) {
            return (RequestState) ZeusTransformUtils.preCheckCast(Enum.valueOf(RequestState.class, r2), RequestState.class, "com.obric.memorydata.plugin");
        }

        public static RequestState[] values() {
            return (RequestState[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RequestState[].class, "com.obric.memorydata.plugin");
        }

        boolean isComplete() {
            return this.isComplete;
        }
    }

    boolean b(d r1);

    boolean c(d r1);

    boolean d(d r1);

    void e(d r1);

    void f(d r1);

    boolean g();

    RequestCoordinator h();
}
