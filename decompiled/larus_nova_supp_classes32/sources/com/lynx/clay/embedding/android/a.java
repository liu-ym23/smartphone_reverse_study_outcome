package com.lynx.clay.embedding.android;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import com.lynx.clay.embedding.engine.renderer.FlutterRenderer;
import com.obric.aivoice.core.data.NameKeys;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public FlutterRenderer a;
    public u5a.b b;
    public int c;
    public C0033a d;

    /* JADX INFO: renamed from: com.lynx.clay.embedding.android.a$a, reason: collision with other inner class name */
    public static class C0033a implements b {
        public final Deque<KeyEvent> a;
        public View b;
        public u5a.b c;

        public final KeyEvent a(int r4) {
            Iterator r0 = ((ArrayDeque) this.a).iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            KeyEvent r1 = (KeyEvent) r0.next();
            if (r1.hashCode() != r4) goto L4;
            return r1;
        L8:
            return null;
        }

        public C0033a(View r2, u5a.b r3) {
            this.a = new ArrayDeque();
            this.b = r2;
            this.c = r3;
        }
    }

    public interface b {
    }

    public interface c {
    }

    public final boolean a(KeyEvent r11) {
        int r0 = r11.getAction();
        if (r0 == 0) goto L7;
        if (r0 == 1) goto L7;
        return false;
    L7:
        if (this.d.a(r11.hashCode()) == null) goto L9;
        boolean r3 = true;
    L10:
        if (r3 == false) goto L13;
        ((ArrayDeque) this.d.a).remove(r11);
        return false;
    L13:
        int r4 = r11.getUnicodeChar();
        if (r4 != 0) goto L16;
        Character r2 = null;
    L32:
        if (r2 == null) goto L34;
        String r5 = r2.toString();
    L35:
        Long r6 = KeyboardMap.a.get(Long.valueOf(r11.getScanCode()));
        Long r7 = KeyboardMap.b.get(Long.valueOf(r11.getKeyCode()));
        ByteBuffer r8 = ByteBuffer.allocateDirect(40);
        r8.order(ByteOrder.LITTLE_ENDIAN);
        r8.putLong(r11.getEventTime());
        if (r0 != 0) goto L38;
        long r9 = 0;
    L39:
        r8.putLong(r9);
        if (r6 != null) goto L42;
        long r10 = 0;
    L43:
        r8.putLong(r10);
        if (r7 != null) goto L46;
        long r12 = 0;
    L47:
        r8.putLong(r12);
        r8.putLong(0);
        C0033a r1 = this.d;
        ((ArrayDeque) r1.a).addLast(r11);
        if (((ArrayDeque) r1.a).size() <= 1000) goto L50;
        c5a.c.d(6, "AndroidKeyProcessor", "There are " + ((ArrayDeque) r1.a).size() + " keyboard events that have not yet received a response. Are responses being sent?");
    L50:
        FlutterRenderer r13 = this.a;
        r13.a.dispatchKeyDataPacket(r8, r5, r11.hashCode());
        return true;
    L46:
        r12 = r7.longValue();
        goto L47
    L42:
        r10 = r6.longValue();
        goto L43
    L38:
        r9 = 1;
        goto L39
    L34:
        r5 = NameKeys.UnloadStrategy_No_Strategy;
        goto L35
    L16:
        char r14 = (char) r4;
        if ((Integer.MIN_VALUE & r4) == 0) goto L19;
        boolean r15 = true;
    L20:
        if (r15 == false) goto L25;
        int r16 = Integer.MAX_VALUE & r4;
        int r17 = this.c;
        if (r17 == 0) goto L24;
        this.c = KeyCharacterMap.getDeadChar(r17, r16);
    L31:
        r2 = Character.valueOf(r14);
        goto L32
    L24:
        this.c = r16;
        goto L31
    L25:
        int r18 = this.c;
        if (r18 == 0) goto L31;
        int r19 = KeyCharacterMap.getDeadChar(r18, r4);
        if (r19 <= 0) goto L30;
        r14 = (char) r19;
    L30:
        this.c = 0;
        goto L31
    L19:
        r15 = false;
        goto L20
    L9:
        r3 = false;
        goto L10
    }

    public a(View r1, FlutterRenderer r2, u5a.b r3) {
        this.a = r2;
        this.b = r3;
        r3.f = this;
        C0033a r4 = new C0033a(r1, r3);
        this.d = r4;
        this.a.a.setEventResponseHandler(r4);
    }
}
