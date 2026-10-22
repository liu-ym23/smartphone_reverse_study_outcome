package androidx.room.jarjarred.org.stringtemplate.v4;

import androidx.room.jarjarred.org.stringtemplate.v4.debug.EvalTemplateEvent;
import androidx.room.jarjarred.org.stringtemplate.v4.debug.InterpEvent;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class InstanceScope {
    public List<EvalTemplateEvent> childEvalTemplateEvents;
    public boolean earlyEval;
    public List<InterpEvent> events;

    /* JADX INFO: renamed from: ip, reason: collision with root package name */
    public int f674ip;
    public final InstanceScope parent;

    /* JADX INFO: renamed from: st, reason: collision with root package name */
    public final ST f675st;

    public InstanceScope(InstanceScope r5, ST r10) {
        this.events = new ArrayList();
        this.childEvalTemplateEvents = new ArrayList();
        this.parent = r5;
        this.f675st = r10;
        if (r5 != null) goto L5;
    L7:
        boolean r11 = false;
    L8:
        this.earlyEval = r11;
        return;
    L5:
        if (r5.earlyEval == false) goto L7;
        r11 = true;
        goto L8
    }
}
