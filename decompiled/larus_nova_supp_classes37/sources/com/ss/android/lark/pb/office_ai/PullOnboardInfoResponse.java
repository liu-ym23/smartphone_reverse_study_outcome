package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PullOnboardInfoResponse extends Message<PullOnboardInfoResponse, Builder> {
    public static final ProtoAdapter<PullOnboardInfoResponse> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_MORE = null;
    private static final long serialVersionUID = 0;
    public final List<AIBot> mai_bots;
    public final Boolean mhas_more;
    public final OnboardText monboard_text;
    public final List<PromptSample> mprompt_samples;
    public final List<QuickAction> mquery_templates;
    public final List<QuickAction> mquick_actions;
    public final List<SampleTypeConfig> msample_type_configs;
    public final List<MyAIScene> mscene;

    public static final class Builder extends Message.Builder<PullOnboardInfoResponse, Builder> {
        public List<AIBot> mai_bots;
        public Boolean mhas_more;
        public OnboardText monboard_text;
        public List<PromptSample> mprompt_samples;
        public List<QuickAction> mquery_templates;
        public List<QuickAction> mquick_actions;
        public List<SampleTypeConfig> msample_type_configs;
        public List<MyAIScene> mscene;

        /* JADX INFO: renamed from: build, reason: collision with other method in class */
        public PullOnboardInfoResponse m1991build() {
            return new PullOnboardInfoResponse(this.mscene, this.mhas_more, this.monboard_text, this.mquick_actions, this.mai_bots, this.msample_type_configs, this.mprompt_samples, this.mquery_templates, super.buildUnknownFields());
        }

        public Builder() {
            this.mscene = Internal.newMutableList();
            this.mquick_actions = Internal.newMutableList();
            this.mai_bots = Internal.newMutableList();
            this.msample_type_configs = Internal.newMutableList();
            this.mprompt_samples = Internal.newMutableList();
            this.mquery_templates = Internal.newMutableList();
        }

        public /* bridge */ /* synthetic */ Message build() {
            return m1991build();
        }

        public Builder ai_bots(List<AIBot> r1) {
            Internal.checkElementsNotNull(r1);
            this.mai_bots = r1;
            return this;
        }

        public Builder has_more(Boolean r1) {
            this.mhas_more = r1;
            return this;
        }

        public Builder onboard_text(OnboardText r1) {
            this.monboard_text = r1;
            return this;
        }

        public Builder prompt_samples(List<PromptSample> r1) {
            Internal.checkElementsNotNull(r1);
            this.mprompt_samples = r1;
            return this;
        }

        public Builder query_templates(List<QuickAction> r1) {
            Internal.checkElementsNotNull(r1);
            this.mquery_templates = r1;
            return this;
        }

        public Builder quick_actions(List<QuickAction> r1) {
            Internal.checkElementsNotNull(r1);
            this.mquick_actions = r1;
            return this;
        }

        public Builder sample_type_configs(List<SampleTypeConfig> r1) {
            Internal.checkElementsNotNull(r1);
            this.msample_type_configs = r1;
            return this;
        }

        public Builder scene(List<MyAIScene> r1) {
            Internal.checkElementsNotNull(r1);
            this.mscene = r1;
            return this;
        }
    }

    public static final class ProtoAdapter_PullOnboardInfoResponse extends ProtoAdapter<PullOnboardInfoResponse> {
        public ProtoAdapter_PullOnboardInfoResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PullOnboardInfoResponse.class);
        }

        public PullOnboardInfoResponse decode(ProtoReader r7) throws IOException {
            Builder r0 = new Builder();
            r0.mhas_more = Boolean.FALSE;
            long r1 = r7.beginMessage();
        L3:
            int r3 = r7.nextTag();
            if (r3 == (-1)) goto L15;
            switch(r3) {
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L11;
                case 5: goto L10;
                case 6: goto L9;
                case 7: goto L8;
                case 8: goto L7;
                default: goto L6;
            };
        L7:
            r0.mquery_templates.add((QuickAction) QuickAction.ADAPTER.decode(r7));
            goto L3
        L8:
            r0.mprompt_samples.add((PromptSample) PromptSample.ADAPTER.decode(r7));
            goto L3
        L9:
            r0.msample_type_configs.add((SampleTypeConfig) SampleTypeConfig.ADAPTER.decode(r7));
            goto L3
        L10:
            r0.mai_bots.add((AIBot) AIBot.ADAPTER.decode(r7));
            goto L3
        L11:
            r0.mquick_actions.add((QuickAction) QuickAction.ADAPTER.decode(r7));
            goto L3
        L12:
            r0.monboard_text = (OnboardText) OnboardText.ADAPTER.decode(r7);
            goto L3
        L13:
            r0.mhas_more = (Boolean) ProtoAdapter.BOOL.decode(r7);
            goto L3
        L14:
            r0.mscene.add((MyAIScene) MyAIScene.ADAPTER.decode(r7));
            goto L3
        L6:
            FieldEncoding r4 = r7.peekFieldEncoding();
            r0.addUnknownField(r3, r4, r4.rawProtoAdapter().decode(r7));
            goto L3
        L15:
            r7.endMessage(r1);
            return r0.m1991build();
        }

        public int encodedSize(PullOnboardInfoResponse r6) {
            int r0 = MyAIScene.ADAPTER.asRepeated().encodedSizeWithTag(1, r6.mscene);
            Boolean r1 = r6.mhas_more;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r1);
        L6:
            int r4 = r0 + r3;
            OnboardText r5 = r6.monboard_text;
            if (r5 == null) goto L9;
            r2 = OnboardText.ADAPTER.encodedSizeWithTag(3, r5);
        L9:
            ProtoAdapter<QuickAction> r7 = QuickAction.ADAPTER;
            return ((((((r4 + r2) + r7.asRepeated().encodedSizeWithTag(4, r6.mquick_actions)) + AIBot.ADAPTER.asRepeated().encodedSizeWithTag(5, r6.mai_bots)) + SampleTypeConfig.ADAPTER.asRepeated().encodedSizeWithTag(6, r6.msample_type_configs)) + PromptSample.ADAPTER.asRepeated().encodedSizeWithTag(7, r6.mprompt_samples)) + r7.asRepeated().encodedSizeWithTag(8, r6.mquery_templates)) + r6.unknownFields().size();
        L5:
            r3 = 0;
            goto L6
        }

        /* JADX INFO: renamed from: decode, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1992decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        public /* bridge */ /* synthetic */ int encodedSize(Object r1) {
            return encodedSize((PullOnboardInfoResponse) r1);
        }

        public void encode(ProtoWriter r5, PullOnboardInfoResponse r6) throws IOException {
            MyAIScene.ADAPTER.asRepeated().encodeWithTag(r5, 1, r6.mscene);
            Boolean r0 = r6.mhas_more;
            if (r0 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r5, 2, r0);
        L5:
            OnboardText r1 = r6.monboard_text;
            if (r1 == null) goto L8;
            OnboardText.ADAPTER.encodeWithTag(r5, 3, r1);
        L8:
            ProtoAdapter<QuickAction> r2 = QuickAction.ADAPTER;
            r2.asRepeated().encodeWithTag(r5, 4, r6.mquick_actions);
            AIBot.ADAPTER.asRepeated().encodeWithTag(r5, 5, r6.mai_bots);
            SampleTypeConfig.ADAPTER.asRepeated().encodeWithTag(r5, 6, r6.msample_type_configs);
            PromptSample.ADAPTER.asRepeated().encodeWithTag(r5, 7, r6.mprompt_samples);
            r2.asRepeated().encodeWithTag(r5, 8, r6.mquery_templates);
            r5.writeBytes(r6.unknownFields());
        }

        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, Object r2) throws IOException {
            encode(r1, (PullOnboardInfoResponse) r2);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullOnboardInfoResponse();
        DEFAULT_HAS_MORE = Boolean.FALSE;
    }

    /* JADX INFO: renamed from: newBuilder, reason: collision with other method in class */
    public Builder m1990newBuilder() {
        Builder r0 = new Builder();
        r0.mscene = Internal.copyOf("mscene", this.mscene);
        r0.mhas_more = this.mhas_more;
        r0.monboard_text = this.monboard_text;
        r0.mquick_actions = Internal.copyOf("mquick_actions", this.mquick_actions);
        r0.mai_bots = Internal.copyOf("mai_bots", this.mai_bots);
        r0.msample_type_configs = Internal.copyOf("msample_type_configs", this.msample_type_configs);
        r0.mprompt_samples = Internal.copyOf("mprompt_samples", this.mprompt_samples);
        r0.mquery_templates = Internal.copyOf("mquery_templates", this.mquery_templates);
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public String toString() {
        return PullOnboardInfoResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return m1990newBuilder();
    }

    public PullOnboardInfoResponse(List<MyAIScene> r11, Boolean r12, OnboardText r13, List<QuickAction> r14, List<AIBot> r15, List<SampleTypeConfig> r16, List<PromptSample> r17, List<QuickAction> r18) {
        this(r11, r12, r13, r14, r15, r16, r17, r18, ByteString.EMPTY);
    }

    public PullOnboardInfoResponse(List<MyAIScene> r2, Boolean r3, OnboardText r4, List<QuickAction> r5, List<AIBot> r6, List<SampleTypeConfig> r7, List<PromptSample> r8, List<QuickAction> r9, ByteString r10) {
        super(ADAPTER, r10);
        this.mscene = Internal.immutableCopyOf("mscene", r2);
        this.mhas_more = r3;
        this.monboard_text = r4;
        this.mquick_actions = Internal.immutableCopyOf("mquick_actions", r5);
        this.mai_bots = Internal.immutableCopyOf("mai_bots", r6);
        this.msample_type_configs = Internal.immutableCopyOf("msample_type_configs", r7);
        this.mprompt_samples = Internal.immutableCopyOf("mprompt_samples", r8);
        this.mquery_templates = Internal.immutableCopyOf("mquery_templates", r9);
    }
}
