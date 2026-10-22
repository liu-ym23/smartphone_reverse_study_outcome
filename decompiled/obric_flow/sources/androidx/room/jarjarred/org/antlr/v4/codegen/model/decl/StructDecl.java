package androidx.room.jarjarred.org.antlr.v4.codegen.model.decl;

import androidx.room.jarjarred.org.antlr.v4.codegen.OutputModelFactory;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.DispatchMethod;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.ListenerDispatchMethod;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.ModelElement;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.OutputModelObject;
import androidx.room.jarjarred.org.antlr.v4.codegen.model.VisitorDispatchMethod;
import androidx.room.jarjarred.org.antlr.v4.runtime.misc.OrderedHashSet;
import androidx.room.jarjarred.org.antlr.v4.tool.Attribute;
import androidx.room.jarjarred.org.antlr.v4.tool.Rule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class StructDecl extends Decl {
    public OrderedHashSet<Decl> attributeDecls;

    @ModelElement
    public OrderedHashSet<Decl> attrs;

    @ModelElement
    public Collection<AttributeDecl> ctorAttrs;
    public String derivedFromName;

    @ModelElement
    public List<? super DispatchMethod> dispatchMethods;

    @ModelElement
    public List<OutputModelObject> extensionMembers;

    @ModelElement
    public OrderedHashSet<Decl> getters;

    @ModelElement
    public List<OutputModelObject> interfaces;
    public boolean provideCopyFrom;
    public OrderedHashSet<Decl> ruleContextDecls;
    public OrderedHashSet<Decl> ruleContextListDecls;
    public OrderedHashSet<Decl> tokenDecls;
    public OrderedHashSet<Decl> tokenListDecls;
    public OrderedHashSet<Decl> tokenTypeDecls;

    public StructDecl(OutputModelFactory r5, Rule r10) {
        super(r5, r5.getGenerator().getTarget().getRuleFunctionContextStructName(r10));
        this.attrs = new OrderedHashSet();
        this.getters = new OrderedHashSet();
        this.tokenDecls = new OrderedHashSet();
        this.tokenTypeDecls = new OrderedHashSet();
        this.tokenListDecls = new OrderedHashSet();
        this.ruleContextDecls = new OrderedHashSet();
        this.ruleContextListDecls = new OrderedHashSet();
        this.attributeDecls = new OrderedHashSet();
        addDispatchMethods(r10);
        this.derivedFromName = r10.name;
        this.provideCopyFrom = r10.hasAltSpecificContexts();
    }

    public void addDecl(Decl r5) {
        r5.ctx = this;
        if ((r5 instanceof ContextGetterDecl) == false) goto L5;
        this.getters.add(r5);
    L7:
        if ((r5 instanceof TokenTypeDecl) == false) goto L10;
        this.tokenTypeDecls.add(r5);
        return;
    L10:
        if ((r5 instanceof TokenListDecl) == false) goto L13;
        this.tokenListDecls.add(r5);
        return;
    L13:
        if ((r5 instanceof TokenDecl) == false) goto L16;
        this.tokenDecls.add(r5);
        return;
    L16:
        if ((r5 instanceof RuleContextListDecl) == false) goto L19;
        this.ruleContextListDecls.add(r5);
        return;
    L19:
        if ((r5 instanceof RuleContextDecl) == false) goto L22;
        this.ruleContextDecls.add(r5);
        return;
    L22:
        if ((r5 instanceof AttributeDecl) == false) goto L30;
        this.attributeDecls.add(r5);
        return;
    L30:
        return;
    L5:
        this.attrs.add(r5);
        goto L7
    }

    public void addDecls(Collection<Attribute> r5) {
        Iterator<Attribute> r10 = r5.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        addDecl(r10.next());
        goto L4
    }

    public void addDispatchMethods(Rule r5) {
        this.dispatchMethods = new ArrayList();
        if (r5.hasAltSpecificContexts() == false) goto L5;
        return;
    L5:
        if (this.factory.getGrammar().tool.gen_listener == false) goto L8;
        this.dispatchMethods.add(new ListenerDispatchMethod(this.factory, true));
        this.dispatchMethods.add(new ListenerDispatchMethod(this.factory, false));
    L8:
        if (this.factory.getGrammar().tool.gen_visitor == false) goto L12;
        this.dispatchMethods.add(new VisitorDispatchMethod(this.factory));
        return;
    }

    public void addExtensionMember(OutputModelObject r5) {
        if (this.extensionMembers != null) goto L5;
        this.extensionMembers = new ArrayList();
    L5:
        this.extensionMembers.add(r5);
    }

    public void implementInterface(OutputModelObject r5) {
        if (this.interfaces != null) goto L5;
        this.interfaces = new ArrayList();
    L5:
        this.interfaces.add(r5);
    }

    public boolean isEmpty() {
        return this.attrs.isEmpty();
    }

    public void addDecl(Attribute r5) {
        addDecl(new AttributeDecl(this.factory, r5));
    }
}
