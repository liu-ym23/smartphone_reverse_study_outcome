package com.obric.miniapp.lynx;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.behavior.LynxContext;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.common.oui.BuildConfig;
import com.obric.common.oui.R;
import com.obric.memorydata.sdk.entity.search.SearchError;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OButtonFloating;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.button.OIconButton;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.material.MaterialToken;
import com.obric.oui.text.OTextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class o1 {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReadableType.values().length];
            r0[ReadableType.Map.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[ReadableType.Array.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[ReadableType.Null.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[ReadableType.Boolean.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[ReadableType.Int.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[ReadableType.Long.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[ReadableType.Number.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[ReadableType.String.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    public static final Float F(Object r1) {
        if ((r1 instanceof Number) == false) goto L6;
        return Float.valueOf(((Number) r1).floatValue());
    L6:
        if ((r1 instanceof String) == true) goto L11;
        return null;
    L11:
        return StringsKt.toFloatOrNull(StringsKt.removeSuffix(StringsKt.removeSuffix(StringsKt.removeSuffix(StringsKt.trim((String) r1).toString(), "dp"), "sp"), "px"));
    }

    public static final JSONObject G(String r2) {
        Object r0 = null;
        if (r2 != null) goto L5;
        return null;
    L5:
        if ((!StringsKt.isBlank(r2)) == true) goto L8;
        r2 = null;
    L8:
        if (r2 == null) goto L22;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        Object r3 = Result.constructor-impl(new JSONObject(r2));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r3) == true) goto L18;
        r0 = r3;
    L18:
        return (JSONObject) r0;
    L11:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L22:
        return null;
    }

    public static final List<String> H(Object r9) {
        if ((r9 instanceof JSONArray) == false) goto L18;
        JSONArray r10 = (JSONArray) r9;
        IntRange r0 = RangesKt.until(0, r10.length());
        ArrayList r1 = new ArrayList();
        IntIterator r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L37;
        int r3 = r2.nextInt();
        JSONObject r4 = r10.optJSONObject(r3);
        if (r4 == null) goto L11;
        String r5 = C(r4, new String[]{"title", "label", "text", "name", "value"});
        if (r5 == null) goto L11;
    L15:
        if (r5 == null) goto L6;
        r1.add(r5);
    L11:
        r5 = r10.optString(r3);
        Intrinsics.checkNotNull(r5);
        if ((!StringsKt.isBlank(r5)) == true) goto L15;
        r5 = null;
        goto L15
    L37:
        return r1;
    L18:
        if ((r9 instanceof String) == false) goto L28;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L21
        Object r11 = Result.constructor-impl(H(new JSONArray((String) r9)));     // Catch: Throwable -> L21
    L23:
        List r7 = CollectionsKt.emptyList();
        if (Result.isFailure-impl(r11) == false) goto L36;
        r11 = r7;
    L36:
        return (List) r11;
    L21:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    L28:
        return CollectionsKt.emptyList();
    }

    public static final JSONArray I(ReadableArray r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        JSONArray r0 = new JSONArray();
        int r1 = r5.size();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L27;
        ReadableType r3 = r5.getType(r2);
        if (r3 != null) goto L10;
        int r4 = -1;
    L11:
        switch(r4) {
            case 1: goto L24;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L21;
            case 5: goto L20;
            case 6: goto L19;
            case 7: goto L18;
            case 8: goto L17;
            default: goto L12;
        };
    L12:
        f6a.a r6 = r5.getDynamic(r2);
        if (r6 == null) goto L25;
        Object r7 = r6.asString();
        if (r7 == null) goto L25;
    L26:
        r0.put(r7);
        r2 = r2 + 1;
    L25:
        r7 = JSONObject.NULL;
        goto L26
    L17:
        r7 = r5.getString(r2);
        goto L26
    L18:
        r7 = Double.valueOf(r5.getDouble(r2));
        goto L26
    L19:
        r7 = Long.valueOf(r5.getLong(r2));
        goto L26
    L20:
        r7 = Integer.valueOf(r5.getInt(r2));
        goto L26
    L21:
        r7 = Boolean.valueOf(r5.getBoolean(r2));
        goto L26
    L22:
        r7 = JSONObject.NULL;
        goto L26
    L23:
        r7 = I(r5.getArray(r2));
        goto L26
    L24:
        r7 = J(r5.getMap(r2));
        goto L26
    L10:
        r4 = a.a[r3.ordinal()];
        goto L11
    L27:
        return r0;
    }

    public static final JSONObject J(ReadableMap r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        JSONObject r0 = new JSONObject();
        ReadableMapKeySetIterator r1 = r5.keySetIterator();
    L7:
        if (r1.hasNextKey() == false) goto L28;
        String r2 = r1.nextKey();
        Intrinsics.checkNotNull(r2);
        ReadableType r3 = r5.getType(r2);
        if (r3 != null) goto L11;
        int r4 = -1;
    L12:
        switch(r4) {
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L18;
            default: goto L13;
        };
    L13:
        f6a.a r6 = r5.getDynamic(r2);
        if (r6 == null) goto L26;
        Object r7 = r6.asString();
        if (r7 == null) goto L26;
    L27:
        r0.put(r2, r7);
    L26:
        r7 = JSONObject.NULL;
        goto L27
    L18:
        r7 = r5.getString(r2);
        goto L27
    L19:
        r7 = Double.valueOf(r5.getDouble(r2));
        goto L27
    L20:
        r7 = Long.valueOf(r5.getLong(r2));
        goto L27
    L21:
        r7 = Integer.valueOf(r5.getInt(r2));
        goto L27
    L22:
        r7 = Boolean.valueOf(r5.getBoolean(r2));
        goto L27
    L23:
        r7 = JSONObject.NULL;
        goto L27
    L24:
        r7 = I(r5.getArray(r2));
        goto L27
    L25:
        r7 = J(r5.getMap(r2));
        goto L27
    L11:
        r4 = a.a[r3.ordinal()];
        goto L12
    L28:
        return r0;
    }

    public static final int R(int r3) {
        return Color.argb(RangesKt.coerceIn((int) (Color.alpha(r3) * 0.48f), 0, 255), Color.red(r3), Color.green(r3), Color.blue(r3));
    }

    public static DisplayMetrics a(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static final OButton d(Context r3) {
        View r4 = LayoutInflater.from(r3).inflate(2131563907, null, false);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.obric.oui.button.OButton");
        return (OButton) r4;
    }

    public static final Integer i(Object r1) {
        if ((r1 instanceof Number) == false) goto L6;
        return Integer.valueOf(((Number) r1).intValue());
    L6:
        if ((r1 instanceof String) == true) goto L11;
        return null;
    L11:
        return StringsKt.toIntOrNull(StringsKt.trim((String) r1).toString());
    }

    public static final int l(LynxContext r4) {
        if (w(r4) == false) goto L5;
        int r0 = Q(r4, CollectionsKt.listOf(new String[]{"OFloatingTitleBar_Action_Dark", "OFloatingTitleBar_Action_Overlay", "OFloatingTitleBar_Action_Standard"}));
    L6:
        OTextView r1 = new OTextView(new ContextThemeWrapper(r4, r0), null, 0, 14);
        r1.setTextAppearance(2131953751);
        return r1.getCurrentTextColor();
    L5:
        r0 = Q(r4, CollectionsKt.listOf("OFloatingTitleBar_Action_Standard"));
        goto L6
    }

    public static final Map o(Map r3) {
        HashMap r0 = new HashMap(r3.size());
        Iterator r4 = r3.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) r4.next();
        int r2 = ((Number) r1.getKey()).intValue();
        Integer r5 = Integer.valueOf(((Number) r1.getValue()).intValue());
        r0.put(String.valueOf(r2), r5);
        goto L4
    L6:
        return r0;
    }

    public static final Drawable q(Drawable r7) {
        Integer r0 = null;
        if (r7 != null) goto L5;
        return null;
    L5:
        Drawable.ConstantState r1 = r7.getConstantState();
        if (r1 == null) goto L11;
        Drawable r2 = r1.newDrawable();
        if (r2 == null) goto L11;
        Drawable r3 = r2.mutate();
        if (r3 == null) goto L11;
    L12:
        r3.setState(r7.getState());
        r3.setLevel(r7.getLevel());
        if (r7.getBounds().isEmpty() == true) goto L15;
        r3.setBounds(new Rect(r7.getBounds()));
    L55:
        return r3;
    L15:
        Integer r4 = Integer.valueOf(r3.getIntrinsicWidth());
        boolean r5 = true;
        if (r4.intValue() <= 0) goto L18;
        boolean r6 = true;
    L19:
        if (r6 == true) goto L22;
        r4 = null;
    L22:
        if (r4 == null) goto L24;
    L23:
        int r8 = r4.intValue();
    L34:
        Integer r9 = Integer.valueOf(r3.getIntrinsicHeight());
        if (r9.intValue() <= 0) goto L37;
        boolean r10 = true;
    L38:
        if (r10 == true) goto L41;
        r9 = null;
    L41:
        if (r9 == null) goto L43;
        int r11 = r9.intValue();
    L52:
        if (r8 <= 0) goto L55;
        if (r11 <= 0) goto L55;
        r3.setBounds(0, 0, r8, r11);
        goto L55
    L43:
        Integer r12 = Integer.valueOf(r7.getIntrinsicHeight());
        if (r12.intValue() > 0) goto L47;
        r5 = false;
    L47:
        if (r5 == false) goto L49;
        r0 = r12;
    L49:
        if (r0 == null) goto L51;
        r11 = r0.intValue();
        goto L52
    L51:
        r11 = 0;
        goto L52
    L37:
        r10 = false;
        goto L38
    L24:
        r4 = Integer.valueOf(r7.getIntrinsicWidth());
        if (r4.intValue() <= 0) goto L27;
        boolean r13 = true;
    L28:
        if (r13 == true) goto L31;
        r4 = null;
    L31:
        if (r4 != null) goto L23;
        r8 = 0;
        goto L34
    L27:
        r13 = false;
        goto L28
    L18:
        r6 = false;
    L11:
        r3 = r7.mutate();
        goto L12
    }

    public static final Integer u(Drawable r4) {
        if (r4 == null) goto L7;
        Drawable r0 = r4.getCurrent();
        if (r0 == null) goto L7;
        r4 = r0;
    L7:
        boolean r1 = true;
        if ((r4 instanceof ColorDrawable) == false) goto L16;
        Integer r5 = Integer.valueOf(((ColorDrawable) r4).getColor());
        if (Color.alpha(r5.intValue()) > 0) goto L13;
        r1 = false;
    L13:
        if (r1 == true) goto L44;
        return null;
    L44:
        return r5;
    L16:
        if ((r4 instanceof GradientDrawable) == false) goto L26;
        ColorStateList r6 = ((GradientDrawable) r4).getColor();
        if (r6 == null) goto L45;
        r5 = Integer.valueOf(r6.getDefaultColor());
        if (Color.alpha(r5.intValue()) > 0) goto L23;
        r1 = false;
    L23:
        if (r1 == true) goto L44;
        return null;
    L45:
        return null;
    L26:
        if ((r4 instanceof InsetDrawable) == false) goto L29;
        return u(((InsetDrawable) r4).getDrawable());
    L29:
        if ((r4 instanceof LayerDrawable) == false) goto L37;
        LayerDrawable r7 = (LayerDrawable) r4;
        IntIterator r2 = RangesKt.until(0, r7.getNumberOfLayers()).iterator();
    L32:
        if (r2.hasNext() == false) goto L50;
        Integer r3 = u(r7.getDrawable(r2.nextInt()));
        if (r3 == null) goto L32;
        return r3;
    L50:
        return null;
    L37:
        if ((r4 instanceof StateListDrawable) == true) goto L39;
        return null;
    L39:
        return u(((StateListDrawable) r4).getCurrent());
    }

    public static final boolean v(q4 r1) {
        if (r1.h == null) goto L5;
    L8:
        return true;
    L5:
        if (r1.m != null) goto L8;
        return false;
    }

    public static final boolean w(Context r1) {
        if (r1 == null) goto L7;
        Resources r2 = r1.getResources();
        if (r2 == null) goto L7;
        Configuration r3 = r2.getConfiguration();
        if (r3 == null) goto L7;
    L9:
        if ((r3.uiMode & 48) != 32) goto L11;
        return true;
    L11:
        return false;
    L7:
        r3 = Resources.getSystem().getConfiguration();
        goto L9
    }

    public static final boolean x(int r3) {
        if (Color.alpha(r3) >= 128) goto L6;
        return false;
    L6:
        if (((((Color.red(r3) * 299) + (Color.green(r3) * 587)) + (Color.blue(r3) * 114)) / SearchError.ERR_UNKNOWN) < 220) goto L9;
        return true;
    L9:
        return false;
    }

    public static final void z(View r3) {
        r3.forceLayout();
        r3.requestLayout();
        if ((r3 instanceof ViewGroup) == false) goto L11;
        ViewGroup r4 = (ViewGroup) r3;
        int r0 = r4.getChildCount();
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L15;
        View r2 = r4.getChildAt(r1);
        if (r2 == null) goto L10;
        z(r2);
    L10:
        r1 = r1 + 1;
        goto L5
    L15:
        return;
    }

    public static final Boolean B(JSONObject r6, String... r7) {
        int r0 = r7.length;
        boolean r1 = false;
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L55;
        String r4 = r7[r2];
        if (r6.has(r4) == true) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        Object r8 = r6.opt(r4);
        if ((r8 instanceof Boolean) == false) goto L11;
        return (Boolean) r8;
    L11:
        if ((r8 instanceof Number) == false) goto L17;
        if (((Number) r8).intValue() == 0) goto L59;
        r1 = true;
    L59:
        return Boolean.valueOf(r1);
    L17:
        if ((r8 instanceof String) == false) goto L60;
        String r9 = StringsKt.trim((String) r8).toString().toLowerCase(Locale.ROOT);
        switch(r9.hashCode()) {
            case 48: goto L50;
            case 49: goto L46;
            case 110: goto L43;
            case 121: goto L40;
            case 3521: goto L37;
            case 3551: goto L34;
            case 109935: goto L31;
            case 119527: goto L28;
            case 3569038: goto L25;
            case 97196323: goto L22;
            default: goto L63;
        };
    L63:
        return null;
    L22:
        if (r9.equals("false") == true) goto L53;
        return null;
    L53:
        return Boolean.FALSE;
    L25:
        if (r9.equals("true") == true) goto L62;
        return null;
    L62:
        return Boolean.TRUE;
    L28:
        if (r9.equals("yes") == true) goto L62;
        return null;
    L31:
        if (r9.equals("off") == true) goto L53;
        return null;
    L34:
        if (r9.equals("on") == true) goto L62;
        return null;
    L37:
        if (r9.equals("no") == true) goto L53;
        return null;
    L40:
        if (r9.equals("y") == true) goto L62;
        return null;
    L43:
        if (r9.equals("n") == true) goto L53;
        return null;
    L46:
        if (r9.equals("1") == true) goto L62;
        return null;
    L50:
        if (r9.equals("0") == true) goto L53;
        return null;
    L60:
        return null;
    L55:
        return null;
    }

    public static final String C(JSONObject r5, String... r6) {
        int r0 = r6.length;
        int r1 = 0;
    L3:
        String r2 = null;
        if (r1 >= r0) goto L11;
        String r3 = r5.optString(r6[r1]);
        Intrinsics.checkNotNull(r3);
        if ((!StringsKt.isBlank(r3)) == false) goto L8;
        r2 = r3;
    L8:
        if (r2 != null) goto L9;
        r1 = r1 + 1;
        goto L3
    L9:
        return r2;
    L11:
        return null;
    }

    public static final Object D(JSONObject r4, String... r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "keys");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        String r2 = r5[r1];
        if (r4.has(r2) == false) goto L10;
        if (r4.isNull(r2) == true) goto L10;
        return r4.opt(r2);
    L10:
        r1 = r1 + 1;
        goto L3
    L11:
        return null;
    }

    public static final Integer E(Object r17, Context r18) {
        if ((r17 instanceof Number) == false) goto L6;
        return Integer.valueOf(((Number) r17).intValue());
    L6:
        if ((r17 instanceof String) == false) goto L83;
        String r0 = StringsKt.trim((String) r17).toString();
        if ((!StringsKt.isBlank(r0)) == false) goto L10;
        String r2 = r0;
    L11:
        if (r2 == null) goto L83;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        Object r3 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r2)));     // Catch: Throwable -> L14
    L17:
        if (Result.isFailure-impl(r3) == false) goto L19;
        r3 = null;
    L19:
        Integer r4 = (Integer) r3;
        if (r4 != null) goto L100;
        if (r18 == null) goto L75;
        String r5 = StringsKt.removePrefix(StringsKt.removePrefix(StringsKt.trim(r2).toString().toLowerCase(Locale.ROOT), "@color/"), "color/");
        if ((!StringsKt.isBlank(r5)) == false) goto L26;
        String r6 = r5;
    L27:
        if (r6 != null) goto L29;
        List r7 = CollectionsKt.emptyList();
    L69:
        Iterator r8 = r7.iterator();
    L71:
        if (r8.hasNext() == false) goto L75;
        Integer r9 = L((String) r8.next(), r18);
        if (r9 == null) goto L71;
        Integer r10 = r9;
    L76:
        if (r10 != null) goto L101;
        com.obric.oui.material.c r11 = P(r2, r18);
        if (r11 == null) goto L83;
        ColorStateList r12 = r11.a;
        if (r12 == null) goto L83;
        return Integer.valueOf(r12.getDefaultColor());
    L101:
        return r10;
    L29:
        List r13 = StringsKt.split$default(r6, new char[]{'/'}, false, 0, 6, null);
        ArrayList r14 = new ArrayList();
        Iterator r15 = r13.iterator();
    L31:
        if (r15.hasNext() == false) goto L36;
        Object r16 = r15.next();
        if ((!StringsKt.isBlank((String) r16)) == false) goto L31;
        r14.add(r16);
        goto L31
    L36:
        if (r14.isEmpty() == false) goto L38;
        r7 = CollectionsKt.emptyList();
        goto L69
    L38:
        Iterator r19 = r14.iterator();
    L40:
        if (r19.hasNext() == false) goto L50;
        Object r20 = r19.next();
        String r21 = (String) r20;
        if (Intrinsics.areEqual(r21, "light") == false) goto L44;
    L47:
        boolean r22 = true;
    L48:
        if (r22 == false) goto L40;
    L51:
        String r23 = (String) r20;
        List r24 = r14;
        if (r23 == null) goto L54;
        r24 = CollectionsKt.drop(r14, 1);
    L54:
        String r25 = CollectionsKt.joinToString$default(r24, "_", null, null, 0, null, new m1(), 30, null);
        if (StringsKt.isBlank(r25) == false) goto L57;
        r7 = CollectionsKt.emptyList();
        goto L69
    L57:
        LinkedHashSet r26 = new LinkedHashSet();
        if (r23 == null) goto L64;
        String r27 = r23 + '_' + r25;
        r(r26, r27);
        String r28 = StringsKt.removePrefix(r27, "ui_");
        if (StringsKt.isBlank(r28) == true) goto L63;
        r27 = r28;
    L63:
        r(r26, r27);
    L64:
        r(r26, r25);
        String r29 = StringsKt.removePrefix(r25, "ui_");
        if (StringsKt.isBlank(r29) == true) goto L68;
        r25 = r29;
    L68:
        r(r26, r25);
        r7 = CollectionsKt.toList(r26);
        goto L69
    L44:
        if (Intrinsics.areEqual(r21, "dark") == true) goto L47;
        r22 = false;
        goto L48
    L50:
        r20 = null;
        goto L51
    L26:
        r6 = null;
    L75:
        r10 = null;
        goto L76
    L100:
        return r4;
    L14:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    L10:
        r2 = null;
    L83:
        return null;
    }

    public static final Integer L(String r5, Context r6) {
        Integer r0 = Integer.valueOf(r6.getResources().getIdentifier(r5, "color", r6.getPackageName()));
        boolean r2 = true;
        if (r0.intValue() == 0) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L10;
        r0 = null;
    L10:
        if (r0 == null) goto L30;
    L27:
        if (r0 != null) goto L29;
        return null;
    L29:
        return Integer.valueOf(ContextCompat.getColor(r6, r0.intValue()));
    L30:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L13
        Object r7 = Result.constructor-impl(Integer.valueOf(R.color.class.getField(r5).getInt(null)));     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r7) == false) goto L18;
        r7 = null;
    L18:
        r0 = (Integer) r7;
        if (r0 != null) goto L21;
    L26:
        r0 = null;
        goto L27
    L21:
        if (r0.intValue() != 0) goto L24;
        r2 = false;
    L24:
        if (r2 == false) goto L26;
    L13:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L5:
        r1 = false;
        goto L7
    }

    public static final Drawable M(Context r4, String r5) {
        String r6 = StringsKt.trimStart(StringsKt.trim(r5).toString(), new char[]{65279});
        Object r2 = null;
        if (StringsKt.isBlank(r6) == false) goto L5;
        return null;
    L5:
        com.obric.miniapp.utils.e1.a.getClass();
        Drawable r1 = com.obric.miniapp.utils.e1.b(r4, r6);
        if (r1 == null) goto L9;
        return r1;
    L9:
        if (StringsKt.endsWith(r6, ".svg", true) == false) goto L13;
        Drawable r0 = com.obric.miniapp.utils.e1.a(r4, r6);
        if (r0 == null) goto L13;
        return r0;
    L13:
        cla.a.a.getClass();
        String r3 = cla.a.e(r6);
        if (r3 == null) goto L18;
        Drawable r7 = com.obric.miniapp.utils.e1.a(r4, r3);
        if (r7 == null) goto L18;
        return r7;
    L18:
        Integer r8 = cla.a.d(r6);
        if (r8 == null) goto L31;
        int r9 = r8.intValue();
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L23
        Object r11 = Result.constructor-impl(ContextCompat.getDrawable(r4, r9));     // Catch: Throwable -> L23
    L26:
        if (Result.isFailure-impl(r11) == true) goto L30;
        r2 = r11;
    L30:
        return (Drawable) r2;
    L23:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    L31:
        int r13 = r4.getResources().getIdentifier(StringsKt.removePrefix(StringsKt.removePrefix(r6, "@drawable/"), "drawable/"), "drawable", r4.getPackageName());
        if (r13 != 0) goto L44;
        return null;
    L44:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L36
        Object r15 = Result.constructor-impl(ContextCompat.getDrawable(r4, r13));     // Catch: Throwable -> L36
    L39:
        if (Result.isFailure-impl(r15) == true) goto L43;
        r2 = r15;
    L43:
        return (Drawable) r2;
    L36:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L39
    }

    public static final Drawable N(Context r3, JSONObject r4) {
        return O(r3, r4, new String[]{"icon"}, new String[]{"iconResId"}, new String[]{"iconResName"});
    }

    public static final com.obric.oui.material.c P(Object r24, Context r25) {
        String r0 = StringsKt.trim((String) r24).toString();
        if (r0 != null) goto L5;
        return null;
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L166;
        boolean r2 = !w(r25);
        String r1 = StringsKt.trim(r0).toString().toLowerCase(Locale.ROOT);
        if (StringsKt.isBlank(r1) == false) goto L13;
        List r3 = CollectionsKt.emptyList();
    L115:
        Iterator r4 = r3.iterator();
    L117:
        if (r4.hasNext() == false) goto L167;
        String r5 = (String) r4.next();
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L121
        Object r7 = Result.constructor-impl(MaterialToken.parse(r5, r2));     // Catch: Throwable -> L121
    L124:
        if (Result.isFailure-impl(r7) == false) goto L126;
        r7 = null;
    L126:
        com.obric.oui.material.c r8 = (com.obric.oui.material.c) r7;
        if (r8 == null) goto L117;
        return r8;
    L121:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L124
    L167:
        return null;
    L13:
        List r10 = StringsKt.split$default(r1, new char[]{'/'}, false, 0, 6, null);
        ArrayList r12 = new ArrayList();
        Iterator r11 = r10.iterator();
    L15:
        if (r11.hasNext() == false) goto L19;
        Object r13 = r11.next();
        if ((!StringsKt.isBlank((String) r13)) == false) goto L15;
        r12.add(r13);
        goto L15
    L19:
        Iterator r14 = r12.iterator();
    L21:
        if (r14.hasNext() == false) goto L31;
        Object r15 = r14.next();
        String r16 = (String) r15;
        if (Intrinsics.areEqual(r16, "light") == false) goto L25;
    L28:
        boolean r17 = true;
    L29:
        if (r17 == false) goto L21;
    L32:
        String r18 = (String) r15;
        String r19 = (String) CollectionsKt.lastOrNull(r12);
        LinkedHashSet r110 = new LinkedHashSet();
        A(r18, r110, r1);
        A(r18, r110, StringsKt.replace$default(r1, '/', '_', false, 4, null));
        A(r18, r110, StringsKt.replace$default(StringsKt.replace$default(r1, '/', '_', false, 4, null), '-', '_', false, 4, null));
        if (r19 == null) goto L112;
        A(r18, r110, r19);
        A(r18, r110, StringsKt.removePrefix(r19, "material-"));
        A(r18, r110, StringsKt.replace$default(StringsKt.removePrefix(r19, "material-"), '-', '_', false, 4, null));
        String r20 = StringsKt.removePrefix(r19, "material-");
        switch(r20.hashCode()) {
            case -1973867682: goto L106;
            case -1925170059: goto L102;
            case -1905951327: goto L98;
            case -1863013633: goto L94;
            case -1646134716: goto L91;
            case -1528408482: goto L88;
            case -1417887953: goto L84;
            case -1326900299: goto L80;
            case -877022319: goto L76;
            case -877022317: goto L72;
            case 322307652: goto L68;
            case 322307653: goto L64;
            case 383723407: goto L61;
            case 449270415: goto L58;
            case 469608608: goto L55;
            case 1173467971: goto L51;
            case 1196923268: goto L48;
            case 1212725854: goto L45;
            case 1758312079: goto L42;
            case 1784953129: goto L38;
            default: goto L145;
        };
    L145:
        String r21 = null;
    L110:
        A(r18, r110, r21);
        goto L112
    L38:
        if (r20.equals("blue-regular") == false) goto L146;
        r21 = "regular_1_blue";
        goto L110
    L146:
        r21 = null;
        goto L110
    L42:
        if (r20.equals("yellow-disable") == false) goto L147;
    L82:
        r21 = "regular_1_yellow_disable";
        goto L110
    L147:
        r21 = null;
        goto L110
    L45:
        if (r20.equals("yellow-disable-regular") == true) goto L82;
        r21 = null;
        goto L110
    L48:
        if (r20.equals("yellow-disabled-regular") == true) goto L82;
        r21 = null;
        goto L110
    L51:
        if (r20.equals("yellow-regular") == false) goto L150;
        r21 = "regular_1_yellow";
        goto L110
    L150:
        r21 = null;
        goto L110
    L55:
        if (r20.equals("base-regular") == true) goto L70;
        r21 = null;
    L70:
        r21 = "regular_1";
        goto L110
    L58:
        if (r20.equals("blue-disabled") == false) goto L151;
    L104:
        r21 = "regular_1_blue_disable";
        goto L110
    L151:
        r21 = null;
        goto L110
    L61:
        if (r20.equals("blue-primary") == false) goto L152;
    L108:
        r21 = "regular_1_blue_primary";
        goto L110
    L152:
        r21 = null;
        goto L110
    L64:
        if (r20.equals("base-regular-2") == false) goto L153;
        r21 = "regular_2";
        goto L110
    L153:
        r21 = null;
        goto L110
    L68:
        if (r20.equals("base-regular-1") == true) goto L70;
        r21 = null;
        goto L110
    L72:
        if (r20.equals("text-3") == false) goto L155;
        r21 = "text_3";
        goto L110
    L155:
        r21 = null;
        goto L110
    L76:
        if (r20.equals("text-1") == false) goto L156;
        r21 = "text_1";
        goto L110
    L156:
        r21 = null;
        goto L110
    L80:
        if (r20.equals("yellow-disabled") == true) goto L82;
        r21 = null;
        goto L110
    L84:
        if (r20.equals("text-3b") == false) goto L158;
        r21 = "text_3b";
        goto L110
    L158:
        r21 = null;
        goto L110
    L88:
        if (r20.equals("blue-disabled-regular") == true) goto L104;
        r21 = null;
        goto L110
    L91:
        if (r20.equals("blue-disable-regular") == true) goto L104;
        r21 = null;
        goto L110
    L94:
        if (r20.equals("base-fill") == false) goto L161;
        r21 = "fill";
        goto L110
    L161:
        r21 = null;
        goto L110
    L98:
        if (r20.equals("base-thick") == false) goto L162;
        r21 = "thick";
        goto L110
    L162:
        r21 = null;
        goto L110
    L102:
        if (r20.equals("blue-disable") == true) goto L104;
        r21 = null;
        goto L110
    L106:
        if (r20.equals("blue-primary-regular") == true) goto L108;
        r21 = null;
    L112:
        if (r12.size() < 2) goto L114;
        A(r18, r110, CollectionsKt.joinToString$default(CollectionsKt.takeLast(r12, 2), "_", null, null, 0, null, null, 62, null));
        A(r18, r110, StringsKt.replace$default(CollectionsKt.joinToString$default(CollectionsKt.takeLast(r12, 2), "_", null, null, 0, null, new n1(), 30, null), '-', '_', false, 4, null));
    L114:
        r3 = CollectionsKt.toList(r110);
        goto L115
    L25:
        if (Intrinsics.areEqual(r16, "dark") == true) goto L28;
        r17 = false;
        goto L29
    L31:
        r15 = null;
        goto L32
    L166:
        return null;
    }

    public static final int Q(LynxContext r5, List r6) {
        Iterator r7 = r6.iterator();
    L3:
        Integer r1 = null;
        if (r7.hasNext() == false) goto L12;
        String r0 = (String) r7.next();
        Integer r2 = Integer.valueOf(r5.getResources().getIdentifier(r0, "style", BuildConfig.LIBRARY_PACKAGE_NAME));
        if (r2.intValue() == 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        r1 = r2;
    L11:
        if (r1 == null) goto L3;
    L8:
        r3 = false;
    L12:
        if (r1 != null) goto L21;
        return 2131952740;
    L21:
        return r1.intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void b(OIconButton r8, q4 r9) {
        Float r0 = r9.e;
        boolean r1 = true;
        Float r4 = null;
        if (r0 != null) goto L5;
    L13:
        Object r2 = r8.getParent();
        if ((r2 instanceof View) == false) goto L16;
        View r3 = (View) r2;
    L17:
        Integer[] r5 = new Integer[8];
        if (r3 == null) goto L25;
        Integer r6 = Integer.valueOf(r3.getWidth());
        if (r6.intValue() <= 0) goto L22;
        boolean r7 = true;
    L23:
        if (r7 == false) goto L25;
    L26:
        r5[0] = r6;
        if (r3 == null) goto L34;
        Integer r10 = Integer.valueOf(r3.getHeight());
        if (r10.intValue() <= 0) goto L31;
        boolean r11 = true;
    L32:
        if (r11 == false) goto L34;
    L35:
        r5[1] = r10;
        if (r3 == null) goto L45;
        ViewGroup.LayoutParams r12 = r3.getLayoutParams();
        if (r12 == null) goto L45;
        Integer r13 = Integer.valueOf(r12.width);
        if (r13.intValue() <= 0) goto L42;
        boolean r14 = true;
    L43:
        if (r14 == false) goto L45;
    L46:
        r5[2] = r13;
        if (r3 == null) goto L56;
        ViewGroup.LayoutParams r15 = r3.getLayoutParams();
        if (r15 == null) goto L56;
        Integer r16 = Integer.valueOf(r15.height);
        if (r16.intValue() <= 0) goto L53;
        boolean r17 = true;
    L54:
        if (r17 == false) goto L56;
    L57:
        r5[3] = r16;
        Integer r18 = Integer.valueOf(r8.getWidth());
        if (r18.intValue() <= 0) goto L60;
        boolean r19 = true;
    L61:
        if (r19 == true) goto L64;
        r18 = null;
    L64:
        r5[4] = r18;
        Integer r20 = Integer.valueOf(r8.getHeight());
        if (r20.intValue() <= 0) goto L67;
        boolean r21 = true;
    L68:
        if (r21 == true) goto L71;
        r20 = null;
    L71:
        r5[5] = r20;
        ViewGroup.LayoutParams r22 = r8.getLayoutParams();
        if (r22 == null) goto L79;
        Integer r23 = Integer.valueOf(r22.width);
        if (r23.intValue() <= 0) goto L76;
        boolean r24 = true;
    L77:
        if (r24 == false) goto L79;
    L80:
        r5[6] = r23;
        ViewGroup.LayoutParams r25 = r8.getLayoutParams();
        if (r25 == null) goto L88;
        Integer r26 = Integer.valueOf(r25.height);
        if (r26.intValue() <= 0) goto L85;
        boolean r27 = true;
    L86:
        if (r27 == false) goto L88;
    L89:
        r5[7] = r26;
        Integer r28 = (Integer) CollectionsKt.minOrNull(CollectionsKt.listOfNotNull(r5));
        if (r28 == null) goto L92;
        int r29 = r28.intValue();
    L93:
        Float r30 = r9.f;
        if (r30 != null) goto L96;
    L104:
        Float r31 = Float.valueOf(a(r8.getContext().getResources()).density);
        if (r31.floatValue() > 0.0f) goto L108;
        r1 = false;
    L108:
        if (r1 == false) goto L110;
        r4 = r31;
    L110:
        if (r4 == null) goto L112;
        float r32 = r4.floatValue();
    L114:
        if ((r29 / r32) > 32.0f) goto L116;
        float r33 = 18.0f;
    L117:
        int r34 = RangesKt.coerceAtMost(s(r8.getContext(), r33), r29);
    L118:
        int r35 = RangesKt.coerceAtLeast((int) ((r29 - r34) / 2.0f), 0);
        ViewGroup.LayoutParams r36 = r8.getLayoutParams();
        if (r36 != null) goto L121;
        ViewGroup.LayoutParams r37 = new ViewGroup.LayoutParams(r29, r29);
    L122:
        if (r36 != null) goto L124;
    L127:
        r37.width = r29;
        r37.height = r29;
        r8.setLayoutParams(r37);
    L128:
        r8.setMinimumWidth(r29);
        r8.setMinimumHeight(r29);
        r8.setPadding(r35, r35, r35, r35);
        p(r8, r9);
        return;
    L124:
        if (r37.width != r29) goto L127;
        if (r37.height == r29) goto L128;
    L121:
        r37 = r36;
        goto L122
    L116:
        r33 = 22.0f;
        goto L117
    L112:
        r32 = 1.0f;
        goto L114
    L96:
        if (r30.floatValue() <= 0.0f) goto L98;
        boolean r38 = true;
    L99:
        if (r38 == true) goto L102;
        r30 = null;
    L102:
        if (r30 == null) goto L104;
        r34 = RangesKt.coerceAtMost(s(r8.getContext(), r30.floatValue()), r29);
        goto L118
    L98:
        r38 = false;
        goto L99
    L92:
        r29 = s(r8.getContext(), 40.0f);
        goto L93
    L85:
        r27 = false;
    L88:
        r26 = null;
        goto L89
    L76:
        r24 = false;
    L79:
        r23 = null;
        goto L80
    L67:
        r21 = false;
        goto L68
    L60:
        r19 = false;
        goto L61
    L53:
        r17 = false;
    L56:
        r16 = null;
        goto L57
    L42:
        r14 = false;
    L45:
        r13 = null;
        goto L46
    L31:
        r11 = false;
    L34:
        r10 = null;
        goto L35
    L22:
        r7 = false;
    L25:
        r6 = null;
        goto L26
    L16:
        r3 = null;
        goto L17
    L5:
        if (r0.floatValue() <= 0.0f) goto L7;
        boolean r39 = true;
    L8:
        if (r39 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L13;
        r29 = s(r8.getContext(), r0.floatValue());
        goto L93
    L7:
        r39 = false;
        goto L8
    }

    public static final OIconButton c(Context r7, q4 r8) {
        Integer r9 = r8.a;
        if (r9 != null) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L10;
        int r4 = 2131953053;
    L14:
        return new OIconButton(r7, null, 0, r4, 16);
    L10:
        if (r9 == null) goto L12;
        r4 = 2131953035;
        goto L14
    L12:
        r4 = 2131953032;
        goto L14
    L5:
        if (Color.alpha(r9.intValue()) != 0) goto L7;
        r0 = true;
        goto L8
    }

    public static final q4 e(q4 r17, q4 r18) {
        Integer r2 = r18.a;
        if (r2 != null) goto L5;
        r2 = r17.a;
    L5:
        Float r3 = r18.b;
        if (r3 != null) goto L8;
        r3 = r17.b;
    L8:
        Float r4 = r18.c;
        if (r4 != null) goto L11;
        r4 = r17.c;
    L11:
        Float r5 = r18.d;
        if (r5 != null) goto L14;
        r5 = r17.d;
    L14:
        Float r6 = r18.e;
        if (r6 != null) goto L17;
        r6 = r17.e;
    L17:
        Float r7 = r18.f;
        if (r7 != null) goto L20;
        r7 = r17.f;
    L20:
        Boolean r8 = r18.g;
        if (r8 != null) goto L23;
        r8 = r17.g;
    L23:
        Integer r9 = r18.h;
        if (r9 != null) goto L26;
        r9 = r17.h;
    L26:
        Integer r10 = r18.i;
        if (r10 != null) goto L29;
        r10 = r17.i;
    L29:
        Float r11 = r18.j;
        if (r11 != null) goto L32;
        r11 = r17.j;
    L32:
        Integer r12 = r18.k;
        if (r12 != null) goto L35;
        r12 = r17.k;
    L35:
        Integer r13 = r18.l;
        if (r13 != null) goto L38;
        r13 = r17.l;
    L38:
        Integer r14 = r18.m;
        if (r14 != null) goto L41;
        r14 = r17.m;
    L41:
        Integer r1 = r18.n;
        if (r1 != null) goto L44;
        Integer r16 = r17.n;
    L46:
        return new q4(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r16);
    L44:
        r16 = r1;
        goto L46
    }

    public static final Integer f(JSONObject r4, String... r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L18;
        String r2 = r5[r1];
        if (r4.has(r2) == false) goto L17;
        if (r4.isNull(r2) == true) goto L17;
        Object r3 = r4.opt(r2);
        if ((r3 instanceof Number) == true) goto L27;
        if ((r3 instanceof String) == false) goto L17;
        Integer r6 = StringsKt.toIntOrNull(StringsKt.trim((String) r3).toString());
        if (r6 == null) goto L17;
        return Integer.valueOf(r6.intValue());
    L27:
        return Integer.valueOf(((Number) r3).intValue());
    L17:
        r1 = r1 + 1;
        goto L3
    L18:
        return null;
    }

    public static final q4 g(JSONObject r20, Context r21) {
        if (r20 != null) goto L6;
        return new q4(0);
    L6:
        return new q4(E(D(r20, new String[]{"backgroundColor", "bgColor", "background_color", "bg_color"}), r21), F(D(r20, new String[]{"radiusDp", "cornerRadius", "borderRadius", "radius_dp", "corner_radius", "border_radius"})), F(D(r20, new String[]{"paddingLeftDp", "paddingStartDp", "paddingLeft", "paddingStart", "padding_left_dp", "padding_start_dp"})), F(D(r20, new String[]{"marginLeftDp", "marginStartDp", "marginLeft", "marginStart", "margin_left_dp", "margin_start_dp"})), F(D(r20, new String[]{"buttonSize", "buttonSizeDp", "size", "button_size", "button_size_dp"})), F(D(r20, new String[]{"iconSize", "iconSizeDp", "icon_size", "icon_size_dp"})), B(r20, new String[]{"disablePressEffect", "disable_press_effect", "disableGreyInteraction", "disable_gray_interaction", "disableGrayInteraction"}), E(D(r20, new String[]{"textColor", "titleColor", "color", "text_color", "title_color"}), r21), E(D(r20, new String[]{"borderColor", "strokeColor", "border_color", "stroke_color"}), r21), F(D(r20, new String[]{"borderWidth", "strokeWidth", "border_width", "stroke_width"})), E(D(r20, new String[]{"iconTint", "iconColor", "icon_tint", "icon_color"}), r21), E(D(r20, new String[]{"disabledBackgroundColor", "disabledBgColor", "disabled_background_color", "disabled_bg_color"}), r21), E(D(r20, new String[]{"disabledTextColor", "disabledColor", "disabled_text_color", "disabled_color"}), r21), E(D(r20, new String[]{"disabledBorderColor", "disabledStrokeColor", "disabled_border_color", "disabled_stroke_color"}), r21));
    }

    public static final List h(Context r17, JSONObject r18) {
        JSONArray r2 = r18.optJSONArray("items");
        if (r2 != null) goto L7;
        r2 = r18.optJSONArray("titles");
        if (r2 != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        ArrayList r1 = new ArrayList();
        int r3 = r2.length();
        int r5 = 0;
    L8:
        if (r5 >= r3) goto L51;
        JSONObject r6 = r2.optJSONObject(r5);
        String r7 = r2.optString(r5);
        Intrinsics.checkNotNull(r7);
        boolean r9 = true;
        Drawable r10 = null;
        if ((!StringsKt.isBlank(r7)) == true) goto L14;
        r7 = null;
    L14:
        if (r6 != null) goto L18;
        r6 = new JSONObject();
        if (r7 == null) goto L18;
        r6.put("title", r7);
    L18:
        String r8 = C(r6, new String[]{"title", "label", "text", "name", "value"});
        if (r8 != null) goto L21;
        r8 = "";
    L21:
        String r12 = r8;
        if (r6.has("icon") == false) goto L24;
    L29:
        boolean r11 = true;
    L30:
        if (r11 == false) goto L32;
        Drawable r13 = N(r17, r6);
    L34:
        if (r6.has("tailIcon") == false) goto L36;
    L41:
        if (r9 == false) goto L43;
        r10 = O(r17, r6, new String[]{"tailIcon"}, new String[]{"tailIconResId"}, new String[]{"tailIconResName"});
    L43:
        Drawable r14 = r10;
        boolean r15 = r6.optBoolean("disabled", false);
        if (StringsKt.isBlank(r12) == false) goto L48;
        if (r13 != null) goto L48;
        if (r14 != null) goto L48;
    L49:
        r5 = r5 + 1;
    L48:
        r1.add(new r4(r12, r13, r14, r15, r6));
        goto L49
    L36:
        if (r6.has("tailIconResId") == true) goto L41;
        if (r6.has("tailIconResName") == true) goto L41;
        r9 = false;
        goto L41
    L32:
        r13 = null;
        goto L34
    L24:
        if (r6.has("iconResId") == true) goto L29;
        if (r6.has("iconResName") == true) goto L29;
        r11 = false;
        goto L30
    L51:
        return r1;
    }

    public static final Drawable n(Drawable r0, Integer r1) {
        Drawable r2 = q(r0);
        if (r2 != null) goto L5;
        return null;
    L5:
        if (r1 == null) goto L7;
        r2.setTint(r1.intValue());
        return r2;
    L7:
        r2.clearColorFilter();
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void p(View r4, q4 r5) {
        Boolean r0 = r5.g;
        if (r0 == null) goto L5;
        boolean r6 = r0.booleanValue();
    L25:
        if ((r4 instanceof OButtonFloating) == false) goto L30;
        if (r6 == false) goto L50;
        ((OButtonFloating) r4).setPressColor(0);
        return;
    L50:
        return;
    L30:
        if ((r4 instanceof OIconButtonFloating) == false) goto L35;
        if (r6 == false) goto L51;
        ((OIconButtonFloating) r4).setPressColor(0);
        return;
    L51:
        return;
    L35:
        if ((r4 instanceof OButtonGroup) == false) goto L40;
        if (r6 == false) goto L52;
        ((OButtonGroup) r4).setPressColor(0);
        return;
    L52:
        return;
    L40:
        if ((r4 instanceof com.obric.oui.common.style.a) == false) goto L42;
        com.obric.oui.common.style.a r1 = (com.obric.oui.common.style.a) r4;
    L43:
        if (r1 != null) goto L45;
        return;
    L45:
        r1.setChangeAlphaWhenPress(!r6);
        r1.f1(r6);
        if (r6 == false) goto L48;
        r1.setOverridePressColor(0);
        r1.m1("LynxMiniAppButton");
        r4.setForeground(null);
        return;
    L48:
        r1.setOverridePressColor(-1);
        r1.m1("LynxMiniAppButton");
        return;
    L42:
        r1 = null;
        goto L43
    L5:
        Integer r7 = r5.a;
        if (r7 == null) goto L23;
        int r8 = r7.intValue();
        if (Color.alpha(r8) == 0) goto L20;
        float[] r2 = new float[3];
        Color.colorToHSV(r8, r2);
        if (r2[1] > 0.12f) goto L20;
        float r9 = r2[2];
        if (0.35f <= r9) goto L15;
    L17:
        boolean r10 = false;
    L18:
        if (r10 == false) goto L20;
        boolean r11 = true;
    L21:
        if (r11 != true) goto L23;
        r6 = true;
        goto L25
    L15:
        if (r9 > 0.98f) goto L17;
        r10 = true;
    L20:
        r11 = false;
    L23:
        r6 = false;
        goto L25
    }

    public static final void r(LinkedHashSet<String> r4, String r5) {
        if (r5 == null) goto L14;
        String r6 = StringsKt.trim(r5, new char[]{'_'});
        if (r6 != null) goto L6;
        return;
    L6:
        if ((true ^ StringsKt.isBlank(r6)) == true) goto L9;
        r6 = null;
    L9:
        if (r6 == null) goto L16;
        r4.add(r6);
        if (StringsKt.startsWith$default(r6, "oui_", false, 2, null) == true) goto L17;
        r4.add("oui_".concat(r6));
        return;
    L17:
        return;
    L16:
        return;
    }

    public static final int s(Context r0, float r1) {
        return (int) ((r1 * a(r0.getResources()).density) + 0.5f);
    }

    public static final int t(Context r0, int r1) {
        return (int) ((r1 * a(r0.getResources()).density) + 0.5f);
    }

    public static final boolean y(String r4, JSONObject r5) {
        if (Intrinsics.areEqual(r4, "option") == false) goto L5;
        return true;
    L5:
        if (Intrinsics.areEqual(r4, "left_option") == false) goto L7;
        return true;
    L7:
        if (Intrinsics.areEqual(r4, "right_option") == false) goto L9;
        return true;
    L9:
        if (r5.optBoolean("leftOption", false) == false) goto L11;
        return true;
    L11:
        if (r5.optBoolean("rightOption", false) == true) goto L36;
        String r6 = C(r5, new String[]{"optionPosition", "option", "checkPosition"});
        if (r6 != null) goto L15;
    L17:
        boolean r7 = false;
    L18:
        if (r7 == false) goto L20;
        return true;
    L20:
        if (r5.has("checked") == false) goto L22;
        return true;
    L22:
        if (r5.has("selected") == false) goto L24;
        return true;
    L24:
        if (r5.has("isChecked") == false) goto L26;
        return true;
    L26:
        if (r5.has("checkable") == false) goto L28;
        return true;
    L28:
        if (r5.has("enableCheckable") == true) goto L42;
        return false;
    L42:
        return true;
    L15:
        if ((!StringsKt.isBlank(r6)) != true) goto L17;
        r7 = true;
        goto L18
    L36:
        return true;
    }

    public static final void A(String r4, LinkedHashSet<String> r5, String r6) {
        if (r6 == null) goto L20;
        String r7 = StringsKt.trim(r6).toString();
        if (r7 == null) goto L21;
        String r8 = r7.toLowerCase(Locale.ROOT);
        if (r8 != null) goto L8;
        return;
    L8:
        if ((!StringsKt.isBlank(r8)) == true) goto L11;
        r8 = null;
    L11:
        if (r8 == null) goto L23;
        if (r4 != null) goto L14;
    L18:
        r5.add(r8);
        return;
    L14:
        if (StringsKt.endsWith$default(r8, "_light", false, 2, null) == true) goto L18;
        if (StringsKt.endsWith$default(r8, "_dark", false, 2, null) == true) goto L18;
        r5.add(r8 + '_' + r4);
        goto L18
    L23:
        return;
    L21:
        return;
    }

    public static final int K(q4 r0, boolean r1, int r2) {
        if (r1 == true) goto L7;
        Integer r3 = r0.h;
        if (r3 != null) goto L6;
        return r2;
    L6:
        return r3.intValue();
    L7:
        Integer r4 = r0.m;
        if (r4 != null) goto L18;
        Integer r5 = r0.h;
        if (r5 == null) goto L13;
        Integer r6 = Integer.valueOf(R(r5.intValue()));
    L14:
        if (r6 != null) goto L16;
        return r2;
    L16:
        return r6.intValue();
    L13:
        r6 = null;
        goto L14
    L18:
        return r4.intValue();
    }

    public static final Integer k(q4 r1, boolean r2, int r3) {
        Integer r0 = r1.k;
        if (r0 == null) goto L7;
        if (r2 == true) goto L13;
        return r0;
    L13:
        return Integer.valueOf(R(r0.intValue()));
    L7:
        if (v(r1) == false) goto L9;
        Integer r4 = Integer.valueOf(r3);
    L11:
        return r4;
    L9:
        r4 = null;
        goto L11
    }

    public static final Drawable O(Context r8, JSONObject r9, String[] r10, String[] r11, String[] r12) {
        int r0 = r10.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        Object r4 = null;
        Object r5 = null;
        String r6 = null;
        Object r7 = null;
        if (r2 >= r0) goto L59;
        Object r13 = r9.opt(r10[r2]);
        if ((r13 instanceof Number) == false) goto L20;
        if (((Number) r13).intValue() <= 0) goto L58;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L11
        Object r15 = Result.constructor-impl(ContextCompat.getDrawable(r8, ((Number) r13).intValue()));     // Catch: Throwable -> L11
    L14:
        if (Result.isFailure-impl(r15) == true) goto L18;
        r5 = r15;
    L18:
        return (Drawable) r5;
    L11:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
    L58:
        r2 = r2 + 1;
        goto L3
    L20:
        if ((r13 instanceof String) == false) goto L25;
        Drawable r3 = M(r8, (String) r13);
        if (r3 == null) goto L58;
        return r3;
    L25:
        if ((r13 instanceof JSONObject) == false) goto L58;
        JSONObject r17 = (JSONObject) r13;
        Integer r18 = Integer.valueOf(r17.optInt("resId"));
        if (r18.intValue() <= 0) goto L29;
        boolean r19 = true;
    L30:
        if (r19 == true) goto L33;
        r18 = null;
    L33:
        if (r18 != null) goto L34;
        String r20 = r17.optString("resName");
        Intrinsics.checkNotNull(r20);
        if ((!StringsKt.isBlank(r20)) == true) goto L49;
        r20 = null;
    L49:
        if (r20 != null) goto L53;
        String r21 = r17.optString("iconResName");
        Intrinsics.checkNotNull(r21);
        if ((true ^ StringsKt.isBlank(r21)) == false) goto L54;
        r6 = r21;
    L54:
        if (r6 == null) goto L58;
        Drawable r22 = M(r8, r6);
        if (r22 == null) goto L58;
        return r22;
    L53:
        r6 = r20;
        goto L54
    L34:
        int r23 = r18.intValue();
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L37
        Object r24 = Result.constructor-impl(ContextCompat.getDrawable(r8, r23));     // Catch: Throwable -> L37
    L40:
        if (Result.isFailure-impl(r24) == true) goto L44;
        r7 = r24;
    L44:
        return (Drawable) r7;
    L37:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r24 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L40
    L29:
        r19 = false;
        goto L30
    L59:
        int r111 = r11.length;
        int r26 = 0;
    L60:
        if (r26 >= r111) goto L81;
        Integer r27 = Integer.valueOf(r9.optInt(r11[r26]));
        if (r27.intValue() <= 0) goto L64;
        boolean r28 = true;
    L65:
        if (r28 == true) goto L68;
        r27 = null;
    L68:
        if (r27 != null) goto L69;
        r26 = r26 + 1;
        goto L60
    L69:
        int r29 = r27.intValue();
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L72
        Object r30 = Result.constructor-impl(ContextCompat.getDrawable(r8, r29));     // Catch: Throwable -> L72
    L75:
        if (Result.isFailure-impl(r30) == true) goto L79;
        r4 = r30;
    L79:
        return (Drawable) r4;
    L72:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L75
    L64:
        r28 = false;
        goto L65
    L81:
        int r113 = r12.length;
    L82:
        if (r1 >= r113) goto L91;
        String r114 = r9.optString(r12[r1]);
        Intrinsics.checkNotNull(r114);
        if ((!StringsKt.isBlank(r114)) == true) goto L87;
        r114 = null;
    L87:
        if (r114 != null) goto L89;
        r1 = r1 + 1;
        goto L82
    L89:
        return M(r8, r114);
    L91:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v11, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r12v12, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r12v14, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r12v16, types: [java.lang.Double] */
    /* JADX WARN: Type inference failed for: r12v18, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v21, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v22, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v8, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r12v9, types: [org.json.JSONArray] */
    public static com.lynx.tasm.behavior.x0 S(com.lynx.tasm.behavior.x0 r16, JSONObject r17, String[] r18, String[] r19, int r20) {
        JSONObject r2 = null;
        if ((r20 & 2) == 0) goto L5;
        String r1 = "options";
    L7:
        if ((r20 & 8) == 0) goto L9;
        String[] r3 = new String[0];
    L10:
        Intrinsics.checkNotNullParameter(r16, "<this>");
        Intrinsics.checkNotNullParameter(r1, "optionKey");
        Intrinsics.checkNotNullParameter(r18, "directKeys");
        Intrinsics.checkNotNullParameter(r3, "jsonKeys");
        SpreadBuilder r5 = new SpreadBuilder(2);
        r5.add(r1);
        r5.addSpread(r3);
        String[] r6 = (String[]) r5.toArray(new String[r5.size()]);
        if (r6.length != 0) goto L13;
        boolean r8 = true;
    L15:
        if (r8 == false) goto L17;
        com.lynx.tasm.behavior.x0 r7 = r16;
    L43:
        Set r0 = ArraysKt.toSet(r18);
        Set r4 = ArraysKt.toSet(r3);
        boolean r9 = r7.i(r1);
        Set r10 = r0;
        if ((r10 instanceof Collection) == true) goto L46;
    L48:
        Iterator r11 = r10.iterator();
    L50:
        if (r11.hasNext() == false) goto L54;
        if (r7.i((String) r11.next()) == false) goto L50;
        boolean r12 = true;
    L55:
        if (r9 == true) goto L58;
        if (r12 == true) goto L58;
    L140:
        if (r2 == null) goto L165;
        String r13 = r2.toString();
        JavaOnlyMap r14 = JavaOnlyMap.shallowCopy(r7.a);
        r14.putString(r1, r13);
        return new com.lynx.tasm.behavior.x0(r14, r7.b);
    L165:
        return r7;
    L58:
        if (r9 == true) goto L60;
    L65:
        if (r9 == false) goto L67;
        JSONObject r15 = new JSONObject();
    L70:
        Iterator r21 = r10.iterator();
    L72:
        if (r21.hasNext() == false) goto L139;
        String r110 = (String) r21.next();
        if (r7.i(r110) == false) goto L72;
        if (r7.k(r110) == true) goto L77;
        boolean r22 = r4.contains(r110);
        ReadableType r111 = r7.a.getType(r110);
        if (r111 != null) goto L81;
        int r112 = -1;
    L82:
        switch(r112) {
            case 1: goto L136;
            case 2: goto L135;
            case 3: goto L134;
            case 4: goto L133;
            case 5: goto L132;
            case 6: goto L131;
            case 7: goto L130;
            case 8: goto L88;
            default: goto L83;
        };
    L83:
        f6a.a r23 = r7.a.getDynamic(r110);
        if (r23 == null) goto L137;
        Object r113 = r23.asString();
        if (r113 == 0) goto L137;
    L138:
        r15.put(r110, r113);
    L137:
        r113 = JSONObject.NULL;
        goto L138
    L88:
        r113 = r7.a.getString(r110);
        if (r22 == false) goto L138;
        if (r113 == 0) goto L92;
        String r24 = StringsKt.trim(r113).toString();
    L93:
        if (r24 != null) goto L96;
        r24 = "";
    L96:
        if (r24.length() != 0) goto L98;
        boolean r114 = true;
    L99:
        if (r114 == true) goto L138;
        if (StringsKt.startsWith$default(r24, "{", false, 2, null) == false) goto L117;
        if (StringsKt.endsWith$default(r24, "}", false, 2, null) == false) goto L117;
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L107
        Object r25 = Result.constructor-impl(new JSONObject(r24));     // Catch: Throwable -> L107
    L110:
        if (Result.isFailure-impl(r25) == false) goto L112;
        r25 = null;
    L112:
        Object r26 = (JSONObject) r25;
        if (r26 == null) goto L138;
    L115:
        r113 = r26;
    L107:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r25 = Result.constructor-impl(ResultKt.createFailure(th));
    L117:
        if (StringsKt.startsWith$default(r24, "[", false, 2, null) == false) goto L138;
        if (StringsKt.endsWith$default(r24, "]", false, 2, null) == false) goto L138;
        Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L122
        Object r27 = Result.constructor-impl(new JSONArray(r24));     // Catch: Throwable -> L122
    L125:
        if (Result.isFailure-impl(r27) == false) goto L127;
        r27 = null;
    L127:
        r26 = (JSONArray) r27;
        if (r26 != null) goto L115;
    L122:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r27 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L125
    L98:
        r114 = false;
        goto L99
    L92:
        r24 = null;
        goto L93
    L130:
        r113 = Double.valueOf(r7.a.getDouble(r110));
        goto L138
    L131:
        r113 = Long.valueOf(r7.a.getLong(r110));
        goto L138
    L132:
        r113 = Integer.valueOf(r7.a.getInt(r110));
        goto L138
    L133:
        r113 = Boolean.valueOf(r7.a.getBoolean(r110));
        goto L138
    L134:
        r113 = JSONObject.NULL;
        goto L138
    L135:
        r113 = I(r7.a.getArray(r110));
        goto L138
    L136:
        r113 = J(r7.a.getMap(r110));
        goto L138
    L81:
        r112 = a.a[r111.ordinal()];
        goto L82
    L77:
        r15.remove(r110);
        goto L72
    L139:
        r2 = r15;
        goto L140
    L67:
        if (r17 == null) goto L69;
        r15 = new JSONObject(r17.toString());
        goto L70
    L69:
        r15 = new JSONObject();
        goto L70
    L60:
        if (r7.k(r1) == true) goto L65;
        JSONObject r28 = G(r7.a.getString(r1));
        if (r28 == null) goto L64;
        r15 = new JSONObject(r28.toString());
        goto L70
    L64:
        r15 = new JSONObject();
    L54:
        r12 = false;
        goto L55
    L46:
        if (r10.isEmpty() == false) goto L48;
    L17:
        JavaOnlyMap r29 = JavaOnlyMap.shallowCopy(r16.a);
        int r119 = r6.length;
        int r120 = 0;
    L18:
        if (r120 >= r119) goto L42;
        String r121 = r6[r120];
        if (r16.i(r121) == false) goto L41;
        if (r16.k(r121) == true) goto L41;
        ReadableType r122 = r16.a.getType(r121);
        if (r122 != null) goto L27;
        int r123 = -1;
    L28:
        if (r123 == 1) goto L36;
        if (r123 != 2) goto L41;
        JSONArray r124 = I(r16.a.getArray(r121));
        if (r124 == null) goto L34;
        String r125 = r124.toString();
    L35:
        r29.putString(r121, r125);
        goto L41
    L34:
        r125 = null;
        goto L35
    L36:
        JSONObject r126 = J(r16.a.getMap(r121));
        if (r126 == null) goto L39;
        String r127 = r126.toString();
    L40:
        r29.putString(r121, r127);
        goto L41
    L39:
        r127 = null;
        goto L40
    L27:
        r123 = a.a[r122.ordinal()];
    L41:
        r120 = r120 + 1;
        goto L18
    L42:
        r7 = new com.lynx.tasm.behavior.x0(r29, r16.b);
        goto L43
    L13:
        r8 = false;
        goto L15
    L9:
        r3 = r19;
        goto L10
    L5:
        r1 = null;
        goto L7
    }

    public static final Drawable j(Context r3, q4 r4, boolean r5, Drawable r6, float r7) {
        Integer r0 = r4.a;
        if (r0 == null) goto L5;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == false) goto L49;
        if (r0 != null) goto L19;
        r0 = u(r6);
    L19:
        if (r5 == false) goto L26;
        Integer r8 = r4.l;
        if (r8 != null) goto L25;
        if (r0 == null) goto L24;
        r0 = Integer.valueOf(R(r0.intValue()));
        goto L26
    L24:
        r0 = null;
        goto L26
    L25:
        r0 = r8;
    L26:
        if (r5 == false) goto L30;
        Integer r9 = r4.n;
        if (r9 == null) goto L30;
    L35:
        if (r9 != null) goto L37;
        int r10 = 0;
    L41:
        GradientDrawable r11 = new GradientDrawable();
        r11.setShape(0);
        r11.setCornerRadius(s(r3, r7));
        if (r0 == null) goto L44;
        r11.setColor(r0.intValue());
    L44:
        if (r9 == null) goto L48;
        if (r10 <= 0) goto L48;
        r11.setStroke(r10, r9.intValue());
    L48:
        return r11;
    L37:
        Float r12 = r4.j;
        if (r12 == null) goto L40;
        r10 = s(r3, r12.floatValue());
        goto L41
    L40:
        r10 = s(r3, 1.0f);
    L30:
        if (r5 == false) goto L34;
        Integer r13 = r4.i;
        if (r13 == null) goto L34;
        r9 = Integer.valueOf(R(r13.intValue()));
    L34:
        r9 = r4.i;
        goto L35
    L49:
        return q(r6);
    L5:
        if (r4.i != null) goto L14;
        if (r4.j != null) goto L14;
        if (r4.l != null) goto L14;
        if (r4.n != null) goto L14;
        r2 = false;
        goto L15
    }

    public static final int m(Context r6, JSONObject r7, Map r8, String[] r9, String[] r10, String[] r11) {
        int r0 = r9.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L10;
        Object r3 = r7.opt(r9[r2]);
        if ((r3 instanceof Number) == false) goto L9;
        Number r4 = (Number) r3;
        if (r4.intValue() <= 0) goto L9;
        return r4.intValue();
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        int r1 = r10.length;
        int r5 = 0;
    L11:
        boolean r12 = true;
        if (r5 >= r1) goto L23;
        Integer r13 = Integer.valueOf(r7.optInt(r10[r5]));
        if (r13.intValue() > 0) goto L17;
        r12 = false;
    L17:
        if (r12 == true) goto L20;
        r13 = null;
    L20:
        if (r13 != null) goto L35;
        r5 = r5 + 1;
        goto L11
    L35:
        return r13.intValue();
    L23:
        Drawable r14 = O(r6, r7, r9, r10, r11);
        if (r14 == null) goto L36;
        int r15 = -(r8.size() + 1);
        r8.put(Integer.valueOf(r15), r14);
        return r15;
    L36:
        return 0;
    }
}
