package com.bytedance.applog;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class WhalerGameHelper {

    public static final enum Result extends Enum<Result> {
        private static final /* synthetic */ Result[] $VALUES = null;
        public static final Result FAIL = null;
        public static final Result SUCCESS = null;
        public static final Result UNCOMPLETED = null;
        final String gameResult;

        static {
            Result r0 = new Result("UNCOMPLETED", 0, "uncompleted");
            UNCOMPLETED = r0;
            Result r1 = new Result("SUCCESS", 1, "success");
            SUCCESS = r1;
            Result r3 = new Result("FAIL", 2, "fail");
            FAIL = r3;
            $VALUES = new Result[]{r0, r1, r3};
        }

        private Result(String r1, int r2, String r3) {
            super(r1, r2);
            this.gameResult = r3;
        }

        public static Result valueOf(String r2) {
            return (Result) ZeusTransformUtils.preCheckCast(Enum.valueOf(Result.class, r2), Result.class, "com.obric.memorydata.plugin");
        }

        public static Result[] values() {
            return (Result[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Result[].class, "com.obric.memorydata.plugin");
        }
    }
}
