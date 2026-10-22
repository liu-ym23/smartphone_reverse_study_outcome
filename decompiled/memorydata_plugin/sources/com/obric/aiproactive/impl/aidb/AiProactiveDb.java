package com.obric.aiproactive.impl.aidb;

import androidx.room.RoomDatabase;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0017H&¨\u0006\u0018"}, d2 = {"Lcom/obric/aiproactive/impl/aidb/AiProactiveDb;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "eventRecordDao", "Lcom/obric/aiproactive/impl/aidb/dao/AiProactiveEventRecordDao;", "recommendationDao", "Lcom/obric/aiproactive/impl/aidb/dao/AiProactiveRecommendationDao;", "directFeedbackDao", "Lcom/obric/aiproactive/impl/aidb/dao/AiProactiveDirectFeedbackDao;", "traceDao", "Lcom/obric/aiproactive/impl/aidb/dao/AiProactiveTraceDao;", "taskDao", "Lcom/obric/aiproactive/impl/aidb/dao/AiProactiveTaskDao;", "preferenceDao", "Lcom/obric/aiproactive/impl/aidb/dao/AiProactivePreferenceDao;", "ecaDao", "Lcom/obric/aiproactive/impl/aidb/dao/AiProactiveEcaDao;", "messageDao", "Lcom/obric/aiproactive/impl/aidb/dao/AiProactiveMessageDao;", "messageBackupDao", "Lcom/obric/aiproactive/impl/aidb/dao/AiProactiveMessageBackupDao;", "spellEcaDao", "Lcom/obric/aiproactive/impl/aidb/dao/SpellProactiveEcaDao;", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AiProactiveDb extends RoomDatabase {
    public AiProactiveDb() {
    }

    public abstract com.obric.aiproactive.impl.aidb.dao.a directFeedbackDao();

    public abstract com.obric.aiproactive.impl.aidb.dao.b ecaDao();

    public abstract com.obric.aiproactive.impl.aidb.dao.c eventRecordDao();

    public abstract com.obric.aiproactive.impl.aidb.dao.d messageBackupDao();

    public abstract com.obric.aiproactive.impl.aidb.dao.e messageDao();

    public abstract com.obric.aiproactive.impl.aidb.dao.f preferenceDao();

    public abstract com.obric.aiproactive.impl.aidb.dao.g recommendationDao();

    public abstract com.obric.aiproactive.impl.aidb.dao.j spellEcaDao();

    public abstract com.obric.aiproactive.impl.aidb.dao.h taskDao();

    public abstract com.obric.aiproactive.impl.aidb.dao.i traceDao();
}
