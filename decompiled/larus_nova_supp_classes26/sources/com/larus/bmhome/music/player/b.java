package com.larus.bmhome.music.player;

import android.text.TextUtils;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.block.MusicCreationContent;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public interface b {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;
        public static WeakReference<ad9.b> b;
        public static final WeakHashMap<String, WeakReference<com.larus.bmhome.music.player.a>> c = null;
        public static String d;
        public static final HashMap<String, Integer> e = null;
        public static final VideoEngineMusicPlayerViewImpl f = null;
        public static boolean g;
        public static boolean h;
        public static boolean i;

        public a() {
        }

        static {
            a = new a();
            c = new WeakHashMap();
            d = "";
            e = new HashMap();
            f r0 = f.a;
            c r1 = new c(AppHost.a.getApplication().getApplicationContext());
            Intrinsics.checkNotNullParameter(r1, "parent");
            f = new VideoEngineMusicPlayerViewImpl(r1, null);
            g = true;
            i = true;
        }

        public static void a(ad9.b r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "list");
            Intrinsics.checkNotNullParameter(r2, "playListId");
            if (TextUtils.isEmpty(r2) == false) goto L6;
            return;
        L6:
            if (TextUtils.equals(d, r2) == true) goto L8;
            e.clear();
        L8:
            d = r2;
            b = new WeakReference(r1);
        }

        public static void b(ad9.b r27, j r28) {
            FLogger r0 = FLogger.a;
            StringBuilder r1 = new StringBuilder("[handlePlayListTryNext] current play list auto handle ");
            ad9.b r2 = null;
            if (r27 == null) goto L5;
            Boolean r3 = Boolean.valueOf(r27.c());
        L6:
            r1.append(r3);
            r1.append(' ');
            r0.i("CreationPlayList", r1.toString());
            boolean r4 = false;
            if (r27 != null) goto L9;
        L11:
            boolean r6 = false;
        L12:
            if (r6 == false) goto L14;
            return;
        L14:
            if (r27 == null) goto L16;
            MusicCreationContent r7 = r27.getNext();
        L22:
            ad9.b.a.getClass();
            HashMap r8 = ad9.b.a.b;
            StringBuilder r9 = new StringBuilder();
            r9.append(d);
            if (r7 == null) goto L27;
            ad9.b r10 = r7.getPlayList();
            if (r10 == null) goto L27;
            String r11 = r10.getItemId();
        L28:
            r9.append(r11);
            MusicCreationContent r12 = (MusicCreationContent) r8.get(r9.toString());
            if (r12 == null) goto L33;
            ad9.b r13 = r12.getPlayList();
            if (r13 == null) goto L33;
            String r14 = r13.getVid();
        L35:
            if (TextUtils.isEmpty(r14) == false) goto L37;
            return;
        L37:
            WeakReference<com.larus.bmhome.music.player.a> r15 = c.get(r14);
            if (r15 == null) goto L40;
            com.larus.bmhome.music.player.a r16 = r15.get();
        L41:
            if (r16 == null) goto L50;
            j r17 = r16.data();
            if (r17 == null) goto L49;
            CoroutineScope r18 = r17.a;
            if (r18 == null) goto L49;
            if (CoroutineScopeKt.isActive(r18) != true) goto L49;
            r4 = true;
        L49:
            if (r4 == false) goto L50;
        L68:
            r0.i("CreationPlayList", "handle play list next " + r14 + " auto next " + g + "next can play " + com.larus.bmhome.music.protocol.a.a(r12) + " player " + r16 + ' ');
            if (g == true) goto L71;
            return;
        L71:
            r16.i();
            return;
        L50:
            r16 = f;
            if (r28 == null) goto L68;
            if (r12 == null) goto L58;
            String r5 = r12.getVid();
            if (r5 == null) goto L58;
            String r19 = r5;
        L59:
            if (r12 == null) goto L64;
            String r20 = r12.getVideoModel();
            if (r20 == null) goto L64;
            String r110 = r20;
        L65:
            if (r12 == null) goto L67;
            r2 = r12.getPlayList();
        L67:
            r16.d(j.a(r28, r110, r19, true, false, null, 0, null, null, false, null, null, r2, false, false, null, 65010751));
        L64:
            r110 = "";
        L58:
            r19 = "";
            goto L59
        L40:
            r16 = null;
        L33:
            r14 = null;
        L27:
            r11 = null;
            goto L28
        L16:
            WeakReference<ad9.b> r21 = b;
            if (r21 == null) goto L21;
            ad9.b r22 = r21.get();
            if (r22 == null) goto L21;
            r7 = r22.getNext();
        L21:
            r7 = null;
            goto L22
        L9:
            if (r27.c() == true) goto L11;
            r6 = true;
            goto L12
        L5:
            r3 = null;
            goto L6
        }

        public static void c(String r2, String r3, MusicCreationContent r4) {
            Intrinsics.checkNotNullParameter(r2, "playListId");
            Intrinsics.checkNotNullParameter(r4, "content");
            ad9.b.a.getClass();
            ad9.b.a.b.put(r2 + r3, r4);
        }

        public static void d(String r2, String r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, "playListId");
            if (TextUtils.equals(r2, d) == true) goto L5;
            return;
        L5:
            FLogger.a.i("CreationPlayList", "[updateResumeCompatDuration] " + r3 + " progress " + r4);
            if (r3 == null) goto L10;
            if (r4 < 0) goto L11;
            e.put(r3, Integer.valueOf(r4));
            return;
        L11:
            return;
        }
    }

    static {
        a = a.a;
    }
}
