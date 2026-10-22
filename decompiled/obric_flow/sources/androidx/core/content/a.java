package androidx.core.content;

import androidx.core.util.Consumer;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f448a;

    public /* synthetic */ a(int r5) {
        this.f448a = r5;
    }

    @Override // androidx.core.util.Consumer
    public final void accept(Object r5) {
        String r10 = (String) r5;
        switch(this.f448a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        IntentSanitizer.b(r10);
        return;
    L6:
        IntentSanitizer.a(r10);
    }
}
