package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import r5.f;

/* JADX INFO: loaded from: classes.dex */
public class SsWsApp implements IWsApp, Parcelable {
    public static final Parcelable.Creator<SsWsApp> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f3891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3892b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f3893m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3894n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f3895o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f3896p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f3897q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f3898r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f3899s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f3900t;

    public static class a implements Parcelable.Creator<SsWsApp> {
        @Override // android.os.Parcelable.Creator
        public final SsWsApp createFromParcel(Parcel r8) {
            return new SsWsApp(r8);
        }

        @Override // android.os.Parcelable.Creator
        public final SsWsApp[] newArray(int r8) {
            return new SsWsApp[r8];
        }
    }

    public static class b {
        public static SsWsApp a(JSONObject r8) {
            SsWsApp r10 = new SsWsApp();
            if (r8 == null) goto L10;
            r10.f3892b = r8.optInt(WsConstants.KEY_CHANNEL_ID);
            r10.f3894n = r8.optInt("app_id");
            r10.f3895o = r8.optString("device_id");
            r10.f3896p = r8.optString("install_id");
            r10.f3897q = r8.optInt("app_version");
            r10.f3898r = r8.optInt(WsConstants.KEY_PLATFORM);
            r10.f3899s = r8.optInt(WsConstants.KEY_FPID);
            r10.f3900t = r8.optString("app_kay");
            r10.f3893m = r8.optString(WsConstants.KEY_EXTRA);
            JSONArray r11 = r8.optJSONArray("urls");
            ArrayList r12 = r10.f3891a;
            r12.clear();
            if (r11 == null) goto L10;
            int r13 = r11.length();
            int r14 = 0;
        L8:
            if (r14 >= r13) goto L10;
            r12.add(r11.optString(r14));
            r14 = r14 + 1;
        L10:
            return r10;
        }
    }

    static {
        CREATOR = new a();
    }

    public SsWsApp() {
        this.f3891a = new ArrayList();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 != null) goto L8;
    L60:
        return false;
    L8:
        if (getClass() != r8.getClass()) goto L60;
        SsWsApp r10 = (SsWsApp) r8;
        if (this.f3892b == r10.f3892b) goto L14;
        return false;
    L14:
        if (this.f3894n == r10.f3894n) goto L17;
        return false;
    L17:
        if (this.f3897q == r10.f3897q) goto L20;
        return false;
    L20:
        if (this.f3898r == r10.f3898r) goto L22;
        return false;
    L22:
        String r11 = this.f3895o;
        if (r11 == null) goto L28;
        if (r11.equals(r10.f3895o) == false) goto L29;
    L30:
        String r12 = this.f3896p;
        if (r12 == null) goto L36;
        if (r12.equals(r10.f3896p) == true) goto L39;
    L37:
        return false;
    L39:
        if (this.f3899s == r10.f3899s) goto L41;
        return false;
    L41:
        String r13 = this.f3900t;
        if (r13 == null) goto L47;
        if (r13.equals(r10.f3900t) == false) goto L48;
    L49:
        ArrayList r14 = this.f3891a;
        int r15 = r14.size();
        ArrayList r16 = r10.f3891a;
        if (r15 == r16.size()) goto L52;
        return false;
    L52:
        Iterator r17 = r14.iterator();
    L54:
        if (r17.hasNext() == false) goto L59;
        if (r16.contains((String) r17.next()) == true) goto L54;
        return false;
    L59:
        return f.a(this.f3893m, r10.f3893m);
    L48:
        return false;
    L47:
        if (r10.f3900t == null) goto L49;
    L36:
        if (r10.f3896p == null) goto L39;
    L29:
        return false;
    L28:
        if (r10.f3895o == null) goto L30;
        goto L29
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public final int getAppId() {
        return this.f3894n;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public final String getDeviceId() {
        return this.f3895o;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public final String getExtra() {
        return this.f3893m;
    }

    public final int hashCode() {
        int r8 = ((this.f3894n * 31) + this.f3892b) * 31;
        String r10 = this.f3895o;
        int r11 = 0;
        if (r10 == null) goto L5;
        int r12 = r10.hashCode();
    L6:
        int r13 = (r8 + r12) * 31;
        String r14 = this.f3896p;
        if (r14 == null) goto L9;
        int r15 = r14.hashCode();
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.f3893m;
        if (r17 == null) goto L14;
        r11 = r17.hashCode();
    L14:
        return ((((r16 + r11) * 31) + this.f3897q) * 31) + this.f3898r;
    L9:
        r15 = 0;
        goto L10
    L5:
        r12 = 0;
        goto L6
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public final String j() {
        return this.f3896p;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public final int k() {
        return this.f3892b;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public final JSONObject l() {
        JSONObject r8 = new JSONObject();
        r8.put(WsConstants.KEY_CHANNEL_ID, this.f3892b);
        r8.put("app_id", this.f3894n);
        r8.put("device_id", this.f3895o);
        r8.put("install_id", this.f3896p);
        JSONArray r10 = new JSONArray();
        ArrayList r11 = this.f3891a;
        if (r11 == null) goto L8;
        Iterator r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        r10.put((String) r12.next());
    L8:
        r8.put("urls", r10);
        r8.put("app_version", this.f3897q);
        r8.put(WsConstants.KEY_PLATFORM, this.f3898r);
        r8.put(WsConstants.KEY_FPID, this.f3899s);
        r8.put("app_kay", this.f3900t);
        r8.put(WsConstants.KEY_EXTRA, this.f3893m);
        return r8;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public final int m() {
        return this.f3898r;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public final String n() {
        return this.f3900t;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public final int o() {
        return this.f3897q;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public final int q() {
        return this.f3899s;
    }

    @Override // com.bytedance.common.wschannel.app.IWsApp
    public final List<String> s() {
        return this.f3891a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        r8.writeStringList(this.f3891a);
        r8.writeInt(this.f3892b);
        r8.writeString(this.f3893m);
        r8.writeInt(this.f3894n);
        r8.writeString(this.f3895o);
        r8.writeString(this.f3896p);
        r8.writeInt(this.f3897q);
        r8.writeInt(this.f3898r);
        r8.writeInt(this.f3899s);
        r8.writeString(this.f3900t);
    }

    public SsWsApp(Parcel r8) {
        this.f3891a = new ArrayList();
        this.f3891a = r8.createStringArrayList();
        this.f3892b = r8.readInt();
        this.f3893m = r8.readString();
        this.f3894n = r8.readInt();
        this.f3895o = r8.readString();
        this.f3896p = r8.readString();
        this.f3897q = r8.readInt();
        this.f3898r = r8.readInt();
        this.f3899s = r8.readInt();
        this.f3900t = r8.readString();
    }
}
