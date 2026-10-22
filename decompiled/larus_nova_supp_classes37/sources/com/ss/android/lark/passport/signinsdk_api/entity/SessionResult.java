package com.ss.android.lark.passport.signinsdk_api.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.passport.signinsdk_api.account.SessionInfo;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class SessionResult implements Serializable, Parcelable {
    public static final int CMD_SUCCESS_CODE = 0;
    public static final Parcelable.Creator<SessionResult> CREATOR = null;
    public boolean isOnboarding;
    public int responseCode;
    public String responseMessage;
    public Map<String, SessionInfo> sessionInfoMap;
    public String token;

    public class a implements Parcelable.Creator<SessionResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SessionResult createFromParcel(Parcel r2) {
            return new SessionResult(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final SessionResult[] newArray(int r1) {
            return new SessionResult[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public SessionResult() {
        this.sessionInfoMap = new HashMap();
    }

    public SessionResult(Parcel r3) {
        this.sessionInfoMap = new HashMap();
        this.token = r3.readString();
        r3.readMap(this.sessionInfoMap, SessionInfo.class.getClassLoader());
        boolean r1 = true;
        if (r3.readInt() == 1) goto L6;
        r1 = false;
    L6:
        this.isOnboarding = r1;
        this.responseCode = r3.readInt();
        this.responseMessage = r3.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.token);
        r1.writeMap(this.sessionInfoMap);
        r1.writeInt(this.isOnboarding ? 1 : 0);
        r1.writeInt(this.responseCode);
        r1.writeString(this.responseMessage);
    }

    public SessionResult(String r2, Map<String, SessionInfo> r3, int r4, String r5) {
        new HashMap();
        this.token = r2;
        this.sessionInfoMap = r3;
        this.responseCode = r4;
        this.responseMessage = r5;
        this.isOnboarding = false;
    }
}
