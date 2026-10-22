package org.apache.xmlbeans.impl.values;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Map;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.common.PrefixResolver;
import org.apache.xmlbeans.xml.stream.StartElement;

/* JADX INFO: loaded from: classes7.dex */
public class NamespaceContext implements PrefixResolver {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static ThreadLocal tl_namespaceContextStack;
    private int _code;
    private Object _obj;

    /* JADX INFO: renamed from: org.apache.xmlbeans.impl.values.NamespaceContext$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class NamespaceContextStack {
        NamespaceContext current;
        ArrayList<NamespaceContext> stack;

        private NamespaceContextStack() {
            this.stack = new ArrayList();
        }

        /* synthetic */ NamespaceContextStack(AnonymousClass1 r1) {
            this();
        }

        final void pop() {
            ArrayList<NamespaceContext> r0 = this.stack;
            this.current = (NamespaceContext) ZeusTransformUtils.preCheckCast(r0.get(r0.size() - 1), NamespaceContext.class, "com.obric.memorydata.plugin");
            ArrayList<NamespaceContext> r3 = this.stack;
            r3.remove(r3.size() - 1);
        }

        final void push(NamespaceContext r3) {
            this.stack.add(this.current);
            this.current = r3;
        }
    }

    static {
        tl_namespaceContextStack = new ThreadLocal();
    }

    public NamespaceContext(XmlObject r3) {
        XmlObject r4 = (XmlObject) ZeusTransformUtils.wrapperContextForParams(r3, XmlObject.class, "com.obric.memorydata.plugin");
        this._code = 2;
        this._obj = r4;
    }

    public NamespaceContext(PrefixResolver r3) {
        PrefixResolver r4 = (PrefixResolver) ZeusTransformUtils.wrapperContextForParams(r3, PrefixResolver.class, "com.obric.memorydata.plugin");
        this._code = 5;
        this._obj = r4;
    }

    public NamespaceContext(TypeStore r3) {
        TypeStore r4 = (TypeStore) ZeusTransformUtils.wrapperContextForParams(r3, TypeStore.class, "com.obric.memorydata.plugin");
        this._code = 1;
        this._obj = r4;
    }

    public static PrefixResolver getCurrent() {
        return getNamespaceContextStack().current;
    }

    private static NamespaceContextStack getNamespaceContextStack() {
        NamespaceContextStack r0 = (NamespaceContextStack) ZeusTransformUtils.preCheckCast(tl_namespaceContextStack.get(), NamespaceContextStack.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        NamespaceContextStack r1 = new NamespaceContextStack(null);
        tl_namespaceContextStack.set(r1);
        return r1;
    L6:
        return r0;
    }

    public static void pop() {
        NamespaceContextStack r0 = getNamespaceContextStack();
        r0.pop();
        if (r0.stack.size() != 0) goto L6;
        tl_namespaceContextStack.set(null);
        return;
    }

    public static void push(NamespaceContext r1) {
        getNamespaceContextStack().push(r1);
    }

    @Override // org.apache.xmlbeans.impl.common.PrefixResolver
    public String getNamespaceForPrefix(String r4) {
        if (r4 != null) goto L4;
    L7:
        int r0 = this._code;
        if (r0 == 1) goto L53;
        if (r0 != 2) goto L12;
        Object r1 = this._obj;
        if (Proxy.isProxyClass(r1.getClass()) == false) goto L27;
        r1 = Proxy.getInvocationHandler(r1);
    L27:
        if (ZeusTransformUtils.instanceOf(r1, TypeStoreUser.class) == true) goto L29;
        XmlCursor r2 = ((XmlObject) ZeusTransformUtils.preCheckCast(this._obj, XmlObject.class, "com.obric.memorydata.plugin")).newCursor();
        if (r2 != null) goto L58;
        if (r2 == null) goto L51;
        r2.close();
    L51:
        return (String) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(this._obj, Map.class, "com.obric.memorydata.plugin")).get(r4), String.class, "com.obric.memorydata.plugin");
    L58:
    L39:
        th = move-exception;
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        if (r2 != null) goto L56;
    L47:
        throw th;
    L56:
        r2.close();     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        th.addSuppressed(th);
        goto L47
    L33:
        if (r2.currentTokenType() != XmlCursor.TokenType.ATTR) goto L35;
        r2.toParent();     // Catch: Throwable -> L39
    L35:
        String r3 = r2.namespaceForPrefix(r4);     // Catch: Throwable -> L39
        if (r2 == null) goto L38;
        r2.close();
    L38:
        return r3;
    L29:
        return ((TypeStoreUser) ZeusTransformUtils.preCheckCast(r1, TypeStoreUser.class, "com.obric.memorydata.plugin")).get_store().getNamespaceForPrefix(r4);
    L12:
        if (r0 == 3) goto L51;
        if (r0 == 4) goto L22;
        if (r0 == 5) goto L20;
        return null;
    L20:
        return ((PrefixResolver) ZeusTransformUtils.preCheckCast(this._obj, PrefixResolver.class, "com.obric.memorydata.plugin")).getNamespaceForPrefix(r4);
    L22:
        return ((StartElement) ZeusTransformUtils.preCheckCast(this._obj, StartElement.class, "com.obric.memorydata.plugin")).getNamespaceUri(r4);
    L53:
        return ((TypeStore) ZeusTransformUtils.preCheckCast(this._obj, TypeStore.class, "com.obric.memorydata.plugin")).getNamespaceForPrefix(r4);
    L4:
        if (r4.equals("xml") == false) goto L7;
        return "http://www.w3.org/XML/1998/namespace";
    }
}
