package m1;

import androidx.core.util.Consumer;
import com.bytedance.ai.bridge.core.AIBridgeMethod$Error;
import com.google.gson.JsonObject;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f19958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ym.j f19959c;
    public final /* synthetic */ AtomicBoolean d;

    public /* synthetic */ b(i r5, ym.j r10, AtomicBoolean r11, int r12) {
        this.f19957a = r12;
        this.f19958b = r5;
        this.f19959c = r10;
        this.d = r11;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object r5) {
        switch(this.f19957a) {
            case 0: goto L10;
            case 1: goto L8;
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        i r10 = this.f19958b;
        ym.j r11 = this.f19959c;
        r10.f(r11, (AIBridgeMethod$Error) r5, this.d);
        return;
    L6:
        i r12 = this.f19958b;
        ym.j r13 = this.f19959c;
        r12.f(r13, (JsonObject) r5, this.d);
        return;
    L8:
        i r14 = this.f19958b;
        ym.j r15 = this.f19959c;
        r14.f(r15, (AIBridgeMethod$Error) r5, this.d);
        return;
    L10:
        i r16 = this.f19958b;
        ym.j r17 = this.f19959c;
        r16.f(r17, (JsonObject) r5, this.d);
    }
}
