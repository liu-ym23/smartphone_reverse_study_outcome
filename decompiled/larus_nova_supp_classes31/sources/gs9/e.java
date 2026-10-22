package gs9;

import androidx.lifecycle.LiveData;
import com.larus.platform.api.creation.UserCreation;
import com.larus.profile.api.bean.UserCreationModel;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public interface e {
    void checkLoadMore();

    void deleteUserCreation(String r1, boolean r2);

    LiveData<List<UserCreationModel>> getFeedDataLiveData();

    LiveData<i> getMoreState();

    void updateCreationContent(UserCreation r1);

    void updateCreationModelPrivacy(int r1, boolean r2, UserCreation r3, boolean r4);
}
