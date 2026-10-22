package com.bytedance.common.wschannel.model;

import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class WsComponent implements Parcelable {
    public static final Parcelable.Creator<WsComponent> CREATOR = null;
    List<WsApi> acceptApis;
    ComponentName componentName;

    static class a implements Parcelable.Creator<WsComponent> {
        a() {
        }

        public WsComponent a(Parcel r10) {
            WsComponent r11 = new WsComponent();
            r11.componentName = (ComponentName) r10.readParcelable(a.class.getClassLoader());
            r11.acceptApis = r10.createTypedArrayList(WsApi.CREATOR);
            return r11;
        }

        public WsComponent[] b(int r10) {
            return new WsComponent[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WsComponent createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WsComponent[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a();
    }

    public WsComponent() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<WsApi> getAcceptApis() {
        return this.acceptApis;
    }

    public ComponentName getComponentName() {
        return this.componentName;
    }

    public void parseFromJson(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        String r11 = r10.optString("package_name");
        String r12 = r10.optString("class_name");
        if (TextUtils.isEmpty(r11) == false) goto L7;
    L9:
        JSONArray r13 = r10.optJSONArray("accept_services");
        if (r13 == null) goto L14;
        this.acceptApis = new ArrayList();
        int r14 = r13.length();
        int r15 = 0;
    L12:
        if (r15 >= r14) goto L16;
        WsApi r16 = new WsApi();
        r16.parseFromJson(r13.optJSONObject(r15));
        this.acceptApis.add(r16);
        r15 = r15 + 1;
        goto L12
    L16:
        return;
    L14:
        return;
    L7:
        if (TextUtils.isEmpty(r12) == true) goto L9;
        this.componentName = new ComponentName(r11, r12);
        goto L9
    }

    public void setAcceptApis(List<WsApi> r10) {
        this.acceptApis = r10;
    }

    public void setComponentName(ComponentName r10) {
        this.componentName = r10;
    }

    public JSONObject toJson() {
        JSONObject r10 = new JSONObject();
        ComponentName r11 = this.componentName;
        if (r11 == null) goto L5;
        r10.put("package_name", r11.getPackageName());
        r10.put("class_name", this.componentName.getClassName());
    L5:
        List<WsApi> r12 = this.acceptApis;
        if (r12 != null) goto L8;
    L14:
        return r10;
    L8:
        if (r12.size() <= 0) goto L14;
        JSONArray r13 = new JSONArray();
        Iterator<WsApi> r14 = this.acceptApis.iterator();
    L11:
        if (r14.hasNext() == false) goto L13;
        r13.put(r14.next().toJson());
        goto L11
    L13:
        r10.put("accept_services", r13);
        goto L14
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeParcelable(this.componentName, r11);
        r10.writeTypedList(this.acceptApis);
    }
}
