package q3b;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.biz.im.api.a1;
import com.ss.android.lark.biz.im.api.w0;
import com.ss.android.lark.chat.chatwindow.chat.model.pin.MessageListPinExtraLoader;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.v;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageFoldDetail;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m extends BasePageStore<MessageInfo, x4b.a<MessageInfo>> {
    public final Map<String, Boolean> k;
    public final List<Pair<Integer, Integer>> l;
    public c m;
    public final com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.a n;
    public final MessageListPinExtraLoader o;
    public final a2b.j.a p;
    public final boolean q;
    public int r;
    public w0 s;
    public a1 t;

    public class a implements r3b.a.InterfaceC0291a<MessageInfo> {
        public final /* synthetic */ m a;

        public a(m r1) {
            this.a = r1;
        }
    }

    public class b implements com.ss.android.lark.chatbase.j<MessageInfo> {
        public final /* synthetic */ m a;

        @Override // com.ss.android.lark.chatbase.j
        public final void c(List<MessageInfo> r1) {
        }

        public b(m r1) {
            this.a = r1;
        }

        @Override // com.ss.android.lark.chatbase.j
        public final /* bridge */ /* synthetic */ void a(f5b.b r1) {
            MessageInfo r2 = (MessageInfo) r1;
        }

        @Override // com.ss.android.lark.chatbase.j
        public final void b(List<MessageInfo> r2, x4b.a<MessageInfo> r3) {
            if ((r3 instanceof e) == false) goto L11;
            m r4 = this.a;
            e r5 = (e) r3;
            r4.getClass();
            if (r5 == null) goto L9;
            int r0 = r5.d;
            if (r0 <= 0) goto L9;
            r4.r = r0;
        L9:
            Map<String, Boolean> r6 = this.a.k;
            ConcurrentHashMap r7 = (ConcurrentHashMap) r6;
            r7.putAll(r5.e);
            return;
        }
    }

    public interface c {
        int a();
    }

    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final String x() {
        return "ChatWindowDataStore";
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [q3b.f] */
    /* JADX WARN: Type inference failed for: r1v4, types: [q3b.g] */
    /* JADX WARN: Type inference failed for: r2v0, types: [q3b.h] */
    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final void J() {
        h(new com.ss.android.lark.chat.chatwindow.chat.model.data.decorator.d(this.g));
        h(new com.ss.android.lark.chat.chatwindow.chat.model.data.decorator.b(this.g.E()));
        h(new com.ss.android.lark.chat.chatwindow.chat.model.data.decorator.f(new f(this)));
        h(new com.ss.android.lark.chat.chatwindow.chat.model.data.decorator.c());
        h(new com.ss.android.lark.chat.chatwindow.chat.model.data.decorator.e(new g(this)));
        h(new com.ss.android.lark.chat.chatwindow.chat.model.data.decorator.a(this.g, new h(this)));
    }

    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final void K() {
        i(new r3b.b(this.g.P()));
        i(new r3b.a(new a(this)));
        i(new b(this));
    }

    public final void V() {
        int r0 = this.b.size();
        if (r0 >= 30) goto L6;
        Log.i("ChatWindowDataStore", "current item size is:" + r0 + ", no need opt");
        return;
    L6:
        this.a.execute(new j(this));
    }

    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final void I() {
        super.I();
        ((ArrayList) this.l).clear();
    }

    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final boolean D() {
        return this.q;
    }

    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final boolean C(f5b.b r2) {
        MessageInfo r3 = (MessageInfo) r2;
        if (this.q == false) goto L8;
        if (r3.getMessageFoldDetail() == null) goto L8;
        return !r3.getMessageFoldDetail().isFakeFold();
    L8:
        return super.C(r3);
    }

    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final boolean E(f5b.b r10) {
        MessageInfo r11 = (MessageInfo) r10;
        boolean r1 = true;
        if (this.q == false) goto L37;
        List<Pair<Integer, Integer>> r0 = this.l;
        String r3 = r11.getMessage().getFoldId();
        if (TextUtils.isEmpty(r3) == false) goto L7;
    L9:
        boolean r4 = false;
    L11:
        if (r11.isPreMessage() == false) goto L13;
    L17:
        boolean r5 = true;
    L19:
        if (r5 == true) goto L28;
        int r6 = r11.getMessage().getPosition();
        Iterator r2 = ((ArrayList) r0).iterator();
    L22:
        if (r2.hasNext() == false) goto L28;
        Pair r7 = (Pair) r2.next();
        if (((Integer) r7.first).intValue() > r6) goto L22;
        if (((Integer) r7.second).intValue() < r6) goto L22;
        Log.d("MessageUtils", "isMessageFilterByFold: msg position:" + r6 + " is in fold interval [" + r7.first + " , " + r7.second + "]");
        boolean r8 = true;
    L29:
        boolean r9 = !TextUtils.isEmpty(r3);
        Log.d("MessageUtils", "isMessageFilterByFold: msgHasFoldId: " + r9 + " , inFoldInterval: " + r8 + " , skipFold: " + r5);
        if (r9 == true) goto L32;
        if (r8 == true) goto L32;
    L34:
        boolean r12 = false;
    L35:
        if (r12 == false) goto L37;
        boolean r13 = true;
    L38:
        Log.d("ChatWindowDataStore", "msg id " + r11.getMessage().getId() + " , pos: " + U(r11) + " foldId: " + r11.getMessage().getFoldId() + " fold: " + r11.getMessageFoldDetail());
        if (r13 == false) goto L53;
        Log.i("ChatWindowDataStore", "isValidData: current message should be fold , return false, msg id " + r11.getMessage().getId() + " , pos " + U(r11));
        Message r14 = r11.getMessage();
        String r15 = r14.getcId();
        if (TextUtils.isEmpty(r15) == false) goto L43;
        Log.w("ChatWindowDataStore", "tryRemoveFakeMessageInDatas: message cid is empty, " + r14.getId());
        return false;
    L43:
        Iterator r16 = this.b.iterator();
    L45:
        if (r16.hasNext() == false) goto L49;
        final MessageInfo r17 = (MessageInfo) r16.next();
        if (Objects.equals(r17.getMessage().getcId(), r15) == false) goto L45;
    L50:
        if (r17 == null) goto L72;
        Log.i("ChatWindowDataStore", "tryRemoveFakeMessageInDatas: find preMessage in mDatas, cid: " + r15);
        this.a.execute(new i(this, r17));
        return false;
    L72:
        return false;
    L49:
        r17 = null;
        goto L50
    L53:
        if (this.s.a() == Integer.MIN_VALUE) goto L55;
        int r18 = this.s.a();
    L57:
        if (U(r11) >= r18) goto L61;
        r1 = false;
    L61:
        return r1;
    L55:
        r18 = -1;
    L32:
        if (r5 == true) goto L34;
        r12 = true;
    L28:
        r8 = false;
        goto L29
    L13:
        if (r11.getMessageFoldDetail() != null) goto L17;
        if (r4 == true) goto L17;
        r5 = false;
        goto L19
    L7:
        if (r3.equals(r11.getId()) == false) goto L9;
        r4 = true;
    L37:
        r13 = false;
        goto L38
    }

    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final void G(x4b.a<MessageInfo> r2) {
        super.G(r2);
        if ((r2 instanceof e) == false) goto L6;
        Map<String, Boolean> r0 = this.k;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        r1.putAll(((e) r2).e);
        return;
    }

    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final void L(w0 r1) {
        this.s = r1;
    }

    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final void M(a1 r1) {
        this.t = r1;
    }

    public final int U(MessageInfo r2) {
        return this.t.a(r2);
    }

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
    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final void j(f5b.b r7) {
        MessageInfo r8 = (MessageInfo) r7;
        int r0 = U(r8);
        if (r8.isPreMessage() == false) goto L5;
    L17:
        super.j(r8);
        return;
    L5:
        if (this.b.size() == 0) goto L17;
        if (r0 > this.d) goto L17;
        int r1 = 0;
    L11:
        if (r1 >= this.b.size()) goto L16;
        int r2 = U((MessageInfo) this.b.get(r1));
        if (r2 > r0) goto L14;
        r1 = r1 + 1;
        goto L11
    L14:
        Log.i("ChatWindowDataStore", "appendNewItem into position:" + r1 + ", newItemPosition is" + r0 + ", nextPosition is:" + r2);
        this.b.add(r1, r8);
        return;
    L16:
        Log.w("ChatWindowDataStore", "appendNewItem, can't find insert position, append to last position");
        super.j(r8);
    }

    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final boolean n(f5b.b r9) {
        MessageInfo r10 = (MessageInfo) r9;
        StringBuilder r0 = new StringBuilder("canAppendNewItem: pos is ");
        r0.append(U(r10));
        r0.append(" , item id is: ");
        r0.append(r10.getMessage().getId());
        r0.append(" , item has fold: ");
        if (r10.getMessageFoldDetail() == null) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        Log.d("ChatWindowDataStore", r0.toString());
        if (r10.isPreMessage() == true) goto L9;
        int r2 = U(r10);
        MessageFoldDetail r11 = r10.getMessageFoldDetail();
        if (this.q == false) goto L15;
        if (r11 == null) goto L15;
        int r12 = (int) Math.max(r11.getLastMessagePosition(), r2);
    L17:
        if (this.c != Integer.MAX_VALUE) goto L25;
        if (this.d != Integer.MIN_VALUE) goto L25;
        int r4 = this.f.get();
        Log.d("ChatWindowDataStore", "canAppendNewItem: lastPos is " + r4 + " , position is " + r2);
        if (r4 < r2) goto L47;
        if (r4 < r12) goto L47;
        return false;
    L47:
        return true;
    L25:
        if (r12 < this.c) goto L30;
        if (r12 <= this.d) goto L47;
    L30:
        if (r2 >= this.c) goto L33;
        return false;
    L33:
        if (r2 > (this.d + 1)) goto L52;
        c r13 = this.m;
        if (r13 == null) goto L44;
        int r14 = r13.a();
        if (r14 < 0) goto L44;
        Log.i("ChatWindowDataStore", "newItemPosition is:" + r2 + ", lastItemPosition is:" + r14);
        if ((r2 - r14) <= 100) goto L44;
        boolean r15 = true;
    L45:
        if (r15 == false) goto L47;
        return false;
    L44:
        r15 = false;
        goto L45
    L52:
        return false;
    L15:
        r12 = r2;
        goto L17
    L9:
        if (B(r10) == false) goto L47;
        return false;
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final void q(f5b.b r11) {
        MessageInfo r12 = (MessageInfo) r11;
        if (this.q == true) goto L5;
        r12.setMessageFoldDetail(null);
    L5:
        super.q(r12);
        if (this.q == true) goto L8;
        return;
    L8:
        if (r12.getMessageFoldDetail() != null) goto L10;
        return;
    L10:
        if (this.q == true) goto L12;
        return;
    L12:
        if (r12.getMessageFoldDetail() == null) goto L76;
        MessageFoldDetail r13 = r12.getMessageFoldDetail();
        int r1 = (int) r13.getRootMessagePosition();
        int r14 = (int) r13.getLastMessagePosition();
        if (r1 < 0) goto L75;
        if (r14 < 0) goto L77;
        ArrayList r0 = new ArrayList(this.l);
        r0.add(new Pair(Integer.valueOf(r1), Integer.valueOf(r14)));
        Collections.sort(r0, new k());
        ArrayList r15 = new ArrayList(r0.size());
        int r2 = ((Integer) ((Pair) ListProtector.get(r0, 0)).first).intValue();
        int r3 = ((Integer) ((Pair) ListProtector.get(r0, 0)).second).intValue();
        int r5 = 1;
    L20:
        if (r5 >= r0.size()) goto L26;
        Pair r6 = (Pair) ListProtector.get(r0, r5);
        if (((Integer) r6.first).intValue() <= r3) goto L24;
        r15.add(new Pair(Integer.valueOf(r2), Integer.valueOf(r3)));
        r2 = ((Integer) r6.first).intValue();
        r3 = ((Integer) r6.second).intValue();
    L25:
        r5 = r5 + 1;
        goto L20
    L24:
        r3 = Math.max(r3, ((Integer) r6.second).intValue());
        goto L25
    L26:
        r15.add(new Pair(Integer.valueOf(r2), Integer.valueOf(r3)));
        CollectionUtils.resetToList(this.l, r15);
        Log.d("ChatWindowDataStore", "updateFoldIntervalIfNeed: foldIntervals: " + this.l);
        final ArrayList r16 = new ArrayList();
        ArrayList r4 = new ArrayList();
        Iterator r7 = this.b.iterator();
    L28:
        if (r7.hasNext() == false) goto L50;
        MessageInfo r8 = (MessageInfo) r7.next();
        String r9 = r8.getMessage().getFoldId();
        if (TextUtils.isEmpty(r9) == false) goto L32;
    L34:
        boolean r10 = false;
    L36:
        if (r8.getMessageFoldDetail() != null) goto L28;
        if (r8.isPreMessage() == true) goto L28;
        if (r10 == true) goto L28;
        int r17 = U(r8);
        Iterator r18 = ((ArrayList) this.l).iterator();
    L43:
        if (r18.hasNext() == false) goto L28;
        Pair r19 = (Pair) r18.next();
        if (r17 < ((Integer) r19.first).intValue()) goto L43;
        if (r17 > ((Integer) r19.second).intValue()) goto L43;
        r16.add(r8.getId());
        r4.add(Integer.valueOf(r17));
        goto L28
    L32:
        if (r9.equals(r8.getId()) == false) goto L34;
        r10 = true;
        goto L36
    L50:
        if (r16.isEmpty() == true) goto L78;
        Log.i("ChatWindowDataStore", "removeFoldMessagesInDataStoreIfNeed: find " + r16.size() + " messages to fold , remove positions: " + r4);
        this.a.execute(new l(this, r16));
        return;
    L78:
        return;
    L77:
        return;
    L75:
        return;
    }

    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final int t(f5b.b r1) {
        return ((MessageInfo) r1).getMessage().getBadgeCount();
    }

    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final /* bridge */ /* synthetic */ int v(f5b.b r1) {
        return U((MessageInfo) r1);
    }

    public final boolean T(MessageInfo r6, MessageInfo r7) {
        if (this.q == false) goto L16;
        long r1 = 0;
        if (r6.getMessageFoldDetail() == null) goto L7;
        long r3 = r6.getMessageFoldDetail().getUpdateTimeMs();
    L9:
        if (r7.getMessageFoldDetail() == null) goto L12;
        r1 = r7.getMessageFoldDetail().getUpdateTimeMs();
    L12:
        if (r1 <= r3) goto L16;
        return true;
    L7:
        r3 = 0;
    L16:
        return super.o(r6, r7);
    }

    @Override // com.ss.android.lark.chatbase.BasePageStore
    public final /* bridge */ /* synthetic */ boolean o(f5b.b r1, f5b.b r2) {
        return T((MessageInfo) r1, (MessageInfo) r2);
    }

    public m(v r1, x4b.d r2, BasePageStore.c r3, com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.a r4, MessageListPinExtraLoader r5, a2b.j.a r6, boolean r7) {
        super(r1, r2, r3);
        this.l = new ArrayList();
        this.r = 0;
        this.s = w0.a;
        this.t = a1.a.a;
        this.k = new ConcurrentHashMap();
        this.n = r4;
        this.o = r5;
        this.p = r6;
        this.q = r7;
    }
}
