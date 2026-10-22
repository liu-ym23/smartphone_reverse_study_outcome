package com.obric.memorydata.database.manager;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.migration.AutoMigrationSpec;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.obric.memorydata.database.dao.AlarmDao;
import com.obric.memorydata.database.dao.AlarmEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.AlarmRawDbDao;
import com.obric.memorydata.database.dao.AlbumHistoryEntityDao;
import com.obric.memorydata.database.dao.AlbumRawDbDao;
import com.obric.memorydata.database.dao.AppActivityDao;
import com.obric.memorydata.database.dao.AppUsageDao;
import com.obric.memorydata.database.dao.ArriveLeaveHomeCompanyEventDao;
import com.obric.memorydata.database.dao.AuditoryAsrTaskDao;
import com.obric.memorydata.database.dao.AuditoryRecordingEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.AuditoryRecordingRawDbDao;
import com.obric.memorydata.database.dao.AuditoryRecordingTextEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.AuditoryRecordingTextRawDbDao;
import com.obric.memorydata.database.dao.AuditorySyncStateDao;
import com.obric.memorydata.database.dao.AutoMemoryProTraceDao;
import com.obric.memorydata.database.dao.AwarenessInfoDao;
import com.obric.memorydata.database.dao.BatchChatDao;
import com.obric.memorydata.database.dao.BatteryStateDao;
import com.obric.memorydata.database.dao.BluetoothDeviceDao;
import com.obric.memorydata.database.dao.BrowserBookmarkHistoryEntityDao;
import com.obric.memorydata.database.dao.BrowserBookmarkRawDbDao;
import com.obric.memorydata.database.dao.BssidCalcCacheDao;
import com.obric.memorydata.database.dao.CallHistoryEntityContentTimeDao;
import com.obric.memorydata.database.dao.CallHistoryEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.CallHistoryHistoryEntityDao;
import com.obric.memorydata.database.dao.CallHistoryRawDbDao;
import com.obric.memorydata.database.dao.CellInfoDao;
import com.obric.memorydata.database.dao.CommonPhotoEntityImageVectorCopilotDao;
import com.obric.memorydata.database.dao.CommonPhotoEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.CommonPhotoRawDbDao;
import com.obric.memorydata.database.dao.CommonVideoFrameEntityImageVectorCopilotDao;
import com.obric.memorydata.database.dao.CommonVideoFrameEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.CommonVideoFrameRawDbDao;
import com.obric.memorydata.database.dao.ContactEntityImageVectorCopilotDao;
import com.obric.memorydata.database.dao.ContactEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.ContactHistoryEntityDao;
import com.obric.memorydata.database.dao.ContactRawDbDao;
import com.obric.memorydata.database.dao.CountdownEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.CountdownRawDbDao;
import com.obric.memorydata.database.dao.DataBuildMemoryStatusDao;
import com.obric.memorydata.database.dao.DeviceBootDao;
import com.obric.memorydata.database.dao.DeviceShutdownDao;
import com.obric.memorydata.database.dao.DoubaoAccountEntityRawDbDao;
import com.obric.memorydata.database.dao.ElementKGIndexPendingDao;
import com.obric.memorydata.database.dao.EmbeddingVectorCacheDao;
import com.obric.memorydata.database.dao.EntityIndexLifecycleDao;
import com.obric.memorydata.database.dao.EvaluationSourceDataDao;
import com.obric.memorydata.database.dao.FileEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.FileHistoryEntityDao;
import com.obric.memorydata.database.dao.FileRawDbDao;
import com.obric.memorydata.database.dao.FileTextEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.FileTextRawDbDao;
import com.obric.memorydata.database.dao.GeographyDao;
import com.obric.memorydata.database.dao.GlassesSyncStateDao;
import com.obric.memorydata.database.dao.HarStateDao;
import com.obric.memorydata.database.dao.ICSProtocolEntityRawDbDao;
import com.obric.memorydata.database.dao.ICSProtocolHistoryEntityDao;
import com.obric.memorydata.database.dao.InAppL1RuleDao;
import com.obric.memorydata.database.dao.InAppTraceUploadDao;
import com.obric.memorydata.database.dao.IndexPendingDao;
import com.obric.memorydata.database.dao.LanguageChangeEventDao;
import com.obric.memorydata.database.dao.LightSensorDao;
import com.obric.memorydata.database.dao.LocalMemorySyncToDoubaoPendingDao;
import com.obric.memorydata.database.dao.LocationAddressCacheDao;
import com.obric.memorydata.database.dao.LocationDao;
import com.obric.memorydata.database.dao.MemoryEntityContentTimeDao;
import com.obric.memorydata.database.dao.MemoryEntityRawDbDao;
import com.obric.memorydata.database.dao.MemoryEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.MemoryLocationEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.MemoryLocationRawDbDao;
import com.obric.memorydata.database.dao.MemoryMapTableDao;
import com.obric.memorydata.database.dao.MemoryProcessConsumerSubscriptionDao;
import com.obric.memorydata.database.dao.MemoryProcessOperationRecordDao;
import com.obric.memorydata.database.dao.MemoryProcessOutputEventDao;
import com.obric.memorydata.database.dao.MemoryProcessSourceEventDao;
import com.obric.memorydata.database.dao.MemoryProcessTriggerStateDao;
import com.obric.memorydata.database.dao.MemoryTraceReportDao;
import com.obric.memorydata.database.dao.MessageEntityContentTimeDao;
import com.obric.memorydata.database.dao.MessageEntityImageVectorCopilotDao;
import com.obric.memorydata.database.dao.MessageEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.MessageHistoryRawDbDao;
import com.obric.memorydata.database.dao.MessageRawDbDao;
import com.obric.memorydata.database.dao.MetaFullContentKeywordCopilotDao;
import com.obric.memorydata.database.dao.MetaLocationEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.MetaLocationRawDbDao;
import com.obric.memorydata.database.dao.MetaTagRawDbDao;
import com.obric.memorydata.database.dao.MobileCellularDao;
import com.obric.memorydata.database.dao.MovementStateDao;
import com.obric.memorydata.database.dao.NetworkStatusDao;
import com.obric.memorydata.database.dao.NetworkTypeDao;
import com.obric.memorydata.database.dao.NoteEntityContentTimeDao;
import com.obric.memorydata.database.dao.NoteEntityImageVectorCopilotDao;
import com.obric.memorydata.database.dao.NoteEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.NoteRawDbDao;
import com.obric.memorydata.database.dao.NoteRecordingEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.NoteRecordingRawDbDao;
import com.obric.memorydata.database.dao.NoteRecordingTextEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.NoteRecordingTextRawDbDao;
import com.obric.memorydata.database.dao.OrderHitDao;
import com.obric.memorydata.database.dao.OsAudioPlayDao;
import com.obric.memorydata.database.dao.OsNotificationDao;
import com.obric.memorydata.database.dao.PackageEventDao;
import com.obric.memorydata.database.dao.PhotoEntityImageVectorCopilotDao;
import com.obric.memorydata.database.dao.PhotoEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.PhotoFaceRawDbDao;
import com.obric.memorydata.database.dao.PhotoHistoryEntityDao;
import com.obric.memorydata.database.dao.PhotoRawDbDao;
import com.obric.memorydata.database.dao.PoiInfoGroupDao;
import com.obric.memorydata.database.dao.PoiReqRecorderDao;
import com.obric.memorydata.database.dao.PredictAppDao;
import com.obric.memorydata.database.dao.PredictSleepWakeupDao;
import com.obric.memorydata.database.dao.ProactiveMemoryProcessInfoDao;
import com.obric.memorydata.database.dao.ProactiveMemorySyncPendingDao;
import com.obric.memorydata.database.dao.ProactiveOsNotificationDao;
import com.obric.memorydata.database.dao.RawChatAppChatDao;
import com.obric.memorydata.database.dao.RawMemoryHistoryRawDbDao;
import com.obric.memorydata.database.dao.RawObservationDao;
import com.obric.memorydata.database.dao.RawPhotoContentTimeDao;
import com.obric.memorydata.database.dao.RecordingEntityContentTimeDao;
import com.obric.memorydata.database.dao.RecordingEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.RecordingRawDbDao;
import com.obric.memorydata.database.dao.RecordingTextEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.RecordingTextRawDbDao;
import com.obric.memorydata.database.dao.ScheduleEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.ScheduleRawDbDao;
import com.obric.memorydata.database.dao.ScreenBrightnessDao;
import com.obric.memorydata.database.dao.ScreenObservationDao;
import com.obric.memorydata.database.dao.ScreenStateDao;
import com.obric.memorydata.database.dao.SettingsChangedDao;
import com.obric.memorydata.database.dao.SpeakerEmbeddingPendingDao;
import com.obric.memorydata.database.dao.StreamVolumeDao;
import com.obric.memorydata.database.dao.UploadDataDao;
import com.obric.memorydata.database.dao.UserActionRecorderDao;
import com.obric.memorydata.database.dao.VideoFrameEntityImageVectorCopilotDao;
import com.obric.memorydata.database.dao.VideoFrameEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.VideoFrameRawDbDao;
import com.obric.memorydata.database.dao.WifiDao;
import com.obric.memorydata.database.dao.WifiListDao;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.database.entity.dx;
import com.obric.memorydata.database.entity.el;
import com.obric.memorydata.database.entity.hx;
import com.obric.memorydata.database.legacy.dao.aa;
import com.obric.memorydata.database.legacy.dao.ab;
import com.obric.memorydata.database.legacy.dao.ac;
import com.obric.memorydata.database.legacy.dao.ad;
import com.obric.memorydata.database.legacy.dao.ae;
import com.obric.memorydata.database.legacy.dao.af;
import com.obric.memorydata.database.legacy.dao.ag;
import com.obric.memorydata.database.legacy.dao.ah;
import com.obric.memorydata.database.legacy.dao.ai;
import com.obric.memorydata.database.legacy.dao.aj;
import com.obric.memorydata.database.legacy.dao.ak;
import com.obric.memorydata.database.legacy.dao.al;
import com.obric.memorydata.database.legacy.dao.am;
import com.obric.memorydata.database.legacy.dao.an;
import com.obric.memorydata.database.legacy.dao.ao;
import com.obric.memorydata.database.legacy.dao.ap;
import com.obric.memorydata.database.legacy.dao.aq;
import com.obric.memorydata.database.legacy.dao.ar;
import com.obric.memorydata.database.legacy.dao.as;
import com.obric.memorydata.database.legacy.dao.at;
import com.obric.memorydata.database.legacy.dao.au;
import com.obric.memorydata.database.legacy.dao.av;
import com.obric.memorydata.database.legacy.dao.aw;
import com.obric.memorydata.database.legacy.dao.ax;
import com.obric.memorydata.database.legacy.dao.ay;
import com.obric.memorydata.database.legacy.dao.az;
import com.obric.memorydata.database.legacy.dao.ba;
import com.obric.memorydata.database.legacy.dao.bb;
import com.obric.memorydata.database.legacy.dao.bc;
import com.obric.memorydata.database.legacy.dao.bd;
import com.obric.memorydata.database.legacy.dao.be;
import com.obric.memorydata.database.legacy.dao.bf;
import com.obric.memorydata.database.legacy.dao.x;
import com.obric.memorydata.database.legacy.dao.y;
import com.obric.memorydata.database.legacy.dao.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000ê\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001:\u0002ÿ\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0011\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0012J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001eR\u0012\u0010\u001f\u001a\u00020 X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0012\u0010#\u001a\u00020$X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0012\u0010'\u001a\u00020(X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0012\u0010+\u001a\u00020,X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0012\u0010/\u001a\u000200X¦\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0012\u00103\u001a\u000204X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u001a\u00107\u001a\u0002088 X¡\u0004¢\u0006\f\u0012\u0004\b9\u0010\u0003\u001a\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020=8 X¡\u0004¢\u0006\f\u0012\u0004\b>\u0010\u0003\u001a\u0004\b?\u0010@R\u0012\u0010A\u001a\u00020BX¦\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0012\u0010E\u001a\u00020FX¦\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0012\u0010I\u001a\u00020JX¦\u0004¢\u0006\u0006\u001a\u0004\bK\u0010LR\u0012\u0010M\u001a\u00020NX¦\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0012\u0010Q\u001a\u00020RX¦\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0012\u0010U\u001a\u00020VX¦\u0004¢\u0006\u0006\u001a\u0004\bW\u0010XR\u0012\u0010Y\u001a\u00020ZX¦\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u0012\u0010]\u001a\u00020^X¦\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`R\u0012\u0010a\u001a\u00020bX¦\u0004¢\u0006\u0006\u001a\u0004\bc\u0010dR\u0012\u0010e\u001a\u00020fX¦\u0004¢\u0006\u0006\u001a\u0004\bg\u0010hR\u0012\u0010i\u001a\u00020jX¦\u0004¢\u0006\u0006\u001a\u0004\bk\u0010lR\u0012\u0010m\u001a\u00020nX¦\u0004¢\u0006\u0006\u001a\u0004\bo\u0010pR\u0012\u0010q\u001a\u00020rX¦\u0004¢\u0006\u0006\u001a\u0004\bs\u0010tR\u0012\u0010u\u001a\u00020vX¦\u0004¢\u0006\u0006\u001a\u0004\bw\u0010xR\u0012\u0010y\u001a\u00020zX¦\u0004¢\u0006\u0006\u001a\u0004\b{\u0010|R\u0013\u0010}\u001a\u00020~X¦\u0004¢\u0006\u0007\u001a\u0005\b\u007f\u0010\u0080\u0001R\u0016\u0010\u0081\u0001\u001a\u00030\u0082\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0016\u0010\u0085\u0001\u001a\u00030\u0086\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0016\u0010\u0089\u0001\u001a\u00030\u008a\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0016\u0010\u008d\u0001\u001a\u00030\u008e\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0016\u0010\u0091\u0001\u001a\u00030\u0092\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001R\u0016\u0010\u0095\u0001\u001a\u00030\u0096\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0016\u0010\u0099\u0001\u001a\u00030\u009a\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001R\u0016\u0010\u009d\u0001\u001a\u00030\u009e\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u009f\u0001\u0010 \u0001R\u0016\u0010¡\u0001\u001a\u00030¢\u0001X¦\u0004¢\u0006\b\u001a\u0006\b£\u0001\u0010¤\u0001R\u0016\u0010¥\u0001\u001a\u00030¦\u0001X¦\u0004¢\u0006\b\u001a\u0006\b§\u0001\u0010¨\u0001R\u0016\u0010©\u0001\u001a\u00030ª\u0001X¦\u0004¢\u0006\b\u001a\u0006\b«\u0001\u0010¬\u0001R\u0016\u0010\u00ad\u0001\u001a\u00030®\u0001X¦\u0004¢\u0006\b\u001a\u0006\b¯\u0001\u0010°\u0001R\u0016\u0010±\u0001\u001a\u00030²\u0001X¦\u0004¢\u0006\b\u001a\u0006\b³\u0001\u0010´\u0001R\u0016\u0010µ\u0001\u001a\u00030¶\u0001X¦\u0004¢\u0006\b\u001a\u0006\b·\u0001\u0010¸\u0001R\u0016\u0010¹\u0001\u001a\u00030º\u0001X¦\u0004¢\u0006\b\u001a\u0006\b»\u0001\u0010¼\u0001R\u0016\u0010½\u0001\u001a\u00030¾\u0001X¦\u0004¢\u0006\b\u001a\u0006\b¿\u0001\u0010À\u0001R\u0016\u0010Á\u0001\u001a\u00030Â\u0001X¦\u0004¢\u0006\b\u001a\u0006\bÃ\u0001\u0010Ä\u0001R\u0016\u0010Å\u0001\u001a\u00030Æ\u0001X¦\u0004¢\u0006\b\u001a\u0006\bÇ\u0001\u0010È\u0001R\u0016\u0010É\u0001\u001a\u00030Ê\u0001X¦\u0004¢\u0006\b\u001a\u0006\bË\u0001\u0010Ì\u0001R\u0016\u0010Í\u0001\u001a\u00030Î\u0001X¦\u0004¢\u0006\b\u001a\u0006\bÏ\u0001\u0010Ð\u0001R\u0016\u0010Ñ\u0001\u001a\u00030Ò\u0001X¦\u0004¢\u0006\b\u001a\u0006\bÓ\u0001\u0010Ô\u0001R\u0016\u0010Õ\u0001\u001a\u00030Ö\u0001X¦\u0004¢\u0006\b\u001a\u0006\b×\u0001\u0010Ø\u0001R\u0016\u0010Ù\u0001\u001a\u00030Ú\u0001X¦\u0004¢\u0006\b\u001a\u0006\bÛ\u0001\u0010Ü\u0001R\u0016\u0010Ý\u0001\u001a\u00030Þ\u0001X¦\u0004¢\u0006\b\u001a\u0006\bß\u0001\u0010à\u0001R\u0016\u0010á\u0001\u001a\u00030â\u0001X¦\u0004¢\u0006\b\u001a\u0006\bã\u0001\u0010ä\u0001R\u0016\u0010å\u0001\u001a\u00030æ\u0001X¦\u0004¢\u0006\b\u001a\u0006\bç\u0001\u0010è\u0001R\u0016\u0010é\u0001\u001a\u00030ê\u0001X¦\u0004¢\u0006\b\u001a\u0006\bë\u0001\u0010ì\u0001R\u0016\u0010í\u0001\u001a\u00030î\u0001X¦\u0004¢\u0006\b\u001a\u0006\bï\u0001\u0010ð\u0001R\u0016\u0010ñ\u0001\u001a\u00030ò\u0001X¦\u0004¢\u0006\b\u001a\u0006\bó\u0001\u0010ô\u0001R\u0016\u0010õ\u0001\u001a\u00030ö\u0001X¦\u0004¢\u0006\b\u001a\u0006\b÷\u0001\u0010ø\u0001R\u0016\u0010ù\u0001\u001a\u00030ú\u0001X¦\u0004¢\u0006\b\u001a\u0006\bû\u0001\u0010ü\u0001R\u0016\u0010ý\u0001\u001a\u00030þ\u0001X¦\u0004¢\u0006\b\u001a\u0006\bÿ\u0001\u0010\u0080\u0002R\u0016\u0010\u0081\u0002\u001a\u00030\u0082\u0002X¦\u0004¢\u0006\b\u001a\u0006\b\u0083\u0002\u0010\u0084\u0002R\u0016\u0010\u0085\u0002\u001a\u00030\u0086\u0002X¦\u0004¢\u0006\b\u001a\u0006\b\u0087\u0002\u0010\u0088\u0002R\u0016\u0010\u0089\u0002\u001a\u00030\u008a\u0002X¦\u0004¢\u0006\b\u001a\u0006\b\u008b\u0002\u0010\u008c\u0002R\u0016\u0010\u008d\u0002\u001a\u00030\u008e\u0002X¦\u0004¢\u0006\b\u001a\u0006\b\u008f\u0002\u0010\u0090\u0002R\u0016\u0010\u0091\u0002\u001a\u00030\u0092\u0002X¦\u0004¢\u0006\b\u001a\u0006\b\u0093\u0002\u0010\u0094\u0002R\u0016\u0010\u0095\u0002\u001a\u00030\u0096\u0002X¦\u0004¢\u0006\b\u001a\u0006\b\u0097\u0002\u0010\u0098\u0002R\u0016\u0010\u0099\u0002\u001a\u00030\u009a\u0002X¦\u0004¢\u0006\b\u001a\u0006\b\u009b\u0002\u0010\u009c\u0002R\u0016\u0010\u009d\u0002\u001a\u00030\u009e\u0002X¦\u0004¢\u0006\b\u001a\u0006\b\u009f\u0002\u0010 \u0002R\u0016\u0010¡\u0002\u001a\u00030¢\u0002X¦\u0004¢\u0006\b\u001a\u0006\b£\u0002\u0010¤\u0002R\u0016\u0010¥\u0002\u001a\u00030¦\u0002X¦\u0004¢\u0006\b\u001a\u0006\b§\u0002\u0010¨\u0002R\u0016\u0010©\u0002\u001a\u00030ª\u0002X¦\u0004¢\u0006\b\u001a\u0006\b«\u0002\u0010¬\u0002R\u0016\u0010\u00ad\u0002\u001a\u00030®\u0002X¦\u0004¢\u0006\b\u001a\u0006\b¯\u0002\u0010°\u0002R\u0016\u0010±\u0002\u001a\u00030²\u0002X¦\u0004¢\u0006\b\u001a\u0006\b³\u0002\u0010´\u0002R\u0016\u0010µ\u0002\u001a\u00030¶\u0002X¦\u0004¢\u0006\b\u001a\u0006\b·\u0002\u0010¸\u0002R\u0016\u0010¹\u0002\u001a\u00030º\u0002X¦\u0004¢\u0006\b\u001a\u0006\b»\u0002\u0010¼\u0002R\u0016\u0010½\u0002\u001a\u00030¾\u0002X¦\u0004¢\u0006\b\u001a\u0006\b¿\u0002\u0010À\u0002R\u0016\u0010Á\u0002\u001a\u00030Â\u0002X¦\u0004¢\u0006\b\u001a\u0006\bÃ\u0002\u0010Ä\u0002R\u0016\u0010Å\u0002\u001a\u00030Æ\u0002X¦\u0004¢\u0006\b\u001a\u0006\bÇ\u0002\u0010È\u0002R\u0016\u0010É\u0002\u001a\u00030Ê\u0002X¦\u0004¢\u0006\b\u001a\u0006\bË\u0002\u0010Ì\u0002R\u0016\u0010Í\u0002\u001a\u00030Î\u0002X¦\u0004¢\u0006\b\u001a\u0006\bÏ\u0002\u0010Ð\u0002R\u0016\u0010Ñ\u0002\u001a\u00030Ò\u0002X¦\u0004¢\u0006\b\u001a\u0006\bÓ\u0002\u0010Ô\u0002R\u0016\u0010Õ\u0002\u001a\u00030Ö\u0002X¦\u0004¢\u0006\b\u001a\u0006\b×\u0002\u0010Ø\u0002R\u0016\u0010Ù\u0002\u001a\u00030Ú\u0002X¦\u0004¢\u0006\b\u001a\u0006\bÛ\u0002\u0010Ü\u0002R\u0016\u0010Ý\u0002\u001a\u00030Þ\u0002X¦\u0004¢\u0006\b\u001a\u0006\bß\u0002\u0010à\u0002R\u0016\u0010á\u0002\u001a\u00030â\u0002X¦\u0004¢\u0006\b\u001a\u0006\bã\u0002\u0010ä\u0002R\u0016\u0010å\u0002\u001a\u00030æ\u0002X¦\u0004¢\u0006\b\u001a\u0006\bç\u0002\u0010è\u0002R\u0016\u0010é\u0002\u001a\u00030ê\u0002X¦\u0004¢\u0006\b\u001a\u0006\bë\u0002\u0010ì\u0002R\u0016\u0010í\u0002\u001a\u00030î\u0002X¦\u0004¢\u0006\b\u001a\u0006\bï\u0002\u0010ð\u0002R\u0016\u0010ñ\u0002\u001a\u00030ò\u0002X¦\u0004¢\u0006\b\u001a\u0006\bó\u0002\u0010ô\u0002R\u0016\u0010õ\u0002\u001a\u00030ö\u0002X¦\u0004¢\u0006\b\u001a\u0006\b÷\u0002\u0010ø\u0002R\u0016\u0010ù\u0002\u001a\u00030ú\u0002X¦\u0004¢\u0006\b\u001a\u0006\bû\u0002\u0010ü\u0002R\u0016\u0010ý\u0002\u001a\u00030þ\u0002X¦\u0004¢\u0006\b\u001a\u0006\bÿ\u0002\u0010\u0080\u0003R\u0016\u0010\u0081\u0003\u001a\u00030\u0082\u0003X¦\u0004¢\u0006\b\u001a\u0006\b\u0083\u0003\u0010\u0084\u0003R\u0016\u0010\u0085\u0003\u001a\u00030\u0086\u0003X¦\u0004¢\u0006\b\u001a\u0006\b\u0087\u0003\u0010\u0088\u0003R\u0016\u0010\u0089\u0003\u001a\u00030\u008a\u0003X¦\u0004¢\u0006\b\u001a\u0006\b\u008b\u0003\u0010\u008c\u0003R\u0016\u0010\u008d\u0003\u001a\u00030\u008e\u0003X¦\u0004¢\u0006\b\u001a\u0006\b\u008f\u0003\u0010\u0090\u0003R\u0016\u0010\u0091\u0003\u001a\u00030\u0092\u0003X¦\u0004¢\u0006\b\u001a\u0006\b\u0093\u0003\u0010\u0094\u0003R\u0016\u0010\u0095\u0003\u001a\u00030\u0096\u0003X¦\u0004¢\u0006\b\u001a\u0006\b\u0097\u0003\u0010\u0098\u0003R\u0016\u0010\u0099\u0003\u001a\u00030\u009a\u0003X¦\u0004¢\u0006\b\u001a\u0006\b\u009b\u0003\u0010\u009c\u0003R\u0016\u0010\u009d\u0003\u001a\u00030\u009e\u0003X¦\u0004¢\u0006\b\u001a\u0006\b\u009f\u0003\u0010 \u0003R\u0016\u0010¡\u0003\u001a\u00030¢\u0003X¦\u0004¢\u0006\b\u001a\u0006\b£\u0003\u0010¤\u0003R\u0016\u0010¥\u0003\u001a\u00030¦\u0003X¦\u0004¢\u0006\b\u001a\u0006\b§\u0003\u0010¨\u0003R\u0016\u0010©\u0003\u001a\u00030ª\u0003X¦\u0004¢\u0006\b\u001a\u0006\b«\u0003\u0010¬\u0003R\u0016\u0010\u00ad\u0003\u001a\u00030®\u0003X¦\u0004¢\u0006\b\u001a\u0006\b¯\u0003\u0010°\u0003R\u0016\u0010±\u0003\u001a\u00030²\u0003X¦\u0004¢\u0006\b\u001a\u0006\b³\u0003\u0010´\u0003R\u001f\u0010µ\u0003\u001a\u00030¶\u00038 X¡\u0004¢\u0006\u000f\u0012\u0005\b·\u0003\u0010\u0003\u001a\u0006\b¸\u0003\u0010¹\u0003R\u001f\u0010º\u0003\u001a\u00030»\u00038 X¡\u0004¢\u0006\u000f\u0012\u0005\b¼\u0003\u0010\u0003\u001a\u0006\b½\u0003\u0010¾\u0003R\u001f\u0010¿\u0003\u001a\u00030À\u00038 X¡\u0004¢\u0006\u000f\u0012\u0005\bÁ\u0003\u0010\u0003\u001a\u0006\bÂ\u0003\u0010Ã\u0003R\u001f\u0010Ä\u0003\u001a\u00030Å\u00038 X¡\u0004¢\u0006\u000f\u0012\u0005\bÆ\u0003\u0010\u0003\u001a\u0006\bÇ\u0003\u0010È\u0003R\u001f\u0010É\u0003\u001a\u00030Ê\u00038 X¡\u0004¢\u0006\u000f\u0012\u0005\bË\u0003\u0010\u0003\u001a\u0006\bÌ\u0003\u0010Í\u0003R\u0016\u0010Î\u0003\u001a\u00030Ï\u0003X¦\u0004¢\u0006\b\u001a\u0006\bÐ\u0003\u0010Ñ\u0003R\u0016\u0010Ò\u0003\u001a\u00030Ó\u0003X¦\u0004¢\u0006\b\u001a\u0006\bÔ\u0003\u0010Õ\u0003R\u0016\u0010Ö\u0003\u001a\u00030×\u0003X¦\u0004¢\u0006\b\u001a\u0006\bØ\u0003\u0010Ù\u0003R\u0016\u0010Ú\u0003\u001a\u00030Û\u0003X¦\u0004¢\u0006\b\u001a\u0006\bÜ\u0003\u0010Ý\u0003R\u0016\u0010Þ\u0003\u001a\u00030ß\u0003X¦\u0004¢\u0006\b\u001a\u0006\bà\u0003\u0010á\u0003R\u0016\u0010â\u0003\u001a\u00030ã\u0003X¦\u0004¢\u0006\b\u001a\u0006\bä\u0003\u0010å\u0003R\u0016\u0010æ\u0003\u001a\u00030ç\u0003X¦\u0004¢\u0006\b\u001a\u0006\bè\u0003\u0010é\u0003R\u0016\u0010ê\u0003\u001a\u00030ë\u0003X¦\u0004¢\u0006\b\u001a\u0006\bì\u0003\u0010í\u0003R\u0016\u0010î\u0003\u001a\u00030ï\u0003X¦\u0004¢\u0006\b\u001a\u0006\bð\u0003\u0010ñ\u0003R\u0016\u0010ò\u0003\u001a\u00030ó\u0003X¦\u0004¢\u0006\b\u001a\u0006\bô\u0003\u0010õ\u0003R\u0016\u0010ö\u0003\u001a\u00030÷\u0003X¦\u0004¢\u0006\b\u001a\u0006\bø\u0003\u0010ù\u0003R\u0016\u0010ú\u0003\u001a\u00030û\u0003X¦\u0004¢\u0006\b\u001a\u0006\bü\u0003\u0010ý\u0003R\u0016\u0010þ\u0003\u001a\u00030ÿ\u0003X¦\u0004¢\u0006\b\u001a\u0006\b\u0080\u0004\u0010\u0081\u0004R\u0016\u0010\u0082\u0004\u001a\u00030\u0083\u0004X¦\u0004¢\u0006\b\u001a\u0006\b\u0084\u0004\u0010\u0085\u0004R\u0016\u0010\u0086\u0004\u001a\u00030\u0087\u0004X¦\u0004¢\u0006\b\u001a\u0006\b\u0088\u0004\u0010\u0089\u0004R\u0016\u0010\u008a\u0004\u001a\u00030\u008b\u0004X¦\u0004¢\u0006\b\u001a\u0006\b\u008c\u0004\u0010\u008d\u0004R\u0016\u0010\u008e\u0004\u001a\u00030\u008f\u0004X¦\u0004¢\u0006\b\u001a\u0006\b\u0090\u0004\u0010\u0091\u0004R\u001f\u0010\u0092\u0004\u001a\u00030\u0093\u00048 X¡\u0004¢\u0006\u000f\u0012\u0005\b\u0094\u0004\u0010\u0003\u001a\u0006\b\u0095\u0004\u0010\u0096\u0004R\u0016\u0010\u0097\u0004\u001a\u00030\u0098\u0004X¦\u0004¢\u0006\b\u001a\u0006\b\u0099\u0004\u0010\u009a\u0004R\u0016\u0010\u009b\u0004\u001a\u00030\u009c\u0004X¦\u0004¢\u0006\b\u001a\u0006\b\u009d\u0004\u0010\u009e\u0004R\u0016\u0010\u009f\u0004\u001a\u00030 \u0004X¦\u0004¢\u0006\b\u001a\u0006\b¡\u0004\u0010¢\u0004R\u0016\u0010£\u0004\u001a\u00030¤\u0004X¦\u0004¢\u0006\b\u001a\u0006\b¥\u0004\u0010¦\u0004R\u001f\u0010§\u0004\u001a\u00030¨\u00048 X¡\u0004¢\u0006\u000f\u0012\u0005\b©\u0004\u0010\u0003\u001a\u0006\bª\u0004\u0010«\u0004R\u0016\u0010¬\u0004\u001a\u00030\u00ad\u0004X¦\u0004¢\u0006\b\u001a\u0006\b®\u0004\u0010¯\u0004R\u0016\u0010°\u0004\u001a\u00030±\u0004X¦\u0004¢\u0006\b\u001a\u0006\b²\u0004\u0010³\u0004R\u0016\u0010´\u0004\u001a\u00030µ\u0004X¦\u0004¢\u0006\b\u001a\u0006\b¶\u0004\u0010·\u0004R\u0016\u0010¸\u0004\u001a\u00030¹\u0004X¦\u0004¢\u0006\b\u001a\u0006\bº\u0004\u0010»\u0004R\u0016\u0010¼\u0004\u001a\u00030½\u0004X¦\u0004¢\u0006\b\u001a\u0006\b¾\u0004\u0010¿\u0004R\u0016\u0010À\u0004\u001a\u00030Á\u0004X¦\u0004¢\u0006\b\u001a\u0006\bÂ\u0004\u0010Ã\u0004R\u001f\u0010Ä\u0004\u001a\u00030Å\u00048 X¡\u0004¢\u0006\u000f\u0012\u0005\bÆ\u0004\u0010\u0003\u001a\u0006\bÇ\u0004\u0010È\u0004R\u001f\u0010É\u0004\u001a\u00030Ê\u00048 X¡\u0004¢\u0006\u000f\u0012\u0005\bË\u0004\u0010\u0003\u001a\u0006\bÌ\u0004\u0010Í\u0004R\u001f\u0010Î\u0004\u001a\u00030Ï\u00048 X¡\u0004¢\u0006\u000f\u0012\u0005\bÐ\u0004\u0010\u0003\u001a\u0006\bÑ\u0004\u0010Ò\u0004R\u001f\u0010Ó\u0004\u001a\u00030Ô\u00048 X¡\u0004¢\u0006\u000f\u0012\u0005\bÕ\u0004\u0010\u0003\u001a\u0006\bÖ\u0004\u0010×\u0004R\u0016\u0010Ø\u0004\u001a\u00030Ù\u0004X¦\u0004¢\u0006\b\u001a\u0006\bÚ\u0004\u0010Û\u0004R\u001f\u0010Ü\u0004\u001a\u00030Ý\u00048 X¡\u0004¢\u0006\u000f\u0012\u0005\bÞ\u0004\u0010\u0003\u001a\u0006\bß\u0004\u0010à\u0004R\u0016\u0010á\u0004\u001a\u00030â\u0004X¦\u0004¢\u0006\b\u001a\u0006\bã\u0004\u0010ä\u0004R\u001f\u0010å\u0004\u001a\u00030æ\u00048 X¡\u0004¢\u0006\u000f\u0012\u0005\bç\u0004\u0010\u0003\u001a\u0006\bè\u0004\u0010é\u0004R\u001f\u0010ê\u0004\u001a\u00030ë\u00048 X¡\u0004¢\u0006\u000f\u0012\u0005\bì\u0004\u0010\u0003\u001a\u0006\bí\u0004\u0010î\u0004R\u001f\u0010ï\u0004\u001a\u00030ð\u00048 X¡\u0004¢\u0006\u000f\u0012\u0005\bñ\u0004\u0010\u0003\u001a\u0006\bò\u0004\u0010ó\u0004R\u001f\u0010ô\u0004\u001a\u00030õ\u00048 X¡\u0004¢\u0006\u000f\u0012\u0005\bö\u0004\u0010\u0003\u001a\u0006\b÷\u0004\u0010ø\u0004R\u001f\u0010ù\u0004\u001a\u00030ú\u00048 X¡\u0004¢\u0006\u000f\u0012\u0005\bû\u0004\u0010\u0003\u001a\u0006\bü\u0004\u0010ý\u0004R\u001f\u0010þ\u0004\u001a\u00030ÿ\u00048 X¡\u0004¢\u0006\u000f\u0012\u0005\b\u0080\u0005\u0010\u0003\u001a\u0006\b\u0081\u0005\u0010\u0082\u0005R\u001f\u0010\u0083\u0005\u001a\u00030\u0084\u00058 X¡\u0004¢\u0006\u000f\u0012\u0005\b\u0085\u0005\u0010\u0003\u001a\u0006\b\u0086\u0005\u0010\u0087\u0005R\u001f\u0010\u0088\u0005\u001a\u00030\u0089\u00058 X¡\u0004¢\u0006\u000f\u0012\u0005\b\u008a\u0005\u0010\u0003\u001a\u0006\b\u008b\u0005\u0010\u008c\u0005R\u001f\u0010\u008d\u0005\u001a\u00030\u008e\u00058 X¡\u0004¢\u0006\u000f\u0012\u0005\b\u008f\u0005\u0010\u0003\u001a\u0006\b\u0090\u0005\u0010\u0091\u0005R\u001f\u0010\u0092\u0005\u001a\u00030\u0093\u00058 X¡\u0004¢\u0006\u000f\u0012\u0005\b\u0094\u0005\u0010\u0003\u001a\u0006\b\u0095\u0005\u0010\u0096\u0005R\u001f\u0010\u0097\u0005\u001a\u00030\u0098\u00058 X¡\u0004¢\u0006\u000f\u0012\u0005\b\u0099\u0005\u0010\u0003\u001a\u0006\b\u009a\u0005\u0010\u009b\u0005R\u0016\u0010\u009c\u0005\u001a\u00030\u009d\u0005X¦\u0004¢\u0006\b\u001a\u0006\b\u009e\u0005\u0010\u009f\u0005R\u001f\u0010 \u0005\u001a\u00030¡\u00058 X¡\u0004¢\u0006\u000f\u0012\u0005\b¢\u0005\u0010\u0003\u001a\u0006\b£\u0005\u0010¤\u0005R\u001f\u0010¥\u0005\u001a\u00030¦\u00058 X¡\u0004¢\u0006\u000f\u0012\u0005\b§\u0005\u0010\u0003\u001a\u0006\b¨\u0005\u0010©\u0005R\u001f\u0010ª\u0005\u001a\u00030«\u00058 X¡\u0004¢\u0006\u000f\u0012\u0005\b¬\u0005\u0010\u0003\u001a\u0006\b\u00ad\u0005\u0010®\u0005R\u001f\u0010¯\u0005\u001a\u00030°\u00058 X¡\u0004¢\u0006\u000f\u0012\u0005\b±\u0005\u0010\u0003\u001a\u0006\b²\u0005\u0010³\u0005R\u001f\u0010´\u0005\u001a\u00030µ\u00058 X¡\u0004¢\u0006\u000f\u0012\u0005\b¶\u0005\u0010\u0003\u001a\u0006\b·\u0005\u0010¸\u0005R\u001f\u0010¹\u0005\u001a\u00030º\u00058 X¡\u0004¢\u0006\u000f\u0012\u0005\b»\u0005\u0010\u0003\u001a\u0006\b¼\u0005\u0010½\u0005R\u001f\u0010¾\u0005\u001a\u00030¿\u00058 X¡\u0004¢\u0006\u000f\u0012\u0005\bÀ\u0005\u0010\u0003\u001a\u0006\bÁ\u0005\u0010Â\u0005R\u001f\u0010Ã\u0005\u001a\u00030Ä\u00058 X¡\u0004¢\u0006\u000f\u0012\u0005\bÅ\u0005\u0010\u0003\u001a\u0006\bÆ\u0005\u0010Ç\u0005R\u001f\u0010È\u0005\u001a\u00030É\u00058 X¡\u0004¢\u0006\u000f\u0012\u0005\bÊ\u0005\u0010\u0003\u001a\u0006\bË\u0005\u0010Ì\u0005R\u001f\u0010Í\u0005\u001a\u00030Î\u00058 X¡\u0004¢\u0006\u000f\u0012\u0005\bÏ\u0005\u0010\u0003\u001a\u0006\bÐ\u0005\u0010Ñ\u0005R\u001f\u0010Ò\u0005\u001a\u00030Ó\u00058 X¡\u0004¢\u0006\u000f\u0012\u0005\bÔ\u0005\u0010\u0003\u001a\u0006\bÕ\u0005\u0010Ö\u0005R\u001f\u0010×\u0005\u001a\u00030Ø\u00058 X¡\u0004¢\u0006\u000f\u0012\u0005\bÙ\u0005\u0010\u0003\u001a\u0006\bÚ\u0005\u0010Û\u0005R\u001f\u0010Ü\u0005\u001a\u00030Ý\u00058 X¡\u0004¢\u0006\u000f\u0012\u0005\bÞ\u0005\u0010\u0003\u001a\u0006\bß\u0005\u0010à\u0005R\u001f\u0010á\u0005\u001a\u00030â\u00058 X¡\u0004¢\u0006\u000f\u0012\u0005\bã\u0005\u0010\u0003\u001a\u0006\bä\u0005\u0010å\u0005R\u001f\u0010æ\u0005\u001a\u00030ç\u00058 X¡\u0004¢\u0006\u000f\u0012\u0005\bè\u0005\u0010\u0003\u001a\u0006\bé\u0005\u0010ê\u0005R\u001f\u0010ë\u0005\u001a\u00030ì\u00058 X¡\u0004¢\u0006\u000f\u0012\u0005\bí\u0005\u0010\u0003\u001a\u0006\bî\u0005\u0010ï\u0005R\u001f\u0010ð\u0005\u001a\u00030ñ\u00058 X¡\u0004¢\u0006\u000f\u0012\u0005\bò\u0005\u0010\u0003\u001a\u0006\bó\u0005\u0010ô\u0005R\u001f\u0010õ\u0005\u001a\u00030ö\u00058 X¡\u0004¢\u0006\u000f\u0012\u0005\b÷\u0005\u0010\u0003\u001a\u0006\bø\u0005\u0010ù\u0005R\u001f\u0010ú\u0005\u001a\u00030û\u00058 X¡\u0004¢\u0006\u000f\u0012\u0005\bü\u0005\u0010\u0003\u001a\u0006\bý\u0005\u0010þ\u0005R\u001f\u0010ÿ\u0005\u001a\u00030\u0080\u00068 X¡\u0004¢\u0006\u000f\u0012\u0005\b\u0081\u0006\u0010\u0003\u001a\u0006\b\u0082\u0006\u0010\u0083\u0006R\u001f\u0010\u0084\u0006\u001a\u00030\u0085\u00068 X¡\u0004¢\u0006\u000f\u0012\u0005\b\u0086\u0006\u0010\u0003\u001a\u0006\b\u0087\u0006\u0010\u0088\u0006R\u001f\u0010\u0089\u0006\u001a\u00030\u008a\u00068 X¡\u0004¢\u0006\u000f\u0012\u0005\b\u008b\u0006\u0010\u0003\u001a\u0006\b\u008c\u0006\u0010\u008d\u0006R\u001f\u0010\u008e\u0006\u001a\u00030\u008f\u00068 X¡\u0004¢\u0006\u000f\u0012\u0005\b\u0090\u0006\u0010\u0003\u001a\u0006\b\u0091\u0006\u0010\u0092\u0006R\u001f\u0010\u0093\u0006\u001a\u00030\u0094\u00068 X¡\u0004¢\u0006\u000f\u0012\u0005\b\u0095\u0006\u0010\u0003\u001a\u0006\b\u0096\u0006\u0010\u0097\u0006R\u0016\u0010\u0098\u0006\u001a\u00030\u0099\u0006X¦\u0004¢\u0006\b\u001a\u0006\b\u009a\u0006\u0010\u009b\u0006R\u0016\u0010\u009c\u0006\u001a\u00030\u009d\u0006X¦\u0004¢\u0006\b\u001a\u0006\b\u009e\u0006\u0010\u009f\u0006R\u0016\u0010 \u0006\u001a\u00030¡\u0006X¦\u0004¢\u0006\b\u001a\u0006\b¢\u0006\u0010£\u0006R\u0016\u0010¤\u0006\u001a\u00030¥\u0006X¦\u0004¢\u0006\b\u001a\u0006\b¦\u0006\u0010§\u0006R\u0016\u0010¨\u0006\u001a\u00030©\u0006X¦\u0004¢\u0006\b\u001a\u0006\bª\u0006\u0010«\u0006R\u0016\u0010¬\u0006\u001a\u00030\u00ad\u0006X¦\u0004¢\u0006\b\u001a\u0006\b®\u0006\u0010¯\u0006R\u001f\u0010°\u0006\u001a\u00030±\u00068 X¡\u0004¢\u0006\u000f\u0012\u0005\b²\u0006\u0010\u0003\u001a\u0006\b³\u0006\u0010´\u0006R\u001f\u0010µ\u0006\u001a\u00030¶\u00068 X¡\u0004¢\u0006\u000f\u0012\u0005\b·\u0006\u0010\u0003\u001a\u0006\b¸\u0006\u0010¹\u0006R\u001f\u0010º\u0006\u001a\u00030»\u00068 X¡\u0004¢\u0006\u000f\u0012\u0005\b¼\u0006\u0010\u0003\u001a\u0006\b½\u0006\u0010¾\u0006R\u001f\u0010¿\u0006\u001a\u00030À\u00068 X¡\u0004¢\u0006\u000f\u0012\u0005\bÁ\u0006\u0010\u0003\u001a\u0006\bÂ\u0006\u0010Ã\u0006R\u001f\u0010Ä\u0006\u001a\u00030Å\u00068 X¡\u0004¢\u0006\u000f\u0012\u0005\bÆ\u0006\u0010\u0003\u001a\u0006\bÇ\u0006\u0010È\u0006R\u001f\u0010É\u0006\u001a\u00030Ê\u00068 X¡\u0004¢\u0006\u000f\u0012\u0005\bË\u0006\u0010\u0003\u001a\u0006\bÌ\u0006\u0010Í\u0006R\u001f\u0010Î\u0006\u001a\u00030Ï\u00068 X¡\u0004¢\u0006\u000f\u0012\u0005\bÐ\u0006\u0010\u0003\u001a\u0006\bÑ\u0006\u0010Ò\u0006R\u001f\u0010Ó\u0006\u001a\u00030Ô\u00068 X¡\u0004¢\u0006\u000f\u0012\u0005\bÕ\u0006\u0010\u0003\u001a\u0006\bÖ\u0006\u0010×\u0006R\u001f\u0010Ø\u0006\u001a\u00030Ù\u00068 X¡\u0004¢\u0006\u000f\u0012\u0005\bÚ\u0006\u0010\u0003\u001a\u0006\bÛ\u0006\u0010Ü\u0006R\u001f\u0010Ý\u0006\u001a\u00030Þ\u00068 X¡\u0004¢\u0006\u000f\u0012\u0005\bß\u0006\u0010\u0003\u001a\u0006\bà\u0006\u0010á\u0006R\u001f\u0010â\u0006\u001a\u00030ã\u00068 X¡\u0004¢\u0006\u000f\u0012\u0005\bä\u0006\u0010\u0003\u001a\u0006\bå\u0006\u0010æ\u0006R\u001f\u0010ç\u0006\u001a\u00030è\u00068 X¡\u0004¢\u0006\u000f\u0012\u0005\bé\u0006\u0010\u0003\u001a\u0006\bê\u0006\u0010ë\u0006R\u001f\u0010ì\u0006\u001a\u00030í\u00068 X¡\u0004¢\u0006\u000f\u0012\u0005\bî\u0006\u0010\u0003\u001a\u0006\bï\u0006\u0010ð\u0006R\u001f\u0010ñ\u0006\u001a\u00030ò\u00068 X¡\u0004¢\u0006\u000f\u0012\u0005\bó\u0006\u0010\u0003\u001a\u0006\bô\u0006\u0010õ\u0006R\u001f\u0010ö\u0006\u001a\u00030÷\u00068 X¡\u0004¢\u0006\u000f\u0012\u0005\bø\u0006\u0010\u0003\u001a\u0006\bù\u0006\u0010ú\u0006R\u001f\u0010û\u0006\u001a\u00030ü\u00068 X¡\u0004¢\u0006\u000f\u0012\u0005\bý\u0006\u0010\u0003\u001a\u0006\bþ\u0006\u0010ÿ\u0006R\u001f\u0010\u0080\u0007\u001a\u00030\u0081\u00078 X¡\u0004¢\u0006\u000f\u0012\u0005\b\u0082\u0007\u0010\u0003\u001a\u0006\b\u0083\u0007\u0010\u0084\u0007R\u001f\u0010\u0085\u0007\u001a\u00030\u0086\u00078 X¡\u0004¢\u0006\u000f\u0012\u0005\b\u0087\u0007\u0010\u0003\u001a\u0006\b\u0088\u0007\u0010\u0089\u0007R\u001f\u0010\u008a\u0007\u001a\u00030\u008b\u00078 X¡\u0004¢\u0006\u000f\u0012\u0005\b\u008c\u0007\u0010\u0003\u001a\u0006\b\u008d\u0007\u0010\u008e\u0007R\u001f\u0010\u008f\u0007\u001a\u00030\u0090\u00078 X¡\u0004¢\u0006\u000f\u0012\u0005\b\u0091\u0007\u0010\u0003\u001a\u0006\b\u0092\u0007\u0010\u0093\u0007R\u001f\u0010\u0094\u0007\u001a\u00030\u0095\u00078 X¡\u0004¢\u0006\u000f\u0012\u0005\b\u0096\u0007\u0010\u0003\u001a\u0006\b\u0097\u0007\u0010\u0098\u0007R\u001f\u0010\u0099\u0007\u001a\u00030\u009a\u00078 X¡\u0004¢\u0006\u000f\u0012\u0005\b\u009b\u0007\u0010\u0003\u001a\u0006\b\u009c\u0007\u0010\u009d\u0007R\u001f\u0010\u009e\u0007\u001a\u00030\u009f\u00078 X¡\u0004¢\u0006\u000f\u0012\u0005\b \u0007\u0010\u0003\u001a\u0006\b¡\u0007\u0010¢\u0007R\u001f\u0010£\u0007\u001a\u00030¤\u00078 X¡\u0004¢\u0006\u000f\u0012\u0005\b¥\u0007\u0010\u0003\u001a\u0006\b¦\u0007\u0010§\u0007R\u001f\u0010¨\u0007\u001a\u00030©\u00078 X¡\u0004¢\u0006\u000f\u0012\u0005\bª\u0007\u0010\u0003\u001a\u0006\b«\u0007\u0010¬\u0007R\u001f\u0010\u00ad\u0007\u001a\u00030®\u00078 X¡\u0004¢\u0006\u000f\u0012\u0005\b¯\u0007\u0010\u0003\u001a\u0006\b°\u0007\u0010±\u0007R\u001f\u0010²\u0007\u001a\u00030³\u00078 X¡\u0004¢\u0006\u000f\u0012\u0005\b´\u0007\u0010\u0003\u001a\u0006\bµ\u0007\u0010¶\u0007R\u0016\u0010·\u0007\u001a\u00030¸\u0007X¦\u0004¢\u0006\b\u001a\u0006\b¹\u0007\u0010º\u0007R\u001f\u0010»\u0007\u001a\u00030¼\u00078 X¡\u0004¢\u0006\u000f\u0012\u0005\b½\u0007\u0010\u0003\u001a\u0006\b¾\u0007\u0010¿\u0007R\u001f\u0010À\u0007\u001a\u00030Á\u00078 X¡\u0004¢\u0006\u000f\u0012\u0005\bÂ\u0007\u0010\u0003\u001a\u0006\bÃ\u0007\u0010Ä\u0007R\u001f\u0010Å\u0007\u001a\u00030Æ\u00078 X¡\u0004¢\u0006\u000f\u0012\u0005\bÇ\u0007\u0010\u0003\u001a\u0006\bÈ\u0007\u0010É\u0007R\u0016\u0010Ê\u0007\u001a\u00030Ë\u0007X¦\u0004¢\u0006\b\u001a\u0006\bÌ\u0007\u0010Í\u0007R\u0016\u0010Î\u0007\u001a\u00030Ï\u0007X¦\u0004¢\u0006\b\u001a\u0006\bÐ\u0007\u0010Ñ\u0007R\u0016\u0010Ò\u0007\u001a\u00030Ó\u0007X¦\u0004¢\u0006\b\u001a\u0006\bÔ\u0007\u0010Õ\u0007R\u0016\u0010Ö\u0007\u001a\u00030×\u0007X¦\u0004¢\u0006\b\u001a\u0006\bØ\u0007\u0010Ù\u0007R\u0016\u0010Ú\u0007\u001a\u00030Û\u0007X¦\u0004¢\u0006\b\u001a\u0006\bÜ\u0007\u0010Ý\u0007R\u001f\u0010Þ\u0007\u001a\u00030ß\u00078 X¡\u0004¢\u0006\u000f\u0012\u0005\bà\u0007\u0010\u0003\u001a\u0006\bá\u0007\u0010â\u0007R\u001f\u0010ã\u0007\u001a\u00030ä\u00078 X¡\u0004¢\u0006\u000f\u0012\u0005\bå\u0007\u0010\u0003\u001a\u0006\bæ\u0007\u0010ç\u0007R\u001f\u0010è\u0007\u001a\u00030é\u00078 X¡\u0004¢\u0006\u000f\u0012\u0005\bê\u0007\u0010\u0003\u001a\u0006\bë\u0007\u0010ì\u0007R\u001f\u0010í\u0007\u001a\u00030î\u00078 X¡\u0004¢\u0006\u000f\u0012\u0005\bï\u0007\u0010\u0003\u001a\u0006\bð\u0007\u0010ñ\u0007R\u001f\u0010ò\u0007\u001a\u00030ó\u00078 X¡\u0004¢\u0006\u000f\u0012\u0005\bô\u0007\u0010\u0003\u001a\u0006\bõ\u0007\u0010ö\u0007R\u0016\u0010÷\u0007\u001a\u00030ø\u0007X¦\u0004¢\u0006\b\u001a\u0006\bù\u0007\u0010ú\u0007R\u0016\u0010û\u0007\u001a\u00030ü\u0007X¦\u0004¢\u0006\b\u001a\u0006\bý\u0007\u0010þ\u0007¨\u0006\u0080\b"}, d2 = {"Lcom/obric/memorydata/database/manager/MemoryFrameDb;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "openHelper", "Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "getOpenHelper", "()Landroidx/sqlite/db/SupportSQLiteOpenHelper;", "queryExecutor", "Ljava/util/concurrent/Executor;", "getQueryExecutor", "()Ljava/util/concurrent/Executor;", ChatMessage.TYPE_QUERY, "Landroid/database/Cursor;", "", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)Landroid/database/Cursor;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "signal", "Landroid/os/CancellationSignal;", "invalidationTracker", "Landroidx/room/InvalidationTracker;", "getInvalidationTracker", "()Landroidx/room/InvalidationTracker;", "clearAllTables", "", "isOpen", "", "()Z", "geographyDao", "Lcom/obric/memorydata/database/dao/GeographyDao;", "getGeographyDao", "()Lcom/obric/memorydata/database/dao/GeographyDao;", "mobileCellularDao", "Lcom/obric/memorydata/database/dao/MobileCellularDao;", "getMobileCellularDao", "()Lcom/obric/memorydata/database/dao/MobileCellularDao;", "wifiDao", "Lcom/obric/memorydata/database/dao/WifiDao;", "getWifiDao", "()Lcom/obric/memorydata/database/dao/WifiDao;", "wifiListDao", "Lcom/obric/memorydata/database/dao/WifiListDao;", "getWifiListDao", "()Lcom/obric/memorydata/database/dao/WifiListDao;", "locationDao", "Lcom/obric/memorydata/database/dao/LocationDao;", "getLocationDao", "()Lcom/obric/memorydata/database/dao/LocationDao;", "screenStateDao", "Lcom/obric/memorydata/database/dao/ScreenStateDao;", "getScreenStateDao", "()Lcom/obric/memorydata/database/dao/ScreenStateDao;", "middleUserProfileDao", "Lcom/obric/memorydata/database/legacy/dao/MiddleUserProfileDaoOld;", "getMiddleUserProfileDao$database_obricRelease$annotations", "getMiddleUserProfileDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/MiddleUserProfileDaoOld;", "userProfileDao", "Lcom/obric/memorydata/database/legacy/dao/UserProfileDaoOld;", "getUserProfileDao$database_obricRelease$annotations", "getUserProfileDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/UserProfileDaoOld;", "bluetoothDeviceDao", "Lcom/obric/memorydata/database/dao/BluetoothDeviceDao;", "getBluetoothDeviceDao", "()Lcom/obric/memorydata/database/dao/BluetoothDeviceDao;", "appActivityDao", "Lcom/obric/memorydata/database/dao/AppActivityDao;", "getAppActivityDao", "()Lcom/obric/memorydata/database/dao/AppActivityDao;", "streamVolumeDao", "Lcom/obric/memorydata/database/dao/StreamVolumeDao;", "getStreamVolumeDao", "()Lcom/obric/memorydata/database/dao/StreamVolumeDao;", "settingsChangedDao", "Lcom/obric/memorydata/database/dao/SettingsChangedDao;", "getSettingsChangedDao", "()Lcom/obric/memorydata/database/dao/SettingsChangedDao;", "screenBrightnessDao", "Lcom/obric/memorydata/database/dao/ScreenBrightnessDao;", "getScreenBrightnessDao", "()Lcom/obric/memorydata/database/dao/ScreenBrightnessDao;", "packageEventDao", "Lcom/obric/memorydata/database/dao/PackageEventDao;", "getPackageEventDao", "()Lcom/obric/memorydata/database/dao/PackageEventDao;", "osNotificationDao", "Lcom/obric/memorydata/database/dao/OsNotificationDao;", "getOsNotificationDao", "()Lcom/obric/memorydata/database/dao/OsNotificationDao;", "osAudioPlayDao", "Lcom/obric/memorydata/database/dao/OsAudioPlayDao;", "getOsAudioPlayDao", "()Lcom/obric/memorydata/database/dao/OsAudioPlayDao;", "networkStatusDao", "Lcom/obric/memorydata/database/dao/NetworkStatusDao;", "getNetworkStatusDao", "()Lcom/obric/memorydata/database/dao/NetworkStatusDao;", "movementStateDao", "Lcom/obric/memorydata/database/dao/MovementStateDao;", "getMovementStateDao", "()Lcom/obric/memorydata/database/dao/MovementStateDao;", "lightSensorDao", "Lcom/obric/memorydata/database/dao/LightSensorDao;", "getLightSensorDao", "()Lcom/obric/memorydata/database/dao/LightSensorDao;", "languageChangeEventDao", "Lcom/obric/memorydata/database/dao/LanguageChangeEventDao;", "getLanguageChangeEventDao", "()Lcom/obric/memorydata/database/dao/LanguageChangeEventDao;", "batteryStateDao", "Lcom/obric/memorydata/database/dao/BatteryStateDao;", "getBatteryStateDao", "()Lcom/obric/memorydata/database/dao/BatteryStateDao;", "deviceBootDao", "Lcom/obric/memorydata/database/dao/DeviceBootDao;", "getDeviceBootDao", "()Lcom/obric/memorydata/database/dao/DeviceBootDao;", "deviceShutdownDao", "Lcom/obric/memorydata/database/dao/DeviceShutdownDao;", "getDeviceShutdownDao", "()Lcom/obric/memorydata/database/dao/DeviceShutdownDao;", "alarmDao", "Lcom/obric/memorydata/database/dao/AlarmDao;", "getAlarmDao", "()Lcom/obric/memorydata/database/dao/AlarmDao;", "appUsageDao", "Lcom/obric/memorydata/database/dao/AppUsageDao;", "getAppUsageDao", "()Lcom/obric/memorydata/database/dao/AppUsageDao;", "networkTypeDao", "Lcom/obric/memorydata/database/dao/NetworkTypeDao;", "getNetworkTypeDao", "()Lcom/obric/memorydata/database/dao/NetworkTypeDao;", "predictAppResultDao", "Lcom/obric/memorydata/database/dao/PredictAppDao;", "getPredictAppResultDao", "()Lcom/obric/memorydata/database/dao/PredictAppDao;", "userActionRecorderDao", "Lcom/obric/memorydata/database/dao/UserActionRecorderDao;", "getUserActionRecorderDao", "()Lcom/obric/memorydata/database/dao/UserActionRecorderDao;", "predictSleepWakeupDao", "Lcom/obric/memorydata/database/dao/PredictSleepWakeupDao;", "getPredictSleepWakeupDao", "()Lcom/obric/memorydata/database/dao/PredictSleepWakeupDao;", "poiInfoGroupDao", "Lcom/obric/memorydata/database/dao/PoiInfoGroupDao;", "getPoiInfoGroupDao", "()Lcom/obric/memorydata/database/dao/PoiInfoGroupDao;", "poiReqRecorderDao", "Lcom/obric/memorydata/database/dao/PoiReqRecorderDao;", "getPoiReqRecorderDao", "()Lcom/obric/memorydata/database/dao/PoiReqRecorderDao;", "uploadDataDao", "Lcom/obric/memorydata/database/dao/UploadDataDao;", "getUploadDataDao", "()Lcom/obric/memorydata/database/dao/UploadDataDao;", "indexPendingDao", "Lcom/obric/memorydata/database/dao/IndexPendingDao;", "getIndexPendingDao", "()Lcom/obric/memorydata/database/dao/IndexPendingDao;", "entityIndexLifecycleDao", "Lcom/obric/memorydata/database/dao/EntityIndexLifecycleDao;", "getEntityIndexLifecycleDao", "()Lcom/obric/memorydata/database/dao/EntityIndexLifecycleDao;", "messageRawDbDao", "Lcom/obric/memorydata/database/dao/MessageRawDbDao;", "getMessageRawDbDao", "()Lcom/obric/memorydata/database/dao/MessageRawDbDao;", "messageHistoryRawDbDao", "Lcom/obric/memorydata/database/dao/MessageHistoryRawDbDao;", "getMessageHistoryRawDbDao", "()Lcom/obric/memorydata/database/dao/MessageHistoryRawDbDao;", "contactRawDbDao", "Lcom/obric/memorydata/database/dao/ContactRawDbDao;", "getContactRawDbDao", "()Lcom/obric/memorydata/database/dao/ContactRawDbDao;", "contactRawHistoryDbDao", "Lcom/obric/memorydata/database/dao/ContactHistoryEntityDao;", "getContactRawHistoryDbDao", "()Lcom/obric/memorydata/database/dao/ContactHistoryEntityDao;", "icsProtocolRawDbDao", "Lcom/obric/memorydata/database/dao/ICSProtocolEntityRawDbDao;", "getIcsProtocolRawDbDao", "()Lcom/obric/memorydata/database/dao/ICSProtocolEntityRawDbDao;", "icsProtocolHistoryRawDbDao", "Lcom/obric/memorydata/database/dao/ICSProtocolHistoryEntityDao;", "getIcsProtocolHistoryRawDbDao", "()Lcom/obric/memorydata/database/dao/ICSProtocolHistoryEntityDao;", "doubaoAccountEntityRawDbDao", "Lcom/obric/memorydata/database/dao/DoubaoAccountEntityRawDbDao;", "getDoubaoAccountEntityRawDbDao", "()Lcom/obric/memorydata/database/dao/DoubaoAccountEntityRawDbDao;", "callHistoryRawDbDao", "Lcom/obric/memorydata/database/dao/CallHistoryRawDbDao;", "getCallHistoryRawDbDao", "()Lcom/obric/memorydata/database/dao/CallHistoryRawDbDao;", "callHistoryHistoryEntityDao", "Lcom/obric/memorydata/database/dao/CallHistoryHistoryEntityDao;", "getCallHistoryHistoryEntityDao", "()Lcom/obric/memorydata/database/dao/CallHistoryHistoryEntityDao;", "noteRawDbDao", "Lcom/obric/memorydata/database/dao/NoteRawDbDao;", "getNoteRawDbDao", "()Lcom/obric/memorydata/database/dao/NoteRawDbDao;", "noteHistoryRawDbDao", "Lcom/obric/memorydata/database/entity/NoteHistoryRawDbDao;", "getNoteHistoryRawDbDao", "()Lcom/obric/memorydata/database/entity/NoteHistoryRawDbDao;", "photoRawDbDao", "Lcom/obric/memorydata/database/dao/PhotoRawDbDao;", "getPhotoRawDbDao", "()Lcom/obric/memorydata/database/dao/PhotoRawDbDao;", "commonPhotoRawDbDao", "Lcom/obric/memorydata/database/dao/CommonPhotoRawDbDao;", "getCommonPhotoRawDbDao", "()Lcom/obric/memorydata/database/dao/CommonPhotoRawDbDao;", "photoFaceRawDbDao", "Lcom/obric/memorydata/database/dao/PhotoFaceRawDbDao;", "getPhotoFaceRawDbDao", "()Lcom/obric/memorydata/database/dao/PhotoFaceRawDbDao;", "photoFaceHistoryRawDbDao", "Lcom/obric/memorydata/database/entity/PhotoFaceHistoryRawDbDao;", "getPhotoFaceHistoryRawDbDao", "()Lcom/obric/memorydata/database/entity/PhotoFaceHistoryRawDbDao;", "metaLocationRawDbDao", "Lcom/obric/memorydata/database/dao/MetaLocationRawDbDao;", "getMetaLocationRawDbDao", "()Lcom/obric/memorydata/database/dao/MetaLocationRawDbDao;", "locationAddressCacheDao", "Lcom/obric/memorydata/database/dao/LocationAddressCacheDao;", "getLocationAddressCacheDao", "()Lcom/obric/memorydata/database/dao/LocationAddressCacheDao;", "metaTagRawDbDao", "Lcom/obric/memorydata/database/dao/MetaTagRawDbDao;", "getMetaTagRawDbDao", "()Lcom/obric/memorydata/database/dao/MetaTagRawDbDao;", "albumRawDbDao", "Lcom/obric/memorydata/database/dao/AlbumRawDbDao;", "getAlbumRawDbDao", "()Lcom/obric/memorydata/database/dao/AlbumRawDbDao;", "albumHistoryEntityDao", "Lcom/obric/memorydata/database/dao/AlbumHistoryEntityDao;", "getAlbumHistoryEntityDao", "()Lcom/obric/memorydata/database/dao/AlbumHistoryEntityDao;", "alarmRawDbDao", "Lcom/obric/memorydata/database/dao/AlarmRawDbDao;", "getAlarmRawDbDao", "()Lcom/obric/memorydata/database/dao/AlarmRawDbDao;", "videoFrameRawDbDao", "Lcom/obric/memorydata/database/dao/VideoFrameRawDbDao;", "getVideoFrameRawDbDao", "()Lcom/obric/memorydata/database/dao/VideoFrameRawDbDao;", "commonVideoFrameRawDbDao", "Lcom/obric/memorydata/database/dao/CommonVideoFrameRawDbDao;", "getCommonVideoFrameRawDbDao", "()Lcom/obric/memorydata/database/dao/CommonVideoFrameRawDbDao;", "recordingRawDbDao", "Lcom/obric/memorydata/database/dao/RecordingRawDbDao;", "getRecordingRawDbDao", "()Lcom/obric/memorydata/database/dao/RecordingRawDbDao;", "recordingHistoryRawDbDao", "Lcom/obric/memorydata/database/entity/RecordingHistoryRawDbDao;", "getRecordingHistoryRawDbDao", "()Lcom/obric/memorydata/database/entity/RecordingHistoryRawDbDao;", "recordingTextRawDbDao", "Lcom/obric/memorydata/database/dao/RecordingTextRawDbDao;", "getRecordingTextRawDbDao", "()Lcom/obric/memorydata/database/dao/RecordingTextRawDbDao;", "auditoryRecordingRawDbDao", "Lcom/obric/memorydata/database/dao/AuditoryRecordingRawDbDao;", "getAuditoryRecordingRawDbDao", "()Lcom/obric/memorydata/database/dao/AuditoryRecordingRawDbDao;", "auditoryRecordingHistoryEntityDao", "Lcom/obric/memorydata/database/entity/AuditoryRecordingHistoryEntityDao;", "getAuditoryRecordingHistoryEntityDao", "()Lcom/obric/memorydata/database/entity/AuditoryRecordingHistoryEntityDao;", "auditoryRecordingTextRawDbDao", "Lcom/obric/memorydata/database/dao/AuditoryRecordingTextRawDbDao;", "getAuditoryRecordingTextRawDbDao", "()Lcom/obric/memorydata/database/dao/AuditoryRecordingTextRawDbDao;", "auditoryRecordingTextVectorCopilotDao", "Lcom/obric/memorydata/database/dao/AuditoryRecordingEntityTextVectorCopilotDao;", "getAuditoryRecordingTextVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/AuditoryRecordingEntityTextVectorCopilotDao;", "auditoryRecordingTextTextVectorCopilotDao", "Lcom/obric/memorydata/database/dao/AuditoryRecordingTextEntityTextVectorCopilotDao;", "getAuditoryRecordingTextTextVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/AuditoryRecordingTextEntityTextVectorCopilotDao;", "scheduleRawDbDao", "Lcom/obric/memorydata/database/dao/ScheduleRawDbDao;", "getScheduleRawDbDao", "()Lcom/obric/memorydata/database/dao/ScheduleRawDbDao;", "browserBookmarkRawDbDao", "Lcom/obric/memorydata/database/dao/BrowserBookmarkRawDbDao;", "getBrowserBookmarkRawDbDao", "()Lcom/obric/memorydata/database/dao/BrowserBookmarkRawDbDao;", "browserBookmarkHistoryEntityDao", "Lcom/obric/memorydata/database/dao/BrowserBookmarkHistoryEntityDao;", "getBrowserBookmarkHistoryEntityDao", "()Lcom/obric/memorydata/database/dao/BrowserBookmarkHistoryEntityDao;", "fileRawDbDao", "Lcom/obric/memorydata/database/dao/FileRawDbDao;", "getFileRawDbDao", "()Lcom/obric/memorydata/database/dao/FileRawDbDao;", "fileRawHistoryDbDao", "Lcom/obric/memorydata/database/dao/FileHistoryEntityDao;", "getFileRawHistoryDbDao", "()Lcom/obric/memorydata/database/dao/FileHistoryEntityDao;", "fileTextRawDbDao", "Lcom/obric/memorydata/database/dao/FileTextRawDbDao;", "getFileTextRawDbDao", "()Lcom/obric/memorydata/database/dao/FileTextRawDbDao;", "noteRecordingRawDbDao", "Lcom/obric/memorydata/database/dao/NoteRecordingRawDbDao;", "getNoteRecordingRawDbDao", "()Lcom/obric/memorydata/database/dao/NoteRecordingRawDbDao;", "noteRecordingTextRawDbDao", "Lcom/obric/memorydata/database/dao/NoteRecordingTextRawDbDao;", "getNoteRecordingTextRawDbDao", "()Lcom/obric/memorydata/database/dao/NoteRecordingTextRawDbDao;", "messageTextVectorCopilotDao", "Lcom/obric/memorydata/database/dao/MessageEntityTextVectorCopilotDao;", "getMessageTextVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/MessageEntityTextVectorCopilotDao;", "messageImageVectorCopilotDao", "Lcom/obric/memorydata/database/dao/MessageEntityImageVectorCopilotDao;", "getMessageImageVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/MessageEntityImageVectorCopilotDao;", "messageEntityContentTimeDao", "Lcom/obric/memorydata/database/dao/MessageEntityContentTimeDao;", "getMessageEntityContentTimeDao", "()Lcom/obric/memorydata/database/dao/MessageEntityContentTimeDao;", "contactTextVectorCopilotDao", "Lcom/obric/memorydata/database/dao/ContactEntityTextVectorCopilotDao;", "getContactTextVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/ContactEntityTextVectorCopilotDao;", "contactImageVectorCopilotDao", "Lcom/obric/memorydata/database/dao/ContactEntityImageVectorCopilotDao;", "getContactImageVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/ContactEntityImageVectorCopilotDao;", "callHistoryTextVectorCopilotDao", "Lcom/obric/memorydata/database/dao/CallHistoryEntityTextVectorCopilotDao;", "getCallHistoryTextVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/CallHistoryEntityTextVectorCopilotDao;", "noteEntityContentTimeDao", "Lcom/obric/memorydata/database/dao/NoteEntityContentTimeDao;", "getNoteEntityContentTimeDao", "()Lcom/obric/memorydata/database/dao/NoteEntityContentTimeDao;", "recordingEntityContentTimeDao", "Lcom/obric/memorydata/database/dao/RecordingEntityContentTimeDao;", "getRecordingEntityContentTimeDao", "()Lcom/obric/memorydata/database/dao/RecordingEntityContentTimeDao;", "callHistoryEntityContentTimeDao", "Lcom/obric/memorydata/database/dao/CallHistoryEntityContentTimeDao;", "getCallHistoryEntityContentTimeDao", "()Lcom/obric/memorydata/database/dao/CallHistoryEntityContentTimeDao;", "memoryEntityContentTimeDao", "Lcom/obric/memorydata/database/dao/MemoryEntityContentTimeDao;", "getMemoryEntityContentTimeDao", "()Lcom/obric/memorydata/database/dao/MemoryEntityContentTimeDao;", "noteTextVectorCopilotDao", "Lcom/obric/memorydata/database/dao/NoteEntityTextVectorCopilotDao;", "getNoteTextVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/NoteEntityTextVectorCopilotDao;", "noteImageVectorCopilotDao", "Lcom/obric/memorydata/database/dao/NoteEntityImageVectorCopilotDao;", "getNoteImageVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/NoteEntityImageVectorCopilotDao;", "photoTextVectorCopilotDao", "Lcom/obric/memorydata/database/dao/PhotoEntityTextVectorCopilotDao;", "getPhotoTextVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/PhotoEntityTextVectorCopilotDao;", "photoImageVectorCopilotDao", "Lcom/obric/memorydata/database/dao/PhotoEntityImageVectorCopilotDao;", "getPhotoImageVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/PhotoEntityImageVectorCopilotDao;", "rawPhotoContentTimeDao", "Lcom/obric/memorydata/database/dao/RawPhotoContentTimeDao;", "getRawPhotoContentTimeDao", "()Lcom/obric/memorydata/database/dao/RawPhotoContentTimeDao;", "commonPhotoTextVectorCopilotDao", "Lcom/obric/memorydata/database/dao/CommonPhotoEntityTextVectorCopilotDao;", "getCommonPhotoTextVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/CommonPhotoEntityTextVectorCopilotDao;", "commonPhotoImageVectorCopilotDao", "Lcom/obric/memorydata/database/dao/CommonPhotoEntityImageVectorCopilotDao;", "getCommonPhotoImageVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/CommonPhotoEntityImageVectorCopilotDao;", "videoFrameTextVectorCopilotDao", "Lcom/obric/memorydata/database/dao/VideoFrameEntityTextVectorCopilotDao;", "getVideoFrameTextVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/VideoFrameEntityTextVectorCopilotDao;", "videoFrameImageVectorCopilotDao", "Lcom/obric/memorydata/database/dao/VideoFrameEntityImageVectorCopilotDao;", "getVideoFrameImageVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/VideoFrameEntityImageVectorCopilotDao;", "commonVideoFrameTextVectorCopilotDao", "Lcom/obric/memorydata/database/dao/CommonVideoFrameEntityTextVectorCopilotDao;", "getCommonVideoFrameTextVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/CommonVideoFrameEntityTextVectorCopilotDao;", "commonVideoFrameImageVectorCopilotDao", "Lcom/obric/memorydata/database/dao/CommonVideoFrameEntityImageVectorCopilotDao;", "getCommonVideoFrameImageVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/CommonVideoFrameEntityImageVectorCopilotDao;", "metaLocationTextVectorCopilotDao", "Lcom/obric/memorydata/database/dao/MetaLocationEntityTextVectorCopilotDao;", "getMetaLocationTextVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/MetaLocationEntityTextVectorCopilotDao;", "alarmTextVectorCopilotDao", "Lcom/obric/memorydata/database/dao/AlarmEntityTextVectorCopilotDao;", "getAlarmTextVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/AlarmEntityTextVectorCopilotDao;", "scheduleTextVectorCopilotDao", "Lcom/obric/memorydata/database/dao/ScheduleEntityTextVectorCopilotDao;", "getScheduleTextVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/ScheduleEntityTextVectorCopilotDao;", "evaluationSourceDataDao", "Lcom/obric/memorydata/database/dao/EvaluationSourceDataDao;", "getEvaluationSourceDataDao", "()Lcom/obric/memorydata/database/dao/EvaluationSourceDataDao;", "rawAppChatDao", "Lcom/obric/memorydata/database/dao/RawChatAppChatDao;", "getRawAppChatDao", "()Lcom/obric/memorydata/database/dao/RawChatAppChatDao;", "elementKGIndexPendingDao", "Lcom/obric/memorydata/database/dao/ElementKGIndexPendingDao;", "getElementKGIndexPendingDao", "()Lcom/obric/memorydata/database/dao/ElementKGIndexPendingDao;", "embeddingVectorCacheDao", "Lcom/obric/memorydata/database/dao/EmbeddingVectorCacheDao;", "getEmbeddingVectorCacheDao", "()Lcom/obric/memorydata/database/dao/EmbeddingVectorCacheDao;", "episodicMemoryDao", "Lcom/obric/memorydata/database/legacy/dao/EpisodicMemoryDaoOld;", "getEpisodicMemoryDao$database_obricRelease$annotations", "getEpisodicMemoryDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/EpisodicMemoryDaoOld;", "episodicMemoryTextVectorCopilotDao", "Lcom/obric/memorydata/database/legacy/dao/EpisodicMemoryTextVectorCopilotDaoOld;", "getEpisodicMemoryTextVectorCopilotDao$database_obricRelease$annotations", "getEpisodicMemoryTextVectorCopilotDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/EpisodicMemoryTextVectorCopilotDaoOld;", "episodicMemoryContentTimeDao", "Lcom/obric/memorydata/database/legacy/dao/EpisodicMemoryContentTimeDaoOld;", "getEpisodicMemoryContentTimeDao$database_obricRelease$annotations", "getEpisodicMemoryContentTimeDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/EpisodicMemoryContentTimeDaoOld;", "episodicTopicMemoryDao", "Lcom/obric/memorydata/database/legacy/dao/EpisodicTopicMemoryDaoOld;", "getEpisodicTopicMemoryDao$database_obricRelease$annotations", "getEpisodicTopicMemoryDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/EpisodicTopicMemoryDaoOld;", "episodicTopicMemoryTextVectorCopilotDao", "Lcom/obric/memorydata/database/legacy/dao/EpisodicTopicMemoryTextVectorCopilotDaoOld;", "getEpisodicTopicMemoryTextVectorCopilotDao$database_obricRelease$annotations", "getEpisodicTopicMemoryTextVectorCopilotDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/EpisodicTopicMemoryTextVectorCopilotDaoOld;", "proactiveMemoryProcessInfoDao", "Lcom/obric/memorydata/database/dao/ProactiveMemoryProcessInfoDao;", "getProactiveMemoryProcessInfoDao", "()Lcom/obric/memorydata/database/dao/ProactiveMemoryProcessInfoDao;", "proactiveMemorySyncPendingDao", "Lcom/obric/memorydata/database/dao/ProactiveMemorySyncPendingDao;", "getProactiveMemorySyncPendingDao", "()Lcom/obric/memorydata/database/dao/ProactiveMemorySyncPendingDao;", "rawMemoryEntityDao", "Lcom/obric/memorydata/database/dao/MemoryEntityRawDbDao;", "getRawMemoryEntityDao", "()Lcom/obric/memorydata/database/dao/MemoryEntityRawDbDao;", "rawMemoryHistoryRawDbDao", "Lcom/obric/memorydata/database/dao/RawMemoryHistoryRawDbDao;", "getRawMemoryHistoryRawDbDao", "()Lcom/obric/memorydata/database/dao/RawMemoryHistoryRawDbDao;", "memoryEntityTextVectorCopilotDao", "Lcom/obric/memorydata/database/dao/MemoryEntityTextVectorCopilotDao;", "getMemoryEntityTextVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/MemoryEntityTextVectorCopilotDao;", "dataBuildMemoryStatusDao", "Lcom/obric/memorydata/database/dao/DataBuildMemoryStatusDao;", "getDataBuildMemoryStatusDao", "()Lcom/obric/memorydata/database/dao/DataBuildMemoryStatusDao;", "batchChatDao", "Lcom/obric/memorydata/database/dao/BatchChatDao;", "getBatchChatDao", "()Lcom/obric/memorydata/database/dao/BatchChatDao;", "orderHitDao", "Lcom/obric/memorydata/database/dao/OrderHitDao;", "getOrderHitDao", "()Lcom/obric/memorydata/database/dao/OrderHitDao;", "memoryLocationRawDbDao", "Lcom/obric/memorydata/database/dao/MemoryLocationRawDbDao;", "getMemoryLocationRawDbDao", "()Lcom/obric/memorydata/database/dao/MemoryLocationRawDbDao;", "memoryLocationTextVectorCopilotDao", "Lcom/obric/memorydata/database/dao/MemoryLocationEntityTextVectorCopilotDao;", "getMemoryLocationTextVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/MemoryLocationEntityTextVectorCopilotDao;", "fileTextVectorCopilotDao", "Lcom/obric/memorydata/database/dao/FileEntityTextVectorCopilotDao;", "getFileTextVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/FileEntityTextVectorCopilotDao;", "fileTextTextVectorCopilotDao", "Lcom/obric/memorydata/database/dao/FileTextEntityTextVectorCopilotDao;", "getFileTextTextVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/FileTextEntityTextVectorCopilotDao;", "recordingTextVectorCopilotDao", "Lcom/obric/memorydata/database/dao/RecordingEntityTextVectorCopilotDao;", "getRecordingTextVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/RecordingEntityTextVectorCopilotDao;", "recordingTextTextVectorCopilotDao", "Lcom/obric/memorydata/database/dao/RecordingTextEntityTextVectorCopilotDao;", "getRecordingTextTextVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/RecordingTextEntityTextVectorCopilotDao;", "noteRecordingTextVectorCopilotDao", "Lcom/obric/memorydata/database/dao/NoteRecordingEntityTextVectorCopilotDao;", "getNoteRecordingTextVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/NoteRecordingEntityTextVectorCopilotDao;", "noteRecordingTextTextVectorCopilotDao", "Lcom/obric/memorydata/database/dao/NoteRecordingTextEntityTextVectorCopilotDao;", "getNoteRecordingTextTextVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/NoteRecordingTextEntityTextVectorCopilotDao;", "memoryMapTableDao", "Lcom/obric/memorydata/database/dao/MemoryMapTableDao;", "getMemoryMapTableDao", "()Lcom/obric/memorydata/database/dao/MemoryMapTableDao;", "memoryEntityCorrelationDao", "Lcom/obric/memorydata/database/legacy/dao/MemoryEntityCorrelationDaoOld;", "getMemoryEntityCorrelationDao$database_obricRelease$annotations", "getMemoryEntityCorrelationDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/MemoryEntityCorrelationDaoOld;", "countdownRawDbDao", "Lcom/obric/memorydata/database/dao/CountdownRawDbDao;", "getCountdownRawDbDao", "()Lcom/obric/memorydata/database/dao/CountdownRawDbDao;", "countdownTextVectorCopilotDao", "Lcom/obric/memorydata/database/dao/CountdownEntityTextVectorCopilotDao;", "getCountdownTextVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/CountdownEntityTextVectorCopilotDao;", "arriveLeaveHomeCompanyEventDao", "Lcom/obric/memorydata/database/dao/ArriveLeaveHomeCompanyEventDao;", "getArriveLeaveHomeCompanyEventDao", "()Lcom/obric/memorydata/database/dao/ArriveLeaveHomeCompanyEventDao;", "rawPhotoHistoryEntityDao", "Lcom/obric/memorydata/database/dao/PhotoHistoryEntityDao;", "getRawPhotoHistoryEntityDao", "()Lcom/obric/memorydata/database/dao/PhotoHistoryEntityDao;", "complexRecommendQueryDao", "Lcom/obric/memorydata/database/legacy/dao/ComplexRecommendQueryDaoOld;", "getComplexRecommendQueryDao$database_obricRelease$annotations", "getComplexRecommendQueryDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/ComplexRecommendQueryDaoOld;", "screenObservationDao", "Lcom/obric/memorydata/database/dao/ScreenObservationDao;", "getScreenObservationDao", "()Lcom/obric/memorydata/database/dao/ScreenObservationDao;", "rawObservationDao", "Lcom/obric/memorydata/database/dao/RawObservationDao;", "getRawObservationDao", "()Lcom/obric/memorydata/database/dao/RawObservationDao;", "glassesSyncStateDao", "Lcom/obric/memorydata/database/dao/GlassesSyncStateDao;", "getGlassesSyncStateDao", "()Lcom/obric/memorydata/database/dao/GlassesSyncStateDao;", "speakerEmbeddingPendingDao", "Lcom/obric/memorydata/database/dao/SpeakerEmbeddingPendingDao;", "getSpeakerEmbeddingPendingDao", "()Lcom/obric/memorydata/database/dao/SpeakerEmbeddingPendingDao;", "auditoryAsrTaskDao", "Lcom/obric/memorydata/database/dao/AuditoryAsrTaskDao;", "getAuditoryAsrTaskDao", "()Lcom/obric/memorydata/database/dao/AuditoryAsrTaskDao;", "auditorySyncStateDao", "Lcom/obric/memorydata/database/dao/AuditorySyncStateDao;", "getAuditorySyncStateDao", "()Lcom/obric/memorydata/database/dao/AuditorySyncStateDao;", "lifelogDao", "Lcom/obric/memorydata/database/legacy/dao/LifelogDaoOld;", "getLifelogDao$database_obricRelease$annotations", "getLifelogDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/LifelogDaoOld;", "userProfileMemoryDao", "Lcom/obric/memorydata/database/legacy/dao/UserProfileMemoryDaoOld;", "getUserProfileMemoryDao$database_obricRelease$annotations", "getUserProfileMemoryDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/UserProfileMemoryDaoOld;", "pendingMemoryCalendarDao", "Lcom/obric/memorydata/database/legacy/dao/PendingMemoryCalendarDaoOld;", "getPendingMemoryCalendarDao$database_obricRelease$annotations", "getPendingMemoryCalendarDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/PendingMemoryCalendarDaoOld;", "memoryEntityToCalendarDao", "Lcom/obric/memorydata/database/legacy/dao/MemoryEntityToCalendarDaoOld;", "getMemoryEntityToCalendarDao$database_obricRelease$annotations", "getMemoryEntityToCalendarDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/MemoryEntityToCalendarDaoOld;", "localMemorySyncToDoubaoPendingDao", "Lcom/obric/memorydata/database/dao/LocalMemorySyncToDoubaoPendingDao;", "getLocalMemorySyncToDoubaoPendingDao", "()Lcom/obric/memorydata/database/dao/LocalMemorySyncToDoubaoPendingDao;", "blockMemoryContentDao", "Lcom/obric/memorydata/database/legacy/dao/BlockMemoryContentDaoOld;", "getBlockMemoryContentDao$database_obricRelease$annotations", "getBlockMemoryContentDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/BlockMemoryContentDaoOld;", "bssidCalcCacheDao", "Lcom/obric/memorydata/database/dao/BssidCalcCacheDao;", "getBssidCalcCacheDao", "()Lcom/obric/memorydata/database/dao/BssidCalcCacheDao;", "userKeywordDao", "Lcom/obric/memorydata/database/legacy/dao/UserKeywordDaoOld;", "getUserKeywordDao$database_obricRelease$annotations", "getUserKeywordDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/UserKeywordDaoOld;", "userProfileRawDbDao", "Lcom/obric/memorydata/database/legacy/dao/UserProfileRawDbDaoOld;", "getUserProfileRawDbDao$database_obricRelease$annotations", "getUserProfileRawDbDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/UserProfileRawDbDaoOld;", "userProfileTextVectorCopilotDao", "Lcom/obric/memorydata/database/legacy/dao/UserProfileTextEntityTextVectorCopilotDaoOld;", "getUserProfileTextVectorCopilotDao$database_obricRelease$annotations", "getUserProfileTextVectorCopilotDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/UserProfileTextEntityTextVectorCopilotDaoOld;", "backUpBlockMemoryContentDao", "Lcom/obric/memorydata/database/legacy/backup/dao/BackUpBlockMemoryContentDaoOld;", "getBackUpBlockMemoryContentDao$database_obricRelease$annotations", "getBackUpBlockMemoryContentDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/backup/dao/BackUpBlockMemoryContentDaoOld;", "backUpEpisodicMemoryDao", "Lcom/obric/memorydata/database/legacy/backup/dao/BackUpEpisodicMemoryDaoOld;", "getBackUpEpisodicMemoryDao$database_obricRelease$annotations", "getBackUpEpisodicMemoryDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/backup/dao/BackUpEpisodicMemoryDaoOld;", "backUpEpisodicTopicMemoryDao", "Lcom/obric/memorydata/database/legacy/backup/dao/BackUpEpisodicTopicMemoryDaoOld;", "getBackUpEpisodicTopicMemoryDao$database_obricRelease$annotations", "getBackUpEpisodicTopicMemoryDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/backup/dao/BackUpEpisodicTopicMemoryDaoOld;", "backUpLifelogDao", "Lcom/obric/memorydata/database/legacy/backup/dao/BackUpLifelogDaoOld;", "getBackUpLifelogDao$database_obricRelease$annotations", "getBackUpLifelogDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/backup/dao/BackUpLifelogDaoOld;", "backUpMemoryEntityCorrelationDao", "Lcom/obric/memorydata/database/legacy/backup/dao/BackUpMemoryEntityCorrelationDaoOld;", "getBackUpMemoryEntityCorrelationDao$database_obricRelease$annotations", "getBackUpMemoryEntityCorrelationDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/backup/dao/BackUpMemoryEntityCorrelationDaoOld;", "backUpMemoryEntityToCalendarDao", "Lcom/obric/memorydata/database/legacy/backup/dao/BackUpMemoryEntityToCalendarDaoOld;", "getBackUpMemoryEntityToCalendarDao$database_obricRelease$annotations", "getBackUpMemoryEntityToCalendarDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/backup/dao/BackUpMemoryEntityToCalendarDaoOld;", "backUpMemoryKeyInfoDao", "Lcom/obric/memorydata/database/legacy/backup/dao/BackUpMemoryKeyInfoDaoOld;", "getBackUpMemoryKeyInfoDao$database_obricRelease$annotations", "getBackUpMemoryKeyInfoDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/backup/dao/BackUpMemoryKeyInfoDaoOld;", "backUpPendingMemoryCalendarDao", "Lcom/obric/memorydata/database/legacy/backup/dao/BackUpPendingMemoryCalendarDaoOld;", "getBackUpPendingMemoryCalendarDao$database_obricRelease$annotations", "getBackUpPendingMemoryCalendarDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/backup/dao/BackUpPendingMemoryCalendarDaoOld;", "backUpRawMemoryDao", "Lcom/obric/memorydata/database/backup/dao/BackUpRawMemoryDao;", "getBackUpRawMemoryDao", "()Lcom/obric/memorydata/database/backup/dao/BackUpRawMemoryDao;", "backUpRawUserProfileDao", "Lcom/obric/memorydata/database/legacy/backup/dao/BackUpRawUserProfileDaoOld;", "getBackUpRawUserProfileDao$database_obricRelease$annotations", "getBackUpRawUserProfileDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/backup/dao/BackUpRawUserProfileDaoOld;", "backUpUnionSemanticMemoryDao", "Lcom/obric/memorydata/database/legacy/backup/dao/BackUpUnionSemanticMemoryDaoOld;", "getBackUpUnionSemanticMemoryDao$database_obricRelease$annotations", "getBackUpUnionSemanticMemoryDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/backup/dao/BackUpUnionSemanticMemoryDaoOld;", "backUpProactiveSemanticRelevantDataDao", "Lcom/obric/memorydata/database/legacy/backup/dao/BackUpProactiveSemanticRelevantDataDaoOld;", "getBackUpProactiveSemanticRelevantDataDao$database_obricRelease$annotations", "getBackUpProactiveSemanticRelevantDataDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/backup/dao/BackUpProactiveSemanticRelevantDataDaoOld;", "backUpProactiveEpisodicRelevantDataDao", "Lcom/obric/memorydata/database/legacy/backup/dao/BackUpProactiveEpisodicRelevantDataDaoOld;", "getBackUpProactiveEpisodicRelevantDataDao$database_obricRelease$annotations", "getBackUpProactiveEpisodicRelevantDataDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/backup/dao/BackUpProactiveEpisodicRelevantDataDaoOld;", "backUpUpdateUnionSemanticMemoryDao", "Lcom/obric/memorydata/database/legacy/backup/dao/BackUpUpdateUnionSemanticMemoryDaoOld;", "getBackUpUpdateUnionSemanticMemoryDao$database_obricRelease$annotations", "getBackUpUpdateUnionSemanticMemoryDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/backup/dao/BackUpUpdateUnionSemanticMemoryDaoOld;", "backUpUpdateProactiveSemanticRelevantDataDao", "Lcom/obric/memorydata/database/legacy/backup/dao/BackUpUpdateProactiveSemanticRelevantDataDaoOld;", "getBackUpUpdateProactiveSemanticRelevantDataDao$database_obricRelease$annotations", "getBackUpUpdateProactiveSemanticRelevantDataDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/backup/dao/BackUpUpdateProactiveSemanticRelevantDataDaoOld;", "backUpAutoMemoryEpisodicRelevantDataDao", "Lcom/obric/memorydata/database/legacy/backup/dao/BackUpAutoMemoryEpisodicRelevantDataDaoOld;", "getBackUpAutoMemoryEpisodicRelevantDataDao$database_obricRelease$annotations", "getBackUpAutoMemoryEpisodicRelevantDataDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/backup/dao/BackUpAutoMemoryEpisodicRelevantDataDaoOld;", "backUpAutoMemorySemanticRelevantDataDao", "Lcom/obric/memorydata/database/legacy/backup/dao/BackUpAutoMemorySemanticRelevantDataDaoOld;", "getBackUpAutoMemorySemanticRelevantDataDao$database_obricRelease$annotations", "getBackUpAutoMemorySemanticRelevantDataDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/backup/dao/BackUpAutoMemorySemanticRelevantDataDaoOld;", "agentWatermarkDao", "Lcom/obric/memorydata/database/legacy/dao/AgentWatermarkDaoOld;", "getAgentWatermarkDao$database_obricRelease$annotations", "getAgentWatermarkDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/AgentWatermarkDaoOld;", "backUpAgentWatermarkDao", "Lcom/obric/memorydata/database/legacy/backup/dao/BackUpAgentWatermarkDaoOld;", "getBackUpAgentWatermarkDao$database_obricRelease$annotations", "getBackUpAgentWatermarkDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/backup/dao/BackUpAgentWatermarkDaoOld;", "episodicMemoryHistoryRawDbDao", "Lcom/obric/memorydata/database/legacy/dao/EpisodicMemoryHistoryRawDbDaoOld;", "getEpisodicMemoryHistoryRawDbDao$database_obricRelease$annotations", "getEpisodicMemoryHistoryRawDbDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/EpisodicMemoryHistoryRawDbDaoOld;", "episodicTopicMemoryHistoryRawDbDao", "Lcom/obric/memorydata/database/legacy/dao/EpisodicTopicMemoryHistoryRawDbDaoOld;", "getEpisodicTopicMemoryHistoryRawDbDao$database_obricRelease$annotations", "getEpisodicTopicMemoryHistoryRawDbDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/EpisodicTopicMemoryHistoryRawDbDaoOld;", "lifelogHistoryRawDbDao", "Lcom/obric/memorydata/database/legacy/dao/LifelogHistoryRawDbDaoOld;", "getLifelogHistoryRawDbDao$database_obricRelease$annotations", "getLifelogHistoryRawDbDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/LifelogHistoryRawDbDaoOld;", "autoMemoryProHistoryRawDbDao", "Lcom/obric/memorydata/database/legacy/dao/AutoMemoryProHistoryRawDbDaoOld;", "getAutoMemoryProHistoryRawDbDao$database_obricRelease$annotations", "getAutoMemoryProHistoryRawDbDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/AutoMemoryProHistoryRawDbDaoOld;", "rawUserProfileHistoryRawDbDao", "Lcom/obric/memorydata/database/legacy/dao/RawUserProfileHistoryRawDbDaoOld;", "getRawUserProfileHistoryRawDbDao$database_obricRelease$annotations", "getRawUserProfileHistoryRawDbDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/RawUserProfileHistoryRawDbDaoOld;", "lifeLogTextVectorCopilotDao", "Lcom/obric/memorydata/database/legacy/dao/LifeLogTextEntityTextVectorCopilotDaoOld;", "getLifeLogTextVectorCopilotDao$database_obricRelease$annotations", "getLifeLogTextVectorCopilotDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/LifeLogTextEntityTextVectorCopilotDaoOld;", "autoMemoryProTextVectorCopilotDao", "Lcom/obric/memorydata/database/legacy/dao/AutoMemoryProTextEntityTextVectorCopilotDaoOld;", "getAutoMemoryProTextVectorCopilotDao$database_obricRelease$annotations", "getAutoMemoryProTextVectorCopilotDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/AutoMemoryProTextEntityTextVectorCopilotDaoOld;", "backupAutoMemoryProDao", "Lcom/obric/memorydata/database/legacy/backup/dao/BackUpAutoMemoryProEntityDaoOld;", "getBackupAutoMemoryProDao$database_obricRelease$annotations", "getBackupAutoMemoryProDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/backup/dao/BackUpAutoMemoryProEntityDaoOld;", "backUpAutoMemoryProSlmPersonalInfoDao", "Lcom/obric/memorydata/database/legacy/backup/dao/BackUpAutoMemoryProSlmPersonalInfoDaoOld;", "getBackUpAutoMemoryProSlmPersonalInfoDao$database_obricRelease$annotations", "getBackUpAutoMemoryProSlmPersonalInfoDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/backup/dao/BackUpAutoMemoryProSlmPersonalInfoDaoOld;", "backUpAutoMemoryProSlmEpisodicMemoryDao", "Lcom/obric/memorydata/database/legacy/backup/dao/BackUpAutoMemoryProSlmEpisodicMemoryDaoOld;", "getBackUpAutoMemoryProSlmEpisodicMemoryDao$database_obricRelease$annotations", "getBackUpAutoMemoryProSlmEpisodicMemoryDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/backup/dao/BackUpAutoMemoryProSlmEpisodicMemoryDaoOld;", "backUpSlmAutoMemoryProTempResultDao", "Lcom/obric/memorydata/database/legacy/backup/dao/BackUpSlmAutoMemoryProTempResultDaoOld;", "getBackUpSlmAutoMemoryProTempResultDao$database_obricRelease$annotations", "getBackUpSlmAutoMemoryProTempResultDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/backup/dao/BackUpSlmAutoMemoryProTempResultDaoOld;", "backUpSlmAgentWatermarkDao", "Lcom/obric/memorydata/database/legacy/backup/dao/BackUpSlmAgentWatermarkDaoOld;", "getBackUpSlmAgentWatermarkDao$database_obricRelease$annotations", "getBackUpSlmAgentWatermarkDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/backup/dao/BackUpSlmAgentWatermarkDaoOld;", "memoryKeyInfoDao", "Lcom/obric/memorydata/database/legacy/dao/MemoryKeyInfoDaoOld;", "getMemoryKeyInfoDao$database_obricRelease$annotations", "getMemoryKeyInfoDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/MemoryKeyInfoDaoOld;", "memoryReviewFeedbackDao", "Lcom/obric/memorydata/database/legacy/dao/MemoryReviewFeedbackDaoOld;", "getMemoryReviewFeedbackDao$database_obricRelease$annotations", "getMemoryReviewFeedbackDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/MemoryReviewFeedbackDaoOld;", "memoryTraceReportDao", "Lcom/obric/memorydata/database/dao/MemoryTraceReportDao;", "getMemoryTraceReportDao", "()Lcom/obric/memorydata/database/dao/MemoryTraceReportDao;", "inAppTraceUploadDao", "Lcom/obric/memorydata/database/dao/InAppTraceUploadDao;", "getInAppTraceUploadDao", "()Lcom/obric/memorydata/database/dao/InAppTraceUploadDao;", "metaFullContentKeywordCopilotDao", "Lcom/obric/memorydata/database/dao/MetaFullContentKeywordCopilotDao;", "getMetaFullContentKeywordCopilotDao", "()Lcom/obric/memorydata/database/dao/MetaFullContentKeywordCopilotDao;", "harStateDao", "Lcom/obric/memorydata/database/dao/HarStateDao;", "getHarStateDao", "()Lcom/obric/memorydata/database/dao/HarStateDao;", "awarenessInfoDao", "Lcom/obric/memorydata/database/dao/AwarenessInfoDao;", "getAwarenessInfoDao", "()Lcom/obric/memorydata/database/dao/AwarenessInfoDao;", "cellInfoDao", "Lcom/obric/memorydata/database/dao/CellInfoDao;", "getCellInfoDao", "()Lcom/obric/memorydata/database/dao/CellInfoDao;", "semanticMemoryDao", "Lcom/obric/memorydata/database/legacy/dao/SemanticMemoryDaoOld;", "getSemanticMemoryDao$database_obricRelease$annotations", "getSemanticMemoryDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/SemanticMemoryDaoOld;", "semanticMemoryHistoryRawDbDao", "Lcom/obric/memorydata/database/legacy/dao/UnionSemanticMemoryHistoryRawDbDaoOld;", "getSemanticMemoryHistoryRawDbDao$database_obricRelease$annotations", "getSemanticMemoryHistoryRawDbDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/UnionSemanticMemoryHistoryRawDbDaoOld;", "semanticTextCopilotDao", "Lcom/obric/memorydata/database/legacy/dao/SemanticTextCopilotDaoOld;", "getSemanticTextCopilotDao$database_obricRelease$annotations", "getSemanticTextCopilotDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/SemanticTextCopilotDaoOld;", "unionSemanticMemoryExtDao", "Lcom/obric/memorydata/database/legacy/dao/UnionSemanticMemoryExtDaoOld;", "getUnionSemanticMemoryExtDao$database_obricRelease$annotations", "getUnionSemanticMemoryExtDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/UnionSemanticMemoryExtDaoOld;", "proactiveSemanticRelevantDataDao", "Lcom/obric/memorydata/database/legacy/dao/ProactiveSemanticRelevantDataDaoOld;", "getProactiveSemanticRelevantDataDao$database_obricRelease$annotations", "getProactiveSemanticRelevantDataDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/ProactiveSemanticRelevantDataDaoOld;", "updateUnionSemanticMemoryDao", "Lcom/obric/memorydata/database/legacy/dao/UpdateUnionSemanticMemoryDaoOld;", "getUpdateUnionSemanticMemoryDao$database_obricRelease$annotations", "getUpdateUnionSemanticMemoryDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/UpdateUnionSemanticMemoryDaoOld;", "updateProactiveSemanticRelevantDataDao", "Lcom/obric/memorydata/database/legacy/dao/UpdateProactiveSemanticRelevantDataDaoOld;", "getUpdateProactiveSemanticRelevantDataDao$database_obricRelease$annotations", "getUpdateProactiveSemanticRelevantDataDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/UpdateProactiveSemanticRelevantDataDaoOld;", "pendingContextDao", "Lcom/obric/memorydata/database/legacy/dao/PendingContextDaoOld;", "getPendingContextDao$database_obricRelease$annotations", "getPendingContextDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/PendingContextDaoOld;", "pendingEpisodicDao", "Lcom/obric/memorydata/database/legacy/dao/PendingEpisodicDaoOld;", "getPendingEpisodicDao$database_obricRelease$annotations", "getPendingEpisodicDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/PendingEpisodicDaoOld;", "pendingSemanticDao", "Lcom/obric/memorydata/database/legacy/dao/PendingSemanticDaoOld;", "getPendingSemanticDao$database_obricRelease$annotations", "getPendingSemanticDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/PendingSemanticDaoOld;", "assistantChatDao", "Lcom/obric/memorydata/database/legacy/dao/AssistantChatDaoOld;", "getAssistantChatDao$database_obricRelease$annotations", "getAssistantChatDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/AssistantChatDaoOld;", "assistantChatMessageDao", "Lcom/obric/memorydata/database/legacy/dao/AssistantChatMessageDaoOld;", "getAssistantChatMessageDao$database_obricRelease$annotations", "getAssistantChatMessageDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/AssistantChatMessageDaoOld;", "proactiveEpisodicRelevantDataDao", "Lcom/obric/memorydata/database/legacy/dao/ProactiveEpisodicRelevantDataDaoOld;", "getProactiveEpisodicRelevantDataDao$database_obricRelease$annotations", "getProactiveEpisodicRelevantDataDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/ProactiveEpisodicRelevantDataDaoOld;", "memoryRuleDao", "Lcom/obric/memorydata/database/legacy/dao/MemoryRuleDaoOld;", "getMemoryRuleDao$database_obricRelease$annotations", "getMemoryRuleDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/MemoryRuleDaoOld;", "memoryBaseSceneDao", "Lcom/obric/memorydata/database/legacy/dao/MemoryBaseSceneDaoOld;", "getMemoryBaseSceneDao$database_obricRelease$annotations", "getMemoryBaseSceneDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/MemoryBaseSceneDaoOld;", "memoryBaseRequirementDao", "Lcom/obric/memorydata/database/legacy/dao/MemoryBaseRequirementDaoOld;", "getMemoryBaseRequirementDao$database_obricRelease$annotations", "getMemoryBaseRequirementDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/MemoryBaseRequirementDaoOld;", "autoMemoryEpisodicRelevantDataDao", "Lcom/obric/memorydata/database/legacy/dao/AutoMemoryEpisodicRelevantDataDaoOld;", "getAutoMemoryEpisodicRelevantDataDao$database_obricRelease$annotations", "getAutoMemoryEpisodicRelevantDataDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/AutoMemoryEpisodicRelevantDataDaoOld;", "autoMemorySemanticRelevantDataDao", "Lcom/obric/memorydata/database/legacy/dao/AutoMemorySemanticRelevantDataDaoOld;", "getAutoMemorySemanticRelevantDataDao$database_obricRelease$annotations", "getAutoMemorySemanticRelevantDataDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/AutoMemorySemanticRelevantDataDaoOld;", "autoMemoryProDao", "Lcom/obric/memorydata/database/legacy/dao/AutoMemoryProDaoOld;", "getAutoMemoryProDao$database_obricRelease$annotations", "getAutoMemoryProDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/AutoMemoryProDaoOld;", "autoMemoryProRawSourceDao", "Lcom/obric/memorydata/database/legacy/dao/AutoMemoryProRawSourceDaoOld;", "getAutoMemoryProRawSourceDao$database_obricRelease$annotations", "getAutoMemoryProRawSourceDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/AutoMemoryProRawSourceDaoOld;", "autoMemoryProSnapShotDao", "Lcom/obric/memorydata/database/legacy/dao/AutoMemoryProSnapShotDaoOld;", "getAutoMemoryProSnapShotDao$database_obricRelease$annotations", "getAutoMemoryProSnapShotDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/AutoMemoryProSnapShotDaoOld;", "unionSemanticMemorySnapShotDao", "Lcom/obric/memorydata/database/legacy/dao/UnionSemanticMemorySnapShotDaoOld;", "getUnionSemanticMemorySnapShotDao$database_obricRelease$annotations", "getUnionSemanticMemorySnapShotDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/UnionSemanticMemorySnapShotDaoOld;", "autoMemoryProSlmPersonalInfoDao", "Lcom/obric/memorydata/database/legacy/dao/AutoMemoryProSlmPersonalInfoDaoOld;", "getAutoMemoryProSlmPersonalInfoDao$database_obricRelease$annotations", "getAutoMemoryProSlmPersonalInfoDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/AutoMemoryProSlmPersonalInfoDaoOld;", "autoMemoryProSlmEpisodicMemoryDao", "Lcom/obric/memorydata/database/legacy/dao/AutoMemoryProSlmEpisodicMemoryDaoOld;", "getAutoMemoryProSlmEpisodicMemoryDao$database_obricRelease$annotations", "getAutoMemoryProSlmEpisodicMemoryDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/AutoMemoryProSlmEpisodicMemoryDaoOld;", "slmAutoMemoryProTempResultDao", "Lcom/obric/memorydata/database/legacy/dao/SlmAutoMemoryProTempResultDaoOld;", "getSlmAutoMemoryProTempResultDao$database_obricRelease$annotations", "getSlmAutoMemoryProTempResultDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/SlmAutoMemoryProTempResultDaoOld;", "slmAgentWatermarkDao", "Lcom/obric/memorydata/database/legacy/dao/SlmAgentWatermarkDaoOld;", "getSlmAgentWatermarkDao$database_obricRelease$annotations", "getSlmAgentWatermarkDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/SlmAgentWatermarkDaoOld;", "autoMemoryProEvaluationStatsDao", "Lcom/obric/memorydata/database/legacy/dao/AutoMemoryProEvaluationStatsDaoOld;", "getAutoMemoryProEvaluationStatsDao$database_obricRelease$annotations", "getAutoMemoryProEvaluationStatsDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/AutoMemoryProEvaluationStatsDaoOld;", "autoMemoryTraceDao", "Lcom/obric/memorydata/database/dao/AutoMemoryProTraceDao;", "getAutoMemoryTraceDao", "()Lcom/obric/memorydata/database/dao/AutoMemoryProTraceDao;", "unionSemanticTypeSummaryDao", "Lcom/obric/memorydata/database/legacy/dao/UnionSemanticTypeSummaryDaoOld;", "getUnionSemanticTypeSummaryDao$database_obricRelease$annotations", "getUnionSemanticTypeSummaryDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/UnionSemanticTypeSummaryDaoOld;", "unionUserInsightDao", "Lcom/obric/memorydata/database/legacy/dao/UnionUserInsightDaoOld;", "getUnionUserInsightDao$database_obricRelease$annotations", "getUnionUserInsightDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/UnionUserInsightDaoOld;", "unionUserPersonaDao", "Lcom/obric/memorydata/database/legacy/dao/UnionUserPersonaDaoOld;", "getUnionUserPersonaDao$database_obricRelease$annotations", "getUnionUserPersonaDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/UnionUserPersonaDaoOld;", "memoryProcessConsumerSubscriptionDao", "Lcom/obric/memorydata/database/dao/MemoryProcessConsumerSubscriptionDao;", "getMemoryProcessConsumerSubscriptionDao", "()Lcom/obric/memorydata/database/dao/MemoryProcessConsumerSubscriptionDao;", "memoryProcessSourceEventDao", "Lcom/obric/memorydata/database/dao/MemoryProcessSourceEventDao;", "getMemoryProcessSourceEventDao", "()Lcom/obric/memorydata/database/dao/MemoryProcessSourceEventDao;", "memoryProcessTriggerStateDao", "Lcom/obric/memorydata/database/dao/MemoryProcessTriggerStateDao;", "getMemoryProcessTriggerStateDao", "()Lcom/obric/memorydata/database/dao/MemoryProcessTriggerStateDao;", "memoryProcessOperationRecordDao", "Lcom/obric/memorydata/database/dao/MemoryProcessOperationRecordDao;", "getMemoryProcessOperationRecordDao", "()Lcom/obric/memorydata/database/dao/MemoryProcessOperationRecordDao;", "memoryProcessOutputEventDao", "Lcom/obric/memorydata/database/dao/MemoryProcessOutputEventDao;", "getMemoryProcessOutputEventDao", "()Lcom/obric/memorydata/database/dao/MemoryProcessOutputEventDao;", "memoryProcessUserInsightDao", "Lcom/obric/memorydata/database/legacy/dao/MemoryProcessUserInsightDaoOld;", "getMemoryProcessUserInsightDao$database_obricRelease$annotations", "getMemoryProcessUserInsightDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/dao/MemoryProcessUserInsightDaoOld;", "backUpMemoryRuleDao", "Lcom/obric/memorydata/database/legacy/backup/dao/BackUpMemoryRuleDaoOld;", "getBackUpMemoryRuleDao$database_obricRelease$annotations", "getBackUpMemoryRuleDao$database_obricRelease", "()Lcom/obric/memorydata/database/legacy/backup/dao/BackUpMemoryRuleDaoOld;", "backUpAutoMemoryProSnapShotDao", "Lcom/obric/memorydata/database/backup/dao/BackUpAutoMemoryProSnapShotDao;", "getBackUpAutoMemoryProSnapShotDao$database_obricRelease$annotations", "getBackUpAutoMemoryProSnapShotDao$database_obricRelease", "()Lcom/obric/memorydata/database/backup/dao/BackUpAutoMemoryProSnapShotDao;", "backUpUnionSemanticMemorySnapShotDao", "Lcom/obric/memorydata/database/backup/dao/BackUpUnionSemanticMemorySnapShotDao;", "getBackUpUnionSemanticMemorySnapShotDao$database_obricRelease$annotations", "getBackUpUnionSemanticMemorySnapShotDao$database_obricRelease", "()Lcom/obric/memorydata/database/backup/dao/BackUpUnionSemanticMemorySnapShotDao;", "backUpMemoryReviewFeedbackDao", "Lcom/obric/memorydata/database/backup/dao/BackUpMemoryReviewFeedbackDao;", "getBackUpMemoryReviewFeedbackDao$database_obricRelease$annotations", "getBackUpMemoryReviewFeedbackDao$database_obricRelease", "()Lcom/obric/memorydata/database/backup/dao/BackUpMemoryReviewFeedbackDao;", "proactiveOsNotificationDao", "Lcom/obric/memorydata/database/dao/ProactiveOsNotificationDao;", "getProactiveOsNotificationDao", "()Lcom/obric/memorydata/database/dao/ProactiveOsNotificationDao;", "inAppL1RuleDao", "Lcom/obric/memorydata/database/dao/InAppL1RuleDao;", "getInAppL1RuleDao", "()Lcom/obric/memorydata/database/dao/InAppL1RuleDao;", "AutoMigration37", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class MemoryFrameDb extends RoomDatabase {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/memorydata/database/manager/MemoryFrameDb$AutoMigration37;", "Landroidx/room/migration/AutoMigrationSpec;", "<init>", "()V", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AutoMigration37 implements AutoMigrationSpec {
        public AutoMigration37() {
        }
    }

    public MemoryFrameDb() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getAgentWatermarkDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getAssistantChatDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getAssistantChatMessageDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getAutoMemoryEpisodicRelevantDataDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getAutoMemoryProDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getAutoMemoryProEvaluationStatsDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getAutoMemoryProHistoryRawDbDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getAutoMemoryProRawSourceDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getAutoMemoryProSlmEpisodicMemoryDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getAutoMemoryProSlmPersonalInfoDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getAutoMemoryProSnapShotDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getAutoMemoryProTextVectorCopilotDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getAutoMemorySemanticRelevantDataDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getBackUpAgentWatermarkDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getBackUpAutoMemoryEpisodicRelevantDataDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getBackUpAutoMemoryProSlmEpisodicMemoryDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getBackUpAutoMemoryProSlmPersonalInfoDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getBackUpAutoMemoryProSnapShotDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getBackUpAutoMemorySemanticRelevantDataDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getBackUpBlockMemoryContentDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getBackUpEpisodicMemoryDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getBackUpEpisodicTopicMemoryDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getBackUpLifelogDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getBackUpMemoryEntityCorrelationDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getBackUpMemoryEntityToCalendarDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getBackUpMemoryKeyInfoDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getBackUpMemoryReviewFeedbackDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getBackUpMemoryRuleDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getBackUpPendingMemoryCalendarDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getBackUpProactiveEpisodicRelevantDataDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getBackUpProactiveSemanticRelevantDataDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getBackUpRawUserProfileDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getBackUpSlmAgentWatermarkDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getBackUpSlmAutoMemoryProTempResultDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getBackUpUnionSemanticMemoryDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getBackUpUnionSemanticMemorySnapShotDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getBackUpUpdateProactiveSemanticRelevantDataDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getBackUpUpdateUnionSemanticMemoryDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getBackupAutoMemoryProDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getBlockMemoryContentDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getComplexRecommendQueryDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getEpisodicMemoryContentTimeDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getEpisodicMemoryDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getEpisodicMemoryHistoryRawDbDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getEpisodicMemoryTextVectorCopilotDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getEpisodicTopicMemoryDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getEpisodicTopicMemoryHistoryRawDbDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getEpisodicTopicMemoryTextVectorCopilotDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getLifeLogTextVectorCopilotDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getLifelogDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getLifelogHistoryRawDbDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getMemoryBaseRequirementDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getMemoryBaseSceneDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getMemoryEntityCorrelationDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getMemoryEntityToCalendarDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getMemoryKeyInfoDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getMemoryProcessUserInsightDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getMemoryReviewFeedbackDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getMemoryRuleDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getMiddleUserProfileDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getPendingContextDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getPendingEpisodicDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getPendingMemoryCalendarDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getPendingSemanticDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getProactiveEpisodicRelevantDataDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getProactiveSemanticRelevantDataDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getRawUserProfileHistoryRawDbDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getSemanticMemoryDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getSemanticMemoryHistoryRawDbDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getSemanticTextCopilotDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getSlmAgentWatermarkDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getSlmAutoMemoryProTempResultDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getUnionSemanticMemoryExtDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getUnionSemanticMemorySnapShotDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getUnionSemanticTypeSummaryDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getUnionUserInsightDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getUnionUserPersonaDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getUpdateProactiveSemanticRelevantDataDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getUpdateUnionSemanticMemoryDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getUserKeywordDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getUserProfileDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getUserProfileMemoryDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getUserProfileRawDbDao$database_obricRelease$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
    public static /* synthetic */ void getUserProfileTextVectorCopilotDao$database_obricRelease$annotations() {
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public abstract com.obric.memorydata.database.legacy.dao.a getAgentWatermarkDao$database_obricRelease();

    public abstract AlarmDao getAlarmDao();

    public abstract AlarmRawDbDao getAlarmRawDbDao();

    public abstract AlarmEntityTextVectorCopilotDao getAlarmTextVectorCopilotDao();

    public abstract AlbumHistoryEntityDao getAlbumHistoryEntityDao();

    public abstract AlbumRawDbDao getAlbumRawDbDao();

    public abstract AppActivityDao getAppActivityDao();

    public abstract AppUsageDao getAppUsageDao();

    public abstract ArriveLeaveHomeCompanyEventDao getArriveLeaveHomeCompanyEventDao();

    public abstract com.obric.memorydata.database.legacy.dao.b getAssistantChatDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.dao.c getAssistantChatMessageDao$database_obricRelease();

    public abstract AuditoryAsrTaskDao getAuditoryAsrTaskDao();

    public abstract com.obric.memorydata.database.entity.r getAuditoryRecordingHistoryEntityDao();

    public abstract AuditoryRecordingRawDbDao getAuditoryRecordingRawDbDao();

    public abstract AuditoryRecordingTextRawDbDao getAuditoryRecordingTextRawDbDao();

    public abstract AuditoryRecordingTextEntityTextVectorCopilotDao getAuditoryRecordingTextTextVectorCopilotDao();

    public abstract AuditoryRecordingEntityTextVectorCopilotDao getAuditoryRecordingTextVectorCopilotDao();

    public abstract AuditorySyncStateDao getAuditorySyncStateDao();

    public abstract com.obric.memorydata.database.legacy.dao.d getAutoMemoryEpisodicRelevantDataDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.dao.e getAutoMemoryProDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.dao.f getAutoMemoryProEvaluationStatsDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.dao.g getAutoMemoryProHistoryRawDbDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.dao.h getAutoMemoryProRawSourceDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.dao.i getAutoMemoryProSlmEpisodicMemoryDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.dao.j getAutoMemoryProSlmPersonalInfoDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.dao.k getAutoMemoryProSnapShotDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.dao.l getAutoMemoryProTextVectorCopilotDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.dao.m getAutoMemorySemanticRelevantDataDao$database_obricRelease();

    public abstract AutoMemoryProTraceDao getAutoMemoryTraceDao();

    public abstract AwarenessInfoDao getAwarenessInfoDao();

    public abstract com.obric.memorydata.database.legacy.backup.dao.a getBackUpAgentWatermarkDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.backup.dao.b getBackUpAutoMemoryEpisodicRelevantDataDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.backup.dao.d getBackUpAutoMemoryProSlmEpisodicMemoryDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.backup.dao.e getBackUpAutoMemoryProSlmPersonalInfoDao$database_obricRelease();

    public abstract com.obric.memorydata.database.backup.dao.a getBackUpAutoMemoryProSnapShotDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.backup.dao.f getBackUpAutoMemorySemanticRelevantDataDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.backup.dao.g getBackUpBlockMemoryContentDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.backup.dao.h getBackUpEpisodicMemoryDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.backup.dao.i getBackUpEpisodicTopicMemoryDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.backup.dao.j getBackUpLifelogDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.backup.dao.k getBackUpMemoryEntityCorrelationDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.backup.dao.l getBackUpMemoryEntityToCalendarDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.backup.dao.m getBackUpMemoryKeyInfoDao$database_obricRelease();

    public abstract com.obric.memorydata.database.backup.dao.b getBackUpMemoryReviewFeedbackDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.backup.dao.n getBackUpMemoryRuleDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.backup.dao.o getBackUpPendingMemoryCalendarDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.backup.dao.p getBackUpProactiveEpisodicRelevantDataDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.backup.dao.q getBackUpProactiveSemanticRelevantDataDao$database_obricRelease();

    public abstract com.obric.memorydata.database.backup.dao.c getBackUpRawMemoryDao();

    public abstract com.obric.memorydata.database.legacy.backup.dao.r getBackUpRawUserProfileDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.backup.dao.s getBackUpSlmAgentWatermarkDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.backup.dao.t getBackUpSlmAutoMemoryProTempResultDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.backup.dao.u getBackUpUnionSemanticMemoryDao$database_obricRelease();

    public abstract com.obric.memorydata.database.backup.dao.d getBackUpUnionSemanticMemorySnapShotDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.backup.dao.v getBackUpUpdateProactiveSemanticRelevantDataDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.backup.dao.w getBackUpUpdateUnionSemanticMemoryDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.backup.dao.c getBackupAutoMemoryProDao$database_obricRelease();

    public abstract BatchChatDao getBatchChatDao();

    public abstract BatteryStateDao getBatteryStateDao();

    public abstract com.obric.memorydata.database.legacy.dao.n getBlockMemoryContentDao$database_obricRelease();

    public abstract BluetoothDeviceDao getBluetoothDeviceDao();

    public abstract BrowserBookmarkHistoryEntityDao getBrowserBookmarkHistoryEntityDao();

    public abstract BrowserBookmarkRawDbDao getBrowserBookmarkRawDbDao();

    public abstract BssidCalcCacheDao getBssidCalcCacheDao();

    public abstract CallHistoryEntityContentTimeDao getCallHistoryEntityContentTimeDao();

    public abstract CallHistoryHistoryEntityDao getCallHistoryHistoryEntityDao();

    public abstract CallHistoryRawDbDao getCallHistoryRawDbDao();

    public abstract CallHistoryEntityTextVectorCopilotDao getCallHistoryTextVectorCopilotDao();

    public abstract CellInfoDao getCellInfoDao();

    public abstract CommonPhotoEntityImageVectorCopilotDao getCommonPhotoImageVectorCopilotDao();

    public abstract CommonPhotoRawDbDao getCommonPhotoRawDbDao();

    public abstract CommonPhotoEntityTextVectorCopilotDao getCommonPhotoTextVectorCopilotDao();

    public abstract CommonVideoFrameEntityImageVectorCopilotDao getCommonVideoFrameImageVectorCopilotDao();

    public abstract CommonVideoFrameRawDbDao getCommonVideoFrameRawDbDao();

    public abstract CommonVideoFrameEntityTextVectorCopilotDao getCommonVideoFrameTextVectorCopilotDao();

    public abstract com.obric.memorydata.database.legacy.dao.o getComplexRecommendQueryDao$database_obricRelease();

    public abstract ContactEntityImageVectorCopilotDao getContactImageVectorCopilotDao();

    public abstract ContactRawDbDao getContactRawDbDao();

    public abstract ContactHistoryEntityDao getContactRawHistoryDbDao();

    public abstract ContactEntityTextVectorCopilotDao getContactTextVectorCopilotDao();

    public abstract CountdownRawDbDao getCountdownRawDbDao();

    public abstract CountdownEntityTextVectorCopilotDao getCountdownTextVectorCopilotDao();

    public abstract DataBuildMemoryStatusDao getDataBuildMemoryStatusDao();

    public abstract DeviceBootDao getDeviceBootDao();

    public abstract DeviceShutdownDao getDeviceShutdownDao();

    public abstract DoubaoAccountEntityRawDbDao getDoubaoAccountEntityRawDbDao();

    public abstract ElementKGIndexPendingDao getElementKGIndexPendingDao();

    public abstract EmbeddingVectorCacheDao getEmbeddingVectorCacheDao();

    public abstract EntityIndexLifecycleDao getEntityIndexLifecycleDao();

    public abstract com.obric.memorydata.database.legacy.dao.p getEpisodicMemoryContentTimeDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.dao.q getEpisodicMemoryDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.dao.r getEpisodicMemoryHistoryRawDbDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.dao.s getEpisodicMemoryTextVectorCopilotDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.dao.t getEpisodicTopicMemoryDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.dao.u getEpisodicTopicMemoryHistoryRawDbDao$database_obricRelease();

    public abstract com.obric.memorydata.database.legacy.dao.v getEpisodicTopicMemoryTextVectorCopilotDao$database_obricRelease();

    public abstract EvaluationSourceDataDao getEvaluationSourceDataDao();

    public abstract FileRawDbDao getFileRawDbDao();

    public abstract FileHistoryEntityDao getFileRawHistoryDbDao();

    public abstract FileTextRawDbDao getFileTextRawDbDao();

    public abstract FileTextEntityTextVectorCopilotDao getFileTextTextVectorCopilotDao();

    public abstract FileEntityTextVectorCopilotDao getFileTextVectorCopilotDao();

    public abstract GeographyDao getGeographyDao();

    public abstract GlassesSyncStateDao getGlassesSyncStateDao();

    public abstract HarStateDao getHarStateDao();

    public abstract ICSProtocolHistoryEntityDao getIcsProtocolHistoryRawDbDao();

    public abstract ICSProtocolEntityRawDbDao getIcsProtocolRawDbDao();

    public abstract InAppL1RuleDao getInAppL1RuleDao();

    public abstract InAppTraceUploadDao getInAppTraceUploadDao();

    public abstract IndexPendingDao getIndexPendingDao();

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker getInvalidationTracker() {
        return super.getInvalidationTracker();
    }

    public abstract LanguageChangeEventDao getLanguageChangeEventDao();

    public abstract com.obric.memorydata.database.legacy.dao.w getLifeLogTextVectorCopilotDao$database_obricRelease();

    public abstract x getLifelogDao$database_obricRelease();

    public abstract y getLifelogHistoryRawDbDao$database_obricRelease();

    public abstract LightSensorDao getLightSensorDao();

    public abstract LocalMemorySyncToDoubaoPendingDao getLocalMemorySyncToDoubaoPendingDao();

    public abstract LocationAddressCacheDao getLocationAddressCacheDao();

    public abstract LocationDao getLocationDao();

    public abstract z getMemoryBaseRequirementDao$database_obricRelease();

    public abstract aa getMemoryBaseSceneDao$database_obricRelease();

    public abstract MemoryEntityContentTimeDao getMemoryEntityContentTimeDao();

    public abstract ab getMemoryEntityCorrelationDao$database_obricRelease();

    public abstract MemoryEntityTextVectorCopilotDao getMemoryEntityTextVectorCopilotDao();

    public abstract ac getMemoryEntityToCalendarDao$database_obricRelease();

    public abstract ad getMemoryKeyInfoDao$database_obricRelease();

    public abstract MemoryLocationRawDbDao getMemoryLocationRawDbDao();

    public abstract MemoryLocationEntityTextVectorCopilotDao getMemoryLocationTextVectorCopilotDao();

    public abstract MemoryMapTableDao getMemoryMapTableDao();

    public abstract MemoryProcessConsumerSubscriptionDao getMemoryProcessConsumerSubscriptionDao();

    public abstract MemoryProcessOperationRecordDao getMemoryProcessOperationRecordDao();

    public abstract MemoryProcessOutputEventDao getMemoryProcessOutputEventDao();

    public abstract MemoryProcessSourceEventDao getMemoryProcessSourceEventDao();

    public abstract MemoryProcessTriggerStateDao getMemoryProcessTriggerStateDao();

    public abstract ae getMemoryProcessUserInsightDao$database_obricRelease();

    public abstract af getMemoryReviewFeedbackDao$database_obricRelease();

    public abstract ag getMemoryRuleDao$database_obricRelease();

    public abstract MemoryTraceReportDao getMemoryTraceReportDao();

    public abstract MessageEntityContentTimeDao getMessageEntityContentTimeDao();

    public abstract MessageHistoryRawDbDao getMessageHistoryRawDbDao();

    public abstract MessageEntityImageVectorCopilotDao getMessageImageVectorCopilotDao();

    public abstract MessageRawDbDao getMessageRawDbDao();

    public abstract MessageEntityTextVectorCopilotDao getMessageTextVectorCopilotDao();

    public abstract MetaFullContentKeywordCopilotDao getMetaFullContentKeywordCopilotDao();

    public abstract MetaLocationRawDbDao getMetaLocationRawDbDao();

    public abstract MetaLocationEntityTextVectorCopilotDao getMetaLocationTextVectorCopilotDao();

    public abstract MetaTagRawDbDao getMetaTagRawDbDao();

    public abstract ah getMiddleUserProfileDao$database_obricRelease();

    public abstract MobileCellularDao getMobileCellularDao();

    public abstract MovementStateDao getMovementStateDao();

    public abstract NetworkStatusDao getNetworkStatusDao();

    public abstract NetworkTypeDao getNetworkTypeDao();

    public abstract NoteEntityContentTimeDao getNoteEntityContentTimeDao();

    public abstract dx getNoteHistoryRawDbDao();

    public abstract NoteEntityImageVectorCopilotDao getNoteImageVectorCopilotDao();

    public abstract NoteRawDbDao getNoteRawDbDao();

    public abstract NoteRecordingRawDbDao getNoteRecordingRawDbDao();

    public abstract NoteRecordingTextRawDbDao getNoteRecordingTextRawDbDao();

    public abstract NoteRecordingTextEntityTextVectorCopilotDao getNoteRecordingTextTextVectorCopilotDao();

    public abstract NoteRecordingEntityTextVectorCopilotDao getNoteRecordingTextVectorCopilotDao();

    public abstract NoteEntityTextVectorCopilotDao getNoteTextVectorCopilotDao();

    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper getOpenHelper() {
        return super.getOpenHelper();
    }

    public abstract OrderHitDao getOrderHitDao();

    public abstract OsAudioPlayDao getOsAudioPlayDao();

    public abstract OsNotificationDao getOsNotificationDao();

    public abstract PackageEventDao getPackageEventDao();

    public abstract ai getPendingContextDao$database_obricRelease();

    public abstract aj getPendingEpisodicDao$database_obricRelease();

    public abstract ak getPendingMemoryCalendarDao$database_obricRelease();

    public abstract al getPendingSemanticDao$database_obricRelease();

    public abstract el getPhotoFaceHistoryRawDbDao();

    public abstract PhotoFaceRawDbDao getPhotoFaceRawDbDao();

    public abstract PhotoEntityImageVectorCopilotDao getPhotoImageVectorCopilotDao();

    public abstract PhotoRawDbDao getPhotoRawDbDao();

    public abstract PhotoEntityTextVectorCopilotDao getPhotoTextVectorCopilotDao();

    public abstract PoiInfoGroupDao getPoiInfoGroupDao();

    public abstract PoiReqRecorderDao getPoiReqRecorderDao();

    public abstract PredictAppDao getPredictAppResultDao();

    public abstract PredictSleepWakeupDao getPredictSleepWakeupDao();

    public abstract am getProactiveEpisodicRelevantDataDao$database_obricRelease();

    public abstract ProactiveMemoryProcessInfoDao getProactiveMemoryProcessInfoDao();

    public abstract ProactiveMemorySyncPendingDao getProactiveMemorySyncPendingDao();

    public abstract ProactiveOsNotificationDao getProactiveOsNotificationDao();

    public abstract an getProactiveSemanticRelevantDataDao$database_obricRelease();

    @Override // androidx.room.RoomDatabase
    public Executor getQueryExecutor() {
        return super.getQueryExecutor();
    }

    public abstract RawChatAppChatDao getRawAppChatDao();

    public abstract MemoryEntityRawDbDao getRawMemoryEntityDao();

    public abstract RawMemoryHistoryRawDbDao getRawMemoryHistoryRawDbDao();

    public abstract RawObservationDao getRawObservationDao();

    public abstract RawPhotoContentTimeDao getRawPhotoContentTimeDao();

    public abstract PhotoHistoryEntityDao getRawPhotoHistoryEntityDao();

    public abstract ao getRawUserProfileHistoryRawDbDao$database_obricRelease();

    public abstract RecordingEntityContentTimeDao getRecordingEntityContentTimeDao();

    public abstract hx getRecordingHistoryRawDbDao();

    public abstract RecordingRawDbDao getRecordingRawDbDao();

    public abstract RecordingTextRawDbDao getRecordingTextRawDbDao();

    public abstract RecordingTextEntityTextVectorCopilotDao getRecordingTextTextVectorCopilotDao();

    public abstract RecordingEntityTextVectorCopilotDao getRecordingTextVectorCopilotDao();

    public abstract ScheduleRawDbDao getScheduleRawDbDao();

    public abstract ScheduleEntityTextVectorCopilotDao getScheduleTextVectorCopilotDao();

    public abstract ScreenBrightnessDao getScreenBrightnessDao();

    public abstract ScreenObservationDao getScreenObservationDao();

    public abstract ScreenStateDao getScreenStateDao();

    public abstract ap getSemanticMemoryDao$database_obricRelease();

    public abstract au getSemanticMemoryHistoryRawDbDao$database_obricRelease();

    public abstract aq getSemanticTextCopilotDao$database_obricRelease();

    public abstract SettingsChangedDao getSettingsChangedDao();

    public abstract ar getSlmAgentWatermarkDao$database_obricRelease();

    public abstract as getSlmAutoMemoryProTempResultDao$database_obricRelease();

    public abstract SpeakerEmbeddingPendingDao getSpeakerEmbeddingPendingDao();

    public abstract StreamVolumeDao getStreamVolumeDao();

    public abstract at getUnionSemanticMemoryExtDao$database_obricRelease();

    public abstract av getUnionSemanticMemorySnapShotDao$database_obricRelease();

    public abstract aw getUnionSemanticTypeSummaryDao$database_obricRelease();

    public abstract ax getUnionUserInsightDao$database_obricRelease();

    public abstract ay getUnionUserPersonaDao$database_obricRelease();

    public abstract az getUpdateProactiveSemanticRelevantDataDao$database_obricRelease();

    public abstract ba getUpdateUnionSemanticMemoryDao$database_obricRelease();

    public abstract UploadDataDao getUploadDataDao();

    public abstract UserActionRecorderDao getUserActionRecorderDao();

    public abstract bb getUserKeywordDao$database_obricRelease();

    public abstract bc getUserProfileDao$database_obricRelease();

    public abstract bd getUserProfileMemoryDao$database_obricRelease();

    public abstract be getUserProfileRawDbDao$database_obricRelease();

    public abstract bf getUserProfileTextVectorCopilotDao$database_obricRelease();

    public abstract VideoFrameEntityImageVectorCopilotDao getVideoFrameImageVectorCopilotDao();

    public abstract VideoFrameRawDbDao getVideoFrameRawDbDao();

    public abstract VideoFrameEntityTextVectorCopilotDao getVideoFrameTextVectorCopilotDao();

    public abstract WifiDao getWifiDao();

    public abstract WifiListDao getWifiListDao();

    @Override // androidx.room.RoomDatabase
    public boolean isOpen() {
        return super.isOpen();
    }

    @Override // androidx.room.RoomDatabase
    public Cursor query(SupportSQLiteQuery r3, CancellationSignal r4) {
        SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, ChatMessage.TYPE_QUERY);
        return super.query(r5, r4);
    }

    @Override // androidx.room.RoomDatabase
    public Cursor query(String r2, Object[] r3) {
        Intrinsics.checkNotNullParameter(r2, ChatMessage.TYPE_QUERY);
        return super.query(r2, r3);
    }
}
