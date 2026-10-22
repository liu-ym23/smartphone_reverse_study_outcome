package pmb;

import android.app.Activity;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface c {
    void pickGroupMember(Activity r1, String r2, List<String> r3, boolean r4, String r5, IGetDataCallback<List<ChatChatter>> r6);

    void pickTargetMember(Activity r1, List<String> r2, List<String> r3, boolean r4, String r5, IGetDataCallback<List<ChatChatter>> r6);
}
