package com.bytedance.common.wschannel.model;

import a5.b;
import ai.j0;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.common.wschannel.WsConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SocketState implements Parcelable {
    public static final Parcelable.Creator<SocketState> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3998c;
    public int d;
    public int e;
    public String f;
    public int g;

    static {
        CREATOR = new b(14);
    }

    public static SocketState c(JSONObject r5) {
        SocketState r10 = new SocketState();
        r10.d = r5.optInt(WsConstants.KEY_CHANNEL_ID, Integer.MIN_VALUE);
        r10.f3996a = r5.optInt("type", -1);
        r10.f3997b = r5.optInt("state", -1);
        r10.f3998c = r5.optString("url", "");
        r10.e = r5.optInt(WsConstants.KEY_CHANNEL_TYPE);
        r10.f = r5.optString("error", "");
        r10.g = r5.optInt(WsConstants.ERROR_CODE);
        return r10;
    }

    public final void d() {
        JSONObject r5 = new JSONObject();
        r5.put(WsConstants.KEY_CHANNEL_ID, this.d);     // Catch: JSONException -> L5
        r5.put("type", this.f3996a);     // Catch: JSONException -> L5
        r5.put("state", this.f3997b);     // Catch: JSONException -> L5
        r5.put("url", this.f3998c);     // Catch: JSONException -> L5
        r5.put(WsConstants.KEY_CHANNEL_TYPE, this.e);     // Catch: JSONException -> L5
        r5.put("error", this.f);     // Catch: JSONException -> L5
        r5.put(WsConstants.ERROR_CODE, this.g);     // Catch: JSONException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("SocketState{connectionType=");
        r5.append(this.f3996a);
        r5.append(", connectionState=");
        r5.append(this.f3997b);
        r5.append(", connectionUrl='");
        r5.append(this.f3998c);
        r5.append("', channelId=");
        r5.append(this.d);
        r5.append(", channelType=");
        r5.append(this.e);
        r5.append(", error='");
        return j0.q(r5, this.f, "'}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r10) {
        r5.writeInt(this.f3996a);
        r5.writeInt(this.f3997b);
        r5.writeString(this.f3998c);
        r5.writeInt(this.d);
        r5.writeInt(this.e);
        r5.writeString(this.f);
        r5.writeInt(this.g);
    }
}
