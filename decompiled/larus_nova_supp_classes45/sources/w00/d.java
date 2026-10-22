package w00;

import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.android.scope.o;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements o, g00.d {
    public final Set<Integer> a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public d() {
        this.a = new LinkedHashSet();
    }

    @Override // g00.d
    public final void markEnterSceneFromJsb(int r2) {
        this.a.add(Integer.valueOf(r2));
    }

    @Override // nz.v
    public final void markPopupShown(int r4) {
        com.bytedance.android.livesdk.sharedpref.e r0 = com.bytedance.android.livesdk.sharedpref.b.b0;
        ((HashSet) r0.getValue()).add(Integer.valueOf(r4));
        f.d(r0, r0.getValue());
        this.a.remove(Integer.valueOf(r4));
    }

    @Override // g00.d
    public final boolean shouldShowGuidePromptBubble(int r3) {
        boolean r4 = ((HashSet) com.bytedance.android.livesdk.sharedpref.b.b0.getValue()).contains(17);
        boolean r0 = this.a.contains(17);
        if (r4 == true) goto L6;
        if (r0 == false) goto L6;
        return true;
    L6:
        return false;
    }
}
