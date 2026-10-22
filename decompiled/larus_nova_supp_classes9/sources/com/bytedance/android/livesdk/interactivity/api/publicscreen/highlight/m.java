package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.trigger.TopicDismissTrigger;
import com.bytedance.android.livesdk.message.model.b6;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface m {

    public interface a {
        void a(TriggerKey r1);
    }

    public interface b {
        TopicDismissTrigger a(DataCenter r1, b6.b r2);
    }

    public static final class c {
        public final List<b> a;

        public c() {
            this.a = new ArrayList();
        }
    }

    void a(a r1);

    void b(b6.b r1);

    void release();
}
