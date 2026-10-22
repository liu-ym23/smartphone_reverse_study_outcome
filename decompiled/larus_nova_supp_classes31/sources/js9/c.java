package js9;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.common_ui.image.ImageAdapter;
import com.larus.platform.api.creation.UserCreation;
import com.larus.profile.impl.creation.CreationGroupFragment;
import com.larus.profile.impl.creation.CreationImageDetailFragment;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c implements b {
    public c() {
    }

    @Override // js9.b
    public final Fragment a(UserCreation r10, Fragment r11, boolean r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "creation");
        int r14 = r10.b;
        CreationGroupFragment r0 = null;
        if (r14 != 2) goto L5;
    L12:
        ImageAdapter r3 = new ImageAdapter();
        List r4 = CollectionsKt.mutableListOf(new UserCreation[]{r10});
        boolean r15 = r11 instanceof CreationGroupFragment;
        if (r15 == false) goto L15;
        CreationGroupFragment r16 = (CreationGroupFragment) r11;
    L16:
        if (r16 == null) goto L18;
        String r5 = r16.n;
    L19:
        if (r15 == false) goto L21;
        CreationGroupFragment r17 = (CreationGroupFragment) r11;
    L22:
        if (r17 == null) goto L24;
        gs9.d r7 = r17.q;
    L25:
        if (r15 == false) goto L27;
        r0 = (CreationGroupFragment) r11;
    L27:
        if (r0 == null) goto L29;
        int r6 = r0.o;
    L31:
        return new CreationImageDetailFragment(r3, r4, r5, r6, r7, 32);
    L29:
        r6 = 2;
        goto L31
    L24:
        r7 = null;
        goto L25
    L21:
        r17 = null;
        goto L22
    L18:
        r5 = null;
        goto L19
    L15:
        r16 = null;
        goto L16
    L5:
        if (r14 == 3) goto L12;
        if (r14 == 4) goto L12;
        if (r14 == 5) goto L12;
        return null;
    }
}
