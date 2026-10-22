package bolts;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AggregateException extends Exception {
    private static final String DEFAULT_MESSAGE = "There were multiple errors.";
    private static final long serialVersionUID = 1;
    private List<Throwable> innerThrowables;

    public AggregateException(String r4, List<? extends Throwable> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
    L7:
        Throwable r0 = null;
    L8:
        super(r4, r0);
        this.innerThrowables = Collections.unmodifiableList(r6);
        return;
    L5:
        if (r6.size() <= 0) goto L7;
        r0 = (Throwable) ZeusTransformUtils.preCheckCast(r6.get(0), Throwable.class, "com.obric.memorydata.plugin");
        goto L8
    }

    public AggregateException(String r1, Throwable[] r2) {
        this(r1, Arrays.asList(r2));
    }

    public AggregateException(List<? extends Throwable> r3) {
        this(DEFAULT_MESSAGE, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
    }

    @Deprecated
    public Throwable[] getCauses() {
        List<Throwable> r2 = this.innerThrowables;
        return (Throwable[]) ZeusTransformUtils.preCheckCast(r2.toArray(new Throwable[r2.size()]), Throwable[].class, "com.obric.memorydata.plugin");
    }

    @Deprecated
    public List<Exception> getErrors() {
        ArrayList r0 = new ArrayList();
        List<Throwable> r4 = this.innerThrowables;
        if (r4 != null) goto L5;
        return r0;
    L5:
        Iterator<Throwable> r5 = r4.iterator();
    L7:
        if (r5.hasNext() == false) goto L12;
        Throwable r1 = (Throwable) ZeusTransformUtils.preCheckCast(r5.next(), Throwable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, Exception.class) == true) goto L10;
        r0.add(new Exception(r1));
        goto L7
    L10:
        r0.add((Exception) ZeusTransformUtils.preCheckCast(r1, Exception.class, "com.obric.memorydata.plugin"));
        goto L7
    L12:
        return r0;
    }

    public List<Throwable> getInnerThrowables() {
        return this.innerThrowables;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream r5) {
        super.printStackTrace(r5);
        Iterator<Throwable> r4 = this.innerThrowables.iterator();
        int r0 = -1;
    L4:
        if (r4.hasNext() == false) goto L6;
        Throwable r1 = (Throwable) ZeusTransformUtils.preCheckCast(r4.next(), Throwable.class, "com.obric.memorydata.plugin");
        r5.append("\n");
        r5.append("  Inner throwable #");
        r0 = r0 + 1;
        r5.append(Integer.toString(r0));
        r5.append(": ");
        r1.printStackTrace(r5);
        r5.append("\n");
        goto L4
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter r5) {
        super.printStackTrace(r5);
        Iterator<Throwable> r4 = this.innerThrowables.iterator();
        int r0 = -1;
    L4:
        if (r4.hasNext() == false) goto L6;
        Throwable r1 = (Throwable) ZeusTransformUtils.preCheckCast(r4.next(), Throwable.class, "com.obric.memorydata.plugin");
        r5.append("\n");
        r5.append("  Inner throwable #");
        r0 = r0 + 1;
        r5.append(Integer.toString(r0));
        r5.append(": ");
        r1.printStackTrace(r5);
        r5.append("\n");
        goto L4
    }
}
