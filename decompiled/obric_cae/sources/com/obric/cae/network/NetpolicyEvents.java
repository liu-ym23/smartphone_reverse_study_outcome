package com.obric.cae.network;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.ttnet.org.chromium.net.NetError;
import defpackage.b;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class NetpolicyEvents extends GeneratedMessageV3 implements NetpolicyEventsOrBuilder {
    public static final int APPNETOPCHANGEDEVENTS_FIELD_NUMBER = 9;
    public static final int BLOCKEDREASONCHANGEDEVENTS_FIELD_NUMBER = 7;
    private static final NetpolicyEvents DEFAULT_INSTANCE = null;
    public static final int METEREDIFACESCHANGEDEVENTS_FIELD_NUMBER = 2;

    @Deprecated
    public static final Parser<NetpolicyEvents> PARSER = null;
    public static final int POWERSTATEEVENTS_FIELD_NUMBER = 8;
    public static final int RESTRICTBACKGROUNDCHANGEDEVENTS_FIELD_NUMBER = 3;
    public static final int SLEEPMODECHANGEDEVENTS_FIELD_NUMBER = 10;
    public static final int SUBSCRIPTIONOVERRIDECHANGEDEVENTS_FIELD_NUMBER = 5;
    public static final int SUBSCRIPTIONPLANSCHANGEDEVENTS_FIELD_NUMBER = 6;
    public static final int UIDPOLICIESCHANGEDEVENTS_FIELD_NUMBER = 4;
    public static final int UIDRULESCHANGEDEVENTS_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private List<AppNetOpChangedEvent> appNetOpChangedEvents_;
    private List<BlockedReasonChangedEvent> blockedReasonChangedEvents_;
    private byte memoizedIsInitialized;
    private List<MeteredIfacesChangedEvent> meteredIfacesChangedEvents_;
    private List<PowerStateEvent> powerStateEvents_;
    private List<RestrictBackgroundChangedEvent> restrictBackgroundChangedEvents_;
    private List<SleepModeChangedEvent> sleepModeChangedEvents_;
    private List<SubscriptionOverrideChangedEvent> subscriptionOverrideChangedEvents_;
    private List<SubscriptionPlansChangedEvent> subscriptionPlansChangedEvents_;
    private List<UidPoliciesChangedEvent> uidPoliciesChangedEvents_;
    private List<UidRulesChangedEvent> uidRulesChangedEvents_;

    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements NetpolicyEventsOrBuilder {
        private RepeatedFieldBuilderV3<AppNetOpChangedEvent, AppNetOpChangedEvent.Builder, AppNetOpChangedEventOrBuilder> appNetOpChangedEventsBuilder_;
        private List<AppNetOpChangedEvent> appNetOpChangedEvents_;
        private int bitField0_;
        private RepeatedFieldBuilderV3<BlockedReasonChangedEvent, BlockedReasonChangedEvent.Builder, BlockedReasonChangedEventOrBuilder> blockedReasonChangedEventsBuilder_;
        private List<BlockedReasonChangedEvent> blockedReasonChangedEvents_;
        private RepeatedFieldBuilderV3<MeteredIfacesChangedEvent, MeteredIfacesChangedEvent.Builder, MeteredIfacesChangedEventOrBuilder> meteredIfacesChangedEventsBuilder_;
        private List<MeteredIfacesChangedEvent> meteredIfacesChangedEvents_;
        private RepeatedFieldBuilderV3<PowerStateEvent, PowerStateEvent.Builder, PowerStateEventOrBuilder> powerStateEventsBuilder_;
        private List<PowerStateEvent> powerStateEvents_;
        private RepeatedFieldBuilderV3<RestrictBackgroundChangedEvent, RestrictBackgroundChangedEvent.Builder, RestrictBackgroundChangedEventOrBuilder> restrictBackgroundChangedEventsBuilder_;
        private List<RestrictBackgroundChangedEvent> restrictBackgroundChangedEvents_;
        private RepeatedFieldBuilderV3<SleepModeChangedEvent, SleepModeChangedEvent.Builder, SleepModeChangedEventOrBuilder> sleepModeChangedEventsBuilder_;
        private List<SleepModeChangedEvent> sleepModeChangedEvents_;
        private RepeatedFieldBuilderV3<SubscriptionOverrideChangedEvent, SubscriptionOverrideChangedEvent.Builder, SubscriptionOverrideChangedEventOrBuilder> subscriptionOverrideChangedEventsBuilder_;
        private List<SubscriptionOverrideChangedEvent> subscriptionOverrideChangedEvents_;
        private RepeatedFieldBuilderV3<SubscriptionPlansChangedEvent, SubscriptionPlansChangedEvent.Builder, SubscriptionPlansChangedEventOrBuilder> subscriptionPlansChangedEventsBuilder_;
        private List<SubscriptionPlansChangedEvent> subscriptionPlansChangedEvents_;
        private RepeatedFieldBuilderV3<UidPoliciesChangedEvent, UidPoliciesChangedEvent.Builder, UidPoliciesChangedEventOrBuilder> uidPoliciesChangedEventsBuilder_;
        private List<UidPoliciesChangedEvent> uidPoliciesChangedEvents_;
        private RepeatedFieldBuilderV3<UidRulesChangedEvent, UidRulesChangedEvent.Builder, UidRulesChangedEventOrBuilder> uidRulesChangedEventsBuilder_;
        private List<UidRulesChangedEvent> uidRulesChangedEvents_;

        private Builder() {
            this.uidRulesChangedEvents_ = Collections.emptyList();
            this.meteredIfacesChangedEvents_ = Collections.emptyList();
            this.restrictBackgroundChangedEvents_ = Collections.emptyList();
            this.uidPoliciesChangedEvents_ = Collections.emptyList();
            this.subscriptionOverrideChangedEvents_ = Collections.emptyList();
            this.subscriptionPlansChangedEvents_ = Collections.emptyList();
            this.blockedReasonChangedEvents_ = Collections.emptyList();
            this.powerStateEvents_ = Collections.emptyList();
            this.appNetOpChangedEvents_ = Collections.emptyList();
            this.sleepModeChangedEvents_ = Collections.emptyList();
        }

        private void buildPartial0(NetpolicyEvents r8) {
        }

        private void buildPartialRepeatedFields(NetpolicyEvents r8) {
            RepeatedFieldBuilderV3<UidRulesChangedEvent, UidRulesChangedEvent.Builder, UidRulesChangedEventOrBuilder> r10 = this.uidRulesChangedEventsBuilder_;
            if (r10 == null) goto L5;
            List r11 = r10.build();
        L9:
            NetpolicyEvents.access$302(r8, r11);
            RepeatedFieldBuilderV3<MeteredIfacesChangedEvent, MeteredIfacesChangedEvent.Builder, MeteredIfacesChangedEventOrBuilder> r12 = this.meteredIfacesChangedEventsBuilder_;
            if (r12 == null) goto L12;
            List r13 = r12.build();
        L16:
            NetpolicyEvents.access$402(r8, r13);
            RepeatedFieldBuilderV3<RestrictBackgroundChangedEvent, RestrictBackgroundChangedEvent.Builder, RestrictBackgroundChangedEventOrBuilder> r14 = this.restrictBackgroundChangedEventsBuilder_;
            if (r14 == null) goto L19;
            List r15 = r14.build();
        L23:
            NetpolicyEvents.access$502(r8, r15);
            RepeatedFieldBuilderV3<UidPoliciesChangedEvent, UidPoliciesChangedEvent.Builder, UidPoliciesChangedEventOrBuilder> r16 = this.uidPoliciesChangedEventsBuilder_;
            if (r16 == null) goto L26;
            List r17 = r16.build();
        L30:
            NetpolicyEvents.access$602(r8, r17);
            RepeatedFieldBuilderV3<SubscriptionOverrideChangedEvent, SubscriptionOverrideChangedEvent.Builder, SubscriptionOverrideChangedEventOrBuilder> r18 = this.subscriptionOverrideChangedEventsBuilder_;
            if (r18 == null) goto L33;
            List r19 = r18.build();
        L37:
            NetpolicyEvents.access$702(r8, r19);
            RepeatedFieldBuilderV3<SubscriptionPlansChangedEvent, SubscriptionPlansChangedEvent.Builder, SubscriptionPlansChangedEventOrBuilder> r20 = this.subscriptionPlansChangedEventsBuilder_;
            if (r20 == null) goto L40;
            List r21 = r20.build();
        L44:
            NetpolicyEvents.access$802(r8, r21);
            RepeatedFieldBuilderV3<BlockedReasonChangedEvent, BlockedReasonChangedEvent.Builder, BlockedReasonChangedEventOrBuilder> r22 = this.blockedReasonChangedEventsBuilder_;
            if (r22 == null) goto L47;
            List r23 = r22.build();
        L51:
            NetpolicyEvents.access$902(r8, r23);
            RepeatedFieldBuilderV3<PowerStateEvent, PowerStateEvent.Builder, PowerStateEventOrBuilder> r24 = this.powerStateEventsBuilder_;
            if (r24 == null) goto L54;
            List r25 = r24.build();
        L58:
            NetpolicyEvents.access$1002(r8, r25);
            RepeatedFieldBuilderV3<AppNetOpChangedEvent, AppNetOpChangedEvent.Builder, AppNetOpChangedEventOrBuilder> r26 = this.appNetOpChangedEventsBuilder_;
            if (r26 == null) goto L61;
            List r27 = r26.build();
        L65:
            NetpolicyEvents.access$1102(r8, r27);
            RepeatedFieldBuilderV3<SleepModeChangedEvent, SleepModeChangedEvent.Builder, SleepModeChangedEventOrBuilder> r28 = this.sleepModeChangedEventsBuilder_;
            if (r28 == null) goto L68;
            List r29 = r28.build();
        L72:
            NetpolicyEvents.access$1202(r8, r29);
            return;
        L68:
            if ((this.bitField0_ & 512) == 0) goto L70;
            this.sleepModeChangedEvents_ = Collections.unmodifiableList(this.sleepModeChangedEvents_);
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
        L70:
            r29 = this.sleepModeChangedEvents_;
            goto L72
        L61:
            if ((this.bitField0_ & 256) == 0) goto L63;
            this.appNetOpChangedEvents_ = Collections.unmodifiableList(this.appNetOpChangedEvents_);
            this.bitField0_ &= -257;
        L63:
            r27 = this.appNetOpChangedEvents_;
            goto L65
        L54:
            if ((this.bitField0_ & 128) == 0) goto L56;
            this.powerStateEvents_ = Collections.unmodifiableList(this.powerStateEvents_);
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
        L56:
            r25 = this.powerStateEvents_;
            goto L58
        L47:
            if ((this.bitField0_ & 64) == 0) goto L49;
            this.blockedReasonChangedEvents_ = Collections.unmodifiableList(this.blockedReasonChangedEvents_);
            this.bitField0_ &= -65;
        L49:
            r23 = this.blockedReasonChangedEvents_;
            goto L51
        L40:
            if ((this.bitField0_ & 32) == 0) goto L42;
            this.subscriptionPlansChangedEvents_ = Collections.unmodifiableList(this.subscriptionPlansChangedEvents_);
            this.bitField0_ &= -33;
        L42:
            r21 = this.subscriptionPlansChangedEvents_;
            goto L44
        L33:
            if ((this.bitField0_ & 16) == 0) goto L35;
            this.subscriptionOverrideChangedEvents_ = Collections.unmodifiableList(this.subscriptionOverrideChangedEvents_);
            this.bitField0_ &= -17;
        L35:
            r19 = this.subscriptionOverrideChangedEvents_;
            goto L37
        L26:
            if ((this.bitField0_ & 8) == 0) goto L28;
            this.uidPoliciesChangedEvents_ = Collections.unmodifiableList(this.uidPoliciesChangedEvents_);
            this.bitField0_ &= -9;
        L28:
            r17 = this.uidPoliciesChangedEvents_;
            goto L30
        L19:
            if ((this.bitField0_ & 4) == 0) goto L21;
            this.restrictBackgroundChangedEvents_ = Collections.unmodifiableList(this.restrictBackgroundChangedEvents_);
            this.bitField0_ &= -5;
        L21:
            r15 = this.restrictBackgroundChangedEvents_;
            goto L23
        L12:
            if ((this.bitField0_ & 2) == 0) goto L14;
            this.meteredIfacesChangedEvents_ = Collections.unmodifiableList(this.meteredIfacesChangedEvents_);
            this.bitField0_ &= -3;
        L14:
            r13 = this.meteredIfacesChangedEvents_;
            goto L16
        L5:
            if ((this.bitField0_ & 1) == 0) goto L7;
            this.uidRulesChangedEvents_ = Collections.unmodifiableList(this.uidRulesChangedEvents_);
            this.bitField0_ &= -2;
        L7:
            r11 = this.uidRulesChangedEvents_;
            goto L9
        }

        private void ensureAppNetOpChangedEventsIsMutable() {
            if ((this.bitField0_ & 256) != 0) goto L6;
            this.appNetOpChangedEvents_ = new ArrayList(this.appNetOpChangedEvents_);
            this.bitField0_ |= 256;
            return;
        }

        private void ensureBlockedReasonChangedEventsIsMutable() {
            if ((this.bitField0_ & 64) != 0) goto L6;
            this.blockedReasonChangedEvents_ = new ArrayList(this.blockedReasonChangedEvents_);
            this.bitField0_ |= 64;
            return;
        }

        private void ensureMeteredIfacesChangedEventsIsMutable() {
            if ((this.bitField0_ & 2) != 0) goto L6;
            this.meteredIfacesChangedEvents_ = new ArrayList(this.meteredIfacesChangedEvents_);
            this.bitField0_ |= 2;
            return;
        }

        private void ensurePowerStateEventsIsMutable() {
            if ((this.bitField0_ & 128) != 0) goto L6;
            this.powerStateEvents_ = new ArrayList(this.powerStateEvents_);
            this.bitField0_ |= 128;
            return;
        }

        private void ensureRestrictBackgroundChangedEventsIsMutable() {
            if ((this.bitField0_ & 4) != 0) goto L6;
            this.restrictBackgroundChangedEvents_ = new ArrayList(this.restrictBackgroundChangedEvents_);
            this.bitField0_ |= 4;
            return;
        }

        private void ensureSleepModeChangedEventsIsMutable() {
            if ((this.bitField0_ & 512) != 0) goto L6;
            this.sleepModeChangedEvents_ = new ArrayList(this.sleepModeChangedEvents_);
            this.bitField0_ |= 512;
            return;
        }

        private void ensureSubscriptionOverrideChangedEventsIsMutable() {
            if ((this.bitField0_ & 16) != 0) goto L6;
            this.subscriptionOverrideChangedEvents_ = new ArrayList(this.subscriptionOverrideChangedEvents_);
            this.bitField0_ |= 16;
            return;
        }

        private void ensureSubscriptionPlansChangedEventsIsMutable() {
            if ((this.bitField0_ & 32) != 0) goto L6;
            this.subscriptionPlansChangedEvents_ = new ArrayList(this.subscriptionPlansChangedEvents_);
            this.bitField0_ |= 32;
            return;
        }

        private void ensureUidPoliciesChangedEventsIsMutable() {
            if ((this.bitField0_ & 8) != 0) goto L6;
            this.uidPoliciesChangedEvents_ = new ArrayList(this.uidPoliciesChangedEvents_);
            this.bitField0_ |= 8;
            return;
        }

        private void ensureUidRulesChangedEventsIsMutable() {
            if ((this.bitField0_ & 1) != 0) goto L6;
            this.uidRulesChangedEvents_ = new ArrayList(this.uidRulesChangedEvents_);
            this.bitField0_ |= 1;
            return;
        }

        private RepeatedFieldBuilderV3<AppNetOpChangedEvent, AppNetOpChangedEvent.Builder, AppNetOpChangedEventOrBuilder> getAppNetOpChangedEventsFieldBuilder() {
            if (this.appNetOpChangedEventsBuilder_ != null) goto L10;
            List<AppNetOpChangedEvent> r8 = this.appNetOpChangedEvents_;
            if ((this.bitField0_ & 256) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.appNetOpChangedEventsBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.appNetOpChangedEvents_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.appNetOpChangedEventsBuilder_;
        }

        private RepeatedFieldBuilderV3<BlockedReasonChangedEvent, BlockedReasonChangedEvent.Builder, BlockedReasonChangedEventOrBuilder> getBlockedReasonChangedEventsFieldBuilder() {
            if (this.blockedReasonChangedEventsBuilder_ != null) goto L10;
            List<BlockedReasonChangedEvent> r8 = this.blockedReasonChangedEvents_;
            if ((this.bitField0_ & 64) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.blockedReasonChangedEventsBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.blockedReasonChangedEvents_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.blockedReasonChangedEventsBuilder_;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CaeNetpolicyEvent.internal_static_com_obric_cae_network_NetpolicyEvents_descriptor;
        }

        private RepeatedFieldBuilderV3<MeteredIfacesChangedEvent, MeteredIfacesChangedEvent.Builder, MeteredIfacesChangedEventOrBuilder> getMeteredIfacesChangedEventsFieldBuilder() {
            if (this.meteredIfacesChangedEventsBuilder_ != null) goto L10;
            List<MeteredIfacesChangedEvent> r8 = this.meteredIfacesChangedEvents_;
            if ((this.bitField0_ & 2) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.meteredIfacesChangedEventsBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.meteredIfacesChangedEvents_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.meteredIfacesChangedEventsBuilder_;
        }

        private RepeatedFieldBuilderV3<PowerStateEvent, PowerStateEvent.Builder, PowerStateEventOrBuilder> getPowerStateEventsFieldBuilder() {
            if (this.powerStateEventsBuilder_ != null) goto L10;
            List<PowerStateEvent> r8 = this.powerStateEvents_;
            if ((this.bitField0_ & 128) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.powerStateEventsBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.powerStateEvents_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.powerStateEventsBuilder_;
        }

        private RepeatedFieldBuilderV3<RestrictBackgroundChangedEvent, RestrictBackgroundChangedEvent.Builder, RestrictBackgroundChangedEventOrBuilder> getRestrictBackgroundChangedEventsFieldBuilder() {
            if (this.restrictBackgroundChangedEventsBuilder_ != null) goto L10;
            List<RestrictBackgroundChangedEvent> r8 = this.restrictBackgroundChangedEvents_;
            if ((this.bitField0_ & 4) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.restrictBackgroundChangedEventsBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.restrictBackgroundChangedEvents_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.restrictBackgroundChangedEventsBuilder_;
        }

        private RepeatedFieldBuilderV3<SleepModeChangedEvent, SleepModeChangedEvent.Builder, SleepModeChangedEventOrBuilder> getSleepModeChangedEventsFieldBuilder() {
            if (this.sleepModeChangedEventsBuilder_ != null) goto L10;
            List<SleepModeChangedEvent> r8 = this.sleepModeChangedEvents_;
            if ((this.bitField0_ & 512) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.sleepModeChangedEventsBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.sleepModeChangedEvents_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.sleepModeChangedEventsBuilder_;
        }

        private RepeatedFieldBuilderV3<SubscriptionOverrideChangedEvent, SubscriptionOverrideChangedEvent.Builder, SubscriptionOverrideChangedEventOrBuilder> getSubscriptionOverrideChangedEventsFieldBuilder() {
            if (this.subscriptionOverrideChangedEventsBuilder_ != null) goto L10;
            List<SubscriptionOverrideChangedEvent> r8 = this.subscriptionOverrideChangedEvents_;
            if ((this.bitField0_ & 16) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.subscriptionOverrideChangedEventsBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.subscriptionOverrideChangedEvents_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.subscriptionOverrideChangedEventsBuilder_;
        }

        private RepeatedFieldBuilderV3<SubscriptionPlansChangedEvent, SubscriptionPlansChangedEvent.Builder, SubscriptionPlansChangedEventOrBuilder> getSubscriptionPlansChangedEventsFieldBuilder() {
            if (this.subscriptionPlansChangedEventsBuilder_ != null) goto L10;
            List<SubscriptionPlansChangedEvent> r8 = this.subscriptionPlansChangedEvents_;
            if ((this.bitField0_ & 32) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.subscriptionPlansChangedEventsBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.subscriptionPlansChangedEvents_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.subscriptionPlansChangedEventsBuilder_;
        }

        private RepeatedFieldBuilderV3<UidPoliciesChangedEvent, UidPoliciesChangedEvent.Builder, UidPoliciesChangedEventOrBuilder> getUidPoliciesChangedEventsFieldBuilder() {
            if (this.uidPoliciesChangedEventsBuilder_ != null) goto L10;
            List<UidPoliciesChangedEvent> r8 = this.uidPoliciesChangedEvents_;
            if ((this.bitField0_ & 8) == 0) goto L7;
            boolean r10 = true;
        L8:
            this.uidPoliciesChangedEventsBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.uidPoliciesChangedEvents_ = null;
            goto L10
        L7:
            r10 = false;
        L10:
            return this.uidPoliciesChangedEventsBuilder_;
        }

        private RepeatedFieldBuilderV3<UidRulesChangedEvent, UidRulesChangedEvent.Builder, UidRulesChangedEventOrBuilder> getUidRulesChangedEventsFieldBuilder() {
            if (this.uidRulesChangedEventsBuilder_ != null) goto L10;
            List<UidRulesChangedEvent> r8 = this.uidRulesChangedEvents_;
            boolean r10 = true;
            if ((this.bitField0_ & 1) != 0) goto L8;
            r10 = false;
        L8:
            this.uidRulesChangedEventsBuilder_ = new RepeatedFieldBuilderV3(r8, r10, getParentForChildren(), isClean());
            this.uidRulesChangedEvents_ = null;
        L10:
            return this.uidRulesChangedEventsBuilder_;
        }

        public Builder addAllAppNetOpChangedEvents(Iterable<? extends AppNetOpChangedEvent> r8) {
            RepeatedFieldBuilderV3<AppNetOpChangedEvent, AppNetOpChangedEvent.Builder, AppNetOpChangedEventOrBuilder> r10 = this.appNetOpChangedEventsBuilder_;
            if (r10 != null) goto L5;
            ensureAppNetOpChangedEventsIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.appNetOpChangedEvents_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addAllBlockedReasonChangedEvents(Iterable<? extends BlockedReasonChangedEvent> r8) {
            RepeatedFieldBuilderV3<BlockedReasonChangedEvent, BlockedReasonChangedEvent.Builder, BlockedReasonChangedEventOrBuilder> r10 = this.blockedReasonChangedEventsBuilder_;
            if (r10 != null) goto L5;
            ensureBlockedReasonChangedEventsIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.blockedReasonChangedEvents_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addAllMeteredIfacesChangedEvents(Iterable<? extends MeteredIfacesChangedEvent> r8) {
            RepeatedFieldBuilderV3<MeteredIfacesChangedEvent, MeteredIfacesChangedEvent.Builder, MeteredIfacesChangedEventOrBuilder> r10 = this.meteredIfacesChangedEventsBuilder_;
            if (r10 != null) goto L5;
            ensureMeteredIfacesChangedEventsIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.meteredIfacesChangedEvents_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addAllPowerStateEvents(Iterable<? extends PowerStateEvent> r8) {
            RepeatedFieldBuilderV3<PowerStateEvent, PowerStateEvent.Builder, PowerStateEventOrBuilder> r10 = this.powerStateEventsBuilder_;
            if (r10 != null) goto L5;
            ensurePowerStateEventsIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.powerStateEvents_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addAllRestrictBackgroundChangedEvents(Iterable<? extends RestrictBackgroundChangedEvent> r8) {
            RepeatedFieldBuilderV3<RestrictBackgroundChangedEvent, RestrictBackgroundChangedEvent.Builder, RestrictBackgroundChangedEventOrBuilder> r10 = this.restrictBackgroundChangedEventsBuilder_;
            if (r10 != null) goto L5;
            ensureRestrictBackgroundChangedEventsIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.restrictBackgroundChangedEvents_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addAllSleepModeChangedEvents(Iterable<? extends SleepModeChangedEvent> r8) {
            RepeatedFieldBuilderV3<SleepModeChangedEvent, SleepModeChangedEvent.Builder, SleepModeChangedEventOrBuilder> r10 = this.sleepModeChangedEventsBuilder_;
            if (r10 != null) goto L5;
            ensureSleepModeChangedEventsIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.sleepModeChangedEvents_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addAllSubscriptionOverrideChangedEvents(Iterable<? extends SubscriptionOverrideChangedEvent> r8) {
            RepeatedFieldBuilderV3<SubscriptionOverrideChangedEvent, SubscriptionOverrideChangedEvent.Builder, SubscriptionOverrideChangedEventOrBuilder> r10 = this.subscriptionOverrideChangedEventsBuilder_;
            if (r10 != null) goto L5;
            ensureSubscriptionOverrideChangedEventsIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.subscriptionOverrideChangedEvents_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addAllSubscriptionPlansChangedEvents(Iterable<? extends SubscriptionPlansChangedEvent> r8) {
            RepeatedFieldBuilderV3<SubscriptionPlansChangedEvent, SubscriptionPlansChangedEvent.Builder, SubscriptionPlansChangedEventOrBuilder> r10 = this.subscriptionPlansChangedEventsBuilder_;
            if (r10 != null) goto L5;
            ensureSubscriptionPlansChangedEventsIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.subscriptionPlansChangedEvents_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addAllUidPoliciesChangedEvents(Iterable<? extends UidPoliciesChangedEvent> r8) {
            RepeatedFieldBuilderV3<UidPoliciesChangedEvent, UidPoliciesChangedEvent.Builder, UidPoliciesChangedEventOrBuilder> r10 = this.uidPoliciesChangedEventsBuilder_;
            if (r10 != null) goto L5;
            ensureUidPoliciesChangedEventsIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.uidPoliciesChangedEvents_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addAllUidRulesChangedEvents(Iterable<? extends UidRulesChangedEvent> r8) {
            RepeatedFieldBuilderV3<UidRulesChangedEvent, UidRulesChangedEvent.Builder, UidRulesChangedEventOrBuilder> r10 = this.uidRulesChangedEventsBuilder_;
            if (r10 != null) goto L5;
            ensureUidRulesChangedEventsIsMutable();
            AbstractMessageLite.Builder.addAll(r8, this.uidRulesChangedEvents_);
            onChanged();
        L6:
            return this;
        L5:
            r10.addAllMessages(r8);
            goto L6
        }

        public Builder addAppNetOpChangedEvents(int r8, AppNetOpChangedEvent.Builder r10) {
            RepeatedFieldBuilderV3<AppNetOpChangedEvent, AppNetOpChangedEvent.Builder, AppNetOpChangedEventOrBuilder> r11 = this.appNetOpChangedEventsBuilder_;
            if (r11 != null) goto L5;
            ensureAppNetOpChangedEventsIsMutable();
            this.appNetOpChangedEvents_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public AppNetOpChangedEvent.Builder addAppNetOpChangedEventsBuilder() {
            return (AppNetOpChangedEvent.Builder) getAppNetOpChangedEventsFieldBuilder().addBuilder(AppNetOpChangedEvent.getDefaultInstance());
        }

        public Builder addBlockedReasonChangedEvents(int r8, BlockedReasonChangedEvent.Builder r10) {
            RepeatedFieldBuilderV3<BlockedReasonChangedEvent, BlockedReasonChangedEvent.Builder, BlockedReasonChangedEventOrBuilder> r11 = this.blockedReasonChangedEventsBuilder_;
            if (r11 != null) goto L5;
            ensureBlockedReasonChangedEventsIsMutable();
            this.blockedReasonChangedEvents_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public BlockedReasonChangedEvent.Builder addBlockedReasonChangedEventsBuilder() {
            return (BlockedReasonChangedEvent.Builder) getBlockedReasonChangedEventsFieldBuilder().addBuilder(BlockedReasonChangedEvent.getDefaultInstance());
        }

        public Builder addMeteredIfacesChangedEvents(int r8, MeteredIfacesChangedEvent.Builder r10) {
            RepeatedFieldBuilderV3<MeteredIfacesChangedEvent, MeteredIfacesChangedEvent.Builder, MeteredIfacesChangedEventOrBuilder> r11 = this.meteredIfacesChangedEventsBuilder_;
            if (r11 != null) goto L5;
            ensureMeteredIfacesChangedEventsIsMutable();
            this.meteredIfacesChangedEvents_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public MeteredIfacesChangedEvent.Builder addMeteredIfacesChangedEventsBuilder() {
            return (MeteredIfacesChangedEvent.Builder) getMeteredIfacesChangedEventsFieldBuilder().addBuilder(MeteredIfacesChangedEvent.getDefaultInstance());
        }

        public Builder addPowerStateEvents(int r8, PowerStateEvent.Builder r10) {
            RepeatedFieldBuilderV3<PowerStateEvent, PowerStateEvent.Builder, PowerStateEventOrBuilder> r11 = this.powerStateEventsBuilder_;
            if (r11 != null) goto L5;
            ensurePowerStateEventsIsMutable();
            this.powerStateEvents_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public PowerStateEvent.Builder addPowerStateEventsBuilder() {
            return (PowerStateEvent.Builder) getPowerStateEventsFieldBuilder().addBuilder(PowerStateEvent.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        public Builder addRestrictBackgroundChangedEvents(int r8, RestrictBackgroundChangedEvent.Builder r10) {
            RepeatedFieldBuilderV3<RestrictBackgroundChangedEvent, RestrictBackgroundChangedEvent.Builder, RestrictBackgroundChangedEventOrBuilder> r11 = this.restrictBackgroundChangedEventsBuilder_;
            if (r11 != null) goto L5;
            ensureRestrictBackgroundChangedEventsIsMutable();
            this.restrictBackgroundChangedEvents_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public RestrictBackgroundChangedEvent.Builder addRestrictBackgroundChangedEventsBuilder() {
            return (RestrictBackgroundChangedEvent.Builder) getRestrictBackgroundChangedEventsFieldBuilder().addBuilder(RestrictBackgroundChangedEvent.getDefaultInstance());
        }

        public Builder addSleepModeChangedEvents(int r8, SleepModeChangedEvent.Builder r10) {
            RepeatedFieldBuilderV3<SleepModeChangedEvent, SleepModeChangedEvent.Builder, SleepModeChangedEventOrBuilder> r11 = this.sleepModeChangedEventsBuilder_;
            if (r11 != null) goto L5;
            ensureSleepModeChangedEventsIsMutable();
            this.sleepModeChangedEvents_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public SleepModeChangedEvent.Builder addSleepModeChangedEventsBuilder() {
            return (SleepModeChangedEvent.Builder) getSleepModeChangedEventsFieldBuilder().addBuilder(SleepModeChangedEvent.getDefaultInstance());
        }

        public Builder addSubscriptionOverrideChangedEvents(int r8, SubscriptionOverrideChangedEvent.Builder r10) {
            RepeatedFieldBuilderV3<SubscriptionOverrideChangedEvent, SubscriptionOverrideChangedEvent.Builder, SubscriptionOverrideChangedEventOrBuilder> r11 = this.subscriptionOverrideChangedEventsBuilder_;
            if (r11 != null) goto L5;
            ensureSubscriptionOverrideChangedEventsIsMutable();
            this.subscriptionOverrideChangedEvents_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public SubscriptionOverrideChangedEvent.Builder addSubscriptionOverrideChangedEventsBuilder() {
            return (SubscriptionOverrideChangedEvent.Builder) getSubscriptionOverrideChangedEventsFieldBuilder().addBuilder(SubscriptionOverrideChangedEvent.getDefaultInstance());
        }

        public Builder addSubscriptionPlansChangedEvents(int r8, SubscriptionPlansChangedEvent.Builder r10) {
            RepeatedFieldBuilderV3<SubscriptionPlansChangedEvent, SubscriptionPlansChangedEvent.Builder, SubscriptionPlansChangedEventOrBuilder> r11 = this.subscriptionPlansChangedEventsBuilder_;
            if (r11 != null) goto L5;
            ensureSubscriptionPlansChangedEventsIsMutable();
            this.subscriptionPlansChangedEvents_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public SubscriptionPlansChangedEvent.Builder addSubscriptionPlansChangedEventsBuilder() {
            return (SubscriptionPlansChangedEvent.Builder) getSubscriptionPlansChangedEventsFieldBuilder().addBuilder(SubscriptionPlansChangedEvent.getDefaultInstance());
        }

        public Builder addUidPoliciesChangedEvents(int r8, UidPoliciesChangedEvent.Builder r10) {
            RepeatedFieldBuilderV3<UidPoliciesChangedEvent, UidPoliciesChangedEvent.Builder, UidPoliciesChangedEventOrBuilder> r11 = this.uidPoliciesChangedEventsBuilder_;
            if (r11 != null) goto L5;
            ensureUidPoliciesChangedEventsIsMutable();
            this.uidPoliciesChangedEvents_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public UidPoliciesChangedEvent.Builder addUidPoliciesChangedEventsBuilder() {
            return (UidPoliciesChangedEvent.Builder) getUidPoliciesChangedEventsFieldBuilder().addBuilder(UidPoliciesChangedEvent.getDefaultInstance());
        }

        public Builder addUidRulesChangedEvents(int r8, UidRulesChangedEvent.Builder r10) {
            RepeatedFieldBuilderV3<UidRulesChangedEvent, UidRulesChangedEvent.Builder, UidRulesChangedEventOrBuilder> r11 = this.uidRulesChangedEventsBuilder_;
            if (r11 != null) goto L5;
            ensureUidRulesChangedEventsIsMutable();
            this.uidRulesChangedEvents_.add(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.addMessage(r8, r10.build());
            goto L6
        }

        public UidRulesChangedEvent.Builder addUidRulesChangedEventsBuilder() {
            return (UidRulesChangedEvent.Builder) getUidRulesChangedEventsFieldBuilder().addBuilder(UidRulesChangedEvent.getDefaultInstance());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clear() {
            return clear();
        }

        public Builder clearAppNetOpChangedEvents() {
            RepeatedFieldBuilderV3<AppNetOpChangedEvent, AppNetOpChangedEvent.Builder, AppNetOpChangedEventOrBuilder> r8 = this.appNetOpChangedEventsBuilder_;
            if (r8 != null) goto L5;
            this.appNetOpChangedEvents_ = Collections.emptyList();
            this.bitField0_ &= -257;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        public Builder clearBlockedReasonChangedEvents() {
            RepeatedFieldBuilderV3<BlockedReasonChangedEvent, BlockedReasonChangedEvent.Builder, BlockedReasonChangedEventOrBuilder> r8 = this.blockedReasonChangedEventsBuilder_;
            if (r8 != null) goto L5;
            this.blockedReasonChangedEvents_ = Collections.emptyList();
            this.bitField0_ &= -65;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        public Builder clearMeteredIfacesChangedEvents() {
            RepeatedFieldBuilderV3<MeteredIfacesChangedEvent, MeteredIfacesChangedEvent.Builder, MeteredIfacesChangedEventOrBuilder> r8 = this.meteredIfacesChangedEventsBuilder_;
            if (r8 != null) goto L5;
            this.meteredIfacesChangedEvents_ = Collections.emptyList();
            this.bitField0_ &= -3;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        public Builder clearPowerStateEvents() {
            RepeatedFieldBuilderV3<PowerStateEvent, PowerStateEvent.Builder, PowerStateEventOrBuilder> r8 = this.powerStateEventsBuilder_;
            if (r8 != null) goto L5;
            this.powerStateEvents_ = Collections.emptyList();
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        public Builder clearRestrictBackgroundChangedEvents() {
            RepeatedFieldBuilderV3<RestrictBackgroundChangedEvent, RestrictBackgroundChangedEvent.Builder, RestrictBackgroundChangedEventOrBuilder> r8 = this.restrictBackgroundChangedEventsBuilder_;
            if (r8 != null) goto L5;
            this.restrictBackgroundChangedEvents_ = Collections.emptyList();
            this.bitField0_ &= -5;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        public Builder clearSleepModeChangedEvents() {
            RepeatedFieldBuilderV3<SleepModeChangedEvent, SleepModeChangedEvent.Builder, SleepModeChangedEventOrBuilder> r8 = this.sleepModeChangedEventsBuilder_;
            if (r8 != null) goto L5;
            this.sleepModeChangedEvents_ = Collections.emptyList();
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        public Builder clearSubscriptionOverrideChangedEvents() {
            RepeatedFieldBuilderV3<SubscriptionOverrideChangedEvent, SubscriptionOverrideChangedEvent.Builder, SubscriptionOverrideChangedEventOrBuilder> r8 = this.subscriptionOverrideChangedEventsBuilder_;
            if (r8 != null) goto L5;
            this.subscriptionOverrideChangedEvents_ = Collections.emptyList();
            this.bitField0_ &= -17;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        public Builder clearSubscriptionPlansChangedEvents() {
            RepeatedFieldBuilderV3<SubscriptionPlansChangedEvent, SubscriptionPlansChangedEvent.Builder, SubscriptionPlansChangedEventOrBuilder> r8 = this.subscriptionPlansChangedEventsBuilder_;
            if (r8 != null) goto L5;
            this.subscriptionPlansChangedEvents_ = Collections.emptyList();
            this.bitField0_ &= -33;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        public Builder clearUidPoliciesChangedEvents() {
            RepeatedFieldBuilderV3<UidPoliciesChangedEvent, UidPoliciesChangedEvent.Builder, UidPoliciesChangedEventOrBuilder> r8 = this.uidPoliciesChangedEventsBuilder_;
            if (r8 != null) goto L5;
            this.uidPoliciesChangedEvents_ = Collections.emptyList();
            this.bitField0_ &= -9;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        public Builder clearUidRulesChangedEvents() {
            RepeatedFieldBuilderV3<UidRulesChangedEvent, UidRulesChangedEvent.Builder, UidRulesChangedEventOrBuilder> r8 = this.uidRulesChangedEventsBuilder_;
            if (r8 != null) goto L5;
            this.uidRulesChangedEvents_ = Collections.emptyList();
            this.bitField0_ &= -2;
            onChanged();
        L6:
            return this;
        L5:
            r8.clear();
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder clone() {
            return clone();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public AppNetOpChangedEvent getAppNetOpChangedEvents(int r8) {
            RepeatedFieldBuilderV3<AppNetOpChangedEvent, AppNetOpChangedEvent.Builder, AppNetOpChangedEventOrBuilder> r10 = this.appNetOpChangedEventsBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.appNetOpChangedEvents_.get(r8);
        L6:
            return (AppNetOpChangedEvent) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public AppNetOpChangedEvent.Builder getAppNetOpChangedEventsBuilder(int r8) {
            return (AppNetOpChangedEvent.Builder) getAppNetOpChangedEventsFieldBuilder().getBuilder(r8);
        }

        public List<AppNetOpChangedEvent.Builder> getAppNetOpChangedEventsBuilderList() {
            return getAppNetOpChangedEventsFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public int getAppNetOpChangedEventsCount() {
            RepeatedFieldBuilderV3<AppNetOpChangedEvent, AppNetOpChangedEvent.Builder, AppNetOpChangedEventOrBuilder> r8 = this.appNetOpChangedEventsBuilder_;
            if (r8 != null) goto L7;
            return this.appNetOpChangedEvents_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public List<AppNetOpChangedEvent> getAppNetOpChangedEventsList() {
            RepeatedFieldBuilderV3<AppNetOpChangedEvent, AppNetOpChangedEvent.Builder, AppNetOpChangedEventOrBuilder> r8 = this.appNetOpChangedEventsBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.appNetOpChangedEvents_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public AppNetOpChangedEventOrBuilder getAppNetOpChangedEventsOrBuilder(int r8) {
            RepeatedFieldBuilderV3<AppNetOpChangedEvent, AppNetOpChangedEvent.Builder, AppNetOpChangedEventOrBuilder> r10 = this.appNetOpChangedEventsBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.appNetOpChangedEvents_.get(r8);
        L6:
            return (AppNetOpChangedEventOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public List<? extends AppNetOpChangedEventOrBuilder> getAppNetOpChangedEventsOrBuilderList() {
            RepeatedFieldBuilderV3<AppNetOpChangedEvent, AppNetOpChangedEvent.Builder, AppNetOpChangedEventOrBuilder> r8 = this.appNetOpChangedEventsBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.appNetOpChangedEvents_);
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public BlockedReasonChangedEvent getBlockedReasonChangedEvents(int r8) {
            RepeatedFieldBuilderV3<BlockedReasonChangedEvent, BlockedReasonChangedEvent.Builder, BlockedReasonChangedEventOrBuilder> r10 = this.blockedReasonChangedEventsBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.blockedReasonChangedEvents_.get(r8);
        L6:
            return (BlockedReasonChangedEvent) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public BlockedReasonChangedEvent.Builder getBlockedReasonChangedEventsBuilder(int r8) {
            return (BlockedReasonChangedEvent.Builder) getBlockedReasonChangedEventsFieldBuilder().getBuilder(r8);
        }

        public List<BlockedReasonChangedEvent.Builder> getBlockedReasonChangedEventsBuilderList() {
            return getBlockedReasonChangedEventsFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public int getBlockedReasonChangedEventsCount() {
            RepeatedFieldBuilderV3<BlockedReasonChangedEvent, BlockedReasonChangedEvent.Builder, BlockedReasonChangedEventOrBuilder> r8 = this.blockedReasonChangedEventsBuilder_;
            if (r8 != null) goto L7;
            return this.blockedReasonChangedEvents_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public List<BlockedReasonChangedEvent> getBlockedReasonChangedEventsList() {
            RepeatedFieldBuilderV3<BlockedReasonChangedEvent, BlockedReasonChangedEvent.Builder, BlockedReasonChangedEventOrBuilder> r8 = this.blockedReasonChangedEventsBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.blockedReasonChangedEvents_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public BlockedReasonChangedEventOrBuilder getBlockedReasonChangedEventsOrBuilder(int r8) {
            RepeatedFieldBuilderV3<BlockedReasonChangedEvent, BlockedReasonChangedEvent.Builder, BlockedReasonChangedEventOrBuilder> r10 = this.blockedReasonChangedEventsBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.blockedReasonChangedEvents_.get(r8);
        L6:
            return (BlockedReasonChangedEventOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public List<? extends BlockedReasonChangedEventOrBuilder> getBlockedReasonChangedEventsOrBuilderList() {
            RepeatedFieldBuilderV3<BlockedReasonChangedEvent, BlockedReasonChangedEvent.Builder, BlockedReasonChangedEventOrBuilder> r8 = this.blockedReasonChangedEventsBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.blockedReasonChangedEvents_);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return CaeNetpolicyEvent.internal_static_com_obric_cae_network_NetpolicyEvents_descriptor;
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public MeteredIfacesChangedEvent getMeteredIfacesChangedEvents(int r8) {
            RepeatedFieldBuilderV3<MeteredIfacesChangedEvent, MeteredIfacesChangedEvent.Builder, MeteredIfacesChangedEventOrBuilder> r10 = this.meteredIfacesChangedEventsBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.meteredIfacesChangedEvents_.get(r8);
        L6:
            return (MeteredIfacesChangedEvent) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public MeteredIfacesChangedEvent.Builder getMeteredIfacesChangedEventsBuilder(int r8) {
            return (MeteredIfacesChangedEvent.Builder) getMeteredIfacesChangedEventsFieldBuilder().getBuilder(r8);
        }

        public List<MeteredIfacesChangedEvent.Builder> getMeteredIfacesChangedEventsBuilderList() {
            return getMeteredIfacesChangedEventsFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public int getMeteredIfacesChangedEventsCount() {
            RepeatedFieldBuilderV3<MeteredIfacesChangedEvent, MeteredIfacesChangedEvent.Builder, MeteredIfacesChangedEventOrBuilder> r8 = this.meteredIfacesChangedEventsBuilder_;
            if (r8 != null) goto L7;
            return this.meteredIfacesChangedEvents_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public List<MeteredIfacesChangedEvent> getMeteredIfacesChangedEventsList() {
            RepeatedFieldBuilderV3<MeteredIfacesChangedEvent, MeteredIfacesChangedEvent.Builder, MeteredIfacesChangedEventOrBuilder> r8 = this.meteredIfacesChangedEventsBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.meteredIfacesChangedEvents_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public MeteredIfacesChangedEventOrBuilder getMeteredIfacesChangedEventsOrBuilder(int r8) {
            RepeatedFieldBuilderV3<MeteredIfacesChangedEvent, MeteredIfacesChangedEvent.Builder, MeteredIfacesChangedEventOrBuilder> r10 = this.meteredIfacesChangedEventsBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.meteredIfacesChangedEvents_.get(r8);
        L6:
            return (MeteredIfacesChangedEventOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public List<? extends MeteredIfacesChangedEventOrBuilder> getMeteredIfacesChangedEventsOrBuilderList() {
            RepeatedFieldBuilderV3<MeteredIfacesChangedEvent, MeteredIfacesChangedEvent.Builder, MeteredIfacesChangedEventOrBuilder> r8 = this.meteredIfacesChangedEventsBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.meteredIfacesChangedEvents_);
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public PowerStateEvent getPowerStateEvents(int r8) {
            RepeatedFieldBuilderV3<PowerStateEvent, PowerStateEvent.Builder, PowerStateEventOrBuilder> r10 = this.powerStateEventsBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.powerStateEvents_.get(r8);
        L6:
            return (PowerStateEvent) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public PowerStateEvent.Builder getPowerStateEventsBuilder(int r8) {
            return (PowerStateEvent.Builder) getPowerStateEventsFieldBuilder().getBuilder(r8);
        }

        public List<PowerStateEvent.Builder> getPowerStateEventsBuilderList() {
            return getPowerStateEventsFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public int getPowerStateEventsCount() {
            RepeatedFieldBuilderV3<PowerStateEvent, PowerStateEvent.Builder, PowerStateEventOrBuilder> r8 = this.powerStateEventsBuilder_;
            if (r8 != null) goto L7;
            return this.powerStateEvents_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public List<PowerStateEvent> getPowerStateEventsList() {
            RepeatedFieldBuilderV3<PowerStateEvent, PowerStateEvent.Builder, PowerStateEventOrBuilder> r8 = this.powerStateEventsBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.powerStateEvents_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public PowerStateEventOrBuilder getPowerStateEventsOrBuilder(int r8) {
            RepeatedFieldBuilderV3<PowerStateEvent, PowerStateEvent.Builder, PowerStateEventOrBuilder> r10 = this.powerStateEventsBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.powerStateEvents_.get(r8);
        L6:
            return (PowerStateEventOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public List<? extends PowerStateEventOrBuilder> getPowerStateEventsOrBuilderList() {
            RepeatedFieldBuilderV3<PowerStateEvent, PowerStateEvent.Builder, PowerStateEventOrBuilder> r8 = this.powerStateEventsBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.powerStateEvents_);
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public RestrictBackgroundChangedEvent getRestrictBackgroundChangedEvents(int r8) {
            RepeatedFieldBuilderV3<RestrictBackgroundChangedEvent, RestrictBackgroundChangedEvent.Builder, RestrictBackgroundChangedEventOrBuilder> r10 = this.restrictBackgroundChangedEventsBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.restrictBackgroundChangedEvents_.get(r8);
        L6:
            return (RestrictBackgroundChangedEvent) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public RestrictBackgroundChangedEvent.Builder getRestrictBackgroundChangedEventsBuilder(int r8) {
            return (RestrictBackgroundChangedEvent.Builder) getRestrictBackgroundChangedEventsFieldBuilder().getBuilder(r8);
        }

        public List<RestrictBackgroundChangedEvent.Builder> getRestrictBackgroundChangedEventsBuilderList() {
            return getRestrictBackgroundChangedEventsFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public int getRestrictBackgroundChangedEventsCount() {
            RepeatedFieldBuilderV3<RestrictBackgroundChangedEvent, RestrictBackgroundChangedEvent.Builder, RestrictBackgroundChangedEventOrBuilder> r8 = this.restrictBackgroundChangedEventsBuilder_;
            if (r8 != null) goto L7;
            return this.restrictBackgroundChangedEvents_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public List<RestrictBackgroundChangedEvent> getRestrictBackgroundChangedEventsList() {
            RepeatedFieldBuilderV3<RestrictBackgroundChangedEvent, RestrictBackgroundChangedEvent.Builder, RestrictBackgroundChangedEventOrBuilder> r8 = this.restrictBackgroundChangedEventsBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.restrictBackgroundChangedEvents_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public RestrictBackgroundChangedEventOrBuilder getRestrictBackgroundChangedEventsOrBuilder(int r8) {
            RepeatedFieldBuilderV3<RestrictBackgroundChangedEvent, RestrictBackgroundChangedEvent.Builder, RestrictBackgroundChangedEventOrBuilder> r10 = this.restrictBackgroundChangedEventsBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.restrictBackgroundChangedEvents_.get(r8);
        L6:
            return (RestrictBackgroundChangedEventOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public List<? extends RestrictBackgroundChangedEventOrBuilder> getRestrictBackgroundChangedEventsOrBuilderList() {
            RepeatedFieldBuilderV3<RestrictBackgroundChangedEvent, RestrictBackgroundChangedEvent.Builder, RestrictBackgroundChangedEventOrBuilder> r8 = this.restrictBackgroundChangedEventsBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.restrictBackgroundChangedEvents_);
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public SleepModeChangedEvent getSleepModeChangedEvents(int r8) {
            RepeatedFieldBuilderV3<SleepModeChangedEvent, SleepModeChangedEvent.Builder, SleepModeChangedEventOrBuilder> r10 = this.sleepModeChangedEventsBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.sleepModeChangedEvents_.get(r8);
        L6:
            return (SleepModeChangedEvent) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public SleepModeChangedEvent.Builder getSleepModeChangedEventsBuilder(int r8) {
            return (SleepModeChangedEvent.Builder) getSleepModeChangedEventsFieldBuilder().getBuilder(r8);
        }

        public List<SleepModeChangedEvent.Builder> getSleepModeChangedEventsBuilderList() {
            return getSleepModeChangedEventsFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public int getSleepModeChangedEventsCount() {
            RepeatedFieldBuilderV3<SleepModeChangedEvent, SleepModeChangedEvent.Builder, SleepModeChangedEventOrBuilder> r8 = this.sleepModeChangedEventsBuilder_;
            if (r8 != null) goto L7;
            return this.sleepModeChangedEvents_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public List<SleepModeChangedEvent> getSleepModeChangedEventsList() {
            RepeatedFieldBuilderV3<SleepModeChangedEvent, SleepModeChangedEvent.Builder, SleepModeChangedEventOrBuilder> r8 = this.sleepModeChangedEventsBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.sleepModeChangedEvents_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public SleepModeChangedEventOrBuilder getSleepModeChangedEventsOrBuilder(int r8) {
            RepeatedFieldBuilderV3<SleepModeChangedEvent, SleepModeChangedEvent.Builder, SleepModeChangedEventOrBuilder> r10 = this.sleepModeChangedEventsBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.sleepModeChangedEvents_.get(r8);
        L6:
            return (SleepModeChangedEventOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public List<? extends SleepModeChangedEventOrBuilder> getSleepModeChangedEventsOrBuilderList() {
            RepeatedFieldBuilderV3<SleepModeChangedEvent, SleepModeChangedEvent.Builder, SleepModeChangedEventOrBuilder> r8 = this.sleepModeChangedEventsBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.sleepModeChangedEvents_);
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public SubscriptionOverrideChangedEvent getSubscriptionOverrideChangedEvents(int r8) {
            RepeatedFieldBuilderV3<SubscriptionOverrideChangedEvent, SubscriptionOverrideChangedEvent.Builder, SubscriptionOverrideChangedEventOrBuilder> r10 = this.subscriptionOverrideChangedEventsBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.subscriptionOverrideChangedEvents_.get(r8);
        L6:
            return (SubscriptionOverrideChangedEvent) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public SubscriptionOverrideChangedEvent.Builder getSubscriptionOverrideChangedEventsBuilder(int r8) {
            return (SubscriptionOverrideChangedEvent.Builder) getSubscriptionOverrideChangedEventsFieldBuilder().getBuilder(r8);
        }

        public List<SubscriptionOverrideChangedEvent.Builder> getSubscriptionOverrideChangedEventsBuilderList() {
            return getSubscriptionOverrideChangedEventsFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public int getSubscriptionOverrideChangedEventsCount() {
            RepeatedFieldBuilderV3<SubscriptionOverrideChangedEvent, SubscriptionOverrideChangedEvent.Builder, SubscriptionOverrideChangedEventOrBuilder> r8 = this.subscriptionOverrideChangedEventsBuilder_;
            if (r8 != null) goto L7;
            return this.subscriptionOverrideChangedEvents_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public List<SubscriptionOverrideChangedEvent> getSubscriptionOverrideChangedEventsList() {
            RepeatedFieldBuilderV3<SubscriptionOverrideChangedEvent, SubscriptionOverrideChangedEvent.Builder, SubscriptionOverrideChangedEventOrBuilder> r8 = this.subscriptionOverrideChangedEventsBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.subscriptionOverrideChangedEvents_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public SubscriptionOverrideChangedEventOrBuilder getSubscriptionOverrideChangedEventsOrBuilder(int r8) {
            RepeatedFieldBuilderV3<SubscriptionOverrideChangedEvent, SubscriptionOverrideChangedEvent.Builder, SubscriptionOverrideChangedEventOrBuilder> r10 = this.subscriptionOverrideChangedEventsBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.subscriptionOverrideChangedEvents_.get(r8);
        L6:
            return (SubscriptionOverrideChangedEventOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public List<? extends SubscriptionOverrideChangedEventOrBuilder> getSubscriptionOverrideChangedEventsOrBuilderList() {
            RepeatedFieldBuilderV3<SubscriptionOverrideChangedEvent, SubscriptionOverrideChangedEvent.Builder, SubscriptionOverrideChangedEventOrBuilder> r8 = this.subscriptionOverrideChangedEventsBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.subscriptionOverrideChangedEvents_);
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public SubscriptionPlansChangedEvent getSubscriptionPlansChangedEvents(int r8) {
            RepeatedFieldBuilderV3<SubscriptionPlansChangedEvent, SubscriptionPlansChangedEvent.Builder, SubscriptionPlansChangedEventOrBuilder> r10 = this.subscriptionPlansChangedEventsBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.subscriptionPlansChangedEvents_.get(r8);
        L6:
            return (SubscriptionPlansChangedEvent) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public SubscriptionPlansChangedEvent.Builder getSubscriptionPlansChangedEventsBuilder(int r8) {
            return (SubscriptionPlansChangedEvent.Builder) getSubscriptionPlansChangedEventsFieldBuilder().getBuilder(r8);
        }

        public List<SubscriptionPlansChangedEvent.Builder> getSubscriptionPlansChangedEventsBuilderList() {
            return getSubscriptionPlansChangedEventsFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public int getSubscriptionPlansChangedEventsCount() {
            RepeatedFieldBuilderV3<SubscriptionPlansChangedEvent, SubscriptionPlansChangedEvent.Builder, SubscriptionPlansChangedEventOrBuilder> r8 = this.subscriptionPlansChangedEventsBuilder_;
            if (r8 != null) goto L7;
            return this.subscriptionPlansChangedEvents_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public List<SubscriptionPlansChangedEvent> getSubscriptionPlansChangedEventsList() {
            RepeatedFieldBuilderV3<SubscriptionPlansChangedEvent, SubscriptionPlansChangedEvent.Builder, SubscriptionPlansChangedEventOrBuilder> r8 = this.subscriptionPlansChangedEventsBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.subscriptionPlansChangedEvents_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public SubscriptionPlansChangedEventOrBuilder getSubscriptionPlansChangedEventsOrBuilder(int r8) {
            RepeatedFieldBuilderV3<SubscriptionPlansChangedEvent, SubscriptionPlansChangedEvent.Builder, SubscriptionPlansChangedEventOrBuilder> r10 = this.subscriptionPlansChangedEventsBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.subscriptionPlansChangedEvents_.get(r8);
        L6:
            return (SubscriptionPlansChangedEventOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public List<? extends SubscriptionPlansChangedEventOrBuilder> getSubscriptionPlansChangedEventsOrBuilderList() {
            RepeatedFieldBuilderV3<SubscriptionPlansChangedEvent, SubscriptionPlansChangedEvent.Builder, SubscriptionPlansChangedEventOrBuilder> r8 = this.subscriptionPlansChangedEventsBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.subscriptionPlansChangedEvents_);
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public UidPoliciesChangedEvent getUidPoliciesChangedEvents(int r8) {
            RepeatedFieldBuilderV3<UidPoliciesChangedEvent, UidPoliciesChangedEvent.Builder, UidPoliciesChangedEventOrBuilder> r10 = this.uidPoliciesChangedEventsBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.uidPoliciesChangedEvents_.get(r8);
        L6:
            return (UidPoliciesChangedEvent) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public UidPoliciesChangedEvent.Builder getUidPoliciesChangedEventsBuilder(int r8) {
            return (UidPoliciesChangedEvent.Builder) getUidPoliciesChangedEventsFieldBuilder().getBuilder(r8);
        }

        public List<UidPoliciesChangedEvent.Builder> getUidPoliciesChangedEventsBuilderList() {
            return getUidPoliciesChangedEventsFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public int getUidPoliciesChangedEventsCount() {
            RepeatedFieldBuilderV3<UidPoliciesChangedEvent, UidPoliciesChangedEvent.Builder, UidPoliciesChangedEventOrBuilder> r8 = this.uidPoliciesChangedEventsBuilder_;
            if (r8 != null) goto L7;
            return this.uidPoliciesChangedEvents_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public List<UidPoliciesChangedEvent> getUidPoliciesChangedEventsList() {
            RepeatedFieldBuilderV3<UidPoliciesChangedEvent, UidPoliciesChangedEvent.Builder, UidPoliciesChangedEventOrBuilder> r8 = this.uidPoliciesChangedEventsBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.uidPoliciesChangedEvents_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public UidPoliciesChangedEventOrBuilder getUidPoliciesChangedEventsOrBuilder(int r8) {
            RepeatedFieldBuilderV3<UidPoliciesChangedEvent, UidPoliciesChangedEvent.Builder, UidPoliciesChangedEventOrBuilder> r10 = this.uidPoliciesChangedEventsBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.uidPoliciesChangedEvents_.get(r8);
        L6:
            return (UidPoliciesChangedEventOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public List<? extends UidPoliciesChangedEventOrBuilder> getUidPoliciesChangedEventsOrBuilderList() {
            RepeatedFieldBuilderV3<UidPoliciesChangedEvent, UidPoliciesChangedEvent.Builder, UidPoliciesChangedEventOrBuilder> r8 = this.uidPoliciesChangedEventsBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.uidPoliciesChangedEvents_);
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public UidRulesChangedEvent getUidRulesChangedEvents(int r8) {
            RepeatedFieldBuilderV3<UidRulesChangedEvent, UidRulesChangedEvent.Builder, UidRulesChangedEventOrBuilder> r10 = this.uidRulesChangedEventsBuilder_;
            if (r10 != null) goto L7;
            MessageLite r11 = this.uidRulesChangedEvents_.get(r8);
        L6:
            return (UidRulesChangedEvent) r11;
        L7:
            r11 = r10.getMessage(r8);
            goto L6
        }

        public UidRulesChangedEvent.Builder getUidRulesChangedEventsBuilder(int r8) {
            return (UidRulesChangedEvent.Builder) getUidRulesChangedEventsFieldBuilder().getBuilder(r8);
        }

        public List<UidRulesChangedEvent.Builder> getUidRulesChangedEventsBuilderList() {
            return getUidRulesChangedEventsFieldBuilder().getBuilderList();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public int getUidRulesChangedEventsCount() {
            RepeatedFieldBuilderV3<UidRulesChangedEvent, UidRulesChangedEvent.Builder, UidRulesChangedEventOrBuilder> r8 = this.uidRulesChangedEventsBuilder_;
            if (r8 != null) goto L7;
            return this.uidRulesChangedEvents_.size();
        L7:
            return r8.getCount();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public List<UidRulesChangedEvent> getUidRulesChangedEventsList() {
            RepeatedFieldBuilderV3<UidRulesChangedEvent, UidRulesChangedEvent.Builder, UidRulesChangedEventOrBuilder> r8 = this.uidRulesChangedEventsBuilder_;
            if (r8 != null) goto L7;
            return Collections.unmodifiableList(this.uidRulesChangedEvents_);
        L7:
            return r8.getMessageList();
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public UidRulesChangedEventOrBuilder getUidRulesChangedEventsOrBuilder(int r8) {
            RepeatedFieldBuilderV3<UidRulesChangedEvent, UidRulesChangedEvent.Builder, UidRulesChangedEventOrBuilder> r10 = this.uidRulesChangedEventsBuilder_;
            if (r10 != null) goto L7;
            Object r11 = this.uidRulesChangedEvents_.get(r8);
        L6:
            return (UidRulesChangedEventOrBuilder) r11;
        L7:
            r11 = r10.getMessageOrBuilder(r8);
            goto L6
        }

        @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
        public List<? extends UidRulesChangedEventOrBuilder> getUidRulesChangedEventsOrBuilderList() {
            RepeatedFieldBuilderV3<UidRulesChangedEvent, UidRulesChangedEvent.Builder, UidRulesChangedEventOrBuilder> r8 = this.uidRulesChangedEventsBuilder_;
            if (r8 == null) goto L7;
            return r8.getMessageOrBuilderList();
        L7:
            return Collections.unmodifiableList(this.uidRulesChangedEvents_);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return internalGetFieldAccessorTable();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            int r8 = 0;
        L4:
            if (r8 >= getUidRulesChangedEventsCount()) goto L9;
            if (getUidRulesChangedEvents(r8).isInitialized() == false) goto L7;
            r8 = r8 + 1;
            goto L4
        L7:
            return false;
        L9:
            int r10 = 0;
        L11:
            if (r10 >= getRestrictBackgroundChangedEventsCount()) goto L16;
            if (getRestrictBackgroundChangedEvents(r10).isInitialized() == false) goto L14;
            r10 = r10 + 1;
            goto L11
        L14:
            return false;
        L16:
            int r11 = 0;
        L18:
            if (r11 >= getUidPoliciesChangedEventsCount()) goto L23;
            if (getUidPoliciesChangedEvents(r11).isInitialized() == false) goto L21;
            r11 = r11 + 1;
            goto L18
        L21:
            return false;
        L23:
            int r12 = 0;
        L25:
            if (r12 >= getSubscriptionOverrideChangedEventsCount()) goto L30;
            if (getSubscriptionOverrideChangedEvents(r12).isInitialized() == false) goto L28;
            r12 = r12 + 1;
            goto L25
        L28:
            return false;
        L30:
            int r13 = 0;
        L32:
            if (r13 >= getSubscriptionPlansChangedEventsCount()) goto L37;
            if (getSubscriptionPlansChangedEvents(r13).isInitialized() == false) goto L35;
            r13 = r13 + 1;
            goto L32
        L35:
            return false;
        L37:
            int r14 = 0;
        L39:
            if (r14 >= getBlockedReasonChangedEventsCount()) goto L44;
            if (getBlockedReasonChangedEvents(r14).isInitialized() == false) goto L42;
            r14 = r14 + 1;
            goto L39
        L42:
            return false;
        L44:
            int r15 = 0;
        L46:
            if (r15 >= getPowerStateEventsCount()) goto L51;
            if (getPowerStateEvents(r15).isInitialized() == false) goto L49;
            r15 = r15 + 1;
            goto L46
        L49:
            return false;
        L51:
            int r16 = 0;
        L53:
            if (r16 >= getAppNetOpChangedEventsCount()) goto L58;
            if (getAppNetOpChangedEvents(r16).isInitialized() == false) goto L56;
            r16 = r16 + 1;
            goto L53
        L56:
            return false;
        L58:
            int r17 = 0;
        L60:
            if (r17 >= getSleepModeChangedEventsCount()) goto L65;
            if (getSleepModeChangedEvents(r17).isInitialized() == false) goto L63;
            r17 = r17 + 1;
            goto L60
        L63:
            return false;
        L65:
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        public Builder removeAppNetOpChangedEvents(int r8) {
            RepeatedFieldBuilderV3<AppNetOpChangedEvent, AppNetOpChangedEvent.Builder, AppNetOpChangedEventOrBuilder> r10 = this.appNetOpChangedEventsBuilder_;
            if (r10 != null) goto L5;
            ensureAppNetOpChangedEventsIsMutable();
            this.appNetOpChangedEvents_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder removeBlockedReasonChangedEvents(int r8) {
            RepeatedFieldBuilderV3<BlockedReasonChangedEvent, BlockedReasonChangedEvent.Builder, BlockedReasonChangedEventOrBuilder> r10 = this.blockedReasonChangedEventsBuilder_;
            if (r10 != null) goto L5;
            ensureBlockedReasonChangedEventsIsMutable();
            this.blockedReasonChangedEvents_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder removeMeteredIfacesChangedEvents(int r8) {
            RepeatedFieldBuilderV3<MeteredIfacesChangedEvent, MeteredIfacesChangedEvent.Builder, MeteredIfacesChangedEventOrBuilder> r10 = this.meteredIfacesChangedEventsBuilder_;
            if (r10 != null) goto L5;
            ensureMeteredIfacesChangedEventsIsMutable();
            this.meteredIfacesChangedEvents_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder removePowerStateEvents(int r8) {
            RepeatedFieldBuilderV3<PowerStateEvent, PowerStateEvent.Builder, PowerStateEventOrBuilder> r10 = this.powerStateEventsBuilder_;
            if (r10 != null) goto L5;
            ensurePowerStateEventsIsMutable();
            this.powerStateEvents_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder removeRestrictBackgroundChangedEvents(int r8) {
            RepeatedFieldBuilderV3<RestrictBackgroundChangedEvent, RestrictBackgroundChangedEvent.Builder, RestrictBackgroundChangedEventOrBuilder> r10 = this.restrictBackgroundChangedEventsBuilder_;
            if (r10 != null) goto L5;
            ensureRestrictBackgroundChangedEventsIsMutable();
            this.restrictBackgroundChangedEvents_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder removeSleepModeChangedEvents(int r8) {
            RepeatedFieldBuilderV3<SleepModeChangedEvent, SleepModeChangedEvent.Builder, SleepModeChangedEventOrBuilder> r10 = this.sleepModeChangedEventsBuilder_;
            if (r10 != null) goto L5;
            ensureSleepModeChangedEventsIsMutable();
            this.sleepModeChangedEvents_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder removeSubscriptionOverrideChangedEvents(int r8) {
            RepeatedFieldBuilderV3<SubscriptionOverrideChangedEvent, SubscriptionOverrideChangedEvent.Builder, SubscriptionOverrideChangedEventOrBuilder> r10 = this.subscriptionOverrideChangedEventsBuilder_;
            if (r10 != null) goto L5;
            ensureSubscriptionOverrideChangedEventsIsMutable();
            this.subscriptionOverrideChangedEvents_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder removeSubscriptionPlansChangedEvents(int r8) {
            RepeatedFieldBuilderV3<SubscriptionPlansChangedEvent, SubscriptionPlansChangedEvent.Builder, SubscriptionPlansChangedEventOrBuilder> r10 = this.subscriptionPlansChangedEventsBuilder_;
            if (r10 != null) goto L5;
            ensureSubscriptionPlansChangedEventsIsMutable();
            this.subscriptionPlansChangedEvents_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder removeUidPoliciesChangedEvents(int r8) {
            RepeatedFieldBuilderV3<UidPoliciesChangedEvent, UidPoliciesChangedEvent.Builder, UidPoliciesChangedEventOrBuilder> r10 = this.uidPoliciesChangedEventsBuilder_;
            if (r10 != null) goto L5;
            ensureUidPoliciesChangedEventsIsMutable();
            this.uidPoliciesChangedEvents_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder removeUidRulesChangedEvents(int r8) {
            RepeatedFieldBuilderV3<UidRulesChangedEvent, UidRulesChangedEvent.Builder, UidRulesChangedEventOrBuilder> r10 = this.uidRulesChangedEventsBuilder_;
            if (r10 != null) goto L5;
            ensureUidRulesChangedEventsIsMutable();
            this.uidRulesChangedEvents_.remove(r8);
            onChanged();
        L6:
            return this;
        L5:
            r10.remove(r8);
            goto L6
        }

        public Builder setAppNetOpChangedEvents(int r8, AppNetOpChangedEvent.Builder r10) {
            RepeatedFieldBuilderV3<AppNetOpChangedEvent, AppNetOpChangedEvent.Builder, AppNetOpChangedEventOrBuilder> r11 = this.appNetOpChangedEventsBuilder_;
            if (r11 != null) goto L5;
            ensureAppNetOpChangedEventsIsMutable();
            this.appNetOpChangedEvents_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        public Builder setBlockedReasonChangedEvents(int r8, BlockedReasonChangedEvent.Builder r10) {
            RepeatedFieldBuilderV3<BlockedReasonChangedEvent, BlockedReasonChangedEvent.Builder, BlockedReasonChangedEventOrBuilder> r11 = this.blockedReasonChangedEventsBuilder_;
            if (r11 != null) goto L5;
            ensureBlockedReasonChangedEventsIsMutable();
            this.blockedReasonChangedEvents_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setMeteredIfacesChangedEvents(int r8, MeteredIfacesChangedEvent.Builder r10) {
            RepeatedFieldBuilderV3<MeteredIfacesChangedEvent, MeteredIfacesChangedEvent.Builder, MeteredIfacesChangedEventOrBuilder> r11 = this.meteredIfacesChangedEventsBuilder_;
            if (r11 != null) goto L5;
            ensureMeteredIfacesChangedEventsIsMutable();
            this.meteredIfacesChangedEvents_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        public Builder setPowerStateEvents(int r8, PowerStateEvent.Builder r10) {
            RepeatedFieldBuilderV3<PowerStateEvent, PowerStateEvent.Builder, PowerStateEventOrBuilder> r11 = this.powerStateEventsBuilder_;
            if (r11 != null) goto L5;
            ensurePowerStateEventsIsMutable();
            this.powerStateEvents_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setRestrictBackgroundChangedEvents(int r8, RestrictBackgroundChangedEvent.Builder r10) {
            RepeatedFieldBuilderV3<RestrictBackgroundChangedEvent, RestrictBackgroundChangedEvent.Builder, RestrictBackgroundChangedEventOrBuilder> r11 = this.restrictBackgroundChangedEventsBuilder_;
            if (r11 != null) goto L5;
            ensureRestrictBackgroundChangedEventsIsMutable();
            this.restrictBackgroundChangedEvents_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        public Builder setSleepModeChangedEvents(int r8, SleepModeChangedEvent.Builder r10) {
            RepeatedFieldBuilderV3<SleepModeChangedEvent, SleepModeChangedEvent.Builder, SleepModeChangedEventOrBuilder> r11 = this.sleepModeChangedEventsBuilder_;
            if (r11 != null) goto L5;
            ensureSleepModeChangedEventsIsMutable();
            this.sleepModeChangedEvents_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        public Builder setSubscriptionOverrideChangedEvents(int r8, SubscriptionOverrideChangedEvent.Builder r10) {
            RepeatedFieldBuilderV3<SubscriptionOverrideChangedEvent, SubscriptionOverrideChangedEvent.Builder, SubscriptionOverrideChangedEventOrBuilder> r11 = this.subscriptionOverrideChangedEventsBuilder_;
            if (r11 != null) goto L5;
            ensureSubscriptionOverrideChangedEventsIsMutable();
            this.subscriptionOverrideChangedEvents_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        public Builder setSubscriptionPlansChangedEvents(int r8, SubscriptionPlansChangedEvent.Builder r10) {
            RepeatedFieldBuilderV3<SubscriptionPlansChangedEvent, SubscriptionPlansChangedEvent.Builder, SubscriptionPlansChangedEventOrBuilder> r11 = this.subscriptionPlansChangedEventsBuilder_;
            if (r11 != null) goto L5;
            ensureSubscriptionPlansChangedEventsIsMutable();
            this.subscriptionPlansChangedEvents_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        public Builder setUidPoliciesChangedEvents(int r8, UidPoliciesChangedEvent.Builder r10) {
            RepeatedFieldBuilderV3<UidPoliciesChangedEvent, UidPoliciesChangedEvent.Builder, UidPoliciesChangedEventOrBuilder> r11 = this.uidPoliciesChangedEventsBuilder_;
            if (r11 != null) goto L5;
            ensureUidPoliciesChangedEventsIsMutable();
            this.uidPoliciesChangedEvents_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        public Builder setUidRulesChangedEvents(int r8, UidRulesChangedEvent.Builder r10) {
            RepeatedFieldBuilderV3<UidRulesChangedEvent, UidRulesChangedEvent.Builder, UidRulesChangedEventOrBuilder> r11 = this.uidRulesChangedEventsBuilder_;
            if (r11 != null) goto L5;
            ensureUidRulesChangedEventsIsMutable();
            this.uidRulesChangedEvents_.set(r8, r10.build());
            onChanged();
        L6:
            return this;
        L5:
            r11.setMessage(r8, r10.build());
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        private Builder(GeneratedMessageV3.BuilderParent r8) {
            super(r8);
            this.uidRulesChangedEvents_ = Collections.emptyList();
            this.meteredIfacesChangedEvents_ = Collections.emptyList();
            this.restrictBackgroundChangedEvents_ = Collections.emptyList();
            this.uidPoliciesChangedEvents_ = Collections.emptyList();
            this.subscriptionOverrideChangedEvents_ = Collections.emptyList();
            this.subscriptionPlansChangedEvents_ = Collections.emptyList();
            this.blockedReasonChangedEvents_ = Collections.emptyList();
            this.powerStateEvents_ = Collections.emptyList();
            this.appNetOpChangedEvents_ = Collections.emptyList();
            this.sleepModeChangedEvents_ = Collections.emptyList();
        }

        public Builder addAppNetOpChangedEvents(int r8, AppNetOpChangedEvent r10) {
            RepeatedFieldBuilderV3<AppNetOpChangedEvent, AppNetOpChangedEvent.Builder, AppNetOpChangedEventOrBuilder> r11 = this.appNetOpChangedEventsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureAppNetOpChangedEventsIsMutable();
            this.appNetOpChangedEvents_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public AppNetOpChangedEvent.Builder addAppNetOpChangedEventsBuilder(int r8) {
            return (AppNetOpChangedEvent.Builder) getAppNetOpChangedEventsFieldBuilder().addBuilder(r8, AppNetOpChangedEvent.getDefaultInstance());
        }

        public Builder addBlockedReasonChangedEvents(int r8, BlockedReasonChangedEvent r10) {
            RepeatedFieldBuilderV3<BlockedReasonChangedEvent, BlockedReasonChangedEvent.Builder, BlockedReasonChangedEventOrBuilder> r11 = this.blockedReasonChangedEventsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureBlockedReasonChangedEventsIsMutable();
            this.blockedReasonChangedEvents_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public BlockedReasonChangedEvent.Builder addBlockedReasonChangedEventsBuilder(int r8) {
            return (BlockedReasonChangedEvent.Builder) getBlockedReasonChangedEventsFieldBuilder().addBuilder(r8, BlockedReasonChangedEvent.getDefaultInstance());
        }

        public Builder addMeteredIfacesChangedEvents(int r8, MeteredIfacesChangedEvent r10) {
            RepeatedFieldBuilderV3<MeteredIfacesChangedEvent, MeteredIfacesChangedEvent.Builder, MeteredIfacesChangedEventOrBuilder> r11 = this.meteredIfacesChangedEventsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureMeteredIfacesChangedEventsIsMutable();
            this.meteredIfacesChangedEvents_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public MeteredIfacesChangedEvent.Builder addMeteredIfacesChangedEventsBuilder(int r8) {
            return (MeteredIfacesChangedEvent.Builder) getMeteredIfacesChangedEventsFieldBuilder().addBuilder(r8, MeteredIfacesChangedEvent.getDefaultInstance());
        }

        public Builder addPowerStateEvents(int r8, PowerStateEvent r10) {
            RepeatedFieldBuilderV3<PowerStateEvent, PowerStateEvent.Builder, PowerStateEventOrBuilder> r11 = this.powerStateEventsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensurePowerStateEventsIsMutable();
            this.powerStateEvents_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public PowerStateEvent.Builder addPowerStateEventsBuilder(int r8) {
            return (PowerStateEvent.Builder) getPowerStateEventsFieldBuilder().addBuilder(r8, PowerStateEvent.getDefaultInstance());
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        public Builder addRestrictBackgroundChangedEvents(int r8, RestrictBackgroundChangedEvent r10) {
            RepeatedFieldBuilderV3<RestrictBackgroundChangedEvent, RestrictBackgroundChangedEvent.Builder, RestrictBackgroundChangedEventOrBuilder> r11 = this.restrictBackgroundChangedEventsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureRestrictBackgroundChangedEventsIsMutable();
            this.restrictBackgroundChangedEvents_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public RestrictBackgroundChangedEvent.Builder addRestrictBackgroundChangedEventsBuilder(int r8) {
            return (RestrictBackgroundChangedEvent.Builder) getRestrictBackgroundChangedEventsFieldBuilder().addBuilder(r8, RestrictBackgroundChangedEvent.getDefaultInstance());
        }

        public Builder addSleepModeChangedEvents(int r8, SleepModeChangedEvent r10) {
            RepeatedFieldBuilderV3<SleepModeChangedEvent, SleepModeChangedEvent.Builder, SleepModeChangedEventOrBuilder> r11 = this.sleepModeChangedEventsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureSleepModeChangedEventsIsMutable();
            this.sleepModeChangedEvents_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public SleepModeChangedEvent.Builder addSleepModeChangedEventsBuilder(int r8) {
            return (SleepModeChangedEvent.Builder) getSleepModeChangedEventsFieldBuilder().addBuilder(r8, SleepModeChangedEvent.getDefaultInstance());
        }

        public Builder addSubscriptionOverrideChangedEvents(int r8, SubscriptionOverrideChangedEvent r10) {
            RepeatedFieldBuilderV3<SubscriptionOverrideChangedEvent, SubscriptionOverrideChangedEvent.Builder, SubscriptionOverrideChangedEventOrBuilder> r11 = this.subscriptionOverrideChangedEventsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureSubscriptionOverrideChangedEventsIsMutable();
            this.subscriptionOverrideChangedEvents_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public SubscriptionOverrideChangedEvent.Builder addSubscriptionOverrideChangedEventsBuilder(int r8) {
            return (SubscriptionOverrideChangedEvent.Builder) getSubscriptionOverrideChangedEventsFieldBuilder().addBuilder(r8, SubscriptionOverrideChangedEvent.getDefaultInstance());
        }

        public Builder addSubscriptionPlansChangedEvents(int r8, SubscriptionPlansChangedEvent r10) {
            RepeatedFieldBuilderV3<SubscriptionPlansChangedEvent, SubscriptionPlansChangedEvent.Builder, SubscriptionPlansChangedEventOrBuilder> r11 = this.subscriptionPlansChangedEventsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureSubscriptionPlansChangedEventsIsMutable();
            this.subscriptionPlansChangedEvents_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public SubscriptionPlansChangedEvent.Builder addSubscriptionPlansChangedEventsBuilder(int r8) {
            return (SubscriptionPlansChangedEvent.Builder) getSubscriptionPlansChangedEventsFieldBuilder().addBuilder(r8, SubscriptionPlansChangedEvent.getDefaultInstance());
        }

        public Builder addUidPoliciesChangedEvents(int r8, UidPoliciesChangedEvent r10) {
            RepeatedFieldBuilderV3<UidPoliciesChangedEvent, UidPoliciesChangedEvent.Builder, UidPoliciesChangedEventOrBuilder> r11 = this.uidPoliciesChangedEventsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureUidPoliciesChangedEventsIsMutable();
            this.uidPoliciesChangedEvents_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public UidPoliciesChangedEvent.Builder addUidPoliciesChangedEventsBuilder(int r8) {
            return (UidPoliciesChangedEvent.Builder) getUidPoliciesChangedEventsFieldBuilder().addBuilder(r8, UidPoliciesChangedEvent.getDefaultInstance());
        }

        public Builder addUidRulesChangedEvents(int r8, UidRulesChangedEvent r10) {
            RepeatedFieldBuilderV3<UidRulesChangedEvent, UidRulesChangedEvent.Builder, UidRulesChangedEventOrBuilder> r11 = this.uidRulesChangedEventsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureUidRulesChangedEventsIsMutable();
            this.uidRulesChangedEvents_.add(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.addMessage(r8, r10);
            goto L9
        }

        public UidRulesChangedEvent.Builder addUidRulesChangedEventsBuilder(int r8) {
            return (UidRulesChangedEvent.Builder) getUidRulesChangedEventsFieldBuilder().addBuilder(r8, UidRulesChangedEvent.getDefaultInstance());
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite build() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return buildPartial();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CaeNetpolicyEvent.internal_static_com_obric_cae_network_NetpolicyEvents_fieldAccessorTable.ensureFieldAccessorsInitialized(NetpolicyEvents.class, Builder.class);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessage.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        public Builder setAppNetOpChangedEvents(int r8, AppNetOpChangedEvent r10) {
            RepeatedFieldBuilderV3<AppNetOpChangedEvent, AppNetOpChangedEvent.Builder, AppNetOpChangedEventOrBuilder> r11 = this.appNetOpChangedEventsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureAppNetOpChangedEventsIsMutable();
            this.appNetOpChangedEvents_.set(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r8, r10);
            goto L9
        }

        public Builder setBlockedReasonChangedEvents(int r8, BlockedReasonChangedEvent r10) {
            RepeatedFieldBuilderV3<BlockedReasonChangedEvent, BlockedReasonChangedEvent.Builder, BlockedReasonChangedEventOrBuilder> r11 = this.blockedReasonChangedEventsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureBlockedReasonChangedEventsIsMutable();
            this.blockedReasonChangedEvents_.set(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r8, r10);
            goto L9
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        public Builder setMeteredIfacesChangedEvents(int r8, MeteredIfacesChangedEvent r10) {
            RepeatedFieldBuilderV3<MeteredIfacesChangedEvent, MeteredIfacesChangedEvent.Builder, MeteredIfacesChangedEventOrBuilder> r11 = this.meteredIfacesChangedEventsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureMeteredIfacesChangedEventsIsMutable();
            this.meteredIfacesChangedEvents_.set(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r8, r10);
            goto L9
        }

        public Builder setPowerStateEvents(int r8, PowerStateEvent r10) {
            RepeatedFieldBuilderV3<PowerStateEvent, PowerStateEvent.Builder, PowerStateEventOrBuilder> r11 = this.powerStateEventsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensurePowerStateEventsIsMutable();
            this.powerStateEvents_.set(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r8, r10);
            goto L9
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        public Builder setRestrictBackgroundChangedEvents(int r8, RestrictBackgroundChangedEvent r10) {
            RepeatedFieldBuilderV3<RestrictBackgroundChangedEvent, RestrictBackgroundChangedEvent.Builder, RestrictBackgroundChangedEventOrBuilder> r11 = this.restrictBackgroundChangedEventsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureRestrictBackgroundChangedEventsIsMutable();
            this.restrictBackgroundChangedEvents_.set(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r8, r10);
            goto L9
        }

        public Builder setSleepModeChangedEvents(int r8, SleepModeChangedEvent r10) {
            RepeatedFieldBuilderV3<SleepModeChangedEvent, SleepModeChangedEvent.Builder, SleepModeChangedEventOrBuilder> r11 = this.sleepModeChangedEventsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureSleepModeChangedEventsIsMutable();
            this.sleepModeChangedEvents_.set(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r8, r10);
            goto L9
        }

        public Builder setSubscriptionOverrideChangedEvents(int r8, SubscriptionOverrideChangedEvent r10) {
            RepeatedFieldBuilderV3<SubscriptionOverrideChangedEvent, SubscriptionOverrideChangedEvent.Builder, SubscriptionOverrideChangedEventOrBuilder> r11 = this.subscriptionOverrideChangedEventsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureSubscriptionOverrideChangedEventsIsMutable();
            this.subscriptionOverrideChangedEvents_.set(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r8, r10);
            goto L9
        }

        public Builder setSubscriptionPlansChangedEvents(int r8, SubscriptionPlansChangedEvent r10) {
            RepeatedFieldBuilderV3<SubscriptionPlansChangedEvent, SubscriptionPlansChangedEvent.Builder, SubscriptionPlansChangedEventOrBuilder> r11 = this.subscriptionPlansChangedEventsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureSubscriptionPlansChangedEventsIsMutable();
            this.subscriptionPlansChangedEvents_.set(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r8, r10);
            goto L9
        }

        public Builder setUidPoliciesChangedEvents(int r8, UidPoliciesChangedEvent r10) {
            RepeatedFieldBuilderV3<UidPoliciesChangedEvent, UidPoliciesChangedEvent.Builder, UidPoliciesChangedEventOrBuilder> r11 = this.uidPoliciesChangedEventsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureUidPoliciesChangedEventsIsMutable();
            this.uidPoliciesChangedEvents_.set(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r8, r10);
            goto L9
        }

        public Builder setUidRulesChangedEvents(int r8, UidRulesChangedEvent r10) {
            RepeatedFieldBuilderV3<UidRulesChangedEvent, UidRulesChangedEvent.Builder, UidRulesChangedEventOrBuilder> r11 = this.uidRulesChangedEventsBuilder_;
            if (r11 != null) goto L8;
            if (r10 == null) goto L7;
            ensureUidRulesChangedEventsIsMutable();
            this.uidRulesChangedEvents_.set(r8, r10);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r11.setMessage(r8, r10);
            goto L9
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public /* synthetic */ Builder(GeneratedMessageV3.BuilderParent r8, AnonymousClass1 r10) {
            this(r8);
        }

        public Builder addAppNetOpChangedEvents(AppNetOpChangedEvent.Builder r8) {
            RepeatedFieldBuilderV3<AppNetOpChangedEvent, AppNetOpChangedEvent.Builder, AppNetOpChangedEventOrBuilder> r10 = this.appNetOpChangedEventsBuilder_;
            if (r10 != null) goto L5;
            ensureAppNetOpChangedEventsIsMutable();
            this.appNetOpChangedEvents_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        public Builder addBlockedReasonChangedEvents(BlockedReasonChangedEvent.Builder r8) {
            RepeatedFieldBuilderV3<BlockedReasonChangedEvent, BlockedReasonChangedEvent.Builder, BlockedReasonChangedEventOrBuilder> r10 = this.blockedReasonChangedEventsBuilder_;
            if (r10 != null) goto L5;
            ensureBlockedReasonChangedEventsIsMutable();
            this.blockedReasonChangedEvents_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        public Builder addMeteredIfacesChangedEvents(MeteredIfacesChangedEvent.Builder r8) {
            RepeatedFieldBuilderV3<MeteredIfacesChangedEvent, MeteredIfacesChangedEvent.Builder, MeteredIfacesChangedEventOrBuilder> r10 = this.meteredIfacesChangedEventsBuilder_;
            if (r10 != null) goto L5;
            ensureMeteredIfacesChangedEventsIsMutable();
            this.meteredIfacesChangedEvents_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        public Builder addPowerStateEvents(PowerStateEvent.Builder r8) {
            RepeatedFieldBuilderV3<PowerStateEvent, PowerStateEvent.Builder, PowerStateEventOrBuilder> r10 = this.powerStateEventsBuilder_;
            if (r10 != null) goto L5;
            ensurePowerStateEventsIsMutable();
            this.powerStateEvents_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        public Builder addRestrictBackgroundChangedEvents(RestrictBackgroundChangedEvent.Builder r8) {
            RepeatedFieldBuilderV3<RestrictBackgroundChangedEvent, RestrictBackgroundChangedEvent.Builder, RestrictBackgroundChangedEventOrBuilder> r10 = this.restrictBackgroundChangedEventsBuilder_;
            if (r10 != null) goto L5;
            ensureRestrictBackgroundChangedEventsIsMutable();
            this.restrictBackgroundChangedEvents_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        public Builder addSleepModeChangedEvents(SleepModeChangedEvent.Builder r8) {
            RepeatedFieldBuilderV3<SleepModeChangedEvent, SleepModeChangedEvent.Builder, SleepModeChangedEventOrBuilder> r10 = this.sleepModeChangedEventsBuilder_;
            if (r10 != null) goto L5;
            ensureSleepModeChangedEventsIsMutable();
            this.sleepModeChangedEvents_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        public Builder addSubscriptionOverrideChangedEvents(SubscriptionOverrideChangedEvent.Builder r8) {
            RepeatedFieldBuilderV3<SubscriptionOverrideChangedEvent, SubscriptionOverrideChangedEvent.Builder, SubscriptionOverrideChangedEventOrBuilder> r10 = this.subscriptionOverrideChangedEventsBuilder_;
            if (r10 != null) goto L5;
            ensureSubscriptionOverrideChangedEventsIsMutable();
            this.subscriptionOverrideChangedEvents_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        public Builder addSubscriptionPlansChangedEvents(SubscriptionPlansChangedEvent.Builder r8) {
            RepeatedFieldBuilderV3<SubscriptionPlansChangedEvent, SubscriptionPlansChangedEvent.Builder, SubscriptionPlansChangedEventOrBuilder> r10 = this.subscriptionPlansChangedEventsBuilder_;
            if (r10 != null) goto L5;
            ensureSubscriptionPlansChangedEventsIsMutable();
            this.subscriptionPlansChangedEvents_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        public Builder addUidPoliciesChangedEvents(UidPoliciesChangedEvent.Builder r8) {
            RepeatedFieldBuilderV3<UidPoliciesChangedEvent, UidPoliciesChangedEvent.Builder, UidPoliciesChangedEventOrBuilder> r10 = this.uidPoliciesChangedEventsBuilder_;
            if (r10 != null) goto L5;
            ensureUidPoliciesChangedEventsIsMutable();
            this.uidPoliciesChangedEvents_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        public Builder addUidRulesChangedEvents(UidRulesChangedEvent.Builder r8) {
            RepeatedFieldBuilderV3<UidRulesChangedEvent, UidRulesChangedEvent.Builder, UidRulesChangedEventOrBuilder> r10 = this.uidRulesChangedEventsBuilder_;
            if (r10 != null) goto L5;
            ensureUidRulesChangedEventsIsMutable();
            this.uidRulesChangedEvents_.add(r8.build());
            onChanged();
        L6:
            return this;
        L5:
            r10.addMessage(r8.build());
            goto L6
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public NetpolicyEvents build() {
            NetpolicyEvents r8 = buildPartial();
            if (r8.isInitialized() == false) goto L6;
            return r8;
        L6:
            throw AbstractMessage.Builder.newUninitializedMessageException(r8);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public NetpolicyEvents buildPartial() {
            NetpolicyEvents r8 = new NetpolicyEvents(this, null);
            buildPartialRepeatedFields(r8);
            if (this.bitField0_ == 0) goto L5;
            buildPartial0(r8);
        L5:
            onBuilt();
            return r8;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.ExtendableBuilder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessage.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public NetpolicyEvents getDefaultInstanceForType() {
            return NetpolicyEvents.getDefaultInstance();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setUnknownFields(UnknownFieldSet r8) {
            return setUnknownFields(r8);
        }

        public /* synthetic */ Builder(AnonymousClass1 r8) {
            this();
        }

        public Builder addAppNetOpChangedEvents(AppNetOpChangedEvent r8) {
            RepeatedFieldBuilderV3<AppNetOpChangedEvent, AppNetOpChangedEvent.Builder, AppNetOpChangedEventOrBuilder> r10 = this.appNetOpChangedEventsBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureAppNetOpChangedEventsIsMutable();
            this.appNetOpChangedEvents_.add(r8);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r10.addMessage(r8);
            goto L9
        }

        public Builder addBlockedReasonChangedEvents(BlockedReasonChangedEvent r8) {
            RepeatedFieldBuilderV3<BlockedReasonChangedEvent, BlockedReasonChangedEvent.Builder, BlockedReasonChangedEventOrBuilder> r10 = this.blockedReasonChangedEventsBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureBlockedReasonChangedEventsIsMutable();
            this.blockedReasonChangedEvents_.add(r8);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r10.addMessage(r8);
            goto L9
        }

        public Builder addMeteredIfacesChangedEvents(MeteredIfacesChangedEvent r8) {
            RepeatedFieldBuilderV3<MeteredIfacesChangedEvent, MeteredIfacesChangedEvent.Builder, MeteredIfacesChangedEventOrBuilder> r10 = this.meteredIfacesChangedEventsBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureMeteredIfacesChangedEventsIsMutable();
            this.meteredIfacesChangedEvents_.add(r8);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r10.addMessage(r8);
            goto L9
        }

        public Builder addPowerStateEvents(PowerStateEvent r8) {
            RepeatedFieldBuilderV3<PowerStateEvent, PowerStateEvent.Builder, PowerStateEventOrBuilder> r10 = this.powerStateEventsBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensurePowerStateEventsIsMutable();
            this.powerStateEvents_.add(r8);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r10.addMessage(r8);
            goto L9
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return addRepeatedField(r8, r10);
        }

        public Builder addRestrictBackgroundChangedEvents(RestrictBackgroundChangedEvent r8) {
            RepeatedFieldBuilderV3<RestrictBackgroundChangedEvent, RestrictBackgroundChangedEvent.Builder, RestrictBackgroundChangedEventOrBuilder> r10 = this.restrictBackgroundChangedEventsBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureRestrictBackgroundChangedEventsIsMutable();
            this.restrictBackgroundChangedEvents_.add(r8);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r10.addMessage(r8);
            goto L9
        }

        public Builder addSleepModeChangedEvents(SleepModeChangedEvent r8) {
            RepeatedFieldBuilderV3<SleepModeChangedEvent, SleepModeChangedEvent.Builder, SleepModeChangedEventOrBuilder> r10 = this.sleepModeChangedEventsBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureSleepModeChangedEventsIsMutable();
            this.sleepModeChangedEvents_.add(r8);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r10.addMessage(r8);
            goto L9
        }

        public Builder addSubscriptionOverrideChangedEvents(SubscriptionOverrideChangedEvent r8) {
            RepeatedFieldBuilderV3<SubscriptionOverrideChangedEvent, SubscriptionOverrideChangedEvent.Builder, SubscriptionOverrideChangedEventOrBuilder> r10 = this.subscriptionOverrideChangedEventsBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureSubscriptionOverrideChangedEventsIsMutable();
            this.subscriptionOverrideChangedEvents_.add(r8);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r10.addMessage(r8);
            goto L9
        }

        public Builder addSubscriptionPlansChangedEvents(SubscriptionPlansChangedEvent r8) {
            RepeatedFieldBuilderV3<SubscriptionPlansChangedEvent, SubscriptionPlansChangedEvent.Builder, SubscriptionPlansChangedEventOrBuilder> r10 = this.subscriptionPlansChangedEventsBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureSubscriptionPlansChangedEventsIsMutable();
            this.subscriptionPlansChangedEvents_.add(r8);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r10.addMessage(r8);
            goto L9
        }

        public Builder addUidPoliciesChangedEvents(UidPoliciesChangedEvent r8) {
            RepeatedFieldBuilderV3<UidPoliciesChangedEvent, UidPoliciesChangedEvent.Builder, UidPoliciesChangedEventOrBuilder> r10 = this.uidPoliciesChangedEventsBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureUidPoliciesChangedEventsIsMutable();
            this.uidPoliciesChangedEvents_.add(r8);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r10.addMessage(r8);
            goto L9
        }

        public Builder addUidRulesChangedEvents(UidRulesChangedEvent r8) {
            RepeatedFieldBuilderV3<UidRulesChangedEvent, UidRulesChangedEvent.Builder, UidRulesChangedEventOrBuilder> r10 = this.uidRulesChangedEventsBuilder_;
            if (r10 != null) goto L8;
            if (r8 == null) goto L7;
            ensureUidRulesChangedEventsIsMutable();
            this.uidRulesChangedEvents_.add(r8);
            onChanged();
        L9:
            return this;
        L7:
            throw null;
        L8:
            r10.addMessage(r8);
            goto L9
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearField(Descriptors.FieldDescriptor r8) {
            return clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return clearOneof(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageV3.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeUnknownFields(UnknownFieldSet r8) {
            return mergeUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet r8) {
            return (Builder) super.setUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor r8, Object r10) {
            return (Builder) super.addRepeatedField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor r8) {
            return (Builder) super.clearField(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor r8) {
            return (Builder) super.clearOneof(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ Message.Builder mergeFrom(Message r8) {
            return mergeFrom(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet r8) {
            return (Builder) super.mergeUnknownFields(r8);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor r8, Object r10) {
            return (Builder) super.setField(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor r8, int r10, Object r11) {
            return (Builder) super.setRepeatedField(r8, r10, r11);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            return clear();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            return mergeFrom(r8, r10);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            RepeatedFieldBuilderV3<UidRulesChangedEvent, UidRulesChangedEvent.Builder, UidRulesChangedEventOrBuilder> r8 = this.uidRulesChangedEventsBuilder_;
            if (r8 != null) goto L5;
            this.uidRulesChangedEvents_ = Collections.emptyList();
        L6:
            this.bitField0_ &= -2;
            RepeatedFieldBuilderV3<MeteredIfacesChangedEvent, MeteredIfacesChangedEvent.Builder, MeteredIfacesChangedEventOrBuilder> r10 = this.meteredIfacesChangedEventsBuilder_;
            if (r10 != null) goto L9;
            this.meteredIfacesChangedEvents_ = Collections.emptyList();
        L10:
            this.bitField0_ &= -3;
            RepeatedFieldBuilderV3<RestrictBackgroundChangedEvent, RestrictBackgroundChangedEvent.Builder, RestrictBackgroundChangedEventOrBuilder> r11 = this.restrictBackgroundChangedEventsBuilder_;
            if (r11 != null) goto L13;
            this.restrictBackgroundChangedEvents_ = Collections.emptyList();
        L14:
            this.bitField0_ &= -5;
            RepeatedFieldBuilderV3<UidPoliciesChangedEvent, UidPoliciesChangedEvent.Builder, UidPoliciesChangedEventOrBuilder> r12 = this.uidPoliciesChangedEventsBuilder_;
            if (r12 != null) goto L17;
            this.uidPoliciesChangedEvents_ = Collections.emptyList();
        L18:
            this.bitField0_ &= -9;
            RepeatedFieldBuilderV3<SubscriptionOverrideChangedEvent, SubscriptionOverrideChangedEvent.Builder, SubscriptionOverrideChangedEventOrBuilder> r13 = this.subscriptionOverrideChangedEventsBuilder_;
            if (r13 != null) goto L21;
            this.subscriptionOverrideChangedEvents_ = Collections.emptyList();
        L22:
            this.bitField0_ &= -17;
            RepeatedFieldBuilderV3<SubscriptionPlansChangedEvent, SubscriptionPlansChangedEvent.Builder, SubscriptionPlansChangedEventOrBuilder> r14 = this.subscriptionPlansChangedEventsBuilder_;
            if (r14 != null) goto L25;
            this.subscriptionPlansChangedEvents_ = Collections.emptyList();
        L26:
            this.bitField0_ &= -33;
            RepeatedFieldBuilderV3<BlockedReasonChangedEvent, BlockedReasonChangedEvent.Builder, BlockedReasonChangedEventOrBuilder> r15 = this.blockedReasonChangedEventsBuilder_;
            if (r15 != null) goto L29;
            this.blockedReasonChangedEvents_ = Collections.emptyList();
        L30:
            this.bitField0_ &= -65;
            RepeatedFieldBuilderV3<PowerStateEvent, PowerStateEvent.Builder, PowerStateEventOrBuilder> r16 = this.powerStateEventsBuilder_;
            if (r16 != null) goto L33;
            this.powerStateEvents_ = Collections.emptyList();
        L34:
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            RepeatedFieldBuilderV3<AppNetOpChangedEvent, AppNetOpChangedEvent.Builder, AppNetOpChangedEventOrBuilder> r17 = this.appNetOpChangedEventsBuilder_;
            if (r17 != null) goto L37;
            this.appNetOpChangedEvents_ = Collections.emptyList();
        L38:
            this.bitField0_ &= -257;
            RepeatedFieldBuilderV3<SleepModeChangedEvent, SleepModeChangedEvent.Builder, SleepModeChangedEventOrBuilder> r18 = this.sleepModeChangedEventsBuilder_;
            if (r18 != null) goto L41;
            this.sleepModeChangedEvents_ = Collections.emptyList();
        L42:
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            return this;
        L41:
            this.sleepModeChangedEvents_ = null;
            r18.clear();
            goto L42
        L37:
            this.appNetOpChangedEvents_ = null;
            r17.clear();
            goto L38
        L33:
            this.powerStateEvents_ = null;
            r16.clear();
            goto L34
        L29:
            this.blockedReasonChangedEvents_ = null;
            r15.clear();
            goto L30
        L25:
            this.subscriptionPlansChangedEvents_ = null;
            r14.clear();
            goto L26
        L21:
            this.subscriptionOverrideChangedEvents_ = null;
            r13.clear();
            goto L22
        L17:
            this.uidPoliciesChangedEvents_ = null;
            r12.clear();
            goto L18
        L13:
            this.restrictBackgroundChangedEvents_ = null;
            r11.clear();
            goto L14
        L9:
            this.meteredIfacesChangedEvents_ = null;
            r10.clear();
            goto L10
        L5:
            this.uidRulesChangedEvents_ = null;
            r8.clear();
            goto L6
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clone() {
            return (Builder) super.clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
            if (r10 == null) goto L54;
            boolean r11 = false;
        L4:
            if (r11 == true) goto L51;
            int r12 = r8.readTag();     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            switch(r12) {
                case 0: goto L41;
                case 10: goto L37;
                case 18: goto L34;
                case 26: goto L31;
                case 34: goto L28;
                case 42: goto L25;
                case 50: goto L22;
                case 58: goto L19;
                case 66: goto L16;
                case 74: goto L13;
                case 82: goto L8;
                default: goto L42;
            };     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
        L8:
            GeneratedMessage.ExtendableMessageOrBuilder r13 = (SleepModeChangedEvent) r8.readMessage(SleepModeChangedEvent.PARSER, r10);     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            RepeatedFieldBuilderV3 r14 = this.sleepModeChangedEventsBuilder_;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            if (r14 == null) goto L10;
        L12:
            r14.addMessage(r13);     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            goto L4
        L10:
            ensureSleepModeChangedEventsIsMutable();     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            List r15 = this.sleepModeChangedEvents_;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
        L11:
            r15.add(r13);     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            goto L4
        L13:
            r13 = (AppNetOpChangedEvent) r8.readMessage(AppNetOpChangedEvent.PARSER, r10);     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            r14 = this.appNetOpChangedEventsBuilder_;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            if (r14 != null) goto L12;
            ensureAppNetOpChangedEventsIsMutable();     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            r15 = this.appNetOpChangedEvents_;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            goto L11
        L16:
            r13 = (PowerStateEvent) r8.readMessage(PowerStateEvent.PARSER, r10);     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            r14 = this.powerStateEventsBuilder_;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            if (r14 != null) goto L12;
            ensurePowerStateEventsIsMutable();     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            r15 = this.powerStateEvents_;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            goto L11
        L19:
            r13 = (BlockedReasonChangedEvent) r8.readMessage(BlockedReasonChangedEvent.PARSER, r10);     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            r14 = this.blockedReasonChangedEventsBuilder_;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            if (r14 != null) goto L12;
            ensureBlockedReasonChangedEventsIsMutable();     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            r15 = this.blockedReasonChangedEvents_;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            goto L11
        L22:
            r13 = (SubscriptionPlansChangedEvent) r8.readMessage(SubscriptionPlansChangedEvent.PARSER, r10);     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            r14 = this.subscriptionPlansChangedEventsBuilder_;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            if (r14 != null) goto L12;
            ensureSubscriptionPlansChangedEventsIsMutable();     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            r15 = this.subscriptionPlansChangedEvents_;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            goto L11
        L25:
            r13 = (SubscriptionOverrideChangedEvent) r8.readMessage(SubscriptionOverrideChangedEvent.PARSER, r10);     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            r14 = this.subscriptionOverrideChangedEventsBuilder_;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            if (r14 != null) goto L12;
            ensureSubscriptionOverrideChangedEventsIsMutable();     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            r15 = this.subscriptionOverrideChangedEvents_;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            goto L11
        L28:
            r13 = (UidPoliciesChangedEvent) r8.readMessage(UidPoliciesChangedEvent.PARSER, r10);     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            r14 = this.uidPoliciesChangedEventsBuilder_;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            if (r14 != null) goto L12;
            ensureUidPoliciesChangedEventsIsMutable();     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            r15 = this.uidPoliciesChangedEvents_;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            goto L11
        L31:
            r13 = (RestrictBackgroundChangedEvent) r8.readMessage(RestrictBackgroundChangedEvent.PARSER, r10);     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            r14 = this.restrictBackgroundChangedEventsBuilder_;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            if (r14 != null) goto L12;
            ensureRestrictBackgroundChangedEventsIsMutable();     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            r15 = this.restrictBackgroundChangedEvents_;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            goto L11
        L34:
            r13 = (MeteredIfacesChangedEvent) r8.readMessage(MeteredIfacesChangedEvent.PARSER, r10);     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            r14 = this.meteredIfacesChangedEventsBuilder_;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            if (r14 != null) goto L12;
            ensureMeteredIfacesChangedEventsIsMutable();     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            r15 = this.meteredIfacesChangedEvents_;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            goto L11
        L37:
            r13 = (UidRulesChangedEvent) r8.readMessage(UidRulesChangedEvent.PARSER, r10);     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            r14 = this.uidRulesChangedEventsBuilder_;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            if (r14 != null) goto L12;
            ensureUidRulesChangedEventsIsMutable();     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
            r15 = this.uidRulesChangedEvents_;     // Catch: Throwable -> L44 InvalidProtocolBufferException -> L46
        L41:
            r11 = true;
            goto L4
        L42:
            if (super.parseUnknownField(r8, r10, r12) == true) goto L4;
        L44:
            th = move-exception;
            onChanged();
            throw th;
        L46:
            e = move-exception;
            throw e.unwrapIOException();     // Catch: Throwable -> L44
        L51:
            onChanged();
            return this;
        L54:
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* JADX INFO: renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo1clone() {
            return clone();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message r8) {
            if ((r8 instanceof NetpolicyEvents) == true) goto L5;
            super.mergeFrom(r8);
            return this;
        L5:
            return mergeFrom((NetpolicyEvents) r8);
        }

        public Builder mergeFrom(NetpolicyEvents r8) {
            if (r8 != NetpolicyEvents.getDefaultInstance()) goto L5;
            return this;
        L5:
            RepeatedFieldBuilderV3<SleepModeChangedEvent, SleepModeChangedEvent.Builder, SleepModeChangedEventOrBuilder> r10 = null;
            if (this.uidRulesChangedEventsBuilder_ != null) goto L15;
            if (NetpolicyEvents.access$300(r8).isEmpty() == true) goto L25;
            if (this.uidRulesChangedEvents_.isEmpty() == false) goto L12;
            this.uidRulesChangedEvents_ = NetpolicyEvents.access$300(r8);
            this.bitField0_ &= -2;
        L13:
            onChanged();
            goto L25
        L12:
            ensureUidRulesChangedEventsIsMutable();
            this.uidRulesChangedEvents_.addAll(NetpolicyEvents.access$300(r8));
        L25:
            if (this.meteredIfacesChangedEventsBuilder_ != null) goto L34;
            if (NetpolicyEvents.access$400(r8).isEmpty() == true) goto L44;
            if (this.meteredIfacesChangedEvents_.isEmpty() == false) goto L31;
            this.meteredIfacesChangedEvents_ = NetpolicyEvents.access$400(r8);
            this.bitField0_ &= -3;
        L32:
            onChanged();
            goto L44
        L31:
            ensureMeteredIfacesChangedEventsIsMutable();
            this.meteredIfacesChangedEvents_.addAll(NetpolicyEvents.access$400(r8));
        L44:
            if (this.restrictBackgroundChangedEventsBuilder_ != null) goto L53;
            if (NetpolicyEvents.access$500(r8).isEmpty() == true) goto L63;
            if (this.restrictBackgroundChangedEvents_.isEmpty() == false) goto L50;
            this.restrictBackgroundChangedEvents_ = NetpolicyEvents.access$500(r8);
            this.bitField0_ &= -5;
        L51:
            onChanged();
            goto L63
        L50:
            ensureRestrictBackgroundChangedEventsIsMutable();
            this.restrictBackgroundChangedEvents_.addAll(NetpolicyEvents.access$500(r8));
        L63:
            if (this.uidPoliciesChangedEventsBuilder_ != null) goto L72;
            if (NetpolicyEvents.access$600(r8).isEmpty() == true) goto L82;
            if (this.uidPoliciesChangedEvents_.isEmpty() == false) goto L69;
            this.uidPoliciesChangedEvents_ = NetpolicyEvents.access$600(r8);
            this.bitField0_ &= -9;
        L70:
            onChanged();
            goto L82
        L69:
            ensureUidPoliciesChangedEventsIsMutable();
            this.uidPoliciesChangedEvents_.addAll(NetpolicyEvents.access$600(r8));
        L82:
            if (this.subscriptionOverrideChangedEventsBuilder_ != null) goto L91;
            if (NetpolicyEvents.access$700(r8).isEmpty() == true) goto L101;
            if (this.subscriptionOverrideChangedEvents_.isEmpty() == false) goto L88;
            this.subscriptionOverrideChangedEvents_ = NetpolicyEvents.access$700(r8);
            this.bitField0_ &= -17;
        L89:
            onChanged();
            goto L101
        L88:
            ensureSubscriptionOverrideChangedEventsIsMutable();
            this.subscriptionOverrideChangedEvents_.addAll(NetpolicyEvents.access$700(r8));
        L101:
            if (this.subscriptionPlansChangedEventsBuilder_ != null) goto L110;
            if (NetpolicyEvents.access$800(r8).isEmpty() == true) goto L120;
            if (this.subscriptionPlansChangedEvents_.isEmpty() == false) goto L107;
            this.subscriptionPlansChangedEvents_ = NetpolicyEvents.access$800(r8);
            this.bitField0_ &= -33;
        L108:
            onChanged();
            goto L120
        L107:
            ensureSubscriptionPlansChangedEventsIsMutable();
            this.subscriptionPlansChangedEvents_.addAll(NetpolicyEvents.access$800(r8));
        L120:
            if (this.blockedReasonChangedEventsBuilder_ != null) goto L129;
            if (NetpolicyEvents.access$900(r8).isEmpty() == true) goto L139;
            if (this.blockedReasonChangedEvents_.isEmpty() == false) goto L126;
            this.blockedReasonChangedEvents_ = NetpolicyEvents.access$900(r8);
            this.bitField0_ &= -65;
        L127:
            onChanged();
            goto L139
        L126:
            ensureBlockedReasonChangedEventsIsMutable();
            this.blockedReasonChangedEvents_.addAll(NetpolicyEvents.access$900(r8));
        L139:
            if (this.powerStateEventsBuilder_ != null) goto L148;
            if (NetpolicyEvents.access$1000(r8).isEmpty() == true) goto L158;
            if (this.powerStateEvents_.isEmpty() == false) goto L145;
            this.powerStateEvents_ = NetpolicyEvents.access$1000(r8);
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
        L146:
            onChanged();
            goto L158
        L145:
            ensurePowerStateEventsIsMutable();
            this.powerStateEvents_.addAll(NetpolicyEvents.access$1000(r8));
        L158:
            if (this.appNetOpChangedEventsBuilder_ != null) goto L167;
            if (NetpolicyEvents.access$1100(r8).isEmpty() == true) goto L177;
            if (this.appNetOpChangedEvents_.isEmpty() == false) goto L164;
            this.appNetOpChangedEvents_ = NetpolicyEvents.access$1100(r8);
            this.bitField0_ &= -257;
        L165:
            onChanged();
            goto L177
        L164:
            ensureAppNetOpChangedEventsIsMutable();
            this.appNetOpChangedEvents_.addAll(NetpolicyEvents.access$1100(r8));
        L177:
            if (this.sleepModeChangedEventsBuilder_ != null) goto L186;
            if (NetpolicyEvents.access$1200(r8).isEmpty() == false) goto L181;
        L194:
            mergeUnknownFields(r8.getUnknownFields());
            onChanged();
            return this;
        L181:
            if (this.sleepModeChangedEvents_.isEmpty() == false) goto L183;
            this.sleepModeChangedEvents_ = NetpolicyEvents.access$1200(r8);
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
        L184:
            onChanged();
            goto L194
        L183:
            ensureSleepModeChangedEventsIsMutable();
            this.sleepModeChangedEvents_.addAll(NetpolicyEvents.access$1200(r8));
            goto L184
        L186:
            if (NetpolicyEvents.access$1200(r8).isEmpty() == true) goto L194;
            if (this.sleepModeChangedEventsBuilder_.isEmpty() == false) goto L193;
            this.sleepModeChangedEventsBuilder_.dispose();
            this.sleepModeChangedEventsBuilder_ = null;
            this.sleepModeChangedEvents_ = NetpolicyEvents.access$1200(r8);
            this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            if (NetpolicyEvents.access$2200() == false) goto L192;
            r10 = getSleepModeChangedEventsFieldBuilder();
        L192:
            this.sleepModeChangedEventsBuilder_ = r10;
            goto L194
        L193:
            this.sleepModeChangedEventsBuilder_.addAllMessages(NetpolicyEvents.access$1200(r8));
            goto L194
        L167:
            if (NetpolicyEvents.access$1100(r8).isEmpty() == true) goto L177;
            if (this.appNetOpChangedEventsBuilder_.isEmpty() == false) goto L175;
            this.appNetOpChangedEventsBuilder_.dispose();
            this.appNetOpChangedEventsBuilder_ = null;
            this.appNetOpChangedEvents_ = NetpolicyEvents.access$1100(r8);
            this.bitField0_ &= -257;
            if (NetpolicyEvents.access$2100() == false) goto L173;
            RepeatedFieldBuilderV3<AppNetOpChangedEvent, AppNetOpChangedEvent.Builder, AppNetOpChangedEventOrBuilder> r11 = getAppNetOpChangedEventsFieldBuilder();
        L174:
            this.appNetOpChangedEventsBuilder_ = r11;
            goto L177
        L173:
            r11 = null;
            goto L174
        L175:
            this.appNetOpChangedEventsBuilder_.addAllMessages(NetpolicyEvents.access$1100(r8));
            goto L177
        L148:
            if (NetpolicyEvents.access$1000(r8).isEmpty() == true) goto L158;
            if (this.powerStateEventsBuilder_.isEmpty() == false) goto L156;
            this.powerStateEventsBuilder_.dispose();
            this.powerStateEventsBuilder_ = null;
            this.powerStateEvents_ = NetpolicyEvents.access$1000(r8);
            this.bitField0_ &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
            if (NetpolicyEvents.access$2000() == false) goto L154;
            RepeatedFieldBuilderV3<PowerStateEvent, PowerStateEvent.Builder, PowerStateEventOrBuilder> r12 = getPowerStateEventsFieldBuilder();
        L155:
            this.powerStateEventsBuilder_ = r12;
            goto L158
        L154:
            r12 = null;
            goto L155
        L156:
            this.powerStateEventsBuilder_.addAllMessages(NetpolicyEvents.access$1000(r8));
            goto L158
        L129:
            if (NetpolicyEvents.access$900(r8).isEmpty() == true) goto L139;
            if (this.blockedReasonChangedEventsBuilder_.isEmpty() == false) goto L137;
            this.blockedReasonChangedEventsBuilder_.dispose();
            this.blockedReasonChangedEventsBuilder_ = null;
            this.blockedReasonChangedEvents_ = NetpolicyEvents.access$900(r8);
            this.bitField0_ &= -65;
            if (NetpolicyEvents.access$1900() == false) goto L135;
            RepeatedFieldBuilderV3<BlockedReasonChangedEvent, BlockedReasonChangedEvent.Builder, BlockedReasonChangedEventOrBuilder> r13 = getBlockedReasonChangedEventsFieldBuilder();
        L136:
            this.blockedReasonChangedEventsBuilder_ = r13;
            goto L139
        L135:
            r13 = null;
            goto L136
        L137:
            this.blockedReasonChangedEventsBuilder_.addAllMessages(NetpolicyEvents.access$900(r8));
            goto L139
        L110:
            if (NetpolicyEvents.access$800(r8).isEmpty() == true) goto L120;
            if (this.subscriptionPlansChangedEventsBuilder_.isEmpty() == false) goto L118;
            this.subscriptionPlansChangedEventsBuilder_.dispose();
            this.subscriptionPlansChangedEventsBuilder_ = null;
            this.subscriptionPlansChangedEvents_ = NetpolicyEvents.access$800(r8);
            this.bitField0_ &= -33;
            if (NetpolicyEvents.access$1800() == false) goto L116;
            RepeatedFieldBuilderV3<SubscriptionPlansChangedEvent, SubscriptionPlansChangedEvent.Builder, SubscriptionPlansChangedEventOrBuilder> r14 = getSubscriptionPlansChangedEventsFieldBuilder();
        L117:
            this.subscriptionPlansChangedEventsBuilder_ = r14;
            goto L120
        L116:
            r14 = null;
            goto L117
        L118:
            this.subscriptionPlansChangedEventsBuilder_.addAllMessages(NetpolicyEvents.access$800(r8));
            goto L120
        L91:
            if (NetpolicyEvents.access$700(r8).isEmpty() == true) goto L101;
            if (this.subscriptionOverrideChangedEventsBuilder_.isEmpty() == false) goto L99;
            this.subscriptionOverrideChangedEventsBuilder_.dispose();
            this.subscriptionOverrideChangedEventsBuilder_ = null;
            this.subscriptionOverrideChangedEvents_ = NetpolicyEvents.access$700(r8);
            this.bitField0_ &= -17;
            if (NetpolicyEvents.access$1700() == false) goto L97;
            RepeatedFieldBuilderV3<SubscriptionOverrideChangedEvent, SubscriptionOverrideChangedEvent.Builder, SubscriptionOverrideChangedEventOrBuilder> r15 = getSubscriptionOverrideChangedEventsFieldBuilder();
        L98:
            this.subscriptionOverrideChangedEventsBuilder_ = r15;
            goto L101
        L97:
            r15 = null;
            goto L98
        L99:
            this.subscriptionOverrideChangedEventsBuilder_.addAllMessages(NetpolicyEvents.access$700(r8));
            goto L101
        L72:
            if (NetpolicyEvents.access$600(r8).isEmpty() == true) goto L82;
            if (this.uidPoliciesChangedEventsBuilder_.isEmpty() == false) goto L80;
            this.uidPoliciesChangedEventsBuilder_.dispose();
            this.uidPoliciesChangedEventsBuilder_ = null;
            this.uidPoliciesChangedEvents_ = NetpolicyEvents.access$600(r8);
            this.bitField0_ &= -9;
            if (NetpolicyEvents.access$1600() == false) goto L78;
            RepeatedFieldBuilderV3<UidPoliciesChangedEvent, UidPoliciesChangedEvent.Builder, UidPoliciesChangedEventOrBuilder> r16 = getUidPoliciesChangedEventsFieldBuilder();
        L79:
            this.uidPoliciesChangedEventsBuilder_ = r16;
            goto L82
        L78:
            r16 = null;
            goto L79
        L80:
            this.uidPoliciesChangedEventsBuilder_.addAllMessages(NetpolicyEvents.access$600(r8));
            goto L82
        L53:
            if (NetpolicyEvents.access$500(r8).isEmpty() == true) goto L63;
            if (this.restrictBackgroundChangedEventsBuilder_.isEmpty() == false) goto L61;
            this.restrictBackgroundChangedEventsBuilder_.dispose();
            this.restrictBackgroundChangedEventsBuilder_ = null;
            this.restrictBackgroundChangedEvents_ = NetpolicyEvents.access$500(r8);
            this.bitField0_ &= -5;
            if (NetpolicyEvents.access$1500() == false) goto L59;
            RepeatedFieldBuilderV3<RestrictBackgroundChangedEvent, RestrictBackgroundChangedEvent.Builder, RestrictBackgroundChangedEventOrBuilder> r17 = getRestrictBackgroundChangedEventsFieldBuilder();
        L60:
            this.restrictBackgroundChangedEventsBuilder_ = r17;
            goto L63
        L59:
            r17 = null;
            goto L60
        L61:
            this.restrictBackgroundChangedEventsBuilder_.addAllMessages(NetpolicyEvents.access$500(r8));
            goto L63
        L34:
            if (NetpolicyEvents.access$400(r8).isEmpty() == true) goto L44;
            if (this.meteredIfacesChangedEventsBuilder_.isEmpty() == false) goto L42;
            this.meteredIfacesChangedEventsBuilder_.dispose();
            this.meteredIfacesChangedEventsBuilder_ = null;
            this.meteredIfacesChangedEvents_ = NetpolicyEvents.access$400(r8);
            this.bitField0_ &= -3;
            if (NetpolicyEvents.access$1400() == false) goto L40;
            RepeatedFieldBuilderV3<MeteredIfacesChangedEvent, MeteredIfacesChangedEvent.Builder, MeteredIfacesChangedEventOrBuilder> r18 = getMeteredIfacesChangedEventsFieldBuilder();
        L41:
            this.meteredIfacesChangedEventsBuilder_ = r18;
            goto L44
        L40:
            r18 = null;
            goto L41
        L42:
            this.meteredIfacesChangedEventsBuilder_.addAllMessages(NetpolicyEvents.access$400(r8));
            goto L44
        L15:
            if (NetpolicyEvents.access$300(r8).isEmpty() == true) goto L25;
            if (this.uidRulesChangedEventsBuilder_.isEmpty() == false) goto L23;
            this.uidRulesChangedEventsBuilder_.dispose();
            this.uidRulesChangedEventsBuilder_ = null;
            this.uidRulesChangedEvents_ = NetpolicyEvents.access$300(r8);
            this.bitField0_ &= -2;
            if (NetpolicyEvents.access$1300() == false) goto L21;
            RepeatedFieldBuilderV3<UidRulesChangedEvent, UidRulesChangedEvent.Builder, UidRulesChangedEventOrBuilder> r19 = getUidRulesChangedEventsFieldBuilder();
        L22:
            this.uidRulesChangedEventsBuilder_ = r19;
            goto L25
        L21:
            r19 = null;
            goto L22
        L23:
            this.uidRulesChangedEventsBuilder_.addAllMessages(NetpolicyEvents.access$300(r8));
            goto L25
        }
    }

    static {
        DEFAULT_INSTANCE = new NetpolicyEvents();
        PARSER = new AnonymousClass1();
    }

    private NetpolicyEvents() {
        this.memoizedIsInitialized = -1;
        this.uidRulesChangedEvents_ = Collections.emptyList();
        this.meteredIfacesChangedEvents_ = Collections.emptyList();
        this.restrictBackgroundChangedEvents_ = Collections.emptyList();
        this.uidPoliciesChangedEvents_ = Collections.emptyList();
        this.subscriptionOverrideChangedEvents_ = Collections.emptyList();
        this.subscriptionPlansChangedEvents_ = Collections.emptyList();
        this.blockedReasonChangedEvents_ = Collections.emptyList();
        this.powerStateEvents_ = Collections.emptyList();
        this.appNetOpChangedEvents_ = Collections.emptyList();
        this.sleepModeChangedEvents_ = Collections.emptyList();
    }

    public static /* synthetic */ List access$1000(NetpolicyEvents r8) {
        return r8.powerStateEvents_;
    }

    public static /* synthetic */ List access$1002(NetpolicyEvents r8, List r10) {
        r8.powerStateEvents_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$1100(NetpolicyEvents r8) {
        return r8.appNetOpChangedEvents_;
    }

    public static /* synthetic */ List access$1102(NetpolicyEvents r8, List r10) {
        r8.appNetOpChangedEvents_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$1200(NetpolicyEvents r8) {
        return r8.sleepModeChangedEvents_;
    }

    public static /* synthetic */ List access$1202(NetpolicyEvents r8, List r10) {
        r8.sleepModeChangedEvents_ = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$1300() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ boolean access$1400() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ boolean access$1500() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ boolean access$1600() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ boolean access$1700() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ boolean access$1800() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ boolean access$1900() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ boolean access$2000() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ boolean access$2100() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ boolean access$2200() {
        return GeneratedMessage.alwaysUseFieldBuilders;
    }

    public static /* synthetic */ List access$300(NetpolicyEvents r8) {
        return r8.uidRulesChangedEvents_;
    }

    public static /* synthetic */ List access$302(NetpolicyEvents r8, List r10) {
        r8.uidRulesChangedEvents_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$400(NetpolicyEvents r8) {
        return r8.meteredIfacesChangedEvents_;
    }

    public static /* synthetic */ List access$402(NetpolicyEvents r8, List r10) {
        r8.meteredIfacesChangedEvents_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$500(NetpolicyEvents r8) {
        return r8.restrictBackgroundChangedEvents_;
    }

    public static /* synthetic */ List access$502(NetpolicyEvents r8, List r10) {
        r8.restrictBackgroundChangedEvents_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$600(NetpolicyEvents r8) {
        return r8.uidPoliciesChangedEvents_;
    }

    public static /* synthetic */ List access$602(NetpolicyEvents r8, List r10) {
        r8.uidPoliciesChangedEvents_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$700(NetpolicyEvents r8) {
        return r8.subscriptionOverrideChangedEvents_;
    }

    public static /* synthetic */ List access$702(NetpolicyEvents r8, List r10) {
        r8.subscriptionOverrideChangedEvents_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$800(NetpolicyEvents r8) {
        return r8.subscriptionPlansChangedEvents_;
    }

    public static /* synthetic */ List access$802(NetpolicyEvents r8, List r10) {
        r8.subscriptionPlansChangedEvents_ = r10;
        return r10;
    }

    public static /* synthetic */ List access$900(NetpolicyEvents r8) {
        return r8.blockedReasonChangedEvents_;
    }

    public static /* synthetic */ List access$902(NetpolicyEvents r8, List r10) {
        r8.blockedReasonChangedEvents_ = r10;
        return r10;
    }

    public static NetpolicyEvents getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return CaeNetpolicyEvent.internal_static_com_obric_cae_network_NetpolicyEvents_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static NetpolicyEvents parseDelimitedFrom(InputStream r8) {
        return (NetpolicyEvents) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8);
    }

    public static NetpolicyEvents parseFrom(ByteString r8) {
        return PARSER.parseFrom(r8);
    }

    public static Parser<NetpolicyEvents> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object r8) {
        if (r8 != this) goto L6;
        return true;
    L6:
        if ((r8 instanceof NetpolicyEvents) == false) goto L8;
        NetpolicyEvents r10 = (NetpolicyEvents) r8;
        if (getUidRulesChangedEventsList().equals(r10.getUidRulesChangedEventsList()) == true) goto L13;
        return false;
    L13:
        if (getMeteredIfacesChangedEventsList().equals(r10.getMeteredIfacesChangedEventsList()) == true) goto L16;
        return false;
    L16:
        if (getRestrictBackgroundChangedEventsList().equals(r10.getRestrictBackgroundChangedEventsList()) == true) goto L19;
        return false;
    L19:
        if (getUidPoliciesChangedEventsList().equals(r10.getUidPoliciesChangedEventsList()) == true) goto L22;
        return false;
    L22:
        if (getSubscriptionOverrideChangedEventsList().equals(r10.getSubscriptionOverrideChangedEventsList()) == true) goto L25;
        return false;
    L25:
        if (getSubscriptionPlansChangedEventsList().equals(r10.getSubscriptionPlansChangedEventsList()) == true) goto L28;
        return false;
    L28:
        if (getBlockedReasonChangedEventsList().equals(r10.getBlockedReasonChangedEventsList()) == true) goto L31;
        return false;
    L31:
        if (getPowerStateEventsList().equals(r10.getPowerStateEventsList()) == true) goto L34;
        return false;
    L34:
        if (getAppNetOpChangedEventsList().equals(r10.getAppNetOpChangedEventsList()) == true) goto L37;
        return false;
    L37:
        if (getSleepModeChangedEventsList().equals(r10.getSleepModeChangedEventsList()) == true) goto L40;
        return false;
    L40:
        if (getUnknownFields().equals(r10.getUnknownFields()) == true) goto L42;
        return false;
    L42:
        return true;
    L8:
        return super.equals(r8);
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public AppNetOpChangedEvent getAppNetOpChangedEvents(int r8) {
        return this.appNetOpChangedEvents_.get(r8);
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public int getAppNetOpChangedEventsCount() {
        return this.appNetOpChangedEvents_.size();
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public List<AppNetOpChangedEvent> getAppNetOpChangedEventsList() {
        return this.appNetOpChangedEvents_;
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public AppNetOpChangedEventOrBuilder getAppNetOpChangedEventsOrBuilder(int r8) {
        return this.appNetOpChangedEvents_.get(r8);
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public List<? extends AppNetOpChangedEventOrBuilder> getAppNetOpChangedEventsOrBuilderList() {
        return this.appNetOpChangedEvents_;
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public BlockedReasonChangedEvent getBlockedReasonChangedEvents(int r8) {
        return this.blockedReasonChangedEvents_.get(r8);
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public int getBlockedReasonChangedEventsCount() {
        return this.blockedReasonChangedEvents_.size();
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public List<BlockedReasonChangedEvent> getBlockedReasonChangedEventsList() {
        return this.blockedReasonChangedEvents_;
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public BlockedReasonChangedEventOrBuilder getBlockedReasonChangedEventsOrBuilder(int r8) {
        return this.blockedReasonChangedEvents_.get(r8);
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public List<? extends BlockedReasonChangedEventOrBuilder> getBlockedReasonChangedEventsOrBuilderList() {
        return this.blockedReasonChangedEvents_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ Message getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public MeteredIfacesChangedEvent getMeteredIfacesChangedEvents(int r8) {
        return this.meteredIfacesChangedEvents_.get(r8);
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public int getMeteredIfacesChangedEventsCount() {
        return this.meteredIfacesChangedEvents_.size();
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public List<MeteredIfacesChangedEvent> getMeteredIfacesChangedEventsList() {
        return this.meteredIfacesChangedEvents_;
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public MeteredIfacesChangedEventOrBuilder getMeteredIfacesChangedEventsOrBuilder(int r8) {
        return this.meteredIfacesChangedEvents_.get(r8);
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public List<? extends MeteredIfacesChangedEventOrBuilder> getMeteredIfacesChangedEventsOrBuilderList() {
        return this.meteredIfacesChangedEvents_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<NetpolicyEvents> getParserForType() {
        return PARSER;
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public PowerStateEvent getPowerStateEvents(int r8) {
        return this.powerStateEvents_.get(r8);
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public int getPowerStateEventsCount() {
        return this.powerStateEvents_.size();
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public List<PowerStateEvent> getPowerStateEventsList() {
        return this.powerStateEvents_;
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public PowerStateEventOrBuilder getPowerStateEventsOrBuilder(int r8) {
        return this.powerStateEvents_.get(r8);
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public List<? extends PowerStateEventOrBuilder> getPowerStateEventsOrBuilderList() {
        return this.powerStateEvents_;
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public RestrictBackgroundChangedEvent getRestrictBackgroundChangedEvents(int r8) {
        return this.restrictBackgroundChangedEvents_.get(r8);
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public int getRestrictBackgroundChangedEventsCount() {
        return this.restrictBackgroundChangedEvents_.size();
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public List<RestrictBackgroundChangedEvent> getRestrictBackgroundChangedEventsList() {
        return this.restrictBackgroundChangedEvents_;
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public RestrictBackgroundChangedEventOrBuilder getRestrictBackgroundChangedEventsOrBuilder(int r8) {
        return this.restrictBackgroundChangedEvents_.get(r8);
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public List<? extends RestrictBackgroundChangedEventOrBuilder> getRestrictBackgroundChangedEventsOrBuilderList() {
        return this.restrictBackgroundChangedEvents_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int r8 = this.memoizedSize;
        if (r8 == (-1)) goto L5;
        return r8;
    L5:
        int r10 = 0;
        int r11 = 0;
        int r12 = 0;
    L7:
        if (r11 >= this.uidRulesChangedEvents_.size()) goto L9;
        r12 = r12 + CodedOutputStream.computeMessageSize(1, this.uidRulesChangedEvents_.get(r11));
        r11 = r11 + 1;
        goto L7
    L9:
        int r13 = 0;
    L11:
        if (r13 >= this.meteredIfacesChangedEvents_.size()) goto L13;
        r12 = r12 + CodedOutputStream.computeMessageSize(2, this.meteredIfacesChangedEvents_.get(r13));
        r13 = r13 + 1;
        goto L11
    L13:
        int r14 = 0;
    L15:
        if (r14 >= this.restrictBackgroundChangedEvents_.size()) goto L17;
        r12 = r12 + CodedOutputStream.computeMessageSize(3, this.restrictBackgroundChangedEvents_.get(r14));
        r14 = r14 + 1;
        goto L15
    L17:
        int r15 = 0;
    L19:
        if (r15 >= this.uidPoliciesChangedEvents_.size()) goto L21;
        r12 = r12 + CodedOutputStream.computeMessageSize(4, this.uidPoliciesChangedEvents_.get(r15));
        r15 = r15 + 1;
        goto L19
    L21:
        int r16 = 0;
    L23:
        if (r16 >= this.subscriptionOverrideChangedEvents_.size()) goto L25;
        r12 = r12 + CodedOutputStream.computeMessageSize(5, this.subscriptionOverrideChangedEvents_.get(r16));
        r16 = r16 + 1;
        goto L23
    L25:
        int r17 = 0;
    L27:
        if (r17 >= this.subscriptionPlansChangedEvents_.size()) goto L29;
        r12 = r12 + CodedOutputStream.computeMessageSize(6, this.subscriptionPlansChangedEvents_.get(r17));
        r17 = r17 + 1;
        goto L27
    L29:
        int r18 = 0;
    L31:
        if (r18 >= this.blockedReasonChangedEvents_.size()) goto L33;
        r12 = r12 + CodedOutputStream.computeMessageSize(7, this.blockedReasonChangedEvents_.get(r18));
        r18 = r18 + 1;
        goto L31
    L33:
        int r19 = 0;
    L35:
        if (r19 >= this.powerStateEvents_.size()) goto L37;
        r12 = r12 + CodedOutputStream.computeMessageSize(8, this.powerStateEvents_.get(r19));
        r19 = r19 + 1;
        goto L35
    L37:
        int r20 = 0;
    L39:
        if (r20 >= this.appNetOpChangedEvents_.size()) goto L42;
        r12 = r12 + CodedOutputStream.computeMessageSize(9, this.appNetOpChangedEvents_.get(r20));
        r20 = r20 + 1;
    L42:
        if (r10 >= this.sleepModeChangedEvents_.size()) goto L44;
        r12 = r12 + CodedOutputStream.computeMessageSize(10, this.sleepModeChangedEvents_.get(r10));
        r10 = r10 + 1;
        goto L42
    L44:
        int r21 = getUnknownFields().getSerializedSize() + r12;
        this.memoizedSize = r21;
        return r21;
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public SleepModeChangedEvent getSleepModeChangedEvents(int r8) {
        return this.sleepModeChangedEvents_.get(r8);
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public int getSleepModeChangedEventsCount() {
        return this.sleepModeChangedEvents_.size();
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public List<SleepModeChangedEvent> getSleepModeChangedEventsList() {
        return this.sleepModeChangedEvents_;
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public SleepModeChangedEventOrBuilder getSleepModeChangedEventsOrBuilder(int r8) {
        return this.sleepModeChangedEvents_.get(r8);
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public List<? extends SleepModeChangedEventOrBuilder> getSleepModeChangedEventsOrBuilderList() {
        return this.sleepModeChangedEvents_;
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public SubscriptionOverrideChangedEvent getSubscriptionOverrideChangedEvents(int r8) {
        return this.subscriptionOverrideChangedEvents_.get(r8);
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public int getSubscriptionOverrideChangedEventsCount() {
        return this.subscriptionOverrideChangedEvents_.size();
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public List<SubscriptionOverrideChangedEvent> getSubscriptionOverrideChangedEventsList() {
        return this.subscriptionOverrideChangedEvents_;
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public SubscriptionOverrideChangedEventOrBuilder getSubscriptionOverrideChangedEventsOrBuilder(int r8) {
        return this.subscriptionOverrideChangedEvents_.get(r8);
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public List<? extends SubscriptionOverrideChangedEventOrBuilder> getSubscriptionOverrideChangedEventsOrBuilderList() {
        return this.subscriptionOverrideChangedEvents_;
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public SubscriptionPlansChangedEvent getSubscriptionPlansChangedEvents(int r8) {
        return this.subscriptionPlansChangedEvents_.get(r8);
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public int getSubscriptionPlansChangedEventsCount() {
        return this.subscriptionPlansChangedEvents_.size();
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public List<SubscriptionPlansChangedEvent> getSubscriptionPlansChangedEventsList() {
        return this.subscriptionPlansChangedEvents_;
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public SubscriptionPlansChangedEventOrBuilder getSubscriptionPlansChangedEventsOrBuilder(int r8) {
        return this.subscriptionPlansChangedEvents_.get(r8);
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public List<? extends SubscriptionPlansChangedEventOrBuilder> getSubscriptionPlansChangedEventsOrBuilderList() {
        return this.subscriptionPlansChangedEvents_;
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public UidPoliciesChangedEvent getUidPoliciesChangedEvents(int r8) {
        return this.uidPoliciesChangedEvents_.get(r8);
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public int getUidPoliciesChangedEventsCount() {
        return this.uidPoliciesChangedEvents_.size();
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public List<UidPoliciesChangedEvent> getUidPoliciesChangedEventsList() {
        return this.uidPoliciesChangedEvents_;
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public UidPoliciesChangedEventOrBuilder getUidPoliciesChangedEventsOrBuilder(int r8) {
        return this.uidPoliciesChangedEvents_.get(r8);
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public List<? extends UidPoliciesChangedEventOrBuilder> getUidPoliciesChangedEventsOrBuilderList() {
        return this.uidPoliciesChangedEvents_;
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public UidRulesChangedEvent getUidRulesChangedEvents(int r8) {
        return this.uidRulesChangedEvents_.get(r8);
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public int getUidRulesChangedEventsCount() {
        return this.uidRulesChangedEvents_.size();
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public List<UidRulesChangedEvent> getUidRulesChangedEventsList() {
        return this.uidRulesChangedEvents_;
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public UidRulesChangedEventOrBuilder getUidRulesChangedEventsOrBuilder(int r8) {
        return this.uidRulesChangedEvents_.get(r8);
    }

    @Override // com.obric.cae.network.NetpolicyEventsOrBuilder
    public List<? extends UidRulesChangedEventOrBuilder> getUidRulesChangedEventsOrBuilderList() {
        return this.uidRulesChangedEvents_;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        int r8 = this.memoizedHashCode;
        if (r8 == 0) goto L5;
        return r8;
    L5:
        int r10 = getDescriptor().hashCode() + 779;
        if (getUidRulesChangedEventsCount() <= 0) goto L9;
        r10 = b.a(r10, 37, 1, 53) + getUidRulesChangedEventsList().hashCode();
    L9:
        if (getMeteredIfacesChangedEventsCount() <= 0) goto L12;
        r10 = b.a(r10, 37, 2, 53) + getMeteredIfacesChangedEventsList().hashCode();
    L12:
        if (getRestrictBackgroundChangedEventsCount() <= 0) goto L15;
        r10 = b.a(r10, 37, 3, 53) + getRestrictBackgroundChangedEventsList().hashCode();
    L15:
        if (getUidPoliciesChangedEventsCount() <= 0) goto L18;
        r10 = b.a(r10, 37, 4, 53) + getUidPoliciesChangedEventsList().hashCode();
    L18:
        if (getSubscriptionOverrideChangedEventsCount() <= 0) goto L21;
        r10 = b.a(r10, 37, 5, 53) + getSubscriptionOverrideChangedEventsList().hashCode();
    L21:
        if (getSubscriptionPlansChangedEventsCount() <= 0) goto L24;
        r10 = b.a(r10, 37, 6, 53) + getSubscriptionPlansChangedEventsList().hashCode();
    L24:
        if (getBlockedReasonChangedEventsCount() <= 0) goto L27;
        r10 = b.a(r10, 37, 7, 53) + getBlockedReasonChangedEventsList().hashCode();
    L27:
        if (getPowerStateEventsCount() <= 0) goto L30;
        r10 = b.a(r10, 37, 8, 53) + getPowerStateEventsList().hashCode();
    L30:
        if (getAppNetOpChangedEventsCount() <= 0) goto L33;
        r10 = b.a(r10, 37, 9, 53) + getAppNetOpChangedEventsList().hashCode();
    L33:
        if (getSleepModeChangedEventsCount() <= 0) goto L35;
        r10 = b.a(r10, 37, 10, 53) + getSleepModeChangedEventsList().hashCode();
    L35:
        int r11 = getUnknownFields().hashCode();
        int r12 = r11 + (r10 * 29);
        this.memoizedHashCode = r12;
        return r12;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public /* bridge */ /* synthetic */ GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return internalGetFieldAccessorTable();
    }

    @Override // com.google.protobuf.GeneratedMessage.ExtendableMessage, com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte r8 = this.memoizedIsInitialized;
        if (r8 != 1) goto L6;
        return true;
    L6:
        if (r8 != 0) goto L8;
        return false;
    L8:
        int r10 = 0;
    L10:
        if (r10 >= getUidRulesChangedEventsCount()) goto L16;
        if (getUidRulesChangedEvents(r10).isInitialized() == false) goto L13;
        r10 = r10 + 1;
        goto L10
    L13:
        this.memoizedIsInitialized = 0;
        return false;
    L16:
        int r11 = 0;
    L18:
        if (r11 >= getRestrictBackgroundChangedEventsCount()) goto L24;
        if (getRestrictBackgroundChangedEvents(r11).isInitialized() == false) goto L21;
        r11 = r11 + 1;
        goto L18
    L21:
        this.memoizedIsInitialized = 0;
        return false;
    L24:
        int r12 = 0;
    L26:
        if (r12 >= getUidPoliciesChangedEventsCount()) goto L32;
        if (getUidPoliciesChangedEvents(r12).isInitialized() == false) goto L29;
        r12 = r12 + 1;
        goto L26
    L29:
        this.memoizedIsInitialized = 0;
        return false;
    L32:
        int r13 = 0;
    L34:
        if (r13 >= getSubscriptionOverrideChangedEventsCount()) goto L40;
        if (getSubscriptionOverrideChangedEvents(r13).isInitialized() == false) goto L37;
        r13 = r13 + 1;
        goto L34
    L37:
        this.memoizedIsInitialized = 0;
        return false;
    L40:
        int r14 = 0;
    L42:
        if (r14 >= getSubscriptionPlansChangedEventsCount()) goto L48;
        if (getSubscriptionPlansChangedEvents(r14).isInitialized() == false) goto L45;
        r14 = r14 + 1;
        goto L42
    L45:
        this.memoizedIsInitialized = 0;
        return false;
    L48:
        int r15 = 0;
    L50:
        if (r15 >= getBlockedReasonChangedEventsCount()) goto L56;
        if (getBlockedReasonChangedEvents(r15).isInitialized() == false) goto L53;
        r15 = r15 + 1;
        goto L50
    L53:
        this.memoizedIsInitialized = 0;
        return false;
    L56:
        int r16 = 0;
    L58:
        if (r16 >= getPowerStateEventsCount()) goto L64;
        if (getPowerStateEvents(r16).isInitialized() == false) goto L61;
        r16 = r16 + 1;
        goto L58
    L61:
        this.memoizedIsInitialized = 0;
        return false;
    L64:
        int r17 = 0;
    L66:
        if (r17 >= getAppNetOpChangedEventsCount()) goto L72;
        if (getAppNetOpChangedEvents(r17).isInitialized() == false) goto L69;
        r17 = r17 + 1;
        goto L66
    L69:
        this.memoizedIsInitialized = 0;
        return false;
    L72:
        int r18 = 0;
    L74:
        if (r18 >= getSleepModeChangedEventsCount()) goto L80;
        if (getSleepModeChangedEvents(r18).isInitialized() == false) goto L77;
        r18 = r18 + 1;
        goto L74
    L77:
        this.memoizedIsInitialized = 0;
        return false;
    L80:
        this.memoizedIsInitialized = 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter r8) {
        return new NetpolicyEvents();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ Message.Builder toBuilder() {
        return toBuilder();
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream r8) {
        int r10 = 0;
        int r11 = 0;
    L4:
        if (r11 >= this.uidRulesChangedEvents_.size()) goto L6;
        r8.writeMessage(1, this.uidRulesChangedEvents_.get(r11));
        r11 = r11 + 1;
        goto L4
    L6:
        int r12 = 0;
    L8:
        if (r12 >= this.meteredIfacesChangedEvents_.size()) goto L10;
        r8.writeMessage(2, this.meteredIfacesChangedEvents_.get(r12));
        r12 = r12 + 1;
        goto L8
    L10:
        int r13 = 0;
    L12:
        if (r13 >= this.restrictBackgroundChangedEvents_.size()) goto L14;
        r8.writeMessage(3, this.restrictBackgroundChangedEvents_.get(r13));
        r13 = r13 + 1;
        goto L12
    L14:
        int r14 = 0;
    L16:
        if (r14 >= this.uidPoliciesChangedEvents_.size()) goto L18;
        r8.writeMessage(4, this.uidPoliciesChangedEvents_.get(r14));
        r14 = r14 + 1;
        goto L16
    L18:
        int r15 = 0;
    L20:
        if (r15 >= this.subscriptionOverrideChangedEvents_.size()) goto L22;
        r8.writeMessage(5, this.subscriptionOverrideChangedEvents_.get(r15));
        r15 = r15 + 1;
        goto L20
    L22:
        int r16 = 0;
    L24:
        if (r16 >= this.subscriptionPlansChangedEvents_.size()) goto L26;
        r8.writeMessage(6, this.subscriptionPlansChangedEvents_.get(r16));
        r16 = r16 + 1;
        goto L24
    L26:
        int r17 = 0;
    L28:
        if (r17 >= this.blockedReasonChangedEvents_.size()) goto L30;
        r8.writeMessage(7, this.blockedReasonChangedEvents_.get(r17));
        r17 = r17 + 1;
        goto L28
    L30:
        int r18 = 0;
    L32:
        if (r18 >= this.powerStateEvents_.size()) goto L34;
        r8.writeMessage(8, this.powerStateEvents_.get(r18));
        r18 = r18 + 1;
        goto L32
    L34:
        int r19 = 0;
    L36:
        if (r19 >= this.appNetOpChangedEvents_.size()) goto L39;
        r8.writeMessage(9, this.appNetOpChangedEvents_.get(r19));
        r19 = r19 + 1;
    L39:
        if (r10 >= this.sleepModeChangedEvents_.size()) goto L41;
        r8.writeMessage(10, this.sleepModeChangedEvents_.get(r10));
        r10 = r10 + 1;
        goto L39
    L41:
        getUnknownFields().writeTo(r8);
    }

    private NetpolicyEvents(GeneratedMessageV3.Builder<?> r8) {
        super(r8);
        this.memoizedIsInitialized = -1;
    }

    public static Builder newBuilder(NetpolicyEvents r8) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(r8);
    }

    public static NetpolicyEvents parseDelimitedFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (NetpolicyEvents) GeneratedMessage.parseDelimitedWithIOException(PARSER, r8, r10);
    }

    public static NetpolicyEvents parseFrom(ByteString r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return getDefaultInstanceForType();
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.GeneratedMessage
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return CaeNetpolicyEvent.internal_static_com_obric_cae_network_NetpolicyEvents_fieldAccessorTable.ensureFieldAccessorsInitialized(NetpolicyEvents.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public /* bridge */ /* synthetic */ Message.Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return newBuilderForType(r8);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
        return toBuilder();
    }

    public /* synthetic */ NetpolicyEvents(GeneratedMessageV3.Builder r8, AnonymousClass1 r10) {
        this(r8);
    }

    public static NetpolicyEvents parseFrom(CodedInputStream r8) {
        return (NetpolicyEvents) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder, com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
    public NetpolicyEvents getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
        return newBuilderForType();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        AnonymousClass1 r8 = null;
        if (this != DEFAULT_INSTANCE) goto L6;
        return new Builder(r8);
    L6:
        return new Builder(r8).mergeFrom(this);
    }

    public static NetpolicyEvents parseFrom(CodedInputStream r8, ExtensionRegistryLite r10) {
        return (NetpolicyEvents) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static NetpolicyEvents parseFrom(InputStream r8) {
        return (NetpolicyEvents) GeneratedMessage.parseWithIOException(PARSER, r8);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent r8) {
        return new Builder(r8, null);
    }

    public static NetpolicyEvents parseFrom(InputStream r8, ExtensionRegistryLite r10) {
        return (NetpolicyEvents) GeneratedMessage.parseWithIOException(PARSER, r8, r10);
    }

    public static NetpolicyEvents parseFrom(ByteBuffer r8) {
        return PARSER.parseFrom(r8);
    }

    public static NetpolicyEvents parseFrom(ByteBuffer r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }

    public static NetpolicyEvents parseFrom(byte[] r8) {
        return PARSER.parseFrom(r8);
    }

    public static NetpolicyEvents parseFrom(byte[] r8, ExtensionRegistryLite r10) {
        return PARSER.parseFrom(r8, r10);
    }
}
