package d0;

import android.content.res.AssetManager;

/* JADX INFO: loaded from: classes.dex */
public final class a implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AssetManager f16523b;

    public /* synthetic */ a(AssetManager r5, int r10) {
        this.f16522a = r10;
        this.f16523b = r5;
    }

    @Override // d0.s
    public final r a(z r5) {
        switch(this.f16522a) {
            case 0: goto L7;
            default: goto L5;
        };
    L5:
        return new b(this.f16523b, this);
    L7:
        return new b(this.f16523b, this);
    }
}
