package com.bytedance.android.ec.core.imagex.transform;

import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\f\u0018\u0000  2\u00020\u0001:\u0002!\"B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R*\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R6\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006#"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/transform/ImageUrlTransformRules;", "Ljava/io/Serializable;", "", "origin", "Lcom/bytedance/android/ec/core/imagex/transform/a;", "resizeConfig", "transform", "", "Lcom/bytedance/android/ec/core/imagex/transform/ImageUrlTransformRules$TransformRuleFilter;", "filters", "[Lcom/bytedance/android/ec/core/imagex/transform/ImageUrlTransformRules$TransformRuleFilter;", "getFilters", "()[Lcom/bytedance/android/ec/core/imagex/transform/ImageUrlTransformRules$TransformRuleFilter;", "setFilters", "([Lcom/bytedance/android/ec/core/imagex/transform/ImageUrlTransformRules$TransformRuleFilter;)V", "", "Lcom/bytedance/android/ec/core/imagex/transform/ImageUrlTransformRule;", "defaultRules", "Ljava/util/List;", "getDefaultRules", "()Ljava/util/List;", "setDefaultRules", "(Ljava/util/List;)V", "", "transformRules", "Ljava/util/Map;", "getTransformRules", "()Ljava/util/Map;", "setTransformRules", "(Ljava/util/Map;)V", "<init>", "()V", "Companion", "a", "TransformRuleFilter", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImageUrlTransformRules implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("default_rules")
    private List<ImageUrlTransformRule> defaultRules;

    @SerializedName("filters")
    private TransformRuleFilter[] filters;

    @SerializedName("transform_rules")
    private Map<String, ? extends List<ImageUrlTransformRule>> transformRules;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/ec/core/imagex/transform/ImageUrlTransformRules$TransformRuleFilter;", "Ljava/io/Serializable;", "", "origin", "keyOfRule", "pattern", "Ljava/lang/String;", "getPattern", "()Ljava/lang/String;", "setPattern", "(Ljava/lang/String;)V", "", "filterType", "Ljava/lang/Integer;", "getFilterType", "()Ljava/lang/Integer;", "setFilterType", "(Ljava/lang/Integer;)V", "groupIndex", "getGroupIndex", "setGroupIndex", "targetRule", "getTargetRule", "setTargetRule", "<init>", "()V", "Companion", "a", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class TransformRuleFilter implements Serializable {
        public static final a Companion = null;
        private static final long serialVersionUID = 1;

        @SerializedName("filter_type")
        private Integer filterType;

        @SerializedName("group_index")
        private Integer groupIndex;

        @SerializedName("pattern")
        private String pattern;

        @SerializedName("target_rule")
        private String targetRule;

        public static final class a {
            public a() {
            }
        }

        static {
            Companion = new a();
        }

        public TransformRuleFilter() {
        }

        public final Integer getFilterType() {
            return this.filterType;
        }

        public final Integer getGroupIndex() {
            return this.groupIndex;
        }

        public final String getPattern() {
            return this.pattern;
        }

        public final String getTargetRule() {
            return this.targetRule;
        }

        public final String keyOfRule(String r10) {
            Intrinsics.checkNotNullParameter(r10, "origin");
            if (StringsKt.isBlank(r10) == true) goto L37;
            String r0 = this.pattern;
            if (r0 != null) goto L7;
        L10:
            boolean r1 = true;
        L11:
            if (r1 == true) goto L37;
            if (this.filterType == null) goto L37;
            String r11 = this.pattern;
            Intrinsics.checkNotNull(r11);
            MatchResult r12 = Regex.find$default(new Regex(r11), r10, 0, 2, null);
            if (r12 != null) goto L18;
            return null;
        L18:
            Integer r13 = this.filterType;
            if (r13 != null) goto L22;
        L31:
            if (r13 == null) goto L37;
            if (r13.intValue() != 1) goto L37;
            return a2.d(this.targetRule);
        L22:
            if (r13.intValue() != 0) goto L31;
            Integer r14 = this.groupIndex;
            if (r14 == null) goto L38;
            int r15 = r14.intValue();
            List r16 = r12.getGroupValues();
            int r17 = r16.size();
            if (r15 < 0) goto L40;
            if (r17 > r15) goto L30;
            return null;
        L30:
            return (String) ListProtector.get(r16, r15);
        L40:
            return null;
        L38:
            return null;
        L7:
            if (StringsKt.isBlank(r0) == true) goto L10;
            r1 = false;
        L37:
            return null;
        }

        public final void setFilterType(Integer r1) {
            this.filterType = r1;
        }

        public final void setGroupIndex(Integer r1) {
            this.groupIndex = r1;
        }

        public final void setPattern(String r1) {
            this.pattern = r1;
        }

        public final void setTargetRule(String r1) {
            this.targetRule = r1;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ImageUrlTransformRules() {
    }

    public final List<ImageUrlTransformRule> getDefaultRules() {
        return this.defaultRules;
    }

    public final TransformRuleFilter[] getFilters() {
        return this.filters;
    }

    public final Map<String, List<ImageUrlTransformRule>> getTransformRules() {
        return this.transformRules;
    }

    public final void setDefaultRules(List<ImageUrlTransformRule> r1) {
        this.defaultRules = r1;
    }

    public final void setFilters(TransformRuleFilter[] r1) {
        this.filters = r1;
    }

    public final void setTransformRules(Map<String, ? extends List<ImageUrlTransformRule>> r1) {
        this.transformRules = r1;
    }

    public final String transform(String r10, com.bytedance.android.ec.core.imagex.transform.a r11) {
        Intrinsics.checkNotNullParameter(r10, "origin");
        TransformRuleFilter[] r0 = this.filters;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L11:
        boolean r12 = true;
    L13:
        if (r12 == false) goto L15;
        List<ImageUrlTransformRule> r13 = this.defaultRules;
    L58:
        List<ImageUrlTransformRule> r14 = r13;
        if (r14 != null) goto L61;
    L64:
        boolean r15 = true;
    L65:
        if (r15 == false) goto L67;
        return null;
    L67:
        Iterator<T> r16 = r13.iterator();
        String r17 = null;
    L69:
        if (r16.hasNext() == false) goto L83;
        String r18 = ((ImageUrlTransformRule) r16.next()).transform(r10, r11);
        if (r18 != null) goto L73;
    L76:
        boolean r19 = true;
    L78:
        if ((!r19) == true) goto L81;
        r18 = null;
    L81:
        if (r18 == null) goto L69;
        r17 = r18;
        goto L69
    L73:
        if (StringsKt.isBlank(r18) == true) goto L76;
        r19 = false;
        goto L78
    L83:
        if (r17 != null) goto L85;
    L86:
        r1 = true;
    L88:
        if ((!r1) == true) goto L90;
        return null;
    L90:
        return r17;
    L85:
        if (StringsKt.isBlank(r17) == false) goto L88;
    L61:
        if (r14.isEmpty() == true) goto L64;
        r15 = false;
        goto L65
    L15:
        Map<String, ? extends List<ImageUrlTransformRule>> r20 = this.transformRules;
        if (r20 != null) goto L18;
    L21:
        boolean r21 = true;
    L22:
        if (r21 == true) goto L57;
        TransformRuleFilter[] r22 = this.filters;
        if (r22 == null) goto L42;
        int r23 = r22.length;
        String r24 = null;
        int r25 = 0;
    L27:
        if (r25 >= r23) goto L43;
        String r26 = r22[r25].keyOfRule(r10);
        if (r26 != null) goto L31;
    L34:
        boolean r27 = true;
    L36:
        if ((!r27) == true) goto L39;
        r26 = null;
    L39:
        if (r26 == null) goto L41;
        r24 = r26;
    L41:
        r25 = r25 + 1;
        goto L27
    L31:
        if (StringsKt.isBlank(r26) == true) goto L34;
        r27 = false;
    L43:
        if (r24 != null) goto L45;
    L48:
        boolean r28 = true;
    L50:
        if ((!r28) == false) goto L52;
        String r29 = r24;
    L53:
        if (r29 == null) goto L57;
        Map<String, ? extends List<ImageUrlTransformRule>> r30 = this.transformRules;
        if (r30 == null) goto L57;
        r13 = r30.get(r24);
        goto L58
    L52:
        r29 = null;
        goto L53
    L45:
        if (StringsKt.isBlank(r24) == true) goto L48;
        r28 = false;
        goto L50
    L42:
        r24 = null;
    L57:
        r13 = null;
        goto L58
    L18:
        if (r20.isEmpty() == true) goto L21;
        r21 = false;
        goto L22
    L5:
        if (r0.length != 0) goto L7;
        boolean r31 = true;
    L8:
        if (r31 == true) goto L11;
        r12 = false;
        goto L13
    L7:
        r31 = false;
        goto L8
    }
}
