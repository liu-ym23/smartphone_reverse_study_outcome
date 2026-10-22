package com.bytedance.android.ec.core.imagex.transform;

import com.bytedance.android.ec.core.imagex.ImageExperiments;
import com.bytedance.android.ec.core.imagex.r;
import com.bytedance.android.ec.core.opt.ab.p;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ImageUrlTransformRulesConfigCenter {
    public static final Lazy a = null;
    public static final ImageUrlTransformRulesConfig b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u000e\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R0\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR0\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/transform/ImageUrlTransformRulesConfigCenter$ConfigKeyFinder;", "Ljava/io/Serializable;", "Lcom/bytedance/android/ec/core/imagex/r;", "callerContext", "", "keyOf", "", "settingMap", "Ljava/util/Map;", "getSettingMap", "()Ljava/util/Map;", "setSettingMap", "(Ljava/util/Map;)V", "blockMap", "getBlockMap", "setBlockMap", "<init>", "()V", "Companion", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ConfigKeyFinder implements Serializable {
        public static final a Companion = null;
        private static final long serialVersionUID = 1;

        @SerializedName("block_map")
        private Map<String, String> blockMap;

        @SerializedName("setting_map")
        private Map<String, String> settingMap;

        public static final class a {
            public a() {
            }
        }

        static {
            Companion = new a();
        }

        public ConfigKeyFinder() {
        }

        public final Map<String, String> getBlockMap() {
            return this.blockMap;
        }

        public final Map<String, String> getSettingMap() {
            return this.settingMap;
        }

        public final String keyOf(r r11) {
            Intrinsics.checkNotNullParameter(r11, "callerContext");
            r11.getClass();
            String r0 = r11.f + '_' + r11.g;
            String r1 = r11.f;
            if (StringsKt.isBlank(r1) == false) goto L5;
        L85:
            r11.h("setting_key", "ec_image_url_transform_rules_default");
            return "ec_image_url_transform_rules_default";
        L5:
            if (Intrinsics.areEqual(r1, "ec_default") == true) goto L85;
            Map<String, String> r10 = this.blockMap;
            boolean r12 = true;
            if (r10 != null) goto L10;
        L11:
            Map<String, String> r13 = this.blockMap;
            if (r13 != null) goto L14;
        L16:
            ImageExperiments.G.getClass();
            HashMap r14 = (HashMap) ImageExperiments.c.getValue();
            if ((!r14.isEmpty()) == false) goto L43;
            Object r15 = r14.get(r0);
            if ((r15 instanceof String) == true) goto L21;
            r15 = null;
        L21:
            String r16 = (String) r15;
            if (r16 != null) goto L24;
        L27:
            boolean r17 = true;
        L28:
            if (r17 == false) goto L33;
            Object r18 = r14.get(r1);
            if ((r18 instanceof String) == true) goto L32;
            r18 = null;
        L32:
            r16 = (String) r18;
        L33:
            if (r16 != null) goto L35;
        L38:
            boolean r19 = true;
        L39:
            if (r19 == true) goto L43;
            if (r16 == null) goto L87;
            r11.h("abtest_key", r16);
            return r16;
        L87:
            return null;
        L35:
            if (StringsKt.isBlank(r16) == true) goto L38;
            r19 = false;
            goto L39
        L24:
            if (StringsKt.isBlank(r16) == true) goto L27;
            r17 = false;
        L43:
            Map<String, String> r20 = this.settingMap;
            if (r20 != null) goto L46;
        L49:
            boolean r21 = true;
        L50:
            if (r21 == true) goto L83;
            Map<String, String> r22 = this.settingMap;
            if (r22 == null) goto L58;
            String r23 = r22.get(r0);
            if (r23 == null) goto L58;
            if ((!StringsKt.isBlank(r23)) == false) goto L58;
        L59:
            if (r23 != null) goto L61;
        L64:
            boolean r24 = true;
        L65:
            if (r24 == false) goto L74;
            Map<String, String> r25 = this.settingMap;
            if (r25 == null) goto L73;
            r23 = r25.get(r1);
            if (r23 == null) goto L73;
            if ((!StringsKt.isBlank(r23)) == true) goto L74;
        L73:
            r23 = null;
        L74:
            if (r23 != null) goto L76;
        L79:
            if (r12 == true) goto L83;
            if (r23 == null) goto L88;
            r11.h("setting_key", r23);
            return r23;
        L88:
            return null;
        L76:
            if (StringsKt.isBlank(r23) == true) goto L79;
            r12 = false;
            goto L79
        L61:
            if (StringsKt.isBlank(r23) == true) goto L64;
            r24 = false;
        L58:
            r23 = null;
        L83:
            r11.h("setting_key", "ec_image_url_transform_rules_default");
            return "ec_image_url_transform_rules_default";
        L46:
            if (r20.isEmpty() == true) goto L49;
            r21 = false;
            goto L50
        L14:
            if (r13.containsKey(r0) != true) goto L16;
        L15:
            return null;
        L10:
            if (r10.containsKey(r1) == true) goto L15;
            goto L11
        }

        public final void setBlockMap(Map<String, String> r1) {
            this.blockMap = r1;
        }

        public final void setSettingMap(Map<String, String> r1) {
            this.settingMap = r1;
        }
    }

    static {
        a = LazyKt.lazy(ImageUrlTransformRulesConfigCenter$defaultTransformFixedWidthOptions$2.INSTANCE);
        b = new ImageUrlTransformRulesConfig();
        c = LazyKt.lazy(ImageUrlTransformRulesConfigCenter$configKeyFinder$2.INSTANCE);
        d = LazyKt.lazy(ImageUrlTransformRulesConfigCenter$defaultConfig$2.INSTANCE);
        e = LazyKt.lazy(ImageUrlTransformRulesConfigCenter$configMap$2.INSTANCE);
    }

    public static ImageUrlTransformRulesConfig a(r r10) {
        ImageUrlTransformRulesConfig r0 = (ImageUrlTransformRulesConfig) d.getValue();
        if (r10 != null) goto L5;
        return r0;
    L5:
        String r11 = ((ConfigKeyFinder) c.getValue()).keyOf(r10);
        if (r11 != null) goto L8;
    L11:
        boolean r12 = true;
    L13:
        if (r12 == false) goto L16;
        return null;
    L16:
        if (Intrinsics.areEqual(r11, "ec_image_url_transform_rules_default") == false) goto L18;
        return r0;
    L18:
        ImageUrlTransformRulesConfig r1 = (ImageUrlTransformRulesConfig) ((Map) e.getValue()).get(r11);
        if (r1 != null) goto L33;
        int r13 = p.a;
        Object r14 = b;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L25
        jj4.b r16 = jj4.b.b;     // Catch: Throwable -> L25
        Object r17 = jj4.a.a(r11, ImageUrlTransformRulesConfig.class, r14, false);     // Catch: Throwable -> L25
        if (r17 != null) goto L31;
        Intrinsics.throwNpe();     // Catch: Throwable -> L25
    L31:
        r1 = (ImageUrlTransformRulesConfig) r17;
        Map r18 = (Map) e.getValue();
        r1.setName(r11);
        Unit r19 = Unit.INSTANCE;
        r18.put(r11, r1);
    L25:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        Object r21 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r21) == true) goto L30;
        r14 = r21;
    L30:
        r17 = r14;
    L33:
        if ((!Intrinsics.areEqual(r1, b)) == true) goto L35;
        return null;
    L35:
        return r1;
    L8:
        if (StringsKt.isBlank(r11) == true) goto L11;
        r12 = false;
        goto L13
    }
}
