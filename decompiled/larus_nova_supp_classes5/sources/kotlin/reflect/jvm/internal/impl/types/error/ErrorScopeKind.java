package kotlin.reflect.jvm.internal.impl.types.error;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final enum ErrorScopeKind extends Enum<ErrorScopeKind> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ErrorScopeKind[] $VALUES = null;
    public static final ErrorScopeKind CAPTURED_TYPE_SCOPE = null;
    public static final ErrorScopeKind ERASED_RECEIVER_TYPE_SCOPE = null;
    public static final ErrorScopeKind ERROR_TYPE_SCOPE = null;
    public static final ErrorScopeKind INTEGER_LITERAL_TYPE_SCOPE = null;
    public static final ErrorScopeKind NON_CLASSIFIER_SUPER_TYPE_SCOPE = null;
    public static final ErrorScopeKind SCOPE_FOR_ABBREVIATION_TYPE = null;
    public static final ErrorScopeKind SCOPE_FOR_ERROR_CLASS = null;
    public static final ErrorScopeKind SCOPE_FOR_ERROR_RESOLUTION_CANDIDATE = null;
    public static final ErrorScopeKind STUB_TYPE_SCOPE = null;
    public static final ErrorScopeKind UNSUPPORTED_TYPE_SCOPE = null;
    private final String debugMessage;

    private static final /* synthetic */ ErrorScopeKind[] $values() {
        return new ErrorScopeKind[]{CAPTURED_TYPE_SCOPE, INTEGER_LITERAL_TYPE_SCOPE, ERASED_RECEIVER_TYPE_SCOPE, SCOPE_FOR_ABBREVIATION_TYPE, STUB_TYPE_SCOPE, NON_CLASSIFIER_SUPER_TYPE_SCOPE, ERROR_TYPE_SCOPE, UNSUPPORTED_TYPE_SCOPE, SCOPE_FOR_ERROR_CLASS, SCOPE_FOR_ERROR_RESOLUTION_CANDIDATE};
    }

    static {
        CAPTURED_TYPE_SCOPE = new ErrorScopeKind("CAPTURED_TYPE_SCOPE", 0, "No member resolution should be done on captured type, it used only during constraint system resolution");
        INTEGER_LITERAL_TYPE_SCOPE = new ErrorScopeKind("INTEGER_LITERAL_TYPE_SCOPE", 1, "Scope for integer literal type (%s)");
        ERASED_RECEIVER_TYPE_SCOPE = new ErrorScopeKind("ERASED_RECEIVER_TYPE_SCOPE", 2, "Error scope for erased receiver type");
        SCOPE_FOR_ABBREVIATION_TYPE = new ErrorScopeKind("SCOPE_FOR_ABBREVIATION_TYPE", 3, "Scope for abbreviation %s");
        STUB_TYPE_SCOPE = new ErrorScopeKind("STUB_TYPE_SCOPE", 4, "Scope for stub type %s");
        NON_CLASSIFIER_SUPER_TYPE_SCOPE = new ErrorScopeKind("NON_CLASSIFIER_SUPER_TYPE_SCOPE", 5, "A scope for common supertype which is not a normal classifier");
        ERROR_TYPE_SCOPE = new ErrorScopeKind("ERROR_TYPE_SCOPE", 6, "Scope for error type %s");
        UNSUPPORTED_TYPE_SCOPE = new ErrorScopeKind("UNSUPPORTED_TYPE_SCOPE", 7, "Scope for unsupported type %s");
        SCOPE_FOR_ERROR_CLASS = new ErrorScopeKind("SCOPE_FOR_ERROR_CLASS", 8, "Error scope for class %s with arguments: %s");
        SCOPE_FOR_ERROR_RESOLUTION_CANDIDATE = new ErrorScopeKind("SCOPE_FOR_ERROR_RESOLUTION_CANDIDATE", 9, "Error resolution candidate for call %s");
        ErrorScopeKind[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static ErrorScopeKind[] values() {
        return (ErrorScopeKind[]) $VALUES.clone();
    }

    public final String getDebugMessage() {
        return this.debugMessage;
    }

    public static ErrorScopeKind valueOf(String r1) {
        return (ErrorScopeKind) a.a(ErrorScopeKind.class, r1);
    }

    private ErrorScopeKind(String r1, int r2, String r3) {
        super(r1, r2);
        this.debugMessage = r3;
    }
}
