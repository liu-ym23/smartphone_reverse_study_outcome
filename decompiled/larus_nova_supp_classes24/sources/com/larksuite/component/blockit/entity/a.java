package com.larksuite.component.blockit.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class a {

    @SerializedName("code")
    public Integer code;

    @SerializedName("data")
    public C0010a data;

    @SerializedName("msg")
    public String msg;

    /* JADX INFO: renamed from: com.larksuite.component.blockit.entity.a$a, reason: collision with other inner class name */
    public static class C0010a {

        @SerializedName("availableItemList")
        public List<C0011a> availableItemList;

        @SerializedName("minUpdateInterval")
        public long minUpdateInterval;

        @SerializedName("ts")
        public long ts;

        /* JADX INFO: renamed from: com.larksuite.component.blockit.entity.a$a$a, reason: collision with other inner class name */
        public static class C0011a {

            @SerializedName("appId")
            public String appId;

            @SerializedName("appName")
            public Map<String, String> appName;

            @SerializedName("blockTypeId")
            public String blockTypeId;

            @SerializedName("category")
            public String category;

            @SerializedName("desc")
            public Map<String, String> desc;

            @SerializedName("descImage")
            public Map<String, String> descImage;

            @SerializedName("key")
            public String key;

            @SerializedName("mobileIcon")
            public String mobileIcon;

            @SerializedName("name")
            public Map<String, String> name;

            public C0011a() {
            }
        }

        public C0010a() {
        }
    }

    public a() {
    }
}
