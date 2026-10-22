package org.apache.xmlbeans.impl.xpath;

import com.ctc.wstx.shaded.msv_core.grammar.xmlschema.XMLSchemaSchema;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.impl.common.XMLChar;

/* JADX INFO: loaded from: classes7.dex */
class XPathCompilationContext {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int _column;
    private final String _currentNodeVar;
    private String _expr;
    private final Map<String, String> _externalNamespaces;
    private boolean _lastDeepDot;
    private int _line;
    protected final Map<String, String> _namespaces;
    private int _offset;
    private boolean _sawDeepDot;

    static {
    }

    XPathCompilationContext(Map<String, String> r3, String r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        this._namespaces = new HashMap();
        if (r4 != null) goto L5;
        r4 = "$this";
    L5:
        this._currentNodeVar = r4;
        if (r5 != null) goto L8;
        r5 = new HashMap();
    L8:
        this._externalNamespaces = r5;
    }

    private XPathStep addStep(boolean r1, boolean r2, QName r3, XPathStep r4) {
        XPathStep r0 = new XPathStep(r1, r2, r3);
        if (r4 != null) goto L5;
        return r0;
    L5:
        XPathStep r5 = r4;
    L7:
        if (r5._next == null) goto L9;
        r5 = r5._next;
        goto L7
    L9:
        r5._next = r0;
        r0._prev = r5;
        return r4;
    }

    private void computeBacktrack(XPathStep r13) {
    L2:
        if (r13 == null) goto L56;
        XPathStep r0 = r13._next;
    L4:
        if (r0 == null) goto L9;
        if (r0._deep == true) goto L9;
        r0 = r0._next;
    L9:
        if (r13._deep == true) goto L12;
    L10:
        if (r13 == r0) goto L55;
        r13._hasBacktrack = true;
        r13 = r13._next;
    L55:
        r13 = r0;
        goto L2
    L12:
        int r1 = 0;
        XPathStep r3 = r13;
        int r4 = 0;
    L13:
        if (r3 == r0) goto L21;
        if (r3._name == null) goto L21;
        if (r3.isWild() == true) goto L21;
        if (r3._attr == true) goto L21;
        r4 = r4 + 1;
        r3 = r3._next;
    L21:
        int r5 = r4 + 1;
        Object[] r6 = new QName[r5];
        int[] r7 = new int[r5];
        XPathStep r8 = r13;
        int r9 = 0;
    L22:
        if (r9 >= r4) goto L24;
        r6[r9] = r8._name;
        r8 = r8._next;
        r9 = r9 + 1;
        goto L22
    L24:
        r6[r4] = getAnyQName();
        r7[0] = -1;
        int r10 = 0;
        int r11 = -1;
    L25:
        if (r10 >= r4) goto L35;
    L26:
        if (r11 <= (-1)) goto L30;
        if (r6[r10].equals(r6[r11]) == true) goto L30;
        r11 = r7[r11];
    L30:
        r10 = r10 + 1;
        r11 = r11 + 1;
        if (r6[r10].equals(r6[r11]) == false) goto L33;
        int r12 = r7[r11];
    L34:
        r7[r10] = r12;
        goto L25
    L33:
        r12 = r11;
        goto L34
    L35:
        XPathStep r14 = r13;
    L36:
        if (r14 == r3) goto L41;
        r14._hasBacktrack = true;
        r14._backtrack = r13;
        int r15 = r7[r1];
    L38:
        if (r15 <= 0) goto L40;
        r14._backtrack = r14._backtrack._next;
        r15 = r15 - 1;
        goto L38
    L40:
        r1 = r1 + 1;
        r14 = r14._next;
        goto L36
    L41:
        if (r4 <= 1) goto L45;
        int r2 = r7[r4 - 1];
        XPathStep r16 = r13;
    L43:
        if (r2 <= 0) goto L46;
        r16 = r16._next;
        r2 = r2 - 1;
    L46:
        if (r3 != r0) goto L48;
    L50:
        if (r3 != r0) goto L52;
    L54:
        r13._hasBacktrack = true;
        r13._backtrack = r13;
        goto L55
    L52:
        if (r3._name != null) goto L54;
        r3._hasBacktrack = true;
        r3._backtrack = r16;
        goto L54
    L48:
        if (r3._attr == false) goto L50;
        r3._hasBacktrack = true;
        r3._backtrack = r16;
        r3 = r3._next;
        goto L50
    L45:
        r16 = r13;
        goto L46
    }

    private QName getAnyQName() {
        return new QName("", "");
    }

    private XPath.XPathCompileException newError(String r7) {
        return new XPath.XPathCompileException(XmlError.forLocation(r7, 0, null, this._line, this._column, this._offset));
    }

    private boolean parseWhitespace() {
        boolean r0 = false;
    L4:
        if (isWhitespace() == false) goto L6;
        advance();
        r0 = true;
        goto L4
    L6:
        return r0;
    }

    private boolean tokenize(String... r7) {
        int r0 = r7.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L12;
        String r4 = r7[r2];
    L6:
        if (isWhitespace(r3) == false) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        if (startsWith(r4, r3) == false) goto L10;
        r3 = r3 + r4.length();
        r2 = r2 + 1;
        goto L3
    L10:
        return false;
    L12:
        advance(r3);
        return true;
    }

    private String tokenizeNCName() {
        parseWhitespace();
        if (isNCNameStart() == false) goto L11;
        StringBuilder r0 = new StringBuilder();
    L5:
        r0.append((char) currChar());
        advance();
        if (isNCName() == true) goto L5;
        return r0.toString();
    L11:
        throw newError("Expected non-colonized name");
    }

    private void tokenizePath(ArrayList<XPathStep> r8) {
        this._lastDeepDot = false;
        XPathStep r1 = tokenizeSteps();
        computeBacktrack(r1);
        r8.add(r1);
        if (this._lastDeepDot == false) goto L20;
        this._sawDeepDot = true;
        XPathStep r3 = null;
    L5:
        if (r1 == null) goto L15;
        if (r1._next == null) goto L11;
        if (r1._next._next != null) goto L11;
    L12:
        boolean r4 = true;
    L14:
        r3 = addStep(r1._deep, r4, r1._name, r3);
        r1 = r1._next;
    L11:
        if (r1._attr == true) goto L12;
        r4 = false;
        goto L14
    L15:
        computeBacktrack(r3);
        r8.add(r3);
        return;
    }

    private QName tokenizeQName() {
        if (tokenize(new String[]{"*"}) == true) goto L5;
        String r1 = tokenizeNCName();
        String r3 = "";
        if (tokenize(new String[]{ParameterizedMessage.ERROR_MSG_SEPARATOR}) == false) goto L9;
        String r2 = lookupPrefix(r1);
        if (tokenize(new String[]{"*"}) == true) goto L15;
        r3 = tokenizeNCName();
    L15:
        return new QName(r2, r3);
    L9:
        return new QName(lookupPrefix(""), r1);
    L5:
        return getAnyQName();
    }

    private String tokenizeQuotedUri() {
        if (tokenize(new String[]{"\""}) == false) goto L6;
        int r0 = 34;
    L8:
        StringBuilder r1 = new StringBuilder();
    L10:
        if (currChar() == (-1)) goto L19;
        if (currChar() != r0) goto L17;
        advance();
        if (currChar() == r0) goto L17;
        return r1.toString();
    L17:
        r1.append((char) currChar());
        advance();
        goto L10
    L19:
        throw newError("Path terminated in URI literal");
    L6:
        if (tokenize(new String[]{"'"}) == false) goto L21;
        r0 = 39;
        goto L8
    L21:
        throw newError("Expected quote (\" or ')");
    }

    private XPath.Selector tokenizeSelector() {
        ArrayList<XPathStep> r0 = new ArrayList();
    L3:
        tokenizePath(r0);
        if (tokenize(new String[]{"|"}) == true) goto L3;
        return new XPath.Selector((XPathStep[]) ZeusTransformUtils.preCheckCast(r0.toArray(new XPathStep[0]), XPathStep[].class, "com.obric.memorydata.plugin"));
    }

    private XPathStep tokenizeSteps() {
        if (tokenize(new String[]{"/"}) == true) goto L51;
        if (tokenize(new String[]{"$", this._currentNodeVar, "//"}) == false) goto L7;
    L21:
        boolean r1 = true;
    L22:
        boolean r4 = false;
        XPathStep r2 = null;
    L24:
        if (tokenize(new String[]{"attribute", "::"}) == true) goto L44;
        if (tokenize(new String[]{"@"}) == true) goto L44;
        if (tokenize(new String[]{"."}) == false) goto L35;
        if (r4 == true) goto L34;
        if (r1 == true) goto L34;
        r4 = false;
    L37:
        if (tokenize(new String[]{"//"}) == true) goto L38;
        if (tokenize(new String[]{"/"}) == false) goto L45;
        if (r4 == false) goto L24;
    L39:
        r1 = true;
    L45:
        this._lastDeepDot = r4;
        if (r4 == false) goto L49;
        this._lastDeepDot = true;
        r2 = addStep(true, false, getAnyQName(), r2);
    L49:
        return addStep(false, false, null, r2);
    L38:
        r4 = false;
    L34:
        r4 = true;
        goto L37
    L35:
        tokenize(new String[]{"child", "::"});
        r2 = addStep(r1, false, tokenizeQName(), r2);
        r1 = false;
    L44:
        r2 = addStep(r1, true, tokenizeQName(), r2);
        goto L45
    L7:
        if (tokenize(new String[]{".", "//"}) == true) goto L21;
        if (tokenize(new String[]{"$", this._currentNodeVar, "/"}) == false) goto L12;
    L20:
        r1 = false;
        goto L22
    L12:
        if (tokenize(new String[]{".", "/"}) == true) goto L20;
        if (tokenize(new String[]{"$", this._currentNodeVar}) == true) goto L19;
        if (tokenize(new String[]{"."}) == false) goto L20;
    L19:
        return addStep(false, false, null, null);
    L51:
        throw newError("Absolute paths unsupported");
    }

    private XPath tokenizeXPath() {
    L3:
        if (tokenize(new String[]{"declare", "namespace"}) == false) goto L22;
        if (parseWhitespace() == false) goto L20;
        String r0 = tokenizeNCName();
        if (tokenize(new String[]{"="}) == false) goto L18;
        String r1 = tokenizeQuotedUri();
        if (this._namespaces.containsKey(r0) == true) goto L16;
        this._namespaces.put(r0, r1);
        if (this._externalNamespaces.containsKey(r0) == true) goto L14;
        this._externalNamespaces.put(r0, r1);
        tokenize(new String[]{";"});
    L29:
        this._externalNamespaces.put("$xmlbeans!ns_boundary", Integer.toString(this._offset));
        goto L3
    L14:
        throw newError("Redefinition of namespace prefix: " + r0);
    L16:
        throw newError("Redefinition of namespace prefix: " + r0);
    L18:
        throw newError("Expected '='");
    L20:
        throw newError("Expected prefix after 'declare namespace'");
    L22:
        if (tokenize(new String[]{"declare", "default", "element", "namespace"}) == false) goto L37;
        String r2 = tokenizeQuotedUri();
        if (this._namespaces.containsKey("") == true) goto L35;
        this._namespaces.put("", r2);
        if (this._externalNamespaces.containsKey("$xmlbeans!default_uri") == true) goto L33;
        this._externalNamespaces.put("$xmlbeans!default_uri", r2);
        if (tokenize(new String[]{";"}) == true) goto L29;
        throw newError("Default Namespace declaration must end with ;");
    L33:
        throw newError("Redefinition of default element namespace : ");
    L35:
        throw newError("Redefinition of default element namespace");
    L37:
        if (this._namespaces.containsKey("") == true) goto L39;
        this._namespaces.put("", "");
    L39:
        XPath.Selector r3 = tokenizeSelector();
        parseWhitespace();
        if (currChar() != (-1)) goto L44;
        return new XPath(r3, this._sawDeepDot);
    L44:
        throw newError("Unexpected char '" + ((char) currChar()) + "'");
    }

    void advance() {
        if (this._offset >= this._expr.length()) goto L15;
        char r0 = this._expr.charAt(this._offset);
        int r1 = this._offset + 1;
        this._offset = r1;
        this._column++;
        if (r0 == '\r') goto L7;
        if (r0 == '\n') goto L7;
        return;
    L7:
        this._line++;
        this._column = 1;
        if ((r1 + 1) >= this._expr.length()) goto L17;
        char r2 = this._expr.charAt(this._offset + 1);
        if (r2 == '\r') goto L12;
        if (r2 == '\n') goto L12;
        return;
    L12:
        if (r0 == r2) goto L19;
        this._offset++;
        return;
    L19:
        return;
    L17:
        return;
    }

    void advance(int r2) {
    L2:
        int r0 = r2 - 1;
        if (r2 <= 0) goto L5;
        advance();
        r2 = r0;
        goto L2
    }

    XPath compile(String r2) {
        this._offset = 0;
        this._line = 1;
        this._column = 1;
        this._expr = r2;
        return tokenizeXPath();
    }

    int currChar() {
        return currChar(0);
    }

    int currChar(int r3) {
        if ((this._offset + r3) < this._expr.length()) goto L6;
        return -1;
    L6:
        return this._expr.charAt(this._offset + r3);
    }

    boolean isNCName() {
        if (currChar() != (-1)) goto L5;
    L7:
        return false;
    L5:
        if (XMLChar.isNCName(currChar()) == false) goto L7;
        return true;
    }

    boolean isNCNameStart() {
        if (currChar() != (-1)) goto L5;
    L7:
        return false;
    L5:
        if (XMLChar.isNCNameStart(currChar()) == false) goto L7;
        return true;
    }

    boolean isWhitespace() {
        return isWhitespace(0);
    }

    boolean isWhitespace(int r1) {
        int r0 = currChar(r1);
        if (r0 != 32) goto L5;
    L12:
        return true;
    L5:
        if (r0 == 9) goto L12;
        if (r0 == 10) goto L12;
        if (r0 == 13) goto L12;
        return false;
    }

    String lookupPrefix(String r4) {
        if (this._namespaces.containsKey(r4) == false) goto L8;
        Map<String, String> r3 = this._namespaces;
    L6:
        return (String) ZeusTransformUtils.preCheckCast(r3.get(r4), String.class, "com.obric.memorydata.plugin");
    L8:
        if (this._externalNamespaces.containsKey(r4) == false) goto L10;
        r3 = this._externalNamespaces;
        goto L6
    L10:
        if (r4 == null) goto L12;
        String r0 = r4;
    L13:
        r0.hashCode();
        byte r1 = -1;
        switch(r0.hashCode()) {
            case 3272: goto L37;
            case 3835: goto L33;
            case 118536: goto L29;
            case 118807: goto L25;
            case 118990: goto L21;
            case 103145323: goto L17;
            default: goto L40;
        };
    L40:
        switch(r1) {
            case 0: goto L53;
            case 1: goto L51;
            case 2: goto L49;
            case 3: goto L47;
            case 4: goto L45;
            case 5: goto L43;
            default: goto L42;
        };
    L43:
        return "http://www.w3.org/2003/11/xquery-local-functions";
    L45:
        return XMLSchemaSchema.XMLSchemaInstanceNamespace;
    L47:
        return "http://www.w3.org/XML/1998/namespace";
    L49:
        return "http://www.w3.org/2003/11/xpath-datatypes";
    L51:
        return "http://www.w3.org/2001/XMLSchema";
    L53:
        return "http://www.w3.org/2002/11/xquery-functions";
    L42:
        throw newError("Undefined prefix: " + r4);
    L17:
        if (r0.equals("local") == false) goto L40;
        r1 = 5;
        goto L40
    L21:
        if (r0.equals("xsi") == false) goto L40;
        r1 = 4;
        goto L40
    L25:
        if (r0.equals("xml") == false) goto L40;
        r1 = 3;
        goto L40
    L29:
        if (r0.equals("xdt") == false) goto L40;
        r1 = 2;
        goto L40
    L33:
        if (r0.equals("xs") == false) goto L40;
        r1 = 1;
        goto L40
    L37:
        if (r0.equals("fn") == false) goto L40;
        r1 = 0;
        goto L40
    L12:
        r0 = "";
        goto L13
    }

    boolean startsWith(String r3, int r4) {
        if ((this._offset + r4) < this._expr.length()) goto L7;
        return false;
    L7:
        return this._expr.startsWith(r3, this._offset + r4);
    }
}
