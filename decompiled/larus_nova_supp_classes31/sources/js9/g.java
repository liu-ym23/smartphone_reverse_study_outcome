package js9;

import androidx.fragment.app.Fragment;
import com.larus.bmhome.utils.c4;
import com.larus.bmhome.video.fragment.BaseVideoDetailFragment;
import com.larus.bmhome.video.fragment.a0;
import com.larus.platform.api.creation.UserCreation;
import com.larus.profile.impl.creation.CreationGroupFragment;
import com.larus.profile.impl.creation.CreationVideoDetailFragment;
import com.larus.profile.impl.creation.i2;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g implements b {
    public g() {
    }

    @Override // js9.b
    public final Fragment a(UserCreation r32, Fragment r33, boolean r34, int r35) {
        Intrinsics.checkNotNullParameter(r32, "creation");
        String r3 = null;
        if (CollectionsKt.listOf(new Integer[]{6, 7, 8, 9, 10, 11, 12}).contains(Integer.valueOf(r32.b)) == true) goto L6;
        return null;
    L6:
        if ((r33 instanceof CreationGroupFragment) == false) goto L8;
        CreationGroupFragment r1 = (CreationGroupFragment) r33;
    L9:
        if (r1 == null) goto L11;
        gs9.d r13 = r1.q;
    L12:
        if (r1 == null) goto L14;
        int r11 = r1.o;
    L15:
        if (r1 == null) goto L17;
        r3 = r1.n;
    L17:
        String r10 = r3;
        if (r10 != null) goto L20;
    L23:
        boolean r2 = true;
    L24:
        if (r13 == null) goto L27;
        String r4 = r13.h;
        if (r4 == null) goto L27;
    L28:
        if (r13 == null) goto L31;
        String r5 = r13.i;
        if (r5 == null) goto L31;
    L32:
        if (r2 == false) goto L39;
        CreationNoWatermarkManager r6 = CreationNoWatermarkManager.a;
        if (r6.D() == false) goto L39;
        UserCreation r7 = r6.f0(r32, false);
        if (r7 == null) goto L39;
        UserCreation r9 = r7;
    L40:
        CreationVideoDetailFragment r8 = new CreationVideoDetailFragment(r9, r10, r11, null, r13, i2.b(r9, r2), new c4(null, null, "creation_private", null, null, null, null, null, null, null, null, null, null, null, 16379));
        a0.a r0 = new a0.a();
        r0.a.a = true;
        String r12 = r8.tag();
        Intrinsics.checkNotNullParameter(r12, "value");
        a0 r14 = r0.a;
        r14.getClass();
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r14.c = r12;
        r0.b(r4);
        r0.a(r5);
        a0 r15 = r0.a;
        r15.h = true;
        Intrinsics.checkNotNullParameter(r15, "config");
        ((BaseVideoDetailFragment) r8).u = r15;
        return r8;
    L39:
        r9 = r32;
    L31:
        r5 = "immersive_preview";
    L27:
        r4 = "ugc_video";
        goto L28
    L20:
        if (r10.length() == 0) goto L23;
        r2 = false;
        goto L24
    L14:
        r11 = 2;
        goto L15
    L11:
        r13 = null;
        goto L12
    L8:
        r1 = null;
        goto L9
    }
}
