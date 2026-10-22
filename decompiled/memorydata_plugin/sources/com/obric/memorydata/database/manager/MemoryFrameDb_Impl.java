package com.obric.memorydata.database.manager;

import android.os.Build;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.obric.memorydata.database.backup.dao.BackUpAutoMemoryProSnapShotDao_Impl;
import com.obric.memorydata.database.backup.dao.BackUpMemoryReviewFeedbackDao_Impl;
import com.obric.memorydata.database.backup.dao.BackUpRawMemoryDao_Impl;
import com.obric.memorydata.database.backup.dao.BackUpUnionSemanticMemorySnapShotDao_Impl;
import com.obric.memorydata.database.dao.AlarmDao;
import com.obric.memorydata.database.dao.AlarmDao_Impl;
import com.obric.memorydata.database.dao.AlarmEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.AlarmEntityTextVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.AlarmRawDbDao;
import com.obric.memorydata.database.dao.AlarmRawDbDao_Impl;
import com.obric.memorydata.database.dao.AlbumHistoryEntityDao;
import com.obric.memorydata.database.dao.AlbumHistoryEntityDao_Impl;
import com.obric.memorydata.database.dao.AlbumRawDbDao;
import com.obric.memorydata.database.dao.AlbumRawDbDao_Impl;
import com.obric.memorydata.database.dao.AppActivityDao;
import com.obric.memorydata.database.dao.AppActivityDao_Impl;
import com.obric.memorydata.database.dao.AppUsageDao;
import com.obric.memorydata.database.dao.AppUsageDao_Impl;
import com.obric.memorydata.database.dao.ArriveLeaveHomeCompanyEventDao;
import com.obric.memorydata.database.dao.ArriveLeaveHomeCompanyEventDao_Impl;
import com.obric.memorydata.database.dao.AuditoryAsrTaskDao;
import com.obric.memorydata.database.dao.AuditoryAsrTaskDao_Impl;
import com.obric.memorydata.database.dao.AuditoryRecordingEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.AuditoryRecordingEntityTextVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.AuditoryRecordingRawDbDao;
import com.obric.memorydata.database.dao.AuditoryRecordingRawDbDao_Impl;
import com.obric.memorydata.database.dao.AuditoryRecordingTextEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.AuditoryRecordingTextEntityTextVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.AuditoryRecordingTextRawDbDao;
import com.obric.memorydata.database.dao.AuditoryRecordingTextRawDbDao_Impl;
import com.obric.memorydata.database.dao.AuditorySyncStateDao;
import com.obric.memorydata.database.dao.AuditorySyncStateDao_Impl;
import com.obric.memorydata.database.dao.AutoMemoryProTraceDao;
import com.obric.memorydata.database.dao.AutoMemoryProTraceDao_Impl;
import com.obric.memorydata.database.dao.AwarenessInfoDao;
import com.obric.memorydata.database.dao.AwarenessInfoDao_Impl;
import com.obric.memorydata.database.dao.BatchChatDao;
import com.obric.memorydata.database.dao.BatchChatDao_Impl;
import com.obric.memorydata.database.dao.BatteryStateDao;
import com.obric.memorydata.database.dao.BatteryStateDao_Impl;
import com.obric.memorydata.database.dao.BluetoothDeviceDao;
import com.obric.memorydata.database.dao.BluetoothDeviceDao_Impl;
import com.obric.memorydata.database.dao.BrowserBookmarkHistoryEntityDao;
import com.obric.memorydata.database.dao.BrowserBookmarkHistoryEntityDao_Impl;
import com.obric.memorydata.database.dao.BrowserBookmarkRawDbDao;
import com.obric.memorydata.database.dao.BrowserBookmarkRawDbDao_Impl;
import com.obric.memorydata.database.dao.BssidCalcCacheDao;
import com.obric.memorydata.database.dao.BssidCalcCacheDao_Impl;
import com.obric.memorydata.database.dao.CallHistoryEntityContentTimeDao;
import com.obric.memorydata.database.dao.CallHistoryEntityContentTimeDao_Impl;
import com.obric.memorydata.database.dao.CallHistoryEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.CallHistoryEntityTextVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.CallHistoryHistoryEntityDao;
import com.obric.memorydata.database.dao.CallHistoryHistoryEntityDao_Impl;
import com.obric.memorydata.database.dao.CallHistoryRawDbDao;
import com.obric.memorydata.database.dao.CallHistoryRawDbDao_Impl;
import com.obric.memorydata.database.dao.CellInfoDao;
import com.obric.memorydata.database.dao.CellInfoDao_Impl;
import com.obric.memorydata.database.dao.CommonPhotoEntityImageVectorCopilotDao;
import com.obric.memorydata.database.dao.CommonPhotoEntityImageVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.CommonPhotoEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.CommonPhotoEntityTextVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.CommonPhotoRawDbDao;
import com.obric.memorydata.database.dao.CommonPhotoRawDbDao_Impl;
import com.obric.memorydata.database.dao.CommonVideoFrameEntityImageVectorCopilotDao;
import com.obric.memorydata.database.dao.CommonVideoFrameEntityImageVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.CommonVideoFrameEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.CommonVideoFrameEntityTextVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.CommonVideoFrameRawDbDao;
import com.obric.memorydata.database.dao.CommonVideoFrameRawDbDao_Impl;
import com.obric.memorydata.database.dao.ContactEntityImageVectorCopilotDao;
import com.obric.memorydata.database.dao.ContactEntityImageVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.ContactEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.ContactEntityTextVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.ContactHistoryEntityDao;
import com.obric.memorydata.database.dao.ContactHistoryEntityDao_Impl;
import com.obric.memorydata.database.dao.ContactRawDbDao;
import com.obric.memorydata.database.dao.ContactRawDbDao_Impl;
import com.obric.memorydata.database.dao.CountdownEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.CountdownEntityTextVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.CountdownRawDbDao;
import com.obric.memorydata.database.dao.CountdownRawDbDao_Impl;
import com.obric.memorydata.database.dao.DataBuildMemoryStatusDao;
import com.obric.memorydata.database.dao.DataBuildMemoryStatusDao_Impl;
import com.obric.memorydata.database.dao.DeviceBootDao;
import com.obric.memorydata.database.dao.DeviceBootDao_Impl;
import com.obric.memorydata.database.dao.DeviceShutdownDao;
import com.obric.memorydata.database.dao.DeviceShutdownDao_Impl;
import com.obric.memorydata.database.dao.DoubaoAccountEntityRawDbDao;
import com.obric.memorydata.database.dao.DoubaoAccountEntityRawDbDao_Impl;
import com.obric.memorydata.database.dao.ElementKGIndexPendingDao;
import com.obric.memorydata.database.dao.ElementKGIndexPendingDao_Impl;
import com.obric.memorydata.database.dao.EmbeddingVectorCacheDao;
import com.obric.memorydata.database.dao.EmbeddingVectorCacheDao_Impl;
import com.obric.memorydata.database.dao.EntityIndexLifecycleDao;
import com.obric.memorydata.database.dao.EntityIndexLifecycleDao_MemoryFrameDb_Impl;
import com.obric.memorydata.database.dao.EvaluationSourceDataDao;
import com.obric.memorydata.database.dao.EvaluationSourceDataDao_Impl;
import com.obric.memorydata.database.dao.FileEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.FileEntityTextVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.FileHistoryEntityDao;
import com.obric.memorydata.database.dao.FileHistoryEntityDao_Impl;
import com.obric.memorydata.database.dao.FileRawDbDao;
import com.obric.memorydata.database.dao.FileRawDbDao_Impl;
import com.obric.memorydata.database.dao.FileTextEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.FileTextEntityTextVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.FileTextRawDbDao;
import com.obric.memorydata.database.dao.FileTextRawDbDao_Impl;
import com.obric.memorydata.database.dao.GeographyDao;
import com.obric.memorydata.database.dao.GeographyDao_Impl;
import com.obric.memorydata.database.dao.GlassesSyncStateDao;
import com.obric.memorydata.database.dao.GlassesSyncStateDao_Impl;
import com.obric.memorydata.database.dao.HarStateDao;
import com.obric.memorydata.database.dao.HarStateDao_Impl;
import com.obric.memorydata.database.dao.ICSProtocolEntityRawDbDao;
import com.obric.memorydata.database.dao.ICSProtocolEntityRawDbDao_Impl;
import com.obric.memorydata.database.dao.ICSProtocolHistoryEntityDao;
import com.obric.memorydata.database.dao.ICSProtocolHistoryEntityDao_Impl;
import com.obric.memorydata.database.dao.InAppL1RuleDao;
import com.obric.memorydata.database.dao.InAppL1RuleDao_Impl;
import com.obric.memorydata.database.dao.InAppTraceUploadDao;
import com.obric.memorydata.database.dao.InAppTraceUploadDao_Impl;
import com.obric.memorydata.database.dao.IndexPendingDao;
import com.obric.memorydata.database.dao.IndexPendingDao_MemoryFrameDb_Impl;
import com.obric.memorydata.database.dao.LanguageChangeEventDao;
import com.obric.memorydata.database.dao.LanguageChangeEventDao_Impl;
import com.obric.memorydata.database.dao.LightSensorDao;
import com.obric.memorydata.database.dao.LightSensorDao_Impl;
import com.obric.memorydata.database.dao.LocalMemorySyncToDoubaoPendingDao;
import com.obric.memorydata.database.dao.LocalMemorySyncToDoubaoPendingDao_Impl;
import com.obric.memorydata.database.dao.LocationAddressCacheDao;
import com.obric.memorydata.database.dao.LocationAddressCacheDao_Impl;
import com.obric.memorydata.database.dao.LocationDao;
import com.obric.memorydata.database.dao.LocationDao_Impl;
import com.obric.memorydata.database.dao.MemoryEntityContentTimeDao;
import com.obric.memorydata.database.dao.MemoryEntityContentTimeDao_Impl;
import com.obric.memorydata.database.dao.MemoryEntityRawDbDao;
import com.obric.memorydata.database.dao.MemoryEntityRawDbDao_Impl;
import com.obric.memorydata.database.dao.MemoryEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.MemoryEntityTextVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.MemoryLocationEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.MemoryLocationEntityTextVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.MemoryLocationRawDbDao;
import com.obric.memorydata.database.dao.MemoryLocationRawDbDao_Impl;
import com.obric.memorydata.database.dao.MemoryMapTableDao;
import com.obric.memorydata.database.dao.MemoryMapTableDao_Impl;
import com.obric.memorydata.database.dao.MemoryProcessConsumerSubscriptionDao;
import com.obric.memorydata.database.dao.MemoryProcessConsumerSubscriptionDao_Impl;
import com.obric.memorydata.database.dao.MemoryProcessOperationRecordDao;
import com.obric.memorydata.database.dao.MemoryProcessOperationRecordDao_Impl;
import com.obric.memorydata.database.dao.MemoryProcessOutputEventDao;
import com.obric.memorydata.database.dao.MemoryProcessOutputEventDao_Impl;
import com.obric.memorydata.database.dao.MemoryProcessSourceEventDao;
import com.obric.memorydata.database.dao.MemoryProcessSourceEventDao_Impl;
import com.obric.memorydata.database.dao.MemoryProcessTriggerStateDao;
import com.obric.memorydata.database.dao.MemoryProcessTriggerStateDao_Impl;
import com.obric.memorydata.database.dao.MemoryTraceReportDao;
import com.obric.memorydata.database.dao.MemoryTraceReportDao_Impl;
import com.obric.memorydata.database.dao.MessageEntityContentTimeDao;
import com.obric.memorydata.database.dao.MessageEntityContentTimeDao_Impl;
import com.obric.memorydata.database.dao.MessageEntityImageVectorCopilotDao;
import com.obric.memorydata.database.dao.MessageEntityImageVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.MessageEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.MessageEntityTextVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.MessageHistoryRawDbDao;
import com.obric.memorydata.database.dao.MessageHistoryRawDbDao_Impl;
import com.obric.memorydata.database.dao.MessageRawDbDao;
import com.obric.memorydata.database.dao.MessageRawDbDao_Impl;
import com.obric.memorydata.database.dao.MetaFullContentKeywordCopilotDao;
import com.obric.memorydata.database.dao.MetaFullContentKeywordCopilotDao_Impl;
import com.obric.memorydata.database.dao.MetaLocationEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.MetaLocationEntityTextVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.MetaLocationRawDbDao;
import com.obric.memorydata.database.dao.MetaLocationRawDbDao_Impl;
import com.obric.memorydata.database.dao.MetaTagRawDbDao;
import com.obric.memorydata.database.dao.MetaTagRawDbDao_Impl;
import com.obric.memorydata.database.dao.MobileCellularDao;
import com.obric.memorydata.database.dao.MobileCellularDao_Impl;
import com.obric.memorydata.database.dao.MovementStateDao;
import com.obric.memorydata.database.dao.MovementStateDao_Impl;
import com.obric.memorydata.database.dao.NetworkStatusDao;
import com.obric.memorydata.database.dao.NetworkStatusDao_Impl;
import com.obric.memorydata.database.dao.NetworkTypeDao;
import com.obric.memorydata.database.dao.NetworkTypeDao_Impl;
import com.obric.memorydata.database.dao.NoteEntityContentTimeDao;
import com.obric.memorydata.database.dao.NoteEntityContentTimeDao_Impl;
import com.obric.memorydata.database.dao.NoteEntityImageVectorCopilotDao;
import com.obric.memorydata.database.dao.NoteEntityImageVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.NoteEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.NoteEntityTextVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.NoteRawDbDao;
import com.obric.memorydata.database.dao.NoteRawDbDao_Impl;
import com.obric.memorydata.database.dao.NoteRecordingEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.NoteRecordingEntityTextVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.NoteRecordingRawDbDao;
import com.obric.memorydata.database.dao.NoteRecordingRawDbDao_Impl;
import com.obric.memorydata.database.dao.NoteRecordingTextEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.NoteRecordingTextEntityTextVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.NoteRecordingTextRawDbDao;
import com.obric.memorydata.database.dao.NoteRecordingTextRawDbDao_Impl;
import com.obric.memorydata.database.dao.OrderHitDao;
import com.obric.memorydata.database.dao.OrderHitDao_Impl;
import com.obric.memorydata.database.dao.OsAudioPlayDao;
import com.obric.memorydata.database.dao.OsAudioPlayDao_Impl;
import com.obric.memorydata.database.dao.OsNotificationDao;
import com.obric.memorydata.database.dao.OsNotificationDao_Impl;
import com.obric.memorydata.database.dao.PackageEventDao;
import com.obric.memorydata.database.dao.PackageEventDao_Impl;
import com.obric.memorydata.database.dao.PhotoEntityImageVectorCopilotDao;
import com.obric.memorydata.database.dao.PhotoEntityImageVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.PhotoEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.PhotoEntityTextVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.PhotoFaceRawDbDao;
import com.obric.memorydata.database.dao.PhotoFaceRawDbDao_Impl;
import com.obric.memorydata.database.dao.PhotoHistoryEntityDao;
import com.obric.memorydata.database.dao.PhotoHistoryEntityDao_Impl;
import com.obric.memorydata.database.dao.PhotoRawDbDao;
import com.obric.memorydata.database.dao.PhotoRawDbDao_Impl;
import com.obric.memorydata.database.dao.PoiInfoGroupDao;
import com.obric.memorydata.database.dao.PoiInfoGroupDao_Impl;
import com.obric.memorydata.database.dao.PoiReqRecorderDao;
import com.obric.memorydata.database.dao.PoiReqRecorderDao_Impl;
import com.obric.memorydata.database.dao.PredictAppDao;
import com.obric.memorydata.database.dao.PredictAppDao_Impl;
import com.obric.memorydata.database.dao.PredictSleepWakeupDao;
import com.obric.memorydata.database.dao.PredictSleepWakeupDao_Impl;
import com.obric.memorydata.database.dao.ProactiveMemoryProcessInfoDao;
import com.obric.memorydata.database.dao.ProactiveMemoryProcessInfoDao_Impl;
import com.obric.memorydata.database.dao.ProactiveMemorySyncPendingDao;
import com.obric.memorydata.database.dao.ProactiveMemorySyncPendingDao_Impl;
import com.obric.memorydata.database.dao.ProactiveOsNotificationDao;
import com.obric.memorydata.database.dao.ProactiveOsNotificationDao_Impl;
import com.obric.memorydata.database.dao.RawChatAppChatDao;
import com.obric.memorydata.database.dao.RawChatAppChatDao_Impl;
import com.obric.memorydata.database.dao.RawMemoryHistoryRawDbDao;
import com.obric.memorydata.database.dao.RawMemoryHistoryRawDbDao_Impl;
import com.obric.memorydata.database.dao.RawObservationDao;
import com.obric.memorydata.database.dao.RawObservationDao_Impl;
import com.obric.memorydata.database.dao.RawPhotoContentTimeDao;
import com.obric.memorydata.database.dao.RawPhotoContentTimeDao_Impl;
import com.obric.memorydata.database.dao.RecordingEntityContentTimeDao;
import com.obric.memorydata.database.dao.RecordingEntityContentTimeDao_Impl;
import com.obric.memorydata.database.dao.RecordingEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.RecordingEntityTextVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.RecordingRawDbDao;
import com.obric.memorydata.database.dao.RecordingRawDbDao_Impl;
import com.obric.memorydata.database.dao.RecordingTextEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.RecordingTextEntityTextVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.RecordingTextRawDbDao;
import com.obric.memorydata.database.dao.RecordingTextRawDbDao_Impl;
import com.obric.memorydata.database.dao.ScheduleEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.ScheduleEntityTextVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.ScheduleRawDbDao;
import com.obric.memorydata.database.dao.ScheduleRawDbDao_Impl;
import com.obric.memorydata.database.dao.ScreenBrightnessDao;
import com.obric.memorydata.database.dao.ScreenBrightnessDao_Impl;
import com.obric.memorydata.database.dao.ScreenObservationDao;
import com.obric.memorydata.database.dao.ScreenObservationDao_Impl;
import com.obric.memorydata.database.dao.ScreenStateDao;
import com.obric.memorydata.database.dao.ScreenStateDao_Impl;
import com.obric.memorydata.database.dao.SettingsChangedDao;
import com.obric.memorydata.database.dao.SettingsChangedDao_Impl;
import com.obric.memorydata.database.dao.SpeakerEmbeddingPendingDao;
import com.obric.memorydata.database.dao.SpeakerEmbeddingPendingDao_Impl;
import com.obric.memorydata.database.dao.StreamVolumeDao;
import com.obric.memorydata.database.dao.StreamVolumeDao_Impl;
import com.obric.memorydata.database.dao.UploadDataDao;
import com.obric.memorydata.database.dao.UploadDataDao_Impl;
import com.obric.memorydata.database.dao.UserActionRecorderDao;
import com.obric.memorydata.database.dao.UserActionRecorderDao_Impl;
import com.obric.memorydata.database.dao.VideoFrameEntityImageVectorCopilotDao;
import com.obric.memorydata.database.dao.VideoFrameEntityImageVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.VideoFrameEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.VideoFrameEntityTextVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.VideoFrameRawDbDao;
import com.obric.memorydata.database.dao.VideoFrameRawDbDao_Impl;
import com.obric.memorydata.database.dao.WifiDao;
import com.obric.memorydata.database.dao.WifiDao_Impl;
import com.obric.memorydata.database.dao.WifiListDao;
import com.obric.memorydata.database.dao.WifiListDao_Impl;
import com.obric.memorydata.database.entity.AuditoryRecordingHistoryEntityDao_Impl;
import com.obric.memorydata.database.entity.NoteHistoryRawDbDao_Impl;
import com.obric.memorydata.database.entity.PhotoFaceHistoryRawDbDao_Impl;
import com.obric.memorydata.database.entity.RecordingHistoryRawDbDao_Impl;
import com.obric.memorydata.database.entity.dx;
import com.obric.memorydata.database.entity.el;
import com.obric.memorydata.database.entity.hx;
import com.obric.memorydata.database.legacy.backup.dao.BackUpAgentWatermarkDaoOld_Impl;
import com.obric.memorydata.database.legacy.backup.dao.BackUpAutoMemoryEpisodicRelevantDataDaoOld_Impl;
import com.obric.memorydata.database.legacy.backup.dao.BackUpAutoMemoryProEntityDaoOld_Impl;
import com.obric.memorydata.database.legacy.backup.dao.BackUpAutoMemoryProSlmEpisodicMemoryDaoOld_Impl;
import com.obric.memorydata.database.legacy.backup.dao.BackUpAutoMemoryProSlmPersonalInfoDaoOld_Impl;
import com.obric.memorydata.database.legacy.backup.dao.BackUpAutoMemorySemanticRelevantDataDaoOld_Impl;
import com.obric.memorydata.database.legacy.backup.dao.BackUpBlockMemoryContentDaoOld_Impl;
import com.obric.memorydata.database.legacy.backup.dao.BackUpEpisodicMemoryDaoOld_Impl;
import com.obric.memorydata.database.legacy.backup.dao.BackUpEpisodicTopicMemoryDaoOld_Impl;
import com.obric.memorydata.database.legacy.backup.dao.BackUpLifelogDaoOld_Impl;
import com.obric.memorydata.database.legacy.backup.dao.BackUpMemoryEntityCorrelationDaoOld_Impl;
import com.obric.memorydata.database.legacy.backup.dao.BackUpMemoryEntityToCalendarDaoOld_Impl;
import com.obric.memorydata.database.legacy.backup.dao.BackUpMemoryKeyInfoDaoOld_Impl;
import com.obric.memorydata.database.legacy.backup.dao.BackUpMemoryRuleDaoOld_Impl;
import com.obric.memorydata.database.legacy.backup.dao.BackUpPendingMemoryCalendarDaoOld_Impl;
import com.obric.memorydata.database.legacy.backup.dao.BackUpProactiveEpisodicRelevantDataDaoOld_Impl;
import com.obric.memorydata.database.legacy.backup.dao.BackUpProactiveSemanticRelevantDataDaoOld_Impl;
import com.obric.memorydata.database.legacy.backup.dao.BackUpRawUserProfileDaoOld_Impl;
import com.obric.memorydata.database.legacy.backup.dao.BackUpSlmAgentWatermarkDaoOld_Impl;
import com.obric.memorydata.database.legacy.backup.dao.BackUpSlmAutoMemoryProTempResultDaoOld_Impl;
import com.obric.memorydata.database.legacy.backup.dao.BackUpUnionSemanticMemoryDaoOld_Impl;
import com.obric.memorydata.database.legacy.backup.dao.BackUpUpdateProactiveSemanticRelevantDataDaoOld_Impl;
import com.obric.memorydata.database.legacy.backup.dao.BackUpUpdateUnionSemanticMemoryDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.AgentWatermarkDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.AssistantChatDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.AssistantChatMessageDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.AutoMemoryEpisodicRelevantDataDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.AutoMemoryProDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.AutoMemoryProEvaluationStatsDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.AutoMemoryProHistoryRawDbDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.AutoMemoryProRawSourceDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.AutoMemoryProSlmEpisodicMemoryDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.AutoMemoryProSlmPersonalInfoDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.AutoMemoryProSnapShotDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.AutoMemoryProTextEntityTextVectorCopilotDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.AutoMemorySemanticRelevantDataDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.BlockMemoryContentDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.ComplexRecommendQueryDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.EpisodicMemoryContentTimeDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.EpisodicMemoryDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.EpisodicMemoryHistoryRawDbDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.EpisodicMemoryTextVectorCopilotDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.EpisodicTopicMemoryDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.EpisodicTopicMemoryHistoryRawDbDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.EpisodicTopicMemoryTextVectorCopilotDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.LifeLogTextEntityTextVectorCopilotDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.LifelogDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.LifelogHistoryRawDbDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.MemoryBaseRequirementDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.MemoryBaseSceneDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.MemoryEntityCorrelationDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.MemoryEntityToCalendarDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.MemoryKeyInfoDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.MemoryProcessUserInsightDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.MemoryReviewFeedbackDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.MemoryRuleDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.MiddleUserProfileDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.PendingContextDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.PendingEpisodicDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.PendingMemoryCalendarDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.PendingSemanticDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.ProactiveEpisodicRelevantDataDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.ProactiveSemanticRelevantDataDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.RawUserProfileHistoryRawDbDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.SemanticMemoryDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.SemanticTextCopilotDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.SlmAgentWatermarkDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.SlmAutoMemoryProTempResultDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.UnionSemanticMemoryExtDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.UnionSemanticMemoryHistoryRawDbDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.UnionSemanticMemorySnapShotDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.UnionSemanticTypeSummaryDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.UnionUserInsightDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.UnionUserPersonaDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.UpdateProactiveSemanticRelevantDataDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.UpdateUnionSemanticMemoryDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.UserKeywordDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.UserProfileDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.UserProfileMemoryDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.UserProfileRawDbDaoOld_Impl;
import com.obric.memorydata.database.legacy.dao.UserProfileTextEntityTextVectorCopilotDaoOld_Impl;
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
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class MemoryFrameDb_Impl extends MemoryFrameDb {
    private volatile com.obric.memorydata.database.legacy.dao.a _agentWatermarkDaoOld;
    private volatile AlarmDao _alarmDao;
    private volatile AlarmEntityTextVectorCopilotDao _alarmEntityTextVectorCopilotDao;
    private volatile AlarmRawDbDao _alarmRawDbDao;
    private volatile AlbumHistoryEntityDao _albumHistoryEntityDao;
    private volatile AlbumRawDbDao _albumRawDbDao;
    private volatile AppActivityDao _appActivityDao;
    private volatile AppUsageDao _appUsageDao;
    private volatile ArriveLeaveHomeCompanyEventDao _arriveLeaveHomeCompanyEventDao;
    private volatile com.obric.memorydata.database.legacy.dao.b _assistantChatDaoOld;
    private volatile com.obric.memorydata.database.legacy.dao.c _assistantChatMessageDaoOld;
    private volatile AuditoryAsrTaskDao _auditoryAsrTaskDao;
    private volatile AuditoryRecordingEntityTextVectorCopilotDao _auditoryRecordingEntityTextVectorCopilotDao;
    private volatile com.obric.memorydata.database.entity.r _auditoryRecordingHistoryEntityDao;
    private volatile AuditoryRecordingRawDbDao _auditoryRecordingRawDbDao;
    private volatile AuditoryRecordingTextEntityTextVectorCopilotDao _auditoryRecordingTextEntityTextVectorCopilotDao;
    private volatile AuditoryRecordingTextRawDbDao _auditoryRecordingTextRawDbDao;
    private volatile AuditorySyncStateDao _auditorySyncStateDao;
    private volatile com.obric.memorydata.database.legacy.dao.d _autoMemoryEpisodicRelevantDataDaoOld;
    private volatile com.obric.memorydata.database.legacy.dao.e _autoMemoryProDaoOld;
    private volatile com.obric.memorydata.database.legacy.dao.f _autoMemoryProEvaluationStatsDaoOld;
    private volatile com.obric.memorydata.database.legacy.dao.g _autoMemoryProHistoryRawDbDaoOld;
    private volatile com.obric.memorydata.database.legacy.dao.h _autoMemoryProRawSourceDaoOld;
    private volatile com.obric.memorydata.database.legacy.dao.i _autoMemoryProSlmEpisodicMemoryDaoOld;
    private volatile com.obric.memorydata.database.legacy.dao.j _autoMemoryProSlmPersonalInfoDaoOld;
    private volatile com.obric.memorydata.database.legacy.dao.k _autoMemoryProSnapShotDaoOld;
    private volatile com.obric.memorydata.database.legacy.dao.l _autoMemoryProTextEntityTextVectorCopilotDaoOld;
    private volatile AutoMemoryProTraceDao _autoMemoryProTraceDao;
    private volatile com.obric.memorydata.database.legacy.dao.m _autoMemorySemanticRelevantDataDaoOld;
    private volatile AwarenessInfoDao _awarenessInfoDao;
    private volatile com.obric.memorydata.database.legacy.backup.dao.a _backUpAgentWatermarkDaoOld;
    private volatile com.obric.memorydata.database.legacy.backup.dao.b _backUpAutoMemoryEpisodicRelevantDataDaoOld;
    private volatile com.obric.memorydata.database.legacy.backup.dao.c _backUpAutoMemoryProEntityDaoOld;
    private volatile com.obric.memorydata.database.legacy.backup.dao.d _backUpAutoMemoryProSlmEpisodicMemoryDaoOld;
    private volatile com.obric.memorydata.database.legacy.backup.dao.e _backUpAutoMemoryProSlmPersonalInfoDaoOld;
    private volatile com.obric.memorydata.database.backup.dao.a _backUpAutoMemoryProSnapShotDao;
    private volatile com.obric.memorydata.database.legacy.backup.dao.f _backUpAutoMemorySemanticRelevantDataDaoOld;
    private volatile com.obric.memorydata.database.legacy.backup.dao.g _backUpBlockMemoryContentDaoOld;
    private volatile com.obric.memorydata.database.legacy.backup.dao.h _backUpEpisodicMemoryDaoOld;
    private volatile com.obric.memorydata.database.legacy.backup.dao.i _backUpEpisodicTopicMemoryDaoOld;
    private volatile com.obric.memorydata.database.legacy.backup.dao.j _backUpLifelogDaoOld;
    private volatile com.obric.memorydata.database.legacy.backup.dao.k _backUpMemoryEntityCorrelationDaoOld;
    private volatile com.obric.memorydata.database.legacy.backup.dao.l _backUpMemoryEntityToCalendarDaoOld;
    private volatile com.obric.memorydata.database.legacy.backup.dao.m _backUpMemoryKeyInfoDaoOld;
    private volatile com.obric.memorydata.database.backup.dao.b _backUpMemoryReviewFeedbackDao;
    private volatile com.obric.memorydata.database.legacy.backup.dao.n _backUpMemoryRuleDaoOld;
    private volatile com.obric.memorydata.database.legacy.backup.dao.o _backUpPendingMemoryCalendarDaoOld;
    private volatile com.obric.memorydata.database.legacy.backup.dao.p _backUpProactiveEpisodicRelevantDataDaoOld;
    private volatile com.obric.memorydata.database.legacy.backup.dao.q _backUpProactiveSemanticRelevantDataDaoOld;
    private volatile com.obric.memorydata.database.backup.dao.c _backUpRawMemoryDao;
    private volatile com.obric.memorydata.database.legacy.backup.dao.r _backUpRawUserProfileDaoOld;
    private volatile com.obric.memorydata.database.legacy.backup.dao.s _backUpSlmAgentWatermarkDaoOld;
    private volatile com.obric.memorydata.database.legacy.backup.dao.t _backUpSlmAutoMemoryProTempResultDaoOld;
    private volatile com.obric.memorydata.database.legacy.backup.dao.u _backUpUnionSemanticMemoryDaoOld;
    private volatile com.obric.memorydata.database.backup.dao.d _backUpUnionSemanticMemorySnapShotDao;
    private volatile com.obric.memorydata.database.legacy.backup.dao.v _backUpUpdateProactiveSemanticRelevantDataDaoOld;
    private volatile com.obric.memorydata.database.legacy.backup.dao.w _backUpUpdateUnionSemanticMemoryDaoOld;
    private volatile BatchChatDao _batchChatDao;
    private volatile BatteryStateDao _batteryStateDao;
    private volatile com.obric.memorydata.database.legacy.dao.n _blockMemoryContentDaoOld;
    private volatile BluetoothDeviceDao _bluetoothDeviceDao;
    private volatile BrowserBookmarkHistoryEntityDao _browserBookmarkHistoryEntityDao;
    private volatile BrowserBookmarkRawDbDao _browserBookmarkRawDbDao;
    private volatile BssidCalcCacheDao _bssidCalcCacheDao;
    private volatile CallHistoryEntityContentTimeDao _callHistoryEntityContentTimeDao;
    private volatile CallHistoryEntityTextVectorCopilotDao _callHistoryEntityTextVectorCopilotDao;
    private volatile CallHistoryHistoryEntityDao _callHistoryHistoryEntityDao;
    private volatile CallHistoryRawDbDao _callHistoryRawDbDao;
    private volatile CellInfoDao _cellInfoDao;
    private volatile CommonPhotoEntityImageVectorCopilotDao _commonPhotoEntityImageVectorCopilotDao;
    private volatile CommonPhotoEntityTextVectorCopilotDao _commonPhotoEntityTextVectorCopilotDao;
    private volatile CommonPhotoRawDbDao _commonPhotoRawDbDao;
    private volatile CommonVideoFrameEntityImageVectorCopilotDao _commonVideoFrameEntityImageVectorCopilotDao;
    private volatile CommonVideoFrameEntityTextVectorCopilotDao _commonVideoFrameEntityTextVectorCopilotDao;
    private volatile CommonVideoFrameRawDbDao _commonVideoFrameRawDbDao;
    private volatile com.obric.memorydata.database.legacy.dao.o _complexRecommendQueryDaoOld;
    private volatile ContactEntityImageVectorCopilotDao _contactEntityImageVectorCopilotDao;
    private volatile ContactEntityTextVectorCopilotDao _contactEntityTextVectorCopilotDao;
    private volatile ContactHistoryEntityDao _contactHistoryEntityDao;
    private volatile ContactRawDbDao _contactRawDbDao;
    private volatile CountdownEntityTextVectorCopilotDao _countdownEntityTextVectorCopilotDao;
    private volatile CountdownRawDbDao _countdownRawDbDao;
    private volatile DataBuildMemoryStatusDao _dataBuildMemoryStatusDao;
    private volatile DeviceBootDao _deviceBootDao;
    private volatile DeviceShutdownDao _deviceShutdownDao;
    private volatile DoubaoAccountEntityRawDbDao _doubaoAccountEntityRawDbDao;
    private volatile ElementKGIndexPendingDao _elementKGIndexPendingDao;
    private volatile EmbeddingVectorCacheDao _embeddingVectorCacheDao;
    private volatile EntityIndexLifecycleDao _entityIndexLifecycleDao;
    private volatile com.obric.memorydata.database.legacy.dao.p _episodicMemoryContentTimeDaoOld;
    private volatile com.obric.memorydata.database.legacy.dao.q _episodicMemoryDaoOld;
    private volatile com.obric.memorydata.database.legacy.dao.r _episodicMemoryHistoryRawDbDaoOld;
    private volatile com.obric.memorydata.database.legacy.dao.s _episodicMemoryTextVectorCopilotDaoOld;
    private volatile com.obric.memorydata.database.legacy.dao.t _episodicTopicMemoryDaoOld;
    private volatile com.obric.memorydata.database.legacy.dao.u _episodicTopicMemoryHistoryRawDbDaoOld;
    private volatile com.obric.memorydata.database.legacy.dao.v _episodicTopicMemoryTextVectorCopilotDaoOld;
    private volatile EvaluationSourceDataDao _evaluationSourceDataDao;
    private volatile FileEntityTextVectorCopilotDao _fileEntityTextVectorCopilotDao;
    private volatile FileHistoryEntityDao _fileHistoryEntityDao;
    private volatile FileRawDbDao _fileRawDbDao;
    private volatile FileTextEntityTextVectorCopilotDao _fileTextEntityTextVectorCopilotDao;
    private volatile FileTextRawDbDao _fileTextRawDbDao;
    private volatile GeographyDao _geographyDao;
    private volatile GlassesSyncStateDao _glassesSyncStateDao;
    private volatile HarStateDao _harStateDao;
    private volatile ICSProtocolEntityRawDbDao _iCSProtocolEntityRawDbDao;
    private volatile ICSProtocolHistoryEntityDao _iCSProtocolHistoryEntityDao;
    private volatile InAppL1RuleDao _inAppL1RuleDao;
    private volatile InAppTraceUploadDao _inAppTraceUploadDao;
    private volatile IndexPendingDao _indexPendingDao;
    private volatile LanguageChangeEventDao _languageChangeEventDao;
    private volatile com.obric.memorydata.database.legacy.dao.w _lifeLogTextEntityTextVectorCopilotDaoOld;
    private volatile x _lifelogDaoOld;
    private volatile y _lifelogHistoryRawDbDaoOld;
    private volatile LightSensorDao _lightSensorDao;
    private volatile LocalMemorySyncToDoubaoPendingDao _localMemorySyncToDoubaoPendingDao;
    private volatile LocationAddressCacheDao _locationAddressCacheDao;
    private volatile LocationDao _locationDao;
    private volatile z _memoryBaseRequirementDaoOld;
    private volatile aa _memoryBaseSceneDaoOld;
    private volatile MemoryEntityContentTimeDao _memoryEntityContentTimeDao;
    private volatile ab _memoryEntityCorrelationDaoOld;
    private volatile MemoryEntityRawDbDao _memoryEntityRawDbDao;
    private volatile MemoryEntityTextVectorCopilotDao _memoryEntityTextVectorCopilotDao;
    private volatile ac _memoryEntityToCalendarDaoOld;
    private volatile ad _memoryKeyInfoDaoOld;
    private volatile MemoryLocationEntityTextVectorCopilotDao _memoryLocationEntityTextVectorCopilotDao;
    private volatile MemoryLocationRawDbDao _memoryLocationRawDbDao;
    private volatile MemoryMapTableDao _memoryMapTableDao;
    private volatile MemoryProcessConsumerSubscriptionDao _memoryProcessConsumerSubscriptionDao;
    private volatile MemoryProcessOperationRecordDao _memoryProcessOperationRecordDao;
    private volatile MemoryProcessOutputEventDao _memoryProcessOutputEventDao;
    private volatile MemoryProcessSourceEventDao _memoryProcessSourceEventDao;
    private volatile MemoryProcessTriggerStateDao _memoryProcessTriggerStateDao;
    private volatile ae _memoryProcessUserInsightDaoOld;
    private volatile af _memoryReviewFeedbackDaoOld;
    private volatile ag _memoryRuleDaoOld;
    private volatile MemoryTraceReportDao _memoryTraceReportDao;
    private volatile MessageEntityContentTimeDao _messageEntityContentTimeDao;
    private volatile MessageEntityImageVectorCopilotDao _messageEntityImageVectorCopilotDao;
    private volatile MessageEntityTextVectorCopilotDao _messageEntityTextVectorCopilotDao;
    private volatile MessageHistoryRawDbDao _messageHistoryRawDbDao;
    private volatile MessageRawDbDao _messageRawDbDao;
    private volatile MetaFullContentKeywordCopilotDao _metaFullContentKeywordCopilotDao;
    private volatile MetaLocationEntityTextVectorCopilotDao _metaLocationEntityTextVectorCopilotDao;
    private volatile MetaLocationRawDbDao _metaLocationRawDbDao;
    private volatile MetaTagRawDbDao _metaTagRawDbDao;
    private volatile ah _middleUserProfileDaoOld;
    private volatile MobileCellularDao _mobileCellularDao;
    private volatile MovementStateDao _movementStateDao;
    private volatile NetworkStatusDao _networkStatusDao;
    private volatile NetworkTypeDao _networkTypeDao;
    private volatile NoteEntityContentTimeDao _noteEntityContentTimeDao;
    private volatile NoteEntityImageVectorCopilotDao _noteEntityImageVectorCopilotDao;
    private volatile NoteEntityTextVectorCopilotDao _noteEntityTextVectorCopilotDao;
    private volatile dx _noteHistoryRawDbDao;
    private volatile NoteRawDbDao _noteRawDbDao;
    private volatile NoteRecordingEntityTextVectorCopilotDao _noteRecordingEntityTextVectorCopilotDao;
    private volatile NoteRecordingRawDbDao _noteRecordingRawDbDao;
    private volatile NoteRecordingTextEntityTextVectorCopilotDao _noteRecordingTextEntityTextVectorCopilotDao;
    private volatile NoteRecordingTextRawDbDao _noteRecordingTextRawDbDao;
    private volatile OrderHitDao _orderHitDao;
    private volatile OsAudioPlayDao _osAudioPlayDao;
    private volatile OsNotificationDao _osNotificationDao;
    private volatile PackageEventDao _packageEventDao;
    private volatile ai _pendingContextDaoOld;
    private volatile aj _pendingEpisodicDaoOld;
    private volatile ak _pendingMemoryCalendarDaoOld;
    private volatile al _pendingSemanticDaoOld;
    private volatile PhotoEntityImageVectorCopilotDao _photoEntityImageVectorCopilotDao;
    private volatile PhotoEntityTextVectorCopilotDao _photoEntityTextVectorCopilotDao;
    private volatile el _photoFaceHistoryRawDbDao;
    private volatile PhotoFaceRawDbDao _photoFaceRawDbDao;
    private volatile PhotoHistoryEntityDao _photoHistoryEntityDao;
    private volatile PhotoRawDbDao _photoRawDbDao;
    private volatile PoiInfoGroupDao _poiInfoGroupDao;
    private volatile PoiReqRecorderDao _poiReqRecorderDao;
    private volatile PredictAppDao _predictAppDao;
    private volatile PredictSleepWakeupDao _predictSleepWakeupDao;
    private volatile am _proactiveEpisodicRelevantDataDaoOld;
    private volatile ProactiveMemoryProcessInfoDao _proactiveMemoryProcessInfoDao;
    private volatile ProactiveMemorySyncPendingDao _proactiveMemorySyncPendingDao;
    private volatile ProactiveOsNotificationDao _proactiveOsNotificationDao;
    private volatile an _proactiveSemanticRelevantDataDaoOld;
    private volatile RawChatAppChatDao _rawChatAppChatDao;
    private volatile RawMemoryHistoryRawDbDao _rawMemoryHistoryRawDbDao;
    private volatile RawObservationDao _rawObservationDao;
    private volatile RawPhotoContentTimeDao _rawPhotoContentTimeDao;
    private volatile ao _rawUserProfileHistoryRawDbDaoOld;
    private volatile RecordingEntityContentTimeDao _recordingEntityContentTimeDao;
    private volatile RecordingEntityTextVectorCopilotDao _recordingEntityTextVectorCopilotDao;
    private volatile hx _recordingHistoryRawDbDao;
    private volatile RecordingRawDbDao _recordingRawDbDao;
    private volatile RecordingTextEntityTextVectorCopilotDao _recordingTextEntityTextVectorCopilotDao;
    private volatile RecordingTextRawDbDao _recordingTextRawDbDao;
    private volatile ScheduleEntityTextVectorCopilotDao _scheduleEntityTextVectorCopilotDao;
    private volatile ScheduleRawDbDao _scheduleRawDbDao;
    private volatile ScreenBrightnessDao _screenBrightnessDao;
    private volatile ScreenObservationDao _screenObservationDao;
    private volatile ScreenStateDao _screenStateDao;
    private volatile ap _semanticMemoryDaoOld;
    private volatile aq _semanticTextCopilotDaoOld;
    private volatile SettingsChangedDao _settingsChangedDao;
    private volatile ar _slmAgentWatermarkDaoOld;
    private volatile as _slmAutoMemoryProTempResultDaoOld;
    private volatile SpeakerEmbeddingPendingDao _speakerEmbeddingPendingDao;
    private volatile StreamVolumeDao _streamVolumeDao;
    private volatile at _unionSemanticMemoryExtDaoOld;
    private volatile au _unionSemanticMemoryHistoryRawDbDaoOld;
    private volatile av _unionSemanticMemorySnapShotDaoOld;
    private volatile aw _unionSemanticTypeSummaryDaoOld;
    private volatile ax _unionUserInsightDaoOld;
    private volatile ay _unionUserPersonaDaoOld;
    private volatile az _updateProactiveSemanticRelevantDataDaoOld;
    private volatile ba _updateUnionSemanticMemoryDaoOld;
    private volatile UploadDataDao _uploadDataDao;
    private volatile UserActionRecorderDao _userActionRecorderDao;
    private volatile bb _userKeywordDaoOld;
    private volatile bc _userProfileDaoOld;
    private volatile bd _userProfileMemoryDaoOld;
    private volatile be _userProfileRawDbDaoOld;
    private volatile bf _userProfileTextEntityTextVectorCopilotDaoOld;
    private volatile VideoFrameEntityImageVectorCopilotDao _videoFrameEntityImageVectorCopilotDao;
    private volatile VideoFrameEntityTextVectorCopilotDao _videoFrameEntityTextVectorCopilotDao;
    private volatile VideoFrameRawDbDao _videoFrameRawDbDao;
    private volatile WifiDao _wifiDao;
    private volatile WifiListDao _wifiListDao;

    public MemoryFrameDb_Impl() {
    }

    static /* synthetic */ List access$000(MemoryFrameDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$100(MemoryFrameDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$1000(MemoryFrameDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$200(MemoryFrameDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$300(MemoryFrameDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$400(MemoryFrameDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$500(MemoryFrameDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ SupportSQLiteDatabase access$602(MemoryFrameDb_Impl r2, SupportSQLiteDatabase r3) {
        SupportSQLiteDatabase r4 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r2.mDatabase = r4;
        return r4;
    }

    static /* synthetic */ void access$700(MemoryFrameDb_Impl r2, SupportSQLiteDatabase r3) {
        r2.internalInitInvalidationTracker((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ List access$800(MemoryFrameDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$900(MemoryFrameDb_Impl r0) {
        return r0.mCallbacks;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb, androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r0 = super.getOpenHelper().getWritableDatabase();
        if (Build.VERSION.SDK_INT < 21) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L28;
    L9:
        super.beginTransaction();     // Catch: Throwable -> L20
        if (r1 == false) goto L12;
        r0.execSQL("PRAGMA defer_foreign_keys = TRUE");     // Catch: Throwable -> L20
    L12:
        r0.execSQL("DELETE FROM `RawGeography`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawMobileCellular`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawWifi`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawLocation`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawScreenState`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MiddleUserProfile`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `UserProfile`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawBluetoothDevice`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawAppActivity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawStreamVolume`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawSettingsChanged`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawScreenBrightness`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawPackageEvent`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawOsNotification`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawNetworkStatus`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawMovementState`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawLightSensor`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawLanguageChangeEvent`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawBatteryState`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawDeviceBoot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawDeviceShutdown`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `app_usage_info`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `network_type`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `predict_app_result`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawAlarm`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `predict_sleep_result`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `PoiInfoGroup`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `PoiReqRecorder`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `UseActionRecorder`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `UploadData`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawWxChat`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawAudioPlay`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawMessageEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AppEntityIndexPending`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `EntityIndexLifecycle`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MessageEntityTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `EvaluationSourceData`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawContactEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawCallHistoryEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `ContactEntityTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `ElementRelationData`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `ElementPropertyData`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `ElementMention2EntityData`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `ElementRelMention2RelationData`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `ElementSettingsData`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `ElementSummary`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AppElementMapID`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `CallHistoryEntityTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawNoteEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `NoteEntityTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MessageEntityImageVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `ContactEntityImageVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `NoteEntityImageVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawAlbumEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawPhotoEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawPhotoFaceEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawMetaLocationEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawMetaTagEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `LocationAddressCache`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `PhotoEntityTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `PhotoEntityImageVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MetaLocationEntityTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `EmbeddingVectorCache`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawAlarmEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `ElementKGIndexPending`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawVideoFrameEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `VideoFrameEntityImageVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `VideoFrameEntityTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AlarmEntityTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `ShortMemory`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `ShortMemoryTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MemoryEntityTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BatchChat`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawMemoryEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `DataBuildMemoryStatus`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `SmartMemoryOrderHit`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawMemoryLocationEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MemoryLocationEntityTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawRecordingEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawAuditoryRecordingEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawNoteRecordingEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawBrowserBookmarkEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawFileEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawScheduleEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawNoteRecordingTextEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawRecordingTextEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawAuditoryRecordingTextEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawFileTextEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `NoteRecordingTextEntityTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RecordingTextEntityTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AuditoryRecordingTextEntityTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RecordingEntityTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AuditoryRecordingEntityTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `FileEntityTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `FileTextEntityTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `NoteRecordingEntityTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `ScheduleEntityTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AppEntityToMemoryTable`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawMemoryEntityCorrelation`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawCountdownEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `CountdownEntityTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawWifiInfoList`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawPhotoHistoryEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `ArriveLeaveHomeCompanyEvent`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `ShortMemoryContentTime`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawCommonPhotoEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawCommonVideoFrameEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `CommonPhotoEntityTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `CommonPhotoEntityImageVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `CommonVideoFrameEntityImageVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `CommonVideoFrameEntityTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `ScreenObservation`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawObservation`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `GlassesSyncState`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `SpeakerEmbeddingPending`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AuditoryAsrTask`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AuditorySyncState`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `ProactiveMemoryProcessInfo`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `ProactiveMemorySyncPending`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `Lifelog`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `UserProfileMemoryEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `ComplexRecommendQuery`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `PendingMemoryCalendar`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MemoryEntityToCalendar`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawICSProtocolEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawDoubaoAccountEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `LocalMemorySyncToDoubaoPending`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BlockMemoryContent`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BssidCalcCacheEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawMessageHistoryEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawContactHistoryEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawICSProtocolHistoryEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawCallHistoryHistoryEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawNoteHistoryEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawPhotoFaceHistoryEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `UnionSemanticMemoryHistoryEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawMemoryHistoryEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawAlbumHistoryEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawRecordingHistoryEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawAuditoryRecordingHistoryEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawBrowserBookmarkHistoryEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawFileHistoryEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `EpisodicTopicMemory`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `EpisodicTopicMemoryTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `UserProfileEntityTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawUserProfileEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `LifeLogEntityTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MessageEntityContentTime`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `CallHistoryEntityContentTime`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `NoteEntityContentTime`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RecordingEntityContentTime`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `PhotoEntityContentTime`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MetaFullContentKeywordCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `har_state`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AwarenessInfo`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `ProactiveOsNotification`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `cell_info`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MemoryKeyInfoEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `UserKeyword`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MemoryEntityContentTime`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AssistantChatEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AssistantChatMessageEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `UnionSemanticMemory`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `UnionSemanticMemoryExt`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `ProactiveEpisodicRelevantData`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `ProactiveSemanticRelevantData`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `UpdateUnionSemanticMemory`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `UpdateProactiveSemanticRelevantData`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `SemanticTextCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `PendingContext`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `PendingEpisodic`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `PendingSemantic`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MemoryRule`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AutoMemoryPro`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AutoMemoryProSlmPersonalInfo`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AutoMemoryProSlmEpisodicMemory`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `SlmAutoMemoryProTempResult`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AutoMemoryProEvaluationStats`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BackUpBlockMemoryContent`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BackUpEpisodicMemoryEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BackUpEpisodicTopicMemory`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BackUpLifelog`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BackUpRawMemoryEntityCorrelation`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BackUpMemoryEntityToCalendar`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BackUpMemoryKeyInfoEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BackUpPendingMemoryCalendar`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BackUpRawMemoryEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BackUpRawUserProfileEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `EpisodicMemoryHistoryEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `EpisodicTopicMemoryHistoryEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `LifelogHistoryEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawUserProfileHistoryEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BackUpProactiveSemanticRelevantData`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BackUpProactiveEpisodicRelevantData`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BackUpUnionSemanticMemory`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BackUpUpdateUnionSemanticMemory`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BackUpUpdateProactiveSemanticRelevantData`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AutoMemoryProHistoryEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AutoMemoryProTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BackUpAutoMemoryProEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BackUpAutoMemoryProSlmPersonalInfo`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BackUpAutoMemoryProSlmEpisodicMemory`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BackUpSlmAutoMemoryProTempResult`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BackUpAgentWatermark`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BackUpSlmAgentWatermark`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BacupMemoryRule`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `UnionSemanticTypeSummary`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `UnionUserInsight`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `UnionUserPersona`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AutoMemoryEpisodicRelevantData`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AutoMemorySemanticRelevantData`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AutoMemoryProRawSource`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MemoryBaseScene`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MemoryBaseRequirement`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MemoryProcessConsumerSubscription`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MemoryProcessSourceEvent`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MemoryProcessTriggerState`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MemoryProcessOperationRecord`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MemoryProcessOutputEvent`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MemoryProcessUserInsight`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AutoMemoryProSnapShot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `UnionSemanticMemorySnapShot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MemoryReviewFeedback`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MemoryTraceReport`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `InAppTraceUpload`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `in_app_l1_rule`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `InAppTraceObservation`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BackUpAutoMemoryEpisodicRelevantData`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BackUpAutoMemorySemanticRelevantData`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AgentWatermark`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `SlmAgentWatermark`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AutoMemoryTrace`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BackUpAutoMemoryProSnapShot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BackUpUnionSemanticMemorySnapShot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BackUpMemoryReviewFeedback`");     // Catch: Throwable -> L20
        super.setTransactionSuccessful();     // Catch: Throwable -> L20
        super.endTransaction();
        if (r1 == true) goto L16;
        r0.execSQL("PRAGMA foreign_keys = TRUE");
    L16:
        r0.query("PRAGMA wal_checkpoint(FULL)").close();
        if (r0.inTransaction() == true) goto L30;
        r0.execSQL("VACUUM");
        return;
    L30:
        return;
    L20:
        th = move-exception;
        super.endTransaction();
        if (r1 == true) goto L24;
        r0.execSQL("PRAGMA foreign_keys = TRUE");
    L24:
        r0.query("PRAGMA wal_checkpoint(FULL)").close();
        if (r0.inTransaction() == true) goto L27;
        r0.execSQL("VACUUM");
    L27:
        throw th;
    L28:
        r0.execSQL("PRAGMA foreign_keys = FALSE");     // Catch: Throwable -> L20
        goto L9
    L5:
        r1 = false;
        goto L7
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"RawGeography", "RawMobileCellular", "RawWifi", "RawLocation", "RawScreenState", "MiddleUserProfile", "UserProfile", "RawBluetoothDevice", "RawAppActivity", "RawStreamVolume", "RawSettingsChanged", "RawScreenBrightness", "RawPackageEvent", "RawOsNotification", "RawNetworkStatus", "RawMovementState", "RawLightSensor", "RawLanguageChangeEvent", "RawBatteryState", "RawDeviceBoot", "RawDeviceShutdown", "app_usage_info", Constants.KEY_NET_TYPE, "predict_app_result", "RawAlarm", "predict_sleep_result", "PoiInfoGroup", "PoiReqRecorder", "UseActionRecorder", "UploadData", "RawWxChat", "RawAudioPlay", "RawMessageEntity", "AppEntityIndexPending", "EntityIndexLifecycle", "MessageEntityTextVectorCopilot", "EvaluationSourceData", "RawContactEntity", "RawCallHistoryEntity", "ContactEntityTextVectorCopilot", "ElementRelationData", "ElementPropertyData", "ElementMention2EntityData", "ElementRelMention2RelationData", "ElementSettingsData", "ElementSummary", "AppElementMapID", "CallHistoryEntityTextVectorCopilot", "RawNoteEntity", "NoteEntityTextVectorCopilot", "MessageEntityImageVectorCopilot", "ContactEntityImageVectorCopilot", "NoteEntityImageVectorCopilot", "RawAlbumEntity", "RawPhotoEntity", "RawPhotoFaceEntity", "RawMetaLocationEntity", "RawMetaTagEntity", "LocationAddressCache", "PhotoEntityTextVectorCopilot", "PhotoEntityImageVectorCopilot", "MetaLocationEntityTextVectorCopilot", "EmbeddingVectorCache", "RawAlarmEntity", "ElementKGIndexPending", "RawVideoFrameEntity", "VideoFrameEntityImageVectorCopilot", "VideoFrameEntityTextVectorCopilot", "AlarmEntityTextVectorCopilot", "ShortMemory", "ShortMemoryTextVectorCopilot", "MemoryEntityTextVectorCopilot", "BatchChat", "RawMemoryEntity", "DataBuildMemoryStatus", "SmartMemoryOrderHit", "RawMemoryLocationEntity", "MemoryLocationEntityTextVectorCopilot", "RawRecordingEntity", "RawAuditoryRecordingEntity", "RawNoteRecordingEntity", "RawBrowserBookmarkEntity", "RawFileEntity", "RawScheduleEntity", "RawNoteRecordingTextEntity", "RawRecordingTextEntity", "RawAuditoryRecordingTextEntity", "RawFileTextEntity", "NoteRecordingTextEntityTextVectorCopilot", "RecordingTextEntityTextVectorCopilot", "AuditoryRecordingTextEntityTextVectorCopilot", "RecordingEntityTextVectorCopilot", "AuditoryRecordingEntityTextVectorCopilot", "FileEntityTextVectorCopilot", "FileTextEntityTextVectorCopilot", "NoteRecordingEntityTextVectorCopilot", "ScheduleEntityTextVectorCopilot", "AppEntityToMemoryTable", "RawMemoryEntityCorrelation", "RawCountdownEntity", "CountdownEntityTextVectorCopilot", "RawWifiInfoList", "RawPhotoHistoryEntity", "ArriveLeaveHomeCompanyEvent", "ShortMemoryContentTime", "RawCommonPhotoEntity", "RawCommonVideoFrameEntity", "CommonPhotoEntityTextVectorCopilot", "CommonPhotoEntityImageVectorCopilot", "CommonVideoFrameEntityImageVectorCopilot", "CommonVideoFrameEntityTextVectorCopilot", "ScreenObservation", "RawObservation", "GlassesSyncState", "SpeakerEmbeddingPending", "AuditoryAsrTask", "AuditorySyncState", "ProactiveMemoryProcessInfo", "ProactiveMemorySyncPending", "Lifelog", "UserProfileMemoryEntity", "ComplexRecommendQuery", "PendingMemoryCalendar", "MemoryEntityToCalendar", "RawICSProtocolEntity", "RawDoubaoAccountEntity", "LocalMemorySyncToDoubaoPending", "BlockMemoryContent", "BssidCalcCacheEntity", "RawMessageHistoryEntity", "RawContactHistoryEntity", "RawICSProtocolHistoryEntity", "RawCallHistoryHistoryEntity", "RawNoteHistoryEntity", "RawPhotoFaceHistoryEntity", "UnionSemanticMemoryHistoryEntity", "RawMemoryHistoryEntity", "RawAlbumHistoryEntity", "RawRecordingHistoryEntity", "RawAuditoryRecordingHistoryEntity", "RawBrowserBookmarkHistoryEntity", "RawFileHistoryEntity", "EpisodicTopicMemory", "EpisodicTopicMemoryTextVectorCopilot", "UserProfileEntityTextVectorCopilot", "RawUserProfileEntity", "LifeLogEntityTextVectorCopilot", "MessageEntityContentTime", "CallHistoryEntityContentTime", "NoteEntityContentTime", "RecordingEntityContentTime", "PhotoEntityContentTime", "MetaFullContentKeywordCopilot", "har_state", "AwarenessInfo", "ProactiveOsNotification", "cell_info", "MemoryKeyInfoEntity", "UserKeyword", "MemoryEntityContentTime", "AssistantChatEntity", "AssistantChatMessageEntity", "UnionSemanticMemory", "UnionSemanticMemoryExt", "ProactiveEpisodicRelevantData", "ProactiveSemanticRelevantData", "UpdateUnionSemanticMemory", "UpdateProactiveSemanticRelevantData", "SemanticTextCopilot", "PendingContext", "PendingEpisodic", "PendingSemantic", "MemoryRule", "AutoMemoryPro", "AutoMemoryProSlmPersonalInfo", "AutoMemoryProSlmEpisodicMemory", "SlmAutoMemoryProTempResult", "AutoMemoryProEvaluationStats", "BackUpBlockMemoryContent", "BackUpEpisodicMemoryEntity", "BackUpEpisodicTopicMemory", "BackUpLifelog", "BackUpRawMemoryEntityCorrelation", "BackUpMemoryEntityToCalendar", "BackUpMemoryKeyInfoEntity", "BackUpPendingMemoryCalendar", "BackUpRawMemoryEntity", "BackUpRawUserProfileEntity", "EpisodicMemoryHistoryEntity", "EpisodicTopicMemoryHistoryEntity", "LifelogHistoryEntity", "RawUserProfileHistoryEntity", "BackUpProactiveSemanticRelevantData", "BackUpProactiveEpisodicRelevantData", "BackUpUnionSemanticMemory", "BackUpUpdateUnionSemanticMemory", "BackUpUpdateProactiveSemanticRelevantData", "AutoMemoryProHistoryEntity", "AutoMemoryProTextVectorCopilot", "BackUpAutoMemoryProEntity", "BackUpAutoMemoryProSlmPersonalInfo", "BackUpAutoMemoryProSlmEpisodicMemory", "BackUpSlmAutoMemoryProTempResult", "BackUpAgentWatermark", "BackUpSlmAgentWatermark", "BacupMemoryRule", "UnionSemanticTypeSummary", "UnionUserInsight", "UnionUserPersona", "AutoMemoryEpisodicRelevantData", "AutoMemorySemanticRelevantData", "AutoMemoryProRawSource", "MemoryBaseScene", "MemoryBaseRequirement", "MemoryProcessConsumerSubscription", "MemoryProcessSourceEvent", "MemoryProcessTriggerState", "MemoryProcessOperationRecord", "MemoryProcessOutputEvent", "MemoryProcessUserInsight", "AutoMemoryProSnapShot", "UnionSemanticMemorySnapShot", "MemoryReviewFeedback", "MemoryTraceReport", "InAppTraceUpload", "in_app_l1_rule", "InAppTraceObservation", "BackUpAutoMemoryEpisodicRelevantData", "BackUpAutoMemorySemanticRelevantData", "AgentWatermark", "SlmAgentWatermark", "AutoMemoryTrace", "BackUpAutoMemoryProSnapShot", "BackUpUnionSemanticMemorySnapShot", "BackUpMemoryReviewFeedback"});
    }

    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r4) {
        final int r2 = 105;
        RoomOpenHelper r0 = new RoomOpenHelper(r4, new AnonymousClass1(this, r2), "a9dcd4eb6bab7ea931ca3ba30c23f310", "45c57ff6098eb63c5975ab0232c50eb8");
        SupportSQLiteOpenHelper.Configuration r3 = SupportSQLiteOpenHelper.Configuration.builder(r4.context).name(r4.name).callback(r0).build();
        return r4.sqliteOpenHelperFactory.create(r3);
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.dao.a getAgentWatermarkDao$database_obricRelease() {
        if (this._agentWatermarkDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._agentWatermarkDaoOld != null) goto L10;
        this._agentWatermarkDaoOld = new AgentWatermarkDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.dao.a r0 = this._agentWatermarkDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._agentWatermarkDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public AlarmDao getAlarmDao() {
        if (this._alarmDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._alarmDao != null) goto L10;
        this._alarmDao = new AlarmDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        AlarmDao r0 = this._alarmDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._alarmDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public AlarmRawDbDao getAlarmRawDbDao() {
        if (this._alarmRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._alarmRawDbDao != null) goto L10;
        this._alarmRawDbDao = new AlarmRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        AlarmRawDbDao r0 = this._alarmRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._alarmRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public AlarmEntityTextVectorCopilotDao getAlarmTextVectorCopilotDao() {
        if (this._alarmEntityTextVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._alarmEntityTextVectorCopilotDao != null) goto L10;
        this._alarmEntityTextVectorCopilotDao = new AlarmEntityTextVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        AlarmEntityTextVectorCopilotDao r0 = this._alarmEntityTextVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._alarmEntityTextVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public AlbumHistoryEntityDao getAlbumHistoryEntityDao() {
        if (this._albumHistoryEntityDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._albumHistoryEntityDao != null) goto L10;
        this._albumHistoryEntityDao = new AlbumHistoryEntityDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        AlbumHistoryEntityDao r0 = this._albumHistoryEntityDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._albumHistoryEntityDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public AlbumRawDbDao getAlbumRawDbDao() {
        if (this._albumRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._albumRawDbDao != null) goto L10;
        this._albumRawDbDao = new AlbumRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        AlbumRawDbDao r0 = this._albumRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._albumRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public AppActivityDao getAppActivityDao() {
        if (this._appActivityDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._appActivityDao != null) goto L10;
        this._appActivityDao = new AppActivityDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        AppActivityDao r0 = this._appActivityDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._appActivityDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public AppUsageDao getAppUsageDao() {
        if (this._appUsageDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._appUsageDao != null) goto L10;
        this._appUsageDao = new AppUsageDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        AppUsageDao r0 = this._appUsageDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._appUsageDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public ArriveLeaveHomeCompanyEventDao getArriveLeaveHomeCompanyEventDao() {
        if (this._arriveLeaveHomeCompanyEventDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._arriveLeaveHomeCompanyEventDao != null) goto L10;
        this._arriveLeaveHomeCompanyEventDao = new ArriveLeaveHomeCompanyEventDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        ArriveLeaveHomeCompanyEventDao r0 = this._arriveLeaveHomeCompanyEventDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._arriveLeaveHomeCompanyEventDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.dao.b getAssistantChatDao$database_obricRelease() {
        if (this._assistantChatDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._assistantChatDaoOld != null) goto L10;
        this._assistantChatDaoOld = new AssistantChatDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.dao.b r0 = this._assistantChatDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._assistantChatDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.dao.c getAssistantChatMessageDao$database_obricRelease() {
        if (this._assistantChatMessageDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._assistantChatMessageDaoOld != null) goto L10;
        this._assistantChatMessageDaoOld = new AssistantChatMessageDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.dao.c r0 = this._assistantChatMessageDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._assistantChatMessageDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public AuditoryAsrTaskDao getAuditoryAsrTaskDao() {
        if (this._auditoryAsrTaskDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._auditoryAsrTaskDao != null) goto L10;
        this._auditoryAsrTaskDao = new AuditoryAsrTaskDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        AuditoryAsrTaskDao r0 = this._auditoryAsrTaskDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._auditoryAsrTaskDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.entity.r getAuditoryRecordingHistoryEntityDao() {
        if (this._auditoryRecordingHistoryEntityDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._auditoryRecordingHistoryEntityDao != null) goto L10;
        this._auditoryRecordingHistoryEntityDao = new AuditoryRecordingHistoryEntityDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.entity.r r0 = this._auditoryRecordingHistoryEntityDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._auditoryRecordingHistoryEntityDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public AuditoryRecordingRawDbDao getAuditoryRecordingRawDbDao() {
        if (this._auditoryRecordingRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._auditoryRecordingRawDbDao != null) goto L10;
        this._auditoryRecordingRawDbDao = new AuditoryRecordingRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        AuditoryRecordingRawDbDao r0 = this._auditoryRecordingRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._auditoryRecordingRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public AuditoryRecordingTextRawDbDao getAuditoryRecordingTextRawDbDao() {
        if (this._auditoryRecordingTextRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._auditoryRecordingTextRawDbDao != null) goto L10;
        this._auditoryRecordingTextRawDbDao = new AuditoryRecordingTextRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        AuditoryRecordingTextRawDbDao r0 = this._auditoryRecordingTextRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._auditoryRecordingTextRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public AuditoryRecordingTextEntityTextVectorCopilotDao getAuditoryRecordingTextTextVectorCopilotDao() {
        if (this._auditoryRecordingTextEntityTextVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._auditoryRecordingTextEntityTextVectorCopilotDao != null) goto L10;
        this._auditoryRecordingTextEntityTextVectorCopilotDao = new AuditoryRecordingTextEntityTextVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        AuditoryRecordingTextEntityTextVectorCopilotDao r0 = this._auditoryRecordingTextEntityTextVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._auditoryRecordingTextEntityTextVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public AuditoryRecordingEntityTextVectorCopilotDao getAuditoryRecordingTextVectorCopilotDao() {
        if (this._auditoryRecordingEntityTextVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._auditoryRecordingEntityTextVectorCopilotDao != null) goto L10;
        this._auditoryRecordingEntityTextVectorCopilotDao = new AuditoryRecordingEntityTextVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        AuditoryRecordingEntityTextVectorCopilotDao r0 = this._auditoryRecordingEntityTextVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._auditoryRecordingEntityTextVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public AuditorySyncStateDao getAuditorySyncStateDao() {
        if (this._auditorySyncStateDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._auditorySyncStateDao != null) goto L10;
        this._auditorySyncStateDao = new AuditorySyncStateDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        AuditorySyncStateDao r0 = this._auditorySyncStateDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._auditorySyncStateDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.dao.d getAutoMemoryEpisodicRelevantDataDao$database_obricRelease() {
        if (this._autoMemoryEpisodicRelevantDataDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._autoMemoryEpisodicRelevantDataDaoOld != null) goto L10;
        this._autoMemoryEpisodicRelevantDataDaoOld = new AutoMemoryEpisodicRelevantDataDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.dao.d r0 = this._autoMemoryEpisodicRelevantDataDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._autoMemoryEpisodicRelevantDataDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.dao.e getAutoMemoryProDao$database_obricRelease() {
        if (this._autoMemoryProDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._autoMemoryProDaoOld != null) goto L10;
        this._autoMemoryProDaoOld = new AutoMemoryProDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.dao.e r0 = this._autoMemoryProDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._autoMemoryProDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.dao.f getAutoMemoryProEvaluationStatsDao$database_obricRelease() {
        if (this._autoMemoryProEvaluationStatsDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._autoMemoryProEvaluationStatsDaoOld != null) goto L10;
        this._autoMemoryProEvaluationStatsDaoOld = new AutoMemoryProEvaluationStatsDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.dao.f r0 = this._autoMemoryProEvaluationStatsDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._autoMemoryProEvaluationStatsDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.dao.g getAutoMemoryProHistoryRawDbDao$database_obricRelease() {
        if (this._autoMemoryProHistoryRawDbDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._autoMemoryProHistoryRawDbDaoOld != null) goto L10;
        this._autoMemoryProHistoryRawDbDaoOld = new AutoMemoryProHistoryRawDbDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.dao.g r0 = this._autoMemoryProHistoryRawDbDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._autoMemoryProHistoryRawDbDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.dao.h getAutoMemoryProRawSourceDao$database_obricRelease() {
        if (this._autoMemoryProRawSourceDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._autoMemoryProRawSourceDaoOld != null) goto L10;
        this._autoMemoryProRawSourceDaoOld = new AutoMemoryProRawSourceDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.dao.h r0 = this._autoMemoryProRawSourceDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._autoMemoryProRawSourceDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.dao.i getAutoMemoryProSlmEpisodicMemoryDao$database_obricRelease() {
        if (this._autoMemoryProSlmEpisodicMemoryDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._autoMemoryProSlmEpisodicMemoryDaoOld != null) goto L10;
        this._autoMemoryProSlmEpisodicMemoryDaoOld = new AutoMemoryProSlmEpisodicMemoryDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.dao.i r0 = this._autoMemoryProSlmEpisodicMemoryDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._autoMemoryProSlmEpisodicMemoryDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.dao.j getAutoMemoryProSlmPersonalInfoDao$database_obricRelease() {
        if (this._autoMemoryProSlmPersonalInfoDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._autoMemoryProSlmPersonalInfoDaoOld != null) goto L10;
        this._autoMemoryProSlmPersonalInfoDaoOld = new AutoMemoryProSlmPersonalInfoDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.dao.j r0 = this._autoMemoryProSlmPersonalInfoDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._autoMemoryProSlmPersonalInfoDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.dao.k getAutoMemoryProSnapShotDao$database_obricRelease() {
        if (this._autoMemoryProSnapShotDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._autoMemoryProSnapShotDaoOld != null) goto L10;
        this._autoMemoryProSnapShotDaoOld = new AutoMemoryProSnapShotDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.dao.k r0 = this._autoMemoryProSnapShotDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._autoMemoryProSnapShotDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.dao.l getAutoMemoryProTextVectorCopilotDao$database_obricRelease() {
        if (this._autoMemoryProTextEntityTextVectorCopilotDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._autoMemoryProTextEntityTextVectorCopilotDaoOld != null) goto L10;
        this._autoMemoryProTextEntityTextVectorCopilotDaoOld = new AutoMemoryProTextEntityTextVectorCopilotDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.dao.l r0 = this._autoMemoryProTextEntityTextVectorCopilotDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._autoMemoryProTextEntityTextVectorCopilotDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.dao.m getAutoMemorySemanticRelevantDataDao$database_obricRelease() {
        if (this._autoMemorySemanticRelevantDataDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._autoMemorySemanticRelevantDataDaoOld != null) goto L10;
        this._autoMemorySemanticRelevantDataDaoOld = new AutoMemorySemanticRelevantDataDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.dao.m r0 = this._autoMemorySemanticRelevantDataDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._autoMemorySemanticRelevantDataDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public AutoMemoryProTraceDao getAutoMemoryTraceDao() {
        if (this._autoMemoryProTraceDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._autoMemoryProTraceDao != null) goto L10;
        this._autoMemoryProTraceDao = new AutoMemoryProTraceDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        AutoMemoryProTraceDao r0 = this._autoMemoryProTraceDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._autoMemoryProTraceDao;
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> r2) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        return Arrays.asList(new Migration[]{new MemoryFrameDb_AutoMigration_16_17_Impl(), new MemoryFrameDb_AutoMigration_17_18_Impl(), new MemoryFrameDb_AutoMigration_18_19_Impl(), new MemoryFrameDb_AutoMigration_20_21_Impl(), new MemoryFrameDb_AutoMigration_22_23_Impl(), new MemoryFrameDb_AutoMigration_23_24_Impl(), new MemoryFrameDb_AutoMigration_24_25_Impl(), new MemoryFrameDb_AutoMigration_25_26_Impl(), new MemoryFrameDb_AutoMigration_26_27_Impl(), new MemoryFrameDb_AutoMigration_27_28_Impl(), new MemoryFrameDb_AutoMigration_28_29_Impl(), new MemoryFrameDb_AutoMigration_29_30_Impl(), new MemoryFrameDb_AutoMigration_30_31_Impl(), new MemoryFrameDb_AutoMigration_31_32_Impl(), new MemoryFrameDb_AutoMigration_32_33_Impl(), new MemoryFrameDb_AutoMigration_34_35_Impl(), new MemoryFrameDb_AutoMigration_35_36_Impl(), new MemoryFrameDb_AutoMigration_36_37_Impl(), new MemoryFrameDb_AutoMigration_38_39_Impl(), new MemoryFrameDb_AutoMigration_40_41_Impl(), new MemoryFrameDb_AutoMigration_41_42_Impl(), new MemoryFrameDb_AutoMigration_44_45_Impl(), new MemoryFrameDb_AutoMigration_45_46_Impl(), new MemoryFrameDb_AutoMigration_46_47_Impl(), new MemoryFrameDb_AutoMigration_47_48_Impl(), new MemoryFrameDb_AutoMigration_48_49_Impl(), new MemoryFrameDb_AutoMigration_49_50_Impl(), new MemoryFrameDb_AutoMigration_50_51_Impl(), new MemoryFrameDb_AutoMigration_52_53_Impl(), new MemoryFrameDb_AutoMigration_53_54_Impl(), new MemoryFrameDb_AutoMigration_55_56_Impl(), new MemoryFrameDb_AutoMigration_57_58_Impl(), new MemoryFrameDb_AutoMigration_58_59_Impl(), new MemoryFrameDb_AutoMigration_59_60_Impl(), new MemoryFrameDb_AutoMigration_60_61_Impl(), new MemoryFrameDb_AutoMigration_62_63_Impl(), new MemoryFrameDb_AutoMigration_63_64_Impl(), new MemoryFrameDb_AutoMigration_64_65_Impl(), new MemoryFrameDb_AutoMigration_65_66_Impl(), new MemoryFrameDb_AutoMigration_66_67_Impl(), new MemoryFrameDb_AutoMigration_68_69_Impl(), new MemoryFrameDb_AutoMigration_69_70_Impl(), new MemoryFrameDb_AutoMigration_70_71_Impl(), new MemoryFrameDb_AutoMigration_72_73_Impl(), new MemoryFrameDb_AutoMigration_73_74_Impl(), new MemoryFrameDb_AutoMigration_74_75_Impl(), new MemoryFrameDb_AutoMigration_75_76_Impl(), new MemoryFrameDb_AutoMigration_76_77_Impl(), new MemoryFrameDb_AutoMigration_78_79_Impl(), new MemoryFrameDb_AutoMigration_79_80_Impl(), new MemoryFrameDb_AutoMigration_81_82_Impl(), new MemoryFrameDb_AutoMigration_82_83_Impl(), new MemoryFrameDb_AutoMigration_83_84_Impl(), new MemoryFrameDb_AutoMigration_84_85_Impl(), new MemoryFrameDb_AutoMigration_86_87_Impl(), new MemoryFrameDb_AutoMigration_87_88_Impl(), new MemoryFrameDb_AutoMigration_88_89_Impl(), new MemoryFrameDb_AutoMigration_90_91_Impl(), new MemoryFrameDb_AutoMigration_91_92_Impl(), new MemoryFrameDb_AutoMigration_92_93_Impl(), new MemoryFrameDb_AutoMigration_93_94_Impl(), new MemoryFrameDb_AutoMigration_94_95_Impl(), new MemoryFrameDb_AutoMigration_95_96_Impl(), new MemoryFrameDb_AutoMigration_96_97_Impl(), new MemoryFrameDb_AutoMigration_97_98_Impl(), new MemoryFrameDb_AutoMigration_98_99_Impl(), new MemoryFrameDb_AutoMigration_99_100_Impl(), new MemoryFrameDb_AutoMigration_100_101_Impl(), new MemoryFrameDb_AutoMigration_101_102_Impl(), new MemoryFrameDb_AutoMigration_102_103_Impl(), new MemoryFrameDb_AutoMigration_103_104_Impl()});
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public AwarenessInfoDao getAwarenessInfoDao() {
        if (this._awarenessInfoDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._awarenessInfoDao != null) goto L10;
        this._awarenessInfoDao = new AwarenessInfoDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        AwarenessInfoDao r0 = this._awarenessInfoDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._awarenessInfoDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.backup.dao.a getBackUpAgentWatermarkDao$database_obricRelease() {
        if (this._backUpAgentWatermarkDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._backUpAgentWatermarkDaoOld != null) goto L10;
        this._backUpAgentWatermarkDaoOld = new BackUpAgentWatermarkDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.backup.dao.a r0 = this._backUpAgentWatermarkDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._backUpAgentWatermarkDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.backup.dao.b getBackUpAutoMemoryEpisodicRelevantDataDao$database_obricRelease() {
        if (this._backUpAutoMemoryEpisodicRelevantDataDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._backUpAutoMemoryEpisodicRelevantDataDaoOld != null) goto L10;
        this._backUpAutoMemoryEpisodicRelevantDataDaoOld = new BackUpAutoMemoryEpisodicRelevantDataDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.backup.dao.b r0 = this._backUpAutoMemoryEpisodicRelevantDataDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._backUpAutoMemoryEpisodicRelevantDataDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.backup.dao.d getBackUpAutoMemoryProSlmEpisodicMemoryDao$database_obricRelease() {
        if (this._backUpAutoMemoryProSlmEpisodicMemoryDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._backUpAutoMemoryProSlmEpisodicMemoryDaoOld != null) goto L10;
        this._backUpAutoMemoryProSlmEpisodicMemoryDaoOld = new BackUpAutoMemoryProSlmEpisodicMemoryDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.backup.dao.d r0 = this._backUpAutoMemoryProSlmEpisodicMemoryDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._backUpAutoMemoryProSlmEpisodicMemoryDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.backup.dao.e getBackUpAutoMemoryProSlmPersonalInfoDao$database_obricRelease() {
        if (this._backUpAutoMemoryProSlmPersonalInfoDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._backUpAutoMemoryProSlmPersonalInfoDaoOld != null) goto L10;
        this._backUpAutoMemoryProSlmPersonalInfoDaoOld = new BackUpAutoMemoryProSlmPersonalInfoDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.backup.dao.e r0 = this._backUpAutoMemoryProSlmPersonalInfoDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._backUpAutoMemoryProSlmPersonalInfoDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.backup.dao.a getBackUpAutoMemoryProSnapShotDao$database_obricRelease() {
        if (this._backUpAutoMemoryProSnapShotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._backUpAutoMemoryProSnapShotDao != null) goto L10;
        this._backUpAutoMemoryProSnapShotDao = new BackUpAutoMemoryProSnapShotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.backup.dao.a r0 = this._backUpAutoMemoryProSnapShotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._backUpAutoMemoryProSnapShotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.backup.dao.f getBackUpAutoMemorySemanticRelevantDataDao$database_obricRelease() {
        if (this._backUpAutoMemorySemanticRelevantDataDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._backUpAutoMemorySemanticRelevantDataDaoOld != null) goto L10;
        this._backUpAutoMemorySemanticRelevantDataDaoOld = new BackUpAutoMemorySemanticRelevantDataDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.backup.dao.f r0 = this._backUpAutoMemorySemanticRelevantDataDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._backUpAutoMemorySemanticRelevantDataDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.backup.dao.g getBackUpBlockMemoryContentDao$database_obricRelease() {
        if (this._backUpBlockMemoryContentDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._backUpBlockMemoryContentDaoOld != null) goto L10;
        this._backUpBlockMemoryContentDaoOld = new BackUpBlockMemoryContentDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.backup.dao.g r0 = this._backUpBlockMemoryContentDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._backUpBlockMemoryContentDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.backup.dao.h getBackUpEpisodicMemoryDao$database_obricRelease() {
        if (this._backUpEpisodicMemoryDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._backUpEpisodicMemoryDaoOld != null) goto L10;
        this._backUpEpisodicMemoryDaoOld = new BackUpEpisodicMemoryDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.backup.dao.h r0 = this._backUpEpisodicMemoryDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._backUpEpisodicMemoryDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.backup.dao.i getBackUpEpisodicTopicMemoryDao$database_obricRelease() {
        if (this._backUpEpisodicTopicMemoryDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._backUpEpisodicTopicMemoryDaoOld != null) goto L10;
        this._backUpEpisodicTopicMemoryDaoOld = new BackUpEpisodicTopicMemoryDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.backup.dao.i r0 = this._backUpEpisodicTopicMemoryDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._backUpEpisodicTopicMemoryDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.backup.dao.j getBackUpLifelogDao$database_obricRelease() {
        if (this._backUpLifelogDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._backUpLifelogDaoOld != null) goto L10;
        this._backUpLifelogDaoOld = new BackUpLifelogDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.backup.dao.j r0 = this._backUpLifelogDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._backUpLifelogDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.backup.dao.k getBackUpMemoryEntityCorrelationDao$database_obricRelease() {
        if (this._backUpMemoryEntityCorrelationDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._backUpMemoryEntityCorrelationDaoOld != null) goto L10;
        this._backUpMemoryEntityCorrelationDaoOld = new BackUpMemoryEntityCorrelationDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.backup.dao.k r0 = this._backUpMemoryEntityCorrelationDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._backUpMemoryEntityCorrelationDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.backup.dao.l getBackUpMemoryEntityToCalendarDao$database_obricRelease() {
        if (this._backUpMemoryEntityToCalendarDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._backUpMemoryEntityToCalendarDaoOld != null) goto L10;
        this._backUpMemoryEntityToCalendarDaoOld = new BackUpMemoryEntityToCalendarDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.backup.dao.l r0 = this._backUpMemoryEntityToCalendarDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._backUpMemoryEntityToCalendarDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.backup.dao.m getBackUpMemoryKeyInfoDao$database_obricRelease() {
        if (this._backUpMemoryKeyInfoDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._backUpMemoryKeyInfoDaoOld != null) goto L10;
        this._backUpMemoryKeyInfoDaoOld = new BackUpMemoryKeyInfoDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.backup.dao.m r0 = this._backUpMemoryKeyInfoDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._backUpMemoryKeyInfoDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.backup.dao.b getBackUpMemoryReviewFeedbackDao$database_obricRelease() {
        if (this._backUpMemoryReviewFeedbackDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._backUpMemoryReviewFeedbackDao != null) goto L10;
        this._backUpMemoryReviewFeedbackDao = new BackUpMemoryReviewFeedbackDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.backup.dao.b r0 = this._backUpMemoryReviewFeedbackDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._backUpMemoryReviewFeedbackDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.backup.dao.n getBackUpMemoryRuleDao$database_obricRelease() {
        if (this._backUpMemoryRuleDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._backUpMemoryRuleDaoOld != null) goto L10;
        this._backUpMemoryRuleDaoOld = new BackUpMemoryRuleDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.backup.dao.n r0 = this._backUpMemoryRuleDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._backUpMemoryRuleDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.backup.dao.o getBackUpPendingMemoryCalendarDao$database_obricRelease() {
        if (this._backUpPendingMemoryCalendarDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._backUpPendingMemoryCalendarDaoOld != null) goto L10;
        this._backUpPendingMemoryCalendarDaoOld = new BackUpPendingMemoryCalendarDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.backup.dao.o r0 = this._backUpPendingMemoryCalendarDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._backUpPendingMemoryCalendarDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.backup.dao.p getBackUpProactiveEpisodicRelevantDataDao$database_obricRelease() {
        if (this._backUpProactiveEpisodicRelevantDataDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._backUpProactiveEpisodicRelevantDataDaoOld != null) goto L10;
        this._backUpProactiveEpisodicRelevantDataDaoOld = new BackUpProactiveEpisodicRelevantDataDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.backup.dao.p r0 = this._backUpProactiveEpisodicRelevantDataDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._backUpProactiveEpisodicRelevantDataDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.backup.dao.q getBackUpProactiveSemanticRelevantDataDao$database_obricRelease() {
        if (this._backUpProactiveSemanticRelevantDataDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._backUpProactiveSemanticRelevantDataDaoOld != null) goto L10;
        this._backUpProactiveSemanticRelevantDataDaoOld = new BackUpProactiveSemanticRelevantDataDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.backup.dao.q r0 = this._backUpProactiveSemanticRelevantDataDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._backUpProactiveSemanticRelevantDataDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.backup.dao.c getBackUpRawMemoryDao() {
        if (this._backUpRawMemoryDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._backUpRawMemoryDao != null) goto L10;
        this._backUpRawMemoryDao = new BackUpRawMemoryDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.backup.dao.c r0 = this._backUpRawMemoryDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._backUpRawMemoryDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.backup.dao.r getBackUpRawUserProfileDao$database_obricRelease() {
        if (this._backUpRawUserProfileDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._backUpRawUserProfileDaoOld != null) goto L10;
        this._backUpRawUserProfileDaoOld = new BackUpRawUserProfileDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.backup.dao.r r0 = this._backUpRawUserProfileDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._backUpRawUserProfileDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.backup.dao.s getBackUpSlmAgentWatermarkDao$database_obricRelease() {
        if (this._backUpSlmAgentWatermarkDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._backUpSlmAgentWatermarkDaoOld != null) goto L10;
        this._backUpSlmAgentWatermarkDaoOld = new BackUpSlmAgentWatermarkDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.backup.dao.s r0 = this._backUpSlmAgentWatermarkDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._backUpSlmAgentWatermarkDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.backup.dao.t getBackUpSlmAutoMemoryProTempResultDao$database_obricRelease() {
        if (this._backUpSlmAutoMemoryProTempResultDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._backUpSlmAutoMemoryProTempResultDaoOld != null) goto L10;
        this._backUpSlmAutoMemoryProTempResultDaoOld = new BackUpSlmAutoMemoryProTempResultDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.backup.dao.t r0 = this._backUpSlmAutoMemoryProTempResultDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._backUpSlmAutoMemoryProTempResultDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.backup.dao.u getBackUpUnionSemanticMemoryDao$database_obricRelease() {
        if (this._backUpUnionSemanticMemoryDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._backUpUnionSemanticMemoryDaoOld != null) goto L10;
        this._backUpUnionSemanticMemoryDaoOld = new BackUpUnionSemanticMemoryDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.backup.dao.u r0 = this._backUpUnionSemanticMemoryDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._backUpUnionSemanticMemoryDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.backup.dao.d getBackUpUnionSemanticMemorySnapShotDao$database_obricRelease() {
        if (this._backUpUnionSemanticMemorySnapShotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._backUpUnionSemanticMemorySnapShotDao != null) goto L10;
        this._backUpUnionSemanticMemorySnapShotDao = new BackUpUnionSemanticMemorySnapShotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.backup.dao.d r0 = this._backUpUnionSemanticMemorySnapShotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._backUpUnionSemanticMemorySnapShotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.backup.dao.v getBackUpUpdateProactiveSemanticRelevantDataDao$database_obricRelease() {
        if (this._backUpUpdateProactiveSemanticRelevantDataDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._backUpUpdateProactiveSemanticRelevantDataDaoOld != null) goto L10;
        this._backUpUpdateProactiveSemanticRelevantDataDaoOld = new BackUpUpdateProactiveSemanticRelevantDataDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.backup.dao.v r0 = this._backUpUpdateProactiveSemanticRelevantDataDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._backUpUpdateProactiveSemanticRelevantDataDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.backup.dao.w getBackUpUpdateUnionSemanticMemoryDao$database_obricRelease() {
        if (this._backUpUpdateUnionSemanticMemoryDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._backUpUpdateUnionSemanticMemoryDaoOld != null) goto L10;
        this._backUpUpdateUnionSemanticMemoryDaoOld = new BackUpUpdateUnionSemanticMemoryDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.backup.dao.w r0 = this._backUpUpdateUnionSemanticMemoryDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._backUpUpdateUnionSemanticMemoryDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.backup.dao.c getBackupAutoMemoryProDao$database_obricRelease() {
        if (this._backUpAutoMemoryProEntityDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._backUpAutoMemoryProEntityDaoOld != null) goto L10;
        this._backUpAutoMemoryProEntityDaoOld = new BackUpAutoMemoryProEntityDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.backup.dao.c r0 = this._backUpAutoMemoryProEntityDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._backUpAutoMemoryProEntityDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public BatchChatDao getBatchChatDao() {
        if (this._batchChatDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._batchChatDao != null) goto L10;
        this._batchChatDao = new BatchChatDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        BatchChatDao r0 = this._batchChatDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._batchChatDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public BatteryStateDao getBatteryStateDao() {
        if (this._batteryStateDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._batteryStateDao != null) goto L10;
        this._batteryStateDao = new BatteryStateDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        BatteryStateDao r0 = this._batteryStateDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._batteryStateDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.dao.n getBlockMemoryContentDao$database_obricRelease() {
        if (this._blockMemoryContentDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._blockMemoryContentDaoOld != null) goto L10;
        this._blockMemoryContentDaoOld = new BlockMemoryContentDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.dao.n r0 = this._blockMemoryContentDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._blockMemoryContentDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public BluetoothDeviceDao getBluetoothDeviceDao() {
        if (this._bluetoothDeviceDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._bluetoothDeviceDao != null) goto L10;
        this._bluetoothDeviceDao = new BluetoothDeviceDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        BluetoothDeviceDao r0 = this._bluetoothDeviceDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._bluetoothDeviceDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public BrowserBookmarkHistoryEntityDao getBrowserBookmarkHistoryEntityDao() {
        if (this._browserBookmarkHistoryEntityDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._browserBookmarkHistoryEntityDao != null) goto L10;
        this._browserBookmarkHistoryEntityDao = new BrowserBookmarkHistoryEntityDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        BrowserBookmarkHistoryEntityDao r0 = this._browserBookmarkHistoryEntityDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._browserBookmarkHistoryEntityDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public BrowserBookmarkRawDbDao getBrowserBookmarkRawDbDao() {
        if (this._browserBookmarkRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._browserBookmarkRawDbDao != null) goto L10;
        this._browserBookmarkRawDbDao = new BrowserBookmarkRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        BrowserBookmarkRawDbDao r0 = this._browserBookmarkRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._browserBookmarkRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public BssidCalcCacheDao getBssidCalcCacheDao() {
        if (this._bssidCalcCacheDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._bssidCalcCacheDao != null) goto L10;
        this._bssidCalcCacheDao = new BssidCalcCacheDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        BssidCalcCacheDao r0 = this._bssidCalcCacheDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._bssidCalcCacheDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public CallHistoryEntityContentTimeDao getCallHistoryEntityContentTimeDao() {
        if (this._callHistoryEntityContentTimeDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._callHistoryEntityContentTimeDao != null) goto L10;
        this._callHistoryEntityContentTimeDao = new CallHistoryEntityContentTimeDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        CallHistoryEntityContentTimeDao r0 = this._callHistoryEntityContentTimeDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._callHistoryEntityContentTimeDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public CallHistoryHistoryEntityDao getCallHistoryHistoryEntityDao() {
        if (this._callHistoryHistoryEntityDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._callHistoryHistoryEntityDao != null) goto L10;
        this._callHistoryHistoryEntityDao = new CallHistoryHistoryEntityDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        CallHistoryHistoryEntityDao r0 = this._callHistoryHistoryEntityDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._callHistoryHistoryEntityDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public CallHistoryRawDbDao getCallHistoryRawDbDao() {
        if (this._callHistoryRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._callHistoryRawDbDao != null) goto L10;
        this._callHistoryRawDbDao = new CallHistoryRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        CallHistoryRawDbDao r0 = this._callHistoryRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._callHistoryRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public CallHistoryEntityTextVectorCopilotDao getCallHistoryTextVectorCopilotDao() {
        if (this._callHistoryEntityTextVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._callHistoryEntityTextVectorCopilotDao != null) goto L10;
        this._callHistoryEntityTextVectorCopilotDao = new CallHistoryEntityTextVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        CallHistoryEntityTextVectorCopilotDao r0 = this._callHistoryEntityTextVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._callHistoryEntityTextVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public CellInfoDao getCellInfoDao() {
        if (this._cellInfoDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._cellInfoDao != null) goto L10;
        this._cellInfoDao = new CellInfoDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        CellInfoDao r0 = this._cellInfoDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._cellInfoDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public CommonPhotoEntityImageVectorCopilotDao getCommonPhotoImageVectorCopilotDao() {
        if (this._commonPhotoEntityImageVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._commonPhotoEntityImageVectorCopilotDao != null) goto L10;
        this._commonPhotoEntityImageVectorCopilotDao = new CommonPhotoEntityImageVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        CommonPhotoEntityImageVectorCopilotDao r0 = this._commonPhotoEntityImageVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._commonPhotoEntityImageVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public CommonPhotoRawDbDao getCommonPhotoRawDbDao() {
        if (this._commonPhotoRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._commonPhotoRawDbDao != null) goto L10;
        this._commonPhotoRawDbDao = new CommonPhotoRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        CommonPhotoRawDbDao r0 = this._commonPhotoRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._commonPhotoRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public CommonPhotoEntityTextVectorCopilotDao getCommonPhotoTextVectorCopilotDao() {
        if (this._commonPhotoEntityTextVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._commonPhotoEntityTextVectorCopilotDao != null) goto L10;
        this._commonPhotoEntityTextVectorCopilotDao = new CommonPhotoEntityTextVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        CommonPhotoEntityTextVectorCopilotDao r0 = this._commonPhotoEntityTextVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._commonPhotoEntityTextVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public CommonVideoFrameEntityImageVectorCopilotDao getCommonVideoFrameImageVectorCopilotDao() {
        if (this._commonVideoFrameEntityImageVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._commonVideoFrameEntityImageVectorCopilotDao != null) goto L10;
        this._commonVideoFrameEntityImageVectorCopilotDao = new CommonVideoFrameEntityImageVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        CommonVideoFrameEntityImageVectorCopilotDao r0 = this._commonVideoFrameEntityImageVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._commonVideoFrameEntityImageVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public CommonVideoFrameRawDbDao getCommonVideoFrameRawDbDao() {
        if (this._commonVideoFrameRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._commonVideoFrameRawDbDao != null) goto L10;
        this._commonVideoFrameRawDbDao = new CommonVideoFrameRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        CommonVideoFrameRawDbDao r0 = this._commonVideoFrameRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._commonVideoFrameRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public CommonVideoFrameEntityTextVectorCopilotDao getCommonVideoFrameTextVectorCopilotDao() {
        if (this._commonVideoFrameEntityTextVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._commonVideoFrameEntityTextVectorCopilotDao != null) goto L10;
        this._commonVideoFrameEntityTextVectorCopilotDao = new CommonVideoFrameEntityTextVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        CommonVideoFrameEntityTextVectorCopilotDao r0 = this._commonVideoFrameEntityTextVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._commonVideoFrameEntityTextVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.dao.o getComplexRecommendQueryDao$database_obricRelease() {
        if (this._complexRecommendQueryDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._complexRecommendQueryDaoOld != null) goto L10;
        this._complexRecommendQueryDaoOld = new ComplexRecommendQueryDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.dao.o r0 = this._complexRecommendQueryDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._complexRecommendQueryDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public ContactEntityImageVectorCopilotDao getContactImageVectorCopilotDao() {
        if (this._contactEntityImageVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._contactEntityImageVectorCopilotDao != null) goto L10;
        this._contactEntityImageVectorCopilotDao = new ContactEntityImageVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        ContactEntityImageVectorCopilotDao r0 = this._contactEntityImageVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._contactEntityImageVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public ContactRawDbDao getContactRawDbDao() {
        if (this._contactRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._contactRawDbDao != null) goto L10;
        this._contactRawDbDao = new ContactRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        ContactRawDbDao r0 = this._contactRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._contactRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public ContactHistoryEntityDao getContactRawHistoryDbDao() {
        if (this._contactHistoryEntityDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._contactHistoryEntityDao != null) goto L10;
        this._contactHistoryEntityDao = new ContactHistoryEntityDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        ContactHistoryEntityDao r0 = this._contactHistoryEntityDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._contactHistoryEntityDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public ContactEntityTextVectorCopilotDao getContactTextVectorCopilotDao() {
        if (this._contactEntityTextVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._contactEntityTextVectorCopilotDao != null) goto L10;
        this._contactEntityTextVectorCopilotDao = new ContactEntityTextVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        ContactEntityTextVectorCopilotDao r0 = this._contactEntityTextVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._contactEntityTextVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public CountdownRawDbDao getCountdownRawDbDao() {
        if (this._countdownRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._countdownRawDbDao != null) goto L10;
        this._countdownRawDbDao = new CountdownRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        CountdownRawDbDao r0 = this._countdownRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._countdownRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public CountdownEntityTextVectorCopilotDao getCountdownTextVectorCopilotDao() {
        if (this._countdownEntityTextVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._countdownEntityTextVectorCopilotDao != null) goto L10;
        this._countdownEntityTextVectorCopilotDao = new CountdownEntityTextVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        CountdownEntityTextVectorCopilotDao r0 = this._countdownEntityTextVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._countdownEntityTextVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public DataBuildMemoryStatusDao getDataBuildMemoryStatusDao() {
        if (this._dataBuildMemoryStatusDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._dataBuildMemoryStatusDao != null) goto L10;
        this._dataBuildMemoryStatusDao = new DataBuildMemoryStatusDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        DataBuildMemoryStatusDao r0 = this._dataBuildMemoryStatusDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._dataBuildMemoryStatusDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public DeviceBootDao getDeviceBootDao() {
        if (this._deviceBootDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._deviceBootDao != null) goto L10;
        this._deviceBootDao = new DeviceBootDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        DeviceBootDao r0 = this._deviceBootDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._deviceBootDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public DeviceShutdownDao getDeviceShutdownDao() {
        if (this._deviceShutdownDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._deviceShutdownDao != null) goto L10;
        this._deviceShutdownDao = new DeviceShutdownDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        DeviceShutdownDao r0 = this._deviceShutdownDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._deviceShutdownDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public DoubaoAccountEntityRawDbDao getDoubaoAccountEntityRawDbDao() {
        if (this._doubaoAccountEntityRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._doubaoAccountEntityRawDbDao != null) goto L10;
        this._doubaoAccountEntityRawDbDao = new DoubaoAccountEntityRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        DoubaoAccountEntityRawDbDao r0 = this._doubaoAccountEntityRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._doubaoAccountEntityRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public ElementKGIndexPendingDao getElementKGIndexPendingDao() {
        if (this._elementKGIndexPendingDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._elementKGIndexPendingDao != null) goto L10;
        this._elementKGIndexPendingDao = new ElementKGIndexPendingDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        ElementKGIndexPendingDao r0 = this._elementKGIndexPendingDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._elementKGIndexPendingDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public EmbeddingVectorCacheDao getEmbeddingVectorCacheDao() {
        if (this._embeddingVectorCacheDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._embeddingVectorCacheDao != null) goto L10;
        this._embeddingVectorCacheDao = new EmbeddingVectorCacheDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        EmbeddingVectorCacheDao r0 = this._embeddingVectorCacheDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._embeddingVectorCacheDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public EntityIndexLifecycleDao getEntityIndexLifecycleDao() {
        if (this._entityIndexLifecycleDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._entityIndexLifecycleDao != null) goto L10;
        this._entityIndexLifecycleDao = new EntityIndexLifecycleDao_MemoryFrameDb_Impl(this);     // Catch: Throwable -> L13
    L10:
        EntityIndexLifecycleDao r0 = this._entityIndexLifecycleDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._entityIndexLifecycleDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.dao.p getEpisodicMemoryContentTimeDao$database_obricRelease() {
        if (this._episodicMemoryContentTimeDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._episodicMemoryContentTimeDaoOld != null) goto L10;
        this._episodicMemoryContentTimeDaoOld = new EpisodicMemoryContentTimeDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.dao.p r0 = this._episodicMemoryContentTimeDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._episodicMemoryContentTimeDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.dao.q getEpisodicMemoryDao$database_obricRelease() {
        if (this._episodicMemoryDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._episodicMemoryDaoOld != null) goto L10;
        this._episodicMemoryDaoOld = new EpisodicMemoryDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.dao.q r0 = this._episodicMemoryDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._episodicMemoryDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.dao.r getEpisodicMemoryHistoryRawDbDao$database_obricRelease() {
        if (this._episodicMemoryHistoryRawDbDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._episodicMemoryHistoryRawDbDaoOld != null) goto L10;
        this._episodicMemoryHistoryRawDbDaoOld = new EpisodicMemoryHistoryRawDbDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.dao.r r0 = this._episodicMemoryHistoryRawDbDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._episodicMemoryHistoryRawDbDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.dao.s getEpisodicMemoryTextVectorCopilotDao$database_obricRelease() {
        if (this._episodicMemoryTextVectorCopilotDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._episodicMemoryTextVectorCopilotDaoOld != null) goto L10;
        this._episodicMemoryTextVectorCopilotDaoOld = new EpisodicMemoryTextVectorCopilotDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.dao.s r0 = this._episodicMemoryTextVectorCopilotDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._episodicMemoryTextVectorCopilotDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.dao.t getEpisodicTopicMemoryDao$database_obricRelease() {
        if (this._episodicTopicMemoryDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._episodicTopicMemoryDaoOld != null) goto L10;
        this._episodicTopicMemoryDaoOld = new EpisodicTopicMemoryDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.dao.t r0 = this._episodicTopicMemoryDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._episodicTopicMemoryDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.dao.u getEpisodicTopicMemoryHistoryRawDbDao$database_obricRelease() {
        if (this._episodicTopicMemoryHistoryRawDbDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._episodicTopicMemoryHistoryRawDbDaoOld != null) goto L10;
        this._episodicTopicMemoryHistoryRawDbDaoOld = new EpisodicTopicMemoryHistoryRawDbDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.dao.u r0 = this._episodicTopicMemoryHistoryRawDbDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._episodicTopicMemoryHistoryRawDbDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.dao.v getEpisodicTopicMemoryTextVectorCopilotDao$database_obricRelease() {
        if (this._episodicTopicMemoryTextVectorCopilotDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._episodicTopicMemoryTextVectorCopilotDaoOld != null) goto L10;
        this._episodicTopicMemoryTextVectorCopilotDaoOld = new EpisodicTopicMemoryTextVectorCopilotDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.dao.v r0 = this._episodicTopicMemoryTextVectorCopilotDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._episodicTopicMemoryTextVectorCopilotDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public EvaluationSourceDataDao getEvaluationSourceDataDao() {
        if (this._evaluationSourceDataDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._evaluationSourceDataDao != null) goto L10;
        this._evaluationSourceDataDao = new EvaluationSourceDataDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        EvaluationSourceDataDao r0 = this._evaluationSourceDataDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._evaluationSourceDataDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public FileRawDbDao getFileRawDbDao() {
        if (this._fileRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._fileRawDbDao != null) goto L10;
        this._fileRawDbDao = new FileRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        FileRawDbDao r0 = this._fileRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._fileRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public FileHistoryEntityDao getFileRawHistoryDbDao() {
        if (this._fileHistoryEntityDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._fileHistoryEntityDao != null) goto L10;
        this._fileHistoryEntityDao = new FileHistoryEntityDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        FileHistoryEntityDao r0 = this._fileHistoryEntityDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._fileHistoryEntityDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public FileTextRawDbDao getFileTextRawDbDao() {
        if (this._fileTextRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._fileTextRawDbDao != null) goto L10;
        this._fileTextRawDbDao = new FileTextRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        FileTextRawDbDao r0 = this._fileTextRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._fileTextRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public FileTextEntityTextVectorCopilotDao getFileTextTextVectorCopilotDao() {
        if (this._fileTextEntityTextVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._fileTextEntityTextVectorCopilotDao != null) goto L10;
        this._fileTextEntityTextVectorCopilotDao = new FileTextEntityTextVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        FileTextEntityTextVectorCopilotDao r0 = this._fileTextEntityTextVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._fileTextEntityTextVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public FileEntityTextVectorCopilotDao getFileTextVectorCopilotDao() {
        if (this._fileEntityTextVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._fileEntityTextVectorCopilotDao != null) goto L10;
        this._fileEntityTextVectorCopilotDao = new FileEntityTextVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        FileEntityTextVectorCopilotDao r0 = this._fileEntityTextVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._fileEntityTextVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public GeographyDao getGeographyDao() {
        if (this._geographyDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._geographyDao != null) goto L10;
        this._geographyDao = new GeographyDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        GeographyDao r0 = this._geographyDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._geographyDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public GlassesSyncStateDao getGlassesSyncStateDao() {
        if (this._glassesSyncStateDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._glassesSyncStateDao != null) goto L10;
        this._glassesSyncStateDao = new GlassesSyncStateDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        GlassesSyncStateDao r0 = this._glassesSyncStateDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._glassesSyncStateDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public HarStateDao getHarStateDao() {
        if (this._harStateDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._harStateDao != null) goto L10;
        this._harStateDao = new HarStateDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        HarStateDao r0 = this._harStateDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._harStateDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public ICSProtocolHistoryEntityDao getIcsProtocolHistoryRawDbDao() {
        if (this._iCSProtocolHistoryEntityDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._iCSProtocolHistoryEntityDao != null) goto L10;
        this._iCSProtocolHistoryEntityDao = new ICSProtocolHistoryEntityDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        ICSProtocolHistoryEntityDao r0 = this._iCSProtocolHistoryEntityDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._iCSProtocolHistoryEntityDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public ICSProtocolEntityRawDbDao getIcsProtocolRawDbDao() {
        if (this._iCSProtocolEntityRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._iCSProtocolEntityRawDbDao != null) goto L10;
        this._iCSProtocolEntityRawDbDao = new ICSProtocolEntityRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        ICSProtocolEntityRawDbDao r0 = this._iCSProtocolEntityRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._iCSProtocolEntityRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public InAppL1RuleDao getInAppL1RuleDao() {
        if (this._inAppL1RuleDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._inAppL1RuleDao != null) goto L10;
        this._inAppL1RuleDao = new InAppL1RuleDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        InAppL1RuleDao r0 = this._inAppL1RuleDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._inAppL1RuleDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public InAppTraceUploadDao getInAppTraceUploadDao() {
        if (this._inAppTraceUploadDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._inAppTraceUploadDao != null) goto L10;
        this._inAppTraceUploadDao = new InAppTraceUploadDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        InAppTraceUploadDao r0 = this._inAppTraceUploadDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._inAppTraceUploadDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public IndexPendingDao getIndexPendingDao() {
        if (this._indexPendingDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._indexPendingDao != null) goto L10;
        this._indexPendingDao = new IndexPendingDao_MemoryFrameDb_Impl(this);     // Catch: Throwable -> L13
    L10:
        IndexPendingDao r0 = this._indexPendingDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._indexPendingDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public LanguageChangeEventDao getLanguageChangeEventDao() {
        if (this._languageChangeEventDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._languageChangeEventDao != null) goto L10;
        this._languageChangeEventDao = new LanguageChangeEventDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        LanguageChangeEventDao r0 = this._languageChangeEventDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._languageChangeEventDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public com.obric.memorydata.database.legacy.dao.w getLifeLogTextVectorCopilotDao$database_obricRelease() {
        if (this._lifeLogTextEntityTextVectorCopilotDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._lifeLogTextEntityTextVectorCopilotDaoOld != null) goto L10;
        this._lifeLogTextEntityTextVectorCopilotDaoOld = new LifeLogTextEntityTextVectorCopilotDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        com.obric.memorydata.database.legacy.dao.w r0 = this._lifeLogTextEntityTextVectorCopilotDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._lifeLogTextEntityTextVectorCopilotDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public x getLifelogDao$database_obricRelease() {
        if (this._lifelogDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._lifelogDaoOld != null) goto L10;
        this._lifelogDaoOld = new LifelogDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        x r0 = this._lifelogDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._lifelogDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public y getLifelogHistoryRawDbDao$database_obricRelease() {
        if (this._lifelogHistoryRawDbDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._lifelogHistoryRawDbDaoOld != null) goto L10;
        this._lifelogHistoryRawDbDaoOld = new LifelogHistoryRawDbDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        y r0 = this._lifelogHistoryRawDbDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._lifelogHistoryRawDbDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public LightSensorDao getLightSensorDao() {
        if (this._lightSensorDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._lightSensorDao != null) goto L10;
        this._lightSensorDao = new LightSensorDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        LightSensorDao r0 = this._lightSensorDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._lightSensorDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public LocalMemorySyncToDoubaoPendingDao getLocalMemorySyncToDoubaoPendingDao() {
        if (this._localMemorySyncToDoubaoPendingDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._localMemorySyncToDoubaoPendingDao != null) goto L10;
        this._localMemorySyncToDoubaoPendingDao = new LocalMemorySyncToDoubaoPendingDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        LocalMemorySyncToDoubaoPendingDao r0 = this._localMemorySyncToDoubaoPendingDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._localMemorySyncToDoubaoPendingDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public LocationAddressCacheDao getLocationAddressCacheDao() {
        if (this._locationAddressCacheDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._locationAddressCacheDao != null) goto L10;
        this._locationAddressCacheDao = new LocationAddressCacheDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        LocationAddressCacheDao r0 = this._locationAddressCacheDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._locationAddressCacheDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public LocationDao getLocationDao() {
        if (this._locationDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._locationDao != null) goto L10;
        this._locationDao = new LocationDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        LocationDao r0 = this._locationDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._locationDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public z getMemoryBaseRequirementDao$database_obricRelease() {
        if (this._memoryBaseRequirementDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memoryBaseRequirementDaoOld != null) goto L10;
        this._memoryBaseRequirementDaoOld = new MemoryBaseRequirementDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        z r0 = this._memoryBaseRequirementDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memoryBaseRequirementDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public aa getMemoryBaseSceneDao$database_obricRelease() {
        if (this._memoryBaseSceneDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memoryBaseSceneDaoOld != null) goto L10;
        this._memoryBaseSceneDaoOld = new MemoryBaseSceneDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        aa r0 = this._memoryBaseSceneDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memoryBaseSceneDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public MemoryEntityContentTimeDao getMemoryEntityContentTimeDao() {
        if (this._memoryEntityContentTimeDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memoryEntityContentTimeDao != null) goto L10;
        this._memoryEntityContentTimeDao = new MemoryEntityContentTimeDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MemoryEntityContentTimeDao r0 = this._memoryEntityContentTimeDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memoryEntityContentTimeDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public ab getMemoryEntityCorrelationDao$database_obricRelease() {
        if (this._memoryEntityCorrelationDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memoryEntityCorrelationDaoOld != null) goto L10;
        this._memoryEntityCorrelationDaoOld = new MemoryEntityCorrelationDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        ab r0 = this._memoryEntityCorrelationDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memoryEntityCorrelationDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public MemoryEntityTextVectorCopilotDao getMemoryEntityTextVectorCopilotDao() {
        if (this._memoryEntityTextVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memoryEntityTextVectorCopilotDao != null) goto L10;
        this._memoryEntityTextVectorCopilotDao = new MemoryEntityTextVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MemoryEntityTextVectorCopilotDao r0 = this._memoryEntityTextVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memoryEntityTextVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public ac getMemoryEntityToCalendarDao$database_obricRelease() {
        if (this._memoryEntityToCalendarDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memoryEntityToCalendarDaoOld != null) goto L10;
        this._memoryEntityToCalendarDaoOld = new MemoryEntityToCalendarDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        ac r0 = this._memoryEntityToCalendarDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memoryEntityToCalendarDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public ad getMemoryKeyInfoDao$database_obricRelease() {
        if (this._memoryKeyInfoDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memoryKeyInfoDaoOld != null) goto L10;
        this._memoryKeyInfoDaoOld = new MemoryKeyInfoDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        ad r0 = this._memoryKeyInfoDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memoryKeyInfoDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public MemoryLocationRawDbDao getMemoryLocationRawDbDao() {
        if (this._memoryLocationRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memoryLocationRawDbDao != null) goto L10;
        this._memoryLocationRawDbDao = new MemoryLocationRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MemoryLocationRawDbDao r0 = this._memoryLocationRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memoryLocationRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public MemoryLocationEntityTextVectorCopilotDao getMemoryLocationTextVectorCopilotDao() {
        if (this._memoryLocationEntityTextVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memoryLocationEntityTextVectorCopilotDao != null) goto L10;
        this._memoryLocationEntityTextVectorCopilotDao = new MemoryLocationEntityTextVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MemoryLocationEntityTextVectorCopilotDao r0 = this._memoryLocationEntityTextVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memoryLocationEntityTextVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public MemoryMapTableDao getMemoryMapTableDao() {
        if (this._memoryMapTableDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memoryMapTableDao != null) goto L10;
        this._memoryMapTableDao = new MemoryMapTableDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MemoryMapTableDao r0 = this._memoryMapTableDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memoryMapTableDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public MemoryProcessConsumerSubscriptionDao getMemoryProcessConsumerSubscriptionDao() {
        if (this._memoryProcessConsumerSubscriptionDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memoryProcessConsumerSubscriptionDao != null) goto L10;
        this._memoryProcessConsumerSubscriptionDao = new MemoryProcessConsumerSubscriptionDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MemoryProcessConsumerSubscriptionDao r0 = this._memoryProcessConsumerSubscriptionDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memoryProcessConsumerSubscriptionDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public MemoryProcessOperationRecordDao getMemoryProcessOperationRecordDao() {
        if (this._memoryProcessOperationRecordDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memoryProcessOperationRecordDao != null) goto L10;
        this._memoryProcessOperationRecordDao = new MemoryProcessOperationRecordDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MemoryProcessOperationRecordDao r0 = this._memoryProcessOperationRecordDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memoryProcessOperationRecordDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public MemoryProcessOutputEventDao getMemoryProcessOutputEventDao() {
        if (this._memoryProcessOutputEventDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memoryProcessOutputEventDao != null) goto L10;
        this._memoryProcessOutputEventDao = new MemoryProcessOutputEventDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MemoryProcessOutputEventDao r0 = this._memoryProcessOutputEventDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memoryProcessOutputEventDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public MemoryProcessSourceEventDao getMemoryProcessSourceEventDao() {
        if (this._memoryProcessSourceEventDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memoryProcessSourceEventDao != null) goto L10;
        this._memoryProcessSourceEventDao = new MemoryProcessSourceEventDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MemoryProcessSourceEventDao r0 = this._memoryProcessSourceEventDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memoryProcessSourceEventDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public MemoryProcessTriggerStateDao getMemoryProcessTriggerStateDao() {
        if (this._memoryProcessTriggerStateDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memoryProcessTriggerStateDao != null) goto L10;
        this._memoryProcessTriggerStateDao = new MemoryProcessTriggerStateDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MemoryProcessTriggerStateDao r0 = this._memoryProcessTriggerStateDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memoryProcessTriggerStateDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public ae getMemoryProcessUserInsightDao$database_obricRelease() {
        if (this._memoryProcessUserInsightDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memoryProcessUserInsightDaoOld != null) goto L10;
        this._memoryProcessUserInsightDaoOld = new MemoryProcessUserInsightDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        ae r0 = this._memoryProcessUserInsightDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memoryProcessUserInsightDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public af getMemoryReviewFeedbackDao$database_obricRelease() {
        if (this._memoryReviewFeedbackDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memoryReviewFeedbackDaoOld != null) goto L10;
        this._memoryReviewFeedbackDaoOld = new MemoryReviewFeedbackDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        af r0 = this._memoryReviewFeedbackDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memoryReviewFeedbackDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public ag getMemoryRuleDao$database_obricRelease() {
        if (this._memoryRuleDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memoryRuleDaoOld != null) goto L10;
        this._memoryRuleDaoOld = new MemoryRuleDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        ag r0 = this._memoryRuleDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memoryRuleDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public MemoryTraceReportDao getMemoryTraceReportDao() {
        if (this._memoryTraceReportDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memoryTraceReportDao != null) goto L10;
        this._memoryTraceReportDao = new MemoryTraceReportDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MemoryTraceReportDao r0 = this._memoryTraceReportDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memoryTraceReportDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public MessageEntityContentTimeDao getMessageEntityContentTimeDao() {
        if (this._messageEntityContentTimeDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._messageEntityContentTimeDao != null) goto L10;
        this._messageEntityContentTimeDao = new MessageEntityContentTimeDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MessageEntityContentTimeDao r0 = this._messageEntityContentTimeDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._messageEntityContentTimeDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public MessageHistoryRawDbDao getMessageHistoryRawDbDao() {
        if (this._messageHistoryRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._messageHistoryRawDbDao != null) goto L10;
        this._messageHistoryRawDbDao = new MessageHistoryRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MessageHistoryRawDbDao r0 = this._messageHistoryRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._messageHistoryRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public MessageEntityImageVectorCopilotDao getMessageImageVectorCopilotDao() {
        if (this._messageEntityImageVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._messageEntityImageVectorCopilotDao != null) goto L10;
        this._messageEntityImageVectorCopilotDao = new MessageEntityImageVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MessageEntityImageVectorCopilotDao r0 = this._messageEntityImageVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._messageEntityImageVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public MessageRawDbDao getMessageRawDbDao() {
        if (this._messageRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._messageRawDbDao != null) goto L10;
        this._messageRawDbDao = new MessageRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MessageRawDbDao r0 = this._messageRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._messageRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public MessageEntityTextVectorCopilotDao getMessageTextVectorCopilotDao() {
        if (this._messageEntityTextVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._messageEntityTextVectorCopilotDao != null) goto L10;
        this._messageEntityTextVectorCopilotDao = new MessageEntityTextVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MessageEntityTextVectorCopilotDao r0 = this._messageEntityTextVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._messageEntityTextVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public MetaFullContentKeywordCopilotDao getMetaFullContentKeywordCopilotDao() {
        if (this._metaFullContentKeywordCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._metaFullContentKeywordCopilotDao != null) goto L10;
        this._metaFullContentKeywordCopilotDao = new MetaFullContentKeywordCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MetaFullContentKeywordCopilotDao r0 = this._metaFullContentKeywordCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._metaFullContentKeywordCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public MetaLocationRawDbDao getMetaLocationRawDbDao() {
        if (this._metaLocationRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._metaLocationRawDbDao != null) goto L10;
        this._metaLocationRawDbDao = new MetaLocationRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MetaLocationRawDbDao r0 = this._metaLocationRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._metaLocationRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public MetaLocationEntityTextVectorCopilotDao getMetaLocationTextVectorCopilotDao() {
        if (this._metaLocationEntityTextVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._metaLocationEntityTextVectorCopilotDao != null) goto L10;
        this._metaLocationEntityTextVectorCopilotDao = new MetaLocationEntityTextVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MetaLocationEntityTextVectorCopilotDao r0 = this._metaLocationEntityTextVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._metaLocationEntityTextVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public MetaTagRawDbDao getMetaTagRawDbDao() {
        if (this._metaTagRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._metaTagRawDbDao != null) goto L10;
        this._metaTagRawDbDao = new MetaTagRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MetaTagRawDbDao r0 = this._metaTagRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._metaTagRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public ah getMiddleUserProfileDao$database_obricRelease() {
        if (this._middleUserProfileDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._middleUserProfileDaoOld != null) goto L10;
        this._middleUserProfileDaoOld = new MiddleUserProfileDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        ah r0 = this._middleUserProfileDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._middleUserProfileDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public MobileCellularDao getMobileCellularDao() {
        if (this._mobileCellularDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._mobileCellularDao != null) goto L10;
        this._mobileCellularDao = new MobileCellularDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MobileCellularDao r0 = this._mobileCellularDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._mobileCellularDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public MovementStateDao getMovementStateDao() {
        if (this._movementStateDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._movementStateDao != null) goto L10;
        this._movementStateDao = new MovementStateDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MovementStateDao r0 = this._movementStateDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._movementStateDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public NetworkStatusDao getNetworkStatusDao() {
        if (this._networkStatusDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._networkStatusDao != null) goto L10;
        this._networkStatusDao = new NetworkStatusDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        NetworkStatusDao r0 = this._networkStatusDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._networkStatusDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public NetworkTypeDao getNetworkTypeDao() {
        if (this._networkTypeDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._networkTypeDao != null) goto L10;
        this._networkTypeDao = new NetworkTypeDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        NetworkTypeDao r0 = this._networkTypeDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._networkTypeDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public NoteEntityContentTimeDao getNoteEntityContentTimeDao() {
        if (this._noteEntityContentTimeDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._noteEntityContentTimeDao != null) goto L10;
        this._noteEntityContentTimeDao = new NoteEntityContentTimeDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        NoteEntityContentTimeDao r0 = this._noteEntityContentTimeDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._noteEntityContentTimeDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public dx getNoteHistoryRawDbDao() {
        if (this._noteHistoryRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._noteHistoryRawDbDao != null) goto L10;
        this._noteHistoryRawDbDao = new NoteHistoryRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        dx r0 = this._noteHistoryRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._noteHistoryRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public NoteEntityImageVectorCopilotDao getNoteImageVectorCopilotDao() {
        if (this._noteEntityImageVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._noteEntityImageVectorCopilotDao != null) goto L10;
        this._noteEntityImageVectorCopilotDao = new NoteEntityImageVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        NoteEntityImageVectorCopilotDao r0 = this._noteEntityImageVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._noteEntityImageVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public NoteRawDbDao getNoteRawDbDao() {
        if (this._noteRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._noteRawDbDao != null) goto L10;
        this._noteRawDbDao = new NoteRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        NoteRawDbDao r0 = this._noteRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._noteRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public NoteRecordingRawDbDao getNoteRecordingRawDbDao() {
        if (this._noteRecordingRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._noteRecordingRawDbDao != null) goto L10;
        this._noteRecordingRawDbDao = new NoteRecordingRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        NoteRecordingRawDbDao r0 = this._noteRecordingRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._noteRecordingRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public NoteRecordingTextRawDbDao getNoteRecordingTextRawDbDao() {
        if (this._noteRecordingTextRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._noteRecordingTextRawDbDao != null) goto L10;
        this._noteRecordingTextRawDbDao = new NoteRecordingTextRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        NoteRecordingTextRawDbDao r0 = this._noteRecordingTextRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._noteRecordingTextRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public NoteRecordingTextEntityTextVectorCopilotDao getNoteRecordingTextTextVectorCopilotDao() {
        if (this._noteRecordingTextEntityTextVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._noteRecordingTextEntityTextVectorCopilotDao != null) goto L10;
        this._noteRecordingTextEntityTextVectorCopilotDao = new NoteRecordingTextEntityTextVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        NoteRecordingTextEntityTextVectorCopilotDao r0 = this._noteRecordingTextEntityTextVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._noteRecordingTextEntityTextVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public NoteRecordingEntityTextVectorCopilotDao getNoteRecordingTextVectorCopilotDao() {
        if (this._noteRecordingEntityTextVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._noteRecordingEntityTextVectorCopilotDao != null) goto L10;
        this._noteRecordingEntityTextVectorCopilotDao = new NoteRecordingEntityTextVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        NoteRecordingEntityTextVectorCopilotDao r0 = this._noteRecordingEntityTextVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._noteRecordingEntityTextVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public NoteEntityTextVectorCopilotDao getNoteTextVectorCopilotDao() {
        if (this._noteEntityTextVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._noteEntityTextVectorCopilotDao != null) goto L10;
        this._noteEntityTextVectorCopilotDao = new NoteEntityTextVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        NoteEntityTextVectorCopilotDao r0 = this._noteEntityTextVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._noteEntityTextVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public OrderHitDao getOrderHitDao() {
        if (this._orderHitDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._orderHitDao != null) goto L10;
        this._orderHitDao = new OrderHitDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        OrderHitDao r0 = this._orderHitDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._orderHitDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public OsAudioPlayDao getOsAudioPlayDao() {
        if (this._osAudioPlayDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._osAudioPlayDao != null) goto L10;
        this._osAudioPlayDao = new OsAudioPlayDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        OsAudioPlayDao r0 = this._osAudioPlayDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._osAudioPlayDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public OsNotificationDao getOsNotificationDao() {
        if (this._osNotificationDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._osNotificationDao != null) goto L10;
        this._osNotificationDao = new OsNotificationDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        OsNotificationDao r0 = this._osNotificationDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._osNotificationDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public PackageEventDao getPackageEventDao() {
        if (this._packageEventDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._packageEventDao != null) goto L10;
        this._packageEventDao = new PackageEventDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        PackageEventDao r0 = this._packageEventDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._packageEventDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public ai getPendingContextDao$database_obricRelease() {
        if (this._pendingContextDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._pendingContextDaoOld != null) goto L10;
        this._pendingContextDaoOld = new PendingContextDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        ai r0 = this._pendingContextDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._pendingContextDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public aj getPendingEpisodicDao$database_obricRelease() {
        if (this._pendingEpisodicDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._pendingEpisodicDaoOld != null) goto L10;
        this._pendingEpisodicDaoOld = new PendingEpisodicDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        aj r0 = this._pendingEpisodicDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._pendingEpisodicDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public ak getPendingMemoryCalendarDao$database_obricRelease() {
        if (this._pendingMemoryCalendarDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._pendingMemoryCalendarDaoOld != null) goto L10;
        this._pendingMemoryCalendarDaoOld = new PendingMemoryCalendarDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        ak r0 = this._pendingMemoryCalendarDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._pendingMemoryCalendarDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public al getPendingSemanticDao$database_obricRelease() {
        if (this._pendingSemanticDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._pendingSemanticDaoOld != null) goto L10;
        this._pendingSemanticDaoOld = new PendingSemanticDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        al r0 = this._pendingSemanticDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._pendingSemanticDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public el getPhotoFaceHistoryRawDbDao() {
        if (this._photoFaceHistoryRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._photoFaceHistoryRawDbDao != null) goto L10;
        this._photoFaceHistoryRawDbDao = new PhotoFaceHistoryRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        el r0 = this._photoFaceHistoryRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._photoFaceHistoryRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public PhotoFaceRawDbDao getPhotoFaceRawDbDao() {
        if (this._photoFaceRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._photoFaceRawDbDao != null) goto L10;
        this._photoFaceRawDbDao = new PhotoFaceRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        PhotoFaceRawDbDao r0 = this._photoFaceRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._photoFaceRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public PhotoEntityImageVectorCopilotDao getPhotoImageVectorCopilotDao() {
        if (this._photoEntityImageVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._photoEntityImageVectorCopilotDao != null) goto L10;
        this._photoEntityImageVectorCopilotDao = new PhotoEntityImageVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        PhotoEntityImageVectorCopilotDao r0 = this._photoEntityImageVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._photoEntityImageVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public PhotoRawDbDao getPhotoRawDbDao() {
        if (this._photoRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._photoRawDbDao != null) goto L10;
        this._photoRawDbDao = new PhotoRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        PhotoRawDbDao r0 = this._photoRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._photoRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public PhotoEntityTextVectorCopilotDao getPhotoTextVectorCopilotDao() {
        if (this._photoEntityTextVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._photoEntityTextVectorCopilotDao != null) goto L10;
        this._photoEntityTextVectorCopilotDao = new PhotoEntityTextVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        PhotoEntityTextVectorCopilotDao r0 = this._photoEntityTextVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._photoEntityTextVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public PoiInfoGroupDao getPoiInfoGroupDao() {
        if (this._poiInfoGroupDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._poiInfoGroupDao != null) goto L10;
        this._poiInfoGroupDao = new PoiInfoGroupDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        PoiInfoGroupDao r0 = this._poiInfoGroupDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._poiInfoGroupDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public PoiReqRecorderDao getPoiReqRecorderDao() {
        if (this._poiReqRecorderDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._poiReqRecorderDao != null) goto L10;
        this._poiReqRecorderDao = new PoiReqRecorderDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        PoiReqRecorderDao r0 = this._poiReqRecorderDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._poiReqRecorderDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public PredictAppDao getPredictAppResultDao() {
        if (this._predictAppDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._predictAppDao != null) goto L10;
        this._predictAppDao = new PredictAppDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        PredictAppDao r0 = this._predictAppDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._predictAppDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public PredictSleepWakeupDao getPredictSleepWakeupDao() {
        if (this._predictSleepWakeupDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._predictSleepWakeupDao != null) goto L10;
        this._predictSleepWakeupDao = new PredictSleepWakeupDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        PredictSleepWakeupDao r0 = this._predictSleepWakeupDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._predictSleepWakeupDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public am getProactiveEpisodicRelevantDataDao$database_obricRelease() {
        if (this._proactiveEpisodicRelevantDataDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._proactiveEpisodicRelevantDataDaoOld != null) goto L10;
        this._proactiveEpisodicRelevantDataDaoOld = new ProactiveEpisodicRelevantDataDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        am r0 = this._proactiveEpisodicRelevantDataDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._proactiveEpisodicRelevantDataDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public ProactiveMemoryProcessInfoDao getProactiveMemoryProcessInfoDao() {
        if (this._proactiveMemoryProcessInfoDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._proactiveMemoryProcessInfoDao != null) goto L10;
        this._proactiveMemoryProcessInfoDao = new ProactiveMemoryProcessInfoDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        ProactiveMemoryProcessInfoDao r0 = this._proactiveMemoryProcessInfoDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._proactiveMemoryProcessInfoDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public ProactiveMemorySyncPendingDao getProactiveMemorySyncPendingDao() {
        if (this._proactiveMemorySyncPendingDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._proactiveMemorySyncPendingDao != null) goto L10;
        this._proactiveMemorySyncPendingDao = new ProactiveMemorySyncPendingDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        ProactiveMemorySyncPendingDao r0 = this._proactiveMemorySyncPendingDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._proactiveMemorySyncPendingDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public ProactiveOsNotificationDao getProactiveOsNotificationDao() {
        if (this._proactiveOsNotificationDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._proactiveOsNotificationDao != null) goto L10;
        this._proactiveOsNotificationDao = new ProactiveOsNotificationDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        ProactiveOsNotificationDao r0 = this._proactiveOsNotificationDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._proactiveOsNotificationDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public an getProactiveSemanticRelevantDataDao$database_obricRelease() {
        if (this._proactiveSemanticRelevantDataDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._proactiveSemanticRelevantDataDaoOld != null) goto L10;
        this._proactiveSemanticRelevantDataDaoOld = new ProactiveSemanticRelevantDataDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        an r0 = this._proactiveSemanticRelevantDataDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._proactiveSemanticRelevantDataDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public RawChatAppChatDao getRawAppChatDao() {
        if (this._rawChatAppChatDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._rawChatAppChatDao != null) goto L10;
        this._rawChatAppChatDao = new RawChatAppChatDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        RawChatAppChatDao r0 = this._rawChatAppChatDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._rawChatAppChatDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public MemoryEntityRawDbDao getRawMemoryEntityDao() {
        if (this._memoryEntityRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memoryEntityRawDbDao != null) goto L10;
        this._memoryEntityRawDbDao = new MemoryEntityRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MemoryEntityRawDbDao r0 = this._memoryEntityRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memoryEntityRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public RawMemoryHistoryRawDbDao getRawMemoryHistoryRawDbDao() {
        if (this._rawMemoryHistoryRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._rawMemoryHistoryRawDbDao != null) goto L10;
        this._rawMemoryHistoryRawDbDao = new RawMemoryHistoryRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        RawMemoryHistoryRawDbDao r0 = this._rawMemoryHistoryRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._rawMemoryHistoryRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public RawObservationDao getRawObservationDao() {
        if (this._rawObservationDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._rawObservationDao != null) goto L10;
        this._rawObservationDao = new RawObservationDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        RawObservationDao r0 = this._rawObservationDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._rawObservationDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public RawPhotoContentTimeDao getRawPhotoContentTimeDao() {
        if (this._rawPhotoContentTimeDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._rawPhotoContentTimeDao != null) goto L10;
        this._rawPhotoContentTimeDao = new RawPhotoContentTimeDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        RawPhotoContentTimeDao r0 = this._rawPhotoContentTimeDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._rawPhotoContentTimeDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public PhotoHistoryEntityDao getRawPhotoHistoryEntityDao() {
        if (this._photoHistoryEntityDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._photoHistoryEntityDao != null) goto L10;
        this._photoHistoryEntityDao = new PhotoHistoryEntityDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        PhotoHistoryEntityDao r0 = this._photoHistoryEntityDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._photoHistoryEntityDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public ao getRawUserProfileHistoryRawDbDao$database_obricRelease() {
        if (this._rawUserProfileHistoryRawDbDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._rawUserProfileHistoryRawDbDaoOld != null) goto L10;
        this._rawUserProfileHistoryRawDbDaoOld = new RawUserProfileHistoryRawDbDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        ao r0 = this._rawUserProfileHistoryRawDbDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._rawUserProfileHistoryRawDbDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public RecordingEntityContentTimeDao getRecordingEntityContentTimeDao() {
        if (this._recordingEntityContentTimeDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._recordingEntityContentTimeDao != null) goto L10;
        this._recordingEntityContentTimeDao = new RecordingEntityContentTimeDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        RecordingEntityContentTimeDao r0 = this._recordingEntityContentTimeDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._recordingEntityContentTimeDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public hx getRecordingHistoryRawDbDao() {
        if (this._recordingHistoryRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._recordingHistoryRawDbDao != null) goto L10;
        this._recordingHistoryRawDbDao = new RecordingHistoryRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        hx r0 = this._recordingHistoryRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._recordingHistoryRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public RecordingRawDbDao getRecordingRawDbDao() {
        if (this._recordingRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._recordingRawDbDao != null) goto L10;
        this._recordingRawDbDao = new RecordingRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        RecordingRawDbDao r0 = this._recordingRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._recordingRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public RecordingTextRawDbDao getRecordingTextRawDbDao() {
        if (this._recordingTextRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._recordingTextRawDbDao != null) goto L10;
        this._recordingTextRawDbDao = new RecordingTextRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        RecordingTextRawDbDao r0 = this._recordingTextRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._recordingTextRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public RecordingTextEntityTextVectorCopilotDao getRecordingTextTextVectorCopilotDao() {
        if (this._recordingTextEntityTextVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._recordingTextEntityTextVectorCopilotDao != null) goto L10;
        this._recordingTextEntityTextVectorCopilotDao = new RecordingTextEntityTextVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        RecordingTextEntityTextVectorCopilotDao r0 = this._recordingTextEntityTextVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._recordingTextEntityTextVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public RecordingEntityTextVectorCopilotDao getRecordingTextVectorCopilotDao() {
        if (this._recordingEntityTextVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._recordingEntityTextVectorCopilotDao != null) goto L10;
        this._recordingEntityTextVectorCopilotDao = new RecordingEntityTextVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        RecordingEntityTextVectorCopilotDao r0 = this._recordingEntityTextVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._recordingEntityTextVectorCopilotDao;
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap r2 = new HashMap();
        r2.put(GeographyDao.class, GeographyDao_Impl.getRequiredConverters());
        r2.put(MobileCellularDao.class, MobileCellularDao_Impl.getRequiredConverters());
        r2.put(WifiDao.class, WifiDao_Impl.getRequiredConverters());
        r2.put(WifiListDao.class, WifiListDao_Impl.getRequiredConverters());
        r2.put(LocationDao.class, LocationDao_Impl.getRequiredConverters());
        r2.put(ScreenStateDao.class, ScreenStateDao_Impl.getRequiredConverters());
        r2.put(ah.class, MiddleUserProfileDaoOld_Impl.getRequiredConverters());
        r2.put(bc.class, UserProfileDaoOld_Impl.getRequiredConverters());
        r2.put(BluetoothDeviceDao.class, BluetoothDeviceDao_Impl.getRequiredConverters());
        r2.put(AppActivityDao.class, AppActivityDao_Impl.getRequiredConverters());
        r2.put(StreamVolumeDao.class, StreamVolumeDao_Impl.getRequiredConverters());
        r2.put(SettingsChangedDao.class, SettingsChangedDao_Impl.getRequiredConverters());
        r2.put(ScreenBrightnessDao.class, ScreenBrightnessDao_Impl.getRequiredConverters());
        r2.put(PackageEventDao.class, PackageEventDao_Impl.getRequiredConverters());
        r2.put(OsNotificationDao.class, OsNotificationDao_Impl.getRequiredConverters());
        r2.put(OsAudioPlayDao.class, OsAudioPlayDao_Impl.getRequiredConverters());
        r2.put(NetworkStatusDao.class, NetworkStatusDao_Impl.getRequiredConverters());
        r2.put(MovementStateDao.class, MovementStateDao_Impl.getRequiredConverters());
        r2.put(LightSensorDao.class, LightSensorDao_Impl.getRequiredConverters());
        r2.put(LanguageChangeEventDao.class, LanguageChangeEventDao_Impl.getRequiredConverters());
        r2.put(BatteryStateDao.class, BatteryStateDao_Impl.getRequiredConverters());
        r2.put(DeviceBootDao.class, DeviceBootDao_Impl.getRequiredConverters());
        r2.put(DeviceShutdownDao.class, DeviceShutdownDao_Impl.getRequiredConverters());
        r2.put(AlarmDao.class, AlarmDao_Impl.getRequiredConverters());
        r2.put(AppUsageDao.class, AppUsageDao_Impl.getRequiredConverters());
        r2.put(NetworkTypeDao.class, NetworkTypeDao_Impl.getRequiredConverters());
        r2.put(PredictAppDao.class, PredictAppDao_Impl.getRequiredConverters());
        r2.put(UserActionRecorderDao.class, UserActionRecorderDao_Impl.getRequiredConverters());
        r2.put(PredictSleepWakeupDao.class, PredictSleepWakeupDao_Impl.getRequiredConverters());
        r2.put(PoiInfoGroupDao.class, PoiInfoGroupDao_Impl.getRequiredConverters());
        r2.put(PoiReqRecorderDao.class, PoiReqRecorderDao_Impl.getRequiredConverters());
        r2.put(UploadDataDao.class, UploadDataDao_Impl.getRequiredConverters());
        r2.put(IndexPendingDao.class, IndexPendingDao_MemoryFrameDb_Impl.getRequiredConverters());
        r2.put(EntityIndexLifecycleDao.class, EntityIndexLifecycleDao_MemoryFrameDb_Impl.getRequiredConverters());
        r2.put(MessageRawDbDao.class, MessageRawDbDao_Impl.getRequiredConverters());
        r2.put(MessageHistoryRawDbDao.class, MessageHistoryRawDbDao_Impl.getRequiredConverters());
        r2.put(ContactRawDbDao.class, ContactRawDbDao_Impl.getRequiredConverters());
        r2.put(ContactHistoryEntityDao.class, ContactHistoryEntityDao_Impl.getRequiredConverters());
        r2.put(ICSProtocolEntityRawDbDao.class, ICSProtocolEntityRawDbDao_Impl.getRequiredConverters());
        r2.put(ICSProtocolHistoryEntityDao.class, ICSProtocolHistoryEntityDao_Impl.getRequiredConverters());
        r2.put(DoubaoAccountEntityRawDbDao.class, DoubaoAccountEntityRawDbDao_Impl.getRequiredConverters());
        r2.put(CallHistoryRawDbDao.class, CallHistoryRawDbDao_Impl.getRequiredConverters());
        r2.put(CallHistoryHistoryEntityDao.class, CallHistoryHistoryEntityDao_Impl.getRequiredConverters());
        r2.put(NoteRawDbDao.class, NoteRawDbDao_Impl.getRequiredConverters());
        r2.put(dx.class, NoteHistoryRawDbDao_Impl.getRequiredConverters());
        r2.put(PhotoRawDbDao.class, PhotoRawDbDao_Impl.getRequiredConverters());
        r2.put(CommonPhotoRawDbDao.class, CommonPhotoRawDbDao_Impl.getRequiredConverters());
        r2.put(PhotoFaceRawDbDao.class, PhotoFaceRawDbDao_Impl.getRequiredConverters());
        r2.put(el.class, PhotoFaceHistoryRawDbDao_Impl.getRequiredConverters());
        r2.put(MetaLocationRawDbDao.class, MetaLocationRawDbDao_Impl.getRequiredConverters());
        r2.put(LocationAddressCacheDao.class, LocationAddressCacheDao_Impl.getRequiredConverters());
        r2.put(MetaTagRawDbDao.class, MetaTagRawDbDao_Impl.getRequiredConverters());
        r2.put(AlbumRawDbDao.class, AlbumRawDbDao_Impl.getRequiredConverters());
        r2.put(AlbumHistoryEntityDao.class, AlbumHistoryEntityDao_Impl.getRequiredConverters());
        r2.put(AlarmRawDbDao.class, AlarmRawDbDao_Impl.getRequiredConverters());
        r2.put(VideoFrameRawDbDao.class, VideoFrameRawDbDao_Impl.getRequiredConverters());
        r2.put(CommonVideoFrameRawDbDao.class, CommonVideoFrameRawDbDao_Impl.getRequiredConverters());
        r2.put(RecordingRawDbDao.class, RecordingRawDbDao_Impl.getRequiredConverters());
        r2.put(hx.class, RecordingHistoryRawDbDao_Impl.getRequiredConverters());
        r2.put(RecordingTextRawDbDao.class, RecordingTextRawDbDao_Impl.getRequiredConverters());
        r2.put(AuditoryRecordingRawDbDao.class, AuditoryRecordingRawDbDao_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.entity.r.class, AuditoryRecordingHistoryEntityDao_Impl.getRequiredConverters());
        r2.put(AuditoryRecordingTextRawDbDao.class, AuditoryRecordingTextRawDbDao_Impl.getRequiredConverters());
        r2.put(AuditoryRecordingEntityTextVectorCopilotDao.class, AuditoryRecordingEntityTextVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(AuditoryRecordingTextEntityTextVectorCopilotDao.class, AuditoryRecordingTextEntityTextVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(ScheduleRawDbDao.class, ScheduleRawDbDao_Impl.getRequiredConverters());
        r2.put(BrowserBookmarkRawDbDao.class, BrowserBookmarkRawDbDao_Impl.getRequiredConverters());
        r2.put(BrowserBookmarkHistoryEntityDao.class, BrowserBookmarkHistoryEntityDao_Impl.getRequiredConverters());
        r2.put(FileRawDbDao.class, FileRawDbDao_Impl.getRequiredConverters());
        r2.put(FileHistoryEntityDao.class, FileHistoryEntityDao_Impl.getRequiredConverters());
        r2.put(FileTextRawDbDao.class, FileTextRawDbDao_Impl.getRequiredConverters());
        r2.put(NoteRecordingRawDbDao.class, NoteRecordingRawDbDao_Impl.getRequiredConverters());
        r2.put(NoteRecordingTextRawDbDao.class, NoteRecordingTextRawDbDao_Impl.getRequiredConverters());
        r2.put(MessageEntityTextVectorCopilotDao.class, MessageEntityTextVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(MessageEntityImageVectorCopilotDao.class, MessageEntityImageVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(MessageEntityContentTimeDao.class, MessageEntityContentTimeDao_Impl.getRequiredConverters());
        r2.put(ContactEntityTextVectorCopilotDao.class, ContactEntityTextVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(ContactEntityImageVectorCopilotDao.class, ContactEntityImageVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(CallHistoryEntityTextVectorCopilotDao.class, CallHistoryEntityTextVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(NoteEntityContentTimeDao.class, NoteEntityContentTimeDao_Impl.getRequiredConverters());
        r2.put(RecordingEntityContentTimeDao.class, RecordingEntityContentTimeDao_Impl.getRequiredConverters());
        r2.put(CallHistoryEntityContentTimeDao.class, CallHistoryEntityContentTimeDao_Impl.getRequiredConverters());
        r2.put(MemoryEntityContentTimeDao.class, MemoryEntityContentTimeDao_Impl.getRequiredConverters());
        r2.put(NoteEntityTextVectorCopilotDao.class, NoteEntityTextVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(NoteEntityImageVectorCopilotDao.class, NoteEntityImageVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(PhotoEntityTextVectorCopilotDao.class, PhotoEntityTextVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(PhotoEntityImageVectorCopilotDao.class, PhotoEntityImageVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(RawPhotoContentTimeDao.class, RawPhotoContentTimeDao_Impl.getRequiredConverters());
        r2.put(CommonPhotoEntityTextVectorCopilotDao.class, CommonPhotoEntityTextVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(CommonPhotoEntityImageVectorCopilotDao.class, CommonPhotoEntityImageVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(VideoFrameEntityTextVectorCopilotDao.class, VideoFrameEntityTextVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(VideoFrameEntityImageVectorCopilotDao.class, VideoFrameEntityImageVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(CommonVideoFrameEntityTextVectorCopilotDao.class, CommonVideoFrameEntityTextVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(CommonVideoFrameEntityImageVectorCopilotDao.class, CommonVideoFrameEntityImageVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(MetaLocationEntityTextVectorCopilotDao.class, MetaLocationEntityTextVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(AlarmEntityTextVectorCopilotDao.class, AlarmEntityTextVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(ScheduleEntityTextVectorCopilotDao.class, ScheduleEntityTextVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(EvaluationSourceDataDao.class, EvaluationSourceDataDao_Impl.getRequiredConverters());
        r2.put(RawChatAppChatDao.class, RawChatAppChatDao_Impl.getRequiredConverters());
        r2.put(ElementKGIndexPendingDao.class, ElementKGIndexPendingDao_Impl.getRequiredConverters());
        r2.put(EmbeddingVectorCacheDao.class, EmbeddingVectorCacheDao_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.dao.q.class, EpisodicMemoryDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.dao.s.class, EpisodicMemoryTextVectorCopilotDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.dao.p.class, EpisodicMemoryContentTimeDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.dao.t.class, EpisodicTopicMemoryDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.dao.v.class, EpisodicTopicMemoryTextVectorCopilotDaoOld_Impl.getRequiredConverters());
        r2.put(ProactiveMemoryProcessInfoDao.class, ProactiveMemoryProcessInfoDao_Impl.getRequiredConverters());
        r2.put(ProactiveMemorySyncPendingDao.class, ProactiveMemorySyncPendingDao_Impl.getRequiredConverters());
        r2.put(MemoryEntityRawDbDao.class, MemoryEntityRawDbDao_Impl.getRequiredConverters());
        r2.put(RawMemoryHistoryRawDbDao.class, RawMemoryHistoryRawDbDao_Impl.getRequiredConverters());
        r2.put(MemoryEntityTextVectorCopilotDao.class, MemoryEntityTextVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(DataBuildMemoryStatusDao.class, DataBuildMemoryStatusDao_Impl.getRequiredConverters());
        r2.put(BatchChatDao.class, BatchChatDao_Impl.getRequiredConverters());
        r2.put(OrderHitDao.class, OrderHitDao_Impl.getRequiredConverters());
        r2.put(MemoryLocationRawDbDao.class, MemoryLocationRawDbDao_Impl.getRequiredConverters());
        r2.put(MemoryLocationEntityTextVectorCopilotDao.class, MemoryLocationEntityTextVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(FileEntityTextVectorCopilotDao.class, FileEntityTextVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(FileTextEntityTextVectorCopilotDao.class, FileTextEntityTextVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(RecordingEntityTextVectorCopilotDao.class, RecordingEntityTextVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(RecordingTextEntityTextVectorCopilotDao.class, RecordingTextEntityTextVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(NoteRecordingEntityTextVectorCopilotDao.class, NoteRecordingEntityTextVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(NoteRecordingTextEntityTextVectorCopilotDao.class, NoteRecordingTextEntityTextVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(MemoryMapTableDao.class, MemoryMapTableDao_Impl.getRequiredConverters());
        r2.put(ab.class, MemoryEntityCorrelationDaoOld_Impl.getRequiredConverters());
        r2.put(CountdownRawDbDao.class, CountdownRawDbDao_Impl.getRequiredConverters());
        r2.put(CountdownEntityTextVectorCopilotDao.class, CountdownEntityTextVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(ArriveLeaveHomeCompanyEventDao.class, ArriveLeaveHomeCompanyEventDao_Impl.getRequiredConverters());
        r2.put(PhotoHistoryEntityDao.class, PhotoHistoryEntityDao_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.dao.o.class, ComplexRecommendQueryDaoOld_Impl.getRequiredConverters());
        r2.put(ScreenObservationDao.class, ScreenObservationDao_Impl.getRequiredConverters());
        r2.put(RawObservationDao.class, RawObservationDao_Impl.getRequiredConverters());
        r2.put(GlassesSyncStateDao.class, GlassesSyncStateDao_Impl.getRequiredConverters());
        r2.put(SpeakerEmbeddingPendingDao.class, SpeakerEmbeddingPendingDao_Impl.getRequiredConverters());
        r2.put(AuditoryAsrTaskDao.class, AuditoryAsrTaskDao_Impl.getRequiredConverters());
        r2.put(AuditorySyncStateDao.class, AuditorySyncStateDao_Impl.getRequiredConverters());
        r2.put(x.class, LifelogDaoOld_Impl.getRequiredConverters());
        r2.put(bd.class, UserProfileMemoryDaoOld_Impl.getRequiredConverters());
        r2.put(ak.class, PendingMemoryCalendarDaoOld_Impl.getRequiredConverters());
        r2.put(ac.class, MemoryEntityToCalendarDaoOld_Impl.getRequiredConverters());
        r2.put(LocalMemorySyncToDoubaoPendingDao.class, LocalMemorySyncToDoubaoPendingDao_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.dao.n.class, BlockMemoryContentDaoOld_Impl.getRequiredConverters());
        r2.put(BssidCalcCacheDao.class, BssidCalcCacheDao_Impl.getRequiredConverters());
        r2.put(bb.class, UserKeywordDaoOld_Impl.getRequiredConverters());
        r2.put(be.class, UserProfileRawDbDaoOld_Impl.getRequiredConverters());
        r2.put(bf.class, UserProfileTextEntityTextVectorCopilotDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.backup.dao.g.class, BackUpBlockMemoryContentDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.backup.dao.h.class, BackUpEpisodicMemoryDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.backup.dao.i.class, BackUpEpisodicTopicMemoryDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.backup.dao.j.class, BackUpLifelogDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.backup.dao.k.class, BackUpMemoryEntityCorrelationDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.backup.dao.l.class, BackUpMemoryEntityToCalendarDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.backup.dao.m.class, BackUpMemoryKeyInfoDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.backup.dao.o.class, BackUpPendingMemoryCalendarDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.backup.dao.c.class, BackUpRawMemoryDao_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.backup.dao.r.class, BackUpRawUserProfileDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.backup.dao.u.class, BackUpUnionSemanticMemoryDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.backup.dao.q.class, BackUpProactiveSemanticRelevantDataDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.backup.dao.p.class, BackUpProactiveEpisodicRelevantDataDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.backup.dao.w.class, BackUpUpdateUnionSemanticMemoryDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.backup.dao.v.class, BackUpUpdateProactiveSemanticRelevantDataDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.backup.dao.b.class, BackUpAutoMemoryEpisodicRelevantDataDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.backup.dao.f.class, BackUpAutoMemorySemanticRelevantDataDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.dao.a.class, AgentWatermarkDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.backup.dao.a.class, BackUpAgentWatermarkDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.dao.r.class, EpisodicMemoryHistoryRawDbDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.dao.u.class, EpisodicTopicMemoryHistoryRawDbDaoOld_Impl.getRequiredConverters());
        r2.put(y.class, LifelogHistoryRawDbDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.dao.g.class, AutoMemoryProHistoryRawDbDaoOld_Impl.getRequiredConverters());
        r2.put(ao.class, RawUserProfileHistoryRawDbDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.dao.w.class, LifeLogTextEntityTextVectorCopilotDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.dao.l.class, AutoMemoryProTextEntityTextVectorCopilotDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.backup.dao.c.class, BackUpAutoMemoryProEntityDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.backup.dao.e.class, BackUpAutoMemoryProSlmPersonalInfoDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.backup.dao.d.class, BackUpAutoMemoryProSlmEpisodicMemoryDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.backup.dao.t.class, BackUpSlmAutoMemoryProTempResultDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.backup.dao.s.class, BackUpSlmAgentWatermarkDaoOld_Impl.getRequiredConverters());
        r2.put(ad.class, MemoryKeyInfoDaoOld_Impl.getRequiredConverters());
        r2.put(af.class, MemoryReviewFeedbackDaoOld_Impl.getRequiredConverters());
        r2.put(MemoryTraceReportDao.class, MemoryTraceReportDao_Impl.getRequiredConverters());
        r2.put(InAppTraceUploadDao.class, InAppTraceUploadDao_Impl.getRequiredConverters());
        r2.put(MetaFullContentKeywordCopilotDao.class, MetaFullContentKeywordCopilotDao_Impl.getRequiredConverters());
        r2.put(HarStateDao.class, HarStateDao_Impl.getRequiredConverters());
        r2.put(AwarenessInfoDao.class, AwarenessInfoDao_Impl.getRequiredConverters());
        r2.put(CellInfoDao.class, CellInfoDao_Impl.getRequiredConverters());
        r2.put(ap.class, SemanticMemoryDaoOld_Impl.getRequiredConverters());
        r2.put(au.class, UnionSemanticMemoryHistoryRawDbDaoOld_Impl.getRequiredConverters());
        r2.put(aq.class, SemanticTextCopilotDaoOld_Impl.getRequiredConverters());
        r2.put(at.class, UnionSemanticMemoryExtDaoOld_Impl.getRequiredConverters());
        r2.put(an.class, ProactiveSemanticRelevantDataDaoOld_Impl.getRequiredConverters());
        r2.put(ba.class, UpdateUnionSemanticMemoryDaoOld_Impl.getRequiredConverters());
        r2.put(az.class, UpdateProactiveSemanticRelevantDataDaoOld_Impl.getRequiredConverters());
        r2.put(ai.class, PendingContextDaoOld_Impl.getRequiredConverters());
        r2.put(aj.class, PendingEpisodicDaoOld_Impl.getRequiredConverters());
        r2.put(al.class, PendingSemanticDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.dao.b.class, AssistantChatDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.dao.c.class, AssistantChatMessageDaoOld_Impl.getRequiredConverters());
        r2.put(am.class, ProactiveEpisodicRelevantDataDaoOld_Impl.getRequiredConverters());
        r2.put(ag.class, MemoryRuleDaoOld_Impl.getRequiredConverters());
        r2.put(aa.class, MemoryBaseSceneDaoOld_Impl.getRequiredConverters());
        r2.put(z.class, MemoryBaseRequirementDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.dao.d.class, AutoMemoryEpisodicRelevantDataDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.dao.m.class, AutoMemorySemanticRelevantDataDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.dao.e.class, AutoMemoryProDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.dao.h.class, AutoMemoryProRawSourceDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.dao.k.class, AutoMemoryProSnapShotDaoOld_Impl.getRequiredConverters());
        r2.put(av.class, UnionSemanticMemorySnapShotDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.dao.j.class, AutoMemoryProSlmPersonalInfoDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.dao.i.class, AutoMemoryProSlmEpisodicMemoryDaoOld_Impl.getRequiredConverters());
        r2.put(as.class, SlmAutoMemoryProTempResultDaoOld_Impl.getRequiredConverters());
        r2.put(ar.class, SlmAgentWatermarkDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.dao.f.class, AutoMemoryProEvaluationStatsDaoOld_Impl.getRequiredConverters());
        r2.put(AutoMemoryProTraceDao.class, AutoMemoryProTraceDao_Impl.getRequiredConverters());
        r2.put(aw.class, UnionSemanticTypeSummaryDaoOld_Impl.getRequiredConverters());
        r2.put(ax.class, UnionUserInsightDaoOld_Impl.getRequiredConverters());
        r2.put(ay.class, UnionUserPersonaDaoOld_Impl.getRequiredConverters());
        r2.put(MemoryProcessConsumerSubscriptionDao.class, MemoryProcessConsumerSubscriptionDao_Impl.getRequiredConverters());
        r2.put(MemoryProcessSourceEventDao.class, MemoryProcessSourceEventDao_Impl.getRequiredConverters());
        r2.put(MemoryProcessTriggerStateDao.class, MemoryProcessTriggerStateDao_Impl.getRequiredConverters());
        r2.put(MemoryProcessOperationRecordDao.class, MemoryProcessOperationRecordDao_Impl.getRequiredConverters());
        r2.put(MemoryProcessOutputEventDao.class, MemoryProcessOutputEventDao_Impl.getRequiredConverters());
        r2.put(ae.class, MemoryProcessUserInsightDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.legacy.backup.dao.n.class, BackUpMemoryRuleDaoOld_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.backup.dao.a.class, BackUpAutoMemoryProSnapShotDao_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.backup.dao.d.class, BackUpUnionSemanticMemorySnapShotDao_Impl.getRequiredConverters());
        r2.put(com.obric.memorydata.database.backup.dao.b.class, BackUpMemoryReviewFeedbackDao_Impl.getRequiredConverters());
        r2.put(ProactiveOsNotificationDao.class, ProactiveOsNotificationDao_Impl.getRequiredConverters());
        r2.put(InAppL1RuleDao.class, InAppL1RuleDao_Impl.getRequiredConverters());
        return r2;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public ScheduleRawDbDao getScheduleRawDbDao() {
        if (this._scheduleRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._scheduleRawDbDao != null) goto L10;
        this._scheduleRawDbDao = new ScheduleRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        ScheduleRawDbDao r0 = this._scheduleRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._scheduleRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public ScheduleEntityTextVectorCopilotDao getScheduleTextVectorCopilotDao() {
        if (this._scheduleEntityTextVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._scheduleEntityTextVectorCopilotDao != null) goto L10;
        this._scheduleEntityTextVectorCopilotDao = new ScheduleEntityTextVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        ScheduleEntityTextVectorCopilotDao r0 = this._scheduleEntityTextVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._scheduleEntityTextVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public ScreenBrightnessDao getScreenBrightnessDao() {
        if (this._screenBrightnessDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._screenBrightnessDao != null) goto L10;
        this._screenBrightnessDao = new ScreenBrightnessDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        ScreenBrightnessDao r0 = this._screenBrightnessDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._screenBrightnessDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public ScreenObservationDao getScreenObservationDao() {
        if (this._screenObservationDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._screenObservationDao != null) goto L10;
        this._screenObservationDao = new ScreenObservationDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        ScreenObservationDao r0 = this._screenObservationDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._screenObservationDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public ScreenStateDao getScreenStateDao() {
        if (this._screenStateDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._screenStateDao != null) goto L10;
        this._screenStateDao = new ScreenStateDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        ScreenStateDao r0 = this._screenStateDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._screenStateDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public ap getSemanticMemoryDao$database_obricRelease() {
        if (this._semanticMemoryDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._semanticMemoryDaoOld != null) goto L10;
        this._semanticMemoryDaoOld = new SemanticMemoryDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        ap r0 = this._semanticMemoryDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._semanticMemoryDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public au getSemanticMemoryHistoryRawDbDao$database_obricRelease() {
        if (this._unionSemanticMemoryHistoryRawDbDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._unionSemanticMemoryHistoryRawDbDaoOld != null) goto L10;
        this._unionSemanticMemoryHistoryRawDbDaoOld = new UnionSemanticMemoryHistoryRawDbDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        au r0 = this._unionSemanticMemoryHistoryRawDbDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._unionSemanticMemoryHistoryRawDbDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public aq getSemanticTextCopilotDao$database_obricRelease() {
        if (this._semanticTextCopilotDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._semanticTextCopilotDaoOld != null) goto L10;
        this._semanticTextCopilotDaoOld = new SemanticTextCopilotDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        aq r0 = this._semanticTextCopilotDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._semanticTextCopilotDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public SettingsChangedDao getSettingsChangedDao() {
        if (this._settingsChangedDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._settingsChangedDao != null) goto L10;
        this._settingsChangedDao = new SettingsChangedDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        SettingsChangedDao r0 = this._settingsChangedDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._settingsChangedDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public ar getSlmAgentWatermarkDao$database_obricRelease() {
        if (this._slmAgentWatermarkDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._slmAgentWatermarkDaoOld != null) goto L10;
        this._slmAgentWatermarkDaoOld = new SlmAgentWatermarkDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        ar r0 = this._slmAgentWatermarkDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._slmAgentWatermarkDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public as getSlmAutoMemoryProTempResultDao$database_obricRelease() {
        if (this._slmAutoMemoryProTempResultDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._slmAutoMemoryProTempResultDaoOld != null) goto L10;
        this._slmAutoMemoryProTempResultDaoOld = new SlmAutoMemoryProTempResultDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        as r0 = this._slmAutoMemoryProTempResultDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._slmAutoMemoryProTempResultDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public SpeakerEmbeddingPendingDao getSpeakerEmbeddingPendingDao() {
        if (this._speakerEmbeddingPendingDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._speakerEmbeddingPendingDao != null) goto L10;
        this._speakerEmbeddingPendingDao = new SpeakerEmbeddingPendingDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        SpeakerEmbeddingPendingDao r0 = this._speakerEmbeddingPendingDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._speakerEmbeddingPendingDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public StreamVolumeDao getStreamVolumeDao() {
        if (this._streamVolumeDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._streamVolumeDao != null) goto L10;
        this._streamVolumeDao = new StreamVolumeDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        StreamVolumeDao r0 = this._streamVolumeDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._streamVolumeDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public at getUnionSemanticMemoryExtDao$database_obricRelease() {
        if (this._unionSemanticMemoryExtDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._unionSemanticMemoryExtDaoOld != null) goto L10;
        this._unionSemanticMemoryExtDaoOld = new UnionSemanticMemoryExtDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        at r0 = this._unionSemanticMemoryExtDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._unionSemanticMemoryExtDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public av getUnionSemanticMemorySnapShotDao$database_obricRelease() {
        if (this._unionSemanticMemorySnapShotDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._unionSemanticMemorySnapShotDaoOld != null) goto L10;
        this._unionSemanticMemorySnapShotDaoOld = new UnionSemanticMemorySnapShotDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        av r0 = this._unionSemanticMemorySnapShotDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._unionSemanticMemorySnapShotDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public aw getUnionSemanticTypeSummaryDao$database_obricRelease() {
        if (this._unionSemanticTypeSummaryDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._unionSemanticTypeSummaryDaoOld != null) goto L10;
        this._unionSemanticTypeSummaryDaoOld = new UnionSemanticTypeSummaryDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        aw r0 = this._unionSemanticTypeSummaryDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._unionSemanticTypeSummaryDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public ax getUnionUserInsightDao$database_obricRelease() {
        if (this._unionUserInsightDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._unionUserInsightDaoOld != null) goto L10;
        this._unionUserInsightDaoOld = new UnionUserInsightDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        ax r0 = this._unionUserInsightDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._unionUserInsightDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public ay getUnionUserPersonaDao$database_obricRelease() {
        if (this._unionUserPersonaDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._unionUserPersonaDaoOld != null) goto L10;
        this._unionUserPersonaDaoOld = new UnionUserPersonaDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        ay r0 = this._unionUserPersonaDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._unionUserPersonaDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public az getUpdateProactiveSemanticRelevantDataDao$database_obricRelease() {
        if (this._updateProactiveSemanticRelevantDataDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._updateProactiveSemanticRelevantDataDaoOld != null) goto L10;
        this._updateProactiveSemanticRelevantDataDaoOld = new UpdateProactiveSemanticRelevantDataDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        az r0 = this._updateProactiveSemanticRelevantDataDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._updateProactiveSemanticRelevantDataDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public ba getUpdateUnionSemanticMemoryDao$database_obricRelease() {
        if (this._updateUnionSemanticMemoryDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._updateUnionSemanticMemoryDaoOld != null) goto L10;
        this._updateUnionSemanticMemoryDaoOld = new UpdateUnionSemanticMemoryDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        ba r0 = this._updateUnionSemanticMemoryDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._updateUnionSemanticMemoryDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public UploadDataDao getUploadDataDao() {
        if (this._uploadDataDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._uploadDataDao != null) goto L10;
        this._uploadDataDao = new UploadDataDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        UploadDataDao r0 = this._uploadDataDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._uploadDataDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public UserActionRecorderDao getUserActionRecorderDao() {
        if (this._userActionRecorderDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._userActionRecorderDao != null) goto L10;
        this._userActionRecorderDao = new UserActionRecorderDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        UserActionRecorderDao r0 = this._userActionRecorderDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._userActionRecorderDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public bb getUserKeywordDao$database_obricRelease() {
        if (this._userKeywordDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._userKeywordDaoOld != null) goto L10;
        this._userKeywordDaoOld = new UserKeywordDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        bb r0 = this._userKeywordDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._userKeywordDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public bc getUserProfileDao$database_obricRelease() {
        if (this._userProfileDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._userProfileDaoOld != null) goto L10;
        this._userProfileDaoOld = new UserProfileDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        bc r0 = this._userProfileDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._userProfileDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public bd getUserProfileMemoryDao$database_obricRelease() {
        if (this._userProfileMemoryDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._userProfileMemoryDaoOld != null) goto L10;
        this._userProfileMemoryDaoOld = new UserProfileMemoryDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        bd r0 = this._userProfileMemoryDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._userProfileMemoryDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public be getUserProfileRawDbDao$database_obricRelease() {
        if (this._userProfileRawDbDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._userProfileRawDbDaoOld != null) goto L10;
        this._userProfileRawDbDaoOld = new UserProfileRawDbDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        be r0 = this._userProfileRawDbDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._userProfileRawDbDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public bf getUserProfileTextVectorCopilotDao$database_obricRelease() {
        if (this._userProfileTextEntityTextVectorCopilotDaoOld != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._userProfileTextEntityTextVectorCopilotDaoOld != null) goto L10;
        this._userProfileTextEntityTextVectorCopilotDaoOld = new UserProfileTextEntityTextVectorCopilotDaoOld_Impl(this);     // Catch: Throwable -> L13
    L10:
        bf r0 = this._userProfileTextEntityTextVectorCopilotDaoOld;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._userProfileTextEntityTextVectorCopilotDaoOld;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public VideoFrameEntityImageVectorCopilotDao getVideoFrameImageVectorCopilotDao() {
        if (this._videoFrameEntityImageVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._videoFrameEntityImageVectorCopilotDao != null) goto L10;
        this._videoFrameEntityImageVectorCopilotDao = new VideoFrameEntityImageVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        VideoFrameEntityImageVectorCopilotDao r0 = this._videoFrameEntityImageVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._videoFrameEntityImageVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public VideoFrameRawDbDao getVideoFrameRawDbDao() {
        if (this._videoFrameRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._videoFrameRawDbDao != null) goto L10;
        this._videoFrameRawDbDao = new VideoFrameRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        VideoFrameRawDbDao r0 = this._videoFrameRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._videoFrameRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public VideoFrameEntityTextVectorCopilotDao getVideoFrameTextVectorCopilotDao() {
        if (this._videoFrameEntityTextVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._videoFrameEntityTextVectorCopilotDao != null) goto L10;
        this._videoFrameEntityTextVectorCopilotDao = new VideoFrameEntityTextVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        VideoFrameEntityTextVectorCopilotDao r0 = this._videoFrameEntityTextVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._videoFrameEntityTextVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public WifiDao getWifiDao() {
        if (this._wifiDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._wifiDao != null) goto L10;
        this._wifiDao = new WifiDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        WifiDao r0 = this._wifiDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._wifiDao;
    }

    @Override // com.obric.memorydata.database.manager.MemoryFrameDb
    public WifiListDao getWifiListDao() {
        if (this._wifiListDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._wifiListDao != null) goto L10;
        this._wifiListDao = new WifiListDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        WifiListDao r0 = this._wifiListDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._wifiListDao;
    }
}
