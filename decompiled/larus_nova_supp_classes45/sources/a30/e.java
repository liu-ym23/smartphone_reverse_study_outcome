package a30;

import android.text.TextUtils;
import com.bytedance.android.live.browser.jsbridge.base.SetEffectComposerResultModel;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.a0;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.x;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import i12.o;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import w20.f6;
import w20.me;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e extends f6<me, SetEffectComposerResultModel> {

    public static final class a {
    }

    static {
    }

    public e() {
    }

    public final void invoke(Object r19, CallContext r21) {
        me r1 = (me) r19;
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r21, "context");
        boolean r3 = com.bytedance.android.livesdk.gift.platform.core.h.q();
        StringBuilder r4 = new StringBuilder();
        StringBuilder r5 = new StringBuilder();
        r5.append(r1.getName());
        r5.append(": nodePaths = ");
        List<String> r6 = r1.w();
        if (r6 == null) goto L5;
        String r7 = CollectionsKt.joinToString$default(r6, ",", "[", "]", 0, null, null, 56, null);
    L6:
        r5.append(r7);
        r5.append(", scene = ");
        r5.append(r1.getScene());
        r5.append(", channel = ");
        r5.append(r1.getChannel());
        r4.append(r5.toString());
        r4.append(", enableNewPkEffect = ");
        r4.append(r3);
        jy0.b.d("SetEffectComposerMethod", r4.toString());
        Class r8 = SetEffectComposerResultModel.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r9 = vh7.b.a;
        Object r11 = r9.get(r8);
        if (r11 != null) goto L16;
        r11 = r8.getConstructor(new Class[0]);
        if (r11 == null) goto L15;
        Object r12 = r9.putIfAbsent(r8, r11);
        if (r12 == null) goto L16;
        r11 = r12;
        goto L16
    L15:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L16:
        Object r13 = ((SerializableObjectJsonAdapterBase) ((Constructor) r11).newInstance(new Object[0])).createInstance();
        if (r13 == null) goto L215;
        SetEffectComposerResultModel r14 = (SetEffectComposerResultModel) r13;
        Class r15 = SetEffectComposerResultModel.b.class.getAnnotation(JsonAdapter.class).value();
        Object r16 = r9.get(r15);
        if (r16 != null) goto L28;
        r16 = r15.getConstructor(new Class[0]);
        if (r16 == null) goto L27;
        Object r17 = r9.putIfAbsent(r15, r16);
        if (r17 == null) goto L28;
        r16 = r17;
        goto L28
    L27:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L28:
        Object r18 = ((SerializableObjectJsonAdapterBase) ((Constructor) r16).newInstance(new Object[0])).createInstance();
        if (r18 == null) goto L213;
        r14.v8((SetEffectComposerResultModel.b) r18);
        String r22 = r1.getName();
        if (r22 != null) goto L34;
        return;
    L34:
        switch(r22.hashCode()) {
            case -860210598: goto L117;
            case 1389977506: goto L114;
            case 1478557334: goto L111;
            case 2101172676: goto L37;
            default: goto L238;
        };
    L238:
        return;
    L37:
        if (r22.equals("removeComposer") == false) goto L211;
        if (r3 == false) goto L89;
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r14, "result");
        GiftContext r2 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r2 == null) goto L44;
        com.bytedance.live.datacontext.m r23 = r2.getGiftRenderFilterWrapper();
        if (r23 == null) goto L44;
        ca0.i r24 = (ca0.i) r23.getValue();
    L45:
        if (r24 != null) goto L47;
        jy0.b.c("SetEffectComposerMethod", "giftRenderFilter is null", null, 4);
        finishWithFailure();
        return;
    L47:
        boolean r25 = m.g();
        jy0.b.a("SetEffectComposerMethod", "isLiveCore = " + r25);
        Object[] r26 = ((ArrayList) m.f(r1.w())).toArray(new String[0]);
        if (r26 == null) goto L88;
        String[] r27 = (String[]) r26;
        i r28 = new i(this);
        String r29 = r1.getChannel();
        i12.e r31 = o.b();
        if (r31 == null) goto L52;
        Object r32 = com.bytedance.android.scope.m.e.d(r31, x.class);
    L53:
        x r33 = (x) r32;
        if (r33 == null) goto L66;
        String r34 = r1.getScene();
        List r35 = ArraysKt.toList(r27);
        Intrinsics.checkNotNullParameter(r35, "nodePath");
        if (r34 != null) goto L58;
        String r110 = "default";
    L59:
        Set r36 = (Set) ((LinkedHashMap) r33.a).get(r110);
        if (r36 == null) goto L66;
        Set r37 = CollectionsKt.toMutableSet(r36);
        if (r37 == null) goto L66;
        r37.removeAll(CollectionsKt.toSet(r35));
        r33.a.put(r110, r37);
        goto L66
    L58:
        r110 = r34;
    L66:
        if (TextUtils.isEmpty(r29) == false) goto L68;
    L86:
        r24.c(r27, r28, r25);
        return;
    L68:
        if (a0.d() == true) goto L86;
        if (TextUtils.equals(r29, "renderFilter") == true) goto L86;
        if (TextUtils.equals(r29, "pk") == false) goto L78;
        ca0.b r38 = m.c();
        if (r38 == null) goto L85;
        r38.o(r27);
    L85:
        finishWithSuccess();
        return;
    L78:
        if (TextUtils.equals(r29, "pk_interact") == false) goto L82;
        ca0.b r39 = m.c();
        if (r39 == null) goto L85;
        r39.c(r27);
        goto L85
    L82:
        ca0.b r41 = m.c();
        if (r41 == null) goto L85;
        r41.i(r27);
        goto L85
    L52:
        r32 = null;
        goto L53
    L88:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L44:
        r24 = null;
        goto L45
    L89:
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r14, "result");
        jy0.b.a("SetEffectComposerMethod", "removeComposer, channel = " + r1.getChannel());
        if (m.e() == true) goto L93;
        jy0.b.c("SetEffectComposerMethod", "removeComposer, isInit() == false, return", null, 4);
        finishWithSuccess();
        return;
    L93:
        if (m.d() == true) goto L95;
        jy0.b.c("SetEffectComposerMethod", "removeComposer, isEnable() == false, return", null, 4);
        finishWithSuccess();
        return;
    L95:
        Object[] r42 = ((ArrayList) m.f(r1.w())).toArray(new String[0]);
        if (r42 == null) goto L109;
        String[] r43 = (String[]) r42;
        boolean r44 = m.g();
        jy0.b.a("SetEffectComposerMethod", "isLiveCore = " + r44);
        if (r44 == false) goto L103;
        ca0.b r45 = m.c();
        if (r45 == null) goto L102;
        r45.x(r43);
    L102:
        jy0.b.d("SetEffectComposerMethod", "removeComposer success, stickerHandler = " + r45);
        finishWithResult(r14);
        return;
    L103:
        or2.j r46 = m.a();
        if (r46 != null) goto L106;
        jy0.b.f("SetEffectComposerMethod", "removeComposer, livePlayerClient is null, JSB will not return!", null, 4);
    L106:
        if (r46 == null) goto L222;
        r46.h(r43, new h(this, r14));
        return;
    L222:
        return;
    L109:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L211:
        return;
    L111:
        if (r22.equals("getComposer") == false) goto L224;
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r14, "result");
        return;
    L224:
        return;
    L114:
        if (r22.equals("setComposer") == false) goto L226;
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r14, "result");
        return;
    L226:
        return;
    L117:
        if (r22.equals("appendComposer") == false) goto L228;
        String r47 = "";
        if (r3 == false) goto L178;
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r14, "result");
        GiftContext r48 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r48 == null) goto L125;
        com.bytedance.live.datacontext.m r49 = r48.getGiftRenderFilterWrapper();
        if (r49 == null) goto L125;
        ca0.i r51 = (ca0.i) r49.getValue();
    L126:
        if (r51 != null) goto L128;
        jy0.b.c("SetEffectComposerMethod", "giftRenderFilter is null", null, 4);
        finishWithFailure();
        return;
    L128:
        boolean r52 = m.g();
        jy0.b.a("SetEffectComposerMethod", "isLiveCore = " + r52);
        Object[] r53 = ((ArrayList) m.f(r1.w())).toArray(new String[0]);
        if (r53 == null) goto L177;
        String[] r54 = (String[]) r53;
        List<String> r55 = r1.getTags();
        if (r55 == null) goto L137;
        Object[] r56 = r55.toArray(new String[0]);
        if (r56 == null) goto L136;
        String[] r57 = (String[]) r56;
    L138:
        g r58 = new g(this);
        String r59 = r1.getChannel();
        i12.e r61 = o.b();
        if (r61 == null) goto L141;
        Object r62 = com.bytedance.android.scope.m.e.d(r61, x.class);
    L142:
        x r63 = (x) r62;
        if (r63 == null) goto L155;
        String r64 = r1.getScene();
        List r65 = ArraysKt.toList(r54);
        Intrinsics.checkNotNullParameter(r65, "nodePath");
        if (r64 != null) goto L147;
        String r111 = "default";
    L148:
        Set r66 = (Set) ((LinkedHashMap) r63.a).get(r111);
        if (r66 == null) goto L152;
        Set r67 = CollectionsKt.toMutableSet(r66);
        if (r67 == null) goto L152;
    L153:
        r67.addAll(CollectionsKt.toSet(r65));
        r63.a.put(r111, r67);
    L152:
        r67 = new LinkedHashSet();
        goto L153
    L147:
        r111 = r64;
    L155:
        if (TextUtils.isEmpty(r59) == false) goto L157;
    L175:
        r51.a(r54, r57, r58, r52);
        return;
    L157:
        if (a0.d() == true) goto L175;
        if (TextUtils.equals(r59, "renderFilter") == true) goto L175;
        if (TextUtils.equals(r59, "pk") == false) goto L167;
        ca0.b r68 = m.c();
        if (r68 == null) goto L174;
        r68.k(r54, r57);
    L174:
        finishWithSuccess();
        return;
    L167:
        if (TextUtils.equals(r59, "pk_interact") == false) goto L171;
        ca0.b r69 = m.c();
        if (r69 == null) goto L174;
        r69.w(r54, r57);
        goto L174
    L171:
        ca0.b r71 = m.c();
        if (r71 == null) goto L174;
        r71.f(r54, r57);
        goto L174
    L141:
        r62 = null;
        goto L142
    L136:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L137:
        r57 = new String[]{""};
        goto L138
    L177:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L125:
        r51 = null;
        goto L126
    L178:
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r14, "result");
        jy0.b.a("SetEffectComposerMethod", "appendComposer, channel = " + r1.getChannel());
        if (m.e() == true) goto L182;
        jy0.b.c("SetEffectComposerMethod", "appendComposer, isInit() == false, return", null, 4);
        finishWithSuccess();
        return;
    L182:
        if (m.d() == true) goto L184;
        jy0.b.c("SetEffectComposerMethod", "appendComposer, isEnable() == false, return", null, 4);
        finishWithSuccess();
        return;
    L184:
        Object[] r72 = ((ArrayList) m.f(r1.w())).toArray(new String[0]);
        if (r72 == null) goto L210;
        String[] r73 = (String[]) r72;
        List<String> r74 = r1.getTags();
        if (r74 == null) goto L193;
        Object[] r75 = r74.toArray(new String[0]);
        if (r75 == null) goto L192;
        String[] r76 = (String[]) r75;
    L194:
        String r77 = r1.getScene();
        if (r77 == null) goto L198;
        r47 = r77;
    L198:
        boolean r78 = m.g();
        jy0.b.a("SetEffectComposerMethod", "isLiveCore = " + r78);
        if (r78 == false) goto L204;
        ca0.b r79 = m.c();
        if (r79 == null) goto L203;
        r79.d(r73, r76);
    L203:
        jy0.b.d("SetEffectComposerMethod", "appendComposer success, stickerHandler = " + r79);
        finishWithResult(r14);
        return;
    L204:
        or2.j r81 = m.a();
        if (r81 != null) goto L207;
        jy0.b.f("SetEffectComposerMethod", "appendComposer, livePlayerClient is null, JSB will not return!", null, 4);
    L207:
        if (r81 == null) goto L235;
        r81.a(r73, r76, new f(this, r47, r73, r14));
        return;
    L235:
        return;
    L192:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L193:
        r76 = new String[]{""};
        goto L194
    L210:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L228:
        return;
    L213:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.browser.jsbridge.base.SetEffectComposerResultModel.SetEffectComposerData");
    L215:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.browser.jsbridge.base.SetEffectComposerResultModel");
    L5:
        r7 = null;
        goto L6
    }
}
