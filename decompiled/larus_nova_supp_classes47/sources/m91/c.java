package m91;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface c {
    boolean a();

    aa1.a b();

    boolean c();

    LifecycleOwner e();

    k getAvatarThumb();

    Context getContext();

    DataCenter getDataCenter();

    Fragment getFragment();

    String getName();

    IRoom getRoom();

    DataContext getRoomContext();

    boolean isAnchor();

    boolean isPortrait();
}
