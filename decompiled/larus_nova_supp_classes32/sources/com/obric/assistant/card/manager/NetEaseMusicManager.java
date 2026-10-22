package com.obric.assistant.card.manager;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.entity.app.MusicEntity;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class NetEaseMusicManager {
    public static final NetEaseMusicManager a = null;
    public static final String[] b = null;
    public static final Handler c = null;
    public static final CoroutineScope d = null;
    public static final Map<String, List<WeakReference<a>>> e = null;
    public static Bundle f;
    public static boolean g;
    public static final b h = null;
    public static boolean i;
    public static final NetEaseMusicManager$musicStateListener$1 j = null;

    public interface a {
        void onMusicStateChanged(Bundle r1);
    }

    public static final class b implements Runnable {
        public b() {
        }

        public final void a() {
            long r0 = NetEaseMusicManager.f.getLong("id", 0);
            if (r0 != 0) goto L5;
            NetEaseMusicManager r1 = NetEaseMusicManager.a;
            Bundle r2 = NetEaseMusicManager.f;
            r1.getClass();
            NetEaseMusicManager.e(null, r2);
        L7:
            if (NetEaseMusicManager.e.isEmpty() == false) goto L17;
            NetEaseMusicManager.a.getClass();
            NetEaseMusicManager.g = true;
            NetEaseMusicManager.c.removeCallbacks(NetEaseMusicManager.h);
            if (NetEaseMusicManager.i == false) goto L22;
            NetEaseMusicManager.i = false;
            ILogDepend.a.d("NetEaseMusicManager", "removeMusicStateListener");
            IAgentAppIntentIDL r3 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
            if (r3 == null) goto L14;
            r3.unregisterMusicStateListener(NetEaseMusicManager.j);
        L14:
            Bundle r4 = new Bundle();
            NetEaseMusicManager.f = r4;
            NetEaseMusicManager.e(null, r4);
            return;
        L22:
            return;
        L17:
            if (NetEaseMusicManager.f.getBoolean("isPlaying", false) == true) goto L20;
            NetEaseMusicManager.a.getClass();
            NetEaseMusicManager.g = true;
            NetEaseMusicManager.c.removeCallbacks(NetEaseMusicManager.h);
            return;
        L20:
            NetEaseMusicManager.c.postDelayed(this, 1000);
            return;
        L5:
            NetEaseMusicManager r5 = NetEaseMusicManager.a;
            String r6 = String.valueOf(r0);
            Bundle r7 = NetEaseMusicManager.f;
            r5.getClass();
            NetEaseMusicManager.e(r6, r7);
            goto L7
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public NetEaseMusicManager() {
    }

    static {
        a = new NetEaseMusicManager();
        b = new String[]{"music.126.net", "music.163.com"};
        c = new Handler(Looper.getMainLooper());
        d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        e = new LinkedHashMap();
        f = new Bundle();
        g = true;
        h = new b();
        j = new NetEaseMusicManager$musicStateListener$1();
    }

    public static void a() {
        if (i == false) goto L5;
        return;
    L5:
        IAgentAppIntentIDL r0 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r0 == null) goto L9;
        i = true;
        ILogDepend.a.d("NetEaseMusicManager", "ensureMusicStateListener");
        r0.registerMusicStateListener(j);
        return;
    }

    public static boolean c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r3 = Result.constructor-impl(r2.getPackageManager().getApplicationInfo("com.netease.cloudmusic", 0));     // Catch: Throwable -> L5
    L8:
        return Result.isSuccess-impl(r3);
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public static boolean d(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "musicId");
        String r0 = f.getString("local_message");
        if (r4 != null) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r4, r0) == true) goto L7;
        return false;
    L7:
        if (f.getBoolean("isPlaying", false) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(String.valueOf(f.getLong("id")), r5) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public static void e(final String r4, final Bundle r5) {
        Iterator r0 = ((LinkedHashMap) e).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        final Map.Entry r1 = (Map.Entry) r0.next();
        CollectionsKt.removeAll((List) r1.getValue(), new f(r4, r1, r5));
        if (((List) r1.getValue()).isEmpty() == false) goto L4;
        r0.remove();
        goto L4
    }

    public static void b(Bundle r2, boolean r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "traceInfo");
        r2.putString("operation_type", "jump_to_app");
        if (r3 == false) goto L5;
        String r0 = "success";
    L6:
        r2.putString("click_music_result", r0);
        r2.putInt("item_position", r4 + 1);
        r2.putString("click_result", "click_to_redirect");
        if (r3 == false) goto L11;
        IAgentAppIntentIDL r5 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r5 == null) goto L11;
        r5.showMusicPage();
    L11:
        gda.a r6 = gda.a.a;
        gda.b.a(r2);
        return;
    L5:
        r0 = "fail";
        goto L6
    }

    public static void f(String r10, MusicEntity[] r11, MusicEntity r12, Function1 r13) {
        Intrinsics.checkNotNullParameter(r13, "onResult");
        BuildersKt.launch$default(d, null, null, new NetEaseMusicManager$playMusic$1(r10, r11, r12, r13, null), 3, null);
    }
}
