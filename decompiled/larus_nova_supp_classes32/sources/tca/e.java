package tca;

import android.os.Parcelable;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aiagent.assistant.idl.bean.AppIntentCardData;
import com.obric.aiagent.assistant.idl.bean.AppIntentMessage;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.AppInfoEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static List b(AppIntentMessage r4) {
        Intrinsics.checkNotNullParameter(r4, LynxResourceModule.DATA_KEY);
        List<Parcelable> r5 = com.obric.assistant.card.utils.c.d(r4);
        if (r5 != null) goto L5;
        r5 = CollectionsKt.emptyList();
    L5:
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L20;
        AppIntentCardData r1 = (Parcelable) r6.next();
        AppInfoEntity r3 = null;
        if ((r1 instanceof AppIntentCardData) == false) goto L11;
        AppIntentCardData r2 = r1;
    L12:
        if (r2 == null) goto L14;
        AppEntity r7 = r2.getAppEntity();
    L16:
        if ((r7 instanceof AppInfoEntity) == false) goto L18;
        r3 = (AppInfoEntity) r7;
    L18:
        if (r3 == null) goto L7;
        r0.add(r3);
        goto L7
    L14:
        r7 = null;
        goto L16
    L11:
        r2 = null;
        goto L12
    L20:
        return r0;
    }

    public static int c(AppIntentMessage r1) {
        Intrinsics.checkNotNullParameter(r1, LynxResourceModule.DATA_KEY);
        Map r2 = r1.getExt();
        if (r2 == null) goto L10;
        String r3 = (String) r2.get("operate_type");
        if (r3 == null) goto L10;
        Integer r4 = StringsKt.toIntOrNull(r3);
        if (r4 == null) goto L10;
        return r4.intValue();
    L10:
        return 0;
    }

    public static int a(int r5, AppInfoEntity r6) {
        Intrinsics.checkNotNullParameter(r6, "entity");
        int r0 = r6.getAppStatus();
        boolean r7 = r6.isExactMatch();
        if (r5 == 0) goto L16;
        if (r5 != 1) goto L23;
        if (r0 == 0) goto L23;
        if (r0 == 2) goto L29;
        if (r7 == true) goto L13;
        if (r0 == 4) goto L23;
    L13:
        if (r7 == false) goto L23;
        if (r0 != 3) goto L23;
    L22:
        return 1;
    L29:
        return 2;
    L23:
        return 0;
    L16:
        if (r0 == 1) goto L21;
        if (r0 == 2) goto L25;
        if (r0 == 3) goto L26;
        if (r0 != 4) goto L23;
        return 2;
    L26:
        return 2;
    L25:
        return 2;
    L21:
        if (r7 == false) goto L23;
        goto L22
    }
}
