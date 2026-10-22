package com.larus.bmhome.music.player;

import android.media.MediaPlayer;
import com.larus.im.bean.message.Message;
import com.larus.im.observer.MessageListState;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public static final f a = null;
    public static final boolean b = false;
    public static volatile String c;
    public static WeakReference<com.larus.bmhome.music.player.a> d;
    public static boolean e;

    public static final class a implements nf9.b {
        public a() {
        }

        public final void a(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void c(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "cid");
            Intrinsics.checkNotNullParameter(r2, "msg");
        }

        public final void d(String r2, Message r3) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        public final void e(String r1, Message r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r1, "cid");
            Intrinsics.checkNotNullParameter(r2, "msg");
        }

        public final void onMessageListReplaced(String r2, List<Message> r3, List<Message> r4) {
            Intrinsics.checkNotNullParameter(r2, "cid");
            Intrinsics.checkNotNullParameter(r3, "oldMsgList");
            Intrinsics.checkNotNullParameter(r4, "newMsgList");
        }

        public final void f(String r3, Message r4) {
            Intrinsics.checkNotNullParameter(r3, "cid");
            Intrinsics.checkNotNullParameter(r4, "msg");
            WeakReference<com.larus.bmhome.music.player.a> r5 = f.d;
            String r0 = null;
            if (r5 == null) goto L5;
            com.larus.bmhome.music.player.a r6 = r5.get();
        L6:
            if (r6 == null) goto L10;
            j r1 = r6.data();
            if (r1 == null) goto L10;
            r0 = r1.j();
        L10:
            String r7 = r4.getMessageId();
            if (r7 != null) goto L14;
            r7 = "";
        L14:
            if (Intrinsics.areEqual(r0, r7) == false) goto L17;
            r6.k(true);
            return;
        L17:
            return;
        L5:
            r6 = null;
            goto L6
        }

        public final void b(String r3, MessageListState r4, List<Message> r5) {
            Intrinsics.checkNotNullParameter(r3, "cid");
            Intrinsics.checkNotNullParameter(r4, "state");
            Intrinsics.checkNotNullParameter(r5, "msgList");
            WeakReference<com.larus.bmhome.music.player.a> r6 = f.d;
            String r0 = null;
            if (r6 == null) goto L5;
            com.larus.bmhome.music.player.a r7 = r6.get();
        L7:
            if (r4 != MessageListState.DELETE) goto L22;
            List<Message> r8 = r5;
            ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
            Iterator<T> r10 = r8.iterator();
        L10:
            if (r10.hasNext() == false) goto L12;
            r9.add(((Message) r10.next()).getMessageId());
            goto L10
        L12:
            if (r7 == null) goto L17;
            j r11 = r7.data();
            if (r11 == null) goto L17;
            r0 = r11.j();
        L17:
            if (r9.contains(r0) == false) goto L23;
            if (r7 == null) goto L24;
            r7.k(true);
            return;
        L24:
            return;
        L23:
            return;
        L22:
            return;
        L5:
            r7 = null;
            goto L7
        }
    }

    public f() {
    }

    static {
        a = new f();
        b = z2.a.musicCreateSupportStreaming();
        com.larus.im.d.e().registerOnGlobalMessageObserver(new a());
        c = "";
    }

    public static void c() {
        WeakReference<com.larus.bmhome.music.player.a> r0 = d;
        if (r0 == null) goto L8;
        com.larus.bmhome.music.player.a r1 = r0.get();
        if (r1 == null) goto L9;
        r1.k(true);
        return;
    L9:
        return;
    }

    public static void a(j r5, com.larus.bmhome.music.player.a r6) {
        Intrinsics.checkNotNullParameter(r6, "self");
        if (r5 != null) goto L5;
        return;
    L5:
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[acquirePlay] id ");
        r1.append(c);
        r1.append(" self ");
        r1.append(r5.j());
        r1.append(' ');
        ad9.b r2 = r5.g;
        String r3 = null;
        if (r2 == null) goto L8;
        String r4 = r2.getItemId();
    L9:
        r1.append(r4);
        r0.i("acquirePlay", r1.toString());
        StringBuilder r7 = new StringBuilder();
        r7.append(r5.j());
        ad9.b r8 = r5.g;
        if (r8 == null) goto L12;
        r3 = r8.getItemId();
    L12:
        r7.append(r3);
        c = r7.toString();
        WeakReference<com.larus.bmhome.music.player.a> r9 = d;
        if (r9 == null) goto L33;
        com.larus.bmhome.music.player.a r10 = r9.get();
        if (r10 == null) goto L33;
        if (Intrinsics.areEqual(r10, r6) == true) goto L33;
        if (r6.a() == true) goto L33;
        if (r10.a() == false) goto L33;
        r0.i("acquirePlay", "pause");
        r10.k(true);
    L33:
        MediaPlayer r11 = StreamingMusicPlayer.q;     // Catch: IllegalStateException -> L30
        if (r11 != null) goto L26;
    L31:
        d = new WeakReference(r6);
        return;
    L26:
        if (fna.g.d() == true) goto L28;
        r11.pause();     // Catch: IllegalStateException -> L30
        goto L31
    L28:
        r11.pause();     // Catch: IllegalStateException -> L30
        gna.a.a(r11.hashCode());     // Catch: IllegalStateException -> L30
    L30:
        FLogger.a.i("acquire media player", "ensure pause");
        goto L31
    L8:
        r4 = null;
        goto L9
    }

    public static com.larus.bmhome.music.player.a b(com.larus.bmhome.music.player.a.InterfaceC0021a r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "parent");
        if (b == false) goto L6;
        return new StreamingMusicPlayer(r1, r2);
    L6:
        return new VideoEngineMusicPlayerViewImpl(r1, r2);
    }

    public static void d(j r4, com.larus.bmhome.music.player.a r5) {
        Intrinsics.checkNotNullParameter(r5, "self");
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("[resetWeakPlaying] id ");
        r1.append(c);
        r1.append(" self ");
        String r2 = null;
        if (r4 == null) goto L5;
        String r3 = r4.j();
    L6:
        r1.append(r3);
        r1.append(' ');
        if (r4 == null) goto L11;
        ad9.b r6 = r4.g;
        if (r6 == null) goto L11;
        String r7 = r6.getItemId();
    L12:
        r1.append(r7);
        r0.i("acquirePlay", r1.toString());
        if (r4 != null) goto L15;
        return;
    L15:
        String r8 = c;
        StringBuilder r9 = new StringBuilder();
        r9.append(r4.j());
        ad9.b r10 = r4.g;
        if (r10 == null) goto L18;
        r2 = r10.getItemId();
    L18:
        r9.append(r2);
        if (Intrinsics.areEqual(r8, r9.toString()) == false) goto L22;
        d = new WeakReference(r5);
        return;
    L22:
        return;
    L11:
        r7 = null;
        goto L12
    L5:
        r3 = null;
        goto L6
    }
}
