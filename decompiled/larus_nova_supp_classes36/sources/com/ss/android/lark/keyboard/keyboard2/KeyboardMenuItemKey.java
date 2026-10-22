package com.ss.android.lark.keyboard.keyboard2;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/keyboard/keyboard2/KeyboardMenuItemKey;", "", "<init>", "(Ljava/lang/String;I)V", "AaStyle", "At", "Emoji", "Plus", "Photo", "Voice", "UploadLog", "BurnLife", "TodoAttachment", "HashTag", "RestrictedBurnLife", "File", "keyboard-base_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final enum KeyboardMenuItemKey extends Enum<KeyboardMenuItemKey> {
    public static final KeyboardMenuItemKey AaStyle = null;
    public static final KeyboardMenuItemKey At = null;
    public static final KeyboardMenuItemKey BurnLife = null;
    public static final KeyboardMenuItemKey Emoji = null;
    public static final KeyboardMenuItemKey File = null;
    public static final KeyboardMenuItemKey HashTag = null;
    public static final KeyboardMenuItemKey Photo = null;
    public static final KeyboardMenuItemKey Plus = null;
    public static final KeyboardMenuItemKey RestrictedBurnLife = null;
    public static final KeyboardMenuItemKey TodoAttachment = null;
    public static final KeyboardMenuItemKey UploadLog = null;
    public static final KeyboardMenuItemKey Voice = null;
    public static final /* synthetic */ KeyboardMenuItemKey[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<KeyboardMenuItemKey> getEntries() {
        return b;
    }

    static {
        KeyboardMenuItemKey r0 = new KeyboardMenuItemKey("AaStyle", 0);
        AaStyle = r0;
        KeyboardMenuItemKey r1 = new KeyboardMenuItemKey("At", 1);
        At = r1;
        KeyboardMenuItemKey r3 = new KeyboardMenuItemKey("Emoji", 2);
        Emoji = r3;
        KeyboardMenuItemKey r5 = new KeyboardMenuItemKey("Plus", 3);
        Plus = r5;
        KeyboardMenuItemKey r7 = new KeyboardMenuItemKey("Photo", 4);
        Photo = r7;
        KeyboardMenuItemKey r9 = new KeyboardMenuItemKey("Voice", 5);
        Voice = r9;
        KeyboardMenuItemKey r11 = new KeyboardMenuItemKey("UploadLog", 6);
        UploadLog = r11;
        KeyboardMenuItemKey r13 = new KeyboardMenuItemKey("BurnLife", 7);
        BurnLife = r13;
        KeyboardMenuItemKey r15 = new KeyboardMenuItemKey("TodoAttachment", 8);
        TodoAttachment = r15;
        KeyboardMenuItemKey r14 = new KeyboardMenuItemKey("HashTag", 9);
        HashTag = r14;
        KeyboardMenuItemKey r12 = new KeyboardMenuItemKey("RestrictedBurnLife", 10);
        RestrictedBurnLife = r12;
        KeyboardMenuItemKey r10 = new KeyboardMenuItemKey("File", 11);
        File = r10;
        KeyboardMenuItemKey[] r8 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10};
        a = r8;
        b = EnumEntriesKt.enumEntries(r8);
    }

    public static KeyboardMenuItemKey[] values() {
        return (KeyboardMenuItemKey[]) a.clone();
    }

    public static KeyboardMenuItemKey valueOf(String r1) {
        return (KeyboardMenuItemKey) r27.a.a(KeyboardMenuItemKey.class, r1);
    }

    public KeyboardMenuItemKey(String r1, int r2) {
        super(r1, r2);
    }
}
