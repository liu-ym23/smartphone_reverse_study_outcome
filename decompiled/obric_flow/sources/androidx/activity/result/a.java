package androidx.activity.result;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements ActivityResultCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f410a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f411b;

    public /* synthetic */ a(int r5, Function1 r10) {
        this.f410a = r5;
        this.f411b = r10;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object r5) {
        int r10 = this.f410a;
        Function1 r11 = this.f411b;
        switch(r10) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ActivityResultCallerKt.b(r5, r11);
        return;
    L6:
        ActivityResultCallerKt.a(r5, r11);
    }
}
