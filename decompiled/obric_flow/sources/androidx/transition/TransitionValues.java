package androidx.transition;

import ai.j0;
import android.annotation.SuppressLint;
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

    @SuppressLint({"UnknownNullness"})
    public View view;

    @Deprecated
    public TransitionValues() {
        this.values = new HashMap();
        this.mTargetedTransitions = new ArrayList();
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof TransitionValues) == false) goto L10;
        TransitionValues r10 = (TransitionValues) r5;
        if (this.view == r10.view) goto L7;
        return false;
    L7:
        if (this.values.equals(r10.values) == false) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public int hashCode() {
        int r5 = this.view.hashCode() * 31;
        return this.values.hashCode() + r5;
    }

    @NonNull
    public String toString() {
        StringBuilder r5 = j0.w("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n", "    view = ");
        r5.append(this.view);
        r5.append("\n");
        String r10 = j0.j(r5.toString(), "    values:");
        Iterator<String> r11 = this.values.keySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        String r12 = r11.next();
        r10 = r10 + "    " + r12 + ": " + this.values.get(r12) + "\n";
        goto L4
    L6:
        return r10;
    }

    public TransitionValues(@NonNull View r5) {
        this.values = new HashMap();
        this.mTargetedTransitions = new ArrayList();
        this.view = r5;
    }
}
