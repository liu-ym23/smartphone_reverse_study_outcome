package com.byted.mgl.merge.service.api.share;

import org.json.JSONArray;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface BdpShareCallback {

    public static final enum ProcessResult extends Enum<ProcessResult> {
        private static final /* synthetic */ ProcessResult[] $VALUES = null;
        public static final ProcessResult CUT_TEMPLATE_PROCESS_FAIL = null;

        static {
            ProcessResult r0 = new ProcessResult("CUT_TEMPLATE_PROCESS_FAIL", 0);
            CUT_TEMPLATE_PROCESS_FAIL = r0;
            $VALUES = new ProcessResult[]{r0};
        }

        public static ProcessResult[] values() {
            return (ProcessResult[]) $VALUES.clone();
        }

        public static ProcessResult valueOf(String r1) {
            return (ProcessResult) a.a(ProcessResult.class, r1);
        }

        private ProcessResult(String r1, int r10) {
            super(r1, r10);
        }
    }

    void onCancel(String r1);

    void onFail(String r1, JSONArray r10);

    void onProcess(ProcessResult r1);

    void onPublishResponseFinish(boolean r1, String r10, boolean r11, String r12, boolean r13, String r14);

    void onSuccess(String r1, JSONArray r10);
}
