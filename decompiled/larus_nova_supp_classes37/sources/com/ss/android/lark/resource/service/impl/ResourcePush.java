package com.ss.android.lark.resource.service.impl;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class ResourcePush {
    public final List<qpc.c> a;
    public final List<qpc.d> b;
    public final List<qpc.b> c;
    public final List<Object> d;

    public static final enum Link extends Enum<Link> {
        public static final Link DOWNLOAD = null;
        public static final Link UNKNOWN = null;
        public static final Link UPLOAD = null;
        public static final /* synthetic */ Link[] a = null;
        private int value;

        static {
            Link r0 = new Link("UNKNOWN", 0, -1);
            UNKNOWN = r0;
            Link r1 = new Link("UPLOAD", 1, 1);
            UPLOAD = r1;
            Link r2 = new Link("DOWNLOAD", 2, 2);
            DOWNLOAD = r2;
            a = new Link[]{r0, r1, r2};
        }

        public static Link[] values() {
            return (Link[]) a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Link forNumber(int r1) {
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L9;
            return UNKNOWN;
        L9:
            return DOWNLOAD;
        L11:
            return UPLOAD;
        }

        public static Link valueOf(String r1) {
            return (Link) r27.a.a(Link.class, r1);
        }

        public static Link valueOf(int r0) {
            return forNumber(r0);
        }

        public Link(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static class a {
        public static final ResourcePush a = null;

        static {
            a = new ResourcePush();
        }
    }

    public ResourcePush() {
        this.a = new CopyOnWriteArrayList();
        this.b = new CopyOnWriteArrayList();
        this.c = new CopyOnWriteArrayList();
        this.d = new CopyOnWriteArrayList();
    }
}
