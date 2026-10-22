package com.obric.memorydata.database.manager;

import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import com.obric.memorydata.database.dao.AgentWatermarkDao;
import com.obric.memorydata.database.dao.AssistantChatDao;
import com.obric.memorydata.database.dao.AssistantChatMessageDao;
import com.obric.memorydata.database.dao.AutoMemoryEpisodicRelevantDataDao;
import com.obric.memorydata.database.dao.AutoMemoryProDao;
import com.obric.memorydata.database.dao.AutoMemoryProEvaluationStatsDao;
import com.obric.memorydata.database.dao.AutoMemoryProHistoryRawDbDao;
import com.obric.memorydata.database.dao.AutoMemoryProRawSourceDao;
import com.obric.memorydata.database.dao.AutoMemoryProSlmEpisodicMemoryDao;
import com.obric.memorydata.database.dao.AutoMemoryProSlmPersonalInfoDao;
import com.obric.memorydata.database.dao.AutoMemoryProSnapShotDao;
import com.obric.memorydata.database.dao.AutoMemoryProTextEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.AutoMemorySemanticRelevantDataDao;
import com.obric.memorydata.database.dao.BlockMemoryContentDao;
import com.obric.memorydata.database.dao.ComplexRecommendQueryDao;
import com.obric.memorydata.database.dao.EntityIndexLifecycleDao;
import com.obric.memorydata.database.dao.EpisodicMemoryContentTimeDao;
import com.obric.memorydata.database.dao.EpisodicMemoryDao;
import com.obric.memorydata.database.dao.EpisodicMemoryHistoryRawDbDao;
import com.obric.memorydata.database.dao.EpisodicMemoryTextVectorCopilotDao;
import com.obric.memorydata.database.dao.EpisodicTopicMemoryDao;
import com.obric.memorydata.database.dao.EpisodicTopicMemoryHistoryRawDbDao;
import com.obric.memorydata.database.dao.EpisodicTopicMemoryTextVectorCopilotDao;
import com.obric.memorydata.database.dao.GlassesEpisodicRelevantDataDao;
import com.obric.memorydata.database.dao.IndexPendingDao;
import com.obric.memorydata.database.dao.LifeLogTextEntityTextVectorCopilotDao;
import com.obric.memorydata.database.dao.LifelogDao;
import com.obric.memorydata.database.dao.LifelogHistoryRawDbDao;
import com.obric.memorydata.database.dao.MemoryBaseRequirementDao;
import com.obric.memorydata.database.dao.MemoryBaseSceneDao;
import com.obric.memorydata.database.dao.MemoryContextSyncDao;
import com.obric.memorydata.database.dao.MemoryEntityCorrelationDao;
import com.obric.memorydata.database.dao.MemoryEntityToCalendarDao;
import com.obric.memorydata.database.dao.MemoryKeyInfoDao;
import com.obric.memorydata.database.dao.MemoryProcessUserInsightDao;
import com.obric.memorydata.database.dao.MemoryReviewFeedbackDao;
import com.obric.memorydata.database.dao.MemoryRuleDao;
import com.obric.memorydata.database.dao.MemorySourceEpisodicImageRelationDao;
import com.obric.memorydata.database.dao.MemorySourceImageRelationDao;
import com.obric.memorydata.database.dao.MemorySourceSemanticImageRelationDao;
import com.obric.memorydata.database.dao.MemorySynthesisDao;
import com.obric.memorydata.database.dao.MiddleUserProfileDao;
import com.obric.memorydata.database.dao.PendingContextDao;
import com.obric.memorydata.database.dao.PendingEpisodicDao;
import com.obric.memorydata.database.dao.PendingMemoryCalendarDao;
import com.obric.memorydata.database.dao.PendingSemanticDao;
import com.obric.memorydata.database.dao.PersonAudioProfileDao;
import com.obric.memorydata.database.dao.PersonImageProfileDao;
import com.obric.memorydata.database.dao.PersonProfileDao;
import com.obric.memorydata.database.dao.ProactiveEpisodicRelevantDataDao;
import com.obric.memorydata.database.dao.ProactiveSemanticRelevantDataDao;
import com.obric.memorydata.database.dao.RawUserProfileHistoryRawDbDao;
import com.obric.memorydata.database.dao.SemanticMemoryDao;
import com.obric.memorydata.database.dao.SemanticRetractionDao;
import com.obric.memorydata.database.dao.SemanticStateDao;
import com.obric.memorydata.database.dao.SemanticTextCopilotDao;
import com.obric.memorydata.database.dao.SlmAgentWatermarkDao;
import com.obric.memorydata.database.dao.SlmAutoMemoryProTempResultDao;
import com.obric.memorydata.database.dao.UnionSemanticMemoryExtDao;
import com.obric.memorydata.database.dao.UnionSemanticMemorySnapShotDao;
import com.obric.memorydata.database.dao.UnionSemanticTypeSummaryDao;
import com.obric.memorydata.database.dao.UnionUserInsightDao;
import com.obric.memorydata.database.dao.UnionUserPersonaDao;
import com.obric.memorydata.database.dao.UpdateProactiveSemanticRelevantDataDao;
import com.obric.memorydata.database.dao.UpdateUnionSemanticMemoryDao;
import com.obric.memorydata.database.dao.UserKeywordDao;
import com.obric.memorydata.database.dao.UserKeywordRefDao;
import com.obric.memorydata.database.dao.UserProfileDao;
import com.obric.memorydata.database.dao.UserProfileMemoryDao;
import com.obric.memorydata.database.dao.UserProfileRawDbDao;
import com.obric.memorydata.database.dao.UserProfileTextEntityTextVectorCopilotDao;
import com.obric.memorydata.database.entity.it;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Ô\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0012\u0010 \u001a\u00020!X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0012\u0010$\u001a\u00020%X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0012\u0010(\u001a\u00020)X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0012\u0010,\u001a\u00020-X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0012\u00100\u001a\u000201X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0012\u00104\u001a\u000205X¦\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0012\u00108\u001a\u000209X¦\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0012\u0010<\u001a\u00020=X¦\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0012\u0010@\u001a\u00020AX¦\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0012\u0010D\u001a\u00020EX¦\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0012\u0010H\u001a\u00020IX¦\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0012\u0010L\u001a\u00020MX¦\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0012\u0010P\u001a\u00020QX¦\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0012\u0010T\u001a\u00020UX¦\u0004¢\u0006\u0006\u001a\u0004\bV\u0010WR\u0012\u0010X\u001a\u00020YX¦\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010[R\u0012\u0010\\\u001a\u00020]X¦\u0004¢\u0006\u0006\u001a\u0004\b^\u0010_R\u0012\u0010`\u001a\u00020aX¦\u0004¢\u0006\u0006\u001a\u0004\bb\u0010cR\u0012\u0010d\u001a\u00020eX¦\u0004¢\u0006\u0006\u001a\u0004\bf\u0010gR\u0012\u0010h\u001a\u00020iX¦\u0004¢\u0006\u0006\u001a\u0004\bj\u0010kR\u0012\u0010l\u001a\u00020mX¦\u0004¢\u0006\u0006\u001a\u0004\bn\u0010oR\u0012\u0010p\u001a\u00020qX¦\u0004¢\u0006\u0006\u001a\u0004\br\u0010sR\u0012\u0010t\u001a\u00020uX¦\u0004¢\u0006\u0006\u001a\u0004\bv\u0010wR\u0012\u0010x\u001a\u00020yX¦\u0004¢\u0006\u0006\u001a\u0004\bz\u0010{R\u0012\u0010|\u001a\u00020}X¦\u0004¢\u0006\u0006\u001a\u0004\b~\u0010\u007fR\u0016\u0010\u0080\u0001\u001a\u00030\u0081\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0016\u0010\u0084\u0001\u001a\u00030\u0085\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0016\u0010\u0088\u0001\u001a\u00030\u0089\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0016\u0010\u008c\u0001\u001a\u00030\u008d\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0016\u0010\u0090\u0001\u001a\u00030\u0091\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0016\u0010\u0094\u0001\u001a\u00030\u0095\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0016\u0010\u0098\u0001\u001a\u00030\u0099\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R\u0016\u0010\u009c\u0001\u001a\u00030\u009d\u0001X¦\u0004¢\u0006\b\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001R\u0016\u0010 \u0001\u001a\u00030¡\u0001X¦\u0004¢\u0006\b\u001a\u0006\b¢\u0001\u0010£\u0001R\u0016\u0010¤\u0001\u001a\u00030¥\u0001X¦\u0004¢\u0006\b\u001a\u0006\b¦\u0001\u0010§\u0001R\u0016\u0010¨\u0001\u001a\u00030©\u0001X¦\u0004¢\u0006\b\u001a\u0006\bª\u0001\u0010«\u0001R\u0016\u0010¬\u0001\u001a\u00030\u00ad\u0001X¦\u0004¢\u0006\b\u001a\u0006\b®\u0001\u0010¯\u0001R\u0016\u0010°\u0001\u001a\u00030±\u0001X¦\u0004¢\u0006\b\u001a\u0006\b²\u0001\u0010³\u0001R\u0016\u0010´\u0001\u001a\u00030µ\u0001X¦\u0004¢\u0006\b\u001a\u0006\b¶\u0001\u0010·\u0001R\u0016\u0010¸\u0001\u001a\u00030¹\u0001X¦\u0004¢\u0006\b\u001a\u0006\bº\u0001\u0010»\u0001R\u0016\u0010¼\u0001\u001a\u00030½\u0001X¦\u0004¢\u0006\b\u001a\u0006\b¾\u0001\u0010¿\u0001R\u0016\u0010À\u0001\u001a\u00030Á\u0001X¦\u0004¢\u0006\b\u001a\u0006\bÂ\u0001\u0010Ã\u0001R\u0016\u0010Ä\u0001\u001a\u00030Å\u0001X¦\u0004¢\u0006\b\u001a\u0006\bÆ\u0001\u0010Ç\u0001R\u0016\u0010È\u0001\u001a\u00030É\u0001X¦\u0004¢\u0006\b\u001a\u0006\bÊ\u0001\u0010Ë\u0001R\u0016\u0010Ì\u0001\u001a\u00030Í\u0001X¦\u0004¢\u0006\b\u001a\u0006\bÎ\u0001\u0010Ï\u0001R\u0016\u0010Ð\u0001\u001a\u00030Ñ\u0001X¦\u0004¢\u0006\b\u001a\u0006\bÒ\u0001\u0010Ó\u0001R\u0016\u0010Ô\u0001\u001a\u00030Õ\u0001X¦\u0004¢\u0006\b\u001a\u0006\bÖ\u0001\u0010×\u0001R\u0016\u0010Ø\u0001\u001a\u00030Ù\u0001X¦\u0004¢\u0006\b\u001a\u0006\bÚ\u0001\u0010Û\u0001R\u0016\u0010Ü\u0001\u001a\u00030Ý\u0001X¦\u0004¢\u0006\b\u001a\u0006\bÞ\u0001\u0010ß\u0001R\u0016\u0010à\u0001\u001a\u00030á\u0001X¦\u0004¢\u0006\b\u001a\u0006\bâ\u0001\u0010ã\u0001R\u0016\u0010ä\u0001\u001a\u00030å\u0001X¦\u0004¢\u0006\b\u001a\u0006\bæ\u0001\u0010ç\u0001R\u0016\u0010è\u0001\u001a\u00030é\u0001X¦\u0004¢\u0006\b\u001a\u0006\bê\u0001\u0010ë\u0001R\u0016\u0010ì\u0001\u001a\u00030í\u0001X¦\u0004¢\u0006\b\u001a\u0006\bî\u0001\u0010ï\u0001R\u0016\u0010ð\u0001\u001a\u00030ñ\u0001X¦\u0004¢\u0006\b\u001a\u0006\bò\u0001\u0010ó\u0001R\u0016\u0010ô\u0001\u001a\u00030õ\u0001X¦\u0004¢\u0006\b\u001a\u0006\bö\u0001\u0010÷\u0001R\u0016\u0010ø\u0001\u001a\u00030ù\u0001X¦\u0004¢\u0006\b\u001a\u0006\bú\u0001\u0010û\u0001R\u0016\u0010ü\u0001\u001a\u00030ý\u0001X¦\u0004¢\u0006\b\u001a\u0006\bþ\u0001\u0010ÿ\u0001R\u0016\u0010\u0080\u0002\u001a\u00030\u0081\u0002X¦\u0004¢\u0006\b\u001a\u0006\b\u0082\u0002\u0010\u0083\u0002R\u0016\u0010\u0084\u0002\u001a\u00030\u0085\u0002X¦\u0004¢\u0006\b\u001a\u0006\b\u0086\u0002\u0010\u0087\u0002R\u0016\u0010\u0088\u0002\u001a\u00030\u0089\u0002X¦\u0004¢\u0006\b\u001a\u0006\b\u008a\u0002\u0010\u008b\u0002R\u0016\u0010\u008c\u0002\u001a\u00030\u008d\u0002X¦\u0004¢\u0006\b\u001a\u0006\b\u008e\u0002\u0010\u008f\u0002R\u0016\u0010\u0090\u0002\u001a\u00030\u0091\u0002X¦\u0004¢\u0006\b\u001a\u0006\b\u0092\u0002\u0010\u0093\u0002R\u0016\u0010\u0094\u0002\u001a\u00030\u0095\u0002X¦\u0004¢\u0006\b\u001a\u0006\b\u0096\u0002\u0010\u0097\u0002R\u0016\u0010\u0098\u0002\u001a\u00030\u0099\u0002X¦\u0004¢\u0006\b\u001a\u0006\b\u009a\u0002\u0010\u009b\u0002R\u0016\u0010\u009c\u0002\u001a\u00030\u009d\u0002X¦\u0004¢\u0006\b\u001a\u0006\b\u009e\u0002\u0010\u009f\u0002R\u0016\u0010 \u0002\u001a\u00030¡\u0002X¦\u0004¢\u0006\b\u001a\u0006\b¢\u0002\u0010£\u0002R\u0016\u0010¤\u0002\u001a\u00030¥\u0002X¦\u0004¢\u0006\b\u001a\u0006\b¦\u0002\u0010§\u0002¨\u0006¨\u0002"}, d2 = {"Lcom/obric/memorydata/database/manager/PersonalMemoryFrameDb;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "invalidationTracker", "Landroidx/room/InvalidationTracker;", "getInvalidationTracker", "()Landroidx/room/InvalidationTracker;", "agentWatermarkDao", "Lcom/obric/memorydata/database/dao/AgentWatermarkDao;", "getAgentWatermarkDao", "()Lcom/obric/memorydata/database/dao/AgentWatermarkDao;", "assistantChatDao", "Lcom/obric/memorydata/database/dao/AssistantChatDao;", "getAssistantChatDao", "()Lcom/obric/memorydata/database/dao/AssistantChatDao;", "assistantChatMessageDao", "Lcom/obric/memorydata/database/dao/AssistantChatMessageDao;", "getAssistantChatMessageDao", "()Lcom/obric/memorydata/database/dao/AssistantChatMessageDao;", "indexPendingDao", "Lcom/obric/memorydata/database/dao/IndexPendingDao;", "getIndexPendingDao", "()Lcom/obric/memorydata/database/dao/IndexPendingDao;", "entityIndexLifecycleDao", "Lcom/obric/memorydata/database/dao/EntityIndexLifecycleDao;", "getEntityIndexLifecycleDao", "()Lcom/obric/memorydata/database/dao/EntityIndexLifecycleDao;", "autoMemoryEpisodicRelevantDataDao", "Lcom/obric/memorydata/database/dao/AutoMemoryEpisodicRelevantDataDao;", "getAutoMemoryEpisodicRelevantDataDao", "()Lcom/obric/memorydata/database/dao/AutoMemoryEpisodicRelevantDataDao;", "autoMemorySemanticRelevantDataDao", "Lcom/obric/memorydata/database/dao/AutoMemorySemanticRelevantDataDao;", "getAutoMemorySemanticRelevantDataDao", "()Lcom/obric/memorydata/database/dao/AutoMemorySemanticRelevantDataDao;", "autoMemoryProDao", "Lcom/obric/memorydata/database/dao/AutoMemoryProDao;", "getAutoMemoryProDao", "()Lcom/obric/memorydata/database/dao/AutoMemoryProDao;", "autoMemoryProEvaluationStatsDao", "Lcom/obric/memorydata/database/dao/AutoMemoryProEvaluationStatsDao;", "getAutoMemoryProEvaluationStatsDao", "()Lcom/obric/memorydata/database/dao/AutoMemoryProEvaluationStatsDao;", "autoMemoryProHistoryRawDbDao", "Lcom/obric/memorydata/database/dao/AutoMemoryProHistoryRawDbDao;", "getAutoMemoryProHistoryRawDbDao", "()Lcom/obric/memorydata/database/dao/AutoMemoryProHistoryRawDbDao;", "autoMemoryProRawSourceDao", "Lcom/obric/memorydata/database/dao/AutoMemoryProRawSourceDao;", "getAutoMemoryProRawSourceDao", "()Lcom/obric/memorydata/database/dao/AutoMemoryProRawSourceDao;", "autoMemoryProSnapShotDao", "Lcom/obric/memorydata/database/dao/AutoMemoryProSnapShotDao;", "getAutoMemoryProSnapShotDao", "()Lcom/obric/memorydata/database/dao/AutoMemoryProSnapShotDao;", "autoMemoryProSlmPersonalInfoDao", "Lcom/obric/memorydata/database/dao/AutoMemoryProSlmPersonalInfoDao;", "getAutoMemoryProSlmPersonalInfoDao", "()Lcom/obric/memorydata/database/dao/AutoMemoryProSlmPersonalInfoDao;", "autoMemoryProSlmEpisodicMemoryDao", "Lcom/obric/memorydata/database/dao/AutoMemoryProSlmEpisodicMemoryDao;", "getAutoMemoryProSlmEpisodicMemoryDao", "()Lcom/obric/memorydata/database/dao/AutoMemoryProSlmEpisodicMemoryDao;", "autoMemoryProTextVectorCopilotDao", "Lcom/obric/memorydata/database/dao/AutoMemoryProTextEntityTextVectorCopilotDao;", "getAutoMemoryProTextVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/AutoMemoryProTextEntityTextVectorCopilotDao;", "blockMemoryContentDao", "Lcom/obric/memorydata/database/dao/BlockMemoryContentDao;", "getBlockMemoryContentDao", "()Lcom/obric/memorydata/database/dao/BlockMemoryContentDao;", "memorySynthesisDao", "Lcom/obric/memorydata/database/dao/MemorySynthesisDao;", "getMemorySynthesisDao", "()Lcom/obric/memorydata/database/dao/MemorySynthesisDao;", "complexRecommendQueryDao", "Lcom/obric/memorydata/database/dao/ComplexRecommendQueryDao;", "getComplexRecommendQueryDao", "()Lcom/obric/memorydata/database/dao/ComplexRecommendQueryDao;", "episodicMemoryDao", "Lcom/obric/memorydata/database/dao/EpisodicMemoryDao;", "getEpisodicMemoryDao", "()Lcom/obric/memorydata/database/dao/EpisodicMemoryDao;", "episodicMemoryContentTimeDao", "Lcom/obric/memorydata/database/dao/EpisodicMemoryContentTimeDao;", "getEpisodicMemoryContentTimeDao", "()Lcom/obric/memorydata/database/dao/EpisodicMemoryContentTimeDao;", "episodicMemoryHistoryRawDbDao", "Lcom/obric/memorydata/database/dao/EpisodicMemoryHistoryRawDbDao;", "getEpisodicMemoryHistoryRawDbDao", "()Lcom/obric/memorydata/database/dao/EpisodicMemoryHistoryRawDbDao;", "episodicMemoryTextVectorCopilotDao", "Lcom/obric/memorydata/database/dao/EpisodicMemoryTextVectorCopilotDao;", "getEpisodicMemoryTextVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/EpisodicMemoryTextVectorCopilotDao;", "episodicTopicMemoryDao", "Lcom/obric/memorydata/database/dao/EpisodicTopicMemoryDao;", "getEpisodicTopicMemoryDao", "()Lcom/obric/memorydata/database/dao/EpisodicTopicMemoryDao;", "episodicTopicMemoryHistoryRawDbDao", "Lcom/obric/memorydata/database/dao/EpisodicTopicMemoryHistoryRawDbDao;", "getEpisodicTopicMemoryHistoryRawDbDao", "()Lcom/obric/memorydata/database/dao/EpisodicTopicMemoryHistoryRawDbDao;", "episodicTopicMemoryTextVectorCopilotDao", "Lcom/obric/memorydata/database/dao/EpisodicTopicMemoryTextVectorCopilotDao;", "getEpisodicTopicMemoryTextVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/EpisodicTopicMemoryTextVectorCopilotDao;", "glassesEpisodicRelevantDataDao", "Lcom/obric/memorydata/database/dao/GlassesEpisodicRelevantDataDao;", "getGlassesEpisodicRelevantDataDao", "()Lcom/obric/memorydata/database/dao/GlassesEpisodicRelevantDataDao;", "pendingEpisodicDao", "Lcom/obric/memorydata/database/dao/PendingEpisodicDao;", "getPendingEpisodicDao", "()Lcom/obric/memorydata/database/dao/PendingEpisodicDao;", "lifeLogTextVectorCopilotDao", "Lcom/obric/memorydata/database/dao/LifeLogTextEntityTextVectorCopilotDao;", "getLifeLogTextVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/LifeLogTextEntityTextVectorCopilotDao;", "lifelogDao", "Lcom/obric/memorydata/database/dao/LifelogDao;", "getLifelogDao", "()Lcom/obric/memorydata/database/dao/LifelogDao;", "lifelogHistoryRawDbDao", "Lcom/obric/memorydata/database/dao/LifelogHistoryRawDbDao;", "getLifelogHistoryRawDbDao", "()Lcom/obric/memorydata/database/dao/LifelogHistoryRawDbDao;", "memoryBaseSceneDao", "Lcom/obric/memorydata/database/dao/MemoryBaseSceneDao;", "getMemoryBaseSceneDao", "()Lcom/obric/memorydata/database/dao/MemoryBaseSceneDao;", "memoryBaseRequirementDao", "Lcom/obric/memorydata/database/dao/MemoryBaseRequirementDao;", "getMemoryBaseRequirementDao", "()Lcom/obric/memorydata/database/dao/MemoryBaseRequirementDao;", "memoryEntityCorrelationDao", "Lcom/obric/memorydata/database/dao/MemoryEntityCorrelationDao;", "getMemoryEntityCorrelationDao", "()Lcom/obric/memorydata/database/dao/MemoryEntityCorrelationDao;", "memoryEntityToCalendarDao", "Lcom/obric/memorydata/database/dao/MemoryEntityToCalendarDao;", "getMemoryEntityToCalendarDao", "()Lcom/obric/memorydata/database/dao/MemoryEntityToCalendarDao;", "memoryKeyInfoDao", "Lcom/obric/memorydata/database/dao/MemoryKeyInfoDao;", "getMemoryKeyInfoDao", "()Lcom/obric/memorydata/database/dao/MemoryKeyInfoDao;", "memoryReviewFeedbackDao", "Lcom/obric/memorydata/database/dao/MemoryReviewFeedbackDao;", "getMemoryReviewFeedbackDao", "()Lcom/obric/memorydata/database/dao/MemoryReviewFeedbackDao;", "memoryContextSyncDao", "Lcom/obric/memorydata/database/dao/MemoryContextSyncDao;", "getMemoryContextSyncDao", "()Lcom/obric/memorydata/database/dao/MemoryContextSyncDao;", "memoryRuleDao", "Lcom/obric/memorydata/database/dao/MemoryRuleDao;", "getMemoryRuleDao", "()Lcom/obric/memorydata/database/dao/MemoryRuleDao;", "memorySourceImageRelationDao", "Lcom/obric/memorydata/database/dao/MemorySourceImageRelationDao;", "getMemorySourceImageRelationDao", "()Lcom/obric/memorydata/database/dao/MemorySourceImageRelationDao;", "memorySourceEpisodicImageRelationDao", "Lcom/obric/memorydata/database/dao/MemorySourceEpisodicImageRelationDao;", "getMemorySourceEpisodicImageRelationDao", "()Lcom/obric/memorydata/database/dao/MemorySourceEpisodicImageRelationDao;", "memorySourceSemanticImageRelationDao", "Lcom/obric/memorydata/database/dao/MemorySourceSemanticImageRelationDao;", "getMemorySourceSemanticImageRelationDao", "()Lcom/obric/memorydata/database/dao/MemorySourceSemanticImageRelationDao;", "middleUserProfileDao", "Lcom/obric/memorydata/database/dao/MiddleUserProfileDao;", "getMiddleUserProfileDao", "()Lcom/obric/memorydata/database/dao/MiddleUserProfileDao;", "memoryProcessUserInsightDao", "Lcom/obric/memorydata/database/dao/MemoryProcessUserInsightDao;", "getMemoryProcessUserInsightDao", "()Lcom/obric/memorydata/database/dao/MemoryProcessUserInsightDao;", "pendingContextDao", "Lcom/obric/memorydata/database/dao/PendingContextDao;", "getPendingContextDao", "()Lcom/obric/memorydata/database/dao/PendingContextDao;", "pendingMemoryCalendarDao", "Lcom/obric/memorydata/database/dao/PendingMemoryCalendarDao;", "getPendingMemoryCalendarDao", "()Lcom/obric/memorydata/database/dao/PendingMemoryCalendarDao;", "pendingSemanticDao", "Lcom/obric/memorydata/database/dao/PendingSemanticDao;", "getPendingSemanticDao", "()Lcom/obric/memorydata/database/dao/PendingSemanticDao;", "personAudioProfileDao", "Lcom/obric/memorydata/database/dao/PersonAudioProfileDao;", "getPersonAudioProfileDao", "()Lcom/obric/memorydata/database/dao/PersonAudioProfileDao;", "personImageProfileDao", "Lcom/obric/memorydata/database/dao/PersonImageProfileDao;", "getPersonImageProfileDao", "()Lcom/obric/memorydata/database/dao/PersonImageProfileDao;", "personProfileDao", "Lcom/obric/memorydata/database/dao/PersonProfileDao;", "getPersonProfileDao", "()Lcom/obric/memorydata/database/dao/PersonProfileDao;", "proactiveEpisodicRelevantDataDao", "Lcom/obric/memorydata/database/dao/ProactiveEpisodicRelevantDataDao;", "getProactiveEpisodicRelevantDataDao", "()Lcom/obric/memorydata/database/dao/ProactiveEpisodicRelevantDataDao;", "proactiveSemanticRelevantDataDao", "Lcom/obric/memorydata/database/dao/ProactiveSemanticRelevantDataDao;", "getProactiveSemanticRelevantDataDao", "()Lcom/obric/memorydata/database/dao/ProactiveSemanticRelevantDataDao;", "userProfileDao", "Lcom/obric/memorydata/database/dao/UserProfileDao;", "getUserProfileDao", "()Lcom/obric/memorydata/database/dao/UserProfileDao;", "userProfileRawDbDao", "Lcom/obric/memorydata/database/dao/UserProfileRawDbDao;", "getUserProfileRawDbDao", "()Lcom/obric/memorydata/database/dao/UserProfileRawDbDao;", "rawUserProfileHistoryRawDbDao", "Lcom/obric/memorydata/database/dao/RawUserProfileHistoryRawDbDao;", "getRawUserProfileHistoryRawDbDao", "()Lcom/obric/memorydata/database/dao/RawUserProfileHistoryRawDbDao;", "userProfileMemoryDao", "Lcom/obric/memorydata/database/dao/UserProfileMemoryDao;", "getUserProfileMemoryDao", "()Lcom/obric/memorydata/database/dao/UserProfileMemoryDao;", "semanticMemoryDao", "Lcom/obric/memorydata/database/dao/SemanticMemoryDao;", "getSemanticMemoryDao", "()Lcom/obric/memorydata/database/dao/SemanticMemoryDao;", "semanticRetractionDao", "Lcom/obric/memorydata/database/dao/SemanticRetractionDao;", "getSemanticRetractionDao", "()Lcom/obric/memorydata/database/dao/SemanticRetractionDao;", "semanticStateDao", "Lcom/obric/memorydata/database/dao/SemanticStateDao;", "getSemanticStateDao", "()Lcom/obric/memorydata/database/dao/SemanticStateDao;", "unionSemanticMemorySnapShotDao", "Lcom/obric/memorydata/database/dao/UnionSemanticMemorySnapShotDao;", "getUnionSemanticMemorySnapShotDao", "()Lcom/obric/memorydata/database/dao/UnionSemanticMemorySnapShotDao;", "unionSemanticMemoryExtDao", "Lcom/obric/memorydata/database/dao/UnionSemanticMemoryExtDao;", "getUnionSemanticMemoryExtDao", "()Lcom/obric/memorydata/database/dao/UnionSemanticMemoryExtDao;", "semanticMemoryHistoryRawDbDao", "Lcom/obric/memorydata/database/entity/UnionSemanticMemoryHistoryRawDbDao;", "getSemanticMemoryHistoryRawDbDao", "()Lcom/obric/memorydata/database/entity/UnionSemanticMemoryHistoryRawDbDao;", "semanticTextCopilotDao", "Lcom/obric/memorydata/database/dao/SemanticTextCopilotDao;", "getSemanticTextCopilotDao", "()Lcom/obric/memorydata/database/dao/SemanticTextCopilotDao;", "unionSemanticTypeSummaryDao", "Lcom/obric/memorydata/database/dao/UnionSemanticTypeSummaryDao;", "getUnionSemanticTypeSummaryDao", "()Lcom/obric/memorydata/database/dao/UnionSemanticTypeSummaryDao;", "unionUserInsightDao", "Lcom/obric/memorydata/database/dao/UnionUserInsightDao;", "getUnionUserInsightDao", "()Lcom/obric/memorydata/database/dao/UnionUserInsightDao;", "unionUserPersonaDao", "Lcom/obric/memorydata/database/dao/UnionUserPersonaDao;", "getUnionUserPersonaDao", "()Lcom/obric/memorydata/database/dao/UnionUserPersonaDao;", "slmAgentWatermarkDao", "Lcom/obric/memorydata/database/dao/SlmAgentWatermarkDao;", "getSlmAgentWatermarkDao", "()Lcom/obric/memorydata/database/dao/SlmAgentWatermarkDao;", "slmAutoMemoryProTempResultDao", "Lcom/obric/memorydata/database/dao/SlmAutoMemoryProTempResultDao;", "getSlmAutoMemoryProTempResultDao", "()Lcom/obric/memorydata/database/dao/SlmAutoMemoryProTempResultDao;", "updateUnionSemanticMemoryDao", "Lcom/obric/memorydata/database/dao/UpdateUnionSemanticMemoryDao;", "getUpdateUnionSemanticMemoryDao", "()Lcom/obric/memorydata/database/dao/UpdateUnionSemanticMemoryDao;", "updateProactiveSemanticRelevantDataDao", "Lcom/obric/memorydata/database/dao/UpdateProactiveSemanticRelevantDataDao;", "getUpdateProactiveSemanticRelevantDataDao", "()Lcom/obric/memorydata/database/dao/UpdateProactiveSemanticRelevantDataDao;", "userKeywordDao", "Lcom/obric/memorydata/database/dao/UserKeywordDao;", "getUserKeywordDao", "()Lcom/obric/memorydata/database/dao/UserKeywordDao;", "userKeywordRefDao", "Lcom/obric/memorydata/database/dao/UserKeywordRefDao;", "getUserKeywordRefDao", "()Lcom/obric/memorydata/database/dao/UserKeywordRefDao;", "userProfileTextVectorCopilotDao", "Lcom/obric/memorydata/database/dao/UserProfileTextEntityTextVectorCopilotDao;", "getUserProfileTextVectorCopilotDao", "()Lcom/obric/memorydata/database/dao/UserProfileTextEntityTextVectorCopilotDao;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class PersonalMemoryFrameDb extends RoomDatabase {
    public PersonalMemoryFrameDb() {
    }

    public abstract AgentWatermarkDao getAgentWatermarkDao();

    public abstract AssistantChatDao getAssistantChatDao();

    public abstract AssistantChatMessageDao getAssistantChatMessageDao();

    public abstract AutoMemoryEpisodicRelevantDataDao getAutoMemoryEpisodicRelevantDataDao();

    public abstract AutoMemoryProDao getAutoMemoryProDao();

    public abstract AutoMemoryProEvaluationStatsDao getAutoMemoryProEvaluationStatsDao();

    public abstract AutoMemoryProHistoryRawDbDao getAutoMemoryProHistoryRawDbDao();

    public abstract AutoMemoryProRawSourceDao getAutoMemoryProRawSourceDao();

    public abstract AutoMemoryProSlmEpisodicMemoryDao getAutoMemoryProSlmEpisodicMemoryDao();

    public abstract AutoMemoryProSlmPersonalInfoDao getAutoMemoryProSlmPersonalInfoDao();

    public abstract AutoMemoryProSnapShotDao getAutoMemoryProSnapShotDao();

    public abstract AutoMemoryProTextEntityTextVectorCopilotDao getAutoMemoryProTextVectorCopilotDao();

    public abstract AutoMemorySemanticRelevantDataDao getAutoMemorySemanticRelevantDataDao();

    public abstract BlockMemoryContentDao getBlockMemoryContentDao();

    public abstract ComplexRecommendQueryDao getComplexRecommendQueryDao();

    public abstract EntityIndexLifecycleDao getEntityIndexLifecycleDao();

    public abstract EpisodicMemoryContentTimeDao getEpisodicMemoryContentTimeDao();

    public abstract EpisodicMemoryDao getEpisodicMemoryDao();

    public abstract EpisodicMemoryHistoryRawDbDao getEpisodicMemoryHistoryRawDbDao();

    public abstract EpisodicMemoryTextVectorCopilotDao getEpisodicMemoryTextVectorCopilotDao();

    public abstract EpisodicTopicMemoryDao getEpisodicTopicMemoryDao();

    public abstract EpisodicTopicMemoryHistoryRawDbDao getEpisodicTopicMemoryHistoryRawDbDao();

    public abstract EpisodicTopicMemoryTextVectorCopilotDao getEpisodicTopicMemoryTextVectorCopilotDao();

    public abstract GlassesEpisodicRelevantDataDao getGlassesEpisodicRelevantDataDao();

    public abstract IndexPendingDao getIndexPendingDao();

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker getInvalidationTracker() {
        return super.getInvalidationTracker();
    }

    public abstract LifeLogTextEntityTextVectorCopilotDao getLifeLogTextVectorCopilotDao();

    public abstract LifelogDao getLifelogDao();

    public abstract LifelogHistoryRawDbDao getLifelogHistoryRawDbDao();

    public abstract MemoryBaseRequirementDao getMemoryBaseRequirementDao();

    public abstract MemoryBaseSceneDao getMemoryBaseSceneDao();

    public abstract MemoryContextSyncDao getMemoryContextSyncDao();

    public abstract MemoryEntityCorrelationDao getMemoryEntityCorrelationDao();

    public abstract MemoryEntityToCalendarDao getMemoryEntityToCalendarDao();

    public abstract MemoryKeyInfoDao getMemoryKeyInfoDao();

    public abstract MemoryProcessUserInsightDao getMemoryProcessUserInsightDao();

    public abstract MemoryReviewFeedbackDao getMemoryReviewFeedbackDao();

    public abstract MemoryRuleDao getMemoryRuleDao();

    public abstract MemorySourceEpisodicImageRelationDao getMemorySourceEpisodicImageRelationDao();

    public abstract MemorySourceImageRelationDao getMemorySourceImageRelationDao();

    public abstract MemorySourceSemanticImageRelationDao getMemorySourceSemanticImageRelationDao();

    public abstract MemorySynthesisDao getMemorySynthesisDao();

    public abstract MiddleUserProfileDao getMiddleUserProfileDao();

    public abstract PendingContextDao getPendingContextDao();

    public abstract PendingEpisodicDao getPendingEpisodicDao();

    public abstract PendingMemoryCalendarDao getPendingMemoryCalendarDao();

    public abstract PendingSemanticDao getPendingSemanticDao();

    public abstract PersonAudioProfileDao getPersonAudioProfileDao();

    public abstract PersonImageProfileDao getPersonImageProfileDao();

    public abstract PersonProfileDao getPersonProfileDao();

    public abstract ProactiveEpisodicRelevantDataDao getProactiveEpisodicRelevantDataDao();

    public abstract ProactiveSemanticRelevantDataDao getProactiveSemanticRelevantDataDao();

    public abstract RawUserProfileHistoryRawDbDao getRawUserProfileHistoryRawDbDao();

    public abstract SemanticMemoryDao getSemanticMemoryDao();

    public abstract it getSemanticMemoryHistoryRawDbDao();

    public abstract SemanticRetractionDao getSemanticRetractionDao();

    public abstract SemanticStateDao getSemanticStateDao();

    public abstract SemanticTextCopilotDao getSemanticTextCopilotDao();

    public abstract SlmAgentWatermarkDao getSlmAgentWatermarkDao();

    public abstract SlmAutoMemoryProTempResultDao getSlmAutoMemoryProTempResultDao();

    public abstract UnionSemanticMemoryExtDao getUnionSemanticMemoryExtDao();

    public abstract UnionSemanticMemorySnapShotDao getUnionSemanticMemorySnapShotDao();

    public abstract UnionSemanticTypeSummaryDao getUnionSemanticTypeSummaryDao();

    public abstract UnionUserInsightDao getUnionUserInsightDao();

    public abstract UnionUserPersonaDao getUnionUserPersonaDao();

    public abstract UpdateProactiveSemanticRelevantDataDao getUpdateProactiveSemanticRelevantDataDao();

    public abstract UpdateUnionSemanticMemoryDao getUpdateUnionSemanticMemoryDao();

    public abstract UserKeywordDao getUserKeywordDao();

    public abstract UserKeywordRefDao getUserKeywordRefDao();

    public abstract UserProfileDao getUserProfileDao();

    public abstract UserProfileMemoryDao getUserProfileMemoryDao();

    public abstract UserProfileRawDbDao getUserProfileRawDbDao();

    public abstract UserProfileTextEntityTextVectorCopilotDao getUserProfileTextVectorCopilotDao();
}
