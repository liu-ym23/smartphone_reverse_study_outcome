package com.ss.android.lark.feed.shared.data;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ICache$Operation {

    public static final enum Type extends Enum<Type> {
        public static final Type ADD = null;
        public static final Type MOVE = null;
        public static final Type REMOVE = null;
        public static final Type UNKNOWN = null;
        public static final Type UPDATE = null;
        public static final /* synthetic */ Type[] a = null;
        private final int value;

        static {
            Type r0 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            Type r1 = new Type("UPDATE", 1, 1);
            UPDATE = r1;
            Type r3 = new Type("ADD", 2, 2);
            ADD = r3;
            Type r5 = new Type("REMOVE", 3, 3);
            REMOVE = r5;
            Type r7 = new Type("MOVE", 4, 4);
            MOVE = r7;
            a = new Type[]{r0, r1, r3, r5, r7};
        }

        public static Type[] values() {
            return (Type[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Type forNumber(int r1) {
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L17;
            if (r1 == 3) goto L15;
            if (r1 == 4) goto L13;
            return UNKNOWN;
        L13:
            return MOVE;
        L15:
            return REMOVE;
        L17:
            return ADD;
        L19:
            return UPDATE;
        }

        public static Type valueOf(String r1) {
            return (Type) a.a(Type.class, r1);
        }

        public static Type valueOf(int r0) {
            return forNumber(r0);
        }

        public Type(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }
}
