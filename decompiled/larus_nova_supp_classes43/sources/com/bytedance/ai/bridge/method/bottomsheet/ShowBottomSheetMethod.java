package com.bytedance.ai.bridge.method.bottomsheet;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.doubao.showBottomSheet.AbsShowBottomSheetMethodIDL;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.utils.g;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import d3.a0;
import e3.d;
import f3.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import k3.c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import m3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\f\u0010\u000f\u001a\u00020\u0010*\u00020\u000eH\u0002J\f\u0010\u0011\u001a\u00020\f*\u00020\u0012H\u0002J\u000e\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u00020\u0015H\u0002J\f\u0010\u0016\u001a\u00020\u0015*\u00020\u0014H\u0002J\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0015*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0015H\u0002J\u000e\u0010\u001a\u001a\u0004\u0018\u00010\u0015*\u00020\u001bH\u0002J\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0010*\u00020\u001bH\u0002¢\u0006\u0002\u0010\u001dJ\u000e\u0010\u001e\u001a\u0004\u0018\u00010\u0018*\u00020\u001bH\u0002J\u000e\u0010\u001f\u001a\u0004\u0018\u00010 *\u00020\u001bH\u0002J\u001a\u0010!\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\"\u001a\u00020\u0015H\u0002J\u0012\u0010#\u001a\u0004\u0018\u00010\u00152\u0006\u0010$\u001a\u00020\u0015H\u0002¨\u0006&"}, d2 = {"Lcom/bytedance/ai/bridge/method/bottomsheet/ShowBottomSheetMethod;", "Lcom/bytedance/ai/bridge/doubao/showBottomSheet/AbsShowBottomSheetMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/bytedance/ai/bridge/doubao/showBottomSheet/AbsShowBottomSheetMethodIDL$ShowBottomSheetParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/ai/bridge/doubao/showBottomSheet/AbsShowBottomSheetMethodIDL$ShowBottomSheetResultModel;", "resolveAppInfo", "Lcom/bytedance/ai/bridge/method/bottomsheet/DoubaoBottomSheetAppInfo;", "isBlank", "", "toResultModel", "Lcom/bytedance/ai/bridge/method/bottomsheet/DoubaoBottomSheetResult;", "toButtonRole", "Lcom/bytedance/ai/bridge/method/bottomsheet/DoubaoBottomSheetButtonRole;", "", "toResultValue", "getStringOrNull", "Lcom/google/gson/JsonObject;", "key", "asStringOrNull", "Lcom/google/gson/JsonElement;", "asBooleanOrNull", "(Lcom/google/gson/JsonElement;)Ljava/lang/Boolean;", "asJsonObjectOrNull", "asJsonArrayOrNull", "Lcom/google/gson/JsonArray;", "onInvalidParameter", MessageIndication.MESSAGE_TYPE_MSG, "htmlValidate", "html", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShowBottomSheetMethod extends AbsShowBottomSheetMethodIDL {
    public static final Regex b = null;
    public static final Regex c = null;
    public static final Regex d = null;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[DoubaoBottomSheetCancelSource.values().length];
            r0[DoubaoBottomSheetCancelSource.MASK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L31:
            r0[DoubaoBottomSheetCancelSource.GESTURE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L43:
            r0[DoubaoBottomSheetCancelSource.HOST_UNAVAILABLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L33:
            r0[DoubaoBottomSheetCancelSource.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L9:
            a = r0;
            int[] r1 = new int[DoubaoBottomSheetAction.values().length];
            r1[DoubaoBottomSheetAction.BUTTON_CLICK.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L35:
            r1[DoubaoBottomSheetAction.CANCEL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L12:
            b = r1;
            int[] r10 = new int[DoubaoBottomSheetButtonRole.values().length];
            r10[DoubaoBottomSheetButtonRole.AGREE_MAIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L29:
            r10[DoubaoBottomSheetButtonRole.AGREE_SUB.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L37:
            r10[DoubaoBottomSheetButtonRole.REJECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L16:
            c = r10;
        }
    }

    static {
        RegexOption r1 = RegexOption.IGNORE_CASE;
        b = new Regex("<\\s*/?\\s*(script|style|iframe|object|embed|img|svg|link|meta|form|input|button|video|audio)\\b", r1);
        c = new Regex("\\son[a-z0-9_-]+\\s*=", r1);
        d = new Regex("<a\\b[^>]*\\bhref\\s*=\\s*['\"]?\\s*(javascript|data|file|about)\\s*:", r1);
    }

    public ShowBottomSheetMethod() {
    }

    public static JsonObject b(JsonElement r10) {
        Object r1 = null;
        if (r10.isJsonObject() == true) goto L15;
        return null;
    L15:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        Object r11 = Result.constructor-impl(r10.getAsJsonObject());     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r11) == true) goto L14;
        r1 = r11;
    L14:
        return (JsonObject) r1;
    L7:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static AbsShowBottomSheetMethodIDL.b e(com.bytedance.ai.bridge.method.bottomsheet.a r10) {
        Intrinsics.checkNotNullParameter(AbsShowBottomSheetMethodIDL.b.class, "<this>");
        AbsShowBottomSheetMethodIDL.b r0 = (AbsShowBottomSheetMethodIDL.b) c.a(AbsShowBottomSheetMethodIDL.b.class);
        int r1 = b.b[r10.a.ordinal()];
        if (r1 == 1) goto L25;
        if (r1 != 2) goto L24;
        r0.setAction("cancel");
        r0.setRole(null);
        DoubaoBottomSheetCancelSource r11 = r10.c;
        if (r11 != null) goto L8;
        int r12 = -1;
    L9:
        if (r12 == (-1)) goto L21;
        if (r12 == 1) goto L20;
        if (r12 == 2) goto L19;
        if (r12 != 3) goto L14;
        String r13 = "hostUnavailable";
    L22:
        r0.setSource(r13);
    L38:
        return r0;
    L14:
        if (r12 == 4) goto L21;
        throw new NoWhenBranchMatchedException();
    L19:
        r13 = "gesture";
        goto L22
    L20:
        r13 = "mask";
    L21:
        r13 = "unknown";
        goto L22
    L8:
        r12 = b.a[r11.ordinal()];
        goto L9
    L24:
        throw new NoWhenBranchMatchedException();
    L25:
        r0.setAction("buttonClick");
        DoubaoBottomSheetButtonRole r14 = r10.b;
        if (r14 == null) goto L36;
        int r15 = b.c[r14.ordinal()];
        if (r15 == 1) goto L35;
        if (r15 == 2) goto L34;
        if (r15 != 3) goto L33;
        String r16 = "reject";
    L37:
        r0.setRole(r16);
        r0.setSource(null);
        goto L38
    L33:
        throw new NoWhenBranchMatchedException();
    L34:
        r16 = "agreeSub";
        goto L37
    L35:
        r16 = "agreeMain";
        goto L37
    L36:
        r16 = null;
        goto L37
    }

    public static String c(JsonObject r1, String r10) {
        JsonElement r11 = r1.get(r10);
        Object r12 = null;
        if (r11 != null) goto L5;
        return null;
    L5:
        if (r11.isJsonNull() == true) goto L20;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        Object r13 = Result.constructor-impl(r11.getAsString());     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r13) == true) goto L16;
        r12 = r13;
    L16:
        return (String) r12;
    L9:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L20:
        return null;
    }

    public static void d(h r10, String r11) {
        g r0 = g.a;
        StringBuilder r1 = new StringBuilder("call failed, errNo=");
        f3.a r12 = f3.a.h;
        r1.append(r12.a);
        r1.append(", msg=");
        r1.append(r11);
        r0.e("AISDK_JSB_ShowBottomSheetMethod", r1.toString());
        h.a.a(r10, r11, r12, null, 10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [m3.e] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(d r17, ParamModel r18, final h r19) {
        AbsShowBottomSheetMethodIDL.a r0 = (AbsShowBottomSheetMethodIDL.a) r18;
        Intrinsics.checkNotNullParameter(r17, "bridgeContext");
        Intrinsics.checkNotNullParameter(r0, "params");
        Intrinsics.checkNotNullParameter(r19, "callback");
        JsonObject r10 = r0.toJson();
        String r11 = c(r10, "title");
        String r12 = c(r10, "content");
        JsonElement r1 = r10.get("buttons");
        if (r1 != null) goto L183;
        JsonArray r13 = null;
    L17:
        a0 r14 = r17.getContainerContext();
        g r15 = g.a;
        StringBuilder r16 = new StringBuilder("call start, titleLen=");
        boolean r110 = false;
        if (r11 == null) goto L20;
        int r111 = r11.length();
    L21:
        r16.append(r111);
        r16.append(", contentLen=");
        if (r12 == null) goto L24;
        int r112 = r12.length();
    L25:
        r16.append(r112);
        r16.append(", buttonCount=");
        if (r13 == null) goto L28;
        int r113 = r13.size();
    L29:
        r16.append(r113);
        r16.append(", appletId=");
        if (r14 == null) goto L32;
        String r114 = r14.getAppletId();
    L33:
        r16.append(r114);
        r16.append(", containerId=");
        if (r14 == null) goto L36;
        String r20 = r14.getContainerId();
    L37:
        r16.append(r20);
        r15.i("AISDK_JSB_ShowBottomSheetMethod", r16.toString());
        boolean r21 = true;
        if (r11 != null) goto L40;
    L43:
        boolean r22 = true;
    L44:
        if (r22 == false) goto L47;
        d(r19, "title can not be empty");
    L192:
        return;
    L47:
        if (r12 != null) goto L49;
    L52:
        boolean r23 = true;
    L53:
        if (r23 == false) goto L56;
        d(r19, "content can not be empty");
        goto L192
    L56:
        if (b.containsMatchIn(r12) == false) goto L59;
        String r24 = "content contains unsupported html tag";
    L65:
        if (r24 == null) goto L67;
        d(r19, r24);
        goto L192
    L67:
        if (r13 != null) goto L69;
    L181:
        d(r19, "buttons size must be between 1 and 3");
        return;
    L69:
        if (r13.size() == 0) goto L181;
        if (r13.size() > 3) goto L181;
        LinkedHashSet r25 = new LinkedHashSet();
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r26 = r13.iterator();
    L74:
        String r116 = "";
        if (r26.hasNext() == false) goto L123;
        JsonElement r117 = (JsonElement) r26.next();
        Intrinsics.checkNotNull(r117);
        JsonObject r118 = b(r117);
        if (r118 == null) goto L78;
        String r119 = c(r118, "role");
        if (r119 == null) goto L99;
        int r120 = r119.hashCode();
        if (r120 == (-934710369)) goto L96;
        if (r120 == 974829189) goto L93;
        if (r120 != 1832567796) goto L99;
        if (r119.equals("agreeSub") == false) goto L99;
        DoubaoBottomSheetButtonRole r27 = DoubaoBottomSheetButtonRole.AGREE_SUB;
    L100:
        if (r27 == null) goto L102;
        if (r25.add(r27) == false) goto L109;
        String r121 = c(r118, "text");
        if (r121 != null) goto L116;
    L119:
        boolean r122 = true;
    L120:
        if (r122 == true) goto L121;
        r115.add(new m3.c(r27, r121));
        goto L74
    L121:
        d(r19, "button text can not be empty");
        goto L192
    L116:
        if (StringsKt.isBlank(r121) == true) goto L119;
        r122 = false;
        goto L120
    L109:
        if (r119 == null) goto L112;
        r116 = r119;
    L112:
        d(r19, "button role can not be duplicated: ".concat(r116));
        goto L192
    L102:
        if (r119 == null) goto L105;
        r116 = r119;
    L105:
        d(r19, "invalid button role: ".concat(r116));
        goto L192
    L93:
        if (r119.equals("agreeMain") == false) goto L99;
        r27 = DoubaoBottomSheetButtonRole.AGREE_MAIN;
        goto L100
    L96:
        if (r119.equals("reject") == false) goto L99;
        r27 = DoubaoBottomSheetButtonRole.REJECT;
    L99:
        r27 = null;
        goto L100
    L78:
        d(r19, "button item must be object");
        goto L192
    L123:
        a0 r28 = r17.getContainerContext();
        if (r28 == null) goto L156;
        String r29 = r28.getAppletId();
        if (r29 == null) goto L156;
        if ((!StringsKt.isBlank(r29)) == true) goto L131;
        r29 = null;
    L131:
        if (r29 == null) goto L156;
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r30 = AppletAppManagerService.a(r29);
        if (r30 != null) goto L136;
        g.a.w("AISDK_JSB_ShowBottomSheetMethod", "fallback used, reason=applet unavailable");
    L157:
        m3.a r31 = null;
    L158:
        JsonElement r32 = r10.get("behavior");
        if (r32 == null) goto L177;
        JsonObject r33 = b(r32);
        if (r33 == null) goto L177;
        JsonElement r34 = r33.get("dismissOnMaskTap");
        if (r34 == null) goto L177;
        if (r34.isJsonNull() == false) goto L185;
        Boolean r35 = null;
    L175:
        if (r35 == null) goto L177;
        r21 = r35.booleanValue();
        goto L177
    L185:
        Result.Companion r36 = Result.Companion;     // Catch: Throwable -> L169
        Object r37 = Result.constructor-impl(Boolean.valueOf(r34.getAsBoolean()));     // Catch: Throwable -> L169
    L172:
        if (Result.isFailure-impl(r37) == false) goto L174;
        r37 = null;
    L174:
        r35 = (Boolean) r37;
    L169:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        r37 = Result.constructor-impl(ResultKt.createFailure(th));
    L177:
        m3.d r39 = new m3.d(r31, r11, r12, r115, new m3.b(r21));
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r40 = AppletRuntimeManager.d;
        if (r40 != 0) goto L180;
        g r41 = g.a;
        r41.w("AISDK_JSB_ShowBottomSheetMethod", "fallback used, reason=host unavailable");
        r41.i("AISDK_JSB_ShowBottomSheetMethod", "call success, action=cancel, source=hostUnavailable");
        int r42 = com.bytedance.ai.bridge.method.bottomsheet.a.d;
        r19.b(e(com.bytedance.ai.bridge.method.bottomsheet.a.C0021a.a(DoubaoBottomSheetCancelSource.HOST_UNAVAILABLE)), "");
        goto L192
    L180:
        r40.M(r39, new e(r19, this));
        return;
    L136:
        String r43 = r30.j().a;
        String r44 = r30.j().b();
        m3.a r45 = new m3.a(r43, r44);
        if (r43 != null) goto L139;
    L142:
        boolean r46 = true;
    L143:
        if (r46 == false) goto L152;
        if (r44 != null) goto L146;
    L149:
        boolean r47 = true;
    L150:
        if (r47 == false) goto L152;
        r110 = true;
        goto L152
    L146:
        if (StringsKt.isBlank(r44) == true) goto L149;
        r47 = false;
    L152:
        if (r110 == false) goto L155;
        r45 = null;
    L155:
        r31 = r45;
        goto L158
    L139:
        if (StringsKt.isBlank(r43) == true) goto L142;
        r46 = false;
    L156:
        g.a.w("AISDK_JSB_ShowBottomSheetMethod", "fallback used, reason=appletId unavailable");
        goto L157
    L59:
        if (c.containsMatchIn(r12) == false) goto L62;
        r24 = "content contains unsupported html event attribute";
        goto L65
    L62:
        if (d.containsMatchIn(r12) == false) goto L64;
        r24 = "a href should use http or https";
        goto L65
    L64:
        r24 = null;
        goto L65
    L49:
        if (StringsKt.isBlank(r12) == true) goto L52;
        r23 = false;
        goto L53
    L40:
        if (StringsKt.isBlank(r11) == true) goto L43;
        r22 = false;
        goto L44
    L36:
        r20 = null;
        goto L37
    L32:
        r114 = null;
        goto L33
    L28:
        r113 = 0;
        goto L29
    L24:
        r112 = 0;
        goto L25
    L20:
        r111 = 0;
        goto L21
    L183:
        Result.Companion r48 = Result.Companion;     // Catch: Throwable -> L10
        if (r1.isJsonArray() == false) goto L7;
        JsonArray r49 = r1.getAsJsonArray();     // Catch: Throwable -> L10
    L8:
        Object r50 = Result.constructor-impl(r49);     // Catch: Throwable -> L10
    L13:
        if (Result.isFailure-impl(r50) == false) goto L15;
        r50 = null;
    L15:
        r13 = (JsonArray) r50;
        goto L17
    L7:
        r49 = null;
    L10:
        th = move-exception;
        Result.Companion r51 = Result.Companion;
        r50 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }
}
