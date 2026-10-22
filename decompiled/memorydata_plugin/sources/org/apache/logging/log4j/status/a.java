package org.apache.logging.log4j.status;

import java.io.Closeable;
import java.util.EventListener;
import org.apache.logging.log4j.Level;

/* JADX INFO: loaded from: classes6.dex */
public interface a extends Closeable, EventListener {
    Level a();

    void a(StatusData r1);
}
