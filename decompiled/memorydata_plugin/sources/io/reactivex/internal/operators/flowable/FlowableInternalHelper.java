package io.reactivex.internal.operators.flowable;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import io.reactivex.b.g;

/* JADX INFO: loaded from: classes6.dex */
public final class FlowableInternalHelper {

    public static final enum RequestMax extends Enum<RequestMax> implements g<org.a.d> {
        private static final /* synthetic */ RequestMax[] $VALUES = null;
        public static final RequestMax INSTANCE = null;

        static {
            RequestMax r0 = new RequestMax("INSTANCE", 0);
            INSTANCE = r0;
            $VALUES = new RequestMax[]{r0};
        }

        private RequestMax(String r1, int r2) {
            super(r1, r2);
        }

        public static RequestMax valueOf(String r2) {
            return (RequestMax) ZeusTransformUtils.preCheckCast(Enum.valueOf(RequestMax.class, r2), RequestMax.class, "com.obric.memorydata.plugin");
        }

        public static RequestMax[] values() {
            return (RequestMax[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RequestMax[].class, "com.obric.memorydata.plugin");
        }

        @Override // io.reactivex.b.g
        public /* synthetic */ void accept(org.a.d r3) {
            accept2((org.a.d) ZeusTransformUtils.preCheckCast(r3, org.a.d.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(org.a.d r3) {
            ((org.a.d) ZeusTransformUtils.wrapperContextForParams(r3, org.a.d.class, "com.obric.memorydata.plugin")).request(Long.MAX_VALUE);
        }
    }
}
