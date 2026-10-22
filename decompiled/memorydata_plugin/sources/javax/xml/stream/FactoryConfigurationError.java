package javax.xml.stream;

/* JADX INFO: loaded from: classes6.dex */
public class FactoryConfigurationError extends Error {
    Exception nested;

    public FactoryConfigurationError() {
    }

    public FactoryConfigurationError(Exception r1) {
        this.nested = r1;
    }

    public FactoryConfigurationError(Exception r1, String r2) {
        super(r2);
        this.nested = r1;
    }

    public FactoryConfigurationError(String r1) {
        super(r1);
    }

    public FactoryConfigurationError(String r1, Exception r2) {
        super(r1);
        this.nested = r2;
    }

    public Exception getException() {
        return this.nested;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String r0 = super.getMessage();
        if (r0 == null) goto L5;
        return r0;
    L5:
        Exception r1 = this.nested;
        if (r1 == null) goto L11;
        String r2 = r1.getMessage();
        if (r2 == null) goto L10;
        return r2;
    L10:
        return this.nested.getClass().toString();
    L11:
        return r0;
    }
}
