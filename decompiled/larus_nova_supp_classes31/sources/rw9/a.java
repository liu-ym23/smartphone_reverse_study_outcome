package rw9;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import sw9.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a extends ym9.a {

    /* JADX INFO: renamed from: rw9.a$a, reason: collision with other inner class name */
    public static final class C0072a {
    }

    static {
    }

    public final String getPanelName() {
        return "chat_input";
    }

    public a() {
    }

    public final int getPanelHeight(Context r4) {
        int r5 = g.a().getChatInputHeight();
        FLogger.a.i("SheetEditPanelDelegate", "getPanelHeight: " + r5);
        return r5;
    }
}
