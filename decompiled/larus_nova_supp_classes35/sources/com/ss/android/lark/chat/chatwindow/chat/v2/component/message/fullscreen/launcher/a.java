package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher;

import com.larksuite.framework.thread.n;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public static final ExecutorService a = null;
    public static final Map<C0067a, b> b = null;
    public static final Map<C0067a, Object> c = null;
    public static final List<c> d = null;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a$a, reason: collision with other inner class name */
    public static final class C0067a {
        public final String a;
        public final PageType b;
        public final String c;

        public final String toString() {
            return "DataKey(chatId=" + this.a + ", pageType=" + this.b + ", uuid=" + this.c + ')';
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 == null) goto L8;
            Class<?> r2 = r5.getClass();
        L10:
            if (Intrinsics.areEqual(C0067a.class, r2) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.FullScreenVODataCenter.DataKey");
            C0067a r6 = (C0067a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L16;
            return false;
        L16:
            if (this.b == r6.b) goto L19;
            return false;
        L19:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L21;
            return false;
        L21:
            return true;
        L8:
            r2 = null;
            goto L10
        }

        public C0067a(String r2, PageType r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "chatId");
            Intrinsics.checkNotNullParameter(r3, "pageType");
            Intrinsics.checkNotNullParameter(r4, "uuid");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.launcher.a$b$a, reason: collision with other inner class name */
        public static final class C0068a {
        }

        static {
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L8;
            return false;
        L8:
            ((b) r4).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(null, null) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(null, null) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(null, null) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "DataUpdateTask(key=null, messageId=null, messageVO=null, message=null)";
        }
    }

    public static abstract class c {
        public c(C0067a r2) {
            Intrinsics.checkNotNullParameter(r2, "dataKey");
        }
    }

    static {
        a = PThreadExecutorsUtils.newSingleThreadExecutor(new n("FullVODataCenter"));
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
        d = new CopyOnWriteArrayList();
    }
}
