package com.ss.android.lark.feed.shared.data;

import java.util.concurrent.atomic.AtomicBoolean;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class LoadState {
    public final AtomicBoolean a;

    public static final enum LoadType extends Enum<LoadType> {
        public static final LoadType CONNECT = null;
        public static final LoadType LOCAL = null;
        public static final LoadType NET = null;
        public static final LoadType UNKNOWN = null;
        public static final /* synthetic */ LoadType[] a = null;
        private int value;

        static {
            LoadType r0 = new LoadType("UNKNOWN", 0, -1);
            UNKNOWN = r0;
            LoadType r1 = new LoadType("LOCAL", 1, 0);
            LOCAL = r1;
            LoadType r2 = new LoadType("NET", 2, 1);
            NET = r2;
            LoadType r5 = new LoadType("CONNECT", 3, 2);
            CONNECT = r5;
            a = new LoadType[]{r0, r1, r2, r5};
        }

        public static LoadType[] values() {
            return (LoadType[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static LoadType forNumber(int r1) {
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L12;
            if (r1 == 2) goto L10;
            return UNKNOWN;
        L10:
            return CONNECT;
        L12:
            return NET;
        L14:
            return LOCAL;
        }

        public static LoadType valueOf(String r1) {
            return (LoadType) a.a(LoadType.class, r1);
        }

        public static LoadType valueOf(int r0) {
            return forNumber(r0);
        }

        public LoadType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public LoadState() {
        new AtomicBoolean(false);
        this.a = new AtomicBoolean(false);
        new AtomicBoolean(false);
    }
}
