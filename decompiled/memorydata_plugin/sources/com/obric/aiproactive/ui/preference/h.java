package com.obric.aiproactive.ui.preference;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.zetetic.database.sqlcipher.SQLiteDatabase;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t¨\u0006\u000b"}, d2 = {"Lcom/obric/aiproactive/ui/preference/GuidedPreferenceInterviewLauncher;", "", "<init>", "()V", "open", "", "context", "Landroid/content/Context;", AILabCheckPermissionTask.KEY_SOURCE, "", "enterFrom", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f6772a = null;

    static {
        f6772a = new h();
    }

    private h() {
    }

    public final boolean a(Context r4, String r5, String r6) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r5, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r6, "enterFrom");
        Intent r1 = new Intent();
        r1.setClassName(r3, "com.obric.aiproactive.ui.preference.GuidedPreferenceInterviewActivity");
        r1.putExtra(AILabCheckPermissionTask.KEY_SOURCE, r5);
        r1.putExtra("enter_from", r6);
        if (ZeusTransformUtils.instanceOf(r3, Activity.class) == true) goto L9;
        r1.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
    L9:
        ZeusTransformUtils.startActivity(r3, r1, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L7
        return true;
    L7:
        return false;
    }
}
