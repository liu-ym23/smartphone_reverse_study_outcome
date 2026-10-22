package org.apache.xmlbeans;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.xml.namespace.QName;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes7.dex */
public class QNameSetBuilder implements Serializable, QNameSetSpecification {
    private static final String[] EMPTY_STRINGARRAY = null;
    private static final long serialVersionUID = 1;
    private Set<QName> _excludedQNames;
    private Set<QName> _includedQNames;
    private Set<String> _includedURIs;
    private boolean _inverted;

    static {
        EMPTY_STRINGARRAY = new String[0];
    }

    public QNameSetBuilder() {
        this._inverted = false;
        this._includedURIs = new HashSet();
        this._excludedQNames = new HashSet();
        this._includedQNames = new HashSet();
    }

    public QNameSetBuilder(String r7, String r8) {
        this();
        if (r7 != null) goto L5;
        r7 = "##any";
    L5:
        String[] r9 = splitList(r7);
        int r1 = 0;
    L7:
        if (r1 >= r9.length) goto L30;
        String r2 = r9[r1];
        if (r2.startsWith("##") == true) goto L11;
    L28:
        addNamespace(r2);
    L29:
        r1 = r1 + 1;
        goto L7
    L11:
        if (r2.equals("##other") == false) goto L17;
        if (r8 == null) goto L15;
        QNameSetBuilder r3 = new QNameSetBuilder();
        r3.addNamespace(r8);
        r3.addNamespace("");
        r3.invert();
        addAll(r3);
        goto L29
    L15:
        throw new IllegalArgumentException();
    L17:
        if (r2.equals("##any") == false) goto L20;
        clear();
        invert();
        goto L29
    L20:
        if (r9[r1].equals("##targetNamespace") == false) goto L26;
        if (r8 == null) goto L24;
        r2 = r8;
        goto L28
    L24:
        throw new IllegalArgumentException();
    L26:
        if (r9[r1].equals("##local") == false) goto L28;
        r2 = "";
        goto L28
    }

    public QNameSetBuilder(Set<String> r3, Set<String> r4, Set<QName> r5, Set<QName> r6) {
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Set r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L7;
        if (r7 != null) goto L7;
        this._inverted = false;
        this._includedURIs = new HashSet(r8);
        this._excludedQNames = new HashSet(r9);
        HashSet r11 = new HashSet(r10);
    L6:
        this._includedQNames = r11;
        return;
    L7:
        if (r7 == null) goto L12;
        if (r8 != null) goto L12;
        this._inverted = true;
        this._includedURIs = new HashSet(r7);
        this._excludedQNames = new HashSet(r10);
        r11 = new HashSet(r9);
    L12:
        throw new IllegalArgumentException("Exactly one of excludedURIs and includedURIs must be null");
    }

    public QNameSetBuilder(QNameSetSpecification r3) {
        QNameSetSpecification r4 = (QNameSetSpecification) ZeusTransformUtils.wrapperContextForParams(r3, QNameSetSpecification.class, "com.obric.memorydata.plugin");
        Set<String> r0 = r4.includedURIs();
        if (r0 == null) goto L5;
        this._inverted = false;
        this._includedURIs = new HashSet(r0);
        this._excludedQNames = new HashSet(r4.excludedQNamesInIncludedURIs());
        HashSet r1 = new HashSet(r4.includedQNamesInExcludedURIs());
    L6:
        this._includedQNames = r1;
        return;
    L5:
        this._inverted = true;
        this._includedURIs = new HashSet(r4.excludedURIs());
        this._excludedQNames = new HashSet(r4.includedQNamesInExcludedURIs());
        r1 = new HashSet(r4.excludedQNamesInIncludedURIs());
        goto L6
    }

    private void addAllImpl(Set<String> r8, Set<String> r9, Set<QName> r10, Set<QName> r11) {
        Set r12 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.memorydata.plugin");
        Set r13 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.memorydata.plugin");
        Set r14 = (Set) ZeusTransformUtils.wrapperContextForParams(r10, Set.class, "com.obric.memorydata.plugin");
        Set r15 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.memorydata.plugin");
        if (r13 == null) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        Set r3 = r13;
    L9:
        Iterator<QName> r4 = this._excludedQNames.iterator();
    L11:
        if (r4.hasNext() == false) goto L17;
        QName r5 = (QName) ZeusTransformUtils.preCheckCast(r4.next(), QName.class, "com.obric.memorydata.plugin");
        if ((r3.contains(nsFromName(r5)) ^ r2) == false) goto L11;
        if (r15.contains(r5) == true) goto L11;
        r4.remove();
        goto L11
    L17:
        Iterator r16 = r15.iterator();
    L19:
        if (r16.hasNext() == false) goto L25;
        QName r6 = (QName) ZeusTransformUtils.preCheckCast(r16.next(), QName.class, "com.obric.memorydata.plugin");
        if (this._includedURIs.contains(nsFromName(r6)) == true) goto L19;
        if (this._includedQNames.contains(r6) == true) goto L19;
        this._excludedQNames.add(r6);
        goto L19
    L25:
        Iterator r17 = r14.iterator();
    L27:
        if (r17.hasNext() == false) goto L32;
        QName r18 = (QName) ZeusTransformUtils.preCheckCast(r17.next(), QName.class, "com.obric.memorydata.plugin");
        if (this._includedURIs.contains(nsFromName(r18)) == false) goto L30;
        this._excludedQNames.remove(r18);
        goto L27
    L30:
        this._includedQNames.add(r18);
        goto L27
    L32:
        if (r2 == true) goto L34;
        removeAllMatchingFirstOnly(r12, this._includedURIs, this._includedQNames);
        this._includedURIs.addAll(r12);
        return;
    L34:
        removeAllMatchingNeither(r13, this._includedURIs, this._includedQNames);
        Iterator<String> r19 = this._includedURIs.iterator();
    L36:
        if (r19.hasNext() == false) goto L40;
        if (r13.contains((String) ZeusTransformUtils.preCheckCast(r19.next(), String.class, "com.obric.memorydata.plugin")) == true) goto L36;
        r19.remove();
        goto L36
    L40:
        Iterator r20 = r13.iterator();
    L42:
        if (r20.hasNext() == false) goto L47;
        String r21 = (String) ZeusTransformUtils.preCheckCast(r20.next(), String.class, "com.obric.memorydata.plugin");
        if (this._includedURIs.contains(r21) == false) goto L45;
        this._includedURIs.remove(r21);
        goto L42
    L45:
        this._includedURIs.add(r21);
        goto L42
    L47:
        Set<QName> r22 = this._excludedQNames;
        this._excludedQNames = this._includedQNames;
        this._includedQNames = r22;
        this._inverted = !this._inverted;
        return;
    L8:
        r3 = r12;
        goto L9
    L5:
        r2 = false;
        goto L6
    }

    private void addImpl(QName r3) {
        if (this._includedURIs.contains(nsFromName(r3)) == false) goto L5;
        this._excludedQNames.remove(r3);
        return;
    L5:
        this._includedQNames.add(r3);
    }

    private void addNamespaceImpl(String r2) {
        if (this._includedURIs.contains(r2) == false) goto L5;
        removeAllMatchingNs(r2, this._excludedQNames);
        return;
    L5:
        removeAllMatchingNs(r2, this._includedQNames);
        this._includedURIs.add(r2);
    }

    private boolean isDisjointImpl(QNameSetSpecification r6, QNameSetSpecification r7) {
        QNameSetSpecification r5 = (QNameSetSpecification) ZeusTransformUtils.wrapperContextForParams(r6, QNameSetSpecification.class, "com.obric.memorydata.plugin");
        QNameSetSpecification r8 = (QNameSetSpecification) ZeusTransformUtils.wrapperContextForParams(r7, QNameSetSpecification.class, "com.obric.memorydata.plugin");
        Set<String> r9 = r5.includedURIs();
        Set<String> r1 = r8.includedURIs();
        if (r1 == null) goto L10;
        Iterator<String> r3 = r9.iterator();
    L6:
        if (r3.hasNext() == false) goto L16;
        if (r1.contains(r3.next()) == false) goto L6;
        return false;
    L16:
        Iterator<QName> r2 = r5.includedQNamesInExcludedURIs().iterator();
    L18:
        if (r2.hasNext() == false) goto L23;
        if (r8.contains((QName) ZeusTransformUtils.preCheckCast(r2.next(), QName.class, "com.obric.memorydata.plugin")) == false) goto L18;
        return false;
    L23:
        if (r9.size() <= 0) goto L30;
        Iterator<QName> r10 = r8.includedQNamesInExcludedURIs().iterator();
    L26:
        if (r10.hasNext() == false) goto L44;
        if (r5.contains((QName) ZeusTransformUtils.preCheckCast(r10.next(), QName.class, "com.obric.memorydata.plugin")) == false) goto L26;
        return false;
    L44:
        return true;
    L30:
        return true;
    L10:
        Set<String> r4 = r8.excludedURIs();
        Iterator<String> r11 = r9.iterator();
    L12:
        if (r11.hasNext() == false) goto L16;
        if (r4.contains(r11.next()) == true) goto L12;
        return false;
    }

    private static boolean isSpace(char r1) {
        if (r1 != '\t') goto L5;
        return true;
    L5:
        if (r1 != '\n') goto L7;
        return true;
    L7:
        if (r1 != '\r') goto L9;
        return true;
    L9:
        if (r1 == ' ') goto L16;
        return false;
    L16:
        return true;
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

    private void removeAllImpl(Set<String> r7, Set<String> r8, Set<QName> r9, Set<QName> r10) {
        Set r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.memorydata.plugin");
        Set r12 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.memorydata.plugin");
        Set r13 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.memorydata.plugin");
        Set r14 = (Set) ZeusTransformUtils.wrapperContextForParams(r10, Set.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        Set r2 = r12;
    L9:
        Iterator<QName> r3 = this._includedQNames.iterator();
    L11:
        if (r3.hasNext() == false) goto L20;
        QName r4 = (QName) ZeusTransformUtils.preCheckCast(r3.next(), QName.class, "com.obric.memorydata.plugin");
        if ((r2.contains(nsFromName(r4)) ^ r0) == true) goto L15;
        if (r13.contains(r4) == false) goto L11;
    L19:
        r3.remove();
        goto L11
    L15:
        if (r14.contains(r4) == true) goto L11;
    L20:
        Iterator r15 = r13.iterator();
    L22:
        if (r15.hasNext() == false) goto L26;
        QName r5 = (QName) ZeusTransformUtils.preCheckCast(r15.next(), QName.class, "com.obric.memorydata.plugin");
        String r6 = nsFromName(r5);
        if (this._includedURIs.contains(r6) == false) goto L22;
        this._excludedQNames.add(r5);
        goto L22
    L26:
        Iterator r16 = r14.iterator();
    L28:
        if (r16.hasNext() == false) goto L34;
        QName r17 = (QName) ZeusTransformUtils.preCheckCast(r16.next(), QName.class, "com.obric.memorydata.plugin");
        String r18 = nsFromName(r17);
        if (this._includedURIs.contains(r18) == false) goto L28;
        if (this._excludedQNames.contains(r17) == true) goto L28;
        this._includedQNames.add(r17);
        goto L28
    L34:
        if (r0 == false) goto L36;
        removeAllMatchingFirstOnly(this._includedURIs, r12, this._excludedQNames);
    L37:
        Iterator<String> r19 = this._includedURIs.iterator();
    L39:
        if (r19.hasNext() == false) goto L43;
        if ((r2.contains(r19.next()) ^ r0) == false) goto L39;
        r19.remove();
        goto L39
    L43:
        return;
    L36:
        removeAllMatchingBoth(this._includedURIs, r11, this._excludedQNames);
        goto L37
    L8:
        r2 = r11;
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    private static void removeAllMatchingBoth(Set<String> r3, Set<String> r4, Set<QName> r5) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Iterator r8 = ((Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L10;
        String r0 = nsFromName((QName) ZeusTransformUtils.preCheckCast(r8.next(), QName.class, "com.obric.memorydata.plugin"));
        if (r6.contains(r0) == false) goto L4;
        if (r7.contains(r0) == false) goto L4;
        r8.remove();
        goto L4
    }

    private static void removeAllMatchingFirstOnly(Set<String> r3, Set<String> r4, Set<QName> r5) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Iterator r8 = ((Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L10;
        String r0 = nsFromName((QName) ZeusTransformUtils.preCheckCast(r8.next(), QName.class, "com.obric.memorydata.plugin"));
        if (r6.contains(r0) == false) goto L4;
        if (r7.contains(r0) == true) goto L4;
        r8.remove();
        goto L4
    }

    private static void removeAllMatchingNeither(Set<String> r3, Set<String> r4, Set<QName> r5) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Iterator r8 = ((Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L10;
        String r0 = nsFromName((QName) ZeusTransformUtils.preCheckCast(r8.next(), QName.class, "com.obric.memorydata.plugin"));
        if (r6.contains(r0) == true) goto L4;
        if (r7.contains(r0) == true) goto L4;
        r8.remove();
        goto L4
    }

    private static void removeAllMatchingNs(String r3, Set<QName> r4) {
        Iterator r5 = ((Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        if (r3.equals(nsFromName((QName) ZeusTransformUtils.preCheckCast(r5.next(), QName.class, "com.obric.memorydata.plugin"))) == false) goto L4;
        r5.remove();
        goto L4
    }

    private void removeImpl(QName r3) {
        if (this._includedURIs.contains(nsFromName(r3)) == false) goto L5;
        this._excludedQNames.add(r3);
        return;
    L5:
        this._includedQNames.remove(r3);
    }

    private void removeNamespaceImpl(String r2) {
        if (this._includedURIs.contains(r2) == false) goto L5;
        removeAllMatchingNs(r2, this._excludedQNames);
        this._includedURIs.remove(r2);
        return;
    L5:
        removeAllMatchingNs(r2, this._includedQNames);
    }

    private static String[] splitList(String r4) {
        if (r4.length() == 0) goto L5;
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L8:
        if (r1 >= r4.length()) goto L13;
        if (isSpace(r4.charAt(r1)) == false) goto L13;
        r1 = r1 + 1;
    L13:
        if (r1 >= r4.length()) goto L15;
        int r2 = r1;
    L18:
        if (r2 >= r4.length()) goto L22;
        if (isSpace(r4.charAt(r2)) == true) goto L22;
        r2 = r2 + 1;
    L22:
        r0.add(r4.substring(r1, r2));
        r1 = r2;
        goto L8
    L15:
        return (String[]) ZeusTransformUtils.preCheckCast(r0.toArray(EMPTY_STRINGARRAY), String[].class, "com.obric.memorydata.plugin");
    L5:
        return EMPTY_STRINGARRAY;
    }

    public void add(QName r2) {
        if (this._inverted == true) goto L5;
        addImpl(r2);
        return;
    L5:
        removeImpl(r2);
    }

    public void addAll(QNameSetSpecification r4) {
        QNameSetSpecification r5 = (QNameSetSpecification) ZeusTransformUtils.wrapperContextForParams(r4, QNameSetSpecification.class, "com.obric.memorydata.plugin");
        if (this._inverted == false) goto L5;
        removeAllImpl(r5.includedURIs(), r5.excludedURIs(), r5.includedQNamesInExcludedURIs(), r5.excludedQNamesInIncludedURIs());
        return;
    L5:
        addAllImpl(r5.includedURIs(), r5.excludedURIs(), r5.includedQNamesInExcludedURIs(), r5.excludedQNamesInIncludedURIs());
    }

    public void addNamespace(String r2) {
        if (this._inverted == true) goto L5;
        addNamespaceImpl(r2);
        return;
    L5:
        removeNamespaceImpl(r2);
    }

    public void clear() {
        this._inverted = false;
        this._includedURIs.clear();
        this._excludedQNames.clear();
        this._includedQNames.clear();
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
        return QNameSet.forSets(includedURIs(), excludedURIs(), includedQNamesInExcludedURIs(), excludedQNamesInIncludedURIs());
    }

    public void invert() {
        this._inverted = !this._inverted;
    }

    public boolean isAll() {
        if (this._inverted == true) goto L5;
    L9:
        return false;
    L5:
        if (this._includedURIs.size() != 0) goto L9;
        if (this._includedQNames.size() != 0) goto L9;
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
        if (this._includedURIs.size() != 0) goto L9;
        if (this._includedQNames.size() != 0) goto L9;
        return true;
    }

    public void remove(QName r2) {
        if (this._inverted == false) goto L5;
        addImpl(r2);
        return;
    L5:
        removeImpl(r2);
    }

    public void removeAll(QNameSetSpecification r4) {
        QNameSetSpecification r5 = (QNameSetSpecification) ZeusTransformUtils.wrapperContextForParams(r4, QNameSetSpecification.class, "com.obric.memorydata.plugin");
        if (this._inverted == false) goto L5;
        addAllImpl(r5.includedURIs(), r5.excludedURIs(), r5.includedQNamesInExcludedURIs(), r5.excludedQNamesInIncludedURIs());
        return;
    L5:
        removeAllImpl(r5.includedURIs(), r5.excludedURIs(), r5.includedQNamesInExcludedURIs(), r5.excludedQNamesInIncludedURIs());
    }

    public void removeNamespace(String r2) {
        if (this._inverted == false) goto L5;
        addNamespaceImpl(r2);
        return;
    L5:
        removeNamespaceImpl(r2);
    }

    public void restrict(QNameSetSpecification r4) {
        QNameSetSpecification r5 = (QNameSetSpecification) ZeusTransformUtils.wrapperContextForParams(r4, QNameSetSpecification.class, "com.obric.memorydata.plugin");
        if (this._inverted == false) goto L5;
        addAllImpl(r5.excludedURIs(), r5.includedURIs(), r5.excludedQNamesInIncludedURIs(), r5.includedQNamesInExcludedURIs());
        return;
    L5:
        removeAllImpl(r5.excludedURIs(), r5.includedURIs(), r5.excludedQNamesInIncludedURIs(), r5.includedQNamesInExcludedURIs());
    }

    public QNameSet toQNameSet() {
        return QNameSet.forSpecification(this);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("QNameSetBuilder");
        if (this._inverted == false) goto L5;
        String r1 = "-(";
    L6:
        r0.append(r1);
        Iterator<String> r2 = this._includedURIs.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r0.append("+*@");
        r0.append((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin"));
        r0.append(", ");
        goto L8
    L10:
        Iterator<QName> r3 = this._excludedQNames.iterator();
    L12:
        if (r3.hasNext() == false) goto L14;
        r0.append("-");
        r0.append(prettyQName((QName) ZeusTransformUtils.preCheckCast(r3.next(), QName.class, "com.obric.memorydata.plugin")));
        r0.append(", ");
        goto L12
    L14:
        Iterator<QName> r4 = this._includedQNames.iterator();
    L16:
        if (r4.hasNext() == false) goto L18;
        r0.append(Marker.ANY_NON_NULL_MARKER);
        r0.append(prettyQName((QName) ZeusTransformUtils.preCheckCast(r4.next(), QName.class, "com.obric.memorydata.plugin")));
        r0.append(", ");
        goto L16
    L18:
        int r6 = r0.lastIndexOf(", ");
        if (r6 <= 0) goto L21;
        r0.setLength(r6);
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
