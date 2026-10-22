package ca2;

import com.bytedance.android.livesdk.interactivity.publicscreen.preview.transition.TransitionPhotoDraweeView;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements a {
    public final /* synthetic */ TransitionPhotoDraweeView a;

    public b(TransitionPhotoDraweeView r1) {
        this.a = r1;
    }

    @Override // ca2.a
    public final void onTransitionBegin(int r3) {
        Iterator<T> r0 = this.a.n.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).onTransitionBegin(r3);
        goto L4
    }

    @Override // ca2.a
    public final void onTransitionEnd(int r3) {
        Iterator<T> r0 = this.a.n.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).onTransitionEnd(r3);
        goto L4
    }

    @Override // ca2.a
    public final void onTransitionChanged(int r3, float r4) {
        Iterator<T> r0 = this.a.n.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).onTransitionChanged(r3, r4);
        goto L4
    }
}
