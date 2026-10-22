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
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 /2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0004./01B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010,\u001a\u00020\u0002H\u0016J\b\u0010-\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000e\u0010\u0010R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010 \u001a\u0004\u0018\u00010!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010$\u001a\u0004\u0018\u00010%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010(\u001a\u0004\u0018\u00010)¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u00062"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/VideoMeeting;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/VideoMeeting$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/VideoMeeting$Builder;Lokio/ByteString;)V", "unique_id", "", "getUnique_id", "()Ljava/lang/String;", "meeting_number", "getMeeting_number", "is_expired", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "meeting_url", "getMeeting_url", "video_meeting_type", "Lcom/lark/kmp/pb/calendar/v1/VideoMeeting$VideoMeetingType;", "getVideo_meeting_type", "()Lcom/lark/kmp/pb/calendar/v1/VideoMeeting$VideoMeetingType;", "lark_vc_binding_data", "Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$LarkVCBindingData;", "getLark_vc_binding_data", "()Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$LarkVCBindingData;", "other_configs", "Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$OtherVideoMeetingConfigs;", "getOther_configs", "()Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$OtherVideoMeetingConfigs;", "google_configs", "Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$GoogleVideoMeetingConfigs;", "getGoogle_configs", "()Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$GoogleVideoMeetingConfigs;", "zoom_configs", "Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$ZoomVideoMeetingConfigs;", "getZoom_configs", "()Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$ZoomVideoMeetingConfigs;", "third_party_configs", "Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$ThirdPartyMeetingConfigs;", "getThird_party_configs", "()Lcom/lark/kmp/pb/calendar/v1/EventVideoMeetingConfig$ThirdPartyMeetingConfigs;", "newBuilder", "toString", "Builder", "Companion", "Status", "VideoMeetingType", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class VideoMeeting extends Message<VideoMeeting, a> {
    public static final ProtoAdapter<VideoMeeting> ADAPTER = null;
    public static final c Companion = null;
    public static final boolean DEFAULT_IS_EXPIRED = false;
    public static final String DEFAULT_MEETING_NUMBER = "";
    private static final long serialVersionUID = 0;
    private final EventVideoMeetingConfig.GoogleVideoMeetingConfigs google_configs;
    private final Boolean is_expired;
    private final EventVideoMeetingConfig.LarkVCBindingData lark_vc_binding_data;
    private final String meeting_number;
    private final String meeting_url;
    private final EventVideoMeetingConfig.OtherVideoMeetingConfigs other_configs;
    private final EventVideoMeetingConfig.ThirdPartyMeetingConfigs third_party_configs;
    private final String unique_id;
    private final VideoMeetingType video_meeting_type;
    private final EventVideoMeetingConfig.ZoomVideoMeetingConfigs zoom_configs;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/VideoMeeting$Status;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "LIVE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Status extends Enum<Status> implements o0 {
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final b Companion = null;
        public static final Status LIVE = null;
        public static final Status UNKNOWN = null;
        public static final /* synthetic */ Status[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Status> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Status.Companion.getClass();
                if (r2 == 0) goto L9;
                if (r2 == 1) goto L11;
                return null;
            L11:
                return Status.LIVE;
            L9:
                return Status.UNKNOWN;
            }

            public a(KClass<Status> r1, Syntax r2, Status r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Status> getEntries() {
            return b;
        }

        static {
            Status r0 = new Status("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Status r1 = new Status("LIVE", 1, 1);
            LIVE = r1;
            Status[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Status.class), Syntax.PROTO_2, r0);
        }

        public static Status[] values() {
            return (Status[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Status fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L9;
            if (r1 == 1) goto L11;
            return null;
        L11:
            return LIVE;
        L9:
            return UNKNOWN;
        }

        public static Status valueOf(String r1) {
            return (Status) r27.a.a(Status.class, r1);
        }

        public Status(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00112\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/VideoMeeting$VideoMeetingType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_VIDEO_MEETING_TYPE", "VCHAT", "OTHER", "LARK_LIVE_HOST", "NO_VIDEO_MEETING", "GOOGLE_VIDEO_CONFERENCE", "ZOOM_VIDEO_MEETING", "THIRD_PARTY_MEETING", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum VideoMeetingType extends Enum<VideoMeetingType> implements o0 {
        public static final ProtoAdapter<VideoMeetingType> ADAPTER = null;
        public static final b Companion = null;
        public static final VideoMeetingType GOOGLE_VIDEO_CONFERENCE = null;
        public static final VideoMeetingType LARK_LIVE_HOST = null;
        public static final VideoMeetingType NO_VIDEO_MEETING = null;
        public static final VideoMeetingType OTHER = null;
        public static final VideoMeetingType THIRD_PARTY_MEETING = null;
        public static final VideoMeetingType UNKNOWN_VIDEO_MEETING_TYPE = null;
        public static final VideoMeetingType VCHAT = null;
        public static final VideoMeetingType ZOOM_VIDEO_MEETING = null;
        public static final /* synthetic */ VideoMeetingType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<VideoMeetingType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                VideoMeetingType.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<VideoMeetingType> r1, Syntax r2, VideoMeetingType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static VideoMeetingType a(int r0) {
                switch(r0) {
                    case 0: goto L12;
                    case 1: goto L20;
                    case 2: goto L19;
                    case 3: goto L18;
                    case 4: goto L17;
                    case 5: goto L16;
                    case 6: goto L15;
                    case 7: goto L14;
                    default: goto L3;
                };
            L3:
                return null;
            L14:
                return VideoMeetingType.THIRD_PARTY_MEETING;
            L15:
                return VideoMeetingType.ZOOM_VIDEO_MEETING;
            L16:
                return VideoMeetingType.GOOGLE_VIDEO_CONFERENCE;
            L17:
                return VideoMeetingType.NO_VIDEO_MEETING;
            L18:
                return VideoMeetingType.LARK_LIVE_HOST;
            L19:
                return VideoMeetingType.OTHER;
            L20:
                return VideoMeetingType.VCHAT;
            L12:
                return VideoMeetingType.UNKNOWN_VIDEO_MEETING_TYPE;
            }
        }

        @JvmStatic
        public static final VideoMeetingType fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<VideoMeetingType> getEntries() {
            return b;
        }

        static {
            VideoMeetingType r0 = new VideoMeetingType("UNKNOWN_VIDEO_MEETING_TYPE", 0, 0);
            UNKNOWN_VIDEO_MEETING_TYPE = r0;
            VideoMeetingType r1 = new VideoMeetingType("VCHAT", 1, 1);
            VCHAT = r1;
            VideoMeetingType r3 = new VideoMeetingType("OTHER", 2, 2);
            OTHER = r3;
            VideoMeetingType r5 = new VideoMeetingType("LARK_LIVE_HOST", 3, 3);
            LARK_LIVE_HOST = r5;
            VideoMeetingType r7 = new VideoMeetingType("NO_VIDEO_MEETING", 4, 4);
            NO_VIDEO_MEETING = r7;
            VideoMeetingType r9 = new VideoMeetingType("GOOGLE_VIDEO_CONFERENCE", 5, 5);
            GOOGLE_VIDEO_CONFERENCE = r9;
            VideoMeetingType r11 = new VideoMeetingType("ZOOM_VIDEO_MEETING", 6, 6);
            ZOOM_VIDEO_MEETING = r11;
            VideoMeetingType r13 = new VideoMeetingType("THIRD_PARTY_MEETING", 7, 7);
            THIRD_PARTY_MEETING = r13;
            VideoMeetingType[] r15 = {r0, r1, r3, r5, r7, r9, r11, r13};
            a = r15;
            b = EnumEntriesKt.enumEntries(r15);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(VideoMeetingType.class), Syntax.PROTO_2, r0);
        }

        public static VideoMeetingType[] values() {
            return (VideoMeetingType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static VideoMeetingType valueOf(String r1) {
            return (VideoMeetingType) r27.a.a(VideoMeetingType.class, r1);
        }

        public VideoMeetingType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends Message.a<VideoMeeting, a> {
        public String d;
        public String e;
        public Boolean f;
        public String g;
        public VideoMeetingType h;
        public EventVideoMeetingConfig.LarkVCBindingData i;
        public EventVideoMeetingConfig.OtherVideoMeetingConfigs j;
        public EventVideoMeetingConfig.GoogleVideoMeetingConfigs k;
        public EventVideoMeetingConfig.ZoomVideoMeetingConfigs l;
        public EventVideoMeetingConfig.ThirdPartyMeetingConfigs m;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new VideoMeeting(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<VideoMeeting> {
        @Override // com.lark.wire.ProtoAdapter
        public final VideoMeeting c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            DefaultConstructorMarker r6 = null;
            if (r4 == (-1)) goto L22;
            switch(r4) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L23;
                case 6: goto L8;
                default: goto L6;
            };
        L23:
            r1.h = VideoMeetingType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L11
        L11:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L8:
            r1.i = EventVideoMeetingConfig.LarkVCBindingData.ADAPTER.c(r10);
            goto L3
        L13:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.g = r10.i();
            goto L3
        L14:
            r1.f = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L15:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.e = r10.i();
            goto L3
        L16:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.d = r10.i();
            goto L3
        L6:
            switch(r4) {
                case 101: goto L20;
                case 102: goto L19;
                case 103: goto L18;
                case 104: goto L17;
                default: goto L7;
            };
        L17:
            r1.m = EventVideoMeetingConfig.ThirdPartyMeetingConfigs.ADAPTER.c(r10);
            r1.j = null;
            r1.k = null;
            r1.l = null;
            goto L3
        L18:
            r1.l = EventVideoMeetingConfig.ZoomVideoMeetingConfigs.ADAPTER.c(r10);
            r1.j = null;
            r1.k = null;
            r1.m = null;
            goto L3
        L19:
            r1.k = EventVideoMeetingConfig.GoogleVideoMeetingConfigs.ADAPTER.c(r10);
            r1.j = null;
            r1.l = null;
            r1.m = null;
            goto L3
        L20:
            r1.j = EventVideoMeetingConfig.OtherVideoMeetingConfigs.ADAPTER.c(r10);
            r1.k = null;
            r1.l = null;
            r1.m = null;
            goto L3
        L7:
            r10.j(r4);
            Unit r7 = Unit.INSTANCE;
            goto L3
        L22:
            return new VideoMeeting(r1, r10.d(r2), r6);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(VideoMeeting r6) {
            VideoMeeting r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            w r1 = ProtoAdapter.q;
            return (((((((((r0 + r1.l(1, r7.getUnique_id())) + r1.l(2, r7.getMeeting_number())) + ProtoAdapter.g.l(3, r7.is_expired())) + r1.l(4, r7.getMeeting_url())) + VideoMeetingType.ADAPTER.l(5, r7.getVideo_meeting_type())) + EventVideoMeetingConfig.LarkVCBindingData.ADAPTER.l(6, r7.getLark_vc_binding_data())) + EventVideoMeetingConfig.OtherVideoMeetingConfigs.ADAPTER.l(101, r7.getOther_configs())) + EventVideoMeetingConfig.GoogleVideoMeetingConfigs.ADAPTER.l(102, r7.getGoogle_configs())) + EventVideoMeetingConfig.ZoomVideoMeetingConfigs.ADAPTER.l(103, r7.getZoom_configs())) + EventVideoMeetingConfig.ThirdPartyMeetingConfigs.ADAPTER.l(104, r7.getThird_party_configs());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, VideoMeeting r6) {
            VideoMeeting r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r5, 1, r7.getUnique_id());
            r0.i(r5, 2, r7.getMeeting_number());
            ProtoAdapter.g.i(r5, 3, r7.is_expired());
            r0.i(r5, 4, r7.getMeeting_url());
            VideoMeetingType.ADAPTER.i(r5, 5, r7.getVideo_meeting_type());
            EventVideoMeetingConfig.LarkVCBindingData.ADAPTER.i(r5, 6, r7.getLark_vc_binding_data());
            EventVideoMeetingConfig.OtherVideoMeetingConfigs.ADAPTER.i(r5, 101, r7.getOther_configs());
            EventVideoMeetingConfig.GoogleVideoMeetingConfigs.ADAPTER.i(r5, 102, r7.getGoogle_configs());
            EventVideoMeetingConfig.ZoomVideoMeetingConfigs.ADAPTER.i(r5, 103, r7.getZoom_configs());
            EventVideoMeetingConfig.ThirdPartyMeetingConfigs.ADAPTER.i(r5, 104, r7.getThird_party_configs());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, VideoMeeting r6) {
            VideoMeeting r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            EventVideoMeetingConfig.ThirdPartyMeetingConfigs.ADAPTER.j(r5, 104, r7.getThird_party_configs());
            EventVideoMeetingConfig.ZoomVideoMeetingConfigs.ADAPTER.j(r5, 103, r7.getZoom_configs());
            EventVideoMeetingConfig.GoogleVideoMeetingConfigs.ADAPTER.j(r5, 102, r7.getGoogle_configs());
            EventVideoMeetingConfig.OtherVideoMeetingConfigs.ADAPTER.j(r5, 101, r7.getOther_configs());
            EventVideoMeetingConfig.LarkVCBindingData.ADAPTER.j(r5, 6, r7.getLark_vc_binding_data());
            VideoMeetingType.ADAPTER.j(r5, 5, r7.getVideo_meeting_type());
            w r0 = ProtoAdapter.q;
            r0.j(r5, 4, r7.getMeeting_url());
            ProtoAdapter.g.j(r5, 3, r7.is_expired());
            r0.j(r5, 2, r7.getMeeting_number());
            r0.j(r5, 1, r7.getUnique_id());
        }

        public b(FieldEncoding r7, KClass<VideoMeeting> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.VideoMeeting", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ VideoMeeting(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(VideoMeeting.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.unique_id;
        r0.e = this.meeting_number;
        r0.f = this.is_expired;
        r0.g = this.meeting_url;
        r0.h = this.video_meeting_type;
        r0.i = this.lark_vc_binding_data;
        r0.j = this.other_configs;
        r0.k = this.google_configs;
        r0.l = this.zoom_configs;
        r0.m = this.third_party_configs;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(VideoMeeting.class).getSimpleName() + '@' + hashCode();
    }

    public final EventVideoMeetingConfig.GoogleVideoMeetingConfigs getGoogle_configs() {
        return this.google_configs;
    }

    public final EventVideoMeetingConfig.LarkVCBindingData getLark_vc_binding_data() {
        return this.lark_vc_binding_data;
    }

    public final String getMeeting_number() {
        return this.meeting_number;
    }

    public final String getMeeting_url() {
        return this.meeting_url;
    }

    public final EventVideoMeetingConfig.OtherVideoMeetingConfigs getOther_configs() {
        return this.other_configs;
    }

    public final EventVideoMeetingConfig.ThirdPartyMeetingConfigs getThird_party_configs() {
        return this.third_party_configs;
    }

    public final String getUnique_id() {
        return this.unique_id;
    }

    public final VideoMeetingType getVideo_meeting_type() {
        return this.video_meeting_type;
    }

    public final EventVideoMeetingConfig.ZoomVideoMeetingConfigs getZoom_configs() {
        return this.zoom_configs;
    }

    public final Boolean is_expired() {
        return this.is_expired;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public VideoMeeting(a r5, ByteString r6) {
        super(ADAPTER, r6);
        this.unique_id = r5.d;
        this.meeting_number = r5.e;
        this.is_expired = r5.f;
        this.meeting_url = r5.g;
        this.video_meeting_type = r5.h;
        this.lark_vc_binding_data = r5.i;
        EventVideoMeetingConfig.OtherVideoMeetingConfigs r7 = r5.j;
        this.other_configs = r7;
        EventVideoMeetingConfig.GoogleVideoMeetingConfigs r0 = r5.k;
        this.google_configs = r0;
        EventVideoMeetingConfig.ZoomVideoMeetingConfigs r1 = r5.l;
        this.zoom_configs = r1;
        EventVideoMeetingConfig.ThirdPartyMeetingConfigs r8 = r5.m;
        this.third_party_configs = r8;
        boolean r2 = false;
        if (com.lark.wire.internal.a.b(r7, r0, r1, r8, new Object[0]) > 1) goto L5;
        r2 = true;
    L5:
        if (r2 == false) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("At most one of other_configs, google_configs, zoom_configs, third_party_configs may be non-null".toString());
    }

    public /* synthetic */ VideoMeeting(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
