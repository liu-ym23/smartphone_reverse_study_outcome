package androidx.work.impl.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.bytedance.bdinstall.oaid.OaidModel;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Dao
public interface WorkTagDao {

    public static final class DefaultImpls {
        public static void insertTags(WorkTagDao r10, String r11, Set<String> r12) {
            Intrinsics.checkNotNullParameter(r11, OaidModel.KEY_ID);
            Intrinsics.checkNotNullParameter(r12, "tags");
            Iterator<T> r13 = r12.iterator();
        L4:
            if (r13.hasNext() == false) goto L6;
            r10.insert(new WorkTag((String) r13.next(), r11));
            goto L4
        }
    }

    @Query("DELETE FROM worktag WHERE work_spec_id=:id")
    void deleteByWorkSpecId(String r10);

    @Query("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=:id")
    List<String> getTagsForWorkSpecId(String r10);

    @Query("SELECT work_spec_id FROM worktag WHERE tag=:tag")
    List<String> getWorkSpecIdsWithTag(String r10);

    @Insert(onConflict = 5)
    void insert(WorkTag r10);

    void insertTags(String r10, Set<String> r11);
}
