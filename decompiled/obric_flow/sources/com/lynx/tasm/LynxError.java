package com.lynx.tasm;

import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.base.CalledByNative;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class LynxError {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9992c;
    public final String d;
    public JSONObject e;
    public final int f;
    public String g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f9993h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f9994i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f9995j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f9996k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List f9997l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f9998m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f9999n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f10000o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public HashMap f10001p;

    public LynxError(int r5, String r10, String r11, String r12, int r13, JavaOnlyMap r14, boolean r15) {
        this.f9991b = false;
        this.d = "";
        this.f9992c = r5;
        this.f9993h = r10;
        this.f = r13;
        this.f10001p = r14;
        this.f9990a = r15;
        switch(r5) {
            case 0: goto L98;
            case 10201: goto L97;
            case 10202: goto L96;
            case 10203: goto L95;
            case 10204: goto L94;
            case 10205: goto L93;
            case 10299: goto L92;
            case 10501: goto L91;
            case 10701: goto L90;
            case 20100: goto L89;
            case 20101: goto L88;
            case 20102: goto L87;
            case 20103: goto L86;
            case 20201: goto L85;
            case 20301: goto L84;
            case 30101: goto L83;
            case 30102: goto L82;
            case 30103: goto L81;
            case 30196: goto L80;
            case 30199: goto L79;
            case 30200: goto L78;
            case 30201: goto L77;
            case 30202: goto L76;
            case 30203: goto L75;
            case 30204: goto L74;
            case 30205: goto L73;
            case 30301: goto L72;
            case 30302: goto L71;
            case 30400: goto L70;
            case 32101: goto L69;
            case 32102: goto L68;
            case 32103: goto L67;
            case 39800: goto L66;
            case 39900: goto L65;
            case 40101: goto L64;
            case 40102: goto L63;
            case 40199: goto L62;
            case 50101: goto L61;
            case 50102: goto L60;
            case 50201: goto L59;
            case 60100: goto L58;
            case 60201: goto L57;
            case 60301: goto L56;
            case 60401: goto L55;
            case 90101: goto L54;
            case 90102: goto L53;
            case 90103: goto L52;
            case 90104: goto L51;
            case 90105: goto L50;
            case 90106: goto L49;
            case 90107: goto L48;
            case 90108: goto L47;
            case 90801: goto L46;
            case 99800: goto L45;
            case 99900: goto L44;
            case 109900: goto L43;
            case 110100: goto L42;
            case 111101: goto L41;
            case 111102: goto L40;
            case 120201: goto L39;
            case 120202: goto L38;
            case 130100: goto L37;
            case 130101: goto L36;
            case 130102: goto L35;
            case 130201: goto L34;
            case 130202: goto L33;
            case 130203: goto L32;
            case 130300: goto L31;
            case 140100: goto L30;
            case 140101: goto L29;
            case 140102: goto L28;
            case 140201: goto L27;
            case 140401: goto L26;
            case 160101: goto L25;
            case 160102: goto L24;
            case 160103: goto L23;
            case 160104: goto L22;
            case 190100: goto L21;
            case 190200: goto L20;
            case 190300: goto L19;
            case 200101: goto L18;
            case 220101: goto L17;
            case 220201: goto L16;
            case 220202: goto L15;
            case 220203: goto L14;
            case 220204: goto L13;
            case 220205: goto L12;
            case 220206: goto L11;
            case 220207: goto L10;
            case 220208: goto L9;
            case 220301: goto L8;
            case 229800: goto L7;
            case 990100: goto L6;
            case 990200: goto L5;
            default: goto L4;
        };
    L4:
        a0 r16 = null;
    L99:
        if (r16 == null) goto L109;
        LynxSubErrorCode$Level r17 = LynxSubErrorCode$Level.e;
        LynxSubErrorCode$Level r18 = (LynxSubErrorCode$Level) r16.f10069b;
        if (r18 == r17) goto L103;
        r12 = r18.f10014a;
    L103:
        this.f9995j = r12;
        String r19 = r16.f10068a;
        if (r19.isEmpty() == true) goto L107;
        r11 = r19;
    L107:
        this.f9998m = r11;
        this.f9997l = (List) r16.f10070c;
        this.f9991b = true;
        return;
    L109:
        this.f9995j = r12;
        this.f9998m = r11;
        this.f9997l = Collections.EMPTY_LIST;
        return;
    L5:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "This error is caught by Lynx engine. Please file an issue to Lynx for help.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L6:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "This error is caught by Lynx engine. Please file an issue to Lynx for help.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L7:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L8:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "This may be due to platform-specific limitations or system restrictions. If blur-radius is not supported on this platform, consider using CSS filter: blur() as an alternative.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L9:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please check the legality of the item-key.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L10:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please set the attribute enable-async-list of <list /> to true.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L11:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "The internal state of the engine has become inconsistent.  Please file an issue to Lynx for help resolving this problem.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L12:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "For parameter usage, please check documentation of list component.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L13:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please do not change the value of `vertical-orientation` dynamically.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L14:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "We have encountered a system-level error. Please file an issue to Lynx to help resolve this problem.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L15:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "We have encountered a system-level error. Please file an issue to Lynx to help resolve this problem.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L16:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please check the legality of the item-key.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L17:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.f10009a}));
        goto L99
    L18:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L19:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Make sure you have imported worklet file correctly.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L20:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Calling requestAnimationFrame failed. This is usually caused by an error in the callback function. Please ensure that the callback function executes without errors.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L21:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L22:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please check the error message of the bundle", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L23:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please check whether the lazy bundle file is broken or it is compatible with the host page", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L24:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please check whether the lazy bundle file is empty", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L25:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please check whether the url of the lazy bundle is available", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L26:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "The used app bundle and injected data to hydrate the SSR page should be the same as ones used to render on the server side", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L27:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L28:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Check the syntax of the script which is attached with SSR data.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L29:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please limit the client version to the ones that support the SSR data sent from the server side.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L30:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please check if the data used to render the page is the same data generated from the SSR server runtime. Or check if SSR is correctly implemented.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L31:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please use values following the property definitions. You can get the definitions at the official website.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L32:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Remove property name from inheritance list.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L33:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Ignore it or raise an issue on github to let us know. This error is unexpected, which might be caused by internal pipeline fault.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L34:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Ignore it or raise an issue on github to let us know. This error is unexpected, which might be caused by internal pipeline fault", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L35:
        r16 = new a0(LynxSubErrorCode$Level.e, "Please check your value for the property follow the detailed message.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L36:
        r16 = new a0(LynxSubErrorCode$Level.e, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L37:
        r16 = new a0(LynxSubErrorCode$Level.e, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L38:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L39:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L40:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L41:
        r16 = new a0(LynxSubErrorCode$Level.f10012b, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L42:
        r16 = new a0(LynxSubErrorCode$Level.e, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L43:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "This error is caught by the Lynx Engine. Please file an issue to Lynx to help address it.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.f10011c}));
        goto L99
    L44:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "This error indicates an unhandled runtime exception within the native module implementation. Please refer to the module error handling guide or contact the module maintainer with complete error context.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.f10010b}));
        goto L99
    L45:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "This error is explicitly defined by the native module implementation. Please refer to the module error handling guide or contact the module maintainer with complete error context.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.f10010b}));
        goto L99
    L46:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Check if the server's response body is correct; Check if client unexpectedly consumes http response body using network request interceptor; You can use request's url and log id to track down the problem.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.f10009a}));
        goto L99
    L47:
        r16 = new a0(LynxSubErrorCode$Level.d, "Please migrate deprecated api as soon as possible.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L48:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please file an issue to Lynx to help address it.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L49:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please file an issue to Lynx to help address it.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L50:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please file an issue to Lynx to help address it.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L51:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please verify that the parameter types in the method call exactly match the native module implementation. Ensure type compatibility across all parameters and validate the parameter order corresponds to the native method signature. You can check the native module documentation for expected data types.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.f10009a}));
        goto L99
    L52:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please ensure that the number of parameters passed to the native method exactly matches the declared parameters in the native module implementation.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.f10009a}));
        goto L99
    L53:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please verify proper method registration using platform-specific annotations on Android or static method declarations on iOS (For details, refer to the native module documentation). Additionally, ensure that the invoked method name exactly matches the registered name in the native module implementation.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.f10010b}));
        goto L99
    L54:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please verify that the invoked native module name matches the registered name and confirm module registration status.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.f10010b}));
        goto L99
    L55:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "This is an internal error of Lynx, which usually occurs when multiple threads access ShadowNode at the same time.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L56:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "This is an internal error of Lynx. LynxUI has not been created or the creation failed while updating.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L57:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Infinite loop of layout happens. It usually happens when the front-end decides the content size based on the viewport size, while the client is deciding the viewport size based on the content size.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.f10009a}));
        goto L99
    L58:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Lynx internal error. Please check whether the creating of corresponding ShadowNode failed", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L59:
        r16 = new a0(LynxSubErrorCode$Level.f10012b, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L60:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L61:
        r16 = new a0(LynxSubErrorCode$Level.f10012b, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L62:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L63:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Target string data should be enabled to be parsed into a table.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L64:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Should not call `getDerivedStateFromProps`, `getDerivedStateFromError`, `shouldComponentUpdate` as data processor.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L65:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "This is unexpected. Please file an issue to Lynx to help address it.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L66:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "This is unexpected. Please file an issue to Lynx to help address it.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L67:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please refer to the official documentation to implement the ILynxResourceService and integrate it into your app.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.f10010b}));
        goto L99
    L68:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please refer to the official documentation to integrate LynxImageService into your app.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.f10010b}));
        goto L99
    L69:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please refer to the parameter descriptions of this API in documentation and check the parameters used in the call.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.f10009a}));
        goto L99
    L70:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L71:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please check whether the local external resource is available", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L72:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please check whether the url of the external resource is available", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L73:
        r16 = new a0(LynxSubErrorCode$Level.e, "If the font is displayed correctly, there is no need to deal with it.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L74:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please use a font file in ttf or otf format.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L75:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please check whether the base64 resource is available.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L76:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please check whether font resource is available.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L77:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please check the font-face format.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L78:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L79:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "An unidentified exception occurred that cannot be attributed to a specific cause. Please investigate further based on the available details.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L80:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please investigate the corresponding image download workflow for potential issues.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L81:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "In most cases, the issue arises from a canceled image request or an unavailable network connection.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L82:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Possibly due to an unsupported image format or a corrupted file. Please verify the integrity of the image file.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L83:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please resize the image to appropriate dimensions or enable downsampling.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L84:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please see error info.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L85:
        r16 = new a0(LynxSubErrorCode$Level.d, "Please throttle related calls.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L86:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please check the error message and fix binding API call.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L87:
        r16 = new a0(LynxSubErrorCode$Level.f10012b, "Please check the error message and fix the script.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L88:
        r16 = new a0(LynxSubErrorCode$Level.f10012b, "Please check the error message and fix the script.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L89:
        r16 = new a0(LynxSubErrorCode$Level.e, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L90:
        r16 = new a0(LynxSubErrorCode$Level.f10012b, "Please check if the app bundle has been signed correctly", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L91:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "Please `loadTemplate` before `reloadTemplate`", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.f10010b}));
        goto L99
    L92:
        r16 = new a0(LynxSubErrorCode$Level.f10012b, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L93:
        r16 = new a0(LynxSubErrorCode$Level.f10012b, "Please check the error message of the bundle.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L94:
        r16 = new a0(LynxSubErrorCode$Level.f10012b, "Please check that 1. the provided bundle is an app bundle, 2. the engine version of the bundle is compatible with that of Lynx engine, 3. the bundle file is not broken.", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L95:
        r16 = new a0(LynxSubErrorCode$Level.f10012b, "Please check if the app bundle is available", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L96:
        r16 = new a0(LynxSubErrorCode$Level.f10012b, "Please call the initialization method of LynxEnv before loadTemplate.", Arrays.asList(new LynxSubErrorCode$Consumer[]{LynxSubErrorCode$Consumer.f10010b}));
        goto L99
    L97:
        r16 = new a0(LynxSubErrorCode$Level.f10012b, "Should not call `loadTemplate` while the rendering pipeline of app bundle has not finished", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    L98:
        r16 = new a0(LynxSubErrorCode$Level.f10013c, "", Arrays.asList(new LynxSubErrorCode$Consumer[0]));
        goto L99
    }

    public static void c(JSONObject r5, String r10, String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L9;
        r5.put(r10, r11);
        return;
    }

    @CalledByNative
    private static LynxError createLynxError(int r10, String r11, String r12, String r13, JavaOnlyMap r14, boolean r15) {
        return new LynxError(r10, r11, r12, r13, -1, r14, r15);
    }

    public static void d(JSONObject r5, HashMap r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.isEmpty() == true) goto L23;
        JSONObject r11 = new JSONObject();
        Iterator r12 = r10.entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L13;
        Map.Entry r13 = (Map.Entry) r12.next();
        if (((String) r13.getKey()).startsWith("lynx_context_") == true) goto L10;
        r5.put((String) r13.getKey(), r13.getValue());
        goto L7
    L10:
        r11.put((String) r13.getKey(), r13.getValue());
        goto L7
    L13:
        if (r11.length() <= 0) goto L24;
        r5.put("context", r11);
        return;
    L24:
        return;
    }

    public final int a() {
        boolean r5 = this.f9991b;
        int r10 = this.f9992c;
        if (r5 == true) goto L5;
        return r10;
    L5:
        return r10 / 100;
    }

    public final void b(String r5, String r10) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r10) == true) goto L13;
        this.g = null;
        if (this.f10001p != null) goto L10;
        this.f10001p = new HashMap();
    L10:
        this.f10001p.put(r5, r10);
        return;
    }

    public final String e() {
        if (TextUtils.isEmpty(this.g) == false) goto L5;
        String r5 = this.f9993h;
        if (TextUtils.isEmpty(r5) == true) goto L22;
        JSONObject r10 = new JSONObject();
        r10.put(WsConstants.ERROR_CODE, a());     // Catch: JSONException -> L14
        r10.put("sub_code", this.f9992c);     // Catch: JSONException -> L14
        c(r10, "url", this.f9994i);     // Catch: JSONException -> L14
        c(r10, "error", r5);     // Catch: JSONException -> L14
        c(r10, "card_version", this.f9996k);     // Catch: JSONException -> L14
        c(r10, "sdk", LynxEnv.inst().getLynxVersion());     // Catch: JSONException -> L14
        c(r10, "level", this.f9995j);     // Catch: JSONException -> L14
        r10.put("consumers", new JSONArray(this.f9997l));     // Catch: JSONException -> L14
        c(r10, "fix_suggestion", this.f9998m);     // Catch: JSONException -> L14
        c(r10, "error_stack", this.f9999n);     // Catch: JSONException -> L14
        c(r10, "root_cause", this.f10000o);     // Catch: JSONException -> L14
        d(r10, this.f10001p);     // Catch: JSONException -> L14
        JSONObject r11 = this.e;     // Catch: JSONException -> L14
        if (r11 != null) goto L12;
    L16:
        String r12 = r10.toString();     // Catch: JSONException -> L14
    L19:
        if (r12 != null) goto L21;
        r12 = "";
    L21:
        this.g = r12;
    L25:
        String r13 = this.g;
        if (r13 != null) goto L29;
        return "";
    L29:
        return r13;
    L12:
        if (r11.length() <= 0) goto L16;
        r10.put("user_define_info", this.e);     // Catch: JSONException -> L14
    L14:
        e = move-exception;
        LynxLog.b(4, "LynxError", e.getMessage());
        r12 = null;
        goto L19
    L22:
        String r14 = this.d;
        if (r14 == null) goto L25;
        this.g = r14;
        goto L25
    L5:
        return this.g;
    }

    public final String toString() {
        return "{\"code\": " + a() + ",\"msg\":" + e() + "}";
    }

    public LynxError(String r5, int r10) {
        this.f9990a = false;
        this.f9991b = false;
        this.f9992c = r10;
        this.d = r5;
    }

    public LynxError(int r10, String r11, String r12, String r13) {
        this(r10, r11, r12, r13, -3, null, false);
    }
}
