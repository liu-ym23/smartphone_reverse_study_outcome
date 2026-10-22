package com.ctc.wstx.shaded.msv_core.relaxns.grammar;

import com.ctc.wstx.shaded.msv.org_isorelax.a.a;
import com.ctc.wstx.shaded.msv.org_isorelax.a.d;
import com.ctc.wstx.shaded.msv_core.grammar.Expression;
import com.ctc.wstx.shaded.msv_core.grammar.ReferenceExp;
import java.io.Serializable;
import org.xml.sax.SAXNotRecognizedException;

/* JADX INFO: loaded from: classes2.dex */
public class DeclImpl implements a, d, Serializable {
    public final Expression exp;
    protected final String name;

    public DeclImpl(ReferenceExp r2) {
        this(r2.name, r2.exp);
    }

    public DeclImpl(String r1, Expression r2) {
        this.exp = r2;
        this.name = r1;
    }

    public boolean getFeature(String r1) {
        throw new SAXNotRecognizedException(r1);
    }

    @Override // com.ctc.wstx.shaded.msv.org_isorelax.a.d
    public String getName() {
        return this.name;
    }

    public Object getProperty(String r1) {
        throw new SAXNotRecognizedException(r1);
    }
}
