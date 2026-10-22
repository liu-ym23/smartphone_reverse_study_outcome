package tqb;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.m;
import com.lynx.tasm.q1;
import com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeProtocol;
import com.ss.android.lark.lynxkit.bridge.ILarkLynxBridgeRuntimeFactory;
import com.ss.android.lark.lynxkit.container.ILarkLynxContainer;
import com.ss.android.lark.lynxkit.container.ILynxContainerContext;
import com.ss.android.lark.lynxkit.container.LarkLynxContainerBuilder;
import com.ss.android.lark.lynxkit.host.LarkLynxHostOptions;
import com.ss.android.lark.lynxkit.host.LarkLynxHostParams;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public static final class a extends q1 {
        public final q1 a;
        public final e b;

        public final void onLoadSuccess() {
            e r0 = this.b;
            if (r0 == null) goto L5;
            r0.a();
        L5:
            q1 r1 = this.a;
            if (r1 == null) goto L8;
            r1.onLoadSuccess();
            return;
        L8:
            super.onLoadSuccess();
        }

        public final void onPageStart(String r2) {
            e r0 = this.b;
            if (r0 == null) goto L5;
            r0.onLoadStart();
        L5:
            q1 r1 = this.a;
            if (r1 == null) goto L8;
            r1.onPageStart(r2);
            return;
        L8:
            super.onPageStart(r2);
        }

        public final void onReceivedError(LynxError r2) {
            e r0 = this.b;
            if (r0 == null) goto L5;
            r0.a();
        L5:
            q1 r1 = this.a;
            if (r1 == null) goto L8;
            r1.onReceivedError(r2);
            return;
        L8:
            super.onReceivedError(r2);
        }

        public a(q1 r1, e r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public static boolean b(LarkLynxHostParams r1) {
        Intrinsics.checkNotNullParameter(r1, "params");
        if (TextUtils.isEmpty(r1.getTemplateUrl()) == true) goto L5;
    L8:
        return true;
    L5:
        if (TextUtils.isEmpty(r1.getTemplatePath()) == false) goto L8;
        return false;
    }

    public static void c(ILarkLynxContainer r2, LarkLynxHostParams r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r3, "params");
        String r1 = "";
        if (TextUtils.isEmpty(r3.getTemplateUrl()) == true) goto L13;
        String r0 = r3.getTemplateUrl();
        if (r0 == null) goto L8;
        r1 = r0;
    L8:
        Map<String, Object> r4 = r3.getInitDataMap();
        if (r4 == null) goto L11;
        r2.render(r1, r4, r3.getLynxViewShareData());
        return;
    L11:
        r2.render(r1, r3.getInitDataJson(), r3.getLynxViewShareData());
        return;
    L13:
        if (TextUtils.isEmpty(r3.getTemplatePath()) == true) goto L22;
        String r5 = r3.getTemplatePath();
        if (r5 == null) goto L18;
        r1 = r5;
    L18:
        Map<String, Object> r6 = r3.getInitDataMap();
        if (r6 == null) goto L21;
        r2.renderByTemplateLoader(r1, r6, r3.getLynxViewShareData());
        return;
    L21:
        r2.renderByTemplateLoader(r1, r3.getInitDataJson(), r3.getLynxViewShareData());
        return;
    L22:
        r2.render();
    }

    public static ILarkLynxContainer a(Context r5, LarkLynxHostParams r6, LarkLynxHostOptions r7, e r8) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r7, "options");
        LarkLynxContainerBuilder r9 = new LarkLynxContainerBuilder(r5).enableAsyncRender(r6.getEnableAsyncRender()).enableAsyncRenderForList(r6.getEnableAsyncRenderForList()).enableDevToolsDebug(r6.getEnableDevToolsDebug()).setEnableUserCodeCache(r6.getEnableUserCodeCache());
        ILynxContainerContext r0 = r6.getContainerContext();
        if (r0 == null) goto L5;
        r9.containerContext(r0);
    L5:
        String r1 = r6.getTagForJsContext();
        boolean r2 = false;
        LynxView r3 = null;
        if (r1 != null) goto L8;
    L16:
        String r4 = r6.getTagForCustomComponent();
        if (r4 != null) goto L19;
    L27:
        String r10 = r6.getTagForGlobalData();
        if (r10 != null) goto L30;
    L38:
        String r11 = r6.getTagForBridgeMethodDispatcher();
        if (r11 != null) goto L41;
    L49:
        String r12 = r6.getTagForBridgeMethodGroup();
        if (r12 != null) goto L52;
    L60:
        String r13 = r6.getTagForBridgeProtocol();
        if (r13 != null) goto L63;
    L71:
        ILarkLynxBridgeRuntimeFactory r14 = r6.getBridgeRuntimeFactory();
        if (r14 == null) goto L74;
        r9.bridgeRuntimeFactory(r14);
    L74:
        ILarkLynxBridgeProtocol r15 = r6.getBridgeProtocol();
        if (r15 == null) goto L77;
        r9.bridgeProtocol(r15);
    L77:
        String r16 = r6.getBridgeProtocolContainerId();
        if (r16 != null) goto L80;
    L88:
        String r17 = r6.getTagForJSModule();
        if (r17 != null) goto L91;
    L99:
        String r18 = r6.getTagForTemplateLoader();
        if (r18 != null) goto L102;
    L110:
        String r19 = r6.getDevToolSocketUrl();
        if (r19 != null) goto L113;
    L121:
        String r20 = r6.getCodeCacheSourceUrl();
        if (r20 != null) goto L124;
    L132:
        String r21 = r6.getTemplateUrl();
        if (r21 != null) goto L135;
    L143:
        String r22 = r6.getTemplatePath();
        if (r22 != null) goto L146;
    L153:
        Map<String, ? extends Object> r23 = r6.getInitDataMap();
        if (r23 != null) goto L156;
    L157:
        String r24 = r6.getInitDataJson();
        if (r24 == null) goto L160;
        r9.initData(r24);
    L160:
        Integer r25 = r6.getWidthMeasureSpec();
        if (r25 == null) goto L163;
        r9.widthMeasureSpec(r25.intValue());
    L163:
        Integer r26 = r6.getHeightMeasureSpec();
        if (r26 == null) goto L166;
        r9.heightMeasureSpec(r26.intValue());
    L166:
        Float r27 = r6.getFontScale();
        if (r27 == null) goto L169;
        r9.fontScale(r27.floatValue());
    L169:
        Map<String, Object> r28 = r6.getLynxViewShareData();
        if (r28 == null) goto L175;
        Iterator<Map.Entry<String, Object>> r29 = r28.entrySet().iterator();
    L173:
        if (r29.hasNext() == false) goto L175;
        Map.Entry<String, Object> r30 = r29.next();
        r9.lynxContextShareData(r30.getKey(), r30.getValue());
    L175:
        m r31 = r7.getImageInterceptor();
        if (r31 == null) goto L178;
        r9.imageLoader(r31);
    L178:
        sqb.a r32 = r7.getTemplateLoadListener();
        if (r32 == null) goto L181;
        r9.templateLoadListener(r32);
    L181:
        ILarkLynxContainer r33 = r9.build();
        if (r7.getLynxViewClient() != null) goto L184;
        if (r8 != null) goto L184;
    L189:
        return r33;
    L184:
        View r34 = r33.getLynxView();
        if ((r34 instanceof LynxView) == false) goto L187;
        r3 = (LynxView) r34;
    L187:
        if (r3 == null) goto L189;
        r3.addLynxViewClient(new a(r7.getLynxViewClient(), r8));
        goto L189
    L156:
        if (r9.initData(r23) != null) goto L160;
    L146:
        if (r22.length() <= 0) goto L148;
        r2 = true;
    L148:
        if (r2 == true) goto L151;
        r22 = null;
    L151:
        if (r22 == null) goto L153;
        r9.templatePathForTemplateLoader(r22);
        goto L153
    L135:
        if (r21.length() <= 0) goto L137;
        boolean r35 = true;
    L138:
        if (r35 == true) goto L141;
        r21 = null;
    L141:
        if (r21 == null) goto L143;
        r9.templateUrl(r21);
        goto L143
    L137:
        r35 = false;
        goto L138
    L124:
        if (r20.length() <= 0) goto L126;
        boolean r36 = true;
    L127:
        if (r36 == true) goto L130;
        r20 = null;
    L130:
        if (r20 == null) goto L132;
        r9.setCodeCacheSourceUrl(r20);
        goto L132
    L126:
        r36 = false;
        goto L127
    L113:
        if (r19.length() <= 0) goto L115;
        boolean r37 = true;
    L116:
        if (r37 == true) goto L119;
        r19 = null;
    L119:
        if (r19 == null) goto L121;
        r9.devToolSocketUrl(r19);
        goto L121
    L115:
        r37 = false;
        goto L116
    L102:
        if (r18.length() <= 0) goto L104;
        boolean r38 = true;
    L105:
        if (r38 == true) goto L108;
        r18 = null;
    L108:
        if (r18 == null) goto L110;
        r9.tagForTemplateLoader(r18);
        goto L110
    L104:
        r38 = false;
        goto L105
    L91:
        if (r17.length() <= 0) goto L93;
        boolean r39 = true;
    L94:
        if (r39 == true) goto L97;
        r17 = null;
    L97:
        if (r17 == null) goto L99;
        r9.tagForJSModule(r17);
        goto L99
    L93:
        r39 = false;
        goto L94
    L80:
        if (r16.length() <= 0) goto L82;
        boolean r40 = true;
    L83:
        if (r40 == true) goto L86;
        r16 = null;
    L86:
        if (r16 == null) goto L88;
        r9.bridgeProtocolContainerId(r16);
        goto L88
    L82:
        r40 = false;
        goto L83
    L63:
        if (r13.length() <= 0) goto L65;
        boolean r41 = true;
    L66:
        if (r41 == true) goto L69;
        r13 = null;
    L69:
        if (r13 == null) goto L71;
        r9.tagForBridgeProtocol(r13);
        goto L71
    L65:
        r41 = false;
        goto L66
    L52:
        if (r12.length() <= 0) goto L54;
        boolean r42 = true;
    L55:
        if (r42 == true) goto L58;
        r12 = null;
    L58:
        if (r12 == null) goto L60;
        r9.tagForBridgeMethodGroup(r12);
        goto L60
    L54:
        r42 = false;
        goto L55
    L41:
        if (r11.length() <= 0) goto L43;
        boolean r43 = true;
    L44:
        if (r43 == true) goto L47;
        r11 = null;
    L47:
        if (r11 == null) goto L49;
        r9.tagForBridgeMethodDispatcher(r11);
        goto L49
    L43:
        r43 = false;
        goto L44
    L30:
        if (r10.length() <= 0) goto L32;
        boolean r44 = true;
    L33:
        if (r44 == true) goto L36;
        r10 = null;
    L36:
        if (r10 == null) goto L38;
        r9.tagForGlobalData(r10);
        goto L38
    L32:
        r44 = false;
        goto L33
    L19:
        if (r4.length() <= 0) goto L21;
        boolean r45 = true;
    L22:
        if (r45 == true) goto L25;
        r4 = null;
    L25:
        if (r4 == null) goto L27;
        r9.tagForCustomComponent(r4);
        goto L27
    L21:
        r45 = false;
        goto L22
    L8:
        if (r1.length() <= 0) goto L10;
        boolean r46 = true;
    L11:
        if (r46 == true) goto L14;
        r1 = null;
    L14:
        if (r1 == null) goto L16;
        r9.tagForJsContext(r1);
        goto L16
    L10:
        r46 = false;
        goto L11
    }
}
