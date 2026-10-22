package com.bytedance.ai.widget;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final List<C0055a> a = null;

    /* JADX INFO: renamed from: com.bytedance.ai.widget.a$a, reason: collision with other inner class name */
    public static final class C0055a {
        public final String a;
        public final String b;
        public final String c;

        public final boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof C0055a) == true) goto L8;
            return false;
        L8:
            C0055a r11 = (C0055a) r10;
            if (Intrinsics.areEqual(this.a, r11.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r11.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r11.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "WidgetDegradeSetting(appletId=" + this.a + ", originalWidgetId=" + this.b + ", degradeWidgetId=" + this.c + ')';
        }

        public C0055a(String r10, String r11) {
            Intrinsics.checkNotNullParameter("com.flow.music.auth", "appletId");
            Intrinsics.checkNotNullParameter(r10, "originalWidgetId");
            Intrinsics.checkNotNullParameter(r11, "degradeWidgetId");
            this.a = "com.flow.music.auth";
            this.b = r10;
            this.c = r11;
        }
    }

    static {
        a = CollectionsKt.listOf(new C0055a[]{new C0055a("widget__playlist_rx", "widget__playlist"), new C0055a("widget__single_music_rx", "widget__single_music"), new C0055a("widget__album_rx", "widget__album"), new C0055a("widget__artist_album_rx", "widget__artist_album"), new C0055a("widget__collected_music_rx", "widget__collected_music"), new C0055a("widget__collect_mix_rx", "widget__collect_mix"), new C0055a("widget__auth_card_rx", "widget__auth_card"), new C0055a("widget__auth_card_onboarding_rx", "widget__auth_card_onboarding"), new C0055a("widget__card_onboarding_tb_rx", "widget__card_onboarding_tb")});
    }

    public static String a(String r10, String r11) {
        if (r10 == null) goto L24;
        if (r11 == null) goto L24;
        Iterator<T> r12 = a.iterator();
    L8:
        if (r12.hasNext() == false) goto L17;
        Object r13 = r12.next();
        C0055a r14 = (C0055a) r13;
        if (Intrinsics.areEqual(r14.a, r10) == true) goto L12;
    L14:
        boolean r15 = false;
    L15:
        if (r15 == false) goto L8;
    L18:
        C0055a r16 = (C0055a) r13;
        if (r16 == null) goto L31;
        String r17 = r16.c;
        if (r17 == null) goto L32;
        com.bytedance.ai.utils.g.a.i("WidgetDegradeMapping", "getDegradeWidgetId: " + r11 + " -> " + r17);
        return r17;
    L32:
        return null;
    L31:
        return null;
    L12:
        if (Intrinsics.areEqual(r14.b, r11) == false) goto L14;
        r15 = true;
        goto L15
    L17:
        r13 = null;
    L24:
        com.bytedance.ai.utils.g.a.e("WidgetDegradeMapping", "getDegradeWidgetId: appletId or widgetId is null");
        return null;
    }
}
