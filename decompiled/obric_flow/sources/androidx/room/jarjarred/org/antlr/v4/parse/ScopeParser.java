package androidx.room.jarjarred.org.antlr.v4.parse;

import androidx.room.jarjarred.org.antlr.runtime.CommonToken;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Pair;
import androidx.room.jarjarred.org.antlr.v4.tool.Attribute;
import androidx.room.jarjarred.org.antlr.v4.tool.AttributeDict;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorType;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ScopeParser {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public ScopeParser() {
    }

    public static Pair<Integer, Integer> _parsePostfixDecl(Attribute r10, String r11, ActionAST r12, Grammar r13) {
        int r5 = r11.indexOf(58);
        if (r5 != (-1)) goto L5;
        int r14 = r11.length();
    L6:
        int r15 = 0;
        int r16 = 0;
    L8:
        if (r16 >= r14) goto L14;
        char r17 = r11.charAt(r16);
        if (Character.isLetterOrDigit(r17) == true) goto L15;
        if (r17 == '_') goto L15;
        r16 = r16 + 1;
    L15:
        if (r16 != (-1)) goto L17;
        r13.tool.errMgr.grammarError(ErrorType.CANNOT_FIND_ATTRIBUTE_NAME_IN_DECL, r13.fileName, r12.token, new Object[]{r11});
    L18:
        int r18 = -1;
        int r19 = r15;
    L19:
        if (r19 >= r14) goto L28;
        char r20 = r11.charAt(r19);
        if (Character.isLetterOrDigit(r20) == true) goto L25;
        if (r20 == '_') goto L25;
    L29:
        if (r19 != (-1)) goto L31;
        r19 = r15;
    L31:
        r10.name = r11.substring(r15, r19);
        if (r5 != (-1)) goto L34;
        r10.type = "";
    L35:
        String r21 = r10.type.trim();
        r10.type = r21;
        if (r21.length() != 0) goto L39;
        r10.type = null;
    L39:
        return new Pair(Integer.valueOf(r15), Integer.valueOf(r19));
    L34:
        r10.type = r11.substring(r5 + 1, r11.length());
    L25:
        if (r19 != (r14 - 1)) goto L27;
        r18 = r14;
    L27:
        r19 = r19 + 1;
        goto L19
    L28:
        r19 = r18;
        goto L29
    L17:
        r15 = r16;
        goto L18
    L14:
        r16 = -1;
        goto L15
    L5:
        r14 = r5;
        goto L6
    }

    public static Pair<Integer, Integer> _parsePrefixDecl(Attribute r10, String r11, ActionAST r12, Grammar r13) {
        int r5 = r11.length() - 1;
        boolean r14 = false;
    L3:
        int r15 = -1;
        if (r5 < 0) goto L16;
        char r16 = r11.charAt(r5);
        if (r14 == false) goto L8;
    L10:
        if (r14 == false) goto L15;
        if (Character.isLetterOrDigit(r16) == true) goto L15;
        if (r16 == '_') goto L15;
        int r17 = r5 + 1;
    L17:
        if (r17 >= 0) goto L20;
        if (r14 == false) goto L20;
        r17 = 0;
    L20:
        if (r17 >= 0) goto L22;
        r13.tool.errMgr.grammarError(ErrorType.CANNOT_FIND_ATTRIBUTE_NAME_IN_DECL, r13.fileName, r12.token, new Object[]{r11});
    L22:
        int r18 = r17;
    L24:
        if (r18 >= r11.length()) goto L33;
        char r19 = r11.charAt(r18);
        if (Character.isLetterOrDigit(r19) == true) goto L30;
        if (r19 == '_') goto L30;
        r15 = r18;
    L30:
        if (r18 != (r11.length() - 1)) goto L32;
        r15 = r18 + 1;
    L32:
        r18 = r18 + 1;
    L33:
        r10.name = r11.substring(r17, r15);
        r10.type = r11.substring(0, r17);
        if (r15 > (r11.length() - 1)) goto L36;
        r10.type += r11.substring(r15, r11.length());
    L36:
        String r20 = r10.type.trim();
        r10.type = r20;
        if (r20.length() != 0) goto L40;
        r10.type = null;
    L40:
        return new Pair(Integer.valueOf(r17), Integer.valueOf(r15));
    L15:
        r5 = r5 - 1;
        goto L3
    L8:
        if (Character.isLetterOrDigit(r16) == false) goto L10;
        r14 = true;
        goto L15
    L16:
        r17 = -1;
        goto L17
    }

    public static int _splitArgumentList(String r10, int r11, int r12, int r13, List<Pair<String, Integer>> r14) {
        if (r10 != null) goto L5;
        return -1;
    L5:
        String r15 = r10.replaceAll("//[^\\n]*", "");
        int r5 = r15.length();
        int r16 = r11;
    L6:
        if (r11 >= r5) goto L59;
        if (r15.charAt(r11) == r12) goto L59;
        char r17 = r15.charAt(r11);
        if (r17 == '\"') goto L48;
        if (r17 != '<') goto L14;
        int r18 = r11 + 1;
        if (r15.indexOf(62, r18) >= r11) goto L46;
        r11 = r18;
        goto L6
    L46:
        r11 = _splitArgumentList(r15, r18, 62, r13, r14);
        goto L6
    L14:
        if (r17 != '[') goto L16;
        r11 = _splitArgumentList(r15, r11 + 1, 93, r13, r14);
        goto L6
    L16:
        if (r17 != '{') goto L18;
        r11 = _splitArgumentList(r15, r11 + 1, 125, r13, r14);
        goto L6
    L18:
        if (r17 == '\'') goto L31;
        if (r17 != '(') goto L21;
        r11 = _splitArgumentList(r15, r11 + 1, 41, r13, r14);
        goto L6
    L21:
        if (r17 != r13) goto L29;
        if (r12 != (-1)) goto L29;
        String r19 = r15.substring(r16, r11);
    L24:
        if (r16 >= r11) goto L28;
        if (Character.isWhitespace(r15.charAt(r16)) == false) goto L28;
        r16 = r16 + 1;
    L28:
        r14.add(new Pair(r19.trim(), Integer.valueOf(r16)));
        r16 = r11 + 1;
    L29:
        r11 = r11 + 1;
    L31:
        r11 = r11 + 1;
        if (r11 >= r5) goto L29;
        if (r15.charAt(r11) == '\'') goto L29;
        if (r15.charAt(r11) != '\\') goto L31;
        int r20 = r11 + 1;
        if (r20 >= r5) goto L31;
        if (r15.charAt(r20) != '\'') goto L31;
        r11 = r20;
    L48:
        r11 = r11 + 1;
        if (r11 >= r5) goto L29;
        if (r15.charAt(r11) == '\"') goto L29;
        if (r15.charAt(r11) != '\\') goto L48;
        int r21 = r11 + 1;
        if (r21 >= r5) goto L48;
        if (r15.charAt(r21) != '\"') goto L48;
        r11 = r21;
    L59:
        if (r12 != (-1)) goto L70;
        if (r11 > r5) goto L70;
        String r22 = r15.substring(r16, r11).trim();
    L62:
        if (r16 >= r11) goto L67;
        if (Character.isWhitespace(r15.charAt(r16)) == false) goto L67;
        r16 = r16 + 1;
    L67:
        if (r22.length() <= 0) goto L70;
        r14.add(new Pair(r22.trim(), Integer.valueOf(r16)));
    L70:
        return r11 + 1;
    }

    public static AttributeDict parse(ActionAST r5, String r10, char r11, Grammar r12) {
        AttributeDict r13 = new AttributeDict();
        Iterator<Pair<String, Integer>> r14 = splitDecls(r10, r11).iterator();
    L4:
        if (r14.hasNext() == false) goto L8;
        Pair<String, Integer> r15 = r14.next();
        if (r15.f667a.trim().length() <= 0) goto L4;
        r13.add(parseAttributeDef(r5, r15, r12));
        goto L4
    L8:
        return r13;
    }

    public static Attribute parseAttributeDef(ActionAST r12, Pair<String, Integer> r13, Grammar r14) {
        if (r13.f667a != null) goto L6;
        return null;
    L6:
        Attribute r5 = new Attribute();
        int r10 = r13.f667a.length() - 1;
        int r11 = r13.f667a.indexOf(61);
        if (r11 <= 0) goto L9;
        String r15 = r13.f667a;
        r5.initValue = r15.substring(r11 + 1, r15.length()).trim();
        r10 = r11 - 1;
    L9:
        int r16 = 0;
        String r17 = r13.f667a.substring(0, r10 + 1);
        if (r13.f667a.replaceAll("::", "").contains(":") == false) goto L12;
        Pair<Integer, Integer> r18 = _parsePostfixDecl(r5, r17, r12, r14);
    L13:
        int r19 = r18.f667a.intValue();
        int r110 = r18.f668b.intValue();
        r5.decl = r13.f667a;
        if (r12 == null) goto L41;
        String r20 = r12.getText();
        int[] r21 = new int[r20.length()];
        int[] r22 = new int[r20.length()];
        int r23 = 0;
        int r24 = 0;
        int r25 = 0;
    L17:
        if (r23 >= r20.length()) goto L22;
        r21[r23] = r24;
        r22[r23] = r25;
        if (r20.charAt(r23) != '\n') goto L21;
        r24 = r24 + 1;
        r25 = -1;
    L21:
        r23 = r23 + 1;
        r25 = r25 + 1;
        goto L17
    L22:
        int[] r26 = new int[r20.length()];
        int r27 = 0;
    L24:
        if (r16 >= r20.length()) goto L37;
        r26[r27] = r16;
        if (r16 >= (r20.length() - 1)) goto L36;
        if (r20.charAt(r16) != '/') goto L36;
        if (r20.charAt(r16 + 1) != '/') goto L36;
    L32:
        if (r16 >= r20.length()) goto L36;
        if (r20.charAt(r16) == '\n') goto L36;
        r16 = r16 + 1;
    L36:
        r16 = r16 + 1;
        r27 = r27 + 1;
        goto L24
    L37:
        int r111 = r26[r13.f668b.intValue()];
        int r28 = r111 + r19;
        int r29 = r21[r28];
        int r30 = r12.getToken().getLine() + r29;
        int r31 = r22[r28];
        if (r29 != 0) goto L40;
        r31 = r31 + (r12.getToken().getCharPositionInLine() + 1);
    L40:
        int r32 = ((CommonToken) r12.getToken()).getStartIndex() + r111;
        CommonToken r112 = new CommonToken(r12.getToken().getInputStream(), 28, 0, (r19 + r32) + 1, r32 + r110);
        r5.token = r112;
        r112.setLine(r30);
        r5.token.setCharPositionInLine(r31);
    L41:
        return r5;
    L12:
        r18 = _parsePrefixDecl(r5, r17, r12, r14);
        goto L13
    }

    public static AttributeDict parseTypedArgList(ActionAST r5, String r10, Grammar r11) {
        return parse(r5, r10, ',', r11);
    }

    public static List<Pair<String, Integer>> splitDecls(String r5, int r10) {
        ArrayList r11 = new ArrayList();
        _splitArgumentList(r5, 0, -1, r10, r11);
        return r11;
    }
}
