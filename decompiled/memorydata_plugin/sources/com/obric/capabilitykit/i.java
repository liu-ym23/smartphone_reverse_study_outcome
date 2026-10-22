package com.obric.capabilitykit;

import android.app.Activity;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u000eJ\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0007H&J\b\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/apphost/ActivityStackManager;", "", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "addAppBackGroundListener", "", "listener", "Lcom/obric/capabilitykit/apphost/ActivityStackManager$OnAppBackGroundListener;", "finishAllActivities", "isAppBackground", "", "removeAppBackGroundListener", "OnAppBackGroundListener", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface i {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/obric/capabilitykit/apphost/ActivityStackManager$OnAppBackGroundListener;", "", "onAllActivityDestroyed", "", "onAppBackground", "onAppForeground", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void a();

        void b();

        void c();
    }

    Activity a();

    void a(a r1);

    void b();

    void b(a r1);

    boolean c();
}
