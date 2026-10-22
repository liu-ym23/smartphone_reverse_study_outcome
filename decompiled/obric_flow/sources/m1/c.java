package m1;

import android.os.Handler;
import android.os.Looper;
import androidx.core.util.Consumer;
import com.bytedance.ai.bridge.core.AIBridgeMethod$Error;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f19961b;

    public /* synthetic */ c(Object r5, int r10) {
        this.f19960a = r10;
        this.f19961b = r5;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object r5) {
        switch(this.f19960a) {
            case 0: goto L16;
            case 1: goto L14;
            case 2: goto L9;
            default: goto L4;
        };
    L4:
        j2.b r10 = (j2.b) r5;
        i r11 = (i) this.f19961b;
        r11.getClass();
        if (Intrinsics.areEqual(c1.b.c().getLooper(), Looper.myLooper()) == false) goto L7;
        kh.b r12 = new kh.b(1, r11, r10);
        ((Handler) i.f19971j.getValue()).post(r12);
        return;
    L7:
        r11.h(r10);
        return;
    L9:
        j2.a r13 = (j2.a) r5;
        i2.c r14 = (i2.c) this.f19961b;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r13, "messageWrapper");
        com.lynx.tasm.utils.a r15 = r13.f18230c;
        if (r15 == null) goto L12;
        r15.d();
    L12:
        r14.f17490b.c(r13);
        return;
    L14:
        b r16 = (b) this.f19961b;
        r16.accept((AIBridgeMethod$Error) r5);
        return;
    L16:
        b r17 = (b) this.f19961b;
        r17.accept((JsonObject) r5);
    }
}
