package com.larus.bmhome.chat.standarduikit.interaction.viewmodel;

import com.larus.bmhome.interactionpanel.w;
import com.larus.bmhome.interactionpanel.x;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.block.QuickReplyInteractionType;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {
    public static final a g = null;
    public static final Set<Integer> h = null;
    public final Function0<Long> a;
    public final com.larus.bmhome.chat.standarduikit.interaction.viewmodel.a b;
    public final Function2<String, JSONObject, Unit> c;
    public b d;
    public Long e;
    public boolean f;

    public static final class a {
        public a() {
        }

        public static String a(String r1) {
            if (r1 == null) goto L11;
            String r2 = StringsKt.trim(r1).toString();
            if (r2 == null) goto L11;
            if (r2.length() <= 0) goto L8;
            boolean r0 = true;
        L9:
            if (r0 == false) goto L11;
            return r2;
        L8:
            r0 = false;
        L11:
            return null;
        }
    }

    public static final class b {
        public final String a;
        public final String b;
        public final int c;
        public final boolean d;
        public final String e;
        public final String f;
        public final String g;
        public final w h;
        public final String i;
        public final String j;
        public final String k;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.k, r6.k) == true) goto L41;
            return false;
        L41:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31;
            if (this.d == false) goto L5;
            int r1 = 1231;
        L6:
            int r2 = (((((((r0 + r1) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
            w r3 = this.h;
            int r4 = 0;
            if (r3 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r2 + r5) * 31;
            String r7 = this.i;
            if (r7 == null) goto L15;
            r4 = r7.hashCode();
        L15:
            return ((((r6 + r4) * 31) + this.j.hashCode()) * 31) + this.k.hashCode();
        L9:
            r5 = r3.hashCode();
            goto L10
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "Context(blockId=" + this.a + ", messageId=" + this.b + ", interactionType=" + this.c + ", folderSpecified=" + this.d + ", currentPage=" + this.e + ", displayType=" + this.f + ", agentType=" + this.g + ", trackContext=" + this.h + ", triggerScene=" + this.i + ", conversationId=" + this.j + ", accountId=" + this.k + ')';
        }

        public b(String r2, String r3, int r4, boolean r5, String r6, String r7, String r8, w r9, String r10, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r2, "blockId");
            Intrinsics.checkNotNullParameter(r3, "messageId");
            Intrinsics.checkNotNullParameter(r6, "currentPage");
            Intrinsics.checkNotNullParameter(r7, "displayType");
            Intrinsics.checkNotNullParameter(r8, "agentType");
            Intrinsics.checkNotNullParameter(r11, "conversationId");
            Intrinsics.checkNotNullParameter(r12, "accountId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
        }
    }

    static {
        g = new a();
        h = SetsKt.setOf(new Integer[]{Integer.valueOf(QuickReplyInteractionType.QUICK_REPLY_INTERACTION_TYPE_REQUEST_ACTION.getValue()), Integer.valueOf(QuickReplyInteractionType.QUICK_REPLY_INTERACTION_TYPE_BASH_WARN.getValue()), Integer.valueOf(QuickReplyInteractionType.QUICK_REPLY_INTERACTION_TYPE_AUTHORIZE_FOLDER.getValue())});
    }

    public final void b() {
        Intrinsics.checkNotNullParameter("closed", "result");
        if (this.f == true) goto L13;
        b r0 = this.d;
        if (r0 == null) goto L14;
        Long r2 = this.e;
        if (r2 == null) goto L12;
        c(r0, r2.longValue(), "closed");
        return;
    L12:
        return;
    L14:
        return;
    }

    public final void d() {
        if (this.e == null) goto L5;
        return;
    L5:
        b r0 = this.d;
        if (r0 != null) goto L8;
        return;
    L8:
        com.larus.bmhome.chat.standarduikit.interaction.viewmodel.a r1 = this.b;
        com.larus.bmhome.chat.standarduikit.interaction.viewmodel.a.b r2 = e(r0);
        monitor-enter(r1);
        Intrinsics.checkNotNullParameter(r2, "key");     // Catch: Throwable -> L16
        boolean r3 = r1.b.contains(r2);     // Catch: Throwable -> L16
        monitor-exit(r1);
        if (r3 == false) goto L14;
        return;
    L14:
        this.e = (Long) this.a.invoke();
        this.c.invoke("interaction_component_show", a(r0, true));
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public e(int r4) {
        InteractionQuickReplyTracker$1 r5 = InteractionQuickReplyTracker$1.INSTANCE;
        com.larus.bmhome.chat.standarduikit.interaction.viewmodel.a r0 = com.larus.bmhome.chat.standarduikit.interaction.viewmodel.a.e;
        Function2<String, JSONObject, Unit> r1 = new com.larus.bmhome.chat.standarduikit.interaction.viewmodel.b();
        Intrinsics.checkNotNullParameter(r5, "elapsedRealtime");
        Intrinsics.checkNotNullParameter(r0, "resultStore");
        Intrinsics.checkNotNullParameter(r1, "reportEvent");
        this.a = r5;
        this.b = r0;
        this.c = r1;
    }

    public static com.larus.bmhome.chat.standarduikit.interaction.viewmodel.a.b e(b r4) {
        return new com.larus.bmhome.chat.standarduikit.interaction.viewmodel.a.b(r4.k, r4.j, r4.b, r4.a);
    }

    public static JSONObject a(b r3, boolean r4) {
        JSONObject r0 = new JSONObject();
        r0.put("block_id", r3.a);
        r0.put(MusicAppletPage.KEY_MESSAGE_ID, r3.b);
        r0.put("current_page", r3.e);
        r0.put("interaction_type", r3.c);
        x.a(r0, r3.h);
        r0.put("display_type", r3.f);
        r0.put("agent_type", r3.g);
        String r1 = r3.i;
        if (r1 == null) goto L5;
        r0.put("trigger_scene", r1);
    L5:
        if (r4 == true) goto L7;
    L9:
        return r0;
    L7:
        if (r3.c != QuickReplyInteractionType.QUICK_REPLY_INTERACTION_TYPE_AUTHORIZE_FOLDER.getValue()) goto L9;
        r0.put("folder_specified", r3.d ? 1 : 0);
        goto L9
    }

    public final void c(final b r15, final long r16, final String r18) {
        com.larus.bmhome.chat.standarduikit.interaction.viewmodel.a.b r8 = e(r15);
        com.larus.bmhome.chat.standarduikit.interaction.viewmodel.a.b r9 = null;
        if (Intrinsics.areEqual(r18, "closed") == false) goto L34;
        com.larus.bmhome.chat.standarduikit.interaction.viewmodel.a r12 = this.b;
        Function0<Unit> r13 = new c(this, r15, r16, r18);
        monitor-enter(r12);
        Intrinsics.checkNotNullParameter(r8, "key");     // Catch: Throwable -> L30
        Intrinsics.checkNotNullParameter(r13, "report");     // Catch: Throwable -> L30
        if (r12.b.contains(r8) == false) goto L11;
        monitor-exit(r12);
    L18:
        boolean r1 = true;
    L19:
        if (r1 == false) goto L21;
        return;
    L21:
        b r2 = this.d;
        if (r2 == null) goto L24;
        com.larus.bmhome.chat.standarduikit.interaction.viewmodel.a.b r3 = e(r2);
    L26:
        if (Intrinsics.areEqual(r3, r8) == true) goto L28;
    L36:
        b r4 = this.d;
        if (r4 == null) goto L40;
        r9 = e(r4);
    L40:
        if (Intrinsics.areEqual(r9, r8) == false) goto L42;
        this.f = true;
    L42:
        Function2<String, JSONObject, Unit> r5 = this.c;
        JSONObject r6 = a(r15, false);
        r6.put("result", r18);
        r6.put("duration", RangesKt.coerceAtLeast(((Number) this.a.invoke()).longValue() - r16, 0));
        Unit r0 = Unit.INSTANCE;
        r5.invoke("interaction_result", r6);
        return;
    L28:
        if (this.f == false) goto L36;
        return;
    L24:
        r3 = null;
        goto L26
    L11:
        if (r12.c.containsKey(r8) == true) goto L15;
        monitor-exit(r12);
        r1 = false;
        goto L19
    L15:
        if (r12.d.containsKey(r8) == true) goto L17;
        r12.d.put(r8, r13);     // Catch: Throwable -> L30
    L17:
        monitor-exit(r12);
    L30:
        th = move-exception;
        throw th;
    L34:
        if (this.b.a(r8) == true) goto L36;
    }
}
