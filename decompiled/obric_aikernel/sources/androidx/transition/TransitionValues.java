package androidx.transition;

import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TransitionValues {
    final ArrayList<Transition> mTargetedTransitions;
    public final Map<String, Object> values;
    public View view;

    @Deprecated
    public TransitionValues() {
        this.values = new HashMap();
        this.mTargetedTransitions = new ArrayList();
    }

    public TransitionValues(@NonNull View r10) {
        this.values = new HashMap();
        this.mTargetedTransitions = new ArrayList();
        this.view = r10;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof TransitionValues) == false) goto L10;
        TransitionValues r11 = (TransitionValues) r10;
        if (this.view == r11.view) goto L7;
        return false;
    L7:
        if (this.values.equals(r11.values) == false) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public int hashCode() {
        return (this.view.hashCode() * 31) + this.values.hashCode();
    }

    public String toString() {
        String r10 = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.view + "\n") + "    values:";
        Iterator<String> r11 = this.values.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        String r12 = r11.next();
        r10 = r10 + "    " + r12 + ": " + this.values.get(r12) + "\n";
        goto L4
    L6:
        return r10;
    }
}
