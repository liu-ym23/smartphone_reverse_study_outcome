package com.larksuite.component.openplatform.api.entity;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class BlockInitData {

    @SerializedName("customApis")
    public List<CustomApis> customApis;

    @SerializedName("host")
    public String host;

    @SerializedName("typedDataCollection")
    public JsonObject typedDataCollection;

    public static class CustomApis {

        @SerializedName("apiName")
        public String apiName;

        @SerializedName("apiType")
        public String apiType;

        public CustomApis(String r1, String r2) {
            this.apiName = r1;
            this.apiType = r2;
        }
    }

    public BlockInitData() {
    }
}
