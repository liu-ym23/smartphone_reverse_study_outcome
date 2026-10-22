package pz9;

import androidx.fragment.app.Fragment;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.creation.ChatCreationPagerFragment;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class g implements b {
    public final KClass<? extends zo8.a> a;

    public g() {
        this.a = Reflection.getOrCreateKotlinClass(zo8.e.class);
    }

    @Override // pz9.b
    public KClass<? extends zo8.a> getType() {
        return this.a;
    }

    @Override // pz9.c
    public final Fragment a(Fragment r8, zo8.a r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "data");
        IAIChatUgcAIGCService.Companion r1 = IAIChatUgcAIGCService.a;
        if ((r8 instanceof ChatCreationPagerFragment) == false) goto L5;
        ChatCreationPagerFragment r0 = (ChatCreationPagerFragment) r8;
    L6:
        if (r0 != null) goto L8;
    L10:
        boolean r6 = false;
    L12:
        return r1.q0(r8, r9, r10, r11, r6);
    L8:
        if (r0.q != true) goto L10;
        r6 = true;
        goto L12
    L5:
        r0 = null;
        goto L6
    }
}
