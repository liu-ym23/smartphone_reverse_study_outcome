package androidx.room.jarjarred.org.antlr.v4.analysis;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.jarjarred.org.antlr.runtime.CommonToken;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.TokenStream;
import androidx.room.jarjarred.org.antlr.runtime.tree.CommonTreeNodeStream;
import androidx.room.jarjarred.org.antlr.runtime.tree.Tree;
import androidx.room.jarjarred.org.antlr.v4.Tool;
import androidx.room.jarjarred.org.antlr.v4.codegen.CodeGenerator;
import androidx.room.jarjarred.org.antlr.v4.parse.GrammarASTAdaptor;
import androidx.room.jarjarred.org.antlr.v4.parse.LeftRecursiveRuleWalker;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.IntervalSet;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.Pair;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorType;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.AltAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarAST;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.GrammarASTWithOptions;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.RuleRefAST;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroupFile;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public class LeftRecursiveRuleAnalyzer extends LeftRecursiveRuleWalker {
    public Map<Integer, ASSOC> altAssociativity;
    public LinkedHashMap<Integer, LeftRecursiveRuleAltInfo> binaryAlts;
    public STGroup codegenTemplates;
    public String language;
    public List<Pair<GrammarAST, String>> leftRecursiveRuleRefLabels;
    public List<LeftRecursiveRuleAltInfo> prefixAndOtherAlts;
    public STGroup recRuleTemplates;
    public GrammarAST retvals;
    public String ruleName;
    public LinkedHashMap<Integer, LeftRecursiveRuleAltInfo> suffixAlts;
    public LinkedHashMap<Integer, LeftRecursiveRuleAltInfo> ternaryAlts;
    public final TokenStream tokenStream;
    public Tool tool;

    public static final enum ASSOC extends Enum<ASSOC> {
        private static final /* synthetic */ ASSOC[] $VALUES = null;
        public static final ASSOC left = null;
        public static final ASSOC right = null;

        static {
            ASSOC r5 = new ASSOC(OpenPageMethod.ALIGN_LEFT, 0);
            left = r5;
            ASSOC r10 = new ASSOC("right", 1);
            right = r10;
            $VALUES = new ASSOC[]{r5, r10};
        }

        private ASSOC(String r5, int r10) {
            super(r5, r10);
        }

        public static ASSOC valueOf(String r5) {
            return (ASSOC) Enum.valueOf(ASSOC.class, r5);
        }

        public static ASSOC[] values() {
            return (ASSOC[]) $VALUES.clone();
        }
    }

    public LeftRecursiveRuleAnalyzer(GrammarAST r5, Tool r10, String r11, String r12) {
        super(new CommonTreeNodeStream(new GrammarASTAdaptor(r5.token.getInputStream()), r5));
        this.binaryAlts = new LinkedHashMap();
        this.ternaryAlts = new LinkedHashMap();
        this.suffixAlts = new LinkedHashMap();
        this.prefixAndOtherAlts = new ArrayList();
        this.leftRecursiveRuleRefLabels = new ArrayList();
        this.altAssociativity = new HashMap();
        this.tool = r10;
        this.ruleName = r11;
        this.language = r12;
        TokenStream r13 = r5.g.tokenStream;
        this.tokenStream = r13;
        if (r13 == null) goto L7;
        loadPrecRuleTemplates();
        return;
    L7:
        throw new NullPointerException("grammar must have a token stream");
    }

    public static boolean hasImmediateRecursiveRuleRefs(GrammarAST r10, String r11) {
        if (r10 != null) goto L5;
        return false;
    L5:
        GrammarAST r12 = (GrammarAST) r10.getFirstChildWithType(78);
        if (r12 != null) goto L8;
        return false;
    L8:
        int r5 = r12.getChildren().size();
        int r13 = 0;
    L9:
        if (r13 >= r5) goto L31;
        GrammarAST r14 = (GrammarAST) r12.getChildren().get(r13);
        Tree r15 = r14.getChild(0);
        if (r15 == null) goto L30;
        if (r15.getType() != 82) goto L19;
        r15 = r14.getChild(1);
        if (r15 == null) goto L30;
    L19:
        if (r15.getType() == 57) goto L21;
    L23:
        Tree r16 = r15.getChild(1);
        if (r16 == null) goto L30;
        if (r16.getType() != 57) goto L30;
        if (r16.getText().equals(r11) == false) goto L30;
        return true;
    L21:
        if (r15.getText().equals(r11) == false) goto L23;
        return true;
    L30:
        r13 = r13 + 1;
        goto L9
    L31:
        return false;
    }

    public AltAST addPrecedenceArgToRules(AltAST r10, int r11) {
        if (r10 != null) goto L5;
        return null;
    L5:
        List<GrammarAST> r5 = r10.getNodesWithTypePreorderDFS(IntervalSet.of(57));
        Iterator<GrammarAST> r12 = r5.iterator();
    L7:
        if (r12.hasNext() == false) goto L15;
        RuleRefAST r13 = (RuleRefAST) r12.next();
        boolean r14 = r13.getText().equals(this.ruleName);
        boolean r15 = true;
        if (r13 == j0.e(r5, 1)) goto L12;
        r15 = false;
    L12:
        if (r14 == false) goto L7;
        if (r15 == false) goto L7;
        r13.setOption(LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME, new GrammarAST(new CommonToken(30, j0.g(r11, ""))));
        goto L7
    L15:
        return r10;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.LeftRecursiveRuleWalker
    public void binaryAlt(AltAST r11, int r12) {
        AltAST r5 = (AltAST) r11.dupTree();
        GrammarAST r10 = r5.altLabel;
        String r13 = null;
        if (r10 == null) goto L5;
        String r14 = r10.getText();
    L6:
        GrammarAST r15 = stripLeftRecursion(r5);
        boolean r16 = false;
        if (r15 == null) goto L12;
        r13 = r15.getText();
        if (r15.getParent().getType() != 46) goto L11;
        r16 = true;
    L11:
        this.leftRecursiveRuleRefLabels.add(new Pair(r15, r14));
    L12:
        stripAltLabel(r5);
        int r17 = nextPrecedence(r12);
        AltAST r18 = addPrecedenceArgToRules(r5, r17);
        stripAltLabel(r18);
        LeftRecursiveRuleAltInfo r19 = new LeftRecursiveRuleAltInfo(r12, text(r18).trim(), r13, r14, r16, r11);
        r19.nextPrec = r17;
        this.binaryAlts.put(Integer.valueOf(r12), r19);
        return;
    L5:
        r14 = null;
        goto L6
    }

    public String getArtificialOpPrecRule() {
        ST r5 = this.recRuleTemplates.getInstanceOf("recRule");
        r5.add("ruleName", this.ruleName);
        r5.add("argName", this.codegenTemplates.getInstanceOf("recRuleArg"));
        r5.add("setResultAction", this.codegenTemplates.getInstanceOf("recRuleSetResultAction"));
        r5.add("userRetvals", this.retvals);
        LinkedHashMap r10 = new LinkedHashMap();
        r10.putAll(this.binaryAlts);
        r10.putAll(this.ternaryAlts);
        r10.putAll(this.suffixAlts);
        Iterator r11 = r10.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Integer r12 = (Integer) r11.next();
        int r13 = r12.intValue();
        LeftRecursiveRuleAltInfo r14 = (LeftRecursiveRuleAltInfo) r10.get(r12);
        ST r15 = this.recRuleTemplates.getInstanceOf("recRuleAlt");
        ST r16 = this.codegenTemplates.getInstanceOf("recRuleAltPredicate");
        r16.add("opPrec", Integer.valueOf(precedence(r13)));
        r16.add("ruleName", this.ruleName);
        r15.add("pred", r16);
        r15.add("alt", r14);
        r15.add("precOption", LeftRecursiveRuleTransformer.PRECEDENCE_OPTION_NAME);
        r15.add("opPrec", Integer.valueOf(precedence(r13)));
        r5.add("opAlts", r15);
        goto L4
    L6:
        r5.add("primaryAlts", this.prefixAndOtherAlts);
        this.tool.log("left-recursion", r5.render());
        return r5.render();
    }

    public void loadPrecRuleTemplates() {
        STGroupFile r5 = new STGroupFile("androidx/room/jarjarred/org/antlr/v4/tool/templates/LeftRecursiveRules.stg");
        this.recRuleTemplates = r5;
        if (r5.isDefined("recRule") == true) goto L5;
        this.tool.errMgr.toolError(ErrorType.MISSING_CODE_GEN_TEMPLATES, new Object[]{"LeftRecursiveRules"});
    L5:
        this.codegenTemplates = new CodeGenerator(this.tool, null, this.language).getTemplates();
    }

    public int nextPrecedence(int r5) {
        int r10 = precedence(r5);
        if (this.altAssociativity.get(Integer.valueOf(r5)) != ASSOC.right) goto L6;
        return r10;
    L6:
        return r10 + 1;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.LeftRecursiveRuleWalker
    public void otherAlt(AltAST r10, int r11) {
        AltAST r5 = (AltAST) r10.dupTree();
        stripAltLabel(r5);
        String r12 = text(r5);
        GrammarAST r13 = r5.altLabel;
        if (r13 == null) goto L6;
        String r14 = r13.getText();
    L7:
        LeftRecursiveRuleAltInfo r15 = new LeftRecursiveRuleAltInfo(r11, r12, null, r14, false, r10);
        this.prefixAndOtherAlts.add(r15);
        return;
    L6:
        r14 = null;
        goto L7
    }

    public int precedence(int r5) {
        return (this.numAlts - r5) + 1;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.LeftRecursiveRuleWalker
    public void prefixAlt(AltAST r11, int r12) {
        AltAST r5 = (AltAST) r11.dupTree();
        stripAltLabel(r5);
        int r10 = precedence(r12);
        AltAST r13 = addPrecedenceArgToRules(r5, r10);
        String r14 = text(r13).trim();
        GrammarAST r15 = r13.altLabel;
        if (r15 == null) goto L6;
        String r16 = r15.getText();
    L7:
        LeftRecursiveRuleAltInfo r17 = new LeftRecursiveRuleAltInfo(r12, r14, null, r16, false, r11);
        r17.nextPrec = r10;
        this.prefixAndOtherAlts.add(r17);
        return;
    L6:
        r16 = null;
        goto L7
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.LeftRecursiveRuleWalker
    public void setAltAssoc(AltAST r10, int r11) {
        ASSOC r5 = ASSOC.left;
        if (r10.getOptions() == null) goto L14;
        String r12 = r10.getOptionString("assoc");
        if (r12 == null) goto L14;
        ASSOC r13 = ASSOC.right;
        if (r12.equals(r13.toString()) == false) goto L10;
        r5 = r13;
        goto L14
    L10:
        if (r12.equals(r5.toString()) == true) goto L14;
        this.tool.errMgr.grammarError(ErrorType.ILLEGAL_OPTION_VALUE, r10.g.fileName, r10.getOptionAST("assoc").getToken(), new Object[]{"assoc", r5});
    L14:
        if (this.altAssociativity.get(Integer.valueOf(r11)) != null) goto L16;
    L18:
        this.altAssociativity.put(Integer.valueOf(r11), r5);
        return;
    L16:
        if (this.altAssociativity.get(Integer.valueOf(r11)) == r5) goto L18;
        this.tool.errMgr.toolError(ErrorType.INTERNAL_ERROR, new Object[]{j0.h(r11, "all operators of alt ", " of left-recursive rule must have same associativity")});
        goto L18
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.LeftRecursiveRuleWalker
    public void setReturnValues(GrammarAST r5) {
        this.retvals = r5;
    }

    public void stripAltLabel(GrammarAST r5) {
        int r10 = r5.getTokenStartIndex();
        int r11 = r5.getTokenStopIndex();
    L3:
        if (r11 < r10) goto L9;
        if (this.tokenStream.get(r11).getType() == 47) goto L6;
        r11 = r11 - 1;
        goto L3
    L6:
        r5.setTokenStopIndex(r11 - 1);
        return;
    }

    public GrammarAST stripLeftRecursion(GrammarAST r10) {
        GrammarAST r5 = (GrammarAST) r10.getChild(0);
        if (r5.getType() != 82) goto L5;
        r5 = (GrammarAST) r10.getChild(1);
        int r11 = 1;
    L6:
        Tree r12 = r5.getChild(1);
        GrammarAST r13 = null;
        if (r5.getType() == 57) goto L9;
    L10:
        if (r12 != null) goto L12;
    L21:
        return r13;
    L12:
        if (r12.getType() != 57) goto L21;
        if (r12.getText().equals(this.ruleName) == false) goto L21;
    L16:
        if (r5.getType() != 10) goto L18;
    L19:
        r13 = (GrammarAST) r5.getChild(0);
    L20:
        r10.deleteChild(r11);
        r10.setTokenStartIndex(((GrammarAST) r10.getChild(r11)).getTokenStartIndex());
        goto L21
    L18:
        if (r5.getType() != 46) goto L20;
    L9:
        if (r5.getText().equals(this.ruleName) == true) goto L16;
    L5:
        r11 = 0;
        goto L6
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.LeftRecursiveRuleWalker
    public void suffixAlt(AltAST r11, int r12) {
        AltAST r5 = (AltAST) r11.dupTree();
        GrammarAST r10 = r5.altLabel;
        String r13 = null;
        if (r10 == null) goto L5;
        String r14 = r10.getText();
    L6:
        GrammarAST r15 = stripLeftRecursion(r5);
        boolean r16 = false;
        if (r15 == null) goto L12;
        r13 = r15.getText();
        if (r15.getParent().getType() != 46) goto L11;
        r16 = true;
    L11:
        this.leftRecursiveRuleRefLabels.add(new Pair(r15, r14));
    L12:
        stripAltLabel(r5);
        this.suffixAlts.put(Integer.valueOf(r12), new LeftRecursiveRuleAltInfo(r12, text(r5).trim(), r13, r14, r16, r11));
        return;
    L5:
        r14 = null;
        goto L6
    }

    public String text(GrammarAST r13) {
        if (r13 != null) goto L5;
        return "";
    L5:
        int r5 = r13.getTokenStartIndex();
        int r10 = r13.getTokenStopIndex();
        IntervalSet r11 = new IntervalSet(new int[0]);
        Iterator<GrammarAST> r12 = r13.getNodesWithType(82).iterator();
    L7:
        if (r12.hasNext() == false) goto L9;
        GrammarAST r14 = r12.next();
        r11.add(r14.getTokenStartIndex(), r14.getTokenStopIndex());
        goto L7
    L9:
        IntervalSet r15 = new IntervalSet(new int[0]);
        Iterator<GrammarAST> r16 = r13.getNodesWithType(new IntervalSet(new int[]{10, 46})).iterator();
    L11:
        if (r16.hasNext() == false) goto L13;
        r15.add(r16.next().getChild(0).getTokenStartIndex());
        goto L11
    L13:
        StringBuilder r17 = new StringBuilder();
    L14:
        if (r5 > r10) goto L49;
        if (r11.contains(r5) == true) goto L17;
        Token r18 = this.tokenStream.get(r5);
        StringBuilder r19 = new StringBuilder();
        if (r15.contains(r5) == true) goto L38;
        GrammarAST r20 = r13.getNodeWithTokenIndex(r18.getTokenIndex());
        if (r20 == null) goto L30;
        if (r18.getType() != 66) goto L25;
    L28:
        r19.append("tokenIndex=");
        r19.append(r18.getTokenIndex());
        goto L30
    L25:
        if (r18.getType() == 62) goto L28;
        if (r18.getType() == 57) goto L28;
    L30:
        if ((r20 instanceof GrammarASTWithOptions) == false) goto L38;
        Iterator<Map.Entry<String, GrammarAST>> r21 = ((GrammarASTWithOptions) r20).getOptions().entrySet().iterator();
    L33:
        if (r21.hasNext() == false) goto L38;
        Map.Entry<String, GrammarAST> r110 = r21.next();
        if (r19.length() <= 0) goto L37;
        r19.append(',');
    L37:
        r19.append(r110.getKey());
        r19.append('=');
        r19.append(r110.getValue().getText());
    L38:
        r17.append(r18.getText());
        int r22 = r5 + 1;
        if (r18.getType() != 57) goto L44;
        if (r22 > r10) goto L44;
        if (this.tokenStream.get(r22).getType() != 8) goto L44;
        r17.append("[" + this.tokenStream.get(r22).getText() + ']');
        r5 = r5 + 2;
    L46:
        if (r19.length() <= 0) goto L14;
        r17.append(Typography.less);
        r17.append(r19);
        r17.append(Typography.greater);
    L44:
        r5 = r22;
        goto L46
    L17:
        r5 = r5 + 1;
        goto L14
    L49:
        return r17.toString();
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("PrecRuleOperatorCollector{binaryAlts=");
        r5.append(this.binaryAlts);
        r5.append(", ternaryAlts=");
        r5.append(this.ternaryAlts);
        r5.append(", suffixAlts=");
        r5.append(this.suffixAlts);
        r5.append(", prefixAndOtherAlts=");
        return a.v(r5, this.prefixAndOtherAlts, '}');
    }
}
