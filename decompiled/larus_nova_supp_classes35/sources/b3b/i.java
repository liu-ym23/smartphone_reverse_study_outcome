package b3b;

import android.view.View;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.widget.photopicker.animation.activitytransition.ActivityTransitionLauncher;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface i {
    void n(View r1, String r2, List<Object> r3, int r4);

    void s(View r1, ActivityTransitionLauncher.LocationInfo r2, PhotoItem r3, boolean r4, boolean r5, int r6, Message.SourceType r7);

    void v(View r1, PhotoItem r2, boolean r3);
}
