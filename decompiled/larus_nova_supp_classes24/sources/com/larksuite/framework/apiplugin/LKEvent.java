package com.larksuite.framework.apiplugin;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.larksuite.framework.apiplugin.annotation.LKIncludeWithFailData;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larksuite.framework.apiplugin.entity.LKBasePluginResult;
import com.larksuite.framework.apiplugin.entity.LKPluginHandleResult;
import com.ss.android.lark.log.Log;
import j18.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class LKEvent implements Parcelable {
    public static final Parcelable.Creator<LKEvent> CREATOR = null;
    public final String a;
    public JSONObject b;
    public j18.b c;
    public final int d;
    public Context e;
    public final JSONObject f;
    public c g;
    public Object h;
    public final Map<String, Object> i;
    public i18.c j;
    public j18.a k;
    public final EventSourceEnv l;
    public final p18.b m;
    public final boolean n;
    public final Bundle o;

    public static final enum EventSourceEnv extends Enum<EventSourceEnv> {
        public static final EventSourceEnv APP_ENV = null;
        public static final EventSourceEnv BIZ_ENV = null;
        public static final /* synthetic */ EventSourceEnv[] a = null;

        static {
            EventSourceEnv r0 = new EventSourceEnv("APP_ENV", 0);
            APP_ENV = r0;
            EventSourceEnv r1 = new EventSourceEnv("BIZ_ENV", 1);
            BIZ_ENV = r1;
            a = new EventSourceEnv[]{r0, r1};
        }

        public static EventSourceEnv[] values() {
            return (EventSourceEnv[]) a.clone();
        }

        public static EventSourceEnv valueOf(String r1) {
            return (EventSourceEnv) r27.a.a(EventSourceEnv.class, r1);
        }

        public EventSourceEnv(String r1, int r2) {
            super(r1, r2);
        }
    }

    public class a implements Parcelable.Creator<LKEvent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LKEvent createFromParcel(Parcel r2) {
            return new LKEvent(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final LKEvent[] newArray(int r1) {
            return new LKEvent[r1];
        }
    }

    public static class b {
        public String a;
        public JSONObject b;
        public Context c;
        public boolean d;

        public b() {
            this.d = false;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final hyb.a c() {
        p18.b r0 = this.m;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.b;
    }

    public Context getContext() {
        return this.e;
    }

    public LKEvent(Parcel r4) {
        boolean r1 = false;
        this.n = false;
        this.a = r4.readString();
        this.d = r4.readInt();
        if (r4.readByte() == 0) goto L5;
        r1 = true;
    L5:
        this.n = r1;
        String r2 = r4.readString();
        if (TextUtils.isEmpty(r2) == true) goto L10;
        Object r3 = JSON.parse(r2);
        if ((r3 instanceof Map) == false) goto L10;
        this.i = (Map) r3;
    L10:
        Serializable r5 = r4.readSerializable();
        if ((r5 instanceof EventSourceEnv) == false) goto L13;
        this.l = (EventSourceEnv) r5;
    L13:
        this.m = new p18.b();
        String r6 = r4.readString();
    L18:
        e = move-exception;
        Log.e("LKEvent", "JSONException", e);
    L21:
        if (this.b != null) goto L23;
        this.b = new JSONObject();
        Log.i("LKEvent", "event params is empty!");
    L23:
        this.o = r4.readBundle(getClass().getClassLoader());
        return;
    L15:
        if (TextUtils.isEmpty(r6) == true) goto L21;
        this.b = new JSONObject(r6);     // Catch: JSONException -> L18
        goto L21
    }

    public final void a(JSONObject r8) {
        JSONObject r0 = this.f;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.length() <= 0) goto L29;
        if (r8 != null) goto L8;
        r8 = new JSONObject();
    L8:
        Iterator<String> r1 = this.f.keys();
    L10:
        if (r1.hasNext() == false) goto L30;
        String r2 = r1.next();
        r8.put(r2, this.f.get(r2));     // Catch: JSONException -> L14
    L14:
        e = move-exception;
        hyb.a r3 = c();
        if (r3 != null) goto L17;
        Log.e("LKEvent", "JSONException", e);
        goto L10
    L17:
        r3.e("LKEvent", new Object[]{"JSONException", e});
        goto L10
    L30:
        return;
    }

    public final void b(Object r15) {
        if (r15 == null) goto L89;
        JSONObject r4 = new JSONObject();
        k18.a r7 = k18.a.c;     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        r4.put(LKBaseResponseModel.ERROR_MSG_KEY, "internal error");     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        if ((r15 instanceof LKBaseResponseModel) == false) goto L59;
        LKBaseResponseModel r8 = (LKBaseResponseModel) r15;     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        if (r8.optimizeJsonParse() == false) goto L11;
        JSONObject r9 = r18.a.a((com.alibaba.fastjson.JSONObject) JSON.toJSON(r8));     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
    L14:
        r18.b.a(r9, (LKBaseResponseModel) r15);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        r9.put(LKBaseResponseModel.ERROR_MSG_KEY, r18.b.c(r8));     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        if (r8.mIsArrayBuffer == true) goto L17;
    L19:
        boolean r0 = false;
    L21:
        if (r0 == false) goto L39;
        LKPluginHandleResult.a r1 = new LKPluginHandleResult.a();     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        if (r8.isFail() == true) goto L25;
    L31:
        r1.a = r9;     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        r1.e = r8.isCease();     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        List<LKBasePluginResult.b.a> r16 = r8.getArrayBuffers();     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        if (r1.d != null) goto L34;
        r1.d = new ArrayList();     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
    L34:
        ((ArrayList) r1.d).addAll(r16);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        if (r8.isFail() == false) goto L98;
        r1.c = r8.getApiErrCode().a;     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
    L98:
        return;
    L25:
        if (((LKBaseResponseModel) r15).getClass().getAnnotation(LKIncludeWithFailData.class) != null) goto L27;
        boolean r17 = true;
    L28:
        if (r17 == false) goto L30;
        r9 = q18.c.d(r8);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        goto L31
    L30:
        r9.remove("apiErrNo");     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        goto L31
    L27:
        r17 = false;
        goto L28
    L39:
        if (r8.isFail() == false) goto L55;
        hyb.a r2 = c();     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        if (r2 == null) goto L44;
        ((p18.b.a) r2).i("LKEvent", new Object[]{"errorCode:" + r8.getApiErrCode() + " eventName:" + this.a});     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
    L46:
        if (((LKBaseResponseModel) r15).getClass().getAnnotation(LKIncludeWithFailData.class) != null) goto L48;
        boolean r19 = true;
    L49:
        if (r19 == false) goto L51;
        r9 = q18.c.d(r8);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
    L52:
        int r110 = r8.getApiErrCode().a;     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        if (this.g == null) goto L99;
        a(r9);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        this.g.onFail(r110, r9);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        return;
    L99:
        return;
    L51:
        r9.remove("apiErrNo");     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        goto L52
    L48:
        r19 = false;
        goto L49
    L44:
        Log.i("LKEvent", "errorCode:" + r8.getApiErrCode() + " eventName:" + this.a);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        goto L46
    L55:
        r9.remove(LKBaseResponseModel.INNER_CODE_KEY);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        r9.remove(LKBaseResponseModel.ERROR_NO_KEY);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        r9.remove(LKBaseResponseModel.ERROR_STRING_KEY);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        if (this.g == null) goto L101;
        a(r9);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        this.g.onSuccess(r9);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        return;
    L101:
        return;
    L17:
        if (r8.getArrayBuffers() == null) goto L19;
        r0 = true;
        goto L21
    L11:
        if (r8.getSerializeFilter() == null) goto L13;
        r9 = new JSONObject(JSON.toJSONString(r8, r8.getSerializeFilter(), new SerializerFeature[0]));     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        goto L14
    L13:
        r9 = new JSONObject(JSON.toJSONString(r8));     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        goto L14
    L59:
        if ((r15 instanceof JSONObject) == false) goto L62;
        JSONObject r111 = (JSONObject) r15;     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
    L70:
        if (this.g == null) goto L103;
        a(r111);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        this.g.onSuccess(r111);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
        return;
    L103:
        return;
    L62:
        if ((r15 instanceof Map) == false) goto L66;
        JSONObject r3 = new JSONObject((Map) r15);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
    L64:
        r111 = r3;
        goto L70
    L66:
        if ((r15 instanceof String) == false) goto L68;
        r15 = JSON.parseObject((String) r15);     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
    L68:
        r3 = new JSONObject(JSON.toJSONString(r15));     // Catch: com.alibaba.fastjson.JSONException -> L73 JSONException -> L81
    L73:
        e = move-exception;
        hyb.a r5 = c();
        if (r5 == null) goto L77;
        ((p18.b.a) r5).e("LKEvent", new Object[]{"fast JSONException", e});
    L78:
        k18.a r112 = k18.a.c;
        if (this.g == null) goto L104;
        a(r4);
        this.g.onFail(102, r4);
        return;
    L104:
        return;
    L77:
        Log.e("LKEvent", "fast JSONException", e);
    L81:
        e = move-exception;
        hyb.a r6 = c();
        if (r6 == null) goto L85;
        ((p18.b.a) r6).e("LKEvent", new Object[]{"JSONException", e});
    L86:
        k18.a r113 = k18.a.c;
        if (this.g == null) goto L106;
        a(r4);
        this.g.onFail(102, r4);
        return;
    L106:
        return;
    L85:
        Log.e("LKEvent", "JSONException", e);
        goto L86
    L89:
        hyb.a r114 = c();
        if (r114 == null) goto L92;
        ((p18.b.a) r114).i("LKEvent", new Object[]{"result is null"});
    L93:
        JSONObject r115 = new JSONObject();
        if (this.g == null) goto L108;
        a(r115);
        this.g.onSuccess(r115);
        return;
    L108:
        return;
    L92:
        Log.i("LKEvent", "result is null");
        goto L93
    }

    public final void e(j18.b r5) {
        this.c = r5;
        if (r5 == null) goto L7;
        this.j = r5.getBridgeContext();
        if (this.e != null) goto L7;
        this.e = this.c.getContext();
    L7:
        hyb.a r6 = c();
        if (r6 == null) goto L10;
        r6.d("LKEvent", new Object[]{"setSourceNode"});
        return;
    L10:
        Log.d("LKEvent", "setSourceNode");
    }

    public LKEvent(b r2) {
        this.n = false;
        this.n = r2.d;
        this.m = new p18.b();
        this.f = new JSONObject();
        this.a = r2.a;
        this.b = r2.b;
        this.e = r2.c;
        this.d = -1;
        this.d = new Random().nextInt();
        this.i = new HashMap();
        new HashMap();
        e(null);
        this.o = null;
    }

    public static LKPluginHandleResult d(int r1, JSONObject r2) {
        LKPluginHandleResult.a r0 = new LKPluginHandleResult.a();
        r0.a = r2;
        r0.c = r1;
        r0.e = true;
        return new LKPluginHandleResult(r0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        r2.writeString(this.a);
        r2.writeInt(this.d);
        r2.writeByte(this.n ? 1 : 0);
        Map<String, Object> r4 = this.i;
        String r0 = "";
        if (r4 == null) goto L5;
        String r5 = JSON.toJSONString(r4);
    L6:
        r2.writeString(r5);
        r2.writeSerializable(this.l);
        JSONObject r6 = this.b;
        if (r6 == null) goto L9;
        r0 = r6.toString();
    L9:
        r2.writeString(r0);
        r2.writeBundle(this.o);
        return;
    L5:
        r5 = "";
        goto L6
    }
}
