package androidx.activity;

import android.content.Context;
import android.graphics.Typeface;
import com.google.android.material.textfield.TextInputLayout;
import com.obric.cae.libs.nfc.CaeNfcAdapter;
import com.obric.cae.libs.softap.CaeSoftApManager;
import com.obric.cae.location.StarLocationManager;
import com.obric.cae.location.geofence.StarGeofenceManager;
import com.obric.cae.location.zpp.StarZppManager;
import com.obric.cae.smartBluetooth.btaware.SmartBluetoothInCarAware;
import com.obric.cae.smartNetwork.SmartNetworkBinder;
import com.obric.cae.smartNetwork.nefid.NefidInterface;
import com.obric.cae.smartNetwork.netPolicy.NetPolicyMetric;
import com.obric.cae.smartNetwork.networkRateLimit.AppRateLimitManager;
import com.obric.cae.softap.CaeSoftApService;
import com.obric.cae.userAware.NearElevator.NearElevator;
import com.obric.cae.userAware.ui.StoreArrivalActivity;
import com.obric.cae.userAware.ui.StoreArrivalEventManager;
import com.obric.cae.userAware.ui.UserAwareLauncherActivity;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import java.nio.MappedByteBuffer;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f490b;

    public /* synthetic */ k(Object r8, int r10) {
        this.f489a = r10;
        this.f490b = r8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f489a) {
            case 0: goto L115;
            case 1: goto L117;
            case 2: goto L57;
            case 3: goto L55;
            case 4: goto L53;
            case 5: goto L51;
            case 6: goto L49;
            case 7: goto L47;
            case 8: goto L41;
            case 9: goto L117;
            case 10: goto L39;
            case 11: goto L37;
            case 12: goto L35;
            case 13: goto L33;
            case 14: goto L31;
            case 15: goto L29;
            case 16: goto L27;
            case 17: goto L25;
            case 18: goto L23;
            case 19: goto L21;
            case 20: goto L19;
            case 21: goto L17;
            case 22: goto L15;
            case 23: goto L13;
            case 24: goto L11;
            case 25: goto L9;
            case 26: goto L7;
            case 27: goto L5;
            default: goto L117;
        };
    L5:
        UserAwareLauncherActivity.d((UserAwareLauncherActivity) this.f490b);
        return;
    L7:
        StoreArrivalEventManager.HistoryLoadTask.b((StoreArrivalEventManager.HistoryLoadTask) this.f490b);
        return;
    L9:
        StoreArrivalActivity.a((StoreArrivalActivity) this.f490b);
        return;
    L11:
        NearElevator.b((NearElevator) this.f490b);
        return;
    L13:
        CaeSoftApService.I2((CaeSoftApService) this.f490b);
        return;
    L15:
        AppRateLimitManager.a((AppRateLimitManager) this.f490b);
        return;
    L17:
        NetPolicyMetric.a((NetPolicyMetric) this.f490b);
        return;
    L19:
        NefidInterface.a((NefidInterface) this.f490b);
        return;
    L21:
        SmartNetworkBinder.a((SmartNetworkBinder) this.f490b);
        return;
    L23:
        SmartBluetoothInCarAware.c((SmartBluetoothInCarAware) this.f490b);
        return;
    L25:
        StarZppManager.e((StarZppManager) this.f490b);
        return;
    L27:
        StarGeofenceManager.b((StarGeofenceManager) this.f490b);
        return;
    L29:
        StarLocationManager.d((StarLocationManager) this.f490b);
        return;
    L31:
        ((CaeSoftApManager) this.f490b).a();
        return;
    L33:
        CaeNfcAdapter.a((CaeNfcAdapter) this.f490b);
        return;
    L35:
        ((TextInputLayout) this.f490b).f4984n.requestLayout();
        return;
    L37:
        com.google.android.material.textfield.l r8 = (com.google.android.material.textfield.l) this.f490b;
        boolean r10 = r8.f5038h.isPopupShowing();
        r8.t(r10);
        r8.f5043m = r10;
        return;
    L39:
        ((com.google.android.material.textfield.f) this.f490b).t(true);
        return;
    L41:
        w8.e r11 = (w8.e) this.f490b;
        AtomicLong r12 = w8.e.f13069a;
        r11.getClass();
        if ((System.currentTimeMillis() - w8.e.f13069a.get()) >= w8.e.f13079u) goto L44;
        return;
    L44:
        if (w8.e.f13070b.get() < 0) goto L131;
        w8.e.b(w8.e.a.f13081a);
        return;
    L131:
        return;
    L47:
        ge.a r13 = (ge.a) this.f490b;
        he.i.f(r13, "$f");
        r13.f();
        return;
    L49:
        he.i.f((androidx.room.p) this.f490b, "this$0");
        throw null;
    L51:
        he.i.f((androidx.room.n) this.f490b, "this$0");
        throw null;
    L53:
        androidx.room.i.a((androidx.room.i) this.f490b);
        return;
    L55:
        defpackage.b.l(this.f490b);
        he.i.f(null, "this$0");
        throw null;
    L57:
        androidx.emoji2.text.l.b r14 = (androidx.emoji2.text.l.b) this.f490b;
        Object r15 = r14.f1790d;
        monitor-enter(r15);
    L112:
        th = move-exception;
        throw th;
    L60:
        if (r14.f1794h != null) goto L63;
        monitor-exit(r15);     // Catch: Throwable -> L112
        return;
    L63:
        monitor-exit(r15);     // Catch: Throwable -> L112
        g0.m r16 = r14.d();     // Catch: Throwable -> L100
        int r17 = r16.f7532e;     // Catch: Throwable -> L100
        if (r17 != 2) goto L73;
        Object r18 = r14.f1790d;     // Catch: Throwable -> L100
        monitor-enter(r18);     // Catch: Throwable -> L100
        monitor-exit(r18);     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        throw th;     // Catch: Throwable -> L100
    L73:
        if (r17 != 0) goto L99;
        f0.h.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");     // Catch: Throwable -> L95
        androidx.emoji2.text.l.a r19 = r14.f1789c;     // Catch: Throwable -> L95
        Context r20 = r14.f1787a;     // Catch: Throwable -> L95
        r19.getClass();     // Catch: Throwable -> L95
        Typeface r21 = a0.e.a(r20, new g0.m[]{r16}, 0);     // Catch: Throwable -> L95
        MappedByteBuffer r22 = a0.h.a(r14.f1787a, r16.f7528a);     // Catch: Throwable -> L95
        if (r22 == null) goto L94;
        if (r21 == null) goto L94;
        f0.h.a("EmojiCompat.MetadataRepo.create");     // Catch: Throwable -> L90
        androidx.emoji2.text.n r23 = new androidx.emoji2.text.n(r21, androidx.emoji2.text.m.a(r22));     // Catch: Throwable -> L90
        f0.h.b();     // Catch: Throwable -> L95
        f0.h.b();     // Catch: Throwable -> L100
        Object r24 = r14.f1790d;     // Catch: Throwable -> L100
        monitor-enter(r24);     // Catch: Throwable -> L100
        androidx.emoji2.text.f.h r25 = r14.f1794h;     // Catch: Throwable -> L87
        if (r25 == null) goto L84;
        r25.b(r23);     // Catch: Throwable -> L87
    L84:
        monitor-exit(r24);     // Catch: Throwable -> L87
        r14.b();     // Catch: Throwable -> L100
        return;
    L87:
        th = move-exception;
        throw th;     // Catch: Throwable -> L100
    L90:
        th = move-exception;
        f0.h.b();     // Catch: Throwable -> L95
        throw th;     // Catch: Throwable -> L95
    L94:
        throw new RuntimeException("Unable to open file.");     // Catch: Throwable -> L95
    L95:
        th = move-exception;
        f0.h.b();     // Catch: Throwable -> L100
        throw th;     // Catch: Throwable -> L100
    L99:
        throw new RuntimeException("fetchFonts result is not OK. (" + r17 + ")");     // Catch: Throwable -> L100
    L100:
        th = move-exception;
        monitor-enter(r14.f1790d);
        androidx.emoji2.text.f.h r26 = r14.f1794h;     // Catch: Throwable -> L109
        if (r26 == null) goto L106;
        r26.a(th);     // Catch: Throwable -> L109
    L106:
        r14.b();
        return;
    L109:
        th = move-exception;
        throw th;
    L115:
        l.a((l) this.f490b);
        return;
    L117:
        MatrixTeaManager r27 = (MatrixTeaManager) this.f490b;
        he.i.f(r27, "this$0");
        r27.b();
        r27.f6129f.postDelayed(r27.f6131h, 5000);
    }
}
