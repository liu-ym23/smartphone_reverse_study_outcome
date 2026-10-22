package org.apache.logging.log4j.message;

import java.io.Serializable;

/* JADX INFO: loaded from: classes6.dex */
public interface Message extends Serializable {
    String getFormat();

    String getFormattedMessage();

    Object[] getParameters();

    Throwable getThrowable();
}
