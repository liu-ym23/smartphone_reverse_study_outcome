package com.lynx.tasm;

import android.text.TextUtils;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.xelement.overlay.LynxUIOverlay;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxError extends a0 {
    public static final int JAVA_ERROR = -3;
    public static final int JS_ERROR = -2;
    public static final String LEVEL_ERROR = "error";
    public static final String LEVEL_WARN = "warn";
    static final String LYNX_ERROR_KEY_CONTEXT = "context";
    public static final String LYNX_ERROR_KEY_IMAGE_CATEGORIZED_CODE = "image_categorized_code";
    static final String LYNX_ERROR_KEY_PREFIX_CONTEXT = "lynx_context_";
    public static final String LYNX_ERROR_KEY_RESOURCE_TYPE = "type";
    public static final String LYNX_ERROR_KEY_RESOURCE_URL = "src";
    public static final String LYNX_ERROR_SUGGESTION_REF_OFFICIAL_SITE = "Please refer to the solution in Doc 'LynxError FAQ' on the official website.";
    public static final String LYNX_THROWABLE = "throwable";
    public static final int NATIVE_ERROR = -1;
    private static final String TAG = "LynxError";
    private JSONObject errorObj;
    private String mCallStack;
    private String mCardVersion;
    private List<LynxSubErrorCode$Consumer> mConsumers;
    private Map<String, Object> mCustomInfo;
    private int mErrorType;
    private String mFixSuggestion;
    private boolean mIsLogBoxOnly;
    private boolean mIsNewErrorCode;
    private String mJsonStringCache;
    private String mLevel;
    private String mRootCause;
    private int mSubCode;
    private String mSummaryMessage;
    private String mTemplateUrl;
    private JSONObject mUserDefineInfo;
    private String msg;

    private String generateJsonString() {
        JSONObject r0 = new JSONObject();
        r0.put("error_code", getErrorCode());     // Catch: JSONException -> L10
        r0.put("sub_code", this.mSubCode);     // Catch: JSONException -> L10
        putStringToJsonObject(r0, LynxEventReporter.PROP_NAME_URL, this.mTemplateUrl);     // Catch: JSONException -> L10
        putStringToJsonObject(r0, "error", this.mSummaryMessage);     // Catch: JSONException -> L10
        putStringToJsonObject(r0, "card_version", this.mCardVersion);     // Catch: JSONException -> L10
        putStringToJsonObject(r0, "sdk", LynxEnv.inst().getLynxVersion());     // Catch: JSONException -> L10
        putStringToJsonObject(r0, LynxUIOverlay.PROP_LEVEL, this.mLevel);     // Catch: JSONException -> L10
        r0.put("consumers", new JSONArray(this.mConsumers));     // Catch: JSONException -> L10
        putStringToJsonObject(r0, "fix_suggestion", this.mFixSuggestion);     // Catch: JSONException -> L10
        putStringToJsonObject(r0, "error_stack", this.mCallStack);     // Catch: JSONException -> L10
        putStringToJsonObject(r0, "root_cause", this.mRootCause);     // Catch: JSONException -> L10
        putMapValueToJsonObject(r0, this.mCustomInfo);     // Catch: JSONException -> L10
        JSONObject r1 = this.mUserDefineInfo;     // Catch: JSONException -> L10
        if (r1 != null) goto L6;
    L8:
        String r2 = r0.toString();     // Catch: JSONException -> L10
    L12:
        if (r2 != null) goto L17;
        return NameKeys.UnloadStrategy_No_Strategy;
    L17:
        return r2;
    L6:
        if (r1.length() <= 0) goto L8;
        r0.put("user_define_info", this.mUserDefineInfo);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        LLog.e(TAG, e.getMessage());
        r2 = null;
        goto L12
    }

    public Map<String, String> getContextInfo() {
        HashMap r0 = new HashMap();
        Map<String, Object> r1 = this.mCustomInfo;
        if (r1 != null) goto L5;
        return r0;
    L5:
        Iterator<Map.Entry<String, Object>> r2 = r1.entrySet().iterator();
    L7:
        if (r2.hasNext() == false) goto L14;
        Map.Entry<String, Object> r3 = r2.next();
        String r4 = r3.getKey();
        if (r4.startsWith(LYNX_ERROR_KEY_PREFIX_CONTEXT) == true) goto L10;
        if (r4.equals(LYNX_ERROR_KEY_RESOURCE_URL) == false) goto L7;
        r0.put(r4, r3.getValue().toString());
        goto L7
    L10:
        r0.put(r4.substring(13), r3.getValue().toString());
        goto L7
    L14:
        return r0;
    }

    public int getErrorCode() {
        if (this.mIsNewErrorCode == false) goto L7;
        return this.mSubCode / 100;
    L7:
        return this.mSubCode;
    }

    public String getFixSuggestion() {
        String r0 = this.mFixSuggestion;
        if (r0 != null) goto L6;
        return NameKeys.UnloadStrategy_No_Strategy;
    L6:
        return r0;
    }

    public String getMsg() {
        if (TextUtils.isEmpty(this.mJsonStringCache) == true) goto L7;
        return this.mJsonStringCache;
    L7:
        if (TextUtils.isEmpty(this.mSummaryMessage) == true) goto L9;
        this.mJsonStringCache = generateJsonString();
    L15:
        String r0 = this.mJsonStringCache;
        if (r0 != null) goto L19;
        return NameKeys.UnloadStrategy_No_Strategy;
    L19:
        return r0;
    L9:
        JSONObject r1 = this.errorObj;
        if (r1 == null) goto L12;
        this.mJsonStringCache = r1.toString();
        goto L15
    L12:
        String r2 = this.msg;
        if (r2 == null) goto L15;
        this.mJsonStringCache = r2;
        goto L15
    }

    public String getRootCause() {
        String r0 = this.mRootCause;
        if (r0 != null) goto L6;
        return NameKeys.UnloadStrategy_No_Strategy;
    L6:
        return r0;
    }

    public String getSummaryMessage() {
        String r0 = this.mSummaryMessage;
        if (r0 != null) goto L6;
        return NameKeys.UnloadStrategy_No_Strategy;
    L6:
        return r0;
    }

    public boolean isFatal() {
        if (this.mLevel != LynxSubErrorCode$Level.FATAL.value) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isValid() {
        if (TextUtils.isEmpty(this.msg) == true) goto L5;
        return true;
    L5:
        if (this.errorObj == null) goto L7;
        return true;
    L7:
        if (TextUtils.isEmpty(this.mSummaryMessage) == false) goto L14;
        return false;
    L14:
        return true;
    }

    public String toString() {
        return "{\"code\": " + getErrorCode() + ",\"msg\":" + getMsg() + "}";
    }

    public boolean isJSError() {
        int r0 = getErrorCode();
        if (r0 >= 200) goto L5;
    L7:
        return false;
    L5:
        if (r0 >= 300) goto L7;
        return true;
    }

    public boolean isLepusError() {
        int r0 = getErrorCode();
        if (r0 >= 1100) goto L5;
    L7:
        return false;
    L5:
        if (r0 >= 1200) goto L7;
        return true;
    }

    public JSONObject getErrorObj() {
        return this.errorObj;
    }

    public String getLevel() {
        return this.mLevel;
    }

    public int getSubCode() {
        return this.mSubCode;
    }

    public int getType() {
        return this.mErrorType;
    }

    public boolean isLogBoxOnly() {
        return this.mIsLogBoxOnly;
    }

    public boolean containsCustomField(String r2) {
        if (this.mCustomInfo != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r2) == false) goto L8;
        return false;
    L8:
        return this.mCustomInfo.containsKey(r2);
    }

    public void setCallStack(String r2) {
        this.mJsonStringCache = null;
        this.mCallStack = r2;
    }

    public void setCardVersion(String r2) {
        this.mJsonStringCache = null;
        this.mCardVersion = r2;
    }

    public void setCustomInfo(Map<String, Object> r2) {
        this.mJsonStringCache = null;
        this.mCustomInfo = r2;
    }

    public void setLogBoxOnly(boolean r1) {
        this.mIsLogBoxOnly = r1;
    }

    public void setRootCause(String r2) {
        this.mJsonStringCache = null;
        this.mRootCause = r2;
    }

    public void setTemplateUrl(String r2) {
        this.mJsonStringCache = null;
        this.mTemplateUrl = r2;
    }

    public void setUserDefineInfo(JSONObject r2) {
        this.mJsonStringCache = null;
        this.mUserDefineInfo = r2;
    }

    public LynxError(String r2, int r3) {
        this.mIsLogBoxOnly = false;
        this.mIsNewErrorCode = false;
        this.mSubCode = r3;
        this.msg = r2;
    }

    public static void putMapValueToJsonObject(JSONObject r4, Map<String, Object> r5) throws JSONException {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.isEmpty() == true) goto L25;
        if (r4 == null) goto L27;
        JSONObject r0 = new JSONObject();
        Iterator<Map.Entry<String, Object>> r6 = r5.entrySet().iterator();
    L9:
        if (r6.hasNext() == false) goto L15;
        Map.Entry<String, Object> r1 = r6.next();
        if (r1.getKey().startsWith(LYNX_ERROR_KEY_PREFIX_CONTEXT) == true) goto L12;
        r4.put(r1.getKey(), r1.getValue());
        goto L9
    L12:
        r0.put(r1.getKey(), r1.getValue());
        goto L9
    L15:
        if (r0.length() <= 0) goto L26;
        r4.put(LYNX_ERROR_KEY_CONTEXT, r0);
        return;
    L26:
        return;
    L27:
        return;
    }

    public void addCustomInfo(String r2, String r3) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L13;
        this.mJsonStringCache = null;
        if (this.mCustomInfo != null) goto L10;
        this.mCustomInfo = new HashMap();
    L10:
        this.mCustomInfo.put(r2, r3);
        return;
    }

    public LynxError(int r3, String r4) {
        this(r3, r4, NameKeys.UnloadStrategy_No_Strategy, LynxSubErrorCode$Level.ERROR.value);
    }

    public static void putStringToJsonObject(JSONObject r1, String r2, String r3) throws JSONException {
        if (r1 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r2) == true) goto L11;
        r1.put(r2, r3);
        return;
    }

    public LynxError(int r7, String r8, String r9, String r10) {
        this(r7, r8, r9, r10, -3);
    }

    public LynxError(int r8, String r9, String r10, String r11, int r12) {
        this(r8, r9, r10, r11, r12, null);
    }

    public LynxError(int r9, String r10, String r11, String r12, int r13, Map<String, Object> r14) {
        this(r9, r10, r11, r12, r13, r14, false);
    }

    private static LynxError createLynxError(int r9, String r10, String r11, String r12, JavaOnlyMap r13, boolean r14) {
        return new LynxError(r9, r10, r11, r12, -1, r13, r14);
    }

    public LynxError(int r3, String r4, String r5, String r6, int r7, Map<String, Object> r8, boolean r9) {
        this.mIsNewErrorCode = false;
        this.msg = NameKeys.UnloadStrategy_No_Strategy;
        this.mSubCode = r3;
        this.mSummaryMessage = r4;
        this.mErrorType = r7;
        this.mCustomInfo = r8;
        this.mIsLogBoxOnly = r9;
        if (r3 != 0) goto L5;
    L127:
        x0 r10 = new x0(LynxSubErrorCode$Level.ERROR, NameKeys.UnloadStrategy_No_Strategy, Arrays.asList(new LynxSubErrorCode$Consumer[0]));
    L128:
        if (r10 == null) goto L137;
        LynxSubErrorCode$Level r11 = r10.a;
        if (r11 == LynxSubErrorCode$Level.UNDECIDED) goto L132;
        r6 = r11.value;
    L132:
        this.mLevel = r6;
        if (r10.b.isEmpty() == true) goto L136;
        r5 = r10.b;
    L136:
        this.mFixSuggestion = r5;
        this.mConsumers = r10.c;
        this.mIsNewErrorCode = true;
        return;
    L137:
        this.mLevel = r6;
        this.mFixSuggestion = r5;
        this.mConsumers = Collections.emptyList();
        return;
    L5:
        if (r3 != 30301) goto L7;
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please check whether the url of the external resource is available", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L7:
        if (r3 == 30302) goto L125;
        if (r3 == 0) goto L127;
        switch(r3) {
            case 0: goto L127;
            case 10299: goto L124;
            case 10501: goto L123;
            case 10701: goto L122;
            case 20201: goto L121;
            case 20301: goto L120;
            case 20401: goto L119;
            case 30196: goto L118;
            case 30400: goto L117;
            case 39800: goto L116;
            case 39900: goto L115;
            case 40199: goto L114;
            case 50201: goto L113;
            case 60100: goto L112;
            case 60201: goto L111;
            case 60301: goto L110;
            case 60401: goto L109;
            case 90801: goto L108;
            case 99800: goto L107;
            case 99900: goto L106;
            case 109900: goto L105;
            case 110100: goto L104;
            case 130300: goto L103;
            case 140201: goto L102;
            case 140401: goto L101;
            case 190100: goto L100;
            case 190200: goto L99;
            case 190300: goto L98;
            case 200101: goto L97;
            case 220101: goto L96;
            case 220301: goto L95;
            case 229800: goto L94;
            case 990100: goto L93;
            case 990200: goto L92;
            default: goto L12;
        };
    L92:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "This error is caught by Lynx engine. Please file an issue to Lynx for help.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L93:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "This error is caught by Lynx engine. Please file an issue to Lynx for help.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L94:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, NameKeys.UnloadStrategy_No_Strategy, Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L95:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "This may be due to platform-specific limitations or system restrictions. If blur-radius is not supported on this platform, consider using CSS filter: blur() as an alternative.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L96:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, NameKeys.UnloadStrategy_No_Strategy, Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.FRONT_END}));
        goto L128
    L97:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, NameKeys.UnloadStrategy_No_Strategy, Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L98:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Make sure you have imported worklet file correctly.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L99:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Calling requestAnimationFrame failed. This is usually caused by an error in the callback function. Please ensure that the callback function executes without errors.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L100:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, NameKeys.UnloadStrategy_No_Strategy, Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L101:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "The used app bundle and injected data to hydrate the SSR page should be the same as ones used to render on the server side", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L102:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, NameKeys.UnloadStrategy_No_Strategy, Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L103:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please use values following the property definitions. You can get the definitions at the official website.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L104:
        r10 = new x0(LynxSubErrorCode$Level.UNDECIDED, NameKeys.UnloadStrategy_No_Strategy, Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L105:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "This error is caught by the Lynx Engine. Please file an issue to Lynx to help address it.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.LYNX}));
        goto L128
    L106:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "This error indicates an unhandled runtime exception within the native module implementation. Please refer to the module error handling guide or contact the module maintainer with complete error context.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.CLIENT}));
        goto L128
    L107:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "This error is explicitly defined by the native module implementation. Please refer to the module error handling guide or contact the module maintainer with complete error context.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.CLIENT}));
        goto L128
    L108:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Check if the server's response body is correct; Check if client unexpectedly consumes http response body using network request interceptor; You can use request's url and log id to track down the problem.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.FRONT_END}));
        goto L128
    L109:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "This is an internal error of Lynx, which usually occurs when multiple threads access ShadowNode at the same time.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L110:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "This is an internal error of Lynx. LynxUI has not been created or the creation failed while updating.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L111:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Infinite loop of layout happens. It usually happens when the front-end decides the content size based on the viewport size, while the client is deciding the viewport size based on the content size.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.FRONT_END}));
        goto L128
    L112:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Lynx internal error. Please check whether the creating of corresponding ShadowNode failed", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L113:
        r10 = new x0(LynxSubErrorCode$Level.FATAL, NameKeys.UnloadStrategy_No_Strategy, Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L114:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, NameKeys.UnloadStrategy_No_Strategy, Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L115:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "This is unexpected. Please file an issue to Lynx to help address it.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L116:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "This is unexpected. Please file an issue to Lynx to help address it.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L117:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, NameKeys.UnloadStrategy_No_Strategy, Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L118:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please investigate the corresponding image download workflow for potential issues.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L119:
        r10 = new x0(LynxSubErrorCode$Level.WARN, "Please throttle related calls.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L120:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please see error info.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L121:
        r10 = new x0(LynxSubErrorCode$Level.WARN, "Please throttle related calls.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L122:
        r10 = new x0(LynxSubErrorCode$Level.FATAL, "Please check if the app bundle has been signed correctly", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L123:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please `loadTemplate` before `reloadTemplate`", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.CLIENT}));
        goto L128
    L124:
        r10 = new x0(LynxSubErrorCode$Level.FATAL, NameKeys.UnloadStrategy_No_Strategy, Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L12:
        switch(r3) {
            case 90101: goto L91;
            case 90102: goto L90;
            case 90103: goto L89;
            case 90104: goto L88;
            case 90105: goto L87;
            case 90106: goto L86;
            case 90107: goto L85;
            case 90108: goto L84;
            default: goto L13;
        };
    L13:
        switch(r3) {
            case 120201: goto L83;
            case 120202: goto L82;
            default: goto L14;
        };
    L14:
        switch(r3) {
            case 130100: goto L81;
            case 130101: goto L80;
            case 130102: goto L79;
            default: goto L15;
        };
    L15:
        switch(r3) {
            case 130201: goto L78;
            case 130202: goto L77;
            case 130203: goto L76;
            default: goto L16;
        };
    L16:
        switch(r3) {
            case 140100: goto L75;
            case 140101: goto L74;
            case 140102: goto L73;
            default: goto L17;
        };
    L17:
        switch(r3) {
            case 160101: goto L72;
            case 160102: goto L71;
            case 160103: goto L70;
            case 160104: goto L69;
            default: goto L19;
        };
    L69:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please check the error message of the bundle", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L70:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please check whether the lazy bundle file is broken or it is compatible with the host page", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L71:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please check whether the lazy bundle file is empty", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L72:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please check whether the url of the lazy bundle is available", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L19:
        switch(r3) {
            case 220201: goto L68;
            case 220202: goto L67;
            case 220203: goto L66;
            case 220204: goto L65;
            case 220205: goto L64;
            case 220206: goto L63;
            case 220207: goto L62;
            case 220208: goto L61;
            case 220209: goto L60;
            default: goto L20;
        };
    L20:
        switch(r3) {
            case 10201: goto L34;
            case 10202: goto L33;
            case 10203: goto L32;
            case 10204: goto L31;
            case 10205: goto L30;
            default: goto L22;
        };
    L30:
        r10 = new x0(LynxSubErrorCode$Level.FATAL, "Please check the error message of the bundle.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L31:
        r10 = new x0(LynxSubErrorCode$Level.FATAL, "Please check that 1. the provided bundle is an app bundle, 2. the engine version of the bundle is compatible with that of Lynx engine, 3. the bundle file is not broken.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L32:
        r10 = new x0(LynxSubErrorCode$Level.FATAL, "Please check if the app bundle is available", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L33:
        r10 = new x0(LynxSubErrorCode$Level.FATAL, "Please call the initialization method of LynxEnv before loadTemplate.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.CLIENT}));
        goto L128
    L34:
        r10 = new x0(LynxSubErrorCode$Level.FATAL, "Should not call `loadTemplate` while the rendering pipeline of app bundle has not finished", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L22:
        switch(r3) {
            case 20100: goto L39;
            case 20101: goto L38;
            case 20102: goto L37;
            case 20103: goto L36;
            case 20104: goto L35;
            default: goto L23;
        };
    L23:
        switch(r3) {
            case 30101: goto L42;
            case 30102: goto L41;
            case 30103: goto L40;
            default: goto L24;
        };
    L24:
        switch(r3) {
            case 30199: goto L49;
            case 30200: goto L48;
            case 30201: goto L47;
            case 30202: goto L46;
            case 30203: goto L45;
            case 30204: goto L44;
            case 30205: goto L43;
            default: goto L25;
        };
    L25:
        switch(r3) {
            case 32101: goto L53;
            case 32102: goto L52;
            case 32103: goto L51;
            case 32104: goto L50;
            default: goto L26;
        };
    L26:
        switch(r3) {
            case 40101: goto L55;
            case 40102: goto L54;
            default: goto L27;
        };
    L27:
        switch(r3) {
            case 50101: goto L57;
            case 50102: goto L56;
            default: goto L28;
        };
    L28:
        switch(r3) {
            case 111101: goto L59;
            case 111102: goto L58;
            default: goto L29;
        };
    L29:
        r10 = null;
        goto L128
    L58:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, NameKeys.UnloadStrategy_No_Strategy, Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L59:
        r10 = new x0(LynxSubErrorCode$Level.FATAL, NameKeys.UnloadStrategy_No_Strategy, Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L56:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, NameKeys.UnloadStrategy_No_Strategy, Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L57:
        r10 = new x0(LynxSubErrorCode$Level.FATAL, NameKeys.UnloadStrategy_No_Strategy, Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L54:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Target string data should be enabled to be parsed into a table.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L55:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Should not call `getDerivedStateFromProps`, `getDerivedStateFromError`, `shouldComponentUpdate` as data processor.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L50:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please check the network status or increase the timeout value.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.FRONT_END}));
        goto L128
    L51:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please refer to the official documentation to implement the ILynxResourceService and integrate it into your app.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.CLIENT}));
        goto L128
    L52:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please refer to the official documentation to integrate LynxImageService into your app.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.CLIENT}));
        goto L128
    L53:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please refer to the parameter descriptions of this API in documentation and check the parameters used in the call.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.FRONT_END}));
        goto L128
    L43:
        r10 = new x0(LynxSubErrorCode$Level.UNDECIDED, "If the font is displayed correctly, there is no need to deal with it.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L44:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please use a font file in ttf or otf format.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L45:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please check whether the base64 resource is available.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L46:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please check whether font resource is available.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L47:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please check the font-face format.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L48:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, NameKeys.UnloadStrategy_No_Strategy, Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L49:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "An unidentified exception occurred that cannot be attributed to a specific cause. Please investigate further based on the available details.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L40:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "In most cases, the issue arises from a canceled image request or an unavailable network connection.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L41:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Possibly due to an unsupported image format or a corrupted file. Please verify the integrity of the image file.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L42:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please resize the image to appropriate dimensions or enable downsampling.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L35:
        r10 = new x0(LynxSubErrorCode$Level.WARN, "Please check the error message and fix the script.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L36:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please check the error message and fix binding API call.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L37:
        r10 = new x0(LynxSubErrorCode$Level.FATAL, "Please check the error message and fix the script.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L38:
        r10 = new x0(LynxSubErrorCode$Level.FATAL, "Please check the error message and fix the script.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L39:
        r10 = new x0(LynxSubErrorCode$Level.UNDECIDED, NameKeys.UnloadStrategy_No_Strategy, Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L60:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "For parameter usage, please check documentation of list component.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L61:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please check the legality of the item-key.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L62:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please set the attribute enable-async-list of <list /> to true.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L63:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "The internal state of the engine has become inconsistent.  Please file an issue to Lynx for help resolving this problem.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L64:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "For parameter usage, please check documentation of list component.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L65:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please do not change the value of `vertical-orientation` dynamically.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L66:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "We have encountered a system-level error. Please file an issue to Lynx to help resolve this problem.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L67:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "We have encountered a system-level error. Please file an issue to Lynx to help resolve this problem.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L68:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please check the legality of the item-key.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L73:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Check the syntax of the script which is attached with SSR data.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L74:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please limit the client version to the ones that support the SSR data sent from the server side.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L75:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please check if the data used to render the page is the same data generated from the SSR server runtime. Or check if SSR is correctly implemented.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L76:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Remove property name from inheritance list.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L77:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Ignore it or raise an issue on github to let us know. This error is unexpected, which might be caused by internal pipeline fault.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L78:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Ignore it or raise an issue on github to let us know. This error is unexpected, which might be caused by internal pipeline fault", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L79:
        r10 = new x0(LynxSubErrorCode$Level.UNDECIDED, "Please check your value for the property follow the detailed message.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L80:
        r10 = new x0(LynxSubErrorCode$Level.UNDECIDED, NameKeys.UnloadStrategy_No_Strategy, Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L81:
        r10 = new x0(LynxSubErrorCode$Level.UNDECIDED, NameKeys.UnloadStrategy_No_Strategy, Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L82:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, NameKeys.UnloadStrategy_No_Strategy, Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L83:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, NameKeys.UnloadStrategy_No_Strategy, Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L84:
        r10 = new x0(LynxSubErrorCode$Level.WARN, "Please migrate deprecated api as soon as possible.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L85:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please file an issue to Lynx to help address it.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L86:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please file an issue to Lynx to help address it.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L87:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please file an issue to Lynx to help address it.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    L88:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please verify that the parameter types in the method call exactly match the native module implementation. Ensure type compatibility across all parameters and validate the parameter order corresponds to the native method signature. You can check the native module documentation for expected data types.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.FRONT_END}));
        goto L128
    L89:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please ensure that the number of parameters passed to the native method exactly matches the declared parameters in the native module implementation.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.FRONT_END}));
        goto L128
    L90:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please verify proper method registration using platform-specific annotations on Android or static method declarations on iOS (For details, refer to the native module documentation). Additionally, ensure that the invoked method name exactly matches the registered name in the native module implementation.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.CLIENT}));
        goto L128
    L91:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please verify that the invoked native module name matches the registered name and confirm module registration status.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.CLIENT}));
        goto L128
    L125:
        r10 = new x0(LynxSubErrorCode$Level.ERROR, "Please check whether the local external resource is available", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L128
    }
}
