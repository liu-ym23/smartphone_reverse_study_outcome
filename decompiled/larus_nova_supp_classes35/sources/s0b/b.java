package s0b;

import com.bytedance.geckox.model.UpdatePackage;
import com.ss.android.lark.chameleon.ChameleonConfig;
import com.ss.android.lark.chameleon.GeckoConst;
import com.ss.android.lark.chameleon.ResConfig;
import com.ss.android.lark.chameleon.ResGeckoConfig;
import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResUtils;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.vfs.VFSFile;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import io.reactivex.functions.Function;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b<T, R> implements Function {
    public final /* synthetic */ UpdatePackage a;
    public final /* synthetic */ long b;
    public final /* synthetic */ ChameleonConfig c;

    public b(UpdatePackage r1, long r2, ChameleonConfig r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final Object apply(Object r11) {
        Boolean r12 = (Boolean) r11;
        byte[] r1 = g.d;
        UpdatePackage r2 = this.a;
        long r3 = this.b;
        ChameleonConfig r5 = this.c;
        monitor-enter(r1);
        VFSFile r4 = g.a(r2, r3);     // Catch: Throwable -> L38
        int r6 = com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.a;     // Catch: Throwable -> L38
        String r7 = com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.e(r4.getVfsPath());     // Catch: Throwable -> L38
        Intrinsics.checkNotNullParameter(r5, "chameleonConfig");     // Catch: Throwable -> L38
        String r8 = com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.d(com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.j(r5, r2));     // Catch: Throwable -> L38
        int r9 = swb.g.b(r8, r7);     // Catch: Throwable -> L38
        j.e("CML_TAG_GeckoResManager", "applyGeckoResource() sdVersion = " + r8 + ", geckoVersion = " + r7 + "compare result = " + r9);     // Catch: Throwable -> L38
        if (r9 == (-2)) goto L37;
        if (r9 != (-1)) goto L11;
        if (r7 != null) goto L10;
        r7 = BuildConfig.FLAVOR;
    L10:
        g.b(r5, r2, r7, r4);     // Catch: Throwable -> L38
    L33:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L38
        monitor-exit(r1);
        return r12;
    L11:
        if (r9 <= 0) goto L33;
        ResConfig r10 = r5.getResConfig();     // Catch: Throwable -> L38
        if (r10 == null) goto L17;
        ResGeckoConfig r13 = r10.getGeckoConfig();     // Catch: Throwable -> L38
        if (r13 == null) goto L17;
        HashMap<String, String> r14 = r13.getChannels();     // Catch: Throwable -> L38
    L18:
        String r15 = r2.getChannel();     // Catch: Throwable -> L38
        boolean r16 = false;
        if (r14 == null) goto L28;
        Set<Map.Entry<String, String>> r17 = r14.entrySet();     // Catch: Throwable -> L38
        if (r17 == null) goto L28;
        Iterator<T> r18 = r17.iterator();     // Catch: Throwable -> L38
    L24:
        if (r18.hasNext() == false) goto L28;
        Map.Entry r19 = (Map.Entry) r18.next();     // Catch: Throwable -> L38
        if (Intrinsics.areEqual(r19.getValue(), r15) == false) goto L24;
        r16 = Intrinsics.areEqual(r19.getKey(), GeckoConst.FULL_PACKAGE);     // Catch: Throwable -> L38
    L28:
        if (r16 == false) goto L33;
        int r20 = com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.a;     // Catch: Throwable -> L38
        String r21 = r2.getChannel();     // Catch: Throwable -> L38
        Intrinsics.checkNotNullParameter(r21, "channel");     // Catch: Throwable -> L38
        j.e(ChameleonResUtils.TAG, "cleanSpaceResourceByChannel, channel = " + r21);     // Catch: Throwable -> L38
        swb.j.f(com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate.c.i(r5, r21).getVfsPath());     // Catch: Throwable -> L38
        AtomicBoolean r22 = g.a;     // Catch: Throwable -> L38
        if (r7 != null) goto L32;
        r7 = BuildConfig.FLAVOR;
    L32:
        g.b(r5, r2, r7, r4);     // Catch: Throwable -> L38
    L17:
        r14 = null;
        goto L18
    L37:
        throw new IOException("applyGeckoResource resource version is damage");     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        throw th;
    }
}
