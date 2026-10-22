package com.larus.browsertakeover.cdp;

import com.larus.bmhome.share.panel.ShareType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public abstract class RemoteInputCommand {

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/browsertakeover/cdp/RemoteInputCommand$Key;", "", "key", "", "code", "virtualKeyCode", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V", "getKey", "()Ljava/lang/String;", "getCode", "getVirtualKeyCode", "()I", "BACKSPACE", "TAB", "ENTER", "DELETE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Key extends Enum<Key> {
        public static final Key BACKSPACE = null;
        public static final Key DELETE = null;
        public static final Key ENTER = null;
        public static final Key TAB = null;
        public static final /* synthetic */ Key[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String code;
        private final String key;
        private final int virtualKeyCode;

        public static EnumEntries<Key> getEntries() {
            return b;
        }

        static {
            Key r6 = new Key("BACKSPACE", 0, "Backspace", "Backspace", 8);
            BACKSPACE = r6;
            Key r0 = new Key("TAB", 1, "Tab", "Tab", 9);
            TAB = r0;
            Key r1 = new Key("ENTER", 2, "Enter", "Enter", 13);
            ENTER = r1;
            Key r2 = new Key("DELETE", 3, "Delete", "Delete", 46);
            DELETE = r2;
            Key[] r3 = {r6, r0, r1, r2};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static Key[] values() {
            return (Key[]) a.clone();
        }

        public final String getCode() {
            return this.code;
        }

        public final String getKey() {
            return this.key;
        }

        public final int getVirtualKeyCode() {
            return this.virtualKeyCode;
        }

        public static Key valueOf(String r1) {
            return (Key) r27.a.a(Key.class, r1);
        }

        public Key(String r1, int r2, String r3, String r4, int r5) {
            super(r1, r2);
            this.key = r3;
            this.code = r4;
            this.virtualKeyCode = r5;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/browsertakeover/cdp/RemoteInputCommand$Phase;", "", "cdpType", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getCdpType", "()Ljava/lang/String;", "DOWN", "UP", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Phase extends Enum<Phase> {
        public static final Phase DOWN = null;
        public static final Phase UP = null;
        public static final /* synthetic */ Phase[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String cdpType;

        public static EnumEntries<Phase> getEntries() {
            return b;
        }

        static {
            Phase r0 = new Phase("DOWN", 0, "keyDown");
            DOWN = r0;
            Phase r1 = new Phase("UP", 1, "keyUp");
            UP = r1;
            Phase[] r2 = {r0, r1};
            a = r2;
            b = EnumEntriesKt.enumEntries(r2);
        }

        public static Phase[] values() {
            return (Phase[]) a.clone();
        }

        public final String getCdpType() {
            return this.cdpType;
        }

        public static Phase valueOf(String r1) {
            return (Phase) r27.a.a(Phase.class, r1);
        }

        public Phase(String r1, int r2, String r3) {
            super(r1, r2);
            this.cdpType = r3;
        }
    }

    public static final class a extends RemoteInputCommand {
        public final Function0<Unit> a;
        public final Function0<Unit> b;

        public a(Function0<Unit> r2, Function0<Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, "action");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class b extends RemoteInputCommand {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "InsertText(text=" + this.a + ')';
        }

        public b(String r2) {
            Intrinsics.checkNotNullParameter(r2, ShareType.TEXT);
            this.a = r2;
        }
    }

    public static final class c extends RemoteInputCommand {
        public final Key a;
        public final Phase b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "KeyEvent(key=" + this.a + ", phase=" + this.b + ')';
        }

        public c(Key r2, Phase r3) {
            Intrinsics.checkNotNullParameter(r2, "key");
            Intrinsics.checkNotNullParameter(r3, "phase");
            this.a = r2;
            this.b = r3;
        }
    }

    public RemoteInputCommand() {
    }
}
