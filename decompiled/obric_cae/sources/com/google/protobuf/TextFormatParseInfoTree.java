package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TextFormatParseInfoTree {
    private Map<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> locationsFromField;
    Map<Descriptors.FieldDescriptor, List<TextFormatParseInfoTree>> subtreesFromField;

    /* JADX INFO: renamed from: com.google.protobuf.TextFormatParseInfoTree$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private Map<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> locationsFromField;
        private Map<Descriptors.FieldDescriptor, List<Builder>> subtreeBuildersFromField;

        private Builder() {
            this.locationsFromField = new HashMap();
            this.subtreeBuildersFromField = new HashMap();
        }

        public TextFormatParseInfoTree build() {
            return new TextFormatParseInfoTree(this.locationsFromField, this.subtreeBuildersFromField, null);
        }

        public Builder getBuilderForSubMessageField(Descriptors.FieldDescriptor r8) {
            List<Builder> r10 = this.subtreeBuildersFromField.get(r8);
            if (r10 != null) goto L5;
            r10 = new ArrayList();
            this.subtreeBuildersFromField.put(r8, r10);
        L5:
            Builder r11 = new Builder();
            r10.add(r11);
            return r11;
        }

        public Builder setLocation(Descriptors.FieldDescriptor r8, TextFormatParseLocation r10) {
            List<TextFormatParseLocation> r11 = this.locationsFromField.get(r8);
            if (r11 != null) goto L5;
            r11 = new ArrayList();
            this.locationsFromField.put(r8, r11);
        L5:
            r11.add(r10);
            return this;
        }

        public /* synthetic */ Builder(AnonymousClass1 r8) {
            this();
        }
    }

    private TextFormatParseInfoTree(Map<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> r8, Map<Descriptors.FieldDescriptor, List<Builder>> r10) {
        HashMap r11 = new HashMap();
        Iterator<Map.Entry<Descriptors.FieldDescriptor, List<TextFormatParseLocation>>> r12 = r8.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Map.Entry<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> r13 = r12.next();
        r11.put(r13.getKey(), Collections.unmodifiableList(r13.getValue()));
        goto L4
    L6:
        this.locationsFromField = Collections.unmodifiableMap(r11);
        HashMap r14 = new HashMap();
        Iterator<Map.Entry<Descriptors.FieldDescriptor, List<Builder>>> r15 = r10.entrySet().iterator();
    L8:
        if (r15.hasNext() == false) goto L14;
        Map.Entry<Descriptors.FieldDescriptor, List<Builder>> r16 = r15.next();
        ArrayList r17 = new ArrayList();
        Iterator<Builder> r18 = r16.getValue().iterator();
    L11:
        if (r18.hasNext() == false) goto L13;
        r17.add(r18.next().build());
        goto L11
    L13:
        r14.put(r16.getKey(), Collections.unmodifiableList(r17));
        goto L8
    L14:
        this.subtreesFromField = Collections.unmodifiableMap(r14);
    }

    public static Builder builder() {
        return new Builder(null);
    }

    private static <T> T getFromList(List<T> r8, int r10, Descriptors.FieldDescriptor r11) {
        if (r10 >= r8.size()) goto L8;
        if (r10 < 0) goto L8;
        return r8.get(r10);
    L8:
        Object[] r12 = new Object[2];
        if (r11 != null) goto L11;
        String r13 = "<null>";
    L12:
        r12[0] = r13;
        r12[1] = Integer.valueOf(r10);
        throw new IllegalArgumentException(String.format("Illegal index field: %s, index %d", r12));
    L11:
        r13 = r11.getName();
        goto L12
    }

    public TextFormatParseLocation getLocation(Descriptors.FieldDescriptor r8, int r10) {
        return (TextFormatParseLocation) getFromList(getLocations(r8), r10, r8);
    }

    public List<TextFormatParseLocation> getLocations(Descriptors.FieldDescriptor r8) {
        List<TextFormatParseLocation> r10 = this.locationsFromField.get(r8);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return Collections.emptyList();
    }

    public TextFormatParseInfoTree getNestedTree(Descriptors.FieldDescriptor r8, int r10) {
        return (TextFormatParseInfoTree) getFromList(getNestedTrees(r8), r10, r8);
    }

    public List<TextFormatParseInfoTree> getNestedTrees(Descriptors.FieldDescriptor r8) {
        List<TextFormatParseInfoTree> r10 = this.subtreesFromField.get(r8);
        if (r10 == null) goto L5;
        return r10;
    L5:
        return Collections.emptyList();
    }

    public /* synthetic */ TextFormatParseInfoTree(Map r8, Map r10, AnonymousClass1 r11) {
        this(r8, r10);
    }
}
