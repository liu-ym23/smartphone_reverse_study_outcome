package com.byted.mgl.merge.service.api.share;

import android.text.TextUtils;
import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import com.bytedance.android.ec.core.event.a;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class BdpShareBaseInfo {
    public static final String CHANNEL_ARTICLE = "article";
    public static final String CHANNEL_PICTURE = "picture";
    public static final String CHANNEL_TOKEN = "token";
    public static final String CHANNEL_VIDEO = "video";
    private static final String TAG = "BdpShareBaseInfo";
    public String desc;
    public String entryPath;
    public String from;
    public String imMsgContent;
    public int imMsgType;
    public int imShareType;
    public String imageUrl;
    public String innerChannel;
    public boolean isPictureShare;
    public boolean isPictureToken;
    public boolean isShieldSelf;
    public boolean isVideoShare;
    public String linkTitle;
    public String miniImageUrl;
    public String outerShareUrl;
    public String path;
    public String query;
    public String queryString;
    public ShareAppInfo shareAppInfo;
    public ShareExtraInfo shareExtra;
    public String shareToken;
    public String shareType;
    public String templateId;
    public String title;

    public static class ShareAppInfo {
        public String anchorExtra;
        public String appIcon;
        public String appId;
        public String appName;
        public String homePath;
        public int orientation;
        public String schema;
        public String snapshotUrl;
        public String token;
        public String ttId;
        public int type;

        public String toString() {
            return "ShareAppInfo{appId='" + this.appId + "', ttId='" + this.ttId + "', appName='" + this.appName + "', appIcon='" + this.appIcon + "', type=" + this.type + ", schema='" + this.schema + "', anchorExtra='" + this.anchorExtra + "', snapshotUrl='" + this.snapshotUrl + "', orientation=" + this.orientation + ", token='" + this.token + "', homePath='" + this.homePath + "'}";
        }

        public ShareAppInfo() {
        }

        public ShareAppInfo(JSONObject r10) {
            this.appId = r10.optString(BdpAwemeConstant.KEY_APP_ID);
            this.ttId = r10.optString("ttid");
            this.appName = r10.optString(BdpAwemeConstant.KEY_APP_NAME);
            this.appIcon = r10.optString("appIcon");
            this.type = r10.optInt("appType");
            this.schema = r10.optString(a.KEY_SCHEMA);
            this.anchorExtra = r10.optString("anchorExtra");
            this.snapshotUrl = r10.optString("snapshotUrl");
            this.orientation = r10.optInt("orientation");
        }
    }

    public static class ShareExtraInfo {
        protected JSONObject extraJson;

        public String toJsonString() {
            return this.extraJson.toString();
        }

        public ShareExtraInfo(JSONObject r1) {
            if (r1 != null) goto L5;
            r1 = new JSONObject();
        L5:
            this.extraJson = r1;
        }

        public <T> T getData(String r10) {
            return (T) this.extraJson.opt(r10);
        }

        public void replace(JSONObject r1) {
            this.extraJson = r1;
        }

        public void updateData(String r10, Object r11) {
            this.extraJson.put(r10, r11);     // Catch: JSONException -> L4
            return;
        }
    }

    public String getExtraString() {
        return this.shareExtra.toJsonString();
    }

    public JSONObject toJson() {
        JSONObject r0 = new JSONObject();
        if (this.shareAppInfo != null) goto L8;
        return r0;
    L8:
        r0.put("channel", this.innerChannel);     // Catch: JSONException -> L7
        r0.put("title", this.title);     // Catch: JSONException -> L7
        r0.put("desc", this.desc);     // Catch: JSONException -> L7
        r0.put("imageUrl", this.imageUrl);     // Catch: JSONException -> L7
        r0.put("miniImageUrl", this.miniImageUrl);     // Catch: JSONException -> L7
        r0.put("templateId", this.templateId);     // Catch: JSONException -> L7
        r0.put("path", this.path);     // Catch: JSONException -> L7
        r0.put("query", this.query);     // Catch: JSONException -> L7
        r0.put("queryString", this.queryString);     // Catch: JSONException -> L7
        r0.put("entryPath", this.entryPath);     // Catch: JSONException -> L7
        r0.put(CHANNEL_TOKEN, this.shareToken);     // Catch: JSONException -> L7
        r0.put("ugUrl", this.outerShareUrl);     // Catch: JSONException -> L7
        r0.put("linkTitle", this.linkTitle);     // Catch: JSONException -> L7
        r0.put(BdpAwemeConstant.KEY_APP_ID, this.shareAppInfo.appId);     // Catch: JSONException -> L7
        r0.put("ttid", this.shareAppInfo.ttId);     // Catch: JSONException -> L7
        r0.put(BdpAwemeConstant.KEY_APP_NAME, this.shareAppInfo.appName);     // Catch: JSONException -> L7
        r0.put("appIcon", this.shareAppInfo.appIcon);     // Catch: JSONException -> L7
        r0.put("appType", this.shareAppInfo.type);     // Catch: JSONException -> L7
        r0.put(a.KEY_SCHEMA, this.shareAppInfo.schema);     // Catch: JSONException -> L7
        r0.put("anchorExtra", this.shareAppInfo.anchorExtra);     // Catch: JSONException -> L7
        r0.put("snapshotUrl", this.shareAppInfo.snapshotUrl);     // Catch: JSONException -> L7
        r0.put("orientation", this.shareAppInfo.orientation);     // Catch: JSONException -> L7
        r0.put("extra", getExtraString());     // Catch: JSONException -> L7
        r0.put("homePath", this.shareAppInfo.homePath);     // Catch: JSONException -> L7
    L6:
        return r0;
    }

    public String toString() {
        return "BdpShareBaseInfo{innerChannel='" + this.innerChannel + "', from='" + this.from + "', shareType='" + this.shareType + "', title='" + this.title + "', desc='" + this.desc + "', imageUrl='" + this.imageUrl + "', miniImageUrl='" + this.miniImageUrl + "', outerShareUrl='" + this.outerShareUrl + "', templateId='" + this.templateId + "', path='" + this.path + "', query='" + this.query + "', queryString='" + this.queryString + "', entryPath='" + this.entryPath + "', linkTitle='" + this.linkTitle + "', shareExtra=" + this.shareExtra + ", shareAppInfo=" + this.shareAppInfo + ", shareToken='" + this.shareToken + "', isPictureToken=" + this.isPictureToken + ", isVideoShare=" + this.isVideoShare + ", isShieldSelf=" + this.isShieldSelf + '}';
    }

    public BdpShareBaseInfo() {
    }

    public BdpShareBaseInfo(JSONObject r10) {
        this.innerChannel = r10.optString("channel");
        this.title = r10.optString("title");
        this.desc = r10.optString("desc");
        this.imageUrl = r10.optString("imageUrl");
        this.miniImageUrl = r10.optString("miniImageUrl");
        this.templateId = r10.optString("templateId");
        this.path = r10.optString("path");
        this.query = r10.optString("query");
        this.queryString = r10.optString("queryString");
        this.entryPath = r10.optString("entryPath");
        this.shareToken = r10.optString(CHANNEL_TOKEN);
        this.outerShareUrl = r10.optString("ugUrl");
        this.linkTitle = r10.optString("linkTitle");
        if (TextUtils.isEmpty(r10.optString(BdpAwemeConstant.KEY_APP_ID)) == true) goto L5;
        this.shareAppInfo = new ShareAppInfo(r10);
    L5:
        this.shareExtra = new ShareExtraInfo(r10.optJSONObject("extra"));
    }

    public static BdpShareBaseInfo fromJson(JSONObject r1) {
        return new BdpShareBaseInfo(r1);
    }

    public <T> T getExtraData(String r10) {
        return (T) this.shareExtra.getData(r10);
    }

    public void updateExtraData(String r10, Object r11) {
        this.shareExtra.updateData(r10, r11);
    }
}
