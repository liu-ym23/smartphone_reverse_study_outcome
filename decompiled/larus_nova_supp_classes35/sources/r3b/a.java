package r3b;

import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chatbase.j;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import q3b.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements j<MessageInfo> {
    public final InterfaceC0291a<MessageInfo> a;
    public final Map<String, HashSet<String>> b;
    public final Map<String, HashSet<String>> c;

    /* JADX INFO: renamed from: r3b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0291a<T extends f5b.b> {
    }

    @Override // com.ss.android.lark.chatbase.j
    public final void c(List r2) {
        Intrinsics.checkNotNullParameter(r2, "updateItems");
    }

    public a(m.a r2) {
        Intrinsics.checkNotNullParameter(r2, "dependency");
        this.a = r2;
        this.b = new HashMap();
        this.c = new HashMap();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.ss.android.lark.chatbase.j
    public final void a(f5b.b r9) {
        MessageInfo r10 = (MessageInfo) r9;
        Intrinsics.checkNotNullParameter(r10, "updateItem");
        if (r10.getMessage().getReplyCount() <= 0) goto L5;
    L6:
        HashSet r0 = (HashSet) ((HashMap) this.b).get(r10.getMessage().getId());
        if (r0 != null) goto L9;
    L20:
        HashSet r1 = (HashSet) ((HashMap) this.c).get(r10.getMessage().getId());
        if (r1 != null) goto L23;
    L26:
        boolean r4 = true;
    L27:
        if (r4 == true) goto L39;
        if (r1 == null) goto L58;
        Iterator r2 = r1.iterator();
    L31:
        if (r2.hasNext() == false) goto L59;
        int r5 = ((m.a) this.a).a.b.getItemPosByKey(new String[]{(String) r2.next()});
        if (r5 <= (-1)) goto L31;
        MessageInfo r6 = (MessageInfo) ((m.a) this.a).a.b.get(r5);
        MessageInfo r7 = r6.getThreadParentMessageInfo();
        if (r7 == null) goto L31;
        m.a r8 = (m.a) this.a;
        r8.getClass();
        if (r8.a.T(r7, r10) == false) goto L31;
        r6.setThreadParentMessageInfo(r10);
        ((m.a) this.a).a.b.set(r5, r6);
        goto L31
    L59:
        return;
    L58:
        return;
    L39:
        return;
    L23:
        if (r1.isEmpty() == true) goto L26;
        r4 = false;
        goto L27
    L9:
        if ((!r0.isEmpty()) == false) goto L20;
        Iterator r3 = r0.iterator();
    L12:
        if (r3.hasNext() == false) goto L20;
        int r11 = ((m.a) this.a).a.b.getItemPosByKey(new String[]{(String) r3.next()});
        if (r11 <= (-1)) goto L12;
        MessageInfo r12 = (MessageInfo) ((m.a) this.a).a.b.get(r11);
        MessageInfo r13 = r12.getParentMessageInfo();
        if (r13 == null) goto L12;
        m.a r14 = (m.a) this.a;
        r14.getClass();
        if (r14.a.T(r13, r10) == false) goto L12;
        r12.setParentMessageInfo(r10);
        ((m.a) this.a).a.b.set(r11, r12);
        goto L12
    L5:
        if (r10.getParentMessageInfo() == null) goto L20;
        goto L6
    }

    @Override // com.ss.android.lark.chatbase.j
    public final void b(List<MessageInfo> r5, x4b.a<MessageInfo> r6) {
        Intrinsics.checkNotNullParameter(r5, "appendItems");
        Iterator<MessageInfo> r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L17;
        MessageInfo r8 = r7.next();
        MessageInfo r0 = r8.getParentMessageInfo();
        if (r0 == null) goto L11;
        String r1 = r0.getMessage().getId();
        String r2 = r8.getMessage().getId();
        HashSet r3 = (HashSet) ((HashMap) this.b).get(r1);
        if (r3 != null) goto L10;
        r3 = new HashSet();
        ((HashMap) this.b).put(r1, r3);
    L10:
        r3.add(r2);
    L11:
        MessageInfo r4 = r8.getThreadParentMessageInfo();
        if (r4 == null) goto L4;
        String r9 = r4.getMessage().getId();
        String r10 = r8.getMessage().getId();
        HashSet r11 = (HashSet) ((HashMap) this.c).get(r9);
        if (r11 != null) goto L16;
        r11 = new HashSet();
        ((HashMap) this.c).put(r9, r11);
    L16:
        r11.add(r10);
        goto L4
    }
}
