package com.lark.kmp.pb.calendar.v1;

import com.lark.kmp.pb.basic.v1.ImageSet;
import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.lark.wire.s;
import com.lark.wire.t;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u001e\u0018\u0000 V2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003UVWB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010S\u001a\u00020\u0002H\u0016J\b\u0010T\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000bR\u0011\u0010\u0015\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000bR\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0017\u0010\u0019R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0019R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0015\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u001e\u0010&\u001a\u0004\u0018\u00010'8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0015\u0010,\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b-\u0010\u0011R\u0015\u0010.\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b/\u0010\u0011R\u0013\u00100\u001a\u0004\u0018\u000101¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u00104\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u000bR\u0013\u00106\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u000bR\u0015\u00108\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b8\u0010\u0019R\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020\u00000:¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<R\u0013\u0010=\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u000bR\u0013\u0010?\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u000bR\u0015\u0010A\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\bA\u0010\u0019R\u0013\u0010B\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u000bR\u0015\u0010D\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\bE\u0010\u0019R\u0015\u0010F\u001a\u0004\u0018\u00010\"¢\u0006\n\n\u0002\u0010%\u001a\u0004\bG\u0010$R\u0013\u0010H\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bI\u0010\u000bR\u0015\u0010J\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\bJ\u0010\u0019R\u0013\u0010K\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\u000bR\u0015\u0010M\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\bM\u0010\u0019R\u0013\u0010N\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bO\u0010\u000bR\u0015\u0010P\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\bP\u0010\u0019R\u0013\u0010Q\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\u000b¨\u0006X"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEventAttendee;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEventAttendee$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEventAttendee$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "key", "getKey", "original_time", "", "getOriginal_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "display_name", "getDisplay_name", "attendee_calendar_id", "getAttendee_calendar_id", "is_organizer", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "is_resource", "is_optional", "status", "Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEventAttendee$Status;", "getStatus", "()Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEventAttendee$Status;", "additional_guests_count", "", "getAdditional_guests_count", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "avatar", "Lcom/lark/kmp/pb/basic/v1/ImageSet;", "getAvatar$annotations", "()V", "getAvatar", "()Lcom/lark/kmp/pb/basic/v1/ImageSet;", "create_time", "getCreate_time", "update_time", "getUpdate_time", "type", "Lcom/lark/kmp/pb/calendar/v1/Calendar$Type;", "getType", "()Lcom/lark/kmp/pb/calendar/v1/Calendar$Type;", "tags", "getTags", "group_id", "getGroup_id", "is_group", "group_members", "", "getGroup_members", "()Ljava/util/List;", "avatar_key", "getAvatar_key", "localized_display_name", "getLocalized_display_name", "is_cross_tenant", "tenant_id", "getTenant_id", "open_security", "getOpen_security", "show_member_limit", "getShow_member_limit", "user_id", "getUser_id", "is_editable", "inviter_calendar_id", "getInviter_calendar_id", "is_disabled", "email", "getEmail", "is_third_party", "avatar_path", "getAvatar_path", "newBuilder", "toString", "Builder", "Companion", "Status", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class OldVersionCalendarEventAttendee extends Message<OldVersionCalendarEventAttendee, a> {
    public static final ProtoAdapter<OldVersionCalendarEventAttendee> ADAPTER = null;
    public static final c Companion = null;
    public static final int DEFAULT_ADDITIONAL_GUESTS_COUNT = 0;
    public static final String DEFAULT_AVATAR_PATH = "";
    public static final long DEFAULT_CREATE_TIME = 0;
    public static final String DEFAULT_DISPLAY_NAME = "";
    public static final String DEFAULT_EMAIL = "";
    public static final String DEFAULT_GROUP_ID = "";
    public static final String DEFAULT_INVITER_CALENDAR_ID = "";
    public static final boolean DEFAULT_IS_CROSS_TENANT = false;
    public static final boolean DEFAULT_IS_DISABLED = false;
    public static final boolean DEFAULT_IS_EDITABLE = false;
    public static final boolean DEFAULT_IS_GROUP = false;
    public static final boolean DEFAULT_IS_OPTIONAL = false;
    public static final boolean DEFAULT_IS_ORGANIZER = false;
    public static final boolean DEFAULT_IS_RESOURCE = false;
    public static final boolean DEFAULT_IS_THIRD_PARTY = false;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_LOCALIZED_DISPLAY_NAME = "";
    public static final boolean DEFAULT_OPEN_SECURITY = false;
    public static final long DEFAULT_ORIGINAL_TIME = 0;
    public static final int DEFAULT_SHOW_MEMBER_LIMIT = 0;
    public static final Status DEFAULT_STATUS = null;
    public static final String DEFAULT_TAGS = "";
    public static final String DEFAULT_TENANT_ID = "";
    public static final Calendar.Type DEFAULT_TYPE = null;
    public static final long DEFAULT_UPDATE_TIME = 0;
    public static final String DEFAULT_USER_ID = "";
    private static final long serialVersionUID = 0;
    private final Integer additional_guests_count;
    private final String attendee_calendar_id;
    private final ImageSet avatar;
    private final String avatar_key;
    private final String avatar_path;
    private final Long create_time;
    private final String display_name;
    private final String email;
    private final String group_id;
    private final List<OldVersionCalendarEventAttendee> group_members;
    private final String id;
    private final String inviter_calendar_id;
    private final Boolean is_cross_tenant;
    private final Boolean is_disabled;
    private final Boolean is_editable;
    private final Boolean is_group;
    private final Boolean is_optional;
    private final Boolean is_organizer;
    private final Boolean is_resource;
    private final Boolean is_third_party;
    private final String key;
    private final String localized_display_name;
    private final Boolean open_security;
    private final Long original_time;
    private final Integer show_member_limit;
    private final Status status;
    private final String tags;
    private final String tenant_id;
    private final Calendar.Type type;
    private final Long update_time;
    private final String user_id;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEventAttendee$Status;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NEEDS_ACTION", "ACCEPT", "TENTATIVE", "DECLINE", "REMOVED", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Status extends Enum<Status> implements o0 {
        public static final Status ACCEPT = null;
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final b Companion = null;
        public static final Status DECLINE = null;
        public static final Status NEEDS_ACTION = null;
        public static final Status REMOVED = null;
        public static final Status TENTATIVE = null;
        public static final /* synthetic */ Status[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Status> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Status.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<Status> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static Status a(int r1) {
                if (r1 == 1) goto L18;
                if (r1 == 2) goto L23;
                if (r1 == 3) goto L22;
                if (r1 == 4) goto L21;
                if (r1 == 5) goto L20;
                return null;
            L20:
                return Status.REMOVED;
            L21:
                return Status.DECLINE;
            L22:
                return Status.TENTATIVE;
            L23:
                return Status.ACCEPT;
            L18:
                return Status.NEEDS_ACTION;
            }
        }

        @JvmStatic
        public static final Status fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<Status> getEntries() {
            return b;
        }

        static {
            Status r0 = new Status("NEEDS_ACTION", 0, 1);
            NEEDS_ACTION = r0;
            Status r1 = new Status("ACCEPT", 1, 2);
            ACCEPT = r1;
            Status r4 = new Status("TENTATIVE", 2, 3);
            TENTATIVE = r4;
            Status r6 = new Status("DECLINE", 3, 4);
            DECLINE = r6;
            Status r8 = new Status("REMOVED", 4, 5);
            REMOVED = r8;
            Status[] r10 = {r0, r1, r4, r6, r8};
            a = r10;
            b = EnumEntriesKt.enumEntries(r10);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Status.class), Syntax.PROTO_2);
        }

        public static Status[] values() {
            return (Status[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static Status valueOf(String r1) {
            return (Status) r27.a.a(Status.class, r1);
        }

        public Status(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends Message.a<OldVersionCalendarEventAttendee, a> {
        public Integer A;
        public String B;
        public Boolean C;
        public String D;
        public Boolean E;
        public String F;
        public Boolean G;
        public String H;
        public String d;
        public String e;
        public Long f;
        public String g;
        public String h;
        public Boolean i;
        public Boolean j;
        public Boolean k;
        public Status l;
        public Integer m;
        public ImageSet n;
        public Long o;
        public Long p;
        public Calendar.Type q;
        public String r;
        public String s;
        public Boolean t;
        public List<OldVersionCalendarEventAttendee> u;
        public String v;
        public String w;
        public Boolean x;
        public String y;
        public Boolean z;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new OldVersionCalendarEventAttendee(this, c(), null);
        }

        public a() {
            this.u = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<OldVersionCalendarEventAttendee> {
        @Override // com.lark.wire.ProtoAdapter
        public final OldVersionCalendarEventAttendee c(g0 r11) {
            Intrinsics.checkNotNullParameter(r11, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            long r3 = r11.c();
        L3:
            int r5 = r11.e();
            if (r5 == (-1)) goto L44;
            switch(r5) {
                case 1: goto L43;
                case 2: goto L42;
                case 3: goto L41;
                case 4: goto L40;
                case 5: goto L39;
                case 6: goto L38;
                case 7: goto L37;
                case 8: goto L36;
                case 9: goto L46;
                case 10: goto L31;
                case 11: goto L30;
                case 12: goto L29;
                case 13: goto L28;
                case 14: goto L48;
                case 15: goto L23;
                case 16: goto L22;
                case 17: goto L21;
                case 18: goto L20;
                case 19: goto L19;
                case 20: goto L18;
                case 21: goto L17;
                case 22: goto L16;
                case 23: goto L15;
                case 24: goto L14;
                case 25: goto L13;
                case 26: goto L12;
                case 27: goto L11;
                case 28: goto L10;
                case 29: goto L9;
                case 30: goto L8;
                case 31: goto L7;
                default: goto L6;
            };
        L46:
            r1.l = Status.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L34
        L34:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r6 = Unit.INSTANCE;
            goto L3
        L48:
            r1.q = Calendar.Type.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L26
        L26:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r7 = Unit.INSTANCE;
            goto L3
        L7:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.H = r11.i();
            goto L3
        L8:
            r1.G = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L9:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.F = r11.i();
            goto L3
        L10:
            r1.E = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L11:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.D = r11.i();
            goto L3
        L12:
            r1.C = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L13:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.B = r11.i();
            goto L3
        L14:
            r1.A = (Integer) ProtoAdapter.h.c(r11);
            goto L3
        L15:
            r1.z = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L16:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.y = r11.i();
            goto L3
        L17:
            r1.x = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L18:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.w = r11.i();
            goto L3
        L19:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.v = r11.i();
            goto L3
        L20:
            r2.add(OldVersionCalendarEventAttendee.ADAPTER.c(r11));
            goto L3
        L21:
            r1.t = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L22:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.s = r11.i();
            goto L3
        L23:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.r = r11.i();
            goto L3
        L28:
            r1.p = (Long) ProtoAdapter.k.c(r11);
            goto L3
        L29:
            r1.o = (Long) ProtoAdapter.k.c(r11);
            goto L3
        L30:
            r1.n = ImageSet.ADAPTER.c(r11);
            goto L3
        L31:
            r1.m = (Integer) ProtoAdapter.h.c(r11);
            goto L3
        L36:
            r1.k = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L37:
            r1.j = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L38:
            r1.i = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L39:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            String r8 = r11.i();
            Intrinsics.checkNotNullParameter(r8, "attendee_calendar_id");
            r1.h = r8;
            goto L3
        L40:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.g = r11.i();
            goto L3
        L41:
            r1.f = (Long) ProtoAdapter.k.c(r11);
            goto L3
        L42:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.e = r11.i();
            goto L3
        L43:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            String r9 = r11.i();
            Intrinsics.checkNotNullParameter(r9, "id");
            r1.d = r9;
            goto L3
        L6:
            r11.j(r5);
            Unit r10 = Unit.INSTANCE;
            goto L3
        L44:
            ByteString r12 = r11.d(r3);
            Intrinsics.checkNotNullParameter(r2, "group_members");
            com.lark.wire.internal.a.a(r2);
            r1.u = r2;
            return new OldVersionCalendarEventAttendee(r1, r12, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(OldVersionCalendarEventAttendee r9) {
            OldVersionCalendarEventAttendee r10 = r9;
            Intrinsics.checkNotNullParameter(r10, "value");
            int r0 = r10.unknownFields().size();
            w r1 = ProtoAdapter.q;
            int r2 = (r0 + r1.l(1, r10.getId())) + r1.l(2, r10.getKey());
            t r3 = ProtoAdapter.k;
            int r4 = ((r2 + r3.l(3, r10.getOriginal_time())) + r1.l(4, r10.getDisplay_name())) + r1.l(5, r10.getAttendee_calendar_id());
            l r5 = ProtoAdapter.g;
            int r6 = (((r4 + r5.l(6, r10.is_organizer())) + r5.l(7, r10.is_resource())) + r5.l(8, r10.is_optional())) + Status.ADAPTER.l(9, r10.getStatus());
            s r7 = ProtoAdapter.h;
            return (((((((((((((((((((((r6 + r7.l(10, r10.getAdditional_guests_count())) + ImageSet.ADAPTER.l(11, r10.getAvatar())) + r3.l(12, r10.getCreate_time())) + r3.l(13, r10.getUpdate_time())) + Calendar.Type.ADAPTER.l(14, r10.getType())) + r1.l(15, r10.getTags())) + r1.l(16, r10.getGroup_id())) + r5.l(17, r10.is_group())) + OldVersionCalendarEventAttendee.ADAPTER.a().l(18, r10.getGroup_members())) + r1.l(19, r10.getAvatar_key())) + r1.l(20, r10.getLocalized_display_name())) + r5.l(21, r10.is_cross_tenant())) + r1.l(22, r10.getTenant_id())) + r5.l(23, r10.getOpen_security())) + r7.l(24, r10.getShow_member_limit())) + r1.l(25, r10.getUser_id())) + r5.l(26, r10.is_editable())) + r1.l(27, r10.getInviter_calendar_id())) + r5.l(28, r10.is_disabled())) + r1.l(29, r10.getEmail())) + r5.l(30, r10.is_third_party())) + r1.l(31, r10.getAvatar_path());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r8, OldVersionCalendarEventAttendee r9) {
            OldVersionCalendarEventAttendee r10 = r9;
            Intrinsics.checkNotNullParameter(r8, "writer");
            Intrinsics.checkNotNullParameter(r10, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r8, 1, r10.getId());
            r0.i(r8, 2, r10.getKey());
            t r1 = ProtoAdapter.k;
            r1.i(r8, 3, r10.getOriginal_time());
            r0.i(r8, 4, r10.getDisplay_name());
            r0.i(r8, 5, r10.getAttendee_calendar_id());
            l r2 = ProtoAdapter.g;
            r2.i(r8, 6, r10.is_organizer());
            r2.i(r8, 7, r10.is_resource());
            r2.i(r8, 8, r10.is_optional());
            Status.ADAPTER.i(r8, 9, r10.getStatus());
            s r3 = ProtoAdapter.h;
            r3.i(r8, 10, r10.getAdditional_guests_count());
            ImageSet.ADAPTER.i(r8, 11, r10.getAvatar());
            r1.i(r8, 12, r10.getCreate_time());
            r1.i(r8, 13, r10.getUpdate_time());
            Calendar.Type.ADAPTER.i(r8, 14, r10.getType());
            r0.i(r8, 15, r10.getTags());
            r0.i(r8, 16, r10.getGroup_id());
            r2.i(r8, 17, r10.is_group());
            OldVersionCalendarEventAttendee.ADAPTER.a().i(r8, 18, r10.getGroup_members());
            r0.i(r8, 19, r10.getAvatar_key());
            r0.i(r8, 20, r10.getLocalized_display_name());
            r2.i(r8, 21, r10.is_cross_tenant());
            r0.i(r8, 22, r10.getTenant_id());
            r2.i(r8, 23, r10.getOpen_security());
            r3.i(r8, 24, r10.getShow_member_limit());
            r0.i(r8, 25, r10.getUser_id());
            r2.i(r8, 26, r10.is_editable());
            r0.i(r8, 27, r10.getInviter_calendar_id());
            r2.i(r8, 28, r10.is_disabled());
            r0.i(r8, 29, r10.getEmail());
            r2.i(r8, 30, r10.is_third_party());
            r0.i(r8, 31, r10.getAvatar_path());
            r8.a(r10.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r8, OldVersionCalendarEventAttendee r9) {
            OldVersionCalendarEventAttendee r10 = r9;
            Intrinsics.checkNotNullParameter(r8, "writer");
            Intrinsics.checkNotNullParameter(r10, "value");
            r8.d(r10.unknownFields());
            w r0 = ProtoAdapter.q;
            r0.j(r8, 31, r10.getAvatar_path());
            l r1 = ProtoAdapter.g;
            r1.j(r8, 30, r10.is_third_party());
            r0.j(r8, 29, r10.getEmail());
            r1.j(r8, 28, r10.is_disabled());
            r0.j(r8, 27, r10.getInviter_calendar_id());
            r1.j(r8, 26, r10.is_editable());
            r0.j(r8, 25, r10.getUser_id());
            s r2 = ProtoAdapter.h;
            r2.j(r8, 24, r10.getShow_member_limit());
            r1.j(r8, 23, r10.getOpen_security());
            r0.j(r8, 22, r10.getTenant_id());
            r1.j(r8, 21, r10.is_cross_tenant());
            r0.j(r8, 20, r10.getLocalized_display_name());
            r0.j(r8, 19, r10.getAvatar_key());
            OldVersionCalendarEventAttendee.ADAPTER.a().j(r8, 18, r10.getGroup_members());
            r1.j(r8, 17, r10.is_group());
            r0.j(r8, 16, r10.getGroup_id());
            r0.j(r8, 15, r10.getTags());
            Calendar.Type.ADAPTER.j(r8, 14, r10.getType());
            t r3 = ProtoAdapter.k;
            r3.j(r8, 13, r10.getUpdate_time());
            r3.j(r8, 12, r10.getCreate_time());
            ImageSet.ADAPTER.j(r8, 11, r10.getAvatar());
            r2.j(r8, 10, r10.getAdditional_guests_count());
            Status.ADAPTER.j(r8, 9, r10.getStatus());
            r1.j(r8, 8, r10.is_optional());
            r1.j(r8, 7, r10.is_resource());
            r1.j(r8, 6, r10.is_organizer());
            r0.j(r8, 5, r10.getAttendee_calendar_id());
            r0.j(r8, 4, r10.getDisplay_name());
            r3.j(r8, 3, r10.getOriginal_time());
            r0.j(r8, 2, r10.getKey());
            r0.j(r8, 1, r10.getId());
        }

        public b(FieldEncoding r7, KClass<OldVersionCalendarEventAttendee> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.OldVersionCalendarEventAttendee", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ OldVersionCalendarEventAttendee(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    @Deprecated(message = "avatar is deprecated")
    public static /* synthetic */ void getAvatar$annotations() {
    }

    static {
        Companion = new c();
        DEFAULT_STATUS = Status.NEEDS_ACTION;
        DEFAULT_TYPE = Calendar.Type.PRIMARY;
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(OldVersionCalendarEventAttendee.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.key;
        r0.f = this.original_time;
        r0.g = this.display_name;
        r0.h = this.attendee_calendar_id;
        r0.i = this.is_organizer;
        r0.j = this.is_resource;
        r0.k = this.is_optional;
        r0.l = this.status;
        r0.m = this.additional_guests_count;
        r0.n = this.avatar;
        r0.o = this.create_time;
        r0.p = this.update_time;
        r0.q = this.type;
        r0.r = this.tags;
        r0.s = this.group_id;
        r0.t = this.is_group;
        r0.u = this.group_members;
        r0.v = this.avatar_key;
        r0.w = this.localized_display_name;
        r0.x = this.is_cross_tenant;
        r0.y = this.tenant_id;
        r0.z = this.open_security;
        r0.A = this.show_member_limit;
        r0.B = this.user_id;
        r0.C = this.is_editable;
        r0.D = this.inviter_calendar_id;
        r0.E = this.is_disabled;
        r0.F = this.email;
        r0.G = this.is_third_party;
        r0.H = this.avatar_path;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(OldVersionCalendarEventAttendee.class).getSimpleName() + '@' + hashCode();
    }

    public final Integer getAdditional_guests_count() {
        return this.additional_guests_count;
    }

    public final String getAttendee_calendar_id() {
        return this.attendee_calendar_id;
    }

    public final ImageSet getAvatar() {
        return this.avatar;
    }

    public final String getAvatar_key() {
        return this.avatar_key;
    }

    public final String getAvatar_path() {
        return this.avatar_path;
    }

    public final Long getCreate_time() {
        return this.create_time;
    }

    public final String getDisplay_name() {
        return this.display_name;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getGroup_id() {
        return this.group_id;
    }

    public final List<OldVersionCalendarEventAttendee> getGroup_members() {
        return this.group_members;
    }

    public final String getId() {
        return this.id;
    }

    public final String getInviter_calendar_id() {
        return this.inviter_calendar_id;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getLocalized_display_name() {
        return this.localized_display_name;
    }

    public final Boolean getOpen_security() {
        return this.open_security;
    }

    public final Long getOriginal_time() {
        return this.original_time;
    }

    public final Integer getShow_member_limit() {
        return this.show_member_limit;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final String getTags() {
        return this.tags;
    }

    public final String getTenant_id() {
        return this.tenant_id;
    }

    public final Calendar.Type getType() {
        return this.type;
    }

    public final Long getUpdate_time() {
        return this.update_time;
    }

    public final String getUser_id() {
        return this.user_id;
    }

    public final Boolean is_cross_tenant() {
        return this.is_cross_tenant;
    }

    public final Boolean is_disabled() {
        return this.is_disabled;
    }

    public final Boolean is_editable() {
        return this.is_editable;
    }

    public final Boolean is_group() {
        return this.is_group;
    }

    public final Boolean is_optional() {
        return this.is_optional;
    }

    public final Boolean is_organizer() {
        return this.is_organizer;
    }

    public final Boolean is_resource() {
        return this.is_resource;
    }

    public final Boolean is_third_party() {
        return this.is_third_party;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public OldVersionCalendarEventAttendee(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.id = r4;
        this.key = r2.e;
        this.original_time = r2.f;
        this.display_name = r2.g;
        String r5 = r2.h;
        Intrinsics.checkNotNull(r5);
        this.attendee_calendar_id = r5;
        this.is_organizer = r2.i;
        this.is_resource = r2.j;
        this.is_optional = r2.k;
        this.status = r2.l;
        this.additional_guests_count = r2.m;
        this.avatar = r2.n;
        this.create_time = r2.o;
        this.update_time = r2.p;
        this.type = r2.q;
        this.tags = r2.r;
        this.group_id = r2.s;
        this.is_group = r2.t;
        this.group_members = com.lark.wire.internal.a.c("group_members", r2.u);
        this.avatar_key = r2.v;
        this.localized_display_name = r2.w;
        this.is_cross_tenant = r2.x;
        this.tenant_id = r2.y;
        this.open_security = r2.z;
        this.show_member_limit = r2.A;
        this.user_id = r2.B;
        this.is_editable = r2.C;
        this.inviter_calendar_id = r2.D;
        this.is_disabled = r2.E;
        this.email = r2.F;
        this.is_third_party = r2.G;
        this.avatar_path = r2.H;
    }

    public /* synthetic */ OldVersionCalendarEventAttendee(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
