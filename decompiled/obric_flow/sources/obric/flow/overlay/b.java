package obric.flow.overlay;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends Binder implements IInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f20532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f20533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public cq.c f20534c;
    public final bb.b d;
    public final a e;

    public b(AssistantOverlayService r5) {
        Intrinsics.checkNotNullParameter(r5, NotificationCompat.CATEGORY_SERVICE);
        attachInterface(this, "com.obric.flow.ILauncherOverlayAidl");
        this.f20532a = new WeakReference(r5);
        this.d = new bb.b(this);
        this.e = new a(this);
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int r10, Parcel r11, Parcel r12, int r13) {
        if (r10 < 1) goto L8;
        if (r10 > 16777215) goto L8;
        r11.enforceInterface("com.obric.flow.ILauncherOverlayAidl");
    L8:
        if (r10 == 1598968902) goto L123;
        Object r5 = null;
        boolean r14 = false;
        switch(r10) {
            case 1: goto L110;
            case 2: goto L102;
            case 3: goto L97;
            case 4: goto L86;
            case 5: goto L70;
            case 6: goto L66;
            case 7: goto L41;
            case 8: goto L37;
            case 9: goto L31;
            case 10: goto L29;
            case 11: goto L23;
            case 12: goto L16;
            case 13: goto L14;
            case 14: goto L13;
            default: goto L12;
        };
    L13:
        obric.flow.b.a(false);
    L122:
        return true;
    L14:
        obric.flow.b.a(true);
        goto L122
    L29:
        r11.readInt();
        r12.writeNoException();
        goto L122
    L37:
        AssistantOverlayService r15 = (AssistantOverlayService) this.f20532a.get();
        if (r15 == null) goto L40;
        AssistantOverlayService.a(r15, new AssistantOverlayService$AssistantBinder$openOverlay$1(this, null));
    L40:
        r12.writeNoException();
        goto L122
    L41:
        IBinder r16 = r11.readStrongBinder();
        if (r16 != null) goto L44;
        cq.c r17 = null;
    L50:
        cq.c r18 = this.f20534c;
        if (r18 == null) goto L53;
        IBinder r19 = r18.f16499a;
    L54:
        a r110 = this.e;
        if (r19 != null) goto L126;
    L57:
        this.f20534c = r17;
        if (r17 == null) goto L60;
        IBinder r20 = r17.f16499a;
    L61:
        if (r20 != null) goto L128;
    L65:
        r12.writeNoException();
        goto L122
    L128:
        r20.linkToDeath(r110, 0);     // Catch: RemoteException -> L64
    L64:
        this.f20534c = null;
        goto L65
    L60:
        r20 = null;
        goto L61
    L126:
        r19.unlinkToDeath(r110, 0);     // Catch: NoSuchElementException -> L125
        goto L57
    L53:
        r19 = null;
        goto L54
    L44:
        IInterface r111 = r16.queryLocalInterface("com.obric.flow.ILauncherOverlayCallbackAidl");
        if (r111 != null) goto L47;
    L49:
        r17 = new cq.c();
        r17.f16499a = r16;
        goto L50
    L47:
        if ((r111 instanceof cq.c) == false) goto L49;
        r17 = (cq.c) r111;
        goto L50
    L66:
        Parcelable.Creator r21 = MotionEvent.CREATOR;
        if (r11.readInt() == 0) goto L69;
        r5 = r21.createFromParcel(r11);
    L69:
        MotionEvent r22 = (MotionEvent) r5;
        r11.readFloat();
        r12.writeNoException();
        goto L122
    L70:
        float r23 = r11.readFloat();
        if (this.f20533b == true) goto L77;
        Intrinsics.checkNotNullParameter("AssistantOverlayService", "tag");
        Intrinsics.checkNotNullParameter("onFlingVelocity ignored: Watchdog already took over", "msg");
        org.koin.core.a r24 = su.a.f22013b;
        if (r24 == null) goto L76;
        ((ju.b) r24.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).w("AssistantOverlayService", "onFlingVelocity ignored: Watchdog already took over");
    L83:
        r12.writeNoException();
        goto L122
    L76:
        throw new IllegalStateException("KoinApplication has not been started");
    L77:
        String r112 = "onFlingVelocity: velocity=" + r23 + " isBeingDragged：" + this.f20533b + " before";
        Intrinsics.checkNotNullParameter("AssistantOverlayService", "tag");
        Intrinsics.checkNotNullParameter(r112, "msg");
        org.koin.core.a r25 = su.a.f22013b;
        if (r25 == null) goto L85;
        ((ju.b) r25.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).d("AssistantOverlayService", r112);
        this.f20533b = false;
        this.d.removeMessages(100);
        AssistantOverlayService r113 = (AssistantOverlayService) this.f20532a.get();
        if (r113 == null) goto L83;
        AssistantOverlayService.a(r113, new AssistantOverlayService$AssistantBinder$onFlingVelocity$1(r23, this, r113, null));
        goto L83
    L85:
        throw new IllegalStateException("KoinApplication has not been started");
    L86:
        float r26 = r11.readFloat();
        if (r11.readInt() == 0) goto L90;
        r14 = true;
    L90:
        if (this.f20533b == false) goto L96;
        bb.b r114 = this.d;
        r114.removeMessages(100);
        r114.sendEmptyMessageDelayed(100, 1000);
        AssistantOverlayService r27 = (AssistantOverlayService) this.f20532a.get();
        if (r27 == null) goto L96;
        AssistantOverlayService.a(r27, new AssistantOverlayService$AssistantBinder$onScrollChange$1(r27, r26, r14, null));
    L96:
        r12.writeNoException();
        goto L122
    L97:
        AssistantOverlayService r28 = (AssistantOverlayService) this.f20532a.get();
        if (r28 == null) goto L101;
        AssistantOverlayService.a(r28, new AssistantOverlayService$AssistantBinder$onScrollInteractionEnd$1(r28, null));
    L101:
        r12.writeNoException();
        goto L122
    L102:
        Intrinsics.checkNotNullParameter("AssistantOverlayService", "tag");
        Intrinsics.checkNotNullParameter("onScrollInteractionBegin", "msg");
        org.koin.core.a r115 = su.a.f22013b;
        if (r115 == null) goto L109;
        ((ju.b) r115.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("AssistantOverlayService", "onScrollInteractionBegin");
        this.f20533b = true;
        this.d.removeMessages(100);
        AssistantOverlayService r29 = (AssistantOverlayService) this.f20532a.get();
        if (r29 == null) goto L107;
        AssistantOverlayService.a(r29, new AssistantOverlayService$AssistantBinder$onScrollInteractionBegin$1(this, null));
    L107:
        r12.writeNoException();
        goto L122
    L109:
        throw new IllegalStateException("KoinApplication has not been started");
    L110:
        IBinder r30 = r11.readStrongBinder();
        if (r30 != null) goto L117;
        Intrinsics.checkNotNullParameter("AssistantOverlayService", "tag");
        Intrinsics.checkNotNullParameter("setLauncherWindowToken: token is null", "msg");
        org.koin.core.a r116 = su.a.f22013b;
        if (r116 == null) goto L116;
        ((ju.b) r116.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).e("AssistantOverlayService", "setLauncherWindowToken: token is null");
    L121:
        r12.writeNoException();
        goto L122
    L116:
        throw new IllegalStateException("KoinApplication has not been started");
    L117:
        AssistantOverlayService r31 = (AssistantOverlayService) this.f20532a.get();
        if (r31 == null) goto L121;
        AssistantOverlayService.a(r31, new AssistantOverlayService$AssistantBinder$setLauncherWindowToken$1$1(r31, r30, null));
        goto L121
    L12:
        return super.onTransact(r10, r11, r12, r13);
    L16:
        if (r11.readInt() == 0) goto L18;
        r14 = true;
    L18:
        AssistantOverlayService r32 = (AssistantOverlayService) this.f20532a.get();
        if (r32 == null) goto L21;
        AssistantOverlayService.a(r32, new AssistantOverlayService$AssistantBinder$onOverlayShown$1(r14, this, null));
    L21:
        r12.writeNoException();
        goto L122
    L23:
        if (r11.readInt() == 0) goto L25;
        r14 = true;
    L25:
        AssistantOverlayService r33 = (AssistantOverlayService) this.f20532a.get();
        if (r33 == null) goto L28;
        AssistantOverlayService.a(r33, new AssistantOverlayService$AssistantBinder$onOverlayHidden$1(r14, this, null));
    L28:
        r12.writeNoException();
        goto L122
    L31:
        if (r11.readInt() == 0) goto L33;
        r14 = true;
    L33:
        AssistantOverlayService r34 = (AssistantOverlayService) this.f20532a.get();
        if (r34 == null) goto L36;
        AssistantOverlayService.a(r34, new AssistantOverlayService$AssistantBinder$hideOverlay$1(this, r14, null));
    L36:
        r12.writeNoException();
        goto L122
    L123:
        r12.writeString("com.obric.flow.ILauncherOverlayAidl");
        return true;
    }
}
