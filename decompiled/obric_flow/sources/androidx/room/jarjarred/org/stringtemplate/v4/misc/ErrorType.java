package androidx.room.jarjarred.org.stringtemplate.v4.misc;

/* JADX INFO: loaded from: classes.dex */
public final enum ErrorType extends Enum<ErrorType> {
    private static final /* synthetic */ ErrorType[] $VALUES = null;
    public static final ErrorType ALIAS_TARGET_UNDEFINED = null;
    public static final ErrorType ANON_ARGUMENT_MISMATCH = null;
    public static final ErrorType ARGUMENT_COUNT_MISMATCH = null;
    public static final ErrorType CANT_IMPORT = null;
    public static final ErrorType CANT_LOAD_GROUP_FILE = null;
    public static final ErrorType EMBEDDED_REGION_REDEFINITION = null;
    public static final ErrorType EXPECTING_STRING = null;
    public static final ErrorType INTERNAL_ERROR = null;
    public static final ErrorType INVALID_TEMPLATE_NAME = null;
    public static final ErrorType LEXER_ERROR = null;
    public static final ErrorType MAP_ARGUMENT_COUNT_MISMATCH = null;
    public static final ErrorType MAP_REDEFINITION = null;
    public static final ErrorType MISSING_FORMAL_ARGUMENTS = null;
    public static final ErrorType NO_DEFAULT_VALUE = null;
    public static final ErrorType NO_IMPORTED_TEMPLATE = null;
    public static final ErrorType NO_SUCH_ATTRIBUTE = null;
    public static final ErrorType NO_SUCH_ATTRIBUTE_PASS_THROUGH = null;
    public static final ErrorType NO_SUCH_FUNCTION = null;
    public static final ErrorType NO_SUCH_OPTION = null;
    public static final ErrorType NO_SUCH_PROPERTY = null;
    public static final ErrorType NO_SUCH_REGION = null;
    public static final ErrorType NO_SUCH_TEMPLATE = null;
    public static final ErrorType REF_TO_IMPLICIT_ATTRIBUTE_OUT_OF_SCOPE = null;
    public static final ErrorType REGION_REDEFINITION = null;
    public static final ErrorType REQUIRED_PARAMETER_AFTER_OPTIONAL = null;
    public static final ErrorType SYNTAX_ERROR = null;
    public static final ErrorType TEMPLATE_REDEFINITION = null;
    public static final ErrorType TEMPLATE_REDEFINITION_AS_MAP = null;
    public static final ErrorType WRITER_CTOR_ISSUE = null;
    public static final ErrorType WRITE_IO_ERROR = null;
    public String message;

    static {
        ErrorType r5 = new ErrorType("NO_SUCH_TEMPLATE", 0, "no such template: %s");
        NO_SUCH_TEMPLATE = r5;
        ErrorType r10 = new ErrorType("NO_IMPORTED_TEMPLATE", 1, "no such template: super.%s");
        NO_IMPORTED_TEMPLATE = r10;
        ErrorType r11 = new ErrorType("NO_SUCH_ATTRIBUTE", 2, "attribute %s isn't defined");
        NO_SUCH_ATTRIBUTE = r11;
        ErrorType r12 = new ErrorType("NO_SUCH_ATTRIBUTE_PASS_THROUGH", 3, "could not pass through undefined attribute %s");
        NO_SUCH_ATTRIBUTE_PASS_THROUGH = r12;
        ErrorType r13 = new ErrorType("REF_TO_IMPLICIT_ATTRIBUTE_OUT_OF_SCOPE", 4, "implicitly-defined attribute %s not visible");
        REF_TO_IMPLICIT_ATTRIBUTE_OUT_OF_SCOPE = r13;
        ErrorType r14 = new ErrorType("MISSING_FORMAL_ARGUMENTS", 5, "missing argument definitions");
        MISSING_FORMAL_ARGUMENTS = r14;
        ErrorType r15 = new ErrorType("NO_SUCH_PROPERTY", 6, "no such property or can't access: %s");
        NO_SUCH_PROPERTY = r15;
        ErrorType r16 = new ErrorType("MAP_ARGUMENT_COUNT_MISMATCH", 7, "iterating through %s values in zip map but template has %s declared arguments");
        MAP_ARGUMENT_COUNT_MISMATCH = r16;
        ErrorType r17 = new ErrorType("ARGUMENT_COUNT_MISMATCH", 8, "passed %s arg(s) to template %s with %s declared arg(s)");
        ARGUMENT_COUNT_MISMATCH = r17;
        ErrorType r18 = new ErrorType("EXPECTING_STRING", 9, "function %s expects a string not %s");
        EXPECTING_STRING = r18;
        ErrorType r19 = new ErrorType("WRITER_CTOR_ISSUE", 10, "%s(Writer) constructor doesn't exist");
        WRITER_CTOR_ISSUE = r19;
        ErrorType r110 = new ErrorType("CANT_IMPORT", 11, "can't find template(s) in import \"%s\"");
        CANT_IMPORT = r110;
        ErrorType r111 = new ErrorType("SYNTAX_ERROR", 12, "%s");
        SYNTAX_ERROR = r111;
        ErrorType r112 = new ErrorType("TEMPLATE_REDEFINITION", 13, "redefinition of template %s");
        TEMPLATE_REDEFINITION = r112;
        ErrorType r20 = new ErrorType("EMBEDDED_REGION_REDEFINITION", 14, "region %s is embedded and thus already implicitly defined");
        EMBEDDED_REGION_REDEFINITION = r20;
        ErrorType r21 = new ErrorType("REGION_REDEFINITION", 15, "redefinition of region %s");
        REGION_REDEFINITION = r21;
        ErrorType r22 = new ErrorType("MAP_REDEFINITION", 16, "redefinition of dictionary %s");
        MAP_REDEFINITION = r22;
        ErrorType r23 = new ErrorType("ALIAS_TARGET_UNDEFINED", 17, "cannot alias %s to undefined template: %s");
        ALIAS_TARGET_UNDEFINED = r23;
        ErrorType r24 = new ErrorType("TEMPLATE_REDEFINITION_AS_MAP", 18, "redefinition of template %s as a map");
        TEMPLATE_REDEFINITION_AS_MAP = r24;
        ErrorType r25 = new ErrorType("LEXER_ERROR", 19, "%s");
        LEXER_ERROR = r25;
        ErrorType r26 = new ErrorType("NO_DEFAULT_VALUE", 20, "missing dictionary default value");
        NO_DEFAULT_VALUE = r26;
        ErrorType r27 = new ErrorType("NO_SUCH_FUNCTION", 21, "no such function: %s");
        NO_SUCH_FUNCTION = r27;
        ErrorType r28 = new ErrorType("NO_SUCH_REGION", 22, "template %s doesn't have a region called %s");
        NO_SUCH_REGION = r28;
        ErrorType r29 = new ErrorType("NO_SUCH_OPTION", 23, "no such option: %s");
        NO_SUCH_OPTION = r29;
        ErrorType r30 = new ErrorType("INVALID_TEMPLATE_NAME", 24, "invalid template name or path: %s");
        INVALID_TEMPLATE_NAME = r30;
        ErrorType r31 = new ErrorType("ANON_ARGUMENT_MISMATCH", 25, "anonymous template has %s arg(s) but mapped across %s value(s)");
        ANON_ARGUMENT_MISMATCH = r31;
        ErrorType r32 = new ErrorType("REQUIRED_PARAMETER_AFTER_OPTIONAL", 26, "required parameters (%s) must appear before optional parameters");
        REQUIRED_PARAMETER_AFTER_OPTIONAL = r32;
        ErrorType r33 = new ErrorType("INTERNAL_ERROR", 27, "%s");
        INTERNAL_ERROR = r33;
        ErrorType r34 = new ErrorType("WRITE_IO_ERROR", 28, "error writing output caused by");
        WRITE_IO_ERROR = r34;
        ErrorType r35 = new ErrorType("CANT_LOAD_GROUP_FILE", 29, "can't load group file %s");
        CANT_LOAD_GROUP_FILE = r35;
        $VALUES = new ErrorType[]{r5, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35};
    }

    private ErrorType(String r5, int r10, String r11) {
        super(r5, r10);
        this.message = r11;
    }

    public static ErrorType valueOf(String r5) {
        return (ErrorType) Enum.valueOf(ErrorType.class, r5);
    }

    public static ErrorType[] values() {
        return (ErrorType[]) $VALUES.clone();
    }
}
