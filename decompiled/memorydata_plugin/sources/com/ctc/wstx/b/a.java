package com.ctc.wstx.b;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static String A = "Missing processing instruction target";
    public static String B = "Illegal processing instruction target (\"{0}\"); 'xml' (case insensitive) is reserved by the specs.";
    public static String C = "expected either space or \"?>\" after PI target";
    public static String D = "Entity \"{0}\" declared externally, but referenced from a document declared 'standalone=\"yes\"'";
    public static String E = "Undeclared general entity \"{0}\"";
    public static String F = "Undeclared general entity \"{0}\" (document in stand-alone mode; perhaps declared externally?)";
    public static String G = "Undeclared namespace prefix \"{0}\"";
    public static String H = "Undeclared namespace prefix \"{0}\" (for attribute \"{1}\")";
    public static String I = "Trying to redeclare prefix \"xml\" from its default URI \"http://www.w3.org/XML/1998/namespace\" to \"{0}\"";

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static String f3450J = "Trying to declare prefix \"xmlns\" (illegal as per NS 1.1 #4)";
    public static String K = "Trying to bind URI \"http://www.w3.org/XML/1998/namespace\" to prefix \"{0}\" (can only bind to \"xml\")";
    public static String L = "Trying to bind URI \"http://www.w3.org/2000/xmlns/\" to prefix \"{0}\" (can not be explicitly bound)";
    public static String M = "Non-default namespace can not map to empty URI (as per Namespace 1.0 # 2) in XML 1.0 documents";
    public static String N = "; expected a keyword (ATTLIST, ELEMENT, ENTITY, NOTATION), comment, or conditional section";
    public static String O = "; expected one of type (CDATA, ID, IDREF, IDREFS, ENTITY, ENTITIES NOTATION, NMTOKEN or NMTOKENS)";
    public static String P = "; expected #REQUIRED, #IMPLIED or #FIXED";
    public static String Q = "Trying to redefine element \"{0}\" (originally defined at {1})";
    public static String R = "Trying to redefine notation \"{0}\" (originally defined at {1})";
    public static String S = "Undeclared {0} entity \"{1}\"";
    public static String T = "Attribute xml:space has to be defined of type enumerated, and have 1 or 2 values, 'default' and/or 'preserve'";
    public static String U = "Attribute xml:id has to have attribute type of ID, as per Xml:id specification";
    public static String V = "Undefined element <{0}> encountered";
    public static String W = "Element <{0}> has EMPTY content specification; can not contain {1}";
    public static String X = "Element <{0}> has non-mixed content specification; can not contain non-white space text, or any CDATA sections";
    public static String Y = "Element <{0}> has ANY content specification; can not contain {1}";
    public static String Z = "Element <{0}> has no attribute \"{1}\"";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f3451a = "entity declaration";
    public static String aa = "Unexpected root element <{0}>; expected <{0}> as per DOCTYPE declaration";
    public static String ab = "Trying to output a CDATA block outside main element tree (in prolog or epilog)";
    public static String ac = "Trying to output non-whitespace characters outside main element tree (in prolog or epilog)";
    public static String ad = "Trying to output second root, <{0}>";
    public static String ae = "Illegal input: CDATA block has embedded ']]>' in it (index {0})";
    public static String af = "Illegal input: comment content has embedded '--' in it (index {0})";
    public static String ag = "Trying to write an attribute when there is no open start element.";
    public static String ah = "Illegal to pass empty name";
    public static String ai = "Illegal first name character {0} in name \"{1}\"";
    public static String aj = "Illegal name character {0} in name \"{1}\" (index #{2})";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f3452b = "element declaration";
    public static String c = "attribute declaration";
    public static String d = "xml declaration";
    public static String e = "doctype declaration";
    public static String f = "namespace declaration";
    public static String g = "schema validation";
    public static String h = "Undefined element \"{0}\"; referred to by attribute(s)";
    public static String i = "Inconsistent text encoding; declared as \"{0}\" in xml declaration, application had passed \"{1}\"";
    public static String j = "Missing DOCTYPE declaration in validating mode; can not validate elements or attributes";
    public static String k = "Attribute \"{0}\" (for element <{1}>) declared multiple times";
    public static String l = "Attribute \"{0}\" already declared for element <{1}>; ignoring re-declaration";
    public static String m = "Internal error";
    public static String n = "Illegal to pass null as argument";
    public static String o = "Unrecognized feature \"{0}\"";
    public static String p = "Current event not START_ELEMENT";
    public static String q = "Current event not START_ELEMENT or END_ELEMENT";
    public static String r = "Current event not PROCESSING_INSTRUCTION";
    public static String s = "Current event ({0}) not START_ELEMENT, END_ELEMENT, CHARACTERS or CDATA";
    public static String t = "XML 1.0 document can not refer to XML 1.1 parsed external entities";
    public static String u = "Can not have DOCTYPE declaration in epilog";
    public static String v = "Duplicate DOCTYPE declaration";
    public static String w = " (CDATA not allowed in prolog/epilog)";
    public static String x = "String '--' not allowed in comment (missing '>'?)";
    public static String y = "String ']]>' not allowed in textual content, except as the end marker of CDATA section";
    public static String z = "Unexpected keyword \"{0}\"; expected \"{1}\"";

    static {
    }

    public static String a(int r2) {
        switch(r2) {
            case 1: goto L25;
            case 2: goto L23;
            case 3: goto L21;
            case 4: goto L19;
            case 5: goto L17;
            case 6: goto L15;
            case 7: goto L13;
            case 8: goto L11;
            case 9: goto L9;
            case 10: goto L4;
            case 11: goto L7;
            case 12: goto L5;
            default: goto L4;
        };
    L5:
        return "CDATA";
    L7:
        return "DTD";
    L9:
        return "ENTITY_REFERENCE";
    L11:
        return "END_DOCUMENT";
    L13:
        return "START_DOCUMENT";
    L15:
        return "SPACE";
    L17:
        return "COMMENT";
    L19:
        return "CHARACTERS";
    L21:
        return "PROCESSING_INSTRUCTION";
    L23:
        return "END_ELEMENT";
    L25:
        return "START_ELEMENT";
    L4:
        return "[" + r2 + "]";
    }
}
