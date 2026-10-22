package com.ss.android.lark.keyboard.biz.p000float.inject;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import aya.f;
import com.bytedance.lark.pb.im.v1.DoubaoSmartReply;
import com.bytedance.lark.pb.im.v1.PushDoubaoSmartReply;
import com.bytedance.lark.pb.im.v1.SubscribeChatEventRequest;
import com.larksuite.framework.utils.UIUtils;
import com.larus.feishu.office.im.impl.smart_reply.FlowSmartReplyAIContainerView;
import com.ss.android.lark.biz.im.api.extension.chat_window.h;
import com.ss.android.lark.biz.im.api.g0;
import com.ss.android.lark.chat.entity.ComponentType;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.keyboard.base.inputinner.Direction;
import com.ss.android.lark.keyboard.base.inputinner.DirectionInParent;
import com.ss.android.lark.keyboard.base.inputinner.InputInnerVisibilityMode;
import com.ss.android.lark.keyboard.dependency.KeyboardAssemblerModule;
import com.ss.android.lark.keyboard.editor.inject.InputInnerController;
import com.ss.android.lark.keyboard.editor.input.n;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;
import com.ss.android.lark.keyboard.plugin.input.base.InputSupportType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import okio.ByteString;
import s5c.d;
import wnb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FloatExpandPlugin implements wnb.b<FloatExpandPlugin>, wnb.a {
    public static final a w = null;
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b a;
    public final Lazy b;
    public d c;
    public com.ss.android.lark.keyboard.b d;
    public wnb.c e;
    public View f;
    public View g;
    public Drawable h;
    public Boolean i;
    public Boolean j;
    public boolean k;
    public com.ss.android.lark.keyboard.ime.c l;
    public final String m;
    public boolean n;
    public final CoroutineScope o;
    public wnb.d p;
    public final Set<g0> q;
    public final Lazy r;
    public final Lazy s;
    public final c t;
    public final FloatExpandPlugin$floatExpandActionHandler$1 u;
    public f v;

    public static final class Store {
        public static final ConcurrentHashMap<String, ConcurrentHashMap<a, c>> a = null;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/keyboard/biz/float/inject/FloatExpandPlugin$Store$ConsumeDecision;", "", "<init>", "(Ljava/lang/String;I)V", "CONSUMED_NEW_REPLY", "CONSUMED_NEW_STATUS", "DROPPED_OLD_REPLY", "DROPPED_OLD_STATUS", "DROPPED_MISSING_KEY", "keyboard-assembler_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
        public static final enum ConsumeDecision extends Enum<ConsumeDecision> {
            public static final ConsumeDecision CONSUMED_NEW_REPLY = null;
            public static final ConsumeDecision CONSUMED_NEW_STATUS = null;
            public static final ConsumeDecision DROPPED_MISSING_KEY = null;
            public static final ConsumeDecision DROPPED_OLD_REPLY = null;
            public static final ConsumeDecision DROPPED_OLD_STATUS = null;
            public static final /* synthetic */ ConsumeDecision[] a = null;
            public static final /* synthetic */ EnumEntries b = null;

            public static EnumEntries<ConsumeDecision> getEntries() {
                return b;
            }

            static {
                ConsumeDecision r0 = new ConsumeDecision("CONSUMED_NEW_REPLY", 0);
                CONSUMED_NEW_REPLY = r0;
                ConsumeDecision r1 = new ConsumeDecision("CONSUMED_NEW_STATUS", 1);
                CONSUMED_NEW_STATUS = r1;
                ConsumeDecision r3 = new ConsumeDecision("DROPPED_OLD_REPLY", 2);
                DROPPED_OLD_REPLY = r3;
                ConsumeDecision r5 = new ConsumeDecision("DROPPED_OLD_STATUS", 3);
                DROPPED_OLD_STATUS = r5;
                ConsumeDecision r7 = new ConsumeDecision("DROPPED_MISSING_KEY", 4);
                DROPPED_MISSING_KEY = r7;
                ConsumeDecision[] r9 = {r0, r1, r3, r5, r7};
                a = r9;
                b = EnumEntriesKt.enumEntries(r9);
            }

            public static ConsumeDecision[] values() {
                return (ConsumeDecision[]) a.clone();
            }

            public static ConsumeDecision valueOf(String r1) {
                return (ConsumeDecision) r27.a.a(ConsumeDecision.class, r1);
            }

            public ConsumeDecision(String r1, int r2) {
                super(r1, r2);
            }
        }

        public interface a {

            /* JADX INFO: renamed from: com.ss.android.lark.keyboard.biz.float.inject.FloatExpandPlugin$Store$a$a, reason: collision with other inner class name */
            public static final class C0126a implements a {
                public static final C0126a a = null;

                static {
                    a = new C0126a();
                }

                public C0126a() {
                }

                public final boolean equals(Object r3) {
                    if (this != r3) goto L6;
                    return true;
                L6:
                    if ((r3 instanceof C0126a) == true) goto L9;
                    return false;
                L9:
                    C0126a r4 = (C0126a) r3;
                    return true;
                }

                public final int hashCode() {
                    return 1765276716;
                }

                public final String toString() {
                    return "Chat";
                }
            }

            public static final class b implements a {
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
                    return "Thread(threadId=" + this.a + ')';
                }

                public b(String r2) {
                    Intrinsics.checkNotNullParameter(r2, "threadId");
                    this.a = r2;
                }
            }
        }

        public static final class b {
            public final ConsumeDecision a;
            public final a b;
            public final Long c;
            public final Long d;
            public final c e;
            public final c f;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof b) == true) goto L8;
                return false;
            L8:
                b r6 = (b) r5;
                if (this.a == r6.a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
                return false;
            L21:
                if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
                return false;
            L24:
                if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
                return false;
            L26:
                return true;
            }

            public final int hashCode() {
                int r0 = this.a.hashCode() * 31;
                a r1 = this.b;
                int r2 = 0;
                if (r1 != null) goto L5;
                int r3 = 0;
            L6:
                int r4 = (r0 + r3) * 31;
                Long r5 = this.c;
                if (r5 != null) goto L9;
                int r6 = 0;
            L10:
                int r7 = (r4 + r6) * 31;
                Long r8 = this.d;
                if (r8 != null) goto L13;
                int r9 = 0;
            L14:
                int r10 = (r7 + r9) * 31;
                c r11 = this.e;
                if (r11 != null) goto L17;
                int r12 = 0;
            L18:
                int r13 = (r10 + r12) * 31;
                c r14 = this.f;
                if (r14 == null) goto L23;
                r2 = r14.hashCode();
            L23:
                return r13 + r2;
            L17:
                r12 = r11.hashCode();
                goto L18
            L13:
                r9 = r8.hashCode();
                goto L14
            L9:
                r6 = r5.hashCode();
                goto L10
            L5:
                r3 = r1.hashCode();
                goto L6
            }

            public final String toString() {
                return "ConsumeResult(decision=" + this.a + ", belong=" + this.b + ", replyCreateTimeMs=" + this.c + ", updateTimeMs=" + this.d + ", prev=" + this.e + ", next=" + this.f + ')';
            }

            public b(ConsumeDecision r2, a r3, Long r4, Long r5, c r6, c r7) {
                Intrinsics.checkNotNullParameter(r2, "decision");
                this.a = r2;
                this.b = r3;
                this.c = r4;
                this.d = r5;
                this.e = r6;
                this.f = r7;
            }
        }

        public static final class c {
            public long a;
            public long b;
            public DoubaoSmartReply.TaskStatus c;
            public ByteString d;
            public Long e;

            public c() {
                this(0);
            }

            public final boolean equals(Object r8) {
                if (this != r8) goto L6;
                return true;
            L6:
                if ((r8 instanceof c) == true) goto L8;
                return false;
            L8:
                c r9 = (c) r8;
                if (this.a == r9.a) goto L12;
                return false;
            L12:
                if (this.b == r9.b) goto L15;
                return false;
            L15:
                if (this.c == r9.c) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
                return false;
            L21:
                if (Intrinsics.areEqual(this.e, r9.e) == true) goto L23;
                return false;
            L23:
                return true;
            }

            public final int hashCode() {
                long r0 = this.a;
                int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
                long r3 = this.b;
                int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
                DoubaoSmartReply.TaskStatus r4 = this.c;
                int r5 = 0;
                if (r4 != null) goto L5;
                int r6 = 0;
            L6:
                int r7 = (r2 + r6) * 31;
                ByteString r8 = this.d;
                if (r8 != null) goto L9;
                int r9 = 0;
            L10:
                int r10 = (r7 + r9) * 31;
                Long r11 = this.e;
                if (r11 == null) goto L15;
                r5 = r11.hashCode();
            L15:
                return r10 + r5;
            L9:
                r9 = r8.hashCode();
                goto L10
            L5:
                r6 = r4.hashCode();
                goto L6
            }

            public final String toString() {
                return "Latest(replyCreateTimeMs=" + this.a + ", updateTimeMs=" + this.b + ", status=" + this.c + ", content=" + this.d + ", replyLarkMsgId=" + this.e + ')';
            }

            public /* synthetic */ c(int r9) {
                this(Long.MIN_VALUE, Long.MIN_VALUE, null, null, null);
            }

            public static c a(c r8) {
                return new c(r8.a, r8.b, r8.c, r8.d, r8.e);
            }

            public c(long r1, long r3, DoubaoSmartReply.TaskStatus r5, ByteString r6, Long r7) {
                this.a = r1;
                this.b = r3;
                this.c = r5;
                this.d = r6;
                this.e = r7;
            }
        }

        static {
            a = new ConcurrentHashMap();
        }

        public static a a(com.ss.android.lark.biz.im.api.extension.chat_window.b r5) {
            Intrinsics.checkNotNullParameter(r5, "context");
            h r6 = r5.e;
            boolean r1 = false;
            if (r6 == null) goto L12;
            ComponentType r3 = r6.a;
            if (r3 == null) goto L12;
            ComponentType.Companion.getClass();
            Intrinsics.checkNotNullParameter(r3, "<this>");
            if (r3 != ComponentType.CHAT) goto L9;
            boolean r4 = true;
        L10:
            if (r4 != true) goto L12;
            boolean r7 = true;
        L13:
            if (r7 == true) goto L31;
            if (r6 == null) goto L24;
            ComponentType r8 = r6.a;
            if (r8 == null) goto L24;
            ComponentType.Companion.getClass();
            Intrinsics.checkNotNullParameter(r8, "<this>");
            if (r8 != ComponentType.REPLY_IN_THREAD) goto L21;
            boolean r0 = true;
        L22:
            if (r0 != true) goto L24;
            r1 = true;
            goto L24
        L21:
            r0 = false;
        L24:
            if (r1 == false) goto L29;
            String r9 = r6.b;
            if (r9 != null) goto L32;
            r9 = "";
        L32:
            return new a.b(r9);
        L29:
            return null;
        L31:
            return a.C0126a.a;
        L9:
            r4 = false;
        L12:
            r7 = false;
            goto L13
        }
    }

    public static final class a implements wnb.b.a<FloatExpandPlugin> {
        public a() {
        }
    }

    public static final class b implements n {
        public final String a;
        public final d b;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.ss.android.lark.keyboard.editor.input.n
        public final com.ss.android.lark.keyboard.biz.p000float.inject.a a(KeyboardFunctionEditText r4) {
            Intrinsics.checkNotNullParameter(r4, "editor");
            Editable r5 = r4.getEditableText();
            int r0 = r5.getSpanStart(this);
            int r1 = r5.getSpanEnd(this);
            boolean r2 = true;
            if (r0 == 0) goto L5;
        L8:
            if (r2 == false) goto L10;
            s5c.a r6 = z5c.f.c;
        L12:
            return new com.ss.android.lark.keyboard.biz.p000float.inject.a(this, r6);
        L10:
            r6 = z5c.f.d;
            goto L12
        L5:
            if (r1 != r5.length()) goto L8;
            r2 = true ^ Intrinsics.areEqual(r5.toString(), this.a);
            goto L8
        }

        public b(String r2, d r3) {
            Intrinsics.checkNotNullParameter(r2, "originText");
            Intrinsics.checkNotNullParameter(r3, "extraParam");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c extends aqb.a {
        public final /* synthetic */ FloatExpandPlugin a;

        public c(FloatExpandPlugin r1) {
            this.a = r1;
        }

        @Override // aqb.a
        public final void d(PushDoubaoSmartReply r18) {
            Intrinsics.checkNotNullParameter(r18, "push");
            DoubaoSmartReply r1 = r18.doubao_smart_reply;
            if (r1 != null) goto L5;
            return;
        L5:
            Long r3 = r1.chat_id;
            Long r4 = null;
            if (r3 == null) goto L8;
            String r5 = r3.toString();
        L9:
            String r6 = "";
            if (r5 != null) goto L12;
            r5 = "";
        L12:
            StringBuilder r7 = new StringBuilder("onPushDoubaoSmartReply: registerKey=");
            r7.append(this.a.m);
            r7.append(" pushChatId=");
            r7.append(r5);
            r7.append(" currentChatId=");
            r7.append(this.a.j());
            r7.append(" threadId=");
            Long r8 = r1.reply_lark_thread_id;
            if (r8 == null) goto L15;
            String r9 = r8.toString();
        L16:
            if (r9 == null) goto L19;
            r6 = r9;
        L19:
            r7.append(r6);
            r7.append(" replyMsgId=");
            Long r10 = r1.reply_lark_msg_id;
            if (r10 == null) goto L22;
            long r11 = r10.longValue();
        L23:
            r7.append(r11);
            r7.append(" replyCreateMs=");
            Long r12 = r1.reply_lark_msg_create_time_ms;
            long r13 = -1;
            if (r12 == null) goto L26;
            long r14 = r12.longValue();
        L27:
            r7.append(r14);
            r7.append(" updateMs=");
            Long r15 = r1.update_time_ms;
            if (r15 == null) goto L30;
            r13 = r15.longValue();
        L30:
            r7.append(r13);
            r7.append(" status=");
            r7.append(r1.status);
            r7.append(" contentSize=");
            r7.append(r1.content.size());
            Log.i("FloatExpandPlugin", r7.toString());
            if (Intrinsics.areEqual(r5, this.a.j()) == true) goto L34;
            Log.w("FloatExpandPlugin", "drop smartReply push by chatId mismatch: pushChatId=" + r5 + ", currentChatId=" + this.a.j());
            return;
        L34:
            ConcurrentHashMap<String, ConcurrentHashMap<Store.a, Store.c>> r16 = Store.a;
            com.ss.android.lark.biz.im.api.extension.chat_window.b r17 = this.a.a;
            Intrinsics.checkNotNullParameter(r1, "push");
            Intrinsics.checkNotNullParameter(r17, "keyboardPluginContext");
            Long r2 = r1.chat_id;
            if (r2 == null) goto L37;
            String r19 = r2.toString();
        L38:
            Long r110 = r1.reply_lark_msg_create_time_ms;
            Long r111 = r1.update_time_ms;
            boolean r20 = true;
            if (r19 != null) goto L41;
        L44:
            boolean r21 = true;
        L45:
            if (r21 == true) goto L89;
            if (r110 == null) goto L89;
            if (r111 == null) goto L89;
            Store.a r112 = Store.a(r17);
            if (r112 != null) goto L52;
            Log.e("FloatExpandPlugin", "consumeDetail: belong is null");
            Store.b r22 = new Store.b(Store.ConsumeDecision.DROPPED_MISSING_KEY, null, r110, r111, null, null);
        L90:
            Store.ConsumeDecision r23 = r22.a;
            if (r23 == Store.ConsumeDecision.CONSUMED_NEW_REPLY) goto L97;
            if (r23 == Store.ConsumeDecision.CONSUMED_NEW_STATUS) goto L97;
            r20 = false;
        L97:
            if (r20 == true) goto L107;
            StringBuilder r24 = new StringBuilder("drop smartReply push: decision=");
            r24.append(r22.a);
            r24.append(" belong=");
            r24.append(r22.b);
            r24.append(" push(replyCreate=");
            r24.append(r22.c);
            r24.append(", update=");
            r24.append(r22.d);
            r24.append(") latest(prevReply=");
            Store.c r25 = r22.e;
            if (r25 == null) goto L101;
            Long r26 = Long.valueOf(r25.a);
        L102:
            r24.append(r26);
            r24.append(", prevUpdate=");
            Store.c r27 = r22.e;
            if (r27 == null) goto L105;
            r4 = Long.valueOf(r27.b);
        L105:
            r24.append(r4);
            r24.append(')');
            Log.w("FloatExpandPlugin", r24.toString());
            return;
        L101:
            r26 = null;
            goto L102
        L107:
            StringBuilder r28 = new StringBuilder("consume smartReply push: decision=");
            r28.append(r22.a);
            r28.append(" belong=");
            r28.append(r22.b);
            r28.append(" latest(nextReply=");
            Store.c r29 = r22.f;
            if (r29 == null) goto L110;
            Long r30 = Long.valueOf(r29.a);
        L111:
            r28.append(r30);
            r28.append(", nextUpdate=");
            Store.c r31 = r22.f;
            if (r31 == null) goto L114;
            Long r32 = Long.valueOf(r31.b);
        L115:
            r28.append(r32);
            r28.append(", status=");
            Store.c r33 = r22.f;
            if (r33 == null) goto L118;
            r4 = r33.c;
        L118:
            r28.append(r4);
            r28.append(", contentSize=");
            Store.c r34 = r22.f;
            if (r34 == null) goto L123;
            ByteString r35 = r34.d;
            if (r35 == null) goto L123;
            int r113 = r35.size();
        L124:
            r28.append(r113);
            r28.append(')');
            Log.i("FloatExpandPlugin", r28.toString());
            this.a.n();
            return;
        L123:
            r113 = 0;
            goto L124
        L114:
            r32 = null;
            goto L115
        L110:
            r30 = null;
            goto L111
        L52:
            int r36 = 0;
            if ((r112 instanceof Store.a.b) == false) goto L55;
            String r37 = ((Store.a.b) r112).a;
        L56:
            Long r114 = r1.reply_lark_thread_id;
            if (r37 == null) goto L59;
            boolean r115 = Intrinsics.areEqual(r114, StringsKt.toLongOrNull(r37));
        L65:
            if (r115 == true) goto L67;
            Log.w("FloatExpandPlugin", "drop smartReply push: threadId mismatch, currentThreadId=" + r37 + ", pushThreadId=" + r114);
            r22 = new Store.b(Store.ConsumeDecision.DROPPED_MISSING_KEY, r112, r110, r111, null, null);
            goto L90
        L67:
            ConcurrentHashMap<String, ConcurrentHashMap<Store.a, Store.c>> r38 = Store.a;
            ConcurrentHashMap<Store.a, Store.c> r39 = r38.get(r19);
            if (r39 != null) goto L73;
            r39 = new ConcurrentHashMap();
            ConcurrentHashMap<Store.a, Store.c> r40 = r38.putIfAbsent(r19, r39);
            if (r40 == null) goto L73;
            r39 = r40;
        L73:
            ConcurrentHashMap<Store.a, Store.c> r41 = r39;
            Intrinsics.checkNotNull(r41);
            Store.c r42 = r41.get(r112);
            if (r42 != null) goto L79;
            r42 = new Store.c(r36);
            Store.c r43 = r41.putIfAbsent(r112, r42);
            if (r43 == null) goto L79;
            r42 = r43;
        L79:
            Store.c r44 = r42;
            Store.c r45 = Store.c.a(r44);
            if (r110.longValue() >= r44.a) goto L83;
            r22 = new Store.b(Store.ConsumeDecision.DROPPED_OLD_REPLY, r112, r110, r111, r45, r45);
            goto L90
        L83:
            if (r110.longValue() <= r44.a) goto L86;
            r44.a = r110.longValue();
            r44.b = r111.longValue();
            r44.c = r1.status;
            r44.d = r1.content;
            r44.e = r1.reply_lark_msg_id;
            r22 = new Store.b(Store.ConsumeDecision.CONSUMED_NEW_REPLY, r112, r110, r111, r45, Store.c.a(r44));
            goto L90
        L86:
            if (r111.longValue() >= r44.b) goto L88;
            r22 = new Store.b(Store.ConsumeDecision.DROPPED_OLD_STATUS, r112, r110, r111, r45, r45);
            goto L90
        L88:
            r44.b = r111.longValue();
            r44.c = r1.status;
            r44.d = r1.content;
            r44.e = r1.reply_lark_msg_id;
            r22 = new Store.b(Store.ConsumeDecision.CONSUMED_NEW_STATUS, r112, r110, r111, r45, Store.c.a(r44));
            goto L90
        L59:
            if (r114 != null) goto L61;
        L64:
            r115 = true;
            goto L65
        L61:
            if (r114.longValue() == 0) goto L64;
            r115 = false;
            goto L65
        L55:
            r37 = null;
        L89:
            r22 = new Store.b(Store.ConsumeDecision.DROPPED_MISSING_KEY, null, r110, r111, null, null);
            goto L90
        L41:
            if (r19.length() == 0) goto L44;
            r21 = false;
            goto L45
        L37:
            r19 = null;
            goto L38
        L26:
            r14 = -1;
            goto L27
        L22:
            r11 = 0;
            goto L23
        L15:
            r9 = null;
            goto L16
        L8:
            r5 = null;
            goto L9
        }
    }

    static {
        w = new a();
    }

    @Override // wnb.b
    public final boolean i() {
        return false;
    }

    @Override // wnb.b
    public final View a() {
        Log.i("FloatExpandPlugin", "getPluginView: registerKey=" + this.m + " chatId=" + j());
        aya.c r0 = (aya.c) this.r.getValue();
        if (r0 == null) goto L5;
        r0.a(this.u);
    L5:
        aya.c r1 = (aya.c) this.r.getValue();
        if (r1 == null) goto L8;
        FlowSmartReplyAIContainerView r2 = r1.b();
    L10:
        if ((r2 instanceof View) == true) goto L13;
        r2 = null;
    L13:
        if (r2 != null) goto L15;
        r2 = new FrameLayout(this.a.a.requireContext());
        r2.setLayoutParams(new ViewGroup.LayoutParams(-1, UIHelper.dp2px(50.0f)));
        TextView r4 = new TextView(this.a.a.requireContext());
        r4.setTextSize(16.0f);
        r4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r2.addView(r4);
    L15:
        this.f = r2;
        if (this.l != null) goto L20;
        com.ss.android.lark.keyboard.ime.c r3 = k().z().v(this);
        this.l = r3;
        r3.f(new FloatExpandPlugin$registerImePanelVisibilityListener$1(this));
        r3.c(new FloatExpandPlugin$registerImePanelVisibilityListener$2(this));
        r3.a(new FloatExpandPlugin$registerImePanelVisibilityListener$3(this));
        r3.d(new FloatExpandPlugin$registerImePanelVisibilityListener$4(this));
    L20:
        if (this.n == true) goto L23;
        Log.i("FloatExpandPlugin", "ensureSubscribed: registerKey=" + this.m + " chatId=" + j());
        KeyboardAssemblerModule.a().registerPushChatRelation(this.m, j(), SubscribeChatEventRequest.SubscriptionKey.DOUBAO_SMART_REPLY, this.t);
        this.n = true;
        n();
    L23:
        k().e().of(this).d(InputSupportType.class, new FloatExpandPlugin$notifyInputChange$1(this));
        View r5 = this.f;
        if (r5 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        return null;
    L27:
        return r5;
    L8:
        r2 = null;
        goto L10
    }

    @Override // wnb.b
    public final e b() {
        return new e(0, 0, 0, 0);
    }

    @Override // wnb.b
    public final wnb.c h() {
        wnb.c r0 = this.e;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
        return null;
    }

    public final String j() {
        String r0 = this.a.c.getId();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final com.ss.android.lark.keyboard.b k() {
        com.ss.android.lark.keyboard.b r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("keyboard");
        return null;
    }

    public final void n() {
        if (this.f != null) goto L5;
        return;
    L5:
        ConcurrentHashMap<String, ConcurrentHashMap<Store.a, Store.c>> r0 = Store.a;
        Store.a r1 = Store.a(this.a);
        if (r1 != null) goto L8;
        return;
    L8:
        String r2 = j();
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r1, "belong");
        ConcurrentHashMap<Store.a, Store.c> r3 = Store.a.get(r2);
        Long r4 = null;
        if (r3 == null) goto L11;
        Store.c r5 = r3.get(r1);
    L12:
        if (r5 == null) goto L14;
        DoubaoSmartReply.TaskStatus r6 = r5.c;
    L15:
        boolean r7 = true;
        int r8 = 0;
        if (r6 != DoubaoSmartReply.TaskStatus.OPEN) goto L18;
        boolean r9 = true;
    L19:
        this.k = r9;
        StringBuilder r10 = new StringBuilder("renderFromStore: chatId=");
        r10.append(j());
        r10.append(" belong=");
        r10.append(r1);
        r10.append(" latest(replyCreate=");
        if (r5 == null) goto L22;
        Long r11 = Long.valueOf(r5.a);
    L23:
        r10.append(r11);
        r10.append(", update=");
        if (r5 == null) goto L26;
        Long r12 = Long.valueOf(r5.b);
    L27:
        r10.append(r12);
        r10.append(", status=");
        if (r5 == null) goto L30;
        DoubaoSmartReply.TaskStatus r13 = r5.c;
    L31:
        r10.append(r13);
        r10.append(", contentSize=");
        if (r5 == null) goto L36;
        ByteString r14 = r5.d;
        if (r14 == null) goto L36;
        int r15 = r14.size();
    L37:
        r10.append(r15);
        r10.append(") visible=");
        r10.append(r9);
        Log.i("FloatExpandPlugin", r10.toString());
        if (r9 == true) goto L40;
    L42:
        r7 = false;
    L43:
        View r16 = this.f;
        if (r16 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        r16 = null;
    L46:
        if (r7 == true) goto L49;
        r8 = 8;
    L49:
        r16.setVisibility(r8);
        o(r7);
        if (r5 == null) goto L52;
        ByteString r17 = r5.d;
    L53:
        if (r5 == null) goto L55;
        r4 = r5.e;
    L55:
        if (r17 == null) goto L63;
        if (r4 == null) goto L63;
        Log.i("FloatExpandPlugin", "renderFromStore: chatId=" + j() + " belong=" + r1 + " floatExpandContent=" + r17 + " replyMsgId=" + r4);
        aya.c r18 = (aya.c) this.r.getValue();
        if (r18 == null) goto L61;
        r18.c(new aya.b(r17, r4.longValue(), j()));
    L61:
        m(r7);
        return;
    L63:
        Log.e("FloatExpandPlugin", "renderFromStore: floatExpandContent or replyMsgId is null");
        m(r7);
        return;
    L52:
        r17 = null;
        goto L53
    L40:
        if (l() == true) goto L42;
    L36:
        r15 = 0;
        goto L37
    L30:
        r13 = null;
        goto L31
    L26:
        r12 = null;
        goto L27
    L22:
        r11 = null;
        goto L23
    L18:
        r9 = false;
        goto L19
    L14:
        r6 = null;
        goto L15
    L11:
        r5 = null;
        goto L12
    }

    @Override // wnb.b
    public final void onDestroy() {
        Log.i("FloatExpandPlugin", "onDestroy: registerKey=" + this.m + " chatId=" + j());
        View r0 = this.f;
        if (r0 == null) goto L5;
        r0.setOnClickListener(null);
    L5:
        m(false);
        this.v = null;
        com.ss.android.lark.keyboard.ime.c r4 = this.l;
        if (r4 == null) goto L8;
        r4.clear();
    L8:
        this.l = null;
        o(false);
        Iterator r5 = CollectionsKt.toList(this.q).iterator();
    L10:
        if (r5.hasNext() == false) goto L16;
        g0 r6 = (g0) r5.next();
        wnb.d r7 = this.p;
        if (r7 == null) goto L10;
        q4b.a r8 = r7.h;
        if (r8 == null) goto L10;
        r8.c(r6);
        goto L10
    L16:
        this.q.clear();
        if (this.n == false) goto L20;
        Log.i("FloatExpandPlugin", "unsubscribe: registerKey=" + this.m + " chatId=" + j());
        KeyboardAssemblerModule.a().unregisterPushChatRelation(this.m, j(), SubscribeChatEventRequest.SubscriptionKey.DOUBAO_SMART_REPLY);
        this.n = false;
    L20:
        CoroutineScopeKt.cancel$default(this.o, null, 1, null);
        aya.c r1 = (aya.c) this.r.getValue();
        if (r1 == null) goto L31;
        r1.onDestroy();
        return;
    }

    public final boolean l() {
        com.ss.android.lark.keyboard.ime.a r0 = k().z();
        if (r0.getImeState().b().isEnterOrShow() == false) goto L5;
    L8:
        return true;
    L5:
        if (r0.getPanelState().b().isEnterOrShow() == true) goto L8;
        return false;
    }

    @Override // wnb.b
    public final DirectionInParent c() {
        return DirectionInParent.TOP;
    }

    @Override // wnb.b
    public final InputInnerVisibilityMode d() {
        return InputInnerVisibilityMode.DYNAMIC;
    }

    @Override // wnb.b
    public final Direction getDirection() {
        return Direction.TopMiddle;
    }

    @Override // wnb.b
    public final wnb.b.a<FloatExpandPlugin> getKey() {
        return w;
    }

    /* JADX WARN: Type inference failed for: r2v16, types: [com.ss.android.lark.keyboard.biz.float.inject.FloatExpandPlugin$floatExpandActionHandler$1] */
    public FloatExpandPlugin(com.ss.android.lark.biz.im.api.extension.chat_window.b r2) {
        Intrinsics.checkNotNullParameter(r2, "keyboardPluginContext");
        this.a = r2;
        this.b = LazyKt.lazy(FloatExpandPlugin$model$2.INSTANCE);
        this.m = String.valueOf(hashCode());
        this.o = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.q = Collections.synchronizedSet(new LinkedHashSet());
        this.r = LazyKt.lazy(new FloatExpandPlugin$floatExpandExtension$2(this));
        this.s = LazyKt.lazy(new FloatExpandPlugin$attachmentExtension$2(this));
        this.t = new c(this);
        this.u = new FloatExpandPlugin$floatExpandActionHandler$1(this);
    }

    public static final void g(FloatExpandPlugin r6) {
        if (r6.f == null) goto L30;
        boolean r1 = true;
        int r2 = 0;
        if (r6.k == true) goto L8;
    L10:
        boolean r0 = false;
    L11:
        View r3 = r6.f;
        View r4 = null;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("view");
        r3 = null;
    L15:
        if (r3.getVisibility() == 0) goto L18;
        r1 = false;
    L18:
        if (r1 != r0) goto L20;
        r6.o(r0);
        return;
    L20:
        View r5 = r6.f;
        if (r5 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L24:
        if (r0 == true) goto L27;
        r2 = 8;
    L27:
        r4.setVisibility(r2);
        r6.o(r0);
        r6.m(r0);
        return;
    L23:
        r4 = r5;
        goto L24
    L8:
        if (r6.l() == true) goto L10;
        r0 = true;
        goto L11
    }

    @Override // wnb.b
    public final void e(InputInnerController r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.e = r2;
    }

    @Override // wnb.a
    public final void f(wnb.d r2) {
        Intrinsics.checkNotNullParameter(r2, "env");
        this.p = r2;
    }

    public final void m(boolean r3) {
        if (Intrinsics.areEqual(this.j, Boolean.valueOf(r3)) == false) goto L5;
        return;
    L5:
        this.j = Boolean.valueOf(r3);
        f r0 = this.v;
        if (r0 == null) goto L9;
        r0.l(r3);
        return;
    }

    public final void o(boolean r9) {
        if (Intrinsics.areEqual(this.i, Boolean.valueOf(r9)) == false) goto L5;
        return;
    L5:
        this.i = Boolean.valueOf(r9);
        View r0 = this.g;
        View r1 = r0;
        if (r0 == null) goto L9;
    L12:
        if (r1 != null) goto L14;
        return;
    L14:
        if (r9 == false) goto L19;
        Drawable r10 = this.h;
        Drawable r11 = r10;
        if (r10 != null) goto L18;
        GradientDrawable r12 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{UIUtils.getColor(this.a.a.requireContext(), 2131102026), UIUtils.getColor(this.a.a.requireContext(), 2131102022), UIUtils.getColor(this.a.a.requireContext(), 2131102022)});
        float r2 = UIHelper.dp2px(28.0f);
        r12.setCornerRadii(new float[]{r2, r2, r2, r2, 0.0f, 0.0f, 0.0f, 0.0f});
        this.h = r12;
        r11 = r12;
    L18:
        r1.setBackground(r11);
        return;
    L19:
        r1.setBackground(null);
        return;
    L9:
        if (this.f != null) goto L11;
        r1 = null;
        goto L12
    L11:
        View r3 = k().v().e().c.findViewById(2131372950);
        this.g = r3;
        r1 = r3;
        goto L12
    }

    @Override // wnb.b
    public final void setKeyboard(com.ss.android.lark.keyboard.b r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }
}
