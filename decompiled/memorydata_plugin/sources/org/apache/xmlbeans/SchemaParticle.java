package org.apache.xmlbeans;

import java.math.BigInteger;
import javax.xml.namespace.QName;

/* JADX INFO: loaded from: classes7.dex */
public interface SchemaParticle {
    QNameSet acceptedStartNames();

    boolean canStartWithElement(QName r1);

    int countOfParticleChild();

    int getIntMaxOccurs();

    int getIntMinOccurs();

    BigInteger getMaxOccurs();

    QName getName();

    SchemaParticle getParticleChild(int r1);

    int getParticleType();

    SchemaType getType();

    int getWildcardProcess();

    QNameSet getWildcardSet();

    boolean isSkippable();
}
