package androidx.room.jarjarred.org.stringtemplate.v4.debug;

import ai.j0;
import androidx.room.jarjarred.org.stringtemplate.v4.InstanceScope;

/* JADX INFO: loaded from: classes.dex */
public class InterpEvent {
    public final int outputStartChar;
    public final int outputStopChar;
    public InstanceScope scope;

    public InterpEvent(InstanceScope r5, int r10, int r11) {
        this.scope = r5;
        this.outputStartChar = r10;
        this.outputStopChar = r11;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(getClass().getSimpleName());
        r5.append("{self=");
        r5.append(this.scope.f675st);
        r5.append(", start=");
        r5.append(this.outputStartChar);
        r5.append(", stop=");
        return j0.n(r5, this.outputStopChar, '}');
    }
}
