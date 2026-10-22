package com.lark.kmp.pb.calendar.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.t;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0007&'()*+,B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010$\u001a\u00020\u0002H\u0016J\b\u0010%\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006-"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$Builder;Lokio/ByteString;)V", "video_meeting_type", "Lcom/lark/kmp/pb/calendar/v1/VideoMeeting$VideoMeetingType;", "getVideo_meeting_type", "()Lcom/lark/kmp/pb/calendar/v1/VideoMeeting$VideoMeetingType;", "meeting_url", "", "getMeeting_url", "()Ljava/lang/String;", "other_configs", "Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$OtherVideoMeetingConfigs;", "getOther_configs", "()Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$OtherVideoMeetingConfigs;", "google_configs", "Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$GoogleVideoMeetingConfigs;", "getGoogle_configs", "()Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$GoogleVideoMeetingConfigs;", "zoom_configs", "Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$ZoomVideoMeetingConfigs;", "getZoom_configs", "()Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$ZoomVideoMeetingConfigs;", "third_party_configs", "Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$ThirdPartyMeetingConfigs;", "getThird_party_configs", "()Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$ThirdPartyMeetingConfigs;", "lark_vc_binding_data", "Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$LarkVCBindingData;", "getLark_vc_binding_data", "()Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$LarkVCBindingData;", "newBuilder", "toString", "Builder", "Companion", "OtherVideoMeetingConfigs", "GoogleVideoMeetingConfigs", "ZoomVideoMeetingConfigs", "ThirdPartyMeetingConfigs", "LarkVCBindingData", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class EventVideoMeetingConfig extends Message<EventVideoMeetingConfig, a> {
    public static final ProtoAdapter<EventVideoMeetingConfig> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final GoogleVideoMeetingConfigs google_configs;
    private final LarkVCBindingData lark_vc_binding_data;
    private final String meeting_url;
    private final OtherVideoMeetingConfigs other_configs;
    private final ThirdPartyMeetingConfigs third_party_configs;
    private final VideoMeeting.VideoMeetingType video_meeting_type;
    private final ZoomVideoMeetingConfigs zoom_configs;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0010\u0011B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$GoogleVideoMeetingConfigs;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$GoogleVideoMeetingConfigs$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$GoogleVideoMeetingConfigs$Builder;Lokio/ByteString;)V", "phone_number", "", "getPhone_number", "()Ljava/lang/String;", "more_phone_number_url", "getMore_phone_number_url", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class GoogleVideoMeetingConfigs extends Message<GoogleVideoMeetingConfigs, a> {
        public static final ProtoAdapter<GoogleVideoMeetingConfigs> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String more_phone_number_url;
        private final String phone_number;

        public static final class a extends Message.a<GoogleVideoMeetingConfigs, a> {
            public String d;
            public String e;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new GoogleVideoMeetingConfigs(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<GoogleVideoMeetingConfigs> {
            @Override // com.lark.wire.ProtoAdapter
            public final GoogleVideoMeetingConfigs c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L13;
                if (r4 != 1) goto L8;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.d = r7.i();
                goto L3
            L8:
                if (r4 != 2) goto L9;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.e = r7.i();
                goto L3
            L9:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L13:
                return new GoogleVideoMeetingConfigs(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(GoogleVideoMeetingConfigs r5) {
                GoogleVideoMeetingConfigs r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                int r0 = r6.unknownFields().size();
                w r1 = ProtoAdapter.q;
                return (r0 + r1.l(1, r6.getPhone_number())) + r1.l(2, r6.getMore_phone_number_url());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, GoogleVideoMeetingConfigs r5) {
                GoogleVideoMeetingConfigs r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                w r0 = ProtoAdapter.q;
                r0.i(r4, 1, r6.getPhone_number());
                r0.i(r4, 2, r6.getMore_phone_number_url());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, GoogleVideoMeetingConfigs r5) {
                GoogleVideoMeetingConfigs r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                w r0 = ProtoAdapter.q;
                r0.j(r4, 2, r6.getMore_phone_number_url());
                r0.j(r4, 1, r6.getPhone_number());
            }

            public b(FieldEncoding r7, KClass<GoogleVideoMeetingConfigs> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/calendar.v1.EventVideoMeetingConfig.GoogleVideoMeetingConfigs", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ GoogleVideoMeetingConfigs(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(GoogleVideoMeetingConfigs.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.phone_number;
            r0.e = this.more_phone_number_url;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(GoogleVideoMeetingConfigs.class).getSimpleName() + '@' + hashCode();
        }

        public final String getMore_phone_number_url() {
            return this.more_phone_number_url;
        }

        public final String getPhone_number() {
            return this.phone_number;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public GoogleVideoMeetingConfigs(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.phone_number = r2.d;
            this.more_phone_number_url = r2.e;
        }

        public /* synthetic */ GoogleVideoMeetingConfigs(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000e\u000fB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$LarkVCBindingData;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$LarkVCBindingData$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$LarkVCBindingData$Builder;Lokio/ByteString;)V", "vc_setting_id", "", "getVc_setting_id", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class LarkVCBindingData extends Message<LarkVCBindingData, a> {
        public static final ProtoAdapter<LarkVCBindingData> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String vc_setting_id;

        public static final class a extends Message.a<LarkVCBindingData, a> {
            public String d;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new LarkVCBindingData(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<LarkVCBindingData> {
            @Override // com.lark.wire.ProtoAdapter
            public final LarkVCBindingData c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L10;
                if (r4 == 1) goto L7;
                r7.j(r4);
                goto L3
            L7:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.d = r7.i();
                goto L3
            L10:
                return new LarkVCBindingData(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(LarkVCBindingData r4) {
                LarkVCBindingData r5 = r4;
                Intrinsics.checkNotNullParameter(r5, "value");
                return r5.unknownFields().size() + ProtoAdapter.q.l(1, r5.getVc_setting_id());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, LarkVCBindingData r5) {
                LarkVCBindingData r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                ProtoAdapter.q.i(r4, 1, r6.getVc_setting_id());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r3, LarkVCBindingData r4) {
                LarkVCBindingData r5 = r4;
                Intrinsics.checkNotNullParameter(r3, "writer");
                Intrinsics.checkNotNullParameter(r5, "value");
                r3.d(r5.unknownFields());
                ProtoAdapter.q.j(r3, 1, r5.getVc_setting_id());
            }

            public b(FieldEncoding r7, KClass<LarkVCBindingData> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/calendar.v1.EventVideoMeetingConfig.LarkVCBindingData", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ LarkVCBindingData(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(LarkVCBindingData.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.vc_setting_id;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(LarkVCBindingData.class).getSimpleName() + '@' + hashCode();
        }

        public final String getVc_setting_id() {
            return this.vc_setting_id;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public LarkVCBindingData(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.vc_setting_id = r2.d;
        }

        public /* synthetic */ LarkVCBindingData(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0012\u0013\u0014B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$OtherVideoMeetingConfigs;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$OtherVideoMeetingConfigs$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$OtherVideoMeetingConfigs$Builder;Lokio/ByteString;)V", "icon", "Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$OtherVideoMeetingConfigs$IconType;", "getIcon", "()Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$OtherVideoMeetingConfigs$IconType;", "customized_description", "", "getCustomized_description", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "IconType", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class OtherVideoMeetingConfigs extends Message<OtherVideoMeetingConfigs, a> {
        public static final ProtoAdapter<OtherVideoMeetingConfigs> ADAPTER = null;
        public static final c Companion = null;
        public static final String DEFAULT_CUSTOMIZED_DESCRIPTION = "";
        private static final long serialVersionUID = 0;
        private final String customized_description;
        private final IconType icon;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$OtherVideoMeetingConfigs$IconType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "VIDEO_MEETING", "LIVE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        public static final enum IconType extends Enum<IconType> implements o0 {
            public static final ProtoAdapter<IconType> ADAPTER = null;
            public static final b Companion = null;
            public static final IconType DEFAULT = null;
            public static final IconType LIVE = null;
            public static final IconType VIDEO_MEETING = null;
            public static final /* synthetic */ IconType[] a = null;
            public static final /* synthetic */ EnumEntries b = null;
            private final int value;

            public static final class a extends d<IconType> {
                @Override // com.lark.wire.d
                public final o0 n(int r2) {
                    IconType.Companion.getClass();
                    if (r2 == 0) goto L12;
                    if (r2 == 1) goto L15;
                    if (r2 == 2) goto L14;
                    return null;
                L14:
                    return IconType.LIVE;
                L15:
                    return IconType.VIDEO_MEETING;
                L12:
                    return IconType.DEFAULT;
                }

                public a(KClass<IconType> r1, Syntax r2, IconType r3) {
                    super(r1, r2, r3);
                }
            }

            public static final class b {
                public b() {
                }
            }

            public static EnumEntries<IconType> getEntries() {
                return b;
            }

            static {
                IconType r0 = new IconType("DEFAULT", 0, 0);
                DEFAULT = r0;
                IconType r1 = new IconType("VIDEO_MEETING", 1, 1);
                VIDEO_MEETING = r1;
                IconType r3 = new IconType("LIVE", 2, 2);
                LIVE = r3;
                IconType[] r5 = {r0, r1, r3};
                a = r5;
                b = EnumEntriesKt.enumEntries(r5);
                Companion = new b();
                ADAPTER = new a(Reflection.getOrCreateKotlinClass(IconType.class), Syntax.PROTO_2, r0);
            }

            public static IconType[] values() {
                return (IconType[]) a.clone();
            }

            @Override // com.lark.wire.o0
            public int getValue() {
                return this.value;
            }

            @JvmStatic
            public static final IconType fromValue(int r1) {
                Companion.getClass();
                if (r1 == 0) goto L12;
                if (r1 == 1) goto L15;
                if (r1 == 2) goto L14;
                return null;
            L14:
                return LIVE;
            L15:
                return VIDEO_MEETING;
            L12:
                return DEFAULT;
            }

            public static IconType valueOf(String r1) {
                return (IconType) r27.a.a(IconType.class, r1);
            }

            public IconType(String r1, int r2, int r3) {
                super(r1, r2);
                this.value = r3;
            }
        }

        public static final class a extends Message.a<OtherVideoMeetingConfigs, a> {
            public IconType d;
            public String e;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new OtherVideoMeetingConfigs(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<OtherVideoMeetingConfigs> {
            @Override // com.lark.wire.ProtoAdapter
            public final OtherVideoMeetingConfigs c(g0 r10) {
                Intrinsics.checkNotNullParameter(r10, "reader");
                a r1 = new a();
                long r2 = r10.c();
            L3:
                int r4 = r10.e();
                if (r4 == (-1)) goto L16;
                if (r4 != 1) goto L8;
                r1.d = IconType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
            L13:
                e = move-exception;
                r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
                Unit r5 = Unit.INSTANCE;
                goto L3
            L8:
                if (r4 != 2) goto L9;
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r10, "reader");
                r1.e = r10.i();
                goto L3
            L9:
                r10.j(r4);
                goto L3
            L16:
                return new OtherVideoMeetingConfigs(r1, r10.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(OtherVideoMeetingConfigs r5) {
                OtherVideoMeetingConfigs r6 = r5;
                Intrinsics.checkNotNullParameter(r6, "value");
                return (r6.unknownFields().size() + IconType.ADAPTER.l(1, r6.getIcon())) + ProtoAdapter.q.l(2, r6.getCustomized_description());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r4, OtherVideoMeetingConfigs r5) {
                OtherVideoMeetingConfigs r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                IconType.ADAPTER.i(r4, 1, r6.getIcon());
                ProtoAdapter.q.i(r4, 2, r6.getCustomized_description());
                r4.a(r6.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r4, OtherVideoMeetingConfigs r5) {
                OtherVideoMeetingConfigs r6 = r5;
                Intrinsics.checkNotNullParameter(r4, "writer");
                Intrinsics.checkNotNullParameter(r6, "value");
                r4.d(r6.unknownFields());
                ProtoAdapter.q.j(r4, 2, r6.getCustomized_description());
                IconType.ADAPTER.j(r4, 1, r6.getIcon());
            }

            public b(FieldEncoding r7, KClass<OtherVideoMeetingConfigs> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/calendar.v1.EventVideoMeetingConfig.OtherVideoMeetingConfigs", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ OtherVideoMeetingConfigs(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(OtherVideoMeetingConfigs.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.icon;
            r0.e = this.customized_description;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(OtherVideoMeetingConfigs.class).getSimpleName() + '@' + hashCode();
        }

        public final String getCustomized_description() {
            return this.customized_description;
        }

        public final IconType getIcon() {
            return this.icon;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public OtherVideoMeetingConfigs(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.icon = r2.d;
            this.customized_description = r2.e;
        }

        public /* synthetic */ OtherVideoMeetingConfigs(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0007\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\rH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u001d\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$ThirdPartyMeetingConfigs;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$ThirdPartyMeetingConfigs$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$ThirdPartyMeetingConfigs$Builder;Lokio/ByteString;)V", "meeting_type", "Lcom/lark/kmp/pb/calendar/v1/ThirdPartyMeetingType;", "getMeeting_type", "()Lcom/lark/kmp/pb/calendar/v1/ThirdPartyMeetingType;", "meeting_id", "", "getMeeting_id", "()Ljava/lang/String;", "meeting_no", "getMeeting_no", "password", "getPassword", "meeting_description", "", "getMeeting_description", "()Ljava/util/Map;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ThirdPartyMeetingConfigs extends Message<ThirdPartyMeetingConfigs, a> {
        public static final ProtoAdapter<ThirdPartyMeetingConfigs> ADAPTER = null;
        public static final b Companion = null;
        private static final long serialVersionUID = 0;
        private final Map<String, String> meeting_description;
        private final String meeting_id;
        private final String meeting_no;
        private final ThirdPartyMeetingType meeting_type;
        private final String password;

        public static final class a extends Message.a<ThirdPartyMeetingConfigs, a> {
            public ThirdPartyMeetingType d;
            public String e;
            public String f;
            public String g;
            public Map<String, String> h;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new ThirdPartyMeetingConfigs(this, c(), null);
            }

            public a() {
                this.h = MapsKt.emptyMap();
            }
        }

        public static final class b {
            public b() {
            }
        }

        public /* synthetic */ ThirdPartyMeetingConfigs(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new b();
            final FieldEncoding r0 = FieldEncoding.LENGTH_DELIMITED;
            final KClass r1 = Reflection.getOrCreateKotlinClass(ThirdPartyMeetingConfigs.class);
            final Syntax r2 = Syntax.PROTO_2;
            ADAPTER = new EventVideoMeetingConfig$ThirdPartyMeetingConfigs$Companion$ADAPTER$1(r0, r1, r2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.meeting_type;
            r0.e = this.meeting_id;
            r0.f = this.meeting_no;
            r0.g = this.password;
            r0.h = this.meeting_description;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ThirdPartyMeetingConfigs.class).getSimpleName() + '@' + hashCode();
        }

        public final Map<String, String> getMeeting_description() {
            return this.meeting_description;
        }

        public final String getMeeting_id() {
            return this.meeting_id;
        }

        public final String getMeeting_no() {
            return this.meeting_no;
        }

        public final ThirdPartyMeetingType getMeeting_type() {
            return this.meeting_type;
        }

        public final String getPassword() {
            return this.password;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public ThirdPartyMeetingConfigs(a r2, ByteString r3) {
            super(ADAPTER, r3);
            ThirdPartyMeetingType r4 = r2.d;
            Intrinsics.checkNotNull(r4);
            this.meeting_type = r4;
            this.meeting_id = r2.e;
            this.meeting_no = r2.f;
            this.password = r2.g;
            this.meeting_description = com.lark.wire.internal.a.d("meeting_description", r2.h);
        }

        public /* synthetic */ ThirdPartyMeetingConfigs(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\u0010H\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\r\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0017\u0010\u0019R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u001c\u0010\u000b¨\u0006!"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$ZoomVideoMeetingConfigs;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$ZoomVideoMeetingConfigs$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$ZoomVideoMeetingConfigs$Builder;Lokio/ByteString;)V", "meeting_id", "", "getMeeting_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "meeting_no", "getMeeting_no", "creator_account", "", "getCreator_account", "()Ljava/lang/String;", "meeting_url", "getMeeting_url", "password", "getPassword", "is_editable", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "creator_user_id", "getCreator_user_id", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class ZoomVideoMeetingConfigs extends Message<ZoomVideoMeetingConfigs, a> {
        public static final ProtoAdapter<ZoomVideoMeetingConfigs> ADAPTER = null;
        public static final c Companion = null;
        private static final long serialVersionUID = 0;
        private final String creator_account;
        private final Long creator_user_id;
        private final Boolean is_editable;
        private final Long meeting_id;
        private final Long meeting_no;
        private final String meeting_url;
        private final String password;

        public static final class a extends Message.a<ZoomVideoMeetingConfigs, a> {
            public Long d;
            public Long e;
            public String f;
            public String g;
            public String h;
            public Boolean i;
            public Long j;

            @Override // com.lark.wire.Message.a
            public final Message b() {
                return new ZoomVideoMeetingConfigs(this, c(), null);
            }

            public a() {
            }
        }

        public static final class b extends ProtoAdapter<ZoomVideoMeetingConfigs> {
            @Override // com.lark.wire.ProtoAdapter
            public final ZoomVideoMeetingConfigs c(g0 r7) {
                Intrinsics.checkNotNullParameter(r7, "reader");
                a r1 = new a();
                long r2 = r7.c();
            L3:
                int r4 = r7.e();
                if (r4 == (-1)) goto L15;
                switch(r4) {
                    case 1: goto L13;
                    case 2: goto L12;
                    case 3: goto L11;
                    case 4: goto L10;
                    case 5: goto L9;
                    case 6: goto L8;
                    case 7: goto L7;
                    default: goto L6;
                };
            L7:
                r1.j = (Long) ProtoAdapter.k.c(r7);
                goto L3
            L8:
                r1.i = (Boolean) ProtoAdapter.g.c(r7);
                goto L3
            L9:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.h = r7.i();
                goto L3
            L10:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.g = r7.i();
                goto L3
            L11:
                ProtoAdapter.q.getClass();
                Intrinsics.checkNotNullParameter(r7, "reader");
                r1.f = r7.i();
                goto L3
            L12:
                r1.e = (Long) ProtoAdapter.k.c(r7);
                goto L3
            L13:
                r1.d = (Long) ProtoAdapter.k.c(r7);
                goto L3
            L6:
                r7.j(r4);
                Unit r5 = Unit.INSTANCE;
                goto L3
            L15:
                return new ZoomVideoMeetingConfigs(r1, r7.d(r2), null);
            }

            @Override // com.lark.wire.ProtoAdapter
            public final int k(ZoomVideoMeetingConfigs r6) {
                ZoomVideoMeetingConfigs r7 = r6;
                Intrinsics.checkNotNullParameter(r7, "value");
                int r0 = r7.unknownFields().size();
                t r1 = ProtoAdapter.k;
                int r2 = (r0 + r1.l(1, r7.getMeeting_id())) + r1.l(2, r7.getMeeting_no());
                w r3 = ProtoAdapter.q;
                return ((((r2 + r3.l(3, r7.getCreator_account())) + r3.l(4, r7.getMeeting_url())) + r3.l(5, r7.getPassword())) + ProtoAdapter.g.l(6, r7.is_editable())) + r1.l(7, r7.getCreator_user_id());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void f(j0 r5, ZoomVideoMeetingConfigs r6) {
                ZoomVideoMeetingConfigs r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                t r0 = ProtoAdapter.k;
                r0.i(r5, 1, r7.getMeeting_id());
                r0.i(r5, 2, r7.getMeeting_no());
                w r1 = ProtoAdapter.q;
                r1.i(r5, 3, r7.getCreator_account());
                r1.i(r5, 4, r7.getMeeting_url());
                r1.i(r5, 5, r7.getPassword());
                ProtoAdapter.g.i(r5, 6, r7.is_editable());
                r0.i(r5, 7, r7.getCreator_user_id());
                r5.a(r7.unknownFields());
            }

            @Override // com.lark.wire.ProtoAdapter
            public final void g(n0 r5, ZoomVideoMeetingConfigs r6) {
                ZoomVideoMeetingConfigs r7 = r6;
                Intrinsics.checkNotNullParameter(r5, "writer");
                Intrinsics.checkNotNullParameter(r7, "value");
                r5.d(r7.unknownFields());
                t r0 = ProtoAdapter.k;
                r0.j(r5, 7, r7.getCreator_user_id());
                ProtoAdapter.g.j(r5, 6, r7.is_editable());
                w r1 = ProtoAdapter.q;
                r1.j(r5, 5, r7.getPassword());
                r1.j(r5, 4, r7.getMeeting_url());
                r1.j(r5, 3, r7.getCreator_account());
                r0.j(r5, 2, r7.getMeeting_no());
                r0.j(r5, 1, r7.getMeeting_id());
            }

            public b(FieldEncoding r7, KClass<ZoomVideoMeetingConfigs> r8, Syntax r9) {
                super(r7, r8, "type.googleapis.com/calendar.v1.EventVideoMeetingConfig.ZoomVideoMeetingConfigs", r9, null);
            }
        }

        public static final class c {
            public c() {
            }
        }

        public /* synthetic */ ZoomVideoMeetingConfigs(a r1, ByteString r2, DefaultConstructorMarker r3) {
            this(r1, r2);
        }

        static {
            Companion = new c();
            ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(ZoomVideoMeetingConfigs.class), Syntax.PROTO_2);
        }

        @Override // com.lark.wire.Message
        public a newBuilder() {
            a r0 = new a();
            r0.d = this.meeting_id;
            r0.e = this.meeting_no;
            r0.f = this.creator_account;
            r0.g = this.meeting_url;
            r0.h = this.password;
            r0.i = this.is_editable;
            r0.j = this.creator_user_id;
            r0.a(unknownFields());
            return r0;
        }

        @Override // com.lark.wire.Message
        public String toString() {
            return Reflection.getOrCreateKotlinClass(ZoomVideoMeetingConfigs.class).getSimpleName() + '@' + hashCode();
        }

        public final String getCreator_account() {
            return this.creator_account;
        }

        public final Long getCreator_user_id() {
            return this.creator_user_id;
        }

        public final Long getMeeting_id() {
            return this.meeting_id;
        }

        public final Long getMeeting_no() {
            return this.meeting_no;
        }

        public final String getMeeting_url() {
            return this.meeting_url;
        }

        public final String getPassword() {
            return this.password;
        }

        public final Boolean is_editable() {
            return this.is_editable;
        }

        @Override // com.lark.wire.Message
        public /* bridge */ /* synthetic */ Message.a newBuilder() {
            return newBuilder();
        }

        public ZoomVideoMeetingConfigs(a r2, ByteString r3) {
            super(ADAPTER, r3);
            this.meeting_id = r2.d;
            this.meeting_no = r2.e;
            this.creator_account = r2.f;
            this.meeting_url = r2.g;
            this.password = r2.h;
            this.is_editable = r2.i;
            this.creator_user_id = r2.j;
        }

        public /* synthetic */ ZoomVideoMeetingConfigs(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = ByteString.EMPTY;
        L5:
            this(r1, r2);
        }
    }

    public static final class a extends Message.a<EventVideoMeetingConfig, a> {
        public VideoMeeting.VideoMeetingType d;
        public String e;
        public OtherVideoMeetingConfigs f;
        public GoogleVideoMeetingConfigs g;
        public ZoomVideoMeetingConfigs h;
        public ThirdPartyMeetingConfigs i;
        public LarkVCBindingData j;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new EventVideoMeetingConfig(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<EventVideoMeetingConfig> {
        @Override // com.lark.wire.ProtoAdapter
        public final EventVideoMeetingConfig c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            DefaultConstructorMarker r6 = null;
            if (r4 == (-1)) goto L24;
            if (r4 != 1) goto L8;
            r1.d = VideoMeeting.VideoMeetingType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L8:
            if (r4 != 2) goto L10;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.e = r10.i();
            goto L3
        L10:
            if (r4 != 3) goto L11;
            r1.j = LarkVCBindingData.ADAPTER.c(r10);
            goto L3
        L11:
            switch(r4) {
                case 101: goto L16;
                case 102: goto L15;
                case 103: goto L14;
                case 104: goto L13;
                default: goto L12;
            };
        L13:
            r1.i = ThirdPartyMeetingConfigs.ADAPTER.c(r10);
            r1.f = null;
            r1.g = null;
            r1.h = null;
            goto L3
        L14:
            r1.h = ZoomVideoMeetingConfigs.ADAPTER.c(r10);
            r1.f = null;
            r1.g = null;
            r1.i = null;
            goto L3
        L15:
            r1.g = GoogleVideoMeetingConfigs.ADAPTER.c(r10);
            r1.f = null;
            r1.h = null;
            r1.i = null;
            goto L3
        L16:
            r1.f = OtherVideoMeetingConfigs.ADAPTER.c(r10);
            r1.g = null;
            r1.h = null;
            r1.i = null;
            goto L3
        L12:
            r10.j(r4);
            Unit r7 = Unit.INSTANCE;
            goto L3
        L24:
            return new EventVideoMeetingConfig(r1, r10.d(r2), r6);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(EventVideoMeetingConfig r5) {
            EventVideoMeetingConfig r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return ((((((r6.unknownFields().size() + VideoMeeting.VideoMeetingType.ADAPTER.l(1, r6.getVideo_meeting_type())) + ProtoAdapter.q.l(2, r6.getMeeting_url())) + OtherVideoMeetingConfigs.ADAPTER.l(101, r6.getOther_configs())) + GoogleVideoMeetingConfigs.ADAPTER.l(102, r6.getGoogle_configs())) + ZoomVideoMeetingConfigs.ADAPTER.l(103, r6.getZoom_configs())) + ThirdPartyMeetingConfigs.ADAPTER.l(104, r6.getThird_party_configs())) + LarkVCBindingData.ADAPTER.l(3, r6.getLark_vc_binding_data());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, EventVideoMeetingConfig r5) {
            EventVideoMeetingConfig r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            VideoMeeting.VideoMeetingType.ADAPTER.i(r4, 1, r6.getVideo_meeting_type());
            ProtoAdapter.q.i(r4, 2, r6.getMeeting_url());
            LarkVCBindingData.ADAPTER.i(r4, 3, r6.getLark_vc_binding_data());
            OtherVideoMeetingConfigs.ADAPTER.i(r4, 101, r6.getOther_configs());
            GoogleVideoMeetingConfigs.ADAPTER.i(r4, 102, r6.getGoogle_configs());
            ZoomVideoMeetingConfigs.ADAPTER.i(r4, 103, r6.getZoom_configs());
            ThirdPartyMeetingConfigs.ADAPTER.i(r4, 104, r6.getThird_party_configs());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, EventVideoMeetingConfig r5) {
            EventVideoMeetingConfig r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ThirdPartyMeetingConfigs.ADAPTER.j(r4, 104, r6.getThird_party_configs());
            ZoomVideoMeetingConfigs.ADAPTER.j(r4, 103, r6.getZoom_configs());
            GoogleVideoMeetingConfigs.ADAPTER.j(r4, 102, r6.getGoogle_configs());
            OtherVideoMeetingConfigs.ADAPTER.j(r4, 101, r6.getOther_configs());
            LarkVCBindingData.ADAPTER.j(r4, 3, r6.getLark_vc_binding_data());
            ProtoAdapter.q.j(r4, 2, r6.getMeeting_url());
            VideoMeeting.VideoMeetingType.ADAPTER.j(r4, 1, r6.getVideo_meeting_type());
        }

        public b(FieldEncoding r7, KClass<EventVideoMeetingConfig> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.EventVideoMeetingConfig", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ EventVideoMeetingConfig(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(EventVideoMeetingConfig.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.video_meeting_type;
        r0.e = this.meeting_url;
        r0.f = this.other_configs;
        r0.g = this.google_configs;
        r0.h = this.zoom_configs;
        r0.i = this.third_party_configs;
        r0.j = this.lark_vc_binding_data;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(EventVideoMeetingConfig.class).getSimpleName() + '@' + hashCode();
    }

    public final GoogleVideoMeetingConfigs getGoogle_configs() {
        return this.google_configs;
    }

    public final LarkVCBindingData getLark_vc_binding_data() {
        return this.lark_vc_binding_data;
    }

    public final String getMeeting_url() {
        return this.meeting_url;
    }

    public final OtherVideoMeetingConfigs getOther_configs() {
        return this.other_configs;
    }

    public final ThirdPartyMeetingConfigs getThird_party_configs() {
        return this.third_party_configs;
    }

    public final VideoMeeting.VideoMeetingType getVideo_meeting_type() {
        return this.video_meeting_type;
    }

    public final ZoomVideoMeetingConfigs getZoom_configs() {
        return this.zoom_configs;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public EventVideoMeetingConfig(a r5, ByteString r6) {
        super(ADAPTER, r6);
        this.video_meeting_type = r5.d;
        this.meeting_url = r5.e;
        OtherVideoMeetingConfigs r7 = r5.f;
        this.other_configs = r7;
        GoogleVideoMeetingConfigs r0 = r5.g;
        this.google_configs = r0;
        ZoomVideoMeetingConfigs r1 = r5.h;
        this.zoom_configs = r1;
        ThirdPartyMeetingConfigs r2 = r5.i;
        this.third_party_configs = r2;
        this.lark_vc_binding_data = r5.j;
        boolean r8 = false;
        if (com.lark.wire.internal.a.b(r7, r0, r1, r2, new Object[0]) > 1) goto L5;
        r8 = true;
    L5:
        if (r8 == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("At most one of other_configs, google_configs, zoom_configs, third_party_configs may be non-null".toString());
    }

    public /* synthetic */ EventVideoMeetingConfig(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
