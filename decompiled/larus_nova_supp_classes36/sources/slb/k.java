package slb;

import com.ss.android.lark.inline.ai.api.InlineAIError;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface k {
    void a(InlineAIError r1);

    List<h> onFinish();

    void onMessage(String r1);

    l onStart();
}
