package com.larksuite.framework.apiplugin.common;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.larksuite.framework.apiplugin.annotation.LKIncludeWithFailData;
import com.larksuite.framework.apiplugin.entity.LKBasePluginResult;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import n18.a;
import n18.b;
import org.json.JSONException;
import org.json.JSONObject;
import q18.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@JSONType(ignores = {"success", "fail"})
public class LKBaseResponseModel extends LKBaseModel {
    private static final String API_ERR_NO = "apiErrNo";
    public static final a DEFAULT_API_ERR_CODE = null;
    private static final a DEFAULT_API_ERR_CODE_FOR_ERRNO = null;
    public static final int DEFAULT_ERROR_CODE = Integer.MIN_VALUE;
    public static final int DEFAULT_ERR_NO = 0;
    public static final String ERROR_MSG_KEY = "errMsg";
    public static final String ERROR_NO_KEY = "errno";
    public static final String ERROR_STRING_KEY = "errString";
    public static final String INNER_CODE_KEY = "innerCode";
    public static final String INNER_MSG_KEY = "innerMsg";
    public static final String KEY_NATIVE_BUFFER = "__nativeBuffers__";
    private static final String TAG = "LKBaseResponseModel";

    @JSONField(serialize = false)
    private a apiErrCode;

    @JSONField(serialize = false)
    private String customErrMsg;
    private int errNo;
    private String errString;

    @JSONField(name = KEY_NATIVE_BUFFER)
    private List<LKBasePluginResult.b.a> mArrayBuffers;

    @JSONField(name = INNER_MSG_KEY)
    public String mInnerMsg;

    @JSONField(serialize = false)
    public boolean mIsArrayBuffer;

    @JSONField(serialize = false)
    private boolean mIsCease;
    private List<String> mRemovedParams;

    @JSONField(serialize = false)
    private boolean optimizeJsonParse;

    @JSONField(serialize = false)
    private SerializeFilter serializeFilter;

    public void proceed() {
        this.mIsCease = false;
    }

    static {
        DEFAULT_API_ERR_CODE = new a(DEFAULT_ERROR_CODE, null);
        DEFAULT_API_ERR_CODE_FOR_ERRNO = new a(DEFAULT_ERROR_CODE, "please check errno");
    }

    private void copyCommonCode2errno() {
        a r0 = this.apiErrCode;
        int r1 = r0.a;
        if (r1 >= 100) goto L5;
        return;
    L5:
        if (r1 >= 999) goto L33;
        o18.a r3 = o18.a.c;
        if (r1 != 100) goto L9;
        setApiErrNo(r3);
        return;
    L9:
        o18.a r2 = o18.a.d;
        if (r1 != 101) goto L12;
        setApiErrNo(r2);
        return;
    L12:
        o18.a r4 = o18.a.e;
        if (r1 != 102) goto L15;
        setApiErrNo(r4);
        return;
    L15:
        o18.a r5 = o18.a.f;
        if (r1 != 103) goto L18;
        setApiErrNo(r5);
        return;
    L18:
        o18.a r6 = o18.a.g;
        if (r1 != 105) goto L21;
        setApiErrNo(r6);
        return;
    L21:
        o18.a r7 = o18.a.h;
        if (r1 != 106) goto L24;
        setApiErrNo(r7);
        return;
    L24:
        o18.a r8 = o18.a.i;
        if (r1 != 107) goto L27;
        setApiErrNo(r8);
        return;
    L27:
        o18.a r9 = o18.a.j;
        if (r1 != 108) goto L30;
        setApiErrNo(r9);
        return;
    L30:
        setApiErrNo(new b(r1, r0.b));
        return;
    }

    public b getApiErrNo() {
        int r0 = this.errNo;
        if (r0 != 0) goto L5;
        return null;
    L5:
        return new b(r0, this.errString);
    }

    public boolean isSuccess() {
        a r0 = this.apiErrCode;
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.a != Integer.MIN_VALUE) goto L9;
        if (this.errNo != 0) goto L9;
        return true;
    }

    public LKBaseResponseModel() {
        this.apiErrCode = DEFAULT_API_ERR_CODE;
        this.errNo = 0;
        this.errString = "";
        this.optimizeJsonParse = false;
        this.mIsCease = true;
        this.mIsArrayBuffer = false;
        this.mRemovedParams = new ArrayList();
    }

    private boolean hasExtraFailData() {
        if (getClass().getAnnotation(LKIncludeWithFailData.class) != null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isFail() {
        return !isSuccess();
    }

    public JSONObject toJSONObject() {
    L17:
        e = move-exception;
        JSONObject r1 = new JSONObject();
        Log.e(TAG, "toJSONObject error", e);
        return r1;
    L3:
        if (optimizeJsonParse() == false) goto L6;
        JSONObject r0 = r18.a.a((com.alibaba.fastjson.JSONObject) JSON.toJSON(this));     // Catch: JSONException -> L17
    L10:
        if (isFail() == true) goto L12;
        r0.remove(INNER_CODE_KEY);     // Catch: JSONException -> L17
        r0.remove(ERROR_NO_KEY);     // Catch: JSONException -> L17
        r0.remove(ERROR_STRING_KEY);     // Catch: JSONException -> L17
        return r0;
    L12:
        if (hasExtraFailData() == true) goto L21;
        r0.remove(API_ERR_NO);     // Catch: JSONException -> L17
        return r0;
    L21:
        return c.d(this);
    L6:
        if (getSerializeFilter() == null) goto L8;
        r0 = new JSONObject(JSON.toJSONString(this, getSerializeFilter(), new SerializerFeature[0]));     // Catch: JSONException -> L17
        goto L10
    L8:
        r0 = new JSONObject(JSON.toJSONString(this));     // Catch: JSONException -> L17
        goto L10
    }

    public List<String> findRemovedParams() {
        return this.mRemovedParams;
    }

    public a getApiErrCode() {
        return this.apiErrCode;
    }

    public List<LKBasePluginResult.b.a> getArrayBuffers() {
        return this.mArrayBuffers;
    }

    public String getCustomErrMsg() {
        return this.customErrMsg;
    }

    @JSONField(name = ERROR_NO_KEY)
    public int getErrNo() {
        return this.errNo;
    }

    @JSONField(name = ERROR_STRING_KEY)
    public String getErrString() {
        return this.errString;
    }

    public SerializeFilter getSerializeFilter() {
        return this.serializeFilter;
    }

    public boolean isCease() {
        return this.mIsCease;
    }

    public boolean optimizeJsonParse() {
        return this.optimizeJsonParse;
    }

    public LKBaseResponseModel(a r3) {
        this.apiErrCode = DEFAULT_API_ERR_CODE;
        this.errNo = 0;
        this.errString = "";
        this.optimizeJsonParse = false;
        this.mIsCease = true;
        this.mIsArrayBuffer = false;
        this.mRemovedParams = new ArrayList();
        Intrinsics.checkNotNull(r3);
        this.apiErrCode = r3;
        copyCommonCode2errno();
    }

    public void addArrayBuffer(LKBasePluginResult.b.a r2) {
        if (this.mArrayBuffers != null) goto L5;
        this.mArrayBuffers = new ArrayList();
    L5:
        this.mArrayBuffers.add(r2);
    }

    public void addRemovedParams(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        List<String> r0 = this.mRemovedParams;
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.contains(r2) == false) goto L11;
        return;
    L11:
        this.mRemovedParams.add(r2);
    }

    public void setApiErrCode(a r1) {
        this.apiErrCode = r1;
        copyCommonCode2errno();
    }

    public void setApiErrNo(b r2) {
        if (r2 == null) goto L7;
        this.errNo = r2.a;
        this.errString = r2.b;
        if (this.apiErrCode != DEFAULT_API_ERR_CODE) goto L8;
        this.apiErrCode = DEFAULT_API_ERR_CODE_FOR_ERRNO;
        return;
    L8:
        return;
    }

    public void setCustomErrMsg(String r1) {
        this.customErrMsg = r1;
    }

    public void setOptimizeJsonParse(boolean r1) {
        this.optimizeJsonParse = r1;
    }

    public void setSerializeFilter(SerializeFilter r1) {
        this.serializeFilter = r1;
    }
}
