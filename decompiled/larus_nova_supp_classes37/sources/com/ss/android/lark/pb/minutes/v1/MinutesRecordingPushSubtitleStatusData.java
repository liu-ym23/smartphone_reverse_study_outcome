package com.ss.android.lark.pb.minutes.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class MinutesRecordingPushSubtitleStatusData extends Message<MinutesRecordingPushSubtitleStatusData, Builder> {
    public static final ProtoAdapter<MinutesRecordingPushSubtitleStatusData> ADAPTER = null;
    public static final Status DEFAULT_STATUS = null;
    public static final ProtoAdapter_MinutesRecordingPushSubtitleStatusData RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final SimultaneousInterpretationSpokenLanguageChange simultaneous_interpretation_spoken_language_change;
    public final Status status;
    public final SubtitleTranslationChange subtitle_translation_change;

    public static final class Builder extends Message.Builder<MinutesRecordingPushSubtitleStatusData, Builder> implements d<MinutesRecordingPushSubtitleStatusData> {
        public SimultaneousInterpretationSpokenLanguageChange simultaneous_interpretation_spoken_language_change;
        public Status status;
        public SubtitleTranslationChange subtitle_translation_change;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public MinutesRecordingPushSubtitleStatusData m1862build() {
            Status r0 = this.status;
            if (r0 == null) goto L7;
            return new MinutesRecordingPushSubtitleStatusData(this.status, this.subtitle_translation_change, this.simultaneous_interpretation_spoken_language_change, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r0, "status"});
        }

        public Builder() {
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1862build();
        }

        public Builder simultaneous_interpretation_spoken_language_change(SimultaneousInterpretationSpokenLanguageChange r1) {
            this.simultaneous_interpretation_spoken_language_change = r1;
            return this;
        }

        public Builder status(Status r1) {
            this.status = r1;
            return this;
        }

        public Builder subtitle_translation_change(SubtitleTranslationChange r1) {
            this.subtitle_translation_change = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_MinutesRecordingPushSubtitleStatusData extends ProtoAdapter<MinutesRecordingPushSubtitleStatusData> implements c<MinutesRecordingPushSubtitleStatusData> {
        public ProtoAdapter_MinutesRecordingPushSubtitleStatusData() {
            super(FieldEncoding.LENGTH_DELIMITED, MinutesRecordingPushSubtitleStatusData.class);
        }

        public MinutesRecordingPushSubtitleStatusData decode(ProtoReader r9) throws IOException {
            Builder r0 = new Builder();
            r0.status = Status.STATUS_UNKNOWN;
            long r1 = r9.beginMessage();
        L3:
            int r3 = r9.nextTag();
            if (r3 == (-1)) goto L18;
            if (r3 != 1) goto L8;
            r0.status = (Status) Status.ADAPTER.decode(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r0.addUnknownField(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r3 != 11) goto L10;
            r0.subtitle_translation_change = (SubtitleTranslationChange) SubtitleTranslationChange.ADAPTER.decode(r9);
            goto L3
        L10:
            if (r3 != 12) goto L11;
            r0.simultaneous_interpretation_spoken_language_change = (SimultaneousInterpretationSpokenLanguageChange) SimultaneousInterpretationSpokenLanguageChange.ADAPTER.decode(r9);
            goto L3
        L11:
            FieldEncoding r4 = r9.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r9));
            goto L3
        L18:
            r9.endMessage(r1);
            return r0.m1862build();
        }

        public int encodedSize(MinutesRecordingPushSubtitleStatusData r6) {
            int r0 = Status.ADAPTER.encodedSizeWithTag(1, r6.status);
            SubtitleTranslationChange r1 = r6.subtitle_translation_change;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = SubtitleTranslationChange.ADAPTER.encodedSizeWithTag(11, r1);
        L6:
            int r4 = r0 + r3;
            SimultaneousInterpretationSpokenLanguageChange r5 = r6.simultaneous_interpretation_spoken_language_change;
            if (r5 == null) goto L10;
            r2 = SimultaneousInterpretationSpokenLanguageChange.ADAPTER.encodedSizeWithTag(12, r5);
        L10:
            return (r4 + r2) + r6.unknownFields().size();
        L5:
            r3 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1863decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((MinutesRecordingPushSubtitleStatusData) r1);
        }

        public void encode(ProtoWriter r4, MinutesRecordingPushSubtitleStatusData r5) throws IOException {
            Status.ADAPTER.encodeWithTag(r4, 1, r5.status);
            SubtitleTranslationChange r0 = r5.subtitle_translation_change;
            if (r0 == null) goto L5;
            SubtitleTranslationChange.ADAPTER.encodeWithTag(r4, 11, r0);
        L5:
            SimultaneousInterpretationSpokenLanguageChange r1 = r5.simultaneous_interpretation_spoken_language_change;
            if (r1 == null) goto L8;
            SimultaneousInterpretationSpokenLanguageChange.ADAPTER.encodeWithTag(r4, 12, r1);
        L8:
            r4.writeBytes(r5.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (MinutesRecordingPushSubtitleStatusData) r2);
        }
    }

    public static final class SimultaneousInterpretationSpokenLanguageChange extends Message<SimultaneousInterpretationSpokenLanguageChange, Builder> {
        public static final ProtoAdapter<SimultaneousInterpretationSpokenLanguageChange> ADAPTER = null;
        public static final String DEFAULT_SPOKEN_LANGUAGE = "";
        private static final long serialVersionUID = 0;
        public final String spoken_language;

        public static final class Builder extends Message.Builder<SimultaneousInterpretationSpokenLanguageChange, Builder> {
            public String spoken_language;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public SimultaneousInterpretationSpokenLanguageChange m1865build() {
                String r0 = this.spoken_language;
                if (r0 == null) goto L7;
                return new SimultaneousInterpretationSpokenLanguageChange(this.spoken_language, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r0, "spoken_language"});
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m1865build();
            }

            public Builder spoken_language(String r1) {
                this.spoken_language = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_SimultaneousInterpretationSpokenLanguageChange extends ProtoAdapter<SimultaneousInterpretationSpokenLanguageChange> {
            public ProtoAdapter_SimultaneousInterpretationSpokenLanguageChange() {
                super(FieldEncoding.LENGTH_DELIMITED, SimultaneousInterpretationSpokenLanguageChange.class);
            }

            public SimultaneousInterpretationSpokenLanguageChange decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.spoken_language = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.spoken_language = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m1865build();
            }

            public int encodedSize(SimultaneousInterpretationSpokenLanguageChange r4) {
                return ProtoAdapter.STRING.encodedSizeWithTag(1, r4.spoken_language) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1866decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((SimultaneousInterpretationSpokenLanguageChange) r1);
            }

            public void encode(ProtoWriter r4, SimultaneousInterpretationSpokenLanguageChange r5) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.spoken_language);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (SimultaneousInterpretationSpokenLanguageChange) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SimultaneousInterpretationSpokenLanguageChange();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1864newBuilder() {
            Builder r0 = new Builder();
            r0.spoken_language = this.spoken_language;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return SimultaneousInterpretationSpokenLanguageChange.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m1864newBuilder();
        }

        public SimultaneousInterpretationSpokenLanguageChange(String r2) {
            this(r2, ByteString.EMPTY);
        }

        public SimultaneousInterpretationSpokenLanguageChange(String r2, ByteString r3) {
            super(ADAPTER, r3);
            this.spoken_language = r2;
        }
    }

    public static final enum Status extends Enum<Status> implements WireEnum {
        private static final /* synthetic */ Status[] $VALUES = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status SIMULTANEOUS_SPOKEN_LANGUAGE_NOT_SUPPORT = null;
        public static final Status STATUS_UNKNOWN = null;
        public static final Status SUBTITLE_TRANSLATION_CHANGE = null;
        private final int value;

        static {
            Status r0 = new Status("STATUS_UNKNOWN", 0, 0);
            STATUS_UNKNOWN = r0;
            Status r1 = new Status("SUBTITLE_TRANSLATION_CHANGE", 1, 15);
            SUBTITLE_TRANSLATION_CHANGE = r1;
            Status r3 = new Status("SIMULTANEOUS_SPOKEN_LANGUAGE_NOT_SUPPORT", 2, 16);
            SIMULTANEOUS_SPOKEN_LANGUAGE_NOT_SUPPORT = r3;
            $VALUES = new Status[]{r0, r1, r3};
            ADAPTER = ProtoAdapter.newEnumAdapter(Status.class);
        }

        public static Status[] values() {
            return (Status[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static Status fromValue(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 15) goto L12;
            if (r1 == 16) goto L10;
            return null;
        L10:
            return SIMULTANEOUS_SPOKEN_LANGUAGE_NOT_SUPPORT;
        L12:
            return SUBTITLE_TRANSLATION_CHANGE;
        L14:
            return STATUS_UNKNOWN;
        }

        public static Status valueOf(String r1) {
            return (Status) a.a(Status.class, r1);
        }

        private Status(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class SubtitleTranslationChange extends Message<SubtitleTranslationChange, Builder> {
        public static final ProtoAdapter<SubtitleTranslationChange> ADAPTER = null;
        public static final String DEFAULT_LANGUAGE = "";
        private static final long serialVersionUID = 0;
        public final String language;

        public static final class Builder extends Message.Builder<SubtitleTranslationChange, Builder> {
            public String language;

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public SubtitleTranslationChange m1868build() {
                String r0 = this.language;
                if (r0 == null) goto L7;
                return new SubtitleTranslationChange(this.language, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r0, "language"});
            }

            public Builder() {
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m1868build();
            }

            public Builder language(String r1) {
                this.language = r1;
                return this;
            }
        }

        public static final class ProtoAdapter_SubtitleTranslationChange extends ProtoAdapter<SubtitleTranslationChange> {
            public ProtoAdapter_SubtitleTranslationChange() {
                super(FieldEncoding.LENGTH_DELIMITED, SubtitleTranslationChange.class);
            }

            public SubtitleTranslationChange decode(ProtoReader r7) throws IOException {
                Builder r0 = new Builder();
                r0.language = "";
                long r1 = r7.beginMessage();
            L3:
                int r3 = r7.nextTag();
                if (r3 == (-1)) goto L9;
                if (r3 != 1) goto L7;
                r0.language = (String) ProtoAdapter.STRING.decode(r7);
                goto L3
            L7:
                FieldEncoding r4 = r7.peekFieldEncoding();
                r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
                goto L3
            L9:
                r7.endMessage(r1);
                return r0.m1868build();
            }

            public int encodedSize(SubtitleTranslationChange r4) {
                return ProtoAdapter.STRING.encodedSizeWithTag(1, r4.language) + r4.unknownFields().size();
            }

            /* JADX INFO: renamed from: decode, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m1869decode(ProtoReader r1) throws IOException {
                return decode(r1);
            }

            public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
                return encodedSize((SubtitleTranslationChange) r1);
            }

            public void encode(ProtoWriter r4, SubtitleTranslationChange r5) throws IOException {
                ProtoAdapter.STRING.encodeWithTag(r4, 1, r5.language);
                r4.writeBytes(r5.unknownFields());
            }

            public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
                encode(r1, (SubtitleTranslationChange) r2);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_SubtitleTranslationChange();
        }

        /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
        public Builder m1867newBuilder() {
            Builder r0 = new Builder();
            r0.language = this.language;
            r0.addUnknownFields(unknownFields());
            return r0;
        }

        public String toString() {
            return SubtitleTranslationChange.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return m1867newBuilder();
        }

        public SubtitleTranslationChange(String r2) {
            this(r2, ByteString.EMPTY);
        }

        public SubtitleTranslationChange(String r2, ByteString r3) {
            super(ADAPTER, r3);
            this.language = r2;
        }
    }

    static {
        ProtoAdapter_MinutesRecordingPushSubtitleStatusData r0 = new ProtoAdapter_MinutesRecordingPushSubtitleStatusData();
        RAW_TYPE_ADAPTER = r0;
        ADAPTER = r0;
        DEFAULT_STATUS = Status.STATUS_UNKNOWN;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1861newBuilder() {
        Builder r0 = new Builder();
        r0.status = this.status;
        r0.subtitle_translation_change = this.subtitle_translation_change;
        r0.simultaneous_interpretation_spoken_language_change = this.simultaneous_interpretation_spoken_language_change;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return MinutesRecordingPushSubtitleStatusData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1861newBuilder();
    }

    public MinutesRecordingPushSubtitleStatusData(Status r2, SubtitleTranslationChange r3, SimultaneousInterpretationSpokenLanguageChange r4) {
        this(r2, r3, r4, ByteString.EMPTY);
    }

    public MinutesRecordingPushSubtitleStatusData(Status r2, SubtitleTranslationChange r3, SimultaneousInterpretationSpokenLanguageChange r4, ByteString r5) {
        super(ADAPTER, r5);
        this.status = r2;
        this.subtitle_translation_change = r3;
        this.simultaneous_interpretation_spoken_language_change = r4;
    }
}
