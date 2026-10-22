package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.lark.pb.entities.ImageSetPassThrough;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MyAIScene extends Message<MyAIScene, Builder> {
    public static final ProtoAdapter<MyAIScene> ADAPTER = null;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final String DEFAULT_GREETING = "";
    public static final Boolean DEFAULT_IS_OFFICIAL = null;
    public static final Boolean DEFAULT_IS_PRESET = null;
    public static final Long DEFAULT_SCENE_ID = null;
    public static final String DEFAULT_SCENE_NAME = "";
    public static final Long DEFAULT_TENANT_ID = null;
    private static final long serialVersionUID = 0;
    public final String mdescription;
    public final String mgreeting;
    public final List<GuideQuestion> mguide_questions;
    public final Boolean mis_official;
    public final Boolean mis_preset;
    public final SceneOwner mowner;
    public final ProcessorType mprocessor_type;
    public final Long mscene_id;
    public final String mscene_name;
    public final ImageSetPassThrough mscene_photo;
    public final SceneStatus mstatus;
    public final Long mtenant_id;

    public static final class Builder extends Message.Builder<MyAIScene, Builder> {
        public String mdescription;
        public String mgreeting;
        public List<GuideQuestion> mguide_questions;
        public Boolean mis_official;
        public Boolean mis_preset;
        public SceneOwner mowner;
        public ProcessorType mprocessor_type;
        public Long mscene_id;
        public String mscene_name;
        public ImageSetPassThrough mscene_photo;
        public SceneStatus mstatus;
        public Long mtenant_id;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MyAIScene m1970build() {
            return new MyAIScene(this.mscene_id, this.mowner, this.mtenant_id, this.mprocessor_type, this.mscene_name, this.mscene_photo, this.mgreeting, this.mdescription, this.mguide_questions, this.mstatus, this.mis_official, this.mis_preset, super.buildUnknownFields());
        }

        public Builder() {
            this.mguide_questions = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1970build();
        }

        public Builder description(String r1) {
            this.mdescription = r1;
            return this;
        }

        public Builder greeting(String r1) {
            this.mgreeting = r1;
            return this;
        }

        public Builder guide_questions(List<GuideQuestion> r1) {
            Internal.checkElementsNotNull(r1);
            this.mguide_questions = r1;
            return this;
        }

        public Builder is_official(Boolean r1) {
            this.mis_official = r1;
            return this;
        }

        public Builder is_preset(Boolean r1) {
            this.mis_preset = r1;
            return this;
        }

        public Builder owner(SceneOwner r1) {
            this.mowner = r1;
            return this;
        }

        public Builder processor_type(ProcessorType r1) {
            this.mprocessor_type = r1;
            return this;
        }

        public Builder scene_id(Long r1) {
            this.mscene_id = r1;
            return this;
        }

        public Builder scene_name(String r1) {
            this.mscene_name = r1;
            return this;
        }

        public Builder scene_photo(ImageSetPassThrough r1) {
            this.mscene_photo = r1;
            return this;
        }

        public Builder status(SceneStatus r1) {
            this.mstatus = r1;
            return this;
        }

        public Builder tenant_id(Long r1) {
            this.mtenant_id = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MyAIScene extends ProtoAdapter<MyAIScene> {
        public ProtoAdapter_MyAIScene() {
            super(FieldEncoding.LENGTH_DELIMITED, MyAIScene.class);
        }

        public MyAIScene decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.mscene_id = 0L;
            r0.mtenant_id = 0L;
            r0.mscene_name = "";
            r0.mgreeting = "";
            r0.mdescription = "";
            Boolean r1 = Boolean.FALSE;
            r0.mis_official = r1;
            r0.mis_preset = r1;
            long r2 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L25;
            switch(r3) {
                case 1: goto L24;
                case 2: goto L23;
                case 3: goto L22;
                case 4: goto L29;
                case 5: goto L17;
                case 6: goto L16;
                case 7: goto L15;
                case 8: goto L14;
                case 9: goto L13;
                case 10: goto L27;
                case 11: goto L8;
                case 12: goto L7;
                default: goto L6;
            };
        L27:
            r0.mstatus = (SceneStatus) SceneStatus.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L29:
            r0.mprocessor_type = (ProcessorType) ProcessorType.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r0.mis_preset = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L8:
            r0.mis_official = (Boolean) ProtoAdapter.BOOL.decode(r9);
            goto L3
        L13:
            r0.mguide_questions.add((GuideQuestion) GuideQuestion.ADAPTER.decode(r9));
            goto L3
        L14:
            r0.mdescription = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L15:
            r0.mgreeting = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L16:
            r0.mscene_photo = (ImageSetPassThrough) ImageSetPassThrough.ADAPTER.decode(r9);
            goto L3
        L17:
            r0.mscene_name = (String) ProtoAdapter.STRING.decode(r9);
            goto L3
        L22:
            r0.mtenant_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L23:
            r0.mowner = (SceneOwner) SceneOwner.ADAPTER.decode(r9);
            goto L3
        L24:
            r0.mscene_id = (Long) ProtoAdapter.INT64.decode(r9);
            goto L3
        L6:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L25:
            r9.endMessage(r2);
            return r0.m1970build();
        }

        public int encodedSize(MyAIScene r6) {
            Long r0 = r6.mscene_id;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = ProtoAdapter.INT64.encodedSizeWithTag(1, r0);
        L6:
            SceneOwner r3 = r6.mowner;
            if (r3 == null) goto L9;
            int r4 = SceneOwner.ADAPTER.encodedSizeWithTag(2, r3);
        L10:
            int r5 = r2 + r4;
            Long r7 = r6.mtenant_id;
            if (r7 == null) goto L13;
            int r8 = ProtoAdapter.INT64.encodedSizeWithTag(3, r7);
        L14:
            int r9 = r5 + r8;
            ProcessorType r10 = r6.mprocessor_type;
            if (r10 == null) goto L17;
            int r11 = ProcessorType.ADAPTER.encodedSizeWithTag(4, r10);
        L18:
            int r12 = r9 + r11;
            String r13 = r6.mscene_name;
            if (r13 == null) goto L21;
            int r14 = ProtoAdapter.STRING.encodedSizeWithTag(5, r13);
        L22:
            int r15 = r12 + r14;
            ImageSetPassThrough r16 = r6.mscene_photo;
            if (r16 == null) goto L25;
            int r17 = ImageSetPassThrough.ADAPTER.encodedSizeWithTag(6, r16);
        L26:
            int r18 = r15 + r17;
            String r19 = r6.mgreeting;
            if (r19 == null) goto L29;
            int r20 = ProtoAdapter.STRING.encodedSizeWithTag(7, r19);
        L30:
            int r21 = r18 + r20;
            String r22 = r6.mdescription;
            if (r22 == null) goto L33;
            int r23 = ProtoAdapter.STRING.encodedSizeWithTag(8, r22);
        L34:
            int r24 = (r21 + r23) + GuideQuestion.ADAPTER.asRepeated().encodedSizeWithTag(9, r6.mguide_questions);
            SceneStatus r25 = r6.mstatus;
            if (r25 == null) goto L37;
            int r26 = SceneStatus.ADAPTER.encodedSizeWithTag(10, r25);
        L38:
            int r27 = r24 + r26;
            Boolean r28 = r6.mis_official;
            if (r28 == null) goto L41;
            int r29 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r28);
        L42:
            int r30 = r27 + r29;
            Boolean r31 = r6.mis_preset;
            if (r31 == null) goto L46;
            r1 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r31);
        L46:
            return (r30 + r1) + r6.unknownFields().size();
        L41:
            r29 = 0;
            goto L42
        L37:
            r26 = 0;
            goto L38
        L33:
            r23 = 0;
            goto L34
        L29:
            r20 = 0;
            goto L30
        L25:
            r17 = 0;
            goto L26
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
        public /* bridge */ /* synthetic */ Object m1971decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MyAIScene) r1);
        }

        public void encode(ProtoWriter r4, MyAIScene r5) throws IOException {
            Long r0 = r5.mscene_id;
            if (r0 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r4, 1, r0);
        L5:
            SceneOwner r1 = r5.mowner;
            if (r1 == null) goto L8;
            SceneOwner.ADAPTER.encodeWithTag(r4, 2, r1);
        L8:
            Long r2 = r5.mtenant_id;
            if (r2 == null) goto L11;
            ProtoAdapter.INT64.encodeWithTag(r4, 3, r2);
        L11:
            ProcessorType r3 = r5.mprocessor_type;
            if (r3 == null) goto L14;
            ProcessorType.ADAPTER.encodeWithTag(r4, 4, r3);
        L14:
            String r6 = r5.mscene_name;
            if (r6 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r4, 5, r6);
        L17:
            ImageSetPassThrough r7 = r5.mscene_photo;
            if (r7 == null) goto L20;
            ImageSetPassThrough.ADAPTER.encodeWithTag(r4, 6, r7);
        L20:
            String r8 = r5.mgreeting;
            if (r8 == null) goto L23;
            ProtoAdapter.STRING.encodeWithTag(r4, 7, r8);
        L23:
            String r9 = r5.mdescription;
            if (r9 == null) goto L26;
            ProtoAdapter.STRING.encodeWithTag(r4, 8, r9);
        L26:
            GuideQuestion.ADAPTER.asRepeated().encodeWithTag(r4, 9, r5.mguide_questions);
            SceneStatus r10 = r5.mstatus;
            if (r10 == null) goto L29;
            SceneStatus.ADAPTER.encodeWithTag(r4, 10, r10);
        L29:
            Boolean r11 = r5.mis_official;
            if (r11 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r4, 11, r11);
        L32:
            Boolean r12 = r5.mis_preset;
            if (r12 == null) goto L35;
            ProtoAdapter.BOOL.encodeWithTag(r4, 12, r12);
        L35:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MyAIScene) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MyAIScene();
        DEFAULT_SCENE_ID = 0L;
        DEFAULT_TENANT_ID = 0L;
        Boolean r0 = Boolean.FALSE;
        DEFAULT_IS_OFFICIAL = r0;
        DEFAULT_IS_PRESET = r0;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1969newBuilder() {
        Builder r0 = new Builder();
        r0.mscene_id = this.mscene_id;
        r0.mowner = this.mowner;
        r0.mtenant_id = this.mtenant_id;
        r0.mprocessor_type = this.mprocessor_type;
        r0.mscene_name = this.mscene_name;
        r0.mscene_photo = this.mscene_photo;
        r0.mgreeting = this.mgreeting;
        r0.mdescription = this.mdescription;
        r0.mguide_questions = Internal.copyOf("mguide_questions", this.mguide_questions);
        r0.mstatus = this.mstatus;
        r0.mis_official = this.mis_official;
        r0.mis_preset = this.mis_preset;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MyAIScene.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1969newBuilder();
    }

    public MyAIScene(Long r15, SceneOwner r16, Long r17, ProcessorType r18, String r19, ImageSetPassThrough r20, String r21, String r22, List<GuideQuestion> r23, SceneStatus r24, Boolean r25, Boolean r26) {
        this(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, ByteString.EMPTY);
    }

    public MyAIScene(Long r2, SceneOwner r3, Long r4, ProcessorType r5, String r6, ImageSetPassThrough r7, String r8, String r9, List<GuideQuestion> r10, SceneStatus r11, Boolean r12, Boolean r13, ByteString r14) {
        super(ADAPTER, r14);
        this.mscene_id = r2;
        this.mowner = r3;
        this.mtenant_id = r4;
        this.mprocessor_type = r5;
        this.mscene_name = r6;
        this.mscene_photo = r7;
        this.mgreeting = r8;
        this.mdescription = r9;
        this.mguide_questions = Internal.immutableCopyOf("mguide_questions", r10);
        this.mstatus = r11;
        this.mis_official = r12;
        this.mis_preset = r13;
    }
}
