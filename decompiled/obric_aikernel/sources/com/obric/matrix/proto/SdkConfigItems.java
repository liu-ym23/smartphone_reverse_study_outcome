package com.obric.matrix.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import d6.c;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
public final class SdkConfigItems extends Message<SdkConfigItems, a> {
    public static final ProtoAdapter<SdkConfigItems> ADAPTER = null;
    public static final Boolean DEFAULT_ISALLUSEBIND = null;
    public static final Integer DEFAULT_POLLINGINTERVAL = null;
    public static final Integer DEFAULT_SENDCMDTIMEOUT = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    @c("extraConfigs")
    public final Map<String, String> extraConfigs;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 6)
    @c("forceUseOldBindCmd")
    public final List<Integer> forceUseOldBindCmd;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    @c("isAllUseBind")
    public final Boolean isAllUseBind;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    @c("pollingInterval")
    public final Integer pollingInterval;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    @c("sendCmdTimeout")
    public final Integer sendCmdTimeout;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", label = WireField.Label.REPEATED, tag = 2)
    @c("useBindCmd")
    public final List<Integer> useBindCmd;

    public static final class a extends Message.Builder<SdkConfigItems, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Boolean f6077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<Integer> f6078b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f6079c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f6080d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Map<String, String> f6081e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<Integer> f6082f;

        public a() {
            this.f6077a = Boolean.FALSE;
            this.f6079c = 0;
            this.f6080d = 0;
            this.f6078b = Internal.newMutableList();
            this.f6081e = Internal.newMutableMap();
            this.f6082f = Internal.newMutableList();
        }

        public SdkConfigItems a() {
            return new SdkConfigItems(this.f6077a, this.f6078b, this.f6079c, this.f6080d, this.f6081e, this.f6082f, super.buildUnknownFields());
        }

        public a b(Boolean r10) {
            this.f6077a = r10;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return a();
        }

        public a c(Integer r10) {
            this.f6080d = r10;
            return this;
        }

        public a d(Integer r10) {
            this.f6079c = r10;
            return this;
        }
    }

    private static final class b extends ProtoAdapter<SdkConfigItems> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProtoAdapter<Map<String, String>> f6083a;

        public b() {
            super(FieldEncoding.LENGTH_DELIMITED, SdkConfigItems.class);
            ProtoAdapter<String> r10 = ProtoAdapter.STRING;
            this.f6083a = ProtoAdapter.newMapAdapter(r10, r10);
        }

        public SdkConfigItems a(ProtoReader r10) {
            a r11 = new a();
            long r12 = r10.beginMessage();
        L3:
            int r13 = r10.nextTag();
            if (r13 == (-1)) goto L14;
            switch(r13) {
                case 1: goto L13;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            List<Integer> r14 = r11.f6082f;
        L12:
            r14.add(ProtoAdapter.INT32.decode(r10));
            goto L3
        L8:
            r11.f6081e.putAll(this.f6083a.decode(r10));
            goto L3
        L9:
            r11.c(ProtoAdapter.INT32.decode(r10));
            goto L3
        L10:
            r11.d(ProtoAdapter.INT32.decode(r10));
            goto L3
        L11:
            r14 = r11.f6078b;
            goto L12
        L13:
            r11.b(ProtoAdapter.BOOL.decode(r10));
            goto L3
        L6:
            FieldEncoding r15 = r10.peekFieldEncoding();
            r11.addUnknownField(r13, r15, r15.rawProtoAdapter().decode(r10));
            goto L3
        L14:
            r10.endMessage(r12);
            return r11.a();
        }

        public void b(ProtoWriter r10, SdkConfigItems r11) {
            ProtoAdapter.BOOL.encodeWithTag(r10, 1, r11.isAllUseBind);
            ProtoAdapter<Integer> r12 = ProtoAdapter.INT32;
            r12.asRepeated().encodeWithTag(r10, 2, r11.useBindCmd);
            r12.encodeWithTag(r10, 3, r11.sendCmdTimeout);
            r12.encodeWithTag(r10, 4, r11.pollingInterval);
            this.f6083a.encodeWithTag(r10, 5, r11.extraConfigs);
            r12.asRepeated().encodeWithTag(r10, 6, r11.forceUseOldBindCmd);
            r10.writeBytes(r11.unknownFields());
        }

        public int c(SdkConfigItems r10) {
            int r11 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r10.isAllUseBind);
            ProtoAdapter<Integer> r12 = ProtoAdapter.INT32;
            return (((((r11 + r12.asRepeated().encodedSizeWithTag(2, r10.useBindCmd)) + r12.encodedSizeWithTag(3, r10.sendCmdTimeout)) + r12.encodedSizeWithTag(4, r10.pollingInterval)) + this.f6083a.encodedSizeWithTag(5, r10.extraConfigs)) + r12.asRepeated().encodedSizeWithTag(6, r10.forceUseOldBindCmd)) + r10.unknownFields().size();
        }

        public SdkConfigItems d(SdkConfigItems r10) {
            a r11 = r10.newBuilder();
            r11.clearUnknownFields();
            return r11.a();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkConfigItems decode(ProtoReader r10) {
            return a(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r10, SdkConfigItems r11) {
            b(r10, r11);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SdkConfigItems r10) {
            return c(r10);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SdkConfigItems redact(SdkConfigItems r10) {
            return d(r10);
        }
    }

    static {
        ADAPTER = new b();
        DEFAULT_ISALLUSEBIND = Boolean.FALSE;
        DEFAULT_SENDCMDTIMEOUT = 0;
        DEFAULT_POLLINGINTERVAL = 0;
    }

    public SdkConfigItems(Boolean r10, List<Integer> r11, Integer r12, Integer r13, Map<String, String> r14, List<Integer> r15) {
        this(r10, r11, r12, r13, r14, r15, ByteString.EMPTY);
    }

    public SdkConfigItems(Boolean r10, List<Integer> r11, Integer r12, Integer r13, Map<String, String> r14, List<Integer> r15, ByteString r16) {
        super(ADAPTER, r16);
        this.isAllUseBind = r10;
        this.useBindCmd = Internal.immutableCopyOf("useBindCmd", r11);
        this.sendCmdTimeout = r12;
        this.pollingInterval = r13;
        this.extraConfigs = Internal.immutableCopyOf("extraConfigs", r14);
        this.forceUseOldBindCmd = Internal.immutableCopyOf("forceUseOldBindCmd", r15);
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof SdkConfigItems) == true) goto L8;
        return false;
    L8:
        SdkConfigItems r11 = (SdkConfigItems) r10;
        if (unknownFields().equals(r11.unknownFields()) == false) goto L24;
        if (Internal.equals(this.isAllUseBind, r11.isAllUseBind) == false) goto L24;
        if (this.useBindCmd.equals(r11.useBindCmd) == false) goto L24;
        if (Internal.equals(this.sendCmdTimeout, r11.sendCmdTimeout) == false) goto L24;
        if (Internal.equals(this.pollingInterval, r11.pollingInterval) == false) goto L24;
        if (this.extraConfigs.equals(r11.extraConfigs) == false) goto L24;
        if (this.forceUseOldBindCmd.equals(r11.forceUseOldBindCmd) == false) goto L24;
        return true;
    L24:
        return false;
    }

    public int hashCode() {
        int r10 = this.hashCode;
        if (r10 != 0) goto L17;
        int r11 = unknownFields().hashCode() * 37;
        Boolean r12 = this.isAllUseBind;
        int r13 = 0;
        if (r12 == null) goto L7;
        int r14 = r12.hashCode();
    L8:
        int r15 = (((r11 + r14) * 37) + this.useBindCmd.hashCode()) * 37;
        Integer r16 = this.sendCmdTimeout;
        if (r16 == null) goto L11;
        int r17 = r16.hashCode();
    L12:
        int r18 = (r15 + r17) * 37;
        Integer r19 = this.pollingInterval;
        if (r19 == null) goto L15;
        r13 = r19.hashCode();
    L15:
        int r20 = ((((r18 + r13) * 37) + this.extraConfigs.hashCode()) * 37) + this.forceUseOldBindCmd.hashCode();
        this.hashCode = r20;
        return r20;
    L11:
        r17 = 0;
        goto L12
    L7:
        r14 = 0;
        goto L8
    L17:
        return r10;
    }

    @Override // com.squareup.wire.Message
    public a newBuilder() {
        a r10 = new a();
        r10.f6077a = this.isAllUseBind;
        r10.f6078b = Internal.copyOf("useBindCmd", this.useBindCmd);
        r10.f6079c = this.sendCmdTimeout;
        r10.f6080d = this.pollingInterval;
        r10.f6081e = Internal.copyOf("extraConfigs", this.extraConfigs);
        r10.f6082f = Internal.copyOf("forceUseOldBindCmd", this.forceUseOldBindCmd);
        r10.addUnknownFields(unknownFields());
        return r10;
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r10 = new StringBuilder();
        if (this.isAllUseBind == null) goto L5;
        r10.append(", isAllUseBind=");
        r10.append(this.isAllUseBind);
    L5:
        List<Integer> r11 = this.useBindCmd;
        if (r11 == null) goto L11;
        if (r11.isEmpty() == true) goto L11;
        r10.append(", useBindCmd=");
        r10.append(this.useBindCmd);
    L11:
        if (this.sendCmdTimeout == null) goto L14;
        r10.append(", sendCmdTimeout=");
        r10.append(this.sendCmdTimeout);
    L14:
        if (this.pollingInterval == null) goto L16;
        r10.append(", pollingInterval=");
        r10.append(this.pollingInterval);
    L16:
        Map<String, String> r12 = this.extraConfigs;
        if (r12 != null) goto L19;
    L21:
        List<Integer> r13 = this.forceUseOldBindCmd;
        if (r13 != null) goto L24;
    L26:
        StringBuilder r14 = r10.replace(0, 2, "SdkConfigItems{");
        r14.append('}');
        return r14.toString();
    L24:
        if (r13.isEmpty() == true) goto L26;
        r10.append(", forceUseOldBindCmd=");
        r10.append(this.forceUseOldBindCmd);
        goto L26
    L19:
        if (r12.isEmpty() == true) goto L21;
        r10.append(", extraConfigs=");
        r10.append(this.extraConfigs);
        goto L21
    }
}
