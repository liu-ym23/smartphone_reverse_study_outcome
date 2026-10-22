package com.ss.android.lark.passport.signinsdk_api.account;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class SessionInfo implements Serializable, Parcelable {
    public static final Parcelable.Creator<SessionInfo> CREATOR = null;
    private String hostUrl;

    @JSONField(alternateNames = {"value", AppbrandHostConstants.SCHEMA_INSPECT.SESSION})
    private String session;

    @JSONField(alternateNames = {AppbrandHostConstants.Schema_Meta.NAME, "sessionName"})
    private String sessionName;

    public class a implements Parcelable.Creator<SessionInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SessionInfo createFromParcel(Parcel r2) {
            return new SessionInfo(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final SessionInfo[] newArray(int r1) {
            return new SessionInfo[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public SessionInfo() {
    }

    public String getHostUrl() {
        return this.hostUrl;
    }

    public String getSession() {
        return this.session;
    }

    public String getSessionName() {
        return this.sessionName;
    }

    public SessionInfo(Parcel r2) {
        this.hostUrl = r2.readString();
        this.sessionName = r2.readString();
        this.session = r2.readString();
    }

    public void setHostUrl(String r1) {
        this.hostUrl = r1;
    }

    public void setSession(String r1) {
        this.session = r1;
    }

    public void setSessionName(String r1) {
        this.sessionName = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.hostUrl);
        r1.writeString(this.sessionName);
        r1.writeString(this.session);
    }

    public SessionInfo(String r1, String r2, String r3) {
        this.hostUrl = r1;
        this.sessionName = r2;
        this.session = r3;
    }
}
