package com.ss.android.lark.conditional.access.nopermission.manager;

import android.app.Activity;
import android.app.Dialog;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.conditional.access.traffic.InternalSecurityAction;
import com.ss.android.lark.conditional.access.traffic.RegulateDispatcher;
import io.reactivex.subjects.PublishSubject;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class SecurityDialogUtil {
    public static WeakReference<Dialog> a;
    public static WeakReference<Activity> b;
    public static InternalSecurityAction c;
    public static final Lazy d = null;
    public static final Map<String, Integer> e = null;
    public static final Map<String, Integer> f = null;

    static {
        new AtomicBoolean(false);
        d = LazyKt.lazy(SecurityDialogUtil$mainHandler$2.INSTANCE);
        e = MapsKt.mapOf(new Pair[]{TuplesKt.to("IM_MSG_FILE_UPLOAD", 2131892723), TuplesKt.to("CCM_ATTACHMENT_UPLOAD", 2131892723), TuplesKt.to("CCM_FILE_UPLOAD", 2131892723), TuplesKt.to("APPROVAL_FILE_UPLOAD", 2131892723), TuplesKt.to("IM_MSG_FILE_DOWNLOAD", 2131892720), TuplesKt.to("IM_MSG_FILE_SAVE", 2131892720), TuplesKt.to("CCM_ATTACHMENT_DOWNLOAD", 2131892720), TuplesKt.to("CCM_FILE_DOWNLOAD", 2131892720), TuplesKt.to("CCM_EXPORT", 2131892720), TuplesKt.to("APPROVAL_FILE_DOWNLOAD", 2131892720), TuplesKt.to("CCM_PRINT", 2131892722), TuplesKt.to("APPROVAL_FILE_PRINT", 2131892722), TuplesKt.to("IM_MSG_FILE_COPY", 2131892718), TuplesKt.to("CCM_CONTENT_COPY", 2131892718), TuplesKt.to("VC_MM_CONTENT_COPY", 2131892718), TuplesKt.to("CCM_CREATE_COPY", 2131892721), TuplesKt.to("CCM_MOVE_RECYCLE_BIN", 2131892719), TuplesKt.to("CCM_DELETE_FROM_RECYCLE_BIN", 2131892719), TuplesKt.to("VC_MM_MOVE_RECYCLE_BIN", 2131892719), TuplesKt.to("VC_MM_DELETE_FROM_RECYCLE_BIN", 2131892719), TuplesKt.to("IM_MSG_FILE_SHARE", 2131890727), TuplesKt.to("CCM_SHARE", 2131890727), TuplesKt.to("CCM_AUTH", 2131890727), TuplesKt.to("IM_MSG_FILE_PREVIEW", 2131892724), TuplesKt.to("CCM_CONTENT_PREVIEW", 2131892724), TuplesKt.to("CCM_FILE_PREVIEW", 2131892724), TuplesKt.to("APPROVAL_FILE_PREVIEW", 2131892724), TuplesKt.to("IM_MSG_FILE_READ", 2131890727)});
        f = MapsKt.mapOf(new Pair[]{TuplesKt.to("IM_MSG_FILE_UPLOAD", 2131890492), TuplesKt.to("CCM_ATTACHMENT_UPLOAD", 2131890491), TuplesKt.to("CCM_FILE_UPLOAD", 2131890493), TuplesKt.to("APPROVAL_FILE_UPLOAD", 2131890491), TuplesKt.to("IM_MSG_FILE_DOWNLOAD", 2131890486), TuplesKt.to("IM_MSG_FILE_SAVE", 2131890486), TuplesKt.to("CCM_ATTACHMENT_DOWNLOAD", 2131890485), TuplesKt.to("CCM_FILE_DOWNLOAD", 2131890499), TuplesKt.to("CCM_EXPORT", 2131890499), TuplesKt.to("APPROVAL_FILE_DOWNLOAD", 2131890485), TuplesKt.to("CCM_PRINT", 2131890489), TuplesKt.to("APPROVAL_FILE_PRINT", 2131890489), TuplesKt.to("IM_MSG_FILE_COPY", 2131890496), TuplesKt.to("CCM_CONTENT_COPY", 2131890484), TuplesKt.to("VC_MM_CONTENT_COPY", 2131890730), TuplesKt.to("CCM_CREATE_COPY", 2131890487), TuplesKt.to("CCM_MOVE_RECYCLE_BIN", 2131890498), TuplesKt.to("CCM_DELETE_FROM_RECYCLE_BIN", 2131890498), TuplesKt.to("VC_MM_MOVE_RECYCLE_BIN", 2131890731), TuplesKt.to("VC_MM_DELETE_FROM_RECYCLE_BIN", 2131890731), TuplesKt.to("IM_MSG_FILE_SHARE", 2131890490), TuplesKt.to("CCM_SHARE", 2131890490), TuplesKt.to("CCM_AUTH", 2131890490), TuplesKt.to("IM_MSG_FILE_PREVIEW", 2131890488), TuplesKt.to("CCM_CONTENT_PREVIEW", 2131890488), TuplesKt.to("CCM_FILE_PREVIEW", 2131890488), TuplesKt.to("APPROVAL_FILE_PREVIEW", 2131890488), TuplesKt.to("IM_MSG_FILE_READ", 2131890500)});
    }

    public static Pair a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "operation");
        Integer r0 = e.get(r2);
        if (r0 == null) goto L5;
        int r1 = r0.intValue();
    L6:
        Integer r3 = f.get(r2);
        if (r3 == null) goto L9;
        int r4 = r3.intValue();
    L11:
        return new Pair(Integer.valueOf(r1), Integer.valueOf(r4));
    L9:
        r4 = 2131890495;
        goto L11
    L5:
        r1 = 2131890494;
        goto L6
    }

    public static void b(InternalSecurityAction r2) {
        Intrinsics.checkNotNullParameter(r2, "internalSecurityAction");
        List<DecisionData.Action> r0 = CollectionsKt.toMutableList(r2.getActions());
        r0.remove(r2.getCurrentAction());
        r2.setActions(r0);
        DecisionData.Action r1 = (DecisionData.Action) CollectionsKt.firstOrNull(r0);
        if (r1 != null) goto L5;
        r1 = new DecisionData.Action();
    L5:
        r2.setCurrentAction(r1);
        PublishSubject<InternalSecurityAction> r3 = RegulateDispatcher.a;
        Object r4 = r2.getInternalParams().get("comeFrom");
        if (r4 != null) goto L8;
        r4 = "SDK_INTERNAL";
    L8:
        RegulateDispatcher.a(r2, (String) r4);
    }
}
