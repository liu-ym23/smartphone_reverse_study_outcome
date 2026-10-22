package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
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

        public Builder(int r2) {
            this.checkInitialized = null;
            this.fields = new ArrayList(r2);
        }

        public StructuralMessageInfo build() {
            if (this.wasBuilt == true) goto L11;
            if (this.syntax == null) goto L9;
            this.wasBuilt = true;
            Collections.sort(this.fields);
            return new StructuralMessageInfo(this.syntax, this.messageSetWireFormat, this.checkInitialized, (FieldInfo[]) ZeusTransformUtils.preCheckCast(this.fields.toArray(new FieldInfo[0]), FieldInfo[].class, "com.obric.memorydata.plugin"), this.defaultInstance);
        L9:
            throw new IllegalStateException("Must specify a proto syntax");
        L11:
            throw new IllegalStateException("Builder can only build once");
        }

        public void withCheckInitialized(int[] r1) {
            this.checkInitialized = r1;
        }

        public void withDefaultInstance(Object r1) {
            this.defaultInstance = r1;
        }

        public void withField(FieldInfo r2) {
            if (this.wasBuilt == true) goto L7;
            this.fields.add(r2);
            return;
        L7:
            throw new IllegalStateException("Builder can only build once");
        }

        public void withMessageSetWireFormat(boolean r1) {
            this.messageSetWireFormat = r1;
        }

        public void withSyntax(ProtoSyntax r3) {
            this.syntax = (ProtoSyntax) ZeusTransformUtils.preCheckCast(Internal.checkNotNull(r3, "syntax"), ProtoSyntax.class, "com.obric.memorydata.plugin");
        }
    }

    StructuralMessageInfo(ProtoSyntax r1, boolean r2, int[] r3, FieldInfo[] r4, Object r5) {
        this.syntax = r1;
        this.messageSetWireFormat = r2;
        this.checkInitialized = r3;
        this.fields = r4;
        this.defaultInstance = (MessageLite) ZeusTransformUtils.preCheckCast(Internal.checkNotNull(r5, "defaultInstance"), MessageLite.class, "com.obric.memorydata.plugin");
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(int r1) {
        return new Builder(r1);
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
