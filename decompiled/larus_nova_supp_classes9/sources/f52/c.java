package f52;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.CleanStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.ConflictStrategy;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.topcontainer.DiscardReason;
import com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.PSTopContainer;
import com.bytedance.android.livesdkapi.message.HighlightAreaPriorityConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface c {
    void a(DiscardReason r1);

    CleanStrategy b(b r1, c r2);

    HighlightAreaPriorityConfig c();

    ConflictStrategy d();

    void e(c r1, PSTopContainer r2);

    ConflictStrategy f();

    boolean g();

    int getDelayTime();

    int getDuration();

    long getEndTimestamp();

    String getId();

    long getStartTimestamp();

    f getType();

    void h(b r1);

    CleanStrategy i(b r1);

    boolean j(c r1);

    ConflictStrategy k();

    int l();
}
