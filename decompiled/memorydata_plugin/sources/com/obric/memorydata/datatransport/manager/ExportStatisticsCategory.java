package com.obric.memorydata.datatransport.manager;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b%\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)¨\u0006*"}, d2 = {"Lcom/obric/memorydata/datatransport/manager/ExportStatisticsCategory;", "", "section", "Lcom/obric/memorydata/datatransport/manager/ExportStatisticsSection;", "labelRes", "", "<init>", "(Ljava/lang/String;ILcom/obric/memorydata/datatransport/manager/ExportStatisticsSection;I)V", "getSection", "()Lcom/obric/memorydata/datatransport/manager/ExportStatisticsSection;", "getLabelRes", "()I", "CONTACTS", "PHOTOS", "CALL_HISTORY", "MESSAGES", "RECORDINGS", "CALENDAR", "NOTES", "FILES", "ALARMS", "TIMERS", "VIDEOS", "ALBUMS", "MEMORY", "PERSONAL_INFO", "MEMORY_TASKS", "OTHER_DATABASE_TABLES", "CONTACT_AVATAR", "MESSAGE_FILE", "NOTE_FILE", "NOTE_RECORDING", "PHOTO_ORIGINAL", "VIDEO_ORIGINAL", "ALBUM_COVER", "FACE_AVATAR", "AUDITORY_RECORDING", "AUDITORY_TRANSCRIPT", "RECORDING_FILE", "RECORDING_TRANSCRIPT", "DOCUMENT", "MEMORY_SCREENSHOT", "data_transport_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum ExportStatisticsCategory extends Enum<ExportStatisticsCategory> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ExportStatisticsCategory[] $VALUES = null;
    public static final ExportStatisticsCategory ALARMS = null;
    public static final ExportStatisticsCategory ALBUMS = null;
    public static final ExportStatisticsCategory ALBUM_COVER = null;
    public static final ExportStatisticsCategory AUDITORY_RECORDING = null;
    public static final ExportStatisticsCategory AUDITORY_TRANSCRIPT = null;
    public static final ExportStatisticsCategory CALENDAR = null;
    public static final ExportStatisticsCategory CALL_HISTORY = null;
    public static final ExportStatisticsCategory CONTACTS = null;
    public static final ExportStatisticsCategory CONTACT_AVATAR = null;
    public static final ExportStatisticsCategory DOCUMENT = null;
    public static final ExportStatisticsCategory FACE_AVATAR = null;
    public static final ExportStatisticsCategory FILES = null;
    public static final ExportStatisticsCategory MEMORY = null;
    public static final ExportStatisticsCategory MEMORY_SCREENSHOT = null;
    public static final ExportStatisticsCategory MEMORY_TASKS = null;
    public static final ExportStatisticsCategory MESSAGES = null;
    public static final ExportStatisticsCategory MESSAGE_FILE = null;
    public static final ExportStatisticsCategory NOTES = null;
    public static final ExportStatisticsCategory NOTE_FILE = null;
    public static final ExportStatisticsCategory NOTE_RECORDING = null;
    public static final ExportStatisticsCategory OTHER_DATABASE_TABLES = null;
    public static final ExportStatisticsCategory PERSONAL_INFO = null;
    public static final ExportStatisticsCategory PHOTOS = null;
    public static final ExportStatisticsCategory PHOTO_ORIGINAL = null;
    public static final ExportStatisticsCategory RECORDINGS = null;
    public static final ExportStatisticsCategory RECORDING_FILE = null;
    public static final ExportStatisticsCategory RECORDING_TRANSCRIPT = null;
    public static final ExportStatisticsCategory TIMERS = null;
    public static final ExportStatisticsCategory VIDEOS = null;
    public static final ExportStatisticsCategory VIDEO_ORIGINAL = null;
    private final int labelRes;
    private final ExportStatisticsSection section;

    private static final /* synthetic */ ExportStatisticsCategory[] $values() {
        return new ExportStatisticsCategory[]{CONTACTS, PHOTOS, CALL_HISTORY, MESSAGES, RECORDINGS, CALENDAR, NOTES, FILES, ALARMS, TIMERS, VIDEOS, ALBUMS, MEMORY, PERSONAL_INFO, MEMORY_TASKS, OTHER_DATABASE_TABLES, CONTACT_AVATAR, MESSAGE_FILE, NOTE_FILE, NOTE_RECORDING, PHOTO_ORIGINAL, VIDEO_ORIGINAL, ALBUM_COVER, FACE_AVATAR, AUDITORY_RECORDING, AUDITORY_TRANSCRIPT, RECORDING_FILE, RECORDING_TRANSCRIPT, DOCUMENT, MEMORY_SCREENSHOT};
    }

    static {
        CONTACTS = new ExportStatisticsCategory("CONTACTS", 0, ExportStatisticsSection.DATA_TABLE, ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_contacts, TypedValues.Custom.S_STRING, "data_transport_export_stat_contacts"));
        PHOTOS = new ExportStatisticsCategory("PHOTOS", 1, ExportStatisticsSection.DATA_TABLE, ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_photos, TypedValues.Custom.S_STRING, "data_transport_export_stat_photos"));
        CALL_HISTORY = new ExportStatisticsCategory("CALL_HISTORY", 2, ExportStatisticsSection.DATA_TABLE, ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_call_history, TypedValues.Custom.S_STRING, "data_transport_export_stat_call_history"));
        MESSAGES = new ExportStatisticsCategory("MESSAGES", 3, ExportStatisticsSection.DATA_TABLE, ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_messages, TypedValues.Custom.S_STRING, "data_transport_export_stat_messages"));
        RECORDINGS = new ExportStatisticsCategory("RECORDINGS", 4, ExportStatisticsSection.DATA_TABLE, ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_recordings, TypedValues.Custom.S_STRING, "data_transport_export_stat_recordings"));
        CALENDAR = new ExportStatisticsCategory("CALENDAR", 5, ExportStatisticsSection.DATA_TABLE, ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_calendar, TypedValues.Custom.S_STRING, "data_transport_export_stat_calendar"));
        NOTES = new ExportStatisticsCategory("NOTES", 6, ExportStatisticsSection.DATA_TABLE, ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_notes, TypedValues.Custom.S_STRING, "data_transport_export_stat_notes"));
        FILES = new ExportStatisticsCategory("FILES", 7, ExportStatisticsSection.DATA_TABLE, ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_files, TypedValues.Custom.S_STRING, "data_transport_export_stat_files"));
        ALARMS = new ExportStatisticsCategory("ALARMS", 8, ExportStatisticsSection.DATA_TABLE, ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_alarms, TypedValues.Custom.S_STRING, "data_transport_export_stat_alarms"));
        TIMERS = new ExportStatisticsCategory("TIMERS", 9, ExportStatisticsSection.DATA_TABLE, ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_timers, TypedValues.Custom.S_STRING, "data_transport_export_stat_timers"));
        VIDEOS = new ExportStatisticsCategory("VIDEOS", 10, ExportStatisticsSection.DATA_TABLE, ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_videos, TypedValues.Custom.S_STRING, "data_transport_export_stat_videos"));
        ALBUMS = new ExportStatisticsCategory("ALBUMS", 11, ExportStatisticsSection.DATA_TABLE, ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_albums, TypedValues.Custom.S_STRING, "data_transport_export_stat_albums"));
        MEMORY = new ExportStatisticsCategory("MEMORY", 12, ExportStatisticsSection.DATA_TABLE, ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_memory, TypedValues.Custom.S_STRING, "data_transport_export_stat_memory"));
        PERSONAL_INFO = new ExportStatisticsCategory("PERSONAL_INFO", 13, ExportStatisticsSection.DATA_TABLE, ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_personal_info, TypedValues.Custom.S_STRING, "data_transport_export_stat_personal_info"));
        MEMORY_TASKS = new ExportStatisticsCategory("MEMORY_TASKS", 14, ExportStatisticsSection.DATA_TABLE, ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_memory_tasks, TypedValues.Custom.S_STRING, "data_transport_export_stat_memory_tasks"));
        OTHER_DATABASE_TABLES = new ExportStatisticsCategory("OTHER_DATABASE_TABLES", 15, ExportStatisticsSection.DATA_TABLE, ZeusTransformUtils.mapRes(R.string.data_transport_export_stat_other_tables, TypedValues.Custom.S_STRING, "data_transport_export_stat_other_tables"));
        CONTACT_AVATAR = new ExportStatisticsCategory("CONTACT_AVATAR", 16, ExportStatisticsSection.ATTACHMENT, ZeusTransformUtils.mapRes(R.string.data_transport_export_attachment_contact_avatar, TypedValues.Custom.S_STRING, "data_transport_export_attachment_contact_avatar"));
        MESSAGE_FILE = new ExportStatisticsCategory("MESSAGE_FILE", 17, ExportStatisticsSection.ATTACHMENT, ZeusTransformUtils.mapRes(R.string.data_transport_export_attachment_message_file, TypedValues.Custom.S_STRING, "data_transport_export_attachment_message_file"));
        NOTE_FILE = new ExportStatisticsCategory("NOTE_FILE", 18, ExportStatisticsSection.ATTACHMENT, ZeusTransformUtils.mapRes(R.string.data_transport_export_attachment_note_file, TypedValues.Custom.S_STRING, "data_transport_export_attachment_note_file"));
        NOTE_RECORDING = new ExportStatisticsCategory("NOTE_RECORDING", 19, ExportStatisticsSection.ATTACHMENT, ZeusTransformUtils.mapRes(R.string.data_transport_export_attachment_note_recording, TypedValues.Custom.S_STRING, "data_transport_export_attachment_note_recording"));
        PHOTO_ORIGINAL = new ExportStatisticsCategory("PHOTO_ORIGINAL", 20, ExportStatisticsSection.ATTACHMENT, ZeusTransformUtils.mapRes(R.string.data_transport_export_attachment_photo, TypedValues.Custom.S_STRING, "data_transport_export_attachment_photo"));
        VIDEO_ORIGINAL = new ExportStatisticsCategory("VIDEO_ORIGINAL", 21, ExportStatisticsSection.ATTACHMENT, ZeusTransformUtils.mapRes(R.string.data_transport_export_attachment_video, TypedValues.Custom.S_STRING, "data_transport_export_attachment_video"));
        ALBUM_COVER = new ExportStatisticsCategory("ALBUM_COVER", 22, ExportStatisticsSection.ATTACHMENT, ZeusTransformUtils.mapRes(R.string.data_transport_export_attachment_album_cover, TypedValues.Custom.S_STRING, "data_transport_export_attachment_album_cover"));
        FACE_AVATAR = new ExportStatisticsCategory("FACE_AVATAR", 23, ExportStatisticsSection.ATTACHMENT, ZeusTransformUtils.mapRes(R.string.data_transport_export_attachment_face_avatar, TypedValues.Custom.S_STRING, "data_transport_export_attachment_face_avatar"));
        AUDITORY_RECORDING = new ExportStatisticsCategory("AUDITORY_RECORDING", 24, ExportStatisticsSection.ATTACHMENT, ZeusTransformUtils.mapRes(R.string.data_transport_export_attachment_auditory_recording, TypedValues.Custom.S_STRING, "data_transport_export_attachment_auditory_recording"));
        AUDITORY_TRANSCRIPT = new ExportStatisticsCategory("AUDITORY_TRANSCRIPT", 25, ExportStatisticsSection.ATTACHMENT, ZeusTransformUtils.mapRes(R.string.data_transport_export_attachment_auditory_transcript, TypedValues.Custom.S_STRING, "data_transport_export_attachment_auditory_transcript"));
        RECORDING_FILE = new ExportStatisticsCategory("RECORDING_FILE", 26, ExportStatisticsSection.ATTACHMENT, ZeusTransformUtils.mapRes(R.string.data_transport_export_attachment_recording, TypedValues.Custom.S_STRING, "data_transport_export_attachment_recording"));
        RECORDING_TRANSCRIPT = new ExportStatisticsCategory("RECORDING_TRANSCRIPT", 27, ExportStatisticsSection.ATTACHMENT, ZeusTransformUtils.mapRes(R.string.data_transport_export_attachment_recording_transcript, TypedValues.Custom.S_STRING, "data_transport_export_attachment_recording_transcript"));
        DOCUMENT = new ExportStatisticsCategory("DOCUMENT", 28, ExportStatisticsSection.ATTACHMENT, ZeusTransformUtils.mapRes(R.string.data_transport_export_attachment_document, TypedValues.Custom.S_STRING, "data_transport_export_attachment_document"));
        MEMORY_SCREENSHOT = new ExportStatisticsCategory("MEMORY_SCREENSHOT", 29, ExportStatisticsSection.ATTACHMENT, ZeusTransformUtils.mapRes(R.string.data_transport_export_attachment_memory_screenshot, TypedValues.Custom.S_STRING, "data_transport_export_attachment_memory_screenshot"));
        ExportStatisticsCategory[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
    }

    private ExportStatisticsCategory(String r1, int r2, ExportStatisticsSection r3, int r4) {
        super(r1, r2);
        this.section = r3;
        this.labelRes = r4;
    }

    public static EnumEntries<ExportStatisticsCategory> getEntries() {
        return $ENTRIES;
    }

    public static ExportStatisticsCategory valueOf(String r2) {
        return (ExportStatisticsCategory) ZeusTransformUtils.preCheckCast(Enum.valueOf(ExportStatisticsCategory.class, r2), ExportStatisticsCategory.class, "com.obric.memorydata.plugin");
    }

    public static ExportStatisticsCategory[] values() {
        return (ExportStatisticsCategory[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ExportStatisticsCategory[].class, "com.obric.memorydata.plugin");
    }

    public final int getLabelRes() {
        return this.labelRes;
    }

    public final ExportStatisticsSection getSection() {
        return this.section;
    }
}
