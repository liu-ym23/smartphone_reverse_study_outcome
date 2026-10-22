package com.obric.lifelog.data;

import android.content.Context;
import android.content.Intent;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.notification.UniversalNotificationUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/lifelog/data/LifeLogNotification;", "", "<init>", "()V", "TAG", "", "LIFE_LOG_KEY", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "lifelog_data_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8049a = null;

    /* JADX INFO: renamed from: com.obric.lifelog.data.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/lifelog/data/LifeLogNotification$init$1", "Lcom/obric/memorydata/utils/notification/UniversalNotificationUtils$OnNotificationClickListener;", "onNotificationClick", "", Params.CONTENT, "Lcom/obric/memorydata/utils/notification/UniversalNotificationUtils$NotificationContent;", "lifelog_data_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0396a implements UniversalNotificationUtils.c {
        C0396a() {
        }

        @Override // com.obric.memorydata.utils.notification.UniversalNotificationUtils.c
        public void a(int r1) {
            UniversalNotificationUtils.c.a.a(this, r1);
        }

        @Override // com.obric.memorydata.utils.notification.UniversalNotificationUtils.c
        public void a(UniversalNotificationUtils.NotificationContent r9) {
            Intrinsics.checkNotNullParameter(r9, Params.CONTENT);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LifeLogNotification", r9.getId(), false, 4, null);
            if (r9.getExtras().containsKey("life_log") == false) goto L10;
            Intent r8 = new Intent("android.intent.action.MAIN");
            r8.setPackage("com.obric.lifelog");
            r8.setClassName("com.obric.lifelog", "com.obric.lifelog.ui.list.LifelogActivity");
            r8.putExtra("navigate", true);
            String r10 = (String) ZeusTransformUtils.preCheckCast(r9.getExtras().get("life_log"), String.class, "com.obric.memorydata.plugin");
            if (r10 == null) goto L7;
            long r2 = Long.parseLong(r10);
        L8:
            r8.putExtra("timestamp", r2);
            r8.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            ZeusTransformUtils.startActivity((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r8, "com.obric.memorydata.plugin");
            return;
        L7:
            r2 = 0;
            goto L8
        }
    }

    static {
        f8049a = new a();
    }

    private a() {
    }

    public final void a() {
        UniversalNotificationUtils.f13251a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).a((UniversalNotificationUtils.c) ZeusTransformUtils.preCheckCast(new C0396a(), UniversalNotificationUtils.c.class, "com.obric.memorydata.plugin"));
    }
}
