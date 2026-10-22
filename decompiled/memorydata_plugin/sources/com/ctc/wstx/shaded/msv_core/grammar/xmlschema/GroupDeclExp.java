package com.ctc.wstx.shaded.msv_core.grammar.xmlschema;

/* JADX INFO: loaded from: classes2.dex */
public class GroupDeclExp extends RedefinableExp {
    private static final long serialVersionUID = 1;

    public GroupDeclExp(String r1) {
        super(r1);
    }

    @Override // com.ctc.wstx.shaded.msv_core.grammar.xmlschema.RedefinableExp
    public RedefinableExp getClone() {
        GroupDeclExp r0 = new GroupDeclExp(this.name);
        r0.redefine(this);
        return r0;
    }
}
