package androidx.room.jarjarred.org.stringtemplate.v4.misc;

import ai.j0;
import androidx.room.jarjarred.org.stringtemplate.v4.compiler.STException;

/* JADX INFO: loaded from: classes.dex */
public class STNoSuchPropertyException extends STException {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Object f685o;
    public String propertyName;

    public STNoSuchPropertyException(Exception r5, Object r10, String r11) {
        super(null, r5);
        this.f685o = r10;
        this.propertyName = r11;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        if (this.f685o == null) goto L7;
        StringBuilder r5 = new StringBuilder("object ");
        r5.append(this.f685o.getClass());
        r5.append(" has no ");
        return j0.q(r5, this.propertyName, " property");
    L7:
        return "no such property: " + this.propertyName;
    }
}
