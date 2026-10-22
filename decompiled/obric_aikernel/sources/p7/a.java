package p7;

import androidx.core.app.NotificationCompat;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final void a(String r10, Function0<String> r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        if (AppContext.INSTANCE.isAdminMode() == false) goto L6;
        AIKLog.INSTANCE.v(r10, r11.invoke());
        return;
    }
}
