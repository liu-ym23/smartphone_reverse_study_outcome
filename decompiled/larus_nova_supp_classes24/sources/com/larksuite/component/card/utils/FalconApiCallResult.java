package com.larksuite.component.card.utils;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.ss.android.lark.log.Log;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class FalconApiCallResult implements Parcelable {
    public static final Parcelable.Creator<FalconApiCallResult> CREATOR = null;
    public final String a;

    public class a implements Parcelable.Creator<FalconApiCallResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FalconApiCallResult createFromParcel(Parcel r2) {
            return new FalconApiCallResult(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final FalconApiCallResult[] newArray(int r1) {
            return new FalconApiCallResult[r1];
        }
    }

    public static class b {
        public final String a;
        public final String b;
        public String c;
        public JSONObject d;
        public int e;

        public final FalconApiCallResult a() {
            JSONObject r5 = this.d;
            if (r5 != null) goto L27;
            r5 = new JSONObject();
        L27:
        L23:
            e = move-exception;
            Log.e("ApiCallResult", "build", e);
        L26:
            return new FalconApiCallResult(r5);
        L7:
            if (r5.has(LKBaseResponseModel.ERROR_MSG_KEY) == false) goto L15;
            Log.i("ApiCallResult", "has errMsg event:" + this.a);     // Catch: Exception -> L23
            String r4 = JSONObjectProtectorUtils.getString(r5, LKBaseResponseModel.ERROR_MSG_KEY);     // Catch: Exception -> L23
            if (r4.contains(this.a + ":" + this.b) == false) goto L12;
            Log.i("ApiCallResult", "success buildErrMsg");     // Catch: Exception -> L23
            boolean r6 = true;
        L16:
            if (r6 == true) goto L19;
            Log.i("ApiCallResult", "append errMsg");     // Catch: Exception -> L23
            r5.put(LKBaseResponseModel.ERROR_MSG_KEY, b(this.a, this.b, this.c));     // Catch: Exception -> L23
        L19:
            if (this.e == 0) goto L21;
            Log.i("ApiCallResult", "errCode:" + this.e);     // Catch: Exception -> L23
            r5.put("errCode", this.e);     // Catch: Exception -> L23
        L21:
            Log.i("ApiCallResult", "errMsg:" + r5.get(LKBaseResponseModel.ERROR_MSG_KEY));     // Catch: Exception -> L23
            goto L26
        L12:
            if (TextUtils.isEmpty(this.c) == false) goto L14;
            this.c = r4;     // Catch: Exception -> L23
            goto L15
        L14:
            this.c += r4;     // Catch: Exception -> L23
        L15:
            r6 = false;
            goto L16
        }

        public final String toString() {
            Log.e("ApiCallResult", "pls do not use Builder toString");
            return a().a;
        }

        public b(String r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public static String b(String r2, String r3, String r4) {
            if (TextUtils.isEmpty(r4) == false) goto L7;
            return r2 + ":" + r3;
        L7:
            return r2 + ":" + r3 + " " + r4;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final String toString() {
        return this.a;
    }

    public FalconApiCallResult(Parcel r4) {
        String r5 = r4.readString();
        if (r5 != null) goto L11;
        Log.d("ApiCallResult", "empty result");
        r5 = "";
    L11:
        new JSONObject(r5);     // Catch: JSONException -> L7
    L9:
        this.a = r5;
        r5.contains(":fail");
        return;
    L7:
        e = move-exception;
        new JSONObject();
        Log.e("ApiCallResult", r5, e);
        goto L9
    }

    public FalconApiCallResult(JSONObject r1) {
        this.a = r1.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.a);
    }
}
