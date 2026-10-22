package com.ss.android.lark.chat.base.view.vo;

import com.bytedance.lark.pb.basic.v1.MessageLink;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageDLPState;
import com.ss.android.lark.chat.entity.message.MessageEditInfo;
import com.ss.android.lark.chat.entity.message.MessageFoldDetail;
import com.ss.android.lark.chat.entity.message.MessageSecurityESCReviewExtra;
import com.ss.android.lark.chat.entity.message.MessageStreamStatus;
import com.ss.android.lark.chat.entity.message.SendStatus;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.Intrinsics;
import r5b.e;
import u2b.f;
import u2b.g;
import u2b.i;
import u2b.k;
import u2b.l;
import u2b.m;
import u2b.n;
import u2b.p;
import u2b.q;
import u2b.r;
import u2b.s;
import v5b.a;
import v5b.d;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ThreadMessageVO<T extends v5b.a<?>> extends y6b.a<T> implements b<ThreadMessageVO<?>>, d<T> {
    public static final a d = null;
    public static final r e = null;
    public static final m f = null;
    public static final i g = null;
    public static final p h = null;
    public static final k i = null;
    public static final f j = null;
    public static final g k = null;
    public static final u2b.a l = null;
    public static final l m = null;
    public static final s n = null;
    public static final n o = null;
    public static final q p = null;
    public HashMap<Integer, String> c;

    @Target({ElementType.TYPE, ElementType.TYPE_USE})
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0081\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/ss/android/lark/chat/base/view/vo/ThreadMessageVO$AtType;", BuildConfig.FLAVOR, "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface AtType {
        public static final int AT_ALL = 1;
        public static final int AT_ME = 0;
        public static final a Companion = null;

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/ss/android/lark/chat/base/view/vo/ThreadMessageVO$ItemType;", BuildConfig.FLAVOR, "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ItemType {
    }

    public static final class a {
        public a() {
        }

        public static final void a(a r1, Map r2, y6b.d r3) {
            r1.getClass();
            HashMap r4 = (HashMap) r2;
            List r5 = (List) r4.get(r3.a());
            if (r5 != null) goto L5;
            r5 = new ArrayList();
            r4.put(r3.a(), r5);
        L5:
            r5.add(r3);
        }
    }

    @Override // y6b.a
    public final int A() {
        return 0;
    }

    @Override // y6b.a
    public final List<ReactionInfo> B() {
        return null;
    }

    @Override // y6b.a
    public final int C() {
        return 1;
    }

    @Override // y6b.a
    public final y6b.b D() {
        return null;
    }

    @Override // y6b.a
    public final Message.RecallerIdentity E() {
        return null;
    }

    @Override // y6b.a
    public final String F() {
        return BuildConfig.FLAVOR;
    }

    @Override // y6b.a
    public final SendStatus G() {
        return null;
    }

    @Override // y6b.a
    public final boolean H() {
        return false;
    }

    @Override // y6b.a
    public final String I() {
        return null;
    }

    @Override // y6b.a
    public final Message.SourceType J() {
        return null;
    }

    @Override // y6b.a
    public final Message.Status K() {
        return null;
    }

    @Override // y6b.a
    public final MessageStreamStatus L() {
        return null;
    }

    @Override // y6b.a
    public final String M() {
        return null;
    }

    @Override // y6b.a
    public final ValidateIMFileResult N() {
        return null;
    }

    @Override // y6b.a
    public final boolean O() {
        return false;
    }

    @Override // y6b.a
    public final boolean P() {
        return false;
    }

    @Override // y6b.a
    public final boolean R() {
        return false;
    }

    @Override // y6b.a
    public final boolean S() {
        return false;
    }

    @Override // y6b.a
    public final boolean U() {
        return false;
    }

    @Override // y6b.a
    public final boolean V(long r1) {
        return false;
    }

    @Override // v5b.c
    public final y6b.b a() {
        return null;
    }

    @Override // v5b.c
    public final T b() {
        Intrinsics.checkNotNull(null);
        return null;
    }

    @Override // v5b.c
    public final boolean c() {
        return false;
    }

    @Override // v5b.c
    public final boolean d() {
        return false;
    }

    @Override // v5b.c
    public final boolean e() {
        return false;
    }

    @Override // v5b.c
    public final String g() {
        return null;
    }

    @Override // v5b.c
    public final String getChatId() {
        return null;
    }

    @Override // v5b.c
    public final long getCreateTime() {
        return 0;
    }

    @Override // v5b.c
    public final int getGroupType() {
        return 0;
    }

    @Override // v5b.c
    public final String getId() {
        return null;
    }

    @Override // y6b.a, v5b.c, v5b.d
    public Message.Type getType() {
        return null;
    }

    @Override // v5b.c
    public final String getcId() {
        return null;
    }

    @Override // v5b.c
    public final boolean h() {
        return false;
    }

    @Override // v5b.c
    public final String i() {
        return BuildConfig.FLAVOR;
    }

    @Override // v5b.c
    public final boolean m() {
        return false;
    }

    @Override // v5b.c
    public final boolean na() {
        return false;
    }

    @Override // y6b.a
    public final long o() {
        return 0;
    }

    @Override // y6b.a
    public final int q() {
        return 0;
    }

    @Override // y6b.a
    public final int r() {
        return 0;
    }

    @Override // y6b.a
    public final MessageDLPState t() {
        return null;
    }

    @Override // y6b.a
    public final MessageEditInfo u() {
        return null;
    }

    @Override // y6b.a
    public final MessageSecurityESCReviewExtra v() {
        return null;
    }

    @Override // y6b.a
    public final Map<Class<?>, Object> w() {
        return null;
    }

    @Override // y6b.a
    public final MessageFoldDetail x() {
        return null;
    }

    @Override // y6b.a
    public final String y() {
        return null;
    }

    @Override // y6b.a
    public final Map<String, MessageLink> z() {
        return null;
    }

    static {
        d = new a();
        e = new r();
        f = new m();
        g = new i();
        h = new p();
        i = new k();
        j = new f();
        k = new g();
        l = new u2b.a();
        m = new l();
        n = new s();
        o = new n();
        p = new q();
        HashMap r0 = new HashMap();
        List<e<?, ?, ?>> r1 = ChatCoreModule.a().getExtensionDependency().c();
        if (CollectionUtils.isEmpty(r1) == true) goto L8;
        Iterator<e<?, ?, ?>> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        p2b.a r3 = new p2b.a(r2.next().b());
        a.a(d, r0, r3);
    L8:
        a r4 = d;
        a.a(r4, r0, f);
        a.a(r4, r0, e);
        a.a(r4, r0, p);
        a.a(r4, r0, i);
        a.a(r4, r0, g);
        a.a(r4, r0, h);
        a.a(r4, r0, l);
        a.a(r4, r0, m);
        a.a(r4, r0, n);
        a.a(r4, r0, o);
        a.a(r4, r0, j);
        a.a(r4, r0, k);
    }

    @Override // v5b.c
    public final boolean j() {
        if (Message.Status.DELETED != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // v5b.c
    public final HashMap<Integer, String> k() {
        return this.c;
    }

    public final boolean isContentSame(b r4) {
        ThreadMessageVO r5 = (ThreadMessageVO) r4;
        if (r5 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(null, null) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(null, null) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(null, null) == true) goto L18;
        return false;
    L18:
        if (getType() == r5.getType()) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(null, null) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.a, r5.a) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.b, r5.b) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(null, null) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(null, null) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(null, null) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(null, null) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(null, null) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(null, null) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(null, null) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(null, null) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(null, null) == true) goto L57;
        return false;
    L57:
        T(null, null);
        throw null;
    }

    public final boolean isItemSame(b r2) {
        ThreadMessageVO<T> r3 = (ThreadMessageVO) r2;
        Intrinsics.checkNotNullParameter(r3, "diffable");
        if (this == r3) goto L8;
        r3.getClass();
        return true;
    L8:
        return true;
    }

    @Override // v5b.c
    public final void f(int r2, String r3) {
        if (this.c != null) goto L5;
        this.c = new HashMap();
    L5:
        HashMap<Integer, String> r0 = this.c;
        if (r0 == null) goto L9;
        r0.put(Integer.valueOf(r2), r3);
        return;
    }
}
