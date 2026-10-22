package kc8;

import com.larus.common_ui.video.VideoPlayView;
import com.larus.im.bean.message.CreationItem;
import com.larus.im.bean.message.Message;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public interface d0 {
    s0 a();

    void b(VideoPlayView r1, Message r2, CreationItem r3, int r4, q r5, CoroutineScope r6, JSONObject r7, fn8.r r8, fn8.s r9);

    void recycle();
}
