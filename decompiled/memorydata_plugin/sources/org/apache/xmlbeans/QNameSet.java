package org.apache.xmlbeans;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;
import javax.xml.namespace.QName;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes7.dex */
public final class QNameSet implements Serializable, QNameSetSpecification {
    public static final QNameSet ALL = null;
    public static final QNameSet EMPTY = null;
    public static final QNameSet LOCAL = null;
    public static final QNameSet NONLOCAL = null;
    private static final long serialVersionUID = 1;
    private final Set<QName> _excludedQNames;
    private final Set<QName> _includedQNames;
    private final Set<String> _includedURIs;
    private final boolean _inverted;

    static {
        EMPTY = new QNameSet(null, Collections.emptySet(), Collections.emptySet(), Collections.emptySet());
        ALL = new QNameSet(Collections.emptySet(), null, Collections.emptySet(), Collections.emptySet());
        LOCAL = new QNameSet(null, Collections.singleton(""), Collections.emptySet(), Collections.emptySet());
        NONLOCAL = new QNameSet(Collections.singleton(""), null, Collections.emptySet(), Collections.emptySet());
    }

    private QNameSet(Set<String> r3, Set<String> r4, Set<QName> r5, Set<QName> r6) {
        Set<String> r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Set<String> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Set<QName> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Set<QName> r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L6;
        if (r7 != null) goto L6;
        this._inverted = false;
        this._includedURIs = r8;
        this._excludedQNames = r9;
        this._includedQNames = r10;
        return;
    L6:
        if (r7 == null) goto L11;
        if (r8 != null) goto L11;
        this._inverted = true;
        this._includedURIs = r7;
        this._excludedQNames = r10;
        this._includedQNames = r9;
        return;
    L11:
        throw new IllegalArgumentException("Exactly one of excludedURIs and includedURIs must be null");
    }

    public static QNameSet forArray(QName[] r5) {
        if (r5 == null) goto L6;
        return new QNameSet(null, Collections.emptySet(), Collections.emptySet(), new HashSet(Arrays.asList(r5)));
    L6:
        throw new IllegalArgumentException("includedQNames cannot be null");
    }

    public static QNameSet forSets(Set<String> r3, Set<String> r4, Set<QName> r5, Set<QName> r6) {
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Set r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
        boolean r0 = false;
        if (r7 == null) goto L5;
        boolean r2 = true;
    L6:
        if (r8 == null) goto L8;
        r0 = true;
    L8:
        if (r2 == r0) goto L49;
        if (r7 == null) goto L11;
    L16:
        if (r8 != null) goto L24;
        if (r7.isEmpty() == false) goto L24;
        if (r9.isEmpty() == false) goto L24;
        return ALL;
    L24:
        if (r7 == null) goto L26;
    L35:
        if (r8 != null) goto L47;
        if (r7.size() != 1) goto L47;
        if (r7.contains("") == false) goto L47;
        if (r9.isEmpty() == false) goto L47;
        if (r10.isEmpty() == false) goto L47;
        return NONLOCAL;
    L47:
        return new QNameSet(minSetCopy(r7), minSetCopy(r8), minSetCopy(r9), minSetCopy(r10));
    L26:
        if (r8.size() != 1) goto L35;
        if (r8.contains("") == false) goto L35;
        if (r10.isEmpty() == false) goto L35;
        if (r9.isEmpty() == false) goto L35;
        return LOCAL;
    L11:
        if (r8.isEmpty() == false) goto L16;
        if (r10.isEmpty() == false) goto L16;
        return EMPTY;
    L49:
        throw new IllegalArgumentException("Exactly one of excludedURIs and includedURIs must be null");
    L5:
        r2 = false;
        goto L6
    }

    public static QNameSet forSpecification(QNameSetSpecification r3) {
        QNameSetSpecification r4 = (QNameSetSpecification) ZeusTransformUtils.wrapperContextForParams(r3, QNameSetSpecification.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, QNameSet.class) == false) goto L7;
        return (QNameSet) ZeusTransformUtils.preCheckCast(r4, QNameSet.class, "com.obric.memorydata.plugin");
    L7:
        return forSets(r4.excludedURIs(), r4.includedURIs(), r4.excludedQNamesInIncludedURIs(), r4.includedQNamesInExcludedURIs());
    }

    public static QNameSet forWildcardNamespaceString(String r1, String r2) {
        return forSpecification(new QNameSetBuilder(r1, r2));
    }

    private boolean isDisjointImpl(QNameSetSpecification r3, QNameSetSpecification r4) {
        final QNameSetSpecification r2 = (QNameSetSpecification) ZeusTransformUtils.wrapperContextForParams(r3, QNameSetSpecification.class, "com.obric.memorydata.plugin");
        final QNameSetSpecification r5 = (QNameSetSpecification) ZeusTransformUtils.wrapperContextForParams(r4, QNameSetSpecification.class, "com.obric.memorydata.plugin");
        Set<String> r6 = r2.includedURIs();
        Set<String> r0 = r5.includedURIs();
        if (r0 == null) goto L8;
        if (Collections.disjoint(r6, r0) == true) goto L10;
        return false;
    L10:
        Stream<QName> r7 = r2.includedQNamesInExcludedURIs().stream();
        r5.getClass();
        if (r7.anyMatch(new $$Lambda$f0fKNMpSSQkM_nEwfEkTHqKnYEM(r5)) == false) goto L13;
        return false;
    L13:
        Stream<QName> r8 = r5.includedQNamesInExcludedURIs().stream();
        r2.getClass();
        if (r8.anyMatch(new $$Lambda$f0fKNMpSSQkM_nEwfEkTHqKnYEM(r2)) == false) goto L16;
        return false;
    L16:
        return true;
    L8:
        if (r5.excludedURIs().containsAll(r6) == true) goto L10;
        return false;
    }

    private static <T> Set<T> minSetCopy(Set<T> r2) {
        Set r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        if (r3.isEmpty() == false) goto L11;
        return Collections.emptySet();
    L11:
        if (r3.size() != 1) goto L15;
        return Collections.singleton(r3.iterator().next());
    L15:
        return new HashSet(r3);
    }

    private static String nsFromName(QName r0) {
        String r1 = r0.getNamespaceURI();
        if (r1 != null) goto L6;
        return "";
    L6:
        return r1;
    }

    private String prettyQName(QName r2) {
        if (r2.getNamespaceURI() != null) goto L7;
        return r2.getLocalPart();
    L7:
        return r2.getLocalPart() + "@" + r2.getNamespaceURI();
    }

    public static QNameSet singleton(QName r4) {
        return new QNameSet(null, Collections.emptySet(), Collections.emptySet(), Collections.singleton(r4));
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public boolean contains(QName r3) {
        if (this._includedURIs.contains(nsFromName(r3)) == true) goto L5;
        boolean r4 = this._includedQNames.contains(r3);
    L10:
        return this._inverted ^ r4;
    L5:
        if (this._excludedQNames.contains(r3) == true) goto L7;
        r4 = true;
        goto L10
    L7:
        r4 = false;
        goto L10
    }

    public boolean containsAll(QNameSetSpecification r3) {
        QNameSetSpecification r4 = (QNameSetSpecification) ZeusTransformUtils.wrapperContextForParams(r3, QNameSetSpecification.class, "com.obric.memorydata.plugin");
        if (this._inverted == true) goto L9;
        if (r4.excludedURIs() == null) goto L9;
        return false;
    L9:
        return inverse().isDisjoint(r4);
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public Set<QName> excludedQNamesInIncludedURIs() {
        if (this._inverted == false) goto L5;
        Set<QName> r1 = this._includedQNames;
    L7:
        return Collections.unmodifiableSet(r1);
    L5:
        r1 = this._excludedQNames;
        goto L7
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public Set<String> excludedURIs() {
        if (this._inverted == true) goto L5;
        return null;
    L5:
        return Collections.unmodifiableSet(this._includedURIs);
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public Set<QName> includedQNamesInExcludedURIs() {
        if (this._inverted == false) goto L5;
        Set<QName> r1 = this._excludedQNames;
    L7:
        return Collections.unmodifiableSet(r1);
    L5:
        r1 = this._includedQNames;
        goto L7
    }

    @Override // org.apache.xmlbeans.QNameSetSpecification
    public Set<String> includedURIs() {
        if (this._inverted == false) goto L5;
        return null;
    L5:
        return this._includedURIs;
    }

    public QNameSet intersect(QNameSetSpecification r3) {
        QNameSetSpecification r4 = (QNameSetSpecification) ZeusTransformUtils.wrapperContextForParams(r3, QNameSetSpecification.class, "com.obric.memorydata.plugin");
        QNameSetBuilder r0 = new QNameSetBuilder(this);
        r0.restrict(r4);
        return r0.toQNameSet();
    }

    public QNameSet inverse() {
        QNameSet r0 = EMPTY;
        if (this != r0) goto L7;
        return ALL;
    L7:
        if (this != ALL) goto L9;
        return r0;
    L9:
        QNameSet r1 = LOCAL;
        if (this != r1) goto L14;
        return NONLOCAL;
    L14:
        if (this != NONLOCAL) goto L17;
        return r1;
    L17:
        return new QNameSet(includedURIs(), excludedURIs(), includedQNamesInExcludedURIs(), excludedQNamesInIncludedURIs());
    }

    public boolean isAll() {
        if (this._inverted == true) goto L5;
    L9:
        return false;
    L5:
        if (this._includedURIs.isEmpty() == false) goto L9;
        if (this._includedQNames.isEmpty() == false) goto L9;
        return true;
    }

    public boolean isDisjoint(QNameSetSpecification r3) {
        QNameSetSpecification r4 = (QNameSetSpecification) ZeusTransformUtils.wrapperContextForParams(r3, QNameSetSpecification.class, "com.obric.memorydata.plugin");
        if (this._inverted == false) goto L9;
        if (r4.excludedURIs() == null) goto L9;
        return false;
    L9:
        if (this._inverted == false) goto L13;
        return isDisjointImpl(r4, this);
    L13:
        return isDisjointImpl(this, r4);
    }

    public boolean isEmpty() {
        if (this._inverted == false) goto L5;
    L9:
        return false;
    L5:
        if (this._includedURIs.isEmpty() == false) goto L9;
        if (this._includedQNames.isEmpty() == false) goto L9;
        return true;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("QNameSet");
        if (this._inverted == false) goto L5;
        String r1 = "-(";
    L6:
        r0.append(r1);
        Iterator<String> r2 = this._includedURIs.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        r0.append("+*@");
        r0.append(r3);
        r0.append(", ");
        goto L8
    L10:
        Iterator<QName> r4 = this._excludedQNames.iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        QName r5 = (QName) ZeusTransformUtils.preCheckCast(r4.next(), QName.class, "com.obric.memorydata.plugin");
        r0.append("-");
        r0.append(prettyQName(r5));
        r0.append(", ");
        goto L12
    L14:
        Iterator<QName> r6 = this._includedQNames.iterator();
    L16:
        if (r6.hasNext() == false) goto L18;
        QName r7 = (QName) ZeusTransformUtils.preCheckCast(r6.next(), QName.class, "com.obric.memorydata.plugin");
        r0.append(Marker.ANY_NON_NULL_MARKER);
        r0.append(prettyQName(r7));
        r0.append(", ");
        goto L16
    L18:
        int r8 = r0.lastIndexOf(", ");
        if (r8 <= 0) goto L21;
        r0.setLength(r8);
    L21:
        r0.append(')');
        return r0.toString();
    L5:
        r1 = "+(";
        goto L6
    }

    public QNameSet union(QNameSetSpecification r3) {
        QNameSetSpecification r4 = (QNameSetSpecification) ZeusTransformUtils.wrapperContextForParams(r3, QNameSetSpecification.class, "com.obric.memorydata.plugin");
        QNameSetBuilder r0 = new QNameSetBuilder(this);
        r0.addAll(r4);
        return r0.toQNameSet();
    }
}
