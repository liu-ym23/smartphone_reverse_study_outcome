package androidx.room.jarjarred.org.antlr.v4.codegen;

import androidx.room.jarjarred.org.antlr.runtime.ANTLRStringStream;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.RuleFunction;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.ActionChunk;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.ActionText;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.ArgRef;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.LabelRef;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.ListLabelRef;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.LocalRef;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.NonLocalAttrRef;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.QRetValueRef;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.RetValueRef;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.RulePropertyRef;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.RulePropertyRef_ctx;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.RulePropertyRef_parser;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.RulePropertyRef_start;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.RulePropertyRef_stop;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.RulePropertyRef_text;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.SetAttr;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.SetNonLocalAttr;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.ThisRulePropertyRef_ctx;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.ThisRulePropertyRef_parser;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.ThisRulePropertyRef_start;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.ThisRulePropertyRef_stop;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.ThisRulePropertyRef_text;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.TokenPropertyRef;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.TokenPropertyRef_channel;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.TokenPropertyRef_index;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.TokenPropertyRef_int;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.TokenPropertyRef_line;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.TokenPropertyRef_pos;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.TokenPropertyRef_text;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.TokenPropertyRef_type;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.chunk.TokenRef;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.decl.StructDecl;
import androidx.room.jarjarred.org.antlr.v4.parse.ActionSplitter;
import androidx.room.jarjarred.org.antlr.v4.parse.ActionSplitterListener;
import androidx.room.jarjarred.org.antlr.v4.tool.Attribute;
import androidx.room.jarjarred.org.antlr.v4.tool.AttributeDict;
import androidx.room.jarjarred.org.antlr.v4.tool.ErrorType;
import androidx.room.jarjarred.org.antlr.v4.tool.Grammar;
import androidx.room.jarjarred.org.antlr.v4.tool.Rule;
import androidx.room.jarjarred.org.antlr.v4.tool.ast.ActionAST;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ActionTranslator implements ActionSplitterListener {
    public static final Map<String, Class<? extends RulePropertyRef>> rulePropToModelMap = null;
    public static final Map<String, Class<? extends RulePropertyRef>> thisRulePropToModelMap = null;
    public static final Map<String, Class<? extends TokenPropertyRef>> tokenPropToModelMap = null;
    List<ActionChunk> chunks;
    OutputModelFactory factory;
    CodeGenerator gen;
    ActionAST node;
    StructDecl nodeContext;

    /* JADX INFO: renamed from: rf, reason: collision with root package name */
    RuleFunction f640rf;

    /* JADX INFO: renamed from: androidx.room.jarjarred.org.antlr.v4.codegen.ActionTranslator$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$antlr$v4$tool$AttributeDict$DictType = null;

        static {
            int[] r5 = new int[AttributeDict.DictType.values().length];
            $SwitchMap$org$antlr$v4$tool$AttributeDict$DictType = r5;
            r5[AttributeDict.DictType.ARG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$org$antlr$v4$tool$AttributeDict$DictType[AttributeDict.DictType.RET.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$org$antlr$v4$tool$AttributeDict$DictType[AttributeDict.DictType.LOCAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$org$antlr$v4$tool$AttributeDict$DictType[AttributeDict.DictType.PREDEFINED_RULE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$org$antlr$v4$tool$AttributeDict$DictType[AttributeDict.DictType.TOKEN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static {
        HashMap r5 = new HashMap();
        thisRulePropToModelMap = r5;
        r5.put("start", ThisRulePropertyRef_start.class);
        r5.put("stop", ThisRulePropertyRef_stop.class);
        r5.put(MessageIndication.CONTENT_TYPE_TEXT, ThisRulePropertyRef_text.class);
        r5.put("ctx", ThisRulePropertyRef_ctx.class);
        r5.put("parser", ThisRulePropertyRef_parser.class);
        HashMap r10 = new HashMap();
        rulePropToModelMap = r10;
        r10.put("start", RulePropertyRef_start.class);
        r10.put("stop", RulePropertyRef_stop.class);
        r10.put(MessageIndication.CONTENT_TYPE_TEXT, RulePropertyRef_text.class);
        r10.put("ctx", RulePropertyRef_ctx.class);
        r10.put("parser", RulePropertyRef_parser.class);
        HashMap r11 = new HashMap();
        tokenPropToModelMap = r11;
        r11.put(MessageIndication.CONTENT_TYPE_TEXT, TokenPropertyRef_text.class);
        r11.put("type", TokenPropertyRef_type.class);
        r11.put(SVGRenderEngine.LINE, TokenPropertyRef_line.class);
        r11.put("index", TokenPropertyRef_index.class);
        r11.put(OpenPageMethod.KEY_POS, TokenPropertyRef_pos.class);
        r11.put(LynxMonitorService.KEY_CHANNEL, TokenPropertyRef_channel.class);
        r11.put("int", TokenPropertyRef_int.class);
    }

    public ActionTranslator(OutputModelFactory r5, ActionAST r10) {
        this.chunks = new ArrayList();
        this.factory = r5;
        this.node = r10;
        this.gen = r5.getGenerator();
    }

    public static String toString(List<ActionChunk> r5) {
        StringBuilder r10 = new StringBuilder();
        Iterator<ActionChunk> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        r10.append(r11.next().toString());
        goto L4
    L7:
        return r10.toString();
    }

    public static List<ActionChunk> translateAction(OutputModelFactory r5, RuleFunction r10, Token r11, ActionAST r12) {
        String r13 = r11.getText();
        if (r13 == null) goto L13;
        if (r13.length() <= 0) goto L13;
        if (r13.charAt(0) != '{') goto L13;
        int r14 = r13.indexOf(123);
        int r15 = r13.lastIndexOf(125);
        if (r14 < 0) goto L13;
        if (r15 < 0) goto L13;
        r13 = r13.substring(r14 + 1, r15);
    L13:
        return translateActionChunk(r5, r10, r13, r12);
    }

    public static List<ActionChunk> translateActionChunk(OutputModelFactory r5, RuleFunction r10, String r11, ActionAST r12) {
        Token r13 = r12.token;
        ActionTranslator r14 = new ActionTranslator(r5, r12);
        r14.f640rf = r10;
        r5.getGrammar().tool.log("action-translator", "translate " + r11);
        String r15 = r12.getAltLabel();
        if (r10 == null) goto L7;
        r14.nodeContext = r10.ruleCtx;
        if (r15 == null) goto L7;
        r14.nodeContext = r10.altLabelCtxs.get(r15);
    L7:
        ANTLRStringStream r16 = new ANTLRStringStream(r11);
        r16.setLine(r13.getLine());
        r16.setCharPositionInLine(r13.getCharPositionInLine());
        new ActionSplitter(r16, r14).getActionTokens();
        return r14.chunks;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.ActionSplitterListener
    public void attr(String r5, Token r10) {
        this.gen.g.tool.log("action-translator", "attr " + r10);
        Attribute r11 = this.node.resolver.resolveToAttribute(r10.getText(), this.node);
        if (r11 == null) goto L18;
        int r12 = AnonymousClass1.$SwitchMap$org$antlr$v4$tool$AttributeDict$DictType[r11.dict.type.ordinal()];
        if (r12 != 1) goto L7;
        this.chunks.add(new ArgRef(this.nodeContext, r10.getText()));
        goto L18
    L7:
        if (r12 != 2) goto L9;
        this.chunks.add(new RetValueRef(this.f640rf.ruleCtx, r10.getText()));
        goto L18
    L9:
        if (r12 != 3) goto L11;
        this.chunks.add(new LocalRef(this.nodeContext, r10.getText()));
        goto L18
    L11:
        if (r12 != 4) goto L18;
        this.chunks.add(getRulePropertyRef(r10));
    L18:
        if (this.node.resolver.resolvesToToken(r10.getText(), this.node) == false) goto L22;
        this.chunks.add(new TokenRef(this.nodeContext, getTokenLabel(r10.getText())));
        return;
    L22:
        if (this.node.resolver.resolvesToLabel(r10.getText(), this.node) == false) goto L26;
        this.chunks.add(new LabelRef(this.nodeContext, getTokenLabel(r10.getText())));
        return;
    L26:
        if (this.node.resolver.resolvesToListLabel(r10.getText(), this.node) == false) goto L30;
        this.chunks.add(new ListLabelRef(this.nodeContext, r10.getText()));
        return;
    L30:
        if (this.factory.getGrammar().getRule(r10.getText()) == null) goto L33;
        this.chunks.add(new LabelRef(this.nodeContext, getRuleLabel(r10.getText())));
        return;
    }

    public String getRuleLabel(String r5) {
        ActionAST r10 = this.node;
        if (r10.resolver.resolvesToLabel(r5, r10) == false) goto L6;
        return r5;
    L6:
        return this.factory.getGenerator().getTarget().getImplicitRuleLabel(r5);
    }

    public RulePropertyRef getRulePropertyRef(Token r5) {
        return thisRulePropToModelMap.get(r5.getText()).getConstructor(new Class[]{StructDecl.class, String.class}).newInstance(new Object[]{this.nodeContext, getRuleLabel(r5.getText())});
    L4:
        e = move-exception;
        this.factory.getGrammar().tool.errMgr.toolError(ErrorType.INTERNAL_ERROR, e, new Object[0]);
        return null;
    }

    public String getTokenLabel(String r5) {
        ActionAST r10 = this.node;
        if (r10.resolver.resolvesToLabel(r5, r10) == false) goto L6;
        return r5;
    L6:
        return this.factory.getGenerator().getTarget().getImplicitTokenLabel(r5);
    }

    public TokenPropertyRef getTokenPropertyRef(Token r5, Token r10) {
        return tokenPropToModelMap.get(r10.getText()).getConstructor(new Class[]{StructDecl.class, String.class}).newInstance(new Object[]{this.nodeContext, getTokenLabel(r5.getText())});
    L4:
        e = move-exception;
        this.factory.getGrammar().tool.errMgr.toolError(ErrorType.INTERNAL_ERROR, e, new Object[0]);
        return null;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.ActionSplitterListener
    public void nonLocalAttr(String r5, Token r10, Token r11) {
        this.gen.g.tool.log("action-translator", "nonLocalAttr " + r10 + "::" + r11);
        this.chunks.add(new NonLocalAttrRef(this.nodeContext, r10.getText(), r11.getText(), this.factory.getGrammar().getRule(r10.getText()).index));
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.ActionSplitterListener
    public void qualifiedAttr(String r5, Token r10, Token r11) {
        this.gen.g.tool.log("action-translator", "qattr " + r10 + "." + r11);
        if (this.node.resolver.resolveToAttribute(r10.getText(), this.node) == null) goto L6;
        attr(r5, r10);
        this.chunks.add(new ActionText(this.nodeContext, "." + r11.getText()));
        return;
    L6:
        Attribute r12 = this.node.resolver.resolveToAttribute(r10.getText(), r11.getText(), this.node);
        if (r12 != null) goto L10;
        Grammar r13 = this.gen.g;
        r13.tool.errMgr.grammarError(ErrorType.UNKNOWN_SIMPLE_ATTRIBUTE, r13.fileName, r10, new Object[]{r10.getText(), "rule"});
        return;
    L10:
        int r14 = AnonymousClass1.$SwitchMap$org$antlr$v4$tool$AttributeDict$DictType[r12.dict.type.ordinal()];
        if (r14 != 1) goto L13;
        this.chunks.add(new ArgRef(this.nodeContext, r11.getText()));
        return;
    L13:
        if (r14 != 2) goto L15;
        this.chunks.add(new QRetValueRef(this.nodeContext, getRuleLabel(r10.getText()), r11.getText()));
        return;
    L15:
        if (r14 != 4) goto L17;
        this.chunks.add(getRulePropertyRef(r10, r11));
        return;
    L17:
        if (r14 != 5) goto L27;
        this.chunks.add(getTokenPropertyRef(r10, r11));
        return;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.ActionSplitterListener
    public void setAttr(String r5, Token r10, Token r11) {
        this.gen.g.tool.log("action-translator", "setAttr " + r10 + " " + r11);
        this.chunks.add(new SetAttr(this.nodeContext, r10.getText(), translateActionChunk(this.factory, this.f640rf, r11.getText(), this.node)));
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.ActionSplitterListener
    public void setNonLocalAttr(String r10, Token r11, Token r12, Token r13) {
        this.gen.g.tool.log("action-translator", "setNonLocalAttr " + r11 + "::" + r12 + "=" + r13);
        Rule r14 = this.factory.getGrammar().getRule(r11.getText());
        this.chunks.add(new SetNonLocalAttr(this.nodeContext, r11.getText(), r12.getText(), r14.index, translateActionChunk(this.factory, this.f640rf, r13.getText(), this.node)));
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.parse.ActionSplitterListener
    public void text(String r5) {
        this.chunks.add(new ActionText(this.nodeContext, r5));
    }

    public RulePropertyRef getRulePropertyRef(Token r5, Token r10) {
        Grammar r11 = this.factory.getGrammar();
        return rulePropToModelMap.get(r10.getText()).getConstructor(new Class[]{StructDecl.class, String.class}).newInstance(new Object[]{this.nodeContext, getRuleLabel(r5.getText())});
    L5:
        e = move-exception;
        r11.tool.errMgr.toolError(ErrorType.INTERNAL_ERROR, e, new Object[]{r10.getText()});
        return null;
    }
}
