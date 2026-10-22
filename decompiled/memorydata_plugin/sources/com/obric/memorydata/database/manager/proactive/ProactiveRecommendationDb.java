package com.obric.memorydata.database.manager.proactive;

import androidx.room.RoomDatabase;
import com.obric.memorydata.database.dao.ProactiveAgentMemoryDao;
import com.obric.memorydata.database.dao.ProactiveEcaConditionDao;
import com.obric.memorydata.database.dao.ProactiveInspirationDao;
import com.obric.memorydata.database.dao.ProactiveMemoryRuleDao;
import com.obric.memorydata.database.dao.ProactivePhoneEventDao;
import com.obric.memorydata.database.dao.ProactiveRecommendationsDao;
import com.obric.memorydata.database.dao.ProactiveSubscriptionTasksDao;
import com.obric.memorydata.database.dao.ProactiveUserSubscriptionsDao;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0013H&¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/database/manager/proactive/ProactiveRecommendationDb;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "proactiveUserSubscriptionsDao", "Lcom/obric/memorydata/database/dao/ProactiveUserSubscriptionsDao;", "proactiveSubscriptionTasksDao", "Lcom/obric/memorydata/database/dao/ProactiveSubscriptionTasksDao;", "proactiveRecommendationsDao", "Lcom/obric/memorydata/database/dao/ProactiveRecommendationsDao;", "proactiveEcaConditionDao", "Lcom/obric/memorydata/database/dao/ProactiveEcaConditionDao;", "proactiveInspirationDao", "Lcom/obric/memorydata/database/dao/ProactiveInspirationDao;", "proactiveMemoryRuleDao", "Lcom/obric/memorydata/database/dao/ProactiveMemoryRuleDao;", "proactivePhoneEventDao", "Lcom/obric/memorydata/database/dao/ProactivePhoneEventDao;", "proactiveAgentMemoryDao", "Lcom/obric/memorydata/database/dao/ProactiveAgentMemoryDao;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ProactiveRecommendationDb extends RoomDatabase {
    public ProactiveRecommendationDb() {
    }

    public abstract ProactiveAgentMemoryDao proactiveAgentMemoryDao();

    public abstract ProactiveEcaConditionDao proactiveEcaConditionDao();

    public abstract ProactiveInspirationDao proactiveInspirationDao();

    public abstract ProactiveMemoryRuleDao proactiveMemoryRuleDao();

    public abstract ProactivePhoneEventDao proactivePhoneEventDao();

    public abstract ProactiveRecommendationsDao proactiveRecommendationsDao();

    public abstract ProactiveSubscriptionTasksDao proactiveSubscriptionTasksDao();

    public abstract ProactiveUserSubscriptionsDao proactiveUserSubscriptionsDao();
}
