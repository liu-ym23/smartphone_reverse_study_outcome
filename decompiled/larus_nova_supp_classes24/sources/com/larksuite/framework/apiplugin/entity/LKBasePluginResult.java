package com.larksuite.framework.apiplugin.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.ss.android.lark.log.Log;
import j18.k;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class LKBasePluginResult implements Parcelable {
    public static final Parcelable.Creator<LKBasePluginResult> CREATOR = null;
    public static final LKBasePluginResult f = null;
    public final boolean a;
    public final JSONObject b;
    public final k c;
    public final int d;
    public final List<b.a> e;

    public class a implements Parcelable.Creator<LKBasePluginResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LKBasePluginResult createFromParcel(Parcel r2) {
            return new LKBasePluginResult(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final LKBasePluginResult[] newArray(int r1) {
            return new LKBasePluginResult[r1];
        }
    }

    public static abstract class b<T extends b<T>> {
        public JSONObject a;
        public k b;
        public int c;
        public List<a> d;

        public static class a<T> {

            @JSONField(name = "key")
            public String a;

            @JSONField(serialize = false)
            public T b;

            @JSONField(name = "base64")
            public String c;
        }

        public b() {
            this.c = LKBaseResponseModel.DEFAULT_ERROR_CODE;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
        f = new LKBasePluginResult(false, null, null, LKBaseResponseModel.DEFAULT_ERROR_CODE, null);
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("LKBasePluginResult{mResult=");
        JSONObject r1 = this.b;
        if (r1 == null) goto L5;
        String r2 = r1.toString();
    L6:
        r0.append(r2);
        r0.append(", mErrorCode=");
        r0.append(this.d);
        r0.append('}');
        return r0.toString();
    L5:
        r2 = "";
        goto L6
    }

    public LKBasePluginResult(Parcel r3) {
        boolean r0 = false;
        this.a = false;
        this.d = LKBaseResponseModel.DEFAULT_ERROR_CODE;
        if (r3.readByte() == 0) goto L5;
        r0 = true;
    L5:
        this.a = r0;
        this.d = r3.readInt();
        String r4 = r3.readString();
        if (TextUtils.isEmpty(r4) == true) goto L14;
        this.b = new JSONObject(r4);     // Catch: JSONException -> L9
        return;
    L9:
        e = move-exception;
        Log.e("LKBasePluginResult", "JSONException", e);
        this.b = new JSONObject();
        return;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeByte(this.a ? 1 : 0);
        r1.writeInt(this.d);
        JSONObject r3 = this.b;
        if (r3 == null) goto L5;
        String r4 = r3.toString();
    L6:
        r1.writeString(r4);
        return;
    L5:
        r4 = "";
        goto L6
    }

    public LKBasePluginResult(boolean r2, JSONObject r3, k r4, int r5, List<b.a> r6) {
        this.a = false;
        this.d = LKBaseResponseModel.DEFAULT_ERROR_CODE;
        this.a = r2;
        this.b = r3;
        this.d = r5;
        this.c = r4;
        this.e = r6;
    }
}
