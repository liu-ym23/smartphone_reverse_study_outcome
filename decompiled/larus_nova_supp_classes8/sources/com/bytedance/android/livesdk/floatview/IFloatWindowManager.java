package com.bytedance.android.livesdk.floatview;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.view.IVideoFloatManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nH&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\r\u001a\u00020\u0003H&J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\u0010\u001a\u00020\u0003H&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/floatview/IFloatWindowManager;", "Lcom/bytedance/android/live/base/IService;", "addVideoFloatManagerListener", "", "listener", "Lcom/bytedance/android/livesdkapi/view/IVideoFloatManager$VideoFloatManagerListener;", "getCurRoom", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "hideFloatWindow", "isAutoClose", "", "isDestroyCause", "removeVideoFloatManagerListener", "reset", "setRoom", "room", "showFloatWindow", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IFloatWindowManager extends IService {

    public static final class a {
        public static /* synthetic */ void a(VideoFloatWindowManager r2, boolean r3, int r4) {
            if ((r4 & 1) == 0) goto L5;
            boolean r0 = true;
        L7:
            if ((r4 & 2) == 0) goto L9;
            r3 = false;
        L9:
            r2.hideFloatWindow(r0, r3);
            return;
        L5:
            r0 = false;
            goto L7
        }
    }

    void addVideoFloatManagerListener(IVideoFloatManager.VideoFloatManagerListener r1);

    Room getCurRoom();

    void hideFloatWindow(boolean r1, boolean r2);

    void removeVideoFloatManagerListener(IVideoFloatManager.VideoFloatManagerListener r1);

    void reset();

    void setRoom(Room r1);

    void showFloatWindow();
}
