package com.bytedance.badger.collect.impl.model;

import android.net.Network;
import com.bytedance.badger.collect.impl.constants.NetworkMethodEnum;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class TTRequest {
    private String baseUrl;
    private final Map<String, String> bodyMap;
    private boolean enableOperator;
    private final Map<String, String> headers;
    private final NetworkMethodEnum method;
    private Network network;
    private Map<String, String> queryParams;

    public String toString() {
        return "TTRequest{baseUrl='" + this.baseUrl + "', method=" + this.method + ", headers=" + this.headers + ", queryParams=" + this.queryParams + ", body=" + this.bodyMap + '}';
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public Map<String, String> getBodyMap() {
        return this.bodyMap;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public NetworkMethodEnum getMethod() {
        return this.method;
    }

    public Network getNetwork() {
        return this.network;
    }

    public Map<String, String> getQueryParams() {
        return this.queryParams;
    }

    public boolean isEnableOperator() {
        return this.enableOperator;
    }

    public void setBaseUrl(String r1) {
        this.baseUrl = r1;
    }

    public TTRequest(String r2, NetworkMethodEnum r3, Map<String, String> r4) {
        this.network = null;
        this.baseUrl = r2;
        this.method = r3;
        this.headers = r4;
        this.bodyMap = null;
    }

    public TTRequest(String r2, NetworkMethodEnum r3, Map<String, String> r4, Map<String, String> r5) {
        this.network = null;
        this.baseUrl = r2;
        this.method = r3;
        this.headers = r4;
        this.bodyMap = r5;
    }

    public TTRequest(String r1, boolean r2, Network r3, NetworkMethodEnum r4, Map<String, String> r5, Map<String, String> r6) {
        this.baseUrl = r1;
        this.enableOperator = r2;
        this.network = r3;
        this.method = r4;
        this.headers = r5;
        this.queryParams = r6;
        this.bodyMap = null;
    }

    public TTRequest(boolean r2, String r3, NetworkMethodEnum r4, Map<String, String> r5, Map<String, String> r6, Map<String, String> r7) {
        this.network = null;
        this.enableOperator = r2;
        this.baseUrl = r3;
        this.method = r4;
        this.headers = r5;
        this.queryParams = r6;
        this.bodyMap = r7;
    }

    public TTRequest(String r1, boolean r2, Network r3, NetworkMethodEnum r4, Map<String, String> r5, Map<String, String> r6, Map<String, String> r7) {
        this.baseUrl = r1;
        this.enableOperator = r2;
        this.network = r3;
        this.method = r4;
        this.headers = r5;
        this.queryParams = r6;
        this.bodyMap = r7;
    }
}
