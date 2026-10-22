package com.larksuite.component.blockit.data;

import com.google.gson.annotations.SerializedName;
import com.larksuite.component.openplatform.api.entity.BaseBlockInfo;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class BlockGuideInfo extends BaseBlockInfo {

    @SerializedName("block_extension")
    public BlockExtension blockExtension;

    @SerializedName("block_extension_tip")
    public BlockExtensionTip blockExtensionTip;

    public static class BlockExtension implements Serializable {

        @SerializedName("status")
        public Integer status;

        public BlockExtension() {
        }
    }

    public static class BlockExtensionTip implements Serializable {

        @SerializedName("buttons")
        public List<Button> buttons;

        @SerializedName("content")
        public Map<String, String> content;

        public BlockExtensionTip() {
        }
    }

    public static class Button implements Serializable {

        @SerializedName("content")
        public Map<String, String> content;

        @SerializedName("schema")
        public String schema;

        public Button() {
        }
    }

    public BlockGuideInfo() {
    }
}
