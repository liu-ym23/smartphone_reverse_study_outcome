package com.ss.android.lark.chatbase;

import android.text.TextUtils;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.biz.im.api.a1;
import com.ss.android.lark.biz.im.api.w0;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.base.model.dispatch.ActionDispatcher;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.IMessageListComponent;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.core.model.ObservableMappedArrayList;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageFoldDetail;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.MessageStreamStatus;
import com.ss.android.lark.im.sdk.utils.ImSdkMessageUtils;
import com.ss.android.lark.log.Log;
import f5b.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import w4b.d0;
import x4b.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class BasePageStore<T extends f5b.b, PageData extends x4b.a<T>> extends com.ss.android.lark.chatbase.model.c<String, T, PageData, com.ss.android.lark.chat.core.model.d<T>> implements ActionDispatcher.a {
    public final ObservableMappedArrayList<String, T> b;
    public volatile int c;
    public volatile int d;
    public final List<Integer> e;
    public volatile AtomicInteger f;
    public final v g;
    public final c<T> h;
    public final List<j<T>> i;
    public final List<i<T>> j;

    public static class a<T extends f5b.b> implements hya.a<T> {
        public final T a;

        public a(T r1) {
            this.a = r1;
        }

        public final Object a(Object r1) {
            f5b.b r2 = (f5b.b) r1;
            return this.a;
        }
    }

    public static class b<T extends f5b.b> implements ObservableMappedArrayList.b<String, T> {
        public b() {
        }

        public final Object a(Object r1) {
            return ((f5b.b) r1).getId();
        }
    }

    public interface c<T> {
        void a();

        void b(List<T> r1);

        void c(List<T> r1);
    }

    public static abstract class d<T extends f5b.b> implements hya.a<T> {
        public d() {
        }

        public abstract T b(T r1);

        public final Object a(Object r1) {
            f5b.b r2 = (f5b.b) r1;
            if (r2 != null) goto L7;
            return null;
        L7:
            return b(r2);
        }
    }

    public static class e implements hya.b<String> {
        public final String a;

        public final /* bridge */ /* synthetic */ Object b() {
            return null;
        }

        public final Object a() {
            return this.a;
        }

        public e(String r1) {
            this.a = r1;
        }
    }

    public boolean D() {
        return true;
    }

    public boolean E(T r1) {
        return true;
    }

    public void H(n5b.a r1) {
    }

    public abstract void J();

    public abstract void K();

    public void L(w0 r1) {
    }

    public void M(a1 r1) {
    }

    public abstract int t(T r1);

    public abstract int v(T r1);

    public abstract String x();

    public MessageInfo y() {
        return null;
    }

    public void I() {
        this.b.clear();
        ((ArrayList) this.e).clear();
        this.c = Integer.MAX_VALUE;
        this.d = PluginList.LEVEL_NOT_SET;
    }

    public final k N() {
        return new k(this, this.a);
    }

    public final List<T> s() {
        this.b.acquireReadAccess();
        ArrayList r0 = new ArrayList(this.b);
        this.b.releaseReadAccess();
        return r0;
    }

    @Override // com.ss.android.lark.chatbase.model.c
    public final List d() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A(PageData r4) {
        c();
        this.b.beginUpdate();
        I();
        List<T> r0 = r(r4.a);
        this.b.addAll(r0);
        List<Integer> r1 = this.e;
        ArrayList r2 = (ArrayList) r1;
        r2.addAll(r4.c);
        z(r0, r4);
        R("init", r4);
        this.b.finishUpdate();
        F("init", r4);
    }

    public final boolean B(T r8) {
        if (v(r8) >= this.d) goto L11;
        int r0 = this.b.size();
        int r1 = Math.min(r0, 5);
        int r3 = 0;
    L5:
        if (r3 >= r1) goto L11;
        T r4 = this.b.get((r0 - 1) - r3);
        if (TextUtils.equals(r4.getcId(), r8.getcId()) == true) goto L8;
        r3 = r3 + 1;
        goto L5
    L8:
        Log.i(x(), "can not add, pre message has add in list, cid = " + r4.getcId());
        return true;
    L11:
        return false;
    }

    public boolean C(T r2) {
        if (r2.canShow() == false) goto L7;
        Message r3 = r2.getMessage();
        d0 r0 = b7b.b.a;
        if (ImSdkMessageUtils.c(r3) == true) goto L7;
        return true;
    L7:
        return false;
    }

    public void G(final PageData r3) {
        this.a.execute(new h(this, r3));
    }

    public final void Q(T r5) {
        MessageFoldDetail r6 = r5.getMessageFoldDetail();
        if (D() == false) goto L7;
        if (r6 == null) goto L8;
        this.d = (int) Math.max(this.d, r6.getLastMessagePosition());
        return;
    L8:
        return;
    }

    @Override // com.ss.android.lark.chat.base.model.dispatch.ActionDispatcher.a
    public final boolean a(com.ss.android.lark.chat.base.model.dispatch.a r6) {
        if ((r6 instanceof com.ss.android.lark.chat.base.model.dispatch.b) == false) goto L7;
        com.ss.android.lark.chat.base.model.dispatch.b r7 = (com.ss.android.lark.chat.base.model.dispatch.b) r6;
        e r0 = r7.b;
        r7.setResult(this.b.getItemByKey(new String[]{r0.a, null}));
        return true;
    L7:
        if ((r6 instanceof com.ss.android.lark.chat.base.model.dispatch.e) == false) goto L10;
        final com.ss.android.lark.chat.base.model.dispatch.e r8 = (com.ss.android.lark.chat.base.model.dispatch.e) r6;
        this.a.execute(new com.ss.android.lark.chatbase.d(this, r8));
        return true;
    L10:
        return false;
    }

    @Override // com.ss.android.lark.chatbase.model.c
    public final /* bridge */ /* synthetic */ void b(x4b.a r1) {
        k(r1);
    }

    @Override // com.ss.android.lark.chatbase.model.c
    public final /* bridge */ /* synthetic */ void e(x4b.a r1) {
        A(r1);
    }

    @Override // com.ss.android.lark.chatbase.model.c
    public final void f(x4b.a r4) {
        c();
        this.b.beginUpdate();
        List<T> r0 = r(r4.a);
        this.b.addAll(0, r0);
        z(r0, r4);
        R("prependPage", r4);
        this.b.finishUpdate();
        F("prependPage", r4);
    }

    public final void h(i<T> r2) {
        if (this.j.contains(r2) == true) goto L6;
        this.j.add(r2);
        return;
    }

    public final void i(j<T> r2) {
        if (((CopyOnWriteArrayList) this.i).contains(r2) == true) goto L6;
        ((CopyOnWriteArrayList) this.i).add(r2);
        return;
    }

    public void j(T r2) {
        this.b.add(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k(PageData r3) {
        c();
        this.b.beginUpdate();
        List<T> r0 = r(r3.a);
        this.b.addAll(r0);
        z(r0, r3);
        R("appendPage", r3);
        this.b.finishUpdate();
        F("appendPage", r3);
    }

    public final void l(final List<hya.c<String, f5b.b>> r3) {
        this.a.execute(new f(this, r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void m(List<hya.c<String, f5b.b>> r21) {
        BasePageStore<T, PageData> r0 = this;
        if (r21.isEmpty() == false) goto L5;
        return;
    L5:
        c();
        Log.i(x(), "batch update start");
        r0.b.beginUpdate();
        ArrayList r1 = new ArrayList();
        Iterator<hya.c<String, f5b.b>> r2 = r21.iterator();
    L7:
        if (r2.hasNext() == false) goto L68;
        hya.c<String, f5b.b> r3 = r2.next();
        hya.b r4 = r3.b();
        hya.a r5 = r3.a();
        int r6 = r0.b.getItemPosByKey(new String[]{(String) r4.a(), (String) r4.b()});
        if (r6 <= (-1)) goto L11;
        T r7 = r0.b.get(r6);
    L12:
        f5b.b r8 = (f5b.b) r5.a(r7);
        if (r8 != null) goto L15;
        r8 = null;
    L15:
        if (r8 == null) goto L7;
        if (r7 == null) goto L19;
        boolean r10 = true;
    L20:
        Log.d(x(), "isUpdateExistItem: " + r10);
        String r11 = "<this>";
        String r12 = "noTraceDelete";
        if (r10 == false) goto L41;
        boolean r13 = r8.isNoTraceDelete();
        boolean r14 = r0.C(r8);
        if (r13 == false) goto L25;
        r0.b.remove(r6);
    L32:
        r2 = r2;
        r11 = "<this>";
    L40:
        r1.add(r8);
        BasePageStore<T, PageData> r9 = this;
    L59:
        if (TextUtils.isEmpty(r12) == true) goto L63;
        Intrinsics.checkNotNullParameter(r8, r11);
        if (kkb.a.a(r8.getMessage()) == true) goto L63;
        Log.i(x(), String.format("%s message： %s", new Object[]{r12, r8}));
    L63:
        Iterator r15 = ((CopyOnWriteArrayList) r9.i).iterator();
    L65:
        if (r15.hasNext() == false) goto L67;
        ((j) r15.next()).a(r8);
        goto L65
    L67:
        r0 = r9;
        r2 = r2;
        goto L7
    L25:
        if (r14 == true) goto L27;
        r0.b.remove(r6);
        Collections.synchronizedSet(new HashSet());
        Message r16 = r8.getMessage();
        if (r16 == null) goto L39;
        d0 r17 = b7b.b.a;
        if (ImSdkMessageUtils.c(r16) == false) goto L39;
        long r18 = ChatCoreModule.a().getSettingDependency().a();
        long r19 = r16.getBurnTime();
        long r20 = r16.getCreateTime() * 1000;
        long r110 = r16.getBurnLife() * 1000;
        String r22 = TimeZone.getDefault().getDisplayName(false, 0);
        StringBuilder r23 = new StringBuilder("logMsgBurned --> ");
        r23.append(" msgId = " + r16.getId() + " , isBurned = " + r16.isBurned() + " ,ntpTime = " + r18 + " ,burnTime = " + r19 + " ,msgCreateTime = " + r20 + " ,calLeftTime = " + (r19 - r18) + " ,burnLife = " + r110 + " ,timezone = " + r22 + " ,local with ntp offset = " + (System.currentTimeMillis() - r18));
        Log.i("secret_chat_tag", r23.toString());
    L39:
        r12 = "remove";
        goto L40
    L27:
        if (r0.o(r7, r8) == false) goto L31;
        r0.b.set(r6, r8);
        r0.z(Collections.singletonList(r8), null);
        Intrinsics.checkNotNullParameter(r8, "<this>");
        r12 = "update";
        if (kkb.a.a(r8.getMessage()) == true) goto L32;
        r0.S("update", r8);
        goto L32
    L31:
        r12 = String.format("can not replace, skip update。(%s, %s) - (%s, %s)", new Object[]{Long.valueOf(r7.getUpdateTime()), Boolean.valueOf(r7.isPreMessage()), Long.valueOf(r8.getUpdateTime()), Boolean.valueOf(r8.isPreMessage())});
        goto L32
    L41:
        r2 = r2;
        r11 = "<this>";
        r9 = this;
        List<T> r24 = r9.r(Collections.singletonList(r8));
        if (r9.n(r8) == true) goto L44;
        r12 = "can not append, skip update ";
    L54:
        if (r9.v(r8) <= r9.c) goto L59;
        c<T> r25 = r9.h;
        if (r25 == null) goto L59;
        r25.c(r24);
        goto L59
    L44:
        if (r8.isNoTraceDelete() == true) goto L54;
        if (CollectionUtils.isNotEmpty(r24) == false) goto L51;
        r9.j(r8);
        c<T> r26 = r9.h;
        if (r26 == null) goto L51;
        r26.b(r24);
    L51:
        r9.z(Collections.singletonList(r8), null);
        r12 = "add";
        r9.S("add", r8);
        goto L54
    L19:
        r10 = false;
        goto L20
    L11:
        r7 = null;
        goto L12
    L68:
        BasePageStore<T, PageData> r27 = r0;
        if (r1.isEmpty() == true) goto L74;
        Iterator r28 = ((CopyOnWriteArrayList) r27.i).iterator();
    L72:
        if (r28.hasNext() == false) goto L74;
        ((j) r28.next()).c(r1);
    L74:
        r27.b.finishUpdate();
        Log.i(x(), "batch update end");
    }

    public boolean n(T r5) {
        if (r5.isPreMessage() == true) goto L5;
        int r6 = v(r5);
        if (this.c != Integer.MAX_VALUE) goto L18;
        if (this.d != Integer.MIN_VALUE) goto L18;
        if (this.f.get() < r6) goto L25;
        return false;
    L25:
        return true;
    L18:
        if (r6 >= this.c) goto L21;
        return false;
    L21:
        if (this.f.get() <= this.d) goto L26;
        return false;
    L26:
        return true;
    L5:
        if (B(r5) == false) goto L7;
        return false;
    L7:
        return true;
    }

    public void q(T r3) {
        Iterator r0 = ((CopyOnWriteArrayList) this.j).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((i) r0.next()).a(r3);
        goto L4
    }

    public final List<T> r(List<T> r8) {
        c();
        if (CollectionUtils.isEmpty(r8) == false) goto L5;
        return r8;
    L5:
        ArrayList r0 = new ArrayList();
        Iterator<T> r9 = r8.iterator();
    L7:
        if (r9.hasNext() == false) goto L18;
        T r1 = r9.next();
        String r2 = r1.getId();
        if (C(r1) == false) goto L10;
        if (r1.isNoTraceDelete() == true) goto L13;
        if (this.b.containsKey(new String[]{r2, r1.getcId()}) == true) goto L16;
        r0.add(r1);
        goto L7
    L16:
        Log.e(x(), "filter duplicate item:" + r2);
        goto L7
    L13:
        Log.e(x(), "filter noTraceDelete item:" + r2);
        goto L7
    L10:
        Log.e(x(), "filter invisible item:" + r2);
        goto L7
    L18:
        return r0;
    }

    public final T u(String r4) {
        return this.b.getItemByKey(new String[]{r4});
    }

    public final List<T> w(Collection<String> r2) {
        return this.b.getItemsByKey(r2);
    }

    public static boolean g(BasePageStore r3, f5b.b r4) {
        Log.d(r3.x(), "preProcessData: msgPosition is " + r4.getMessage().getPosition());
        if (r3.E(r4) == true) goto L5;
        Log.i(r3.x(), "preProcess data: failed to add data, id = " + r4.getId());
        return false;
    L5:
        r3.q(r4);
        return true;
    }

    public final void F(String r6, x4b.a<T> r7) {
        int r0 = this.b.size();
        int r1 = 0;
        if (r0 <= 0) goto L5;
        int r2 = t(this.b.get(0));
    L6:
        if (r0 <= 0) goto L8;
        r1 = t(this.b.get(r0 - 1));
    L8:
        Log.i(x(), "DataStore " + r6 + ", size is:" + ((ArrayList) r7.a).size() + "， current position range:[" + this.c + ", " + this.d + "], current badge range:[" + r2 + ", " + r1 + "]");
        return;
    L5:
        r2 = 0;
        goto L6
    }

    public final void O(final hya.b<String> r3, final hya.a<f5b.b> r4) {
        this.a.execute(new com.ss.android.lark.chatbase.c(this, r3, r4));
    }

    public final void P(String r2, com.ss.android.lark.chatbase.model.c.b r3) {
        O(new e(r2), r3);
    }

    public final void R(String r7, x4b.a<T> r8) {
        int r0 = this.c;
        int r1 = this.d;
        List<T> r2 = r8.a;
        List<Integer> r9 = r8.b;
        Iterator r3 = ((ArrayList) r2).iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        f5b.b r4 = (f5b.b) r3.next();
        if (r4.isPreMessage() == true) goto L8;
        int r5 = v(r4);
        this.d = Math.max(this.d, r5);
        this.c = Math.min(this.c, r5);
    L8:
        Q(r4);
        goto L4
    L9:
        Iterator r10 = ((ArrayList) r9).iterator();
    L11:
        if (r10.hasNext() == false) goto L13;
        Integer r6 = (Integer) r10.next();
        this.d = Math.max(this.d, r6.intValue());
        this.c = Math.min(this.c, r6.intValue());
        goto L11
    L13:
        Log.i(x(), String.format("%s [%d-%d] -> [%d-%d]", new Object[]{r7, Integer.valueOf(r0), Integer.valueOf(r1), Integer.valueOf(this.c), Integer.valueOf(this.d)}));
    }

    public final void S(String r6, T r7) {
        if (r7.isPreMessage() == false) goto L5;
        return;
    L5:
        int r0 = this.c;
        int r1 = this.d;
        int r2 = v(r7);
        if (this.d == Integer.MIN_VALUE) goto L8;
    L12:
        this.d = Math.max(this.d, r2);
    L13:
        Q(r7);
        Log.i(x(), String.format("%s [%d-%d] -> [%d-%d]", new Object[]{r6, Integer.valueOf(r0), Integer.valueOf(r1), Integer.valueOf(this.c), Integer.valueOf(this.d)}));
        return;
    L8:
        if (this.c != Integer.MAX_VALUE) goto L12;
        this.d = r2;
        this.c = r2;
        c<T> r3 = this.h;
        if (r3 == null) goto L13;
        r3.a();
        goto L13
    }

    public boolean o(T r8, T r9) {
        if (r9.isPreMessage() == false) goto L8;
        if (r8.isPreMessage() == true) goto L8;
        return false;
    L8:
        if (r9.isPreMessage() == true) goto L13;
        if (r8.isPreMessage() == false) goto L13;
        return true;
    L13:
        if (r9.isPreMessage() == true) goto L29;
        if (r8.isPreMessage() == true) goto L29;
        if (r9.getMessage().getStatus() == r8.getMessage().getStatus()) goto L19;
        return true;
    L19:
        MessageStreamStatus r0 = r8.getMessage().getStreamStatus();
        MessageStreamStatus r3 = MessageStreamStatus.Transport;
        if (r0 != r3) goto L29;
        if (r9.getMessage().getStreamStatus() == r3) goto L24;
        return true;
    L24:
        if (r9.getMessage().getStreamSequenceId() < r8.getMessage().getStreamSequenceId()) goto L34;
        return true;
    L34:
        return false;
    L29:
        if (r9.getUpdateTime() >= r8.getUpdateTime()) goto L31;
        return false;
    L31:
        if (r9.isIntermediateMessage() == true) goto L36;
        return true;
    L36:
        return false;
    }

    public final void p(Integer r8, IMessageListComponent.c r9) {
        c();
        Log.d(x(), "checkToClearDataStore: newFirstMsgPosition is " + r8 + " , position interval is [" + this.c + "," + this.d + "]");
        this.b.beginUpdate();
        if (r8.intValue() != (-1)) goto L8;
        if (this.d != Integer.MIN_VALUE) goto L8;
        Log.i(x(), "not clear data store: only have pre message");
    L27:
        this.b.finishUpdate();
        return;
    L8:
        if (r8.intValue() < this.d) goto L11;
        I();
        r9.a();
        Log.i(x(), "data store is cleared");
        goto L27
    L11:
        if (this.c > r8.intValue()) goto L27;
        if (r8.intValue() >= this.d) goto L27;
        int r1 = 0;
    L16:
        if (r1 >= this.b.size()) goto L26;
        T r2 = this.b.get(r1);
        int r3 = r2.getMessage().getPosition();
        if (D() == false) goto L23;
        if (r2.getMessageFoldDetail() == null) goto L23;
        r3 = (int) Math.max(r3, r2.getMessageFoldDetail().getLastMessagePosition());
    L23:
        if (r3 > r8.intValue()) goto L26;
        r1 = r1 + 1;
    L26:
        this.b.removeRange(0, r1);
        this.c = r8.intValue() + 1;
        r9.a();
        Log.i(x(), "data store is partially cleared from " + r8);
        goto L27
    }

    public final void z(List<T> r3, PageData r4) {
        Iterator r0 = ((CopyOnWriteArrayList) this.i).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((j) r0.next()).b(r3, r4);
        goto L4
    }

    public BasePageStore(v r2, x4b.d r3, c r4) {
        super(r3);
        this.c = Integer.MAX_VALUE;
        this.d = PluginList.LEVEL_NOT_SET;
        this.e = new ArrayList();
        this.f = new AtomicInteger(-1);
        this.i = new CopyOnWriteArrayList();
        this.j = new CopyOnWriteArrayList();
        this.g = r2;
        this.h = r4;
        final b r5 = new b();
        final boolean r6 = DevEnvUtil.isDebugMode(ChatCoreModule.a().getContext());
        final boolean r0 = true;
        this.b = (ObservableMappedArrayList<String, T>) new AnonymousClass1(this, r5, r0, r6);
        K();
        J();
    }
}
