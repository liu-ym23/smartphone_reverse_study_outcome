package androidx.room.jarjarred.org.stringtemplate.v4.compiler;

import ai.j0;
import androidx.room.jarjarred.org.antlr.runtime.Token;
import androidx.room.jarjarred.org.antlr.runtime.TokenStream;
import androidx.room.jarjarred.org.antlr.runtime.tree.CommonTree;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.Interval;
import androidx.room.jarjarred.org.stringtemplate.v4.misc.Misc;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CompiledST implements Cloneable {
    public CommonTree ast;
    public int codeSize;
    public Map<String, FormalArgument> formalArguments;
    public boolean hasFormalArgs;
    public List<CompiledST> implicitlyDefinedTemplates;
    public byte[] instrs;
    public boolean isAnonSubtemplate;
    public boolean isRegion;
    public String name;
    public STGroup nativeGroup;
    public int numberOfArgsWithDefaultValues;
    public String prefix;
    public ST.RegionType regionDefType;
    public Interval[] sourceMap;
    public String[] strings;
    public String template;
    public Token templateDefStartToken;
    public TokenStream tokens;

    public CompiledST() {
        this.prefix = "/";
        this.nativeGroup = STGroup.defaultGroup;
        this.instrs = new byte[15];
        this.sourceMap = new Interval[15];
        this.template = "";
    }

    public void addArg(FormalArgument r5) {
        if (this.formalArguments != null) goto L5;
        this.formalArguments = Collections.synchronizedMap(new LinkedHashMap());
    L5:
        r5.index = this.formalArguments.size();
        this.formalArguments.put(r5.name, r5);
    }

    public void addImplicitlyDefinedTemplate(CompiledST r5) {
        r5.prefix = this.prefix;
        if (r5.name.charAt(0) == '/') goto L6;
        r5.name = r5.prefix + r5.name;
    L6:
        if (this.implicitlyDefinedTemplates != null) goto L8;
        this.implicitlyDefinedTemplates = new ArrayList();
    L8:
        this.implicitlyDefinedTemplates.add(r5);
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m80clone() throws CloneNotSupportedException {
        return clone();
    }

    public void defineArgDefaultValueTemplates(STGroup r13) {
        Map<String, FormalArgument> r5 = this.formalArguments;
        if (r5 != null) goto L5;
        return;
    L5:
        Iterator<String> r10 = r5.keySet().iterator();
    L7:
        if (r10.hasNext() == false) goto L30;
        FormalArgument r11 = this.formalArguments.get(r10.next());
        Token r12 = r11.defaultValueToken;
        if (r12 == null) goto L7;
        boolean r14 = true;
        this.numberOfArgsWithDefaultValues++;
        int r15 = r12.getType();
        if (r15 != 4) goto L13;
        String r16 = j0.q(new StringBuilder(), r11.name, "_default_value");
        CompiledST r17 = new Compiler(r13).compile(r13.getFileName(), r16, null, Misc.strip(r11.defaultValueToken.getText(), 1), r11.defaultValueToken);
        r11.compiledDefaultValue = r17;
        r17.name = r16;
        r17.defineImplicitlyDefinedTemplates(r13);
        goto L7
    L13:
        if (r15 == 8) goto L25;
        if (r15 != 10) goto L17;
        r11.defaultValue = Collections.emptyList();
        goto L7
    L17:
        if (r15 == 13) goto L22;
        if (r15 == 14) goto L25;
        throw new UnsupportedOperationException("Unexpected default value token type.");
    L22:
        r11.defaultValue = Misc.strip(r11.defaultValueToken.getText(), 1);
    L25:
        if (r11.defaultValueToken.getType() == 14) goto L28;
        r14 = false;
    L28:
        r11.defaultValue = Boolean.valueOf(r14);
        goto L7
    }

    public void defineFormalArgs(List<FormalArgument> r5) {
        this.hasFormalArgs = true;
        if (r5 != null) goto L5;
        this.formalArguments = null;
        return;
    L5:
        Iterator<FormalArgument> r10 = r5.iterator();
    L7:
        if (r10.hasNext() == false) goto L11;
        addArg(r10.next());
        goto L7
    }

    public void defineImplicitlyDefinedTemplates(STGroup r5) {
        List<CompiledST> r10 = this.implicitlyDefinedTemplates;
        if (r10 == null) goto L8;
        Iterator<CompiledST> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        CompiledST r12 = r11.next();
        r5.rawDefineTemplate(r12.name, r12, r12.templateDefStartToken);
        r12.defineImplicitlyDefinedTemplates(r5);
        goto L6
    L10:
        return;
    }

    public String disasm() {
        BytecodeDisassembler r5 = new BytecodeDisassembler(this);
        StringWriter r10 = new StringWriter();
        PrintWriter r11 = new PrintWriter(r10);
        r11.println(r5.disassemble());
        r11.println("Strings:");
        r11.println(r5.strings());
        r11.println("Bytecode to template map:");
        r11.println(r5.sourceMap());
        r11.close();
        return r10.toString();
    }

    public void dump() {
        BytecodeDisassembler r5 = new BytecodeDisassembler(this);
        PrintStream r10 = System.out;
        r10.println(this.name + ":");
        r10.println(r5.disassemble());
        r10.println("Strings:");
        r10.println(r5.strings());
        r10.println("Bytecode to template map:");
        r10.println(r5.sourceMap());
    }

    public Interval getTemplateRange() {
        if (this.isAnonSubtemplate == false) goto L16;
        Interval[] r5 = this.sourceMap;
        int r10 = r5.length;
        int r11 = Integer.MAX_VALUE;
        int r12 = Integer.MIN_VALUE;
        int r13 = 0;
    L5:
        if (r13 >= r10) goto L12;
        Interval r14 = r5[r13];
        if (r14 == null) goto L10;
        r11 = Math.min(r11, r14.f683a);
        r12 = Math.max(r12, r14.f684b);
    L10:
        r13 = r13 + 1;
        goto L5
    L12:
        if (r11 > (r12 + 1)) goto L16;
        return new Interval(r11, r12);
    L16:
        return new Interval(0, this.template.length() - 1);
    }

    public String getTemplateSource() {
        Interval r5 = getTemplateRange();
        return this.template.substring(r5.f683a, r5.f684b + 1);
    }

    public String instrs() {
        return new BytecodeDisassembler(this).instrs();
    }

    public CompiledST clone() throws CloneNotSupportedException {
        CompiledST r5 = (CompiledST) super.clone();
        if (this.formalArguments == null) goto L5;
        this.formalArguments = Collections.synchronizedMap(new LinkedHashMap(this.formalArguments));
    L5:
        return r5;
    }
}
