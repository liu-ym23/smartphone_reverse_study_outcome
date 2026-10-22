package org.apache.xmlbeans;

/* JADX INFO: loaded from: classes7.dex */
public interface SchemaLocalElement extends SchemaField {
    boolean blockExtension();

    boolean blockRestriction();

    boolean blockSubstitution();

    SchemaIdentityConstraint[] getIdentityConstraints();

    boolean isAbstract();
}
