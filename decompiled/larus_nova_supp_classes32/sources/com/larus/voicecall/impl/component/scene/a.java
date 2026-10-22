package com.larus.voicecall.impl.component.scene;

import androidx.lifecycle.LiveData;
import com.larus.im.bean.bot.SceneModel;
import com.larus.voicecall.impl.scene.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import l3a.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public interface a extends t1a.a {
    public static final C0016a C1 = null;

    /* JADX INFO: renamed from: com.larus.voicecall.impl.component.scene.a$a, reason: collision with other inner class name */
    public static final class C0016a {
        public static final /* synthetic */ C0016a a = null;

        static {
            a = new C0016a();
        }

        public C0016a() {
        }

        public static boolean a(SceneModel r4) {
            if (r4 != null) goto L5;
        L7:
            boolean r2 = false;
        L8:
            if (r2 == true) goto L15;
            if (r4 != null) goto L11;
        L13:
            boolean r5 = false;
        L14:
            if (r5 == true) goto L15;
            return false;
        L11:
            if (r4.getId() != 20) goto L13;
            r5 = true;
        L15:
            return true;
        L5:
            if (r4.getId() != 21) goto L7;
            r2 = true;
            goto L8
        }
    }

    public static final class b {
        public static /* synthetic */ void a(a r3, boolean r4, int r5) {
            Function0<Unit> r1 = null;
            if ((r5 & 1) == 0) goto L5;
            Function0<Unit> r0 = new l3a.a();
        L7:
            if ((r5 & 2) == 0) goto L10;
            r1 = new l3a.b();
        L10:
            if ((r5 & 4) == 0) goto L12;
            r4 = false;
        L12:
            r3.x50(r0, r1, r4);
            return;
        L5:
            r0 = null;
            goto L7
        }
    }

    static {
        C1 = C0016a.a;
    }

    void Fk(c r1);

    void Ii(String r1);

    void R3(m r1, int r2);

    void bQ();

    LiveData<m> getCurrentScene();

    List<m> getSceneList();

    boolean oY();

    boolean wm();

    void x50(Function0<Unit> r1, Function0<Unit> r2, boolean r3);

    void yM(c r1);
}
