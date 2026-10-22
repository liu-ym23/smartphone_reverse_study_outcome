package androidx.activity;

import android.content.Intent;
import android.content.IntentSender;

/* JADX INFO: loaded from: classes.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IntentSender.SendIntentException f485b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ ComponentActivity.a f486m;

    public i(ComponentActivity.a r8, int r10, IntentSender.SendIntentException r11) {
        this.f486m = r8;
        this.f484a = r10;
        this.f485b = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Intent r8 = new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.f485b);
        this.f486m.a(this.f484a, 0, r8);
    }
}
