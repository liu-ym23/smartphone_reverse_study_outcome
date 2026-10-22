package com.bytedance.common.wschannel.model;

import a5.b;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SsWsApp implements IWsApp, Parcelable {
    public static final Parcelable.Creator<SsWsApp> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f3999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4001c;
    public int d;
    public String e;
    public String f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4002h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f4003i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f4004j;

    static {
        CREATOR = new b(15);
    }

    public SsWsApp() {
        this.f3999a = new ArrayList();
    }

    public final JSONObject c() {
        JSONObject r5 = new JSONObject();
        r5.put(WsConstants.KEY_CHANNEL_ID, this.f4000b);
        r5.put("app_id", this.d);
        r5.put(WsConstants.KEY_DEVICE_ID, this.e);
        r5.put("install_id", this.f);
        JSONArray r10 = new JSONArray();
        ArrayList r11 = this.f3999a;
        if (r11 == null) goto L8;
        Iterator r12 = r11.iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        r10.put((String) r12.next());
    L8:
        r5.put("urls", r10);
        r5.put("app_version", this.g);
        r5.put(WsConstants.KEY_PLATFORM, this.f4002h);
        r5.put(WsConstants.KEY_FPID, this.f4003i);
        r5.put("app_kay", this.f4004j);
        r5.put("extra", this.f4001c);
        return r5;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L8;
    L60:
        return false;
    L8:
        if (getClass() != r10.getClass()) goto L60;
        SsWsApp r11 = (SsWsApp) r10;
        if (this.f4000b == r11.f4000b) goto L14;
        return false;
    L14:
        if (this.d == r11.d) goto L17;
        return false;
    L17:
        if (this.g == r11.g) goto L20;
        return false;
    L20:
        if (this.f4002h == r11.f4002h) goto L22;
        return false;
    L22:
        String r5 = this.e;
        if (r5 == null) goto L28;
        if (r5.equals(r11.e) == false) goto L29;
    L30:
        String r12 = this.f;
        if (r12 == null) goto L36;
        if (r12.equals(r11.f) == true) goto L39;
    L37:
        return false;
    L39:
        if (this.f4003i == r11.f4003i) goto L41;
        return false;
    L41:
        String r13 = this.f4004j;
        if (r13 == null) goto L47;
        if (r13.equals(r11.f4004j) == false) goto L48;
    L49:
        ArrayList r14 = this.f3999a;
        int r15 = r14.size();
        ArrayList r16 = r11.f3999a;
        if (r15 == r16.size()) goto L52;
        return false;
    L52:
        Iterator r17 = r14.iterator();
    L54:
        if (r17.hasNext() == false) goto L59;
        if (r16.contains((String) r17.next()) == true) goto L54;
        return false;
    L59:
        return com.bytedance.common.utility.b.a(this.f4001c, r11.f4001c);
    L48:
        return false;
    L47:
        if (r11.f4004j == null) goto L49;
    L36:
        if (r11.f == null) goto L39;
    L29:
        return false;
    L28:
        if (r11.e == null) goto L30;
        goto L29
    }

    public final int hashCode() {
        int r5 = ((this.d * 31) + this.f4000b) * 31;
        String r10 = this.e;
        int r11 = 0;
        if (r10 == null) goto L5;
        int r12 = r10.hashCode();
    L6:
        int r13 = (r5 + r12) * 31;
        String r14 = this.f;
        if (r14 == null) goto L9;
        int r15 = r14.hashCode();
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.f4001c;
        if (r17 == null) goto L14;
        r11 = r17.hashCode();
    L14:
        return ((((r16 + r11) * 31) + this.g) * 31) + this.f4002h;
    L9:
        r15 = 0;
        goto L10
    L5:
        r12 = 0;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r5, int r10) {
        r5.writeStringList(this.f3999a);
        r5.writeInt(this.f4000b);
        r5.writeString(this.f4001c);
        r5.writeInt(this.d);
        r5.writeString(this.e);
        r5.writeString(this.f);
        r5.writeInt(this.g);
        r5.writeInt(this.f4002h);
        r5.writeInt(this.f4003i);
        r5.writeString(this.f4004j);
    }

    public SsWsApp(Parcel r5) {
        this.f3999a = new ArrayList();
        this.f3999a = r5.createStringArrayList();
        this.f4000b = r5.readInt();
        this.f4001c = r5.readString();
        this.d = r5.readInt();
        this.e = r5.readString();
        this.f = r5.readString();
        this.g = r5.readInt();
        this.f4002h = r5.readInt();
        this.f4003i = r5.readInt();
        this.f4004j = r5.readString();
    }
}
