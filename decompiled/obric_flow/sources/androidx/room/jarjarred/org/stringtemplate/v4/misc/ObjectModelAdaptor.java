package androidx.room.jarjarred.org.stringtemplate.v4.misc;

import androidx.room.jarjarred.org.stringtemplate.v4.Interpreter;
import androidx.room.jarjarred.org.stringtemplate.v4.ModelAdaptor;
import androidx.room.jarjarred.org.stringtemplate.v4.ST;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ObjectModelAdaptor implements ModelAdaptor {
    protected static final Member INVALID_MEMBER = null;
    protected static final Map<Class<?>, Map<String, Member>> membersCache = null;

    static {
        Field r5 = null;
        r5 = ObjectModelAdaptor.class.getDeclaredField("INVALID_MEMBER");     // Catch: Throwable -> L6
    L4:
        INVALID_MEMBER = r5;
        membersCache = new HashMap();
    }

    public ObjectModelAdaptor() {
    }

    public static Member findMember(Class<?> r10, String r11) {
        if (r10 == null) goto L38;
        if (r11 == null) goto L36;
        Map<Class<?>, Map<String, Member>> r5 = membersCache;
        monitor-enter(r5);
        Map<String, Member> r12 = r5.get(r10);     // Catch: Throwable -> L17
        if (r12 == null) goto L19;
        Member r13 = r12.get(r11);     // Catch: Throwable -> L17
        if (r13 != null) goto L12;
    L20:
        String r14 = Character.toUpperCase(r11.charAt(0)) + r11.substring(1, r11.length());     // Catch: Throwable -> L17
        Member r15 = tryGetMethod(r10, "get" + r14);     // Catch: Throwable -> L17
        if (r15 != null) goto L25;
        r15 = tryGetMethod(r10, "is" + r14);     // Catch: Throwable -> L17
        if (r15 != null) goto L25;
        r15 = tryGetMethod(r10, "has" + r14);     // Catch: Throwable -> L17
    L25:
        if (r15 != null) goto L27;
        r15 = tryGetField(r10, r11);     // Catch: Throwable -> L17
    L27:
        if (r15 == null) goto L29;
        Member r16 = r15;
    L30:
        r12.put(r11, r16);     // Catch: Throwable -> L17
        monitor-exit(r5);     // Catch: Throwable -> L17
        return r15;
    L29:
        r16 = INVALID_MEMBER;     // Catch: Throwable -> L17
        goto L30
    L12:
        if (r13 != INVALID_MEMBER) goto L15;
        r13 = null;
    L15:
        monitor-exit(r5);     // Catch: Throwable -> L17
        return r13;
    L19:
        r12 = new HashMap();     // Catch: Throwable -> L17
        r5.put(r10, r12);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    L36:
        throw new NullPointerException("memberName");
    L38:
        throw new NullPointerException("clazz");
    }

    public static Field tryGetField(Class<?> r5, String r10) {
        Field r11 = r5.getField(r10);     // Catch: Throwable -> L6
        if (r11 == null) goto L5;
        r11.setAccessible(true);     // Catch: Throwable -> L6
    L5:
        return r11;
    L6:
        return null;
    }

    public static Method tryGetMethod(Class<?> r5, String r10) {
        Method r11 = r5.getMethod(r10, null);     // Catch: Throwable -> L7
        if (r11 == null) goto L6;
        r11.setAccessible(true);     // Catch: Throwable -> L7
    L6:
        return r11;
    L7:
        return null;
    }

    @Override // androidx.room.jarjarred.org.stringtemplate.v4.ModelAdaptor
    public synchronized Object getProperty(Interpreter r5, ST r10, Object r11, Object r12, String r13) throws STNoSuchPropertyException {
        monitor-enter(this);
        if (r11 == null) goto L30;
        Class<?> r14 = r11.getClass();     // Catch: Throwable -> L9
        if (r12 != null) goto L11;
        Object r15 = throwNoSuchProperty(r14, r13, null);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r15;
    L11:
        Member r16 = findMember(r14, r13);     // Catch: Throwable -> L9
        if (r16 != null) goto L34;
    L26:
        Object r17 = throwNoSuchProperty(r14, r13, null);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r17;
    L34:
    L18:
        e = move-exception;
        throwNoSuchProperty(r14, r13, e);     // Catch: Throwable -> L9
        goto L26
    L14:
        if ((r16 instanceof Method) == false) goto L21;
        Object r18 = ((Method) r16).invoke(r11, null);     // Catch: Throwable -> L9 Exception -> L18
        monitor-exit(this);
        return r18;
    L21:
        if ((r16 instanceof Field) == false) goto L26;
        Object r19 = ((Field) r16).get(r11);     // Catch: Throwable -> L9 Exception -> L18
        monitor-exit(this);
        return r19;
    L30:
        throw new NullPointerException("o");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public Object throwNoSuchProperty(Class<?> r5, String r10, Exception r11) {
        throw new STNoSuchPropertyException(r11, null, r5.getName() + "." + r10);
    }
}
