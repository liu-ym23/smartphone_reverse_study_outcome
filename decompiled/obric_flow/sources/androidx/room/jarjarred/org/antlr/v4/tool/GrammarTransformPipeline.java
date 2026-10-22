package androidx.room.jarjarred.org.antlr.v4.tool;

import androidx.constraintlayout.motion.widget.a;
import androidx.room.jarjarred.org.antlr.runtime.CommonToken;
import androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree;
import androidx.room.jarjarred.org.antlr.runtime.tree.CommonTreeNodeStream;
import androidx.room.jarjarred.org.antlr.runtime.tree.Tree;
import androidx.room.jarjarred.org.antlr.runtime.tree.TreeVisitor;
import androidx.room.jarjarred.org.antlr.v4.Tool;
import androidx.room.jarjarred.org.antlr.v4.analysis.LeftRecursiveRuleTransformer;
import androidx.room.jarjarred.org.antlr.v4.parse.BlockSetTransformer;
import androidx.room.jarjarred.org.antlr.v4.parse.GrammarASTAdaptor;
import androidx.room.jarjarred.org.antlr.v4.parse.GrammarToken;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.DoubleKeyMap;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Pair;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.AltAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.BlockAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarASTWithOptions;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarRootAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.RuleAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.TerminalAST;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class GrammarTransformPipeline {
    public Grammar g;
    public Tool tool;

    public GrammarTransformPipeline(Grammar r5, Tool r10) {
        this.g = r5;
        this.tool = r10;
    }

    public static void augmentTokensWithOriginalPosition(Grammar r10, GrammarAST r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        List<GrammarAST> r12 = r11.getNodesWithType(82);
        int r5 = 0;
    L6:
        if (r5 >= r12.size()) goto L16;
        CommonTree r13 = r12.get(r5).parent;
        if ((r13 instanceof GrammarASTWithOptions) == false) goto L15;
        Map<String, GrammarAST> r14 = ((GrammarASTWithOptions) r13).getOptions();
        if (r14.containsKey(LeftRecursiveRuleTransformer.TOKENINDEX_OPTION_NAME) == false) goto L15;
        GrammarToken r15 = new GrammarToken(r10, r13.getToken());
        r15.originalTokenIndex = Integer.valueOf(r14.get(LeftRecursiveRuleTransformer.TOKENINDEX_OPTION_NAME).getText()).intValue();
        r13.token = r15;
        GrammarAST r16 = r10.ast.getNodeWithTokenIndex(r15.getTokenIndex());
        if (r16 == null) goto L14;
        r13.setTokenStartIndex(r16.getTokenStartIndex());
        r13.setTokenStopIndex(r16.getTokenStopIndex());
        goto L15
    L14:
        r13.setTokenStartIndex(r15.getTokenIndex());
        r13.setTokenStopIndex(r15.getTokenIndex());
    L15:
        r5 = r5 + 1;
        goto L6
    }

    public static void setGrammarPtr(final Grammar r5, GrammarAST r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        new TreeVisitor(new GrammarASTAdaptor()).visit(r10, new AnonymousClass2(r5));
    }

    public GrammarAST expandParameterizedLoop(GrammarAST r5) {
        return r5;
    }

    public void expandParameterizedLoops(GrammarAST r5) {
        new TreeVisitor(new GrammarASTAdaptor()).visit(r5, new AnonymousClass1(this));
    }

    public GrammarRootAST extractImplicitLexer(Grammar r14) {
        GrammarRootAST r13 = r14.ast;
        GrammarASTAdaptor r5 = new GrammarASTAdaptor(r13.token.getInputStream());
        int r10 = 0;
        GrammarAST[] r11 = (GrammarAST[]) r13.getChildren().toArray(new GrammarAST[0]);
        String r12 = r13.getChild(0).getText() + "Lexer";
        GrammarRootAST r15 = new GrammarRootAST(new CommonToken(25, "LEXER_GRAMMAR"), r14.ast.tokenStream);
        r15.grammarType = 31;
        r15.token.setInputStream(r13.token.getInputStream());
        r15.addChild((GrammarAST) r5.create(28, r12));
        GrammarAST r16 = (GrammarAST) r13.getFirstChildWithType(42);
        if (r16 != null) goto L5;
    L14:
        ArrayList r17 = new ArrayList();
        int r18 = r11.length;
        int r19 = 0;
    L15:
        if (r19 >= r18) goto L22;
        GrammarAST r20 = r11[r19];
        if (r20.getType() != 11) goto L21;
        r15.addChild((Tree) r5.dupTree(r20));
        if (r20.getChild(0).getText().equals("lexer") == false) goto L21;
        r17.add(r20);
    L21:
        r19 = r19 + 1;
        goto L15
    L22:
        Iterator r21 = r17.iterator();
    L24:
        if (r21.hasNext() == false) goto L26;
        r13.deleteChild((GrammarAST) r21.next());
        goto L24
    L26:
        GrammarAST r22 = (GrammarAST) r13.getFirstChildWithType(97);
        if (r22 != null) goto L29;
        return r15;
    L29:
        GrammarAST r23 = (GrammarAST) r5.create(97, "RULES");
        r15.addChild(r23);
        ArrayList r24 = new ArrayList();
        if (r22.getChildCount() <= 0) goto L32;
        GrammarASTWithOptions[] r25 = (GrammarASTWithOptions[]) r22.getChildren().toArray(new GrammarASTWithOptions[0]);
    L33:
        int r26 = r25.length;
        int r27 = 0;
    L34:
        if (r27 >= r26) goto L39;
        GrammarASTWithOptions r28 = r25[r27];
        if (Grammar.isTokenName(r28.getChild(0).getText()) == false) goto L38;
        r23.addChild((Tree) r5.dupTree(r28));
        r24.add(r28);
    L38:
        r27 = r27 + 1;
        goto L34
    L39:
        Iterator r29 = r24.iterator();
    L41:
        if (r29.hasNext() == false) goto L43;
        r22.deleteChild((GrammarAST) r29.next());
        goto L41
    L43:
        List<Pair<GrammarAST, GrammarAST>> r30 = Grammar.getStringLiteralAliasesFromLexerRules(r15);
        Iterator<String> r31 = r14.getStringLiterals().iterator();
    L45:
        if (r31.hasNext() == false) goto L55;
        String r32 = r31.next();
        if (r30 == null) goto L54;
        Iterator<Pair<GrammarAST, GrammarAST>> r33 = r30.iterator();
    L50:
        if (r33.hasNext() == false) goto L54;
        if (r32.equals(r33.next().f668b.getText()) == false) goto L50;
    L54:
        String r34 = r14.getStringLiteralLexerRuleName(r32);
        RuleAST r35 = new RuleAST(94);
        BlockAST r36 = new BlockAST(78);
        AltAST r37 = new AltAST(74);
        r37.addChild(new TerminalAST(new CommonToken(62, r32)));
        r36.addChild(r37);
        r35.addChild(new TerminalAST(new CommonToken(66, r34)));
        r35.addChild(r36);
        r23.insertChild(r10, r35);
        r23.freshenParentAndChildIndexes();
        r10 = r10 + 1;
        goto L45
    L55:
        r15.sanityCheckParentAndChildIndexes();
        r13.sanityCheckParentAndChildIndexes();
        r14.tool.log("grammar", "after extract implicit lexer =" + r13.toStringTree());
        r14.tool.log("grammar", "lexer =" + r15.toStringTree());
        if (r23.getChildCount() != 0) goto L59;
        return null;
    L59:
        return r15;
    L32:
        r25 = new GrammarASTWithOptions[0];
        goto L33
    L5:
        if (r16.getChildCount() == 0) goto L14;
        Tree r38 = (GrammarAST) r5.dupNode(r16);
        r15.addChild(r38);
        GrammarAST[] r39 = (GrammarAST[]) r16.getChildren().toArray(new GrammarAST[0]);
        int r40 = r39.length;
        int r41 = 0;
    L7:
        if (r41 >= r40) goto L14;
        GrammarAST r42 = r39[r41];
        String r43 = r42.getChild(0).getText();
        if (Grammar.lexerOptions.contains(r43) == false) goto L13;
        if (Grammar.doNotCopyOptionsToLexer.contains(r43) == true) goto L13;
        Tree r44 = (GrammarAST) r5.dupTree(r42);
        r38.addChild(r44);
        r15.setOption(r43, (GrammarAST) r44.getChild(1));
    L13:
        r41 = r41 + 1;
        goto L7
    }

    public void integrateImportedGrammars(Grammar r29) {
        List<Grammar> r5 = r29.getAllImportedGrammars();
        if (r5 != null) goto L5;
        return;
    L5:
        GrammarRootAST r10 = r29.ast;
        GrammarASTAdaptor r11 = new GrammarASTAdaptor(((GrammarAST) r10.getChild(0)).token.getInputStream());
        int r12 = 13;
        GrammarAST r13 = (GrammarAST) r10.getFirstChildWithType(13);
        GrammarAST r14 = (GrammarAST) r10.getFirstChildWithType(65);
        List<GrammarAST> r15 = r10.getNodesWithType(11);
        GrammarAST r16 = (GrammarAST) r10.getFirstChildWithType(97);
        HashSet r17 = new HashSet();
        Iterator<GrammarAST> r18 = r16.getNodesWithType(94).iterator();
    L7:
        if (r18.hasNext() == false) goto L9;
        r17.add(r18.next().getChild(0).getText());
        goto L7
    L9:
        List<GrammarAST> r19 = r10.getNodesWithType(36);
        HashSet r110 = new HashSet();
        Iterator<GrammarAST> r111 = r19.iterator();
    L11:
        if (r111.hasNext() == false) goto L13;
        r110.add(r111.next().getChild(0).getText());
        goto L11
    L13:
        new ArrayList();
        Iterator<Grammar> r20 = r5.iterator();
    L15:
        if (r20.hasNext() == false) goto L126;
        Grammar r112 = r20.next();
        GrammarAST r21 = (GrammarAST) r112.ast.getFirstChildWithType(r12);
        if (r21 == null) goto L34;
        Iterator<Grammar> r113 = r20;
        r29.tool.log("grammar", "imported channels: " + r21.getChildren());
        if (r13 != null) goto L22;
        GrammarAST r22 = r21.dupTree();
        r22.g = r29;
        r10.insertChild(1, r22);
        r13 = r22;
    L21:
        GrammarAST r23 = r16;
        GrammarAST r24 = (GrammarAST) r112.ast.getFirstChildWithType(65);
        if (r24 == null) goto L43;
        r29.tool.log("grammar", "imported tokens: " + r24.getChildren());
        if (r14 != null) goto L41;
        r14 = (GrammarAST) r11.create(65, "TOKENS");
        r14.g = r29;
        r10.insertChild(1, r14);
    L41:
        r14.addChildren(Arrays.asList(r24.getChildren().toArray(new Tree[0])));
    L43:
        ArrayList r25 = new ArrayList();
        List<GrammarAST> r26 = r112.ast.getAllChildrenWithType(11);
        if (r15 == null) goto L46;
        r25.addAll(r15);
    L46:
        r25.addAll(r26);
        if (r26 == null) goto L74;
        DoubleKeyMap r114 = new DoubleKeyMap();
        r29.tool.log("grammar", "imported actions: " + r26);
        Iterator r27 = r25.iterator();
    L50:
        if (r27.hasNext() == false) goto L63;
        GrammarAST r28 = (GrammarAST) r27.next();
        String r30 = r29.getDefaultActionScope();
        if (r28.getChildCount() <= 2) goto L54;
        r30 = ((GrammarAST) r28.getChild(0)).getText();
        GrammarAST r115 = (GrammarAST) r28.getChild(1);
        GrammarAST r31 = (GrammarAST) r28.getChild(2);
        GrammarAST r32 = r115;
    L55:
        GrammarAST r33 = (GrammarAST) r114.get(r30, r32.getText());
        if (r33 != null) goto L58;
        r114.put(r30, r32.getText(), r31);
    L62:
        r27 = r27;
        goto L50
    L58:
        Grammar r34 = r33.g;
        Grammar r35 = r28.g;
        if (r34 != r35) goto L61;
        r29.tool.errMgr.grammarError(ErrorType.ACTION_REDEFINITION, r35.fileName, r32.token, new Object[]{r32.getText()});
        goto L62
    L61:
        r33.token.setText("{" + a.n(r33.getText(), 1, 1) + '\n' + a.n(r31.getText(), 1, 1) + "}");
        goto L62
    L54:
        GrammarAST r36 = (GrammarAST) r28.getChild(0);
        r31 = (GrammarAST) r28.getChild(1);
        r32 = r36;
        goto L55
    L63:
        Iterator r37 = r114.keySet().iterator();
    L65:
        if (r37.hasNext() == false) goto L74;
        String r38 = (String) r37.next();
        Iterator r39 = r114.keySet(r38).iterator();
    L68:
        if (r39.hasNext() == false) goto L65;
        String r40 = (String) r39.next();
        GrammarAST r41 = (GrammarAST) r114.get(r38, r40);
        Iterator r210 = r37;
        Tool r42 = r29.tool;
        Iterator r211 = r39;
        StringBuilder r43 = new StringBuilder();
        GrammarAST r212 = r13;
        GrammarAST r213 = r14;
        List<GrammarAST> r214 = r15;
        a.C(r43, r41.g.name, " ", r38, ":");
        r43.append(r40);
        r43.append("=");
        r43.append(r41.getText());
        r42.log("grammar", r43.toString());
        if (r41.g == r29) goto L73;
        r10.insertChild(1, r41.getParent());
    L73:
        r37 = r210;
        r39 = r211;
        r13 = r212;
        r14 = r213;
        r15 = r214;
    L74:
        GrammarAST r215 = r13;
        GrammarAST r216 = r14;
        List<GrammarAST> r217 = r15;
        List<GrammarAST> r44 = r112.ast.getNodesWithType(36);
        if (r44 == null) goto L105;
        Iterator<GrammarAST> r45 = r44.iterator();
    L80:
        if (r45.hasNext() == false) goto L105;
        GrammarAST r46 = r45.next();
        r29.tool.log("grammar", "imported mode: " + r46.toStringTree());
        String r47 = r46.getChild(0).getText();
        boolean r48 = r110.contains(r47);
        if (r48 == false) goto L92;
        Iterator<GrammarAST> r116 = r19.iterator();
    L85:
        if (r116.hasNext() == false) goto L90;
        GrammarAST r117 = r116.next();
        if (r117.getChild(0).getText().equals(r47) == false) goto L85;
    L93:
        Iterator<GrammarAST> r49 = r46.getAllChildrenWithType(94).iterator();
        int r50 = 0;
    L95:
        if (r49.hasNext() == false) goto L100;
        GrammarAST r51 = r49.next();
        Tool r118 = r29.tool;
        Iterator<GrammarAST> r119 = r45;
        StringBuilder r52 = new StringBuilder("imported rule: ");
        GrammarRootAST r218 = r10;
        r52.append(r51.toStringTree());
        r118.log("grammar", r52.toString());
        String r53 = r51.getChild(0).getText();
        if (r17.contains(r53) == true) goto L99;
        r117.addChild(r51);
        r50 = r50 + 1;
        r17.add(r53);
    L99:
        r45 = r119;
        r10 = r218;
        goto L95
    L100:
        Iterator<GrammarAST> r120 = r45;
        GrammarRootAST r219 = r10;
        if (r48 == true) goto L104;
        if (r50 <= 0) goto L104;
        r29.ast.addChild(r117);
        r110.add(r47);
        r19.add(r117);
    L104:
        r45 = r120;
        r10 = r219;
        goto L80
    L90:
        r117 = null;
        goto L93
    L92:
        r117 = r46.dupNode();
        r117.addChild(r46.getChild(0).dupNode());
    L105:
        GrammarRootAST r220 = r10;
        List<GrammarAST> r54 = r112.ast.getNodesWithType(94);
        if (r54 == null) goto L114;
        Iterator<GrammarAST> r55 = r54.iterator();
    L109:
        if (r55.hasNext() == false) goto L114;
        GrammarAST r56 = r55.next();
        r29.tool.log("grammar", "imported rule: " + r56.toStringTree());
        String r57 = r56.getChild(0).getText();
        GrammarAST r121 = r23;
        if (r17.contains(r57) == true) goto L113;
        r121.addChild(r56);
        r17.add(r57);
    L113:
        r23 = r121;
    L114:
        r16 = r23;
        GrammarAST r58 = (GrammarAST) r112.ast.getFirstChildWithType(42);
        if (r58 == null) goto L125;
        Iterator<Map.Entry<String, GrammarAST>> r59 = r112.ast.getOptions().entrySet().iterator();
    L118:
        if (r59.hasNext() == false) goto L125;
        Map.Entry<String, GrammarAST> r60 = r59.next();
        String r61 = r112.ast.getOptionString(r60.getKey());
        if (r61 == null) goto L118;
        if (r61.equals(r29.ast.getOptionString(r60.getKey())) == true) goto L118;
        r29.tool.errMgr.grammarError(ErrorType.OPTIONS_IN_DELEGATE, r58.g.fileName, r58.token, new Object[]{r112.name});
    L125:
        r20 = r113;
        r11 = r11;
        r10 = r220;
        r13 = r215;
        r14 = r216;
        r15 = r217;
        r12 = 13;
        goto L15
    L22:
        int r62 = 0;
    L24:
        if (r62 >= r21.getChildCount()) goto L21;
        String r63 = r21.getChild(r62).getText();
        GrammarAST r221 = r16;
        int r64 = 0;
    L27:
        if (r64 >= r13.getChildCount()) goto L32;
        if (r13.getChild(r64).getText().equals(r63) == true) goto L33;
        r64 = r64 + 1;
    L33:
        r62 = r62 + 1;
        r16 = r221;
        goto L24
    L32:
        r13.addChild(r21.getChild(r62).dupNode());
        goto L33
    L34:
        r113 = r20;
        goto L21
    L126:
        r29.tool.log("grammar", "Grammar: " + r29.ast.toStringTree());
    }

    public void process() {
        GrammarRootAST r5 = this.g.ast;
        if (r5 != null) goto L5;
        return;
    L5:
        this.tool.log("grammar", "before: " + r5.toStringTree());
        integrateImportedGrammars(this.g);
        reduceBlocksToSets(r5);
        expandParameterizedLoops(r5);
        this.tool.log("grammar", "after: " + r5.toStringTree());
    }

    public void reduceBlocksToSets(GrammarAST r5) {
        CommonTreeNodeStream r10 = new CommonTreeNodeStream(new GrammarASTAdaptor(), r5);
        GrammarASTAdaptor r11 = new GrammarASTAdaptor();
        BlockSetTransformer r12 = new BlockSetTransformer(r10, this.g);
        r12.setTreeAdaptor(r11);
        r12.downup(r5);
    }
}
