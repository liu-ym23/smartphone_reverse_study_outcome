package mn;

import com.lynx.base.log.LynxLog;
import com.lynx.tasm.core.LynxEngineProxy;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f20121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ on.h f20122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LynxEngineProxy f20123c;

    public /* synthetic */ c(LynxEngineProxy r5, on.h r10, int r11) {
        this.f20121a = r11;
        this.f20123c = r5;
        this.f20122b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int r5 = 0;
        on.h r10 = this.f20122b;
        switch(this.f20121a) {
            case 0: goto L26;
            case 1: goto L17;
            default: goto L4;
        };
    L4:
        LynxEngineProxy r11 = this.f20123c;
        if (r11.f10828a != 0) goto L7;
        LynxLog.b(4, "LynxEngineProxy", "startEventGenerate failed since mNativePtr is null");
        return;
    L7:
        boolean r12 = kn.b.f18686a;
        r10.getClass();
        ArrayList r13 = new ArrayList();
        r13.add(r10.f20780b);
        r13.add(Integer.valueOf(r10.f20781c.ordinal()));
        r13.add(Integer.valueOf(r10.f20779a));
        r13.add(Long.valueOf(r10.e));
        r13.add(Long.valueOf(r10.f));
        ArrayList r14 = new ArrayList();
        boolean r15 = r10.f20788j;
        r14.add(Boolean.valueOf(r15));
        if (r15 == false) goto L10;
        r14.add(r10.f20789k);
    L11:
        r13.add(r14);
        ByteBuffer r16 = kn.b.b(r13);
        if (r16 == null) goto L15;
        r5 = r16.position();
    L15:
        LynxEngineProxy.j(r11, r11.f10828a, r16, r5);
        return;
    L10:
        on.g r17 = r10.g;
        r14.add(Float.valueOf(r17.f20784a));
        r14.add(Float.valueOf(r17.f20785b));
        on.g r18 = r10.f20786h;
        r14.add(Float.valueOf(r18.f20784a));
        r14.add(Float.valueOf(r18.f20785b));
        on.g r19 = r10.f20787i;
        r14.add(Float.valueOf(r19.f20784a));
        r14.add(Float.valueOf(r19.f20785b));
        goto L11
    L17:
        LynxEngineProxy r20 = this.f20123c;
        if (r20.f10828a != 0) goto L20;
        LynxLog.b(4, "LynxEngineProxy", "sendMultiTouchEvent failed since mNativePtr is null");
        return;
    L20:
        boolean r21 = kn.b.f18686a;
        ByteBuffer r22 = kn.b.b(r10.f20789k);
        if (r22 != null) goto L23;
    L22:
        int r110 = r5;
        LynxEngineProxy.i(r20, r20.f10828a, r10.f20780b, r22, r110, r10.e);
        return;
    L23:
        r5 = r22.position();
        goto L22
    L26:
        LynxEngineProxy r111 = this.f20123c;
        long r112 = r111.f10828a;
        if (r112 != 0) goto L29;
        LynxLog.b(4, "LynxEngineProxy", "sendTouchEvent failed since mNativePtr is null");
        return;
    L29:
        on.g r23 = r10.g;
        float r24 = r23.f20784a;
        float r25 = r23.f20785b;
        on.g r26 = r10.f20786h;
        float r27 = r26.f20784a;
        float r28 = r26.f20785b;
        on.g r29 = r10.f20787i;
        float r30 = r29.f20784a;
        float r31 = r29.f20785b;
        long r32 = r10.e;
        LynxEngineProxy.f(r111, r112, r10.f20780b, r10.f20779a, r24, r25, r27, r28, r30, r31, r32);
    }
}
