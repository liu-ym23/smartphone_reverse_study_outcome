package l19;

import android.view.View;
import android.view.ViewGroup;
import com.larus.common_ui.photoviewer.transition.TransitionPhotoDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j {
    /* JADX WARN: Multi-variable type inference failed */
    public static final TransitionPhotoDraweeView a(View r4) {
        if ((r4 instanceof TransitionPhotoDraweeView) == false) goto L7;
        return (TransitionPhotoDraweeView) r4;
    L7:
        if ((r4 instanceof ViewGroup) == false) goto L14;
        ViewGroup r5 = (ViewGroup) r4;
        int r0 = r5.getChildCount();
        int r2 = 0;
    L9:
        if (r2 >= r0) goto L14;
        TransitionPhotoDraweeView r3 = a(r5.getChildAt(r2));
        if (r3 != null) goto L12;
        r2 = r2 + 1;
        goto L9
    L12:
        return r3;
    L14:
        return null;
    }
}
