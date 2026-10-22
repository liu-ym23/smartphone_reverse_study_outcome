package com.ss.android.lark.chat.entity.chatter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public static final b a = null;
    public static final a b = null;

    public static final class a implements com.ss.android.lark.chat.entity.chatter.b {
        public a() {
        }

        @Override // com.ss.android.lark.chat.entity.chatter.b
        public final List<TagInfo> a(List<TagInfo> r5) {
            Intrinsics.checkNotNullParameter(r5, "lst");
            ArrayList r0 = new ArrayList();
            Iterator<T> r6 = r5.iterator();
        L4:
            if (r6.hasNext() == false) goto L11;
            Object r1 = r6.next();
            if (((TagInfo) r1).getType() != TagType.ADMIN_USER) goto L8;
            boolean r2 = true;
        L9:
            if (r2 == true) goto L4;
            r0.add(r1);
            goto L4
        L8:
            r2 = false;
            goto L9
        L11:
            return r0;
        }
    }

    public static final class b implements com.ss.android.lark.chat.entity.chatter.b {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object, java.util.List<com.ss.android.lark.chat.entity.chatter.TagInfo>] */
        /* JADX WARN: Type inference failed for: r7v1, types: [java.util.List<com.ss.android.lark.chat.entity.chatter.TagInfo>] */
        /* JADX WARN: Type inference failed for: r7v2, types: [java.util.ArrayList] */
        @Override // com.ss.android.lark.chat.entity.chatter.b
        public final List<TagInfo> a(List<TagInfo> r7) {
            Intrinsics.checkNotNullParameter(r7, "lst");
            Iterable r0 = (Iterable) r7;
            if ((r0 instanceof Collection) == true) goto L5;
        L7:
            Iterator r1 = r0.iterator();
        L9:
            if (r1.hasNext() == false) goto L16;
            if (((TagInfo) r1.next()).getType() != TagType.CLASS_TEACHER) goto L13;
            boolean r4 = true;
        L14:
            if (r4 == false) goto L9;
            boolean r2 = true;
        L17:
            if (r2 == false) goto L27;
            r7 = new ArrayList();
            Iterator r3 = r0.iterator();
        L20:
            if (r3.hasNext() == false) goto L27;
            Object r5 = r3.next();
            if (((TagInfo) r5).getType() != TagType.DISCIPLINE_TEACHER) goto L24;
            boolean r6 = true;
        L25:
            if (r6 == true) goto L20;
            r7.add(r5);
            goto L20
        L24:
            r6 = false;
        L27:
            return r7;
        L13:
            r4 = false;
        L16:
            r2 = false;
            goto L17
        L5:
            if (((Collection) r0).isEmpty() == false) goto L7;
            goto L7
        }
    }

    static {
        a = new b();
        b = new a();
    }
}
