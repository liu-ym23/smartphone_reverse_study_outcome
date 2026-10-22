package org.apache.poi.ss.formula;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class CollaboratingWorkbooksEnvironment {
    public static final CollaboratingWorkbooksEnvironment EMPTY = null;
    private final WorkbookEvaluator[] _evaluators;
    private final Map<String, WorkbookEvaluator> _evaluatorsByName;
    private boolean _unhooked;

    public static final class WorkbookNotFoundException extends Exception {
        private static final long serialVersionUID = 8787784539811167941L;

        WorkbookNotFoundException(String r1) {
            super(r1);
        }
    }

    static {
        EMPTY = new CollaboratingWorkbooksEnvironment();
    }

    private CollaboratingWorkbooksEnvironment() {
        this._evaluatorsByName = Collections.emptyMap();
        this._evaluators = new WorkbookEvaluator[0];
    }

    public WorkbookEvaluator getWorkbookEvaluator(String r6) {
        if (this._unhooked == true) goto L21;
        WorkbookEvaluator r0 = (WorkbookEvaluator) ZeusTransformUtils.preCheckCast(this._evaluatorsByName.get(r6), WorkbookEvaluator.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L19;
        StringBuilder r1 = new StringBuilder(256);
        r1.append("Could not resolve external workbook name '").append(r6).append("'.");
        if (this._evaluators.length < 1) goto L16;
        r1.append(" The following workbook names are valid: (");
        Iterator<String> r5 = this._evaluatorsByName.keySet().iterator();
        int r7 = 0;
    L10:
        if (r5.hasNext() == false) goto L15;
        int r2 = r7 + 1;
        if (r7 <= 0) goto L14;
        r1.append(", ");
    L14:
        r1.append('\'').append((String) ZeusTransformUtils.preCheckCast(r5.next(), String.class, "com.obric.memorydata.plugin")).append("'");
        r7 = r2;
        goto L10
    L15:
        r1.append(')');
    L18:
        throw new WorkbookNotFoundException(r1.toString());
    L16:
        r1.append(" Workbook environment has not been set up.");
        goto L18
    L19:
        return r0;
    L21:
        throw new IllegalStateException("This environment has been unhooked");
    }
}
