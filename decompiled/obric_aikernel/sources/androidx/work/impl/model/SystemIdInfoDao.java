package androidx.work.impl.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.bytedance.bdinstall.oaid.OaidModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Dao
public interface SystemIdInfoDao {

    public static final class DefaultImpls {
        public static SystemIdInfo getSystemIdInfo(SystemIdInfoDao r10, WorkGenerationalId r11) {
            Intrinsics.checkNotNullParameter(r11, OaidModel.KEY_ID);
            return r10.getSystemIdInfo(r11.getWorkSpecId(), r11.getGeneration());
        }

        public static void removeSystemIdInfo(SystemIdInfoDao r10, WorkGenerationalId r11) {
            Intrinsics.checkNotNullParameter(r11, OaidModel.KEY_ID);
            r10.removeSystemIdInfo(r11.getWorkSpecId(), r11.getGeneration());
        }
    }

    SystemIdInfo getSystemIdInfo(WorkGenerationalId r10);

    @Query("SELECT * FROM SystemIdInfo WHERE work_spec_id=:workSpecId AND generation=:generation")
    SystemIdInfo getSystemIdInfo(String r10, int r11);

    @Query("SELECT DISTINCT work_spec_id FROM SystemIdInfo")
    List<String> getWorkSpecIds();

    @Insert(onConflict = 1)
    void insertSystemIdInfo(SystemIdInfo r10);

    void removeSystemIdInfo(WorkGenerationalId r10);

    @Query("DELETE FROM SystemIdInfo where work_spec_id=:workSpecId")
    void removeSystemIdInfo(String r10);

    @Query("DELETE FROM SystemIdInfo where work_spec_id=:workSpecId AND generation=:generation")
    void removeSystemIdInfo(String r10, int r11);
}
