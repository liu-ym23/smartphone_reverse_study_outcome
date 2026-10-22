package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.event.ChannelType;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SocketState implements Parcelable {
    public static final Parcelable.Creator<SocketState> CREATOR = null;
    public int channelId;
    public int channelType;
    public int connectionState;
    public int connectionType;
    public String connectionUrl;
    public String error;
    public int errorCode;
    private boolean privateProtocolEnabled;

    static class a implements Parcelable.Creator<SocketState> {
        a() {
        }

        public SocketState a(Parcel r10) {
            return new SocketState(r10);
        }

        public SocketState[] b(int r10) {
            return new SocketState[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SocketState createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SocketState[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a();
    }

    public SocketState() {
    }

    protected SocketState(Parcel r10) {
        this.connectionType = r10.readInt();
        this.connectionState = r10.readInt();
        this.connectionUrl = r10.readString();
        this.channelId = r10.readInt();
        this.channelType = r10.readInt();
        this.error = r10.readString();
        this.errorCode = r10.readInt();
        if (r10.readInt() <= 0) goto L5;
        boolean r11 = true;
    L6:
        this.privateProtocolEnabled = r11;
        return;
    L5:
        r11 = false;
        goto L6
    }

    public static SocketState fromJson(JSONObject r10) {
        SocketState r11 = new SocketState();
        r11.channelId = r10.optInt(WsConstants.KEY_CHANNEL_ID, Integer.MIN_VALUE);
        r11.connectionType = r10.optInt(WsConstants.KEY_CONNECTION_TYPE, -1);
        r11.connectionState = r10.optInt("state", -1);
        r11.connectionUrl = r10.optString("url", "");
        r11.channelType = r10.optInt(WsConstants.KEY_CHANNEL_TYPE);
        r11.error = r10.optString("error", "");
        r11.errorCode = r10.optInt(WsConstants.ERROR_CODE);
        boolean r12 = false;
        if (r10.optInt(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, 0) <= 0) goto L5;
        r12 = true;
    L5:
        r11.privateProtocolEnabled = r12;
        return r11;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getChannelId() {
        return this.channelId;
    }

    public ChannelType getChannelType() {
        return ChannelType.of(this.channelType);
    }

    public int getConnectionState() {
        return this.connectionState;
    }

    public int getConnectionType() {
        return this.connectionType;
    }

    public String getConnectionUrl() {
        return this.connectionUrl;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public boolean isPrivateProtocolEnabled() {
        return this.privateProtocolEnabled;
    }

    public void setChannelId(int r10) {
        this.channelId = r10;
    }

    public void setConnectionState(int r10) {
        this.connectionState = r10;
    }

    public void setConnectionType(int r10) {
        this.connectionType = r10;
    }

    public void setConnectionUrl(String r10) {
        this.connectionUrl = r10;
    }

    public void setErrorCode(int r10) {
        this.errorCode = r10;
    }

    public JSONObject toJson() {
        JSONObject r10 = new JSONObject();
        r10.put(WsConstants.KEY_CHANNEL_ID, this.channelId);     // Catch: JSONException -> L9
        r10.put(WsConstants.KEY_CONNECTION_TYPE, this.connectionType);     // Catch: JSONException -> L9
        r10.put("state", this.connectionState);     // Catch: JSONException -> L9
        r10.put("url", this.connectionUrl);     // Catch: JSONException -> L9
        r10.put(WsConstants.KEY_CHANNEL_TYPE, this.channelType);     // Catch: JSONException -> L9
        r10.put("error", this.error);     // Catch: JSONException -> L9
        r10.put(WsConstants.ERROR_CODE, this.errorCode);     // Catch: JSONException -> L9
        if (this.privateProtocolEnabled == false) goto L6;
        int r11 = 1;
    L7:
        r10.put(WsConstants.KEY_PRIVATE_PROTOCOL_ENABLE, r11);     // Catch: JSONException -> L9
    L11:
        return r10;
    L6:
        r11 = 0;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public String toString() {
        return "SocketState{connectionType=" + this.connectionType + ", connectionState=" + this.connectionState + ", connectionUrl='" + this.connectionUrl + "', channelId=" + this.channelId + ", channelType=" + this.channelType + ", error='" + this.error + "', privateProtocol=" + this.privateProtocolEnabled + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeInt(this.connectionType);
        r10.writeInt(this.connectionState);
        r10.writeString(this.connectionUrl);
        r10.writeInt(this.channelId);
        r10.writeInt(this.channelType);
        r10.writeString(this.error);
        r10.writeInt(this.errorCode);
        r10.writeInt(this.privateProtocolEnabled ? 1 : 0);
    }
}
