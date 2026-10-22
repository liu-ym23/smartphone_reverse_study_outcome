package androidx.room.jarjarred.org.antlr.v4.tool;

import ai.j0;
import androidx.room.jarjarred.org.antlr.v4.Tool;
import androidx.room.jarjarred.org.antlr.v4.codegen.CodeGenerator;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroupFile;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BuildDependencyGenerator {
    protected Grammar g;
    protected CodeGenerator generator;
    protected STGroup templates;
    protected Tool tool;

    public BuildDependencyGenerator(Tool r5, Grammar r10) {
        this.tool = r5;
        this.g = r10;
        this.generator = new CodeGenerator(r5, r10, r10.getOptionString("language"));
    }

    public ST getDependencies() {
        loadDependencyTemplates();
        ST r5 = this.templates.getInstanceOf("dependencies");
        r5.add("in", getDependenciesFileList());
        r5.add("out", getGeneratedFileList());
        r5.add("grammarFileName", this.g.fileName);
        return r5;
    }

    public List<File> getDependenciesFileList() {
        List<File> r5 = getNonImportDependenciesFileList();
        List<Grammar> r10 = this.g.getAllImportedGrammars();
        if (r10 == null) goto L9;
        Iterator<Grammar> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L9;
        Grammar r12 = r11.next();
        r5.add(new File(groomQualifiedFileName(this.tool.libDirectory, r12.fileName)));
    L9:
        if (r5.isEmpty() == false) goto L12;
        return null;
    L12:
        return r5;
    }

    public List<File> getGeneratedFileList() {
        ArrayList r5 = new ArrayList();
        if (this.generator.getTarget().needsHeader() == false) goto L5;
        r5.add(getOutputFile(this.generator.getRecognizerFileName(true)));
    L5:
        r5.add(getOutputFile(this.generator.getRecognizerFileName(false)));
        r5.add(getOutputFile(this.generator.getVocabFileName()));
        ST r10 = this.generator.getTemplates().getInstanceOf("codeFileExtension");
        if (this.generator.getTemplates().isDefined("headerFile") == false) goto L8;
        ST r11 = this.generator.getTemplates().getInstanceOf("headerFileExtension");
        r5.add(getOutputFile(this.g.name + Grammar.getGrammarTypeToFileNameSuffix(this.g.getType()) + r11.render()));
    L10:
        if (this.g.isCombined() == false) goto L15;
        String r12 = Grammar.getGrammarTypeToFileNameSuffix(31);
        r5.add(getOutputFile(this.g.name + r12 + r10.render()));
        r5.add(getOutputFile(this.g.name + r12 + CodeGenerator.VOCAB_FILE_EXTENSION));
        if (r11 == null) goto L15;
        r5.add(getOutputFile(this.g.name + r12 + r11.render()));
    L15:
        if (this.g.tool.gen_listener == false) goto L24;
        if (this.generator.getTarget().needsHeader() == false) goto L19;
        r5.add(getOutputFile(this.generator.getListenerFileName(true)));
    L19:
        r5.add(getOutputFile(this.generator.getListenerFileName(false)));
        if (this.generator.getTarget().needsHeader() == false) goto L22;
        r5.add(getOutputFile(this.generator.getBaseListenerFileName(true)));
    L22:
        r5.add(getOutputFile(this.generator.getBaseListenerFileName(false)));
    L24:
        if (this.g.tool.gen_visitor == true) goto L26;
    L32:
        List<Grammar> r13 = this.g.getAllImportedGrammars();
        if (r13 == null) goto L39;
        Iterator<Grammar> r14 = r13.iterator();
    L36:
        if (r14.hasNext() == false) goto L39;
        r5.add(getOutputFile(r14.next().fileName));
    L39:
        if (r5.isEmpty() == false) goto L41;
        return null;
    L41:
        return r5;
    L26:
        if (this.generator.getTarget().needsHeader() == false) goto L28;
        r5.add(getOutputFile(this.generator.getVisitorFileName(true)));
    L28:
        r5.add(getOutputFile(this.generator.getVisitorFileName(false)));
        if (this.generator.getTarget().needsHeader() == false) goto L31;
        r5.add(getOutputFile(this.generator.getBaseVisitorFileName(true)));
    L31:
        r5.add(getOutputFile(this.generator.getBaseVisitorFileName(false)));
        goto L32
    L8:
        r11 = null;
        goto L10
    }

    public CodeGenerator getGenerator() {
        return this.generator;
    }

    public List<File> getNonImportDependenciesFileList() {
        ArrayList r5 = new ArrayList();
        String r10 = this.g.getOptionString("tokenVocab");
        if (r10 == null) goto L9;
        String r11 = r10.concat(CodeGenerator.VOCAB_FILE_EXTENSION);
        if (this.tool.libDirectory.equals(".") == false) goto L7;
        File r12 = new File(r11);
    L8:
        r5.add(r12);
        goto L9
    L7:
        r12 = new File(this.tool.libDirectory, r11);
    L9:
        return r5;
    }

    public File getOutputFile(String r5) {
        File r10 = this.tool.getOutputDirectory(this.g.fileName);
        if (r10.toString().equals(".") == false) goto L6;
        r10 = this.tool.getOutputDirectory(r5);
    L6:
        if (r10.toString().equals(".") == false) goto L10;
        return new File(r5);
    L10:
        if (r10.getName().equals(".") == false) goto L13;
        int r11 = r10.toString().lastIndexOf(46);
        r10 = new File(r10.toString().substring(0, r11));
    L13:
        if (r10.getName().indexOf(32) < 0) goto L16;
        r10 = new File(r10.toString().replace(" ", "\\ "));
    L16:
        return new File(r10, r5);
    }

    public String groomQualifiedFileName(String r5, String r10) {
        if (r5.equals(".") == false) goto L6;
        return r10;
    L6:
        if (r5.indexOf(32) < 0) goto L10;
        return j0.q(j0.u(r5.replace(" ", "\\ ")), File.separator, r10);
    L10:
        return j0.q(j0.u(r5), File.separator, r10);
    }

    public void loadDependencyTemplates() {
        if (this.templates == null) goto L5;
        return;
    L5:
        this.templates = new STGroupFile("androidx/room/jarjarred/org/antlr/v4/tool/templates/depend.stg", "UTF-8");
    }
}
