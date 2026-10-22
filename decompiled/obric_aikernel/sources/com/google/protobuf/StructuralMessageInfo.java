package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
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

        public Builder(int r10) {
            this.checkInitialized = null;
            this.fields = new ArrayList(r10);
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

        public void withCheckInitialized(int[] r10) {
            this.checkInitialized = r10;
        }

        public void withDefaultInstance(Object r10) {
            this.defaultInstance = r10;
        }

        public void withField(FieldInfo r10) {
            if (this.wasBuilt == true) goto L7;
            this.fields.add(r10);
            return;
        L7:
            throw new IllegalStateException("Builder can only build once");
        }

        public void withMessageSetWireFormat(boolean r10) {
            this.messageSetWireFormat = r10;
        }

        public void withSyntax(ProtoSyntax r10) {
            this.syntax = (ProtoSyntax) Internal.checkNotNull(r10, "syntax");
        }
    }

    StructuralMessageInfo(ProtoSyntax r10, boolean r11, int[] r12, FieldInfo[] r13, Object r14) {
        this.syntax = r10;
        this.messageSetWireFormat = r11;
        this.checkInitialized = r12;
        this.fields = r13;
        this.defaultInstance = (MessageLite) Internal.checkNotNull(r14, "defaultInstance");
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(int r10) {
        return new Builder(r10);
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
}
