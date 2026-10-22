package rfb;

import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.ErrorLevel;
import com.ss.android.lark.appreciablelib.ErrorParams;
import com.ss.android.lark.appreciablelib.ErrorType;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void a(boolean r17, ErrorType r18, int r19, String r20) {
        Intrinsics.checkNotNullParameter(r18, "errorType");
        ErrorParams r0 = new ErrorParams(Biz.Messenger, Scene.Chat, Event.file_download, r18, ErrorLevel.Fatal, r19, null, null, r20, Boolean.TRUE, null, null, MapsKt.mapOf(TuplesKt.to("is_crypto", Boolean.valueOf(r17))), 3264, null);
        AppreciableKit.Companion.getInstance().error(r0);
    }
}
