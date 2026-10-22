package com.ss.android.lark.maincore;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface ITitleInfo {

    public static final enum IconStyle extends Enum<IconStyle> {
        public static final IconStyle Down = null;
        public static final IconStyle Hide = null;
        public static final IconStyle Up = null;
        public static final /* synthetic */ IconStyle[] a = null;
        private int value;

        static {
            IconStyle r0 = new IconStyle("Hide", 0, 0);
            Hide = r0;
            IconStyle r1 = new IconStyle("Up", 1, 1);
            Up = r1;
            IconStyle r3 = new IconStyle("Down", 2, 2);
            Down = r3;
            a = new IconStyle[]{r0, r1, r3};
        }

        public static IconStyle[] values() {
            return (IconStyle[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static IconStyle forNumber(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return null;
        L10:
            return Down;
        L12:
            return Up;
        L14:
            return Hide;
        }

        public static IconStyle valueOf(String r1) {
            return (IconStyle) a.a(IconStyle.class, r1);
        }

        public static IconStyle valueOf(int r0) {
            return forNumber(r0);
        }

        public IconStyle(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final enum Status extends Enum<Status> {
        public static final Status Loading = null;
        public static final Status Normal = null;
        public static final /* synthetic */ Status[] a = null;
        private int value;

        static {
            Status r0 = new Status("Normal", 0, 0);
            Normal = r0;
            Status r1 = new Status("Loading", 1, 1);
            Loading = r1;
            a = new Status[]{r0, r1};
        }

        public static Status[] values() {
            return (Status[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Status forNumber(int r1) {
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L8;
            return null;
        L8:
            return Loading;
        L10:
            return Normal;
        }

        public static Status valueOf(String r1) {
            return (Status) a.a(Status.class, r1);
        }

        public static Status valueOf(int r0) {
            return forNumber(r0);
        }

        public Status(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }
}
