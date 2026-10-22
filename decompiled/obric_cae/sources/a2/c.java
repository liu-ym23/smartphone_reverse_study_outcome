package a2;

import android.os.CountDownTimer;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;

/* JADX INFO: loaded from: classes.dex */
public final class c extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b.d f50a;

    public c(b.d r8, long r10) {
        this.f50a = r8;
        super(r10, 1000);
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener countdown times finish.");
        StringBuilder r8 = new StringBuilder("locate timeout because of receive valid satellite count is ");
        b.d r10 = this.f50a;
        r8.append(r10.f43c);
        String r11 = r8.toString();
        if (r10.f41a == null) goto L5;
        Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener stopCountDownTimer() is executed.");
        r10.f41a.cancel();
    L5:
        Logger.i("ByteLocationManagerImpl: LocationGpsStatusListener notifyLocationFailed() and the message is " + r11);
        b r12 = r10.f45e;
        r12.getClass();
        r12.f30b.d(new BDLocationException(r11, LocationInfoConst.BYTE, "0"));
        if (r10.f44d == false) goto L9;
        r12.d();
        return;
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long r8) {
    }
}
