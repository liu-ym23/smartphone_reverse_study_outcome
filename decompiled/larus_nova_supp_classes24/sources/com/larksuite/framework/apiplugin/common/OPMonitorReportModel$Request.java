package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.lark.opmonitor.model.OPMonitorCode;
import com.ss.android.lark.opmonitor.model.OPMonitorLevel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class OPMonitorReportModel$Request extends LKBaseRequestModel {

    @JSONField(name = "errorCode")
    public String mErrorCode;

    @JSONField(name = "errorMsg")
    public String mErrorMessage;

    @JSONField(name = "eventName")
    public String mEventName;

    @JSONField(name = "monitorCode")
    public OPInnerMonitorCode mMonitorCode;

    public static class OPInnerMonitorCode extends LKBaseRequestModel {

        @JSONField(name = "code")
        public int mCode;

        @JSONField(name = "domain")
        public String mDomain;

        @JSONField(name = "ID")
        public String mID;

        @JSONField(name = "level")
        public OPMonitorLevel mLevel;

        @JSONField(name = "message")
        public String mMessage;

        public OPInnerMonitorCode() {
        }

        public OPInnerMonitorCode adapter(OPMonitorCode r2) {
            this.mCode = r2.code;
            this.mDomain = r2.domain;
            this.mID = r2.ID;
            this.mLevel = r2.level;
            this.mMessage = r2.message;
            return this;
        }
    }

    public OPMonitorReportModel$Request() {
    }
}
