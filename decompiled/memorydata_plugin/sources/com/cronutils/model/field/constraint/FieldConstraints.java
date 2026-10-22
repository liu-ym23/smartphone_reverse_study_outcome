package com.cronutils.model.field.constraint;

import com.cronutils.model.field.value.SpecialChar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class FieldConstraints implements Serializable {
    private static final long serialVersionUID = -9112124669329704710L;
    private final Integer endRange;
    private final Map<Integer, Integer> intMapping;
    private final Set<SpecialChar> specialChars;
    private final Integer startRange;
    private final boolean strictRange;
    private final Map<String, Integer> stringMapping;

    public FieldConstraints(Map<String, Integer> r3, Map<Integer, Integer> r4, Set<SpecialChar> r5, int r6, int r7, boolean r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Set r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        this.stringMapping = Collections.unmodifiableMap((Map) ZeusTransformUtils.preCheckCast(com.cronutils.utils.a.a(r9, "String mapping must not be null"), Map.class, "com.obric.memorydata.plugin"));
        this.intMapping = Collections.unmodifiableMap((Map) ZeusTransformUtils.preCheckCast(com.cronutils.utils.a.a(r10, "Integer mapping must not be null"), Map.class, "com.obric.memorydata.plugin"));
        this.specialChars = Collections.unmodifiableSet((Set) ZeusTransformUtils.preCheckCast(com.cronutils.utils.a.a(r11, "Special (non-standard) chars set must not be null"), Set.class, "com.obric.memorydata.plugin"));
        this.startRange = Integer.valueOf(r6);
        this.endRange = Integer.valueOf(r7);
        this.strictRange = r8;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L25:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L25;
        FieldConstraints r6 = (FieldConstraints) ZeusTransformUtils.preCheckCast(r5, FieldConstraints.class, "com.obric.memorydata.plugin");
        if (this.strictRange != r6.strictRange) goto L24;
        if (this.stringMapping.equals(r6.stringMapping) == false) goto L24;
        if (this.intMapping.equals(r6.intMapping) == false) goto L24;
        if (this.specialChars.equals(r6.specialChars) == false) goto L24;
        if (this.startRange.equals(r6.startRange) == false) goto L24;
        if (this.endRange.equals(r6.endRange) == false) goto L24;
        return true;
    L24:
        return false;
    }

    public int getEndRange() {
        return this.endRange.intValue();
    }

    public Integer getIntMappingValue(Integer r2) {
        return (Integer) ZeusTransformUtils.preCheckCast(this.intMapping.get(r2), Integer.class, "com.obric.memorydata.plugin");
    }

    public Set<SpecialChar> getSpecialChars() {
        return this.specialChars;
    }

    public int getStartRange() {
        return this.startRange.intValue();
    }

    public Set<String> getStringMappingKeySet() {
        return this.stringMapping.keySet();
    }

    public Integer getStringMappingValue(String r2) {
        return (Integer) ZeusTransformUtils.preCheckCast(this.stringMapping.get(r2), Integer.class, "com.obric.memorydata.plugin");
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.stringMapping, this.intMapping, this.specialChars, this.startRange, this.endRange, Boolean.valueOf(this.strictRange)});
    }

    public boolean isInRange(int r2) {
        if (r2 >= getStartRange()) goto L5;
    L7:
        return false;
    L5:
        if (r2 > getEndRange()) goto L7;
        return true;
    }

    public boolean isPeriodInRange(int r4) {
        if (r4 > 0) goto L5;
    L9:
        return false;
    L5:
        if (r4 > ((getEndRange() - getStartRange()) + 1)) goto L9;
        if (r4 > getEndRange()) goto L9;
        return true;
    }

    public boolean isStrictRange() {
        return this.strictRange;
    }
}
