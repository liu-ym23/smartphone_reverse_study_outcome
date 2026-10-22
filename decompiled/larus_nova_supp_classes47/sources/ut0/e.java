package ut0;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface e {
    MutableLiveData<Boolean> a();

    void b(boolean r1);

    void c(Context r1, UserProfileEvent r2);

    void d(Activity r1, UserProfileEvent r2);

    void showAnonymousUserSilentDialog(Context r1);
}
