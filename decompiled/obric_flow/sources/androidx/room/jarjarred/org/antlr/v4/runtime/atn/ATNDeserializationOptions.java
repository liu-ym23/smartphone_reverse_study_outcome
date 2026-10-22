package androidx.room.jarjarred.org.antlr.v4.runtime.atn;

/* JADX INFO: loaded from: classes.dex */
public class ATNDeserializationOptions {
    private static final ATNDeserializationOptions defaultOptions = null;
    private boolean generateRuleBypassTransitions;
    private boolean readOnly;
    private boolean verifyATN;

    static {
        ATNDeserializationOptions r5 = new ATNDeserializationOptions();
        defaultOptions = r5;
        r5.makeReadOnly();
    }

    public ATNDeserializationOptions() {
        this.verifyATN = true;
        this.generateRuleBypassTransitions = false;
    }

    public static ATNDeserializationOptions getDefaultOptions() {
        return defaultOptions;
    }

    public final boolean isGenerateRuleBypassTransitions() {
        return this.generateRuleBypassTransitions;
    }

    public final boolean isReadOnly() {
        return this.readOnly;
    }

    public final boolean isVerifyATN() {
        return this.verifyATN;
    }

    public final void makeReadOnly() {
        this.readOnly = true;
    }

    public final void setGenerateRuleBypassTransitions(boolean r5) {
        throwIfReadOnly();
        this.generateRuleBypassTransitions = r5;
    }

    public final void setVerifyATN(boolean r5) {
        throwIfReadOnly();
        this.verifyATN = r5;
    }

    public void throwIfReadOnly() {
        if (isReadOnly() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("The object is read only.");
    }

    public ATNDeserializationOptions(ATNDeserializationOptions r5) {
        this.verifyATN = r5.verifyATN;
        this.generateRuleBypassTransitions = r5.generateRuleBypassTransitions;
    }
}
