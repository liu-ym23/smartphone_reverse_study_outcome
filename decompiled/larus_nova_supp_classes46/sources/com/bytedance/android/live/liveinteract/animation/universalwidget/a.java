package com.bytedance.android.live.liveinteract.animation.universalwidget;

import android.graphics.Path;
import com.bytedance.android.live.liveinteract.animation.universalwidget.context.LinkUniversalAnimContext;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.MultiLinkScriptInfo;
import com.bytedance.live.datacontext.DataContext;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public interface a {
    public static final C0014a f0 = null;

    /* JADX INFO: renamed from: com.bytedance.android.live.liveinteract.animation.universalwidget.a$a, reason: collision with other inner class name */
    public static final class C0014a {
        public static final /* synthetic */ C0014a a = null;

        public C0014a() {
        }

        static {
            a = new C0014a();
        }

        public static a a() {
            DataContext r0 = com.bytedance.live.datacontext.d.d(com.bytedance.android.live.liveinteract.plantform.dynamicframe.context.a.class);
            if ((r0 instanceof LinkUniversalAnimContext) == true) goto L5;
            r0 = null;
        L5:
            LinkUniversalAnimContext r1 = (LinkUniversalAnimContext) r0;
            if (r1 == null) goto L11;
            com.bytedance.live.datacontext.j<a> r2 = r1.getService();
            if (r2 != null) goto L10;
            return null;
        L10:
            return (a) r2.getValue();
        L11:
            return null;
        }
    }

    public static final class b {
        public static /* synthetic */ boolean a(a r1) {
            return r1.Zg("");
        }
    }

    static {
        f0 = C0014a.a;
    }

    void Jl(Path r1);

    void Le(String r1, JsonObject r2, oh0.a r3);

    boolean Zg(String r1);

    void d4(int r1, int r2);

    void m9(com.bytedance.android.live.liveinteract.videotalk.emoji.model.g r1, com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r2, com.bytedance.android.live.liveinteract.videotalk.emoji.model.n r3, com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r4, String r5, com.bytedance.android.live.liveinteract.videotalk.emoji.model.o r6, MultiLinkScriptInfo r7, com.bytedance.android.live.liveinteract.animation.e r8);

    void start3DAnim(com.bytedance.android.live.liveinteract.videotalk.emoji.model.g r1, com.bytedance.android.live.liveinteract.videotalk.emoji.model.c r2, com.bytedance.android.live.liveinteract.videotalk.emoji.model.n r3, com.bytedance.android.live.liveinteract.videotalk.emoji.model.m r4, String r5, com.bytedance.android.live.liveinteract.videotalk.emoji.model.o r6, MultiLinkScriptInfo r7, com.bytedance.android.live.liveinteract.animation.e r8);

    void y7(Function0<Unit> r1);

    void zn(Function0<Unit> r1);
}
