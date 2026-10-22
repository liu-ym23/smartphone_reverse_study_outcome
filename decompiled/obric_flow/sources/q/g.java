package q;

import com.airbnb.lottie.model.content.MergePaths$MergePathsMode;
import com.airbnb.lottie.w;

/* JADX INFO: loaded from: classes.dex */
public final class g implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MergePaths$MergePathsMode f21412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f21413b;

    public g(String r5, MergePaths$MergePathsMode r10, boolean r11) {
        this.f21412a = r10;
        this.f21413b = r11;
    }

    @Override // q.b
    public final k.c a(w r5, r.c r10) {
        if (r5.f1346l == true) goto L7;
        u.b.b("Animation contains merge paths but they are disabled.");
        return null;
    L7:
        return new k.m(this);
    }

    public final String toString() {
        return "MergePaths{mode=" + this.f21412a + '}';
    }
}
