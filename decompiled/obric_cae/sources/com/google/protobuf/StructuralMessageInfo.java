package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
final class StructuralMessageInfo implements MessageInfo {
    private final int[] checkInitialized;
    private final MessageLite defaultInstance;
    private final FieldInfo[] fields;
    private final boolean messageSetWireFormat;
    private final ProtoSyntax syntax;

    public static final class Builder {
        private int[] checkInitialized;
        private Object defaultInstance;
        private final List<FieldInfo> fields;
        private boolean messageSetWireFormat;
        private ProtoSyntax syntax;
        private boolean wasBuilt;

        public Builder() {
            this.checkInitialized = null;
            this.fields = new ArrayList();
        }

        public StructuralMessageInfo build() {
            if (this.wasBuilt == true) goto L11;
            if (this.syntax == null) goto L9;
            this.wasBuilt = true;
            Collections.sort(this.fields);
            return new StructuralMessageInfo(this.syntax, this.messageSetWireFormat, this.checkInitialized, (FieldInfo[]) this.fields.toArray(new FieldInfo[0]), this.defaultInstance);
        L9:
            throw new IllegalStateException("Must specify a proto syntax");
        L11:
            throw new IllegalStateException("Builder can only build once");
        }

        public void withCheckInitialized(int[] r8) {
            this.checkInitialized = r8;
        }

        public void withDefaultInstance(Object r8) {
            this.defaultInstance = r8;
        }

        public void withField(FieldInfo r8) {
            if (this.wasBuilt == true) goto L7;
            this.fields.add(r8);
            return;
        L7:
            throw new IllegalStateException("Builder can only build once");
        }

        public void withMessageSetWireFormat(boolean r8) {
            this.messageSetWireFormat = r8;
        }

        public void withSyntax(ProtoSyntax r8) {
            this.syntax = (ProtoSyntax) Internal.checkNotNull(r8, "syntax");
        }

        public Builder(int r8) {
            this.checkInitialized = null;
            this.fields = new ArrayList(r8);
        }
    }

    public StructuralMessageInfo(ProtoSyntax r8, boolean r10, int[] r11, FieldInfo[] r12, Object r13) {
        this.syntax = r8;
        this.messageSetWireFormat = r10;
        this.checkInitialized = r11;
        this.fields = r12;
        this.defaultInstance = (MessageLite) Internal.checkNotNull(r13, "defaultInstance");
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int[] getCheckInitialized() {
        return this.checkInitialized;
    }

    @Override // com.google.protobuf.MessageInfo
    public MessageLite getDefaultInstance() {
        return this.defaultInstance;
    }

    public FieldInfo[] getFields() {
        return this.fields;
    }

    @Override // com.google.protobuf.MessageInfo
    public ProtoSyntax getSyntax() {
        return this.syntax;
    }

    @Override // com.google.protobuf.MessageInfo
    public boolean isMessageSetWireFormat() {
        return this.messageSetWireFormat;
    }

    public static Builder newBuilder(int r8) {
        return new Builder(r8);
    }
}
