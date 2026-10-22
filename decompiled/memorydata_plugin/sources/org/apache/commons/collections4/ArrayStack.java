package org.apache.commons.collections4;

import java.util.ArrayList;
import java.util.EmptyStackException;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class ArrayStack<E> extends ArrayList<E> {
    private static final long serialVersionUID = 2130079159931574599L;

    public ArrayStack() {
    }

    public ArrayStack(int r1) {
        super(r1);
    }

    public boolean empty() {
        return isEmpty();
    }

    public E peek() {
        int r0 = size();
        if (r0 <= 0) goto L7;
        return get(r0 - 1);
    L7:
        throw new EmptyStackException();
    }

    public E peek(int r2) {
        int r0 = (size() - r2) - 1;
        if (r0 < 0) goto L7;
        return get(r0);
    L7:
        throw new EmptyStackException();
    }

    public E pop() {
        int r0 = size();
        if (r0 <= 0) goto L7;
        return remove(r0 - 1);
    L7:
        throw new EmptyStackException();
    }

    public E push(E r1) {
        add(r1);
        return r1;
    }

    public int search(Object r4) {
        int r1 = 1;
        int r0 = size() - 1;
    L3:
        if (r0 < 0) goto L12;
        E r2 = get(r0);
        if (r4 != null) goto L7;
        if (r2 != null) goto L7;
    L10:
        return r1;
    L7:
        if (r4 == null) goto L11;
        if (r4.equals(r2) == true) goto L10;
    L11:
        r0 = r0 - 1;
        r1 = r1 + 1;
        goto L3
    L12:
        return -1;
    }
}
