package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.coremdbiz.facade.node.MarkdownUrlPreviewInline;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import com.ss.android.lark.export.entity.preview.ColorIcon;
import com.ss.android.lark.export.entity.preview.ImageSet;
import com.ss.android.lark.export.entity.preview.ThemeColor;
import com.ss.android.lark.export.entity.preview.UDIcon;
import com.ss.android.lark.export.entity.preview.UnifiedHeaderInfo;
import com.ss.android.lark.export.entity.preview.Url;
import com.ss.android.lark.export.entity.preview.UrlInlinePreviewEntity;
import com.ss.android.lark.widget.light.processor.b0;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
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
            String r4 = this.b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "MarkdownUrlPreviewIcon(key=" + this.a + ", type=" + this.b + ')';
        }

        public final String getType() {
            return this.b;
        }

        public a(String r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public c() {
    }

    public static String c(ThemeColor r9) {
        if (r9 != null) goto L5;
        return null;
    L5:
        String r1 = r9.getToken();
        if (r1 == null) goto L19;
        String r2 = StringsKt.trim(r1).toString();
        if (r2 == null) goto L19;
        if (r2.length() <= 0) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L15;
        String r4 = r2;
    L16:
        if (r4 == null) goto L19;
        return StringsKt.removePrefix(StringsKt.replace$default(r4, '_', '-', false, 4, null), "ud-");
    L15:
        r4 = null;
        goto L16
    L12:
        r3 = false;
    L19:
        ThemeColor.KeyType r5 = r9.getKey().getType();
        if (r5 != null) goto L23;
        return null;
    L23:
        if (r5 == ThemeColor.KeyType.STATIC_WHITE) goto L25;
        Integer r6 = r9.getKey().getValue();
        if (r6 == null) goto L44;
        int r7 = r6.intValue();
        String r8 = r5.name() + r7;
        if (r9.getKey().getAlpha() == 100) goto L45;
        ThemeColor.KeyType r10 = ThemeColor.KeyType.N;
        if (r5 != r10) goto L38;
        if (r7 != 0) goto L38;
        return "N00" + r9.getKey().getAlpha();
    L38:
        if (r5 == r10) goto L40;
        return null;
    L40:
        if (r7 == 900) goto L42;
        return null;
    L42:
        return "N900-" + r9.getKey().getAlpha();
    L45:
        return r8;
    L44:
        return null;
    L25:
        if (r9.getKey().getAlpha() != 100) goto L28;
        return "static-white";
    L28:
        return "static-white-" + r9.getKey().getAlpha();
    }

    public static a b(UDIcon r6, String r7) {
        String r0 = r6.getUnicode();
        boolean r1 = false;
        if (r0 == null) goto L16;
        String r2 = StringsKt.trim(r0).toString();
        if (r2 == null) goto L16;
        if (r2.length() <= 0) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == true) goto L13;
        r2 = null;
    L13:
        if (r2 == null) goto L16;
        return new a(d("unicode", "unicode", r2), "ud_icon_key");
    L9:
        r5 = false;
    L16:
        String r3 = c(r6.getThemeColor());
        if (r3 == null) goto L20;
        r7 = r3;
    L20:
        String r8 = StringsKt.trim(r6.getKey()).toString();
        if (r8.length() <= 0) goto L23;
        r1 = true;
    L23:
        if (r1 == true) goto L26;
        r8 = null;
    L26:
        if (r8 != null) goto L28;
        return null;
    L28:
        return new a(e(r8, r7), "ud_icon_key");
    }

    public static String e(String r1, String r2) {
        if (r2 == null) goto L11;
        String r3 = StringsKt.trim(r2).toString();
        if (r3 == null) goto L11;
        if (r3.length() <= 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
    L13:
        return d(r1, "tint_color", r3);
    L8:
        r0 = false;
    L11:
        r3 = null;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static List a(Context r17, Map r18, int r19) {
        Intrinsics.checkNotNullParameter(r17, "context");
        if (r18 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L197;
        int r4 = b0.a;
        Resources r1 = r17.getResources();
        float r5 = r19 / WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).density;
        LinkedHashSet r2 = new LinkedHashSet();
        Collection r6 = r18.values();
        ArrayList r7 = new ArrayList();
        Iterator r8 = r6.iterator();
    L13:
        if (r8.hasNext() == false) goto L191;
        PreviewHangPoint r9 = (PreviewHangPoint) r8.next();
        String r10 = r9.getUrl();
        Object r11 = null;
        if (r10 == null) goto L17;
        String r12 = StringsKt.trim(r10).toString();
    L19:
        if (r12 != null) goto L21;
        String r13 = BuildConfig.FLAVOR;
    L22:
        String r14 = r9.getPreviewId();
        if (r14 != null) goto L25;
        String r15 = BuildConfig.FLAVOR;
    L26:
        UrlCardPreviewEntity r16 = r9.getUrlCardPreviewEntity();
        if (r16 == null) goto L29;
        UrlInlinePreviewEntity r20 = r16.getInlineEntity();
    L30:
        if (r20 == null) goto L34;
        String r21 = r20.getTitle();
        if (r21 == null) goto L34;
        String r22 = StringsKt.trim(r21).toString();
    L35:
        if (r22 != null) goto L37;
        String r110 = BuildConfig.FLAVOR;
    L39:
        if (r13.length() != 0) goto L41;
        boolean r23 = true;
    L42:
        if (r23 == false) goto L44;
    L188:
        if (r11 == null) goto L13;
        r7.add(r11);
        goto L13
    L44:
        if (r15.length() != 0) goto L46;
        boolean r24 = true;
    L47:
        if (r24 == true) goto L188;
        if (r110.length() != 0) goto L51;
        boolean r25 = true;
    L52:
        if (r25 == true) goto L188;
        if (r2.add(r15) == false) goto L188;
        if (r20 != null) goto L58;
    L147:
        a r26 = null;
    L148:
        if (r20 == null) goto L165;
        Url r27 = r20.getUrl();
        if (r27 == null) goto L165;
        String r28 = r27.getAndroidUrl();
        if (r28 == null) goto L165;
        String r29 = StringsKt.trim(r28).toString();
        if (r29 == null) goto L165;
        if (r29.length() <= 0) goto L158;
        boolean r111 = true;
    L159:
        if (r111 == true) goto L162;
        r29 = null;
    L162:
        if (r29 == null) goto L165;
        String r112 = r29;
    L182:
        if (r26 == null) goto L184;
        String r113 = r26.a;
    L185:
        if (r26 == null) goto L187;
        r11 = r26.getType();
    L187:
        r11 = new MarkdownUrlPreviewInline(r15, r13, r112, r110, r113, r11);
        goto L188
    L184:
        r113 = null;
        goto L185
    L158:
        r111 = false;
    L165:
        if (r20 == null) goto L178;
        Url r30 = r20.getUrl();
        if (r30 == null) goto L178;
        String r31 = r30.getUrl();
        if (r31 == null) goto L178;
        String r32 = StringsKt.trim(r31).toString();
        if (r32 == null) goto L178;
        if (r32.length() <= 0) goto L175;
        boolean r33 = true;
    L176:
        if (r33 == false) goto L178;
    L179:
        if (r32 != null) goto L181;
        r112 = r13;
        goto L182
    L181:
        r112 = r32;
        goto L182
    L175:
        r33 = false;
    L178:
        r32 = null;
        goto L179
    L58:
        if (r20.getUseColorIcon() == false) goto L96;
        UnifiedHeaderInfo r34 = r20.getHeaderInfo();
        if (r34 == null) goto L96;
        ColorIcon r35 = r34.getIcon();
        if (r35 == null) goto L96;
        UDIcon r114 = r35.getUdIcon();
        if (r114 == null) goto L68;
        a r115 = b(r114, null);
        if (r115 == null) goto L68;
    L116:
        if (r115 == null) goto L147;
        String r36 = r115.a;
        if (r36 == null) goto L147;
        String r37 = StringsKt.trim(r36).toString();
        if (r37 == null) goto L147;
        if (r37.length() <= 0) goto L124;
        boolean r116 = true;
    L125:
        if (r116 == true) goto L128;
        r37 = null;
    L128:
        if (r37 == null) goto L147;
        String r117 = r115.getType();
        if (r117 == null) goto L147;
        String r118 = StringsKt.trim(r117).toString();
        if (r118 == null) goto L147;
        if (Intrinsics.areEqual(r118, "image_key") == false) goto L137;
    L140:
        boolean r38 = true;
    L141:
        if (r38 == true) goto L144;
        r118 = null;
    L144:
        if (r118 == null) goto L147;
        r26 = new a(new JSONObject().put("key", r37).put(IPortraitService.TYPE, r118).put("width", Float.valueOf(r5)).put("height", Float.valueOf(r5)).toString(), "photo_with_size");
        goto L148
    L137:
        if (Intrinsics.areEqual(r118, "ud_icon_key") == true) goto L140;
        r38 = false;
        goto L141
    L124:
        r116 = false;
    L68:
        String r119 = c(r35.getThemeColor());
        ImageSet r120 = r35.getImageSet();
        if (r120 == null) goto L83;
        String r121 = r120.getKey();
        if (r121 == null) goto L83;
        String r122 = StringsKt.trim(r121).toString();
        if (r122 == null) goto L83;
        if (r122.length() <= 0) goto L77;
        boolean r123 = true;
    L78:
        if (r123 == true) goto L81;
        r122 = null;
    L81:
        if (r122 == null) goto L83;
        a r39 = new a(e(r122, r119), "image_key");
    L100:
        r115 = r39;
        goto L116
    L77:
        r123 = false;
    L83:
        String r40 = r35.getFaviconUrl();
        if (r40 == null) goto L96;
        String r41 = StringsKt.trim(r40).toString();
        if (r41 == null) goto L96;
        if (r41.length() <= 0) goto L90;
        boolean r124 = true;
    L91:
        if (r124 == true) goto L94;
        r41 = null;
    L94:
        if (r41 == null) goto L96;
        a r125 = new a(e(r41, r119), "image_key");
    L114:
        r115 = r125;
        goto L116
    L90:
        r124 = false;
    L96:
        UDIcon r42 = r20.getUdIcon();
        if (r42 == null) goto L101;
        r39 = b(r42, "text-link-normal");
        if (r39 != null) goto L100;
    L101:
        String r43 = r20.getNetIconKey();
        if (r43 == null) goto L115;
        String r44 = StringsKt.trim(r43).toString();
        if (r44 == null) goto L115;
        if (r44.length() <= 0) goto L108;
        boolean r126 = true;
    L109:
        if (r126 == true) goto L112;
        r44 = null;
    L112:
        if (r44 == null) goto L115;
        r125 = new a(e(r44, "text-link-normal"), "image_key");
        goto L114
    L108:
        r126 = false;
    L115:
        r115 = null;
        goto L116
    L51:
        r25 = false;
        goto L52
    L46:
        r24 = false;
        goto L47
    L41:
        r23 = false;
        goto L42
    L37:
        r110 = r22;
    L34:
        r22 = null;
        goto L35
    L29:
        r20 = null;
        goto L30
    L25:
        r15 = r14;
        goto L26
    L21:
        r13 = r12;
        goto L22
    L17:
        r12 = null;
        goto L19
    L191:
        return r7;
    L197:
        return CollectionsKt.emptyList();
    L5:
        if (r18.isEmpty() == true) goto L8;
        r3 = false;
        goto L9
    }

    public static String d(String r5, String r6, String r7) {
        if (r7 != null) goto L4;
        return r5;
    L4:
        StringBuilder r0 = new StringBuilder();
        r0.append(r5);
        if (StringsKt.contains$default(r5, "?", false, 2, null) == false) goto L7;
        String r8 = "&" + r6 + '=' + Uri.encode(r7);
    L8:
        r0.append(r8);
        return r0.toString();
    L7:
        r8 = "?" + r6 + '=' + Uri.encode(r7);
        goto L8
    }
}
