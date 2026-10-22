package com.ss.android.lark.pb.usearch;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class DoubaoSearchSceneMeta extends Message<DoubaoSearchSceneMeta, Builder> {
    public static final ProtoAdapter<DoubaoSearchSceneMeta> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final String DEFAULT_PICKER_SCENE = "";
    private static final long serialVersionUID = 0;
    public final String mchat_id;
    public final String mpicker_scene;
    public final DoubaoSearchScene mscene;

    public static final class Builder extends Message.Builder<DoubaoSearchSceneMeta, Builder> {
        public String mchat_id;
        public String mpicker_scene;
        public DoubaoSearchScene mscene;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public DoubaoSearchSceneMeta m2636build() {
            return new DoubaoSearchSceneMeta(this.mscene, this.mchat_id, this.mpicker_scene, super.buildUnknownFields());
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m2636build();
        }

        public Builder chat_id(String r1) {
            this.mchat_id = r1;
            return this;
        }

        public Builder picker_scene(String r1) {
            this.mpicker_scene = r1;
            return this;
        }

        public Builder scene(DoubaoSearchScene r1) {
            this.mscene = r1;
            return this;
        }
    }

    public static final enum DoubaoSearchScene extends Enum<DoubaoSearchScene> implements WireEnum {
        private static final /* synthetic */ DoubaoSearchScene[] $VALUES = null;
        public static final ProtoAdapter<DoubaoSearchScene> ADAPTER = null;
        public static final DoubaoSearchScene PICKER = null;
        public static final DoubaoSearchScene SEARCH_IN_CHAT = null;
        public static final DoubaoSearchScene UNIVERSAL_SEARCH = null;
        public static final DoubaoSearchScene UNKNOWN = null;
        private final int value;

        static {
            DoubaoSearchScene r0 = new DoubaoSearchScene("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            DoubaoSearchScene r1 = new DoubaoSearchScene("UNIVERSAL_SEARCH", 1, 1);
            UNIVERSAL_SEARCH = r1;
            DoubaoSearchScene r3 = new DoubaoSearchScene("SEARCH_IN_CHAT", 2, 2);
            SEARCH_IN_CHAT = r3;
            DoubaoSearchScene r5 = new DoubaoSearchScene("PICKER", 3, 3);
            PICKER = r5;
            $VALUES = new DoubaoSearchScene[]{r0, r1, r3, r5};
            ADAPTER = ProtoAdapter.newEnumAdapter(DoubaoSearchScene.class);
        }

        public static DoubaoSearchScene[] values() {
            return (DoubaoSearchScene[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static DoubaoSearchScene fromValue(int r1) {
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L12;
            return null;
        L12:
            return PICKER;
        L14:
            return SEARCH_IN_CHAT;
        L16:
            return UNIVERSAL_SEARCH;
        L18:
            return UNKNOWN;
        }

        public static DoubaoSearchScene valueOf(String r1) {
            return (DoubaoSearchScene) a.a(DoubaoSearchScene.class, r1);
        }

        private DoubaoSearchScene(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class ProtoAdapter_DoubaoSearchSceneMeta extends ProtoAdapter<DoubaoSearchSceneMeta> {
        public ProtoAdapter_DoubaoSearchSceneMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, DoubaoSearchSceneMeta.class);
        }

        public DoubaoSearchSceneMeta decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mchat_id = "";
            r0.mpicker_scene = "";
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.mscene = (DoubaoSearchScene) DoubaoSearchScene.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.mchat_id = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.mpicker_scene = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m2636build();
        }

        public int encodedSize(DoubaoSearchSceneMeta r6) {
            DoubaoSearchScene r0 = r6.mscene;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = DoubaoSearchScene.ADAPTER.encodedSizeWithTag(1, r0);
        L6:
            String r3 = r6.mchat_id;
            if (r3 == null) goto L9;
            int r4 = ProtoAdapter.STRING.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            String r7 = r6.mpicker_scene;
            if (r7 == null) goto L14;
            r1 = ProtoAdapter.STRING.encodedSizeWithTag(3, r7);
        L14:
            return (r5 + r1) + r6.unknownFields().size();
        L9:
            r4 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m2637decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((DoubaoSearchSceneMeta) r1);
        }

        public void encode(ProtoWriter r4, DoubaoSearchSceneMeta r5) throws IOException {
            DoubaoSearchScene r0 = r5.mscene;
            if (r0 == null) goto L5;
            DoubaoSearchScene.ADAPTER.encodeWithTag(r4, 1, r0);
        L5:
            String r1 = r5.mchat_id;
            if (r1 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r4, 2, r1);
        L8:
            String r2 = r5.mpicker_scene;
            if (r2 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r4, 3, r2);
        L11:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (DoubaoSearchSceneMeta) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DoubaoSearchSceneMeta();
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m2635newBuilder() {
        Builder r0 = new Builder();
        r0.mscene = this.mscene;
        r0.mchat_id = this.mchat_id;
        r0.mpicker_scene = this.mpicker_scene;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return DoubaoSearchSceneMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m2635newBuilder();
    }

    public DoubaoSearchSceneMeta(DoubaoSearchScene r2, String r3, String r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public DoubaoSearchSceneMeta(DoubaoSearchScene r2, String r3, String r4, ByteString r5) {
        super(ADAPTER, r5);
        this.mscene = r2;
        this.mchat_id = r3;
        this.mpicker_scene = r4;
    }
}
