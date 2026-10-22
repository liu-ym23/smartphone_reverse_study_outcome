package cx9;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import ex9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class b extends ym9.a {

    public static final class a {
    }

    static {
    }

    public final String getPanelName() {
        return "chat_input";
    }

    public b() {
    }

    public final int getPanelHeight(Context r4) {
        int r5 = e.a().getChatInputHeight();
        FLogger.a.i("SlidesEditPanelDelegate", "getPanelHeight: " + r5);
        return r5;
    }
}
