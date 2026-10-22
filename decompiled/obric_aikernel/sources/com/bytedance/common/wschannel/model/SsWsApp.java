package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import g2.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SsWsApp implements IWsApp, Parcelable {
    public static final Parcelable.Creator<SsWsApp> CREATOR = null;
    private String appKey;
    private int channelId;
    private String extra;
    private int fPid;
    private Map<String, String> headers;
    private int mAppId;
    private int mAppVersion;
    private String mDeviceId;
    boolean mDisableFallbackWs;
    private String mInstallId;
    int mMode;
    boolean mNewPrivateProtocolEnabled;
    private int mPlatform;
    String mPrivateProtocolUrl;
    List<Integer> mServiceIdList;
    private List<String> urls;

    static class a implements Parcelable.Creator<SsWsApp> {
        a() {
        }

        public SsWsApp a(Parcel r10) {
            return new SsWsApp(r10);
        }

        public SsWsApp[] b(int r10) {
            return new SsWsApp[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SsWsApp createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SsWsApp[] newArray(int r10) {
            return b(r10);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Map<String, String> f1357a;

        public b() {
            new ArrayList();
        }

        static /* synthetic */ Map a(b r10) {
            return r10.f1357a;
        }

        public SsWsApp b(JSONObject r10) {
            SsWsApp r11 = new SsWsApp();
            r11.parseFromJson(r10);
            return r11;
        }
    }

    static {
        CREATOR = new a();
    }

    protected SsWsApp() {
        this.headers = new HashMap();
        this.urls = new ArrayList();
        this.mServiceIdList = new ArrayList();
    }

    private SsWsApp(int r10, int r11, String r12, String r13, List<String> r14, int r15, int r16, int r17, String r18, String r19, boolean r110, List<Integer> r111, String r112, int r113, boolean r114, b r115) {
        this.headers = new HashMap();
        this.urls = new ArrayList();
        this.mServiceIdList = new ArrayList();
        this.mAppId = r11;
        this.channelId = r10;
        this.mDeviceId = r12;
        this.mInstallId = r13;
        if (r14 == null) goto L5;
        this.urls.addAll(r14);
    L5:
        this.mAppVersion = r15;
        this.mPlatform = r16;
        this.fPid = r17;
        this.appKey = r18;
        this.extra = r19;
        if (b.a(r115) == null) goto L8;
        this.headers.putAll(b.a(r115));
    L8:
        this.mNewPrivateProtocolEnabled = r110;
        this.mServiceIdList = r111;
        this.mPrivateProtocolUrl = r112;
        this.mMode = r113;
        this.mDisableFallbackWs = r114;
    }

    /* synthetic */ SsWsApp(int r10, int r11, String r12, String r13, List r14, int r15, int r16, int r17, String r18, String r19, boolean r110, List r111, String r112, int r113, boolean r114, b r115, a r116) {
        this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r114, r115);
    }

    protected SsWsApp(Parcel r10) {
        this.headers = new HashMap();
        this.urls = new ArrayList();
        this.mServiceIdList = new ArrayList();
        int r11 = r10.readInt();
        this.headers = new HashMap(r11);
        boolean r12 = false;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        this.headers.put(r10.readString(), r10.readString());
        r13 = r13 + 1;
        goto L3
    L5:
        this.urls = r10.createStringArrayList();
        this.channelId = r10.readInt();
        this.extra = r10.readString();
        this.mAppId = r10.readInt();
        this.mDeviceId = r10.readString();
        this.mInstallId = r10.readString();
        this.mAppVersion = r10.readInt();
        this.mPlatform = r10.readInt();
        this.fPid = r10.readInt();
        this.appKey = r10.readString();
        if (r10.readByte() == 0) goto L8;
        boolean r14 = true;
    L9:
        this.mNewPrivateProtocolEnabled = r14;
        int r15 = r10.readInt();
        int r16 = 0;
    L10:
        if (r16 >= r15) goto L12;
        this.mServiceIdList.add(Integer.valueOf(r10.readInt()));
        r16 = r16 + 1;
        goto L10
    L12:
        this.mPrivateProtocolUrl = r10.readString();
        this.mMode = r10.readInt();
        if (r10.readByte() == 0) goto L15;
        r12 = true;
    L15:
        this.mDisableFallbackWs = r12;
        return;
    L8:
        r14 = false;
        goto L9
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public boolean disableFallbackWSEnabled() {
        return this.mDisableFallbackWs;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L68:
        return false;
    L8:
        if (getClass() != r10.getClass()) goto L68;
        SsWsApp r11 = (SsWsApp) r10;
        if (this.channelId == r11.channelId) goto L14;
        return false;
    L14:
        if (this.mAppId == r11.mAppId) goto L17;
        return false;
    L17:
        if (this.mAppVersion == r11.mAppVersion) goto L20;
        return false;
    L20:
        if (this.mPlatform == r11.mPlatform) goto L23;
        return false;
    L23:
        if (this.fPid == r11.fPid) goto L26;
        return false;
    L26:
        if (this.headers.equals(r11.headers) == true) goto L28;
        return false;
    L28:
        List<String> r12 = this.urls;
        if (r12 == null) goto L34;
        if (r12.equals(r11.urls) == false) goto L35;
    L36:
        String r13 = this.extra;
        if (r13 == null) goto L42;
        if (r13.equals(r11.extra) == false) goto L43;
    L44:
        String r14 = this.mDeviceId;
        if (r14 == null) goto L50;
        if (r14.equals(r11.mDeviceId) == false) goto L51;
    L52:
        String r15 = this.mInstallId;
        if (r15 == null) goto L58;
        if (r15.equals(r11.mInstallId) == false) goto L59;
    L60:
        String r16 = this.appKey;
        if (r16 == null) goto L64;
        return r16.equals(r11.appKey);
    L64:
        if (r11.appKey != null) goto L67;
        return true;
    L67:
        return false;
    L59:
        return false;
    L58:
        if (r11.mInstallId == null) goto L60;
    L51:
        return false;
    L50:
        if (r11.mDeviceId == null) goto L52;
    L43:
        return false;
    L42:
        if (r11.extra == null) goto L44;
    L35:
        return false;
    L34:
        if (r11.urls == null) goto L36;
        goto L35
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int getAppId() {
        return this.mAppId;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public String getAppKey() {
        return this.appKey;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int getAppVersion() {
        return this.mAppVersion;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int getChannelId() {
        return this.channelId;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public List<String> getConnectUrls() {
        return this.urls;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public String getDeviceId() {
        return this.mDeviceId;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public String getExtra() {
        return this.extra;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int getFPID() {
        return this.fPid;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public Map<String, String> getHeaders() {
        return this.headers;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public String getInstallId() {
        return this.mInstallId;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int getPlatform() {
        return this.mPlatform;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    @Nullable
    public String getPrivateProtocolUrl() {
        return this.mPrivateProtocolUrl;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public List<Integer> getServiceIdList() {
        return this.mServiceIdList;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public int getTransportMode() {
        return this.mMode;
    }

    public int hashCode() {
        int r10 = this.headers.hashCode() * 31;
        List<String> r11 = this.urls;
        int r12 = 0;
        if (r11 == null) goto L5;
        int r13 = r11.hashCode();
    L6:
        int r14 = (((r10 + r13) * 31) + this.channelId) * 31;
        String r15 = this.extra;
        if (r15 == null) goto L9;
        int r16 = r15.hashCode();
    L10:
        int r17 = (((r14 + r16) * 31) + this.mAppId) * 31;
        String r18 = this.mDeviceId;
        if (r18 == null) goto L13;
        int r19 = r18.hashCode();
    L14:
        int r20 = (r17 + r19) * 31;
        String r21 = this.mInstallId;
        if (r21 == null) goto L17;
        int r22 = r21.hashCode();
    L18:
        int r23 = (((((((r20 + r22) * 31) + this.mAppVersion) * 31) + this.mPlatform) * 31) + this.fPid) * 31;
        String r24 = this.appKey;
        if (r24 == null) goto L22;
        r12 = r24.hashCode();
    L22:
        return r23 + r12;
    L17:
        r22 = 0;
        goto L18
    L13:
        r19 = 0;
        goto L14
    L9:
        r16 = 0;
        goto L10
    L5:
        r13 = 0;
        goto L6
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public boolean newPrivateProtocolEnabled() {
        return this.mNewPrivateProtocolEnabled;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public void parseFromJson(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        this.channelId = r10.optInt(WsConstants.KEY_CHANNEL_ID);
        this.mAppId = r10.optInt("app_id");
        this.mDeviceId = r10.optString("device_id");
        this.mInstallId = r10.optString("install_id");
        this.mAppVersion = r10.optInt("app_version");
        this.mPlatform = r10.optInt(WsConstants.KEY_PLATFORM);
        this.fPid = r10.optInt(WsConstants.KEY_FPID);
        this.appKey = r10.optString("app_kay");
        this.extra = r10.optString(WsConstants.KEY_EXTRA);
        JSONArray r11 = r10.optJSONArray("urls");
        this.urls.clear();
        int r12 = 0;
        if (r11 == null) goto L9;
        int r13 = r11.length();
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L9;
        this.urls.add(r11.optString(r14));
        r14 = r14 + 1;
    L9:
        this.mNewPrivateProtocolEnabled = r10.optBoolean(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE);
        JSONArray r15 = r10.optJSONArray(WsConstants.KEY_SERVICE_ID_LIST);
        this.mServiceIdList.clear();
        if (r15 == null) goto L14;
        int r16 = r15.length();
    L12:
        if (r12 >= r16) goto L14;
        this.mServiceIdList.add(Integer.valueOf(r15.optInt(r12)));
        r12 = r12 + 1;
    L14:
        this.mPrivateProtocolUrl = r10.optString(WsConstants.KEY_PRIVATE_PROTOCOL_URL);
        this.mMode = r10.optInt(WsConstants.KEY_TRANSPORT_MODE);
        this.mDisableFallbackWs = r10.optBoolean(WsConstants.KEY_DISABLE_FALLBACK_WEBSOCKET);
        this.headers.clear();
        this.headers.putAll(c.m(r10.optJSONObject("headers")));
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public JSONObject toJson() {
        JSONObject r10 = new JSONObject();
        r10.put(WsConstants.KEY_CHANNEL_ID, this.channelId);
        r10.put("app_id", this.mAppId);
        r10.put("device_id", this.mDeviceId);
        r10.put("install_id", this.mInstallId);
        JSONArray r11 = new JSONArray();
        List<String> r12 = this.urls;
        if (r12 == null) goto L8;
        Iterator<String> r13 = r12.iterator();
    L6:
        if (r13.hasNext() == false) goto L8;
        r11.put(r13.next());
    L8:
        r10.put("headers", c.n(this.headers));
        r10.put("urls", r11);
        r10.put("app_version", this.mAppVersion);
        r10.put(WsConstants.KEY_PLATFORM, this.mPlatform);
        r10.put(WsConstants.KEY_FPID, this.fPid);
        r10.put("app_kay", this.appKey);
        r10.put(WsConstants.KEY_EXTRA, this.extra);
        r10.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, this.mNewPrivateProtocolEnabled);
        JSONArray r14 = new JSONArray();
        List<Integer> r15 = this.mServiceIdList;
        if (r15 == null) goto L14;
        Iterator<Integer> r16 = r15.iterator();
    L12:
        if (r16.hasNext() == false) goto L14;
        r14.put(r16.next());
    L14:
        r10.put(WsConstants.KEY_SERVICE_ID_LIST, r14);
        r10.put(WsConstants.KEY_PRIVATE_PROTOCOL_URL, this.mPrivateProtocolUrl);
        r10.put(WsConstants.KEY_TRANSPORT_MODE, this.mMode);
        r10.put(WsConstants.KEY_DISABLE_FALLBACK_WEBSOCKET, this.mDisableFallbackWs);
        return r10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeInt(this.headers.size());
        Iterator<Map.Entry<String, String>> r12 = this.headers.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Map.Entry<String, String> r13 = r12.next();
        r10.writeString(r13.getKey());
        r10.writeString(r13.getValue());
        goto L4
    L6:
        r10.writeStringList(this.urls);
        r10.writeInt(this.channelId);
        r10.writeString(this.extra);
        r10.writeInt(this.mAppId);
        r10.writeString(this.mDeviceId);
        r10.writeString(this.mInstallId);
        r10.writeInt(this.mAppVersion);
        r10.writeInt(this.mPlatform);
        r10.writeInt(this.fPid);
        r10.writeString(this.appKey);
        r10.writeByte(this.mNewPrivateProtocolEnabled ? 1 : 0);
        r10.writeInt(this.mServiceIdList.size());
        Iterator<Integer> r14 = this.mServiceIdList.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        r10.writeInt(r14.next().intValue());
        goto L8
    L10:
        r10.writeString(this.mPrivateProtocolUrl);
        r10.writeInt(this.mMode);
        r10.writeByte(this.mDisableFallbackWs ? 1 : 0);
    }
}
