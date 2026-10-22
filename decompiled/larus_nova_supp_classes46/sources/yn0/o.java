package yn0;

import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.room.IMicRoomService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o implements l81.o {
    public static final o a = null;

    public o() {
    }

    static {
        a = new o();
    }

    public final Class<? extends LiveRecyclableWidget> getMicRoomOfficialInfoWidget() {
        return jc1.k.n(IMicRoomService.class).getMicRoomOfficialInfoWidget();
    }
}
