package com.ss.android.lark.flow.threadwindow;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowThreadWindowMsgSender extends j4b.a {
    public static final /* synthetic */ int n = 0;
    public final a h;
    public final Handler i;
    public c j;
    public final List<c> k;
    public boolean l;
    public final p m;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/flow/threadwindow/FlowThreadWindowMsgSender$MsgType;", "", "<init>", "(Ljava/lang/String;I)V", "TEXT", "POST", "IMAGE", "FILE", "VIDEO", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final enum MsgType extends Enum<MsgType> {
        public static final MsgType FILE = null;
        public static final MsgType IMAGE = null;
        public static final MsgType POST = null;
        public static final MsgType TEXT = null;
        public static final MsgType VIDEO = null;
        public static final /* synthetic */ MsgType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<MsgType> getEntries() {
            return b;
        }

        static {
            MsgType r0 = new MsgType("TEXT", 0);
            TEXT = r0;
            MsgType r1 = new MsgType("POST", 1);
            POST = r1;
            MsgType r3 = new MsgType("IMAGE", 2);
            IMAGE = r3;
            MsgType r5 = new MsgType("FILE", 3);
            FILE = r5;
            MsgType r7 = new MsgType("VIDEO", 4);
            VIDEO = r7;
            MsgType[] r9 = {r0, r1, r3, r5, r7};
            a = r9;
            b = EnumEntriesKt.enumEntries(r9);
        }

        public static MsgType[] values() {
            return (MsgType[]) a.clone();
        }

        public static MsgType valueOf(String r1) {
            return (MsgType) r27.a.a(MsgType.class, r1);
        }

        public MsgType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
        void a();

        void b(String r1, Message r2);
    }

    public static final class b {
    }

    public static final class c {
        public final MsgType a;
        public final m5b.d b;

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
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            m5b.d r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "PendingItem(type=" + this.a + ", sendInfo=" + this.b + ')';
        }

        public final MsgType getType() {
            return this.a;
        }

        public c(MsgType r2, m5b.d r3) {
            Intrinsics.checkNotNullParameter(r2, "type");
            this.a = r2;
            this.b = r3;
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MsgType.values().length];
            r0[MsgType.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[MsgType.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[MsgType.IMAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[MsgType.FILE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[MsgType.VIDEO.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    static {
    }

    public final void g(m5b.d r4) {
        MsgType r0 = MsgType.TEXT;
        if (this.j != null) goto L5;
        this.j = new c(r0, r4);
    L7:
        if (this.l == true) goto L11;
        this.l = true;
        this.i.post(this.m);
        return;
    L11:
        return;
    L5:
        List<c> r1 = this.k;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new c(r0, r4));
        goto L7
    }

    public final void j(m5b.d r4) {
        MsgType r0 = MsgType.IMAGE;
        List<c> r1 = this.k;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new c(r0, r4));
        if (this.l == true) goto L7;
        this.l = true;
        this.i.post(this.m);
        return;
    }

    public final void l(m5b.d r4) {
        MsgType r0 = MsgType.POST;
        if (this.j != null) goto L5;
        this.j = new c(r0, r4);
    L7:
        if (this.l == true) goto L11;
        this.l = true;
        this.i.post(this.m);
        return;
    L11:
        return;
    L5:
        List<c> r1 = this.k;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new c(r0, r4));
        goto L7
    }

    public final void n(m5b.d r4) {
        MsgType r0 = MsgType.FILE;
        List<c> r1 = this.k;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new c(r0, r4));
        if (this.l == true) goto L7;
        this.l = true;
        this.i.post(this.m);
        return;
    }

    public final void p(m5b.d r4) {
        MsgType r0 = MsgType.VIDEO;
        List<c> r1 = this.k;
        ArrayList r2 = (ArrayList) r1;
        r2.add(new c(r0, r4));
        if (this.l == true) goto L7;
        this.l = true;
        this.i.post(this.m);
        return;
    }

    public final void y(c r3) {
        MsgType r0 = r3.getType();
        int r1 = d.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        super.g(r3.b);
        return;
    L5:
        if (r1 != 2) goto L7;
        super.l(r3.b);
        return;
    L7:
        if (r1 != 3) goto L9;
        super.j(r3.b);
        return;
    L9:
        if (r1 != 4) goto L11;
        super.n(r3.b);
        return;
    L11:
        if (r1 != 5) goto L14;
        super.p(r3.b);
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public final void z(final c r10, final long r11, boolean r13, final Function2<? super String, ? super Message, Unit> r14) {
        m5b.d r0 = r10.b;
        if (r0 == null) goto L7;
        m5b.e r1 = r0.e;
        if (r1 == null) goto L7;
        r1.d = Long.valueOf(r11);
        r1.e = Boolean.valueOf(r13);
    L7:
        m5b.d r15 = r10.b;
        String r2 = null;
        if (r15 == null) goto L12;
        m5b.e r16 = r15.e;
        if (r16 == null) goto L12;
        String r17 = r16.h;
    L13:
        final String r6 = q.a(r17);
        m5b.d r18 = r10.b;
        if (r18 == null) goto L18;
        m5b.e r19 = r18.e;
        if (r19 == null) goto L18;
        r2 = r19.i;
    L18:
        final String r7 = q.a(r2);
        s(new FlowThreadWindowMsgSender$sendRoot$rootListener$1(r11, r14, r10, r6, r7, this));
        y(r10);
        return;
    L12:
        r17 = null;
        goto L13
    }

    public FlowThreadWindowMsgSender(com.ss.android.lark.im.sdk.service.h r2, com.ss.android.lark.im.sdk.service.p r3, IChatService r4, FlowThreadWindowFragment$initComponents$4.AnonymousClass1 r5, FlowThreadWindowFragment$initComponents$4$1$messageSender$2.a r6) {
        Intrinsics.checkNotNullParameter(r2, "chatterService");
        Intrinsics.checkNotNullParameter(r3, "messageService");
        Intrinsics.checkNotNullParameter(r4, "legacyChatService");
        Intrinsics.checkNotNullParameter(r5, "listener");
        Intrinsics.checkNotNullParameter(r6, "callback");
        super(r2, r3, r4, r5);
        this.h = r6;
        this.i = new Handler(Looper.getMainLooper());
        this.k = new ArrayList();
        this.m = new p(this);
    }
}
