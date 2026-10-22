package dx1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.feedback.FeedbackCard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public interface a {
    View a(LayoutInflater r1, ViewGroup r2);

    void b();

    void c(FeedbackCard r1);

    void onDestroy();

    void onSlide();

    void onViewCreated(View r1);

    void startRoom();

    void stopRoom();
}
