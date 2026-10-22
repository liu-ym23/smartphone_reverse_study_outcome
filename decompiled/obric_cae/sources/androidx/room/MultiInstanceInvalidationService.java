package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import com.qualcomm.qti.qesdk.QesdkUtils;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class MultiInstanceInvalidationService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f2597b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f2598m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final MultiInstanceInvalidationService$binder$1 f2599n;

    public static final class a extends RemoteCallbackList<IMultiInstanceInvalidationCallback> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiInstanceInvalidationService f2600a;

        public a(MultiInstanceInvalidationService r8) {
            this.f2600a = r8;
        }

        @Override // android.os.RemoteCallbackList
        public final void onCallbackDied(IInterface r8, Object r10) {
            he.i.f((IMultiInstanceInvalidationCallback) r8, QesdkUtils.TAGS.JSON_TAG_CALLBACK);
            he.i.f(r10, "cookie");
            this.f2600a.f2597b.remove((Integer) r10);
        }
    }

    public MultiInstanceInvalidationService() {
        this.f2597b = new LinkedHashMap();
        this.f2598m = new a(this);
        this.f2599n = new MultiInstanceInvalidationService$binder$1(this);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r8) {
        he.i.f(r8, "intent");
        return this.f2599n;
    }
}
