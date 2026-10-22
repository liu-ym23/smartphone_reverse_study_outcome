package com.ss.bduploader.smartserver;

import android.util.Log;

/* JADX INFO: loaded from: classes6.dex */
public class SmartVideoUploader {
    private static final String ROUTING_ENGINE_TYPE = "mlsdk";
    private static final String ROUTING_OUTPUT_TYPE = "regression";
    private static final String ROUTING_SERVER_NAME = "smart_upload_tcp_quic";
    private SmartServiceInterface mIntelligentService;
    private String mIntelligentURL;

    public SmartVideoUploader() {
        this.mIntelligentURL = "";
    }

    public void configServer() {
        Log.d("intelligent_uploader", "config_server engine_type: mlsdk outputType: regression service name: smart_upload_tcp_quic model_url: " + this.mIntelligentURL);
        this.mIntelligentService.setStringValue(1000, ROUTING_ENGINE_TYPE);
        this.mIntelligentService.setStringValue(1001, ROUTING_OUTPUT_TYPE);
        this.mIntelligentService.setStringValue(1002, ROUTING_SERVER_NAME);
        this.mIntelligentService.setStringValue(1003, this.mIntelligentURL);
        this.mIntelligentService.configServer();
    }

    public void init() {
        this.mIntelligentService = new SmartServiceWrapper();
    }

    public void preloadEnv() {
        SmartServiceInterface r0 = this.mIntelligentService;
        if (r0 == null) goto L6;
        r0.preloadEnv();
        return;
    }
}
