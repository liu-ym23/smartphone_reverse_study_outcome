package com.obric.memorydata.database.manager;

import android.os.Build;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.obric.memorydata.database.dao.AgentWatermarkDao;
import com.obric.memorydata.database.dao.AgentWatermarkDao_Impl;
import com.obric.memorydata.database.dao.AssistantChatDao;
import com.obric.memorydata.database.dao.AssistantChatDao_Impl;
import com.obric.memorydata.database.dao.AssistantChatMessageDao;
import com.obric.memorydata.database.dao.AssistantChatMessageDao_Impl;
import com.obric.memorydata.database.dao.AutoMemoryEpisodicRelevantDataDao;
import com.obric.memorydata.database.dao.AutoMemoryEpisodicRelevantDataDao_Impl;
import com.obric.memorydata.database.dao.AutoMemoryProDao;
import com.obric.memorydata.database.dao.AutoMemoryProDao_Impl;
import com.obric.memorydata.database.dao.AutoMemoryProEvaluationStatsDao;
import com.obric.memorydata.database.dao.AutoMemoryProEvaluationStatsDao_Impl;
import com.obric.memorydata.database.dao.AutoMemoryProHistoryRawDbDao;
import com.obric.memorydata.database.dao.AutoMemoryProHistoryRawDbDao_Impl;
import com.obric.memorydata.database.dao.AutoMemoryProRawSourceDao;
import com.obric.memorydata.database.dao.AutoMemoryProRawSourceDao_Impl;
import com.obric.memorydata.database.dao.AutoMemoryProSlmEpisodicMemoryDao;
import com.obric.memorydata.database.dao.AutoMemoryProSlmEpisodicMemoryDao_Impl;
import com.obric.memorydata.database.dao.AutoMemoryProSlmPersonalInfoDao;
import com.obric.memorydata.database.dao.AutoMemoryProSlmPersonalInfoDao_Impl;
import com.obric.memorydata.database.dao.AutoMemoryProSnapShotDao;
import com.obric.memorydata.database.dao.AutoMemoryProSnapShotDao_Impl;
import com.obric.memorydata.database.dao.AutoMemoryProTextEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.AutoMemoryProTextEntityTextVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.AutoMemorySemanticRelevantDataDao;
import com.obric.memorydata.database.dao.AutoMemorySemanticRelevantDataDao_Impl;
import com.obric.memorydata.database.dao.BlockMemoryContentDao;
import com.obric.memorydata.database.dao.BlockMemoryContentDao_Impl;
import com.obric.memorydata.database.dao.ComplexRecommendQueryDao;
import com.obric.memorydata.database.dao.ComplexRecommendQueryDao_Impl;
import com.obric.memorydata.database.dao.EntityIndexLifecycleDao;
import com.obric.memorydata.database.dao.EntityIndexLifecycleDao_PersonalMemoryFrameDb_Impl;
import com.obric.memorydata.database.dao.EpisodicMemoryContentTimeDao;
import com.obric.memorydata.database.dao.EpisodicMemoryContentTimeDao_Impl;
import com.obric.memorydata.database.dao.EpisodicMemoryDao;
import com.obric.memorydata.database.dao.EpisodicMemoryDao_Impl;
import com.obric.memorydata.database.dao.EpisodicMemoryHistoryRawDbDao;
import com.obric.memorydata.database.dao.EpisodicMemoryHistoryRawDbDao_Impl;
import com.obric.memorydata.database.dao.EpisodicMemoryTextVectorCopilotDao;
import com.obric.memorydata.database.dao.EpisodicMemoryTextVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.EpisodicTopicMemoryDao;
import com.obric.memorydata.database.dao.EpisodicTopicMemoryDao_Impl;
import com.obric.memorydata.database.dao.EpisodicTopicMemoryHistoryRawDbDao;
import com.obric.memorydata.database.dao.EpisodicTopicMemoryHistoryRawDbDao_Impl;
import com.obric.memorydata.database.dao.EpisodicTopicMemoryTextVectorCopilotDao;
import com.obric.memorydata.database.dao.EpisodicTopicMemoryTextVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.GlassesEpisodicRelevantDataDao;
import com.obric.memorydata.database.dao.GlassesEpisodicRelevantDataDao_Impl;
import com.obric.memorydata.database.dao.IndexPendingDao;
import com.obric.memorydata.database.dao.IndexPendingDao_PersonalMemoryFrameDb_Impl;
import com.obric.memorydata.database.dao.LifeLogTextEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.LifeLogTextEntityTextVectorCopilotDao_Impl;
import com.obric.memorydata.database.dao.LifelogDao;
import com.obric.memorydata.database.dao.LifelogDao_Impl;
import com.obric.memorydata.database.dao.LifelogHistoryRawDbDao;
import com.obric.memorydata.database.dao.LifelogHistoryRawDbDao_Impl;
import com.obric.memorydata.database.dao.MemoryBaseRequirementDao;
import com.obric.memorydata.database.dao.MemoryBaseRequirementDao_Impl;
import com.obric.memorydata.database.dao.MemoryBaseSceneDao;
import com.obric.memorydata.database.dao.MemoryBaseSceneDao_Impl;
import com.obric.memorydata.database.dao.MemoryContextSyncDao;
import com.obric.memorydata.database.dao.MemoryContextSyncDao_Impl;
import com.obric.memorydata.database.dao.MemoryEntityCorrelationDao;
import com.obric.memorydata.database.dao.MemoryEntityCorrelationDao_Impl;
import com.obric.memorydata.database.dao.MemoryEntityToCalendarDao;
import com.obric.memorydata.database.dao.MemoryEntityToCalendarDao_Impl;
import com.obric.memorydata.database.dao.MemoryKeyInfoDao;
import com.obric.memorydata.database.dao.MemoryKeyInfoDao_Impl;
import com.obric.memorydata.database.dao.MemoryProcessUserInsightDao;
import com.obric.memorydata.database.dao.MemoryProcessUserInsightDao_Impl;
import com.obric.memorydata.database.dao.MemoryReviewFeedbackDao;
import com.obric.memorydata.database.dao.MemoryReviewFeedbackDao_Impl;
import com.obric.memorydata.database.dao.MemoryRuleDao;
import com.obric.memorydata.database.dao.MemoryRuleDao_Impl;
import com.obric.memorydata.database.dao.MemorySourceEpisodicImageRelationDao;
import com.obric.memorydata.database.dao.MemorySourceEpisodicImageRelationDao_Impl;
import com.obric.memorydata.database.dao.MemorySourceImageRelationDao;
import com.obric.memorydata.database.dao.MemorySourceImageRelationDao_Impl;
import com.obric.memorydata.database.dao.MemorySourceSemanticImageRelationDao;
import com.obric.memorydata.database.dao.MemorySourceSemanticImageRelationDao_Impl;
import com.obric.memorydata.database.dao.MemorySynthesisDao;
import com.obric.memorydata.database.dao.MemorySynthesisDao_Impl;
import com.obric.memorydata.database.dao.MiddleUserProfileDao;
import com.obric.memorydata.database.dao.MiddleUserProfileDao_Impl;
import com.obric.memorydata.database.dao.PendingContextDao;
import com.obric.memorydata.database.dao.PendingContextDao_Impl;
import com.obric.memorydata.database.dao.PendingEpisodicDao;
import com.obric.memorydata.database.dao.PendingEpisodicDao_Impl;
import com.obric.memorydata.database.dao.PendingMemoryCalendarDao;
import com.obric.memorydata.database.dao.PendingMemoryCalendarDao_Impl;
import com.obric.memorydata.database.dao.PendingSemanticDao;
import com.obric.memorydata.database.dao.PendingSemanticDao_Impl;
import com.obric.memorydata.database.dao.PersonAudioProfileDao;
import com.obric.memorydata.database.dao.PersonAudioProfileDao_Impl;
import com.obric.memorydata.database.dao.PersonImageProfileDao;
import com.obric.memorydata.database.dao.PersonImageProfileDao_Impl;
import com.obric.memorydata.database.dao.PersonProfileDao;
import com.obric.memorydata.database.dao.PersonProfileDao_Impl;
import com.obric.memorydata.database.dao.ProactiveEpisodicRelevantDataDao;
import com.obric.memorydata.database.dao.ProactiveEpisodicRelevantDataDao_Impl;
import com.obric.memorydata.database.dao.ProactiveSemanticRelevantDataDao;
import com.obric.memorydata.database.dao.ProactiveSemanticRelevantDataDao_Impl;
import com.obric.memorydata.database.dao.RawUserProfileHistoryRawDbDao;
import com.obric.memorydata.database.dao.RawUserProfileHistoryRawDbDao_Impl;
import com.obric.memorydata.database.dao.SemanticMemoryDao;
import com.obric.memorydata.database.dao.SemanticMemoryDao_Impl;
import com.obric.memorydata.database.dao.SemanticRetractionDao;
import com.obric.memorydata.database.dao.SemanticRetractionDao_Impl;
import com.obric.memorydata.database.dao.SemanticStateDao;
import com.obric.memorydata.database.dao.SemanticStateDao_Impl;
import com.obric.memorydata.database.dao.SemanticTextCopilotDao;
import com.obric.memorydata.database.dao.SemanticTextCopilotDao_Impl;
import com.obric.memorydata.database.dao.SlmAgentWatermarkDao;
import com.obric.memorydata.database.dao.SlmAgentWatermarkDao_Impl;
import com.obric.memorydata.database.dao.SlmAutoMemoryProTempResultDao;
import com.obric.memorydata.database.dao.SlmAutoMemoryProTempResultDao_Impl;
import com.obric.memorydata.database.dao.UnionSemanticMemoryExtDao;
import com.obric.memorydata.database.dao.UnionSemanticMemoryExtDao_Impl;
import com.obric.memorydata.database.dao.UnionSemanticMemorySnapShotDao;
import com.obric.memorydata.database.dao.UnionSemanticMemorySnapShotDao_Impl;
import com.obric.memorydata.database.dao.UnionSemanticTypeSummaryDao;
import com.obric.memorydata.database.dao.UnionSemanticTypeSummaryDao_Impl;
import com.obric.memorydata.database.dao.UnionUserInsightDao;
import com.obric.memorydata.database.dao.UnionUserInsightDao_Impl;
import com.obric.memorydata.database.dao.UnionUserPersonaDao;
import com.obric.memorydata.database.dao.UnionUserPersonaDao_Impl;
import com.obric.memorydata.database.dao.UpdateProactiveSemanticRelevantDataDao;
import com.obric.memorydata.database.dao.UpdateProactiveSemanticRelevantDataDao_Impl;
import com.obric.memorydata.database.dao.UpdateUnionSemanticMemoryDao;
import com.obric.memorydata.database.dao.UpdateUnionSemanticMemoryDao_Impl;
import com.obric.memorydata.database.dao.UserKeywordDao;
import com.obric.memorydata.database.dao.UserKeywordDao_Impl;
import com.obric.memorydata.database.dao.UserKeywordRefDao;
import com.obric.memorydata.database.dao.UserKeywordRefDao_Impl;
import com.obric.memorydata.database.dao.UserProfileDao;
import com.obric.memorydata.database.dao.UserProfileDao_Impl;
import com.obric.memorydata.database.dao.UserProfileMemoryDao;
import com.obric.memorydata.database.dao.UserProfileMemoryDao_Impl;
import com.obric.memorydata.database.dao.UserProfileRawDbDao;
import com.obric.memorydata.database.dao.UserProfileRawDbDao_Impl;
import com.obric.memorydata.database.dao.UserProfileTextEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.UserProfileTextEntityTextVectorCopilotDao_Impl;
import com.obric.memorydata.database.entity.UnionSemanticMemoryHistoryRawDbDao_Impl;
import com.obric.memorydata.database.entity.it;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class PersonalMemoryFrameDb_Impl extends PersonalMemoryFrameDb {
    private volatile AgentWatermarkDao _agentWatermarkDao;
    private volatile AssistantChatDao _assistantChatDao;
    private volatile AssistantChatMessageDao _assistantChatMessageDao;
    private volatile AutoMemoryEpisodicRelevantDataDao _autoMemoryEpisodicRelevantDataDao;
    private volatile AutoMemoryProDao _autoMemoryProDao;
    private volatile AutoMemoryProEvaluationStatsDao _autoMemoryProEvaluationStatsDao;
    private volatile AutoMemoryProHistoryRawDbDao _autoMemoryProHistoryRawDbDao;
    private volatile AutoMemoryProRawSourceDao _autoMemoryProRawSourceDao;
    private volatile AutoMemoryProSlmEpisodicMemoryDao _autoMemoryProSlmEpisodicMemoryDao;
    private volatile AutoMemoryProSlmPersonalInfoDao _autoMemoryProSlmPersonalInfoDao;
    private volatile AutoMemoryProSnapShotDao _autoMemoryProSnapShotDao;
    private volatile AutoMemoryProTextEntityTextVectorCopilotDao _autoMemoryProTextEntityTextVectorCopilotDao;
    private volatile AutoMemorySemanticRelevantDataDao _autoMemorySemanticRelevantDataDao;
    private volatile BlockMemoryContentDao _blockMemoryContentDao;
    private volatile ComplexRecommendQueryDao _complexRecommendQueryDao;
    private volatile EntityIndexLifecycleDao _entityIndexLifecycleDao;
    private volatile EpisodicMemoryContentTimeDao _episodicMemoryContentTimeDao;
    private volatile EpisodicMemoryDao _episodicMemoryDao;
    private volatile EpisodicMemoryHistoryRawDbDao _episodicMemoryHistoryRawDbDao;
    private volatile EpisodicMemoryTextVectorCopilotDao _episodicMemoryTextVectorCopilotDao;
    private volatile EpisodicTopicMemoryDao _episodicTopicMemoryDao;
    private volatile EpisodicTopicMemoryHistoryRawDbDao _episodicTopicMemoryHistoryRawDbDao;
    private volatile EpisodicTopicMemoryTextVectorCopilotDao _episodicTopicMemoryTextVectorCopilotDao;
    private volatile GlassesEpisodicRelevantDataDao _glassesEpisodicRelevantDataDao;
    private volatile IndexPendingDao _indexPendingDao;
    private volatile LifeLogTextEntityTextVectorCopilotDao _lifeLogTextEntityTextVectorCopilotDao;
    private volatile LifelogDao _lifelogDao;
    private volatile LifelogHistoryRawDbDao _lifelogHistoryRawDbDao;
    private volatile MemoryBaseRequirementDao _memoryBaseRequirementDao;
    private volatile MemoryBaseSceneDao _memoryBaseSceneDao;
    private volatile MemoryContextSyncDao _memoryContextSyncDao;
    private volatile MemoryEntityCorrelationDao _memoryEntityCorrelationDao;
    private volatile MemoryEntityToCalendarDao _memoryEntityToCalendarDao;
    private volatile MemoryKeyInfoDao _memoryKeyInfoDao;
    private volatile MemoryProcessUserInsightDao _memoryProcessUserInsightDao;
    private volatile MemoryReviewFeedbackDao _memoryReviewFeedbackDao;
    private volatile MemoryRuleDao _memoryRuleDao;
    private volatile MemorySourceEpisodicImageRelationDao _memorySourceEpisodicImageRelationDao;
    private volatile MemorySourceImageRelationDao _memorySourceImageRelationDao;
    private volatile MemorySourceSemanticImageRelationDao _memorySourceSemanticImageRelationDao;
    private volatile MemorySynthesisDao _memorySynthesisDao;
    private volatile MiddleUserProfileDao _middleUserProfileDao;
    private volatile PendingContextDao _pendingContextDao;
    private volatile PendingEpisodicDao _pendingEpisodicDao;
    private volatile PendingMemoryCalendarDao _pendingMemoryCalendarDao;
    private volatile PendingSemanticDao _pendingSemanticDao;
    private volatile PersonAudioProfileDao _personAudioProfileDao;
    private volatile PersonImageProfileDao _personImageProfileDao;
    private volatile PersonProfileDao _personProfileDao;
    private volatile ProactiveEpisodicRelevantDataDao _proactiveEpisodicRelevantDataDao;
    private volatile ProactiveSemanticRelevantDataDao _proactiveSemanticRelevantDataDao;
    private volatile RawUserProfileHistoryRawDbDao _rawUserProfileHistoryRawDbDao;
    private volatile SemanticMemoryDao _semanticMemoryDao;
    private volatile SemanticRetractionDao _semanticRetractionDao;
    private volatile SemanticStateDao _semanticStateDao;
    private volatile SemanticTextCopilotDao _semanticTextCopilotDao;
    private volatile SlmAgentWatermarkDao _slmAgentWatermarkDao;
    private volatile SlmAutoMemoryProTempResultDao _slmAutoMemoryProTempResultDao;
    private volatile UnionSemanticMemoryExtDao _unionSemanticMemoryExtDao;
    private volatile it _unionSemanticMemoryHistoryRawDbDao;
    private volatile UnionSemanticMemorySnapShotDao _unionSemanticMemorySnapShotDao;
    private volatile UnionSemanticTypeSummaryDao _unionSemanticTypeSummaryDao;
    private volatile UnionUserInsightDao _unionUserInsightDao;
    private volatile UnionUserPersonaDao _unionUserPersonaDao;
    private volatile UpdateProactiveSemanticRelevantDataDao _updateProactiveSemanticRelevantDataDao;
    private volatile UpdateUnionSemanticMemoryDao _updateUnionSemanticMemoryDao;
    private volatile UserKeywordDao _userKeywordDao;
    private volatile UserKeywordRefDao _userKeywordRefDao;
    private volatile UserProfileDao _userProfileDao;
    private volatile UserProfileMemoryDao _userProfileMemoryDao;
    private volatile UserProfileRawDbDao _userProfileRawDbDao;
    private volatile UserProfileTextEntityTextVectorCopilotDao _userProfileTextEntityTextVectorCopilotDao;

    public PersonalMemoryFrameDb_Impl() {
    }

    static /* synthetic */ List access$000(PersonalMemoryFrameDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$100(PersonalMemoryFrameDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$1000(PersonalMemoryFrameDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$200(PersonalMemoryFrameDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$300(PersonalMemoryFrameDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$400(PersonalMemoryFrameDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$500(PersonalMemoryFrameDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ SupportSQLiteDatabase access$602(PersonalMemoryFrameDb_Impl r2, SupportSQLiteDatabase r3) {
        SupportSQLiteDatabase r4 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        r2.mDatabase = r4;
        return r4;
    }

    static /* synthetic */ void access$700(PersonalMemoryFrameDb_Impl r2, SupportSQLiteDatabase r3) {
        r2.internalInitInvalidationTracker((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ List access$800(PersonalMemoryFrameDb_Impl r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ List access$900(PersonalMemoryFrameDb_Impl r0) {
        return r0.mCallbacks;
    }

    @Override // androidx.room.RoomDatabase
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
        r0.execSQL("DELETE FROM `AgentWatermark`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AssistantChatEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AssistantChatMessageEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AppEntityIndexPending`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `EntityIndexLifecycle`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AutoMemoryEpisodicRelevantData`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AutoMemoryPro`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AutoMemoryProEvaluationStats`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AutoMemoryProHistoryEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AutoMemoryProRawSource`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AutoMemoryProSnapShot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AutoMemoryProSlmEpisodicMemory`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AutoMemoryProSlmPersonalInfo`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AutoMemoryProTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `AutoMemorySemanticRelevantData`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `BlockMemoryContent`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `ComplexRecommendQuery`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MemorySynthesisRun`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MemorySynthesisTaskCard`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `ShortMemory`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `EpisodicMemoryHistoryEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `ShortMemoryTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `EpisodicTopicMemory`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `EpisodicTopicMemoryHistoryEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `EpisodicTopicMemoryTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `GlassesEpisodicRelevantData`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `Lifelog`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `LifelogHistoryEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `LifeLogEntityTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MemoryBaseScene`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MemoryBaseRequirement`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawMemoryEntityCorrelation`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MemoryEntityToCalendar`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MemoryKeyInfoEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MemoryReviewFeedback`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MemoryContextSyncPending`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MemoryContextSyncState`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MemoryRule`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MemorySourceEpisodicImageRelation`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MemorySourceSemanticImageRelation`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MiddleUserProfile`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `MemoryProcessUserInsight`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `PendingContext`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `PendingEpisodic`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `PendingMemoryCalendar`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `PendingSemantic`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `PersonAudioProfile`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `PersonImageProfile`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `PersonProfile`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `ProactiveEpisodicRelevantData`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `ProactiveSemanticRelevantData`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawUserProfileEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `RawUserProfileHistoryEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `SemanticRetraction`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `SemanticState`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `SemanticTextCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `ShortMemoryContentTime`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `SlmAgentWatermark`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `SlmAutoMemoryProTempResult`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `UnionSemanticMemory`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `UnionSemanticMemoryExt`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `UnionSemanticMemoryHistoryEntity`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `UnionSemanticMemorySnapShot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `UnionSemanticTypeSummary`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `UnionUserInsight`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `UnionUserPersona`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `UpdateProactiveSemanticRelevantData`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `UpdateUnionSemanticMemory`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `UserKeyword`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `UserKeywordRef`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `UserProfile`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `UserProfileEntityTextVectorCopilot`");     // Catch: Throwable -> L20
        r0.execSQL("DELETE FROM `UserProfileMemoryEntity`");     // Catch: Throwable -> L20
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"AgentWatermark", "AssistantChatEntity", "AssistantChatMessageEntity", "AppEntityIndexPending", "EntityIndexLifecycle", "AutoMemoryEpisodicRelevantData", "AutoMemoryPro", "AutoMemoryProEvaluationStats", "AutoMemoryProHistoryEntity", "AutoMemoryProRawSource", "AutoMemoryProSnapShot", "AutoMemoryProSlmEpisodicMemory", "AutoMemoryProSlmPersonalInfo", "AutoMemoryProTextVectorCopilot", "AutoMemorySemanticRelevantData", "BlockMemoryContent", "ComplexRecommendQuery", "MemorySynthesisRun", "MemorySynthesisTaskCard", "ShortMemory", "EpisodicMemoryHistoryEntity", "ShortMemoryTextVectorCopilot", "EpisodicTopicMemory", "EpisodicTopicMemoryHistoryEntity", "EpisodicTopicMemoryTextVectorCopilot", "GlassesEpisodicRelevantData", "Lifelog", "LifelogHistoryEntity", "LifeLogEntityTextVectorCopilot", "MemoryBaseScene", "MemoryBaseRequirement", "RawMemoryEntityCorrelation", "MemoryEntityToCalendar", "MemoryKeyInfoEntity", "MemoryReviewFeedback", "MemoryContextSyncPending", "MemoryContextSyncState", "MemoryRule", "MemorySourceEpisodicImageRelation", "MemorySourceSemanticImageRelation", "MiddleUserProfile", "MemoryProcessUserInsight", "PendingContext", "PendingEpisodic", "PendingMemoryCalendar", "PendingSemantic", "PersonAudioProfile", "PersonImageProfile", "PersonProfile", "ProactiveEpisodicRelevantData", "ProactiveSemanticRelevantData", "RawUserProfileEntity", "RawUserProfileHistoryEntity", "SemanticRetraction", "SemanticState", "SemanticTextCopilot", "ShortMemoryContentTime", "SlmAgentWatermark", "SlmAutoMemoryProTempResult", "UnionSemanticMemory", "UnionSemanticMemoryExt", "UnionSemanticMemoryHistoryEntity", "UnionSemanticMemorySnapShot", "UnionSemanticTypeSummary", "UnionUserInsight", "UnionUserPersona", "UpdateProactiveSemanticRelevantData", "UpdateUnionSemanticMemory", "UserKeyword", "UserKeywordRef", "UserProfile", "UserProfileEntityTextVectorCopilot", "UserProfileMemoryEntity"});
    }

    @Override // androidx.room.RoomDatabase
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r4) {
        final int r2 = 14;
        RoomOpenHelper r0 = new RoomOpenHelper(r4, new AnonymousClass1(this, r2), "8e6a1af3b1e26adf1a62e8ce0675373a", "b37c92e04c8e1c1dc6eb59fca2551a02");
        SupportSQLiteOpenHelper.Configuration r3 = SupportSQLiteOpenHelper.Configuration.builder(r4.context).name(r4.name).callback(r0).build();
        return r4.sqliteOpenHelperFactory.create(r3);
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public AgentWatermarkDao getAgentWatermarkDao() {
        if (this._agentWatermarkDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._agentWatermarkDao != null) goto L10;
        this._agentWatermarkDao = new AgentWatermarkDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        AgentWatermarkDao r0 = this._agentWatermarkDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._agentWatermarkDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public AssistantChatDao getAssistantChatDao() {
        if (this._assistantChatDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._assistantChatDao != null) goto L10;
        this._assistantChatDao = new AssistantChatDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        AssistantChatDao r0 = this._assistantChatDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._assistantChatDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public AssistantChatMessageDao getAssistantChatMessageDao() {
        if (this._assistantChatMessageDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._assistantChatMessageDao != null) goto L10;
        this._assistantChatMessageDao = new AssistantChatMessageDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        AssistantChatMessageDao r0 = this._assistantChatMessageDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._assistantChatMessageDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public AutoMemoryEpisodicRelevantDataDao getAutoMemoryEpisodicRelevantDataDao() {
        if (this._autoMemoryEpisodicRelevantDataDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._autoMemoryEpisodicRelevantDataDao != null) goto L10;
        this._autoMemoryEpisodicRelevantDataDao = new AutoMemoryEpisodicRelevantDataDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        AutoMemoryEpisodicRelevantDataDao r0 = this._autoMemoryEpisodicRelevantDataDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._autoMemoryEpisodicRelevantDataDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public AutoMemoryProDao getAutoMemoryProDao() {
        if (this._autoMemoryProDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._autoMemoryProDao != null) goto L10;
        this._autoMemoryProDao = new AutoMemoryProDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        AutoMemoryProDao r0 = this._autoMemoryProDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._autoMemoryProDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public AutoMemoryProEvaluationStatsDao getAutoMemoryProEvaluationStatsDao() {
        if (this._autoMemoryProEvaluationStatsDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._autoMemoryProEvaluationStatsDao != null) goto L10;
        this._autoMemoryProEvaluationStatsDao = new AutoMemoryProEvaluationStatsDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        AutoMemoryProEvaluationStatsDao r0 = this._autoMemoryProEvaluationStatsDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._autoMemoryProEvaluationStatsDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public AutoMemoryProHistoryRawDbDao getAutoMemoryProHistoryRawDbDao() {
        if (this._autoMemoryProHistoryRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._autoMemoryProHistoryRawDbDao != null) goto L10;
        this._autoMemoryProHistoryRawDbDao = new AutoMemoryProHistoryRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        AutoMemoryProHistoryRawDbDao r0 = this._autoMemoryProHistoryRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._autoMemoryProHistoryRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public AutoMemoryProRawSourceDao getAutoMemoryProRawSourceDao() {
        if (this._autoMemoryProRawSourceDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._autoMemoryProRawSourceDao != null) goto L10;
        this._autoMemoryProRawSourceDao = new AutoMemoryProRawSourceDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        AutoMemoryProRawSourceDao r0 = this._autoMemoryProRawSourceDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._autoMemoryProRawSourceDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public AutoMemoryProSlmEpisodicMemoryDao getAutoMemoryProSlmEpisodicMemoryDao() {
        if (this._autoMemoryProSlmEpisodicMemoryDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._autoMemoryProSlmEpisodicMemoryDao != null) goto L10;
        this._autoMemoryProSlmEpisodicMemoryDao = new AutoMemoryProSlmEpisodicMemoryDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        AutoMemoryProSlmEpisodicMemoryDao r0 = this._autoMemoryProSlmEpisodicMemoryDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._autoMemoryProSlmEpisodicMemoryDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public AutoMemoryProSlmPersonalInfoDao getAutoMemoryProSlmPersonalInfoDao() {
        if (this._autoMemoryProSlmPersonalInfoDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._autoMemoryProSlmPersonalInfoDao != null) goto L10;
        this._autoMemoryProSlmPersonalInfoDao = new AutoMemoryProSlmPersonalInfoDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        AutoMemoryProSlmPersonalInfoDao r0 = this._autoMemoryProSlmPersonalInfoDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._autoMemoryProSlmPersonalInfoDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public AutoMemoryProSnapShotDao getAutoMemoryProSnapShotDao() {
        if (this._autoMemoryProSnapShotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._autoMemoryProSnapShotDao != null) goto L10;
        this._autoMemoryProSnapShotDao = new AutoMemoryProSnapShotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        AutoMemoryProSnapShotDao r0 = this._autoMemoryProSnapShotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._autoMemoryProSnapShotDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public AutoMemoryProTextEntityTextVectorCopilotDao getAutoMemoryProTextVectorCopilotDao() {
        if (this._autoMemoryProTextEntityTextVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._autoMemoryProTextEntityTextVectorCopilotDao != null) goto L10;
        this._autoMemoryProTextEntityTextVectorCopilotDao = new AutoMemoryProTextEntityTextVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        AutoMemoryProTextEntityTextVectorCopilotDao r0 = this._autoMemoryProTextEntityTextVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._autoMemoryProTextEntityTextVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public AutoMemorySemanticRelevantDataDao getAutoMemorySemanticRelevantDataDao() {
        if (this._autoMemorySemanticRelevantDataDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._autoMemorySemanticRelevantDataDao != null) goto L10;
        this._autoMemorySemanticRelevantDataDao = new AutoMemorySemanticRelevantDataDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        AutoMemorySemanticRelevantDataDao r0 = this._autoMemorySemanticRelevantDataDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._autoMemorySemanticRelevantDataDao;
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> r2) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        return Arrays.asList(new Migration[]{new PersonalMemoryFrameDb_AutoMigration_1_2_Impl(), new PersonalMemoryFrameDb_AutoMigration_2_3_Impl(), new PersonalMemoryFrameDb_AutoMigration_3_4_Impl(), new PersonalMemoryFrameDb_AutoMigration_4_5_Impl(), new PersonalMemoryFrameDb_AutoMigration_5_6_Impl(), new PersonalMemoryFrameDb_AutoMigration_6_7_Impl(), new PersonalMemoryFrameDb_AutoMigration_7_8_Impl(), new PersonalMemoryFrameDb_AutoMigration_8_9_Impl(), new PersonalMemoryFrameDb_AutoMigration_9_10_Impl(), new PersonalMemoryFrameDb_AutoMigration_11_12_Impl()});
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public BlockMemoryContentDao getBlockMemoryContentDao() {
        if (this._blockMemoryContentDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._blockMemoryContentDao != null) goto L10;
        this._blockMemoryContentDao = new BlockMemoryContentDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        BlockMemoryContentDao r0 = this._blockMemoryContentDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._blockMemoryContentDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public ComplexRecommendQueryDao getComplexRecommendQueryDao() {
        if (this._complexRecommendQueryDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._complexRecommendQueryDao != null) goto L10;
        this._complexRecommendQueryDao = new ComplexRecommendQueryDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        ComplexRecommendQueryDao r0 = this._complexRecommendQueryDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._complexRecommendQueryDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public EntityIndexLifecycleDao getEntityIndexLifecycleDao() {
        if (this._entityIndexLifecycleDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._entityIndexLifecycleDao != null) goto L10;
        this._entityIndexLifecycleDao = new EntityIndexLifecycleDao_PersonalMemoryFrameDb_Impl(this);     // Catch: Throwable -> L13
    L10:
        EntityIndexLifecycleDao r0 = this._entityIndexLifecycleDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._entityIndexLifecycleDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public EpisodicMemoryContentTimeDao getEpisodicMemoryContentTimeDao() {
        if (this._episodicMemoryContentTimeDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._episodicMemoryContentTimeDao != null) goto L10;
        this._episodicMemoryContentTimeDao = new EpisodicMemoryContentTimeDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        EpisodicMemoryContentTimeDao r0 = this._episodicMemoryContentTimeDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._episodicMemoryContentTimeDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public EpisodicMemoryDao getEpisodicMemoryDao() {
        if (this._episodicMemoryDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._episodicMemoryDao != null) goto L10;
        this._episodicMemoryDao = new EpisodicMemoryDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        EpisodicMemoryDao r0 = this._episodicMemoryDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._episodicMemoryDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public EpisodicMemoryHistoryRawDbDao getEpisodicMemoryHistoryRawDbDao() {
        if (this._episodicMemoryHistoryRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._episodicMemoryHistoryRawDbDao != null) goto L10;
        this._episodicMemoryHistoryRawDbDao = new EpisodicMemoryHistoryRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        EpisodicMemoryHistoryRawDbDao r0 = this._episodicMemoryHistoryRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._episodicMemoryHistoryRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public EpisodicMemoryTextVectorCopilotDao getEpisodicMemoryTextVectorCopilotDao() {
        if (this._episodicMemoryTextVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._episodicMemoryTextVectorCopilotDao != null) goto L10;
        this._episodicMemoryTextVectorCopilotDao = new EpisodicMemoryTextVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        EpisodicMemoryTextVectorCopilotDao r0 = this._episodicMemoryTextVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._episodicMemoryTextVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public EpisodicTopicMemoryDao getEpisodicTopicMemoryDao() {
        if (this._episodicTopicMemoryDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._episodicTopicMemoryDao != null) goto L10;
        this._episodicTopicMemoryDao = new EpisodicTopicMemoryDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        EpisodicTopicMemoryDao r0 = this._episodicTopicMemoryDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._episodicTopicMemoryDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public EpisodicTopicMemoryHistoryRawDbDao getEpisodicTopicMemoryHistoryRawDbDao() {
        if (this._episodicTopicMemoryHistoryRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._episodicTopicMemoryHistoryRawDbDao != null) goto L10;
        this._episodicTopicMemoryHistoryRawDbDao = new EpisodicTopicMemoryHistoryRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        EpisodicTopicMemoryHistoryRawDbDao r0 = this._episodicTopicMemoryHistoryRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._episodicTopicMemoryHistoryRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public EpisodicTopicMemoryTextVectorCopilotDao getEpisodicTopicMemoryTextVectorCopilotDao() {
        if (this._episodicTopicMemoryTextVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._episodicTopicMemoryTextVectorCopilotDao != null) goto L10;
        this._episodicTopicMemoryTextVectorCopilotDao = new EpisodicTopicMemoryTextVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        EpisodicTopicMemoryTextVectorCopilotDao r0 = this._episodicTopicMemoryTextVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._episodicTopicMemoryTextVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public GlassesEpisodicRelevantDataDao getGlassesEpisodicRelevantDataDao() {
        if (this._glassesEpisodicRelevantDataDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._glassesEpisodicRelevantDataDao != null) goto L10;
        this._glassesEpisodicRelevantDataDao = new GlassesEpisodicRelevantDataDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        GlassesEpisodicRelevantDataDao r0 = this._glassesEpisodicRelevantDataDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._glassesEpisodicRelevantDataDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public IndexPendingDao getIndexPendingDao() {
        if (this._indexPendingDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._indexPendingDao != null) goto L10;
        this._indexPendingDao = new IndexPendingDao_PersonalMemoryFrameDb_Impl(this);     // Catch: Throwable -> L13
    L10:
        IndexPendingDao r0 = this._indexPendingDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._indexPendingDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public LifeLogTextEntityTextVectorCopilotDao getLifeLogTextVectorCopilotDao() {
        if (this._lifeLogTextEntityTextVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._lifeLogTextEntityTextVectorCopilotDao != null) goto L10;
        this._lifeLogTextEntityTextVectorCopilotDao = new LifeLogTextEntityTextVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        LifeLogTextEntityTextVectorCopilotDao r0 = this._lifeLogTextEntityTextVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._lifeLogTextEntityTextVectorCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public LifelogDao getLifelogDao() {
        if (this._lifelogDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._lifelogDao != null) goto L10;
        this._lifelogDao = new LifelogDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        LifelogDao r0 = this._lifelogDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._lifelogDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public LifelogHistoryRawDbDao getLifelogHistoryRawDbDao() {
        if (this._lifelogHistoryRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._lifelogHistoryRawDbDao != null) goto L10;
        this._lifelogHistoryRawDbDao = new LifelogHistoryRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        LifelogHistoryRawDbDao r0 = this._lifelogHistoryRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._lifelogHistoryRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public MemoryBaseRequirementDao getMemoryBaseRequirementDao() {
        if (this._memoryBaseRequirementDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memoryBaseRequirementDao != null) goto L10;
        this._memoryBaseRequirementDao = new MemoryBaseRequirementDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MemoryBaseRequirementDao r0 = this._memoryBaseRequirementDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memoryBaseRequirementDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public MemoryBaseSceneDao getMemoryBaseSceneDao() {
        if (this._memoryBaseSceneDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memoryBaseSceneDao != null) goto L10;
        this._memoryBaseSceneDao = new MemoryBaseSceneDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MemoryBaseSceneDao r0 = this._memoryBaseSceneDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memoryBaseSceneDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public MemoryContextSyncDao getMemoryContextSyncDao() {
        if (this._memoryContextSyncDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memoryContextSyncDao != null) goto L10;
        this._memoryContextSyncDao = new MemoryContextSyncDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MemoryContextSyncDao r0 = this._memoryContextSyncDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memoryContextSyncDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public MemoryEntityCorrelationDao getMemoryEntityCorrelationDao() {
        if (this._memoryEntityCorrelationDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memoryEntityCorrelationDao != null) goto L10;
        this._memoryEntityCorrelationDao = new MemoryEntityCorrelationDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MemoryEntityCorrelationDao r0 = this._memoryEntityCorrelationDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memoryEntityCorrelationDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public MemoryEntityToCalendarDao getMemoryEntityToCalendarDao() {
        if (this._memoryEntityToCalendarDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memoryEntityToCalendarDao != null) goto L10;
        this._memoryEntityToCalendarDao = new MemoryEntityToCalendarDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MemoryEntityToCalendarDao r0 = this._memoryEntityToCalendarDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memoryEntityToCalendarDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public MemoryKeyInfoDao getMemoryKeyInfoDao() {
        if (this._memoryKeyInfoDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memoryKeyInfoDao != null) goto L10;
        this._memoryKeyInfoDao = new MemoryKeyInfoDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MemoryKeyInfoDao r0 = this._memoryKeyInfoDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memoryKeyInfoDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public MemoryProcessUserInsightDao getMemoryProcessUserInsightDao() {
        if (this._memoryProcessUserInsightDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memoryProcessUserInsightDao != null) goto L10;
        this._memoryProcessUserInsightDao = new MemoryProcessUserInsightDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MemoryProcessUserInsightDao r0 = this._memoryProcessUserInsightDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memoryProcessUserInsightDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public MemoryReviewFeedbackDao getMemoryReviewFeedbackDao() {
        if (this._memoryReviewFeedbackDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memoryReviewFeedbackDao != null) goto L10;
        this._memoryReviewFeedbackDao = new MemoryReviewFeedbackDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MemoryReviewFeedbackDao r0 = this._memoryReviewFeedbackDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memoryReviewFeedbackDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public MemoryRuleDao getMemoryRuleDao() {
        if (this._memoryRuleDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memoryRuleDao != null) goto L10;
        this._memoryRuleDao = new MemoryRuleDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MemoryRuleDao r0 = this._memoryRuleDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memoryRuleDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public MemorySourceEpisodicImageRelationDao getMemorySourceEpisodicImageRelationDao() {
        if (this._memorySourceEpisodicImageRelationDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memorySourceEpisodicImageRelationDao != null) goto L10;
        this._memorySourceEpisodicImageRelationDao = new MemorySourceEpisodicImageRelationDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MemorySourceEpisodicImageRelationDao r0 = this._memorySourceEpisodicImageRelationDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memorySourceEpisodicImageRelationDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public MemorySourceImageRelationDao getMemorySourceImageRelationDao() {
        if (this._memorySourceImageRelationDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memorySourceImageRelationDao != null) goto L10;
        this._memorySourceImageRelationDao = new MemorySourceImageRelationDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MemorySourceImageRelationDao r0 = this._memorySourceImageRelationDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memorySourceImageRelationDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public MemorySourceSemanticImageRelationDao getMemorySourceSemanticImageRelationDao() {
        if (this._memorySourceSemanticImageRelationDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memorySourceSemanticImageRelationDao != null) goto L10;
        this._memorySourceSemanticImageRelationDao = new MemorySourceSemanticImageRelationDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MemorySourceSemanticImageRelationDao r0 = this._memorySourceSemanticImageRelationDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memorySourceSemanticImageRelationDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public MemorySynthesisDao getMemorySynthesisDao() {
        if (this._memorySynthesisDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._memorySynthesisDao != null) goto L10;
        this._memorySynthesisDao = new MemorySynthesisDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MemorySynthesisDao r0 = this._memorySynthesisDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._memorySynthesisDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public MiddleUserProfileDao getMiddleUserProfileDao() {
        if (this._middleUserProfileDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._middleUserProfileDao != null) goto L10;
        this._middleUserProfileDao = new MiddleUserProfileDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        MiddleUserProfileDao r0 = this._middleUserProfileDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._middleUserProfileDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public PendingContextDao getPendingContextDao() {
        if (this._pendingContextDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._pendingContextDao != null) goto L10;
        this._pendingContextDao = new PendingContextDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        PendingContextDao r0 = this._pendingContextDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._pendingContextDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public PendingEpisodicDao getPendingEpisodicDao() {
        if (this._pendingEpisodicDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._pendingEpisodicDao != null) goto L10;
        this._pendingEpisodicDao = new PendingEpisodicDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        PendingEpisodicDao r0 = this._pendingEpisodicDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._pendingEpisodicDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public PendingMemoryCalendarDao getPendingMemoryCalendarDao() {
        if (this._pendingMemoryCalendarDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._pendingMemoryCalendarDao != null) goto L10;
        this._pendingMemoryCalendarDao = new PendingMemoryCalendarDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        PendingMemoryCalendarDao r0 = this._pendingMemoryCalendarDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._pendingMemoryCalendarDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public PendingSemanticDao getPendingSemanticDao() {
        if (this._pendingSemanticDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._pendingSemanticDao != null) goto L10;
        this._pendingSemanticDao = new PendingSemanticDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        PendingSemanticDao r0 = this._pendingSemanticDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._pendingSemanticDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public PersonAudioProfileDao getPersonAudioProfileDao() {
        if (this._personAudioProfileDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._personAudioProfileDao != null) goto L10;
        this._personAudioProfileDao = new PersonAudioProfileDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        PersonAudioProfileDao r0 = this._personAudioProfileDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._personAudioProfileDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public PersonImageProfileDao getPersonImageProfileDao() {
        if (this._personImageProfileDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._personImageProfileDao != null) goto L10;
        this._personImageProfileDao = new PersonImageProfileDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        PersonImageProfileDao r0 = this._personImageProfileDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._personImageProfileDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public PersonProfileDao getPersonProfileDao() {
        if (this._personProfileDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._personProfileDao != null) goto L10;
        this._personProfileDao = new PersonProfileDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        PersonProfileDao r0 = this._personProfileDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._personProfileDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public ProactiveEpisodicRelevantDataDao getProactiveEpisodicRelevantDataDao() {
        if (this._proactiveEpisodicRelevantDataDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._proactiveEpisodicRelevantDataDao != null) goto L10;
        this._proactiveEpisodicRelevantDataDao = new ProactiveEpisodicRelevantDataDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        ProactiveEpisodicRelevantDataDao r0 = this._proactiveEpisodicRelevantDataDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._proactiveEpisodicRelevantDataDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public ProactiveSemanticRelevantDataDao getProactiveSemanticRelevantDataDao() {
        if (this._proactiveSemanticRelevantDataDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._proactiveSemanticRelevantDataDao != null) goto L10;
        this._proactiveSemanticRelevantDataDao = new ProactiveSemanticRelevantDataDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        ProactiveSemanticRelevantDataDao r0 = this._proactiveSemanticRelevantDataDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._proactiveSemanticRelevantDataDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public RawUserProfileHistoryRawDbDao getRawUserProfileHistoryRawDbDao() {
        if (this._rawUserProfileHistoryRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._rawUserProfileHistoryRawDbDao != null) goto L10;
        this._rawUserProfileHistoryRawDbDao = new RawUserProfileHistoryRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        RawUserProfileHistoryRawDbDao r0 = this._rawUserProfileHistoryRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._rawUserProfileHistoryRawDbDao;
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap r2 = new HashMap();
        r2.put(AgentWatermarkDao.class, AgentWatermarkDao_Impl.getRequiredConverters());
        r2.put(AssistantChatDao.class, AssistantChatDao_Impl.getRequiredConverters());
        r2.put(AssistantChatMessageDao.class, AssistantChatMessageDao_Impl.getRequiredConverters());
        r2.put(IndexPendingDao.class, IndexPendingDao_PersonalMemoryFrameDb_Impl.getRequiredConverters());
        r2.put(EntityIndexLifecycleDao.class, EntityIndexLifecycleDao_PersonalMemoryFrameDb_Impl.getRequiredConverters());
        r2.put(AutoMemoryEpisodicRelevantDataDao.class, AutoMemoryEpisodicRelevantDataDao_Impl.getRequiredConverters());
        r2.put(AutoMemorySemanticRelevantDataDao.class, AutoMemorySemanticRelevantDataDao_Impl.getRequiredConverters());
        r2.put(AutoMemoryProDao.class, AutoMemoryProDao_Impl.getRequiredConverters());
        r2.put(AutoMemoryProEvaluationStatsDao.class, AutoMemoryProEvaluationStatsDao_Impl.getRequiredConverters());
        r2.put(AutoMemoryProHistoryRawDbDao.class, AutoMemoryProHistoryRawDbDao_Impl.getRequiredConverters());
        r2.put(AutoMemoryProRawSourceDao.class, AutoMemoryProRawSourceDao_Impl.getRequiredConverters());
        r2.put(AutoMemoryProSnapShotDao.class, AutoMemoryProSnapShotDao_Impl.getRequiredConverters());
        r2.put(AutoMemoryProSlmPersonalInfoDao.class, AutoMemoryProSlmPersonalInfoDao_Impl.getRequiredConverters());
        r2.put(AutoMemoryProSlmEpisodicMemoryDao.class, AutoMemoryProSlmEpisodicMemoryDao_Impl.getRequiredConverters());
        r2.put(AutoMemoryProTextEntityTextVectorCopilotDao.class, AutoMemoryProTextEntityTextVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(BlockMemoryContentDao.class, BlockMemoryContentDao_Impl.getRequiredConverters());
        r2.put(MemorySynthesisDao.class, MemorySynthesisDao_Impl.getRequiredConverters());
        r2.put(ComplexRecommendQueryDao.class, ComplexRecommendQueryDao_Impl.getRequiredConverters());
        r2.put(EpisodicMemoryDao.class, EpisodicMemoryDao_Impl.getRequiredConverters());
        r2.put(EpisodicMemoryContentTimeDao.class, EpisodicMemoryContentTimeDao_Impl.getRequiredConverters());
        r2.put(EpisodicMemoryHistoryRawDbDao.class, EpisodicMemoryHistoryRawDbDao_Impl.getRequiredConverters());
        r2.put(EpisodicMemoryTextVectorCopilotDao.class, EpisodicMemoryTextVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(EpisodicTopicMemoryDao.class, EpisodicTopicMemoryDao_Impl.getRequiredConverters());
        r2.put(EpisodicTopicMemoryHistoryRawDbDao.class, EpisodicTopicMemoryHistoryRawDbDao_Impl.getRequiredConverters());
        r2.put(EpisodicTopicMemoryTextVectorCopilotDao.class, EpisodicTopicMemoryTextVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(GlassesEpisodicRelevantDataDao.class, GlassesEpisodicRelevantDataDao_Impl.getRequiredConverters());
        r2.put(PendingEpisodicDao.class, PendingEpisodicDao_Impl.getRequiredConverters());
        r2.put(LifeLogTextEntityTextVectorCopilotDao.class, LifeLogTextEntityTextVectorCopilotDao_Impl.getRequiredConverters());
        r2.put(LifelogDao.class, LifelogDao_Impl.getRequiredConverters());
        r2.put(LifelogHistoryRawDbDao.class, LifelogHistoryRawDbDao_Impl.getRequiredConverters());
        r2.put(MemoryBaseSceneDao.class, MemoryBaseSceneDao_Impl.getRequiredConverters());
        r2.put(MemoryBaseRequirementDao.class, MemoryBaseRequirementDao_Impl.getRequiredConverters());
        r2.put(MemoryEntityCorrelationDao.class, MemoryEntityCorrelationDao_Impl.getRequiredConverters());
        r2.put(MemoryEntityToCalendarDao.class, MemoryEntityToCalendarDao_Impl.getRequiredConverters());
        r2.put(MemoryKeyInfoDao.class, MemoryKeyInfoDao_Impl.getRequiredConverters());
        r2.put(MemoryReviewFeedbackDao.class, MemoryReviewFeedbackDao_Impl.getRequiredConverters());
        r2.put(MemoryContextSyncDao.class, MemoryContextSyncDao_Impl.getRequiredConverters());
        r2.put(MemoryRuleDao.class, MemoryRuleDao_Impl.getRequiredConverters());
        r2.put(MemorySourceImageRelationDao.class, MemorySourceImageRelationDao_Impl.getRequiredConverters());
        r2.put(MemorySourceEpisodicImageRelationDao.class, MemorySourceEpisodicImageRelationDao_Impl.getRequiredConverters());
        r2.put(MemorySourceSemanticImageRelationDao.class, MemorySourceSemanticImageRelationDao_Impl.getRequiredConverters());
        r2.put(MiddleUserProfileDao.class, MiddleUserProfileDao_Impl.getRequiredConverters());
        r2.put(MemoryProcessUserInsightDao.class, MemoryProcessUserInsightDao_Impl.getRequiredConverters());
        r2.put(PendingContextDao.class, PendingContextDao_Impl.getRequiredConverters());
        r2.put(PendingMemoryCalendarDao.class, PendingMemoryCalendarDao_Impl.getRequiredConverters());
        r2.put(PendingSemanticDao.class, PendingSemanticDao_Impl.getRequiredConverters());
        r2.put(PersonAudioProfileDao.class, PersonAudioProfileDao_Impl.getRequiredConverters());
        r2.put(PersonImageProfileDao.class, PersonImageProfileDao_Impl.getRequiredConverters());
        r2.put(PersonProfileDao.class, PersonProfileDao_Impl.getRequiredConverters());
        r2.put(ProactiveEpisodicRelevantDataDao.class, ProactiveEpisodicRelevantDataDao_Impl.getRequiredConverters());
        r2.put(ProactiveSemanticRelevantDataDao.class, ProactiveSemanticRelevantDataDao_Impl.getRequiredConverters());
        r2.put(UserProfileDao.class, UserProfileDao_Impl.getRequiredConverters());
        r2.put(UserProfileRawDbDao.class, UserProfileRawDbDao_Impl.getRequiredConverters());
        r2.put(RawUserProfileHistoryRawDbDao.class, RawUserProfileHistoryRawDbDao_Impl.getRequiredConverters());
        r2.put(UserProfileMemoryDao.class, UserProfileMemoryDao_Impl.getRequiredConverters());
        r2.put(SemanticMemoryDao.class, SemanticMemoryDao_Impl.getRequiredConverters());
        r2.put(SemanticRetractionDao.class, SemanticRetractionDao_Impl.getRequiredConverters());
        r2.put(SemanticStateDao.class, SemanticStateDao_Impl.getRequiredConverters());
        r2.put(UnionSemanticMemorySnapShotDao.class, UnionSemanticMemorySnapShotDao_Impl.getRequiredConverters());
        r2.put(UnionSemanticMemoryExtDao.class, UnionSemanticMemoryExtDao_Impl.getRequiredConverters());
        r2.put(it.class, UnionSemanticMemoryHistoryRawDbDao_Impl.getRequiredConverters());
        r2.put(SemanticTextCopilotDao.class, SemanticTextCopilotDao_Impl.getRequiredConverters());
        r2.put(UnionSemanticTypeSummaryDao.class, UnionSemanticTypeSummaryDao_Impl.getRequiredConverters());
        r2.put(UnionUserInsightDao.class, UnionUserInsightDao_Impl.getRequiredConverters());
        r2.put(UnionUserPersonaDao.class, UnionUserPersonaDao_Impl.getRequiredConverters());
        r2.put(SlmAgentWatermarkDao.class, SlmAgentWatermarkDao_Impl.getRequiredConverters());
        r2.put(SlmAutoMemoryProTempResultDao.class, SlmAutoMemoryProTempResultDao_Impl.getRequiredConverters());
        r2.put(UpdateUnionSemanticMemoryDao.class, UpdateUnionSemanticMemoryDao_Impl.getRequiredConverters());
        r2.put(UpdateProactiveSemanticRelevantDataDao.class, UpdateProactiveSemanticRelevantDataDao_Impl.getRequiredConverters());
        r2.put(UserKeywordDao.class, UserKeywordDao_Impl.getRequiredConverters());
        r2.put(UserKeywordRefDao.class, UserKeywordRefDao_Impl.getRequiredConverters());
        r2.put(UserProfileTextEntityTextVectorCopilotDao.class, UserProfileTextEntityTextVectorCopilotDao_Impl.getRequiredConverters());
        return r2;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public SemanticMemoryDao getSemanticMemoryDao() {
        if (this._semanticMemoryDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._semanticMemoryDao != null) goto L10;
        this._semanticMemoryDao = new SemanticMemoryDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        SemanticMemoryDao r0 = this._semanticMemoryDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._semanticMemoryDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public it getSemanticMemoryHistoryRawDbDao() {
        if (this._unionSemanticMemoryHistoryRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._unionSemanticMemoryHistoryRawDbDao != null) goto L10;
        this._unionSemanticMemoryHistoryRawDbDao = new UnionSemanticMemoryHistoryRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        it r0 = this._unionSemanticMemoryHistoryRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._unionSemanticMemoryHistoryRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public SemanticRetractionDao getSemanticRetractionDao() {
        if (this._semanticRetractionDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._semanticRetractionDao != null) goto L10;
        this._semanticRetractionDao = new SemanticRetractionDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        SemanticRetractionDao r0 = this._semanticRetractionDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._semanticRetractionDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public SemanticStateDao getSemanticStateDao() {
        if (this._semanticStateDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._semanticStateDao != null) goto L10;
        this._semanticStateDao = new SemanticStateDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        SemanticStateDao r0 = this._semanticStateDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._semanticStateDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public SemanticTextCopilotDao getSemanticTextCopilotDao() {
        if (this._semanticTextCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._semanticTextCopilotDao != null) goto L10;
        this._semanticTextCopilotDao = new SemanticTextCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        SemanticTextCopilotDao r0 = this._semanticTextCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._semanticTextCopilotDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public SlmAgentWatermarkDao getSlmAgentWatermarkDao() {
        if (this._slmAgentWatermarkDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._slmAgentWatermarkDao != null) goto L10;
        this._slmAgentWatermarkDao = new SlmAgentWatermarkDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        SlmAgentWatermarkDao r0 = this._slmAgentWatermarkDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._slmAgentWatermarkDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public SlmAutoMemoryProTempResultDao getSlmAutoMemoryProTempResultDao() {
        if (this._slmAutoMemoryProTempResultDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._slmAutoMemoryProTempResultDao != null) goto L10;
        this._slmAutoMemoryProTempResultDao = new SlmAutoMemoryProTempResultDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        SlmAutoMemoryProTempResultDao r0 = this._slmAutoMemoryProTempResultDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._slmAutoMemoryProTempResultDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public UnionSemanticMemoryExtDao getUnionSemanticMemoryExtDao() {
        if (this._unionSemanticMemoryExtDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._unionSemanticMemoryExtDao != null) goto L10;
        this._unionSemanticMemoryExtDao = new UnionSemanticMemoryExtDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        UnionSemanticMemoryExtDao r0 = this._unionSemanticMemoryExtDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._unionSemanticMemoryExtDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public UnionSemanticMemorySnapShotDao getUnionSemanticMemorySnapShotDao() {
        if (this._unionSemanticMemorySnapShotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._unionSemanticMemorySnapShotDao != null) goto L10;
        this._unionSemanticMemorySnapShotDao = new UnionSemanticMemorySnapShotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        UnionSemanticMemorySnapShotDao r0 = this._unionSemanticMemorySnapShotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._unionSemanticMemorySnapShotDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public UnionSemanticTypeSummaryDao getUnionSemanticTypeSummaryDao() {
        if (this._unionSemanticTypeSummaryDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._unionSemanticTypeSummaryDao != null) goto L10;
        this._unionSemanticTypeSummaryDao = new UnionSemanticTypeSummaryDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        UnionSemanticTypeSummaryDao r0 = this._unionSemanticTypeSummaryDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._unionSemanticTypeSummaryDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public UnionUserInsightDao getUnionUserInsightDao() {
        if (this._unionUserInsightDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._unionUserInsightDao != null) goto L10;
        this._unionUserInsightDao = new UnionUserInsightDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        UnionUserInsightDao r0 = this._unionUserInsightDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._unionUserInsightDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public UnionUserPersonaDao getUnionUserPersonaDao() {
        if (this._unionUserPersonaDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._unionUserPersonaDao != null) goto L10;
        this._unionUserPersonaDao = new UnionUserPersonaDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        UnionUserPersonaDao r0 = this._unionUserPersonaDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._unionUserPersonaDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public UpdateProactiveSemanticRelevantDataDao getUpdateProactiveSemanticRelevantDataDao() {
        if (this._updateProactiveSemanticRelevantDataDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._updateProactiveSemanticRelevantDataDao != null) goto L10;
        this._updateProactiveSemanticRelevantDataDao = new UpdateProactiveSemanticRelevantDataDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        UpdateProactiveSemanticRelevantDataDao r0 = this._updateProactiveSemanticRelevantDataDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._updateProactiveSemanticRelevantDataDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public UpdateUnionSemanticMemoryDao getUpdateUnionSemanticMemoryDao() {
        if (this._updateUnionSemanticMemoryDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._updateUnionSemanticMemoryDao != null) goto L10;
        this._updateUnionSemanticMemoryDao = new UpdateUnionSemanticMemoryDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        UpdateUnionSemanticMemoryDao r0 = this._updateUnionSemanticMemoryDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._updateUnionSemanticMemoryDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public UserKeywordDao getUserKeywordDao() {
        if (this._userKeywordDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._userKeywordDao != null) goto L10;
        this._userKeywordDao = new UserKeywordDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        UserKeywordDao r0 = this._userKeywordDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._userKeywordDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public UserKeywordRefDao getUserKeywordRefDao() {
        if (this._userKeywordRefDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._userKeywordRefDao != null) goto L10;
        this._userKeywordRefDao = new UserKeywordRefDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        UserKeywordRefDao r0 = this._userKeywordRefDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._userKeywordRefDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public UserProfileDao getUserProfileDao() {
        if (this._userProfileDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._userProfileDao != null) goto L10;
        this._userProfileDao = new UserProfileDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        UserProfileDao r0 = this._userProfileDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._userProfileDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public UserProfileMemoryDao getUserProfileMemoryDao() {
        if (this._userProfileMemoryDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._userProfileMemoryDao != null) goto L10;
        this._userProfileMemoryDao = new UserProfileMemoryDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        UserProfileMemoryDao r0 = this._userProfileMemoryDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._userProfileMemoryDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public UserProfileRawDbDao getUserProfileRawDbDao() {
        if (this._userProfileRawDbDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._userProfileRawDbDao != null) goto L10;
        this._userProfileRawDbDao = new UserProfileRawDbDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        UserProfileRawDbDao r0 = this._userProfileRawDbDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._userProfileRawDbDao;
    }

    @Override // com.obric.memorydata.database.manager.PersonalMemoryFrameDb
    public UserProfileTextEntityTextVectorCopilotDao getUserProfileTextVectorCopilotDao() {
        if (this._userProfileTextEntityTextVectorCopilotDao != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this._userProfileTextEntityTextVectorCopilotDao != null) goto L10;
        this._userProfileTextEntityTextVectorCopilotDao = new UserProfileTextEntityTextVectorCopilotDao_Impl(this);     // Catch: Throwable -> L13
    L10:
        UserProfileTextEntityTextVectorCopilotDao r0 = this._userProfileTextEntityTextVectorCopilotDao;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this._userProfileTextEntityTextVectorCopilotDao;
    }
}
