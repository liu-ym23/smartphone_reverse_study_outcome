package androidx.room.jarjarred.org.antlr.v4.runtime;

import ai.j0;
import androidx.room.jarjarred.org.antlr.runtime.debug.Profiler;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATN;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ATNSimulator;
import androidx.room.jarjarred.org.antlr.v4.runtime.atn.ParseInfo;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Utils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class Recognizer<Symbol, ATNInterpreter extends ATNSimulator> {
    public static final int EOF = -1;
    private static final Map<String[], Map<String, Integer>> ruleIndexMapCache = null;
    private static final Map<Vocabulary, Map<String, Integer>> tokenTypeMapCache = null;
    protected ATNInterpreter _interp;
    private List<ANTLRErrorListener> _listeners;
    private int _stateNumber;

    static {
        tokenTypeMapCache = new WeakHashMap();
        ruleIndexMapCache = new WeakHashMap();
    }

    public Recognizer() {
        this._listeners = new AnonymousClass1(this);
        this._stateNumber = -1;
    }

    public void action(RuleContext r5, int r10, int r11) {
    }

    public void addErrorListener(ANTLRErrorListener r5) {
        if (r5 == null) goto L6;
        this._listeners.add(r5);
        return;
    L6:
        throw new NullPointerException("listener cannot be null.");
    }

    public abstract ATN getATN();

    public String getErrorHeader(RecognitionException r5) {
        return j0.f(r5.getOffendingToken().getLine(), r5.getOffendingToken().getCharPositionInLine(), "line ", ":");
    }

    public ANTLRErrorListener getErrorListenerDispatch() {
        return new ProxyErrorListener(getErrorListeners());
    }

    public List<? extends ANTLRErrorListener> getErrorListeners() {
        return this._listeners;
    }

    public abstract String getGrammarFileName();

    public abstract IntStream getInputStream();

    public ATNInterpreter getInterpreter() {
        return this._interp;
    }

    public ParseInfo getParseInfo() {
        return null;
    }

    public Map<String, Integer> getRuleIndexMap() {
        String[] r5 = getRuleNames();
        if (r5 == null) goto L16;
        Map<String[], Map<String, Integer>> r10 = ruleIndexMapCache;
        monitor-enter(r10);
        Map<String, Integer> r11 = r10.get(r5);     // Catch: Throwable -> L9
        if (r11 != null) goto L11;
        r11 = Collections.unmodifiableMap(Utils.toMap(r5));     // Catch: Throwable -> L9
        r10.put(r5, r11);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r10);     // Catch: Throwable -> L9
        return r11;
    L9:
        th = move-exception;
        throw th;
    L16:
        throw new UnsupportedOperationException("The current recognizer does not provide a list of rule names.");
    }

    public abstract String[] getRuleNames();

    public String getSerializedATN() {
        throw new UnsupportedOperationException("there is no serialized ATN");
    }

    public final int getState() {
        return this._stateNumber;
    }

    @Deprecated
    public String getTokenErrorDisplay(Token r5) {
        if (r5 != null) goto L5;
        return "<no token>";
    L5:
        String r10 = r5.getText();
        if (r10 != null) goto L12;
        if (r5.getType() != (-1)) goto L10;
        r10 = "<EOF>";
        goto L12
    L10:
        r10 = "<" + r5.getType() + ">";
    L12:
        return j0.k("'", r10.replace("\n", "\\n").replace("\r", "\\r").replace(Profiler.DATA_SEP, "\\t"), "'");
    }

    public abstract TokenFactory<?> getTokenFactory();

    @Deprecated
    public abstract String[] getTokenNames();

    public int getTokenType(String r5) {
        Integer r10 = getTokenTypeMap().get(r5);
        if (r10 != null) goto L5;
        return 0;
    L5:
        return r10.intValue();
    }

    public Map<String, Integer> getTokenTypeMap() {
        Vocabulary r5 = getVocabulary();
        Map<Vocabulary, Map<String, Integer>> r10 = tokenTypeMapCache;
        monitor-enter(r10);
        Map<String, Integer> r11 = r10.get(r5);     // Catch: Throwable -> L12
        if (r11 != null) goto L19;
        HashMap r12 = new HashMap();     // Catch: Throwable -> L12
        int r13 = 0;
    L8:
        if (r13 > getATN().maxTokenType) goto L18;
        String r14 = r5.getLiteralName(r13);     // Catch: Throwable -> L12
        if (r14 == null) goto L14;
        r12.put(r14, Integer.valueOf(r13));     // Catch: Throwable -> L12
    L14:
        String r15 = r5.getSymbolicName(r13);     // Catch: Throwable -> L12
        if (r15 == null) goto L17;
        r12.put(r15, Integer.valueOf(r13));     // Catch: Throwable -> L12
    L17:
        r13 = r13 + 1;     // Catch: Throwable -> L12
        goto L8
    L18:
        r12.put("EOF", -1);     // Catch: Throwable -> L12
        r11 = Collections.unmodifiableMap(r12);     // Catch: Throwable -> L12
        tokenTypeMapCache.put(r5, r11);     // Catch: Throwable -> L12
    L19:
        monitor-exit(r10);     // Catch: Throwable -> L12
        return r11;
    L12:
        th = move-exception;
        throw th;
    }

    public Vocabulary getVocabulary() {
        return VocabularyImpl.fromTokenNames(getTokenNames());
    }

    public boolean precpred(RuleContext r5, int r10) {
        return true;
    }

    public void removeErrorListener(ANTLRErrorListener r5) {
        this._listeners.remove(r5);
    }

    public void removeErrorListeners() {
        this._listeners.clear();
    }

    public boolean sempred(RuleContext r5, int r10, int r11) {
        return true;
    }

    public abstract void setInputStream(IntStream r5);

    public void setInterpreter(ATNInterpreter r5) {
        this._interp = r5;
    }

    public final void setState(int r5) {
        this._stateNumber = r5;
    }

    public abstract void setTokenFactory(TokenFactory<?> r5);
}
