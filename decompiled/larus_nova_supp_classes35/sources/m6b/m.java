package m6b;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.keyboard.dtocompat.FrameInfo;
import com.ss.android.lark.keyboard.dtocompat.VideoInfo;
import com.ss.android.lark.todo.impl.features.detail.comment.CommentKeyboardSection;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface m {
    Observable<Map<String, FrameInfo>> Db(List<VideoInfo> r1);

    Observable M4(List r1, boolean r2, CommentKeyboardSection.handleActivityResult.1 r3, Biz r4, Scene r5);

    void d2(String r1, boolean r2, IGetDataCallback<List<MessageInfo>> r3);
}
