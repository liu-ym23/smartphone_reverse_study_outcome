package com.obric.aiagent.product.platform.api.app;

import android.app.ActivityManager;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0016J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\u0012\u0010\u001b\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u001b\u0010\u0004\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00018FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006¨\u0006\u001e"}, d2 = {"Lcom/obric/aiagent/product/platform/api/app/ObricTaskStackListener;", "", "<init>", "()V", "obricStub", "getObricStub", "()Ljava/lang/Object;", "obricStub$delegate", "Lkotlin/Lazy;", "assistantStub", "getAssistantStub", "assistantStub$delegate", "onTaskToBackground", "", "task", "Landroid/app/ActivityManager$RunningTaskInfo;", "onTaskRemovedBeforeFocusChanged", "onDisplaySecureChanged", "displayId", "", "secure", "", "onDisplayStatusBarChanged", "appearance", "onReportError", "taskid", "error", "onBlacklistAppOpen", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ObricTaskStackListener {
    private final Lazy assistantStub$delegate;
    private final Lazy obricStub$delegate;

    public ObricTaskStackListener() {
        this.obricStub$delegate = LazyKt.lazy(new $$Lambda$ObricTaskStackListener$fGDNFK1AU8c8ATeqmSC5TL6CXn4(this));
        this.assistantStub$delegate = LazyKt.lazy(new $$Lambda$ObricTaskStackListener$241ibPkRKpqYTHx2DmEUt7dVBFU(this));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.app.ObricTaskStackListener$assistantStub$2$1] */
    private static final ObricTaskStackListener$assistantStub$2$1 assistantStub_delegate$lambda$1(final ObricTaskStackListener r1) {
        return new ObricTaskStackListener$assistantStub$2$1(r1);
    }

    public static /* synthetic */ ObricTaskStackListener$assistantStub$2$1 lambda$241ibPkRKpqYTHx2DmEUt7dVBFU(ObricTaskStackListener r0) {
        return assistantStub_delegate$lambda$1(r0);
    }

    public static /* synthetic */ ObricTaskStackListener$obricStub$2$1 lambda$fGDNFK1AU8c8ATeqmSC5TL6CXn4(ObricTaskStackListener r0) {
        return obricStub_delegate$lambda$0(r0);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.aiagent.product.platform.api.app.ObricTaskStackListener$obricStub$2$1] */
    private static final ObricTaskStackListener$obricStub$2$1 obricStub_delegate$lambda$0(final ObricTaskStackListener r1) {
        return new ObricTaskStackListener$obricStub$2$1(r1);
    }

    public final Object getAssistantStub() {
        return this.assistantStub$delegate.getValue();
    }

    public final Object getObricStub() {
        return this.obricStub$delegate.getValue();
    }

    public void onBlacklistAppOpen(String r1) {
    }

    public void onDisplaySecureChanged(int r1, boolean r2) {
    }

    public void onDisplayStatusBarChanged(int r1, int r2) {
    }

    public void onReportError(int r1, int r2) {
    }

    public void onTaskRemovedBeforeFocusChanged(ActivityManager.RunningTaskInfo r1) {
    }

    public void onTaskToBackground(ActivityManager.RunningTaskInfo r1) {
    }
}
