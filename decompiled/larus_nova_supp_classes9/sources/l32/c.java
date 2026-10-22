package l32;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.loader.e;
import com.bytedance.android.livesdk.room.external.toolbar.ToolbarLoader;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public interface c {
    void a();

    Disposable b(MiddlewareRoomContext r1);

    ToolbarLoader c(e r1, Context r2);
}
