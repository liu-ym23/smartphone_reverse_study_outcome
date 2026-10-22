package com.obric.memorydata.memory.ui.share;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.memorydata.memory.v;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.activity.GeneratePluginActivity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/memory/ui/share/MemoryShareActivity;", "Landroid/app/Activity;", "<init>", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "finish", "prepareTransitWindow", "finishForEnterpriseAccount", "", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryShareActivity extends GeneratePluginActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11523a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/ui/share/MemoryShareActivity$Companion;", "", "<init>", "()V", "TAG", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f11523a = new a(null);
    }

    public MemoryShareActivity() {
    }

    private final void a() {
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        Window r2 = getWindow();
        r2.getDecorView().setSystemUiVisibility(5888);
        r2.setStatusBarColor(0);
        r2.setNavigationBarColor(0);
    }

    private final boolean b() {
        if (UserSettings.INSTANCE.isEnterpriseAccount() == true) goto L6;
        return false;
    L6:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryShare", "ignore share intent for enterprise account", false, 4, null);
        finish();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void finish() {
        super/*android.app.Activity*/.finish();
        overridePendingTransition(0, 0);
    }

    public String getPluginPkgName() {
        return "com.obric.memorydata.plugin";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle r9) {
        super/*android.app.Activity*/.onCreate(r9);
        if (b() == false) goto L5;
        return;
    L5:
        a();
        overridePendingTransition(0, 0);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryShare", "MemoryShareActivity onCreate, referrer=" + getReferrer(), false, 4, null);
        v r10 = v.f11572a;
        Activity r0 = (Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin");
        Intent r8 = getIntent();
        Intrinsics.checkNotNullExpressionValue(r8, "getIntent(...)");
        r10.a(r0, r8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onNewIntent(Intent r10) {
        Intrinsics.checkNotNullParameter(r10, MemorySourceLinkType.INTENT);
        super/*android.app.Activity*/.onNewIntent(r10);
        if (b() == false) goto L5;
        return;
    L5:
        setIntent(r10);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryShare", "MemoryShareActivity onNewIntent, referrer=" + getReferrer(), false, 4, null);
        overridePendingTransition(0, 0);
        v.f11572a.a((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.memorydata.plugin"), r10);
    }
}
