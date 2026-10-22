package androidx.room;

import android.os.RemoteException;
import android.util.Log;
import com.qualcomm.qti.qesdk.QesdkUtils;

/* JADX INFO: loaded from: classes.dex */
public final class MultiInstanceInvalidationService$binder$1 extends IMultiInstanceInvalidationService.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiInstanceInvalidationService f2601a;

    public MultiInstanceInvalidationService$binder$1(MultiInstanceInvalidationService r8) {
        this.f2601a = r8;
    }

    @Override // androidx.room.IMultiInstanceInvalidationService
    public final int F1(IMultiInstanceInvalidationCallback r8, String r10) {
        he.i.f(r8, QesdkUtils.TAGS.JSON_TAG_CALLBACK);
        int r11 = 0;
        if (r10 != null) goto L5;
        return 0;
    L5:
        MultiInstanceInvalidationService r12 = this.f2601a;
        MultiInstanceInvalidationService.a r13 = r12.f2598m;
        monitor-enter(r13);
        int r14 = r12.f2596a + 1;     // Catch: Throwable -> L13
        r12.f2596a = r14;     // Catch: Throwable -> L13
        if (r12.f2598m.register(r8, Integer.valueOf(r14)) == false) goto L10;
        r12.f2597b.put(Integer.valueOf(r14), r10);     // Catch: Throwable -> L13
        r11 = r14;
    L11:
        monitor-exit(r13);
        return r11;
    L10:
        r12.f2596a--;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    @Override // androidx.room.IMultiInstanceInvalidationService
    public final void G2(IMultiInstanceInvalidationCallback r8, int r10) {
        he.i.f(r8, QesdkUtils.TAGS.JSON_TAG_CALLBACK);
        MultiInstanceInvalidationService r11 = this.f2601a;
        MultiInstanceInvalidationService.a r12 = r11.f2598m;
        monitor-enter(r12);
        r11.f2598m.unregister(r8);     // Catch: Throwable -> L7
        String r13 = (String) r11.f2597b.remove(Integer.valueOf(r10));     // Catch: Throwable -> L7
        monitor-exit(r12);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.room.IMultiInstanceInvalidationService
    public final void b1(int r8, String[] r10) {
        he.i.f(r10, "tables");
        MultiInstanceInvalidationService r11 = this.f2601a;
        MultiInstanceInvalidationService.a r12 = r11.f2598m;
        monitor-enter(r12);
        String r13 = (String) r11.f2597b.get(Integer.valueOf(r8));     // Catch: Throwable -> L28
        if (r13 != null) goto L9;
        Log.w("ROOM", "Remote invalidation client ID not registered");     // Catch: Throwable -> L28
        monitor-exit(r12);
        return;
    L9:
        int r14 = r11.f2598m.beginBroadcast();     // Catch: Throwable -> L28
        int r15 = 0;
    L11:
        if (r15 >= r14) goto L25;
        Object r16 = r11.f2598m.getBroadcastCookie(r15);     // Catch: Throwable -> L22
        he.i.d(r16, "null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L22
        int r17 = ((Integer) r16).intValue();     // Catch: Throwable -> L22
        String r18 = (String) r11.f2597b.get(Integer.valueOf(r17));     // Catch: Throwable -> L22
        if (r8 == r17) goto L21;
        if (he.i.a(r13, r18) == false) goto L21;
        r11.f2598m.getBroadcastItem(r15).M(r10);     // Catch: RemoteException -> L19 Throwable -> L22
    L19:
        e = move-exception;
        Log.w("ROOM", "Error invoking a remote callback", e);     // Catch: Throwable -> L22
    L21:
        r15 = r15 + 1;
        goto L11
    L22:
        th = move-exception;
        r11.f2598m.finishBroadcast();     // Catch: Throwable -> L28
        throw th;     // Catch: Throwable -> L28
    L25:
        r11.f2598m.finishBroadcast();     // Catch: Throwable -> L28
        xd.j r19 = xd.j.f13877a;     // Catch: Throwable -> L28
        monitor-exit(r12);
        return;
    L28:
        th = move-exception;
        throw th;
    }
}
