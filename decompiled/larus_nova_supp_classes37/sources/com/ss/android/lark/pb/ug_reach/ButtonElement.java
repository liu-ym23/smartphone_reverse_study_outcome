package com.ss.android.lark.pb.ug_reach;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ButtonElement extends Message<ButtonElement, Builder> {
    public static final ProtoAdapter<ButtonElement> ADAPTER = null;
    public static final String DEFAULT_BACKGROUND_COLOR = "";
    public static final String DEFAULT_CALLBACK_EVENT_NAME = "";
    public static final String DEFAULT_LINK = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_TEXT = "";
    public static final String DEFAULT_TEXT_COLOR = "";
    private static final long serialVersionUID = 0;
    public final String mbackground_color;
    public final String mcallback_event_name;
    public final String mlink;
    public final String mname;
    public final String mtext;
    public final String mtext_color;

    public static final class Builder extends Message.Builder<ButtonElement, Builder> {
        public String mbackground_color;
        public String mcallback_event_name;
        public String mlink;
        public String mname;
        public String mtext;
        public String mtext_color;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public ButtonElement m2429build() {
            return new ButtonElement(this.mname, this.mtext, this.mbackground_color, this.mtext_color, this.mcallback_event_name, this.mlink, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2429build();
        }

        public Builder background_color(String r1) {
            this.mbackground_color = r1;
            return this;
        }

        public Builder callback_event_name(String r1) {
            this.mcallback_event_name = r1;
            return this;
        }

        public Builder link(String r1) {
            this.mlink = r1;
            return this;
        }

        public Builder name(String r1) {
            this.mname = r1;
            return this;
        }

        public Builder text(String r1) {
            this.mtext = r1;
            return this;
        }

        public Builder text_color(String r1) {
            this.mtext_color = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_ButtonElement extends ProtoAdapter<ButtonElement> {
        public ProtoAdapter_ButtonElement() {
            super(FieldEncoding.LENGTH_DELIMITED, ButtonElement.class);
        }

        public ButtonElement decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mname = "";
            r0.mtext = "";
            r0.mbackground_color = "";
            r0.mtext_color = "";
            r0.mcallback_event_name = "";
            r0.mlink = "";
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L13;
            switch(r3) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r0.mlink = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L8:
            r0.mcallback_event_name = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L9:
            r0.mtext_color = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L10:
            r0.mbackground_color = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L11:
            r0.mtext = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L12:
            r0.mname = (String) ProtoAdapter.STRING.decode(r7);
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L13:
            r7.endMessage(r1);
            return r0.m2429build();
        }

        public int encodedSize(ButtonElement r6) {
            String r0 = r6.mname;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.STRING.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mtext;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mbackground_color;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            String r10 = r6.mtext_color;
            if (r10 == null) goto L17;
            int r11 = ProtoAdapter.STRING.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            String r13 = r6.mcallback_event_name;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.STRING.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            String r16 = r6.mlink;
            if (r16 == null) goto L26;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(6, r16);
        L26:
            return (r15 + r1) + r6.unknownFields().size();
        L21:
            r14 = 0;
            goto L22
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2430decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((ButtonElement) r1);
        }

        public void encode(ProtoWriter r4, ButtonElement r5) throws IOException {
            String r0 = r5.mname;
            if (r0 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mtext;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mbackground_color;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            String r3 = r5.mtext_color;
            if (r3 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r4, 4, r3);
        L14:
            String r6 = r5.mcallback_event_name;
            if (r6 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r4, 5, r6);
        L17:
            String r7 = r5.mlink;
            if (r7 == null) goto L20;
            ProtoAdapter.STRING.encodeWithTag(r4, 6, r7);
        L20:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (ButtonElement) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ButtonElement();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2428newBuilder() {
        Builder r0 = new Builder();
        r0.mname = this.mname;
        r0.mtext = this.mtext;
        r0.mbackground_color = this.mbackground_color;
        r0.mtext_color = this.mtext_color;
        r0.mcallback_event_name = this.mcallback_event_name;
        r0.mlink = this.mlink;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return ButtonElement.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2428newBuilder();
    }

    public ButtonElement(String r9, String r10, String r11, String r12, String r13, String r14) {
        this(r9, r10, r11, r12, r13, r14, ByteString.EMPTY);
    }

    public ButtonElement(String r2, String r3, String r4, String r5, String r6, String r7, ByteString r8) {
        super(ADAPTER, r8);
        this.mname = r2;
        this.mtext = r3;
        this.mbackground_color = r4;
        this.mtext_color = r5;
        this.mcallback_event_name = r6;
        this.mlink = r7;
    }
}
