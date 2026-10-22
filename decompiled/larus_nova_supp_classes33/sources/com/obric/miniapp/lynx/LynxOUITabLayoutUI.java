package com.obric.miniapp.lynx;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.material.OMaterialHelper;
import com.obric.oui.tab.OTabLayout;
import com.obric.oui.tab.OTabLayoutBase;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0007\u0018\u0000 =2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003=>?B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fH\u0007J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\fH\u0007J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\b\u0010\u001e\u001a\u00020\u0014H\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0002J\u0012\u0010 \u001a\u00020\u00142\b\u0010!\u001a\u0004\u0018\u00010\nH\u0002J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u000e2\u0006\u0010$\u001a\u00020\bH\u0002J\u001a\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(H\u0002J\u001a\u0010)\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\n2\b\u0010*\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010+\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\n2\b\u0010,\u001a\u0004\u0018\u00010\bH\u0002J\"\u0010-\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\n2\u0006\u0010.\u001a\u00020\f2\b\u0010/\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u00100\u001a\u00020\fH\u0002J\u0018\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u00020\u000f2\u0006\u00103\u001a\u000204H\u0002J\u0018\u00105\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u00106\u001a\u0004\u0018\u000107H\u0002J\u0018\u00108\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u00109\u001a\u00020\u001dH\u0002J\u0019\u0010:\u001a\u0004\u0018\u00010\u001d2\b\u00106\u001a\u0004\u0018\u000107H\u0002¢\u0006\u0002\u0010;J\b\u0010<\u001a\u00020\fH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/obric/miniapp/lynx/LynxOUITabLayoutUI;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/FrameLayout;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "optionsJson", "Lorg/json/JSONObject;", "tabLayout", "Lcom/obric/oui/tab/OTabLayoutBase;", "suppressEvent", "", "titlesCache", "", "", "disabledCache", "createView", "Landroid/content/Context;", "updatePropertiesInterval", "", "props", "Lcom/lynx/tasm/behavior/StylesDiffMap;", "setOptions", "options", "setDisabled", "disabled", "setSelectedIndex", "index", "", "destroy", "rebuildTabs", "applyTabEnabledState", "tabs", "parseTabItems", "Lcom/obric/miniapp/lynx/LynxOUITabLayoutUI$TabItem;", "json", "resolveDrawable", "Landroid/graphics/drawable/Drawable;", "icon", "Lcom/obric/miniapp/lynx/LynxOUITabLayoutUI$IconSpec;", "applyIndicatorOptions", "indicator", "applyStyleOptions", "style", "applyMaterialIfNeeded", "enable", "token", "isMaterialEffectEnabledReflect", "sendEvent", "type", "tab", "Lcom/obric/oui/tab/OTabLayoutBase$Tab;", "parseTitles", "any", "", "dpToPx", "dp", "parseColor", "(Ljava/lang/Object;)Ljava/lang/Integer;", "isDarkTheme", "Companion", "TabItem", "IconSpec", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LynxOUITabLayoutUI extends LynxUI<FrameLayout> {
    public JSONObject a;
    public OTabLayout b;
    public boolean c;
    public List<String> d;
    public boolean e;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final Integer b;

        /* JADX WARN: Multi-variable type inference failed */
        public b() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Integer r4 = this.b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "IconSpec(resName=" + this.a + ", resId=" + this.b + ')';
        }

        public b(String r1, Integer r2) {
            this.a = r1;
            this.b = r2;
        }

        public /* synthetic */ b(String r3, Integer r4, int r5) {
            if ((r5 & 1) == 0) goto L6;
            r3 = null;
        L6:
            if ((r5 & 2) == 0) goto L8;
            r4 = null;
        L8:
            this(r3, r4);
        }
    }

    public static final class c {
        public final String a;
        public final b b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            b r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "TabItem(title=" + this.a + ", icon=" + this.b + ')';
        }

        public c(String r2, b r3) {
            Intrinsics.checkNotNullParameter(r2, "title");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public final void destroy() {
        this.b = null;
        super.destroy();
    }

    public LynxOUITabLayoutUI(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.d = CollectionsKt.emptyList();
        if (r2.getDefaultOverflowVisible() == false) goto L6;
        ((LynxBaseUI) this).mOverflow = 3;
        return;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class M(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r2 = Class.forName(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class<?> r4 = Class.forName(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public final Integer S(Object r2) {
        OTabLayout r0 = this.b;
        if (r0 == null) goto L5;
        Context r1 = r0.getContext();
    L7:
        return o1.E(r2, r1);
    L5:
        r1 = null;
        goto L7
    }

    public final View createView(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        h6 r0 = new h6(r6);
        r0.setMinimumHeight(R(r6, 56));
        r0.setClipChildren(false);
        r0.setClipToPadding(false);
        r0.setClipToOutline(false);
        GradientDrawable r2 = new GradientDrawable();
        r2.setColor(0);
        r0.setBackground(r2);
        View r3 = LayoutInflater.from(r6).inflate(2131563666, r0, false);
        if ((r3 instanceof OTabLayout) == false) goto L5;
        OTabLayout r4 = (OTabLayout) r3;
    L6:
        if (r4 != null) goto L8;
        r4 = new OTabLayout(r6, null);
    L8:
        r4.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        r4.setClipChildren(false);
        r4.setClipToPadding(false);
        r4.setClipToOutline(false);
        g4 r7 = new g4(this);
        if (((OTabLayoutBase) r4).R.contains(r7) == true) goto L11;
        ((OTabLayoutBase) r4).R.add(r7);
    L11:
        this.b = r4;
        r4.setEnabled(!this.e);
        r0.addView(r4);
        return r0;
    L5:
        r4 = null;
        goto L6
    }

    @LynxProp(name = "disabled")
    public final void setDisabled(boolean r2) {
        this.e = r2;
        OTabLayout r0 = this.b;
        if (r0 == null) goto L7;
        r0.setEnabled(!r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v23, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v26, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v31, types: [java.util.ArrayList] */
    @LynxProp(name = "options")
    public final void setOptions(String r23) {
        if (r23 != null) goto L5;
    L17:
        JSONObject r0 = null;
    L18:
        this.a = r0;
        if (r23 == null) goto L21;
        int r1 = r23.length();
    L22:
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("setOptions len=");
        r5.append(r1);
        r5.append(" parsed=");
        if (this.a == null) goto L25;
        boolean r2 = true;
    L26:
        r5.append(r2);
        String r3 = r5.toString();
        String r6 = "LynxOUITabLayoutUI";
        r4.i("LynxOUITabLayoutUI", r3);
        JSONObject r7 = this.a;
        if (r7 != null) goto L29;
    L34:
        JSONObject r8 = this.a;
        if (r8 == null) goto L212;
        OTabLayout r9 = this.b;
        if (r9 == null) goto L213;
        int r10 = r8.optInt("selectedIndex", 0);
        String r11 = r8.optString("mode");
        String r12 = r8.optString("gravity");
        boolean r13 = r8.optBoolean("autoFillWhenScrollable", false);
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L47
        Object r15 = M("com.obric.oui.material.OMaterialHelper").getMethod("isMaterialEffectEnabled", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L47
        if ((r15 instanceof Boolean) == false) goto L44;
        Boolean r16 = (Boolean) r15;     // Catch: Throwable -> L47
    L45:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L47
    L50:
        if (Result.isFailure-impl(r17) == false) goto L52;
        r17 = null;
    L52:
        Boolean r18 = (Boolean) r17;
        if (r18 == null) goto L55;
        boolean r19 = r18.booleanValue();
    L56:
        boolean r110 = r8.optBoolean("enableMaterial", r19);
        String r20 = r8.optString("materialToken");
        Intrinsics.checkNotNull(r20);
        if ((!StringsKt.isBlank(r20)) == false) goto L59;
        String r111 = r20;
    L60:
        JSONObject r112 = r8.optJSONObject("indicator");
        JSONObject r113 = r8.optJSONObject("style");
        JSONArray r21 = r8.optJSONArray("tabs");
        if (r21 == null) goto L111;
        ArrayList r22 = new ArrayList();
        int r24 = r21.length();
        int r25 = 0;
    L63:
        if (r25 >= r24) goto L108;
        int r114 = r24;
        JSONObject r26 = r21.optJSONObject(r25);
        JSONArray r115 = r21;
        if (r26 == null) goto L72;
        String r27 = r26.optString("title");
        Intrinsics.checkNotNull(r27);
        if ((!StringsKt.isBlank(r27)) == true) goto L71;
        r27 = null;
    L71:
        if (r27 == null) goto L72;
        Object r28 = r26.opt("icon");
        if ((r28 instanceof JSONObject) == false) goto L87;
        JSONObject r29 = (JSONObject) r28;
        String r30 = r29.optString("resName");
        Intrinsics.checkNotNull(r30);
        if ((!StringsKt.isBlank(r30)) == true) goto L79;
        r30 = null;
    L79:
        Integer r31 = Integer.valueOf(r29.optInt("resId"));
        if (r31.intValue() <= 0) goto L82;
        boolean r32 = true;
    L83:
        if (r32 == true) goto L86;
        r31 = null;
    L86:
        b r33 = new b(r30, r31);
    L94:
        b r116 = r33;
    L106:
        r22.add(new c(r27, r116));
    L107:
        r25 = r25 + 1;
        r24 = r114;
        r21 = r115;
        r6 = r6;
        r10 = r10;
        r110 = r110;
        goto L63
    L82:
        r32 = false;
        goto L83
    L87:
        r10 = r10;
        if ((r28 instanceof String) == true) goto L90;
        r110 = r110;
        if ((r28 instanceof Number) == false) goto L105;
        Integer r34 = Integer.valueOf(((Number) r28).intValue());
        if (r34.intValue() <= 0) goto L100;
        boolean r35 = true;
    L101:
        if (r35 == true) goto L104;
        r34 = null;
    L104:
        r116 = new b(null, r34, 1);
        goto L106
    L100:
        r35 = false;
        goto L101
    L105:
        r116 = null;
        goto L106
    L90:
        if ((!StringsKt.isBlank((String) r28)) == true) goto L93;
        r28 = null;
    L93:
        r33 = new b((String) r28, null, 2);
    L72:
        r10 = r10;
        r110 = r110;
        goto L107
    L108:
        String r117 = r6;
        int r210 = r10;
        boolean r211 = r110;
        if ((!r22.isEmpty()) == true) goto L147;
    L112:
        Object r36 = r8.opt("titles");
        if ((r36 instanceof JSONArray) == false) goto L124;
        JSONArray r37 = (JSONArray) r36;
        IntRange r38 = RangesKt.until(0, r37.length());
        ?? r39 = new ArrayList();
        IntIterator r40 = r38.iterator();
    L116:
        if (r40.hasNext() == false) goto L143;
        String r118 = r37.optString(r40.nextInt());
        Intrinsics.checkNotNull(r118);
        if ((!StringsKt.isBlank(r118)) == true) goto L121;
        r118 = null;
    L121:
        if (r118 == null) goto L116;
        r39.add(r118);
    L143:
        Iterable r41 = (Iterable) r39;
        r22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r41, 10));
        Iterator r42 = r41.iterator();
    L145:
        if (r42.hasNext() == false) goto L147;
        r22.add(new c((String) r42.next(), null));
        goto L145
    L124:
        if ((r36 instanceof String) == true) goto L189;
        r39 = CollectionsKt.emptyList();
        goto L143
    L189:
        Result.Companion r43 = Result.Companion;     // Catch: Throwable -> L136
        JSONArray r44 = new JSONArray((String) r36);     // Catch: Throwable -> L136
        IntRange r45 = RangesKt.until(0, r44.length());     // Catch: Throwable -> L136
        ArrayList r46 = new ArrayList();     // Catch: Throwable -> L136
        IntIterator r47 = r45.iterator();     // Catch: Throwable -> L136
    L127:
        if (r47.hasNext() == false) goto L134;
        String r119 = r44.optString(r47.nextInt());     // Catch: Throwable -> L136
        Intrinsics.checkNotNull(r119);     // Catch: Throwable -> L136
        if ((!StringsKt.isBlank(r119)) == true) goto L132;
        r119 = null;
    L132:
        if (r119 == null) goto L127;
        r46.add(r119);     // Catch: Throwable -> L136
        goto L127
    L134:
        Object r48 = Result.constructor-impl(r46);     // Catch: Throwable -> L136
    L138:
        List r49 = CollectionsKt.emptyList();
        if (Result.isFailure-impl(r48) == false) goto L141;
        r48 = r49;
    L141:
        r39 = (List) r48;
    L136:
        th = move-exception;
        Result.Companion r50 = Result.Companion;
        r48 = Result.constructor-impl(ResultKt.createFailure(th));
    L147:
        ArrayList r51 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));
        Iterator r52 = r22.iterator();
    L149:
        if (r52.hasNext() == false) goto L151;
        r51.add(((c) r52.next()).a);
        goto L149
    L151:
        this.c = true;
        Result.Companion r53 = Result.Companion;     // Catch: Throwable -> L178
        r9.u();     // Catch: Throwable -> L178
        Iterator r54 = r22.iterator();     // Catch: Throwable -> L178
    L154:
        if (r54.hasNext() == false) goto L162;
        c r55 = (c) r54.next();     // Catch: Throwable -> L178
        OTabLayoutBase.i r56 = r9.s(0);     // Catch: Throwable -> L178
        r56.b = r55.a;     // Catch: Throwable -> L178
        r56.b();     // Catch: Throwable -> L178
        b r57 = r55.b;     // Catch: Throwable -> L178
        if (r57 == null) goto L160;
        Drawable r58 = T(r9.getContext(), r57);     // Catch: Throwable -> L178
        if (r58 == null) goto L160;
        r56.a = r58;     // Catch: Throwable -> L178
        r56.b();     // Catch: Throwable -> L178
    L160:
        r9.h(r56);     // Catch: Throwable -> L178
        goto L154
    L162:
        if (Intrinsics.areEqual(r11, "scrollable") == false) goto L165;
        r9.setTabMode(0);     // Catch: Throwable -> L178
    L168:
        if (Intrinsics.areEqual(r12, "fill") == false) goto L171;
        r9.setTabGravity(0);     // Catch: Throwable -> L178
    L173:
        r9.setAutoFillWhenScrollable(r13);     // Catch: Throwable -> L178
        O(r9, r112);     // Catch: Throwable -> L178
        Q(r9, r113);     // Catch: Throwable -> L178
        P(r9, r211, r111);     // Catch: Throwable -> L178
        int r59 = RangesKt.coerceIn(r210, 0, RangesKt.coerceAtLeast(r51.size() - 1, 0));     // Catch: Throwable -> L178
        if ((!r51.isEmpty()) == false) goto L176;
        r9.v(r59);     // Catch: Throwable -> L178
    L176:
        Object r60 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L178
    L180:
        Throwable r61 = Result.exceptionOrNull-impl(r60);
        if (r61 == null) goto L183;
        FLogger.a.e(r117, "rebuildTabs failed", r61);
    L183:
        this.c = false;
        this.d = r51;
        r9.setEnabled(!this.e);
        return;
    L171:
        if (Intrinsics.areEqual(r12, "center") == false) goto L173;
        r9.setTabGravity(1);     // Catch: Throwable -> L178
        goto L173
    L165:
        if (Intrinsics.areEqual(r11, "fixed") == false) goto L168;
        r9.setTabMode(1);     // Catch: Throwable -> L178
    L178:
        th = move-exception;
        Result.Companion r62 = Result.Companion;
        r60 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L180
    L111:
        r117 = "LynxOUITabLayoutUI";
        r210 = r10;
        r211 = r110;
        goto L112
    L59:
        r111 = null;
        goto L60
    L55:
        r19 = false;
        goto L56
    L44:
        r16 = null;
    L47:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L50
    L213:
        return;
    L212:
        return;
    L29:
        if (r7.has("disabled") == true) goto L32;
        r7 = null;
    L32:
        if (r7 == null) goto L34;
        setDisabled(r7.optBoolean("disabled", false));
        goto L34
    L25:
        r2 = false;
        goto L26
    L21:
        r1 = -1;
        goto L22
    L5:
        if ((!StringsKt.isBlank(r23)) == false) goto L7;
        String r63 = r23;
    L8:
        if (r63 == null) goto L17;
        Result.Companion r64 = Result.Companion;     // Catch: Throwable -> L11
        Object r65 = Result.constructor-impl(new JSONObject(r63));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r65) == false) goto L16;
        r65 = null;
    L16:
        r0 = (JSONObject) r65;
    L11:
        th = move-exception;
        Result.Companion r66 = Result.Companion;
        r65 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L7:
        r63 = null;
        goto L8
    }

    @LynxProp(name = "selectedIndex")
    public final void setSelectedIndex(int r3) {
        OTabLayout r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r3 >= 0) goto L7;
        return;
    L7:
        if (r3 >= r0.getTabCount()) goto L19;
        this.c = true;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        r0.v(r3);     // Catch: Throwable -> L12
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        this.c = false;
        return;
    L12:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    }

    public final void updatePropertiesInterval(com.lynx.tasm.behavior.x0 r13) {
        Intrinsics.checkNotNullParameter(r13, "props");
        super/*com.lynx.tasm.behavior.ui.LynxBaseUI*/.updatePropertiesInterval(o1.S(r13, this.a, new String[]{"titles", "tabs", "selectedIndex", "disabled", "mode", "gravity", "autoFillWhenScrollable", "enableMaterial", "materialToken", "indicator", "style"}, new String[]{"titles", "tabs", "indicator", "style"}, 2));
    }

    public static Drawable T(Context r4, b r5) {
        Integer r0 = r5.b;
        Object r1 = null;
        if (r0 == null) goto L15;
        int r6 = r0.intValue();
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        Object r7 = Result.constructor-impl(ContextCompat.getDrawable(r4, r6));     // Catch: Throwable -> L7
    L10:
        if (Result.isFailure-impl(r7) == true) goto L14;
        r1 = r7;
    L14:
        return (Drawable) r1;
    L7:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    L15:
        String r9 = r5.a;
        if (r9 == null) goto L40;
        String r10 = StringsKt.trim(r9).toString();
        if (r10 == null) goto L41;
        String r11 = StringsKt.removePrefix(r10, "@drawable/");
        if (r11 == null) goto L42;
        String r12 = StringsKt.removePrefix(r11, "drawable/");
        if (r12 == null) goto L44;
        int r13 = r4.getResources().getIdentifier(r12, "drawable", r4.getPackageName());
        if (r13 == 0) goto L43;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L28
        Object r14 = Result.constructor-impl(ContextCompat.getDrawable(r4, r13));     // Catch: Throwable -> L28
    L31:
        if (Result.isFailure-impl(r14) == true) goto L35;
        r1 = r14;
    L35:
        return (Drawable) r1;
    L28:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    L43:
        return null;
    L44:
        return null;
    L42:
        return null;
    L41:
        return null;
    L40:
        return null;
    }

    public final void O(OTabLayout r4, JSONObject r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        Object r0 = r5.opt("showTopLine");
        if (r0 != null) goto L7;
    L9:
        Object r1 = r5.opt("showSelectedIndicator");
        if (r1 != null) goto L12;
    L14:
        Object r2 = r5.opt("heightDp");
        Number r3 = null;
        if (r2 != null) goto L17;
    L24:
        Object r6 = r5.opt("horizontalPaddingDp");
        if (r6 != null) goto L27;
    L34:
        Object r7 = r5.opt("cornerRadiusDp");
        if (r7 != null) goto L37;
    L43:
        Integer r8 = S(r5.opt("color"));
        Integer r9 = S(r5.opt("unselectedColor"));
        if (r8 == null) goto L47;
        if (r9 == null) goto L47;
        int r10 = r8.intValue();
        int r11 = r9.intValue();
        ((OTabLayoutBase) r4).G1 = 0;
        ((OTabLayoutBase) r4).L0 = r10;
        ((OTabLayoutBase) r4).P0 = r11;
        ((OTabLayoutBase) r4).H1 = false;
        r4.B();
        r4.invalidate();
        ((OTabLayoutBase) r4).t.invalidate();
    L49:
        Object r12 = r5.opt("animEnable");
        if (r12 != null) goto L52;
    L54:
        Object r13 = r5.opt("bounceEnable");
        if (r13 != null) goto L57;
        return;
    L57:
        if ((r13 instanceof Boolean) == false) goto L61;
        r4.setIndicatorBounceEnable(((Boolean) r13).booleanValue());
        return;
    L61:
        return;
    L52:
        if ((r12 instanceof Boolean) == false) goto L54;
        r4.setIndicatorAnimEnable(((Boolean) r12).booleanValue());
    L47:
        if (r8 == null) goto L49;
        r4.setSelectedTabIndicatorColor(r8.intValue());
        goto L49
    L37:
        if ((r7 instanceof Number) == false) goto L39;
        r3 = (Number) r7;
    L39:
        if (r3 == null) goto L43;
        int r14 = r3.intValue();
        if (r14 < 0) goto L43;
        r4.setIndicatorCornerRadius(R(r4.getContext(), r14));
        goto L43
    L27:
        if ((r6 instanceof Number) == false) goto L29;
        Number r15 = (Number) r6;
    L30:
        if (r15 == null) goto L34;
        int r16 = r15.intValue();
        if (r16 < 0) goto L34;
        r4.setSelectedTabHorizontalPadding(R(r4.getContext(), r16));
        goto L34
    L29:
        r15 = null;
        goto L30
    L17:
        if ((r2 instanceof Number) == false) goto L19;
        Number r17 = (Number) r2;
    L20:
        if (r17 == null) goto L24;
        int r18 = r17.intValue();
        if (r18 <= 0) goto L24;
        r4.setSelectedTabIndicatorHeight(R(r4.getContext(), r18));
        goto L24
    L19:
        r17 = null;
        goto L20
    L12:
        if ((r1 instanceof Boolean) == false) goto L14;
        r4.setShowSelectedIndicator((Boolean) r1);
        goto L14
    L7:
        if ((r0 instanceof Boolean) == false) goto L9;
        r4.setShowTopLine((Boolean) r0);
        goto L9
    }

    public final void Q(OTabLayout r10, JSONObject r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        Object r0 = r11.opt("tabMarginDp");
        Number r2 = null;
        if ((r0 instanceof Number) == false) goto L7;
        Number r1 = (Number) r0;
    L8:
        if (r1 == null) goto L12;
        int r3 = r1.intValue();
        if (r3 < 0) goto L12;
        r10.setTabMargin(r3);
    L12:
        Object r4 = r11.opt("tabSideMarginDp");
        if ((r4 instanceof Number) == false) goto L15;
        Number r5 = (Number) r4;
    L16:
        if (r5 == null) goto L18;
        Integer r6 = Integer.valueOf(r5.intValue());
    L19:
        Object r7 = r11.opt("tabTopMarginDp");
        if ((r7 instanceof Number) == false) goto L22;
        Number r8 = (Number) r7;
    L23:
        if (r8 == null) goto L25;
        Integer r9 = Integer.valueOf(r8.intValue());
    L26:
        if (r6 == null) goto L35;
        if (r9 == null) goto L35;
        if (r6.intValue() < 0) goto L35;
        if (r9.intValue() < 0) goto L35;
        int r12 = r6.intValue();
        int r13 = r9.intValue();
        ((OTabLayoutBase) r10).w = r10.o(r12);
        if (((OTabLayoutBase) r10).F <= r10.o(20)) goto L35;
        ((OTabLayoutBase) r10).x = r10.o(r13);
    L35:
        JSONObject r14 = r11.optJSONObject("tabStripPadding");
        if (r14 == null) goto L38;
        r10.z(R(r10.getContext(), r14.optInt("leftDp", 0)), R(r10.getContext(), r14.optInt("topDp", 0)), R(r10.getContext(), r14.optInt("rightDp", 0)), R(r10.getContext(), r14.optInt("bottomDp", 0)));
    L38:
        JSONObject r15 = r11.optJSONObject("tabPadding");
        if (r15 == null) goto L71;
        Object r16 = r15.opt("startDp");
        if (r16 != null) goto L43;
    L48:
        Object r17 = r15.opt("topDp");
        if (r17 != null) goto L51;
    L56:
        Object r18 = r15.opt("endDp");
        if (r18 != null) goto L59;
    L64:
        Object r19 = r15.opt("bottomDp");
        if (r19 == null) goto L71;
        if ((r19 instanceof Number) == false) goto L69;
        r2 = (Number) r19;
    L69:
        if (r2 == null) goto L71;
        r10.setTabPaddingBottom(R(r10.getContext(), r2.intValue()));
        goto L71
    L59:
        if ((r18 instanceof Number) == false) goto L61;
        Number r20 = (Number) r18;
    L62:
        if (r20 == null) goto L64;
        r10.setTabPaddingEnd(R(r10.getContext(), r20.intValue()));
        goto L64
    L61:
        r20 = null;
        goto L62
    L51:
        if ((r17 instanceof Number) == false) goto L53;
        Number r21 = (Number) r17;
    L54:
        if (r21 == null) goto L56;
        r10.setTabPaddingTop(R(r10.getContext(), r21.intValue()));
        goto L56
    L53:
        r21 = null;
        goto L54
    L43:
        if ((r16 instanceof Number) == false) goto L45;
        Number r22 = (Number) r16;
    L46:
        if (r22 == null) goto L48;
        r10.setTabPaddingStart(R(r10.getContext(), r22.intValue()));
        goto L48
    L45:
        r22 = null;
    L71:
        boolean r23 = r11.optBoolean("enableCustomColors", false);
        Integer r24 = S(r11.opt("textColor"));
        Integer r25 = S(r11.opt("selectedTextColor"));
        if (r23 == false) goto L76;
        if (r24 == null) goto L76;
        if (r25 == null) goto L76;
        r10.setTabTextColors(OTabLayoutBase.n(r24.intValue(), r25.intValue()));
    L76:
        Integer r26 = S(r11.opt("barColor"));
        Integer r27 = S(r11.opt("indicatorColor"));
        Integer r28 = S(r11.opt("indicatorUnselectedColor"));
        String r110 = r11.optString("backgroundMode");
        if (r23 == true) goto L80;
        return;
    L80:
        if (Intrinsics.areEqual(r110, "show_tab_and_indicator") == false) goto L85;
        if (r26 == null) goto L90;
        if (r27 == null) goto L91;
        int r111 = r26.intValue();
        int r29 = r27.intValue();
        ((OTabLayoutBase) r10).G1 = r111;
        ((OTabLayoutBase) r10).L0 = r29;
        ((OTabLayoutBase) r10).H1 = true;
        r10.B();
        r10.invalidate();
        ((OTabLayoutBase) r10).t.invalidate();
        return;
    L91:
        return;
    L90:
        return;
    L85:
        if (Intrinsics.areEqual(r110, "indicator_only") == false) goto L93;
        if (r27 == null) goto L94;
        if (r28 == null) goto L95;
        int r112 = r27.intValue();
        int r30 = r28.intValue();
        ((OTabLayoutBase) r10).G1 = 0;
        ((OTabLayoutBase) r10).L0 = r112;
        ((OTabLayoutBase) r10).P0 = r30;
        ((OTabLayoutBase) r10).H1 = false;
        r10.B();
        r10.invalidate();
        ((OTabLayoutBase) r10).t.invalidate();
        return;
    L95:
        return;
    L94:
        return;
    L93:
        return;
    L25:
        r9 = null;
        goto L26
    L22:
        r8 = null;
        goto L23
    L18:
        r6 = null;
        goto L19
    L15:
        r5 = null;
        goto L16
    L7:
        r1 = null;
        goto L8
    }

    public final int R(Context r2, int r3) {
        Resources r4 = r2.getResources();
        return (int) (r3 * WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).density);
    }

    public static final void N(LynxOUITabLayoutUI r3, String r4, OTabLayoutBase.i r5) {
        LynxContext r0 = r3.getLynxContext();
        if (r0 == null) goto L25;
        EventEmitter r1 = r0.getEventEmitter();
        if (r1 == null) goto L26;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L9
        Object r6 = Result.constructor-impl(Integer.valueOf(r5.d));     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r6) == false) goto L14;
        r6 = null;
    L14:
        Integer r7 = (Integer) r6;
        if (r7 == null) goto L17;
        int r8 = r7.intValue();
    L18:
        String r9 = (String) CollectionsKt.getOrNull(r3.d, r8);
        m7a.a r10 = new m7a.a(r3.getSign(), r4);
        r10.a("index", Integer.valueOf(r8));
        r10.a("value", Integer.valueOf(r8));
        if (r9 == null) goto L21;
        r10.a("title", r9);
    L21:
        r1.sendCustomEvent(r10);
        return;
    L17:
        r8 = -1;
    L9:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L26:
        return;
    }

    public final void P(OTabLayout r9, boolean r10, String r11) {
        if (r10 == true) goto L4;
        return;
    L4:
        if (r11 != null) goto L6;
        r11 = "regular_1";
    L6:
        com.obric.oui.material.c r12 = o1.P(r11, r9.getContext());
        if (r12 == null) goto L34;
        Integer r13 = OMaterialHelper.a;
        Resources r14 = Resources.getSystem();
        OMaterialHelper.v(r9, 2, r12, WindowDisplayMetricsOverride.apply(r14, r14.getDisplayMetrics()).density);
        GradientDrawable r15 = new GradientDrawable();
        r15.setShape(0);
        r15.setCornerRadius(99.0f);
        r15.setColor(0);
        r9.setBackground(r15);
        r9.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        r9.setClipToOutline(false);
        return;
    L34:
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L28
        Method r17 = M("com.obric.oui.material.MaterialToken").getMethod("parse", new Class[]{String.class, Boolean.TYPE});     // Catch: Throwable -> L28
        Object[] r3 = new Object[2];     // Catch: Throwable -> L28
        r3[0] = r11;     // Catch: Throwable -> L28
        OTabLayout r18 = this.b;     // Catch: Throwable -> L28
        if (r18 == null) goto L19;
        Resources r19 = r18.getResources();     // Catch: Throwable -> L28
        if (r19 == null) goto L19;
        Configuration r110 = r19.getConfiguration();     // Catch: Throwable -> L28
        if (r110 == null) goto L19;
        if ((r110.uiMode & 48) != 32) goto L19;
        boolean r111 = true;
    L20:
        if (r111 == true) goto L22;
        boolean r112 = true;
    L23:
        r3[1] = Boolean.valueOf(r112);     // Catch: Throwable -> L28
        Object r113 = r17.invoke(null, r3);     // Catch: Throwable -> L28
        if (r113 != null) goto L26;
        return;
    L26:
        M("com.obric.oui.material.OMaterialHelper").getMethod("setMaterial", new Class[]{View.class, M("com.obric.oui.material.MaterialConfig")}).invoke(null, new Object[]{r9, r113});     // Catch: Throwable -> L28
        GradientDrawable r114 = new GradientDrawable();     // Catch: Throwable -> L28
        r114.setShape(0);     // Catch: Throwable -> L28
        r114.setCornerRadius(99.0f);     // Catch: Throwable -> L28
        r114.setColor(0);     // Catch: Throwable -> L28
        r9.setBackground(r114);     // Catch: Throwable -> L28
        r9.setOutlineProvider(ViewOutlineProvider.BACKGROUND);     // Catch: Throwable -> L28
        r9.setClipToOutline(false);     // Catch: Throwable -> L28
        Object r20 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L31:
        if (Result.exceptionOrNull-impl(r20) == null) goto L36;
        FLogger.a.i("LynxOUITabLayoutUI", "applyMaterial skipped (material classes not found or failed)");
        return;
    L36:
        return;
    L22:
        r112 = false;
    L19:
        r111 = false;
    L28:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    }
}
