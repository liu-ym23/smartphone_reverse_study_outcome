package sb0;

import com.bytedance.android.live.base.model.user.IBaseUser;
import java.util.Map;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public interface e {
    String a();

    boolean b();

    k c(Integer r1);

    Map<String, String> getAnchorAbMap();

    com.bytedance.android.live.pushstream.d getLiveStream();

    IBaseUser getOwner();

    long getRoomId();

    boolean isAnchor();
}
