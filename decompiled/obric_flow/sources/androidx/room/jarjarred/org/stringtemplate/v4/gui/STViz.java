package androidx.room.jarjarred.org.stringtemplate.v4.gui;

import ai.j0;
import androidx.room.jarjarred.kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
import androidx.room.jarjarred.org.antlr.runtime.tree.CommonTreeAdaptor;
import androidx.room.jarjarred.org.stringtemplate.v4.InstanceScope;
import androidx.room.jarjarred.org.stringtemplate.v4.Interpreter;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroupFile;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroupString;
import androidx.room.jarjarred.org.stringtemplate.v4.debug.EvalExprEvent;
import androidx.room.jarjarred.org.stringtemplate.v4.debug.EvalTemplateEvent;
import androidx.room.jarjarred.org.stringtemplate.v4.debug.InterpEvent;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.ErrorManager;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.Interval;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.Misc;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.STMessage;
import com.bytedance.ies.bullet.lynx.impl.LynxErrorCode;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JEditorPane;
import javax.swing.border.Border;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

/* JADX INFO: loaded from: classes.dex */
public class STViz {
    protected static final String WINDOWS_LINE_ENDINGS = "WINDOWS_LINE_ENDINGS";
    public List<InterpEvent> allEvents;
    public InterpEvent currentEvent;
    public InstanceScope currentScope;
    public ErrorManager errMgr;
    public List<STMessage> errors;
    public Interpreter interp;
    public String output;
    public EvalTemplateEvent root;
    public JTreeSTModel tmodel;
    public List<String> trace;
    private final AtomicInteger updateDepth;
    public STViewFrame viewFrame;

    public STViz(ErrorManager r5, EvalTemplateEvent r10, String r11, Interpreter r12, List<String> r13, List<STMessage> r14) {
        this.updateDepth = new AtomicInteger();
        this.errMgr = r5;
        this.currentEvent = r10;
        this.currentScope = r10.scope;
        this.output = r11;
        this.interp = r12;
        this.allEvents = r12.getEvents();
        this.trace = r13;
        this.errors = r14;
    }

    public static /* synthetic */ AtomicInteger access$000(STViz r5) {
        return r5.updateDepth;
    }

    public static /* synthetic */ void access$100(STViz r5, STViewFrame r10) {
        r5.updateCurrentST(r10);
    }

    public static void main(String[] r5) throws IOException {
        if (r5.length <= 0) goto L8;
        if (r5[0].equals(IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST) == false) goto L8;
        test1();
        return;
    L8:
        if (r5.length <= 0) goto L13;
        if (r5[0].equals("2") == false) goto L13;
        test2();
        return;
    L13:
        if (r5.length <= 0) goto L18;
        if (r5[0].equals("3") == false) goto L18;
        test3();
        return;
    L18:
        if (r5.length > 0) goto L20;
        return;
    L20:
        if (r5[0].equals("4") == false) goto L27;
        test4();
        return;
    }

    public static void test1() throws IOException {
        String r5 = System.getProperty("java.io.tmpdir");
        writeFile(r5, "t.stg", "method(type,name,locals,args,stats) ::= <<\npublic <type> <name>(<args:{a| int <a>}; separator=\", \">) {\n    <if(locals)>int locals[<locals>];<endif>\n    <stats;separator=\"\\n\">\n}\n>>\nassign(a,b) ::= \"<a> = <b>;\"\nreturn(x) ::= <<return <x>;>>\nparen(x) ::= \"(<x>)\"\n");
        STGroupFile r10 = new STGroupFile(j0.j(r5, "/t.stg"));
        ST r11 = r10.getInstanceOf("method");
        r11.impl.dump();
        r11.add("type", "float");
        r11.add("name", "foo");
        r11.add("locals", 3);
        r11.add("args", new String[]{"x", "y", "z"});
        ST r12 = r10.getInstanceOf("assign");
        ST r13 = r10.getInstanceOf("paren");
        r13.add("x", "x");
        r12.add("a", r13);
        r12.add("b", "y");
        ST r14 = r10.getInstanceOf("assign");
        r14.add("a", "y");
        r14.add("b", "z");
        ST r15 = r10.getInstanceOf("return");
        r15.add("x", "3.14159");
        r11.add("stats", r12);
        r11.add("stats", r14);
        r11.add("stats", r15);
        r11.inspect();
        System.out.println(r11.render());
    }

    public static void test2() throws IOException {
        String r5 = System.getProperty("java.io.tmpdir");
        writeFile(r5, "t.stg", "t1(q1=\"Some\\nText\") ::= <<\n<q1>\n>>\n\nt2(p1) ::= <<\n<p1>\n>>\n\nmain() ::= <<\nSTART-<t1()>-END\n\nSTART-<t2(p1=\"Some\\nText\")>-END\n>>\n");
        new STGroupFile(j0.j(r5, "/t.stg")).getInstanceOf(JvmProtoBufUtil.DEFAULT_MODULE_NAME).inspect();
    }

    public static void test3() throws IOException {
        String r5 = System.getProperty("java.io.tmpdir");
        writeFile(r5, "t.stg", "main() ::= <<\nFoo: <{bar};format=\"lower\">\n>>\n");
        new STGroupFile(j0.j(r5, "/t.stg")).getInstanceOf(JvmProtoBufUtil.DEFAULT_MODULE_NAME).inspect();
    }

    public static void test4() throws IOException {
        STGroupString r5 = new STGroupString("main(t) ::= <<\nhi: <t>\n>>\nfoo(x,y={hi}) ::= \"<bar(x,y)>\"\nbar(x,y) ::= << <y> >>\nignore(m) ::= \"<m>\"\n");
        ST r10 = r5.getInstanceOf(JvmProtoBufUtil.DEFAULT_MODULE_NAME);
        ST r11 = r5.getInstanceOf("foo");
        r10.add("t", r11);
        r5.getInstanceOf("ignore").add("m", r11);
        r10.inspect();
        r10.render();
    }

    private void updateCurrentST(STViewFrame r5) {
        updateStack(this.currentScope, r5);
        updateAttributes(this.currentScope, r5);
        setText(r5.bytecode, this.currentScope.f675st.impl.disasm());
        setText(r5.template, this.currentScope.f675st.impl.template);
        JTreeASTModel r10 = new JTreeASTModel(new CommonTreeAdaptor(), this.currentScope.f675st.impl.ast);
        this.viewFrame.ast.setModel(r10);
        InterpEvent r11 = this.currentEvent;
        if ((r11 instanceof EvalExprEvent) == false) goto L6;
        EvalExprEvent r12 = (EvalExprEvent) r11;
        highlight(r5.output, r12.outputStartChar, r12.outputStopChar);
        highlight(r5.template, r12.exprStartChar, r12.exprStopChar);
        return;
    L6:
        if ((r11 instanceof EvalTemplateEvent) == false) goto L8;
        EvalTemplateEvent r13 = (EvalTemplateEvent) r11;
    L9:
        if (r13 == null) goto L12;
        highlight(r5.output, r13.outputStartChar, r13.outputStopChar);
    L12:
        if (this.currentScope.f675st.isAnonSubtemplate() == false) goto L16;
        Interval r14 = this.currentScope.f675st.impl.getTemplateRange();
        highlight(r5.template, r14.f683a, r14.f684b);
        return;
    L16:
        return;
    L8:
        r13 = (EvalTemplateEvent) j0.e(this.currentScope.events, 1);
        goto L9
    }

    public static void writeFile(String r5, String r10, String r11) {
        File r12 = new File(r5, r10);     // Catch: IOException -> L5
        if (r12.getParentFile().exists() == true) goto L7;
        r12.getParentFile().mkdirs();     // Catch: IOException -> L5
    L7:
        FileWriter r13 = new FileWriter(r12);     // Catch: IOException -> L5
        BufferedWriter r14 = new BufferedWriter(r13);     // Catch: IOException -> L5
        r14.write(r11);     // Catch: IOException -> L5
        r14.close();     // Catch: IOException -> L5
        r13.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        PrintStream r15 = System.err;
        r15.println("can't write file");
        e.printStackTrace(r15);
    }

    public InterpEvent findEventAtOutputLocation(List<InterpEvent> r5, int r10) {
        Iterator<InterpEvent> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L13;
        InterpEvent r12 = r11.next();
        if (r12.scope.earlyEval == true) goto L4;
        if (r10 < r12.outputStartChar) goto L4;
        if (r10 > r12.outputStopChar) goto L4;
        return r12;
    L13:
        return null;
    }

    public final void highlight(JTextComponent r5, int r10, int r11) {
        highlight(r5, r10, r11, true);
    }

    public void open() {
        STViewFrame r5 = new STViewFrame();
        this.viewFrame = r5;
        updateStack(this.currentScope, r5);
        updateAttributes(this.currentScope, this.viewFrame);
        List<InterpEvent> r10 = this.currentScope.events;
        JTreeSTModel r11 = new JTreeSTModel(this.interp, (EvalTemplateEvent) j0.e(r10, 1));
        this.tmodel = r11;
        this.viewFrame.tree.setModel(r11);
        this.viewFrame.tree.addTreeSelectionListener(new AnonymousClass1(this));
        JTreeASTModel r12 = new JTreeASTModel(new CommonTreeAdaptor(), this.currentScope.f675st.impl.ast);
        this.viewFrame.ast.setModel(r12);
        this.viewFrame.ast.addTreeSelectionListener(new AnonymousClass2(this));
        CaretListener r13 = new AnonymousClass3(this);
        this.viewFrame.output.addCaretListener(r13);
        List<STMessage> r14 = this.errors;
        if (r14 != null) goto L5;
    L12:
        this.viewFrame.errorScrollPane.setVisible(false);
    L13:
        this.viewFrame.errorList.addListSelectionListener(new AnonymousClass4(this));
        Border r15 = BorderFactory.createEmptyBorder();
        this.viewFrame.treeContentSplitPane.setBorder(r15);
        this.viewFrame.outputTemplateSplitPane.setBorder(r15);
        this.viewFrame.templateBytecodeTraceTabPanel.setBorder(r15);
        this.viewFrame.treeAttributesSplitPane.setBorder(r15);
        this.viewFrame.treeContentSplitPane.setOneTouchExpandable(true);
        this.viewFrame.outputTemplateSplitPane.setOneTouchExpandable(true);
        this.viewFrame.treeContentSplitPane.setDividerSize(10);
        this.viewFrame.outputTemplateSplitPane.setDividerSize(8);
        this.viewFrame.treeContentSplitPane.setContinuousLayout(true);
        this.viewFrame.treeAttributesSplitPane.setContinuousLayout(true);
        this.viewFrame.outputTemplateSplitPane.setContinuousLayout(true);
        this.viewFrame.setDefaultCloseOperation(2);
        this.viewFrame.pack();
        this.viewFrame.setSize(LynxErrorCode.LYNX_ERROR_CODE_MODULE_NOT_EXIST, 700);
        setText(this.viewFrame.output, this.output);
        setText(this.viewFrame.template, this.currentScope.f675st.impl.template);
        setText(this.viewFrame.bytecode, this.currentScope.f675st.impl.disasm());
        setText(this.viewFrame.trace, Misc.join(this.trace.iterator(), "\n"));
        this.viewFrame.setVisible(true);
        return;
    L5:
        if (r14.size() == 0) goto L12;
        DefaultListModel r16 = new DefaultListModel();
        Iterator<STMessage> r17 = this.errors.iterator();
    L9:
        if (r17.hasNext() == false) goto L11;
        r16.addElement(r17.next());
        goto L9
    L11:
        this.viewFrame.errorList.setModel(r16);
        goto L13
    }

    public void setText(JEditorPane r5, String r10) {
        ArrayList r11 = new ArrayList();
        int r12 = 0;
        int r13 = 0;
    L4:
        if (r13 >= r10.length()) goto L9;
        int r14 = r10.indexOf("\r\n", r13);
        if (r14 < 0) goto L9;
        r13 = j0.d(r14, r11, r14, 2);
    L9:
        int[] r15 = new int[r11.size()];
    L11:
        if (r12 >= r11.size()) goto L13;
        r15[r12] = ((Integer) r11.get(r12)).intValue();
        r12 = r12 + 1;
        goto L11
    L13:
        r5.setText(r10);
        r5.getDocument().putProperty(WINDOWS_LINE_ENDINGS, r15);
    }

    public int toComponentPosition(JTextComponent r5, int r10) {
        int[] r11 = (int[]) r5.getDocument().getProperty(WINDOWS_LINE_ENDINGS);
        if (r11 != null) goto L5;
        return r10;
    L5:
        if (r11.length == 0) goto L14;
        int r12 = Arrays.binarySearch(r11, r10);
        if (r12 < 0) goto L12;
        return r10 - r12;
    L12:
        return r10 - ((-r12) - 1);
    L14:
        return r10;
    }

    public int toEventPosition(JTextComponent r5, int r10) {
        int r11 = r10;
    L4:
        if (toComponentPosition(r5, r11) >= r10) goto L6;
        r11 = r11 + 1;
        goto L4
    L6:
        return r11;
    }

    public void updateAttributes(InstanceScope r5, STViewFrame r10) {
        r10.attributes.setModel(new JTreeScopeStackModel(r5));
        r10.attributes.setRootVisible(false);
        r10.attributes.setShowsRootHandles(true);
    }

    public void updateStack(InstanceScope r5, STViewFrame r10) {
        r10.setTitle("STViz - [" + Misc.join(Interpreter.getEnclosingInstanceStack(r5, true).iterator(), " ") + "]");
    }

    public void waitForClose() throws InterruptedException {
        final Object r5 = new Object();
        Thread r10 = new AnonymousClass5(this, r5);
        r10.start();
        this.viewFrame.addWindowListener(new AnonymousClass6(this, r5));
        r10.join();
    }

    public void highlight(JTextComponent r5, int r10, int r11, boolean r12) {
        Highlighter r13 = r5.getHighlighter();
        r13.removeAllHighlights();
        int r14 = toComponentPosition(r5, r10);     // Catch: BadLocationException -> L10
        int r15 = toComponentPosition(r5, r11);     // Catch: BadLocationException -> L10
        r13.addHighlight(r14, r15 + 1, DefaultHighlighter.DefaultPainter);     // Catch: BadLocationException -> L10
        if (r12 == true) goto L6;
        return;
    L6:
        if (r5.getCaretPosition() >= r14) goto L8;
    L12:
        r5.moveCaretPosition(r14);     // Catch: BadLocationException -> L10
        r5.scrollRectToVisible(r5.modelToView(r14));     // Catch: BadLocationException -> L10
        return;
    L8:
        if (r5.getCaretPosition() > r15) goto L12;
        return;
    L10:
        e = move-exception;
        this.errMgr.internalError(this.tmodel.root.event.scope.f675st, "bad highlight location", e);
    }
}
