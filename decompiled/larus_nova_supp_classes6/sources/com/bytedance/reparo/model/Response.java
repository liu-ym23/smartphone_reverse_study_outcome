package com.bytedance.reparo.model;

import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class Response {
    public PatchResponse data;
    public String message;

    public static class PatchResponse {
        public List<PatchFetchInfo> patch;

        public PatchResponse() {
        }
    }

    public Response() {
    }
}
