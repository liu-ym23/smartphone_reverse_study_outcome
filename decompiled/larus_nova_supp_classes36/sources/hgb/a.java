package hgb;

import com.ss.android.lark.biz.officesdk.im.message.reaction.DoubaoMessageFeedbackOperation;
import com.ss.android.lark.biz.officesdk.im.message.reaction.DoubaoMessageFeedbackSource;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import wsb.b;
import y6b.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: hgb.a$a, reason: collision with other inner class name */
    public static final class C0272a {
        public C0272a() {
        }

        public final boolean a(String r3) {
            Intrinsics.checkNotNullParameter(r3, "reactionKey");
            Set<String> r1 = b.a;
            Intrinsics.checkNotNullParameter(r3, "reactionKey");
            return b.b.contains(r3);
        }

        public final boolean b(String r3) {
            Intrinsics.checkNotNullParameter(r3, "reactionKey");
            Set<String> r1 = b.a;
            Intrinsics.checkNotNullParameter(r3, "reactionKey");
            return b.a.contains(r3);
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v14, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v5 */
    public static void a(y6b.a r9, String r10, DoubaoMessageFeedbackSource r11) {
        Intrinsics.checkNotNullParameter(r9, "messageVo");
        Intrinsics.checkNotNullParameter(r10, "reactionKey");
        Intrinsics.checkNotNullParameter(r11, "source");
        if ((r9 instanceof c) == false) goto L5;
        c r12 = (c) r9;
    L6:
        if (r12 != null) goto L9;
        return;
    L9:
        if (r12.getType() == Message.Type.DOUBAO) goto L11;
        return;
    L11:
        String r0 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d();
        g5b.a r1 = (g5b.a) r12.n(g5b.a.class);
        if (r1 == null) goto L43;
        String r3 = Long.valueOf(r1.a).toString();
        if (r3 == null) goto L45;
        List r13 = r12.u;
        if (r13 == null) goto L28;
        ArrayList r2 = new ArrayList();
        Iterator r14 = r13.iterator();
    L20:
        if (r14.hasNext() == false) goto L24;
        Object r4 = r14.next();
        if (((ReactionInfo) r4).getReactionChatters().containsKey(r0) == false) goto L20;
        r2.add(r4);
        goto L20
    L24:
        ?? r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator r5 = r2.iterator();
    L26:
        if (r5.hasNext() == false) goto L29;
        r15.add(((ReactionInfo) r5.next()).getReaction().getType());
    L29:
        ?? r6 = r15;
        if (r6.contains(r10) == false) goto L32;
        DoubaoMessageFeedbackOperation r16 = DoubaoMessageFeedbackOperation.REMOVE;
    L33:
        DoubaoMessageFeedbackOperation r7 = r16;
        C0272a r8 = new C0272a();
        oza.a r17 = OfficeSDKManager.getHostUserService(r0, oza.a.class);
        if (r17 == null) goto L44;
        r17.i0(r3, r6, r7, r10, r11, r8);
        return;
    L44:
        return;
    L32:
        r16 = DoubaoMessageFeedbackOperation.ADD;
        goto L33
    L28:
        r15 = CollectionsKt.emptyList();
        goto L29
    L45:
        return;
    L43:
        return;
    L5:
        r12 = null;
        goto L6
    }
}
