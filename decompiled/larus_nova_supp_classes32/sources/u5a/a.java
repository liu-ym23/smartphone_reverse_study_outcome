package u5a;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import com.lynx.clay.embedding.android.KeyEventType;
import com.lynx.clay.embedding.engine.renderer.FlutterRenderer;
import com.obric.aivoice.core.data.NameKeys;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a extends BaseInputConnection {
    public final FlutterRenderer a;
    public final com.lynx.clay.embedding.android.a b;
    public int c;

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean performEditorAction(int r2) {
        this.a.a.performEditorAction(r2);
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean sendKeyEvent(KeyEvent r8) {
        com.lynx.clay.embedding.android.a r0 = this.b;
        if (r0 != null) goto L5;
    L12:
        int r1 = r8.getUnicodeChar();
        if (r1 != 0) goto L15;
        Character r2 = null;
    L31:
        if (r2 == null) goto L33;
        String r3 = r2.toString();
    L34:
        ByteBuffer r4 = ByteBuffer.allocateDirect(40);
        r4.order(ByteOrder.LITTLE_ENDIAN);
        r4.putLong(r8.getEventTime());
        r4.putLong(r8.getAction());
        r4.putLong(0);
        r4.putLong(r8.getKeyCode());
        r4.putLong(0);
        this.a.a.sendKeyboardEventDataPacket(r4, r3);
        return true;
    L33:
        r3 = NameKeys.UnloadStrategy_No_Strategy;
        goto L34
    L15:
        char r5 = (char) r1;
        if ((Integer.MIN_VALUE & r1) == 0) goto L18;
        boolean r6 = true;
    L19:
        if (r6 == false) goto L24;
        int r7 = r1 & Integer.MAX_VALUE;
        int r9 = this.c;
        if (r9 == 0) goto L23;
        this.c = KeyCharacterMap.getDeadChar(r9, r7);
    L30:
        r2 = Character.valueOf(r5);
        goto L31
    L23:
        this.c = r7;
        goto L30
    L24:
        int r10 = this.c;
        if (r10 == 0) goto L30;
        int r11 = KeyCharacterMap.getDeadChar(r10, r1);
        if (r11 <= 0) goto L29;
        r5 = (char) r11;
    L29:
        this.c = 0;
        goto L30
    L18:
        r6 = false;
        goto L19
    L5:
        if (r0.d.a(r8.hashCode()) == null) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == true) goto L12;
        if (this.b.a(r8) == false) goto L12;
        return true;
    L7:
        r12 = false;
        goto L8
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean commitText(CharSequence r6, int r7) {
        ByteBuffer r0 = ByteBuffer.allocateDirect(40);
        r0.order(ByteOrder.LITTLE_ENDIAN);
        r0.putLong(0);
        r0.putLong(KeyEventType.COMMIT_TEXT.ordinal());
        r0.putLong(0);
        r0.putLong(0);
        r0.putLong(0);
        FlutterRenderer r1 = this.a;
        r1.a.sendKeyboardEventDataPacket(r0, r6.toString());
        return super.commitText(r6, r7);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int r2, int r3) {
        this.a.a.deleteSurroundingText(r2, r3);
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public final boolean setComposingText(CharSequence r5, int r6) {
        ByteBuffer r7 = ByteBuffer.allocateDirect(40);
        r7.order(ByteOrder.LITTLE_ENDIAN);
        r7.putLong(0);
        r7.putLong(KeyEventType.COMMIT_COMPOSING_TEXT.ordinal());
        r7.putLong(0);
        r7.putLong(0);
        r7.putLong(0);
        FlutterRenderer r0 = this.a;
        r0.a.sendKeyboardEventDataPacket(r7, r5.toString());
        return true;
    }

    public a(View r2, FlutterRenderer r3, com.lynx.clay.embedding.android.a r4) {
        super(r2, true);
        this.c = 0;
        this.a = r3;
        this.b = r4;
    }
}
