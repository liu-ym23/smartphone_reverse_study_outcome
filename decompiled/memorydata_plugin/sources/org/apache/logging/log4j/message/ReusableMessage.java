package org.apache.logging.log4j.message;

import org.apache.logging.log4j.util.q;

/* JADX INFO: loaded from: classes6.dex */
public interface ReusableMessage extends Message, q {
    short getParameterCount();

    Message memento();

    Object[] swapParameters(Object[] r1);
}
