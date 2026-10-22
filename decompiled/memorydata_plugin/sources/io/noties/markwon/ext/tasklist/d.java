package io.noties.markwon.ext.tasklist;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.commonmark.node.AbstractVisitor;
import org.commonmark.node.ListItem;
import org.commonmark.node.Node;
import org.commonmark.node.Paragraph;
import org.commonmark.node.Text;
import org.commonmark.parser.PostProcessor;

/* JADX INFO: loaded from: classes6.dex */
class d implements PostProcessor {

    /* JADX INFO: renamed from: io.noties.markwon.ext.tasklist.d$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a extends AbstractVisitor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Pattern f16536a = null;

        static {
            f16536a = Pattern.compile("^\\[([xX\\s])]\\s+(.*)");
        }

        private a() {
        }

        /* synthetic */ a(AnonymousClass1 r1) {
            this();
        }

        @Override // org.commonmark.node.AbstractVisitor, org.commonmark.node.Visitor
        public void visit(ListItem r7) {
            Node r0 = r7.getFirstChild();
            if (ZeusTransformUtils.instanceOf(r0, Paragraph.class) == false) goto L19;
            Node r1 = r0.getFirstChild();
            if (ZeusTransformUtils.instanceOf(r1, Text.class) == false) goto L19;
            Text r2 = (Text) ZeusTransformUtils.preCheckCast(r1, Text.class, "com.obric.memorydata.plugin");
            Matcher r3 = f16536a.matcher(r2.getLiteral());
            if (r3.matches() == false) goto L19;
            boolean r4 = true;
            String r5 = r3.group(1);
            if ("x".equals(r5) == false) goto L11;
        L14:
            b r6 = new b(r4);
            Paragraph r8 = new Paragraph();
            r7.insertBefore(r6);
            String r9 = r3.group(2);
            if (TextUtils.isEmpty(r9) == true) goto L17;
            r8.appendChild(new Text(r9));
        L17:
            io.noties.markwon.g.e.a(r8, r1);
            r6.appendChild(r8);
            io.noties.markwon.g.e.a(r6, r0);
            r7.unlink();
            visitChildren(r6);
            return;
        L11:
            if ("X".equals(r5) == true) goto L14;
            r4 = false;
        L19:
            visitChildren(r7);
        }
    }

    d() {
    }

    @Override // org.commonmark.parser.PostProcessor
    public Node process(Node r2) {
        r2.accept(new a(null));
        return r2;
    }
}
