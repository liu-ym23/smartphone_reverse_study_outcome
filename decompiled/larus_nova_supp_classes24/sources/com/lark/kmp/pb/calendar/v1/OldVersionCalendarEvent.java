package com.lark.kmp.pb.calendar.v1;

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
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 ¯\u00012\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0016®\u0001¯\u0001°\u0001±\u0001²\u0001³\u0001´\u0001µ\u0001¶\u0001·\u0001¸\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010¬\u0001\u001a\u00020\u0002H\u0016J\t\u0010\u00ad\u0001\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000bR\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000bR\u0015\u0010 \u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0015\u0010%\u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010$\u001a\u0004\b%\u0010#R\u0015\u0010&\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0015\u0010*\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0002\u0010)\u001a\u0004\b+\u0010(R\u0015\u0010,\u001a\u0004\u0018\u00010\u001b¢\u0006\n\n\u0002\u0010)\u001a\u0004\b-\u0010(R\u0015\u0010.\u001a\u0004\u0018\u00010/¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0013\u00103\u001a\u0004\u0018\u000104¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u00107\u001a\u0004\u0018\u000108¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0015\u0010;\u001a\u0004\u0018\u00010/¢\u0006\n\n\u0002\u00102\u001a\u0004\b<\u00101R\u0013\u0010=\u001a\u0004\u0018\u00010>¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0015\u0010A\u001a\u0004\u0018\u00010/¢\u0006\n\n\u0002\u00102\u001a\u0004\bB\u00101R\u0015\u0010C\u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010$\u001a\u0004\bD\u0010#R\u0011\u0010E\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u000bR\u0013\u0010G\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u000bR\u0011\u0010I\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0011\u0010K\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\u001dR\u0011\u0010M\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bN\u0010\u000bR\u0011\u0010O\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\u001dR\u0011\u0010Q\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\u000bR\u0013\u0010S\u001a\u0004\u0018\u00010T¢\u0006\b\n\u0000\u001a\u0004\bU\u0010VR\u0013\u0010W\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bX\u0010\u000bR\u0015\u0010Y\u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010$\u001a\u0004\bZ\u0010#R\u0015\u0010[\u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\\\u0010#R\u0015\u0010]\u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010$\u001a\u0004\b^\u0010#R\u0013\u0010_\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b`\u0010\u000bR\u0013\u0010a\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\bb\u0010\u000bR\u0013\u0010c\u001a\u0004\u0018\u00010d¢\u0006\b\n\u0000\u001a\u0004\be\u0010fR\u0015\u0010g\u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010$\u001a\u0004\bh\u0010#R\u0015\u0010i\u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010$\u001a\u0004\bj\u0010#R\u0015\u0010k\u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u0010$\u001a\u0004\bk\u0010#R\u0013\u0010l\u001a\u0004\u0018\u00010m¢\u0006\b\n\u0000\u001a\u0004\bn\u0010oR\u0013\u0010p\u001a\u0004\u0018\u00010m¢\u0006\b\n\u0000\u001a\u0004\bq\u0010oR\u0017\u0010r\u001a\b\u0012\u0004\u0012\u00020m0s¢\u0006\b\n\u0000\u001a\u0004\bt\u0010uR\u0017\u0010v\u001a\b\u0012\u0004\u0012\u00020w0s¢\u0006\b\n\u0000\u001a\u0004\bx\u0010uR\u0013\u0010y\u001a\u0004\u0018\u00010z¢\u0006\b\n\u0000\u001a\u0004\b{\u0010|R\u0014\u0010}\u001a\u0004\u0018\u00010~¢\u0006\t\n\u0000\u001a\u0005\b\u007f\u0010\u0080\u0001R\u0016\u0010\u0081\u0001\u001a\u0004\u0018\u00010~¢\u0006\n\n\u0000\u001a\u0006\b\u0082\u0001\u0010\u0080\u0001R\u0017\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0017\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0015\u0010\u008b\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b\u008c\u0001\u0010\u000bR\u0017\u0010\u008d\u0001\u001a\u0004\u0018\u00010!¢\u0006\u000b\n\u0002\u0010$\u001a\u0005\b\u008d\u0001\u0010#R\u0017\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u008e\u0001\u0010\u0090\u0001R\u0017\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u0092\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0015\u0010\u0095\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b\u0096\u0001\u0010\u000bR\u0015\u0010\u0097\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b\u0098\u0001\u0010\u000bR\u0015\u0010\u0099\u0001\u001a\u0004\u0018\u00010m¢\u0006\t\n\u0000\u001a\u0005\b\u009a\u0001\u0010oR\u0017\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0017\u0010\u009f\u0001\u001a\u0004\u0018\u00010!¢\u0006\u000b\n\u0002\u0010$\u001a\u0005\b\u009f\u0001\u0010#R\u0017\u0010 \u0001\u001a\u0004\u0018\u00010!¢\u0006\u000b\n\u0002\u0010$\u001a\u0005\b¡\u0001\u0010#R\u0017\u0010¢\u0001\u001a\u0004\u0018\u00010!¢\u0006\u000b\n\u0002\u0010$\u001a\u0005\b£\u0001\u0010#R\u0017\u0010¤\u0001\u001a\u0004\u0018\u00010!¢\u0006\u000b\n\u0002\u0010$\u001a\u0005\b¥\u0001\u0010#R\u0017\u0010¦\u0001\u001a\u0005\u0018\u00010§\u0001¢\u0006\n\n\u0000\u001a\u0006\b¨\u0001\u0010©\u0001R\u0015\u0010ª\u0001\u001a\u0004\u0018\u00010\t¢\u0006\t\n\u0000\u001a\u0005\b«\u0001\u0010\u000b¨\u0006¹\u0001"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEvent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEvent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEvent$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "creator_calendar_id", "getCreator_calendar_id", "calendar_id", "getCalendar_id", "organizer_calendar_id", "getOrganizer_calendar_id", "server_id", "getServer_id", "self_attendee_status", "Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEventAttendee$Status;", "getSelf_attendee_status", "()Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEventAttendee$Status;", "key", "getKey", "original_time", "", "getOriginal_time", "()J", "original_event_key", "getOriginal_event_key", "original_is_all_day", "", "getOriginal_is_all_day", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "is_free", "last_date", "getLast_date", "()Ljava/lang/Long;", "Ljava/lang/Long;", "create_time", "getCreate_time", "update_time", "getUpdate_time", "color", "", "getColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "source", "Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEvent$Source;", "getSource", "()Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEvent$Source;", "visibility", "Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEvent$Visibility;", "getVisibility", "()Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEvent$Visibility;", "importance", "getImportance", "dirty_type", "Lcom/lark/kmp/pb/calendar/v1/CalendarDirtyType;", "getDirty_type", "()Lcom/lark/kmp/pb/calendar/v1/CalendarDirtyType;", "version", "getVersion", "need_update", "getNeed_update", "summary", "getSummary", "description", "getDescription", "is_all_day", "()Z", "start_time", "getStart_time", "start_timezone", "getStart_timezone", "end_time", "getEnd_time", "end_timezone", "getEnd_timezone", "status", "Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEvent$Status;", "getStatus", "()Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEvent$Status;", "rrule", "getRrule", "guest_can_invite", "getGuest_can_invite", "guest_can_see_other_guests", "getGuest_can_see_other_guests", "guest_can_modify", "getGuest_can_modify", "audio_url", "getAudio_url", "url", "getUrl", "location", "Lcom/lark/kmp/pb/calendar/v1/CalendarLocation;", "getLocation", "()Lcom/lark/kmp/pb/calendar/v1/CalendarLocation;", "has_alarm", "getHas_alarm", "has_attendee", "getHas_attendee", "is_scheduled", "creator", "Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEventAttendee;", "getCreator", "()Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEventAttendee;", "organizer", "getOrganizer", "attendees", "", "getAttendees", "()Ljava/util/List;", "reminders", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventReminder;", "getReminders", "display_type", "Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEvent$DisplayType;", "getDisplay_type", "()Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEvent$DisplayType;", "event_color", "Lcom/lark/kmp/pb/calendar/v1/MappingColor;", "getEvent_color", "()Lcom/lark/kmp/pb/calendar/v1/MappingColor;", "cal_color", "getCal_color", "conflict_type", "Lcom/lark/kmp/pb/calendar/v1/ConflictType;", "getConflict_type", "()Lcom/lark/kmp/pb/calendar/v1/ConflictType;", "type", "Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEvent$Type;", "getType", "()Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEvent$Type;", "meeting_id", "getMeeting_id", "is_editable", "is_deletable", "Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEvent$Deletable;", "()Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEvent$Deletable;", "sharability", "Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEvent$Sharability;", "getSharability", "()Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEvent$Sharability;", "docs_description", "getDocs_description", "successor_calendar_id", "getSuccessor_calendar_id", "successor", "getSuccessor", "notification_type", "Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEvent$NotificationType;", "getNotification_type", "()Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEvent$NotificationType;", "is_cross_tenant", "will_creator_attend", "getWill_creator_attend", "will_organizer_attend", "getWill_organizer_attend", "will_successor_attend", "getWill_successor_attend", "video_meeting", "Lcom/lark/kmp/pb/calendar/v1/VideoMeeting;", "getVideo_meeting", "()Lcom/lark/kmp/pb/calendar/v1/VideoMeeting;", "meeting_minute_url", "getMeeting_minute_url", "newBuilder", "toString", "Builder", "Companion", "Source", "Visibility", "Status", "Span", "DisplayType", "Type", "Deletable", "Sharability", "NotificationType", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class OldVersionCalendarEvent extends Message<OldVersionCalendarEvent, a> {
    public static final ProtoAdapter<OldVersionCalendarEvent> ADAPTER = null;
    public static final c Companion = null;
    public static final String DEFAULT_AUDIO_URL = "";
    public static final int DEFAULT_COLOR = -1;
    public static final ConflictType DEFAULT_CONFLICT_TYPE = null;
    public static final long DEFAULT_CREATE_TIME = 0;
    public static final String DEFAULT_DESCRIPTION = "";
    public static final CalendarDirtyType DEFAULT_DIRTY_TYPE = null;
    public static final DisplayType DEFAULT_DISPLAY_TYPE = null;
    public static final String DEFAULT_DOCS_DESCRIPTION = "";
    public static final boolean DEFAULT_GUEST_CAN_INVITE = true;
    public static final boolean DEFAULT_GUEST_CAN_MODIFY = false;
    public static final boolean DEFAULT_GUEST_CAN_SEE_OTHER_GUESTS = true;
    public static final boolean DEFAULT_HAS_ALARM = false;
    public static final boolean DEFAULT_HAS_ATTENDEE = false;
    public static final int DEFAULT_IMPORTANCE = 0;
    public static final boolean DEFAULT_IS_CROSS_TENANT = false;
    public static final Deletable DEFAULT_IS_DELETABLE = null;
    public static final boolean DEFAULT_IS_EDITABLE = false;
    public static final boolean DEFAULT_IS_FREE = false;
    public static final boolean DEFAULT_IS_SCHEDULED = false;
    public static final long DEFAULT_LAST_DATE = 0;
    public static final String DEFAULT_MEETING_ID = "";
    public static final boolean DEFAULT_NEED_UPDATE = false;
    public static final NotificationType DEFAULT_NOTIFICATION_TYPE = null;
    public static final String DEFAULT_ORIGINAL_EVENT_KEY = "";
    public static final boolean DEFAULT_ORIGINAL_IS_ALL_DAY = false;
    public static final String DEFAULT_RRULE = "";
    public static final OldVersionCalendarEventAttendee.Status DEFAULT_SELF_ATTENDEE_STATUS = null;
    public static final String DEFAULT_SERVER_ID = "";
    public static final Sharability DEFAULT_SHARABILITY = null;
    public static final Source DEFAULT_SOURCE = null;
    public static final Status DEFAULT_STATUS = null;
    public static final String DEFAULT_SUCCESSOR_CALENDAR_ID = "";
    public static final Type DEFAULT_TYPE = null;
    public static final long DEFAULT_UPDATE_TIME = 0;
    public static final String DEFAULT_URL = "";
    public static final int DEFAULT_VERSION = 0;
    public static final Visibility DEFAULT_VISIBILITY = null;
    public static final boolean DEFAULT_WILL_CREATOR_ATTEND = false;
    public static final boolean DEFAULT_WILL_ORGANIZER_ATTEND = false;
    public static final boolean DEFAULT_WILL_SUCCESSOR_ATTEND = false;
    private static final long serialVersionUID = 0;
    private final List<OldVersionCalendarEventAttendee> attendees;
    private final String audio_url;
    private final MappingColor cal_color;
    private final String calendar_id;
    private final Integer color;
    private final ConflictType conflict_type;
    private final Long create_time;
    private final OldVersionCalendarEventAttendee creator;
    private final String creator_calendar_id;
    private final String description;
    private final CalendarDirtyType dirty_type;
    private final DisplayType display_type;
    private final String docs_description;
    private final long end_time;
    private final String end_timezone;
    private final MappingColor event_color;
    private final Boolean guest_can_invite;
    private final Boolean guest_can_modify;
    private final Boolean guest_can_see_other_guests;
    private final Boolean has_alarm;
    private final Boolean has_attendee;
    private final String id;
    private final Integer importance;
    private final boolean is_all_day;
    private final Boolean is_cross_tenant;
    private final Deletable is_deletable;
    private final Boolean is_editable;
    private final Boolean is_free;
    private final Boolean is_scheduled;
    private final String key;
    private final Long last_date;
    private final CalendarLocation location;
    private final String meeting_id;
    private final String meeting_minute_url;
    private final Boolean need_update;
    private final NotificationType notification_type;
    private final OldVersionCalendarEventAttendee organizer;
    private final String organizer_calendar_id;
    private final String original_event_key;
    private final Boolean original_is_all_day;
    private final long original_time;
    private final List<CalendarEventReminder> reminders;
    private final String rrule;
    private final OldVersionCalendarEventAttendee.Status self_attendee_status;
    private final String server_id;
    private final Sharability sharability;
    private final Source source;
    private final long start_time;
    private final String start_timezone;
    private final Status status;
    private final OldVersionCalendarEventAttendee successor;
    private final String successor_calendar_id;
    private final String summary;
    private final Type type;
    private final Long update_time;
    private final String url;
    private final Integer version;
    private final VideoMeeting video_meeting;
    private final Visibility visibility;
    private final Boolean will_creator_attend;
    private final Boolean will_organizer_attend;
    private final Boolean will_successor_attend;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEvent$Deletable;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NOT", "SELF", "ALL", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Deletable extends Enum<Deletable> implements o0 {
        public static final ProtoAdapter<Deletable> ADAPTER = null;
        public static final Deletable ALL = null;
        public static final b Companion = null;
        public static final Deletable NOT = null;
        public static final Deletable SELF = null;
        public static final /* synthetic */ Deletable[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Deletable> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Deletable.Companion.getClass();
                if (r2 == 1) goto L12;
                if (r2 == 2) goto L15;
                if (r2 == 3) goto L14;
                return null;
            L14:
                return Deletable.ALL;
            L15:
                return Deletable.SELF;
            L12:
                return Deletable.NOT;
            }

            public a(KClass<Deletable> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Deletable> getEntries() {
            return b;
        }

        static {
            Deletable r0 = new Deletable("NOT", 0, 1);
            NOT = r0;
            Deletable r1 = new Deletable("SELF", 1, 2);
            SELF = r1;
            Deletable r4 = new Deletable("ALL", 2, 3);
            ALL = r4;
            Deletable[] r6 = {r0, r1, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Deletable.class), Syntax.PROTO_2);
        }

        public static Deletable[] values() {
            return (Deletable[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Deletable fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L15;
            if (r1 == 3) goto L14;
            return null;
        L14:
            return ALL;
        L15:
            return SELF;
        L12:
            return NOT;
        }

        public static Deletable valueOf(String r1) {
            return (Deletable) r27.a.a(Deletable.class, r1);
        }

        public Deletable(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEvent$DisplayType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "INVISIBLE", "LIMITED", "FULL", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum DisplayType extends Enum<DisplayType> implements o0 {
        public static final ProtoAdapter<DisplayType> ADAPTER = null;
        public static final b Companion = null;
        public static final DisplayType FULL = null;
        public static final DisplayType INVISIBLE = null;
        public static final DisplayType LIMITED = null;
        public static final /* synthetic */ DisplayType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<DisplayType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                DisplayType.Companion.getClass();
                if (r2 == 1) goto L12;
                if (r2 == 2) goto L15;
                if (r2 == 3) goto L14;
                return null;
            L14:
                return DisplayType.FULL;
            L15:
                return DisplayType.LIMITED;
            L12:
                return DisplayType.INVISIBLE;
            }

            public a(KClass<DisplayType> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<DisplayType> getEntries() {
            return b;
        }

        static {
            DisplayType r0 = new DisplayType("INVISIBLE", 0, 1);
            INVISIBLE = r0;
            DisplayType r1 = new DisplayType("LIMITED", 1, 2);
            LIMITED = r1;
            DisplayType r4 = new DisplayType("FULL", 2, 3);
            FULL = r4;
            DisplayType[] r6 = {r0, r1, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(DisplayType.class), Syntax.PROTO_2);
        }

        public static DisplayType[] values() {
            return (DisplayType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final DisplayType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L15;
            if (r1 == 3) goto L14;
            return null;
        L14:
            return FULL;
        L15:
            return LIMITED;
        L12:
            return INVISIBLE;
        }

        public static DisplayType valueOf(String r1) {
            return (DisplayType) r27.a.a(DisplayType.class, r1);
        }

        public DisplayType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEvent$NotificationType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT_NOTIFICATION_TYPE", "NO_NOTIFICATION", "SEND_NOTIFICATION", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum NotificationType extends Enum<NotificationType> implements o0 {
        public static final ProtoAdapter<NotificationType> ADAPTER = null;
        public static final b Companion = null;
        public static final NotificationType DEFAULT_NOTIFICATION_TYPE = null;
        public static final NotificationType NO_NOTIFICATION = null;
        public static final NotificationType SEND_NOTIFICATION = null;
        public static final /* synthetic */ NotificationType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<NotificationType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                NotificationType.Companion.getClass();
                if (r2 == 1) goto L12;
                if (r2 == 2) goto L15;
                if (r2 == 3) goto L14;
                return null;
            L14:
                return NotificationType.SEND_NOTIFICATION;
            L15:
                return NotificationType.NO_NOTIFICATION;
            L12:
                return NotificationType.DEFAULT_NOTIFICATION_TYPE;
            }

            public a(KClass<NotificationType> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<NotificationType> getEntries() {
            return b;
        }

        static {
            NotificationType r0 = new NotificationType("DEFAULT_NOTIFICATION_TYPE", 0, 1);
            DEFAULT_NOTIFICATION_TYPE = r0;
            NotificationType r1 = new NotificationType("NO_NOTIFICATION", 1, 2);
            NO_NOTIFICATION = r1;
            NotificationType r4 = new NotificationType("SEND_NOTIFICATION", 2, 3);
            SEND_NOTIFICATION = r4;
            NotificationType[] r6 = {r0, r1, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(NotificationType.class), Syntax.PROTO_2);
        }

        public static NotificationType[] values() {
            return (NotificationType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final NotificationType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L15;
            if (r1 == 3) goto L14;
            return null;
        L14:
            return SEND_NOTIFICATION;
        L15:
            return NO_NOTIFICATION;
        L12:
            return DEFAULT_NOTIFICATION_TYPE;
        }

        public static NotificationType valueOf(String r1) {
            return (NotificationType) r27.a.a(NotificationType.class, r1);
        }

        public NotificationType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEvent$Sharability;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FORBIDDEN_NOT_ACCESSIBLE", "FORBIDDEN_PRIVATE", "SHARABLE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Sharability extends Enum<Sharability> implements o0 {
        public static final ProtoAdapter<Sharability> ADAPTER = null;
        public static final b Companion = null;
        public static final Sharability FORBIDDEN_NOT_ACCESSIBLE = null;
        public static final Sharability FORBIDDEN_PRIVATE = null;
        public static final Sharability SHARABLE = null;
        public static final /* synthetic */ Sharability[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Sharability> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Sharability.Companion.getClass();
                if (r2 == 1) goto L12;
                if (r2 == 2) goto L15;
                if (r2 == 3) goto L14;
                return null;
            L14:
                return Sharability.SHARABLE;
            L15:
                return Sharability.FORBIDDEN_PRIVATE;
            L12:
                return Sharability.FORBIDDEN_NOT_ACCESSIBLE;
            }

            public a(KClass<Sharability> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Sharability> getEntries() {
            return b;
        }

        static {
            Sharability r0 = new Sharability("FORBIDDEN_NOT_ACCESSIBLE", 0, 1);
            FORBIDDEN_NOT_ACCESSIBLE = r0;
            Sharability r1 = new Sharability("FORBIDDEN_PRIVATE", 1, 2);
            FORBIDDEN_PRIVATE = r1;
            Sharability r4 = new Sharability("SHARABLE", 2, 3);
            SHARABLE = r4;
            Sharability[] r6 = {r0, r1, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Sharability.class), Syntax.PROTO_2);
        }

        public static Sharability[] values() {
            return (Sharability[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Sharability fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L15;
            if (r1 == 3) goto L14;
            return null;
        L14:
            return SHARABLE;
        L15:
            return FORBIDDEN_PRIVATE;
        L12:
            return FORBIDDEN_NOT_ACCESSIBLE;
        }

        public static Sharability valueOf(String r1) {
            return (Sharability) r27.a.a(Sharability.class, r1);
        }

        public Sharability(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00122\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEvent$Source;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_SOURCE", "WEB", "IOS", "IOS_APP", "ANDROID", "ANDROID_APP", "PC_CLIENT", "GOOGLE", "PEOPLE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Source extends Enum<Source> implements o0 {
        public static final ProtoAdapter<Source> ADAPTER = null;
        public static final Source ANDROID = null;
        public static final Source ANDROID_APP = null;
        public static final b Companion = null;
        public static final Source GOOGLE = null;
        public static final Source IOS = null;
        public static final Source IOS_APP = null;
        public static final Source PC_CLIENT = null;
        public static final Source PEOPLE = null;
        public static final Source UNKNOWN_SOURCE = null;
        public static final Source WEB = null;
        public static final /* synthetic */ Source[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Source> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Source.Companion.getClass();
                return b.a(r2);
            }

            public a(KClass<Source> r1, Syntax r2, Source r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }

            @JvmStatic
            public static Source a(int r0) {
                switch(r0) {
                    case 0: goto L13;
                    case 1: goto L22;
                    case 2: goto L21;
                    case 3: goto L20;
                    case 4: goto L19;
                    case 5: goto L18;
                    case 6: goto L17;
                    case 7: goto L16;
                    case 8: goto L15;
                    default: goto L3;
                };
            L3:
                return null;
            L15:
                return Source.PEOPLE;
            L16:
                return Source.GOOGLE;
            L17:
                return Source.PC_CLIENT;
            L18:
                return Source.ANDROID_APP;
            L19:
                return Source.ANDROID;
            L20:
                return Source.IOS_APP;
            L21:
                return Source.IOS;
            L22:
                return Source.WEB;
            L13:
                return Source.UNKNOWN_SOURCE;
            }
        }

        @JvmStatic
        public static final Source fromValue(int r1) {
            Companion.getClass();
            return b.a(r1);
        }

        public static EnumEntries<Source> getEntries() {
            return b;
        }

        static {
            Source r0 = new Source("UNKNOWN_SOURCE", 0, 0);
            UNKNOWN_SOURCE = r0;
            Source r1 = new Source("WEB", 1, 1);
            WEB = r1;
            Source r3 = new Source("IOS", 2, 2);
            IOS = r3;
            Source r5 = new Source("IOS_APP", 3, 3);
            IOS_APP = r5;
            Source r7 = new Source("ANDROID", 4, 4);
            ANDROID = r7;
            Source r9 = new Source("ANDROID_APP", 5, 5);
            ANDROID_APP = r9;
            Source r11 = new Source("PC_CLIENT", 6, 6);
            PC_CLIENT = r11;
            Source r13 = new Source("GOOGLE", 7, 7);
            GOOGLE = r13;
            Source r15 = new Source("PEOPLE", 8, 8);
            PEOPLE = r15;
            Source[] r14 = {r0, r1, r3, r5, r7, r9, r11, r13, r15};
            a = r14;
            b = EnumEntriesKt.enumEntries(r14);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Source.class), Syntax.PROTO_2, r0);
        }

        public static Source[] values() {
            return (Source[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        public static Source valueOf(String r1) {
            return (Source) r27.a.a(Source.class, r1);
        }

        public Source(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEvent$Span;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NONE_SPAN", "THIS_EVENT", "FUTURE_EVENTS", "ALL_EVENTS", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Span extends Enum<Span> implements o0 {
        public static final ProtoAdapter<Span> ADAPTER = null;
        public static final Span ALL_EVENTS = null;
        public static final b Companion = null;
        public static final Span FUTURE_EVENTS = null;
        public static final Span NONE_SPAN = null;
        public static final Span THIS_EVENT = null;
        public static final /* synthetic */ Span[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Span> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Span.Companion.getClass();
                if (r2 == 0) goto L15;
                if (r2 == 1) goto L19;
                if (r2 == 2) goto L18;
                if (r2 == 3) goto L17;
                return null;
            L17:
                return Span.ALL_EVENTS;
            L18:
                return Span.FUTURE_EVENTS;
            L19:
                return Span.THIS_EVENT;
            L15:
                return Span.NONE_SPAN;
            }

            public a(KClass<Span> r1, Syntax r2, Span r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Span> getEntries() {
            return b;
        }

        static {
            Span r0 = new Span("NONE_SPAN", 0, 0);
            NONE_SPAN = r0;
            Span r1 = new Span("THIS_EVENT", 1, 1);
            THIS_EVENT = r1;
            Span r3 = new Span("FUTURE_EVENTS", 2, 2);
            FUTURE_EVENTS = r3;
            Span r5 = new Span("ALL_EVENTS", 3, 3);
            ALL_EVENTS = r5;
            Span[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Span.class), Syntax.PROTO_2, r0);
        }

        public static Span[] values() {
            return (Span[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Span fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L17;
            return null;
        L17:
            return ALL_EVENTS;
        L18:
            return FUTURE_EVENTS;
        L19:
            return THIS_EVENT;
        L15:
            return NONE_SPAN;
        }

        public static Span valueOf(String r1) {
            return (Span) r27.a.a(Span.class, r1);
        }

        public Span(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEvent$Status;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "TENTATIVE", "CONFIRMED", "CANCELED", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Status extends Enum<Status> implements o0 {
        public static final ProtoAdapter<Status> ADAPTER = null;
        public static final Status CANCELED = null;
        public static final Status CONFIRMED = null;
        public static final b Companion = null;
        public static final Status TENTATIVE = null;
        public static final /* synthetic */ Status[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Status> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Status.Companion.getClass();
                if (r2 == 1) goto L12;
                if (r2 == 2) goto L15;
                if (r2 == 3) goto L14;
                return null;
            L14:
                return Status.CANCELED;
            L15:
                return Status.CONFIRMED;
            L12:
                return Status.TENTATIVE;
            }

            public a(KClass<Status> r2, Syntax r3) {
                super(r2, r3, null);
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
            Status r0 = new Status("TENTATIVE", 0, 1);
            TENTATIVE = r0;
            Status r1 = new Status("CONFIRMED", 1, 2);
            CONFIRMED = r1;
            Status r4 = new Status("CANCELED", 2, 3);
            CANCELED = r4;
            Status[] r6 = {r0, r1, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
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

        @JvmStatic
        public static final Status fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L15;
            if (r1 == 3) goto L14;
            return null;
        L14:
            return CANCELED;
        L15:
            return CONFIRMED;
        L12:
            return TENTATIVE;
        }

        public static Status valueOf(String r1) {
            return (Status) r27.a.a(Status.class, r1);
        }

        public Status(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEvent$Type;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT_TYPE", "MEETING", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Type extends Enum<Type> implements o0 {
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final b Companion = null;
        public static final Type DEFAULT_TYPE = null;
        public static final Type MEETING = null;
        public static final /* synthetic */ Type[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Type> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Type.Companion.getClass();
                if (r2 == 1) goto L9;
                if (r2 == 2) goto L11;
                return null;
            L11:
                return Type.MEETING;
            L9:
                return Type.DEFAULT_TYPE;
            }

            public a(KClass<Type> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Type> getEntries() {
            return b;
        }

        static {
            Type r0 = new Type("DEFAULT_TYPE", 0, 1);
            DEFAULT_TYPE = r0;
            Type r1 = new Type("MEETING", 1, 2);
            MEETING = r1;
            Type[] r4 = {r0, r1};
            a = r4;
            b = EnumEntriesKt.enumEntries(r4);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Type.class), Syntax.PROTO_2);
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Type fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L9;
            if (r1 == 2) goto L11;
            return null;
        L11:
            return MEETING;
        L9:
            return DEFAULT_TYPE;
        }

        public static Type valueOf(String r1) {
            return (Type) r27.a.a(Type.class, r1);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/OldVersionCalendarEvent$Visibility;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "PUBLIC", "PRIVATE", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Visibility extends Enum<Visibility> implements o0 {
        public static final ProtoAdapter<Visibility> ADAPTER = null;
        public static final b Companion = null;
        public static final Visibility DEFAULT = null;
        public static final Visibility PRIVATE = null;
        public static final Visibility PUBLIC = null;
        public static final /* synthetic */ Visibility[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Visibility> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Visibility.Companion.getClass();
                if (r2 == 1) goto L12;
                if (r2 == 2) goto L15;
                if (r2 == 3) goto L14;
                return null;
            L14:
                return Visibility.PRIVATE;
            L15:
                return Visibility.PUBLIC;
            L12:
                return Visibility.DEFAULT;
            }

            public a(KClass<Visibility> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Visibility> getEntries() {
            return b;
        }

        static {
            Visibility r0 = new Visibility("DEFAULT", 0, 1);
            DEFAULT = r0;
            Visibility r1 = new Visibility("PUBLIC", 1, 2);
            PUBLIC = r1;
            Visibility r4 = new Visibility("PRIVATE", 2, 3);
            PRIVATE = r4;
            Visibility[] r6 = {r0, r1, r4};
            a = r6;
            b = EnumEntriesKt.enumEntries(r6);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Visibility.class), Syntax.PROTO_2);
        }

        public static Visibility[] values() {
            return (Visibility[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Visibility fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L15;
            if (r1 == 3) goto L14;
            return null;
        L14:
            return PRIVATE;
        L15:
            return PUBLIC;
        L12:
            return DEFAULT;
        }

        public static Visibility valueOf(String r1) {
            return (Visibility) r27.a.a(Visibility.class, r1);
        }

        public Visibility(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends Message.a<OldVersionCalendarEvent, a> {
        public Boolean A;
        public Long B;
        public String C;
        public Long D;
        public String E;
        public Status F;
        public String G;
        public Boolean H;
        public Boolean I;
        public Boolean J;
        public String K;
        public String L;
        public CalendarLocation M;
        public Boolean N;
        public Boolean O;
        public Boolean P;
        public OldVersionCalendarEventAttendee Q;
        public OldVersionCalendarEventAttendee R;
        public List<OldVersionCalendarEventAttendee> S;
        public List<CalendarEventReminder> T;
        public DisplayType U;
        public MappingColor V;
        public MappingColor W;
        public ConflictType X;
        public Type Y;
        public String Z;
        public Boolean a0;
        public Deletable b0;
        public Sharability c0;
        public String d;
        public String d0;
        public String e;
        public String e0;
        public String f;
        public OldVersionCalendarEventAttendee f0;
        public String g;
        public NotificationType g0;
        public String h;
        public Boolean h0;
        public OldVersionCalendarEventAttendee.Status i;
        public Boolean i0;
        public String j;
        public Boolean j0;
        public Long k;
        public Boolean k0;
        public String l;
        public VideoMeeting l0;
        public Boolean m;
        public String m0;
        public Boolean n;
        public Long o;
        public Long p;
        public Long q;
        public Integer r;
        public Source s;
        public Visibility t;
        public Integer u;
        public CalendarDirtyType v;
        public Integer w;
        public Boolean x;
        public String y;
        public String z;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new OldVersionCalendarEvent(this, c(), null);
        }

        public a() {
            this.S = CollectionsKt.emptyList();
            this.T = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<OldVersionCalendarEvent> {
        @Override // com.lark.wire.ProtoAdapter
        public final OldVersionCalendarEvent c(g0 r12) {
            Intrinsics.checkNotNullParameter(r12, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            ArrayList r3 = new ArrayList();
            long r4 = r12.c();
        L3:
            int r6 = r12.e();
            if (r6 == (-1)) goto L102;
            switch(r6) {
                case 1: goto L101;
                case 2: goto L100;
                case 3: goto L99;
                case 4: goto L98;
                case 5: goto L97;
                case 6: goto L118;
                case 7: goto L92;
                case 8: goto L91;
                case 9: goto L90;
                case 10: goto L89;
                case 11: goto L88;
                case 12: goto L87;
                case 13: goto L86;
                case 14: goto L85;
                case 15: goto L84;
                case 16: goto L122;
                case 17: goto L104;
                case 18: goto L75;
                case 19: goto L114;
                case 20: goto L70;
                case 21: goto L69;
                case 22: goto L68;
                case 23: goto L67;
                case 24: goto L66;
                case 25: goto L65;
                case 26: goto L64;
                case 27: goto L63;
                case 28: goto L62;
                case 29: goto L110;
                case 30: goto L57;
                case 31: goto L56;
                case 32: goto L55;
                case 33: goto L54;
                case 34: goto L53;
                case 35: goto L52;
                case 36: goto L51;
                case 37: goto L50;
                case 38: goto L49;
                case 39: goto L48;
                case 40: goto L47;
                case 41: goto L46;
                case 42: goto L45;
                case 43: goto L44;
                case 44: goto L112;
                case 45: goto L39;
                case 46: goto L38;
                case 47: goto L106;
                case 48: goto L108;
                case 49: goto L29;
                case 50: goto L28;
                case 51: goto L120;
                case 52: goto L124;
                case 53: goto L19;
                case 54: goto L18;
                case 55: goto L17;
                case 56: goto L116;
                case 57: goto L12;
                case 58: goto L11;
                case 59: goto L10;
                case 60: goto L9;
                case 61: goto L8;
                case 62: goto L7;
                default: goto L6;
            };
        L104:
            r1.t = Visibility.ADAPTER.c(r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L78
        L78:
            e = move-exception;
            r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r7 = Unit.INSTANCE;
            goto L3
        L106:
            r1.X = ConflictType.ADAPTER.c(r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L36
        L36:
            e = move-exception;
            r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r8 = Unit.INSTANCE;
            goto L3
        L108:
            r1.Y = Type.ADAPTER.c(r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L32
        L32:
            e = move-exception;
            r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r9 = Unit.INSTANCE;
            goto L3
        L110:
            r1.F = Status.ADAPTER.c(r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L60
        L60:
            e = move-exception;
            r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r10 = Unit.INSTANCE;
            goto L3
        L112:
            r1.U = DisplayType.ADAPTER.c(r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L42
        L42:
            e = move-exception;
            r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r11 = Unit.INSTANCE;
            goto L3
        L114:
            r1.v = CalendarDirtyType.ADAPTER.c(r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L73
        L73:
            e = move-exception;
            r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r13 = Unit.INSTANCE;
            goto L3
        L116:
            r1.g0 = NotificationType.ADAPTER.c(r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r14 = Unit.INSTANCE;
            goto L3
        L118:
            r1.i = OldVersionCalendarEventAttendee.Status.ADAPTER.c(r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L95
        L95:
            e = move-exception;
            r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r15 = Unit.INSTANCE;
            goto L3
        L120:
            r1.b0 = Deletable.ADAPTER.c(r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L26
        L26:
            e = move-exception;
            r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r16 = Unit.INSTANCE;
            goto L3
        L122:
            r1.s = Source.ADAPTER.c(r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L82
        L82:
            e = move-exception;
            r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r17 = Unit.INSTANCE;
            goto L3
        L124:
            r1.c0 = Sharability.ADAPTER.c(r12);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r12.a(r6, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r19 = Unit.INSTANCE;
            goto L3
        L7:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.m0 = r12.i();
            goto L3
        L8:
            r1.l0 = VideoMeeting.ADAPTER.c(r12);
            goto L3
        L9:
            r1.k0 = (Boolean) ProtoAdapter.g.c(r12);
            goto L3
        L10:
            r1.j0 = (Boolean) ProtoAdapter.g.c(r12);
            goto L3
        L11:
            r1.i0 = (Boolean) ProtoAdapter.g.c(r12);
            goto L3
        L12:
            r1.h0 = (Boolean) ProtoAdapter.g.c(r12);
            goto L3
        L17:
            r1.f0 = OldVersionCalendarEventAttendee.ADAPTER.c(r12);
            goto L3
        L18:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.e0 = r12.i();
            goto L3
        L19:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.d0 = r12.i();
            goto L3
        L28:
            r1.a0 = (Boolean) ProtoAdapter.g.c(r12);
            goto L3
        L29:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.Z = r12.i();
            goto L3
        L38:
            r1.W = MappingColor.ADAPTER.c(r12);
            goto L3
        L39:
            r1.V = MappingColor.ADAPTER.c(r12);
            goto L3
        L44:
            r3.add(CalendarEventReminder.ADAPTER.c(r12));
            goto L3
        L45:
            r2.add(OldVersionCalendarEventAttendee.ADAPTER.c(r12));
            goto L3
        L46:
            r1.R = OldVersionCalendarEventAttendee.ADAPTER.c(r12);
            goto L3
        L47:
            r1.Q = OldVersionCalendarEventAttendee.ADAPTER.c(r12);
            goto L3
        L48:
            r1.P = (Boolean) ProtoAdapter.g.c(r12);
            goto L3
        L49:
            r1.O = (Boolean) ProtoAdapter.g.c(r12);
            goto L3
        L50:
            r1.N = (Boolean) ProtoAdapter.g.c(r12);
            goto L3
        L51:
            r1.M = CalendarLocation.ADAPTER.c(r12);
            goto L3
        L52:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.L = r12.i();
            goto L3
        L53:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.K = r12.i();
            goto L3
        L54:
            r1.J = (Boolean) ProtoAdapter.g.c(r12);
            goto L3
        L55:
            r1.I = (Boolean) ProtoAdapter.g.c(r12);
            goto L3
        L56:
            r1.H = (Boolean) ProtoAdapter.g.c(r12);
            goto L3
        L57:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.G = r12.i();
            goto L3
        L62:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            String r20 = r12.i();
            Intrinsics.checkNotNullParameter(r20, "end_timezone");
            r1.E = r20;
            goto L3
        L63:
            r1.D = Long.valueOf(((Number) ProtoAdapter.k.c(r12)).longValue());
            goto L3
        L64:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            String r21 = r12.i();
            Intrinsics.checkNotNullParameter(r21, "start_timezone");
            r1.C = r21;
            goto L3
        L65:
            r1.B = Long.valueOf(((Number) ProtoAdapter.k.c(r12)).longValue());
            goto L3
        L66:
            r1.A = Boolean.valueOf(((Boolean) ProtoAdapter.g.c(r12)).booleanValue());
            goto L3
        L67:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.z = r12.i();
            goto L3
        L68:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            String r22 = r12.i();
            Intrinsics.checkNotNullParameter(r22, "summary");
            r1.y = r22;
            goto L3
        L69:
            r1.x = (Boolean) ProtoAdapter.g.c(r12);
            goto L3
        L70:
            r1.w = (Integer) ProtoAdapter.h.c(r12);
            goto L3
        L75:
            r1.u = (Integer) ProtoAdapter.h.c(r12);
            goto L3
        L84:
            r1.r = (Integer) ProtoAdapter.h.c(r12);
            goto L3
        L85:
            r1.q = (Long) ProtoAdapter.k.c(r12);
            goto L3
        L86:
            r1.p = (Long) ProtoAdapter.k.c(r12);
            goto L3
        L87:
            r1.o = (Long) ProtoAdapter.k.c(r12);
            goto L3
        L88:
            r1.n = (Boolean) ProtoAdapter.g.c(r12);
            goto L3
        L89:
            r1.m = (Boolean) ProtoAdapter.g.c(r12);
            goto L3
        L90:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.l = r12.i();
            goto L3
        L91:
            r1.k = Long.valueOf(((Number) ProtoAdapter.k.c(r12)).longValue());
            goto L3
        L92:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            String r23 = r12.i();
            Intrinsics.checkNotNullParameter(r23, "key");
            r1.j = r23;
            goto L3
        L97:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            r1.h = r12.i();
            goto L3
        L98:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            String r24 = r12.i();
            Intrinsics.checkNotNullParameter(r24, "organizer_calendar_id");
            r1.g = r24;
            goto L3
        L99:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            String r25 = r12.i();
            Intrinsics.checkNotNullParameter(r25, "calendar_id");
            r1.f = r25;
            goto L3
        L100:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            String r26 = r12.i();
            Intrinsics.checkNotNullParameter(r26, "creator_calendar_id");
            r1.e = r26;
            goto L3
        L101:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r12, "reader");
            String r27 = r12.i();
            Intrinsics.checkNotNullParameter(r27, "id");
            r1.d = r27;
            goto L3
        L6:
            r12.j(r6);
            Unit r29 = Unit.INSTANCE;
            goto L3
        L102:
            ByteString r110 = r12.d(r4);
            Intrinsics.checkNotNullParameter(r2, "attendees");
            com.lark.wire.internal.a.a(r2);
            r1.S = r2;
            Intrinsics.checkNotNullParameter(r3, "reminders");
            com.lark.wire.internal.a.a(r3);
            r1.T = r3;
            return new OldVersionCalendarEvent(r1, r110, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(OldVersionCalendarEvent r9) {
            OldVersionCalendarEvent r10 = r9;
            Intrinsics.checkNotNullParameter(r10, "value");
            int r0 = r10.unknownFields().size();
            w r1 = ProtoAdapter.q;
            int r2 = ((((((r0 + r1.l(1, r10.getId())) + r1.l(2, r10.getCreator_calendar_id())) + r1.l(3, r10.getCalendar_id())) + r1.l(4, r10.getOrganizer_calendar_id())) + r1.l(5, r10.getServer_id())) + OldVersionCalendarEventAttendee.Status.ADAPTER.l(6, r10.getSelf_attendee_status())) + r1.l(7, r10.getKey());
            t r3 = ProtoAdapter.k;
            int r4 = (r2 + r3.l(8, Long.valueOf(r10.getOriginal_time()))) + r1.l(9, r10.getOriginal_event_key());
            l r5 = ProtoAdapter.g;
            int r6 = ((((r4 + r5.l(10, r10.getOriginal_is_all_day())) + r5.l(11, r10.is_free())) + r3.l(12, r10.getLast_date())) + r3.l(13, r10.getCreate_time())) + r3.l(14, r10.getUpdate_time());
            s r7 = ProtoAdapter.h;
            int r8 = ((((((((((((((((((((((((r6 + r7.l(15, r10.getColor())) + Source.ADAPTER.l(16, r10.getSource())) + Visibility.ADAPTER.l(17, r10.getVisibility())) + r7.l(18, r10.getImportance())) + CalendarDirtyType.ADAPTER.l(19, r10.getDirty_type())) + r7.l(20, r10.getVersion())) + r5.l(21, r10.getNeed_update())) + r1.l(22, r10.getSummary())) + r1.l(23, r10.getDescription())) + r5.l(24, Boolean.valueOf(r10.is_all_day()))) + r3.l(25, Long.valueOf(r10.getStart_time()))) + r1.l(26, r10.getStart_timezone())) + r3.l(27, Long.valueOf(r10.getEnd_time()))) + r1.l(28, r10.getEnd_timezone())) + Status.ADAPTER.l(29, r10.getStatus())) + r1.l(30, r10.getRrule())) + r5.l(31, r10.getGuest_can_invite())) + r5.l(32, r10.getGuest_can_see_other_guests())) + r5.l(33, r10.getGuest_can_modify())) + r1.l(34, r10.getAudio_url())) + r1.l(35, r10.getUrl())) + CalendarLocation.ADAPTER.l(36, r10.getLocation())) + r5.l(37, r10.getHas_alarm())) + r5.l(38, r10.getHas_attendee())) + r5.l(39, r10.is_scheduled());
            ProtoAdapter<OldVersionCalendarEventAttendee> r11 = OldVersionCalendarEventAttendee.ADAPTER;
            int r12 = ((((r8 + r11.l(40, r10.getCreator())) + r11.l(41, r10.getOrganizer())) + r11.a().l(42, r10.getAttendees())) + CalendarEventReminder.ADAPTER.a().l(43, r10.getReminders())) + DisplayType.ADAPTER.l(44, r10.getDisplay_type());
            ProtoAdapter<MappingColor> r13 = MappingColor.ADAPTER;
            return (((((((((((((((((r12 + r13.l(45, r10.getEvent_color())) + r13.l(46, r10.getCal_color())) + ConflictType.ADAPTER.l(47, r10.getConflict_type())) + Type.ADAPTER.l(48, r10.getType())) + r1.l(49, r10.getMeeting_id())) + r5.l(50, r10.is_editable())) + Deletable.ADAPTER.l(51, r10.is_deletable())) + Sharability.ADAPTER.l(52, r10.getSharability())) + r1.l(53, r10.getDocs_description())) + r1.l(54, r10.getSuccessor_calendar_id())) + r11.l(55, r10.getSuccessor())) + NotificationType.ADAPTER.l(56, r10.getNotification_type())) + r5.l(57, r10.is_cross_tenant())) + r5.l(58, r10.getWill_creator_attend())) + r5.l(59, r10.getWill_organizer_attend())) + r5.l(60, r10.getWill_successor_attend())) + VideoMeeting.ADAPTER.l(61, r10.getVideo_meeting())) + r1.l(62, r10.getMeeting_minute_url());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r8, OldVersionCalendarEvent r9) {
            OldVersionCalendarEvent r10 = r9;
            Intrinsics.checkNotNullParameter(r8, "writer");
            Intrinsics.checkNotNullParameter(r10, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r8, 1, r10.getId());
            r0.i(r8, 2, r10.getCreator_calendar_id());
            r0.i(r8, 3, r10.getCalendar_id());
            r0.i(r8, 4, r10.getOrganizer_calendar_id());
            r0.i(r8, 5, r10.getServer_id());
            OldVersionCalendarEventAttendee.Status.ADAPTER.i(r8, 6, r10.getSelf_attendee_status());
            r0.i(r8, 7, r10.getKey());
            t r1 = ProtoAdapter.k;
            r1.i(r8, 8, Long.valueOf(r10.getOriginal_time()));
            r0.i(r8, 9, r10.getOriginal_event_key());
            l r2 = ProtoAdapter.g;
            r2.i(r8, 10, r10.getOriginal_is_all_day());
            r2.i(r8, 11, r10.is_free());
            r1.i(r8, 12, r10.getLast_date());
            r1.i(r8, 13, r10.getCreate_time());
            r1.i(r8, 14, r10.getUpdate_time());
            s r3 = ProtoAdapter.h;
            r3.i(r8, 15, r10.getColor());
            Source.ADAPTER.i(r8, 16, r10.getSource());
            Visibility.ADAPTER.i(r8, 17, r10.getVisibility());
            r3.i(r8, 18, r10.getImportance());
            CalendarDirtyType.ADAPTER.i(r8, 19, r10.getDirty_type());
            r3.i(r8, 20, r10.getVersion());
            r2.i(r8, 21, r10.getNeed_update());
            r0.i(r8, 22, r10.getSummary());
            r0.i(r8, 23, r10.getDescription());
            r2.i(r8, 24, Boolean.valueOf(r10.is_all_day()));
            r1.i(r8, 25, Long.valueOf(r10.getStart_time()));
            r0.i(r8, 26, r10.getStart_timezone());
            r1.i(r8, 27, Long.valueOf(r10.getEnd_time()));
            r0.i(r8, 28, r10.getEnd_timezone());
            Status.ADAPTER.i(r8, 29, r10.getStatus());
            r0.i(r8, 30, r10.getRrule());
            r2.i(r8, 31, r10.getGuest_can_invite());
            r2.i(r8, 32, r10.getGuest_can_see_other_guests());
            r2.i(r8, 33, r10.getGuest_can_modify());
            r0.i(r8, 34, r10.getAudio_url());
            r0.i(r8, 35, r10.getUrl());
            CalendarLocation.ADAPTER.i(r8, 36, r10.getLocation());
            r2.i(r8, 37, r10.getHas_alarm());
            r2.i(r8, 38, r10.getHas_attendee());
            r2.i(r8, 39, r10.is_scheduled());
            ProtoAdapter<OldVersionCalendarEventAttendee> r4 = OldVersionCalendarEventAttendee.ADAPTER;
            r4.i(r8, 40, r10.getCreator());
            r4.i(r8, 41, r10.getOrganizer());
            r4.a().i(r8, 42, r10.getAttendees());
            CalendarEventReminder.ADAPTER.a().i(r8, 43, r10.getReminders());
            DisplayType.ADAPTER.i(r8, 44, r10.getDisplay_type());
            ProtoAdapter<MappingColor> r5 = MappingColor.ADAPTER;
            r5.i(r8, 45, r10.getEvent_color());
            r5.i(r8, 46, r10.getCal_color());
            ConflictType.ADAPTER.i(r8, 47, r10.getConflict_type());
            Type.ADAPTER.i(r8, 48, r10.getType());
            r0.i(r8, 49, r10.getMeeting_id());
            r2.i(r8, 50, r10.is_editable());
            Deletable.ADAPTER.i(r8, 51, r10.is_deletable());
            Sharability.ADAPTER.i(r8, 52, r10.getSharability());
            r0.i(r8, 53, r10.getDocs_description());
            r0.i(r8, 54, r10.getSuccessor_calendar_id());
            r4.i(r8, 55, r10.getSuccessor());
            NotificationType.ADAPTER.i(r8, 56, r10.getNotification_type());
            r2.i(r8, 57, r10.is_cross_tenant());
            r2.i(r8, 58, r10.getWill_creator_attend());
            r2.i(r8, 59, r10.getWill_organizer_attend());
            r2.i(r8, 60, r10.getWill_successor_attend());
            VideoMeeting.ADAPTER.i(r8, 61, r10.getVideo_meeting());
            r0.i(r8, 62, r10.getMeeting_minute_url());
            r8.a(r10.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r8, OldVersionCalendarEvent r9) {
            OldVersionCalendarEvent r10 = r9;
            Intrinsics.checkNotNullParameter(r8, "writer");
            Intrinsics.checkNotNullParameter(r10, "value");
            r8.d(r10.unknownFields());
            w r0 = ProtoAdapter.q;
            r0.j(r8, 62, r10.getMeeting_minute_url());
            VideoMeeting.ADAPTER.j(r8, 61, r10.getVideo_meeting());
            l r1 = ProtoAdapter.g;
            r1.j(r8, 60, r10.getWill_successor_attend());
            r1.j(r8, 59, r10.getWill_organizer_attend());
            r1.j(r8, 58, r10.getWill_creator_attend());
            r1.j(r8, 57, r10.is_cross_tenant());
            NotificationType.ADAPTER.j(r8, 56, r10.getNotification_type());
            ProtoAdapter<OldVersionCalendarEventAttendee> r2 = OldVersionCalendarEventAttendee.ADAPTER;
            r2.j(r8, 55, r10.getSuccessor());
            r0.j(r8, 54, r10.getSuccessor_calendar_id());
            r0.j(r8, 53, r10.getDocs_description());
            Sharability.ADAPTER.j(r8, 52, r10.getSharability());
            Deletable.ADAPTER.j(r8, 51, r10.is_deletable());
            r1.j(r8, 50, r10.is_editable());
            r0.j(r8, 49, r10.getMeeting_id());
            Type.ADAPTER.j(r8, 48, r10.getType());
            ConflictType.ADAPTER.j(r8, 47, r10.getConflict_type());
            ProtoAdapter<MappingColor> r3 = MappingColor.ADAPTER;
            r3.j(r8, 46, r10.getCal_color());
            r3.j(r8, 45, r10.getEvent_color());
            DisplayType.ADAPTER.j(r8, 44, r10.getDisplay_type());
            CalendarEventReminder.ADAPTER.a().j(r8, 43, r10.getReminders());
            r2.a().j(r8, 42, r10.getAttendees());
            r2.j(r8, 41, r10.getOrganizer());
            r2.j(r8, 40, r10.getCreator());
            r1.j(r8, 39, r10.is_scheduled());
            r1.j(r8, 38, r10.getHas_attendee());
            r1.j(r8, 37, r10.getHas_alarm());
            CalendarLocation.ADAPTER.j(r8, 36, r10.getLocation());
            r0.j(r8, 35, r10.getUrl());
            r0.j(r8, 34, r10.getAudio_url());
            r1.j(r8, 33, r10.getGuest_can_modify());
            r1.j(r8, 32, r10.getGuest_can_see_other_guests());
            r1.j(r8, 31, r10.getGuest_can_invite());
            r0.j(r8, 30, r10.getRrule());
            Status.ADAPTER.j(r8, 29, r10.getStatus());
            r0.j(r8, 28, r10.getEnd_timezone());
            t r4 = ProtoAdapter.k;
            r4.j(r8, 27, Long.valueOf(r10.getEnd_time()));
            r0.j(r8, 26, r10.getStart_timezone());
            r4.j(r8, 25, Long.valueOf(r10.getStart_time()));
            r1.j(r8, 24, Boolean.valueOf(r10.is_all_day()));
            r0.j(r8, 23, r10.getDescription());
            r0.j(r8, 22, r10.getSummary());
            r1.j(r8, 21, r10.getNeed_update());
            s r5 = ProtoAdapter.h;
            r5.j(r8, 20, r10.getVersion());
            CalendarDirtyType.ADAPTER.j(r8, 19, r10.getDirty_type());
            r5.j(r8, 18, r10.getImportance());
            Visibility.ADAPTER.j(r8, 17, r10.getVisibility());
            Source.ADAPTER.j(r8, 16, r10.getSource());
            r5.j(r8, 15, r10.getColor());
            r4.j(r8, 14, r10.getUpdate_time());
            r4.j(r8, 13, r10.getCreate_time());
            r4.j(r8, 12, r10.getLast_date());
            r1.j(r8, 11, r10.is_free());
            r1.j(r8, 10, r10.getOriginal_is_all_day());
            r0.j(r8, 9, r10.getOriginal_event_key());
            r4.j(r8, 8, Long.valueOf(r10.getOriginal_time()));
            r0.j(r8, 7, r10.getKey());
            OldVersionCalendarEventAttendee.Status.ADAPTER.j(r8, 6, r10.getSelf_attendee_status());
            r0.j(r8, 5, r10.getServer_id());
            r0.j(r8, 4, r10.getOrganizer_calendar_id());
            r0.j(r8, 3, r10.getCalendar_id());
            r0.j(r8, 2, r10.getCreator_calendar_id());
            r0.j(r8, 1, r10.getId());
        }

        public b(FieldEncoding r7, KClass<OldVersionCalendarEvent> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.OldVersionCalendarEvent", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ OldVersionCalendarEvent(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        DEFAULT_SELF_ATTENDEE_STATUS = OldVersionCalendarEventAttendee.Status.NEEDS_ACTION;
        DEFAULT_SOURCE = Source.UNKNOWN_SOURCE;
        DEFAULT_VISIBILITY = Visibility.DEFAULT;
        DEFAULT_DIRTY_TYPE = CalendarDirtyType.NONE_DIRTY_TYPE;
        DEFAULT_STATUS = Status.TENTATIVE;
        DEFAULT_DISPLAY_TYPE = DisplayType.INVISIBLE;
        DEFAULT_CONFLICT_TYPE = ConflictType.NONE;
        DEFAULT_TYPE = Type.DEFAULT_TYPE;
        DEFAULT_IS_DELETABLE = Deletable.NOT;
        DEFAULT_SHARABILITY = Sharability.FORBIDDEN_NOT_ACCESSIBLE;
        DEFAULT_NOTIFICATION_TYPE = NotificationType.DEFAULT_NOTIFICATION_TYPE;
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(OldVersionCalendarEvent.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.creator_calendar_id;
        r0.f = this.calendar_id;
        r0.g = this.organizer_calendar_id;
        r0.h = this.server_id;
        r0.i = this.self_attendee_status;
        r0.j = this.key;
        r0.k = Long.valueOf(this.original_time);
        r0.l = this.original_event_key;
        r0.m = this.original_is_all_day;
        r0.n = this.is_free;
        r0.o = this.last_date;
        r0.p = this.create_time;
        r0.q = this.update_time;
        r0.r = this.color;
        r0.s = this.source;
        r0.t = this.visibility;
        r0.u = this.importance;
        r0.v = this.dirty_type;
        r0.w = this.version;
        r0.x = this.need_update;
        r0.y = this.summary;
        r0.z = this.description;
        r0.A = Boolean.valueOf(this.is_all_day);
        r0.B = Long.valueOf(this.start_time);
        r0.C = this.start_timezone;
        r0.D = Long.valueOf(this.end_time);
        r0.E = this.end_timezone;
        r0.F = this.status;
        r0.G = this.rrule;
        r0.H = this.guest_can_invite;
        r0.I = this.guest_can_see_other_guests;
        r0.J = this.guest_can_modify;
        r0.K = this.audio_url;
        r0.L = this.url;
        r0.M = this.location;
        r0.N = this.has_alarm;
        r0.O = this.has_attendee;
        r0.P = this.is_scheduled;
        r0.Q = this.creator;
        r0.R = this.organizer;
        r0.S = this.attendees;
        r0.T = this.reminders;
        r0.U = this.display_type;
        r0.V = this.event_color;
        r0.W = this.cal_color;
        r0.X = this.conflict_type;
        r0.Y = this.type;
        r0.Z = this.meeting_id;
        r0.a0 = this.is_editable;
        r0.b0 = this.is_deletable;
        r0.c0 = this.sharability;
        r0.d0 = this.docs_description;
        r0.e0 = this.successor_calendar_id;
        r0.f0 = this.successor;
        r0.g0 = this.notification_type;
        r0.h0 = this.is_cross_tenant;
        r0.i0 = this.will_creator_attend;
        r0.j0 = this.will_organizer_attend;
        r0.k0 = this.will_successor_attend;
        r0.l0 = this.video_meeting;
        r0.m0 = this.meeting_minute_url;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(OldVersionCalendarEvent.class).getSimpleName() + '@' + hashCode();
    }

    public final List<OldVersionCalendarEventAttendee> getAttendees() {
        return this.attendees;
    }

    public final String getAudio_url() {
        return this.audio_url;
    }

    public final MappingColor getCal_color() {
        return this.cal_color;
    }

    public final String getCalendar_id() {
        return this.calendar_id;
    }

    public final Integer getColor() {
        return this.color;
    }

    public final ConflictType getConflict_type() {
        return this.conflict_type;
    }

    public final Long getCreate_time() {
        return this.create_time;
    }

    public final OldVersionCalendarEventAttendee getCreator() {
        return this.creator;
    }

    public final String getCreator_calendar_id() {
        return this.creator_calendar_id;
    }

    public final String getDescription() {
        return this.description;
    }

    public final CalendarDirtyType getDirty_type() {
        return this.dirty_type;
    }

    public final DisplayType getDisplay_type() {
        return this.display_type;
    }

    public final String getDocs_description() {
        return this.docs_description;
    }

    public final long getEnd_time() {
        return this.end_time;
    }

    public final String getEnd_timezone() {
        return this.end_timezone;
    }

    public final MappingColor getEvent_color() {
        return this.event_color;
    }

    public final Boolean getGuest_can_invite() {
        return this.guest_can_invite;
    }

    public final Boolean getGuest_can_modify() {
        return this.guest_can_modify;
    }

    public final Boolean getGuest_can_see_other_guests() {
        return this.guest_can_see_other_guests;
    }

    public final Boolean getHas_alarm() {
        return this.has_alarm;
    }

    public final Boolean getHas_attendee() {
        return this.has_attendee;
    }

    public final String getId() {
        return this.id;
    }

    public final Integer getImportance() {
        return this.importance;
    }

    public final String getKey() {
        return this.key;
    }

    public final Long getLast_date() {
        return this.last_date;
    }

    public final CalendarLocation getLocation() {
        return this.location;
    }

    public final String getMeeting_id() {
        return this.meeting_id;
    }

    public final String getMeeting_minute_url() {
        return this.meeting_minute_url;
    }

    public final Boolean getNeed_update() {
        return this.need_update;
    }

    public final NotificationType getNotification_type() {
        return this.notification_type;
    }

    public final OldVersionCalendarEventAttendee getOrganizer() {
        return this.organizer;
    }

    public final String getOrganizer_calendar_id() {
        return this.organizer_calendar_id;
    }

    public final String getOriginal_event_key() {
        return this.original_event_key;
    }

    public final Boolean getOriginal_is_all_day() {
        return this.original_is_all_day;
    }

    public final long getOriginal_time() {
        return this.original_time;
    }

    public final List<CalendarEventReminder> getReminders() {
        return this.reminders;
    }

    public final String getRrule() {
        return this.rrule;
    }

    public final OldVersionCalendarEventAttendee.Status getSelf_attendee_status() {
        return this.self_attendee_status;
    }

    public final String getServer_id() {
        return this.server_id;
    }

    public final Sharability getSharability() {
        return this.sharability;
    }

    public final Source getSource() {
        return this.source;
    }

    public final long getStart_time() {
        return this.start_time;
    }

    public final String getStart_timezone() {
        return this.start_timezone;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final OldVersionCalendarEventAttendee getSuccessor() {
        return this.successor;
    }

    public final String getSuccessor_calendar_id() {
        return this.successor_calendar_id;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final Type getType() {
        return this.type;
    }

    public final Long getUpdate_time() {
        return this.update_time;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Integer getVersion() {
        return this.version;
    }

    public final VideoMeeting getVideo_meeting() {
        return this.video_meeting;
    }

    public final Visibility getVisibility() {
        return this.visibility;
    }

    public final Boolean getWill_creator_attend() {
        return this.will_creator_attend;
    }

    public final Boolean getWill_organizer_attend() {
        return this.will_organizer_attend;
    }

    public final Boolean getWill_successor_attend() {
        return this.will_successor_attend;
    }

    public final boolean is_all_day() {
        return this.is_all_day;
    }

    public final Boolean is_cross_tenant() {
        return this.is_cross_tenant;
    }

    public final Deletable is_deletable() {
        return this.is_deletable;
    }

    public final Boolean is_editable() {
        return this.is_editable;
    }

    public final Boolean is_free() {
        return this.is_free;
    }

    public final Boolean is_scheduled() {
        return this.is_scheduled;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public OldVersionCalendarEvent(a r3, ByteString r4) {
        super(ADAPTER, r4);
        String r5 = r3.d;
        Intrinsics.checkNotNull(r5);
        this.id = r5;
        String r6 = r3.e;
        Intrinsics.checkNotNull(r6);
        this.creator_calendar_id = r6;
        String r7 = r3.f;
        Intrinsics.checkNotNull(r7);
        this.calendar_id = r7;
        String r8 = r3.g;
        Intrinsics.checkNotNull(r8);
        this.organizer_calendar_id = r8;
        this.server_id = r3.h;
        this.self_attendee_status = r3.i;
        String r9 = r3.j;
        Intrinsics.checkNotNull(r9);
        this.key = r9;
        Long r10 = r3.k;
        Intrinsics.checkNotNull(r10);
        this.original_time = r10.longValue();
        this.original_event_key = r3.l;
        this.original_is_all_day = r3.m;
        this.is_free = r3.n;
        this.last_date = r3.o;
        this.create_time = r3.p;
        this.update_time = r3.q;
        this.color = r3.r;
        this.source = r3.s;
        this.visibility = r3.t;
        this.importance = r3.u;
        this.dirty_type = r3.v;
        this.version = r3.w;
        this.need_update = r3.x;
        String r11 = r3.y;
        Intrinsics.checkNotNull(r11);
        this.summary = r11;
        this.description = r3.z;
        Boolean r12 = r3.A;
        Intrinsics.checkNotNull(r12);
        this.is_all_day = r12.booleanValue();
        Long r13 = r3.B;
        Intrinsics.checkNotNull(r13);
        this.start_time = r13.longValue();
        String r14 = r3.C;
        Intrinsics.checkNotNull(r14);
        this.start_timezone = r14;
        Long r15 = r3.D;
        Intrinsics.checkNotNull(r15);
        this.end_time = r15.longValue();
        String r16 = r3.E;
        Intrinsics.checkNotNull(r16);
        this.end_timezone = r16;
        this.status = r3.F;
        this.rrule = r3.G;
        this.guest_can_invite = r3.H;
        this.guest_can_see_other_guests = r3.I;
        this.guest_can_modify = r3.J;
        this.audio_url = r3.K;
        this.url = r3.L;
        this.location = r3.M;
        this.has_alarm = r3.N;
        this.has_attendee = r3.O;
        this.is_scheduled = r3.P;
        this.creator = r3.Q;
        this.organizer = r3.R;
        this.attendees = com.lark.wire.internal.a.c("attendees", r3.S);
        this.reminders = com.lark.wire.internal.a.c("reminders", r3.T);
        this.display_type = r3.U;
        this.event_color = r3.V;
        this.cal_color = r3.W;
        this.conflict_type = r3.X;
        this.type = r3.Y;
        this.meeting_id = r3.Z;
        this.is_editable = r3.a0;
        this.is_deletable = r3.b0;
        this.sharability = r3.c0;
        this.docs_description = r3.d0;
        this.successor_calendar_id = r3.e0;
        this.successor = r3.f0;
        this.notification_type = r3.g0;
        this.is_cross_tenant = r3.h0;
        this.will_creator_attend = r3.i0;
        this.will_organizer_attend = r3.j0;
        this.will_successor_attend = r3.k0;
        this.video_meeting = r3.l0;
        this.meeting_minute_url = r3.m0;
    }

    public /* synthetic */ OldVersionCalendarEvent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
