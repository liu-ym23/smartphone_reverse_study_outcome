package com.obric.memorydata.memory.ui;

import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.ui.BaseAuthActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\u0007\u001a\u00020\u0005H\u0014J\b\u0010\b\u001a\u00020\u0005H\u0014J\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\nH\u0014J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/memorydata/memory/ui/BaseMemoryActivity;", "Lcom/obric/memorydata/ui/BaseAuthActivity;", "<init>", "()V", "activityStarted", "", "needLoginCheckOnCreate", "needLoginCheckOnResume", "checkAdditionalPageAccess", "onStart", "", "onStop", "onTrimMemory", "level", "", "getEnterFrom", "", "shouldFinishBackgroundActivity", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class BaseMemoryActivity extends BaseAuthActivity {
    public static final a Companion = null;
    private static final String TAG = "BaseMemoryActivity";
    private boolean activityStarted;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/BaseMemoryActivity$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public BaseMemoryActivity() {
    }

    private final boolean shouldFinishBackgroundActivity(int r1) {
        if (r1 != 10) goto L5;
    L10:
        return true;
    L5:
        if (r1 == 15) goto L10;
        if (r1 >= 40) goto L10;
        return false;
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public boolean checkAdditionalPageAccess() {
        if (UserSettings.INSTANCE.isEnterpriseAccount() == true) goto L6;
        return true;
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "finish Memory activity for enterprise account, activity=" + getClass().getName(), false, 4, null);
        if (isTaskRoot() == false) goto L9;
        finishAndRemoveTask();
        return false;
    L9:
        finish();
        return false;
    }

    public String getEnterFrom() {
        return "";
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public boolean needLoginCheckOnCreate() {
        return true;
    }

    @Override // com.obric.memorydata.ui.BaseActivity
    public boolean needLoginCheckOnResume() {
        return true;
    }

    @Override // com.obric.memorydata.ui.BaseAuthActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStart() {
        super.onStart();
        this.activityStarted = true;
    }

    @Override // com.obric.memorydata.ui.BaseAuthActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onStop() {
        this.activityStarted = false;
        super.onStop();
    }

    @Override // androidx.activity.ComponentActivity
    public void onTrimMemory(int r8) {
        super.onTrimMemory(r8);
        if (shouldFinishBackgroundActivity(r8) == true) goto L6;
        return;
    L6:
        if (this.activityStarted == false) goto L8;
        return;
    L8:
        if (isFinishing() == false) goto L10;
        return;
    L10:
        if (isDestroyed() == true) goto L16;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "finish background Memory activity, level=" + r8 + ", activity=" + getClass().getName(), null, 4, null);
        finish();
        return;
    }
}
