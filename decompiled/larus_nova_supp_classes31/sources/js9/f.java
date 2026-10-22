package js9;

import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.music.player.j;
import com.larus.bmhome.music.protocol.h;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationContent;
import com.larus.platform.api.creation.UserCreationMusic;
import com.larus.profile.impl.creation.CreationGroupFragment;
import com.larus.profile.impl.creation.MusicDetailFragment;
import com.larus.profile.impl.databinding.LarusCreationPagerLayoutBinding;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f implements b {
    public f() {
    }

    @Override // js9.b
    public final Fragment a(UserCreation r39, Fragment r40, boolean r41, int r42) {
        Intrinsics.checkNotNullParameter(r39, "creation");
        if (r39.b == 1) goto L5;
        return null;
    L5:
        ArrayList r1 = new ArrayList();
        r1.add(r39);
        com.larus.bmhome.music.player.d.a r2 = new com.larus.bmhome.music.player.d.a();
        LinkedHashMap r4 = new LinkedHashMap();
        Iterator r3 = r1.iterator();
        int r6 = 0;
    L7:
        if (r3.hasNext() == false) goto L13;
        UserCreation r7 = (UserCreation) r3.next();
        UserCreationContent r9 = r7.e;
        if (r9 == null) goto L7;
        UserCreationMusic r10 = r9.b;
        if (r10 == null) goto L7;
        r4.put(Integer.valueOf(r6), h.a(r10, r7.a));
        r6 = r6 + 1;
        goto L7
    L13:
        Iterator r5 = r4.entrySet().iterator();
    L14:
        String r8 = "";
        if (r5.hasNext() == false) goto L36;
        MusicCreationContent r11 = (MusicCreationContent) ((Map.Entry) r5.next()).getValue();
        Intrinsics.checkNotNullParameter(r11, "nextNode");
        String r12 = r11.getVid();
        if (r12 == null) goto L20;
        r8 = r12;
    L20:
        r11.setPlayList(new com.larus.bmhome.music.player.d(r2, r8));
        MusicCreationContent r13 = r2.a;
        if (r13 == null) goto L22;
        com.larus.bmhome.music.player.d r14 = r13.getPlayList();
        if ((r14 instanceof com.larus.bmhome.music.player.d) == false) goto L26;
        com.larus.bmhome.music.player.d r15 = r14;
    L27:
        if (r15 == null) goto L29;
        r15.c = r11;
    L29:
        com.larus.bmhome.music.player.d r16 = r11.getPlayList();
        if ((r16 instanceof com.larus.bmhome.music.player.d) == false) goto L32;
        com.larus.bmhome.music.player.d r17 = r16;
    L33:
        if (r17 == null) goto L35;
        r17.d = r2.a;
    L35:
        r2.a = r11;
        goto L14
    L32:
        r17 = null;
        goto L33
    L26:
        r15 = null;
        goto L27
    L22:
        r2.a = r11;
        goto L14
    L36:
        MusicCreationContent r18 = (MusicCreationContent) r4.get(0);
        if (r40 == null) goto L41;
        LifecycleCoroutineScope r19 = LifecycleOwnerKt.getLifecycleScope(r40);
        if (r19 == null) goto L41;
    L42:
        LifecycleCoroutineScope r20 = r19;
        if (r18 == null) goto L48;
        String r21 = r18.getVid();
        if (r21 == null) goto L48;
        String r110 = r21;
    L49:
        if (r18 == null) goto L54;
        String r22 = r18.getVideoModel();
        if (r22 == null) goto L54;
        String r111 = r22;
    L55:
        if (r18 == null) goto L60;
        String r23 = r18.getTitle();
        if (r23 == null) goto L60;
        String r28 = r23;
    L61:
        if (r18 == null) goto L66;
        String r24 = r18.getChunkUrl();
        if (r24 == null) goto L66;
        String r29 = r24;
    L67:
        if (r18 == null) goto L69;
        ad9.b r32 = r18.getPlayList();
    L70:
        j r25 = new j(null, null, null, null, "", -1, r111, r110, false, false, r20, 0, null, null, "creation_detail", true, null, r28, r29, false, false, r32, false, false, null, "music_gen", 31012879);
        boolean r26 = r40 instanceof CreationGroupFragment;
        if (r26 == false) goto L73;
        CreationGroupFragment r27 = (CreationGroupFragment) r40;
    L74:
        if (r27 == null) goto L80;
        LarusCreationPagerLayoutBinding r30 = r27.i;
        if (r30 == null) goto L78;
        FrameLayout r31 = r30.d;
    L79:
        FrameLayout r33 = r31;
    L81:
        if (r26 == false) goto L83;
        CreationGroupFragment r34 = (CreationGroupFragment) r40;
    L84:
        if (r34 == null) goto L86;
        String r35 = r34.n;
    L87:
        if (r26 == false) goto L89;
        CreationGroupFragment r36 = (CreationGroupFragment) r40;
    L90:
        if (r36 == null) goto L92;
        int r37 = r36.o;
    L93:
        if (r26 == false) goto L95;
        CreationGroupFragment r0 = (CreationGroupFragment) r40;
    L96:
        if (r0 == null) goto L98;
        gs9.d r112 = r0.q;
    L100:
        return new MusicDetailFragment(r25, r18, 0, true, new e(), r33, r35, r39, r37, r112);
    L98:
        r112 = null;
        goto L100
    L95:
        r0 = null;
        goto L96
    L92:
        r37 = 2;
        goto L93
    L89:
        r36 = null;
        goto L90
    L86:
        r35 = null;
        goto L87
    L83:
        r34 = null;
        goto L84
    L78:
        r31 = null;
        goto L79
    L80:
        r33 = null;
        goto L81
    L73:
        r27 = null;
        goto L74
    L69:
        r32 = null;
    L66:
        r29 = "";
    L60:
        r28 = "";
    L54:
        r111 = "";
    L48:
        r110 = "";
    L41:
        r19 = GlobalScope.INSTANCE;
        goto L42
    }
}
