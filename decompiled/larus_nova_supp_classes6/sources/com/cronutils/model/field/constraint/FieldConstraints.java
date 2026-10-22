package com.cronutils.model.field.constraint;

import com.cronutils.model.field.value.SpecialChar;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import zr7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class FieldConstraints implements Serializable {
    private static final long serialVersionUID = -9112124669329704710L;
    private final Integer endRange;
    private final Map<Integer, Integer> intMapping;
    private final Set<SpecialChar> specialChars;
    private final Integer startRange;
    private final boolean strictRange;
    private final Map<String, Integer> stringMapping;

    public int hashCode() {
        return Objects.hash(new Object[]{this.stringMapping, this.intMapping, this.specialChars, this.startRange, this.endRange, Boolean.valueOf(this.strictRange)});
    }

    public int getEndRange() {
        return this.endRange.intValue();
    }

    public int getStartRange() {
        return this.startRange.intValue();
    }

    public Set<String> getStringMappingKeySet() {
        return this.stringMapping.keySet();
    }

    public Set<SpecialChar> getSpecialChars() {
        return this.specialChars;
    }

    public boolean isStrictRange() {
        return this.strictRange;
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
        FieldConstraints r6 = (FieldConstraints) r5;
        if (this.strictRange == r6.strictRange) goto L13;
    L23:
        return false;
    L13:
        if (this.stringMapping.equals(r6.stringMapping) == false) goto L23;
        if (this.intMapping.equals(r6.intMapping) == false) goto L23;
        if (this.specialChars.equals(r6.specialChars) == false) goto L23;
        if (this.startRange.equals(r6.startRange) == false) goto L23;
        if (this.endRange.equals(r6.endRange) == false) goto L23;
        return true;
    }

    public Integer getIntMappingValue(Integer r2) {
        return this.intMapping.get(r2);
    }

    public Integer getStringMappingValue(String r2) {
        return this.stringMapping.get(r2);
    }

    public boolean isInRange(int r2) {
        if (r2 >= getStartRange()) goto L5;
    L7:
        return false;
    L5:
        if (r2 > getEndRange()) goto L7;
        return true;
    }

    public boolean isPeriodInRange(int r3) {
        if (r3 > 0) goto L4;
    L8:
        return false;
    L4:
        if (r3 > ((getEndRange() - getStartRange()) + 1)) goto L8;
        if (r3 > getEndRange()) goto L8;
        return true;
    }

    public FieldConstraints(Map<String, Integer> r2, Map<Integer, Integer> r3, Set<SpecialChar> r4, int r5, int r6, boolean r7) {
        a.b(r2, "String mapping must not be null");
        this.stringMapping = Collections.unmodifiableMap(r2);
        a.b(r3, "Integer mapping must not be null");
        this.intMapping = Collections.unmodifiableMap(r3);
        a.b(r4, "Special (non-standard) chars set must not be null");
        this.specialChars = Collections.unmodifiableSet(r4);
        this.startRange = Integer.valueOf(r5);
        this.endRange = Integer.valueOf(r6);
        this.strictRange = r7;
    }
}
