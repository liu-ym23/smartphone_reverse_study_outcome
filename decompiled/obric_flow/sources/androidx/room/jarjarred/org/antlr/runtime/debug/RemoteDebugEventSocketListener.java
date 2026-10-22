package androidx.room.jarjarred.org.antlr.runtime.debug;

import androidx.room.jarjarred.org.antlr.runtime.CharStream;
import androidx.room.jarjarred.org.antlr.runtime.RecognitionException;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.a;
import androidx.room.jarjarred.org.antlr.runtime.tree.BaseTree;
import androidx.room.jarjarred.org.antlr.runtime.tree.Tree;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes.dex */
public class RemoteDebugEventSocketListener implements Runnable {
    static final int MAX_EVENT_ELEMENTS = 8;
    Socket channel;
    String event;
    public String grammarFileName;

    /* JADX INFO: renamed from: in, reason: collision with root package name */
    BufferedReader f630in;
    DebugEventListener listener;
    String machine;
    PrintWriter out;
    int port;
    int previousTokenIndex;
    boolean tokenIndexesInvalid;
    public String version;

    public static class ProxyToken implements Token {
        int channel;
        int charPos;
        int index;
        int line;
        String text;
        int type;

        public ProxyToken(int r5) {
            this.index = r5;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.Token
        public int getChannel() {
            return this.channel;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.Token
        public int getCharPositionInLine() {
            return this.charPos;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.Token
        public CharStream getInputStream() {
            return null;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.Token
        public int getLine() {
            return this.line;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.Token
        public String getText() {
            return this.text;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.Token
        public int getTokenIndex() {
            return this.index;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.Token
        public int getType() {
            return this.type;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.Token
        public void setChannel(int r5) {
            this.channel = r5;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.Token
        public void setCharPositionInLine(int r5) {
            this.charPos = r5;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.Token
        public void setInputStream(CharStream r5) {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.Token
        public void setLine(int r5) {
            this.line = r5;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.Token
        public void setText(String r5) {
            this.text = r5;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.Token
        public void setTokenIndex(int r5) {
            this.index = r5;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.Token
        public void setType(int r5) {
            this.type = r5;
        }

        public String toString() {
            if (this.channel == 0) goto L5;
            String r5 = ",channel=" + this.channel;
        L6:
            StringBuilder r10 = new StringBuilder("[");
            r10.append(getText());
            r10.append("/<");
            a.D(r10, this.type, ">", r5, ",");
            r10.append(this.line);
            r10.append(":");
            r10.append(getCharPositionInLine());
            r10.append(",@");
            return androidx.constraintlayout.motion.widget.a.s(r10, this.index, "]");
        L5:
            r5 = "";
            goto L6
        }

        public ProxyToken(int r5, int r10, int r11, int r12, int r13, String r14) {
            this.index = r5;
            this.type = r10;
            this.channel = r11;
            this.line = r12;
            this.charPos = r13;
            this.text = r14;
        }
    }

    public static class ProxyTree extends BaseTree {
        public int ID;
        public int charPos;
        public int line;
        public String text;
        public int tokenIndex;
        public int type;

        public ProxyTree(int r5, int r10, int r11, int r12, int r13, String r14) {
            this.ID = r5;
            this.type = r10;
            this.line = r11;
            this.charPos = r12;
            this.tokenIndex = r13;
            this.text = r14;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
        public Tree dupNode() {
            return null;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
        public String getText() {
            return this.text;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
        public int getTokenStartIndex() {
            return this.tokenIndex;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
        public int getTokenStopIndex() {
            return 0;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
        public int getType() {
            return this.type;
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
        public void setTokenStartIndex(int r5) {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.tree.Tree
        public void setTokenStopIndex(int r5) {
        }

        @Override // androidx.room.jarjarred.org.antlr.runtime.tree.BaseTree, androidx.room.jarjarred.org.antlr.runtime.tree.Tree
        public String toString() {
            return "fix this";
        }

        public ProxyTree(int r5) {
            this.line = 0;
            this.charPos = -1;
            this.tokenIndex = -1;
            this.ID = r5;
        }
    }

    public RemoteDebugEventSocketListener(DebugEventListener r5, String r10, int r11) throws IOException {
        this.channel = null;
        this.previousTokenIndex = -1;
        this.tokenIndexesInvalid = false;
        this.listener = r5;
        this.machine = r10;
        this.port = r11;
        if (openConnection() == false) goto L6;
        return;
    L6:
        throw new ConnectException();
    }

    public void ack() {
        this.out.println("ack");
        this.out.flush();
    }

    public void closeConnection() {
        this.f630in.close();     // Catch: Throwable -> L18 Exception -> L20
        this.f630in = null;     // Catch: Throwable -> L18 Exception -> L20
        this.out.close();     // Catch: Throwable -> L18 Exception -> L20
        this.out = null;     // Catch: Throwable -> L18 Exception -> L20
        this.channel.close();     // Catch: Throwable -> L18 Exception -> L20
        this.channel = null;     // Catch: Throwable -> L18 Exception -> L20
        BufferedReader r5 = this.f630in;
        if (r5 != null) goto L62;
    L9:
        PrintWriter r10 = this.out;
        if (r10 == null) goto L12;
        r10.close();
    L12:
        Socket r11 = this.channel;
        if (r11 == null) goto L55;
        r11.close();     // Catch: IOException -> L16
    L55:
        return;
    L62:
        r5.close();     // Catch: IOException -> L7
    L7:
        e = move-exception;
        System.err.println(e);
        goto L9
    L20:
        e = move-exception;
        PrintStream r12 = System.err;     // Catch: Throwable -> L18
        r12.println(e);     // Catch: Throwable -> L18
        e.printStackTrace(r12);     // Catch: Throwable -> L18
        BufferedReader r13 = this.f630in;
        if (r13 != null) goto L60;
    L28:
        PrintWriter r14 = this.out;
        if (r14 == null) goto L31;
        r14.close();
    L31:
        Socket r15 = this.channel;
        if (r15 == null) goto L64;
        r15.close();     // Catch: IOException -> L16
        goto L55
    L64:
        return;
    L60:
        r13.close();     // Catch: IOException -> L26
    L26:
        e = move-exception;
        System.err.println(e);
    L16:
        e = move-exception;
        System.err.println(e);
        return;
    L18:
        th = move-exception;
        BufferedReader r16 = this.f630in;
        if (r16 != null) goto L51;
    L41:
        PrintWriter r17 = this.out;
        if (r17 == null) goto L44;
        r17.close();
    L44:
        Socket r18 = this.channel;
        if (r18 == null) goto L66;
        r18.close();     // Catch: IOException -> L48
        throw th;
    L48:
        e = move-exception;
        System.err.println(e);
        throw th;
    L66:
        throw th;
    L51:
        r16.close();     // Catch: IOException -> L39
    L39:
        e = move-exception;
        System.err.println(e);
        goto L41
    }

    public ProxyTree deserializeNode(String[] r10, int r11) {
        return new ProxyTree(Integer.parseInt(r10[r11]), Integer.parseInt(r10[r11 + 1]), Integer.parseInt(r10[r11 + 2]), Integer.parseInt(r10[r11 + 3]), Integer.parseInt(r10[r11 + 4]), unEscapeNewlines(r10[r11 + 5]));
    }

    public ProxyToken deserializeToken(String[] r13, int r14) {
        String r5 = r13[r14];
        String r10 = r13[r14 + 1];
        String r11 = r13[r14 + 2];
        String r12 = r13[r14 + 3];
        String r15 = r13[r14 + 4];
        String r16 = unEscapeNewlines(r13[r14 + 5]);
        return new ProxyToken(Integer.parseInt(r5), Integer.parseInt(r10), Integer.parseInt(r11), Integer.parseInt(r12), Integer.parseInt(r15), r16);
    }

    public void dispatch(String r15) {
        String[] r5 = getEventElements(r15);
        if (r5 == null) goto L119;
        boolean r10 = false;
        String r11 = r5[0];
        if (r11 == null) goto L119;
        if (r11.equals("enterRule") == false) goto L11;
        this.listener.enterRule(r5[1], r5[2]);
        return;
    L11:
        if (r5[0].equals("exitRule") == false) goto L14;
        this.listener.exitRule(r5[1], r5[2]);
        return;
    L14:
        if (r5[0].equals("enterAlt") == false) goto L17;
        this.listener.enterAlt(Integer.parseInt(r5[1]));
        return;
    L17:
        if (r5[0].equals("enterSubRule") == false) goto L20;
        this.listener.enterSubRule(Integer.parseInt(r5[1]));
        return;
    L20:
        if (r5[0].equals("exitSubRule") == false) goto L23;
        this.listener.exitSubRule(Integer.parseInt(r5[1]));
        return;
    L23:
        if (r5[0].equals("enterDecision") == false) goto L26;
        this.listener.enterDecision(Integer.parseInt(r5[1]), r5[2].equals("true"));
        return;
    L26:
        if (r5[0].equals("exitDecision") == false) goto L29;
        this.listener.exitDecision(Integer.parseInt(r5[1]));
        return;
    L29:
        if (r5[0].equals("location") == false) goto L32;
        this.listener.location(Integer.parseInt(r5[1]), Integer.parseInt(r5[2]));
        return;
    L32:
        if (r5[0].equals("consumeToken") == false) goto L38;
        ProxyToken r16 = deserializeToken(r5, 1);
        if (r16.getTokenIndex() != this.previousTokenIndex) goto L36;
        this.tokenIndexesInvalid = true;
    L36:
        this.previousTokenIndex = r16.getTokenIndex();
        this.listener.consumeToken(r16);
        return;
    L38:
        if (r5[0].equals("consumeHiddenToken") == false) goto L44;
        ProxyToken r17 = deserializeToken(r5, 1);
        if (r17.getTokenIndex() != this.previousTokenIndex) goto L42;
        this.tokenIndexesInvalid = true;
    L42:
        this.previousTokenIndex = r17.getTokenIndex();
        this.listener.consumeHiddenToken(r17);
        return;
    L44:
        if (r5[0].equals("LT") == false) goto L47;
        this.listener.LT(Integer.parseInt(r5[1]), deserializeToken(r5, 2));
        return;
    L47:
        if (r5[0].equals("mark") == false) goto L50;
        this.listener.mark(Integer.parseInt(r5[1]));
        return;
    L50:
        if (r5[0].equals("rewind") == false) goto L56;
        String r18 = r5[1];
        if (r18 == null) goto L54;
        this.listener.rewind(Integer.parseInt(r18));
        return;
    L54:
        this.listener.rewind();
        return;
    L56:
        if (r5[0].equals("beginBacktrack") == false) goto L59;
        this.listener.beginBacktrack(Integer.parseInt(r5[1]));
        return;
    L59:
        if (r5[0].equals("endBacktrack") == false) goto L65;
        int r19 = Integer.parseInt(r5[1]);
        int r12 = Integer.parseInt(r5[2]);
        DebugEventListener r14 = this.listener;
        if (r12 != 1) goto L63;
        r10 = true;
    L63:
        r14.endBacktrack(r19, r10);
        return;
    L65:
        if (r5[0].equals("exception") == false) goto L79;
        String r110 = r5[1];
        String r13 = r5[2];
        String r20 = r5[3];
        String r21 = r5[4];
        RecognitionException r111 = (RecognitionException) Class.forName(r110).asSubclass(RecognitionException.class).newInstance();     // Catch: IllegalAccessException -> L69 InstantiationException -> L71 ClassNotFoundException -> L73
        r111.index = Integer.parseInt(r13);     // Catch: IllegalAccessException -> L69 InstantiationException -> L71 ClassNotFoundException -> L73
        r111.line = Integer.parseInt(r20);     // Catch: IllegalAccessException -> L69 InstantiationException -> L71 ClassNotFoundException -> L73
        r111.charPositionInLine = Integer.parseInt(r21);     // Catch: IllegalAccessException -> L69 InstantiationException -> L71 ClassNotFoundException -> L73
        this.listener.recognitionException(r111);     // Catch: IllegalAccessException -> L69 InstantiationException -> L71 ClassNotFoundException -> L73
    L155:
        return;
    L73:
        e = move-exception;
        PrintStream r112 = System.err;
        r112.println("can't find class " + e);
        e.printStackTrace(r112);
        return;
    L69:
        e = move-exception;
        PrintStream r113 = System.err;
        r113.println("can't access class " + e);
        e.printStackTrace(r113);
        return;
    L71:
        e = move-exception;
        PrintStream r114 = System.err;
        r114.println("can't instantiate class " + e);
        e.printStackTrace(r114);
        return;
    L79:
        if (r5[0].equals("beginResync") == false) goto L82;
        this.listener.beginResync();
        return;
    L82:
        if (r5[0].equals("endResync") == false) goto L85;
        this.listener.endResync();
        return;
    L85:
        if (r5[0].equals("terminate") == false) goto L88;
        this.listener.terminate();
        return;
    L88:
        if (r5[0].equals("semanticPredicate") == false) goto L91;
        Boolean r115 = Boolean.valueOf(r5[1]);
        this.listener.semanticPredicate(r115.booleanValue(), unEscapeNewlines(r5[2]));
        return;
    L91:
        if (r5[0].equals("consumeNode") == false) goto L94;
        this.listener.consumeNode(deserializeNode(r5, 1));
        return;
    L94:
        if (r5[0].equals("LN") == false) goto L97;
        this.listener.LT(Integer.parseInt(r5[1]), deserializeNode(r5, 2));
        return;
    L97:
        if (r5[0].equals("createNodeFromTokenElements") == false) goto L100;
        this.listener.createNode(new ProxyTree(Integer.parseInt(r5[1]), Integer.parseInt(r5[2]), -1, -1, -1, unEscapeNewlines(r5[3])));
        return;
    L100:
        if (r5[0].equals("createNode") == false) goto L103;
        int r116 = Integer.parseInt(r5[1]);
        int r22 = Integer.parseInt(r5[2]);
        this.listener.createNode(new ProxyTree(r116), new ProxyToken(r22));
        return;
    L103:
        if (r5[0].equals("nilNode") == false) goto L106;
        this.listener.nilNode(new ProxyTree(Integer.parseInt(r5[1])));
        return;
    L106:
        if (r5[0].equals("errorNode") == false) goto L109;
        this.listener.errorNode(new ProxyTree(Integer.parseInt(r5[1]), Integer.parseInt(r5[2]), -1, -1, -1, unEscapeNewlines(r5[3])));
        return;
    L109:
        if (r5[0].equals("becomeRoot") == false) goto L112;
        int r117 = Integer.parseInt(r5[1]);
        int r23 = Integer.parseInt(r5[2]);
        this.listener.becomeRoot(new ProxyTree(r117), new ProxyTree(r23));
        return;
    L112:
        if (r5[0].equals("addChild") == false) goto L115;
        int r118 = Integer.parseInt(r5[1]);
        int r24 = Integer.parseInt(r5[2]);
        this.listener.addChild(new ProxyTree(r118), new ProxyTree(r24));
        return;
    L115:
        if (r5[0].equals("setTokenBoundaries") == false) goto L117;
        this.listener.setTokenBoundaries(new ProxyTree(Integer.parseInt(r5[1])), Integer.parseInt(r5[2]), Integer.parseInt(r5[3]));
        return;
    L117:
        System.err.println("unknown debug event: " + r15);
        return;
    L119:
        System.err.println("unknown debug event: " + r15);
    }

    public void eventHandler() {
        handshake();     // Catch: Throwable -> L7 Exception -> L9
        this.event = this.f630in.readLine();     // Catch: Throwable -> L7 Exception -> L9
    L3:
        String r5 = this.event;     // Catch: Throwable -> L7 Exception -> L9
        if (r5 == null) goto L11;
        dispatch(r5);     // Catch: Throwable -> L7 Exception -> L9
        ack();     // Catch: Throwable -> L7 Exception -> L9
        this.event = this.f630in.readLine();     // Catch: Throwable -> L7 Exception -> L9
    L11:
        closeConnection();
        return;
    L9:
        e = move-exception;
        PrintStream r10 = System.err;     // Catch: Throwable -> L7
        r10.println(e);     // Catch: Throwable -> L7
        e.printStackTrace(r10);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        closeConnection();
        throw th;
    }

    public String[] getEventElements(String r10) {
        String r11 = null;
        if (r10 != null) goto L5;
        return null;
    L5:
        String[] r5 = new String[8];
        int r12 = r10.indexOf(34);     // Catch: Exception -> L9
        int r13 = 0;
        if (r12 < 0) goto L11;
        String r14 = r10.substring(0, r12);     // Catch: Exception -> L9
        String r15 = r10.substring(r12 + 1, r10.length());     // Catch: Exception -> L9
        r10 = r14;
        r11 = r15;
    L11:
        StringTokenizer r16 = new StringTokenizer(r10, Profiler.DATA_SEP, false);     // Catch: Exception -> L9
    L13:
        if (r16.hasMoreTokens() == false) goto L17;
        if (r13 >= 8) goto L15;
        r5[r13] = r16.nextToken();     // Catch: Exception -> L9
        r13 = r13 + 1;     // Catch: Exception -> L9
        goto L13
    L15:
        return r5;
    L17:
        if (r11 == null) goto L21;
        r5[r13] = r11;     // Catch: Exception -> L9
    L21:
        return r5;
    L9:
        e = move-exception;
        e.printStackTrace(System.err);
        goto L21
    }

    public void handshake() throws IOException {
        this.version = getEventElements(this.f630in.readLine())[1];
        this.grammarFileName = getEventElements(this.f630in.readLine())[1];
        ack();
        this.listener.commence();
    }

    public boolean openConnection() {
        Socket r5 = new Socket(this.machine, this.port);     // Catch: Exception -> L5
        this.channel = r5;     // Catch: Exception -> L5
        r5.setTcpNoDelay(true);     // Catch: Exception -> L5
        this.out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.channel.getOutputStream(), "UTF8")));     // Catch: Exception -> L5
        this.f630in = new BufferedReader(new InputStreamReader(this.channel.getInputStream(), "UTF8"));     // Catch: Exception -> L5
        return true;
    L5:
        e = move-exception;
        System.err.println(e);
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        eventHandler();
    }

    public void start() {
        new Thread(this).start();
    }

    public boolean tokenIndexesAreInvalid() {
        return false;
    }

    public String unEscapeNewlines(String r5) {
        return r5.replaceAll("%0A", "\n").replaceAll("%0D", "\r").replaceAll("%25", "%");
    }
}
