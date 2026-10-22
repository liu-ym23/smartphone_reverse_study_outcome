package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.bdlocation.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public abstract class BaseTimingUpdater<T> {
    public final List<o<T>> a;
    public final Handler b;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/api/BaseTimingUpdater$Companion$HandlerMessage;", BuildConfig.FLAVOR, "UPDATE", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final enum HandlerMessage extends Enum<HandlerMessage> {
            public static final HandlerMessage UPDATE = null;
            public static final /* synthetic */ HandlerMessage[] a = null;

            static {
                HandlerMessage r1 = new HandlerMessage();
                UPDATE = r1;
                a = new HandlerMessage[]{r1};
            }

            public static HandlerMessage valueOf(String r1) {
                return (HandlerMessage) r27.a.a(HandlerMessage.class, r1);
            }

            public static HandlerMessage[] values() {
                return (HandlerMessage[]) a.clone();
            }

            public HandlerMessage() {
                super("UPDATE", 0);
            }
        }
    }

    public static final class a implements Handler.Callback {
        public final /* synthetic */ BaseTimingUpdater a;

        public a(BaseTimingUpdater r1) {
            this.a = r1;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            if (r2.what != Companion.HandlerMessage.UPDATE.ordinal()) goto L7;
            BaseTimingUpdater.a(this.a);
            return true;
        L7:
            return true;
        }
    }

    static {
    }

    public abstract void c();

    public abstract long d();

    public final void f() {
        this.b.removeCallbacksAndMessages(null);
        this.b.sendEmptyMessageDelayed(Companion.HandlerMessage.UPDATE.ordinal(), d());
    }

    public void g() {
        this.b.removeCallbacksAndMessages(null);
        this.b.sendEmptyMessageDelayed(Companion.HandlerMessage.UPDATE.ordinal(), d());
    }

    public final void h() {
        this.b.removeCallbacksAndMessages(null);
        update();
    }

    public void i() {
        this.b.removeCallbacksAndMessages(null);
    }

    public final void j() {
        this.b.removeCallbacksAndMessages(null);
        update();
        this.b.sendEmptyMessageDelayed(Companion.HandlerMessage.UPDATE.ordinal(), d());
    }

    public BaseTimingUpdater() {
        this.a = new ArrayList();
        this.b = new Handler(Looper.getMainLooper(), new a(this));
    }

    private final void update() {
        c();
        this.b.sendEmptyMessageDelayed(Companion.HandlerMessage.UPDATE.ordinal(), d());
    }

    public static final /* synthetic */ void a(BaseTimingUpdater r0) {
        r0.update();
    }

    public final void b(o<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) this.a).add(r2);
    }

    public final void e(T r3) {
        Iterator<T> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((o) r0.next()).a(r3);
        goto L4
    }
}
