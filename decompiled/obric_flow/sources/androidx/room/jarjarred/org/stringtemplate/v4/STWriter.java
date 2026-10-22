package androidx.room.jarjarred.org.stringtemplate.v4;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface STWriter {
    public static final int NO_WRAP = -1;

    int index();

    void popAnchorPoint();

    String popIndentation();

    void pushAnchorPoint();

    void pushIndentation(String r5);

    void setLineWidth(int r5);

    int write(String r5) throws IOException;

    int write(String r5, String r10) throws IOException;

    int writeSeparator(String r5) throws IOException;

    int writeWrap(String r5) throws IOException;
}
