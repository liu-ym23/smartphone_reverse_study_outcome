package androidx.transition;

import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    public TransitionValues(View r2) {
        this.values = new HashMap();
        this.mTargetedTransitions = new ArrayList();
        this.view = r2;
    }

    public boolean equals(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, TransitionValues.class) == true) goto L5;
        return false;
    L5:
        if (this.view == ((TransitionValues) ZeusTransformUtils.preCheckCast(r5, TransitionValues.class, "com.obric.memorydata.plugin")).view) goto L7;
        return false;
    L7:
        if (this.values.equals(((TransitionValues) ZeusTransformUtils.preCheckCast(r5, TransitionValues.class, "com.obric.memorydata.plugin")).values) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public int hashCode() {
        return (this.view.hashCode() * 31) + this.values.hashCode();
    }

    public String toString() {
        String r0 = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.view + "\n") + "    values:";
        Iterator<String> r2 = this.values.keySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
        r0 = r0 + "    " + r3 + ": " + this.values.get(r3) + "\n";
        goto L4
    L6:
        return r0;
    }
}
