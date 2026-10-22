package androidx.room.jarjarred.org.antlr.runtime.debug;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.jarjarred.org.antlr.runtime.BaseRecognizer;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeAdaptor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/* JADX INFO: loaded from: classes.dex */
public class DebugEventSocketProxy extends BlankDebugEventListener {
    public static final int DEFAULT_DEBUGGER_PORT = 49100;
    protected TreeAdaptor adaptor;
    protected String grammarFileName;

    /* JADX INFO: renamed from: in, reason: collision with root package name */
    protected BufferedReader f627in;
    protected PrintWriter out;
    protected int port;
    protected BaseRecognizer recognizer;
    protected ServerSocket serverSocket;
    protected Socket socket;

    public DebugEventSocketProxy(BaseRecognizer r5, TreeAdaptor r10) {
        this(r5, DEFAULT_DEBUGGER_PORT, r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void LT(int r5, Token r10) {
        if (r10 == null) goto L5;
        StringBuilder r11 = j0.s(r5, "LT\t", Profiler.DATA_SEP);
        r11.append(serializeToken(r10));
        transmit(r11.toString());
        return;
    }

    public void ack() {
        this.f627in.readLine();     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace(System.err);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void addChild(Object r5, Object r10) {
        transmit("addChild\t" + this.adaptor.getUniqueID(r5) + Profiler.DATA_SEP + this.adaptor.getUniqueID(r10));
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void becomeRoot(Object r5, Object r10) {
        transmit("becomeRoot\t" + this.adaptor.getUniqueID(r5) + Profiler.DATA_SEP + this.adaptor.getUniqueID(r10));
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void beginBacktrack(int r5) {
        transmit("beginBacktrack\t" + r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void beginResync() {
        transmit("beginResync");
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void commence() {
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void consumeHiddenToken(Token r5) {
        transmit("consumeHiddenToken\t" + serializeToken(r5));
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void consumeNode(Object r5) {
        StringBuffer r10 = new StringBuffer(50);
        r10.append("consumeNode");
        serializeNode(r10, r5);
        transmit(r10.toString());
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void consumeToken(Token r5) {
        transmit("consumeToken\t" + serializeToken(r5));
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void createNode(Object r5) {
        int r10 = this.adaptor.getUniqueID(r5);
        String r11 = this.adaptor.getText(r5);
        int r12 = this.adaptor.getType(r5);
        StringBuffer r13 = new StringBuffer(50);
        r13.append("createNodeFromTokenElements\t");
        r13.append(r10);
        r13.append(Profiler.DATA_SEP);
        r13.append(r12);
        serializeText(r13, r11);
        transmit(r13.toString());
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void endBacktrack(int r5, boolean r10) {
        transmit("endBacktrack\t" + r5 + Profiler.DATA_SEP + (r10 ? 1 : 0));
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void endResync() {
        transmit("endResync");
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void enterAlt(int r5) {
        transmit("enterAlt\t" + r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void enterDecision(int r5, boolean r10) {
        transmit("enterDecision\t" + r5 + Profiler.DATA_SEP + r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void enterRule(String r5, String r10) {
        transmit("enterRule\t" + r5 + Profiler.DATA_SEP + r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void enterSubRule(int r5) {
        transmit("enterSubRule\t" + r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void errorNode(Object r5) {
        int r10 = this.adaptor.getUniqueID(r5);
        String r11 = r5.toString();
        StringBuffer r12 = new StringBuffer(50);
        r12.append("errorNode\t");
        r12.append(r10);
        r12.append("\t0");
        serializeText(r12, r11);
        transmit(r12.toString());
    }

    public String escapeNewlines(String r5) {
        return r5.replaceAll("%", "%25").replaceAll("\n", "%0A").replaceAll("\r", "%0D");
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void exitDecision(int r5) {
        transmit("exitDecision\t" + r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void exitRule(String r5, String r10) {
        transmit("exitRule\t" + r5 + Profiler.DATA_SEP + r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void exitSubRule(int r5) {
        transmit("exitSubRule\t" + r5);
    }

    public TreeAdaptor getTreeAdaptor() {
        return this.adaptor;
    }

    public void handshake() throws IOException {
        if (this.serverSocket != null) goto L6;
        ServerSocket r5 = new ServerSocket(this.port);
        this.serverSocket = r5;
        Socket r10 = r5.accept();
        this.socket = r10;
        r10.setTcpNoDelay(true);
        this.out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream(), "UTF8")));
        this.f627in = new BufferedReader(new InputStreamReader(this.socket.getInputStream(), "UTF8"));
        this.out.println("ANTLR 2");
        this.out.println("grammar \"" + this.grammarFileName);
        this.out.flush();
        ack();
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void location(int r5, int r10) {
        transmit("location\t" + r5 + Profiler.DATA_SEP + r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void mark(int r5) {
        transmit("mark\t" + r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void nilNode(Object r5) {
        transmit("nilNode\t" + this.adaptor.getUniqueID(r5));
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void recognitionException(RecognitionException r5) {
        StringBuilder r10 = a.x(50, "exception\t");
        r10.append(r5.getClass().getName());
        r10.append(Profiler.DATA_SEP);
        r10.append(r5.index);
        r10.append(Profiler.DATA_SEP);
        r10.append(r5.line);
        r10.append(Profiler.DATA_SEP);
        r10.append(r5.charPositionInLine);
        transmit(r10.toString());
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void rewind(int r5) {
        transmit("rewind\t" + r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void semanticPredicate(boolean r5, String r10) {
        StringBuffer r11 = new StringBuffer(50);
        r11.append("semanticPredicate\t");
        r11.append(r5);
        serializeText(r11, r10);
        transmit(r11.toString());
    }

    public void serializeNode(StringBuffer r5, Object r10) {
        int r11 = this.adaptor.getUniqueID(r10);
        String r12 = this.adaptor.getText(r10);
        int r13 = this.adaptor.getType(r10);
        r5.append(Profiler.DATA_SEP);
        r5.append(r11);
        r5.append(Profiler.DATA_SEP);
        r5.append(r13);
        Token r14 = this.adaptor.getToken(r10);
        if (r14 == null) goto L5;
        int r15 = r14.getLine();
        int r16 = r14.getCharPositionInLine();
    L6:
        r5.append(Profiler.DATA_SEP);
        r5.append(r15);
        r5.append(Profiler.DATA_SEP);
        r5.append(r16);
        int r17 = this.adaptor.getTokenStartIndex(r10);
        r5.append(Profiler.DATA_SEP);
        r5.append(r17);
        serializeText(r5, r12);
        return;
    L5:
        r15 = -1;
        r16 = -1;
        goto L6
    }

    public void serializeText(StringBuffer r5, String r10) {
        r5.append("\t\"");
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        r5.append(escapeNewlines(r10));
    }

    public String serializeToken(Token r5) {
        StringBuffer r10 = new StringBuffer(50);
        r10.append(r5.getTokenIndex());
        r10.append('\t');
        r10.append(r5.getType());
        r10.append('\t');
        r10.append(r5.getChannel());
        r10.append('\t');
        r10.append(r5.getLine());
        r10.append('\t');
        r10.append(r5.getCharPositionInLine());
        serializeText(r10, r5.getText());
        return r10.toString();
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void setTokenBoundaries(Object r5, int r10, int r11) {
        StringBuilder r12 = j0.v("setTokenBoundaries\t", this.adaptor.getUniqueID(r5), r10, Profiler.DATA_SEP, Profiler.DATA_SEP);
        r12.append(r11);
        transmit(r12.toString());
    }

    public void setTreeAdaptor(TreeAdaptor r5) {
        this.adaptor = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void terminate() {
        transmit("terminate");
        this.out.close();
        this.socket.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace(System.err);
    }

    public void transmit(String r5) {
        this.out.println(r5);
        this.out.flush();
        ack();
    }

    public DebugEventSocketProxy(BaseRecognizer r5, int r10, TreeAdaptor r11) {
        this.port = DEFAULT_DEBUGGER_PORT;
        this.grammarFileName = r5.getGrammarFileName();
        this.adaptor = r11;
        this.port = r10;
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void rewind() {
        transmit("rewind");
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void LT(int r5, Object r10) {
        this.adaptor.getUniqueID(r10);
        this.adaptor.getText(r10);
        this.adaptor.getType(r10);
        StringBuffer r11 = new StringBuffer(50);
        r11.append("LN\t");
        r11.append(r5);
        serializeNode(r11, r10);
        transmit(r11.toString());
    }

    @Override // androidx.room.jarjarred.org.antlr.runtime.debug.BlankDebugEventListener, androidx.room.jarjarred.org.antlr.runtime.debug.DebugEventListener
    public void createNode(Object r5, Token r10) {
        transmit("createNode\t" + this.adaptor.getUniqueID(r5) + Profiler.DATA_SEP + r10.getTokenIndex());
    }
}
