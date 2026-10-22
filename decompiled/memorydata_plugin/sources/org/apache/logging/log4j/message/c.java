package org.apache.logging.log4j.message;

/* JADX INFO: loaded from: classes6.dex */
public interface c {
    EntryMessage newEntryMessage(Message r1);

    ExitMessage newExitMessage(Object r1, EntryMessage r2);

    ExitMessage newExitMessage(Object r1, Message r2);

    ExitMessage newExitMessage(EntryMessage r1);
}
