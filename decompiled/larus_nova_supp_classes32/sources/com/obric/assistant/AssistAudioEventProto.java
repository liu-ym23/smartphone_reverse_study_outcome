package com.obric.assistant;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import com.lynx.tasm.event.LynxTouchEvent;
import com.obric.aivoice.core.data.NameKeys;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class AssistAudioEventProto {
    private static Descriptors.FileDescriptor descriptor;
    private static final Descriptors.Descriptor internal_static_com_obric_assistant_AssistAudioEventDataTraceViewer_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_assistant_AssistAudioEventDataTraceViewer_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_com_obric_assistant_AssistAudioEventData_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_assistant_AssistAudioEventData_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_com_obric_assistant_BreathWakeupDuration_ExtraEntry_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_assistant_BreathWakeupDuration_ExtraEntry_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_com_obric_assistant_BreathWakeupDuration_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_assistant_BreathWakeupDuration_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_com_obric_assistant_BreathWakeupEvent_ExtraEntry_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_assistant_BreathWakeupEvent_ExtraEntry_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_com_obric_assistant_BreathWakeupEvent_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_assistant_BreathWakeupEvent_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_com_obric_assistant_RealtimeCallDuration_ExtraEntry_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_assistant_RealtimeCallDuration_ExtraEntry_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_com_obric_assistant_RealtimeCallDuration_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_assistant_RealtimeCallDuration_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_com_obric_assistant_RealtimeCallEvent_ExtraEntry_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_assistant_RealtimeCallEvent_ExtraEntry_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_com_obric_assistant_RealtimeCallEvent_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_assistant_RealtimeCallEvent_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_com_obric_assistant_VoiceWakeupDuration_ExtraEntry_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_assistant_VoiceWakeupDuration_ExtraEntry_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_com_obric_assistant_VoiceWakeupDuration_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_assistant_VoiceWakeupDuration_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_com_obric_assistant_VoiceWakeupEvent_ExtraEntry_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_assistant_VoiceWakeupEvent_ExtraEntry_fieldAccessorTable = null;
    private static final Descriptors.Descriptor internal_static_com_obric_assistant_VoiceWakeupEvent_descriptor = null;
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_com_obric_assistant_VoiceWakeupEvent_fieldAccessorTable = null;

    public static final class AssistAudioEventData extends GeneratedMessageV3 implements AssistAudioEventDataOrBuilder {
        public static final int BREATH_WAKEUP_DURATION_FIELD_NUMBER = 3;
        public static final int BREATH_WAKEUP_EVENT_FIELD_NUMBER = 4;
        private static final AssistAudioEventData DEFAULT_INSTANCE = null;
        public static final Parser<AssistAudioEventData> PARSER = null;
        public static final int REALTIME_CALL_DURATIONS_FIELD_NUMBER = 5;
        public static final int REALTIME_CALL_EVENTS_FIELD_NUMBER = 6;
        public static final int VOICE_WAKEUP_DURATION_FIELD_NUMBER = 1;
        public static final int VOICE_WAKEUP_EVENT_FIELD_NUMBER = 2;
        private static final long serialVersionUID = 0;
        private List<BreathWakeupDuration> breathWakeupDuration_;
        private List<BreathWakeupEvent> breathWakeupEvent_;
        private byte memoizedIsInitialized;
        private List<RealtimeCallDuration> realtimeCallDurations_;
        private List<RealtimeCallEvent> realtimeCallEvents_;
        private List<VoiceWakeupDuration> voiceWakeupDuration_;
        private List<VoiceWakeupEvent> voiceWakeupEvent_;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AssistAudioEventDataOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<BreathWakeupDuration, BreathWakeupDuration.Builder, BreathWakeupDurationOrBuilder> breathWakeupDurationBuilder_;
            private List<BreathWakeupDuration> breathWakeupDuration_;
            private RepeatedFieldBuilderV3<BreathWakeupEvent, BreathWakeupEvent.Builder, BreathWakeupEventOrBuilder> breathWakeupEventBuilder_;
            private List<BreathWakeupEvent> breathWakeupEvent_;
            private RepeatedFieldBuilderV3<RealtimeCallDuration, RealtimeCallDuration.Builder, RealtimeCallDurationOrBuilder> realtimeCallDurationsBuilder_;
            private List<RealtimeCallDuration> realtimeCallDurations_;
            private RepeatedFieldBuilderV3<RealtimeCallEvent, RealtimeCallEvent.Builder, RealtimeCallEventOrBuilder> realtimeCallEventsBuilder_;
            private List<RealtimeCallEvent> realtimeCallEvents_;
            private RepeatedFieldBuilderV3<VoiceWakeupDuration, VoiceWakeupDuration.Builder, VoiceWakeupDurationOrBuilder> voiceWakeupDurationBuilder_;
            private List<VoiceWakeupDuration> voiceWakeupDuration_;
            private RepeatedFieldBuilderV3<VoiceWakeupEvent, VoiceWakeupEvent.Builder, VoiceWakeupEventOrBuilder> voiceWakeupEventBuilder_;
            private List<VoiceWakeupEvent> voiceWakeupEvent_;

            public final boolean isInitialized() {
                return true;
            }

            private void ensureBreathWakeupDurationIsMutable() {
                if ((this.bitField0_ & 4) == 4) goto L6;
                this.breathWakeupDuration_ = new ArrayList(this.breathWakeupDuration_);
                this.bitField0_ |= 4;
                return;
            }

            private void ensureBreathWakeupEventIsMutable() {
                if ((this.bitField0_ & 8) == 8) goto L6;
                this.breathWakeupEvent_ = new ArrayList(this.breathWakeupEvent_);
                this.bitField0_ |= 8;
                return;
            }

            private void ensureRealtimeCallDurationsIsMutable() {
                if ((this.bitField0_ & 16) == 16) goto L6;
                this.realtimeCallDurations_ = new ArrayList(this.realtimeCallDurations_);
                this.bitField0_ |= 16;
                return;
            }

            private void ensureRealtimeCallEventsIsMutable() {
                if ((this.bitField0_ & 32) == 32) goto L6;
                this.realtimeCallEvents_ = new ArrayList(this.realtimeCallEvents_);
                this.bitField0_ |= 32;
                return;
            }

            private void ensureVoiceWakeupDurationIsMutable() {
                if ((this.bitField0_ & 1) == 1) goto L6;
                this.voiceWakeupDuration_ = new ArrayList(this.voiceWakeupDuration_);
                this.bitField0_ |= 1;
                return;
            }

            private void ensureVoiceWakeupEventIsMutable() {
                if ((this.bitField0_ & 2) == 2) goto L6;
                this.voiceWakeupEvent_ = new ArrayList(this.voiceWakeupEvent_);
                this.bitField0_ |= 2;
                return;
            }

            private RepeatedFieldBuilderV3<BreathWakeupDuration, BreathWakeupDuration.Builder, BreathWakeupDurationOrBuilder> getBreathWakeupDurationFieldBuilder() {
                if (this.breathWakeupDurationBuilder_ != null) goto L10;
                List<BreathWakeupDuration> r1 = this.breathWakeupDuration_;
                if ((this.bitField0_ & 4) != 4) goto L7;
                boolean r2 = true;
            L8:
                this.breathWakeupDurationBuilder_ = new RepeatedFieldBuilderV3(r1, r2, getParentForChildren(), isClean());
                this.breathWakeupDuration_ = null;
                goto L10
            L7:
                r2 = false;
            L10:
                return this.breathWakeupDurationBuilder_;
            }

            private RepeatedFieldBuilderV3<BreathWakeupEvent, BreathWakeupEvent.Builder, BreathWakeupEventOrBuilder> getBreathWakeupEventFieldBuilder() {
                if (this.breathWakeupEventBuilder_ != null) goto L10;
                List<BreathWakeupEvent> r1 = this.breathWakeupEvent_;
                if ((this.bitField0_ & 8) != 8) goto L7;
                boolean r2 = true;
            L8:
                this.breathWakeupEventBuilder_ = new RepeatedFieldBuilderV3(r1, r2, getParentForChildren(), isClean());
                this.breathWakeupEvent_ = null;
                goto L10
            L7:
                r2 = false;
            L10:
                return this.breathWakeupEventBuilder_;
            }

            private RepeatedFieldBuilderV3<RealtimeCallDuration, RealtimeCallDuration.Builder, RealtimeCallDurationOrBuilder> getRealtimeCallDurationsFieldBuilder() {
                if (this.realtimeCallDurationsBuilder_ != null) goto L10;
                List<RealtimeCallDuration> r1 = this.realtimeCallDurations_;
                if ((this.bitField0_ & 16) != 16) goto L7;
                boolean r2 = true;
            L8:
                this.realtimeCallDurationsBuilder_ = new RepeatedFieldBuilderV3(r1, r2, getParentForChildren(), isClean());
                this.realtimeCallDurations_ = null;
                goto L10
            L7:
                r2 = false;
            L10:
                return this.realtimeCallDurationsBuilder_;
            }

            private RepeatedFieldBuilderV3<RealtimeCallEvent, RealtimeCallEvent.Builder, RealtimeCallEventOrBuilder> getRealtimeCallEventsFieldBuilder() {
                if (this.realtimeCallEventsBuilder_ != null) goto L10;
                List<RealtimeCallEvent> r1 = this.realtimeCallEvents_;
                if ((this.bitField0_ & 32) != 32) goto L7;
                boolean r2 = true;
            L8:
                this.realtimeCallEventsBuilder_ = new RepeatedFieldBuilderV3(r1, r2, getParentForChildren(), isClean());
                this.realtimeCallEvents_ = null;
                goto L10
            L7:
                r2 = false;
            L10:
                return this.realtimeCallEventsBuilder_;
            }

            private RepeatedFieldBuilderV3<VoiceWakeupDuration, VoiceWakeupDuration.Builder, VoiceWakeupDurationOrBuilder> getVoiceWakeupDurationFieldBuilder() {
                if (this.voiceWakeupDurationBuilder_ != null) goto L10;
                List<VoiceWakeupDuration> r1 = this.voiceWakeupDuration_;
                boolean r3 = true;
                if ((this.bitField0_ & 1) == 1) goto L8;
                r3 = false;
            L8:
                this.voiceWakeupDurationBuilder_ = new RepeatedFieldBuilderV3(r1, r3, getParentForChildren(), isClean());
                this.voiceWakeupDuration_ = null;
            L10:
                return this.voiceWakeupDurationBuilder_;
            }

            private RepeatedFieldBuilderV3<VoiceWakeupEvent, VoiceWakeupEvent.Builder, VoiceWakeupEventOrBuilder> getVoiceWakeupEventFieldBuilder() {
                if (this.voiceWakeupEventBuilder_ != null) goto L10;
                List<VoiceWakeupEvent> r1 = this.voiceWakeupEvent_;
                if ((this.bitField0_ & 2) != 2) goto L7;
                boolean r2 = true;
            L8:
                this.voiceWakeupEventBuilder_ = new RepeatedFieldBuilderV3(r1, r2, getParentForChildren(), isClean());
                this.voiceWakeupEvent_ = null;
                goto L10
            L7:
                r2 = false;
            L10:
                return this.voiceWakeupEventBuilder_;
            }

            /* JADX INFO: renamed from: buildPartial, reason: collision with other method in class */
            public AssistAudioEventData m51buildPartial() {
                AssistAudioEventData r0 = new AssistAudioEventData(this, null);
                int r1 = this.bitField0_;
                RepeatedFieldBuilderV3<VoiceWakeupDuration, VoiceWakeupDuration.Builder, VoiceWakeupDurationOrBuilder> r2 = this.voiceWakeupDurationBuilder_;
                if (r2 == null) goto L5;
                AssistAudioEventData.access$602(r0, r2.build());
            L9:
                RepeatedFieldBuilderV3<VoiceWakeupEvent, VoiceWakeupEvent.Builder, VoiceWakeupEventOrBuilder> r3 = this.voiceWakeupEventBuilder_;
                if (r3 == null) goto L12;
                AssistAudioEventData.access$702(r0, r3.build());
            L16:
                RepeatedFieldBuilderV3<BreathWakeupDuration, BreathWakeupDuration.Builder, BreathWakeupDurationOrBuilder> r4 = this.breathWakeupDurationBuilder_;
                if (r4 == null) goto L19;
                AssistAudioEventData.access$802(r0, r4.build());
            L23:
                RepeatedFieldBuilderV3<BreathWakeupEvent, BreathWakeupEvent.Builder, BreathWakeupEventOrBuilder> r5 = this.breathWakeupEventBuilder_;
                if (r5 == null) goto L26;
                AssistAudioEventData.access$902(r0, r5.build());
            L30:
                RepeatedFieldBuilderV3<RealtimeCallDuration, RealtimeCallDuration.Builder, RealtimeCallDurationOrBuilder> r6 = this.realtimeCallDurationsBuilder_;
                if (r6 == null) goto L33;
                AssistAudioEventData.access$1002(r0, r6.build());
            L37:
                RepeatedFieldBuilderV3<RealtimeCallEvent, RealtimeCallEvent.Builder, RealtimeCallEventOrBuilder> r7 = this.realtimeCallEventsBuilder_;
                if (r7 == null) goto L40;
                AssistAudioEventData.access$1102(r0, r7.build());
            L44:
                onBuilt();
                return r0;
            L40:
                if ((this.bitField0_ & 32) != 32) goto L42;
                this.realtimeCallEvents_ = Collections.unmodifiableList(this.realtimeCallEvents_);
                this.bitField0_ &= -33;
            L42:
                AssistAudioEventData.access$1102(r0, this.realtimeCallEvents_);
                goto L44
            L33:
                if ((this.bitField0_ & 16) != 16) goto L35;
                this.realtimeCallDurations_ = Collections.unmodifiableList(this.realtimeCallDurations_);
                this.bitField0_ &= -17;
            L35:
                AssistAudioEventData.access$1002(r0, this.realtimeCallDurations_);
                goto L37
            L26:
                if ((this.bitField0_ & 8) != 8) goto L28;
                this.breathWakeupEvent_ = Collections.unmodifiableList(this.breathWakeupEvent_);
                this.bitField0_ &= -9;
            L28:
                AssistAudioEventData.access$902(r0, this.breathWakeupEvent_);
                goto L30
            L19:
                if ((this.bitField0_ & 4) != 4) goto L21;
                this.breathWakeupDuration_ = Collections.unmodifiableList(this.breathWakeupDuration_);
                this.bitField0_ &= -5;
            L21:
                AssistAudioEventData.access$802(r0, this.breathWakeupDuration_);
                goto L23
            L12:
                if ((this.bitField0_ & 2) != 2) goto L14;
                this.voiceWakeupEvent_ = Collections.unmodifiableList(this.voiceWakeupEvent_);
                this.bitField0_ &= -3;
            L14:
                AssistAudioEventData.access$702(r0, this.voiceWakeupEvent_);
                goto L16
            L5:
                if ((r1 & 1) != 1) goto L7;
                this.voiceWakeupDuration_ = Collections.unmodifiableList(this.voiceWakeupDuration_);
                this.bitField0_ &= -2;
            L7:
                AssistAudioEventData.access$602(r0, this.voiceWakeupDuration_);
                goto L9
            }

            public Builder clearBreathWakeupDuration() {
                RepeatedFieldBuilderV3<BreathWakeupDuration, BreathWakeupDuration.Builder, BreathWakeupDurationOrBuilder> r0 = this.breathWakeupDurationBuilder_;
                if (r0 != null) goto L5;
                this.breathWakeupDuration_ = Collections.emptyList();
                this.bitField0_ &= -5;
                onChanged();
            L6:
                return this;
            L5:
                r0.clear();
                goto L6
            }

            public Builder clearBreathWakeupEvent() {
                RepeatedFieldBuilderV3<BreathWakeupEvent, BreathWakeupEvent.Builder, BreathWakeupEventOrBuilder> r0 = this.breathWakeupEventBuilder_;
                if (r0 != null) goto L5;
                this.breathWakeupEvent_ = Collections.emptyList();
                this.bitField0_ &= -9;
                onChanged();
            L6:
                return this;
            L5:
                r0.clear();
                goto L6
            }

            public Builder clearRealtimeCallDurations() {
                RepeatedFieldBuilderV3<RealtimeCallDuration, RealtimeCallDuration.Builder, RealtimeCallDurationOrBuilder> r0 = this.realtimeCallDurationsBuilder_;
                if (r0 != null) goto L5;
                this.realtimeCallDurations_ = Collections.emptyList();
                this.bitField0_ &= -17;
                onChanged();
            L6:
                return this;
            L5:
                r0.clear();
                goto L6
            }

            public Builder clearRealtimeCallEvents() {
                RepeatedFieldBuilderV3<RealtimeCallEvent, RealtimeCallEvent.Builder, RealtimeCallEventOrBuilder> r0 = this.realtimeCallEventsBuilder_;
                if (r0 != null) goto L5;
                this.realtimeCallEvents_ = Collections.emptyList();
                this.bitField0_ &= -33;
                onChanged();
            L6:
                return this;
            L5:
                r0.clear();
                goto L6
            }

            public Builder clearVoiceWakeupDuration() {
                RepeatedFieldBuilderV3<VoiceWakeupDuration, VoiceWakeupDuration.Builder, VoiceWakeupDurationOrBuilder> r0 = this.voiceWakeupDurationBuilder_;
                if (r0 != null) goto L5;
                this.voiceWakeupDuration_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
            L6:
                return this;
            L5:
                r0.clear();
                goto L6
            }

            public Builder clearVoiceWakeupEvent() {
                RepeatedFieldBuilderV3<VoiceWakeupEvent, VoiceWakeupEvent.Builder, VoiceWakeupEventOrBuilder> r0 = this.voiceWakeupEventBuilder_;
                if (r0 != null) goto L5;
                this.voiceWakeupEvent_ = Collections.emptyList();
                this.bitField0_ &= -3;
                onChanged();
            L6:
                return this;
            L5:
                r0.clear();
                goto L6
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
            public int getBreathWakeupDurationCount() {
                RepeatedFieldBuilderV3<BreathWakeupDuration, BreathWakeupDuration.Builder, BreathWakeupDurationOrBuilder> r0 = this.breathWakeupDurationBuilder_;
                if (r0 != null) goto L7;
                return this.breathWakeupDuration_.size();
            L7:
                return r0.getCount();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
            public List<BreathWakeupDuration> getBreathWakeupDurationList() {
                RepeatedFieldBuilderV3<BreathWakeupDuration, BreathWakeupDuration.Builder, BreathWakeupDurationOrBuilder> r0 = this.breathWakeupDurationBuilder_;
                if (r0 != null) goto L7;
                return Collections.unmodifiableList(this.breathWakeupDuration_);
            L7:
                return r0.getMessageList();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
            public List<? extends BreathWakeupDurationOrBuilder> getBreathWakeupDurationOrBuilderList() {
                RepeatedFieldBuilderV3<BreathWakeupDuration, BreathWakeupDuration.Builder, BreathWakeupDurationOrBuilder> r0 = this.breathWakeupDurationBuilder_;
                if (r0 == null) goto L7;
                return r0.getMessageOrBuilderList();
            L7:
                return Collections.unmodifiableList(this.breathWakeupDuration_);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
            public int getBreathWakeupEventCount() {
                RepeatedFieldBuilderV3<BreathWakeupEvent, BreathWakeupEvent.Builder, BreathWakeupEventOrBuilder> r0 = this.breathWakeupEventBuilder_;
                if (r0 != null) goto L7;
                return this.breathWakeupEvent_.size();
            L7:
                return r0.getCount();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
            public List<BreathWakeupEvent> getBreathWakeupEventList() {
                RepeatedFieldBuilderV3<BreathWakeupEvent, BreathWakeupEvent.Builder, BreathWakeupEventOrBuilder> r0 = this.breathWakeupEventBuilder_;
                if (r0 != null) goto L7;
                return Collections.unmodifiableList(this.breathWakeupEvent_);
            L7:
                return r0.getMessageList();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
            public List<? extends BreathWakeupEventOrBuilder> getBreathWakeupEventOrBuilderList() {
                RepeatedFieldBuilderV3<BreathWakeupEvent, BreathWakeupEvent.Builder, BreathWakeupEventOrBuilder> r0 = this.breathWakeupEventBuilder_;
                if (r0 == null) goto L7;
                return r0.getMessageOrBuilderList();
            L7:
                return Collections.unmodifiableList(this.breathWakeupEvent_);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
            public int getRealtimeCallDurationsCount() {
                RepeatedFieldBuilderV3<RealtimeCallDuration, RealtimeCallDuration.Builder, RealtimeCallDurationOrBuilder> r0 = this.realtimeCallDurationsBuilder_;
                if (r0 != null) goto L7;
                return this.realtimeCallDurations_.size();
            L7:
                return r0.getCount();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
            public List<RealtimeCallDuration> getRealtimeCallDurationsList() {
                RepeatedFieldBuilderV3<RealtimeCallDuration, RealtimeCallDuration.Builder, RealtimeCallDurationOrBuilder> r0 = this.realtimeCallDurationsBuilder_;
                if (r0 != null) goto L7;
                return Collections.unmodifiableList(this.realtimeCallDurations_);
            L7:
                return r0.getMessageList();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
            public List<? extends RealtimeCallDurationOrBuilder> getRealtimeCallDurationsOrBuilderList() {
                RepeatedFieldBuilderV3<RealtimeCallDuration, RealtimeCallDuration.Builder, RealtimeCallDurationOrBuilder> r0 = this.realtimeCallDurationsBuilder_;
                if (r0 == null) goto L7;
                return r0.getMessageOrBuilderList();
            L7:
                return Collections.unmodifiableList(this.realtimeCallDurations_);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
            public int getRealtimeCallEventsCount() {
                RepeatedFieldBuilderV3<RealtimeCallEvent, RealtimeCallEvent.Builder, RealtimeCallEventOrBuilder> r0 = this.realtimeCallEventsBuilder_;
                if (r0 != null) goto L7;
                return this.realtimeCallEvents_.size();
            L7:
                return r0.getCount();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
            public List<RealtimeCallEvent> getRealtimeCallEventsList() {
                RepeatedFieldBuilderV3<RealtimeCallEvent, RealtimeCallEvent.Builder, RealtimeCallEventOrBuilder> r0 = this.realtimeCallEventsBuilder_;
                if (r0 != null) goto L7;
                return Collections.unmodifiableList(this.realtimeCallEvents_);
            L7:
                return r0.getMessageList();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
            public List<? extends RealtimeCallEventOrBuilder> getRealtimeCallEventsOrBuilderList() {
                RepeatedFieldBuilderV3<RealtimeCallEvent, RealtimeCallEvent.Builder, RealtimeCallEventOrBuilder> r0 = this.realtimeCallEventsBuilder_;
                if (r0 == null) goto L7;
                return r0.getMessageOrBuilderList();
            L7:
                return Collections.unmodifiableList(this.realtimeCallEvents_);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
            public int getVoiceWakeupDurationCount() {
                RepeatedFieldBuilderV3<VoiceWakeupDuration, VoiceWakeupDuration.Builder, VoiceWakeupDurationOrBuilder> r0 = this.voiceWakeupDurationBuilder_;
                if (r0 != null) goto L7;
                return this.voiceWakeupDuration_.size();
            L7:
                return r0.getCount();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
            public List<VoiceWakeupDuration> getVoiceWakeupDurationList() {
                RepeatedFieldBuilderV3<VoiceWakeupDuration, VoiceWakeupDuration.Builder, VoiceWakeupDurationOrBuilder> r0 = this.voiceWakeupDurationBuilder_;
                if (r0 != null) goto L7;
                return Collections.unmodifiableList(this.voiceWakeupDuration_);
            L7:
                return r0.getMessageList();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
            public List<? extends VoiceWakeupDurationOrBuilder> getVoiceWakeupDurationOrBuilderList() {
                RepeatedFieldBuilderV3<VoiceWakeupDuration, VoiceWakeupDuration.Builder, VoiceWakeupDurationOrBuilder> r0 = this.voiceWakeupDurationBuilder_;
                if (r0 == null) goto L7;
                return r0.getMessageOrBuilderList();
            L7:
                return Collections.unmodifiableList(this.voiceWakeupDuration_);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
            public int getVoiceWakeupEventCount() {
                RepeatedFieldBuilderV3<VoiceWakeupEvent, VoiceWakeupEvent.Builder, VoiceWakeupEventOrBuilder> r0 = this.voiceWakeupEventBuilder_;
                if (r0 != null) goto L7;
                return this.voiceWakeupEvent_.size();
            L7:
                return r0.getCount();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
            public List<VoiceWakeupEvent> getVoiceWakeupEventList() {
                RepeatedFieldBuilderV3<VoiceWakeupEvent, VoiceWakeupEvent.Builder, VoiceWakeupEventOrBuilder> r0 = this.voiceWakeupEventBuilder_;
                if (r0 != null) goto L7;
                return Collections.unmodifiableList(this.voiceWakeupEvent_);
            L7:
                return r0.getMessageList();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
            public List<? extends VoiceWakeupEventOrBuilder> getVoiceWakeupEventOrBuilderList() {
                RepeatedFieldBuilderV3<VoiceWakeupEvent, VoiceWakeupEvent.Builder, VoiceWakeupEventOrBuilder> r0 = this.voiceWakeupEventBuilder_;
                if (r0 == null) goto L7;
                return r0.getMessageOrBuilderList();
            L7:
                return Collections.unmodifiableList(this.voiceWakeupEvent_);
            }

            private Builder() {
                this.voiceWakeupDuration_ = Collections.emptyList();
                this.voiceWakeupEvent_ = Collections.emptyList();
                this.breathWakeupDuration_ = Collections.emptyList();
                this.breathWakeupEvent_ = Collections.emptyList();
                this.realtimeCallDurations_ = Collections.emptyList();
                this.realtimeCallEvents_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AssistAudioEventProto.access$000();
            }

            private void maybeForceBuilderInitialization() {
                if (AssistAudioEventData.access$400() == false) goto L6;
                getVoiceWakeupDurationFieldBuilder();
                getVoiceWakeupEventFieldBuilder();
                getBreathWakeupDurationFieldBuilder();
                getBreathWakeupEventFieldBuilder();
                getRealtimeCallDurationsFieldBuilder();
                getRealtimeCallEventsFieldBuilder();
                return;
            }

            public BreathWakeupDuration.Builder addBreathWakeupDurationBuilder() {
                return getBreathWakeupDurationFieldBuilder().addBuilder(BreathWakeupDuration.getDefaultInstance());
            }

            public BreathWakeupEvent.Builder addBreathWakeupEventBuilder() {
                return getBreathWakeupEventFieldBuilder().addBuilder(BreathWakeupEvent.getDefaultInstance());
            }

            public RealtimeCallDuration.Builder addRealtimeCallDurationsBuilder() {
                return getRealtimeCallDurationsFieldBuilder().addBuilder(RealtimeCallDuration.getDefaultInstance());
            }

            public RealtimeCallEvent.Builder addRealtimeCallEventsBuilder() {
                return getRealtimeCallEventsFieldBuilder().addBuilder(RealtimeCallEvent.getDefaultInstance());
            }

            public VoiceWakeupDuration.Builder addVoiceWakeupDurationBuilder() {
                return getVoiceWakeupDurationFieldBuilder().addBuilder(VoiceWakeupDuration.getDefaultInstance());
            }

            public VoiceWakeupEvent.Builder addVoiceWakeupEventBuilder() {
                return getVoiceWakeupEventFieldBuilder().addBuilder(VoiceWakeupEvent.getDefaultInstance());
            }

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public AssistAudioEventData m49build() {
                AssistAudioEventData r0 = m51buildPartial();
                if (r0.isInitialized() == false) goto L6;
                return r0;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r0);
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public Builder m55clear() {
                super.clear();
                RepeatedFieldBuilderV3<VoiceWakeupDuration, VoiceWakeupDuration.Builder, VoiceWakeupDurationOrBuilder> r0 = this.voiceWakeupDurationBuilder_;
                if (r0 != null) goto L5;
                this.voiceWakeupDuration_ = Collections.emptyList();
                this.bitField0_ &= -2;
            L6:
                RepeatedFieldBuilderV3<VoiceWakeupEvent, VoiceWakeupEvent.Builder, VoiceWakeupEventOrBuilder> r1 = this.voiceWakeupEventBuilder_;
                if (r1 != null) goto L9;
                this.voiceWakeupEvent_ = Collections.emptyList();
                this.bitField0_ &= -3;
            L10:
                RepeatedFieldBuilderV3<BreathWakeupDuration, BreathWakeupDuration.Builder, BreathWakeupDurationOrBuilder> r2 = this.breathWakeupDurationBuilder_;
                if (r2 != null) goto L13;
                this.breathWakeupDuration_ = Collections.emptyList();
                this.bitField0_ &= -5;
            L14:
                RepeatedFieldBuilderV3<BreathWakeupEvent, BreathWakeupEvent.Builder, BreathWakeupEventOrBuilder> r3 = this.breathWakeupEventBuilder_;
                if (r3 != null) goto L17;
                this.breathWakeupEvent_ = Collections.emptyList();
                this.bitField0_ &= -9;
            L18:
                RepeatedFieldBuilderV3<RealtimeCallDuration, RealtimeCallDuration.Builder, RealtimeCallDurationOrBuilder> r4 = this.realtimeCallDurationsBuilder_;
                if (r4 != null) goto L21;
                this.realtimeCallDurations_ = Collections.emptyList();
                this.bitField0_ &= -17;
            L22:
                RepeatedFieldBuilderV3<RealtimeCallEvent, RealtimeCallEvent.Builder, RealtimeCallEventOrBuilder> r5 = this.realtimeCallEventsBuilder_;
                if (r5 != null) goto L25;
                this.realtimeCallEvents_ = Collections.emptyList();
                this.bitField0_ &= -33;
            L26:
                return this;
            L25:
                r5.clear();
                goto L26
            L21:
                r4.clear();
                goto L22
            L17:
                r3.clear();
                goto L18
            L13:
                r2.clear();
                goto L14
            L9:
                r1.clear();
                goto L10
            L5:
                r0.clear();
                goto L6
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public Builder m65clone() {
                return (Builder) super.clone();
            }

            public List<BreathWakeupDuration.Builder> getBreathWakeupDurationBuilderList() {
                return getBreathWakeupDurationFieldBuilder().getBuilderList();
            }

            public List<BreathWakeupEvent.Builder> getBreathWakeupEventBuilderList() {
                return getBreathWakeupEventFieldBuilder().getBuilderList();
            }

            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return m68getDefaultInstanceForType();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return AssistAudioEventProto.access$000();
            }

            public List<RealtimeCallDuration.Builder> getRealtimeCallDurationsBuilderList() {
                return getRealtimeCallDurationsFieldBuilder().getBuilderList();
            }

            public List<RealtimeCallEvent.Builder> getRealtimeCallEventsBuilderList() {
                return getRealtimeCallEventsFieldBuilder().getBuilderList();
            }

            public List<VoiceWakeupDuration.Builder> getVoiceWakeupDurationBuilderList() {
                return getVoiceWakeupDurationFieldBuilder().getBuilderList();
            }

            public List<VoiceWakeupEvent.Builder> getVoiceWakeupEventBuilderList() {
                return getVoiceWakeupEventFieldBuilder().getBuilderList();
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AssistAudioEventProto.access$100().ensureFieldAccessorsInitialized(AssistAudioEventData.class, Builder.class);
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m49build();
            }

            public /* bridge */ /* synthetic */ Message buildPartial() {
                return m51buildPartial();
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
                return m55clear();
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
                return m65clone();
            }

            /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite m67getDefaultInstanceForType() {
                return m68getDefaultInstanceForType();
            }

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite m48build() {
                return m49build();
            }

            /* JADX INFO: renamed from: buildPartial, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite m50buildPartial() {
                return m51buildPartial();
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m52clear() {
                return m55clear();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder m61clone() {
                return m65clone();
            }

            /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
            public AssistAudioEventData m68getDefaultInstanceForType() {
                return AssistAudioEventData.getDefaultInstance();
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m53clear() {
                return m55clear();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m62clone() {
                return m65clone();
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite.Builder m54clear() {
                return m55clear();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m63clone() {
                return m65clone();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite.Builder m64clone() {
                return m65clone();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m66clone() throws CloneNotSupportedException {
                return m65clone();
            }

            private Builder(GeneratedMessageV3.BuilderParent r1) {
                super(r1);
                this.voiceWakeupDuration_ = Collections.emptyList();
                this.voiceWakeupEvent_ = Collections.emptyList();
                this.breathWakeupDuration_ = Collections.emptyList();
                this.breathWakeupEvent_ = Collections.emptyList();
                this.realtimeCallDurations_ = Collections.emptyList();
                this.realtimeCallEvents_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public Builder addAllBreathWakeupDuration(Iterable<? extends BreathWakeupDuration> r2) {
                RepeatedFieldBuilderV3<BreathWakeupDuration, BreathWakeupDuration.Builder, BreathWakeupDurationOrBuilder> r0 = this.breathWakeupDurationBuilder_;
                if (r0 != null) goto L5;
                ensureBreathWakeupDurationIsMutable();
                AbstractMessageLite.Builder.addAll(r2, this.breathWakeupDuration_);
                onChanged();
            L6:
                return this;
            L5:
                r0.addAllMessages(r2);
                goto L6
            }

            public Builder addAllBreathWakeupEvent(Iterable<? extends BreathWakeupEvent> r2) {
                RepeatedFieldBuilderV3<BreathWakeupEvent, BreathWakeupEvent.Builder, BreathWakeupEventOrBuilder> r0 = this.breathWakeupEventBuilder_;
                if (r0 != null) goto L5;
                ensureBreathWakeupEventIsMutable();
                AbstractMessageLite.Builder.addAll(r2, this.breathWakeupEvent_);
                onChanged();
            L6:
                return this;
            L5:
                r0.addAllMessages(r2);
                goto L6
            }

            public Builder addAllRealtimeCallDurations(Iterable<? extends RealtimeCallDuration> r2) {
                RepeatedFieldBuilderV3<RealtimeCallDuration, RealtimeCallDuration.Builder, RealtimeCallDurationOrBuilder> r0 = this.realtimeCallDurationsBuilder_;
                if (r0 != null) goto L5;
                ensureRealtimeCallDurationsIsMutable();
                AbstractMessageLite.Builder.addAll(r2, this.realtimeCallDurations_);
                onChanged();
            L6:
                return this;
            L5:
                r0.addAllMessages(r2);
                goto L6
            }

            public Builder addAllRealtimeCallEvents(Iterable<? extends RealtimeCallEvent> r2) {
                RepeatedFieldBuilderV3<RealtimeCallEvent, RealtimeCallEvent.Builder, RealtimeCallEventOrBuilder> r0 = this.realtimeCallEventsBuilder_;
                if (r0 != null) goto L5;
                ensureRealtimeCallEventsIsMutable();
                AbstractMessageLite.Builder.addAll(r2, this.realtimeCallEvents_);
                onChanged();
            L6:
                return this;
            L5:
                r0.addAllMessages(r2);
                goto L6
            }

            public Builder addAllVoiceWakeupDuration(Iterable<? extends VoiceWakeupDuration> r2) {
                RepeatedFieldBuilderV3<VoiceWakeupDuration, VoiceWakeupDuration.Builder, VoiceWakeupDurationOrBuilder> r0 = this.voiceWakeupDurationBuilder_;
                if (r0 != null) goto L5;
                ensureVoiceWakeupDurationIsMutable();
                AbstractMessageLite.Builder.addAll(r2, this.voiceWakeupDuration_);
                onChanged();
            L6:
                return this;
            L5:
                r0.addAllMessages(r2);
                goto L6
            }

            public Builder addAllVoiceWakeupEvent(Iterable<? extends VoiceWakeupEvent> r2) {
                RepeatedFieldBuilderV3<VoiceWakeupEvent, VoiceWakeupEvent.Builder, VoiceWakeupEventOrBuilder> r0 = this.voiceWakeupEventBuilder_;
                if (r0 != null) goto L5;
                ensureVoiceWakeupEventIsMutable();
                AbstractMessageLite.Builder.addAll(r2, this.voiceWakeupEvent_);
                onChanged();
            L6:
                return this;
            L5:
                r0.addAllMessages(r2);
                goto L6
            }

            public Builder addBreathWakeupDuration(BreathWakeupDuration.Builder r2) {
                RepeatedFieldBuilderV3<BreathWakeupDuration, BreathWakeupDuration.Builder, BreathWakeupDurationOrBuilder> r0 = this.breathWakeupDurationBuilder_;
                if (r0 != null) goto L5;
                ensureBreathWakeupDurationIsMutable();
                this.breathWakeupDuration_.add(r2.m142build());
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2.m142build());
                goto L6
            }

            public BreathWakeupDuration.Builder addBreathWakeupDurationBuilder(int r3) {
                return getBreathWakeupDurationFieldBuilder().addBuilder(r3, BreathWakeupDuration.getDefaultInstance());
            }

            public Builder addBreathWakeupEvent(BreathWakeupEvent.Builder r2) {
                RepeatedFieldBuilderV3<BreathWakeupEvent, BreathWakeupEvent.Builder, BreathWakeupEventOrBuilder> r0 = this.breathWakeupEventBuilder_;
                if (r0 != null) goto L5;
                ensureBreathWakeupEventIsMutable();
                this.breathWakeupEvent_.add(r2.m188build());
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2.m188build());
                goto L6
            }

            public BreathWakeupEvent.Builder addBreathWakeupEventBuilder(int r3) {
                return getBreathWakeupEventFieldBuilder().addBuilder(r3, BreathWakeupEvent.getDefaultInstance());
            }

            public Builder addRealtimeCallDurations(RealtimeCallDuration.Builder r2) {
                RepeatedFieldBuilderV3<RealtimeCallDuration, RealtimeCallDuration.Builder, RealtimeCallDurationOrBuilder> r0 = this.realtimeCallDurationsBuilder_;
                if (r0 != null) goto L5;
                ensureRealtimeCallDurationsIsMutable();
                this.realtimeCallDurations_.add(r2.m234build());
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2.m234build());
                goto L6
            }

            public RealtimeCallDuration.Builder addRealtimeCallDurationsBuilder(int r3) {
                return getRealtimeCallDurationsFieldBuilder().addBuilder(r3, RealtimeCallDuration.getDefaultInstance());
            }

            public Builder addRealtimeCallEvents(RealtimeCallEvent.Builder r2) {
                RepeatedFieldBuilderV3<RealtimeCallEvent, RealtimeCallEvent.Builder, RealtimeCallEventOrBuilder> r0 = this.realtimeCallEventsBuilder_;
                if (r0 != null) goto L5;
                ensureRealtimeCallEventsIsMutable();
                this.realtimeCallEvents_.add(r2.m280build());
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2.m280build());
                goto L6
            }

            public RealtimeCallEvent.Builder addRealtimeCallEventsBuilder(int r3) {
                return getRealtimeCallEventsFieldBuilder().addBuilder(r3, RealtimeCallEvent.getDefaultInstance());
            }

            public Builder addVoiceWakeupDuration(VoiceWakeupDuration.Builder r2) {
                RepeatedFieldBuilderV3<VoiceWakeupDuration, VoiceWakeupDuration.Builder, VoiceWakeupDurationOrBuilder> r0 = this.voiceWakeupDurationBuilder_;
                if (r0 != null) goto L5;
                ensureVoiceWakeupDurationIsMutable();
                this.voiceWakeupDuration_.add(r2.m326build());
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2.m326build());
                goto L6
            }

            public VoiceWakeupDuration.Builder addVoiceWakeupDurationBuilder(int r3) {
                return getVoiceWakeupDurationFieldBuilder().addBuilder(r3, VoiceWakeupDuration.getDefaultInstance());
            }

            public Builder addVoiceWakeupEvent(VoiceWakeupEvent.Builder r2) {
                RepeatedFieldBuilderV3<VoiceWakeupEvent, VoiceWakeupEvent.Builder, VoiceWakeupEventOrBuilder> r0 = this.voiceWakeupEventBuilder_;
                if (r0 != null) goto L5;
                ensureVoiceWakeupEventIsMutable();
                this.voiceWakeupEvent_.add(r2.m372build());
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2.m372build());
                goto L6
            }

            public VoiceWakeupEvent.Builder addVoiceWakeupEventBuilder(int r3) {
                return getVoiceWakeupEventFieldBuilder().addBuilder(r3, VoiceWakeupEvent.getDefaultInstance());
            }

            /* JADX INFO: renamed from: clearField, reason: collision with other method in class */
            public Builder m57clearField(Descriptors.FieldDescriptor r1) {
                return (Builder) super.clearField(r1);
            }

            /* JADX INFO: renamed from: clearOneof, reason: collision with other method in class */
            public Builder m60clearOneof(Descriptors.OneofDescriptor r1) {
                return (Builder) super.clearOneof(r1);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
            public BreathWakeupDuration getBreathWakeupDuration(int r2) {
                RepeatedFieldBuilderV3<BreathWakeupDuration, BreathWakeupDuration.Builder, BreathWakeupDurationOrBuilder> r0 = this.breathWakeupDurationBuilder_;
                if (r0 != null) goto L7;
                return (BreathWakeupDuration) ListProtector.get(this.breathWakeupDuration_, r2);
            L7:
                return r0.getMessage(r2);
            }

            public BreathWakeupDuration.Builder getBreathWakeupDurationBuilder(int r2) {
                return getBreathWakeupDurationFieldBuilder().getBuilder(r2);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
            public BreathWakeupDurationOrBuilder getBreathWakeupDurationOrBuilder(int r2) {
                RepeatedFieldBuilderV3<BreathWakeupDuration, BreathWakeupDuration.Builder, BreathWakeupDurationOrBuilder> r0 = this.breathWakeupDurationBuilder_;
                if (r0 != null) goto L7;
                return (BreathWakeupDurationOrBuilder) ListProtector.get(this.breathWakeupDuration_, r2);
            L7:
                return (BreathWakeupDurationOrBuilder) r0.getMessageOrBuilder(r2);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
            public BreathWakeupEvent getBreathWakeupEvent(int r2) {
                RepeatedFieldBuilderV3<BreathWakeupEvent, BreathWakeupEvent.Builder, BreathWakeupEventOrBuilder> r0 = this.breathWakeupEventBuilder_;
                if (r0 != null) goto L7;
                return (BreathWakeupEvent) ListProtector.get(this.breathWakeupEvent_, r2);
            L7:
                return r0.getMessage(r2);
            }

            public BreathWakeupEvent.Builder getBreathWakeupEventBuilder(int r2) {
                return getBreathWakeupEventFieldBuilder().getBuilder(r2);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
            public BreathWakeupEventOrBuilder getBreathWakeupEventOrBuilder(int r2) {
                RepeatedFieldBuilderV3<BreathWakeupEvent, BreathWakeupEvent.Builder, BreathWakeupEventOrBuilder> r0 = this.breathWakeupEventBuilder_;
                if (r0 != null) goto L7;
                return (BreathWakeupEventOrBuilder) ListProtector.get(this.breathWakeupEvent_, r2);
            L7:
                return (BreathWakeupEventOrBuilder) r0.getMessageOrBuilder(r2);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
            public RealtimeCallDuration getRealtimeCallDurations(int r2) {
                RepeatedFieldBuilderV3<RealtimeCallDuration, RealtimeCallDuration.Builder, RealtimeCallDurationOrBuilder> r0 = this.realtimeCallDurationsBuilder_;
                if (r0 != null) goto L7;
                return (RealtimeCallDuration) ListProtector.get(this.realtimeCallDurations_, r2);
            L7:
                return r0.getMessage(r2);
            }

            public RealtimeCallDuration.Builder getRealtimeCallDurationsBuilder(int r2) {
                return getRealtimeCallDurationsFieldBuilder().getBuilder(r2);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
            public RealtimeCallDurationOrBuilder getRealtimeCallDurationsOrBuilder(int r2) {
                RepeatedFieldBuilderV3<RealtimeCallDuration, RealtimeCallDuration.Builder, RealtimeCallDurationOrBuilder> r0 = this.realtimeCallDurationsBuilder_;
                if (r0 != null) goto L7;
                return (RealtimeCallDurationOrBuilder) ListProtector.get(this.realtimeCallDurations_, r2);
            L7:
                return (RealtimeCallDurationOrBuilder) r0.getMessageOrBuilder(r2);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
            public RealtimeCallEvent getRealtimeCallEvents(int r2) {
                RepeatedFieldBuilderV3<RealtimeCallEvent, RealtimeCallEvent.Builder, RealtimeCallEventOrBuilder> r0 = this.realtimeCallEventsBuilder_;
                if (r0 != null) goto L7;
                return (RealtimeCallEvent) ListProtector.get(this.realtimeCallEvents_, r2);
            L7:
                return r0.getMessage(r2);
            }

            public RealtimeCallEvent.Builder getRealtimeCallEventsBuilder(int r2) {
                return getRealtimeCallEventsFieldBuilder().getBuilder(r2);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
            public RealtimeCallEventOrBuilder getRealtimeCallEventsOrBuilder(int r2) {
                RepeatedFieldBuilderV3<RealtimeCallEvent, RealtimeCallEvent.Builder, RealtimeCallEventOrBuilder> r0 = this.realtimeCallEventsBuilder_;
                if (r0 != null) goto L7;
                return (RealtimeCallEventOrBuilder) ListProtector.get(this.realtimeCallEvents_, r2);
            L7:
                return (RealtimeCallEventOrBuilder) r0.getMessageOrBuilder(r2);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
            public VoiceWakeupDuration getVoiceWakeupDuration(int r2) {
                RepeatedFieldBuilderV3<VoiceWakeupDuration, VoiceWakeupDuration.Builder, VoiceWakeupDurationOrBuilder> r0 = this.voiceWakeupDurationBuilder_;
                if (r0 != null) goto L7;
                return (VoiceWakeupDuration) ListProtector.get(this.voiceWakeupDuration_, r2);
            L7:
                return r0.getMessage(r2);
            }

            public VoiceWakeupDuration.Builder getVoiceWakeupDurationBuilder(int r2) {
                return getVoiceWakeupDurationFieldBuilder().getBuilder(r2);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
            public VoiceWakeupDurationOrBuilder getVoiceWakeupDurationOrBuilder(int r2) {
                RepeatedFieldBuilderV3<VoiceWakeupDuration, VoiceWakeupDuration.Builder, VoiceWakeupDurationOrBuilder> r0 = this.voiceWakeupDurationBuilder_;
                if (r0 != null) goto L7;
                return (VoiceWakeupDurationOrBuilder) ListProtector.get(this.voiceWakeupDuration_, r2);
            L7:
                return (VoiceWakeupDurationOrBuilder) r0.getMessageOrBuilder(r2);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
            public VoiceWakeupEvent getVoiceWakeupEvent(int r2) {
                RepeatedFieldBuilderV3<VoiceWakeupEvent, VoiceWakeupEvent.Builder, VoiceWakeupEventOrBuilder> r0 = this.voiceWakeupEventBuilder_;
                if (r0 != null) goto L7;
                return (VoiceWakeupEvent) ListProtector.get(this.voiceWakeupEvent_, r2);
            L7:
                return r0.getMessage(r2);
            }

            public VoiceWakeupEvent.Builder getVoiceWakeupEventBuilder(int r2) {
                return getVoiceWakeupEventFieldBuilder().getBuilder(r2);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
            public VoiceWakeupEventOrBuilder getVoiceWakeupEventOrBuilder(int r2) {
                RepeatedFieldBuilderV3<VoiceWakeupEvent, VoiceWakeupEvent.Builder, VoiceWakeupEventOrBuilder> r0 = this.voiceWakeupEventBuilder_;
                if (r0 != null) goto L7;
                return (VoiceWakeupEventOrBuilder) ListProtector.get(this.voiceWakeupEvent_, r2);
            L7:
                return (VoiceWakeupEventOrBuilder) r0.getMessageOrBuilder(r2);
            }

            public Builder mergeFrom(AssistAudioEventData r4) {
                if (r4 != AssistAudioEventData.getDefaultInstance()) goto L5;
                return this;
            L5:
                RepeatedFieldBuilderV3<RealtimeCallEvent, RealtimeCallEvent.Builder, RealtimeCallEventOrBuilder> r1 = null;
                if (this.voiceWakeupDurationBuilder_ != null) goto L15;
                if (AssistAudioEventData.access$600(r4).isEmpty() == true) goto L25;
                if (this.voiceWakeupDuration_.isEmpty() == false) goto L12;
                this.voiceWakeupDuration_ = AssistAudioEventData.access$600(r4);
                this.bitField0_ &= -2;
            L13:
                onChanged();
                goto L25
            L12:
                ensureVoiceWakeupDurationIsMutable();
                this.voiceWakeupDuration_.addAll(AssistAudioEventData.access$600(r4));
            L25:
                if (this.voiceWakeupEventBuilder_ != null) goto L34;
                if (AssistAudioEventData.access$700(r4).isEmpty() == true) goto L44;
                if (this.voiceWakeupEvent_.isEmpty() == false) goto L31;
                this.voiceWakeupEvent_ = AssistAudioEventData.access$700(r4);
                this.bitField0_ &= -3;
            L32:
                onChanged();
                goto L44
            L31:
                ensureVoiceWakeupEventIsMutable();
                this.voiceWakeupEvent_.addAll(AssistAudioEventData.access$700(r4));
            L44:
                if (this.breathWakeupDurationBuilder_ != null) goto L53;
                if (AssistAudioEventData.access$800(r4).isEmpty() == true) goto L63;
                if (this.breathWakeupDuration_.isEmpty() == false) goto L50;
                this.breathWakeupDuration_ = AssistAudioEventData.access$800(r4);
                this.bitField0_ &= -5;
            L51:
                onChanged();
                goto L63
            L50:
                ensureBreathWakeupDurationIsMutable();
                this.breathWakeupDuration_.addAll(AssistAudioEventData.access$800(r4));
            L63:
                if (this.breathWakeupEventBuilder_ != null) goto L72;
                if (AssistAudioEventData.access$900(r4).isEmpty() == true) goto L82;
                if (this.breathWakeupEvent_.isEmpty() == false) goto L69;
                this.breathWakeupEvent_ = AssistAudioEventData.access$900(r4);
                this.bitField0_ &= -9;
            L70:
                onChanged();
                goto L82
            L69:
                ensureBreathWakeupEventIsMutable();
                this.breathWakeupEvent_.addAll(AssistAudioEventData.access$900(r4));
            L82:
                if (this.realtimeCallDurationsBuilder_ != null) goto L91;
                if (AssistAudioEventData.access$1000(r4).isEmpty() == true) goto L101;
                if (this.realtimeCallDurations_.isEmpty() == false) goto L88;
                this.realtimeCallDurations_ = AssistAudioEventData.access$1000(r4);
                this.bitField0_ &= -17;
            L89:
                onChanged();
                goto L101
            L88:
                ensureRealtimeCallDurationsIsMutable();
                this.realtimeCallDurations_.addAll(AssistAudioEventData.access$1000(r4));
            L101:
                if (this.realtimeCallEventsBuilder_ != null) goto L110;
                if (AssistAudioEventData.access$1100(r4).isEmpty() == false) goto L105;
            L118:
                m77mergeUnknownFields(AssistAudioEventData.access$1800(r4));
                onChanged();
                return this;
            L105:
                if (this.realtimeCallEvents_.isEmpty() == false) goto L107;
                this.realtimeCallEvents_ = AssistAudioEventData.access$1100(r4);
                this.bitField0_ &= -33;
            L108:
                onChanged();
                goto L118
            L107:
                ensureRealtimeCallEventsIsMutable();
                this.realtimeCallEvents_.addAll(AssistAudioEventData.access$1100(r4));
                goto L108
            L110:
                if (AssistAudioEventData.access$1100(r4).isEmpty() == true) goto L118;
                if (this.realtimeCallEventsBuilder_.isEmpty() == false) goto L117;
                this.realtimeCallEventsBuilder_.dispose();
                this.realtimeCallEventsBuilder_ = null;
                this.realtimeCallEvents_ = AssistAudioEventData.access$1100(r4);
                this.bitField0_ &= -33;
                if (AssistAudioEventData.access$1700() == false) goto L116;
                r1 = getRealtimeCallEventsFieldBuilder();
            L116:
                this.realtimeCallEventsBuilder_ = r1;
                goto L118
            L117:
                this.realtimeCallEventsBuilder_.addAllMessages(AssistAudioEventData.access$1100(r4));
                goto L118
            L91:
                if (AssistAudioEventData.access$1000(r4).isEmpty() == true) goto L101;
                if (this.realtimeCallDurationsBuilder_.isEmpty() == false) goto L99;
                this.realtimeCallDurationsBuilder_.dispose();
                this.realtimeCallDurationsBuilder_ = null;
                this.realtimeCallDurations_ = AssistAudioEventData.access$1000(r4);
                this.bitField0_ &= -17;
                if (AssistAudioEventData.access$1600() == false) goto L97;
                RepeatedFieldBuilderV3<RealtimeCallDuration, RealtimeCallDuration.Builder, RealtimeCallDurationOrBuilder> r0 = getRealtimeCallDurationsFieldBuilder();
            L98:
                this.realtimeCallDurationsBuilder_ = r0;
                goto L101
            L97:
                r0 = null;
                goto L98
            L99:
                this.realtimeCallDurationsBuilder_.addAllMessages(AssistAudioEventData.access$1000(r4));
                goto L101
            L72:
                if (AssistAudioEventData.access$900(r4).isEmpty() == true) goto L82;
                if (this.breathWakeupEventBuilder_.isEmpty() == false) goto L80;
                this.breathWakeupEventBuilder_.dispose();
                this.breathWakeupEventBuilder_ = null;
                this.breathWakeupEvent_ = AssistAudioEventData.access$900(r4);
                this.bitField0_ &= -9;
                if (AssistAudioEventData.access$1500() == false) goto L78;
                RepeatedFieldBuilderV3<BreathWakeupEvent, BreathWakeupEvent.Builder, BreathWakeupEventOrBuilder> r2 = getBreathWakeupEventFieldBuilder();
            L79:
                this.breathWakeupEventBuilder_ = r2;
                goto L82
            L78:
                r2 = null;
                goto L79
            L80:
                this.breathWakeupEventBuilder_.addAllMessages(AssistAudioEventData.access$900(r4));
                goto L82
            L53:
                if (AssistAudioEventData.access$800(r4).isEmpty() == true) goto L63;
                if (this.breathWakeupDurationBuilder_.isEmpty() == false) goto L61;
                this.breathWakeupDurationBuilder_.dispose();
                this.breathWakeupDurationBuilder_ = null;
                this.breathWakeupDuration_ = AssistAudioEventData.access$800(r4);
                this.bitField0_ &= -5;
                if (AssistAudioEventData.access$1400() == false) goto L59;
                RepeatedFieldBuilderV3<BreathWakeupDuration, BreathWakeupDuration.Builder, BreathWakeupDurationOrBuilder> r3 = getBreathWakeupDurationFieldBuilder();
            L60:
                this.breathWakeupDurationBuilder_ = r3;
                goto L63
            L59:
                r3 = null;
                goto L60
            L61:
                this.breathWakeupDurationBuilder_.addAllMessages(AssistAudioEventData.access$800(r4));
                goto L63
            L34:
                if (AssistAudioEventData.access$700(r4).isEmpty() == true) goto L44;
                if (this.voiceWakeupEventBuilder_.isEmpty() == false) goto L42;
                this.voiceWakeupEventBuilder_.dispose();
                this.voiceWakeupEventBuilder_ = null;
                this.voiceWakeupEvent_ = AssistAudioEventData.access$700(r4);
                this.bitField0_ &= -3;
                if (AssistAudioEventData.access$1300() == false) goto L40;
                RepeatedFieldBuilderV3<VoiceWakeupEvent, VoiceWakeupEvent.Builder, VoiceWakeupEventOrBuilder> r5 = getVoiceWakeupEventFieldBuilder();
            L41:
                this.voiceWakeupEventBuilder_ = r5;
                goto L44
            L40:
                r5 = null;
                goto L41
            L42:
                this.voiceWakeupEventBuilder_.addAllMessages(AssistAudioEventData.access$700(r4));
                goto L44
            L15:
                if (AssistAudioEventData.access$600(r4).isEmpty() == true) goto L25;
                if (this.voiceWakeupDurationBuilder_.isEmpty() == false) goto L23;
                this.voiceWakeupDurationBuilder_.dispose();
                this.voiceWakeupDurationBuilder_ = null;
                this.voiceWakeupDuration_ = AssistAudioEventData.access$600(r4);
                this.bitField0_ &= -2;
                if (AssistAudioEventData.access$1200() == false) goto L21;
                RepeatedFieldBuilderV3<VoiceWakeupDuration, VoiceWakeupDuration.Builder, VoiceWakeupDurationOrBuilder> r6 = getVoiceWakeupDurationFieldBuilder();
            L22:
                this.voiceWakeupDurationBuilder_ = r6;
                goto L25
            L21:
                r6 = null;
                goto L22
            L23:
                this.voiceWakeupDurationBuilder_.addAllMessages(AssistAudioEventData.access$600(r4));
                goto L25
            }

            /* JADX INFO: renamed from: mergeUnknownFields, reason: collision with other method in class */
            public final Builder m77mergeUnknownFields(UnknownFieldSet r1) {
                return (Builder) super.mergeUnknownFields(r1);
            }

            public Builder removeBreathWakeupDuration(int r2) {
                RepeatedFieldBuilderV3<BreathWakeupDuration, BreathWakeupDuration.Builder, BreathWakeupDurationOrBuilder> r0 = this.breathWakeupDurationBuilder_;
                if (r0 != null) goto L5;
                ensureBreathWakeupDurationIsMutable();
                ListProtector.remove(this.breathWakeupDuration_, r2);
                onChanged();
            L6:
                return this;
            L5:
                r0.remove(r2);
                goto L6
            }

            public Builder removeBreathWakeupEvent(int r2) {
                RepeatedFieldBuilderV3<BreathWakeupEvent, BreathWakeupEvent.Builder, BreathWakeupEventOrBuilder> r0 = this.breathWakeupEventBuilder_;
                if (r0 != null) goto L5;
                ensureBreathWakeupEventIsMutable();
                ListProtector.remove(this.breathWakeupEvent_, r2);
                onChanged();
            L6:
                return this;
            L5:
                r0.remove(r2);
                goto L6
            }

            public Builder removeRealtimeCallDurations(int r2) {
                RepeatedFieldBuilderV3<RealtimeCallDuration, RealtimeCallDuration.Builder, RealtimeCallDurationOrBuilder> r0 = this.realtimeCallDurationsBuilder_;
                if (r0 != null) goto L5;
                ensureRealtimeCallDurationsIsMutable();
                ListProtector.remove(this.realtimeCallDurations_, r2);
                onChanged();
            L6:
                return this;
            L5:
                r0.remove(r2);
                goto L6
            }

            public Builder removeRealtimeCallEvents(int r2) {
                RepeatedFieldBuilderV3<RealtimeCallEvent, RealtimeCallEvent.Builder, RealtimeCallEventOrBuilder> r0 = this.realtimeCallEventsBuilder_;
                if (r0 != null) goto L5;
                ensureRealtimeCallEventsIsMutable();
                ListProtector.remove(this.realtimeCallEvents_, r2);
                onChanged();
            L6:
                return this;
            L5:
                r0.remove(r2);
                goto L6
            }

            public Builder removeVoiceWakeupDuration(int r2) {
                RepeatedFieldBuilderV3<VoiceWakeupDuration, VoiceWakeupDuration.Builder, VoiceWakeupDurationOrBuilder> r0 = this.voiceWakeupDurationBuilder_;
                if (r0 != null) goto L5;
                ensureVoiceWakeupDurationIsMutable();
                ListProtector.remove(this.voiceWakeupDuration_, r2);
                onChanged();
            L6:
                return this;
            L5:
                r0.remove(r2);
                goto L6
            }

            public Builder removeVoiceWakeupEvent(int r2) {
                RepeatedFieldBuilderV3<VoiceWakeupEvent, VoiceWakeupEvent.Builder, VoiceWakeupEventOrBuilder> r0 = this.voiceWakeupEventBuilder_;
                if (r0 != null) goto L5;
                ensureVoiceWakeupEventIsMutable();
                ListProtector.remove(this.voiceWakeupEvent_, r2);
                onChanged();
            L6:
                return this;
            L5:
                r0.remove(r2);
                goto L6
            }

            /* JADX INFO: renamed from: setUnknownFields, reason: collision with other method in class */
            public final Builder m83setUnknownFields(UnknownFieldSet r1) {
                return (Builder) super.setUnknownFields(r1);
            }

            public /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            public Builder addBreathWakeupDuration(BreathWakeupDuration r2) {
                RepeatedFieldBuilderV3<BreathWakeupDuration, BreathWakeupDuration.Builder, BreathWakeupDurationOrBuilder> r0 = this.breathWakeupDurationBuilder_;
                if (r0 != null) goto L8;
                if (r2 == null) goto L7;
                ensureBreathWakeupDurationIsMutable();
                this.breathWakeupDuration_.add(r2);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.addMessage(r2);
                goto L9
            }

            public Builder addBreathWakeupEvent(BreathWakeupEvent r2) {
                RepeatedFieldBuilderV3<BreathWakeupEvent, BreathWakeupEvent.Builder, BreathWakeupEventOrBuilder> r0 = this.breathWakeupEventBuilder_;
                if (r0 != null) goto L8;
                if (r2 == null) goto L7;
                ensureBreathWakeupEventIsMutable();
                this.breathWakeupEvent_.add(r2);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.addMessage(r2);
                goto L9
            }

            public Builder addRealtimeCallDurations(RealtimeCallDuration r2) {
                RepeatedFieldBuilderV3<RealtimeCallDuration, RealtimeCallDuration.Builder, RealtimeCallDurationOrBuilder> r0 = this.realtimeCallDurationsBuilder_;
                if (r0 != null) goto L8;
                if (r2 == null) goto L7;
                ensureRealtimeCallDurationsIsMutable();
                this.realtimeCallDurations_.add(r2);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.addMessage(r2);
                goto L9
            }

            public Builder addRealtimeCallEvents(RealtimeCallEvent r2) {
                RepeatedFieldBuilderV3<RealtimeCallEvent, RealtimeCallEvent.Builder, RealtimeCallEventOrBuilder> r0 = this.realtimeCallEventsBuilder_;
                if (r0 != null) goto L8;
                if (r2 == null) goto L7;
                ensureRealtimeCallEventsIsMutable();
                this.realtimeCallEvents_.add(r2);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.addMessage(r2);
                goto L9
            }

            public Builder addVoiceWakeupDuration(VoiceWakeupDuration r2) {
                RepeatedFieldBuilderV3<VoiceWakeupDuration, VoiceWakeupDuration.Builder, VoiceWakeupDurationOrBuilder> r0 = this.voiceWakeupDurationBuilder_;
                if (r0 != null) goto L8;
                if (r2 == null) goto L7;
                ensureVoiceWakeupDurationIsMutable();
                this.voiceWakeupDuration_.add(r2);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.addMessage(r2);
                goto L9
            }

            public Builder addVoiceWakeupEvent(VoiceWakeupEvent r2) {
                RepeatedFieldBuilderV3<VoiceWakeupEvent, VoiceWakeupEvent.Builder, VoiceWakeupEventOrBuilder> r0 = this.voiceWakeupEventBuilder_;
                if (r0 != null) goto L8;
                if (r2 == null) goto L7;
                ensureVoiceWakeupEventIsMutable();
                this.voiceWakeupEvent_.add(r2);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.addMessage(r2);
                goto L9
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearField(Descriptors.FieldDescriptor r1) {
                return m57clearField(r1);
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r1) {
                return m60clearOneof(r1);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public Builder m74mergeFrom(Message r2) {
                if ((r2 instanceof AssistAudioEventData) == true) goto L5;
                super/*com.google.protobuf.AbstractMessage.Builder*/.mergeFrom(r2);
                return this;
            L5:
                return mergeFrom((AssistAudioEventData) r2);
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r1) {
                return m77mergeUnknownFields(r1);
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r1) {
                return m83setUnknownFields(r1);
            }

            /* JADX INFO: renamed from: clearField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m56clearField(Descriptors.FieldDescriptor r1) {
                return m57clearField(r1);
            }

            /* JADX INFO: renamed from: clearOneof, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m58clearOneof(Descriptors.OneofDescriptor r1) {
                return m60clearOneof(r1);
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r1) {
                return m74mergeFrom(r1);
            }

            /* JADX INFO: renamed from: mergeUnknownFields, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m75mergeUnknownFields(UnknownFieldSet r1) {
                return m77mergeUnknownFields(r1);
            }

            /* JADX INFO: renamed from: setUnknownFields, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m82setUnknownFields(UnknownFieldSet r1) {
                return m83setUnknownFields(r1);
            }

            /* JADX INFO: renamed from: clearOneof, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m59clearOneof(Descriptors.OneofDescriptor r1) {
                return m60clearOneof(r1);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m71mergeFrom(Message r1) {
                return m74mergeFrom(r1);
            }

            /* JADX INFO: renamed from: mergeUnknownFields, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m76mergeUnknownFields(UnknownFieldSet r1) {
                return m77mergeUnknownFields(r1);
            }

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r1, AnonymousClass1 r2) {
                this(r1);
            }

            public Builder addBreathWakeupDuration(int r2, BreathWakeupDuration.Builder r3) {
                RepeatedFieldBuilderV3<BreathWakeupDuration, BreathWakeupDuration.Builder, BreathWakeupDurationOrBuilder> r0 = this.breathWakeupDurationBuilder_;
                if (r0 != null) goto L5;
                ensureBreathWakeupDurationIsMutable();
                ListProtector.add(this.breathWakeupDuration_, r2, r3.m142build());
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2, r3.m142build());
                goto L6
            }

            public Builder addBreathWakeupEvent(int r2, BreathWakeupEvent.Builder r3) {
                RepeatedFieldBuilderV3<BreathWakeupEvent, BreathWakeupEvent.Builder, BreathWakeupEventOrBuilder> r0 = this.breathWakeupEventBuilder_;
                if (r0 != null) goto L5;
                ensureBreathWakeupEventIsMutable();
                ListProtector.add(this.breathWakeupEvent_, r2, r3.m188build());
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2, r3.m188build());
                goto L6
            }

            public Builder addRealtimeCallDurations(int r2, RealtimeCallDuration.Builder r3) {
                RepeatedFieldBuilderV3<RealtimeCallDuration, RealtimeCallDuration.Builder, RealtimeCallDurationOrBuilder> r0 = this.realtimeCallDurationsBuilder_;
                if (r0 != null) goto L5;
                ensureRealtimeCallDurationsIsMutable();
                ListProtector.add(this.realtimeCallDurations_, r2, r3.m234build());
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2, r3.m234build());
                goto L6
            }

            public Builder addRealtimeCallEvents(int r2, RealtimeCallEvent.Builder r3) {
                RepeatedFieldBuilderV3<RealtimeCallEvent, RealtimeCallEvent.Builder, RealtimeCallEventOrBuilder> r0 = this.realtimeCallEventsBuilder_;
                if (r0 != null) goto L5;
                ensureRealtimeCallEventsIsMutable();
                ListProtector.add(this.realtimeCallEvents_, r2, r3.m280build());
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2, r3.m280build());
                goto L6
            }

            /* JADX INFO: renamed from: addRepeatedField, reason: collision with other method in class */
            public Builder m47addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
                return (Builder) super.addRepeatedField(r1, r2);
            }

            public Builder addVoiceWakeupDuration(int r2, VoiceWakeupDuration.Builder r3) {
                RepeatedFieldBuilderV3<VoiceWakeupDuration, VoiceWakeupDuration.Builder, VoiceWakeupDurationOrBuilder> r0 = this.voiceWakeupDurationBuilder_;
                if (r0 != null) goto L5;
                ensureVoiceWakeupDurationIsMutable();
                ListProtector.add(this.voiceWakeupDuration_, r2, r3.m326build());
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2, r3.m326build());
                goto L6
            }

            public Builder addVoiceWakeupEvent(int r2, VoiceWakeupEvent.Builder r3) {
                RepeatedFieldBuilderV3<VoiceWakeupEvent, VoiceWakeupEvent.Builder, VoiceWakeupEventOrBuilder> r0 = this.voiceWakeupEventBuilder_;
                if (r0 != null) goto L5;
                ensureVoiceWakeupEventIsMutable();
                ListProtector.add(this.voiceWakeupEvent_, r2, r3.m372build());
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2, r3.m372build());
                goto L6
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public Builder m73mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                AssistAudioEventData r0 = null;
                AssistAudioEventData r5 = (AssistAudioEventData) AssistAudioEventData.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                AssistAudioEventData r6 = (AssistAudioEventData) e.getUnfinishedMessage();     // Catch: Throwable -> L7
            L13:
                th = th;
                r0 = r6;
            L15:
                if (r0 == null) goto L17;
                mergeFrom(r0);
            L17:
                throw th;
            L12:
                throw e.unwrapIOException();     // Catch: Throwable -> L13
            L7:
                th = th;
                goto L15
            }

            public Builder setBreathWakeupDuration(int r2, BreathWakeupDuration.Builder r3) {
                RepeatedFieldBuilderV3<BreathWakeupDuration, BreathWakeupDuration.Builder, BreathWakeupDurationOrBuilder> r0 = this.breathWakeupDurationBuilder_;
                if (r0 != null) goto L5;
                ensureBreathWakeupDurationIsMutable();
                ListProtector.set(this.breathWakeupDuration_, r2, r3.m142build());
                onChanged();
            L6:
                return this;
            L5:
                r0.setMessage(r2, r3.m142build());
                goto L6
            }

            public Builder setBreathWakeupEvent(int r2, BreathWakeupEvent.Builder r3) {
                RepeatedFieldBuilderV3<BreathWakeupEvent, BreathWakeupEvent.Builder, BreathWakeupEventOrBuilder> r0 = this.breathWakeupEventBuilder_;
                if (r0 != null) goto L5;
                ensureBreathWakeupEventIsMutable();
                ListProtector.set(this.breathWakeupEvent_, r2, r3.m188build());
                onChanged();
            L6:
                return this;
            L5:
                r0.setMessage(r2, r3.m188build());
                goto L6
            }

            /* JADX INFO: renamed from: setField, reason: collision with other method in class */
            public Builder m79setField(Descriptors.FieldDescriptor r1, Object r2) {
                return (Builder) super.setField(r1, r2);
            }

            public Builder setRealtimeCallDurations(int r2, RealtimeCallDuration.Builder r3) {
                RepeatedFieldBuilderV3<RealtimeCallDuration, RealtimeCallDuration.Builder, RealtimeCallDurationOrBuilder> r0 = this.realtimeCallDurationsBuilder_;
                if (r0 != null) goto L5;
                ensureRealtimeCallDurationsIsMutable();
                ListProtector.set(this.realtimeCallDurations_, r2, r3.m234build());
                onChanged();
            L6:
                return this;
            L5:
                r0.setMessage(r2, r3.m234build());
                goto L6
            }

            public Builder setRealtimeCallEvents(int r2, RealtimeCallEvent.Builder r3) {
                RepeatedFieldBuilderV3<RealtimeCallEvent, RealtimeCallEvent.Builder, RealtimeCallEventOrBuilder> r0 = this.realtimeCallEventsBuilder_;
                if (r0 != null) goto L5;
                ensureRealtimeCallEventsIsMutable();
                ListProtector.set(this.realtimeCallEvents_, r2, r3.m280build());
                onChanged();
            L6:
                return this;
            L5:
                r0.setMessage(r2, r3.m280build());
                goto L6
            }

            public Builder setVoiceWakeupDuration(int r2, VoiceWakeupDuration.Builder r3) {
                RepeatedFieldBuilderV3<VoiceWakeupDuration, VoiceWakeupDuration.Builder, VoiceWakeupDurationOrBuilder> r0 = this.voiceWakeupDurationBuilder_;
                if (r0 != null) goto L5;
                ensureVoiceWakeupDurationIsMutable();
                ListProtector.set(this.voiceWakeupDuration_, r2, r3.m326build());
                onChanged();
            L6:
                return this;
            L5:
                r0.setMessage(r2, r3.m326build());
                goto L6
            }

            public Builder setVoiceWakeupEvent(int r2, VoiceWakeupEvent.Builder r3) {
                RepeatedFieldBuilderV3<VoiceWakeupEvent, VoiceWakeupEvent.Builder, VoiceWakeupEventOrBuilder> r0 = this.voiceWakeupEventBuilder_;
                if (r0 != null) goto L5;
                ensureVoiceWakeupEventIsMutable();
                ListProtector.set(this.voiceWakeupEvent_, r2, r3.m372build());
                onChanged();
            L6:
                return this;
            L5:
                r0.setMessage(r2, r3.m372build());
                goto L6
            }

            public Builder addBreathWakeupDuration(int r2, BreathWakeupDuration r3) {
                RepeatedFieldBuilderV3<BreathWakeupDuration, BreathWakeupDuration.Builder, BreathWakeupDurationOrBuilder> r0 = this.breathWakeupDurationBuilder_;
                if (r0 != null) goto L8;
                if (r3 == null) goto L7;
                ensureBreathWakeupDurationIsMutable();
                ListProtector.add(this.breathWakeupDuration_, r2, r3);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.addMessage(r2, r3);
                goto L9
            }

            public Builder addBreathWakeupEvent(int r2, BreathWakeupEvent r3) {
                RepeatedFieldBuilderV3<BreathWakeupEvent, BreathWakeupEvent.Builder, BreathWakeupEventOrBuilder> r0 = this.breathWakeupEventBuilder_;
                if (r0 != null) goto L8;
                if (r3 == null) goto L7;
                ensureBreathWakeupEventIsMutable();
                ListProtector.add(this.breathWakeupEvent_, r2, r3);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.addMessage(r2, r3);
                goto L9
            }

            public Builder addRealtimeCallDurations(int r2, RealtimeCallDuration r3) {
                RepeatedFieldBuilderV3<RealtimeCallDuration, RealtimeCallDuration.Builder, RealtimeCallDurationOrBuilder> r0 = this.realtimeCallDurationsBuilder_;
                if (r0 != null) goto L8;
                if (r3 == null) goto L7;
                ensureRealtimeCallDurationsIsMutable();
                ListProtector.add(this.realtimeCallDurations_, r2, r3);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.addMessage(r2, r3);
                goto L9
            }

            public Builder addRealtimeCallEvents(int r2, RealtimeCallEvent r3) {
                RepeatedFieldBuilderV3<RealtimeCallEvent, RealtimeCallEvent.Builder, RealtimeCallEventOrBuilder> r0 = this.realtimeCallEventsBuilder_;
                if (r0 != null) goto L8;
                if (r3 == null) goto L7;
                ensureRealtimeCallEventsIsMutable();
                ListProtector.add(this.realtimeCallEvents_, r2, r3);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.addMessage(r2, r3);
                goto L9
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
                return m47addRepeatedField(r1, r2);
            }

            public Builder addVoiceWakeupDuration(int r2, VoiceWakeupDuration r3) {
                RepeatedFieldBuilderV3<VoiceWakeupDuration, VoiceWakeupDuration.Builder, VoiceWakeupDurationOrBuilder> r0 = this.voiceWakeupDurationBuilder_;
                if (r0 != null) goto L8;
                if (r3 == null) goto L7;
                ensureVoiceWakeupDurationIsMutable();
                ListProtector.add(this.voiceWakeupDuration_, r2, r3);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.addMessage(r2, r3);
                goto L9
            }

            public Builder addVoiceWakeupEvent(int r2, VoiceWakeupEvent r3) {
                RepeatedFieldBuilderV3<VoiceWakeupEvent, VoiceWakeupEvent.Builder, VoiceWakeupEventOrBuilder> r0 = this.voiceWakeupEventBuilder_;
                if (r0 != null) goto L8;
                if (r3 == null) goto L7;
                ensureVoiceWakeupEventIsMutable();
                ListProtector.add(this.voiceWakeupEvent_, r2, r3);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.addMessage(r2, r3);
                goto L9
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m73mergeFrom(r1, r2);
            }

            public Builder setBreathWakeupDuration(int r2, BreathWakeupDuration r3) {
                RepeatedFieldBuilderV3<BreathWakeupDuration, BreathWakeupDuration.Builder, BreathWakeupDurationOrBuilder> r0 = this.breathWakeupDurationBuilder_;
                if (r0 != null) goto L8;
                if (r3 == null) goto L7;
                ensureBreathWakeupDurationIsMutable();
                ListProtector.set(this.breathWakeupDuration_, r2, r3);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.setMessage(r2, r3);
                goto L9
            }

            public Builder setBreathWakeupEvent(int r2, BreathWakeupEvent r3) {
                RepeatedFieldBuilderV3<BreathWakeupEvent, BreathWakeupEvent.Builder, BreathWakeupEventOrBuilder> r0 = this.breathWakeupEventBuilder_;
                if (r0 != null) goto L8;
                if (r3 == null) goto L7;
                ensureBreathWakeupEventIsMutable();
                ListProtector.set(this.breathWakeupEvent_, r2, r3);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.setMessage(r2, r3);
                goto L9
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setField(Descriptors.FieldDescriptor r1, Object r2) {
                return m79setField(r1, r2);
            }

            public Builder setRealtimeCallDurations(int r2, RealtimeCallDuration r3) {
                RepeatedFieldBuilderV3<RealtimeCallDuration, RealtimeCallDuration.Builder, RealtimeCallDurationOrBuilder> r0 = this.realtimeCallDurationsBuilder_;
                if (r0 != null) goto L8;
                if (r3 == null) goto L7;
                ensureRealtimeCallDurationsIsMutable();
                ListProtector.set(this.realtimeCallDurations_, r2, r3);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.setMessage(r2, r3);
                goto L9
            }

            public Builder setRealtimeCallEvents(int r2, RealtimeCallEvent r3) {
                RepeatedFieldBuilderV3<RealtimeCallEvent, RealtimeCallEvent.Builder, RealtimeCallEventOrBuilder> r0 = this.realtimeCallEventsBuilder_;
                if (r0 != null) goto L8;
                if (r3 == null) goto L7;
                ensureRealtimeCallEventsIsMutable();
                ListProtector.set(this.realtimeCallEvents_, r2, r3);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.setMessage(r2, r3);
                goto L9
            }

            public Builder setVoiceWakeupDuration(int r2, VoiceWakeupDuration r3) {
                RepeatedFieldBuilderV3<VoiceWakeupDuration, VoiceWakeupDuration.Builder, VoiceWakeupDurationOrBuilder> r0 = this.voiceWakeupDurationBuilder_;
                if (r0 != null) goto L8;
                if (r3 == null) goto L7;
                ensureVoiceWakeupDurationIsMutable();
                ListProtector.set(this.voiceWakeupDuration_, r2, r3);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.setMessage(r2, r3);
                goto L9
            }

            public Builder setVoiceWakeupEvent(int r2, VoiceWakeupEvent r3) {
                RepeatedFieldBuilderV3<VoiceWakeupEvent, VoiceWakeupEvent.Builder, VoiceWakeupEventOrBuilder> r0 = this.voiceWakeupEventBuilder_;
                if (r0 != null) goto L8;
                if (r3 == null) goto L7;
                ensureVoiceWakeupEventIsMutable();
                ListProtector.set(this.voiceWakeupEvent_, r2, r3);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.setMessage(r2, r3);
                goto L9
            }

            /* JADX INFO: renamed from: addRepeatedField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m46addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
                return m47addRepeatedField(r1, r2);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder m69mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m73mergeFrom(r1, r2);
            }

            /* JADX INFO: renamed from: setField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m78setField(Descriptors.FieldDescriptor r1, Object r2) {
                return m79setField(r1, r2);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m70mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m73mergeFrom(r1, r2);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite.Builder m72mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m73mergeFrom(r1, r2);
            }

            /* JADX INFO: renamed from: setRepeatedField, reason: collision with other method in class */
            public Builder m81setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
                return (Builder) super.setRepeatedField(r1, r2, r3);
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
                return m81setRepeatedField(r1, r2, r3);
            }

            /* JADX INFO: renamed from: setRepeatedField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m80setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
                return m81setRepeatedField(r1, r2, r3);
            }
        }

        static {
            DEFAULT_INSTANCE = new AssistAudioEventData();
            PARSER = new AnonymousClass1();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m44toBuilder();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
        public int getBreathWakeupDurationCount() {
            return this.breathWakeupDuration_.size();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
        public int getBreathWakeupEventCount() {
            return this.breathWakeupEvent_.size();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
        public int getRealtimeCallDurationsCount() {
            return this.realtimeCallDurations_.size();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
        public int getRealtimeCallEventsCount() {
            return this.realtimeCallEvents_.size();
        }

        public int getSerializedSize() {
            int r0 = ((AbstractMessage) this).memoizedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r1 = 0;
            int r2 = 0;
            int r3 = 0;
        L7:
            if (r2 >= this.voiceWakeupDuration_.size()) goto L9;
            r3 = r3 + CodedOutputStream.computeMessageSize(1, (MessageLite) ListProtector.get(this.voiceWakeupDuration_, r2));
            r2 = r2 + 1;
            goto L7
        L9:
            int r4 = 0;
        L11:
            if (r4 >= this.voiceWakeupEvent_.size()) goto L13;
            r3 = r3 + CodedOutputStream.computeMessageSize(2, (MessageLite) ListProtector.get(this.voiceWakeupEvent_, r4));
            r4 = r4 + 1;
            goto L11
        L13:
            int r5 = 0;
        L15:
            if (r5 >= this.breathWakeupDuration_.size()) goto L17;
            r3 = r3 + CodedOutputStream.computeMessageSize(3, (MessageLite) ListProtector.get(this.breathWakeupDuration_, r5));
            r5 = r5 + 1;
            goto L15
        L17:
            int r6 = 0;
        L19:
            if (r6 >= this.breathWakeupEvent_.size()) goto L21;
            r3 = r3 + CodedOutputStream.computeMessageSize(4, (MessageLite) ListProtector.get(this.breathWakeupEvent_, r6));
            r6 = r6 + 1;
            goto L19
        L21:
            int r7 = 0;
        L23:
            if (r7 >= this.realtimeCallDurations_.size()) goto L26;
            r3 = r3 + CodedOutputStream.computeMessageSize(5, (MessageLite) ListProtector.get(this.realtimeCallDurations_, r7));
            r7 = r7 + 1;
        L26:
            if (r1 >= this.realtimeCallEvents_.size()) goto L28;
            r3 = r3 + CodedOutputStream.computeMessageSize(6, (MessageLite) ListProtector.get(this.realtimeCallEvents_, r1));
            r1 = r1 + 1;
            goto L26
        L28:
            int r8 = r3 + ((GeneratedMessageV3) this).unknownFields.getSerializedSize();
            ((AbstractMessage) this).memoizedSize = r8;
            return r8;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
        public int getVoiceWakeupDurationCount() {
            return this.voiceWakeupDuration_.size();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
        public int getVoiceWakeupEventCount() {
            return this.voiceWakeupEvent_.size();
        }

        public int hashCode() {
            int r0 = ((AbstractMessageLite) this).memoizedHashCode;
            if (r0 == 0) goto L5;
            return r0;
        L5:
            int r1 = 779 + getDescriptor().hashCode();
            if (getVoiceWakeupDurationCount() <= 0) goto L9;
            r1 = (((r1 * 37) + 1) * 53) + getVoiceWakeupDurationList().hashCode();
        L9:
            if (getVoiceWakeupEventCount() <= 0) goto L12;
            r1 = (((r1 * 37) + 2) * 53) + getVoiceWakeupEventList().hashCode();
        L12:
            if (getBreathWakeupDurationCount() <= 0) goto L15;
            r1 = (((r1 * 37) + 3) * 53) + getBreathWakeupDurationList().hashCode();
        L15:
            if (getBreathWakeupEventCount() <= 0) goto L18;
            r1 = (((r1 * 37) + 4) * 53) + getBreathWakeupEventList().hashCode();
        L18:
            if (getRealtimeCallDurationsCount() <= 0) goto L21;
            r1 = (((r1 * 37) + 5) * 53) + getRealtimeCallDurationsList().hashCode();
        L21:
            if (getRealtimeCallEventsCount() <= 0) goto L23;
            r1 = (((r1 * 37) + 6) * 53) + getRealtimeCallEventsList().hashCode();
        L23:
            int r2 = (r1 * 29) + ((GeneratedMessageV3) this).unknownFields.hashCode();
            ((AbstractMessageLite) this).memoizedHashCode = r2;
            return r2;
        }

        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L5;
            return true;
        L5:
            if (r0 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        /* JADX INFO: renamed from: toBuilder, reason: collision with other method in class */
        public Builder m44toBuilder() {
            AnonymousClass1 r1 = null;
            if (this != DEFAULT_INSTANCE) goto L6;
            return new Builder(r1);
        L6:
            return new Builder(r1).mergeFrom(this);
        }

        private AssistAudioEventData() {
            this.memoizedIsInitialized = -1;
            this.voiceWakeupDuration_ = Collections.emptyList();
            this.voiceWakeupEvent_ = Collections.emptyList();
            this.breathWakeupDuration_ = Collections.emptyList();
            this.breathWakeupEvent_ = Collections.emptyList();
            this.realtimeCallDurations_ = Collections.emptyList();
            this.realtimeCallEvents_ = Collections.emptyList();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AssistAudioEventProto.access$000();
        }

        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return m39getDefaultInstanceForType();
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AssistAudioEventProto.access$100().ensureFieldAccessorsInitialized(AssistAudioEventData.class, Builder.class);
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return m41newBuilderForType();
        }

        public static /* synthetic */ boolean access$1200() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ boolean access$1300() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ boolean access$1400() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ boolean access$1500() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ boolean access$1600() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ boolean access$1700() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ boolean access$400() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static AssistAudioEventData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AssistAudioEventData> parser() {
            return PARSER;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
        public List<BreathWakeupDuration> getBreathWakeupDurationList() {
            return this.breathWakeupDuration_;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
        public List<? extends BreathWakeupDurationOrBuilder> getBreathWakeupDurationOrBuilderList() {
            return this.breathWakeupDuration_;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
        public List<BreathWakeupEvent> getBreathWakeupEventList() {
            return this.breathWakeupEvent_;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
        public List<? extends BreathWakeupEventOrBuilder> getBreathWakeupEventOrBuilderList() {
            return this.breathWakeupEvent_;
        }

        public Parser<AssistAudioEventData> getParserForType() {
            return PARSER;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
        public List<RealtimeCallDuration> getRealtimeCallDurationsList() {
            return this.realtimeCallDurations_;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
        public List<? extends RealtimeCallDurationOrBuilder> getRealtimeCallDurationsOrBuilderList() {
            return this.realtimeCallDurations_;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
        public List<RealtimeCallEvent> getRealtimeCallEventsList() {
            return this.realtimeCallEvents_;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
        public List<? extends RealtimeCallEventOrBuilder> getRealtimeCallEventsOrBuilderList() {
            return this.realtimeCallEvents_;
        }

        public final UnknownFieldSet getUnknownFields() {
            return ((GeneratedMessageV3) this).unknownFields;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
        public List<VoiceWakeupDuration> getVoiceWakeupDurationList() {
            return this.voiceWakeupDuration_;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
        public List<? extends VoiceWakeupDurationOrBuilder> getVoiceWakeupDurationOrBuilderList() {
            return this.voiceWakeupDuration_;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
        public List<VoiceWakeupEvent> getVoiceWakeupEventList() {
            return this.voiceWakeupEvent_;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
        public List<? extends VoiceWakeupEventOrBuilder> getVoiceWakeupEventOrBuilderList() {
            return this.voiceWakeupEvent_;
        }

        /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite m38getDefaultInstanceForType() {
            return m39getDefaultInstanceForType();
        }

        /* JADX INFO: renamed from: newBuilderForType, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite.Builder m40newBuilderForType() {
            return m41newBuilderForType();
        }

        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return m44toBuilder();
        }

        /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
        public AssistAudioEventData m39getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: renamed from: newBuilderForType, reason: collision with other method in class */
        public Builder m41newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: renamed from: toBuilder, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite.Builder m43toBuilder() {
            return m44toBuilder();
        }

        private AssistAudioEventData(GeneratedMessageV3.Builder<?> r1) {
            super(r1);
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ List access$1000(AssistAudioEventData r0) {
            return r0.realtimeCallDurations_;
        }

        public static /* synthetic */ List access$1100(AssistAudioEventData r0) {
            return r0.realtimeCallEvents_;
        }

        public static /* synthetic */ UnknownFieldSet access$1800(AssistAudioEventData r0) {
            return ((GeneratedMessageV3) r0).unknownFields;
        }

        public static /* synthetic */ List access$600(AssistAudioEventData r0) {
            return r0.voiceWakeupDuration_;
        }

        public static /* synthetic */ List access$700(AssistAudioEventData r0) {
            return r0.voiceWakeupEvent_;
        }

        public static /* synthetic */ List access$800(AssistAudioEventData r0) {
            return r0.breathWakeupDuration_;
        }

        public static /* synthetic */ List access$900(AssistAudioEventData r0) {
            return r0.breathWakeupEvent_;
        }

        public static Builder newBuilder(AssistAudioEventData r1) {
            return DEFAULT_INSTANCE.m44toBuilder().mergeFrom(r1);
        }

        public static AssistAudioEventData parseDelimitedFrom(InputStream r1) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r1);
        }

        public static AssistAudioEventData parseFrom(ByteString r1) throws InvalidProtocolBufferException {
            return (AssistAudioEventData) PARSER.parseFrom(r1);
        }

        public boolean equals(Object r5) {
            if (r5 != this) goto L6;
            return true;
        L6:
            if ((r5 instanceof AssistAudioEventData) == false) goto L8;
            AssistAudioEventData r6 = (AssistAudioEventData) r5;
            if (getVoiceWakeupDurationList().equals(r6.getVoiceWakeupDurationList()) == false) goto L12;
            boolean r1 = true;
        L13:
            if (r1 == true) goto L15;
        L17:
            boolean r2 = false;
        L18:
            if (r2 == true) goto L20;
        L22:
            boolean r3 = false;
        L23:
            if (r3 == true) goto L25;
        L27:
            boolean r4 = false;
        L28:
            if (r4 == true) goto L30;
        L32:
            boolean r7 = false;
        L33:
            if (r7 == true) goto L35;
        L37:
            boolean r8 = false;
        L38:
            if (r8 == true) goto L40;
        L42:
            return false;
        L40:
            if (((GeneratedMessageV3) this).unknownFields.equals(((GeneratedMessageV3) r6).unknownFields) == false) goto L42;
            return true;
        L35:
            if (getRealtimeCallEventsList().equals(r6.getRealtimeCallEventsList()) == false) goto L37;
            r8 = true;
            goto L38
        L30:
            if (getRealtimeCallDurationsList().equals(r6.getRealtimeCallDurationsList()) == false) goto L32;
            r7 = true;
            goto L33
        L25:
            if (getBreathWakeupEventList().equals(r6.getBreathWakeupEventList()) == false) goto L27;
            r4 = true;
            goto L28
        L20:
            if (getBreathWakeupDurationList().equals(r6.getBreathWakeupDurationList()) == false) goto L22;
            r3 = true;
            goto L23
        L15:
            if (getVoiceWakeupEventList().equals(r6.getVoiceWakeupEventList()) == false) goto L17;
            r2 = true;
            goto L18
        L12:
            r1 = false;
            goto L13
        L8:
            return super/*com.google.protobuf.AbstractMessage*/.equals(r5);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
        public BreathWakeupDuration getBreathWakeupDuration(int r2) {
            return (BreathWakeupDuration) ListProtector.get(this.breathWakeupDuration_, r2);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
        public BreathWakeupDurationOrBuilder getBreathWakeupDurationOrBuilder(int r2) {
            return (BreathWakeupDurationOrBuilder) ListProtector.get(this.breathWakeupDuration_, r2);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
        public BreathWakeupEvent getBreathWakeupEvent(int r2) {
            return (BreathWakeupEvent) ListProtector.get(this.breathWakeupEvent_, r2);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
        public BreathWakeupEventOrBuilder getBreathWakeupEventOrBuilder(int r2) {
            return (BreathWakeupEventOrBuilder) ListProtector.get(this.breathWakeupEvent_, r2);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
        public RealtimeCallDuration getRealtimeCallDurations(int r2) {
            return (RealtimeCallDuration) ListProtector.get(this.realtimeCallDurations_, r2);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
        public RealtimeCallDurationOrBuilder getRealtimeCallDurationsOrBuilder(int r2) {
            return (RealtimeCallDurationOrBuilder) ListProtector.get(this.realtimeCallDurations_, r2);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
        public RealtimeCallEvent getRealtimeCallEvents(int r2) {
            return (RealtimeCallEvent) ListProtector.get(this.realtimeCallEvents_, r2);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
        public RealtimeCallEventOrBuilder getRealtimeCallEventsOrBuilder(int r2) {
            return (RealtimeCallEventOrBuilder) ListProtector.get(this.realtimeCallEvents_, r2);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
        public VoiceWakeupDuration getVoiceWakeupDuration(int r2) {
            return (VoiceWakeupDuration) ListProtector.get(this.voiceWakeupDuration_, r2);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
        public VoiceWakeupDurationOrBuilder getVoiceWakeupDurationOrBuilder(int r2) {
            return (VoiceWakeupDurationOrBuilder) ListProtector.get(this.voiceWakeupDuration_, r2);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
        public VoiceWakeupEvent getVoiceWakeupEvent(int r2) {
            return (VoiceWakeupEvent) ListProtector.get(this.voiceWakeupEvent_, r2);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataOrBuilder
        public VoiceWakeupEventOrBuilder getVoiceWakeupEventOrBuilder(int r2) {
            return (VoiceWakeupEventOrBuilder) ListProtector.get(this.voiceWakeupEvent_, r2);
        }

        /* JADX INFO: renamed from: newBuilderForType, reason: collision with other method in class */
        public Builder m42newBuilderForType(GeneratedMessageV3.BuilderParent r3) {
            return new Builder(r3, null);
        }

        public void writeTo(CodedOutputStream r5) throws IOException {
            int r0 = 0;
            int r1 = 0;
        L4:
            if (r1 >= this.voiceWakeupDuration_.size()) goto L6;
            r5.writeMessage(1, (MessageLite) ListProtector.get(this.voiceWakeupDuration_, r1));
            r1 = r1 + 1;
            goto L4
        L6:
            int r2 = 0;
        L8:
            if (r2 >= this.voiceWakeupEvent_.size()) goto L10;
            r5.writeMessage(2, (MessageLite) ListProtector.get(this.voiceWakeupEvent_, r2));
            r2 = r2 + 1;
            goto L8
        L10:
            int r3 = 0;
        L12:
            if (r3 >= this.breathWakeupDuration_.size()) goto L14;
            r5.writeMessage(3, (MessageLite) ListProtector.get(this.breathWakeupDuration_, r3));
            r3 = r3 + 1;
            goto L12
        L14:
            int r4 = 0;
        L16:
            if (r4 >= this.breathWakeupEvent_.size()) goto L18;
            r5.writeMessage(4, (MessageLite) ListProtector.get(this.breathWakeupEvent_, r4));
            r4 = r4 + 1;
            goto L16
        L18:
            int r6 = 0;
        L20:
            if (r6 >= this.realtimeCallDurations_.size()) goto L23;
            r5.writeMessage(5, (MessageLite) ListProtector.get(this.realtimeCallDurations_, r6));
            r6 = r6 + 1;
        L23:
            if (r0 >= this.realtimeCallEvents_.size()) goto L25;
            r5.writeMessage(6, (MessageLite) ListProtector.get(this.realtimeCallEvents_, r0));
            r0 = r0 + 1;
            goto L23
        L25:
            ((GeneratedMessageV3) this).unknownFields.writeTo(r5);
        }

        public static AssistAudioEventData parseFrom(CodedInputStream r1) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1);
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r1) {
            return m42newBuilderForType(r1);
        }

        public static AssistAudioEventData parseFrom(InputStream r1) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1);
        }

        public static AssistAudioEventData parseFrom(ByteBuffer r1) throws InvalidProtocolBufferException {
            return (AssistAudioEventData) PARSER.parseFrom(r1);
        }

        public static AssistAudioEventData parseFrom(byte[] r1) throws InvalidProtocolBufferException {
            return (AssistAudioEventData) PARSER.parseFrom(r1);
        }

        private AssistAudioEventData(CodedInputStream r12, ExtensionRegistryLite r13) throws InvalidProtocolBufferException {
            this();
            if (r13 == null) goto L99;
            UnknownFieldSet.Builder r0 = UnknownFieldSet.newBuilder();
            boolean r1 = false;
            int r2 = 0;
        L6:
            if (r1 == true) goto L79;
            int r9 = r12.readTag();     // Catch: Throwable -> L50 IOException -> L52 InvalidProtocolBufferException -> L55
            if (r9 == 0) goto L49;
            if (r9 != 10) goto L12;
            if ((r2 & 1) == 1) goto L47;
            this.voiceWakeupDuration_ = new ArrayList();     // Catch: Throwable -> L50 IOException -> L52 InvalidProtocolBufferException -> L55
            r2 = r2 | 1;     // Catch: Throwable -> L50 IOException -> L52 InvalidProtocolBufferException -> L55
        L47:
            this.voiceWakeupDuration_.add((VoiceWakeupDuration) r12.readMessage(VoiceWakeupDuration.PARSER, r13));     // Catch: Throwable -> L50 IOException -> L52 InvalidProtocolBufferException -> L55
            goto L6
        L12:
            if (r9 != 18) goto L14;
            if ((r2 & 2) == 2) goto L43;
            this.voiceWakeupEvent_ = new ArrayList();     // Catch: Throwable -> L50 IOException -> L52 InvalidProtocolBufferException -> L55
            r2 = r2 | 2;     // Catch: Throwable -> L50 IOException -> L52 InvalidProtocolBufferException -> L55
        L43:
            this.voiceWakeupEvent_.add((VoiceWakeupEvent) r12.readMessage(VoiceWakeupEvent.PARSER, r13));     // Catch: Throwable -> L50 IOException -> L52 InvalidProtocolBufferException -> L55
            goto L6
        L14:
            if (r9 != 26) goto L16;
            if ((r2 & 4) == 4) goto L39;
            this.breathWakeupDuration_ = new ArrayList();     // Catch: Throwable -> L50 IOException -> L52 InvalidProtocolBufferException -> L55
            r2 = r2 | 4;     // Catch: Throwable -> L50 IOException -> L52 InvalidProtocolBufferException -> L55
        L39:
            this.breathWakeupDuration_.add((BreathWakeupDuration) r12.readMessage(BreathWakeupDuration.PARSER, r13));     // Catch: Throwable -> L50 IOException -> L52 InvalidProtocolBufferException -> L55
            goto L6
        L16:
            if (r9 != 34) goto L18;
            if ((r2 & 8) == 8) goto L35;
            this.breathWakeupEvent_ = new ArrayList();     // Catch: Throwable -> L50 IOException -> L52 InvalidProtocolBufferException -> L55
            r2 = r2 | 8;     // Catch: Throwable -> L50 IOException -> L52 InvalidProtocolBufferException -> L55
        L35:
            this.breathWakeupEvent_.add((BreathWakeupEvent) r12.readMessage(BreathWakeupEvent.PARSER, r13));     // Catch: Throwable -> L50 IOException -> L52 InvalidProtocolBufferException -> L55
            goto L6
        L18:
            if (r9 != 42) goto L20;
            if ((r2 & 16) == 16) goto L31;
            this.realtimeCallDurations_ = new ArrayList();     // Catch: Throwable -> L50 IOException -> L52 InvalidProtocolBufferException -> L55
            r2 = r2 | 16;     // Catch: Throwable -> L50 IOException -> L52 InvalidProtocolBufferException -> L55
        L31:
            this.realtimeCallDurations_.add((RealtimeCallDuration) r12.readMessage(RealtimeCallDuration.PARSER, r13));     // Catch: Throwable -> L50 IOException -> L52 InvalidProtocolBufferException -> L55
            goto L6
        L20:
            if (r9 != 50) goto L22;
            if ((r2 & 32) == 32) goto L27;
            this.realtimeCallEvents_ = new ArrayList();     // Catch: Throwable -> L50 IOException -> L52 InvalidProtocolBufferException -> L55
            r2 = r2 | 32;     // Catch: Throwable -> L50 IOException -> L52 InvalidProtocolBufferException -> L55
        L27:
            this.realtimeCallEvents_.add((RealtimeCallEvent) r12.readMessage(RealtimeCallEvent.PARSER, r13));     // Catch: Throwable -> L50 IOException -> L52 InvalidProtocolBufferException -> L55
            goto L6
        L22:
            if (parseUnknownField(r12, r0, r13, r9) == true) goto L6;
        L49:
            r1 = true;
            goto L6
        L50:
            th = move-exception;
            if ((r2 & 1) != 1) goto L62;
            this.voiceWakeupDuration_ = Collections.unmodifiableList(this.voiceWakeupDuration_);
        L62:
            if ((r2 & 2) != 2) goto L65;
            this.voiceWakeupEvent_ = Collections.unmodifiableList(this.voiceWakeupEvent_);
        L65:
            if ((r2 & 4) != 4) goto L68;
            this.breathWakeupDuration_ = Collections.unmodifiableList(this.breathWakeupDuration_);
        L68:
            if ((r2 & 8) != 8) goto L71;
            this.breathWakeupEvent_ = Collections.unmodifiableList(this.breathWakeupEvent_);
        L71:
            if ((r2 & 16) != 16) goto L74;
            this.realtimeCallDurations_ = Collections.unmodifiableList(this.realtimeCallDurations_);
        L74:
            if ((r2 & 32) != 32) goto L76;
            this.realtimeCallEvents_ = Collections.unmodifiableList(this.realtimeCallEvents_);
        L76:
            ((GeneratedMessageV3) this).unknownFields = r0.build();
            makeExtensionsImmutable();
            throw th;
        L52:
            e = move-exception;
            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L50
        L55:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L50
        L79:
            if ((r2 & 1) != 1) goto L82;
            this.voiceWakeupDuration_ = Collections.unmodifiableList(this.voiceWakeupDuration_);
        L82:
            if ((r2 & 2) != 2) goto L85;
            this.voiceWakeupEvent_ = Collections.unmodifiableList(this.voiceWakeupEvent_);
        L85:
            if ((r2 & 4) != 4) goto L88;
            this.breathWakeupDuration_ = Collections.unmodifiableList(this.breathWakeupDuration_);
        L88:
            if ((r2 & 8) != 8) goto L91;
            this.breathWakeupEvent_ = Collections.unmodifiableList(this.breathWakeupEvent_);
        L91:
            if ((r2 & 16) != 16) goto L94;
            this.realtimeCallDurations_ = Collections.unmodifiableList(this.realtimeCallDurations_);
        L94:
            if ((r2 & 32) != 32) goto L96;
            this.realtimeCallEvents_ = Collections.unmodifiableList(this.realtimeCallEvents_);
        L96:
            ((GeneratedMessageV3) this).unknownFields = r0.build();
            makeExtensionsImmutable();
            return;
        L99:
            throw null;
        }

        public static /* synthetic */ List access$1002(AssistAudioEventData r0, List r1) {
            r0.realtimeCallDurations_ = r1;
            return r1;
        }

        public static /* synthetic */ List access$1102(AssistAudioEventData r0, List r1) {
            r0.realtimeCallEvents_ = r1;
            return r1;
        }

        public static /* synthetic */ List access$602(AssistAudioEventData r0, List r1) {
            r0.voiceWakeupDuration_ = r1;
            return r1;
        }

        public static /* synthetic */ List access$702(AssistAudioEventData r0, List r1) {
            r0.voiceWakeupEvent_ = r1;
            return r1;
        }

        public static /* synthetic */ List access$802(AssistAudioEventData r0, List r1) {
            r0.breathWakeupDuration_ = r1;
            return r1;
        }

        public static /* synthetic */ List access$902(AssistAudioEventData r0, List r1) {
            r0.breathWakeupEvent_ = r1;
            return r1;
        }

        public static AssistAudioEventData parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r1, r2);
        }

        public static AssistAudioEventData parseFrom(ByteString r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
            return (AssistAudioEventData) PARSER.parseFrom(r1, r2);
        }

        public /* synthetic */ AssistAudioEventData(GeneratedMessageV3.Builder r1, AnonymousClass1 r2) {
            this(r1);
        }

        public static AssistAudioEventData parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1, r2);
        }

        public static AssistAudioEventData parseFrom(InputStream r1, ExtensionRegistryLite r2) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1, r2);
        }

        public static AssistAudioEventData parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
            return (AssistAudioEventData) PARSER.parseFrom(r1, r2);
        }

        public static AssistAudioEventData parseFrom(byte[] r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
            return (AssistAudioEventData) PARSER.parseFrom(r1, r2);
        }

        public /* synthetic */ AssistAudioEventData(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }
    }

    public interface AssistAudioEventDataOrBuilder extends MessageOrBuilder {
        BreathWakeupDuration getBreathWakeupDuration(int r1);

        int getBreathWakeupDurationCount();

        List<BreathWakeupDuration> getBreathWakeupDurationList();

        BreathWakeupDurationOrBuilder getBreathWakeupDurationOrBuilder(int r1);

        List<? extends BreathWakeupDurationOrBuilder> getBreathWakeupDurationOrBuilderList();

        BreathWakeupEvent getBreathWakeupEvent(int r1);

        int getBreathWakeupEventCount();

        List<BreathWakeupEvent> getBreathWakeupEventList();

        BreathWakeupEventOrBuilder getBreathWakeupEventOrBuilder(int r1);

        List<? extends BreathWakeupEventOrBuilder> getBreathWakeupEventOrBuilderList();

        RealtimeCallDuration getRealtimeCallDurations(int r1);

        int getRealtimeCallDurationsCount();

        List<RealtimeCallDuration> getRealtimeCallDurationsList();

        RealtimeCallDurationOrBuilder getRealtimeCallDurationsOrBuilder(int r1);

        List<? extends RealtimeCallDurationOrBuilder> getRealtimeCallDurationsOrBuilderList();

        RealtimeCallEvent getRealtimeCallEvents(int r1);

        int getRealtimeCallEventsCount();

        List<RealtimeCallEvent> getRealtimeCallEventsList();

        RealtimeCallEventOrBuilder getRealtimeCallEventsOrBuilder(int r1);

        List<? extends RealtimeCallEventOrBuilder> getRealtimeCallEventsOrBuilderList();

        VoiceWakeupDuration getVoiceWakeupDuration(int r1);

        int getVoiceWakeupDurationCount();

        List<VoiceWakeupDuration> getVoiceWakeupDurationList();

        VoiceWakeupDurationOrBuilder getVoiceWakeupDurationOrBuilder(int r1);

        List<? extends VoiceWakeupDurationOrBuilder> getVoiceWakeupDurationOrBuilderList();

        VoiceWakeupEvent getVoiceWakeupEvent(int r1);

        int getVoiceWakeupEventCount();

        List<VoiceWakeupEvent> getVoiceWakeupEventList();

        VoiceWakeupEventOrBuilder getVoiceWakeupEventOrBuilder(int r1);

        List<? extends VoiceWakeupEventOrBuilder> getVoiceWakeupEventOrBuilderList();
    }

    public static final class AssistAudioEventDataTraceViewer extends GeneratedMessageV3 implements AssistAudioEventDataTraceViewerOrBuilder {
        private static final AssistAudioEventDataTraceViewer DEFAULT_INSTANCE = null;
        public static final Parser<AssistAudioEventDataTraceViewer> PARSER = null;
        public static final int TRACE_VIEWER_BIZ_TAG_FIELD_NUMBER = 2;
        public static final int TRACE_VIEWER_END_TS_FIELD_NUMBER = 6;
        public static final int TRACE_VIEWER_EVENT_TS_FIELD_NUMBER = 7;
        public static final int TRACE_VIEWER_EXPANSION_KEY_LIST_FIELD_NUMBER = 8;
        public static final int TRACE_VIEWER_START_TS_FIELD_NUMBER = 5;
        public static final int TRACE_VIEWER_TRACK_FIELD_NUMBER = 3;
        public static final int TRACE_VIEWER_TYPE_FIELD_NUMBER = 1;
        public static final int TRACE_VIEWER_VAL_FIELD_NUMBER = 4;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private volatile Object traceViewerBizTag_;
        private long traceViewerEndTs_;
        private long traceViewerEventTs_;
        private LazyStringList traceViewerExpansionKeyList_;
        private long traceViewerStartTs_;
        private volatile Object traceViewerTrack_;
        private volatile Object traceViewerType_;
        private volatile Object traceViewerVal_;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AssistAudioEventDataTraceViewerOrBuilder {
            private int bitField0_;
            private Object traceViewerBizTag_;
            private long traceViewerEndTs_;
            private long traceViewerEventTs_;
            private LazyStringList traceViewerExpansionKeyList_;
            private long traceViewerStartTs_;
            private Object traceViewerTrack_;
            private Object traceViewerType_;
            private Object traceViewerVal_;

            public final boolean isInitialized() {
                return true;
            }

            private void ensureTraceViewerExpansionKeyListIsMutable() {
                if ((this.bitField0_ & LynxTouchEvent.kPseudoStateFocusTransition) == 128) goto L6;
                this.traceViewerExpansionKeyList_ = new LazyStringArrayList(this.traceViewerExpansionKeyList_);
                this.bitField0_ |= LynxTouchEvent.kPseudoStateFocusTransition;
                return;
            }

            /* JADX INFO: renamed from: buildPartial, reason: collision with other method in class */
            public AssistAudioEventDataTraceViewer m98buildPartial() {
                AssistAudioEventDataTraceViewer r0 = new AssistAudioEventDataTraceViewer(this, null);
                int r1 = this.bitField0_;
                int r3 = 1;
                if ((r1 & 1) == 1) goto L6;
                r3 = 0;
            L6:
                AssistAudioEventDataTraceViewer.access$14902(r0, this.traceViewerType_);
                if ((r1 & 2) != 2) goto L9;
                r3 = r3 | 2;
            L9:
                AssistAudioEventDataTraceViewer.access$15002(r0, this.traceViewerBizTag_);
                if ((r1 & 4) != 4) goto L12;
                r3 = r3 | 4;
            L12:
                AssistAudioEventDataTraceViewer.access$15102(r0, this.traceViewerTrack_);
                if ((r1 & 8) != 8) goto L15;
                r3 = r3 | 8;
            L15:
                AssistAudioEventDataTraceViewer.access$15202(r0, this.traceViewerVal_);
                if ((r1 & 16) != 16) goto L18;
                r3 = r3 | 16;
            L18:
                AssistAudioEventDataTraceViewer.access$15302(r0, this.traceViewerStartTs_);
                if ((r1 & 32) != 32) goto L21;
                r3 = r3 | 32;
            L21:
                AssistAudioEventDataTraceViewer.access$15402(r0, this.traceViewerEndTs_);
                if ((r1 & 64) != 64) goto L24;
                r3 = r3 | 64;
            L24:
                AssistAudioEventDataTraceViewer.access$15502(r0, this.traceViewerEventTs_);
                if ((this.bitField0_ & LynxTouchEvent.kPseudoStateFocusTransition) != 128) goto L27;
                this.traceViewerExpansionKeyList_ = this.traceViewerExpansionKeyList_.getUnmodifiableView();
                this.bitField0_ &= -129;
            L27:
                AssistAudioEventDataTraceViewer.access$15602(r0, this.traceViewerExpansionKeyList_);
                AssistAudioEventDataTraceViewer.access$15702(r0, r3);
                onBuilt();
                return r0;
            }

            public Builder clearTraceViewerBizTag() {
                this.bitField0_ &= -3;
                this.traceViewerBizTag_ = AssistAudioEventDataTraceViewer.getDefaultInstance().getTraceViewerBizTag();
                onChanged();
                return this;
            }

            public Builder clearTraceViewerEndTs() {
                this.bitField0_ &= -33;
                this.traceViewerEndTs_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTraceViewerEventTs() {
                this.bitField0_ &= -65;
                this.traceViewerEventTs_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTraceViewerExpansionKeyList() {
                this.traceViewerExpansionKeyList_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -129;
                onChanged();
                return this;
            }

            public Builder clearTraceViewerStartTs() {
                this.bitField0_ &= -17;
                this.traceViewerStartTs_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTraceViewerTrack() {
                this.bitField0_ &= -5;
                this.traceViewerTrack_ = AssistAudioEventDataTraceViewer.getDefaultInstance().getTraceViewerTrack();
                onChanged();
                return this;
            }

            public Builder clearTraceViewerType() {
                this.bitField0_ &= -2;
                this.traceViewerType_ = AssistAudioEventDataTraceViewer.getDefaultInstance().getTraceViewerType();
                onChanged();
                return this;
            }

            public Builder clearTraceViewerVal() {
                this.bitField0_ &= -9;
                this.traceViewerVal_ = AssistAudioEventDataTraceViewer.getDefaultInstance().getTraceViewerVal();
                onChanged();
                return this;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
            public String getTraceViewerBizTag() {
                Object r0 = this.traceViewerBizTag_;
                if ((r0 instanceof String) == true) goto L9;
                ByteString r1 = (ByteString) r0;
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L7;
                this.traceViewerBizTag_ = r2;
            L7:
                return r2;
            L9:
                return (String) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
            public ByteString getTraceViewerBizTagBytes() {
                Object r0 = this.traceViewerBizTag_;
                if ((r0 instanceof String) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) r0);
                this.traceViewerBizTag_ = r1;
                return r1;
            L7:
                return (ByteString) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
            public int getTraceViewerExpansionKeyListCount() {
                return this.traceViewerExpansionKeyList_.size();
            }

            public ProtocolStringList getTraceViewerExpansionKeyListList() {
                return this.traceViewerExpansionKeyList_.getUnmodifiableView();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
            public String getTraceViewerTrack() {
                Object r0 = this.traceViewerTrack_;
                if ((r0 instanceof String) == true) goto L9;
                ByteString r1 = (ByteString) r0;
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L7;
                this.traceViewerTrack_ = r2;
            L7:
                return r2;
            L9:
                return (String) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
            public ByteString getTraceViewerTrackBytes() {
                Object r0 = this.traceViewerTrack_;
                if ((r0 instanceof String) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) r0);
                this.traceViewerTrack_ = r1;
                return r1;
            L7:
                return (ByteString) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
            public String getTraceViewerType() {
                Object r0 = this.traceViewerType_;
                if ((r0 instanceof String) == true) goto L9;
                ByteString r1 = (ByteString) r0;
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L7;
                this.traceViewerType_ = r2;
            L7:
                return r2;
            L9:
                return (String) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
            public ByteString getTraceViewerTypeBytes() {
                Object r0 = this.traceViewerType_;
                if ((r0 instanceof String) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) r0);
                this.traceViewerType_ = r1;
                return r1;
            L7:
                return (ByteString) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
            public String getTraceViewerVal() {
                Object r0 = this.traceViewerVal_;
                if ((r0 instanceof String) == true) goto L9;
                ByteString r1 = (ByteString) r0;
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L7;
                this.traceViewerVal_ = r2;
            L7:
                return r2;
            L9:
                return (String) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
            public ByteString getTraceViewerValBytes() {
                Object r0 = this.traceViewerVal_;
                if ((r0 instanceof String) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) r0);
                this.traceViewerVal_ = r1;
                return r1;
            L7:
                return (ByteString) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
            public boolean hasTraceViewerBizTag() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
            public boolean hasTraceViewerEndTs() {
                if ((this.bitField0_ & 32) != 32) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
            public boolean hasTraceViewerEventTs() {
                if ((this.bitField0_ & 64) != 64) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
            public boolean hasTraceViewerStartTs() {
                if ((this.bitField0_ & 16) != 16) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
            public boolean hasTraceViewerTrack() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
            public boolean hasTraceViewerType() {
                if ((this.bitField0_ & 1) == 1) goto L7;
                return false;
            L7:
                return true;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
            public boolean hasTraceViewerVal() {
                if ((this.bitField0_ & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            private Builder() {
                this.traceViewerType_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceViewerBizTag_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceViewerTrack_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceViewerVal_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceViewerExpansionKeyList_ = LazyStringArrayList.EMPTY;
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AssistAudioEventProto.access$14300();
            }

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public AssistAudioEventDataTraceViewer m96build() {
                AssistAudioEventDataTraceViewer r0 = m98buildPartial();
                if (r0.isInitialized() == false) goto L6;
                return r0;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r0);
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public Builder m102clear() {
                super.clear();
                this.traceViewerType_ = NameKeys.UnloadStrategy_No_Strategy;
                int r1 = this.bitField0_ & (-2);
                this.traceViewerBizTag_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceViewerTrack_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceViewerVal_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceViewerStartTs_ = 0;
                this.traceViewerEndTs_ = 0;
                this.traceViewerEventTs_ = 0;
                int r0 = (((((r1 & (-3)) & (-5)) & (-9)) & (-17)) & (-33)) & (-65);
                this.bitField0_ = r0;
                this.traceViewerExpansionKeyList_ = LazyStringArrayList.EMPTY;
                this.bitField0_ = r0 & (-129);
                return this;
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public Builder m112clone() {
                return (Builder) super.clone();
            }

            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return m115getDefaultInstanceForType();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return AssistAudioEventProto.access$14300();
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AssistAudioEventProto.access$14400().ensureFieldAccessorsInitialized(AssistAudioEventDataTraceViewer.class, Builder.class);
            }

            private void maybeForceBuilderInitialization() {
                AssistAudioEventDataTraceViewer.access$14700();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
            public long getTraceViewerEndTs() {
                return this.traceViewerEndTs_;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
            public long getTraceViewerEventTs() {
                return this.traceViewerEventTs_;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
            public long getTraceViewerStartTs() {
                return this.traceViewerStartTs_;
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m96build();
            }

            public /* bridge */ /* synthetic */ Message buildPartial() {
                return m98buildPartial();
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
                return m102clear();
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
                return m112clone();
            }

            /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite m114getDefaultInstanceForType() {
                return m115getDefaultInstanceForType();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
            /* JADX INFO: renamed from: getTraceViewerExpansionKeyListList */
            public /* bridge */ /* synthetic */ List mo86getTraceViewerExpansionKeyListList() {
                return getTraceViewerExpansionKeyListList();
            }

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite m95build() {
                return m96build();
            }

            /* JADX INFO: renamed from: buildPartial, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite m97buildPartial() {
                return m98buildPartial();
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m99clear() {
                return m102clear();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder m108clone() {
                return m112clone();
            }

            /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
            public AssistAudioEventDataTraceViewer m115getDefaultInstanceForType() {
                return AssistAudioEventDataTraceViewer.getDefaultInstance();
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m100clear() {
                return m102clear();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m109clone() {
                return m112clone();
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite.Builder m101clear() {
                return m102clear();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m110clone() {
                return m112clone();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite.Builder m111clone() {
                return m112clone();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m113clone() throws CloneNotSupportedException {
                return m112clone();
            }

            private Builder(GeneratedMessageV3.BuilderParent r1) {
                super(r1);
                this.traceViewerType_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceViewerBizTag_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceViewerTrack_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceViewerVal_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceViewerExpansionKeyList_ = LazyStringArrayList.EMPTY;
                maybeForceBuilderInitialization();
            }

            public Builder addAllTraceViewerExpansionKeyList(Iterable<String> r2) {
                ensureTraceViewerExpansionKeyListIsMutable();
                AbstractMessageLite.Builder.addAll(r2, this.traceViewerExpansionKeyList_);
                onChanged();
                return this;
            }

            public Builder addTraceViewerExpansionKeyList(String r2) {
                if (r2 == null) goto L6;
                ensureTraceViewerExpansionKeyListIsMutable();
                this.traceViewerExpansionKeyList_.add(r2);
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder addTraceViewerExpansionKeyListBytes(ByteString r2) {
                if (r2 == null) goto L6;
                ensureTraceViewerExpansionKeyListIsMutable();
                this.traceViewerExpansionKeyList_.add(r2);
                onChanged();
                return this;
            L6:
                throw null;
            }

            /* JADX INFO: renamed from: clearField, reason: collision with other method in class */
            public Builder m104clearField(Descriptors.FieldDescriptor r1) {
                return (Builder) super.clearField(r1);
            }

            /* JADX INFO: renamed from: clearOneof, reason: collision with other method in class */
            public Builder m107clearOneof(Descriptors.OneofDescriptor r1) {
                return (Builder) super.clearOneof(r1);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
            public String getTraceViewerExpansionKeyList(int r2) {
                return (String) this.traceViewerExpansionKeyList_.get(r2);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
            public ByteString getTraceViewerExpansionKeyListBytes(int r2) {
                return this.traceViewerExpansionKeyList_.getByteString(r2);
            }

            public Builder mergeFrom(AssistAudioEventDataTraceViewer r3) {
                if (r3 != AssistAudioEventDataTraceViewer.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r3.hasTraceViewerType() == false) goto L9;
                this.bitField0_ |= 1;
                this.traceViewerType_ = AssistAudioEventDataTraceViewer.access$14900(r3);
                onChanged();
            L9:
                if (r3.hasTraceViewerBizTag() == false) goto L12;
                this.bitField0_ |= 2;
                this.traceViewerBizTag_ = AssistAudioEventDataTraceViewer.access$15000(r3);
                onChanged();
            L12:
                if (r3.hasTraceViewerTrack() == false) goto L15;
                this.bitField0_ |= 4;
                this.traceViewerTrack_ = AssistAudioEventDataTraceViewer.access$15100(r3);
                onChanged();
            L15:
                if (r3.hasTraceViewerVal() == false) goto L18;
                this.bitField0_ |= 8;
                this.traceViewerVal_ = AssistAudioEventDataTraceViewer.access$15200(r3);
                onChanged();
            L18:
                if (r3.hasTraceViewerStartTs() == false) goto L21;
                setTraceViewerStartTs(r3.getTraceViewerStartTs());
            L21:
                if (r3.hasTraceViewerEndTs() == false) goto L24;
                setTraceViewerEndTs(r3.getTraceViewerEndTs());
            L24:
                if (r3.hasTraceViewerEventTs() == false) goto L27;
                setTraceViewerEventTs(r3.getTraceViewerEventTs());
            L27:
                if (AssistAudioEventDataTraceViewer.access$15600(r3).isEmpty() == false) goto L29;
            L33:
                m124mergeUnknownFields(AssistAudioEventDataTraceViewer.access$15800(r3));
                onChanged();
                return this;
            L29:
                if (this.traceViewerExpansionKeyList_.isEmpty() == false) goto L31;
                this.traceViewerExpansionKeyList_ = AssistAudioEventDataTraceViewer.access$15600(r3);
                this.bitField0_ &= -129;
            L32:
                onChanged();
                goto L33
            L31:
                ensureTraceViewerExpansionKeyListIsMutable();
                this.traceViewerExpansionKeyList_.addAll(AssistAudioEventDataTraceViewer.access$15600(r3));
                goto L32
            }

            /* JADX INFO: renamed from: mergeUnknownFields, reason: collision with other method in class */
            public final Builder m124mergeUnknownFields(UnknownFieldSet r1) {
                return (Builder) super.mergeUnknownFields(r1);
            }

            public Builder setTraceViewerBizTag(String r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 2;
                this.traceViewerBizTag_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setTraceViewerBizTagBytes(ByteString r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 2;
                this.traceViewerBizTag_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setTraceViewerEndTs(long r2) {
                this.bitField0_ |= 32;
                this.traceViewerEndTs_ = r2;
                onChanged();
                return this;
            }

            public Builder setTraceViewerEventTs(long r2) {
                this.bitField0_ |= 64;
                this.traceViewerEventTs_ = r2;
                onChanged();
                return this;
            }

            public Builder setTraceViewerStartTs(long r2) {
                this.bitField0_ |= 16;
                this.traceViewerStartTs_ = r2;
                onChanged();
                return this;
            }

            public Builder setTraceViewerTrack(String r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 4;
                this.traceViewerTrack_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setTraceViewerTrackBytes(ByteString r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 4;
                this.traceViewerTrack_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setTraceViewerType(String r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 1;
                this.traceViewerType_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setTraceViewerTypeBytes(ByteString r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 1;
                this.traceViewerType_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setTraceViewerVal(String r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 8;
                this.traceViewerVal_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setTraceViewerValBytes(ByteString r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 8;
                this.traceViewerVal_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            /* JADX INFO: renamed from: setUnknownFields, reason: collision with other method in class */
            public final Builder m130setUnknownFields(UnknownFieldSet r1) {
                return (Builder) super.setUnknownFields(r1);
            }

            public /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearField(Descriptors.FieldDescriptor r1) {
                return m104clearField(r1);
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r1) {
                return m107clearOneof(r1);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public Builder m121mergeFrom(Message r2) {
                if ((r2 instanceof AssistAudioEventDataTraceViewer) == true) goto L5;
                super/*com.google.protobuf.AbstractMessage.Builder*/.mergeFrom(r2);
                return this;
            L5:
                return mergeFrom((AssistAudioEventDataTraceViewer) r2);
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r1) {
                return m124mergeUnknownFields(r1);
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r1) {
                return m130setUnknownFields(r1);
            }

            /* JADX INFO: renamed from: clearField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m103clearField(Descriptors.FieldDescriptor r1) {
                return m104clearField(r1);
            }

            /* JADX INFO: renamed from: clearOneof, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m105clearOneof(Descriptors.OneofDescriptor r1) {
                return m107clearOneof(r1);
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r1) {
                return m121mergeFrom(r1);
            }

            /* JADX INFO: renamed from: mergeUnknownFields, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m122mergeUnknownFields(UnknownFieldSet r1) {
                return m124mergeUnknownFields(r1);
            }

            /* JADX INFO: renamed from: setUnknownFields, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m129setUnknownFields(UnknownFieldSet r1) {
                return m130setUnknownFields(r1);
            }

            /* JADX INFO: renamed from: clearOneof, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m106clearOneof(Descriptors.OneofDescriptor r1) {
                return m107clearOneof(r1);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m118mergeFrom(Message r1) {
                return m121mergeFrom(r1);
            }

            /* JADX INFO: renamed from: mergeUnknownFields, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m123mergeUnknownFields(UnknownFieldSet r1) {
                return m124mergeUnknownFields(r1);
            }

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r1, AnonymousClass1 r2) {
                this(r1);
            }

            /* JADX INFO: renamed from: addRepeatedField, reason: collision with other method in class */
            public Builder m94addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
                return (Builder) super.addRepeatedField(r1, r2);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public Builder m120mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                AssistAudioEventDataTraceViewer r0 = null;
                AssistAudioEventDataTraceViewer r5 = (AssistAudioEventDataTraceViewer) AssistAudioEventDataTraceViewer.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                AssistAudioEventDataTraceViewer r6 = (AssistAudioEventDataTraceViewer) e.getUnfinishedMessage();     // Catch: Throwable -> L7
            L13:
                th = th;
                r0 = r6;
            L15:
                if (r0 == null) goto L17;
                mergeFrom(r0);
            L17:
                throw th;
            L12:
                throw e.unwrapIOException();     // Catch: Throwable -> L13
            L7:
                th = th;
                goto L15
            }

            /* JADX INFO: renamed from: setField, reason: collision with other method in class */
            public Builder m126setField(Descriptors.FieldDescriptor r1, Object r2) {
                return (Builder) super.setField(r1, r2);
            }

            public Builder setTraceViewerExpansionKeyList(int r2, String r3) {
                if (r3 == null) goto L6;
                ensureTraceViewerExpansionKeyListIsMutable();
                this.traceViewerExpansionKeyList_.set(r2, r3);
                onChanged();
                return this;
            L6:
                throw null;
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
                return m94addRepeatedField(r1, r2);
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m120mergeFrom(r1, r2);
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setField(Descriptors.FieldDescriptor r1, Object r2) {
                return m126setField(r1, r2);
            }

            /* JADX INFO: renamed from: addRepeatedField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m93addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
                return m94addRepeatedField(r1, r2);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder m116mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m120mergeFrom(r1, r2);
            }

            /* JADX INFO: renamed from: setField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m125setField(Descriptors.FieldDescriptor r1, Object r2) {
                return m126setField(r1, r2);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m117mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m120mergeFrom(r1, r2);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite.Builder m119mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m120mergeFrom(r1, r2);
            }

            /* JADX INFO: renamed from: setRepeatedField, reason: collision with other method in class */
            public Builder m128setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
                return (Builder) super.setRepeatedField(r1, r2, r3);
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
                return m128setRepeatedField(r1, r2, r3);
            }

            /* JADX INFO: renamed from: setRepeatedField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m127setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
                return m128setRepeatedField(r1, r2, r3);
            }
        }

        static {
            DEFAULT_INSTANCE = new AssistAudioEventDataTraceViewer();
            PARSER = new AnonymousClass1();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m91toBuilder();
        }

        public int getSerializedSize() {
            int r0 = ((AbstractMessage) this).memoizedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r2 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r1 = GeneratedMessageV3.computeStringSize(1, this.traceViewerType_) + 0;
        L10:
            if ((this.bitField0_ & 2) != 2) goto L13;
            r1 = r1 + GeneratedMessageV3.computeStringSize(2, this.traceViewerBizTag_);
        L13:
            if ((this.bitField0_ & 4) != 4) goto L16;
            r1 = r1 + GeneratedMessageV3.computeStringSize(3, this.traceViewerTrack_);
        L16:
            if ((this.bitField0_ & 8) != 8) goto L19;
            r1 = r1 + GeneratedMessageV3.computeStringSize(4, this.traceViewerVal_);
        L19:
            if ((this.bitField0_ & 16) != 16) goto L22;
            r1 = r1 + CodedOutputStream.computeInt64Size(5, this.traceViewerStartTs_);
        L22:
            if ((this.bitField0_ & 32) != 32) goto L25;
            r1 = r1 + CodedOutputStream.computeInt64Size(6, this.traceViewerEndTs_);
        L25:
            if ((this.bitField0_ & 64) != 64) goto L27;
            r1 = r1 + CodedOutputStream.computeInt64Size(7, this.traceViewerEventTs_);
        L27:
            int r3 = 0;
        L29:
            if (r2 >= this.traceViewerExpansionKeyList_.size()) goto L31;
            r3 = r3 + GeneratedMessageV3.computeStringSizeNoTag(this.traceViewerExpansionKeyList_.getRaw(r2));
            r2 = r2 + 1;
            goto L29
        L31:
            int r4 = ((r1 + r3) + (getTraceViewerExpansionKeyListList().size() * 1)) + ((GeneratedMessageV3) this).unknownFields.getSerializedSize();
            ((AbstractMessage) this).memoizedSize = r4;
            return r4;
        L8:
            r1 = 0;
            goto L10
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
        public String getTraceViewerBizTag() {
            Object r0 = this.traceViewerBizTag_;
            if ((r0 instanceof String) == true) goto L5;
            ByteString r1 = (ByteString) r0;
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L9;
            this.traceViewerBizTag_ = r2;
        L9:
            return r2;
        L5:
            return (String) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
        public ByteString getTraceViewerBizTagBytes() {
            Object r0 = this.traceViewerBizTag_;
            if ((r0 instanceof String) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) r0);
            this.traceViewerBizTag_ = r1;
            return r1;
        L7:
            return (ByteString) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
        public int getTraceViewerExpansionKeyListCount() {
            return this.traceViewerExpansionKeyList_.size();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
        public String getTraceViewerTrack() {
            Object r0 = this.traceViewerTrack_;
            if ((r0 instanceof String) == true) goto L5;
            ByteString r1 = (ByteString) r0;
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L9;
            this.traceViewerTrack_ = r2;
        L9:
            return r2;
        L5:
            return (String) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
        public ByteString getTraceViewerTrackBytes() {
            Object r0 = this.traceViewerTrack_;
            if ((r0 instanceof String) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) r0);
            this.traceViewerTrack_ = r1;
            return r1;
        L7:
            return (ByteString) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
        public String getTraceViewerType() {
            Object r0 = this.traceViewerType_;
            if ((r0 instanceof String) == true) goto L5;
            ByteString r1 = (ByteString) r0;
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L9;
            this.traceViewerType_ = r2;
        L9:
            return r2;
        L5:
            return (String) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
        public ByteString getTraceViewerTypeBytes() {
            Object r0 = this.traceViewerType_;
            if ((r0 instanceof String) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) r0);
            this.traceViewerType_ = r1;
            return r1;
        L7:
            return (ByteString) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
        public String getTraceViewerVal() {
            Object r0 = this.traceViewerVal_;
            if ((r0 instanceof String) == true) goto L5;
            ByteString r1 = (ByteString) r0;
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L9;
            this.traceViewerVal_ = r2;
        L9:
            return r2;
        L5:
            return (String) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
        public ByteString getTraceViewerValBytes() {
            Object r0 = this.traceViewerVal_;
            if ((r0 instanceof String) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) r0);
            this.traceViewerVal_ = r1;
            return r1;
        L7:
            return (ByteString) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
        public boolean hasTraceViewerBizTag() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
        public boolean hasTraceViewerEndTs() {
            if ((this.bitField0_ & 32) != 32) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
        public boolean hasTraceViewerEventTs() {
            if ((this.bitField0_ & 64) != 64) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
        public boolean hasTraceViewerStartTs() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
        public boolean hasTraceViewerTrack() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
        public boolean hasTraceViewerType() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
        public boolean hasTraceViewerVal() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public int hashCode() {
            int r0 = ((AbstractMessageLite) this).memoizedHashCode;
            if (r0 == 0) goto L5;
            return r0;
        L5:
            int r1 = 779 + getDescriptor().hashCode();
            if (hasTraceViewerType() == false) goto L9;
            r1 = (((r1 * 37) + 1) * 53) + getTraceViewerType().hashCode();
        L9:
            if (hasTraceViewerBizTag() == false) goto L12;
            r1 = (((r1 * 37) + 2) * 53) + getTraceViewerBizTag().hashCode();
        L12:
            if (hasTraceViewerTrack() == false) goto L15;
            r1 = (((r1 * 37) + 3) * 53) + getTraceViewerTrack().hashCode();
        L15:
            if (hasTraceViewerVal() == false) goto L18;
            r1 = (((r1 * 37) + 4) * 53) + getTraceViewerVal().hashCode();
        L18:
            if (hasTraceViewerStartTs() == false) goto L21;
            r1 = (((r1 * 37) + 5) * 53) + Internal.hashLong(getTraceViewerStartTs());
        L21:
            if (hasTraceViewerEndTs() == false) goto L24;
            r1 = (((r1 * 37) + 6) * 53) + Internal.hashLong(getTraceViewerEndTs());
        L24:
            if (hasTraceViewerEventTs() == false) goto L27;
            r1 = (((r1 * 37) + 7) * 53) + Internal.hashLong(getTraceViewerEventTs());
        L27:
            if (getTraceViewerExpansionKeyListCount() <= 0) goto L29;
            r1 = (((r1 * 37) + 8) * 53) + getTraceViewerExpansionKeyListList().hashCode();
        L29:
            int r2 = (r1 * 29) + ((GeneratedMessageV3) this).unknownFields.hashCode();
            ((AbstractMessageLite) this).memoizedHashCode = r2;
            return r2;
        }

        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L5;
            return true;
        L5:
            if (r0 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        /* JADX INFO: renamed from: toBuilder, reason: collision with other method in class */
        public Builder m91toBuilder() {
            AnonymousClass1 r1 = null;
            if (this != DEFAULT_INSTANCE) goto L6;
            return new Builder(r1);
        L6:
            return new Builder(r1).mergeFrom(this);
        }

        private AssistAudioEventDataTraceViewer() {
            this.memoizedIsInitialized = -1;
            this.traceViewerType_ = NameKeys.UnloadStrategy_No_Strategy;
            this.traceViewerBizTag_ = NameKeys.UnloadStrategy_No_Strategy;
            this.traceViewerTrack_ = NameKeys.UnloadStrategy_No_Strategy;
            this.traceViewerVal_ = NameKeys.UnloadStrategy_No_Strategy;
            this.traceViewerStartTs_ = 0;
            this.traceViewerEndTs_ = 0;
            this.traceViewerEventTs_ = 0;
            this.traceViewerExpansionKeyList_ = LazyStringArrayList.EMPTY;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AssistAudioEventProto.access$14300();
        }

        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return m85getDefaultInstanceForType();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
        /* JADX INFO: renamed from: getTraceViewerExpansionKeyListList, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ List mo86getTraceViewerExpansionKeyListList() {
            return getTraceViewerExpansionKeyListList();
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AssistAudioEventProto.access$14400().ensureFieldAccessorsInitialized(AssistAudioEventDataTraceViewer.class, Builder.class);
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return m88newBuilderForType();
        }

        public static /* synthetic */ boolean access$14700() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static AssistAudioEventDataTraceViewer getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AssistAudioEventDataTraceViewer> parser() {
            return PARSER;
        }

        public Parser<AssistAudioEventDataTraceViewer> getParserForType() {
            return PARSER;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
        public long getTraceViewerEndTs() {
            return this.traceViewerEndTs_;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
        public long getTraceViewerEventTs() {
            return this.traceViewerEventTs_;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
        public long getTraceViewerStartTs() {
            return this.traceViewerStartTs_;
        }

        public final UnknownFieldSet getUnknownFields() {
            return ((GeneratedMessageV3) this).unknownFields;
        }

        /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite m84getDefaultInstanceForType() {
            return m85getDefaultInstanceForType();
        }

        public ProtocolStringList getTraceViewerExpansionKeyListList() {
            return this.traceViewerExpansionKeyList_;
        }

        /* JADX INFO: renamed from: newBuilderForType, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite.Builder m87newBuilderForType() {
            return m88newBuilderForType();
        }

        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return m91toBuilder();
        }

        /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
        public AssistAudioEventDataTraceViewer m85getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: renamed from: newBuilderForType, reason: collision with other method in class */
        public Builder m88newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: renamed from: toBuilder, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite.Builder m90toBuilder() {
            return m91toBuilder();
        }

        private AssistAudioEventDataTraceViewer(GeneratedMessageV3.Builder<?> r1) {
            super(r1);
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ Object access$14900(AssistAudioEventDataTraceViewer r0) {
            return r0.traceViewerType_;
        }

        public static /* synthetic */ Object access$15000(AssistAudioEventDataTraceViewer r0) {
            return r0.traceViewerBizTag_;
        }

        public static /* synthetic */ Object access$15100(AssistAudioEventDataTraceViewer r0) {
            return r0.traceViewerTrack_;
        }

        public static /* synthetic */ Object access$15200(AssistAudioEventDataTraceViewer r0) {
            return r0.traceViewerVal_;
        }

        public static /* synthetic */ LazyStringList access$15600(AssistAudioEventDataTraceViewer r0) {
            return r0.traceViewerExpansionKeyList_;
        }

        public static /* synthetic */ UnknownFieldSet access$15800(AssistAudioEventDataTraceViewer r0) {
            return ((GeneratedMessageV3) r0).unknownFields;
        }

        public static Builder newBuilder(AssistAudioEventDataTraceViewer r1) {
            return DEFAULT_INSTANCE.m91toBuilder().mergeFrom(r1);
        }

        public static AssistAudioEventDataTraceViewer parseDelimitedFrom(InputStream r1) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r1);
        }

        public static AssistAudioEventDataTraceViewer parseFrom(ByteString r1) throws InvalidProtocolBufferException {
            return (AssistAudioEventDataTraceViewer) PARSER.parseFrom(r1);
        }

        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof AssistAudioEventDataTraceViewer) == false) goto L8;
            AssistAudioEventDataTraceViewer r9 = (AssistAudioEventDataTraceViewer) r8;
            if (hasTraceViewerType() != r9.hasTraceViewerType()) goto L12;
            boolean r1 = true;
        L14:
            if (hasTraceViewerType() == false) goto L20;
            if (r1 == true) goto L17;
        L19:
            r1 = false;
            goto L20
        L17:
            if (getTraceViewerType().equals(r9.getTraceViewerType()) == false) goto L19;
            r1 = true;
        L20:
            if (r1 == true) goto L22;
        L24:
            boolean r2 = false;
        L26:
            if (hasTraceViewerBizTag() == false) goto L32;
            if (r2 == true) goto L29;
        L31:
            r2 = false;
            goto L32
        L29:
            if (getTraceViewerBizTag().equals(r9.getTraceViewerBizTag()) == false) goto L31;
            r2 = true;
        L32:
            if (r2 == true) goto L34;
        L36:
            boolean r3 = false;
        L38:
            if (hasTraceViewerTrack() == false) goto L44;
            if (r3 == true) goto L41;
        L43:
            r3 = false;
            goto L44
        L41:
            if (getTraceViewerTrack().equals(r9.getTraceViewerTrack()) == false) goto L43;
            r3 = true;
        L44:
            if (r3 == true) goto L46;
        L48:
            boolean r4 = false;
        L50:
            if (hasTraceViewerVal() == false) goto L56;
            if (r4 == true) goto L53;
        L55:
            r4 = false;
            goto L56
        L53:
            if (getTraceViewerVal().equals(r9.getTraceViewerVal()) == false) goto L55;
            r4 = true;
        L56:
            if (r4 == true) goto L58;
        L60:
            boolean r5 = false;
        L62:
            if (hasTraceViewerStartTs() == false) goto L68;
            if (r5 == true) goto L65;
        L67:
            r5 = false;
            goto L68
        L65:
            if (getTraceViewerStartTs() != r9.getTraceViewerStartTs()) goto L67;
            r5 = true;
        L68:
            if (r5 == true) goto L70;
        L72:
            boolean r6 = false;
        L74:
            if (hasTraceViewerEndTs() == false) goto L80;
            if (r6 == true) goto L77;
        L79:
            r6 = false;
            goto L80
        L77:
            if (getTraceViewerEndTs() != r9.getTraceViewerEndTs()) goto L79;
            r6 = true;
        L80:
            if (r6 == true) goto L82;
        L84:
            boolean r7 = false;
        L86:
            if (hasTraceViewerEventTs() == false) goto L92;
            if (r7 == true) goto L89;
        L91:
            r7 = false;
            goto L92
        L89:
            if (getTraceViewerEventTs() != r9.getTraceViewerEventTs()) goto L91;
            r7 = true;
        L92:
            if (r7 == true) goto L94;
        L96:
            boolean r10 = false;
        L97:
            if (r10 == true) goto L99;
        L101:
            return false;
        L99:
            if (((GeneratedMessageV3) this).unknownFields.equals(((GeneratedMessageV3) r9).unknownFields) == false) goto L101;
            return true;
        L94:
            if (getTraceViewerExpansionKeyListList().equals(r9.getTraceViewerExpansionKeyListList()) == false) goto L96;
            r10 = true;
            goto L97
        L82:
            if (hasTraceViewerEventTs() != r9.hasTraceViewerEventTs()) goto L84;
            r7 = true;
            goto L86
        L70:
            if (hasTraceViewerEndTs() != r9.hasTraceViewerEndTs()) goto L72;
            r6 = true;
            goto L74
        L58:
            if (hasTraceViewerStartTs() != r9.hasTraceViewerStartTs()) goto L60;
            r5 = true;
            goto L62
        L46:
            if (hasTraceViewerVal() != r9.hasTraceViewerVal()) goto L48;
            r4 = true;
            goto L50
        L34:
            if (hasTraceViewerTrack() != r9.hasTraceViewerTrack()) goto L36;
            r3 = true;
            goto L38
        L22:
            if (hasTraceViewerBizTag() != r9.hasTraceViewerBizTag()) goto L24;
            r2 = true;
            goto L26
        L12:
            r1 = false;
            goto L14
        L8:
            return super/*com.google.protobuf.AbstractMessage*/.equals(r8);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
        public String getTraceViewerExpansionKeyList(int r2) {
            return (String) this.traceViewerExpansionKeyList_.get(r2);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.AssistAudioEventDataTraceViewerOrBuilder
        public ByteString getTraceViewerExpansionKeyListBytes(int r2) {
            return this.traceViewerExpansionKeyList_.getByteString(r2);
        }

        /* JADX INFO: renamed from: newBuilderForType, reason: collision with other method in class */
        public Builder m89newBuilderForType(GeneratedMessageV3.BuilderParent r3) {
            return new Builder(r3, null);
        }

        public void writeTo(CodedOutputStream r6) throws IOException {
            if ((this.bitField0_ & 1) != 1) goto L6;
            GeneratedMessageV3.writeString(r6, 1, this.traceViewerType_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            GeneratedMessageV3.writeString(r6, 2, this.traceViewerBizTag_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L12;
            GeneratedMessageV3.writeString(r6, 3, this.traceViewerTrack_);
        L12:
            if ((this.bitField0_ & 8) != 8) goto L15;
            GeneratedMessageV3.writeString(r6, 4, this.traceViewerVal_);
        L15:
            if ((this.bitField0_ & 16) != 16) goto L18;
            r6.writeInt64(5, this.traceViewerStartTs_);
        L18:
            if ((this.bitField0_ & 32) != 32) goto L21;
            r6.writeInt64(6, this.traceViewerEndTs_);
        L21:
            if ((this.bitField0_ & 64) != 64) goto L23;
            r6.writeInt64(7, this.traceViewerEventTs_);
        L23:
            int r0 = 0;
        L25:
            if (r0 >= this.traceViewerExpansionKeyList_.size()) goto L27;
            GeneratedMessageV3.writeString(r6, 8, this.traceViewerExpansionKeyList_.getRaw(r0));
            r0 = r0 + 1;
            goto L25
        L27:
            ((GeneratedMessageV3) this).unknownFields.writeTo(r6);
        }

        public static AssistAudioEventDataTraceViewer parseFrom(CodedInputStream r1) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1);
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r1) {
            return m89newBuilderForType(r1);
        }

        public static AssistAudioEventDataTraceViewer parseFrom(InputStream r1) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1);
        }

        public static AssistAudioEventDataTraceViewer parseFrom(ByteBuffer r1) throws InvalidProtocolBufferException {
            return (AssistAudioEventDataTraceViewer) PARSER.parseFrom(r1);
        }

        public static AssistAudioEventDataTraceViewer parseFrom(byte[] r1) throws InvalidProtocolBufferException {
            return (AssistAudioEventDataTraceViewer) PARSER.parseFrom(r1);
        }

        private AssistAudioEventDataTraceViewer(CodedInputStream r8, ExtensionRegistryLite r9) throws InvalidProtocolBufferException {
            this();
            if (r9 == null) goto L60;
            UnknownFieldSet.Builder r0 = UnknownFieldSet.newBuilder();
            boolean r1 = false;
            int r2 = 0;
        L6:
            if (r1 == true) goto L55;
            int r4 = r8.readTag();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            if (r4 == 0) goto L40;
            if (r4 != 10) goto L12;
            ByteString r5 = r8.readBytes();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.bitField0_ = 1 | this.bitField0_;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.traceViewerType_ = r5;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L6
        L12:
            if (r4 != 18) goto L14;
            ByteString r6 = r8.readBytes();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.bitField0_ |= 2;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.traceViewerBizTag_ = r6;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L6
        L14:
            if (r4 != 26) goto L16;
            ByteString r7 = r8.readBytes();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.bitField0_ |= 4;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.traceViewerTrack_ = r7;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L6
        L16:
            if (r4 != 34) goto L18;
            ByteString r10 = r8.readBytes();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.bitField0_ |= 8;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.traceViewerVal_ = r10;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L6
        L18:
            if (r4 != 40) goto L20;
            this.bitField0_ |= 16;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.traceViewerStartTs_ = r8.readInt64();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L6
        L20:
            if (r4 != 48) goto L22;
            this.bitField0_ |= 32;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.traceViewerEndTs_ = r8.readInt64();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L6
        L22:
            if (r4 != 56) goto L24;
            this.bitField0_ |= 64;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.traceViewerEventTs_ = r8.readInt64();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L6
        L24:
            if (r4 != 66) goto L26;
            ByteString r11 = r8.readBytes();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            if ((r2 & LynxTouchEvent.kPseudoStateFocusTransition) == 128) goto L31;
            this.traceViewerExpansionKeyList_ = new LazyStringArrayList();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            r2 = r2 | LynxTouchEvent.kPseudoStateFocusTransition;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        L31:
            this.traceViewerExpansionKeyList_.add(r11);     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L6
        L26:
            if (parseUnknownField(r8, r0, r9, r4) == true) goto L6;
        L40:
            r1 = true;
            goto L6
        L41:
            th = move-exception;
            if ((r2 & LynxTouchEvent.kPseudoStateFocusTransition) != 128) goto L52;
            this.traceViewerExpansionKeyList_ = this.traceViewerExpansionKeyList_.getUnmodifiableView();
        L52:
            ((GeneratedMessageV3) this).unknownFields = r0.build();
            makeExtensionsImmutable();
            throw th;
        L43:
            e = move-exception;
            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L41
        L46:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L41
        L55:
            if ((r2 & LynxTouchEvent.kPseudoStateFocusTransition) != 128) goto L57;
            this.traceViewerExpansionKeyList_ = this.traceViewerExpansionKeyList_.getUnmodifiableView();
        L57:
            ((GeneratedMessageV3) this).unknownFields = r0.build();
            makeExtensionsImmutable();
            return;
        L60:
            throw null;
        }

        public static /* synthetic */ Object access$14902(AssistAudioEventDataTraceViewer r0, Object r1) {
            r0.traceViewerType_ = r1;
            return r1;
        }

        public static /* synthetic */ Object access$15002(AssistAudioEventDataTraceViewer r0, Object r1) {
            r0.traceViewerBizTag_ = r1;
            return r1;
        }

        public static /* synthetic */ Object access$15102(AssistAudioEventDataTraceViewer r0, Object r1) {
            r0.traceViewerTrack_ = r1;
            return r1;
        }

        public static /* synthetic */ Object access$15202(AssistAudioEventDataTraceViewer r0, Object r1) {
            r0.traceViewerVal_ = r1;
            return r1;
        }

        public static /* synthetic */ long access$15302(AssistAudioEventDataTraceViewer r0, long r1) {
            r0.traceViewerStartTs_ = r1;
            return r1;
        }

        public static /* synthetic */ long access$15402(AssistAudioEventDataTraceViewer r0, long r1) {
            r0.traceViewerEndTs_ = r1;
            return r1;
        }

        public static /* synthetic */ long access$15502(AssistAudioEventDataTraceViewer r0, long r1) {
            r0.traceViewerEventTs_ = r1;
            return r1;
        }

        public static /* synthetic */ LazyStringList access$15602(AssistAudioEventDataTraceViewer r0, LazyStringList r1) {
            r0.traceViewerExpansionKeyList_ = r1;
            return r1;
        }

        public static /* synthetic */ int access$15702(AssistAudioEventDataTraceViewer r0, int r1) {
            r0.bitField0_ = r1;
            return r1;
        }

        public static AssistAudioEventDataTraceViewer parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r1, r2);
        }

        public static AssistAudioEventDataTraceViewer parseFrom(ByteString r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
            return (AssistAudioEventDataTraceViewer) PARSER.parseFrom(r1, r2);
        }

        public /* synthetic */ AssistAudioEventDataTraceViewer(GeneratedMessageV3.Builder r1, AnonymousClass1 r2) {
            this(r1);
        }

        public static AssistAudioEventDataTraceViewer parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1, r2);
        }

        public static AssistAudioEventDataTraceViewer parseFrom(InputStream r1, ExtensionRegistryLite r2) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1, r2);
        }

        public static AssistAudioEventDataTraceViewer parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
            return (AssistAudioEventDataTraceViewer) PARSER.parseFrom(r1, r2);
        }

        public static AssistAudioEventDataTraceViewer parseFrom(byte[] r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
            return (AssistAudioEventDataTraceViewer) PARSER.parseFrom(r1, r2);
        }

        public /* synthetic */ AssistAudioEventDataTraceViewer(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }
    }

    public interface AssistAudioEventDataTraceViewerOrBuilder extends MessageOrBuilder {
        String getTraceViewerBizTag();

        ByteString getTraceViewerBizTagBytes();

        long getTraceViewerEndTs();

        long getTraceViewerEventTs();

        String getTraceViewerExpansionKeyList(int r1);

        ByteString getTraceViewerExpansionKeyListBytes(int r1);

        int getTraceViewerExpansionKeyListCount();

        /* JADX INFO: renamed from: getTraceViewerExpansionKeyListList */
        List<String> mo86getTraceViewerExpansionKeyListList();

        long getTraceViewerStartTs();

        String getTraceViewerTrack();

        ByteString getTraceViewerTrackBytes();

        String getTraceViewerType();

        ByteString getTraceViewerTypeBytes();

        String getTraceViewerVal();

        ByteString getTraceViewerValBytes();

        boolean hasTraceViewerBizTag();

        boolean hasTraceViewerEndTs();

        boolean hasTraceViewerEventTs();

        boolean hasTraceViewerStartTs();

        boolean hasTraceViewerTrack();

        boolean hasTraceViewerType();

        boolean hasTraceViewerVal();
    }

    public static final class BreathWakeupDuration extends GeneratedMessageV3 implements BreathWakeupDurationOrBuilder {
        private static final BreathWakeupDuration DEFAULT_INSTANCE = null;
        public static final int END_TIMESTAMP_FIELD_NUMBER = 5;
        public static final int EVENT_NAME_FIELD_NUMBER = 1;
        public static final int EVENT_REPORT_SOURCE_FIELD_NUMBER = 2;
        public static final int EXTRA_FIELD_NUMBER = 9;
        public static final Parser<BreathWakeupDuration> PARSER = null;
        public static final int START_TIMESTAMP_FIELD_NUMBER = 4;
        public static final int TRACE_ID_FIELD_NUMBER = 3;
        public static final int TRACE_VIEWERS_FIELD_NUMBER = 10;
        public static final int WAKEUP_STAGE1_DURATION_FIELD_NUMBER = 6;
        public static final int WAKEUP_STAGE2_DURATION_FIELD_NUMBER = 7;
        public static final int WAKEUP_STAGE3_DURATION_FIELD_NUMBER = 8;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private long endTimestamp_;
        private volatile Object eventName_;
        private volatile Object eventReportSource_;
        private MapField<String, String> extra_;
        private byte memoizedIsInitialized;
        private long startTimestamp_;
        private volatile Object traceId_;
        private List<AssistAudioEventDataTraceViewer> traceViewers_;
        private long wakeupStage1Duration_;
        private long wakeupStage2Duration_;
        private long wakeupStage3Duration_;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BreathWakeupDurationOrBuilder {
            private int bitField0_;
            private long endTimestamp_;
            private Object eventName_;
            private Object eventReportSource_;
            private MapField<String, String> extra_;
            private long startTimestamp_;
            private Object traceId_;
            private RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> traceViewersBuilder_;
            private List<AssistAudioEventDataTraceViewer> traceViewers_;
            private long wakeupStage1Duration_;
            private long wakeupStage2Duration_;
            private long wakeupStage3Duration_;

            public final boolean isInitialized() {
                return true;
            }

            private void ensureTraceViewersIsMutable() {
                if ((this.bitField0_ & 512) == 512) goto L6;
                this.traceViewers_ = new ArrayList(this.traceViewers_);
                this.bitField0_ |= 512;
                return;
            }

            private RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> getTraceViewersFieldBuilder() {
                if (this.traceViewersBuilder_ != null) goto L10;
                List<AssistAudioEventDataTraceViewer> r1 = this.traceViewers_;
                if ((this.bitField0_ & 512) != 512) goto L7;
                boolean r2 = true;
            L8:
                this.traceViewersBuilder_ = new RepeatedFieldBuilderV3(r1, r2, getParentForChildren(), isClean());
                this.traceViewers_ = null;
                goto L10
            L7:
                r2 = false;
            L10:
                return this.traceViewersBuilder_;
            }

            private MapField<String, String> internalGetExtra() {
                MapField<String, String> r0 = this.extra_;
                if (r0 == null) goto L5;
                return r0;
            L5:
                return MapField.emptyMapField(ExtraDefaultEntryHolder.defaultEntry);
            }

            /* JADX INFO: renamed from: buildPartial, reason: collision with other method in class */
            public BreathWakeupDuration m144buildPartial() {
                BreathWakeupDuration r0 = new BreathWakeupDuration(this, null);
                int r1 = this.bitField0_;
                int r3 = 1;
                if ((r1 & 1) == 1) goto L6;
                r3 = 0;
            L6:
                BreathWakeupDuration.access$7002(r0, this.eventName_);
                if ((r1 & 2) != 2) goto L9;
                r3 = r3 | 2;
            L9:
                BreathWakeupDuration.access$7102(r0, this.eventReportSource_);
                if ((r1 & 4) != 4) goto L12;
                r3 = r3 | 4;
            L12:
                BreathWakeupDuration.access$7202(r0, this.traceId_);
                if ((r1 & 8) != 8) goto L15;
                r3 = r3 | 8;
            L15:
                BreathWakeupDuration.access$7302(r0, this.startTimestamp_);
                if ((r1 & 16) != 16) goto L18;
                r3 = r3 | 16;
            L18:
                BreathWakeupDuration.access$7402(r0, this.endTimestamp_);
                if ((r1 & 32) != 32) goto L21;
                r3 = r3 | 32;
            L21:
                BreathWakeupDuration.access$7502(r0, this.wakeupStage1Duration_);
                if ((r1 & 64) != 64) goto L24;
                r3 = r3 | 64;
            L24:
                BreathWakeupDuration.access$7602(r0, this.wakeupStage2Duration_);
                if ((r1 & LynxTouchEvent.kPseudoStateFocusTransition) != 128) goto L27;
                r3 = r3 | LynxTouchEvent.kPseudoStateFocusTransition;
            L27:
                BreathWakeupDuration.access$7702(r0, this.wakeupStage3Duration_);
                BreathWakeupDuration.access$7802(r0, internalGetExtra());
                BreathWakeupDuration.access$7800(r0).makeImmutable();
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r2 = this.traceViewersBuilder_;
                if (r2 == null) goto L30;
                BreathWakeupDuration.access$7902(r0, r2.build());
            L34:
                BreathWakeupDuration.access$8002(r0, r3);
                onBuilt();
                return r0;
            L30:
                if ((this.bitField0_ & 512) != 512) goto L32;
                this.traceViewers_ = Collections.unmodifiableList(this.traceViewers_);
                this.bitField0_ &= -513;
            L32:
                BreathWakeupDuration.access$7902(r0, this.traceViewers_);
                goto L34
            }

            public Builder clearEndTimestamp() {
                this.bitField0_ &= -17;
                this.endTimestamp_ = 0;
                onChanged();
                return this;
            }

            public Builder clearEventName() {
                this.bitField0_ &= -2;
                this.eventName_ = BreathWakeupDuration.getDefaultInstance().getEventName();
                onChanged();
                return this;
            }

            public Builder clearEventReportSource() {
                this.bitField0_ &= -3;
                this.eventReportSource_ = BreathWakeupDuration.getDefaultInstance().getEventReportSource();
                onChanged();
                return this;
            }

            public Builder clearStartTimestamp() {
                this.bitField0_ &= -9;
                this.startTimestamp_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTraceId() {
                this.bitField0_ &= -5;
                this.traceId_ = BreathWakeupDuration.getDefaultInstance().getTraceId();
                onChanged();
                return this;
            }

            public Builder clearTraceViewers() {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                this.traceViewers_ = Collections.emptyList();
                this.bitField0_ &= -513;
                onChanged();
            L6:
                return this;
            L5:
                r0.clear();
                goto L6
            }

            public Builder clearWakeupStage1Duration() {
                this.bitField0_ &= -33;
                this.wakeupStage1Duration_ = 0;
                onChanged();
                return this;
            }

            public Builder clearWakeupStage2Duration() {
                this.bitField0_ &= -65;
                this.wakeupStage2Duration_ = 0;
                onChanged();
                return this;
            }

            public Builder clearWakeupStage3Duration() {
                this.bitField0_ &= -129;
                this.wakeupStage3Duration_ = 0;
                onChanged();
                return this;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
            public String getEventName() {
                Object r0 = this.eventName_;
                if ((r0 instanceof String) == true) goto L9;
                ByteString r1 = (ByteString) r0;
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L7;
                this.eventName_ = r2;
            L7:
                return r2;
            L9:
                return (String) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
            public ByteString getEventNameBytes() {
                Object r0 = this.eventName_;
                if ((r0 instanceof String) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) r0);
                this.eventName_ = r1;
                return r1;
            L7:
                return (ByteString) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
            public String getEventReportSource() {
                Object r0 = this.eventReportSource_;
                if ((r0 instanceof String) == true) goto L9;
                ByteString r1 = (ByteString) r0;
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L7;
                this.eventReportSource_ = r2;
            L7:
                return r2;
            L9:
                return (String) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
            public ByteString getEventReportSourceBytes() {
                Object r0 = this.eventReportSource_;
                if ((r0 instanceof String) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) r0);
                this.eventReportSource_ = r1;
                return r1;
            L7:
                return (ByteString) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
            public String getTraceId() {
                Object r0 = this.traceId_;
                if ((r0 instanceof String) == true) goto L9;
                ByteString r1 = (ByteString) r0;
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L7;
                this.traceId_ = r2;
            L7:
                return r2;
            L9:
                return (String) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
            public ByteString getTraceIdBytes() {
                Object r0 = this.traceId_;
                if ((r0 instanceof String) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) r0);
                this.traceId_ = r1;
                return r1;
            L7:
                return (ByteString) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
            public int getTraceViewersCount() {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L7;
                return this.traceViewers_.size();
            L7:
                return r0.getCount();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
            public List<AssistAudioEventDataTraceViewer> getTraceViewersList() {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L7;
                return Collections.unmodifiableList(this.traceViewers_);
            L7:
                return r0.getMessageList();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
            public List<? extends AssistAudioEventDataTraceViewerOrBuilder> getTraceViewersOrBuilderList() {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 == null) goto L7;
                return r0.getMessageOrBuilderList();
            L7:
                return Collections.unmodifiableList(this.traceViewers_);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
            public boolean hasEndTimestamp() {
                if ((this.bitField0_ & 16) != 16) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
            public boolean hasEventName() {
                if ((this.bitField0_ & 1) == 1) goto L7;
                return false;
            L7:
                return true;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
            public boolean hasEventReportSource() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
            public boolean hasStartTimestamp() {
                if ((this.bitField0_ & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
            public boolean hasTraceId() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
            public boolean hasWakeupStage1Duration() {
                if ((this.bitField0_ & 32) != 32) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
            public boolean hasWakeupStage2Duration() {
                if ((this.bitField0_ & 64) != 64) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
            public boolean hasWakeupStage3Duration() {
                if ((this.bitField0_ & LynxTouchEvent.kPseudoStateFocusTransition) != 128) goto L5;
                return true;
            L5:
                return false;
            }

            private Builder() {
                this.eventName_ = NameKeys.UnloadStrategy_No_Strategy;
                this.eventReportSource_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceId_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceViewers_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AssistAudioEventProto.access$6300();
            }

            private MapField<String, String> internalGetMutableExtra() {
                onChanged();
                if (this.extra_ != null) goto L6;
                this.extra_ = MapField.newMapField(ExtraDefaultEntryHolder.defaultEntry);
            L6:
                if (this.extra_.isMutable() == true) goto L9;
                this.extra_ = this.extra_.copy();
            L9:
                return this.extra_;
            }

            private void maybeForceBuilderInitialization() {
                if (BreathWakeupDuration.access$6800() == false) goto L6;
                getTraceViewersFieldBuilder();
                return;
            }

            public AssistAudioEventDataTraceViewer.Builder addTraceViewersBuilder() {
                return getTraceViewersFieldBuilder().addBuilder(AssistAudioEventDataTraceViewer.getDefaultInstance());
            }

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public BreathWakeupDuration m142build() {
                BreathWakeupDuration r0 = m144buildPartial();
                if (r0.isInitialized() == false) goto L6;
                return r0;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r0);
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public Builder m148clear() {
                super.clear();
                this.eventName_ = NameKeys.UnloadStrategy_No_Strategy;
                int r1 = this.bitField0_ & (-2);
                this.eventReportSource_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceId_ = NameKeys.UnloadStrategy_No_Strategy;
                this.startTimestamp_ = 0;
                this.endTimestamp_ = 0;
                this.wakeupStage1Duration_ = 0;
                this.wakeupStage2Duration_ = 0;
                this.wakeupStage3Duration_ = 0;
                this.bitField0_ = ((((((r1 & (-3)) & (-5)) & (-9)) & (-17)) & (-33)) & (-65)) & (-129);
                internalGetMutableExtra().clear();
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                this.traceViewers_ = Collections.emptyList();
                this.bitField0_ &= -513;
            L6:
                return this;
            L5:
                r0.clear();
                goto L6
            }

            public Builder clearExtra() {
                internalGetMutableExtra().getMutableMap().clear();
                return this;
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public Builder m158clone() {
                return (Builder) super.clone();
            }

            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return m161getDefaultInstanceForType();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return AssistAudioEventProto.access$6300();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
            public Map<String, String> getExtra() {
                return getExtraMap();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
            public int getExtraCount() {
                return internalGetExtra().getMap().size();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
            public Map<String, String> getExtraMap() {
                return internalGetExtra().getMap();
            }

            public Map<String, String> getMutableExtra() {
                return internalGetMutableExtra().getMutableMap();
            }

            public List<AssistAudioEventDataTraceViewer.Builder> getTraceViewersBuilderList() {
                return getTraceViewersFieldBuilder().getBuilderList();
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AssistAudioEventProto.access$6400().ensureFieldAccessorsInitialized(BreathWakeupDuration.class, Builder.class);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
            public long getEndTimestamp() {
                return this.endTimestamp_;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
            public long getStartTimestamp() {
                return this.startTimestamp_;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
            public long getWakeupStage1Duration() {
                return this.wakeupStage1Duration_;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
            public long getWakeupStage2Duration() {
                return this.wakeupStage2Duration_;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
            public long getWakeupStage3Duration() {
                return this.wakeupStage3Duration_;
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m142build();
            }

            public /* bridge */ /* synthetic */ Message buildPartial() {
                return m144buildPartial();
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
                return m148clear();
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
                return m158clone();
            }

            /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite m160getDefaultInstanceForType() {
                return m161getDefaultInstanceForType();
            }

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite m141build() {
                return m142build();
            }

            /* JADX INFO: renamed from: buildPartial, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite m143buildPartial() {
                return m144buildPartial();
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m145clear() {
                return m148clear();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder m154clone() {
                return m158clone();
            }

            /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
            public BreathWakeupDuration m161getDefaultInstanceForType() {
                return BreathWakeupDuration.getDefaultInstance();
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m146clear() {
                return m148clear();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m155clone() {
                return m158clone();
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite.Builder m147clear() {
                return m148clear();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m156clone() {
                return m158clone();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite.Builder m157clone() {
                return m158clone();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m159clone() throws CloneNotSupportedException {
                return m158clone();
            }

            private Builder(GeneratedMessageV3.BuilderParent r1) {
                super(r1);
                this.eventName_ = NameKeys.UnloadStrategy_No_Strategy;
                this.eventReportSource_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceId_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceViewers_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public Builder addAllTraceViewers(Iterable<? extends AssistAudioEventDataTraceViewer> r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                ensureTraceViewersIsMutable();
                AbstractMessageLite.Builder.addAll(r2, this.traceViewers_);
                onChanged();
            L6:
                return this;
            L5:
                r0.addAllMessages(r2);
                goto L6
            }

            public Builder addTraceViewers(AssistAudioEventDataTraceViewer.Builder r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                ensureTraceViewersIsMutable();
                this.traceViewers_.add(r2.m96build());
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2.m96build());
                goto L6
            }

            public AssistAudioEventDataTraceViewer.Builder addTraceViewersBuilder(int r3) {
                return getTraceViewersFieldBuilder().addBuilder(r3, AssistAudioEventDataTraceViewer.getDefaultInstance());
            }

            /* JADX INFO: renamed from: clearField, reason: collision with other method in class */
            public Builder m150clearField(Descriptors.FieldDescriptor r1) {
                return (Builder) super.clearField(r1);
            }

            /* JADX INFO: renamed from: clearOneof, reason: collision with other method in class */
            public Builder m153clearOneof(Descriptors.OneofDescriptor r1) {
                return (Builder) super.clearOneof(r1);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
            public boolean containsExtra(String r2) {
                if (r2 == null) goto L6;
                return internalGetExtra().getMap().containsKey(r2);
            L6:
                throw null;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
            public String getExtraOrThrow(String r3) {
                if (r3 == null) goto L10;
                Map r0 = internalGetExtra().getMap();
                if (r0.containsKey(r3) == false) goto L8;
                return (String) r0.get(r3);
            L8:
                throw new IllegalArgumentException();
            L10:
                throw null;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
            public AssistAudioEventDataTraceViewer getTraceViewers(int r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L7;
                return (AssistAudioEventDataTraceViewer) ListProtector.get(this.traceViewers_, r2);
            L7:
                return r0.getMessage(r2);
            }

            public AssistAudioEventDataTraceViewer.Builder getTraceViewersBuilder(int r2) {
                return getTraceViewersFieldBuilder().getBuilder(r2);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
            public AssistAudioEventDataTraceViewerOrBuilder getTraceViewersOrBuilder(int r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L7;
                return (AssistAudioEventDataTraceViewerOrBuilder) ListProtector.get(this.traceViewers_, r2);
            L7:
                return (AssistAudioEventDataTraceViewerOrBuilder) r0.getMessageOrBuilder(r2);
            }

            public MapField internalGetMapField(int r4) {
                if (r4 != 9) goto L7;
                return internalGetExtra();
            L7:
                throw new RuntimeException("Invalid map field number: " + r4);
            }

            public MapField internalGetMutableMapField(int r4) {
                if (r4 != 9) goto L7;
                return internalGetMutableExtra();
            L7:
                throw new RuntimeException("Invalid map field number: " + r4);
            }

            public Builder mergeFrom(BreathWakeupDuration r3) {
                if (r3 != BreathWakeupDuration.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r3.hasEventName() == false) goto L9;
                this.bitField0_ |= 1;
                this.eventName_ = BreathWakeupDuration.access$7000(r3);
                onChanged();
            L9:
                if (r3.hasEventReportSource() == false) goto L12;
                this.bitField0_ |= 2;
                this.eventReportSource_ = BreathWakeupDuration.access$7100(r3);
                onChanged();
            L12:
                if (r3.hasTraceId() == false) goto L15;
                this.bitField0_ |= 4;
                this.traceId_ = BreathWakeupDuration.access$7200(r3);
                onChanged();
            L15:
                if (r3.hasStartTimestamp() == false) goto L18;
                setStartTimestamp(r3.getStartTimestamp());
            L18:
                if (r3.hasEndTimestamp() == false) goto L21;
                setEndTimestamp(r3.getEndTimestamp());
            L21:
                if (r3.hasWakeupStage1Duration() == false) goto L24;
                setWakeupStage1Duration(r3.getWakeupStage1Duration());
            L24:
                if (r3.hasWakeupStage2Duration() == false) goto L27;
                setWakeupStage2Duration(r3.getWakeupStage2Duration());
            L27:
                if (r3.hasWakeupStage3Duration() == false) goto L29;
                setWakeupStage3Duration(r3.getWakeupStage3Duration());
            L29:
                internalGetMutableExtra().mergeFrom(BreathWakeupDuration.access$8100(r3));
                if (this.traceViewersBuilder_ != null) goto L39;
                if (BreathWakeupDuration.access$7900(r3).isEmpty() == false) goto L34;
            L47:
                m170mergeUnknownFields(BreathWakeupDuration.access$8300(r3));
                onChanged();
                return this;
            L34:
                if (this.traceViewers_.isEmpty() == false) goto L36;
                this.traceViewers_ = BreathWakeupDuration.access$7900(r3);
                this.bitField0_ &= -513;
            L37:
                onChanged();
                goto L47
            L36:
                ensureTraceViewersIsMutable();
                this.traceViewers_.addAll(BreathWakeupDuration.access$7900(r3));
                goto L37
            L39:
                if (BreathWakeupDuration.access$7900(r3).isEmpty() == true) goto L47;
                if (this.traceViewersBuilder_.isEmpty() == false) goto L46;
                this.traceViewersBuilder_.dispose();
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = null;
                this.traceViewersBuilder_ = null;
                this.traceViewers_ = BreathWakeupDuration.access$7900(r3);
                this.bitField0_ &= -513;
                if (BreathWakeupDuration.access$8200() == false) goto L45;
                r0 = getTraceViewersFieldBuilder();
            L45:
                this.traceViewersBuilder_ = r0;
                goto L47
            L46:
                this.traceViewersBuilder_.addAllMessages(BreathWakeupDuration.access$7900(r3));
                goto L47
            }

            /* JADX INFO: renamed from: mergeUnknownFields, reason: collision with other method in class */
            public final Builder m170mergeUnknownFields(UnknownFieldSet r1) {
                return (Builder) super.mergeUnknownFields(r1);
            }

            public Builder putAllExtra(Map<String, String> r2) {
                internalGetMutableExtra().getMutableMap().putAll(r2);
                return this;
            }

            public Builder removeExtra(String r2) {
                if (r2 == null) goto L6;
                internalGetMutableExtra().getMutableMap().remove(r2);
                return this;
            L6:
                throw null;
            }

            public Builder removeTraceViewers(int r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                ensureTraceViewersIsMutable();
                ListProtector.remove(this.traceViewers_, r2);
                onChanged();
            L6:
                return this;
            L5:
                r0.remove(r2);
                goto L6
            }

            public Builder setEndTimestamp(long r2) {
                this.bitField0_ |= 16;
                this.endTimestamp_ = r2;
                onChanged();
                return this;
            }

            public Builder setEventName(String r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 1;
                this.eventName_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setEventNameBytes(ByteString r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 1;
                this.eventName_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setEventReportSource(String r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 2;
                this.eventReportSource_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setEventReportSourceBytes(ByteString r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 2;
                this.eventReportSource_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setStartTimestamp(long r2) {
                this.bitField0_ |= 8;
                this.startTimestamp_ = r2;
                onChanged();
                return this;
            }

            public Builder setTraceId(String r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 4;
                this.traceId_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setTraceIdBytes(ByteString r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 4;
                this.traceId_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            /* JADX INFO: renamed from: setUnknownFields, reason: collision with other method in class */
            public final Builder m176setUnknownFields(UnknownFieldSet r1) {
                return (Builder) super.setUnknownFields(r1);
            }

            public Builder setWakeupStage1Duration(long r2) {
                this.bitField0_ |= 32;
                this.wakeupStage1Duration_ = r2;
                onChanged();
                return this;
            }

            public Builder setWakeupStage2Duration(long r2) {
                this.bitField0_ |= 64;
                this.wakeupStage2Duration_ = r2;
                onChanged();
                return this;
            }

            public Builder setWakeupStage3Duration(long r2) {
                this.bitField0_ |= LynxTouchEvent.kPseudoStateFocusTransition;
                this.wakeupStage3Duration_ = r2;
                onChanged();
                return this;
            }

            public /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            public Builder addTraceViewers(AssistAudioEventDataTraceViewer r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L8;
                if (r2 == null) goto L7;
                ensureTraceViewersIsMutable();
                this.traceViewers_.add(r2);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.addMessage(r2);
                goto L9
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearField(Descriptors.FieldDescriptor r1) {
                return m150clearField(r1);
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r1) {
                return m153clearOneof(r1);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public Builder m167mergeFrom(Message r2) {
                if ((r2 instanceof BreathWakeupDuration) == true) goto L5;
                super/*com.google.protobuf.AbstractMessage.Builder*/.mergeFrom(r2);
                return this;
            L5:
                return mergeFrom((BreathWakeupDuration) r2);
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r1) {
                return m170mergeUnknownFields(r1);
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r1) {
                return m176setUnknownFields(r1);
            }

            /* JADX INFO: renamed from: clearField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m149clearField(Descriptors.FieldDescriptor r1) {
                return m150clearField(r1);
            }

            /* JADX INFO: renamed from: clearOneof, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m151clearOneof(Descriptors.OneofDescriptor r1) {
                return m153clearOneof(r1);
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r1) {
                return m167mergeFrom(r1);
            }

            /* JADX INFO: renamed from: mergeUnknownFields, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m168mergeUnknownFields(UnknownFieldSet r1) {
                return m170mergeUnknownFields(r1);
            }

            /* JADX INFO: renamed from: setUnknownFields, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m175setUnknownFields(UnknownFieldSet r1) {
                return m176setUnknownFields(r1);
            }

            /* JADX INFO: renamed from: clearOneof, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m152clearOneof(Descriptors.OneofDescriptor r1) {
                return m153clearOneof(r1);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m164mergeFrom(Message r1) {
                return m167mergeFrom(r1);
            }

            /* JADX INFO: renamed from: mergeUnknownFields, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m169mergeUnknownFields(UnknownFieldSet r1) {
                return m170mergeUnknownFields(r1);
            }

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r1, AnonymousClass1 r2) {
                this(r1);
            }

            /* JADX INFO: renamed from: addRepeatedField, reason: collision with other method in class */
            public Builder m140addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
                return (Builder) super.addRepeatedField(r1, r2);
            }

            public Builder addTraceViewers(int r2, AssistAudioEventDataTraceViewer.Builder r3) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                ensureTraceViewersIsMutable();
                ListProtector.add(this.traceViewers_, r2, r3.m96build());
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2, r3.m96build());
                goto L6
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
            public String getExtraOrDefault(String r3, String r4) {
                if (r3 == null) goto L8;
                Map r0 = internalGetExtra().getMap();
                if (r0.containsKey(r3) == true) goto L6;
                return r4;
            L6:
                return (String) r0.get(r3);
            L8:
                throw null;
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public Builder m166mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                BreathWakeupDuration r0 = null;
                BreathWakeupDuration r5 = (BreathWakeupDuration) BreathWakeupDuration.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                BreathWakeupDuration r6 = (BreathWakeupDuration) e.getUnfinishedMessage();     // Catch: Throwable -> L7
            L13:
                th = th;
                r0 = r6;
            L15:
                if (r0 == null) goto L17;
                mergeFrom(r0);
            L17:
                throw th;
            L12:
                throw e.unwrapIOException();     // Catch: Throwable -> L13
            L7:
                th = th;
                goto L15
            }

            public Builder putExtra(String r2, String r3) {
                if (r2 == null) goto L8;
                if (r3 == null) goto L7;
                internalGetMutableExtra().getMutableMap().put(r2, r3);
                return this;
            L7:
                throw null;
            L8:
                throw null;
            }

            /* JADX INFO: renamed from: setField, reason: collision with other method in class */
            public Builder m172setField(Descriptors.FieldDescriptor r1, Object r2) {
                return (Builder) super.setField(r1, r2);
            }

            public Builder setTraceViewers(int r2, AssistAudioEventDataTraceViewer.Builder r3) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                ensureTraceViewersIsMutable();
                ListProtector.set(this.traceViewers_, r2, r3.m96build());
                onChanged();
            L6:
                return this;
            L5:
                r0.setMessage(r2, r3.m96build());
                goto L6
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
                return m140addRepeatedField(r1, r2);
            }

            public Builder addTraceViewers(int r2, AssistAudioEventDataTraceViewer r3) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L8;
                if (r3 == null) goto L7;
                ensureTraceViewersIsMutable();
                ListProtector.add(this.traceViewers_, r2, r3);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.addMessage(r2, r3);
                goto L9
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m166mergeFrom(r1, r2);
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setField(Descriptors.FieldDescriptor r1, Object r2) {
                return m172setField(r1, r2);
            }

            public Builder setTraceViewers(int r2, AssistAudioEventDataTraceViewer r3) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L8;
                if (r3 == null) goto L7;
                ensureTraceViewersIsMutable();
                ListProtector.set(this.traceViewers_, r2, r3);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.setMessage(r2, r3);
                goto L9
            }

            /* JADX INFO: renamed from: addRepeatedField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m139addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
                return m140addRepeatedField(r1, r2);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder m162mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m166mergeFrom(r1, r2);
            }

            /* JADX INFO: renamed from: setField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m171setField(Descriptors.FieldDescriptor r1, Object r2) {
                return m172setField(r1, r2);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m163mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m166mergeFrom(r1, r2);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite.Builder m165mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m166mergeFrom(r1, r2);
            }

            /* JADX INFO: renamed from: setRepeatedField, reason: collision with other method in class */
            public Builder m174setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
                return (Builder) super.setRepeatedField(r1, r2, r3);
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
                return m174setRepeatedField(r1, r2, r3);
            }

            /* JADX INFO: renamed from: setRepeatedField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m173setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
                return m174setRepeatedField(r1, r2, r3);
            }
        }

        public static final class ExtraDefaultEntryHolder {
            static final MapEntry<String, String> defaultEntry = null;

            private ExtraDefaultEntryHolder() {
            }

            static {
                Descriptors.Descriptor r0 = AssistAudioEventProto.access$6500();
                WireFormat.FieldType r1 = WireFormat.FieldType.STRING;
                defaultEntry = MapEntry.newDefaultInstance(r0, r1, NameKeys.UnloadStrategy_No_Strategy, r1, NameKeys.UnloadStrategy_No_Strategy);
            }
        }

        static {
            DEFAULT_INSTANCE = new BreathWakeupDuration();
            PARSER = new AnonymousClass1();
        }

        private MapField<String, String> internalGetExtra() {
            MapField<String, String> r0 = this.extra_;
            if (r0 == null) goto L5;
            return r0;
        L5:
            return MapField.emptyMapField(ExtraDefaultEntryHolder.defaultEntry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m137toBuilder();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
        public String getEventName() {
            Object r0 = this.eventName_;
            if ((r0 instanceof String) == true) goto L5;
            ByteString r1 = (ByteString) r0;
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L9;
            this.eventName_ = r2;
        L9:
            return r2;
        L5:
            return (String) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
        public ByteString getEventNameBytes() {
            Object r0 = this.eventName_;
            if ((r0 instanceof String) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) r0);
            this.eventName_ = r1;
            return r1;
        L7:
            return (ByteString) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
        public String getEventReportSource() {
            Object r0 = this.eventReportSource_;
            if ((r0 instanceof String) == true) goto L5;
            ByteString r1 = (ByteString) r0;
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L9;
            this.eventReportSource_ = r2;
        L9:
            return r2;
        L5:
            return (String) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
        public ByteString getEventReportSourceBytes() {
            Object r0 = this.eventReportSource_;
            if ((r0 instanceof String) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) r0);
            this.eventReportSource_ = r1;
            return r1;
        L7:
            return (ByteString) r0;
        }

        public int getSerializedSize() {
            int r0 = ((AbstractMessage) this).memoizedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r2 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r1 = GeneratedMessageV3.computeStringSize(1, this.eventName_) + 0;
        L10:
            if ((this.bitField0_ & 2) != 2) goto L13;
            r1 = r1 + GeneratedMessageV3.computeStringSize(2, this.eventReportSource_);
        L13:
            if ((this.bitField0_ & 4) != 4) goto L16;
            r1 = r1 + GeneratedMessageV3.computeStringSize(3, this.traceId_);
        L16:
            if ((this.bitField0_ & 8) != 8) goto L19;
            r1 = r1 + CodedOutputStream.computeInt64Size(4, this.startTimestamp_);
        L19:
            if ((this.bitField0_ & 16) != 16) goto L22;
            r1 = r1 + CodedOutputStream.computeInt64Size(5, this.endTimestamp_);
        L22:
            if ((this.bitField0_ & 32) != 32) goto L25;
            r1 = r1 + CodedOutputStream.computeInt64Size(6, this.wakeupStage1Duration_);
        L25:
            if ((this.bitField0_ & 64) != 64) goto L28;
            r1 = r1 + CodedOutputStream.computeInt64Size(7, this.wakeupStage2Duration_);
        L28:
            if ((this.bitField0_ & LynxTouchEvent.kPseudoStateFocusTransition) != 128) goto L30;
            r1 = r1 + CodedOutputStream.computeInt64Size(8, this.wakeupStage3Duration_);
        L30:
            Iterator r3 = internalGetExtra().getMap().entrySet().iterator();
        L32:
            if (r3.hasNext() == false) goto L35;
            Map.Entry r4 = (Map.Entry) r3.next();
            r1 = r1 + CodedOutputStream.computeMessageSize(9, ExtraDefaultEntryHolder.defaultEntry.newBuilderForType().setKey((String) r4.getKey()).setValue((String) r4.getValue()).build());
        L35:
            if (r2 >= this.traceViewers_.size()) goto L37;
            r1 = r1 + CodedOutputStream.computeMessageSize(10, (MessageLite) ListProtector.get(this.traceViewers_, r2));
            r2 = r2 + 1;
            goto L35
        L37:
            int r5 = r1 + ((GeneratedMessageV3) this).unknownFields.getSerializedSize();
            ((AbstractMessage) this).memoizedSize = r5;
            return r5;
        L8:
            r1 = 0;
            goto L10
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
        public String getTraceId() {
            Object r0 = this.traceId_;
            if ((r0 instanceof String) == true) goto L5;
            ByteString r1 = (ByteString) r0;
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L9;
            this.traceId_ = r2;
        L9:
            return r2;
        L5:
            return (String) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
        public ByteString getTraceIdBytes() {
            Object r0 = this.traceId_;
            if ((r0 instanceof String) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) r0);
            this.traceId_ = r1;
            return r1;
        L7:
            return (ByteString) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
        public int getTraceViewersCount() {
            return this.traceViewers_.size();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
        public boolean hasEndTimestamp() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
        public boolean hasEventName() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
        public boolean hasEventReportSource() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
        public boolean hasStartTimestamp() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
        public boolean hasTraceId() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
        public boolean hasWakeupStage1Duration() {
            if ((this.bitField0_ & 32) != 32) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
        public boolean hasWakeupStage2Duration() {
            if ((this.bitField0_ & 64) != 64) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
        public boolean hasWakeupStage3Duration() {
            if ((this.bitField0_ & LynxTouchEvent.kPseudoStateFocusTransition) != 128) goto L5;
            return true;
        L5:
            return false;
        }

        public int hashCode() {
            int r0 = ((AbstractMessageLite) this).memoizedHashCode;
            if (r0 == 0) goto L5;
            return r0;
        L5:
            int r1 = 779 + getDescriptor().hashCode();
            if (hasEventName() == false) goto L9;
            r1 = (((r1 * 37) + 1) * 53) + getEventName().hashCode();
        L9:
            if (hasEventReportSource() == false) goto L12;
            r1 = (((r1 * 37) + 2) * 53) + getEventReportSource().hashCode();
        L12:
            if (hasTraceId() == false) goto L15;
            r1 = (((r1 * 37) + 3) * 53) + getTraceId().hashCode();
        L15:
            if (hasStartTimestamp() == false) goto L18;
            r1 = (((r1 * 37) + 4) * 53) + Internal.hashLong(getStartTimestamp());
        L18:
            if (hasEndTimestamp() == false) goto L21;
            r1 = (((r1 * 37) + 5) * 53) + Internal.hashLong(getEndTimestamp());
        L21:
            if (hasWakeupStage1Duration() == false) goto L24;
            r1 = (((r1 * 37) + 6) * 53) + Internal.hashLong(getWakeupStage1Duration());
        L24:
            if (hasWakeupStage2Duration() == false) goto L27;
            r1 = (((r1 * 37) + 7) * 53) + Internal.hashLong(getWakeupStage2Duration());
        L27:
            if (hasWakeupStage3Duration() == false) goto L30;
            r1 = (((r1 * 37) + 8) * 53) + Internal.hashLong(getWakeupStage3Duration());
        L30:
            if (internalGetExtra().getMap().isEmpty() == true) goto L33;
            r1 = (((r1 * 37) + 9) * 53) + internalGetExtra().hashCode();
        L33:
            if (getTraceViewersCount() <= 0) goto L35;
            r1 = (((r1 * 37) + 10) * 53) + getTraceViewersList().hashCode();
        L35:
            int r2 = (r1 * 29) + ((GeneratedMessageV3) this).unknownFields.hashCode();
            ((AbstractMessageLite) this).memoizedHashCode = r2;
            return r2;
        }

        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L5;
            return true;
        L5:
            if (r0 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        /* JADX INFO: renamed from: toBuilder, reason: collision with other method in class */
        public Builder m137toBuilder() {
            AnonymousClass1 r1 = null;
            if (this != DEFAULT_INSTANCE) goto L6;
            return new Builder(r1);
        L6:
            return new Builder(r1).mergeFrom(this);
        }

        private BreathWakeupDuration() {
            this.memoizedIsInitialized = -1;
            this.eventName_ = NameKeys.UnloadStrategy_No_Strategy;
            this.eventReportSource_ = NameKeys.UnloadStrategy_No_Strategy;
            this.traceId_ = NameKeys.UnloadStrategy_No_Strategy;
            this.startTimestamp_ = 0;
            this.endTimestamp_ = 0;
            this.wakeupStage1Duration_ = 0;
            this.wakeupStage2Duration_ = 0;
            this.wakeupStage3Duration_ = 0;
            this.traceViewers_ = Collections.emptyList();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AssistAudioEventProto.access$6300();
        }

        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return m132getDefaultInstanceForType();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
        public Map<String, String> getExtra() {
            return getExtraMap();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
        public int getExtraCount() {
            return internalGetExtra().getMap().size();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
        public Map<String, String> getExtraMap() {
            return internalGetExtra().getMap();
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AssistAudioEventProto.access$6400().ensureFieldAccessorsInitialized(BreathWakeupDuration.class, Builder.class);
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return m134newBuilderForType();
        }

        public static /* synthetic */ boolean access$6800() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ boolean access$8200() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static BreathWakeupDuration getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BreathWakeupDuration> parser() {
            return PARSER;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
        public long getEndTimestamp() {
            return this.endTimestamp_;
        }

        public Parser<BreathWakeupDuration> getParserForType() {
            return PARSER;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
        public long getStartTimestamp() {
            return this.startTimestamp_;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
        public List<AssistAudioEventDataTraceViewer> getTraceViewersList() {
            return this.traceViewers_;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
        public List<? extends AssistAudioEventDataTraceViewerOrBuilder> getTraceViewersOrBuilderList() {
            return this.traceViewers_;
        }

        public final UnknownFieldSet getUnknownFields() {
            return ((GeneratedMessageV3) this).unknownFields;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
        public long getWakeupStage1Duration() {
            return this.wakeupStage1Duration_;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
        public long getWakeupStage2Duration() {
            return this.wakeupStage2Duration_;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
        public long getWakeupStage3Duration() {
            return this.wakeupStage3Duration_;
        }

        /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite m131getDefaultInstanceForType() {
            return m132getDefaultInstanceForType();
        }

        /* JADX INFO: renamed from: newBuilderForType, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite.Builder m133newBuilderForType() {
            return m134newBuilderForType();
        }

        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return m137toBuilder();
        }

        /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
        public BreathWakeupDuration m132getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: renamed from: newBuilderForType, reason: collision with other method in class */
        public Builder m134newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: renamed from: toBuilder, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite.Builder m136toBuilder() {
            return m137toBuilder();
        }

        private BreathWakeupDuration(GeneratedMessageV3.Builder<?> r1) {
            super(r1);
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ Object access$7000(BreathWakeupDuration r0) {
            return r0.eventName_;
        }

        public static /* synthetic */ Object access$7100(BreathWakeupDuration r0) {
            return r0.eventReportSource_;
        }

        public static /* synthetic */ Object access$7200(BreathWakeupDuration r0) {
            return r0.traceId_;
        }

        public static /* synthetic */ MapField access$7800(BreathWakeupDuration r0) {
            return r0.extra_;
        }

        public static /* synthetic */ List access$7900(BreathWakeupDuration r0) {
            return r0.traceViewers_;
        }

        public static /* synthetic */ MapField access$8100(BreathWakeupDuration r0) {
            return r0.internalGetExtra();
        }

        public static /* synthetic */ UnknownFieldSet access$8300(BreathWakeupDuration r0) {
            return ((GeneratedMessageV3) r0).unknownFields;
        }

        public static Builder newBuilder(BreathWakeupDuration r1) {
            return DEFAULT_INSTANCE.m137toBuilder().mergeFrom(r1);
        }

        public static BreathWakeupDuration parseDelimitedFrom(InputStream r1) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r1);
        }

        public static BreathWakeupDuration parseFrom(ByteString r1) throws InvalidProtocolBufferException {
            return (BreathWakeupDuration) PARSER.parseFrom(r1);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
        public boolean containsExtra(String r2) {
            if (r2 == null) goto L6;
            return internalGetExtra().getMap().containsKey(r2);
        L6:
            throw null;
        }

        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof BreathWakeupDuration) == false) goto L8;
            BreathWakeupDuration r9 = (BreathWakeupDuration) r8;
            if (hasEventName() != r9.hasEventName()) goto L12;
            boolean r1 = true;
        L14:
            if (hasEventName() == false) goto L20;
            if (r1 == true) goto L17;
        L19:
            r1 = false;
            goto L20
        L17:
            if (getEventName().equals(r9.getEventName()) == false) goto L19;
            r1 = true;
        L20:
            if (r1 == true) goto L22;
        L24:
            boolean r2 = false;
        L26:
            if (hasEventReportSource() == false) goto L32;
            if (r2 == true) goto L29;
        L31:
            r2 = false;
            goto L32
        L29:
            if (getEventReportSource().equals(r9.getEventReportSource()) == false) goto L31;
            r2 = true;
        L32:
            if (r2 == true) goto L34;
        L36:
            boolean r3 = false;
        L38:
            if (hasTraceId() == false) goto L44;
            if (r3 == true) goto L41;
        L43:
            r3 = false;
            goto L44
        L41:
            if (getTraceId().equals(r9.getTraceId()) == false) goto L43;
            r3 = true;
        L44:
            if (r3 == true) goto L46;
        L48:
            boolean r4 = false;
        L50:
            if (hasStartTimestamp() == false) goto L56;
            if (r4 == true) goto L53;
        L55:
            r4 = false;
            goto L56
        L53:
            if (getStartTimestamp() != r9.getStartTimestamp()) goto L55;
            r4 = true;
        L56:
            if (r4 == true) goto L58;
        L60:
            boolean r5 = false;
        L62:
            if (hasEndTimestamp() == false) goto L68;
            if (r5 == true) goto L65;
        L67:
            r5 = false;
            goto L68
        L65:
            if (getEndTimestamp() != r9.getEndTimestamp()) goto L67;
            r5 = true;
        L68:
            if (r5 == true) goto L70;
        L72:
            boolean r6 = false;
        L74:
            if (hasWakeupStage1Duration() == false) goto L80;
            if (r6 == true) goto L77;
        L79:
            r6 = false;
            goto L80
        L77:
            if (getWakeupStage1Duration() != r9.getWakeupStage1Duration()) goto L79;
            r6 = true;
        L80:
            if (r6 == true) goto L82;
        L84:
            boolean r7 = false;
        L86:
            if (hasWakeupStage2Duration() == false) goto L92;
            if (r7 == true) goto L89;
        L91:
            r7 = false;
            goto L92
        L89:
            if (getWakeupStage2Duration() != r9.getWakeupStage2Duration()) goto L91;
            r7 = true;
        L92:
            if (r7 == true) goto L94;
        L96:
            boolean r10 = false;
        L98:
            if (hasWakeupStage3Duration() == false) goto L104;
            if (r10 == true) goto L101;
        L103:
            r10 = false;
            goto L104
        L101:
            if (getWakeupStage3Duration() != r9.getWakeupStage3Duration()) goto L103;
            r10 = true;
        L104:
            if (r10 == true) goto L106;
        L108:
            boolean r11 = false;
        L109:
            if (r11 == true) goto L111;
        L113:
            boolean r12 = false;
        L114:
            if (r12 == true) goto L116;
        L118:
            return false;
        L116:
            if (((GeneratedMessageV3) this).unknownFields.equals(((GeneratedMessageV3) r9).unknownFields) == false) goto L118;
            return true;
        L111:
            if (getTraceViewersList().equals(r9.getTraceViewersList()) == false) goto L113;
            r12 = true;
            goto L114
        L106:
            if (internalGetExtra().equals(r9.internalGetExtra()) == false) goto L108;
            r11 = true;
            goto L109
        L94:
            if (hasWakeupStage3Duration() != r9.hasWakeupStage3Duration()) goto L96;
            r10 = true;
            goto L98
        L82:
            if (hasWakeupStage2Duration() != r9.hasWakeupStage2Duration()) goto L84;
            r7 = true;
            goto L86
        L70:
            if (hasWakeupStage1Duration() != r9.hasWakeupStage1Duration()) goto L72;
            r6 = true;
            goto L74
        L58:
            if (hasEndTimestamp() != r9.hasEndTimestamp()) goto L60;
            r5 = true;
            goto L62
        L46:
            if (hasStartTimestamp() != r9.hasStartTimestamp()) goto L48;
            r4 = true;
            goto L50
        L34:
            if (hasTraceId() != r9.hasTraceId()) goto L36;
            r3 = true;
            goto L38
        L22:
            if (hasEventReportSource() != r9.hasEventReportSource()) goto L24;
            r2 = true;
            goto L26
        L12:
            r1 = false;
            goto L14
        L8:
            return super/*com.google.protobuf.AbstractMessage*/.equals(r8);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
        public String getExtraOrThrow(String r3) {
            if (r3 == null) goto L10;
            Map r0 = internalGetExtra().getMap();
            if (r0.containsKey(r3) == false) goto L8;
            return (String) r0.get(r3);
        L8:
            throw new IllegalArgumentException();
        L10:
            throw null;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
        public AssistAudioEventDataTraceViewer getTraceViewers(int r2) {
            return (AssistAudioEventDataTraceViewer) ListProtector.get(this.traceViewers_, r2);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
        public AssistAudioEventDataTraceViewerOrBuilder getTraceViewersOrBuilder(int r2) {
            return (AssistAudioEventDataTraceViewerOrBuilder) ListProtector.get(this.traceViewers_, r2);
        }

        public MapField internalGetMapField(int r4) {
            if (r4 != 9) goto L7;
            return internalGetExtra();
        L7:
            throw new RuntimeException("Invalid map field number: " + r4);
        }

        /* JADX INFO: renamed from: newBuilderForType, reason: collision with other method in class */
        public Builder m135newBuilderForType(GeneratedMessageV3.BuilderParent r3) {
            return new Builder(r3, null);
        }

        public void writeTo(CodedOutputStream r6) throws IOException {
            if ((this.bitField0_ & 1) != 1) goto L6;
            GeneratedMessageV3.writeString(r6, 1, this.eventName_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            GeneratedMessageV3.writeString(r6, 2, this.eventReportSource_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L12;
            GeneratedMessageV3.writeString(r6, 3, this.traceId_);
        L12:
            if ((this.bitField0_ & 8) != 8) goto L15;
            r6.writeInt64(4, this.startTimestamp_);
        L15:
            if ((this.bitField0_ & 16) != 16) goto L18;
            r6.writeInt64(5, this.endTimestamp_);
        L18:
            if ((this.bitField0_ & 32) != 32) goto L21;
            r6.writeInt64(6, this.wakeupStage1Duration_);
        L21:
            if ((this.bitField0_ & 64) != 64) goto L24;
            r6.writeInt64(7, this.wakeupStage2Duration_);
        L24:
            if ((this.bitField0_ & LynxTouchEvent.kPseudoStateFocusTransition) != 128) goto L26;
            r6.writeInt64(8, this.wakeupStage3Duration_);
        L26:
            GeneratedMessageV3.serializeStringMapTo(r6, internalGetExtra(), ExtraDefaultEntryHolder.defaultEntry, 9);
            int r0 = 0;
        L28:
            if (r0 >= this.traceViewers_.size()) goto L30;
            r6.writeMessage(10, (MessageLite) ListProtector.get(this.traceViewers_, r0));
            r0 = r0 + 1;
            goto L28
        L30:
            ((GeneratedMessageV3) this).unknownFields.writeTo(r6);
        }

        public static BreathWakeupDuration parseFrom(CodedInputStream r1) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1);
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r1) {
            return m135newBuilderForType(r1);
        }

        public static BreathWakeupDuration parseFrom(InputStream r1) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1);
        }

        public static BreathWakeupDuration parseFrom(ByteBuffer r1) throws InvalidProtocolBufferException {
            return (BreathWakeupDuration) PARSER.parseFrom(r1);
        }

        public static BreathWakeupDuration parseFrom(byte[] r1) throws InvalidProtocolBufferException {
            return (BreathWakeupDuration) PARSER.parseFrom(r1);
        }

        private BreathWakeupDuration(CodedInputStream r8, ExtensionRegistryLite r9) throws InvalidProtocolBufferException {
            this();
            if (r9 == null) goto L49;
            UnknownFieldSet.Builder r0 = UnknownFieldSet.newBuilder();
            boolean r1 = false;
            int r2 = 0;
        L6:
            if (r1 == true) goto L44;
            int r4 = r8.readTag();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            switch(r4) {
                case 0: goto L27;
                case 10: goto L25;
                case 18: goto L24;
                case 26: goto L23;
                case 32: goto L22;
                case 40: goto L21;
                case 48: goto L20;
                case 56: goto L19;
                case 64: goto L18;
                case 74: goto L15;
                case 82: goto L11;
                default: goto L28;
            };     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
        L11:
            if ((r2 & 512) == 512) goto L13;
            this.traceViewers_ = new ArrayList();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            r2 = r2 | 512;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
        L13:
            this.traceViewers_.add((AssistAudioEventDataTraceViewer) r8.readMessage(AssistAudioEventDataTraceViewer.PARSER, r9));     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            goto L6
        L15:
            if ((r2 & 256) == 256) goto L17;
            this.extra_ = MapField.newMapField(ExtraDefaultEntryHolder.defaultEntry);     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            r2 = r2 | 256;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
        L17:
            MapEntry r5 = r8.readMessage(ExtraDefaultEntryHolder.defaultEntry.getParserForType(), r9);     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            this.extra_.getMutableMap().put((String) r5.getKey(), (String) r5.getValue());     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            goto L6
        L18:
            this.bitField0_ |= LynxTouchEvent.kPseudoStateFocusTransition;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            this.wakeupStage3Duration_ = r8.readInt64();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            goto L6
        L19:
            this.bitField0_ |= 64;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            this.wakeupStage2Duration_ = r8.readInt64();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            goto L6
        L20:
            this.bitField0_ |= 32;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            this.wakeupStage1Duration_ = r8.readInt64();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            goto L6
        L21:
            this.bitField0_ |= 16;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            this.endTimestamp_ = r8.readInt64();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            goto L6
        L22:
            this.bitField0_ |= 8;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            this.startTimestamp_ = r8.readInt64();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            goto L6
        L23:
            ByteString r6 = r8.readBytes();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            this.bitField0_ |= 4;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            this.traceId_ = r6;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            goto L6
        L24:
            ByteString r7 = r8.readBytes();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            this.bitField0_ |= 2;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            this.eventReportSource_ = r7;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            goto L6
        L25:
            ByteString r10 = r8.readBytes();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            this.bitField0_ = 1 | this.bitField0_;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            this.eventName_ = r10;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
        L27:
            r1 = true;
            goto L6
        L28:
            if (parseUnknownField(r8, r0, r9, r4) == true) goto L6;
        L30:
            th = move-exception;
            if ((r2 & 512) != 512) goto L41;
            this.traceViewers_ = Collections.unmodifiableList(this.traceViewers_);
        L41:
            ((GeneratedMessageV3) this).unknownFields = r0.build();
            makeExtensionsImmutable();
            throw th;
        L32:
            e = move-exception;
            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L30
        L35:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L30
        L44:
            if ((r2 & 512) != 512) goto L46;
            this.traceViewers_ = Collections.unmodifiableList(this.traceViewers_);
        L46:
            ((GeneratedMessageV3) this).unknownFields = r0.build();
            makeExtensionsImmutable();
            return;
        L49:
            throw null;
        }

        public static /* synthetic */ Object access$7002(BreathWakeupDuration r0, Object r1) {
            r0.eventName_ = r1;
            return r1;
        }

        public static /* synthetic */ Object access$7102(BreathWakeupDuration r0, Object r1) {
            r0.eventReportSource_ = r1;
            return r1;
        }

        public static /* synthetic */ Object access$7202(BreathWakeupDuration r0, Object r1) {
            r0.traceId_ = r1;
            return r1;
        }

        public static /* synthetic */ long access$7302(BreathWakeupDuration r0, long r1) {
            r0.startTimestamp_ = r1;
            return r1;
        }

        public static /* synthetic */ long access$7402(BreathWakeupDuration r0, long r1) {
            r0.endTimestamp_ = r1;
            return r1;
        }

        public static /* synthetic */ long access$7502(BreathWakeupDuration r0, long r1) {
            r0.wakeupStage1Duration_ = r1;
            return r1;
        }

        public static /* synthetic */ long access$7602(BreathWakeupDuration r0, long r1) {
            r0.wakeupStage2Duration_ = r1;
            return r1;
        }

        public static /* synthetic */ long access$7702(BreathWakeupDuration r0, long r1) {
            r0.wakeupStage3Duration_ = r1;
            return r1;
        }

        public static /* synthetic */ MapField access$7802(BreathWakeupDuration r0, MapField r1) {
            r0.extra_ = r1;
            return r1;
        }

        public static /* synthetic */ List access$7902(BreathWakeupDuration r0, List r1) {
            r0.traceViewers_ = r1;
            return r1;
        }

        public static /* synthetic */ int access$8002(BreathWakeupDuration r0, int r1) {
            r0.bitField0_ = r1;
            return r1;
        }

        public static BreathWakeupDuration parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r1, r2);
        }

        public static BreathWakeupDuration parseFrom(ByteString r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
            return (BreathWakeupDuration) PARSER.parseFrom(r1, r2);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupDurationOrBuilder
        public String getExtraOrDefault(String r3, String r4) {
            if (r3 == null) goto L8;
            Map r0 = internalGetExtra().getMap();
            if (r0.containsKey(r3) == true) goto L6;
            return r4;
        L6:
            return (String) r0.get(r3);
        L8:
            throw null;
        }

        public /* synthetic */ BreathWakeupDuration(GeneratedMessageV3.Builder r1, AnonymousClass1 r2) {
            this(r1);
        }

        public static BreathWakeupDuration parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1, r2);
        }

        public static BreathWakeupDuration parseFrom(InputStream r1, ExtensionRegistryLite r2) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1, r2);
        }

        public static BreathWakeupDuration parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
            return (BreathWakeupDuration) PARSER.parseFrom(r1, r2);
        }

        public static BreathWakeupDuration parseFrom(byte[] r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
            return (BreathWakeupDuration) PARSER.parseFrom(r1, r2);
        }

        public /* synthetic */ BreathWakeupDuration(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }
    }

    public interface BreathWakeupDurationOrBuilder extends MessageOrBuilder {
        boolean containsExtra(String r1);

        long getEndTimestamp();

        String getEventName();

        ByteString getEventNameBytes();

        String getEventReportSource();

        ByteString getEventReportSourceBytes();

        Map<String, String> getExtra();

        int getExtraCount();

        Map<String, String> getExtraMap();

        String getExtraOrDefault(String r1, String r2);

        String getExtraOrThrow(String r1);

        long getStartTimestamp();

        String getTraceId();

        ByteString getTraceIdBytes();

        AssistAudioEventDataTraceViewer getTraceViewers(int r1);

        int getTraceViewersCount();

        List<AssistAudioEventDataTraceViewer> getTraceViewersList();

        AssistAudioEventDataTraceViewerOrBuilder getTraceViewersOrBuilder(int r1);

        List<? extends AssistAudioEventDataTraceViewerOrBuilder> getTraceViewersOrBuilderList();

        long getWakeupStage1Duration();

        long getWakeupStage2Duration();

        long getWakeupStage3Duration();

        boolean hasEndTimestamp();

        boolean hasEventName();

        boolean hasEventReportSource();

        boolean hasStartTimestamp();

        boolean hasTraceId();

        boolean hasWakeupStage1Duration();

        boolean hasWakeupStage2Duration();

        boolean hasWakeupStage3Duration();
    }

    public static final class BreathWakeupEvent extends GeneratedMessageV3 implements BreathWakeupEventOrBuilder {
        private static final BreathWakeupEvent DEFAULT_INSTANCE = null;
        public static final int EVENT_NAME_FIELD_NUMBER = 1;
        public static final int EVENT_REPORT_SOURCE_FIELD_NUMBER = 2;
        public static final int EXTRA_FIELD_NUMBER = 8;
        public static final Parser<BreathWakeupEvent> PARSER = null;
        public static final int REJECT_REASON_FIELD_NUMBER = 7;
        public static final int TIMESTAMP_FIELD_NUMBER = 4;
        public static final int TRACE_ID_FIELD_NUMBER = 3;
        public static final int TRACE_VIEWERS_FIELD_NUMBER = 9;
        public static final int WAKEUP_STAGE_FIELD_NUMBER = 5;
        public static final int WAKEUP_SUCCESS_FIELD_NUMBER = 6;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private volatile Object eventName_;
        private volatile Object eventReportSource_;
        private MapField<String, String> extra_;
        private byte memoizedIsInitialized;
        private volatile Object rejectReason_;
        private long timestamp_;
        private volatile Object traceId_;
        private List<AssistAudioEventDataTraceViewer> traceViewers_;
        private volatile Object wakeupStage_;
        private boolean wakeupSuccess_;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BreathWakeupEventOrBuilder {
            private int bitField0_;
            private Object eventName_;
            private Object eventReportSource_;
            private MapField<String, String> extra_;
            private Object rejectReason_;
            private long timestamp_;
            private Object traceId_;
            private RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> traceViewersBuilder_;
            private List<AssistAudioEventDataTraceViewer> traceViewers_;
            private Object wakeupStage_;
            private boolean wakeupSuccess_;

            public final boolean isInitialized() {
                return true;
            }

            private void ensureTraceViewersIsMutable() {
                if ((this.bitField0_ & 256) == 256) goto L6;
                this.traceViewers_ = new ArrayList(this.traceViewers_);
                this.bitField0_ |= 256;
                return;
            }

            private RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> getTraceViewersFieldBuilder() {
                if (this.traceViewersBuilder_ != null) goto L10;
                List<AssistAudioEventDataTraceViewer> r1 = this.traceViewers_;
                if ((this.bitField0_ & 256) != 256) goto L7;
                boolean r2 = true;
            L8:
                this.traceViewersBuilder_ = new RepeatedFieldBuilderV3(r1, r2, getParentForChildren(), isClean());
                this.traceViewers_ = null;
                goto L10
            L7:
                r2 = false;
            L10:
                return this.traceViewersBuilder_;
            }

            private MapField<String, String> internalGetExtra() {
                MapField<String, String> r0 = this.extra_;
                if (r0 == null) goto L5;
                return r0;
            L5:
                return MapField.emptyMapField(ExtraDefaultEntryHolder.defaultEntry);
            }

            /* JADX INFO: renamed from: buildPartial, reason: collision with other method in class */
            public BreathWakeupEvent m190buildPartial() {
                BreathWakeupEvent r0 = new BreathWakeupEvent(this, null);
                int r1 = this.bitField0_;
                int r3 = 1;
                if ((r1 & 1) == 1) goto L6;
                r3 = 0;
            L6:
                BreathWakeupEvent.access$9202(r0, this.eventName_);
                if ((r1 & 2) != 2) goto L9;
                r3 = r3 | 2;
            L9:
                BreathWakeupEvent.access$9302(r0, this.eventReportSource_);
                if ((r1 & 4) != 4) goto L12;
                r3 = r3 | 4;
            L12:
                BreathWakeupEvent.access$9402(r0, this.traceId_);
                if ((r1 & 8) != 8) goto L15;
                r3 = r3 | 8;
            L15:
                BreathWakeupEvent.access$9502(r0, this.timestamp_);
                if ((r1 & 16) != 16) goto L18;
                r3 = r3 | 16;
            L18:
                BreathWakeupEvent.access$9602(r0, this.wakeupStage_);
                if ((r1 & 32) != 32) goto L21;
                r3 = r3 | 32;
            L21:
                BreathWakeupEvent.access$9702(r0, this.wakeupSuccess_);
                if ((r1 & 64) != 64) goto L24;
                r3 = r3 | 64;
            L24:
                BreathWakeupEvent.access$9802(r0, this.rejectReason_);
                BreathWakeupEvent.access$9902(r0, internalGetExtra());
                BreathWakeupEvent.access$9900(r0).makeImmutable();
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r2 = this.traceViewersBuilder_;
                if (r2 == null) goto L27;
                BreathWakeupEvent.access$10002(r0, r2.build());
            L31:
                BreathWakeupEvent.access$10102(r0, r3);
                onBuilt();
                return r0;
            L27:
                if ((this.bitField0_ & 256) != 256) goto L29;
                this.traceViewers_ = Collections.unmodifiableList(this.traceViewers_);
                this.bitField0_ &= -257;
            L29:
                BreathWakeupEvent.access$10002(r0, this.traceViewers_);
                goto L31
            }

            public Builder clearEventName() {
                this.bitField0_ &= -2;
                this.eventName_ = BreathWakeupEvent.getDefaultInstance().getEventName();
                onChanged();
                return this;
            }

            public Builder clearEventReportSource() {
                this.bitField0_ &= -3;
                this.eventReportSource_ = BreathWakeupEvent.getDefaultInstance().getEventReportSource();
                onChanged();
                return this;
            }

            public Builder clearRejectReason() {
                this.bitField0_ &= -65;
                this.rejectReason_ = BreathWakeupEvent.getDefaultInstance().getRejectReason();
                onChanged();
                return this;
            }

            public Builder clearTimestamp() {
                this.bitField0_ &= -9;
                this.timestamp_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTraceId() {
                this.bitField0_ &= -5;
                this.traceId_ = BreathWakeupEvent.getDefaultInstance().getTraceId();
                onChanged();
                return this;
            }

            public Builder clearTraceViewers() {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                this.traceViewers_ = Collections.emptyList();
                this.bitField0_ &= -257;
                onChanged();
            L6:
                return this;
            L5:
                r0.clear();
                goto L6
            }

            public Builder clearWakeupStage() {
                this.bitField0_ &= -17;
                this.wakeupStage_ = BreathWakeupEvent.getDefaultInstance().getWakeupStage();
                onChanged();
                return this;
            }

            public Builder clearWakeupSuccess() {
                this.bitField0_ &= -33;
                this.wakeupSuccess_ = false;
                onChanged();
                return this;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
            public String getEventName() {
                Object r0 = this.eventName_;
                if ((r0 instanceof String) == true) goto L9;
                ByteString r1 = (ByteString) r0;
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L7;
                this.eventName_ = r2;
            L7:
                return r2;
            L9:
                return (String) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
            public ByteString getEventNameBytes() {
                Object r0 = this.eventName_;
                if ((r0 instanceof String) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) r0);
                this.eventName_ = r1;
                return r1;
            L7:
                return (ByteString) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
            public String getEventReportSource() {
                Object r0 = this.eventReportSource_;
                if ((r0 instanceof String) == true) goto L9;
                ByteString r1 = (ByteString) r0;
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L7;
                this.eventReportSource_ = r2;
            L7:
                return r2;
            L9:
                return (String) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
            public ByteString getEventReportSourceBytes() {
                Object r0 = this.eventReportSource_;
                if ((r0 instanceof String) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) r0);
                this.eventReportSource_ = r1;
                return r1;
            L7:
                return (ByteString) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
            public String getRejectReason() {
                Object r0 = this.rejectReason_;
                if ((r0 instanceof String) == true) goto L9;
                ByteString r1 = (ByteString) r0;
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L7;
                this.rejectReason_ = r2;
            L7:
                return r2;
            L9:
                return (String) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
            public ByteString getRejectReasonBytes() {
                Object r0 = this.rejectReason_;
                if ((r0 instanceof String) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) r0);
                this.rejectReason_ = r1;
                return r1;
            L7:
                return (ByteString) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
            public String getTraceId() {
                Object r0 = this.traceId_;
                if ((r0 instanceof String) == true) goto L9;
                ByteString r1 = (ByteString) r0;
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L7;
                this.traceId_ = r2;
            L7:
                return r2;
            L9:
                return (String) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
            public ByteString getTraceIdBytes() {
                Object r0 = this.traceId_;
                if ((r0 instanceof String) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) r0);
                this.traceId_ = r1;
                return r1;
            L7:
                return (ByteString) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
            public int getTraceViewersCount() {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L7;
                return this.traceViewers_.size();
            L7:
                return r0.getCount();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
            public List<AssistAudioEventDataTraceViewer> getTraceViewersList() {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L7;
                return Collections.unmodifiableList(this.traceViewers_);
            L7:
                return r0.getMessageList();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
            public List<? extends AssistAudioEventDataTraceViewerOrBuilder> getTraceViewersOrBuilderList() {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 == null) goto L7;
                return r0.getMessageOrBuilderList();
            L7:
                return Collections.unmodifiableList(this.traceViewers_);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
            public String getWakeupStage() {
                Object r0 = this.wakeupStage_;
                if ((r0 instanceof String) == true) goto L9;
                ByteString r1 = (ByteString) r0;
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L7;
                this.wakeupStage_ = r2;
            L7:
                return r2;
            L9:
                return (String) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
            public ByteString getWakeupStageBytes() {
                Object r0 = this.wakeupStage_;
                if ((r0 instanceof String) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) r0);
                this.wakeupStage_ = r1;
                return r1;
            L7:
                return (ByteString) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
            public boolean hasEventName() {
                if ((this.bitField0_ & 1) == 1) goto L7;
                return false;
            L7:
                return true;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
            public boolean hasEventReportSource() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
            public boolean hasRejectReason() {
                if ((this.bitField0_ & 64) != 64) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
            public boolean hasTimestamp() {
                if ((this.bitField0_ & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
            public boolean hasTraceId() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
            public boolean hasWakeupStage() {
                if ((this.bitField0_ & 16) != 16) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
            public boolean hasWakeupSuccess() {
                if ((this.bitField0_ & 32) != 32) goto L5;
                return true;
            L5:
                return false;
            }

            private Builder() {
                this.eventName_ = NameKeys.UnloadStrategy_No_Strategy;
                this.eventReportSource_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceId_ = NameKeys.UnloadStrategy_No_Strategy;
                this.wakeupStage_ = NameKeys.UnloadStrategy_No_Strategy;
                this.rejectReason_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceViewers_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AssistAudioEventProto.access$8500();
            }

            private MapField<String, String> internalGetMutableExtra() {
                onChanged();
                if (this.extra_ != null) goto L6;
                this.extra_ = MapField.newMapField(ExtraDefaultEntryHolder.defaultEntry);
            L6:
                if (this.extra_.isMutable() == true) goto L9;
                this.extra_ = this.extra_.copy();
            L9:
                return this.extra_;
            }

            private void maybeForceBuilderInitialization() {
                if (BreathWakeupEvent.access$9000() == false) goto L6;
                getTraceViewersFieldBuilder();
                return;
            }

            public AssistAudioEventDataTraceViewer.Builder addTraceViewersBuilder() {
                return getTraceViewersFieldBuilder().addBuilder(AssistAudioEventDataTraceViewer.getDefaultInstance());
            }

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public BreathWakeupEvent m188build() {
                BreathWakeupEvent r0 = m190buildPartial();
                if (r0.isInitialized() == false) goto L6;
                return r0;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r0);
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public Builder m194clear() {
                super.clear();
                this.eventName_ = NameKeys.UnloadStrategy_No_Strategy;
                int r1 = this.bitField0_ & (-2);
                this.eventReportSource_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceId_ = NameKeys.UnloadStrategy_No_Strategy;
                this.timestamp_ = 0;
                this.wakeupStage_ = NameKeys.UnloadStrategy_No_Strategy;
                this.wakeupSuccess_ = false;
                this.rejectReason_ = NameKeys.UnloadStrategy_No_Strategy;
                this.bitField0_ = (((((r1 & (-3)) & (-5)) & (-9)) & (-17)) & (-33)) & (-65);
                internalGetMutableExtra().clear();
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                this.traceViewers_ = Collections.emptyList();
                this.bitField0_ &= -257;
            L6:
                return this;
            L5:
                r0.clear();
                goto L6
            }

            public Builder clearExtra() {
                internalGetMutableExtra().getMutableMap().clear();
                return this;
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public Builder m204clone() {
                return (Builder) super.clone();
            }

            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return m207getDefaultInstanceForType();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return AssistAudioEventProto.access$8500();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
            public Map<String, String> getExtra() {
                return getExtraMap();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
            public int getExtraCount() {
                return internalGetExtra().getMap().size();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
            public Map<String, String> getExtraMap() {
                return internalGetExtra().getMap();
            }

            public Map<String, String> getMutableExtra() {
                return internalGetMutableExtra().getMutableMap();
            }

            public List<AssistAudioEventDataTraceViewer.Builder> getTraceViewersBuilderList() {
                return getTraceViewersFieldBuilder().getBuilderList();
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AssistAudioEventProto.access$8600().ensureFieldAccessorsInitialized(BreathWakeupEvent.class, Builder.class);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
            public long getTimestamp() {
                return this.timestamp_;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
            public boolean getWakeupSuccess() {
                return this.wakeupSuccess_;
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m188build();
            }

            public /* bridge */ /* synthetic */ Message buildPartial() {
                return m190buildPartial();
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
                return m194clear();
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
                return m204clone();
            }

            /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite m206getDefaultInstanceForType() {
                return m207getDefaultInstanceForType();
            }

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite m187build() {
                return m188build();
            }

            /* JADX INFO: renamed from: buildPartial, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite m189buildPartial() {
                return m190buildPartial();
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m191clear() {
                return m194clear();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder m200clone() {
                return m204clone();
            }

            /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
            public BreathWakeupEvent m207getDefaultInstanceForType() {
                return BreathWakeupEvent.getDefaultInstance();
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m192clear() {
                return m194clear();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m201clone() {
                return m204clone();
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite.Builder m193clear() {
                return m194clear();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m202clone() {
                return m204clone();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite.Builder m203clone() {
                return m204clone();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m205clone() throws CloneNotSupportedException {
                return m204clone();
            }

            private Builder(GeneratedMessageV3.BuilderParent r1) {
                super(r1);
                this.eventName_ = NameKeys.UnloadStrategy_No_Strategy;
                this.eventReportSource_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceId_ = NameKeys.UnloadStrategy_No_Strategy;
                this.wakeupStage_ = NameKeys.UnloadStrategy_No_Strategy;
                this.rejectReason_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceViewers_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public Builder addAllTraceViewers(Iterable<? extends AssistAudioEventDataTraceViewer> r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                ensureTraceViewersIsMutable();
                AbstractMessageLite.Builder.addAll(r2, this.traceViewers_);
                onChanged();
            L6:
                return this;
            L5:
                r0.addAllMessages(r2);
                goto L6
            }

            public Builder addTraceViewers(AssistAudioEventDataTraceViewer.Builder r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                ensureTraceViewersIsMutable();
                this.traceViewers_.add(r2.m96build());
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2.m96build());
                goto L6
            }

            public AssistAudioEventDataTraceViewer.Builder addTraceViewersBuilder(int r3) {
                return getTraceViewersFieldBuilder().addBuilder(r3, AssistAudioEventDataTraceViewer.getDefaultInstance());
            }

            /* JADX INFO: renamed from: clearField, reason: collision with other method in class */
            public Builder m196clearField(Descriptors.FieldDescriptor r1) {
                return (Builder) super.clearField(r1);
            }

            /* JADX INFO: renamed from: clearOneof, reason: collision with other method in class */
            public Builder m199clearOneof(Descriptors.OneofDescriptor r1) {
                return (Builder) super.clearOneof(r1);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
            public boolean containsExtra(String r2) {
                if (r2 == null) goto L6;
                return internalGetExtra().getMap().containsKey(r2);
            L6:
                throw null;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
            public String getExtraOrThrow(String r3) {
                if (r3 == null) goto L10;
                Map r0 = internalGetExtra().getMap();
                if (r0.containsKey(r3) == false) goto L8;
                return (String) r0.get(r3);
            L8:
                throw new IllegalArgumentException();
            L10:
                throw null;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
            public AssistAudioEventDataTraceViewer getTraceViewers(int r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L7;
                return (AssistAudioEventDataTraceViewer) ListProtector.get(this.traceViewers_, r2);
            L7:
                return r0.getMessage(r2);
            }

            public AssistAudioEventDataTraceViewer.Builder getTraceViewersBuilder(int r2) {
                return getTraceViewersFieldBuilder().getBuilder(r2);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
            public AssistAudioEventDataTraceViewerOrBuilder getTraceViewersOrBuilder(int r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L7;
                return (AssistAudioEventDataTraceViewerOrBuilder) ListProtector.get(this.traceViewers_, r2);
            L7:
                return (AssistAudioEventDataTraceViewerOrBuilder) r0.getMessageOrBuilder(r2);
            }

            public MapField internalGetMapField(int r4) {
                if (r4 != 8) goto L7;
                return internalGetExtra();
            L7:
                throw new RuntimeException("Invalid map field number: " + r4);
            }

            public MapField internalGetMutableMapField(int r4) {
                if (r4 != 8) goto L7;
                return internalGetMutableExtra();
            L7:
                throw new RuntimeException("Invalid map field number: " + r4);
            }

            public Builder mergeFrom(BreathWakeupEvent r3) {
                if (r3 != BreathWakeupEvent.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r3.hasEventName() == false) goto L9;
                this.bitField0_ |= 1;
                this.eventName_ = BreathWakeupEvent.access$9200(r3);
                onChanged();
            L9:
                if (r3.hasEventReportSource() == false) goto L12;
                this.bitField0_ |= 2;
                this.eventReportSource_ = BreathWakeupEvent.access$9300(r3);
                onChanged();
            L12:
                if (r3.hasTraceId() == false) goto L15;
                this.bitField0_ |= 4;
                this.traceId_ = BreathWakeupEvent.access$9400(r3);
                onChanged();
            L15:
                if (r3.hasTimestamp() == false) goto L18;
                setTimestamp(r3.getTimestamp());
            L18:
                if (r3.hasWakeupStage() == false) goto L21;
                this.bitField0_ |= 16;
                this.wakeupStage_ = BreathWakeupEvent.access$9600(r3);
                onChanged();
            L21:
                if (r3.hasWakeupSuccess() == false) goto L24;
                setWakeupSuccess(r3.getWakeupSuccess());
            L24:
                if (r3.hasRejectReason() == false) goto L26;
                this.bitField0_ |= 64;
                this.rejectReason_ = BreathWakeupEvent.access$9800(r3);
                onChanged();
            L26:
                internalGetMutableExtra().mergeFrom(BreathWakeupEvent.access$10200(r3));
                if (this.traceViewersBuilder_ != null) goto L36;
                if (BreathWakeupEvent.access$10000(r3).isEmpty() == false) goto L31;
            L44:
                m216mergeUnknownFields(BreathWakeupEvent.access$10400(r3));
                onChanged();
                return this;
            L31:
                if (this.traceViewers_.isEmpty() == false) goto L33;
                this.traceViewers_ = BreathWakeupEvent.access$10000(r3);
                this.bitField0_ &= -257;
            L34:
                onChanged();
                goto L44
            L33:
                ensureTraceViewersIsMutable();
                this.traceViewers_.addAll(BreathWakeupEvent.access$10000(r3));
                goto L34
            L36:
                if (BreathWakeupEvent.access$10000(r3).isEmpty() == true) goto L44;
                if (this.traceViewersBuilder_.isEmpty() == false) goto L43;
                this.traceViewersBuilder_.dispose();
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = null;
                this.traceViewersBuilder_ = null;
                this.traceViewers_ = BreathWakeupEvent.access$10000(r3);
                this.bitField0_ &= -257;
                if (BreathWakeupEvent.access$10300() == false) goto L42;
                r0 = getTraceViewersFieldBuilder();
            L42:
                this.traceViewersBuilder_ = r0;
                goto L44
            L43:
                this.traceViewersBuilder_.addAllMessages(BreathWakeupEvent.access$10000(r3));
                goto L44
            }

            /* JADX INFO: renamed from: mergeUnknownFields, reason: collision with other method in class */
            public final Builder m216mergeUnknownFields(UnknownFieldSet r1) {
                return (Builder) super.mergeUnknownFields(r1);
            }

            public Builder putAllExtra(Map<String, String> r2) {
                internalGetMutableExtra().getMutableMap().putAll(r2);
                return this;
            }

            public Builder removeExtra(String r2) {
                if (r2 == null) goto L6;
                internalGetMutableExtra().getMutableMap().remove(r2);
                return this;
            L6:
                throw null;
            }

            public Builder removeTraceViewers(int r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                ensureTraceViewersIsMutable();
                ListProtector.remove(this.traceViewers_, r2);
                onChanged();
            L6:
                return this;
            L5:
                r0.remove(r2);
                goto L6
            }

            public Builder setEventName(String r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 1;
                this.eventName_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setEventNameBytes(ByteString r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 1;
                this.eventName_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setEventReportSource(String r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 2;
                this.eventReportSource_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setEventReportSourceBytes(ByteString r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 2;
                this.eventReportSource_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setRejectReason(String r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 64;
                this.rejectReason_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setRejectReasonBytes(ByteString r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 64;
                this.rejectReason_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setTimestamp(long r2) {
                this.bitField0_ |= 8;
                this.timestamp_ = r2;
                onChanged();
                return this;
            }

            public Builder setTraceId(String r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 4;
                this.traceId_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setTraceIdBytes(ByteString r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 4;
                this.traceId_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            /* JADX INFO: renamed from: setUnknownFields, reason: collision with other method in class */
            public final Builder m222setUnknownFields(UnknownFieldSet r1) {
                return (Builder) super.setUnknownFields(r1);
            }

            public Builder setWakeupStage(String r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 16;
                this.wakeupStage_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setWakeupStageBytes(ByteString r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 16;
                this.wakeupStage_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setWakeupSuccess(boolean r2) {
                this.bitField0_ |= 32;
                this.wakeupSuccess_ = r2;
                onChanged();
                return this;
            }

            public /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            public Builder addTraceViewers(AssistAudioEventDataTraceViewer r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L8;
                if (r2 == null) goto L7;
                ensureTraceViewersIsMutable();
                this.traceViewers_.add(r2);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.addMessage(r2);
                goto L9
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearField(Descriptors.FieldDescriptor r1) {
                return m196clearField(r1);
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r1) {
                return m199clearOneof(r1);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public Builder m213mergeFrom(Message r2) {
                if ((r2 instanceof BreathWakeupEvent) == true) goto L5;
                super/*com.google.protobuf.AbstractMessage.Builder*/.mergeFrom(r2);
                return this;
            L5:
                return mergeFrom((BreathWakeupEvent) r2);
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r1) {
                return m216mergeUnknownFields(r1);
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r1) {
                return m222setUnknownFields(r1);
            }

            /* JADX INFO: renamed from: clearField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m195clearField(Descriptors.FieldDescriptor r1) {
                return m196clearField(r1);
            }

            /* JADX INFO: renamed from: clearOneof, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m197clearOneof(Descriptors.OneofDescriptor r1) {
                return m199clearOneof(r1);
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r1) {
                return m213mergeFrom(r1);
            }

            /* JADX INFO: renamed from: mergeUnknownFields, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m214mergeUnknownFields(UnknownFieldSet r1) {
                return m216mergeUnknownFields(r1);
            }

            /* JADX INFO: renamed from: setUnknownFields, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m221setUnknownFields(UnknownFieldSet r1) {
                return m222setUnknownFields(r1);
            }

            /* JADX INFO: renamed from: clearOneof, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m198clearOneof(Descriptors.OneofDescriptor r1) {
                return m199clearOneof(r1);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m210mergeFrom(Message r1) {
                return m213mergeFrom(r1);
            }

            /* JADX INFO: renamed from: mergeUnknownFields, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m215mergeUnknownFields(UnknownFieldSet r1) {
                return m216mergeUnknownFields(r1);
            }

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r1, AnonymousClass1 r2) {
                this(r1);
            }

            /* JADX INFO: renamed from: addRepeatedField, reason: collision with other method in class */
            public Builder m186addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
                return (Builder) super.addRepeatedField(r1, r2);
            }

            public Builder addTraceViewers(int r2, AssistAudioEventDataTraceViewer.Builder r3) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                ensureTraceViewersIsMutable();
                ListProtector.add(this.traceViewers_, r2, r3.m96build());
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2, r3.m96build());
                goto L6
            }

            @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
            public String getExtraOrDefault(String r3, String r4) {
                if (r3 == null) goto L8;
                Map r0 = internalGetExtra().getMap();
                if (r0.containsKey(r3) == true) goto L6;
                return r4;
            L6:
                return (String) r0.get(r3);
            L8:
                throw null;
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public Builder m212mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                BreathWakeupEvent r0 = null;
                BreathWakeupEvent r5 = (BreathWakeupEvent) BreathWakeupEvent.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                BreathWakeupEvent r6 = (BreathWakeupEvent) e.getUnfinishedMessage();     // Catch: Throwable -> L7
            L13:
                th = th;
                r0 = r6;
            L15:
                if (r0 == null) goto L17;
                mergeFrom(r0);
            L17:
                throw th;
            L12:
                throw e.unwrapIOException();     // Catch: Throwable -> L13
            L7:
                th = th;
                goto L15
            }

            public Builder putExtra(String r2, String r3) {
                if (r2 == null) goto L8;
                if (r3 == null) goto L7;
                internalGetMutableExtra().getMutableMap().put(r2, r3);
                return this;
            L7:
                throw null;
            L8:
                throw null;
            }

            /* JADX INFO: renamed from: setField, reason: collision with other method in class */
            public Builder m218setField(Descriptors.FieldDescriptor r1, Object r2) {
                return (Builder) super.setField(r1, r2);
            }

            public Builder setTraceViewers(int r2, AssistAudioEventDataTraceViewer.Builder r3) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                ensureTraceViewersIsMutable();
                ListProtector.set(this.traceViewers_, r2, r3.m96build());
                onChanged();
            L6:
                return this;
            L5:
                r0.setMessage(r2, r3.m96build());
                goto L6
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
                return m186addRepeatedField(r1, r2);
            }

            public Builder addTraceViewers(int r2, AssistAudioEventDataTraceViewer r3) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L8;
                if (r3 == null) goto L7;
                ensureTraceViewersIsMutable();
                ListProtector.add(this.traceViewers_, r2, r3);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.addMessage(r2, r3);
                goto L9
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m212mergeFrom(r1, r2);
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setField(Descriptors.FieldDescriptor r1, Object r2) {
                return m218setField(r1, r2);
            }

            public Builder setTraceViewers(int r2, AssistAudioEventDataTraceViewer r3) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L8;
                if (r3 == null) goto L7;
                ensureTraceViewersIsMutable();
                ListProtector.set(this.traceViewers_, r2, r3);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.setMessage(r2, r3);
                goto L9
            }

            /* JADX INFO: renamed from: addRepeatedField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m185addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
                return m186addRepeatedField(r1, r2);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder m208mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m212mergeFrom(r1, r2);
            }

            /* JADX INFO: renamed from: setField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m217setField(Descriptors.FieldDescriptor r1, Object r2) {
                return m218setField(r1, r2);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m209mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m212mergeFrom(r1, r2);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite.Builder m211mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m212mergeFrom(r1, r2);
            }

            /* JADX INFO: renamed from: setRepeatedField, reason: collision with other method in class */
            public Builder m220setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
                return (Builder) super.setRepeatedField(r1, r2, r3);
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
                return m220setRepeatedField(r1, r2, r3);
            }

            /* JADX INFO: renamed from: setRepeatedField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m219setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
                return m220setRepeatedField(r1, r2, r3);
            }
        }

        public static final class ExtraDefaultEntryHolder {
            static final MapEntry<String, String> defaultEntry = null;

            private ExtraDefaultEntryHolder() {
            }

            static {
                Descriptors.Descriptor r0 = AssistAudioEventProto.access$8700();
                WireFormat.FieldType r1 = WireFormat.FieldType.STRING;
                defaultEntry = MapEntry.newDefaultInstance(r0, r1, NameKeys.UnloadStrategy_No_Strategy, r1, NameKeys.UnloadStrategy_No_Strategy);
            }
        }

        static {
            DEFAULT_INSTANCE = new BreathWakeupEvent();
            PARSER = new AnonymousClass1();
        }

        private MapField<String, String> internalGetExtra() {
            MapField<String, String> r0 = this.extra_;
            if (r0 == null) goto L5;
            return r0;
        L5:
            return MapField.emptyMapField(ExtraDefaultEntryHolder.defaultEntry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m183toBuilder();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
        public String getEventName() {
            Object r0 = this.eventName_;
            if ((r0 instanceof String) == true) goto L5;
            ByteString r1 = (ByteString) r0;
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L9;
            this.eventName_ = r2;
        L9:
            return r2;
        L5:
            return (String) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
        public ByteString getEventNameBytes() {
            Object r0 = this.eventName_;
            if ((r0 instanceof String) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) r0);
            this.eventName_ = r1;
            return r1;
        L7:
            return (ByteString) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
        public String getEventReportSource() {
            Object r0 = this.eventReportSource_;
            if ((r0 instanceof String) == true) goto L5;
            ByteString r1 = (ByteString) r0;
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L9;
            this.eventReportSource_ = r2;
        L9:
            return r2;
        L5:
            return (String) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
        public ByteString getEventReportSourceBytes() {
            Object r0 = this.eventReportSource_;
            if ((r0 instanceof String) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) r0);
            this.eventReportSource_ = r1;
            return r1;
        L7:
            return (ByteString) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
        public String getRejectReason() {
            Object r0 = this.rejectReason_;
            if ((r0 instanceof String) == true) goto L5;
            ByteString r1 = (ByteString) r0;
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L9;
            this.rejectReason_ = r2;
        L9:
            return r2;
        L5:
            return (String) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
        public ByteString getRejectReasonBytes() {
            Object r0 = this.rejectReason_;
            if ((r0 instanceof String) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) r0);
            this.rejectReason_ = r1;
            return r1;
        L7:
            return (ByteString) r0;
        }

        public int getSerializedSize() {
            int r0 = ((AbstractMessage) this).memoizedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r2 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r1 = GeneratedMessageV3.computeStringSize(1, this.eventName_) + 0;
        L10:
            if ((this.bitField0_ & 2) != 2) goto L13;
            r1 = r1 + GeneratedMessageV3.computeStringSize(2, this.eventReportSource_);
        L13:
            if ((this.bitField0_ & 4) != 4) goto L16;
            r1 = r1 + GeneratedMessageV3.computeStringSize(3, this.traceId_);
        L16:
            if ((this.bitField0_ & 8) != 8) goto L19;
            r1 = r1 + CodedOutputStream.computeInt64Size(4, this.timestamp_);
        L19:
            if ((this.bitField0_ & 16) != 16) goto L22;
            r1 = r1 + GeneratedMessageV3.computeStringSize(5, this.wakeupStage_);
        L22:
            if ((this.bitField0_ & 32) != 32) goto L25;
            r1 = r1 + CodedOutputStream.computeBoolSize(6, this.wakeupSuccess_);
        L25:
            if ((this.bitField0_ & 64) != 64) goto L27;
            r1 = r1 + GeneratedMessageV3.computeStringSize(7, this.rejectReason_);
        L27:
            Iterator r3 = internalGetExtra().getMap().entrySet().iterator();
        L29:
            if (r3.hasNext() == false) goto L32;
            Map.Entry r4 = (Map.Entry) r3.next();
            r1 = r1 + CodedOutputStream.computeMessageSize(8, ExtraDefaultEntryHolder.defaultEntry.newBuilderForType().setKey((String) r4.getKey()).setValue((String) r4.getValue()).build());
        L32:
            if (r2 >= this.traceViewers_.size()) goto L34;
            r1 = r1 + CodedOutputStream.computeMessageSize(9, (MessageLite) ListProtector.get(this.traceViewers_, r2));
            r2 = r2 + 1;
            goto L32
        L34:
            int r5 = r1 + ((GeneratedMessageV3) this).unknownFields.getSerializedSize();
            ((AbstractMessage) this).memoizedSize = r5;
            return r5;
        L8:
            r1 = 0;
            goto L10
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
        public String getTraceId() {
            Object r0 = this.traceId_;
            if ((r0 instanceof String) == true) goto L5;
            ByteString r1 = (ByteString) r0;
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L9;
            this.traceId_ = r2;
        L9:
            return r2;
        L5:
            return (String) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
        public ByteString getTraceIdBytes() {
            Object r0 = this.traceId_;
            if ((r0 instanceof String) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) r0);
            this.traceId_ = r1;
            return r1;
        L7:
            return (ByteString) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
        public int getTraceViewersCount() {
            return this.traceViewers_.size();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
        public String getWakeupStage() {
            Object r0 = this.wakeupStage_;
            if ((r0 instanceof String) == true) goto L5;
            ByteString r1 = (ByteString) r0;
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L9;
            this.wakeupStage_ = r2;
        L9:
            return r2;
        L5:
            return (String) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
        public ByteString getWakeupStageBytes() {
            Object r0 = this.wakeupStage_;
            if ((r0 instanceof String) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) r0);
            this.wakeupStage_ = r1;
            return r1;
        L7:
            return (ByteString) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
        public boolean hasEventName() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
        public boolean hasEventReportSource() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
        public boolean hasRejectReason() {
            if ((this.bitField0_ & 64) != 64) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
        public boolean hasTimestamp() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
        public boolean hasTraceId() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
        public boolean hasWakeupStage() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
        public boolean hasWakeupSuccess() {
            if ((this.bitField0_ & 32) != 32) goto L5;
            return true;
        L5:
            return false;
        }

        public int hashCode() {
            int r0 = ((AbstractMessageLite) this).memoizedHashCode;
            if (r0 == 0) goto L5;
            return r0;
        L5:
            int r1 = 779 + getDescriptor().hashCode();
            if (hasEventName() == false) goto L9;
            r1 = (((r1 * 37) + 1) * 53) + getEventName().hashCode();
        L9:
            if (hasEventReportSource() == false) goto L12;
            r1 = (((r1 * 37) + 2) * 53) + getEventReportSource().hashCode();
        L12:
            if (hasTraceId() == false) goto L15;
            r1 = (((r1 * 37) + 3) * 53) + getTraceId().hashCode();
        L15:
            if (hasTimestamp() == false) goto L18;
            r1 = (((r1 * 37) + 4) * 53) + Internal.hashLong(getTimestamp());
        L18:
            if (hasWakeupStage() == false) goto L21;
            r1 = (((r1 * 37) + 5) * 53) + getWakeupStage().hashCode();
        L21:
            if (hasWakeupSuccess() == false) goto L24;
            r1 = (((r1 * 37) + 6) * 53) + Internal.hashBoolean(getWakeupSuccess());
        L24:
            if (hasRejectReason() == false) goto L27;
            r1 = (((r1 * 37) + 7) * 53) + getRejectReason().hashCode();
        L27:
            if (internalGetExtra().getMap().isEmpty() == true) goto L30;
            r1 = (((r1 * 37) + 8) * 53) + internalGetExtra().hashCode();
        L30:
            if (getTraceViewersCount() <= 0) goto L32;
            r1 = (((r1 * 37) + 9) * 53) + getTraceViewersList().hashCode();
        L32:
            int r2 = (r1 * 29) + ((GeneratedMessageV3) this).unknownFields.hashCode();
            ((AbstractMessageLite) this).memoizedHashCode = r2;
            return r2;
        }

        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L5;
            return true;
        L5:
            if (r0 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        /* JADX INFO: renamed from: toBuilder, reason: collision with other method in class */
        public Builder m183toBuilder() {
            AnonymousClass1 r1 = null;
            if (this != DEFAULT_INSTANCE) goto L6;
            return new Builder(r1);
        L6:
            return new Builder(r1).mergeFrom(this);
        }

        private BreathWakeupEvent() {
            this.memoizedIsInitialized = -1;
            this.eventName_ = NameKeys.UnloadStrategy_No_Strategy;
            this.eventReportSource_ = NameKeys.UnloadStrategy_No_Strategy;
            this.traceId_ = NameKeys.UnloadStrategy_No_Strategy;
            this.timestamp_ = 0;
            this.wakeupStage_ = NameKeys.UnloadStrategy_No_Strategy;
            this.wakeupSuccess_ = false;
            this.rejectReason_ = NameKeys.UnloadStrategy_No_Strategy;
            this.traceViewers_ = Collections.emptyList();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AssistAudioEventProto.access$8500();
        }

        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return m178getDefaultInstanceForType();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
        public Map<String, String> getExtra() {
            return getExtraMap();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
        public int getExtraCount() {
            return internalGetExtra().getMap().size();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
        public Map<String, String> getExtraMap() {
            return internalGetExtra().getMap();
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AssistAudioEventProto.access$8600().ensureFieldAccessorsInitialized(BreathWakeupEvent.class, Builder.class);
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return m180newBuilderForType();
        }

        public static /* synthetic */ boolean access$10300() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ boolean access$9000() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static BreathWakeupEvent getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BreathWakeupEvent> parser() {
            return PARSER;
        }

        public Parser<BreathWakeupEvent> getParserForType() {
            return PARSER;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
        public List<AssistAudioEventDataTraceViewer> getTraceViewersList() {
            return this.traceViewers_;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
        public List<? extends AssistAudioEventDataTraceViewerOrBuilder> getTraceViewersOrBuilderList() {
            return this.traceViewers_;
        }

        public final UnknownFieldSet getUnknownFields() {
            return ((GeneratedMessageV3) this).unknownFields;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
        public boolean getWakeupSuccess() {
            return this.wakeupSuccess_;
        }

        /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite m177getDefaultInstanceForType() {
            return m178getDefaultInstanceForType();
        }

        /* JADX INFO: renamed from: newBuilderForType, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite.Builder m179newBuilderForType() {
            return m180newBuilderForType();
        }

        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return m183toBuilder();
        }

        /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
        public BreathWakeupEvent m178getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: renamed from: newBuilderForType, reason: collision with other method in class */
        public Builder m180newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: renamed from: toBuilder, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite.Builder m182toBuilder() {
            return m183toBuilder();
        }

        private BreathWakeupEvent(GeneratedMessageV3.Builder<?> r1) {
            super(r1);
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ List access$10000(BreathWakeupEvent r0) {
            return r0.traceViewers_;
        }

        public static /* synthetic */ MapField access$10200(BreathWakeupEvent r0) {
            return r0.internalGetExtra();
        }

        public static /* synthetic */ UnknownFieldSet access$10400(BreathWakeupEvent r0) {
            return ((GeneratedMessageV3) r0).unknownFields;
        }

        public static /* synthetic */ Object access$9200(BreathWakeupEvent r0) {
            return r0.eventName_;
        }

        public static /* synthetic */ Object access$9300(BreathWakeupEvent r0) {
            return r0.eventReportSource_;
        }

        public static /* synthetic */ Object access$9400(BreathWakeupEvent r0) {
            return r0.traceId_;
        }

        public static /* synthetic */ Object access$9600(BreathWakeupEvent r0) {
            return r0.wakeupStage_;
        }

        public static /* synthetic */ Object access$9800(BreathWakeupEvent r0) {
            return r0.rejectReason_;
        }

        public static /* synthetic */ MapField access$9900(BreathWakeupEvent r0) {
            return r0.extra_;
        }

        public static Builder newBuilder(BreathWakeupEvent r1) {
            return DEFAULT_INSTANCE.m183toBuilder().mergeFrom(r1);
        }

        public static BreathWakeupEvent parseDelimitedFrom(InputStream r1) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r1);
        }

        public static BreathWakeupEvent parseFrom(ByteString r1) throws InvalidProtocolBufferException {
            return (BreathWakeupEvent) PARSER.parseFrom(r1);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
        public boolean containsExtra(String r2) {
            if (r2 == null) goto L6;
            return internalGetExtra().getMap().containsKey(r2);
        L6:
            throw null;
        }

        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof BreathWakeupEvent) == false) goto L8;
            BreathWakeupEvent r9 = (BreathWakeupEvent) r8;
            if (hasEventName() != r9.hasEventName()) goto L12;
            boolean r1 = true;
        L14:
            if (hasEventName() == false) goto L20;
            if (r1 == true) goto L17;
        L19:
            r1 = false;
            goto L20
        L17:
            if (getEventName().equals(r9.getEventName()) == false) goto L19;
            r1 = true;
        L20:
            if (r1 == true) goto L22;
        L24:
            boolean r2 = false;
        L26:
            if (hasEventReportSource() == false) goto L32;
            if (r2 == true) goto L29;
        L31:
            r2 = false;
            goto L32
        L29:
            if (getEventReportSource().equals(r9.getEventReportSource()) == false) goto L31;
            r2 = true;
        L32:
            if (r2 == true) goto L34;
        L36:
            boolean r3 = false;
        L38:
            if (hasTraceId() == false) goto L44;
            if (r3 == true) goto L41;
        L43:
            r3 = false;
            goto L44
        L41:
            if (getTraceId().equals(r9.getTraceId()) == false) goto L43;
            r3 = true;
        L44:
            if (r3 == true) goto L46;
        L48:
            boolean r4 = false;
        L50:
            if (hasTimestamp() == false) goto L56;
            if (r4 == true) goto L53;
        L55:
            r4 = false;
            goto L56
        L53:
            if (getTimestamp() != r9.getTimestamp()) goto L55;
            r4 = true;
        L56:
            if (r4 == true) goto L58;
        L60:
            boolean r5 = false;
        L62:
            if (hasWakeupStage() == false) goto L68;
            if (r5 == true) goto L65;
        L67:
            r5 = false;
            goto L68
        L65:
            if (getWakeupStage().equals(r9.getWakeupStage()) == false) goto L67;
            r5 = true;
        L68:
            if (r5 == true) goto L70;
        L72:
            boolean r6 = false;
        L74:
            if (hasWakeupSuccess() == false) goto L80;
            if (r6 == true) goto L77;
        L79:
            r6 = false;
            goto L80
        L77:
            if (getWakeupSuccess() != r9.getWakeupSuccess()) goto L79;
            r6 = true;
        L80:
            if (r6 == true) goto L82;
        L84:
            boolean r7 = false;
        L86:
            if (hasRejectReason() == false) goto L92;
            if (r7 == true) goto L89;
        L91:
            r7 = false;
            goto L92
        L89:
            if (getRejectReason().equals(r9.getRejectReason()) == false) goto L91;
            r7 = true;
        L92:
            if (r7 == true) goto L94;
        L96:
            boolean r10 = false;
        L97:
            if (r10 == true) goto L99;
        L101:
            boolean r11 = false;
        L102:
            if (r11 == true) goto L104;
        L106:
            return false;
        L104:
            if (((GeneratedMessageV3) this).unknownFields.equals(((GeneratedMessageV3) r9).unknownFields) == false) goto L106;
            return true;
        L99:
            if (getTraceViewersList().equals(r9.getTraceViewersList()) == false) goto L101;
            r11 = true;
            goto L102
        L94:
            if (internalGetExtra().equals(r9.internalGetExtra()) == false) goto L96;
            r10 = true;
            goto L97
        L82:
            if (hasRejectReason() != r9.hasRejectReason()) goto L84;
            r7 = true;
            goto L86
        L70:
            if (hasWakeupSuccess() != r9.hasWakeupSuccess()) goto L72;
            r6 = true;
            goto L74
        L58:
            if (hasWakeupStage() != r9.hasWakeupStage()) goto L60;
            r5 = true;
            goto L62
        L46:
            if (hasTimestamp() != r9.hasTimestamp()) goto L48;
            r4 = true;
            goto L50
        L34:
            if (hasTraceId() != r9.hasTraceId()) goto L36;
            r3 = true;
            goto L38
        L22:
            if (hasEventReportSource() != r9.hasEventReportSource()) goto L24;
            r2 = true;
            goto L26
        L12:
            r1 = false;
            goto L14
        L8:
            return super/*com.google.protobuf.AbstractMessage*/.equals(r8);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
        public String getExtraOrThrow(String r3) {
            if (r3 == null) goto L10;
            Map r0 = internalGetExtra().getMap();
            if (r0.containsKey(r3) == false) goto L8;
            return (String) r0.get(r3);
        L8:
            throw new IllegalArgumentException();
        L10:
            throw null;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
        public AssistAudioEventDataTraceViewer getTraceViewers(int r2) {
            return (AssistAudioEventDataTraceViewer) ListProtector.get(this.traceViewers_, r2);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
        public AssistAudioEventDataTraceViewerOrBuilder getTraceViewersOrBuilder(int r2) {
            return (AssistAudioEventDataTraceViewerOrBuilder) ListProtector.get(this.traceViewers_, r2);
        }

        public MapField internalGetMapField(int r4) {
            if (r4 != 8) goto L7;
            return internalGetExtra();
        L7:
            throw new RuntimeException("Invalid map field number: " + r4);
        }

        /* JADX INFO: renamed from: newBuilderForType, reason: collision with other method in class */
        public Builder m181newBuilderForType(GeneratedMessageV3.BuilderParent r3) {
            return new Builder(r3, null);
        }

        public void writeTo(CodedOutputStream r6) throws IOException {
            if ((this.bitField0_ & 1) != 1) goto L6;
            GeneratedMessageV3.writeString(r6, 1, this.eventName_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            GeneratedMessageV3.writeString(r6, 2, this.eventReportSource_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L12;
            GeneratedMessageV3.writeString(r6, 3, this.traceId_);
        L12:
            if ((this.bitField0_ & 8) != 8) goto L15;
            r6.writeInt64(4, this.timestamp_);
        L15:
            if ((this.bitField0_ & 16) != 16) goto L18;
            GeneratedMessageV3.writeString(r6, 5, this.wakeupStage_);
        L18:
            if ((this.bitField0_ & 32) != 32) goto L21;
            r6.writeBool(6, this.wakeupSuccess_);
        L21:
            if ((this.bitField0_ & 64) != 64) goto L23;
            GeneratedMessageV3.writeString(r6, 7, this.rejectReason_);
        L23:
            GeneratedMessageV3.serializeStringMapTo(r6, internalGetExtra(), ExtraDefaultEntryHolder.defaultEntry, 8);
            int r0 = 0;
        L25:
            if (r0 >= this.traceViewers_.size()) goto L27;
            r6.writeMessage(9, (MessageLite) ListProtector.get(this.traceViewers_, r0));
            r0 = r0 + 1;
            goto L25
        L27:
            ((GeneratedMessageV3) this).unknownFields.writeTo(r6);
        }

        public static BreathWakeupEvent parseFrom(CodedInputStream r1) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1);
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r1) {
            return m181newBuilderForType(r1);
        }

        public static BreathWakeupEvent parseFrom(InputStream r1) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1);
        }

        public static BreathWakeupEvent parseFrom(ByteBuffer r1) throws InvalidProtocolBufferException {
            return (BreathWakeupEvent) PARSER.parseFrom(r1);
        }

        public static BreathWakeupEvent parseFrom(byte[] r1) throws InvalidProtocolBufferException {
            return (BreathWakeupEvent) PARSER.parseFrom(r1);
        }

        private BreathWakeupEvent(CodedInputStream r9, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
            this();
            if (r10 == null) goto L66;
            UnknownFieldSet.Builder r0 = UnknownFieldSet.newBuilder();
            boolean r1 = false;
            int r2 = 0;
        L6:
            if (r1 == true) goto L61;
            int r4 = r9.readTag();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            if (r4 == 0) goto L46;
            if (r4 != 10) goto L12;
            ByteString r5 = r9.readBytes();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.bitField0_ = 1 | this.bitField0_;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.eventName_ = r5;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L6
        L12:
            if (r4 != 18) goto L14;
            ByteString r6 = r9.readBytes();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.bitField0_ |= 2;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.eventReportSource_ = r6;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L6
        L14:
            if (r4 != 26) goto L16;
            ByteString r7 = r9.readBytes();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.bitField0_ |= 4;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.traceId_ = r7;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L6
        L16:
            if (r4 != 32) goto L18;
            this.bitField0_ |= 8;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.timestamp_ = r9.readInt64();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L6
        L18:
            if (r4 != 42) goto L20;
            ByteString r8 = r9.readBytes();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.bitField0_ |= 16;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.wakeupStage_ = r8;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L6
        L20:
            if (r4 != 48) goto L22;
            this.bitField0_ |= 32;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.wakeupSuccess_ = r9.readBool();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L6
        L22:
            if (r4 != 58) goto L24;
            ByteString r11 = r9.readBytes();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.bitField0_ |= 64;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.rejectReason_ = r11;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L6
        L24:
            if (r4 != 66) goto L26;
            if ((r2 & LynxTouchEvent.kPseudoStateFocusTransition) == 128) goto L37;
            this.extra_ = MapField.newMapField(ExtraDefaultEntryHolder.defaultEntry);     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            r2 = r2 | LynxTouchEvent.kPseudoStateFocusTransition;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
        L37:
            MapEntry r12 = r9.readMessage(ExtraDefaultEntryHolder.defaultEntry.getParserForType(), r10);     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.extra_.getMutableMap().put((String) r12.getKey(), (String) r12.getValue());     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L6
        L26:
            if (r4 != 74) goto L28;
            if ((r2 & 256) == 256) goto L33;
            this.traceViewers_ = new ArrayList();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            r2 = r2 | 256;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
        L33:
            this.traceViewers_.add((AssistAudioEventDataTraceViewer) r9.readMessage(AssistAudioEventDataTraceViewer.PARSER, r10));     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L6
        L28:
            if (parseUnknownField(r9, r0, r10, r4) == true) goto L6;
        L46:
            r1 = true;
            goto L6
        L47:
            th = move-exception;
            if ((r2 & 256) != 256) goto L58;
            this.traceViewers_ = Collections.unmodifiableList(this.traceViewers_);
        L58:
            ((GeneratedMessageV3) this).unknownFields = r0.build();
            makeExtensionsImmutable();
            throw th;
        L49:
            e = move-exception;
            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L47
        L52:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L47
        L61:
            if ((r2 & 256) != 256) goto L63;
            this.traceViewers_ = Collections.unmodifiableList(this.traceViewers_);
        L63:
            ((GeneratedMessageV3) this).unknownFields = r0.build();
            makeExtensionsImmutable();
            return;
        L66:
            throw null;
        }

        public static /* synthetic */ List access$10002(BreathWakeupEvent r0, List r1) {
            r0.traceViewers_ = r1;
            return r1;
        }

        public static /* synthetic */ int access$10102(BreathWakeupEvent r0, int r1) {
            r0.bitField0_ = r1;
            return r1;
        }

        public static /* synthetic */ Object access$9202(BreathWakeupEvent r0, Object r1) {
            r0.eventName_ = r1;
            return r1;
        }

        public static /* synthetic */ Object access$9302(BreathWakeupEvent r0, Object r1) {
            r0.eventReportSource_ = r1;
            return r1;
        }

        public static /* synthetic */ Object access$9402(BreathWakeupEvent r0, Object r1) {
            r0.traceId_ = r1;
            return r1;
        }

        public static /* synthetic */ long access$9502(BreathWakeupEvent r0, long r1) {
            r0.timestamp_ = r1;
            return r1;
        }

        public static /* synthetic */ Object access$9602(BreathWakeupEvent r0, Object r1) {
            r0.wakeupStage_ = r1;
            return r1;
        }

        public static /* synthetic */ boolean access$9702(BreathWakeupEvent r0, boolean r1) {
            r0.wakeupSuccess_ = r1;
            return r1;
        }

        public static /* synthetic */ Object access$9802(BreathWakeupEvent r0, Object r1) {
            r0.rejectReason_ = r1;
            return r1;
        }

        public static /* synthetic */ MapField access$9902(BreathWakeupEvent r0, MapField r1) {
            r0.extra_ = r1;
            return r1;
        }

        public static BreathWakeupEvent parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r1, r2);
        }

        public static BreathWakeupEvent parseFrom(ByteString r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
            return (BreathWakeupEvent) PARSER.parseFrom(r1, r2);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.BreathWakeupEventOrBuilder
        public String getExtraOrDefault(String r3, String r4) {
            if (r3 == null) goto L8;
            Map r0 = internalGetExtra().getMap();
            if (r0.containsKey(r3) == true) goto L6;
            return r4;
        L6:
            return (String) r0.get(r3);
        L8:
            throw null;
        }

        public /* synthetic */ BreathWakeupEvent(GeneratedMessageV3.Builder r1, AnonymousClass1 r2) {
            this(r1);
        }

        public static BreathWakeupEvent parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1, r2);
        }

        public static BreathWakeupEvent parseFrom(InputStream r1, ExtensionRegistryLite r2) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1, r2);
        }

        public static BreathWakeupEvent parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
            return (BreathWakeupEvent) PARSER.parseFrom(r1, r2);
        }

        public static BreathWakeupEvent parseFrom(byte[] r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
            return (BreathWakeupEvent) PARSER.parseFrom(r1, r2);
        }

        public /* synthetic */ BreathWakeupEvent(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }
    }

    public interface BreathWakeupEventOrBuilder extends MessageOrBuilder {
        boolean containsExtra(String r1);

        String getEventName();

        ByteString getEventNameBytes();

        String getEventReportSource();

        ByteString getEventReportSourceBytes();

        Map<String, String> getExtra();

        int getExtraCount();

        Map<String, String> getExtraMap();

        String getExtraOrDefault(String r1, String r2);

        String getExtraOrThrow(String r1);

        String getRejectReason();

        ByteString getRejectReasonBytes();

        long getTimestamp();

        String getTraceId();

        ByteString getTraceIdBytes();

        AssistAudioEventDataTraceViewer getTraceViewers(int r1);

        int getTraceViewersCount();

        List<AssistAudioEventDataTraceViewer> getTraceViewersList();

        AssistAudioEventDataTraceViewerOrBuilder getTraceViewersOrBuilder(int r1);

        List<? extends AssistAudioEventDataTraceViewerOrBuilder> getTraceViewersOrBuilderList();

        String getWakeupStage();

        ByteString getWakeupStageBytes();

        boolean getWakeupSuccess();

        boolean hasEventName();

        boolean hasEventReportSource();

        boolean hasRejectReason();

        boolean hasTimestamp();

        boolean hasTraceId();

        boolean hasWakeupStage();

        boolean hasWakeupSuccess();
    }

    public static final class RealtimeCallDuration extends GeneratedMessageV3 implements RealtimeCallDurationOrBuilder {
        private static final RealtimeCallDuration DEFAULT_INSTANCE = null;
        public static final int END_TIMESTAMP_FIELD_NUMBER = 5;
        public static final int EVENT_NAME_FIELD_NUMBER = 1;
        public static final int EVENT_REPORT_SOURCE_FIELD_NUMBER = 2;
        public static final int EXTRA_FIELD_NUMBER = 6;
        public static final Parser<RealtimeCallDuration> PARSER = null;
        public static final int START_TIMESTAMP_FIELD_NUMBER = 4;
        public static final int TRACE_ID_FIELD_NUMBER = 3;
        public static final int TRACE_VIEWERS_FIELD_NUMBER = 7;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private long endTimestamp_;
        private volatile Object eventName_;
        private volatile Object eventReportSource_;
        private MapField<String, String> extra_;
        private byte memoizedIsInitialized;
        private long startTimestamp_;
        private volatile Object traceId_;
        private List<AssistAudioEventDataTraceViewer> traceViewers_;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RealtimeCallDurationOrBuilder {
            private int bitField0_;
            private long endTimestamp_;
            private Object eventName_;
            private Object eventReportSource_;
            private MapField<String, String> extra_;
            private long startTimestamp_;
            private Object traceId_;
            private RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> traceViewersBuilder_;
            private List<AssistAudioEventDataTraceViewer> traceViewers_;

            public final boolean isInitialized() {
                return true;
            }

            private void ensureTraceViewersIsMutable() {
                if ((this.bitField0_ & 64) == 64) goto L6;
                this.traceViewers_ = new ArrayList(this.traceViewers_);
                this.bitField0_ |= 64;
                return;
            }

            private RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> getTraceViewersFieldBuilder() {
                if (this.traceViewersBuilder_ != null) goto L10;
                List<AssistAudioEventDataTraceViewer> r1 = this.traceViewers_;
                if ((this.bitField0_ & 64) != 64) goto L7;
                boolean r2 = true;
            L8:
                this.traceViewersBuilder_ = new RepeatedFieldBuilderV3(r1, r2, getParentForChildren(), isClean());
                this.traceViewers_ = null;
                goto L10
            L7:
                r2 = false;
            L10:
                return this.traceViewersBuilder_;
            }

            private MapField<String, String> internalGetExtra() {
                MapField<String, String> r0 = this.extra_;
                if (r0 == null) goto L5;
                return r0;
            L5:
                return MapField.emptyMapField(ExtraDefaultEntryHolder.defaultEntry);
            }

            /* JADX INFO: renamed from: buildPartial, reason: collision with other method in class */
            public RealtimeCallDuration m236buildPartial() {
                RealtimeCallDuration r0 = new RealtimeCallDuration(this, null);
                int r1 = this.bitField0_;
                int r3 = 1;
                if ((r1 & 1) == 1) goto L6;
                r3 = 0;
            L6:
                RealtimeCallDuration.access$11302(r0, this.eventName_);
                if ((r1 & 2) != 2) goto L9;
                r3 = r3 | 2;
            L9:
                RealtimeCallDuration.access$11402(r0, this.eventReportSource_);
                if ((r1 & 4) != 4) goto L12;
                r3 = r3 | 4;
            L12:
                RealtimeCallDuration.access$11502(r0, this.traceId_);
                if ((r1 & 8) != 8) goto L15;
                r3 = r3 | 8;
            L15:
                RealtimeCallDuration.access$11602(r0, this.startTimestamp_);
                if ((r1 & 16) != 16) goto L18;
                r3 = r3 | 16;
            L18:
                RealtimeCallDuration.access$11702(r0, this.endTimestamp_);
                RealtimeCallDuration.access$11802(r0, internalGetExtra());
                RealtimeCallDuration.access$11800(r0).makeImmutable();
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r2 = this.traceViewersBuilder_;
                if (r2 == null) goto L21;
                RealtimeCallDuration.access$11902(r0, r2.build());
            L25:
                RealtimeCallDuration.access$12002(r0, r3);
                onBuilt();
                return r0;
            L21:
                if ((this.bitField0_ & 64) != 64) goto L23;
                this.traceViewers_ = Collections.unmodifiableList(this.traceViewers_);
                this.bitField0_ &= -65;
            L23:
                RealtimeCallDuration.access$11902(r0, this.traceViewers_);
                goto L25
            }

            public Builder clearEndTimestamp() {
                this.bitField0_ &= -17;
                this.endTimestamp_ = 0;
                onChanged();
                return this;
            }

            public Builder clearEventName() {
                this.bitField0_ &= -2;
                this.eventName_ = RealtimeCallDuration.getDefaultInstance().getEventName();
                onChanged();
                return this;
            }

            public Builder clearEventReportSource() {
                this.bitField0_ &= -3;
                this.eventReportSource_ = RealtimeCallDuration.getDefaultInstance().getEventReportSource();
                onChanged();
                return this;
            }

            public Builder clearStartTimestamp() {
                this.bitField0_ &= -9;
                this.startTimestamp_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTraceId() {
                this.bitField0_ &= -5;
                this.traceId_ = RealtimeCallDuration.getDefaultInstance().getTraceId();
                onChanged();
                return this;
            }

            public Builder clearTraceViewers() {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                this.traceViewers_ = Collections.emptyList();
                this.bitField0_ &= -65;
                onChanged();
            L6:
                return this;
            L5:
                r0.clear();
                goto L6
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
            public String getEventName() {
                Object r0 = this.eventName_;
                if ((r0 instanceof String) == true) goto L9;
                ByteString r1 = (ByteString) r0;
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L7;
                this.eventName_ = r2;
            L7:
                return r2;
            L9:
                return (String) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
            public ByteString getEventNameBytes() {
                Object r0 = this.eventName_;
                if ((r0 instanceof String) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) r0);
                this.eventName_ = r1;
                return r1;
            L7:
                return (ByteString) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
            public String getEventReportSource() {
                Object r0 = this.eventReportSource_;
                if ((r0 instanceof String) == true) goto L9;
                ByteString r1 = (ByteString) r0;
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L7;
                this.eventReportSource_ = r2;
            L7:
                return r2;
            L9:
                return (String) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
            public ByteString getEventReportSourceBytes() {
                Object r0 = this.eventReportSource_;
                if ((r0 instanceof String) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) r0);
                this.eventReportSource_ = r1;
                return r1;
            L7:
                return (ByteString) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
            public String getTraceId() {
                Object r0 = this.traceId_;
                if ((r0 instanceof String) == true) goto L9;
                ByteString r1 = (ByteString) r0;
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L7;
                this.traceId_ = r2;
            L7:
                return r2;
            L9:
                return (String) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
            public ByteString getTraceIdBytes() {
                Object r0 = this.traceId_;
                if ((r0 instanceof String) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) r0);
                this.traceId_ = r1;
                return r1;
            L7:
                return (ByteString) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
            public int getTraceViewersCount() {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L7;
                return this.traceViewers_.size();
            L7:
                return r0.getCount();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
            public List<AssistAudioEventDataTraceViewer> getTraceViewersList() {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L7;
                return Collections.unmodifiableList(this.traceViewers_);
            L7:
                return r0.getMessageList();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
            public List<? extends AssistAudioEventDataTraceViewerOrBuilder> getTraceViewersOrBuilderList() {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 == null) goto L7;
                return r0.getMessageOrBuilderList();
            L7:
                return Collections.unmodifiableList(this.traceViewers_);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
            public boolean hasEndTimestamp() {
                if ((this.bitField0_ & 16) != 16) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
            public boolean hasEventName() {
                if ((this.bitField0_ & 1) == 1) goto L7;
                return false;
            L7:
                return true;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
            public boolean hasEventReportSource() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
            public boolean hasStartTimestamp() {
                if ((this.bitField0_ & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
            public boolean hasTraceId() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            private Builder() {
                this.eventName_ = NameKeys.UnloadStrategy_No_Strategy;
                this.eventReportSource_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceId_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceViewers_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AssistAudioEventProto.access$10600();
            }

            private MapField<String, String> internalGetMutableExtra() {
                onChanged();
                if (this.extra_ != null) goto L6;
                this.extra_ = MapField.newMapField(ExtraDefaultEntryHolder.defaultEntry);
            L6:
                if (this.extra_.isMutable() == true) goto L9;
                this.extra_ = this.extra_.copy();
            L9:
                return this.extra_;
            }

            private void maybeForceBuilderInitialization() {
                if (RealtimeCallDuration.access$11100() == false) goto L6;
                getTraceViewersFieldBuilder();
                return;
            }

            public AssistAudioEventDataTraceViewer.Builder addTraceViewersBuilder() {
                return getTraceViewersFieldBuilder().addBuilder(AssistAudioEventDataTraceViewer.getDefaultInstance());
            }

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public RealtimeCallDuration m234build() {
                RealtimeCallDuration r0 = m236buildPartial();
                if (r0.isInitialized() == false) goto L6;
                return r0;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r0);
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public Builder m240clear() {
                super.clear();
                this.eventName_ = NameKeys.UnloadStrategy_No_Strategy;
                int r1 = this.bitField0_ & (-2);
                this.eventReportSource_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceId_ = NameKeys.UnloadStrategy_No_Strategy;
                this.startTimestamp_ = 0;
                this.endTimestamp_ = 0;
                this.bitField0_ = (((r1 & (-3)) & (-5)) & (-9)) & (-17);
                internalGetMutableExtra().clear();
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                this.traceViewers_ = Collections.emptyList();
                this.bitField0_ &= -65;
            L6:
                return this;
            L5:
                r0.clear();
                goto L6
            }

            public Builder clearExtra() {
                internalGetMutableExtra().getMutableMap().clear();
                return this;
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public Builder m250clone() {
                return (Builder) super.clone();
            }

            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return m253getDefaultInstanceForType();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return AssistAudioEventProto.access$10600();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
            public Map<String, String> getExtra() {
                return getExtraMap();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
            public int getExtraCount() {
                return internalGetExtra().getMap().size();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
            public Map<String, String> getExtraMap() {
                return internalGetExtra().getMap();
            }

            public Map<String, String> getMutableExtra() {
                return internalGetMutableExtra().getMutableMap();
            }

            public List<AssistAudioEventDataTraceViewer.Builder> getTraceViewersBuilderList() {
                return getTraceViewersFieldBuilder().getBuilderList();
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AssistAudioEventProto.access$10700().ensureFieldAccessorsInitialized(RealtimeCallDuration.class, Builder.class);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
            public long getEndTimestamp() {
                return this.endTimestamp_;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
            public long getStartTimestamp() {
                return this.startTimestamp_;
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m234build();
            }

            public /* bridge */ /* synthetic */ Message buildPartial() {
                return m236buildPartial();
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
                return m240clear();
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
                return m250clone();
            }

            /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite m252getDefaultInstanceForType() {
                return m253getDefaultInstanceForType();
            }

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite m233build() {
                return m234build();
            }

            /* JADX INFO: renamed from: buildPartial, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite m235buildPartial() {
                return m236buildPartial();
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m237clear() {
                return m240clear();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder m246clone() {
                return m250clone();
            }

            /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
            public RealtimeCallDuration m253getDefaultInstanceForType() {
                return RealtimeCallDuration.getDefaultInstance();
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m238clear() {
                return m240clear();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m247clone() {
                return m250clone();
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite.Builder m239clear() {
                return m240clear();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m248clone() {
                return m250clone();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite.Builder m249clone() {
                return m250clone();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m251clone() throws CloneNotSupportedException {
                return m250clone();
            }

            private Builder(GeneratedMessageV3.BuilderParent r1) {
                super(r1);
                this.eventName_ = NameKeys.UnloadStrategy_No_Strategy;
                this.eventReportSource_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceId_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceViewers_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public Builder addAllTraceViewers(Iterable<? extends AssistAudioEventDataTraceViewer> r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                ensureTraceViewersIsMutable();
                AbstractMessageLite.Builder.addAll(r2, this.traceViewers_);
                onChanged();
            L6:
                return this;
            L5:
                r0.addAllMessages(r2);
                goto L6
            }

            public Builder addTraceViewers(AssistAudioEventDataTraceViewer.Builder r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                ensureTraceViewersIsMutable();
                this.traceViewers_.add(r2.m96build());
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2.m96build());
                goto L6
            }

            public AssistAudioEventDataTraceViewer.Builder addTraceViewersBuilder(int r3) {
                return getTraceViewersFieldBuilder().addBuilder(r3, AssistAudioEventDataTraceViewer.getDefaultInstance());
            }

            /* JADX INFO: renamed from: clearField, reason: collision with other method in class */
            public Builder m242clearField(Descriptors.FieldDescriptor r1) {
                return (Builder) super.clearField(r1);
            }

            /* JADX INFO: renamed from: clearOneof, reason: collision with other method in class */
            public Builder m245clearOneof(Descriptors.OneofDescriptor r1) {
                return (Builder) super.clearOneof(r1);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
            public boolean containsExtra(String r2) {
                if (r2 == null) goto L6;
                return internalGetExtra().getMap().containsKey(r2);
            L6:
                throw null;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
            public String getExtraOrThrow(String r3) {
                if (r3 == null) goto L10;
                Map r0 = internalGetExtra().getMap();
                if (r0.containsKey(r3) == false) goto L8;
                return (String) r0.get(r3);
            L8:
                throw new IllegalArgumentException();
            L10:
                throw null;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
            public AssistAudioEventDataTraceViewer getTraceViewers(int r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L7;
                return (AssistAudioEventDataTraceViewer) ListProtector.get(this.traceViewers_, r2);
            L7:
                return r0.getMessage(r2);
            }

            public AssistAudioEventDataTraceViewer.Builder getTraceViewersBuilder(int r2) {
                return getTraceViewersFieldBuilder().getBuilder(r2);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
            public AssistAudioEventDataTraceViewerOrBuilder getTraceViewersOrBuilder(int r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L7;
                return (AssistAudioEventDataTraceViewerOrBuilder) ListProtector.get(this.traceViewers_, r2);
            L7:
                return (AssistAudioEventDataTraceViewerOrBuilder) r0.getMessageOrBuilder(r2);
            }

            public MapField internalGetMapField(int r4) {
                if (r4 != 6) goto L7;
                return internalGetExtra();
            L7:
                throw new RuntimeException("Invalid map field number: " + r4);
            }

            public MapField internalGetMutableMapField(int r4) {
                if (r4 != 6) goto L7;
                return internalGetMutableExtra();
            L7:
                throw new RuntimeException("Invalid map field number: " + r4);
            }

            public Builder mergeFrom(RealtimeCallDuration r3) {
                if (r3 != RealtimeCallDuration.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r3.hasEventName() == false) goto L9;
                this.bitField0_ |= 1;
                this.eventName_ = RealtimeCallDuration.access$11300(r3);
                onChanged();
            L9:
                if (r3.hasEventReportSource() == false) goto L12;
                this.bitField0_ |= 2;
                this.eventReportSource_ = RealtimeCallDuration.access$11400(r3);
                onChanged();
            L12:
                if (r3.hasTraceId() == false) goto L15;
                this.bitField0_ |= 4;
                this.traceId_ = RealtimeCallDuration.access$11500(r3);
                onChanged();
            L15:
                if (r3.hasStartTimestamp() == false) goto L18;
                setStartTimestamp(r3.getStartTimestamp());
            L18:
                if (r3.hasEndTimestamp() == false) goto L20;
                setEndTimestamp(r3.getEndTimestamp());
            L20:
                internalGetMutableExtra().mergeFrom(RealtimeCallDuration.access$12100(r3));
                if (this.traceViewersBuilder_ != null) goto L30;
                if (RealtimeCallDuration.access$11900(r3).isEmpty() == false) goto L25;
            L38:
                m262mergeUnknownFields(RealtimeCallDuration.access$12300(r3));
                onChanged();
                return this;
            L25:
                if (this.traceViewers_.isEmpty() == false) goto L27;
                this.traceViewers_ = RealtimeCallDuration.access$11900(r3);
                this.bitField0_ &= -65;
            L28:
                onChanged();
                goto L38
            L27:
                ensureTraceViewersIsMutable();
                this.traceViewers_.addAll(RealtimeCallDuration.access$11900(r3));
                goto L28
            L30:
                if (RealtimeCallDuration.access$11900(r3).isEmpty() == true) goto L38;
                if (this.traceViewersBuilder_.isEmpty() == false) goto L37;
                this.traceViewersBuilder_.dispose();
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = null;
                this.traceViewersBuilder_ = null;
                this.traceViewers_ = RealtimeCallDuration.access$11900(r3);
                this.bitField0_ &= -65;
                if (RealtimeCallDuration.access$12200() == false) goto L36;
                r0 = getTraceViewersFieldBuilder();
            L36:
                this.traceViewersBuilder_ = r0;
                goto L38
            L37:
                this.traceViewersBuilder_.addAllMessages(RealtimeCallDuration.access$11900(r3));
                goto L38
            }

            /* JADX INFO: renamed from: mergeUnknownFields, reason: collision with other method in class */
            public final Builder m262mergeUnknownFields(UnknownFieldSet r1) {
                return (Builder) super.mergeUnknownFields(r1);
            }

            public Builder putAllExtra(Map<String, String> r2) {
                internalGetMutableExtra().getMutableMap().putAll(r2);
                return this;
            }

            public Builder removeExtra(String r2) {
                if (r2 == null) goto L6;
                internalGetMutableExtra().getMutableMap().remove(r2);
                return this;
            L6:
                throw null;
            }

            public Builder removeTraceViewers(int r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                ensureTraceViewersIsMutable();
                ListProtector.remove(this.traceViewers_, r2);
                onChanged();
            L6:
                return this;
            L5:
                r0.remove(r2);
                goto L6
            }

            public Builder setEndTimestamp(long r2) {
                this.bitField0_ |= 16;
                this.endTimestamp_ = r2;
                onChanged();
                return this;
            }

            public Builder setEventName(String r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 1;
                this.eventName_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setEventNameBytes(ByteString r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 1;
                this.eventName_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setEventReportSource(String r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 2;
                this.eventReportSource_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setEventReportSourceBytes(ByteString r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 2;
                this.eventReportSource_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setStartTimestamp(long r2) {
                this.bitField0_ |= 8;
                this.startTimestamp_ = r2;
                onChanged();
                return this;
            }

            public Builder setTraceId(String r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 4;
                this.traceId_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setTraceIdBytes(ByteString r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 4;
                this.traceId_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            /* JADX INFO: renamed from: setUnknownFields, reason: collision with other method in class */
            public final Builder m268setUnknownFields(UnknownFieldSet r1) {
                return (Builder) super.setUnknownFields(r1);
            }

            public /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            public Builder addTraceViewers(AssistAudioEventDataTraceViewer r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L8;
                if (r2 == null) goto L7;
                ensureTraceViewersIsMutable();
                this.traceViewers_.add(r2);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.addMessage(r2);
                goto L9
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearField(Descriptors.FieldDescriptor r1) {
                return m242clearField(r1);
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r1) {
                return m245clearOneof(r1);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public Builder m259mergeFrom(Message r2) {
                if ((r2 instanceof RealtimeCallDuration) == true) goto L5;
                super/*com.google.protobuf.AbstractMessage.Builder*/.mergeFrom(r2);
                return this;
            L5:
                return mergeFrom((RealtimeCallDuration) r2);
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r1) {
                return m262mergeUnknownFields(r1);
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r1) {
                return m268setUnknownFields(r1);
            }

            /* JADX INFO: renamed from: clearField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m241clearField(Descriptors.FieldDescriptor r1) {
                return m242clearField(r1);
            }

            /* JADX INFO: renamed from: clearOneof, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m243clearOneof(Descriptors.OneofDescriptor r1) {
                return m245clearOneof(r1);
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r1) {
                return m259mergeFrom(r1);
            }

            /* JADX INFO: renamed from: mergeUnknownFields, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m260mergeUnknownFields(UnknownFieldSet r1) {
                return m262mergeUnknownFields(r1);
            }

            /* JADX INFO: renamed from: setUnknownFields, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m267setUnknownFields(UnknownFieldSet r1) {
                return m268setUnknownFields(r1);
            }

            /* JADX INFO: renamed from: clearOneof, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m244clearOneof(Descriptors.OneofDescriptor r1) {
                return m245clearOneof(r1);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m256mergeFrom(Message r1) {
                return m259mergeFrom(r1);
            }

            /* JADX INFO: renamed from: mergeUnknownFields, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m261mergeUnknownFields(UnknownFieldSet r1) {
                return m262mergeUnknownFields(r1);
            }

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r1, AnonymousClass1 r2) {
                this(r1);
            }

            /* JADX INFO: renamed from: addRepeatedField, reason: collision with other method in class */
            public Builder m232addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
                return (Builder) super.addRepeatedField(r1, r2);
            }

            public Builder addTraceViewers(int r2, AssistAudioEventDataTraceViewer.Builder r3) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                ensureTraceViewersIsMutable();
                ListProtector.add(this.traceViewers_, r2, r3.m96build());
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2, r3.m96build());
                goto L6
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
            public String getExtraOrDefault(String r3, String r4) {
                if (r3 == null) goto L8;
                Map r0 = internalGetExtra().getMap();
                if (r0.containsKey(r3) == true) goto L6;
                return r4;
            L6:
                return (String) r0.get(r3);
            L8:
                throw null;
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public Builder m258mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                RealtimeCallDuration r0 = null;
                RealtimeCallDuration r5 = (RealtimeCallDuration) RealtimeCallDuration.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                RealtimeCallDuration r6 = (RealtimeCallDuration) e.getUnfinishedMessage();     // Catch: Throwable -> L7
            L13:
                th = th;
                r0 = r6;
            L15:
                if (r0 == null) goto L17;
                mergeFrom(r0);
            L17:
                throw th;
            L12:
                throw e.unwrapIOException();     // Catch: Throwable -> L13
            L7:
                th = th;
                goto L15
            }

            public Builder putExtra(String r2, String r3) {
                if (r2 == null) goto L8;
                if (r3 == null) goto L7;
                internalGetMutableExtra().getMutableMap().put(r2, r3);
                return this;
            L7:
                throw null;
            L8:
                throw null;
            }

            /* JADX INFO: renamed from: setField, reason: collision with other method in class */
            public Builder m264setField(Descriptors.FieldDescriptor r1, Object r2) {
                return (Builder) super.setField(r1, r2);
            }

            public Builder setTraceViewers(int r2, AssistAudioEventDataTraceViewer.Builder r3) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                ensureTraceViewersIsMutable();
                ListProtector.set(this.traceViewers_, r2, r3.m96build());
                onChanged();
            L6:
                return this;
            L5:
                r0.setMessage(r2, r3.m96build());
                goto L6
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
                return m232addRepeatedField(r1, r2);
            }

            public Builder addTraceViewers(int r2, AssistAudioEventDataTraceViewer r3) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L8;
                if (r3 == null) goto L7;
                ensureTraceViewersIsMutable();
                ListProtector.add(this.traceViewers_, r2, r3);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.addMessage(r2, r3);
                goto L9
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m258mergeFrom(r1, r2);
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setField(Descriptors.FieldDescriptor r1, Object r2) {
                return m264setField(r1, r2);
            }

            public Builder setTraceViewers(int r2, AssistAudioEventDataTraceViewer r3) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L8;
                if (r3 == null) goto L7;
                ensureTraceViewersIsMutable();
                ListProtector.set(this.traceViewers_, r2, r3);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.setMessage(r2, r3);
                goto L9
            }

            /* JADX INFO: renamed from: addRepeatedField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m231addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
                return m232addRepeatedField(r1, r2);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder m254mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m258mergeFrom(r1, r2);
            }

            /* JADX INFO: renamed from: setField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m263setField(Descriptors.FieldDescriptor r1, Object r2) {
                return m264setField(r1, r2);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m255mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m258mergeFrom(r1, r2);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite.Builder m257mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m258mergeFrom(r1, r2);
            }

            /* JADX INFO: renamed from: setRepeatedField, reason: collision with other method in class */
            public Builder m266setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
                return (Builder) super.setRepeatedField(r1, r2, r3);
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
                return m266setRepeatedField(r1, r2, r3);
            }

            /* JADX INFO: renamed from: setRepeatedField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m265setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
                return m266setRepeatedField(r1, r2, r3);
            }
        }

        public static final class ExtraDefaultEntryHolder {
            static final MapEntry<String, String> defaultEntry = null;

            private ExtraDefaultEntryHolder() {
            }

            static {
                Descriptors.Descriptor r0 = AssistAudioEventProto.access$10800();
                WireFormat.FieldType r1 = WireFormat.FieldType.STRING;
                defaultEntry = MapEntry.newDefaultInstance(r0, r1, NameKeys.UnloadStrategy_No_Strategy, r1, NameKeys.UnloadStrategy_No_Strategy);
            }
        }

        static {
            DEFAULT_INSTANCE = new RealtimeCallDuration();
            PARSER = new AnonymousClass1();
        }

        private MapField<String, String> internalGetExtra() {
            MapField<String, String> r0 = this.extra_;
            if (r0 == null) goto L5;
            return r0;
        L5:
            return MapField.emptyMapField(ExtraDefaultEntryHolder.defaultEntry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m229toBuilder();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
        public String getEventName() {
            Object r0 = this.eventName_;
            if ((r0 instanceof String) == true) goto L5;
            ByteString r1 = (ByteString) r0;
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L9;
            this.eventName_ = r2;
        L9:
            return r2;
        L5:
            return (String) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
        public ByteString getEventNameBytes() {
            Object r0 = this.eventName_;
            if ((r0 instanceof String) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) r0);
            this.eventName_ = r1;
            return r1;
        L7:
            return (ByteString) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
        public String getEventReportSource() {
            Object r0 = this.eventReportSource_;
            if ((r0 instanceof String) == true) goto L5;
            ByteString r1 = (ByteString) r0;
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L9;
            this.eventReportSource_ = r2;
        L9:
            return r2;
        L5:
            return (String) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
        public ByteString getEventReportSourceBytes() {
            Object r0 = this.eventReportSource_;
            if ((r0 instanceof String) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) r0);
            this.eventReportSource_ = r1;
            return r1;
        L7:
            return (ByteString) r0;
        }

        public int getSerializedSize() {
            int r0 = ((AbstractMessage) this).memoizedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r2 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r1 = GeneratedMessageV3.computeStringSize(1, this.eventName_) + 0;
        L10:
            if ((this.bitField0_ & 2) != 2) goto L13;
            r1 = r1 + GeneratedMessageV3.computeStringSize(2, this.eventReportSource_);
        L13:
            if ((this.bitField0_ & 4) != 4) goto L16;
            r1 = r1 + GeneratedMessageV3.computeStringSize(3, this.traceId_);
        L16:
            if ((this.bitField0_ & 8) != 8) goto L19;
            r1 = r1 + CodedOutputStream.computeInt64Size(4, this.startTimestamp_);
        L19:
            if ((this.bitField0_ & 16) != 16) goto L21;
            r1 = r1 + CodedOutputStream.computeInt64Size(5, this.endTimestamp_);
        L21:
            Iterator r3 = internalGetExtra().getMap().entrySet().iterator();
        L23:
            if (r3.hasNext() == false) goto L26;
            Map.Entry r4 = (Map.Entry) r3.next();
            r1 = r1 + CodedOutputStream.computeMessageSize(6, ExtraDefaultEntryHolder.defaultEntry.newBuilderForType().setKey((String) r4.getKey()).setValue((String) r4.getValue()).build());
        L26:
            if (r2 >= this.traceViewers_.size()) goto L28;
            r1 = r1 + CodedOutputStream.computeMessageSize(7, (MessageLite) ListProtector.get(this.traceViewers_, r2));
            r2 = r2 + 1;
            goto L26
        L28:
            int r5 = r1 + ((GeneratedMessageV3) this).unknownFields.getSerializedSize();
            ((AbstractMessage) this).memoizedSize = r5;
            return r5;
        L8:
            r1 = 0;
            goto L10
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
        public String getTraceId() {
            Object r0 = this.traceId_;
            if ((r0 instanceof String) == true) goto L5;
            ByteString r1 = (ByteString) r0;
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L9;
            this.traceId_ = r2;
        L9:
            return r2;
        L5:
            return (String) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
        public ByteString getTraceIdBytes() {
            Object r0 = this.traceId_;
            if ((r0 instanceof String) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) r0);
            this.traceId_ = r1;
            return r1;
        L7:
            return (ByteString) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
        public int getTraceViewersCount() {
            return this.traceViewers_.size();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
        public boolean hasEndTimestamp() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
        public boolean hasEventName() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
        public boolean hasEventReportSource() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
        public boolean hasStartTimestamp() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
        public boolean hasTraceId() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public int hashCode() {
            int r0 = ((AbstractMessageLite) this).memoizedHashCode;
            if (r0 == 0) goto L5;
            return r0;
        L5:
            int r1 = 779 + getDescriptor().hashCode();
            if (hasEventName() == false) goto L9;
            r1 = (((r1 * 37) + 1) * 53) + getEventName().hashCode();
        L9:
            if (hasEventReportSource() == false) goto L12;
            r1 = (((r1 * 37) + 2) * 53) + getEventReportSource().hashCode();
        L12:
            if (hasTraceId() == false) goto L15;
            r1 = (((r1 * 37) + 3) * 53) + getTraceId().hashCode();
        L15:
            if (hasStartTimestamp() == false) goto L18;
            r1 = (((r1 * 37) + 4) * 53) + Internal.hashLong(getStartTimestamp());
        L18:
            if (hasEndTimestamp() == false) goto L21;
            r1 = (((r1 * 37) + 5) * 53) + Internal.hashLong(getEndTimestamp());
        L21:
            if (internalGetExtra().getMap().isEmpty() == true) goto L24;
            r1 = (((r1 * 37) + 6) * 53) + internalGetExtra().hashCode();
        L24:
            if (getTraceViewersCount() <= 0) goto L26;
            r1 = (((r1 * 37) + 7) * 53) + getTraceViewersList().hashCode();
        L26:
            int r2 = (r1 * 29) + ((GeneratedMessageV3) this).unknownFields.hashCode();
            ((AbstractMessageLite) this).memoizedHashCode = r2;
            return r2;
        }

        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L5;
            return true;
        L5:
            if (r0 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        /* JADX INFO: renamed from: toBuilder, reason: collision with other method in class */
        public Builder m229toBuilder() {
            AnonymousClass1 r1 = null;
            if (this != DEFAULT_INSTANCE) goto L6;
            return new Builder(r1);
        L6:
            return new Builder(r1).mergeFrom(this);
        }

        private RealtimeCallDuration() {
            this.memoizedIsInitialized = -1;
            this.eventName_ = NameKeys.UnloadStrategy_No_Strategy;
            this.eventReportSource_ = NameKeys.UnloadStrategy_No_Strategy;
            this.traceId_ = NameKeys.UnloadStrategy_No_Strategy;
            this.startTimestamp_ = 0;
            this.endTimestamp_ = 0;
            this.traceViewers_ = Collections.emptyList();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AssistAudioEventProto.access$10600();
        }

        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return m224getDefaultInstanceForType();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
        public Map<String, String> getExtra() {
            return getExtraMap();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
        public int getExtraCount() {
            return internalGetExtra().getMap().size();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
        public Map<String, String> getExtraMap() {
            return internalGetExtra().getMap();
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AssistAudioEventProto.access$10700().ensureFieldAccessorsInitialized(RealtimeCallDuration.class, Builder.class);
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return m226newBuilderForType();
        }

        public static /* synthetic */ boolean access$11100() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ boolean access$12200() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static RealtimeCallDuration getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RealtimeCallDuration> parser() {
            return PARSER;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
        public long getEndTimestamp() {
            return this.endTimestamp_;
        }

        public Parser<RealtimeCallDuration> getParserForType() {
            return PARSER;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
        public long getStartTimestamp() {
            return this.startTimestamp_;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
        public List<AssistAudioEventDataTraceViewer> getTraceViewersList() {
            return this.traceViewers_;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
        public List<? extends AssistAudioEventDataTraceViewerOrBuilder> getTraceViewersOrBuilderList() {
            return this.traceViewers_;
        }

        public final UnknownFieldSet getUnknownFields() {
            return ((GeneratedMessageV3) this).unknownFields;
        }

        /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite m223getDefaultInstanceForType() {
            return m224getDefaultInstanceForType();
        }

        /* JADX INFO: renamed from: newBuilderForType, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite.Builder m225newBuilderForType() {
            return m226newBuilderForType();
        }

        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return m229toBuilder();
        }

        /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
        public RealtimeCallDuration m224getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: renamed from: newBuilderForType, reason: collision with other method in class */
        public Builder m226newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: renamed from: toBuilder, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite.Builder m228toBuilder() {
            return m229toBuilder();
        }

        private RealtimeCallDuration(GeneratedMessageV3.Builder<?> r1) {
            super(r1);
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ Object access$11300(RealtimeCallDuration r0) {
            return r0.eventName_;
        }

        public static /* synthetic */ Object access$11400(RealtimeCallDuration r0) {
            return r0.eventReportSource_;
        }

        public static /* synthetic */ Object access$11500(RealtimeCallDuration r0) {
            return r0.traceId_;
        }

        public static /* synthetic */ MapField access$11800(RealtimeCallDuration r0) {
            return r0.extra_;
        }

        public static /* synthetic */ List access$11900(RealtimeCallDuration r0) {
            return r0.traceViewers_;
        }

        public static /* synthetic */ MapField access$12100(RealtimeCallDuration r0) {
            return r0.internalGetExtra();
        }

        public static /* synthetic */ UnknownFieldSet access$12300(RealtimeCallDuration r0) {
            return ((GeneratedMessageV3) r0).unknownFields;
        }

        public static Builder newBuilder(RealtimeCallDuration r1) {
            return DEFAULT_INSTANCE.m229toBuilder().mergeFrom(r1);
        }

        public static RealtimeCallDuration parseDelimitedFrom(InputStream r1) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r1);
        }

        public static RealtimeCallDuration parseFrom(ByteString r1) throws InvalidProtocolBufferException {
            return (RealtimeCallDuration) PARSER.parseFrom(r1);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
        public boolean containsExtra(String r2) {
            if (r2 == null) goto L6;
            return internalGetExtra().getMap().containsKey(r2);
        L6:
            throw null;
        }

        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof RealtimeCallDuration) == false) goto L8;
            RealtimeCallDuration r9 = (RealtimeCallDuration) r8;
            if (hasEventName() != r9.hasEventName()) goto L12;
            boolean r1 = true;
        L14:
            if (hasEventName() == false) goto L20;
            if (r1 == true) goto L17;
        L19:
            r1 = false;
            goto L20
        L17:
            if (getEventName().equals(r9.getEventName()) == false) goto L19;
            r1 = true;
        L20:
            if (r1 == true) goto L22;
        L24:
            boolean r2 = false;
        L26:
            if (hasEventReportSource() == false) goto L32;
            if (r2 == true) goto L29;
        L31:
            r2 = false;
            goto L32
        L29:
            if (getEventReportSource().equals(r9.getEventReportSource()) == false) goto L31;
            r2 = true;
        L32:
            if (r2 == true) goto L34;
        L36:
            boolean r3 = false;
        L38:
            if (hasTraceId() == false) goto L44;
            if (r3 == true) goto L41;
        L43:
            r3 = false;
            goto L44
        L41:
            if (getTraceId().equals(r9.getTraceId()) == false) goto L43;
            r3 = true;
        L44:
            if (r3 == true) goto L46;
        L48:
            boolean r4 = false;
        L50:
            if (hasStartTimestamp() == false) goto L56;
            if (r4 == true) goto L53;
        L55:
            r4 = false;
            goto L56
        L53:
            if (getStartTimestamp() != r9.getStartTimestamp()) goto L55;
            r4 = true;
        L56:
            if (r4 == true) goto L58;
        L60:
            boolean r5 = false;
        L62:
            if (hasEndTimestamp() == false) goto L68;
            if (r5 == true) goto L65;
        L67:
            r5 = false;
            goto L68
        L65:
            if (getEndTimestamp() != r9.getEndTimestamp()) goto L67;
            r5 = true;
        L68:
            if (r5 == true) goto L70;
        L72:
            boolean r6 = false;
        L73:
            if (r6 == true) goto L75;
        L77:
            boolean r7 = false;
        L78:
            if (r7 == true) goto L80;
        L82:
            return false;
        L80:
            if (((GeneratedMessageV3) this).unknownFields.equals(((GeneratedMessageV3) r9).unknownFields) == false) goto L82;
            return true;
        L75:
            if (getTraceViewersList().equals(r9.getTraceViewersList()) == false) goto L77;
            r7 = true;
            goto L78
        L70:
            if (internalGetExtra().equals(r9.internalGetExtra()) == false) goto L72;
            r6 = true;
            goto L73
        L58:
            if (hasEndTimestamp() != r9.hasEndTimestamp()) goto L60;
            r5 = true;
            goto L62
        L46:
            if (hasStartTimestamp() != r9.hasStartTimestamp()) goto L48;
            r4 = true;
            goto L50
        L34:
            if (hasTraceId() != r9.hasTraceId()) goto L36;
            r3 = true;
            goto L38
        L22:
            if (hasEventReportSource() != r9.hasEventReportSource()) goto L24;
            r2 = true;
            goto L26
        L12:
            r1 = false;
            goto L14
        L8:
            return super/*com.google.protobuf.AbstractMessage*/.equals(r8);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
        public String getExtraOrThrow(String r3) {
            if (r3 == null) goto L10;
            Map r0 = internalGetExtra().getMap();
            if (r0.containsKey(r3) == false) goto L8;
            return (String) r0.get(r3);
        L8:
            throw new IllegalArgumentException();
        L10:
            throw null;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
        public AssistAudioEventDataTraceViewer getTraceViewers(int r2) {
            return (AssistAudioEventDataTraceViewer) ListProtector.get(this.traceViewers_, r2);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
        public AssistAudioEventDataTraceViewerOrBuilder getTraceViewersOrBuilder(int r2) {
            return (AssistAudioEventDataTraceViewerOrBuilder) ListProtector.get(this.traceViewers_, r2);
        }

        public MapField internalGetMapField(int r4) {
            if (r4 != 6) goto L7;
            return internalGetExtra();
        L7:
            throw new RuntimeException("Invalid map field number: " + r4);
        }

        /* JADX INFO: renamed from: newBuilderForType, reason: collision with other method in class */
        public Builder m227newBuilderForType(GeneratedMessageV3.BuilderParent r3) {
            return new Builder(r3, null);
        }

        public void writeTo(CodedOutputStream r5) throws IOException {
            if ((this.bitField0_ & 1) != 1) goto L6;
            GeneratedMessageV3.writeString(r5, 1, this.eventName_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            GeneratedMessageV3.writeString(r5, 2, this.eventReportSource_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L12;
            GeneratedMessageV3.writeString(r5, 3, this.traceId_);
        L12:
            if ((this.bitField0_ & 8) != 8) goto L15;
            r5.writeInt64(4, this.startTimestamp_);
        L15:
            if ((this.bitField0_ & 16) != 16) goto L17;
            r5.writeInt64(5, this.endTimestamp_);
        L17:
            GeneratedMessageV3.serializeStringMapTo(r5, internalGetExtra(), ExtraDefaultEntryHolder.defaultEntry, 6);
            int r0 = 0;
        L19:
            if (r0 >= this.traceViewers_.size()) goto L21;
            r5.writeMessage(7, (MessageLite) ListProtector.get(this.traceViewers_, r0));
            r0 = r0 + 1;
            goto L19
        L21:
            ((GeneratedMessageV3) this).unknownFields.writeTo(r5);
        }

        public static RealtimeCallDuration parseFrom(CodedInputStream r1) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1);
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r1) {
            return m227newBuilderForType(r1);
        }

        public static RealtimeCallDuration parseFrom(InputStream r1) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1);
        }

        public static RealtimeCallDuration parseFrom(ByteBuffer r1) throws InvalidProtocolBufferException {
            return (RealtimeCallDuration) PARSER.parseFrom(r1);
        }

        public static RealtimeCallDuration parseFrom(byte[] r1) throws InvalidProtocolBufferException {
            return (RealtimeCallDuration) PARSER.parseFrom(r1);
        }

        private RealtimeCallDuration(CodedInputStream r9, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
            this();
            if (r10 == null) goto L60;
            UnknownFieldSet.Builder r0 = UnknownFieldSet.newBuilder();
            boolean r1 = false;
            int r2 = 0;
        L6:
            if (r1 == true) goto L55;
            int r4 = r9.readTag();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            if (r4 == 0) goto L40;
            if (r4 != 10) goto L12;
            ByteString r5 = r9.readBytes();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.bitField0_ = 1 | this.bitField0_;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.eventName_ = r5;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L6
        L12:
            if (r4 != 18) goto L14;
            ByteString r6 = r9.readBytes();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.bitField0_ |= 2;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.eventReportSource_ = r6;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L6
        L14:
            if (r4 != 26) goto L16;
            ByteString r7 = r9.readBytes();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.bitField0_ |= 4;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.traceId_ = r7;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L6
        L16:
            if (r4 != 32) goto L18;
            this.bitField0_ |= 8;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.startTimestamp_ = r9.readInt64();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L6
        L18:
            if (r4 != 40) goto L20;
            this.bitField0_ |= 16;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.endTimestamp_ = r9.readInt64();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L6
        L20:
            if (r4 != 50) goto L22;
            if ((r2 & 32) == 32) goto L33;
            this.extra_ = MapField.newMapField(ExtraDefaultEntryHolder.defaultEntry);     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            r2 = r2 | 32;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        L33:
            MapEntry r8 = r9.readMessage(ExtraDefaultEntryHolder.defaultEntry.getParserForType(), r10);     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.extra_.getMutableMap().put((String) r8.getKey(), (String) r8.getValue());     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L6
        L22:
            if (r4 != 58) goto L24;
            if ((r2 & 64) == 64) goto L29;
            this.traceViewers_ = new ArrayList();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            r2 = r2 | 64;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        L29:
            this.traceViewers_.add((AssistAudioEventDataTraceViewer) r9.readMessage(AssistAudioEventDataTraceViewer.PARSER, r10));     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L6
        L24:
            if (parseUnknownField(r9, r0, r10, r4) == true) goto L6;
        L40:
            r1 = true;
            goto L6
        L41:
            th = move-exception;
            if ((r2 & 64) != 64) goto L52;
            this.traceViewers_ = Collections.unmodifiableList(this.traceViewers_);
        L52:
            ((GeneratedMessageV3) this).unknownFields = r0.build();
            makeExtensionsImmutable();
            throw th;
        L43:
            e = move-exception;
            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L41
        L46:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L41
        L55:
            if ((r2 & 64) != 64) goto L57;
            this.traceViewers_ = Collections.unmodifiableList(this.traceViewers_);
        L57:
            ((GeneratedMessageV3) this).unknownFields = r0.build();
            makeExtensionsImmutable();
            return;
        L60:
            throw null;
        }

        public static /* synthetic */ Object access$11302(RealtimeCallDuration r0, Object r1) {
            r0.eventName_ = r1;
            return r1;
        }

        public static /* synthetic */ Object access$11402(RealtimeCallDuration r0, Object r1) {
            r0.eventReportSource_ = r1;
            return r1;
        }

        public static /* synthetic */ Object access$11502(RealtimeCallDuration r0, Object r1) {
            r0.traceId_ = r1;
            return r1;
        }

        public static /* synthetic */ long access$11602(RealtimeCallDuration r0, long r1) {
            r0.startTimestamp_ = r1;
            return r1;
        }

        public static /* synthetic */ long access$11702(RealtimeCallDuration r0, long r1) {
            r0.endTimestamp_ = r1;
            return r1;
        }

        public static /* synthetic */ MapField access$11802(RealtimeCallDuration r0, MapField r1) {
            r0.extra_ = r1;
            return r1;
        }

        public static /* synthetic */ List access$11902(RealtimeCallDuration r0, List r1) {
            r0.traceViewers_ = r1;
            return r1;
        }

        public static /* synthetic */ int access$12002(RealtimeCallDuration r0, int r1) {
            r0.bitField0_ = r1;
            return r1;
        }

        public static RealtimeCallDuration parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r1, r2);
        }

        public static RealtimeCallDuration parseFrom(ByteString r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
            return (RealtimeCallDuration) PARSER.parseFrom(r1, r2);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallDurationOrBuilder
        public String getExtraOrDefault(String r3, String r4) {
            if (r3 == null) goto L8;
            Map r0 = internalGetExtra().getMap();
            if (r0.containsKey(r3) == true) goto L6;
            return r4;
        L6:
            return (String) r0.get(r3);
        L8:
            throw null;
        }

        public /* synthetic */ RealtimeCallDuration(GeneratedMessageV3.Builder r1, AnonymousClass1 r2) {
            this(r1);
        }

        public static RealtimeCallDuration parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1, r2);
        }

        public static RealtimeCallDuration parseFrom(InputStream r1, ExtensionRegistryLite r2) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1, r2);
        }

        public static RealtimeCallDuration parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
            return (RealtimeCallDuration) PARSER.parseFrom(r1, r2);
        }

        public static RealtimeCallDuration parseFrom(byte[] r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
            return (RealtimeCallDuration) PARSER.parseFrom(r1, r2);
        }

        public /* synthetic */ RealtimeCallDuration(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }
    }

    public interface RealtimeCallDurationOrBuilder extends MessageOrBuilder {
        boolean containsExtra(String r1);

        long getEndTimestamp();

        String getEventName();

        ByteString getEventNameBytes();

        String getEventReportSource();

        ByteString getEventReportSourceBytes();

        Map<String, String> getExtra();

        int getExtraCount();

        Map<String, String> getExtraMap();

        String getExtraOrDefault(String r1, String r2);

        String getExtraOrThrow(String r1);

        long getStartTimestamp();

        String getTraceId();

        ByteString getTraceIdBytes();

        AssistAudioEventDataTraceViewer getTraceViewers(int r1);

        int getTraceViewersCount();

        List<AssistAudioEventDataTraceViewer> getTraceViewersList();

        AssistAudioEventDataTraceViewerOrBuilder getTraceViewersOrBuilder(int r1);

        List<? extends AssistAudioEventDataTraceViewerOrBuilder> getTraceViewersOrBuilderList();

        boolean hasEndTimestamp();

        boolean hasEventName();

        boolean hasEventReportSource();

        boolean hasStartTimestamp();

        boolean hasTraceId();
    }

    public static final class RealtimeCallEvent extends GeneratedMessageV3 implements RealtimeCallEventOrBuilder {
        private static final RealtimeCallEvent DEFAULT_INSTANCE = null;
        public static final int EVENT_NAME_FIELD_NUMBER = 1;
        public static final int EVENT_REPORT_SOURCE_FIELD_NUMBER = 2;
        public static final int EXTRA_FIELD_NUMBER = 5;
        public static final Parser<RealtimeCallEvent> PARSER = null;
        public static final int TIMESTAMP_FIELD_NUMBER = 4;
        public static final int TRACE_ID_FIELD_NUMBER = 3;
        public static final int TRACE_VIEWERS_FIELD_NUMBER = 6;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private volatile Object eventName_;
        private volatile Object eventReportSource_;
        private MapField<String, String> extra_;
        private byte memoizedIsInitialized;
        private long timestamp_;
        private volatile Object traceId_;
        private List<AssistAudioEventDataTraceViewer> traceViewers_;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RealtimeCallEventOrBuilder {
            private int bitField0_;
            private Object eventName_;
            private Object eventReportSource_;
            private MapField<String, String> extra_;
            private long timestamp_;
            private Object traceId_;
            private RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> traceViewersBuilder_;
            private List<AssistAudioEventDataTraceViewer> traceViewers_;

            public final boolean isInitialized() {
                return true;
            }

            private void ensureTraceViewersIsMutable() {
                if ((this.bitField0_ & 32) == 32) goto L6;
                this.traceViewers_ = new ArrayList(this.traceViewers_);
                this.bitField0_ |= 32;
                return;
            }

            private RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> getTraceViewersFieldBuilder() {
                if (this.traceViewersBuilder_ != null) goto L10;
                List<AssistAudioEventDataTraceViewer> r1 = this.traceViewers_;
                if ((this.bitField0_ & 32) != 32) goto L7;
                boolean r2 = true;
            L8:
                this.traceViewersBuilder_ = new RepeatedFieldBuilderV3(r1, r2, getParentForChildren(), isClean());
                this.traceViewers_ = null;
                goto L10
            L7:
                r2 = false;
            L10:
                return this.traceViewersBuilder_;
            }

            private MapField<String, String> internalGetExtra() {
                MapField<String, String> r0 = this.extra_;
                if (r0 == null) goto L5;
                return r0;
            L5:
                return MapField.emptyMapField(ExtraDefaultEntryHolder.defaultEntry);
            }

            /* JADX INFO: renamed from: buildPartial, reason: collision with other method in class */
            public RealtimeCallEvent m282buildPartial() {
                RealtimeCallEvent r0 = new RealtimeCallEvent(this, null);
                int r1 = this.bitField0_;
                int r3 = 1;
                if ((r1 & 1) == 1) goto L6;
                r3 = 0;
            L6:
                RealtimeCallEvent.access$13202(r0, this.eventName_);
                if ((r1 & 2) != 2) goto L9;
                r3 = r3 | 2;
            L9:
                RealtimeCallEvent.access$13302(r0, this.eventReportSource_);
                if ((r1 & 4) != 4) goto L12;
                r3 = r3 | 4;
            L12:
                RealtimeCallEvent.access$13402(r0, this.traceId_);
                if ((r1 & 8) != 8) goto L15;
                r3 = r3 | 8;
            L15:
                RealtimeCallEvent.access$13502(r0, this.timestamp_);
                RealtimeCallEvent.access$13602(r0, internalGetExtra());
                RealtimeCallEvent.access$13600(r0).makeImmutable();
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r2 = this.traceViewersBuilder_;
                if (r2 == null) goto L18;
                RealtimeCallEvent.access$13702(r0, r2.build());
            L22:
                RealtimeCallEvent.access$13802(r0, r3);
                onBuilt();
                return r0;
            L18:
                if ((this.bitField0_ & 32) != 32) goto L20;
                this.traceViewers_ = Collections.unmodifiableList(this.traceViewers_);
                this.bitField0_ &= -33;
            L20:
                RealtimeCallEvent.access$13702(r0, this.traceViewers_);
                goto L22
            }

            public Builder clearEventName() {
                this.bitField0_ &= -2;
                this.eventName_ = RealtimeCallEvent.getDefaultInstance().getEventName();
                onChanged();
                return this;
            }

            public Builder clearEventReportSource() {
                this.bitField0_ &= -3;
                this.eventReportSource_ = RealtimeCallEvent.getDefaultInstance().getEventReportSource();
                onChanged();
                return this;
            }

            public Builder clearTimestamp() {
                this.bitField0_ &= -9;
                this.timestamp_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTraceId() {
                this.bitField0_ &= -5;
                this.traceId_ = RealtimeCallEvent.getDefaultInstance().getTraceId();
                onChanged();
                return this;
            }

            public Builder clearTraceViewers() {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                this.traceViewers_ = Collections.emptyList();
                this.bitField0_ &= -33;
                onChanged();
            L6:
                return this;
            L5:
                r0.clear();
                goto L6
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
            public String getEventName() {
                Object r0 = this.eventName_;
                if ((r0 instanceof String) == true) goto L9;
                ByteString r1 = (ByteString) r0;
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L7;
                this.eventName_ = r2;
            L7:
                return r2;
            L9:
                return (String) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
            public ByteString getEventNameBytes() {
                Object r0 = this.eventName_;
                if ((r0 instanceof String) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) r0);
                this.eventName_ = r1;
                return r1;
            L7:
                return (ByteString) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
            public String getEventReportSource() {
                Object r0 = this.eventReportSource_;
                if ((r0 instanceof String) == true) goto L9;
                ByteString r1 = (ByteString) r0;
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L7;
                this.eventReportSource_ = r2;
            L7:
                return r2;
            L9:
                return (String) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
            public ByteString getEventReportSourceBytes() {
                Object r0 = this.eventReportSource_;
                if ((r0 instanceof String) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) r0);
                this.eventReportSource_ = r1;
                return r1;
            L7:
                return (ByteString) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
            public String getTraceId() {
                Object r0 = this.traceId_;
                if ((r0 instanceof String) == true) goto L9;
                ByteString r1 = (ByteString) r0;
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L7;
                this.traceId_ = r2;
            L7:
                return r2;
            L9:
                return (String) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
            public ByteString getTraceIdBytes() {
                Object r0 = this.traceId_;
                if ((r0 instanceof String) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) r0);
                this.traceId_ = r1;
                return r1;
            L7:
                return (ByteString) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
            public int getTraceViewersCount() {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L7;
                return this.traceViewers_.size();
            L7:
                return r0.getCount();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
            public List<AssistAudioEventDataTraceViewer> getTraceViewersList() {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L7;
                return Collections.unmodifiableList(this.traceViewers_);
            L7:
                return r0.getMessageList();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
            public List<? extends AssistAudioEventDataTraceViewerOrBuilder> getTraceViewersOrBuilderList() {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 == null) goto L7;
                return r0.getMessageOrBuilderList();
            L7:
                return Collections.unmodifiableList(this.traceViewers_);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
            public boolean hasEventName() {
                if ((this.bitField0_ & 1) == 1) goto L7;
                return false;
            L7:
                return true;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
            public boolean hasEventReportSource() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
            public boolean hasTimestamp() {
                if ((this.bitField0_ & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
            public boolean hasTraceId() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            private Builder() {
                this.eventName_ = NameKeys.UnloadStrategy_No_Strategy;
                this.eventReportSource_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceId_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceViewers_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AssistAudioEventProto.access$12500();
            }

            private MapField<String, String> internalGetMutableExtra() {
                onChanged();
                if (this.extra_ != null) goto L6;
                this.extra_ = MapField.newMapField(ExtraDefaultEntryHolder.defaultEntry);
            L6:
                if (this.extra_.isMutable() == true) goto L9;
                this.extra_ = this.extra_.copy();
            L9:
                return this.extra_;
            }

            private void maybeForceBuilderInitialization() {
                if (RealtimeCallEvent.access$13000() == false) goto L6;
                getTraceViewersFieldBuilder();
                return;
            }

            public AssistAudioEventDataTraceViewer.Builder addTraceViewersBuilder() {
                return getTraceViewersFieldBuilder().addBuilder(AssistAudioEventDataTraceViewer.getDefaultInstance());
            }

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public RealtimeCallEvent m280build() {
                RealtimeCallEvent r0 = m282buildPartial();
                if (r0.isInitialized() == false) goto L6;
                return r0;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r0);
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public Builder m286clear() {
                super.clear();
                this.eventName_ = NameKeys.UnloadStrategy_No_Strategy;
                int r1 = this.bitField0_ & (-2);
                this.eventReportSource_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceId_ = NameKeys.UnloadStrategy_No_Strategy;
                this.timestamp_ = 0;
                this.bitField0_ = ((r1 & (-3)) & (-5)) & (-9);
                internalGetMutableExtra().clear();
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                this.traceViewers_ = Collections.emptyList();
                this.bitField0_ &= -33;
            L6:
                return this;
            L5:
                r0.clear();
                goto L6
            }

            public Builder clearExtra() {
                internalGetMutableExtra().getMutableMap().clear();
                return this;
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public Builder m296clone() {
                return (Builder) super.clone();
            }

            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return m299getDefaultInstanceForType();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return AssistAudioEventProto.access$12500();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
            public Map<String, String> getExtra() {
                return getExtraMap();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
            public int getExtraCount() {
                return internalGetExtra().getMap().size();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
            public Map<String, String> getExtraMap() {
                return internalGetExtra().getMap();
            }

            public Map<String, String> getMutableExtra() {
                return internalGetMutableExtra().getMutableMap();
            }

            public List<AssistAudioEventDataTraceViewer.Builder> getTraceViewersBuilderList() {
                return getTraceViewersFieldBuilder().getBuilderList();
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AssistAudioEventProto.access$12600().ensureFieldAccessorsInitialized(RealtimeCallEvent.class, Builder.class);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
            public long getTimestamp() {
                return this.timestamp_;
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m280build();
            }

            public /* bridge */ /* synthetic */ Message buildPartial() {
                return m282buildPartial();
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
                return m286clear();
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
                return m296clone();
            }

            /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite m298getDefaultInstanceForType() {
                return m299getDefaultInstanceForType();
            }

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite m279build() {
                return m280build();
            }

            /* JADX INFO: renamed from: buildPartial, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite m281buildPartial() {
                return m282buildPartial();
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m283clear() {
                return m286clear();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder m292clone() {
                return m296clone();
            }

            /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
            public RealtimeCallEvent m299getDefaultInstanceForType() {
                return RealtimeCallEvent.getDefaultInstance();
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m284clear() {
                return m286clear();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m293clone() {
                return m296clone();
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite.Builder m285clear() {
                return m286clear();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m294clone() {
                return m296clone();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite.Builder m295clone() {
                return m296clone();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m297clone() throws CloneNotSupportedException {
                return m296clone();
            }

            private Builder(GeneratedMessageV3.BuilderParent r1) {
                super(r1);
                this.eventName_ = NameKeys.UnloadStrategy_No_Strategy;
                this.eventReportSource_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceId_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceViewers_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public Builder addAllTraceViewers(Iterable<? extends AssistAudioEventDataTraceViewer> r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                ensureTraceViewersIsMutable();
                AbstractMessageLite.Builder.addAll(r2, this.traceViewers_);
                onChanged();
            L6:
                return this;
            L5:
                r0.addAllMessages(r2);
                goto L6
            }

            public Builder addTraceViewers(AssistAudioEventDataTraceViewer.Builder r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                ensureTraceViewersIsMutable();
                this.traceViewers_.add(r2.m96build());
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2.m96build());
                goto L6
            }

            public AssistAudioEventDataTraceViewer.Builder addTraceViewersBuilder(int r3) {
                return getTraceViewersFieldBuilder().addBuilder(r3, AssistAudioEventDataTraceViewer.getDefaultInstance());
            }

            /* JADX INFO: renamed from: clearField, reason: collision with other method in class */
            public Builder m288clearField(Descriptors.FieldDescriptor r1) {
                return (Builder) super.clearField(r1);
            }

            /* JADX INFO: renamed from: clearOneof, reason: collision with other method in class */
            public Builder m291clearOneof(Descriptors.OneofDescriptor r1) {
                return (Builder) super.clearOneof(r1);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
            public boolean containsExtra(String r2) {
                if (r2 == null) goto L6;
                return internalGetExtra().getMap().containsKey(r2);
            L6:
                throw null;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
            public String getExtraOrThrow(String r3) {
                if (r3 == null) goto L10;
                Map r0 = internalGetExtra().getMap();
                if (r0.containsKey(r3) == false) goto L8;
                return (String) r0.get(r3);
            L8:
                throw new IllegalArgumentException();
            L10:
                throw null;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
            public AssistAudioEventDataTraceViewer getTraceViewers(int r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L7;
                return (AssistAudioEventDataTraceViewer) ListProtector.get(this.traceViewers_, r2);
            L7:
                return r0.getMessage(r2);
            }

            public AssistAudioEventDataTraceViewer.Builder getTraceViewersBuilder(int r2) {
                return getTraceViewersFieldBuilder().getBuilder(r2);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
            public AssistAudioEventDataTraceViewerOrBuilder getTraceViewersOrBuilder(int r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L7;
                return (AssistAudioEventDataTraceViewerOrBuilder) ListProtector.get(this.traceViewers_, r2);
            L7:
                return (AssistAudioEventDataTraceViewerOrBuilder) r0.getMessageOrBuilder(r2);
            }

            public MapField internalGetMapField(int r4) {
                if (r4 != 5) goto L7;
                return internalGetExtra();
            L7:
                throw new RuntimeException("Invalid map field number: " + r4);
            }

            public MapField internalGetMutableMapField(int r4) {
                if (r4 != 5) goto L7;
                return internalGetMutableExtra();
            L7:
                throw new RuntimeException("Invalid map field number: " + r4);
            }

            public Builder mergeFrom(RealtimeCallEvent r3) {
                if (r3 != RealtimeCallEvent.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r3.hasEventName() == false) goto L9;
                this.bitField0_ |= 1;
                this.eventName_ = RealtimeCallEvent.access$13200(r3);
                onChanged();
            L9:
                if (r3.hasEventReportSource() == false) goto L12;
                this.bitField0_ |= 2;
                this.eventReportSource_ = RealtimeCallEvent.access$13300(r3);
                onChanged();
            L12:
                if (r3.hasTraceId() == false) goto L15;
                this.bitField0_ |= 4;
                this.traceId_ = RealtimeCallEvent.access$13400(r3);
                onChanged();
            L15:
                if (r3.hasTimestamp() == false) goto L17;
                setTimestamp(r3.getTimestamp());
            L17:
                internalGetMutableExtra().mergeFrom(RealtimeCallEvent.access$13900(r3));
                if (this.traceViewersBuilder_ != null) goto L27;
                if (RealtimeCallEvent.access$13700(r3).isEmpty() == false) goto L22;
            L35:
                m308mergeUnknownFields(RealtimeCallEvent.access$14100(r3));
                onChanged();
                return this;
            L22:
                if (this.traceViewers_.isEmpty() == false) goto L24;
                this.traceViewers_ = RealtimeCallEvent.access$13700(r3);
                this.bitField0_ &= -33;
            L25:
                onChanged();
                goto L35
            L24:
                ensureTraceViewersIsMutable();
                this.traceViewers_.addAll(RealtimeCallEvent.access$13700(r3));
                goto L25
            L27:
                if (RealtimeCallEvent.access$13700(r3).isEmpty() == true) goto L35;
                if (this.traceViewersBuilder_.isEmpty() == false) goto L34;
                this.traceViewersBuilder_.dispose();
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = null;
                this.traceViewersBuilder_ = null;
                this.traceViewers_ = RealtimeCallEvent.access$13700(r3);
                this.bitField0_ &= -33;
                if (RealtimeCallEvent.access$14000() == false) goto L33;
                r0 = getTraceViewersFieldBuilder();
            L33:
                this.traceViewersBuilder_ = r0;
                goto L35
            L34:
                this.traceViewersBuilder_.addAllMessages(RealtimeCallEvent.access$13700(r3));
                goto L35
            }

            /* JADX INFO: renamed from: mergeUnknownFields, reason: collision with other method in class */
            public final Builder m308mergeUnknownFields(UnknownFieldSet r1) {
                return (Builder) super.mergeUnknownFields(r1);
            }

            public Builder putAllExtra(Map<String, String> r2) {
                internalGetMutableExtra().getMutableMap().putAll(r2);
                return this;
            }

            public Builder removeExtra(String r2) {
                if (r2 == null) goto L6;
                internalGetMutableExtra().getMutableMap().remove(r2);
                return this;
            L6:
                throw null;
            }

            public Builder removeTraceViewers(int r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                ensureTraceViewersIsMutable();
                ListProtector.remove(this.traceViewers_, r2);
                onChanged();
            L6:
                return this;
            L5:
                r0.remove(r2);
                goto L6
            }

            public Builder setEventName(String r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 1;
                this.eventName_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setEventNameBytes(ByteString r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 1;
                this.eventName_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setEventReportSource(String r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 2;
                this.eventReportSource_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setEventReportSourceBytes(ByteString r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 2;
                this.eventReportSource_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setTimestamp(long r2) {
                this.bitField0_ |= 8;
                this.timestamp_ = r2;
                onChanged();
                return this;
            }

            public Builder setTraceId(String r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 4;
                this.traceId_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setTraceIdBytes(ByteString r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 4;
                this.traceId_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            /* JADX INFO: renamed from: setUnknownFields, reason: collision with other method in class */
            public final Builder m314setUnknownFields(UnknownFieldSet r1) {
                return (Builder) super.setUnknownFields(r1);
            }

            public /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            public Builder addTraceViewers(AssistAudioEventDataTraceViewer r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L8;
                if (r2 == null) goto L7;
                ensureTraceViewersIsMutable();
                this.traceViewers_.add(r2);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.addMessage(r2);
                goto L9
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearField(Descriptors.FieldDescriptor r1) {
                return m288clearField(r1);
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r1) {
                return m291clearOneof(r1);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public Builder m305mergeFrom(Message r2) {
                if ((r2 instanceof RealtimeCallEvent) == true) goto L5;
                super/*com.google.protobuf.AbstractMessage.Builder*/.mergeFrom(r2);
                return this;
            L5:
                return mergeFrom((RealtimeCallEvent) r2);
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r1) {
                return m308mergeUnknownFields(r1);
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r1) {
                return m314setUnknownFields(r1);
            }

            /* JADX INFO: renamed from: clearField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m287clearField(Descriptors.FieldDescriptor r1) {
                return m288clearField(r1);
            }

            /* JADX INFO: renamed from: clearOneof, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m289clearOneof(Descriptors.OneofDescriptor r1) {
                return m291clearOneof(r1);
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r1) {
                return m305mergeFrom(r1);
            }

            /* JADX INFO: renamed from: mergeUnknownFields, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m306mergeUnknownFields(UnknownFieldSet r1) {
                return m308mergeUnknownFields(r1);
            }

            /* JADX INFO: renamed from: setUnknownFields, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m313setUnknownFields(UnknownFieldSet r1) {
                return m314setUnknownFields(r1);
            }

            /* JADX INFO: renamed from: clearOneof, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m290clearOneof(Descriptors.OneofDescriptor r1) {
                return m291clearOneof(r1);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m302mergeFrom(Message r1) {
                return m305mergeFrom(r1);
            }

            /* JADX INFO: renamed from: mergeUnknownFields, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m307mergeUnknownFields(UnknownFieldSet r1) {
                return m308mergeUnknownFields(r1);
            }

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r1, AnonymousClass1 r2) {
                this(r1);
            }

            /* JADX INFO: renamed from: addRepeatedField, reason: collision with other method in class */
            public Builder m278addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
                return (Builder) super.addRepeatedField(r1, r2);
            }

            public Builder addTraceViewers(int r2, AssistAudioEventDataTraceViewer.Builder r3) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                ensureTraceViewersIsMutable();
                ListProtector.add(this.traceViewers_, r2, r3.m96build());
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2, r3.m96build());
                goto L6
            }

            @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
            public String getExtraOrDefault(String r3, String r4) {
                if (r3 == null) goto L8;
                Map r0 = internalGetExtra().getMap();
                if (r0.containsKey(r3) == true) goto L6;
                return r4;
            L6:
                return (String) r0.get(r3);
            L8:
                throw null;
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public Builder m304mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                RealtimeCallEvent r0 = null;
                RealtimeCallEvent r5 = (RealtimeCallEvent) RealtimeCallEvent.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                RealtimeCallEvent r6 = (RealtimeCallEvent) e.getUnfinishedMessage();     // Catch: Throwable -> L7
            L13:
                th = th;
                r0 = r6;
            L15:
                if (r0 == null) goto L17;
                mergeFrom(r0);
            L17:
                throw th;
            L12:
                throw e.unwrapIOException();     // Catch: Throwable -> L13
            L7:
                th = th;
                goto L15
            }

            public Builder putExtra(String r2, String r3) {
                if (r2 == null) goto L8;
                if (r3 == null) goto L7;
                internalGetMutableExtra().getMutableMap().put(r2, r3);
                return this;
            L7:
                throw null;
            L8:
                throw null;
            }

            /* JADX INFO: renamed from: setField, reason: collision with other method in class */
            public Builder m310setField(Descriptors.FieldDescriptor r1, Object r2) {
                return (Builder) super.setField(r1, r2);
            }

            public Builder setTraceViewers(int r2, AssistAudioEventDataTraceViewer.Builder r3) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                ensureTraceViewersIsMutable();
                ListProtector.set(this.traceViewers_, r2, r3.m96build());
                onChanged();
            L6:
                return this;
            L5:
                r0.setMessage(r2, r3.m96build());
                goto L6
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
                return m278addRepeatedField(r1, r2);
            }

            public Builder addTraceViewers(int r2, AssistAudioEventDataTraceViewer r3) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L8;
                if (r3 == null) goto L7;
                ensureTraceViewersIsMutable();
                ListProtector.add(this.traceViewers_, r2, r3);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.addMessage(r2, r3);
                goto L9
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m304mergeFrom(r1, r2);
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setField(Descriptors.FieldDescriptor r1, Object r2) {
                return m310setField(r1, r2);
            }

            public Builder setTraceViewers(int r2, AssistAudioEventDataTraceViewer r3) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L8;
                if (r3 == null) goto L7;
                ensureTraceViewersIsMutable();
                ListProtector.set(this.traceViewers_, r2, r3);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.setMessage(r2, r3);
                goto L9
            }

            /* JADX INFO: renamed from: addRepeatedField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m277addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
                return m278addRepeatedField(r1, r2);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder m300mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m304mergeFrom(r1, r2);
            }

            /* JADX INFO: renamed from: setField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m309setField(Descriptors.FieldDescriptor r1, Object r2) {
                return m310setField(r1, r2);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m301mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m304mergeFrom(r1, r2);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite.Builder m303mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m304mergeFrom(r1, r2);
            }

            /* JADX INFO: renamed from: setRepeatedField, reason: collision with other method in class */
            public Builder m312setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
                return (Builder) super.setRepeatedField(r1, r2, r3);
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
                return m312setRepeatedField(r1, r2, r3);
            }

            /* JADX INFO: renamed from: setRepeatedField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m311setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
                return m312setRepeatedField(r1, r2, r3);
            }
        }

        public static final class ExtraDefaultEntryHolder {
            static final MapEntry<String, String> defaultEntry = null;

            private ExtraDefaultEntryHolder() {
            }

            static {
                Descriptors.Descriptor r0 = AssistAudioEventProto.access$12700();
                WireFormat.FieldType r1 = WireFormat.FieldType.STRING;
                defaultEntry = MapEntry.newDefaultInstance(r0, r1, NameKeys.UnloadStrategy_No_Strategy, r1, NameKeys.UnloadStrategy_No_Strategy);
            }
        }

        static {
            DEFAULT_INSTANCE = new RealtimeCallEvent();
            PARSER = new AnonymousClass1();
        }

        private MapField<String, String> internalGetExtra() {
            MapField<String, String> r0 = this.extra_;
            if (r0 == null) goto L5;
            return r0;
        L5:
            return MapField.emptyMapField(ExtraDefaultEntryHolder.defaultEntry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m275toBuilder();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
        public String getEventName() {
            Object r0 = this.eventName_;
            if ((r0 instanceof String) == true) goto L5;
            ByteString r1 = (ByteString) r0;
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L9;
            this.eventName_ = r2;
        L9:
            return r2;
        L5:
            return (String) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
        public ByteString getEventNameBytes() {
            Object r0 = this.eventName_;
            if ((r0 instanceof String) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) r0);
            this.eventName_ = r1;
            return r1;
        L7:
            return (ByteString) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
        public String getEventReportSource() {
            Object r0 = this.eventReportSource_;
            if ((r0 instanceof String) == true) goto L5;
            ByteString r1 = (ByteString) r0;
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L9;
            this.eventReportSource_ = r2;
        L9:
            return r2;
        L5:
            return (String) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
        public ByteString getEventReportSourceBytes() {
            Object r0 = this.eventReportSource_;
            if ((r0 instanceof String) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) r0);
            this.eventReportSource_ = r1;
            return r1;
        L7:
            return (ByteString) r0;
        }

        public int getSerializedSize() {
            int r0 = ((AbstractMessage) this).memoizedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r2 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r1 = GeneratedMessageV3.computeStringSize(1, this.eventName_) + 0;
        L10:
            if ((this.bitField0_ & 2) != 2) goto L13;
            r1 = r1 + GeneratedMessageV3.computeStringSize(2, this.eventReportSource_);
        L13:
            if ((this.bitField0_ & 4) != 4) goto L16;
            r1 = r1 + GeneratedMessageV3.computeStringSize(3, this.traceId_);
        L16:
            if ((this.bitField0_ & 8) != 8) goto L18;
            r1 = r1 + CodedOutputStream.computeInt64Size(4, this.timestamp_);
        L18:
            Iterator r3 = internalGetExtra().getMap().entrySet().iterator();
        L20:
            if (r3.hasNext() == false) goto L23;
            Map.Entry r4 = (Map.Entry) r3.next();
            r1 = r1 + CodedOutputStream.computeMessageSize(5, ExtraDefaultEntryHolder.defaultEntry.newBuilderForType().setKey((String) r4.getKey()).setValue((String) r4.getValue()).build());
        L23:
            if (r2 >= this.traceViewers_.size()) goto L25;
            r1 = r1 + CodedOutputStream.computeMessageSize(6, (MessageLite) ListProtector.get(this.traceViewers_, r2));
            r2 = r2 + 1;
            goto L23
        L25:
            int r5 = r1 + ((GeneratedMessageV3) this).unknownFields.getSerializedSize();
            ((AbstractMessage) this).memoizedSize = r5;
            return r5;
        L8:
            r1 = 0;
            goto L10
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
        public String getTraceId() {
            Object r0 = this.traceId_;
            if ((r0 instanceof String) == true) goto L5;
            ByteString r1 = (ByteString) r0;
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L9;
            this.traceId_ = r2;
        L9:
            return r2;
        L5:
            return (String) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
        public ByteString getTraceIdBytes() {
            Object r0 = this.traceId_;
            if ((r0 instanceof String) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) r0);
            this.traceId_ = r1;
            return r1;
        L7:
            return (ByteString) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
        public int getTraceViewersCount() {
            return this.traceViewers_.size();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
        public boolean hasEventName() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
        public boolean hasEventReportSource() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
        public boolean hasTimestamp() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
        public boolean hasTraceId() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public int hashCode() {
            int r0 = ((AbstractMessageLite) this).memoizedHashCode;
            if (r0 == 0) goto L5;
            return r0;
        L5:
            int r1 = 779 + getDescriptor().hashCode();
            if (hasEventName() == false) goto L9;
            r1 = (((r1 * 37) + 1) * 53) + getEventName().hashCode();
        L9:
            if (hasEventReportSource() == false) goto L12;
            r1 = (((r1 * 37) + 2) * 53) + getEventReportSource().hashCode();
        L12:
            if (hasTraceId() == false) goto L15;
            r1 = (((r1 * 37) + 3) * 53) + getTraceId().hashCode();
        L15:
            if (hasTimestamp() == false) goto L18;
            r1 = (((r1 * 37) + 4) * 53) + Internal.hashLong(getTimestamp());
        L18:
            if (internalGetExtra().getMap().isEmpty() == true) goto L21;
            r1 = (((r1 * 37) + 5) * 53) + internalGetExtra().hashCode();
        L21:
            if (getTraceViewersCount() <= 0) goto L23;
            r1 = (((r1 * 37) + 6) * 53) + getTraceViewersList().hashCode();
        L23:
            int r2 = (r1 * 29) + ((GeneratedMessageV3) this).unknownFields.hashCode();
            ((AbstractMessageLite) this).memoizedHashCode = r2;
            return r2;
        }

        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L5;
            return true;
        L5:
            if (r0 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        /* JADX INFO: renamed from: toBuilder, reason: collision with other method in class */
        public Builder m275toBuilder() {
            AnonymousClass1 r1 = null;
            if (this != DEFAULT_INSTANCE) goto L6;
            return new Builder(r1);
        L6:
            return new Builder(r1).mergeFrom(this);
        }

        private RealtimeCallEvent() {
            this.memoizedIsInitialized = -1;
            this.eventName_ = NameKeys.UnloadStrategy_No_Strategy;
            this.eventReportSource_ = NameKeys.UnloadStrategy_No_Strategy;
            this.traceId_ = NameKeys.UnloadStrategy_No_Strategy;
            this.timestamp_ = 0;
            this.traceViewers_ = Collections.emptyList();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AssistAudioEventProto.access$12500();
        }

        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return m270getDefaultInstanceForType();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
        public Map<String, String> getExtra() {
            return getExtraMap();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
        public int getExtraCount() {
            return internalGetExtra().getMap().size();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
        public Map<String, String> getExtraMap() {
            return internalGetExtra().getMap();
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AssistAudioEventProto.access$12600().ensureFieldAccessorsInitialized(RealtimeCallEvent.class, Builder.class);
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return m272newBuilderForType();
        }

        public static /* synthetic */ boolean access$13000() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ boolean access$14000() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static RealtimeCallEvent getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RealtimeCallEvent> parser() {
            return PARSER;
        }

        public Parser<RealtimeCallEvent> getParserForType() {
            return PARSER;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
        public List<AssistAudioEventDataTraceViewer> getTraceViewersList() {
            return this.traceViewers_;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
        public List<? extends AssistAudioEventDataTraceViewerOrBuilder> getTraceViewersOrBuilderList() {
            return this.traceViewers_;
        }

        public final UnknownFieldSet getUnknownFields() {
            return ((GeneratedMessageV3) this).unknownFields;
        }

        /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite m269getDefaultInstanceForType() {
            return m270getDefaultInstanceForType();
        }

        /* JADX INFO: renamed from: newBuilderForType, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite.Builder m271newBuilderForType() {
            return m272newBuilderForType();
        }

        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return m275toBuilder();
        }

        /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
        public RealtimeCallEvent m270getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: renamed from: newBuilderForType, reason: collision with other method in class */
        public Builder m272newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: renamed from: toBuilder, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite.Builder m274toBuilder() {
            return m275toBuilder();
        }

        private RealtimeCallEvent(GeneratedMessageV3.Builder<?> r1) {
            super(r1);
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ Object access$13200(RealtimeCallEvent r0) {
            return r0.eventName_;
        }

        public static /* synthetic */ Object access$13300(RealtimeCallEvent r0) {
            return r0.eventReportSource_;
        }

        public static /* synthetic */ Object access$13400(RealtimeCallEvent r0) {
            return r0.traceId_;
        }

        public static /* synthetic */ MapField access$13600(RealtimeCallEvent r0) {
            return r0.extra_;
        }

        public static /* synthetic */ List access$13700(RealtimeCallEvent r0) {
            return r0.traceViewers_;
        }

        public static /* synthetic */ MapField access$13900(RealtimeCallEvent r0) {
            return r0.internalGetExtra();
        }

        public static /* synthetic */ UnknownFieldSet access$14100(RealtimeCallEvent r0) {
            return ((GeneratedMessageV3) r0).unknownFields;
        }

        public static Builder newBuilder(RealtimeCallEvent r1) {
            return DEFAULT_INSTANCE.m275toBuilder().mergeFrom(r1);
        }

        public static RealtimeCallEvent parseDelimitedFrom(InputStream r1) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r1);
        }

        public static RealtimeCallEvent parseFrom(ByteString r1) throws InvalidProtocolBufferException {
            return (RealtimeCallEvent) PARSER.parseFrom(r1);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
        public boolean containsExtra(String r2) {
            if (r2 == null) goto L6;
            return internalGetExtra().getMap().containsKey(r2);
        L6:
            throw null;
        }

        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof RealtimeCallEvent) == false) goto L8;
            RealtimeCallEvent r9 = (RealtimeCallEvent) r8;
            if (hasEventName() != r9.hasEventName()) goto L12;
            boolean r1 = true;
        L14:
            if (hasEventName() == false) goto L20;
            if (r1 == true) goto L17;
        L19:
            r1 = false;
            goto L20
        L17:
            if (getEventName().equals(r9.getEventName()) == false) goto L19;
            r1 = true;
        L20:
            if (r1 == true) goto L22;
        L24:
            boolean r2 = false;
        L26:
            if (hasEventReportSource() == false) goto L32;
            if (r2 == true) goto L29;
        L31:
            r2 = false;
            goto L32
        L29:
            if (getEventReportSource().equals(r9.getEventReportSource()) == false) goto L31;
            r2 = true;
        L32:
            if (r2 == true) goto L34;
        L36:
            boolean r3 = false;
        L38:
            if (hasTraceId() == false) goto L44;
            if (r3 == true) goto L41;
        L43:
            r3 = false;
            goto L44
        L41:
            if (getTraceId().equals(r9.getTraceId()) == false) goto L43;
            r3 = true;
        L44:
            if (r3 == true) goto L46;
        L48:
            boolean r4 = false;
        L50:
            if (hasTimestamp() == false) goto L56;
            if (r4 == true) goto L53;
        L55:
            r4 = false;
            goto L56
        L53:
            if (getTimestamp() != r9.getTimestamp()) goto L55;
            r4 = true;
        L56:
            if (r4 == true) goto L58;
        L60:
            boolean r5 = false;
        L61:
            if (r5 == true) goto L63;
        L65:
            boolean r6 = false;
        L66:
            if (r6 == true) goto L68;
        L70:
            return false;
        L68:
            if (((GeneratedMessageV3) this).unknownFields.equals(((GeneratedMessageV3) r9).unknownFields) == false) goto L70;
            return true;
        L63:
            if (getTraceViewersList().equals(r9.getTraceViewersList()) == false) goto L65;
            r6 = true;
            goto L66
        L58:
            if (internalGetExtra().equals(r9.internalGetExtra()) == false) goto L60;
            r5 = true;
            goto L61
        L46:
            if (hasTimestamp() != r9.hasTimestamp()) goto L48;
            r4 = true;
            goto L50
        L34:
            if (hasTraceId() != r9.hasTraceId()) goto L36;
            r3 = true;
            goto L38
        L22:
            if (hasEventReportSource() != r9.hasEventReportSource()) goto L24;
            r2 = true;
            goto L26
        L12:
            r1 = false;
            goto L14
        L8:
            return super/*com.google.protobuf.AbstractMessage*/.equals(r8);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
        public String getExtraOrThrow(String r3) {
            if (r3 == null) goto L10;
            Map r0 = internalGetExtra().getMap();
            if (r0.containsKey(r3) == false) goto L8;
            return (String) r0.get(r3);
        L8:
            throw new IllegalArgumentException();
        L10:
            throw null;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
        public AssistAudioEventDataTraceViewer getTraceViewers(int r2) {
            return (AssistAudioEventDataTraceViewer) ListProtector.get(this.traceViewers_, r2);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
        public AssistAudioEventDataTraceViewerOrBuilder getTraceViewersOrBuilder(int r2) {
            return (AssistAudioEventDataTraceViewerOrBuilder) ListProtector.get(this.traceViewers_, r2);
        }

        public MapField internalGetMapField(int r4) {
            if (r4 != 5) goto L7;
            return internalGetExtra();
        L7:
            throw new RuntimeException("Invalid map field number: " + r4);
        }

        /* JADX INFO: renamed from: newBuilderForType, reason: collision with other method in class */
        public Builder m273newBuilderForType(GeneratedMessageV3.BuilderParent r3) {
            return new Builder(r3, null);
        }

        public void writeTo(CodedOutputStream r5) throws IOException {
            if ((this.bitField0_ & 1) != 1) goto L6;
            GeneratedMessageV3.writeString(r5, 1, this.eventName_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            GeneratedMessageV3.writeString(r5, 2, this.eventReportSource_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L12;
            GeneratedMessageV3.writeString(r5, 3, this.traceId_);
        L12:
            if ((this.bitField0_ & 8) != 8) goto L14;
            r5.writeInt64(4, this.timestamp_);
        L14:
            GeneratedMessageV3.serializeStringMapTo(r5, internalGetExtra(), ExtraDefaultEntryHolder.defaultEntry, 5);
            int r0 = 0;
        L16:
            if (r0 >= this.traceViewers_.size()) goto L18;
            r5.writeMessage(6, (MessageLite) ListProtector.get(this.traceViewers_, r0));
            r0 = r0 + 1;
            goto L16
        L18:
            ((GeneratedMessageV3) this).unknownFields.writeTo(r5);
        }

        public static RealtimeCallEvent parseFrom(CodedInputStream r1) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1);
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r1) {
            return m273newBuilderForType(r1);
        }

        public static RealtimeCallEvent parseFrom(InputStream r1) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1);
        }

        public static RealtimeCallEvent parseFrom(ByteBuffer r1) throws InvalidProtocolBufferException {
            return (RealtimeCallEvent) PARSER.parseFrom(r1);
        }

        public static RealtimeCallEvent parseFrom(byte[] r1) throws InvalidProtocolBufferException {
            return (RealtimeCallEvent) PARSER.parseFrom(r1);
        }

        private RealtimeCallEvent(CodedInputStream r8, ExtensionRegistryLite r9) throws InvalidProtocolBufferException {
            this();
            if (r9 == null) goto L56;
            UnknownFieldSet.Builder r0 = UnknownFieldSet.newBuilder();
            boolean r1 = false;
            int r2 = 0;
        L6:
            if (r1 == true) goto L51;
            int r4 = r8.readTag();     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
            if (r4 == 0) goto L36;
            if (r4 != 10) goto L12;
            ByteString r5 = r8.readBytes();     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
            this.bitField0_ = 1 | this.bitField0_;     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
            this.eventName_ = r5;     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
            goto L6
        L12:
            if (r4 != 18) goto L14;
            ByteString r6 = r8.readBytes();     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
            this.bitField0_ |= 2;     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
            this.eventReportSource_ = r6;     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
            goto L6
        L14:
            if (r4 != 26) goto L15;
            ByteString r7 = r8.readBytes();     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
            this.bitField0_ |= 4;     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
            this.traceId_ = r7;     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
            goto L6
        L15:
            if (r4 != 32) goto L17;
            this.bitField0_ |= 8;     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
            this.timestamp_ = r8.readInt64();     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
            goto L6
        L17:
            if (r4 != 42) goto L19;
            if ((r2 & 16) == 16) goto L30;
            this.extra_ = MapField.newMapField(ExtraDefaultEntryHolder.defaultEntry);     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
            r2 = r2 | 16;     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
        L30:
            MapEntry r10 = r8.readMessage(ExtraDefaultEntryHolder.defaultEntry.getParserForType(), r9);     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
            this.extra_.getMutableMap().put((String) r10.getKey(), (String) r10.getValue());     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
            goto L6
        L19:
            if (r4 != 50) goto L21;
            if ((r2 & 32) == 32) goto L26;
            this.traceViewers_ = new ArrayList();     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
            r2 = r2 | 32;     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
        L26:
            this.traceViewers_.add((AssistAudioEventDataTraceViewer) r8.readMessage(AssistAudioEventDataTraceViewer.PARSER, r9));     // Catch: Throwable -> L37 IOException -> L39 InvalidProtocolBufferException -> L42
            goto L6
        L21:
            if (parseUnknownField(r8, r0, r9, r4) == true) goto L6;
        L36:
            r1 = true;
            goto L6
        L37:
            th = move-exception;
            if ((r2 & 32) != 32) goto L48;
            this.traceViewers_ = Collections.unmodifiableList(this.traceViewers_);
        L48:
            ((GeneratedMessageV3) this).unknownFields = r0.build();
            makeExtensionsImmutable();
            throw th;
        L42:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L37
        L39:
            e = move-exception;
            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L37
        L51:
            if ((r2 & 32) != 32) goto L53;
            this.traceViewers_ = Collections.unmodifiableList(this.traceViewers_);
        L53:
            ((GeneratedMessageV3) this).unknownFields = r0.build();
            makeExtensionsImmutable();
            return;
        L56:
            throw null;
        }

        public static /* synthetic */ Object access$13202(RealtimeCallEvent r0, Object r1) {
            r0.eventName_ = r1;
            return r1;
        }

        public static /* synthetic */ Object access$13302(RealtimeCallEvent r0, Object r1) {
            r0.eventReportSource_ = r1;
            return r1;
        }

        public static /* synthetic */ Object access$13402(RealtimeCallEvent r0, Object r1) {
            r0.traceId_ = r1;
            return r1;
        }

        public static /* synthetic */ long access$13502(RealtimeCallEvent r0, long r1) {
            r0.timestamp_ = r1;
            return r1;
        }

        public static /* synthetic */ MapField access$13602(RealtimeCallEvent r0, MapField r1) {
            r0.extra_ = r1;
            return r1;
        }

        public static /* synthetic */ List access$13702(RealtimeCallEvent r0, List r1) {
            r0.traceViewers_ = r1;
            return r1;
        }

        public static /* synthetic */ int access$13802(RealtimeCallEvent r0, int r1) {
            r0.bitField0_ = r1;
            return r1;
        }

        public static RealtimeCallEvent parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r1, r2);
        }

        public static RealtimeCallEvent parseFrom(ByteString r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
            return (RealtimeCallEvent) PARSER.parseFrom(r1, r2);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.RealtimeCallEventOrBuilder
        public String getExtraOrDefault(String r3, String r4) {
            if (r3 == null) goto L8;
            Map r0 = internalGetExtra().getMap();
            if (r0.containsKey(r3) == true) goto L6;
            return r4;
        L6:
            return (String) r0.get(r3);
        L8:
            throw null;
        }

        public /* synthetic */ RealtimeCallEvent(GeneratedMessageV3.Builder r1, AnonymousClass1 r2) {
            this(r1);
        }

        public static RealtimeCallEvent parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1, r2);
        }

        public static RealtimeCallEvent parseFrom(InputStream r1, ExtensionRegistryLite r2) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1, r2);
        }

        public static RealtimeCallEvent parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
            return (RealtimeCallEvent) PARSER.parseFrom(r1, r2);
        }

        public static RealtimeCallEvent parseFrom(byte[] r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
            return (RealtimeCallEvent) PARSER.parseFrom(r1, r2);
        }

        public /* synthetic */ RealtimeCallEvent(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }
    }

    public interface RealtimeCallEventOrBuilder extends MessageOrBuilder {
        boolean containsExtra(String r1);

        String getEventName();

        ByteString getEventNameBytes();

        String getEventReportSource();

        ByteString getEventReportSourceBytes();

        Map<String, String> getExtra();

        int getExtraCount();

        Map<String, String> getExtraMap();

        String getExtraOrDefault(String r1, String r2);

        String getExtraOrThrow(String r1);

        long getTimestamp();

        String getTraceId();

        ByteString getTraceIdBytes();

        AssistAudioEventDataTraceViewer getTraceViewers(int r1);

        int getTraceViewersCount();

        List<AssistAudioEventDataTraceViewer> getTraceViewersList();

        AssistAudioEventDataTraceViewerOrBuilder getTraceViewersOrBuilder(int r1);

        List<? extends AssistAudioEventDataTraceViewerOrBuilder> getTraceViewersOrBuilderList();

        boolean hasEventName();

        boolean hasEventReportSource();

        boolean hasTimestamp();

        boolean hasTraceId();
    }

    public static final class VoiceWakeupDuration extends GeneratedMessageV3 implements VoiceWakeupDurationOrBuilder {
        private static final VoiceWakeupDuration DEFAULT_INSTANCE = null;
        public static final int END_TIMESTAMP_FIELD_NUMBER = 5;
        public static final int EVENT_NAME_FIELD_NUMBER = 1;
        public static final int EVENT_REPORT_SOURCE_FIELD_NUMBER = 2;
        public static final int EXTRA_FIELD_NUMBER = 9;
        public static final Parser<VoiceWakeupDuration> PARSER = null;
        public static final int START_TIMESTAMP_FIELD_NUMBER = 4;
        public static final int TRACE_ID_FIELD_NUMBER = 3;
        public static final int TRACE_VIEWERS_FIELD_NUMBER = 10;
        public static final int WAKEUP_STAGE1_DURATION_FIELD_NUMBER = 6;
        public static final int WAKEUP_STAGE2_DURATION_FIELD_NUMBER = 7;
        public static final int WAKEUP_STAGE3_DURATION_FIELD_NUMBER = 8;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private long endTimestamp_;
        private volatile Object eventName_;
        private volatile Object eventReportSource_;
        private MapField<String, String> extra_;
        private byte memoizedIsInitialized;
        private long startTimestamp_;
        private volatile Object traceId_;
        private List<AssistAudioEventDataTraceViewer> traceViewers_;
        private long wakeupStage1Duration_;
        private long wakeupStage2Duration_;
        private long wakeupStage3Duration_;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements VoiceWakeupDurationOrBuilder {
            private int bitField0_;
            private long endTimestamp_;
            private Object eventName_;
            private Object eventReportSource_;
            private MapField<String, String> extra_;
            private long startTimestamp_;
            private Object traceId_;
            private RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> traceViewersBuilder_;
            private List<AssistAudioEventDataTraceViewer> traceViewers_;
            private long wakeupStage1Duration_;
            private long wakeupStage2Duration_;
            private long wakeupStage3Duration_;

            public final boolean isInitialized() {
                return true;
            }

            private void ensureTraceViewersIsMutable() {
                if ((this.bitField0_ & 512) == 512) goto L6;
                this.traceViewers_ = new ArrayList(this.traceViewers_);
                this.bitField0_ |= 512;
                return;
            }

            private RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> getTraceViewersFieldBuilder() {
                if (this.traceViewersBuilder_ != null) goto L10;
                List<AssistAudioEventDataTraceViewer> r1 = this.traceViewers_;
                if ((this.bitField0_ & 512) != 512) goto L7;
                boolean r2 = true;
            L8:
                this.traceViewersBuilder_ = new RepeatedFieldBuilderV3(r1, r2, getParentForChildren(), isClean());
                this.traceViewers_ = null;
                goto L10
            L7:
                r2 = false;
            L10:
                return this.traceViewersBuilder_;
            }

            private MapField<String, String> internalGetExtra() {
                MapField<String, String> r0 = this.extra_;
                if (r0 == null) goto L5;
                return r0;
            L5:
                return MapField.emptyMapField(ExtraDefaultEntryHolder.defaultEntry);
            }

            /* JADX INFO: renamed from: buildPartial, reason: collision with other method in class */
            public VoiceWakeupDuration m328buildPartial() {
                VoiceWakeupDuration r0 = new VoiceWakeupDuration(this, null);
                int r1 = this.bitField0_;
                int r3 = 1;
                if ((r1 & 1) == 1) goto L6;
                r3 = 0;
            L6:
                VoiceWakeupDuration.access$2702(r0, this.eventName_);
                if ((r1 & 2) != 2) goto L9;
                r3 = r3 | 2;
            L9:
                VoiceWakeupDuration.access$2802(r0, this.eventReportSource_);
                if ((r1 & 4) != 4) goto L12;
                r3 = r3 | 4;
            L12:
                VoiceWakeupDuration.access$2902(r0, this.traceId_);
                if ((r1 & 8) != 8) goto L15;
                r3 = r3 | 8;
            L15:
                VoiceWakeupDuration.access$3002(r0, this.startTimestamp_);
                if ((r1 & 16) != 16) goto L18;
                r3 = r3 | 16;
            L18:
                VoiceWakeupDuration.access$3102(r0, this.endTimestamp_);
                if ((r1 & 32) != 32) goto L21;
                r3 = r3 | 32;
            L21:
                VoiceWakeupDuration.access$3202(r0, this.wakeupStage1Duration_);
                if ((r1 & 64) != 64) goto L24;
                r3 = r3 | 64;
            L24:
                VoiceWakeupDuration.access$3302(r0, this.wakeupStage2Duration_);
                if ((r1 & LynxTouchEvent.kPseudoStateFocusTransition) != 128) goto L27;
                r3 = r3 | LynxTouchEvent.kPseudoStateFocusTransition;
            L27:
                VoiceWakeupDuration.access$3402(r0, this.wakeupStage3Duration_);
                VoiceWakeupDuration.access$3502(r0, internalGetExtra());
                VoiceWakeupDuration.access$3500(r0).makeImmutable();
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r2 = this.traceViewersBuilder_;
                if (r2 == null) goto L30;
                VoiceWakeupDuration.access$3602(r0, r2.build());
            L34:
                VoiceWakeupDuration.access$3702(r0, r3);
                onBuilt();
                return r0;
            L30:
                if ((this.bitField0_ & 512) != 512) goto L32;
                this.traceViewers_ = Collections.unmodifiableList(this.traceViewers_);
                this.bitField0_ &= -513;
            L32:
                VoiceWakeupDuration.access$3602(r0, this.traceViewers_);
                goto L34
            }

            public Builder clearEndTimestamp() {
                this.bitField0_ &= -17;
                this.endTimestamp_ = 0;
                onChanged();
                return this;
            }

            public Builder clearEventName() {
                this.bitField0_ &= -2;
                this.eventName_ = VoiceWakeupDuration.getDefaultInstance().getEventName();
                onChanged();
                return this;
            }

            public Builder clearEventReportSource() {
                this.bitField0_ &= -3;
                this.eventReportSource_ = VoiceWakeupDuration.getDefaultInstance().getEventReportSource();
                onChanged();
                return this;
            }

            public Builder clearStartTimestamp() {
                this.bitField0_ &= -9;
                this.startTimestamp_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTraceId() {
                this.bitField0_ &= -5;
                this.traceId_ = VoiceWakeupDuration.getDefaultInstance().getTraceId();
                onChanged();
                return this;
            }

            public Builder clearTraceViewers() {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                this.traceViewers_ = Collections.emptyList();
                this.bitField0_ &= -513;
                onChanged();
            L6:
                return this;
            L5:
                r0.clear();
                goto L6
            }

            public Builder clearWakeupStage1Duration() {
                this.bitField0_ &= -33;
                this.wakeupStage1Duration_ = 0;
                onChanged();
                return this;
            }

            public Builder clearWakeupStage2Duration() {
                this.bitField0_ &= -65;
                this.wakeupStage2Duration_ = 0;
                onChanged();
                return this;
            }

            public Builder clearWakeupStage3Duration() {
                this.bitField0_ &= -129;
                this.wakeupStage3Duration_ = 0;
                onChanged();
                return this;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
            public String getEventName() {
                Object r0 = this.eventName_;
                if ((r0 instanceof String) == true) goto L9;
                ByteString r1 = (ByteString) r0;
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L7;
                this.eventName_ = r2;
            L7:
                return r2;
            L9:
                return (String) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
            public ByteString getEventNameBytes() {
                Object r0 = this.eventName_;
                if ((r0 instanceof String) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) r0);
                this.eventName_ = r1;
                return r1;
            L7:
                return (ByteString) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
            public String getEventReportSource() {
                Object r0 = this.eventReportSource_;
                if ((r0 instanceof String) == true) goto L9;
                ByteString r1 = (ByteString) r0;
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L7;
                this.eventReportSource_ = r2;
            L7:
                return r2;
            L9:
                return (String) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
            public ByteString getEventReportSourceBytes() {
                Object r0 = this.eventReportSource_;
                if ((r0 instanceof String) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) r0);
                this.eventReportSource_ = r1;
                return r1;
            L7:
                return (ByteString) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
            public String getTraceId() {
                Object r0 = this.traceId_;
                if ((r0 instanceof String) == true) goto L9;
                ByteString r1 = (ByteString) r0;
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L7;
                this.traceId_ = r2;
            L7:
                return r2;
            L9:
                return (String) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
            public ByteString getTraceIdBytes() {
                Object r0 = this.traceId_;
                if ((r0 instanceof String) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) r0);
                this.traceId_ = r1;
                return r1;
            L7:
                return (ByteString) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
            public int getTraceViewersCount() {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L7;
                return this.traceViewers_.size();
            L7:
                return r0.getCount();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
            public List<AssistAudioEventDataTraceViewer> getTraceViewersList() {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L7;
                return Collections.unmodifiableList(this.traceViewers_);
            L7:
                return r0.getMessageList();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
            public List<? extends AssistAudioEventDataTraceViewerOrBuilder> getTraceViewersOrBuilderList() {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 == null) goto L7;
                return r0.getMessageOrBuilderList();
            L7:
                return Collections.unmodifiableList(this.traceViewers_);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
            public boolean hasEndTimestamp() {
                if ((this.bitField0_ & 16) != 16) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
            public boolean hasEventName() {
                if ((this.bitField0_ & 1) == 1) goto L7;
                return false;
            L7:
                return true;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
            public boolean hasEventReportSource() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
            public boolean hasStartTimestamp() {
                if ((this.bitField0_ & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
            public boolean hasTraceId() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
            public boolean hasWakeupStage1Duration() {
                if ((this.bitField0_ & 32) != 32) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
            public boolean hasWakeupStage2Duration() {
                if ((this.bitField0_ & 64) != 64) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
            public boolean hasWakeupStage3Duration() {
                if ((this.bitField0_ & LynxTouchEvent.kPseudoStateFocusTransition) != 128) goto L5;
                return true;
            L5:
                return false;
            }

            private Builder() {
                this.eventName_ = NameKeys.UnloadStrategy_No_Strategy;
                this.eventReportSource_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceId_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceViewers_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AssistAudioEventProto.access$2000();
            }

            private MapField<String, String> internalGetMutableExtra() {
                onChanged();
                if (this.extra_ != null) goto L6;
                this.extra_ = MapField.newMapField(ExtraDefaultEntryHolder.defaultEntry);
            L6:
                if (this.extra_.isMutable() == true) goto L9;
                this.extra_ = this.extra_.copy();
            L9:
                return this.extra_;
            }

            private void maybeForceBuilderInitialization() {
                if (VoiceWakeupDuration.access$2500() == false) goto L6;
                getTraceViewersFieldBuilder();
                return;
            }

            public AssistAudioEventDataTraceViewer.Builder addTraceViewersBuilder() {
                return getTraceViewersFieldBuilder().addBuilder(AssistAudioEventDataTraceViewer.getDefaultInstance());
            }

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public VoiceWakeupDuration m326build() {
                VoiceWakeupDuration r0 = m328buildPartial();
                if (r0.isInitialized() == false) goto L6;
                return r0;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r0);
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public Builder m332clear() {
                super.clear();
                this.eventName_ = NameKeys.UnloadStrategy_No_Strategy;
                int r1 = this.bitField0_ & (-2);
                this.eventReportSource_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceId_ = NameKeys.UnloadStrategy_No_Strategy;
                this.startTimestamp_ = 0;
                this.endTimestamp_ = 0;
                this.wakeupStage1Duration_ = 0;
                this.wakeupStage2Duration_ = 0;
                this.wakeupStage3Duration_ = 0;
                this.bitField0_ = ((((((r1 & (-3)) & (-5)) & (-9)) & (-17)) & (-33)) & (-65)) & (-129);
                internalGetMutableExtra().clear();
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                this.traceViewers_ = Collections.emptyList();
                this.bitField0_ &= -513;
            L6:
                return this;
            L5:
                r0.clear();
                goto L6
            }

            public Builder clearExtra() {
                internalGetMutableExtra().getMutableMap().clear();
                return this;
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public Builder m342clone() {
                return (Builder) super.clone();
            }

            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return m345getDefaultInstanceForType();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return AssistAudioEventProto.access$2000();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
            public Map<String, String> getExtra() {
                return getExtraMap();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
            public int getExtraCount() {
                return internalGetExtra().getMap().size();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
            public Map<String, String> getExtraMap() {
                return internalGetExtra().getMap();
            }

            public Map<String, String> getMutableExtra() {
                return internalGetMutableExtra().getMutableMap();
            }

            public List<AssistAudioEventDataTraceViewer.Builder> getTraceViewersBuilderList() {
                return getTraceViewersFieldBuilder().getBuilderList();
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AssistAudioEventProto.access$2100().ensureFieldAccessorsInitialized(VoiceWakeupDuration.class, Builder.class);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
            public long getEndTimestamp() {
                return this.endTimestamp_;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
            public long getStartTimestamp() {
                return this.startTimestamp_;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
            public long getWakeupStage1Duration() {
                return this.wakeupStage1Duration_;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
            public long getWakeupStage2Duration() {
                return this.wakeupStage2Duration_;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
            public long getWakeupStage3Duration() {
                return this.wakeupStage3Duration_;
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m326build();
            }

            public /* bridge */ /* synthetic */ Message buildPartial() {
                return m328buildPartial();
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
                return m332clear();
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
                return m342clone();
            }

            /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite m344getDefaultInstanceForType() {
                return m345getDefaultInstanceForType();
            }

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite m325build() {
                return m326build();
            }

            /* JADX INFO: renamed from: buildPartial, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite m327buildPartial() {
                return m328buildPartial();
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m329clear() {
                return m332clear();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder m338clone() {
                return m342clone();
            }

            /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
            public VoiceWakeupDuration m345getDefaultInstanceForType() {
                return VoiceWakeupDuration.getDefaultInstance();
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m330clear() {
                return m332clear();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m339clone() {
                return m342clone();
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite.Builder m331clear() {
                return m332clear();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m340clone() {
                return m342clone();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite.Builder m341clone() {
                return m342clone();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m343clone() throws CloneNotSupportedException {
                return m342clone();
            }

            private Builder(GeneratedMessageV3.BuilderParent r1) {
                super(r1);
                this.eventName_ = NameKeys.UnloadStrategy_No_Strategy;
                this.eventReportSource_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceId_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceViewers_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public Builder addAllTraceViewers(Iterable<? extends AssistAudioEventDataTraceViewer> r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                ensureTraceViewersIsMutable();
                AbstractMessageLite.Builder.addAll(r2, this.traceViewers_);
                onChanged();
            L6:
                return this;
            L5:
                r0.addAllMessages(r2);
                goto L6
            }

            public Builder addTraceViewers(AssistAudioEventDataTraceViewer.Builder r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                ensureTraceViewersIsMutable();
                this.traceViewers_.add(r2.m96build());
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2.m96build());
                goto L6
            }

            public AssistAudioEventDataTraceViewer.Builder addTraceViewersBuilder(int r3) {
                return getTraceViewersFieldBuilder().addBuilder(r3, AssistAudioEventDataTraceViewer.getDefaultInstance());
            }

            /* JADX INFO: renamed from: clearField, reason: collision with other method in class */
            public Builder m334clearField(Descriptors.FieldDescriptor r1) {
                return (Builder) super.clearField(r1);
            }

            /* JADX INFO: renamed from: clearOneof, reason: collision with other method in class */
            public Builder m337clearOneof(Descriptors.OneofDescriptor r1) {
                return (Builder) super.clearOneof(r1);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
            public boolean containsExtra(String r2) {
                if (r2 == null) goto L6;
                return internalGetExtra().getMap().containsKey(r2);
            L6:
                throw null;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
            public String getExtraOrThrow(String r3) {
                if (r3 == null) goto L10;
                Map r0 = internalGetExtra().getMap();
                if (r0.containsKey(r3) == false) goto L8;
                return (String) r0.get(r3);
            L8:
                throw new IllegalArgumentException();
            L10:
                throw null;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
            public AssistAudioEventDataTraceViewer getTraceViewers(int r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L7;
                return (AssistAudioEventDataTraceViewer) ListProtector.get(this.traceViewers_, r2);
            L7:
                return r0.getMessage(r2);
            }

            public AssistAudioEventDataTraceViewer.Builder getTraceViewersBuilder(int r2) {
                return getTraceViewersFieldBuilder().getBuilder(r2);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
            public AssistAudioEventDataTraceViewerOrBuilder getTraceViewersOrBuilder(int r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L7;
                return (AssistAudioEventDataTraceViewerOrBuilder) ListProtector.get(this.traceViewers_, r2);
            L7:
                return (AssistAudioEventDataTraceViewerOrBuilder) r0.getMessageOrBuilder(r2);
            }

            public MapField internalGetMapField(int r4) {
                if (r4 != 9) goto L7;
                return internalGetExtra();
            L7:
                throw new RuntimeException("Invalid map field number: " + r4);
            }

            public MapField internalGetMutableMapField(int r4) {
                if (r4 != 9) goto L7;
                return internalGetMutableExtra();
            L7:
                throw new RuntimeException("Invalid map field number: " + r4);
            }

            public Builder mergeFrom(VoiceWakeupDuration r3) {
                if (r3 != VoiceWakeupDuration.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r3.hasEventName() == false) goto L9;
                this.bitField0_ |= 1;
                this.eventName_ = VoiceWakeupDuration.access$2700(r3);
                onChanged();
            L9:
                if (r3.hasEventReportSource() == false) goto L12;
                this.bitField0_ |= 2;
                this.eventReportSource_ = VoiceWakeupDuration.access$2800(r3);
                onChanged();
            L12:
                if (r3.hasTraceId() == false) goto L15;
                this.bitField0_ |= 4;
                this.traceId_ = VoiceWakeupDuration.access$2900(r3);
                onChanged();
            L15:
                if (r3.hasStartTimestamp() == false) goto L18;
                setStartTimestamp(r3.getStartTimestamp());
            L18:
                if (r3.hasEndTimestamp() == false) goto L21;
                setEndTimestamp(r3.getEndTimestamp());
            L21:
                if (r3.hasWakeupStage1Duration() == false) goto L24;
                setWakeupStage1Duration(r3.getWakeupStage1Duration());
            L24:
                if (r3.hasWakeupStage2Duration() == false) goto L27;
                setWakeupStage2Duration(r3.getWakeupStage2Duration());
            L27:
                if (r3.hasWakeupStage3Duration() == false) goto L29;
                setWakeupStage3Duration(r3.getWakeupStage3Duration());
            L29:
                internalGetMutableExtra().mergeFrom(VoiceWakeupDuration.access$3800(r3));
                if (this.traceViewersBuilder_ != null) goto L39;
                if (VoiceWakeupDuration.access$3600(r3).isEmpty() == false) goto L34;
            L47:
                m354mergeUnknownFields(VoiceWakeupDuration.access$4000(r3));
                onChanged();
                return this;
            L34:
                if (this.traceViewers_.isEmpty() == false) goto L36;
                this.traceViewers_ = VoiceWakeupDuration.access$3600(r3);
                this.bitField0_ &= -513;
            L37:
                onChanged();
                goto L47
            L36:
                ensureTraceViewersIsMutable();
                this.traceViewers_.addAll(VoiceWakeupDuration.access$3600(r3));
                goto L37
            L39:
                if (VoiceWakeupDuration.access$3600(r3).isEmpty() == true) goto L47;
                if (this.traceViewersBuilder_.isEmpty() == false) goto L46;
                this.traceViewersBuilder_.dispose();
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = null;
                this.traceViewersBuilder_ = null;
                this.traceViewers_ = VoiceWakeupDuration.access$3600(r3);
                this.bitField0_ &= -513;
                if (VoiceWakeupDuration.access$3900() == false) goto L45;
                r0 = getTraceViewersFieldBuilder();
            L45:
                this.traceViewersBuilder_ = r0;
                goto L47
            L46:
                this.traceViewersBuilder_.addAllMessages(VoiceWakeupDuration.access$3600(r3));
                goto L47
            }

            /* JADX INFO: renamed from: mergeUnknownFields, reason: collision with other method in class */
            public final Builder m354mergeUnknownFields(UnknownFieldSet r1) {
                return (Builder) super.mergeUnknownFields(r1);
            }

            public Builder putAllExtra(Map<String, String> r2) {
                internalGetMutableExtra().getMutableMap().putAll(r2);
                return this;
            }

            public Builder removeExtra(String r2) {
                if (r2 == null) goto L6;
                internalGetMutableExtra().getMutableMap().remove(r2);
                return this;
            L6:
                throw null;
            }

            public Builder removeTraceViewers(int r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                ensureTraceViewersIsMutable();
                ListProtector.remove(this.traceViewers_, r2);
                onChanged();
            L6:
                return this;
            L5:
                r0.remove(r2);
                goto L6
            }

            public Builder setEndTimestamp(long r2) {
                this.bitField0_ |= 16;
                this.endTimestamp_ = r2;
                onChanged();
                return this;
            }

            public Builder setEventName(String r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 1;
                this.eventName_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setEventNameBytes(ByteString r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 1;
                this.eventName_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setEventReportSource(String r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 2;
                this.eventReportSource_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setEventReportSourceBytes(ByteString r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 2;
                this.eventReportSource_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setStartTimestamp(long r2) {
                this.bitField0_ |= 8;
                this.startTimestamp_ = r2;
                onChanged();
                return this;
            }

            public Builder setTraceId(String r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 4;
                this.traceId_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setTraceIdBytes(ByteString r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 4;
                this.traceId_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            /* JADX INFO: renamed from: setUnknownFields, reason: collision with other method in class */
            public final Builder m360setUnknownFields(UnknownFieldSet r1) {
                return (Builder) super.setUnknownFields(r1);
            }

            public Builder setWakeupStage1Duration(long r2) {
                this.bitField0_ |= 32;
                this.wakeupStage1Duration_ = r2;
                onChanged();
                return this;
            }

            public Builder setWakeupStage2Duration(long r2) {
                this.bitField0_ |= 64;
                this.wakeupStage2Duration_ = r2;
                onChanged();
                return this;
            }

            public Builder setWakeupStage3Duration(long r2) {
                this.bitField0_ |= LynxTouchEvent.kPseudoStateFocusTransition;
                this.wakeupStage3Duration_ = r2;
                onChanged();
                return this;
            }

            public /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            public Builder addTraceViewers(AssistAudioEventDataTraceViewer r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L8;
                if (r2 == null) goto L7;
                ensureTraceViewersIsMutable();
                this.traceViewers_.add(r2);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.addMessage(r2);
                goto L9
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearField(Descriptors.FieldDescriptor r1) {
                return m334clearField(r1);
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r1) {
                return m337clearOneof(r1);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public Builder m351mergeFrom(Message r2) {
                if ((r2 instanceof VoiceWakeupDuration) == true) goto L5;
                super/*com.google.protobuf.AbstractMessage.Builder*/.mergeFrom(r2);
                return this;
            L5:
                return mergeFrom((VoiceWakeupDuration) r2);
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r1) {
                return m354mergeUnknownFields(r1);
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r1) {
                return m360setUnknownFields(r1);
            }

            /* JADX INFO: renamed from: clearField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m333clearField(Descriptors.FieldDescriptor r1) {
                return m334clearField(r1);
            }

            /* JADX INFO: renamed from: clearOneof, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m335clearOneof(Descriptors.OneofDescriptor r1) {
                return m337clearOneof(r1);
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r1) {
                return m351mergeFrom(r1);
            }

            /* JADX INFO: renamed from: mergeUnknownFields, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m352mergeUnknownFields(UnknownFieldSet r1) {
                return m354mergeUnknownFields(r1);
            }

            /* JADX INFO: renamed from: setUnknownFields, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m359setUnknownFields(UnknownFieldSet r1) {
                return m360setUnknownFields(r1);
            }

            /* JADX INFO: renamed from: clearOneof, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m336clearOneof(Descriptors.OneofDescriptor r1) {
                return m337clearOneof(r1);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m348mergeFrom(Message r1) {
                return m351mergeFrom(r1);
            }

            /* JADX INFO: renamed from: mergeUnknownFields, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m353mergeUnknownFields(UnknownFieldSet r1) {
                return m354mergeUnknownFields(r1);
            }

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r1, AnonymousClass1 r2) {
                this(r1);
            }

            /* JADX INFO: renamed from: addRepeatedField, reason: collision with other method in class */
            public Builder m324addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
                return (Builder) super.addRepeatedField(r1, r2);
            }

            public Builder addTraceViewers(int r2, AssistAudioEventDataTraceViewer.Builder r3) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                ensureTraceViewersIsMutable();
                ListProtector.add(this.traceViewers_, r2, r3.m96build());
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2, r3.m96build());
                goto L6
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
            public String getExtraOrDefault(String r3, String r4) {
                if (r3 == null) goto L8;
                Map r0 = internalGetExtra().getMap();
                if (r0.containsKey(r3) == true) goto L6;
                return r4;
            L6:
                return (String) r0.get(r3);
            L8:
                throw null;
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public Builder m350mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                VoiceWakeupDuration r0 = null;
                VoiceWakeupDuration r5 = (VoiceWakeupDuration) VoiceWakeupDuration.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                VoiceWakeupDuration r6 = (VoiceWakeupDuration) e.getUnfinishedMessage();     // Catch: Throwable -> L7
            L13:
                th = th;
                r0 = r6;
            L15:
                if (r0 == null) goto L17;
                mergeFrom(r0);
            L17:
                throw th;
            L12:
                throw e.unwrapIOException();     // Catch: Throwable -> L13
            L7:
                th = th;
                goto L15
            }

            public Builder putExtra(String r2, String r3) {
                if (r2 == null) goto L8;
                if (r3 == null) goto L7;
                internalGetMutableExtra().getMutableMap().put(r2, r3);
                return this;
            L7:
                throw null;
            L8:
                throw null;
            }

            /* JADX INFO: renamed from: setField, reason: collision with other method in class */
            public Builder m356setField(Descriptors.FieldDescriptor r1, Object r2) {
                return (Builder) super.setField(r1, r2);
            }

            public Builder setTraceViewers(int r2, AssistAudioEventDataTraceViewer.Builder r3) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                ensureTraceViewersIsMutable();
                ListProtector.set(this.traceViewers_, r2, r3.m96build());
                onChanged();
            L6:
                return this;
            L5:
                r0.setMessage(r2, r3.m96build());
                goto L6
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
                return m324addRepeatedField(r1, r2);
            }

            public Builder addTraceViewers(int r2, AssistAudioEventDataTraceViewer r3) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L8;
                if (r3 == null) goto L7;
                ensureTraceViewersIsMutable();
                ListProtector.add(this.traceViewers_, r2, r3);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.addMessage(r2, r3);
                goto L9
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m350mergeFrom(r1, r2);
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setField(Descriptors.FieldDescriptor r1, Object r2) {
                return m356setField(r1, r2);
            }

            public Builder setTraceViewers(int r2, AssistAudioEventDataTraceViewer r3) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L8;
                if (r3 == null) goto L7;
                ensureTraceViewersIsMutable();
                ListProtector.set(this.traceViewers_, r2, r3);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.setMessage(r2, r3);
                goto L9
            }

            /* JADX INFO: renamed from: addRepeatedField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m323addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
                return m324addRepeatedField(r1, r2);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder m346mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m350mergeFrom(r1, r2);
            }

            /* JADX INFO: renamed from: setField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m355setField(Descriptors.FieldDescriptor r1, Object r2) {
                return m356setField(r1, r2);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m347mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m350mergeFrom(r1, r2);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite.Builder m349mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m350mergeFrom(r1, r2);
            }

            /* JADX INFO: renamed from: setRepeatedField, reason: collision with other method in class */
            public Builder m358setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
                return (Builder) super.setRepeatedField(r1, r2, r3);
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
                return m358setRepeatedField(r1, r2, r3);
            }

            /* JADX INFO: renamed from: setRepeatedField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m357setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
                return m358setRepeatedField(r1, r2, r3);
            }
        }

        public static final class ExtraDefaultEntryHolder {
            static final MapEntry<String, String> defaultEntry = null;

            private ExtraDefaultEntryHolder() {
            }

            static {
                Descriptors.Descriptor r0 = AssistAudioEventProto.access$2200();
                WireFormat.FieldType r1 = WireFormat.FieldType.STRING;
                defaultEntry = MapEntry.newDefaultInstance(r0, r1, NameKeys.UnloadStrategy_No_Strategy, r1, NameKeys.UnloadStrategy_No_Strategy);
            }
        }

        static {
            DEFAULT_INSTANCE = new VoiceWakeupDuration();
            PARSER = new AnonymousClass1();
        }

        private MapField<String, String> internalGetExtra() {
            MapField<String, String> r0 = this.extra_;
            if (r0 == null) goto L5;
            return r0;
        L5:
            return MapField.emptyMapField(ExtraDefaultEntryHolder.defaultEntry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m321toBuilder();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
        public String getEventName() {
            Object r0 = this.eventName_;
            if ((r0 instanceof String) == true) goto L5;
            ByteString r1 = (ByteString) r0;
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L9;
            this.eventName_ = r2;
        L9:
            return r2;
        L5:
            return (String) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
        public ByteString getEventNameBytes() {
            Object r0 = this.eventName_;
            if ((r0 instanceof String) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) r0);
            this.eventName_ = r1;
            return r1;
        L7:
            return (ByteString) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
        public String getEventReportSource() {
            Object r0 = this.eventReportSource_;
            if ((r0 instanceof String) == true) goto L5;
            ByteString r1 = (ByteString) r0;
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L9;
            this.eventReportSource_ = r2;
        L9:
            return r2;
        L5:
            return (String) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
        public ByteString getEventReportSourceBytes() {
            Object r0 = this.eventReportSource_;
            if ((r0 instanceof String) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) r0);
            this.eventReportSource_ = r1;
            return r1;
        L7:
            return (ByteString) r0;
        }

        public int getSerializedSize() {
            int r0 = ((AbstractMessage) this).memoizedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r2 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r1 = GeneratedMessageV3.computeStringSize(1, this.eventName_) + 0;
        L10:
            if ((this.bitField0_ & 2) != 2) goto L13;
            r1 = r1 + GeneratedMessageV3.computeStringSize(2, this.eventReportSource_);
        L13:
            if ((this.bitField0_ & 4) != 4) goto L16;
            r1 = r1 + GeneratedMessageV3.computeStringSize(3, this.traceId_);
        L16:
            if ((this.bitField0_ & 8) != 8) goto L19;
            r1 = r1 + CodedOutputStream.computeInt64Size(4, this.startTimestamp_);
        L19:
            if ((this.bitField0_ & 16) != 16) goto L22;
            r1 = r1 + CodedOutputStream.computeInt64Size(5, this.endTimestamp_);
        L22:
            if ((this.bitField0_ & 32) != 32) goto L25;
            r1 = r1 + CodedOutputStream.computeInt64Size(6, this.wakeupStage1Duration_);
        L25:
            if ((this.bitField0_ & 64) != 64) goto L28;
            r1 = r1 + CodedOutputStream.computeInt64Size(7, this.wakeupStage2Duration_);
        L28:
            if ((this.bitField0_ & LynxTouchEvent.kPseudoStateFocusTransition) != 128) goto L30;
            r1 = r1 + CodedOutputStream.computeInt64Size(8, this.wakeupStage3Duration_);
        L30:
            Iterator r3 = internalGetExtra().getMap().entrySet().iterator();
        L32:
            if (r3.hasNext() == false) goto L35;
            Map.Entry r4 = (Map.Entry) r3.next();
            r1 = r1 + CodedOutputStream.computeMessageSize(9, ExtraDefaultEntryHolder.defaultEntry.newBuilderForType().setKey((String) r4.getKey()).setValue((String) r4.getValue()).build());
        L35:
            if (r2 >= this.traceViewers_.size()) goto L37;
            r1 = r1 + CodedOutputStream.computeMessageSize(10, (MessageLite) ListProtector.get(this.traceViewers_, r2));
            r2 = r2 + 1;
            goto L35
        L37:
            int r5 = r1 + ((GeneratedMessageV3) this).unknownFields.getSerializedSize();
            ((AbstractMessage) this).memoizedSize = r5;
            return r5;
        L8:
            r1 = 0;
            goto L10
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
        public String getTraceId() {
            Object r0 = this.traceId_;
            if ((r0 instanceof String) == true) goto L5;
            ByteString r1 = (ByteString) r0;
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L9;
            this.traceId_ = r2;
        L9:
            return r2;
        L5:
            return (String) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
        public ByteString getTraceIdBytes() {
            Object r0 = this.traceId_;
            if ((r0 instanceof String) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) r0);
            this.traceId_ = r1;
            return r1;
        L7:
            return (ByteString) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
        public int getTraceViewersCount() {
            return this.traceViewers_.size();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
        public boolean hasEndTimestamp() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
        public boolean hasEventName() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
        public boolean hasEventReportSource() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
        public boolean hasStartTimestamp() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
        public boolean hasTraceId() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
        public boolean hasWakeupStage1Duration() {
            if ((this.bitField0_ & 32) != 32) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
        public boolean hasWakeupStage2Duration() {
            if ((this.bitField0_ & 64) != 64) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
        public boolean hasWakeupStage3Duration() {
            if ((this.bitField0_ & LynxTouchEvent.kPseudoStateFocusTransition) != 128) goto L5;
            return true;
        L5:
            return false;
        }

        public int hashCode() {
            int r0 = ((AbstractMessageLite) this).memoizedHashCode;
            if (r0 == 0) goto L5;
            return r0;
        L5:
            int r1 = 779 + getDescriptor().hashCode();
            if (hasEventName() == false) goto L9;
            r1 = (((r1 * 37) + 1) * 53) + getEventName().hashCode();
        L9:
            if (hasEventReportSource() == false) goto L12;
            r1 = (((r1 * 37) + 2) * 53) + getEventReportSource().hashCode();
        L12:
            if (hasTraceId() == false) goto L15;
            r1 = (((r1 * 37) + 3) * 53) + getTraceId().hashCode();
        L15:
            if (hasStartTimestamp() == false) goto L18;
            r1 = (((r1 * 37) + 4) * 53) + Internal.hashLong(getStartTimestamp());
        L18:
            if (hasEndTimestamp() == false) goto L21;
            r1 = (((r1 * 37) + 5) * 53) + Internal.hashLong(getEndTimestamp());
        L21:
            if (hasWakeupStage1Duration() == false) goto L24;
            r1 = (((r1 * 37) + 6) * 53) + Internal.hashLong(getWakeupStage1Duration());
        L24:
            if (hasWakeupStage2Duration() == false) goto L27;
            r1 = (((r1 * 37) + 7) * 53) + Internal.hashLong(getWakeupStage2Duration());
        L27:
            if (hasWakeupStage3Duration() == false) goto L30;
            r1 = (((r1 * 37) + 8) * 53) + Internal.hashLong(getWakeupStage3Duration());
        L30:
            if (internalGetExtra().getMap().isEmpty() == true) goto L33;
            r1 = (((r1 * 37) + 9) * 53) + internalGetExtra().hashCode();
        L33:
            if (getTraceViewersCount() <= 0) goto L35;
            r1 = (((r1 * 37) + 10) * 53) + getTraceViewersList().hashCode();
        L35:
            int r2 = (r1 * 29) + ((GeneratedMessageV3) this).unknownFields.hashCode();
            ((AbstractMessageLite) this).memoizedHashCode = r2;
            return r2;
        }

        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L5;
            return true;
        L5:
            if (r0 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        /* JADX INFO: renamed from: toBuilder, reason: collision with other method in class */
        public Builder m321toBuilder() {
            AnonymousClass1 r1 = null;
            if (this != DEFAULT_INSTANCE) goto L6;
            return new Builder(r1);
        L6:
            return new Builder(r1).mergeFrom(this);
        }

        private VoiceWakeupDuration() {
            this.memoizedIsInitialized = -1;
            this.eventName_ = NameKeys.UnloadStrategy_No_Strategy;
            this.eventReportSource_ = NameKeys.UnloadStrategy_No_Strategy;
            this.traceId_ = NameKeys.UnloadStrategy_No_Strategy;
            this.startTimestamp_ = 0;
            this.endTimestamp_ = 0;
            this.wakeupStage1Duration_ = 0;
            this.wakeupStage2Duration_ = 0;
            this.wakeupStage3Duration_ = 0;
            this.traceViewers_ = Collections.emptyList();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AssistAudioEventProto.access$2000();
        }

        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return m316getDefaultInstanceForType();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
        public Map<String, String> getExtra() {
            return getExtraMap();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
        public int getExtraCount() {
            return internalGetExtra().getMap().size();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
        public Map<String, String> getExtraMap() {
            return internalGetExtra().getMap();
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AssistAudioEventProto.access$2100().ensureFieldAccessorsInitialized(VoiceWakeupDuration.class, Builder.class);
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return m318newBuilderForType();
        }

        public static /* synthetic */ boolean access$2500() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ boolean access$3900() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static VoiceWakeupDuration getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<VoiceWakeupDuration> parser() {
            return PARSER;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
        public long getEndTimestamp() {
            return this.endTimestamp_;
        }

        public Parser<VoiceWakeupDuration> getParserForType() {
            return PARSER;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
        public long getStartTimestamp() {
            return this.startTimestamp_;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
        public List<AssistAudioEventDataTraceViewer> getTraceViewersList() {
            return this.traceViewers_;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
        public List<? extends AssistAudioEventDataTraceViewerOrBuilder> getTraceViewersOrBuilderList() {
            return this.traceViewers_;
        }

        public final UnknownFieldSet getUnknownFields() {
            return ((GeneratedMessageV3) this).unknownFields;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
        public long getWakeupStage1Duration() {
            return this.wakeupStage1Duration_;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
        public long getWakeupStage2Duration() {
            return this.wakeupStage2Duration_;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
        public long getWakeupStage3Duration() {
            return this.wakeupStage3Duration_;
        }

        /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite m315getDefaultInstanceForType() {
            return m316getDefaultInstanceForType();
        }

        /* JADX INFO: renamed from: newBuilderForType, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite.Builder m317newBuilderForType() {
            return m318newBuilderForType();
        }

        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return m321toBuilder();
        }

        /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
        public VoiceWakeupDuration m316getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: renamed from: newBuilderForType, reason: collision with other method in class */
        public Builder m318newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: renamed from: toBuilder, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite.Builder m320toBuilder() {
            return m321toBuilder();
        }

        private VoiceWakeupDuration(GeneratedMessageV3.Builder<?> r1) {
            super(r1);
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ Object access$2700(VoiceWakeupDuration r0) {
            return r0.eventName_;
        }

        public static /* synthetic */ Object access$2800(VoiceWakeupDuration r0) {
            return r0.eventReportSource_;
        }

        public static /* synthetic */ Object access$2900(VoiceWakeupDuration r0) {
            return r0.traceId_;
        }

        public static /* synthetic */ MapField access$3500(VoiceWakeupDuration r0) {
            return r0.extra_;
        }

        public static /* synthetic */ List access$3600(VoiceWakeupDuration r0) {
            return r0.traceViewers_;
        }

        public static /* synthetic */ MapField access$3800(VoiceWakeupDuration r0) {
            return r0.internalGetExtra();
        }

        public static /* synthetic */ UnknownFieldSet access$4000(VoiceWakeupDuration r0) {
            return ((GeneratedMessageV3) r0).unknownFields;
        }

        public static Builder newBuilder(VoiceWakeupDuration r1) {
            return DEFAULT_INSTANCE.m321toBuilder().mergeFrom(r1);
        }

        public static VoiceWakeupDuration parseDelimitedFrom(InputStream r1) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r1);
        }

        public static VoiceWakeupDuration parseFrom(ByteString r1) throws InvalidProtocolBufferException {
            return (VoiceWakeupDuration) PARSER.parseFrom(r1);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
        public boolean containsExtra(String r2) {
            if (r2 == null) goto L6;
            return internalGetExtra().getMap().containsKey(r2);
        L6:
            throw null;
        }

        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof VoiceWakeupDuration) == false) goto L8;
            VoiceWakeupDuration r9 = (VoiceWakeupDuration) r8;
            if (hasEventName() != r9.hasEventName()) goto L12;
            boolean r1 = true;
        L14:
            if (hasEventName() == false) goto L20;
            if (r1 == true) goto L17;
        L19:
            r1 = false;
            goto L20
        L17:
            if (getEventName().equals(r9.getEventName()) == false) goto L19;
            r1 = true;
        L20:
            if (r1 == true) goto L22;
        L24:
            boolean r2 = false;
        L26:
            if (hasEventReportSource() == false) goto L32;
            if (r2 == true) goto L29;
        L31:
            r2 = false;
            goto L32
        L29:
            if (getEventReportSource().equals(r9.getEventReportSource()) == false) goto L31;
            r2 = true;
        L32:
            if (r2 == true) goto L34;
        L36:
            boolean r3 = false;
        L38:
            if (hasTraceId() == false) goto L44;
            if (r3 == true) goto L41;
        L43:
            r3 = false;
            goto L44
        L41:
            if (getTraceId().equals(r9.getTraceId()) == false) goto L43;
            r3 = true;
        L44:
            if (r3 == true) goto L46;
        L48:
            boolean r4 = false;
        L50:
            if (hasStartTimestamp() == false) goto L56;
            if (r4 == true) goto L53;
        L55:
            r4 = false;
            goto L56
        L53:
            if (getStartTimestamp() != r9.getStartTimestamp()) goto L55;
            r4 = true;
        L56:
            if (r4 == true) goto L58;
        L60:
            boolean r5 = false;
        L62:
            if (hasEndTimestamp() == false) goto L68;
            if (r5 == true) goto L65;
        L67:
            r5 = false;
            goto L68
        L65:
            if (getEndTimestamp() != r9.getEndTimestamp()) goto L67;
            r5 = true;
        L68:
            if (r5 == true) goto L70;
        L72:
            boolean r6 = false;
        L74:
            if (hasWakeupStage1Duration() == false) goto L80;
            if (r6 == true) goto L77;
        L79:
            r6 = false;
            goto L80
        L77:
            if (getWakeupStage1Duration() != r9.getWakeupStage1Duration()) goto L79;
            r6 = true;
        L80:
            if (r6 == true) goto L82;
        L84:
            boolean r7 = false;
        L86:
            if (hasWakeupStage2Duration() == false) goto L92;
            if (r7 == true) goto L89;
        L91:
            r7 = false;
            goto L92
        L89:
            if (getWakeupStage2Duration() != r9.getWakeupStage2Duration()) goto L91;
            r7 = true;
        L92:
            if (r7 == true) goto L94;
        L96:
            boolean r10 = false;
        L98:
            if (hasWakeupStage3Duration() == false) goto L104;
            if (r10 == true) goto L101;
        L103:
            r10 = false;
            goto L104
        L101:
            if (getWakeupStage3Duration() != r9.getWakeupStage3Duration()) goto L103;
            r10 = true;
        L104:
            if (r10 == true) goto L106;
        L108:
            boolean r11 = false;
        L109:
            if (r11 == true) goto L111;
        L113:
            boolean r12 = false;
        L114:
            if (r12 == true) goto L116;
        L118:
            return false;
        L116:
            if (((GeneratedMessageV3) this).unknownFields.equals(((GeneratedMessageV3) r9).unknownFields) == false) goto L118;
            return true;
        L111:
            if (getTraceViewersList().equals(r9.getTraceViewersList()) == false) goto L113;
            r12 = true;
            goto L114
        L106:
            if (internalGetExtra().equals(r9.internalGetExtra()) == false) goto L108;
            r11 = true;
            goto L109
        L94:
            if (hasWakeupStage3Duration() != r9.hasWakeupStage3Duration()) goto L96;
            r10 = true;
            goto L98
        L82:
            if (hasWakeupStage2Duration() != r9.hasWakeupStage2Duration()) goto L84;
            r7 = true;
            goto L86
        L70:
            if (hasWakeupStage1Duration() != r9.hasWakeupStage1Duration()) goto L72;
            r6 = true;
            goto L74
        L58:
            if (hasEndTimestamp() != r9.hasEndTimestamp()) goto L60;
            r5 = true;
            goto L62
        L46:
            if (hasStartTimestamp() != r9.hasStartTimestamp()) goto L48;
            r4 = true;
            goto L50
        L34:
            if (hasTraceId() != r9.hasTraceId()) goto L36;
            r3 = true;
            goto L38
        L22:
            if (hasEventReportSource() != r9.hasEventReportSource()) goto L24;
            r2 = true;
            goto L26
        L12:
            r1 = false;
            goto L14
        L8:
            return super/*com.google.protobuf.AbstractMessage*/.equals(r8);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
        public String getExtraOrThrow(String r3) {
            if (r3 == null) goto L10;
            Map r0 = internalGetExtra().getMap();
            if (r0.containsKey(r3) == false) goto L8;
            return (String) r0.get(r3);
        L8:
            throw new IllegalArgumentException();
        L10:
            throw null;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
        public AssistAudioEventDataTraceViewer getTraceViewers(int r2) {
            return (AssistAudioEventDataTraceViewer) ListProtector.get(this.traceViewers_, r2);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
        public AssistAudioEventDataTraceViewerOrBuilder getTraceViewersOrBuilder(int r2) {
            return (AssistAudioEventDataTraceViewerOrBuilder) ListProtector.get(this.traceViewers_, r2);
        }

        public MapField internalGetMapField(int r4) {
            if (r4 != 9) goto L7;
            return internalGetExtra();
        L7:
            throw new RuntimeException("Invalid map field number: " + r4);
        }

        /* JADX INFO: renamed from: newBuilderForType, reason: collision with other method in class */
        public Builder m319newBuilderForType(GeneratedMessageV3.BuilderParent r3) {
            return new Builder(r3, null);
        }

        public void writeTo(CodedOutputStream r6) throws IOException {
            if ((this.bitField0_ & 1) != 1) goto L6;
            GeneratedMessageV3.writeString(r6, 1, this.eventName_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            GeneratedMessageV3.writeString(r6, 2, this.eventReportSource_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L12;
            GeneratedMessageV3.writeString(r6, 3, this.traceId_);
        L12:
            if ((this.bitField0_ & 8) != 8) goto L15;
            r6.writeInt64(4, this.startTimestamp_);
        L15:
            if ((this.bitField0_ & 16) != 16) goto L18;
            r6.writeInt64(5, this.endTimestamp_);
        L18:
            if ((this.bitField0_ & 32) != 32) goto L21;
            r6.writeInt64(6, this.wakeupStage1Duration_);
        L21:
            if ((this.bitField0_ & 64) != 64) goto L24;
            r6.writeInt64(7, this.wakeupStage2Duration_);
        L24:
            if ((this.bitField0_ & LynxTouchEvent.kPseudoStateFocusTransition) != 128) goto L26;
            r6.writeInt64(8, this.wakeupStage3Duration_);
        L26:
            GeneratedMessageV3.serializeStringMapTo(r6, internalGetExtra(), ExtraDefaultEntryHolder.defaultEntry, 9);
            int r0 = 0;
        L28:
            if (r0 >= this.traceViewers_.size()) goto L30;
            r6.writeMessage(10, (MessageLite) ListProtector.get(this.traceViewers_, r0));
            r0 = r0 + 1;
            goto L28
        L30:
            ((GeneratedMessageV3) this).unknownFields.writeTo(r6);
        }

        public static VoiceWakeupDuration parseFrom(CodedInputStream r1) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1);
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r1) {
            return m319newBuilderForType(r1);
        }

        public static VoiceWakeupDuration parseFrom(InputStream r1) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1);
        }

        public static VoiceWakeupDuration parseFrom(ByteBuffer r1) throws InvalidProtocolBufferException {
            return (VoiceWakeupDuration) PARSER.parseFrom(r1);
        }

        public static VoiceWakeupDuration parseFrom(byte[] r1) throws InvalidProtocolBufferException {
            return (VoiceWakeupDuration) PARSER.parseFrom(r1);
        }

        private VoiceWakeupDuration(CodedInputStream r8, ExtensionRegistryLite r9) throws InvalidProtocolBufferException {
            this();
            if (r9 == null) goto L49;
            UnknownFieldSet.Builder r0 = UnknownFieldSet.newBuilder();
            boolean r1 = false;
            int r2 = 0;
        L6:
            if (r1 == true) goto L44;
            int r4 = r8.readTag();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            switch(r4) {
                case 0: goto L27;
                case 10: goto L25;
                case 18: goto L24;
                case 26: goto L23;
                case 32: goto L22;
                case 40: goto L21;
                case 48: goto L20;
                case 56: goto L19;
                case 64: goto L18;
                case 74: goto L15;
                case 82: goto L11;
                default: goto L28;
            };     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
        L11:
            if ((r2 & 512) == 512) goto L13;
            this.traceViewers_ = new ArrayList();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            r2 = r2 | 512;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
        L13:
            this.traceViewers_.add((AssistAudioEventDataTraceViewer) r8.readMessage(AssistAudioEventDataTraceViewer.PARSER, r9));     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            goto L6
        L15:
            if ((r2 & 256) == 256) goto L17;
            this.extra_ = MapField.newMapField(ExtraDefaultEntryHolder.defaultEntry);     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            r2 = r2 | 256;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
        L17:
            MapEntry r5 = r8.readMessage(ExtraDefaultEntryHolder.defaultEntry.getParserForType(), r9);     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            this.extra_.getMutableMap().put((String) r5.getKey(), (String) r5.getValue());     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            goto L6
        L18:
            this.bitField0_ |= LynxTouchEvent.kPseudoStateFocusTransition;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            this.wakeupStage3Duration_ = r8.readInt64();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            goto L6
        L19:
            this.bitField0_ |= 64;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            this.wakeupStage2Duration_ = r8.readInt64();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            goto L6
        L20:
            this.bitField0_ |= 32;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            this.wakeupStage1Duration_ = r8.readInt64();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            goto L6
        L21:
            this.bitField0_ |= 16;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            this.endTimestamp_ = r8.readInt64();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            goto L6
        L22:
            this.bitField0_ |= 8;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            this.startTimestamp_ = r8.readInt64();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            goto L6
        L23:
            ByteString r6 = r8.readBytes();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            this.bitField0_ |= 4;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            this.traceId_ = r6;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            goto L6
        L24:
            ByteString r7 = r8.readBytes();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            this.bitField0_ |= 2;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            this.eventReportSource_ = r7;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            goto L6
        L25:
            ByteString r10 = r8.readBytes();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            this.bitField0_ = 1 | this.bitField0_;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            this.eventName_ = r10;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
        L27:
            r1 = true;
            goto L6
        L28:
            if (parseUnknownField(r8, r0, r9, r4) == true) goto L6;
        L30:
            th = move-exception;
            if ((r2 & 512) != 512) goto L41;
            this.traceViewers_ = Collections.unmodifiableList(this.traceViewers_);
        L41:
            ((GeneratedMessageV3) this).unknownFields = r0.build();
            makeExtensionsImmutable();
            throw th;
        L32:
            e = move-exception;
            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L30
        L35:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L30
        L44:
            if ((r2 & 512) != 512) goto L46;
            this.traceViewers_ = Collections.unmodifiableList(this.traceViewers_);
        L46:
            ((GeneratedMessageV3) this).unknownFields = r0.build();
            makeExtensionsImmutable();
            return;
        L49:
            throw null;
        }

        public static /* synthetic */ Object access$2702(VoiceWakeupDuration r0, Object r1) {
            r0.eventName_ = r1;
            return r1;
        }

        public static /* synthetic */ Object access$2802(VoiceWakeupDuration r0, Object r1) {
            r0.eventReportSource_ = r1;
            return r1;
        }

        public static /* synthetic */ Object access$2902(VoiceWakeupDuration r0, Object r1) {
            r0.traceId_ = r1;
            return r1;
        }

        public static /* synthetic */ long access$3002(VoiceWakeupDuration r0, long r1) {
            r0.startTimestamp_ = r1;
            return r1;
        }

        public static /* synthetic */ long access$3102(VoiceWakeupDuration r0, long r1) {
            r0.endTimestamp_ = r1;
            return r1;
        }

        public static /* synthetic */ long access$3202(VoiceWakeupDuration r0, long r1) {
            r0.wakeupStage1Duration_ = r1;
            return r1;
        }

        public static /* synthetic */ long access$3302(VoiceWakeupDuration r0, long r1) {
            r0.wakeupStage2Duration_ = r1;
            return r1;
        }

        public static /* synthetic */ long access$3402(VoiceWakeupDuration r0, long r1) {
            r0.wakeupStage3Duration_ = r1;
            return r1;
        }

        public static /* synthetic */ MapField access$3502(VoiceWakeupDuration r0, MapField r1) {
            r0.extra_ = r1;
            return r1;
        }

        public static /* synthetic */ List access$3602(VoiceWakeupDuration r0, List r1) {
            r0.traceViewers_ = r1;
            return r1;
        }

        public static /* synthetic */ int access$3702(VoiceWakeupDuration r0, int r1) {
            r0.bitField0_ = r1;
            return r1;
        }

        public static VoiceWakeupDuration parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r1, r2);
        }

        public static VoiceWakeupDuration parseFrom(ByteString r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
            return (VoiceWakeupDuration) PARSER.parseFrom(r1, r2);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupDurationOrBuilder
        public String getExtraOrDefault(String r3, String r4) {
            if (r3 == null) goto L8;
            Map r0 = internalGetExtra().getMap();
            if (r0.containsKey(r3) == true) goto L6;
            return r4;
        L6:
            return (String) r0.get(r3);
        L8:
            throw null;
        }

        public /* synthetic */ VoiceWakeupDuration(GeneratedMessageV3.Builder r1, AnonymousClass1 r2) {
            this(r1);
        }

        public static VoiceWakeupDuration parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1, r2);
        }

        public static VoiceWakeupDuration parseFrom(InputStream r1, ExtensionRegistryLite r2) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1, r2);
        }

        public static VoiceWakeupDuration parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
            return (VoiceWakeupDuration) PARSER.parseFrom(r1, r2);
        }

        public static VoiceWakeupDuration parseFrom(byte[] r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
            return (VoiceWakeupDuration) PARSER.parseFrom(r1, r2);
        }

        public /* synthetic */ VoiceWakeupDuration(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }
    }

    public interface VoiceWakeupDurationOrBuilder extends MessageOrBuilder {
        boolean containsExtra(String r1);

        long getEndTimestamp();

        String getEventName();

        ByteString getEventNameBytes();

        String getEventReportSource();

        ByteString getEventReportSourceBytes();

        Map<String, String> getExtra();

        int getExtraCount();

        Map<String, String> getExtraMap();

        String getExtraOrDefault(String r1, String r2);

        String getExtraOrThrow(String r1);

        long getStartTimestamp();

        String getTraceId();

        ByteString getTraceIdBytes();

        AssistAudioEventDataTraceViewer getTraceViewers(int r1);

        int getTraceViewersCount();

        List<AssistAudioEventDataTraceViewer> getTraceViewersList();

        AssistAudioEventDataTraceViewerOrBuilder getTraceViewersOrBuilder(int r1);

        List<? extends AssistAudioEventDataTraceViewerOrBuilder> getTraceViewersOrBuilderList();

        long getWakeupStage1Duration();

        long getWakeupStage2Duration();

        long getWakeupStage3Duration();

        boolean hasEndTimestamp();

        boolean hasEventName();

        boolean hasEventReportSource();

        boolean hasStartTimestamp();

        boolean hasTraceId();

        boolean hasWakeupStage1Duration();

        boolean hasWakeupStage2Duration();

        boolean hasWakeupStage3Duration();
    }

    public static final class VoiceWakeupEvent extends GeneratedMessageV3 implements VoiceWakeupEventOrBuilder {
        private static final VoiceWakeupEvent DEFAULT_INSTANCE = null;
        public static final int EVENT_NAME_FIELD_NUMBER = 1;
        public static final int EVENT_REPORT_SOURCE_FIELD_NUMBER = 2;
        public static final int EXTRA_FIELD_NUMBER = 8;
        public static final Parser<VoiceWakeupEvent> PARSER = null;
        public static final int REJECT_REASON_FIELD_NUMBER = 7;
        public static final int TIMESTAMP_FIELD_NUMBER = 4;
        public static final int TRACE_ID_FIELD_NUMBER = 3;
        public static final int TRACE_VIEWERS_FIELD_NUMBER = 9;
        public static final int WAKEUP_STAGE_FIELD_NUMBER = 5;
        public static final int WAKEUP_SUCCESS_FIELD_NUMBER = 6;
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private volatile Object eventName_;
        private volatile Object eventReportSource_;
        private MapField<String, String> extra_;
        private byte memoizedIsInitialized;
        private volatile Object rejectReason_;
        private long timestamp_;
        private volatile Object traceId_;
        private List<AssistAudioEventDataTraceViewer> traceViewers_;
        private volatile Object wakeupStage_;
        private boolean wakeupSuccess_;

        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements VoiceWakeupEventOrBuilder {
            private int bitField0_;
            private Object eventName_;
            private Object eventReportSource_;
            private MapField<String, String> extra_;
            private Object rejectReason_;
            private long timestamp_;
            private Object traceId_;
            private RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> traceViewersBuilder_;
            private List<AssistAudioEventDataTraceViewer> traceViewers_;
            private Object wakeupStage_;
            private boolean wakeupSuccess_;

            public final boolean isInitialized() {
                return true;
            }

            private void ensureTraceViewersIsMutable() {
                if ((this.bitField0_ & 256) == 256) goto L6;
                this.traceViewers_ = new ArrayList(this.traceViewers_);
                this.bitField0_ |= 256;
                return;
            }

            private RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> getTraceViewersFieldBuilder() {
                if (this.traceViewersBuilder_ != null) goto L10;
                List<AssistAudioEventDataTraceViewer> r1 = this.traceViewers_;
                if ((this.bitField0_ & 256) != 256) goto L7;
                boolean r2 = true;
            L8:
                this.traceViewersBuilder_ = new RepeatedFieldBuilderV3(r1, r2, getParentForChildren(), isClean());
                this.traceViewers_ = null;
                goto L10
            L7:
                r2 = false;
            L10:
                return this.traceViewersBuilder_;
            }

            private MapField<String, String> internalGetExtra() {
                MapField<String, String> r0 = this.extra_;
                if (r0 == null) goto L5;
                return r0;
            L5:
                return MapField.emptyMapField(ExtraDefaultEntryHolder.defaultEntry);
            }

            /* JADX INFO: renamed from: buildPartial, reason: collision with other method in class */
            public VoiceWakeupEvent m374buildPartial() {
                VoiceWakeupEvent r0 = new VoiceWakeupEvent(this, null);
                int r1 = this.bitField0_;
                int r3 = 1;
                if ((r1 & 1) == 1) goto L6;
                r3 = 0;
            L6:
                VoiceWakeupEvent.access$4902(r0, this.eventName_);
                if ((r1 & 2) != 2) goto L9;
                r3 = r3 | 2;
            L9:
                VoiceWakeupEvent.access$5002(r0, this.eventReportSource_);
                if ((r1 & 4) != 4) goto L12;
                r3 = r3 | 4;
            L12:
                VoiceWakeupEvent.access$5102(r0, this.traceId_);
                if ((r1 & 8) != 8) goto L15;
                r3 = r3 | 8;
            L15:
                VoiceWakeupEvent.access$5202(r0, this.timestamp_);
                if ((r1 & 16) != 16) goto L18;
                r3 = r3 | 16;
            L18:
                VoiceWakeupEvent.access$5302(r0, this.wakeupStage_);
                if ((r1 & 32) != 32) goto L21;
                r3 = r3 | 32;
            L21:
                VoiceWakeupEvent.access$5402(r0, this.wakeupSuccess_);
                if ((r1 & 64) != 64) goto L24;
                r3 = r3 | 64;
            L24:
                VoiceWakeupEvent.access$5502(r0, this.rejectReason_);
                VoiceWakeupEvent.access$5602(r0, internalGetExtra());
                VoiceWakeupEvent.access$5600(r0).makeImmutable();
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r2 = this.traceViewersBuilder_;
                if (r2 == null) goto L27;
                VoiceWakeupEvent.access$5702(r0, r2.build());
            L31:
                VoiceWakeupEvent.access$5802(r0, r3);
                onBuilt();
                return r0;
            L27:
                if ((this.bitField0_ & 256) != 256) goto L29;
                this.traceViewers_ = Collections.unmodifiableList(this.traceViewers_);
                this.bitField0_ &= -257;
            L29:
                VoiceWakeupEvent.access$5702(r0, this.traceViewers_);
                goto L31
            }

            public Builder clearEventName() {
                this.bitField0_ &= -2;
                this.eventName_ = VoiceWakeupEvent.getDefaultInstance().getEventName();
                onChanged();
                return this;
            }

            public Builder clearEventReportSource() {
                this.bitField0_ &= -3;
                this.eventReportSource_ = VoiceWakeupEvent.getDefaultInstance().getEventReportSource();
                onChanged();
                return this;
            }

            public Builder clearRejectReason() {
                this.bitField0_ &= -65;
                this.rejectReason_ = VoiceWakeupEvent.getDefaultInstance().getRejectReason();
                onChanged();
                return this;
            }

            public Builder clearTimestamp() {
                this.bitField0_ &= -9;
                this.timestamp_ = 0;
                onChanged();
                return this;
            }

            public Builder clearTraceId() {
                this.bitField0_ &= -5;
                this.traceId_ = VoiceWakeupEvent.getDefaultInstance().getTraceId();
                onChanged();
                return this;
            }

            public Builder clearTraceViewers() {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                this.traceViewers_ = Collections.emptyList();
                this.bitField0_ &= -257;
                onChanged();
            L6:
                return this;
            L5:
                r0.clear();
                goto L6
            }

            public Builder clearWakeupStage() {
                this.bitField0_ &= -17;
                this.wakeupStage_ = VoiceWakeupEvent.getDefaultInstance().getWakeupStage();
                onChanged();
                return this;
            }

            public Builder clearWakeupSuccess() {
                this.bitField0_ &= -33;
                this.wakeupSuccess_ = false;
                onChanged();
                return this;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
            public String getEventName() {
                Object r0 = this.eventName_;
                if ((r0 instanceof String) == true) goto L9;
                ByteString r1 = (ByteString) r0;
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L7;
                this.eventName_ = r2;
            L7:
                return r2;
            L9:
                return (String) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
            public ByteString getEventNameBytes() {
                Object r0 = this.eventName_;
                if ((r0 instanceof String) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) r0);
                this.eventName_ = r1;
                return r1;
            L7:
                return (ByteString) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
            public String getEventReportSource() {
                Object r0 = this.eventReportSource_;
                if ((r0 instanceof String) == true) goto L9;
                ByteString r1 = (ByteString) r0;
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L7;
                this.eventReportSource_ = r2;
            L7:
                return r2;
            L9:
                return (String) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
            public ByteString getEventReportSourceBytes() {
                Object r0 = this.eventReportSource_;
                if ((r0 instanceof String) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) r0);
                this.eventReportSource_ = r1;
                return r1;
            L7:
                return (ByteString) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
            public String getRejectReason() {
                Object r0 = this.rejectReason_;
                if ((r0 instanceof String) == true) goto L9;
                ByteString r1 = (ByteString) r0;
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L7;
                this.rejectReason_ = r2;
            L7:
                return r2;
            L9:
                return (String) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
            public ByteString getRejectReasonBytes() {
                Object r0 = this.rejectReason_;
                if ((r0 instanceof String) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) r0);
                this.rejectReason_ = r1;
                return r1;
            L7:
                return (ByteString) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
            public String getTraceId() {
                Object r0 = this.traceId_;
                if ((r0 instanceof String) == true) goto L9;
                ByteString r1 = (ByteString) r0;
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L7;
                this.traceId_ = r2;
            L7:
                return r2;
            L9:
                return (String) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
            public ByteString getTraceIdBytes() {
                Object r0 = this.traceId_;
                if ((r0 instanceof String) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) r0);
                this.traceId_ = r1;
                return r1;
            L7:
                return (ByteString) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
            public int getTraceViewersCount() {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L7;
                return this.traceViewers_.size();
            L7:
                return r0.getCount();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
            public List<AssistAudioEventDataTraceViewer> getTraceViewersList() {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L7;
                return Collections.unmodifiableList(this.traceViewers_);
            L7:
                return r0.getMessageList();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
            public List<? extends AssistAudioEventDataTraceViewerOrBuilder> getTraceViewersOrBuilderList() {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 == null) goto L7;
                return r0.getMessageOrBuilderList();
            L7:
                return Collections.unmodifiableList(this.traceViewers_);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
            public String getWakeupStage() {
                Object r0 = this.wakeupStage_;
                if ((r0 instanceof String) == true) goto L9;
                ByteString r1 = (ByteString) r0;
                String r2 = r1.toStringUtf8();
                if (r1.isValidUtf8() == false) goto L7;
                this.wakeupStage_ = r2;
            L7:
                return r2;
            L9:
                return (String) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
            public ByteString getWakeupStageBytes() {
                Object r0 = this.wakeupStage_;
                if ((r0 instanceof String) == false) goto L7;
                ByteString r1 = ByteString.copyFromUtf8((String) r0);
                this.wakeupStage_ = r1;
                return r1;
            L7:
                return (ByteString) r0;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
            public boolean hasEventName() {
                if ((this.bitField0_ & 1) == 1) goto L7;
                return false;
            L7:
                return true;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
            public boolean hasEventReportSource() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
            public boolean hasRejectReason() {
                if ((this.bitField0_ & 64) != 64) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
            public boolean hasTimestamp() {
                if ((this.bitField0_ & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
            public boolean hasTraceId() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
            public boolean hasWakeupStage() {
                if ((this.bitField0_ & 16) != 16) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
            public boolean hasWakeupSuccess() {
                if ((this.bitField0_ & 32) != 32) goto L5;
                return true;
            L5:
                return false;
            }

            private Builder() {
                this.eventName_ = NameKeys.UnloadStrategy_No_Strategy;
                this.eventReportSource_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceId_ = NameKeys.UnloadStrategy_No_Strategy;
                this.wakeupStage_ = NameKeys.UnloadStrategy_No_Strategy;
                this.rejectReason_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceViewers_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return AssistAudioEventProto.access$4200();
            }

            private MapField<String, String> internalGetMutableExtra() {
                onChanged();
                if (this.extra_ != null) goto L6;
                this.extra_ = MapField.newMapField(ExtraDefaultEntryHolder.defaultEntry);
            L6:
                if (this.extra_.isMutable() == true) goto L9;
                this.extra_ = this.extra_.copy();
            L9:
                return this.extra_;
            }

            private void maybeForceBuilderInitialization() {
                if (VoiceWakeupEvent.access$4700() == false) goto L6;
                getTraceViewersFieldBuilder();
                return;
            }

            public AssistAudioEventDataTraceViewer.Builder addTraceViewersBuilder() {
                return getTraceViewersFieldBuilder().addBuilder(AssistAudioEventDataTraceViewer.getDefaultInstance());
            }

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public VoiceWakeupEvent m372build() {
                VoiceWakeupEvent r0 = m374buildPartial();
                if (r0.isInitialized() == false) goto L6;
                return r0;
            L6:
                throw AbstractMessage.Builder.newUninitializedMessageException(r0);
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public Builder m378clear() {
                super.clear();
                this.eventName_ = NameKeys.UnloadStrategy_No_Strategy;
                int r1 = this.bitField0_ & (-2);
                this.eventReportSource_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceId_ = NameKeys.UnloadStrategy_No_Strategy;
                this.timestamp_ = 0;
                this.wakeupStage_ = NameKeys.UnloadStrategy_No_Strategy;
                this.wakeupSuccess_ = false;
                this.rejectReason_ = NameKeys.UnloadStrategy_No_Strategy;
                this.bitField0_ = (((((r1 & (-3)) & (-5)) & (-9)) & (-17)) & (-33)) & (-65);
                internalGetMutableExtra().clear();
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                this.traceViewers_ = Collections.emptyList();
                this.bitField0_ &= -257;
            L6:
                return this;
            L5:
                r0.clear();
                goto L6
            }

            public Builder clearExtra() {
                internalGetMutableExtra().getMutableMap().clear();
                return this;
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public Builder m388clone() {
                return (Builder) super.clone();
            }

            public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
                return m391getDefaultInstanceForType();
            }

            public Descriptors.Descriptor getDescriptorForType() {
                return AssistAudioEventProto.access$4200();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
            public Map<String, String> getExtra() {
                return getExtraMap();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
            public int getExtraCount() {
                return internalGetExtra().getMap().size();
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
            public Map<String, String> getExtraMap() {
                return internalGetExtra().getMap();
            }

            public Map<String, String> getMutableExtra() {
                return internalGetMutableExtra().getMutableMap();
            }

            public List<AssistAudioEventDataTraceViewer.Builder> getTraceViewersBuilderList() {
                return getTraceViewersFieldBuilder().getBuilderList();
            }

            public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AssistAudioEventProto.access$4300().ensureFieldAccessorsInitialized(VoiceWakeupEvent.class, Builder.class);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
            public long getTimestamp() {
                return this.timestamp_;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
            public boolean getWakeupSuccess() {
                return this.wakeupSuccess_;
            }

            public /* bridge */ /* synthetic */ Message build() {
                return m372build();
            }

            public /* bridge */ /* synthetic */ Message buildPartial() {
                return m374buildPartial();
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
                return m378clear();
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
                return m388clone();
            }

            /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite m390getDefaultInstanceForType() {
                return m391getDefaultInstanceForType();
            }

            /* JADX INFO: renamed from: build, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite m371build() {
                return m372build();
            }

            /* JADX INFO: renamed from: buildPartial, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite m373buildPartial() {
                return m374buildPartial();
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m375clear() {
                return m378clear();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder m384clone() {
                return m388clone();
            }

            /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
            public VoiceWakeupEvent m391getDefaultInstanceForType() {
                return VoiceWakeupEvent.getDefaultInstance();
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m376clear() {
                return m378clear();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m385clone() {
                return m388clone();
            }

            /* JADX INFO: renamed from: clear, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite.Builder m377clear() {
                return m378clear();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m386clone() {
                return m388clone();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite.Builder m387clone() {
                return m388clone();
            }

            /* JADX INFO: renamed from: clone, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m389clone() throws CloneNotSupportedException {
                return m388clone();
            }

            private Builder(GeneratedMessageV3.BuilderParent r1) {
                super(r1);
                this.eventName_ = NameKeys.UnloadStrategy_No_Strategy;
                this.eventReportSource_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceId_ = NameKeys.UnloadStrategy_No_Strategy;
                this.wakeupStage_ = NameKeys.UnloadStrategy_No_Strategy;
                this.rejectReason_ = NameKeys.UnloadStrategy_No_Strategy;
                this.traceViewers_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public Builder addAllTraceViewers(Iterable<? extends AssistAudioEventDataTraceViewer> r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                ensureTraceViewersIsMutable();
                AbstractMessageLite.Builder.addAll(r2, this.traceViewers_);
                onChanged();
            L6:
                return this;
            L5:
                r0.addAllMessages(r2);
                goto L6
            }

            public Builder addTraceViewers(AssistAudioEventDataTraceViewer.Builder r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                ensureTraceViewersIsMutable();
                this.traceViewers_.add(r2.m96build());
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2.m96build());
                goto L6
            }

            public AssistAudioEventDataTraceViewer.Builder addTraceViewersBuilder(int r3) {
                return getTraceViewersFieldBuilder().addBuilder(r3, AssistAudioEventDataTraceViewer.getDefaultInstance());
            }

            /* JADX INFO: renamed from: clearField, reason: collision with other method in class */
            public Builder m380clearField(Descriptors.FieldDescriptor r1) {
                return (Builder) super.clearField(r1);
            }

            /* JADX INFO: renamed from: clearOneof, reason: collision with other method in class */
            public Builder m383clearOneof(Descriptors.OneofDescriptor r1) {
                return (Builder) super.clearOneof(r1);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
            public boolean containsExtra(String r2) {
                if (r2 == null) goto L6;
                return internalGetExtra().getMap().containsKey(r2);
            L6:
                throw null;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
            public String getExtraOrThrow(String r3) {
                if (r3 == null) goto L10;
                Map r0 = internalGetExtra().getMap();
                if (r0.containsKey(r3) == false) goto L8;
                return (String) r0.get(r3);
            L8:
                throw new IllegalArgumentException();
            L10:
                throw null;
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
            public AssistAudioEventDataTraceViewer getTraceViewers(int r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L7;
                return (AssistAudioEventDataTraceViewer) ListProtector.get(this.traceViewers_, r2);
            L7:
                return r0.getMessage(r2);
            }

            public AssistAudioEventDataTraceViewer.Builder getTraceViewersBuilder(int r2) {
                return getTraceViewersFieldBuilder().getBuilder(r2);
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
            public AssistAudioEventDataTraceViewerOrBuilder getTraceViewersOrBuilder(int r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L7;
                return (AssistAudioEventDataTraceViewerOrBuilder) ListProtector.get(this.traceViewers_, r2);
            L7:
                return (AssistAudioEventDataTraceViewerOrBuilder) r0.getMessageOrBuilder(r2);
            }

            public MapField internalGetMapField(int r4) {
                if (r4 != 8) goto L7;
                return internalGetExtra();
            L7:
                throw new RuntimeException("Invalid map field number: " + r4);
            }

            public MapField internalGetMutableMapField(int r4) {
                if (r4 != 8) goto L7;
                return internalGetMutableExtra();
            L7:
                throw new RuntimeException("Invalid map field number: " + r4);
            }

            public Builder mergeFrom(VoiceWakeupEvent r3) {
                if (r3 != VoiceWakeupEvent.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r3.hasEventName() == false) goto L9;
                this.bitField0_ |= 1;
                this.eventName_ = VoiceWakeupEvent.access$4900(r3);
                onChanged();
            L9:
                if (r3.hasEventReportSource() == false) goto L12;
                this.bitField0_ |= 2;
                this.eventReportSource_ = VoiceWakeupEvent.access$5000(r3);
                onChanged();
            L12:
                if (r3.hasTraceId() == false) goto L15;
                this.bitField0_ |= 4;
                this.traceId_ = VoiceWakeupEvent.access$5100(r3);
                onChanged();
            L15:
                if (r3.hasTimestamp() == false) goto L18;
                setTimestamp(r3.getTimestamp());
            L18:
                if (r3.hasWakeupStage() == false) goto L21;
                this.bitField0_ |= 16;
                this.wakeupStage_ = VoiceWakeupEvent.access$5300(r3);
                onChanged();
            L21:
                if (r3.hasWakeupSuccess() == false) goto L24;
                setWakeupSuccess(r3.getWakeupSuccess());
            L24:
                if (r3.hasRejectReason() == false) goto L26;
                this.bitField0_ |= 64;
                this.rejectReason_ = VoiceWakeupEvent.access$5500(r3);
                onChanged();
            L26:
                internalGetMutableExtra().mergeFrom(VoiceWakeupEvent.access$5900(r3));
                if (this.traceViewersBuilder_ != null) goto L36;
                if (VoiceWakeupEvent.access$5700(r3).isEmpty() == false) goto L31;
            L44:
                m400mergeUnknownFields(VoiceWakeupEvent.access$6100(r3));
                onChanged();
                return this;
            L31:
                if (this.traceViewers_.isEmpty() == false) goto L33;
                this.traceViewers_ = VoiceWakeupEvent.access$5700(r3);
                this.bitField0_ &= -257;
            L34:
                onChanged();
                goto L44
            L33:
                ensureTraceViewersIsMutable();
                this.traceViewers_.addAll(VoiceWakeupEvent.access$5700(r3));
                goto L34
            L36:
                if (VoiceWakeupEvent.access$5700(r3).isEmpty() == true) goto L44;
                if (this.traceViewersBuilder_.isEmpty() == false) goto L43;
                this.traceViewersBuilder_.dispose();
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = null;
                this.traceViewersBuilder_ = null;
                this.traceViewers_ = VoiceWakeupEvent.access$5700(r3);
                this.bitField0_ &= -257;
                if (VoiceWakeupEvent.access$6000() == false) goto L42;
                r0 = getTraceViewersFieldBuilder();
            L42:
                this.traceViewersBuilder_ = r0;
                goto L44
            L43:
                this.traceViewersBuilder_.addAllMessages(VoiceWakeupEvent.access$5700(r3));
                goto L44
            }

            /* JADX INFO: renamed from: mergeUnknownFields, reason: collision with other method in class */
            public final Builder m400mergeUnknownFields(UnknownFieldSet r1) {
                return (Builder) super.mergeUnknownFields(r1);
            }

            public Builder putAllExtra(Map<String, String> r2) {
                internalGetMutableExtra().getMutableMap().putAll(r2);
                return this;
            }

            public Builder removeExtra(String r2) {
                if (r2 == null) goto L6;
                internalGetMutableExtra().getMutableMap().remove(r2);
                return this;
            L6:
                throw null;
            }

            public Builder removeTraceViewers(int r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                ensureTraceViewersIsMutable();
                ListProtector.remove(this.traceViewers_, r2);
                onChanged();
            L6:
                return this;
            L5:
                r0.remove(r2);
                goto L6
            }

            public Builder setEventName(String r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 1;
                this.eventName_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setEventNameBytes(ByteString r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 1;
                this.eventName_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setEventReportSource(String r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 2;
                this.eventReportSource_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setEventReportSourceBytes(ByteString r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 2;
                this.eventReportSource_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setRejectReason(String r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 64;
                this.rejectReason_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setRejectReasonBytes(ByteString r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 64;
                this.rejectReason_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setTimestamp(long r2) {
                this.bitField0_ |= 8;
                this.timestamp_ = r2;
                onChanged();
                return this;
            }

            public Builder setTraceId(String r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 4;
                this.traceId_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setTraceIdBytes(ByteString r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 4;
                this.traceId_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            /* JADX INFO: renamed from: setUnknownFields, reason: collision with other method in class */
            public final Builder m406setUnknownFields(UnknownFieldSet r1) {
                return (Builder) super.setUnknownFields(r1);
            }

            public Builder setWakeupStage(String r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 16;
                this.wakeupStage_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setWakeupStageBytes(ByteString r2) {
                if (r2 == null) goto L6;
                this.bitField0_ |= 16;
                this.wakeupStage_ = r2;
                onChanged();
                return this;
            L6:
                throw null;
            }

            public Builder setWakeupSuccess(boolean r2) {
                this.bitField0_ |= 32;
                this.wakeupSuccess_ = r2;
                onChanged();
                return this;
            }

            public /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            public Builder addTraceViewers(AssistAudioEventDataTraceViewer r2) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L8;
                if (r2 == null) goto L7;
                ensureTraceViewersIsMutable();
                this.traceViewers_.add(r2);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.addMessage(r2);
                goto L9
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearField(Descriptors.FieldDescriptor r1) {
                return m380clearField(r1);
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r1) {
                return m383clearOneof(r1);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public Builder m397mergeFrom(Message r2) {
                if ((r2 instanceof VoiceWakeupEvent) == true) goto L5;
                super/*com.google.protobuf.AbstractMessage.Builder*/.mergeFrom(r2);
                return this;
            L5:
                return mergeFrom((VoiceWakeupEvent) r2);
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r1) {
                return m400mergeUnknownFields(r1);
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r1) {
                return m406setUnknownFields(r1);
            }

            /* JADX INFO: renamed from: clearField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m379clearField(Descriptors.FieldDescriptor r1) {
                return m380clearField(r1);
            }

            /* JADX INFO: renamed from: clearOneof, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m381clearOneof(Descriptors.OneofDescriptor r1) {
                return m383clearOneof(r1);
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r1) {
                return m397mergeFrom(r1);
            }

            /* JADX INFO: renamed from: mergeUnknownFields, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder m398mergeUnknownFields(UnknownFieldSet r1) {
                return m400mergeUnknownFields(r1);
            }

            /* JADX INFO: renamed from: setUnknownFields, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m405setUnknownFields(UnknownFieldSet r1) {
                return m406setUnknownFields(r1);
            }

            /* JADX INFO: renamed from: clearOneof, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m382clearOneof(Descriptors.OneofDescriptor r1) {
                return m383clearOneof(r1);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m394mergeFrom(Message r1) {
                return m397mergeFrom(r1);
            }

            /* JADX INFO: renamed from: mergeUnknownFields, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m399mergeUnknownFields(UnknownFieldSet r1) {
                return m400mergeUnknownFields(r1);
            }

            public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r1, AnonymousClass1 r2) {
                this(r1);
            }

            /* JADX INFO: renamed from: addRepeatedField, reason: collision with other method in class */
            public Builder m370addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
                return (Builder) super.addRepeatedField(r1, r2);
            }

            public Builder addTraceViewers(int r2, AssistAudioEventDataTraceViewer.Builder r3) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                ensureTraceViewersIsMutable();
                ListProtector.add(this.traceViewers_, r2, r3.m96build());
                onChanged();
            L6:
                return this;
            L5:
                r0.addMessage(r2, r3.m96build());
                goto L6
            }

            @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
            public String getExtraOrDefault(String r3, String r4) {
                if (r3 == null) goto L8;
                Map r0 = internalGetExtra().getMap();
                if (r0.containsKey(r3) == true) goto L6;
                return r4;
            L6:
                return (String) r0.get(r3);
            L8:
                throw null;
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public Builder m396mergeFrom(CodedInputStream r3, ExtensionRegistryLite r4) throws IOException {
                VoiceWakeupEvent r0 = null;
                VoiceWakeupEvent r5 = (VoiceWakeupEvent) VoiceWakeupEvent.PARSER.parsePartialFrom(r3, r4);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r5 == null) goto L6;
                mergeFrom(r5);
            L6:
                return this;
            L9:
                e = move-exception;
                VoiceWakeupEvent r6 = (VoiceWakeupEvent) e.getUnfinishedMessage();     // Catch: Throwable -> L7
            L13:
                th = th;
                r0 = r6;
            L15:
                if (r0 == null) goto L17;
                mergeFrom(r0);
            L17:
                throw th;
            L12:
                throw e.unwrapIOException();     // Catch: Throwable -> L13
            L7:
                th = th;
                goto L15
            }

            public Builder putExtra(String r2, String r3) {
                if (r2 == null) goto L8;
                if (r3 == null) goto L7;
                internalGetMutableExtra().getMutableMap().put(r2, r3);
                return this;
            L7:
                throw null;
            L8:
                throw null;
            }

            /* JADX INFO: renamed from: setField, reason: collision with other method in class */
            public Builder m402setField(Descriptors.FieldDescriptor r1, Object r2) {
                return (Builder) super.setField(r1, r2);
            }

            public Builder setTraceViewers(int r2, AssistAudioEventDataTraceViewer.Builder r3) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L5;
                ensureTraceViewersIsMutable();
                ListProtector.set(this.traceViewers_, r2, r3.m96build());
                onChanged();
            L6:
                return this;
            L5:
                r0.setMessage(r2, r3.m96build());
                goto L6
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
                return m370addRepeatedField(r1, r2);
            }

            public Builder addTraceViewers(int r2, AssistAudioEventDataTraceViewer r3) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L8;
                if (r3 == null) goto L7;
                ensureTraceViewersIsMutable();
                ListProtector.add(this.traceViewers_, r2, r3);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.addMessage(r2, r3);
                goto L9
            }

            public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m396mergeFrom(r1, r2);
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setField(Descriptors.FieldDescriptor r1, Object r2) {
                return m402setField(r1, r2);
            }

            public Builder setTraceViewers(int r2, AssistAudioEventDataTraceViewer r3) {
                RepeatedFieldBuilderV3<AssistAudioEventDataTraceViewer, AssistAudioEventDataTraceViewer.Builder, AssistAudioEventDataTraceViewerOrBuilder> r0 = this.traceViewersBuilder_;
                if (r0 != null) goto L8;
                if (r3 == null) goto L7;
                ensureTraceViewersIsMutable();
                ListProtector.set(this.traceViewers_, r2, r3);
                onChanged();
            L9:
                return this;
            L7:
                throw null;
            L8:
                r0.setMessage(r2, r3);
                goto L9
            }

            /* JADX INFO: renamed from: addRepeatedField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m369addRepeatedField(Descriptors.FieldDescriptor r1, Object r2) {
                return m370addRepeatedField(r1, r2);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder m392mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m396mergeFrom(r1, r2);
            }

            /* JADX INFO: renamed from: setField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m401setField(Descriptors.FieldDescriptor r1, Object r2) {
                return m402setField(r1, r2);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m393mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m396mergeFrom(r1, r2);
            }

            /* JADX INFO: renamed from: mergeFrom, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ MessageLite.Builder m395mergeFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
                return m396mergeFrom(r1, r2);
            }

            /* JADX INFO: renamed from: setRepeatedField, reason: collision with other method in class */
            public Builder m404setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
                return (Builder) super.setRepeatedField(r1, r2, r3);
            }

            public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
                return m404setRepeatedField(r1, r2, r3);
            }

            /* JADX INFO: renamed from: setRepeatedField, reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Message.Builder m403setRepeatedField(Descriptors.FieldDescriptor r1, int r2, Object r3) {
                return m404setRepeatedField(r1, r2, r3);
            }
        }

        public static final class ExtraDefaultEntryHolder {
            static final MapEntry<String, String> defaultEntry = null;

            private ExtraDefaultEntryHolder() {
            }

            static {
                Descriptors.Descriptor r0 = AssistAudioEventProto.access$4400();
                WireFormat.FieldType r1 = WireFormat.FieldType.STRING;
                defaultEntry = MapEntry.newDefaultInstance(r0, r1, NameKeys.UnloadStrategy_No_Strategy, r1, NameKeys.UnloadStrategy_No_Strategy);
            }
        }

        static {
            DEFAULT_INSTANCE = new VoiceWakeupEvent();
            PARSER = new AnonymousClass1();
        }

        private MapField<String, String> internalGetExtra() {
            MapField<String, String> r0 = this.extra_;
            if (r0 == null) goto L5;
            return r0;
        L5:
            return MapField.emptyMapField(ExtraDefaultEntryHolder.defaultEntry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.m367toBuilder();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
        public String getEventName() {
            Object r0 = this.eventName_;
            if ((r0 instanceof String) == true) goto L5;
            ByteString r1 = (ByteString) r0;
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L9;
            this.eventName_ = r2;
        L9:
            return r2;
        L5:
            return (String) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
        public ByteString getEventNameBytes() {
            Object r0 = this.eventName_;
            if ((r0 instanceof String) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) r0);
            this.eventName_ = r1;
            return r1;
        L7:
            return (ByteString) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
        public String getEventReportSource() {
            Object r0 = this.eventReportSource_;
            if ((r0 instanceof String) == true) goto L5;
            ByteString r1 = (ByteString) r0;
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L9;
            this.eventReportSource_ = r2;
        L9:
            return r2;
        L5:
            return (String) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
        public ByteString getEventReportSourceBytes() {
            Object r0 = this.eventReportSource_;
            if ((r0 instanceof String) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) r0);
            this.eventReportSource_ = r1;
            return r1;
        L7:
            return (ByteString) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
        public String getRejectReason() {
            Object r0 = this.rejectReason_;
            if ((r0 instanceof String) == true) goto L5;
            ByteString r1 = (ByteString) r0;
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L9;
            this.rejectReason_ = r2;
        L9:
            return r2;
        L5:
            return (String) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
        public ByteString getRejectReasonBytes() {
            Object r0 = this.rejectReason_;
            if ((r0 instanceof String) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) r0);
            this.rejectReason_ = r1;
            return r1;
        L7:
            return (ByteString) r0;
        }

        public int getSerializedSize() {
            int r0 = ((AbstractMessage) this).memoizedSize;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            int r2 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r1 = GeneratedMessageV3.computeStringSize(1, this.eventName_) + 0;
        L10:
            if ((this.bitField0_ & 2) != 2) goto L13;
            r1 = r1 + GeneratedMessageV3.computeStringSize(2, this.eventReportSource_);
        L13:
            if ((this.bitField0_ & 4) != 4) goto L16;
            r1 = r1 + GeneratedMessageV3.computeStringSize(3, this.traceId_);
        L16:
            if ((this.bitField0_ & 8) != 8) goto L19;
            r1 = r1 + CodedOutputStream.computeInt64Size(4, this.timestamp_);
        L19:
            if ((this.bitField0_ & 16) != 16) goto L22;
            r1 = r1 + GeneratedMessageV3.computeStringSize(5, this.wakeupStage_);
        L22:
            if ((this.bitField0_ & 32) != 32) goto L25;
            r1 = r1 + CodedOutputStream.computeBoolSize(6, this.wakeupSuccess_);
        L25:
            if ((this.bitField0_ & 64) != 64) goto L27;
            r1 = r1 + GeneratedMessageV3.computeStringSize(7, this.rejectReason_);
        L27:
            Iterator r3 = internalGetExtra().getMap().entrySet().iterator();
        L29:
            if (r3.hasNext() == false) goto L32;
            Map.Entry r4 = (Map.Entry) r3.next();
            r1 = r1 + CodedOutputStream.computeMessageSize(8, ExtraDefaultEntryHolder.defaultEntry.newBuilderForType().setKey((String) r4.getKey()).setValue((String) r4.getValue()).build());
        L32:
            if (r2 >= this.traceViewers_.size()) goto L34;
            r1 = r1 + CodedOutputStream.computeMessageSize(9, (MessageLite) ListProtector.get(this.traceViewers_, r2));
            r2 = r2 + 1;
            goto L32
        L34:
            int r5 = r1 + ((GeneratedMessageV3) this).unknownFields.getSerializedSize();
            ((AbstractMessage) this).memoizedSize = r5;
            return r5;
        L8:
            r1 = 0;
            goto L10
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
        public String getTraceId() {
            Object r0 = this.traceId_;
            if ((r0 instanceof String) == true) goto L5;
            ByteString r1 = (ByteString) r0;
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L9;
            this.traceId_ = r2;
        L9:
            return r2;
        L5:
            return (String) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
        public ByteString getTraceIdBytes() {
            Object r0 = this.traceId_;
            if ((r0 instanceof String) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) r0);
            this.traceId_ = r1;
            return r1;
        L7:
            return (ByteString) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
        public int getTraceViewersCount() {
            return this.traceViewers_.size();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
        public String getWakeupStage() {
            Object r0 = this.wakeupStage_;
            if ((r0 instanceof String) == true) goto L5;
            ByteString r1 = (ByteString) r0;
            String r2 = r1.toStringUtf8();
            if (r1.isValidUtf8() == false) goto L9;
            this.wakeupStage_ = r2;
        L9:
            return r2;
        L5:
            return (String) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
        public ByteString getWakeupStageBytes() {
            Object r0 = this.wakeupStage_;
            if ((r0 instanceof String) == false) goto L7;
            ByteString r1 = ByteString.copyFromUtf8((String) r0);
            this.wakeupStage_ = r1;
            return r1;
        L7:
            return (ByteString) r0;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
        public boolean hasEventName() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
        public boolean hasEventReportSource() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
        public boolean hasRejectReason() {
            if ((this.bitField0_ & 64) != 64) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
        public boolean hasTimestamp() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
        public boolean hasTraceId() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
        public boolean hasWakeupStage() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
        public boolean hasWakeupSuccess() {
            if ((this.bitField0_ & 32) != 32) goto L5;
            return true;
        L5:
            return false;
        }

        public int hashCode() {
            int r0 = ((AbstractMessageLite) this).memoizedHashCode;
            if (r0 == 0) goto L5;
            return r0;
        L5:
            int r1 = 779 + getDescriptor().hashCode();
            if (hasEventName() == false) goto L9;
            r1 = (((r1 * 37) + 1) * 53) + getEventName().hashCode();
        L9:
            if (hasEventReportSource() == false) goto L12;
            r1 = (((r1 * 37) + 2) * 53) + getEventReportSource().hashCode();
        L12:
            if (hasTraceId() == false) goto L15;
            r1 = (((r1 * 37) + 3) * 53) + getTraceId().hashCode();
        L15:
            if (hasTimestamp() == false) goto L18;
            r1 = (((r1 * 37) + 4) * 53) + Internal.hashLong(getTimestamp());
        L18:
            if (hasWakeupStage() == false) goto L21;
            r1 = (((r1 * 37) + 5) * 53) + getWakeupStage().hashCode();
        L21:
            if (hasWakeupSuccess() == false) goto L24;
            r1 = (((r1 * 37) + 6) * 53) + Internal.hashBoolean(getWakeupSuccess());
        L24:
            if (hasRejectReason() == false) goto L27;
            r1 = (((r1 * 37) + 7) * 53) + getRejectReason().hashCode();
        L27:
            if (internalGetExtra().getMap().isEmpty() == true) goto L30;
            r1 = (((r1 * 37) + 8) * 53) + internalGetExtra().hashCode();
        L30:
            if (getTraceViewersCount() <= 0) goto L32;
            r1 = (((r1 * 37) + 9) * 53) + getTraceViewersList().hashCode();
        L32:
            int r2 = (r1 * 29) + ((GeneratedMessageV3) this).unknownFields.hashCode();
            ((AbstractMessageLite) this).memoizedHashCode = r2;
            return r2;
        }

        public final boolean isInitialized() {
            byte r0 = this.memoizedIsInitialized;
            if (r0 != 1) goto L5;
            return true;
        L5:
            if (r0 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        /* JADX INFO: renamed from: toBuilder, reason: collision with other method in class */
        public Builder m367toBuilder() {
            AnonymousClass1 r1 = null;
            if (this != DEFAULT_INSTANCE) goto L6;
            return new Builder(r1);
        L6:
            return new Builder(r1).mergeFrom(this);
        }

        private VoiceWakeupEvent() {
            this.memoizedIsInitialized = -1;
            this.eventName_ = NameKeys.UnloadStrategy_No_Strategy;
            this.eventReportSource_ = NameKeys.UnloadStrategy_No_Strategy;
            this.traceId_ = NameKeys.UnloadStrategy_No_Strategy;
            this.timestamp_ = 0;
            this.wakeupStage_ = NameKeys.UnloadStrategy_No_Strategy;
            this.wakeupSuccess_ = false;
            this.rejectReason_ = NameKeys.UnloadStrategy_No_Strategy;
            this.traceViewers_ = Collections.emptyList();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AssistAudioEventProto.access$4200();
        }

        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return m362getDefaultInstanceForType();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
        public Map<String, String> getExtra() {
            return getExtraMap();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
        public int getExtraCount() {
            return internalGetExtra().getMap().size();
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
        public Map<String, String> getExtraMap() {
            return internalGetExtra().getMap();
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AssistAudioEventProto.access$4300().ensureFieldAccessorsInitialized(VoiceWakeupEvent.class, Builder.class);
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
            return m364newBuilderForType();
        }

        public static /* synthetic */ boolean access$4700() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static /* synthetic */ boolean access$6000() {
            return GeneratedMessageV3.alwaysUseFieldBuilders;
        }

        public static VoiceWakeupEvent getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<VoiceWakeupEvent> parser() {
            return PARSER;
        }

        public Parser<VoiceWakeupEvent> getParserForType() {
            return PARSER;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
        public long getTimestamp() {
            return this.timestamp_;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
        public List<AssistAudioEventDataTraceViewer> getTraceViewersList() {
            return this.traceViewers_;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
        public List<? extends AssistAudioEventDataTraceViewerOrBuilder> getTraceViewersOrBuilderList() {
            return this.traceViewers_;
        }

        public final UnknownFieldSet getUnknownFields() {
            return ((GeneratedMessageV3) this).unknownFields;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
        public boolean getWakeupSuccess() {
            return this.wakeupSuccess_;
        }

        /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite m361getDefaultInstanceForType() {
            return m362getDefaultInstanceForType();
        }

        /* JADX INFO: renamed from: newBuilderForType, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite.Builder m363newBuilderForType() {
            return m364newBuilderForType();
        }

        public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
            return m367toBuilder();
        }

        /* JADX INFO: renamed from: getDefaultInstanceForType, reason: collision with other method in class */
        public VoiceWakeupEvent m362getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: renamed from: newBuilderForType, reason: collision with other method in class */
        public Builder m364newBuilderForType() {
            return newBuilder();
        }

        /* JADX INFO: renamed from: toBuilder, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ MessageLite.Builder m366toBuilder() {
            return m367toBuilder();
        }

        private VoiceWakeupEvent(GeneratedMessageV3.Builder<?> r1) {
            super(r1);
            this.memoizedIsInitialized = -1;
        }

        public static /* synthetic */ Object access$4900(VoiceWakeupEvent r0) {
            return r0.eventName_;
        }

        public static /* synthetic */ Object access$5000(VoiceWakeupEvent r0) {
            return r0.eventReportSource_;
        }

        public static /* synthetic */ Object access$5100(VoiceWakeupEvent r0) {
            return r0.traceId_;
        }

        public static /* synthetic */ Object access$5300(VoiceWakeupEvent r0) {
            return r0.wakeupStage_;
        }

        public static /* synthetic */ Object access$5500(VoiceWakeupEvent r0) {
            return r0.rejectReason_;
        }

        public static /* synthetic */ MapField access$5600(VoiceWakeupEvent r0) {
            return r0.extra_;
        }

        public static /* synthetic */ List access$5700(VoiceWakeupEvent r0) {
            return r0.traceViewers_;
        }

        public static /* synthetic */ MapField access$5900(VoiceWakeupEvent r0) {
            return r0.internalGetExtra();
        }

        public static /* synthetic */ UnknownFieldSet access$6100(VoiceWakeupEvent r0) {
            return ((GeneratedMessageV3) r0).unknownFields;
        }

        public static Builder newBuilder(VoiceWakeupEvent r1) {
            return DEFAULT_INSTANCE.m367toBuilder().mergeFrom(r1);
        }

        public static VoiceWakeupEvent parseDelimitedFrom(InputStream r1) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r1);
        }

        public static VoiceWakeupEvent parseFrom(ByteString r1) throws InvalidProtocolBufferException {
            return (VoiceWakeupEvent) PARSER.parseFrom(r1);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
        public boolean containsExtra(String r2) {
            if (r2 == null) goto L6;
            return internalGetExtra().getMap().containsKey(r2);
        L6:
            throw null;
        }

        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof VoiceWakeupEvent) == false) goto L8;
            VoiceWakeupEvent r9 = (VoiceWakeupEvent) r8;
            if (hasEventName() != r9.hasEventName()) goto L12;
            boolean r1 = true;
        L14:
            if (hasEventName() == false) goto L20;
            if (r1 == true) goto L17;
        L19:
            r1 = false;
            goto L20
        L17:
            if (getEventName().equals(r9.getEventName()) == false) goto L19;
            r1 = true;
        L20:
            if (r1 == true) goto L22;
        L24:
            boolean r2 = false;
        L26:
            if (hasEventReportSource() == false) goto L32;
            if (r2 == true) goto L29;
        L31:
            r2 = false;
            goto L32
        L29:
            if (getEventReportSource().equals(r9.getEventReportSource()) == false) goto L31;
            r2 = true;
        L32:
            if (r2 == true) goto L34;
        L36:
            boolean r3 = false;
        L38:
            if (hasTraceId() == false) goto L44;
            if (r3 == true) goto L41;
        L43:
            r3 = false;
            goto L44
        L41:
            if (getTraceId().equals(r9.getTraceId()) == false) goto L43;
            r3 = true;
        L44:
            if (r3 == true) goto L46;
        L48:
            boolean r4 = false;
        L50:
            if (hasTimestamp() == false) goto L56;
            if (r4 == true) goto L53;
        L55:
            r4 = false;
            goto L56
        L53:
            if (getTimestamp() != r9.getTimestamp()) goto L55;
            r4 = true;
        L56:
            if (r4 == true) goto L58;
        L60:
            boolean r5 = false;
        L62:
            if (hasWakeupStage() == false) goto L68;
            if (r5 == true) goto L65;
        L67:
            r5 = false;
            goto L68
        L65:
            if (getWakeupStage().equals(r9.getWakeupStage()) == false) goto L67;
            r5 = true;
        L68:
            if (r5 == true) goto L70;
        L72:
            boolean r6 = false;
        L74:
            if (hasWakeupSuccess() == false) goto L80;
            if (r6 == true) goto L77;
        L79:
            r6 = false;
            goto L80
        L77:
            if (getWakeupSuccess() != r9.getWakeupSuccess()) goto L79;
            r6 = true;
        L80:
            if (r6 == true) goto L82;
        L84:
            boolean r7 = false;
        L86:
            if (hasRejectReason() == false) goto L92;
            if (r7 == true) goto L89;
        L91:
            r7 = false;
            goto L92
        L89:
            if (getRejectReason().equals(r9.getRejectReason()) == false) goto L91;
            r7 = true;
        L92:
            if (r7 == true) goto L94;
        L96:
            boolean r10 = false;
        L97:
            if (r10 == true) goto L99;
        L101:
            boolean r11 = false;
        L102:
            if (r11 == true) goto L104;
        L106:
            return false;
        L104:
            if (((GeneratedMessageV3) this).unknownFields.equals(((GeneratedMessageV3) r9).unknownFields) == false) goto L106;
            return true;
        L99:
            if (getTraceViewersList().equals(r9.getTraceViewersList()) == false) goto L101;
            r11 = true;
            goto L102
        L94:
            if (internalGetExtra().equals(r9.internalGetExtra()) == false) goto L96;
            r10 = true;
            goto L97
        L82:
            if (hasRejectReason() != r9.hasRejectReason()) goto L84;
            r7 = true;
            goto L86
        L70:
            if (hasWakeupSuccess() != r9.hasWakeupSuccess()) goto L72;
            r6 = true;
            goto L74
        L58:
            if (hasWakeupStage() != r9.hasWakeupStage()) goto L60;
            r5 = true;
            goto L62
        L46:
            if (hasTimestamp() != r9.hasTimestamp()) goto L48;
            r4 = true;
            goto L50
        L34:
            if (hasTraceId() != r9.hasTraceId()) goto L36;
            r3 = true;
            goto L38
        L22:
            if (hasEventReportSource() != r9.hasEventReportSource()) goto L24;
            r2 = true;
            goto L26
        L12:
            r1 = false;
            goto L14
        L8:
            return super/*com.google.protobuf.AbstractMessage*/.equals(r8);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
        public String getExtraOrThrow(String r3) {
            if (r3 == null) goto L10;
            Map r0 = internalGetExtra().getMap();
            if (r0.containsKey(r3) == false) goto L8;
            return (String) r0.get(r3);
        L8:
            throw new IllegalArgumentException();
        L10:
            throw null;
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
        public AssistAudioEventDataTraceViewer getTraceViewers(int r2) {
            return (AssistAudioEventDataTraceViewer) ListProtector.get(this.traceViewers_, r2);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
        public AssistAudioEventDataTraceViewerOrBuilder getTraceViewersOrBuilder(int r2) {
            return (AssistAudioEventDataTraceViewerOrBuilder) ListProtector.get(this.traceViewers_, r2);
        }

        public MapField internalGetMapField(int r4) {
            if (r4 != 8) goto L7;
            return internalGetExtra();
        L7:
            throw new RuntimeException("Invalid map field number: " + r4);
        }

        /* JADX INFO: renamed from: newBuilderForType, reason: collision with other method in class */
        public Builder m365newBuilderForType(GeneratedMessageV3.BuilderParent r3) {
            return new Builder(r3, null);
        }

        public void writeTo(CodedOutputStream r6) throws IOException {
            if ((this.bitField0_ & 1) != 1) goto L6;
            GeneratedMessageV3.writeString(r6, 1, this.eventName_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            GeneratedMessageV3.writeString(r6, 2, this.eventReportSource_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L12;
            GeneratedMessageV3.writeString(r6, 3, this.traceId_);
        L12:
            if ((this.bitField0_ & 8) != 8) goto L15;
            r6.writeInt64(4, this.timestamp_);
        L15:
            if ((this.bitField0_ & 16) != 16) goto L18;
            GeneratedMessageV3.writeString(r6, 5, this.wakeupStage_);
        L18:
            if ((this.bitField0_ & 32) != 32) goto L21;
            r6.writeBool(6, this.wakeupSuccess_);
        L21:
            if ((this.bitField0_ & 64) != 64) goto L23;
            GeneratedMessageV3.writeString(r6, 7, this.rejectReason_);
        L23:
            GeneratedMessageV3.serializeStringMapTo(r6, internalGetExtra(), ExtraDefaultEntryHolder.defaultEntry, 8);
            int r0 = 0;
        L25:
            if (r0 >= this.traceViewers_.size()) goto L27;
            r6.writeMessage(9, (MessageLite) ListProtector.get(this.traceViewers_, r0));
            r0 = r0 + 1;
            goto L25
        L27:
            ((GeneratedMessageV3) this).unknownFields.writeTo(r6);
        }

        public static VoiceWakeupEvent parseFrom(CodedInputStream r1) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1);
        }

        public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r1) {
            return m365newBuilderForType(r1);
        }

        public static VoiceWakeupEvent parseFrom(InputStream r1) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1);
        }

        public static VoiceWakeupEvent parseFrom(ByteBuffer r1) throws InvalidProtocolBufferException {
            return (VoiceWakeupEvent) PARSER.parseFrom(r1);
        }

        public static VoiceWakeupEvent parseFrom(byte[] r1) throws InvalidProtocolBufferException {
            return (VoiceWakeupEvent) PARSER.parseFrom(r1);
        }

        private VoiceWakeupEvent(CodedInputStream r9, ExtensionRegistryLite r10) throws InvalidProtocolBufferException {
            this();
            if (r10 == null) goto L66;
            UnknownFieldSet.Builder r0 = UnknownFieldSet.newBuilder();
            boolean r1 = false;
            int r2 = 0;
        L6:
            if (r1 == true) goto L61;
            int r4 = r9.readTag();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            if (r4 == 0) goto L46;
            if (r4 != 10) goto L12;
            ByteString r5 = r9.readBytes();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.bitField0_ = 1 | this.bitField0_;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.eventName_ = r5;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L6
        L12:
            if (r4 != 18) goto L14;
            ByteString r6 = r9.readBytes();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.bitField0_ |= 2;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.eventReportSource_ = r6;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L6
        L14:
            if (r4 != 26) goto L16;
            ByteString r7 = r9.readBytes();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.bitField0_ |= 4;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.traceId_ = r7;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L6
        L16:
            if (r4 != 32) goto L18;
            this.bitField0_ |= 8;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.timestamp_ = r9.readInt64();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L6
        L18:
            if (r4 != 42) goto L20;
            ByteString r8 = r9.readBytes();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.bitField0_ |= 16;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.wakeupStage_ = r8;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L6
        L20:
            if (r4 != 48) goto L22;
            this.bitField0_ |= 32;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.wakeupSuccess_ = r9.readBool();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L6
        L22:
            if (r4 != 58) goto L24;
            ByteString r11 = r9.readBytes();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.bitField0_ |= 64;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.rejectReason_ = r11;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L6
        L24:
            if (r4 != 66) goto L26;
            if ((r2 & LynxTouchEvent.kPseudoStateFocusTransition) == 128) goto L37;
            this.extra_ = MapField.newMapField(ExtraDefaultEntryHolder.defaultEntry);     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            r2 = r2 | LynxTouchEvent.kPseudoStateFocusTransition;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
        L37:
            MapEntry r12 = r9.readMessage(ExtraDefaultEntryHolder.defaultEntry.getParserForType(), r10);     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            this.extra_.getMutableMap().put((String) r12.getKey(), (String) r12.getValue());     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L6
        L26:
            if (r4 != 74) goto L28;
            if ((r2 & 256) == 256) goto L33;
            this.traceViewers_ = new ArrayList();     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            r2 = r2 | 256;     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
        L33:
            this.traceViewers_.add((AssistAudioEventDataTraceViewer) r9.readMessage(AssistAudioEventDataTraceViewer.PARSER, r10));     // Catch: Throwable -> L47 IOException -> L49 InvalidProtocolBufferException -> L52
            goto L6
        L28:
            if (parseUnknownField(r9, r0, r10, r4) == true) goto L6;
        L46:
            r1 = true;
            goto L6
        L47:
            th = move-exception;
            if ((r2 & 256) != 256) goto L58;
            this.traceViewers_ = Collections.unmodifiableList(this.traceViewers_);
        L58:
            ((GeneratedMessageV3) this).unknownFields = r0.build();
            makeExtensionsImmutable();
            throw th;
        L49:
            e = move-exception;
            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);     // Catch: Throwable -> L47
        L52:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L47
        L61:
            if ((r2 & 256) != 256) goto L63;
            this.traceViewers_ = Collections.unmodifiableList(this.traceViewers_);
        L63:
            ((GeneratedMessageV3) this).unknownFields = r0.build();
            makeExtensionsImmutable();
            return;
        L66:
            throw null;
        }

        public static /* synthetic */ Object access$4902(VoiceWakeupEvent r0, Object r1) {
            r0.eventName_ = r1;
            return r1;
        }

        public static /* synthetic */ Object access$5002(VoiceWakeupEvent r0, Object r1) {
            r0.eventReportSource_ = r1;
            return r1;
        }

        public static /* synthetic */ Object access$5102(VoiceWakeupEvent r0, Object r1) {
            r0.traceId_ = r1;
            return r1;
        }

        public static /* synthetic */ long access$5202(VoiceWakeupEvent r0, long r1) {
            r0.timestamp_ = r1;
            return r1;
        }

        public static /* synthetic */ Object access$5302(VoiceWakeupEvent r0, Object r1) {
            r0.wakeupStage_ = r1;
            return r1;
        }

        public static /* synthetic */ boolean access$5402(VoiceWakeupEvent r0, boolean r1) {
            r0.wakeupSuccess_ = r1;
            return r1;
        }

        public static /* synthetic */ Object access$5502(VoiceWakeupEvent r0, Object r1) {
            r0.rejectReason_ = r1;
            return r1;
        }

        public static /* synthetic */ MapField access$5602(VoiceWakeupEvent r0, MapField r1) {
            r0.extra_ = r1;
            return r1;
        }

        public static /* synthetic */ List access$5702(VoiceWakeupEvent r0, List r1) {
            r0.traceViewers_ = r1;
            return r1;
        }

        public static /* synthetic */ int access$5802(VoiceWakeupEvent r0, int r1) {
            r0.bitField0_ = r1;
            return r1;
        }

        public static VoiceWakeupEvent parseDelimitedFrom(InputStream r1, ExtensionRegistryLite r2) throws IOException {
            return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, r1, r2);
        }

        public static VoiceWakeupEvent parseFrom(ByteString r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
            return (VoiceWakeupEvent) PARSER.parseFrom(r1, r2);
        }

        @Override // com.obric.assistant.AssistAudioEventProto.VoiceWakeupEventOrBuilder
        public String getExtraOrDefault(String r3, String r4) {
            if (r3 == null) goto L8;
            Map r0 = internalGetExtra().getMap();
            if (r0.containsKey(r3) == true) goto L6;
            return r4;
        L6:
            return (String) r0.get(r3);
        L8:
            throw null;
        }

        public /* synthetic */ VoiceWakeupEvent(GeneratedMessageV3.Builder r1, AnonymousClass1 r2) {
            this(r1);
        }

        public static VoiceWakeupEvent parseFrom(CodedInputStream r1, ExtensionRegistryLite r2) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1, r2);
        }

        public static VoiceWakeupEvent parseFrom(InputStream r1, ExtensionRegistryLite r2) throws IOException {
            return GeneratedMessageV3.parseWithIOException(PARSER, r1, r2);
        }

        public static VoiceWakeupEvent parseFrom(ByteBuffer r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
            return (VoiceWakeupEvent) PARSER.parseFrom(r1, r2);
        }

        public static VoiceWakeupEvent parseFrom(byte[] r1, ExtensionRegistryLite r2) throws InvalidProtocolBufferException {
            return (VoiceWakeupEvent) PARSER.parseFrom(r1, r2);
        }

        public /* synthetic */ VoiceWakeupEvent(CodedInputStream r1, ExtensionRegistryLite r2, AnonymousClass1 r3) throws InvalidProtocolBufferException {
            this(r1, r2);
        }
    }

    public interface VoiceWakeupEventOrBuilder extends MessageOrBuilder {
        boolean containsExtra(String r1);

        String getEventName();

        ByteString getEventNameBytes();

        String getEventReportSource();

        ByteString getEventReportSourceBytes();

        Map<String, String> getExtra();

        int getExtraCount();

        Map<String, String> getExtraMap();

        String getExtraOrDefault(String r1, String r2);

        String getExtraOrThrow(String r1);

        String getRejectReason();

        ByteString getRejectReasonBytes();

        long getTimestamp();

        String getTraceId();

        ByteString getTraceIdBytes();

        AssistAudioEventDataTraceViewer getTraceViewers(int r1);

        int getTraceViewersCount();

        List<AssistAudioEventDataTraceViewer> getTraceViewersList();

        AssistAudioEventDataTraceViewerOrBuilder getTraceViewersOrBuilder(int r1);

        List<? extends AssistAudioEventDataTraceViewerOrBuilder> getTraceViewersOrBuilderList();

        String getWakeupStage();

        ByteString getWakeupStageBytes();

        boolean getWakeupSuccess();

        boolean hasEventName();

        boolean hasEventReportSource();

        boolean hasRejectReason();

        boolean hasTimestamp();

        boolean hasTraceId();

        boolean hasWakeupStage();

        boolean hasWakeupSuccess();
    }

    private AssistAudioEventProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite r0) {
    }

    static {
        Descriptors.FileDescriptor[] r3 = new Descriptors.FileDescriptor[0];
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0011AssistAudio.proto\u0012\u0013com.obric.assistant\"Ä\u0003\n\u0014AssistAudioEventData\u0012G\n\u0015voice_wakeup_duration\u0018\u0001 \u0003(\u000b2(.com.obric.assistant.VoiceWakeupDuration\u0012A\n\u0012voice_wakeup_event\u0018\u0002 \u0003(\u000b2%.com.obric.assistant.VoiceWakeupEvent\u0012I\n\u0016breath_wakeup_duration\u0018\u0003 \u0003(\u000b2).com.obric.assistant.BreathWakeupDuration\u0012C\n\u0013breath_wakeup_event\u0018\u0004 \u0003(\u000b2&.com.obric.assistant.BreathWakeupEvent\u0012J\n\u0017realtime_call_durations\u0018\u0005 \u0003(\u000b2).com.obric.assistant.RealtimeCallDuration\u0012D\n\u0014realtime_call_events\u0018\u0006 \u0003(\u000b2&.com.obric.assistant.RealtimeCallEvent\"§\u0003\n\u0013VoiceWakeupDuration\u0012\u0012\n\nevent_name\u0018\u0001 \u0001(\t\u0012\u001b\n\u0013event_report_source\u0018\u0002 \u0001(\t\u0012\u0010\n\btrace_id\u0018\u0003 \u0001(\t\u0012\u0017\n\u000fstart_timestamp\u0018\u0004 \u0001(\u0003\u0012\u0015\n\rend_timestamp\u0018\u0005 \u0001(\u0003\u0012\u001e\n\u0016wakeup_stage1_duration\u0018\u0006 \u0001(\u0003\u0012\u001e\n\u0016wakeup_stage2_duration\u0018\u0007 \u0001(\u0003\u0012\u001e\n\u0016wakeup_stage3_duration\u0018\b \u0001(\u0003\u0012B\n\u0005extra\u0018\t \u0003(\u000b23.com.obric.assistant.VoiceWakeupDuration.ExtraEntry\u0012K\n\rtrace_viewers\u0018\n \u0003(\u000b24.com.obric.assistant.AssistAudioEventDataTraceViewer\u001a,\n\nExtraEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\t:\u00028\u0001\"é\u0002\n\u0010VoiceWakeupEvent\u0012\u0012\n\nevent_name\u0018\u0001 \u0001(\t\u0012\u001b\n\u0013event_report_source\u0018\u0002 \u0001(\t\u0012\u0010\n\btrace_id\u0018\u0003 \u0001(\t\u0012\u0011\n\ttimestamp\u0018\u0004 \u0001(\u0003\u0012\u0014\n\fwakeup_stage\u0018\u0005 \u0001(\t\u0012\u0016\n\u000ewakeup_success\u0018\u0006 \u0001(\b\u0012\u0015\n\rreject_reason\u0018\u0007 \u0001(\t\u0012?\n\u0005extra\u0018\b \u0003(\u000b20.com.obric.assistant.VoiceWakeupEvent.ExtraEntry\u0012K\n\rtrace_viewers\u0018\t \u0003(\u000b24.com.obric.assistant.AssistAudioEventDataTraceViewer\u001a,\n\nExtraEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\t:\u00028\u0001\"©\u0003\n\u0014BreathWakeupDuration\u0012\u0012\n\nevent_name\u0018\u0001 \u0001(\t\u0012\u001b\n\u0013event_report_source\u0018\u0002 \u0001(\t\u0012\u0010\n\btrace_id\u0018\u0003 \u0001(\t\u0012\u0017\n\u000fstart_timestamp\u0018\u0004 \u0001(\u0003\u0012\u0015\n\rend_timestamp\u0018\u0005 \u0001(\u0003\u0012\u001e\n\u0016wakeup_stage1_duration\u0018\u0006 \u0001(\u0003\u0012\u001e\n\u0016wakeup_stage2_duration\u0018\u0007 \u0001(\u0003\u0012\u001e\n\u0016wakeup_stage3_duration\u0018\b \u0001(\u0003\u0012C\n\u0005extra\u0018\t \u0003(\u000b24.com.obric.assistant.BreathWakeupDuration.ExtraEntry\u0012K\n\rtrace_viewers\u0018\n \u0003(\u000b24.com.obric.assistant.AssistAudioEventDataTraceViewer\u001a,\n\nExtraEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\t:\u00028\u0001\"ë\u0002\n\u0011BreathWakeupEvent\u0012\u0012\n\nevent_name\u0018\u0001 \u0001(\t\u0012\u001b\n\u0013event_report_source\u0018\u0002 \u0001(\t\u0012\u0010\n\btrace_id\u0018\u0003 \u0001(\t\u0012\u0011\n\ttimestamp\u0018\u0004 \u0001(\u0003\u0012\u0014\n\fwakeup_stage\u0018\u0005 \u0001(\t\u0012\u0016\n\u000ewakeup_success\u0018\u0006 \u0001(\b\u0012\u0015\n\rreject_reason\u0018\u0007 \u0001(\t\u0012@\n\u0005extra\u0018\b \u0003(\u000b21.com.obric.assistant.BreathWakeupEvent.ExtraEntry\u0012K\n\rtrace_viewers\u0018\t \u0003(\u000b24.com.obric.assistant.AssistAudioEventDataTraceViewer\u001a,\n\nExtraEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\t:\u00028\u0001\"É\u0002\n\u0014RealtimeCallDuration\u0012\u0012\n\nevent_name\u0018\u0001 \u0001(\t\u0012\u001b\n\u0013event_report_source\u0018\u0002 \u0001(\t\u0012\u0010\n\btrace_id\u0018\u0003 \u0001(\t\u0012\u0017\n\u000fstart_timestamp\u0018\u0004 \u0001(\u0003\u0012\u0015\n\rend_timestamp\u0018\u0005 \u0001(\u0003\u0012C\n\u0005extra\u0018\u0006 \u0003(\u000b24.com.obric.assistant.RealtimeCallDuration.ExtraEntry\u0012K\n\rtrace_viewers\u0018\u0007 \u0003(\u000b24.com.obric.assistant.AssistAudioEventDataTraceViewer\u001a,\n\nExtraEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\t:\u00028\u0001\"¦\u0002\n\u0011RealtimeCallEvent\u0012\u0012\n\nevent_name\u0018\u0001 \u0001(\t\u0012\u001b\n\u0013event_report_source\u0018\u0002 \u0001(\t\u0012\u0010\n\btrace_id\u0018\u0003 \u0001(\t\u0012\u0011\n\ttimestamp\u0018\u0004 \u0001(\u0003\u0012@\n\u0005extra\u0018\u0005 \u0003(\u000b21.com.obric.assistant.RealtimeCallEvent.ExtraEntry\u0012K\n\rtrace_viewers\u0018\u0006 \u0003(\u000b24.com.obric.assistant.AssistAudioEventDataTraceViewer\u001a,\n\nExtraEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\t\u0012\r\n\u0005value\u0018\u0002 \u0001(\t:\u00028\u0001\"\u0094\u0002\n\u001fAssistAudioEventDataTraceViewer\u0012\u0019\n\u0011trace_viewer_type\u0018\u0001 \u0001(\t\u0012\u001c\n\u0014trace_viewer_biz_tag\u0018\u0002 \u0001(\t\u0012\u001a\n\u0012trace_viewer_track\u0018\u0003 \u0001(\t\u0012\u0018\n\u0010trace_viewer_val\u0018\u0004 \u0001(\t\u0012\u001d\n\u0015trace_viewer_start_ts\u0018\u0005 \u0001(\u0003\u0012\u001b\n\u0013trace_viewer_end_ts\u0018\u0006 \u0001(\u0003\u0012\u001d\n\u0015trace_viewer_event_ts\u0018\u0007 \u0001(\u0003\u0012'\n\u001ftrace_viewer_expansion_key_list\u0018\b \u0003(\tB\u0017B\u0015AssistAudioEventProto"}, r3, new AnonymousClass1());
        Descriptors.Descriptor r0 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 0);
        internal_static_com_obric_assistant_AssistAudioEventData_descriptor = r0;
        internal_static_com_obric_assistant_AssistAudioEventData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r0, new String[]{"VoiceWakeupDuration", "VoiceWakeupEvent", "BreathWakeupDuration", "BreathWakeupEvent", "RealtimeCallDurations", "RealtimeCallEvents"});
        Descriptors.Descriptor r1 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 1);
        internal_static_com_obric_assistant_VoiceWakeupDuration_descriptor = r1;
        internal_static_com_obric_assistant_VoiceWakeupDuration_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r1, new String[]{"EventName", "EventReportSource", "TraceId", "StartTimestamp", "EndTimestamp", "WakeupStage1Duration", "WakeupStage2Duration", "WakeupStage3Duration", "Extra", "TraceViewers"});
        Descriptors.Descriptor r2 = (Descriptors.Descriptor) ListProtector.get(r1.getNestedTypes(), 0);
        internal_static_com_obric_assistant_VoiceWakeupDuration_ExtraEntry_descriptor = r2;
        internal_static_com_obric_assistant_VoiceWakeupDuration_ExtraEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r2, new String[]{"Key", "Value"});
        Descriptors.Descriptor r4 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 2);
        internal_static_com_obric_assistant_VoiceWakeupEvent_descriptor = r4;
        internal_static_com_obric_assistant_VoiceWakeupEvent_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r4, new String[]{"EventName", "EventReportSource", "TraceId", "Timestamp", "WakeupStage", "WakeupSuccess", "RejectReason", "Extra", "TraceViewers"});
        Descriptors.Descriptor r5 = (Descriptors.Descriptor) ListProtector.get(r4.getNestedTypes(), 0);
        internal_static_com_obric_assistant_VoiceWakeupEvent_ExtraEntry_descriptor = r5;
        internal_static_com_obric_assistant_VoiceWakeupEvent_ExtraEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r5, new String[]{"Key", "Value"});
        Descriptors.Descriptor r6 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 3);
        internal_static_com_obric_assistant_BreathWakeupDuration_descriptor = r6;
        internal_static_com_obric_assistant_BreathWakeupDuration_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r6, new String[]{"EventName", "EventReportSource", "TraceId", "StartTimestamp", "EndTimestamp", "WakeupStage1Duration", "WakeupStage2Duration", "WakeupStage3Duration", "Extra", "TraceViewers"});
        Descriptors.Descriptor r7 = (Descriptors.Descriptor) ListProtector.get(r6.getNestedTypes(), 0);
        internal_static_com_obric_assistant_BreathWakeupDuration_ExtraEntry_descriptor = r7;
        internal_static_com_obric_assistant_BreathWakeupDuration_ExtraEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r7, new String[]{"Key", "Value"});
        Descriptors.Descriptor r8 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 4);
        internal_static_com_obric_assistant_BreathWakeupEvent_descriptor = r8;
        internal_static_com_obric_assistant_BreathWakeupEvent_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r8, new String[]{"EventName", "EventReportSource", "TraceId", "Timestamp", "WakeupStage", "WakeupSuccess", "RejectReason", "Extra", "TraceViewers"});
        Descriptors.Descriptor r9 = (Descriptors.Descriptor) ListProtector.get(r8.getNestedTypes(), 0);
        internal_static_com_obric_assistant_BreathWakeupEvent_ExtraEntry_descriptor = r9;
        internal_static_com_obric_assistant_BreathWakeupEvent_ExtraEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r9, new String[]{"Key", "Value"});
        Descriptors.Descriptor r10 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 5);
        internal_static_com_obric_assistant_RealtimeCallDuration_descriptor = r10;
        internal_static_com_obric_assistant_RealtimeCallDuration_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r10, new String[]{"EventName", "EventReportSource", "TraceId", "StartTimestamp", "EndTimestamp", "Extra", "TraceViewers"});
        Descriptors.Descriptor r11 = (Descriptors.Descriptor) ListProtector.get(r10.getNestedTypes(), 0);
        internal_static_com_obric_assistant_RealtimeCallDuration_ExtraEntry_descriptor = r11;
        internal_static_com_obric_assistant_RealtimeCallDuration_ExtraEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r11, new String[]{"Key", "Value"});
        Descriptors.Descriptor r12 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 6);
        internal_static_com_obric_assistant_RealtimeCallEvent_descriptor = r12;
        internal_static_com_obric_assistant_RealtimeCallEvent_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r12, new String[]{"EventName", "EventReportSource", "TraceId", "Timestamp", "Extra", "TraceViewers"});
        Descriptors.Descriptor r13 = (Descriptors.Descriptor) ListProtector.get(r12.getNestedTypes(), 0);
        internal_static_com_obric_assistant_RealtimeCallEvent_ExtraEntry_descriptor = r13;
        internal_static_com_obric_assistant_RealtimeCallEvent_ExtraEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r13, new String[]{"Key", "Value"});
        Descriptors.Descriptor r14 = (Descriptors.Descriptor) ListProtector.get(getDescriptor().getMessageTypes(), 7);
        internal_static_com_obric_assistant_AssistAudioEventDataTraceViewer_descriptor = r14;
        internal_static_com_obric_assistant_AssistAudioEventDataTraceViewer_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(r14, new String[]{"TraceViewerType", "TraceViewerBizTag", "TraceViewerTrack", "TraceViewerVal", "TraceViewerStartTs", "TraceViewerEndTs", "TraceViewerEventTs", "TraceViewerExpansionKeyList"});
    }

    public static /* synthetic */ Descriptors.Descriptor access$000() {
        return internal_static_com_obric_assistant_AssistAudioEventData_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$100() {
        return internal_static_com_obric_assistant_AssistAudioEventData_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$10600() {
        return internal_static_com_obric_assistant_RealtimeCallDuration_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$10700() {
        return internal_static_com_obric_assistant_RealtimeCallDuration_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$10800() {
        return internal_static_com_obric_assistant_RealtimeCallDuration_ExtraEntry_descriptor;
    }

    public static /* synthetic */ Descriptors.Descriptor access$12500() {
        return internal_static_com_obric_assistant_RealtimeCallEvent_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$12600() {
        return internal_static_com_obric_assistant_RealtimeCallEvent_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$12700() {
        return internal_static_com_obric_assistant_RealtimeCallEvent_ExtraEntry_descriptor;
    }

    public static /* synthetic */ Descriptors.Descriptor access$14300() {
        return internal_static_com_obric_assistant_AssistAudioEventDataTraceViewer_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$14400() {
        return internal_static_com_obric_assistant_AssistAudioEventDataTraceViewer_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$2000() {
        return internal_static_com_obric_assistant_VoiceWakeupDuration_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$2100() {
        return internal_static_com_obric_assistant_VoiceWakeupDuration_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$2200() {
        return internal_static_com_obric_assistant_VoiceWakeupDuration_ExtraEntry_descriptor;
    }

    public static /* synthetic */ Descriptors.Descriptor access$4200() {
        return internal_static_com_obric_assistant_VoiceWakeupEvent_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$4300() {
        return internal_static_com_obric_assistant_VoiceWakeupEvent_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$4400() {
        return internal_static_com_obric_assistant_VoiceWakeupEvent_ExtraEntry_descriptor;
    }

    public static /* synthetic */ Descriptors.Descriptor access$6300() {
        return internal_static_com_obric_assistant_BreathWakeupDuration_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$6400() {
        return internal_static_com_obric_assistant_BreathWakeupDuration_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$6500() {
        return internal_static_com_obric_assistant_BreathWakeupDuration_ExtraEntry_descriptor;
    }

    public static /* synthetic */ Descriptors.Descriptor access$8500() {
        return internal_static_com_obric_assistant_BreathWakeupEvent_descriptor;
    }

    public static /* synthetic */ GeneratedMessageV3.FieldAccessorTable access$8600() {
        return internal_static_com_obric_assistant_BreathWakeupEvent_fieldAccessorTable;
    }

    public static /* synthetic */ Descriptors.Descriptor access$8700() {
        return internal_static_com_obric_assistant_BreathWakeupEvent_ExtraEntry_descriptor;
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    public static /* synthetic */ Descriptors.FileDescriptor access$16002(Descriptors.FileDescriptor r0) {
        descriptor = r0;
        return r0;
    }

    public static void registerAllExtensions(ExtensionRegistry r0) {
        registerAllExtensions(r0);
    }
}
