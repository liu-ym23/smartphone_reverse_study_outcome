package com.bytedance.android.live.ktv.common.music.control;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.ktvimpl.base.controlnode.CutMusicControlNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class KtvMusicControlManager implements g {
    public static final Lazy d = null;
    public final Lazy a;
    public final MusicControlChain b;
    public Function1<? super IMusicControlNode, Unit> c;

    public static final class a {
        public static KtvMusicControlManager a() {
            return (KtvMusicControlManager) KtvMusicControlManager.d.getValue();
        }
    }

    public final Map<IMusicControlNode, List<IMusicControlNode.a>> f() {
        return (Map) this.a.getValue();
    }

    static {
        d = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, KtvMusicControlManager$Companion$instance$2.INSTANCE);
    }

    public KtvMusicControlManager() {
        this.a = LazyKt.lazy(KtvMusicControlManager$callbackMap$2.INSTANCE);
        MusicControlChain r0 = new MusicControlChain(this);
        this.b = r0;
        r0.a(IMusicControlNode.OperationType.ADD_MUSIC, new com.bytedance.android.live.ktv.common.music.control.a());
        r0.a(IMusicControlNode.OperationType.CUT_MUSIC, new f());
        r0.a(IMusicControlNode.OperationType.PAUSE_MUSIC, new i());
    }

    public final void e() {
        f().clear();
        MusicControlChain r0 = this.b;
        r0.d().clear();
        Iterator<IMusicControlNode> r1 = r0.c().iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        IMusicControlNode r2 = r1.next();
        r2.a();
        r0.c().remove(r2);
        goto L4
    L6:
        com.bytedance.android.live.ktv.common.util.g.a("MusicControlChain#clear，" + r0.c().size());
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.g
    public final void a(IMusicControlNode r3) {
        Intrinsics.checkNotNullParameter(r3, "node");
        ALogger.i("KtvMusicControlManager", "onNodeProcessOverTime ;; node == " + r3.getClass());
        f().remove(r3);
        this.b.f(r3);
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.g
    public final void b(IMusicControlNode.b r4, IMusicControlNode r5) {
        Intrinsics.checkNotNullParameter(r4, "result");
        Intrinsics.checkNotNullParameter(r5, "node");
        ALogger.i("KtvMusicControlManager", "onNodeProcessSuccess ;; mId == " + r4.b.a.getId() + " ;; name == " + r4.b.a.getTitle() + " ;; node == " + r5);
        this.b.f(r5);
        if (f().isEmpty() == false) goto L6;
        ALogger.i("KtvMusicControlManager", "onNodeProcessSuccess ;; callbackMap.isEmpty() ;; name == " + r4.b.a.getTitle());
        return;
    L6:
        List<IMusicControlNode.a> r0 = f().get(r5);
        List<IMusicControlNode.a> r2 = r0;
        if (r2 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L16;
        f().remove(r5);
        ALogger.i("KtvMusicControlManager", "onNodeProcessSuccess ;; callbackList.isNullOrEmpty() ;; name == " + r4.b.a.getTitle());
        return;
    L16:
        Iterator<IMusicControlNode.a> r1 = r0.iterator();
    L18:
        if (r1.hasNext() == false) goto L20;
        r1.next().a(r4);
        goto L18
    L20:
        f().remove(r5);
        return;
    L9:
        if (r2.isEmpty() == true) goto L12;
        r3 = false;
        goto L13
    }

    @Override // com.bytedance.android.live.ktv.common.music.control.g
    public final void c(IMusicControlNode.b r4, IMusicControlNode r5) {
        Intrinsics.checkNotNullParameter(r4, "result");
        Intrinsics.checkNotNullParameter(r5, "node");
        ALogger.i("KtvMusicControlManager", "onNodeProcessFail ;; mId == " + r4.b.a.getId());
        this.b.f(r5);
        if (f().isEmpty() == false) goto L5;
        return;
    L5:
        List<IMusicControlNode.a> r0 = f().get(r5);
        List<IMusicControlNode.a> r1 = r0;
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L15;
        f().remove(r5);
        return;
    L15:
        Iterator<IMusicControlNode.a> r3 = r0.iterator();
    L17:
        if (r3.hasNext() == false) goto L19;
        r3.next().b(r4);
        goto L17
    L19:
        f().remove(r5);
        return;
    L8:
        if (r1.isEmpty() == true) goto L11;
        r2 = false;
        goto L12
    }

    public final void d(CutMusicControlNode r2, IMusicControlNode.a r3) {
        Intrinsics.checkNotNullParameter(r2, "node");
        if (r3 == null) goto L5;
        g(r2, r3);
    L5:
        this.b.b(r2);
        Function1<? super IMusicControlNode, Unit> r4 = this.c;
        if (r4 == null) goto L9;
        Unit r5 = (Unit) r4.invoke(r2);
        return;
    }

    public final void g(d r2, IMusicControlNode.a r3) {
        Intrinsics.checkNotNullParameter(r2, "node");
        Intrinsics.checkNotNullParameter(r3, "callback");
        List<IMusicControlNode.a> r0 = f().get(r2);
        if (r0 != null) goto L5;
        r0 = new ArrayList();
    L5:
        r0.add(r3);
        f().put(r2, r0);
    }
}
